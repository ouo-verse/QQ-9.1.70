package com.tencent.mobileqq.guild.feed.part;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.component.GuildQUIEmptyState;
import com.tencent.mobileqq.guild.feed.event.GuildFeedThemeChangeEvent;
import com.tencent.mobileqq.guild.feed.event.GuildInboxEmptyPartEvent;
import com.tencent.richframework.data.base.UIStateData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes13.dex */
public class al extends f {

    /* renamed from: h, reason: collision with root package name */
    private LinearLayout f222512h;

    /* renamed from: i, reason: collision with root package name */
    private GuildQUIEmptyState f222513i;

    private void B9(GuildInboxEmptyPartEvent guildInboxEmptyPartEvent) {
        int i3;
        LinearLayout linearLayout = this.f222512h;
        if (linearLayout == null) {
            return;
        }
        if (guildInboxEmptyPartEvent.isShowView()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        linearLayout.setVisibility(i3);
        String errorMsg = guildInboxEmptyPartEvent.getErrorMsg();
        if (!TextUtils.isEmpty(errorMsg)) {
            this.f222513i.setTitle(errorMsg);
        }
        if (!TextUtils.isEmpty(guildInboxEmptyPartEvent.getErrorDesc())) {
            this.f222513i.setDesc(guildInboxEmptyPartEvent.getErrorDesc());
        }
        if (guildInboxEmptyPartEvent.isShowView()) {
            HashMap hashMap = new HashMap();
            if (errorMsg == null) {
                errorMsg = "";
            }
            hashMap.put("feed_notice_empty_error_msg", errorMsg);
            com.tencent.mobileqq.guild.feed.performance.report.g.a("feed_list_show_empty");
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> eventClass = super.getEventClass();
        eventClass.add(GuildInboxEmptyPartEvent.class);
        eventClass.add(GuildFeedThemeChangeEvent.class);
        return eventClass;
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "GuildFeedNoticeEmptyListPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.wiu);
        this.f222512h = linearLayout;
        linearLayout.setVisibility(8);
        GuildQUIEmptyState a16 = new GuildQUIEmptyState.a(getContext()).s(3).u(HardCodeUtil.qqStr(R.string.f1513717i)).r(false).o(0).a();
        this.f222513i = a16;
        this.f222512h.addView(a16);
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof GuildInboxEmptyPartEvent) {
            B9((GuildInboxEmptyPartEvent) simpleBaseEvent);
        } else {
            boolean z16 = simpleBaseEvent instanceof GuildFeedThemeChangeEvent;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.feed.part.f
    public void z9(UIStateData<List<ij1.g>> uIStateData) {
        super.z9(uIStateData);
    }
}
