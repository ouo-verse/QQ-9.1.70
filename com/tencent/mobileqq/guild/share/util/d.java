package com.tencent.mobileqq.guild.share.util;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQCustomArkDialogUtil;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u001a\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\bJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\b\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/share/util/d;", "", "Lcom/tencent/mobileqq/sharehelper/a;", "arkShareInfo", "Landroid/content/Intent;", "intent", "", "a", "", "key", "Lorg/json/JSONObject;", "jsonObject", "d", "arkInfo", "b", "c", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f235123a = new d();

    d() {
    }

    @JvmStatic
    public static final void a(@NotNull com.tencent.mobileqq.sharehelper.a arkShareInfo, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(arkShareInfo, "arkShareInfo");
        Intrinsics.checkNotNullParameter(intent, "intent");
        intent.putExtra("is_ark_display_share", true);
        intent.putExtra("forward_type", arkShareInfo.g());
        intent.putExtra("forward_ark_app_name", arkShareInfo.a());
        intent.putExtra("forward_ark_app_view", arkShareInfo.c());
        intent.putExtra("forward_ark_app_ver", arkShareInfo.b());
        intent.putExtra("forward_ark_app_prompt", arkShareInfo.i());
        intent.putExtra("forward_ark_biz_src", arkShareInfo.d());
        intent.putExtra(AppConstants.Key.FORWARD_USE_BOTTOM_SHEET_PREVIEW, true);
        intent.putExtra(arkShareInfo.e(), true);
        intent.putExtra("forward_ark_app_meta", arkShareInfo.h());
        intent.putExtras(arkShareInfo.f());
        if (QLog.isColorLevel()) {
            QLog.d("GuildArkUtils", 2, "getShareArkIntent metaDataString: ", arkShareInfo.h());
        }
    }

    private final String d(String key, JSONObject jsonObject) {
        String optString;
        String str = "";
        try {
            optString = jsonObject.optString(key);
            try {
                if (TextUtils.isEmpty(optString)) {
                    optString = String.valueOf(jsonObject.getLong(key));
                }
            } catch (Exception e16) {
                e = e16;
                str = optString;
                e.printStackTrace();
                return str;
            }
        } catch (Exception e17) {
            e = e17;
        }
        if (TextUtils.isEmpty(optString)) {
            JSONObject optJSONObject = jsonObject.optJSONObject(key);
            if (optJSONObject != null) {
                String jSONObject = optJSONObject.toString();
                if (jSONObject != null) {
                    str = jSONObject;
                }
            }
            return str;
        }
        return optString;
    }

    @NotNull
    public final Intent b(@NotNull String arkInfo) {
        Intrinsics.checkNotNullParameter(arkInfo, "arkInfo");
        Intent intent = new Intent();
        com.tencent.mobileqq.sharehelper.a c16 = c(arkInfo);
        if (c16 != null) {
            a(c16, intent);
        }
        intent.putExtra(ForwardRecentActivity.SELECTION_MODE, 2);
        intent.putExtra("call_by_forward", true);
        return intent;
    }

    @Nullable
    public final com.tencent.mobileqq.sharehelper.a c(@NotNull String arkInfo) {
        Intrinsics.checkNotNullParameter(arkInfo, "arkInfo");
        try {
            JSONObject jSONObject = new JSONObject(arkInfo);
            String d16 = d(PublicAccountMessageUtilImpl.META_NAME, jSONObject);
            String d17 = d("view", jSONObject);
            String d18 = d("app", jSONObject);
            String d19 = d("ver", jSONObject);
            String d26 = d(QQCustomArkDialogUtil.BIZ_SRC, jSONObject);
            Bundle bundle = new Bundle();
            bundle.putString("appName", d18);
            bundle.putString(QQCustomArkDialogUtil.APP_MIN_VERSION, d19);
            bundle.putString(QQCustomArkDialogUtil.APP_VIEW, d17);
            bundle.putString(QQCustomArkDialogUtil.META_DATA, d16);
            bundle.putFloat("scale", ViewUtils.getDensity());
            bundle.putString(QQCustomArkDialogUtil.BIZ_SRC, d26);
            bundle.putString(AppConstants.Key.FORWARD_ARK_APP_CONFIG, d(DownloadInfo.spKey_Config, jSONObject));
            return new com.tencent.mobileqq.sharehelper.a(d18, d17, d19, d("prompt", jSONObject), d16, bundle, "guild_share_label", 27, d26);
        } catch (JSONException e16) {
            e16.printStackTrace();
            QLog.e("GuildArkUtils", 1, "initArkShareInfo e:" + e16);
            return null;
        }
    }
}
