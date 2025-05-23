package com.tencent.mobileqq.topicaggregation.bean;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/topicaggregation/bean/TopicAggregationSource;", "", "(Ljava/lang/String;I)V", "DEFAULT", "RECOMMEND_HOT_TOPIC", "FEED_LIST", "FEED_DETAIL", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes10.dex */
public final class TopicAggregationSource {
    private static final /* synthetic */ TopicAggregationSource[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final TopicAggregationSource DEFAULT;
    public static final TopicAggregationSource FEED_DETAIL;
    public static final TopicAggregationSource FEED_LIST;
    public static final TopicAggregationSource RECOMMEND_HOT_TOPIC;

    private static final /* synthetic */ TopicAggregationSource[] $values() {
        return new TopicAggregationSource[]{DEFAULT, RECOMMEND_HOT_TOPIC, FEED_LIST, FEED_DETAIL};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50688);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        DEFAULT = new TopicAggregationSource("DEFAULT", 0);
        RECOMMEND_HOT_TOPIC = new TopicAggregationSource("RECOMMEND_HOT_TOPIC", 1);
        FEED_LIST = new TopicAggregationSource("FEED_LIST", 2);
        FEED_DETAIL = new TopicAggregationSource("FEED_DETAIL", 3);
        $VALUES = $values();
    }

    TopicAggregationSource(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static TopicAggregationSource valueOf(String str) {
        return (TopicAggregationSource) Enum.valueOf(TopicAggregationSource.class, str);
    }

    public static TopicAggregationSource[] values() {
        return (TopicAggregationSource[]) $VALUES.clone();
    }
}
