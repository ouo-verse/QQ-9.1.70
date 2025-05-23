package com.tencent.mobileqq.troop.viewmodel;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\b\b\u0002\u0010 \u001a\u00020\u0007\u00a2\u0006\u0004\b!\u0010\"J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\n\u001a\u0004\b\t\u0010\f\"\u0004\b\u0015\u0010\u000eR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0017\u0010\u000eR\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\"\u0010 \u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001c\u001a\u0004\b\u0014\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/troop/viewmodel/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "setRowKey", "(Ljava/lang/String;)V", "rowKey", "b", "e", "setSeq", "seq", "c", "setCommentNumValue", "commentNumValue", "setLikeNumValue", "likeNumValue", "f", "setShareNumValue", "shareNumValue", "Z", "()Z", "setLikedValue", "(Z)V", "likedValue", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final /* data */ class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String rowKey;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String seq;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String commentNumValue;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String likeNumValue;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String shareNumValue;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean likedValue;

    public d(@NotNull String rowKey, @NotNull String seq, @NotNull String commentNumValue, @NotNull String likeNumValue, @NotNull String shareNumValue, boolean z16) {
        Intrinsics.checkNotNullParameter(rowKey, "rowKey");
        Intrinsics.checkNotNullParameter(seq, "seq");
        Intrinsics.checkNotNullParameter(commentNumValue, "commentNumValue");
        Intrinsics.checkNotNullParameter(likeNumValue, "likeNumValue");
        Intrinsics.checkNotNullParameter(shareNumValue, "shareNumValue");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, rowKey, seq, commentNumValue, likeNumValue, shareNumValue, Boolean.valueOf(z16));
            return;
        }
        this.rowKey = rowKey;
        this.seq = seq;
        this.commentNumValue = commentNumValue;
        this.likeNumValue = likeNumValue;
        this.shareNumValue = shareNumValue;
        this.likedValue = z16;
    }

    @NotNull
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.commentNumValue;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.likeNumValue;
    }

    public final boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return this.likedValue;
    }

    @NotNull
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.rowKey;
    }

    @NotNull
    public final String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.seq;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof d)) {
            return false;
        }
        d dVar = (d) other;
        if (Intrinsics.areEqual(this.rowKey, dVar.rowKey) && Intrinsics.areEqual(this.seq, dVar.seq) && Intrinsics.areEqual(this.commentNumValue, dVar.commentNumValue) && Intrinsics.areEqual(this.likeNumValue, dVar.likeNumValue) && Intrinsics.areEqual(this.shareNumValue, dVar.shareNumValue) && this.likedValue == dVar.likedValue) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.shareNumValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this)).intValue();
        }
        int hashCode = ((((((((this.rowKey.hashCode() * 31) + this.seq.hashCode()) * 31) + this.commentNumValue.hashCode()) * 31) + this.likeNumValue.hashCode()) * 31) + this.shareNumValue.hashCode()) * 31;
        boolean z16 = this.likedValue;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (String) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return "SocialBottomBarData(rowKey=" + this.rowKey + ", seq=" + this.seq + ", commentNumValue=" + this.commentNumValue + ", likeNumValue=" + this.likeNumValue + ", shareNumValue=" + this.shareNumValue + ", likedValue=" + this.likedValue + ")";
    }
}
