package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes20.dex */
public class DropdownView extends RelativeLayout implements PopupWindow.OnDismissListener {
    Drawable C;
    boolean D;
    InputMethodManager E;
    private Context F;

    /* renamed from: d, reason: collision with root package name */
    a f315622d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f315623e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f315624f;

    /* renamed from: h, reason: collision with root package name */
    private final RelativeLayout.LayoutParams f315625h;

    /* renamed from: i, reason: collision with root package name */
    private float f315626i;

    /* renamed from: m, reason: collision with root package name */
    Drawable f315627m;

    public DropdownView(Context context) {
        super(context);
        this.f315625h = new RelativeLayout.LayoutParams(-1, -1);
        this.D = false;
        this.F = context;
        this.f315622d = new a(context);
        b(context);
    }

    private void b(Context context) {
        this.E = (InputMethodManager) context.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        this.f315626i = context.getResources().getDisplayMetrics().density;
        setLayoutParams(this.f315625h);
        setPadding(0, 0, 0, 0);
        addView(this.f315622d, new RelativeLayout.LayoutParams((ViewGroup.LayoutParams) this.f315625h));
        this.f315622d.setDropDownVerticalOffset(0);
        LinearLayout linearLayout = new LinearLayout(context);
        new RelativeLayout.LayoutParams((ViewGroup.LayoutParams) this.f315625h);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams.setMargins(0, 0, 0, 0);
        layoutParams.addRule(15);
        layoutParams.addRule(7, this.f315622d.getId());
        addView(linearLayout, layoutParams);
        ImageView imageView = new ImageView(context);
        this.f315624f = imageView;
        float f16 = this.f315626i;
        imageView.setPadding((int) (f16 * 10.0f), (int) (f16 * 10.0f), (int) (f16 * 15.0f), (int) (f16 * 10.0f));
        this.f315624f.setImageResource(R.drawable.haa);
        this.f315624f.setClickable(true);
        this.f315624f.setVisibility(8);
        this.f315624f.setContentDescription(HardCodeUtil.qqStr(R.string.lta));
        new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams) this.f315625h);
        float f17 = this.f315626i;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams((int) (44.0f * f17), (int) (f17 * 39.0f));
        layoutParams2.gravity = 16;
        linearLayout.addView(this.f315624f, layoutParams2);
        ImageView imageView2 = new ImageView(context);
        this.f315623e = imageView2;
        imageView2.setId(PlayerResources.ViewId.EXTENDED_VIEW_LEFT_TOP_CIRCLE);
        ImageView imageView3 = this.f315623e;
        float f18 = this.f315626i;
        imageView3.setPadding((int) (1.0f * f18), (int) (f18 * 10.0f), (int) (15.0f * f18), (int) (f18 * 10.0f));
        this.f315623e.setContentDescription(HardCodeUtil.qqStr(R.string.ltb));
        this.f315627m = getResources().getDrawable(R.drawable.f160931ct2);
        this.C = getResources().getDrawable(R.drawable.f160932ct3);
        this.f315623e.setImageDrawable(this.f315627m);
        this.f315623e.setClickable(true);
        float f19 = this.f315626i;
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams((int) (35.0f * f19), (int) (f19 * 33.0f));
        layoutParams3.gravity = 16;
        linearLayout.addView(this.f315623e, layoutParams3);
        this.f315623e.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.widget.DropdownView.1
            @Override // android.view.View.OnClickListener
            public void onClick(final View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                DropdownView.this.f315622d.clearFocus();
                DropdownView dropdownView = DropdownView.this;
                dropdownView.E.hideSoftInputFromWindow(dropdownView.f315622d.getWindowToken(), 0);
                if (DropdownView.this.f315622d.getAdapter() != null && DropdownView.this.f315622d.getAdapter().getCount() > 0) {
                    Drawable drawable = ((ImageView) view).getDrawable();
                    DropdownView dropdownView2 = DropdownView.this;
                    if (drawable == dropdownView2.f315627m && !dropdownView2.D) {
                        dropdownView2.f315623e.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.widget.DropdownView.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                DropdownView.this.f315622d.showDropDown();
                                ((ImageView) view).setImageDrawable(DropdownView.this.C);
                                DropdownView.this.D = true;
                            }
                        }, 250L);
                        view.getContext();
                    } else {
                        dropdownView2.f315622d.dismissDropDown();
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        try {
            Field declaredField = this.f315622d.getClass().getSuperclass().getDeclaredField("mPopup");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(this.f315622d);
            obj.getClass().getMethod("setOnDismissListener", PopupWindow.OnDismissListener.class).invoke(obj, this);
        } catch (Exception unused) {
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f315623e.setImageDrawable(this.f315627m);
        new Handler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.widget.DropdownView.2
            @Override // java.lang.Runnable
            public void run() {
                DropdownView.this.D = false;
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a extends AutoCompleteTextView {

        /* renamed from: d, reason: collision with root package name */
        private boolean f315631d;

        public a(Context context) {
            super(context);
            setId(526);
            this.f315631d = true;
        }

        @Override // android.widget.AutoCompleteTextView
        public boolean enoughToFilter() {
            return true;
        }

        @Override // android.widget.AutoCompleteTextView
        public boolean isPopupShowing() {
            if (this.f315631d) {
                return super.isPopupShowing();
            }
            return false;
        }

        @Override // android.widget.TextView
        public void onEditorAction(int i3) {
            if (i3 == 5) {
                View focusSearch = focusSearch(130);
                if (focusSearch != null && !focusSearch.requestFocus(130)) {
                    throw new IllegalStateException("focus search returned a view that wasn't able to take focus!");
                }
                return;
            }
            super.onEditorAction(i3);
        }

        @Override // android.widget.TextView
        protected void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            super.onTextChanged(charSequence, i3, i16, i17);
            try {
                if (isPopupShowing()) {
                    dismissDropDown();
                }
            } catch (Exception unused) {
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public void showDropDown() {
            try {
                super.showDropDown();
                try {
                    try {
                        Field declaredField = getClass().getSuperclass().getDeclaredField("mDropDownList");
                        declaredField.setAccessible(true);
                        Object obj = declaredField.get(this);
                        obj.getClass().getSuperclass().getMethod("setDividerHeight", Integer.TYPE).invoke(obj, 0);
                    } catch (Exception unused) {
                    }
                } catch (Exception unused2) {
                    Field declaredField2 = getClass().getSuperclass().getDeclaredField("mPopup");
                    declaredField2.setAccessible(true);
                    Object obj2 = declaredField2.get(this);
                    Field declaredField3 = obj2.getClass().getDeclaredField("mDropDownList");
                    declaredField3.setAccessible(true);
                    Object obj3 = declaredField3.get(obj2);
                    obj3.getClass().getSuperclass().getMethod("setDividerHeight", Integer.TYPE).invoke(obj3, 0);
                    ((PopupWindow) obj2).setAnimationStyle(R.anim.f155031h7);
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            } catch (OutOfMemoryError e17) {
                e17.printStackTrace();
            }
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            setId(526);
            this.f315631d = true;
        }

        public a(Context context, AttributeSet attributeSet, int i3) {
            super(context, attributeSet, i3);
            setId(526);
            this.f315631d = true;
        }

        @Override // android.widget.AutoCompleteTextView
        protected void performFiltering(CharSequence charSequence, int i3) {
        }
    }

    public DropdownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f315625h = new RelativeLayout.LayoutParams(-1, -1);
        this.D = false;
        this.f315622d = new a(context, attributeSet);
        b(context);
    }

    @TargetApi(11)
    public DropdownView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f315625h = new RelativeLayout.LayoutParams(-1, -1);
        this.D = false;
        this.f315622d = new a(context, attributeSet, i3);
        b(context);
    }
}
