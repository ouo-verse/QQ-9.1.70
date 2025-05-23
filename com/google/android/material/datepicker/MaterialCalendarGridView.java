package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.internal.ViewUtils;
import com.tencent.mobileqq.R;
import java.util.Calendar;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public final class MaterialCalendarGridView extends GridView {

    /* renamed from: d, reason: collision with root package name */
    private final Calendar f33554d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f33555e;

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

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(int i3, Rect rect) {
        if (i3 == 33) {
            setSelection(getAdapter().i());
        } else if (i3 == 130) {
            setSelection(getAdapter().b());
        } else {
            super.onFocusChanged(true, i3, rect);
        }
    }

    private View c(int i3) {
        return getChildAt(i3 - getFirstVisiblePosition());
    }

    private static int d(@NonNull View view) {
        return view.getLeft() + (view.getWidth() / 2);
    }

    private static boolean e(@Nullable Long l3, @Nullable Long l16, @Nullable Long l17, @Nullable Long l18) {
        if (l3 == null || l16 == null || l17 == null || l18 == null || l17.longValue() > l16.longValue() || l18.longValue() < l3.longValue()) {
            return true;
        }
        return false;
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public g getAdapter2() {
        return (g) super.getAdapter();
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter().notifyDataSetChanged();
    }

    @Override // android.view.View
    protected final void onDraw(@NonNull Canvas canvas) {
        int a16;
        int d16;
        int a17;
        int d17;
        int i3;
        int i16;
        int i17;
        int i18;
        int left;
        int left2;
        MaterialCalendarGridView materialCalendarGridView = this;
        super.onDraw(canvas);
        g adapter = getAdapter();
        DateSelector<?> dateSelector = adapter.f33601e;
        b bVar = adapter.f33603h;
        int max = Math.max(adapter.b(), getFirstVisiblePosition());
        int min = Math.min(adapter.i(), getLastVisiblePosition());
        Long item = adapter.getItem(max);
        Long item2 = adapter.getItem(min);
        Iterator<Pair<Long, Long>> it = dateSelector.P().iterator();
        while (it.hasNext()) {
            Pair<Long, Long> next = it.next();
            Long l3 = next.first;
            if (l3 != null) {
                if (next.second != null) {
                    long longValue = l3.longValue();
                    long longValue2 = next.second.longValue();
                    if (!e(item, item2, Long.valueOf(longValue), Long.valueOf(longValue2))) {
                        boolean i19 = ViewUtils.i(this);
                        if (longValue < item.longValue()) {
                            if (adapter.f(max)) {
                                left2 = 0;
                            } else if (!i19) {
                                left2 = materialCalendarGridView.c(max - 1).getRight();
                            } else {
                                left2 = materialCalendarGridView.c(max - 1).getLeft();
                            }
                            d16 = left2;
                            a16 = max;
                        } else {
                            materialCalendarGridView.f33554d.setTimeInMillis(longValue);
                            a16 = adapter.a(materialCalendarGridView.f33554d.get(5));
                            d16 = d(materialCalendarGridView.c(a16));
                        }
                        if (longValue2 > item2.longValue()) {
                            if (adapter.g(min)) {
                                left = getWidth();
                            } else if (!i19) {
                                left = materialCalendarGridView.c(min).getRight();
                            } else {
                                left = materialCalendarGridView.c(min).getLeft();
                            }
                            d17 = left;
                            a17 = min;
                        } else {
                            materialCalendarGridView.f33554d.setTimeInMillis(longValue2);
                            a17 = adapter.a(materialCalendarGridView.f33554d.get(5));
                            d17 = d(materialCalendarGridView.c(a17));
                        }
                        int itemId = (int) adapter.getItemId(a16);
                        int i26 = max;
                        int i27 = min;
                        int itemId2 = (int) adapter.getItemId(a17);
                        while (itemId <= itemId2) {
                            int numColumns = getNumColumns() * itemId;
                            int numColumns2 = (numColumns + getNumColumns()) - 1;
                            View c16 = materialCalendarGridView.c(numColumns);
                            int top = c16.getTop() + bVar.f33587a.c();
                            g gVar = adapter;
                            int bottom = c16.getBottom() - bVar.f33587a.b();
                            if (!i19) {
                                if (numColumns > a16) {
                                    i18 = 0;
                                } else {
                                    i18 = d16;
                                }
                                if (a17 > numColumns2) {
                                    i17 = getWidth();
                                } else {
                                    i17 = d17;
                                }
                            } else {
                                if (a17 > numColumns2) {
                                    i3 = 0;
                                } else {
                                    i3 = d17;
                                }
                                if (numColumns > a16) {
                                    i16 = getWidth();
                                } else {
                                    i16 = d16;
                                }
                                int i28 = i3;
                                i17 = i16;
                                i18 = i28;
                            }
                            canvas.drawRect(i18, top, i17, bottom, bVar.f33594h);
                            itemId++;
                            materialCalendarGridView = this;
                            it = it;
                            adapter = gVar;
                        }
                        materialCalendarGridView = this;
                        max = i26;
                        min = i27;
                    }
                }
            } else {
                materialCalendarGridView = this;
            }
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    protected void onFocusChanged(boolean z16, int i3, Rect rect) {
        if (z16) {
            a(i3, rect);
        } else {
            super.onFocusChanged(false, i3, rect);
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        if (!super.onKeyDown(i3, keyEvent)) {
            return false;
        }
        if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= getAdapter().b()) {
            return true;
        }
        if (19 != i3) {
            return false;
        }
        setSelection(getAdapter().b());
        return true;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i3, int i16) {
        if (this.f33555e) {
            super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec(16777215, Integer.MIN_VALUE));
            getLayoutParams().height = getMeasuredHeight();
            return;
        }
        super.onMeasure(i3, i16);
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public void setSelection(int i3) {
        if (i3 < getAdapter().b()) {
            super.setSelection(getAdapter().b());
        } else {
            super.setSelection(i3);
        }
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f33554d = o.q();
        if (MaterialDatePicker.Eh(getContext())) {
            setNextFocusLeftId(R.id.tlh);
            setNextFocusRightId(R.id.u49);
        }
        this.f33555e = MaterialDatePicker.Fh(getContext());
        ViewCompat.setAccessibilityDelegate(this, new a());
    }

    @Override // android.widget.AdapterView
    public final void setAdapter(ListAdapter listAdapter) {
        if (listAdapter instanceof g) {
            super.setAdapter(listAdapter);
            return;
        }
        throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), g.class.getCanonicalName()));
    }
}
