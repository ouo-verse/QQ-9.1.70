package com.tencent.mobileqq.opr.helper.sr.model;

import android.util.Size;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0018\u00a2\u0006\u0004\b!\u0010\"J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\t\u0010\u0016R\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010 \u001a\u0004\u0018\u00010\u00188\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001f\u0010\u001c\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/opr/helper/sr/model/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/Boolean;", "getFromCache", "()Ljava/lang/Boolean;", "fromCache", "Lcom/tencent/mobileqq/opr/helper/sr/model/b;", "b", "Lcom/tencent/mobileqq/opr/helper/sr/model/b;", "()Lcom/tencent/mobileqq/opr/helper/sr/model/b;", "getSrInstanceStatistic", "Lcom/tencent/mobileqq/opr/helper/sr/model/a;", "c", "Lcom/tencent/mobileqq/opr/helper/sr/model/a;", "()Lcom/tencent/mobileqq/opr/helper/sr/model/a;", "doSrStatistic", "Landroid/util/Size;", "d", "Landroid/util/Size;", "getInputSize", "()Landroid/util/Size;", "inputSize", "e", "getOutputSize", "outputSize", "<init>", "(Ljava/lang/Boolean;Lcom/tencent/mobileqq/opr/helper/sr/model/b;Lcom/tencent/mobileqq/opr/helper/sr/model/a;Landroid/util/Size;Landroid/util/Size;)V", "opr_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final /* data */ class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Boolean fromCache;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final b getSrInstanceStatistic;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final a doSrStatistic;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Size inputSize;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Size outputSize;

    public e() {
        this(null, null, null, null, null, 31, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 17)) {
            return;
        }
        iPatchRedirector.redirect((short) 17, (Object) this);
    }

    @Nullable
    public final a a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (a) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.doSrStatistic;
    }

    @Nullable
    public final b b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (b) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.getSrInstanceStatistic;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof e)) {
            return false;
        }
        e eVar = (e) other;
        if (Intrinsics.areEqual(this.fromCache, eVar.fromCache) && Intrinsics.areEqual(this.getSrInstanceStatistic, eVar.getSrInstanceStatistic) && Intrinsics.areEqual(this.doSrStatistic, eVar.doSrStatistic) && Intrinsics.areEqual(this.inputSize, eVar.inputSize) && Intrinsics.areEqual(this.outputSize, eVar.outputSize)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        Boolean bool = this.fromCache;
        int i3 = 0;
        if (bool == null) {
            hashCode = 0;
        } else {
            hashCode = bool.hashCode();
        }
        int i16 = hashCode * 31;
        b bVar = this.getSrInstanceStatistic;
        if (bVar == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = bVar.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        a aVar = this.doSrStatistic;
        if (aVar == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = aVar.hashCode();
        }
        int i18 = (i17 + hashCode3) * 31;
        Size size = this.inputSize;
        if (size == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = size.hashCode();
        }
        int i19 = (i18 + hashCode4) * 31;
        Size size2 = this.outputSize;
        if (size2 != null) {
            i3 = size2.hashCode();
        }
        return i19 + i3;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return "SrStatistics(fromCache=" + this.fromCache + ", getSrInstanceStatistic=" + this.getSrInstanceStatistic + ", doSrStatistic=" + this.doSrStatistic + ", inputSize=" + this.inputSize + ", outputSize=" + this.outputSize + ')';
    }

    public e(@Nullable Boolean bool, @Nullable b bVar, @Nullable a aVar, @Nullable Size size, @Nullable Size size2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, bool, bVar, aVar, size, size2);
            return;
        }
        this.fromCache = bool;
        this.getSrInstanceStatistic = bVar;
        this.doSrStatistic = aVar;
        this.inputSize = size;
        this.outputSize = size2;
    }

    public /* synthetic */ e(Boolean bool, b bVar, a aVar, Size size, Size size2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : bool, (i3 & 2) != 0 ? null : bVar, (i3 & 4) != 0 ? null : aVar, (i3 & 8) != 0 ? null : size, (i3 & 16) != 0 ? null : size2);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, bool, bVar, aVar, size, size2, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
