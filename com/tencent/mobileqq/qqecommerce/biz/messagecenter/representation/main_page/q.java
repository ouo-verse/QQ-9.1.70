package com.tencent.mobileqq.qqecommerce.biz.messagecenter.representation.main_page;

import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.MessageType;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import zf2.MessageSettingItem;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a.\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u0005*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0002\u00a8\u0006\u0007"}, d2 = {"", "Lzf2/c;", "Ljava/util/HashMap;", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/c;", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/e;", "Lkotlin/collections/HashMap;", "b", "qqecommerce_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class q {
    /* JADX INFO: Access modifiers changed from: private */
    public static final HashMap<MessageType, com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.e> b(List<MessageSettingItem> list) {
        HashMap<MessageType, com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.e> hashMap = new HashMap<>();
        for (MessageSettingItem messageSettingItem : list) {
            hashMap.put(messageSettingItem.getType(), messageSettingItem.getStatus());
        }
        return hashMap;
    }
}
