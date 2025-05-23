package com.tencent.mobileqq.qqlive.sail.model.audience;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\b\b\u0002\u0010 \u001a\u00020\u0002\u00a2\u0006\u0004\b!\u0010\"J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\t\u0010\u0015R\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u0017\u0010\fR\u0017\u0010\u001c\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u001a\u001a\u0004\b\u0013\u0010\u001bR\"\u0010 \u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\n\u001a\u0004\b\u001d\u0010\f\"\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/model/audience/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "name", "Lcom/tencent/mobileqq/qqlive/sail/model/audience/StreamDefinition;", "b", "Lcom/tencent/mobileqq/qqlive/sail/model/audience/StreamDefinition;", "()Lcom/tencent/mobileqq/qqlive/sail/model/audience/StreamDefinition;", "definition", "c", "I", "()I", "bitrate", "e", "url", "Lcom/tencent/mobileqq/qqlive/sail/model/audience/StreamFormat;", "Lcom/tencent/mobileqq/qqlive/sail/model/audience/StreamFormat;", "()Lcom/tencent/mobileqq/qqlive/sail/model/audience/StreamFormat;", "format", "f", "g", "(Ljava/lang/String;)V", "urlWithToken", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/qqlive/sail/model/audience/StreamDefinition;ILjava/lang/String;Lcom/tencent/mobileqq/qqlive/sail/model/audience/StreamFormat;Ljava/lang/String;)V", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final /* data */ class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String name;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final StreamDefinition definition;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int bitrate;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String url;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final StreamFormat format;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String urlWithToken;

    public a(@NotNull String name, @NotNull StreamDefinition definition, int i3, @NotNull String url, @NotNull StreamFormat format, @NotNull String urlWithToken) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(definition, "definition");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(format, "format");
        Intrinsics.checkNotNullParameter(urlWithToken, "urlWithToken");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, name, definition, Integer.valueOf(i3), url, format, urlWithToken);
            return;
        }
        this.name = name;
        this.definition = definition;
        this.bitrate = i3;
        this.url = url;
        this.format = format;
        this.urlWithToken = urlWithToken;
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.bitrate;
    }

    @NotNull
    public final StreamDefinition b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (StreamDefinition) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.definition;
    }

    @NotNull
    public final StreamFormat c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (StreamFormat) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.format;
    }

    @NotNull
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.name;
    }

    @NotNull
    public final String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.url;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        if (Intrinsics.areEqual(this.name, aVar.name) && this.definition == aVar.definition && this.bitrate == aVar.bitrate && Intrinsics.areEqual(this.url, aVar.url) && this.format == aVar.format && Intrinsics.areEqual(this.urlWithToken, aVar.urlWithToken)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.urlWithToken;
    }

    public final void g(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.urlWithToken = str;
        }
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        return (((((((((this.name.hashCode() * 31) + this.definition.hashCode()) * 31) + this.bitrate) * 31) + this.url.hashCode()) * 31) + this.format.hashCode()) * 31) + this.urlWithToken.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return "StreamInfo(name=" + this.name + ", definition=" + this.definition + ", bitrate=" + this.bitrate + ", url=" + this.url + ", format=" + this.format + ", urlWithToken=" + this.urlWithToken + ")";
    }

    public /* synthetic */ a(String str, StreamDefinition streamDefinition, int i3, String str2, StreamFormat streamFormat, String str3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, streamDefinition, i3, str2, streamFormat, (i16 & 32) != 0 ? "" : str3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, streamDefinition, Integer.valueOf(i3), str2, streamFormat, str3, Integer.valueOf(i16), defaultConstructorMarker);
    }
}
