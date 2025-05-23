package com.tencent.imsdk.v2;

import com.tencent.imsdk.common.IMCallback;
import com.tencent.imsdk.message.MergerElement;
import com.tencent.imsdk.message.Message;
import com.tencent.imsdk.message.MessageCenter;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class V2TIMMergerElem extends V2TIMElem {
    public void downloadMergerMessage(final V2TIMValueCallback<List<V2TIMMessage>> v2TIMValueCallback) {
        if (getElement() == null) {
            return;
        }
        MessageCenter.getInstance().downloadRelayMessageList(getMessage(), new IMCallback<List<Message>>(new V2TIMValueCallback<List<Message>>() { // from class: com.tencent.imsdk.v2.V2TIMMergerElem.1
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i3, String str) {
                V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                if (v2TIMValueCallback2 != null) {
                    v2TIMValueCallback2.onError(i3, str);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(List<Message> list) {
                ArrayList arrayList = new ArrayList();
                for (Message message : list) {
                    V2TIMMessage v2TIMMessage = new V2TIMMessage();
                    v2TIMMessage.setMessage(message);
                    arrayList.add(v2TIMMessage);
                }
                V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                if (v2TIMValueCallback2 != null) {
                    v2TIMValueCallback2.onSuccess(arrayList);
                }
            }
        }) { // from class: com.tencent.imsdk.v2.V2TIMMergerElem.2
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i3, String str) {
                super.fail(i3, str);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(List<Message> list) {
                super.success((AnonymousClass2) list);
            }
        });
    }

    public List<String> getAbstractList() {
        if (getElement() == null) {
            return null;
        }
        return ((MergerElement) getElement()).getAbstractList();
    }

    public String getTitle() {
        if (getElement() == null) {
            return null;
        }
        return ((MergerElement) getElement()).getTitle();
    }

    public boolean isLayersOverLimit() {
        if (getElement() == null) {
            return false;
        }
        return ((MergerElement) getElement()).isLayerOverLimit();
    }

    public String toString() {
        return "V2TIMRelayElem--->title:" + getTitle() + ", abstractList:" + getAbstractList();
    }
}
