package com.tencent.mobileqq.component.qrcode;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000f\u001a\u0004\b\t\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/component/qrcode/i;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "d", "()I", "staticResId", "b", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "animResStrId", "animDarkResStrId", "animRepeatCount", "<init>", "(ILjava/lang/Integer;Ljava/lang/Integer;I)V", "qrcode_component_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final /* data */ class i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int staticResId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Integer animResStrId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Integer animDarkResStrId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int animRepeatCount;

    public i() {
        this(0, null, null, 0, 15, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) {
            return;
        }
        iPatchRedirector.redirect((short) 15, (Object) this);
    }

    @Nullable
    public final Integer a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Integer) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.animDarkResStrId;
    }

    public final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.animRepeatCount;
    }

    @Nullable
    public final Integer c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Integer) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.animResStrId;
    }

    public final int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.staticResId;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof i)) {
            return false;
        }
        i iVar = (i) other;
        if (this.staticResId == iVar.staticResId && Intrinsics.areEqual(this.animResStrId, iVar.animResStrId) && Intrinsics.areEqual(this.animDarkResStrId, iVar.animDarkResStrId) && this.animRepeatCount == iVar.animRepeatCount) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        int i3 = this.staticResId * 31;
        Integer num = this.animResStrId;
        int i16 = 0;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        int i17 = (i3 + hashCode) * 31;
        Integer num2 = this.animDarkResStrId;
        if (num2 != null) {
            i16 = num2.hashCode();
        }
        return ((i17 + i16) * 31) + this.animRepeatCount;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return "LogoResourceParams(staticResId=" + this.staticResId + ", animResStrId=" + this.animResStrId + ", animDarkResStrId=" + this.animDarkResStrId + ", animRepeatCount=" + this.animRepeatCount + ")";
    }

    public i(int i3, @Nullable Integer num, @Nullable Integer num2, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), num, num2, Integer.valueOf(i16));
            return;
        }
        this.staticResId = i3;
        this.animResStrId = num;
        this.animDarkResStrId = num2;
        this.animRepeatCount = i16;
    }

    public /* synthetic */ i(int i3, Integer num, Integer num2, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? R.drawable.f161853kv2 : i3, (i17 & 2) != 0 ? Integer.valueOf(R.string.f2035450h) : num, (i17 & 4) != 0 ? Integer.valueOf(R.string.f2035350g) : num2, (i17 & 8) != 0 ? 0 : i16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), num, num2, Integer.valueOf(i16), Integer.valueOf(i17), defaultConstructorMarker);
    }
}
