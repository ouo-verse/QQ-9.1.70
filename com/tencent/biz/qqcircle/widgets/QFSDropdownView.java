package com.tencent.biz.qqcircle.widgets;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListPopupWindow;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSDropdownView extends LinearLayout implements View.OnClickListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener {
    private int C;
    private int D;
    private boolean E;
    private int F;
    private int G;
    private ObjectAnimator H;
    private Drawable I;
    private boolean J;

    /* renamed from: d, reason: collision with root package name */
    private TextView f93208d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f93209e;

    /* renamed from: f, reason: collision with root package name */
    private ListPopupWindow f93210f;

    /* renamed from: h, reason: collision with root package name */
    private a f93211h;

    /* renamed from: i, reason: collision with root package name */
    private final List<String> f93212i;

    /* renamed from: m, reason: collision with root package name */
    private int f93213m;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    private static class a extends BaseAdapter {

        /* renamed from: d, reason: collision with root package name */
        private List<String> f93214d;

        /* renamed from: e, reason: collision with root package name */
        private int f93215e = 0;

        a() {
        }

        @Override // android.widget.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String getItem(int i3) {
            List<String> list = this.f93214d;
            if (list != null && list.size() >= i3) {
                return this.f93214d.get(i3);
            }
            return null;
        }

        public void b(List<String> list) {
            this.f93214d = list;
            notifyDataSetChanged();
        }

        public void c(int i3) {
            this.f93215e = i3;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<String> list = this.f93214d;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            int i16 = 0;
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.gdj, viewGroup, false);
            }
            ((TextView) view.findViewById(R.id.kbk)).setText(getItem(i3));
            ImageView imageView = (ImageView) view.findViewById(R.id.duj);
            if (i3 != this.f93215e) {
                i16 = 8;
            }
            imageView.setVisibility(i16);
            EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
            return view;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface b {
    }

    public QFSDropdownView(@NonNull Context context) {
        super(context);
        this.f93212i = new ArrayList();
        this.f93213m = 0;
        this.H = null;
        e();
    }

    private void a(boolean z16) {
        int i3;
        Drawable drawable = this.I;
        if (drawable == null) {
            return;
        }
        int i16 = 10000;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 10000;
        }
        if (!z16) {
            i16 = 0;
        }
        ObjectAnimator ofInt = ObjectAnimator.ofInt(drawable, "level", i3, i16);
        this.H = ofInt;
        ofInt.setInterpolator(new LinearOutSlowInInterpolator());
        this.H.start();
    }

    private void c() {
        a(false);
    }

    private void d(View view) {
        this.f93210f.setAnchorView(view);
        this.f93210f.setWidth(DisplayUtil.getScreenWidth());
        this.f93210f.show();
        if (this.f93210f.getListView() != null) {
            this.f93210f.getListView().setSelector(17170445);
            this.f93210f.getListView().setDivider(null);
            this.f93210f.getListView().setDividerHeight(0);
        }
        a(true);
    }

    private void e() {
        Typeface typeface;
        this.C = 18;
        this.D = QFSQUIUtilsKt.d(getContext(), R.color.qui_common_text_primary);
        this.E = true;
        this.I = f();
        this.F = cx.a(10.0f);
        this.G = cx.a(6.0f);
        TextView textView = new TextView(getContext());
        this.f93208d = textView;
        textView.setTextSize(this.C);
        this.f93208d.setTextColor(this.D);
        TextView textView2 = this.f93208d;
        if (this.E) {
            typeface = Typeface.DEFAULT_BOLD;
        } else {
            typeface = Typeface.DEFAULT;
        }
        textView2.setTypeface(typeface);
        addView(this.f93208d, new LinearLayout.LayoutParams(-2, -2));
        ImageView imageView = new ImageView(getContext());
        this.f93209e = imageView;
        imageView.setImageDrawable(this.I);
        int i3 = this.F;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i3);
        layoutParams.leftMargin = this.G;
        this.f93209e.setVisibility(8);
        addView(this.f93209e, layoutParams);
        ListPopupWindow listPopupWindow = new ListPopupWindow(getContext());
        this.f93210f = listPopupWindow;
        listPopupWindow.setAnimationStyle(0);
        this.f93210f.setBackgroundDrawable(getContext().getResources().getDrawable(R.drawable.kkg));
        this.f93210f.setWidth(DisplayUtil.getScreenWidth());
        this.f93210f.setHeight(-2);
        this.f93210f.setModal(true);
        this.f93210f.setOnItemClickListener(this);
        this.f93210f.setOnDismissListener(this);
        setOnClickListener(this);
    }

    private Drawable f() {
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.kif);
        if (drawable != null) {
            Drawable mutate = DrawableCompat.wrap(drawable).mutate();
            mutate.setColorFilter(new PorterDuffColorFilter(QFSQUIUtilsKt.d(getContext(), R.color.qui_common_icon_primary), PorterDuff.Mode.SRC_ATOP));
            return mutate;
        }
        return drawable;
    }

    private void g() {
        int i3;
        ImageView imageView = this.f93209e;
        if (!this.J && this.f93212i.size() > 1) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
    }

    public String b(int i3) {
        if (this.f93212i.size() < i3) {
            return "";
        }
        return this.f93212i.get(i3);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        List<String> list;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null && (list = this.f93212i) != null && list.size() > 1) {
            d(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        c();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
        EventCollector.getInstance().onItemClickBefore(adapterView, view, i3, j3);
        this.f93208d.setText(b(i3));
        this.f93210f.dismiss();
        this.f93213m = i3;
        a aVar = this.f93211h;
        if (aVar != null) {
            aVar.c(i3);
        }
        EventCollector.getInstance().onItemClick(adapterView, view, i3, j3);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i3) {
        super.onVisibilityChanged(view, i3);
        g();
    }

    public void setItems(List<String> list) {
        if (this.f93211h == null) {
            a aVar = new a();
            this.f93211h = aVar;
            this.f93210f.setAdapter(aVar);
        }
        this.f93212i.clear();
        if (list != null) {
            this.f93212i.addAll(list);
        }
        this.f93211h.b(this.f93212i);
    }

    public void setText(String str) {
        this.f93208d.setText(str);
    }

    public QFSDropdownView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f93212i = new ArrayList();
        this.f93213m = 0;
        this.H = null;
        e();
    }

    public QFSDropdownView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f93212i = new ArrayList();
        this.f93213m = 0;
        this.H = null;
        e();
    }

    public void setOnPopWindowStatusListener(b bVar) {
    }
}
