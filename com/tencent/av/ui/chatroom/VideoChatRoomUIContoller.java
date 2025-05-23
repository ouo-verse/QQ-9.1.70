package com.tencent.av.ui.chatroom;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.EditText;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.chatroom.ChatRoomInfo;
import com.tencent.av.chatroom.ChatRoomMng;
import com.tencent.av.foldable.FoldInfoUtils;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.av.ui.aj;
import com.tencent.av.widget.RotateLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.widget.f;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public class VideoChatRoomUIContoller {

    /* renamed from: a, reason: collision with root package name */
    private VideoChatRoomContainer f75480a;

    /* renamed from: b, reason: collision with root package name */
    private final AVActivity f75481b;

    /* renamed from: c, reason: collision with root package name */
    private final VideoAppInterface f75482c;

    /* renamed from: d, reason: collision with root package name */
    private final c f75483d;

    /* renamed from: e, reason: collision with root package name */
    private final d f75484e;

    /* renamed from: h, reason: collision with root package name */
    private boolean f75487h;

    /* renamed from: i, reason: collision with root package name */
    private e f75488i;

    /* renamed from: f, reason: collision with root package name */
    private boolean f75485f = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f75486g = false;

    /* renamed from: j, reason: collision with root package name */
    private ArrayList<com.tencent.av.chatroom.a> f75489j = new ArrayList<>(10);

    /* renamed from: k, reason: collision with root package name */
    private ArrayList<com.tencent.av.ui.chatroom.b> f75490k = new ArrayList<>(10);

    /* renamed from: l, reason: collision with root package name */
    private ArrayList<com.tencent.av.ui.chatroom.b> f75491l = new ArrayList<>(10);

    /* renamed from: m, reason: collision with root package name */
    private List<com.tencent.av.ui.chatroom.b> f75492m = null;

    /* renamed from: n, reason: collision with root package name */
    private StringBuilder f75493n = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class b extends f {
        b() {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            VideoChatRoomUIContoller.this.f75480a.setVisibility(8);
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z16) {
            onAnimationEnd(animator);
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator, boolean z16) {
            onAnimationStart(animator);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class c implements com.tencent.av.chatroom.b {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<VideoChatRoomUIContoller> f75496a;

        c(VideoChatRoomUIContoller videoChatRoomUIContoller) {
            this.f75496a = new WeakReference<>(videoChatRoomUIContoller);
        }

        @Override // com.tencent.av.chatroom.b
        public void a(com.tencent.av.chatroom.a aVar) {
            if (QLog.isDevelopLevel()) {
                QLog.i("VideoChatRoomUIContoller", 4, "onChatRoomSendMsgResult, msg[" + aVar + "]");
            }
            VideoChatRoomUIContoller videoChatRoomUIContoller = this.f75496a.get();
            if (aVar != null && videoChatRoomUIContoller != null && videoChatRoomUIContoller.p()) {
                videoChatRoomUIContoller.D(aVar.f73523a);
            }
        }

        @Override // com.tencent.av.chatroom.b
        public void b(int i3, ChatRoomInfo chatRoomInfo) {
            boolean z16;
            if ((i3 & 4) == 4) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (QLog.isDevelopLevel()) {
                QLog.i("VideoChatRoomUIContoller", 4, "onChatRoomMsgUpdate, flag[" + i3 + "], room[" + chatRoomInfo + "]");
            }
            VideoChatRoomUIContoller videoChatRoomUIContoller = this.f75496a.get();
            if (videoChatRoomUIContoller == null) {
                return;
            }
            if (videoChatRoomUIContoller.p()) {
                videoChatRoomUIContoller.D(chatRoomInfo);
                return;
            }
            if (z16) {
                if (!videoChatRoomUIContoller.f75486g) {
                    videoChatRoomUIContoller.B(0);
                    return;
                }
                videoChatRoomUIContoller.f75485f = true;
                long d16 = com.tencent.av.utils.e.d();
                if (videoChatRoomUIContoller.f75481b.I0 == null) {
                    return;
                }
                videoChatRoomUIContoller.f75481b.I0.i1(d16, 65536);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class d implements Observer {

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<VideoChatRoomUIContoller> f75497d;

        d(VideoChatRoomUIContoller videoChatRoomUIContoller) {
            this.f75497d = new WeakReference<>(videoChatRoomUIContoller);
        }

        @Override // java.util.Observer
        public void update(Observable observable, Object obj) {
            VideoChatRoomUIContoller videoChatRoomUIContoller;
            Object[] objArr = (Object[]) obj;
            if (((Integer) objArr[0]).intValue() == 6503 && (videoChatRoomUIContoller = this.f75497d.get()) != null && objArr.length >= 2) {
                Object obj2 = objArr[1];
                if ((obj2 instanceof Boolean) && !((Boolean) obj2).booleanValue()) {
                    videoChatRoomUIContoller.v();
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface e {
        void a(boolean z16);
    }

    public VideoChatRoomUIContoller(AVActivity aVActivity, VideoAppInterface videoAppInterface) {
        this.f75481b = aVActivity;
        this.f75482c = videoAppInterface;
        d dVar = new d(this);
        this.f75484e = dVar;
        c cVar = new c(this);
        this.f75483d = cVar;
        videoAppInterface.addObserver(dVar);
        ChatRoomMng D = videoAppInterface.D();
        if (D != null) {
            D.b(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(int i3) {
        this.f75487h = true;
        e eVar = this.f75488i;
        if (eVar != null) {
            eVar.a(true);
        }
        SessionInfo f16 = n.e().f();
        if (!f16.Y2 && !f16.f73060o0 && !f16.f73098x2) {
            aj ajVar = this.f75481b.I0;
            if (ajVar == null) {
                return;
            }
            VideoChatRoomContainer videoChatRoomContainer = this.f75480a;
            if (videoChatRoomContainer != null && videoChatRoomContainer.getVisibility() == 0) {
                if (QLog.isDevelopLevel()) {
                    QLog.i("VideoChatRoomUIContoller", 4, "ChatRoomPanel has already show");
                    return;
                }
                return;
            }
            if (this.f75480a == null) {
                this.f75480a = m();
            }
            this.f75480a.setVisibility(0);
            C();
            if (i3 == 2) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f75480a, "TranslationX", n(), 0.0f);
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f75480a, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(ofFloat, ofFloat2);
                animatorSet.setDuration(300L);
                animatorSet.start();
            } else if (i3 == 0) {
                this.f75480a.setTranslationX(0.0f);
                this.f75480a.setAlpha(1.0f);
            }
            E(ajVar.k());
            v();
            ChatRoomMng D = this.f75482c.D();
            if (D != null) {
                ChatRoomInfo k3 = D.k(f16, true);
                if (QLog.isColorLevel()) {
                    QLog.i("ChatRoomUtil", 2, String.format("showChatRoomPanelWithAnimation, session[%s], chat_room[%s]", f16, k3));
                }
                D(k3);
            }
            com.tencent.av.chatroom.c.e("0X800A8D3");
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("VideoChatRoomUIContoller", 4, "ChatRoomPanel can not show when recording.");
        }
    }

    private void C() {
        if (!this.f75481b.Z0.i(1)) {
            this.f75481b.Z0.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(ChatRoomInfo chatRoomInfo) {
        if (chatRoomInfo == null) {
            return;
        }
        this.f75489j.clear();
        ChatRoomMng D = this.f75482c.D();
        if (D != null) {
            D.g(chatRoomInfo, this.f75489j);
        }
        List<com.tencent.av.ui.chatroom.b> list = this.f75492m;
        ArrayList<com.tencent.av.ui.chatroom.b> arrayList = this.f75490k;
        if (list == arrayList && list == (arrayList = this.f75491l)) {
            arrayList = null;
        }
        j(this.f75489j, arrayList);
        this.f75492m = arrayList;
        this.f75481b.runOnUiThread(new Runnable() { // from class: com.tencent.av.ui.chatroom.VideoChatRoomUIContoller.3
            @Override // java.lang.Runnable
            public void run() {
                if (QLog.isDevelopLevel() && VideoChatRoomUIContoller.this.f75492m != null) {
                    if (VideoChatRoomUIContoller.this.f75493n == null) {
                        VideoChatRoomUIContoller.this.f75493n = new StringBuilder(300);
                    }
                    VideoChatRoomUIContoller.this.f75493n.setLength(0);
                    VideoChatRoomUIContoller.this.f75493n.append("updateChatRoomMsgList, list[");
                    for (com.tencent.av.ui.chatroom.b bVar : VideoChatRoomUIContoller.this.f75492m) {
                        if (bVar != null) {
                            StringBuilder sb5 = VideoChatRoomUIContoller.this.f75493n;
                            sb5.append(bVar.c());
                            sb5.append(", ");
                        }
                    }
                    VideoChatRoomUIContoller.this.f75493n.append("]");
                    QLog.i("ChatRoomUtil", 4, VideoChatRoomUIContoller.this.f75493n.toString());
                }
                if (VideoChatRoomUIContoller.this.f75480a != null && VideoChatRoomUIContoller.this.f75492m != null) {
                    VideoChatRoomUIContoller.this.f75480a.g(VideoChatRoomUIContoller.this.f75492m, true);
                }
            }
        });
    }

    private void j(List<com.tencent.av.chatroom.a> list, List<com.tencent.av.ui.chatroom.b> list2) {
        int i3;
        if (list != null && list2 != null) {
            String currentAccountUin = this.f75482c.getCurrentAccountUin();
            list2.clear();
            for (com.tencent.av.chatroom.a aVar : list) {
                if (aVar != null) {
                    String valueOf = String.valueOf(aVar.f73524b);
                    com.tencent.av.ui.chatroom.b d16 = com.tencent.av.ui.chatroom.b.d();
                    d16.h(valueOf);
                    d16.g(aVar.f73525c);
                    if (TextUtils.equals(valueOf, currentAccountUin)) {
                        i3 = 1;
                    } else {
                        i3 = 2;
                    }
                    d16.j(i3);
                    d16.i(String.format("%s|%s", Long.valueOf(aVar.f73529g), Long.valueOf(aVar.f73526d)));
                    list2.add(d16);
                }
            }
        }
    }

    private VideoChatRoomContainer m() {
        int i3;
        if (this.f75480a == null) {
            ((ViewStub) this.f75481b.findViewById(R.id.f166588cp4)).inflate();
            VideoChatRoomContainer videoChatRoomContainer = (VideoChatRoomContainer) this.f75481b.findViewById(R.id.f166564cp2);
            this.f75480a = videoChatRoomContainer;
            videoChatRoomContainer.h(this.f75482c);
            if (this.f75481b.isInFoldingMode()) {
                if (FoldInfoUtils.j(this.f75481b)) {
                    i3 = 270;
                } else {
                    i3 = 90;
                }
                w(i3);
            }
        }
        return this.f75480a;
    }

    private int n() {
        VideoChatRoomContainer videoChatRoomContainer = this.f75480a;
        if (videoChatRoomContainer == null) {
            return 0;
        }
        int width = videoChatRoomContainer.getWidth();
        if (width == 0) {
            this.f75480a.measure(0, 0);
            return this.f75480a.getMeasuredWidth();
        }
        return width;
    }

    public void A(int i3) {
        if (QLog.isDevelopLevel()) {
            QLog.i("VideoChatRoomUIContoller", 4, "showChatRoomPanel, which[" + i3 + "]");
        }
        this.f75485f = false;
        B(i3);
    }

    public void E(int i3) {
        boolean z16;
        SessionInfo sessionInfo;
        int i16;
        AVActivity aVActivity;
        VideoLayerUI videoLayerUI;
        if (p()) {
            if (i3 > 20) {
                z16 = true;
            } else {
                z16 = false;
            }
            int g36 = this.f75481b.g3();
            int dimensionPixelSize = this.f75481b.getResources().getDimensionPixelSize(R.dimen.a7y);
            if (r.h0() != null) {
                sessionInfo = n.e().f();
            } else {
                sessionInfo = null;
            }
            if (g36 == 4 && sessionInfo != null && sessionInfo.N() && sessionInfo.P() && (videoLayerUI = (aVActivity = this.f75481b).J0) != null && z16) {
                i16 = ((int) (i3 + (BaseAIOUtils.f(videoLayerUI.I0, aVActivity.getResources()) * 0.4f))) + this.f75481b.getResources().getDimensionPixelSize(R.dimen.b8s);
            } else {
                i16 = i3;
            }
            if (sessionInfo != null && sessionInfo.P()) {
                i16 += dimensionPixelSize;
            }
            if (QLog.isDevelopLevel()) {
                QLog.i("ChatRoomUtil", 4, String.format("updateChatRoomPanel, [%s --> %s], layoutMode[%s]", Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(this.f75481b.g3())));
            }
            this.f75480a.i(i16);
        }
    }

    public void k(boolean z16) {
        EditText editText;
        InputFilter[] filters;
        if (!z16) {
            n.e().f().f73018e2 = p();
        } else {
            n.e().f().f73018e2 = false;
        }
        ChatRoomMng D = this.f75482c.D();
        if (D != null) {
            D.u(this.f75483d);
        }
        this.f75482c.deleteObserver(this.f75484e);
        VideoChatRoomContainer videoChatRoomContainer = this.f75480a;
        if (videoChatRoomContainer != null) {
            editText = videoChatRoomContainer.f75472h;
        } else {
            editText = null;
        }
        if (editText != null) {
            Editable text = editText.getText();
            if (text == null) {
                filters = null;
            } else {
                filters = text.getFilters();
            }
            for (int i3 = 0; filters != null && i3 < filters.length; i3++) {
                filters[i3] = null;
            }
        }
        this.f75485f = false;
        this.f75486g = false;
        if (QLog.isColorLevel()) {
            QLog.i("ChatRoomUtil", 2, "VideoChatRoomUIContoller-destroy, isQuit[" + z16 + "], mCheckFirstShowChatRoomPanel[" + n.e().f().f73018e2 + "]");
        }
    }

    public int l() {
        if (p()) {
            return this.f75480a.j();
        }
        return 0;
    }

    public void o(int i3) {
        if (QLog.isDevelopLevel()) {
            QLog.i("ChatRoomUtil", 4, "hideChatRoomPanel, from[" + i3 + "]");
        }
        this.f75487h = false;
        e eVar = this.f75488i;
        if (eVar != null && i3 != 3) {
            eVar.a(false);
        }
        if (p()) {
            if (i3 == 2) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(300L);
                alphaAnimation.setAnimationListener(new a());
                this.f75480a.startAnimation(alphaAnimation);
                return;
            }
            if (i3 == 1) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f75480a, "TranslationX", 0.0f, n());
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f75480a, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(ofFloat, ofFloat2);
                animatorSet.setDuration(300L);
                animatorSet.addListener(new b());
                animatorSet.start();
                return;
            }
            this.f75480a.setVisibility(8);
        }
    }

    public boolean p() {
        VideoChatRoomContainer videoChatRoomContainer = this.f75480a;
        if (videoChatRoomContainer != null && videoChatRoomContainer.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public boolean q() {
        return this.f75487h;
    }

    public boolean r() {
        return this.f75485f;
    }

    public boolean s() {
        VideoChatRoomContainer videoChatRoomContainer = this.f75480a;
        if (videoChatRoomContainer != null && videoChatRoomContainer.p()) {
            return true;
        }
        return false;
    }

    public boolean t() {
        if (p()) {
            return this.f75480a.s();
        }
        return false;
    }

    public void u(String str) {
        ChatRoomMng D;
        ChatRoomInfo k3;
        if (str != null && str.length() > 0 && (D = this.f75482c.D()) != null && (k3 = D.k(n.e().f(), true)) != null) {
            D.w(k3, str, System.currentTimeMillis());
        }
    }

    public void v() {
        if (p()) {
            VideoChatRoomContainer videoChatRoomContainer = this.f75480a;
            AVActivity aVActivity = this.f75481b;
            videoChatRoomContainer.t(aVActivity.J0, aVActivity.g3());
        }
    }

    public void w(int i3) {
        VideoChatRoomContainer videoChatRoomContainer = this.f75480a;
        if (videoChatRoomContainer != null) {
            RotateLayout.LayoutParams layoutParams = (RotateLayout.LayoutParams) videoChatRoomContainer.getLayoutParams();
            if (layoutParams.f77225a == i3) {
                return;
            }
            layoutParams.f77225a = i3;
            this.f75480a.requestLayout();
        }
    }

    public void x(e eVar) {
        this.f75488i = eVar;
    }

    public void y(boolean z16) {
        this.f75485f = z16;
    }

    public void z(boolean z16) {
        this.f75486g = z16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (VideoChatRoomUIContoller.this.f75480a != null) {
                VideoChatRoomUIContoller.this.f75480a.setVisibility(8);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
