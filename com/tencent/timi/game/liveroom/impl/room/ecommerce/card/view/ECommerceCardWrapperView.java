package com.tencent.timi.game.liveroom.impl.room.ecommerce.card.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.qqecommerce.biz.sdk.api.IQQECommerceSdk;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.liveroom.impl.room.ecommerce.card.view.g;
import cooperation.qzone.report.lp.LpReportInfoConfig;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001\u0011B'\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001c\u001a\u00020\r\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0016\u00a8\u0006 "}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/ecommerce/card/view/ECommerceCardWrapperView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/timi/game/liveroom/impl/room/ecommerce/card/view/g;", "d", "", "onEnterRoom", "b", "Lbj4/a;", "vm", "setCardViewModel", "Ldj4/a;", "product", "c", "", "type", "", "pushMsg", "a", "onActivityCreate", "onActivityResume", "onActivityStop", "onActivityDestroy", "Lcom/tencent/timi/game/liveroom/impl/room/ecommerce/card/view/g;", "ecommerceCardView", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attr", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "e", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class ECommerceCardWrapperView extends FrameLayout implements g {

    /* renamed from: f, reason: collision with root package name */
    private static boolean f377596f;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private g ecommerceCardView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ECommerceCardWrapperView(@NotNull Context ctx) {
        this(ctx, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    private final g d() {
        boolean z16;
        if (!f377596f) {
            ((IReadInJoyHelper) QRoute.api(IReadInJoyHelper.class)).initAladdin();
            f377596f = true;
        }
        if (((Number) ((IQQECommerceSdk) QRoute.api(IQQECommerceSdk.class)).getAladdinConfig(LpReportInfoConfig.ACTION_SPECIAL_FOLLOW_TOAST, "ecommerce_live_explain_version", 0)).intValue() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.i("EcommerceCardWrapperView", 1, "bubble use hr version:" + z16);
        if (z16) {
            setClipChildren(false);
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            return new ECommerceHRCardView(context, null, 0, 6, null);
        }
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        return new ECommerceCardView(context2, null, 0, 6, null);
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.ecommerce.card.view.g
    public void a(int type, @NotNull String pushMsg) {
        Intrinsics.checkNotNullParameter(pushMsg, "pushMsg");
        g.a.h(this, type, pushMsg);
        g gVar = this.ecommerceCardView;
        if (gVar != null) {
            gVar.a(type, pushMsg);
        }
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.ecommerce.card.view.g
    public void b() {
        g.a.g(this);
        g gVar = this.ecommerceCardView;
        if (gVar != null) {
            gVar.b();
        }
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.ecommerce.card.view.g
    public void c(@Nullable dj4.a product) {
        g gVar = this.ecommerceCardView;
        if (gVar != null) {
            gVar.c(product);
        }
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.ecommerce.card.view.g
    public void onActivityCreate() {
        g.a.b(this);
        g gVar = this.ecommerceCardView;
        if (gVar != null) {
            gVar.onActivityCreate();
        }
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.ecommerce.card.view.g
    public void onActivityDestroy() {
        g.a.c(this);
        g gVar = this.ecommerceCardView;
        if (gVar != null) {
            gVar.onActivityDestroy();
        }
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.ecommerce.card.view.g
    public void onActivityResume() {
        g.a.d(this);
        g gVar = this.ecommerceCardView;
        if (gVar != null) {
            gVar.onActivityResume();
        }
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.ecommerce.card.view.g
    public void onActivityStop() {
        g.a.e(this);
        g gVar = this.ecommerceCardView;
        if (gVar != null) {
            gVar.onActivityStop();
        }
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.ecommerce.card.view.g
    public void onEnterRoom() {
        g.a.f(this);
        g gVar = this.ecommerceCardView;
        if (gVar != null) {
            gVar.onEnterRoom();
        }
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.ecommerce.card.view.g
    public void setCardViewModel(@NotNull bj4.a vm5) {
        Intrinsics.checkNotNullParameter(vm5, "vm");
        g gVar = this.ecommerceCardView;
        if (gVar != null) {
            gVar.setCardViewModel(vm5);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ECommerceCardWrapperView(@NotNull Context ctx, @Nullable AttributeSet attributeSet) {
        this(ctx, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    public /* synthetic */ ECommerceCardWrapperView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public ECommerceCardWrapperView(@NotNull Context ctx, @Nullable AttributeSet attributeSet, int i3) {
        super(ctx, attributeSet, i3);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        g d16 = d();
        this.ecommerceCardView = d16;
        Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type android.view.View");
        addView((View) d16);
    }
}
