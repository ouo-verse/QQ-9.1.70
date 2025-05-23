package com.tencent.mobileqq.guild.feed.event.bus;

import com.tencent.ams.dynamicwidget.report.LinkReportConstant$GlobalKey;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a8\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006*\u00020\u00002&\u0010\u0005\u001a\"\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00020\u0001j\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002`\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/biz/richframework/eventbus/SimpleEventBus;", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lkotlin/collections/ArrayList;", LinkReportConstant$GlobalKey.EVENTS, "Lkotlinx/coroutines/flow/Flow;", "a", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class SimpleEventBusExtKt {
    @NotNull
    public static final Flow<SimpleBaseEvent> a(@NotNull SimpleEventBus simpleEventBus, @NotNull ArrayList<Class<? extends SimpleBaseEvent>> events) {
        Intrinsics.checkNotNullParameter(simpleEventBus, "<this>");
        Intrinsics.checkNotNullParameter(events, "events");
        return FlowKt.callbackFlow(new SimpleEventBusExtKt$eventsFlow$1(simpleEventBus, events, null));
    }
}
