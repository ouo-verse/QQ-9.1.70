package com.tencent.mobileqq.ai.main;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.kernel.nativeinterface.AiAvatarActionStatus;
import com.tencent.qqnt.kernel.nativeinterface.AiAvatarJumpInfo;
import com.tencent.qqnt.kernel.nativeinterface.AiAvatarStatusInfo;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qshadow.ShadowAIGCStatus$ActionStatus;
import qshadow.ShadowAIGCStatus$GetStatusReply;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u0000 \u00032\u00020\u0001:\u0001\u000bB\u001f\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u0017\u0010\u0010\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u000f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/ai/main/a;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/AiAvatarActionStatus;", "d", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "available", "b", "jumpType", "c", "Ljava/lang/String;", "()Ljava/lang/String;", WadlProxyConsts.KEY_JUMP_URL, "<init>", "(IILjava/lang/String;)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final /* data */ class a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int available;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int jumpType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String jumpUrl;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/ai/main/a$a;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/AiAvatarStatusInfo;", "info", "Lcom/tencent/mobileqq/ai/main/a;", "a", "Lqshadow/ShadowAIGCStatus$GetStatusReply;", TtmlNode.ATTR_TTS_ORIGIN, "b", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.ai.main.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        @Nullable
        public final a a(@NotNull AiAvatarStatusInfo info) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) info);
            }
            Intrinsics.checkNotNullParameter(info, "info");
            Iterator<AiAvatarActionStatus> it = info.actionsList.iterator();
            AiAvatarActionStatus aiAvatarActionStatus = null;
            while (it.hasNext()) {
                AiAvatarActionStatus next = it.next();
                if (next.type == 1) {
                    aiAvatarActionStatus = next;
                }
            }
            if (aiAvatarActionStatus == null) {
                return null;
            }
            int i3 = aiAvatarActionStatus.available;
            AiAvatarJumpInfo aiAvatarJumpInfo = info.jumpInfo;
            int i16 = aiAvatarJumpInfo.type;
            String str = aiAvatarJumpInfo.schema;
            Intrinsics.checkNotNullExpressionValue(str, "info.jumpInfo.schema");
            return new a(i3, i16, str);
        }

        @Nullable
        public final a b(@NotNull ShadowAIGCStatus$GetStatusReply info, @NotNull a origin) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (a) iPatchRedirector.redirect((short) 3, (Object) this, (Object) info, (Object) origin);
            }
            Intrinsics.checkNotNullParameter(info, "info");
            Intrinsics.checkNotNullParameter(origin, "origin");
            ShadowAIGCStatus$ActionStatus shadowAIGCStatus$ActionStatus = null;
            for (ShadowAIGCStatus$ActionStatus shadowAIGCStatus$ActionStatus2 : info.actions.get()) {
                if (shadowAIGCStatus$ActionStatus2.type.get() == 1) {
                    shadowAIGCStatus$ActionStatus = shadowAIGCStatus$ActionStatus2;
                }
            }
            if (shadowAIGCStatus$ActionStatus == null) {
                return null;
            }
            return new a(shadowAIGCStatus$ActionStatus.available.get(), origin.b(), origin.c());
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22128);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a(int i3, int i16, @NotNull String jumpUrl) {
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), jumpUrl);
            return;
        }
        this.available = i3;
        this.jumpType = i16;
        this.jumpUrl = jumpUrl;
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.available;
    }

    public final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.jumpType;
    }

    @NotNull
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.jumpUrl;
    }

    @NotNull
    public final AiAvatarActionStatus d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (AiAvatarActionStatus) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        AiAvatarActionStatus aiAvatarActionStatus = new AiAvatarActionStatus();
        aiAvatarActionStatus.type = 1;
        aiAvatarActionStatus.available = this.available;
        return aiAvatarActionStatus;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        if (this.available == aVar.available && this.jumpType == aVar.jumpType && Intrinsics.areEqual(this.jumpUrl, aVar.jumpUrl)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return (((this.available * 31) + this.jumpType) * 31) + this.jumpUrl.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return "AIAvatarActionStatusInfo(available=" + this.available + ", jumpType=" + this.jumpType + ", jumpUrl=" + this.jumpUrl + ")";
    }
}
