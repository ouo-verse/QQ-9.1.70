package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.tencent.aio.data.AIOContact;
import com.tencent.common.config.AppSetting;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AdapterView;
import com.tencent.widget.GestureSelectGridView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public class ChatHistoryEmotionView extends ChatHistoryViewBase implements Handler.Callback, AdapterView.OnItemClickListener, AbsListView.OnScrollListener, GestureSelectGridView.OnSelectListener {
    static IPatchRedirector $redirector_;
    private View C;
    public com.tencent.mobileqq.emotionintegrate.i D;
    private final WeakReferenceHandler E;
    private int F;
    private int G;
    private String H;
    private Parcelable I;
    private AIOContact J;
    private com.tencent.mobileqq.emotionintegrate.r K;
    private boolean L;
    private boolean M;
    private boolean N;
    private int P;
    private int Q;
    long R;
    boolean S;
    public boolean T;
    public int U;

    /* renamed from: f, reason: collision with root package name */
    private QQAppInterface f175253f;

    /* renamed from: h, reason: collision with root package name */
    private Activity f175254h;

    /* renamed from: i, reason: collision with root package name */
    private View f175255i;

    /* renamed from: m, reason: collision with root package name */
    private GestureSelectGridView f175256m;

    public ChatHistoryEmotionView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.E = new WeakReferenceHandler(Looper.getMainLooper(), this);
        this.F = 0;
        this.L = false;
        this.N = false;
        this.P = Integer.MIN_VALUE;
        this.Q = Integer.MAX_VALUE;
        this.R = 0L;
        this.S = false;
        this.U = 2;
    }

    private boolean r(com.tencent.mobileqq.emotionintegrate.s sVar, boolean z16) {
        ChatHistoryFileActivity chatHistoryFileActivity = this.f175325e;
        if (chatHistoryFileActivity != null && sVar.f205290b != z16) {
            if (z16) {
                if (chatHistoryFileActivity.R2()) {
                    return false;
                }
                sVar.f205290b = true;
                this.f175325e.L2(sVar);
            } else {
                sVar.f205290b = false;
                chatHistoryFileActivity.W2(sVar);
            }
        }
        return true;
    }

    @Override // com.tencent.mobileqq.activity.ChatHistoryViewBase
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        com.tencent.mobileqq.emotionintegrate.i iVar = this.D;
        if (iVar.L) {
            this.L = false;
            iVar.L = false;
            this.f175256m.setSelectMode(false);
            this.D.notifyDataSetChanged();
        }
    }

    @Override // com.tencent.mobileqq.activity.ChatHistoryViewBase
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        com.tencent.mobileqq.emotionintegrate.i iVar = this.D;
        if (!iVar.L) {
            this.L = true;
            iVar.L = true;
            this.f175256m.setSelectMode(true);
            this.D.notifyDataSetChanged();
        }
    }

    @Override // com.tencent.mobileqq.activity.ChatHistoryViewBase
    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            AbstractGifImage.pauseAll();
            this.S = false;
        }
    }

    @Override // com.tencent.mobileqq.activity.ChatHistoryViewBase
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            AbstractGifImage.resumeAll();
            this.S = true;
        }
    }

    @Override // com.tencent.mobileqq.activity.ChatHistoryViewBase
    public View e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f175255i;
    }

    @Override // com.tencent.mobileqq.activity.ChatHistoryViewBase
    public boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return this.L;
    }

    @Override // com.tencent.mobileqq.activity.ChatHistoryViewBase
    public void h(long j3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, j3);
            return;
        }
        List<MessageRecord> f16 = this.D.f();
        if (f16 != null) {
            Iterator<MessageRecord> it = f16.iterator();
            while (it.hasNext()) {
                if (it.next().uniseq == j3) {
                    z16 = true;
                    break;
                }
            }
        }
        z16 = false;
        if (!z16) {
            if (QLog.isColorLevel()) {
                QLog.d("ChatHistoryEmotionView", 2, "onRevokeMsg notContain seq:" + j3);
                return;
            }
            return;
        }
        if (j3 == this.R) {
            this.E.post(new Runnable() { // from class: com.tencent.mobileqq.activity.ChatHistoryEmotionView.4
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatHistoryEmotionView.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    ChatHistoryEmotionView chatHistoryEmotionView = ChatHistoryEmotionView.this;
                    if (chatHistoryEmotionView.S) {
                        com.tencent.mobileqq.activity.aio.photo.b.c(chatHistoryEmotionView.f175254h);
                    }
                    ChatHistoryEmotionView.this.s();
                }
            });
        } else {
            s();
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        List<MessageRecord> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) message)).booleanValue();
        }
        if (message.what == 1) {
            Object obj = message.obj;
            if (obj == null) {
                list = new ArrayList<>();
            } else {
                list = (List) obj;
            }
            if (message.arg1 == 1) {
                this.D.t(list);
            } else {
                this.D.p(list);
                if (list.isEmpty()) {
                    this.C.setVisibility(0);
                }
            }
        }
        return false;
    }

    @Override // com.tencent.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, adapterView, view, Integer.valueOf(i3), Long.valueOf(j3));
            return;
        }
        Object item = this.D.getItem(i3);
        if (!com.tencent.mobileqq.emotionintegrate.s.class.isInstance(item)) {
            return;
        }
        com.tencent.mobileqq.emotionintegrate.s sVar = (com.tencent.mobileqq.emotionintegrate.s) item;
        if (this.L) {
            if (r(sVar, !sVar.f205290b)) {
                this.D.notifyDataSetChanged();
                return;
            }
            return;
        }
        if (this.T) {
            com.tencent.imcore.message.report.a.j(this.f175253f, 4, this.U);
        }
        SessionInfo sessionInfo = new SessionInfo();
        sessionInfo.f179557e = this.H;
        int i16 = this.G;
        sessionInfo.f179555d = i16;
        Parcelable parcelable = this.I;
        if (parcelable != null && (parcelable instanceof SessionInfo)) {
            sessionInfo.f179559f = ((SessionInfo) parcelable).f179559f;
        }
        if (view == null) {
            QLog.d("ChatHistoryEmotionView", 1, "onItemClick: view is null, return directly");
        } else if (i16 == 10014) {
            AIOEmotionFragment.ei(view.getContext(), sVar.f205289a, sessionInfo, com.tencent.common.galleryactivity.j.d(view));
        } else {
            AIOEmotionFragment.ci(view.getContext(), sVar.f205289a, sessionInfo, this.J, com.tencent.common.galleryactivity.j.d(view), true, true, null);
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, absListView, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) absListView, i3);
            return;
        }
        if (i3 == 0) {
            int lastVisiblePosition = this.f175256m.getLastVisiblePosition();
            int g16 = this.D.g();
            int e16 = this.D.e();
            if ((lastVisiblePosition >= g16 - 28 || lastVisiblePosition == g16) && this.F != e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("ChatHistoryEmotionView", 2, "[onScroll] loadEmotion: mLastLoadingCount=" + this.F);
                }
                this.F = e16;
                this.D.r(true);
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.ChatHistoryEmotionView.3
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatHistoryEmotionView.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        Message obtainMessage = ChatHistoryEmotionView.this.E.obtainMessage(1, ChatHistoryEmotionView.this.K.e(ChatHistoryEmotionView.this.H, ChatHistoryEmotionView.this.G, false, true));
                        obtainMessage.arg1 = 1;
                        ChatHistoryEmotionView.this.E.sendMessage(obtainMessage);
                    }
                }, 32, null, false);
            }
        }
    }

    @Override // com.tencent.widget.GestureSelectGridView.OnSelectListener
    public void onSelectBegin(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, i3);
            return;
        }
        if (!this.L || this.D.g() <= i3) {
            return;
        }
        Object h16 = this.D.h(i3);
        if (!com.tencent.mobileqq.emotionintegrate.s.class.isInstance(h16)) {
            return;
        }
        com.tencent.mobileqq.emotionintegrate.s sVar = (com.tencent.mobileqq.emotionintegrate.s) h16;
        boolean z16 = sVar.f205290b;
        this.N = z16;
        if (r(sVar, !z16)) {
            this.f175256m.invalidateViews();
        }
        this.M = true;
        if (QLog.isColorLevel()) {
            QLog.d("ChatHistoryEmotionView", 2, "onSelectBegin");
        }
    }

    @Override // com.tencent.widget.GestureSelectGridView.OnSelectListener
    public void onSelectChanged(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (!this.L || !this.M) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ChatHistoryEmotionView", 2, "onSelectBegin beginIndex:", Integer.valueOf(i3), "  selectIndex:", Integer.valueOf(i16));
        }
        if (i16 < i3) {
            if (this.Q > i16) {
                this.Q = i16;
            }
            i16 = i3;
            i3 = i16;
        } else if (this.P < i16) {
            this.P = i16;
        }
        for (int i17 = i3; i17 <= i16; i17++) {
            Object h16 = this.D.h(i17);
            if (com.tencent.mobileqq.emotionintegrate.s.class.isInstance(h16)) {
                r((com.tencent.mobileqq.emotionintegrate.s) h16, !this.N);
            }
        }
        for (int i18 = i16 + 1; i18 <= this.P; i18++) {
            Object h17 = this.D.h(i18);
            if (com.tencent.mobileqq.emotionintegrate.s.class.isInstance(h17)) {
                r((com.tencent.mobileqq.emotionintegrate.s) h17, this.N);
            }
        }
        for (int i19 = this.Q; i19 < i3; i19++) {
            Object h18 = this.D.h(i19);
            if (com.tencent.mobileqq.emotionintegrate.s.class.isInstance(h18)) {
                r((com.tencent.mobileqq.emotionintegrate.s) h18, this.N);
            }
        }
        this.f175256m.invalidateViews();
    }

    @Override // com.tencent.widget.GestureSelectGridView.OnSelectListener
    public void onSelectEnd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        if (!this.L || !this.M) {
            return;
        }
        this.M = false;
        this.N = false;
        this.P = Integer.MIN_VALUE;
        this.Q = Integer.MAX_VALUE;
        if (QLog.isColorLevel()) {
            QLog.d("ChatHistoryEmotionView", 2, "onSelectEnd");
        }
    }

    public void p(Intent intent, QQAppInterface qQAppInterface, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 2;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, intent, qQAppInterface, context);
            return;
        }
        this.f175254h = (Activity) context;
        int intExtra = intent.getIntExtra("uintype", -1);
        this.G = intExtra;
        if (intExtra == 0) {
            i3 = 1;
        }
        this.U = i3;
        this.H = intent.getStringExtra("uin");
        this.I = intent.getParcelableExtra(AppConstants.Key.SESSION_INFO);
        this.J = (AIOContact) intent.getParcelableExtra("nt_aio_contact_info");
        this.R = intent.getLongExtra("msg_revoke_uniseq", 0L);
        Parcelable parcelable = this.I;
        if (parcelable != null && (parcelable instanceof SessionInfo)) {
            int i16 = this.G;
            if (i16 == 10014) {
                this.K = new com.tencent.mobileqq.emotionintegrate.x((SessionInfo) parcelable, this.H, i16);
            } else {
                this.K = new com.tencent.mobileqq.emotionintegrate.r((SessionInfo) parcelable, this.H, i16, this.J);
            }
        } else {
            int i17 = this.G;
            if (i17 == 10014) {
                this.K = new com.tencent.mobileqq.emotionintegrate.x(this.H, i17);
            } else {
                this.K = new com.tencent.mobileqq.emotionintegrate.r(this.H, i17, this.J);
            }
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.ama, (ViewGroup) null);
        this.f175255i = inflate;
        GestureSelectGridView gestureSelectGridView = (GestureSelectGridView) inflate.findViewById(R.id.cx5);
        this.f175256m = gestureSelectGridView;
        gestureSelectGridView.setSelectMode(false);
        View findViewById = this.f175255i.findViewById(R.id.bwv);
        this.C = findViewById;
        if (AppSetting.f99565y) {
            findViewById.setContentDescription(this.f175254h.getString(R.string.f170954b82));
        }
        int dimensionPixelSize = this.f175254h.getResources().getDimensionPixelSize(R.dimen.f159226xw);
        int dimensionPixelSize2 = this.f175254h.getResources().getDimensionPixelSize(R.dimen.f159227xx);
        int dimensionPixelSize3 = this.f175254h.getResources().getDimensionPixelSize(R.dimen.f159228xy);
        int screenWidth = ((ViewUtils.getScreenWidth() - (dimensionPixelSize * 2)) - (dimensionPixelSize2 * 3)) / 4;
        this.f175256m.setGravity(3);
        this.f175256m.setScrollBarStyle(0);
        this.f175256m.setNumColumns(4);
        this.f175256m.setColumnWidth(screenWidth);
        this.f175256m.setHorizontalSpacing(dimensionPixelSize2);
        this.f175256m.setVerticalSpacing(dimensionPixelSize3);
        GestureSelectGridView gestureSelectGridView2 = this.f175256m;
        gestureSelectGridView2.setPadding(dimensionPixelSize, gestureSelectGridView2.getPaddingTop(), dimensionPixelSize, this.f175256m.getPaddingBottom());
        com.tencent.mobileqq.emotionintegrate.i iVar = new com.tencent.mobileqq.emotionintegrate.i(this.f175254h, this.K, this.E, screenWidth, this.f175256m);
        this.D = iVar;
        iVar.q(true);
        this.D.o(this.G);
        this.f175256m.setAdapter((ListAdapter) this.D);
        this.f175256m.setOnItemClickListener(this);
        this.f175256m.setOnScrollListener(this);
        this.f175256m.setOnIndexChangedListener(this);
        this.f175256m.setSelectMode(false);
        this.f175256m.setTouchSlopRate(3);
        AccessibilityUtil.n(this.f175256m, false);
        this.D.r(true);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.ChatHistoryEmotionView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatHistoryEmotionView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                ChatHistoryEmotionView.this.E.sendMessage(ChatHistoryEmotionView.this.E.obtainMessage(1, ChatHistoryEmotionView.this.K.e(ChatHistoryEmotionView.this.H, ChatHistoryEmotionView.this.G, false, false)));
            }
        }, 32, null, false);
    }

    public void q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            this.D.n();
        }
    }

    public void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.ChatHistoryEmotionView.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatHistoryEmotionView.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    ChatHistoryEmotionView.this.E.sendMessage(ChatHistoryEmotionView.this.E.obtainMessage(1, ChatHistoryEmotionView.this.K.e(ChatHistoryEmotionView.this.H, ChatHistoryEmotionView.this.G, true, false)));
                }
            }, 32, null, false);
        }
    }
}
