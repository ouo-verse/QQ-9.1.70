package com.tencent.qqnt.aio.refresher;

import android.content.Context;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0006\u0012\u0006\u0010\u001b\u001a\u00020\b\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0017\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0015\u001a\u0004\b\u000b\u0010\u0016R\u0017\u0010\u001b\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/qqnt/aio/refresher/b;", "Lcom/tencent/mobileqq/aio/msglist/holder/external/h;", "", "toString", "", "hashCode", "", "other", "", "equals", "Landroid/content/Context;", "a", "Landroid/content/Context;", "b", "()Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "c", "()Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "Ljava/lang/Object;", "()Ljava/lang/Object;", "avatarDrawable", "d", "Z", "()Z", "isSelectMode", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;Ljava/lang/Object;Z)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final /* data */ class b implements com.tencent.mobileqq.aio.msglist.holder.external.h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AIOMsgItem msgItem;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Object avatarDrawable;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean isSelectMode;

    public b(@NotNull Context context, @NotNull AIOMsgItem msgItem, @NotNull Object avatarDrawable, boolean z16) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(avatarDrawable, "avatarDrawable");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, msgItem, avatarDrawable, Boolean.valueOf(z16));
            return;
        }
        this.context = context;
        this.msgItem = msgItem;
        this.avatarDrawable = avatarDrawable;
        this.isSelectMode = z16;
    }

    @NotNull
    public final Object a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.avatarDrawable;
    }

    @NotNull
    public final Context b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Context) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.context;
    }

    @NotNull
    public final AIOMsgItem c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (AIOMsgItem) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.msgItem;
    }

    public final boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.isSelectMode;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof b)) {
            return false;
        }
        b bVar = (b) other;
        if (Intrinsics.areEqual(this.context, bVar.context) && Intrinsics.areEqual(this.msgItem, bVar.msgItem) && Intrinsics.areEqual(this.avatarDrawable, bVar.avatarDrawable) && this.isSelectMode == bVar.isSelectMode) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        int hashCode = ((((this.context.hashCode() * 31) + this.msgItem.hashCode()) * 31) + this.avatarDrawable.hashCode()) * 31;
        boolean z16 = this.isSelectMode;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return "AvatarEggRefreshRequest(context=" + this.context + ", msgItem=" + this.msgItem + ", avatarDrawable=" + this.avatarDrawable + ", isSelectMode=" + this.isSelectMode + ")";
    }
}
