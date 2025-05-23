package com.tencent.mobileqq.matchfriend.reborn.content.msg.nt;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendChatApi;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.nt.i;
import com.tencent.mobileqq.matchfriend.reborn.liteinteraction.QQStrangerLIAHelper;
import com.tencent.mobileqq.matchfriend.reborn.liteinteraction.QQStrangerLIAItem;
import com.tencent.mobileqq.matchfriend.reborn.liteinteraction.action.QQStrangerLIAClickHandlerProvider;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqnt.chats.api.IStrangerChatsApi;
import com.tencent.qqnt.chats.biz.qqstranger.api.IQQStrangerChatUtilApi;
import com.tencent.qqnt.chats.core.adapter.holder.RecentContactItemBinding;
import com.tencent.qqnt.chats.core.itempart.summary.a;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import p82.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 %2\u00020\u0001:\u0001%B\u0007\u00a2\u0006\u0004\b&\u0010'J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J(\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J,\u0010\u0013\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\u0014\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\u001b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010 \u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010!\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u000eH\u0002J\u0018\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\"*\u00020\u0004H\u0002J \u0010%\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020$2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/nt/r;", "Lcom/tencent/qqnt/chats/inject/content/a;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/matchfriend/reborn/liteinteraction/d;", "actionItem", "Lcom/tencent/qqnt/chats/core/adapter/holder/RecentContactItemBinding;", "binding", "Landroid/graphics/drawable/Drawable;", "iconDrawable", "", "l", "", "k", "Landroid/view/View;", "actionBtn", "g", "innerBtn", "innerBinding", "d", "i", "", "depth", "Landroid/graphics/Bitmap;", "r", "", "j", "o", DomainData.DOMAIN_NAME, tl.h.F, "view", "f", "e", "p", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/qqnt/chats/core/adapter/holder/h;", "a", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class r extends com.tencent.qqnt.chats.inject.content.a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/content/msg/nt/r$b", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class b extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ WeakReference<View> f244710d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ WeakReference<RecentContactItemBinding> f244711e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ r f244712f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ com.tencent.qqnt.chats.core.adapter.itemdata.g f244713h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ QQStrangerLIAItem f244714i;

        b(WeakReference<View> weakReference, WeakReference<RecentContactItemBinding> weakReference2, r rVar, com.tencent.qqnt.chats.core.adapter.itemdata.g gVar, QQStrangerLIAItem qQStrangerLIAItem) {
            this.f244710d = weakReference;
            this.f244711e = weakReference2;
            this.f244712f = rVar;
            this.f244713h = gVar;
            this.f244714i = qQStrangerLIAItem;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            this.f244712f.d(this.f244710d.get(), this.f244711e.get(), this.f244713h, this.f244714i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(View innerBtn, RecentContactItemBinding innerBinding, com.tencent.qqnt.chats.core.adapter.itemdata.g item, QQStrangerLIAItem actionItem) {
        if (innerBtn != null && innerBinding != null && RecentContactItemBinding.f(innerBinding, false, 1, null) != null) {
            Object parent = innerBinding.a().getAvatarLayout().getParent();
            View view = parent instanceof View ? (View) parent : null;
            if (view == null || view.getId() != R.id.f164548a32) {
                view = innerBinding.a().getAvatarLayout();
            }
            View f16 = RecentContactItemBinding.f(innerBinding, false, 1, null);
            Intrinsics.checkNotNull(f16, "null cannot be cast to non-null type android.view.ViewGroup");
            View childAt = ((ViewGroup) f16).getChildAt(0);
            Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.widget.ImageView");
            Drawable drawable = ((ImageView) childAt).getDrawable();
            Intrinsics.checkNotNullExpressionValue(drawable, "(innerBinding.getInterAc\u20260) as ImageView).drawable");
            Bitmap s16 = s(this, drawable, 0, 2, null);
            if (s16 == null) {
                if (!QLog.isDebugVersion()) {
                    QLog.d("QQStrangerLIAContentProcessor", 1, "[doAfterAnim] " + item.k() + " not able to get bitmap)");
                    return;
                }
                throw new IllegalStateException("not able to get bitmap");
            }
            ((IQQStrangerChatUtilApi) QRoute.api(IQQStrangerChatUtilApi.class)).sendEventToChat(new i.QQStrangerShowLightInterActionAnim(item, view, actionItem, s16));
            i(innerBtn, innerBinding, item);
            return;
        }
        QLog.d("QQStrangerLIAContentProcessor", 1, "hide anim after. view is recycled. isBindingNull=" + (innerBinding == null) + ", isBtnNull=" + (innerBtn == null));
        if (QLog.isDevelopLevel()) {
            QLog.d("QQStrangerLIAContentProcessor", 1, "no lia anim, to send msg, name=" + item.w().e());
        }
        com.tencent.mobileqq.matchfriend.reborn.liteinteraction.action.a a16 = QQStrangerLIAClickHandlerProvider.f245123a.a(actionItem.getType());
        if (a16 != null) {
            a16.a(actionItem, new Contact(item.n(), item.k(), ""));
        }
    }

    private final void e(View view, QQStrangerLIAItem actionItem) {
        p(view);
        VideoReport.reportEvent("clck", view, q(actionItem));
    }

    private final void f(View view, QQStrangerLIAItem actionItem) {
        p(view);
        VideoReport.reportEvent("imp", view, q(actionItem));
    }

    private final void g(View actionBtn, com.tencent.qqnt.chats.core.adapter.itemdata.g item, RecentContactItemBinding binding, QQStrangerLIAItem actionItem) {
        WeakReference weakReference = new WeakReference(binding);
        actionBtn.animate().alpha(0.0f).setDuration(200L).setInterpolator(new LinearInterpolator()).setListener(new b(new WeakReference(actionBtn), weakReference, this, item, actionItem)).start();
    }

    private final void h(com.tencent.qqnt.chats.core.adapter.itemdata.g item) {
        a.Companion companion = p82.a.INSTANCE;
        if (companion.b(item.m())) {
            companion.c(item.m());
            ((IStrangerChatsApi) QRoute.api(IStrangerChatsApi.class)).reportChatItemImplEvent("qq_imp", item, false);
        }
    }

    private final void i(View actionBtn, RecentContactItemBinding binding, com.tencent.qqnt.chats.core.adapter.itemdata.g item) {
        if (actionBtn.getVisibility() != 0) {
            return;
        }
        actionBtn.setOnClickListener(null);
        actionBtn.setVisibility(8);
        if (item.n() == 104 && binding.l().getTag(R.id.f907853e) != null) {
            binding.l().setVisibility(0);
        }
        binding.m().setShowIconDrawable(true);
        binding.m().setShowTimeStamp(true);
    }

    private final boolean j(com.tencent.qqnt.chats.core.adapter.itemdata.g item) {
        return item.n() != 104;
    }

    private final String k(com.tencent.qqnt.chats.core.adapter.itemdata.g item, QQStrangerLIAItem actionItem) {
        return item.k() + actionItem.getType();
    }

    private final void l(final com.tencent.qqnt.chats.core.adapter.itemdata.g item, final QQStrangerLIAItem actionItem, final RecentContactItemBinding binding, Drawable iconDrawable) {
        if (Intrinsics.areEqual(k(item, actionItem), binding.b().getTag(R.id.f922457c))) {
            final View e16 = binding.e(true);
            if (e16 != null) {
                e16.setVisibility(0);
                e16.setAlpha(1.0f);
                View childAt = ((ViewGroup) e16).getChildAt(0);
                Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.widget.ImageView");
                ((ImageView) childAt).setImageDrawable(iconDrawable);
                e16.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.nt.q
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        r.m(r.this, actionItem, e16, item, binding, view);
                    }
                });
                f(e16, actionItem);
            }
            binding.l().setVisibility(8);
            binding.m().setShowIconDrawable(false);
            binding.m().setShowTimeStamp(false);
            o(item, actionItem, binding);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(r this$0, QQStrangerLIAItem actionItem, View this_apply, com.tencent.qqnt.chats.core.adapter.itemdata.g item, RecentContactItemBinding binding, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(actionItem, "$actionItem");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(item, "$item");
        Intrinsics.checkNotNullParameter(binding, "$binding");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.e(it, actionItem);
        this$0.g(this_apply, item, binding, actionItem);
    }

    private final boolean n(QQStrangerLIAItem actionItem) {
        return actionItem.getType() == 1 || actionItem.getType() == 2;
    }

    private final void o(com.tencent.qqnt.chats.core.adapter.itemdata.g item, QQStrangerLIAItem actionItem, RecentContactItemBinding binding) {
        a.Companion.b(com.tencent.qqnt.chats.core.itempart.summary.a.INSTANCE, binding.k(), false, 2, null);
        KeyEvent.Callback k3 = binding.k();
        com.tencent.qqnt.chats.view.a aVar = k3 instanceof com.tencent.qqnt.chats.view.a ? (com.tencent.qqnt.chats.view.a) k3 : null;
        if (aVar != null) {
            boolean n3 = n(actionItem);
            CharSequence summary = actionItem.getResource().getSummary();
            if (n3) {
                summary = "[\u65b0\u5339\u914d]" + ((Object) summary);
            }
            aVar.setSummaryContent(summary);
        }
        h(item);
    }

    private final void p(View view) {
        VideoReport.setPageId(view.getParent(), "pg_kl_new_chat_list");
        VideoReport.setPageParams(view.getParent(), "kl_new_from_openid", ((IMatchFriendChatApi) QRoute.api(IMatchFriendChatApi.class)).getSelfOpenId());
        VideoReport.setPageReportPolicy(view.getParent(), PageReportPolicy.REPORT_NONE);
        VideoReport.setElementId(view, "em_kl_emoji_icon");
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_NONE);
    }

    private final Map<String, String> q(QQStrangerLIAItem qQStrangerLIAItem) {
        Map<String, String> mapOf;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("kl_emoji_id", String.valueOf(qQStrangerLIAItem.getResource().getEmojiId())));
        return mapOf;
    }

    @Override // com.tencent.qqnt.chats.inject.content.a
    public void a(com.tencent.qqnt.chats.core.adapter.itemdata.g item, com.tencent.qqnt.chats.core.adapter.holder.h view, RecentContactItemBinding binding) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(binding, "binding");
        if (j(item)) {
            return;
        }
        QQStrangerLIAHelper qQStrangerLIAHelper = QQStrangerLIAHelper.f245114a;
        QQStrangerLIAItem u16 = qQStrangerLIAHelper.u(new Contact(item.n(), item.k(), ""), 1);
        if (u16 == null) {
            View f16 = RecentContactItemBinding.f(binding, false, 1, null);
            if (f16 != null) {
                i(f16, binding, item);
            }
            binding.b().setTag(R.id.f922457c, null);
            return;
        }
        qQStrangerLIAHelper.C(u16);
        Drawable c16 = com.tencent.mobileqq.matchfriend.reborn.liteinteraction.e.c(u16.getResource());
        if (c16 == null) {
            View f17 = RecentContactItemBinding.f(binding, false, 1, null);
            if (f17 != null) {
                i(f17, binding, item);
            }
            binding.b().setTag(R.id.f922457c, null);
            return;
        }
        if (binding.l().getVisibility() == 0) {
            binding.l().setVisibility(8);
        }
        String k3 = k(item, u16);
        if (Intrinsics.areEqual(k3, binding.b().getTag(R.id.f922457c))) {
            QLog.d("QQStrangerLIAContentProcessor", 1, "[updateContent] no need to reset when equal");
        } else {
            binding.b().setTag(R.id.f922457c, k3);
            l(item, u16, binding, c16);
        }
    }

    private final Bitmap r(Drawable d16, int depth) {
        if (depth > 3) {
            return null;
        }
        if (d16 instanceof URLDrawable) {
            if (QLog.isDebugVersion()) {
                QLog.d("QQStrangerLIAContentProcessor", 1, "[tryToGetFromDrawable] drawable: " + ((URLDrawable) d16).getCurrDrawable());
            }
            URLDrawable uRLDrawable = (URLDrawable) d16;
            if (uRLDrawable.getCurrDrawable() == null) {
                return null;
            }
            Drawable currDrawable = uRLDrawable.getCurrDrawable();
            Intrinsics.checkNotNullExpressionValue(currDrawable, "d.currDrawable");
            return r(currDrawable, depth + 1);
        }
        if (d16 instanceof SkinnableBitmapDrawable) {
            return ((SkinnableBitmapDrawable) d16).getBitmap();
        }
        if (d16 instanceof RegionDrawable) {
            return ((RegionDrawable) d16).getBitmap();
        }
        if (d16 instanceof BitmapDrawable) {
            return ((BitmapDrawable) d16).getBitmap();
        }
        Bitmap createBitmap = Bitmap.createBitmap(d16.getIntrinsicWidth(), d16.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        d16.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    static /* synthetic */ Bitmap s(r rVar, Drawable drawable, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 0;
        }
        return rVar.r(drawable, i3);
    }
}
