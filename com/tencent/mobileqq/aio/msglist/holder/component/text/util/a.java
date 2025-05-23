package com.tencent.mobileqq.aio.msglist.holder.component.text.util;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.ViewGroup;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.c;
import com.tencent.mobileqq.aio.msglist.holder.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.api.IAIOConfigService;
import com.tencent.qqnt.aio.holder.IMsgItemMviUIState;
import com.tencent.qqnt.aio.widget.AIOMsgTextView;
import com.tencent.qqnt.aio.widget.SelectableLinearLayout;
import com.tencent.qqnt.aio.widget.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006J3\u0010\u0012\u001a\u00020\u0011\"\u0014\b\u0000\u0010\r*\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013J&\u0010\u0018\u001a\u00020\u0011\"\b\b\u0000\u0010\u0015*\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016J\u001a\u0010\u0019\u001a\u00020\u0006\"\b\b\u0000\u0010\u0015*\u00020\u0014*\b\u0012\u0004\u0012\u00028\u00000\u0016J\u0006\u0010\u001b\u001a\u00020\u001aJ\u0006\u0010\u001c\u001a\u00020\u0004\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/text/util/a;", "", "Landroid/content/Context;", "context", "", "bubbleMaxWidth", "Lcom/tencent/qqnt/aio/widget/i;", "doubleClickListener", "Lcom/tencent/fastertextview/wrapper/a;", "a", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/qqnt/aio/holder/a;", "Lcom/tencent/qqnt/aio/holder/IMsgItemMviUIState;", "VB", "Lcom/tencent/qqnt/aio/widget/SelectableLinearLayout;", "view", "vb", "", "g", "(Lcom/tencent/qqnt/aio/widget/SelectableLinearLayout;Lcom/tencent/aio/base/mvvm/a;)V", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "T", "Lcom/tencent/mobileqq/aio/msglist/holder/component/BaseContentComponent;", HippyQQConstants.URL_COMPONENT_NAME, "f", "c", "", "e", "d", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f192006a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/text/util/a$a", "Lcom/tencent/qqnt/aio/widget/i;", "", "formSingleTap", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.text.util.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static final class C7321a implements i {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaseContentComponent<T> f192007a;

        C7321a(BaseContentComponent<T> baseContentComponent) {
            this.f192007a = baseContentComponent;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseContentComponent);
            }
        }

        @Override // com.tencent.qqnt.aio.widget.i
        public boolean a(boolean formSingleTap) {
            com.tencent.qqnt.aio.holder.a wVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, formSingleTap)).booleanValue();
            }
            AIOMsgItem D1 = this.f192007a.D1();
            if (D1 != null) {
                c cVar = this.f192007a;
                if (formSingleTap) {
                    wVar = new d.y(D1);
                } else {
                    wVar = new d.w(D1);
                }
                cVar.sendIntent(wVar);
                return true;
            }
            return true;
        }
    }

    /* JADX WARN: Incorrect field signature: TVB; */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/text/util/a$b", "Lcom/tencent/qqnt/aio/widget/SelectableLinearLayout$a;", "", "a", "b", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b implements SelectableLinearLayout.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.aio.base.mvvm.a f192008a;

        /* JADX WARN: Incorrect types in method signature: (TVB;)V */
        b(com.tencent.aio.base.mvvm.a aVar) {
            this.f192008a = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            }
        }

        @Override // com.tencent.qqnt.aio.widget.SelectableLinearLayout.a
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.f192008a.sendIntent(new d.g(false));
            }
        }

        @Override // com.tencent.qqnt.aio.widget.SelectableLinearLayout.a
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                this.f192008a.sendIntent(d.ag.f192301d);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63636);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            f192006a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static /* synthetic */ com.tencent.fastertextview.wrapper.a b(a aVar, Context context, int i3, i iVar, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            iVar = null;
        }
        return aVar.a(context, i3, iVar);
    }

    @NotNull
    public final com.tencent.fastertextview.wrapper.a a(@NotNull Context context, int bubbleMaxWidth, @Nullable i doubleClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.fastertextview.wrapper.a) iPatchRedirector.redirect((short) 2, this, context, Integer.valueOf(bubbleMaxWidth), doubleClickListener);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        AIOMsgTextView aIOMsgTextView = new AIOMsgTextView(context, null, 0, 6, null);
        aIOMsgTextView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        aIOMsgTextView.setClickable(true);
        aIOMsgTextView.setFocusable(false);
        aIOMsgTextView.setOnDoubleClickListener(doubleClickListener);
        aIOMsgTextView.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.ayp));
        aIOMsgTextView.setId(R.id.sit);
        aIOMsgTextView.setMaxWidth(bubbleMaxWidth);
        aIOMsgTextView.setMovementMethod(LinkMovementMethod.getInstance());
        aIOMsgTextView.setImportantForAccessibility(2);
        return new com.tencent.fastertextview.wrapper.a(aIOMsgTextView);
    }

    @NotNull
    public final <T extends AIOMsgItem> i c(@NotNull BaseContentComponent<T> baseContentComponent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (i) iPatchRedirector.redirect((short) 6, (Object) this, (Object) baseContentComponent);
        }
        Intrinsics.checkNotNullParameter(baseContentComponent, "<this>");
        return new C7321a(baseContentComponent);
    }

    public final int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return 125;
    }

    public final boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.d("TextContentViewUtil", 1, "isLinkStyleModifySwitch: app is null");
            return false;
        }
        return ((IAIOConfigService) peekAppRuntime.getRuntimeService(IAIOConfigService.class, "")).linkUseNewStyle();
    }

    public final <T extends AIOMsgItem> void f(@NotNull SelectableLinearLayout view, @NotNull BaseContentComponent<T> component) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view, (Object) component);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(component, "component");
        view.setOnDoubleClickListener(c(component));
        view.setClickable(true);
    }

    public final <VB extends com.tencent.aio.base.mvvm.a<com.tencent.qqnt.aio.holder.a, IMsgItemMviUIState>> void g(@NotNull SelectableLinearLayout view, @NotNull VB vb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view, (Object) vb5);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(vb5, "vb");
        view.setTouchCursorListener(new b(vb5));
    }
}
