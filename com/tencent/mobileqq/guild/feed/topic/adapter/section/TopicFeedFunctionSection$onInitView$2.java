package com.tencent.mobileqq.guild.feed.topic.adapter.section;

import android.view.View;
import androidx.core.util.Supplier;
import com.tencent.biz.richframework.adapter.section.SectionIOCKt;
import com.tencent.biz.richframework.part.adapter.section.Section;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import zp1.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
final class TopicFeedFunctionSection$onInitView$2 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ TopicFeedFunctionSection this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicFeedFunctionSection$onInitView$2(TopicFeedFunctionSection topicFeedFunctionSection) {
        super(1);
        this.this$0 = topicFeedFunctionSection;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map c() {
        Map emptyMap;
        emptyMap = MapsKt__MapsKt.emptyMap();
        return emptyMap;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull View it) {
        boolean v3;
        com.tencent.mobileqq.guild.feed.topic.a aVar;
        int i3;
        Object mData;
        Intrinsics.checkNotNullParameter(it, "it");
        v3 = this.this$0.v();
        if (v3 || (aVar = (com.tencent.mobileqq.guild.feed.topic.a) SectionIOCKt.getIocInterface(this.this$0, com.tencent.mobileqq.guild.feed.topic.a.class)) == null) {
            return;
        }
        zp1.a<vn1.b> b16 = aVar.b();
        i3 = ((Section) this.this$0).mPosition;
        mData = ((Section) this.this$0).mData;
        Intrinsics.checkNotNullExpressionValue(mData, "mData");
        a.C11708a.a(b16, i3, mData, new Supplier() { // from class: com.tencent.mobileqq.guild.feed.topic.adapter.section.k
            @Override // androidx.core.util.Supplier
            public final Object get() {
                Map c16;
                c16 = TopicFeedFunctionSection$onInitView$2.c();
                return c16;
            }
        }, 0, 8, null);
        this.this$0.t(it);
    }
}
