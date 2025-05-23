package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import androidx.annotation.ArrayRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.ListPopupWindow;
import com.google.android.material.internal.o;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes2.dex */
public class MaterialAutoCompleteTextView extends AppCompatAutoCompleteTextView {

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private final ListPopupWindow f34357d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private final AccessibilityManager f34358e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    private final Rect f34359f;

    /* renamed from: h, reason: collision with root package name */
    @LayoutRes
    private final int f34360h;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements AdapterView.OnItemClickListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            Object item;
            EventCollector.getInstance().onItemClickBefore(adapterView, view, i3, j3);
            MaterialAutoCompleteTextView materialAutoCompleteTextView = MaterialAutoCompleteTextView.this;
            if (i3 < 0) {
                item = materialAutoCompleteTextView.f34357d.getSelectedItem();
            } else {
                item = materialAutoCompleteTextView.getAdapter().getItem(i3);
            }
            MaterialAutoCompleteTextView.this.e(item);
            AdapterView.OnItemClickListener onItemClickListener = MaterialAutoCompleteTextView.this.getOnItemClickListener();
            if (onItemClickListener != null) {
                if (view == null || i3 < 0) {
                    view = MaterialAutoCompleteTextView.this.f34357d.getSelectedView();
                    i3 = MaterialAutoCompleteTextView.this.f34357d.getSelectedItemPosition();
                    j3 = MaterialAutoCompleteTextView.this.f34357d.getSelectedItemId();
                }
                onItemClickListener.onItemClick(MaterialAutoCompleteTextView.this.f34357d.getListView(), view, i3, j3);
            }
            MaterialAutoCompleteTextView.this.f34357d.dismiss();
            EventCollector.getInstance().onItemClick(adapterView, view, i3, j3);
        }
    }

    public MaterialAutoCompleteTextView(@NonNull Context context) {
        this(context, null);
    }

    @Nullable
    private TextInputLayout c() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    private int d() {
        ListAdapter adapter = getAdapter();
        TextInputLayout c16 = c();
        int i3 = 0;
        if (adapter == null || c16 == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int min = Math.min(adapter.getCount(), Math.max(0, this.f34357d.getSelectedItemPosition()) + 15);
        View view = null;
        int i16 = 0;
        for (int max = Math.max(0, min - 15); max < min; max++) {
            int itemViewType = adapter.getItemViewType(max);
            if (itemViewType != i3) {
                view = null;
                i3 = itemViewType;
            }
            view = adapter.getView(max, view, c16);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i16 = Math.max(i16, view.getMeasuredWidth());
        }
        Drawable background = this.f34357d.getBackground();
        if (background != null) {
            background.getPadding(this.f34359f);
            Rect rect = this.f34359f;
            i16 += rect.left + rect.right;
        }
        return i16 + c16.Q().getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T extends ListAdapter & Filterable> void e(Object obj) {
        setText(convertSelectionToString(obj), false);
    }

    @Override // android.widget.TextView
    @Nullable
    public CharSequence getHint() {
        TextInputLayout c16 = c();
        if (c16 != null && c16.i0()) {
            return c16.U();
        }
        return super.getHint();
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout c16 = c();
        if (c16 != null && c16.i0() && super.getHint() == null && com.google.android.material.internal.f.c()) {
            setHint("");
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        if (View.MeasureSpec.getMode(i3) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), d()), View.MeasureSpec.getSize(i3)), getMeasuredHeight());
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public <T extends ListAdapter & Filterable> void setAdapter(@Nullable T t16) {
        super.setAdapter(t16);
        this.f34357d.setAdapter(getAdapter());
    }

    public void setSimpleItems(@ArrayRes int i3) {
        setSimpleItems(getResources().getStringArray(i3));
    }

    @Override // android.widget.AutoCompleteTextView
    public void showDropDown() {
        AccessibilityManager accessibilityManager = this.f34358e;
        if (accessibilityManager != null && accessibilityManager.isTouchExplorationEnabled()) {
            this.f34357d.show();
        } else {
            super.showDropDown();
        }
    }

    public MaterialAutoCompleteTextView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.f5298t);
    }

    public void setSimpleItems(@NonNull String[] strArr) {
        setAdapter(new ArrayAdapter(getContext(), this.f34360h, strArr));
    }

    public MaterialAutoCompleteTextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(k1.a.c(context, attributeSet, i3, 0), attributeSet, i3);
        this.f34359f = new Rect();
        Context context2 = getContext();
        TypedArray h16 = o.h(context2, attributeSet, w0.a.P3, i3, R.style.ak6, new int[0]);
        int i16 = w0.a.Q3;
        if (h16.hasValue(i16) && h16.getInt(i16, 0) == 0) {
            setKeyListener(null);
        }
        this.f34360h = h16.getResourceId(w0.a.R3, R.layout.flf);
        this.f34358e = (AccessibilityManager) context2.getSystemService("accessibility");
        ListPopupWindow listPopupWindow = new ListPopupWindow(context2);
        this.f34357d = listPopupWindow;
        listPopupWindow.setModal(true);
        listPopupWindow.setAnchorView(this);
        listPopupWindow.setInputMethodMode(2);
        listPopupWindow.setAdapter(getAdapter());
        listPopupWindow.setOnItemClickListener(new a());
        int i17 = w0.a.S3;
        if (h16.hasValue(i17)) {
            setSimpleItems(h16.getResourceId(i17, 0));
        }
        h16.recycle();
    }
}
