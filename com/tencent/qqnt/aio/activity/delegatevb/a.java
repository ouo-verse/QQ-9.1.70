package com.tencent.qqnt.aio.activity.delegatevb;

import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.activity.AIODelegate;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\r\u0018\u0000 \u00062\u00020\u0001:\u0001\u0017B\u001f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\f\u001a\u00020\b\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/aio/activity/delegatevb/a;", "Lcom/tencent/qqnt/aio/activity/delegatevb/b;", "Landroid/os/Bundle;", "bundle", "", h.F, "e", "c", "Lcom/tencent/qqnt/aio/activity/AIODelegate;", "Lcom/tencent/qqnt/aio/activity/AIODelegate;", "getAioDelegate", "()Lcom/tencent/qqnt/aio/activity/AIODelegate;", "aioDelegate", "com/tencent/qqnt/aio/activity/delegatevb/a$b", "d", "Lcom/tencent/qqnt/aio/activity/delegatevb/a$b;", "mDrawerScrollAction", "Landroid/view/ViewGroup;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lus/a;", "chatFragmentProvider", "<init>", "(Landroid/view/ViewGroup;Lus/a;Lcom/tencent/qqnt/aio/activity/AIODelegate;)V", "a", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class a extends com.tencent.qqnt.aio.activity.delegatevb.b {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final HashMap<Integer, Boolean> f348461f;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AIODelegate aioDelegate;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mDrawerScrollAction;

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR0\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\fj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004`\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/aio/activity/delegatevb/a$a;", "", "", "activityHashCode", "", "open", "", "c", "b", "", "TAG", "Ljava/lang/String;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "rightDrawerOpenMap", "Ljava/util/HashMap;", "<init>", "()V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.activity.delegatevb.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void c(int activityHashCode, boolean open) {
            a.f348461f.put(Integer.valueOf(activityHashCode), Boolean.valueOf(open));
        }

        public final boolean b(int activityHashCode) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, activityHashCode)).booleanValue();
            }
            Boolean bool = (Boolean) a.f348461f.get(Integer.valueOf(activityHashCode));
            if (bool == null) {
                return false;
            }
            return bool.booleanValue();
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/activity/delegatevb/a$b", "Lcom/tencent/aio/runtime/message/b;", "Landroid/os/Bundle;", "data", "", "a", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b implements com.tencent.aio.runtime.message.b {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.aio.runtime.message.b
        public void a(@NotNull Bundle data) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) data);
            } else {
                Intrinsics.checkNotNullParameter(data, "data");
                a.this.h(data);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39834);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
            f348461f = new HashMap<>();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull ViewGroup rootView, @NotNull us.a chatFragmentProvider, @NotNull AIODelegate aioDelegate) {
        super(rootView, chatFragmentProvider);
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(chatFragmentProvider, "chatFragmentProvider");
        Intrinsics.checkNotNullParameter(aioDelegate, "aioDelegate");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, rootView, chatFragmentProvider, aioDelegate);
        } else {
            this.aioDelegate = aioDelegate;
            this.mDrawerScrollAction = new b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(Bundle bundle) {
        com.tencent.qqnt.aio.drawer.a aVar = com.tencent.qqnt.aio.drawer.a.f349869a;
        int i3 = bundle.getInt(aVar.b(), -1);
        int i16 = bundle.getInt(aVar.a(), -1);
        if (i3 != -1 && i16 != -1) {
            if (i3 == 0) {
                QLog.i("RightDrawerVB", 1, "[handleDrawerScroll]: drawerClose");
                INSTANCE.c(this.aioDelegate.A().getContext().hashCode(), false);
            } else if (i16 == 0) {
                QLog.i("RightDrawerVB", 1, "[handleDrawerScroll]: drawerOpen");
                INSTANCE.c(this.aioDelegate.A().getContext().hashCode(), true);
            }
        }
    }

    @Override // com.tencent.qqnt.aio.activity.delegatevb.b
    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.c();
            a().l("drawer_frame_scroll_event", this.mDrawerScrollAction);
        }
    }

    @Override // com.tencent.qqnt.aio.activity.delegatevb.b
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.e();
        INSTANCE.c(this.aioDelegate.A().getContext().hashCode(), false);
        a().i("drawer_frame_scroll_event", this.mDrawerScrollAction);
    }
}
