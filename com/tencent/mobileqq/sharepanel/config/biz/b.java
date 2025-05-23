package com.tencent.mobileqq.sharepanel.config.biz;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\tR \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/config/biz/b;", "", "", WadlProxyConsts.SCENE_ID, "Lcom/tencent/mobileqq/sharepanel/config/biz/c;", "b", "", "Lcom/tencent/mobileqq/sharepanel/config/biz/a;", "a", "Ljava/util/List;", "bizConfigList", "", "c", "Ljava/util/Map;", "bizInfoMap", "<init>", "()V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f287223a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<a> bizConfigList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, c> bizInfoMap;

    static {
        List<a> mutableListOf;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33027);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        f287223a = new b();
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new ShareActionCommonBizConfig(), new ShareActionRelationBizConfig(), new ShareActionRichMediaBizConfig(), new ShareActionStrangerBizConfig(), new ShareActionWinkBizConfig(), new ShareActionCommercialBizConfig(), new ShareActionTroopSettingBizConfig(), new ShareActionGuildFeedBizConfig(), new ShareActionGuildInfoConfig(), new ShareActionQzoneBizConfig());
        bizConfigList = mutableListOf;
        bizInfoMap = new LinkedHashMap();
        Iterator<a> it = mutableListOf.iterator();
        while (it.hasNext()) {
            for (c cVar : it.next().a()) {
                bizInfoMap.put(cVar.e(), cVar);
            }
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final List<a> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return bizConfigList;
    }

    @NotNull
    public final c b(@NotNull String sceneId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (c) iPatchRedirector.redirect((short) 2, (Object) this, (Object) sceneId);
        }
        Intrinsics.checkNotNullParameter(sceneId, "sceneId");
        c cVar = bizInfoMap.get(sceneId);
        if (cVar == null) {
            return new c(sceneId, null, null, null, null, 30, null);
        }
        return cVar;
    }
}
