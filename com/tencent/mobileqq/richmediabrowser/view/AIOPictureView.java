package com.tencent.mobileqq.richmediabrowser.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.aelight.camera.qqstory.api.IJumpUtil;
import com.tencent.aelight.camera.util.api.ICaptureUtil;
import com.tencent.image.JpegExifReader;
import com.tencent.image.URLDrawable;
import com.tencent.image.Utils;
import com.tencent.imcore.message.ao;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.RichMediaBrowserConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.mini.api.IMiniAppFileMaterialService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msg.api.IFeatureSwitch;
import com.tencent.mobileqq.ocr.api.IOCR;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend;
import com.tencent.mobileqq.richmediabrowser.api.IShortVideoDepend;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;
import com.tencent.mobileqq.richmediabrowser.presenter.AIOBrowserPresenter;
import com.tencent.mobileqq.richmediabrowser.presenter.d;
import com.tencent.mobileqq.richmediabrowser.utils.RichMediaBrowserUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.wink.api.IQQWinkLauncher;
import com.tencent.mobileqq.wink.api.IWinkMediaHelper;
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
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.util.PermissionUtil;
import com.tencent.widget.ActionSheet;
import cooperation.peak.PeakConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.BaseActivity;
import mqq.app.MobileQQ;

/* loaded from: classes18.dex */
public class AIOPictureView extends com.tencent.mobileqq.richmediabrowser.view.a implements View.OnClickListener, ActionSheet.WatchDismissActions {
    private com.tencent.mobileqq.richmediabrowser.presenter.d Q;
    public PictureView R;
    private URLDrawable S;
    private int T;
    private Boolean U;
    public boolean V;
    public int W;
    public boolean X;
    public boolean Y;
    public String Z;

    /* renamed from: a0, reason: collision with root package name */
    public String f281995a0;

    /* renamed from: b0, reason: collision with root package name */
    public k f281996b0;

    /* renamed from: c0, reason: collision with root package name */
    public ArrayList<String> f281997c0;

    /* renamed from: d0, reason: collision with root package name */
    public RelativeLayout f281998d0;

    /* renamed from: e0, reason: collision with root package name */
    public TextView f281999e0;

    /* renamed from: f0, reason: collision with root package name */
    public ImageView f282000f0;

    /* renamed from: g0, reason: collision with root package name */
    public SeekBar f282001g0;

    /* renamed from: h0, reason: collision with root package name */
    public TextView f282002h0;

    /* renamed from: i0, reason: collision with root package name */
    public ImageView f282003i0;

    /* renamed from: j0, reason: collision with root package name */
    public Runnable f282004j0;

    /* renamed from: k0, reason: collision with root package name */
    public TextView f282005k0;

    /* renamed from: l0, reason: collision with root package name */
    public LinearLayout f282006l0;

    /* renamed from: m0, reason: collision with root package name */
    public TextView f282007m0;

    /* renamed from: n0, reason: collision with root package name */
    public long f282008n0;

    /* renamed from: o0, reason: collision with root package name */
    private Intent f282009o0;

    /* renamed from: p0, reason: collision with root package name */
    public com.tencent.mobileqq.richmediabrowser.f f282010p0;

    /* renamed from: q0, reason: collision with root package name */
    private final boolean f282011q0;

    /* renamed from: r0, reason: collision with root package name */
    MessageQueue.IdleHandler f282012r0;

    /* renamed from: s0, reason: collision with root package name */
    private Runnable f282013s0;

    /* loaded from: classes18.dex */
    class c implements k {
        c() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class d implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ActionSheet f282027d;

        d(ActionSheet actionSheet) {
            this.f282027d = actionSheet;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            if (view == null) {
                this.f282027d.dismiss();
                return;
            }
            String content = this.f282027d.getContent(i3);
            if (content == null) {
                this.f282027d.dismiss();
            } else if (TextUtils.isEmpty(content)) {
                this.f282027d.dismiss();
            } else {
                this.f282027d.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class e implements ShareActionSheet.OnItemClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AIOPictureData f282029d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ RichMediaBrowserInfo f282030e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ File f282031f;

        e(AIOPictureData aIOPictureData, RichMediaBrowserInfo richMediaBrowserInfo, File file) {
            this.f282029d = aIOPictureData;
            this.f282030e = richMediaBrowserInfo;
            this.f282031f = file;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
        public void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
            int i3;
            int i16 = actionSheetItem.action;
            if (i16 != 72) {
                AIOPictureView.this.f282075e.dismiss();
            }
            int i17 = 5;
            switch (i16) {
                case 2:
                case 72:
                case 73:
                    AIOPictureView.this.x0(i16, actionSheetItem, this.f282030e);
                    i3 = 1;
                    break;
                case 6:
                    AIOPictureView.this.g0(this.f282030e, this.f282031f);
                    AIOBrowserPresenter aIOBrowserPresenter = AIOPictureView.this.f282074d.f281859e;
                    i17 = 3;
                    if (aIOBrowserPresenter != null) {
                        aIOBrowserPresenter.P(3);
                    }
                    i3 = i17;
                    break;
                case 9:
                    ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).sharePicToWXFromPeak(this.f282031f.getPath(), AIOPictureView.this.f282077h);
                    ReportController.o(null, "dc00898", "", "", "0X800A4FF", "0X800A4FF", 0, 0, "", "", "", "");
                    i17 = 0;
                    i3 = i17;
                    break;
                case 27:
                    AIOPictureView.this.y0(this.f282029d);
                    i17 = 6;
                    i3 = i17;
                    break;
                case 39:
                    AIOPictureView.this.v0(this.f282029d, this.f282030e, this.f282031f, true);
                    i3 = 2;
                    break;
                case 48:
                    AIOPictureView.this.i0(this.f282029d);
                    i17 = 12;
                    i3 = i17;
                    break;
                case 50:
                    AIOPictureView.this.D0(this.f282030e);
                    i3 = 4;
                    break;
                case 51:
                    AIOPictureView.this.s0(this.f282029d);
                    i3 = i17;
                    break;
                case 52:
                    if (AIOPictureView.this.f282077h instanceof Activity) {
                        IOCR iocr = (IOCR) QRoute.api(IOCR.class);
                        Activity activity = (Activity) AIOPictureView.this.f282077h;
                        String absolutePath = this.f282031f.getAbsolutePath();
                        AIOPictureData aIOPictureData = this.f282029d;
                        iocr.startOcrPerformFragment(activity, absolutePath, 1, aIOPictureData.istroop, aIOPictureData.md5, false);
                    }
                    AIOBrowserPresenter aIOBrowserPresenter2 = AIOPictureView.this.f282074d.f281859e;
                    if (aIOBrowserPresenter2 != null) {
                        aIOBrowserPresenter2.P(5);
                    }
                    i17 = 8;
                    i3 = i17;
                    break;
                case 54:
                    AIOPictureView.this.t0(this.f282029d);
                    AIOBrowserPresenter aIOBrowserPresenter3 = AIOPictureView.this.f282074d.f281859e;
                    if (aIOBrowserPresenter3 != null) {
                        aIOBrowserPresenter3.P(4);
                    }
                    i17 = 7;
                    i3 = i17;
                    break;
                case 55:
                    Intent intent = new Intent();
                    intent.putExtra(AppConstants.Key.KEY_QR_SCAN_TROOP_ID, com.tencent.mobileqq.richmediabrowser.h.a().i());
                    IBrowserDepend iBrowserDepend = (IBrowserDepend) QRoute.api(IBrowserDepend.class);
                    AIOPictureView aIOPictureView = AIOPictureView.this;
                    Context context = aIOPictureView.f282077h;
                    String str = aIOPictureView.Z;
                    AIOPictureData aIOPictureData2 = this.f282029d;
                    iBrowserDepend.onQRDecodeSucceed(context, str, aIOPictureData2.istroop, aIOPictureData2.isFromFile, aIOPictureData2.sendUin, aIOPictureData2.md5, aIOPictureData2.picServerUrl, aIOPictureData2.uuid, 1, com.tencent.mobileqq.richmediabrowser.h.a().m(), com.tencent.mobileqq.richmediabrowser.h.a().g(), intent);
                    ReportController.o(null, "P_CliOper", "qrcode", "", "0X80059A4", "0X80059A4", 0, 0, "", "", "", "");
                    i17 = 9;
                    i3 = i17;
                    break;
                case 56:
                    Intent intent2 = new Intent();
                    IBrowserDepend iBrowserDepend2 = (IBrowserDepend) QRoute.api(IBrowserDepend.class);
                    AIOPictureView aIOPictureView2 = AIOPictureView.this;
                    Context context2 = aIOPictureView2.f282077h;
                    String str2 = aIOPictureView2.Z;
                    AIOPictureData aIOPictureData3 = this.f282029d;
                    iBrowserDepend2.onQRDecodeSucceed(context2, str2, aIOPictureData3.istroop, aIOPictureData3.isFromFile, aIOPictureData3.sendUin, aIOPictureData3.md5, aIOPictureData3.picServerUrl, aIOPictureData3.uuid, 2, com.tencent.mobileqq.richmediabrowser.h.a().m(), com.tencent.mobileqq.richmediabrowser.h.a().g(), intent2);
                    i17 = 10;
                    i3 = i17;
                    break;
                case 66:
                    AIOPictureView.this.u0(this.f282029d);
                    i17 = 0;
                    i3 = i17;
                    break;
                case 94:
                    AIOPictureView.this.m1(200);
                    AIOBrowserPresenter aIOBrowserPresenter4 = AIOPictureView.this.f282074d.f281859e;
                    if (aIOBrowserPresenter4 != null) {
                        aIOBrowserPresenter4.P(2);
                    }
                    i17 = 0;
                    i3 = i17;
                    break;
                case 166:
                    AIOPictureView.this.F0(this.f282031f);
                    i17 = 0;
                    i3 = i17;
                    break;
                case 171:
                    AIOPictureView.this.w0(i16, this.f282030e);
                    i17 = 0;
                    i3 = i17;
                    break;
                case 184:
                    AIOPictureView.this.E0(this.f282031f, this.f282029d);
                    i17 = 0;
                    i3 = i17;
                    break;
                default:
                    i17 = 0;
                    i3 = i17;
                    break;
            }
            String W0 = AIOPictureView.W0(this.f282029d);
            String V0 = AIOPictureView.V0();
            QLog.i("AIOPictureView", 2, "reportClickEvent 0X8009EF6 sessionType=" + W0 + "enterType=" + V0);
            ReportController.o(null, "dc00898", "", "", "0X8009EF6", "0X8009EF6", i3, 0, W0, V0, "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class f implements DialogInterface.OnCancelListener {
        f() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (AIOPictureView.this.X) {
                ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "6", "", "", "", "", 0, 0, 0, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class g extends QQPermission.BasePermissionsListener {
        g() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class h implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f282035d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Object f282036e;

        h(int i3, Object obj) {
            this.f282035d = i3;
            this.f282036e = obj;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (this.f282035d != 100) {
                BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "showSaveFileTips type = " + this.f282035d);
                return;
            }
            if (this.f282036e instanceof AIOPictureData) {
                AIOPictureView.this.Q.S((AIOPictureData) this.f282036e);
                AIOPictureView.this.updateUI();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class i implements DialogInterface.OnClickListener {
        i() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "showSaveFileTips cancel");
        }
    }

    /* loaded from: classes18.dex */
    public static class j extends IBrowserViewHolder {

        /* renamed from: a, reason: collision with root package name */
        public BrowserScaleView f282039a;
    }

    /* loaded from: classes18.dex */
    public interface k {
    }

    public AIOPictureView(Context context, com.tencent.mobileqq.richmediabrowser.presenter.d dVar) {
        super(context, dVar);
        this.T = -1;
        this.U = null;
        this.V = false;
        this.W = 1;
        this.Y = false;
        this.f281997c0 = new ArrayList<>();
        this.f282008n0 = 0L;
        this.f282012r0 = new MessageQueue.IdleHandler() { // from class: com.tencent.mobileqq.richmediabrowser.view.AIOPictureView.10
            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                AIOPictureData I0 = AIOPictureView.this.I0();
                tm2.d dVar2 = new tm2.d();
                if (I0 != null && dVar2.f(I0, 4) && dVar2.c(I0, 4) == null) {
                    AIOPictureView.this.j1(true);
                    AIOPictureView.this.updateUI();
                    return false;
                }
                return false;
            }
        };
        this.f282013s0 = new Runnable() { // from class: com.tencent.mobileqq.richmediabrowser.view.AIOPictureView.13
            @Override // java.lang.Runnable
            public void run() {
                AIOPictureView.this.l1();
            }
        };
        this.Q = dVar;
        this.f282011q0 = M0();
    }

    private boolean A0(AIOPictureData aIOPictureData, BrowserScaleView browserScaleView) {
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "dealTempImage()");
        tm2.d dVar = new tm2.d();
        if (dVar.c(aIOPictureData, 8) != null) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
            obtain.mLoadingDrawable = drawable;
            obtain.mFailedDrawable = drawable;
            obtain.mUseExifOrientation = false;
            URLDrawable uRLDrawable = null;
            try {
                uRLDrawable = URLDrawable.getDrawable(dVar.e(aIOPictureData, 8), obtain);
                uRLDrawable.downloadImediatly();
            } catch (Exception e16) {
                BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "dealTempImage() exception = " + e16.getMessage());
            }
            URLDrawable uRLDrawable2 = uRLDrawable;
            if (uRLDrawable2 != null && uRLDrawable2.getStatus() == 1) {
                uRLDrawable2.setTag(1);
                browserScaleView.setImageDrawable(uRLDrawable2);
                browserScaleView.initDrawable(uRLDrawable2, this.J, this.K, 0, this.f282011q0);
                BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "set temp image");
                return true;
            }
            BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "getView(): url is " + dVar.e(aIOPictureData, 8) + ", file type is 8");
        }
        return false;
    }

    private void B0(AIOPictureData aIOPictureData) {
        if (!C0(aIOPictureData, this.R.imageView) && !n0(aIOPictureData, this.R.imageView)) {
            l0(this.R.imageView);
        }
        G0(aIOPictureData.msgId, aIOPictureData.subId, 2);
    }

    private boolean C0(AIOPictureData aIOPictureData, GalleryUrlImageView galleryUrlImageView) {
        URLDrawable uRLDrawable;
        URLDrawable uRLDrawable2;
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "dealThumbImage()");
        File c16 = new tm2.d().c(aIOPictureData, 1);
        if (c16 != null) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
            obtain.mLoadingDrawable = drawable;
            obtain.mFailedDrawable = drawable;
            try {
                uRLDrawable = URLDrawable.getDrawable(c16, obtain);
            } catch (Exception e16) {
                e = e16;
                uRLDrawable = null;
            }
            try {
                uRLDrawable.downloadImediatly();
            } catch (Exception e17) {
                e = e17;
                BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "dealTempImage() exception = " + e.getMessage());
                uRLDrawable2 = uRLDrawable;
                return uRLDrawable2 == null ? false : false;
            }
            uRLDrawable2 = uRLDrawable;
            if (uRLDrawable2 == null && uRLDrawable2.getStatus() == 1) {
                uRLDrawable2.setTag(1);
                galleryUrlImageView.setImageDrawable(uRLDrawable2);
                this.R.imageView.initDrawable(uRLDrawable2, this.J, this.K, 0, this.f282011q0);
                BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "set thumb image");
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0(RichMediaBrowserInfo richMediaBrowserInfo) {
        com.tencent.mobileqq.richmediabrowser.f fVar = this.f282010p0;
        if (fVar != null) {
            fVar.b(RichMediaBrowserConstants.SINGLE_FORWARD_QZONE, 0);
        }
        if (richMediaBrowserInfo != null && (this.f282077h instanceof Activity)) {
            ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).fowardToQzoneAlbum((Activity) this.f282077h, com.tencent.mobileqq.richmediabrowser.h.a().m(), com.tencent.mobileqq.richmediabrowser.h.a().h(), this.W, richMediaBrowserInfo.baseData, this.V, com.tencent.mobileqq.richmediabrowser.h.a().i());
        }
        if (this.X) {
            ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "4", "", "", "", "", 0, 0, 0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0(File file, AIOPictureData aIOPictureData) {
        String i3;
        if (file != null && aIOPictureData != null && this.f282009o0 != null) {
            int i16 = aIOPictureData.istroop;
            if (i16 != 1) {
                if (i16 != 10014) {
                    i3 = "";
                } else {
                    i3 = com.tencent.mobileqq.richmediabrowser.h.a().j();
                }
            } else {
                i3 = com.tencent.mobileqq.richmediabrowser.h.a().i();
                if (TextUtils.isEmpty(i3)) {
                    i3 = com.tencent.mobileqq.richmediabrowser.h.a().g();
                }
            }
            String str = i3;
            ((IQQWinkLauncher) QRoute.api(IQQWinkLauncher.class)).innerBizShareToQCircle(this.f282077h, file.getAbsolutePath(), i16, str, this.f282009o0.getStringExtra(PeakConstants.KEY_TROOP_GROUP_NAME), Long.valueOf(aIOPictureData.shmsgseq));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0(File file) {
        if (this.f282077h instanceof Activity) {
            ((IMiniAppFileMaterialService) QRoute.api(IMiniAppFileMaterialService.class)).showSupportedAppList((Activity) this.f282077h, file.getAbsolutePath(), "image/*");
        }
    }

    private void G0(long j3, int i3, int i16) {
        com.tencent.mobileqq.richmediabrowser.f fVar = this.f282010p0;
        if (fVar != null) {
            fVar.y(j3, i3, i16);
        }
        this.Q.R(j3, i3, 1);
    }

    private File H0() {
        BrowserBasePresenter browserBasePresenter;
        RichMediaBrowserInfo selectedItem;
        com.tencent.mobileqq.richmediabrowser.presenter.d dVar = this.Q;
        if (dVar != null && (browserBasePresenter = dVar.f281861h) != null && (selectedItem = browserBasePresenter.getSelectedItem()) != null) {
            RichMediaBaseData richMediaBaseData = selectedItem.baseData;
            if (richMediaBaseData instanceof AIOPictureData) {
                AIOPictureData aIOPictureData = (AIOPictureData) richMediaBaseData;
                tm2.d dVar2 = new tm2.d();
                File c16 = dVar2.c(aIOPictureData, 4);
                if (c16 == null) {
                    return dVar2.c(aIOPictureData, 2);
                }
                return c16;
            }
        }
        return null;
    }

    private static int J0(String str) {
        try {
            return JpegExifReader.readOrientation(str);
        } catch (Exception e16) {
            BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "read exif error" + e16.getMessage());
            return 0;
        }
    }

    private static int K0(String str) {
        return com.tencent.richmediabrowser.utils.a.a(J0(str));
    }

    private boolean M0() {
        return ((IFeatureRuntimeService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("rich_media_browser_scale_image_to_full_screen", true);
    }

    private static boolean O0(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int lastIndexOf = str.lastIndexOf(":");
        if (lastIndexOf >= 0) {
            str = str.substring(lastIndexOf + 1);
        }
        return ((IPicHelper) QRoute.api(IPicHelper.class)).isImageExpired(str);
    }

    static void P0(String str) {
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 1, str);
    }

    private void Q0() {
        AIOPictureData I0 = I0();
        if (I0 != null && !TextUtils.isEmpty(I0.templateId) && (this.f282077h instanceof Activity)) {
            ((IJumpUtil) QRoute.api(IJumpUtil.class)).jumpToCameraActivityForAio((Activity) this.f282077h, I0.templateId);
            ReportController.o(null, "dc00898", "", "", "0X800A91F", "0X800A91F", 1, 0, "", "", I0.templateId, "");
        }
    }

    private void R0() {
        com.tencent.mobileqq.richmediabrowser.f fVar;
        AIOPictureData I0 = I0();
        if (I0 != null) {
            int i3 = I0.status;
            if (i3 != 1) {
                if (i3 != 3) {
                    if (i3 == 4 && (fVar = this.f282010p0) != null) {
                        fVar.A(I0.msgId, I0.subId, 24);
                    }
                } else {
                    com.tencent.mobileqq.richmediabrowser.f fVar2 = this.f282010p0;
                    if (fVar2 != null) {
                        fVar2.A(I0.msgId, I0.subId, 4);
                    }
                }
            } else {
                com.tencent.mobileqq.richmediabrowser.f fVar3 = this.f282010p0;
                if (fVar3 != null) {
                    fVar3.A(I0.msgId, I0.subId, 2);
                }
            }
            this.Q.R(I0.msgId, I0.subId, 0);
            updateUI();
        }
    }

    private void S0() {
        if (QLog.isColorLevel()) {
            QLog.d("AIOPictureView", 2, "onClick qq_gallery_danmaku_view ");
        }
        AIOPictureData I0 = I0();
        if (I0 != null && (this.f282077h instanceof Activity)) {
            ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).openMiniAioForDanmaku((Activity) this.f282077h, com.tencent.mobileqq.richmediabrowser.h.a().f(), com.tencent.mobileqq.richmediabrowser.h.a().i(), false, I0.shmsgseq, 0L);
        }
        this.Q.M();
    }

    private void U0(RichMediaBrowserInfo richMediaBrowserInfo, AIOPictureData aIOPictureData) {
        if (richMediaBrowserInfo != null) {
            RichMediaBaseData richMediaBaseData = richMediaBrowserInfo.baseData;
            if (richMediaBaseData instanceof AIOPictureData) {
                AIOPictureData aIOPictureData2 = (AIOPictureData) richMediaBaseData;
                if (aIOPictureData2.getType() == 100 && aIOPictureData2.msgId == aIOPictureData.msgId && aIOPictureData2.subId == aIOPictureData.subId && !richMediaBrowserInfo.isReport) {
                    ReportController.o(null, "dc00898", "", "", "0X8009EEF", "0X8009EEF", 1, 0, "", "", "", "");
                    richMediaBrowserInfo.isReport = true;
                } else {
                    ReportController.o(null, "dc00898", "", "", "0X8009EEF", "0X8009EEF", 2, 0, "", "", "", "");
                }
            }
        }
    }

    public static String V0() {
        try {
            int c16 = com.tencent.mobileqq.richmediabrowser.h.a().c();
            if (c16 == 1) {
                return "1";
            }
            if (c16 == 2) {
                return "3";
            }
            return "5";
        } catch (Exception e16) {
            QLog.i("AIOPictureView", 1, "reportBuildEnterType", e16);
            return "5";
        }
    }

    public static String W0(AIOBrowserBaseData aIOBrowserBaseData) {
        if (aIOBrowserBaseData == null) {
            return "4";
        }
        return String.valueOf(com.tencent.mobileqq.richmediabrowser.view.a.r(aIOBrowserBaseData.istroop));
    }

    private void b1(BrowserScaleView browserScaleView, AIOPictureData aIOPictureData, tm2.d dVar) {
        URLDrawable drawable = URLDrawable.getDrawable(dVar.e(aIOPictureData, 1), URLDrawable.URLDrawableOptions.obtain());
        browserScaleView.setImageDrawable(drawable);
        browserScaleView.initDrawable(drawable, this.J, this.K, 0, this.f282011q0);
    }

    private boolean d0() {
        if ((H0() == null && com.tencent.mobileqq.richmediabrowser.h.a().s()) || !com.tencent.mobileqq.richmediabrowser.utils.h.a() || ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).saveImageNeedBlock()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0(Uri uri, ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList, ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList2) {
        Context context = this.f282077h;
        if (((context instanceof Activity) && ((Activity) context).isFinishing()) || this.R == null) {
            return;
        }
        boolean z16 = this.f282077h instanceof Activity;
    }

    private void e1(AIOPictureData aIOPictureData, RichMediaBrowserInfo richMediaBrowserInfo) {
        Intent X;
        String str;
        tm2.d dVar = new tm2.d();
        File c16 = dVar.c(aIOPictureData, 4);
        if (c16 == null) {
            c16 = dVar.c(aIOPictureData, 2);
        }
        if (c16 == null && com.tencent.mobileqq.richmediabrowser.h.a().s()) {
            return;
        }
        if (c16 != null) {
            this.f281995a0 = c16.getPath();
        }
        ActionSheet createMenuSheet = ActionSheet.createMenuSheet(this.f282077h);
        if (ao.c(com.tencent.mobileqq.richmediabrowser.h.a().f()) != 1032) {
            ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList = new ArrayList<>();
            ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList2 = new ArrayList<>();
            if (c16 != null) {
                k0(arrayList, aIOPictureData, c16, arrayList2, c16);
            } else {
                if (com.tencent.mobileqq.richmediabrowser.utils.h.a() && c1()) {
                    RichMediaBrowserUtils.a(94, arrayList2);
                }
                if (!com.tencent.mobileqq.richmediabrowser.h.a().q() && com.tencent.mobileqq.richmediabrowser.h.a().r() && !TextUtils.isEmpty(com.tencent.mobileqq.richmediabrowser.h.a().g()) && ao.c(com.tencent.mobileqq.richmediabrowser.h.a().f()) != 1044) {
                    RichMediaBrowserUtils.a(54, arrayList2);
                }
            }
            if (aIOPictureData.imageBizType == 4 && !this.X && !aIOPictureData.isSend) {
                RichMediaBrowserUtils.a(66, arrayList2);
            }
            Y0(aIOPictureData, richMediaBrowserInfo, c16);
            Intent intent = this.f282009o0;
            if (intent != null) {
                if (this.X) {
                    str = "biz_src_jc_groupgif";
                } else {
                    str = "biz_src_jc_photo";
                }
                intent.putExtra("big_brother_source_key", str);
                if (aIOPictureData.istroop == 10014) {
                    this.f282009o0.putExtra("extra.MSG_ID", aIOPictureData.msgId);
                }
            }
            if (ao.c(com.tencent.mobileqq.richmediabrowser.h.a().f()) != 1044) {
                Context context = this.f282077h;
                if (context instanceof Activity) {
                    com.tencent.mobileqq.richmediabrowser.presenter.d dVar2 = this.Q;
                    if (dVar2 == null) {
                        X = null;
                    } else {
                        X = dVar2.X(richMediaBrowserInfo, (Activity) context);
                    }
                    if (X != null) {
                        X.putExtra(RichMediaBrowserConstants.KEY_TYPE_FROM_NEW_IMG_SHARE_ACTION_SHEET, 1);
                        X.putExtra(((IBrowserDepend) QRoute.api(IBrowserDepend.class)).getShowDataLine(), true);
                        this.f282075e.setIntentForStartForwardRecentActivity(X);
                    } else {
                        this.f282075e.setIntentForStartForwardRecentActivity(null);
                        QLog.e("AIOPictureView", 2, "showActionSheetForPic setIntentForStartForwardRecentActivity get null intent");
                    }
                }
            }
            this.f282075e.setActionSheetItems(arrayList, arrayList2);
            this.f282075e.show();
            return;
        }
        q0(createMenuSheet, c16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g0(RichMediaBrowserInfo richMediaBrowserInfo, File file) {
        try {
            AIOBrowserBaseData aIOBrowserBaseData = (AIOBrowserBaseData) richMediaBrowserInfo.baseData;
            com.tencent.mobileqq.richmediabrowser.f fVar = this.f282010p0;
            if (fVar != null && (this.f282077h instanceof Activity)) {
                ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).dealAddFavorite((Activity) this.f282077h, fVar.E(aIOBrowserBaseData.msgId, aIOBrowserBaseData.subId), file.getAbsolutePath(), com.tencent.mobileqq.richmediabrowser.h.a().m());
            }
        } catch (RemoteException e16) {
            BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "ACTION_ADD_FAVORITER exception = " + e16.getMessage());
            QQToast.makeText(this.f282077h.getApplicationContext(), this.f282077h.getString(R.string.f221696bi), 0).show();
        }
    }

    private void h1(boolean z16) {
        int i3;
        View view = this.G;
        if (view != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0(AIOPictureData aIOPictureData) {
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "action sheet add to favorite.");
        if (this.f282077h instanceof Activity) {
            ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).dealAddToEmotion(aIOPictureData, (Activity) this.f282077h);
        }
        if (this.X) {
            ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "1", "", "", "", "", 0, 0, 0, 0);
        }
    }

    private void i1() {
        AIOPictureData I0 = I0();
        if (I0 != null && new tm2.d().f(I0, 4)) {
            if (I0.size > 0) {
                a1(String.format(Locale.CHINA, this.f282077h.getString(R.string.f221806bt), com.tencent.mobileqq.utils.ao.a(I0.size)));
            } else {
                a1(this.f282077h.getString(R.string.f221776bq));
            }
        }
    }

    private void j0(RichMediaBrowserInfo richMediaBrowserInfo, AIOPictureData aIOPictureData, tm2.d dVar, URLDrawable uRLDrawable) {
        String str;
        com.tencent.mobileqq.richmediabrowser.f fVar;
        this.R.imageView.setImageDrawable(uRLDrawable);
        String e16 = dVar.e(aIOPictureData, 4);
        String url = uRLDrawable.getURL().toString();
        if (url.equals(e16)) {
            this.R.imageView.setOriginalImage(true);
        }
        this.R.imageView.initDrawable(uRLDrawable, this.J, this.K, com.tencent.richmediabrowser.utils.a.a(J0(uRLDrawable.getURL().getFile())), this.f282011q0);
        if (this.R.imageView.isOriginalImage()) {
            str = aIOPictureData.originImageFile;
        } else {
            str = aIOPictureData.largeImageFile;
        }
        String estimateFileType = FileUtils.estimateFileType(str);
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "getView(): cache url is " + url + ", cache type is " + dVar.d(aIOPictureData, uRLDrawable.getURL().getFile()) + ",extName = + " + estimateFileType);
        if (aIOPictureData.mIsPart && (fVar = this.f282010p0) != null) {
            fVar.y(aIOPictureData.msgId, aIOPictureData.subId, 2);
        }
    }

    private void k0(final ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList, AIOPictureData aIOPictureData, File file, final ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList2, final File file2) {
        if (ao.c(com.tencent.mobileqq.richmediabrowser.h.a().f()) != 1044) {
            RichMediaBrowserUtils.a(2, arrayList);
        }
        if (this.U == null) {
            this.U = Boolean.valueOf(((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).isShowGuildTab());
        }
        Boolean bool = this.U;
        if (bool != null && bool.booleanValue()) {
            RichMediaBrowserUtils.a(171, arrayList);
        }
        if (ao.c(com.tencent.mobileqq.richmediabrowser.h.a().f()) != 1044 && aIOPictureData.uuid != null && aIOPictureData.istroop != 10014) {
            RichMediaBrowserUtils.a(50, arrayList);
        }
        RichMediaBrowserUtils.a(27, arrayList);
        if (((IBrowserDepend) QRoute.api(IBrowserDepend.class)).isPicShareToWXEnable() && ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).isFileSizeEnable(file)) {
            RichMediaBrowserUtils.a(9, arrayList);
        }
        if (((IWinkMediaHelper) QRoute.api(IWinkMediaHelper.class)).isSupportImageFormat(file)) {
            RichMediaBrowserUtils.a(184, arrayList);
        }
        if (this.X) {
            RichMediaBrowserUtils.a(48, arrayList2);
            ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).reportCommercialDrainage("", "QLbq", "ClickMore", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
        }
        if (!((IBrowserDepend) QRoute.api(IBrowserDepend.class)).saveImageNeedBlock()) {
            RichMediaBrowserUtils.a(39, arrayList2);
        }
        if (com.tencent.mobileqq.richmediabrowser.utils.h.a() && c1()) {
            RichMediaBrowserUtils.a(94, arrayList2);
        }
        if (!this.X) {
            RichMediaBrowserUtils.a(6, arrayList2);
        }
        if (ao.c(com.tencent.mobileqq.richmediabrowser.h.a().f()) != 1044) {
            if (com.tencent.mobileqq.richmediabrowser.h.a().r() && !TextUtils.isEmpty(com.tencent.mobileqq.richmediabrowser.h.a().g()) && !com.tencent.mobileqq.richmediabrowser.h.a().q()) {
                RichMediaBrowserUtils.a(54, arrayList2);
            }
            if (this.Y) {
                RichMediaBrowserUtils.a(52, arrayList2);
            }
            ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.richmediabrowser.view.AIOPictureView.3
                @Override // java.lang.Runnable
                public void run() {
                    String str;
                    if (!((IBrowserDepend) QRoute.api(IBrowserDepend.class)).scanQrCodeNeedBlock() && (str = AIOPictureView.this.f281995a0) != null && str.equals(file2.getPath())) {
                        AIOPictureView.this.e0(Uri.parse("file://" + file2.getAbsolutePath()), arrayList, arrayList2);
                    }
                }
            });
        }
    }

    private boolean l0(GalleryUrlImageView galleryUrlImageView) {
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "dealDefaultImage()");
        galleryUrlImageView.setImageDrawable(com.tencent.mobileqq.urldrawable.b.f306350a);
        return true;
    }

    private void m0(AIOPictureData aIOPictureData) {
        if (!n0(aIOPictureData, this.R.imageView)) {
            l0(this.R.imageView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m1(int i3) {
        ThreadManager.getUIHandler().postDelayed(this.f282013s0, i3);
    }

    private boolean n0(AIOPictureData aIOPictureData, GalleryUrlImageView galleryUrlImageView) {
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "dealErrorImage()");
        if (!aIOPictureData.mOriginError && !aIOPictureData.mLargeError && !aIOPictureData.mThumbError) {
            return false;
        }
        Drawable drawable = BaseApplication.getContext().getResources().getDrawable(R.drawable.mzb);
        galleryUrlImageView.setImageDrawable(drawable);
        this.R.imageView.initDrawable(drawable, this.J, this.K, 0);
        BrowserBasePresenter browserBasePresenter = this.Q.f281861h;
        browserBasePresenter.onLoadFinish(browserBasePresenter.getSelectedIndex(), false);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n1(URLDrawable uRLDrawable, File file, int i3) {
        BrowserBasePresenter browserBasePresenter;
        uRLDrawable.setTag(1);
        this.R.imageView.setImageDrawable(uRLDrawable);
        this.R.imageView.initDrawable(uRLDrawable, this.J, this.K, K0(file.getAbsolutePath()), this.f282011q0);
        com.tencent.mobileqq.richmediabrowser.presenter.d dVar = this.Q;
        if (dVar != null && (browserBasePresenter = dVar.f281861h) != null) {
            browserBasePresenter.mActiveDrawable.put(Integer.valueOf(i3), uRLDrawable);
            this.Q.f281861h.onLoadFinish(i3, true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void o0(AIOPictureData aIOPictureData, tm2.d dVar, File file, int i3) {
        URLDrawable uRLDrawable;
        Drawable drawable = this.R.imageView.getDrawable();
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestWidth = this.J;
        obtain.mRequestHeight = this.K;
        if (drawable == null) {
            drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        }
        obtain.mLoadingDrawable = drawable;
        obtain.mPlayGifImage = true;
        obtain.mUseExifOrientation = false;
        obtain.mDecodeFileStrategy = 2;
        String e16 = dVar.e(aIOPictureData, 2);
        if (aIOPictureData.mIsPart) {
            e16 = e16 + "#PART";
        }
        try {
            uRLDrawable = URLDrawable.getDrawable(e16, obtain);
            try {
                uRLDrawable.setTag(1);
            } catch (Throwable unused) {
                BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "[getView] URLDrawable.getDrawable failed.");
                this.R.imageView.setGalleryImageListener(new b(uRLDrawable, file, aIOPictureData));
                if (uRLDrawable != null) {
                }
                this.R.imageView.setImageDrawable(uRLDrawable);
            }
        } catch (Throwable unused2) {
            uRLDrawable = null;
        }
        this.R.imageView.setGalleryImageListener(new b(uRLDrawable, file, aIOPictureData));
        if (uRLDrawable != null) {
            Runnable g16 = RichMediaBrowserUtils.g(this.f282003i0, uRLDrawable);
            this.f282004j0 = g16;
            if (g16 == null && uRLDrawable.getStatus() == 1) {
                n1(uRLDrawable, file, i3);
            }
        }
        this.R.imageView.setImageDrawable(uRLDrawable);
    }

    private URLDrawable p0(AIOPictureData aIOPictureData, tm2.d dVar, File file, File file2, int i3) {
        boolean z16;
        String e16;
        URLDrawable uRLDrawable;
        if (file != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestWidth = this.J;
        obtain.mRequestHeight = this.K;
        obtain.mLoadingDrawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        obtain.mPlayGifImage = true;
        obtain.mUseExifOrientation = false;
        obtain.mDecodeFileStrategy = 2;
        if (z16) {
            e16 = dVar.e(aIOPictureData, 4);
        } else {
            e16 = dVar.e(aIOPictureData, 2);
            if (aIOPictureData.mIsPart) {
                e16 = e16 + "#PART";
            }
        }
        try {
            uRLDrawable = URLDrawable.getDrawable(e16, obtain);
        } catch (Throwable unused) {
            uRLDrawable = null;
        }
        try {
            uRLDrawable.setTag(1);
            uRLDrawable.downloadImediatly();
        } catch (Throwable unused2) {
            BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "[getView] URLDrawable.getDrawable failed.");
            if (uRLDrawable == null) {
            }
            z0(aIOPictureData);
            return uRLDrawable;
        }
        if (uRLDrawable == null && uRLDrawable.getStatus() == 1) {
            n1(uRLDrawable, file2, i3);
        } else {
            z0(aIOPictureData);
        }
        return uRLDrawable;
    }

    private void q0(ActionSheet actionSheet, File file) {
        if (ao.c(com.tencent.mobileqq.richmediabrowser.h.a().f()) == 1032 && file != null) {
            actionSheet.addButton(R.string.f221666bf);
        }
        actionSheet.addCancelButton(R.string.f221546b4);
        actionSheet.setOnButtonClickListener(new d(actionSheet));
        actionSheet.show();
        actionSheet.registerWatchDisMissActionListener(this);
    }

    private void r0(RichMediaBrowserInfo richMediaBrowserInfo, AIOPictureData aIOPictureData, tm2.d dVar, File file, int i3) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestWidth = this.J;
        obtain.mRequestHeight = this.K;
        URLDrawable uRLDrawable = null;
        if (dVar.c(aIOPictureData, 1) != null) {
            URLDrawable fileDrawable = URLDrawable.getFileDrawable(aIOPictureData.thumbImageFile, null);
            fileDrawable.downloadImediatly();
            obtain.mLoadingDrawable = fileDrawable;
        } else {
            obtain.mLoadingDrawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        }
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "TYPE_ORIGINAL_IMAGE");
        obtain.mPlayGifImage = true;
        obtain.mUseExifOrientation = false;
        obtain.mDecodeFileStrategy = 2;
        try {
            uRLDrawable = URLDrawable.getDrawable(dVar.e(aIOPictureData, 4), obtain);
            uRLDrawable.setTag(1);
        } catch (Throwable th5) {
            BrowserLogHelper.getInstance().getGalleryLog().w("AIOPictureView", 1, "[dealOriginalImage] URLDrawable.getDrawable failed, exc=" + th5);
        }
        if (uRLDrawable == null) {
            BrowserLogHelper.getInstance().getGalleryLog().w("AIOPictureView", 1, "[dealOriginalImage] drawable is null.");
            return;
        }
        this.R.imageView.setGalleryImageListener(new a(uRLDrawable, file, aIOPictureData));
        Runnable g16 = RichMediaBrowserUtils.g(this.f282003i0, uRLDrawable);
        this.f282004j0 = g16;
        if (g16 == null && uRLDrawable.getStatus() == 1) {
            n1(uRLDrawable, file, i3);
        } else {
            this.R.imageView.initDrawable(uRLDrawable, this.J, this.K, com.tencent.richmediabrowser.utils.a.a(uRLDrawable.getExifOrientation()), this.f282011q0);
        }
        this.R.imageView.setImageDrawable(uRLDrawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0(AIOPictureData aIOPictureData) {
        if (this.f282077h instanceof Activity) {
            ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).dealPicForwardToGroupAlbum(aIOPictureData, this.f282077h, this.f282010p0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0(AIOPictureData aIOPictureData) {
        String i3 = com.tencent.mobileqq.richmediabrowser.h.a().i();
        if (aIOPictureData.istroop == 10014) {
            i3 = com.tencent.mobileqq.richmediabrowser.h.a().j();
        }
        if (TextUtils.isEmpty(i3)) {
            i3 = com.tencent.mobileqq.richmediabrowser.h.a().g();
        }
        String str = i3;
        ReportController.o(null, "P_CliOper", "dwop_via", "", "0X8009BE3", "0X8009BE3", com.tencent.mobileqq.richmediabrowser.h.a().c(), 0, "", "", "", "");
        if (this.f282077h instanceof Activity) {
            ((IMsgLocationApi) QRoute.api(IMsgLocationApi.class)).jumpToTargetNTAIOPosition((Activity) this.f282077h, com.tencent.mobileqq.richmediabrowser.h.a().f(), com.tencent.mobileqq.richmediabrowser.h.a().g(), str, aIOPictureData.shmsgseq, aIOPictureData.msgId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0(AIOPictureData aIOPictureData) {
        com.tencent.mobileqq.richmediabrowser.f fVar;
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime != null && (fVar = this.f282010p0) != null) {
            if (aIOPictureData.isAnonymousMsg) {
                fVar.g(com.tencent.mobileqq.richmediabrowser.h.a().f(), true, aIOPictureData.anId, aIOPictureData.friendUin, waitAppRuntime.getAccount(), aIOPictureData.content);
            } else {
                fVar.g(com.tencent.mobileqq.richmediabrowser.h.a().f(), false, aIOPictureData.sendUin, aIOPictureData.friendUin, waitAppRuntime.getAccount(), aIOPictureData.content);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0(AIOPictureData aIOPictureData, RichMediaBrowserInfo richMediaBrowserInfo, File file, boolean z16) {
        if (!PermissionUtil.isHasStoragePermission(this.f282077h) && (this.f282077h instanceof Activity)) {
            QQPermissionFactory.getQQPermission((Activity) this.f282077h, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_RICH_MEDIA_SAVE, QQPermissionConstants.Business.SCENE.RICH_MEDIA_AIO_SAVE_PIC)).requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new g());
            return;
        }
        com.tencent.mobileqq.richmediabrowser.f fVar = this.f282010p0;
        if (fVar != null) {
            fVar.b(RichMediaBrowserConstants.SINGLE_PIC_SAVE, 0);
        }
        tm2.d dVar = new tm2.d();
        if (dVar.c(aIOPictureData, 4) == null && dVar.f(aIOPictureData, 4) && AppNetConnInfo.isNetSupport()) {
            if (!AppNetConnInfo.isWifiConn() && aIOPictureData.size > 29360128) {
                k1(100, aIOPictureData, richMediaBrowserInfo);
            } else {
                this.Q.S(aIOPictureData);
                this.Q.R(aIOPictureData.msgId, aIOPictureData.subId, 4);
                updateUI();
                o();
                this.Q.p().f();
            }
        } else if (this.f282077h instanceof Activity) {
            ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).savePic((Activity) this.f282077h, file, Utils.Crc64String(file.getAbsolutePath() + NetConnInfoCenter.getServerTime()));
        }
        if (this.X) {
            ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "3", "", "", "", "", 0, 0, 0, 0);
        }
        if (com.tencent.mobileqq.richmediabrowser.h.a().q() && this.Q.f281859e != null) {
            AIOBrowserPresenter.D("0X8009ABB");
        }
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 2, "ACTION_SAVE");
        AIOBrowserPresenter aIOBrowserPresenter = this.Q.f281859e;
        if (aIOBrowserPresenter != null) {
            if (z16) {
                aIOBrowserPresenter.P(1);
            } else {
                aIOBrowserPresenter.Q();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0(int i3, RichMediaBrowserInfo richMediaBrowserInfo) {
        String str;
        d.b bVar = new d.b();
        bVar.f281869a = i3;
        Context context = this.f282077h;
        if (context instanceof Activity) {
            com.tencent.mobileqq.richmediabrowser.presenter.d dVar = this.Q;
            Activity activity = (Activity) context;
            int sharePanelType = ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).getSharePanelType();
            if (this.X) {
                str = "biz_src_jc_groupgif";
            } else {
                str = "biz_src_jc_photo";
            }
            dVar.T(richMediaBrowserInfo, activity, bVar, sharePanelType, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0(int i3, ShareActionSheetBuilder.ActionSheetItem actionSheetItem, RichMediaBrowserInfo richMediaBrowserInfo) {
        String str;
        com.tencent.mobileqq.richmediabrowser.f fVar = this.f282010p0;
        if (fVar != null) {
            fVar.b(RichMediaBrowserConstants.SINGLE_FORWARD_CONTACTS, 0);
        }
        d.b bVar = new d.b();
        bVar.f281869a = i3;
        if (i3 == 72) {
            bVar.f281870b = actionSheetItem.uin;
            bVar.f281871c = actionSheetItem.uinType;
        }
        Context context = this.f282077h;
        if (context instanceof Activity) {
            com.tencent.mobileqq.richmediabrowser.presenter.d dVar = this.Q;
            Activity activity = (Activity) context;
            int sharePanelType = ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).getSharePanelType();
            if (this.X) {
                str = "biz_src_jc_groupgif";
            } else {
                str = "biz_src_jc_photo";
            }
            dVar.U(richMediaBrowserInfo, activity, bVar, sharePanelType, str);
            if (this.X) {
                ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "2", "", "", "", "", 0, 0, 0, 0);
            }
        }
        if (com.tencent.mobileqq.richmediabrowser.h.a().q() && this.Q.f281859e != null) {
            AIOBrowserPresenter.D("0X8009ABA");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0(AIOPictureData aIOPictureData) {
        com.tencent.mobileqq.richmediabrowser.f fVar;
        if (this.X) {
            BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "action sheet share weiyun.");
            ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).dealSendToWeiYun(aIOPictureData);
            ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "5", "", "", "", "", 0, 0, 0, 0);
        } else if (aIOPictureData.msgId > 0 && (fVar = this.f282010p0) != null && fVar.n()) {
            this.f282010p0.f(aIOPictureData.msgId);
            Context context = this.f282077h;
            QQToast.makeText(context, context.getString(R.string.f221526b2), 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0(AIOPictureData aIOPictureData) {
        if (!A0(aIOPictureData, this.R.imageView) && !C0(aIOPictureData, this.R.imageView) && !n0(aIOPictureData, this.R.imageView)) {
            l0(this.R.imageView);
        }
        G0(aIOPictureData.msgId, aIOPictureData.subId, 2);
    }

    @Override // com.tencent.mobileqq.richmediabrowser.view.a
    public void A(int i3) {
        RichMediaBrowserInfo selectedItem;
        RichMediaBaseData richMediaBaseData;
        super.A(i3);
        BrowserBasePresenter browserBasePresenter = this.Q.f281861h;
        if (browserBasePresenter != null && (selectedItem = browserBasePresenter.getSelectedItem()) != null && (richMediaBaseData = selectedItem.baseData) != null && richMediaBaseData.getType() == 100) {
            e1((AIOPictureData) selectedItem.baseData, selectedItem);
            BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 2, "showActionSheet, from:" + i3);
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.view.a
    public void B(boolean z16) {
        if (N0()) {
            return;
        }
        super.B(z16);
    }

    @Override // com.tencent.mobileqq.richmediabrowser.view.a
    public void C(boolean z16) {
        if (N0()) {
            return;
        }
        super.C(z16);
    }

    @Override // com.tencent.mobileqq.richmediabrowser.view.a
    public void D(boolean z16) {
        if (N0()) {
            super.D(true);
        } else {
            super.D(z16);
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.view.a
    public void E(boolean z16) {
        if (N0()) {
            return;
        }
        super.E(z16);
    }

    @Override // com.tencent.mobileqq.richmediabrowser.view.a
    public void F(boolean z16) {
        if (N0()) {
            return;
        }
        super.F(z16);
    }

    @Override // com.tencent.mobileqq.richmediabrowser.view.a
    public void G(boolean z16) {
        if (N0()) {
            return;
        }
        super.G(z16);
    }

    @Override // com.tencent.mobileqq.richmediabrowser.view.a
    public void H(boolean z16) {
        if (N0()) {
            return;
        }
        super.H(z16);
    }

    @Override // com.tencent.mobileqq.richmediabrowser.view.a
    public void I() {
        if (N0()) {
            return;
        }
        super.I();
    }

    public AIOPictureData I0() {
        tm2.a aVar;
        RichMediaBrowserInfo selectedItem;
        RichMediaBaseData richMediaBaseData;
        AIOBrowserPresenter aIOBrowserPresenter = this.Q.f281859e;
        if (aIOBrowserPresenter != null && (aVar = aIOBrowserPresenter.f281850e) != null && (selectedItem = aVar.getSelectedItem()) != null && (richMediaBaseData = selectedItem.baseData) != null && richMediaBaseData.getType() == 100) {
            return (AIOPictureData) selectedItem.baseData;
        }
        return null;
    }

    public void L0() {
        RelativeLayout relativeLayout = this.H;
        if (relativeLayout != null) {
            this.f281998d0 = (RelativeLayout) relativeLayout.findViewById(R.id.m7i);
            this.f281999e0 = (TextView) this.H.findViewById(R.id.g27);
            this.f282000f0 = (ImageView) this.H.findViewById(R.id.az_);
            this.f282001g0 = (SeekBar) this.H.findViewById(R.id.ilm);
            this.f282002h0 = (TextView) this.H.findViewById(R.id.lgz);
            this.f282003i0 = (ImageView) this.H.findViewById(R.id.efm);
            this.f282006l0 = (LinearLayout) this.H.findViewById(R.id.f164720x7);
            this.f282007m0 = (TextView) this.H.findViewById(R.id.f164721xu);
            this.f282006l0.setOnClickListener(this);
            this.f282006l0.setVisibility(8);
            this.f282000f0.setOnClickListener(this);
            ImageButton imageButton = (ImageButton) this.H.findViewById(R.id.cp5);
            this.E = imageButton;
            imageButton.setOnClickListener(this);
            this.G = this.H.findViewById(R.id.f59272s_);
            ImageButton imageButton2 = (ImageButton) this.H.findViewById(R.id.f59262s9);
            this.F = imageButton2;
            if (imageButton2 != null) {
                imageButton2.setOnClickListener(this);
            }
            ImageButton imageButton3 = (ImageButton) this.H.findViewById(R.id.gqp);
            this.C = imageButton3;
            imageButton3.setOnClickListener(this);
            ImageButton imageButton4 = (ImageButton) this.H.findViewById(R.id.f59282sa);
            this.D = imageButton4;
            imageButton4.setOnClickListener(this);
            ImageButton imageButton5 = (ImageButton) this.H.findViewById(R.id.f59252s8);
            this.f282079m = imageButton5;
            imageButton5.setOnClickListener(this);
            TextView textView = (TextView) this.H.findViewById(R.id.gqs);
            this.f282005k0 = textView;
            textView.setOnClickListener(this);
            ImageButton imageButton6 = (ImageButton) this.H.findViewById(R.id.gqo);
            this.f282078i = imageButton6;
            imageButton6.setOnClickListener(this);
            BrowserBasePresenter browserBasePresenter = this.Q.f281861h;
            if (browserBasePresenter != null) {
                E(y(browserBasePresenter.getSelectedItem()));
            }
            if (N0()) {
                h1(true);
            }
            H(d0());
            F(d1());
            G(z());
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

    protected boolean N0() {
        Intent intent = this.f282009o0;
        if (intent == null || !intent.getBooleanExtra(RichMediaBrowserConstants.EXTRA_USE_FEED_SHOW_LONG_IMAGE_UI, false)) {
            return false;
        }
        return true;
    }

    public void T0() {
        AIOPictureData I0 = I0();
        com.tencent.mobileqq.richmediabrowser.f fVar = this.f282010p0;
        if (fVar != null && I0 != null && fVar.n()) {
            this.Q.R(I0.msgId, I0.subId, 3);
            this.f282010p0.y(I0.msgId, I0.subId, 4);
            updateUI();
            o();
            this.Q.p().f();
        }
    }

    public void X0(boolean z16) {
        ImageButton imageButton = this.C;
        if (imageButton != null) {
            imageButton.setEnabled(z16);
        }
    }

    public void Y0(AIOPictureData aIOPictureData, RichMediaBrowserInfo richMediaBrowserInfo, File file) {
        this.f282075e.setItemClickListenerV2(new e(aIOPictureData, richMediaBrowserInfo, file));
        this.f282075e.setCancelListener(new f());
    }

    public void Z0(k kVar) {
        this.f281996b0 = kVar;
    }

    @Override // com.tencent.mobileqq.richmediabrowser.view.a, e04.e
    public View a(View view, ViewGroup viewGroup) {
        this.H = (RelativeLayout) LayoutInflater.from(this.f282077h).inflate(R.layout.hnl, (ViewGroup) null);
        L0();
        RelativeLayout relativeLayout = this.R.controlViewContainer;
        if (relativeLayout != null) {
            relativeLayout.addView(this.H, new RelativeLayout.LayoutParams(-1, -1));
        }
        return this.R.mBrowserItemView;
    }

    public void a1(String str) {
        TextView textView = this.f282005k0;
        if (textView != null) {
            textView.setText(str);
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.view.a, e04.e
    public void b(int i3) {
        com.tencent.mobileqq.richmediabrowser.f fVar;
        this.f282003i0.setVisibility(8);
        RichMediaBrowserInfo item = this.Q.f281861h.getItem(i3);
        if (item != null) {
            RichMediaBaseData richMediaBaseData = item.baseData;
            if (richMediaBaseData != null || this.R.imageView != null) {
                if (richMediaBaseData != null && richMediaBaseData.getType() == 100) {
                    AIOPictureData aIOPictureData = (AIOPictureData) item.baseData;
                    tm2.d dVar = new tm2.d();
                    U0(this.Q.o(), aIOPictureData);
                    this.R.imageView.setOnItemEventListener(this);
                    this.R.imageView.setPosition(i3);
                    this.R.imageView.setImageInfo(item);
                    this.R.imageView.setIgnoreLayout(false);
                    this.R.imageView.setContentDescription(this.f282077h.getString(R.string.f221766bp));
                    URLDrawable uRLDrawable = this.Q.f281861h.mActiveDrawable.get(Integer.valueOf(i3));
                    if (uRLDrawable != null && uRLDrawable.getStatus() == 1) {
                        j0(item, aIOPictureData, dVar, uRLDrawable);
                    } else {
                        File c16 = dVar.c(aIOPictureData, 4);
                        if (c16 != null) {
                            r0(item, aIOPictureData, dVar, c16, i3);
                        } else {
                            File c17 = dVar.c(aIOPictureData, 2);
                            if (c17 != null) {
                                if (((IFeatureSwitch) QRoute.api(IFeatureSwitch.class)).isFeatureSwitchEnable("rich_media_browser_large_image_load_async", true)) {
                                    o0(aIOPictureData, dVar, c17, i3);
                                } else {
                                    p0(aIOPictureData, dVar, null, c17, i3);
                                }
                            } else if (dVar.c(aIOPictureData, 8) != null) {
                                z0(aIOPictureData);
                            } else if (dVar.c(aIOPictureData, 1) != null) {
                                B0(aIOPictureData);
                            } else if (!aIOPictureData.mOriginError && !aIOPictureData.mLargeError && !aIOPictureData.mThumbError) {
                                BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "getView(): No pic");
                                l0(this.R.imageView);
                                G0(aIOPictureData.msgId, aIOPictureData.subId, 2);
                            } else {
                                m0(aIOPictureData);
                            }
                        }
                    }
                    String str = aIOPictureData.msgId + "_" + aIOPictureData.subId;
                    if (!this.f281997c0.contains(str) && (fVar = this.f282010p0) != null) {
                        fVar.h(aIOPictureData.msgId, aIOPictureData.subId);
                        this.f281997c0.add(str);
                    }
                }
                this.R.imageView.setMainBrowserPresenter(this.Q.f281859e);
                j jVar = new j();
                PictureView pictureView = this.R;
                jVar.f282039a = pictureView.imageView;
                pictureView.mBrowserItemView.setTag(jVar);
            }
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.view.a, e04.e
    public void c(int i3, View view) {
        BrowserBasePresenter browserBasePresenter;
        ConcurrentHashMap<Integer, URLDrawable> concurrentHashMap;
        URLDrawable uRLDrawable;
        com.tencent.mobileqq.richmediabrowser.presenter.d dVar = this.Q;
        if (dVar != null && (browserBasePresenter = dVar.f281861h) != null && (concurrentHashMap = browserBasePresenter.mActiveDrawable) != null && (uRLDrawable = concurrentHashMap.get(Integer.valueOf(i3))) != null) {
            if (uRLDrawable.getStatus() == 0) {
                uRLDrawable.cancelDownload(true);
            }
            this.Q.f281861h.mActiveDrawable.remove(Integer.valueOf(i3));
        }
        if (i3 == this.T) {
            URLDrawable uRLDrawable2 = this.S;
            if (uRLDrawable2 != null && uRLDrawable2.getStatus() == 0) {
                this.S.cancelDownload(true);
            }
            this.S = null;
            this.T = -1;
        }
    }

    public boolean c1() {
        boolean z16;
        Intent intent = this.f282009o0;
        if (intent == null) {
            return false;
        }
        if (!intent.getBooleanExtra(RichMediaBrowserConstants.EXTRA_FROM_AIO, false) && com.tencent.mobileqq.richmediabrowser.h.a().c() != 3 && com.tencent.mobileqq.richmediabrowser.h.a().c() != 2 && com.tencent.mobileqq.richmediabrowser.h.a().c() != 6 && com.tencent.mobileqq.richmediabrowser.h.a().c() != 7) {
            z16 = false;
        } else {
            z16 = true;
        }
        Bundle extras = this.f282009o0.getExtras();
        if ((!z16 && (com.tencent.mobileqq.richmediabrowser.h.a().c() != 4 || !extras.getBoolean(RichMediaBrowserConstants.KEY_ALLOW_FORWARD_PHOTO_PREVIEW_EDIT, false))) || ao.c(com.tencent.mobileqq.richmediabrowser.h.a().f()) == 1032 || ao.c(com.tencent.mobileqq.richmediabrowser.h.a().f()) == 1044) {
            return false;
        }
        return true;
    }

    public boolean d1() {
        if (com.tencent.mobileqq.richmediabrowser.utils.h.a()) {
            return false;
        }
        return c1();
    }

    public void f0() {
        BrowserBasePresenter browserBasePresenter;
        ConcurrentHashMap<Integer, URLDrawable> concurrentHashMap;
        com.tencent.mobileqq.richmediabrowser.presenter.d dVar = this.Q;
        if (dVar != null && (browserBasePresenter = dVar.f281861h) != null && (concurrentHashMap = browserBasePresenter.mActiveDrawable) != null) {
            concurrentHashMap.clear();
        }
        URLDrawable uRLDrawable = this.S;
        if (uRLDrawable != null && uRLDrawable.getStatus() == 0) {
            this.S.cancelDownload(true);
        }
        this.S = null;
        this.T = -1;
    }

    public void f1(boolean z16) {
        if (this.f282006l0 != null) {
            AIOPictureData I0 = I0();
            boolean z17 = false;
            if (z16 && I0 != null && !com.tencent.mobileqq.richmediabrowser.h.a().v() && !com.tencent.mobileqq.richmediabrowser.h.a().q() && ((ICaptureUtil) QRoute.api(ICaptureUtil.class)).supportCapture() && ((IShortVideoDepend) QRoute.api(IShortVideoDepend.class)).isAEPituTakeSameOpen()) {
                long j3 = I0.msgId;
                if (!TextUtils.isEmpty(I0.templateId)) {
                    this.f282006l0.setVisibility(0);
                    j1(false);
                    String string = this.f282077h.getString(R.string.f221536b3);
                    if (!TextUtils.isEmpty(I0.templateName)) {
                        string = I0.templateName;
                    }
                    this.f282007m0.setText(string);
                    if (this.f282008n0 != j3) {
                        ReportController.o(null, "dc00898", "", "", "0X800A91E", "0X800A91E", 1, 0, "", "", I0.templateId, "");
                        this.f282008n0 = j3;
                    }
                    z17 = true;
                }
            }
            if (!z17) {
                this.f282006l0.setVisibility(8);
            }
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

    public void g1(Dialog dialog) {
        if (dialog != null) {
            Context context = this.f282077h;
            if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
                try {
                    dialog.show();
                } catch (Throwable th5) {
                    BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "showDialogSafe exception: " + th5.getMessage());
                }
            }
        }
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
        this.f282009o0 = intent;
        if (intent != null) {
            Bundle extras = intent.getExtras();
            this.V = extras.getBoolean(RichMediaBrowserConstants.EXTRA_CAN_FORWARD_TO_GROUP_ALBUM, false);
            this.W = extras.getInt(RichMediaBrowserConstants.EXTRA_FORWARD_TO_QZONE_SRC);
            this.X = extras.getBoolean(RichMediaBrowserConstants.GROUP_EMO_PREVIEW, false);
            this.Y = extras.getBoolean(RichMediaBrowserConstants.EXTRA_OCR, false);
        }
        AIOBrowserPresenter aIOBrowserPresenter = this.Q.f281859e;
        if (aIOBrowserPresenter != null && (aIOBrowserPresenter.getParamsBuilder().c() instanceof com.tencent.mobileqq.richmediabrowser.f)) {
            this.f282010p0 = (com.tencent.mobileqq.richmediabrowser.f) this.Q.f281859e.getParamsBuilder().c();
        }
        Z0(new c());
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.richmediabrowser.view.AIOPictureView.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AIOPictureView.this.U = Boolean.valueOf(((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).isShowGuildTabCached());
                } catch (Exception unused) {
                }
            }
        }, 16, null, false);
    }

    public void j1(boolean z16) {
        int i3;
        if (this.f282005k0 != null) {
            if (z16) {
                i1();
            }
            TextView textView = this.f282005k0;
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            textView.setVisibility(i3);
        }
    }

    public void k1(int i3, Object obj, RichMediaBrowserInfo richMediaBrowserInfo) {
        Context context = this.f282077h;
        g1(DialogUtil.createCustomDialog(context, 230, context.getString(R.string.f221866bz), this.f282077h.getString(R.string.f221856by), new h(i3, obj), new i()));
    }

    void l1() {
        int i3;
        int i16;
        int i17;
        boolean z16;
        boolean z17;
        int i18;
        AIOPictureData I0 = I0();
        if (I0 != null && (this.f282077h instanceof Activity)) {
            tm2.d dVar = new tm2.d();
            File c16 = dVar.c(I0, 4);
            if (c16 == null) {
                c16 = dVar.c(I0, 2);
            }
            if (c16 == null) {
                c16 = dVar.c(I0, 1);
            }
            if (c16 == null) {
                return;
            }
            this.f281995a0 = c16.getAbsolutePath();
            int i19 = 19000;
            switch (com.tencent.mobileqq.richmediabrowser.h.a().c()) {
                case 1:
                    i3 = 126;
                    i17 = i3;
                    z17 = true;
                    z16 = true;
                    i18 = i19;
                    break;
                case 2:
                    i3 = 127;
                    i17 = i3;
                    z17 = true;
                    z16 = true;
                    i18 = i19;
                    break;
                case 3:
                    i3 = 128;
                    i17 = i3;
                    z17 = true;
                    z16 = true;
                    i18 = i19;
                    break;
                case 4:
                    i16 = 125;
                    i19 = 19002;
                    i17 = i16;
                    z16 = false;
                    z17 = true;
                    i18 = i19;
                    break;
                case 5:
                    i3 = 129;
                    i17 = i3;
                    z17 = true;
                    z16 = true;
                    i18 = i19;
                    break;
                case 6:
                    i16 = 130;
                    i17 = i16;
                    z16 = false;
                    z17 = true;
                    i18 = i19;
                    break;
                case 7:
                    i3 = 134;
                    i17 = i3;
                    z17 = true;
                    z16 = true;
                    i18 = i19;
                    break;
                default:
                    i17 = 99;
                    z17 = false;
                    z16 = false;
                    i18 = 0;
                    break;
            }
            ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).startEditPicActivity((Activity) this.f282077h, i17, z17, z16, i18, c16.getAbsolutePath(), com.tencent.mobileqq.richmediabrowser.h.a().f());
            ReportController.o(null, "dc00898", "", "", "0X8007ACE", "0X8007ACE", 0, 0, "", "", "", "");
        }
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

    /* JADX WARN: Multi-variable type inference failed */
    public void o1(int i3, boolean z16) {
        RichMediaBrowserInfo item;
        RichMediaBaseData richMediaBaseData;
        RelativeLayout relativeLayout;
        String str;
        BrowserBasePresenter browserBasePresenter = this.Q.f281861h;
        if (browserBasePresenter == null || (item = browserBasePresenter.getItem(i3)) == null || (richMediaBaseData = item.baseData) == null || richMediaBaseData.getType() != 100 || (relativeLayout = this.R.mBrowserItemView) == null || !(relativeLayout.getTag() instanceof j)) {
            return;
        }
        BrowserScaleView browserScaleView = ((j) this.R.mBrowserItemView.getTag()).f282039a;
        AIOPictureData aIOPictureData = (AIOPictureData) item.baseData;
        tm2.d dVar = new tm2.d();
        if (aIOPictureData.mLargeError) {
            Drawable drawable = browserScaleView.getDrawable();
            String str2 = null;
            if (URLDrawable.class.isInstance(drawable)) {
                URLDrawable uRLDrawable = (URLDrawable) drawable;
                if (uRLDrawable != 0) {
                    str2 = uRLDrawable.getURL().getRef();
                }
                String str3 = str2;
                str2 = uRLDrawable;
                str = str3;
            } else {
                str = null;
            }
            if (str2 == null || str == null || (!DecoderType.DECODER_PART.equals(str) && !DecoderType.DECODER_DISPLAY.equals(str))) {
                if (dVar.c(aIOPictureData, 1) != null) {
                    P0("updateView, large image error, use thumb, md5=" + aIOPictureData.md5 + ", url=" + aIOPictureData.picServerUrl);
                    b1(browserScaleView, aIOPictureData, dVar);
                } else {
                    Drawable drawable2 = BaseApplication.getContext().getResources().getDrawable(R.drawable.mzb);
                    browserScaleView.setImageDrawable(drawable2);
                    browserScaleView.initDrawable(drawable2, this.J, this.K, 0);
                }
                this.Q.f281861h.onLoadFinish(i3, false);
            }
            if (!aIOPictureData.mHasShownErrorToast) {
                aIOPictureData.mHasShownErrorToast = true;
                String string = this.f282077h.getString(R.string.f221676bg);
                if (O0(aIOPictureData.mLargeErrorDesc)) {
                    string = this.f282077h.getString(R.string.f221686bh);
                }
                QQToast.makeText(this.f282077h, string, 0).show();
            }
            BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "AIOGalleryAdapter.updateView(): IMAGE_FILE_ERROR");
            return;
        }
        if (dVar.c(aIOPictureData, 2) != null) {
            String e16 = dVar.e(aIOPictureData, 2);
            if (z16) {
                e16 = e16 + "#PART";
            }
            b(i3);
            String estimateFileType = FileUtils.estimateFileType(aIOPictureData.largeImageFile);
            BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "AIOGalleryAdapter.updateView(): Update large image, position=" + i3 + "url = " + e16 + ",extName = " + estimateFileType);
            aIOPictureData.mIsPart = z16;
            return;
        }
        if (dVar.c(aIOPictureData, 1) != null) {
            b1(browserScaleView, aIOPictureData, dVar);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BrowserBasePresenter browserBasePresenter;
        RichMediaBrowserInfo selectedItem;
        RichMediaBaseData richMediaBaseData;
        File H0;
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.enc) {
            AIOPictureData I0 = I0();
            if (I0 != null && I0.mBusinessType == 3) {
                this.Q.back();
            }
        } else if (id5 == R.id.az_) {
            R0();
        } else if (id5 == R.id.gqo) {
            l();
        } else if (id5 == R.id.gqs) {
            T0();
        } else if (id5 == R.id.gqp) {
            l1();
            AIOBrowserPresenter aIOBrowserPresenter = this.Q.f281859e;
            if (aIOBrowserPresenter != null) {
                aIOBrowserPresenter.K();
            }
        } else if (id5 == R.id.f59282sa) {
            com.tencent.mobileqq.richmediabrowser.presenter.d dVar = this.Q;
            if (dVar != null && (browserBasePresenter = dVar.f281861h) != null && (selectedItem = browserBasePresenter.getSelectedItem()) != null && (richMediaBaseData = selectedItem.baseData) != null && richMediaBaseData.getType() == 100 && (H0 = H0()) != null) {
                v0((AIOPictureData) selectedItem.baseData, selectedItem, H0, false);
            }
        } else if (id5 == R.id.f59252s8) {
            n();
        } else if (id5 == R.id.cp5) {
            S0();
        } else if (id5 == R.id.f164720x7) {
            if (this.f282077h instanceof BaseActivity) {
                Q0();
            } else {
                BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 2, "onClick, activity:" + this.f282077h);
            }
        } else if (id5 == R.id.f59262s9) {
            ((Activity) this.f282077h).finish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.widget.ActionSheet.WatchDismissActions
    public void onDismissOperations() {
        BrowserBasePresenter browserBasePresenter = this.Q.f281861h;
        if (browserBasePresenter != null) {
            browserBasePresenter.updateSystemUIVisablity();
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.view.a, e04.b
    public void onEnterAnimationEnd() {
        super.onEnterAnimationEnd();
        Looper.myQueue().addIdleHandler(this.f282012r0);
        C(true);
        updateUI();
    }

    @Override // com.tencent.mobileqq.richmediabrowser.view.a, e04.b
    public void onEnterAnimationStart() {
        super.onEnterAnimationStart();
        C(false);
        f1(false);
    }

    @Override // com.tencent.mobileqq.richmediabrowser.view.a, e04.e
    public void onItemSelected(int i3) {
        super.onItemSelected(i3);
        b(i3);
        BrowserScaleView browserScaleView = this.R.imageView;
        if (browserScaleView != null) {
            Drawable drawable = browserScaleView.getDrawable();
            AIOPictureData I0 = I0();
            if (!this.R.imageView.isOriginalImage() && I0 != null && (drawable instanceof SkinnableBitmapDrawable) && I0.istroop == 1 && I0.size > ((IFMConfig) QRoute.api(IFMConfig.class)).getMaxCreateThumbFileSize()) {
                this.R.imageView.setDoubleTapEnable(false);
                this.R.imageView.setScaleEnable(false);
            }
        }
        updateUI();
    }

    @Override // com.tencent.mobileqq.richmediabrowser.view.a
    public void t() {
        super.t();
        f0();
        this.f282010p0 = null;
        PictureView pictureView = this.R;
        if (pictureView != null) {
            pictureView.onDestroy();
        }
        ThreadManager.getUIHandler().removeCallbacks(this.f282013s0);
    }

    @Override // com.tencent.mobileqq.richmediabrowser.view.a
    public void u(long j3) {
        com.tencent.mobileqq.richmediabrowser.f fVar;
        boolean z16;
        super.u(j3);
        AIOPictureData I0 = I0();
        if (I0 != null && (fVar = this.f282010p0) != null) {
            int k3 = fVar.k(I0.msgId, I0.subId);
            if (k3 >= 0 && k3 < 100) {
                z16 = true;
            } else {
                z16 = false;
            }
            BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "onRevokeMsg isSaving:" + z16);
            if (z16) {
                this.f282010p0.A(I0.msgId, I0.subId, 24);
            }
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.view.a, e04.e
    public void updateUI() {
        AIOPictureData I0 = I0();
        if (I0 != null) {
            int i3 = I0.status;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            PictureView pictureView = this.R;
                            if (pictureView != null) {
                                pictureView.updateUI();
                            }
                            BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "updateUI status is error, status = " + I0.status);
                            return;
                        }
                        BrowserBasePresenter browserBasePresenter = this.Q.f281861h;
                        browserBasePresenter.onLoadFinish(browserBasePresenter.getSelectedIndex(), true);
                        j1(false);
                        G(false);
                        E(false);
                        F(false);
                        H(false);
                        this.f282001g0.setProgress(I0.progress / 100);
                        this.f281999e0.setText(this.f282077h.getString(R.string.f221886c1) + (I0.progress / 100) + "%");
                        this.f281998d0.setVisibility(0);
                        return;
                    }
                    BrowserBasePresenter browserBasePresenter2 = this.Q.f281861h;
                    browserBasePresenter2.onLoadFinish(browserBasePresenter2.getSelectedIndex(), true);
                    j1(false);
                    G(false);
                    E(false);
                    F(false);
                    H(false);
                    this.f282001g0.setProgress(I0.progress / 100);
                    this.f281999e0.setText(this.f282077h.getString(R.string.f221596b9) + (I0.progress / 100) + "%");
                    this.f281998d0.setVisibility(0);
                    return;
                }
                j1(false);
                G(false);
                F(false);
                H(false);
                BrowserBasePresenter browserBasePresenter3 = this.Q.f281861h;
                browserBasePresenter3.onLoadStart(browserBasePresenter3.getSelectedIndex(), I0.progress);
                return;
            }
            BrowserBasePresenter browserBasePresenter4 = this.Q.f281861h;
            browserBasePresenter4.onLoadFinish(browserBasePresenter4.getSelectedIndex(), true);
            this.f281998d0.setVisibility(8);
            G(z());
            E(y(this.Q.f281861h.getSelectedItem()));
            F(d1());
            H(d0());
            tm2.d dVar = new tm2.d();
            if (dVar.c(I0, 2) == null && dVar.c(I0, 4) == null) {
                X0(false);
            } else {
                X0(true);
            }
            if (dVar.f(I0, 4) && dVar.c(I0, 4) == null) {
                j1(true);
            } else {
                j1(false);
            }
            f1(true);
        }
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

    @Override // com.tencent.mobileqq.richmediabrowser.view.a
    public boolean y(RichMediaBrowserInfo richMediaBrowserInfo) {
        if (N0()) {
            return false;
        }
        return super.y(richMediaBrowserInfo);
    }

    @Override // com.tencent.mobileqq.richmediabrowser.view.a
    public boolean z() {
        AIOPictureData I0;
        if (super.z() && (I0 = I0()) != null) {
            tm2.d dVar = new tm2.d();
            File c16 = dVar.c(I0, 4);
            if (c16 == null) {
                c16 = dVar.c(I0, 2);
            }
            if ((c16 != null || !com.tencent.mobileqq.richmediabrowser.h.a().s()) && !com.tencent.mobileqq.richmediabrowser.h.a().s() && !com.tencent.mobileqq.richmediabrowser.h.a().q()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class a implements IGalleryImageListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ URLDrawable f282018d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ File f282019e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ AIOPictureData f282020f;

        a(URLDrawable uRLDrawable, File file, AIOPictureData aIOPictureData) {
            this.f282018d = uRLDrawable;
            this.f282019e = file;
            this.f282020f = aIOPictureData;
        }

        @Override // com.tencent.richmediabrowser.listener.IGalleryImageListener
        public void onLoadSuccessed(int i3, boolean z16) {
            AIOPictureView.this.f282003i0.setVisibility(8);
            if (z16) {
                AIOPictureView.this.n1(this.f282018d, this.f282019e, i3);
            } else {
                AIOPictureView.this.z0(this.f282020f);
            }
        }

        @Override // com.tencent.richmediabrowser.listener.IGalleryImageListener
        public void onLoadDrawable(int i3, URLDrawable uRLDrawable) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class b implements IGalleryImageListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ URLDrawable f282022d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ File f282023e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ AIOPictureData f282024f;

        b(URLDrawable uRLDrawable, File file, AIOPictureData aIOPictureData) {
            this.f282022d = uRLDrawable;
            this.f282023e = file;
            this.f282024f = aIOPictureData;
        }

        @Override // com.tencent.richmediabrowser.listener.IGalleryImageListener
        public void onLoadSuccessed(int i3, boolean z16) {
            AIOPictureView.this.f282003i0.setVisibility(8);
            if (z16) {
                AIOPictureView.this.n1(this.f282022d, this.f282023e, i3);
            } else {
                AIOPictureView.this.z0(this.f282024f);
            }
        }

        @Override // com.tencent.richmediabrowser.listener.IGalleryImageListener
        public void onLoadDrawable(int i3, URLDrawable uRLDrawable) {
        }
    }
}
