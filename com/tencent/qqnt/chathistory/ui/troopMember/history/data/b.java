package com.tencent.qqnt.chathistory.ui.troopMember.history.data;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/troopMember/history/data/b;", "Lcom/tencent/qqnt/base/mvi/b;", "<init>", "()V", "a", "b", "c", "d", "Lcom/tencent/qqnt/chathistory/ui/troopMember/history/data/b$a;", "Lcom/tencent/qqnt/chathistory/ui/troopMember/history/data/b$b;", "Lcom/tencent/qqnt/chathistory/ui/troopMember/history/data/b$c;", "Lcom/tencent/qqnt/chathistory/ui/troopMember/history/data/b$d;", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public abstract class b implements com.tencent.qqnt.base.mvi.b {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/troopMember/history/data/b$a;", "Lcom/tencent/qqnt/chathistory/ui/troopMember/history/data/b;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "a", "Ljava/util/List;", "()Ljava/util/List;", "senderUids", "<init>", "(Ljava/util/List;)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final /* data */ class a extends b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<String> senderUids;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull List<String> senderUids) {
            super(null);
            Intrinsics.checkNotNullParameter(senderUids, "senderUids");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) senderUids);
            } else {
                this.senderUids = senderUids;
            }
        }

        @NotNull
        public final List<String> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (List) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.senderUids;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if ((other instanceof a) && Intrinsics.areEqual(this.senderUids, ((a) other).senderUids)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.senderUids.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return "GetMemberFirstPageIntent(senderUids=" + this.senderUids + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000b\u0010\u0013R\u0017\u0010\u0016\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0015\u0010\u0013R\u0017\u0010\u0017\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/troopMember/history/data/b$b;", "Lcom/tencent/qqnt/chathistory/ui/troopMember/history/data/b;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "a", "Ljava/util/List;", "d", "()Ljava/util/List;", "senderUids", "", "b", "J", "()J", "lastMsgId", "c", "lastMsgTime", "lastMsgSeq", "<init>", "(Ljava/util/List;JJJ)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chathistory.ui.troopMember.history.data.b$b, reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public static final /* data */ class C9558b extends b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<String> senderUids;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final long lastMsgId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final long lastMsgTime;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final long lastMsgSeq;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C9558b(@NotNull List<String> senderUids, long j3, long j16, long j17) {
            super(null);
            Intrinsics.checkNotNullParameter(senderUids, "senderUids");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, senderUids, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17));
                return;
            }
            this.senderUids = senderUids;
            this.lastMsgId = j3;
            this.lastMsgTime = j16;
            this.lastMsgSeq = j17;
        }

        public final long a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
            }
            return this.lastMsgId;
        }

        public final long b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
            }
            return this.lastMsgSeq;
        }

        public final long c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
            }
            return this.lastMsgTime;
        }

        @NotNull
        public final List<String> d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (List) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.senderUids;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof C9558b)) {
                return false;
            }
            C9558b c9558b = (C9558b) other;
            if (Intrinsics.areEqual(this.senderUids, c9558b.senderUids) && this.lastMsgId == c9558b.lastMsgId && this.lastMsgTime == c9558b.lastMsgTime && this.lastMsgSeq == c9558b.lastMsgSeq) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
            }
            return (((((this.senderUids.hashCode() * 31) + androidx.fragment.app.a.a(this.lastMsgId)) * 31) + androidx.fragment.app.a.a(this.lastMsgTime)) * 31) + androidx.fragment.app.a.a(this.lastMsgSeq);
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (String) iPatchRedirector.redirect((short) 12, (Object) this);
            }
            return "GetMoreMemberPageIntent(senderUids=" + this.senderUids + ", lastMsgId=" + this.lastMsgId + ", lastMsgTime=" + this.lastMsgTime + ", lastMsgSeq=" + this.lastMsgSeq + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/troopMember/history/data/b$c;", "Lcom/tencent/qqnt/chathistory/ui/troopMember/history/data/b;", "", "toString", "", "hashCode", "", "other", "", "equals", "Landroid/content/Context;", "a", "Landroid/content/Context;", "()Landroid/content/Context;", "context", "Lcom/tencent/qqnt/chathistory/ui/troopMember/history/data/model/a;", "b", "Lcom/tencent/qqnt/chathistory/ui/troopMember/history/data/model/a;", "()Lcom/tencent/qqnt/chathistory/ui/troopMember/history/data/model/a;", "troopMemberHistoryModel", "<init>", "(Landroid/content/Context;Lcom/tencent/qqnt/chathistory/ui/troopMember/history/data/model/a;)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final /* data */ class c extends b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Context context;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.qqnt.chathistory.ui.troopMember.history.data.model.a troopMemberHistoryModel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull Context context, @NotNull com.tencent.qqnt.chathistory.ui.troopMember.history.data.model.a troopMemberHistoryModel) {
            super(null);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(troopMemberHistoryModel, "troopMemberHistoryModel");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) troopMemberHistoryModel);
            } else {
                this.context = context;
                this.troopMemberHistoryModel = troopMemberHistoryModel;
            }
        }

        @NotNull
        public final Context a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Context) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.context;
        }

        @NotNull
        public final com.tencent.qqnt.chathistory.ui.troopMember.history.data.model.a b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (com.tencent.qqnt.chathistory.ui.troopMember.history.data.model.a) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.troopMemberHistoryModel;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof c)) {
                return false;
            }
            c cVar = (c) other;
            if (Intrinsics.areEqual(this.context, cVar.context) && Intrinsics.areEqual(this.troopMemberHistoryModel, cVar.troopMemberHistoryModel)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
            }
            return (this.context.hashCode() * 31) + this.troopMemberHistoryModel.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return "JumpAIOIntent(context=" + this.context + ", troopMemberHistoryModel=" + this.troopMemberHistoryModel + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/troopMember/history/data/b$d;", "Lcom/tencent/qqnt/chathistory/ui/troopMember/history/data/b;", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class d extends b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final d f353961a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51559);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f353961a = new d();
            }
        }

        d() {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }
}
