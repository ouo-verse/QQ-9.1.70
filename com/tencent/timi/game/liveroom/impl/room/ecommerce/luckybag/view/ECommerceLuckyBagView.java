package com.tencent.timi.game.liveroom.impl.room.ecommerce.luckybag.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.qqecommerce.biz.hr.api.e;
import com.tencent.mobileqq.qqecommerce.biz.sdk.api.IQQECommerceSdk;
import com.tencent.mobileqq.qqlive.sail.c;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import fh4.b;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u0001:\u0001\u0010B'\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001b\u001a\u00020\b\u00a2\u0006\u0004\b\u001c\u0010\u001dJ0\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\bJ\u0006\u0010\r\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u000bJ\u0006\u0010\u000f\u001a\u00020\u000bJ\u0006\u0010\u0010\u001a\u00020\u000bJ\u0016\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0006R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0015\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/ecommerce/luckybag/view/ECommerceLuckyBagView;", "Landroid/widget/FrameLayout;", "", "roomId", "", "isMaster", "", "liveProgramId", "", "liveRoomType", "autoOpen", "", "b", "c", "e", "f", "a", "type", "pushMsg", "d", "Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/e;", "Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/e;", "ecHRViewModel", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attr", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class ECommerceLuckyBagView extends FrameLayout {

    /* renamed from: f, reason: collision with root package name */
    private static final int f377614f = ViewUtils.getScreenWidth() / 2;

    /* renamed from: h, reason: collision with root package name */
    private static final int f377615h = b.b(300);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private e ecHRViewModel;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ECommerceLuckyBagView(@NotNull Context ctx) {
        this(ctx, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    public final void a() {
        Map<String, ? extends Object> emptyMap;
        if (QLog.isColorLevel()) {
            QLog.i("ECommerceLuckyBagView", 2, "notifyChangedEvent");
        }
        e eVar = this.ecHRViewModel;
        if (eVar != null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            eVar.sendEvent("onPendantChanged", emptyMap);
        }
    }

    public final void b(long roomId, boolean isMaster, @NotNull String liveProgramId, int liveRoomType, int autoOpen) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(liveProgramId, "liveProgramId");
        if (QLog.isColorLevel()) {
            QLog.i("ECommerceLuckyBagView", 2, "onCreate, roomId=" + roomId + ", isMaster=" + isMaster + ", liveProgramId=" + liveProgramId + ", liveRoomType=" + liveRoomType + ", autoOpen=" + autoOpen);
        }
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(AudienceReportConst.ROOM_ID, Long.valueOf(roomId)), TuplesKt.to("is_master", Integer.valueOf(isMaster ? 1 : 0)), TuplesKt.to("live_user_id", Long.valueOf(c.f272176a.G())), TuplesKt.to("enter_room_time", Long.valueOf(System.currentTimeMillis())), TuplesKt.to("live_program_id", liveProgramId), TuplesKt.to("live_type", Integer.valueOf(liveRoomType)), TuplesKt.to("auto_open_luckybag", Integer.valueOf(autoOpen)));
        e createHRViewModel = ((IQQECommerceSdk) QRoute.api(IQQECommerceSdk.class)).createHRViewModel("HRLuckyBag");
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        View a16 = e.a.a(createHRViewModel, context, "qlive_common_pendant", mapOf, null, 8, null);
        a16.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(a16);
        this.ecHRViewModel = createHRViewModel;
    }

    public final void c() {
        if (QLog.isColorLevel()) {
            QLog.i("ECommerceLuckyBagView", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        e eVar = this.ecHRViewModel;
        if (eVar != null) {
            eVar.onDestroy();
        }
        this.ecHRViewModel = null;
    }

    public final void d(int type, @NotNull String pushMsg) {
        e eVar;
        Map<String, ? extends Object> mapOf;
        Intrinsics.checkNotNullParameter(pushMsg, "pushMsg");
        if (type == 10 && (eVar = this.ecHRViewModel) != null) {
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("isCoupon", 1));
            eVar.sendEvent("onPendantChanged", mapOf);
        }
    }

    public final void e() {
        if (QLog.isColorLevel()) {
            QLog.i("ECommerceLuckyBagView", 2, "onResume");
        }
        e eVar = this.ecHRViewModel;
        if (eVar != null) {
            eVar.onResume();
        }
    }

    public final void f() {
        if (QLog.isColorLevel()) {
            QLog.i("ECommerceLuckyBagView", 2, DKHippyEvent.EVENT_STOP);
        }
        e eVar = this.ecHRViewModel;
        if (eVar != null) {
            eVar.onStop();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ECommerceLuckyBagView(@NotNull Context ctx, @Nullable AttributeSet attributeSet) {
        this(ctx, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    public /* synthetic */ ECommerceLuckyBagView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ECommerceLuckyBagView(@NotNull Context ctx, @Nullable AttributeSet attributeSet, int i3) {
        super(ctx, attributeSet, i3);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        setLayoutParams(new FrameLayout.LayoutParams(f377614f, f377615h));
    }
}
