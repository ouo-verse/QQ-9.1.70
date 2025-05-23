package com.tencent.mobileqq.aio.api;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.annotation.AutoEventName;
import com.tencent.mvi.base.route.MsgIntent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/api/AIOTofuMsgIntent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "()V", "AuthenticationIntent", "UpdateDisplayTofuIntent", "Lcom/tencent/mobileqq/aio/api/AIOTofuMsgIntent$AuthenticationIntent;", "Lcom/tencent/mobileqq/aio/api/AIOTofuMsgIntent$UpdateDisplayTofuIntent;", "aio_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes10.dex */
public abstract class AIOTofuMsgIntent implements MsgIntent {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0018\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\n\u0012\u0006\u0010\u001c\u001a\u00020\n\u0012\u0006\u0010\u001f\u001a\u00020\u0002\u00a2\u0006\u0004\b \u0010!J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012R\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016R\u0017\u0010\u0019\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\f\u001a\u0004\b\u000b\u0010\u000eR\u0017\u0010\u001c\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\f\u001a\u0004\b\u001b\u0010\u000eR\u0017\u0010\u001f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0015\u001a\u0004\b\u001e\u0010\u0016\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/aio/api/AIOTofuMsgIntent$AuthenticationIntent;", "Lcom/tencent/mobileqq/aio/api/AIOTofuMsgIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "d", "J", "c", "()J", "friendUin", "e", "I", "()I", "rootMsgChatType", "f", "Ljava/lang/String;", "()Ljava/lang/String;", "rootMsgPeerId", h.F, "msgId", "i", "a", "busiID", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "b", "busiUUID", "<init>", "(JILjava/lang/String;JJLjava/lang/String;)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final /* data */ class AuthenticationIntent extends AIOTofuMsgIntent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final long friendUin;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int rootMsgChatType;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String rootMsgPeerId;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private final long msgId;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private final long busiID;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String busiUUID;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AuthenticationIntent(long j3, int i3, @NotNull String rootMsgPeerId, long j16, long j17, @NotNull String busiUUID) {
            super(null);
            Intrinsics.checkNotNullParameter(rootMsgPeerId, "rootMsgPeerId");
            Intrinsics.checkNotNullParameter(busiUUID, "busiUUID");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Integer.valueOf(i3), rootMsgPeerId, Long.valueOf(j16), Long.valueOf(j17), busiUUID);
                return;
            }
            this.friendUin = j3;
            this.rootMsgChatType = i3;
            this.rootMsgPeerId = rootMsgPeerId;
            this.msgId = j16;
            this.busiID = j17;
            this.busiUUID = busiUUID;
        }

        public final long a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
            }
            return this.busiID;
        }

        @NotNull
        public final String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return this.busiUUID;
        }

        public final long c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
            }
            return this.friendUin;
        }

        public final long d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
            }
            return this.msgId;
        }

        public final int e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.rootMsgChatType;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof AuthenticationIntent)) {
                return false;
            }
            AuthenticationIntent authenticationIntent = (AuthenticationIntent) other;
            if (this.friendUin == authenticationIntent.friendUin && this.rootMsgChatType == authenticationIntent.rootMsgChatType && Intrinsics.areEqual(this.rootMsgPeerId, authenticationIntent.rootMsgPeerId) && this.msgId == authenticationIntent.msgId && this.busiID == authenticationIntent.busiID && Intrinsics.areEqual(this.busiUUID, authenticationIntent.busiUUID)) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                return (String) iPatchRedirector.redirect((short) 18, (Object) this);
            }
            return "com.tencent.mobileqq.aio.api.AIOTofuMsgIntent.AuthenticationIntent";
        }

        @NotNull
        public final String f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.rootMsgPeerId;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
            }
            return (((((((((androidx.fragment.app.a.a(this.friendUin) * 31) + this.rootMsgChatType) * 31) + this.rootMsgPeerId.hashCode()) * 31) + androidx.fragment.app.a.a(this.msgId)) * 31) + androidx.fragment.app.a.a(this.busiID)) * 31) + this.busiUUID.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return (String) iPatchRedirector.redirect((short) 15, (Object) this);
            }
            return "AuthenticationIntent(friendUin=" + this.friendUin + ", rootMsgChatType=" + this.rootMsgChatType + ", rootMsgPeerId=" + this.rootMsgPeerId + ", msgId=" + this.msgId + ", busiID=" + this.busiID + ", busiUUID=" + this.busiUUID + ")";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0012\u001a\u00020\n\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0012\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000eR\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/aio/api/AIOTofuMsgIntent$UpdateDisplayTofuIntent;", "Lcom/tencent/mobileqq/aio/api/AIOTofuMsgIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "d", "J", "getFriendUin", "()J", "friendUin", "e", "a", "busiID", "f", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "busiUUID", "<init>", "(JJLjava/lang/String;)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final /* data */ class UpdateDisplayTofuIntent extends AIOTofuMsgIntent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final long friendUin;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final long busiID;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String busiUUID;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UpdateDisplayTofuIntent(long j3, long j16, @NotNull String busiUUID) {
            super(null);
            Intrinsics.checkNotNullParameter(busiUUID, "busiUUID");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Long.valueOf(j16), busiUUID);
                return;
            }
            this.friendUin = j3;
            this.busiID = j16;
            this.busiUUID = busiUUID;
        }

        public final long a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
            }
            return this.busiID;
        }

        @NotNull
        public final String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.busiUUID;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof UpdateDisplayTofuIntent)) {
                return false;
            }
            UpdateDisplayTofuIntent updateDisplayTofuIntent = (UpdateDisplayTofuIntent) other;
            if (this.friendUin == updateDisplayTofuIntent.friendUin && this.busiID == updateDisplayTofuIntent.busiID && Intrinsics.areEqual(this.busiUUID, updateDisplayTofuIntent.busiUUID)) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (String) iPatchRedirector.redirect((short) 12, (Object) this);
            }
            return "com.tencent.mobileqq.aio.api.AIOTofuMsgIntent.UpdateDisplayTofuIntent";
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
            }
            return (((androidx.fragment.app.a.a(this.friendUin) * 31) + androidx.fragment.app.a.a(this.busiID)) * 31) + this.busiUUID.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (String) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return "UpdateDisplayTofuIntent(friendUin=" + this.friendUin + ", busiID=" + this.busiID + ", busiUUID=" + this.busiUUID + ")";
        }
    }

    public /* synthetic */ AIOTofuMsgIntent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return MsgIntent.a.a(this);
    }

    AIOTofuMsgIntent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }
}
