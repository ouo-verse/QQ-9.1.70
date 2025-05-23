package com.tencent.mobileqq.nt.msgpush.factory;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\n\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/nt/msgpush/factory/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/nt/msgpush/troop/processor/a;", "a", "Lcom/tencent/mobileqq/nt/msgpush/troop/processor/a;", "b", "()Lcom/tencent/mobileqq/nt/msgpush/troop/processor/a;", "troopBusinessData", "Lcom/tencent/mobileqq/nt/msgpush/friendlist/processor/a;", "Lcom/tencent/mobileqq/nt/msgpush/friendlist/processor/a;", "()Lcom/tencent/mobileqq/nt/msgpush/friendlist/processor/a;", "friendListBusinessData", "<init>", "(Lcom/tencent/mobileqq/nt/msgpush/troop/processor/a;Lcom/tencent/mobileqq/nt/msgpush/friendlist/processor/a;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final /* data */ class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final com.tencent.mobileqq.nt.msgpush.troop.processor.a troopBusinessData;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final com.tencent.mobileqq.nt.msgpush.friendlist.processor.a friendListBusinessData;

    public a() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            return;
        }
        iPatchRedirector.redirect((short) 11, (Object) this);
    }

    @Nullable
    public final com.tencent.mobileqq.nt.msgpush.friendlist.processor.a a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.nt.msgpush.friendlist.processor.a) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.friendListBusinessData;
    }

    @Nullable
    public final com.tencent.mobileqq.nt.msgpush.troop.processor.a b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.nt.msgpush.troop.processor.a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.troopBusinessData;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        if (Intrinsics.areEqual(this.troopBusinessData, aVar.troopBusinessData) && Intrinsics.areEqual(this.friendListBusinessData, aVar.friendListBusinessData)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        com.tencent.mobileqq.nt.msgpush.troop.processor.a aVar = this.troopBusinessData;
        int i3 = 0;
        if (aVar == null) {
            hashCode = 0;
        } else {
            hashCode = aVar.hashCode();
        }
        int i16 = hashCode * 31;
        com.tencent.mobileqq.nt.msgpush.friendlist.processor.a aVar2 = this.friendListBusinessData;
        if (aVar2 != null) {
            i3 = aVar2.hashCode();
        }
        return i16 + i3;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return "ConvertResultData(troopBusinessData=" + this.troopBusinessData + ", friendListBusinessData=" + this.friendListBusinessData + ")";
    }

    public a(@Nullable com.tencent.mobileqq.nt.msgpush.troop.processor.a aVar, @Nullable com.tencent.mobileqq.nt.msgpush.friendlist.processor.a aVar2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar, (Object) aVar2);
        } else {
            this.troopBusinessData = aVar;
            this.friendListBusinessData = aVar2;
        }
    }

    public /* synthetic */ a(com.tencent.mobileqq.nt.msgpush.troop.processor.a aVar, com.tencent.mobileqq.nt.msgpush.friendlist.processor.a aVar2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : aVar, (i3 & 2) == 0 ? aVar2 : null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, aVar, aVar2, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
