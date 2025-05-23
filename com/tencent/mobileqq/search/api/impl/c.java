package com.tencent.mobileqq.search.api.impl;

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
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQCustomArkDialogUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J.\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bJF\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bJ.\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/search/api/impl/c;", "", "Landroid/content/Context;", "context", "", "arkInfo", "Landroid/os/Bundle;", "a", "Lkotlin/Function1;", "", "", "callback", "b", "uin", "", "uinType", "nickName", "d", "Landroid/app/Activity;", "f", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f282772a = new c();

    c() {
    }

    private final Bundle a(Context context, String arkInfo) {
        String str;
        Bundle bundle = new Bundle();
        bundle.putString("share_ark_info", arkInfo);
        bundle.putBoolean("k_dataline", false);
        bundle.putBoolean("is_ark_display_share", true);
        bundle.putBoolean("only_single_selection", true);
        bundle.putInt("forward_type", 27);
        bundle.putInt(ForwardRecentActivity.SELECTION_MODE, 1);
        bundle.putBoolean("is_need_show_toast", true);
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
            QLog.e("SearchShare.SearchArkShareUtil", 1, "getArkBundle error, " + e16);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void c(c cVar, Context context, String str, Function1 function1, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            function1 = null;
        }
        cVar.b(context, str, function1);
    }

    public static /* synthetic */ void e(c cVar, Context context, String str, int i3, String str2, String str3, Function1 function1, int i16, Object obj) {
        if ((i16 & 32) != 0) {
            function1 = null;
        }
        cVar.d(context, str, i3, str2, str3, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void g(c cVar, Activity activity, String str, Function1 function1, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            function1 = null;
        }
        cVar.f(activity, str, function1);
    }

    public final void b(@NotNull Context context, @NotNull String arkInfo, @Nullable Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(arkInfo, "arkInfo");
        Bundle a16 = a(context, arkInfo);
        if (a16 == null) {
            QLog.e("SearchShare.SearchArkShareUtil", 1, "sendArkToFriendByNative error");
            if (callback != null) {
                callback.invoke(Boolean.FALSE);
                return;
            }
            return;
        }
        a16.putBoolean(IGuildFeatureAdapterApi.PARAM_NEED_SHOW_GUILD_ENTRANCE, false);
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

    public final void d(@NotNull Context context, @NotNull String uin, int uinType, @NotNull String nickName, @NotNull String arkInfo, @Nullable Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(nickName, "nickName");
        Intrinsics.checkNotNullParameter(arkInfo, "arkInfo");
        Bundle a16 = a(context, arkInfo);
        if (a16 == null) {
            QLog.e("SearchShare.SearchArkShareUtil", 1, "sendArkToFriendUinByNative error.");
            if (callback != null) {
                callback.invoke(Boolean.FALSE);
                return;
            }
            return;
        }
        a16.putInt(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, 1);
        a16.putBoolean(IGuildFeatureAdapterApi.PARAM_NEED_SHOW_GUILD_ENTRANCE, false);
        Intent intent = new Intent();
        intent.putExtras(a16);
        intent.putExtra(AppConstants.Key.FORWARD_SEND_TO_UIN_NICKNAME, nickName);
        intent.putExtra("key_direct_show_uin_type", uinType);
        intent.putExtra("key_direct_show_uin", uin);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        RouteUtils.startActivityForResult(context, intent, RouterConstants.UI_ROUTE_FORWARD_RECENT_TRANS, -1);
        QLog.i("SearchShare.SearchArkShareUtil", 1, "sendArkToFriendUinByNative");
        if (callback != null) {
            callback.invoke(Boolean.TRUE);
        }
    }

    public final void f(@NotNull Activity context, @NotNull String arkInfo, @Nullable Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(arkInfo, "arkInfo");
        Bundle a16 = a(context, arkInfo);
        if (a16 == null) {
            QLog.e("SearchShare.SearchArkShareUtil", 1, "sendArkToFriendUinByNative error.");
            if (callback != null) {
                callback.invoke(Boolean.FALSE);
                return;
            }
            return;
        }
        a16.putInt(ForwardRecentActivity.SELECTION_MODE, 1);
        Intent intent = new Intent();
        intent.putExtras(a16);
        intent.putExtra("call_by_forward", true);
        ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).startQQGuildForwardGuildListFragment(context, intent, 20000);
    }
}
