package com.tencent.mobileqq.matchfriend.aio.quote;

import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.tools.config.ITVKConfigRequester;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\tB\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\fR \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/aio/quote/b;", "", "", "chatType", "", "c", "", "d", "Lcom/tencent/mobileqq/utils/abtest/ExpEntityInfo;", "a", "b", "", "Ljava/util/List;", "chatTypeList", "", "Lcom/tencent/mobileqq/matchfriend/aio/quote/b$a;", "Ljava/util/Map;", "expConfigMap", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f243941a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final List<Integer> chatTypeList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final Map<Integer, QuoteExpConfig> expConfigMap;

    static {
        List<Integer> listOf;
        Map<Integer, QuoteExpConfig> emptyMap;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(104);
        chatTypeList = listOf;
        emptyMap = MapsKt__MapsKt.emptyMap();
        expConfigMap = emptyMap;
    }

    b() {
    }

    private final ExpEntityInfo a(int chatType) {
        QuoteExpConfig quoteExpConfig = expConfigMap.get(Integer.valueOf(chatType));
        if (quoteExpConfig == null) {
            return null;
        }
        return ABTestController.getInstance().getExpEntity(quoteExpConfig.getExpName());
    }

    private final boolean c(int chatType) {
        ExpEntityInfo a16;
        QuoteExpConfig quoteExpConfig = expConfigMap.get(Integer.valueOf(chatType));
        if (quoteExpConfig == null || (a16 = a(chatType)) == null) {
            return true;
        }
        return a16.isExperiment(quoteExpConfig.getAssignmentB());
    }

    @JvmStatic
    public static final void d(int chatType) {
        ExpEntityInfo a16 = f243941a.a(chatType);
        if (a16 == null) {
            return;
        }
        a16.reportExpExposure();
        QLog.d("QQStrangerQuoteConfig", 1, "reportExpExposure chatType=" + chatType + " assignment=" + a16.getAssignment());
    }

    public final boolean b(int chatType) {
        if (chatTypeList.contains(Integer.valueOf(chatType))) {
            return c(chatType);
        }
        return false;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/aio/quote/b$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", ITVKConfigRequester.ConfigRequestListener.EXTRA_KEY_EXP_NAME, "getAssignmentA", "assignmentA", "c", "assignmentB", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.matchfriend.aio.quote.b$a, reason: from toString */
    /* loaded from: classes33.dex */
    public static final /* data */ class QuoteExpConfig {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final String expName;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final String assignmentA;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final String assignmentB;

        /* renamed from: a, reason: from getter */
        public final String getAssignmentB() {
            return this.assignmentB;
        }

        /* renamed from: b, reason: from getter */
        public final String getExpName() {
            return this.expName;
        }

        public int hashCode() {
            return (((this.expName.hashCode() * 31) + this.assignmentA.hashCode()) * 31) + this.assignmentB.hashCode();
        }

        public String toString() {
            return "QuoteExpConfig(expName=" + this.expName + ", assignmentA=" + this.assignmentA + ", assignmentB=" + this.assignmentB + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof QuoteExpConfig)) {
                return false;
            }
            QuoteExpConfig quoteExpConfig = (QuoteExpConfig) other;
            return Intrinsics.areEqual(this.expName, quoteExpConfig.expName) && Intrinsics.areEqual(this.assignmentA, quoteExpConfig.assignmentA) && Intrinsics.areEqual(this.assignmentB, quoteExpConfig.assignmentB);
        }
    }
}
