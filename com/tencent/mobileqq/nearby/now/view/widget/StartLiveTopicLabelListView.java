package com.tencent.mobileqq.nearby.now.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.tencent.av.utils.api.IUIToolsApi;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.nearby.now.IResourceUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public class StartLiveTopicLabelListView extends LinearLayout {
    private int C;
    private int D;
    private BaseAdapter E;

    /* renamed from: d, reason: collision with root package name */
    private final String f252994d;

    /* renamed from: e, reason: collision with root package name */
    private Context f252995e;

    /* renamed from: f, reason: collision with root package name */
    private HorizontalListView f252996f;

    /* renamed from: h, reason: collision with root package name */
    private List<String> f252997h;

    /* renamed from: i, reason: collision with root package name */
    private int f252998i;

    /* renamed from: m, reason: collision with root package name */
    private int f252999m;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a extends BaseAdapter {

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.nearby.now.view.widget.StartLiveTopicLabelListView$a$a, reason: collision with other inner class name */
        /* loaded from: classes15.dex */
        class ViewOnClickListenerC8144a implements View.OnClickListener {
            ViewOnClickListenerC8144a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                if (view != null) {
                    StartLiveTopicLabelListView.g(StartLiveTopicLabelListView.this);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        a() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (StartLiveTopicLabelListView.this.f252997h != null && StartLiveTopicLabelListView.this.f252997h.size() != 0) {
                return StartLiveTopicLabelListView.this.f252997h.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return 0L;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            View view2;
            c cVar;
            if (view == null) {
                cVar = new c(StartLiveTopicLabelListView.this, null);
                TopicViewItem topicViewItem = new TopicViewItem(StartLiveTopicLabelListView.this.f252995e);
                topicViewItem.setTag(cVar);
                view2 = topicViewItem;
            } else {
                view2 = view;
                cVar = (c) view.getTag();
            }
            cVar.f253002a = (String) StartLiveTopicLabelListView.this.f252997h.get(i3);
            if (HardCodeUtil.qqStr(((IResourceUtil) QRoute.api(IResourceUtil.class)).getQQStrStartlivBe188c1d()).equals(cVar.f253002a)) {
                view2.setBackgroundResource(StartLiveTopicLabelListView.this.C);
                ((TopicViewItem) view2).setTextColor(StartLiveTopicLabelListView.this.D);
            } else {
                view2.setBackgroundResource(StartLiveTopicLabelListView.this.f252998i);
                ((TopicViewItem) view2).setTextColor(StartLiveTopicLabelListView.this.f252999m);
            }
            view2.setOnClickListener(new ViewOnClickListenerC8144a());
            ((TopicViewItem) view2).setText(cVar.f253002a);
            EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
            return view2;
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface b {
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    private final class c {

        /* renamed from: a, reason: collision with root package name */
        String f253002a;

        c() {
        }

        /* synthetic */ c(StartLiveTopicLabelListView startLiveTopicLabelListView, a aVar) {
            this();
        }
    }

    public StartLiveTopicLabelListView(Context context) {
        super(context);
        this.f252994d = "TopicLabelListView";
        this.f252998i = ((IResourceUtil) QRoute.api(IResourceUtil.class)).getQQNearbyNowBgStartLiveNormalGap();
        this.f252999m = -1;
        this.C = ((IResourceUtil) QRoute.api(IResourceUtil.class)).getQQNearbyNowBgStartLiveGap();
        this.D = -1;
        this.E = new a();
        h(context);
    }

    static /* synthetic */ b g(StartLiveTopicLabelListView startLiveTopicLabelListView) {
        startLiveTopicLabelListView.getClass();
        return null;
    }

    private void h(Context context) {
        this.f252995e = context;
        HorizontalListView horizontalListView = new HorizontalListView(context);
        this.f252996f = horizontalListView;
        horizontalListView.setDividerWidth((int) ((IUIToolsApi) QRoute.api(IUIToolsApi.class)).dp2px(context, 5.0f));
        this.f252996f.setAdapter((ListAdapter) this.E);
        addView(this.f252996f, -1, -1);
    }

    public void setData(List<String> list) {
        this.f252997h = list;
        this.E.notifyDataSetChanged();
    }

    public void setItemAddLabelResId(int i3) {
        this.C = i3;
    }

    public void setItemAddLabelTextColor(int i3) {
        this.D = i3;
    }

    public void setItemResId(int i3) {
        this.f252998i = i3;
    }

    public void setItemTextColor(int i3) {
        this.f252999m = i3;
    }

    public StartLiveTopicLabelListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f252994d = "TopicLabelListView";
        this.f252998i = ((IResourceUtil) QRoute.api(IResourceUtil.class)).getQQNearbyNowBgStartLiveNormalGap();
        this.f252999m = -1;
        this.C = ((IResourceUtil) QRoute.api(IResourceUtil.class)).getQQNearbyNowBgStartLiveGap();
        this.D = -1;
        this.E = new a();
        h(context);
    }

    public StartLiveTopicLabelListView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f252994d = "TopicLabelListView";
        this.f252998i = ((IResourceUtil) QRoute.api(IResourceUtil.class)).getQQNearbyNowBgStartLiveNormalGap();
        this.f252999m = -1;
        this.C = ((IResourceUtil) QRoute.api(IResourceUtil.class)).getQQNearbyNowBgStartLiveGap();
        this.D = -1;
        this.E = new a();
        h(context);
    }
}
