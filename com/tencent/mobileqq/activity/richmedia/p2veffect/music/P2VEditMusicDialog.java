package com.tencent.mobileqq.activity.richmedia.p2veffect.music;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.b;
import com.tencent.biz.qqstory.model.a;
import com.tencent.biz.qqstory.model.c;
import com.tencent.biz.qqstory.model.i;
import com.tencent.biz.qqstory.network.pb.qqstory_service$RspGetMusicListConfig;
import com.tencent.biz.qqstory.takevideo.music.MusicHorizontalSeekView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.utils.en;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import jd0.a;
import jd0.d;

@TargetApi(11)
/* loaded from: classes10.dex */
public class P2VEditMusicDialog extends Dialog implements MusicHorizontalSeekView.a, AdapterView.OnItemClickListener, View.OnClickListener, b.InterfaceC0941b<cd0.c, dd0.c>, wc0.a {

    /* renamed from: i0, reason: collision with root package name */
    private static final String f185862i0 = "P2VEditMusicDialog";
    protected GridView C;
    protected jd0.b D;
    protected MusicHorizontalSeekView E;
    protected TextView F;
    protected TextView G;
    protected View H;
    protected TextView I;
    protected TextView J;
    protected TextView K;
    protected TextView L;
    protected ProgressBar M;
    protected View N;
    protected View P;
    protected wc0.c Q;
    protected Timer R;
    protected MusicPlayTask S;
    ArrayList<d> T;
    protected HashMap<String, String> U;
    protected HashMap<String, Long> V;
    protected int W;
    protected int X;
    protected long Y;
    protected long Z;

    /* renamed from: a0, reason: collision with root package name */
    protected d f185863a0;

    /* renamed from: b0, reason: collision with root package name */
    protected int f185864b0;

    /* renamed from: c0, reason: collision with root package name */
    protected boolean f185865c0;

    /* renamed from: d0, reason: collision with root package name */
    public c f185866d0;

    /* renamed from: e0, reason: collision with root package name */
    private jd0.a f185867e0;

    /* renamed from: f0, reason: collision with root package name */
    protected Handler f185868f0;

    /* renamed from: g0, reason: collision with root package name */
    protected volatile int f185869g0;

    /* renamed from: h0, reason: collision with root package name */
    private c.a<a.c> f185870h0;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public class MusicPlayTask extends TimerTask {
        protected MusicPlayTask() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (P2VEditMusicDialog.this.f185866d0.g() != null) {
                P2VEditMusicDialog.this.X++;
                QLog.isColorLevel();
                P2VEditMusicDialog.this.f185868f0.sendEmptyMessage(8);
            }
        }
    }

    /* loaded from: classes10.dex */
    class b extends Handler {
        b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    P2VEditMusicDialog.this.f0();
                    P2VEditMusicDialog p2VEditMusicDialog = P2VEditMusicDialog.this;
                    jd0.b bVar = p2VEditMusicDialog.D;
                    if (bVar != null) {
                        bVar.e(p2VEditMusicDialog.T);
                        P2VEditMusicDialog.this.D.notifyDataSetChanged();
                    }
                    d g16 = P2VEditMusicDialog.this.f185866d0.g();
                    jd0.b bVar2 = P2VEditMusicDialog.this.D;
                    if (bVar2 != null) {
                        bVar2.f(g16);
                    }
                    if (g16 != null) {
                        int i3 = g16.f409844h;
                        if (i3 == 0) {
                            P2VEditMusicDialog.this.f185868f0.sendEmptyMessage(3);
                            return;
                        }
                        if (i3 == 1) {
                            P2VEditMusicDialog.this.f185868f0.sendEmptyMessage(6);
                            return;
                        }
                        if (!TextUtils.isEmpty(g16.f409846j)) {
                            P2VEditMusicDialog.this.f185868f0.sendEmptyMessage(2);
                            return;
                        }
                        P2VEditMusicDialog p2VEditMusicDialog2 = P2VEditMusicDialog.this;
                        if (p2VEditMusicDialog2.f185865c0) {
                            p2VEditMusicDialog2.f185865c0 = false;
                            p2VEditMusicDialog2.Y(g16);
                            return;
                        }
                        return;
                    }
                    if (!P2VEditMusicDialog.this.f185866d0.h()) {
                        P2VEditMusicDialog.this.f185868f0.sendEmptyMessage(3);
                        return;
                    } else {
                        P2VEditMusicDialog.this.f185868f0.sendEmptyMessage(6);
                        return;
                    }
                case 2:
                    P2VEditMusicDialog.this.f0();
                    d g17 = P2VEditMusicDialog.this.f185866d0.g();
                    if (g17 == null) {
                        if (QLog.isColorLevel()) {
                            QLog.e(P2VEditMusicDialog.f185862i0, 2, "MSG_PLAY_MUSIC music is NULL!!!!!");
                            return;
                        }
                        return;
                    }
                    String str = g17.f409846j;
                    if (str == null) {
                        QLog.e(P2VEditMusicDialog.f185862i0, 2, "MSG_PLAY_MUSIC music.download_path is NULL!!!!!");
                        return;
                    }
                    int duration = (int) ShortVideoUtils.getDuration(str);
                    g17.f409849m = duration;
                    if (g17.f409847k < 0) {
                        g17.f409847k = 0;
                    }
                    int i16 = g17.f409847k;
                    P2VEditMusicDialog p2VEditMusicDialog3 = P2VEditMusicDialog.this;
                    int i17 = p2VEditMusicDialog3.W;
                    if (i16 + i17 > duration) {
                        g17.f409847k = 0;
                    }
                    g17.f409848l = g17.f409847k + i17;
                    p2VEditMusicDialog3.f185866d0.j(3);
                    P2VEditMusicDialog.this.M.setVisibility(8);
                    P2VEditMusicDialog.this.N.setVisibility(0);
                    P2VEditMusicDialog.this.H.setVisibility(0);
                    P2VEditMusicDialog.this.G.setVisibility(8);
                    P2VEditMusicDialog.this.F.setText(g17.f409838b);
                    P2VEditMusicDialog.this.c0();
                    MusicHorizontalSeekView.a((P2VEditMusicDialog.this.P() + 500) / 1000, P2VEditMusicDialog.this.getContext().getResources().getDisplayMetrics().widthPixels - ViewUtils.dip2px(8.0f));
                    P2VEditMusicDialog p2VEditMusicDialog4 = P2VEditMusicDialog.this;
                    p2VEditMusicDialog4.E.setDurations((p2VEditMusicDialog4.P() + 500) / 1000, (Math.max(g17.f409849m, P2VEditMusicDialog.this.W) + 500) / 1000);
                    P2VEditMusicDialog.this.E.c(g17.f409847k);
                    P2VEditMusicDialog.this.g0(g17.f409847k, g17.f409848l);
                    return;
                case 3:
                    P2VEditMusicDialog.this.f0();
                    P2VEditMusicDialog.this.f185866d0.f(d.f409834n);
                    P2VEditMusicDialog.this.f185866d0.j(0);
                    P2VEditMusicDialog.this.F.setText("");
                    P2VEditMusicDialog.this.G.setText(HardCodeUtil.qqStr(R.string.oyz));
                    P2VEditMusicDialog.this.G.setVisibility(0);
                    P2VEditMusicDialog.this.H.setVisibility(8);
                    return;
                case 4:
                case 5:
                case 10:
                default:
                    return;
                case 6:
                    P2VEditMusicDialog.this.f0();
                    P2VEditMusicDialog.this.f185866d0.f(d.f409835o);
                    P2VEditMusicDialog.this.f185866d0.j(1);
                    P2VEditMusicDialog.this.F.setText("");
                    P2VEditMusicDialog.this.G.setText(HardCodeUtil.qqStr(R.string.oyy));
                    P2VEditMusicDialog.this.G.setVisibility(0);
                    P2VEditMusicDialog.this.H.setVisibility(8);
                    P2VEditMusicDialog.this.Z();
                    return;
                case 7:
                    QQToast.makeText(P2VEditMusicDialog.this.getContext(), (String) message.obj, 0).show();
                    return;
                case 8:
                    P2VEditMusicDialog p2VEditMusicDialog5 = P2VEditMusicDialog.this;
                    p2VEditMusicDialog5.E.setPlayedPosition(p2VEditMusicDialog5.X);
                    return;
                case 9:
                    if (P2VEditMusicDialog.this.M.getVisibility() != 0) {
                        P2VEditMusicDialog.this.M.setVisibility(0);
                        P2VEditMusicDialog.this.N.setVisibility(8);
                    }
                    P2VEditMusicDialog.this.M.setProgress(message.arg1);
                    return;
                case 11:
                    P2VEditMusicDialog.this.f0();
                    d dVar = P2VEditMusicDialog.this.f185863a0;
                    int duration2 = (int) ShortVideoUtils.getDuration(dVar.f409846j);
                    dVar.f409849m = duration2;
                    if (dVar.f409847k < 0) {
                        dVar.f409847k = 0;
                    }
                    int i18 = dVar.f409847k;
                    P2VEditMusicDialog p2VEditMusicDialog6 = P2VEditMusicDialog.this;
                    int i19 = p2VEditMusicDialog6.W;
                    if (i18 + i19 > duration2) {
                        dVar.f409847k = 0;
                    }
                    dVar.f409848l = dVar.f409847k + i19;
                    p2VEditMusicDialog6.f185866d0.f(dVar);
                    P2VEditMusicDialog.this.f185866d0.j(3);
                    P2VEditMusicDialog.this.M.setVisibility(8);
                    P2VEditMusicDialog.this.N.setVisibility(0);
                    P2VEditMusicDialog.this.H.setVisibility(0);
                    P2VEditMusicDialog.this.G.setVisibility(8);
                    P2VEditMusicDialog.this.F.setText(dVar.f409838b);
                    P2VEditMusicDialog.this.c0();
                    P2VEditMusicDialog p2VEditMusicDialog7 = P2VEditMusicDialog.this;
                    p2VEditMusicDialog7.E.setDurations((p2VEditMusicDialog7.P() + 500) / 1000, (Math.max(dVar.f409849m, P2VEditMusicDialog.this.W) + 500) / 1000);
                    P2VEditMusicDialog.this.E.c(dVar.f409847k);
                    P2VEditMusicDialog.this.g0(dVar.f409847k, dVar.f409848l);
                    return;
                case 12:
                    P2VEditMusicDialog.this.R((d) message.obj);
                    return;
            }
        }
    }

    /* loaded from: classes10.dex */
    public interface c {
        void a();

        boolean b();

        void c();

        boolean d();

        void e(String str);

        void f(d dVar);

        d g();

        boolean h();

        void i();

        void j(int i3);

        void k();
    }

    public P2VEditMusicDialog(Context context, c cVar, int i3, boolean z16) {
        super(context, R.style.DialogNoBackground);
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.H = null;
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        this.M = null;
        this.N = null;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.S = null;
        this.T = new ArrayList<>();
        this.U = new HashMap<>();
        this.V = new HashMap<>();
        this.W = 0;
        this.X = 0;
        this.Y = 1000L;
        this.Z = 0L;
        this.f185868f0 = new b();
        this.f185869g0 = 0;
        this.f185870h0 = new c.a<a.c>() { // from class: com.tencent.mobileqq.activity.richmedia.p2veffect.music.P2VEditMusicDialog.4
            @Override // com.tencent.biz.qqstory.model.c.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void b(boolean z17, final a.c cVar2) {
                hd0.c.a(P2VEditMusicDialog.f185862i0, "onAddressUpdate.");
                if (z17 && cVar2 != null) {
                    hd0.c.b(P2VEditMusicDialog.f185862i0, "onAddressUpdate success, address=%s", cVar2);
                    P2VEditMusicDialog.this.f185868f0.post(new Runnable() { // from class: com.tencent.mobileqq.activity.richmedia.p2veffect.music.P2VEditMusicDialog.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            hd0.c.a(P2VEditMusicDialog.f185862i0, "address update, refresh ui.");
                            if (((com.tencent.biz.qqstory.model.a) ((com.tencent.biz.qqstory.model.d) i.c(20)).b(1)).h(cVar2)) {
                                QLog.d(P2VEditMusicDialog.f185862i0, 2, "isInternationalUser --------------------2");
                                P2VEditMusicDialog.this.D.d();
                            }
                        }
                    });
                } else {
                    hd0.c.g(P2VEditMusicDialog.f185862i0, "onAddressUpdate failed.");
                }
            }
        };
        super.requestWindowFeature(1);
        this.W = i3;
        this.f185865c0 = z16;
        this.f185866d0 = cVar;
        this.f185867e0 = new jd0.a(context, new a(), this.f185868f0);
        U(context);
        WindowManager.LayoutParams attributes = super.getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        attributes.windowAnimations = R.style.f173456dv;
        super.getWindow().setBackgroundDrawable(new ColorDrawable());
    }

    public static void Q(Activity activity) {
        Intent intent = new Intent(activity, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", String.format(AEEditorConstants.QIM_LOAD_QQ_MUSIC_URL, ah.z(), "", 5));
        intent.putExtra(QQBrowserActivity.EXTRA_FINISH_ANIMATION_UP_DOWN, true);
        activity.startActivityForResult(intent, 1000);
        activity.overridePendingTransition(R.anim.f154424l, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z() {
        this.f185866d0.a();
    }

    private void a0() {
        this.f185866d0.f(this.f185863a0);
        d dVar = this.f185863a0;
        if (dVar != null) {
            int i3 = dVar.f409844h;
            if (i3 == 1) {
                this.f185868f0.sendEmptyMessage(6);
                return;
            }
            if (i3 == 0) {
                this.f185868f0.sendEmptyMessage(3);
                return;
            } else if (!TextUtils.isEmpty(dVar.f409846j)) {
                this.f185868f0.sendEmptyMessage(11);
                return;
            } else {
                this.f185868f0.sendEmptyMessage(6);
                this.f185866d0.f(d.f409835o);
                return;
            }
        }
        this.f185868f0.sendEmptyMessage(6);
        this.f185866d0.f(d.f409835o);
    }

    private void b0() {
        d dVar;
        int i3;
        d g16 = this.f185866d0.g();
        if (g16 != null && (dVar = this.f185863a0) != null && ((i3 = g16.f409844h) == 3 || i3 == 2)) {
            g16.f409837a.equals(dVar.f409837a);
        }
        dismiss();
    }

    protected int P() {
        int i3 = this.W;
        if (i3 < 5000) {
            return 5000;
        }
        return i3;
    }

    public void R(d dVar) {
        if (!TextUtils.isEmpty(dVar.f409840d) || !TextUtils.isEmpty(dVar.f409846j)) {
            this.H.setVisibility(0);
            this.G.setVisibility(8);
            this.F.setText(dVar.f409838b);
            this.N.setVisibility(8);
        }
        this.f185866d0.f(dVar);
        Y(dVar);
        id0.b.i("0X80076D6");
    }

    public void S() {
        d0();
        W();
    }

    public void U(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.b7m, (ViewGroup) null);
        super.setContentView(inflate);
        if (this.W < 5000) {
            this.Y = r1 / 6;
        } else {
            this.Y = 1000L;
        }
        this.M = (ProgressBar) inflate.findViewById(R.id.f3c);
        this.N = inflate.findViewById(R.id.f166353f34);
        MusicHorizontalSeekView musicHorizontalSeekView = (MusicHorizontalSeekView) inflate.findViewById(R.id.f36);
        this.E = musicHorizontalSeekView;
        musicHorizontalSeekView.setOnSeekListener(this);
        this.F = (TextView) inflate.findViewById(R.id.f37);
        this.I = (TextView) super.findViewById(R.id.ill);
        this.J = (TextView) super.findViewById(R.id.ilk);
        this.K = (TextView) super.findViewById(R.id.f3_);
        this.L = (TextView) super.findViewById(R.id.f3a);
        this.K.setOnClickListener(this);
        this.L.setOnClickListener(this);
        TextView textView = (TextView) inflate.findViewById(R.id.f165089bw3);
        this.G = textView;
        textView.setText("");
        this.H = inflate.findViewById(R.id.imf);
        if (this.f185866d0.b()) {
            GridView gridView = (GridView) inflate.findViewById(R.id.f166354f35);
            this.C = gridView;
            gridView.setNumColumns(-1);
            this.C.setSelector(new ColorDrawable(0));
            this.C.setOverScrollMode(2);
            this.C.setOnItemClickListener(this);
            View findViewById = inflate.findViewById(R.id.bmh);
            this.P = findViewById;
            findViewById.setOnClickListener(this);
            jd0.b bVar = new jd0.b(context, this.C, !this.f185866d0.h(), true);
            this.D = bVar;
            this.C.setAdapter((ListAdapter) bVar);
            this.D.e(null);
        } else {
            inflate.findViewById(R.id.bjy).getLayoutParams().height = BaseAIOUtils.f(138.0f, context.getResources());
            inflate.findViewById(R.id.f38).setVisibility(8);
        }
        if (this.f185866d0.g() != null) {
            d dVar = new d();
            this.f185863a0 = dVar;
            dVar.a(this.f185866d0.g());
        } else {
            this.f185863a0 = this.f185866d0.g();
        }
        this.T = d.b(getContext());
        this.f185868f0.sendEmptyMessage(1);
        if (NetworkUtil.isNetSupport(getContext())) {
            this.Z = System.currentTimeMillis();
            com.tencent.biz.qqstory.channel.b.a().b(new cd0.c(), this);
        } else {
            this.f185868f0.sendEmptyMessage(1);
            QQToast.makeText(getContext(), HardCodeUtil.qqStr(R.string.oyx), 0).show();
        }
    }

    public void W() {
        e0();
        this.R = new BaseTimer();
        MusicPlayTask musicPlayTask = new MusicPlayTask();
        this.S = musicPlayTask;
        Timer timer = this.R;
        long j3 = this.Y;
        if (j3 <= 0) {
            j3 = 1000;
        }
        timer.schedule(musicPlayTask, 0L, j3);
    }

    @Override // com.tencent.biz.qqstory.channel.b.InterfaceC0941b
    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public void v(cd0.c cVar, dd0.c cVar2, ErrorMessage errorMessage) {
        String errorMessage2;
        if (QLog.isColorLevel()) {
            String str = f185862i0;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onCmdRespond = ");
            sb5.append(System.currentTimeMillis() - this.Z);
            sb5.append(", errorMsg = ");
            if (errorMessage == null) {
                errorMessage2 = "null";
            } else {
                errorMessage2 = errorMessage.getErrorMessage();
            }
            sb5.append(errorMessage2);
            QLog.d(str, 2, sb5.toString());
        }
        id0.a.n("edit_video", "music_list_time", 0, 0, String.valueOf(System.currentTimeMillis() - this.Z), "", "", "");
        if (errorMessage != null && errorMessage.isFail()) {
            Message obtainMessage = this.f185868f0.obtainMessage(7);
            obtainMessage.obj = "onCmdRespond error = " + errorMessage.getErrorMessage();
            this.f185868f0.sendMessage(obtainMessage);
            id0.a.n("edit_video", "music_list_failed", 0, 0, "", "", "", "");
            return;
        }
        qqstory_service$RspGetMusicListConfig qqstory_service_rspgetmusiclistconfig = cVar2.f393629c;
        int size = qqstory_service_rspgetmusiclistconfig.music_config.size();
        ArrayList<d> arrayList = new ArrayList<>(size);
        if (size > 0) {
            for (int i3 = 0; i3 < size; i3++) {
                arrayList.add(new d(qqstory_service_rspgetmusiclistconfig.music_config.get(i3)));
            }
            if (QLog.isColorLevel()) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("GetMusicConfigResponse size = " + size);
                for (int i16 = 0; i16 < size; i16++) {
                    d dVar = arrayList.get(i16);
                    stringBuffer.append(", " + i16 + ": title = " + dVar.f409838b + ", audioUrl = " + dVar.f409840d);
                }
                QLog.d(f185862i0, 2, stringBuffer.toString());
            }
        } else if (QLog.isColorLevel()) {
            QLog.e(f185862i0, 2, "onCmdRespond data is NULL!!!!!");
        }
        id0.a.n("edit_video", "music_list_count", 0, 0, String.valueOf(size), "", "", "");
        this.T = arrayList;
        d.c(getContext(), arrayList);
        this.f185868f0.sendEmptyMessage(1);
    }

    protected void Y(d dVar) {
        final String str = dVar.f409840d;
        String str2 = dVar.f409846j;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            QLog.e(f185862i0, 1, "playCacheMusicOrDownload - musicUrl\u3001localPath both null \uff1f\uff01");
            return;
        }
        if (!com.tencent.biz.qqstory.utils.d.j(str2)) {
            str2 = this.U.get(str);
            if (!com.tencent.biz.qqstory.utils.d.j(str2)) {
                str2 = jd0.c.a(str);
            }
        }
        if (com.tencent.biz.qqstory.utils.d.j(str2)) {
            wc0.c cVar = this.Q;
            if (cVar != null && cVar.g()) {
                FileUtils.deleteFile(this.Q.f());
                this.Q.c();
            }
            if (this.f185866d0.g() != null) {
                this.f185866d0.e(str2);
                this.f185868f0.sendEmptyMessage(2);
            } else {
                QLog.e(f185862i0, 1, "getCurFragmentMusic - urMusic is null");
            }
            QLog.d(f185862i0, 2, "exists audio_url = " + str + ", path = " + str2);
            return;
        }
        if (!NetworkUtil.isNetworkAvailable(BaseApplication.getContext())) {
            d0();
            QQToast.makeText(BaseApplication.getContext(), R.string.d6b, 0).show();
            return;
        }
        this.V.put(str, Long.valueOf(System.currentTimeMillis()));
        this.U.put(str, str2);
        wc0.c cVar2 = this.Q;
        if (cVar2 != null && cVar2.g()) {
            FileUtils.deleteFile(this.Q.f());
            this.Q.c();
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.activity.richmedia.p2veffect.music.P2VEditMusicDialog.3
            @Override // java.lang.Runnable
            public void run() {
                String a16 = jd0.c.a(str);
                P2VEditMusicDialog.this.Q = new wc0.c();
                P2VEditMusicDialog p2VEditMusicDialog = P2VEditMusicDialog.this;
                p2VEditMusicDialog.Q.b(p2VEditMusicDialog);
                P2VEditMusicDialog.this.Q.a(str, a16, 0L);
            }
        }, 5, null, true);
    }

    @Override // com.tencent.biz.qqstory.takevideo.music.MusicHorizontalSeekView.a
    public void a(int i3, int i16, int i17) {
        d g16 = this.f185866d0.g();
        if (g16 != null) {
            int i18 = (int) (g16.f409849m * (i17 / i3));
            g16.f409847k = i18;
            int i19 = this.W + i18;
            g16.f409848l = i19;
            g0(i18, i19);
        }
    }

    protected void c0() {
        this.f185866d0.k();
    }

    protected void d0() {
        jd0.b bVar;
        d g16 = this.f185866d0.g();
        if (g16 != null && g16.f409844h == 3 && (bVar = this.D) != null && bVar.a(g16) > 0 && !g16.equals(this.D.b())) {
            this.D.f(g16);
            this.D.notifyDataSetChanged();
            if (QLog.isColorLevel()) {
                QLog.d(f185862i0, 2, "checkButtonState \u6309\u94ae\u9519\u4f4d!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            }
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        this.f185867e0.f();
        wc0.c cVar = this.Q;
        if (cVar != null && cVar.g()) {
            FileUtils.deleteFile(this.Q.f());
            this.Q.c();
        }
        ((com.tencent.biz.qqstory.model.a) ((com.tencent.biz.qqstory.model.d) i.c(20)).b(1)).g(this.f185870h0);
        e0();
        c0();
        super.dismiss();
    }

    protected void e0() {
        Timer timer = this.R;
        if (timer != null) {
            timer.cancel();
            this.R = null;
        }
        MusicPlayTask musicPlayTask = this.S;
        if (musicPlayTask != null) {
            musicPlayTask.cancel();
            this.S = null;
        }
        this.X = -1;
        this.f185868f0.sendEmptyMessage(8);
    }

    protected void f0() {
        e0();
        this.f185866d0.c();
    }

    @Override // com.tencent.biz.qqstory.takevideo.music.MusicHorizontalSeekView.a
    public void g(int i3, int i16, int i17) {
        f0();
        a(i3, i16, i17);
    }

    protected void g0(int i3, int i16) {
        int i17 = 1000;
        int i18 = ((i16 - i3) / 1000) * 1000;
        if (i18 >= 1000) {
            i17 = i18;
        }
        if (this.f185864b0 == 1) {
            double d16 = i17;
            if (d16 > 8500.0d && d16 < 13500.0d) {
                i17 = 10000;
            }
        }
        int i19 = i17 + i3;
        if (QLog.isColorLevel()) {
            QLog.d(f185862i0, 2, "start = " + i3 + ", end = " + i16 + ", displayEnd = " + i19);
        }
        this.I.setText(en.j(i3, false));
        this.J.setText(en.j(i19, true));
    }

    @Override // com.tencent.biz.qqstory.takevideo.music.MusicHorizontalSeekView.a
    public void h(int i3, int i16) {
        int measureText = (int) (this.I.getPaint().measureText(QzoneConfig.ALBUM_RECOM_EVENT_ALGO_USER_SAMPLE_DEFAULT) / 2.0f);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.I.getLayoutParams();
        layoutParams.leftMargin = i3 - measureText;
        this.I.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.J.getLayoutParams();
        layoutParams2.leftMargin = i16 - (measureText * 2);
        this.J.setLayoutParams(layoutParams2);
    }

    @Override // com.tencent.biz.qqstory.takevideo.music.MusicHorizontalSeekView.a
    public void k(int i3, int i16, int i17) {
        a(i3, i16, i17);
        c0();
    }

    @Override // wc0.a
    public void l(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d(f185862i0, 2, "onDownloadStart() url = " + str + ", dstPath = " + str2);
        }
        this.f185869g0 = 0;
        Message obtainMessage = this.f185868f0.obtainMessage(9);
        obtainMessage.arg1 = 0;
        this.f185868f0.sendMessage(obtainMessage);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        a0();
        super.onBackPressed();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.f3_) {
            a0();
            dismiss();
        } else if (id5 == R.id.f3a) {
            b0();
        } else if (id5 == R.id.bmh) {
            b0();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
        EventCollector.getInstance().onItemClickBefore(adapterView, view, i3, j3);
        jd0.b bVar = this.D;
        if (bVar != null) {
            d dVar = (d) bVar.getItem(i3);
            if (dVar == null) {
                if (QLog.isColorLevel()) {
                    QLog.e(f185862i0, 2, "onItemClick error musicInfo = " + ((Object) null));
                }
            } else {
                this.D.f(dVar);
                this.D.notifyDataSetChanged();
                if (i3 < this.D.c()) {
                    f0();
                    int i16 = dVar.f409844h;
                    if (i16 == 0) {
                        this.f185866d0.f(dVar);
                        this.f185868f0.sendEmptyMessage(3);
                    } else if (i16 == 1) {
                        this.f185866d0.f(dVar);
                        this.f185868f0.sendEmptyMessage(6);
                    } else if (i16 == 2) {
                        if (!NetworkUtil.isNetworkAvailable(BaseApplication.getContext())) {
                            d0();
                            QQToast.makeText(BaseApplication.getContext(), R.string.d6b, 0).show();
                        } else {
                            this.f185866d0.i();
                            if (!this.f185866d0.d() && (getContext() instanceof ContextThemeWrapper) && (((ContextThemeWrapper) getContext()).getBaseContext() instanceof Activity)) {
                                Q((Activity) ((ContextThemeWrapper) getContext()).getBaseContext());
                            }
                        }
                    }
                } else {
                    f0();
                    if (!TextUtils.isEmpty(dVar.f409840d)) {
                        this.H.setVisibility(0);
                        this.G.setVisibility(8);
                        this.F.setText(dVar.f409838b);
                        this.N.setVisibility(8);
                    }
                    this.f185866d0.f(dVar);
                    Y(dVar);
                    id0.a.n("video_edit", "add_music", 0, 0, "1", "", "", "");
                }
            }
        }
        EventCollector.getInstance().onItemClick(adapterView, view, i3, j3);
    }

    @Override // wc0.a
    public void onProgress(String str, long j3, long j16) {
        float f16 = ((float) j3) / ((float) j16);
        if (f16 >= this.f185869g0 * 0.05f) {
            this.f185869g0++;
            Message obtainMessage = this.f185868f0.obtainMessage(9);
            obtainMessage.arg1 = (int) (100.0f * f16);
            this.f185868f0.sendMessage(obtainMessage);
            if (QLog.isColorLevel()) {
                QLog.d(f185862i0, 2, "onProgress() mIndex = " + this.f185869g0 + ", progress = " + f16 + ", cur = " + j3 + ", size = " + j16);
            }
        }
    }

    @Override // wc0.a
    public void q(String str, int i3) {
        String a16 = jd0.c.a(str);
        if (i3 == 0) {
            this.f185869g0 = 0;
            if (QLog.isColorLevel()) {
                QLog.d(f185862i0, 2, "onDownloadFinish() url = " + str);
            }
            if (this.U == null) {
                this.U = new HashMap<>();
            }
            this.U.put(str, a16);
            d g16 = this.f185866d0.g();
            if (g16 != null && str.equals(g16.f409840d)) {
                this.f185866d0.e(a16);
                this.f185868f0.sendEmptyMessage(2);
                getContext().getSharedPreferences("VideoMusicCache", 0).edit().putString(g16.f409837a, a16).apply();
            }
            id0.a.n("edit_video", "music_download_success", 0, 0, "", "", "", "");
        } else {
            id0.a.n("edit_video", "music_download_failed", 0, 0, String.valueOf(i3), "", "", "");
            id0.b.i("0X80076D9");
        }
        if (QLog.isColorLevel()) {
            long longValue = this.V.get(str).longValue();
            StringBuffer stringBuffer = new StringBuffer("onDownloadFinish errCode = ");
            stringBuffer.append(i3);
            stringBuffer.append(", name = ");
            stringBuffer.append(com.tencent.biz.qqstory.utils.d.n(str));
            stringBuffer.append(", downloadTime = ");
            stringBuffer.append(System.currentTimeMillis() - longValue);
            stringBuffer.append(", fileSize = ");
            stringBuffer.append(com.tencent.biz.qqstory.utils.d.o(a16));
            stringBuffer.append(", url = " + str);
            QLog.d(f185862i0, 2, stringBuffer.toString());
        }
    }

    /* loaded from: classes10.dex */
    class a implements a.c {
        a() {
        }

        @Override // jd0.a.c
        public void a(d dVar) {
            P2VEditMusicDialog.this.R(dVar);
        }

        @Override // jd0.a.c
        public void b() {
            P2VEditMusicDialog.this.S();
        }

        @Override // jd0.a.c
        public void c() {
        }
    }
}
