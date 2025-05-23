package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.b;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.VoicePlayer;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.troop_homework.TroopHomeworkHelper;
import java.io.File;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes19.dex */
public class AudioItem extends d<c, com.tencent.mobileqq.troop.homework.xmediaeditor.model.a> {
    static IPatchRedirector $redirector_;
    private com.tencent.mobileqq.troop.homework.xmediaeditor.model.a C;
    boolean D;
    private VoicePlayer.a E;
    private BroadcastReceiver F;

    /* renamed from: f, reason: collision with root package name */
    private LayoutInflater f297419f;

    /* renamed from: h, reason: collision with root package name */
    private Context f297420h;

    /* renamed from: i, reason: collision with root package name */
    private VoicePlayer f297421i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f297422m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class AudioUploadCallback implements TroopHomeworkHelper.f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        com.tencent.mobileqq.troop.homework.xmediaeditor.model.a f297426a;

        public AudioUploadCallback(com.tencent.mobileqq.troop.homework.xmediaeditor.model.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AudioItem.this, (Object) aVar);
            } else {
                this.f297426a = aVar;
            }
        }

        @Override // cooperation.troop_homework.TroopHomeworkHelper.f
        public void onComplete(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                return;
            }
            com.tencent.mobileqq.troop.homework.xmediaeditor.model.a aVar = this.f297426a;
            aVar.f297417d = 3;
            aVar.i(str);
            ((Activity) AudioItem.this.f297420h).runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem.AudioUploadCallback.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AudioUploadCallback.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    AudioUploadCallback audioUploadCallback = AudioUploadCallback.this;
                    if (audioUploadCallback.f297426a.f297409a < AudioItem.this.f297478d.getAdapter().getItemCount()) {
                        AudioUploadCallback audioUploadCallback2 = AudioUploadCallback.this;
                        AudioItem audioItem = AudioItem.this;
                        audioItem.f297479e.e(audioItem.f297478d.findViewHolderForAdapterPosition(audioUploadCallback2.f297426a.f297409a), true);
                        AudioUploadCallback audioUploadCallback3 = AudioUploadCallback.this;
                        c cVar = (c) AudioItem.this.f297478d.findViewHolderForAdapterPosition(audioUploadCallback3.f297426a.f297409a);
                        if (cVar != null) {
                            AudioUploadCallback audioUploadCallback4 = AudioUploadCallback.this;
                            if (audioUploadCallback4.f297426a.f297407k) {
                                AnimationDrawable animationDrawable = (AnimationDrawable) AudioItem.this.f297420h.getResources().getDrawable(R.anim.f155003ge);
                                cVar.f297432e.setImageDrawable(animationDrawable);
                                animationDrawable.start();
                            } else {
                                cVar.f297432e.setImageResource(R.drawable.f162097fm2);
                            }
                            cVar.f297435i.setVisibility(0);
                            cVar.f297432e.setVisibility(0);
                            cVar.f297434h.setVisibility(4);
                        }
                    }
                }
            });
            long elapsedRealtime = SystemClock.elapsedRealtime();
            com.tencent.mobileqq.troop.homework.xmediaeditor.model.a aVar2 = this.f297426a;
            com.tencent.mobileqq.troop.homework.utils.a.c(0, "\u4e0a\u4f20\u97f3\u9891\u6210\u529f", elapsedRealtime - aVar2.f297408l, aVar2.f297405i / 1024, aVar2.c(), this.f297426a.f297406j);
        }

        @Override // cooperation.troop_homework.TroopHomeworkHelper.f
        public void onError(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3);
                return;
            }
            this.f297426a.f297417d = 2;
            ((Activity) AudioItem.this.f297420h).runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem.AudioUploadCallback.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AudioUploadCallback.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    AudioUploadCallback audioUploadCallback = AudioUploadCallback.this;
                    c cVar = (c) AudioItem.this.f297478d.findViewHolderForAdapterPosition(audioUploadCallback.f297426a.f297409a);
                    if (cVar != null) {
                        AudioUploadCallback audioUploadCallback2 = AudioUploadCallback.this;
                        if (audioUploadCallback2.f297426a.f297407k) {
                            AnimationDrawable animationDrawable = (AnimationDrawable) AudioItem.this.f297420h.getResources().getDrawable(R.anim.f155003ge);
                            cVar.f297432e.setImageDrawable(animationDrawable);
                            animationDrawable.start();
                        } else {
                            cVar.f297432e.setImageResource(R.drawable.f162097fm2);
                        }
                        cVar.f297435i.setVisibility(4);
                        cVar.f297432e.setVisibility(4);
                        cVar.f297434h.setVisibility(0);
                    }
                }
            });
            long elapsedRealtime = SystemClock.elapsedRealtime();
            com.tencent.mobileqq.troop.homework.xmediaeditor.model.a aVar = this.f297426a;
            com.tencent.mobileqq.troop.homework.utils.a.c(i3, "\u4e0a\u4f20\u97f3\u9891\u5931\u8d25", elapsedRealtime - aVar.f297408l, aVar.f297405i / 1024, aVar.c(), this.f297426a.f297406j);
        }

        @Override // cooperation.troop_homework.TroopHomeworkHelper.f
        public void onProgress(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a implements VoicePlayer.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AudioItem.this);
            }
        }

        @Override // com.tencent.mobileqq.utils.VoicePlayer.a
        public void c5(String str, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            }
        }

        @Override // com.tencent.mobileqq.utils.VoicePlayer.a
        public void ic(String str, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            }
        }

        @Override // com.tencent.mobileqq.utils.VoicePlayer.a
        public void u4(int i3, String str, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), str, Integer.valueOf(i16));
            } else {
                AudioItem audioItem = AudioItem.this;
                audioItem.A(audioItem.C);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class b extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AudioItem.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            String action = intent.getAction();
            if ("com.tencent.mobileqq.activity.ai.audiopanel.startrecord_action".equals(action)) {
                AudioItem audioItem = AudioItem.this;
                audioItem.A(audioItem.C);
            } else if ("com.tencent.mobileqq.troop.homework.xmediaeditor.ui.action_play_video".equals(action)) {
                AudioItem audioItem2 = AudioItem.this;
                audioItem2.A(audioItem2.C);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class c extends b.a<com.tencent.mobileqq.troop.homework.xmediaeditor.model.a> {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        public ImageView f297432e;

        /* renamed from: f, reason: collision with root package name */
        public ImageView f297433f;

        /* renamed from: h, reason: collision with root package name */
        public ImageView f297434h;

        /* renamed from: i, reason: collision with root package name */
        public TextView f297435i;

        /* renamed from: m, reason: collision with root package name */
        public View f297436m;

        public c(View view) {
            super(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
                return;
            }
            this.f297436m = view;
            this.f297432e = (ImageView) view.findViewById(R.id.a0k);
            this.f297434h = (ImageView) view.findViewById(R.id.i9d);
            this.f297433f = (ImageView) view.findViewById(R.id.azb);
            this.f297435i = (TextView) view.findViewById(R.id.a0o);
        }
    }

    public AudioItem(XMediaEditor xMediaEditor, Context context) {
        super(xMediaEditor);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) xMediaEditor, (Object) context);
            return;
        }
        this.f297422m = false;
        this.D = false;
        this.E = new a();
        this.F = new b();
        this.f297420h = context;
        this.f297419f = LayoutInflater.from(context);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mobileqq.activity.ai.audiopanel.startrecord_action");
        intentFilter.addAction("com.tencent.mobileqq.troop.homework.xmediaeditor.ui.action_play_video");
        if (!this.D) {
            this.f297420h.registerReceiver(this.F, intentFilter);
            this.D = true;
        }
    }

    private void r(com.tencent.mobileqq.troop.homework.xmediaeditor.model.a aVar) {
        TroopHomeworkHelper.UploadFileTask uploadFileTask = new TroopHomeworkHelper.UploadFileTask(MobileQQ.sMobileQQ.waitAppRuntime(null), aVar.f297402f, aVar.f297406j);
        uploadFileTask.k(new AudioUploadCallback(aVar));
        aVar.f297417d = 1;
        aVar.f297408l = SystemClock.elapsedRealtime();
        ThreadManagerV2.post(new Runnable(uploadFileTask) { // from class: com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ TroopHomeworkHelper.UploadFileTask f297425d;

            {
                this.f297425d = uploadFileTask;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AudioItem.this, (Object) uploadFileTask);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    this.f297425d.l();
                }
            }
        }, 8, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(com.tencent.mobileqq.troop.homework.xmediaeditor.model.a aVar) {
        if (this.f297422m) {
            return;
        }
        this.f297422m = true;
        this.C = aVar;
        aVar.f297407k = true;
        VoicePlayer voicePlayer = new VoicePlayer(aVar.f297402f, new Handler());
        this.f297421i = voicePlayer;
        voicePlayer.y(this.f297420h);
        this.f297421i.z();
        this.f297421i.l(this.E);
        this.f297421i.A();
        c cVar = (c) this.f297478d.findViewHolderForAdapterPosition(aVar.f297409a);
        if (cVar != null) {
            if (aVar.f297407k) {
                AnimationDrawable animationDrawable = (AnimationDrawable) this.f297420h.getResources().getDrawable(R.anim.f155003ge);
                cVar.f297432e.setImageDrawable(animationDrawable);
                animationDrawable.start();
                return;
            }
            cVar.f297432e.setImageResource(R.drawable.f162097fm2);
        }
    }

    public void A(com.tencent.mobileqq.troop.homework.xmediaeditor.model.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) aVar);
            return;
        }
        if (aVar != null && aVar.f297407k) {
            this.f297422m = false;
            this.f297421i.v();
            this.f297421i = null;
            aVar.f297407k = false;
            this.C = null;
            c cVar = (c) this.f297478d.findViewHolderForAdapterPosition(aVar.f297409a);
            if (cVar != null) {
                if (aVar.f297407k) {
                    AnimationDrawable animationDrawable = (AnimationDrawable) this.f297420h.getResources().getDrawable(R.anim.f155003ge);
                    cVar.f297432e.setImageDrawable(animationDrawable);
                    animationDrawable.start();
                    return;
                }
                cVar.f297432e.setImageResource(R.drawable.f162097fm2);
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.xmediaeditor.ui.a
    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (this.f297422m) {
            A(this.C);
        }
        if (this.D) {
            this.f297420h.unregisterReceiver(this.F);
            this.D = false;
        }
    }

    public void q(com.tencent.mobileqq.troop.homework.xmediaeditor.model.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) aVar);
        } else if (TextUtils.isEmpty(aVar.f297403g) && aVar.f297417d == 0) {
            r(aVar);
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.xmediaeditor.ui.a
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void a(c cVar, com.tencent.mobileqq.troop.homework.xmediaeditor.model.a aVar, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, cVar, aVar, Integer.valueOf(i3));
            return;
        }
        if (i3 != 0) {
            cVar.f297432e.setVisibility(0);
            cVar.f297433f.setVisibility(4);
            cVar.f297434h.setVisibility(4);
        } else {
            cVar.f297433f.setVisibility(0);
            int i16 = aVar.f297417d;
            if (i16 != 0) {
                if (i16 != 1) {
                    if (i16 != 2) {
                        if (i16 == 3) {
                            cVar.f297435i.setVisibility(0);
                            cVar.f297432e.setVisibility(0);
                            cVar.f297434h.setVisibility(4);
                        }
                    } else {
                        cVar.f297435i.setVisibility(4);
                        cVar.f297432e.setVisibility(4);
                        cVar.f297434h.setVisibility(0);
                    }
                } else {
                    cVar.f297435i.setVisibility(4);
                    cVar.f297432e.setVisibility(4);
                    cVar.f297434h.setVisibility(4);
                }
            } else {
                cVar.f297435i.setVisibility(4);
                cVar.f297432e.setVisibility(4);
                cVar.f297434h.setVisibility(4);
            }
        }
        cVar.f297435i.setText(aVar.f297404h + "\"");
        if (aVar.f297407k) {
            AnimationDrawable animationDrawable = (AnimationDrawable) this.f297420h.getResources().getDrawable(R.anim.f155003ge);
            cVar.f297432e.setImageDrawable(animationDrawable);
            animationDrawable.start();
            return;
        }
        cVar.f297432e.setImageResource(R.drawable.f162097fm2);
    }

    @Override // com.tencent.mobileqq.troop.homework.xmediaeditor.ui.a
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public c b(ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (c) iPatchRedirector.redirect((short) 2, (Object) this, (Object) viewGroup);
        }
        c cVar = new c(this.f297419f.inflate(R.layout.b3l, viewGroup, false));
        l(cVar.f297433f, cVar);
        l(cVar.f297434h, cVar);
        l(cVar.f297436m, cVar);
        if (this.f297478d.w() != 0) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) cVar.itemView.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = this.f297478d.w();
            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = this.f297478d.w();
        }
        return cVar;
    }

    @Override // com.tencent.mobileqq.troop.homework.xmediaeditor.ui.a
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void c(com.tencent.mobileqq.troop.homework.xmediaeditor.model.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) aVar);
        } else {
            q(aVar);
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.xmediaeditor.ui.a
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public void e(View view, c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view, (Object) cVar);
            return;
        }
        int id5 = view.getId();
        if (id5 == R.id.a0r) {
            if (TextUtils.isEmpty(((com.tencent.mobileqq.troop.homework.xmediaeditor.model.a) cVar.f297481d).f297402f) && TextUtils.isEmpty(((com.tencent.mobileqq.troop.homework.xmediaeditor.model.a) cVar.f297481d).f297403g)) {
                return;
            }
            z((com.tencent.mobileqq.troop.homework.xmediaeditor.model.a) cVar.f297481d);
            return;
        }
        if (id5 == R.id.i9d) {
            r((com.tencent.mobileqq.troop.homework.xmediaeditor.model.a) cVar.f297481d);
            cVar.f297435i.setVisibility(4);
            cVar.f297432e.setVisibility(4);
            cVar.f297434h.setVisibility(4);
            return;
        }
        if (id5 == R.id.azb) {
            this.f297479e.b(cVar);
            com.tencent.mobileqq.troop.homework.xmediaeditor.model.a aVar = this.C;
            if (aVar != null && aVar.f297407k && aVar.f297409a == ((com.tencent.mobileqq.troop.homework.xmediaeditor.model.a) cVar.f297481d).f297409a) {
                A(aVar);
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.xmediaeditor.ui.d
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void m(com.tencent.mobileqq.troop.homework.xmediaeditor.model.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) aVar);
        } else if (TextUtils.isEmpty(aVar.f297403g) && aVar.f297417d == 1) {
            r(aVar);
        }
    }

    public void y(com.tencent.mobileqq.troop.homework.xmediaeditor.model.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) aVar);
            return;
        }
        if (!TextUtils.isEmpty(aVar.f297402f) && new File(aVar.f297402f).exists()) {
            x(aVar);
            return;
        }
        if (!TextUtils.isEmpty(aVar.f297403g)) {
            if (!NetworkUtil.isNetworkAvailable(this.f297420h)) {
                Context context = this.f297420h;
                QQToast.makeText(context, context.getString(R.string.c4w), 0).show();
            } else {
                ThreadManagerV2.post(new Runnable(aVar) { // from class: com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ com.tencent.mobileqq.troop.homework.xmediaeditor.model.a f297423d;

                    {
                        this.f297423d = aVar;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AudioItem.this, (Object) aVar);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        String h16 = TroopHomeworkHelper.h(this.f297423d.f297403g);
                        this.f297423d.h(h16);
                        if (!TextUtils.isEmpty(h16)) {
                            ((Activity) AudioItem.this.f297420h).runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem.1.1
                                static IPatchRedirector $redirector_;

                                {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                        iPatchRedirector3.redirect((short) 2, (Object) this);
                                    } else {
                                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                        AudioItem.this.x(anonymousClass1.f297423d);
                                    }
                                }
                            });
                        }
                    }
                }, 8, null, true);
            }
        }
    }

    public void z(com.tencent.mobileqq.troop.homework.xmediaeditor.model.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) aVar);
            return;
        }
        if (this.f297422m) {
            if (aVar.f297407k) {
                A(aVar);
                return;
            } else {
                A(this.C);
                y(aVar);
                return;
            }
        }
        y(aVar);
    }
}
