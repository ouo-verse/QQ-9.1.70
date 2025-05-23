package com.tencent.mobileqq.nearby.now.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.tencent.av.utils.api.IUIToolsApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public class TopicLabelListView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name */
    private final String f253004d;

    /* renamed from: e, reason: collision with root package name */
    private Context f253005e;

    /* renamed from: f, reason: collision with root package name */
    private HorizontalListView f253006f;

    /* renamed from: h, reason: collision with root package name */
    private List<String> f253007h;

    /* renamed from: i, reason: collision with root package name */
    private BaseAdapter f253008i;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a extends BaseAdapter {
        a() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (TopicLabelListView.this.f253007h != null && TopicLabelListView.this.f253007h.size() != 0) {
                return TopicLabelListView.this.f253007h.size();
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
            b bVar;
            if (view == null) {
                bVar = new b(TopicLabelListView.this, null);
                LabelViewItem labelViewItem = new LabelViewItem(TopicLabelListView.this.f253005e);
                labelViewItem.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                labelViewItem.setTag(bVar);
                view2 = labelViewItem;
            } else {
                view2 = view;
                bVar = (b) view.getTag();
            }
            String str = (String) TopicLabelListView.this.f253007h.get(i3);
            bVar.f253010a = str;
            ((LabelViewItem) view2).setText(str);
            EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
            return view2;
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    private final class b {

        /* renamed from: a, reason: collision with root package name */
        String f253010a;

        b() {
        }

        /* synthetic */ b(TopicLabelListView topicLabelListView, a aVar) {
            this();
        }
    }

    public TopicLabelListView(Context context) {
        super(context);
        this.f253004d = "TopicLabelListView";
        this.f253008i = new a();
        c(context);
    }

    private void c(Context context) {
        this.f253005e = context;
        HorizontalListView horizontalListView = new HorizontalListView(context);
        this.f253006f = horizontalListView;
        horizontalListView.setDividerWidth((int) ((IUIToolsApi) QRoute.api(IUIToolsApi.class)).dp2px(context, 5.0f));
        this.f253006f.setAdapter((ListAdapter) this.f253008i);
        addView(this.f253006f, -1, -1);
    }

    public void setData(List<String> list) {
        this.f253007h = list;
        this.f253008i.notifyDataSetChanged();
    }

    public TopicLabelListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f253004d = "TopicLabelListView";
        this.f253008i = new a();
        c(context);
    }

    public TopicLabelListView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f253004d = "TopicLabelListView";
        this.f253008i = new a();
        c(context);
    }
}
