package com.tencent.mobileqq.gdtad.api.videocelling.impl;

import android.content.Context;
import android.content.Intent;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingFragment;
import com.tencent.mobileqq.activity.GdtActivityNoOrientationLimitsForTool;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.gdtad.api.videocelling.IGdtVideoCellingAPI;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0010\u0010\t\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000b\u0018\u00010\nH\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/gdtad/api/videocelling/impl/GdtVideoCellingAPIImpl;", "Lcom/tencent/mobileqq/gdtad/api/videocelling/IGdtVideoCellingAPI;", "()V", "startActivity", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "cls", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/QBaseFragment;", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class GdtVideoCellingAPIImpl implements IGdtVideoCellingAPI {
    @Override // com.tencent.mobileqq.gdtad.api.videocelling.IGdtVideoCellingAPI
    public void startActivity(Context context, Intent intent, Class<? extends QBaseFragment> cls) {
        Intrinsics.checkNotNullParameter(context, "context");
        PublicFragmentActivity.b.a(context, intent, GdtActivityNoOrientationLimitsForTool.class, GdtVideoCeilingFragment.class);
    }
}
