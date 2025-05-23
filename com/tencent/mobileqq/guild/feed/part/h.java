package com.tencent.mobileqq.guild.feed.part;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.event.GuildFeedVideoCurrentTimeEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFullScreenCloseEvent;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedFullScreenBean;
import com.tencent.mobileqq.guild.feed.presenter.GuildFeedFullScreenVideoPresenter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes13.dex */
public class h extends d implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private GuildFeedFullScreenBean f222554d;

    /* renamed from: e, reason: collision with root package name */
    private GuildFeedFullScreenVideoPresenter f222555e = new GuildFeedFullScreenVideoPresenter();

    /* renamed from: f, reason: collision with root package name */
    private FrameLayout f222556f;

    public h() {
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(GuildFullScreenCloseEvent.class);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSFullScreenVideoPart";
    }

    protected void initData() {
        if (getActivity() != null && getActivity().getIntent() != null && getActivity().getIntent().hasExtra(com.tencent.mobileqq.guild.feed.b.f218115a)) {
            GuildFeedFullScreenBean guildFeedFullScreenBean = (GuildFeedFullScreenBean) getActivity().getIntent().getSerializableExtra(com.tencent.mobileqq.guild.feed.b.f218115a);
            this.f222554d = guildFeedFullScreenBean;
            if (guildFeedFullScreenBean != null && this.f222555e != null) {
                guildFeedFullScreenBean.getFeed().videos.clear();
                this.f222554d.getFeed().videos.add(this.f222554d.getVideo());
                this.f222555e.F(this.f222554d.getFeed());
                this.f222555e.M(0);
                this.f222555e.L(Long.valueOf(this.f222554d.getCurrentVideoPos()));
                return;
            }
            getActivity().finish();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        if (this.f222555e != null) {
            SimpleEventBus.getInstance().dispatchEvent(new GuildFeedVideoCurrentTimeEvent(this.f222555e.y(), this.f222555e.z()));
            return false;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        GuildFeedFullScreenVideoPresenter guildFeedFullScreenVideoPresenter;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null && view.getId() == R.id.wfj && (guildFeedFullScreenVideoPresenter = this.f222555e) != null) {
            guildFeedFullScreenVideoPresenter.r();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        x9(view);
        initData();
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        this.f222555e.H();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStop(Activity activity) {
        super.onPartStop(activity);
        this.f222555e.I();
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof GuildFullScreenCloseEvent) {
            getActivity().onBackPressed();
        }
    }

    protected void x9(View view) {
        this.f222555e.G(view);
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.wfj);
        this.f222556f = frameLayout;
        frameLayout.setOnClickListener(this);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
    }
}
