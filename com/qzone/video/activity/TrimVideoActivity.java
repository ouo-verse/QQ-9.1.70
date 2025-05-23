package com.qzone.video.activity;

import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.QZoneTitleBarActivity;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.proxy.covercomponent.QzoneCoverConst;
import com.qzone.util.ToastUtil;
import com.qzone.util.l;
import com.tencent.maxvideo.common.GlobalInit;
import com.tencent.maxvideo.trim.TrimNative;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.VideoFrameSelectBar;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.video.decode.ShortVideoSoLoad;
import com.tencent.widget.ActionSheet;
import common.config.service.QzoneConfig;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneShareManager;
import cooperation.qzone.QZoneVideoCommonUtils;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.FileUtils;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.QZonePermission;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import java.io.File;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public class TrimVideoActivity extends QZoneTitleBarActivity implements View.OnClickListener, VideoFrameSelectBar.a {

    /* renamed from: r1, reason: collision with root package name */
    private static final boolean f60009r1 = true;
    private FixedSizeVideoView K0;
    private VideoFrameSelectBar L0;
    private ViewGroup M0;
    private ImageView N0;
    private String O0;
    private long P0;
    private int S0;
    private int T0;
    private int U0;
    private boolean V0;
    private String X0;
    private String Y0;
    private QQProgressDialog Z0;

    /* renamed from: a1, reason: collision with root package name */
    private int f60010a1;

    /* renamed from: b1, reason: collision with root package name */
    private int f60011b1;

    /* renamed from: l1, reason: collision with root package name */
    private ImageView f60021l1;

    /* renamed from: n1, reason: collision with root package name */
    private Bitmap f60023n1;

    /* renamed from: q1, reason: collision with root package name */
    private String f60026q1;
    private int Q0 = 0;
    private boolean R0 = false;
    private int W0 = 2;

    /* renamed from: c1, reason: collision with root package name */
    String f60012c1 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastFileNotExistOrMemoryNotEnough", "\u62b1\u6b49\uff0c\u6587\u4ef6\u4e0d\u5b58\u5728\u6216\u5b58\u50a8\u7a7a\u95f4\u4e0d\u8db3");

    /* renamed from: d1, reason: collision with root package name */
    String f60013d1 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastMemoryNotEnough", "\u53ef\u7528\u5185\u5b58\u8fc7\u5c11\uff0c\u53ef\u80fd\u5f71\u54cd\u88c1\u526a\u64cd\u4f5c");

    /* renamed from: e1, reason: collision with root package name */
    String f60014e1 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastInitTrimEngineFail", "\u5bf9\u4e0d\u8d77\uff0c\u521d\u59cb\u5316\u88c1\u526a\u5f15\u64ce\u5931\u8d25");

    /* renamed from: f1, reason: collision with root package name */
    String f60015f1 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogInitTrimFail", "\u521d\u59cb\u5316\u88c1\u526a\u7ec4\u4ef6\u5931\u8d25");

    /* renamed from: g1, reason: collision with root package name */
    String f60016g1 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogLoadVideoTimeOut", "\u52a0\u8f7d\u89c6\u9891\u8d85\u65f6");

    /* renamed from: h1, reason: collision with root package name */
    String f60017h1 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TitleTrimVideoCenterView", "\u88c1\u526a");

    /* renamed from: i1, reason: collision with root package name */
    String f60018i1 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TitleTrimVideoLeftButton", "\u53d6\u6d88");

    /* renamed from: j1, reason: collision with root package name */
    String f60019j1 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TitleTrimVideoRightButton", "\u5b8c\u6210");

    /* renamed from: k1, reason: collision with root package name */
    boolean f60020k1 = false;

    /* renamed from: m1, reason: collision with root package name */
    private Handler f60022m1 = new f();

    /* renamed from: o1, reason: collision with root package name */
    private int f60024o1 = 0;

    /* renamed from: p1, reason: collision with root package name */
    private int f60025p1 = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (TrimVideoActivity.this.K0.isPlaying()) {
                TrimVideoActivity trimVideoActivity = TrimVideoActivity.this;
                trimVideoActivity.f60020k1 = false;
                trimVideoActivity.K0.pause();
                TrimVideoActivity.this.N0.setVisibility(0);
            } else {
                TrimVideoActivity trimVideoActivity2 = TrimVideoActivity.this;
                trimVideoActivity2.f60020k1 = true;
                trimVideoActivity2.f60021l1.setVisibility(8);
                TrimVideoActivity.this.K0.start();
                TrimVideoActivity.this.N0.setVisibility(4);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class b implements FixedSizeVideoView.c {
        b() {
        }

        @Override // com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView.c
        public void a(FixedSizeVideoView fixedSizeVideoView, int i3, int i16) {
            fixedSizeVideoView.pause();
            fixedSizeVideoView.seekTo(i3);
            TrimVideoActivity trimVideoActivity = TrimVideoActivity.this;
            trimVideoActivity.f60020k1 = false;
            trimVideoActivity.N0.setVisibility(0);
        }

        @Override // com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView.c
        public void b(MediaPlayer mediaPlayer) {
            mediaPlayer.seekTo(TrimVideoActivity.this.Q0);
            TrimVideoActivity trimVideoActivity = TrimVideoActivity.this;
            trimVideoActivity.f60020k1 = false;
            trimVideoActivity.N0.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class c implements MediaPlayer.OnErrorListener {
        c() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i3, int i16) {
            QZLog.e(QzoneConfig.MAIN_KEY_TRIM, "VideoView onError, what:" + i3 + ", extra:" + i16);
            try {
                QQToast.makeText(TrimVideoActivity.this.getApplicationContext(), QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastVideoLoadFail", "\u52a0\u8f7d\u89c6\u9891\u5931\u8d25"), 1).show();
                QzoneVideoBeaconReport.reportVideoEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_VIDEO_TRIM, "1", null);
                bp.b.d(1002);
                TrimVideoActivity.this.setResult(0);
                TrimVideoActivity.this.finish();
            } catch (Exception e16) {
                QZLog.e(QzoneConfig.MAIN_KEY_TRIM, "VideoView onError", e16);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class d implements MediaPlayer.OnPreparedListener {
        d() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (QZLog.isColorLevel()) {
                QZLog.d(QzoneConfig.MAIN_KEY_TRIM, 2, "onPrepared, duration:" + mediaPlayer.getDuration());
            }
            TrimVideoActivity.this.f60022m1.removeMessages(9999);
            if (!TrimVideoActivity.this.L0.j()) {
                TrimVideoActivity.this.S0 = mediaPlayer.getDuration();
                if ((FileUtils.getFileSize(TrimVideoActivity.this.O0) / TrimVideoActivity.this.K0.getDuration()) * 15000 > com.qzone.video.mediadevice.a.b(com.qzone.video.mediadevice.a.a()) && QZLog.isColorLevel()) {
                    QZLog.d(QzoneConfig.MAIN_KEY_TRIM, 2, "prepared, there is not enough space on sdcard");
                }
                int videoWidth = mediaPlayer.getVideoWidth();
                int videoHeight = mediaPlayer.getVideoHeight();
                if (videoWidth > 0 && videoHeight > 0) {
                    TrimVideoActivity.this.f60010a1 = videoWidth;
                    TrimVideoActivity.this.f60011b1 = videoHeight;
                    TrimVideoActivity.this.m4(videoWidth, videoHeight);
                    ((QZoneTitleBarActivity) TrimVideoActivity.this).f45401c0.setEnabled(true);
                } else {
                    QQToast.makeText(TrimVideoActivity.this.getApplicationContext(), QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastGetVideoSizeFail", "\u83b7\u53d6\u89c6\u9891\u5c3a\u5bf8\u5931\u8d25"), 1).show();
                    TrimVideoActivity.this.finish();
                    return;
                }
            }
            ((QZoneTitleBarActivity) TrimVideoActivity.this).f45401c0.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class e implements View.OnTouchListener {
        e() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (TrimVideoActivity.this.K0.isPlaying()) {
                TrimVideoActivity trimVideoActivity = TrimVideoActivity.this;
                trimVideoActivity.f60020k1 = false;
                trimVideoActivity.K0.pause();
                TrimVideoActivity.this.N0.setVisibility(0);
            } else {
                TrimVideoActivity.this.K0.start();
                TrimVideoActivity trimVideoActivity2 = TrimVideoActivity.this;
                trimVideoActivity2.f60020k1 = true;
                trimVideoActivity2.N0.setVisibility(4);
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class f extends Handler {

        /* compiled from: P */
        /* loaded from: classes37.dex */
        class a implements DialogInterface.OnClickListener {
            a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                TrimVideoActivity.this.finish();
            }
        }

        /* compiled from: P */
        /* loaded from: classes37.dex */
        class b implements DialogInterface.OnClickListener {
            b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                TrimVideoActivity.this.finish();
            }
        }

        f() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 == 1001) {
                new AlertDialog.Builder(TrimVideoActivity.this).setMessage(TrimVideoActivity.this.f60015f1).setNegativeButton(R.string.c7n, new a()).setCancelable(false).create().show();
                return;
            }
            if (i3 != 9999) {
                switch (i3) {
                    case 1100:
                        if (TrimVideoActivity.this.L0 != null) {
                            TrimVideoActivity.this.L0.requestLayout();
                            return;
                        }
                        return;
                    case 1101:
                        QQToast.makeText(TrimVideoActivity.this.getApplicationContext(), QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastVideoFormatNotSupport", "\u88c1\u526a\u7684\u89c6\u9891\u683c\u5f0f\u4e0d\u652f\u6301\uff0c\u8bf7\u91cd\u65b0\u9009\u62e9\u89c6\u9891"), 1).show();
                        TrimVideoActivity.this.v4();
                        return;
                    case 1102:
                        if (TrimVideoActivity.this.f60021l1 != null) {
                            try {
                                String str = (String) message.obj;
                                int width = TrimVideoActivity.this.K0.getWidth();
                                int height = TrimVideoActivity.this.K0.getHeight();
                                if (QZLog.isColorLevel()) {
                                    QZLog.d(QzoneConfig.MAIN_KEY_TRIM, 2, "VIDEO_SHOW_COVER, filename=" + str + ", w=" + width + ", h=" + height);
                                }
                                if (TrimVideoActivity.this.f60023n1 != null) {
                                    ViewGroup.LayoutParams layoutParams = TrimVideoActivity.this.f60021l1.getLayoutParams();
                                    layoutParams.height = height;
                                    layoutParams.width = width;
                                    TrimVideoActivity.this.f60021l1.setLayoutParams(layoutParams);
                                    TrimVideoActivity.this.f60021l1.setImageBitmap(TrimVideoActivity.this.f60023n1);
                                    TrimVideoActivity.this.f60021l1.setVisibility(0);
                                    TrimVideoActivity.this.f60024o1 = width;
                                    TrimVideoActivity.this.f60025p1 = height;
                                    TrimVideoActivity.this.f60026q1 = str;
                                    return;
                                }
                                return;
                            } catch (Throwable th5) {
                                QZLog.w(QzoneConfig.MAIN_KEY_TRIM, "VIDEO_SHOW_COVER failed", th5);
                                return;
                            }
                        }
                        return;
                    case 1103:
                        if (QZLog.isColorLevel()) {
                            QZLog.d(QzoneConfig.MAIN_KEY_TRIM, 2, "handleMessage, MSG_ON_CONFIRM");
                        }
                        if (TrimVideoActivity.this.Z0 != null) {
                            TrimVideoActivity.this.Z0.dismiss();
                        }
                        Intent intent = new Intent();
                        intent.putExtra("finish_video_component", true);
                        TrimVideoActivity.this.setResult(-1, intent);
                        TrimVideoActivity.this.finish();
                        return;
                    default:
                        return;
                }
            }
            QzoneVideoBeaconReport.reportVideoEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_VIDEO_TRIM, "11", null);
            try {
                new AlertDialog.Builder(TrimVideoActivity.this).setMessage(TrimVideoActivity.this.f60016g1).setNegativeButton(R.string.c7n, new b()).setCancelable(false).create().show();
            } catch (Exception e16) {
                QZLog.e(QzoneConfig.MAIN_KEY_TRIM, "LOAD_VIDEO_TIME_OUT showDialog error", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class h extends QQPermission.BasePermissionsListener {
        h() {
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            cp.b.a(TrimVideoActivity.this, getClass().getName(), "com.tencent.mobileqq", TrimVideoActivity.this.W0, TrimVideoActivity.this.l4());
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            super.onDenied(list, list2);
        }
    }

    private void initUI() {
        setTitle(this.f60017h1);
        this.f45401c0.setCompoundDrawables(null, null, null, null);
        this.f45401c0.setOnClickListener(this);
        this.f45401c0.setVisibility(0);
        this.f45401c0.setText(this.f60019j1);
        this.f45401c0.setEnabled(false);
        this.f45399a0.setOnClickListener(this);
        this.f45399a0.setVisibility(0);
        this.f45399a0.setText(this.f60018i1);
        this.M0 = (ViewGroup) findViewById(R.id.f167092kq3);
        this.K0 = (FixedSizeVideoView) findViewById(R.id.kvb);
        this.f60021l1 = (ImageView) findViewById(R.id.bbd);
        this.L0 = (VideoFrameSelectBar) findViewById(R.id.kpp);
        this.N0 = (ImageView) findViewById(R.id.kwn);
        ViewGroup.LayoutParams layoutParams = this.M0.getLayoutParams();
        layoutParams.height = getResources().getDisplayMetrics().widthPixels;
        this.M0.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String l4() {
        if (this.X0 == null && getIntent() != null) {
            this.X0 = getIntent().getStringExtra(PeakConstants.VIDEO_REFER);
        }
        return this.X0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m4(final int i3, final int i16) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).post(new Runnable() { // from class: com.qzone.video.activity.TrimVideoActivity.7
            @Override // java.lang.Runnable
            public void run() {
                int i17;
                int i18;
                int i19;
                int i26;
                Bitmap a16;
                int i27 = TrimVideoActivity.this.getResources().getDisplayMetrics().widthPixels / 6;
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
                if (!TextUtils.isEmpty(TrimVideoActivity.this.O0)) {
                    if (!TrimVideoActivity.f60009r1) {
                        int c16 = o71.b.c(TrimVideoActivity.this.O0, i17, i26, i18, i19, i27, i27);
                        if (QZLog.isColorLevel()) {
                            QZLog.d(QzoneConfig.MAIN_KEY_TRIM, 2, "init, status1=" + c16 + ", dstWidth=" + i17 + ", dstHeight=" + i26);
                        }
                        if (c16 != 0) {
                            QzoneVideoBeaconReport.reportVideoEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_VIDEO_TRIM, "2", null);
                            TrimVideoActivity.this.f60022m1.sendEmptyMessage(1001);
                            bp.b.d(1003);
                            return;
                        }
                    }
                    TrimVideoActivity.this.L0.i(TrimVideoActivity.this.S0, TrimVideoActivity.this.O0);
                    TrimVideoActivity trimVideoActivity = TrimVideoActivity.this;
                    trimVideoActivity.T0 = (int) trimVideoActivity.L0.f();
                    TrimVideoActivity trimVideoActivity2 = TrimVideoActivity.this;
                    trimVideoActivity2.U0 = (int) trimVideoActivity2.L0.g();
                    if (QZLog.isColorLevel()) {
                        QZLog.d(QzoneConfig.MAIN_KEY_TRIM, 2, "mStartTime=" + TrimVideoActivity.this.T0 + ", mEndTime=" + TrimVideoActivity.this.U0);
                    }
                    TrimVideoActivity.this.K0.setPlayDuration(TrimVideoActivity.this.U0 - TrimVideoActivity.this.T0);
                    TrimVideoActivity.this.f60022m1.sendEmptyMessage(1100);
                    if (!TrimVideoActivity.f60009r1) {
                        int d16 = TextUtils.isEmpty(TrimVideoActivity.this.O0) ? -999 : o71.b.d(TrimVideoActivity.this.O0, i3, i16);
                        if (QZLog.isColorLevel()) {
                            QZLog.d(QzoneConfig.MAIN_KEY_TRIM, 2, "init, status0=" + d16);
                        }
                        if (d16 != 0) {
                            QzoneVideoBeaconReport.reportVideoEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_VIDEO_TRIM, "3", null);
                            TrimVideoActivity.this.f60022m1.sendEmptyMessage(1000);
                            bp.b.d(1008);
                            return;
                        }
                    }
                    try {
                        if (TrimVideoActivity.f60009r1) {
                            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                            mediaMetadataRetriever.setDataSource(TrimVideoActivity.this.O0);
                            a16 = mediaMetadataRetriever.getFrameAtTime(0L);
                            mediaMetadataRetriever.release();
                        } else {
                            a16 = o71.b.a(0L, 1000L);
                        }
                        if (a16 != null) {
                            String str = bp.a.f28738b + File.separator + System.currentTimeMillis() + ".jpg";
                            if (com.qzone.util.image.c.V(a16, str, Bitmap.CompressFormat.JPEG, 80, true)) {
                                TrimVideoActivity.this.f60023n1 = com.qzone.util.image.c.v(str, TrimVideoActivity.this.K0.getWidth(), TrimVideoActivity.this.K0.getHeight());
                                TrimVideoActivity.this.f60022m1.obtainMessage(1102, str).sendToTarget();
                                return;
                            }
                            return;
                        }
                        return;
                    } catch (Throwable th5) {
                        QZLog.w(th5);
                        return;
                    }
                }
                if (QZLog.isColorLevel()) {
                    QZLog.d(QzoneConfig.MAIN_KEY_TRIM, 2, "initFramesBar, mVideoPath is null");
                }
                TrimVideoActivity.this.f60022m1.sendEmptyMessage(1001);
                bp.b.d(1003);
            }
        });
    }

    private void n4() {
        this.N0.setOnClickListener(new a());
        TextView textView = this.f45399a0;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
        TextView textView2 = this.f45401c0;
        if (textView2 != null) {
            textView2.setEnabled(false);
            this.f45401c0.setOnClickListener(this);
        }
        VideoFrameSelectBar videoFrameSelectBar = this.L0;
        if (videoFrameSelectBar != null) {
            videoFrameSelectBar.setOnFramesClipChangeListener(this);
        }
    }

    private void o4() {
        this.K0.setOnFixVDPlayCompelteListener(new b());
        this.K0.setOnErrorListener(new c());
        this.K0.setOnPreparedListener(new d());
        this.K0.setOnTouchListener(new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean p4() {
        String str = this.Y0;
        return str != null && str.equals("referQZoneUploadPhotoActivity");
    }

    private boolean r4() {
        if (!CacheManager.isExternalAvailable()) {
            if (QLog.isColorLevel()) {
                QLog.i(QzoneConfig.MAIN_KEY_TRIM, 2, "isEnoughStorage() sdcard not mounted");
            }
            QzoneVideoBeaconReport.reportVideoEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_VIDEO_TRIM, "6", null);
            bp.b.d(1009);
        }
        long fileSize = FileUtils.getFileSize(this.O0);
        if (fileSize <= 0) {
            if (QZLog.isColorLevel()) {
                QZLog.d(QzoneConfig.MAIN_KEY_TRIM, 2, "no file size");
            }
            QzoneVideoBeaconReport.reportVideoEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_VIDEO_TRIM, "7", null);
            bp.b.d(1010);
            return false;
        }
        if ((fileSize / this.K0.getDuration()) * (this.U0 - this.T0) <= CacheManager.getSDCardRemain()) {
            return true;
        }
        if (QZLog.isColorLevel()) {
            QZLog.d(QzoneConfig.MAIN_KEY_TRIM, 2, "there is not enough space on sdcard");
        }
        QzoneVideoBeaconReport.reportVideoEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_VIDEO_TRIM, "8", null);
        bp.b.d(1011);
        return false;
    }

    private boolean s4() {
        Intent intent = getIntent();
        if (intent != null && !TextUtils.isEmpty(intent.getStringExtra("file_send_path"))) {
            return false;
        }
        String l46 = l4();
        if (TextUtils.isEmpty(l46)) {
            return false;
        }
        return l46.contains(PeakConstants.VIDEO_REFER_FROM_MOOD) || l46.contains(PeakConstants.VIDEO_REFER_FROM_ALBUM) || t4();
    }

    private boolean t4() {
        return QZoneVideoCommonUtils.REFER_SHORT_VIDEO_FOR_VIDEO_COVER.equals(l4());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v4() {
        VideoFrameSelectBar videoFrameSelectBar = this.L0;
        if (videoFrameSelectBar != null) {
            videoFrameSelectBar.n();
        }
        this.f60022m1.removeMessages(9999);
        if (QZonePermission.requestStoragePermissionForPluginActivity(this, new h(), QQPermissionConstants.Business.SCENE.QQ_QZONE_SHUOSHUO_ALBUM_OPEN_MEDIA)) {
            cp.b.a(this, getClass().getName(), "com.tencent.mobileqq", this.W0, l4());
        }
    }

    @Override // com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.VideoFrameSelectBar.a
    public void P1(final int i3, final int i16) {
        if (QZLog.isColorLevel()) {
            QZLog.d(QzoneConfig.MAIN_KEY_TRIM, 2, "onFramesClipChanged, startTime=" + i3 + ", endTime=" + i16);
        }
        runOnUiThread(new Runnable() { // from class: com.qzone.video.activity.TrimVideoActivity.11
            @Override // java.lang.Runnable
            public void run() {
                TrimVideoActivity.this.f60021l1.setVisibility(8);
            }
        });
        if (this.N0.getVisibility() != 0) {
            runOnUiThread(new Runnable() { // from class: com.qzone.video.activity.TrimVideoActivity.12
                @Override // java.lang.Runnable
                public void run() {
                    TrimVideoActivity.this.N0.setVisibility(0);
                }
            });
        }
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.video.activity.TrimVideoActivity.13
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (TrimVideoActivity.this.K0.isPlaying()) {
                        TrimVideoActivity.this.K0.pause();
                    }
                    FixedSizeVideoView fixedSizeVideoView = TrimVideoActivity.this.K0;
                    int i17 = i3;
                    fixedSizeVideoView.setPlayDuration(i17, i16 - i17);
                } catch (IllegalStateException unused) {
                    QZLog.w(QzoneConfig.MAIN_KEY_TRIM, "Illegal state: onFramesClipChanged");
                }
            }
        });
        this.Q0 = i3;
    }

    @Override // com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (!this.L0.h()) {
            this.L0.n();
            this.K0.stopPlayback();
            if (p4()) {
                finish();
                return;
            } else {
                v4();
                return;
            }
        }
        ActionSheet create = ActionSheet.create(this);
        String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ActionSheetTitleGiveUpTrim", "\u662f\u5426\u653e\u5f03\u88c1\u526a?");
        String config2 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ActionSheetButtonGiveUpTrim", "\u653e\u5f03");
        create.setMainTitle(config);
        create.addButton(config2, 3);
        create.addCancelButton(l.a(R.string.j6l));
        create.setOnButtonClickListener(new g(create));
        create.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.ivTitleBtnRightText) {
            try {
                if (this.Z0 == null) {
                    this.Z0 = new QQProgressDialog(this);
                }
                this.Z0.show();
                QZLog.d(QzoneConfig.MAIN_KEY_TRIM, 4, "mProgressDlg show");
            } catch (Exception e16) {
                QZLog.w(e16);
            }
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).post(new Runnable() { // from class: com.qzone.video.activity.TrimVideoActivity.10
                @Override // java.lang.Runnable
                public void run() {
                    TrimVideoActivity.this.u4();
                }
            });
        } else if (id5 == R.id.ivTitleBtnLeft) {
            onBackPressed();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.qzone.common.activities.base.QZoneTitleBarActivity, com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.bhb);
        try {
            GlobalInit.loadLibraryWithFullPath(ShortVideoSoLoad.getShortVideoSoPath(BaseApplication.getContext()) + VideoEnvironment.getShortVideoSoLibName());
        } catch (Throwable th5) {
            QZLog.e(QzoneConfig.MAIN_KEY_TRIM, "loadLibrary Exception", th5);
            QzoneVideoBeaconReport.reportVideoEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_VIDEO_TRIM, "-1", null);
            bp.b.d(1007);
            ToastUtil.s(this.f60014e1, 4);
            finish();
        }
        if (!bp.a.b(LoginData.getInstance().getUin())) {
            ToastUtil.s(this.f60014e1, 4);
            QZLog.e(QzoneConfig.MAIN_KEY_TRIM, "init trim failed");
            finish();
        }
        try {
            ActivityManager activityManager = (ActivityManager) getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            int config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_TRIM, QzoneConfig.SECONDARY_MIN_AVAILABLE_RAM, QzoneConfig.DefaultValue.DEFAUL_VIDEO_TRIM_MIN_AVAIL_RAM);
            if (memoryInfo.availMem < config) {
                ToastUtil.r(this.f60013d1);
            }
            if (QZLog.isColorLevel()) {
                QZLog.d(QzoneConfig.MAIN_KEY_TRIM, 2, "availMem=" + memoryInfo.availMem + ", threshold=" + memoryInfo.threshold + ", lowMem=" + memoryInfo.lowMemory + ", minRam=" + config);
            }
        } catch (Throwable th6) {
            QZLog.w(th6);
        }
        bp.a.a();
        initUI();
        n4();
        o4();
        if (s4()) {
            v4();
        } else {
            if (TextUtils.isEmpty(getIntent().getStringExtra("file_send_path"))) {
                return;
            }
            initData(getIntent());
        }
    }

    @Override // com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        VideoFrameSelectBar videoFrameSelectBar = this.L0;
        if (videoFrameSelectBar != null) {
            videoFrameSelectBar.d();
        }
        Bitmap bitmap = this.f60023n1;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.f60023n1.recycle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (QZLog.isColorLevel()) {
            QZLog.d(QzoneConfig.MAIN_KEY_TRIM, 2, "onNewIntent");
        }
        setIntent(intent);
        initData(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.K0.pause();
        this.N0.setVisibility(0);
    }

    @Override // mqq.app.AppActivity, android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.V0 = bundle.getBoolean("on_local_video", false);
        this.O0 = bundle.getString("video_file_path");
        if (QZLog.isColorLevel()) {
            QZLog.d(QzoneConfig.MAIN_KEY_TRIM, 2, "onRestoreInstanceState, mNeedLocalVideo=" + this.V0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.QZoneTitleBarActivity, com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        if (QZLog.isColorLevel()) {
            QZLog.d(QzoneConfig.MAIN_KEY_TRIM, 2, "onResume, mNeedLocalVideo=" + this.V0 + ", mVideoPath=" + this.O0);
        }
        super.onResume();
        if (TextUtils.isEmpty(this.O0)) {
            return;
        }
        this.K0.setVideoPath(this.O0);
        if (this.f60020k1) {
            this.K0.start();
            this.N0.setVisibility(8);
        }
    }

    @Override // mqq.app.AppActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("on_local_video", this.V0);
        bundle.putString("video_file_path", this.O0);
        if (QZLog.isColorLevel()) {
            QZLog.d(QzoneConfig.MAIN_KEY_TRIM, 2, "onSaveInstanceState, false, mVideoPath=" + this.O0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class g implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ActionSheet f60039d;

        g(ActionSheet actionSheet) {
            this.f60039d = actionSheet;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            if (i3 == 0) {
                TrimVideoActivity.this.L0.n();
                TrimVideoActivity.this.K0.stopPlayback();
                if (!TrimVideoActivity.this.p4()) {
                    TrimVideoActivity.this.v4();
                } else {
                    TrimVideoActivity.this.finish();
                }
            }
            this.f60039d.superDismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0148  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void u4() {
        String str;
        int i3;
        int i16;
        String str2;
        String str3;
        String str4;
        Bitmap bitmap;
        int i17;
        int i18;
        Bitmap a16;
        QZLog.d(QzoneConfig.MAIN_KEY_TRIM, 4, "onConfirm start");
        ClickReport.r("", "", "", true, "355", "5");
        int f16 = (int) this.L0.f();
        int g16 = (int) this.L0.g();
        if (f16 < 0) {
            f16 = 0;
        }
        if (!r4()) {
            QQToast.makeText(BaseApplication.getContext(), this.f60012c1, 1).show();
            return;
        }
        this.R0 = true;
        if (QZLog.isColorLevel()) {
            QZLog.d(QzoneConfig.MAIN_KEY_TRIM, 2, "toPublishMood, startTime=" + f16 + ", endTime=" + g16 + ", duration=" + (g16 - f16));
        }
        boolean z16 = f16 != 0;
        QZLog.d(QzoneConfig.MAIN_KEY_TRIM, 4, "getThumbnail=" + z16);
        if (!z16) {
            str = "";
            i3 = 0;
            i16 = 0;
        } else {
            if (f60009r1) {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.O0);
                a16 = mediaMetadataRetriever.getFrameAtTime(f16 * 1000);
                mediaMetadataRetriever.release();
            } else {
                if (o71.b.d(this.O0, this.f60010a1, this.f60011b1) == 0 ? TrimNative.isGetFrameReady() : false) {
                    a16 = o71.b.a(f16, f16 + 1000);
                } else {
                    QZLog.w(QzoneConfig.MAIN_KEY_TRIM, "TrimNative.isGetFrameReady return false,thumbnail pic is null.");
                    if (!t4()) {
                        str4 = "";
                        bitmap = null;
                        i17 = 0;
                        i18 = 0;
                        if (bitmap != null) {
                        }
                    } else {
                        if (f16 > 1000) {
                            str4 = "";
                        } else {
                            str4 = this.f60026q1;
                        }
                        int i19 = this.f60024o1;
                        i17 = this.f60025p1;
                        i18 = i19;
                        bitmap = null;
                        if (bitmap != null) {
                            String str5 = bp.a.f28738b + File.separator + System.currentTimeMillis() + ".jpg";
                            if (com.qzone.util.image.c.V(bitmap, str5, Bitmap.CompressFormat.JPEG, 90, true)) {
                                str = str5;
                                i3 = bitmap.getWidth();
                                i16 = bitmap.getHeight();
                            } else {
                                QZLog.e(QzoneConfig.MAIN_KEY_TRIM, "save jpg failed");
                                QzoneVideoBeaconReport.reportVideoEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_VIDEO_TRIM, "4", null);
                                bp.b.d(1015);
                                i16 = i17;
                                i3 = i18;
                                str = "";
                            }
                        } else {
                            if (QZLog.isColorLevel()) {
                                QZLog.d(QzoneConfig.MAIN_KEY_TRIM, 2, "getFrame failed");
                            }
                            QzoneVideoBeaconReport.reportVideoEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_VIDEO_TRIM, "5", null);
                            bp.b.d(1014);
                            str = str4;
                            i16 = i17;
                            i3 = i18;
                        }
                    }
                }
            }
            bitmap = a16;
            str4 = "";
            i17 = 0;
            i18 = 0;
            if (bitmap != null) {
            }
        }
        QZLog.d(QzoneConfig.MAIN_KEY_TRIM, 4, "releaseAudioResource");
        bp.a.c();
        String stringExtra = getIntent().getStringExtra("refer");
        if (!t4()) {
            str2 = QzoneConfig.MAIN_KEY_TRIM;
            if (!TextUtils.isEmpty(this.X0) && this.X0.contains(PeakConstants.VIDEO_REFER_FROM_ALBUM)) {
                cp.b.c(this, 1, this.R0, this.O0, str, i3, i16, this.S0, f16, g16, this.P0, u5.b.h0(QZoneShareManager.QZONE_SHARE_VIDEO_TEXT, ""), stringExtra, this.X0);
            } else {
                QZLog.d(str2, 4, "launch publish mood");
                str3 = str2;
                cp.b.b(this, 1, this.R0, this.O0, str, i3, i16, this.S0, f16, g16, this.P0, u5.b.h0(QZoneShareManager.QZONE_SHARE_VIDEO_TEXT, ""), stringExtra, this.X0);
                QZLog.d(str3, 4, "send msg");
                this.f60022m1.sendEmptyMessage(1103);
            }
        } else {
            QLog.d(QzoneConfig.MAIN_KEY_TRIM, 2, "recode video open video preview activity.");
            long j3 = this.P0;
            String h06 = u5.b.h0(QZoneShareManager.QZONE_SHARE_VIDEO_TEXT, "");
            String str6 = this.X0;
            str2 = QzoneConfig.MAIN_KEY_TRIM;
            QZoneHelper.launchVideoCoverPreviewActivity(this, 1, null, this.R0, this.O0, str, i3, i16, this.S0, f16, g16, j3, 0, null, h06, stringExtra, str6, QzoneCoverConst.CoverStringType.COVER_TYPE_VIDEO_COVER);
        }
        str3 = str2;
        QZLog.d(str3, 4, "send msg");
        this.f60022m1.sendEmptyMessage(1103);
    }

    @Override // com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 4 && keyEvent.getRepeatCount() == 0) {
            onBackPressed();
            return true;
        }
        return super.onKeyDown(i3, keyEvent);
    }

    private void initData(Intent intent) {
        this.f60022m1.removeMessages(9999);
        this.f60021l1.setImageBitmap(null);
        this.f60021l1.setVisibility(8);
        this.O0 = intent.getStringExtra("file_send_path");
        this.P0 = intent.getLongExtra(PeakConstants.VIDEO_SIZE, 0L);
        long longExtra = intent.getLongExtra(ShortVideoConstants.FILE_SEND_DURATION, 0L);
        if (QZLog.isColorLevel()) {
            QZLog.d(QzoneConfig.MAIN_KEY_TRIM, 2, "initData, videoPath=" + this.O0 + ", videoSize=" + this.P0 + ", duration:" + longExtra);
        }
        this.W0 = intent.getIntExtra(QAlbumConstants.PHOTOLIST_KEY_SHOW_MEDIA, 2);
        this.X0 = intent.getStringExtra(PeakConstants.VIDEO_REFER);
        this.Y0 = intent.getStringExtra("refer");
        if (!TextUtils.isEmpty(this.O0)) {
            if (intent.getBooleanExtra(PeakConstants.IS_PREVIEW_VIDEO, false)) {
                String stringExtra = getIntent().getStringExtra("refer");
                if (!TextUtils.isEmpty(this.X0) && this.X0.contains(PeakConstants.VIDEO_REFER_FROM_MOOD)) {
                    cp.b.b(this, 1, this.R0, this.O0, null, 0, 0, this.S0, 0L, longExtra, this.P0, u5.b.h0(QZoneShareManager.QZONE_SHARE_VIDEO_TEXT, ""), stringExtra, this.X0);
                } else {
                    cp.b.c(this, 1, this.R0, this.O0, null, 0, 0, this.S0, 0L, longExtra, this.P0, u5.b.h0(QZoneShareManager.QZONE_SHARE_VIDEO_TEXT, ""), stringExtra, this.X0);
                }
                Intent intent2 = new Intent();
                intent2.putExtra("finish_video_component", true);
                setResult(-1, intent2);
                finish();
                return;
            }
            if (o71.a.a(this.O0) != 0) {
                if (QZLog.isColorLevel()) {
                    QZLog.d(QzoneConfig.MAIN_KEY_TRIM, 2, "format is not supported");
                }
                QzoneVideoBeaconReport.reportVideoEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_VIDEO_TRIM, "10", null);
                this.O0 = null;
                this.f60022m1.sendEmptyMessage(1101);
                return;
            }
            if (QZLog.isColorLevel()) {
                QZLog.d(QzoneConfig.MAIN_KEY_TRIM, 2, "setVideoPath:" + this.O0);
            }
            this.K0.setVideoPath(this.O0);
            this.f60022m1.sendEmptyMessageDelayed(9999, 10000L);
            return;
        }
        setResult(0);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i3, int i16, Intent intent) {
        if (1000 == i3 && i16 == -1) {
            finish();
        }
    }

    @Override // com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.VideoFrameSelectBar.a
    public void o1(float f16) {
    }
}
