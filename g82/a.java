package g82;

import com.tencent.mobileqq.matchfriend.aio.foreground.g;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.base.c;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.repository.QQStrangerSignalConfigResult;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.repository.QQStrangerSignalPublishResult;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t\u00a8\u0006\n"}, d2 = {"Lg82/a;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/base/c;", "<init>", "()V", "a", "b", "c", "Lg82/a$a;", "Lg82/a$b;", "Lg82/a$c;", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public abstract class a extends c {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\n\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0010\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\f\u001a\u0004\b\u000b\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lg82/a$a;", "Lg82/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "a", "J", "b", "()J", "partnerId", "partnerAdjId", "<init>", "(JJ)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: g82.a$a, reason: collision with other inner class name and from toString */
    /* loaded from: classes38.dex */
    public static final /* data */ class QQStrangerUpdateLastPublishSignalInfoState extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final long partnerId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final long partnerAdjId;

        /* renamed from: a, reason: from getter */
        public final long getPartnerAdjId() {
            return this.partnerAdjId;
        }

        /* renamed from: b, reason: from getter */
        public final long getPartnerId() {
            return this.partnerId;
        }

        public int hashCode() {
            return (g.a(this.partnerId) * 31) + g.a(this.partnerAdjId);
        }

        public String toString() {
            return "QQStrangerUpdateLastPublishSignalInfoState(partnerId=" + this.partnerId + ", partnerAdjId=" + this.partnerAdjId + ")";
        }

        public QQStrangerUpdateLastPublishSignalInfoState(long j3, long j16) {
            super(null);
            this.partnerId = j3;
            this.partnerAdjId = j16;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof QQStrangerUpdateLastPublishSignalInfoState)) {
                return false;
            }
            QQStrangerUpdateLastPublishSignalInfoState qQStrangerUpdateLastPublishSignalInfoState = (QQStrangerUpdateLastPublishSignalInfoState) other;
            return this.partnerId == qQStrangerUpdateLastPublishSignalInfoState.partnerId && this.partnerAdjId == qQStrangerUpdateLastPublishSignalInfoState.partnerAdjId;
        }
    }

    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    a() {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lg82/a$b;", "Lg82/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/publish/repository/b;", "a", "Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/publish/repository/b;", "()Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/publish/repository/b;", "result", "<init>", "(Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/publish/repository/b;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: g82.a$b, reason: from toString */
    /* loaded from: classes38.dex */
    public static final /* data */ class QQStrangerUpdatePublishState extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final QQStrangerSignalPublishResult result;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public QQStrangerUpdatePublishState(QQStrangerSignalPublishResult result) {
            super(null);
            Intrinsics.checkNotNullParameter(result, "result");
            this.result = result;
        }

        /* renamed from: a, reason: from getter */
        public final QQStrangerSignalPublishResult getResult() {
            return this.result;
        }

        public int hashCode() {
            return this.result.hashCode();
        }

        public String toString() {
            return "QQStrangerUpdatePublishState(result=" + this.result + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof QQStrangerUpdatePublishState) && Intrinsics.areEqual(this.result, ((QQStrangerUpdatePublishState) other).result);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lg82/a$c;", "Lg82/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/publish/repository/a;", "a", "Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/publish/repository/a;", "()Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/publish/repository/a;", "result", "<init>", "(Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/publish/repository/a;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: g82.a$c, reason: from toString */
    /* loaded from: classes38.dex */
    public static final /* data */ class QQStrangerUpdateSignalConfigsState extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final QQStrangerSignalConfigResult result;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public QQStrangerUpdateSignalConfigsState(QQStrangerSignalConfigResult result) {
            super(null);
            Intrinsics.checkNotNullParameter(result, "result");
            this.result = result;
        }

        /* renamed from: a, reason: from getter */
        public final QQStrangerSignalConfigResult getResult() {
            return this.result;
        }

        public int hashCode() {
            return this.result.hashCode();
        }

        public String toString() {
            return "QQStrangerUpdateSignalConfigsState(result=" + this.result + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof QQStrangerUpdateSignalConfigsState) && Intrinsics.areEqual(this.result, ((QQStrangerUpdateSignalConfigsState) other).result);
        }
    }
}
