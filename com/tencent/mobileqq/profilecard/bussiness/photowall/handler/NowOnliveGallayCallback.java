package com.tencent.mobileqq.profilecard.bussiness.photowall.handler;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.ilive.photo.NowLiveGallary$RspBody;

/* compiled from: P */
/* loaded from: classes16.dex */
public abstract class NowOnliveGallayCallback extends ProtoUtils.TroopProtocolObserver {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "NowOnliveGallayCallback";

    public NowOnliveGallayCallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public abstract void onGetNowOnliveGallay(int i3, List<NowLiveGallary$RspBody.PhotoInfo> list);

    @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
    public void onResult(int i3, byte[] bArr, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), bArr, bundle);
            return;
        }
        if (bArr == null) {
            onGetNowOnliveGallay(-1, null);
            return;
        }
        try {
            NowLiveGallary$RspBody nowLiveGallary$RspBody = new NowLiveGallary$RspBody();
            nowLiveGallary$RspBody.mergeFrom(bArr);
            onGetNowOnliveGallay(nowLiveGallary$RspBody.errCode.get(), nowLiveGallary$RspBody.photo_info_list.get());
        } catch (InvalidProtocolBufferMicroException e16) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getNowOnliveGallary exception, e:" + e16.getStackTrace());
            }
        }
    }
}
