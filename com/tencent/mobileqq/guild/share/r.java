package com.tencent.mobileqq.guild.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/share/r;", "", "Landroid/content/Context;", "context", "", "guildMiniAppShareDataStr", "", "a", "<init>", "()V", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public static final r f235093a = new r();

    r() {
    }

    @JvmStatic
    public static final void a(Context context, String guildMiniAppShareDataStr) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(guildMiniAppShareDataStr, "guildMiniAppShareDataStr");
        Intent intent = new Intent();
        intent.putExtra(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, 4);
        intent.putExtra("KEY_MINI_DATA", guildMiniAppShareDataStr);
        intent.putExtra("direct_send_if_dataline_forward", true);
        intent.setClassName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity");
        intent.setClass(context, ForwardRecentTranslucentActivity.class);
        intent.putExtra("caller_name", context.getClass().getSimpleName());
        intent.putExtra("forward_source_business_type", -1);
        context.startActivity(intent);
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(0, 0);
        }
    }
}
