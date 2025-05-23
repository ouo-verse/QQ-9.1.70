package com.tencent.mobileqq.qwallet.hb.skin.share;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.forward.api.IForwardApi;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.qqforward.api.IForwardOption;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQCustomArkDialogUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\"\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/skin/share/a;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "arkMsg", "", "requestCode", "", "a", "<init>", "()V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f277887a = new a();

    a() {
    }

    public final void a(@Nullable Activity activity, @Nullable String arkMsg, int requestCode) {
        boolean z16;
        if (activity != null && !activity.isFinishing()) {
            if (arkMsg != null && arkMsg.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                try {
                    QRouteApi api = QRoute.api(IForwardApi.class);
                    Intrinsics.checkNotNullExpressionValue(api, "api(IForwardApi::class.java)");
                    Intent intent = new Intent();
                    com.tencent.qqnt.msg.data.a aVar = new com.tencent.qqnt.msg.data.a();
                    aVar.o(arkMsg);
                    Bundle zipArgs = QQCustomArkDialogUtil.zipArgs(aVar.d(), aVar.e(), aVar.c(), aVar.m(), null);
                    Intrinsics.checkNotNullExpressionValue(zipArgs, "zipArgs(\n               \u2026       null\n            )");
                    zipArgs.putString("forward_ark_app_name", aVar.d());
                    zipArgs.putString("forward_ark_app_view", aVar.e());
                    zipArgs.putString("forward_ark_biz_src", aVar.f());
                    zipArgs.putString(AppConstants.Key.FORWARD_ARK_APP_DESC, aVar.a());
                    zipArgs.putString("forward_ark_app_ver", aVar.c());
                    zipArgs.putString("forward_ark_app_meta", aVar.m());
                    zipArgs.putString("forward_ark_app_prompt", aVar.n());
                    zipArgs.putString(AppConstants.Key.FORWARD_ARK_APP_CONFIG, aVar.g());
                    intent.putExtra("forward_type", 27);
                    intent.putExtra("is_ark_display_share", true);
                    zipArgs.putBoolean(IGuildFeatureAdapterApi.PARAM_NEED_SHOW_GUILD_ENTRANCE, false);
                    intent.putExtras(zipArgs);
                    ((IForwardOption) QRoute.api(IForwardOption.class)).startForwardActivityForResult(activity, intent, ((IForwardApi) api).getForwardRecentActivityClass(), requestCode);
                    return;
                } catch (Exception e16) {
                    QLog.e("QWalletShareArkHelper", 1, "shareArkToMsg exception: " + e16);
                    return;
                }
            }
        }
        QLog.i("QWalletShareArkHelper", 1, "shareArkToMsg fail, activity is not alive: " + activity);
    }
}
