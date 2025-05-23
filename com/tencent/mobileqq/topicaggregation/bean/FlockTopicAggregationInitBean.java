package com.tencent.mobileqq.topicaggregation.bean;

import com.tencent.mobileqq.flock.base.FlockInitBean;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/topicaggregation/bean/FlockTopicAggregationInitBean;", "Lcom/tencent/mobileqq/flock/base/FlockInitBean;", "tagId", "", "sourceType", "Lcom/tencent/mobileqq/topicaggregation/bean/TopicAggregationSource;", "(ILcom/tencent/mobileqq/topicaggregation/bean/TopicAggregationSource;)V", "getSourceType", "()Lcom/tencent/mobileqq/topicaggregation/bean/TopicAggregationSource;", "getTagId", "()I", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes10.dex */
public final class FlockTopicAggregationInitBean extends FlockInitBean {
    static IPatchRedirector $redirector_;

    @NotNull
    private final TopicAggregationSource sourceType;
    private final int tagId;

    public /* synthetic */ FlockTopicAggregationInitBean(int i3, TopicAggregationSource topicAggregationSource, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i16 & 2) != 0 ? TopicAggregationSource.DEFAULT : topicAggregationSource);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), topicAggregationSource, Integer.valueOf(i16), defaultConstructorMarker);
    }

    @NotNull
    public final TopicAggregationSource getSourceType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (TopicAggregationSource) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.sourceType;
    }

    public final int getTagId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.tagId;
    }

    public FlockTopicAggregationInitBean(int i3, @NotNull TopicAggregationSource sourceType) {
        Intrinsics.checkNotNullParameter(sourceType, "sourceType");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) sourceType);
        } else {
            this.tagId = i3;
            this.sourceType = sourceType;
        }
    }
}
