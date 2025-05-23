package com.tencent.timi.game.api.entrance;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import hf4.a;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes26.dex */
public interface IQQLiveEntranceCheckApi extends QRouteApi {
    void checkEntrance(Context context, @NonNull Bundle bundle, @NonNull a aVar);
}
