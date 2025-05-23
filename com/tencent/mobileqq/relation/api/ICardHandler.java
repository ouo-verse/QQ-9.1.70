package com.tencent.mobileqq.relation.api;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
@QAPI(process = {""})
/* loaded from: classes17.dex */
public interface ICardHandler extends QRouteApi {

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public interface a {
        void a(boolean z16, List<AutoReplyText> list, int i3);

        void b(boolean z16);
    }

    void getAutoReplyList();

    BusinessObserver newCardHandlerForAutoReply(a aVar);

    void setAutoReplyList(ArrayList<AutoReplyText> arrayList, int i3, int i16, boolean z16);
}
