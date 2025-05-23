package com.tencent.mobileqq.guild.api;

import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IGuildTRTCFocusApi extends QRouteApi {

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface a {
        void s();
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface b {
        void a(boolean z16);
    }

    void onReleaseTRTCFocus(@NonNull a aVar);

    void requestTRTCFocus(@NonNull a aVar, @NonNull b bVar, @Nullable Handler handler);
}
