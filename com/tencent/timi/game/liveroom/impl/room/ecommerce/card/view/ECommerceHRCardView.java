package com.tencent.timi.game.liveroom.impl.room.ecommerce.card.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.Size;
import android.util.TypedValue;
import android.widget.FrameLayout;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.qqecommerce.biz.sdk.api.IQQECommerceSdk;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.liveroom.impl.room.ecommerce.card.event.HideCardSimpleEvent;
import com.tencent.timi.game.liveroom.impl.room.ecommerce.card.event.ShowCardSimpleEvent;
import com.tencent.timi.game.liveroom.impl.room.ecommerce.card.view.g;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001\u001bB'\b\u0007\u0012\u0006\u0010+\u001a\u00020*\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010,\u0012\b\b\u0002\u0010.\u001a\u00020\u0003\u00a2\u0006\u0004\b/\u00100J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\u0014\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\f\u0010\u000e\u001a\u00020\u0003*\u00020\rH\u0002J\u0018\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u0007H\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0016J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0018\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u001c\u001a\u00020\u0007H\u0016J\b\u0010\u001d\u001a\u00020\u0007H\u0016J\b\u0010\u001e\u001a\u00020\u0007H\u0016J\b\u0010\u001f\u001a\u00020\u0007H\u0016R\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010$R\u0016\u0010&\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010%R\u0014\u0010)\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010(\u00a8\u00061"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/ecommerce/card/view/ECommerceHRCardView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/timi/game/liveroom/impl/room/ecommerce/card/view/g;", "", "type", "", "pushMsg", "", "k", "f", "", "", "e", "", "l", AdMetricTag.EVENT_NAME, "Lorg/json/JSONObject;", "data", "j", "g", "", h.F, "onEnterRoom", "b", "Lbj4/a;", "vm", "setCardViewModel", "a", "onActivityResume", "onActivityStop", "onActivityDestroy", "i", "Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/e;", "d", "Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/e;", "ecHRViewModel", "Lbj4/a;", "Z", "hadEnterRoom", "Landroid/util/Size;", "Landroid/util/Size;", "viewSize", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attr", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class ECommerceHRCardView extends FrameLayout implements g {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qqecommerce.biz.hr.api.e ecHRViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private bj4.a vm;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean hadEnterRoom;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Size viewSize;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ECommerceHRCardView(@NotNull Context ctx) {
        this(ctx, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    private final Map<String, Object> e() {
        Map<String, Object> mapOf;
        Map<String, Object> emptyMap;
        bj4.a aVar = this.vm;
        if (aVar == null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            return emptyMap;
        }
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("roomID", Long.valueOf(aVar.getRoomId())), TuplesKt.to("bus_id", 8), TuplesKt.to("viewer_uin", Long.valueOf(com.tencent.mobileqq.qqlive.sail.c.f272176a.G())), TuplesKt.to("author_uin", Long.valueOf(aVar.g1())), TuplesKt.to("program_id", aVar.getProgramId()), TuplesKt.to("live_type", Integer.valueOf(aVar.getRoomType())), TuplesKt.to("qz_gdt", aVar.e0()));
        return mapOf;
    }

    private final void f() {
        com.tencent.mobileqq.qqecommerce.biz.hr.api.e eVar = this.ecHRViewModel;
        if (eVar != null) {
            eVar.onDestroy();
        }
        this.ecHRViewModel = null;
    }

    private final void g(JSONObject data) {
        int optInt = data.optInt("type", -1);
        if (optInt != 0) {
            if (optInt == 1) {
                setVisibility(0);
                SimpleEventBus.getInstance().dispatchEvent(new ShowCardSimpleEvent());
                return;
            }
            return;
        }
        setVisibility(8);
        i();
    }

    private final boolean h() {
        bj4.a aVar = this.vm;
        if (aVar != null) {
            return aVar.g();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(String eventName, JSONObject data) {
        bj4.a aVar = this.vm;
        boolean z16 = false;
        if (aVar != null && data.optLong("roomID") == aVar.getRoomId()) {
            z16 = true;
        }
        if (z16 && Intrinsics.areEqual(eventName, "LiveExplainViewEventNotification")) {
            g(data);
        }
    }

    private final void k(int type, String pushMsg) {
        Map<String, ? extends Object> mapOf;
        com.tencent.mobileqq.qqecommerce.biz.hr.api.e eVar = this.ecHRViewModel;
        if (eVar != null) {
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("pushType", Integer.valueOf(type)), TuplesKt.to("msgDataStr", pushMsg));
            eVar.sendEvent("pushMessage", mapOf);
        }
    }

    private final int l(float f16) {
        return (int) (TypedValue.applyDimension(1, f16, Resources.getSystem().getDisplayMetrics()) + 0.5f);
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.ecommerce.card.view.g
    public void a(int type, @NotNull String pushMsg) {
        Intrinsics.checkNotNullParameter(pushMsg, "pushMsg");
        g.a.h(this, type, pushMsg);
        if (!h()) {
            return;
        }
        k(type, pushMsg);
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.ecommerce.card.view.g
    public void b() {
        Map<String, ? extends Object> emptyMap;
        g.a.g(this);
        if (!h()) {
            return;
        }
        int i3 = 0;
        this.hadEnterRoom = false;
        com.tencent.mobileqq.qqecommerce.biz.hr.api.e eVar = this.ecHRViewModel;
        if (eVar != null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            eVar.sendEvent("didExitRoom", emptyMap);
        }
        f();
        i();
        setVisibility(8);
        int hashCode = hashCode();
        com.tencent.mobileqq.qqecommerce.biz.hr.api.e eVar2 = this.ecHRViewModel;
        if (eVar2 != null) {
            i3 = eVar2.hashCode();
        }
        QLog.i("ECommerceHRCardView", 1, "onExitRoom: hashCode: " + hashCode + ", hrViewModel hashCode: " + i3);
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.ecommerce.card.view.g
    public void c(@Nullable dj4.a aVar) {
        g.a.i(this, aVar);
    }

    public void i() {
        if (h()) {
            SimpleEventBus.getInstance().dispatchEvent(new HideCardSimpleEvent());
        }
        g.a.a(this);
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.ecommerce.card.view.g
    public void onActivityCreate() {
        g.a.b(this);
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.ecommerce.card.view.g
    public void onActivityDestroy() {
        g.a.c(this);
        if (!h()) {
            return;
        }
        f();
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.ecommerce.card.view.g
    public void onActivityResume() {
        com.tencent.mobileqq.qqecommerce.biz.hr.api.e eVar;
        g.a.d(this);
        if (h() && (eVar = this.ecHRViewModel) != null) {
            eVar.onResume();
        }
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.ecommerce.card.view.g
    public void onActivityStop() {
        com.tencent.mobileqq.qqecommerce.biz.hr.api.e eVar;
        g.a.e(this);
        if (h() && (eVar = this.ecHRViewModel) != null) {
            eVar.onStop();
        }
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.ecommerce.card.view.g
    public void onEnterRoom() {
        Map<String, ? extends Object> emptyMap;
        int i3;
        g.a.f(this);
        if (this.hadEnterRoom || !h()) {
            return;
        }
        com.tencent.mobileqq.qqecommerce.biz.hr.api.e createHRViewModel = ((IQQECommerceSdk) QRoute.api(IQQECommerceSdk.class)).createHRViewModel("HRBubbleCard");
        createHRViewModel.a(new Function2<String, JSONObject, Unit>() { // from class: com.tencent.timi.game.liveroom.impl.room.ecommerce.card.view.ECommerceHRCardView$onEnterRoom$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(String str, JSONObject jSONObject) {
                invoke2(str, jSONObject);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String eventName, @NotNull JSONObject data) {
                Intrinsics.checkNotNullParameter(eventName, "eventName");
                Intrinsics.checkNotNullParameter(data, "data");
                ECommerceHRCardView.this.j(eventName, data);
            }
        });
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        addView(createHRViewModel.onCreate(context, "live_explain_view", e(), this.viewSize));
        emptyMap = MapsKt__MapsKt.emptyMap();
        createHRViewModel.sendEvent("didEnterRoomAndShown", emptyMap);
        this.ecHRViewModel = createHRViewModel;
        this.hadEnterRoom = true;
        int hashCode = hashCode();
        com.tencent.mobileqq.qqecommerce.biz.hr.api.e eVar = this.ecHRViewModel;
        if (eVar != null) {
            i3 = eVar.hashCode();
        } else {
            i3 = 0;
        }
        QLog.i("ECommerceHRCardView", 1, "onEnterRoom: hashCode: " + hashCode + ", hrViewModel hashCode: " + i3);
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.ecommerce.card.view.g
    public void setCardViewModel(@NotNull bj4.a vm5) {
        Intrinsics.checkNotNullParameter(vm5, "vm");
        this.vm = vm5;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ECommerceHRCardView(@NotNull Context ctx, @Nullable AttributeSet attributeSet) {
        this(ctx, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    public /* synthetic */ ECommerceHRCardView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ECommerceHRCardView(@NotNull Context ctx, @Nullable AttributeSet attributeSet, int i3) {
        super(ctx, attributeSet, i3);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Size size = new Size(l(120.0f), l(245.0f));
        this.viewSize = size;
        setClipChildren(false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(size.getWidth(), size.getHeight());
        layoutParams.rightMargin = x.c(getContext(), 12.0f);
        layoutParams.bottomMargin = x.c(getContext(), 4.0f);
        setLayoutParams(layoutParams);
        setVisibility(8);
    }
}
