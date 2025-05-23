package com.tencent.mobileqq.reminder.db;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0011\u0010\u0003\u001a\u0004\u0018\u00018\u0000H&\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\t\u0010\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/reminder/db/c;", "T", "Lcom/tencent/mobileqq/reminder/db/b;", "getMsgBody", "()Ljava/lang/Object;", "body", "", "setMsgBody", "(Ljava/lang/Object;)V", "createMsgBody", "qqreminder-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public interface c<T> extends b {
    T createMsgBody() throws Exception;

    @Nullable
    T getMsgBody();

    void setMsgBody(T body);
}
