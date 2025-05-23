package com.tencent.mobileqq.qwallet.hb.grap.keep.draw;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qwallet.impl.d;
import com.tencent.mobileqq.util.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ChooseItemView extends FrameLayout {
    private static int H = 13;
    private boolean C;
    private String D;
    c E;
    private View.OnClickListener F;
    private Paint G;

    /* renamed from: d, reason: collision with root package name */
    private List<String> f277412d;

    /* renamed from: e, reason: collision with root package name */
    private View.OnClickListener f277413e;

    /* renamed from: f, reason: collision with root package name */
    private LinearLayout f277414f;

    /* renamed from: h, reason: collision with root package name */
    private int f277415h;

    /* renamed from: i, reason: collision with root package name */
    private int f277416i;

    /* renamed from: m, reason: collision with root package name */
    private int f277417m;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qwallet.hb.grap.keep.draw.ChooseItemView$2, reason: invalid class name */
    /* loaded from: classes16.dex */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ ChooseItemView this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        String f277418a;

        /* renamed from: b, reason: collision with root package name */
        boolean f277419b;

        /* renamed from: c, reason: collision with root package name */
        boolean f277420c;

        public a(String str, boolean z16, boolean z17) {
            this.f277418a = str;
            this.f277419b = z16;
            this.f277420c = z17;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class b extends RecyclerView.ViewHolder {

        /* renamed from: d, reason: collision with root package name */
        LinearLayout f277421d;

        public b(LinearLayout linearLayout) {
            super(linearLayout);
            this.f277421d = linearLayout;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class c extends RecyclerView.Adapter<b> {

        /* renamed from: d, reason: collision with root package name */
        private List<List<a>> f277422d;

        /* renamed from: e, reason: collision with root package name */
        private View.OnClickListener f277423e;

        /* renamed from: f, reason: collision with root package name */
        private String f277424f;

        c(@NonNull List<List<a>> list, View.OnClickListener onClickListener) {
            this.f277422d = list;
            this.f277423e = onClickListener;
        }

        private View p(Context context) {
            TextView textView = new TextView(context);
            textView.setTextSize(1, ChooseItemView.H);
            textView.setGravity(16);
            int c16 = x.c(context, 13.0f);
            textView.setPadding(c16, 0, c16, 0);
            textView.setOnClickListener(this.f277423e);
            d.y(textView, 0.6f);
            textView.setLayoutParams(new RelativeLayout.LayoutParams(-2, x.c(context, 30.0f)));
            RelativeLayout relativeLayout = new RelativeLayout(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, x.c(context, 30.0f));
            layoutParams.leftMargin = x.c(context, 12.0f);
            relativeLayout.setLayoutParams(layoutParams);
            relativeLayout.addView(textView);
            textView.setId(R.id.f166668h62);
            View view = new View(context);
            view.setBackgroundResource(R.drawable.f162128nv1);
            view.setVisibility(8);
            relativeLayout.addView(view);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) view.getLayoutParams();
            layoutParams2.width = x.c(context, 9.2f);
            layoutParams2.height = x.c(context, 8.9f);
            layoutParams2.addRule(7, R.id.f166668h62);
            layoutParams2.addRule(6, R.id.f166668h62);
            return relativeLayout;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f277422d.size();
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(b bVar, int i3) {
            List<a> list = this.f277422d.get(i3);
            LinearLayout linearLayout = bVar.f277421d;
            while (linearLayout.getChildCount() < list.size()) {
                linearLayout.addView(p(linearLayout.getContext()));
            }
            int i16 = 0;
            while (i16 < list.size()) {
                list.get(i16);
                linearLayout.getChildAt(i16).setVisibility(0);
                i16++;
            }
            while (i16 < linearLayout.getChildCount()) {
                linearLayout.getChildAt(i16).setVisibility(8);
                i16++;
            }
            EventCollector.getInstance().onRecyclerBindViewHolder(bVar, i3, getItemId(i3));
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: r, reason: merged with bridge method [inline-methods] */
        public b onCreateViewHolder(ViewGroup viewGroup, int i3) {
            LinearLayout linearLayout = new LinearLayout(viewGroup.getContext());
            linearLayout.setOrientation(0);
            linearLayout.setGravity(16);
            int c16 = x.c(viewGroup.getContext(), 6.0f);
            linearLayout.setPadding(0, c16, 0, c16);
            return new b(linearLayout);
        }

        public void s(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.f277424f = str;
            }
        }
    }

    private void c() {
        if (this.f277417m == 0) {
            TextView textView = new TextView(getContext());
            this.f277414f.addView(textView);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
            layoutParams.height = -2;
            layoutParams.width = -2;
            layoutParams.gravity = 5;
            Drawable drawable = getContext().getResources().getDrawable(R.drawable.n96);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            textView.setCompoundDrawables(drawable, null, null, null);
            textView.setCompoundDrawablePadding(x.c(getContext(), 7.0f));
            textView.setPadding(x.c(getContext(), 5.0f), 0, x.c(getContext(), 20.0f), x.c(getContext(), 10.0f));
            textView.setText(HardCodeUtil.qqStr(R.string.kje));
            textView.setTextColor(-1694379);
            textView.setTextSize(1, 14.0f);
            textView.setOnClickListener(this.F);
            d.y(textView, 0.6f);
        }
    }

    private List<List<a>> d() {
        LinkedList linkedList = new LinkedList();
        int width = this.f277414f.getWidth();
        LinkedList linkedList2 = new LinkedList();
        int i3 = 0;
        int i16 = 0;
        while (true) {
            boolean z16 = true;
            if (i3 >= this.f277412d.size() || !f(linkedList.size() + 1)) {
                break;
            }
            String str = this.f277412d.get(i3);
            if (i3 >= this.f277416i) {
                z16 = false;
            }
            a aVar = new a(str, z16, false);
            float measureText = e().measureText(str) + x.c(getContext(), 26.0f);
            float f16 = i16;
            if (f16 + measureText + (x.c(getContext(), 12.0f) * 2) <= width) {
                linkedList2.add(aVar);
                i16 = (int) (f16 + measureText + x.c(getContext(), 12.0f));
            } else {
                linkedList.add(linkedList2);
                linkedList2 = new LinkedList();
                linkedList2.add(aVar);
                i16 = ((int) measureText) + x.c(getContext(), 12.0f);
            }
            i3++;
        }
        if (f(linkedList.size() + 1)) {
            linkedList.add(linkedList2);
        }
        return linkedList;
    }

    private Paint e() {
        if (this.G == null) {
            TextView textView = new TextView(getContext());
            textView.setTextSize(1, H);
            this.G = textView.getPaint();
        }
        return this.G;
    }

    private boolean f(int i3) {
        if (this.f277417m == 1 || i3 <= this.f277415h) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        QLog.i("ChooseItemView", 2, "updatePageInner....");
        this.f277414f.removeAllViews();
        this.f277414f.setPadding(x.c(getContext(), 8.0f), 0, this.f277414f.getPaddingRight(), x.c(getContext(), 10.0f));
        c();
        RecyclerView recyclerView = new RecyclerView(getContext());
        c cVar = new c(d(), this.f277413e);
        this.E = cVar;
        cVar.s(this.D);
        recyclerView.setAdapter(this.E);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        this.f277414f.addView(recyclerView);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) recyclerView.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
    }

    public void setIsShow(boolean z16) {
        this.C = z16;
    }

    public void setMaxLines(int i3) {
        this.f277415h = i3;
        if (i3 <= 0) {
            this.f277415h = 4;
        }
    }

    public void setRecommendCnt(int i3) {
        this.f277416i = i3;
    }

    public void setStyle(int i3) {
        this.f277417m = i3;
    }

    public void setTextSizeInDp(int i3) {
        if (i3 > 0) {
            H = i3;
        }
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        super.setVisibility(i3);
    }
}
