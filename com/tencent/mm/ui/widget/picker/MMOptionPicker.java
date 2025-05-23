package com.tencent.mm.ui.widget.picker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.a;
import com.tencent.luggage.wxa.fc.c;
import com.tencent.luggage.wxa.lo.o;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes9.dex */
public class MMOptionPicker implements ViewTreeObserver.OnGlobalLayoutListener {
    public static final int BUTTON_COLOR_GRAY = 1;
    public static final int BUTTON_COLOR_GREEN = 0;
    public static final int BUTTON_COLOR_RED = 2;
    public CustomOptionPickNew C;
    public OnResultListener D;
    public OnMultiResultListener E;
    public LinearLayout F;
    public LinearLayout G;
    public LinearLayout H;
    public LinearLayout I;
    public LinearLayout J;
    public LinearLayout K;
    public boolean L;

    /* renamed from: a, reason: collision with root package name */
    public a f153557a;

    /* renamed from: b, reason: collision with root package name */
    public View f153558b;

    /* renamed from: c, reason: collision with root package name */
    public Context f153559c;

    /* renamed from: d, reason: collision with root package name */
    public int f153560d;

    /* renamed from: e, reason: collision with root package name */
    public BottomSheetBehavior f153561e;

    /* renamed from: f, reason: collision with root package name */
    public Button f153562f;
    public OnFirstOptionChange firstValueListener;

    /* renamed from: g, reason: collision with root package name */
    public Button f153563g;

    /* renamed from: h, reason: collision with root package name */
    public Button f153564h;

    /* renamed from: i, reason: collision with root package name */
    public String[] f153565i;

    /* renamed from: j, reason: collision with root package name */
    public ArrayList f153566j;

    /* renamed from: k, reason: collision with root package name */
    public ArrayList f153567k;

    /* renamed from: l, reason: collision with root package name */
    public CustomOptionPickNew f153568l;

    /* renamed from: m, reason: collision with root package name */
    public CustomOptionPickNew f153569m;
    public OnSecondOptionChange secondValueListener;

    /* loaded from: classes9.dex */
    public interface OnFirstOptionChange {
        void onValueChange(int i3);
    }

    /* loaded from: classes9.dex */
    public interface OnMultiResultListener<T> {
        void onResult(boolean z16, T t16, T t17, T t18);
    }

    /* loaded from: classes9.dex */
    public interface OnResultListener<T> {
        void onResult(boolean z16, T t16, T t17);
    }

    /* loaded from: classes9.dex */
    public interface OnSecondOptionChange {
        void onValueChange(int i3);
    }

    public MMOptionPicker(Context context, String[] strArr) {
        this.f153566j = null;
        this.f153567k = null;
        this.L = false;
        this.f153559c = context;
        this.f153565i = strArr;
        a();
    }

    public void adjustPanelOnLandScape(int i3) {
        if (i3 != 0) {
            ViewGroup viewGroup = (ViewGroup) this.f153558b.getParent();
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            layoutParams.width = i3;
            viewGroup.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.F.getLayoutParams();
            layoutParams2.setMargins(layoutParams2.leftMargin, 0, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.G.getLayoutParams();
            layoutParams3.setMargins(layoutParams3.leftMargin, 0, layoutParams3.rightMargin, layoutParams3.bottomMargin);
            LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.H.getLayoutParams();
            layoutParams4.setMargins(layoutParams4.leftMargin, 0, layoutParams4.rightMargin, layoutParams4.bottomMargin);
            LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.K.getLayoutParams();
            layoutParams5.setMargins(layoutParams5.leftMargin, 10, layoutParams5.rightMargin, layoutParams5.bottomMargin);
            this.f153558b.invalidate();
        }
    }

    public Dialog getDialog() {
        return this.f153557a;
    }

    public int getSecondSelectedItem() {
        CustomOptionPickNew customOptionPickNew = this.f153569m;
        if (customOptionPickNew != null) {
            return customOptionPickNew.currentIndex();
        }
        return 0;
    }

    public int getSelectedItem() {
        CustomOptionPickNew customOptionPickNew = this.f153568l;
        if (customOptionPickNew != null) {
            return customOptionPickNew.currentIndex();
        }
        return 0;
    }

    public int getThirdSelectedItem() {
        CustomOptionPickNew customOptionPickNew = this.C;
        if (customOptionPickNew != null) {
            return customOptionPickNew.currentIndex();
        }
        return 0;
    }

    public void hide() {
        a aVar = this.f153557a;
        if (aVar != null) {
            aVar.dismiss();
        }
    }

    public boolean isDisableLink() {
        return this.L;
    }

    public boolean isThreeColumnType() {
        if (this.C != null) {
            return true;
        }
        return false;
    }

    public void setFirstArrayList(String[] strArr) {
        CustomOptionPickNew customOptionPickNew = this.f153568l;
        if (customOptionPickNew != null) {
            customOptionPickNew.setOptionsArray(strArr);
        }
    }

    public void setFirstSelectedItemIndex(int i3) {
        CustomOptionPickNew customOptionPickNew = this.f153568l;
        if (customOptionPickNew != null) {
            customOptionPickNew.setValue(i3);
            this.f153568l.updateSelectedItem(i3);
        }
    }

    public void setFooterView(View view) {
        LinearLayout linearLayout = this.J;
        if (linearLayout != null) {
            if (view == null) {
                linearLayout.setVisibility(8);
                return;
            }
            linearLayout.setVisibility(0);
            this.J.removeAllViews();
            this.J.setGravity(17);
            this.J.addView(view, new LinearLayout.LayoutParams(-1, -2));
        }
    }

    public void setHeaderView(View view) {
        LinearLayout linearLayout = this.I;
        if (linearLayout != null) {
            if (view == null) {
                linearLayout.setVisibility(8);
                return;
            }
            linearLayout.setVisibility(0);
            this.I.removeAllViews();
            this.I.setGravity(17);
            this.I.addView(view, new LinearLayout.LayoutParams(-1, -2));
        }
    }

    public void setLeftBtnBg(int i3) {
        Button button = this.f153563g;
        if (button != null) {
            button.setBackgroundResource(i3);
        }
    }

    public void setLeftBtnTextColor(int i3) {
        Button button = this.f153563g;
        if (button != null) {
            button.setTextColor(i3);
        }
    }

    public void setOnResultListener(OnResultListener onResultListener) {
        this.D = onResultListener;
    }

    public void setPanelHeight(int i3) {
        if (i3 != 0) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f153558b.getLayoutParams();
            layoutParams.height = i3;
            this.f153558b.setLayoutParams(layoutParams);
            this.f153558b.invalidate();
        }
    }

    public void setRightBtnBg(int i3) {
        Button button = this.f153562f;
        if (button != null) {
            button.setBackgroundResource(i3);
        }
    }

    public void setRightBtnColorStyle(int i3) {
        Button button = this.f153562f;
        if (button != null) {
            button.setTextColor(this.f153559c.getResources().getColor(R.color.bdm));
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        this.f153562f.setBackgroundResource(R.drawable.jen);
                        return;
                    }
                    return;
                } else {
                    this.f153562f.setBackgroundResource(R.drawable.jel);
                    this.f153562f.setTextColor(this.f153559c.getResources().getColor(R.color.cyu));
                    return;
                }
            }
            this.f153562f.setBackgroundResource(R.drawable.jeg);
        }
    }

    public void setRightBtnText(CharSequence charSequence) {
        Button button = this.f153562f;
        if (button != null) {
            button.setText(charSequence);
        }
    }

    public void setSecondArrayList(String[] strArr) {
        CustomOptionPickNew customOptionPickNew = this.f153569m;
        if (customOptionPickNew != null) {
            customOptionPickNew.setOptionsArray(strArr);
        }
    }

    public void setSecondSelectedItemIndex(int i3) {
        CustomOptionPickNew customOptionPickNew = this.f153569m;
        if (customOptionPickNew != null) {
            customOptionPickNew.setValue(i3);
            this.f153569m.updateSelectedItem(i3);
        }
    }

    public void setSelectedItem(int i3) {
        CustomOptionPickNew customOptionPickNew = this.f153568l;
        if (customOptionPickNew != null) {
            customOptionPickNew.setValue(i3);
            this.f153568l.updateSelectedItem(i3);
            CustomOptionPickNew customOptionPickNew2 = this.f153569m;
            if (customOptionPickNew2 == null || this.f153566j == null) {
                return;
            }
            customOptionPickNew2.setOptionsArray(a(i3));
        }
    }

    public void setSingleBtnColorStyle(int i3) {
        Button button = this.f153564h;
        if (button != null) {
            button.setTextColor(this.f153559c.getResources().getColor(R.color.bdm));
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        this.f153564h.setBackgroundResource(R.drawable.jen);
                        return;
                    }
                    return;
                } else {
                    this.f153564h.setBackgroundResource(R.drawable.jel);
                    this.f153564h.setTextColor(this.f153559c.getResources().getColor(R.color.cyu));
                    return;
                }
            }
            this.f153564h.setBackgroundResource(R.drawable.jeg);
        }
    }

    public void setSingleBtnText(CharSequence charSequence) {
        Button button = this.f153564h;
        if (button != null) {
            button.setText(charSequence);
        }
    }

    public void setThirdArrayList(String[] strArr) {
        CustomOptionPickNew customOptionPickNew = this.C;
        if (customOptionPickNew != null) {
            customOptionPickNew.setOptionsArray(strArr);
        }
    }

    public void setThirdSelectedItemIndex(int i3) {
        CustomOptionPickNew customOptionPickNew = this.C;
        if (customOptionPickNew != null) {
            customOptionPickNew.setValue(i3);
            this.C.updateSelectedItem(i3);
        }
    }

    public void setTransparentBg() {
        a aVar = this.f153557a;
        if (aVar != null) {
            aVar.getWindow().setDimAmount(0.0f);
        }
    }

    public void setmOnMultiResultListener(OnMultiResultListener onMultiResultListener) {
        this.E = onMultiResultListener;
    }

    public void show() {
        a aVar = this.f153557a;
        if (aVar != null) {
            aVar.show();
        }
    }

    public void showSingleBtn(boolean z16) {
        if (z16) {
            Button button = this.f153564h;
            if (button != null) {
                button.setVisibility(0);
            }
            Button button2 = this.f153562f;
            if (button2 != null) {
                button2.setVisibility(8);
            }
            Button button3 = this.f153563g;
            if (button3 != null) {
                button3.setVisibility(8);
                return;
            }
            return;
        }
        Button button4 = this.f153564h;
        if (button4 != null) {
            button4.setVisibility(8);
        }
        Button button5 = this.f153562f;
        if (button5 != null) {
            button5.setVisibility(0);
        }
        Button button6 = this.f153563g;
        if (button6 != null) {
            button6.setVisibility(0);
        }
    }

    public final String[] b(int i3) {
        ArrayList arrayList;
        ArrayList arrayList2 = this.f153567k;
        if (arrayList2 == null || (arrayList = (ArrayList) arrayList2.get(i3)) == null) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public final void a() {
        this.f153557a = new a(this.f153559c);
        View inflate = View.inflate(this.f153559c, R.layout.fk9, null);
        this.f153558b = inflate;
        this.I = (LinearLayout) inflate.findViewById(R.id.f213400r);
        this.J = (LinearLayout) this.f153558b.findViewById(R.id.f213300q);
        this.F = (LinearLayout) this.f153558b.findViewById(R.id.f213200p);
        this.K = (LinearLayout) this.f153558b.findViewById(R.id.f213800v);
        CustomOptionPickNew customOptionPickNew = new CustomOptionPickNew(this.f153559c);
        this.f153568l = customOptionPickNew;
        customOptionPickNew.setOptionsArray(this.f153565i);
        this.F.removeAllViews();
        this.F.setGravity(17);
        this.F.addView(this.f153568l.getView(), new LinearLayout.LayoutParams(-2, -1));
        this.G = (LinearLayout) this.f153558b.findViewById(R.id.f213500s);
        this.H = (LinearLayout) this.f153558b.findViewById(R.id.f213900w);
        if (this.f153566j != null) {
            this.G.setVisibility(0);
            this.f153569m = new CustomOptionPickNew(this.f153559c);
            this.G.removeAllViews();
            this.G.setGravity(17);
            this.G.addView(this.f153569m.getView(), new LinearLayout.LayoutParams(-2, -1));
            this.f153569m.setOptionsArray(a(this.f153568l.currentIndex()));
            this.f153568l.setOnValueChangedListener(new c() { // from class: com.tencent.mm.ui.widget.picker.MMOptionPicker.1
                @Override // com.tencent.luggage.wxa.fc.c
                public void onOptionsSelectChanged(int i3) {
                    OnFirstOptionChange onFirstOptionChange = MMOptionPicker.this.firstValueListener;
                    if (onFirstOptionChange != null) {
                        onFirstOptionChange.onValueChange(i3);
                    }
                    if (MMOptionPicker.this.L) {
                        return;
                    }
                    MMOptionPicker.this.f153569m.setOptionsArray(MMOptionPicker.this.a(i3));
                    if (MMOptionPicker.this.f153567k != null && MMOptionPicker.this.C != null) {
                        int i16 = 0;
                        for (int i17 = 0; i17 < i3; i17++) {
                            i16 += ((List) MMOptionPicker.this.f153566j.get(i17)).size();
                        }
                        MMOptionPicker.this.C.setOptionsArray(MMOptionPicker.this.b(i16 + MMOptionPicker.this.f153569m.currentIndex()));
                    }
                }
            });
        } else {
            this.G.setVisibility(8);
            CustomOptionPickNew customOptionPickNew2 = this.f153568l;
            if (customOptionPickNew2 != null) {
                customOptionPickNew2.setOnValueChangedListener(new c() { // from class: com.tencent.mm.ui.widget.picker.MMOptionPicker.2
                    @Override // com.tencent.luggage.wxa.fc.c
                    public void onOptionsSelectChanged(int i3) {
                        OnFirstOptionChange onFirstOptionChange = MMOptionPicker.this.firstValueListener;
                        if (onFirstOptionChange != null) {
                            onFirstOptionChange.onValueChange(i3);
                        }
                    }
                });
            }
        }
        if (this.f153567k != null) {
            this.H.setVisibility(0);
            this.C = new CustomOptionPickNew(this.f153559c);
            this.H.removeAllViews();
            this.H.setGravity(17);
            this.H.addView(this.C.getView(), new LinearLayout.LayoutParams(-2, -1));
            this.C.setOptionsArray(b(this.f153569m.currentIndex()));
            this.f153569m.setOnValueChangedListener(new c() { // from class: com.tencent.mm.ui.widget.picker.MMOptionPicker.3
                @Override // com.tencent.luggage.wxa.fc.c
                public void onOptionsSelectChanged(int i3) {
                    OnSecondOptionChange onSecondOptionChange = MMOptionPicker.this.secondValueListener;
                    if (onSecondOptionChange != null) {
                        onSecondOptionChange.onValueChange(i3);
                    }
                    if (MMOptionPicker.this.L) {
                        return;
                    }
                    int currentIndex = MMOptionPicker.this.f153568l.currentIndex();
                    int i16 = 0;
                    for (int i17 = 0; i17 < currentIndex; i17++) {
                        i16 += ((List) MMOptionPicker.this.f153566j.get(i17)).size();
                    }
                    MMOptionPicker.this.C.setOptionsArray(MMOptionPicker.this.b(i16 + i3));
                }
            });
        } else {
            this.H.setVisibility(8);
            CustomOptionPickNew customOptionPickNew3 = this.f153569m;
            if (customOptionPickNew3 != null) {
                customOptionPickNew3.setOnValueChangedListener(new c() { // from class: com.tencent.mm.ui.widget.picker.MMOptionPicker.4
                    @Override // com.tencent.luggage.wxa.fc.c
                    public void onOptionsSelectChanged(int i3) {
                        OnSecondOptionChange onSecondOptionChange = MMOptionPicker.this.secondValueListener;
                        if (onSecondOptionChange != null) {
                            onSecondOptionChange.onValueChange(i3);
                        }
                    }
                });
            }
        }
        Button button = (Button) this.f153558b.findViewById(R.id.fcw);
        this.f153562f = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mm.ui.widget.picker.MMOptionPicker.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String currentValue;
                String currentValue2;
                String currentValue3;
                String currentValue4;
                MMOptionPicker mMOptionPicker = MMOptionPicker.this;
                String str = null;
                if (mMOptionPicker.f153568l == null) {
                    currentValue = null;
                } else {
                    currentValue = MMOptionPicker.this.f153568l.currentValue();
                }
                if (MMOptionPicker.this.f153569m == null) {
                    currentValue2 = null;
                } else {
                    currentValue2 = MMOptionPicker.this.f153569m.currentValue();
                }
                mMOptionPicker.a(true, currentValue, currentValue2);
                MMOptionPicker mMOptionPicker2 = MMOptionPicker.this;
                if (mMOptionPicker2.f153568l == null) {
                    currentValue3 = null;
                } else {
                    currentValue3 = MMOptionPicker.this.f153568l.currentValue();
                }
                if (MMOptionPicker.this.f153569m == null) {
                    currentValue4 = null;
                } else {
                    currentValue4 = MMOptionPicker.this.f153569m.currentValue();
                }
                if (MMOptionPicker.this.C != null) {
                    str = MMOptionPicker.this.C.currentValue();
                }
                mMOptionPicker2.a(true, (Object) currentValue3, (Object) currentValue4, (Object) str);
            }
        });
        Button button2 = (Button) this.f153558b.findViewById(R.id.aou);
        this.f153563g = button2;
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mm.ui.widget.picker.MMOptionPicker.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MMOptionPicker.this.a(false, null, null);
                MMOptionPicker.this.a(false, (Object) null, (Object) null, (Object) null);
            }
        });
        Button button3 = (Button) this.f153558b.findViewById(R.id.f164686th3);
        this.f153564h = button3;
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mm.ui.widget.picker.MMOptionPicker.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String currentValue;
                String currentValue2;
                String currentValue3;
                String currentValue4;
                MMOptionPicker mMOptionPicker = MMOptionPicker.this;
                String str = null;
                if (mMOptionPicker.f153568l == null) {
                    currentValue = null;
                } else {
                    currentValue = MMOptionPicker.this.f153568l.currentValue();
                }
                if (MMOptionPicker.this.f153569m == null) {
                    currentValue2 = null;
                } else {
                    currentValue2 = MMOptionPicker.this.f153569m.currentValue();
                }
                mMOptionPicker.a(true, currentValue, currentValue2);
                MMOptionPicker mMOptionPicker2 = MMOptionPicker.this;
                if (mMOptionPicker2.f153568l == null) {
                    currentValue3 = null;
                } else {
                    currentValue3 = MMOptionPicker.this.f153568l.currentValue();
                }
                if (MMOptionPicker.this.f153569m == null) {
                    currentValue4 = null;
                } else {
                    currentValue4 = MMOptionPicker.this.f153569m.currentValue();
                }
                if (MMOptionPicker.this.C != null) {
                    str = MMOptionPicker.this.C.currentValue();
                }
                mMOptionPicker2.a(true, (Object) currentValue3, (Object) currentValue4, (Object) str);
            }
        });
        this.f153557a.setContentView(this.f153558b);
        this.f153560d = o.a(this.f153559c, 420);
        BottomSheetBehavior from = BottomSheetBehavior.from((View) this.f153558b.getParent());
        this.f153561e = from;
        if (from != null) {
            from.setPeekHeight(this.f153560d);
            this.f153561e.setHideable(false);
        }
        this.f153557a.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mm.ui.widget.picker.MMOptionPicker.8
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                MMOptionPicker.this.f153557a = null;
                MMOptionPicker.this.a(false, null, null);
                MMOptionPicker.this.a(false, (Object) null, (Object) null, (Object) null);
            }
        });
    }

    public void setSelectedItem(int i3, int i16) {
        CustomOptionPickNew customOptionPickNew = this.f153568l;
        if (customOptionPickNew == null || this.f153569m == null) {
            return;
        }
        customOptionPickNew.setValue(i3);
        this.f153568l.updateSelectedItem(i3);
        this.f153569m.setOptionsArray(a(i3));
        this.f153569m.setValue(i16);
        this.f153569m.updateSelectedItem(i16);
        this.f153569m.invalidate();
    }

    public MMOptionPicker(Context context, ArrayList<String> arrayList) {
        this.f153566j = null;
        this.f153567k = null;
        this.L = false;
        this.f153559c = context;
        if (arrayList != null) {
            this.f153565i = (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        a();
    }

    public void setSelectedItem(int i3, int i16, int i17) {
        CustomOptionPickNew customOptionPickNew = this.f153568l;
        if (customOptionPickNew == null || this.f153569m == null || this.C == null) {
            return;
        }
        customOptionPickNew.setValue(i3);
        this.f153568l.updateSelectedItem(i3);
        this.f153569m.setOptionsArray(a(i3));
        this.f153569m.setValue(i16);
        this.f153569m.updateSelectedItem(i16);
        this.f153569m.invalidate();
        this.C.setOptionsArray(b(i16));
        this.C.setValue(i17);
        this.C.updateSelectedItem(i17);
        this.C.invalidate();
    }

    public MMOptionPicker(Context context, ArrayList<String> arrayList, ArrayList<List<String>> arrayList2) {
        this.f153566j = null;
        this.f153567k = null;
        this.L = false;
        this.f153559c = context;
        if (arrayList != null) {
            this.f153565i = (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        this.f153566j = arrayList2;
        a();
    }

    public MMOptionPicker(Context context, ArrayList<String> arrayList, ArrayList<List<String>> arrayList2, ArrayList<List<String>> arrayList3) {
        this.f153566j = null;
        this.f153567k = null;
        this.L = false;
        this.f153559c = context;
        if (arrayList != null) {
            this.f153565i = (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        this.f153566j = arrayList2;
        this.f153567k = arrayList3;
        a();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
    }

    public MMOptionPicker(Context context, ArrayList<String> arrayList, ArrayList<List<String>> arrayList2, ArrayList<List<String>> arrayList3, boolean z16) {
        this.f153566j = null;
        this.f153567k = null;
        this.L = false;
        this.f153559c = context;
        if (arrayList != null) {
            this.f153565i = (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        this.f153566j = arrayList2;
        this.f153567k = arrayList3;
        this.L = z16;
        a();
    }

    public final void a(boolean z16, Object obj, Object obj2) {
        OnResultListener onResultListener = this.D;
        if (onResultListener != null) {
            onResultListener.onResult(z16, obj, obj2);
        }
    }

    public final void a(boolean z16, Object obj, Object obj2, Object obj3) {
        OnMultiResultListener onMultiResultListener = this.E;
        if (onMultiResultListener != null) {
            onMultiResultListener.onResult(z16, obj, obj2, obj3);
        }
    }

    public final String[] a(int i3) {
        ArrayList arrayList;
        ArrayList arrayList2 = this.f153566j;
        if (arrayList2 == null || (arrayList = (ArrayList) arrayList2.get(i3)) == null) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
