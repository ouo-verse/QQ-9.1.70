package com.tencent.timi.game.liveroom.impl.room.ecommerce.card.view;

import android.animation.Animator;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import bj4.a;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.util.RFWTypefaceUtil;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqecommerce.biz.hr.api.IECHRAccessHelper;
import com.tencent.mobileqq.qqecommerce.biz.nv.api.INVViewModel;
import com.tencent.mobileqq.qqecommerce.biz.nv.api.INVViewModelFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.util.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.liveroom.impl.room.ecommerce.card.event.HideCardSimpleEvent;
import com.tencent.timi.game.liveroom.impl.room.ecommerce.card.event.ShowCardSimpleEvent;
import com.tencent.timi.game.liveroom.impl.room.ecommerce.card.view.g;
import fj4.a;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 I2\u00020\u00012\u00020\u0002:\u0002JKB'\b\u0007\u0012\u0006\u0010C\u001a\u00020B\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010D\u0012\b\b\u0002\u0010F\u001a\u00020\u000e\u00a2\u0006\u0004\bG\u0010HJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u000eH\u0002J\b\u0010\u0015\u001a\u00020\u0003H\u0002J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0002J,\u0010\u001a\u001a\u001e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180\u0017j\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018`\u00192\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0012\u0010\u001e\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016R\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010#R\u0016\u0010(\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010#R\u0018\u0010+\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010.\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0018\u00105\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010<\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010>\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010;R\u0016\u0010A\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@\u00a8\u0006L"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/ecommerce/card/view/ECommerceCardView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/timi/game/liveroom/impl/room/ecommerce/card/view/g;", "", "w", ReportConstant.COSTREPORT_PREFIX, "", "isAlphaHideType", "v", "Ldj4/a;", "product", "o", "Landroid/view/View;", "view", "", "animationType", "B", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "frameCount", "", DomainData.DOMAIN_NAME, "u", "t", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lbj4/a;", "vm", "setCardViewModel", "c", "d", "Lbj4/a;", "Landroid/view/ViewGroup;", "e", "Landroid/view/ViewGroup;", "cardContainer", "f", "cardContainerRoot", h.F, "cardExitIcon", "i", "Ldj4/a;", "explainingProduct", "Lcom/tencent/mobileqq/qqecommerce/biz/nv/api/INVViewModel;", "Lcom/tencent/mobileqq/qqecommerce/biz/nv/api/INVViewModel;", "nvViewModel", "Lfj4/a;", BdhLogUtil.LogTag.Tag_Conn, "Lfj4/a;", "ecAnimationSet", "D", "Landroid/view/View;", "cardView", "Lcom/tencent/timi/game/liveroom/impl/room/ecommerce/card/view/ECommerceCardView$b;", "E", "Lcom/tencent/timi/game/liveroom/impl/room/ecommerce/card/view/ECommerceCardView$b;", "waitingExecuteTask", UserInfo.SEX_FEMALE, "Z", "isAnimationPlaying", "G", "isProductShowing", "H", "J", "updateTimeStamp", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attr", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "I", "a", "b", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class ECommerceCardView extends FrameLayout implements g {

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static AtomicBoolean J = new AtomicBoolean(false);

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private fj4.a ecAnimationSet;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private View cardView;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private b waitingExecuteTask;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isAnimationPlaying;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean isProductShowing;

    /* renamed from: H, reason: from kotlin metadata */
    private long updateTimeStamp;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private bj4.a vm;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ViewGroup cardContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ViewGroup cardContainerRoot;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ViewGroup cardExitIcon;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private dj4.a explainingProduct;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private INVViewModel nvViewModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fR\u0014\u0010\u0005\u001a\u00020\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000eR\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\nR\u0014\u0010\u0017\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\nR\u0014\u0010\u0018\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\nR\u0014\u0010\u0019\u001a\u00020\u00138\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u000eR\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006 "}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/ecommerce/card/view/ECommerceCardView$a;", "", "", "c", "()F", "cardViewAnimationPivotX", "d", "cardViewAnimationPivotY", "", "ANIMATION_TYPE_HIDE", "I", "ANIMATION_TYPE_HIDE_WITH_ALPHA", "ANIMATION_TYPE_SHOW", "CARD_MARGIN_BOTTOM_DP", UserInfo.SEX_FEMALE, "CARD_MARGIN_LEFT_DP", "CARD_MARGIN_RIGHT_DP", "CARD_VIEW_HEIGHT", "CARD_VIEW_WIDTH", "", "NUMBER_FONT_BOLD_URL", "Ljava/lang/String;", "REPORT_EVENT_CLICK", "REPORT_EVENT_EXPOSE", "REPORT_EVENT_HIDE", "TAG", "VIEW_WIDTH_DP", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasInitNVView", "Ljava/util/concurrent/atomic/AtomicBoolean;", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.timi.game.liveroom.impl.room.ecommerce.card.view.ECommerceCardView$a, reason: from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final float c() {
            return ((IECHRAccessHelper) QRoute.api(IECHRAccessHelper.class)).dip2px(60.0f);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final float d() {
            return ((IECHRAccessHelper) QRoute.api(IECHRAccessHelper.class)).dip2px(188.0f);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u0003B\u001b\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\u0003\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/ecommerce/card/view/ECommerceCardView$b;", "", "", "a", "I", "b", "()I", "taskType", "Ldj4/a;", "Ldj4/a;", "()Ldj4/a;", "product", "<init>", "(ILdj4/a;)V", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int taskType;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final dj4.a product;

        public b(int i3, @Nullable dj4.a aVar) {
            this.taskType = i3;
            this.product = aVar;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final dj4.a getProduct() {
            return this.product;
        }

        /* renamed from: b, reason: from getter */
        public final int getTaskType() {
            return this.taskType;
        }

        public /* synthetic */ b(int i3, dj4.a aVar, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(i3, (i16 & 2) != 0 ? null : aVar);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ECommerceCardView(@NotNull Context ctx) {
        this(ctx, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A(int animationType) {
        this.isAnimationPlaying = false;
        if (animationType == 2) {
            setVisibility(8);
            SimpleEventBus.getInstance().dispatchEvent(new HideCardSimpleEvent());
            z();
        }
        s();
    }

    private final void B(View view, int animationType) {
        this.isAnimationPlaying = true;
        if (animationType != 1) {
            if (animationType != 2) {
                if (animationType == 3) {
                    this.ecAnimationSet = a.C10319a.b(new a.C10319a(n(10)), view, 1.0f, 0.0f, 0L, 0L, false, false, null, null, 504, null).d(new e(animationType)).c().a();
                    return;
                }
                return;
            }
            a.C10319a c10319a = new a.C10319a(n(10));
            Companion companion = INSTANCE;
            this.ecAnimationSet = a.C10319a.b(a.C10319a.f(a.C10319a.f(a.C10319a.f(c10319a, view, 1.0f, 1.08f, 1.0f, 1.08f, companion.c(), companion.d(), n(5), false, null, null, 0L, 3840, null), view, 1.08f, 1.03f, 1.08f, 1.03f, companion.c(), companion.d(), n(1), false, null, null, n(5), 1792, null), view, 1.03f, 0.6f, 1.03f, 0.6f, companion.c(), companion.d(), n(4), false, null, null, n(6), 1792, null), view, 1.0f, 0.0f, 0L, 0L, false, false, null, null, 504, null).d(new d(animationType)).c().a();
            return;
        }
        a.C10319a c10319a2 = new a.C10319a(n(10));
        Companion companion2 = INSTANCE;
        this.ecAnimationSet = a.C10319a.b(a.C10319a.f(a.C10319a.f(a.C10319a.f(c10319a2, view, 0.6f, 1.03f, 0.6f, 1.03f, companion2.c(), companion2.d(), n(4), false, null, null, 0L, 3840, null), view, 1.03f, 1.08f, 1.03f, 1.08f, companion2.c(), companion2.d(), n(1), false, null, null, n(4), 1792, null), view, 1.08f, 1.0f, 1.08f, 1.0f, companion2.c(), companion2.d(), n(5), false, null, null, n(5), 1792, null), view, 0.0f, 1.0f, 0L, 0L, false, false, null, null, 504, null).d(new c(animationType)).c().a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(ECommerceCardView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.u();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final HashMap<String, String> m(dj4.a product) {
        HashMap<String, String> hashMap = new HashMap<>();
        String str = product.d().get("product_name");
        if (str != null) {
            hashMap.put("qqlive_commodity_name", str);
        }
        String str2 = product.d().get("product_price");
        if (str2 != null) {
            hashMap.put("qqlive_commodity_price", str2);
        }
        String str3 = product.d().get("product_point_words");
        if (str3 != null) {
            hashMap.put("qqlive_product_point_words", str3);
        }
        String str4 = product.d().get("product_state");
        if (str4 != null) {
            hashMap.put("qqlive_product_state", str4);
        }
        String str5 = product.d().get(ReportDataBuilder.KEY_PRODUCT_ID);
        if (str5 != null) {
            hashMap.put("qqlive_item_id", str5);
        }
        String str6 = product.d().get("product_type");
        if (str6 != null) {
            hashMap.put("qqlive_product_type", str6);
        }
        return hashMap;
    }

    private final long n(int frameCount) {
        long roundToLong;
        roundToLong = MathKt__MathJVMKt.roundToLong((frameCount / 25.0f) * 1000);
        return roundToLong;
    }

    private final void o(final dj4.a product) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.ecommerce.card.view.c
            @Override // java.lang.Runnable
            public final void run() {
                ECommerceCardView.p(dj4.a.this, this);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(final dj4.a product, final ECommerceCardView this$0) {
        Intrinsics.checkNotNullParameter(product, "$product");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final INVViewModel create = ((INVViewModelFactory) QRoute.api(INVViewModelFactory.class)).create(true);
        try {
            INVViewModel.DefaultImpls.init$default(create, new JSONObject(product.getCardRichText()), ((IECHRAccessHelper) QRoute.api(IECHRAccessHelper.class)).dip2px(120.0f), null, 4, null);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.ecommerce.card.view.d
                @Override // java.lang.Runnable
                public final void run() {
                    ECommerceCardView.q(ECommerceCardView.this, product, create);
                }
            });
        } catch (JSONException e16) {
            QLog.e("EcommerceCardView", 1, "json error = " + e16.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(final ECommerceCardView this$0, final dj4.a product, INVViewModel nvViewModel) {
        bj4.a aVar;
        ViewParent parent;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(product, "$product");
        Intrinsics.checkNotNullParameter(nvViewModel, "$nvViewModel");
        b bVar = this$0.waitingExecuteTask;
        if (bVar != null) {
            if (Intrinsics.areEqual(bVar.getProduct(), product)) {
                this$0.waitingExecuteTask = null;
                this$0.isProductShowing = true;
                this$0.nvViewModel = nvViewModel;
                View view = this$0.cardView;
                if (view != null && (parent = view.getParent()) != null) {
                    Intrinsics.checkNotNullExpressionValue(parent, "parent");
                    ((ViewGroup) parent).removeAllViews();
                }
                View nVView = nvViewModel.getNVView(this$0.getContext());
                this$0.cardView = nVView;
                if (nVView != null) {
                    this$0.setVisibility(0);
                    this$0.cardContainer.addView(nVView);
                    nVView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.ecommerce.card.view.f
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            ECommerceCardView.r(ECommerceCardView.this, product, view2);
                        }
                    });
                    this$0.B(this$0.cardContainerRoot, 1);
                    bj4.a aVar2 = this$0.vm;
                    if (aVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("vm");
                        aVar = null;
                    } else {
                        aVar = aVar2;
                    }
                    a.C0130a.a(aVar, 1, product, 0L, 4, null);
                    ((ug4.a) mm4.b.b(ug4.a.class)).a(nVView, true, null, "em_qqlive_small_window", this$0.m(product));
                }
                SimpleEventBus.getInstance().dispatchEvent(new ShowCardSimpleEvent());
                return;
            }
            this$0.s();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(ECommerceCardView this$0, dj4.a product, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(product, "$product");
        this$0.t(product);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void s() {
        b bVar;
        if (J.get() && !this.isAnimationPlaying && (bVar = this.waitingExecuteTask) != null) {
            int taskType = bVar.getTaskType();
            if (taskType != 1) {
                if (taskType == 2) {
                    if (this.isProductShowing) {
                        v(false);
                    }
                    this.waitingExecuteTask = null;
                    return;
                }
                return;
            }
            if (this.isProductShowing) {
                v(true);
                return;
            }
            dj4.a product = bVar.getProduct();
            Intrinsics.checkNotNull(product);
            o(product);
        }
    }

    private final void t(dj4.a product) {
        bj4.a aVar;
        Bundle bundle = new Bundle();
        bundle.putString("KEY_URL", product.getJumpUrl());
        cj4.c.f31003a.c("ACTION_JUMP_WITH_SCHEME", bundle, null);
        bj4.a aVar2 = this.vm;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            aVar = null;
        } else {
            aVar = aVar2;
        }
        a.C0130a.a(aVar, 3, product, 0L, 4, null);
    }

    private final void u() {
        c(null);
    }

    private final void v(boolean isAlphaHideType) {
        int i3;
        if (isAlphaHideType) {
            i3 = 3;
        } else {
            i3 = 2;
        }
        B(this.cardContainerRoot, i3);
    }

    private final void w() {
        if (!J.get()) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.ecommerce.card.view.b
                @Override // java.lang.Runnable
                public final void run() {
                    ECommerceCardView.x(ECommerceCardView.this);
                }
            }, 16, null, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(final ECommerceCardView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RFWTypefaceUtil.preloadTypeface("https://dlied5.qq.com/now/qq-live/fonts/EurostileNextPro-Bold.ttf");
        ((IECHRAccessHelper) QRoute.api(IECHRAccessHelper.class)).ensureNVViewMVPEnvironment();
        J.set(true);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.ecommerce.card.view.e
            @Override // java.lang.Runnable
            public final void run() {
                ECommerceCardView.y(ECommerceCardView.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(ECommerceCardView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.s();
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.ecommerce.card.view.g
    public void a(int i3, @NotNull String str) {
        g.a.h(this, i3, str);
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.ecommerce.card.view.g
    public void b() {
        g.a.g(this);
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.ecommerce.card.view.g
    public void c(@Nullable dj4.a product) {
        b bVar;
        if (Intrinsics.areEqual(product, this.explainingProduct)) {
            return;
        }
        dj4.a aVar = null;
        byte b16 = 0;
        int i3 = 2;
        if (product == null) {
            bj4.a aVar2 = this.vm;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vm");
                aVar2 = null;
            }
            dj4.a aVar3 = this.explainingProduct;
            Intrinsics.checkNotNull(aVar3);
            aVar2.A(2, aVar3, System.currentTimeMillis() - this.updateTimeStamp);
        }
        this.updateTimeStamp = System.currentTimeMillis();
        if (product != null) {
            bVar = new b(1, product);
        } else {
            bVar = new b(i3, aVar, i3, b16 == true ? 1 : 0);
        }
        this.waitingExecuteTask = bVar;
        this.explainingProduct = product;
        s();
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.ecommerce.card.view.g
    public void onActivityCreate() {
        g.a.b(this);
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.ecommerce.card.view.g
    public void onActivityDestroy() {
        g.a.c(this);
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.ecommerce.card.view.g
    public void onActivityResume() {
        g.a.d(this);
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.ecommerce.card.view.g
    public void onActivityStop() {
        g.a.e(this);
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.ecommerce.card.view.g
    public void onEnterRoom() {
        g.a.f(this);
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.ecommerce.card.view.g
    public void setCardViewModel(@NotNull bj4.a vm5) {
        Intrinsics.checkNotNullParameter(vm5, "vm");
        this.vm = vm5;
    }

    public void z() {
        g.a.a(this);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ECommerceCardView(@NotNull Context ctx, @Nullable AttributeSet attributeSet) {
        this(ctx, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    public /* synthetic */ ECommerceCardView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ECommerceCardView(@NotNull Context ctx, @Nullable AttributeSet attributeSet, int i3) {
        super(ctx, attributeSet, i3);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        setClipChildren(false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = x.c(getContext(), 12.0f);
        layoutParams.leftMargin = x.c(getContext(), 0.0f);
        layoutParams.bottomMargin = x.c(getContext(), 4.0f);
        setLayoutParams(layoutParams);
        setVisibility(8);
        LayoutInflater.from(getContext()).inflate(R.layout.h_c, this);
        View findViewById = findViewById(R.id.upb);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.ecommerce_card_container_root)");
        this.cardContainerRoot = (ViewGroup) findViewById;
        View findViewById2 = findViewById(R.id.upa);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.ecommerce_card_container)");
        this.cardContainer = (ViewGroup) findViewById2;
        View findViewById3 = findViewById(R.id.upc);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.ecommerce_card_hide_icon)");
        ViewGroup viewGroup = (ViewGroup) findViewById3;
        this.cardExitIcon = viewGroup;
        viewGroup.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.ecommerce.card.view.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ECommerceCardView.j(ECommerceCardView.this, view);
            }
        });
        w();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/ecommerce/card/view/ECommerceCardView$c", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "p0", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements Animator.AnimatorListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f377590e;

        c(int i3) {
            this.f377590e = i3;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator p06) {
            ECommerceCardView.this.A(this.f377590e);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator p06) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator p06) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator p06) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/ecommerce/card/view/ECommerceCardView$d", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "p0", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class d implements Animator.AnimatorListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f377592e;

        d(int i3) {
            this.f377592e = i3;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator p06) {
            ECommerceCardView.this.isProductShowing = false;
            ECommerceCardView.this.A(this.f377592e);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator p06) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator p06) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator p06) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/ecommerce/card/view/ECommerceCardView$e", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "p0", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class e implements Animator.AnimatorListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f377594e;

        e(int i3) {
            this.f377594e = i3;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator p06) {
            ECommerceCardView.this.isProductShowing = false;
            ECommerceCardView.this.A(this.f377594e);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator p06) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator p06) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator p06) {
        }
    }
}
