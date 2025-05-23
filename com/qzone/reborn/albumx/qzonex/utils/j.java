package com.qzone.reborn.albumx.qzonex.utils;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u0005\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\b"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/utils/j;", "", "", "uin", "serviceNick", "a", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static final j f53413a = new j();

    j() {
    }

    public final String a(String uin, String serviceNick) {
        boolean z16 = true;
        if (!(serviceNick == null || serviceNick.length() == 0)) {
            return serviceNick;
        }
        if (uin == null || uin.length() == 0) {
            return "";
        }
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(uin);
        if (uidFromUin == null || uidFromUin.length() == 0) {
            return uin;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(uidFromUin);
        ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> friendSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendSimpleInfoWithUid(arrayList, "QZAlbumx");
        if (friendSimpleInfoWithUid == null || friendSimpleInfoWithUid.isEmpty()) {
            return uin;
        }
        String r16 = friendSimpleInfoWithUid.get(0).r();
        if (!(r16 == null || r16.length() == 0)) {
            String r17 = friendSimpleInfoWithUid.get(0).r();
            Intrinsics.checkNotNull(r17);
            return r17;
        }
        String p16 = friendSimpleInfoWithUid.get(0).p();
        if (p16 != null && p16.length() != 0) {
            z16 = false;
        }
        if (z16) {
            return uin;
        }
        String p17 = friendSimpleInfoWithUid.get(0).p();
        Intrinsics.checkNotNull(p17);
        return p17;
    }
}
