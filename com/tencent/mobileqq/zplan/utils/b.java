package com.tencent.mobileqq.zplan.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQCustomArkDialogUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J.\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bJ>\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/zplan/utils/b;", "", "Landroid/content/Context;", "context", "", "arkInfo", "Landroid/os/Bundle;", "a", "Lkotlin/Function1;", "", "", "callback", "b", "", "uin", "nickName", "c", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f335808a = new b();

    b() {
    }

    private final Bundle a(Context context, String arkInfo) {
        String str;
        Bundle bundle = new Bundle();
        bundle.putString("share_ark_info", arkInfo);
        bundle.putBoolean("k_dataline", false);
        bundle.putBoolean("is_ark_display_share", true);
        bundle.putBoolean("only_single_selection", true);
        bundle.putInt("forward_type", 1067);
        bundle.putInt(ForwardRecentActivity.SELECTION_MODE, 1);
        bundle.putBoolean(IGuildFeatureAdapterApi.PARAM_NEED_SHOW_GUILD_ENTRANCE, false);
        try {
            JSONObject jSONObject = new JSONObject(arkInfo);
            String optString = jSONObject.optString("app", "");
            bundle.putString("forward_ark_app_name", optString);
            String optString2 = jSONObject.optString("view", "");
            bundle.putString("forward_ark_app_view", optString2);
            String optString3 = jSONObject.optString("ver", "");
            bundle.putString("forward_ark_app_ver", optString3);
            bundle.putString("forward_ark_app_prompt", jSONObject.optString("prompt", ""));
            bundle.putString("forward_ark_biz_src", jSONObject.optString(QQCustomArkDialogUtil.BIZ_SRC, ""));
            JSONObject optJSONObject = jSONObject.optJSONObject(DownloadInfo.spKey_Config);
            if (optJSONObject != null) {
                bundle.putString(AppConstants.Key.FORWARD_ARK_APP_CONFIG, optJSONObject.toString());
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject(PublicAccountMessageUtilImpl.META_NAME);
            if (optJSONObject2 != null) {
                bundle.putString("forward_ark_app_meta", optJSONObject2.toString());
                str = optJSONObject2.toString();
            } else {
                str = null;
            }
            Bundle zipArgs = QQCustomArkDialogUtil.zipArgs(optString, optString2, optString3, str, context.getResources().getDisplayMetrics().density, null, bundle);
            Intrinsics.checkNotNullExpressionValue(zipArgs, "zipArgs(\n               \u2026     bundle\n            )");
            return zipArgs;
        } catch (JSONException e16) {
            QLog.e("ArkShareUtil", 1, "getArkBundle error, " + e16);
            return null;
        }
    }

    public final void b(Context context, String arkInfo, Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(arkInfo, "arkInfo");
        Bundle a16 = a(context, arkInfo);
        if (a16 == null) {
            QLog.e("ArkShareUtil", 1, "sendArkToFriendByNative error");
            if (callback != null) {
                callback.invoke(Boolean.FALSE);
                return;
            }
            return;
        }
        Intent intent = new Intent();
        intent.putExtras(a16);
        intent.setClass(context, ForwardRecentActivity.class);
        intent.putExtra("caller_name", context.getClass().getSimpleName());
        intent.putExtra("forward_source_business_type", -1);
        intent.putExtra("forward_source_sub_business_type", "");
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
        if (callback != null) {
            callback.invoke(Boolean.TRUE);
        }
    }

    public final void c(Context context, long uin, String nickName, String arkInfo, Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(nickName, "nickName");
        Intrinsics.checkNotNullParameter(arkInfo, "arkInfo");
        Bundle a16 = a(context, arkInfo);
        if (a16 == null) {
            QLog.e("ArkShareUtil", 1, "sendArkToFriendUinByNative error.");
            if (callback != null) {
                callback.invoke(Boolean.FALSE);
                return;
            }
            return;
        }
        a16.putInt(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, 5);
        a16.putBoolean("is_need_show_toast", true);
        Intent intent = new Intent();
        intent.putExtras(a16);
        intent.putExtra(AppConstants.Key.FORWARD_SEND_TO_UIN, uin);
        intent.putExtra(AppConstants.Key.FORWARD_SEND_TO_UIN_NICKNAME, nickName);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        RouteUtils.startActivityForResult(context, intent, RouterConstants.UI_ROUTE_FORWARD_RECENT_TRANS, -1);
        QLog.i("ArkShareUtil", 1, "sendArkToFriendUinByNative");
        if (callback != null) {
            callback.invoke(Boolean.TRUE);
        }
    }
}
