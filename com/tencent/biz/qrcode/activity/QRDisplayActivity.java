package com.tencent.biz.qrcode.activity;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.zxing.common.BitMatrix;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.autotemplate.extra.PreDetect;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.qrcode.CodeMaskManager;
import com.tencent.biz.qrcode.CustomAccessibilityDelegate;
import com.tencent.biz.qrcode.fragment.QRDisplayMyCardFragment;
import com.tencent.biz.qrcode.util.TroopQRCodeDTReportHelper;
import com.tencent.chirp.PcmPlayer;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.config.business.bb;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.profilecard.base.utils.LongClickCopyAction;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IChirpApi;
import com.tencent.mobileqq.qrscan.api.IQRScanEarlyHandlerApi;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.troop.addsource.TroopSourceHandler;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.cn;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.SimpleModeHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.eu;
import com.tencent.mobileqq.vas.config.business.qvip.QVipQidProcessor;
import com.tencent.mobileqq.vas.qid.QidCardManager;
import com.tencent.mobileqq.vas.qid.QidPagView;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.util.PrettyAccountUtil;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.pb.qid.QidProfile$GetProfileSSOReq;
import com.tencent.pb.qid.QidProfile$GetProfileSSORsp;
import com.tencent.protofile.source.QunJoinUrlSvrPB$ButtonItem;
import com.tencent.protofile.source.QunJoinUrlSvrPB$GetInfoRsp;
import com.tencent.protofile.source.QunSourceSvrPB$SourceItem;
import com.tencent.qidian.controller.QidianHandler;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.bus.api.IBusManager;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.util.InputMethodUtil;
import com.tencent.util.LoadingUtil;
import com.tencent.weiyun.transmission.db.JobDbManager;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import cooperation.qzone.QZoneHelper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mk2.a;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QRDisplayActivity extends IphoneTitleBarActivity implements CodeMaskManager.a, View.OnClickListener, AdapterView.OnItemClickListener, PcmPlayer.a, Handler.Callback, CustomAccessibilityDelegate.a, a.InterfaceC10793a, CompoundButton.OnCheckedChangeListener {

    /* renamed from: t2, reason: collision with root package name */
    public static final String f94578t2 = HardCodeUtil.qqStr(R.string.f172498re0);
    protected Handler A0;
    protected TextView A1;
    protected TextView B1;
    protected ImageView C1;
    DiscussionHandler D0;
    ActionSheet E0;
    private Handler E1;
    WXShareHelper.a F0;
    private PcmPlayer F1;
    String G0;
    long H0;
    QQProgressDialog I0;
    View J0;
    private com.tencent.mobileqq.earlydownload.handler.b J1;
    View K0;
    int L0;
    int M0;
    private ActionSheet M1;
    protected View N0;
    private View N1;
    protected ImageView O0;
    private ImageView O1;
    protected TextView P0;
    private TextView P1;
    protected View Q0;
    private View Q1;
    protected ImageView R0;
    private View R1;
    protected TextView S0;
    private TextView S1;
    protected long T0;
    private TextView T1;
    protected View U0;
    private TroopSourceHandler U1;
    protected ImageView V0;
    protected TextView W0;
    protected LinearLayout X0;
    private zv3.c X1;
    protected View Y0;
    protected ImageView Z0;

    /* renamed from: a0, reason: collision with root package name */
    protected View f94579a0;

    /* renamed from: a1, reason: collision with root package name */
    protected TextView f94580a1;

    /* renamed from: b0, reason: collision with root package name */
    protected View f94582b0;

    /* renamed from: b1, reason: collision with root package name */
    protected View f94583b1;

    /* renamed from: c0, reason: collision with root package name */
    protected View f94585c0;

    /* renamed from: c1, reason: collision with root package name */
    protected ImageView f94586c1;

    /* renamed from: d0, reason: collision with root package name */
    protected ImageView f94588d0;

    /* renamed from: d1, reason: collision with root package name */
    protected View f94589d1;

    /* renamed from: e0, reason: collision with root package name */
    protected BitMatrix f94591e0;

    /* renamed from: e1, reason: collision with root package name */
    protected View f94592e1;

    /* renamed from: f0, reason: collision with root package name */
    protected CodeMaskManager f94594f0;

    /* renamed from: f1, reason: collision with root package name */
    protected ImageView f94595f1;

    /* renamed from: g1, reason: collision with root package name */
    protected ImageView f94598g1;

    /* renamed from: h1, reason: collision with root package name */
    protected TextView f94601h1;

    /* renamed from: i1, reason: collision with root package name */
    protected TextView f94604i1;

    /* renamed from: j0, reason: collision with root package name */
    protected Bitmap f94606j0;

    /* renamed from: j1, reason: collision with root package name */
    protected TextView f94607j1;

    /* renamed from: k0, reason: collision with root package name */
    protected volatile Bitmap f94609k0;

    /* renamed from: k1, reason: collision with root package name */
    protected bb f94610k1;

    /* renamed from: l0, reason: collision with root package name */
    protected String f94612l0;

    /* renamed from: l1, reason: collision with root package name */
    protected String f94613l1;

    /* renamed from: m0, reason: collision with root package name */
    protected String f94615m0;

    /* renamed from: m2, reason: collision with root package name */
    protected LinearLayout f94617m2;

    /* renamed from: n0, reason: collision with root package name */
    protected String f94618n0;

    /* renamed from: n2, reason: collision with root package name */
    protected QidPagView f94620n2;

    /* renamed from: o0, reason: collision with root package name */
    protected String f94621o0;

    /* renamed from: o1, reason: collision with root package name */
    protected String f94622o1;

    /* renamed from: o2, reason: collision with root package name */
    protected RedTouch f94623o2;

    /* renamed from: p0, reason: collision with root package name */
    protected String f94624p0;

    /* renamed from: p1, reason: collision with root package name */
    protected TextView f94625p1;

    /* renamed from: q0, reason: collision with root package name */
    protected int f94627q0;

    /* renamed from: q1, reason: collision with root package name */
    protected Drawable f94628q1;

    /* renamed from: r1, reason: collision with root package name */
    private URLDrawable f94631r1;

    /* renamed from: r2, reason: collision with root package name */
    Bitmap f94632r2;

    /* renamed from: s1, reason: collision with root package name */
    private ac f94634s1;

    /* renamed from: s2, reason: collision with root package name */
    Bitmap f94635s2;

    /* renamed from: t0, reason: collision with root package name */
    protected int f94636t0;

    /* renamed from: t1, reason: collision with root package name */
    protected View f94637t1;

    /* renamed from: u0, reason: collision with root package name */
    protected Bundle f94638u0;

    /* renamed from: u1, reason: collision with root package name */
    protected View f94639u1;

    /* renamed from: v0, reason: collision with root package name */
    protected int f94640v0;

    /* renamed from: v1, reason: collision with root package name */
    protected View f94641v1;

    /* renamed from: w0, reason: collision with root package name */
    protected int f94642w0;

    /* renamed from: w1, reason: collision with root package name */
    protected ImageView f94643w1;

    /* renamed from: x1, reason: collision with root package name */
    protected ImageView f94645x1;

    /* renamed from: y0, reason: collision with root package name */
    protected String f94646y0;

    /* renamed from: y1, reason: collision with root package name */
    protected TextView f94647y1;

    /* renamed from: z1, reason: collision with root package name */
    protected TextView f94649z1;

    /* renamed from: g0, reason: collision with root package name */
    protected boolean f94597g0 = true;

    /* renamed from: h0, reason: collision with root package name */
    protected boolean f94600h0 = false;

    /* renamed from: i0, reason: collision with root package name */
    protected boolean f94603i0 = false;

    /* renamed from: r0, reason: collision with root package name */
    protected long f94630r0 = 0;

    /* renamed from: s0, reason: collision with root package name */
    protected int f94633s0 = 0;

    /* renamed from: x0, reason: collision with root package name */
    protected boolean f94644x0 = true;

    /* renamed from: z0, reason: collision with root package name */
    protected int f94648z0 = 0;
    List<String> B0 = new ArrayList();
    List<String> C0 = new ArrayList();

    /* renamed from: m1, reason: collision with root package name */
    protected boolean f94616m1 = true;

    /* renamed from: n1, reason: collision with root package name */
    protected int f94619n1 = -1;
    protected boolean D1 = false;
    private boolean G1 = false;
    private volatile boolean H1 = false;
    private boolean I1 = false;
    public boolean K1 = true;
    private boolean L1 = SimpleModeHelper.A();
    private QunSourceSvrPB$SourceItem V1 = null;
    private final IBusManager W1 = (IBusManager) QRoute.api(IBusManager.class);
    ab Y1 = new h();
    com.tencent.mobileqq.troop.api.observer.c Z1 = new o();

    /* renamed from: a2, reason: collision with root package name */
    com.tencent.mobileqq.discussion.observer.a f94581a2 = new y();

    /* renamed from: b2, reason: collision with root package name */
    protected Runnable f94584b2 = new Runnable() { // from class: com.tencent.biz.qrcode.activity.QRDisplayActivity.6
        @Override // java.lang.Runnable
        public void run() {
            int i3;
            int i16;
            Bitmap bitmap;
            int i17 = ((int) (((IphoneTitleBarActivity) QRDisplayActivity.this).mDensity * 20.0f)) * 2;
            int width = QRDisplayActivity.this.f94585c0.getWidth() - i17;
            int height = QRDisplayActivity.this.f94585c0.getHeight() - i17;
            QRDisplayActivity qRDisplayActivity = QRDisplayActivity.this;
            int i18 = qRDisplayActivity.f94636t0;
            if (i18 != 1 && i18 != 2) {
                i3 = 540;
                i16 = 740;
            } else {
                i3 = 550;
                i16 = 844;
            }
            if (width >= i3 && height >= i16) {
                qRDisplayActivity.f94640v0 = i3;
                qRDisplayActivity.f94642w0 = i16;
            } else {
                if (width * i3 < height * i3) {
                    qRDisplayActivity.f94640v0 = width;
                    qRDisplayActivity.f94642w0 = (int) ((width / i3) * i16);
                } else {
                    qRDisplayActivity.f94640v0 = (int) ((height / i16) * i3);
                    qRDisplayActivity.f94642w0 = height;
                }
                ViewGroup.LayoutParams layoutParams = qRDisplayActivity.f94588d0.getLayoutParams();
                QRDisplayActivity qRDisplayActivity2 = QRDisplayActivity.this;
                layoutParams.width = qRDisplayActivity2.f94640v0;
                layoutParams.height = qRDisplayActivity2.f94642w0;
                qRDisplayActivity2.f94588d0.setLayoutParams(layoutParams);
                ViewGroup.LayoutParams layoutParams2 = QRDisplayActivity.this.J0.getLayoutParams();
                QRDisplayActivity qRDisplayActivity3 = QRDisplayActivity.this;
                layoutParams2.width = qRDisplayActivity3.f94640v0;
                layoutParams2.height = qRDisplayActivity3.f94642w0;
                qRDisplayActivity3.J0.setLayoutParams(layoutParams2);
            }
            boolean z16 = false;
            if (QRDisplayActivity.this.f94606j0 == null) {
                ThreadManagerV2.post(new Runnable() { // from class: com.tencent.biz.qrcode.activity.QRDisplayActivity.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Bitmap circleFaceBitmap;
                        QRDisplayActivity qRDisplayActivity4 = QRDisplayActivity.this;
                        int i19 = qRDisplayActivity4.f94636t0;
                        if (i19 == 1) {
                            qRDisplayActivity4.f94606j0 = qRDisplayActivity4.app.getFaceBitmap(qRDisplayActivity4.f94618n0, false);
                            QRDisplayActivity qRDisplayActivity5 = QRDisplayActivity.this;
                            Bitmap bitmap2 = qRDisplayActivity5.f94606j0;
                            if (bitmap2 == null) {
                                circleFaceBitmap = BaseImageUtil.getDefaultFaceBitmap(true);
                            } else {
                                circleFaceBitmap = BaseImageUtil.getCircleFaceBitmap(bitmap2, 50, 50);
                            }
                            qRDisplayActivity5.f94606j0 = circleFaceBitmap;
                        } else if (i19 == 2) {
                            qRDisplayActivity4.f94606j0 = qRDisplayActivity4.app.getTroopFaceBitmap(qRDisplayActivity4.f94618n0, (byte) 3, false, false);
                            QRDisplayActivity qRDisplayActivity6 = QRDisplayActivity.this;
                            if (qRDisplayActivity6.f94606j0 == null) {
                                qRDisplayActivity6.f94606j0 = BaseImageUtil.getDefaultTroopFaceBitmap();
                            }
                            QRDisplayActivity qRDisplayActivity7 = QRDisplayActivity.this;
                            qRDisplayActivity7.f94606j0 = BaseImageUtil.getCircleFaceBitmap(qRDisplayActivity7.f94606j0, 50, 50);
                        } else {
                            Drawable V2 = qRDisplayActivity4.D0.V2(qRDisplayActivity4.f94618n0, true);
                            if (V2 instanceof BitmapDrawable) {
                                QRDisplayActivity.this.f94606j0 = ((BitmapDrawable) V2).getBitmap();
                            }
                        }
                        QRDisplayActivity qRDisplayActivity8 = QRDisplayActivity.this;
                        if (qRDisplayActivity8.f94606j0 == null) {
                            qRDisplayActivity8.f94606j0 = BaseImageUtil.getDefaultFaceBitmap();
                        }
                    }
                }, 8, null, false);
            }
            QRDisplayActivity qRDisplayActivity4 = QRDisplayActivity.this;
            if (qRDisplayActivity4.f94636t0 == 2 && (bitmap = qRDisplayActivity4.f94606j0) != null) {
                qRDisplayActivity4.f94606j0 = BaseImageUtil.getCircleFaceBitmap(bitmap, 50, 50);
            }
            QRDisplayActivity qRDisplayActivity5 = QRDisplayActivity.this;
            if (qRDisplayActivity5.f94638u0 == null) {
                qRDisplayActivity5.f94638u0 = new Bundle();
                QRDisplayActivity.this.f94638u0.putInt("bkgRes", 0);
                QRDisplayActivity.this.f94638u0.putInt("nameClr", -16777216);
                QRDisplayActivity.this.f94638u0.putInt("tipsClr", RichStatus.ACTION_COLOR_NORMAL);
                QRDisplayActivity.this.f94638u0.putInt("B", -16777216);
                QRDisplayActivity.this.f94638u0.putInt("W", 16777215);
                QRDisplayActivity.this.f94638u0.putParcelable("qrloc", new Rect(45, 76, 495, 526));
                QRDisplayActivity.this.f94638u0.putInt("head", 1);
            }
            QRDisplayActivity qRDisplayActivity6 = QRDisplayActivity.this;
            int i19 = qRDisplayActivity6.f94636t0;
            if (i19 != 5) {
                if (i19 == 11) {
                    String stringExtra = qRDisplayActivity6.getIntent().getStringExtra("url");
                    QRDisplayActivity qRDisplayActivity7 = QRDisplayActivity.this;
                    qRDisplayActivity7.r4(qRDisplayActivity7.f94618n0, qRDisplayActivity7.f94636t0, stringExtra);
                }
                QRDisplayActivity qRDisplayActivity8 = QRDisplayActivity.this;
                if (qRDisplayActivity8.f94591e0 == null) {
                    qRDisplayActivity8.f94591e0 = qRDisplayActivity8.H3(qRDisplayActivity8.f94618n0, qRDisplayActivity8.f94636t0, -1);
                }
                QRDisplayActivity qRDisplayActivity9 = QRDisplayActivity.this;
                if (qRDisplayActivity9.f94636t0 == 11) {
                    qRDisplayActivity9.Q4();
                }
                QRDisplayActivity.this.B3();
                QRDisplayActivity.this.K3();
            } else {
                SharedPreferences sharedPreferences = qRDisplayActivity6.getSharedPreferences("qrcode", 0);
                QRDisplayActivity.this.H0 = sharedPreferences.getLong("discussionvalidtime" + QRDisplayActivity.this.f94618n0, 0L);
                QRDisplayActivity.this.f94621o0 = sharedPreferences.getString("discussion" + QRDisplayActivity.this.f94618n0, null);
                QRDisplayActivity.this.f94624p0 = sharedPreferences.getString("discussionfullSig" + QRDisplayActivity.this.f94618n0, null);
                if (QRDisplayActivity.this.H0 - (System.currentTimeMillis() / 1000) > 0) {
                    z16 = true;
                }
                QRDisplayActivity.this.findViewById(R.id.f166657h15).setOnClickListener(QRDisplayActivity.this);
                QRDisplayActivity qRDisplayActivity10 = QRDisplayActivity.this;
                if (qRDisplayActivity10.f94621o0 != null && qRDisplayActivity10.f94624p0 != null && z16) {
                    ((TextView) qRDisplayActivity10.findViewById(R.id.gfl)).setText(QRDisplayActivity.this.f94621o0);
                    QRDisplayActivity qRDisplayActivity11 = QRDisplayActivity.this;
                    qRDisplayActivity11.f94591e0 = com.tencent.biz.qrcode.util.h.o(qRDisplayActivity11.f94621o0, -1);
                    QRDisplayActivity.this.Q4();
                } else {
                    if (QLog.isDevelopLevel()) {
                        QLog.d("QRDisplayActivity", 4, "qrcode url not valid");
                    }
                    QRDisplayActivity qRDisplayActivity12 = QRDisplayActivity.this;
                    qRDisplayActivity12.D0.Y2(Long.parseLong(qRDisplayActivity12.f94618n0), true);
                    return;
                }
            }
            QRDisplayActivity qRDisplayActivity13 = QRDisplayActivity.this;
            qRDisplayActivity13.f94582b0.post(qRDisplayActivity13.f94587c2);
        }
    };

    /* renamed from: c2, reason: collision with root package name */
    protected Runnable f94587c2 = new Runnable() { // from class: com.tencent.biz.qrcode.activity.QRDisplayActivity.7
        @Override // java.lang.Runnable
        public void run() {
            int height = QRDisplayActivity.this.f94585c0.getHeight();
            int height2 = QRDisplayActivity.this.f94582b0.getHeight();
            if (height2 < height) {
                View findViewById = QRDisplayActivity.this.findViewById(R.id.f166655h12);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
                int i3 = QRDisplayActivity.this.f94636t0;
                if (i3 == 2) {
                    layoutParams.topMargin = 0;
                    layoutParams.bottomMargin = 0;
                } else if (i3 == 5) {
                    layoutParams.topMargin += (height - height2) / 2;
                } else {
                    layoutParams.topMargin = (int) ((FontSettingManager.customMetrics.density * 20.0f) + 0.5f);
                }
                if ("1103".equals(ThemeUtil.curThemeId)) {
                    findViewById.setBackgroundDrawable(null);
                }
                findViewById.setLayoutParams(layoutParams);
            }
        }
    };

    /* renamed from: d2, reason: collision with root package name */
    protected Runnable f94590d2 = new Runnable() { // from class: com.tencent.biz.qrcode.activity.QRDisplayActivity.8
        @Override // java.lang.Runnable
        public void run() {
            if (QRDisplayActivity.this.f94582b0.getHeight() < QRDisplayActivity.this.f94585c0.getHeight()) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) QRDisplayActivity.this.f94582b0.getLayoutParams();
                layoutParams.gravity = 17;
                QRDisplayActivity.this.f94582b0.setLayoutParams(layoutParams);
            }
        }
    };

    /* renamed from: e2, reason: collision with root package name */
    com.tencent.qidian.controller.a f94593e2 = new z();

    /* renamed from: f2, reason: collision with root package name */
    protected Runnable f94596f2 = new Runnable() { // from class: com.tencent.biz.qrcode.activity.QRDisplayActivity.10
        @Override // java.lang.Runnable
        public void run() {
            QRDisplayActivity qRDisplayActivity = QRDisplayActivity.this;
            qRDisplayActivity.f94600h0 = true;
            qRDisplayActivity.J3();
        }
    };

    /* renamed from: g2, reason: collision with root package name */
    protected ActionSheet f94599g2 = null;

    /* renamed from: h2, reason: collision with root package name */
    protected boolean f94602h2 = false;

    /* renamed from: i2, reason: collision with root package name */
    private ShareActionSheet f94605i2 = null;

    /* renamed from: j2, reason: collision with root package name */
    protected int f94608j2 = 0;

    /* renamed from: k2, reason: collision with root package name */
    private CountDownTimer f94611k2 = new m(1000, 200);

    /* renamed from: l2, reason: collision with root package name */
    int f94614l2 = -1;

    /* renamed from: p2, reason: collision with root package name */
    int f94626p2;

    /* renamed from: q2, reason: collision with root package name */
    int f94629q2 = this.f94626p2;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements DialogInterface.OnDismissListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            QRDisplayActivity.this.f94602h2 = false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class aa implements Comparator<String> {
        aa() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            if (str != null && str2 != null) {
                return ChnToSpell.d(str, 1).compareTo(ChnToSpell.d(str2, 1));
            }
            if (str != null) {
                return 1;
            }
            if (str2 != null) {
                return -1;
            }
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class ac implements View.OnTouchListener {
        ac() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            QRDisplayActivity qRDisplayActivity;
            ImageView imageView;
            QRDisplayActivity qRDisplayActivity2;
            ImageView imageView2;
            QRDisplayActivity qRDisplayActivity3;
            ImageView imageView3;
            QRDisplayActivity qRDisplayActivity4;
            ImageView imageView4;
            QRDisplayActivity qRDisplayActivity5;
            ImageView imageView5;
            QRDisplayActivity qRDisplayActivity6;
            ImageView imageView6;
            QRDisplayActivity qRDisplayActivity7;
            ImageView imageView7;
            QRDisplayActivity qRDisplayActivity8;
            ImageView imageView8;
            QRDisplayActivity qRDisplayActivity9;
            ImageView imageView9;
            QRDisplayActivity qRDisplayActivity10;
            ImageView imageView10;
            int i3 = QRDisplayActivity.this.f94636t0;
            if (i3 == 1) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action == 1 || action == 3) {
                        if (R.id.f6510381 == view.getId() && (imageView10 = (qRDisplayActivity10 = QRDisplayActivity.this).O0) != null && qRDisplayActivity10.P0 != null) {
                            imageView10.setAlpha(1.0f);
                            QRDisplayActivity.this.P0.setAlpha(1.0f);
                            return false;
                        }
                        if (R.id.h1p == view.getId() && (imageView9 = (qRDisplayActivity9 = QRDisplayActivity.this).R0) != null && qRDisplayActivity9.S0 != null) {
                            imageView9.setAlpha(1.0f);
                            QRDisplayActivity.this.S0.setAlpha(1.0f);
                            return false;
                        }
                        if (R.id.f653638q == view.getId() && (imageView8 = (qRDisplayActivity8 = QRDisplayActivity.this).V0) != null && qRDisplayActivity8.W0 != null) {
                            imageView8.setAlpha(1.0f);
                            QRDisplayActivity.this.W0.setAlpha(1.0f);
                            return false;
                        }
                        return false;
                    }
                    return false;
                }
                if (R.id.f6510381 == view.getId() && (imageView7 = (qRDisplayActivity7 = QRDisplayActivity.this).O0) != null && qRDisplayActivity7.P0 != null) {
                    imageView7.setAlpha(0.5f);
                    QRDisplayActivity.this.P0.setAlpha(0.5f);
                    return false;
                }
                if (R.id.h1p == view.getId() && (imageView6 = (qRDisplayActivity6 = QRDisplayActivity.this).R0) != null && qRDisplayActivity6.S0 != null) {
                    imageView6.setAlpha(0.5f);
                    QRDisplayActivity.this.S0.setAlpha(0.5f);
                    return false;
                }
                if (R.id.f653638q == view.getId() && (imageView5 = (qRDisplayActivity5 = QRDisplayActivity.this).V0) != null && qRDisplayActivity5.W0 != null) {
                    imageView5.setAlpha(0.5f);
                    QRDisplayActivity.this.W0.setAlpha(0.5f);
                    return false;
                }
                return false;
            }
            if (i3 == 2) {
                int action2 = motionEvent.getAction();
                if (action2 != 0) {
                    if (action2 == 1 || action2 == 3) {
                        if (R.id.f654138v == view.getId() && (imageView4 = (qRDisplayActivity4 = QRDisplayActivity.this).Z0) != null && qRDisplayActivity4.f94580a1 != null) {
                            imageView4.setAlpha(1.0f);
                            QRDisplayActivity.this.f94580a1.setAlpha(1.0f);
                            return false;
                        }
                        if (R.id.f6513384 == view.getId() && (imageView3 = (qRDisplayActivity3 = QRDisplayActivity.this).O0) != null && qRDisplayActivity3.P0 != null) {
                            imageView3.setAlpha(1.0f);
                            QRDisplayActivity.this.P0.setAlpha(1.0f);
                            return false;
                        }
                        if (R.id.f6517388 == view.getId() && QRDisplayActivity.this.O1 != null) {
                            QRDisplayActivity qRDisplayActivity11 = QRDisplayActivity.this;
                            if (qRDisplayActivity11.W0 != null) {
                                qRDisplayActivity11.O1.setAlpha(1.0f);
                                QRDisplayActivity.this.P1.setAlpha(1.0f);
                                return false;
                            }
                            return false;
                        }
                        return false;
                    }
                    return false;
                }
                if (R.id.f654138v == view.getId() && (imageView2 = (qRDisplayActivity2 = QRDisplayActivity.this).Z0) != null && qRDisplayActivity2.f94580a1 != null) {
                    imageView2.setAlpha(0.5f);
                    QRDisplayActivity.this.f94580a1.setAlpha(0.5f);
                    return false;
                }
                if (R.id.f6513384 == view.getId() && (imageView = (qRDisplayActivity = QRDisplayActivity.this).O0) != null && qRDisplayActivity.P0 != null) {
                    imageView.setAlpha(0.5f);
                    QRDisplayActivity.this.P0.setAlpha(0.5f);
                    return false;
                }
                if (R.id.f6517388 == view.getId() && QRDisplayActivity.this.O1 != null) {
                    QRDisplayActivity qRDisplayActivity12 = QRDisplayActivity.this;
                    if (qRDisplayActivity12.W0 != null) {
                        qRDisplayActivity12.O1.setAlpha(0.5f);
                        QRDisplayActivity.this.P1.setAlpha(0.5f);
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class ad implements com.tencent.mobileqq.qrscan.p {

        /* renamed from: a, reason: collision with root package name */
        public WeakReference<QRDisplayActivity> f94679a;

        /* renamed from: b, reason: collision with root package name */
        public String f94680b;

        /* renamed from: c, reason: collision with root package name */
        public int f94681c;

        ad() {
        }

        private QunSourceSvrPB$SourceItem b() {
            QunSourceSvrPB$SourceItem qunSourceSvrPB$SourceItem;
            WeakReference<QRDisplayActivity> weakReference = this.f94679a;
            if (weakReference == null || weakReference.get() == null || (qunSourceSvrPB$SourceItem = this.f94679a.get().V1) == null || qunSourceSvrPB$SourceItem.url.get() == null || qunSourceSvrPB$SourceItem.url.get().isEmpty()) {
                return null;
            }
            return qunSourceSvrPB$SourceItem;
        }

        @Override // com.tencent.mobileqq.qrscan.p
        public void a(boolean z16, String str) {
            QRDisplayActivity qRDisplayActivity;
            WeakReference<QRDisplayActivity> weakReference = this.f94679a;
            if (weakReference == null || (qRDisplayActivity = weakReference.get()) == null) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QRDisplayActivity", 2, String.format("onReceive qrcode url:%s suc:%b", str, Boolean.valueOf(z16)));
            }
            if (!qRDisplayActivity.f94600h0 && !qRDisplayActivity.isFinishing()) {
                if (!z16) {
                    qRDisplayActivity.J3();
                    return;
                }
                QunSourceSvrPB$SourceItem b16 = b();
                if (b16 != null) {
                    str = b16.url.get();
                }
                qRDisplayActivity.r4(this.f94680b, this.f94681c, str);
                BitMatrix o16 = com.tencent.biz.qrcode.util.h.o(str, -1);
                if (o16 != null) {
                    qRDisplayActivity.f94591e0 = o16;
                    qRDisplayActivity.Q4();
                } else {
                    qRDisplayActivity.J3();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b implements ActionSheet.OnButtonClickListener {
        b() {
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            QRDisplayActivity qRDisplayActivity = QRDisplayActivity.this;
            if (qRDisplayActivity.f94602h2) {
                return;
            }
            qRDisplayActivity.f94602h2 = true;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2 && !qRDisplayActivity.f94597g0) {
                        qRDisplayActivity.l4();
                        QRDisplayActivity qRDisplayActivity2 = QRDisplayActivity.this;
                        if ((qRDisplayActivity2.M0 & 1) != 0) {
                            ReportController.o(qRDisplayActivity2.app, "P_CliOper", "flag1", "", "0X8004171", "0X8004171", 0, 0, "", "", "", "");
                        }
                        QRDisplayActivity qRDisplayActivity3 = QRDisplayActivity.this;
                        if (qRDisplayActivity3.f94636t0 == 2) {
                            ReportController.o(qRDisplayActivity3.app, "P_CliOper", "Grp_set", "", "Grp_data", "qr_save", 0, 0, qRDisplayActivity3.f94618n0, "", "", String.valueOf(qRDisplayActivity3.f94627q0));
                        }
                    }
                } else if (!qRDisplayActivity.f94597g0) {
                    qRDisplayActivity.Q4();
                    QRDisplayActivity qRDisplayActivity4 = QRDisplayActivity.this;
                    if ((qRDisplayActivity4.M0 & 1) != 0) {
                        ReportController.o(qRDisplayActivity4.app, "P_CliOper", "flag1", "", "0X8004170", "0X8004170", 0, 0, "", "", "", "");
                    }
                }
            } else if (!qRDisplayActivity.f94597g0) {
                qRDisplayActivity.B4();
                QRDisplayActivity qRDisplayActivity5 = QRDisplayActivity.this;
                if ((qRDisplayActivity5.M0 & 1) != 0) {
                    ReportController.o(qRDisplayActivity5.app, "P_CliOper", "flag1", "", "0X800416E", "0X800416E", 0, 0, "", "", "", "");
                }
            }
            QRDisplayActivity.this.f94599g2.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class c extends QQPermission.BasePermissionsListener {
        c() {
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            QRDisplayActivity.this.m4();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class e implements URLDrawable.URLDrawableListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Bitmap[] f94685d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Bundle f94686e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ArrayList f94687f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Bitmap f94688h;

        e(Bitmap[] bitmapArr, Bundle bundle, ArrayList arrayList, Bitmap bitmap) {
            this.f94685d = bitmapArr;
            this.f94686e = bundle;
            this.f94687f = arrayList;
            this.f94688h = bitmap;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
            this.f94685d[0] = BitmapFactory.decodeResource(QRDisplayActivity.this.getResources(), QRDisplayActivity.this.C3());
            QRDisplayActivity.this.y3(this.f94686e, this.f94687f, this.f94688h, this.f94685d);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d("QRDisplayActivity", 2, "OnMaskReadyFromMyQrCode.onLoadFialed: urlDrawable = " + uRLDrawable + " throwable = " + th5.toString());
            }
            this.f94685d[0] = BitmapFactory.decodeResource(QRDisplayActivity.this.getResources(), QRDisplayActivity.this.C3());
            QRDisplayActivity.this.y3(this.f94686e, this.f94687f, this.f94688h, this.f94685d);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
            if (QLog.isColorLevel()) {
                QLog.d("QRDisplayActivity", 2, "OnMaskReadyFromMyQrCode: onLoadProgressed i: " + i3);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            if (QLog.isColorLevel()) {
                QLog.d("QRDisplayActivity", 2, "OnMaskReadyFromMyQrCode.onLoadSuccessed: urlDrawable = " + uRLDrawable + " bkgURL = " + QRDisplayActivity.this.f94622o1);
            }
            this.f94685d[0] = BaseImageUtil.drawableToBitmap(uRLDrawable.getCurrDrawable().mutate());
            QRDisplayActivity.this.y3(this.f94686e, this.f94687f, this.f94688h, this.f94685d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class f implements DialogInterface.OnClickListener {
        f() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QRDisplayActivity.this.finish();
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class g implements WXShareHelper.a {
        g() {
        }

        @Override // com.tencent.mobileqq.wxapi.WXShareHelper.a
        public void onWXShareResp(BaseResp baseResp) {
            int i3;
            String str = QRDisplayActivity.this.G0;
            if (str != null && str.equals(baseResp.transaction) && (i3 = baseResp.errCode) != -2) {
                if (i3 != 0) {
                    com.tencent.biz.qrcode.util.h.T(1, R.string.hit);
                } else {
                    com.tencent.biz.qrcode.util.h.T(2, R.string.hj9);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class h extends ab {
        h() {
            super();
        }

        @Override // com.tencent.biz.qrcode.activity.QRDisplayActivity.ab
        protected void a(boolean z16, List<String> list, List<String> list2) {
            int size;
            if (QLog.isDevelopLevel()) {
                QLog.d("QRDisplayActivity", 4, "onGetNicknameList: " + z16);
            }
            if (z16 && list != null && list2 != null && (size = list2.size()) > 0 && list.size() == size) {
                QRDisplayActivity qRDisplayActivity = QRDisplayActivity.this;
                if (qRDisplayActivity.C0 == null) {
                    qRDisplayActivity.C0 = new ArrayList();
                }
                QRDisplayActivity.this.C0.addAll(list);
                for (int i3 = 0; i3 < size; i3++) {
                    if (QRDisplayActivity.this.G3(list2.get(i3)) == null) {
                        QRDisplayActivity.this.p4(list2.get(i3), list.get(i3));
                    }
                }
                QRDisplayActivity qRDisplayActivity2 = QRDisplayActivity.this;
                Collections.sort(qRDisplayActivity2.C0, new aa());
            }
            QRDisplayActivity qRDisplayActivity3 = QRDisplayActivity.this;
            qRDisplayActivity3.f94612l0 = qRDisplayActivity3.D3(qRDisplayActivity3.C0);
            QRDisplayActivity qRDisplayActivity4 = QRDisplayActivity.this;
            if (qRDisplayActivity4.f94612l0 != null) {
                qRDisplayActivity4.f94588d0.setContentDescription(QRDisplayActivity.this.f94612l0 + "," + QRDisplayActivity.this.f94615m0);
                QRDisplayActivity qRDisplayActivity5 = QRDisplayActivity.this;
                qRDisplayActivity5.f94585c0.post(qRDisplayActivity5.f94584b2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class i implements ShareActionSheet.OnItemClickListener {
        i() {
        }

        @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
        public void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
            QRDisplayActivity.this.f94605i2.dismiss();
            if (QLog.isColorLevel()) {
                QLog.i("QRDisplayActivity", 2, "onItemClick.chooseChannel: " + actionSheetItem.action);
            }
            QRDisplayActivity qRDisplayActivity = QRDisplayActivity.this;
            qRDisplayActivity.f94608j2 = actionSheetItem.action;
            qRDisplayActivity.U4();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class j implements DialogInterface.OnDismissListener {
        j() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            QRDisplayActivity.this.f94602h2 = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class k implements DialogInterface.OnCancelListener {
        k() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            QRDisplayActivity qRDisplayActivity = QRDisplayActivity.this;
            if (qRDisplayActivity.f94602h2) {
                return;
            }
            qRDisplayActivity.f94608j2 = 0;
            qRDisplayActivity.f94602h2 = true;
            qRDisplayActivity.f94605i2.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class l implements WXShareHelper.a {
        l() {
        }

        @Override // com.tencent.mobileqq.wxapi.WXShareHelper.a
        public void onWXShareResp(BaseResp baseResp) {
            String str;
            String str2;
            String str3 = QRDisplayActivity.this.G0;
            if (str3 != null && str3.equals(baseResp.transaction)) {
                QRDisplayActivity qRDisplayActivity = QRDisplayActivity.this;
                if (qRDisplayActivity.f94636t0 == 2) {
                    if (qRDisplayActivity.f94608j2 == 9) {
                        str = "qr_wechat";
                    } else {
                        str = "qr_circle";
                    }
                    String str4 = str;
                    String[] strArr = new String[3];
                    strArr[0] = qRDisplayActivity.f94618n0;
                    strArr[1] = String.valueOf(qRDisplayActivity.f94627q0);
                    if (baseResp.errCode == 0) {
                        str2 = "0";
                    } else {
                        str2 = "1";
                    }
                    strArr[2] = str2;
                    eu.g("Grp_share", "grpData_admin", str4, 0, 0, strArr);
                }
                int i3 = baseResp.errCode;
                if (i3 != -2) {
                    if (i3 != 0) {
                        com.tencent.biz.qrcode.util.h.T(1, R.string.hit);
                        QRDisplayActivity.this.e4(false);
                        return;
                    } else {
                        com.tencent.biz.qrcode.util.h.T(2, R.string.hj9);
                        QRDisplayActivity.this.e4(true);
                        return;
                    }
                }
                QRDisplayActivity.this.e4(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class n implements ActionSheet.OnButtonClickListener {
        n() {
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            int id5 = view.getId();
            if (id5 != 7) {
                if (id5 != 8) {
                    if (id5 == 10) {
                        QidCardManager.QidCardReport.reportQidQrCard("0X800B974");
                        QRDisplayActivity qRDisplayActivity = QRDisplayActivity.this;
                        QidCardManager.jumpQidEditPage(qRDisplayActivity.app, qRDisplayActivity, 1);
                    }
                } else {
                    QRDisplayActivity.this.M3(8);
                    ReportController.o(QRDisplayActivity.this.app, "CliOper", "", "", "0X800AEB7", "0X800AEB7", 0, 0, "", "", "", "");
                }
            } else {
                ReportController.o(QRDisplayActivity.this.app, "CliOper", "", "", "0X800AEB6", "0X800AEB6", 0, 0, "", "", "", "");
                QRDisplayActivity.this.M3(7);
            }
            QRDisplayActivity.this.M1.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class o extends com.tencent.mobileqq.troop.api.observer.c {
        o() {
        }

        @Override // com.tencent.mobileqq.troop.api.observer.c
        protected void d(boolean z16, String str) {
            TroopInfo k3;
            if (TextUtils.equals(QRDisplayActivity.this.f94618n0, str) && z16) {
                if (QLog.isColorLevel()) {
                    QLog.d("QRDisplayActivity", 2, "onUpdateTroopSearchApproachPageTroopInfoUpdated ");
                }
                TroopManager troopManager = (TroopManager) QRDisplayActivity.this.app.getManager(QQManagerFactory.TROOP_MANAGER);
                if (troopManager != null && (k3 = troopManager.k(QRDisplayActivity.this.f94618n0)) != null && !k3.isNewTroop) {
                    ((TextView) QRDisplayActivity.this.findViewById(R.id.vu8)).setVisibility(8);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class p implements ShareActionSheet.OnItemClickListener {
        p() {
        }

        @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
        public void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
            shareActionSheet.dismiss();
            QLog.d("QRDisplayActivity", 2, " showMyQrCodeActionSheet() click item = " + actionSheetItem.action);
            int i3 = actionSheetItem.action;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 9) {
                            if (i3 != 10) {
                                if (i3 != 26) {
                                    if (i3 != 39) {
                                        if (i3 == 72) {
                                            QRDisplayActivity.this.C4(actionSheetItem.uinType, actionSheetItem.uin);
                                            return;
                                        } else if (i3 != 73) {
                                            return;
                                        }
                                    } else {
                                        QRDisplayActivity.this.l4();
                                        return;
                                    }
                                } else if (!com.tencent.mobileqq.filemanager.fileassistant.util.h.o()) {
                                    QRDisplayActivity.this.C4(6000, AppConstants.DATALINE_PC_UIN);
                                    return;
                                } else {
                                    QRDisplayActivity qRDisplayActivity = QRDisplayActivity.this;
                                    qRDisplayActivity.C4(0, com.tencent.mobileqq.filemanager.fileassistant.util.h.g(qRDisplayActivity.app));
                                    return;
                                }
                            } else {
                                QRDisplayActivity qRDisplayActivity2 = QRDisplayActivity.this;
                                qRDisplayActivity2.f94608j2 = 10;
                                qRDisplayActivity2.U4();
                                return;
                            }
                        } else {
                            QRDisplayActivity qRDisplayActivity3 = QRDisplayActivity.this;
                            qRDisplayActivity3.f94608j2 = 9;
                            qRDisplayActivity3.U4();
                            return;
                        }
                    } else {
                        QRDisplayActivity qRDisplayActivity4 = QRDisplayActivity.this;
                        qRDisplayActivity4.f94608j2 = 3;
                        qRDisplayActivity4.U4();
                        return;
                    }
                }
                QRDisplayActivity qRDisplayActivity5 = QRDisplayActivity.this;
                qRDisplayActivity5.f94608j2 = 2;
                qRDisplayActivity5.U4();
                return;
            }
            QRDisplayActivity qRDisplayActivity6 = QRDisplayActivity.this;
            qRDisplayActivity6.f94608j2 = 1;
            qRDisplayActivity6.s3();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class q implements ShareActionSheet.OnItemClickListener {
        q() {
        }

        @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
        public void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
            shareActionSheet.dismiss();
            QLog.d("QRDisplayActivity", 2, " showMyQrCodeActionSheet() click item = " + actionSheetItem.action);
            int i3 = actionSheetItem.action;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 9) {
                            if (i3 != 10) {
                                if (i3 != 26) {
                                    if (i3 != 39) {
                                        if (i3 == 72) {
                                            QRDisplayActivity.this.C4(actionSheetItem.uinType, actionSheetItem.uin);
                                            return;
                                        } else if (i3 != 73) {
                                            return;
                                        }
                                    } else {
                                        QRDisplayActivity.this.l4();
                                        return;
                                    }
                                } else if (!com.tencent.mobileqq.filemanager.fileassistant.util.h.o()) {
                                    QRDisplayActivity.this.C4(6000, AppConstants.DATALINE_PC_UIN);
                                    return;
                                } else {
                                    QRDisplayActivity qRDisplayActivity = QRDisplayActivity.this;
                                    qRDisplayActivity.C4(0, com.tencent.mobileqq.filemanager.fileassistant.util.h.g(qRDisplayActivity.app));
                                    return;
                                }
                            } else {
                                QRDisplayActivity qRDisplayActivity2 = QRDisplayActivity.this;
                                qRDisplayActivity2.f94608j2 = 10;
                                qRDisplayActivity2.U4();
                                return;
                            }
                        } else {
                            QRDisplayActivity qRDisplayActivity3 = QRDisplayActivity.this;
                            qRDisplayActivity3.f94608j2 = 9;
                            qRDisplayActivity3.U4();
                            return;
                        }
                    } else {
                        QRDisplayActivity qRDisplayActivity4 = QRDisplayActivity.this;
                        qRDisplayActivity4.f94608j2 = 3;
                        qRDisplayActivity4.U4();
                        return;
                    }
                }
                QRDisplayActivity qRDisplayActivity5 = QRDisplayActivity.this;
                qRDisplayActivity5.f94608j2 = 2;
                qRDisplayActivity5.U4();
                return;
            }
            QRDisplayActivity qRDisplayActivity6 = QRDisplayActivity.this;
            qRDisplayActivity6.f94608j2 = 1;
            qRDisplayActivity6.s3();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class t implements DialogInterface.OnClickListener {
        t() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QRDisplayActivity qRDisplayActivity = QRDisplayActivity.this;
            QidCardManager.jumpQidEditPage(qRDisplayActivity.app, qRDisplayActivity, 1);
            QidCardManager.QidCardReport.reportQidQrCard("0X800B971");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class v implements zv3.c {
        v() {
        }

        @Override // zv3.c
        public void B5(@NonNull zv3.a aVar) {
            if ((aVar instanceof com.tencent.mobileqq.troop.addsource.c) && QRDisplayActivity.this.V1 != null) {
                QRDisplayActivity.this.K3();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class x extends AccessibilityDelegateCompat {
        x() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setClassName("");
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class y extends com.tencent.mobileqq.discussion.observer.a {
        y() {
        }

        @Override // com.tencent.mobileqq.discussion.observer.a
        protected void n(boolean z16, int i3, long j3, String str, String str2, long j16) {
            if (QLog.isColorLevel()) {
                QLog.d("QRDisplayActivity", 2, "onGetFlyTicket: " + z16);
            }
            if (!z16) {
                QRDisplayActivity.this.E3(i3);
                return;
            }
            QRDisplayActivity qRDisplayActivity = QRDisplayActivity.this;
            Drawable V2 = qRDisplayActivity.D0.V2(qRDisplayActivity.f94618n0, true);
            if (V2 != null && (V2 instanceof BitmapDrawable)) {
                QRDisplayActivity.this.f94606j0 = ((BitmapDrawable) V2).getBitmap();
            }
            SharedPreferences.Editor edit = QRDisplayActivity.this.getSharedPreferences("qrcode", 0).edit();
            edit.putLong("discussionvalidtime" + QRDisplayActivity.this.f94618n0, j3);
            edit.putString("discussion" + QRDisplayActivity.this.f94618n0, str2);
            edit.putString("discussionfullSig" + QRDisplayActivity.this.f94618n0, str);
            edit.commit();
            QRDisplayActivity.this.H0 = j3;
            BitMatrix o16 = com.tencent.biz.qrcode.util.h.o(str2, -1);
            if (o16 != null) {
                ((TextView) QRDisplayActivity.this.findViewById(R.id.gfl)).setText(str2);
                QRDisplayActivity qRDisplayActivity2 = QRDisplayActivity.this;
                qRDisplayActivity2.f94582b0.post(qRDisplayActivity2.f94587c2);
                QRDisplayActivity qRDisplayActivity3 = QRDisplayActivity.this;
                qRDisplayActivity3.f94621o0 = str2;
                qRDisplayActivity3.f94624p0 = str;
                qRDisplayActivity3.f94591e0 = o16;
                qRDisplayActivity3.Q4();
                return;
            }
            QRDisplayActivity.this.J3();
        }

        @Override // com.tencent.mobileqq.discussion.observer.a
        protected void u(boolean z16, boolean z17, String str) {
            if (z16) {
                Drawable V2 = ((DiscussionHandler) QRDisplayActivity.this.app.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).V2(str, true);
                if (V2 instanceof BitmapDrawable) {
                    QRDisplayActivity.this.f94606j0 = ((BitmapDrawable) V2).getBitmap();
                }
                QRDisplayActivity qRDisplayActivity = QRDisplayActivity.this;
                if (qRDisplayActivity.f94638u0 == null) {
                    qRDisplayActivity.f94638u0 = new Bundle();
                    QRDisplayActivity.this.f94638u0.putInt("bkgRes", 0);
                    QRDisplayActivity.this.f94638u0.putInt("nameClr", -16777216);
                    QRDisplayActivity.this.f94638u0.putInt("tipsClr", RichStatus.ACTION_COLOR_NORMAL);
                    QRDisplayActivity.this.f94638u0.putInt("B", -16777216);
                    QRDisplayActivity.this.f94638u0.putInt("W", 16777215);
                    QRDisplayActivity.this.f94638u0.putParcelable("qrloc", new Rect(45, 76, 495, 526));
                    QRDisplayActivity.this.f94638u0.putInt("head", 1);
                }
                QRDisplayActivity qRDisplayActivity2 = QRDisplayActivity.this;
                if (qRDisplayActivity2.f94591e0 == null) {
                    qRDisplayActivity2.f94591e0 = qRDisplayActivity2.H3(qRDisplayActivity2.f94618n0, qRDisplayActivity2.f94636t0, -1);
                }
                QRDisplayActivity qRDisplayActivity3 = QRDisplayActivity.this;
                if (qRDisplayActivity3.f94591e0 != null) {
                    qRDisplayActivity3.Q4();
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class z extends com.tencent.qidian.controller.a {
        z() {
        }

        @Override // com.tencent.qidian.controller.a
        protected void l(boolean z16, HashMap<String, Object> hashMap) {
            if (QLog.isColorLevel()) {
                QLog.d("QRDisplayActivity", 2, "mBusinessObserver onQidianGroupInfo qrcode url: " + z16);
            }
            QRDisplayActivity qRDisplayActivity = QRDisplayActivity.this;
            if (!qRDisplayActivity.f94600h0 && !qRDisplayActivity.isFinishing()) {
                if (!z16) {
                    QRDisplayActivity.this.J3();
                    return;
                }
                String str = (String) hashMap.get("uin");
                String str2 = (String) hashMap.get("url");
                QRDisplayActivity.this.r4(str, 2, str2);
                BitMatrix o16 = com.tencent.biz.qrcode.util.h.o(str2, -1);
                if (o16 != null) {
                    QRDisplayActivity qRDisplayActivity2 = QRDisplayActivity.this;
                    qRDisplayActivity2.f94591e0 = o16;
                    qRDisplayActivity2.Q4();
                    return;
                }
                QRDisplayActivity.this.J3();
            }
        }
    }

    public static List<ShareActionSheetBuilder.ActionSheetItem>[] A3(Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
        return new ArrayList[]{arrayList};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B3() {
        if (QLog.isDevelopLevel()) {
            QLog.d("QRDisplayActivity", 4, "qrcode url not valid");
        }
        Intent intent = getIntent();
        if (this.f94603i0) {
            ((QidianHandler) this.app.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).M2(this.f94618n0, intent.getStringExtra("groupOwner"));
            return;
        }
        String stringExtra = intent.getStringExtra("uin");
        int intExtra = intent.getIntExtra("type", 1);
        ad adVar = new ad();
        adVar.f94679a = new WeakReference<>(this);
        adVar.f94681c = intExtra;
        adVar.f94680b = stringExtra;
        com.tencent.biz.qrcode.util.h.q(this.app, stringExtra, intExtra, 0, adVar, this.f94648z0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int C3() {
        if (this.L1) {
            return R.drawable.npr;
        }
        return R.drawable.npq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C4(final int i3, final String str) {
        try {
            final String str2 = "temp_qrcode_share_" + str + ".png";
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.biz.qrcode.activity.QRDisplayActivity.32
                @Override // java.lang.Runnable
                public void run() {
                    QRDisplayActivity qRDisplayActivity = QRDisplayActivity.this;
                    final String P = com.tencent.biz.qrcode.util.h.P(qRDisplayActivity, str2, qRDisplayActivity.f94609k0);
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qrcode.activity.QRDisplayActivity.32.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (QRDisplayActivity.this.isFinishing()) {
                                return;
                            }
                            Bundle bundle = new Bundle();
                            bundle.putInt("forward_type", 1);
                            bundle.putString(AppConstants.Key.FORWARD_FILEPATH, P);
                            bundle.putString(AppConstants.Key.FORWARD_THUMB, P);
                            bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_BIG_URL, P);
                            bundle.putString(AppConstants.Key.FORWARD_EXTRA, P);
                            bundle.putInt(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, 1);
                            bundle.putInt("key_direct_show_uin_type", i3);
                            bundle.putString("key_direct_show_uin", str);
                            AnonymousClass32 anonymousClass32 = AnonymousClass32.this;
                            if (6000 == i3 && AppConstants.DATALINE_PC_UIN == str) {
                                bundle.putBoolean("filepath_copy", true);
                            }
                            Intent intent = new Intent();
                            intent.putExtras(bundle);
                            ForwardBaseOption.startForwardActivityForResult(QRDisplayActivity.this, intent, (Class<?>) ForwardRecentTranslucentActivity.class, 21, BusinessInfoCheckUpdateItem.UIAPPID_CUKING_CARD, "biz_src_jc_gxl_ctcshare");
                        }
                    });
                }
            }, 8, null, true);
        } catch (OutOfMemoryError unused) {
            com.tencent.biz.qrcode.util.h.T(1, R.string.dzy);
        }
    }

    private void D4() {
        ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
        getIntent().putExtra("big_brother_source_key", "biz_src_jc_gxl_ctcshare");
        param.canceledOnTouchOutside = true;
        param.context = this;
        param.fullScreen = true;
        param.f317475lp = new ViewGroup.LayoutParams(-1, -2);
        ShareActionSheet create = ShareActionSheetFactory.create(param);
        Intent intent = new Intent();
        intent.putExtra("forward_type", 27);
        create.setIntentForStartForwardRecentActivity(intent);
        create.setRowVisibility(0, 0, 0);
        ArrayList arrayList = new ArrayList();
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(26));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
        boolean e06 = WXShareHelper.b0().e0();
        boolean f06 = WXShareHelper.b0().f0();
        if (QLog.isColorLevel()) {
            QLog.d("QRDisplayActivity", 2, " showMyQrCodeActionSheet() isWxInstalled = " + e06 + " isWxSupportApi =" + f06);
        }
        if (e06 && f06) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(39));
        arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(1));
        create.setActionSheetItems(arrayList, arrayList2);
        create.setItemClickListenerV2(new q());
        create.show();
    }

    private void E4(boolean z16) {
        ActionSheet actionSheet = this.M1;
        if (actionSheet != null && actionSheet.isShowing()) {
            return;
        }
        if (this.M1 == null) {
            this.M1 = (ActionSheet) ActionSheetHelper.createDialog(this, null);
        }
        if (z16) {
            this.M1.addButton(R.string.f1790638c, 1, 10);
            QidCardManager.QidCardReport.reportQidQrCard("0X800B973");
        }
        this.M1.addButton(R.string.dzo, 1, 7);
        this.M1.addButton(R.string.dzs, 1, 8);
        this.M1.addCancelButton(R.string.cancel);
        this.M1.setOnButtonClickListener(new n());
        this.M1.show();
    }

    private Drawable F3() {
        if (QQTheme.isNowSimpleUI()) {
            return LoadingUtil.getLoadingDrawable(this, 2);
        }
        return getResources().getDrawable(R.drawable.common_loading6);
    }

    private void F4() {
        ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
        getIntent().putExtra("big_brother_source_key", "biz_src_jc_gxl_ctcshare");
        param.canceledOnTouchOutside = true;
        param.context = this;
        param.fullScreen = true;
        param.f317475lp = new ViewGroup.LayoutParams(-1, -2);
        ShareActionSheet create = ShareActionSheetFactory.create(param);
        Intent intent = new Intent();
        intent.putExtra("forward_type", 27);
        create.setIntentForStartForwardRecentActivity(intent);
        create.setRowVisibility(0, 0, 0);
        ArrayList arrayList = new ArrayList();
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(26));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
        boolean e06 = WXShareHelper.b0().e0();
        boolean f06 = WXShareHelper.b0().f0();
        if (QLog.isColorLevel()) {
            QLog.d("QRDisplayActivity", 2, " showMyQrCodeActionSheet() isWxInstalled = " + e06 + " isWxSupportApi =" + f06);
        }
        if (e06 && f06) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(39));
        arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(1));
        create.setActionSheetItems(arrayList, arrayList2);
        create.setItemClickListenerV2(new p());
        create.show();
    }

    private void G4(Bitmap bitmap) {
        bitmap.recycle();
        if (this.f94609k0 != null) {
            this.f94588d0.setImageBitmap(this.f94609k0);
        } else if (super.isResume()) {
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this, 230);
            createCustomDialog.setMessage(R.string.h69);
            createCustomDialog.setPositiveButton(R.string.f171151ok, new d());
            createCustomDialog.show();
        } else {
            super.finish();
        }
        this.f94597g0 = false;
    }

    private void I4() {
        this.U1.l(this, this.V1, new com.tencent.mobileqq.troop.addsource.d() { // from class: com.tencent.biz.qrcode.activity.a
            @Override // com.tencent.mobileqq.troop.addsource.d
            public final void a(QunSourceSvrPB$SourceItem qunSourceSvrPB$SourceItem) {
                QRDisplayActivity.this.b4(qunSourceSvrPB$SourceItem);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K3() {
        if (!X3()) {
            return;
        }
        this.U1.k(new com.tencent.mobileqq.troop.addsource.b() { // from class: com.tencent.biz.qrcode.activity.b
            @Override // com.tencent.mobileqq.troop.addsource.b
            public final void a(QunJoinUrlSvrPB$GetInfoRsp qunJoinUrlSvrPB$GetInfoRsp) {
                QRDisplayActivity.this.a4(qunJoinUrlSvrPB$GetInfoRsp);
            }
        });
    }

    private void L4() {
        if (QLog.isColorLevel()) {
            QLog.d("QRDisplayActivity", 2, "showURLProgressView() mTvProgress =" + this.f94625p1);
        }
        TextView textView = this.f94625p1;
        if (textView != null && this.f94628q1 != null) {
            textView.setVisibility(0);
            this.f94625p1.setBackgroundDrawable(this.f94628q1);
            Object obj = this.f94628q1;
            if (obj instanceof Animatable) {
                ((Animatable) obj).start();
            }
        }
    }

    private void N4(bb.a aVar, boolean z16) {
        O4(aVar, z16, false);
    }

    private void O4(bb.a aVar, boolean z16, boolean z17) {
        if (aVar == null) {
            QLog.i("QRDisplayActivity", 2, "switchMyQrTheme() qrCodeList is null just return");
            return;
        }
        if (!z17) {
            this.f94619n1 = this.f94610k1.f202590a.indexOf(aVar);
        }
        if (QLog.isColorLevel()) {
            QLog.i("QRDisplayActivity", 2, "switchMyQrTheme().qrCodeList:" + aVar.toString());
        }
        if (!TextUtils.isEmpty(aVar.f202591a)) {
            this.f94613l1 = aVar.f202594d;
            this.f94616m1 = aVar.b();
            this.f94622o1 = aVar.f202591a;
            w4(aVar, this.f94619n1, z16, z17);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P3(boolean z16, Object obj) {
        String str;
        if (z16 && (obj instanceof QidProfile$GetProfileSSORsp)) {
            QidProfile$GetProfileSSORsp qidProfile$GetProfileSSORsp = (QidProfile$GetProfileSSORsp) obj;
            if (qidProfile$GetProfileSSORsp.is_set.get() == 0) {
                this.f94614l2 = 0;
                com.tencent.biz.qrcode.util.h.R(this.app, this.f94618n0, 1);
                return;
            }
            if (qidProfile$GetProfileSSORsp.is_set.get() == 1) {
                if (qidProfile$GetProfileSSORsp.pag_url.has()) {
                    str = qidProfile$GetProfileSSORsp.pag_url.get();
                } else {
                    str = "";
                }
                QidCardManager.QidCardReport.initReportParamsId(str);
                if (this.f94614l2 == 0) {
                    com.tencent.biz.qrcode.util.h.R(this.app, this.f94618n0, 2);
                }
                this.f94614l2 = 1;
                try {
                    this.f94629q2 = Color.parseColor(qidProfile$GetProfileSSORsp.btn_color.get());
                } catch (Exception e16) {
                    QLog.d("QRDisplayActivity", 2, "QID_QR,color,parse error:" + e16.getMessage());
                }
                if (qidProfile$GetProfileSSORsp.main_url.has()) {
                    QidCardManager.setLastQidBg(this.f94618n0, qidProfile$GetProfileSSORsp.main_url.get());
                }
                if (com.tencent.biz.qrcode.util.h.x(this.app, this.f94618n0) == 2) {
                    P4(2, false);
                    QidCardManager.QidCardReport.reportQidQrCard("0X800B9A6");
                    QidCardManager.QidCardReport.reportQidQrCard("0X800B9A8");
                    QidCardManager.QidCardReport.reportQidQrCard("0X800B9AA");
                    QidCardManager.QidCardReport.reportQidQrCard("0X800B972");
                } else {
                    this.f94620n2.restoreQrCodeColor = true;
                }
                QidPagView.QidData qidData = new QidPagView.QidData();
                String str2 = this.f94612l0;
                qidData.nickName = str2;
                if (str2.length() > 16) {
                    qidData.nickName = qidData.nickName.substring(0, 15) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
                }
                qidData.uin = this.f94618n0;
                qidData.avatarBitmap = this.f94606j0;
                qidData.qrCodeColor = this.f94629q2;
                qidData.qrDrawable = this.f94598g1.getDrawable();
                if (qidProfile$GetProfileSSORsp.is_lm_show.has() && qidProfile$GetProfileSSORsp.is_lm_show.get() == 1) {
                    qidData.limixiuPath = QidCardManager.jointCmShowUrl(this.f94618n0);
                }
                if (qidProfile$GetProfileSSORsp.qid.has()) {
                    qidData.qidInfo = qidProfile$GetProfileSSORsp.qid.get();
                }
                if (qidProfile$GetProfileSSORsp.pag_url.has()) {
                    String str3 = qidProfile$GetProfileSSORsp.pag_url.get();
                    qidData.pagUrl = str3;
                    qidData.savePath = QidCardManager.obtainPagPathByUrl(str3);
                }
                if (qidProfile$GetProfileSSORsp.bg_url.has()) {
                    qidData.qidBgPath = qidProfile$GetProfileSSORsp.bg_url.get();
                }
                if (QidCardManager.checkQidPagFile(qidData.pagUrl) != null) {
                    this.f94620n2.updateQR(qidData);
                    return;
                } else {
                    QidCardManager.downloadQidRes(this, this.f94620n2, qidData);
                    return;
                }
            }
            return;
        }
        QLog.e("QRDisplayActivity", 1, "QID_QR,pb request,error:" + z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q3() {
        Object obj;
        if (QLog.isColorLevel()) {
            QLog.d("QRDisplayActivity", 2, "hideURLProgressView() mTvProgress =" + this.f94625p1);
        }
        if (this.f94625p1 != null && (obj = this.f94628q1) != null) {
            if (obj instanceof Animatable) {
                ((Animatable) obj).stop();
            }
            this.f94625p1.setBackgroundDrawable(null);
            this.f94625p1.setVisibility(8);
        }
    }

    private void R3() {
        this.f94617m2 = (LinearLayout) findViewById(R.id.f653438o);
        this.f94620n2 = (QidPagView) findViewById(R.id.f58082p2);
        this.f94623o2 = new RedTouch(this, this.U0).setGravity(53).setRedPointSize(20).setTopMargin(20.0f).setRightMargin(20.0f).applyTo();
        this.f94626p2 = getResources().getColor(R.color.ahl);
        int x16 = com.tencent.biz.qrcode.util.h.x(this.app, this.f94618n0);
        if (x16 == 2) {
            P4(x16, false);
        }
        if (!QVipQidProcessor.get().isQidProfileEnable()) {
            this.U0.setVisibility(8);
            findViewById(R.id.f653838s).setVisibility(8);
            this.f94623o2.setVisibility(8);
        }
    }

    private void S3() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f94582b0.getLayoutParams();
        layoutParams.gravity = 17;
        this.f94582b0.setLayoutParams(layoutParams);
        this.f94585c0.setBackgroundDrawable(null);
        getTitleBarView().setBackgroundColor(0);
        ImmersiveUtils.setStatusTextColor(true, getWindow());
        this.f94588d0.setVisibility(8);
        findViewById(R.id.f166655h12).setBackgroundDrawable(null);
        this.J0.setVisibility(8);
        this.f94583b1 = findViewById(android.R.id.content);
        ImageView imageView = (ImageView) findViewById(R.id.ivTitleBtnRightImage);
        this.f94586c1 = imageView;
        imageView.setVisibility(0);
        this.f94586c1.setContentDescription(getString(R.string.epf));
        this.f94586c1.setOnClickListener(this);
        com.tencent.biz.qrcode.util.a aVar = com.tencent.biz.qrcode.util.a.f95053a;
        aVar.b(this.f94586c1, "em_bas_my_qrcode_more_button", null);
        this.leftView.setContentDescription(getString(R.string.hih));
        ViewGroup.LayoutParams layoutParams2 = this.leftView.getLayoutParams();
        layoutParams2.width = ViewUtils.dip2px(24.0f);
        layoutParams2.height = ViewUtils.dpToPx(24.0f);
        View findViewById = findViewById(R.id.f653238m);
        this.f94589d1 = findViewById;
        findViewById.setVisibility(0);
        View findViewById2 = this.f94589d1.findViewById(R.id.f650137s);
        this.f94592e1 = findViewById2;
        findViewById2.setOnClickListener(this);
        this.f94592e1.setContentDescription(getString(R.string.f2034850b));
        ImageView imageView2 = (ImageView) this.f94589d1.findViewById(R.id.y65);
        this.f94595f1 = imageView2;
        imageView2.setContentDescription(HardCodeUtil.qqStr(R.string.f1792038q));
        s4(this.f94595f1);
        this.f94598g1 = (ImageView) this.f94589d1.findViewById(R.id.y7i);
        this.f94601h1 = (TextView) this.f94589d1.findViewById(R.id.f109536g3);
        this.f94604i1 = (TextView) this.f94589d1.findViewById(R.id.f112166n7);
        LongClickCopyAction attachCopyAction = LongClickCopyAction.attachCopyAction(this.f94604i1, HardCodeUtil.qqStr(R.string.f1790338_), this.f94618n0);
        if (attachCopyAction != null) {
            attachCopyAction.setCopyListener(new w());
        }
        this.f94607j1 = (TextView) this.f94589d1.findViewById(R.id.kbr);
        AccessibilityUtil.s(this.f94604i1, getString(R.string.f20341505, this.f94618n0));
        this.f94615m0 = getString(R.string.g2x);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.cyi);
        this.X0 = linearLayout;
        linearLayout.setVisibility(0);
        this.N0 = findViewById(R.id.f6510381);
        this.O0 = (ImageView) findViewById(R.id.f6509380);
        this.P0 = (TextView) findViewById(R.id.f6511382);
        this.Q0 = findViewById(R.id.h1p);
        this.R0 = (ImageView) findViewById(R.id.h1o);
        this.S0 = (TextView) findViewById(R.id.h1q);
        this.U0 = findViewById(R.id.f653638q);
        this.V0 = (ImageView) findViewById(R.id.f653538p);
        this.W0 = (TextView) findViewById(R.id.f653738r);
        this.O0.setImageDrawable(cn.f(getResources().getDrawable(R.drawable.qui_share)));
        aVar.b(this.N0, "em_bas_my_qrcode_share_button", null);
        this.R0.setImageDrawable(cn.f(getResources().getDrawable(R.drawable.qui_scan)));
        aVar.b(this.Q0, "em_bas_my_qrcode_scan_button", null);
        this.V0.setImageDrawable(cn.f(getResources().getDrawable(R.drawable.qui_transfer)));
        aVar.b(this.U0, "em_bas_my_qrcode_switch_qid_button", null);
        int width = (getWindowManager().getDefaultDisplay().getWidth() - (getResources().getDimensionPixelSize(R.dimen.aad) * 3)) / 8;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.X0.getLayoutParams();
        if (marginLayoutParams != null) {
            marginLayoutParams.leftMargin = width;
            marginLayoutParams.rightMargin = width;
            this.X0.setLayoutParams(marginLayoutParams);
        }
        this.f94634s1 = new ac();
        this.N0.setOnClickListener(this);
        this.N0.setOnTouchListener(this.f94634s1);
        this.Q0.setOnClickListener(this);
        this.Q0.setOnTouchListener(this.f94634s1);
        this.U0.setOnClickListener(this);
        this.U0.setOnTouchListener(this.f94634s1);
        AccessibilityUtil.d(this.N0, Button.class.getName());
        AccessibilityUtil.d(this.Q0, Button.class.getName());
        AccessibilityUtil.d(this.U0, Button.class.getName());
        this.f94628q1 = F3();
        this.f94625p1 = (TextView) findViewById(R.id.f61912ze);
        bb bbVar = new bb();
        this.f94610k1 = bbVar;
        if (bbVar.f202590a.size() <= 0 || TextUtils.isEmpty(this.f94610k1.f202590a.get(0).f202591a)) {
            this.f94607j1.setVisibility(8);
        }
        int t16 = com.tencent.biz.qrcode.util.h.t(this.app);
        this.f94619n1 = t16;
        if (t16 >= 0 && t16 < this.f94610k1.f202590a.size()) {
            if (com.tencent.biz.qrcode.util.h.x(this.app, this.f94618n0) == 1) {
                N4(this.f94610k1.f202590a.get(this.f94619n1), false);
            }
        } else {
            z4();
        }
        ReportController.o(this.app, "CliOper", "", "", "0X800AEAB", "0X800AEAB", 0, 0, "", "", "", "");
        QidCardManager.QidCardReport.reportQidQrCard("0X800B96E");
    }

    private void S4(bb.a aVar, boolean z16) {
        if (aVar == null) {
            QLog.i("QRDisplayActivity", 2, "switchMyQrTheme() qrCodeList is null just return");
            return;
        }
        this.f94619n1 = this.f94610k1.f202590a.indexOf(aVar);
        if (QLog.isColorLevel()) {
            QLog.i("QRDisplayActivity", 2, "switchMyQrTheme().qrCodeList:" + aVar.toString());
        }
        if (!TextUtils.isEmpty(aVar.f202591a)) {
            this.f94613l1 = aVar.f202594d;
            this.f94616m1 = aVar.b();
            this.f94622o1 = aVar.f202591a;
            u4(aVar, this.f94619n1, z16);
        }
    }

    private void T3() {
        if (!this.L1) {
            return;
        }
        if (this.f94586c1 != null) {
            Drawable drawable = getResources().getDrawable(R.drawable.a65);
            drawable.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
            this.f94586c1.setBackgroundDrawable(null);
            this.f94586c1.setImageDrawable(drawable);
        }
        TextView textView = this.centerView;
        if (textView != null) {
            textView.setTextColor(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0061 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void U4() {
        String str;
        int i3;
        String str2;
        String str3;
        String str4 = "qr_circle";
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            QQToast.makeText(this, getString(R.string.b3j), 0).show(getTitleBarHeight());
            if (QLog.isColorLevel()) {
                QLog.i("QRDisplayActivity", 2, "tryToGetShareLink: net is not supported");
            }
            if (this.f94636t0 == 2) {
                int i16 = this.f94608j2;
                if (i16 != 2) {
                    if (i16 != 3) {
                        if (i16 == 9) {
                            str3 = "qr_wechat";
                            if (!TextUtils.isEmpty(str3)) {
                                return;
                            } else {
                                eu.g("Grp_share", "grpData_admin", str3, 0, 0, this.f94618n0, String.valueOf(this.f94627q0), "1");
                            }
                        } else if (i16 != 10) {
                            str4 = "";
                        }
                    } else {
                        str4 = "qr_qzone";
                    }
                } else {
                    str4 = "qr_qq";
                }
                str3 = str4;
                if (!TextUtils.isEmpty(str3)) {
                }
            }
            this.f94608j2 = 0;
            return;
        }
        final String str5 = "temp_qrcode_share_" + this.f94618n0 + ".png";
        final String str6 = "temp_qrcode_share_qid_" + this.f94618n0 + ".png";
        int i17 = this.f94608j2;
        if (i17 != 2) {
            if (i17 != 3) {
                if (i17 == 9 || i17 == 10) {
                    try {
                        if (!WXShareHelper.b0().e0()) {
                            i3 = R.string.f173257ih1;
                        } else if (!WXShareHelper.b0().f0()) {
                            i3 = R.string.f173258ih2;
                        } else {
                            i3 = -1;
                        }
                        if (i3 != -1) {
                            QQToast.makeText(this, getString(i3), 0).show(getTitleBarHeight());
                            if (this.f94636t0 == 2) {
                                if (this.f94608j2 != 9) {
                                    str2 = "qr_circle";
                                } else {
                                    str2 = "qr_wechat";
                                }
                                eu.g("Grp_share", "grpData_admin", str2, 0, 0, this.f94618n0, String.valueOf(this.f94627q0), "1");
                            }
                            this.f94608j2 = 0;
                            return;
                        }
                        if (this.F0 == null) {
                            this.F0 = new l();
                            WXShareHelper.b0().A(this.F0);
                        }
                        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.biz.qrcode.activity.QRDisplayActivity.24
                            @Override // java.lang.Runnable
                            public void run() {
                                String str7;
                                QRDisplayActivity qRDisplayActivity = QRDisplayActivity.this;
                                if (com.tencent.biz.qrcode.util.h.x(qRDisplayActivity.app, qRDisplayActivity.f94618n0) == 1) {
                                    str7 = str5;
                                } else {
                                    str7 = str6;
                                }
                                QRDisplayActivity qRDisplayActivity2 = QRDisplayActivity.this;
                                final String P = com.tencent.biz.qrcode.util.h.P(qRDisplayActivity2, str7, qRDisplayActivity2.f94609k0);
                                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qrcode.activity.QRDisplayActivity.24.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        String str8;
                                        if (QRDisplayActivity.this.isFinishing()) {
                                            return;
                                        }
                                        if (TextUtils.isEmpty(P)) {
                                            com.tencent.biz.qrcode.util.h.T(1, R.string.dzx);
                                            QRDisplayActivity qRDisplayActivity3 = QRDisplayActivity.this;
                                            if (qRDisplayActivity3.f94636t0 == 2) {
                                                if (qRDisplayActivity3.f94608j2 == 9) {
                                                    str8 = "qr_wechat";
                                                } else {
                                                    str8 = "qr_circle";
                                                }
                                                eu.g("Grp_share", "grpData_admin", str8, 0, 0, qRDisplayActivity3.f94618n0, String.valueOf(qRDisplayActivity3.f94627q0), "1");
                                                return;
                                            }
                                            return;
                                        }
                                        if (QRDisplayActivity.this.f94608j2 == 9) {
                                            WXShareHelper.b0().u0(P, QRDisplayActivity.this.f94609k0, 0);
                                            QRDisplayActivity qRDisplayActivity4 = QRDisplayActivity.this;
                                            int i18 = qRDisplayActivity4.f94636t0;
                                            if (i18 == 2) {
                                                ReportController.o(qRDisplayActivity4.app, "P_CliOper", "Grp_set", "", "Grp_data", "qr_wechat", 0, 0, qRDisplayActivity4.f94618n0, "", String.valueOf(qRDisplayActivity4.f94627q0), "");
                                                return;
                                            } else {
                                                if (i18 == 5) {
                                                    ReportController.o(qRDisplayActivity4.app, "CliOper", "", "", "0X8006676", "0X8006676", 0, 0, "", "", "", "");
                                                    return;
                                                }
                                                return;
                                            }
                                        }
                                        WXShareHelper.b0().u0(P, QRDisplayActivity.this.f94609k0, 1);
                                        QRDisplayActivity qRDisplayActivity5 = QRDisplayActivity.this;
                                        int i19 = qRDisplayActivity5.f94636t0;
                                        if (i19 == 2) {
                                            ReportController.o(qRDisplayActivity5.app, "P_CliOper", "Grp_set", "", "Grp_data", "qr_circle", 0, 0, qRDisplayActivity5.f94618n0, "", String.valueOf(qRDisplayActivity5.f94627q0), "");
                                        } else if (i19 == 5) {
                                            ReportController.o(qRDisplayActivity5.app, "CliOper", "", "", "0X8006677", "0X8006677", 0, 0, "", "", "", "");
                                        }
                                    }
                                });
                            }
                        }, 8, null, true);
                        return;
                    } catch (OutOfMemoryError unused) {
                        com.tencent.biz.qrcode.util.h.T(1, R.string.dzy);
                        if (this.f94636t0 == 2) {
                            if (this.f94608j2 != 9) {
                                str = "qr_circle";
                            } else {
                                str = "qr_wechat";
                            }
                            eu.g("Grp_share", "grpData_admin", str, 0, 0, this.f94618n0, String.valueOf(this.f94627q0), "1");
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            B4();
            if ((this.M0 & 1) != 0) {
                ReportController.o(this.app, "P_CliOper", "flag1", "", "0X800416E", "0X800416E", 0, 0, "", "", "", "");
            }
            int i18 = this.f94636t0;
            if (i18 == 2) {
                ReportController.o(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "qr_qzone", 0, 0, this.f94618n0, "", String.valueOf(this.f94627q0), "");
                return;
            } else {
                if (i18 == 5) {
                    ReportController.o(this.app, "CliOper", "", "", "0X8006675", "0X8006675", 0, 0, "", "", "", "");
                    return;
                }
                return;
            }
        }
        try {
            if (com.tencent.biz.qrcode.util.h.x(this.app, this.f94618n0) != 1) {
                str5 = str6;
            }
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.biz.qrcode.activity.QRDisplayActivity.25
                @Override // java.lang.Runnable
                public void run() {
                    QRDisplayActivity qRDisplayActivity = QRDisplayActivity.this;
                    final String P = com.tencent.biz.qrcode.util.h.P(qRDisplayActivity, str5, qRDisplayActivity.f94609k0);
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qrcode.activity.QRDisplayActivity.25.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (QRDisplayActivity.this.isFinishing()) {
                                return;
                            }
                            Bundle bundle = new Bundle();
                            bundle.putInt("forward_type", 1);
                            bundle.putString(AppConstants.Key.FORWARD_FILEPATH, P);
                            bundle.putString(AppConstants.Key.FORWARD_THUMB, P);
                            bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_BIG_URL, P);
                            bundle.putString(AppConstants.Key.FORWARD_EXTRA, P);
                            Intent intent = new Intent();
                            intent.putExtras(bundle);
                            QRDisplayActivity qRDisplayActivity2 = QRDisplayActivity.this;
                            if (qRDisplayActivity2.f94636t0 == 1) {
                                ForwardBaseOption.startForwardActivityForResult(qRDisplayActivity2, intent, 21, BusinessInfoCheckUpdateItem.UIAPPID_CUKING_CARD, "biz_src_jc_gxl_ctcshare");
                            } else {
                                ForwardBaseOption.startForwardActivityForResult(qRDisplayActivity2, intent, 21);
                            }
                        }
                    });
                }
            }, 8, null, true);
            int i19 = this.f94636t0;
            if (i19 == 2) {
                ReportController.o(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "qr_qq", 0, 0, this.f94618n0, "", String.valueOf(this.f94627q0), "");
            } else if (i19 == 5) {
                ReportController.o(this.app, "CliOper", "", "", "0X8006674", "0X8006674", 0, 0, "", "", "", "");
            }
        } catch (OutOfMemoryError unused2) {
            com.tencent.biz.qrcode.util.h.T(1, R.string.dzy);
            if (this.f94636t0 == 2) {
                eu.g("Grp_share", "grpData_admin", "qr_qq", 0, 0, this.f94618n0, String.valueOf(this.f94627q0), "1");
            }
        }
    }

    private void V3() {
        this.N1 = findViewById(R.id.f6517388);
        this.O1 = (ImageView) findViewById(R.id.f6516387);
        this.P1 = (TextView) findViewById(R.id.f6518389);
        this.Q1 = findViewById(R.id.f6515386);
        this.R1 = findViewById(R.id.f1034660o);
        this.S1 = (TextView) findViewById(R.id.f30500oi);
        this.T1 = (TextView) findViewById(R.id.f30510oj);
        this.O1.setImageDrawable(cn.f(getResources().getDrawable(R.drawable.qui_transfer)));
        this.f94634s1 = new ac();
        this.N1.setOnClickListener(this);
        this.N1.setOnTouchListener(this.f94634s1);
        this.T1.setOnClickListener(this);
        QunSourceSvrPB$SourceItem qunSourceSvrPB$SourceItem = this.V1;
        if (qunSourceSvrPB$SourceItem != null) {
            this.S1.setText(qunSourceSvrPB$SourceItem.desc.get());
            this.T1.setText("\u53bb\u7f16\u8f91");
        }
    }

    private void V4() {
        zv3.c cVar;
        IBusManager iBusManager = this.W1;
        if (iBusManager != null && (cVar = this.X1) != null) {
            iBusManager.unRegisterEvent(com.tencent.mobileqq.troop.addsource.c.class, cVar);
        }
    }

    private boolean W3() {
        return false;
    }

    private boolean X3() {
        TroopInfo k3;
        TroopManager troopManager = (TroopManager) this.app.getManager(QQManagerFactory.TROOP_MANAGER);
        if (troopManager == null || (k3 = troopManager.k(this.f94618n0)) == null || !k3.isTroopOwner(this.app.getCurrentAccountUin())) {
            return false;
        }
        return true;
    }

    private void X4(TroopInfo troopInfo) {
        int i3;
        boolean isOwnerOrAdmin = troopInfo.isOwnerOrAdmin(getCurrentAccountUin());
        if (QLog.isColorLevel()) {
            QLog.d("QRDisplayActivity", 2, "updateBottomTroopInfoAndTips isOwnerOrAdmin = " + isOwnerOrAdmin);
        }
        TextView textView = (TextView) findViewById(R.id.vu8);
        textView.setVisibility(0);
        if (isOwnerOrAdmin) {
            i3 = R.string.f217055zz;
        } else {
            i3 = R.string.f217045zy;
        }
        textView.setText(getResources().getString(i3));
    }

    private void Y4(boolean z16) {
        if (z16) {
            this.N1.setVisibility(0);
            this.Q1.setVisibility(0);
            this.R1.setVisibility(0);
        } else {
            this.N1.setVisibility(8);
            this.Q1.setVisibility(8);
            this.R1.setVisibility(8);
        }
    }

    private void Z4() {
        QunSourceSvrPB$SourceItem qunSourceSvrPB$SourceItem = this.V1;
        if (qunSourceSvrPB$SourceItem != null && qunSourceSvrPB$SourceItem.url.get() != null && !this.V1.url.get().isEmpty()) {
            QLog.i("QRDisplayActivity", 1, "[updateTroopSourceQRCode] url = " + this.V1.url.get());
            if (this.f94609k0 != null) {
                if (!this.f94609k0.isRecycled()) {
                    this.f94609k0.recycle();
                }
                this.f94609k0 = null;
            }
            ad adVar = new ad();
            adVar.f94679a = new WeakReference<>(this);
            adVar.f94681c = this.f94636t0;
            adVar.f94680b = this.f94618n0;
            adVar.a(true, this.V1.url.get());
            return;
        }
        QLog.i("QRDisplayActivity", 1, "[updateTroopSourceQRCode] sourceItem = " + this.V1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a4(QunJoinUrlSvrPB$GetInfoRsp qunJoinUrlSvrPB$GetInfoRsp) {
        if (qunJoinUrlSvrPB$GetInfoRsp != null && qunJoinUrlSvrPB$GetInfoRsp.items.get() != null && !qunJoinUrlSvrPB$GetInfoRsp.items.get().isEmpty()) {
            QunJoinUrlSvrPB$ButtonItem qunJoinUrlSvrPB$ButtonItem = qunJoinUrlSvrPB$GetInfoRsp.button.get();
            if (qunJoinUrlSvrPB$GetInfoRsp.items.get().size() == 1 && qunJoinUrlSvrPB$ButtonItem != null) {
                this.R1.setVisibility(0);
                this.S1.setText(qunJoinUrlSvrPB$ButtonItem.tip.get());
                this.T1.setText(qunJoinUrlSvrPB$ButtonItem.wording.get());
                return;
            }
            Y4(true);
            if (!this.U1.e(this.V1)) {
                QunSourceSvrPB$SourceItem qunSourceSvrPB$SourceItem = qunJoinUrlSvrPB$GetInfoRsp.items.get().get(0);
                this.V1 = qunSourceSvrPB$SourceItem;
                this.S1.setText(qunSourceSvrPB$SourceItem.desc.get());
                if (qunJoinUrlSvrPB$ButtonItem != null) {
                    this.T1.setText(qunJoinUrlSvrPB$ButtonItem.wording.get());
                }
                Z4();
                return;
            }
            return;
        }
        Y4(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b4(QunSourceSvrPB$SourceItem qunSourceSvrPB$SourceItem) {
        this.V1 = qunSourceSvrPB$SourceItem;
        this.S1.setText(qunSourceSvrPB$SourceItem.desc.get());
        Z4();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c4() {
        if (!this.app.isVideoChatting() && W3()) {
            this.E1.sendMessage(this.E1.obtainMessage(1000, 5, 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d4() {
        if (!this.app.isVideoChatting() && W3()) {
            this.E1.removeCallbacksAndMessages(null);
            this.E1.obtainMessage(1001, 5, 0).sendToTarget();
        }
    }

    private void f4(@NonNull Intent intent) {
        String stringExtra = intent.getStringExtra("my_qrcode_pg_source");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.f94648z0 = Integer.parseInt(stringExtra);
        } else if (intent.getIntExtra("type", 1) == 2) {
            this.f94648z0 = Integer.parseInt("1000");
        } else {
            this.f94648z0 = Integer.parseInt("0");
        }
    }

    private void g4() {
        if (this.X1 == null) {
            this.X1 = new v();
        }
        this.W1.registerEvent(com.tencent.mobileqq.troop.addsource.c.class, this.X1);
    }

    private void h3(Bundle bundle, ArrayList<Rect> arrayList, Bitmap bitmap) {
        String str;
        Bitmap[] bitmapArr = new Bitmap[1];
        if (com.tencent.biz.qrcode.util.h.x(this.app, this.f94618n0) == 2) {
            if (p3()) {
                str = this.f94610k1.f202590a.get(this.f94619n1).f202591a;
            } else {
                str = null;
            }
            this.f94622o1 = str;
        }
        if (TextUtils.isEmpty(this.f94622o1)) {
            bitmapArr[0] = BitmapFactory.decodeResource(getResources(), C3());
            y3(bundle, arrayList, bitmap, bitmapArr);
        } else {
            v3(bundle, arrayList, bitmap, bitmapArr);
        }
    }

    private void h4(View view, String str) {
        VideoReport.addToDetectionWhitelist(this);
        VideoReport.setPageId(view, "pg_my_qrcode");
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        VideoReport.setPageParams(view, "my_qrcode_pg_source", str);
        VideoReport.setPageParams(view, "my_qrcode_pg_source_type", "2");
    }

    private void i3(Bundle bundle, ArrayList<Rect> arrayList, Bitmap bitmap) {
        Bitmap decodeResource;
        char c16;
        if (TextUtils.isEmpty(this.f94622o1)) {
            decodeResource = BitmapFactory.decodeResource(getResources(), C3());
        } else {
            try {
                decodeResource = BaseImageUtil.drawableToBitmap(URLDrawable.getDrawable(this.f94622o1).getCurrDrawable().mutate());
            } catch (Exception unused) {
                decodeResource = BitmapFactory.decodeResource(getResources(), C3());
            }
        }
        Bitmap bitmap2 = decodeResource;
        Bitmap[] r16 = com.tencent.biz.qrcode.util.h.r(this, bitmap2, this.f94606j0, bitmap, arrayList, bundle.getInt("nameClr"), this.f94612l0, String.format(getString(R.string.f2064558c), this.f94618n0), bundle.getInt("tipsClr"), this.f94615m0, this.f94616m1, this.f94613l1, !this.D1);
        if (this.f94609k0 == null) {
            this.f94645x1.setImageBitmap(r16[0]);
            this.f94647y1.setText(this.f94612l0);
            c16 = 1;
            this.f94649z1.setText(String.format(getString(R.string.f2064558c), this.f94618n0));
            this.A1.setText(getString(R.string.f2034850b));
            this.f94643w1.setImageBitmap(this.f94606j0);
        } else {
            c16 = 1;
        }
        this.f94609k0 = r16[c16];
        if (bitmap2 != null) {
            bitmap2.recycle();
        }
    }

    private void k4() {
        if (!QVipQidProcessor.get().isQidProfileEnable()) {
            QLog.e("QRDisplayActivity", 1, "[requestQidProfile] qidProfileEnable is false, not get manager or manager value false!");
        } else {
            com.tencent.mobileqq.vip.n.request(QidCardManager.CMD_GET_QID_PROFILE, new QidProfile$GetProfileSSOReq(), QidProfile$GetProfileSSORsp.class, new BusinessObserver() { // from class: com.tencent.biz.qrcode.activity.QRDisplayActivity.37
                @Override // com.tencent.mobileqq.app.BusinessObserver
                public void onUpdate(int i3, final boolean z16, final Object obj) {
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qrcode.activity.QRDisplayActivity.37.1
                        @Override // java.lang.Runnable
                        public void run() {
                            QRDisplayActivity.this.P3(z16, obj);
                        }
                    });
                }
            });
        }
    }

    private void l3() {
        com.tencent.biz.qrcode.util.h.R(this.app, this.f94618n0, 1);
        Intent intent = new Intent();
        intent.putExtras(getIntent());
        overridePendingTransition(0, 0);
        QPublicFragmentActivity.start(this, intent, QRDisplayMyCardFragment.class);
        finish();
        overridePendingTransition(0, 0);
    }

    private void n3(ImageView imageView) {
        if (imageView == null) {
            return;
        }
        imageView.setImageDrawable(cn.f(imageView.getDrawable()));
        imageView.clearColorFilter();
    }

    private void n4(ImageView imageView) {
        if (imageView == null) {
            return;
        }
        imageView.setImageDrawable(cn.f(imageView.getDrawable()));
        imageView.setColorFilter(this.f94629q2);
    }

    private void o4(bb.a aVar, int i3, boolean z16, URLDrawable uRLDrawable, boolean z17) {
        if (QLog.isColorLevel()) {
            QLog.d("QRDisplayActivity", 2, "setDrawableListener(): ud = " + uRLDrawable + " bkgURL = " + aVar.f202591a);
        }
        uRLDrawable.setURLDrawableListener(new r(aVar, i3, z16, z17));
    }

    private static void r3(short[] sArr, byte[] bArr) {
        for (int i3 = 0; i3 < sArr.length; i3++) {
            int i16 = i3 * 2;
            short s16 = sArr[i3];
            bArr[i16] = (byte) (s16 & 255);
            bArr[i16 + 1] = (byte) ((s16 >> 8) & 255);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s3() {
        String format = String.format(getString(R.string.yko), getData());
        if (this.f94636t0 == 2) {
            format = String.format(getString(R.string.f171050c02), this.f94612l0, getData());
        }
        if (QLog.isColorLevel()) {
            QLog.i("QRDisplayActivity", 2, "copyTroopLink.text:" + format);
        }
        ClipboardMonitor.setPrimaryClip((ClipboardManager) getSystemService("clipboard"), ClipData.newPlainText("my_qr_url", format));
        QQToast.makeText(this, 2, getString(R.string.f170327mg), 0).show(getTitleBarHeight());
        this.f94608j2 = 0;
    }

    private void s4(View view) {
        ViewCompat.setAccessibilityDelegate(view, new x());
    }

    private void sendIsResumeBroadcast(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("QRDisplayActivity", 2, "sendIsResumeBroadcast isNeedSend = " + this.K1 + " ,isResume = " + z16);
        }
        if (this.K1) {
            SmallScreenUtils.A(BaseApplication.getContext(), z16);
        }
    }

    private void t3(Bitmap bitmap) {
        this.f94598g1.setImageBitmap(bitmap);
        this.f94601h1.setText(this.f94612l0);
        int lhFlagValue = PrettyAccountUtil.getLhFlagValue();
        int lhLevelValue = PrettyAccountUtil.getLhLevelValue();
        this.f94604i1.setText(PrettyAccountUtil.handleAccountTxt(lhFlagValue, lhLevelValue, String.format(getString(R.string.f171509fq0), this.f94618n0), this.f94618n0));
        PrettyAccountUtil.handleAccountCloth(this.f94604i1, lhFlagValue, lhLevelValue);
        PrettyAccountUtil.reportLhEvent("0X800B239", lhFlagValue, lhLevelValue);
        this.f94607j1.setText(getString(R.string.f2034850b));
        this.f94595f1.setImageBitmap(this.f94606j0);
        Q3();
        k4();
    }

    private void t4(bb.a aVar, int i3, boolean z16, URLDrawable uRLDrawable) {
        if (QLog.isColorLevel()) {
            QLog.d("QRDisplayActivity", 2, "setTroopDrawableListener(): ud = " + uRLDrawable + " bkgURL = " + aVar.f202591a);
        }
        uRLDrawable.setURLDrawableListener(new s(aVar, i3, z16));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00d5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean u3(String str) {
        short[] sArr;
        ?? r16;
        FileOutputStream fileOutputStream;
        File file = new File(str);
        if (!file.exists()) {
            int init = ((IChirpApi) QRoute.api(IChirpApi.class)).init();
            if (init == 0) {
                try {
                    String currentAccountUin = this.app.getCurrentAccountUin();
                    String str2 = "0" + new String("000000000000000").substring(0, 14 - currentAccountUin.length()) + currentAccountUin;
                    if (QLog.isColorLevel()) {
                        QLog.d("QRDisplayActivity", 2, "encodeStr: " + str2);
                    }
                    Pair<Integer, short[]> encode = ((IChirpApi) QRoute.api(IChirpApi.class)).encode(str2);
                    FileOutputStream fileOutputStream2 = null;
                    if (encode != null) {
                        int intValue = ((Integer) encode.first).intValue();
                        sArr = (short[]) encode.second;
                        r16 = intValue;
                    } else {
                        sArr = null;
                        r16 = init;
                    }
                    if (r16 == 0) {
                        try {
                            try {
                                if (sArr != null) {
                                    try {
                                        fileOutputStream = new FileOutputStream(file);
                                        try {
                                            byte[] bArr = new byte[sArr.length * 2];
                                            r3(sArr, bArr);
                                            fileOutputStream.write(bArr);
                                            try {
                                                fileOutputStream.close();
                                            } catch (IOException unused) {
                                            }
                                            return true;
                                        } catch (Exception e16) {
                                            e = e16;
                                            if (QLog.isColorLevel()) {
                                                QLog.d("QRDisplayActivity", 2, "", e);
                                            }
                                            if (fileOutputStream != null) {
                                                try {
                                                    fileOutputStream.close();
                                                } catch (IOException unused2) {
                                                }
                                            } else {
                                                fileOutputStream2 = fileOutputStream;
                                            }
                                            if (fileOutputStream2 != null) {
                                                try {
                                                    fileOutputStream2.close();
                                                } catch (IOException unused3) {
                                                }
                                            }
                                            return false;
                                        }
                                    } catch (Exception e17) {
                                        e = e17;
                                        fileOutputStream = null;
                                    }
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                fileOutputStream2 = r16;
                                if (fileOutputStream2 != null) {
                                }
                                throw th;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.close();
                                } catch (IOException unused4) {
                                }
                            }
                            throw th;
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("QRDisplayActivity", 4, "something wrong, ret = " + ((int) r16));
                    }
                } finally {
                    ((IChirpApi) QRoute.api(IChirpApi.class)).release();
                }
            }
            return false;
        }
        return true;
    }

    private void u4(bb.a aVar, int i3, boolean z16) {
        boolean z17;
        Drawable background;
        Object obj;
        if (aVar == null) {
            QLog.i("QRDisplayActivity", 2, "setTroopURLDrawable() qrCodeList is null just return");
            return;
        }
        if ("default_bg".equals(aVar.f202591a)) {
            v4(aVar, i3, z16);
            this.f94637t1.setBackgroundResource(C3());
            return;
        }
        if (this.f94637t1.getBackground() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        try {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            if (z17) {
                background = getResources().getDrawable(C3());
            } else {
                background = this.f94637t1.getBackground();
            }
            obtain.mFailedDrawable = background;
            this.f94631r1 = URLDrawable.getDrawable(aVar.f202591a, obtain);
            if (QLog.isColorLevel()) {
                Object[] objArr = new Object[1];
                if (("setTroopURLDrawable: urlDrawable = " + this.f94631r1 + " status = " + this.f94631r1) != null) {
                    obj = Integer.valueOf(this.f94631r1.getStatus());
                } else {
                    obj = " is null";
                }
                objArr[0] = obj;
                QLog.d("QRDisplayActivity", 2, objArr);
            }
            if (this.f94631r1.getStatus() == 1) {
                v4(aVar, i3, z16);
                this.f94637t1.setBackgroundDrawable(this.f94631r1.getCurrDrawable());
                return;
            }
            if (z17) {
                this.f94637t1.setBackgroundResource(C3());
            }
            t4(aVar, i3, z16, this.f94631r1);
            L4();
            this.f94631r1.startDownload();
            this.f94631r1.setAutoDownload(true);
        } catch (IllegalArgumentException e16) {
            QLog.d("QRDisplayActivity", 1, "setTroopURLDrawable bkgURL is illegal please check manage info e =" + e16);
            QQToast.makeText(this, getString(R.string.f17902389), 0).show();
            Q3();
            if (z17) {
                this.f94637t1.setBackgroundResource(C3());
            }
        }
    }

    private void v3(Bundle bundle, ArrayList<Rect> arrayList, Bitmap bitmap, Bitmap[] bitmapArr) {
        try {
            URLDrawable drawable = URLDrawable.getDrawable(this.f94622o1);
            if (drawable.getStatus() == 1) {
                bitmapArr[0] = BaseImageUtil.drawableToBitmap(drawable.getCurrDrawable());
                y3(bundle, arrayList, bitmap, bitmapArr);
            } else {
                y4(bundle, arrayList, bitmap, bitmapArr, drawable);
                drawable.startDownload();
                drawable.setAutoDownload(true);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("QRDisplayActivity", 2, "OnMaskReadyFromMyQrCode: exception: " + e16.toString() + " currBkgUrl:" + this.f94622o1);
            }
            bitmapArr[0] = BitmapFactory.decodeResource(getResources(), C3());
            y3(bundle, arrayList, bitmap, bitmapArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v4(bb.a aVar, int i3, boolean z16) {
        int i16;
        if (z16) {
            Q4();
        }
        Q3();
        com.tencent.biz.qrcode.util.h.Q(this.app, i3);
        ImmersiveUtils.setStatusTextColor(!aVar.c(), getWindow());
        this.leftView.setBackground(com.tencent.biz.qrcode.util.h.p(getResources(), R.drawable.qui_chevron_left_selector));
        TextView textView = this.centerView;
        if (aVar.a()) {
            i16 = -1;
        } else {
            i16 = -16777216;
        }
        textView.setTextColor(i16);
        com.tencent.biz.qrcode.util.h.d(this.N0, this.Y0, this.N1);
    }

    private void w3() {
        DialogUtil.createCustomDialog(this, 232, (String) null, getString(R.string.f20344508), getString(R.string.cancel), getString(R.string.f2058156m), new t(), new u()).show();
        QidCardManager.QidCardReport.reportQidQrCard("0X800B970");
    }

    private void w4(bb.a aVar, int i3, boolean z16, boolean z17) {
        boolean z18;
        Drawable background;
        if ("default_bg".equals(aVar.f202591a)) {
            x4(aVar, i3, z16, z17);
            this.f94583b1.setBackgroundResource(C3());
            return;
        }
        if (this.f94583b1.getBackground() == null) {
            z18 = true;
        } else {
            z18 = false;
        }
        try {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            if (z18) {
                background = getResources().getDrawable(C3());
            } else {
                background = this.f94583b1.getBackground();
            }
            obtain.mFailedDrawable = background;
            this.f94631r1 = URLDrawable.getDrawable(aVar.f202591a, obtain);
            if (QLog.isColorLevel()) {
                QLog.d("QRDisplayActivity", 2, "setURLDrawable: urlDrawable = " + this.f94631r1 + " status = " + this.f94631r1.getStatus());
            }
            if (this.f94631r1.getStatus() == 1) {
                x4(aVar, i3, z16, z17);
                this.f94583b1.setBackgroundDrawable(this.f94631r1.getCurrDrawable());
                return;
            }
            if (z18) {
                this.f94583b1.setBackgroundResource(C3());
            }
            o4(aVar, i3, z16, this.f94631r1, z17);
            L4();
            this.f94631r1.startDownload();
            this.f94631r1.setAutoDownload(true);
        } catch (IllegalArgumentException e16) {
            QLog.d("QRDisplayActivity", 1, "bkgURL is illegal please check manage info e =" + e16);
            QQToast.makeText(this, getString(R.string.f17902389), 0).show();
            Q3();
            if (z18) {
                this.f94583b1.setBackgroundResource(C3());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x4(bb.a aVar, int i3, boolean z16, boolean z17) {
        int i16;
        int i17;
        if (z16 && !z17) {
            Q4();
        }
        Q3();
        com.tencent.biz.qrcode.util.h.O(this.app, i3);
        ImmersiveUtils.setStatusTextColor(!aVar.c(), getWindow());
        Drawable drawable = getResources().getDrawable(R.drawable.a65);
        int i18 = -1;
        if (aVar.a()) {
            i16 = -1;
        } else {
            i16 = -16777216;
        }
        drawable.setColorFilter(i16, PorterDuff.Mode.SRC_ATOP);
        this.f94586c1.setBackgroundDrawable(null);
        this.f94586c1.setImageDrawable(drawable);
        Drawable p16 = com.tencent.biz.qrcode.util.h.p(getResources(), R.drawable.qui_chevron_left_selector);
        if (aVar.a()) {
            i17 = -1;
        } else {
            i17 = -16777216;
        }
        p16.setColorFilter(i17, PorterDuff.Mode.SRC_ATOP);
        this.leftView.setBackground(p16);
        TextView textView = this.centerView;
        if (!aVar.a()) {
            i18 = -16777216;
        }
        textView.setTextColor(i18);
        if (!z17) {
            com.tencent.biz.qrcode.util.h.b(this.N0, this.Q0, this.U0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y3(Bundle bundle, ArrayList<Rect> arrayList, Bitmap bitmap, Bitmap[] bitmapArr) {
        z3(bundle, arrayList, bitmap, bitmapArr);
        G4(bitmap);
    }

    private void y4(Bundle bundle, ArrayList<Rect> arrayList, Bitmap bitmap, Bitmap[] bitmapArr, URLDrawable uRLDrawable) {
        uRLDrawable.setURLDrawableListener(new e(bitmapArr, bundle, arrayList, bitmap));
    }

    private void z3(Bundle bundle, ArrayList<Rect> arrayList, Bitmap bitmap, Bitmap[] bitmapArr) {
        Bitmap[] r16 = com.tencent.biz.qrcode.util.h.r(this, bitmapArr[0], this.f94606j0, bitmap, arrayList, bundle.getInt("nameClr"), this.f94612l0, String.format(getString(R.string.f171509fq0), this.f94618n0), bundle.getInt("tipsClr"), this.f94615m0, this.f94616m1, this.f94613l1, true);
        if (this.f94609k0 == null) {
            t3(r16[0]);
        }
        this.f94609k0 = r16[1];
        this.f94632r2 = r16[1];
        Bitmap bitmap2 = bitmapArr[0];
        if (bitmap2 != null) {
            bitmap2.recycle();
        }
        if (QLog.isColorLevel()) {
            QLog.d("QRDisplayActivity", 2, "onMaskReady: qrcodeCardCache = " + this.f94609k0);
        }
    }

    @Override // mk2.a.InterfaceC10793a
    public void B1() {
        if (isResume()) {
            this.E1.obtainMessage(1004, 4, 0).sendToTarget();
        }
    }

    protected void B4() {
        String str;
        ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.biz.qrcode.activity.QRDisplayActivity.15
            @Override // java.lang.Runnable
            public void run() {
                try {
                    final String P = com.tencent.biz.qrcode.util.h.P(QRDisplayActivity.this.getApplicationContext(), "temp_qrcode_share_" + QRDisplayActivity.this.f94618n0 + ".png", QRDisplayActivity.this.f94609k0);
                    QRDisplayActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.biz.qrcode.activity.QRDisplayActivity.15.2
                        @Override // java.lang.Runnable
                        public void run() {
                            String string;
                            if (QRDisplayActivity.this.isFinishing()) {
                                return;
                            }
                            if (TextUtils.isEmpty(P)) {
                                QRDisplayActivity qRDisplayActivity = QRDisplayActivity.this;
                                if (qRDisplayActivity.f94636t0 == 2) {
                                    eu.g("Grp_share", "grpData_admin", "qr_qzone", 0, 0, qRDisplayActivity.f94618n0, String.valueOf(qRDisplayActivity.f94627q0), "1");
                                }
                                com.tencent.biz.qrcode.util.h.T(1, R.string.dzx);
                                return;
                            }
                            QRDisplayActivity qRDisplayActivity2 = QRDisplayActivity.this;
                            int i3 = qRDisplayActivity2.f94636t0;
                            if (i3 == 2) {
                                if (qRDisplayActivity2.f94603i0) {
                                    string = qRDisplayActivity2.getString(R.string.b1n, qRDisplayActivity2.f94612l0);
                                } else {
                                    string = qRDisplayActivity2.getString(R.string.b1m, qRDisplayActivity2.f94612l0, qRDisplayActivity2.f94618n0);
                                }
                            } else if (i3 == 5) {
                                string = qRDisplayActivity2.getString(R.string.b1l, qRDisplayActivity2.f94612l0);
                            } else if (i3 == 11) {
                                string = qRDisplayActivity2.getString(R.string.f171016iq3);
                            } else {
                                string = qRDisplayActivity2.getString(R.string.b1p);
                            }
                            String str2 = string;
                            QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
                            userInfo.qzone_uin = QRDisplayActivity.this.app.getAccount();
                            QQAppInterface qQAppInterface = QRDisplayActivity.this.app;
                            userInfo.nickname = com.tencent.mobileqq.utils.ac.f(qQAppInterface, qQAppInterface.getAccount());
                            QRDisplayActivity qRDisplayActivity3 = QRDisplayActivity.this;
                            QZoneHelper.forwardToPublishMood(qRDisplayActivity3, userInfo, P, qRDisplayActivity3.getString(R.string.b1o), str2, 1);
                        }
                    });
                } catch (OutOfMemoryError unused) {
                    QRDisplayActivity qRDisplayActivity = QRDisplayActivity.this;
                    if (qRDisplayActivity.f94636t0 == 2) {
                        eu.g("Grp_share", "grpData_admin", "qr_qzone", 0, 0, qRDisplayActivity.f94618n0, String.valueOf(qRDisplayActivity.f94627q0), "1");
                    }
                    QRDisplayActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.biz.qrcode.activity.QRDisplayActivity.15.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (QRDisplayActivity.this.isFinishing()) {
                                return;
                            }
                            com.tencent.biz.qrcode.util.h.T(1, R.string.dzy);
                        }
                    });
                }
            }
        });
        int i3 = this.f94636t0;
        if (i3 == 1) {
            str = "shareConsumerQRcard";
        } else if (i3 == 2) {
            str = "shareGroupQRcard";
        } else {
            str = null;
        }
        StatisticCollector.getInstance(BaseApplication.getContext()).reportButtonClick(this.app, "", str, 1);
    }

    protected String D3(List<String> list) {
        if (list != null && list.size() > 0) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i3 = 0; i3 < list.size(); i3++) {
                stringBuffer.append(list.get(i3));
                if (i3 != list.size() - 1) {
                    stringBuffer.append("\u3001");
                }
            }
            return stringBuffer.toString();
        }
        return null;
    }

    protected void E3(int i3) {
        String qqStr;
        this.A0.removeCallbacks(this.f94596f2);
        if (i3 != 1) {
            if (i3 != 2) {
                qqStr = HardCodeUtil.qqStr(R.string.rdy);
            } else {
                qqStr = HardCodeUtil.qqStr(R.string.rdw);
            }
        } else {
            qqStr = HardCodeUtil.qqStr(R.string.rdz);
        }
        showToast(R.drawable.f160601l6, qqStr);
        finish();
    }

    protected String G3(String str) {
        return getSharedPreferences("qrcode", 0).getString("discussionnick_name" + str, null);
    }

    protected BitMatrix H3(String str, int i3, int i16) {
        String x36 = x3();
        if (x36 == null) {
            return null;
        }
        String string = getSharedPreferences("qrcode", 0).getString(x36, null);
        if (QLog.isColorLevel()) {
            QLog.d("QRDisplayActivity", 2, "getPrefMatrix uin: " + str + " type: " + i3 + " data: " + string);
        }
        if (string == null) {
            return null;
        }
        return com.tencent.biz.qrcode.util.h.o(string, i16);
    }

    public void H4() {
        if (this.f94623o2 != null) {
            IRedTouchManager iRedTouchManager = (IRedTouchManager) this.app.getRuntimeService(IRedTouchManager.class, "");
            BusinessInfoCheckUpdate.AppInfo appInfoByPath = iRedTouchManager.getAppInfoByPath("101600.101601");
            if (appInfoByPath != null) {
                iRedTouchManager.reportLevelOneRedInfo("101600.101601", 30);
            }
            this.f94623o2.parseRedTouch(appInfoByPath);
        }
    }

    public Bitmap I3() {
        Bitmap bitmap = this.f94635s2;
        if (bitmap == null) {
            this.X0.setVisibility(8);
            getTitleBarView().setVisibility(8);
            Bitmap v3 = com.tencent.biz.qrcode.util.h.v(this, com.tencent.biz.qrcode.util.h.S(this.f94583b1), this.f94620n2.getBitmap());
            this.X0.setVisibility(0);
            getTitleBarView().setVisibility(0);
            return v3;
        }
        return bitmap;
    }

    protected void J3() {
        this.A0.removeCallbacks(this.f94596f2);
        if (super.isResume()) {
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this, 230);
            createCustomDialog.setMessage(R.string.h67);
            createCustomDialog.setPositiveButton(R.string.f171151ok, new f());
            createCustomDialog.show();
            return;
        }
        finish();
    }

    protected void J4() {
        if (this.f94605i2 == null) {
            i iVar = new i();
            j jVar = new j();
            ShareActionSheet create = ShareActionSheetFactory.create(this, false);
            this.f94605i2 = create;
            create.setActionSheetTitle(getString(R.string.hja));
            this.f94605i2.setActionSheetItems(A3(this));
            this.f94605i2.setOnDismissListener(jVar);
            this.f94605i2.setCancelListener(new k());
            this.f94605i2.setItemClickListenerV2(iVar);
        }
        try {
            ShareActionSheet shareActionSheet = this.f94605i2;
            if (shareActionSheet != null && !shareActionSheet.isShowing()) {
                this.f94602h2 = false;
                this.f94605i2.show();
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("ShareActionSheet", 2, "actionSheet.show exception=" + e16);
            }
        }
    }

    public void L3() {
        if (this.f94636t0 == 1) {
            ReportController.o(this.app, "CliOper", "", "", "0X800AEAF", "0X800AEAF", 0, 0, "", "", "", "");
            if (com.tencent.biz.qrcode.util.h.x(this.app, this.f94618n0) == 2) {
                QidCardManager.QidCardReport.reportQidQrCard("0X800B9A9");
            }
        }
        ReportController.o(this.app, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "scan_QR_code", "code_click", 0, 0, "", "", "", "");
        if ("ScannerActivity".equals(this.f94646y0)) {
            if (isInMultiWindow()) {
                QQToast.makeText(this, HardCodeUtil.qqStr(R.string.rdv), 0).show();
            }
            setResult(-1);
            finish();
            return;
        }
        if (isInMultiWindow()) {
            QQToast.makeText(this, HardCodeUtil.qqStr(R.string.rdx), 0).show();
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("from", "QRDisplayActivity");
        RouteUtils.startActivityForResult(this, intent, "/qrscan/scanner", 3);
    }

    public void M3(int i3) {
        Intent intent = new Intent(this, (Class<?>) JumpActivity.class);
        intent.setData(Uri.parse("mqqapi://wallet/open?src_type=web&viewtype=0&version=1&view=" + i3 + "&entry=1"));
        startActivityForResult(intent, -1);
    }

    public void M4(boolean z16) {
        int i3;
        int i16 = 17170445;
        if (z16) {
            i3 = this.f94629q2;
            n4(this.O0);
            n4(this.R0);
            n4(this.V0);
        } else {
            if (p3()) {
                i16 = R.drawable.aay;
            }
            i3 = this.f94626p2;
            n3(this.O0);
            n3(this.R0);
            n3(this.V0);
        }
        this.N0.setBackgroundResource(i16);
        this.Q0.setBackgroundResource(i16);
        this.U0.setBackgroundResource(i16);
        this.P0.setTextColor(i3);
        this.S0.setTextColor(i3);
        this.W0.setTextColor(i3);
        QidPagView qidPagView = this.f94620n2;
        if (qidPagView != null) {
            if (z16) {
                qidPagView.updateTheme(this.f94629q2);
            } else {
                qidPagView.clearTheme();
            }
        }
        if (!z16) {
            com.tencent.biz.qrcode.util.h.b(this.N0, this.Q0, this.U0);
        }
    }

    public void P4(int i3, boolean z16) {
        bb.a aVar;
        if (!QVipQidProcessor.get().isQidProfileEnable()) {
            QLog.e("QRDisplayActivity", 1, "[switchQrCodeLayout] qidProfileEnable is false, not get manager or manager value false!");
            return;
        }
        if (p3()) {
            aVar = this.f94610k1.f202590a.get(this.f94619n1);
        } else {
            aVar = null;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.X0.getLayoutParams();
        if (i3 != 1) {
            if (i3 == 2) {
                layoutParams.addRule(3, R.id.f653438o);
                this.f94617m2.setVisibility(0);
                this.f94589d1.setVisibility(8);
                O4(new bb.a(aVar, QidCardManager.getLastQidBg(this.f94618n0), !QQTheme.isColorDark(this.f94629q2) ? 1 : 0), false, true);
                M4(true);
            }
        } else {
            l3();
        }
        if (z16) {
            com.tencent.biz.qrcode.util.h.R(this.app, this.f94618n0, i3);
        }
    }

    protected void Q4() {
        boolean z16;
        boolean z17;
        String str;
        if (!this.f94600h0 && !super.isFinishing()) {
            this.f94579a0.setVisibility(0);
            this.f94597g0 = true;
            if (QLog.isColorLevel()) {
                QLog.d("QRDisplayActivity", 2, "get code template");
            }
            CodeMaskManager codeMaskManager = this.f94594f0;
            boolean z18 = this.f94644x0;
            if ((this.f94630r0 & 2048) != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            int i3 = this.f94633s0;
            int i16 = this.f94636t0;
            if (i16 != 1 && i16 != 2) {
                z17 = false;
            } else {
                z17 = true;
            }
            codeMaskManager.e(this, z18, z16, i3, z17);
            if (this.f94644x0) {
                this.f94644x0 = false;
                return;
            }
            if (this.f94636t0 == 1) {
                str = "changeConsumerQRcard";
            } else {
                str = "changeGroupQRcard";
            }
            StatisticCollector.getInstance(BaseApplication.getContext()).reportButtonClick(this.app, "", str, 1);
        }
    }

    protected void U3() {
        TroopInfo k3;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f94582b0.getLayoutParams();
        this.f94585c0.setBackgroundDrawable(null);
        getTitleBarView().setBackgroundColor(0);
        ImmersiveUtils.setStatusTextColor(true, getWindow());
        this.f94588d0.setVisibility(8);
        findViewById(R.id.f166655h12).setBackgroundDrawable(null);
        this.J0.setVisibility(8);
        this.f94637t1 = findViewById(android.R.id.content);
        View findViewById = findViewById(R.id.f653938t);
        this.f94639u1 = findViewById;
        findViewById.setVisibility(0);
        View findViewById2 = this.f94639u1.findViewById(R.id.f650037r);
        this.f94641v1 = findViewById2;
        findViewById2.setOnClickListener(this);
        this.f94641v1.setContentDescription(getString(R.string.f2034850b));
        ImageView imageView = (ImageView) this.f94639u1.findViewById(R.id.f649237j);
        this.f94643w1 = imageView;
        imageView.setContentDescription(HardCodeUtil.qqStr(R.string.f1791738n));
        s4(this.f94643w1);
        this.f94645x1 = (ImageView) this.f94639u1.findViewById(R.id.f649337k);
        TextView textView = (TextView) this.f94639u1.findViewById(R.id.f649737o);
        this.f94647y1 = textView;
        textView.setEllipsize(TextUtils.TruncateAt.END);
        this.f94647y1.setSingleLine();
        this.f94649z1 = (TextView) this.f94639u1.findViewById(R.id.f649937q);
        this.C1 = (ImageView) this.f94639u1.findViewById(R.id.f649437l);
        this.B1 = (TextView) this.f94639u1.findViewById(R.id.f649637n);
        LongClickCopyAction.attachCopyAction(this.f94649z1, HardCodeUtil.qqStr(R.string.f1790438a), this.f94618n0);
        this.A1 = (TextView) this.f94639u1.findViewById(R.id.f649837p);
        this.f94649z1.setContentDescription(getString(R.string.f216555ym));
        View findViewById3 = findViewById(R.id.vu9);
        findViewById3.setVisibility(0);
        this.N0 = findViewById(R.id.f6513384);
        this.O0 = (ImageView) findViewById(R.id.f6512383);
        this.P0 = (TextView) findViewById(R.id.f6514385);
        this.Y0 = findViewById(R.id.f654138v);
        this.Z0 = (ImageView) findViewById(R.id.f654038u);
        this.f94580a1 = (TextView) findViewById(R.id.f654238w);
        this.O0.setImageDrawable(cn.f(getResources().getDrawable(R.drawable.qui_share)));
        this.Z0.setImageDrawable(cn.f(getResources().getDrawable(R.drawable.qui_download)));
        V3();
        TroopManager troopManager = (TroopManager) this.app.getManager(QQManagerFactory.TROOP_MANAGER);
        if (troopManager != null && (k3 = troopManager.k(this.f94618n0)) != null) {
            if (k3.isNewTroop) {
                X4(k3);
                this.D1 = true;
                this.f94649z1.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f94649z1.getLayoutParams();
                layoutParams.topMargin = 0;
                this.f94649z1.setLayoutParams(layoutParams2);
                r0.height -= 42;
                this.f94641v1.setLayoutParams((RelativeLayout.LayoutParams) this.f94641v1.getLayoutParams());
            }
            if (k3.cGroupOption == 3 && (!TroopInfo.hasPayPrivilege(k3.troopPrivilegeFlag, 128) || !TroopInfo.hasPayPrivilege(k3.troopPrivilegeFlag, 512))) {
                if (QLog.isColorLevel()) {
                    QLog.d("QRDisplayActivity", 2, "initTroopQrCodeUI: not allow join mask");
                }
                this.C1.setVisibility(0);
                this.B1.setVisibility(0);
                this.B1.setText(getString(R.string.f1791838o));
                this.N0.setVisibility(8);
                this.Y0.setVisibility(8);
            } else if ((k3.dwGroupFlagExt & 128) != 0 && !k3.isOwnerOrAdmin()) {
                if (QLog.isColorLevel()) {
                    QLog.d("QRDisplayActivity", 2, "initTroopQrCodeUI: not invite join mask");
                }
                this.C1.setVisibility(0);
                this.B1.setVisibility(0);
                this.B1.setText(getString(R.string.f1791938p));
                this.N0.setVisibility(8);
                this.Y0.setVisibility(8);
            }
        }
        int width = (getWindowManager().getDefaultDisplay().getWidth() - (getResources().getDimensionPixelSize(R.dimen.aad) * 3)) / 8;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) findViewById3.getLayoutParams();
        if (marginLayoutParams != null) {
            marginLayoutParams.leftMargin = width;
            marginLayoutParams.rightMargin = width;
            findViewById3.setLayoutParams(marginLayoutParams);
        }
        this.f94634s1 = new ac();
        this.N0.setOnClickListener(this);
        this.N0.setOnTouchListener(this.f94634s1);
        this.Y0.setOnClickListener(this);
        this.Y0.setOnTouchListener(this.f94634s1);
        this.f94628q1 = F3();
        this.f94625p1 = (TextView) findViewById(R.id.f61912ze);
        this.f94615m0 = getString(R.string.g2d);
        this.leftView.setContentDescription(getString(R.string.f170549u3));
        bb bbVar = new bb();
        this.f94610k1 = bbVar;
        if (bbVar.f202590a.size() <= 0 || TextUtils.isEmpty(this.f94610k1.f202590a.get(0).f202591a)) {
            this.A1.setVisibility(8);
        }
        int w3 = com.tencent.biz.qrcode.util.h.w(this.app);
        this.f94619n1 = w3;
        if (w3 >= 0 && w3 < this.f94610k1.f202590a.size()) {
            S4(this.f94610k1.f202590a.get(this.f94619n1), false);
            return;
        }
        this.f94637t1.setBackgroundResource(C3());
        this.leftView.setBackground(com.tencent.biz.qrcode.util.h.p(getResources(), R.drawable.qui_chevron_left_selector));
        this.centerView.setTextColor(-16777216);
        T3();
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        boolean z16;
        String str;
        String str2;
        if (this.f94636t0 == 2) {
            if (i3 != 1) {
                if (i3 != 21) {
                    str = "";
                } else {
                    str = "qr_qq";
                }
            } else {
                str = "qr_qzone";
            }
            String str3 = str;
            if (!TextUtils.isEmpty(str3)) {
                if (i16 == -1) {
                    str2 = "0";
                } else {
                    str2 = "1";
                }
                eu.g("Grp_share", "grpData_admin", str3, 0, 0, this.f94618n0, String.valueOf(this.f94627q0), str2);
            }
        }
        if (i16 == -1) {
            z16 = true;
        } else {
            z16 = false;
        }
        e4(z16);
        if (i16 == -1) {
            if (i3 == 1) {
                showToast(0, getString(R.string.f172952g24));
                if (QLog.isColorLevel()) {
                    QLog.i("QRDisplayActivity", 2, "shareQRCode success");
                }
                if ((this.M0 & 1) != 0) {
                    ReportController.o(this.app, "P_CliOper", "flag1", "", "0X800416F", "0X800416F", 0, 0, "", "", "", "");
                }
            } else {
                if (i3 == 2) {
                    Intent aliasIntent = SplashActivity.getAliasIntent(this);
                    aliasIntent.putExtras(intent);
                    ForwardUtils.p(this.app, this, ForwardUtils.n0(aliasIntent), aliasIntent);
                } else if (i3 == 21) {
                    Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(this), null);
                    m3.putExtras(new Bundle(intent.getExtras()));
                    startActivity(m3);
                    finish();
                }
                if (this.f94636t0 == 1 && i3 == 1) {
                    k4();
                }
                super.doOnActivityResult(i3, i16, intent);
            }
        }
        if (this.f94636t0 == 1) {
            k4();
        }
        super.doOnActivityResult(i3, i16, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:33:0x03c6  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x03f0  */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean doOnCreate(Bundle bundle) {
        boolean z16;
        if (1 == super.getIntent().getIntExtra("type", 1) || 2 == super.getIntent().getIntExtra("type", 2)) {
            this.mActNeedImmersive = false;
        }
        super.doOnCreate(bundle);
        this.A0 = new Handler();
        super.setContentView(R.layout.acf);
        Intent intent = super.getIntent();
        this.f94646y0 = intent.getStringExtra("from");
        this.M0 = intent.getIntExtra("reportFlag", 0);
        super.setTitle(intent.getStringExtra("title"));
        this.f94612l0 = intent.getStringExtra("nick");
        this.f94606j0 = (Bitmap) intent.getParcelableExtra(PreDetect.FACE_DETECT);
        this.f94636t0 = intent.getIntExtra("type", 1);
        this.f94618n0 = intent.getStringExtra("uin");
        this.f94627q0 = intent.getIntExtra("adminLevel", 2);
        this.f94630r0 = intent.getLongExtra("GroupFlagExt", 0L);
        this.f94633s0 = (int) intent.getLongExtra("AuthGroupType", 0L);
        this.f94603i0 = intent.getBooleanExtra("isQidianPrivateTroop", false);
        f4(intent);
        TroopSourceHandler troopSourceHandler = new TroopSourceHandler(this.f94618n0);
        this.U1 = troopSourceHandler;
        this.V1 = troopSourceHandler.j(intent.getStringExtra("market_channel_source_item"));
        this.f94588d0 = (ImageView) super.findViewById(R.id.f166656h13);
        this.f94585c0 = super.findViewById(R.id.h1s);
        this.J0 = findViewById(R.id.h1j);
        this.f94582b0 = super.findViewById(R.id.h1v);
        int i3 = this.f94636t0;
        if (i3 == 1) {
            S3();
            R3();
            h4(this.titleRoot, intent.getStringExtra("my_qrcode_pg_source"));
            com.tencent.biz.qrcode.util.h.c(this.f94583b1);
            if (com.tencent.biz.qrcode.util.h.x(this.app, this.f94618n0) == 1) {
                com.tencent.biz.qrcode.util.h.b(this.N0, this.Q0, this.U0);
            }
        } else if (i3 == 2) {
            TroopInfo troopInfoFromCache = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(this.f94618n0);
            if (troopInfoFromCache != null && troopInfoFromCache.isNeedInterceptOnBlockTroop()) {
                com.tencent.mobileqq.troop.utils.ab.c(this);
                finish();
                return true;
            }
            U3();
            this.f94585c0.post(this.f94590d2);
            com.tencent.biz.qrcode.util.h.a(this.f94637t1);
            com.tencent.biz.qrcode.util.h.d(this.N0, this.Y0, this.N1);
            TroopQRCodeDTReportHelper.e(this, this.f94637t1, intent.getStringExtra("my_qrcode_pg_source"), this.f94618n0, null);
            TroopQRCodeDTReportHelper.g(this.N0);
            TroopQRCodeDTReportHelper.f(this.Y0);
            TroopQRCodeDTReportHelper.i(this.N1);
            TroopQRCodeDTReportHelper.d(this.T1);
        } else if (i3 == 5) {
            findViewById(R.id.gfj).setVisibility(0);
            findViewById(R.id.cyh).setVisibility(0);
            findViewById(R.id.h1e).setOnClickListener(this);
            findViewById(R.id.h1f).setOnClickListener(this);
            this.f94615m0 = getString(R.string.g2_);
        } else if (i3 == 11) {
            findViewById(R.id.gfj).setVisibility(0);
            findViewById(R.id.cyh).setVisibility(0);
            findViewById(R.id.h1e).setOnClickListener(this);
            findViewById(R.id.h1f).setOnClickListener(this);
            this.f94615m0 = getString(R.string.voo);
        }
        View findViewById = super.findViewById(R.id.h1h);
        this.f94579a0 = findViewById;
        if ((findViewById instanceof ProgressBar) && QQTheme.isNowSimpleUI()) {
            ((ProgressBar) this.f94579a0).setIndeterminateDrawable(LoadingUtil.getLoadingDrawable(this, 2));
        }
        this.K0 = findViewById(R.id.gfk);
        this.J0.setContentDescription(getString(R.string.dzr));
        if (QLog.isDevelopLevel()) {
            QLog.d("QRDisplayActivity", 4, "display qrcode, type: " + this.f94636t0);
        }
        int i16 = this.f94636t0;
        if (i16 == 5) {
            getIntent().getStringExtra("discussion_shorturl");
            addObserver(this.f94581a2);
            QQAppInterface qQAppInterface = this.app;
            if (qQAppInterface != null) {
                this.D0 = (DiscussionHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER);
                this.app.registObserver(this.Y1);
            }
            this.leftView.setContentDescription(getString(R.string.dqa));
            this.J0.setContentDescription(getString(R.string.dqb));
            setResult(-1, getIntent());
            QQAppInterface qQAppInterface2 = this.app;
            if (qQAppInterface2 == null) {
                return true;
            }
            com.tencent.mobileqq.app.n nVar = (com.tencent.mobileqq.app.n) qQAppInterface2.getManager(QQManagerFactory.DISCUSSION_MANAGER);
            DiscussionInfo h16 = nVar.h(this.f94618n0);
            if (h16 == null) {
                J3();
            } else {
                ArrayList<DiscussionMemberInfo> m3 = nVar.m(this.f94618n0);
                if (m3 != null) {
                    this.L0 = m3.size();
                } else {
                    this.L0 = 0;
                }
                if (!h16.hasRenamed()) {
                    if (QLog.isDevelopLevel()) {
                        QLog.d("QRDisplayActivity", 4, "title not defined, join by nicks");
                    }
                    if (m3 != null) {
                        for (DiscussionMemberInfo discussionMemberInfo : m3) {
                            if (this.app.getAccount().equals(discussionMemberInfo.memberUin)) {
                                this.C0.add(com.tencent.mobileqq.utils.ac.f(this.app, discussionMemberInfo.memberUin));
                            } else {
                                String nickWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getNickWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(discussionMemberInfo.memberUin), "QRDisplayActivity");
                                if (!TextUtils.isEmpty(nickWithUid)) {
                                    this.C0.add(nickWithUid);
                                } else if (G3(discussionMemberInfo.memberUin) != null) {
                                    this.C0.add(G3(discussionMemberInfo.memberUin));
                                } else {
                                    this.B0.add(discussionMemberInfo.memberUin);
                                }
                            }
                        }
                        if (this.C0.size() < 5 && this.B0.size() > 0) {
                            if (QLog.isDevelopLevel()) {
                                QLog.d("QRDisplayActivity", 4, "fetch nicks from server");
                            }
                            String[] strArr = {"20002"};
                            String[] strArr2 = new String[this.B0.size()];
                            Iterator<String> it = this.B0.iterator();
                            int i17 = 0;
                            while (it.hasNext()) {
                                strArr2[i17] = it.next();
                                i17++;
                            }
                            ((DiscussionHandler) this.app.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).a3(strArr, strArr2);
                            z16 = false;
                        } else {
                            z16 = true;
                        }
                        if (this.C0.size() > 0) {
                            Collections.sort(this.C0, new aa());
                            this.f94612l0 = D3(this.C0);
                        }
                        this.leftView.setCompoundDrawables(null, null, null, null);
                        this.f94594f0 = new CodeMaskManager(this, this.f94636t0);
                        this.A0.postDelayed(this.f94596f2, 60000L);
                        if (z16) {
                            this.f94588d0.setContentDescription(this.f94612l0 + "," + this.f94615m0);
                            this.f94585c0.post(this.f94584b2);
                        }
                        if ((this.M0 & 1) != 0) {
                            ReportController.o(this.app, "P_CliOper", "flag1", "", "0X800416D", "0X800416D", 0, 0, "", "", "", "");
                        }
                        Handler handler = new Handler(ThreadManagerV2.getSubThreadLooper(), this);
                        this.E1 = handler;
                        handler.obtainMessage(1004, 1, 0).sendToTarget();
                        g4();
                        return true;
                    }
                }
            }
        } else if (i16 == 2) {
            this.J0.setContentDescription(getString(R.string.g2b, this.f94612l0, this.f94615m0));
            addObserver(this.f94593e2);
            addObserver(this.Z1);
        } else if (i16 == 11) {
            this.J0.setContentDescription(getString(R.string.g2b, this.f94612l0, this.f94615m0));
        }
        z16 = true;
        this.leftView.setCompoundDrawables(null, null, null, null);
        this.f94594f0 = new CodeMaskManager(this, this.f94636t0);
        this.A0.postDelayed(this.f94596f2, 60000L);
        if (z16) {
        }
        if ((this.M0 & 1) != 0) {
        }
        Handler handler2 = new Handler(ThreadManagerV2.getSubThreadLooper(), this);
        this.E1 = handler2;
        handler2.obtainMessage(1004, 1, 0).sendToTarget();
        g4();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        this.A0.removeCallbacks(this.f94596f2);
        if (this.f94609k0 != null && !this.f94609k0.isRecycled()) {
            this.f94609k0.recycle();
            this.f94609k0 = null;
        }
        this.f94588d0.setImageDrawable(null);
        CodeMaskManager codeMaskManager = this.f94594f0;
        if (codeMaskManager != null) {
            codeMaskManager.l();
        }
        int i3 = this.f94636t0;
        if (i3 == 5) {
            removeObserver(this.f94581a2);
            this.app.unRegistObserver(this.Y1);
        } else if (i3 == 2) {
            removeObserver(this.f94593e2);
            removeObserver(this.Z1);
        }
        if (this.F0 != null) {
            WXShareHelper.b0().q0(this.F0);
            this.F0 = null;
        }
        Object obj = this.J1;
        if (obj != null) {
            ((mk2.a) obj).b(this);
        }
        ActionSheet actionSheet = this.M1;
        if (actionSheet != null && actionSheet.isShowing()) {
            this.M1.dismiss();
            this.M1 = null;
        }
        V4();
        super.doOnDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        super.doOnPause();
        Handler handler = this.E1;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.E1.sendEmptyMessage(1001);
        }
        sendIsResumeBroadcast(false);
        Q3();
        ApngImage.pauseByTag(35);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        super.doOnResume();
        this.E1.obtainMessage(1004, 2, 0).sendToTarget();
        sendIsResumeBroadcast(true);
        ApngImage.playByTag(35);
        H4();
    }

    @Override // com.tencent.biz.qrcode.CustomAccessibilityDelegate.a
    public void e2() {
        if (QLog.isColorLevel()) {
            QLog.d("QRDisplayActivity", 2, "enter focus_clear");
        }
        this.E1.removeCallbacksAndMessages(null);
        Message.obtain(this.E1, 1001, 3, 0).sendToTarget();
    }

    void e4(boolean z16) {
        int i3;
        if (this.f94636t0 == 11) {
            Intent intent = getIntent();
            Parcelable parcelableExtra = intent.getParcelableExtra("PARAM_QRForwardReceiver");
            if (parcelableExtra instanceof ResultReceiver) {
                ResultReceiver resultReceiver = (ResultReceiver) parcelableExtra;
                if (z16) {
                    i3 = -1;
                } else {
                    i3 = 0;
                }
                resultReceiver.send(i3, intent.getExtras());
            }
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        ForwardRecentActivity.notifyResultReceiver(getIntent(), this);
        this.leftView.setBackground(com.tencent.biz.qrcode.util.h.p(getResources(), R.drawable.qui_chevron_left_selector));
        super.finish();
    }

    public String getData() {
        String x36 = x3();
        if (x36 == null) {
            return null;
        }
        return getSharedPreferences("qrcode", 0).getString(x36, null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x01f5, code lost:
    
        return false;
     */
    @Override // android.os.Handler.Callback
    @TargetApi(14)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleMessage(Message message) {
        final boolean z16 = true;
        switch (message.what) {
            case 1000:
                if (QLog.isColorLevel()) {
                    QLog.d("QRDisplayActivity", 2, "playQRCodeFailed = " + this.H1);
                }
                if (!this.H1) {
                    String str = getFilesDir() + this.app.getCurrentAccountUin() + "_vqr.dat";
                    File file = new File(str);
                    if (QLog.isColorLevel()) {
                        QLog.d("QRDisplayActivity", 2, "voiceFile.exists = " + file.exists());
                    }
                    if (!file.exists()) {
                        this.H1 = !u3(str);
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("QRDisplayActivity", 2, "playQRCodeFailed = " + this.H1);
                    }
                    if (!this.H1) {
                        if (this.F1 == null) {
                            PcmPlayer pcmPlayer = new PcmPlayer(this, this, 44100, str);
                            this.F1 = pcmPlayer;
                            pcmPlayer.g();
                            QQAudioUtils.i(this, true);
                        }
                        if (message.arg1 == 5) {
                            ReportController.o(this.app, "CliOper", "", "", "0X8007099", "0X8007099", 0, 0, "", "", "", "");
                            break;
                        }
                    } else {
                        this.E1.sendEmptyMessage(1003);
                        break;
                    }
                }
                break;
            case 1001:
                PcmPlayer pcmPlayer2 = this.F1;
                if (pcmPlayer2 != null) {
                    pcmPlayer2.h();
                    this.F1 = null;
                    if (message.arg1 == 5) {
                        ReportController.o(this.app, "CliOper", "", "", "0X8007099", "0X8007099", 1, 0, "", "", "", "");
                    }
                    if (message.arg1 == 3) {
                        ReportController.o(this.app, "CliOper", "", "", "0X8007099", "0X8007099", 1, 0, "", "", "", "");
                    }
                    QQAudioUtils.i(this, false);
                    break;
                }
                break;
            case 1002:
                PcmPlayer pcmPlayer3 = this.F1;
                if (pcmPlayer3 != null) {
                    pcmPlayer3.g();
                    break;
                }
                break;
            case 1003:
                QQAppInterface.speak(f94578t2);
                break;
            case 1004:
                this.app.setTalkbackSwitch();
                if (QLog.isColorLevel()) {
                    QLog.d("QRDisplayActivity", 2, "talkback value " + AppSetting.f99565y);
                }
                if (W3() && this.f94636t0 == 1) {
                    boolean loadLibrary = ((IChirpApi) QRoute.api(IChirpApi.class)).loadLibrary();
                    if (QLog.isColorLevel()) {
                        QLog.d("QRDisplayActivity", 2, "isSoLoaded " + loadLibrary);
                    }
                    if (!loadLibrary) {
                        if (this.J1 == null) {
                            this.J1 = ((IEarlyDownloadService) this.app.getRuntimeService(IEarlyDownloadService.class, "")).getEarlyHandler(((IQRScanEarlyHandlerApi) QRoute.api(IQRScanEarlyHandlerApi.class)).getResName(4));
                        }
                        Object obj = this.J1;
                        if (obj != null) {
                            ((mk2.a) obj).a(this);
                            this.J1.I(true);
                        }
                    } else {
                        if (!this.I1) {
                            BaseApplicationImpl.sUiHandler.post(new Runnable() { // from class: com.tencent.biz.qrcode.activity.QRDisplayActivity.26
                                @Override // java.lang.Runnable
                                public void run() {
                                    QRDisplayActivity qRDisplayActivity = QRDisplayActivity.this;
                                    QRDisplayActivity.this.J0.setAccessibilityDelegate(new CustomAccessibilityDelegate(qRDisplayActivity.J0, qRDisplayActivity));
                                    AccessibilityUtil.n(QRDisplayActivity.this.f94588d0, false);
                                }
                            });
                            this.I1 = true;
                        }
                        BaseApplicationImpl.sUiHandler.post(new Runnable() { // from class: com.tencent.biz.qrcode.activity.QRDisplayActivity.27

                            /* compiled from: P */
                            /* renamed from: com.tencent.biz.qrcode.activity.QRDisplayActivity$27$a */
                            /* loaded from: classes5.dex */
                            class a implements View.OnTouchListener {
                                a() {
                                }

                                @Override // android.view.View.OnTouchListener
                                public boolean onTouch(View view, MotionEvent motionEvent) {
                                    int action = motionEvent.getAction();
                                    if (action != 0) {
                                        if (action == 1 || action == 3) {
                                            if (QRDisplayActivity.this.f94611k2 != null) {
                                                QRDisplayActivity.this.f94611k2.cancel();
                                            }
                                            if (!QRDisplayActivity.this.G1 && motionEvent.getAction() == 1) {
                                                AccessibilityUtil.f(QRDisplayActivity.this.J0);
                                                QRDisplayActivity qRDisplayActivity = QRDisplayActivity.this;
                                                qRDisplayActivity.onClick(qRDisplayActivity.J0);
                                            }
                                        }
                                    } else if (QRDisplayActivity.this.f94611k2 != null) {
                                        QRDisplayActivity.this.G1 = false;
                                        QRDisplayActivity.this.f94611k2.start();
                                    }
                                    return true;
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                if (z16) {
                                    QRDisplayActivity.this.J0.setOnClickListener(null);
                                    QRDisplayActivity.this.J0.setClickable(false);
                                    QRDisplayActivity.this.J0.setOnTouchListener(new a());
                                } else {
                                    QRDisplayActivity.this.J0.setClickable(true);
                                    QRDisplayActivity qRDisplayActivity = QRDisplayActivity.this;
                                    qRDisplayActivity.J0.setOnClickListener(qRDisplayActivity);
                                    QRDisplayActivity.this.J0.setTouchDelegate(null);
                                }
                            }
                        });
                        break;
                    }
                }
                z16 = false;
                BaseApplicationImpl.sUiHandler.post(new Runnable() { // from class: com.tencent.biz.qrcode.activity.QRDisplayActivity.27

                    /* compiled from: P */
                    /* renamed from: com.tencent.biz.qrcode.activity.QRDisplayActivity$27$a */
                    /* loaded from: classes5.dex */
                    class a implements View.OnTouchListener {
                        a() {
                        }

                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            int action = motionEvent.getAction();
                            if (action != 0) {
                                if (action == 1 || action == 3) {
                                    if (QRDisplayActivity.this.f94611k2 != null) {
                                        QRDisplayActivity.this.f94611k2.cancel();
                                    }
                                    if (!QRDisplayActivity.this.G1 && motionEvent.getAction() == 1) {
                                        AccessibilityUtil.f(QRDisplayActivity.this.J0);
                                        QRDisplayActivity qRDisplayActivity = QRDisplayActivity.this;
                                        qRDisplayActivity.onClick(qRDisplayActivity.J0);
                                    }
                                }
                            } else if (QRDisplayActivity.this.f94611k2 != null) {
                                QRDisplayActivity.this.G1 = false;
                                QRDisplayActivity.this.f94611k2.start();
                            }
                            return true;
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (z16) {
                            QRDisplayActivity.this.J0.setOnClickListener(null);
                            QRDisplayActivity.this.J0.setClickable(false);
                            QRDisplayActivity.this.J0.setOnTouchListener(new a());
                        } else {
                            QRDisplayActivity.this.J0.setClickable(true);
                            QRDisplayActivity qRDisplayActivity = QRDisplayActivity.this;
                            qRDisplayActivity.J0.setOnClickListener(qRDisplayActivity);
                            QRDisplayActivity.this.J0.setTouchDelegate(null);
                        }
                    }
                });
                break;
        }
    }

    public void i4() {
        ((IRedTouchManager) this.app.getRuntimeService(IRedTouchManager.class, "")).onRedTouchItemClick("101600.101601");
        this.f94623o2.clearRedTouch();
    }

    protected void l4() {
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(QBaseActivity.sTopActivity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_QR_DISPLAY, QQPermissionConstants.Business.SCENE.QR_DISPLAY));
        if (qQPermission == null) {
            return;
        }
        if (qQPermission.hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) == 0) {
            m4();
        } else {
            qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new c());
        }
    }

    protected void m4() {
        String str;
        ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.biz.qrcode.activity.QRDisplayActivity.14
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:13:0x00df A[ADDED_TO_REGION] */
            /* JADX WARN: Removed duplicated region for block: B:18:0x00ee  */
            /* JADX WARN: Removed duplicated region for block: B:38:0x0090 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                final boolean z16;
                QRDisplayActivity qRDisplayActivity;
                String str2;
                OutputStream outputStream;
                Bitmap bitmap = QRDisplayActivity.this.f94609k0;
                final Uri uri = null;
                AssetFileDescriptor.AutoCloseOutputStream autoCloseOutputStream = 0;
                if (bitmap != null && !bitmap.isRecycled()) {
                    Uri uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    ContentResolver contentResolver = QRDisplayActivity.this.getContentResolver();
                    String str3 = "qrcode_" + Long.toString(System.currentTimeMillis());
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("title", str3);
                    contentValues.put(InputMethodUtil.SOUGOU_URI_DISPLAYNAME, str3);
                    contentValues.put(JobDbManager.COL_UP_MIME_TYPE, "image/jpeg");
                    Uri insert = contentResolver.insert(uri2, contentValues);
                    try {
                        if (insert != null) {
                            try {
                                outputStream = contentResolver.openOutputStream(insert);
                            } catch (FileNotFoundException e16) {
                                e = e16;
                                outputStream = null;
                                QLog.e("QRDisplayActivity", 1, "saveQRCodeReal, error = " + e);
                                if (outputStream != null) {
                                }
                                z16 = false;
                                if (!z16) {
                                }
                                uri = insert;
                                qRDisplayActivity = QRDisplayActivity.this;
                                if (qRDisplayActivity.f94636t0 == 2) {
                                }
                                QRDisplayActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.biz.qrcode.activity.QRDisplayActivity.14.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (z16) {
                                            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                                            intent.setData(uri);
                                            QRDisplayActivity.this.sendBroadcast(intent);
                                            QQToast.makeText(BaseApplication.getContext(), 2, QRDisplayActivity.this.getString(R.string.cwj), 1).show(QRDisplayActivity.this.getTitleBarHeight());
                                            return;
                                        }
                                        com.tencent.biz.qrcode.util.h.T(1, R.string.f216945zo);
                                    }
                                });
                            } catch (IllegalStateException e17) {
                                e = e17;
                                outputStream = null;
                                QLog.e("QRDisplayActivity", 1, "saveQRCodeReal, error = " + e);
                                if (outputStream != null) {
                                }
                                z16 = false;
                                if (!z16) {
                                }
                                uri = insert;
                                qRDisplayActivity = QRDisplayActivity.this;
                                if (qRDisplayActivity.f94636t0 == 2) {
                                }
                                QRDisplayActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.biz.qrcode.activity.QRDisplayActivity.14.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (z16) {
                                            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                                            intent.setData(uri);
                                            QRDisplayActivity.this.sendBroadcast(intent);
                                            QQToast.makeText(BaseApplication.getContext(), 2, QRDisplayActivity.this.getString(R.string.cwj), 1).show(QRDisplayActivity.this.getTitleBarHeight());
                                            return;
                                        }
                                        com.tencent.biz.qrcode.util.h.T(1, R.string.f216945zo);
                                    }
                                });
                            } catch (OutOfMemoryError e18) {
                                e = e18;
                                outputStream = null;
                                QLog.e("QRDisplayActivity", 1, "saveQRCodeReal, error = " + e);
                                if (outputStream != null) {
                                }
                                z16 = false;
                                if (!z16) {
                                }
                                uri = insert;
                                qRDisplayActivity = QRDisplayActivity.this;
                                if (qRDisplayActivity.f94636t0 == 2) {
                                }
                                QRDisplayActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.biz.qrcode.activity.QRDisplayActivity.14.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (z16) {
                                            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                                            intent.setData(uri);
                                            QRDisplayActivity.this.sendBroadcast(intent);
                                            QQToast.makeText(BaseApplication.getContext(), 2, QRDisplayActivity.this.getString(R.string.cwj), 1).show(QRDisplayActivity.this.getTitleBarHeight());
                                            return;
                                        }
                                        com.tencent.biz.qrcode.util.h.T(1, R.string.f216945zo);
                                    }
                                });
                            } catch (Throwable th5) {
                                th = th5;
                                if (autoCloseOutputStream != 0) {
                                    try {
                                        autoCloseOutputStream.close();
                                    } catch (IOException e19) {
                                        QLog.e("QRDisplayActivity", 1, "saveQRCodeReal finally, error = " + e19);
                                    }
                                }
                                throw th;
                            }
                        } else {
                            outputStream = null;
                        }
                        if (outputStream != null) {
                            try {
                                z16 = bitmap.compress(Bitmap.CompressFormat.JPEG, 75, outputStream);
                            } catch (FileNotFoundException e26) {
                                e = e26;
                                QLog.e("QRDisplayActivity", 1, "saveQRCodeReal, error = " + e);
                                if (outputStream != null) {
                                    try {
                                        outputStream.close();
                                    } catch (IOException e27) {
                                        QLog.e("QRDisplayActivity", 1, "saveQRCodeReal finally, error = " + e27);
                                    }
                                }
                                z16 = false;
                                if (!z16) {
                                    py3.b.e(contentResolver, insert, null, null);
                                }
                                uri = insert;
                                qRDisplayActivity = QRDisplayActivity.this;
                                if (qRDisplayActivity.f94636t0 == 2) {
                                }
                                QRDisplayActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.biz.qrcode.activity.QRDisplayActivity.14.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (z16) {
                                            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                                            intent.setData(uri);
                                            QRDisplayActivity.this.sendBroadcast(intent);
                                            QQToast.makeText(BaseApplication.getContext(), 2, QRDisplayActivity.this.getString(R.string.cwj), 1).show(QRDisplayActivity.this.getTitleBarHeight());
                                            return;
                                        }
                                        com.tencent.biz.qrcode.util.h.T(1, R.string.f216945zo);
                                    }
                                });
                            } catch (IllegalStateException e28) {
                                e = e28;
                                QLog.e("QRDisplayActivity", 1, "saveQRCodeReal, error = " + e);
                                if (outputStream != null) {
                                }
                                z16 = false;
                                if (!z16) {
                                }
                                uri = insert;
                                qRDisplayActivity = QRDisplayActivity.this;
                                if (qRDisplayActivity.f94636t0 == 2) {
                                }
                                QRDisplayActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.biz.qrcode.activity.QRDisplayActivity.14.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (z16) {
                                            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                                            intent.setData(uri);
                                            QRDisplayActivity.this.sendBroadcast(intent);
                                            QQToast.makeText(BaseApplication.getContext(), 2, QRDisplayActivity.this.getString(R.string.cwj), 1).show(QRDisplayActivity.this.getTitleBarHeight());
                                            return;
                                        }
                                        com.tencent.biz.qrcode.util.h.T(1, R.string.f216945zo);
                                    }
                                });
                            } catch (OutOfMemoryError e29) {
                                e = e29;
                                QLog.e("QRDisplayActivity", 1, "saveQRCodeReal, error = " + e);
                                if (outputStream != null) {
                                }
                                z16 = false;
                                if (!z16) {
                                }
                                uri = insert;
                                qRDisplayActivity = QRDisplayActivity.this;
                                if (qRDisplayActivity.f94636t0 == 2) {
                                }
                                QRDisplayActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.biz.qrcode.activity.QRDisplayActivity.14.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (z16) {
                                            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                                            intent.setData(uri);
                                            QRDisplayActivity.this.sendBroadcast(intent);
                                            QQToast.makeText(BaseApplication.getContext(), 2, QRDisplayActivity.this.getString(R.string.cwj), 1).show(QRDisplayActivity.this.getTitleBarHeight());
                                            return;
                                        }
                                        com.tencent.biz.qrcode.util.h.T(1, R.string.f216945zo);
                                    }
                                });
                            }
                        } else {
                            z16 = false;
                        }
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e36) {
                                QLog.e("QRDisplayActivity", 1, "saveQRCodeReal finally, error = " + e36);
                            }
                        }
                        if (!z16 && insert != null) {
                            py3.b.e(contentResolver, insert, null, null);
                        }
                        uri = insert;
                    } catch (Throwable th6) {
                        th = th6;
                        autoCloseOutputStream = "image/jpeg";
                    }
                } else {
                    z16 = false;
                }
                qRDisplayActivity = QRDisplayActivity.this;
                if (qRDisplayActivity.f94636t0 == 2) {
                    String[] strArr = new String[3];
                    strArr[0] = qRDisplayActivity.f94618n0;
                    strArr[1] = String.valueOf(qRDisplayActivity.f94627q0);
                    if (z16) {
                        str2 = "0";
                    } else {
                        str2 = "1";
                    }
                    strArr[2] = str2;
                    eu.g("Grp_share", "grpData_admin", "qr_save", 0, 0, strArr);
                }
                QRDisplayActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.biz.qrcode.activity.QRDisplayActivity.14.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (z16) {
                            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                            intent.setData(uri);
                            QRDisplayActivity.this.sendBroadcast(intent);
                            QQToast.makeText(BaseApplication.getContext(), 2, QRDisplayActivity.this.getString(R.string.cwj), 1).show(QRDisplayActivity.this.getTitleBarHeight());
                            return;
                        }
                        com.tencent.biz.qrcode.util.h.T(1, R.string.f216945zo);
                    }
                });
            }
        });
        int i3 = this.f94636t0;
        if (i3 == 1) {
            str = "saveConsumerQRcard";
        } else if (i3 == 2) {
            str = "saveGroupQRcard";
        } else {
            str = null;
        }
        StatisticCollector.getInstance(BaseApplication.getContext()).reportButtonClick(this.app, "", str, 1);
    }

    @Override // com.tencent.biz.qrcode.CodeMaskManager.a
    public void o0(Bundle bundle) {
        int i3;
        int i16;
        int i17;
        int i18;
        if (QLog.isColorLevel()) {
            QLog.d("QRDisplayActivity", 2, "template ready, draw qrcode");
        }
        if (!this.f94600h0 && !super.isFinishing()) {
            this.A0.removeCallbacks(this.f94596f2);
            Bitmap bitmap = (Bitmap) bundle.getParcelable("bkg");
            Bitmap bitmap2 = (Bitmap) bundle.getParcelable("qrbkg");
            int i19 = bundle.getInt("B");
            if (SimpleModeHelper.A()) {
                i3 = -1;
            } else {
                i3 = bundle.getInt("W");
            }
            Rect rect = (Rect) bundle.getParcelable("qrloc");
            ArrayList<Rect> parcelableArrayList = bundle.getParcelableArrayList("clip");
            if (bundle.containsKey("qrsz")) {
                int i26 = bundle.getInt("qrsz");
                String data = getData();
                if (data != null) {
                    this.f94591e0 = com.tencent.biz.qrcode.util.h.o(data, i26);
                }
            }
            int width = this.f94591e0.getWidth();
            int[] iArr = new int[width * width];
            for (int i27 = 0; i27 < width; i27++) {
                int i28 = i27 * width;
                for (int i29 = 0; i29 < width; i29++) {
                    int i36 = i28 + i29;
                    if (this.f94591e0.get(i29, i27)) {
                        i18 = i19;
                    } else {
                        i18 = i3;
                    }
                    iArr[i36] = i18;
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(width, width, Bitmap.Config.ARGB_8888);
            createBitmap.setPixels(iArr, 0, width, 0, 0, width, width);
            if ((this.f94630r0 & 2048) != 0 && ((i17 = this.f94633s0) == 2 || i17 == 1)) {
                i16 = R.drawable.e5d;
            } else {
                i16 = 0;
            }
            this.f94579a0.setVisibility(4);
            if (this.f94609k0 != null && !this.f94609k0.isRecycled()) {
                this.f94609k0.recycle();
            }
            int i37 = this.f94636t0;
            if (i37 == 1) {
                h3(bundle, parcelableArrayList, createBitmap);
            } else if (i37 == 2) {
                i3(bundle, parcelableArrayList, createBitmap);
                G4(createBitmap);
            } else {
                this.f94609k0 = com.tencent.biz.qrcode.util.h.u(this, bitmap, this.f94606j0, bundle.getInt("nameClr"), this.f94612l0, bitmap2, createBitmap, bundle.getInt("head"), bundle.getInt("tipsClr"), this.f94615m0, rect, parcelableArrayList, i16);
                G4(createBitmap);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.T0) > 1000) {
            this.T0 = currentTimeMillis;
            boolean z16 = true;
            if (view.getId() == R.id.h1j) {
                if (!this.f94597g0) {
                    int i3 = this.f94636t0;
                    if (i3 == 2) {
                        Q4();
                        if ((this.M0 & 1) != 0) {
                            ReportController.o(this.app, "P_CliOper", "flag1", "", "0X8004170", "0X8004170", 0, 0, "", "", "", "");
                        }
                    } else if (i3 != 5 && i3 != 11) {
                        showActionSheet();
                    } else {
                        Q4();
                        ReportController.o(this.app, "CliOper", "", "", "0X8006671", "0X8006671", 0, 0, "", "", "", "");
                    }
                }
            } else if (view.getId() == R.id.f166657h15) {
                if (this.E0 == null) {
                    this.E0 = new com.tencent.mobileqq.activity.discussion.a(this).b(this);
                }
                try {
                    this.E0.show();
                } catch (Exception unused) {
                }
                ReportController.o(this.app, "CliOper", "", "", "0X80040F6", "0X80040F6", 0, 0, "", "", "", "");
            } else if (view.getId() == R.id.h1e) {
                if (!this.f94597g0) {
                    l4();
                    if ((this.M0 & 1) != 0) {
                        ReportController.o(this.app, "P_CliOper", "flag1", "", "0X8004171", "0X8004171", 0, 0, "", "", "", "");
                    }
                    if (this.f94636t0 == 5) {
                        ReportController.o(this.app, "CliOper", "", "", "0X8006672", "0X8006672", 0, 0, "", "", "", "");
                    }
                    if (this.f94636t0 == 2) {
                        new com.tencent.mobileqq.statistics.q(this.app).i("P_CliOper").a("Grp_set").f("Grp_data").d("qr_save").b(this.f94618n0, "", String.valueOf(this.f94627q0)).g();
                    }
                }
            } else if (view.getId() == R.id.h1f) {
                J4();
                if (this.f94636t0 == 5) {
                    ReportController.o(this.app, "CliOper", "", "", "0X8006673", "0X8006673", 0, 0, "", "", "", "");
                }
            } else if (view.getId() != R.id.h1o && view.getId() != R.id.h1q) {
                if (view.getId() == R.id.f6510381) {
                    ReportController.o(this.app, "CliOper", "", "", "0X800AEAD", "0X800AEAD", 0, 0, "", "", "", "");
                    if (com.tencent.biz.qrcode.util.h.x(this.app, this.f94618n0) == 1) {
                        this.f94609k0 = this.f94632r2;
                    } else {
                        this.f94609k0 = I3();
                        QidCardManager.QidCardReport.reportQidQrCard("0X800B9A7");
                    }
                    F4();
                } else if (view.getId() == R.id.f6513384) {
                    D4();
                } else if (view.getId() == R.id.f654138v) {
                    l4();
                } else if (view.getId() == R.id.h1p) {
                    L3();
                } else if (view.getId() == R.id.f653638q) {
                    int i16 = this.f94614l2;
                    if (i16 == 0) {
                        w3();
                    } else if (i16 == 1) {
                        if (com.tencent.biz.qrcode.util.h.x(this.app, this.f94618n0) == 1) {
                            P4(2, true);
                            QidCardManager.QidCardReport.reportQidQrCard("0X800B96F");
                        } else {
                            P4(1, true);
                            QidCardManager.QidCardReport.reportQidQrCard("0X800B9AB");
                        }
                    }
                    i4();
                } else if (view.getId() == R.id.ivTitleBtnRightImage) {
                    ReportController.o(this.app, "CliOper", "", "", "0X800AEB5", "0X800AEB5", 0, 0, "", "", "", "");
                    if (com.tencent.biz.qrcode.util.h.x(this.app, this.f94618n0) != 2) {
                        z16 = false;
                    }
                    E4(z16);
                } else if (view.getId() == R.id.f650137s) {
                    if (QLog.isColorLevel()) {
                        QLog.d("QRDisplayActivity", 2, "onClick qr_code_white_bg isLoading =" + this.f94597g0);
                    }
                    if (!this.f94597g0) {
                        ReportController.o(this.app, "CliOper", "", "", "0X800AEB4", "0X800AEB4", 0, 0, "", "", "", "");
                        N4(com.tencent.biz.qrcode.util.h.s(this.app, this.f94610k1, this.f94619n1), true);
                    }
                } else if (view.getId() == R.id.f650037r) {
                    if (QLog.isColorLevel()) {
                        QLog.d("QRDisplayActivity", 2, "onClick qr_code_troop_white_bg isLoading =" + this.f94597g0);
                    }
                    if (!this.f94597g0) {
                        S4(com.tencent.biz.qrcode.util.h.s(this.app, this.f94610k1, this.f94619n1), true);
                    }
                } else if (view.getId() == R.id.f6517388) {
                    QLog.i("QRDisplayActivity", 1, "showSourceSelector()");
                    I4();
                    VideoReport.reportEvent("clck", view, null);
                } else if (view.getId() == R.id.f30510oj) {
                    QLog.i("QRDisplayActivity", 1, "go to edit");
                    this.U1.h(this);
                    VideoReport.reportEvent("clck", view, null);
                }
            } else {
                L3();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
        int i16;
        String str;
        int i17;
        EventCollector.getInstance().onItemClickBefore(adapterView, view, i3, j3);
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2 && i3 != 3) {
                    if (i3 == 4) {
                        DiscussionInfoCardActivity.v3(this.app, this.H0, this.f94621o0, this.f94612l0);
                    }
                } else {
                    if (!WXShareHelper.b0().e0()) {
                        i16 = R.string.f173257ih1;
                    } else if (!WXShareHelper.b0().f0()) {
                        i16 = R.string.f173258ih2;
                    } else {
                        i16 = -1;
                    }
                    if (i16 != -1) {
                        com.tencent.biz.qrcode.util.h.T(1, i16);
                    } else {
                        if (this.F0 == null) {
                            this.F0 = new g();
                            WXShareHelper.b0().A(this.F0);
                        }
                        QQAppInterface qQAppInterface = this.app;
                        if (i3 == 2) {
                            str = "1";
                        } else {
                            str = "0";
                        }
                        ReportController.o(qQAppInterface, "CliOper", "", "", "discuss", "share_discuss_to", 0, 0, str, "", "", "");
                        this.G0 = String.valueOf(System.currentTimeMillis());
                        String format = String.format(getString(R.string.asr), this.f94612l0);
                        if (this.f94636t0 == 11) {
                            format = getString(R.string.f171016iq3);
                        }
                        String str2 = format;
                        WXShareHelper b06 = WXShareHelper.b0();
                        String str3 = this.G0;
                        Bitmap bitmap = this.f94606j0;
                        String str4 = this.f94621o0;
                        if (i3 == 2) {
                            i17 = 0;
                        } else {
                            i17 = 1;
                        }
                        b06.L0(str3, str2, bitmap, "", str4, i17);
                    }
                }
            } else {
                DiscussionInfoCardActivity.x3(this.app, this, this.f94621o0, this.f94618n0, this.f94612l0);
            }
        } else {
            if (this.I0 == null) {
                QQProgressDialog qQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
                this.I0 = qQProgressDialog;
                qQProgressDialog.setMessage(R.string.cpr);
                this.I0.setBackAndSearchFilter(false);
            }
            DiscussionInfoCardActivity.w3(this.app, this, 2, this.f94624p0, this.f94618n0, this.f94612l0, this.L0, this.I0);
        }
        this.E0.dismiss();
        EventCollector.getInstance().onItemClick(adapterView, view, i3, j3);
    }

    public boolean p3() {
        int i3 = this.f94619n1;
        if (i3 >= 0 && i3 < this.f94610k1.f202590a.size()) {
            return true;
        }
        return false;
    }

    protected void p4(String str, String str2) {
        SharedPreferences.Editor edit = getSharedPreferences("qrcode", 0).edit();
        edit.putString("discussionnick_name" + str, str2);
        edit.commit();
    }

    protected void r4(String str, int i3, String str2) {
        String x36 = x3();
        if (x36 == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QRDisplayActivity", 2, "setPrefMatrix uin: " + str + " type: " + i3 + " data: " + str2);
        }
        SharedPreferences.Editor edit = getSharedPreferences("qrcode", 0).edit();
        edit.putString(x36, str2);
        edit.commit();
    }

    protected void showActionSheet() {
        if (this.f94599g2 == null) {
            ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(this, null);
            this.f94599g2 = actionSheet;
            actionSheet.addButton(R.string.f172951g23, 1);
            this.f94599g2.addButton(R.string.f172953g25, 1);
            this.f94599g2.addButton(R.string.f172950g22, 1);
            this.f94599g2.addCancelButton(R.string.cancel);
            this.f94599g2.setOnDismissListener(new a());
            this.f94599g2.setOnButtonClickListener(new b());
        }
        if (!this.f94599g2.isShowing()) {
            this.f94602h2 = false;
            this.f94599g2.show();
        }
    }

    void showToast(int i3, String str) {
        QQToast.makeText(this, i3, str, 0).show(getTitleBarHeight());
    }

    @Override // com.tencent.chirp.PcmPlayer.a
    public void u2(int i3) {
        if (QLog.isColorLevel() && i3 != 0) {
            QLog.d("QRDisplayActivity", 2, "onPlayStop, " + i3);
        }
        if (i3 != 0) {
            if (i3 == 1 || i3 == 2) {
                this.E1.sendEmptyMessage(1001);
                this.E1.sendEmptyMessageDelayed(1003, 500L);
                return;
            }
            return;
        }
        if (!this.E1.hasMessages(1001)) {
            this.E1.sendEmptyMessageDelayed(1002, 1000L);
        }
    }

    public String x3() {
        int i3 = this.f94636t0;
        if (i3 == 1) {
            return QCircleAlphaUserReporter.KEY_USER + this.f94618n0;
        }
        if (i3 == 2) {
            return VipFunCallConstants.KEY_GROUP + this.f94618n0;
        }
        if (i3 == 5) {
            return "discussion" + this.f94618n0;
        }
        if (i3 == 11) {
            return "groupqav" + this.f94618n0;
        }
        return null;
    }

    @Override // com.tencent.biz.qrcode.CustomAccessibilityDelegate.a
    public void z1() {
        if (QLog.isColorLevel()) {
            QLog.d("QRDisplayActivity", 2, "enter focus, " + this.app.isVideoChatting());
        }
    }

    public void z4() {
        this.f94583b1.setBackgroundResource(C3());
        Drawable drawable = getResources().getDrawable(R.drawable.a65);
        drawable.setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
        this.f94586c1.setBackgroundDrawable(null);
        this.f94586c1.setImageDrawable(drawable);
        this.leftView.setBackground(com.tencent.biz.qrcode.util.h.p(getResources(), R.drawable.qui_chevron_left_selector));
        this.centerView.setTextColor(-16777216);
        T3();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class w implements LongClickCopyAction.ICopyListener {
        w() {
        }

        @Override // com.tencent.mobileqq.profilecard.base.utils.LongClickCopyAction.ICopyListener
        public void onCopyContent(String str) {
            ReportController.o(QRDisplayActivity.this.app, "CliOper", "", "", "0X800AEB3", "0X800AEB3", 0, 0, "", "", "", "");
        }

        @Override // com.tencent.mobileqq.profilecard.base.utils.LongClickCopyAction.ICopyListener
        public void onShowCopyMenu() {
            ReportController.o(QRDisplayActivity.this.app, "CliOper", "", "", "0X800AEB1", "0X800AEB1", 0, 0, "", "", "", "");
        }

        @Override // com.tencent.mobileqq.profilecard.base.utils.LongClickCopyAction.ICopyListener
        public void onDismiss() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class m extends CountDownTimer {
        m(long j3, long j16) {
            super(j3, j16);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            QRDisplayActivity.this.G1 = true;
            if (QRDisplayActivity.this.F1 == null) {
                QRDisplayActivity.this.c4();
                if (QLog.isColorLevel()) {
                    QLog.d("QRDisplayActivity", 4, "enter longclick");
                    return;
                }
                return;
            }
            if (QRDisplayActivity.this.F1 != null) {
                QRDisplayActivity.this.d4();
                if (QLog.isColorLevel()) {
                    QLog.d("QRDisplayActivity", 4, "enter longclickstop");
                }
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j3) {
        }
    }

    @Override // com.tencent.chirp.PcmPlayer.a
    public void onPlayStart() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class r implements URLDrawable.URLDrawableListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ bb.a f94702d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f94703e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f94704f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f94705h;

        r(bb.a aVar, int i3, boolean z16, boolean z17) {
            this.f94702d = aVar;
            this.f94703e = i3;
            this.f94704f = z16;
            this.f94705h = z17;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
            QRDisplayActivity.this.Q3();
            if (QLog.isColorLevel()) {
                QLog.d("QRDisplayActivity", 2, "onLoadCanceled:" + this.f94702d.f202591a);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d("QRDisplayActivity", 2, "onLoadFialed: urlDrawable = " + uRLDrawable + " bkgURL = " + this.f94702d.f202591a);
            }
            if (uRLDrawable != null) {
                QRDisplayActivity.this.f94583b1.setBackgroundDrawable(uRLDrawable.getCurrDrawable());
            }
            QRDisplayActivity.this.Q3();
            QRDisplayActivity qRDisplayActivity = QRDisplayActivity.this;
            QQToast.makeText(qRDisplayActivity, qRDisplayActivity.getString(R.string.f17902389), 0).show();
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            QRDisplayActivity.this.x4(this.f94702d, this.f94703e, this.f94704f, this.f94705h);
            if (QLog.isColorLevel()) {
                QLog.d("QRDisplayActivity", 2, "onLoadSuccessed: urlDrawable = " + uRLDrawable + " bkgURL = " + this.f94702d.f202591a);
            }
            if (uRLDrawable != null) {
                QRDisplayActivity.this.f94583b1.setBackgroundDrawable(uRLDrawable.getCurrDrawable());
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class s implements URLDrawable.URLDrawableListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ bb.a f94707d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f94708e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f94709f;

        s(bb.a aVar, int i3, boolean z16) {
            this.f94707d = aVar;
            this.f94708e = i3;
            this.f94709f = z16;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
            QRDisplayActivity.this.Q3();
            if (QLog.isColorLevel()) {
                QLog.d("QRDisplayActivity", 2, "setTroopDrawableListener onLoadCanceled:" + this.f94707d.f202591a);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d("QRDisplayActivity", 2, "setTroopDrawableListener onLoadFialed: urlDrawable = " + uRLDrawable + " bkgURL = " + this.f94707d.f202591a);
            }
            if (uRLDrawable != null) {
                QRDisplayActivity.this.f94637t1.setBackgroundDrawable(uRLDrawable.getCurrDrawable());
            }
            QRDisplayActivity.this.Q3();
            QRDisplayActivity qRDisplayActivity = QRDisplayActivity.this;
            QQToast.makeText(qRDisplayActivity, qRDisplayActivity.getString(R.string.f17902389), 0).show();
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            QRDisplayActivity.this.v4(this.f94707d, this.f94708e, this.f94709f);
            if (QLog.isColorLevel()) {
                QLog.d("QRDisplayActivity", 2, "setTroopDrawableListener onLoadSuccessed: urlDrawable = " + uRLDrawable + " bkgURL = " + this.f94707d.f202591a);
            }
            if (uRLDrawable != null) {
                QRDisplayActivity.this.f94637t1.setBackgroundDrawable(uRLDrawable.getCurrDrawable());
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class u implements DialogInterface.OnClickListener {
        u() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class ab implements mqq.observer.BusinessObserver {
        public ab() {
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            if (i3 == 0) {
                if (z16) {
                    a(z16, bundle.getStringArrayList("nickname_list"), bundle.getStringArrayList("uin_list"));
                } else {
                    QRDisplayActivity.this.J3();
                }
            }
        }

        protected void a(boolean z16, List<String> list, List<String> list2) {
        }
    }
}
