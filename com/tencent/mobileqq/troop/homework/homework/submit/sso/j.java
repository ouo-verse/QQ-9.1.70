package com.tencent.mobileqq.troop.homework.homework.submit.sso;

import com.google.protobuf.CodedOutputStream;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001d\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\b\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b(\u0010)J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\t\u0010\n\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u00d6\u0003R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0018\u0010\u0012R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u001b\u0010\u0012R\u0019\u0010\u001f\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0010\u001a\u0004\b\u001e\u0010\u0012R\u0019\u0010$\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0019\u0010'\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b%\u0010!\u001a\u0004\b&\u0010#\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/homework/submit/sso/j;", "Lcom/tencent/mobileqq/troop/homework/homework/submit/sso/a;", "Lcom/google/protobuf/CodedOutputStream;", "output", "", "writeTo", "", "getSerializedSize", "", "toString", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "getPoster", "()Ljava/lang/String;", QAdVrReport.ElementID.AD_POSTER, "b", "getTitle", "title", "c", "getSummary", "summary", "d", "getRealUrl", "realUrl", "e", "getUrl", "url", "f", "Ljava/lang/Integer;", "getWidth", "()Ljava/lang/Integer;", "width", "g", "getHeight", "height", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final /* data */ class j extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String poster;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String title;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String summary;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String realUrl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String url;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Integer width;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Integer height;

    public j(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable Integer num, @Nullable Integer num2) {
        super(null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, str3, str4, str5, num, num2);
            return;
        }
        this.poster = str;
        this.title = str2;
        this.summary = str3;
        this.realUrl = str4;
        this.url = str5;
        this.width = num;
        this.height = num2;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof j)) {
            return false;
        }
        j jVar = (j) other;
        if (Intrinsics.areEqual(this.poster, jVar.poster) && Intrinsics.areEqual(this.title, jVar.title) && Intrinsics.areEqual(this.summary, jVar.summary) && Intrinsics.areEqual(this.realUrl, jVar.realUrl) && Intrinsics.areEqual(this.url, jVar.url) && Intrinsics.areEqual(this.width, jVar.width) && Intrinsics.areEqual(this.height, jVar.height)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.troop.homework.homework.submit.sso.h
    public int getSerializedSize() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        String str = this.poster;
        int i27 = 0;
        if (str != null) {
            i3 = CodedOutputStream.V(1, str);
        } else {
            i3 = 0;
        }
        String str2 = this.title;
        if (str2 != null) {
            i16 = CodedOutputStream.V(2, str2);
        } else {
            i16 = 0;
        }
        int i28 = i3 + i16;
        String str3 = this.summary;
        if (str3 != null) {
            i17 = CodedOutputStream.V(3, str3);
        } else {
            i17 = 0;
        }
        int i29 = i28 + i17;
        String str4 = this.realUrl;
        if (str4 != null) {
            i18 = CodedOutputStream.V(4, str4);
        } else {
            i18 = 0;
        }
        int i36 = i29 + i18;
        String str5 = this.url;
        if (str5 != null) {
            i19 = CodedOutputStream.V(5, str5);
        } else {
            i19 = 0;
        }
        int i37 = i36 + i19;
        Integer num = this.width;
        if (num != null) {
            i26 = CodedOutputStream.x(6, num.intValue());
        } else {
            i26 = 0;
        }
        int i38 = i37 + i26;
        Integer num2 = this.height;
        if (num2 != null) {
            i27 = CodedOutputStream.x(7, num2.intValue());
        }
        return i38 + i27;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        String str = this.poster;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = hashCode * 31;
        String str2 = this.title;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        String str3 = this.summary;
        if (str3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str3.hashCode();
        }
        int i18 = (i17 + hashCode3) * 31;
        String str4 = this.realUrl;
        if (str4 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = str4.hashCode();
        }
        int i19 = (i18 + hashCode4) * 31;
        String str5 = this.url;
        if (str5 == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = str5.hashCode();
        }
        int i26 = (i19 + hashCode5) * 31;
        Integer num = this.width;
        if (num == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = num.hashCode();
        }
        int i27 = (i26 + hashCode6) * 31;
        Integer num2 = this.height;
        if (num2 != null) {
            i3 = num2.hashCode();
        }
        return i27 + i3;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return "VideoContent(poster=" + this.poster + ", title=" + this.title + ", summary=" + this.summary + ", realUrl=" + this.realUrl + ", url=" + this.url + ", width=" + this.width + ", height=" + this.height + ")";
    }

    @Override // com.tencent.mobileqq.troop.homework.homework.submit.sso.h
    public void writeTo(@NotNull CodedOutputStream output) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) output);
            return;
        }
        Intrinsics.checkNotNullParameter(output, "output");
        String str = this.poster;
        if (str != null) {
            output.Y0(1, str);
        }
        String str2 = this.title;
        if (str2 != null) {
            output.Y0(2, str2);
        }
        String str3 = this.summary;
        if (str3 != null) {
            output.Y0(3, str3);
        }
        String str4 = this.realUrl;
        if (str4 != null) {
            output.Y0(4, str4);
        }
        String str5 = this.url;
        if (str5 != null) {
            output.Y0(5, str5);
        }
        Integer num = this.width;
        if (num != null) {
            output.G0(6, num.intValue());
        }
        Integer num2 = this.height;
        if (num2 != null) {
            output.G0(7, num2.intValue());
        }
    }
}
