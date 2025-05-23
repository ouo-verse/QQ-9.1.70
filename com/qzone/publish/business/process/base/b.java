package com.qzone.publish.business.process.base;

import android.text.TextUtils;
import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.publish.business.process.base.a;
import com.qzone.publish.business.process.f;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class b extends a<ShuoshuoVideoInfo> {
    public b(ShuoshuoVideoInfo shuoshuoVideoInfo, a.InterfaceC0438a<ShuoshuoVideoInfo> interfaceC0438a) {
        super(shuoshuoVideoInfo, interfaceC0438a);
    }

    @Override // com.qzone.publish.business.process.base.a
    public void f() {
        try {
            ((ShuoshuoVideoInfo) this.f51050f).mHasCompressed = true;
            super.f();
        } catch (Exception e16) {
            xe.b.f447841a.d(e16);
        }
    }

    @Override // com.qzone.publish.business.process.base.a
    public void o() {
        c fVar;
        if (!TextUtils.equals(((ShuoshuoVideoInfo) this.f51050f).getPublishParamsType(), "INTIMATE_MOOD") && !TextUtils.equals(((ShuoshuoVideoInfo) this.f51050f).getPublishParamsType(), "INTIMATE_ALBUM")) {
            if (TextUtils.equals(((ShuoshuoVideoInfo) this.f51050f).getPublishParamsType(), "MOOD_QQVIDEO_SINGLE_VIDEO")) {
                fVar = new com.qzone.publish.business.process.a();
                QZLog.d(this.f51048d, 1, "startWidthParam use qqvideo videoParam:" + fVar);
            } else {
                T t16 = this.f51050f;
                fVar = new f(((ShuoshuoVideoInfo) t16).mIsUploadOrigin, true, TextUtils.equals(((ShuoshuoVideoInfo) t16).getPublishParamsType(), "MOOD_NORMAL_VIDEO"));
                QZLog.d(this.f51048d, 1, "startWidthParam use old videoParam:" + fVar);
            }
        } else {
            fVar = new f(((ShuoshuoVideoInfo) this.f51050f).mIsUploadOrigin, true, false);
            QZLog.d(this.f51048d, 1, "startWidthParam use intimate videoParam:" + fVar);
        }
        try {
            q(fVar);
        } catch (Exception e16) {
            xe.b.f447841a.d(e16);
        }
    }

    protected abstract void q(c cVar);

    @Override // com.qzone.publish.business.process.base.a
    public String toString() {
        return this.f51048d + "_" + ((ShuoshuoVideoInfo) this.f51049e).mVideoPath;
    }
}
