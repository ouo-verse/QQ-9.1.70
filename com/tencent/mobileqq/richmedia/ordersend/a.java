package com.tencent.mobileqq.richmedia.ordersend;

import android.view.View;
import com.tencent.mobileqq.activity.aio.r;
import com.tencent.mobileqq.app.BaseMessageObserver;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService;

/* compiled from: P */
/* loaded from: classes18.dex */
public interface a {
    void a(MessageRecord messageRecord);

    void b(View view, r rVar);

    void c(MessageRecord messageRecord, BaseMessageObserver baseMessageObserver, IOrderMediaMsgService.a aVar);

    boolean d(MessageRecord messageRecord);

    boolean e(int i3);

    int f(MessageRecord messageRecord);

    String g(MessageRecord messageRecord);

    boolean h(String str);

    boolean i(MessageRecord messageRecord);

    boolean j(int i3);

    void removeCompressTask(long j3);
}
