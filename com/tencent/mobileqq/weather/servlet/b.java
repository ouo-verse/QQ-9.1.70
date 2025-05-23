package com.tencent.mobileqq.weather.servlet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.vas.adv.common.data.VasAdvServiceCode;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\bf\u0018\u0000*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0003J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u0006\u0010\u0007J\"\u0010\u000e\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/weather/servlet/b;", "Lcom/tencent/mobileqq/pb/MessageMicro;", "T", "", "rsp", "", "a", "(Lcom/tencent/mobileqq/pb/MessageMicro;)V", "Lcom/tencent/mobileqq/vas/adv/common/data/VasAdvServiceCode;", "code", "", "errMsg", "", "e", "b", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public interface b<T extends MessageMicro<T>> {
    void a(@NotNull T rsp);

    void b(@NotNull VasAdvServiceCode code, @NotNull String errMsg, @Nullable Throwable e16);
}
