package com.tencent.mobileqq.richmediabrowser.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.Utils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.RichMediaBrowserConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.comment.config.ImmersiveConfProcessor;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend;
import com.tencent.mobileqq.richmediabrowser.h;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;
import com.tencent.mobileqq.richmediabrowser.utils.RichMediaBrowserUtils;
import com.tencent.mobileqq.richmediabrowser.view.AIOPictureView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.constant.DecoderType;
import com.tencent.richmediabrowser.listener.IGalleryImageListener;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.model.MainBrowserModel;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.BrowserBasePresenter;
import com.tencent.richmediabrowser.view.BrowserBaseView;
import com.tencent.richmediabrowser.view.BrowserURLImageView;
import com.tencent.richmediabrowser.view.GalleryUrlImageView;
import com.tencent.richmediabrowser.view.pic.PictureView;
import com.tencent.richmediabrowser.view.recyclerview.BrowserScaleView;
import com.tencent.util.LiuHaiUtils;
import java.io.File;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d extends com.tencent.mobileqq.richmediabrowser.presenter.a {
    public AIOPictureView C;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f281869a;

        /* renamed from: b, reason: collision with root package name */
        public String f281870b;

        /* renamed from: c, reason: collision with root package name */
        public int f281871c = 0;
    }

    public static Intent Z(RichMediaBrowserInfo richMediaBrowserInfo, Activity activity, int i3) {
        RichMediaBaseData richMediaBaseData;
        boolean z16;
        if (richMediaBrowserInfo != null && (richMediaBaseData = richMediaBrowserInfo.baseData) != null && richMediaBaseData.getType() == 100) {
            AIOPictureData aIOPictureData = (AIOPictureData) richMediaBrowserInfo.baseData;
            tm2.d dVar = new tm2.d();
            int i16 = 4;
            File c16 = dVar.c(aIOPictureData, 4);
            if (c16 == null) {
                c16 = dVar.c(aIOPictureData, 2);
                z16 = false;
            } else {
                z16 = true;
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean(AppConstants.Key.FORWARD_URLDRAWABLE, true);
            bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_THUMB_URL, dVar.e(aIOPictureData, 1));
            RichMediaBaseData richMediaBaseData2 = richMediaBrowserInfo.baseData;
            if (richMediaBaseData2 instanceof AIOPictureData) {
                AIOPictureData aIOPictureData2 = (AIOPictureData) richMediaBaseData2;
                tm2.d dVar2 = new tm2.d();
                if (!z16) {
                    i16 = 2;
                }
                bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_BIG_URL, dVar2.e(aIOPictureData2, i16));
            }
            return ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).getFriendPickerForForwardIntent(c16, z16, aIOPictureData, bundle, activity);
        }
        return null;
    }

    private boolean a0(long j3, int i3) {
        RichMediaBrowserInfo r16 = r(j3, i3);
        if (r16 == null) {
            return false;
        }
        RichMediaBaseData richMediaBaseData = r16.baseData;
        if (!(richMediaBaseData instanceof AIOPictureData) || ((AIOPictureData) richMediaBaseData).istroop != 10014) {
            return false;
        }
        return true;
    }

    private void b0(long j3, int i3, int i16, int i17, String str, RichMediaBrowserInfo richMediaBrowserInfo) {
        String str2;
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOPicturePresenter", 2, "TYPE_ORIGINAL_IMAGE result = " + i17 + ", resultStr = " + str);
        if (i17 == 1) {
            str2 = str;
        } else {
            str2 = AIOBrowserBaseData.MEDIA_FILE_ERROR;
        }
        u(j3, i3, i16, str2);
        if (i17 == 1) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            URLDrawable uRLDrawable = null;
            try {
                obtain.mPlayGifImage = true;
                obtain.mUseExifOrientation = false;
                URLDrawable fileDrawable = URLDrawable.getFileDrawable(((AIOPictureData) richMediaBrowserInfo.baseData).largeImageFile, null);
                if (fileDrawable != null) {
                    fileDrawable.downloadImediatly();
                    obtain.mLoadingDrawable = fileDrawable;
                } else {
                    URLDrawable fileDrawable2 = URLDrawable.getFileDrawable(((AIOPictureData) richMediaBrowserInfo.baseData).thumbImageFile, null);
                    if (fileDrawable2 != null) {
                        fileDrawable2.downloadImediatly();
                        obtain.mLoadingDrawable = fileDrawable2;
                    }
                }
                uRLDrawable = URLDrawable.getDrawable(new tm2.d().e((AIOPictureData) richMediaBrowserInfo.baseData, 4), obtain);
                uRLDrawable.setTag(1);
            } catch (Throwable th5) {
                th5.printStackTrace();
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
                AIOPictureView aIOPictureView = this.C;
                aIOPictureView.f282004j0 = RichMediaBrowserUtils.g(aIOPictureView.f282003i0, uRLDrawable);
                return;
            }
            return;
        }
        if (!RichMediaBrowserConstants.TROOP_FILE_ERROR.equals(str)) {
            Context context2 = this.C.f282077h;
            QQToast.makeText(context2, context2.getString(R.string.f221796bs), 0).show();
        }
    }

    private void c0(String str) {
        QLog.i("AIOPicturePresenter", 1, "[savePicForGuild] resultStr: " + str);
        if ((this.C.f282077h instanceof Activity) && !TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.exists()) {
                ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).savePic((Activity) this.C.f282077h, file, Utils.Crc64String(file.getAbsolutePath() + NetConnInfoCenter.getServerTime()));
                return;
            }
            QLog.i("AIOPicturePresenter", 1, "[savePicForGuild] error! file doesn't exist!");
            Context context = this.C.f282077h;
            QQToast.makeText(context, context.getString(R.string.f221836bw), 0).show();
            return;
        }
        QLog.i("AIOPicturePresenter", 1, "[savePicForGuild] error! context or result is empty!");
        Context context2 = this.C.f282077h;
        QQToast.makeText(context2, context2.getString(R.string.f221836bw), 0).show();
    }

    public static void d0(RichMediaBrowserInfo richMediaBrowserInfo, Activity activity, int i3) {
        RichMediaBaseData richMediaBaseData;
        boolean z16;
        if (richMediaBrowserInfo != null && (richMediaBaseData = richMediaBrowserInfo.baseData) != null && richMediaBaseData.getType() == 100) {
            AIOPictureData aIOPictureData = (AIOPictureData) richMediaBrowserInfo.baseData;
            tm2.d dVar = new tm2.d();
            int i16 = 4;
            File c16 = dVar.c(aIOPictureData, 4);
            if (c16 == null) {
                c16 = dVar.c(aIOPictureData, 2);
                z16 = false;
            } else {
                z16 = true;
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean(AppConstants.Key.FORWARD_URLDRAWABLE, true);
            bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_THUMB_URL, dVar.e(aIOPictureData, 1));
            RichMediaBaseData richMediaBaseData2 = richMediaBrowserInfo.baseData;
            if (richMediaBaseData2 instanceof AIOPictureData) {
                AIOPictureData aIOPictureData2 = (AIOPictureData) richMediaBaseData2;
                tm2.d dVar2 = new tm2.d();
                if (!z16) {
                    i16 = 2;
                }
                bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_BIG_URL, dVar2.e(aIOPictureData2, i16));
            }
            ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).showFriendPickerForForward(c16, z16, aIOPictureData, bundle, activity, i3);
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.presenter.a
    public void C(long j3, int i3, int i16, int i17, long j16, boolean z16) {
        RichMediaBrowserInfo selectedItem;
        AIOPictureView aIOPictureView;
        BrowserBaseView browserBaseView;
        int i18;
        RichMediaBrowserInfo r16 = r(j3, i3);
        if (r16 != null && r16.baseData.getType() == 100) {
            RichMediaBaseData richMediaBaseData = r16.baseData;
            if (richMediaBaseData instanceof AIOPictureData) {
                AIOPictureData aIOPictureData = (AIOPictureData) richMediaBaseData;
                if (i16 != 2) {
                    i18 = 4;
                    if (i16 != 4) {
                        if (i16 != 24) {
                            i18 = 0;
                        }
                    } else {
                        i18 = 3;
                    }
                } else {
                    i18 = 1;
                }
                aIOPictureData.status = i18;
                aIOPictureData.progress = i17;
                r16.baseData = aIOPictureData;
                BrowserBasePresenter browserBasePresenter = this.f281861h;
                if (browserBasePresenter != null) {
                    browserBasePresenter.updateItem(r16);
                }
            }
        }
        BrowserBasePresenter browserBasePresenter2 = this.f281861h;
        if (browserBasePresenter2 != null && (selectedItem = browserBasePresenter2.getSelectedItem()) != null) {
            RichMediaBaseData richMediaBaseData2 = selectedItem.baseData;
            if (richMediaBaseData2 instanceof AIOPictureData) {
                AIOPictureData aIOPictureData2 = (AIOPictureData) richMediaBaseData2;
                if (aIOPictureData2.msgId == j3 && aIOPictureData2.subId == i3 && (aIOPictureView = this.C) != null) {
                    aIOPictureView.updateUI();
                    if (z16 && i16 == 2 && (browserBaseView = this.C.I) != null && browserBaseView.mBrowserItemView != null) {
                        e0(this.f281861h.getSelectedIndex(), this.C.I.mBrowserItemView, true);
                    }
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.presenter.a
    public void D(long j3, int i3, int i16, int i17, String str, boolean z16) {
        String str2;
        boolean z17;
        RichMediaBaseData richMediaBaseData;
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOPicturePresenter", 2, "notifyImageResult result = " + i17 + ", type = " + i16 + ", resultStr = " + str);
        long j16 = (long) i3;
        RichMediaBrowserInfo r16 = r(j3, j16);
        if (r16 != null && r16.baseData.getType() == 100) {
            RichMediaBaseData richMediaBaseData2 = r16.baseData;
            if (richMediaBaseData2 instanceof AIOPictureData) {
                AIOPictureData aIOPictureData = (AIOPictureData) richMediaBaseData2;
                aIOPictureData.status = 0;
                aIOPictureData.progress = 0;
                r16.baseData = aIOPictureData;
                BrowserBasePresenter browserBasePresenter = this.f281861h;
                if (browserBasePresenter != null) {
                    browserBasePresenter.updateItem(r16);
                }
            }
        }
        MainBrowserModel mainBrowserModel = this.f281859e.browserModel;
        if (mainBrowserModel != null) {
            RichMediaBrowserInfo selectedItem = mainBrowserModel.getSelectedItem();
            if (this.C != null && selectedItem != null) {
                RichMediaBaseData richMediaBaseData3 = selectedItem.baseData;
                if ((richMediaBaseData3 instanceof AIOPictureData) && ((AIOPictureData) richMediaBaseData3).msgId == j3 && ((AIOPictureData) richMediaBaseData3).subId == i3) {
                    if (i16 == 2) {
                        if (i17 == 1) {
                            str2 = str;
                        } else {
                            str2 = AIOBrowserBaseData.MEDIA_FILE_ERROR;
                        }
                        int v3 = v(j3, i3, i16, str2, str);
                        BrowserLogHelper.getInstance().getGalleryLog().d("AIOPicturePresenter", 2, "notifyImageResult(): TYPE_LARGE_IMAGE Gallery position is " + v3);
                        RichMediaBrowserInfo r17 = r(j3, j16);
                        if (r17 != null && (richMediaBaseData = r17.baseData) != null && richMediaBaseData.getType() == 100) {
                            z17 = true;
                            if (i17 == 1) {
                                AIOPictureData aIOPictureData2 = (AIOPictureData) r17.baseData;
                                if (!aIOPictureData2.isPicFile) {
                                    if (new File(aIOPictureData2.thumbImageFile + "_hd").exists()) {
                                        aIOPictureData2.thumbImageFile += "_hd";
                                    }
                                }
                            }
                        } else {
                            z17 = true;
                        }
                        BrowserBasePresenter browserBasePresenter2 = this.f281861h;
                        if (browserBasePresenter2 != null) {
                            browserBasePresenter2.onLoadFinish(v3, z17);
                        }
                        this.C.o1(v3, z16);
                    } else if (i16 == 24) {
                        BrowserLogHelper.getInstance().getGalleryLog().d("AIOPicturePresenter", 2, "save pic result = " + i17 + ", resultStr = " + str);
                        if (i17 == 1) {
                            if (a0(j3, i3)) {
                                c0(str);
                            } else {
                                Context context = this.C.f282077h;
                                QQToast.makeText(context, context.getString(R.string.f221846bx), 0).show();
                            }
                        } else {
                            Context context2 = this.C.f282077h;
                            QQToast.makeText(context2, context2.getString(R.string.f221836bw), 0).show();
                        }
                        this.C.w();
                    } else if (i16 == 4) {
                        b0(j3, i3, i16, i17, str, selectedItem);
                        this.C.w();
                    }
                    this.C.updateUI();
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.presenter.a
    public void G() {
        AIOBrowserPresenter aIOBrowserPresenter;
        if (this.C != null && (aIOBrowserPresenter = this.f281859e) != null && aIOBrowserPresenter.f281849d != null && aIOBrowserPresenter.m() != null) {
            this.f281862i.clear();
            if (LiuHaiUtils.isLiuHaiUseValid()) {
                this.f281859e.m().s(((int) com.tencent.mobileqq.util.Utils.R(LiuHaiUtils.sNotchHeight, this.C.f282077h.getResources())) + 40);
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
            BrowserLogHelper.getInstance().getGalleryLog().d("AIOPicturePresenter", 4, "onRevokeMsg exception = " + e16.getMessage());
        }
    }

    public void S(AIOPictureData aIOPictureData) {
        if (aIOPictureData != null && this.C.f282010p0 != null) {
            BrowserLogHelper.getInstance().getGalleryLog().d("AIOPicturePresenter", 2, "dealSaveOriginalImage");
            this.C.f282010p0.y(aIOPictureData.msgId, aIOPictureData.subId, 24);
        }
    }

    public void T(RichMediaBrowserInfo richMediaBrowserInfo, Activity activity, b bVar, int i3, String str) {
        W(richMediaBrowserInfo, activity, bVar, i3, str, 1);
    }

    public void U(RichMediaBrowserInfo richMediaBrowserInfo, Activity activity, b bVar, int i3, String str) {
        W(richMediaBrowserInfo, activity, bVar, i3, str, 0);
    }

    protected void V(RichMediaBrowserInfo richMediaBrowserInfo, Activity activity, int i3, b bVar, int i16, String str, int i17) {
        boolean z16;
        boolean z17;
        RichMediaBaseData richMediaBaseData;
        boolean z18;
        int c16 = h.a().c();
        int i18 = 2;
        if (c16 != 1 && c16 != 2 && c16 != 3 && c16 != 5 && c16 != 6) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && i17 != 1) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z17) {
            if (richMediaBrowserInfo != null && (richMediaBaseData = richMediaBrowserInfo.baseData) != null && richMediaBaseData.getType() == 100) {
                AIOPictureData aIOPictureData = (AIOPictureData) richMediaBrowserInfo.baseData;
                tm2.d dVar = new tm2.d();
                File c17 = dVar.c(aIOPictureData, 4);
                if (c17 == null) {
                    c17 = dVar.c(aIOPictureData, 2);
                    z18 = false;
                } else {
                    z18 = true;
                }
                File file = c17;
                Bundle bundle = new Bundle(activity.getIntent().getExtras());
                bundle.putBoolean(AppConstants.Key.FORWARD_URLDRAWABLE, true);
                bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_THUMB_URL, dVar.e(aIOPictureData, 1));
                if (z18) {
                    i18 = 4;
                }
                bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_BIG_URL, dVar.e(aIOPictureData, i18));
                if (i17 == 1) {
                    ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).forwardToChannel(file, z18, aIOPictureData, bundle, activity, bVar.f281869a, i16, str);
                    return;
                } else {
                    ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).forwardPicToFriend(file, z18, aIOPictureData, bundle, activity, bVar.f281869a, bVar.f281870b, bVar.f281871c, i16, str);
                    return;
                }
            }
            return;
        }
        d0(richMediaBrowserInfo, activity, i3);
    }

    protected void W(RichMediaBrowserInfo richMediaBrowserInfo, Activity activity, b bVar, int i3, String str, int i16) {
        RichMediaBaseData richMediaBaseData;
        boolean z16;
        if (richMediaBrowserInfo != null && (richMediaBaseData = richMediaBrowserInfo.baseData) != null && AIOPictureData.class.isInstance(richMediaBaseData)) {
            AIOPictureData aIOPictureData = (AIOPictureData) richMediaBrowserInfo.baseData;
            if (aIOPictureData.istroop == 1 && aIOPictureData.isFromFile) {
                com.tencent.mobileqq.richmediabrowser.f fVar = this.C.f282010p0;
                if (fVar != null && fVar.n()) {
                    Intent u16 = this.C.f282010p0.u(aIOPictureData.msgId, aIOPictureData.subId, 0);
                    if (u16 == null) {
                        BrowserLogHelper.getInstance().getGalleryLog().d("AIOPicturePresenter", 4, "forwardPicToFriend getForwardData is null!");
                        return;
                    }
                    u16.setExtrasClassLoader(ForwardFileInfo.class.getClassLoader());
                    if (aIOPictureData.istroop == 1) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (i16 == 1) {
                        ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).forwardToChannel(activity, u16, z16, i3, str);
                        return;
                    } else {
                        ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).forwardToFriend(activity, u16, z16, i3, str);
                        return;
                    }
                }
                return;
            }
            V(richMediaBrowserInfo, activity, 0, bVar, i3, str, i16);
        }
    }

    public Intent X(RichMediaBrowserInfo richMediaBrowserInfo, Activity activity) {
        RichMediaBaseData richMediaBaseData;
        if (richMediaBrowserInfo != null && (richMediaBaseData = richMediaBrowserInfo.baseData) != null && AIOPictureData.class.isInstance(richMediaBaseData)) {
            AIOPictureData aIOPictureData = (AIOPictureData) richMediaBrowserInfo.baseData;
            boolean z16 = false;
            if (aIOPictureData.istroop == 1 && aIOPictureData.isFromFile) {
                if ((this.f281859e.getParamsBuilder().c() instanceof com.tencent.mobileqq.richmediabrowser.f) && ((com.tencent.mobileqq.richmediabrowser.f) this.f281859e.getParamsBuilder().c()).n()) {
                    Intent u16 = ((com.tencent.mobileqq.richmediabrowser.f) this.f281859e.getParamsBuilder().c()).u(aIOPictureData.msgId, aIOPictureData.subId, 0);
                    if (u16 == null) {
                        BrowserLogHelper.getInstance().getGalleryLog().d("AIOPicturePresenter", 4, "forwardPicToFriend getForwardData is null!");
                        return null;
                    }
                    u16.setExtrasClassLoader(ForwardFileInfo.class.getClassLoader());
                    if (aIOPictureData.istroop == 1) {
                        z16 = true;
                    }
                    return ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).getForwardToFriendIntent(activity, u16, z16);
                }
            } else {
                return Y(richMediaBrowserInfo, activity, 0);
            }
        }
        return null;
    }

    public Intent Y(RichMediaBrowserInfo richMediaBrowserInfo, Activity activity, int i3) {
        RichMediaBaseData richMediaBaseData;
        File file;
        boolean z16;
        int c16 = h.a().c();
        int i16 = 2;
        if (c16 != 1 && c16 != 2 && c16 != 3 && c16 != 5 && c16 != 6) {
            return Z(richMediaBrowserInfo, activity, i3);
        }
        if (richMediaBrowserInfo != null && (richMediaBaseData = richMediaBrowserInfo.baseData) != null && richMediaBaseData.getType() == 100) {
            AIOPictureData aIOPictureData = (AIOPictureData) richMediaBrowserInfo.baseData;
            tm2.d dVar = new tm2.d();
            File c17 = dVar.c(aIOPictureData, 4);
            if (c17 == null) {
                file = dVar.c(aIOPictureData, 2);
                z16 = false;
            } else {
                file = c17;
                z16 = true;
            }
            Bundle bundle = new Bundle(activity.getIntent().getExtras());
            bundle.putBoolean(AppConstants.Key.FORWARD_URLDRAWABLE, true);
            bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_THUMB_URL, dVar.e(aIOPictureData, 1));
            if (z16) {
                i16 = 4;
            }
            bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_BIG_URL, dVar.e(aIOPictureData, i16));
            return ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).getForwardPicToFriendIntent(file, z16, aIOPictureData, bundle, activity);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.richmediabrowser.presenter.a, c04.b
    public void e(c04.c cVar) {
        super.e(cVar);
        if (cVar instanceof AIOPictureView) {
            this.C = (AIOPictureView) cVar;
        }
    }

    public void e0(int i3, View view, boolean z16) {
        BrowserBasePresenter browserBasePresenter;
        if ((view instanceof BrowserURLImageView) && (browserBasePresenter = this.f281861h) != null) {
            BrowserURLImageView browserURLImageView = (BrowserURLImageView) view;
            RichMediaBrowserInfo item = browserBasePresenter.getItem(i3);
            if (item != null && item.baseData.getType() == 100) {
                RichMediaBaseData richMediaBaseData = item.baseData;
                if (richMediaBaseData instanceof AIOPictureData) {
                    AIOPictureData aIOPictureData = (AIOPictureData) richMediaBaseData;
                    tm2.d dVar = new tm2.d();
                    if (z16 && dVar.c(aIOPictureData, 8) != null) {
                        Drawable drawable = browserURLImageView.getDrawable();
                        String str = dVar.e(aIOPictureData, 8) + "#" + DecoderType.DECODER_DISPLAY;
                        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                        obtain.mLoadingDrawable = drawable;
                        obtain.mFailedDrawable = drawable;
                        obtain.mPlayGifImage = true;
                        obtain.mUseExifOrientation = false;
                        URLDrawable drawable2 = URLDrawable.getDrawable(str, obtain);
                        browserURLImageView.setDecodingDrawble(drawable2);
                        drawable2.startDownload();
                        BrowserLogHelper.getInstance().getGalleryLog().d("AIOPicturePresenter", 2, "updateDisplayView(): Update dp image, position=" + i3);
                    }
                }
            }
        }
    }

    public void f0(int i3, URLDrawable uRLDrawable) {
        BrowserBasePresenter browserBasePresenter;
        if (uRLDrawable != null && (browserBasePresenter = this.f281861h) != null) {
            browserBasePresenter.mActiveDrawable.put(Integer.valueOf(i3), uRLDrawable);
            if (this.C != null && i3 == this.f281861h.getCurrentPosition()) {
                this.C.b(i3);
            }
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.presenter.a, com.tencent.richmediabrowser.presenter.BasePresenter, e04.a
    public void onDestroy() {
        Runnable runnable;
        super.onDestroy();
        AIOPictureView aIOPictureView = this.C;
        if (aIOPictureView != null && (runnable = aIOPictureView.f282004j0) != null) {
            aIOPictureView.f282003i0.removeCallbacks(runnable);
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.presenter.a
    public boolean x() {
        boolean a16 = ImmersiveConfProcessor.a();
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOPicturePresenter", 4, "isImmersionOpen:" + a16);
        return a16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements IGalleryImageListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ URLDrawable f281867d;

        a(URLDrawable uRLDrawable) {
            this.f281867d = uRLDrawable;
        }

        @Override // com.tencent.richmediabrowser.listener.IGalleryImageListener
        public void onLoadSuccessed(int i3, boolean z16) {
            BrowserScaleView browserScaleView;
            d.this.C.f282003i0.setVisibility(8);
            if (z16) {
                d.this.f0(i3, this.f281867d);
                int exifOrientation = this.f281867d.getExifOrientation();
                AIOPictureView aIOPictureView = d.this.C;
                PictureView pictureView = aIOPictureView.R;
                if (pictureView != null && (browserScaleView = pictureView.imageView) != null) {
                    browserScaleView.initDrawable(this.f281867d, aIOPictureView.J, aIOPictureView.K, com.tencent.richmediabrowser.utils.a.a(exifOrientation));
                    return;
                }
                return;
            }
            Context context = d.this.C.f282077h;
            QQToast.makeText(context, context.getString(R.string.f221796bs), 0).show();
        }

        @Override // com.tencent.richmediabrowser.listener.IGalleryImageListener
        public void onLoadDrawable(int i3, URLDrawable uRLDrawable) {
        }
    }
}
