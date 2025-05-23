package com.qzone.reborn.feedpro.utils;

import android.content.Context;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.mobileqq.R;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007R\u001a\u0010\u000b\u001a\u00020\u00078\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0005\u0010\b\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/qzone/reborn/feedpro/utils/r;", "", "Landroid/content/Context;", "context", "", "b", "a", "", "Ljava/lang/String;", "getLINK_COLOR_HEX", "()Ljava/lang/String;", "LINK_COLOR_HEX", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public static final r f54359a = new r();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final String LINK_COLOR_HEX = "#465A90";

    r() {
    }

    public final int a(Context context) {
        if (context != null) {
            return ResourcesCompat.getColor(context.getResources(), R.color.qui_common_overlay_standard_primary, null);
        }
        return ef.a.f396213a.a("#D5D5D5", -16777216);
    }

    public final int b(Context context) {
        if (context != null) {
            return ResourcesCompat.getColor(context.getResources(), R.color.qui_common_text_link_qzone, null);
        }
        return ef.a.f396213a.a(LINK_COLOR_HEX, -16777216);
    }
}
