package com.tencent.imsdk.v2;

import com.tencent.imsdk.message.MessageSearchResult;
import com.tencent.imsdk.message.MessageSearchResultItem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class V2TIMMessageSearchResult implements Serializable {
    private MessageSearchResult messageSearchResult;

    public List<V2TIMMessageSearchResultItem> getMessageSearchResultItems() {
        if (this.messageSearchResult != null) {
            ArrayList arrayList = new ArrayList();
            for (MessageSearchResultItem messageSearchResultItem : this.messageSearchResult.getMessageSearchResultItemList()) {
                V2TIMMessageSearchResultItem v2TIMMessageSearchResultItem = new V2TIMMessageSearchResultItem();
                v2TIMMessageSearchResultItem.setMessageSearchResultItem(messageSearchResultItem);
                arrayList.add(v2TIMMessageSearchResultItem);
            }
            return arrayList;
        }
        return null;
    }

    public int getTotalCount() {
        MessageSearchResult messageSearchResult = this.messageSearchResult;
        if (messageSearchResult != null) {
            return messageSearchResult.getTotalCount();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMessageSearchResult(MessageSearchResult messageSearchResult) {
        this.messageSearchResult = messageSearchResult;
    }
}
