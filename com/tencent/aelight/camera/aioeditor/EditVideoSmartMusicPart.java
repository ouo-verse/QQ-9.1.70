package com.tencent.aelight.camera.aioeditor;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.aelight.camera.aioeditor.SmartMusicAdapter;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager;
import com.tencent.aelight.camera.aioeditor.takevideo.ac;
import com.tencent.aelight.camera.aioeditor.takevideo.u;
import com.tencent.aelight.camera.aioeditor.takevideo.x;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.aelight.camera.report.api.IAEBaseReportParam;
import com.tencent.aelight.camera.watermark.api.IAEWaterMarkManager;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.network.request.SmartMusicMatchRequest;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.biz.videostory.video.FrameVideoHelper;
import com.tencent.biz.videostory.video.VsMediaPlayer;
import com.tencent.biz.videostory.widget.easylyric.SingleLyricView;
import com.tencent.biz.videostory.widget.easylyric.h;
import com.tencent.biz.videostory.widget.view.smartmusicview.VsMusicItemInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.bubble.QQAnimationDrawable;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.editor.params.EditLocalVideoSource;
import com.tencent.mobileqq.editor.params.EditTakeVideoSource;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qcircle.weseevideo.editor.sticker.music.LyricParseHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LiuHaiUtils;
import com.tencent.util.WeakReferenceHandler;
import common.config.service.QzoneConfig;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import qqcircle.QQCircleSmartMatchMusic$MusicInfo;
import qqcircle.QQCircleSmartMatchMusic$SmartMatchMusicRsp;

/* loaded from: classes32.dex */
public class EditVideoSmartMusicPart extends u implements com.tencent.aelight.camera.aioeditor.takevideo.f, View.OnClickListener, Handler.Callback, VsMediaPlayer.a {
    private TextView C;
    private WeakReferenceHandler D;
    private VsMusicItemInfo E;
    private SmartMusicAdapter.b F;
    private View G;
    private View H;
    public float I;
    public float J;
    public int K;
    private x L;
    private boolean M;
    private boolean N;
    private boolean P;
    private Vibrator Q;
    private Drawable R;
    private Drawable S;
    private boolean T;
    private SingleLyricView U;
    private LocalMediaInfo V;
    private String W;
    private String X;
    private FrameVideoHelper Y;
    private ImageView Z;

    /* renamed from: a0, reason: collision with root package name */
    private View f66243a0;

    /* renamed from: b0, reason: collision with root package name */
    private View f66244b0;

    /* renamed from: c0, reason: collision with root package name */
    private View f66245c0;

    /* renamed from: d, reason: collision with root package name */
    private final String f66246d;

    /* renamed from: d0, reason: collision with root package name */
    private TextView f66247d0;

    /* renamed from: e, reason: collision with root package name */
    private RelativeLayout f66248e;

    /* renamed from: e0, reason: collision with root package name */
    private ArrayList<FrameVideoHelper.FrameBuffer> f66249e0;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f66250f;

    /* renamed from: f0, reason: collision with root package name */
    private long f66251f0;

    /* renamed from: g0, reason: collision with root package name */
    private long f66252g0;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f66253h;

    /* renamed from: h0, reason: collision with root package name */
    private long f66254h0;

    /* renamed from: i, reason: collision with root package name */
    private SmartMusicRecyclerView f66255i;

    /* renamed from: i0, reason: collision with root package name */
    private long f66256i0;

    /* renamed from: j0, reason: collision with root package name */
    private TextView f66257j0;

    /* renamed from: k0, reason: collision with root package name */
    private HashMap<String, String> f66258k0;

    /* renamed from: l0, reason: collision with root package name */
    private boolean f66259l0;

    /* renamed from: m, reason: collision with root package name */
    private SmartMusicAdapter f66260m;

    /* renamed from: m0, reason: collision with root package name */
    private int f66261m0;

    /* renamed from: n0, reason: collision with root package name */
    private VsMediaPlayer f66262n0;

    /* renamed from: o0, reason: collision with root package name */
    private int f66263o0;

    /* renamed from: p0, reason: collision with root package name */
    private boolean f66264p0;

    /* renamed from: q0, reason: collision with root package name */
    private boolean f66265q0;

    /* renamed from: r0, reason: collision with root package name */
    private boolean f66266r0;

    /* renamed from: s0, reason: collision with root package name */
    private long f66267s0;

    /* renamed from: t0, reason: collision with root package name */
    private int f66268t0;

    /* renamed from: u0, reason: collision with root package name */
    private QQAnimationDrawable f66269u0;

    /* renamed from: v0, reason: collision with root package name */
    private FrameLayout f66270v0;

    /* renamed from: w0, reason: collision with root package name */
    private ImageView f66271w0;

    /* renamed from: x0, reason: collision with root package name */
    private File f66272x0;

    /* renamed from: y0, reason: collision with root package name */
    private String f66273y0;

    /* renamed from: z0, reason: collision with root package name */
    protected BroadcastReceiver f66274z0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            EditVideoSmartMusicPart.this.f66247d0.setVisibility(8);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            EditVideoSmartMusicPart.this.f66257j0.setVisibility(8);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class e implements VSDispatchObserver.OnVSRspCallBack<QQCircleSmartMatchMusic$SmartMatchMusicRsp> {
        e() {
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleSmartMatchMusic$SmartMatchMusicRsp qQCircleSmartMatchMusic$SmartMatchMusicRsp) {
            long currentTimeMillis = System.currentTimeMillis() - EditVideoSmartMusicPart.this.f66252g0;
            VSReporter.q("edit_smart_music", VSReporter.f(j3, currentTimeMillis, "", 0L));
            EditVideoSmartMusicPart.this.D0(HardCodeUtil.qqStr(R.string.m2u) + currentTimeMillis + "ms");
            EditVideoSmartMusicPart.this.R0(z16, j3, str, qQCircleSmartMatchMusic$SmartMatchMusicRsp);
        }
    }

    /* loaded from: classes32.dex */
    class f extends BroadcastReceiver {
        f() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT".equals(intent.getAction())) {
                EditVideoSmartMusicPart.this.Q0(intent);
                EditVideoSmartMusicPart.this.o1();
                EditVideoSmartMusicPart.this.Z0();
            }
        }
    }

    /* loaded from: classes32.dex */
    public interface g {
        void a(int i3, VsMusicItemInfo vsMusicItemInfo);

        void b(int i3, SmartMusicAdapter.b bVar);

        void c(VsMusicItemInfo vsMusicItemInfo, int i3, boolean z16);
    }

    public EditVideoSmartMusicPart(EditVideoPartManager editVideoPartManager) {
        super(editVideoPartManager);
        this.f66246d = "EditVideoSmartMusicPart";
        this.D = new WeakReferenceHandler(Looper.getMainLooper(), this);
        this.I = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_QQ_STORY_VIDEO_SETTING, QzoneConfig.SECONDARY_AUDIO_MIX_ORIGINAL_VOLUME, 0.7f);
        this.J = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_QQ_STORY_VIDEO_SETTING, QzoneConfig.SECONDARY_AUDIO_MIX_MUSIC_VOLUME, 1.0f);
        this.M = true;
        this.f66256i0 = 0L;
        this.f66258k0 = new HashMap<>();
        this.f66267s0 = System.currentTimeMillis();
        this.f66268t0 = -1;
        this.f66273y0 = (String) VSConfigManager.c().e("KEY_SMART_MUSIC_ENTER_ANIM_DOWNLOAD_URL", "https://downv6.qq.com/video_story/smart_music_anim.zip");
        this.f66274z0 = new f();
    }

    private void G0() {
        File file = new File("/storage/emulated/0/Tencent/MobileQQ/video_story/smart_music_anim/");
        if (!file.exists() || file.listFiles() == null) {
            return;
        }
        if (file.listFiles().length < 25) {
            File file2 = this.f66272x0;
            if (file2 != null) {
                file2.delete();
            }
            file.delete();
            QLog.i("EditVideoSmartMusicPart", 1, "anim file is not complete and delete");
            return;
        }
        QLog.i("EditVideoSmartMusicPart", 1, "anim file is exist and complete");
    }

    private void H(boolean z16) {
        if (this.T || P0() == null) {
            return;
        }
        P0().K(this.N);
        P0().setVolume(K0(1));
        if (z16) {
            this.mParent.s(Message.obtain(null, 3, 1, 0));
        } else {
            this.mParent.s(Message.obtain(null, 3, 2, 0));
        }
    }

    private void H0() {
        ImageView imageView = this.f66271w0;
        if (imageView != null) {
            imageView.setImageDrawable(null);
            this.f66271w0.setVisibility(8);
        }
        QQAnimationDrawable qQAnimationDrawable = this.f66269u0;
        if (qQAnimationDrawable != null) {
            qQAnimationDrawable.stop();
        }
        ImageView imageView2 = this.Z;
        if (imageView2 != null) {
            imageView2.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I0() {
        if (!this.f66259l0 && this.f66261m0 == 0) {
            J0();
            VSReporter.m("mystatus_edit", "musiclib_entry_clk", 0, 0, new String[0]);
        }
        boolean z16 = !this.M;
        this.M = z16;
        if (!z16) {
            p1(this.E);
            this.f66253h.setBackgroundDrawable(this.R);
        } else {
            this.f66262n0.s();
            this.f66253h.setBackgroundDrawable(this.S);
        }
        i1();
    }

    private void J0() {
        q1();
        this.f66254h0 = System.currentTimeMillis();
        ArrayList<FrameVideoHelper.FrameBuffer> arrayList = this.f66249e0;
        if (arrayList != null && arrayList.size() != 0) {
            D0("\u62bd\u5e27\u8017\u65f6\uff1a0ms\n\u62bd\u53d6\u56fe\u7247\u6570\uff1a" + this.f66249e0.size() + "\n\u62bd\u5e27\u5b57\u8282\u6570\uff1a" + (this.f66251f0 / 1000) + "KB");
            h1(this.f66249e0);
            return;
        }
        if (this.V == null) {
            QLog.w("EditVideoSmartMusicPart", 1, "mLocalMediaInfo is null stop extractFrame");
            return;
        }
        D0(HardCodeUtil.qqStr(R.string.m3n));
        String str = this.W;
        LocalMediaInfo localMediaInfo = this.V;
        FrameVideoHelper frameVideoHelper = new FrameVideoHelper(str, localMediaInfo.mediaWidth, localMediaInfo.mediaHeight, localMediaInfo.mDuration);
        this.Y = frameVideoHelper;
        frameVideoHelper.x(this.f66256i0, new d());
    }

    private x P0() {
        if (this.L == null) {
            this.L = (x) this.mParent.R(x.class);
        }
        return this.L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q0(Intent intent) {
        String stringExtra = intent.getStringExtra("data");
        String stringExtra2 = intent.getStringExtra("event");
        if (TextUtils.isEmpty(stringExtra2) || !stringExtra2.equals(QQWinkConstants.JS_PLUGIN_EVENT_SELECT_MUSIC) || this.P) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("EditVideoSmartMusicPart", 2, "mMusicReceiver onReceive:" + stringExtra);
        }
        try {
            SmartMusicRecyclerView smartMusicRecyclerView = this.f66255i;
            if (smartMusicRecyclerView != null) {
                smartMusicRecyclerView.setHasAutoSet(false);
            }
            VsMediaPlayer vsMediaPlayer = this.f66262n0;
            if (vsMediaPlayer != null) {
                vsMediaPlayer.s();
                b1();
            }
            JSONObject jSONObject = new JSONObject(stringExtra);
            VsMusicItemInfo vsMusicItemInfo = new VsMusicItemInfo(jSONObject);
            QLog.i("EditVideoSmartMusicPart", 2, "onReceive Music From H5:" + stringExtra);
            SmartMusicAdapter smartMusicAdapter = this.f66260m;
            if (smartMusicAdapter != null) {
                if (smartMusicAdapter.w() > 0) {
                    if (this.f66260m.t(this.K, vsMusicItemInfo)) {
                        vsMusicItemInfo.f97249h = false;
                        ArrayList<String> arrayList = new ArrayList<>();
                        arrayList.add(vsMusicItemInfo.mSongMid);
                        g1(arrayList);
                    }
                    this.f66268t0 = this.f66260m.y(vsMusicItemInfo.mSongMid) + M0();
                    SmartMusicRecyclerView smartMusicRecyclerView2 = this.f66255i;
                    if (smartMusicRecyclerView2 != null) {
                        smartMusicRecyclerView2.setLastPosition(-1);
                        return;
                    }
                    return;
                }
                ArrayList<VsMusicItemInfo> arrayList2 = new ArrayList<>();
                JSONArray optJSONArray = jSONObject.optJSONArray("music_items");
                arrayList2.add(vsMusicItemInfo);
                if (optJSONArray != null) {
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        arrayList2.add(new VsMusicItemInfo(optJSONArray.getJSONObject(i3)));
                    }
                    this.f66260m.F(arrayList2);
                }
            }
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("EditVideoSmartMusicPart", 2, QLog.getStackTraceString(e16));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R0(boolean z16, long j3, String str, QQCircleSmartMatchMusic$SmartMatchMusicRsp qQCircleSmartMatchMusic$SmartMatchMusicRsp) {
        H0();
        if (W0(z16, j3, str, qQCircleSmartMatchMusic$SmartMatchMusicRsp)) {
            return;
        }
        F0(qQCircleSmartMatchMusic$SmartMatchMusicRsp);
        l1(qQCircleSmartMatchMusic$SmartMatchMusicRsp.musicListInfo.get());
    }

    private void T0() {
        EditVideoParams.EditSource editSource = this.mParent.C.f204059i;
        if (editSource instanceof EditTakeVideoSource) {
            EditTakeVideoSource editTakeVideoSource = (EditTakeVideoSource) editSource;
            this.V = editTakeVideoSource.f204052e;
            this.W = editTakeVideoSource.f204051d;
        } else if (editSource instanceof EditLocalVideoSource) {
            EditLocalVideoSource editLocalVideoSource = (EditLocalVideoSource) editSource;
            LocalMediaInfo localMediaInfo = editLocalVideoSource.f204044e;
            this.V = localMediaInfo;
            this.W = editLocalVideoSource.f204043d;
            this.f66256i0 = localMediaInfo.mStartTime;
        }
        VsMediaPlayer vsMediaPlayer = new VsMediaPlayer();
        this.f66262n0 = vsMediaPlayer;
        vsMediaPlayer.o(this);
        LocalMediaInfo localMediaInfo2 = this.V;
        if (localMediaInfo2 != null) {
            this.f66262n0.m(localMediaInfo2.mDuration);
            D0(HardCodeUtil.qqStr(R.string.m0s) + "\n\u89c6\u9891\u65f6\u957f\uff1a" + (this.V.mDuration / 1000) + ReportConstant.COSTREPORT_PREFIX);
            D0(HardCodeUtil.qqStr(R.string.m19) + this.V.mediaWidth + "  " + this.V.mediaHeight);
            ((IAEBaseReportParam) QRoute.api(IAEBaseReportParam.class)).setVideoDuration(this.V.mDuration / 1000);
        }
        if (this.f66265q0) {
            this.f66262n0.l(60000);
        }
        this.f66249e0 = (ArrayList) this.mParent.T().getSerializable("KEY_VIDEO_STORY_CAPTYRE_FRAMES");
        this.f66263o0 = this.mParent.T().getInt("KEY_VIDEO_STORY_CAMERA_TYPE", 2) == 2 ? 0 : 1;
        this.f66251f0 = this.mParent.T().getLong("KEY_VIDEO_STORY_CAPTYRE_FRAMES_SIZE");
        c1();
    }

    private boolean W0(boolean z16, long j3, String str, QQCircleSmartMatchMusic$SmartMatchMusicRsp qQCircleSmartMatchMusic$SmartMatchMusicRsp) {
        if (z16 && qQCircleSmartMatchMusic$SmartMatchMusicRsp != null) {
            if (qQCircleSmartMatchMusic$SmartMatchMusicRsp.musicListInfo.size() != 0) {
                return false;
            }
            QLog.w("EditVideoSmartMusicPart", 1, "SmartMusicMatchRequest success but the music size is 0");
            return true;
        }
        QLog.w("EditVideoSmartMusicPart", 1, "SmartMusicMatchRequest failed" + BaseRequest.concactRetCodeAndMsg(j3, str));
        return true;
    }

    private void X0() {
        Activity activity = (Activity) getContext();
        Intent intent = new Intent(activity, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", String.format(AEEditorConstants.QIM_LOAD_QQ_MUSIC_URL, ah.z(), "", 6));
        intent.putExtra(QQBrowserActivity.EXTRA_FINISH_ANIMATION_UP_DOWN, true);
        activity.startActivityForResult(intent, 1001);
        activity.overridePendingTransition(R.anim.f154424l, 0);
    }

    private void Y0(VsMusicItemInfo vsMusicItemInfo) {
        b1();
        if (vsMusicItemInfo != null && !TextUtils.isEmpty(vsMusicItemInfo.f97247e) && this.U != null) {
            VsMusicItemInfo vsMusicItemInfo2 = this.E;
            if (vsMusicItemInfo2 == null || !vsMusicItemInfo2.mSongMid.equals(vsMusicItemInfo.mSongMid)) {
                return;
            }
            String str = vsMusicItemInfo.f97247e;
            if (str != null && !str.isEmpty()) {
                k1(vsMusicItemInfo.f97247e, vsMusicItemInfo.f97246d, vsMusicItemInfo.musicStart);
                return;
            } else {
                QLog.w("EditVideoSmartMusicPart", 1, "loadLyric mLrics is Empty");
                return;
            }
        }
        QLog.w("EditVideoSmartMusicPart", 1, "loadLyric mLrics null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z0() {
        if (js.a.f410906f.d(this.mParent.C.D)) {
            ac.a().b();
        }
    }

    private void a1() {
        if (js.a.f410906f.d(this.mParent.C.D)) {
            ac.a().c(!this.M);
        }
    }

    private void c1() {
        this.f66272x0 = new File("/storage/emulated/0/Tencent/MobileQQ/video_story/", "smart_music_anim.zip");
        G0();
        if (!this.f66272x0.exists() && !StringUtil.isEmpty(this.f66273y0)) {
            ThreadManagerV2.executeOnNetWorkThread(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.EditVideoSmartMusicPart.1
                @Override // java.lang.Runnable
                public void run() {
                    HttpNetReq httpNetReq = new HttpNetReq();
                    httpNetReq.mCallback = new a();
                    httpNetReq.mReqUrl = EditVideoSmartMusicPart.this.f66273y0;
                    httpNetReq.mHttpMethod = 0;
                    httpNetReq.mOutPath = EditVideoSmartMusicPart.this.f66272x0.getPath();
                    httpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
                    QQStoryContext.h();
                    ((IHttpEngineService) QQStoryContext.a().getRuntimeService(IHttpEngineService.class, "all")).sendReq(httpNetReq);
                    QLog.i("EditVideoSmartMusicPart", 1, "startDownloadAnim, url: " + EditVideoSmartMusicPart.this.f66273y0);
                }

                /* renamed from: com.tencent.aelight.camera.aioeditor.EditVideoSmartMusicPart$1$a */
                /* loaded from: classes32.dex */
                class a implements INetEngineListener {
                    a() {
                    }

                    @Override // com.tencent.mobileqq.transfile.INetEngineListener
                    public void onResp(NetResp netResp) {
                        QLog.i("EditVideoSmartMusicPart", 1, "download smart anim onResp url:  resultcode: " + netResp.mHttpCode);
                        if (EditVideoSmartMusicPart.this.f66272x0 == null) {
                            return;
                        }
                        try {
                            QLog.i("EditVideoSmartMusicPart", 1, "start unzip smart anim");
                            ZipUtils.unZipFile(EditVideoSmartMusicPart.this.f66272x0, "/storage/emulated/0/Tencent/MobileQQ/video_story/");
                        } catch (IOException e16) {
                            QLog.i("EditVideoSmartMusicPart", 1, "unzip smart anim failed" + e16);
                        }
                    }

                    @Override // com.tencent.mobileqq.transfile.INetEngineListener
                    public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
                    }
                }
            });
            return;
        }
        QLog.i("EditVideoSmartMusicPart", 1, "animFile exist:" + this.f66272x0.exists() + " | downloadUrl:" + this.f66273y0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e1() {
        VsMusicItemInfo v3;
        SmartMusicAdapter smartMusicAdapter = this.f66260m;
        if (smartMusicAdapter == null || (v3 = smartMusicAdapter.v(this.K)) == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        long currentTimeMillis = System.currentTimeMillis() - this.f66267s0;
        try {
            jSONObject.put("music_id", v3.mSongMid);
            jSONObject.put("music_play_time", currentTimeMillis);
            LocalMediaInfo localMediaInfo = this.V;
            if (localMediaInfo != null) {
                jSONObject.put("video_duration", localMediaInfo.mDuration);
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        VSReporter.m("mystatus_edit", "aimusic_exp_clk", 0, 0, String.valueOf(v3.f97248f), "", jSONObject.toString());
        this.f66267s0 = System.currentTimeMillis();
        hd0.c.k("EditVideoSmartMusicPart", "reportSmartMusic   reportClickMusic() args3:" + jSONObject.toString());
    }

    private void f1() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.f66260m.v(this.K - 1) != null) {
                jSONObject.put("mid1", this.f66260m.v(this.K - 1).mSongMid);
            }
            if (this.f66260m.v(this.K) != null) {
                jSONObject.put("mid2", this.f66260m.v(this.K).mSongMid);
            }
            if (this.f66260m.v(this.K + 1) != null) {
                jSONObject.put("mid3", this.f66260m.v(this.K + 1).mSongMid);
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        VSReporter.m("mystatus_edit", "aimusic_exp", 0, 0, "", "", jSONObject.toString());
        hd0.c.k("EditVideoSmartMusicPart", "reportSmartMusic   reportShowMusic() args3:" + jSONObject.toString());
    }

    private void g1(ArrayList<String> arrayList) {
        SmartMusicAdapter smartMusicAdapter = this.f66260m;
        if (smartMusicAdapter != null) {
            smartMusicAdapter.D(arrayList, true);
        }
    }

    private void i1() {
        SmartMusicRecyclerView smartMusicRecyclerView = this.f66255i;
        if (smartMusicRecyclerView != null) {
            smartMusicRecyclerView.setNeedScale(!this.M);
        }
        SmartMusicAdapter.b bVar = this.F;
        if (bVar != null) {
            bVar.g(!this.M);
            if (this.M) {
                this.F.e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j1(VsMusicItemInfo vsMusicItemInfo, int i3, SmartMusicAdapter.b bVar) {
        this.E = vsMusicItemInfo;
        VsMediaPlayer vsMediaPlayer = this.f66262n0;
        if (vsMediaPlayer != null) {
            vsMediaPlayer.s();
        }
        b1();
        d1(i3, bVar);
        if (vsMusicItemInfo.f97249h) {
            p1(vsMusicItemInfo);
        }
        f1();
    }

    private void n1(boolean z16) {
        this.f66245c0.setVisibility(z16 ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o1() {
        if (this.f66255i.getBackground() == null) {
            this.f66245c0.setBackgroundResource(R.drawable.f160356g5);
            N0().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.EditVideoSmartMusicPart.7
                @Override // java.lang.Runnable
                public void run() {
                    EditVideoSmartMusicPart.this.f66255i.scrollToPosition(EditVideoSmartMusicPart.this.M0() + 3);
                    EditVideoSmartMusicPart.this.f66255i.smoothScrollToPosition(EditVideoSmartMusicPart.this.M0());
                    EditVideoSmartMusicPart.this.f66255i.setVisibility(0);
                }
            });
        }
    }

    private void q1() {
        Object valueOf;
        File file = this.f66272x0;
        if (file != null && file.exists()) {
            String[] strArr = new String[25];
            for (int i3 = 0; i3 < 25; i3++) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("/storage/emulated/0/Tencent/MobileQQ/video_story/smart_music_anim/music_000");
                if (i3 < 10) {
                    valueOf = "0" + i3;
                } else {
                    valueOf = Integer.valueOf(i3);
                }
                sb5.append(valueOf);
                sb5.append(".png");
                strArr[i3] = sb5.toString();
            }
            FrameLayout frameLayout = this.f66270v0;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
            QQAnimationDrawable qQAnimationDrawable = new QQAnimationDrawable();
            this.f66269u0 = qQAnimationDrawable;
            qQAnimationDrawable.G(strArr);
            this.f66269u0.E(1666L);
            this.Z.setVisibility(8);
            this.f66271w0.setImageDrawable(this.f66269u0);
            this.f66271w0.setVisibility(0);
            this.f66269u0.I(Integer.MAX_VALUE);
            return;
        }
        QLog.w("EditVideoSmartMusicPart", 1, "startMusicMoreAnimation animFile is not valid");
        ImageView imageView = this.Z;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        FrameLayout frameLayout2 = this.f66270v0;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(0);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.f
    public void A() {
        if (!this.f66266r0) {
            if (QLog.isColorLevel()) {
                QLog.d("EditVideoSmartMusicPart", 2, "playBgMusic in = null mIsResume=" + this.f66266r0);
                return;
            }
            return;
        }
        if (this.f66262n0 != null) {
            SmartMusicAdapter.b bVar = this.F;
            if (bVar != null) {
                bVar.i(false);
                this.F.d();
            }
            Y0(this.E);
            this.f66262n0.p();
        }
    }

    public String L0() {
        HashMap<String, String> hashMap;
        VsMusicItemInfo vsMusicItemInfo = this.E;
        if (vsMusicItemInfo != null && this.f66257j0 != null && (hashMap = this.f66258k0) != null && hashMap.get(vsMusicItemInfo.mSongMid) != null) {
            return this.f66258k0.get(this.E.mSongMid);
        }
        return "";
    }

    public int M0() {
        if (this.f66260m.u() == null || this.f66260m.u().size() == 0) {
            return 0;
        }
        return (int) (Math.floor((this.f66260m.getItemCount() / this.f66260m.u().size()) / 2) * this.f66260m.u().size());
    }

    public WeakReferenceHandler N0() {
        if (this.D == null) {
            this.D = new WeakReferenceHandler(Looper.getMainLooper(), this);
        }
        return this.D;
    }

    public Vibrator O0() {
        if (this.Q == null) {
            this.Q = (Vibrator) getContext().getSystemService("vibrator");
        }
        return this.Q;
    }

    public void b1() {
        SingleLyricView singleLyricView = this.U;
        if (singleLyricView != null) {
            singleLyricView.e();
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void editVideoStateChanged(int i3, int i16, Object obj) {
        super.editVideoStateChanged(i3, i16, obj);
        if (i16 == 0) {
            n1(true);
        } else {
            if (i16 != 3) {
                return;
            }
            n1(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public boolean handleEditVideoMessage(Message message) {
        if (this.P) {
            return false;
        }
        if (message.what == 3) {
            S0(message.arg1);
        }
        return super.handleEditVideoMessage(message);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        return false;
    }

    public void k1(String str, String str2, int i3) {
        if (StringUtil.isEmpty(str2)) {
            str2 = LyricParseHelper.LYRIC_FROMAT_LRC;
        }
        this.U.setData(str, str2);
    }

    public void l1(List<QQCircleSmartMatchMusic$MusicInfo> list) {
        this.f66255i.setMusicData(list);
        if ((list == null || list.size() == 0) && this.f66260m.w() == 0) {
            QLog.w("EditVideoSmartMusicPart", 1, "setMusicData musicData response is empty");
        } else {
            o1();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Drawable drawable;
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.rtn) {
            X0();
        } else if (id5 == R.id.rwm) {
            I0();
            Z0();
            a1();
        } else if (id5 == R.id.rwo) {
            this.N = !this.N;
            H(true);
            ImageView imageView = this.f66250f;
            if (this.N) {
                drawable = this.S;
            } else {
                drawable = this.R;
            }
            imageView.setBackgroundDrawable(drawable);
            Z0();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onCreate() {
        View view;
        super.onCreate();
        this.f66264p0 = this.mParent.k0();
        this.f66265q0 = this.mParent.m0();
        V0();
        T0();
        publishEditExport(com.tencent.aelight.camera.aioeditor.takevideo.f.class, this);
        BaseApplicationImpl.getApplication().registerReceiver(this.f66274z0, new IntentFilter("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT"));
        int intValue = ((Long) VSConfigManager.c().e("SmartMatchMusicSwitch", 0L)).intValue();
        this.f66261m0 = intValue;
        if (intValue != 1) {
            if (intValue == 2 && (view = this.f66244b0) != null) {
                view.setVisibility(8);
                return;
            }
            return;
        }
        J0();
        ImageView imageView = this.f66253h;
        if (imageView != null) {
            imageView.setBackgroundDrawable(this.R);
            this.M = false;
            this.f66270v0.setVisibility(0);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onDestroy() {
        e1();
        this.P = true;
        N0().removeCallbacks(null);
        BaseApplicationImpl.getApplication().unregisterReceiver(this.f66274z0);
        VSNetworkHelper.getInstance().cancelRequest(getContext());
        FrameVideoHelper frameVideoHelper = this.Y;
        if (frameVideoHelper != null) {
            frameVideoHelper.z();
        }
        VsMediaPlayer vsMediaPlayer = this.f66262n0;
        if (vsMediaPlayer != null) {
            vsMediaPlayer.j();
        }
        SingleLyricView singleLyricView = this.U;
        if (singleLyricView != null) {
            singleLyricView.e();
        }
        SmartMusicAdapter.b bVar = this.F;
        if (bVar != null) {
            bVar.e();
        }
        N0().removeCallbacks(null);
    }

    @Override // com.tencent.biz.videostory.video.VsMediaPlayer.a
    public void onError(MediaPlayer mediaPlayer, int i3, int i16) {
        if (this.E == null || this.M) {
            return;
        }
        SmartMusicAdapter.b bVar = this.F;
        if (bVar != null) {
            bVar.i(false);
            this.F.e();
        }
        QQToast.makeText(BaseApplicationImpl.sApplication, this.E.f97250i, 1).show();
        QLog.w("EditVideoSmartMusicPart", 1, "mediaplayer onError: what:" + i3 + " | extra:" + i16);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onPause() {
        super.onPause();
        this.f66266r0 = false;
        VsMediaPlayer vsMediaPlayer = this.f66262n0;
        if (vsMediaPlayer != null) {
            vsMediaPlayer.i();
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onResume() {
        int i3;
        super.onResume();
        this.f66266r0 = true;
        SmartMusicRecyclerView smartMusicRecyclerView = this.f66255i;
        if (smartMusicRecyclerView == null || (i3 = this.f66268t0) == -1) {
            return;
        }
        smartMusicRecyclerView.smoothScrollToPosition(i3);
        this.f66268t0 = -1;
    }

    public void r1() {
        N0().postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.EditVideoSmartMusicPart.9
            @Override // java.lang.Runnable
            public void run() {
                VibrationEffect createOneShot;
                if (Build.VERSION.SDK_INT > 25) {
                    createOneShot = VibrationEffect.createOneShot(50, -1);
                    EditVideoSmartMusicPart.this.O0().vibrate(createOneShot);
                } else {
                    EditVideoSmartMusicPart.this.O0().vibrate(50);
                }
            }
        }, 100L);
    }

    @Override // com.tencent.biz.videostory.video.VsMediaPlayer.a
    public void w(MediaPlayer mediaPlayer, VsMusicItemInfo vsMusicItemInfo) {
        if (vsMusicItemInfo.mSongMid.equals(this.E.mSongMid)) {
            H(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class c implements g {
        c() {
        }

        @Override // com.tencent.aelight.camera.aioeditor.EditVideoSmartMusicPart.g
        public void a(int i3, VsMusicItemInfo vsMusicItemInfo) {
            EditVideoSmartMusicPart editVideoSmartMusicPart = EditVideoSmartMusicPart.this;
            if (i3 == editVideoSmartMusicPart.K) {
                return;
            }
            editVideoSmartMusicPart.f66255i.setHasAutoSet(false);
            if (EditVideoSmartMusicPart.this.F != null) {
                EditVideoSmartMusicPart.this.F.g(!EditVideoSmartMusicPart.this.M);
                EditVideoSmartMusicPart.this.F.e();
            }
            EditVideoSmartMusicPart.this.f66255i.smoothScrollToPosition(i3);
        }

        @Override // com.tencent.aelight.camera.aioeditor.EditVideoSmartMusicPart.g
        public void b(int i3, SmartMusicAdapter.b bVar) {
            if (EditVideoSmartMusicPart.this.M) {
                EditVideoSmartMusicPart.this.I0();
            }
            VsMusicItemInfo v3 = EditVideoSmartMusicPart.this.f66260m.v(i3);
            if (EditVideoSmartMusicPart.this.C != null && v3 != null) {
                QLog.i("EditVideoSmartMusicPart", 1, "onPositionChange:" + i3 + ", music name:" + v3.mMusicName + ", musicSongMid:" + v3.mSongMid + ", musicCoverUrl:" + v3.mAlbumUrl + ", musicUrl:" + v3.mUrl);
                EditVideoSmartMusicPart.this.e1();
                EditVideoSmartMusicPart.this.C.setText(v3.mMusicName);
                EditVideoSmartMusicPart.this.j1(v3, i3, bVar);
            }
            EditVideoSmartMusicPart.this.Z0();
        }

        @Override // com.tencent.aelight.camera.aioeditor.EditVideoSmartMusicPart.g
        public void c(VsMusicItemInfo vsMusicItemInfo, int i3, boolean z16) {
            if (!z16 || EditVideoSmartMusicPart.this.E == null || EditVideoSmartMusicPart.this.E.mSongMid == null || !EditVideoSmartMusicPart.this.E.mSongMid.equals(vsMusicItemInfo.mSongMid)) {
                return;
            }
            EditVideoSmartMusicPart.this.j1(vsMusicItemInfo, i3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h1(ArrayList<FrameVideoHelper.FrameBuffer> arrayList) {
        this.f66259l0 = true;
        this.f66252g0 = System.currentTimeMillis();
        SmartMusicMatchRequest smartMusicMatchRequest = new SmartMusicMatchRequest(arrayList, ((IAEWaterMarkManager) QRoute.api(IAEWaterMarkManager.class)).getLocation(), this.f66264p0, this.f66263o0, this.V);
        this.X = smartMusicMatchRequest.get$cmd();
        VSNetworkHelper.getInstance().sendRequest(getContext(), smartMusicMatchRequest, new e());
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void editVideoPrePublish(int i3, fs.b bVar) {
        this.T = true;
        if (this.f66265q0) {
            this.N = true;
        }
        bVar.f400387d.putExtra(PublishVideoEntry.ENTRY_KEY_IS_MIX_ORIGINAL, Boolean.valueOf(!this.N));
        PublishVideoEntry publishVideoEntry = bVar.f400387d;
        boolean z16 = this.N;
        publishVideoEntry.isMixOriginal = !z16;
        publishVideoEntry.isMuteRecordVoice = z16;
        publishVideoEntry.putExtra("KEY_PIC_TO_VIDEO_LOCAL_PIC_PATH", this.mParent.T().getString("KEY_PIC_TO_VIDEO_LOCAL_PIC_PATH"));
        bVar.f400387d.putExtra("KEY_FROM_PIC_TO_VIDEO", Boolean.valueOf(this.f66265q0));
        bVar.f400387d.putExtra("KEY_VIDEO_STORY_CAMERA_TYPE", Boolean.valueOf(this.mParent.f0().isLandTakePicToVideo()));
        if (this.M) {
            bVar.f400387d.backgroundMusicPath = null;
        } else {
            VsMediaPlayer vsMediaPlayer = this.f66262n0;
            if (vsMediaPlayer != null && vsMediaPlayer.h() != null) {
                VsMusicItemInfo h16 = this.f66262n0.h();
                PublishVideoEntry publishVideoEntry2 = bVar.f400387d;
                int i16 = h16.musicStart;
                publishVideoEntry2.backgroundMusicOffset = i16;
                int i17 = h16.musicEnd - i16;
                if (!this.f66265q0) {
                    if (i17 < 0) {
                        i17 = 60000;
                    }
                    i17 = Math.min(i17, (int) this.mParent.a0(i3));
                }
                PublishVideoEntry publishVideoEntry3 = bVar.f400387d;
                publishVideoEntry3.backgroundMusicDuration = i17;
                publishVideoEntry3.backgroundMusicPath = h16.getLocalPath();
                bVar.f400387d.putExtra("vs_publish_entry_json_key_music_id", Integer.valueOf(h16.mItemId));
                bVar.f400387d.putExtra("vs_publish_entry_json_key_music_mid_id", h16.mSongMid);
                bVar.f400387d.putExtra("vs_publish_entry_json_key_song_name", h16.mMusicName);
                bVar.f400387d.putExtra("vs_publish_entry_json_key_music_album_pic", h16.mAlbumUrl);
                bVar.f400387d.putExtra("vs_publish_entry_json_key_music_download_url", h16.mUrl);
                bVar.f400387d.putExtra("vs_publish_entry_json_key_music_source_from", Integer.valueOf(h16.f97248f));
                bVar.f400387d.putExtra(PublishVideoEntry.ENTRY_KEY_ORIGINAL_RECORD_VOLUME, Float.valueOf(K0(1)));
                bVar.f400387d.putExtra(PublishVideoEntry.ENTRY_KEY_BACKGROUND_VOLUME, Float.valueOf(K0(2)));
                this.mParent.f0().setSongMid(h16.mSongMid);
                this.mParent.f0().setMusicType(h16.f97248f);
                this.mParent.f0().setMusciPlayTime(System.currentTimeMillis() - this.f66267s0);
                String str = h16.mTagName;
                if (TextUtils.isEmpty(str)) {
                    str = "none";
                }
                ((IAEBaseReportParam) QRoute.api(IAEBaseReportParam.class)).setEditMusicId(str + "_" + h16.mItemId);
            }
        }
        if (this.V != null) {
            this.mParent.f0().setVideoDuration(this.V.mDuration);
        }
    }

    public void p1(VsMusicItemInfo vsMusicItemInfo) {
        if (vsMusicItemInfo == null) {
            if (QLog.isColorLevel()) {
                QLog.d("EditVideoSmartMusicPart", 2, "startMusic itemInfo=null");
                return;
            }
            return;
        }
        if (this.M) {
            QLog.d("EditVideoSmartMusicPart", 2, "startMusic  music is muted but itemInfo is not MuteInfo");
            return;
        }
        QLog.d("EditVideoSmartMusicPart", 4, "start replay music name:" + vsMusicItemInfo.mMusicName);
        m1(vsMusicItemInfo);
        SmartMusicAdapter.b bVar = this.F;
        if (bVar != null) {
            bVar.i(true);
        }
        VsMediaPlayer vsMediaPlayer = this.f66262n0;
        if (vsMediaPlayer == null || this.M) {
            return;
        }
        vsMediaPlayer.n(K0(2));
        this.f66262n0.q(vsMusicItemInfo);
    }

    private void d1(int i3, SmartMusicAdapter.b bVar) {
        if (bVar == null) {
            bVar = (SmartMusicAdapter.b) this.f66255i.findViewHolderForAdapterPosition(i3);
        }
        this.K = i3;
        this.F = bVar;
        if (bVar != null && !this.M) {
            bVar.f();
            r1();
        }
        E0(L0());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class d implements FrameVideoHelper.a {
        d() {
        }

        @Override // com.tencent.biz.videostory.video.FrameVideoHelper.a
        public void a(boolean z16, ArrayList<FrameVideoHelper.FrameBuffer> arrayList, long j3) {
            if (!z16 || arrayList == null) {
                EditVideoSmartMusicPart.this.D0(HardCodeUtil.qqStr(R.string.f171937m21));
                QLog.w("EditVideoSmartMusicPart", 1, "extractFrame failed  data is null");
            }
            if (EditVideoSmartMusicPart.this.Y != null) {
                EditVideoSmartMusicPart editVideoSmartMusicPart = EditVideoSmartMusicPart.this;
                StringBuilder sb5 = new StringBuilder();
                sb5.append(HardCodeUtil.qqStr(R.string.lyy));
                sb5.append(EditVideoSmartMusicPart.this.Y.v());
                sb5.append("ms\n\u62bd\u53d6\u56fe\u7247\u6570\uff1a");
                sb5.append(arrayList == null ? 0 : arrayList.size());
                sb5.append("\n\u62bd\u5e27\u5b57\u8282\u6570\uff1a");
                sb5.append(EditVideoSmartMusicPart.this.Y.w());
                sb5.append("KB");
                editVideoSmartMusicPart.D0(sb5.toString());
            }
            EditVideoSmartMusicPart.this.h1(arrayList);
        }
    }

    private void U0() {
        SmartMusicRecyclerView smartMusicRecyclerView = (SmartMusicRecyclerView) findViewSure(R.id.rrp);
        this.f66255i = smartMusicRecyclerView;
        this.f66260m = (SmartMusicAdapter) smartMusicRecyclerView.getAdapter();
        this.f66255i.setListener(new c());
    }

    private void V0() {
        int f16;
        int f17;
        int f18;
        this.f66245c0 = findViewSure(R.id.s4q);
        this.f66247d0 = (TextView) findViewSure(R.id.s3b);
        this.f66257j0 = (TextView) findViewSure(R.id.s3y);
        this.f66248e = (RelativeLayout) findViewSure(R.id.s4d);
        this.f66250f = (ImageView) findViewSure(R.id.f163764rw1);
        this.f66253h = (ImageView) findViewSure(R.id.rvy);
        this.C = (TextView) findViewSure(R.id.s3q);
        this.f66271w0 = (ImageView) findViewSure(R.id.rvs);
        this.U = (SingleLyricView) findViewSure(R.id.s0u);
        this.Z = (ImageView) findViewSure(R.id.s0x);
        this.R = getContext().getResources().getDrawable(R.drawable.f162649ha4);
        this.S = getContext().getResources().getDrawable(R.drawable.f162648ha3);
        View findViewSure = findViewSure(R.id.rwo);
        this.f66243a0 = findViewSure;
        findViewSure.setOnClickListener(this);
        View findViewSure2 = findViewSure(R.id.rwm);
        this.f66244b0 = findViewSure2;
        findViewSure2.setOnClickListener(this);
        this.f66270v0 = (FrameLayout) findViewSure(R.id.rtn);
        this.H = this.mParent.f67794m.getActivity().findViewById(R.id.rov);
        this.G = this.mParent.f67794m.getActivity().findViewById(R.id.rou);
        this.f66270v0.setOnClickListener(this);
        U0();
        this.f66247d0.setOnClickListener(new a());
        this.f66257j0.setOnClickListener(new b());
        View view = this.f66243a0;
        if (view != null && this.f66265q0) {
            view.setVisibility(8);
        }
        QLog.d("EditVideoSmartMusicPart", 2, "getRealHeight" + ScreenUtil.getRealHeight(getContext()) + "ScreenUtil.getRealWidth(getContext())" + ScreenUtil.getRealWidth(getContext()));
        if (ScreenUtil.getRealHeight(getContext()) / ScreenUtil.getRealWidth(getContext()) >= 2.0f) {
            LiuHaiUtils.resetFullScreen((Activity) getContext());
            this.G.setVisibility(8);
            this.H.setVisibility(8);
        } else {
            RelativeLayout relativeLayout = this.mParent.U;
            if (relativeLayout != null && relativeLayout.getLayoutParams() != null) {
                this.f66245c0.setPadding(0, 0, 0, this.mParent.U.getLayoutParams().height);
            }
        }
        if (js.a.f410906f.d(this.mParent.C.D) && (this.mParent.C.p() || this.mParent.C.r() || this.mParent.C.s())) {
            f16 = BaseAIOUtils.f(105.0f, getContext().getResources());
            f17 = BaseAIOUtils.f(34.0f, getContext().getResources());
            f18 = BaseAIOUtils.f(19.0f, getContext().getResources());
        } else {
            f16 = BaseAIOUtils.f(17.0f, getContext().getResources());
            f17 = BaseAIOUtils.f(0.0f, getContext().getResources());
            f18 = BaseAIOUtils.f(-15.0f, getContext().getResources());
        }
        RelativeLayout relativeLayout2 = this.f66248e;
        relativeLayout2.setPadding(relativeLayout2.getPaddingLeft(), this.f66248e.getPaddingTop(), this.f66248e.getPaddingRight(), f16);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f66270v0.getLayoutParams();
        marginLayoutParams.bottomMargin = f17;
        this.f66270v0.setLayoutParams(marginLayoutParams);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f66255i.getLayoutParams();
        marginLayoutParams2.bottomMargin = f18;
        this.f66255i.setLayoutParams(marginLayoutParams2);
    }

    private void m1(MusicItemInfo musicItemInfo) {
        if (musicItemInfo == null) {
            return;
        }
        if (musicItemInfo.musicDuration == 0 && musicItemInfo.getLocalPath() != null) {
            musicItemInfo.musicDuration = (int) ShortVideoUtils.getDuration(musicItemInfo.getLocalPath());
        }
        if (this.f66265q0) {
            int i3 = musicItemInfo.musicStart;
            int i16 = i3 + 15999;
            int i17 = musicItemInfo.musicDuration;
            if (i16 <= i17) {
                i17 = i3 + 15999;
            }
            musicItemInfo.musicDuration = i17;
        }
        if (musicItemInfo.musicEnd == 0) {
            musicItemInfo.musicEnd = musicItemInfo.musicDuration;
        }
    }

    private float K0(int i3) {
        if (i3 == 1) {
            boolean z16 = this.M;
            if (z16 && this.N) {
                return 0.0f;
            }
            if (!z16 && this.N) {
                return 0.0f;
            }
            if (!z16 && !this.N) {
                return this.I;
            }
            if (z16) {
                boolean z17 = this.N;
            }
        } else if (i3 == 2) {
            boolean z18 = this.M;
            if (z18 && this.N) {
                return 0.0f;
            }
            if (z18 || !this.N) {
                if (!z18 && !this.N) {
                    return this.J;
                }
                if (z18 && !this.N) {
                    return 0.0f;
                }
            }
        }
        return 1.0f;
    }

    private void S0(int i3) {
        if (i3 != 1) {
            if (i3 == 2) {
                h.b().d();
                return;
            } else if (i3 != 3) {
                return;
            }
        }
        h.b().c();
    }

    private void F0(QQCircleSmartMatchMusic$SmartMatchMusicRsp qQCircleSmartMatchMusic$SmartMatchMusicRsp) {
    }

    public void D0(String str) {
    }

    public void E0(String str) {
    }
}
