package com.tencent.qqnt.aio.emoreply;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0016\u001a\u00020\u0012\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\u0016\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\n\u0010\u0015R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/qqnt/aio/emoreply/AIOEmoReplySelectMsgEvent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "I", "b", "()I", "emojiId", "e", "c", "emojiType", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "f", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msg", "Lcom/tencent/qqnt/aio/emoreply/h;", tl.h.F, "Lcom/tencent/qqnt/aio/emoreply/h;", "a", "()Lcom/tencent/qqnt/aio/emoreply/h;", "emoReplyAnimationInfo", "<init>", "(IILcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;Lcom/tencent/qqnt/aio/emoreply/h;)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final /* data */ class AIOEmoReplySelectMsgEvent implements MsgIntent {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int emojiId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int emojiType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MsgRecord msg;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final h emoReplyAnimationInfo;

    public AIOEmoReplySelectMsgEvent(int i3, int i16, @NotNull MsgRecord msg2, @Nullable h hVar) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), msg2, hVar);
            return;
        }
        this.emojiId = i3;
        this.emojiType = i16;
        this.msg = msg2;
        this.emoReplyAnimationInfo = hVar;
    }

    @Nullable
    public final h a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (h) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.emoReplyAnimationInfo;
    }

    public final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.emojiId;
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.emojiType;
    }

    @NotNull
    public final MsgRecord d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (MsgRecord) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.msg;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof AIOEmoReplySelectMsgEvent)) {
            return false;
        }
        AIOEmoReplySelectMsgEvent aIOEmoReplySelectMsgEvent = (AIOEmoReplySelectMsgEvent) other;
        if (this.emojiId == aIOEmoReplySelectMsgEvent.emojiId && this.emojiType == aIOEmoReplySelectMsgEvent.emojiType && Intrinsics.areEqual(this.msg, aIOEmoReplySelectMsgEvent.msg) && Intrinsics.areEqual(this.emoReplyAnimationInfo, aIOEmoReplySelectMsgEvent.emoReplyAnimationInfo)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return com.tencent.mvi.base.route.h.a(this);
    }

    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        int hashCode2 = ((((this.emojiId * 31) + this.emojiType) * 31) + this.msg.hashCode()) * 31;
        h hVar = this.emoReplyAnimationInfo;
        if (hVar == null) {
            hashCode = 0;
        } else {
            hashCode = hVar.hashCode();
        }
        return hashCode2 + hashCode;
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return MsgIntent.a.a(this);
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return "AIOEmoReplySelectMsgEvent(emojiId=" + this.emojiId + ", emojiType=" + this.emojiType + ", msg=" + this.msg + ", emoReplyAnimationInfo=" + this.emoReplyAnimationInfo + ")";
    }
}
