package com.tencent.upload.network.base;

import android.util.SparseArray;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.network.route.DomainNameParser;
import com.tencent.upload.utils.Const;
import com.tencent.upload.utils.StringUtils;
import com.tencent.upload.utils.UploadLog;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes27.dex */
public class NetworkEngine implements INetworkEngine, IMsgCallback {
    static IPatchRedirector $redirector_;
    private static final AtomicInteger PARAM_SEQUENCE;
    private final String TAG;
    protected final IConnectionCallback mCallback;
    protected String mConnectedIp;
    private long mDomainParserTime;
    private final String mId;
    protected final byte[] mLock;
    private ConnectionImpl mNativeConnection;
    protected SparseArray<Object> mParamMap;
    private long mStartConnectTime;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static final class ConnectParam {
        static IPatchRedirector $redirector_;

        /* renamed from: ip, reason: collision with root package name */
        public final String f383919ip;
        public final int port;
        public final String proxyIp;
        public final int proxyPort;
        public final int timeout;

        public ConnectParam(String str, int i3, String str2, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), str2, Integer.valueOf(i16), Integer.valueOf(i17));
                return;
            }
            this.f383919ip = str;
            this.port = i3;
            this.proxyIp = str2;
            this.proxyPort = i16;
            this.timeout = i17;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class OperationMsg {
        static IPatchRedirector $redirector_ = null;
        public static final int CONNECT = 0;
        public static final int DISCONNECT = 1;
        public static final int ERROR = 3;
        public static final int SEND = 2;
        public static final int TIMEOUT = 4;

        public OperationMsg() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static final class SendParam {
        static IPatchRedirector $redirector_;
        public final byte[] buf;
        public final int recvTimeout;
        public final int sendSequence;
        public final int sendTimeout;

        public SendParam(byte[] bArr, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                return;
            }
            this.buf = bArr;
            this.sendSequence = i3;
            this.sendTimeout = i16;
            this.recvTimeout = i17;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11304);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            PARAM_SEQUENCE = new AtomicInteger(0);
        }
    }

    public NetworkEngine(IConnectionCallback iConnectionCallback, String str, Const.ConnectType connectType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, iConnectionCallback, str, connectType);
            return;
        }
        this.mParamMap = new SparseArray<>();
        this.mLock = new byte[0];
        this.mDomainParserTime = -1L;
        this.mStartConnectTime = -1L;
        this.mId = str;
        String str2 = "NetworkEngine-" + str;
        this.TAG = str2;
        int doNotFragment = UploadConfiguration.getDoNotFragment();
        this.mCallback = iConnectionCallback;
        if (!ConnectionImpl.isLibraryPrepared()) {
            UploadLog.e(str2, "!isLibraryPrepared");
            return;
        }
        ConnectionImpl connectionImpl = new ConnectionImpl(doNotFragment, str, connectType);
        this.mNativeConnection = connectionImpl;
        connectionImpl.setCallback(iConnectionCallback);
        this.mNativeConnection.setMsgCallback(this);
    }

    private static final int nextParamSequence() {
        return PARAM_SEQUENCE.incrementAndGet();
    }

    @Override // com.tencent.upload.network.base.INetworkEngine
    public boolean connectAsync(String str, int i3, String str2, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, str, Integer.valueOf(i3), str2, Integer.valueOf(i16), Integer.valueOf(i17))).booleanValue();
        }
        if (this.mNativeConnection == null) {
            return false;
        }
        ConnectParam connectParam = new ConnectParam(str, i3, str2, i16, i17);
        int nextParamSequence = nextParamSequence();
        synchronized (this.mLock) {
            this.mParamMap.put(nextParamSequence, connectParam);
        }
        return this.mNativeConnection.PostMessage(0, null, nextParamSequence);
    }

    public final String getConnectedIp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.mConnectedIp;
    }

    public long getDomainParserTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Long) iPatchRedirector.redirect((short) 11, (Object) this)).longValue();
        }
        return this.mDomainParserTime;
    }

    public long getStartConnectTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Long) iPatchRedirector.redirect((short) 12, (Object) this)).longValue();
        }
        return this.mStartConnectTime;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        IConnectionCallback iConnectionCallback = this.mCallback;
        if (iConnectionCallback != null) {
            return iConnectionCallback.hashCode();
        }
        return super.hashCode();
    }

    @Override // com.tencent.upload.network.base.INetworkEngine
    public boolean isRunning() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        ConnectionImpl connectionImpl = this.mNativeConnection;
        if (connectionImpl == null) {
            return false;
        }
        return connectionImpl.isRunning();
    }

    @Override // com.tencent.upload.network.base.IMsgCallback
    public void onMsgCallback(IMsgCallback iMsgCallback, int i3, Object obj, int i16) {
        Object obj2;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, iMsgCallback, Integer.valueOf(i3), obj, Integer.valueOf(i16));
            return;
        }
        synchronized (this.mLock) {
            obj2 = this.mParamMap.get(i16);
            this.mParamMap.remove(i16);
        }
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    ConnectionImpl connectionImpl = this.mNativeConnection;
                    if (connectionImpl != null && (obj2 instanceof SendParam)) {
                        SendParam sendParam = (SendParam) obj2;
                        connectionImpl.SendData(sendParam.buf, sendParam.sendSequence, sendParam.sendTimeout, sendParam.recvTimeout);
                        return;
                    }
                    String str2 = this.TAG;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(" OperationMsg.SEND, obj instanceof ConnectParam:");
                    sb5.append(obj2 instanceof SendParam);
                    sb5.append("mNativeConnection != null:");
                    if (this.mNativeConnection == null) {
                        z16 = false;
                    }
                    sb5.append(z16);
                    UploadLog.w(str2, sb5.toString());
                    return;
                }
                return;
            }
            if (this.mNativeConnection != null) {
                UploadLog.w(this.TAG, " OperationMsg.DISCONNECT");
                this.mNativeConnection.disconnect();
                return;
            } else {
                UploadLog.w(this.TAG, " OperationMsg.DISCONNECT, mNativeConnection == null");
                return;
            }
        }
        if (this.mNativeConnection != null && (obj2 instanceof ConnectParam)) {
            ConnectParam connectParam = (ConnectParam) obj2;
            String str3 = connectParam.f383919ip;
            int maxSegmentSize = UploadConfiguration.getMaxSegmentSize(str3);
            if (!StringUtils.isIpv4String(connectParam.f383919ip) && !StringUtils.isIpv6String(connectParam.f383919ip)) {
                DomainNameParser.ParseResult parseResult = new DomainNameParser.ParseResult();
                long currentTimeMillis = System.currentTimeMillis();
                DomainNameParser.parse(connectParam.f383919ip, parseResult);
                this.mDomainParserTime = System.currentTimeMillis() - currentTimeMillis;
                String str4 = parseResult.parsedIp;
                parseResult.parsedIp = null;
                if (str4 == null) {
                    IConnectionCallback iConnectionCallback = this.mCallback;
                    if (iConnectionCallback == null) {
                        return;
                    }
                    iConnectionCallback.onConnect(iConnectionCallback, false, Const.UploadRetCode.DNS_PARSER_ERROR.getCode(), str4);
                    return;
                }
                str = str4;
            } else {
                str = str3;
            }
            UploadLog.w(this.TAG, " OperationMsg.CONNECT, parsedIp:" + str + ", port:" + connectParam.port + ", proxyIp:" + connectParam.proxyIp + ", proxyPort:" + connectParam.proxyPort + " timeout:" + connectParam.timeout);
            this.mConnectedIp = str;
            this.mStartConnectTime = System.currentTimeMillis();
            this.mNativeConnection.connect(str, connectParam.port, connectParam.proxyIp, connectParam.proxyPort, connectParam.timeout, maxSegmentSize);
            return;
        }
        String str5 = this.TAG;
        StringBuilder sb6 = new StringBuilder();
        sb6.append(" OperationMsg.CONNECT, obj instanceof ConnectParam:");
        sb6.append(obj2 instanceof ConnectParam);
        sb6.append(" mNativeConnection != null:");
        if (this.mNativeConnection == null) {
            z16 = false;
        }
        sb6.append(z16);
        UploadLog.w(str5, sb6.toString());
    }

    public void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        UploadLog.w(this.TAG, "release... sid:" + this.mId);
        ConnectionImpl connectionImpl = this.mNativeConnection;
        if (connectionImpl == null) {
            UploadLog.w(this.TAG, "release... sid:" + this.mId + " mNativeConnection == null");
            return;
        }
        connectionImpl.native_finalize();
        this.mNativeConnection = null;
    }

    @Override // com.tencent.upload.network.base.INetworkEngine
    public boolean sendAsync(byte[] bArr, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17))).booleanValue();
        }
        if (this.mNativeConnection == null) {
            return false;
        }
        SendParam sendParam = new SendParam(bArr, i3, i16, i17);
        int nextParamSequence = nextParamSequence();
        synchronized (this.mLock) {
            this.mParamMap.put(nextParamSequence, sendParam);
        }
        return this.mNativeConnection.PostMessage(2, null, nextParamSequence);
    }

    @Override // com.tencent.upload.network.base.INetworkEngine
    public boolean start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        ConnectionImpl connectionImpl = this.mNativeConnection;
        if (connectionImpl == null) {
            return false;
        }
        if (connectionImpl.isRunning()) {
            UploadLog.w(this.TAG, "start, is running, return false");
            return false;
        }
        return this.mNativeConnection.start();
    }

    @Override // com.tencent.upload.network.base.INetworkEngine
    public boolean stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        UploadLog.w(this.TAG, "stop...");
        ConnectionImpl connectionImpl = this.mNativeConnection;
        if (connectionImpl == null) {
            UploadLog.w(this.TAG, "stop... mNativeConnection == null");
            return false;
        }
        boolean stop = connectionImpl.stop();
        this.mNativeConnection.disconnect();
        synchronized (this.mLock) {
            this.mParamMap.clear();
        }
        return stop;
    }

    @Override // com.tencent.upload.network.base.INetworkEngine
    public void wakeUp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        ConnectionImpl connectionImpl = this.mNativeConnection;
        if (connectionImpl == null) {
            return;
        }
        connectionImpl.wakeUp();
    }
}
