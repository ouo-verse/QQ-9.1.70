package com.tencent.qqnt.aio.api.impl;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.aio.data.AIOParam;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.aio.AIODrawableUtils;
import com.tencent.qqnt.aio.api.IAIOImmersiveApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.robot.aio.background.api.IRobotBackgroundApi;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J,\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/aio/api/impl/AIOImmersiveApiImpl;", "Lcom/tencent/qqnt/aio/api/IAIOImmersiveApi;", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "enableImmersive", "Landroid/content/Context;", "context", "Landroid/graphics/drawable/Drawable;", "originDrawable", "", "shortcutBarHeight", "Lkotlin/Pair;", "getImmersiveDrawable", "getNavigationBarSwitch", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class AIOImmersiveApiImpl implements IAIOImmersiveApi {
    @Override // com.tencent.qqnt.aio.api.IAIOImmersiveApi
    public boolean enableImmersive(com.tencent.aio.api.runtime.a aioContext) {
        String valueOf;
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        if (!aioContext.g().l().getBoolean("key_open_color_palette", false) || com.tencent.mobileqq.aio.a.c(aioContext)) {
            return false;
        }
        int e16 = aioContext.g().r().c().e();
        String j3 = aioContext.g().r().c().j();
        AIOParam g16 = aioContext.g();
        Intrinsics.checkNotNullExpressionValue(g16, "aioContext.aioParam");
        long a16 = su3.c.a(g16);
        if (e16 != 1) {
            return false;
        }
        if (a16 == 0) {
            valueOf = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid(j3);
        } else {
            valueOf = String.valueOf(a16);
        }
        return ((IRobotBackgroundApi) QRoute.api(IRobotBackgroundApi.class)).checkImmersiveAIO(valueOf, Integer.valueOf(e16));
    }

    @Override // com.tencent.qqnt.aio.api.IAIOImmersiveApi
    public Pair<Drawable, Drawable> getImmersiveDrawable(Context context, Drawable originDrawable, int shortcutBarHeight) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(originDrawable, "originDrawable");
        if (shortcutBarHeight <= 0) {
            return new Pair<>(originDrawable, originDrawable);
        }
        if (com.tencent.mobileqq.qui.b.f276860a.h(context) <= 0) {
            return new Pair<>(originDrawable, originDrawable);
        }
        float f16 = shortcutBarHeight / (r0 + shortcutBarHeight);
        if (f16 > 0.0f && f16 < 1.0f) {
            return new Pair<>(AIODrawableUtils.c(originDrawable, context, 0.0f, f16), AIODrawableUtils.c(originDrawable, context, f16, 1.0f));
        }
        return new Pair<>(originDrawable, originDrawable);
    }

    @Override // com.tencent.qqnt.aio.api.IAIOImmersiveApi
    public boolean getNavigationBarSwitch() {
        return AIODrawableUtils.b();
    }
}
