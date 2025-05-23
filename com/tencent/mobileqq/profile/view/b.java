package com.tencent.mobileqq.profile.view;

import android.content.Context;
import android.graphics.Color;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ToggleButton;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emoticonview.PanelRecycleBin;
import com.tencent.mobileqq.profile.ProfileLabelTypeInfo;
import com.tencent.mobileqq.profile.view.ProfileLabelPanel;
import com.tencent.mobileqq.profilecard.entity.ProfileLabelInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b extends PagerAdapter implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    protected a C;
    protected SparseArray<a> D;
    protected ProfileLabelPanel.a E;

    /* renamed from: d, reason: collision with root package name */
    protected List<ProfileLabelTypeInfo> f260524d;

    /* renamed from: e, reason: collision with root package name */
    protected PanelRecycleBin f260525e;

    /* renamed from: f, reason: collision with root package name */
    protected Context f260526f;

    /* renamed from: h, reason: collision with root package name */
    protected int f260527h;

    /* renamed from: i, reason: collision with root package name */
    protected float f260528i;

    /* renamed from: m, reason: collision with root package name */
    protected com.tencent.mobileqq.profile.view.a f260529m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class a extends BaseAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        List<ProfileLabelInfo> f260530d;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        public void a(List<ProfileLabelInfo> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
            } else {
                this.f260530d = list;
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.f260530d.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return iPatchRedirector.redirect((short) 4, (Object) this, i3);
            }
            return this.f260530d.get(i3);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Long) iPatchRedirector.redirect((short) 5, (Object) this, i3)).longValue();
            }
            return i3;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            View view2;
            ToggleButton toggleButton;
            View view3;
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = true;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                view2 = (View) iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), view, viewGroup);
                view3 = view;
            } else {
                if (view == null) {
                    toggleButton = new ToggleButton(b.this.f260526f);
                    toggleButton.setLayoutParams(new AbsListView.LayoutParams(-1, (int) (b.this.f260528i * 28.0f)));
                    toggleButton.setBackgroundResource(R.drawable.b5t);
                    toggleButton.setGravity(17);
                    toggleButton.setTextSize(b.this.f260526f.getResources().getInteger(R.integer.f167154g));
                    toggleButton.setTextColor(Color.parseColor("#777777"));
                    toggleButton.setOnClickListener(b.this);
                    view2 = toggleButton;
                } else {
                    view2 = view;
                    toggleButton = (ToggleButton) view;
                }
                ProfileLabelInfo profileLabelInfo = (ProfileLabelInfo) getItem(i3);
                if (profileLabelInfo != null) {
                    toggleButton.setTag(profileLabelInfo);
                    if (profileLabelInfo.labelStatus != ProfileLabelInfo.STATUS_CHECKED) {
                        z16 = false;
                    }
                    toggleButton.setChecked(z16);
                    toggleButton.setText(profileLabelInfo.labelName);
                    toggleButton.setTextOn(profileLabelInfo.labelName);
                    toggleButton.setTextOff(profileLabelInfo.labelName);
                    if (profileLabelInfo.labelStatus == ProfileLabelInfo.STATUS_CHECKED) {
                        b.this.E.a(profileLabelInfo, toggleButton);
                    }
                } else {
                    toggleButton.setVisibility(8);
                }
                view3 = view2;
            }
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view2;
        }
    }

    public b(Context context, List<ProfileLabelTypeInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) list);
            return;
        }
        this.f260525e = new PanelRecycleBin();
        this.f260526f = context;
        this.f260524d = list;
        this.f260528i = context.getResources().getDisplayMetrics().density;
        this.f260527h = this.f260524d.size();
    }

    protected GridView d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (GridView) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        GridView gridView = new GridView(this.f260526f);
        float f16 = this.f260528i;
        gridView.setPadding((int) (f16 * 10.0f), 0, (int) (f16 * 10.0f), 0);
        gridView.setNumColumns(4);
        gridView.setHorizontalSpacing((int) (this.f260528i * 4.0f));
        gridView.setVerticalSpacing((int) (this.f260528i * 4.0f));
        return gridView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(View view, int i3, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, view, Integer.valueOf(i3), obj);
        } else {
            ((ViewGroup) view).removeView((GridView) obj);
            this.f260525e.addScrapView((View) obj);
        }
    }

    public void e(com.tencent.mobileqq.profile.view.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        } else {
            this.f260529m = aVar;
        }
    }

    public void f(ProfileLabelPanel.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        } else {
            this.E = aVar;
        }
    }

    protected void g(View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view, i3);
            return;
        }
        if (this.D == null) {
            this.D = new SparseArray<>();
        }
        a aVar = this.D.get(i3);
        this.C = aVar;
        if (aVar == null) {
            a aVar2 = new a();
            this.C = aVar2;
            this.D.put(i3, aVar2);
        }
        this.C.a(this.f260524d.get(i3).labels);
        ((GridView) view).setAdapter((ListAdapter) this.C);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: getCount */
    public int getF373114d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.f260527h;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return iPatchRedirector.redirect((short) 5, (Object) this, (Object) view, i3);
        }
        GridView gridView = (GridView) this.f260525e.getScrapView();
        if (gridView == null) {
            gridView = d();
        }
        g(gridView, i3);
        if (gridView.getParent() != view && i3 < getF373114d()) {
            ((ViewGroup) view).addView(gridView);
        }
        return gridView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) view, obj)).booleanValue();
        }
        if (view == obj) {
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) view);
        } else {
            ToggleButton toggleButton = (ToggleButton) view;
            toggleButton.toggle();
            ProfileLabelInfo profileLabelInfo = (ProfileLabelInfo) view.getTag();
            if (profileLabelInfo != null) {
                com.tencent.mobileqq.profile.view.a aVar = this.f260529m;
                if (profileLabelInfo.labelStatus == ProfileLabelInfo.STATUS_CHECKED) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                aVar.a(profileLabelInfo, toggleButton, Boolean.valueOf(z16));
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
