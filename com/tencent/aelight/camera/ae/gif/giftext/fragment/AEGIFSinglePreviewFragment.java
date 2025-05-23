package com.tencent.aelight.camera.ae.gif.giftext.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.aelight.camera.ae.gif.giftext.AEGIFOutlineTextView;
import com.tencent.aelight.camera.ae.gif.preview.VideoPlayView;
import com.tencent.aelight.camera.ae.gif.video.VideoGIFCreator;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.ae.util.i;
import com.tencent.aelight.camera.aebase.BaseVMPeakActivity;
import com.tencent.aelight.camera.aioeditor.takevideo.ab;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.qipc.api.IAECameraGetInfoServer;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticonview.api.IEmoticonPanelIpcService;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqlive.module.videoreport.inject.fragment.FragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportFragment;
import com.tencent.util.UiThreadUtil;
import cooperation.peak.PeakConstants;
import dov.com.qq.im.ae.current.SessionWrap;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes32.dex */
public class AEGIFSinglePreviewFragment extends ReportFragment {
    private AEGIFOutlineTextView C;
    private String D;
    private Dialog E;
    private View F;
    private String I;
    private SessionWrap J;
    private VideoGIFCreator T;

    /* renamed from: d, reason: collision with root package name */
    private ViewGroup f65372d;

    /* renamed from: e, reason: collision with root package name */
    private Activity f65373e;

    /* renamed from: f, reason: collision with root package name */
    private VideoPlayView f65374f;

    /* renamed from: h, reason: collision with root package name */
    private MediaPlayer f65375h;

    /* renamed from: m, reason: collision with root package name */
    private rq.e f65377m;

    /* renamed from: i, reason: collision with root package name */
    private String f65376i = null;
    private boolean G = false;
    private boolean H = false;
    private boolean K = false;
    private boolean L = i.b();
    private String M = "";
    private boolean N = false;
    private final int P = 700;
    private final int Q = 600;
    private final float R = 147.0f;
    private final float S = 58.8f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            AEGIFSinglePreviewFragment.this.f65373e.finish();
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
            com.tencent.aelight.camera.ae.report.b.b().T0();
            AEGIFSinglePreviewFragment.this.z(false);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            com.tencent.aelight.camera.ae.report.b.b().U0();
            AEGIFSinglePreviewFragment.this.z(true);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class d implements EIPCResultCallback {
        d() {
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            QLog.d("AEGIFSinglePreviewFragment", 4, "QIPC_ACTION_EMO_CREATE_GIF_AND_UPLOAD onCallback");
            int i3 = eIPCResult.code;
            if (i3 == 0) {
                QLog.d("AEGIFSinglePreviewFragment", 4, "QIPC_ACTION_EMO_CREATE_GIF_AND_UPLOAD eipcResult.code == 0");
            } else {
                QLog.d("AEGIFSinglePreviewFragment", 4, "QIPC_ACTION_EMO_CREATE_GIF_AND_UPLOAD eipcResult.code != 0, eipcResult.code == ", Integer.valueOf(i3), ", msg = ", eIPCResult.f396321e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class e implements MediaPlayer.OnPreparedListener {
        e() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            mediaPlayer.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            AEGIFSinglePreviewFragment.this.D();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(String str, SessionWrap sessionWrap, String str2, String str3) {
        if (new File(str).exists()) {
            Bundle bundle = new Bundle();
            bundle.putString(AECameraConstants.ARG_GIF_PATH, str);
            bundle.putString("curFriendUin", sessionWrap.f394447d);
            bundle.putString("curFriendNick", sessionWrap.f394448e);
            bundle.putString("troopUin", sessionWrap.f394450h);
            bundle.putInt("curType", sessionWrap.f394449f);
            bundle.putString(AppConstants.Key.FORWARD_SUMMARY_EXTRA, str2);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("gif^");
            if (str3 == null) {
                str3 = "";
            }
            sb5.append(str3);
            bundle.putString(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM, sb5.toString());
            QIPCClientHelper.getInstance().callServer(IAECameraGetInfoServer.NAME, "ACTION_SEND_GIF", bundle, null);
            getActivity().setResult(201);
            getActivity().finish();
        }
    }

    private void B() {
        float f16;
        int c16;
        RelativeLayout relativeLayout = (RelativeLayout) this.f65372d.findViewById(R.id.f163782rz4);
        float left = this.C.getLeft() / relativeLayout.getWidth();
        float top = this.C.getTop() / relativeLayout.getHeight();
        float d16 = this.C.d() + (this.C.e() * 2.0f);
        if (this.f65377m.n().indexOf(10) > 0) {
            f16 = d16 * 2.5f;
            c16 = x.c(this.f65373e, 250.0f);
        } else {
            f16 = d16 * 1.2f;
            c16 = x.c(this.f65373e, 250.0f);
        }
        float f17 = f16 / c16;
        if (this.f65377m.n().length() > 0) {
            this.T.C(this.C.c(), left, top, 1.0f, f17);
        }
    }

    private void C() {
        if (this.f65373e.isFinishing()) {
            return;
        }
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.aelight.camera.ae.gif.giftext.fragment.AEGIFSinglePreviewFragment.8
            @Override // java.lang.Runnable
            public void run() {
                if (AEGIFSinglePreviewFragment.this.E == null) {
                    AEGIFSinglePreviewFragment aEGIFSinglePreviewFragment = AEGIFSinglePreviewFragment.this;
                    aEGIFSinglePreviewFragment.E = new ReportDialog(aEGIFSinglePreviewFragment.f65373e, R.style.qZoneInputDialog);
                    AEGIFSinglePreviewFragment.this.E.setCancelable(false);
                    AEGIFSinglePreviewFragment.this.E.setCanceledOnTouchOutside(false);
                    AEGIFSinglePreviewFragment.this.E.setContentView(R.layout.dom);
                }
                if (AEGIFSinglePreviewFragment.this.F != null) {
                    AEGIFSinglePreviewFragment.this.F.setVisibility(0);
                }
                AEGIFSinglePreviewFragment.this.E.show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3) {
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("qipc_param_camera_emo_png_dirs", arrayList);
        bundle.putStringArrayList("qipc_param_camera_emo_texts", arrayList2);
        bundle.putStringArrayList("qipc_param_emo_widget_infos", arrayList3);
        QIPCClientHelper.getInstance().callServer(IEmoticonPanelIpcService.CAMERAEMOIPC_SERVER_NAME, "qipc_action_camera_emo_create_gif_and_upload", bundle, new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.aelight.camera.ae.gif.giftext.fragment.AEGIFSinglePreviewFragment.9
            @Override // java.lang.Runnable
            public void run() {
                if (AEGIFSinglePreviewFragment.this.f65373e.isFinishing()) {
                    return;
                }
                if (AEGIFSinglePreviewFragment.this.E != null && AEGIFSinglePreviewFragment.this.E.isShowing()) {
                    AEGIFSinglePreviewFragment.this.E.dismiss();
                }
                if (AEGIFSinglePreviewFragment.this.F != null) {
                    AEGIFSinglePreviewFragment.this.F.setVisibility(8);
                }
            }
        });
    }

    private void u() {
        v(this.f65376i);
        VideoPlayView videoPlayView = (VideoPlayView) this.f65372d.findViewById(R.id.s48);
        this.f65374f = videoPlayView;
        MediaPlayer mediaPlayer = this.f65375h;
        if (mediaPlayer != null) {
            videoPlayView.c(mediaPlayer);
        }
    }

    private void v(String str) {
        ReportMediaPlayer reportMediaPlayer = new ReportMediaPlayer();
        this.f65375h = reportMediaPlayer;
        reportMediaPlayer.setLooping(true);
        try {
            this.f65375h.setDataSource(str);
        } catch (IOException unused) {
            QLog.e("AEGIFSinglePreviewFragment", 1, "mediaPlayer \u521d\u59cb\u5316\u5931\u8d25");
        }
        this.f65375h.setOnPreparedListener(new e());
    }

    private void w() {
        AEGIFOutlineTextView aEGIFOutlineTextView = (AEGIFOutlineTextView) this.f65372d.findViewById(R.id.rxq);
        this.C = aEGIFOutlineTextView;
        aEGIFOutlineTextView.setVisibility(0);
        this.C.setOnClickListener(new f());
        this.C.setFontId(this.D);
        RelativeLayout relativeLayout = (RelativeLayout) this.f65372d.findViewById(R.id.rz7);
        relativeLayout.setVisibility(0);
        rq.e eVar = new rq.e((BaseVMPeakActivity) this.f65373e, relativeLayout, this.C);
        this.f65377m = eVar;
        eVar.o();
    }

    private void x() {
        this.f65372d.findViewById(R.id.ruc).setOnClickListener(new a());
        this.F = this.f65372d.findViewById(R.id.ro5);
        this.f65372d.findViewById(R.id.rud).setOnClickListener(new b());
        this.f65372d.findViewById(R.id.s3t).setOnClickListener(new c());
    }

    public static Fragment y(String str, Boolean bool, String str2, String str3, SessionWrap sessionWrap, boolean z16, String str4) {
        AEGIFSinglePreviewFragment aEGIFSinglePreviewFragment = new AEGIFSinglePreviewFragment();
        Bundle bundle = new Bundle();
        bundle.putString("KEY_PREVIEW_SOURCE_PATH", str);
        bundle.putString("KEY_AVAILABLE_SAVENAME", str3);
        bundle.putBoolean("KEY_MATERIAL_APPLIED", bool.booleanValue());
        bundle.putString(AECameraConstants.ARG_GIF_MATERIAL_ID, str2);
        bundle.putParcelable(AECameraConstants.ARG_SESSION_INFO, sessionWrap);
        bundle.putBoolean(AECameraConstants.ARG_GIF_SEND_TO_AIO, z16);
        if (!TextUtils.isEmpty(str4)) {
            bundle.putString("KEY_FONT_ID", str4);
        }
        aEGIFSinglePreviewFragment.setArguments(bundle);
        return aEGIFSinglePreviewFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(final boolean z16) {
        ms.a.f("AEGIFSinglePreviewFragment", "saveAndSend---onlySave=" + z16);
        C();
        this.T = new VideoGIFCreator(this.f65376i);
        B();
        this.T.D(new VideoGIFCreator.b() { // from class: com.tencent.aelight.camera.ae.gif.giftext.fragment.AEGIFSinglePreviewFragment.4
            @Override // com.tencent.aelight.camera.ae.gif.video.VideoGIFCreator.b
            public void onGifCreateFail() {
                QLog.d("AEGIFSinglePreviewFragment", 4, "onGifCreateFail");
                AEGIFSinglePreviewFragment.this.t();
                UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.aelight.camera.ae.gif.giftext.fragment.AEGIFSinglePreviewFragment.4.2
                    @Override // java.lang.Runnable
                    public void run() {
                        QQToast.makeText(AEGIFSinglePreviewFragment.this.f65373e, 1, AEGIFSinglePreviewFragment.this.getString(R.string.ihr), 1).show();
                    }
                });
            }

            @Override // com.tencent.aelight.camera.ae.gif.video.VideoGIFCreator.b
            public void onGifCreateSuccess(String str) {
                String str2;
                QLog.d("AEGIFSinglePreviewFragment", 4, "onGifCreateSuccess, come from AECAMERA_MODE_ALL");
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                String str3 = "";
                if (AEGIFSinglePreviewFragment.this.f65377m == null) {
                    str2 = "";
                } else {
                    str2 = AEGIFSinglePreviewFragment.this.f65377m.n();
                }
                arrayList.add(str);
                arrayList2.add(str2);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("gif^");
                if (AEGIFSinglePreviewFragment.this.I != null) {
                    str3 = AEGIFSinglePreviewFragment.this.I;
                }
                sb5.append(str3);
                arrayList3.add(sb5.toString());
                if (z16) {
                    AEGIFSinglePreviewFragment.this.r(arrayList, arrayList2, arrayList3);
                    AEGIFSinglePreviewFragment.this.getActivity().setResult(201);
                    AEGIFSinglePreviewFragment.this.getActivity().finish();
                    final Context applicationContext = AEGIFSinglePreviewFragment.this.getActivity().getApplicationContext();
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.gif.giftext.fragment.AEGIFSinglePreviewFragment.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            QQToast.makeText(applicationContext, R.string.y4x, 1).show();
                        }
                    });
                } else {
                    AEGIFSinglePreviewFragment.this.r(arrayList, arrayList2, arrayList3);
                    if (AEGIFSinglePreviewFragment.this.K && AEGIFSinglePreviewFragment.this.J != null) {
                        AEGIFSinglePreviewFragment aEGIFSinglePreviewFragment = AEGIFSinglePreviewFragment.this;
                        aEGIFSinglePreviewFragment.A(str, aEGIFSinglePreviewFragment.J, str2, AEGIFSinglePreviewFragment.this.I);
                    } else {
                        ab.d(AEGIFSinglePreviewFragment.this.f65373e, str, gq.a.K(AEGIFSinglePreviewFragment.this.getActivity()), true, str2, AEGIFSinglePreviewFragment.this.I, 1);
                    }
                }
                AEGIFSinglePreviewFragment.this.t();
            }
        });
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f65373e = getActivity();
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f65372d = (ViewGroup) layoutInflater.inflate(s(), viewGroup, false);
        int i3 = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
        if (i3 < x.c(this.f65373e, 700.0f)) {
            this.N = true;
        } else {
            this.N = false;
        }
        if (this.N) {
            View findViewById = this.f65372d.findViewById(R.id.f163782rz4);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
            if (i3 < x.c(this.f65373e, 600.0f)) {
                layoutParams.topMargin = x.c(this.f65373e, 58.8f);
            } else {
                layoutParams.topMargin = x.c(this.f65373e, 147.0f - (((r5 - i3) / x.c(this.f65373e, 100.0f)) * 88.2f));
            }
            findViewById.setLayoutParams(layoutParams);
        }
        Bundle arguments = getArguments();
        this.f65376i = arguments.getString("KEY_PREVIEW_SOURCE_PATH");
        this.H = arguments.getBoolean("KEY_MATERIAL_APPLIED");
        this.I = arguments.getString(AECameraConstants.ARG_GIF_MATERIAL_ID);
        ms.a.f("AEGIFSinglePreviewFragment", "receive materialId=" + this.I + ", materialApplied=" + this.H);
        this.M = arguments.getString("KEY_AVAILABLE_SAVENAME");
        this.J = (SessionWrap) arguments.getParcelable(AECameraConstants.ARG_SESSION_INFO);
        this.K = arguments.getBoolean(AECameraConstants.ARG_GIF_SEND_TO_AIO);
        if (getArguments().containsKey("KEY_FONT_ID")) {
            this.D = getArguments().getString("KEY_FONT_ID");
        }
        w();
        x();
        u();
        ViewGroup viewGroup2 = this.f65372d;
        FragmentCollector.onFragmentViewCreated(this, viewGroup2);
        return viewGroup2;
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MediaPlayer mediaPlayer = this.f65375h;
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        VideoPlayView videoPlayView = this.f65374f;
        if (videoPlayView != null) {
            videoPlayView.b();
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportFragment, android.app.Fragment
    public void onPause() {
        super.onPause();
        com.tencent.aelight.camera.ae.report.b.b().V0();
        MediaPlayer mediaPlayer = this.f65375h;
        if (mediaPlayer != null) {
            mediaPlayer.pause();
            this.G = true;
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportFragment, android.app.Fragment
    public void onResume() {
        super.onResume();
        AEBaseReportParam.U().v1();
        MediaPlayer mediaPlayer = this.f65375h;
        if (mediaPlayer == null || !this.G) {
            return;
        }
        mediaPlayer.start();
        this.G = false;
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        MediaPlayer mediaPlayer = this.f65375h;
        if (mediaPlayer == null || !this.G) {
            return;
        }
        mediaPlayer.start();
    }

    protected int s() {
        return this.L ? R.layout.f167505do4 : R.layout.f167504do3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        AEGIFTextEditFragment I = AEGIFTextEditFragment.I(null, false, this.D);
        I.M(this.f65377m);
        getFragmentManager().beginTransaction().add(R.id.ru8, I).addToBackStack(null).commit();
    }
}
