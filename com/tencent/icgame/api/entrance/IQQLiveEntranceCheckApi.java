package com.tencent.icgame.api.entrance;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes7.dex */
public interface IQQLiveEntranceCheckApi extends QRouteApi {
    void checkEntrance(Context context, @NonNull QQLiveEntrance qQLiveEntrance, @NonNull Bundle bundle, @NonNull a aVar);
}
