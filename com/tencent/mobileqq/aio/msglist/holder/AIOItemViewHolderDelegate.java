package com.tencent.mobileqq.aio.msglist.holder;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.aio.msglist.holder.template.n;
import com.tencent.mobileqq.aio.msglist.x;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqnt.aio.holder.IMsgItemMviUIState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b+\u0010,J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J)\u0010\u0013\u001a\u00020\n2!\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\fJ\u0014\u0010\u0015\u001a\u00020\n2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0014J<\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0\u001e2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0014\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0\"H\u0016R1\u0010%\u001a\u001d\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010$R\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00040\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010&R.\u0010)\u001a\u001a\u0012\u0004\u0012\u00020(\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0\u001e0\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R(\u0010*\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0\"0\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010&\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/AIOItemViewHolderDelegate;", "Lcom/tencent/mobileqq/aio/msglist/holder/h;", "", "key", "Lcom/tencent/mobileqq/aio/msglist/holder/template/n;", "template", "Landroid/view/View;", "d", "Lcom/tencent/mobileqq/aio/msglist/holder/component/c;", HippyQQConstants.URL_COMPONENT_NAME, "", "a", "Lkotlin/Function1;", "Landroid/content/Context;", "Lkotlin/ParameterName;", "name", "context", "Lcom/tencent/mobileqq/aio/msglist/holder/g;", "componentProviderGetter", "e", "Lkotlin/Function0;", "f", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "isSelf", "viewType", "subViewType", "Lcom/tencent/mobileqq/aio/msglist/x;", "factoryProvider", "Lcom/tencent/aio/api/list/a;", "Lcom/tencent/qqnt/aio/holder/a;", "Lcom/tencent/qqnt/aio/holder/IMsgItemMviUIState;", "b", "Lcom/tencent/aio/api/list/b;", "c", "Lkotlin/jvm/functions/Function1;", "mComponentProviderGetter", "Lkotlin/jvm/functions/Function0;", "mTemplateGetter", "Lcom/tencent/mobileqq/aio/msglist/holder/e;", "mMsgItemVBGetter", "mMsgItemVMGetter", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOItemViewHolderDelegate implements h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Function1<? super Context, ? extends g> mComponentProviderGetter;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Function0<? extends n> mTemplateGetter;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Function1<? super e, ? extends com.tencent.aio.api.list.a<com.tencent.qqnt.aio.holder.a, IMsgItemMviUIState>> mMsgItemVBGetter;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Function0<? extends com.tencent.aio.api.list.b<com.tencent.qqnt.aio.holder.a, IMsgItemMviUIState>> mMsgItemVMGetter;

    public AIOItemViewHolderDelegate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mComponentProviderGetter = AIOItemViewHolderDelegate$mComponentProviderGetter$1.INSTANCE;
        this.mTemplateGetter = AIOItemViewHolderDelegate$mTemplateGetter$1.INSTANCE;
        this.mMsgItemVBGetter = AIOItemViewHolderDelegate$mMsgItemVBGetter$1.INSTANCE;
        this.mMsgItemVMGetter = AIOItemViewHolderDelegate$mMsgItemVMGetter$1.INSTANCE;
    }

    private final void a(int key, com.tencent.mobileqq.aio.msglist.holder.component.c component, n template) {
        if (key != 0) {
            if (key != 1) {
                if (key != 2) {
                    if (key != 4) {
                        if (key != 5) {
                            if (key != 6) {
                                if (key != 7) {
                                    if (key == 12) {
                                        template.p(component.c1());
                                        return;
                                    }
                                    return;
                                }
                                template.m(component.c1());
                                return;
                            }
                            template.z(component.c1());
                            return;
                        }
                        template.t(component.c1());
                        return;
                    }
                    template.s(component.c1());
                    return;
                }
                template.g(component.c1());
                return;
            }
            template.c(component.c1());
            return;
        }
        template.f(component.c1());
    }

    private final View d(int key, n template) {
        switch (key) {
            case 0:
                return template.a();
            case 1:
                return template.e();
            case 2:
                return template.b();
            case 3:
                return template.r();
            case 4:
                return template.l();
            case 5:
                return template.y();
            case 6:
                return template.v();
            case 7:
                return template.u();
            case 8:
            case 9:
            default:
                return null;
            case 10:
                return template.h();
            case 11:
                return template.n();
            case 12:
                return template.i();
            case 13:
                return template.o();
            case 14:
                return template.k();
            case 15:
                return template.w();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.aio.msglist.holder.h
    @NotNull
    public com.tencent.aio.api.list.a<com.tencent.qqnt.aio.holder.a, IMsgItemMviUIState> b(@NotNull ViewGroup parent, boolean isSelf, int viewType, int subViewType, @NotNull x factoryProvider) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.aio.api.list.a) iPatchRedirector.redirect((short) 4, this, parent, Boolean.valueOf(isSelf), Integer.valueOf(viewType), Integer.valueOf(subViewType), factoryProvider);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(factoryProvider, "factoryProvider");
        n invoke = this.mTemplateGetter.invoke();
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        View d16 = invoke.d(context, parent, isSelf);
        Function1<? super Context, ? extends g> function1 = this.mComponentProviderGetter;
        Context context2 = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "parent.context");
        g invoke2 = function1.invoke(context2);
        SparseArray<com.tencent.mobileqq.aio.msglist.holder.component.c> sparseArray = invoke2.get();
        int size = sparseArray.size();
        for (int i3 = 0; i3 < size; i3++) {
            int keyAt = sparseArray.keyAt(i3);
            com.tencent.mobileqq.aio.msglist.holder.component.c valueAt = sparseArray.valueAt(i3);
            if (valueAt != null) {
                View d17 = d(keyAt, invoke);
                if (d17 == null) {
                    invoke2.get().put(keyAt, null);
                } else {
                    valueAt.k1(d17);
                    a(keyAt, valueAt, invoke);
                }
            }
        }
        com.tencent.aio.api.list.a<com.tencent.qqnt.aio.holder.a, IMsgItemMviUIState> aVar = (com.tencent.aio.api.list.a) this.mMsgItemVBGetter.invoke(new e(invoke, d16, invoke2, factoryProvider, viewType));
        Intrinsics.checkNotNull(aVar, "null cannot be cast to non-null type com.tencent.qqnt.aio.holder.template.OnInterceptTouchListener");
        invoke.x((com.tencent.qqnt.aio.holder.template.d) aVar);
        return aVar;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.h
    @NotNull
    public com.tencent.aio.api.list.b<com.tencent.qqnt.aio.holder.a, IMsgItemMviUIState> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.aio.api.list.b) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mMsgItemVMGetter.invoke();
    }

    public final void e(@NotNull Function1<? super Context, ? extends g> componentProviderGetter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) componentProviderGetter);
        } else {
            Intrinsics.checkNotNullParameter(componentProviderGetter, "componentProviderGetter");
            this.mComponentProviderGetter = componentProviderGetter;
        }
    }

    public final void f(@NotNull Function0<? extends n> template) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) template);
        } else {
            Intrinsics.checkNotNullParameter(template, "template");
            this.mTemplateGetter = template;
        }
    }
}
