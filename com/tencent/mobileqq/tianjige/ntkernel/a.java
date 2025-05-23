package com.tencent.mobileqq.tianjige.ntkernel;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/tianjige/ntkernel/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getScene", "()Ljava/lang/String;", "scene", "Lcom/tencent/mobileqq/tianjige/ntkernel/PublicSampleRate;", "b", "Lcom/tencent/mobileqq/tianjige/ntkernel/PublicSampleRate;", "getPubPolicy", "()Lcom/tencent/mobileqq/tianjige/ntkernel/PublicSampleRate;", "pubPolicy", "Lcom/tencent/mobileqq/tianjige/ntkernel/GraySampleRate;", "c", "Lcom/tencent/mobileqq/tianjige/ntkernel/GraySampleRate;", "getGrayPolicy", "()Lcom/tencent/mobileqq/tianjige/ntkernel/GraySampleRate;", "grayPolicy", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/tianjige/ntkernel/PublicSampleRate;Lcom/tencent/mobileqq/tianjige/ntkernel/GraySampleRate;)V", "QQCommon_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
final /* data */ class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String scene;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PublicSampleRate pubPolicy;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GraySampleRate grayPolicy;

    public a(@NotNull String scene, @NotNull PublicSampleRate pubPolicy, @NotNull GraySampleRate grayPolicy) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(pubPolicy, "pubPolicy");
        Intrinsics.checkNotNullParameter(grayPolicy, "grayPolicy");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, scene, pubPolicy, grayPolicy);
            return;
        }
        this.scene = scene;
        this.pubPolicy = pubPolicy;
        this.grayPolicy = grayPolicy;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        if (Intrinsics.areEqual(this.scene, aVar.scene) && this.pubPolicy == aVar.pubPolicy && this.grayPolicy == aVar.grayPolicy) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return (((this.scene.hashCode() * 31) + this.pubPolicy.hashCode()) * 31) + this.grayPolicy.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return "CountInfo(scene=" + this.scene + ", pubPolicy=" + this.pubPolicy + ", grayPolicy=" + this.grayPolicy + ")";
    }
}
