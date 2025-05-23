package com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section;

import com.tencent.biz.richframework.adapter.section.SectionIOCKt;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.FeedDetailMainData;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0002J\b\u0010\t\u001a\u0004\u0018\u00010\bJ*\u0010\u000f\u001a\u00020\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\rH\u0014J6\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u00102\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\rH\u0014J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0006H\u0014J4\u0010\u0015\u001a\u00020\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006H$\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/e;", "Lhl1/b;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/FeedDetailMainData;", "", "", "payloads", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/FeedDetailMainData$c$c;", "u", "Lrl1/a;", "p", "data", "", "position", "", "", ReportConstant.COSTREPORT_PREFIX, "Lkotlin/Pair;", "", "r", "payload", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "t", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class e extends hl1.b<FeedDetailMainData> {
    private final FeedDetailMainData.c.C7755c u(List<? extends Object> payloads) {
        boolean z16;
        List<? extends Object> list = payloads;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        for (Object obj : payloads) {
            if (obj instanceof Map) {
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    Object key = entry.getKey();
                    Object value = entry.getValue();
                    if ((key instanceof Class) && ((Class) key).isAssignableFrom(FeedDetailMainData.c.C7755c.class) && (value instanceof FeedDetailMainData.c.C7755c)) {
                        return (FeedDetailMainData.c.C7755c) value;
                    }
                }
            }
        }
        return null;
    }

    @Nullable
    public final rl1.a p() {
        return (rl1.a) SectionIOCKt.getIocInterface(this, rl1.a.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean q(@NotNull FeedDetailMainData.c.C7755c payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        if (payload.getType() == 0) {
            return true;
        }
        return false;
    }

    @NotNull
    protected Pair<Boolean, Boolean> r(@Nullable FeedDetailMainData data, int position, @Nullable List<Object> payloads) {
        boolean z16;
        List<Object> list = payloads;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return TuplesKt.to(Boolean.TRUE, Boolean.FALSE);
        }
        for (Object obj : payloads) {
            Boolean bool = Boolean.TRUE;
            if (Intrinsics.areEqual(obj, bool)) {
                return TuplesKt.to(bool, Boolean.FALSE);
            }
            if (FeedDetailMainData.c.INSTANCE.a(obj)) {
                return TuplesKt.to(Boolean.FALSE, bool);
            }
        }
        Boolean bool2 = Boolean.FALSE;
        return TuplesKt.to(bool2, bool2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable FeedDetailMainData data, int position, @Nullable List<Object> payloads) {
        Pair<Boolean, Boolean> r16 = r(data, position, payloads);
        if (r16.getFirst().booleanValue()) {
            t(data, position, payloads, null);
            return;
        }
        if (r16.getSecond().booleanValue()) {
            FeedDetailMainData.c.C7755c u16 = u(payloads);
            if (u16 == null || q(u16)) {
                t(data, position, payloads, u16);
            }
        }
    }

    protected abstract void t(@Nullable FeedDetailMainData data, int position, @Nullable List<Object> payloads, @Nullable FeedDetailMainData.c.C7755c payload);
}
