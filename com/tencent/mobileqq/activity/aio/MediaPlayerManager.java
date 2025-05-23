package com.tencent.mobileqq.activity.aio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCAccountNames;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase;
import com.tencent.mobileqq.qqaudio.audioplayer.CommonAudioPlayer;
import com.tencent.mobileqq.qqaudio.audioplayer.IAudioDeviceService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopHWApi;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XBaseAdapter;
import com.tencent.widget.XListView;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import mqq.util.WeakReference;

/* loaded from: classes10.dex */
public class MediaPlayerManager extends BroadcastReceiver implements AudioPlayerBase.b, Manager {
    private XBaseAdapter C;
    private b D;
    private ChatMessage E;
    private ChatMessage F;
    private ChatMessage G;
    private CommonAudioPlayer H;
    private boolean I;
    private boolean J;
    private boolean N;

    /* renamed from: e, reason: collision with root package name */
    private WeakReference<QQAppInterface> f178151e;

    /* renamed from: f, reason: collision with root package name */
    private ChatMessage f178152f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f178153h;

    /* renamed from: i, reason: collision with root package name */
    private XListView f178154i;

    /* renamed from: m, reason: collision with root package name */
    private c f178155m;

    /* renamed from: d, reason: collision with root package name */
    private Handler f178150d = new Handler(Looper.getMainLooper());
    private boolean K = false;
    private MediaPlayer.OnCompletionListener L = new a();
    boolean M = false;

    /* renamed from: com.tencent.mobileqq.activity.aio.MediaPlayerManager$7, reason: invalid class name */
    /* loaded from: classes10.dex */
    class AnonymousClass7 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f178162d;
        final /* synthetic */ MediaPlayerManager this$0;

        @Override // java.lang.Runnable
        public void run() {
            if (this.this$0.n(this.f178162d, true)) {
                this.this$0.v();
            }
        }
    }

    /* loaded from: classes10.dex */
    class a implements MediaPlayer.OnCompletionListener {
        a() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            boolean z16;
            if (mediaPlayer != null) {
                mediaPlayer.release();
            }
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[SilkPlayer]mFinishListener, onCompletion , mp == null ? ");
                if (mediaPlayer == null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                sb5.append(z16);
                QLog.i(com.tencent.mobileqq.tritonaudio.inneraudio.MediaPlayerManager.TAG, 2, sb5.toString());
            }
            AudioUtil.f306881c = null;
            if (MediaPlayerManager.this.f178152f != null && (MediaPlayerManager.this.f178152f instanceof MessageForPtt)) {
                ((MessageForPtt) MediaPlayerManager.this.f178152f).playProgress = 0.0f;
            }
            if (MediaPlayerManager.this.C == null || !MediaPlayerManager.this.w()) {
                MediaPlayerManager.this.f178152f = null;
                MediaPlayerManager.this.v();
            }
        }
    }

    /* loaded from: classes10.dex */
    public interface b {
        boolean A2(XListView xListView, int i3, View view, ChatMessage chatMessage);

        boolean L1(XListView xListView, int i3, View view, ChatMessage chatMessage, AudioPlayerBase audioPlayerBase, int i16);

        boolean Y(ChatMessage chatMessage);

        void l(XListView xListView, int i3, View view, ChatMessage chatMessage, long j3, float f16);

        void m(XListView xListView, int i3, View view, ChatMessage chatMessage, boolean z16);
    }

    /* loaded from: classes10.dex */
    public interface c extends CommonAudioPlayer.a {
        void Z5(int i3);

        @Override // com.tencent.mobileqq.qqaudio.audioplayer.CommonAudioPlayer.a
        void k(boolean z16, boolean z17, boolean z18, boolean z19);

        void l1(int i3);

        void onPlayStart();

        void onPlayStop();

        void vc(int i3);
    }

    public MediaPlayerManager(QQAppInterface qQAppInterface) {
        BaseApplication app = qQAppInterface.getApp();
        CommonAudioPlayer commonAudioPlayer = new CommonAudioPlayer(app, this);
        this.H = commonAudioPlayer;
        commonAudioPlayer.M();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ITroopHWApi.ACTION_START_VIDEO_CHAT);
        intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_OFF);
        app.registerReceiver(this, intentFilter);
        l(qQAppInterface);
        ((IAudioDeviceService) qQAppInterface.getRuntimeService(IAudioDeviceService.class)).registerAudioDeviceListener(this.H);
        if (DeviceInfoMonitor.getModel() == "PCCM00") {
            com.tencent.mobileqq.qqaudio.audioplayer.f.f262189a = 0;
        }
    }

    private void l(QQAppInterface qQAppInterface) {
        if (QLog.isColorLevel()) {
            QLog.d(com.tencent.mobileqq.tritonaudio.inneraudio.MediaPlayerManager.TAG, 2, "$bindApp, app = " + qQAppInterface);
        }
        WeakReference<QQAppInterface> weakReference = this.f178151e;
        if (weakReference != null && weakReference.get() == qQAppInterface) {
            return;
        }
        WeakReference<QQAppInterface> weakReference2 = this.f178151e;
        if (weakReference2 != null && weakReference2.get() != null) {
            F();
        }
        this.f178151e = new WeakReference<>(qQAppInterface);
        com.tencent.mobileqq.qqaudio.audioplayer.f.u(((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCAccountNames.qq_audio_play_fix.name(), null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n(boolean z16, boolean z17) {
        ChatMessage chatMessage;
        boolean z18;
        ChatMessage chatMessage2;
        if (z16) {
            this.H.stop();
            if (this.K || (this.f178152f != null && this.C != null)) {
                u(z16, z17);
            }
            this.f178152f = null;
            return true;
        }
        XBaseAdapter xBaseAdapter = this.C;
        if (xBaseAdapter != null && (chatMessage2 = this.f178152f) != null) {
            if (!p(chatMessage2).Y(this.f178152f)) {
                return false;
            }
            this.H.stop();
            u(z16, z17);
            this.f178152f = null;
            return true;
        }
        if (xBaseAdapter == null && (chatMessage = this.f178152f) != null) {
            b bVar = this.D;
            if (bVar != null) {
                z18 = bVar.Y(chatMessage);
            } else {
                z18 = false;
            }
            if (!z18) {
                return false;
            }
            this.H.stop();
            u(z16, z17);
            this.f178152f = null;
            return true;
        }
        return true;
    }

    public static int o(ChatMessage chatMessage, XBaseAdapter xBaseAdapter) {
        boolean z16;
        if (com.tencent.imcore.message.ao.c(chatMessage.istroop) == 1032) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (xBaseAdapter != null) {
            for (int i3 = 0; i3 < xBaseAdapter.getCount(); i3++) {
                Object item = xBaseAdapter.getItem(i3);
                if (item != null) {
                    if (item instanceof ChatMessage) {
                        if (((ChatMessage) item).uniseq == chatMessage.uniseq) {
                            return i3;
                        }
                    } else if (item instanceof RecentBaseData) {
                        RecentBaseData recentBaseData = (RecentBaseData) item;
                        if (!z16 || recentBaseData.getRecentUserType() != 1032 || !recentBaseData.getRecentUserUin().equals(AppConstants.CONFESS_UIN)) {
                            if (chatMessage.frienduin.equals(recentBaseData.getRecentUserUin()) && chatMessage.istroop == recentBaseData.getRecentUserType()) {
                                return i3;
                            }
                        } else {
                            return i3;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b p(ChatMessage chatMessage) {
        if (((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).judgeAdapterIsGuildPieAdapter(this.C)) {
            return (b) ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).getGuildPieAdapterCallback(chatMessage, this.C);
        }
        if (this.C instanceof s) {
            w.a("MediaPlayerManager.getCallback");
            return null;
        }
        return this.D;
    }

    public static synchronized MediaPlayerManager q(AppRuntime appRuntime) {
        MediaPlayerManager mediaPlayerManager;
        synchronized (MediaPlayerManager.class) {
            mediaPlayerManager = (MediaPlayerManager) appRuntime.getManager(QQManagerFactory.MGR_MEDIA_PLAYER);
        }
        return mediaPlayerManager;
    }

    private ChatMessage r(int i3) {
        Object item = this.C.getItem(i3);
        if (item != null && (item instanceof ChatMessage)) {
            return (ChatMessage) item;
        }
        return null;
    }

    private int u(boolean z16, boolean z17) {
        if (!this.K) {
            int o16 = o(this.f178152f, this.C);
            B(this.f178152f);
            A(this.f178152f, this.F);
            if (o16 >= 0) {
                XListView xListView = this.f178154i;
                p(this.f178152f).m(this.f178154i, o16, l.E(xListView, xListView.getHeaderViewsCount() + o16), this.f178152f, z17);
            }
            return o16;
        }
        b bVar = this.D;
        if (bVar != null) {
            bVar.m(null, 0, null, this.f178152f, z17);
            return 0;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean w() {
        XBaseAdapter xBaseAdapter;
        int o16;
        int count;
        boolean z16;
        float f16;
        boolean z17;
        boolean z18;
        ChatMessage chatMessage = this.f178152f;
        if (chatMessage != null && (xBaseAdapter = this.C) != null && (o16 = o(chatMessage, xBaseAdapter)) <= (count = this.C.getCount())) {
            float f17 = com.tencent.mobileqq.qqaudio.audioplayer.sonic.a.f262196a;
            ChatMessage chatMessage2 = this.f178152f;
            if (chatMessage2 instanceof MessageForPtt) {
                boolean b16 = com.tencent.mobileqq.qqaudio.audioplayer.sonic.a.b(((MessageForPtt) chatMessage2).playSpeedPos);
                if (b16) {
                    f17 = ((MessageForPtt) this.f178152f).playSpeedPos;
                }
                ((MessageForPtt) this.f178152f).playSpeedPos = com.tencent.mobileqq.qqaudio.audioplayer.sonic.a.f262196a;
                f16 = f17;
                z16 = b16;
            } else {
                z16 = false;
                f16 = f17;
            }
            XListView xListView = this.f178154i;
            View E = l.E(xListView, xListView.getHeaderViewsCount() + o16);
            if (o16 >= 0) {
                p(this.f178152f).m(this.f178154i, o16, E, this.f178152f, true);
            }
            if (this.f178153h) {
                while (o16 < count - 1) {
                    int i3 = o16 + 1;
                    ChatMessage r16 = r(i3);
                    if (r16 instanceof com.tencent.mobileqq.data.c) {
                        if (this.N && E != null) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        XListView xListView2 = this.f178154i;
                        View E2 = l.E(xListView2, xListView2.getHeaderViewsCount() + i3);
                        try {
                            b p16 = p(r16);
                            boolean A2 = p16.A2(this.f178154i, i3, E2, r16);
                            if (A2 && z16 && (r16 instanceof MessageForPtt)) {
                                ((MessageForPtt) r16).playSpeedPos = f16;
                                C(f16);
                                CommonAudioPlayer commonAudioPlayer = this.H;
                                if (commonAudioPlayer != null) {
                                    commonAudioPlayer.D(((MessageForPtt) r16).msgTime);
                                }
                            }
                            if (A2 && p16.L1(this.f178154i, i3, E2, r16, this.H, 0)) {
                                z18 = true;
                            } else {
                                z18 = false;
                            }
                            if (z18) {
                                this.f178152f = r16;
                                if (z17) {
                                    XListView xListView3 = this.f178154i;
                                    xListView3.smoothScrollToPosition(xListView3.getHeaderViewsCount() + i3);
                                }
                                return true;
                            }
                        } catch (Exception e16) {
                            if (QLog.isColorLevel()) {
                                QLog.e(com.tencent.mobileqq.tritonaudio.inneraudio.MediaPlayerManager.TAG, 2, "playNext", e16);
                            }
                        }
                        E = E2;
                    }
                    o16 = i3;
                }
            }
        }
        this.f178152f = null;
        return false;
    }

    public void A(ChatMessage chatMessage, ChatMessage chatMessage2) {
        if ((chatMessage instanceof MessageForPtt) && (chatMessage2 instanceof MessageForPtt) && !chatMessage.equals(chatMessage2)) {
            ((MessageForPtt) chatMessage).playSpeedPos = com.tencent.mobileqq.qqaudio.audioplayer.sonic.a.f262196a;
        }
    }

    public void B(ChatMessage chatMessage) {
        this.G = chatMessage;
    }

    public void C(float f16) {
        CommonAudioPlayer commonAudioPlayer = this.H;
        if (commonAudioPlayer != null) {
            commonAudioPlayer.F(f16);
        }
    }

    public void D(final boolean z16) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            if (n(z16, false)) {
                v();
                return;
            }
            return;
        }
        this.f178150d.post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.MediaPlayerManager.1
            @Override // java.lang.Runnable
            public void run() {
                if (MediaPlayerManager.this.n(z16, false)) {
                    MediaPlayerManager.this.v();
                }
            }
        });
    }

    public void E() {
        if (!com.tencent.mobileqq.qqaudio.audioplayer.c.f262173b) {
            return;
        }
        AudioManager audioManager = (AudioManager) BaseApplication.getContext().getSystemService("audio");
        if (AudioPlayerBase.N && audioManager != null && audioManager.isBluetoothScoOn()) {
            if (QLog.isColorLevel()) {
                QLog.d(com.tencent.mobileqq.tritonaudio.inneraudio.MediaPlayerManager.TAG, 2, "stop sco");
            }
            audioManager.stopBluetoothSco();
            audioManager.setBluetoothScoOn(false);
            AudioPlayerBase.N = false;
        }
    }

    public void F() {
        try {
            D(true);
            G(this.f178154i);
            WeakReference<QQAppInterface> weakReference = this.f178151e;
            if (weakReference != null && weakReference.get() != null) {
                this.f178151e.get().getApp().unregisterReceiver(this);
            }
            this.f178151e = null;
            if (QLog.isColorLevel()) {
                QLog.d(com.tencent.mobileqq.tritonaudio.inneraudio.MediaPlayerManager.TAG, 2, "$unBindApp");
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(com.tencent.mobileqq.tritonaudio.inneraudio.MediaPlayerManager.TAG, 2, "", e16);
            }
        }
    }

    public void G(XListView xListView) {
        if (QLog.isColorLevel()) {
            QLog.i(com.tencent.mobileqq.tritonaudio.inneraudio.MediaPlayerManager.TAG, 2, "unBindUI");
        }
        XListView xListView2 = this.f178154i;
        if (xListView2 != null && xListView2 == xListView) {
            this.f178154i = null;
            this.C = null;
            this.f178155m = null;
            CommonAudioPlayer commonAudioPlayer = this.H;
            if (commonAudioPlayer != null) {
                commonAudioPlayer.R(null);
            }
            this.D = null;
            this.f178153h = false;
            this.N = false;
        }
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase.b
    public void Tg(AudioPlayerBase audioPlayerBase, final int i3, String str) {
        this.f178150d.post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.MediaPlayerManager.5
            @Override // java.lang.Runnable
            public void run() {
                if (MediaPlayerManager.this.f178155m != null) {
                    MediaPlayerManager.this.f178155m.Z5(i3);
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase.b
    public void V3(AudioPlayerBase audioPlayerBase, final int i3, String str) {
        CommonAudioPlayer commonAudioPlayer;
        if (this.f178150d != null && (commonAudioPlayer = this.H) != null && commonAudioPlayer.r()) {
            this.f178150d.post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.MediaPlayerManager.6
                @Override // java.lang.Runnable
                public void run() {
                    float f16;
                    if (MediaPlayerManager.this.f178152f != null) {
                        MediaPlayerManager mediaPlayerManager = MediaPlayerManager.this;
                        b p16 = mediaPlayerManager.p(mediaPlayerManager.f178152f);
                        long n3 = MediaPlayerManager.this.H.n();
                        if (n3 > 0) {
                            f16 = i3 / ((float) n3);
                        } else {
                            f16 = 0.0f;
                        }
                        if (MediaPlayerManager.this.C == null) {
                            if (p16 != null) {
                                p16.l(MediaPlayerManager.this.f178154i, -1, null, MediaPlayerManager.this.f178152f, i3, f16);
                            }
                        } else {
                            int o16 = MediaPlayerManager.o(MediaPlayerManager.this.f178152f, MediaPlayerManager.this.C);
                            if (o16 <= MediaPlayerManager.this.C.getCount()) {
                                p16.l(MediaPlayerManager.this.f178154i, o16, l.E(MediaPlayerManager.this.f178154i, MediaPlayerManager.this.f178154i.getHeaderViewsCount() + o16), MediaPlayerManager.this.f178152f, i3, f16);
                            }
                        }
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase.b
    public void W8(AudioPlayerBase audioPlayerBase, String str) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.MediaPlayerManager.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AudioUtil.m(R.raw.f169414l, 1, MediaPlayerManager.this.L, MediaPlayerManager.this.f178150d);
                } catch (Throwable unused) {
                }
            }
        }, 16, null, false);
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase.b
    public void j5(AudioPlayerBase audioPlayerBase, int i3, String str) {
        c cVar = this.f178155m;
        if (cVar != null) {
            cVar.vc(i3);
        }
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase.b
    public void k9(final AudioPlayerBase audioPlayerBase, final int i3, final String str) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            if (this.f178152f != null) {
                u(true, true);
            }
            c cVar = this.f178155m;
            if (cVar != null) {
                cVar.l1(i3);
                return;
            }
            return;
        }
        this.f178150d.post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.MediaPlayerManager.4
            @Override // java.lang.Runnable
            public void run() {
                MediaPlayerManager.this.k9(audioPlayerBase, i3, str);
            }
        });
    }

    public void m(XListView xListView, XBaseAdapter xBaseAdapter, c cVar, b bVar, boolean z16, boolean z17) {
        if (QLog.isColorLevel()) {
            QLog.i(com.tencent.mobileqq.tritonaudio.inneraudio.MediaPlayerManager.TAG, 2, "bindUI, mListView = " + this.f178154i + " ,listView = " + xListView + " ,adapter = " + xBaseAdapter + ", listener = " + cVar);
        }
        this.f178154i = xListView;
        this.C = xBaseAdapter;
        this.f178155m = cVar;
        CommonAudioPlayer commonAudioPlayer = this.H;
        if (commonAudioPlayer != null) {
            commonAudioPlayer.R(cVar);
        }
        this.D = bVar;
        this.f178153h = z16;
        this.N = z17;
        this.K = false;
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        E();
        F();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action != null && action.equals(ITroopHWApi.ACTION_START_VIDEO_CHAT)) {
            boolean booleanExtra = intent.getBooleanExtra("updateTime", false);
            boolean booleanExtra2 = intent.getBooleanExtra(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TIME, false);
            if (QLog.isColorLevel()) {
                QLog.d(com.tencent.mobileqq.tritonaudio.inneraudio.MediaPlayerManager.TAG, 2, "receive action_recv_video_request. update:" + booleanExtra + ", show:" + booleanExtra2);
            }
            if (booleanExtra && booleanExtra2) {
                ChatActivityUtils.I();
            }
            D(true);
            return;
        }
        if (IECScreenReceiver.ACTION_SCREEN_OFF.equals(action)) {
            D(false);
        }
    }

    public ChatMessage s() {
        return this.f178152f;
    }

    public boolean t() {
        if (this.f178152f != null) {
            return true;
        }
        return false;
    }

    void v() {
        if (QLog.isColorLevel()) {
            QLog.d(com.tencent.mobileqq.tritonaudio.inneraudio.MediaPlayerManager.TAG, 2, "$onStop");
        }
        c cVar = this.f178155m;
        if (cVar != null) {
            cVar.onPlayStop();
        }
    }

    public boolean x(ChatMessage chatMessage) {
        return y(chatMessage, false);
    }

    public boolean y(ChatMessage chatMessage, boolean z16) {
        return z(chatMessage, z16, 0);
    }

    public boolean z(ChatMessage chatMessage, boolean z16, int i3) {
        boolean L1;
        ChatMessage chatMessage2 = this.E;
        if (chatMessage2 != null && (chatMessage2 instanceof MessageForPtt)) {
            ((MessageForPtt) chatMessage2).playProgress = 0.0f;
        }
        A(this.G, chatMessage);
        this.F = chatMessage;
        if (this.C != null && chatMessage != null && this.f178151e != null) {
            if (n(false, false)) {
                if (com.tencent.mobileqq.utils.ah.n0()) {
                    this.I = true;
                } else {
                    WeakReference<QQAppInterface> weakReference = this.f178151e;
                    if (weakReference != null && weakReference.get() != null) {
                        this.I = com.tencent.mobileqq.qqaudio.audioplayer.c.b(this.f178151e.get());
                    }
                }
                boolean f16 = com.tencent.mobileqq.qqaudio.audioplayer.c.f(BaseApplication.getContext());
                boolean c16 = com.tencent.mobileqq.qqaudio.audioplayer.c.c(BaseApplication.getContext());
                int o16 = o(chatMessage, this.C);
                if (z16) {
                    L1 = false;
                } else {
                    this.N = true;
                    XListView xListView = this.f178154i;
                    L1 = p(chatMessage).L1(this.f178154i, o16, l.E(xListView, xListView.getHeaderViewsCount() + o16), chatMessage, this.H, i3);
                }
                if (L1) {
                    this.f178152f = chatMessage;
                    this.M = false;
                    this.F = null;
                    this.G = null;
                    c cVar = this.f178155m;
                    if (cVar != null) {
                        cVar.onPlayStart();
                        this.f178155m.k(f16, c16, this.I, false);
                    }
                    this.J = false;
                    return true;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(com.tencent.mobileqq.tritonaudio.inneraudio.MediaPlayerManager.TAG, 2, "builder play failed.");
                }
            } else if (QLog.isColorLevel()) {
                QLog.d(com.tencent.mobileqq.tritonaudio.inneraudio.MediaPlayerManager.TAG, 2, "doStop failed.");
            }
        } else if (QLog.isColorLevel()) {
            QLog.d(com.tencent.mobileqq.tritonaudio.inneraudio.MediaPlayerManager.TAG, 2, "request play failed, mAdapter = " + this.C + ", msg = " + chatMessage + ", app = " + this.f178151e);
        }
        this.F = null;
        this.G = null;
        return false;
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase.b
    public void f9(AudioPlayerBase audioPlayerBase, String str) {
    }
}
