package com.tencent.mobileqq.troop.homework.homework.submit.sso;

import com.google.protobuf.CodedOutputStream;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\t\u0010\n\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u00d6\u0003R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u001a\u0010\u0017\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/homework/submit/sso/k;", "Lcom/tencent/mobileqq/troop/homework/homework/submit/sso/a;", "Lcom/google/protobuf/CodedOutputStream;", "output", "", "writeTo", "", "getSerializedSize", "", "toString", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", "url", "b", "Ljava/lang/Integer;", "getTime", "()Ljava/lang/Integer;", "time", "c", "getSize", "size", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final /* data */ class k extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String url;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Integer time;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Integer size;

    public k(@Nullable String str, @Nullable Integer num, @Nullable Integer num2) {
        super(null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, num, num2);
            return;
        }
        this.url = str;
        this.time = num;
        this.size = num2;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof k)) {
            return false;
        }
        k kVar = (k) other;
        if (Intrinsics.areEqual(this.url, kVar.url) && Intrinsics.areEqual(this.time, kVar.time) && Intrinsics.areEqual(this.size, kVar.size)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.troop.homework.homework.submit.sso.h
    public int getSerializedSize() {
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        String str = this.url;
        int i17 = 0;
        if (str != null) {
            i3 = CodedOutputStream.V(1, str);
        } else {
            i3 = 0;
        }
        Integer num = this.time;
        if (num != null) {
            i16 = CodedOutputStream.x(2, num.intValue());
        } else {
            i16 = 0;
        }
        int i18 = i3 + i16;
        Integer num2 = this.size;
        if (num2 != null) {
            i17 = CodedOutputStream.x(3, num2.intValue());
        }
        return i18 + i17;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        String str = this.url;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = hashCode * 31;
        Integer num = this.time;
        if (num == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = num.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        Integer num2 = this.size;
        if (num2 != null) {
            i3 = num2.hashCode();
        }
        return i17 + i3;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return "VoiceContent(url=" + this.url + ", time=" + this.time + ", size=" + this.size + ")";
    }

    @Override // com.tencent.mobileqq.troop.homework.homework.submit.sso.h
    public void writeTo(@NotNull CodedOutputStream output) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) output);
            return;
        }
        Intrinsics.checkNotNullParameter(output, "output");
        String str = this.url;
        if (str != null) {
            output.Y0(1, str);
        }
        Integer num = this.time;
        if (num != null) {
            output.G0(2, num.intValue());
        }
        Integer num2 = this.size;
        if (num2 != null) {
            output.G0(3, num2.intValue());
        }
    }
}
