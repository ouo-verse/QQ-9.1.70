package com.tencent.luggage.wxa.q7;

import android.content.Context;
import android.content.res.AssetManager;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public static final x f138214a = new x();

    /* renamed from: b, reason: collision with root package name */
    public static int f138215b;

    public final AssetManager a(Context context, AssetManager assetManager) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(assetManager, "assetManager");
        int hashCode = assetManager.hashCode();
        if (hashCode != f138215b) {
            com.tencent.luggage.wxa.tn.w.d("Luggage.WxaAssetsHandleImpl", "pre init assetsmanager");
            f138215b = hashCode;
            m.f138016a.a(context);
        }
        AssetManager assets = context.getAssets();
        Intrinsics.checkNotNullExpressionValue(assets, "context.assets");
        return assets;
    }
}
