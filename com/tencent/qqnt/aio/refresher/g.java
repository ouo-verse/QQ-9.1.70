package com.tencent.qqnt.aio.refresher;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0016\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001b\u00a2\u0006\u0004\b!\u0010\"J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012R\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u000b\u0010\u0012R\u0017\u0010\u001a\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0017\u0010\u0019R$\u0010 \u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u0014\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/qqnt/aio/refresher/g;", "Lcom/tencent/mobileqq/aio/msglist/holder/external/h;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "a", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "e", "()Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "bubbleId", "c", "bubbleDiyTextId", "", "d", "Ljava/lang/CharSequence;", "()Ljava/lang/CharSequence;", RemoteMessageConst.MessageBody.MSG_CONTENT, "Lcom/tencent/qqnt/aio/refresher/h;", "Lcom/tencent/qqnt/aio/refresher/h;", "()Lcom/tencent/qqnt/aio/refresher/h;", "f", "(Lcom/tencent/qqnt/aio/refresher/h;)V", "bubbleRsp", "<init>", "(Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;Ljava/lang/String;Ljava/lang/String;Ljava/lang/CharSequence;Lcom/tencent/qqnt/aio/refresher/h;)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final /* data */ class g implements com.tencent.mobileqq.aio.msglist.holder.external.h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AIOMsgItem msgItem;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String bubbleId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String bubbleDiyTextId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CharSequence msgContent;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private h bubbleRsp;

    public g(@NotNull AIOMsgItem msgItem, @NotNull String bubbleId, @NotNull String bubbleDiyTextId, @NotNull CharSequence msgContent, @Nullable h hVar) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(bubbleId, "bubbleId");
        Intrinsics.checkNotNullParameter(bubbleDiyTextId, "bubbleDiyTextId");
        Intrinsics.checkNotNullParameter(msgContent, "msgContent");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, msgItem, bubbleId, bubbleDiyTextId, msgContent, hVar);
            return;
        }
        this.msgItem = msgItem;
        this.bubbleId = bubbleId;
        this.bubbleDiyTextId = bubbleDiyTextId;
        this.msgContent = msgContent;
        this.bubbleRsp = hVar;
    }

    @NotNull
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.bubbleDiyTextId;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.bubbleId;
    }

    @Nullable
    public final h c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (h) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.bubbleRsp;
    }

    @NotNull
    public final CharSequence d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (CharSequence) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.msgContent;
    }

    @NotNull
    public final AIOMsgItem e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (AIOMsgItem) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.msgItem;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof g)) {
            return false;
        }
        g gVar = (g) other;
        if (Intrinsics.areEqual(this.msgItem, gVar.msgItem) && Intrinsics.areEqual(this.bubbleId, gVar.bubbleId) && Intrinsics.areEqual(this.bubbleDiyTextId, gVar.bubbleDiyTextId) && Intrinsics.areEqual(this.msgContent, gVar.msgContent) && Intrinsics.areEqual(this.bubbleRsp, gVar.bubbleRsp)) {
            return true;
        }
        return false;
    }

    public final void f(@Nullable h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) hVar);
        } else {
            this.bubbleRsp = hVar;
        }
    }

    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        int hashCode2 = ((((((this.msgItem.hashCode() * 31) + this.bubbleId.hashCode()) * 31) + this.bubbleDiyTextId.hashCode()) * 31) + this.msgContent.hashCode()) * 31;
        h hVar = this.bubbleRsp;
        if (hVar == null) {
            hashCode = 0;
        } else {
            hashCode = hVar.hashCode();
        }
        return hashCode2 + hashCode;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        AIOMsgItem aIOMsgItem = this.msgItem;
        String str = this.bubbleId;
        String str2 = this.bubbleDiyTextId;
        CharSequence charSequence = this.msgContent;
        return "BubbleRefreshRequest(msgItem=" + aIOMsgItem + ", bubbleId=" + str + ", bubbleDiyTextId=" + str2 + ", msgContent=" + ((Object) charSequence) + ", bubbleRsp=" + this.bubbleRsp + ")";
    }

    public /* synthetic */ g(AIOMsgItem aIOMsgItem, String str, String str2, CharSequence charSequence, h hVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(aIOMsgItem, str, str2, charSequence, (i3 & 16) != 0 ? null : hVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, aIOMsgItem, str, str2, charSequence, hVar, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
