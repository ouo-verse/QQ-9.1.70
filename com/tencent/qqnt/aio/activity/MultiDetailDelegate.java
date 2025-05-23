package com.tencent.qqnt.aio.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentManager;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.GestureEvent;
import com.tencent.mobileqq.aio.msg.MsgRecordParams;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.widget.AIOGestureLayout;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 #2\u00020\u0001:\u0001$B\u000f\u0012\u0006\u0010 \u001a\u00020\u001f\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u001b\u0010\u000b\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001b\u0010\u0010\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0015\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u001a\u001a\u00020\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\b\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001e\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\b\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006%"}, d2 = {"Lcom/tencent/qqnt/aio/activity/MultiDetailDelegate;", "Lcom/tencent/qqnt/aio/activity/AIODelegate;", "Lcom/tencent/qqnt/aio/widget/AIOGestureLayout;", "r0", "Landroid/view/View;", "show", "Landroid/content/Context;", "X", "Lkotlin/Lazy;", "E", "()Landroid/content/Context;", "mContext", "Landroid/view/Window;", "Y", "getMWindow", "()Landroid/view/Window;", "mWindow", "Landroidx/fragment/app/FragmentManager;", "Z", "G", "()Landroidx/fragment/app/FragmentManager;", "mFragmentManager", "Landroid/content/Intent;", "a0", "s0", "()Landroid/content/Intent;", "mIntent", "b0", "H", "()Lcom/tencent/qqnt/aio/widget/AIOGestureLayout;", "mRoot", "Lcom/tencent/qqnt/aio/e;", ParseCommon.CONTAINER, "<init>", "(Lcom/tencent/qqnt/aio/e;)V", "c0", "a", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class MultiDetailDelegate extends AIODelegate {
    static IPatchRedirector $redirector_;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private final Lazy mContext;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private final Lazy mWindow;

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    private final Lazy mFragmentManager;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mIntent;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mRoot;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/activity/MultiDetailDelegate$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.activity.MultiDetailDelegate$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/activity/MultiDetailDelegate$b", "Lcom/tencent/qqnt/aio/widget/h;", "Landroid/view/MotionEvent;", "ev", "", "dispatchTouchEvent", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b implements com.tencent.qqnt.aio.widget.h {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MultiDetailDelegate.this);
            }
        }

        @Override // com.tencent.qqnt.aio.widget.h
        public void dispatchTouchEvent(@NotNull MotionEvent ev5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) ev5);
                return;
            }
            Intrinsics.checkNotNullParameter(ev5, "ev");
            us.a D = MultiDetailDelegate.this.D();
            if (D != null) {
                D.a(new GestureEvent.DispatchTouchEvent(ev5));
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39645);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiDetailDelegate(@NotNull final com.tencent.qqnt.aio.e container) {
        super(container, "");
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Intrinsics.checkNotNullParameter(container, "container");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<Context>() { // from class: com.tencent.qqnt.aio.activity.MultiDetailDelegate$mContext$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) com.tencent.qqnt.aio.e.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Context invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? com.tencent.qqnt.aio.e.this.getContext() : (Context) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.mContext = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Window>() { // from class: com.tencent.qqnt.aio.activity.MultiDetailDelegate$mWindow$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) com.tencent.qqnt.aio.e.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Window invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? com.tencent.qqnt.aio.e.this.getWindow() : (Window) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.mWindow = lazy2;
            lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<FragmentManager>() { // from class: com.tencent.qqnt.aio.activity.MultiDetailDelegate$mFragmentManager$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) com.tencent.qqnt.aio.e.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final FragmentManager invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? com.tencent.qqnt.aio.e.this.getSupportFragmentManager() : (FragmentManager) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.mFragmentManager = lazy3;
            lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<Intent>() { // from class: com.tencent.qqnt.aio.activity.MultiDetailDelegate$mIntent$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) com.tencent.qqnt.aio.e.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Intent invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? com.tencent.qqnt.aio.e.this.getIntent() : (Intent) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.mIntent = lazy4;
            lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<AIOGestureLayout>() { // from class: com.tencent.qqnt.aio.activity.MultiDetailDelegate$mRoot$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MultiDetailDelegate.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final AIOGestureLayout invoke() {
                    Context E;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (AIOGestureLayout) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    E = MultiDetailDelegate.this.E();
                    AIOGestureLayout aIOGestureLayout = new AIOGestureLayout(E);
                    aIOGestureLayout.setId(R.id.zjk);
                    return aIOGestureLayout;
                }
            });
            this.mRoot = lazy5;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) container);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Context E() {
        return (Context) this.mContext.getValue();
    }

    private final FragmentManager G() {
        return (FragmentManager) this.mFragmentManager.getValue();
    }

    private final AIOGestureLayout H() {
        return (AIOGestureLayout) this.mRoot.getValue();
    }

    private final Intent s0() {
        return (Intent) this.mIntent.getValue();
    }

    @Override // com.tencent.qqnt.aio.activity.AIODelegate, com.tencent.qqnt.aio.activity.j
    @NotNull
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public AIOGestureLayout getAIORootView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AIOGestureLayout) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return H();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0099  */
    @Override // com.tencent.qqnt.aio.activity.AIODelegate, com.tencent.qqnt.aio.activity.j
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View show() {
        MsgRecordParams msgRecordParams;
        long j3;
        Long l3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        String stringExtra = s0().getStringExtra("key_peerId");
        if (stringExtra == null) {
            return H();
        }
        int intExtra = s0().getIntExtra("key_chat_type", 0);
        String stringExtra2 = s0().getStringExtra("key_chat_name");
        if (stringExtra2 == null) {
            stringExtra2 = "";
        }
        long longExtra = s0().getLongExtra("key_multiforward_parent_msgid", 0L);
        MsgRecordParams msgRecordParams2 = (MsgRecordParams) s0().getParcelableExtra("key_multiforward_parent_msg_record");
        if (s0().hasExtra("key_multiforward_root_msg_record")) {
            msgRecordParams = (MsgRecordParams) s0().getParcelableExtra("key_multiforward_root_msg_record");
            if (msgRecordParams != null) {
                l3 = Long.valueOf(msgRecordParams.b());
            } else {
                l3 = null;
            }
            if (l3 != null && msgRecordParams != null) {
                j3 = msgRecordParams.b();
                if (j3 == 0) {
                    if (s0().hasExtra("key_multiforward_root_msgid")) {
                        j3 = s0().getLongExtra("key_multiforward_root_msgid", 0L);
                    } else {
                        j3 = longExtra;
                    }
                }
                long j16 = j3;
                f0(new AIOContact(intExtra, stringExtra, "", stringExtra2));
                AIOSession aIOSession = new AIOSession(C());
                Bundle bundle = new Bundle();
                bundle.putLong("key_multiforward_root_msgid", j16);
                bundle.putLong("key_multiforward_parent_msgid", longExtra);
                bundle.putParcelable("key_multiforward_root_msg_record", msgRecordParams);
                bundle.putParcelable("key_multiforward_parent_msg_record", msgRecordParams2);
                bundle.putBoolean("key_is_multiforward_page", true);
                AIOParam c16 = new AIOParam.a().i(true).a(bundle).e(com.tencent.qqnt.aio.factory.b.f349915a.a(new com.tencent.qqnt.aio.factory.a(intExtra, false, true, null, 10, null))).h(aIOSession).c();
                QLog.i("MultiDetailDelegate", 1, "[show]: peerId=" + stringExtra + ", chatType=" + intExtra + ", rootMsgId=" + j16 + ", parentMsgId=" + longExtra);
                g0(com.tencent.aio.main.engine.b.f69377a.c(c16, G(), H().getId(), null));
                H().setTouchListener(new b());
                return H();
            }
        } else {
            s0().putExtra("key_multiforward_root_msg_record", msgRecordParams2);
            msgRecordParams = msgRecordParams2;
        }
        j3 = 0;
        if (j3 == 0) {
        }
        long j162 = j3;
        f0(new AIOContact(intExtra, stringExtra, "", stringExtra2));
        AIOSession aIOSession2 = new AIOSession(C());
        Bundle bundle2 = new Bundle();
        bundle2.putLong("key_multiforward_root_msgid", j162);
        bundle2.putLong("key_multiforward_parent_msgid", longExtra);
        bundle2.putParcelable("key_multiforward_root_msg_record", msgRecordParams);
        bundle2.putParcelable("key_multiforward_parent_msg_record", msgRecordParams2);
        bundle2.putBoolean("key_is_multiforward_page", true);
        AIOParam c162 = new AIOParam.a().i(true).a(bundle2).e(com.tencent.qqnt.aio.factory.b.f349915a.a(new com.tencent.qqnt.aio.factory.a(intExtra, false, true, null, 10, null))).h(aIOSession2).c();
        QLog.i("MultiDetailDelegate", 1, "[show]: peerId=" + stringExtra + ", chatType=" + intExtra + ", rootMsgId=" + j162 + ", parentMsgId=" + longExtra);
        g0(com.tencent.aio.main.engine.b.f69377a.c(c162, G(), H().getId(), null));
        H().setTouchListener(new b());
        return H();
    }
}
