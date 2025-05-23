package com.tencent.gathererga.core;

import android.content.Context;

/* loaded from: classes6.dex */
public interface AppInfoProvider extends com.tencent.gathererga.core.internal.c {
    f getAppVersionName(e eVar);

    f getPackageName(e eVar);

    @Override // com.tencent.gathererga.core.internal.c
    /* synthetic */ void onInit(Context context);
}
