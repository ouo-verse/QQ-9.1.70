package k82;

import com.tencent.mobileqq.matchfriend.reborn.content.signal.base.c;
import com.tencent.trpcprotocol.kuolie.signal_plaza_svr.signal_plaza_svr.SignalPlazaSvrPB$SignalInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007\u00a8\u0006\b"}, d2 = {"Lk82/a;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/base/c;", "<init>", "()V", "a", "b", "Lk82/a$a;", "Lk82/a$b;", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public abstract class a extends c {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lk82/a$a;", "Lk82/a;", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: k82.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static final class C10641a extends a {

        /* renamed from: a, reason: collision with root package name */
        public static final C10641a f411899a = new C10641a();

        C10641a() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u0012\u001a\u00020\b\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0012\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0010\u001a\u0004\b\u000b\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lk82/a$b;", "Lk82/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/trpcprotocol/kuolie/signal_plaza_svr/signal_plaza_svr/SignalPlazaSvrPB$SignalInfo;", "a", "Lcom/tencent/trpcprotocol/kuolie/signal_plaza_svr/signal_plaza_svr/SignalPlazaSvrPB$SignalInfo;", "b", "()Lcom/tencent/trpcprotocol/kuolie/signal_plaza_svr/signal_plaza_svr/SignalPlazaSvrPB$SignalInfo;", "signalInfo", "Z", "()Z", "justNowPublish", "<init>", "(Lcom/tencent/trpcprotocol/kuolie/signal_plaza_svr/signal_plaza_svr/SignalPlazaSvrPB$SignalInfo;Z)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: k82.a$b, reason: from toString */
    /* loaded from: classes38.dex */
    public static final /* data */ class QQStrangerUpdateSelfSignalInfoState extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final SignalPlazaSvrPB$SignalInfo signalInfo;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean justNowPublish;

        /* renamed from: a, reason: from getter */
        public final boolean getJustNowPublish() {
            return this.justNowPublish;
        }

        /* renamed from: b, reason: from getter */
        public final SignalPlazaSvrPB$SignalInfo getSignalInfo() {
            return this.signalInfo;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            SignalPlazaSvrPB$SignalInfo signalPlazaSvrPB$SignalInfo = this.signalInfo;
            int hashCode = (signalPlazaSvrPB$SignalInfo == null ? 0 : signalPlazaSvrPB$SignalInfo.hashCode()) * 31;
            boolean z16 = this.justNowPublish;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return hashCode + i3;
        }

        public String toString() {
            return "QQStrangerUpdateSelfSignalInfoState(signalInfo=" + this.signalInfo + ", justNowPublish=" + this.justNowPublish + ")";
        }

        public QQStrangerUpdateSelfSignalInfoState(SignalPlazaSvrPB$SignalInfo signalPlazaSvrPB$SignalInfo, boolean z16) {
            super(null);
            this.signalInfo = signalPlazaSvrPB$SignalInfo;
            this.justNowPublish = z16;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof QQStrangerUpdateSelfSignalInfoState)) {
                return false;
            }
            QQStrangerUpdateSelfSignalInfoState qQStrangerUpdateSelfSignalInfoState = (QQStrangerUpdateSelfSignalInfoState) other;
            return Intrinsics.areEqual(this.signalInfo, qQStrangerUpdateSelfSignalInfoState.signalInfo) && this.justNowPublish == qQStrangerUpdateSelfSignalInfoState.justNowPublish;
        }
    }

    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    a() {
    }
}
