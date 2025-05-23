package com.tencent.mobileqq.activity.richmedia;

import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.StatFs;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.view.PressDarkImageButton;
import com.tencent.image.URLImageView;
import com.tencent.maxvideo.common.GlobalInit;
import com.tencent.maxvideo.trim.TrimNative;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.richmedia.b;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.VideoFrameSelectBar;
import com.tencent.mobileqq.activity.richmedia.view.ExtendEditText;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.open.base.ToastUtil;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qzonehub.api.font.IFontManager;
import com.tencent.video.decode.ShortVideoSoLoad;
import com.tencent.widget.ActionSheet;
import common.config.service.QzoneConfig;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QUA;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneVideoCommonUtils;
import cooperation.qzone.RDMEtraMsgCollector;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.report.lp.LpReportInfoConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.PhotoUtils;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.SystemUtil;
import cooperation.qzone.video.QzoneVerticalVideoTopicInfo;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import cooperation.qzone.webviewplugin.ugcsetting.UgcSettingUtil;
import cooperation.qzone.widget.QzoneGuideBubbleHelper;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes10.dex */
public class EditLocalVideoActivity extends QQStoryBaseActivity implements View.OnClickListener, VideoFrameSelectBar.a {
    private static final String H1;
    private static final String I1;
    public static String J1;
    private static String K1;
    private static final boolean L1;
    private int A0;
    private QzoneVerticalVideoTopicInfo A1;
    private Bitmap B0;
    private View B1;
    private long C1;
    private String E0;
    private String F0;
    private String G0;
    private long H0;
    private long I0;
    private int J0;
    private int K0;
    private ViewStub L0;
    private FixedSizeVideoView M0;
    private RelativeLayout N0;
    private ViewGroup O0;
    private ImageView P0;
    private VideoFrameSelectBar Q0;
    private RelativeLayout R0;
    private TextView S0;
    private TextView T0;
    private TextView U0;
    private ImageView V0;
    private ProgressBar W0;
    private boolean X0;

    /* renamed from: a0, reason: collision with root package name */
    private ViewGroup f185732a0;

    /* renamed from: a1, reason: collision with root package name */
    private String f185733a1;

    /* renamed from: b0, reason: collision with root package name */
    private RelativeLayout f185734b0;

    /* renamed from: b1, reason: collision with root package name */
    private long f185735b1;

    /* renamed from: c0, reason: collision with root package name */
    private TextView f185736c0;

    /* renamed from: c1, reason: collision with root package name */
    private int f185737c1;

    /* renamed from: d0, reason: collision with root package name */
    private TextView f185738d0;

    /* renamed from: d1, reason: collision with root package name */
    private int f185739d1;

    /* renamed from: e0, reason: collision with root package name */
    private RelativeLayout f185740e0;

    /* renamed from: f0, reason: collision with root package name */
    private Button f185742f0;

    /* renamed from: g0, reason: collision with root package name */
    private ExtendEditText f185744g0;

    /* renamed from: h0, reason: collision with root package name */
    private View f185746h0;

    /* renamed from: h1, reason: collision with root package name */
    public String f185747h1;

    /* renamed from: i0, reason: collision with root package name */
    private RelativeLayout f185748i0;

    /* renamed from: i1, reason: collision with root package name */
    public String f185749i1;

    /* renamed from: j0, reason: collision with root package name */
    private Button f185750j0;

    /* renamed from: k0, reason: collision with root package name */
    private TextView f185752k0;

    /* renamed from: k1, reason: collision with root package name */
    private String f185753k1;

    /* renamed from: l0, reason: collision with root package name */
    boolean f185754l0;

    /* renamed from: l1, reason: collision with root package name */
    private boolean f185755l1;

    /* renamed from: o0, reason: collision with root package name */
    private PressDarkImageButton f185760o0;

    /* renamed from: p0, reason: collision with root package name */
    private boolean f185762p0;

    /* renamed from: p1, reason: collision with root package name */
    private String f185763p1;

    /* renamed from: q0, reason: collision with root package name */
    private com.tencent.mobileqq.activity.richmedia.b f185764q0;

    /* renamed from: r0, reason: collision with root package name */
    private View f185766r0;

    /* renamed from: r1, reason: collision with root package name */
    private String f185767r1;

    /* renamed from: s1, reason: collision with root package name */
    private ActionSheet f185769s1;

    /* renamed from: t0, reason: collision with root package name */
    private PressDarkImageButton f185770t0;

    /* renamed from: t1, reason: collision with root package name */
    private QQCustomDialog f185771t1;

    /* renamed from: u1, reason: collision with root package name */
    private String f185773u1;

    /* renamed from: v1, reason: collision with root package name */
    private String f185775v1;

    /* renamed from: y0, reason: collision with root package name */
    private int f185780y0;

    /* renamed from: z0, reason: collision with root package name */
    private int f185782z0;

    /* renamed from: z1, reason: collision with root package name */
    private boolean f185783z1;

    /* renamed from: m0, reason: collision with root package name */
    private boolean f185756m0 = false;

    /* renamed from: n0, reason: collision with root package name */
    private boolean f185758n0 = true;

    /* renamed from: s0, reason: collision with root package name */
    private boolean f185768s0 = false;

    /* renamed from: u0, reason: collision with root package name */
    private boolean f185772u0 = false;

    /* renamed from: v0, reason: collision with root package name */
    private boolean f185774v0 = false;

    /* renamed from: w0, reason: collision with root package name */
    private boolean f185776w0 = true;

    /* renamed from: x0, reason: collision with root package name */
    private int f185778x0 = 0;
    private int C0 = 0;
    private int D0 = 0;
    private boolean Y0 = false;
    private boolean Z0 = false;

    /* renamed from: e1, reason: collision with root package name */
    private int f185741e1 = 2;

    /* renamed from: f1, reason: collision with root package name */
    public int f185743f1 = 1;

    /* renamed from: g1, reason: collision with root package name */
    public ArrayList<String> f185745g1 = null;

    /* renamed from: j1, reason: collision with root package name */
    private String f185751j1 = "";

    /* renamed from: m1, reason: collision with root package name */
    private boolean f185757m1 = true;

    /* renamed from: n1, reason: collision with root package name */
    private int f185759n1 = -1;

    /* renamed from: o1, reason: collision with root package name */
    private int f185761o1 = -1;

    /* renamed from: q1, reason: collision with root package name */
    private int f185765q1 = -1;

    /* renamed from: w1, reason: collision with root package name */
    private qs.c f185777w1 = null;

    /* renamed from: x1, reason: collision with root package name */
    private int f185779x1 = 0;

    /* renamed from: y1, reason: collision with root package name */
    private boolean f185781y1 = false;
    public RMVideoStateMgr D1 = RMVideoStateMgr.u();
    private p E1 = new p(this);
    private StringBuilder F1 = new StringBuilder();
    private Formatter G1 = new Formatter(this.F1, Locale.getDefault());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            EditLocalVideoActivity.this.P3("608", "7", "2", true);
            EditLocalVideoActivity.this.v4("an_yuanshipin");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (EditLocalVideoActivity.this.M0.isPlaying()) {
                EditLocalVideoActivity.this.f185776w0 = false;
                EditLocalVideoActivity.this.M0.pause();
                EditLocalVideoActivity.this.V0.setVisibility(0);
            } else {
                EditLocalVideoActivity.this.f185776w0 = true;
                EditLocalVideoActivity.this.P0.setVisibility(8);
                EditLocalVideoActivity.this.M0.start();
                EditLocalVideoActivity.this.V0.setVisibility(4);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class d implements FixedSizeVideoView.c {
        d() {
        }

        @Override // com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView.c
        public void a(FixedSizeVideoView fixedSizeVideoView, int i3, int i16) {
            if (EditLocalVideoActivity.this.f185774v0) {
                QLog.e("EditLocalVideoActivity", 2, "onArriveTrimEnd() ---------------3   mStartTime=" + EditLocalVideoActivity.this.f185780y0 + " mEndTime=" + EditLocalVideoActivity.this.f185782z0 + "   mCurrentStartTime=" + EditLocalVideoActivity.this.f185778x0);
                fixedSizeVideoView.pause();
                fixedSizeVideoView.seekTo(EditLocalVideoActivity.this.f185778x0);
                EditLocalVideoActivity.this.f185776w0 = false;
                EditLocalVideoActivity.this.V0.setVisibility(0);
            } else {
                if (EditLocalVideoActivity.this.f185782z0 == 0) {
                    return;
                }
                QLog.e("EditLocalVideoActivity", 2, "onArriveTrimEnd() ---------------4   mStartTime=" + EditLocalVideoActivity.this.f185780y0 + " mEndTime=" + EditLocalVideoActivity.this.f185782z0 + "   mCurrentStartTime=" + EditLocalVideoActivity.this.f185778x0);
                fixedSizeVideoView.setPlayDuration(EditLocalVideoActivity.this.f185780y0, EditLocalVideoActivity.this.f185782z0 - EditLocalVideoActivity.this.f185780y0);
                fixedSizeVideoView.seekTo(EditLocalVideoActivity.this.f185780y0);
                fixedSizeVideoView.start();
            }
            if (EditLocalVideoActivity.this.f185764q0 != null) {
                EditLocalVideoActivity.this.f185764q0.t();
            }
        }

        @Override // com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView.c
        public void b(MediaPlayer mediaPlayer) {
            if (EditLocalVideoActivity.this.f185774v0) {
                QLog.e("EditLocalVideoActivity", 2, "onComplete() ---------------1   mStartTime=" + EditLocalVideoActivity.this.f185780y0 + " mEndTime=" + EditLocalVideoActivity.this.f185782z0 + "   mCurrentStartTime=" + EditLocalVideoActivity.this.f185778x0);
                EditLocalVideoActivity.this.M0.pause();
                mediaPlayer.seekTo(EditLocalVideoActivity.this.f185778x0);
                EditLocalVideoActivity.this.f185776w0 = false;
                EditLocalVideoActivity.this.V0.setVisibility(0);
                return;
            }
            QLog.e("EditLocalVideoActivity", 2, "onComplete() ---------------2   mStartTime=" + EditLocalVideoActivity.this.f185780y0 + " mEndTime=" + EditLocalVideoActivity.this.f185782z0 + "   mCurrentStartTime=" + EditLocalVideoActivity.this.f185778x0);
            mediaPlayer.seekTo(EditLocalVideoActivity.this.f185780y0);
            EditLocalVideoActivity.this.M0.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class e implements MediaPlayer.OnErrorListener {
        e() {
        }

        private String[] a() {
            String config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_VIDEOEDIT, QzoneConfig.SECONDARY_VIDEOEDIT_LOAD_VIDEO_FIALED_RETURN_CODE);
            if (config == null) {
                return null;
            }
            return config.split(",");
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i3, int i16) {
            QLog.e("EditLocalVideoActivity", 2, "VideoView onError, what:" + i3 + ", extra:" + i16);
            try {
                QQToast.makeText(EditLocalVideoActivity.this.getApplicationContext(), HardCodeUtil.qqStr(R.string.lvy), 1).show();
                String[] a16 = a();
                if (a16 == null) {
                    EditLocalVideoActivity.this.y4(QzoneVideoBeaconReport.EVENT_PLAY_LOCAL_VIDEO, QzoneVideoBeaconReport.KEY_PLAY_LOCAL_VIDEO_SUCCESS, "4", "what: " + i3 + ",   extra: " + i16 + ",   " + DeviceInfoMonitor.getModel());
                } else {
                    boolean z16 = true;
                    for (String str : a16) {
                        if (TextUtils.equals(str, i3 + "-" + i16)) {
                            z16 = false;
                        }
                    }
                    if (z16) {
                        EditLocalVideoActivity.this.y4(QzoneVideoBeaconReport.EVENT_PLAY_LOCAL_VIDEO, QzoneVideoBeaconReport.KEY_PLAY_LOCAL_VIDEO_SUCCESS, "4", "what: " + i3 + ",   extra: " + i16 + ",   " + DeviceInfoMonitor.getModel());
                    }
                }
                EditLocalVideoActivity.this.setResult(0);
                return true;
            } catch (Exception e16) {
                QLog.e("EditLocalVideoActivity", 2, "VideoView onError", e16);
                return true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class f implements MediaPlayer.OnPreparedListener {
        f() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (QLog.isColorLevel()) {
                QLog.d("EditLocalVideoActivity", 2, "onPrepared, duration:" + mediaPlayer.getDuration());
            }
            EditLocalVideoActivity.this.E1.removeMessages(9999);
            EditLocalVideoActivity.this.R3();
            EditLocalVideoActivity.this.f185764q0.G(EditLocalVideoActivity.this.I0, EditLocalVideoActivity.this.F0);
            EditLocalVideoActivity.this.f185764q0.H(EditLocalVideoActivity.this.f185780y0, EditLocalVideoActivity.this.f185782z0);
            EditLocalVideoActivity.this.f185764q0.w(mediaPlayer.getDuration());
            if (!EditLocalVideoActivity.this.Q0.j()) {
                EditLocalVideoActivity.this.A0 = mediaPlayer.getDuration();
                if ((cooperation.qzone.util.FileUtils.getFileSize(EditLocalVideoActivity.this.f185733a1) / EditLocalVideoActivity.this.M0.getDuration()) * 15000 > EditLocalVideoActivity.this.getFreeSpace(EditLocalVideoActivity.T3()) && QLog.isColorLevel()) {
                    QLog.d("EditLocalVideoActivity", 2, "prepared, there is not enough space on sdcard");
                }
                int videoWidth = mediaPlayer.getVideoWidth();
                int videoHeight = mediaPlayer.getVideoHeight();
                if (videoWidth > 0 && videoHeight > 0) {
                    EditLocalVideoActivity.this.f185737c1 = videoWidth;
                    EditLocalVideoActivity.this.f185739d1 = videoHeight;
                    EditLocalVideoActivity.this.d4(videoWidth, videoHeight);
                    return;
                }
                QQToast.makeText(EditLocalVideoActivity.this.getApplicationContext(), HardCodeUtil.qqStr(R.string.lvs), 1).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class g implements View.OnTouchListener {
        g() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (EditLocalVideoActivity.this.M0.isPlaying()) {
                if (EditLocalVideoActivity.this.f185774v0) {
                    EditLocalVideoActivity.this.f185776w0 = false;
                    EditLocalVideoActivity.this.M0.pause();
                    EditLocalVideoActivity.this.V0.setVisibility(0);
                }
            } else if (EditLocalVideoActivity.this.f185774v0) {
                EditLocalVideoActivity.this.M0.start();
                EditLocalVideoActivity.this.f185776w0 = true;
                EditLocalVideoActivity.this.V0.setVisibility(4);
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class h implements DialogInterface.OnClickListener {
        h() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            EditLocalVideoActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class i implements DialogInterface.OnClickListener {
        i() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            EditLocalVideoActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class j implements DialogInterface.OnClickListener {
        j() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            EditLocalVideoActivity.this.f185771t1.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class k implements DialogInterface.OnClickListener {
        k() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            int i16;
            if (EditLocalVideoActivity.this.f185781y1) {
                i16 = -1;
            } else {
                i16 = 0;
            }
            EditLocalVideoActivity.this.f185771t1.dismiss();
            EditLocalVideoActivity.this.s4(i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class l implements DialogInterface.OnDismissListener {
        l() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (EditLocalVideoActivity.this.f185732a0 != null) {
                EditLocalVideoActivity.this.f185732a0.setVisibility(0);
            }
            if (EditLocalVideoActivity.this.B1 != null) {
                EditLocalVideoActivity.this.B1.setVisibility(0);
            }
            if (EditLocalVideoActivity.this.f185740e0 != null && EditLocalVideoActivity.this.f185779x1 != 1) {
                EditLocalVideoActivity.this.F4(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class m implements DialogInterface.OnShowListener {
        m() {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            if (EditLocalVideoActivity.this.f185732a0 != null) {
                EditLocalVideoActivity.this.f185732a0.setVisibility(8);
            }
            if (EditLocalVideoActivity.this.B1 != null) {
                EditLocalVideoActivity.this.B1.setVisibility(8);
            }
            if (EditLocalVideoActivity.this.f185740e0 != null && EditLocalVideoActivity.this.f185779x1 != 1) {
                EditLocalVideoActivity.this.F4(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class n implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Bundle f185805d;

        n(Bundle bundle) {
            this.f185805d = bundle;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            RDMEtraMsgCollector.getInstance().addUserAction("[Actvity]" + getClass().getSimpleName() + " QQCustomDialog click :" + HardCodeUtil.qqStr(R.string.lwd));
            EditLocalVideoActivity.this.f185769s1.dismiss();
            EditLocalVideoActivity.this.w4(this.f185805d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class o implements ActionSheet.OnDismissListener {
        o() {
        }

        @Override // com.tencent.widget.ActionSheet.OnDismissListener
        public void onDismiss() {
            RDMEtraMsgCollector.getInstance().addUserAction("[Actvity]" + getClass().getSimpleName() + " QQCustomDialog click :" + HardCodeUtil.qqStr(R.string.j6l));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class p extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<EditLocalVideoActivity> f185808a;

        p(EditLocalVideoActivity editLocalVideoActivity) {
            this.f185808a = new WeakReference<>(editLocalVideoActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            WeakReference<EditLocalVideoActivity> weakReference = this.f185808a;
            if (weakReference != null && weakReference.get() != null) {
                EditLocalVideoActivity editLocalVideoActivity = this.f185808a.get();
                int i3 = message.what;
                if (i3 == 1001) {
                    editLocalVideoActivity.c4();
                    return;
                }
                if (i3 == 1009) {
                    editLocalVideoActivity.P4();
                    return;
                }
                if (i3 == 9999) {
                    editLocalVideoActivity.b4();
                    return;
                }
                if (i3 != 1006) {
                    if (i3 != 1007) {
                        switch (i3) {
                            case 1100:
                                if (editLocalVideoActivity.Q0 != null) {
                                    editLocalVideoActivity.Q0.requestLayout();
                                    return;
                                }
                                return;
                            case 1101:
                                QQToast.makeText(editLocalVideoActivity.getApplicationContext(), HardCodeUtil.qqStr(R.string.lw6), 1).show();
                                editLocalVideoActivity.t4();
                                return;
                            case 1102:
                                editLocalVideoActivity.a4(message);
                                return;
                            case 1103:
                                editLocalVideoActivity.X3();
                                return;
                            default:
                                return;
                        }
                    }
                    editLocalVideoActivity.P3("608", "3", "2", true);
                    return;
                }
                editLocalVideoActivity.P3("608", "3", "1", true);
                LpReportInfo_pf00064.allReport(LpReportInfoConfig.ACTION_VIDEO_EDITOR, 3, 4);
            }
        }
    }

    static {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("/tencent");
        String str = File.separator;
        sb5.append(str);
        sb5.append("video_edit_music_download");
        sb5.append(str);
        String sb6 = sb5.toString();
        H1 = sb6;
        String str2 = "/tencent" + str + "video_edit_music" + str;
        I1 = str2;
        StringBuilder sb7 = new StringBuilder();
        String str3 = com.tencent.mobileqq.activity.richmedia.g.f185853a;
        sb7.append(str3);
        sb7.append(sb6);
        J1 = sb7.toString();
        K1 = str3 + str2;
        L1 = true;
    }

    private void B4() {
        if (this.L0 == null) {
            ViewStub viewStub = (ViewStub) findViewById(R.id.gqk);
            this.L0 = viewStub;
            viewStub.inflate();
            try {
                GlobalInit.loadLibraryWithFullPath(ShortVideoSoLoad.getShortVideoSoPath(BaseApplication.getContext()) + VideoEnvironment.getShortVideoSoLibName());
            } catch (Throwable th5) {
                QLog.e("EditLocalVideoActivity", 2, "loadLibrary Exception", th5);
                y4(QzoneVideoBeaconReport.EVENT_PLAY_LOCAL_VIDEO, QzoneVideoBeaconReport.KEY_PLAY_LOCAL_VIDEO_SUCCESS, "2", DeviceInfoMonitor.getModel());
                QQToast.makeText(this, HardCodeUtil.qqStr(R.string.lwb), 0).show();
                finish();
            }
            if (!m71.a.b(this.C1)) {
                QQToast.makeText(this, HardCodeUtil.qqStr(R.string.lvt), 0).show();
                QLog.e("EditLocalVideoActivity", 2, "init trim failed");
                y4(QzoneVideoBeaconReport.EVENT_PLAY_LOCAL_VIDEO, QzoneVideoBeaconReport.KEY_PLAY_LOCAL_VIDEO_SUCCESS, "3", DeviceInfoMonitor.getModel());
                finish();
            }
            try {
                ActivityManager activityManager = (ActivityManager) getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                activityManager.getMemoryInfo(memoryInfo);
                int config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_TRIM, QzoneConfig.SECONDARY_MIN_AVAILABLE_RAM, QzoneConfig.DefaultValue.DEFAUL_VIDEO_TRIM_MIN_AVAIL_RAM);
                if (memoryInfo.availMem < config) {
                    QQToast.makeText(this, HardCodeUtil.qqStr(R.string.lwh), 0).show();
                }
                if (QLog.isColorLevel()) {
                    QLog.d("EditLocalVideoActivity", 2, "availMem=" + memoryInfo.availMem + ", threshold=" + memoryInfo.threshold + ", lowMem=" + memoryInfo.lowMemory + ", minRam=" + config);
                }
            } catch (Throwable th6) {
                QLog.w("EditLocalVideoActivity", 2, "", th6);
            }
            m71.a.a();
            this.N0 = (RelativeLayout) $(R.id.b8q);
            this.O0 = (ViewGroup) $(R.id.f167092kq3);
            this.P0 = (ImageView) $(R.id.bbd);
            this.Q0 = (VideoFrameSelectBar) $(R.id.kpp);
            this.M0 = (FixedSizeVideoView) $(R.id.kvb);
            this.V0 = (ImageView) $(R.id.kwn);
            RelativeLayout relativeLayout = (RelativeLayout) $(R.id.kpq);
            this.R0 = relativeLayout;
            relativeLayout.setVisibility(8);
            this.S0 = (TextView) $(R.id.kpr);
            this.T0 = (TextView) $(R.id.kpt);
            this.U0 = (TextView) $(R.id.kps);
            this.S0.setOnClickListener(this);
            this.U0.setOnClickListener(this);
        }
        if (this.J0 != 0 && this.K0 != 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) $lp(this.O0);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) $lp(this.M0);
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) $lp(this.P0);
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) $lp(this.V0);
            int i3 = this.J0;
            int i16 = this.K0;
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.F0);
                String extractMetadata = mediaMetadataRetriever.extractMetadata(24);
                QLog.e("EditLocalVideoActivity", 2, "rotation=" + extractMetadata + "  localVideoWidth=" + this.J0 + " localVideoHeight=" + this.K0);
                if (TextUtils.equals(extractMetadata, "90") || TextUtils.equals(extractMetadata, "270")) {
                    i3 = this.K0;
                    i16 = this.J0;
                }
                mediaMetadataRetriever.release();
            } catch (Throwable th7) {
                QLog.e("EditLocalVideoActivity", 1, "replay error", th7);
            }
            if (i3 / i16 >= 1.0f) {
                layoutParams4.height = -1;
            } else {
                layoutParams4.height = this.K0;
            }
            this.O0.setLayoutParams(layoutParams);
            this.M0.setLayoutParams(layoutParams2);
            this.P0.setLayoutParams(layoutParams3);
            this.V0.setLayoutParams(layoutParams4);
        }
        e4();
        h4();
        if (!TextUtils.isEmpty(this.F0)) {
            g4();
        }
        N4(0);
        this.M0.setVideoPath(this.F0);
        this.M0.seekTo(this.f185780y0);
        this.M0.start();
    }

    public static Bitmap C4(Bitmap bitmap, int i3, int i16, Matrix matrix, boolean z16) {
        try {
            return Bitmap.createBitmap(bitmap, 0, 0, i3, i16, matrix, true);
        } catch (OutOfMemoryError unused) {
            if (z16) {
                return C4(bitmap, i3, i16, matrix, false);
            }
            return null;
        }
    }

    private static Bitmap D4(BitmapFactory.Options options, String str) {
        int i3 = 0;
        while (true) {
            if (i3 > 0 && options.inSampleSize > 7) {
                return null;
            }
            try {
                return Q3(str, options);
            } catch (OutOfMemoryError unused) {
                options.inSampleSize++;
                i3++;
            }
        }
    }

    private Bitmap E4(BitmapFactory.Options options, String str, boolean z16) {
        try {
            return Q3(str, options);
        } catch (OutOfMemoryError unused) {
            if (z16) {
                return E4(options, str, false);
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F4(boolean z16) {
        int i3;
        int color;
        int i16;
        int i17;
        RelativeLayout relativeLayout = this.f185740e0;
        int i18 = 8;
        if (z16) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        relativeLayout.setVisibility(i3);
        RelativeLayout relativeLayout2 = this.f185740e0;
        if (z16) {
            color = 0;
        } else {
            color = getResources().getColor(R.color.a2n);
        }
        relativeLayout2.setBackgroundColor(color);
        ExtendEditText extendEditText = this.f185744g0;
        if (z16) {
            i16 = 8;
        } else {
            i16 = 0;
        }
        extendEditText.setVisibility(i16);
        Button button = this.f185742f0;
        if (!z16 && !this.f185755l1) {
            i17 = 0;
        } else {
            i17 = 8;
        }
        button.setVisibility(i17);
        View view = this.f185746h0;
        if (!z16) {
            i18 = 0;
        }
        view.setVisibility(i18);
    }

    private void G4() {
        int i3 = this.f185779x1;
        if (i3 == 0) {
            this.f185738d0.setText(R.string.cv5);
            this.f185736c0.setText(R.string.d7o);
            com.tencent.mobileqq.activity.richmedia.b bVar = this.f185764q0;
            if (bVar == null || !bVar.u()) {
                this.f185740e0.setVisibility(0);
                this.f185740e0.setBackgroundColor(getResources().getColor(R.color.a2n));
                com.tencent.mobileqq.shortvideo.util.g.a(this.f185740e0, 8.0f, 0.0f, 0.0f, 0.0f, 300, 0.0f, 1.0f);
            }
        } else if (i3 == 1) {
            this.f185738d0.setText(R.string.f170549u3);
            this.f185736c0.setText(R.string.f171151ok);
            this.f185740e0.setVisibility(8);
            this.f185740e0.setBackgroundColor(0);
        }
        this.f185738d0.setVisibility(0);
        this.f185736c0.setVisibility(0);
        com.tencent.mobileqq.shortvideo.util.g.a(this.f185736c0, 8.0f, 0.0f, 0.0f, 0.0f, 300, 0.0f, 1.0f);
        PressDarkImageButton pressDarkImageButton = this.f185770t0;
        if (pressDarkImageButton != null) {
            pressDarkImageButton.setVisibility(0);
        }
        PressDarkImageButton pressDarkImageButton2 = this.f185760o0;
        if (pressDarkImageButton2 != null) {
            pressDarkImageButton2.setVisibility(0);
        }
        com.tencent.mobileqq.shortvideo.util.g.a(this.f185770t0, 8.0f, 0.0f, 0.0f, 0.0f, 300, 0.0f, 1.0f);
        com.tencent.mobileqq.shortvideo.util.g.a(this.f185760o0, 8.0f, 0.0f, 0.0f, 0.0f, 300, 0.0f, 1.0f);
        O4(false);
        com.tencent.mobileqq.shortvideo.util.g.a(this.f185748i0, 8.0f, 0.0f, 0.0f, 0.0f, 300, 0.0f, 1.0f);
        if (!this.X0) {
            this.f185750j0.setBackgroundResource(R.drawable.ghw);
            this.f185754l0 = false;
        }
    }

    private void H4(String str, String str2) {
        if (str == null) {
            return;
        }
        try {
            Object newInstance = Class.forName(str).newInstance();
            if (newInstance instanceof qs.c) {
                qs.c cVar = (qs.c) newInstance;
                this.f185777w1 = cVar;
                cVar.setRefer(str2);
            }
        } catch (Throwable th5) {
            this.f185777w1 = null;
            if (QLog.isColorLevel()) {
                QLog.d("EditLocalVideoActivity", 2, "initComponentParamData:exp =" + th5);
            }
        }
    }

    private void I4() {
        this.f185764q0.G(this.I0, this.F0);
        this.f185764q0.H(this.f185780y0, this.f185782z0);
        this.f185764q0.y(new l());
        this.f185764q0.z(new m());
        this.f185764q0.D();
    }

    private void J4() {
        QZoneHelper.showQzoneVipOriginalVideoDialog(this, new b());
    }

    private void K3() {
        StringBuilder sb5 = new StringBuilder();
        String str = com.tencent.mobileqq.activity.richmedia.g.f185853a;
        sb5.append(str);
        sb5.append(H1);
        J1 = sb5.toString();
        K1 = str + I1;
        try {
            ArrayList<String> arrayList = new ArrayList();
            Collections.addAll(arrayList, J1, K1);
            for (String str2 : arrayList) {
                File file = new File(str2);
                if (!file.exists() && file.mkdirs()) {
                    QZLog.d("EditLocalVideoActivity", 2, "assertSdcardExit create directory ", str2);
                }
            }
        } catch (Exception e16) {
            QLog.d("EditLocalVideoActivity", 2, "assertSdcardExit exception", e16);
        }
        com.tencent.mobileqq.utils.FileUtils.createFileIfNotExits(K1 + ".nomedia");
    }

    private void L3() {
        com.tencent.mobileqq.activity.richmedia.b bVar = this.f185764q0;
        if (bVar != null && bVar.C()) {
            x4();
        } else {
            z4();
        }
    }

    private boolean M3(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M4(boolean z16) {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        this.f185774v0 = z16;
        VideoFrameSelectBar videoFrameSelectBar = this.Q0;
        int i26 = 8;
        int i27 = 0;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        videoFrameSelectBar.setVisibility(i3);
        RelativeLayout relativeLayout = this.R0;
        if (z16) {
            i16 = 0;
        } else {
            i16 = 8;
        }
        relativeLayout.setVisibility(i16);
        ImageView imageView = this.V0;
        if (z16) {
            i17 = 0;
        } else {
            i17 = 8;
        }
        imageView.setVisibility(i17);
        ImageView imageView2 = this.P0;
        if (z16) {
            i18 = 0;
        } else {
            i18 = 8;
        }
        imageView2.setVisibility(i18);
        ViewGroup viewGroup = this.f185732a0;
        if (z16) {
            i19 = 8;
        } else {
            i19 = 0;
        }
        viewGroup.setVisibility(i19);
        View view = this.B1;
        if (view != null) {
            if (!z16) {
                i26 = 0;
            }
            view.setVisibility(i26);
        }
        int i28 = this.f185779x1;
        if (i28 == 0) {
            F4(z16);
        } else if (i28 == 1) {
            F4(true);
        }
        TextView textView = this.f185738d0;
        if (textView != null) {
            if (z16) {
                i27 = 4;
            }
            textView.setVisibility(i27);
        }
    }

    private void N4(int i3) {
        FixedSizeVideoView fixedSizeVideoView = this.M0;
        if (fixedSizeVideoView != null) {
            fixedSizeVideoView.setVisibility(i3);
        }
        RelativeLayout relativeLayout = this.N0;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(i3);
        }
        ViewGroup viewGroup = this.O0;
        if (viewGroup != null) {
            viewGroup.setVisibility(i3);
        }
    }

    private void O4(boolean z16) {
        int i3;
        int i16;
        RelativeLayout relativeLayout = this.f185748i0;
        if (relativeLayout != null && this.f185750j0 != null && this.f185752k0 != null) {
            int i17 = 0;
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            relativeLayout.setVisibility(i3);
            Button button = this.f185750j0;
            if (z16) {
                i16 = 0;
            } else {
                i16 = 8;
            }
            button.setVisibility(i16);
            TextView textView = this.f185752k0;
            if (!z16) {
                i17 = 8;
            }
            textView.setVisibility(i17);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P4() {
        Typeface createFromFile;
        ExtendEditText extendEditText = this.f185744g0;
        if (extendEditText == null) {
            return;
        }
        extendEditText.setTextEffect(this.f185767r1);
        String trueTypeFont = ((IFontManager) QRoute.api(IFontManager.class)).getTrueTypeFont(this.f185759n1, null, null, true, null);
        if (TextUtils.isEmpty(trueTypeFont)) {
            this.f185759n1 = -1;
            createFromFile = null;
        } else {
            createFromFile = Typeface.createFromFile(trueTypeFont);
        }
        this.f185744g0.setTypeface(createFromFile);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x004e, code lost:
    
        if (r4 != null) goto L43;
     */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0053: MOVE (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]) (LINE:84), block:B:31:0x0053 */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0056 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Bitmap Q3(String str, BitmapFactory.Options options) {
        FileInputStream fileInputStream;
        InputStream inputStream;
        Bitmap decodeStream;
        InputStream inputStream2 = null;
        r3 = null;
        r3 = null;
        r3 = null;
        Bitmap bitmap = null;
        try {
            try {
                fileInputStream = new FileInputStream(str);
            } catch (FileNotFoundException e16) {
                e = e16;
                fileInputStream = null;
            } catch (OutOfMemoryError e17) {
                e = e17;
                fileInputStream = null;
            } catch (Throwable th5) {
                th = th5;
                if (inputStream2 != null) {
                }
                throw th;
            }
            try {
                if (options != null) {
                    try {
                    } catch (FileNotFoundException e18) {
                        e = e18;
                        if (QLog.isColorLevel()) {
                            QLog.e("EditLocalVideoActivity", 2, "", e);
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        return bitmap;
                    } catch (OutOfMemoryError e19) {
                        e = e19;
                        if (QLog.isColorLevel()) {
                            QLog.e("EditLocalVideoActivity", 2, "", e);
                        }
                    }
                    if (options.inJustDecodeBounds) {
                        decodeStream = BitmapFactory.decodeStream(new BufferedInputStream(fileInputStream, 2048), null, options);
                        bitmap = decodeStream;
                        fileInputStream.close();
                    }
                }
                fileInputStream.close();
            } catch (IOException unused) {
                return bitmap;
            }
            decodeStream = BitmapFactory.decodeStream(new BufferedInputStream(fileInputStream, 8192), null, options);
            bitmap = decodeStream;
        } catch (Throwable th6) {
            th = th6;
            inputStream2 = inputStream;
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R3() {
        if (this.f185764q0 == null) {
            this.f185764q0 = com.tencent.mobileqq.activity.richmedia.b.n(this, this.M0, this.A1, this.f185760o0);
        } else {
            QZLog.i("EditLocalVideoActivity", 2, "use old music mixer");
        }
    }

    public static String T3() {
        String str = null;
        try {
            File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
            if (externalStoragePublicDirectory != null && externalStoragePublicDirectory.exists()) {
                str = externalStoragePublicDirectory.getAbsolutePath() + "/Camera";
                File file = new File(str);
                if (!file.exists()) {
                    file.mkdir();
                }
            }
        } catch (Exception e16) {
            QLog.w("EditLocalVideoActivity", 2, "getCameraDirectoryPath error", e16);
        }
        return str;
    }

    private static String V3(int i3) {
        if (i3 != 1) {
            if (i3 != 4) {
                if (i3 != 16) {
                    if (i3 != 64) {
                        if (i3 != 128) {
                            return HardCodeUtil.qqStr(R.string.lwe);
                        }
                        return HardCodeUtil.qqStr(R.string.lvz);
                    }
                    return HardCodeUtil.qqStr(R.string.lwc);
                }
                return HardCodeUtil.qqStr(R.string.f171922lw2);
            }
            return HardCodeUtil.qqStr(R.string.lw8);
        }
        return HardCodeUtil.qqStr(R.string.lvr);
    }

    private void W3() {
        this.C1 = getAppRuntime().getLongAccountUin();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X3() {
        if (QLog.isColorLevel()) {
            QLog.d("EditLocalVideoActivity", 2, "handleMessage, MSG_ON_CONFIRM");
        }
        M4(false);
        if (this.M0.isPlaying()) {
            this.M0.pause();
        }
        FixedSizeVideoView fixedSizeVideoView = this.M0;
        int i3 = this.f185780y0;
        fixedSizeVideoView.setPlayDuration(i3, this.f185782z0 - i3);
        this.M0.start();
        this.f185772u0 = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a4(Message message) {
        if (this.P0 != null) {
            try {
                String str = (String) message.obj;
                int width = this.M0.getWidth();
                int height = this.M0.getHeight();
                if (QLog.isColorLevel()) {
                    QLog.d("EditLocalVideoActivity", 2, "VIDEO_SHOW_COVER, filename=" + str + ", w=" + width + ", h=" + height);
                }
                Bitmap S3 = S3(str, width, height, false);
                this.B0 = S3;
                if (S3 != null) {
                    ViewGroup.LayoutParams layoutParams = this.P0.getLayoutParams();
                    layoutParams.height = height;
                    layoutParams.width = width;
                    this.P0.setLayoutParams(layoutParams);
                    this.P0.setImageBitmap(this.B0);
                    if (this.f185774v0) {
                        this.P0.setVisibility(0);
                    }
                    this.C0 = width;
                    this.D0 = height;
                    this.E0 = str;
                }
            } catch (Throwable th5) {
                QLog.w("EditLocalVideoActivity", 2, "VIDEO_SHOW_COVER failed", th5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b4() {
        y4(QzoneVideoBeaconReport.EVENT_PLAY_LOCAL_VIDEO, QzoneVideoBeaconReport.KEY_PLAY_LOCAL_VIDEO_SUCCESS, "1", DeviceInfoMonitor.getModel());
        try {
            new AlertDialog.Builder(this).setMessage(HardCodeUtil.qqStr(R.string.lw7)).setNegativeButton(R.string.c7n, new i()).setCancelable(false).create().show();
        } catch (Exception e16) {
            QLog.e("EditLocalVideoActivity", 2, "LOAD_VIDEO_TIME_OUT showDialog error", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c4() {
        new AlertDialog.Builder(this).setMessage(HardCodeUtil.qqStr(R.string.lw9)).setNegativeButton(R.string.c7n, new h()).setCancelable(false).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d4(final int i3, final int i16) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).post(new Runnable() { // from class: com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity.18
            @Override // java.lang.Runnable
            public void run() {
                int i17;
                int i18;
                int i19;
                int i26;
                Bitmap a16;
                int d16;
                int i27 = EditLocalVideoActivity.this.getResources().getDisplayMetrics().widthPixels / 6;
                float f16 = (i3 * 1.0f) / i16;
                if (f16 <= 1.0f) {
                    int i28 = (int) (i27 / f16);
                    i26 = i28;
                    i19 = (i28 - i27) / 2;
                    i18 = 0;
                    i17 = i27;
                } else {
                    i17 = (int) (f16 * i27);
                    i18 = (i17 - i27) / 2;
                    i19 = 0;
                    i26 = i27;
                }
                if (TextUtils.isEmpty(EditLocalVideoActivity.this.f185733a1)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("EditLocalVideoActivity", 2, "initFramesBar, mTrimVideoPath is null");
                    }
                    EditLocalVideoActivity.this.E1.sendEmptyMessage(1001);
                    return;
                }
                if (!EditLocalVideoActivity.L1) {
                    int c16 = o71.b.c(EditLocalVideoActivity.this.f185733a1, i17, i26, i18, i19, i27, i27);
                    if (QLog.isColorLevel()) {
                        QLog.d("EditLocalVideoActivity", 2, "init, status1=" + c16 + ", dstWidth=" + i17 + ", dstHeight=" + i26);
                    }
                    if (c16 != 0) {
                        QzoneVideoBeaconReport.reportVideoEvent(String.valueOf(EditLocalVideoActivity.this.C1), QzoneVideoBeaconReport.EVENT_VIDEO_TRIM, "2", null);
                        EditLocalVideoActivity.this.E1.sendEmptyMessage(1001);
                        return;
                    }
                }
                EditLocalVideoActivity.this.Q0.i(EditLocalVideoActivity.this.A0, EditLocalVideoActivity.this.f185733a1);
                if (EditLocalVideoActivity.this.f185780y0 == 0) {
                    EditLocalVideoActivity editLocalVideoActivity = EditLocalVideoActivity.this;
                    editLocalVideoActivity.f185780y0 = (int) editLocalVideoActivity.Q0.f();
                }
                if (EditLocalVideoActivity.this.f185782z0 == 0) {
                    EditLocalVideoActivity editLocalVideoActivity2 = EditLocalVideoActivity.this;
                    editLocalVideoActivity2.f185782z0 = (int) editLocalVideoActivity2.Q0.g();
                }
                if (QLog.isColorLevel()) {
                    QLog.d("EditLocalVideoActivity", 2, "mStartTime=" + EditLocalVideoActivity.this.f185780y0 + ", mEndTime=" + EditLocalVideoActivity.this.f185782z0);
                }
                EditLocalVideoActivity.this.M0.setPlayDuration(EditLocalVideoActivity.this.f185780y0, EditLocalVideoActivity.this.f185782z0 - EditLocalVideoActivity.this.f185780y0);
                EditLocalVideoActivity.this.E1.sendEmptyMessage(1100);
                if (!EditLocalVideoActivity.L1) {
                    if (TextUtils.isEmpty(EditLocalVideoActivity.this.f185733a1)) {
                        d16 = -999;
                    } else {
                        d16 = o71.b.d(EditLocalVideoActivity.this.f185733a1, i3, i16);
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("EditLocalVideoActivity", 2, "init, status0=" + d16);
                    }
                    if (d16 != 0) {
                        QzoneVideoBeaconReport.reportVideoEvent(String.valueOf(EditLocalVideoActivity.this.C1), QzoneVideoBeaconReport.EVENT_VIDEO_TRIM, "3", null);
                        EditLocalVideoActivity.this.E1.sendEmptyMessage(1000);
                        return;
                    }
                }
                try {
                    if (EditLocalVideoActivity.L1) {
                        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                        mediaMetadataRetriever.setDataSource(EditLocalVideoActivity.this.f185733a1);
                        a16 = mediaMetadataRetriever.getFrameAtTime(EditLocalVideoActivity.this.f185780y0 * 1000, 3);
                        mediaMetadataRetriever.release();
                    } else {
                        a16 = o71.b.a(0L, 1000L);
                    }
                    if (a16 != null) {
                        String str = m71.a.f416374b + File.separator + System.currentTimeMillis() + ".jpg";
                        if (PhotoUtils.saveBitmapToFile(a16, str, Bitmap.CompressFormat.JPEG, 90, true)) {
                            EditLocalVideoActivity.this.E1.obtainMessage(1102, str).sendToTarget();
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    private void e4() {
        this.V0.setOnClickListener(new c());
        VideoFrameSelectBar videoFrameSelectBar = this.Q0;
        if (videoFrameSelectBar != null) {
            videoFrameSelectBar.setOnFramesClipChangeListener(this);
        }
    }

    private void f4() {
        if (this.A1 != null) {
            View $ = $(R.id.f167004ju3);
            this.B1 = $;
            $.setVisibility(0);
            ((TextView) $(R.id.kbk)).setText(this.A1.getDescName());
            URLImageView uRLImageView = (URLImageView) $(R.id.dwp);
            if (!TextUtils.isEmpty(this.A1.getThumbImgUrl())) {
                uRLImageView.setBackgroundURL(this.A1.getThumbImgUrl());
            } else {
                uRLImageView.setVisibility(8);
            }
        }
    }

    private void g4() {
        this.E1.removeMessages(9999);
        this.P0.setImageBitmap(null);
        this.P0.setVisibility(8);
        this.f185733a1 = this.F0;
        this.f185735b1 = this.H0;
        long j3 = this.I0;
        if (QLog.isColorLevel()) {
            QLog.d("EditLocalVideoActivity", 2, "initData, videoPath=" + this.f185733a1 + ", videoSize=" + this.f185735b1 + ", duration:" + j3);
        }
        this.f185741e1 = 2;
        if (!TextUtils.isEmpty(this.f185733a1)) {
            int a16 = o71.a.a(this.f185733a1);
            if (a16 != 0) {
                if (QLog.isColorLevel()) {
                    QLog.d("EditLocalVideoActivity", 2, "format is not supported ret=" + a16);
                }
                QzoneVideoBeaconReport.reportVideoEvent(String.valueOf(this.C1), QzoneVideoBeaconReport.EVENT_VIDEO_TRIM, "10", null);
                this.f185733a1 = null;
                this.E1.sendEmptyMessage(1101);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("EditLocalVideoActivity", 2, "setVideoPath:" + this.f185733a1);
            }
            this.M0.setVideoPath(this.f185733a1);
            this.E1.sendEmptyMessageDelayed(9999, 10000L);
            return;
        }
        setResult(0);
        finish();
    }

    private void h4() {
        this.M0.setOnFixVDPlayCompelteListener(new d());
        this.M0.setOnErrorListener(new e());
        this.M0.setOnPreparedListener(new f());
        this.M0.setOnTouchListener(new g());
    }

    private boolean i4() {
        if (!CacheManager.isExternalAvailable()) {
            if (QLog.isColorLevel()) {
                QLog.i("EditLocalVideoActivity", 2, "isEnoughStorage() sdcard not mounted");
            }
            QzoneVideoBeaconReport.reportVideoEvent(String.valueOf(this.C1), QzoneVideoBeaconReport.EVENT_VIDEO_TRIM, "6", null);
        }
        long fileSize = cooperation.qzone.util.FileUtils.getFileSize(this.f185733a1);
        if (fileSize <= 0) {
            if (QLog.isColorLevel()) {
                QLog.d("EditLocalVideoActivity", 2, "no file size");
            }
            QzoneVideoBeaconReport.reportVideoEvent(String.valueOf(this.C1), QzoneVideoBeaconReport.EVENT_VIDEO_TRIM, "7", null);
            return false;
        }
        if ((fileSize / this.M0.getDuration()) * (this.f185782z0 - this.f185780y0) > CacheManager.getSDCardRemain()) {
            if (QLog.isColorLevel()) {
                QLog.d("EditLocalVideoActivity", 2, "there is not enough space on sdcard");
            }
            QzoneVideoBeaconReport.reportVideoEvent(String.valueOf(this.C1), QzoneVideoBeaconReport.EVENT_VIDEO_TRIM, "8", null);
            return false;
        }
        return true;
    }

    private void initData() {
        W3();
        Intent intent = getIntent();
        this.f185779x1 = intent.getIntExtra(PeakConstants.EDIT_LOCAL_VIDEO_ENTRY, 0);
        String stringExtra = intent.getStringExtra("file_send_path");
        this.F0 = stringExtra;
        if (!TextUtils.isEmpty(stringExtra)) {
            if (!new File(this.F0).exists()) {
                QLog.e("EditLocalVideoActivity", 2, "localVideoPath not exists : " + this.F0);
                ToastUtil.a().e(HardCodeUtil.qqStr(R.string.lwa));
                finish();
                return;
            }
            this.G0 = this.F0;
            this.H0 = intent.getLongExtra(PeakConstants.VIDEO_SIZE, 0L);
            this.I0 = intent.getLongExtra(ShortVideoConstants.FILE_SEND_DURATION, 0L);
            this.J0 = intent.getIntExtra(ShortVideoConstants.FILE_WIDTH, 0);
            this.K0 = intent.getIntExtra(ShortVideoConstants.FILE_HEIGHT, 0);
            QLog.i("EditLocalVideoActivity", 2, "localVideoWidth: " + this.J0 + " ,    localVideoHeight: " + this.K0);
            this.X0 = intent.getBooleanExtra("is_qzone_vip", false);
            String stringExtra2 = intent.getStringExtra("topic_id");
            this.f185753k1 = stringExtra2;
            this.f185755l1 = TextUtils.isEmpty(stringExtra2) ^ true;
            this.f185757m1 = intent.getBooleanExtra(RemoteHandleConst.VIDEO_PARAM_TOPIC_SYNC_QZONE, this.f185757m1);
            this.f185759n1 = intent.getIntExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_ID, -1);
            this.f185761o1 = intent.getIntExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_FORMAT_TYPE, -1);
            this.f185763p1 = intent.getStringExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_URL);
            this.f185765q1 = intent.getIntExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_SUPER_FONT_ID, -1);
            this.f185767r1 = intent.getStringExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_SUPER_FONT_INFO);
            this.E1.sendEmptyMessage(1009);
            this.f185773u1 = intent.getStringExtra("short_video_refer");
            String stringExtra3 = intent.getStringExtra("set_user_callback");
            this.f185775v1 = stringExtra3;
            H4(stringExtra3, this.f185773u1);
            this.f185780y0 = (int) intent.getLongExtra(PeakConstants.EDIT_LOCAL_VIDEO_START_TIME, 0L);
            this.f185782z0 = (int) intent.getLongExtra(PeakConstants.EDIT_LOCAL_VIDEO_END_TIME, 0L);
            this.A0 = (int) intent.getLongExtra(PeakConstants.EDIT_LOCAL_VIDEO_DURATION, 0L);
            int i3 = this.f185780y0;
            if (i3 != 0) {
                this.f185778x0 = i3;
            }
            this.A1 = (QzoneVerticalVideoTopicInfo) intent.getParcelableExtra(PeakConstants.KEY_QZONE_TOPIC);
            return;
        }
        QLog.e("EditLocalVideoActivity", 2, "localVideoPath is null : " + this.F0);
        ToastUtil.a().e(HardCodeUtil.qqStr(R.string.lw5));
        finish();
    }

    public static boolean k4(int i3) {
        if (i3 != 16 && i3 != 128) {
            return false;
        }
        return true;
    }

    private boolean l4() {
        return QZoneVideoCommonUtils.REFER_SHORT_VIDEO_FOR_VIDEO_COVER.equals(this.f185773u1);
    }

    private void m4() {
        View findViewById;
        int notchHeight = SystemUtil.getNotchHeight(this, this);
        if (notchHeight > 0 && (findViewById = findViewById(R.id.gql)) != null && (findViewById.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) findViewById.getLayoutParams()).height += notchHeight;
        }
    }

    private void n4() {
        G4();
        if (this.I0 > QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_SHORT_VIDEO_DURATION_THRESHOLD, 90000)) {
            this.f185756m0 = false;
            PressDarkImageButton pressDarkImageButton = this.f185770t0;
            if (pressDarkImageButton != null) {
                pressDarkImageButton.getDrawable().setColorFilter(-7829368, PorterDuff.Mode.MULTIPLY);
            }
        } else {
            this.f185756m0 = true;
            PressDarkImageButton pressDarkImageButton2 = this.f185770t0;
            if (pressDarkImageButton2 != null) {
                pressDarkImageButton2.getDrawable().clearColorFilter();
            }
        }
        long config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_VIDEOEDIT, QzoneConfig.SECONDARY_SUPPORT_MIX_MUSIC_MAX_SIZE, QZoneHelper.Constants.SUPPORT_MIX_MUSIC_DEFAULT);
        if (this.H0 <= 0) {
            this.H0 = new File(this.F0).length();
        }
        if (this.H0 > config) {
            this.f185758n0 = false;
            PressDarkImageButton pressDarkImageButton3 = this.f185760o0;
            if (pressDarkImageButton3 != null) {
                pressDarkImageButton3.getDrawable().setColorFilter(-7829368, PorterDuff.Mode.MULTIPLY);
            }
        } else {
            this.f185758n0 = true;
            PressDarkImageButton pressDarkImageButton4 = this.f185760o0;
            if (pressDarkImageButton4 != null) {
                pressDarkImageButton4.getDrawable().clearColorFilter();
            }
        }
        if (this.f185779x1 == 0) {
            O4(true);
        }
        if (!TextUtils.isEmpty(this.F0)) {
            B4();
        } else {
            QLog.e("EditLocalVideoActivity", 2, " localVideoPath is empty ");
        }
    }

    private void o4() {
        if (this.f185774v0) {
            this.S0.performClick();
            return;
        }
        if (this.f185771t1 == null) {
            this.f185771t1 = DialogUtil.createCustomDialog(this, 230, HardCodeUtil.qqStr(R.string.f171923lw3), (CharSequence) null, getString(R.string.bjz), getString(R.string.cancel), new j(), new k());
        }
        this.f185771t1.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0107  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void p4() {
        boolean z16;
        String str;
        int i3;
        Bitmap bitmap;
        Bitmap a16;
        int f16 = (int) this.Q0.f();
        int g16 = (int) this.Q0.g();
        if (!i4()) {
            QQToast.makeText(BaseApplication.getContext(), HardCodeUtil.qqStr(R.string.f171920lw0), 1).show();
            return;
        }
        this.Z0 = true;
        if (QLog.isColorLevel()) {
            QLog.d("EditLocalVideoActivity", 2, "toPublishMood, startTime=" + f16 + ", endTime=" + g16 + ", duration=" + (g16 - f16));
        }
        String str2 = "";
        int i16 = 0;
        if (L1) {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(this.f185733a1);
            a16 = mediaMetadataRetriever.getFrameAtTime(f16 * 1000);
            mediaMetadataRetriever.release();
        } else {
            if (o71.b.d(this.f185733a1, this.f185737c1, this.f185739d1) == 0) {
                z16 = TrimNative.isGetFrameReady();
            } else {
                z16 = false;
            }
            if (z16) {
                a16 = o71.b.a(f16, f16 + 1000);
            } else {
                QLog.w("EditLocalVideoActivity", 2, "TrimNative.isGetFrameReady return false,thumbnail pic is null.");
                if (!l4()) {
                    str = "";
                    i3 = 0;
                    bitmap = null;
                } else {
                    if (f16 > 1000) {
                        str = "";
                    } else {
                        str = this.E0;
                    }
                    bitmap = null;
                    i3 = this.C0;
                    i16 = this.D0;
                }
                if (bitmap == null) {
                    str = m71.a.f416374b + File.separator + System.currentTimeMillis() + ".jpg";
                    if (PhotoUtils.saveBitmapToFile(bitmap, str, Bitmap.CompressFormat.JPEG, 90, true)) {
                        i3 = bitmap.getWidth();
                        i16 = bitmap.getHeight();
                    } else {
                        QLog.e("EditLocalVideoActivity", 2, "save jpg failed");
                        QzoneVideoBeaconReport.reportVideoEvent(String.valueOf(this.C1), QzoneVideoBeaconReport.EVENT_VIDEO_TRIM, "4", null);
                        m71.a.c();
                        this.f185780y0 = f16;
                        this.f185782z0 = g16;
                        this.E0 = str2;
                        this.D0 = i16;
                        this.C0 = i3;
                        this.E1.sendEmptyMessage(1103);
                    }
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d("EditLocalVideoActivity", 2, "getFrame failed");
                    }
                    QzoneVideoBeaconReport.reportVideoEvent(String.valueOf(this.C1), QzoneVideoBeaconReport.EVENT_VIDEO_TRIM, "5", null);
                }
                str2 = str;
                m71.a.c();
                this.f185780y0 = f16;
                this.f185782z0 = g16;
                this.E0 = str2;
                this.D0 = i16;
                this.C0 = i3;
                this.E1.sendEmptyMessage(1103);
            }
        }
        str = "";
        bitmap = a16;
        i3 = 0;
        if (bitmap == null) {
        }
        str2 = str;
        m71.a.c();
        this.f185780y0 = f16;
        this.f185782z0 = g16;
        this.E0 = str2;
        this.D0 = i16;
        this.C0 = i3;
        this.E1.sendEmptyMessage(1103);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s4(int i3) {
        ProgressBar progressBar = this.W0;
        if (progressBar != null) {
            progressBar.setProgress(0);
            this.W0.setVisibility(8);
        }
        P3("608", "2", "0", true);
        this.f185780y0 = 0;
        this.f185782z0 = 0;
        this.f185778x0 = 0;
        FixedSizeVideoView fixedSizeVideoView = this.M0;
        if (fixedSizeVideoView != null) {
            fixedSizeVideoView.stopPlayback();
        }
        VideoFrameSelectBar videoFrameSelectBar = this.Q0;
        if (videoFrameSelectBar != null) {
            videoFrameSelectBar.d();
        }
        Bitmap bitmap = this.B0;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.B0.recycle();
        }
        N4(8);
        setResult(i3);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t4() {
        VideoFrameSelectBar videoFrameSelectBar = this.Q0;
        if (videoFrameSelectBar != null) {
            videoFrameSelectBar.n();
        }
        this.E1.removeMessages(9999);
    }

    private void u4() {
        if (!this.Q0.h()) {
            this.M0.seekTo(this.f185780y0);
            this.M0.start();
            M4(false);
            this.f185772u0 = false;
            return;
        }
        final ActionSheet create = ActionSheet.create(this);
        create.setMainTitle(HardCodeUtil.qqStr(R.string.lvw));
        create.addButton(R.string.bjz, 3);
        create.addCancelButton(R.string.cancel);
        create.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity.12
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public void onClick(View view, int i3) {
                if (i3 == 0) {
                    EditLocalVideoActivity.this.P3("608", "4", "2", true);
                    EditLocalVideoActivity.this.f185778x0 = 0;
                    EditLocalVideoActivity.this.f185780y0 = 0;
                    EditLocalVideoActivity editLocalVideoActivity = EditLocalVideoActivity.this;
                    editLocalVideoActivity.f185782z0 = editLocalVideoActivity.A0;
                    EditLocalVideoActivity.this.M0.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity.12.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (EditLocalVideoActivity.this.M0 != null) {
                                EditLocalVideoActivity.this.M0.seekTo(0);
                                EditLocalVideoActivity.this.M0.start();
                            }
                        }
                    }, 300L);
                    EditLocalVideoActivity.this.M4(false);
                    EditLocalVideoActivity.this.f185772u0 = false;
                }
                create.superDismiss();
            }
        });
        create.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v4(String str) {
        QZoneHelper.forwardOpenQzoneVip2(this, QZoneHelper.UserInfo.getInstance(), str, this.C1, "", 1010, getResources().getString(R.string.gln), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w4(Bundle bundle) {
        qs.c cVar = this.f185777w1;
        if (cVar != null && QZoneVideoCommonUtils.REFER_UPLOAD_VIDEO_FOR_H5.equals(cVar.getRefer())) {
            Intent intent = new Intent(PeakConstants.ACTION_H5_VIDEO_RECORD_CALLBACK);
            intent.putExtras(bundle);
            BaseApplication.getContext().sendBroadcast(intent);
        } else {
            int i3 = this.f185779x1;
            if (i3 == 0) {
                RemoteHandleManager.getInstance().sendData(RemoteHandleConst.CMD_PUBLISH_VIDEO_MOOD, bundle, false);
            } else if (i3 == 1) {
                Intent intent2 = new Intent(getIntent());
                intent2.putExtras(bundle);
                String stringExtra = intent2.getStringExtra("PhotoConst.PLUGIN_APK");
                boolean booleanExtra = intent2.getBooleanExtra(PeakConstants.DIRECT_BACK_TO_QZONE, false);
                if ("qzone_plugin.apk".equals(stringExtra) && booleanExtra) {
                    intent2.setFlags(603979776);
                    QZoneHelper.launchQZone(this, "", intent2, -1);
                }
            }
        }
        if (this.f185779x1 == 0) {
            setResult(-1);
        }
        finish();
    }

    private void x4() {
        this.f185764q0.v(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y4(String str, String str2, String str3, String str4) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(str2, str3);
        hashMap.put("reserve", str4);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(String.valueOf(this.C1), str, true, 0L, 0L, hashMap, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z4() {
        int i3;
        String str;
        if (!M3(this.F0)) {
            ToastUtil.a().e("\u89c6\u9891\u6587\u4ef6\u4e0d\u5b58\u5728");
            return;
        }
        LpReportInfo_pf00064.allReport(LpReportInfoConfig.ACTION_VIDEO_EDITOR, 2);
        if (this.Y0) {
            if (this.f185772u0) {
                this.Z0 = true;
            } else {
                this.Z0 = false;
            }
        } else {
            long config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_SHORT_VIDEO_DURATION_THRESHOLD, 90000);
            if (this.f185772u0) {
                this.Z0 = true;
            } else if (this.I0 > config) {
                this.Z0 = false;
            } else {
                this.Z0 = true;
            }
        }
        Bundle bundle = new Bundle();
        bundle.putString("param.content", this.f185751j1);
        bundle.putInt("param.priv", this.f185743f1);
        bundle.putStringArrayList("param.privList", this.f185745g1);
        bundle.putInt(PeakConstants.EDIT_LOCAL_VIDEO_ENTRY, this.f185779x1);
        bundle.putString("file_send_path", this.G0);
        bundle.putString(RemoteHandleConst.VIDEO_PARAM_VIDEOPATH, this.F0);
        bundle.putLong(RemoteHandleConst.VIDEO_PARAM_VIDEOSIZE, this.H0);
        bundle.putInt(RemoteHandleConst.VIDEO_PARAM_VIDEOTYPE, 1);
        bundle.putString(RemoteHandleConst.VIDEO_PARAM_THUMBNAILPATH, this.E0);
        bundle.putInt(RemoteHandleConst.VIDEO_PARAM_THUMBNAILHEIGHT, this.D0);
        bundle.putInt(RemoteHandleConst.VIDEO_PARAM_THUMBNAILWIDTH, this.C0);
        bundle.putLong(RemoteHandleConst.VIDEO_PARAM_STARTTIME, this.f185780y0);
        bundle.putLong("param.duration", this.f185782z0 - this.f185780y0);
        bundle.putLong(RemoteHandleConst.VIDEO_PARAM_TOTALDURATION, this.I0);
        bundle.putBoolean(RemoteHandleConst.VIDEO_PARAM_NEEDPROCESS, this.Z0);
        bundle.putBoolean(RemoteHandleConst.VIDEO_PARAM_ISUPLOADORIGIN, this.Y0);
        bundle.putString(RemoteHandleConst.VIDEO_PARAM_TOPIC_ID, this.f185753k1);
        bundle.putBoolean(RemoteHandleConst.VIDEO_PARAM_TOPIC_SYNC_QZONE, this.f185757m1);
        bundle.putBoolean(RemoteHandleConst.PARAM_IS_SYNC_VIDEO_TO_QQSTORY, this.f185783z1);
        bundle.putParcelable(RemoteHandleConst.PARAM_QZONE_TOPIC, this.A1);
        int i16 = this.f185759n1;
        if (i16 >= 0) {
            bundle.putInt(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_ID, i16);
            bundle.putInt(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_FORMAT_TYPE, this.f185761o1);
            bundle.putString(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_URL, this.f185763p1);
        }
        int i17 = this.f185765q1;
        if (i17 >= 0) {
            bundle.putInt(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_SUPER_FONT_ID, i17);
            bundle.putString(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_SUPER_FONT_INFO, this.f185767r1);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putInt(ShortVideoConstants.SV_ENCODE_MAX_BITRATE, CodecParam.mMaxrate);
        bundle2.putInt(ShortVideoConstants.SV_ENCODE_MIN_BITRATE, CodecParam.mMinrate);
        bundle2.putInt(ShortVideoConstants.SV_ENCODE_QMAX, CodecParam.mQmax);
        bundle2.putInt(ShortVideoConstants.SV_ENCODE_QMIN, CodecParam.mQmin);
        bundle2.putInt(ShortVideoConstants.SV_ENCODE_QMAXDIFF, CodecParam.mMaxQdiff);
        bundle2.putInt(ShortVideoConstants.SV_ENCODE_REF_FRAME, CodecParam.mRefframe);
        bundle2.putInt(ShortVideoConstants.SV_ENCODE_SMOOTH, CodecParam.mIsSmooth);
        RMVideoStateMgr rMVideoStateMgr = this.D1;
        if (rMVideoStateMgr != null) {
            PreviewContext previewContext = rMVideoStateMgr.I;
            if (previewContext != null) {
                bundle2.putInt(ShortVideoConstants.SV_TOTAL_FRAME_COUNT, previewContext.getFrameIndex());
            }
            bundle2.putInt(ShortVideoConstants.SV_TOTAL_RECORD_TIME, (int) this.D1.H);
        }
        QzoneVerticalVideoTopicInfo qzoneVerticalVideoTopicInfo = this.A1;
        if (qzoneVerticalVideoTopicInfo != null) {
            if (qzoneVerticalVideoTopicInfo.hasMusic()) {
                i3 = 213;
            } else {
                i3 = 214;
            }
        } else {
            i3 = 201;
        }
        bundle2.putInt("param.uploadEntrance", i3);
        bundle.putBundle(RemoteHandleConst.VIDEO_PARAM_EXTRAS, bundle2);
        if (this.f185779x1 == 1 && !this.f185772u0 && (str = this.G0) != null && str.equals(this.F0)) {
            bundle.putBoolean(PeakConstants.EDIT_LOCAL_VIDEO_DONOTHING_RETURN, true);
        } else {
            P3("608", "1", "0", true);
        }
        long config2 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_VIDEOEDIT, QzoneConfig.SECONDARY_VIDEOEDIT_UPLOAD_MAX_SIZE_TIP_WITH_NO_WIFI, QZoneHelper.Constants.NO_WIFI_UPLOAD_VIDEO_MAX_SIZE_DEFAULT);
        if (NetworkUtil.getNetworkType(BaseApplication.getContext()) != 1 && this.H0 > config2) {
            ActionSheet actionSheet = this.f185769s1;
            if (actionSheet == null) {
                String str2 = HardCodeUtil.qqStr(R.string.f171924lw4) + ((config2 / 1024) / 1024) + HardCodeUtil.qqStr(R.string.lw_);
                ActionSheet create = ActionSheet.create(this);
                this.f185769s1 = create;
                create.setMainTitle(str2);
                this.f185769s1.addButton("\u7acb\u5373\u4e0a\u4f20", 0);
                this.f185769s1.addCancelButton(R.string.cancel);
                this.f185769s1.setOnButtonClickListener(new n(bundle));
                this.f185769s1.setOnDismissListener(new o());
                this.f185769s1.show();
                return;
            }
            if (!actionSheet.isShowing()) {
                this.f185769s1.show();
                return;
            }
            return;
        }
        w4(bundle);
    }

    public String L4(int i3) {
        int i16 = i3 / 1000;
        int i17 = i16 % 60;
        int i18 = (i16 / 60) % 60;
        int i19 = i16 / 3600;
        this.F1.setLength(0);
        if (i19 > 0) {
            return this.G1.format("%d:%02d:%02d", Integer.valueOf(i19), Integer.valueOf(i18), Integer.valueOf(i17)).toString();
        }
        return this.G1.format("%02d:%02d", Integer.valueOf(i18), Integer.valueOf(i17)).toString();
    }

    @Override // com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.VideoFrameSelectBar.a
    public void P1(final int i3, final int i16) {
        if (QLog.isColorLevel()) {
            QLog.d("EditLocalVideoActivity", 2, "onFramesClipChanged, startTime=" + i3 + ", endTime=" + i16);
        }
        if (this.f185774v0) {
            LpReportInfo_pf00064.allReport(LpReportInfoConfig.ACTION_VIDEO_EDITOR, 4, 4);
        }
        runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity.19
            @Override // java.lang.Runnable
            public void run() {
                EditLocalVideoActivity.this.P0.setVisibility(8);
            }
        });
        if (this.V0.getVisibility() != 0) {
            runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity.20
                @Override // java.lang.Runnable
                public void run() {
                    if (EditLocalVideoActivity.this.f185774v0) {
                        EditLocalVideoActivity.this.V0.setVisibility(0);
                    }
                }
            });
        }
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity.21
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (EditLocalVideoActivity.this.M0.isPlaying() && EditLocalVideoActivity.this.f185774v0) {
                        EditLocalVideoActivity.this.M0.pause();
                    }
                    if (EditLocalVideoActivity.this.f185780y0 == 0) {
                        FixedSizeVideoView fixedSizeVideoView = EditLocalVideoActivity.this.M0;
                        int i17 = i3;
                        fixedSizeVideoView.setPlayDuration(i17, i16 - i17);
                    }
                } catch (IllegalStateException unused) {
                    QLog.w("EditLocalVideoActivity", 2, "Illegal state: onFramesClipChanged");
                }
            }
        });
        if (this.f185780y0 == 0) {
            this.f185778x0 = i3;
        }
        com.tencent.mobileqq.activity.richmedia.b bVar = this.f185764q0;
        if (bVar != null) {
            bVar.H(i3, i16);
        }
    }

    public void P3(String str, String str2, String str3, boolean z16) {
        QZoneClickReport.ReportInfo reportInfo = new QZoneClickReport.ReportInfo();
        reportInfo.actionType = str;
        reportInfo.subactionType = str2;
        reportInfo.reserves = str3;
        QZoneClickReport.report(String.valueOf(this.C1), reportInfo, z16);
    }

    public void Q4() {
        this.f185742f0.setText(V3(this.f185743f1));
    }

    public Bitmap S3(String str, int i3, int i16, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("EditLocalVideoActivity", 2, "getBitmapWithSize but fileName is empty");
            return null;
        }
        if (!new File(str).exists()) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        Q3(str, options);
        options.inJustDecodeBounds = false;
        int min = Math.min(options.outWidth / i3, options.outHeight / i16);
        if (min < 1) {
            min = 1;
        }
        options.inSampleSize = min;
        Bitmap E4 = E4(options, str, true);
        if (E4 == null) {
            options.inSampleSize++;
            E4 = D4(options, str);
        }
        if (E4 == null) {
            return null;
        }
        int width = E4.getWidth();
        int height = E4.getHeight();
        float f16 = i3 / width;
        float f17 = i16 / height;
        if (f16 > 1.0f && f17 > 1.0f) {
            return E4;
        }
        Matrix matrix = new Matrix();
        if (z16) {
            if (f16 > f17) {
                f16 = f17;
            }
            matrix.postScale(f16, f16);
        } else {
            matrix.postScale(f16, f17);
        }
        Bitmap C4 = C4(E4, width, height, matrix, true);
        if (C4 != E4) {
            E4.recycle();
        }
        return C4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x00a6, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a3, code lost:
    
        if (r9 != null) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String U3(String str) {
        String str2 = "";
        Cursor cursor = null;
        try {
            try {
                cursor = ContactsMonitor.query(BaseApplication.getContext().getContentResolver(), Uri.parse("content://qq.friendlist/friendlist/" + str), null, "uin=?", new String[]{str}, null);
                if (cursor != null && cursor.moveToFirst()) {
                    int columnIndex = cursor.getColumnIndex("name");
                    if (columnIndex >= 0) {
                        String string = cursor.getString(columnIndex);
                        if (!TextUtils.isEmpty(string)) {
                            str2 = SecurityUtile.decode(new String(string.getBytes(), "utf-8"));
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("EditLocalVideoActivity", 2, "getNickName by ContentProvider success, name =" + str2);
                    }
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("EditLocalVideoActivity", 2, "getNickName by ContentProvider  Exception, trace=" + QLog.getStackTraceString(e16));
                }
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    @Override // com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity, com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    public long getFreeSpace(String str) {
        try {
            StatFs statFs = new StatFs(str);
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Exception e16) {
            QLog.w("EditLocalVideoActivity", 2, "getFreeSpace error", e16);
            return 0L;
        }
    }

    @Override // com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.VideoFrameSelectBar.a
    public void o1(final float f16) {
        runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity.22
            @Override // java.lang.Runnable
            public void run() {
                if (EditLocalVideoActivity.this.T0 != null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("EditLocalVideoActivity", 2, "onCurrentRangeTimeChanged, time=" + EditLocalVideoActivity.this.L4((int) f16));
                    }
                    EditLocalVideoActivity.this.T0.setText(EditLocalVideoActivity.this.L4((int) f16));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i3, int i16, Intent intent) {
        Bundle bundle;
        if (i3 == 2) {
            if (QLog.isColorLevel()) {
                QLog.d("EditLocalVideoActivity", 2, "onActivityResult:requestCode=" + i3 + "  resultCode=" + i16);
            }
            if (intent != null) {
                Bundle extras = intent.getExtras();
                if (extras.containsKey(UgcSettingUtil.KEY_PERMISSION_CODE)) {
                    this.f185743f1 = extras.getInt(UgcSettingUtil.KEY_PERMISSION_CODE);
                }
                if (extras.containsKey("uin_list")) {
                    if (this.f185745g1 == null) {
                        this.f185745g1 = new ArrayList<>();
                    }
                    this.f185745g1.clear();
                    ArrayList<String> stringArrayList = extras.getStringArrayList("uin_list");
                    if (stringArrayList != null) {
                        this.f185745g1.addAll(stringArrayList);
                    }
                }
                if (k4(this.f185743f1)) {
                    this.f185749i1 = extras.getString(UgcSettingUtil.KEY_UGC_SETTING_RAW_JSON);
                    this.f185747h1 = extras.getString(UgcSettingUtil.KEY_TAG_INFO);
                }
                Q4();
                return;
            }
            return;
        }
        if (i3 == 1009) {
            this.f185768s0 = false;
            View view = this.f185766r0;
            if (view != null) {
                view.setVisibility(8);
            }
            if (intent != null) {
                Bundle extras2 = intent.getExtras();
                if (extras2.containsKey(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_BUNDLE_PRIV_KEY) && (bundle = extras2.getBundle(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_BUNDLE_PRIV_KEY)) != null) {
                    this.f185743f1 = bundle.getInt(UgcSettingUtil.KEY_PERMISSION_CODE);
                    if (this.f185745g1 == null) {
                        this.f185745g1 = new ArrayList<>();
                    }
                    this.f185745g1.clear();
                    ArrayList<String> stringArrayList2 = bundle.getStringArrayList("uin_list");
                    if (stringArrayList2 != null) {
                        this.f185745g1.addAll(stringArrayList2);
                    }
                    if (k4(this.f185743f1)) {
                        this.f185749i1 = bundle.getString(UgcSettingUtil.KEY_UGC_SETTING_RAW_JSON);
                        this.f185747h1 = bundle.getString(UgcSettingUtil.KEY_TAG_INFO);
                    }
                    Q4();
                }
                if (extras2.containsKey("contentIntentKey")) {
                    String string = extras2.getString("contentIntentKey");
                    if (string == null) {
                        string = "";
                    }
                    this.f185751j1 = string;
                }
                if (extras2.containsKey(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_CONTENT_INTENT_VIDEO_EDIT_EMO)) {
                    this.f185744g0.setText(extras2.getString(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_CONTENT_INTENT_VIDEO_EDIT_EMO));
                }
                this.f185759n1 = extras2.getInt(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_ID, -1);
                this.f185761o1 = extras2.getInt(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_FORMAT_TYPE);
                this.f185763p1 = extras2.getString(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_URL);
                this.f185765q1 = extras2.getInt(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_SUPER_FONT_ID, -1);
                this.f185767r1 = extras2.getString(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_SUPER_FONT_INFO);
                this.E1.sendEmptyMessage(1009);
                return;
            }
            return;
        }
        if (i3 == 1010 && i16 == -1) {
            ToastUtil.a().b(R.string.gia);
            this.X0 = true;
        }
    }

    @Override // mqq.app.AppActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        this.f185781y1 = true;
        o4();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.cdq) {
            LpReportInfo_pf00064.allReport(LpReportInfoConfig.ACTION_VIDEO_EDITOR, 3, 1);
            if (this.f185758n0) {
                this.f185762p0 = true;
                R3();
                I4();
            } else {
                QQToast.makeText(getApplicationContext(), HardCodeUtil.qqStr(R.string.lvu), 1).show();
            }
        } else if (id5 == R.id.cdn) {
            LpReportInfo_pf00064.allReport(LpReportInfoConfig.ACTION_VIDEO_EDITOR, 4, 1);
            if (this.f185756m0) {
                QLog.e("EditLocalVideoActivity", 2, "click clip ");
                Bitmap S3 = S3(this.E0, this.C0, this.D0, false);
                if (S3 != null) {
                    this.P0.setImageBitmap(S3);
                } else {
                    QLog.e("EditLocalVideoActivity", 2, "click clip but coverview find bitmap is null");
                }
                this.M0.seekTo(this.f185778x0);
                this.M0.pause();
                this.f185774v0 = true;
                M4(true);
            } else {
                long config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_SHORT_VIDEO_DURATION_THRESHOLD, 90000);
                QQToast.makeText(getApplicationContext(), HardCodeUtil.qqStr(R.string.f171921lw1) + (config / 1000) + HardCodeUtil.qqStr(R.string.lwf), 1).show();
            }
        } else if (id5 == R.id.cfe) {
            LpReportInfo_pf00064.allReport(LpReportInfoConfig.ACTION_VIDEO_EDITOR, 1);
            this.f185781y1 = false;
            o4();
        } else if (id5 == R.id.cf5) {
            String replace = QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_UGC_PERMIT_SETTING, QZoneHelper.Constants.UGC_PERMIT_SETTING_PAGE).replace("{uin}", String.valueOf(this.C1)).replace("{qua}", QUA.getQUA3());
            P3("608", "6", "0", true);
            Bundle bundle = new Bundle();
            bundle.putInt(UgcSettingUtil.KEY_PERMISSION_CODE, this.f185743f1);
            ArrayList<String> arrayList = this.f185745g1;
            if (arrayList != null && arrayList.size() > 0) {
                bundle.putStringArrayList("uin_list", this.f185745g1);
                ArrayList<String> arrayList2 = new ArrayList<>(this.f185745g1.size());
                Iterator<String> it = this.f185745g1.iterator();
                while (it.hasNext()) {
                    arrayList2.add(U3(it.next()));
                }
                bundle.putStringArrayList(UgcSettingUtil.KEY_NICKNAMES, arrayList2);
            }
            if (k4(this.f185743f1) && !TextUtils.isEmpty(this.f185749i1)) {
                bundle.putString(UgcSettingUtil.KEY_UGC_SETTING_RAW_JSON, this.f185749i1);
            }
            QZoneHelper.forwardToBrowser(this, replace, 2, bundle, "");
        } else if (id5 == R.id.cfk) {
            L3();
        } else {
            if (id5 == R.id.cdz) {
                this.f185768s0 = true;
                P3("608", "5", "0", true);
                QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
                Bundle bundle2 = new Bundle();
                bundle2.putInt(UgcSettingUtil.KEY_PERMISSION_CODE, this.f185743f1);
                ArrayList<String> arrayList3 = this.f185745g1;
                if (arrayList3 != null && arrayList3.size() > 0) {
                    bundle2.putStringArrayList("uin_list", this.f185745g1);
                    ArrayList<String> arrayList4 = new ArrayList<>(this.f185745g1.size());
                    Iterator<String> it5 = this.f185745g1.iterator();
                    while (it5.hasNext()) {
                        arrayList4.add(U3(it5.next()));
                    }
                    bundle2.putStringArrayList(UgcSettingUtil.KEY_NICKNAMES, arrayList4);
                }
                if (k4(this.f185743f1) && !TextUtils.isEmpty(this.f185749i1)) {
                    bundle2.putString(UgcSettingUtil.KEY_UGC_SETTING_RAW_JSON, this.f185749i1);
                }
                if (this.f185766r0 == null) {
                    View view2 = new View(this);
                    this.f185766r0 = view2;
                    view2.setBackgroundColor(Color.argb(128, 0, 0, 0));
                    this.f185766r0.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                    this.f185734b0.addView(this.f185766r0);
                }
                this.f185766r0.setVisibility(0);
                ExtendEditText extendEditText = this.f185744g0;
                if (extendEditText == null) {
                    str = "";
                } else {
                    str = extendEditText.getText().toString();
                }
                boolean z16 = this.f185755l1;
                QZoneHelper.forwardToVideoEditActionPanel(this, userInfo, 1009, "", str, "", "", 0, !z16 ? 1 : 0, 1, 0, 0, 0, "", 10000, bundle2, z16, this.f185757m1, this.f185759n1, this.f185765q1, false);
            } else {
                if (id5 != R.id.cem && id5 != R.id.cen) {
                    if (id5 == R.id.kpr) {
                        LpReportInfo_pf00064.allReport(LpReportInfoConfig.ACTION_VIDEO_EDITOR, 4, 2);
                        u4();
                    } else if (id5 == R.id.kps) {
                        LpReportInfo_pf00064.allReport(LpReportInfoConfig.ACTION_VIDEO_EDITOR, 4, 3);
                        P3("608", "4", "1", true);
                        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).post(new Runnable() { // from class: com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity.5
                            @Override // java.lang.Runnable
                            public void run() {
                                EditLocalVideoActivity.this.p4();
                            }
                        });
                    }
                } else if (!this.X0) {
                    J4();
                } else if (this.f185754l0) {
                    ToastUtil.a().b(R.string.gpo);
                    this.f185754l0 = false;
                    this.f185750j0.setBackgroundResource(R.drawable.ghw);
                    this.Y0 = false;
                } else {
                    ToastUtil.a().b(R.string.gpq);
                    P3("608", "7", "1", true);
                    this.f185754l0 = true;
                    this.f185750j0.setBackgroundResource(R.drawable.ghv);
                    this.Y0 = true;
                }
                EventCollector.getInstance().onViewClicked(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity, com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        getWindow().addFlags(128);
        getWindow().addFlags(1024);
        K3();
        this.mNeedStatusTrans = false;
        this.mActNeedImmersive = false;
        super.onCreate(bundle);
        initData();
        r4();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        QzoneGuideBubbleHelper.getInstance().dismissGuideBubble();
        com.tencent.mobileqq.activity.richmedia.b bVar = this.f185764q0;
        if (bVar != null) {
            bVar.q();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (!TextUtils.isEmpty(this.f185733a1)) {
            if (!this.f185774v0) {
                this.M0.pause();
            } else if (this.M0.isPlaying()) {
                this.M0.pause();
            }
        }
        com.tencent.mobileqq.activity.richmedia.b bVar = this.f185764q0;
        if (bVar != null) {
            bVar.r();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.f185762p0) {
            LpReportInfo_pf00064.allReport(LpReportInfoConfig.ACTION_VIDEO_EDITOR, 3, 2);
            this.f185762p0 = false;
        }
        n4();
        FixedSizeVideoView fixedSizeVideoView = this.M0;
        if (fixedSizeVideoView != null) {
            if (!this.f185774v0) {
                fixedSizeVideoView.seekTo(this.f185780y0);
                this.M0.start();
                this.V0.setVisibility(8);
            } else {
                Bitmap S3 = S3(this.E0, this.C0, this.D0, false);
                if (S3 != null) {
                    this.P0.setImageBitmap(S3);
                }
                M4(true);
                this.M0.seekTo(this.f185778x0);
                this.M0.pause();
            }
            com.tencent.mobileqq.activity.richmedia.b bVar = this.f185764q0;
            if (bVar != null) {
                bVar.s();
            }
        }
    }

    protected void r4() {
        setContentViewNoTitle(R.layout.aw6);
        this.f185734b0 = (RelativeLayout) $(R.id.bsz);
        this.f185732a0 = (ViewGroup) $(R.id.f165247ce1);
        PressDarkImageButton pressDarkImageButton = (PressDarkImageButton) $(R.id.cdq);
        this.f185760o0 = pressDarkImageButton;
        pressDarkImageButton.setOnClickListener(this);
        PressDarkImageButton pressDarkImageButton2 = (PressDarkImageButton) $(R.id.cdn);
        this.f185770t0 = pressDarkImageButton2;
        pressDarkImageButton2.setOnClickListener(this);
        TextView textView = (TextView) $(R.id.cfk);
        this.f185736c0 = textView;
        textView.setOnClickListener(this);
        TextView textView2 = (TextView) $(R.id.cfe);
        this.f185738d0 = textView2;
        textView2.setOnClickListener(this);
        RelativeLayout relativeLayout = (RelativeLayout) $(R.id.cem);
        this.f185748i0 = relativeLayout;
        relativeLayout.setOnClickListener(this);
        Button button = (Button) $(R.id.cen);
        this.f185750j0 = button;
        button.setOnClickListener(this);
        this.f185752k0 = (TextView) $(R.id.ceo);
        this.f185740e0 = (RelativeLayout) $(R.id.cdy);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) com.tencent.mobileqq.activity.aio.l.X(2, 50, getResources()));
        this.f185740e0.setBackgroundColor(getResources().getColor(R.color.a2n));
        this.f185740e0.setVisibility(0);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = BaseAIOUtils.f(55.0f, getResources());
        this.f185740e0.setLayoutParams(layoutParams);
        ExtendEditText extendEditText = (ExtendEditText) $(R.id.cdz);
        this.f185744g0 = extendEditText;
        extendEditText.setEditableFactory(com.tencent.mobileqq.text.o.f292704d);
        this.f185744g0.setOnClickListener(this);
        Button button2 = (Button) $(R.id.cf5);
        this.f185742f0 = button2;
        button2.setOnClickListener(this);
        this.f185746h0 = $(R.id.cf_);
        f4();
        m4();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements b.d {
        a() {
        }

        @Override // com.tencent.mobileqq.activity.richmedia.b.d
        public void b(String str) {
            EditLocalVideoActivity.this.F0 = str;
            EditLocalVideoActivity.this.z4();
        }

        @Override // com.tencent.mobileqq.activity.richmedia.b.d
        public void c() {
            QQToast.makeText(EditLocalVideoActivity.this, R.string.cua, 1).show();
        }

        @Override // com.tencent.mobileqq.activity.richmedia.b.d
        public void a() {
        }
    }
}
