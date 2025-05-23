package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pair;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.Calendar;
import java.util.Iterator;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public final class MaterialCalendar<S> extends PickerFragment<S> {

    @VisibleForTesting
    static final Object N = "MONTHS_VIEW_GROUP_TAG";

    @VisibleForTesting
    static final Object P = "NAVIGATION_PREV_TAG";

    @VisibleForTesting
    static final Object Q = "NAVIGATION_NEXT_TAG";

    @VisibleForTesting
    static final Object R = "SELECTOR_TOGGLE_TAG";

    @StyleRes
    private int D;

    @Nullable
    private DateSelector<S> E;

    @Nullable
    private CalendarConstraints F;

    @Nullable
    private Month G;
    private CalendarSelector H;
    private com.google.android.material.datepicker.b I;
    private RecyclerView J;
    private RecyclerView K;
    private View L;
    private View M;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum CalendarSelector {
        DAY,
        YEAR
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a extends AccessibilityDelegateCompat {
        a() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setCollectionInfo(null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class b extends com.google.android.material.datepicker.j {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f33539d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Context context, int i3, boolean z16, int i16) {
            super(context, i3, z16);
            this.f33539d = i16;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public void calculateExtraLayoutSpace(@NonNull RecyclerView.State state, @NonNull int[] iArr) {
            if (this.f33539d == 0) {
                iArr[0] = MaterialCalendar.this.K.getWidth();
                iArr[1] = MaterialCalendar.this.K.getWidth();
            } else {
                iArr[0] = MaterialCalendar.this.K.getHeight();
                iArr[1] = MaterialCalendar.this.K.getHeight();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class c implements j {
        c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.material.datepicker.MaterialCalendar.j
        public void a(long j3) {
            if (MaterialCalendar.this.F.g().i(j3)) {
                MaterialCalendar.this.E.L(j3);
                Iterator<com.google.android.material.datepicker.i<S>> it = MaterialCalendar.this.C.iterator();
                while (it.hasNext()) {
                    it.next().b(MaterialCalendar.this.E.X());
                }
                MaterialCalendar.this.K.getAdapter().notifyDataSetChanged();
                if (MaterialCalendar.this.J != null) {
                    MaterialCalendar.this.J.getAdapter().notifyDataSetChanged();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class d extends RecyclerView.ItemDecoration {

        /* renamed from: d, reason: collision with root package name */
        private final Calendar f33542d = o.q();

        /* renamed from: e, reason: collision with root package name */
        private final Calendar f33543e = o.q();

        d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            int i3;
            int width;
            if ((recyclerView.getAdapter() instanceof p) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
                p pVar = (p) recyclerView.getAdapter();
                GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
                for (Pair<Long, Long> pair : MaterialCalendar.this.E.P()) {
                    Long l3 = pair.first;
                    if (l3 != null && pair.second != null) {
                        this.f33542d.setTimeInMillis(l3.longValue());
                        this.f33543e.setTimeInMillis(pair.second.longValue());
                        int k06 = pVar.k0(this.f33542d.get(1));
                        int k07 = pVar.k0(this.f33543e.get(1));
                        View findViewByPosition = gridLayoutManager.findViewByPosition(k06);
                        View findViewByPosition2 = gridLayoutManager.findViewByPosition(k07);
                        int spanCount = k06 / gridLayoutManager.getSpanCount();
                        int spanCount2 = k07 / gridLayoutManager.getSpanCount();
                        for (int i16 = spanCount; i16 <= spanCount2; i16++) {
                            View findViewByPosition3 = gridLayoutManager.findViewByPosition(gridLayoutManager.getSpanCount() * i16);
                            if (findViewByPosition3 != null) {
                                int top = findViewByPosition3.getTop() + MaterialCalendar.this.I.f33590d.c();
                                int bottom = findViewByPosition3.getBottom() - MaterialCalendar.this.I.f33590d.b();
                                if (i16 == spanCount) {
                                    i3 = findViewByPosition.getLeft() + (findViewByPosition.getWidth() / 2);
                                } else {
                                    i3 = 0;
                                }
                                if (i16 == spanCount2) {
                                    width = findViewByPosition2.getLeft() + (findViewByPosition2.getWidth() / 2);
                                } else {
                                    width = recyclerView.getWidth();
                                }
                                canvas.drawRect(i3, top, width, bottom, MaterialCalendar.this.I.f33594h);
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class e extends AccessibilityDelegateCompat {
        e() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            String string;
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            if (MaterialCalendar.this.M.getVisibility() == 0) {
                string = MaterialCalendar.this.getString(R.string.f168802gm);
            } else {
                string = MaterialCalendar.this.getString(R.string.f168782gk);
            }
            accessibilityNodeInfoCompat.setHintText(string);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class f extends RecyclerView.OnScrollListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.google.android.material.datepicker.h f33546d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ MaterialButton f33547e;

        f(com.google.android.material.datepicker.h hVar, MaterialButton materialButton) {
            this.f33546d = hVar;
            this.f33547e = materialButton;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
            if (i3 == 0) {
                recyclerView.announceForAccessibility(this.f33547e.getText());
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i3, int i16) {
            int findLastVisibleItemPosition;
            if (i3 < 0) {
                findLastVisibleItemPosition = MaterialCalendar.this.Gh().findFirstVisibleItemPosition();
            } else {
                findLastVisibleItemPosition = MaterialCalendar.this.Gh().findLastVisibleItemPosition();
            }
            MaterialCalendar.this.G = this.f33546d.j0(findLastVisibleItemPosition);
            this.f33547e.setText(this.f33546d.k0(findLastVisibleItemPosition));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            MaterialCalendar.this.Lh();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class h implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.google.android.material.datepicker.h f33550d;

        h(com.google.android.material.datepicker.h hVar) {
            this.f33550d = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            int findFirstVisibleItemPosition = MaterialCalendar.this.Gh().findFirstVisibleItemPosition() + 1;
            if (findFirstVisibleItemPosition < MaterialCalendar.this.K.getAdapter().getItemCount()) {
                MaterialCalendar.this.Jh(this.f33550d.j0(findFirstVisibleItemPosition));
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class i implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.google.android.material.datepicker.h f33552d;

        i(com.google.android.material.datepicker.h hVar) {
            this.f33552d = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            int findLastVisibleItemPosition = MaterialCalendar.this.Gh().findLastVisibleItemPosition() - 1;
            if (findLastVisibleItemPosition >= 0) {
                MaterialCalendar.this.Jh(this.f33552d.j0(findLastVisibleItemPosition));
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface j {
        void a(long j3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Px
    public static int Eh(@NonNull Context context) {
        return context.getResources().getDimensionPixelSize(R.dimen.csg);
    }

    private static int Fh(@NonNull Context context) {
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.f159170ct1) + resources.getDimensionPixelOffset(R.dimen.f159171ct2) + resources.getDimensionPixelOffset(R.dimen.f159169ct0);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.csl);
        int i3 = com.google.android.material.datepicker.g.f33599m;
        return dimensionPixelSize + dimensionPixelSize2 + (resources.getDimensionPixelSize(R.dimen.csg) * i3) + ((i3 - 1) * resources.getDimensionPixelOffset(R.dimen.csz)) + resources.getDimensionPixelOffset(R.dimen.csd);
    }

    @NonNull
    public static <T> MaterialCalendar<T> Hh(@NonNull DateSelector<T> dateSelector, @StyleRes int i3, @NonNull CalendarConstraints calendarConstraints) {
        MaterialCalendar<T> materialCalendar = new MaterialCalendar<>();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i3);
        bundle.putParcelable("GRID_SELECTOR_KEY", dateSelector);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints);
        bundle.putParcelable("CURRENT_MONTH_KEY", calendarConstraints.l());
        materialCalendar.setArguments(bundle);
        return materialCalendar;
    }

    private void Ih(final int i3) {
        this.K.post(new Runnable() { // from class: com.google.android.material.datepicker.MaterialCalendar.10
            @Override // java.lang.Runnable
            public void run() {
                MaterialCalendar.this.K.smoothScrollToPosition(i3);
            }
        });
    }

    private void yh(@NonNull View view, @NonNull com.google.android.material.datepicker.h hVar) {
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.zdm);
        materialButton.setTag(R);
        ViewCompat.setAccessibilityDelegate(materialButton, new e());
        MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.zdo);
        materialButton2.setTag(P);
        MaterialButton materialButton3 = (MaterialButton) view.findViewById(R.id.zdn);
        materialButton3.setTag(Q);
        this.L = view.findViewById(R.id.zh7);
        this.M = view.findViewById(R.id.f166337zh0);
        Kh(CalendarSelector.DAY);
        materialButton.setText(this.G.n());
        this.K.addOnScrollListener(new f(hVar, materialButton));
        materialButton.setOnClickListener(new g());
        materialButton3.setOnClickListener(new h(hVar));
        materialButton2.setOnClickListener(new i(hVar));
    }

    @NonNull
    private RecyclerView.ItemDecoration zh() {
        return new d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public CalendarConstraints Ah() {
        return this.F;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.google.android.material.datepicker.b Bh() {
        return this.I;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Month Ch() {
        return this.G;
    }

    @Nullable
    public DateSelector<S> Dh() {
        return this.E;
    }

    @NonNull
    LinearLayoutManager Gh() {
        return (LinearLayoutManager) this.K.getLayoutManager();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Jh(Month month) {
        boolean z16;
        com.google.android.material.datepicker.h hVar = (com.google.android.material.datepicker.h) this.K.getAdapter();
        int l06 = hVar.l0(month);
        int l07 = l06 - hVar.l0(this.G);
        boolean z17 = true;
        if (Math.abs(l07) > 3) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (l07 <= 0) {
            z17 = false;
        }
        this.G = month;
        if (z16 && z17) {
            this.K.scrollToPosition(l06 - 3);
            Ih(l06);
        } else if (z16) {
            this.K.scrollToPosition(l06 + 3);
            Ih(l06);
        } else {
            Ih(l06);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Kh(CalendarSelector calendarSelector) {
        this.H = calendarSelector;
        if (calendarSelector == CalendarSelector.YEAR) {
            this.J.getLayoutManager().scrollToPosition(((p) this.J.getAdapter()).k0(this.G.f33570f));
            this.L.setVisibility(0);
            this.M.setVisibility(8);
        } else if (calendarSelector == CalendarSelector.DAY) {
            this.L.setVisibility(8);
            this.M.setVisibility(0);
            Jh(this.G);
        }
    }

    void Lh() {
        CalendarSelector calendarSelector = this.H;
        CalendarSelector calendarSelector2 = CalendarSelector.YEAR;
        if (calendarSelector == calendarSelector2) {
            Kh(CalendarSelector.DAY);
        } else if (calendarSelector == CalendarSelector.DAY) {
            Kh(calendarSelector2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.D = bundle.getInt("THEME_RES_ID_KEY");
        this.E = (DateSelector) bundle.getParcelable("GRID_SELECTOR_KEY");
        this.F = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.G = (Month) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int i3;
        int i16;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), this.D);
        this.I = new com.google.android.material.datepicker.b(contextThemeWrapper);
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        Month m3 = this.F.m();
        if (MaterialDatePicker.Eh(contextThemeWrapper)) {
            i3 = R.layout.flo;
            i16 = 1;
        } else {
            i3 = R.layout.flj;
            i16 = 0;
        }
        View inflate = cloneInContext.inflate(i3, viewGroup, false);
        inflate.setMinimumHeight(Fh(requireContext()));
        GridView gridView = (GridView) inflate.findViewById(R.id.f166338zh1);
        ViewCompat.setAccessibilityDelegate(gridView, new a());
        gridView.setAdapter((ListAdapter) new com.google.android.material.datepicker.e());
        gridView.setNumColumns(m3.f33571h);
        gridView.setEnabled(false);
        this.K = (RecyclerView) inflate.findViewById(R.id.f166341zh4);
        this.K.setLayoutManager(new b(getContext(), i16, false, i16));
        this.K.setTag(N);
        com.google.android.material.datepicker.h hVar = new com.google.android.material.datepicker.h(contextThemeWrapper, this.E, this.F, new c());
        this.K.setAdapter(hVar);
        int integer = contextThemeWrapper.getResources().getInteger(R.integer.by);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.zh7);
        this.J = recyclerView;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.J.setLayoutManager(new GridLayoutManager((Context) contextThemeWrapper, integer, 1, false));
            this.J.setAdapter(new p(this));
            this.J.addItemDecoration(zh());
        }
        if (inflate.findViewById(R.id.zdm) != null) {
            yh(inflate, hVar);
        }
        if (!MaterialDatePicker.Eh(contextThemeWrapper)) {
            new PagerSnapHelper().attachToRecyclerView(this.K);
        }
        this.K.scrollToPosition(hVar.l0(this.G));
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.D);
        bundle.putParcelable("GRID_SELECTOR_KEY", this.E);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.F);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.G);
    }

    @Override // com.google.android.material.datepicker.PickerFragment
    public boolean ph(@NonNull com.google.android.material.datepicker.i<S> iVar) {
        return super.ph(iVar);
    }
}
