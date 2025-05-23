package com.tencent.mobileqq.transfile.chatpic;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.image.CustomError;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ac;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.q;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.TransferResult;
import com.tencent.mobileqq.util.j;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes19.dex */
public class PicDownloadExplicitError extends CustomError {
    static IPatchRedirector $redirector_ = null;
    public static final String C2C_PIC_REQUEST_EXPIRED_DESC = "T_208";
    private static final int ERROR_EXPIRED = 1;
    private static final int ERROR_IO = 3;
    private static final int ERROR_PARAM_CHECK = 2;
    public static final String GROUP_PIC_EXPIRED_DESC = "H_404_-6101";
    public static final String GROUP_PIC_REQUEST_EXPIRED_DESC = "T_203";
    public static final String GROUP_PIC_REQUEST_QUERY_INDEX_TIMEOUT_DESC = "T_206";
    private static final Map<Integer, ExplicitError> M_MAP;
    public static final String TAG = "PicDownloadExplicitError";
    private int mErrCode;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes19.dex */
    public static class ExplicitError {
        static IPatchRedirector $redirector_;
        int mDrawable;
        int mTip;

        public ExplicitError(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.mDrawable = i3;
                this.mTip = i16;
            }
        }

        int getDrawableResId() {
            return this.mDrawable;
        }

        int getTipResId() {
            return this.mTip;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56552);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        HashMap hashMap = new HashMap();
        M_MAP = hashMap;
        hashMap.put(1, new ExplicitError(R.drawable.hkz, R.string.iia));
        hashMap.put(2, new ExplicitError(-1, R.string.iib));
        hashMap.put(3, new ExplicitError(-1, R.string.iic));
    }

    PicDownloadExplicitError(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
        } else {
            this.mErrCode = i3;
        }
    }

    private static PicDownloadExplicitError getError(q qVar) {
        return null;
    }

    private String getFailedTip() {
        int tipResId;
        ExplicitError explicitError = M_MAP.get(Integer.valueOf(this.mErrCode));
        if (explicitError != null && (tipResId = explicitError.getTipResId()) > 0) {
            return BaseApplication.getContext().getResources().getString(tipResId);
        }
        return BaseApplication.getContext().getResources().getString(R.string.iia);
    }

    public static PicDownloadExplicitError getPicError(Object obj) {
        if (obj instanceof TransferResult) {
            return getError((TransferResult) obj);
        }
        if (obj instanceof q) {
            return getError((q) obj);
        }
        return null;
    }

    public static boolean isImageExpires(int i3, String str) {
        if (i3 != -9527) {
            return false;
        }
        if (!GROUP_PIC_EXPIRED_DESC.equals(str) && !GROUP_PIC_REQUEST_EXPIRED_DESC.equals(str) && !GROUP_PIC_REQUEST_QUERY_INDEX_TIMEOUT_DESC.equals(str) && !C2C_PIC_REQUEST_EXPIRED_DESC.equals(str)) {
            return false;
        }
        return true;
    }

    public Drawable getDrawableFromCache(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Drawable) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, i3);
        }
        if (str == null) {
            str = String.valueOf(i3);
        }
        ImageCacheHelper imageCacheHelper = ImageCacheHelper.f98636a;
        Bitmap f16 = imageCacheHelper.f(str);
        if (f16 == null) {
            f16 = j.g(BaseApplication.getContext().getResources(), i3);
            imageCacheHelper.i(str, f16, Business.Conversation);
        }
        if (f16 != null) {
            return new BitmapDrawable(BaseApplication.getContext().getResources(), f16);
        }
        return new ColorDrawable();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.image.CustomError
    public Drawable getFailedDrawable() {
        int drawableResId;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Drawable) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        ExplicitError explicitError = M_MAP.get(Integer.valueOf(this.mErrCode));
        if (explicitError != null && (drawableResId = explicitError.getDrawableResId()) > 0) {
            return getDrawableFromCache(null, drawableResId);
        }
        return getDrawableFromCache("static://CommonFailedDrawable", R.drawable.aio_image_fail_round);
    }

    private static PicDownloadExplicitError getError(TransferResult transferResult) {
        PicDownloadExplicitError picDownloadExplicitError;
        TransferRequest transferRequest = transferResult.mOrigReq;
        if (transferRequest != null) {
            long j3 = transferResult.mErrCode;
            String str = transferResult.mErrDesc;
            int i3 = transferRequest.mUinType;
            MessageRecord messageRecord = transferRequest.mRec;
            if ((messageRecord instanceof MessageForPic) && ac.c((MessageForPic) messageRecord)) {
                return null;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getError,errCode:" + j3 + " errDesc:" + str + " uinType:" + i3);
            }
            if (i3 == 1 || i3 == 3000) {
                if (j3 == -9527) {
                    if (GROUP_PIC_EXPIRED_DESC.equals(str) || GROUP_PIC_REQUEST_EXPIRED_DESC.equals(str) || GROUP_PIC_REQUEST_QUERY_INDEX_TIMEOUT_DESC.equals(str)) {
                        picDownloadExplicitError = new PicDownloadExplicitError(1);
                        return picDownloadExplicitError;
                    }
                } else {
                    if (transferResult.mErrCode == 9302) {
                        return new PicDownloadExplicitError(2);
                    }
                    if (j3 == 9039 || j3 == 9040) {
                        return new PicDownloadExplicitError(3);
                    }
                }
            } else if (j3 == -9527) {
                if (C2C_PIC_REQUEST_EXPIRED_DESC.equals(str)) {
                    picDownloadExplicitError = new PicDownloadExplicitError(1);
                    return picDownloadExplicitError;
                }
            } else {
                if (transferResult.mErrCode == 9302) {
                    return new PicDownloadExplicitError(2);
                }
                if (j3 == 9039 || j3 == 9040) {
                    return new PicDownloadExplicitError(3);
                }
            }
        }
        return null;
    }

    public static String getFailedTip(URLDrawable uRLDrawable) {
        if (uRLDrawable.getStateError() instanceof PicDownloadExplicitError) {
            return ((PicDownloadExplicitError) uRLDrawable.getStateError()).getFailedTip();
        }
        return null;
    }
}
