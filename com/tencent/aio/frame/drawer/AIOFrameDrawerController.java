package com.tencent.aio.frame.drawer;

import android.view.View;
import bt.a;
import com.tencent.aio.frame.api.d;
import com.tencent.aio.frame.api.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 \t2\u00020\u0001:\u0001\u001aB8\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012!\u0010\u0017\u001a\u001d\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00040\u0010\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000eR/\u0010\u0017\u001a\u001d\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00040\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/aio/frame/drawer/AIOFrameDrawerController;", "Lcom/tencent/aio/frame/api/e;", "", "duration", "", "e", "", "i", "enable", h.F, "", "toString", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/aio/frame/drawer/DrawerFrameViewGroup;", "Ljava/lang/ref/WeakReference;", "frameGroup", "Lkotlin/Function1;", "Lbt/a$a;", "Lkotlin/ParameterName;", "name", "param", "f", "Lkotlin/jvm/functions/Function1;", "deliverInvoker", "<init>", "(Ljava/lang/ref/WeakReference;Lkotlin/jvm/functions/Function1;)V", "a", "core-frame-ktx_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class AIOFrameDrawerController extends e {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final WeakReference<DrawerFrameViewGroup> frameGroup;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Function1<a.InterfaceC0149a, Unit> deliverInvoker;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/aio/frame/drawer/AIOFrameDrawerController$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "core-frame-ktx_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.aio.frame.drawer.AIOFrameDrawerController$a, reason: from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7848);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AIOFrameDrawerController(@NotNull WeakReference<DrawerFrameViewGroup> frameGroup, @NotNull Function1<? super a.InterfaceC0149a, Unit> deliverInvoker) {
        Intrinsics.checkNotNullParameter(frameGroup, "frameGroup");
        Intrinsics.checkNotNullParameter(deliverInvoker, "deliverInvoker");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) frameGroup, (Object) deliverInvoker);
            return;
        }
        this.frameGroup = frameGroup;
        this.deliverInvoker = deliverInvoker;
        DrawerFrameViewGroup drawerFrameViewGroup = frameGroup.get();
        if (drawerFrameViewGroup != null) {
            drawerFrameViewGroup.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.tencent.aio.frame.drawer.AIOFrameDrawerController.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) AIOFrameDrawerController.this);
                    }
                }

                @Override // android.view.View.OnScrollChangeListener
                public final void onScrollChange(View view, int i3, int i16, int i17, int i18) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, view, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
                    } else {
                        AIOFrameDrawerController.this.d(new Function1<d, Unit>(i3, i17) { // from class: com.tencent.aio.frame.drawer.AIOFrameDrawerController.1.1
                            static IPatchRedirector $redirector_;
                            final /* synthetic */ int $oldScrollX;
                            final /* synthetic */ int $scrollX;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                                this.$scrollX = i3;
                                this.$oldScrollX = i17;
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i17));
                                }
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(d dVar) {
                                invoke2(dVar);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@NotNull d it) {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) it);
                                } else {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    it.b(this.$scrollX, this.$oldScrollX);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    @Override // com.tencent.aio.frame.api.e
    public void e(int duration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, duration);
            return;
        }
        DrawerFrameViewGroup drawerFrameViewGroup = this.frameGroup.get();
        if (drawerFrameViewGroup != null) {
            drawerFrameViewGroup.i(duration);
        }
    }

    @Override // com.tencent.aio.frame.api.e
    public void h(boolean enable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, enable);
            return;
        }
        DrawerFrameViewGroup drawerFrameViewGroup = this.frameGroup.get();
        if (drawerFrameViewGroup != null) {
            drawerFrameViewGroup.k(enable);
        }
    }

    @Override // com.tencent.aio.frame.api.e
    public boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        DrawerFrameViewGroup drawerFrameViewGroup = this.frameGroup.get();
        if (drawerFrameViewGroup != null) {
            return drawerFrameViewGroup.t();
        }
        return false;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "frameGroup " + this.frameGroup.hashCode();
    }
}
