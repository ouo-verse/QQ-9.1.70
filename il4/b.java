package il4;

import af4.BatteryOperationData;
import af4.OperationData;
import af4.OperationItem;
import af4.RedPocketOperationData;
import com.tencent.timi.game.ad.ui.d;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.PendantOuterClass$PendantMsg;
import trpc.yes.common.PendantOuterClass$PendantMsgPower;
import trpc.yes.common.PendantOuterClass$PendantMsgRedpacket;
import vn4.TimiPicInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0011"}, d2 = {"Lil4/b;", "", "Ltrpc/yes/common/PendantOuterClass$PendantMsg;", "msg", "Laf4/c;", "e", "b", "d", "", "type", "Laf4/d;", "a", "c", "", "f", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f407937a = new b();

    b() {
    }

    private final OperationItem a(int type, PendantOuterClass$PendantMsg msg2) {
        OperationItem operationItem = new OperationItem(0, 0L, 0, null, null, null, null, null, 0, 0, false, null, null, 0, null, 0L, 0L, 0L, 0, 0L, null, null, 4194303, null);
        operationItem.L(type);
        String str = msg2.pic.url.get();
        Intrinsics.checkNotNullExpressionValue(str, "msg.pic.url.get()");
        TimiPicInfo.Companion companion = TimiPicInfo.INSTANCE;
        String str2 = msg2.pic.type.get();
        Intrinsics.checkNotNullExpressionValue(str2, "msg.pic.type.get()");
        operationItem.M(new TimiPicInfo(str, companion.a(str2)));
        operationItem.J(String.valueOf(msg2.jump_type.get()));
        String str3 = msg2.jump_value.get();
        Intrinsics.checkNotNullExpressionValue(str3, "msg.jump_value.get()");
        operationItem.K(str3);
        operationItem.U(String.valueOf(msg2.view.get()));
        OperationItem.Companion companion2 = OperationItem.INSTANCE;
        operationItem.R(companion2.b(msg2.begin_time.get()));
        operationItem.H(companion2.b(msg2.end_time.get()));
        operationItem.G(companion2.b(msg2.countdown_time.get()));
        operationItem.F(msg2.current_time.get());
        return operationItem;
    }

    private final OperationData b(PendantOuterClass$PendantMsg msg2) {
        PendantOuterClass$PendantMsgPower pendantOuterClass$PendantMsgPower = msg2.content.power;
        OperationItem a16 = a(3, msg2);
        a16.C(new BatteryOperationData(pendantOuterClass$PendantMsgPower.recent_task_watch_time.get(), pendantOuterClass$PendantMsgPower.prepare_recv_task_total.get(), pendantOuterClass$PendantMsgPower.day_task_status.get()));
        int i3 = msg2.ad_id.get();
        ArrayList arrayList = new ArrayList();
        arrayList.add(a16);
        Unit unit = Unit.INSTANCE;
        return new OperationData(i3, arrayList);
    }

    private final OperationData d(PendantOuterClass$PendantMsg msg2) {
        PendantOuterClass$PendantMsgRedpacket pendantOuterClass$PendantMsgRedpacket = msg2.content.redpacket;
        OperationItem a16 = a(2, msg2);
        String str = pendantOuterClass$PendantMsgRedpacket.activity_id.get();
        Intrinsics.checkNotNullExpressionValue(str, "redPocketData.activity_id.get()");
        int i3 = pendantOuterClass$PendantMsgRedpacket.status.get();
        String str2 = pendantOuterClass$PendantMsgRedpacket.init_pic.url.get();
        Intrinsics.checkNotNullExpressionValue(str2, "redPocketData.init_pic.url.get()");
        TimiPicInfo.Companion companion = TimiPicInfo.INSTANCE;
        String str3 = pendantOuterClass$PendantMsgRedpacket.init_pic.type.get();
        Intrinsics.checkNotNullExpressionValue(str3, "redPocketData.init_pic.type.get()");
        TimiPicInfo timiPicInfo = new TimiPicInfo(str2, companion.a(str3));
        String str4 = pendantOuterClass$PendantMsgRedpacket.active_pic.url.get();
        Intrinsics.checkNotNullExpressionValue(str4, "redPocketData.active_pic.url.get()");
        String str5 = pendantOuterClass$PendantMsgRedpacket.active_pic.type.get();
        Intrinsics.checkNotNullExpressionValue(str5, "redPocketData.active_pic.type.get()");
        TimiPicInfo timiPicInfo2 = new TimiPicInfo(str4, companion.a(str5));
        String str6 = pendantOuterClass$PendantMsgRedpacket.anchor_hint_text.get();
        Intrinsics.checkNotNullExpressionValue(str6, "redPocketData.anchor_hint_text.get()");
        String str7 = pendantOuterClass$PendantMsgRedpacket.audience_hint_text.get();
        Intrinsics.checkNotNullExpressionValue(str7, "redPocketData.audience_hint_text.get()");
        a16.S(new RedPocketOperationData(str, i3, timiPicInfo, timiPicInfo2, str6, str7, pendantOuterClass$PendantMsgRedpacket.progress_full_time.get()));
        int i16 = msg2.ad_id.get();
        ArrayList arrayList = new ArrayList();
        arrayList.add(a16);
        Unit unit = Unit.INSTANCE;
        return new OperationData(i16, arrayList);
    }

    private final OperationData e(PendantOuterClass$PendantMsg msg2) {
        int i3 = msg2.ad_id.get();
        ArrayList arrayList = new ArrayList();
        arrayList.add(f407937a.a(4, msg2));
        Unit unit = Unit.INSTANCE;
        return new OperationData(i3, arrayList);
    }

    @NotNull
    public final OperationData c(@NotNull PendantOuterClass$PendantMsg msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        int i3 = msg2.type.get();
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return new OperationData(0, null, 3, null);
                }
                return b(msg2);
            }
            return e(msg2);
        }
        return d(msg2);
    }

    public final void f(@NotNull PendantOuterClass$PendantMsg msg2) {
        Object firstOrNull;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) c(msg2).i());
        OperationItem operationItem = (OperationItem) firstOrNull;
        if (operationItem == null) {
            return;
        }
        d.f376246a.b(operationItem);
    }
}
