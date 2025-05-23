package com.tencent.mobileqq.richmediabrowser.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.RichMediaBrowserConstants;
import com.tencent.mobileqq.comment.config.ImmersiveConfProcessor;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureData;
import com.tencent.mobileqq.richmediabrowser.utils.RichMediaBrowserUtils;
import com.tencent.mobileqq.richmediabrowser.view.AIOFilePictureView;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.listener.IGalleryImageListener;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.model.MainBrowserModel;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.BrowserBasePresenter;
import com.tencent.richmediabrowser.view.BrowserBaseView;
import com.tencent.richmediabrowser.view.GalleryUrlImageView;
import com.tencent.richmediabrowser.view.pic.PictureView;
import com.tencent.richmediabrowser.view.recyclerview.BrowserScaleView;
import com.tencent.util.LiuHaiUtils;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b extends com.tencent.mobileqq.richmediabrowser.presenter.a {
    public AIOFilePictureView C;

    private void S(long j3, int i3, int i16, int i17, String str, RichMediaBrowserInfo richMediaBrowserInfo) {
        String str2;
        if (i17 == 1) {
            str2 = str;
        } else {
            str2 = AIOBrowserBaseData.MEDIA_FILE_ERROR;
        }
        u(j3, i3, i16, str2);
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOFilePicPresenter", 2, "AIOFilePicData.TYPE_ORIGINAL_IMAGE,result:" + i17 + ",resultStr: " + str);
        if (i17 == 1) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mPlayGifImage = true;
            obtain.mUseExifOrientation = false;
            String d16 = new tm2.b().d((AIOFilePictureData) richMediaBrowserInfo.baseData, 4);
            if (TextUtils.isEmpty(d16)) {
                BrowserLogHelper.getInstance().getGalleryLog().d("AIOFilePicPresenter", 2, "null url");
                return;
            }
            URLDrawable uRLDrawable = null;
            URLDrawable fileDrawable = URLDrawable.getFileDrawable(((AIOFilePictureData) richMediaBrowserInfo.baseData).f281833f, null);
            if (fileDrawable != null) {
                fileDrawable.downloadImediatly();
                obtain.mLoadingDrawable = fileDrawable;
            } else {
                URLDrawable fileDrawable2 = URLDrawable.getFileDrawable(((AIOFilePictureData) richMediaBrowserInfo.baseData).f281832e, null);
                if (fileDrawable2 != null) {
                    fileDrawable2.downloadImediatly();
                    obtain.mLoadingDrawable = fileDrawable2;
                }
            }
            try {
                uRLDrawable = URLDrawable.getDrawable(d16, obtain);
                uRLDrawable.setTag(1);
            } catch (Throwable th5) {
                BrowserLogHelper.getInstance().getGalleryLog().d("AIOFilePicPresenter", 4, "URLDrawable.getDrawable failed : " + th5.getMessage());
            }
            if (uRLDrawable == null) {
                Context context = this.C.f282077h;
                QQToast.makeText(context, context.getString(R.string.f221796bs), 0).show();
                return;
            }
            GalleryUrlImageView galleryUrlImageView = (GalleryUrlImageView) this.C.I.mBrowserItemView.findViewById(R.id.image);
            if (galleryUrlImageView != null) {
                galleryUrlImageView.setGalleryImageListener(new a(uRLDrawable));
                galleryUrlImageView.setImageDrawable(uRLDrawable);
                AIOFilePictureView aIOFilePictureView = this.C;
                aIOFilePictureView.f281949a0 = RichMediaBrowserUtils.g(aIOFilePictureView.Z, uRLDrawable);
            }
            if (!p().f281782d) {
                p().f();
                p().j();
                return;
            }
            return;
        }
        if (!RichMediaBrowserConstants.TROOP_FILE_ERROR.equals(str)) {
            if (this.C.f282077h.getString(R.string.f221636bc).equals(str)) {
                QQToast.makeText(this.C.f282077h, str, 0).show();
            } else {
                Context context2 = this.C.f282077h;
                QQToast.makeText(context2, context2.getString(R.string.f221796bs), 0).show();
            }
        }
        this.C.x0(true);
    }

    @Override // com.tencent.mobileqq.richmediabrowser.presenter.a
    public void C(long j3, int i3, int i16, int i17, long j16, boolean z16) {
        RichMediaBrowserInfo selectedItem;
        RichMediaBaseData richMediaBaseData;
        RichMediaBaseData richMediaBaseData2;
        int i18;
        RichMediaBrowserInfo q16 = q(j3);
        if (q16 != null && (richMediaBaseData2 = q16.baseData) != null && richMediaBaseData2.getType() == 102) {
            AIOFilePictureData aIOFilePictureData = (AIOFilePictureData) q16.baseData;
            if (i16 != 2) {
                if (i16 != 4) {
                    i18 = 0;
                } else {
                    i18 = 3;
                }
            } else {
                i18 = 1;
            }
            aIOFilePictureData.status = i18;
            aIOFilePictureData.progress = i17;
            q16.baseData = aIOFilePictureData;
            MainBrowserModel mainBrowserModel = this.f281859e.browserModel;
            if (mainBrowserModel != null) {
                mainBrowserModel.updateItem(q16);
            }
        }
        MainBrowserModel mainBrowserModel2 = this.f281859e.browserModel;
        if (mainBrowserModel2 != null && (selectedItem = mainBrowserModel2.getSelectedItem()) != null && (richMediaBaseData = selectedItem.baseData) != null && ((AIOBrowserBaseData) richMediaBaseData).msgId == j3) {
            this.C.updateUI();
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.presenter.a
    public void D(long j3, int i3, int i16, int i17, String str, boolean z16) {
        RichMediaBrowserInfo selectedItem;
        RichMediaBaseData richMediaBaseData;
        String str2;
        RichMediaBaseData richMediaBaseData2;
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOFilePicPresenter", 2, "notifyImageResult result = " + i17 + ", type = " + i16 + ", resultStr = " + str);
        RichMediaBrowserInfo q16 = q(j3);
        if (q16 != null && (richMediaBaseData2 = q16.baseData) != null && richMediaBaseData2.getType() == 102) {
            AIOFilePictureData aIOFilePictureData = (AIOFilePictureData) q16.baseData;
            aIOFilePictureData.status = 0;
            aIOFilePictureData.progress = 0;
            q16.baseData = aIOFilePictureData;
            MainBrowserModel mainBrowserModel = this.f281859e.browserModel;
            if (mainBrowserModel != null) {
                mainBrowserModel.updateItem(q16);
            }
        }
        MainBrowserModel mainBrowserModel2 = this.f281859e.browserModel;
        if (mainBrowserModel2 != null && (selectedItem = mainBrowserModel2.getSelectedItem()) != null && (richMediaBaseData = selectedItem.baseData) != null && ((AIOBrowserBaseData) richMediaBaseData).msgId == j3) {
            if (i16 == 2) {
                if (i17 == 1) {
                    str2 = str;
                } else {
                    str2 = AIOBrowserBaseData.MEDIA_FILE_ERROR;
                }
                int u16 = u(j3, i3, i16, str2);
                if (i17 == 2 && !TextUtils.isEmpty(str)) {
                    new tm2.b().f((AIOFilePictureData) selectedItem.baseData, i16, str);
                }
                AIOFilePictureView aIOFilePictureView = this.C;
                BrowserBaseView browserBaseView = aIOFilePictureView.I;
                if (browserBaseView != null) {
                    aIOFilePictureView.B0(u16, browserBaseView.mBrowserItemView, z16);
                } else {
                    BrowserLogHelper.getInstance().getGalleryLog().d("AIOFilePicPresenter", 2, "notifyImageResult(): decoratorView is null");
                }
                BrowserLogHelper.getInstance().getGalleryLog().d("AIOFilePicPresenter", 2, "notifyImageResult(): Gallery position is " + u16);
            } else if (i16 == 4) {
                S(j3, i3, i16, i17, str, selectedItem);
            }
            this.C.updateUI();
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.presenter.a
    public void G() {
        AIOBrowserPresenter aIOBrowserPresenter = this.f281859e;
        if (aIOBrowserPresenter != null && aIOBrowserPresenter.f281849d != null && aIOBrowserPresenter.m() != null) {
            this.f281862i.clear();
            if (LiuHaiUtils.isLiuHaiUseValid()) {
                this.f281859e.m().s(((int) Utils.R(LiuHaiUtils.sNotchHeight, this.C.f282077h.getResources())) + 40);
            } else {
                this.f281859e.m().s(40);
            }
            this.f281859e.m().i();
            this.f281859e.m().p();
            this.f281859e.f281849d.c();
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.presenter.a
    public void H(int i3) {
        try {
            this.f281861h.mActiveDrawable.remove(Integer.valueOf(i3));
        } catch (Exception e16) {
            BrowserLogHelper.getInstance().getGalleryLog().d("AIOFilePicPresenter", 4, "onRevokeMsg exception = " + e16.getMessage());
        }
    }

    public AIOFilePictureData T() {
        RichMediaBrowserInfo selectedItem;
        tm2.a aVar = this.f281859e.f281850e;
        if (aVar != null && (selectedItem = aVar.getSelectedItem()) != null) {
            RichMediaBaseData richMediaBaseData = selectedItem.baseData;
            if ((richMediaBaseData instanceof AIOFilePictureData) && richMediaBaseData.getType() == 102) {
                return (AIOFilePictureData) selectedItem.baseData;
            }
            return null;
        }
        return null;
    }

    public Intent U(AIOFilePictureData aIOFilePictureData, Activity activity) {
        if (aIOFilePictureData != null && (this.f281859e.getParamsBuilder().c() instanceof com.tencent.mobileqq.richmediabrowser.f) && ((com.tencent.mobileqq.richmediabrowser.f) this.f281859e.getParamsBuilder().c()).n()) {
            boolean z16 = false;
            Intent u16 = ((com.tencent.mobileqq.richmediabrowser.f) this.f281859e.getParamsBuilder().c()).u(aIOFilePictureData.msgId, aIOFilePictureData.subId, 0);
            if (u16 != null) {
                if (aIOFilePictureData.istroop == 1) {
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

    public void V(int i3, URLDrawable uRLDrawable) {
        BrowserBasePresenter browserBasePresenter;
        if (uRLDrawable != null && (browserBasePresenter = this.f281861h) != null) {
            browserBasePresenter.mActiveDrawable.put(Integer.valueOf(i3), uRLDrawable);
            if (this.C != null && i3 == this.f281861h.getCurrentPosition()) {
                this.C.b(i3);
            }
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.presenter.a, c04.b
    public void e(c04.c cVar) {
        super.e(cVar);
        if (cVar instanceof AIOFilePictureView) {
            this.C = (AIOFilePictureView) cVar;
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.presenter.a, com.tencent.richmediabrowser.presenter.BasePresenter, e04.a
    public void onDestroy() {
        super.onDestroy();
        AIOFilePictureView aIOFilePictureView = this.C;
        Runnable runnable = aIOFilePictureView.f281949a0;
        if (runnable != null) {
            aIOFilePictureView.Z.removeCallbacks(runnable);
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.presenter.a
    public boolean x() {
        if (QLog.isColorLevel()) {
            QLog.d("AIOFilePicPresenter", 2, "isImmersionOpen, ImmersiveConfProcessor.isImageEnable() = " + ImmersiveConfProcessor.a());
        }
        return ImmersiveConfProcessor.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements IGalleryImageListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ URLDrawable f281864d;

        a(URLDrawable uRLDrawable) {
            this.f281864d = uRLDrawable;
        }

        @Override // com.tencent.richmediabrowser.listener.IGalleryImageListener
        public void onLoadSuccessed(int i3, boolean z16) {
            BrowserScaleView browserScaleView;
            b.this.C.Z.setVisibility(8);
            if (z16) {
                b.this.V(i3, this.f281864d);
                int exifOrientation = this.f281864d.getExifOrientation();
                AIOFilePictureView aIOFilePictureView = b.this.C;
                PictureView pictureView = aIOFilePictureView.R;
                if (pictureView != null && (browserScaleView = pictureView.imageView) != null) {
                    browserScaleView.initDrawable(this.f281864d, aIOFilePictureView.J, aIOFilePictureView.K, com.tencent.richmediabrowser.utils.a.a(exifOrientation));
                    return;
                }
                return;
            }
            Context context = b.this.C.f282077h;
            QQToast.makeText(context, context.getString(R.string.f221796bs), 0).show();
        }

        @Override // com.tencent.richmediabrowser.listener.IGalleryImageListener
        public void onLoadDrawable(int i3, URLDrawable uRLDrawable) {
        }
    }
}
