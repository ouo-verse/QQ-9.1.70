package com.tencent.mobileqq.richmediabrowser.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.comment.config.ImmersiveConfProcessor;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend;
import com.tencent.mobileqq.richmediabrowser.api.IShortVideoDepend;
import com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData;
import com.tencent.mobileqq.richmediabrowser.view.AIOFileVideoView;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.BrowserBasePresenter;
import com.tencent.util.LiuHaiUtils;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c extends com.tencent.mobileqq.richmediabrowser.presenter.a {
    public AIOFileVideoView C;
    public MqqHandler D = new a();

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a extends MqqHandler {
        a() {
        }

        @Override // mqq.os.MqqHandler
        public void handleMessage(Message message) {
            AIOFileVideoView aIOFileVideoView = c.this.C;
            if (aIOFileVideoView != null && aIOFileVideoView.f282077h != null) {
                if (message.what == ((IShortVideoDepend) QRoute.api(IShortVideoDepend.class)).getVideoSaveFailCode()) {
                    QQToast.makeText(c.this.C.f282077h, R.string.f221896c2, 0).show();
                } else if (message.what == ((IShortVideoDepend) QRoute.api(IShortVideoDepend.class)).getVideoSaveSuccessCode()) {
                    BaseImageUtil.savePhotoToSysAlbum(c.this.C.f282077h, (String) message.obj);
                    QQToast.makeText(c.this.C.f282077h, 2, R.string.f221846bx, 0).show();
                }
            }
        }
    }

    public c() {
        QQVideoPlaySDKManager.initQQImp();
    }

    @Override // com.tencent.mobileqq.richmediabrowser.presenter.a
    public void C(long j3, int i3, int i16, int i17, long j16, boolean z16) {
        RichMediaBrowserInfo selectedItem;
        RichMediaBaseData richMediaBaseData;
        RichMediaBrowserInfo q16 = q(j3);
        if (q16 != null && (richMediaBaseData = q16.baseData) != null && richMediaBaseData.getType() == 103) {
            AIOFileVideoData aIOFileVideoData = (AIOFileVideoData) q16.baseData;
            aIOFileVideoData.W = (i17 / 10000.0f) * ((float) aIOFileVideoData.size);
            q16.baseData = aIOFileVideoData;
            BrowserBasePresenter browserBasePresenter = this.f281861h;
            if (browserBasePresenter != null) {
                browserBasePresenter.updateItem(q16);
            }
        }
        BrowserBasePresenter browserBasePresenter2 = this.f281861h;
        if (browserBasePresenter2 != null && (selectedItem = browserBasePresenter2.getSelectedItem()) != null) {
            RichMediaBaseData richMediaBaseData2 = selectedItem.baseData;
            if ((richMediaBaseData2 instanceof AIOFileVideoData) && ((AIOFileVideoData) richMediaBaseData2).msgId == j3) {
                this.C.updateUI();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x009a  */
    @Override // com.tencent.mobileqq.richmediabrowser.presenter.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void D(long j3, int i3, int i16, int i17, String str, boolean z16) {
        boolean z17;
        boolean z18;
        BrowserBasePresenter browserBasePresenter;
        RichMediaBrowserInfo selectedItem;
        RichMediaBaseData richMediaBaseData;
        BrowserBasePresenter browserBasePresenter2;
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoPresenterXOXO", 2, "notifyImageResult result = " + i17 + ", type = " + i16 + ", resultStr = " + str);
        RichMediaBrowserInfo q16 = q(j3);
        if (i16 == 269484034 && q16 != null && (richMediaBaseData = q16.baseData) != null && richMediaBaseData.getType() == 103) {
            AIOFileVideoData aIOFileVideoData = (AIOFileVideoData) q16.baseData;
            BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoPresenterXOXO", 4, "-----------> recv download finish:" + j3);
            if (i17 == 1) {
                if (!TextUtils.isEmpty(str)) {
                    aIOFileVideoData.f281839f = str;
                }
                aIOFileVideoData.I = true;
                if (aIOFileVideoData.istroop == 10014) {
                    z17 = true;
                    aIOFileVideoData.L = false;
                    z18 = aIOFileVideoData.N;
                    if (!z18) {
                        aIOFileVideoData.status = 4;
                    } else {
                        aIOFileVideoData.status = 3;
                    }
                    q16.baseData = aIOFileVideoData;
                    browserBasePresenter2 = this.f281861h;
                    if (browserBasePresenter2 != null) {
                        browserBasePresenter2.updateItem(q16);
                    }
                }
            } else if (i17 == 2) {
                aIOFileVideoData.I = false;
            }
            z17 = false;
            aIOFileVideoData.L = false;
            z18 = aIOFileVideoData.N;
            if (!z18) {
            }
            q16.baseData = aIOFileVideoData;
            browserBasePresenter2 = this.f281861h;
            if (browserBasePresenter2 != null) {
            }
        } else {
            z17 = false;
            z18 = false;
        }
        if (i16 == 269484034 && (browserBasePresenter = this.f281861h) != null && (selectedItem = browserBasePresenter.getSelectedItem()) != null) {
            RichMediaBaseData richMediaBaseData2 = selectedItem.baseData;
            if ((richMediaBaseData2 instanceof AIOBrowserBaseData) && ((AIOBrowserBaseData) richMediaBaseData2).msgId == j3) {
                if (z18) {
                    if (i17 == 1) {
                        Context context = this.C.f282077h;
                        QQToast.makeText(context, 2, context.getString(R.string.f221846bx), 0).show();
                    } else if (i17 == 2) {
                        Context context2 = this.C.f282077h;
                        QQToast.makeText(context2, 1, context2.getString(R.string.f221876c0), 0).show();
                    }
                }
                this.C.updateUI();
                if (z17) {
                    this.C.y0();
                }
                BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoPresenterXOXO", 4, "-----------> recv download finish set playing!");
            }
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.presenter.a
    public void E(long j3, int i3, int i16, String str, String[] strArr, String str2, MessageRecord messageRecord, int i17, Bundle bundle) {
        this.C.x0(j3, i3, i16, str, strArr, str2, messageRecord, i17, bundle);
    }

    @Override // com.tencent.mobileqq.richmediabrowser.presenter.a
    public void G() {
        boolean z16;
        AIOBrowserPresenter aIOBrowserPresenter = this.f281859e;
        if (aIOBrowserPresenter != null && aIOBrowserPresenter.f281849d != null && aIOBrowserPresenter.m() != null) {
            AIOFileVideoData V = V();
            if (V != null) {
                z16 = FileUtils.fileExistsAndNotEmpty(V.f281839f);
            } else {
                z16 = false;
            }
            if (z16) {
                if (LiuHaiUtils.isLiuHaiUseValid()) {
                    this.f281859e.m().s(((int) Utils.R(LiuHaiUtils.sNotchHeight, this.C.f282077h.getResources())) + 46);
                } else {
                    this.f281859e.m().s(46);
                }
                this.f281859e.m().i();
                this.f281859e.m().p();
                this.f281859e.f281849d.c();
            }
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.presenter.a
    public void H(int i3) {
        try {
            this.f281861h.mActiveDrawable.remove(Integer.valueOf(i3));
        } catch (Exception e16) {
            BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoPresenterXOXO", 4, "onRevokeMsg exception = " + e16.getMessage());
        }
    }

    public void S(AIOFileVideoData aIOFileVideoData) {
        d04.a c16 = this.f281859e.getParamsBuilder().c();
        if (!(c16 instanceof com.tencent.mobileqq.richmediabrowser.f)) {
            QLog.e("AIOFileVideoPresenterXOXO", 1, "cancelDownload failed : provider null");
        } else {
            ((com.tencent.mobileqq.richmediabrowser.f) c16).C(aIOFileVideoData.msgId, 12, aIOFileVideoData.U);
        }
    }

    public void T(long j3) {
        RichMediaBaseData richMediaBaseData;
        RichMediaBrowserInfo q16 = q(j3);
        if (q16 != null && this.f281861h != null && (richMediaBaseData = q16.baseData) != null && richMediaBaseData.getType() == 103) {
            ((AIOFileVideoData) q16.baseData).L = false;
            this.f281861h.updateItem(q16);
        }
    }

    public void U(long j3) {
        RichMediaBaseData richMediaBaseData;
        RichMediaBrowserInfo q16 = q(j3);
        if (q16 != null && this.f281861h != null && (richMediaBaseData = q16.baseData) != null && richMediaBaseData.getType() == 103) {
            ((AIOFileVideoData) q16.baseData).M = false;
            this.f281861h.updateItem(q16);
        }
    }

    public AIOFileVideoData V() {
        RichMediaBrowserInfo selectedItem;
        RichMediaBaseData richMediaBaseData;
        BrowserBasePresenter browserBasePresenter = this.f281861h;
        if (browserBasePresenter != null && (selectedItem = browserBasePresenter.getSelectedItem()) != null && (richMediaBaseData = selectedItem.baseData) != null && richMediaBaseData.getType() == 103) {
            return (AIOFileVideoData) selectedItem.baseData;
        }
        return null;
    }

    public Intent W(AIOFileVideoData aIOFileVideoData, Activity activity) {
        if (aIOFileVideoData != null && (this.f281859e.getParamsBuilder().c() instanceof com.tencent.mobileqq.richmediabrowser.f)) {
            com.tencent.mobileqq.richmediabrowser.f fVar = (com.tencent.mobileqq.richmediabrowser.f) this.f281859e.getParamsBuilder().c();
            if (fVar.n()) {
                boolean z16 = false;
                Intent u16 = fVar.u(aIOFileVideoData.msgId, aIOFileVideoData.subId, 0);
                if (u16 != null) {
                    if (aIOFileVideoData.istroop == 1) {
                        z16 = true;
                    }
                    ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).getForwardToFriendIntent(activity, u16, z16);
                    u16.putExtra("big_brother_source_key", "biz_src_jc_file");
                    return u16;
                }
                return null;
            }
            return null;
        }
        return null;
    }

    public void X(AIOFileVideoData aIOFileVideoData) {
        d04.a c16 = this.f281859e.getParamsBuilder().c();
        if (!(c16 instanceof com.tencent.mobileqq.richmediabrowser.f)) {
            QLog.e("AIOFileVideoPresenterXOXO", 1, "handleUnDownloadVideo failed : provider null");
        } else {
            ((com.tencent.mobileqq.richmediabrowser.f) c16).C(aIOFileVideoData.msgId, 11, aIOFileVideoData.U);
        }
    }

    public void Y(AIOFileVideoData aIOFileVideoData) {
        d04.a c16 = this.f281859e.getParamsBuilder().c();
        if (!(c16 instanceof com.tencent.mobileqq.richmediabrowser.f)) {
            QLog.e("AIOFileVideoPresenterXOXO", 1, "handleVideoStopPlay failed : provider null");
        } else {
            ((com.tencent.mobileqq.richmediabrowser.f) c16).C(aIOFileVideoData.msgId, 14, aIOFileVideoData.U);
        }
    }

    public void Z(AIOFileVideoData aIOFileVideoData) {
        AIOBrowserPresenter aIOBrowserPresenter = this.f281859e;
        if (aIOBrowserPresenter != null && aIOFileVideoData != null) {
            d04.a c16 = aIOBrowserPresenter.getParamsBuilder().c();
            if (!(c16 instanceof com.tencent.mobileqq.richmediabrowser.f)) {
                QLog.e("AIOFileVideoPresenterXOXO", 1, "handleVideoStopPlay failed : provider null");
            } else {
                ((com.tencent.mobileqq.richmediabrowser.f) c16).C(aIOFileVideoData.msgId, 10, aIOFileVideoData.U);
            }
        }
    }

    public boolean a0(int i3) {
        RichMediaBrowserInfo item;
        RichMediaBaseData richMediaBaseData;
        BrowserBasePresenter browserBasePresenter = this.f281861h;
        if (browserBasePresenter != null && (item = browserBasePresenter.getItem(i3)) != null && (richMediaBaseData = item.baseData) != null && richMediaBaseData.getType() == 103) {
            return ((AIOFileVideoData) item.baseData).L;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.richmediabrowser.presenter.a, c04.b
    public void e(c04.c cVar) {
        super.e(cVar);
        if (cVar instanceof AIOFileVideoView) {
            this.C = (AIOFileVideoView) cVar;
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.presenter.a, com.tencent.richmediabrowser.presenter.BasePresenter, e04.a
    public void onDestroy() {
        super.onDestroy();
        AIOFileVideoView aIOFileVideoView = this.C;
        if (aIOFileVideoView != null) {
            aIOFileVideoView.t();
        }
    }

    @Override // com.tencent.richmediabrowser.presenter.BasePresenter, e04.a
    public void onResume() {
        super.onResume();
        AIOFileVideoView aIOFileVideoView = this.C;
        if (aIOFileVideoView != null) {
            aIOFileVideoView.A0();
        }
    }

    @Override // com.tencent.richmediabrowser.presenter.BasePresenter, e04.a
    public void onStop() {
        super.onStop();
        AIOFileVideoView aIOFileVideoView = this.C;
        if (aIOFileVideoView != null) {
            aIOFileVideoView.B0();
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.presenter.a
    public long s() {
        AIOFileVideoView aIOFileVideoView = this.C;
        if (aIOFileVideoView != null) {
            return aIOFileVideoView.m0();
        }
        return 0L;
    }

    @Override // com.tencent.mobileqq.richmediabrowser.presenter.a
    public boolean t() {
        RichMediaBrowserInfo selectedItem;
        BrowserBasePresenter browserBasePresenter = this.f281861h;
        if (browserBasePresenter == null || (selectedItem = browserBasePresenter.getSelectedItem()) == null) {
            return false;
        }
        RichMediaBaseData richMediaBaseData = selectedItem.baseData;
        if (!(richMediaBaseData instanceof AIOBrowserBaseData)) {
            return false;
        }
        AIOBrowserBaseData aIOBrowserBaseData = (AIOBrowserBaseData) richMediaBaseData;
        if (this.f281862i.get(Long.valueOf(aIOBrowserBaseData.shmsgseq)) == null || this.f281862i.get(Long.valueOf(aIOBrowserBaseData.shmsgseq)).size() <= 0) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.richmediabrowser.presenter.a
    public boolean x() {
        if (QLog.isColorLevel()) {
            QLog.d("AIOFileVideoPresenterXOXO", 2, "isImmersionOpen, ImmersiveConfProcessor.isVideoEnable() = " + ImmersiveConfProcessor.b());
        }
        return ImmersiveConfProcessor.b();
    }
}
