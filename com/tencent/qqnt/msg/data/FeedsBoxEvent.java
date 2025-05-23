package com.tencent.qqnt.msg.data;

import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.kernelgpro.nativeinterface.FirstViewDirectMsgNotifyInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0002\u000e'B?\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u0004\u00a2\u0006\u0004\b%\u0010&JO\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u0004H\u00c6\u0001J\t\u0010\u000f\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0007\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\t\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010\n\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b\"\u0010\u001dR\u0017\u0010\f\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b\u001e\u0010$R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001a\u0010\u0019\u00a8\u0006("}, d2 = {"Lcom/tencent/qqnt/msg/data/FeedsBoxEvent;", "", "", "valid", "", "unreadNumber", "", "summary", "", "lastEventTime", "lastFeedId", "Lcom/tencent/qqnt/msg/data/FeedsBoxEvent$FromType;", IProfileCardConst.KEY_FROM_TYPE, "feedCommentsSwitch", "a", "toString", "hashCode", "other", "equals", "Z", "getValid", "()Z", "b", "I", tl.h.F, "()I", "c", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "d", "J", "e", "()J", "f", "Lcom/tencent/qqnt/msg/data/FeedsBoxEvent$FromType;", "()Lcom/tencent/qqnt/msg/data/FeedsBoxEvent$FromType;", "<init>", "(ZILjava/lang/String;JLjava/lang/String;Lcom/tencent/qqnt/msg/data/FeedsBoxEvent$FromType;I)V", "FromType", "msg_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final /* data */ class FeedsBoxEvent {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean valid;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int unreadNumber;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String summary;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long lastEventTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String lastFeedId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FromType fromType;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final int feedCommentsSwitch;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/msg/data/FeedsBoxEvent$FromType;", "", "(Ljava/lang/String;I)V", "FIRST_VIEW_INIT", "UPDATE_EVENT_PUSH", "READ_EVENT_PUSH", "NOTIFY_SWITCH_PUSH", "msg_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes24.dex */
    public static final class FromType {
        private static final /* synthetic */ FromType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final FromType FIRST_VIEW_INIT;
        public static final FromType NOTIFY_SWITCH_PUSH;
        public static final FromType READ_EVENT_PUSH;
        public static final FromType UPDATE_EVENT_PUSH;

        private static final /* synthetic */ FromType[] $values() {
            return new FromType[]{FIRST_VIEW_INIT, UPDATE_EVENT_PUSH, READ_EVENT_PUSH, NOTIFY_SWITCH_PUSH};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38110);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            FIRST_VIEW_INIT = new FromType("FIRST_VIEW_INIT", 0);
            UPDATE_EVENT_PUSH = new FromType("UPDATE_EVENT_PUSH", 1);
            READ_EVENT_PUSH = new FromType("READ_EVENT_PUSH", 2);
            NOTIFY_SWITCH_PUSH = new FromType("NOTIFY_SWITCH_PUSH", 3);
            $VALUES = $values();
        }

        FromType(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static FromType valueOf(String str) {
            return (FromType) Enum.valueOf(FromType.class, str);
        }

        public static FromType[] values() {
            return (FromType[]) $VALUES.clone();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/msg/data/FeedsBoxEvent$a;", "", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/FirstViewDirectMsgNotifyInfo;", "notifyInfo", "Lcom/tencent/qqnt/msg/data/FeedsBoxEvent$FromType;", IProfileCardConst.KEY_FROM_TYPE, "Lcom/tencent/qqnt/msg/data/FeedsBoxEvent;", "a", "<init>", "()V", "msg_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.msg.data.FeedsBoxEvent$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final FeedsBoxEvent a(@NotNull FirstViewDirectMsgNotifyInfo notifyInfo, @NotNull FromType fromType) {
            boolean z16;
            String decodeToString;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (FeedsBoxEvent) iPatchRedirector.redirect((short) 2, (Object) this, (Object) notifyInfo, (Object) fromType);
            }
            Intrinsics.checkNotNullParameter(notifyInfo, "notifyInfo");
            Intrinsics.checkNotNullParameter(fromType, "fromType");
            if (notifyInfo.getFeedsEventIsValid() != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            boolean z17 = z16;
            int feedsEventNnreadNum = (int) notifyInfo.getFeedsEventNnreadNum();
            long feedsEventLastTime = notifyInfo.getFeedsEventLastTime();
            byte[] feedsEventLastId = notifyInfo.getFeedsEventLastId();
            Intrinsics.checkNotNullExpressionValue(feedsEventLastId, "notifyInfo.feedsEventLastId");
            decodeToString = StringsKt__StringsJVMKt.decodeToString(feedsEventLastId);
            return new FeedsBoxEvent(z17, feedsEventNnreadNum, " ", feedsEventLastTime, decodeToString, fromType, notifyInfo.getFeedCommentsSwitch());
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38111);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 20)) {
            redirector.redirect((short) 20);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public FeedsBoxEvent(boolean z16, int i3, @NotNull String summary, long j3, @NotNull String lastFeedId, @NotNull FromType fromType, int i16) {
        Intrinsics.checkNotNullParameter(summary, "summary");
        Intrinsics.checkNotNullParameter(lastFeedId, "lastFeedId");
        Intrinsics.checkNotNullParameter(fromType, "fromType");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Integer.valueOf(i3), summary, Long.valueOf(j3), lastFeedId, fromType, Integer.valueOf(i16));
            return;
        }
        this.valid = z16;
        this.unreadNumber = i3;
        this.summary = summary;
        this.lastEventTime = j3;
        this.lastFeedId = lastFeedId;
        this.fromType = fromType;
        this.feedCommentsSwitch = i16;
    }

    public static /* synthetic */ FeedsBoxEvent b(FeedsBoxEvent feedsBoxEvent, boolean z16, int i3, String str, long j3, String str2, FromType fromType, int i16, int i17, Object obj) {
        boolean z17;
        int i18;
        String str3;
        long j16;
        String str4;
        FromType fromType2;
        int i19;
        if ((i17 & 1) != 0) {
            z17 = feedsBoxEvent.valid;
        } else {
            z17 = z16;
        }
        if ((i17 & 2) != 0) {
            i18 = feedsBoxEvent.unreadNumber;
        } else {
            i18 = i3;
        }
        if ((i17 & 4) != 0) {
            str3 = feedsBoxEvent.summary;
        } else {
            str3 = str;
        }
        if ((i17 & 8) != 0) {
            j16 = feedsBoxEvent.lastEventTime;
        } else {
            j16 = j3;
        }
        if ((i17 & 16) != 0) {
            str4 = feedsBoxEvent.lastFeedId;
        } else {
            str4 = str2;
        }
        if ((i17 & 32) != 0) {
            fromType2 = feedsBoxEvent.fromType;
        } else {
            fromType2 = fromType;
        }
        if ((i17 & 64) != 0) {
            i19 = feedsBoxEvent.feedCommentsSwitch;
        } else {
            i19 = i16;
        }
        return feedsBoxEvent.a(z17, i18, str3, j16, str4, fromType2, i19);
    }

    @NotNull
    public final FeedsBoxEvent a(boolean valid, int unreadNumber, @NotNull String summary, long lastEventTime, @NotNull String lastFeedId, @NotNull FromType fromType, int feedCommentsSwitch) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (FeedsBoxEvent) iPatchRedirector.redirect((short) 16, this, Boolean.valueOf(valid), Integer.valueOf(unreadNumber), summary, Long.valueOf(lastEventTime), lastFeedId, fromType, Integer.valueOf(feedCommentsSwitch));
        }
        Intrinsics.checkNotNullParameter(summary, "summary");
        Intrinsics.checkNotNullParameter(lastFeedId, "lastFeedId");
        Intrinsics.checkNotNullParameter(fromType, "fromType");
        return new FeedsBoxEvent(valid, unreadNumber, summary, lastEventTime, lastFeedId, fromType, feedCommentsSwitch);
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.feedCommentsSwitch;
    }

    @NotNull
    public final FromType d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (FromType) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.fromType;
    }

    public final long e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        return this.lastEventTime;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeedsBoxEvent)) {
            return false;
        }
        FeedsBoxEvent feedsBoxEvent = (FeedsBoxEvent) other;
        if (this.valid == feedsBoxEvent.valid && this.unreadNumber == feedsBoxEvent.unreadNumber && Intrinsics.areEqual(this.summary, feedsBoxEvent.summary) && this.lastEventTime == feedsBoxEvent.lastEventTime && Intrinsics.areEqual(this.lastFeedId, feedsBoxEvent.lastFeedId) && this.fromType == feedsBoxEvent.fromType && this.feedCommentsSwitch == feedsBoxEvent.feedCommentsSwitch) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.lastFeedId;
    }

    @NotNull
    public final String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.summary;
    }

    public final int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.unreadNumber;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        boolean z16 = this.valid;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (((((((((((r06 * 31) + this.unreadNumber) * 31) + this.summary.hashCode()) * 31) + androidx.fragment.app.a.a(this.lastEventTime)) * 31) + this.lastFeedId.hashCode()) * 31) + this.fromType.hashCode()) * 31) + this.feedCommentsSwitch;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return "FeedsBoxEvent(valid=" + this.valid + ", unreadNumber=" + this.unreadNumber + ", summary=" + this.summary + ", lastEventTime=" + this.lastEventTime + ", lastFeedId=" + this.lastFeedId + ", fromType=" + this.fromType + ", feedCommentsSwitch=" + this.feedCommentsSwitch + ")";
    }
}
