package com.tencent.mobileqq.richmediabrowser.presenter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.comment.config.ImmersiveConfProcessor;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend;
import com.tencent.mobileqq.richmediabrowser.api.IShortVideoDepend;
import com.tencent.mobileqq.richmediabrowser.model.AIOVideoData;
import com.tencent.mobileqq.richmediabrowser.utils.g;
import com.tencent.mobileqq.richmediabrowser.view.AIOBrowserScene;
import com.tencent.mobileqq.richmediabrowser.view.AIOVideoView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.BrowserBasePresenter;
import com.tencent.richmediabrowser.view.EmptyDrawable;
import com.tencent.util.LiuHaiUtils;
import java.io.File;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes18.dex */
public class e extends com.tencent.mobileqq.richmediabrowser.presenter.a implements INetInfoHandler, f {
    public AIOVideoView C;
    public ConcurrentHashMap<Integer, URLDrawable> D = new ConcurrentHashMap<>();
    public MqqHandler E = new a();

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a extends MqqHandler {
        a() {
        }

        @Override // mqq.os.MqqHandler
        public void handleMessage(Message message) {
            AIOVideoView aIOVideoView = e.this.C;
            if (aIOVideoView != null && aIOVideoView.f282077h != null) {
                if (message.what == ((IShortVideoDepend) QRoute.api(IShortVideoDepend.class)).getVideoSaveFailCode()) {
                    QQToast.makeText(e.this.C.f282077h, R.string.f221896c2, 0).show();
                } else if (message.what == ((IShortVideoDepend) QRoute.api(IShortVideoDepend.class)).getVideoSaveSuccessCode()) {
                    BaseImageUtil.savePhotoToSysAlbum(e.this.C.f282077h, (String) message.obj);
                    QQToast.makeText(e.this.C.f282077h, 2, R.string.f221846bx, 0).show();
                }
            }
        }
    }

    public e() {
        QQVideoPlaySDKManager.initQQImp();
    }

    public static Drawable getCoverDrawable(String str, int i3, int i16) {
        EmptyDrawable emptyDrawable = new EmptyDrawable(Color.rgb(214, 214, 214), i3, i16);
        if (!TextUtils.isEmpty(str)) {
            try {
                URLDrawable drawable = URLDrawable.getDrawable(str, emptyDrawable, emptyDrawable);
                if (drawable.getStatus() != 1) {
                    drawable.downloadImediatly();
                }
                return drawable;
            } catch (Exception e16) {
                BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoPresenter", 4, "getCoverDrawable():  getDrawable Exception, coverUrl=" + str + "exception = " + e16.getMessage());
            }
        }
        return emptyDrawable;
    }

    @Override // com.tencent.mobileqq.richmediabrowser.presenter.a
    public void C(long j3, int i3, int i16, int i17, long j16, boolean z16) {
        RichMediaBrowserInfo selectedItem;
        RichMediaBrowserInfo q16 = q(j3);
        if (q16 != null && q16.baseData.getType() == 101) {
            RichMediaBaseData richMediaBaseData = q16.baseData;
            if (richMediaBaseData instanceof AIOVideoData) {
                AIOVideoData aIOVideoData = (AIOVideoData) richMediaBaseData;
                if (i16 == 256) {
                    aIOVideoData.status = 7;
                }
                aIOVideoData.progress = i17;
                q16.baseData = aIOVideoData;
                BrowserBasePresenter browserBasePresenter = this.f281861h;
                if (browserBasePresenter != null) {
                    browserBasePresenter.updateItem(q16);
                }
            }
        }
        BrowserBasePresenter browserBasePresenter2 = this.f281861h;
        if (browserBasePresenter2 != null && this.C != null && (selectedItem = browserBasePresenter2.getSelectedItem()) != null) {
            RichMediaBaseData richMediaBaseData2 = selectedItem.baseData;
            if ((richMediaBaseData2 instanceof AIOVideoData) && ((AIOVideoData) richMediaBaseData2).msgId == j3) {
                this.C.updateUI();
            }
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.presenter.a
    public void D(long j3, int i3, int i16, int i17, String str, boolean z16) {
        tm2.a aVar;
        RichMediaBrowserInfo selectedItem;
        BrowserBasePresenter browserBasePresenter;
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoPresenter", 2, "notifyImageResult result = " + i17 + ", type = " + i16 + ", resultStr = " + str);
        RichMediaBrowserInfo q16 = q(j3);
        if (q16 != null && q16.baseData.getType() == 101) {
            RichMediaBaseData richMediaBaseData = q16.baseData;
            if (richMediaBaseData instanceof AIOVideoData) {
                AIOVideoData aIOVideoData = (AIOVideoData) richMediaBaseData;
                aIOVideoData.status = 0;
                aIOVideoData.progress = 0;
                q16.baseData = aIOVideoData;
                BrowserBasePresenter browserBasePresenter2 = this.f281861h;
                if (browserBasePresenter2 != null) {
                    browserBasePresenter2.updateItem(q16);
                }
            }
        }
        AIOBrowserPresenter aIOBrowserPresenter = this.f281859e;
        if (aIOBrowserPresenter != null && (aVar = aIOBrowserPresenter.f281850e) != null && this.C != null && (selectedItem = aVar.getSelectedItem()) != null) {
            RichMediaBaseData richMediaBaseData2 = selectedItem.baseData;
            if ((richMediaBaseData2 instanceof AIOVideoData) && ((AIOVideoData) richMediaBaseData2).msgId == j3) {
                this.C.updateUI();
                if (i16 == 256) {
                    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoPresenter", 4, "save video result resultStr = " + str);
                    if (i17 == 1) {
                        Context context = this.C.f282077h;
                        QQToast.makeText(context, 2, context.getString(R.string.f221846bx), 0).show();
                        return;
                    } else {
                        Context context2 = this.C.f282077h;
                        QQToast.makeText(context2, 1, context2.getString(R.string.f221876c0), 0).show();
                        return;
                    }
                }
                if (i16 == 1 || i16 == 0) {
                    if (i17 != 1) {
                        str = AIOBrowserBaseData.MEDIA_FILE_ERROR;
                    }
                    u(j3, i3, i16, str);
                    AIOVideoView aIOVideoView = this.C;
                    if (aIOVideoView.I != null && (browserBasePresenter = this.f281861h) != null) {
                        aIOVideoView.f1(browserBasePresenter.getSelectedIndex(), this.C.I.mBrowserItemView, z16);
                    }
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.presenter.a
    public void E(long j3, int i3, int i16, String str, String[] strArr, String str2, MessageRecord messageRecord, int i17, Bundle bundle) {
        AIOVideoView aIOVideoView = this.C;
        if (aIOVideoView != null) {
            aIOVideoView.B0(j3, i3, i16, str, strArr, str2, messageRecord, i17);
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.presenter.a
    public void G() {
        AIOBrowserPresenter aIOBrowserPresenter = this.f281859e;
        if (aIOBrowserPresenter != null && aIOBrowserPresenter.f281849d != null && aIOBrowserPresenter.m() != null) {
            if (LiuHaiUtils.isLiuHaiUseValid() && this.C != null) {
                this.f281859e.m().s(((int) Utils.R(LiuHaiUtils.sNotchHeight, this.C.f282077h.getResources())) + 46);
            } else {
                this.f281859e.m().s(46);
            }
            this.f281859e.m().o();
            this.f281859e.m().i();
            this.f281859e.f281849d.c();
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.presenter.a
    public void H(int i3) {
        try {
            this.D.remove(Integer.valueOf(i3));
        } catch (Exception e16) {
            BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoPresenter", 4, "onRevokeMsg exception = " + e16.getMessage());
        }
    }

    public void S(AIOVideoData aIOVideoData) {
        if (aIOVideoData != null && (this.f281859e.getParamsBuilder().c() instanceof com.tencent.mobileqq.richmediabrowser.f)) {
            BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoPresenter", 4, "dealSaveVideo");
            ((com.tencent.mobileqq.richmediabrowser.f) this.f281859e.getParamsBuilder().c()).y(aIOVideoData.msgId, aIOVideoData.subId, 256);
        }
    }

    public void T(long j3, boolean z16) {
        AIOBrowserPresenter aIOBrowserPresenter;
        RichMediaBaseData richMediaBaseData;
        RichMediaBrowserInfo q16 = q(j3);
        if (q16 != null && (aIOBrowserPresenter = this.f281859e) != null && aIOBrowserPresenter.f281850e != null && (richMediaBaseData = q16.baseData) != null && richMediaBaseData.getType() == 101) {
            if (QLog.isColorLevel()) {
                QLog.d("AIOVideoPresenter", 2, "dealVideoAutoPlay set isAutoPlay = ", Boolean.valueOf(z16));
            }
            ((AIOVideoData) q16.baseData).I = z16;
            this.f281859e.f281850e.updateItem(q16);
        }
    }

    public void U(long j3) {
        AIOBrowserPresenter aIOBrowserPresenter;
        RichMediaBaseData richMediaBaseData;
        RichMediaBrowserInfo q16 = q(j3);
        if (q16 != null && (aIOBrowserPresenter = this.f281859e) != null && aIOBrowserPresenter.f281850e != null && (richMediaBaseData = q16.baseData) != null && richMediaBaseData.getType() == 101) {
            ((AIOVideoData) q16.baseData).J = false;
            this.f281859e.f281850e.updateItem(q16);
        }
    }

    public long V(long j3) {
        RichMediaBaseData richMediaBaseData;
        RichMediaBrowserInfo q16 = q(j3);
        if (q16 != null && (richMediaBaseData = q16.baseData) != null && richMediaBaseData.getType() == 101) {
            return ((AIOVideoData) q16.baseData).K;
        }
        return 0L;
    }

    public AIOVideoData W() {
        tm2.a aVar;
        RichMediaBrowserInfo selectedItem;
        RichMediaBaseData richMediaBaseData;
        AIOBrowserPresenter aIOBrowserPresenter = this.f281859e;
        if (aIOBrowserPresenter != null && (aVar = aIOBrowserPresenter.f281850e) != null && (selectedItem = aVar.getSelectedItem()) != null && (richMediaBaseData = selectedItem.baseData) != null && richMediaBaseData.getType() == 101) {
            return (AIOVideoData) selectedItem.baseData;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0097  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public tm2.f X(AIOVideoData aIOVideoData) {
        long j3;
        boolean z16;
        if (aIOVideoData == null) {
            return null;
        }
        File file = new File(aIOVideoData.f281844e);
        if (file.exists()) {
            j3 = file.length();
            if (((IBrowserDepend) QRoute.api(IBrowserDepend.class)).isShortVideoType(aIOVideoData.f281846h) || j3 >= aIOVideoData.size) {
                z16 = false;
                BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoPresenter", 4, "getVideoPlayMedioInfo longvideo GetUrlAction =" + z16);
                if (!z16) {
                    g.c d16 = g.e().d(aIOVideoData.msgId);
                    if (d16 == null || !d16.a()) {
                        return null;
                    }
                    tm2.f fVar = new tm2.f();
                    fVar.f436607a = true;
                    fVar.f436609c = d16.f281936a;
                    fVar.f436608b = aIOVideoData.f281844e;
                    fVar.f436612f = d16.f281938c;
                    fVar.f436613g = d16.f281939d;
                    fVar.f436617k = aIOVideoData.msgId;
                    fVar.f436618l = aIOVideoData.subId;
                    return fVar;
                }
                tm2.f fVar2 = new tm2.f();
                fVar2.f436607a = false;
                fVar2.f436617k = aIOVideoData.msgId;
                fVar2.f436618l = aIOVideoData.subId;
                fVar2.f436608b = aIOVideoData.f281844e;
                fVar2.f436622p = j3;
                return fVar2;
            }
        } else {
            BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoPresenter", 4, "initData, #PLAY_CALLER_SHORT_VIDEO#, not exist");
            j3 = 0;
        }
        z16 = true;
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoPresenter", 4, "getVideoPlayMedioInfo longvideo GetUrlAction =" + z16);
        if (!z16) {
        }
    }

    public void Y(AIOVideoData aIOVideoData) {
        AIOBrowserPresenter aIOBrowserPresenter = this.f281859e;
        if (aIOBrowserPresenter != null && (aIOBrowserPresenter.getParamsBuilder().c() instanceof com.tencent.mobileqq.richmediabrowser.f)) {
            ((com.tencent.mobileqq.richmediabrowser.f) this.f281859e.getParamsBuilder().c()).y(aIOVideoData.msgId, aIOVideoData.subId, 1);
        }
    }

    public boolean Z(long j3) {
        RichMediaBaseData richMediaBaseData;
        RichMediaBrowserInfo q16 = q(j3);
        if (q16 != null && (richMediaBaseData = q16.baseData) != null && richMediaBaseData.getType() == 101) {
            return ((AIOVideoData) q16.baseData).L;
        }
        return false;
    }

    public boolean a0(int i3) {
        tm2.a aVar;
        RichMediaBaseData richMediaBaseData;
        AIOBrowserPresenter aIOBrowserPresenter = this.f281859e;
        if (aIOBrowserPresenter != null && (aVar = aIOBrowserPresenter.f281850e) != null) {
            RichMediaBrowserInfo item = aVar.getItem(i3);
            if (item != null && (richMediaBaseData = item.baseData) != null && richMediaBaseData.getType() == 101) {
                boolean z16 = ((AIOVideoData) item.baseData).I;
                if (QLog.isColorLevel()) {
                    QLog.d("AIOVideoPresenter", 2, "[isNeedAutoPlay] position = ", Integer.valueOf(i3), ", isAutoPlay = ", Boolean.valueOf(z16));
                }
                return z16;
            }
            if (QLog.isColorLevel()) {
                QLog.d("AIOVideoPresenter", 2, "[isNeedAutoPlay] position = ", Integer.valueOf(i3), " galleryInfo.baseData is null");
            }
        } else if (QLog.isColorLevel()) {
            QLog.d("AIOVideoPresenter", 2, "[isNeedAutoPlay] position = ", Integer.valueOf(i3), " aioBrowserModel is null");
        }
        return false;
    }

    @Override // com.tencent.mobileqq.richmediabrowser.presenter.f
    @NonNull
    public BrowserBasePresenter b() {
        return this.f281861h;
    }

    public boolean b0(long j3) {
        RichMediaBaseData richMediaBaseData;
        RichMediaBrowserInfo q16 = q(j3);
        if (q16 != null && (richMediaBaseData = q16.baseData) != null && richMediaBaseData.getType() == 101) {
            return ((AIOVideoData) q16.baseData).J;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.richmediabrowser.presenter.f
    public void c(String str) {
        AIOBrowserScene aIOBrowserScene;
        AIOBrowserPresenter aIOBrowserPresenter = this.f281859e;
        if (aIOBrowserPresenter != null && (aIOBrowserScene = aIOBrowserPresenter.f281849d) != null) {
            aIOBrowserScene.t(str);
        }
    }

    public void c0(String str, int i3, int i16, ImageView imageView, int i17) {
        if (FileUtils.fileExistsAndNotEmpty(str)) {
            URL thumbUrl = ((IShortVideoDepend) QRoute.api(IShortVideoDepend.class)).getThumbUrl(str);
            if (thumbUrl != null) {
                Drawable coverDrawable = getCoverDrawable(thumbUrl.toString(), i3, i16);
                if (coverDrawable instanceof URLDrawable) {
                    this.D.put(Integer.valueOf(i17), (URLDrawable) coverDrawable);
                }
                imageView.setImageDrawable(coverDrawable);
                return;
            }
            BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoPresenter", 4, "url  is null");
        }
    }

    public void d0(long j3, boolean z16) {
        RichMediaBaseData richMediaBaseData;
        RichMediaBrowserInfo q16 = q(j3);
        if (q16 != null && this.f281861h != null && (richMediaBaseData = q16.baseData) != null && richMediaBaseData.getType() == 101) {
            ((AIOVideoData) q16.baseData).L = z16;
            this.f281861h.updateItem(q16);
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.presenter.a, c04.b
    public void e(c04.c cVar) {
        super.e(cVar);
        if (cVar instanceof AIOVideoView) {
            this.C = (AIOVideoView) cVar;
        }
        AppNetConnInfo.registerConnectionChangeReceiver(this.C.f282077h, this);
    }

    public void e0(int i3, File file) {
        String str;
        boolean saveVideoToAlbum;
        if (i3 != 1) {
            if (i3 != 2) {
                str = null;
            } else {
                str = "0X8007A25";
            }
        } else {
            str = "0X8007A24";
        }
        String str2 = str;
        if (str2 != null) {
            ReportController.o(null, "dc00898", "", "", str2, str2, 0, 0, "", "", "", "");
        }
        if (file == null) {
            QLog.w("AIOVideoPresenter", 1, "[saveShortVideo] file is null, from=" + i3);
            saveVideoToAlbum = false;
        } else {
            saveVideoToAlbum = ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).saveVideoToAlbum(BaseApplication.getContext(), file.getAbsolutePath(), ((IShortVideoDepend) QRoute.api(IShortVideoDepend.class)).getLocalShortVideoPath());
        }
        if (saveVideoToAlbum) {
            QQToast.makeText(BaseApplication.getContext(), 2, R.string.f221846bx, 0).show();
        } else {
            QQToast.makeText(BaseApplication.getContext(), 1, R.string.f221876c0, 0).show();
        }
        ReportController.o(null, "CliOper", "", "", "0X800610F", "0X800610F", 0, 0, "", "", "", "");
    }

    @Override // com.tencent.mobileqq.richmediabrowser.presenter.f
    public void f() {
        AIOBrowserScene aIOBrowserScene;
        AIOBrowserPresenter aIOBrowserPresenter = this.f281859e;
        if (aIOBrowserPresenter != null && (aIOBrowserScene = aIOBrowserPresenter.f281849d) != null) {
            aIOBrowserScene.w();
        }
    }

    public void f0(int i3, long j3) {
        tm2.f X = X(W());
        if (X != null) {
            ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).updateMsgStatus(i3, j3, X.f436612f, X.f436613g, this.f281859e.getParamsBuilder().c());
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.presenter.f
    public void g() {
        AIOBrowserScene aIOBrowserScene;
        AIOBrowserPresenter aIOBrowserPresenter = this.f281859e;
        if (aIOBrowserPresenter != null && (aIOBrowserScene = aIOBrowserPresenter.f281849d) != null) {
            aIOBrowserScene.x();
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.presenter.f
    public void h(boolean z16) {
        AIOBrowserScene aIOBrowserScene;
        AIOBrowserPresenter aIOBrowserPresenter = this.f281859e;
        if (aIOBrowserPresenter != null && (aIOBrowserScene = aIOBrowserPresenter.f281849d) != null) {
            aIOBrowserScene.v(z16);
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.presenter.f
    public void i() {
        AIOBrowserScene aIOBrowserScene;
        AIOBrowserPresenter aIOBrowserPresenter = this.f281859e;
        if (aIOBrowserPresenter != null && (aIOBrowserScene = aIOBrowserPresenter.f281849d) != null) {
            aIOBrowserScene.j();
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.presenter.a, com.tencent.richmediabrowser.presenter.BasePresenter, e04.a
    public void onDestroy() {
        super.onDestroy();
        AppNetConnInfo.unregisterNetInfoHandler(this);
        g.e().c();
        AIOVideoView aIOVideoView = this.C;
        if (aIOVideoView != null) {
            aIOVideoView.t();
            this.C = null;
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetMobile2None() {
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoPresenter", 4, "onNetMobile2None");
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetMobile2Wifi(String str) {
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoPresenter", 4, "onNetMobile2Wifi s = " + str);
        g.e().c();
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetNone2Mobile(String str) {
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoPresenter", 4, "onNetNone2Mobile s = " + str);
        AIOVideoView aIOVideoView = this.C;
        if (aIOVideoView != null) {
            aIOVideoView.X0();
        }
        g.e().c();
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetNone2Wifi(String str) {
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoPresenter", 4, "onNetNone2Wifi s = " + str);
        g.e().c();
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetWifi2Mobile(String str) {
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoPresenter", 4, "onNetWifi2Mobile s = " + str);
        AIOVideoView aIOVideoView = this.C;
        if (aIOVideoView != null) {
            aIOVideoView.X0();
        }
        g.e().c();
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetWifi2None() {
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoPresenter", 4, "onNetWifi2None");
    }

    @Override // com.tencent.richmediabrowser.presenter.BasePresenter, e04.a
    public void onResume() {
        super.onResume();
        AIOVideoView aIOVideoView = this.C;
        if (aIOVideoView != null) {
            aIOVideoView.F0();
        }
    }

    @Override // com.tencent.richmediabrowser.presenter.BasePresenter, e04.a
    public void onStart() {
        super.onStart();
        AIOVideoView aIOVideoView = this.C;
        if (aIOVideoView != null) {
            aIOVideoView.G0();
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.presenter.a
    public long s() {
        AIOVideoView aIOVideoView = this.C;
        if (aIOVideoView != null) {
            return aIOVideoView.v0();
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
        boolean b16 = ImmersiveConfProcessor.b();
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoPresenter", 4, "isImmersionOpen:" + b16);
        return b16;
    }
}
