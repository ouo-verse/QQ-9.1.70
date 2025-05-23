package com.tencent.mobileqq.richmediabrowser.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.image.JpegExifReader;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.RichMediaBrowserConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.mini.api.IMiniAppFileMaterialService;
import com.tencent.mobileqq.ocr.api.IOCR;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend;
import com.tencent.mobileqq.richmediabrowser.api.IFileDepend;
import com.tencent.mobileqq.richmediabrowser.f;
import com.tencent.mobileqq.richmediabrowser.h;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureData;
import com.tencent.mobileqq.richmediabrowser.presenter.AIOBrowserPresenter;
import com.tencent.mobileqq.richmediabrowser.utils.RichMediaBrowserUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ao;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.locate.api.IMsgLocationApi;
import com.tencent.richmediabrowser.constant.DecoderType;
import com.tencent.richmediabrowser.listener.IGalleryImageListener;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.BrowserBasePresenter;
import com.tencent.richmediabrowser.view.GalleryUrlImageView;
import com.tencent.richmediabrowser.view.IBrowserViewHolder;
import com.tencent.richmediabrowser.view.pic.PictureView;
import com.tencent.richmediabrowser.view.recyclerview.BrowserScaleView;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.util.PermissionUtil;
import com.tencent.widget.ActionSheet;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes18.dex */
public class AIOFilePictureView extends com.tencent.mobileqq.richmediabrowser.view.a implements View.OnClickListener, ActionSheet.WatchDismissActions {
    public com.tencent.mobileqq.richmediabrowser.presenter.b Q;
    public PictureView R;
    public boolean S;
    public String T;
    public RelativeLayout U;
    public TextView V;
    public ImageView W;
    public SeekBar X;
    public TextView Y;
    public ImageView Z;

    /* renamed from: a0, reason: collision with root package name */
    public Runnable f281949a0;

    /* renamed from: b0, reason: collision with root package name */
    public TextView f281950b0;

    /* renamed from: c0, reason: collision with root package name */
    private ImageView f281951c0;

    /* renamed from: d0, reason: collision with root package name */
    public TextView f281952d0;

    /* renamed from: e0, reason: collision with root package name */
    public String f281953e0;

    /* renamed from: f0, reason: collision with root package name */
    private Intent f281954f0;

    /* renamed from: g0, reason: collision with root package name */
    private f f281955g0;

    /* renamed from: h0, reason: collision with root package name */
    MessageQueue.IdleHandler f281956h0;

    /* renamed from: i0, reason: collision with root package name */
    private Runnable f281957i0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class a implements ShareActionSheet.OnItemClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AIOFilePictureData f281962d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ File f281963e;

        a(AIOFilePictureData aIOFilePictureData, File file) {
            this.f281962d = aIOFilePictureData;
            this.f281963e = file;
        }

        @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
        public void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
            boolean z16;
            boolean z17;
            if (actionSheetItem != null) {
                AIOFilePictureView aIOFilePictureView = AIOFilePictureView.this;
                if (aIOFilePictureView.f282077h instanceof Activity) {
                    aIOFilePictureView.f282075e.dismiss();
                    int i3 = actionSheetItem.action;
                    if (i3 != 2) {
                        if (i3 != 6) {
                            if (i3 != 9) {
                                if (i3 == 39) {
                                    AIOFilePictureView.this.k0(this.f281963e, this.f281962d);
                                    AIOBrowserPresenter aIOBrowserPresenter = AIOFilePictureView.this.Q.f281859e;
                                    if (aIOBrowserPresenter != null) {
                                        aIOBrowserPresenter.P(1);
                                    }
                                } else if (i3 != 52) {
                                    if (i3 != 64) {
                                        if (i3 == 94) {
                                            AIOFilePictureView.this.z0(200);
                                            AIOBrowserPresenter aIOBrowserPresenter2 = AIOFilePictureView.this.f282074d.f281859e;
                                            if (aIOBrowserPresenter2 != null) {
                                                aIOBrowserPresenter2.P(2);
                                            }
                                        } else if (i3 != 121) {
                                            if (i3 != 132) {
                                                if (i3 != 166) {
                                                    if (i3 != 26) {
                                                        if (i3 != 27) {
                                                            if (i3 != 72) {
                                                                if (i3 != 73) {
                                                                    switch (i3) {
                                                                        case 54:
                                                                            String i16 = h.a().i();
                                                                            if (TextUtils.isEmpty(i16)) {
                                                                                i16 = h.a().g();
                                                                            }
                                                                            String str = i16;
                                                                            IMsgLocationApi iMsgLocationApi = (IMsgLocationApi) QRoute.api(IMsgLocationApi.class);
                                                                            Activity activity = (Activity) AIOFilePictureView.this.f282077h;
                                                                            int f16 = h.a().f();
                                                                            String g16 = h.a().g();
                                                                            AIOFilePictureData aIOFilePictureData = this.f281962d;
                                                                            iMsgLocationApi.jumpToTargetNTAIOPosition(activity, f16, g16, str, aIOFilePictureData.shmsgseq, aIOFilePictureData.msgId);
                                                                            AIOBrowserPresenter aIOBrowserPresenter3 = AIOFilePictureView.this.f282074d.f281859e;
                                                                            if (aIOBrowserPresenter3 != null) {
                                                                                aIOBrowserPresenter3.P(4);
                                                                                break;
                                                                            }
                                                                            break;
                                                                        case 55:
                                                                            AIOFilePictureView.this.j0(this.f281962d, 1);
                                                                            ReportController.o(null, "P_CliOper", "qrcode", "", "0X80059A4", "0X80059A4", 0, 0, "", "", "", "");
                                                                            break;
                                                                        case 56:
                                                                            AIOFilePictureView.this.j0(this.f281962d, 2);
                                                                            break;
                                                                    }
                                                                }
                                                            } else {
                                                                int i17 = actionSheetItem.uinType;
                                                                String str2 = actionSheetItem.uin;
                                                                if (i17 == 10014) {
                                                                    Context context = AIOFilePictureView.this.f282077h;
                                                                    QQToast.makeText(context, context.getString(R.string.zzd), 0).show();
                                                                    return;
                                                                } else if (AIOFilePictureView.this.Z() && AIOFilePictureView.this.f281955g0 != null) {
                                                                    f fVar = AIOFilePictureView.this.f281955g0;
                                                                    AIOFilePictureData aIOFilePictureData2 = this.f281962d;
                                                                    Intent u16 = fVar.u(aIOFilePictureData2.msgId, aIOFilePictureData2.subId, 0);
                                                                    if (this.f281962d.istroop == 1) {
                                                                        z17 = true;
                                                                    } else {
                                                                        z17 = false;
                                                                    }
                                                                    ((IFileDepend) QRoute.api(IFileDepend.class)).forwardToTargetFriend((Activity) AIOFilePictureView.this.f282077h, u16, z17, str2, i17);
                                                                }
                                                            }
                                                        } else if (AIOFilePictureView.this.Z() && AIOFilePictureView.this.f281955g0 != null) {
                                                            AIOFilePictureView.this.f281955g0.f(this.f281962d.msgId);
                                                            Context context2 = AIOFilePictureView.this.f282077h;
                                                            QQToast.makeText(context2, context2.getString(R.string.f221626bb), 0).show();
                                                        }
                                                    } else if (AIOFilePictureView.this.Z() && AIOFilePictureView.this.f281955g0 != null) {
                                                        AIOFilePictureView.this.f281955g0.m(this.f281962d.msgId);
                                                        ReportController.o(null, "dc00898", "", "", "0X800A60E", "0X800A60E", 0, 0, "", "", "", "");
                                                        Context context3 = AIOFilePictureView.this.f282077h;
                                                        QQToast.makeText(context3, 2, context3.getString(R.string.f221616ba), 0).show();
                                                    }
                                                } else {
                                                    ((IMiniAppFileMaterialService) QRoute.api(IMiniAppFileMaterialService.class)).showSupportedAppList((Activity) AIOFilePictureView.this.f282077h, this.f281963e.getAbsolutePath(), "image/*");
                                                }
                                            } else {
                                                QbSdk.clearDefaultBrowser(AIOFilePictureView.this.f282077h, this.f281963e.getPath());
                                                ah.r1((Activity) AIOFilePictureView.this.f282077h, this.f281963e.getPath());
                                            }
                                        } else if (AIOFilePictureView.this.Z() && AIOFilePictureView.this.f281955g0 != null) {
                                            AIOFilePictureView.this.f281955g0.G(this.f281962d.msgId);
                                        }
                                    } else {
                                        ah.r1((Activity) AIOFilePictureView.this.f282077h, this.f281963e.getPath());
                                    }
                                } else {
                                    IOCR iocr = (IOCR) QRoute.api(IOCR.class);
                                    Activity activity2 = (Activity) AIOFilePictureView.this.f282077h;
                                    String absolutePath = this.f281963e.getAbsolutePath();
                                    AIOFilePictureData aIOFilePictureData3 = this.f281962d;
                                    iocr.startOcrPerformFragment(activity2, absolutePath, 1, aIOFilePictureData3.istroop, aIOFilePictureData3.J, false);
                                    AIOBrowserPresenter aIOBrowserPresenter4 = AIOFilePictureView.this.f282074d.f281859e;
                                    if (aIOBrowserPresenter4 != null) {
                                        aIOBrowserPresenter4.P(5);
                                    }
                                }
                            } else {
                                ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).sharePicToWXFromPeak(this.f281963e.getPath(), AIOFilePictureView.this.f282077h);
                                ReportController.o(null, "dc00898", "", "", "0X800A4FF", "0X800A4FF", 0, 0, "", "", "", "");
                            }
                        } else {
                            if (AIOFilePictureView.this.Z() && AIOFilePictureView.this.f281955g0 != null) {
                                AIOFilePictureView.this.f281955g0.d(this.f281962d.msgId);
                            }
                            AIOBrowserPresenter aIOBrowserPresenter5 = AIOFilePictureView.this.f282074d.f281859e;
                            if (aIOBrowserPresenter5 != null) {
                                aIOBrowserPresenter5.P(3);
                            }
                        }
                        String W0 = AIOPictureView.W0(this.f281962d);
                        String V0 = AIOPictureView.V0();
                        QLog.i("AIOGalleryFilePicView", 2, "reportClickEvent 0X8009EF7 sessionType=" + W0 + "enterType=" + V0);
                        ReportController.o(null, "dc00898", "", "", "0X8009EF7", "0X8009EF7", AIOFilePictureView.this.i0(actionSheetItem.action), 0, W0, V0, "", "");
                    }
                    if (AIOFilePictureView.this.Z() && AIOFilePictureView.this.f281955g0 != null) {
                        f fVar2 = AIOFilePictureView.this.f281955g0;
                        AIOFilePictureData aIOFilePictureData4 = this.f281962d;
                        Intent u17 = fVar2.u(aIOFilePictureData4.msgId, aIOFilePictureData4.subId, 0);
                        if (this.f281962d.istroop == 1) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).forwardToFriend((Activity) AIOFilePictureView.this.f282077h, u17, z16, ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).getSharePanelType(), "");
                    }
                    String W02 = AIOPictureView.W0(this.f281962d);
                    String V02 = AIOPictureView.V0();
                    QLog.i("AIOGalleryFilePicView", 2, "reportClickEvent 0X8009EF7 sessionType=" + W02 + "enterType=" + V02);
                    ReportController.o(null, "dc00898", "", "", "0X8009EF7", "0X8009EF7", AIOFilePictureView.this.i0(actionSheetItem.action), 0, W02, V02, "", "");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class b extends QQPermission.BasePermissionsListener {
        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class d extends IBrowserViewHolder {

        /* renamed from: a, reason: collision with root package name */
        public BrowserScaleView f281971a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f281972b;

        /* renamed from: c, reason: collision with root package name */
        public ImageView f281973c;

        d() {
        }
    }

    public AIOFilePictureView(Context context, com.tencent.mobileqq.richmediabrowser.presenter.b bVar) {
        super(context, bVar);
        this.S = false;
        this.f281956h0 = new MessageQueue.IdleHandler() { // from class: com.tencent.mobileqq.richmediabrowser.view.AIOFilePictureView.4
            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                AIOFilePictureData T = AIOFilePictureView.this.Q.T();
                if (T != null) {
                    tm2.b bVar2 = new tm2.b();
                    if (bVar2.e(T, 4) && bVar2.c(T, 4) == null) {
                        if (T.E && com.tencent.mobileqq.service.message.remote.a.b(T.H)) {
                            AIOFilePictureView.this.x0(true);
                            AIOFilePictureView.this.updateUI();
                        } else if (T.G) {
                            AIOFilePictureView.this.x0(false);
                        } else {
                            AIOFilePictureView.this.x0(true);
                        }
                        AIOFilePictureView aIOFilePictureView = AIOFilePictureView.this;
                        aIOFilePictureView.t0(String.format(Locale.CHINA, aIOFilePictureView.f282077h.getString(R.string.f221806bt), ao.a(T.F)));
                    }
                }
                return false;
            }
        };
        this.f281957i0 = new Runnable() { // from class: com.tencent.mobileqq.richmediabrowser.view.AIOFilePictureView.6
            @Override // java.lang.Runnable
            public void run() {
                AIOFilePictureView.this.y0();
            }
        };
        this.Q = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0(RichMediaBrowserInfo richMediaBrowserInfo, String str, URLDrawable uRLDrawable, int i3) {
        int i16;
        ConcurrentHashMap<Integer, URLDrawable> concurrentHashMap;
        try {
            i16 = JpegExifReader.readOrientation(str);
        } catch (Exception e16) {
            BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "read exif error" + e16.getMessage());
            i16 = 0;
        }
        BrowserBasePresenter browserBasePresenter = this.Q.f281861h;
        if (browserBasePresenter != null && (concurrentHashMap = browserBasePresenter.mActiveDrawable) != null) {
            concurrentHashMap.put(Integer.valueOf(i3), uRLDrawable);
        }
        this.R.imageView.initDrawable(uRLDrawable, this.J, this.K, com.tencent.richmediabrowser.utils.a.a(i16));
        this.Q.f281861h.onLoadFinish(i3, true);
    }

    private boolean X() {
        if ((g0() == null && h.a().s()) || !com.tencent.mobileqq.richmediabrowser.utils.h.a() || ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).saveImageNeedBlock()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(Uri uri, ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList, ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList2) {
        Context context = this.f282077h;
        if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
            RelativeLayout relativeLayout = this.R.mBrowserItemView;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Z() {
        f fVar = this.f281955g0;
        if (fVar != null && fVar.n()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a0(GalleryUrlImageView galleryUrlImageView) {
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "dealDefaultImage()");
        galleryUrlImageView.setImageDrawable(com.tencent.mobileqq.urldrawable.b.f306350a);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b0(AIOFilePictureData aIOFilePictureData, GalleryUrlImageView galleryUrlImageView) {
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "dealErrorImage()");
        if (!aIOFilePictureData.f281836m) {
            return false;
        }
        Drawable drawable = BaseApplication.getContext().getResources().getDrawable(R.drawable.mzb);
        galleryUrlImageView.setImageDrawable(drawable);
        this.R.imageView.initDrawable(drawable, this.J, this.K, 0);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void c0(RichMediaBrowserInfo richMediaBrowserInfo, AIOFilePictureData aIOFilePictureData, File file, int i3) {
        URLDrawable uRLDrawable;
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestWidth = this.J;
        obtain.mRequestHeight = this.K;
        obtain.mLoadingDrawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        obtain.mPlayGifImage = true;
        int i16 = 0;
        obtain.mUseExifOrientation = false;
        try {
            uRLDrawable = URLDrawable.getDrawable(file, obtain);
            try {
                uRLDrawable.setTag(1);
                uRLDrawable.downloadImediatly();
            } catch (Throwable unused) {
                BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "[getView] URLDrawable.getDrawable failed.");
                if (uRLDrawable != null) {
                }
                if (uRLDrawable == null) {
                }
                if (!e0(aIOFilePictureData, this.R.imageView)) {
                    a0(this.R.imageView);
                }
                f0(aIOFilePictureData.msgId, aIOFilePictureData.subId, 2);
            }
        } catch (Throwable unused2) {
            uRLDrawable = null;
        }
        if (uRLDrawable != null) {
            this.Q.f281861h.mActiveDrawable.put(Integer.valueOf(i3), uRLDrawable);
        }
        if (uRLDrawable == null && uRLDrawable.getStatus() == 1) {
            try {
                i16 = JpegExifReader.readOrientation(file.getAbsolutePath());
            } catch (Exception e16) {
                BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "read exif error" + e16.getMessage());
            }
            this.R.imageView.setImageDrawable(uRLDrawable);
            this.R.imageView.initDrawable(uRLDrawable, this.J, this.K, com.tencent.richmediabrowser.utils.a.a(i16));
            this.Q.f281861h.onLoadFinish(i3, true);
            return;
        }
        if (!e0(aIOFilePictureData, this.R.imageView) && !b0(aIOFilePictureData, this.R.imageView)) {
            a0(this.R.imageView);
        }
        f0(aIOFilePictureData.msgId, aIOFilePictureData.subId, 2);
    }

    private void d0(RichMediaBrowserInfo richMediaBrowserInfo, AIOFilePictureData aIOFilePictureData, tm2.b bVar, File file, int i3) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestWidth = this.J;
        obtain.mRequestHeight = this.K;
        URLDrawable uRLDrawable = null;
        if (bVar.c(aIOFilePictureData, 1) != null) {
            URLDrawable fileDrawable = URLDrawable.getFileDrawable(aIOFilePictureData.f281832e, null);
            fileDrawable.downloadImediatly();
            obtain.mLoadingDrawable = fileDrawable;
        } else {
            obtain.mLoadingDrawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        }
        obtain.mPlayGifImage = true;
        obtain.mUseExifOrientation = false;
        try {
            uRLDrawable = URLDrawable.getFileDrawable(file.getAbsolutePath(), obtain);
        } catch (Throwable unused) {
            BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "[getView] URLDrawable.getDrawable failed.");
        }
        URLDrawable uRLDrawable2 = uRLDrawable;
        if (uRLDrawable2 != null) {
            uRLDrawable2.setTag(1);
            this.Q.f281861h.mActiveDrawable.put(Integer.valueOf(i3), uRLDrawable2);
            String absolutePath = file.getAbsolutePath();
            this.R.imageView.setGalleryImageListener(new c(richMediaBrowserInfo, absolutePath, uRLDrawable2, aIOFilePictureData));
            Runnable g16 = RichMediaBrowserUtils.g(this.Z, uRLDrawable2);
            this.f281949a0 = g16;
            if (g16 == null && uRLDrawable2.getStatus() == 1) {
                A0(richMediaBrowserInfo, absolutePath, uRLDrawable2, i3);
            } else {
                this.R.imageView.initDrawable(uRLDrawable2, this.J, this.K, com.tencent.richmediabrowser.utils.a.a(uRLDrawable2.getExifOrientation()));
            }
            this.R.imageView.setImageDrawable(uRLDrawable2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e0(AIOFilePictureData aIOFilePictureData, GalleryUrlImageView galleryUrlImageView) {
        URLDrawable uRLDrawable;
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "dealThumbImage()");
        tm2.b bVar = new tm2.b();
        if (bVar.c(aIOFilePictureData, 1) != null) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
            obtain.mLoadingDrawable = drawable;
            obtain.mFailedDrawable = drawable;
            try {
                uRLDrawable = URLDrawable.getDrawable(bVar.c(aIOFilePictureData, 1), obtain);
                try {
                    uRLDrawable.downloadImediatly();
                } catch (Exception e16) {
                    e = e16;
                    BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "dealTempImage() exception = " + e.getMessage());
                    if (uRLDrawable != null) {
                        uRLDrawable.setTag(1);
                        galleryUrlImageView.setImageDrawable(uRLDrawable);
                        this.R.imageView.initDrawable(uRLDrawable, this.J, this.K, 0);
                        BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "set thumb image");
                        return true;
                    }
                    return false;
                }
            } catch (Exception e17) {
                e = e17;
                uRLDrawable = null;
            }
            if (uRLDrawable != null && uRLDrawable.getStatus() == 1) {
                uRLDrawable.setTag(1);
                galleryUrlImageView.setImageDrawable(uRLDrawable);
                this.R.imageView.initDrawable(uRLDrawable, this.J, this.K, 0);
                BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "set thumb image");
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0(long j3, int i3, int i16) {
        f fVar = this.f281955g0;
        if (fVar != null) {
            fVar.y(j3, i3, i16);
        }
        this.Q.R(j3, i3, 1);
    }

    private File g0() {
        BrowserBasePresenter browserBasePresenter;
        RichMediaBrowserInfo selectedItem;
        com.tencent.mobileqq.richmediabrowser.presenter.b bVar = this.Q;
        if (bVar != null && (browserBasePresenter = bVar.f281861h) != null && (selectedItem = browserBasePresenter.getSelectedItem()) != null) {
            RichMediaBaseData richMediaBaseData = selectedItem.baseData;
            if (richMediaBaseData instanceof AIOFilePictureData) {
                AIOFilePictureData aIOFilePictureData = (AIOFilePictureData) richMediaBaseData;
                tm2.b bVar2 = new tm2.b();
                File c16 = bVar2.c(aIOFilePictureData, 4);
                if (c16 == null) {
                    return bVar2.c(aIOFilePictureData, 2);
                }
                return c16;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int i0(int i3) {
        if (i3 != 2) {
            if (i3 != 6) {
                if (i3 == 27) {
                    return 6;
                }
                if (i3 == 39) {
                    return 2;
                }
                if (i3 != 52) {
                    if (i3 != 64) {
                        if (i3 != 121 && i3 != 132) {
                            switch (i3) {
                                case 54:
                                    return 7;
                                case 55:
                                    return 9;
                                case 56:
                                    return 10;
                                default:
                                    return -1;
                            }
                        }
                        return 13;
                    }
                    return 11;
                }
                return 8;
            }
            return 3;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0(AIOFilePictureData aIOFilePictureData, int i3) {
        String g16;
        Intent intent = new Intent();
        if (com.tencent.mobileqq.service.message.remote.a.b(aIOFilePictureData.H)) {
            g16 = h.a().m();
        } else {
            g16 = h.a().g();
        }
        ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).onQRDecodeSucceed(this.f282077h, this.T, aIOFilePictureData.f281831d, true, g16, null, null, aIOFilePictureData.I, i3, h.a().m(), h.a().g(), intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0(File file, AIOFilePictureData aIOFilePictureData) {
        if (file == null) {
            file = new tm2.b().c(aIOFilePictureData, 4);
        }
        if (file == null) {
            BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 1, "setItemClickListenerForFile: error, file is null.");
        } else if (!PermissionUtil.isHasStoragePermission(this.f282077h) && (this.f282077h instanceof Activity)) {
            QQPermissionFactory.getQQPermission((Activity) this.f282077h, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_RICH_MEDIA_SAVE, QQPermissionConstants.Business.SCENE.RICH_MEDIA_AIO_SAVE_PIC)).requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new b());
        } else {
            ((IFileDepend) QRoute.api(IFileDepend.class)).saveToAlbum(this.f282077h, file.getAbsolutePath());
        }
    }

    private boolean n0(AIOFilePictureData aIOFilePictureData) {
        if (aIOFilePictureData.f281831d != 10014) {
            return true;
        }
        return false;
    }

    private boolean o0(AIOFilePictureData aIOFilePictureData) {
        if (aIOFilePictureData.f281831d != 10014) {
            return true;
        }
        return false;
    }

    private void q0(RichMediaBrowserInfo richMediaBrowserInfo, RichMediaBrowserInfo richMediaBrowserInfo2) {
        RichMediaBaseData richMediaBaseData;
        if (richMediaBrowserInfo != null && (richMediaBaseData = richMediaBrowserInfo.baseData) != null && richMediaBaseData.getType() == 102 && ((AIOBrowserBaseData) richMediaBrowserInfo.baseData).msgId == ((AIOBrowserBaseData) richMediaBrowserInfo2.baseData).msgId && !richMediaBrowserInfo.isReport) {
            ReportController.o(null, "dc00898", "", "", "0X8009EF0", "0X8009EF0", 1, 0, "", "", "", "");
            richMediaBrowserInfo.isReport = true;
        } else {
            ReportController.o(null, "dc00898", "", "", "0X8009EF0", "0X8009EF0", 2, 0, "", "", "", "");
        }
    }

    private void w0() {
        AIOFilePictureData T = this.Q.T();
        if (T != null && new tm2.b().e(T, 4)) {
            if (T.F > 0) {
                t0(String.format(Locale.CHINA, this.f282077h.getString(R.string.f221806bt), ao.a(T.F)));
            } else {
                t0(this.f282077h.getString(R.string.f221776bq));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0(int i3) {
        ThreadManager.getUIHandler().postDelayed(this.f281957i0, i3);
    }

    @Override // com.tencent.mobileqq.richmediabrowser.view.a
    public void A(int i3) {
        super.A(i3);
        AIOFilePictureData T = this.Q.T();
        if (T != null) {
            tm2.b bVar = new tm2.b();
            File c16 = bVar.c(T, 4);
            if (c16 == null) {
                c16 = bVar.c(T, 2);
            }
            if (c16 == null) {
                c16 = bVar.c(T, 1);
            }
            if (c16 == null && h.a().s()) {
                return;
            }
            l0(T, c16, i3);
        }
    }

    public void B0(int i3, View view, boolean z16) {
        RichMediaBaseData richMediaBaseData;
        URLDrawable uRLDrawable;
        RichMediaBrowserInfo item = this.Q.f281861h.getItem(i3);
        if (item != null && (richMediaBaseData = item.baseData) != null && richMediaBaseData.getType() == 102 && this.R.mBrowserItemView != null && (view.getTag() instanceof d)) {
            d dVar = (d) view.getTag();
            BrowserScaleView browserScaleView = dVar.f281971a;
            ImageView imageView = dVar.f281973c;
            TextView textView = dVar.f281972b;
            AIOFilePictureData aIOFilePictureData = (AIOFilePictureData) item.baseData;
            tm2.b bVar = new tm2.b();
            imageView.setVisibility(8);
            textView.setVisibility(8);
            if (aIOFilePictureData.f281836m) {
                Drawable drawable = browserScaleView.getDrawable();
                String str = null;
                if (URLDrawable.class.isInstance(drawable)) {
                    uRLDrawable = (URLDrawable) drawable;
                    if (uRLDrawable != null) {
                        str = uRLDrawable.getURL().getRef();
                    }
                } else {
                    uRLDrawable = null;
                }
                if (str == null && FileUtils.fileExistsAndNotEmpty(aIOFilePictureData.f281832e)) {
                    URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                    Drawable drawable2 = com.tencent.mobileqq.urldrawable.b.f306350a;
                    obtain.mLoadingDrawable = drawable2;
                    obtain.mFailedDrawable = drawable2;
                    URLDrawable drawable3 = URLDrawable.getDrawable(new File(aIOFilePictureData.f281832e), obtain);
                    if (drawable3 != null) {
                        browserScaleView.setImageDrawable(drawable3);
                        drawable3.downloadImediatly();
                        return;
                    }
                    return;
                }
                if (uRLDrawable == null || str == null || (!DecoderType.DECODER_PART.equals(str) && !DecoderType.DECODER_DISPLAY.equals(str))) {
                    if (!((IFileDepend) QRoute.api(IFileDepend.class)).checkFileThumbOverSize(aIOFilePictureData.K, aIOFilePictureData.L, aIOFilePictureData.F) && aIOFilePictureData.M != 1) {
                        Drawable drawable4 = BaseApplication.getContext().getResources().getDrawable(R.drawable.mzb);
                        browserScaleView.setImageDrawable(drawable4);
                        browserScaleView.initDrawable(drawable4, this.J, this.K, 0);
                    } else {
                        Drawable drawable5 = BaseApplication.getContext().getResources().getDrawable(R.drawable.o0i);
                        imageView.setVisibility(0);
                        imageView.setImageDrawable(drawable5);
                        textView.setVisibility(0);
                        textView.setText(R.string.f221986ca);
                        this.Q.p().f();
                    }
                    this.Q.f281861h.onLoadFinish(i3, false);
                    return;
                }
                return;
            }
            if (bVar.c(aIOFilePictureData, 2) != null) {
                String d16 = bVar.d(aIOFilePictureData, 2);
                b(i3);
                String estimateFileType = FileUtils.estimateFileType(aIOFilePictureData.f281833f);
                BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "AIOGalleryAdapter.updateView(): Update large image, position=" + i3 + "url = " + d16 + ",extName = " + estimateFileType);
            }
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.view.a, e04.e
    public View a(View view, ViewGroup viewGroup) {
        this.H = (RelativeLayout) LayoutInflater.from(this.f282077h).inflate(R.layout.hnl, (ViewGroup) null);
        m0();
        TextView textView = new TextView(this.f282077h);
        this.f281950b0 = textView;
        textView.setTextSize(2, 8.0f);
        this.f281950b0.setTextColor(-1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(3, R.id.c28);
        layoutParams.addRule(14);
        layoutParams.topMargin = Utils.n(4.0f, this.f282077h.getResources());
        this.R.mBrowserItemView.addView(this.f281950b0, layoutParams);
        ImageView imageView = new ImageView(this.f282077h);
        this.f281951c0 = imageView;
        imageView.setId(R.id.c28);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(120, 120);
        layoutParams2.addRule(13);
        this.R.mBrowserItemView.addView(this.f281951c0, layoutParams2);
        this.f281950b0.setVisibility(8);
        this.f281951c0.setVisibility(8);
        RelativeLayout relativeLayout = this.R.controlViewContainer;
        if (relativeLayout == null) {
            return null;
        }
        relativeLayout.addView(this.H, new RelativeLayout.LayoutParams(-1, -1));
        return this.R.mBrowserItemView;
    }

    @Override // com.tencent.mobileqq.richmediabrowser.view.a, e04.e
    public void b(int i3) {
        RichMediaBaseData richMediaBaseData;
        String str;
        super.b(i3);
        this.Z.setVisibility(8);
        RichMediaBrowserInfo item = this.Q.f281861h.getItem(i3);
        if (item != null && (richMediaBaseData = item.baseData) != null && this.R.imageView != null) {
            if (richMediaBaseData.getType() == 102) {
                q0(this.Q.o(), item);
                AIOFilePictureData aIOFilePictureData = (AIOFilePictureData) item.baseData;
                tm2.b bVar = new tm2.b();
                this.R.imageView.setOnItemEventListener(this);
                this.R.imageView.setPosition(i3);
                this.R.imageView.setImageInfo(item);
                this.R.imageView.setIgnoreLayout(false);
                this.R.imageView.setContentDescription(this.f282077h.getString(R.string.f221766bp));
                URLDrawable uRLDrawable = this.Q.f281861h.mActiveDrawable.get(Integer.valueOf(i3));
                String d16 = bVar.d(aIOFilePictureData, 4);
                String d17 = bVar.d(aIOFilePictureData, 2);
                String d18 = bVar.d(aIOFilePictureData, 1);
                if (uRLDrawable != null && uRLDrawable.getURL() != null) {
                    str = uRLDrawable.getURL().toString();
                } else {
                    str = "";
                }
                if (uRLDrawable != null && uRLDrawable.getStatus() == 1 && !TextUtils.isEmpty(str) && (str.equals(d16) || str.equals(d17) || str.equals(d18))) {
                    this.R.imageView.setImageDrawable(uRLDrawable);
                    String d19 = bVar.d(aIOFilePictureData, 4);
                    String url = uRLDrawable.getURL().toString();
                    this.Q.f281861h.onLoadFinish(i3, true);
                    if (url.equals(d19)) {
                        this.R.imageView.setOriginalImage(true);
                    }
                    this.R.imageView.initDrawable(uRLDrawable, this.J, this.K, com.tencent.richmediabrowser.utils.a.a(JpegExifReader.readOrientation(uRLDrawable.getURL().getFile())));
                } else {
                    File c16 = bVar.c(aIOFilePictureData, 4);
                    if (c16 != null) {
                        d0(item, aIOFilePictureData, bVar, c16, i3);
                    } else {
                        File c17 = bVar.c(aIOFilePictureData, 2);
                        if (c17 != null) {
                            c0(item, aIOFilePictureData, c17, i3);
                        } else if (bVar.c(aIOFilePictureData, 1) != null) {
                            if (!e0(aIOFilePictureData, this.R.imageView) && !b0(aIOFilePictureData, this.R.imageView)) {
                                a0(this.R.imageView);
                            }
                            f0(aIOFilePictureData.msgId, aIOFilePictureData.subId, 2);
                            BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "getView(): url is " + bVar.d(aIOFilePictureData, 1) + ", file type is 1");
                        } else if (!((IFileDepend) QRoute.api(IFileDepend.class)).checkFileThumbOverSize(aIOFilePictureData.K, aIOFilePictureData.L, aIOFilePictureData.F) && aIOFilePictureData.M != 1) {
                            if (aIOFilePictureData.f281836m) {
                                a0(this.R.imageView);
                            } else {
                                a0(this.R.imageView);
                                f0(aIOFilePictureData.msgId, aIOFilePictureData.subId, 2);
                            }
                            BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "getView(): No pic");
                        } else {
                            Drawable drawable = BaseApplication.getContext().getResources().getDrawable(R.drawable.o0i);
                            this.f281951c0.setVisibility(0);
                            this.f281951c0.setImageDrawable(drawable);
                            this.f281950b0.setVisibility(0);
                            this.f281950b0.setText(R.string.f221986ca);
                            this.Q.p().f();
                        }
                    }
                }
            }
            this.R.imageView.setMainBrowserPresenter(this.Q.f281861h.mainBrowserPresenter);
            d dVar = new d();
            PictureView pictureView = this.R;
            dVar.f281971a = pictureView.imageView;
            dVar.f281972b = this.f281950b0;
            dVar.f281973c = this.f281951c0;
            pictureView.mBrowserItemView.setTag(dVar);
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.view.a, c04.c
    public void g(f04.c cVar) {
        super.g(cVar);
        if (cVar instanceof PictureView) {
            this.R = (PictureView) cVar;
        }
        this.I.setPictureScaleEventListener(this);
    }

    @Override // com.tencent.mobileqq.richmediabrowser.view.a, e04.b
    public Rect getAnimationEndDstRect() {
        BrowserScaleView browserScaleView = this.R.imageView;
        if (browserScaleView != null) {
            RectF currentMatrixRectF = browserScaleView.getCurrentMatrixRectF();
            float f16 = currentMatrixRectF.bottom;
            int i3 = this.K;
            if (f16 <= i3) {
                i3 = (int) f16;
            }
            Rect rect = new Rect((int) currentMatrixRectF.left, (int) currentMatrixRectF.top, (int) currentMatrixRectF.right, i3);
            rect.offset((int) this.f282077h.getResources().getDimension(R.dimen.dbw), 0);
            return rect;
        }
        return super.getAnimationEndDstRect();
    }

    @Override // com.tencent.mobileqq.richmediabrowser.view.a, e04.e
    public void h(Intent intent) {
        super.h(intent);
        this.f281954f0 = intent;
        this.S = intent.getExtras().getBoolean(RichMediaBrowserConstants.EXTRA_OCR, false);
        AIOBrowserPresenter aIOBrowserPresenter = this.Q.f281859e;
        if (aIOBrowserPresenter != null && (aIOBrowserPresenter.getParamsBuilder().c() instanceof f)) {
            this.f281955g0 = (f) this.Q.f281859e.getParamsBuilder().c();
        }
    }

    public void l0(AIOFilePictureData aIOFilePictureData, final File file, int i3) {
        Intent U;
        Intent intent;
        if (this.f282077h != null && (intent = this.f281954f0) != null) {
            intent.putExtra("big_brother_source_key", "biz_src_jc_file");
        }
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        if (file != null) {
            RichMediaBrowserUtils.a(2, arrayList);
            if (((IBrowserDepend) QRoute.api(IBrowserDepend.class)).isPicShareToWXEnable() && ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).isFileSizeEnable(file)) {
                RichMediaBrowserUtils.a(9, arrayList);
            }
            if (o0(aIOFilePictureData)) {
                RichMediaBrowserUtils.a(27, arrayList);
            }
            RichMediaBrowserUtils.a(64, arrayList);
            RichMediaBrowserUtils.a(39, arrayList2);
            if (com.tencent.mobileqq.richmediabrowser.utils.h.a() && u0()) {
                RichMediaBrowserUtils.a(94, arrayList2);
            }
            if (n0(aIOFilePictureData)) {
                RichMediaBrowserUtils.a(6, arrayList2);
            }
            if (h.a().r() && !TextUtils.isEmpty(h.a().g())) {
                RichMediaBrowserUtils.a(54, arrayList2);
            }
            if (this.S) {
                RichMediaBrowserUtils.a(52, arrayList2);
            }
            ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.richmediabrowser.view.AIOFilePictureView.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (file != null) {
                            AIOFilePictureView.this.Y(Uri.parse("file://" + file.getAbsolutePath()), arrayList, arrayList2);
                        }
                    } catch (Exception e16) {
                        BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "add qr action sheet error: " + e16.getMessage());
                    }
                }
            });
            RichMediaBrowserUtils.a(121, arrayList2);
            Context context = this.f282077h;
            if (context != null && QbSdk.isInDefaultBrowser(context, file.getPath())) {
                RichMediaBrowserUtils.a(132, arrayList2);
            }
        } else if (h.a().r() && !TextUtils.isEmpty(h.a().g())) {
            RichMediaBrowserUtils.a(54, arrayList2);
        }
        s0(aIOFilePictureData, file);
        Context context2 = this.f282077h;
        if ((context2 instanceof Activity) && (U = this.Q.U(aIOFilePictureData, (Activity) context2)) != null) {
            this.f282075e.setIntentForStartForwardRecentActivity(U);
        }
        this.f282075e.setActionSheetItems(arrayList, arrayList2);
        this.f282075e.show();
    }

    @Override // com.tencent.mobileqq.richmediabrowser.view.a
    public void m(boolean z16) {
        super.m(z16);
        if (this.Q.n() != null && this.Q.n().l()) {
            this.Q.p().f281782d = false;
            return;
        }
        C(false);
        D(false);
        this.Q.p().g();
    }

    public void m0() {
        RelativeLayout relativeLayout = this.H;
        if (relativeLayout != null) {
            RelativeLayout relativeLayout2 = (RelativeLayout) relativeLayout.findViewById(R.id.f25360am);
            this.H = relativeLayout2;
            this.U = (RelativeLayout) relativeLayout2.findViewById(R.id.m7i);
            this.V = (TextView) this.H.findViewById(R.id.g27);
            this.W = (ImageView) this.H.findViewById(R.id.az_);
            this.X = (SeekBar) this.H.findViewById(R.id.ilm);
            this.Y = (TextView) this.H.findViewById(R.id.lgz);
            this.Z = (ImageView) this.H.findViewById(R.id.efm);
            this.W.setOnClickListener(this);
            ImageButton imageButton = (ImageButton) this.H.findViewById(R.id.gqp);
            this.C = imageButton;
            imageButton.setOnClickListener(this);
            ImageButton imageButton2 = (ImageButton) this.H.findViewById(R.id.f59282sa);
            this.D = imageButton2;
            imageButton2.setOnClickListener(this);
            TextView textView = (TextView) this.H.findViewById(R.id.gqs);
            this.f281952d0 = textView;
            textView.setOnClickListener(this);
            H(X());
            F(v0());
            ImageButton imageButton3 = (ImageButton) this.H.findViewById(R.id.cp5);
            this.E = imageButton3;
            if (imageButton3 != null) {
                imageButton3.setOnClickListener(this);
            }
            ImageButton imageButton4 = (ImageButton) this.H.findViewById(R.id.f59252s8);
            this.f282079m = imageButton4;
            if (imageButton4 != null) {
                imageButton4.setOnClickListener(this);
            }
            ImageButton imageButton5 = (ImageButton) this.H.findViewById(R.id.gqo);
            this.f282078i = imageButton5;
            imageButton5.setOnClickListener(this);
        }
        PictureView pictureView = this.R;
        if (pictureView != null && !pictureView.isInExitAnim) {
            C(true);
        }
        AIOBrowserPresenter aIOBrowserPresenter = this.f282074d.f281859e;
        if (aIOBrowserPresenter != null) {
            aIOBrowserPresenter.O();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BrowserBasePresenter browserBasePresenter;
        RichMediaBaseData richMediaBaseData;
        File g06;
        RichMediaBaseData richMediaBaseData2;
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.enc) {
            RichMediaBrowserInfo selectedItem = this.Q.f281861h.getSelectedItem();
            if (selectedItem != null && (richMediaBaseData2 = selectedItem.baseData) != null && richMediaBaseData2.getType() == 102) {
                this.Q.back();
            }
        } else if (id5 == R.id.az_) {
            AIOFilePictureData T = this.Q.T();
            if (T != null) {
                f fVar = this.f281955g0;
                if (fVar != null) {
                    fVar.A(T.msgId, T.subId, 4);
                }
                this.Q.R(T.msgId, T.subId, 0);
                updateUI();
            }
        } else if (id5 == R.id.gqo) {
            l();
        } else if (id5 == R.id.gqs) {
            p0();
        } else if (id5 == R.id.gqp) {
            y0();
            AIOBrowserPresenter aIOBrowserPresenter = this.Q.f281859e;
            if (aIOBrowserPresenter != null) {
                aIOBrowserPresenter.K();
            }
        } else if (id5 == R.id.f59282sa) {
            com.tencent.mobileqq.richmediabrowser.presenter.b bVar = this.Q;
            if (bVar != null && (browserBasePresenter = bVar.f281861h) != null) {
                RichMediaBrowserInfo selectedItem2 = browserBasePresenter.getSelectedItem();
                if (selectedItem2 != null && (richMediaBaseData = selectedItem2.baseData) != null && richMediaBaseData.getType() == 102 && (g06 = g0()) != null) {
                    k0(g06, (AIOFilePictureData) selectedItem2.baseData);
                }
                AIOBrowserPresenter aIOBrowserPresenter2 = this.Q.f281859e;
                if (aIOBrowserPresenter2 != null) {
                    aIOBrowserPresenter2.Q();
                }
            }
        } else if (id5 == R.id.f59252s8) {
            n();
        } else if (id5 == R.id.cp5) {
            if (QLog.isColorLevel()) {
                QLog.d("AIOGalleryFilePicView", 2, "onClick qq_gallery_danmaku_view ");
            }
            AIOFilePictureData T2 = this.Q.T();
            if (T2 != null && (this.f282077h instanceof Activity)) {
                ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).openMiniAioForDanmaku((Activity) this.f282077h, h.a().f(), h.a().i(), false, T2.shmsgseq, 0L);
            }
            this.Q.M();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.widget.ActionSheet.WatchDismissActions
    public void onDismissOperations() {
        this.Q.f281861h.updateSystemUIVisablity();
    }

    @Override // com.tencent.mobileqq.richmediabrowser.view.a, e04.b
    public void onEnterAnimationEnd() {
        super.onEnterAnimationEnd();
        Looper.myQueue().addIdleHandler(this.f281956h0);
        C(true);
        updateUI();
    }

    @Override // com.tencent.mobileqq.richmediabrowser.view.a, e04.b
    public void onEnterAnimationStart() {
        C(false);
    }

    @Override // com.tencent.mobileqq.richmediabrowser.view.a, e04.e
    public void onItemSelected(int i3) {
        super.onItemSelected(i3);
        b(i3);
        AIOFilePictureData T = this.Q.T();
        BrowserScaleView browserScaleView = this.R.imageView;
        if (browserScaleView != null) {
            Drawable drawable = browserScaleView.getDrawable();
            if (T != null && !this.R.imageView.isOriginalImage() && (drawable instanceof SkinnableBitmapDrawable) && T.istroop == 1 && T.size > ((IFMConfig) QRoute.api(IFMConfig.class)).getMaxCreateThumbFileSize()) {
                this.R.imageView.setDoubleTapEnable(false);
                this.R.imageView.setScaleEnable(false);
            }
        }
        if (T != null) {
            tm2.b bVar = new tm2.b();
            if (bVar.c(T, 4) == null && bVar.c(T, 2) == null && bVar.c(T, 1) == null && (((IFileDepend) QRoute.api(IFileDepend.class)).checkFileThumbOverSize(T.K, T.L, T.F) || T.M == 1)) {
                this.Q.p().f();
            }
        }
        updateUI();
    }

    public void p0() {
        f fVar;
        AIOFilePictureData T = this.Q.T();
        if (T != null && (fVar = this.f281955g0) != null && fVar.n()) {
            if (!NetworkUtil.isNetSupport(this.f282077h)) {
                Context context = this.f282077h;
                QQToast.makeText(context, context.getString(R.string.f221746bn), 0).show();
                updateUI();
                return;
            }
            if (T.E) {
                Context context2 = this.f282077h;
                QQToast.makeText(context2, context2.getString(R.string.f221636bc), 0).show();
                updateUI();
                return;
            }
            if (T.G) {
                updateUI();
            }
            ((IFMConfig) QRoute.api(IFMConfig.class)).getFlowDialogSize();
            this.Q.R(T.msgId, T.subId, 3);
            this.f281955g0.y(T.msgId, T.subId, 4);
            BrowserScaleView browserScaleView = this.R.imageView;
            if (browserScaleView != null) {
                browserScaleView.setDoubleTapEnable(true);
                this.R.imageView.setScaleEnable(true);
            }
            o();
            this.Q.p().f();
            updateUI();
        }
    }

    public void r0(boolean z16) {
        ImageButton imageButton = this.C;
        if (imageButton != null) {
            imageButton.setEnabled(z16);
        }
    }

    public void s0(AIOFilePictureData aIOFilePictureData, File file) {
        this.f282075e.setItemClickListenerV2(new a(aIOFilePictureData, file));
    }

    @Override // com.tencent.mobileqq.richmediabrowser.view.a
    public void t() {
        super.t();
        this.f281955g0 = null;
        PictureView pictureView = this.R;
        if (pictureView != null) {
            pictureView.onDestroy();
        }
        ThreadManager.getUIHandler().removeCallbacks(this.f281957i0);
    }

    public void t0(String str) {
        TextView textView = this.f281952d0;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public boolean u0() {
        boolean z16;
        if (!this.f281954f0.getBooleanExtra(RichMediaBrowserConstants.EXTRA_FROM_AIO, false) && h.a().c() != 3 && h.a().c() != 2) {
            z16 = false;
        } else {
            z16 = true;
        }
        Bundle extras = this.f281954f0.getExtras();
        if ((!z16 && (h.a().c() != 4 || !extras.getBoolean(RichMediaBrowserConstants.KEY_ALLOW_FORWARD_PHOTO_PREVIEW_EDIT, false))) || com.tencent.imcore.message.ao.c(h.a().f()) == 1032 || com.tencent.imcore.message.ao.c(h.a().f()) == 1044) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.richmediabrowser.view.a, e04.e
    public void updateUI() {
        super.updateUI();
        AIOFilePictureData T = this.Q.T();
        if (T != null) {
            int i3 = T.status;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 3) {
                        BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "updateUI status is error, status = " + T.status);
                        return;
                    }
                    BrowserBasePresenter browserBasePresenter = this.Q.f281861h;
                    browserBasePresenter.onLoadFinish(browserBasePresenter.getSelectedIndex(), true);
                    x0(false);
                    G(false);
                    F(false);
                    E(false);
                    this.V.setText(this.f282077h.getString(R.string.f221596b9) + (T.progress / 100) + "%");
                    this.X.setProgress(T.progress / 100);
                    this.U.setVisibility(0);
                    return;
                }
                x0(false);
                G(false);
                F(false);
                E(false);
                BrowserBasePresenter browserBasePresenter2 = this.Q.f281861h;
                browserBasePresenter2.onLoadStart(browserBasePresenter2.getSelectedIndex(), T.progress);
                return;
            }
            this.U.setVisibility(8);
            G(z());
            E(y(this.Q.f281861h.getSelectedItem()));
            x0(!FileUtils.fileExistsAndNotEmpty(T.f281834h));
            F(v0());
            H(X());
            tm2.b bVar = new tm2.b();
            if (T.F > 10485760) {
                r0(false);
            } else if (bVar.c(T, 2) == null && bVar.c(T, 4) == null) {
                r0(false);
            } else {
                r0(true);
            }
            BrowserBasePresenter browserBasePresenter3 = this.Q.f281861h;
            browserBasePresenter3.onLoadFinish(browserBasePresenter3.getSelectedIndex(), true);
        }
    }

    public boolean v0() {
        if (com.tencent.mobileqq.richmediabrowser.utils.h.a()) {
            return false;
        }
        return u0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.richmediabrowser.view.a
    public void x(int i3, int i16) {
        BrowserScaleView browserScaleView;
        super.x(i3, i16);
        PictureView pictureView = this.R;
        if (pictureView != null && (browserScaleView = pictureView.imageView) != null && browserScaleView.getDrawable() != null) {
            URLDrawable.clearMemoryCache();
            BrowserScaleView browserScaleView2 = this.R.imageView;
            browserScaleView2.initDrawable(browserScaleView2.getDrawable(), i3, i16, 0);
            this.R.imageView.reset();
        }
    }

    public void x0(boolean z16) {
        int i3;
        if (this.f281952d0 != null) {
            if (z16) {
                w0();
            }
            TextView textView = this.f281952d0;
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            textView.setVisibility(i3);
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.view.a
    public boolean y(RichMediaBrowserInfo richMediaBrowserInfo) {
        return super.y(richMediaBrowserInfo);
    }

    void y0() {
        int i3;
        int i16;
        int i17;
        boolean z16;
        boolean z17;
        int i18;
        ForwardFileInfo forwardFileInfo;
        f fVar;
        Intent u16;
        AIOFilePictureData T = this.Q.T();
        if (T != null) {
            tm2.b bVar = new tm2.b();
            File c16 = bVar.c(T, 4);
            if (c16 == null) {
                c16 = bVar.c(T, 2);
            }
            if (c16 == null) {
                c16 = bVar.c(T, 1);
            }
            if (c16 == null) {
                return;
            }
            this.f281953e0 = c16.getAbsolutePath();
            int i19 = 19000;
            switch (h.a().c()) {
                case 1:
                    i3 = 126;
                    i17 = i3;
                    z16 = true;
                    z17 = true;
                    i18 = i19;
                    break;
                case 2:
                    i3 = 127;
                    i17 = i3;
                    z16 = true;
                    z17 = true;
                    i18 = i19;
                    break;
                case 3:
                    i3 = 128;
                    i17 = i3;
                    z16 = true;
                    z17 = true;
                    i18 = i19;
                    break;
                case 4:
                    i16 = 125;
                    i19 = 19002;
                    i17 = i16;
                    z16 = true;
                    z17 = false;
                    i18 = i19;
                    break;
                case 5:
                    i3 = 129;
                    i17 = i3;
                    z16 = true;
                    z17 = true;
                    i18 = i19;
                    break;
                case 6:
                    i16 = 130;
                    i17 = i16;
                    z16 = true;
                    z17 = false;
                    i18 = i19;
                    break;
                default:
                    i17 = 99;
                    z16 = false;
                    z17 = false;
                    i18 = 0;
                    break;
            }
            if (Z() && (fVar = this.f281955g0) != null && (u16 = fVar.u(T.msgId, T.subId, h.a().f())) != null) {
                u16.setExtrasClassLoader(ForwardFileInfo.class.getClassLoader());
                forwardFileInfo = (ForwardFileInfo) u16.getParcelableExtra("fileinfo");
            } else {
                forwardFileInfo = null;
            }
            ForwardFileInfo forwardFileInfo2 = forwardFileInfo;
            if (this.f282077h instanceof Activity) {
                ((IFileDepend) QRoute.api(IFileDepend.class)).startEditPicActivity((Activity) this.f282077h, i17, z16, z17, i18, c16.getAbsolutePath(), h.a().f(), forwardFileInfo2);
            }
            ReportController.o(null, "dc00898", "", "", "0X8007ACE", "0X8007ACE", 0, 0, "", "", "", "");
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.view.a
    public boolean z() {
        AIOFilePictureData T;
        if (super.z() && (T = this.Q.T()) != null) {
            tm2.b bVar = new tm2.b();
            File c16 = bVar.c(T, 4);
            if (c16 == null) {
                c16 = bVar.c(T, 2);
            }
            if ((c16 != null || !h.a().s()) && !h.a().s() && !h.a().q()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class c implements IGalleryImageListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RichMediaBrowserInfo f281966d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f281967e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ URLDrawable f281968f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ AIOFilePictureData f281969h;

        c(RichMediaBrowserInfo richMediaBrowserInfo, String str, URLDrawable uRLDrawable, AIOFilePictureData aIOFilePictureData) {
            this.f281966d = richMediaBrowserInfo;
            this.f281967e = str;
            this.f281968f = uRLDrawable;
            this.f281969h = aIOFilePictureData;
        }

        @Override // com.tencent.richmediabrowser.listener.IGalleryImageListener
        public void onLoadSuccessed(int i3, boolean z16) {
            AIOFilePictureView.this.Z.setVisibility(8);
            if (z16) {
                AIOFilePictureView.this.A0(this.f281966d, this.f281967e, this.f281968f, i3);
                return;
            }
            AIOFilePictureView aIOFilePictureView = AIOFilePictureView.this;
            if (!aIOFilePictureView.e0(this.f281969h, aIOFilePictureView.R.imageView)) {
                AIOFilePictureView aIOFilePictureView2 = AIOFilePictureView.this;
                if (!aIOFilePictureView2.b0(this.f281969h, aIOFilePictureView2.R.imageView)) {
                    AIOFilePictureView aIOFilePictureView3 = AIOFilePictureView.this;
                    aIOFilePictureView3.a0(aIOFilePictureView3.R.imageView);
                }
            }
            AIOFilePictureView aIOFilePictureView4 = AIOFilePictureView.this;
            AIOFilePictureData aIOFilePictureData = this.f281969h;
            aIOFilePictureView4.f0(aIOFilePictureData.msgId, aIOFilePictureData.subId, 2);
        }

        @Override // com.tencent.richmediabrowser.listener.IGalleryImageListener
        public void onLoadDrawable(int i3, URLDrawable uRLDrawable) {
        }
    }
}
