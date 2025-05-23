package com.tencent.mobileqq.guild.nt.misc.api;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IJumpApi extends QRouteApi {

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class a {
    }

    boolean doJumpAction(Context context, String str);

    boolean doJumpAction(AppRuntime appRuntime, Context context, String str);

    boolean doJumpAction(@NonNull AppRuntime appRuntime, Context context, String str, a aVar);
}
