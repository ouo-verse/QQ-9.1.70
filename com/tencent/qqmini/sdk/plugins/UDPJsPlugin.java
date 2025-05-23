package com.tencent.qqmini.sdk.plugins;

import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.utils.NativeBuffer;
import com.tencent.qqmini.sdk.core.utils.thread.NioSelectorThread;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.utils.DebugUtil;
import com.tencent.qqmini.sdk.utils.DomainUtil;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

@JsPlugin
/* loaded from: classes23.dex */
public class UDPJsPlugin extends BaseJsPlugin {
    private static final String TAG = "UDPPlugin";
    private final SparseArray<UDPTask> mTaskRegistry = new SparseArray<>();
    private volatile Set<String> mUdpIpWhiteSet;
    private static final AtomicInteger UDP_TASK_ID_COUNTER = new AtomicInteger();
    private static final Pattern IPV6_ADDRESS_REGEX = Pattern.compile("\\[?(([0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}|([0-9a-fA-F]{1,4}:){1,7}:|([0-9a-fA-F]{1,4}:){1,6}:[0-9a-fA-F]{1,4}|([0-9a-fA-F]{1,4}:){1,5}(:[0-9a-fA-F]{1,4}){1,2}|([0-9a-fA-F]{1,4}:){1,4}(:[0-9a-fA-F]{1,4}){1,3}|([0-9a-fA-F]{1,4}:){1,3}(:[0-9a-fA-F]{1,4}){1,4}|([0-9a-fA-F]{1,4}:){1,2}(:[0-9a-fA-F]{1,4}){1,5}|[0-9a-fA-F]{1,4}:((:[0-9a-fA-F]{1,4}){1,6})|:((:[0-9a-fA-F]{1,4}){1,7}|:)|fe80:(:[0-9a-fA-F]{0,4}){0,4}%[0-9a-zA-Z]+|::(ffff(:0{1,4})?:)?((25[0-5]|(2[0-4]|1?[0-9])?[0-9])\\.){3}(25[0-5]|(2[0-4]|1?[0-9])?[0-9])|([0-9a-fA-F]{1,4}:){1,4}:((25[0-5]|(2[0-4]|1?[0-9])?[0-9])\\.){3}(25[0-5]|(2[0-4]|1?[0-9])?[0-9]))]?");
    private static final Pattern IPV4_ADDRESS_REGEX = Pattern.compile("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}.\\d{1,3}");

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public static class UDPTask implements NioSelectorThread.NioHandler {
        private final DatagramChannel channel;
        private final WeakReference<UDPJsPlugin> jsPluginWeakReference;
        private final IJsService jsService;
        private final ByteBuffer receiveBuffer;
        private final byte[] receiveByteArray;
        final int taskId;

        UDPTask(UDPJsPlugin uDPJsPlugin, IJsService iJsService) throws IOException {
            this.jsPluginWeakReference = new WeakReference<>(uDPJsPlugin);
            this.jsService = iJsService;
            try {
                this.taskId = UDPJsPlugin.UDP_TASK_ID_COUNTER.getAndIncrement();
                DatagramChannel open = DatagramChannel.open();
                this.channel = open;
                open.configureBlocking(false);
                byte[] bArr = new byte[8192];
                this.receiveByteArray = bArr;
                this.receiveBuffer = ByteBuffer.wrap(bArr);
            } catch (IOException e16) {
                onError(e16.getMessage());
                throw e16;
            }
        }

        public int bind() throws IOException {
            try {
                this.channel.socket().bind(null);
                NioSelectorThread.getInstance().registerChannel(this.channel, 1, this);
                onListening();
                return this.channel.socket().getLocalPort();
            } catch (IOException e16) {
                onError(e16.getMessage());
                throw e16;
            }
        }

        public void close() throws IOException {
            try {
                this.channel.close();
                onClose();
            } catch (IOException e16) {
                onError(e16.getMessage());
                throw e16;
            }
        }

        @Override // com.tencent.qqmini.sdk.core.utils.thread.NioSelectorThread.NioHandler
        public boolean handle(SelectionKey selectionKey) {
            try {
                if (selectionKey.isReadable()) {
                    this.receiveBuffer.clear();
                    SocketAddress receive = this.channel.receive(this.receiveBuffer);
                    this.receiveBuffer.flip();
                    onReceive(this.receiveByteArray, this.receiveBuffer.limit(), receive);
                    return true;
                }
                return true;
            } catch (Exception e16) {
                onError(e16.getMessage());
                return true;
            }
        }

        void onClose() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("udpTaskId", this.taskId);
                jSONObject.put("event", "close");
                UDPJsPlugin uDPJsPlugin = this.jsPluginWeakReference.get();
                if (uDPJsPlugin != null) {
                    uDPJsPlugin.sendSubscribeEvent("onUDPTaskEventCallback", jSONObject.toString());
                }
            } catch (JSONException unused) {
            }
        }

        void onError(String str) {
            UDPJsPlugin uDPJsPlugin = this.jsPluginWeakReference.get();
            if (uDPJsPlugin != null) {
                uDPJsPlugin.callbackError(str, this.taskId);
            }
        }

        void onListening() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("udpTaskId", this.taskId);
                jSONObject.put("event", "listening");
                UDPJsPlugin uDPJsPlugin = this.jsPluginWeakReference.get();
                if (uDPJsPlugin != null) {
                    uDPJsPlugin.sendSubscribeEvent("onUDPTaskEventCallback", jSONObject.toString());
                }
            } catch (JSONException unused) {
            }
        }

        void onReceive(byte[] bArr, int i3, SocketAddress socketAddress) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("udpTaskId", this.taskId);
                jSONObject.put("event", "message");
                NativeBuffer.packNativeBuffer(this.jsService, bArr, 0, i3, NativeBuffer.TYPE_BUFFER_NATIVE, "message", jSONObject);
                JSONObject jSONObject2 = new JSONObject();
                if (socketAddress instanceof InetSocketAddress) {
                    InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddress;
                    InetAddress address = inetSocketAddress.getAddress();
                    if (address instanceof Inet4Address) {
                        jSONObject2.put(IjkMediaPlayer.OnNativeInvokeListener.ARG_FAMILIY, "IPv4");
                    } else {
                        jSONObject2.put(IjkMediaPlayer.OnNativeInvokeListener.ARG_FAMILIY, "IPv6");
                    }
                    jSONObject2.put("address", address.getHostAddress());
                    jSONObject2.put("port", inetSocketAddress.getPort());
                }
                jSONObject2.put("size", i3);
                jSONObject.put("remoteInfo", jSONObject2);
                UDPJsPlugin uDPJsPlugin = this.jsPluginWeakReference.get();
                if (uDPJsPlugin != null) {
                    uDPJsPlugin.sendSubscribeEvent("onUDPTaskEventCallback", jSONObject.toString());
                }
            } catch (JSONException unused) {
            }
        }

        public void send(byte[] bArr, int i3, int i16, SocketAddress socketAddress) throws IOException {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.position(i3);
            wrap.limit(i3 + i16);
            this.channel.send(wrap, socketAddress);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackError(String str, int i3) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("udpTaskId", i3);
            jSONObject.put("event", "error");
            jSONObject.put("errMsg", str);
            sendSubscribeEvent("onUDPTaskEventCallback", jSONObject.toString());
        } catch (JSONException unused) {
        }
    }

    private boolean getEnableDebug(String str) {
        return DebugUtil.getDebugEnabled(str);
    }

    @Nullable
    private InetAddress getInetAddress(@NonNull String str) {
        try {
            return InetAddress.getByName(str);
        } catch (SecurityException e16) {
            QMLog.d(TAG, "getInetAddress address:" + str, e16);
            return null;
        } catch (UnknownHostException e17) {
            QMLog.d(TAG, "getInetAddress address:" + str, e17);
            return null;
        }
    }

    @Nullable
    private InetAddress getInetAddressByDomain(@NonNull String str, int i3, boolean z16) {
        if (DomainUtil.isDomainValid(getMiniAppInfo(), z16, str + ":" + i3, 5)) {
            return getInetAddress(str);
        }
        return null;
    }

    @Nullable
    private InetAddress getInetAddressByIp(@NonNull String str, boolean z16) {
        InetAddress inetAddress = getInetAddress(str);
        if (inetAddress == null || inetAddress.isLoopbackAddress() || inetAddress.isAnyLocalAddress() || inetAddress.isMulticastAddress()) {
            return null;
        }
        if (inetAddress.isSiteLocalAddress()) {
            return inetAddress;
        }
        if (!z16 && !isUdpIpValid(str)) {
            return null;
        }
        return inetAddress;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performSend(IJsService iJsService, JSONObject jSONObject, UDPTask uDPTask) throws JSONException, IOException {
        String str;
        int optInt;
        int i3;
        int optInt2 = jSONObject.optInt("port", -1);
        byte[] bArr = null;
        if (!jSONObject.isNull("message")) {
            str = jSONObject.optString("message", null);
        } else {
            str = null;
        }
        if (str != null) {
            bArr = str.getBytes("UTF-8");
            i3 = bArr.length;
            optInt = 0;
        } else {
            NativeBuffer unpackNativeBuffer = NativeBuffer.unpackNativeBuffer(iJsService, jSONObject, "message");
            optInt = jSONObject.optInt("offset");
            int optInt3 = jSONObject.optInt("length", -1);
            if (unpackNativeBuffer != null) {
                bArr = unpackNativeBuffer.buf;
                if (optInt3 == -1) {
                    i3 = bArr.length;
                }
            }
            i3 = optInt3;
        }
        if (optInt2 < 0) {
            callbackError("invalid port", uDPTask.taskId);
            return;
        }
        String optString = jSONObject.optString("address");
        InetAddress validAddress = validAddress(optString, optInt2, jSONObject.optBoolean("__skipDomainCheck__", false));
        if (validAddress == null) {
            String str2 = "invalid address :[" + optString + "]";
            QMLog.d(TAG, str2);
            callbackError(str2, uDPTask.taskId);
            return;
        }
        if (bArr == null) {
            callbackError("undefined message", uDPTask.taskId);
            return;
        }
        if (optInt >= 0 && optInt < i3) {
            if (i3 > bArr.length) {
                callbackError("invalid length", uDPTask.taskId);
                return;
            } else {
                uDPTask.send(bArr, optInt, i3, new InetSocketAddress(validAddress, optInt2));
                return;
            }
        }
        callbackError("invalid offset", uDPTask.taskId);
    }

    @JsEvent({"createUDPTask"})
    public String createUDPTask(RequestEvent requestEvent) {
        JSONObject jSONObject = new JSONObject();
        try {
            UDPTask uDPTask = new UDPTask(this, requestEvent.jsService);
            this.mTaskRegistry.put(uDPTask.taskId, uDPTask);
            jSONObject.put("udpTaskId", uDPTask.taskId);
            return ApiUtil.wrapCallbackOk(requestEvent.event, jSONObject).toString();
        } catch (Exception e16) {
            return ApiUtil.wrapCallbackFail(requestEvent.event, jSONObject, e16.getMessage()).toString();
        }
    }

    @VisibleForTesting
    public boolean isUdpIpValid(String str) {
        MiniAppInfo miniAppInfo = getMiniAppInfo();
        if (miniAppInfo == null) {
            return false;
        }
        if (miniAppInfo.skipDomainCheck == 1) {
            QMLog.d("[mini] http.udp", "udp ip\u68c0\u67e5 skip: " + str);
            return true;
        }
        if (miniAppInfo.verType != 3 && getEnableDebug(miniAppInfo.appId)) {
            QMLog.d("[mini] http.udp", "debug opened and not online version, skip:" + str);
            return true;
        }
        if (this.mUdpIpWhiteSet == null) {
            synchronized (this) {
                if (this.mUdpIpWhiteSet == null) {
                    this.mUdpIpWhiteSet = new HashSet(miniAppInfo.udpIpList);
                }
            }
        }
        return this.mUdpIpWhiteSet.contains(str);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onDestroy() {
        this.mUdpIpWhiteSet = null;
        super.onDestroy();
    }

    @JsEvent({"operateUDPTask"})
    public String operateUDPTask(final RequestEvent requestEvent) {
        JSONObject jSONObject = new JSONObject();
        try {
            final JSONObject jSONObject2 = new JSONObject(requestEvent.jsonParams);
            String optString = jSONObject2.optString(QCircleDaTongConstant.ElementParamValue.OPERATION);
            int optInt = jSONObject2.optInt("udpTaskId");
            final UDPTask uDPTask = this.mTaskRegistry.get(optInt);
            if (uDPTask != null) {
                if ("bind".equals(optString)) {
                    jSONObject.put("port", uDPTask.bind());
                    return ApiUtil.wrapCallbackOk(requestEvent.event, jSONObject).toString();
                }
                if ("close".equals(optString)) {
                    uDPTask.close();
                    this.mTaskRegistry.remove(optInt);
                    return ApiUtil.wrapCallbackOk(requestEvent.event, jSONObject).toString();
                }
                if ("send".equals(optString)) {
                    ThreadManager.executeOnNetworkIOThreadPool(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.UDPJsPlugin.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                UDPJsPlugin.this.performSend(requestEvent.jsService, jSONObject2, uDPTask);
                            } catch (Exception e16) {
                                requestEvent.fail("performSend exception," + e16.getMessage());
                            }
                            requestEvent.ok();
                        }
                    });
                    return "";
                }
                return "";
            }
            return ApiUtil.wrapCallbackFail(requestEvent.event, jSONObject, "task already closed").toString();
        } catch (Exception e16) {
            return ApiUtil.wrapCallbackFail(requestEvent.event, jSONObject, e16.getMessage()).toString();
        }
    }

    @Nullable
    @VisibleForTesting
    public InetAddress validAddress(String str, int i3, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!IPV4_ADDRESS_REGEX.matcher(str).matches() && !IPV6_ADDRESS_REGEX.matcher(str).matches()) {
            return getInetAddressByDomain(str, i3, z16);
        }
        return getInetAddressByIp(str, z16);
    }
}
