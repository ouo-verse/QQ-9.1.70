package com.tencent.mobileqq.ai.main.feeds;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.AiAvatarSubCategoryInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0014\u001a\u0004\b\u000e\u0010\u0015R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00018\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\t\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/ai/main/feeds/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "d", "()I", "type", "b", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "id", "Lcom/tencent/qqnt/kernel/nativeinterface/AiAvatarSubCategoryInfo;", "Lcom/tencent/qqnt/kernel/nativeinterface/AiAvatarSubCategoryInfo;", "()Lcom/tencent/qqnt/kernel/nativeinterface/AiAvatarSubCategoryInfo;", "feedsInfo", "Ljava/lang/Object;", "()Ljava/lang/Object;", "data", "<init>", "(ILjava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/AiAvatarSubCategoryInfo;Ljava/lang/Object;)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final /* data */ class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String id;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AiAvatarSubCategoryInfo feedsInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Object data;

    public a(int i3, @NotNull String id5, @NotNull AiAvatarSubCategoryInfo feedsInfo, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(feedsInfo, "feedsInfo");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), id5, feedsInfo, obj);
            return;
        }
        this.type = i3;
        this.id = id5;
        this.feedsInfo = feedsInfo;
        this.data = obj;
    }

    @Nullable
    public final Object a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.data;
    }

    @NotNull
    public final AiAvatarSubCategoryInfo b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (AiAvatarSubCategoryInfo) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.feedsInfo;
    }

    @NotNull
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.id;
    }

    public final int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.type;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        if (this.type == aVar.type && Intrinsics.areEqual(this.id, aVar.id) && Intrinsics.areEqual(this.feedsInfo, aVar.feedsInfo) && Intrinsics.areEqual(this.data, aVar.data)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        int hashCode2 = ((((this.type * 31) + this.id.hashCode()) * 31) + this.feedsInfo.hashCode()) * 31;
        Object obj = this.data;
        if (obj == null) {
            hashCode = 0;
        } else {
            hashCode = obj.hashCode();
        }
        return hashCode2 + hashCode;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return "AIAvatarFeedsInfo(type=" + this.type + ", id=" + this.id + ", feedsInfo=" + this.feedsInfo + ", data=" + this.data + ")";
    }
}
