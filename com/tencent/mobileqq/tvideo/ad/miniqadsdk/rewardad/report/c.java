package com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.report;

import com.tencent.tvideo.protocol.pb.AdOrderItem;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/report/c;", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/QAdCore/qadreport/playerEvent/a;", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/QAdCore/qadreport/playerEvent/f;", "event", "", "a", "<init>", "()V", "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes19.dex */
public final class c extends com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.playerEvent.a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/report/c$a", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/QAdCore/qadreport/playerEvent/e;", "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes19.dex */
    public static final class a extends com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.playerEvent.e {

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.playerEvent.f f304305h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.playerEvent.f fVar, AdOrderItem adOrderItem) {
            super(adOrderItem);
            this.f304305h = fVar;
            if (this.f304093g == null) {
                this.f304093g = new HashMap();
            }
            Object obj = fVar.f304104e;
            if (obj != null) {
                Map<String, String> it = hw2.f.a((AdOrderItem) obj).a(9);
                Map<String, String> map = this.f304093g;
                if (map != null) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    map.putAll(it);
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.tencent.tvideo.protocol.pb.AdOrderItem");
        }
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.playerEvent.a
    protected void a(@Nullable com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.playerEvent.f event) {
        Object obj;
        if (event != null) {
            obj = event.f304104e;
        } else {
            obj = null;
        }
        if (obj instanceof AdOrderItem) {
            Object obj2 = event.f304104e;
            if (obj2 != null) {
                this.f304096a = new a(event, (AdOrderItem) obj2);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.tencent.tvideo.protocol.pb.AdOrderItem");
        }
    }
}
