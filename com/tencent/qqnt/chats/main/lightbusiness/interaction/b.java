package com.tencent.qqnt.chats.main.lightbusiness.interaction;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.biz.lightbusiness.lightinteraction.LIAConfigManager;
import com.tencent.qqnt.biz.lightbusiness.lightinteraction.LIAHelper;
import com.tencent.qqnt.biz.lightbusiness.lightinteraction.LIAInjectUtil;
import com.tencent.qqnt.biz.lightbusiness.lightinteraction.LIAScene;
import com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.LIAActionItem;
import com.tencent.qqnt.biz.lightbusiness.lightinteraction.d;
import com.tencent.qqnt.chats.api.IChatsReportHelper;
import com.tencent.qqnt.chats.api.IChatsUtil;
import com.tencent.qqnt.chats.core.adapter.holder.RecentContactItemBinding;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.core.itempart.summary.a;
import com.tencent.qqnt.chats.core.uievent.a;
import com.tencent.qqnt.kernel.nativeinterface.LiteBusinessType;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 #2\u00020\u0001:\u0001#B\u0007\u00a2\u0006\u0004\b$\u0010%J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0004H\u0002J\u0018\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0004H\u0002J \u0010\u0017\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J(\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J,\u0010\u001b\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001c\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u001c\u001a\u00020\b2\b\b\u0002\u0010\u001e\u001a\u00020\u001dH\u0002J \u0010#\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0006H\u0016\u00a8\u0006&"}, d2 = {"Lcom/tencent/qqnt/chats/main/lightbusiness/interaction/b;", "Lcom/tencent/qqnt/chats/inject/content/a;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/bean/LIAActionItem;", "actionItem", "Lcom/tencent/qqnt/chats/core/adapter/holder/RecentContactItemBinding;", "bind", "Landroid/graphics/drawable/Drawable;", "iconDrawable", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/ViewGroup;", "view", "f", "", "l", "action", h.F, "i", "Landroid/view/View;", "actionBtn", "binding", "k", "j", "innerBtn", "innerBinding", "g", "d", "", "depth", "Landroid/graphics/Bitmap;", "o", "Lcom/tencent/qqnt/chats/core/adapter/holder/h;", "binging", "a", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class b extends com.tencent.qqnt.chats.inject.content.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chats/main/lightbusiness/interaction/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.main.lightbusiness.interaction.b$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/chats/main/lightbusiness/interaction/b$b", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.main.lightbusiness.interaction.b$b, reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    public static final class C9596b extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ WeakReference<View> f355266d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ WeakReference<RecentContactItemBinding> f355267e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ b f355268f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ g f355269h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ LIAActionItem f355270i;

        C9596b(WeakReference<View> weakReference, WeakReference<RecentContactItemBinding> weakReference2, b bVar, g gVar, LIAActionItem lIAActionItem) {
            this.f355266d = weakReference;
            this.f355267e = weakReference2;
            this.f355268f = bVar;
            this.f355269h = gVar;
            this.f355270i = lIAActionItem;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, weakReference, weakReference2, bVar, gVar, lIAActionItem);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
                return;
            }
            this.f355268f.g(this.f355266d.get(), this.f355267e.get(), this.f355269h, this.f355270i);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/qqnt/chats/main/lightbusiness/interaction/b$c", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/d;", "Landroid/graphics/drawable/Drawable;", "iconDrawable", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/bean/b;", "res", "", "a", "onFail", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class c implements d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WeakReference<RecentContactItemBinding> f355271a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ g f355272b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f355273c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ LIAActionItem f355274d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f355275e;

        c(WeakReference<RecentContactItemBinding> weakReference, g gVar, String str, LIAActionItem lIAActionItem, b bVar) {
            this.f355271a = weakReference;
            this.f355272b = gVar;
            this.f355273c = str;
            this.f355274d = lIAActionItem;
            this.f355275e = bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, weakReference, gVar, str, lIAActionItem, bVar);
            }
        }

        @Override // com.tencent.qqnt.biz.lightbusiness.lightinteraction.d
        public void a(@NotNull Drawable iconDrawable, @NotNull com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b res) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) iconDrawable, (Object) res);
                return;
            }
            Intrinsics.checkNotNullParameter(iconDrawable, "iconDrawable");
            Intrinsics.checkNotNullParameter(res, "res");
            RecentContactItemBinding recentContactItemBinding = this.f355271a.get();
            if (recentContactItemBinding == null) {
                return;
            }
            this.f355272b.q().putInt("key_lite_sub_type", res.m());
            String str2 = this.f355273c;
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                str = peekAppRuntime.getCurrentUid();
            } else {
                str = null;
            }
            if (!Intrinsics.areEqual(str2, str)) {
                return;
            }
            LIAActionItem l3 = LIAHelper.f353124a.l(this.f355274d, res);
            l3.n(new LIAActionItem.b(this.f355273c));
            this.f355275e.m(this.f355272b, l3, recentContactItemBinding, iconDrawable);
        }

        @Override // com.tencent.qqnt.biz.lightbusiness.lightinteraction.d
        public void onFail() {
            View f16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            RecentContactItemBinding recentContactItemBinding = this.f355271a.get();
            if (recentContactItemBinding != null && (f16 = RecentContactItemBinding.f(recentContactItemBinding, false, 1, null)) != null) {
                this.f355275e.k(f16, recentContactItemBinding, this.f355272b);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45067);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void f(ViewGroup view, LIAActionItem actionItem) {
        if (!com.tencent.qqnt.util.b.f362976b.enableTalkBack()) {
            return;
        }
        AccessibilityUtil.c(view, view.getContext().getString(R.string.f169983yj4, actionItem.getTitle()), Button.class.getName());
        if (QLog.isDevelopLevel()) {
            QLog.d("LIAContentProcessor", 1, "[doAccessibility] content=" + ((Object) view.getContentDescription()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(View innerBtn, RecentContactItemBinding innerBinding, g item, LIAActionItem actionItem) {
        boolean z16;
        View view;
        boolean z17 = false;
        if (innerBtn != null && innerBinding != null && RecentContactItemBinding.f(innerBinding, false, 1, null) != null) {
            Object parent = innerBinding.a().getAvatarLayout().getParent();
            if (parent instanceof View) {
                view = (View) parent;
            } else {
                view = null;
            }
            if (view == null || view.getId() != R.id.f164548a32) {
                view = innerBinding.a().getAvatarLayout();
            }
            View f16 = RecentContactItemBinding.f(innerBinding, false, 1, null);
            Intrinsics.checkNotNull(f16, "null cannot be cast to non-null type android.view.ViewGroup");
            View childAt = ((ViewGroup) f16).getChildAt(0);
            Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.widget.ImageView");
            Drawable drawable = ((ImageView) childAt).getDrawable();
            Intrinsics.checkNotNullExpressionValue(drawable, "(innerBinding.getInterAc\u20260) as ImageView).drawable");
            Bitmap p16 = p(this, drawable, 0, 2, null);
            if (p16 == null) {
                if (!QLog.isDebugVersion()) {
                    QLog.d("LIAContentProcessor", 1, "[doAfterAnim] " + item.k() + " not able to get bitmap)");
                    return;
                }
                throw new IllegalStateException("not able to get bitmap");
            }
            ((IChatsUtil) QRoute.api(IChatsUtil.class)).sendEventToChat(new a.u(item, view, actionItem, p16));
            k(innerBtn, innerBinding, item);
            return;
        }
        if (innerBinding == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (innerBtn == null) {
            z17 = true;
        }
        QLog.d("LIAContentProcessor", 1, "hide anim after. view is recycled. isBindingNull=" + z16 + ", isBtnNull=" + z17);
        if (QLog.isDevelopLevel()) {
            QLog.d("LIAContentProcessor", 1, "no lia anim, to send msg, name=" + item.w().e());
        }
        com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b e16 = LIAConfigManager.INSTANCE.a().e(actionItem.getType(), actionItem.c());
        if (e16 == null) {
            QLog.d("LIAContentProcessor", 1, "no res err. type=" + actionItem.getType() + ", subType=" + actionItem.c());
            return;
        }
        LIAInjectUtil.f353125a.h(innerBtn, LIAScene.MsgList, new LIAInjectUtil.a(actionItem, e16, null, new Contact(item.n(), item.k(), ex3.a.f(item.s())), false, 20, null));
    }

    private final void h(g item, LIAActionItem action) {
        com.tencent.qqnt.chats.api.b chatsListReport = ((IChatsReportHelper) QRoute.api(IChatsReportHelper.class)).getChatsListReport(item.o());
        if (chatsListReport != null) {
            chatsListReport.t(item, action.b(), action.getType(), action.c());
        }
    }

    private final void i(g item, LIAActionItem action) {
        com.tencent.qqnt.chats.api.b chatsListReport = ((IChatsReportHelper) QRoute.api(IChatsReportHelper.class)).getChatsListReport(item.o());
        if (chatsListReport != null) {
            chatsListReport.f(item, action.b(), action.getType(), action.c());
        }
    }

    private final void j(View actionBtn, g item, RecentContactItemBinding binding, LIAActionItem actionItem) {
        WeakReference weakReference = new WeakReference(binding);
        actionBtn.animate().alpha(0.0f).setDuration(200L).setInterpolator(new LinearInterpolator()).setListener(new C9596b(new WeakReference(actionBtn), weakReference, this, item, actionItem)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(View actionBtn, RecentContactItemBinding binding, g item) {
        if (actionBtn.getVisibility() != 0) {
            return;
        }
        actionBtn.setOnClickListener(null);
        actionBtn.setVisibility(8);
        if (item.n() == 1 && binding.l().getTag(R.id.f907853e) != null) {
            binding.l().setVisibility(0);
        }
        binding.m().setShowIconDrawable(true);
        binding.m().setShowTimeStamp(true);
        binding.k().setTag(R.id.f922457c, null);
    }

    private final String l(g item, LIAActionItem actionItem) {
        return item.k() + actionItem.getType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(final g item, final LIAActionItem actionItem, final RecentContactItemBinding bind, Drawable iconDrawable) {
        if (!Intrinsics.areEqual(l(item, actionItem), bind.b().getTag(R.id.f922457c))) {
            return;
        }
        View e16 = bind.e(true);
        if (e16 != null) {
            e16.setVisibility(0);
            e16.setAlpha(1.0f);
            ViewGroup viewGroup = (ViewGroup) e16;
            View childAt = viewGroup.getChildAt(0);
            Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.widget.ImageView");
            ((ImageView) childAt).setImageDrawable(iconDrawable);
            e16.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.chats.main.lightbusiness.interaction.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    b.n(b.this, item, bind, actionItem, view);
                }
            });
            f(viewGroup, actionItem);
        }
        bind.l().setVisibility(8);
        bind.m().setShowIconDrawable(false);
        bind.m().setShowTimeStamp(false);
        com.tencent.qqnt.chats.view.a aVar = null;
        a.Companion.b(com.tencent.qqnt.chats.core.itempart.summary.a.INSTANCE, bind.k(), false, 2, null);
        KeyEvent.Callback k3 = bind.k();
        if (k3 instanceof com.tencent.qqnt.chats.view.a) {
            aVar = (com.tencent.qqnt.chats.view.a) k3;
        }
        if (aVar != null) {
            aVar.setSummaryContent(actionItem.e());
        }
        bind.k().setTag(R.id.f922457c, 1);
        i(item, actionItem);
        QLog.d("LIAContentProcessor", 1, "[handleShowView] uin=" + item.l() + ", key=" + l(item, actionItem));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(b this$0, g item, RecentContactItemBinding bind, LIAActionItem actionItem, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        Intrinsics.checkNotNullParameter(bind, "$bind");
        Intrinsics.checkNotNullParameter(actionItem, "$actionItem");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.j(it, item, bind, actionItem);
        this$0.h(item, actionItem);
        EventCollector.getInstance().onViewClicked(it);
    }

    private final Bitmap o(Drawable d16, int depth) {
        BitmapDrawable bitmapDrawable;
        if (depth > 3) {
            return null;
        }
        if (d16 instanceof URLDrawable) {
            if (QLog.isDebugVersion()) {
                QLog.d("LIAContentProcessor", 1, "[tryToGetFromDrawable] drawable: " + ((URLDrawable) d16).getCurrDrawable());
            }
            URLDrawable uRLDrawable = (URLDrawable) d16;
            if (uRLDrawable.getCurrDrawable() == null) {
                return null;
            }
            Drawable currDrawable = uRLDrawable.getCurrDrawable();
            Intrinsics.checkNotNullExpressionValue(currDrawable, "d.currDrawable");
            return o(currDrawable, depth + 1);
        }
        if (d16 instanceof SkinnableBitmapDrawable) {
            return ((SkinnableBitmapDrawable) d16).getBitmap();
        }
        if (d16 instanceof RegionDrawable) {
            return ((RegionDrawable) d16).getBitmap();
        }
        if (d16 instanceof BitmapDrawable) {
            bitmapDrawable = (BitmapDrawable) d16;
        } else {
            bitmapDrawable = null;
        }
        if (bitmapDrawable == null) {
            return null;
        }
        return bitmapDrawable.getBitmap();
    }

    static /* synthetic */ Bitmap p(b bVar, Drawable drawable, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 0;
        }
        return bVar.o(drawable, i3);
    }

    @Override // com.tencent.qqnt.chats.inject.content.a
    public void a(@NotNull g item, @NotNull com.tencent.qqnt.chats.core.adapter.holder.h view, @NotNull RecentContactItemBinding binging) {
        LIAActionItem lIAActionItem;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, item, view, binging);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(binging, "binging");
        String str = null;
        if (item.z()) {
            lIAActionItem = (LIAActionItem) item.h(LiteBusinessType.KLITEACTION);
        } else {
            lIAActionItem = null;
        }
        if (lIAActionItem != null && lIAActionItem.getType() != 0) {
            if (binging.l().getVisibility() == 0) {
                binging.l().setVisibility(8);
            }
            String l3 = l(item, lIAActionItem);
            if (Intrinsics.areEqual(l3, binging.b().getTag(R.id.f922457c))) {
                QLog.d("LIAContentProcessor", 1, "[updateContent] no need to reset when equal");
                return;
            }
            binging.b().setTag(R.id.f922457c, l3);
            WeakReference weakReference = new WeakReference(binging);
            int i3 = item.q().getInt("key_lite_sub_type", -1);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                str = peekAppRuntime.getCurrentUid();
            }
            if (str == null) {
                str = "";
            }
            lIAActionItem.k(i3);
            LIAHelper.f353124a.g(new Contact(item.n(), item.k(), ex3.a.f(item.s())), lIAActionItem, (int) item.m(), new c(weakReference, item, str, lIAActionItem, this));
            return;
        }
        View f16 = RecentContactItemBinding.f(binging, false, 1, null);
        if (f16 != null) {
            k(f16, binging, item);
        }
        binging.b().setTag(R.id.f922457c, null);
    }
}
