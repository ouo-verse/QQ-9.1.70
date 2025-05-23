package com.tencent.qqnt.aio.activity.delegatevb;

import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.exception.OperateViewOnSubThreadException;
import com.tencent.qqnt.aio.reserve2.animation.BusiAnimationEvent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0002\f\u000f\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001c\u001dB\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0007H\u0016R\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0010R\u001e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0013\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/qqnt/aio/activity/delegatevb/FullForegroundVB;", "Lcom/tencent/qqnt/aio/activity/delegatevb/b;", "", "type", "Landroid/view/View;", "j", "view", "", "i", "e", "d", "c", "com/tencent/qqnt/aio/activity/delegatevb/FullForegroundVB$b", "Lcom/tencent/qqnt/aio/activity/delegatevb/FullForegroundVB$b;", "mAddAnimationAction", "com/tencent/qqnt/aio/activity/delegatevb/FullForegroundVB$c", "Lcom/tencent/qqnt/aio/activity/delegatevb/FullForegroundVB$c;", "simpleEventReceiver", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "mChildView", "Landroid/view/ViewGroup;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lus/a;", "chatFragmentProvider", "<init>", "(Landroid/view/ViewGroup;Lus/a;)V", "f", "AddAnimViewEvent", "a", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class FullForegroundVB extends com.tencent.qqnt.aio.activity.delegatevb.b {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAddAnimationAction;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c simpleEventReceiver;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<View> mChildView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/aio/activity/delegatevb/FullForegroundVB$AddAnimViewEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "type", "", "(I)V", "getType", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "aio_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final /* data */ class AddAnimViewEvent extends SimpleBaseEvent {
        static IPatchRedirector $redirector_;
        private final int type;

        public AddAnimViewEvent(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3);
            } else {
                this.type = i3;
            }
        }

        public static /* synthetic */ AddAnimViewEvent copy$default(AddAnimViewEvent addAnimViewEvent, int i3, int i16, Object obj) {
            if ((i16 & 1) != 0) {
                i3 = addAnimViewEvent.type;
            }
            return addAnimViewEvent.copy(i3);
        }

        public final int component1() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.type;
        }

        @NotNull
        public final AddAnimViewEvent copy(int type) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (AddAnimViewEvent) iPatchRedirector.redirect((short) 4, (Object) this, type);
            }
            return new AddAnimViewEvent(type);
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if ((other instanceof AddAnimViewEvent) && this.type == ((AddAnimViewEvent) other).type) {
                return true;
            }
            return false;
        }

        public final int getType() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.type;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.type;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return "AddAnimViewEvent(type=" + this.type + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/activity/delegatevb/FullForegroundVB$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.activity.delegatevb.FullForegroundVB$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/activity/delegatevb/FullForegroundVB$b", "Lcom/tencent/aio/runtime/message/b;", "Landroid/os/Bundle;", "data", "", "a", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b implements com.tencent.aio.runtime.message.b {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FullForegroundVB.this);
            }
        }

        @Override // com.tencent.aio.runtime.message.b
        public void a(@NotNull Bundle data) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) data);
                return;
            }
            Intrinsics.checkNotNullParameter(data, "data");
            int i3 = data.getInt("key_anim_type", -1);
            QLog.i("FullForegroundVB", 1, "[onReceive]: type is " + i3);
            View j3 = FullForegroundVB.this.j(i3);
            if (j3 != null) {
                FullForegroundVB.this.i(j3);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0014\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00070\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/qqnt/aio/activity/delegatevb/FullForegroundVB$c", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class c implements SimpleEventReceiver<SimpleBaseEvent> {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FullForegroundVB.this);
            }
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        @NotNull
        public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (ArrayList) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
            arrayList.add(AddAnimViewEvent.class);
            return arrayList;
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) event);
                return;
            }
            if (event instanceof AddAnimViewEvent) {
                AddAnimViewEvent addAnimViewEvent = (AddAnimViewEvent) event;
                QLog.i("FullForegroundVB", 1, "simpleEventReceiver onReceiveEvent, type:" + addAnimViewEvent.getType());
                View j3 = FullForegroundVB.this.j(addAnimViewEvent.getType());
                if (j3 != null) {
                    FullForegroundVB.this.i(j3);
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39913);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FullForegroundVB(@NotNull ViewGroup rootView, @NotNull us.a chatFragmentProvider) {
        super(rootView, chatFragmentProvider);
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(chatFragmentProvider, "chatFragmentProvider");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) rootView, (Object) chatFragmentProvider);
        } else {
            this.mAddAnimationAction = new b();
            this.simpleEventReceiver = new c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(View view) {
        ViewGroup viewGroup;
        View view2;
        QLog.i("FullForegroundVB", 1, "[onRecaddBusiAnimVieweive]: view is " + view);
        WeakReference<View> weakReference = this.mChildView;
        if (weakReference != null && (view2 = weakReference.get()) != null) {
            b().removeView(view2);
        }
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent;
        } else {
            viewGroup = null;
        }
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        this.mChildView = new WeakReference<>(view);
        b().addView(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View j(int type) {
        BusiAnimationEvent.GetFullScreenView getFullScreenView = new BusiAnimationEvent.GetFullScreenView(type, null, 2, null);
        a().a(getFullScreenView);
        return getFullScreenView.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(FullForegroundVB this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.b().removeView(it);
    }

    @Override // com.tencent.qqnt.aio.activity.delegatevb.b
    public void c() {
        final View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.c();
        QLog.i("FullForegroundVB", 1, "onAIOHide  " + System.identityHashCode(this));
        SimpleEventBus.getInstance().unRegisterReceiver(this.simpleEventReceiver);
        a().l("add_full_screen_foreground_view", this.mAddAnimationAction);
        WeakReference<View> weakReference = this.mChildView;
        if (weakReference != null && (view = weakReference.get()) != null) {
            QLog.i("FullForegroundVB", 1, "onAIOHide  removeView:" + view);
            if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                b().removeView(view);
            } else if (com.tencent.qqnt.util.b.f362976b.isPublicVersion()) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqnt.aio.activity.delegatevb.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        FullForegroundVB.k(FullForegroundVB.this, view);
                    }
                });
            } else {
                throw new OperateViewOnSubThreadException("AIOGestureLayout removeView on sub thread");
            }
        }
        this.mChildView = null;
    }

    @Override // com.tencent.qqnt.aio.activity.delegatevb.b
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.d();
        QLog.i("FullForegroundVB", 1, "onAIOShow  " + System.identityHashCode(this));
        SimpleEventBus.getInstance().registerReceiver(this.simpleEventReceiver);
    }

    @Override // com.tencent.qqnt.aio.activity.delegatevb.b
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            super.e();
            a().i("add_full_screen_foreground_view", this.mAddAnimationAction);
        }
    }
}
