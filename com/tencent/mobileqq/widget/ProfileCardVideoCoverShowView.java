package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.widget.OverScrollCallbackHorizontalListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes20.dex */
public class ProfileCardVideoCoverShowView extends FrameLayout implements OverScrollCallbackHorizontalListView.a, AdapterView.OnItemClickListener {

    /* renamed from: d, reason: collision with root package name */
    private OverScrollCallbackHorizontalListView f315976d;

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<c> f315977e;

    /* renamed from: f, reason: collision with root package name */
    private BaseAdapter f315978f;

    /* loaded from: classes20.dex */
    class a extends BaseAdapter {
        a() {
        }

        @Override // android.widget.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c getItem(int i3) {
            return (c) ProfileCardVideoCoverShowView.this.f315977e.get(i3);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return ProfileCardVideoCoverShowView.this.f315977e.size();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(ProfileCardVideoCoverShowView.this.getContext()).inflate(R.layout.azj, (ViewGroup) null, false);
                view.setTag((ImageView) view.findViewById(R.id.image));
                StateListDrawable stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(FrameLayout.PRESSED_ENABLED_STATE_SET, new ColorDrawable(855638016));
                stateListDrawable.addState(FrameLayout.EMPTY_STATE_SET, new ColorDrawable(0));
                view.findViewById(R.id.f167006jv1).setBackgroundDrawable(stateListDrawable);
            }
            ImageView imageView = (ImageView) view.getTag();
            c item = getItem(i3);
            if (TextUtils.isEmpty(item.f315982c)) {
                imageView.setImageDrawable(null);
            } else {
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                ColorDrawable colorDrawable = new ColorDrawable(0);
                obtain.mLoadingDrawable = colorDrawable;
                obtain.mFailedDrawable = colorDrawable;
                obtain.mRequestHeight = BaseAIOUtils.f(178.0f, ProfileCardVideoCoverShowView.this.getResources());
                obtain.mRequestWidth = BaseAIOUtils.f(100.0f, ProfileCardVideoCoverShowView.this.getResources());
                imageView.setImageDrawable(URLDrawable.getDrawable(item.f315982c, obtain));
            }
            if (i3 == 0) {
                view.setPadding(BaseAIOUtils.f(12.0f, ProfileCardVideoCoverShowView.this.getResources()), 0, 0, 0);
            } else {
                view.setPadding(0, 0, 0, 0);
            }
            EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
            return view;
        }
    }

    /* loaded from: classes20.dex */
    public interface b {
    }

    /* loaded from: classes20.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public int f315980a;

        /* renamed from: b, reason: collision with root package name */
        public int f315981b = 0;

        /* renamed from: c, reason: collision with root package name */
        public String f315982c;

        /* renamed from: d, reason: collision with root package name */
        public String f315983d;

        /* renamed from: e, reason: collision with root package name */
        public String f315984e;

        /* renamed from: f, reason: collision with root package name */
        public String f315985f;

        /* renamed from: g, reason: collision with root package name */
        public String f315986g;

        public String toString() {
            StringBuilder sb5 = new StringBuilder(64);
            sb5.append("DataItem:position=");
            sb5.append(this.f315980a);
            sb5.append(", type=");
            sb5.append(this.f315981b);
            sb5.append(", coverUrl=");
            sb5.append(this.f315982c);
            sb5.append(", feedId=");
            sb5.append(this.f315983d);
            sb5.append(", vid=");
            sb5.append(this.f315984e);
            sb5.append(", jumpUrl=");
            sb5.append(this.f315985f);
            sb5.append(", spiritImageUrl=");
            sb5.append(this.f315986g);
            return sb5.toString();
        }
    }

    public ProfileCardVideoCoverShowView(@NonNull Context context) {
        super(context);
        this.f315977e = new ArrayList<>(10);
        this.f315978f = new a();
        e();
    }

    private void e() {
        LayoutInflater.from(getContext()).inflate(R.layout.azk, (ViewGroup) this, true);
        OverScrollCallbackHorizontalListView overScrollCallbackHorizontalListView = (OverScrollCallbackHorizontalListView) findViewById(R.id.ebs);
        this.f315976d = overScrollCallbackHorizontalListView;
        overScrollCallbackHorizontalListView.setListener(this);
        this.f315976d.setDividerWidth(BaseAIOUtils.f(2.0f, getResources()));
        this.f315976d.setAdapter((ListAdapter) this.f315978f);
        this.f315976d.setOnItemClickListener(this);
        this.f315976d.setOverScrollMode(1);
    }

    @Override // com.tencent.mobileqq.widget.OverScrollCallbackHorizontalListView.a
    public void a(OverScrollCallbackHorizontalListView overScrollCallbackHorizontalListView) {
        if (QLog.isColorLevel()) {
            QLog.i("ProfileCardMicroVideoContentView", 2, "onOverScrollRight");
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
        EventCollector.getInstance().onItemClickBefore(adapterView, view, i3, j3);
        if (QLog.isColorLevel()) {
            QLog.i("ProfileCardMicroVideoContentView", 2, "onItemClick " + i3);
        }
        EventCollector.getInstance().onItemClick(adapterView, view, i3, j3);
    }

    public void setData(List<c> list) {
        Object valueOf;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("setData list=");
            if (list == null) {
                valueOf = "null";
            } else {
                valueOf = Integer.valueOf(list.size());
            }
            sb5.append(valueOf);
            QLog.i("ProfileCardMicroVideoContentView", 2, sb5.toString());
        }
        this.f315977e.clear();
        if (list != null && list.size() > 0) {
            this.f315977e.addAll(list);
        }
        if (list != null && list.size() != 0) {
            if (list.size() > (getResources().getDisplayMetrics().widthPixels * 1.0f) / BaseAIOUtils.f(114.0f, getResources())) {
                this.f315976d.setOverScrollMode(0);
            } else {
                this.f315976d.setOverScrollMode(1);
            }
        } else {
            this.f315976d.setOverScrollMode(1);
        }
        this.f315978f.notifyDataSetChanged();
    }

    public ProfileCardVideoCoverShowView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f315977e = new ArrayList<>(10);
        this.f315978f = new a();
        e();
    }

    public ProfileCardVideoCoverShowView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f315977e = new ArrayList<>(10);
        this.f315978f = new a();
        e();
    }

    public void setCallback(b bVar) {
    }
}
