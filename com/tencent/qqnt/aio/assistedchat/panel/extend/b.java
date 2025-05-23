package com.tencent.qqnt.aio.assistedchat.panel.extend;

import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.view.MotionEvent;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.input.base.panelcontainer.h;
import com.tencent.mobileqq.aio.event.ShortCutBarEvent;
import com.tencent.mobileqq.aio.event.ShortcutEventIntent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.base.route.k;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.shortcutbar.g;
import com.tencent.qqnt.aio.utils.l;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000;\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\b*\u0001%\u0018\u0000 +2\u00020\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u00a2\u0006\u0004\b)\u0010*J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\u000b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\u000e\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0012\u001a\u00020\u0006J\u000e\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0002J\b\u0010\u0015\u001a\u00020\u0006H\u0016J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\u0006\u0010\u0017\u001a\u00020\u0004R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006,"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/panel/extend/b;", "Lcom/tencent/qqnt/aio/assistedchat/panel/extend/c;", "", "p", "", "dy", "", "k", "startHeight", "targetHeight", "duration", h.F, "offset", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqnt/aio/assistedchat/panel/extend/PanelExtendRecyclerView;", "recyclerView", "j", DomainData.DOMAIN_NAME, "intercept", "o", "onPullUp", "onPullDown", "l", "Lcom/tencent/aio/api/runtime/a;", "a", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "b", "I", "normalPanelHeight", "c", "maxPanelHeight", "Landroid/animation/ValueAnimator;", "d", "Landroid/animation/ValueAnimator;", "animator", "com/tencent/qqnt/aio/assistedchat/panel/extend/b$b", "e", "Lcom/tencent/qqnt/aio/assistedchat/panel/extend/b$b;", "shortcutInterceptListener", "<init>", "(Lcom/tencent/aio/api/runtime/a;)V", "f", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class b implements c {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.aio.api.runtime.a aioContext;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int normalPanelHeight;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int maxPanelHeight;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ValueAnimator animator;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final C9456b shortcutInterceptListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/panel/extend/b$a;", "", "", "ANIM_DURATION_DOWN", "I", "ANIM_DURATION_UP", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.assistedchat.panel.extend.b$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u000f"}, d2 = {"com/tencent/qqnt/aio/assistedchat/panel/extend/b$b", "Lcom/tencent/qqnt/aio/shortcutbar/g;", "Landroid/view/MotionEvent;", "event", "", "interceptTouchEvent", "handleTouchEvent", "", "d", UserInfo.SEX_FEMALE, "downY", "", "e", "I", "startPanelHeight", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.assistedchat.panel.extend.b$b, reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public static final class C9456b implements g {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private float downY;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private int startPanelHeight;

        C9456b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0030, code lost:
        
            if (r0 != 3) goto L34;
         */
        @Override // com.tencent.qqnt.aio.shortcutbar.g
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean handleTouchEvent(@NotNull MotionEvent event) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) event)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(event, "event");
            boolean z16 = false;
            if (!b.this.p()) {
                return false;
            }
            int action = event.getAction();
            if (action != 1) {
                if (action == 2) {
                    b.this.k((int) ((event.getY() - this.downY) + 0.5f));
                }
                return true;
            }
            int l3 = b.this.l();
            if (l3 != b.this.normalPanelHeight && l3 != b.this.maxPanelHeight) {
                if (Math.abs(l3 - this.startPanelHeight) > l.b(30)) {
                    z16 = true;
                }
                if (z16) {
                    i3 = l3 > this.startPanelHeight ? b.this.maxPanelHeight : b.this.normalPanelHeight;
                } else {
                    i3 = this.startPanelHeight;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("PanelExtendHelper", 2, "shortcut bar anim update panel " + l3 + " to " + i3);
                }
                b.this.h(l3, i3, 150);
            }
            return true;
        }

        @Override // com.tencent.qqnt.aio.shortcutbar.g
        public boolean interceptTouchEvent(@NotNull MotionEvent event) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) event)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(event, "event");
            if (!b.this.p()) {
                return false;
            }
            int action = event.getAction();
            if (action != 0) {
                if (action == 2) {
                    float y16 = event.getY();
                    if (Math.abs((int) ((y16 - this.downY) + 0.5f)) > b.this.m() * 0.6f) {
                        this.downY = y16;
                        return true;
                    }
                }
            } else {
                this.downY = event.getY();
                this.startPanelHeight = b.this.l();
            }
            return false;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59060);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b(@NotNull com.tencent.aio.api.runtime.a aioContext) {
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aioContext);
        } else {
            this.aioContext = aioContext;
            this.shortcutInterceptListener = new C9456b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(int startHeight, int targetHeight, int duration) {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            valueAnimator.cancel();
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(startHeight, targetHeight);
        ofInt.setDuration(duration);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.qqnt.aio.assistedchat.panel.extend.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                b.i(b.this, valueAnimator2);
            }
        });
        ofInt.start();
        this.animator = ofInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(b this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        this$0.q(((Integer) animatedValue).intValue() - this$0.normalPanelHeight);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(int dy5) {
        int l3 = l() - dy5;
        int i3 = this.maxPanelHeight;
        if (l3 > i3) {
            l3 = i3;
        }
        int i16 = this.normalPanelHeight;
        if (l3 < i16) {
            l3 = i16;
        }
        q(l3 - i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int m() {
        com.tencent.mobileqq.aio.event.h hVar;
        k k3 = this.aioContext.e().k(new ShortcutEventIntent.OnGetIconBarHeightIntent());
        if (k3 instanceof com.tencent.mobileqq.aio.event.h) {
            hVar = (com.tencent.mobileqq.aio.event.h) k3;
        } else {
            hVar = null;
        }
        if (hVar != null) {
            return hVar.a();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean p() {
        if (this.maxPanelHeight > this.normalPanelHeight) {
            return true;
        }
        return false;
    }

    private final void q(int offset) {
        this.aioContext.e().h(new PanelContainerMsgIntent.SetPanelHeightOffsetMsgIntent("PanelExtendHelper", offset, false, 4, null));
    }

    public final void j(@NotNull PanelExtendRecyclerView recyclerView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) recyclerView);
        } else {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            recyclerView.setExtendListener(this);
        }
    }

    public final int l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        k k3 = this.aioContext.e().k(PanelContainerMsgIntent.GetPanelHeightParamMsgIntent.f116806d);
        Intrinsics.checkNotNull(k3, "null cannot be cast to non-null type com.tencent.input.base.panelcontainer.PanelContainerMsgResult.GetPanelHeightParamMsgResult");
        return ((h.b) k3).a();
    }

    public final void n() {
        float f16;
        float f17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.normalPanelHeight = l.b(com.tencent.luggage.wxa.rf.g.CTRL_INDEX);
        Resources resources = BaseApplication.getContext().getResources();
        if (resources.getConfiguration().orientation == 2) {
            f16 = this.normalPanelHeight;
            f17 = 1.1f;
        } else {
            f16 = resources.getDisplayMetrics().heightPixels;
            f17 = 0.6f;
        }
        int i3 = (int) (f16 * f17);
        this.maxPanelHeight = i3;
        int i16 = this.normalPanelHeight;
        if (i3 < i16) {
            this.maxPanelHeight = i16;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PanelExtendHelper", 2, "normalPanelHeight:" + this.normalPanelHeight + " maxPanelHeight:" + this.maxPanelHeight);
        }
    }

    public final void o(boolean intercept) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, intercept);
        } else if (intercept) {
            this.aioContext.e().h(new ShortCutBarEvent.SetShortcutInterceptListener(this.shortcutInterceptListener));
        } else {
            this.aioContext.e().h(new ShortCutBarEvent.SetShortcutInterceptListener(null));
        }
    }

    @Override // com.tencent.qqnt.aio.assistedchat.panel.extend.c
    public void onPullDown() {
        int l3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else if (p() && (l3 = l()) != this.normalPanelHeight) {
            QLog.d("PanelExtendHelper", 1, "onPullDown");
            h(l3, this.normalPanelHeight, 250);
        }
    }

    @Override // com.tencent.qqnt.aio.assistedchat.panel.extend.c
    public void onPullUp() {
        int l3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else if (p() && (l3 = l()) != this.maxPanelHeight) {
            QLog.d("PanelExtendHelper", 1, "onPullUp");
            h(l3, this.maxPanelHeight, 150);
        }
    }
}
