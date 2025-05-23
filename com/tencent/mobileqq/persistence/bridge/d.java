package com.tencent.mobileqq.persistence.bridge;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.entitymanager.Provider;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.service.message.q;

/* compiled from: P */
/* loaded from: classes16.dex */
public class d implements Provider<Entity[]> {

    /* renamed from: a, reason: collision with root package name */
    private Entity[] f258317a = {new DataLineMsgRecord(1), a()};

    private MessageRecord a() {
        MessageRecord d16 = q.d(-1000);
        d16.frienduin = AppConstants.LBS_HELLO_UIN;
        d16.istroop = 1001;
        return d16;
    }

    @Override // com.tencent.mobileqq.data.entitymanager.Provider
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Entity[] get() {
        return this.f258317a;
    }
}
