package com.tencent.mobileqq.reminder.api.impl;

import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.f;
import com.tencent.mobileqq.reminder.api.IQQReminderTempApi;
import com.tencent.mobileqq.service.message.codec.decoder.msgType0x210.j;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/reminder/api/impl/QQReminderTempApiImpl;", "Lcom/tencent/mobileqq/reminder/api/IQQReminderTempApi;", "", "Lcom/tencent/mobileqq/reminder/push/a;", "get0x210PushProcessor", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class QQReminderTempApiImpl implements IQQReminderTempApi {
    @Override // com.tencent.mobileqq.reminder.api.IQQReminderTempApi
    public List<com.tencent.mobileqq.reminder.push.a> get0x210PushProcessor() {
        List<com.tencent.mobileqq.reminder.push.a> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.mobileqq.reminder.push.a[]{new f(), new j()});
        return listOf;
    }
}
