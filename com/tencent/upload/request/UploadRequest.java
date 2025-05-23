package com.tencent.upload.request;

import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.upload.network.session.IUploadSession;
import com.tencent.upload.utils.JceEncoder;
import com.tencent.upload.utils.PDUtil;
import com.tencent.upload.utils.UploadLog;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class UploadRequest implements IActionRequest {
    static IPatchRedirector $redirector_ = null;
    private static final AtomicInteger REQUEST_SEQUENCE;
    private static final String TAG = "UploadRequest";
    private IUploadSession.RequestListener mListener;
    protected final int mRequestId;
    private Object mTag;
    private int mTaskId;
    private long startTime;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11917);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            REQUEST_SEQUENCE = new AtomicInteger(0);
        }
    }

    public UploadRequest() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.mRequestId = REQUEST_SEQUENCE.incrementAndGet();
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    protected abstract JceStruct createJceRequest() throws IOException;

    @Override // com.tencent.upload.request.IActionRequest
    public byte[] encode() throws IOException {
        byte[] encode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (byte[]) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        try {
            JceStruct createJceRequest = createJceRequest();
            if (createJceRequest == null) {
                UploadLog.e(TAG, "createJceRequest return null");
                return null;
            }
            try {
                encode = PDUtil.encode(getCmdId(), this.mRequestId, JceEncoder.encode(createJceRequest));
            } catch (OutOfMemoryError unused) {
                UploadLog.e(TAG, "encode request OOM. gc, then retry");
                System.gc();
                encode = PDUtil.encode(getCmdId(), this.mRequestId, JceEncoder.encode(createJceRequest));
            }
            return encode;
        } catch (FileNotFoundException e16) {
            UploadLog.e(TAG, "encode exception. reqId=" + getRequestId(), e16);
            return null;
        } catch (IOException e17) {
            UploadLog.e(TAG, "encode exception. reqId=" + getRequestId(), e17);
            throw e17;
        } catch (Throwable th5) {
            UploadLog.e(TAG, "encode exception. reqId=" + getRequestId(), th5);
            return null;
        }
    }

    @Override // com.tencent.upload.request.IActionRequest
    public long endRecord() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Long) iPatchRedirector.redirect((short) 15, (Object) this)).longValue();
        }
        return System.currentTimeMillis() - this.startTime;
    }

    @Override // com.tencent.upload.request.IActionRequest
    public int getCmdId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return 1;
    }

    @Override // com.tencent.upload.request.IActionRequest
    public IUploadSession.RequestListener getListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (IUploadSession.RequestListener) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.mListener;
    }

    @Override // com.tencent.upload.request.IActionRequest
    public int getRequestId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.mRequestId;
    }

    @Override // com.tencent.upload.request.IActionRequest
    public Object getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.mTag;
    }

    @Override // com.tencent.upload.request.IActionRequest
    public int getTaskId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.mTaskId;
    }

    @Override // com.tencent.upload.request.IActionRequest
    public boolean needTimeout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.upload.request.IActionRequest
    public void setListener(IUploadSession.RequestListener requestListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) requestListener);
        } else {
            this.mListener = requestListener;
        }
    }

    @Override // com.tencent.upload.request.IActionRequest
    public void setTag(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, obj);
        } else {
            this.mTag = obj;
        }
    }

    @Override // com.tencent.upload.request.IActionRequest
    public void setTaskId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            this.mTaskId = i3;
        }
    }

    @Override // com.tencent.upload.request.IActionRequest
    public void startRecord() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            this.startTime = System.currentTimeMillis();
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "taskId=" + getTaskId() + " reqId=" + getRequestId() + " cmd=" + getCmdId();
    }

    public UploadRequest(int i3) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.mTaskId = i3;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
    }
}
