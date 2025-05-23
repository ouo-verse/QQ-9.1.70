package com.tencent.mobileqq.transfile;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes19.dex */
public class HttpNetReq extends NetReq {
    static IPatchRedirector $redirector_ = null;
    public static final int HTTP_GET = 0;
    public static final int HTTP_POST = 1;
    public IFlowDecoder decoder;
    public DnsParseCallback mDnsParseCallback;
    public boolean mHaveIpConnect;
    public String mHostForHttpsVerify;
    public int mHttpMethod;
    public boolean mIsHostIP;
    public boolean mIsHttps;
    public boolean mIsPreStructPic;
    public boolean mIsSync;
    public boolean mNeedIpConnect;
    public boolean mNeedNotReferer;
    public boolean mNeedRedirectCallback;
    public String mReqUrl;
    public TimeoutParam mTimeoutParam;
    public boolean mUseCmwapConnectionTypeFromDpc;
    public String[] mWhiteListContentType;
    public ResponseURLCallback onResponseURL;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface DecoderState {
        public static final int STATE_END = 2;
        public static final int STATE_INIT = 0;
        public static final int STATE_RUNNING = 1;
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface DnsParseCallback {
        void end();

        void start();
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface IFlowDecoder {
        byte[] decode(byte[] bArr) throws Exception;

        boolean isFinish();

        void reset();
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface ResponseURLCallback {
        void onResponseURL(@Nullable URL url);
    }

    public HttpNetReq() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mHttpMethod = 0;
        this.mNeedIpConnect = false;
        this.mHaveIpConnect = false;
        this.mNeedRedirectCallback = false;
        this.mUseCmwapConnectionTypeFromDpc = false;
        this.mNeedNotReferer = false;
    }
}
