package com.tencent.cache.api.state;

import com.tencent.cache.api.Business;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.SetsKt__SetsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\"\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R)\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u000b\u001a\u0004\b\u0004\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/cache/api/state/a;", "", "", "Lcom/tencent/cache/api/Business;", "a", "Ljava/util/List;", "b", "()Ljava/util/List;", "mainEntranceList", "", "", "Ljava/util/Map;", "()Ljava/util/Map;", "affinityBusinessMap", "<init>", "()V", "Library_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes5.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<Business> mainEntranceList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<Business, Set<Business>> affinityBusinessMap;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f98635c;

    static {
        List<Business> listOf;
        Set of5;
        Map<Business, Set<Business>> mapOf;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13213);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f98635c = new a();
        Business business = Business.AIO;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Business[]{Business.Conversation, business, Business.Guild, Business.QCircle, Business.Contact, Business.Leba, Business.QZone, Business.Setting});
        mainEntranceList = listOf;
        of5 = SetsKt__SetsJVMKt.setOf(Business.Album);
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(business, of5));
        affinityBusinessMap = mapOf;
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final Map<Business, Set<Business>> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Map) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return affinityBusinessMap;
    }

    @NotNull
    public final List<Business> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return mainEntranceList;
    }
}
