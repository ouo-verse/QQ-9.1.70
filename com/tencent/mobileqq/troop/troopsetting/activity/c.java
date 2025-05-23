package com.tencent.mobileqq.troop.troopsetting.activity;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.troopguild.api.ITroopGuildApi;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0007J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0007J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0007J\u001e\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007J\f\u0010\u0011\u001a\u00020\u000f*\u00020\u0006H\u0002\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/activity/c;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/mobileqq/troop/data/TroopInfoData;", "troopInfoData", "", "b", "entryView", "d", "c", "a", "", "", "f", "e", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f301059a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60065);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f301059a = new c();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final void a(@NotNull View entryView) {
        Intrinsics.checkNotNullParameter(entryView, "entryView");
        VideoReport.setElementId(entryView, "em_group_game_data_show_entrance");
        VideoReport.setElementEndExposePolicy(entryView, EndExposurePolicy.REPORT_ALL);
    }

    @JvmStatic
    public static final void b(@NotNull Activity activity, @NotNull View rootView, @Nullable TroopInfoData troopInfoData) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        VideoReport.addToDetectionWhitelist(activity);
        VideoReport.setPageId(rootView, "pg_group_set");
        VideoReport.setPageParams(rootView, new PageParams((Map<String, ?>) f(troopInfoData)));
    }

    @JvmStatic
    public static final void c(@NotNull View entryView) {
        Intrinsics.checkNotNullParameter(entryView, "entryView");
        VideoReport.setElementId(entryView, "em_group_person_setting_entrance");
        VideoReport.setElementEndExposePolicy(entryView, EndExposurePolicy.REPORT_ALL);
    }

    @JvmStatic
    public static final void d(@NotNull View entryView) {
        Intrinsics.checkNotNullParameter(entryView, "entryView");
        VideoReport.setElementId(entryView, "em_group_search_way");
    }

    private final String e(TroopInfoData troopInfoData) {
        if (troopInfoData.bOwner) {
            return "1";
        }
        if (troopInfoData.bAdmin) {
            return "2";
        }
        return "3";
    }

    @JvmStatic
    @NotNull
    public static final Map<String, Object> f(@Nullable TroopInfoData troopInfoData) {
        String str;
        String str2;
        String str3;
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_duration_flag", 1);
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        if (troopInfoData != null) {
            str = troopInfoData.troopUin;
        } else {
            str = null;
        }
        if (str != null) {
            hashMap.put("group_id", str);
            String troopGuildId = ((ITroopGuildApi) QRoute.api(ITroopGuildApi.class)).getTroopGuildId(str);
            hashMap.put("sgrp_channel_id", troopGuildId);
            if (TextUtils.isEmpty(troopGuildId)) {
                str3 = "0";
            } else {
                str3 = "1";
            }
            hashMap.put("group_is_sgrp", str3);
        }
        if (troopInfoData == null || (str2 = f301059a.e(troopInfoData)) == null) {
            str2 = "";
        }
        hashMap.put("group_uin_type", str2);
        return hashMap;
    }
}
