package com.tencent.timi.game.gift.impl.timi;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qqlive.api.config.QQLiveSDKConfigHelper;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.timi.game.gift.impl.sdk.GiftSdkProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass$QQUserId;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0014\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0005J\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0015R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0017R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0018R\u0016\u0010\u000b\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u001aR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u001c\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/timi/game/gift/impl/timi/a;", "", "", "roomId", "e", "", "businessId", "b", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "d", "panelStyle", "c", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "userId", "f", "Landroid/view/ViewGroup;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/timi/game/gift/impl/timi/TimiGiftController;", "a", "Landroid/content/Context;", "Landroid/content/Context;", "ctx", "I", "Lcom/tencent/mobileqq/app/QBaseActivity;", "qBaseActivity", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "selfUserId", "J", "<init>", "(Landroid/content/Context;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context ctx;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int businessId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QBaseActivity qBaseActivity;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int panelStyle;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CommonOuterClass$QQUserId selfUserId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long roomId;

    public a(@NotNull Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        this.ctx = ctx;
        this.businessId = QQLiveSDKConfigHelper.getSceneId();
        this.panelStyle = 1;
    }

    @NotNull
    public final TimiGiftController a(@NotNull ViewGroup rootView) {
        GiftSdkProvider giftSdkProvider;
        String str;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        TimiGiftLayerView timiGiftLayerView = new TimiGiftLayerView(this.ctx, null, 0, 6, null);
        com.tencent.timi.game.initer.impl.b.f377190a.f(this.businessId);
        QBaseActivity qBaseActivity = this.qBaseActivity;
        if (qBaseActivity != null) {
            giftSdkProvider = new GiftSdkProvider(this.businessId, qBaseActivity, this.panelStyle);
        } else {
            giftSdkProvider = null;
        }
        GiftSdkProvider giftSdkProvider2 = giftSdkProvider;
        ReceiverAdapter receiverAdapter = new ReceiverAdapter(this.ctx);
        ReceiverSelectorView receiverSelectorView = new ReceiverSelectorView(this.ctx, null, 0, 6, null);
        int i3 = this.businessId;
        if (i3 != 10005 && i3 != 10004) {
            str = "2";
        } else {
            str = "3";
        }
        String str2 = str;
        long j3 = this.roomId;
        CommonOuterClass$QQUserId commonOuterClass$QQUserId = this.selfUserId;
        if (commonOuterClass$QQUserId == null) {
            commonOuterClass$QQUserId = ((bo4.d) mm4.b.b(bo4.d.class)).b2(((ll4.a) mm4.b.b(ll4.a.class)).h());
        }
        TimiGiftController timiGiftController = new TimiGiftController(giftSdkProvider2, j3, commonOuterClass$QQUserId, receiverAdapter, new ai4.e(), timiGiftLayerView, receiverSelectorView, str2);
        timiGiftLayerView.j(giftSdkProvider2);
        rootView.addView(timiGiftLayerView, new ViewGroup.LayoutParams(-1, -1));
        receiverSelectorView.a(receiverAdapter);
        return timiGiftController;
    }

    @NotNull
    public final a b(int businessId) {
        this.businessId = businessId;
        return this;
    }

    @NotNull
    public final a c(int panelStyle) {
        this.panelStyle = panelStyle;
        return this;
    }

    @NotNull
    public final a d(@NotNull QBaseActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.qBaseActivity = activity;
        return this;
    }

    @NotNull
    public final a e(long roomId) {
        this.roomId = roomId;
        return this;
    }

    @NotNull
    public final a f(@NotNull CommonOuterClass$QQUserId userId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        this.selfUserId = userId;
        return this;
    }
}
