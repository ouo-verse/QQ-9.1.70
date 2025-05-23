package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StUser;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002\u001a\u000e\u0010\u0004\u001a\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\u0001\u001a\f\u0010\u0005\u001a\u00020\u0002*\u00020\u0001H\u0000\u00a8\u0006\u0006"}, d2 = {"toCommon", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUser;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StUser;", "toCommonNonNull", "toPb", "toPbNonNull", "qecommerce-biz_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonUserKt {
    public static final CommonUser toCommonNonNull(StUser stUser) {
        CommonUser commonUser = new CommonUser();
        commonUser.setUin(stUser.uin);
        commonUser.setUid(stUser.uid);
        commonUser.setNick(stUser.nick);
        Boolean bool = stUser.isAnonymous;
        commonUser.setAnonymous(bool != null ? bool.booleanValue() : false);
        return commonUser;
    }

    public static final StUser toPbNonNull(CommonUser commonUser) {
        String uin = commonUser.getUin();
        return new StUser(commonUser.getUid(), commonUser.getNick(), null, null, null, null, null, null, null, null, null, null, uin, null, Boolean.valueOf(commonUser.getIsAnonymous()), null, 45052, null);
    }

    public static final CommonUser toCommon(StUser stUser) {
        if (stUser == null) {
            return null;
        }
        CommonUser commonUser = new CommonUser();
        commonUser.setUin(stUser.uin);
        commonUser.setUid(stUser.uid);
        commonUser.setNick(stUser.nick);
        Boolean bool = stUser.isAnonymous;
        commonUser.setAnonymous(bool != null ? bool.booleanValue() : false);
        return commonUser;
    }

    public static final StUser toPb(CommonUser commonUser) {
        if (commonUser == null) {
            return null;
        }
        String uin = commonUser.getUin();
        return new StUser(commonUser.getUid(), commonUser.getNick(), null, null, null, null, null, null, null, null, null, null, uin, null, Boolean.valueOf(commonUser.getIsAnonymous()), null, 45052, null);
    }
}
