package com.tencent.timi.game.team.impl.main;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.av.utils.ba;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TeamSelectView extends HorizontalScrollView implements View.OnClickListener {
    private int C;
    private c D;
    private b E;

    /* renamed from: d, reason: collision with root package name */
    private int f379542d;

    /* renamed from: e, reason: collision with root package name */
    private String f379543e;

    /* renamed from: f, reason: collision with root package name */
    private String f379544f;

    /* renamed from: h, reason: collision with root package name */
    private String f379545h;

    /* renamed from: i, reason: collision with root package name */
    private String f379546i;

    /* renamed from: m, reason: collision with root package name */
    private LinearLayout f379547m;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f379548a = 0;

        /* renamed from: b, reason: collision with root package name */
        public int f379549b;

        /* renamed from: c, reason: collision with root package name */
        public String f379550c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f379551d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f379552e;

        /* renamed from: f, reason: collision with root package name */
        public Object f379553f;

        public a(int i3, String str) {
            this.f379549b = i3;
            this.f379550c = str;
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface b {
        void b(List<a> list);
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface c {
        void a(a aVar);
    }

    public TeamSelectView(Context context) {
        super(context);
        this.f379542d = 0;
        this.f379543e = "#FFFFFFFF";
        this.f379544f = "#66000000";
        this.f379545h = "#1AF5A300";
        this.f379546i = "#0D000000";
        this.C = 12;
        f();
    }

    private void b() {
        for (int i3 = 0; i3 < this.f379547m.getChildCount(); i3++) {
            TextView textView = (TextView) this.f379547m.getChildAt(i3);
            if (((a) textView.getTag()).f379552e) {
                k(textView);
                return;
            }
        }
    }

    private void c() {
        for (int i3 = 0; i3 < this.f379547m.getChildCount(); i3++) {
            TextView textView = (TextView) this.f379547m.getChildAt(i3);
            if (((a) textView.getTag()).f379552e) {
                j(textView);
                return;
            }
        }
    }

    private void f() {
        setFillViewport(true);
        setOverScrollMode(2);
        setHorizontalScrollBarEnabled(false);
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f379547m = linearLayout;
        linearLayout.setOrientation(0);
        this.f379547m.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        addView(this.f379547m);
    }

    private boolean h() {
        for (int i3 = 0; i3 < this.f379547m.getChildCount(); i3++) {
            if (((TextView) this.f379547m.getChildAt(i3)).isSelected()) {
                return false;
            }
        }
        return true;
    }

    private void i() {
        for (int i3 = 0; i3 < this.f379547m.getChildCount(); i3++) {
            k((TextView) this.f379547m.getChildAt(i3));
        }
    }

    private void j(TextView textView) {
        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.lt8, null);
        if (yn4.a.a(this.f379545h)) {
            PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(Color.parseColor(this.f379545h), PorterDuff.Mode.SRC);
            if (drawable != null) {
                drawable.setColorFilter(porterDuffColorFilter);
            }
        }
        textView.setBackgroundDrawable(drawable);
        if (yn4.a.a(this.f379543e)) {
            textView.setTextColor(Color.parseColor(this.f379543e));
        }
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setSelected(true);
    }

    private void k(TextView textView) {
        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.lt8, null);
        if (yn4.a.a(this.f379546i)) {
            PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(Color.parseColor(this.f379546i), PorterDuff.Mode.SRC);
            if (drawable != null) {
                drawable.setColorFilter(porterDuffColorFilter);
            }
        }
        textView.setBackgroundDrawable(drawable);
        if (yn4.a.a(this.f379544f)) {
            textView.setTextColor(Color.parseColor(this.f379544f));
        }
        textView.setTypeface(Typeface.DEFAULT);
        textView.setSelected(false);
    }

    private void l(TextView textView) {
        a aVar = (a) textView.getTag();
        if (textView.isSelected()) {
            if (!aVar.f379552e) {
                k(textView);
            }
        } else {
            if (aVar.f379552e) {
                i();
            } else {
                b();
            }
            j(textView);
        }
        if (h()) {
            c();
        }
    }

    public void a(List<a> list) {
        if (list != null && !list.isEmpty()) {
            this.f379547m.removeAllViews();
            for (int i3 = 0; i3 < list.size(); i3++) {
                a aVar = list.get(i3);
                TextView textView = new TextView(getContext());
                textView.setPadding(ViewUtils.dip2px(22.0f), 0, ViewUtils.dip2px(22.0f), 0);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
                if (aVar.f379551d) {
                    j(textView);
                } else {
                    k(textView);
                }
                if (i3 != 0) {
                    layoutParams.leftMargin = (int) ba.dp2px(getContext(), this.C);
                }
                textView.setGravity(17);
                textView.setLayoutParams(layoutParams);
                textView.setTag(aVar);
                textView.setOnClickListener(this);
                textView.setText(aVar.f379550c);
                textView.setTextSize(14.0f);
                this.f379547m.addView(textView);
            }
        }
    }

    public a d() {
        for (int i3 = 0; i3 < this.f379547m.getChildCount(); i3++) {
            TextView textView = (TextView) this.f379547m.getChildAt(i3);
            if (textView.isSelected()) {
                return (a) textView.getTag();
            }
        }
        return null;
    }

    public List<a> e() {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < this.f379547m.getChildCount(); i3++) {
            TextView textView = (TextView) this.f379547m.getChildAt(i3);
            if (textView.isSelected()) {
                arrayList.add((a) textView.getTag());
            }
        }
        return arrayList;
    }

    public void g(String str, String str2, String str3, String str4) {
        this.f379543e = str;
        this.f379544f = str2;
        this.f379545h = str3;
        this.f379546i = str4;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        TextView textView = (TextView) view;
        int i3 = this.f379542d;
        if (i3 == 0) {
            i();
            j(textView);
            c cVar = this.D;
            if (cVar != null) {
                cVar.a((a) view.getTag());
            }
        } else if (i3 == 1) {
            l(textView);
            b bVar = this.E;
            if (bVar != null) {
                bVar.b(e());
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setItemSpacing(int i3) {
        this.C = i3;
    }

    public void setMode(int i3) {
        this.f379542d = i3;
    }

    public void setOnMultiSelectedListener(b bVar) {
        this.E = bVar;
    }

    public void setOnSingleSelectedListener(c cVar) {
        this.D = cVar;
    }

    public TeamSelectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f379542d = 0;
        this.f379543e = "#FFFFFFFF";
        this.f379544f = "#66000000";
        this.f379545h = "#1AF5A300";
        this.f379546i = "#0D000000";
        this.C = 12;
        f();
    }

    public TeamSelectView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f379542d = 0;
        this.f379543e = "#FFFFFFFF";
        this.f379544f = "#66000000";
        this.f379545h = "#1AF5A300";
        this.f379546i = "#0D000000";
        this.C = 12;
        f();
    }
}
