package com.tencent.mobileqq.sharepanel.api;

import com.tencent.mobileqq.sharepanel.model.b;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003J;\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00018\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&\u00a2\u0006\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/api/a;", "Lcom/tencent/mobileqq/sharepanel/model/b;", "T", "", "", "isSuccess", "", "errCode", "", "errMsg", "shareData", "", "bizData", "", "a", "(ZILjava/lang/String;Lcom/tencent/mobileqq/sharepanel/model/b;[B)V", "qq-sharepanel-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public interface a<T extends b> {
    void a(boolean isSuccess, int errCode, @NotNull String errMsg, @Nullable T shareData, @Nullable byte[] bizData);
}
