package com.tencent.weiyun.transmission.upload.processor;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.weiyun.transmission.ErrorCode;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal;
import com.tencent.weiyun.transmission.upload.UploadFile;
import com.tencent.weiyun.transmission.upload.UploadJobContext;
import com.tencent.weiyun.transmission.upload.UploadType;
import com.tencent.weiyun.transmission.utils.handler.ReleaseLooperHandler;

/* compiled from: P */
/* loaded from: classes27.dex */
public class UrlFetcher implements Handler.Callback {
    static IPatchRedirector $redirector_ = null;
    private static final int MSG_FETCH = 21;
    private static final String TAG = "UploadUrlFetcher";
    private final UrlFetcherCallback mCallback;
    private final ReleaseLooperHandler mHandler;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface UrlFetcherCallback {
        void onFetchError(long j3, int i3, String str);

        void onFetchSuccess(long j3, UploadFile uploadFile);
    }

    public UrlFetcher(UrlFetcherCallback urlFetcherCallback, ReleaseLooperHandler releaseLooperHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) urlFetcherCallback, (Object) releaseLooperHandler);
            return;
        }
        this.mCallback = urlFetcherCallback;
        this.mHandler = releaseLooperHandler;
        releaseLooperHandler.addCallback(this);
    }

    private void performFetchUrl(UploadJobContext uploadJobContext, int i3) {
        UploadType uploadType;
        if (uploadJobContext == null) {
            return;
        }
        long dbId = uploadJobContext.dbId();
        if (uploadJobContext.isCanceled()) {
            return;
        }
        uploadJobContext.statisticsTimes().onFetchUrlStart();
        WeiyunTransmissionGlobal.HostInterface hostInterface = WeiyunTransmissionGlobal.getInstance().getHostInterface();
        UploadFile m290clone = uploadJobContext.file().m290clone();
        if (!TextUtils.isEmpty(uploadJobContext.file().compressedPath)) {
            uploadType = UploadType.EXIST_COVER;
        } else {
            uploadType = UploadType.values()[i3];
        }
        hostInterface.fetchUploadServerInfo(m290clone, uploadType, new WeiyunTransmissionGlobal.UploadServerInfoCallback(dbId) { // from class: com.tencent.weiyun.transmission.upload.processor.UrlFetcher.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ long val$dbId;

            {
                this.val$dbId = dbId;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, UrlFetcher.this, Long.valueOf(dbId));
                }
            }

            @Override // com.tencent.weiyun.transmission.WeiyunTransmissionGlobal.UploadServerInfoCallback
            public void onResult(UploadFile uploadFile, boolean z16, int i16, String str) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, uploadFile, Boolean.valueOf(z16), Integer.valueOf(i16), str);
                    return;
                }
                if (uploadFile == null) {
                    return;
                }
                if (z16) {
                    if (uploadFile.serverInfo == null) {
                        UrlFetcher.this.mCallback.onFetchError(this.val$dbId, ErrorCode.CMD_INVALID_RSP, "");
                        return;
                    } else {
                        UrlFetcher.this.mCallback.onFetchSuccess(this.val$dbId, uploadFile);
                        return;
                    }
                }
                UrlFetcher.this.mCallback.onFetchError(this.val$dbId, i16, str);
            }
        });
    }

    public void cancelAll() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.mHandler.removeMessages(21);
        }
    }

    public void fetchUrl(UploadJobContext uploadJobContext, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) uploadJobContext, i3);
        } else {
            if (uploadJobContext == null) {
                return;
            }
            this.mHandler.sendMessage(Message.obtain(null, 21, i3, 0, uploadJobContext));
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) message)).booleanValue();
        }
        if (message.what == 21) {
            performFetchUrl((UploadJobContext) message.obj, message.arg1);
            return true;
        }
        return false;
    }
}
