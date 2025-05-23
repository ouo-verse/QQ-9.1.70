package com.tencent.open.api.impl;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.open.agent.PublicFragmentActivityForOpenSDK;
import com.tencent.open.agent.util.t;
import com.tencent.open.api.IOpenSdkApi;
import com.tencent.open.fragment.RecommendFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/open/api/impl/OpenSdkApiImpl;", "Lcom/tencent/open/api/IOpenSdkApi;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "openRecommendFragment", "<init>", "()V", "Companion", "a", "opensdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class OpenSdkApiImpl implements IOpenSdkApi {

    @NotNull
    private static final String TAG = "OpenSdkApiImpl";

    @Override // com.tencent.open.api.IOpenSdkApi
    public void openRecommendFragment(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        t.f(TAG, "openRecommendFragment");
        Intent intent = new Intent(activity, (Class<?>) PublicFragmentActivityForOpenSDK.class);
        intent.putExtra("public_fragment_class", RecommendFragment.class.getName());
        activity.startActivityForResult(intent, 104);
    }
}
