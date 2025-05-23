package com.tencent.mobileqq.guild.feed.part;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.event.GuildFeedShowBubbleEvent;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.ArrayList;

/* loaded from: classes13.dex */
public class GuildFeedRefreshBubblePart extends d {

    /* renamed from: d, reason: collision with root package name */
    private TextView f222462d;

    /* renamed from: e, reason: collision with root package name */
    private Runnable f222463e;

    private void z9(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.f222462d.getVisibility() == 0) {
            RFWThreadManager.getUIHandler().removeCallbacks(this.f222463e);
        } else {
            this.f222462d.setVisibility(0);
        }
        RFWThreadManager.getUIHandler().postDelayed(this.f222463e, 2000L);
        this.f222462d.setText(str);
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> eventClass = super.getEventClass();
        eventClass.add(GuildFeedShowBubbleEvent.class);
        return eventClass;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f222462d = (TextView) view.findViewById(R.id.wdf);
        this.f222463e = new Runnable() { // from class: com.tencent.mobileqq.guild.feed.part.GuildFeedRefreshBubblePart.1
            @Override // java.lang.Runnable
            public void run() {
                GuildFeedRefreshBubblePart.this.f222462d.setVisibility(8);
            }
        };
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof GuildFeedShowBubbleEvent) {
            z9(((GuildFeedShowBubbleEvent) simpleBaseEvent).getMsg());
        }
    }
}
