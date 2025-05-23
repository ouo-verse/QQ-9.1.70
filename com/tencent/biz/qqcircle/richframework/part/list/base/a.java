package com.tencent.biz.qqcircle.richframework.part.list.base;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a extends Part implements View.OnClickListener {
    private int C;

    /* renamed from: d, reason: collision with root package name */
    private FrameLayout f91945d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f91946e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f91947f;

    /* renamed from: h, reason: collision with root package name */
    private LinearLayout f91948h;

    /* renamed from: i, reason: collision with root package name */
    private ArrayList<BaseListBlock> f91949i;

    /* renamed from: m, reason: collision with root package name */
    private ViewPager f91950m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.biz.qqcircle.richframework.part.list.base.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class ViewOnClickListenerC0925a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f91951d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f91952e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ BaseListBlock f91953f;

        ViewOnClickListenerC0925a(int i3, View view, BaseListBlock baseListBlock) {
            this.f91951d = i3;
            this.f91952e = view;
            this.f91953f = baseListBlock;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            a.this.B9(this.f91951d);
            if (fb0.a.a(String.valueOf(this.f91952e.hashCode()))) {
                this.f91953f.onDoubleClickTitle();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public a(ArrayList<BaseListBlock> arrayList) {
        this.f91949i = arrayList;
    }

    private void A9(View view) {
        QCircleInitBean qCircleInitBean = QCirclePluginUtil.getQCircleInitBean(view.getContext());
        if (qCircleInitBean != null) {
            this.C = qCircleInitBean.getLaunchTo();
        }
        this.f91950m.addOnPageChangeListener(new b());
        this.f91950m.setCurrentItem(this.C);
        B9(this.C);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B9(int i3) {
        boolean z16;
        for (int i16 = 0; i16 < this.f91949i.size(); i16++) {
            BaseListBlock baseListBlock = this.f91949i.get(i16);
            View childAt = this.f91948h.getChildAt(i3);
            if (i16 == i3) {
                z16 = true;
            } else {
                z16 = false;
            }
            baseListBlock.onTitleTabSelectedChanged(childAt, z16);
        }
        ViewPager viewPager = this.f91950m;
        if (viewPager != null) {
            viewPager.setCurrentItem(i3);
        }
    }

    private void z9() {
        String str;
        ArrayList<BaseListBlock> arrayList = this.f91949i;
        if (arrayList != null) {
            if (arrayList.size() == 1 && this.f91949i.get(0) != null) {
                TextView textView = this.f91947f;
                if (!TextUtils.isEmpty(this.f91949i.get(0).getTitle())) {
                    str = this.f91949i.get(0).getTitle();
                } else {
                    str = "";
                }
                textView.setText(str);
                this.f91949i.get(0).initTitleBar(this.f91945d);
                this.f91948h.setVisibility(8);
            }
            if (this.f91949i.size() > 1) {
                this.f91948h.removeAllViews();
                for (int i3 = 0; i3 < this.f91949i.size(); i3++) {
                    BaseListBlock baseListBlock = this.f91949i.get(i3);
                    View titleTabView = baseListBlock.getTitleTabView(this.f91948h);
                    if (titleTabView != null) {
                        titleTabView.setOnClickListener(new ViewOnClickListenerC0925a(i3, titleTabView, baseListBlock));
                        this.f91948h.addView(titleTabView);
                    }
                }
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "PublicListCommonPart";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ArrayList<BaseListBlock> arrayList;
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.du6) {
            if (!getPartManager().onBackEvent() && getActivity() != null) {
                getActivity().finish();
            }
        } else if (id5 == R.id.kbs && (arrayList = this.f91949i) != null && !ab0.a.a(0, arrayList) && this.f91949i.get(0) != null) {
            if (fb0.a.a("PublicListCommonPart")) {
                this.f91949i.get(0).onDoubleClickTitle();
            } else {
                this.f91949i.get(0).onSingleClickTitle();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        if (view != null) {
            this.f91945d = (FrameLayout) view.findViewById(R.id.v8v);
            this.f91946e = (ImageView) view.findViewById(R.id.du6);
            this.f91947f = (TextView) view.findViewById(R.id.kbs);
            this.f91948h = (LinearLayout) view.findViewById(R.id.yqy);
            this.f91950m = (ViewPager) view.findViewById(R.id.f12031798);
            this.f91946e.setOnClickListener(this);
            this.f91947f.setOnClickListener(this);
            if (getHostFragment() instanceof QCircleBaseFragment) {
                ((QCircleBaseFragment) getHostFragment()).setExcludeInteractiveView(this.f91946e);
            }
            z9();
            A9(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b implements ViewPager.OnPageChangeListener {
        b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i3) {
            a.this.B9(i3);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i3) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i3, float f16, int i16) {
        }
    }
}
