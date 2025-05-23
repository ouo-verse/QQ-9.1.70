package com.tencent.qqnt.markdown.data.quote;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001f\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0011\u001a\u0004\b\n\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/markdown/data/quote/j;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/qqnt/markdown/data/quote/g;", "a", "Lcom/tencent/qqnt/markdown/data/quote/g;", "b", "()Lcom/tencent/qqnt/markdown/data/quote/g;", "loadingInfo", "", "Lcom/tencent/qqnt/markdown/data/quote/f;", "Ljava/util/List;", "()Ljava/util/List;", "contentDataList", "<init>", "(Lcom/tencent/qqnt/markdown/data/quote/g;Ljava/util/List;)V", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final /* data */ class j {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final g loadingInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final List<f> contentDataList;

    public j(@Nullable g gVar, @Nullable List<f> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) gVar, (Object) list);
        } else {
            this.loadingInfo = gVar;
            this.contentDataList = list;
        }
    }

    @Nullable
    public final List<f> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.contentDataList;
    }

    @Nullable
    public final g b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (g) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.loadingInfo;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof j)) {
            return false;
        }
        j jVar = (j) other;
        if (Intrinsics.areEqual(this.loadingInfo, jVar.loadingInfo) && Intrinsics.areEqual(this.contentDataList, jVar.contentDataList)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        g gVar = this.loadingInfo;
        int i3 = 0;
        if (gVar == null) {
            hashCode = 0;
        } else {
            hashCode = gVar.hashCode();
        }
        int i16 = hashCode * 31;
        List<f> list = this.contentDataList;
        if (list != null) {
            i3 = list.hashCode();
        }
        return i16 + i3;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return "QuoteViewData(loadingInfo=" + this.loadingInfo + ", contentDataList=" + this.contentDataList + ')';
    }
}
