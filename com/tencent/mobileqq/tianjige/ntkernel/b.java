package com.tencent.mobileqq.tianjige.ntkernel;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0082\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u0012\u0006\u0010\u001e\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001f\u0010 J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0010\u001a\u0004\b\t\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001e\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/tianjige/ntkernel/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "name", "", "", "[Ljava/lang/Double;", "()[Ljava/lang/Double;", "boundary", "Lcom/tencent/mobileqq/tianjige/ntkernel/PublicSampleRate;", "c", "Lcom/tencent/mobileqq/tianjige/ntkernel/PublicSampleRate;", "getPubPolicy", "()Lcom/tencent/mobileqq/tianjige/ntkernel/PublicSampleRate;", "pubPolicy", "Lcom/tencent/mobileqq/tianjige/ntkernel/GraySampleRate;", "d", "Lcom/tencent/mobileqq/tianjige/ntkernel/GraySampleRate;", "getGrayPolicy", "()Lcom/tencent/mobileqq/tianjige/ntkernel/GraySampleRate;", "grayPolicy", "<init>", "(Ljava/lang/String;[Ljava/lang/Double;Lcom/tencent/mobileqq/tianjige/ntkernel/PublicSampleRate;Lcom/tencent/mobileqq/tianjige/ntkernel/GraySampleRate;)V", "QQCommon_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final /* data */ class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String name;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Double[] boundary;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PublicSampleRate pubPolicy;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GraySampleRate grayPolicy;

    public b(@NotNull String name, @NotNull Double[] boundary, @NotNull PublicSampleRate pubPolicy, @NotNull GraySampleRate grayPolicy) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(boundary, "boundary");
        Intrinsics.checkNotNullParameter(pubPolicy, "pubPolicy");
        Intrinsics.checkNotNullParameter(grayPolicy, "grayPolicy");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, name, boundary, pubPolicy, grayPolicy);
            return;
        }
        this.name = name;
        this.boundary = boundary;
        this.pubPolicy = pubPolicy;
        this.grayPolicy = grayPolicy;
    }

    @NotNull
    public final Double[] a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Double[]) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.boundary;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.name;
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
        if (Intrinsics.areEqual(this.name, bVar.name) && Intrinsics.areEqual(this.boundary, bVar.boundary) && this.pubPolicy == bVar.pubPolicy && this.grayPolicy == bVar.grayPolicy) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return (((((this.name.hashCode() * 31) + Arrays.hashCode(this.boundary)) * 31) + this.pubPolicy.hashCode()) * 31) + this.grayPolicy.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return "HistogramInfo(name=" + this.name + ", boundary=" + Arrays.toString(this.boundary) + ", pubPolicy=" + this.pubPolicy + ", grayPolicy=" + this.grayPolicy + ")";
    }
}
