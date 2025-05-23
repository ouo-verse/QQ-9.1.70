package com.tencent.biz.pubaccount.weishi.setting.req;

import UserGrowth.stNewUserSettingItem;
import UserGrowth.stSchema;
import UserGrowth.stSetUserSettingListReq;
import UserGrowth.stSetUserSettingListRsp;
import com.tencent.biz.pubaccount.weishi.net.common.g;
import com.tencent.mobileqq.msf.core.f0.c.e.h;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/setting/req/WSSetSettingRequest;", "Lcom/tencent/biz/pubaccount/weishi/net/common/g;", "LUserGrowth/stSetUserSettingListRsp;", "Ljava/lang/Class;", "getRspClass", "", "protocolType", "", h.f248218g, "<init>", "(IZ)V", "Companion", "a", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class WSSetSettingRequest extends g<stSetUserSettingListRsp> {
    private static final String CMD = "SetUserSettingList";

    public WSSetSettingRequest(int i3, boolean z16) {
        super(CMD);
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new stNewUserSettingItem(i3, z16 ? 1 : 0, new stSchema()));
        this.req = new stSetUserSettingListReq(arrayListOf);
    }

    @Override // com.tencent.biz.pubaccount.weishi.net.common.g
    public Class<stSetUserSettingListRsp> getRspClass() {
        return stSetUserSettingListRsp.class;
    }
}
