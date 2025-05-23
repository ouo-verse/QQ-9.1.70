package com.tencent.mobileqq.troop.exp.model;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.recommend.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.guild_search_recommend_svr.guildSearchRecommendSvr$FirstShow;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001f\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/troop/exp/model/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "Lcom/tencent/mobileqq/troop/recommend/c$a;", "a", "Ljava/util/List;", "()Ljava/util/List;", "dataList", "Ltencent/im/oidb/guild_search_recommend_svr/guildSearchRecommendSvr$FirstShow;", "b", "Ltencent/im/oidb/guild_search_recommend_svr/guildSearchRecommendSvr$FirstShow;", "()Ltencent/im/oidb/guild_search_recommend_svr/guildSearchRecommendSvr$FirstShow;", "firstShow", "Lcom/tencent/mobileqq/pb/ByteStringMicro;", "c", "Lcom/tencent/mobileqq/pb/ByteStringMicro;", "()Lcom/tencent/mobileqq/pb/ByteStringMicro;", "sessionInfo", "<init>", "(Ljava/util/List;Ltencent/im/oidb/guild_search_recommend_svr/guildSearchRecommendSvr$FirstShow;Lcom/tencent/mobileqq/pb/ByteStringMicro;)V", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final /* data */ class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final List<c.a> dataList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final guildSearchRecommendSvr$FirstShow firstShow;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final ByteStringMicro sessionInfo;

    /* JADX WARN: Multi-variable type inference failed */
    public a(@Nullable List<? extends c.a> list, @NotNull guildSearchRecommendSvr$FirstShow firstShow, @Nullable ByteStringMicro byteStringMicro) {
        Intrinsics.checkNotNullParameter(firstShow, "firstShow");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, list, firstShow, byteStringMicro);
            return;
        }
        this.dataList = list;
        this.firstShow = firstShow;
        this.sessionInfo = byteStringMicro;
    }

    @Nullable
    public final List<c.a> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.dataList;
    }

    @NotNull
    public final guildSearchRecommendSvr$FirstShow b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (guildSearchRecommendSvr$FirstShow) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.firstShow;
    }

    @Nullable
    public final ByteStringMicro c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ByteStringMicro) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.sessionInfo;
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
        if (Intrinsics.areEqual(this.dataList, aVar.dataList) && Intrinsics.areEqual(this.firstShow, aVar.firstShow) && Intrinsics.areEqual(this.sessionInfo, aVar.sessionInfo)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        List<c.a> list = this.dataList;
        int i3 = 0;
        if (list == null) {
            hashCode = 0;
        } else {
            hashCode = list.hashCode();
        }
        int hashCode2 = ((hashCode * 31) + this.firstShow.hashCode()) * 31;
        ByteStringMicro byteStringMicro = this.sessionInfo;
        if (byteStringMicro != null) {
            i3 = byteStringMicro.hashCode();
        }
        return hashCode2 + i3;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return "TroopFirstPageData(dataList=" + this.dataList + ", firstShow=" + this.firstShow + ", sessionInfo=" + this.sessionInfo + ")";
    }
}
