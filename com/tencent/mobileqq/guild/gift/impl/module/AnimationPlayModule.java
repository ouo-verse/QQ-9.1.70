package com.tencent.mobileqq.guild.gift.impl.module;

import android.content.Context;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import kotlin.C11734b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0007*\u0001\u001f\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0005\u001a\u00020\u0004H\u0003J\b\u0010\u0006\u001a\u00020\u0004H\u0003J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016J$\u0010\u0011\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0016R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/guild/gift/impl/module/AnimationPlayModule;", "Lcom/tencent/mobileqq/guild/gift/module/a;", "Lcom/tencent/mobileqq/guild/gift/module/b;", "Landroidx/lifecycle/LifecycleObserver;", "", "onPageStart", "onPageStop", ReportConstant.COSTREPORT_PREFIX, "Lmo1/b;", "eventBus", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroidx/lifecycle/Lifecycle;", "pageLifecycle", "Landroid/view/ViewGroup;", "bannerViewGroup", "fullViewGroup", "b", "Lcom/tencent/mobileqq/qqgift/mvvm/business/anim/a;", "data", "r", tl.h.F, "Landroidx/lifecycle/Lifecycle;", "lifecycle", "i", "Landroid/view/ViewGroup;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/qqgift/mvvm/business/anim/b;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/qqgift/mvvm/business/anim/b;", "animationEngine", "com/tencent/mobileqq/guild/gift/impl/module/AnimationPlayModule$a", "D", "Lcom/tencent/mobileqq/guild/gift/impl/module/AnimationPlayModule$a;", "addAnimationDataEvent", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class AnimationPlayModule extends com.tencent.mobileqq.guild.gift.module.a implements com.tencent.mobileqq.guild.gift.module.b, LifecycleObserver {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qqgift.mvvm.business.anim.b animationEngine;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private a addAnimationDataEvent = new a();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Lifecycle lifecycle;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup bannerViewGroup;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup fullViewGroup;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/gift/impl/module/AnimationPlayModule$a", "Lmo1/d;", "Lcom/tencent/mobileqq/guild/gift/impl/module/a;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements mo1.d<com.tencent.mobileqq.guild.gift.impl.module.a> {
        a() {
        }

        @Override // mo1.d
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull com.tencent.mobileqq.guild.gift.impl.module.a event) {
            Intrinsics.checkNotNullParameter(event, "event");
            C11734b c11734b = C11734b.f433780a;
            QLog.i("Guild.component.IGuildGiftEngine.", 1, "AddAnimationDataEvent," + event.getData(), null);
            AnimationPlayModule.this.r(event.getData());
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private final void onPageStart() {
        Context context;
        com.tencent.mobileqq.qqgift.mvvm.business.anim.b bVar;
        ph2.a d16;
        ViewGroup viewGroup = this.bannerViewGroup;
        if (viewGroup == null || (context = viewGroup.getContext()) == null) {
            ViewGroup viewGroup2 = this.fullViewGroup;
            if (viewGroup2 != null) {
                context = viewGroup2.getContext();
            } else {
                context = null;
            }
        }
        if (context == null) {
            C11734b c11734b = C11734b.f433780a;
            QLog.w("Guild.component.IGuildGiftEngine.", 1, "onPageStart, not set anim play view.", null);
            return;
        }
        nh2.c sdk = getSdk();
        if (sdk != null && (d16 = sdk.d()) != null) {
            bVar = d16.A(context, 0);
        } else {
            bVar = null;
        }
        this.animationEngine = bVar;
        if (bVar == null) {
            C11734b c11734b2 = C11734b.f433780a;
            QLog.e("Guild.component.IGuildGiftEngine.", 1, "onPageStart, animationEngine is null!", (Throwable) null);
            return;
        }
        Intrinsics.checkNotNull(bVar);
        bVar.prepare();
        ViewGroup viewGroup3 = this.bannerViewGroup;
        if (viewGroup3 != null) {
            com.tencent.mobileqq.qqgift.mvvm.business.anim.b bVar2 = this.animationEngine;
            Intrinsics.checkNotNull(bVar2);
            viewGroup3.addView(bVar2.b(), new ViewGroup.LayoutParams(-1, -1));
        }
        ViewGroup viewGroup4 = this.fullViewGroup;
        if (viewGroup4 != null) {
            com.tencent.mobileqq.qqgift.mvvm.business.anim.b bVar3 = this.animationEngine;
            Intrinsics.checkNotNull(bVar3);
            viewGroup4.addView(bVar3.k(), new ViewGroup.LayoutParams(-1, -1));
        }
        C11734b c11734b3 = C11734b.f433780a;
        QLog.i("Guild.component.IGuildGiftEngine.", 1, "onPageStart, complete. " + this.bannerViewGroup + ", " + this.fullViewGroup, null);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private final void onPageStop() {
        s();
        C11734b c11734b = C11734b.f433780a;
        QLog.i("Guild.component.IGuildGiftEngine.", 1, "onPageStop, complete.", null);
    }

    private final void s() {
        com.tencent.mobileqq.qqgift.mvvm.business.anim.b bVar = this.animationEngine;
        if (bVar != null) {
            bVar.release();
        }
        this.animationEngine = null;
        Lifecycle lifecycle = this.lifecycle;
        if (lifecycle != null) {
            lifecycle.removeObserver(this);
        }
        this.lifecycle = null;
        this.bannerViewGroup = null;
        this.fullViewGroup = null;
    }

    @Override // com.tencent.mobileqq.guild.gift.module.b
    public void b(@NotNull Lifecycle pageLifecycle, @Nullable ViewGroup bannerViewGroup, @Nullable ViewGroup fullViewGroup) {
        Intrinsics.checkNotNullParameter(pageLifecycle, "pageLifecycle");
        C11734b c11734b = C11734b.f433780a;
        QLog.i("Guild.component.IGuildGiftEngine.", 1, "setGiftAnimationContainer.", null);
        com.tencent.mobileqq.qqgift.mvvm.business.anim.b bVar = this.animationEngine;
        if (bVar != null) {
            bVar.release();
        }
        Lifecycle lifecycle = this.lifecycle;
        if (lifecycle != null) {
            lifecycle.removeObserver(this);
        }
        this.lifecycle = pageLifecycle;
        this.bannerViewGroup = bannerViewGroup;
        this.fullViewGroup = fullViewGroup;
        pageLifecycle.addObserver(this);
    }

    @Override // com.tencent.mobileqq.guild.gift.module.a
    public void n(@NotNull mo1.b eventBus) {
        Intrinsics.checkNotNullParameter(eventBus, "eventBus");
        eventBus.b(com.tencent.mobileqq.guild.gift.impl.module.a.class, this.addAnimationDataEvent);
    }

    @Override // com.tencent.mobileqq.guild.gift.module.a
    public void q(@NotNull mo1.b eventBus) {
        Intrinsics.checkNotNullParameter(eventBus, "eventBus");
        eventBus.e(com.tencent.mobileqq.guild.gift.impl.module.a.class, this.addAnimationDataEvent);
    }

    public void r(@NotNull com.tencent.mobileqq.qqgift.mvvm.business.anim.a data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (this.animationEngine == null) {
            C11734b c11734b = C11734b.f433780a;
            QLog.e("Guild.component.IGuildGiftEngine.", 1, "addGiftAnimation, animationEngine is null!!!", (Throwable) null);
        }
        com.tencent.mobileqq.qqgift.mvvm.business.anim.b bVar = this.animationEngine;
        if (bVar != null) {
            bVar.d(data);
        }
    }
}
