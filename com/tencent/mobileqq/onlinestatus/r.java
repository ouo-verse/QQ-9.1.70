package com.tencent.mobileqq.onlinestatus;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes16.dex */
public class r extends BaseAdapter {

    /* renamed from: d, reason: collision with root package name */
    private AppInterface f256158d;

    /* renamed from: e, reason: collision with root package name */
    private Context f256159e;

    /* renamed from: h, reason: collision with root package name */
    private Drawable f256161h;

    /* renamed from: m, reason: collision with root package name */
    private i f256163m;

    /* renamed from: f, reason: collision with root package name */
    private ArrayList<AutoReplyText> f256160f = new ArrayList<>();

    /* renamed from: i, reason: collision with root package name */
    private boolean f256162i = false;
    private boolean C = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i3;
            EventCollector.getInstance().onViewClickedBefore(view);
            if (r.this.f256160f.size() > 10) {
                QQToast.makeText(r.this.f256159e, 1, R.string.f170526tu, 1).show();
            } else if (r.this.f256163m != null) {
                if (r.this.f256160f.size() > 1) {
                    i3 = r.this.f256160f.size() - 1;
                } else {
                    i3 = 0;
                }
                AutoReplyText autoReplyText = new AutoReplyText("", i3);
                autoReplyText.getExtra().putBoolean("addFlag", true);
                r.this.f256163m.a(autoReplyText, false);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class b extends Editable.Factory {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TextView f256165a;

        b(TextView textView) {
            this.f256165a = textView;
        }

        @Override // android.text.Editable.Factory
        public Editable newEditable(CharSequence charSequence) {
            if (charSequence instanceof QQTextBuilder) {
                return (Editable) charSequence;
            }
            return new QQTextBuilder(charSequence, 3, (int) (this.f256165a.getTextSize() / this.f256165a.getPaint().density));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AutoReplyText f256167d;

        c(AutoReplyText autoReplyText) {
            this.f256167d = autoReplyText;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            r.this.p(this.f256167d.getTextId());
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class d implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AutoReplyText f256169d;

        d(AutoReplyText autoReplyText) {
            this.f256169d = autoReplyText;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (r.this.f256163m != null && view != null) {
                r.this.o((View) view.getParent(), this.f256169d.getTextId());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class e implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AutoReplyText f256171d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f256172e;

        e(AutoReplyText autoReplyText, boolean z16) {
            this.f256171d = autoReplyText;
            this.f256172e = z16;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (r.this.f256163m != null) {
                r.this.f256163m.a(this.f256171d, this.f256172e);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class f implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AutoReplyText f256174d;

        f(AutoReplyText autoReplyText) {
            this.f256174d = autoReplyText;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            r.this.p(this.f256174d.getTextId());
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class g extends Animation {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f256176d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f256177e;

        g(View view, int i3) {
            this.f256176d = view;
            this.f256177e = i3;
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f16, Transformation transformation) {
            super.applyTransformation(f16, transformation);
            if (f16 == 1.0f) {
                this.f256176d.setVisibility(8);
                return;
            }
            ViewGroup.LayoutParams layoutParams = this.f256176d.getLayoutParams();
            if (layoutParams != null) {
                int i3 = this.f256177e;
                layoutParams.height = i3 - ((int) (i3 * f16));
                this.f256176d.setLayoutParams(layoutParams);
            }
        }

        @Override // android.view.animation.Animation
        public boolean willChangeBounds() {
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface i {
        void a(@Nullable AutoReplyText autoReplyText, boolean z16);

        void b(AutoReplyText autoReplyText);

        void d(AutoReplyText autoReplyText, boolean z16);

        void e(AutoReplyText autoReplyText, AutoReplyText autoReplyText2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class j {

        /* renamed from: a, reason: collision with root package name */
        View f256181a;

        /* renamed from: b, reason: collision with root package name */
        TextView f256182b;

        /* renamed from: c, reason: collision with root package name */
        ImageView f256183c;

        /* renamed from: d, reason: collision with root package name */
        View f256184d;

        /* renamed from: e, reason: collision with root package name */
        View f256185e;

        /* renamed from: f, reason: collision with root package name */
        View f256186f;

        j() {
        }
    }

    public r(AppInterface appInterface, Context context, Drawable drawable) {
        this.f256158d = appInterface;
        this.f256159e = context;
        this.f256161h = drawable;
    }

    private void g() {
        HashSet hashSet = new HashSet(this.f256160f);
        this.f256160f.clear();
        this.f256160f.addAll(hashSet);
        Collections.sort(this.f256160f);
    }

    private View h(LayoutInflater layoutInflater, int i3, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.f167523o, viewGroup, false);
        inflate.setOnClickListener(new a());
        return inflate;
    }

    private View i(LayoutInflater layoutInflater, int i3, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.f167527t, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.content);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
        if (getItemViewType(i3) == 0) {
            marginLayoutParams.topMargin = this.f256159e.getResources().getDimensionPixelSize(R.dimen.f159492al3);
            marginLayoutParams.bottomMargin = this.f256159e.getResources().getDimensionPixelSize(R.dimen.f159486al0);
            textView.setText(R.string.t_);
            textView.setContentDescription(this.f256159e.getString(R.string.t_));
        } else {
            marginLayoutParams.bottomMargin = this.f256159e.getResources().getDimensionPixelSize(R.dimen.f159492al3);
            marginLayoutParams.topMargin = this.f256159e.getResources().getDimensionPixelSize(R.dimen.f159486al0);
            textView.setText(R.string.f170515tf);
            textView.setContentDescription(this.f256159e.getString(R.string.f170515tf));
        }
        textView.setLayoutParams(marginLayoutParams);
        return inflate;
    }

    private j j(LayoutInflater layoutInflater, int i3, View view, ViewGroup viewGroup, AutoReplyText autoReplyText) {
        int i16;
        j jVar;
        boolean z16;
        Drawable drawable;
        int dip2px;
        if (view != null && view.getTag() != null && view.getVisibility() != 8) {
            jVar = (j) view.getTag();
            jVar.f256181a = view;
        } else {
            View inflate = layoutInflater.inflate(R.layout.f167524q, viewGroup, false);
            View findViewById = inflate.findViewById(R.id.bms);
            if (QQTheme.isDefaultTheme()) {
                i16 = 0;
            } else {
                i16 = 8;
            }
            findViewById.setVisibility(i16);
            if (!QQTheme.isDefaultTheme() && !QQTheme.isNowThemeIsNight()) {
                inflate.findViewById(R.id.i7l).setBackgroundResource(R.drawable.common_strip_setting_middle);
            }
            inflate.findViewById(R.id.e7j).setPadding(0, 0, 0, 0);
            inflate.findViewById(R.id.ian).setVisibility(8);
            TextView textView = (TextView) inflate.findViewById(R.id.e85);
            textView.setEditableFactory(new b(textView));
            j jVar2 = new j();
            jVar2.f256181a = inflate;
            jVar2.f256182b = textView;
            jVar2.f256183c = (ImageView) inflate.findViewById(R.id.f166793ia2);
            jVar2.f256184d = inflate.findViewById(R.id.bq5);
            jVar2.f256185e = inflate.findViewById(R.id.bq6);
            jVar2.f256186f = inflate.findViewById(R.id.jg5);
            jVar2.f256181a.setTag(jVar2);
            jVar = jVar2;
        }
        jVar.f256183c.setOnClickListener(new c(autoReplyText));
        jVar.f256184d.setOnClickListener(new d(autoReplyText));
        boolean z17 = autoReplyText.getExtra().getBoolean("AutoReplyAdapter:in_use", false);
        if (autoReplyText.getTextId() == Integer.MAX_VALUE) {
            z16 = true;
        } else {
            z16 = false;
        }
        String trimRawString = AutoReplyText.trimRawString(autoReplyText.getRawText(), true);
        int textSize = (int) (jVar.f256182b.getTextSize() / jVar.f256182b.getPaint().density);
        String subQQTextString = TextUtils.subQQTextString(trimRawString, jVar.f256182b.getPaint(), 3, textSize, ScreenUtil.SCREEN_WIDTH - ScreenUtil.dip2px(67.0f), true);
        QQText qQText = new QQText(subQQTextString, 3, textSize);
        jVar.f256182b.setText(qQText);
        jVar.f256182b.setContentDescription(qQText);
        jVar.f256183c.setContentDescription(new QQText(HardCodeUtil.qqStr(R.string.jud) + subQQTextString, 3, textSize));
        jVar.f256185e.setOnClickListener(new e(autoReplyText, z17));
        jVar.f256181a.findViewById(R.id.i7l).setOnClickListener(new f(autoReplyText));
        ImageView imageView = jVar.f256183c;
        if (z17) {
            drawable = this.f256161h;
        } else {
            drawable = null;
        }
        imageView.setImageDrawable(drawable);
        View view2 = jVar.f256181a;
        if (z16) {
            dip2px = 0;
        } else {
            dip2px = ScreenUtil.dip2px(200.0f);
        }
        view2.setTag(-3, Integer.valueOf(dip2px));
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) jVar.f256186f.getLayoutParams();
        if (layoutParams.leftMargin > 0) {
            layoutParams.leftMargin = 0;
            jVar.f256186f.setLayoutParams(layoutParams);
        }
        return jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i3) {
        AutoReplyText autoReplyText;
        boolean z16;
        if (i3 != Integer.MAX_VALUE && f()) {
            Iterator<AutoReplyText> it = this.f256160f.iterator();
            boolean z17 = false;
            int i16 = 0;
            boolean z18 = false;
            while (it.hasNext()) {
                AutoReplyText next = it.next();
                if (next.getTextId() == i3) {
                    if (next.getExtra().getBoolean("AutoReplyAdapter:in_use", false)) {
                        z17 = true;
                    }
                    it.remove();
                    i iVar = this.f256163m;
                    if (iVar != null) {
                        if (next.getTextId() == Integer.MAX_VALUE) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        iVar.d(next, z16);
                    }
                    z18 = true;
                } else if (next.mTextId != Integer.MAX_VALUE) {
                    next.mTextId = i16;
                    i16++;
                }
            }
            if (z17 && !this.f256160f.isEmpty() && (autoReplyText = this.f256160f.get(0)) != null) {
                p(autoReplyText.getTextId());
            }
            if (z18) {
                this.C = true;
                notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(View view, int i3) {
        if (i3 != Integer.MAX_VALUE && view != null && f()) {
            g gVar = new g(view, view.getMeasuredHeight());
            gVar.setAnimationListener(new h(i3));
            gVar.setDuration(150L);
            view.startAnimation(gVar);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return false;
    }

    public boolean f() {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            return false;
        }
        return true;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f256162i) {
            return this.f256160f.size() + 1 + 1 + 1;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    @Nullable
    public Object getItem(int i3) {
        if (i3 >= 1 && i3 <= this.f256160f.size()) {
            return this.f256160f.get(i3 - 1);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i3) {
        if (i3 >= 0 && i3 < 1) {
            return 0;
        }
        if (i3 == this.f256160f.size() + 1) {
            return 3;
        }
        if ((i3 >= 1 && i3 <= this.f256160f.size()) || i3 != this.f256160f.size() + 1 + 1) {
            return 1;
        }
        return 4;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        LayoutInflater from = LayoutInflater.from(this.f256159e);
        if (getItemViewType(i3) != 0 && getItemViewType(i3) != 4) {
            if (getItemViewType(i3) == 3) {
                view = h(from, i3, viewGroup);
            } else {
                AutoReplyText autoReplyText = (AutoReplyText) getItem(i3);
                if (autoReplyText != null) {
                    view = j(from, i3, view, viewGroup, autoReplyText).f256181a;
                }
            }
        } else {
            view = i(from, i3, viewGroup);
        }
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i3) {
        if (i3 != 0 && i3 != getCount() - 1) {
            return true;
        }
        return false;
    }

    public ArrayList<AutoReplyText> k() {
        return this.f256160f;
    }

    public boolean l() {
        return this.C;
    }

    public void m(@Nullable AutoReplyText autoReplyText) {
        if (!f() || autoReplyText == null || autoReplyText.getTextId() == Integer.MAX_VALUE) {
            return;
        }
        Iterator<AutoReplyText> it = this.f256160f.iterator();
        AutoReplyText autoReplyText2 = null;
        while (it.hasNext()) {
            AutoReplyText next = it.next();
            if (next != null && next.getTextId() == autoReplyText.getTextId()) {
                it.remove();
                autoReplyText2 = next;
            }
        }
        autoReplyText.getExtra().putBoolean("AutoReplyAdapter:in_use", false);
        if (autoReplyText2 != null && autoReplyText2.getExtra().getBoolean("AutoReplyAdapter:in_use", false)) {
            autoReplyText.getExtra().putBoolean("AutoReplyAdapter:in_use", true);
        }
        this.f256160f.add(autoReplyText);
        i iVar = this.f256163m;
        if (iVar != null) {
            iVar.b(autoReplyText);
        }
        g();
        this.C = true;
        notifyDataSetChanged();
    }

    public void p(int i3) {
        boolean z16;
        if (f()) {
            Iterator<AutoReplyText> it = this.f256160f.iterator();
            AutoReplyText autoReplyText = null;
            AutoReplyText autoReplyText2 = null;
            while (true) {
                z16 = true;
                if (!it.hasNext()) {
                    break;
                }
                AutoReplyText next = it.next();
                if (next != null) {
                    Bundle extra = next.getExtra();
                    boolean z17 = extra.getBoolean("AutoReplyAdapter:in_use", false);
                    if (z17) {
                        autoReplyText2 = next;
                    }
                    if (next.getTextId() == i3) {
                        if (!z17) {
                            extra.putBoolean("AutoReplyAdapter:in_use", true);
                            autoReplyText = next;
                        }
                    } else {
                        extra.putBoolean("AutoReplyAdapter:in_use", false);
                    }
                }
            }
            if (autoReplyText != null) {
                if (autoReplyText2 == null) {
                    z16 = false;
                }
                this.C = z16;
                i iVar = this.f256163m;
                if (iVar != null) {
                    iVar.e(autoReplyText, autoReplyText2);
                }
                notifyDataSetChanged();
            }
        }
    }

    public void q(@Nullable i iVar) {
        this.f256163m = iVar;
    }

    public void r(boolean z16) {
        if (f()) {
            this.f256162i = z16;
            notifyDataSetChanged();
        }
    }

    public void s(List<AutoReplyText> list) {
        int i3;
        if (f()) {
            this.f256160f.clear();
            if (list != null && !list.isEmpty()) {
                this.f256160f.addAll(list);
                i3 = 0;
                for (AutoReplyText autoReplyText : list) {
                    if (autoReplyText.isChecked()) {
                        i3 = autoReplyText.mTextId;
                    }
                    autoReplyText.getExtra().putBoolean("AutoReplyAdapter:in_use", false);
                }
                g();
            } else {
                i3 = 0;
            }
            notifyDataSetChanged();
            p(i3);
            this.C = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class h implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f256179d;

        h(int i3) {
            this.f256179d = i3;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            r.this.n(this.f256179d);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
