package com.tencent.timi.game.gift.impl.sdk;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qqgift.api.IQQGiftManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import nh2.c;
import oh2.b;
import org.jetbrains.annotations.NotNull;
import ph2.a;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010(\u001a\u00020\f\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b)\u0010*J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001c\u0010\u0013\u001a\n \u0011*\u0004\u0018\u00010\u00100\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0012R\u001b\u0010\u0018\u001a\u00020\u00148FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001d\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010#\u001a\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010'\u001a\u00020$8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010%\u001a\u0004\b\u001f\u0010&\u00a8\u0006+"}, d2 = {"Lcom/tencent/timi/game/gift/impl/sdk/GiftSdkProvider;", "", "Lsh2/c;", "d", "", "isSdkDestroy", "", "c", "Lcom/tencent/mobileqq/app/QBaseActivity;", "a", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "b", "I", "panelStyle", "Lnh2/c;", "kotlin.jvm.PlatformType", "Lnh2/c;", "qqSdk", "Lcom/tencent/mobileqq/qqgift/mvvm/business/anim/b;", "Lkotlin/Lazy;", "e", "()Lcom/tencent/mobileqq/qqgift/mvvm/business/anim/b;", "animationEngine", "Loh2/b;", "Loh2/b;", "g", "()Loh2/b;", "giftServerModule", "Lph2/a;", "f", "Lph2/a;", "getGiftViewModule", "()Lph2/a;", "giftViewModule", "Loh2/a;", "Loh2/a;", "()Loh2/a;", "giftResDownloadModule", "businessId", "<init>", "(ILcom/tencent/mobileqq/app/QBaseActivity;I)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class GiftSdkProvider {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QBaseActivity activity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int panelStyle;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final c qqSdk;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy animationEngine;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b giftServerModule;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a giftViewModule;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final oh2.a giftResDownloadModule;

    public GiftSdkProvider(int i3, @NotNull QBaseActivity activity, int i16) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
        this.panelStyle = i16;
        c sDKImpl = ((IQQGiftManager) QRoute.api(IQQGiftManager.class)).getSDKImpl(i3);
        this.qqSdk = sDKImpl;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.qqgift.mvvm.business.anim.b>() { // from class: com.tencent.timi.game.gift.impl.sdk.GiftSdkProvider$animationEngine$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.qqgift.mvvm.business.anim.b invoke() {
                c cVar;
                QBaseActivity qBaseActivity;
                cVar = GiftSdkProvider.this.qqSdk;
                a d16 = cVar.d();
                qBaseActivity = GiftSdkProvider.this.activity;
                com.tencent.mobileqq.qqgift.mvvm.business.anim.b A = d16.A(qBaseActivity, 1);
                A.prepare();
                return A;
            }
        });
        this.animationEngine = lazy;
        b a16 = sDKImpl.a();
        Intrinsics.checkNotNullExpressionValue(a16, "qqSdk.serviceModule");
        this.giftServerModule = a16;
        a d16 = sDKImpl.d();
        Intrinsics.checkNotNullExpressionValue(d16, "qqSdk.viewModule");
        this.giftViewModule = d16;
        oh2.a b16 = sDKImpl.b();
        Intrinsics.checkNotNullExpressionValue(b16, "qqSdk.resModule");
        this.giftResDownloadModule = b16;
    }

    public final void c(boolean isSdkDestroy) {
        e().release();
        if (this.qqSdk.isDestroyed()) {
            this.qqSdk.destroy();
        }
    }

    @NotNull
    public final sh2.c d() {
        sh2.c l3 = this.qqSdk.d().l(this.activity, this.panelStyle);
        Intrinsics.checkNotNullExpressionValue(l3, "qqSdk.viewModule.createG\u2026nel(activity, panelStyle)");
        return l3;
    }

    @NotNull
    public final com.tencent.mobileqq.qqgift.mvvm.business.anim.b e() {
        Object value = this.animationEngine.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-animationEngine>(...)");
        return (com.tencent.mobileqq.qqgift.mvvm.business.anim.b) value;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final oh2.a getGiftResDownloadModule() {
        return this.giftResDownloadModule;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final b getGiftServerModule() {
        return this.giftServerModule;
    }
}
