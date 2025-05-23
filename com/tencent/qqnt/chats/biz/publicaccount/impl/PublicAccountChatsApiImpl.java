package com.tencent.qqnt.chats.biz.publicaccount.impl;

import com.tencent.biz.pubaccount.util.j;
import com.tencent.mobileqq.R;
import com.tencent.qqnt.chats.biz.publicaccount.IPublicAccountChatsApi;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016\u00a2\u0006\u0002\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/chats/biz/publicaccount/impl/PublicAccountChatsApiImpl;", "Lcom/tencent/qqnt/chats/biz/publicaccount/IPublicAccountChatsApi;", "()V", "getPublicAccountFolderIconResId", "", "getPublicAccountFolderName", "", "getPublicAccountIcon", "uin", "", "(Ljava/lang/Long;)Ljava/lang/Integer;", "qqpubaccount_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class PublicAccountChatsApiImpl implements IPublicAccountChatsApi {
    @Override // com.tencent.qqnt.chats.biz.publicaccount.IPublicAccountChatsApi
    public int getPublicAccountFolderIconResId() {
        return j.INSTANCE.g() ? R.drawable.goc : R.drawable.mpv;
    }

    @Override // com.tencent.qqnt.chats.biz.publicaccount.IPublicAccountChatsApi
    public String getPublicAccountFolderName() {
        if (j.INSTANCE.g()) {
            return "\u516c\u4f17\u53f7";
        }
        return "\u8ba2\u9605\u53f7";
    }

    @Override // com.tencent.qqnt.chats.biz.publicaccount.IPublicAccountChatsApi
    public Integer getPublicAccountIcon(Long uin) {
        if (uin == null || uin.longValue() == 0) {
            return null;
        }
        long longValue = uin.longValue();
        if (longValue == 3247658747L) {
            return Integer.valueOf(R.drawable.goh);
        }
        if (longValue == 2909288299L) {
            return Integer.valueOf(R.drawable.goi);
        }
        if (longValue == 2241957680L) {
            return Integer.valueOf(R.drawable.god);
        }
        if (longValue == 2747277822L) {
            return Integer.valueOf(R.drawable.goj);
        }
        if (longValue == 2711679534L) {
            return Integer.valueOf(R.drawable.gog);
        }
        if (longValue == 2010741172) {
            return Integer.valueOf(R.drawable.goe);
        }
        if (longValue == 3026775809L) {
            return Integer.valueOf(R.drawable.gof);
        }
        return null;
    }
}
