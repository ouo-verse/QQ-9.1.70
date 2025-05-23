package com.qzone.reborn.feedx.widget;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.flashname.IFlashNickNameComponent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J:\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0012"}, d2 = {"Lcom/qzone/reborn/feedx/widget/QZoneFlashNickNameHelper;", "", "Landroid/view/View;", "view", "", "scene", "", "isCenter", "animationUrl", "", "loop", "Lcom/tencent/mobileqq/vas/flashname/IFlashNickNameComponent$a;", "listener", "", "a", "b", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneFlashNickNameHelper {
    public final void a(View view, String scene, boolean isCenter, String animationUrl, int loop, IFlashNickNameComponent.a listener) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(animationUrl, "animationUrl");
        if (TextUtils.isEmpty(animationUrl)) {
            return;
        }
        ((IFlashNickNameComponent) QRoute.api(IFlashNickNameComponent.class)).playNickCoverAnimation(view, isCenter, animationUrl, loop, true, scene, new Function1<View, Boolean>() { // from class: com.qzone.reborn.feedx.widget.QZoneFlashNickNameHelper$playNickCoverAnimation$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.FALSE;
            }
        }, listener);
    }

    public final void b(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ((IFlashNickNameComponent) QRoute.api(IFlashNickNameComponent.class)).removeNickCover(view);
    }
}
