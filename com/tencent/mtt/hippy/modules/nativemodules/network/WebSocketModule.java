package com.tencent.mtt.hippy.modules.nativemodules.network;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.d.d;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.javascriptmodules.EventDispatcher;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.upload.report.UploadQualityReportBuilder;
import java.lang.ref.WeakReference;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
@HippyNativeModule(name = "websocket")
/* loaded from: classes20.dex */
public class WebSocketModule extends HippyNativeModuleBase {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicInteger f337523a = new AtomicInteger(0);

    /* renamed from: b, reason: collision with root package name */
    private final SparseArray<d> f337524b;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    private static class a implements d.a {

        /* renamed from: a, reason: collision with root package name */
        private final int f337525a;

        /* renamed from: b, reason: collision with root package name */
        private final WeakReference<HippyEngineContext> f337526b;

        /* renamed from: c, reason: collision with root package name */
        private final WebSocketModule f337527c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f337528d = false;

        public a(int i3, HippyEngineContext hippyEngineContext, WebSocketModule webSocketModule) {
            this.f337525a = i3;
            this.f337526b = new WeakReference<>(hippyEngineContext);
            this.f337527c = webSocketModule;
        }

        @Override // com.tencent.mtt.hippy.d.d.a
        public void a(Exception exc) {
            HippyMap hippyMap = new HippyMap();
            hippyMap.pushString("reason", exc.getMessage());
            a("onError", hippyMap);
        }

        @Override // com.tencent.mtt.hippy.d.d.a
        public void b() {
            a("onOpen", null);
        }

        private void a(String str, HippyMap hippyMap) {
            if (this.f337528d) {
                return;
            }
            HippyMap hippyMap2 = new HippyMap();
            hippyMap2.pushInt("id", this.f337525a);
            hippyMap2.pushString("type", str);
            hippyMap2.pushObject("data", hippyMap);
            HippyEngineContext hippyEngineContext = this.f337526b.get();
            if (hippyEngineContext != null) {
                ((EventDispatcher) hippyEngineContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveNativeEvent("hippyWebsocketEvents", hippyMap2);
            }
        }

        @Override // com.tencent.mtt.hippy.d.d.a
        public void b(int i3, String str) {
            HippyMap hippyMap = new HippyMap();
            hippyMap.pushInt("code", i3);
            hippyMap.pushString("reason", str);
            a("onClose", hippyMap);
            this.f337527c.a(this.f337525a);
            this.f337528d = true;
        }

        @Override // com.tencent.mtt.hippy.d.d.a
        public void a(byte[] bArr) {
        }

        @Override // com.tencent.mtt.hippy.d.d.a
        public void b(String str) {
            HippyMap hippyMap = new HippyMap();
            hippyMap.pushString("data", str);
            hippyMap.pushString("type", "text");
            a("onMessage", hippyMap);
        }
    }

    public WebSocketModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
        this.f337524b = new SparseArray<>();
    }

    private List<com.tencent.mtt.hippy.d.a> a(HippyMap hippyMap) {
        com.tencent.mtt.hippy.d.a aVar;
        if (hippyMap == null) {
            return null;
        }
        Set<String> keySet = hippyMap.keySet();
        ArrayList arrayList = new ArrayList();
        for (String str : keySet) {
            Object obj = hippyMap.get(str);
            if (obj instanceof Number) {
                aVar = new com.tencent.mtt.hippy.d.a(str, obj + "");
            } else if (obj instanceof Boolean) {
                aVar = new com.tencent.mtt.hippy.d.a(str, obj + "");
            } else if (obj instanceof String) {
                aVar = new com.tencent.mtt.hippy.d.a(str, obj + "");
            } else {
                LogUtils.e("WebSocketModule", "Unsupported Request Header List Type");
            }
            arrayList.add(aVar);
        }
        return arrayList;
    }

    @HippyMethod(name = "close")
    public void close(HippyMap hippyMap) {
        String str;
        int i3;
        String str2;
        if (hippyMap == null) {
            str = "close: ERROR: request is null";
        } else if (!hippyMap.containsKey("id")) {
            str = "close: ERROR: no socket id specified";
        } else {
            d dVar = this.f337524b.get(hippyMap.getInt("id"), null);
            if (dVar != null && dVar.c()) {
                if (hippyMap.containsKey("code")) {
                    i3 = hippyMap.getInt("code");
                } else {
                    i3 = 0;
                }
                String str3 = "";
                if (!hippyMap.containsKey("reason")) {
                    str2 = "";
                } else {
                    str2 = hippyMap.getString("reason");
                }
                if (str2 != null) {
                    str3 = str2;
                }
                dVar.a(i3, str3);
                return;
            }
            str = "send: ERROR: specified socket not found, or not connected yet";
        }
        LogUtils.d("WebSocketModule", str);
    }

    @HippyMethod(name = UploadQualityReportBuilder.STATE_CONNECT)
    public void connect(HippyMap hippyMap, Promise promise) {
        String str;
        HippyMap hippyMap2 = new HippyMap();
        if (hippyMap == null) {
            hippyMap2.pushInt("code", -1);
            str = "invalid connect param";
        } else {
            String string = hippyMap.getString("url");
            if (TextUtils.isEmpty(string)) {
                hippyMap2.pushInt("code", -1);
                str = "no valid url for websocket";
            } else {
                HippyMap map = hippyMap.getMap("headers");
                int addAndGet = f337523a.addAndGet(1);
                d dVar = new d(URI.create(string), new a(addAndGet, this.mContext, this), a(map));
                this.f337524b.put(addAndGet, dVar);
                dVar.a();
                hippyMap2.pushInt("code", 0);
                hippyMap2.pushString("reason", "");
                hippyMap2.pushInt("id", addAndGet);
                promise.resolve(hippyMap2);
            }
        }
        hippyMap2.pushString("reason", str);
        promise.resolve(hippyMap2);
    }

    @Override // com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase
    public void destroy() {
        int size = this.f337524b.size();
        if (size == 0) {
            return;
        }
        for (int i3 = 0; i3 < size; i3++) {
            d dVar = this.f337524b.get(this.f337524b.keyAt(i3));
            if (dVar != null && dVar.c()) {
                dVar.b();
            }
        }
        this.f337524b.clear();
    }

    @HippyMethod(name = "send")
    public void send(HippyMap hippyMap) {
        String str;
        if (hippyMap == null) {
            str = "send: ERROR: request is null";
        } else if (!hippyMap.containsKey("id")) {
            str = "send: ERROR: no socket id specified";
        } else {
            d dVar = this.f337524b.get(hippyMap.getInt("id"), null);
            if (dVar != null && dVar.c()) {
                String string = hippyMap.getString("data");
                if (string == null) {
                    str = "send: ERROR: no data specified to be sent";
                } else {
                    try {
                        dVar.a(string);
                        return;
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                        LogUtils.d("WebSocketModule", "send: ERROR: error occured in sending [" + th5.getMessage() + "]");
                        return;
                    }
                }
            } else {
                str = "send: ERROR: specified socket not found, or not connected yet";
            }
        }
        LogUtils.d("WebSocketModule", str);
    }

    protected void a(int i3) {
        this.f337524b.remove(i3);
    }
}
