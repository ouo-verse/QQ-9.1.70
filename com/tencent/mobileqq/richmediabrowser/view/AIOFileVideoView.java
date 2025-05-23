package com.tencent.mobileqq.richmediabrowser.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.mini.api.IMiniAppFileMaterialService;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qqvideoedit.api.IQQVideoEditApi;
import com.tencent.mobileqq.qqvideoplatform.api.SceneID;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend;
import com.tencent.mobileqq.richmediabrowser.api.IFileDepend;
import com.tencent.mobileqq.richmediabrowser.api.IVideoDepend;
import com.tencent.mobileqq.richmediabrowser.f;
import com.tencent.mobileqq.richmediabrowser.h;
import com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData;
import com.tencent.mobileqq.richmediabrowser.presenter.AIOBrowserPresenter;
import com.tencent.mobileqq.richmediabrowser.qqfloatingscreen.TVKVideoController;
import com.tencent.mobileqq.richmediabrowser.utils.RichMediaBrowserUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.ao;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.locate.api.IMsgLocationApi;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.BrowserBasePresenter;
import com.tencent.richmediabrowser.view.GalleryUrlImageView;
import com.tencent.richmediabrowser.view.IBrowserViewHolder;
import com.tencent.richmediabrowser.view.video.VideoView;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.util.PermissionUtil;
import cooperation.peak.PeakConstants;
import e04.g;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class AIOFileVideoView extends com.tencent.mobileqq.richmediabrowser.view.a implements View.OnClickListener, VideoPlayerCallback, g {
    public com.tencent.mobileqq.richmediabrowser.presenter.c Q;
    public VideoView R;
    public RelativeLayout S;
    public TextView T;
    public ImageView U;
    public SeekBar V;
    public ImageButton W;
    public ImageButton X;
    private View Y;
    private TVKVideoController Z;

    /* renamed from: a0, reason: collision with root package name */
    public int f281975a0;

    /* renamed from: b0, reason: collision with root package name */
    private VideoPlayParam f281976b0;

    /* renamed from: c0, reason: collision with root package name */
    protected ArrayList<ShareActionSheetBuilder.ActionSheetItem> f281977c0;

    /* renamed from: d0, reason: collision with root package name */
    public String f281978d0;

    /* renamed from: e0, reason: collision with root package name */
    private long f281979e0;

    /* renamed from: f0, reason: collision with root package name */
    private String f281980f0;

    /* renamed from: g0, reason: collision with root package name */
    ArrayList<ShareActionSheetBuilder.ActionSheetItem> f281981g0;

    /* renamed from: h0, reason: collision with root package name */
    ArrayList<ShareActionSheetBuilder.ActionSheetItem> f281982h0;

    /* renamed from: i0, reason: collision with root package name */
    private f f281983i0;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f281984j0;

    /* renamed from: k0, reason: collision with root package name */
    private final Runnable f281985k0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a extends AccessibilityDelegateCompat {
        a() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setClassName(Button.class.getName());
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            AIOFileVideoData aIOFileVideoData;
            if (32768 == accessibilityEvent.getEventType()) {
                com.tencent.mobileqq.richmediabrowser.presenter.c cVar = AIOFileVideoView.this.Q;
                if (cVar != null) {
                    aIOFileVideoData = cVar.V();
                } else {
                    aIOFileVideoData = null;
                }
                String str = "\u6682\u505c";
                if (aIOFileVideoData != null && aIOFileVideoData.status != 3) {
                    str = "\u64ad\u653e";
                }
                view.setContentDescription(str);
            }
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            AIOFileVideoView.this.Q.back();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c implements ShareActionSheet.OnItemClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AIOFileVideoData f281990d;

        c(AIOFileVideoData aIOFileVideoData) {
            this.f281990d = aIOFileVideoData;
        }

        @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
        public void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
            if (actionSheetItem != null) {
                AIOFileVideoView aIOFileVideoView = AIOFileVideoView.this;
                if (aIOFileVideoView.f282077h instanceof Activity) {
                    aIOFileVideoView.f282075e.dismiss();
                    switch (actionSheetItem.action) {
                        case 2:
                        case 73:
                            AIOFileVideoView.this.d0(this.f281990d);
                            break;
                        case 6:
                            if (AIOFileVideoView.this.c0() && AIOFileVideoView.this.f281983i0 != null) {
                                AIOFileVideoView.this.f281983i0.d(this.f281990d.msgId);
                            }
                            AIOBrowserPresenter aIOBrowserPresenter = AIOFileVideoView.this.Q.f281859e;
                            if (aIOBrowserPresenter != null) {
                                aIOBrowserPresenter.R(5);
                                break;
                            }
                            break;
                        case 26:
                            if (AIOFileVideoView.this.c0() && AIOFileVideoView.this.f281983i0 != null) {
                                AIOFileVideoView.this.f281983i0.m(this.f281990d.msgId);
                                ReportController.o(null, "dc00898", "", "", "0X800A60E", "0X800A60E", 0, 0, "", "", "", "");
                                Context context = AIOFileVideoView.this.f282077h;
                                QQToast.makeText(context, 2, context.getString(R.string.f221616ba), 0).show();
                                break;
                            }
                            break;
                        case 27:
                            if (AIOFileVideoView.this.c0() && AIOFileVideoView.this.f281983i0 != null) {
                                AIOFileVideoView.this.f281983i0.f(this.f281990d.msgId);
                                Context context2 = AIOFileVideoView.this.f282077h;
                                QQToast.makeText(context2, context2.getString(R.string.f221626bb), 0).show();
                                break;
                            }
                            break;
                        case 39:
                            AIOFileVideoView.this.p0(this.f281990d);
                            AIOBrowserPresenter aIOBrowserPresenter2 = AIOFileVideoView.this.Q.f281859e;
                            if (aIOBrowserPresenter2 != null) {
                                aIOBrowserPresenter2.R(3);
                                break;
                            }
                            break;
                        case 54:
                            String i3 = h.a().i();
                            if (TextUtils.isEmpty(i3)) {
                                i3 = h.a().g();
                            }
                            String str = i3;
                            IMsgLocationApi iMsgLocationApi = (IMsgLocationApi) QRoute.api(IMsgLocationApi.class);
                            Activity activity = (Activity) AIOFileVideoView.this.f282077h;
                            int f16 = h.a().f();
                            String g16 = h.a().g();
                            AIOFileVideoData aIOFileVideoData = this.f281990d;
                            iMsgLocationApi.jumpToTargetNTAIOPosition(activity, f16, g16, str, aIOFileVideoData.shmsgseq, aIOFileVideoData.msgId);
                            AIOBrowserPresenter aIOBrowserPresenter3 = AIOFileVideoView.this.Q.f281859e;
                            if (aIOBrowserPresenter3 != null) {
                                aIOBrowserPresenter3.R(6);
                                break;
                            }
                            break;
                        case 56:
                            AIOFileVideoView.this.o0(this.f281990d, 2);
                            ReportController.o(null, "dc00898", "", "", "0X800AD48", "0X800AD48", AIOFileVideoView.this.k0(this.f281990d.Q), 0, "", "", "", "");
                            break;
                        case 64:
                            ah.r1((Activity) AIOFileVideoView.this.f282077h, this.f281990d.f281839f);
                            break;
                        case 72:
                            AIOFileVideoView.this.e0(actionSheetItem, this.f281990d);
                            break;
                        case 94:
                            AIOFileVideoView.this.i0();
                            AIOBrowserPresenter aIOBrowserPresenter4 = AIOFileVideoView.this.Q.f281859e;
                            if (aIOBrowserPresenter4 != null) {
                                aIOBrowserPresenter4.R(4);
                                break;
                            }
                            break;
                        case 126:
                            AIOFileVideoView.this.o0(this.f281990d, 1);
                            ReportController.o(null, "dc00898", "", "", "0X800AD47", "0X800AD47", AIOFileVideoView.this.k0(this.f281990d.Q), 0, "", "", "", "");
                            break;
                        case 132:
                            QbSdk.clearDefaultBrowser(AIOFileVideoView.this.f282077h, this.f281990d.f281839f);
                            ah.r1((Activity) AIOFileVideoView.this.f282077h, this.f281990d.f281839f);
                            break;
                        case 166:
                            ((IMiniAppFileMaterialService) QRoute.api(IMiniAppFileMaterialService.class)).showSupportedAppList((Activity) AIOFileVideoView.this.f282077h, this.f281990d.f281839f);
                            break;
                        case 179:
                            AIOFileVideoView.this.g0();
                            AIOBrowserPresenter aIOBrowserPresenter5 = AIOFileVideoView.this.Q.f281859e;
                            if (aIOBrowserPresenter5 != null) {
                                aIOBrowserPresenter5.L();
                                break;
                            }
                            break;
                    }
                    String W0 = AIOPictureView.W0(this.f281990d);
                    String V0 = AIOPictureView.V0();
                    QLog.i("AIOFileVideoView<FileAssistant>XOXO", 2, "reportClickEvent 0X8009EFA sessionType=" + W0 + "enterType=" + V0);
                    ReportController.o(null, "dc00898", "", "", "0X8009EFA", "0X8009EFA", AIOFileVideoView.this.l0(actionSheetItem.action), 0, W0, V0, "", "");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class d extends QQPermission.BasePermissionsListener {
        d() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class e extends IBrowserViewHolder {

        /* renamed from: a, reason: collision with root package name */
        public BaseVideoView f281993a;

        public e() {
        }
    }

    public AIOFileVideoView(Context context, com.tencent.mobileqq.richmediabrowser.presenter.c cVar) {
        super(context, cVar);
        this.f281979e0 = -1L;
        this.f281980f0 = "";
        this.f281981g0 = new ArrayList<>();
        this.f281982h0 = new ArrayList<>();
        this.f281984j0 = false;
        this.f281985k0 = new Runnable() { // from class: com.tencent.mobileqq.richmediabrowser.view.AIOFileVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                AIOFileVideoView.this.Q.p().f281782d = true;
                AIOFileVideoView.this.m(false);
                AIOFileVideoView.this.L0(0);
                AIOFileVideoView.this.updateUI();
            }
        };
        this.Q = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0148  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void C0(Bitmap bitmap) {
        String str;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        String jSONObject3;
        if (bitmap == null) {
            if (QLog.isColorLevel()) {
                QLog.i("AIOFileVideoView<FileAssistant>XOXO", 2, "onVideoFrameCallBack, videoFrame null");
                return;
            }
            return;
        }
        try {
            File file = new File(BaseApplication.getContext().getFilesDir().getAbsolutePath() + File.separator + "tmpaiovideoframe.jpg");
            if (!file.exists()) {
                file.createNewFile();
            }
            this.f281980f0 = file.getAbsolutePath();
            if (QLog.isColorLevel()) {
                QLog.i("AIOFileVideoView<FileAssistant>XOXO", 2, "onVideoFrameCallBack, write tmp file:" + this.f281980f0);
            }
            RichMediaBrowserUtils.i(bitmap, this.f281980f0);
        } catch (IOException e16) {
            e16.printStackTrace();
        }
        final ArrayList arrayList = new ArrayList();
        SparseArray<Object> detectCode = ((IFileDepend) QRoute.api(IFileDepend.class)).getDetectCode(bitmap);
        String str2 = "";
        JSONObject jSONObject4 = null;
        if (detectCode.get(0) != null) {
            if (QLog.isColorLevel()) {
                QLog.i("AIOFileVideoView<FileAssistant>XOXO", 2, "onVideoFrameCallBack, detected QRCode, build item");
            }
            if (detectCode.get(0) instanceof Pair) {
                Pair pair = (Pair) detectCode.get(0);
                try {
                    jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("scannerType", String.valueOf(pair.second).trim());
                        jSONObject2.put("scannerResult", String.valueOf(pair.first).trim());
                    } catch (JSONException e17) {
                        e = e17;
                        e.printStackTrace();
                        if (jSONObject2 != null) {
                        }
                        RichMediaBrowserUtils.b(126, arrayList, jSONObject3, 0);
                        if (detectCode.get(1) != null) {
                        }
                        if (arrayList.isEmpty()) {
                        }
                    }
                } catch (JSONException e18) {
                    e = e18;
                    jSONObject2 = null;
                }
            } else {
                jSONObject2 = null;
            }
            if (jSONObject2 != null) {
                jSONObject3 = "";
            } else {
                jSONObject3 = jSONObject2.toString();
            }
            RichMediaBrowserUtils.b(126, arrayList, jSONObject3, 0);
        }
        if (detectCode.get(1) != null) {
            if (QLog.isColorLevel()) {
                QLog.i("AIOFileVideoView<FileAssistant>XOXO", 2, "onVideoFrameCallBack, detected MiniCode, build item");
            }
            if (detectCode.get(1) instanceof String) {
                try {
                    str = (String) detectCode.get(1);
                    jSONObject = new JSONObject();
                } catch (JSONException e19) {
                    e = e19;
                }
                try {
                    jSONObject.put("strMini", str);
                    if (detectCode.get(2) instanceof String) {
                        jSONObject.put("strMini", (String) detectCode.get(2));
                    }
                    jSONObject4 = jSONObject;
                } catch (JSONException e26) {
                    e = e26;
                    jSONObject4 = jSONObject;
                    e.printStackTrace();
                    if (jSONObject4 != null) {
                    }
                    RichMediaBrowserUtils.b(127, arrayList, str2, 0);
                    if (arrayList.isEmpty()) {
                    }
                }
            }
            if (jSONObject4 != null) {
                str2 = jSONObject4.toString();
            }
            RichMediaBrowserUtils.b(127, arrayList, str2, 0);
        }
        if (arrayList.isEmpty()) {
            if (QLog.isColorLevel()) {
                QLog.i("AIOFileVideoView<FileAssistant>XOXO", 2, "onVideoFrameCallBack, detected nothing");
                return;
            }
            return;
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.richmediabrowser.view.AIOFileVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ShareActionSheetBuilder.ActionSheetItem actionSheetItem = (ShareActionSheetBuilder.ActionSheetItem) it.next();
                    AIOFileVideoView.this.f281982h0.add(r2.size() - 1, actionSheetItem);
                }
                AIOFileVideoView aIOFileVideoView = AIOFileVideoView.this;
                aIOFileVideoView.f282075e.setActionSheetItems(aIOFileVideoView.f281981g0, aIOFileVideoView.f281982h0);
                if (AIOFileVideoView.this.f282075e.isShowing()) {
                    if (QLog.isColorLevel()) {
                        QLog.i("AIOFileVideoView<FileAssistant>XOXO", 2, "onVideoFrameCallBack, refresh share menu");
                    }
                    AIOFileVideoView.this.f282075e.refresh();
                    return;
                }
                AIOFileVideoView.this.f282075e.show();
            }
        });
    }

    private void D0() {
        VideoView videoView = this.R;
        if (videoView != null) {
            videoView.pauseVideo();
        }
        com.tencent.mobileqq.richmediabrowser.presenter.c cVar = this.Q;
        if (cVar.z(cVar.f281861h.getCurrentPosition())) {
            this.Q.I(true);
        }
    }

    private void E0(tm2.f fVar) {
        this.f281976b0 = a0(fVar);
        this.R.setVideoPlayCallback(this);
        VideoView videoView = this.R;
        if (videoView.mVideoView != null) {
            videoView.setVideoPlayCallback(this.f281976b0);
            this.R.mVideoView.setVideoParam(this.f281976b0);
            this.R.mVideoView.play();
        }
    }

    private void H0(boolean z16) {
        RichMediaBrowserInfo selectedItem;
        if (z16 && (selectedItem = this.Q.f281861h.getSelectedItem()) != null) {
            RichMediaBaseData richMediaBaseData = selectedItem.baseData;
            if ((richMediaBaseData instanceof AIOFileVideoData) && !FileUtils.fileExistsAndNotEmpty(((AIOFileVideoData) richMediaBaseData).f281839f)) {
                z16 = false;
            }
        }
        this.f281984j0 = z16;
    }

    private void J0(boolean z16) {
        int i3;
        View view = this.Y;
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
    public void K0(int i3, boolean z16) {
        RichMediaBaseData richMediaBaseData;
        if (QLog.isColorLevel()) {
            QLog.d("AIOFileVideoView<FileAssistant>XOXO", 2, "tryPlayVideo, position = " + i3);
        }
        RichMediaBrowserInfo item = this.Q.f281861h.getItem(i3);
        if (item != null && (richMediaBaseData = item.baseData) != null && richMediaBaseData.getType() == 103) {
            AIOFileVideoData aIOFileVideoData = (AIOFileVideoData) item.baseData;
            if (QLog.isColorLevel()) {
                QLog.d("AIOFileVideoView<FileAssistant>XOXO", 2, String.format("tryPlayVideo, position:%d , msgId:%s request:%b ", Integer.valueOf(i3), Long.valueOf(aIOFileVideoData.msgId), Boolean.valueOf(aIOFileVideoData.G)));
            }
            aIOFileVideoData.L = z16;
            tm2.c cVar = new tm2.c();
            if (!cVar.i(aIOFileVideoData) && !aIOFileVideoData.G) {
                cVar.j(aIOFileVideoData, this.f281983i0);
                this.Q.X(aIOFileVideoData);
                this.Q.R(aIOFileVideoData.msgId, aIOFileVideoData.subId, 1);
                updateUI();
                return;
            }
            E0(cVar.g(aIOFileVideoData, aIOFileVideoData.M));
            if (aIOFileVideoData.I && aIOFileVideoData.C != null) {
                L0(3);
            }
            updateUI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L0(int i3) {
        AIOFileVideoData j06 = j0();
        if (j06 != null) {
            this.Q.R(j06.msgId, j06.subId, i3);
        }
    }

    private void M0(boolean z16) {
        BaseVideoView baseVideoView;
        VideoView videoView = this.R;
        if (videoView != null && (baseVideoView = videoView.mVideoView) != null && !baseVideoView.isPlaying()) {
            D0();
        } else {
            L0(3);
        }
    }

    private void N0() {
        I0(false);
        H0(true);
        K(this.R, 5);
        J(this.Q, 5);
        this.P.postDelayed(this.f281985k0, 3000L);
    }

    private VideoPlayParam a0(tm2.f fVar) {
        VideoPlayParam videoPlayParam = new VideoPlayParam();
        boolean z16 = !fVar.f436607a;
        videoPlayParam.mIsLocal = z16;
        if (!z16) {
            Bundle bundle = fVar.f436624r;
            if (bundle != null) {
                videoPlayParam.mSavePath = bundle.getString("savepath");
                videoPlayParam.mFileID = fVar.f436624r.getString(QCircleSchemeAttr.Detail.FEED_VIDEO_ID);
            } else {
                QLog.e("AIOFileVideoView<FileAssistant>XOXO", 1, "bundle is null!!!");
            }
            videoPlayParam.mUrls = fVar.f436609c;
            videoPlayParam.mCookies = fVar.f436610d;
            videoPlayParam.mVideoFormat = 104;
            L0(1);
        } else {
            videoPlayParam.mVideoPath = fVar.f436608b;
            L0(3);
        }
        videoPlayParam.mIsMute = fVar.f436619m;
        videoPlayParam.mSceneId = 109;
        videoPlayParam.mSceneName = SceneID.getSceneStr(109);
        videoPlayParam.mIsLoop = false;
        videoPlayParam.mNeedPlayProgress = true;
        return videoPlayParam;
    }

    private void b0(boolean z16, View view) {
        String str;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && ((IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("talkback_fix_enable") && AppSetting.f99565y) {
            CharSequence contentDescription = view.getContentDescription();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("\u5df2\u5207\u6362\u5230");
            if (z16) {
                str = "\u64ad\u653e";
            } else {
                str = "\u6682\u505c";
            }
            sb5.append(str);
            String sb6 = sb5.toString();
            if (!TextUtils.isEmpty(contentDescription) && contentDescription.toString().equals(sb6)) {
                return;
            }
            view.setContentDescription(sb6);
            view.sendAccessibilityEvent(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c0() {
        f fVar = this.f281983i0;
        if (fVar != null && fVar.n()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0(AIOFileVideoData aIOFileVideoData) {
        f fVar;
        boolean z16;
        if (c0() && (fVar = this.f281983i0) != null) {
            Intent u16 = fVar.u(aIOFileVideoData.msgId, aIOFileVideoData.subId, 0);
            if (aIOFileVideoData.istroop == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).forwardToFriend((Activity) this.f282077h, u16, z16, ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).getSharePanelType(), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, AIOFileVideoData aIOFileVideoData) {
        f fVar;
        boolean z16;
        int i3 = actionSheetItem.uinType;
        String str = actionSheetItem.uin;
        if (i3 == 10014) {
            Context context = this.f282077h;
            QQToast.makeText(context, context.getString(R.string.zzd), 0).show();
        } else if (c0() && (fVar = this.f281983i0) != null) {
            Intent u16 = fVar.u(aIOFileVideoData.msgId, aIOFileVideoData.subId, 0);
            if (aIOFileVideoData.istroop == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            ((IFileDepend) QRoute.api(IFileDepend.class)).forwardToTargetFriend((Activity) this.f282077h, u16, z16, str, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap f0(Drawable drawable) {
        Bitmap createBitmap;
        if (drawable == null) {
            if (QLog.isColorLevel()) {
                QLog.i("AIOFileVideoView<FileAssistant>XOXO", 2, "drawable2Bitmap, drawable is null");
                return null;
            }
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                return bitmapDrawable.getBitmap();
            }
        }
        if (drawable.getIntrinsicWidth() > 0 && drawable.getIntrinsicHeight() > 0) {
            createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        } else {
            createBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g0() {
        AIOFileVideoData V = this.Q.V();
        if (V == null || !FileUtils.fileExistsAndNotEmpty(V.f281839f)) {
            return;
        }
        TVKVideoController tVKVideoController = this.Z;
        if (tVKVideoController != null) {
            tVKVideoController.r();
        }
        long curPlayingPos = this.R.mVideoView.getCurPlayingPos();
        TVKVideoController tVKVideoController2 = new TVKVideoController(this.f282077h);
        this.Z = tVKVideoController2;
        tVKVideoController2.w(V.f281839f, V.msgId, curPlayingPos);
        if (FileUtils.fileExistsAndNotEmpty(V.f281838e)) {
            this.Z.u(V.f281838e, V.f281841i, V.f281842m);
        }
        if (this.Z.s(V.istroop, V.f281841i, V.f281842m)) {
            this.Q.back();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0() {
        AIOFileVideoData V = this.Q.V();
        if (V == null) {
            QLog.e("AIOFileVideoView<FileAssistant>XOXO", 1, "enterVideoEditPage error, aioVideoData is null!");
            return;
        }
        Context context = this.f282077h;
        if (!(context instanceof Activity)) {
            QLog.e("AIOFileVideoView<FileAssistant>XOXO", 1, "enterVideoEditPage error, mContext is not instance of Activity!");
            return;
        }
        Activity activity = (Activity) context;
        if (!((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).isCameraResReady("qq_aio")) {
            QQToast.makeText(activity, activity.getResources().getString(R.string.f237737hv), 0).show();
            return;
        }
        Intent intent = new Intent();
        intent.putExtras(activity.getIntent());
        ((IQQVideoEditApi) QRoute.api(IQQVideoEditApi.class)).jumpToVideoEditPage(activity, intent, RichMediaBrowserUtils.c(1, V.f281839f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int k0(int i3) {
        if (i3 == 0) {
            return 1;
        }
        if (i3 == 1) {
            return 2;
        }
        if (i3 == 3000) {
            return 3;
        }
        return 9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int l0(int i3) {
        if (i3 != 2) {
            if (i3 != 6) {
                if (i3 != 27) {
                    if (i3 == 39) {
                        return 2;
                    }
                    if (i3 != 64) {
                        if (i3 != 132) {
                            if (i3 != 179) {
                                switch (i3) {
                                    case 54:
                                        return 6;
                                    case 55:
                                        return 8;
                                    case 56:
                                        return 9;
                                    default:
                                        return -1;
                                }
                            }
                            return 10;
                        }
                        return 13;
                    }
                    return 11;
                }
                return 5;
            }
            return 3;
        }
        return 1;
    }

    private String n0(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 != 6) {
                                if (i3 != 7) {
                                    return "undefine";
                                }
                                return "Saving";
                            }
                            return "Error";
                        }
                        return "Pause";
                    }
                    return "Playing";
                }
                return "Buffering";
            }
            return "Downloading";
        }
        return "Nomal";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0(AIOFileVideoData aIOFileVideoData, int i3) {
        String g16;
        if (com.tencent.mobileqq.service.message.remote.a.b(aIOFileVideoData.R)) {
            g16 = h.a().m();
        } else {
            g16 = h.a().g();
        }
        ((IVideoDepend) QRoute.api(IVideoDepend.class)).onQRDecodeSucceed(this.f282077h, this.f281980f0, aIOFileVideoData.Q, true, g16, null, null, aIOFileVideoData.S, i3, h.a().m(), h.a().g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0(AIOFileVideoData aIOFileVideoData) {
        if (!PermissionUtil.isHasStoragePermission(this.f282077h) && (this.f282077h instanceof Activity)) {
            QQPermission qQPermission = QQPermissionFactory.getQQPermission((Activity) this.f282077h, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_RICH_MEDIA_SAVE, QQPermissionConstants.Business.SCENE.RICH_MEDIA_AIO_SAVE_VIDEO));
            if (qQPermission != null) {
                qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new d());
                return;
            }
            return;
        }
        if (new tm2.c().i(aIOFileVideoData)) {
            ((IFileDepend) QRoute.api(IFileDepend.class)).saveToAlbum(this.f282077h, aIOFileVideoData.f281839f);
            return;
        }
        Bundle bundle = new Bundle();
        f fVar = this.f281983i0;
        if (fVar != null) {
            fVar.C(aIOFileVideoData.msgId, 13, bundle);
        }
        aIOFileVideoData.N = true;
        O0(aIOFileVideoData.msgId, aIOFileVideoData.subId);
        updateUI();
    }

    private void q0(int i3, int i16, VideoPlayParam videoPlayParam) {
        String str;
        String str2;
        tm2.f g16;
        final AIOFileVideoData j06 = j0();
        boolean z16 = false;
        if (i3 == 2 && j06 != null && (g16 = new tm2.c().g(j06, j06.M)) != null && g16.f436609c != null && !StringUtil.isEmpty(g16.f436611e)) {
            for (String str3 : g16.f436609c) {
                if (!StringUtil.isEmpty(str3)) {
                    InnerDns.getInstance().reportBadIp(g16.f436611e, InnerDns.getHostFromUrl(str3), ((IVideoDepend) QRoute.api(IVideoDepend.class)).getVideoIpType());
                }
            }
            com.tencent.mobileqq.richmediabrowser.utils.g.e().c();
        }
        if (i3 == 1) {
            str = this.f282077h.getString(R.string.f222006cc);
        } else {
            str = null;
        }
        if (j06 != null) {
            if (str == null) {
                str = this.f282077h.getString(R.string.f221936c6);
            }
            j06.J = str;
            j06.V++;
            BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView<FileAssistant>XOXO", 2, "handlePlayError, videoData.mPlayErrTimes = " + j06.V);
        }
        if (videoPlayParam != null && (str2 = videoPlayParam.mVideoPath) != null && str2.startsWith(AppConstants.SDCARD_FILE_SAVE_PATH)) {
            z16 = com.tencent.mobileqq.qqvideoplatform.a.a(i16, videoPlayParam);
        }
        if (z16 && this.R.mVideoView != null && j06 != null && j06.V < 2) {
            BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView<FileAssistant>XOXO", 2, "handlePlayError, auto replay video.");
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.richmediabrowser.view.AIOFileVideoView.4
                @Override // java.lang.Runnable
                public void run() {
                    AIOFileVideoView aIOFileVideoView = AIOFileVideoView.this;
                    aIOFileVideoView.K0(aIOFileVideoView.Q.f281861h.getCurrentPosition(), j06.M);
                }
            });
        } else {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.richmediabrowser.view.AIOFileVideoView.5
                @Override // java.lang.Runnable
                public void run() {
                    AIOFileVideoView.this.L0(6);
                    AIOFileVideoView.this.updateUI();
                }
            });
        }
    }

    private void t0(View view) {
        View findViewById;
        View findViewById2;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || !((IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("talkback_fix_enable") || !AppSetting.f99565y || (findViewById = view.findViewById(R.id.fac)) == null || (findViewById2 = findViewById.findViewById(R.id.fff)) == null || (ViewCompat.getAccessibilityDelegate(findViewById2) instanceof AccessibilityDelegateCompat)) {
            return;
        }
        ViewCompat.setAccessibilityDelegate(findViewById2, new a());
    }

    private boolean u0(AIOFileVideoData aIOFileVideoData, boolean z16) {
        long j3 = aIOFileVideoData.E;
        if (j3 == -7003 || j3 == -6101 || j3 == -103 || j3 == -301) {
            return true;
        }
        return z16;
    }

    private boolean v0(AIOFileVideoData aIOFileVideoData) {
        if (this.f281983i0.c(aIOFileVideoData.msgId) && aIOFileVideoData.Q != 10014) {
            return true;
        }
        return false;
    }

    private boolean w0(AIOFileVideoData aIOFileVideoData) {
        if (aIOFileVideoData.Q != 10014) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.richmediabrowser.view.a
    public void A(int i3) {
        super.A(i3);
        AIOFileVideoData V = this.Q.V();
        if (V != null) {
            r0(V, i3);
        }
    }

    public void A0() {
        AIOFileVideoData V;
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView<FileAssistant>XOXO", 4, "onResume");
        com.tencent.mobileqq.richmediabrowser.presenter.c cVar = this.Q;
        if (cVar.a0(cVar.f281861h.getCurrentPosition()) && this.R.mVideoView != null && (V = this.Q.V()) != null && V.status == 4) {
            this.R.mVideoView.resume();
        }
    }

    public void B0() {
        this.Q.Z(j0());
    }

    public void F0(AIOFileVideoData aIOFileVideoData) {
        this.f282075e.setItemClickListenerV2(new c(aIOFileVideoData));
    }

    public void G0(int i3, String str, String[] strArr, String str2, MessageRecord messageRecord, int i16, Bundle bundle) {
        RichMediaBaseData richMediaBaseData;
        boolean u06;
        String str3;
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView<FileAssistant>XOXO", 4, "setVideoDrawableWithUrls position = " + i3);
        RichMediaBrowserInfo item = this.Q.f281861h.getItem(i3);
        if (item != null && (richMediaBaseData = item.baseData) != null && richMediaBaseData.getType() == 103) {
            AIOFileVideoData aIOFileVideoData = (AIOFileVideoData) item.baseData;
            aIOFileVideoData.U = bundle;
            tm2.c cVar = new tm2.c();
            if (aIOFileVideoData.G) {
                BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView<FileAssistant>XOXO", 4, "fileVideo is playing:" + aIOFileVideoData.f365136id);
                return;
            }
            aIOFileVideoData.f281839f = str;
            aIOFileVideoData.G = true;
            if (AIOBrowserBaseData.MEDIA_FILE_ERROR.equals(str)) {
                try {
                    aIOFileVideoData.E = Long.parseLong(strArr[0]);
                    String str4 = strArr[1];
                    ((AIOFileVideoData) item.baseData).J = str4;
                    this.Q.R(aIOFileVideoData.msgId, aIOFileVideoData.subId, 6);
                    if (((IFileDepend) QRoute.api(IFileDepend.class)).isVideoFileError(aIOFileVideoData.E)) {
                        str3 = this.f282077h.getString(R.string.f222016cd);
                        u06 = true;
                    } else {
                        u06 = u0(aIOFileVideoData, false);
                        str3 = str4;
                    }
                    if (u06) {
                        Context context = this.f282077h;
                        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 230, "", str3, (String) null, context.getString(R.string.f221706bj), new b(), (DialogInterface.OnClickListener) null);
                        if (!createCustomDialog.isShowing()) {
                            createCustomDialog.show();
                            return;
                        }
                        return;
                    }
                } catch (NumberFormatException unused) {
                    aIOFileVideoData.E = -1L;
                }
                aIOFileVideoData.F = strArr[1];
            } else {
                aIOFileVideoData.C = strArr[0];
                aIOFileVideoData.D = bundle.getStringArrayList("cookies");
            }
            this.Q.R(aIOFileVideoData.msgId, aIOFileVideoData.subId, 0);
            tm2.f g16 = cVar.g(aIOFileVideoData, aIOFileVideoData.M);
            BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView<FileAssistant>XOXO", 4, "setVideoDrawableWithUrls autoPlay id = " + aIOFileVideoData.f365136id);
            this.Q.R(aIOFileVideoData.msgId, aIOFileVideoData.subId, 3);
            E0(g16);
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.view.a
    public void I() {
        J0(true);
    }

    public void I0(boolean z16) {
        int i3;
        RelativeLayout relativeLayout = this.S;
        if (relativeLayout != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            relativeLayout.setVisibility(i3);
        }
        Z(z());
    }

    public void O0(long j3, int i3) {
        this.Q.R(j3, i3, 7);
    }

    public void Z(boolean z16) {
        if (this.S != null) {
            DisplayMetrics displayMetrics = this.f282077h.getResources().getDisplayMetrics();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.S.getLayoutParams();
            layoutParams.addRule(12, -1);
            if (z16) {
                layoutParams.rightMargin = (int) TypedValue.applyDimension(1, 49.0f, displayMetrics);
            } else {
                layoutParams.rightMargin = (int) TypedValue.applyDimension(1, 10.0f, displayMetrics);
            }
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.view.a, e04.e
    public View a(View view, ViewGroup viewGroup) {
        this.H = (RelativeLayout) LayoutInflater.from(this.f282077h).inflate(R.layout.hnm, (ViewGroup) null);
        s0();
        RelativeLayout relativeLayout = this.R.videoControlContainer;
        if (relativeLayout != null) {
            relativeLayout.addView(this.H);
        }
        return this.R.mBrowserItemView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v7, types: [android.graphics.drawable.Drawable] */
    @Override // com.tencent.mobileqq.richmediabrowser.view.a, e04.e
    public void b(int i3) {
        RichMediaBaseData richMediaBaseData;
        RichMediaBaseData richMediaBaseData2;
        super.b(i3);
        RichMediaBrowserInfo item = this.Q.f281861h.getItem(i3);
        if (item != null && (richMediaBaseData = item.baseData) != null && richMediaBaseData.getType() == 103) {
            RichMediaBrowserInfo o16 = this.Q.o();
            if (o16 != null && (richMediaBaseData2 = o16.baseData) != null && richMediaBaseData2.getType() == 103 && ((AIOBrowserBaseData) o16.baseData).msgId == ((AIOBrowserBaseData) item.baseData).msgId && !o16.isReport) {
                ReportController.o(null, "dc00898", "", "", "0X8009EF3", "0X8009EF3", 1, 0, "", "", "", "");
                o16.isReport = true;
            } else {
                ReportController.o(null, "dc00898", "", "", "0X8009EF3", "0X8009EF3", 2, 0, "", "", "", "");
            }
            AIOFileVideoData aIOFileVideoData = (AIOFileVideoData) item.baseData;
            tm2.c cVar = new tm2.c();
            URLDrawable uRLDrawable = this.Q.f281861h.mActiveDrawable.get(Integer.valueOf(i3));
            URLDrawable uRLDrawable2 = uRLDrawable;
            if (!cVar.h(aIOFileVideoData)) {
                if (uRLDrawable != null && uRLDrawable.getStatus() == 1) {
                    this.Q.f281861h.onLoadFinish(i3, true);
                    uRLDrawable2 = uRLDrawable;
                } else if (!TextUtils.isEmpty(aIOFileVideoData.f281838e)) {
                    File file = new File(aIOFileVideoData.f281838e);
                    URL d16 = AsyncImageView.d(aIOFileVideoData.f281838e, this.J, this.K, file, false, false, false);
                    uRLDrawable2 = uRLDrawable;
                    if (d16 != null) {
                        uRLDrawable2 = uRLDrawable;
                        if (file.exists()) {
                            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                            obtain.mRequestWidth = this.J;
                            obtain.mRequestHeight = this.K;
                            obtain.mLoadingDrawable = com.tencent.mobileqq.urldrawable.b.f306350a;
                            obtain.mPlayGifImage = true;
                            obtain.mUseExifOrientation = false;
                            URLDrawable drawable = URLDrawable.getDrawable(d16, obtain);
                            drawable.setTag(1);
                            this.Q.f281861h.mActiveDrawable.put(Integer.valueOf(i3), drawable);
                            uRLDrawable2 = drawable;
                        }
                    }
                } else {
                    uRLDrawable2 = BaseApplication.getContext().getResources().getDrawable(R.drawable.mzb);
                }
            }
            this.R.coverView.setImageDrawable(uRLDrawable2);
            if (cVar.h(aIOFileVideoData)) {
                this.R.coverView.setImageDrawable(null);
            }
            if (item.isEnterImage) {
                aIOFileVideoData.K = true;
            }
            e eVar = new e();
            VideoView videoView = this.R;
            eVar.f281993a = videoView.mVideoView;
            videoView.mBrowserItemView.setTag(eVar);
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.view.a, e04.e
    public void c(int i3, View view) {
        ConcurrentHashMap<Integer, URLDrawable> concurrentHashMap = this.Q.f281861h.mActiveDrawable;
        if (concurrentHashMap != null) {
            concurrentHashMap.remove(Integer.valueOf(i3));
        }
    }

    @Override // e04.g
    public void d() {
        if (this.Q.x()) {
            if (this.Q.p().f281782d) {
                this.Q.p().i();
                this.Q.p().f281782d = false;
                o();
                this.Q.p().j();
                return;
            }
            this.Q.p().i();
            this.Q.p().f();
            this.Q.p().f281782d = true;
            m(true);
            return;
        }
        this.Q.back();
    }

    @Override // e04.g
    public void e() {
        AIOFileVideoData V = this.Q.V();
        BaseVideoView baseVideoView = this.R.mVideoView;
        if (baseVideoView != null && baseVideoView.isPlaying()) {
            QLog.i("AIOFileVideoView<FileAssistant>XOXO", 1, "video playing, try PAUSE!");
            D0();
        } else {
            QLog.i("AIOFileVideoView<FileAssistant>XOXO", 1, "video pause, try PLAY!");
            new tm2.c().b(V, this.f282077h, this);
        }
        AIOBrowserPresenter aIOBrowserPresenter = this.Q.f281859e;
        if (aIOBrowserPresenter != null) {
            aIOBrowserPresenter.S();
        }
        w();
    }

    @Override // e04.g
    public void f() {
        AIOFileVideoData V = this.Q.V();
        if (V == null) {
            BrowserLogHelper.getInstance().getGalleryLog().e("AIOFileVideoView<FileAssistant>XOXO", 1, "presenter get data is null");
            return;
        }
        tm2.c cVar = new tm2.c();
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView<FileAssistant>XOXO", 4, "onItemClick id = " + V.f365136id);
        if (cVar.i(V)) {
            this.Q.R(V.msgId, V.subId, 3);
        } else {
            this.Q.R(V.msgId, V.subId, 1);
        }
        K0(this.Q.f281861h.getCurrentPosition(), false);
        v();
        updateUI();
    }

    @Override // com.tencent.mobileqq.richmediabrowser.view.a, c04.c
    public void g(f04.c cVar) {
        super.g(cVar);
        if (cVar instanceof VideoView) {
            VideoView videoView = (VideoView) cVar;
            this.R = videoView;
            videoView.setPlayPanelDecorator(true);
            this.R.setVideoViewClickEvent(this);
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.view.a, e04.e
    public void h(Intent intent) {
        super.h(intent);
        this.f281975a0 = ViewUtils.getScreenWidth() / 2;
        AIOBrowserPresenter aIOBrowserPresenter = this.Q.f281859e;
        if (aIOBrowserPresenter != null && (aIOBrowserPresenter.getParamsBuilder().c() instanceof f)) {
            this.f281983i0 = (f) this.Q.f281859e.getParamsBuilder().c();
        }
    }

    public AIOFileVideoData j0() {
        return this.Q.V();
    }

    @Override // com.tencent.mobileqq.richmediabrowser.view.a
    public void m(boolean z16) {
        boolean z17;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("doEnterImmersion, isClick = ");
            sb5.append(z16);
            sb5.append(" ,  isShowingDanmaku =");
            if (this.Q.n() != null) {
                z17 = this.Q.n().l();
            } else {
                z17 = false;
            }
            sb5.append(z17);
            QLog.d("AIOFileVideoView<FileAssistant>XOXO", 2, sb5.toString());
        }
        super.m(z16);
        if (z16) {
            C(false);
            D(false);
            this.Q.Q(false);
        } else {
            if (this.Q.n() != null && this.Q.n().l()) {
                this.Q.p().f281782d = false;
                this.Q.j();
                this.Q.k();
                J0(false);
                return;
            }
            C(false);
            D(false);
        }
    }

    public long m0() {
        BaseVideoView baseVideoView;
        VideoView videoView = this.R;
        if (videoView != null && (baseVideoView = videoView.mVideoView) != null) {
            return baseVideoView.getCurPlayingPos();
        }
        return 0L;
    }

    @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
    public void onCapFrame(long j3, boolean z16, int i3, int i16, Bitmap bitmap) {
        if (QLog.isColorLevel()) {
            QLog.i("AIOFileVideoView<FileAssistant>XOXO", 2, "onCapFrame, id:" + j3 + ", isSuccess:" + z16 + ", w:" + i3 + ", h:" + i16);
        }
        C0(bitmap);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.f164822az1) {
            AIOFileVideoData V = this.Q.V();
            if (V != null) {
                V.H = true;
                this.Q.R(V.msgId, V.subId, 0);
                this.Q.S(V);
                this.Q.back();
            }
        } else if (id5 == R.id.m2d) {
            g0();
            AIOBrowserPresenter aIOBrowserPresenter = this.Q.f281859e;
            if (aIOBrowserPresenter != null) {
                aIOBrowserPresenter.L();
            }
        } else if (id5 == R.id.gqo) {
            l();
        } else if (id5 == R.id.f59252s8) {
            n();
        } else if (id5 == R.id.cp5) {
            if (QLog.isColorLevel()) {
                QLog.d("AIOFileVideoView<FileAssistant>XOXO", 2, "onClick qq_gallery_danmaku_view ");
            }
            AIOFileVideoData V2 = this.Q.V();
            if (V2 != null && (this.f282077h instanceof Activity)) {
                ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).openMiniAioForDanmaku((Activity) this.f282077h, h.a().f(), h.a().i(), false, V2.shmsgseq, this.R.mVideoView.getCurPlayingPos());
            }
            this.Q.M();
        } else if (id5 == R.id.cq7) {
            com.tencent.mobileqq.richmediabrowser.presenter.c cVar = this.Q;
            if (cVar != null) {
                cVar.back();
                AIOBrowserPresenter aIOBrowserPresenter2 = this.Q.f281859e;
                if (aIOBrowserPresenter2 != null) {
                    aIOBrowserPresenter2.T();
                }
            }
        } else if (id5 == R.id.gqp) {
            i0();
            AIOBrowserPresenter aIOBrowserPresenter3 = this.Q.f281859e;
            if (aIOBrowserPresenter3 != null) {
                aIOBrowserPresenter3.K();
            }
        } else if (id5 == R.id.f59282sa) {
            p0(this.Q.V());
            AIOBrowserPresenter aIOBrowserPresenter4 = this.Q.f281859e;
            if (aIOBrowserPresenter4 != null) {
                aIOBrowserPresenter4.Q();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
    public void onDownloadComplete(long j3) {
        QLog.i("AIOFileVideoView<FileAssistant>XOXO", 1, "@@@@@@@@@@@ videoView Download Success:" + j3);
        AIOFileVideoData j06 = j0();
        if (!j06.I) {
            this.Q.Y(j06);
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.view.a, e04.b
    public void onEnterAnimationEnd() {
        super.onEnterAnimationEnd();
        C(true);
        updateUI();
    }

    @Override // com.tencent.mobileqq.richmediabrowser.view.a, e04.b
    public void onEnterAnimationStart() {
        C(false);
    }

    @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
    public void onFirstFrameRendered(long j3) {
        if (QLog.isColorLevel()) {
            QLog.d("AIOFileVideoView<FileAssistant>XOXO", 2, "onFirstFrameRendered, id:" + j3);
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.richmediabrowser.view.AIOFileVideoView.3
            @Override // java.lang.Runnable
            public void run() {
                GalleryUrlImageView galleryUrlImageView;
                VideoView videoView = AIOFileVideoView.this.R;
                if (videoView != null && (galleryUrlImageView = videoView.coverView) != null) {
                    galleryUrlImageView.setVisibility(8);
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.richmediabrowser.view.a, e04.e
    public void onItemSelected(int i3) {
        RichMediaBaseData richMediaBaseData;
        super.onItemSelected(i3);
        b(i3);
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView<FileAssistant>XOXO", 4, "onItemSelected position = " + i3);
        RichMediaBrowserInfo item = this.Q.f281861h.getItem(i3);
        if (item != null && (richMediaBaseData = item.baseData) != null && richMediaBaseData.getType() == 103) {
            AIOFileVideoData aIOFileVideoData = (AIOFileVideoData) item.baseData;
            tm2.c cVar = new tm2.c();
            if (aIOFileVideoData.L && cVar.i(aIOFileVideoData)) {
                K0(i3, true);
                ((IVideoDepend) QRoute.api(IVideoDepend.class)).stopPttMsgPlay(MobileQQ.sMobileQQ.peekAppRuntime());
                return;
            }
            this.Q.R(aIOFileVideoData.msgId, aIOFileVideoData.subId, 0);
            if (item.isEnterImage) {
                aIOFileVideoData.K = true;
            }
            if (this.f281983i0 != null) {
                if (aIOFileVideoData.L) {
                    this.Q.R(aIOFileVideoData.msgId, aIOFileVideoData.subId, 1);
                    cVar.j(aIOFileVideoData, this.f281983i0);
                }
                if (!FileUtils.fileExistsAndNotEmpty(aIOFileVideoData.f281839f)) {
                    com.tencent.mobileqq.richmediabrowser.presenter.c cVar2 = this.Q;
                    if (cVar2.z(cVar2.f281861h.getCurrentPosition())) {
                        this.Q.I(false);
                    }
                }
                updateUI();
                BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView<FileAssistant>XOXO", 4, "FileVideo_AP onItemSelected needUrl return");
                return;
            }
            if (this.Q.a0(i3) && item.isEnterImage) {
                E0(cVar.g(aIOFileVideoData, aIOFileVideoData.M));
            }
            if (!FileUtils.fileExistsAndNotEmpty(aIOFileVideoData.f281839f)) {
                com.tencent.mobileqq.richmediabrowser.presenter.c cVar3 = this.Q;
                if (cVar3.z(cVar3.f281861h.getCurrentPosition())) {
                    this.Q.I(false);
                }
            }
            this.f281977c0 = null;
            this.f281978d0 = null;
            updateUI();
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
    public void onPlayError(long j3, int i3, int i16, int i17, String str) {
        BrowserLogHelper.getInstance().getGalleryLog().e("AIOFileVideoView<FileAssistant>XOXO", 1, "onPlayError, id = " + j3 + " ,module = " + i3 + " , errorType = " + i16 + ", errCode = " + i17 + " , exInfo = " + str);
        q0(i3, i17, this.f281976b0);
    }

    @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
    public void onPlayProgress(long j3, long j16) {
        this.f281979e0 = j16;
        if (this.R != null) {
            this.R.progressTime.setText(com.tencent.richmediabrowser.utils.a.b(j16));
            this.R.playBar.setProgress((int) ((j16 / r3.mVideoView.getVideoDurationMs()) * 10000.0d));
        }
    }

    @Override // e04.g
    public void onProgressChanged(SeekBar seekBar, int i3, boolean z16) {
        if (z16) {
            AIOBrowserPresenter aIOBrowserPresenter = this.Q.f281859e;
            if (aIOBrowserPresenter != null) {
                aIOBrowserPresenter.V();
            }
            this.Q.p().f();
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.view.a, e04.d
    public void onScrollEnd() {
        com.tencent.mobileqq.richmediabrowser.presenter.c cVar = this.Q;
        if (cVar.z(cVar.f281861h.getCurrentPosition())) {
            AIOFileVideoData V = this.Q.V();
            if (V != null) {
                FileUtils.fileExistsAndNotEmpty(V.f281839f);
            }
            this.Q.I(false);
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.view.a, e04.d
    public void onScrollHalfScreenWidth() {
        if (QLog.isColorLevel()) {
            QLog.d("AIOFileVideoView<FileAssistant>XOXO", 2, "onScrollHalfScreenWidth");
        }
        BaseVideoView baseVideoView = this.R.mVideoView;
        if (baseVideoView != null && baseVideoView.mIsPlayVideo) {
            this.Q.Z(j0());
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
    public void onStateChange(long j3, int i3) {
        VideoView videoView;
        if (QLog.isColorLevel()) {
            QLog.d("AIOFileVideoView<FileAssistant>XOXO", 2, "onStateChange , state = " + n0(i3) + ", msgUniseq=" + j3);
        }
        if (i3 != 4) {
            if (i3 != 5) {
                if (i3 != 6) {
                    if (i3 != 8) {
                        if (i3 == 9 && (videoView = this.R) != null) {
                            videoView.abandonAudioFocus();
                            return;
                        }
                        return;
                    }
                    AIOFileVideoData j06 = j0();
                    if (j06 != null) {
                        j06.I = true;
                    }
                    L0(5);
                    updateUI();
                    return;
                }
                L0(4);
                updateUI();
                return;
            }
            L0(2);
            updateUI();
            return;
        }
        AIOFileVideoData j07 = j0();
        if (j07 == null) {
            QLog.w("AIOFileVideoView<FileAssistant>XOXO", 1, "onStateChange , state = " + n0(i3) + ", msgUniseq=" + j3 + " get videoData is null!");
            return;
        }
        M0(j07.I);
        updateUI();
        this.Q.U(j07.msgId);
        this.Q.T(j07.msgId);
        com.tencent.mobileqq.richmediabrowser.presenter.c cVar = this.Q;
        if (cVar.z(cVar.f281861h.getCurrentPosition())) {
            this.Q.N();
            RichMediaBrowserInfo selectedItem = this.Q.f281861h.getSelectedItem();
            if (selectedItem != null && (selectedItem.baseData instanceof AIOBrowserBaseData) && this.Q.n() != null && this.R.mVideoView != null) {
                this.Q.n().g(com.tencent.mobileqq.richmediabrowser.d.g(((AIOBrowserBaseData) selectedItem.baseData).shmsgseq, this.R.mVideoView.getCurPlayingPos(), this.Q.n(), this.Q.f281862i));
            }
        }
    }

    @Override // e04.g
    public void onStopTrackingTouch(SeekBar seekBar) {
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView<FileAssistant>XOXO", 4, "onStopTrackingTouch");
        if (this.Q.n() != null) {
            com.tencent.mobileqq.richmediabrowser.presenter.c cVar = this.Q;
            if (cVar.z(cVar.f281861h.getCurrentPosition()) && seekBar != null) {
                BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView<FileAssistant>XOXO", 4, "seek danmaku");
                this.Q.n().q(seekBar.getProgress());
                AIOFileVideoData V = this.Q.V();
                if (V != null) {
                    this.Q.n().g(com.tencent.mobileqq.richmediabrowser.d.g(V.shmsgseq, seekBar.getProgress(), this.Q.n(), this.Q.f281862i));
                }
            }
        }
        this.Q.p().j();
    }

    public void r0(AIOFileVideoData aIOFileVideoData, int i3) {
        boolean z16;
        Intent W;
        Intent intent;
        Context context = this.f282077h;
        if ((context instanceof Activity) && ((Activity) context).getIntent() != null) {
            ((Activity) this.f282077h).getIntent().putExtra("big_brother_source_key", "biz_src_jc_file");
        }
        this.f281981g0.clear();
        this.f281982h0.clear();
        RichMediaBrowserUtils.a(2, this.f281981g0);
        if (w0(aIOFileVideoData)) {
            RichMediaBrowserUtils.a(27, this.f281981g0);
        }
        if ((aIOFileVideoData.isLocal || aIOFileVideoData.I) && ((IMiniAppFileMaterialService) QRoute.api(IMiniAppFileMaterialService.class)).isFileSupported(aIOFileVideoData.f281839f)) {
            RichMediaBrowserUtils.a(166, this.f281981g0);
        }
        if (aIOFileVideoData.isLocal || aIOFileVideoData.I) {
            RichMediaBrowserUtils.a(64, this.f281981g0);
        }
        if (this.f281984j0) {
            RichMediaBrowserUtils.a(179, this.f281982h0);
        }
        RichMediaBrowserUtils.a(39, this.f281982h0);
        Context context2 = this.f282077h;
        if ((context2 instanceof Activity) && (intent = ((Activity) context2).getIntent()) != null && intent.getBooleanExtra(PeakConstants.VIDEO_EDIT_ENABLED, false)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && com.tencent.mobileqq.richmediabrowser.utils.h.c()) {
            RichMediaBrowserUtils.a(94, this.f281982h0);
        }
        if (v0(aIOFileVideoData)) {
            RichMediaBrowserUtils.a(6, this.f281982h0);
        }
        if (h.a().r() && !TextUtils.isEmpty(h.a().g())) {
            RichMediaBrowserUtils.a(54, this.f281982h0);
        }
        if (this.R.mVideoView.isPlaying()) {
            if (RichMediaBrowserUtils.d()) {
                this.R.mVideoView.captureCurFrame(this.R.mVideoView.getCurPlayingPos(), 0, 0);
            }
        } else if (this.R.playBar.getProgress() > 0) {
            if (RichMediaBrowserUtils.d()) {
                if (QLog.isColorLevel()) {
                    QLog.i("AIOFileVideoView<FileAssistant>XOXO", 2, "showActionSheet, captureCurFrame, from:" + i3 + ", pos:" + this.f281979e0);
                }
                this.R.mVideoView.captureCurFrame(this.f281979e0, 0, 0);
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.i("AIOFileVideoView<FileAssistant>XOXO", 2, "showActionSheet, video is not playing, recognize thumbnail");
            }
            ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.richmediabrowser.view.AIOFileVideoView.7
                @Override // java.lang.Runnable
                public void run() {
                    AIOFileVideoView aIOFileVideoView = AIOFileVideoView.this;
                    aIOFileVideoView.C0(aIOFileVideoView.f0(aIOFileVideoView.R.mVideoView.getCoverDrawable()));
                }
            });
        }
        if ((aIOFileVideoData.isLocal || aIOFileVideoData.I) && !TextUtils.isEmpty(aIOFileVideoData.f281839f) && QbSdk.isInDefaultBrowser(this.f282077h, aIOFileVideoData.f281839f)) {
            RichMediaBrowserUtils.a(132, this.f281982h0);
        }
        this.f281977c0 = this.f281982h0;
        this.f281978d0 = null;
        F0(aIOFileVideoData);
        Context context3 = this.f282077h;
        if ((context3 instanceof Activity) && (W = this.Q.W(aIOFileVideoData, (Activity) context3)) != null) {
            this.f282075e.setIntentForStartForwardRecentActivity(W);
        }
        this.f282075e.setActionSheetItems(this.f281981g0, this.f281982h0);
        this.f282075e.show();
    }

    public void s0() {
        boolean z16;
        Intent intent;
        RelativeLayout relativeLayout = this.H;
        if (relativeLayout != null) {
            RelativeLayout relativeLayout2 = (RelativeLayout) relativeLayout.findViewById(R.id.ffe);
            ImageButton imageButton = (ImageButton) this.H.findViewById(R.id.m2d);
            this.X = imageButton;
            imageButton.setContentDescription(this.f282077h.getString(R.string.f221606b_));
            this.X.setOnClickListener(this);
            this.X.setVisibility(8);
            VideoView videoView = this.R;
            if (videoView != null) {
                videoView.initContentView(this.H);
            }
            t0(this.H);
            RelativeLayout relativeLayout3 = (RelativeLayout) relativeLayout2.findViewById(R.id.kjb);
            this.S = relativeLayout3;
            SeekBar seekBar = (SeekBar) relativeLayout3.findViewById(R.id.kjd);
            this.V = seekBar;
            seekBar.setMax(10000);
            this.T = (TextView) this.S.findViewById(R.id.kjc);
            this.U = (ImageView) this.S.findViewById(R.id.f164822az1);
            this.S.setVisibility(8);
            this.U.setOnClickListener(this);
            ImageButton imageButton2 = (ImageButton) this.H.findViewById(R.id.gqp);
            this.C = imageButton2;
            imageButton2.setOnClickListener(this);
            boolean z17 = false;
            if ((this.f282077h instanceof Activity) && !com.tencent.mobileqq.richmediabrowser.utils.h.c() && (intent = ((Activity) this.f282077h).getIntent()) != null && intent.getBooleanExtra(PeakConstants.VIDEO_EDIT_ENABLED, false)) {
                z16 = true;
            } else {
                z16 = false;
            }
            F(z16);
            ImageButton imageButton3 = (ImageButton) this.H.findViewById(R.id.f59282sa);
            this.D = imageButton3;
            imageButton3.setOnClickListener(this);
            AIOFileVideoData j06 = j0();
            if (com.tencent.mobileqq.richmediabrowser.utils.h.c() && j06 != null && j06.I) {
                z17 = true;
            }
            H(z17);
            ImageButton imageButton4 = (ImageButton) this.H.findViewById(R.id.cp5);
            this.E = imageButton4;
            if (imageButton4 != null) {
                imageButton4.setOnClickListener(this);
            }
            ImageButton imageButton5 = (ImageButton) this.H.findViewById(R.id.f59252s8);
            this.f282079m = imageButton5;
            if (imageButton5 != null) {
                imageButton5.setOnClickListener(this);
            }
            ImageButton imageButton6 = (ImageButton) this.H.findViewById(R.id.cq7);
            this.W = imageButton6;
            imageButton6.setOnClickListener(this);
            this.Y = this.H.findViewById(R.id.jmw);
            ImageButton imageButton7 = (ImageButton) this.H.findViewById(R.id.gqo);
            this.f282078i = imageButton7;
            imageButton7.setOnClickListener(this);
        }
        VideoView videoView2 = this.R;
        if (videoView2 != null && !videoView2.isInExitAnim) {
            C(true);
        }
        AIOBrowserPresenter aIOBrowserPresenter = this.Q.f281859e;
        if (aIOBrowserPresenter != null) {
            aIOBrowserPresenter.O();
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.view.a
    public void t() {
        this.f281983i0 = null;
        com.tencent.mobileqq.richmediabrowser.presenter.c cVar = this.Q;
        if (cVar != null) {
            cVar.Z(j0());
        }
        super.t();
        VideoView videoView = this.R;
        if (videoView != null) {
            videoView.onDestroy();
        }
        this.P.removeCallbacks(this.f281985k0);
    }

    @Override // com.tencent.mobileqq.richmediabrowser.view.a
    public void u(long j3) {
        RichMediaBaseData richMediaBaseData;
        super.u(j3);
        RichMediaBrowserInfo selectedItem = this.Q.f281861h.getSelectedItem();
        if (selectedItem != null && (richMediaBaseData = selectedItem.baseData) != null && richMediaBaseData.getType() == 103) {
            BaseVideoView baseVideoView = this.R.mVideoView;
            if (baseVideoView != null && baseVideoView.isPlaying()) {
                this.R.mVideoView.pause();
                return;
            }
            return;
        }
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView<FileAssistant>XOXO", 4, "onRevokeMsg exp!");
    }

    @Override // com.tencent.mobileqq.richmediabrowser.view.a, e04.e
    public void updateUI() {
        super.updateUI();
        AIOFileVideoData V = this.Q.V();
        if (V != null && this.R != null) {
            G(z());
            E(y(this.Q.f281861h.getSelectedItem()));
            BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView<FileAssistant>XOXO", 4, "updateUI id = " + V.f365136id);
            int i3 = 8;
            switch (V.status) {
                case 0:
                    BrowserBasePresenter browserBasePresenter = this.Q.f281861h;
                    browserBasePresenter.onLoadFinish(browserBasePresenter.getSelectedIndex(), true);
                    this.R.showPlayPanel(false);
                    I0(false);
                    this.T.setVisibility(8);
                    this.R.bufferPanel.setVisibility(8);
                    this.R.mErrLayout.setVisibility(8);
                    ImageView imageView = this.R.mCenterPlayBtn;
                    if (!V.L) {
                        i3 = 0;
                    }
                    imageView.setVisibility(i3);
                    this.R.playButton.setImageResource(R.drawable.f9n);
                    b0(false, this.R.playButton);
                    this.R.progressTime.setText(com.tencent.richmediabrowser.utils.a.b(0L));
                    this.R.playBar.setProgress(0);
                    H0(V.I);
                    this.R.coverView.setVisibility(0);
                    return;
                case 1:
                    BrowserBasePresenter browserBasePresenter2 = this.Q.f281861h;
                    browserBasePresenter2.onLoadFinish(browserBasePresenter2.getSelectedIndex(), true);
                    this.R.showPlayPanel(false);
                    this.T.setText(this.f282077h.getString(R.string.f221596b9) + "(" + ao.a(V.W) + "/" + ao.a(V.size) + ")");
                    this.T.setVisibility(0);
                    this.V.setProgress(((int) ((((float) V.W) / ((float) V.size)) * 100.0f)) * 100);
                    I0(true);
                    E(false);
                    this.R.bufferPanel.setVisibility(8);
                    this.R.mErrLayout.setVisibility(8);
                    this.R.mCenterPlayBtn.setVisibility(8);
                    H0(false);
                    return;
                case 2:
                    if (this.R.mVideoView.isPlaying()) {
                        this.R.bufferPanel.setVisibility(0);
                    } else {
                        this.R.bufferPanel.setVisibility(8);
                    }
                    this.T.setVisibility(8);
                    BrowserBasePresenter browserBasePresenter3 = this.Q.f281861h;
                    browserBasePresenter3.onLoadFinish(browserBasePresenter3.getSelectedIndex(), true);
                    if (V.I) {
                        this.R.showPlayPanel(true);
                        I0(false);
                    } else {
                        I0(true);
                        this.R.showPlayPanel(false);
                        E(false);
                    }
                    this.R.mCenterPlayBtn.setVisibility(8);
                    this.R.mErrLayout.setVisibility(8);
                    H0(true);
                    return;
                case 3:
                    BrowserBasePresenter browserBasePresenter4 = this.Q.f281861h;
                    browserBasePresenter4.onLoadFinish(browserBasePresenter4.getSelectedIndex(), true);
                    this.R.showPlayPanel(true);
                    I0(false);
                    this.R.bufferPanel.setVisibility(8);
                    this.R.mErrLayout.setVisibility(8);
                    this.R.mCenterPlayBtn.setVisibility(8);
                    this.R.playButton.setImageResource(R.drawable.f9o);
                    b0(true, this.R.playButton);
                    H0(true);
                    this.T.setVisibility(8);
                    BaseVideoView baseVideoView = this.R.mVideoView;
                    if (baseVideoView != null) {
                        this.N = baseVideoView.getVideoDurationMs();
                        BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView<FileAssistant>XOXO", 4, "videoDuration = " + this.N);
                        this.R.totalTime.setText(com.tencent.richmediabrowser.utils.a.b(this.N));
                    }
                    this.P.removeCallbacks(this.f281985k0);
                    return;
                case 4:
                    BrowserBasePresenter browserBasePresenter5 = this.Q.f281861h;
                    browserBasePresenter5.onLoadFinish(browserBasePresenter5.getSelectedIndex(), true);
                    this.R.showPlayPanel(true);
                    I0(false);
                    this.R.bufferPanel.setVisibility(8);
                    this.R.mErrLayout.setVisibility(8);
                    this.R.mCenterPlayBtn.setVisibility(0);
                    this.R.playButton.setImageResource(R.drawable.f9n);
                    b0(false, this.R.playButton);
                    H0(true);
                    this.T.setVisibility(8);
                    return;
                case 5:
                    N0();
                    return;
                case 6:
                    BrowserBasePresenter browserBasePresenter6 = this.Q.f281861h;
                    browserBasePresenter6.onLoadFinish(browserBasePresenter6.getSelectedIndex(), true);
                    this.R.showPlayPanel(false);
                    if (V.I) {
                        I0(false);
                    } else {
                        this.T.setText(this.f282077h.getString(R.string.f221596b9) + "(" + ao.a(V.W) + "/" + ao.a(V.size) + ")");
                        this.T.setVisibility(0);
                        this.V.setProgress(((int) ((((float) V.W) / ((float) V.size)) * 100.0f)) * 100);
                        I0(true);
                    }
                    this.R.bufferPanel.setVisibility(8);
                    this.R.mErrLayout.setVisibility(0);
                    this.R.mCenterPlayBtn.setVisibility(8);
                    this.R.playButton.setImageResource(R.drawable.f9n);
                    b0(false, this.R.playButton);
                    H0(false);
                    return;
                case 7:
                    BrowserBasePresenter browserBasePresenter7 = this.Q.f281861h;
                    browserBasePresenter7.onLoadFinish(browserBasePresenter7.getSelectedIndex(), true);
                    float f16 = (((float) V.W) / ((float) V.size)) * 100.0f;
                    String format = new DecimalFormat("0.00").format(f16);
                    this.T.setText(this.f282077h.getString(R.string.f221886c1) + format + "%");
                    this.T.setVisibility(0);
                    this.V.setProgress(((int) f16) * 100);
                    this.R.bufferPanel.setVisibility(8);
                    this.R.showPlayPanel(false);
                    I0(true);
                    E(false);
                    this.R.mErrLayout.setVisibility(8);
                    this.R.mCenterPlayBtn.setVisibility(8);
                    H0(false);
                    return;
                default:
                    BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView<FileAssistant>XOXO", 4, "updateUI status is error, status = " + V.status);
                    return;
            }
        }
    }

    public void x0(long j3, int i3, int i16, String str, String[] strArr, String str2, MessageRecord messageRecord, int i17, Bundle bundle) {
        this.Q.u(j3, i3, i16, str);
        G0(this.Q.f281861h.getSelectedIndex(), str, strArr, str2, messageRecord, i17, bundle);
    }

    @Override // com.tencent.mobileqq.richmediabrowser.view.a
    public boolean y(RichMediaBrowserInfo richMediaBrowserInfo) {
        return super.y(richMediaBrowserInfo);
    }

    public void y0() {
        K0(this.Q.f281861h.getCurrentPosition(), false);
    }

    @Override // com.tencent.mobileqq.richmediabrowser.view.a
    public boolean z() {
        AIOFileVideoData V;
        if (super.z() && (V = this.Q.V()) != null && !h.a().q() && FileUtils.fileExistsAndNotEmpty(V.f281839f)) {
            return true;
        }
        return false;
    }

    public void z0() {
        K0(this.Q.f281861h.getCurrentPosition(), true);
    }

    @Override // com.tencent.mobileqq.richmediabrowser.view.a, e04.b
    public void onExitAnimationStart() {
    }

    @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
    public void onDownloadProgress(long j3, long j16) {
    }

    @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
    public void onLoopBack(long j3, long j16) {
    }
}
