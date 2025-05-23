package com.tencent.mobileqq.guild.feed.part;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.event.GuildFeedListFirstLoadingEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes13.dex */
public class ak extends f implements View.OnTouchListener {

    /* renamed from: h, reason: collision with root package name */
    private View f222511h;

    private boolean B9() {
        UIStateData<List<ij1.g>> value;
        com.tencent.mobileqq.guild.feed.viewmodel.l lVar = this.f222550e;
        if (lVar == null || lVar.j() == null || (value = this.f222550e.j().getValue()) == null || value.getData() == null) {
            return true;
        }
        return value.getData().isEmpty();
    }

    private void C9(GuildFeedListFirstLoadingEvent guildFeedListFirstLoadingEvent) {
        if (guildFeedListFirstLoadingEvent.isLoadingFinish()) {
            this.f222511h.setVisibility(8);
            this.f222511h.setOnTouchListener(null);
        } else {
            this.f222511h.setVisibility(0);
            this.f222511h.setOnTouchListener(this);
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> eventClass = super.getEventClass();
        eventClass.add(GuildFeedListFirstLoadingEvent.class);
        return eventClass;
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "GuildFeedLoadingInterceptPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        View findViewById = view.findViewById(R.id.wbr);
        this.f222511h = findViewById;
        findViewById.setOnTouchListener(this);
        if (!B9()) {
            QLog.i("GuildFeedLoadingInterceptPart", 1, "onInitView: has data, not show.");
            this.f222511h.setVisibility(8);
        } else {
            QLog.i("GuildFeedLoadingInterceptPart", 1, "onInitView: data is empty, show view.");
            this.f222511h.setVisibility(0);
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof GuildFeedListFirstLoadingEvent) {
            C9((GuildFeedListFirstLoadingEvent) simpleBaseEvent);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return true;
    }
}
