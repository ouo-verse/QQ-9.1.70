package com.tencent.biz.subscribe.account_folder.recommend_banner;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.biz.subscribe.event.RecommendFeedbackEvent;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RecommendBannerView extends LinearLayout implements View.OnClickListener, SimpleEventReceiver {

    /* renamed from: d, reason: collision with root package name */
    private RecyclerView f95643d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f95644e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f95645f;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.biz.subscribe.account_folder.top_pannel.a f95646h;

    /* renamed from: i, reason: collision with root package name */
    private TopRecommendBannerAdapter f95647i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements com.tencent.biz.subscribe.account_folder.recommend_banner.a {
        a() {
        }

        @Override // com.tencent.biz.subscribe.account_folder.recommend_banner.a
        public void a(boolean z16, int i3) {
            if (z16) {
                RecommendBannerView.this.b(i3);
            }
        }
    }

    public RecommendBannerView(Context context) {
        super(context);
        d(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i3) {
        com.tencent.biz.subscribe.account_folder.top_pannel.a aVar;
        if (i3 < this.f95647i.getItemCount()) {
            this.f95647i.remove(i3);
            if (!this.f95647i.z() && !this.f95647i.A() && (aVar = this.f95646h) != null) {
                aVar.f();
            }
            c();
        }
    }

    public void c() {
        if (this.f95647i.A() && this.f95645f.getVisibility() == 0) {
            this.f95644e.setVisibility(8);
            this.f95645f.setVisibility(8);
        }
    }

    protected void d(Context context) {
        setOrientation(1);
        View.inflate(context, R.layout.f167706em, this);
        this.f95643d = (RecyclerView) findViewById(R.id.a5c);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(0);
        this.f95643d.setLayoutManager(linearLayoutManager);
        this.f95643d.addItemDecoration(new c());
        TopRecommendBannerAdapter topRecommendBannerAdapter = new TopRecommendBannerAdapter(this.f95643d);
        this.f95647i = topRecommendBannerAdapter;
        topRecommendBannerAdapter.y(SubscribeUtils.m());
        this.f95643d.setAdapter(this.f95647i);
        this.f95647i.w(new a());
        this.f95644e = (ImageView) findViewById(R.id.m5b);
        TextView textView = (TextView) findViewById(R.id.m5c);
        this.f95645f = textView;
        textView.setOnClickListener(this);
        this.f95644e.setOnClickListener(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(RecommendFeedbackEvent.class);
        return arrayList;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.m5b || id5 == R.id.m5c) {
            TopRecommendBannerAdapter topRecommendBannerAdapter = this.f95647i;
            if (topRecommendBannerAdapter != null && this.f95646h != null) {
                if (!topRecommendBannerAdapter.B() && !this.f95647i.A()) {
                    this.f95646h.f();
                } else {
                    this.f95643d.smoothScrollToPosition(0);
                }
                c();
            }
            VSReporter.n(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "auth_page", "clk_change", 0, 0, new String[0]);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (!(simpleBaseEvent instanceof RecommendFeedbackEvent) || this.f95647i == null) {
            return;
        }
        int i3 = 0;
        while (true) {
            if (i3 < this.f95647i.p().size()) {
                RecommendFeedbackEvent recommendFeedbackEvent = (RecommendFeedbackEvent) simpleBaseEvent;
                if ((recommendFeedbackEvent.type == 1 && recommendFeedbackEvent.user != null && TextUtils.equals(this.f95647i.p().get(i3).f441499b.f24929id.get(), recommendFeedbackEvent.user.f24929id.get())) || (recommendFeedbackEvent.type == 2 && recommendFeedbackEvent.feed != null && TextUtils.equals(this.f95647i.p().get(i3).f441500c.f24925id.get(), recommendFeedbackEvent.feed.f24925id.get()))) {
                    break;
                } else {
                    i3++;
                }
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 != -1) {
            b(i3);
        }
    }

    public void setPresenter(com.tencent.biz.subscribe.account_folder.top_pannel.a aVar) {
        this.f95646h = aVar;
    }

    public RecommendBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d(context);
    }
}
