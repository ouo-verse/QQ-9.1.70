package com.tencent.mobileqq.guild.feed.share;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.gamematrix.gmcg.sdk.nonage.report.CGNonAgeReport;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.guild.feed.api.IGuildShareToFeedApi;
import com.tencent.mobileqq.guild.feed.api.SharePublishGuildFeedParam;
import com.tencent.mobileqq.guild.feed.morepanel.FeedMorePanelUtils;
import com.tencent.mobileqq.guild.feed.morepanel.impl.NewFeedMorePanelBusiImpl;
import com.tencent.mobileqq.guild.feed.usecases.GuildFeedArkShareInfo;
import com.tencent.mobileqq.guild.feed.util.bh;
import com.tencent.mobileqq.guild.share.util.GuildActionSheetAttaUtil;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.guild.util.GuildForwardUtilKt;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.guild.util.az;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.sharehelper.IShareActionHelper;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQCustomArkDialogUtil;
import java.util.ArrayList;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes13.dex */
public class v {

    /* renamed from: a, reason: collision with root package name */
    private final IShareActionHelper f223446a = (IShareActionHelper) QRoute.api(IShareActionHelper.class);

    /* renamed from: b, reason: collision with root package name */
    private int f223447b = GuildSharePageSource.UNKNOWN.ordinal();

    private void A(int i3, Activity activity, GuildFeedArkShareInfo guildFeedArkShareInfo, Runnable runnable) {
        this.f223446a.doShareLinkToWeChat("guildShare", i3, guildFeedArkShareInfo.z(), activity, String.valueOf(System.currentTimeMillis()), guildFeedArkShareInfo.s(), guildFeedArkShareInfo.y(), q(guildFeedArkShareInfo), runnable);
    }

    private void c(Intent intent, GuildFeedArkShareInfo guildFeedArkShareInfo) {
        if (intent != null && guildFeedArkShareInfo != null) {
            boolean B = guildFeedArkShareInfo.B();
            SharePublishGuildFeedParam.LinkTypeParam linkTypeParam = new SharePublishGuildFeedParam.LinkTypeParam(guildFeedArkShareInfo.w(), q(guildFeedArkShareInfo), guildFeedArkShareInfo.y(), guildFeedArkShareInfo.s());
            if (B) {
                linkTypeParam.getExtMap().put("feed_new_panel_share_forward_key", new NewFeedMorePanelBusiImpl.FeedNewPanelShareForwardArgs(guildFeedArkShareInfo.p(), guildFeedArkShareInfo.k(), guildFeedArkShareInfo.n(), 1));
            }
            intent.putExtra(AppConstants.Key.SHARE_PANEL_PAGE_SOURCE, this.f223447b);
            GuildForwardUtilKt.m(intent, linkTypeParam);
            return;
        }
        QLog.e("GuildShareAction", 1, "[addShareLinkToPostFeedExtras]: shareInfo = " + guildFeedArkShareInfo);
    }

    private static void d(GuildFeedArkShareInfo guildFeedArkShareInfo, JSONObject jSONObject) throws JSONException {
        guildFeedArkShareInfo.p0(r("text", o(n(p(jSONObject, new String[]{"feed", "title"}), "contents"), "text_content")));
        String r16 = r("feed_id", jSONObject);
        if (!TextUtils.isEmpty(r16)) {
            guildFeedArkShareInfo.b0(r16);
        }
        String r17 = r(AlbumCacheData.CREATE_TIME, o(jSONObject, "feed"));
        if (!TextUtils.isEmpty(r17)) {
            guildFeedArkShareInfo.Z(az.d(r17, 0L));
        }
        String r18 = r("str_tiny_id", o(jSONObject, QAdVrReport.ElementID.AD_POSTER));
        if (!TextUtils.isEmpty(r18)) {
            guildFeedArkShareInfo.j0(az.d(r18, 0L));
        }
        guildFeedArkShareInfo.o0(r("guild_icon", o(jSONObject, CGNonAgeReport.EVENT_CHANNEL)));
        String r19 = r("pic_url", n(o(jSONObject, "feed"), "images"));
        if (!TextUtils.isEmpty(r19)) {
            guildFeedArkShareInfo.o0(r19);
            guildFeedArkShareInfo.e0(true);
        }
        String r26 = r("pic_url", o(n(o(jSONObject, "feed"), "videos"), "cover"));
        if (!TextUtils.isEmpty(r26)) {
            guildFeedArkShareInfo.o0(r26);
            guildFeedArkShareInfo.e0(true);
        }
    }

    public static void l(GuildFeedArkShareInfo guildFeedArkShareInfo, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            guildFeedArkShareInfo.f0(r(PublicAccountMessageUtilImpl.META_NAME, jSONObject));
            guildFeedArkShareInfo.F(r("view", jSONObject));
            guildFeedArkShareInfo.k0(r("prompt", jSONObject));
            guildFeedArkShareInfo.E(r("ver", jSONObject));
            guildFeedArkShareInfo.V(r(DownloadInfo.spKey_Config, jSONObject));
            guildFeedArkShareInfo.D(r("app", jSONObject));
            guildFeedArkShareInfo.C(r(QQCustomArkDialogUtil.BIZ_SRC, jSONObject));
            guildFeedArkShareInfo.G(str);
        } catch (JSONException e16) {
            e16.printStackTrace();
            QLog.e("GuildShareAction", 1, "initArkShareInfo e:" + e16);
        }
    }

    private static JSONObject n(JSONObject jSONObject, String str) {
        try {
            JSONArray jSONArray = jSONObject.getJSONArray(str);
            if (jSONArray.length() > 0) {
                return (JSONObject) jSONArray.get(0);
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return new JSONObject();
    }

    private static JSONObject o(JSONObject jSONObject, String str) {
        try {
            return jSONObject.getJSONObject(str);
        } catch (JSONException e16) {
            e16.printStackTrace();
            return new JSONObject();
        }
    }

    private static JSONObject p(JSONObject jSONObject, String[] strArr) {
        for (String str : strArr) {
            jSONObject = o(jSONObject, str);
        }
        return jSONObject;
    }

    @NonNull
    private String q(GuildFeedArkShareInfo guildFeedArkShareInfo) {
        if (guildFeedArkShareInfo.A() && !TextUtils.isEmpty(guildFeedArkShareInfo.x())) {
            return guildFeedArkShareInfo.x();
        }
        IGProGuildInfo L = ch.L(guildFeedArkShareInfo.p());
        if (L != null) {
            return bh.a(L.getAvatarUrl(0));
        }
        return "";
    }

    private static String r(String str, JSONObject jSONObject) {
        String optString;
        String str2 = "";
        try {
            optString = jSONObject.optString(str);
            try {
                if (TextUtils.isEmpty(optString)) {
                    optString = String.valueOf(jSONObject.getLong(str));
                }
            } catch (Exception e16) {
                e = e16;
                str2 = optString;
                e.printStackTrace();
                return str2;
            }
        } catch (Exception e17) {
            e = e17;
        }
        if (TextUtils.isEmpty(optString)) {
            if (jSONObject.optJSONObject(str) != null) {
                str2 = jSONObject.optJSONObject(str).toString();
            }
            return str2;
        }
        return optString;
    }

    public static GuildFeedArkShareInfo s(String str) {
        GuildFeedArkShareInfo guildFeedArkShareInfo = new GuildFeedArkShareInfo();
        try {
            if (FeedMorePanelUtils.f220193a.f()) {
                d(guildFeedArkShareInfo, p(new JSONObject(str), new String[]{PublicAccountMessageUtilImpl.META_NAME, "detail"}));
            } else {
                JSONObject jSONObject = new JSONObject(str);
                guildFeedArkShareInfo.f0(r(PublicAccountMessageUtilImpl.META_NAME, jSONObject));
                guildFeedArkShareInfo.F(r("view", jSONObject));
                guildFeedArkShareInfo.k0(r("prompt", jSONObject));
                guildFeedArkShareInfo.E(r("ver", jSONObject));
                guildFeedArkShareInfo.V(r(DownloadInfo.spKey_Config, jSONObject));
                guildFeedArkShareInfo.D(r("app", jSONObject));
                d(guildFeedArkShareInfo, p(jSONObject, new String[]{PublicAccountMessageUtilImpl.META_NAME, "detail"}));
                guildFeedArkShareInfo.G(str);
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
            QLog.e("GuildShareAction", 1, "initArkShareInfo e:" + e16);
        }
        guildFeedArkShareInfo.a0(new Bundle());
        return guildFeedArkShareInfo;
    }

    private Intent t(GuildFeedArkShareInfo guildFeedArkShareInfo) {
        if (FeedMorePanelUtils.f220193a.f()) {
            return u(guildFeedArkShareInfo);
        }
        return v(guildFeedArkShareInfo);
    }

    private Intent u(GuildFeedArkShareInfo guildFeedArkShareInfo) {
        boolean B = guildFeedArkShareInfo.B();
        Intent intent = new Intent();
        intent.putExtra("forward_type", 27);
        intent.putExtra("forward_ark_app_name", guildFeedArkShareInfo.c());
        intent.putExtra("forward_ark_app_view", guildFeedArkShareInfo.f());
        intent.putExtra("forward_ark_biz_src", guildFeedArkShareInfo.a());
        intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_DESC, guildFeedArkShareInfo.b());
        intent.putExtra("forward_ark_app_ver", guildFeedArkShareInfo.e());
        intent.putExtra("forward_ark_app_meta", guildFeedArkShareInfo.q());
        intent.putExtra("forward_ark_app_prompt", guildFeedArkShareInfo.u());
        intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_CONFIG, guildFeedArkShareInfo.l());
        if (B) {
            intent.putExtra(AppConstants.Key.FORWARD_USE_BOTTOM_SHEET_PREVIEW, true);
        }
        intent.putExtra("is_ark_display_share", true);
        intent.putExtra(ForwardRecentActivity.SELECTION_MODE, 2);
        intent.putExtras(QQCustomArkDialogUtil.zipArgs(guildFeedArkShareInfo.c(), guildFeedArkShareInfo.f(), guildFeedArkShareInfo.e(), guildFeedArkShareInfo.q(), ViewUtils.getDensity(), null, null));
        return intent;
    }

    private Intent v(GuildFeedArkShareInfo guildFeedArkShareInfo) {
        Intent intent = new Intent();
        intent.putExtra("forward_type", 1051);
        intent.putExtra(AppConstants.Key.GUILD_COMMEN_ARG_MSG_SHARE_TYPE, 1);
        intent.putExtra("is_ark_display_share", true);
        intent.putExtra("forward_ark_app_name", guildFeedArkShareInfo.c());
        intent.putExtra("forward_ark_app_view", guildFeedArkShareInfo.f());
        intent.putExtra("forward_ark_app_ver", guildFeedArkShareInfo.e());
        intent.putExtra("forward_ark_app_prompt", guildFeedArkShareInfo.u());
        intent.putExtra(AppConstants.Key.GUILD_SOURCE_ID, guildFeedArkShareInfo.p());
        intent.putExtra(AppConstants.Key.GUILD_SOURCE_CHANNEL_ID, guildFeedArkShareInfo.k());
        intent.putExtra("forward_ark_app_meta", guildFeedArkShareInfo.g());
        intent.putExtra(ForwardRecentActivity.SELECTION_MODE, 2);
        intent.putExtra(guildFeedArkShareInfo.j(), true);
        intent.putExtras(QQCustomArkDialogUtil.zipArgs(guildFeedArkShareInfo.c(), guildFeedArkShareInfo.f(), guildFeedArkShareInfo.e(), guildFeedArkShareInfo.q(), ViewUtils.getDensity(), null, null));
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void w(Activity activity, Intent intent) {
        RouteUtils.startActivityForResult(activity, intent, RouterConstants.UI_ROUTE_JUMP_FORWARD_RECENT, -1);
        QLog.d("GuildShareAction", 1, "shareToQQ success");
    }

    private void z(Activity activity, String str, @NonNull GuildFeedArkShareInfo guildFeedArkShareInfo) {
        if (str != null && activity != null) {
            String w3 = guildFeedArkShareInfo.w();
            if (QLog.isColorLevel()) {
                QLog.d("GuildShareAction", 1, "[shareRichLinkToPostFeed]: guildId=" + str + ", shareUrl=" + w3);
            }
            ((IGuildShareToFeedApi) QRoute.api(IGuildShareToFeedApi.class)).shareToFeedPostAwareForbidden(activity, str, new SharePublishGuildFeedParam.LinkTypeParam(w3, q(guildFeedArkShareInfo), guildFeedArkShareInfo.y(), guildFeedArkShareInfo.s()), this.f223447b, null);
        }
    }

    public void e(String str, final Activity activity, GuildFeedArkShareInfo guildFeedArkShareInfo) {
        NewFeedMorePanelBusiImpl.c cVar;
        Intent t16 = t(guildFeedArkShareInfo);
        c(t16, guildFeedArkShareInfo);
        if ("guildShare".equals(str)) {
            t16.putExtra(AppConstants.Key.SHARE_REQ_TYPE, 6);
        }
        if (guildFeedArkShareInfo.B()) {
            cVar = new NewFeedMorePanelBusiImpl.c(new NewFeedMorePanelBusiImpl.FeedNewPanelShareForwardArgs(guildFeedArkShareInfo.p(), guildFeedArkShareInfo.k(), guildFeedArkShareInfo.n(), 1));
        } else {
            cVar = null;
        }
        GuildActionSheetAttaUtil.j(t16, guildFeedArkShareInfo.w(), this.f223447b, guildFeedArkShareInfo.v(), cVar, new com.tencent.mobileqq.guild.share.util.g() { // from class: com.tencent.mobileqq.guild.feed.share.t
            @Override // com.tencent.mobileqq.guild.share.util.g
            public final void a(Intent intent) {
                v.w(activity, intent);
            }
        });
    }

    public void f(String str, final Activity activity, GuildFeedArkShareInfo guildFeedArkShareInfo, int i3, String str2) {
        Intent t16 = t(guildFeedArkShareInfo);
        if (i3 == 10027) {
            z(activity, str2, guildFeedArkShareInfo);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, 1);
        bundle.putInt("key_direct_show_uin_type", i3);
        bundle.putString("key_direct_show_uin", str2);
        t16.putExtras(bundle);
        t16.putExtra("caller_name", activity.getClass().getSimpleName());
        t16.putExtra("forward_source_business_type", -1);
        t16.putExtra("forward_source_sub_business_type", "");
        GuildActionSheetAttaUtil.j(t16, guildFeedArkShareInfo.w(), this.f223447b, guildFeedArkShareInfo.v(), null, new com.tencent.mobileqq.guild.share.util.g() { // from class: com.tencent.mobileqq.guild.feed.share.u
            @Override // com.tencent.mobileqq.guild.share.util.g
            public final void a(Intent intent) {
                RouteUtils.startActivityForResult(activity, intent, RouterConstants.UI_ROUTE_FORWARD_RECENT_TRANS, -1);
            }
        });
    }

    public void g(String str, Activity activity, GuildFeedArkShareInfo guildFeedArkShareInfo) {
        Intent t16 = t(guildFeedArkShareInfo);
        c(t16, guildFeedArkShareInfo);
        t16.putExtra("call_by_forward", true);
        ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).startQQGuildForwardGuildListFragment(activity, t16, 20000);
    }

    public void h(String str, Activity activity, GuildFeedArkShareInfo guildFeedArkShareInfo) {
        com.tencent.mobileqq.sharehelper.d dVar = new com.tencent.mobileqq.sharehelper.d();
        dVar.n(guildFeedArkShareInfo.s());
        dVar.j("");
        dVar.p(guildFeedArkShareInfo.y());
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(q(guildFeedArkShareInfo));
        dVar.l(arrayList);
        dVar.o(guildFeedArkShareInfo.w());
        dVar.i(((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).appInterface().getCurrentUin());
        dVar.m(2021);
        this.f223446a.doShareToQZoneWithLink(str, activity, dVar);
    }

    public void i(Activity activity, GuildFeedArkShareInfo guildFeedArkShareInfo, Runnable runnable) {
        A(10, activity, guildFeedArkShareInfo, runnable);
    }

    @Deprecated
    public void j(Activity activity, GuildFeedArkShareInfo guildFeedArkShareInfo, Runnable runnable) {
        A(9, activity, guildFeedArkShareInfo, runnable);
    }

    public void k(Activity activity, String str, String str2) {
        ClipboardMonitor.setPrimaryClip((ClipboardManager) activity.getSystemService("clipboard"), ClipData.newPlainText("group_pro_url", str));
        QQToast.makeText(activity, 2, str2, 0).show(R.dimen.title_bar_height);
    }

    public void m(GuildFeedArkShareInfo guildFeedArkShareInfo, final Function1<Intent, Unit> function1) {
        Intent t16 = t(guildFeedArkShareInfo);
        c(t16, guildFeedArkShareInfo);
        String w3 = guildFeedArkShareInfo.w();
        int i3 = this.f223447b;
        String v3 = guildFeedArkShareInfo.v();
        Objects.requireNonNull(function1);
        GuildActionSheetAttaUtil.j(t16, w3, i3, v3, null, new com.tencent.mobileqq.guild.share.util.g() { // from class: com.tencent.mobileqq.guild.feed.share.s
            @Override // com.tencent.mobileqq.guild.share.util.g
            public final void a(Intent intent) {
                Function1.this.invoke(intent);
            }
        });
    }

    public void y(int i3) {
        this.f223447b = i3;
    }
}
