package com.tencent.mobileqq.guild.feed.qqgame.view;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.avcore.netchannel.INetChannelCallback;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.ITianshuManager;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.widget.ActionMenuItem;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mqq.app.Foreground;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes13.dex */
public abstract class BaseGuildGameFeedsView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    protected Map<String, String> f223215d;

    /* renamed from: e, reason: collision with root package name */
    protected on1.b f223216e;

    /* renamed from: f, reason: collision with root package name */
    protected on1.d f223217f;

    /* renamed from: h, reason: collision with root package name */
    private ActionSheet f223218h;

    public BaseGuildGameFeedsView(@NonNull Context context, on1.d dVar) {
        super(context);
        this.f223218h = null;
        this.f223217f = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(View view, Activity activity, View view2, int i3) {
        com.tencent.xaction.log.b.a("BaseGuildGameFeedsView", 1, "showFeedBackActionSheet onClick which=" + i3);
        l(122);
        on1.d dVar = this.f223217f;
        if (dVar != null) {
            dVar.onClose();
            j(view, "em_sgrp_feed_section_ad_feedback_float");
        }
        ActionSheet actionSheet = this.f223218h;
        if (actionSheet != null) {
            ActionSheetHelper.dismissActionSheet(activity, actionSheet);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view) {
        ch.W0(view, "em_sgrp_feed_section_ad", new HashMap(this.f223215d));
    }

    abstract int c();

    public void d(Map<String, String> map, on1.b bVar) {
        this.f223215d = map;
        this.f223216e = bVar;
        LayoutInflater.from(getContext()).inflate(c(), (ViewGroup) this, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(View view) {
        GuildJumpUtil.w(null, this.f223216e.f423221i);
        l(102);
        k(view, "em_sgrp_feed_section_ad");
    }

    public abstract void g();

    public abstract void h();

    protected void j(View view, String str) {
        HashMap hashMap = new HashMap(this.f223215d);
        hashMap.put("sgrp_btn_type", 0);
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).reportDtEventManual(view, str, "clck", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k(View view, String str) {
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).reportDtEventManual(view, str, "clck", new HashMap(this.f223215d));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l(int i3) {
        String str = this.f223215d.get("ad_id");
        String str2 = this.f223215d.get("trace_info");
        String str3 = this.f223215d.get("trace_id");
        String str4 = this.f223215d.get("guild_id");
        String str5 = this.f223215d.get(INetChannelCallback.KEY_TINY_ID);
        com.tencent.xaction.log.b.a("BaseGuildGameFeedsView", 1, "reportTianShu traceId=" + str3 + ",guildId=" + str4 + ",tinyId=" + str5);
        TianShuReportData tianShuReportData = new TianShuReportData();
        tianShuReportData.mAppId = "tianshu.269";
        tianShuReportData.mAdSpace = 1462;
        tianShuReportData.mActionId = i3;
        tianShuReportData.mTraceNum = 1;
        tianShuReportData.mActionValue = 1;
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        tianShuReportData.mTraceId = str3;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        tianShuReportData.mItemId = str;
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        tianShuReportData.mTriggerInfo = str2;
        tianShuReportData.mOperTime = NetConnInfoCenter.getServerTime();
        tianShuReportData.mModuleId = "";
        tianShuReportData.mPageId = "tianshu.269";
        try {
            JSONObject jSONObject = new JSONObject();
            if (TextUtils.isEmpty(str4)) {
                str4 = "";
            }
            jSONObject.put("channel_id", str4);
            if (TextUtils.isEmpty(str5)) {
                str5 = "";
            }
            jSONObject.put("channel_owner_uin", str5);
            tianShuReportData.mBusiInfo = jSONObject.toString();
        } catch (JSONException e16) {
            com.tencent.xaction.log.b.c("BaseGuildGameFeedsView", 1, "reportTianShu exception", e16);
        }
        ((ITianshuManager) QRoute.api(ITianshuManager.class)).report(tianShuReportData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m(final View view) {
        ActionMenuItem actionMenuItem = new ActionMenuItem(1, ActionSheetHelper.getStringById(getContext(), R.string.f143720mu), 1, 0);
        ArrayList arrayList = new ArrayList();
        arrayList.add(actionMenuItem);
        final Activity topActivity = Foreground.getTopActivity();
        if (topActivity == null) {
            return;
        }
        ActionSheet createActionSheet = ActionSheetHelper.createActionSheet(topActivity, arrayList, new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.guild.feed.qqgame.view.a
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view2, int i3) {
                BaseGuildGameFeedsView.this.f(view, topActivity, view2, i3);
            }
        });
        this.f223218h = createActionSheet;
        createActionSheet.addCancelButton(R.string.cancel);
        ActionSheetHelper.showActionSheet(topActivity, this.f223218h);
    }

    public void i(boolean z16) {
    }
}
