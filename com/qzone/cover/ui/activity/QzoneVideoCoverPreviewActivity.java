package com.qzone.cover.ui.activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.qzone.business.vip.QZoneVIPUtils;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.QZoneTitleBarFragmentV2;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.IObserver;
import com.qzone.proxy.covercomponent.CoverComponentProxy;
import com.qzone.proxy.covercomponent.QzoneCoverConst;
import com.qzone.proxy.covercomponent.adapter.CoverResAdapter;
import com.qzone.proxy.covercomponent.ui.ICoverBaseView;
import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.util.ToastUtil;
import com.qzone.util.ag;
import com.qzone.widget.AsyncImageView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView;
import com.tencent.mobileqq.activity.shortvideo.a;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;
import cooperation.peak.PeakConstants;
import cooperation.qzone.model.CoverCacheData;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import cooperation.vip.vipcomponent.util.a;
import ho.i;
import ho.l;
import java.io.File;
import java.util.HashMap;

/* loaded from: classes39.dex */
public class QzoneVideoCoverPreviewActivity extends QZoneTitleBarFragmentV2 implements View.OnClickListener, IObserver.main {
    private int A0;
    private long B0;
    private long C0;
    private String D0;
    private boolean F0;
    private String H0;

    /* renamed from: h0, reason: collision with root package name */
    private View f46798h0;

    /* renamed from: i0, reason: collision with root package name */
    private CheckBox f46799i0;

    /* renamed from: j0, reason: collision with root package name */
    private FrameLayout f46800j0;

    /* renamed from: k0, reason: collision with root package name */
    private FixedSizeVideoView f46801k0;

    /* renamed from: l0, reason: collision with root package name */
    private Button f46802l0;

    /* renamed from: m0, reason: collision with root package name */
    private View f46803m0;

    /* renamed from: n0, reason: collision with root package name */
    private AsyncImageView f46804n0;

    /* renamed from: o0, reason: collision with root package name */
    private AsyncImageView f46805o0;

    /* renamed from: p0, reason: collision with root package name */
    private ICoverBaseView f46806p0;

    /* renamed from: q0, reason: collision with root package name */
    private TextView f46807q0;

    /* renamed from: r0, reason: collision with root package name */
    private String f46808r0;

    /* renamed from: s0, reason: collision with root package name */
    private String f46809s0;

    /* renamed from: t0, reason: collision with root package name */
    private String f46810t0;

    /* renamed from: u0, reason: collision with root package name */
    private String f46811u0;

    /* renamed from: y0, reason: collision with root package name */
    private int f46815y0;

    /* renamed from: z0, reason: collision with root package name */
    private String f46816z0;

    /* renamed from: v0, reason: collision with root package name */
    private int f46812v0 = 0;

    /* renamed from: w0, reason: collision with root package name */
    private int f46813w0 = 0;

    /* renamed from: x0, reason: collision with root package name */
    private int f46814x0 = 0;
    public boolean E0 = true;
    private boolean G0 = false;
    private Runnable I0 = new Runnable() { // from class: com.qzone.cover.ui.activity.QzoneVideoCoverPreviewActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (QzoneVideoCoverPreviewActivity.this.f46806p0 != null) {
                QzoneVideoCoverPreviewActivity.this.f46806p0.onInvisible();
                QzoneVideoCoverPreviewActivity.this.f46806p0.onVisible();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class a implements MediaPlayer.OnErrorListener {
        a() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i3, int i16) {
            if (QLog.isColorLevel()) {
                QLog.w("QzoneVideoCoverPreviewActivity", 2, "\u9884\u89c8\u89c6\u9891\u53d1\u751f\u9519\u8bef init error, mStartTime=" + QzoneVideoCoverPreviewActivity.this.B0 + ", mEndTime=" + QzoneVideoCoverPreviewActivity.this.C0 + ",what=" + i3 + ",extra=" + i16);
            }
            QzoneVideoCoverPreviewActivity.this.f46801k0.setVisibility(8);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class b implements FixedSizeVideoView.c {
        b() {
        }

        @Override // com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView.c
        public void a(FixedSizeVideoView fixedSizeVideoView, int i3, int i16) {
            fixedSizeVideoView.pause();
            fixedSizeVideoView.seekTo(i3);
            fixedSizeVideoView.start();
        }

        @Override // com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView.c
        public void b(MediaPlayer mediaPlayer) {
            mediaPlayer.seekTo((int) QzoneVideoCoverPreviewActivity.this.B0);
            mediaPlayer.start();
        }
    }

    private boolean Ai() {
        return 1 == this.f46815y0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Bi() {
        if (TextUtils.isEmpty(this.f46811u0)) {
            QZLog.w("QzoneVideoCoverPreviewActivity", "video source path is empty,cannot set cover.");
            ToastUtil.o(R.string.glj, 4);
            return;
        }
        if (TextUtils.isEmpty(this.f46810t0)) {
            QZLog.w("QzoneVideoCoverPreviewActivity", "video thumb path is empty,cannot set cover.");
            ToastUtil.o(R.string.gpi, 4);
            return;
        }
        if (this.f46813w0 > 0 && this.f46814x0 > 0) {
            q6.a.b().k(getHandler(), this.D0, this.f46816z0, this.f46810t0, this.f46811u0, this.f46813w0, this.f46814x0, !zi() ? 1 : 0);
            Hi();
            Ji();
            return;
        }
        QZLog.w("QzoneVideoCoverPreviewActivity", "video width=" + this.f46813w0 + ",height=" + this.f46814x0 + ",cannot set cover.");
        ToastUtil.o(R.string.gph, 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Di(MediaPlayer mediaPlayer) {
        int videoWidth = mediaPlayer.getVideoWidth();
        int videoHeight = mediaPlayer.getVideoHeight();
        mediaPlayer.setVolume(0.0f, 0.0f);
        ViewGroup.LayoutParams layoutParams = this.f46801k0.getLayoutParams();
        oi(layoutParams, videoWidth, videoHeight);
        this.f46801k0.setLayoutParams(layoutParams);
        QZLog.i("QzoneVideoCoverPreviewActivity", "duration is " + this.f46801k0.b());
        long j3 = this.B0;
        if (j3 >= 0) {
            long j16 = this.C0;
            if (j16 >= 0) {
                this.f46801k0.setPlayDuration((int) j3, (int) (j16 - j3));
            }
        }
        this.f46801k0.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ei() {
        try {
            int i3 = 1;
            int i16 = zi() ? 1 : 0;
            if (!FeedVideoEnv.isWifiConnected()) {
                i3 = 0;
            }
            String ui5 = ui(this.f46815y0);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("send_feed", String.valueOf(i16));
            hashMap.put("video_from", ui5);
            hashMap.put("iswifi", String.valueOf(i3));
            StatisticCollector.getInstance(getApplicationContext()).collectPerformance(LoginData.getInstance().getUinString(), QzoneCoverConst.EVENT_CODE_VIDEO_COVER_SET, true, 0L, 0L, hashMap, null);
        } catch (Throwable th5) {
            QZLog.e("QzoneVideoCoverPreviewActivity", "qzone video cover preview report dengta exception:", th5);
        }
    }

    private void Fi() {
        try {
            if (QZLog.isColorLevel()) {
                QZLog.i("QzoneVideoCoverPreviewActivity", 2, "noticeWebviewIfSetCoverSuccess start");
            }
            Intent intent = new Intent("com.tencent.mobileqq.action.ACTION_VIDEO_COVER_SETTING");
            intent.putExtras(getIntent());
            intent.putExtra(PeakConstants.INTENT_COVER_SETTING_TYPE, 1);
            intent.putExtra(PeakConstants.COVER_ID, this.D0);
            BaseApplication.getContext().sendBroadcast(intent, "com.tencent.msg.permission.pushnotify");
        } catch (Throwable th5) {
            th5.printStackTrace();
            QZLog.e("QzoneVideoCoverPreviewActivity", "noticeWebviewIfSetCoverSuccess exception", th5);
        }
    }

    private void Gi() {
        try {
            if (QZLog.isColorLevel()) {
                QZLog.i("QzoneVideoCoverPreviewActivity", 2, "noticeWebviewIfUnsetCoverSuccess start");
            }
            Intent intent = new Intent("com.tencent.mobileqq.action.ACTION_VIDEO_COVER_SETTING");
            intent.putExtras(getIntent());
            intent.putExtra(PeakConstants.INTENT_COVER_SETTING_TYPE, 2);
            intent.putExtra(PeakConstants.COVER_ID, this.D0);
            BaseApplication.getContext().sendBroadcast(intent, "com.tencent.msg.permission.pushnotify");
        } catch (Throwable th5) {
            th5.printStackTrace();
            QZLog.e("QzoneVideoCoverPreviewActivity", "noticeWebviewIfUnsetCoverSuccess exception", th5);
        }
    }

    private void Hi() {
        try {
            if (QZLog.isColorLevel()) {
                QZLog.i("QzoneVideoCoverPreviewActivity", 2, "notifyWebviewIfSetCoverStarted start");
            }
            Intent intent = new Intent("com.tencent.mobileqq.action.ACTION_VIDEO_COVER_SETTING");
            intent.putExtras(getIntent());
            intent.putExtra(PeakConstants.INTENT_COVER_SETTING_TYPE, 0);
            BaseApplication.getContext().sendBroadcast(intent, "com.tencent.msg.permission.pushnotify");
        } catch (Throwable th5) {
            th5.printStackTrace();
            QZLog.e("QzoneVideoCoverPreviewActivity", "notifyWebviewIfSetCoverStarted exception", th5);
        }
    }

    private void Ii() {
        Ni();
        if (this.F0) {
            Ki();
            return;
        }
        if (QZoneVIPUtils.b(this.A0)) {
            if (LoginData.getInstance().isSuperQzoneVip()) {
                Ki();
                return;
            }
            String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "HuangzuanLuxuryUpgrade", "\u5347\u7ea7\u8c6a\u534e\u9ec4\u94bb");
            String config2 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "HuangzuanLuxuryBuy", "\u5f00\u901a\u8c6a\u534e\u9ec4\u94bb");
            if (!LoginData.getInstance().isQzoneVip()) {
                config = config2;
            }
            this.f46807q0.setText(config);
            ((ImageView) findViewById(R.id.hlg)).setImageResource(R.drawable.g0b);
            Li();
            return;
        }
        if (QZoneVIPUtils.c(this.A0)) {
            if (LoginData.getInstance().isQzoneVip()) {
                Ki();
                return;
            }
            this.f46807q0.setText(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "HuangzuanBuy", "\u5f00\u901a\u9ec4\u94bb"));
            Li();
            return;
        }
        Ki();
    }

    private void Ji() {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(new Runnable() { // from class: com.qzone.cover.ui.activity.d
            @Override // java.lang.Runnable
            public final void run() {
                QzoneVideoCoverPreviewActivity.this.Ei();
            }
        });
    }

    private void Ki() {
        this.f46803m0.setVisibility(4);
        this.f46802l0.setVisibility(0);
    }

    private void Li() {
        this.f46803m0.setVisibility(0);
        this.f46802l0.setVisibility(4);
    }

    private void Mi() {
        if (this.G0) {
            return;
        }
        this.G0 = true;
        ToastUtil.o(R.string.gpn, 3);
        q6.a.b().a(getHandler());
    }

    private void Ni() {
        if (!this.F0) {
            this.f46802l0.setText(R.string.gnw);
        } else {
            this.f46802l0.setText(R.string.got);
        }
    }

    private static int getScreenWidth() {
        return u5.a.d();
    }

    private void ni() {
        EventCenter.getInstance().addUIObserver(this, a.C10129a.f391398a, 11);
    }

    private void pi() {
        if (!Ai() && !yi()) {
            if (xi()) {
                qi();
                return;
            } else {
                ToastUtil.o(R.string.gpj, 4);
                return;
            }
        }
        ri();
    }

    private void qi() {
        if (getIntent() == null || this.G0) {
            return;
        }
        this.G0 = true;
        ToastUtil.o(R.string.gpn, 3);
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.cover.ui.activity.c
            @Override // java.lang.Runnable
            public final void run() {
                QzoneVideoCoverPreviewActivity.this.Bi();
            }
        });
    }

    private void ri() {
        final Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.cover.ui.activity.b
            @Override // java.lang.Runnable
            public final void run() {
                QzoneVideoCoverPreviewActivity.this.Ci(intent);
            }
        });
    }

    private String si() {
        if (yi()) {
            return ti();
        }
        return this.f46811u0;
    }

    private String ti() {
        a.C7209a b16 = com.tencent.mobileqq.activity.shortvideo.a.b(this.f46811u0);
        if (b16 != null) {
            return b16.f186311a;
        }
        QLog.d("QzoneVideoCoverPreviewActivity", 2, "getPlayVideoPath null");
        return null;
    }

    private void vi() {
        if (this.F0) {
            Mi();
            return;
        }
        pi();
        int i3 = this.f46815y0;
        if (i3 == 0 || i3 == 1) {
            finish();
        }
    }

    private void wi() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getScreenWidth(), (int) (getScreenWidth() * 0.75d), 17);
        FixedSizeVideoView fixedSizeVideoView = new FixedSizeVideoView(getApplicationContext());
        this.f46801k0 = fixedSizeVideoView;
        this.f46800j0.addView(fixedSizeVideoView, layoutParams);
        this.f46801k0.setOnErrorListener(new a());
        this.f46801k0.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.qzone.cover.ui.activity.a
            @Override // android.media.MediaPlayer.OnPreparedListener
            public final void onPrepared(MediaPlayer mediaPlayer) {
                QzoneVideoCoverPreviewActivity.this.Di(mediaPlayer);
            }
        });
        this.f46801k0.setOnFixVDPlayCompelteListener(new b());
        String si5 = si();
        QZLog.i("QzoneVideoCoverPreviewActivity", "play video url:" + si5);
        this.f46801k0.setVideoPath(si5);
    }

    private boolean yi() {
        return this.f46815y0 == 0;
    }

    private boolean zi() {
        CheckBox checkBox = this.f46799i0;
        return checkBox != null && checkBox.isChecked();
    }

    @Override // com.qzone.common.activities.base.QZoneTitleBarFragmentV2
    public void Gh() {
        if (this.C == null) {
            this.F = (ViewGroup) this.f46798h0.findViewById(R.id.f166673ha1);
            this.R = (ViewGroup) this.f46798h0.findViewById(R.id.f166672ha0);
            this.I = (ViewGroup) this.f46798h0.findViewById(R.id.h_w);
            QZoneTitleBarFragmentV2.setLayerType(this.F);
            Oh(this.F);
            Qh(this.F);
            Wh(getIntent());
        }
    }

    @Override // com.qzone.common.activities.base.QZoneTitleBarFragmentV2
    public boolean Kh() {
        return this.E0;
    }

    @Override // com.qzone.common.activities.base.QZoneTitleBarFragmentV2
    protected boolean Mh() {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.ip6) {
            QZLog.i("QzoneVideoCoverPreviewActivity", 1, "click cover button");
            vi();
        } else if (id5 == R.id.hld) {
            QZLog.i("QzoneVideoCoverPreviewActivity", 1, "click open vip button");
            ((l) i.t(l.class)).a(getActivity(), 1, this.A0, this.f46816z0);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = LayoutInflater.from(layoutInflater.getContext()).inflate(R.layout.bsn, (ViewGroup) null);
        this.f46798h0 = inflate;
        return Uh(layoutInflater, inflate, viewGroup);
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        ICoverBaseView iCoverBaseView;
        super.onDestroy();
        if (QLog.isColorLevel()) {
            QLog.d("QzoneVideoCoverPreviewActivity", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        if (!xi() || (iCoverBaseView = this.f46806p0) == null) {
            return;
        }
        iCoverBaseView.onDestroy();
    }

    @Override // com.qzone.common.event.IObserver.main
    public void onEventUIThread(Event event) {
        if (a.C10129a.f391398a.equals(event.source.getName()) && event.what == 11) {
            QZLog.i("QzoneVideoCoverPreviewActivity", "\u6536\u5230\u9ec4\u94bb\u4fe1\u606f\u53d8\u5316\u901a\u77e5\uff0c\u66f4\u65b0UI");
            Ii();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.BaseFragment
    public void onHandleMessage(Message message) {
        super.onHandleMessage(message);
        QZoneResult unpack = QZoneResult.unpack(message);
        if (unpack == null) {
            return;
        }
        int i3 = unpack.what;
        if (i3 == 1000011) {
            if (unpack.getSucceed()) {
                Fi();
                ToastUtil.o(R.string.gpm, 5);
                finish();
            }
            this.G0 = false;
            return;
        }
        if (i3 != 1000147) {
            return;
        }
        if (unpack.getSucceed()) {
            Gi();
            ToastUtil.o(R.string.gpm, 5);
            finish();
        }
        this.G0 = false;
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        ICoverBaseView iCoverBaseView;
        super.onPause();
        if (yi()) {
            FixedSizeVideoView fixedSizeVideoView = this.f46801k0;
            if (fixedSizeVideoView != null) {
                fixedSizeVideoView.pause();
                return;
            }
            return;
        }
        if (Ai()) {
            FixedSizeVideoView fixedSizeVideoView2 = this.f46801k0;
            if (fixedSizeVideoView2 != null) {
                fixedSizeVideoView2.pause();
                return;
            }
            return;
        }
        if (!xi() || (iCoverBaseView = this.f46806p0) == null) {
            return;
        }
        iCoverBaseView.onPause();
    }

    @Override // com.qzone.common.activities.base.QZoneTitleBarFragmentV2, com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        ICoverBaseView iCoverBaseView;
        super.onResume();
        if (yi()) {
            FixedSizeVideoView fixedSizeVideoView = this.f46801k0;
            if (fixedSizeVideoView != null) {
                fixedSizeVideoView.start();
                return;
            }
            return;
        }
        if (Ai()) {
            FixedSizeVideoView fixedSizeVideoView2 = this.f46801k0;
            if (fixedSizeVideoView2 != null) {
                fixedSizeVideoView2.start();
                return;
            }
            return;
        }
        if (!xi() || (iCoverBaseView = this.f46806p0) == null) {
            return;
        }
        iCoverBaseView.onResume();
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        FixedSizeVideoView fixedSizeVideoView;
        super.onStop();
        if (yi()) {
            FixedSizeVideoView fixedSizeVideoView2 = this.f46801k0;
            if (fixedSizeVideoView2 != null) {
                fixedSizeVideoView2.suspend();
            }
        } else if (Ai() && (fixedSizeVideoView = this.f46801k0) != null) {
            fixedSizeVideoView.suspend();
        }
        getHandler().removeCallbacks(this.I0);
    }

    @Override // com.qzone.common.activities.base.QZoneTitleBarFragmentV2, com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        initUI();
        initData();
    }

    private void initUI() {
        ai(0);
        setTitle(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "VideoCoverPreviewTitle", "\u9884\u89c8"));
        this.f46799i0 = (CheckBox) this.f46798h0.findViewById(R.id.iqt);
        this.f46800j0 = (FrameLayout) this.f46798h0.findViewById(R.id.kwo);
        this.f46804n0 = (AsyncImageView) this.f46798h0.findViewById(R.id.f164921bb4);
        this.f46805o0 = (AsyncImageView) this.f46798h0.findViewById(R.id.bbc);
        Button button = (Button) this.f46798h0.findViewById(R.id.ip6);
        this.f46802l0 = button;
        button.setOnClickListener(this);
        View findViewById = this.f46798h0.findViewById(R.id.hld);
        this.f46803m0 = findViewById;
        findViewById.setOnClickListener(this);
        this.f46807q0 = (TextView) this.f46798h0.findViewById(R.id.hlh);
        ViewGroup.LayoutParams layoutParams = this.f46800j0.getLayoutParams();
        layoutParams.width = getScreenWidth();
        layoutParams.height = (int) (getScreenWidth() / 1.4150943396226414d);
        this.f46800j0.setLayoutParams(layoutParams);
    }

    private boolean xi() {
        return 2 == this.f46815y0;
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent == null) {
            QQToast.makeText(getApplicationContext(), QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "VideoPreviewNoParam", "\u9884\u89c8\u89c6\u9891\u65e0\u53c2\u6570"), 1).show();
            finish();
            return;
        }
        this.f46808r0 = intent.getStringExtra("refer");
        this.f46809s0 = intent.getStringExtra(PeakConstants.VIDEO_REFER);
        this.f46810t0 = intent.getStringExtra(PeakConstants.VIDEO_THUMBNAIL_PATH);
        this.f46811u0 = intent.getStringExtra("file_send_path");
        Bundle bundleExtra = intent.getBundleExtra(ShortVideoConstants.ENCODE_VIDEO_PARAMS);
        if (bundleExtra != null) {
            this.f46812v0 = bundleExtra.getInt(ShortVideoConstants.SV_TOTAL_FRAME_COUNT);
        }
        this.f46815y0 = intent.getIntExtra(PeakConstants.VIDEO_TYPE, -1);
        this.f46813w0 = intent.getIntExtra(PeakConstants.VIDEO_THUMBNAIL_WIDTH, 0);
        this.f46814x0 = intent.getIntExtra(PeakConstants.VIDEO_THUMBNAIL_HEIGHT, 0);
        this.B0 = intent.getLongExtra("start_time", -1L);
        this.C0 = intent.getLongExtra("end_time", -1L);
        this.D0 = intent.getStringExtra(PeakConstants.QZONE_ALBUM_VIDEO_ID);
        String stringExtra = intent.getStringExtra("name");
        this.H0 = stringExtra;
        if (TextUtils.isEmpty(stringExtra)) {
            this.H0 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "VideoBackground", "\u89c6\u9891\u80cc\u666f");
        }
        ((TextView) findViewById(R.id.jja)).setText(this.H0);
        this.A0 = intent.getIntExtra(PeakConstants.COVER_TYPE, 1);
        String stringExtra2 = intent.getStringExtra("COVER_STRING_TYPE");
        this.f46816z0 = stringExtra2;
        if (TextUtils.isEmpty(stringExtra2)) {
            this.f46816z0 = QzoneCoverConst.CoverStringType.COVER_TYPE_NEW_VIDEO_COVER;
        }
        CoverComponentProxy coverComponentProxy = CoverComponentProxy.f50099g;
        CoverCacheData coverFromCache = coverComponentProxy.getServiceInterface().getCoverFromCache(LoginData.getInstance().getUin());
        this.F0 = (coverFromCache == null || TextUtils.isEmpty(coverFromCache.coverId) || !coverFromCache.coverId.equals(this.D0)) ? false : true;
        Ii();
        String str = this.f46810t0;
        if (str != null && str.length() > 0) {
            this.f46804n0.setAsyncImage(this.f46810t0);
        } else {
            this.f46804n0.setAsyncImage(coverComponentProxy.getServiceInterface().getDefaultCover());
        }
        int i3 = this.A0;
        if ((i3 & 2) == 2) {
            this.f46805o0.setAsyncImage("https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_cover_type_limit_free.png");
            this.f46805o0.setVisibility(0);
        } else if ((i3 & 512) == 512) {
            this.f46805o0.setAsyncImage("https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_cover_type_limit_super_vip.png");
            this.f46805o0.setVisibility(0);
        } else if ((i3 & 1) == 1) {
            this.f46805o0.setAsyncImage("https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_cover_type_limit_vip.png");
            this.f46805o0.setVisibility(0);
        } else {
            this.f46805o0.setVisibility(8);
        }
        if (QZLog.isColorLevel()) {
            QZLog.i("QzoneVideoCoverPreviewActivity", 1, (((((((((("mVideoType=" + this.f46815y0 + " , (0\u8868\u793a\u5f55\u5236, 1\u8868\u793a\u88c1\u526a,2\u7a7a\u95f4\u76f8\u518c\u89c6\u9891)") + ",mThumbnailPath=" + this.f46810t0) + ",mSourcePath=" + this.f46811u0) + ",mVideoWidth=" + this.f46813w0) + ",mVideoHeight=" + this.f46814x0) + ",mStartTime=" + this.B0) + ",mEndTime=" + this.C0) + ",mRefer=" + this.f46808r0) + ",mReferActivityName=" + this.f46809s0) + ",mCoverType=" + this.A0) + ",mName=" + this.H0);
        }
        if (Ai()) {
            if (this.B0 >= 0 && this.C0 >= 0) {
                wi();
            } else {
                ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "VideoPreviewParamError", "\u9884\u89c8\u89c6\u9891\u53c2\u6570\u9519\u8bef"), 4);
                if (QLog.isColorLevel()) {
                    QLog.w("QzoneVideoCoverPreviewActivity", 2, "init error, mStartTime=" + this.B0 + ", mEndTime=" + this.C0);
                }
                finish();
                return;
            }
        } else if (xi()) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(QzoneCoverConst.KEY_VIDEO_COVER_STATUS, "2");
            hashMap.put(QzoneCoverConst.KEY_VIDEO_ID, "coverPreview_" + System.currentTimeMillis());
            hashMap.put(QzoneCoverConst.KEY_VIDEO_COVER_PIC, this.f46810t0);
            hashMap.put(QzoneCoverConst.KEY_VIDEO_COVER_PLAY_URL, this.f46811u0);
            hashMap.put(QzoneCoverConst.KEY_VIDEO_COVER_PIC_WIDTH, String.valueOf(this.f46813w0));
            hashMap.put(QzoneCoverConst.KEY_VIDEO_COVER_PIC_HEIGHT, String.valueOf(this.f46814x0));
            long j3 = this.B0;
            if (j3 >= 0) {
                hashMap.put(QzoneCoverConst.KEY_VIDEO_COVER_START_TIME, String.valueOf(j3));
            }
            long j16 = this.B0;
            if (j16 >= 0) {
                long j17 = this.C0;
                if (j17 > 0 && j17 - j16 > 0) {
                    hashMap.put(QzoneCoverConst.KEY_VIDEO_COVER_DURATION, String.valueOf(j17 - j16));
                }
            }
            this.f46806p0 = coverComponentProxy.getUiInterface().getCoverVideoCoverView(BaseApplication.getContext(), getActivity(), this.f46800j0, LoginData.getInstance().getUin(), hashMap, CoverResAdapter.getInstance(), this.f46816z0.equals(QzoneCoverConst.CoverStringType.COVER_TYPE_NEW_VIDEO_COVER) ? 15 : 9);
            if (this.f46800j0.getChildCount() == 1) {
                View childAt = this.f46800j0.getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.topMargin = (int) (getScreenWidth() * 0.125d * (-1.0d));
                    childAt.setLayoutParams(layoutParams);
                }
            }
            getHandler().postDelayed(this.I0, 1000L);
        } else if (yi()) {
            if (!TextUtils.isEmpty(this.f46811u0)) {
                wi();
            }
        } else {
            QLog.e("QzoneVideoCoverPreviewActivity", 1, "unknown video type=" + this.f46815y0);
            ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "VideoUnknowType", "\u672a\u77e5\u7684\u89c6\u9891\u7c7b\u578b"), 4);
            finish();
        }
        ni();
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        if (i3 == 1) {
            z5.a.f().q(LoginData.getInstance().getUin(), null);
            if (i16 != -1) {
                QZLog.i("QzoneVideoCoverPreviewActivity", "\u53d6\u6d88\u5f00\u901a\u9ec4\u94bb");
            } else {
                QZLog.i("QzoneVideoCoverPreviewActivity", 1, "pay finish");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ci(Intent intent) {
        String str;
        int i3;
        if (TextUtils.isEmpty(this.f46811u0)) {
            ToastUtil.o(R.string.glj, 4);
            QZLog.d("QzoneVideoCoverPreviewActivity", 2, "video file not exist:" + this.f46811u0);
            return;
        }
        if (!new File(this.f46811u0).exists()) {
            ToastUtil.o(R.string.glj, 4);
            QZLog.d("QzoneVideoCoverPreviewActivity", 2, "video file not exist:" + this.f46811u0);
            return;
        }
        long longExtra = intent.getLongExtra(ShortVideoConstants.FILE_SEND_DURATION, 0L);
        ShuoshuoVideoInfo q16 = ag.q(this.f46811u0, intent.getLongExtra(PeakConstants.VIDEO_SIZE, 0L), this.f46815y0, this.f46810t0, intent.getIntExtra(PeakConstants.VIDEO_THUMBNAIL_HEIGHT, 0), intent.getIntExtra(PeakConstants.VIDEO_THUMBNAIL_WIDTH, 0), this.B0, longExtra, intent.getLongExtra(PeakConstants.VIDEO_TOTAL_DURATION, longExtra), intent.getBooleanExtra(PeakConstants.VIDEO_NEED_PROCESS, false), intent.getBundleExtra(ShortVideoConstants.ENCODE_VIDEO_PARAMS));
        if (q16 == null) {
            QZLog.w("QzoneVideoCoverPreviewActivity", "prepareVideoInfos return null");
            return;
        }
        q16.mIsNew = 106;
        q16.mIsUploadOrigin = true;
        if (this.f46815y0 == 1) {
            i3 = 211;
            str = "1001";
        } else {
            str = "1000";
            i3 = 210;
        }
        QZoneWriteOperationService.v0().t2(q16, i3, zi(), null, null, null, "shuoshuoOther", str);
        Hi();
        Ji();
    }

    private static String ui(int i3) {
        if (i3 == 0) {
            return QQPermissionConstants.Permission.AUIDO_GROUP;
        }
        if (i3 == 1) {
            return "local";
        }
        if (i3 != 2) {
            return "unknown";
        }
        return "album";
    }

    private void oi(ViewGroup.LayoutParams layoutParams, int i3, int i16) {
        if (layoutParams == null || i3 <= 0 || i16 <= 0) {
            return;
        }
        if (i3 <= i16) {
            int screenWidth = getScreenWidth();
            layoutParams.width = screenWidth;
            layoutParams.height = (int) ((screenWidth / i3) * i16);
        } else {
            int screenWidth2 = getScreenWidth();
            layoutParams.width = (int) (i3 * (screenWidth2 / i16));
            layoutParams.height = screenWidth2;
        }
    }
}
