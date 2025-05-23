package com.tencent.qqnt.aio.api.impl;

import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0016\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR(\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00168\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/qqnt/aio/api/impl/t;", "", "", "e", "", "toString", "", "hashCode", "other", "equals", "url", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "md5", "a", "setMd5", "time", "b", "setTime", "", "topBgEmojiIdList", "Ljava/util/List;", "c", "()Ljava/util/List;", "setTopBgEmojiIdList", "(Ljava/util/List;)V", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final /* data */ class t {
    static IPatchRedirector $redirector_;

    @SerializedName("md5")
    @NotNull
    private String md5;

    @SerializedName("time")
    @NotNull
    private String time;

    @SerializedName("topBgEmojiIdList")
    @NotNull
    private List<String> topBgEmojiIdList;

    @SerializedName("url")
    @NotNull
    private String url;

    public t() {
        this(null, null, null, null, 15, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 20)) {
            return;
        }
        iPatchRedirector.redirect((short) 20, (Object) this);
    }

    @NotNull
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.md5;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.time;
    }

    @NotNull
    public final List<String> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (List) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.topBgEmojiIdList;
    }

    @NotNull
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.url;
    }

    public final boolean e() {
        boolean z16;
        boolean z17;
        boolean z18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        if (this.url.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (this.md5.length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                if (this.time.length() > 0) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z18) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof t)) {
            return false;
        }
        t tVar = (t) other;
        if (Intrinsics.areEqual(this.url, tVar.url) && Intrinsics.areEqual(this.md5, tVar.md5) && Intrinsics.areEqual(this.time, tVar.time) && Intrinsics.areEqual(this.topBgEmojiIdList, tVar.topBgEmojiIdList)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        return (((((this.url.hashCode() * 31) + this.md5.hashCode()) * 31) + this.time.hashCode()) * 31) + this.topBgEmojiIdList.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return "EmoReplyAtmosphereInfo(url=" + this.url + ", md5=" + this.md5 + ", time=" + this.time + ", topBgEmojiIdList=" + this.topBgEmojiIdList + ")";
    }

    public t(@NotNull String url, @NotNull String md5, @NotNull String time, @NotNull List<String> topBgEmojiIdList) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(md5, "md5");
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(topBgEmojiIdList, "topBgEmojiIdList");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, url, md5, time, topBgEmojiIdList);
            return;
        }
        this.url = url;
        this.md5 = md5;
        this.time = time;
        this.topBgEmojiIdList = topBgEmojiIdList;
    }

    public /* synthetic */ t(String str, String str2, String str3, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) == 0 ? str3 : "", (i3 & 8) != 0 ? new ArrayList() : list);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, str2, str3, list, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
