package com.tencent.mobileqq.statustitle;

import android.content.res.Resources;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.SimpleModeHelper;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/statustitle/c;", "", "Landroid/content/res/Resources;", DKConfiguration.Directory.RESOURCES, "", "b", "Lmqq/app/AppRuntime;", "app", "a", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f290185a = new c();

    c() {
    }

    public final int a(AppRuntime app) {
        Intrinsics.checkNotNullParameter(app, "app");
        return (SimpleModeHelper.B() || !ThemeUtil.isNowThemeIsNight(app, false, null)) ? 255 : 153;
    }

    public final int b(Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        return resources.getColor(R.color.qui_common_icon_nav_primary);
    }
}
