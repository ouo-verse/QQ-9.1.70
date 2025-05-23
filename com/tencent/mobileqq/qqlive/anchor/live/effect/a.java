package com.tencent.mobileqq.qqlive.anchor.live.effect;

import android.app.Activity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.PropPanelPopupWindow;
import com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.model.b;
import com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.model.c;
import com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.model.d;
import com.tencent.mobileqq.qqlive.anchor.beauty.ui.select.SelectPanelClickListener;
import com.tencent.mobileqq.qqlive.anchor.beauty.widget.popup.k;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.common.api.IAegisLogApi;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0002\u0017\u001cB\u0007\u00a2\u0006\u0004\b$\u0010%J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\u0006J\u0014\u0010\u0014\u001a\u00020\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J\u001a\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010!\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010 R\u0018\u0010#\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/qqlive/anchor/live/effect/a;", "Lcom/tencent/mobileqq/qqlive/anchor/beauty/ui/select/SelectPanelClickListener;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "roomId", "", h.F, "e", "Lcom/tencent/mobileqq/qqlive/anchor/beauty/ui/prop/api/b;", "listener", "d", "f", "", "index", "g", "c", "", "Lcom/tencent/mobileqq/qqlive/anchor/beauty/ui/prop/bean/b;", "propsInfo", "i", "Lcom/tencent/mobileqq/qqlive/anchor/beauty/ui/select/SelectPanelClickListener$SelectAction;", "type", "a", "Lcom/tencent/mobileqq/qqlive/anchor/beauty/ui/select/a;", "Lcom/tencent/mobileqq/qqlive/anchor/beauty/ui/select/a;", "selectPanelViewController", "Lcom/tencent/mobileqq/qqlive/anchor/beauty/widget/popup/k;", "b", "Lcom/tencent/mobileqq/qqlive/anchor/beauty/widget/popup/k;", "effectPopupWindow", "Lcom/tencent/mobileqq/qqlive/anchor/beauty/ui/prop/PropPanelPopupWindow;", "Lcom/tencent/mobileqq/qqlive/anchor/beauty/ui/prop/PropPanelPopupWindow;", "propPanelPopupWindow", "Lcom/tencent/mobileqq/qqlive/anchor/beauty/ui/prop/api/b;", "propSelectedListener", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a implements SelectPanelClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final IAegisLogApi f270645f;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qqlive.anchor.beauty.ui.select.a selectPanelViewController;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private k effectPopupWindow;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private PropPanelPopupWindow propPanelPopupWindow;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.api.b propSelectedListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qqlive/anchor/live/effect/a$a;", "", "Lcom/tencent/mobileqq/qqlive/anchor/live/effect/a$b;", "fetchCallback", "", "a", "", "TAG", "Ljava/lang/String;", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "aegisLogApi", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.anchor.live.effect.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/qqlive/anchor/live/effect/a$a$a", "Lcom/tencent/mobileqq/qqlive/anchor/beauty/ui/prop/model/b$a;", "Lcom/tencent/mobileqq/qqlive/anchor/beauty/ui/prop/model/c;", "propsInfo", "", "a", "", "errorCode", "", "errorMsg", "b", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.qqlive.anchor.live.effect.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes17.dex */
        public static final class C8347a implements b.a {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ b f270650a;

            C8347a(b bVar) {
                this.f270650a = bVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
                }
            }

            @Override // com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.model.b.a
            public void a(@Nullable c propsInfo) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) propsInfo);
                    return;
                }
                if (propsInfo == null) {
                    return;
                }
                List<com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.b> a16 = d.a(propsInfo);
                Intrinsics.checkNotNullExpressionValue(a16, "parse(propsInfo)");
                com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.cache.c.g(a16);
                b bVar = this.f270650a;
                if (bVar != null) {
                    bVar.a();
                }
            }

            @Override // com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.model.b.a
            public void b(int errorCode, @Nullable String errorMsg) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                    a.f270645f.e("LiveEffectUI", "fetch props failed, error code = " + errorCode + ", errorMsg = " + errorMsg);
                    return;
                }
                iPatchRedirector.redirect((short) 3, (Object) this, errorCode, (Object) errorMsg);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        public final void a(@Nullable b fetchCallback) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) fetchCallback);
            } else {
                new com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.model.b().e(new C8347a(fetchCallback));
            }
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
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/qqlive/anchor/live/effect/a$b;", "", "", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public interface b {
        void a();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19022);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
            return;
        }
        INSTANCE = new Companion(null);
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        f270645f = (IAegisLogApi) api;
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.anchor.beauty.ui.select.SelectPanelClickListener
    public void a(@NotNull Activity activity, @Nullable SelectPanelClickListener.SelectAction type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) activity, (Object) type);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (type == SelectPanelClickListener.SelectAction.CLICK_BEAUTY) {
            e(activity);
        } else if (type == SelectPanelClickListener.SelectAction.CLICK_PROP) {
            f(activity);
        }
    }

    public final void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        com.tencent.mobileqq.qqlive.anchor.beauty.ui.select.a aVar = this.selectPanelViewController;
        if (aVar != null) {
            aVar.h();
        }
        this.selectPanelViewController = null;
        k kVar = this.effectPopupWindow;
        if (kVar != null) {
            kVar.onDestroy();
        }
        this.effectPopupWindow = null;
        PropPanelPopupWindow propPanelPopupWindow = this.propPanelPopupWindow;
        if (propPanelPopupWindow != null) {
            propPanelPopupWindow.J();
        }
        this.propPanelPopupWindow = null;
        this.propSelectedListener = null;
    }

    public final void d(@Nullable com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.api.b listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) listener);
        } else {
            this.propSelectedListener = listener;
        }
    }

    public final void e(@NotNull Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.effectPopupWindow == null) {
            this.effectPopupWindow = new k();
        }
        k kVar = this.effectPopupWindow;
        if (kVar != null) {
            kVar.o(activity);
        }
    }

    public final void f(@NotNull Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.propPanelPopupWindow == null) {
            this.propPanelPopupWindow = new PropPanelPopupWindow(activity);
        }
        PropPanelPopupWindow propPanelPopupWindow = this.propPanelPopupWindow;
        if (propPanelPopupWindow != null) {
            propPanelPopupWindow.Q(this.propSelectedListener);
        }
        PropPanelPopupWindow propPanelPopupWindow2 = this.propPanelPopupWindow;
        if (propPanelPopupWindow2 != null) {
            propPanelPopupWindow2.R();
        }
    }

    public final void g(@NotNull Activity activity, int index) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity, index);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        f(activity);
        PropPanelPopupWindow propPanelPopupWindow = this.propPanelPopupWindow;
        if (propPanelPopupWindow != null) {
            propPanelPopupWindow.O(index);
        }
    }

    public final void h(@NotNull Activity activity, long roomId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, activity, Long.valueOf(roomId));
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.selectPanelViewController == null) {
            com.tencent.mobileqq.qqlive.anchor.beauty.ui.select.a aVar = new com.tencent.mobileqq.qqlive.anchor.beauty.ui.select.a(activity, roomId);
            this.selectPanelViewController = aVar;
            aVar.i(this);
        }
        com.tencent.mobileqq.qqlive.anchor.beauty.ui.select.a aVar2 = this.selectPanelViewController;
        if (aVar2 != null) {
            aVar2.j();
        }
    }

    public final void i(@NotNull List<? extends com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.b> propsInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) propsInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(propsInfo, "propsInfo");
        PropPanelPopupWindow propPanelPopupWindow = this.propPanelPopupWindow;
        if (propPanelPopupWindow != null) {
            propPanelPopupWindow.S(propsInfo);
        }
    }
}
