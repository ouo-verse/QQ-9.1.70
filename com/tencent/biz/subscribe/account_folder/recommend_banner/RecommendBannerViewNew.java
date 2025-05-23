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
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RecommendBannerViewNew extends LinearLayout implements View.OnClickListener, SimpleEventReceiver {
    private TopRecommendBannerAdapter C;
    private View D;
    private boolean E;

    /* renamed from: d, reason: collision with root package name */
    private RecyclerView f95649d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f95650e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f95651f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f95652h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f95653i;

    /* renamed from: m, reason: collision with root package name */
    private com.tencent.biz.subscribe.account_folder.top_pannel.a f95654m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements com.tencent.biz.subscribe.account_folder.recommend_banner.a {
        a() {
        }

        @Override // com.tencent.biz.subscribe.account_folder.recommend_banner.a
        public void a(boolean z16, int i3) {
            if (z16) {
                RecommendBannerViewNew.this.b(i3);
            }
        }
    }

    public RecommendBannerViewNew(Context context) {
        super(context);
        this.E = false;
        d(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i3) {
        com.tencent.biz.subscribe.account_folder.top_pannel.a aVar;
        if (i3 < this.C.getItemCount()) {
            this.C.remove(i3);
            if (!this.C.z() && !this.C.A() && (aVar = this.f95654m) != null) {
                aVar.f();
            }
            c();
        }
    }

    public void c() {
        if (this.C.A() && this.f95652h.getVisibility() == 0) {
            this.f95650e.setVisibility(8);
            this.f95652h.setVisibility(8);
        }
    }

    protected void d(Context context) {
        this.E = SubscribeUtils.m();
        setOrientation(1);
        View.inflate(context, R.layout.c7_, this);
        this.f95649d = (RecyclerView) findViewById(R.id.a5c);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(0);
        this.f95649d.setLayoutManager(linearLayoutManager);
        this.f95649d.addItemDecoration(new c());
        TopRecommendBannerAdapter topRecommendBannerAdapter = new TopRecommendBannerAdapter(this.f95649d);
        this.C = topRecommendBannerAdapter;
        topRecommendBannerAdapter.y(this.E);
        this.C.x(true);
        this.f95649d.setAdapter(this.C);
        this.C.w(new a());
        this.f95651f = (ImageView) findViewById(R.id.dum);
        this.D = findViewById(R.id.f164999bn3);
        this.f95653i = (TextView) findViewById(R.id.i38);
        this.f95650e = (ImageView) findViewById(R.id.m5b);
        TextView textView = (TextView) findViewById(R.id.m5c);
        this.f95652h = textView;
        textView.setOnClickListener(this);
        this.f95650e.setOnClickListener(this);
        if (this.E) {
            this.f95650e.setImageDrawable(getResources().getDrawable(R.drawable.hm9));
            this.f95651f.setImageDrawable(getResources().getDrawable(R.drawable.hlo));
            this.D.setBackgroundColor(-9211021);
            this.f95653i.setTextColor(-10132123);
            this.f95652h.setTextColor(-10132123);
        }
        if (SimpleUIUtil.isNowElderMode()) {
            this.f95653i.setTextSize(0, ViewUtils.dpToPx(18.0f));
        }
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
            TopRecommendBannerAdapter topRecommendBannerAdapter = this.C;
            if (topRecommendBannerAdapter != null && this.f95654m != null) {
                if (!topRecommendBannerAdapter.B() && !this.C.A()) {
                    this.f95654m.f();
                } else {
                    this.f95649d.smoothScrollToPosition(0);
                }
                c();
            }
            VSReporter.n(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "auth_discover", "change_clk", 0, 0, new String[0]);
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
        if (!(simpleBaseEvent instanceof RecommendFeedbackEvent) || this.C == null) {
            return;
        }
        int i3 = 0;
        while (true) {
            if (i3 < this.C.p().size()) {
                RecommendFeedbackEvent recommendFeedbackEvent = (RecommendFeedbackEvent) simpleBaseEvent;
                if ((recommendFeedbackEvent.type == 1 && recommendFeedbackEvent.user != null && TextUtils.equals(this.C.p().get(i3).f441499b.f24929id.get(), recommendFeedbackEvent.user.f24929id.get())) || (recommendFeedbackEvent.type == 2 && recommendFeedbackEvent.feed != null && TextUtils.equals(this.C.p().get(i3).f441500c.f24925id.get(), recommendFeedbackEvent.feed.f24925id.get()))) {
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
        this.f95654m = aVar;
    }

    public RecommendBannerViewNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.E = false;
        d(context);
    }
}
