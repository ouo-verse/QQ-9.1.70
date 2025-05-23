package com.tencent.mobileqq.ptt.temp.api;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQQRecorderTempApi extends QRouteApi {
    long AudioHelper_enlargeVolumWrapper(Context context, byte[] bArr, int i3, float f16);

    int getFilePlayTime(MessageRecord messageRecord);

    int getFilePlayTime(@NonNull String str);
}
