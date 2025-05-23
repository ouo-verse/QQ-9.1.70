package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.personal_album;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonStUser;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StUser;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0002*\u00020\u0001\u00a8\u0006\u0004"}, d2 = {"toCommonStUser", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStUser;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StUser;", "toStUser", "qecommerce-biz_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class AlbumStUserConverterKt {
    public static final CommonStUser toCommonStUser(StUser stUser) {
        CommonStUser commonStUser = new CommonStUser();
        String str = stUser.uid;
        if (str == null) {
            str = "";
        }
        commonStUser.setUid(str);
        String str2 = stUser.uin;
        if (str2 == null) {
            str2 = "";
        }
        commonStUser.setUin(str2);
        String str3 = stUser.nick;
        commonStUser.setNick(str3 != null ? str3 : "");
        return commonStUser;
    }

    public static final StUser toStUser(CommonStUser commonStUser) {
        StUser stUser = new StUser(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 65535, null);
        stUser.uin = commonStUser.getUin();
        stUser.uid = commonStUser.getUid();
        stUser.nick = commonStUser.getNick();
        return stUser;
    }
}
