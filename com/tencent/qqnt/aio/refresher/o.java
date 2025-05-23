package com.tencent.qqnt.aio.refresher;

import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.font.IFontManager;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\"\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110\u0010j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0011`\u0012\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR3\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110\u0010j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0011`\u00128\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0013\u001a\u0004\b\u000b\u0010\u0014R$\u0010\u001c\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0017\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/qqnt/aio/refresher/o;", "Lcom/tencent/mobileqq/aio/msglist/holder/external/h;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "a", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "b", "()Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "Ljava/util/HashMap;", "Lcom/tencent/mobileqq/vas/font/IFontManager$c;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "()Ljava/util/HashMap;", "fontInfoReqMap", "Lcom/tencent/qqnt/aio/refresher/p;", "c", "Lcom/tencent/qqnt/aio/refresher/p;", "()Lcom/tencent/qqnt/aio/refresher/p;", "d", "(Lcom/tencent/qqnt/aio/refresher/p;)V", "rsp", "<init>", "(Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;Ljava/util/HashMap;Lcom/tencent/qqnt/aio/refresher/p;)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final /* data */ class o implements com.tencent.mobileqq.aio.msglist.holder.external.h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AIOMsgItem msgItem;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Integer, IFontManager.FontDrawableInfo> fontInfoReqMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private p rsp;

    public o(@NotNull AIOMsgItem msgItem, @NotNull HashMap<Integer, IFontManager.FontDrawableInfo> fontInfoReqMap, @Nullable p pVar) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(fontInfoReqMap, "fontInfoReqMap");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, msgItem, fontInfoReqMap, pVar);
            return;
        }
        this.msgItem = msgItem;
        this.fontInfoReqMap = fontInfoReqMap;
        this.rsp = pVar;
    }

    @NotNull
    public final HashMap<Integer, IFontManager.FontDrawableInfo> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (HashMap) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.fontInfoReqMap;
    }

    @NotNull
    public final AIOMsgItem b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (AIOMsgItem) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.msgItem;
    }

    @Nullable
    public final p c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (p) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.rsp;
    }

    public final void d(@Nullable p pVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) pVar);
        } else {
            this.rsp = pVar;
        }
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof o)) {
            return false;
        }
        o oVar = (o) other;
        if (Intrinsics.areEqual(this.msgItem, oVar.msgItem) && Intrinsics.areEqual(this.fontInfoReqMap, oVar.fontInfoReqMap) && Intrinsics.areEqual(this.rsp, oVar.rsp)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        int hashCode2 = ((this.msgItem.hashCode() * 31) + this.fontInfoReqMap.hashCode()) * 31;
        p pVar = this.rsp;
        if (pVar == null) {
            hashCode = 0;
        } else {
            hashCode = pVar.hashCode();
        }
        return hashCode2 + hashCode;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return "FontRefreshRequest(msgItem=" + this.msgItem + ", fontInfoReqMap=" + this.fontInfoReqMap + ", rsp=" + this.rsp + ")";
    }

    public /* synthetic */ o(AIOMsgItem aIOMsgItem, HashMap hashMap, p pVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(aIOMsgItem, hashMap, (i3 & 4) != 0 ? null : pVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, aIOMsgItem, hashMap, pVar, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
