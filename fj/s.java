package fj;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u0005\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\b"}, d2 = {"Lfj/s;", "", "", "uin", "serviceNick", "a", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public static final s f399470a = new s();

    s() {
    }

    public final String a(String uin, String serviceNick) {
        if (serviceNick == null) {
            serviceNick = "";
        }
        if (!com.qzone.reborn.configx.g.f53821a.d().n()) {
            return serviceNick;
        }
        boolean z16 = true;
        if (uin == null || uin.length() == 0) {
            return serviceNick;
        }
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(uin);
        if (uidFromUin == null || uidFromUin.length() == 0) {
            return serviceNick;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(uidFromUin);
        ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> friendSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendSimpleInfoWithUid(arrayList, "groupAlbum");
        if ((friendSimpleInfoWithUid == null || friendSimpleInfoWithUid.isEmpty()) || !Intrinsics.areEqual(friendSimpleInfoWithUid.get(0).p(), serviceNick)) {
            return serviceNick;
        }
        String r16 = friendSimpleInfoWithUid.get(0).r();
        if (r16 != null && r16.length() != 0) {
            z16 = false;
        }
        if (z16) {
            return serviceNick;
        }
        String r17 = friendSimpleInfoWithUid.get(0).r();
        Intrinsics.checkNotNull(r17);
        return r17;
    }
}
