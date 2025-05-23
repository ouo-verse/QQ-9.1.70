package com.tencent.mobileqq.troop.api;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J:\u0010\u0002\u001a\n\u0012\u0004\u0012\u0002H\u0004\u0018\u00010\u0003\"\u000e\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u0002H\u0004\u0018\u00010\tH&J(\u0010\n\u001a\u0004\u0018\u00010\u0007\"\u000e\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003H&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/troop/api/ITroopPbFieldApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "readPBRepeatMessageFromByteArray", "Lcom/tencent/mobileqq/pb/PBRepeatMessageField;", "T", "Lcom/tencent/mobileqq/pb/MessageMicro;", "bytes", "", "infoClass", "Ljava/lang/Class;", "writePBRepeatMessageToByteArray", "rptPbValue", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface ITroopPbFieldApi extends QRouteApi {
    @Nullable
    <T extends MessageMicro<T>> PBRepeatMessageField<T> readPBRepeatMessageFromByteArray(@Nullable byte[] bytes, @Nullable Class<T> infoClass);

    @Nullable
    <T extends MessageMicro<T>> byte[] writePBRepeatMessageToByteArray(@NotNull PBRepeatMessageField<T> rptPbValue);
}
