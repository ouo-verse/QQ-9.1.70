package com.tencent.aelight.camera.ae.flashshow.view;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;
import com.tencent.aelight.camera.ae.flashshow.view.TabLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class TabLayout extends FrameLayout {
    private int C;
    private f D;
    private boolean E;

    /* renamed from: d, reason: collision with root package name */
    private RecyclerView f65144d;

    /* renamed from: e, reason: collision with root package name */
    private LinearLayoutManager f65145e;

    /* renamed from: f, reason: collision with root package name */
    LinearSnapHelper f65146f;

    /* renamed from: h, reason: collision with root package name */
    private g f65147h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f65148i;

    /* renamed from: m, reason: collision with root package name */
    private List<h> f65149m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a extends LinearLayoutManager {
        a(Context context, int i3, boolean z16) {
            super(context, i3, z16);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollHorizontally() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            TabLayout.this.f65144d.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            int width = TabLayout.this.f65144d.getWidth() / 2;
            TabLayout.this.f65144d.setPadding(width, 0, width, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c extends RecyclerView.OnScrollListener {

        /* renamed from: d, reason: collision with root package name */
        private boolean f65152d = false;

        c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
            String str;
            super.onScrollStateChanged(recyclerView, i3);
            if (i3 != 0) {
                if (i3 == 1) {
                    this.f65152d = true;
                    return;
                }
                return;
            }
            TabLayout tabLayout = TabLayout.this;
            View findSnapView = tabLayout.f65146f.findSnapView(tabLayout.f65145e);
            if (findSnapView != null) {
                int position = TabLayout.this.f65145e.getPosition(findSnapView);
                if (this.f65152d) {
                    str = WinkDaTongReportConstant.ElementParamValue.BOTTOM_TAB_SWITCH_TYPE_SLIDE;
                } else {
                    str = "";
                }
                TabLayout.this.v(position, true, false, false, str);
            }
            this.f65152d = false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i3, int i16) {
            super.onScrolled(recyclerView, i3, i16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    private class d extends RecyclerViewAccessibilityDelegate.ItemDelegate {
        public d(RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate) {
            super(recyclerViewAccessibilityDelegate);
        }

        @Override // androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate.ItemDelegate, androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            try {
                h hVar = (h) TabLayout.this.f65149m.get(TabLayout.this.C);
                if (((TextView) view.findViewById(R.id.s27)).getText().equals(hVar.f65158b)) {
                    accessibilityNodeInfoCompat.setText(hVar.f65158b + "\u5df2\u9009\u4e2d");
                }
            } catch (Exception unused) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    private class e extends RecyclerViewAccessibilityDelegate {
        public e(RecyclerView recyclerView) {
            super(recyclerView);
        }

        @Override // androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate
        public AccessibilityDelegateCompat getItemDelegate() {
            return new d(this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface f {
        boolean a(int i3);

        void b(int i3, String str, String str2, String str3);
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class h {

        /* renamed from: a, reason: collision with root package name */
        String f65157a;

        /* renamed from: b, reason: collision with root package name */
        String f65158b;

        /* renamed from: c, reason: collision with root package name */
        boolean f65159c;

        public h(String str, String str2, boolean z16) {
            this.f65157a = str;
            this.f65158b = str2;
            this.f65159c = z16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class i extends RecyclerView.ViewHolder {
        TextView E;
        ImageView F;
        View G;

        public i(View view) {
            super(view);
            if (TabLayout.this.E) {
                view.setFocusable(true);
                view.setFocusableInTouchMode(true);
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (TabLayout.this.f65148i) {
                marginLayoutParams.width = -2;
                marginLayoutParams.rightMargin = TabLayout.this.l(20.0f);
                marginLayoutParams.leftMargin = TabLayout.this.l(20.0f);
            } else {
                com.tencent.mobileqq.wink.qzone.templatelibrary.utils.c cVar = com.tencent.mobileqq.wink.qzone.templatelibrary.utils.c.f326233a;
                marginLayoutParams.width = cVar.k(TabLayout.this.f65149m.size());
                marginLayoutParams.leftMargin = cVar.j();
                marginLayoutParams.rightMargin = cVar.j();
            }
            this.E = (TextView) view.findViewById(R.id.s27);
            this.F = (ImageView) view.findViewById(R.id.rzi);
            this.E.setTextSize(1, 16.0f);
            this.G = view.findViewById(R.id.ro7);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.aelight.camera.ae.flashshow.view.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    TabLayout.i.this.m(view2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void m(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            TabLayout.this.v(getAdapterPosition(), true, true, false, "click");
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public TabLayout(Context context) {
        this(context, null);
    }

    private void n() {
        this.f65144d = new RecyclerView(getContext());
        a aVar = new a(getContext(), 0, false);
        this.f65145e = aVar;
        this.f65144d.setLayoutManager(aVar);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -1);
        layoutParams.gravity = 1;
        addView(this.f65144d, layoutParams);
    }

    private void o() {
        this.f65144d.addOnScrollListener(new c());
    }

    private void p() {
        this.f65144d = new RecyclerView(getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 0, false);
        this.f65145e = linearLayoutManager;
        this.f65144d.setLayoutManager(linearLayoutManager);
        this.f65144d.setClipToPadding(false);
        addView(this.f65144d, new FrameLayout.LayoutParams(-1, -1));
        this.f65144d.getViewTreeObserver().addOnGlobalLayoutListener(new b());
        LinearSnapHelper linearSnapHelper = new LinearSnapHelper();
        this.f65146f = linearSnapHelper;
        linearSnapHelper.attachToRecyclerView(this.f65144d);
        o();
    }

    private void q(List<h> list) {
        this.f65149m = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(int i3) {
        View findViewByPosition = this.f65145e.findViewByPosition(i3);
        if (findViewByPosition != null) {
            findViewByPosition.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(final int i3) {
        if (this.E) {
            this.f65144d.postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.view.c
                @Override // java.lang.Runnable
                public final void run() {
                    TabLayout.this.r(i3);
                }
            }, 200L);
        } else {
            com.tencent.mobileqq.wink.utils.e.g(this.f65144d, 0, i3);
        }
    }

    private void x() {
        try {
            AccessibilityManager accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
            if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
                return;
            }
            this.E = accessibilityManager.getEnabledAccessibilityServiceList(-1).size() > 0;
        } catch (Exception e16) {
            w53.b.d("FS_TabLayout", "[updateAccessibilityEnabled]", e16);
        }
    }

    public int l(float f16) {
        return (int) TypedValue.applyDimension(1, f16, getResources().getDisplayMetrics());
    }

    public int m() {
        return this.f65149m.size();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f65148i) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.view.TabLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    int width = TabLayout.this.f65144d.getWidth() / 2;
                    TabLayout.this.f65144d.setPadding(width, 0, width, 0);
                    if (TabLayout.this.C != -1) {
                        TabLayout tabLayout = TabLayout.this;
                        tabLayout.t(tabLayout.C);
                    }
                }
            });
        }
    }

    public void setCallback(f fVar) {
        this.D = fVar;
    }

    public void setTabSelectCallback(f fVar) {
        this.D = fVar;
    }

    public void setTabs(List<h> list, final int i3) {
        boolean z16 = list.size() > 3;
        this.f65148i = z16;
        if (z16) {
            p();
        } else {
            n();
        }
        x();
        if (this.E) {
            this.f65144d.setAccessibilityDelegateCompat(new e(this.f65144d));
        }
        g gVar = new g();
        this.f65147h = gVar;
        this.f65144d.setAdapter(gVar);
        q(list);
        this.f65144d.postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.view.b
            @Override // java.lang.Runnable
            public final void run() {
                TabLayout.this.s(i3);
            }
        }, 200L);
    }

    public void w(int i3, boolean z16) {
        this.f65147h.l0(i3, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class g extends RecyclerView.Adapter<i> {
        g() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return TabLayout.this.f65149m.size();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r8v1 */
        /* JADX WARN: Type inference failed for: r8v2, types: [int, boolean] */
        /* JADX WARN: Type inference failed for: r8v5 */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: i0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(i iVar, int i3) {
            h hVar = (h) TabLayout.this.f65149m.get(i3);
            iVar.E.setText(hVar.f65158b);
            ?? r85 = TabLayout.this.C == i3 ? 1 : 0;
            iVar.E.setTextColor(AppCompatResources.getColorStateList(TabLayout.this.getContext(), R.color.afh));
            iVar.E.setSelected(r85);
            iVar.E.setTextSize(1, r85 != 0 ? 17.0f : 16.0f);
            iVar.E.setTypeface(Typeface.defaultFromStyle(r85));
            iVar.F.setVisibility(hVar.f65159c ? 0 : 8);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: j0, reason: merged with bridge method [inline-methods] */
        public i onCreateViewHolder(ViewGroup viewGroup, int i3) {
            return new i(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dnw, viewGroup, false));
        }

        public void k0(int i3) {
            if (i3 < 0 || i3 >= TabLayout.this.f65149m.size()) {
                return;
            }
            notifyDataSetChanged();
        }

        public void l0(int i3, boolean z16) {
            if (i3 < 0 || i3 >= TabLayout.this.f65149m.size() || ((h) TabLayout.this.f65149m.get(i3)).f65159c == z16) {
                return;
            }
            ((h) TabLayout.this.f65149m.get(i3)).f65159c = z16;
            TabLayout.this.f65147h.notifyItemChanged(i3);
        }
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f65149m = new ArrayList();
        this.C = -1;
        this.E = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(int i3, boolean z16, boolean z17, boolean z18, String str) {
        String str2;
        f fVar;
        if ((z18 || i3 != this.C) && i3 >= 0 && i3 < this.f65149m.size()) {
            f fVar2 = this.D;
            if (fVar2 == null || fVar2.a(i3)) {
                int i16 = this.C;
                if (i16 >= 0 && i16 < this.f65149m.size()) {
                    str2 = this.f65149m.get(this.C).f65157a;
                } else {
                    str2 = "";
                }
                String str3 = this.f65149m.get(i3).f65157a;
                this.C = i3;
                if (z17 && this.f65148i) {
                    t(i3);
                }
                this.f65147h.k0(i3);
                if (!z16 || (fVar = this.D) == null) {
                    return;
                }
                fVar.b(i3, str, str2, str3);
            }
        }
    }

    public void u(int i3, boolean z16) {
        v(i3, true, true, z16, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(int i3) {
        v(i3, true, true, false, "");
    }
}
