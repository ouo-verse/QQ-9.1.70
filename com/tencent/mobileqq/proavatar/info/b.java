package com.tencent.mobileqq.proavatar.info;

import com.tencent.mobileqq.proavatar.group.GroupUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.avatar.meta.info.f;
import com.tencent.qqnt.avatar.meta.refresh.RefreshMapping;
import com.tencent.qqnt.troopmemberlist.ITroopMemberExtInfoRepoApi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00052\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R0\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\nj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b`\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/proavatar/info/b;", "Lcom/tencent/qqnt/avatar/meta/info/f;", "", "troopUin", "", "b", "Lcom/tencent/qqnt/avatar/meta/a;", "avatarBean", "", "a", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "troopRequestMap", "<init>", "()V", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class b implements f {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, Boolean> troopRequestMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/proavatar/info/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.proavatar.info.b$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17925);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.troopRequestMap = new HashMap<>();
        }
    }

    private final void b(String troopUin) {
        QLog.i("ProAvatarComponentInit", 2, "getTroopMemberListFromServer " + troopUin);
        ((ITroopMemberExtInfoRepoApi) QRoute.api(ITroopMemberExtInfoRepoApi.class)).fetchNewTroopHeadUinList(troopUin);
    }

    @Override // com.tencent.qqnt.avatar.meta.info.f
    @Nullable
    public List<com.tencent.qqnt.avatar.meta.a> a(@NotNull com.tencent.qqnt.avatar.meta.a avatarBean) {
        List<com.tencent.qqnt.avatar.meta.a> emptyList;
        List<com.tencent.qqnt.avatar.meta.a> emptyList2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) avatarBean);
        }
        Intrinsics.checkNotNullParameter(avatarBean, "avatarBean");
        if (4 != avatarBean.a() && 113 != avatarBean.a()) {
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            return emptyList2;
        }
        GroupUtil groupUtil = GroupUtil.f259599a;
        String c16 = avatarBean.c();
        Intrinsics.checkNotNull(c16);
        if (groupUtil.l(c16)) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        String c17 = avatarBean.c();
        Intrinsics.checkNotNull(c17);
        ArrayList<String> j3 = groupUtil.j(c17);
        QLog.i("GroupAvatarHelper", 2, "getNewGroupInfo avatarBean.id " + avatarBean.c() + " " + j3);
        if (j3.isEmpty()) {
            HashMap<String, Boolean> hashMap = this.troopRequestMap;
            String c18 = avatarBean.c();
            Intrinsics.checkNotNull(c18);
            Boolean bool = hashMap.get(c18);
            Boolean bool2 = Boolean.TRUE;
            if (!Intrinsics.areEqual(bool, bool2)) {
                String c19 = avatarBean.c();
                Intrinsics.checkNotNull(c19);
                b(c19);
                HashMap<String, Boolean> hashMap2 = this.troopRequestMap;
                String c26 = avatarBean.c();
                Intrinsics.checkNotNull(c26);
                hashMap2.put(c26, bool2);
                return null;
            }
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = j3.iterator();
        while (it.hasNext()) {
            String next = it.next();
            RefreshMapping.f352936a.b(1, next, new com.tencent.qqnt.avatar.meta.refresh.bean.a(avatarBean.c(), avatarBean.a()));
            arrayList.add(new com.tencent.qqnt.avatar.meta.a(0, 1, next, avatarBean.e()));
        }
        return arrayList;
    }
}
