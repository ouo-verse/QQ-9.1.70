package com.tencent.mobileqq.aio.input.reply;

import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/aio/input/reply/InputReplyUIState;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "()V", "ClearReplyUIState", "SetFullScreenModeUIState", "SetReplyUIState", "Lcom/tencent/mobileqq/aio/input/reply/InputReplyUIState$ClearReplyUIState;", "Lcom/tencent/mobileqq/aio/input/reply/InputReplyUIState$SetFullScreenModeUIState;", "Lcom/tencent/mobileqq/aio/input/reply/InputReplyUIState$SetReplyUIState;", "aio_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes10.dex */
public abstract class InputReplyUIState implements InputUIState {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/aio/input/reply/InputReplyUIState$ClearReplyUIState;", "Lcom/tencent/mobileqq/aio/input/reply/InputReplyUIState;", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes10.dex */
    public static final class ClearReplyUIState extends InputReplyUIState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final ClearReplyUIState f189810d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56833);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f189810d = new ClearReplyUIState();
            }
        }

        ClearReplyUIState() {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\b\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/aio/input/reply/InputReplyUIState$SetFullScreenModeUIState;", "Lcom/tencent/mobileqq/aio/input/reply/InputReplyUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Z", "a", "()Z", "isFullScreenMode", "<init>", "(Z)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final /* data */ class SetFullScreenModeUIState extends InputReplyUIState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean isFullScreenMode;

        public SetFullScreenModeUIState(boolean z16) {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, z16);
            } else {
                this.isFullScreenMode = z16;
            }
        }

        public final boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return this.isFullScreenMode;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if ((other instanceof SetFullScreenModeUIState) && this.isFullScreenMode == ((SetFullScreenModeUIState) other).isFullScreenMode) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            boolean z16 = this.isFullScreenMode;
            if (z16) {
                return 1;
            }
            return z16 ? 1 : 0;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return "SetFullScreenModeUIState(isFullScreenMode=" + this.isFullScreenMode + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\r\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u0012\u0006\u0010\u001e\u001a\u00020\u0004\u0012\u0006\u0010\"\u001a\u00020\b\u00a2\u0006\u0004\b#\u0010$J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000b\u0010\u0012R\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\"\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u0010\u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/aio/input/reply/InputReplyUIState$SetReplyUIState;", "Lcom/tencent/mobileqq/aio/input/reply/InputReplyUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "d", "J", "c", "()J", "replyMsgId", "e", "Ljava/lang/String;", "()Ljava/lang/String;", "replyNick", "", "f", "Ljava/lang/CharSequence;", "b", "()Ljava/lang/CharSequence;", "replyContent", tl.h.F, "I", "a", "()I", "from", "i", "Z", "()Z", "isImmersive", "<init>", "(JLjava/lang/String;Ljava/lang/CharSequence;IZ)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final /* data */ class SetReplyUIState extends InputReplyUIState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final long replyMsgId;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String replyNick;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final CharSequence replyContent;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private final int from;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private final boolean isImmersive;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SetReplyUIState(long j3, @NotNull String replyNick, @NotNull CharSequence replyContent, int i3, boolean z16) {
            super(null);
            Intrinsics.checkNotNullParameter(replyNick, "replyNick");
            Intrinsics.checkNotNullParameter(replyContent, "replyContent");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), replyNick, replyContent, Integer.valueOf(i3), Boolean.valueOf(z16));
                return;
            }
            this.replyMsgId = j3;
            this.replyNick = replyNick;
            this.replyContent = replyContent;
            this.from = i3;
            this.isImmersive = z16;
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            return this.from;
        }

        @NotNull
        public final CharSequence b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (CharSequence) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.replyContent;
        }

        public final long c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
            }
            return this.replyMsgId;
        }

        @NotNull
        public final String d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.replyNick;
        }

        public final boolean e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
            }
            return this.isImmersive;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof SetReplyUIState)) {
                return false;
            }
            SetReplyUIState setReplyUIState = (SetReplyUIState) other;
            if (this.replyMsgId == setReplyUIState.replyMsgId && Intrinsics.areEqual(this.replyNick, setReplyUIState.replyNick) && Intrinsics.areEqual(this.replyContent, setReplyUIState.replyContent) && this.from == setReplyUIState.from && this.isImmersive == setReplyUIState.isImmersive) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
            }
            int a16 = ((((((androidx.fragment.app.a.a(this.replyMsgId) * 31) + this.replyNick.hashCode()) * 31) + this.replyContent.hashCode()) * 31) + this.from) * 31;
            boolean z16 = this.isImmersive;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return a16 + i3;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (String) iPatchRedirector.redirect((short) 13, (Object) this);
            }
            long j3 = this.replyMsgId;
            String str = this.replyNick;
            CharSequence charSequence = this.replyContent;
            return "SetReplyUIState(replyMsgId=" + j3 + ", replyNick=" + str + ", replyContent=" + ((Object) charSequence) + ", from=" + this.from + ", isImmersive=" + this.isImmersive + ")";
        }
    }

    public /* synthetic */ InputReplyUIState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return com.tencent.mvi.base.route.h.a(this);
    }

    InputReplyUIState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }
}
