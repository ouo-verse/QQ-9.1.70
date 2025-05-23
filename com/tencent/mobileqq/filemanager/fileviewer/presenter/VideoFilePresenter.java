package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.os.Handler;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.SeekBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.VideoFileViewer;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoPlayUtils;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.mobileqq.qqvideoplatform.api.SceneID;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import rx.functions.Action1;

/* loaded from: classes12.dex */
public class VideoFilePresenter extends FileBrowserPresenterBase implements VideoPlayerCallback, FileBrowserModelBase.f, com.tencent.mobileqq.filemanager.core.i, com.tencent.mobileqq.filemanager.core.j {
    protected VideoFileViewer F;
    protected AudioManager G;
    private PowerManager.WakeLock H;
    private Handler I;
    private boolean J;
    boolean K;
    private long L;
    private int M;
    private boolean N;
    private long P;
    private ShareActionSheet Q;
    private boolean R;
    private BaseVideoView S;
    private com.tencent.mobileqq.filemanager.core.k T;
    private com.tencent.mobileqq.filemanager.fileviewer.data.b U;
    private View.OnLongClickListener V;
    private View.OnClickListener W;
    private SeekBar.OnSeekBarChangeListener X;
    private long Y;
    private AudioManager.OnAudioFocusChangeListener Z;

    /* renamed from: a0, reason: collision with root package name */
    final Runnable f208496a0;

    /* renamed from: b0, reason: collision with root package name */
    Runnable f208497b0;

    /* renamed from: com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter$9, reason: invalid class name */
    /* loaded from: classes12.dex */
    class AnonymousClass9 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f208498d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f208499e;
        final /* synthetic */ VideoFilePresenter this$0;

        /* renamed from: com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter$9$a */
        /* loaded from: classes12.dex */
        class a implements DialogInterface.OnClickListener {
            a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                AnonymousClass9.this.this$0.D();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            String string;
            int i3 = this.f208498d;
            if (i3 != -6101 && i3 != -7003 && i3 != 201) {
                VideoFilePresenter videoFilePresenter = this.this$0;
                videoFilePresenter.F.O(videoFilePresenter.f208460e.N(), this.this$0.f208461f.getString(R.string.bfm));
                return;
            }
            if (i3 != -6101 && i3 != -7003) {
                if (i3 == 201) {
                    if (!this.this$0.f208460e.o0()) {
                        string = this.this$0.f208461f.getString(R.string.bfn);
                    } else {
                        VideoFilePresenter videoFilePresenter2 = this.this$0;
                        videoFilePresenter2.F.O(videoFilePresenter2.f208460e.N(), this.this$0.f208461f.getString(R.string.bfm));
                        return;
                    }
                } else {
                    string = this.this$0.f208461f.getString(R.string.bfm);
                    if (QLog.isColorLevel()) {
                        QLog.i("FileBrowserPresenter<FileAssistant>", 2, "can not handle video error. rc=[" + this.f208498d + "]  msg=[" + this.f208499e + "]");
                    }
                }
            } else {
                string = this.this$0.f208461f.getString(R.string.bet);
                this.this$0.f208460e.x0(this.f208498d, this.f208499e);
            }
            String str = string;
            BaseActivity baseActivity = BaseActivity.sTopActivity;
            if (baseActivity != null) {
                QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(baseActivity, 230, "", str, (String) null, HardCodeUtil.qqStr(R.string.f172892v42), new a(), (DialogInterface.OnClickListener) null);
                if (!createCustomDialog.isShowing()) {
                    createCustomDialog.show();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class a implements View.OnLongClickListener {

        /* renamed from: com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter$a$a, reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        class C7575a implements Action1<ArrayList<ShareActionSheetBuilder.ActionSheetItem>[]> {
            C7575a() {
            }

            @Override // rx.functions.Action1
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void call(ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] arrayListArr) {
                VideoFilePresenter.this.z0(arrayListArr);
                VideoFilePresenter.this.B0(arrayListArr, VideoFilePresenter.this.E() + "(" + q.g(VideoFilePresenter.this.f208460e.Q()) + ")");
            }
        }

        a() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            EventCollector.getInstance().onViewLongClickedBefore(view);
            if (VideoFilePresenter.this.f208460e.t0()) {
                VideoFilePresenter.this.f208460e.c(new C7575a());
            }
            EventCollector.getInstance().onViewLongClicked(view);
            return true;
        }
    }

    /* loaded from: classes12.dex */
    class b implements AudioManager.OnAudioFocusChangeListener {
        b() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i3) {
            Activity activity;
            if (VideoFilePresenter.this.S == null) {
                QLog.w("FileBrowserPresenter<FileAssistant>", 1, "onAudioFocusChange:mVideoView null!");
                return;
            }
            boolean isPlaying = VideoFilePresenter.this.S.isPlaying();
            if (i3 == -2) {
                if (isPlaying) {
                    VideoFilePresenter.this.x0();
                }
            } else {
                if (i3 == 1) {
                    if (!isPlaying && (activity = VideoFilePresenter.this.f208461f) != null && (activity instanceof FileBrowserActivity) && ((FileBrowserActivity) activity).isResume()) {
                        VideoFilePresenter.this.y0();
                        return;
                    }
                    return;
                }
                if (i3 == -1 && isPlaying) {
                    VideoFilePresenter.this.x0();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class c implements View.OnClickListener {

        /* loaded from: classes12.dex */
        class a implements Action1<ArrayList<ShareActionSheetBuilder.ActionSheetItem>[]> {
            a() {
            }

            @Override // rx.functions.Action1
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void call(ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] arrayListArr) {
                VideoFilePresenter.this.z0(arrayListArr);
                VideoFilePresenter.this.B0(arrayListArr, VideoFilePresenter.this.E() + "(" + q.g(VideoFilePresenter.this.f208460e.Q()) + ")");
            }
        }

        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            int id5 = view.getId();
            if (id5 == R.id.fuw) {
                if (VideoFilePresenter.this.S != null) {
                    boolean isPlaying = VideoFilePresenter.this.S.isPlaying();
                    if (!isPlaying) {
                        VideoFilePresenter.this.u0();
                        VideoFilePresenter.this.y0();
                    } else {
                        VideoFilePresenter.this.I.removeCallbacks(VideoFilePresenter.this.f208496a0);
                        FileManagerReporter.addData("0X8004BE5");
                        VideoFilePresenter videoFilePresenter = VideoFilePresenter.this;
                        videoFilePresenter.G.abandonAudioFocus(videoFilePresenter.Z);
                        VideoFilePresenter.this.x0();
                    }
                    VideoFilePresenter.this.F.H(!isPlaying);
                }
            } else if (id5 == R.id.epq) {
                VideoFilePresenter.this.f208460e.c(new a());
            } else if (id5 == R.id.f164560a44) {
                VideoFilePresenter.this.D();
            } else if (id5 == R.id.i9b) {
                int T = VideoFilePresenter.this.f208460e.T();
                int U = VideoFilePresenter.this.f208460e.U();
                if (T == 6 && U == 1 && VideoFilePresenter.this.f208460e.g0() != null) {
                    VideoFilePresenter.this.f208460e.g0().e();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class d implements DialogInterface.OnDismissListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            ImmersiveUtils.isSupporImmersive();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class e implements ShareActionSheet.OnItemClickListener {
        e() {
        }

        @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
        public void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
            if (actionSheetItem == null) {
                return;
            }
            VideoFilePresenter.this.Q.dismiss();
            View.OnClickListener onClickListener = actionSheetItem.listener;
            if (onClickListener != null) {
                onClickListener.onClick(null);
                return;
            }
            FileBrowserModelBase fileBrowserModelBase = VideoFilePresenter.this.f208460e;
            if (fileBrowserModelBase != null) {
                fileBrowserModelBase.k0(actionSheetItem);
            }
        }
    }

    /* loaded from: classes12.dex */
    class f implements Action1<ArrayList<ShareActionSheetBuilder.ActionSheetItem>[]> {
        f() {
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x003d  */
        /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
        @Override // rx.functions.Action1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void call(ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] arrayListArr) {
            ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList;
            ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList2 = null;
            if (arrayListArr != null) {
                if (arrayListArr.length == 1) {
                    arrayList2 = arrayListArr[0];
                    arrayList = null;
                } else if (arrayListArr.length == 2) {
                    arrayList2 = arrayListArr[0];
                    arrayList = arrayListArr[1];
                }
                if ((arrayList2 != null && !arrayList2.isEmpty()) || (arrayList != null && !arrayList.isEmpty())) {
                    VideoFilePresenter.this.Q.setActionSheetItems(arrayList2, arrayList);
                }
                if (VideoFilePresenter.this.Q.isShowing()) {
                    VideoFilePresenter.this.Q.refresh();
                    return;
                }
                return;
            }
            arrayList = null;
            if (arrayList2 != null) {
                VideoFilePresenter.this.Q.setActionSheetItems(arrayList2, arrayList);
                if (VideoFilePresenter.this.Q.isShowing()) {
                }
            }
            VideoFilePresenter.this.Q.setActionSheetItems(arrayList2, arrayList);
            if (VideoFilePresenter.this.Q.isShowing()) {
            }
        }
    }

    /* loaded from: classes12.dex */
    class g implements SeekBar.OnSeekBarChangeListener {
        g() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i3, boolean z16) {
            if (z16 && VideoFilePresenter.this.S != null) {
                VideoFilePresenter videoFilePresenter = VideoFilePresenter.this;
                videoFilePresenter.M = videoFilePresenter.t0(i3);
                VideoFilePresenter.this.F.F(r3.M);
                if (QLog.isDevelopLevel()) {
                    QLog.d("#@#@", 1, "onProgressChanged userPos[" + VideoFilePresenter.this.M + "]");
                }
                VideoFilePresenter.this.F.H(false);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        @TargetApi(16)
        public void onStartTrackingTouch(SeekBar seekBar) {
            if (VideoFilePresenter.this.S != null && VideoFilePresenter.this.S.isPlaying()) {
                VideoFilePresenter.this.D0();
                VideoFilePresenter.this.I.removeCallbacks(VideoFilePresenter.this.f208496a0);
                VideoFilePresenter videoFilePresenter = VideoFilePresenter.this;
                videoFilePresenter.K = videoFilePresenter.S.isPlaying();
                VideoFilePresenter.this.S.pause();
                VideoFilePresenter.this.F.M(null);
                VideoFilePresenter.this.N = true;
                return;
            }
            VideoFilePresenter.this.K = false;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            EventCollector.getInstance().onStopTrackingTouchBefore(seekBar);
            if (VideoFilePresenter.this.S != null) {
                VideoFilePresenter videoFilePresenter = VideoFilePresenter.this;
                videoFilePresenter.M = videoFilePresenter.t0(seekBar.getProgress());
                if (QLog.isDevelopLevel()) {
                    QLog.d("##########", 1, "mMediaPlayer sekTo [" + VideoFilePresenter.this.M + "]");
                }
                VideoFilePresenter.this.S.seekTo(VideoFilePresenter.this.M);
                VideoFilePresenter videoFilePresenter2 = VideoFilePresenter.this;
                if (videoFilePresenter2.K) {
                    videoFilePresenter2.I.post(VideoFilePresenter.this.f208496a0);
                    VideoFilePresenter.this.F.H(true);
                    VideoFilePresenter.this.S.play();
                }
            }
            EventCollector.getInstance().onStopTrackingTouch(seekBar);
        }
    }

    public VideoFilePresenter(FileBrowserModelBase fileBrowserModelBase, Activity activity) {
        super(fileBrowserModelBase, activity);
        this.J = false;
        this.K = false;
        this.L = 0L;
        this.M = 0;
        this.N = false;
        this.P = 0L;
        this.S = null;
        this.V = new a();
        this.W = new c();
        this.X = new g();
        this.Y = FileManagerUtil.genSessionId().longValue();
        this.Z = new b();
        this.f208496a0 = new Runnable() { // from class: com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.11
            @Override // java.lang.Runnable
            public void run() {
                if (VideoFilePresenter.this.S == null) {
                    return;
                }
                VideoFilePresenter videoFilePresenter = VideoFilePresenter.this;
                videoFilePresenter.F.H(videoFilePresenter.S.isPlaying());
                if (!VideoFilePresenter.this.J && VideoFilePresenter.this.S.isPlaying()) {
                    int curPlayingPos = (int) VideoFilePresenter.this.S.getCurPlayingPos();
                    int videoDurationMs = (int) VideoFilePresenter.this.S.getVideoDurationMs();
                    long j3 = curPlayingPos;
                    VideoFilePresenter.this.F.F(j3);
                    if (!VideoFilePresenter.this.N && j3 > VideoFilePresenter.this.P) {
                        VideoFilePresenter.this.P = j3;
                    }
                    float f16 = curPlayingPos / videoDurationMs;
                    if (f16 <= 0.001d) {
                        VideoFilePresenter.this.I.postDelayed(VideoFilePresenter.this.f208496a0, 100L);
                        return;
                    }
                    if (curPlayingPos >= VideoFilePresenter.this.M) {
                        VideoFilePresenter.this.F.K((int) (f16 * 10000.0f));
                    }
                    VideoFilePresenter.this.I.postDelayed(VideoFilePresenter.this.f208496a0, 100L);
                }
            }
        };
        this.f208497b0 = new Runnable() { // from class: com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.12
            @Override // java.lang.Runnable
            public void run() {
                VideoFilePresenter.this.F.T();
            }
        };
        this.F = new VideoFileViewer(activity);
        this.I = new Handler();
        S(this.F);
        v0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0() {
        BaseVideoView baseVideoView = this.S;
        if (baseVideoView != null && !baseVideoView.isPlaying()) {
            return;
        }
        this.I.postDelayed(this.f208497b0, 2500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0() {
        this.I.removeCallbacks(this.f208497b0);
        this.F.E();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String r0() {
        if (FileManagerUtil.isLocalFile(this.f208460e.N())) {
            return this.f208460e.N();
        }
        com.tencent.mobileqq.filemanager.fileviewer.data.b bVar = this.U;
        if (bVar != null) {
            String c16 = bVar.c();
            if (FileManagerUtil.isLocalFile(c16)) {
                return c16;
            }
            return null;
        }
        return null;
    }

    private void s0() {
        com.tencent.mobileqq.filemanager.fileviewer.data.b j06 = this.f208460e.j0();
        this.U = j06;
        if (j06 == null) {
            QLog.w("FileBrowserPresenter<FileAssistant>", 1, "get video biz, data is null!");
            return;
        }
        com.tencent.mobileqq.filemanager.core.k b16 = com.tencent.mobileqq.filemanager.core.g.b(j06);
        this.T = b16;
        b16.g(this);
        this.T.f(this);
        this.T.d(true);
        this.T.startDownload();
        this.F.S(false);
        this.F.o(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int t0(int i3) {
        BaseVideoView baseVideoView;
        long j3 = this.L;
        if (j3 == 0 && (baseVideoView = this.S) != null) {
            j3 = baseVideoView.getVideoDurationMs();
        }
        return (int) (((float) j3) * (i3 / 10000.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0() {
        String r06 = r0();
        if (r06 == null && this.f208460e.G() == 1) {
            this.F.P(true);
            if (this.f208460e.R() == 16) {
                this.F.O(this.f208460e.N(), this.f208461f.getResources().getString(R.string.bfo));
                this.f208460e.Q0(true);
                ShareActionSheet shareActionSheet = this.Q;
                if (shareActionSheet != null && shareActionSheet.isShowing()) {
                    this.Q.dismiss();
                    return;
                }
                return;
            }
            s0();
            this.F.o(true);
            J(this.f208460e.S());
            return;
        }
        if (this.S != null) {
            VideoPlayParam videoPlayParam = new VideoPlayParam();
            videoPlayParam.mIsLocal = true;
            videoPlayParam.mVideoPath = r06;
            videoPlayParam.mSceneId = 109;
            videoPlayParam.mSceneName = SceneID.getSceneStr(109);
            videoPlayParam.mIsLoop = false;
            videoPlayParam.mNeedPlayProgress = true;
            videoPlayParam.mCallback = this;
            this.S.setVideoParam(videoPlayParam);
        }
    }

    @SuppressLint({"InvalidWakeLockTag"})
    private void v0() {
        this.f208461f.setRequestedOrientation(-1);
        if (this.G == null || this.S == null) {
            this.G = (AudioManager) BaseApplication.getContext().getSystemService("audio");
            PowerManager.WakeLock newWakeLock = ((PowerManager) this.f208461f.getSystemService("power")).newWakeLock(536870922, "FileBrowserPresenter<FileAssistant>");
            this.H = newWakeLock;
            newWakeLock.setReferenceCounted(false);
            this.I = new Handler();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0() {
        if (this.S != null) {
            this.H.release();
            this.S.pause();
            this.f208461f.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.7
                @Override // java.lang.Runnable
                public void run() {
                    if (VideoFilePresenter.this.S != null) {
                        VideoFilePresenter videoFilePresenter = VideoFilePresenter.this;
                        videoFilePresenter.F.H(videoFilePresenter.S.isPlaying());
                    } else {
                        VideoFilePresenter.this.F.H(false);
                    }
                    VideoFilePresenter.this.D0();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0() {
        this.f208461f.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.8
            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                if (VideoFilePresenter.this.r0() != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (VideoFilePresenter.this.S == null) {
                    if (z16) {
                        QLog.e("FileBrowserPresenter<FileAssistant>", 1, "playVideo video, but mediaplay null!");
                        return;
                    } else {
                        if (VideoFilePresenter.this.f208460e.G() == 1) {
                            QLog.e("FileBrowserPresenter<FileAssistant>", 1, "playVideo online video, but mediaplay null!");
                            return;
                        }
                        return;
                    }
                }
                VideoFilePresenter.this.H.acquire();
                VideoFilePresenter.this.A0();
                if (VideoFilePresenter.this.J) {
                    VideoFilePresenter.this.J = false;
                    VideoFilePresenter.this.I.removeCallbacks(VideoFilePresenter.this.f208496a0);
                    new HashMap().put(IVideoPlayUtils.KEY_BUS_TYPE, "bus_type_video_file");
                }
                VideoFilePresenter.this.S.play();
                if (z16) {
                    VideoFilePresenter.this.I.postDelayed(VideoFilePresenter.this.f208496a0, 1000L);
                }
                VideoFilePresenter.this.C0();
                if (z16 && QLog.isDevelopLevel()) {
                    QLog.d("#@#@", 1, "userPos[" + VideoFilePresenter.this.M + "]");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0(ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] arrayListArr) {
        if (arrayListArr != null && arrayListArr.length > 0) {
            for (ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList : arrayListArr) {
                if (arrayList != null && arrayList.size() > 0) {
                    Iterator<ShareActionSheetBuilder.ActionSheetItem> it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (it.next().action == 26) {
                            ReportController.o(null, "dc00898", "", "", "0X800A60D", "0X800A60D", 0, 0, "", "", "", "");
                        }
                    }
                }
            }
        }
    }

    protected boolean A0() {
        if (this.G.requestAudioFocus(this.Z, 3, 1) == 1) {
            return true;
        }
        return false;
    }

    public void B0(ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] arrayListArr, String str) {
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList;
        if (this.Q == null) {
            ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
            param.context = this.f208461f;
            this.Q = ShareActionSheetFactory.create(param);
        }
        this.Q.setRowVisibility(0, 0, 0);
        this.Q.setOnDismissListener(new d());
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList2 = null;
        if (arrayListArr != null) {
            if (arrayListArr.length == 1) {
                arrayList2 = arrayListArr[0];
                arrayList = null;
            } else if (arrayListArr.length == 2) {
                arrayList2 = arrayListArr[0];
                arrayList = arrayListArr[1];
            }
            if ((arrayList2 == null && !arrayList2.isEmpty()) || (arrayList != null && !arrayList.isEmpty())) {
                this.Q.setActionSheetTitle("\u5206\u4eab\u5230");
                Intent X = this.f208460e.X();
                String x16 = this.f208460e.x();
                if (X != null && !TextUtils.isEmpty(x16)) {
                    this.Q.setIntentForStartForwardRecentActivity(X);
                    this.f208461f.getIntent().putExtra("big_brother_source_key", x16);
                } else {
                    this.Q.setRowVisibility(8, 0, 0);
                }
                this.Q.setActionSheetItems(arrayList2, arrayList);
                this.Q.setItemClickListenerV2(new e());
                this.Q.show();
                this.R = true;
                return;
            }
            return;
        }
        arrayList = null;
        if (arrayList2 == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase
    public void D() {
        this.f208460e.k("0X8009D60", null);
        super.D();
        this.f208461f.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase
    public boolean G() {
        return false;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase
    public boolean H() {
        return false;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase
    public void K() {
        super.K();
        if (QLog.isColorLevel()) {
            QLog.i("FileBrowserPresenter<FileAssistant>", 1, "FileBrowserPresenter init: type = video");
        }
        this.F.G(this.W);
        this.F.J(10000);
        this.F.I(this.X);
        this.F.D();
        this.f208460e.O0(this);
        this.F.S(false);
        w0();
        this.S = this.F.B();
        u0();
        com.tencent.mobileqq.filemanager.fileviewer.h hVar = this.f208463i;
        if (hVar != null) {
            hVar.g(true);
        }
        if (FileManagerUtil.isLocalFile(this.f208460e.N()) && this.f208460e.T() == 2) {
            this.F.S(true);
        }
        int T = this.f208460e.T();
        int U = this.f208460e.U();
        if (T == 6 && U == 1) {
            this.F.o(false);
            this.F.S(false);
            this.F.R(false);
        }
        this.F.Q(this.f208460e.t0());
        y0();
        ((IQQFloatingWindowBroadcast) QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowClosedBroadcast(this.f208461f, 53);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase
    public void P() {
        int U = this.f208460e.U();
        if (U == 2) {
            if (this.f208460e.D() != null) {
                this.f208460e.D().b();
            }
        } else if (U == 1) {
            if (this.f208460e.g0() != null) {
                this.f208460e.g0().f();
            }
        } else if (QLog.isColorLevel()) {
            QLog.i("FileBrowserPresenter<FileAssistant>", 1, "Video stop transform, but status unknown!");
        }
        D();
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase
    public void U() {
        if (this.f208460e.t0() && this.Q != null) {
            this.f208460e.c(new f());
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.f
    public void a(float f16) {
        J(f16);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.f
    public void e() {
        if (!q.f(this.f208460e.N())) {
            return;
        }
        this.F.o(false);
        this.F.S(true);
        this.F.R(false);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.f
    public void f() {
        this.F.S(true);
        this.F.o(false);
    }

    @Override // com.tencent.mobileqq.filemanager.core.i
    public void m(SuperPlayerVideoInfo superPlayerVideoInfo) {
        if (this.S == null) {
            QLog.e("FileBrowserPresenter<FileAssistant>", 1, "!!!! onDownloadInfoSucc mVideoViwe null !!!!");
            return;
        }
        VideoPlayParam videoPlayParam = new VideoPlayParam();
        videoPlayParam.mIsLocal = false;
        videoPlayParam.mSavePath = superPlayerVideoInfo.getLocalSavePath();
        videoPlayParam.mFileID = superPlayerVideoInfo.getFileId();
        videoPlayParam.mSceneId = 109;
        videoPlayParam.mSceneName = SceneID.getSceneStr(109);
        videoPlayParam.mIsLoop = false;
        videoPlayParam.mNeedPlayProgress = true;
        videoPlayParam.mCallback = this;
        videoPlayParam.mUrls = superPlayerVideoInfo.getPlayUrls();
        videoPlayParam.mCookies = superPlayerVideoInfo.getCookie();
        videoPlayParam.mVideoFormat = 104;
        this.S.setVideoParam(videoPlayParam);
        y0();
    }

    @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
    public void onDownloadComplete(long j3) {
        QLog.i("FileBrowserPresenter<FileAssistant>", 1, "@@@@@@@@@@@ videoView Download Success:" + j3);
        this.T.c();
    }

    @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
    public void onStateChange(long j3, int i3) {
        boolean z16;
        if (i3 != 1) {
            if (i3 != 8) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            return;
                        }
                    } else {
                        BaseVideoView baseVideoView = this.S;
                        if (baseVideoView != null) {
                            this.L = baseVideoView.getVideoDurationMs();
                        }
                        this.F.L(this.L);
                        if (r0() != null) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            this.F.o(false);
                            this.F.S(true);
                        } else {
                            this.F.o(true);
                            this.F.S(false);
                        }
                        this.F.P(false);
                        return;
                    }
                }
            } else {
                this.J = true;
                this.M = 0;
                this.H.release();
                this.F.K(0);
                this.F.F(0L);
                this.F.H(false);
                return;
            }
        }
        this.F.P(true);
    }

    @Override // com.tencent.mobileqq.filemanager.core.j
    public void r(String str) {
        this.F.S(true);
        this.F.o(false);
        this.I.post(this.f208496a0);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase
    public void v() {
        this.f208461f.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    protected void w0() {
        try {
            FileManagerReporter.addData("0X8007426");
            FileManagerReporter.addData("0X8007427");
            this.F.C(this.Y, this.V);
            this.F.P(true);
            BaseVideoView baseVideoView = this.S;
            if (baseVideoView != null) {
                this.F.H(baseVideoView.isPlaying());
            } else {
                this.F.H(false);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase
    public void x() {
        String Z;
        String str;
        String str2;
        int i3;
        this.F.z();
        BaseVideoView baseVideoView = this.S;
        if (baseVideoView != null) {
            baseVideoView.releasePlayer(true);
            this.S = null;
        }
        com.tencent.mobileqq.filemanager.core.k kVar = this.T;
        if (kVar != null) {
            kVar.f(null);
        }
        Handler handler = this.I;
        if (handler != null) {
            handler.removeCallbacks(this.f208496a0);
            this.I.removeCallbacks(this.f208497b0);
            this.I = null;
        }
        AudioManager audioManager = this.G;
        if (audioManager != null) {
            audioManager.abandonAudioFocus(this.Z);
        }
        com.tencent.mobileqq.filemanager.core.k kVar2 = this.T;
        if (kVar2 != null) {
            kVar2.d(false);
        }
        int F = this.f208460e.F();
        String str3 = "3";
        if (F != 3 && F != 4) {
            if (F == 5 || F == 6) {
                str = "";
                Z = str;
            } else {
                if (F != 1 && F != 2) {
                    str3 = "4";
                    i3 = 5;
                    str = "";
                    Z = str;
                } else {
                    str = this.f208460e.Z();
                    i3 = 1;
                    Z = "";
                }
                str2 = str3;
                DecimalFormat decimalFormat = new DecimalFormat("0.00");
                ReportController.o(null, "dc00898", "", str, "0X8009AA6", "0X8009AA6", i3, 0, str2, "3", decimalFormat.format(this.L / 1000.0d) + ";" + decimalFormat.format(this.P / 1000.0d), Z);
                super.x();
            }
        } else {
            Z = this.f208460e.Z();
            str = "";
        }
        str2 = "3";
        i3 = 2;
        DecimalFormat decimalFormat2 = new DecimalFormat("0.00");
        ReportController.o(null, "dc00898", "", str, "0X8009AA6", "0X8009AA6", i3, 0, str2, "3", decimalFormat2.format(this.L / 1000.0d) + ";" + decimalFormat2.format(this.P / 1000.0d), Z);
        super.x();
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase
    public void y() {
        super.y();
        if (this.R) {
            this.R = false;
            return;
        }
        PowerManager.WakeLock wakeLock = this.H;
        if (wakeLock != null && wakeLock.isHeld()) {
            this.H.release();
        }
        x0();
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase
    public void z() {
        BaseVideoView baseVideoView;
        super.z();
        VideoFileViewer videoFileViewer = this.F;
        if (videoFileViewer != null && (baseVideoView = this.S) != null) {
            videoFileViewer.H(!baseVideoView.isPlaying());
            this.I.postDelayed(this.f208496a0, 100L);
            this.S.play();
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.f
    public void j() {
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.f
    public void l() {
    }

    @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
    public void onFirstFrameRendered(long j3) {
    }

    @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
    public void onDownloadProgress(long j3, long j16) {
    }

    @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
    public void onLoopBack(long j3, long j16) {
    }

    @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
    public void onPlayProgress(long j3, long j16) {
    }

    @Override // com.tencent.mobileqq.filemanager.core.i
    public void p(int i3, String str) {
    }

    @Override // com.tencent.mobileqq.filemanager.core.j
    public void onDownloadError(int i3, int i16, String str) {
    }

    @Override // com.tencent.mobileqq.filemanager.core.j
    public void d(int i3, int i16, long j3, long j16) {
    }

    @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
    public void onCapFrame(long j3, boolean z16, int i3, int i16, Bitmap bitmap) {
    }

    @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
    public void onPlayError(long j3, int i3, int i16, int i17, String str) {
    }
}
