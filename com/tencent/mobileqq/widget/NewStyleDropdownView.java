package com.tencent.mobileqq.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListPopupWindow;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AlphaClickableImageView;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes20.dex */
public class NewStyleDropdownView extends RelativeLayout implements PopupWindow.OnDismissListener {
    private float C;
    Drawable D;
    Drawable E;
    boolean F;
    InputMethodManager G;
    private ImageView H;

    /* renamed from: d, reason: collision with root package name */
    a f315867d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f315868e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f315869f;

    /* renamed from: h, reason: collision with root package name */
    private FrameLayout f315870h;

    /* renamed from: i, reason: collision with root package name */
    private QQProAvatarView f315871i;

    /* renamed from: m, reason: collision with root package name */
    private final RelativeLayout.LayoutParams f315872m;

    public NewStyleDropdownView(Context context) {
        super(context);
        this.f315872m = new RelativeLayout.LayoutParams(-1, -1);
        this.F = false;
        this.f315867d = new a(context);
        e(context);
    }

    private void e(Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                View.class.getMethod("setImportantForAutofill", Integer.TYPE).invoke(this.f315867d, 8);
            } catch (Exception e16) {
                QLog.w("NewStyleDropdownView", 2, "disable auto fill error", e16);
            }
        }
        this.f315867d.setHintTextColor(getResources().getColor(R.color.f157252mp));
        this.f315867d.setHighlightColor(Color.parseColor("#8000CAFC"));
        this.G = (InputMethodManager) context.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        this.C = context.getResources().getDisplayMetrics().density;
        setLayoutParams(this.f315872m);
        setPadding(0, 0, 0, 0);
        addView(this.f315867d, new RelativeLayout.LayoutParams((ViewGroup.LayoutParams) this.f315872m));
        this.f315867d.setDropDownVerticalOffset(ViewUtils.dip2px(12.0f));
        this.f315867d.setDropDownHeight(ViewUtils.dip2px(251.5f));
        this.f315867d.setPadding(ViewUtils.dip2px(63.0f), 0, ViewUtils.dip2px(63.0f), 0);
        this.f315867d.setGravity(17);
        this.f315867d.setSingleLine(true);
        this.f315867d.setEllipsize(TextUtils.TruncateAt.END);
        this.f315867d.setDropDownBackgroundResource(R.drawable.adq);
        SpannableString spannableString = new SpannableString(HardCodeUtil.qqStr(R.string.f199994qx));
        spannableString.setSpan(new AbsoluteSizeSpan(17, true), 0, spannableString.length(), 33);
        this.f315867d.setHint(spannableString);
        this.f315870h = new FrameLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(ViewUtils.dip2px(10.0f), 0, 0, 0);
        layoutParams.addRule(15);
        addView(this.f315870h, layoutParams);
        this.H = new ImageView(context);
        int dip2px = ViewUtils.dip2px(40.0f) + 6;
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(dip2px, dip2px);
        this.H.setScaleType(ImageView.ScaleType.FIT_CENTER);
        layoutParams2.gravity = 17;
        this.f315870h.addView(this.H, layoutParams2);
        this.f315871i = new QQProAvatarView(context, null);
        int i3 = dip2px - 6;
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(i3, i3);
        layoutParams3.gravity = 17;
        this.f315870h.addView(this.f315871i, layoutParams3);
        ImageView imageView = new ImageView(context);
        this.f315869f = imageView;
        imageView.setImageResource(R.drawable.f161676ek4);
        this.f315869f.setClickable(true);
        this.f315869f.setVisibility(8);
        this.f315869f.setContentDescription(HardCodeUtil.qqStr(R.string.oqx));
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        ImageView imageView2 = this.f315869f;
        float f16 = this.C;
        imageView2.setPadding((int) (f16 * 10.0f), (int) (f16 * 10.0f), (int) (f16 * 10.0f), (int) (f16 * 10.0f));
        layoutParams4.setMargins(0, 0, ViewUtils.dip2px(40.0f), 0);
        layoutParams4.addRule(15);
        layoutParams4.addRule(11, -1);
        addView(this.f315869f, layoutParams4);
        AlphaClickableImageView alphaClickableImageView = new AlphaClickableImageView(context);
        this.f315868e = alphaClickableImageView;
        alphaClickableImageView.setId(PlayerResources.ViewId.EXTENDED_VIEW_LEFT_TOP_CIRCLE);
        ImageView imageView3 = this.f315868e;
        float f17 = this.C;
        imageView3.setPadding((int) (f17 * 10.0f), (int) (f17 * 10.0f), (int) (f17 * 10.0f), (int) (f17 * 10.0f));
        this.f315868e.setContentDescription(HardCodeUtil.qqStr(R.string.oqv));
        this.D = getResources().getDrawable(R.drawable.f160929ct0);
        this.E = getResources().getDrawable(R.drawable.f160930ct1);
        this.f315868e.setImageDrawable(this.D);
        this.f315868e.setClickable(true);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.setMargins(0, 0, ViewUtils.dip2px(15.0f), 0);
        layoutParams5.addRule(15);
        layoutParams5.addRule(11, -1);
        addView(this.f315868e, layoutParams5);
        this.f315868e.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.widget.NewStyleDropdownView.1
            @Override // android.view.View.OnClickListener
            public void onClick(final View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                NewStyleDropdownView.this.f315867d.clearFocus();
                NewStyleDropdownView newStyleDropdownView = NewStyleDropdownView.this;
                boolean z16 = false;
                newStyleDropdownView.G.hideSoftInputFromWindow(newStyleDropdownView.f315867d.getWindowToken(), 0);
                if (NewStyleDropdownView.this.f315867d.getAdapter() != null && NewStyleDropdownView.this.f315867d.getAdapter().getCount() > 0) {
                    int count = NewStyleDropdownView.this.f315867d.getAdapter().getCount();
                    if (count < 5) {
                        int dip2px2 = ViewUtils.dip2px(7.5f) * 2;
                        NewStyleDropdownView.this.f315867d.setDropDownHeight(dip2px2 + (count * (ViewUtils.dip2px(40.0f) + dip2px2)));
                    } else {
                        NewStyleDropdownView.this.f315867d.setDropDownHeight(ViewUtils.dip2px(251.5f));
                    }
                    Drawable drawable = ((ImageView) view).getDrawable();
                    if (QLog.isColorLevel()) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("arrow clicked, drawable is down=");
                        if (drawable == NewStyleDropdownView.this.D) {
                            z16 = true;
                        }
                        sb5.append(z16);
                        sb5.append(", isLastDropDown=");
                        sb5.append(NewStyleDropdownView.this.F);
                        QLog.d("NewStyleDropdownView", 2, sb5.toString());
                    }
                    NewStyleDropdownView newStyleDropdownView2 = NewStyleDropdownView.this;
                    if (drawable == newStyleDropdownView2.D && !newStyleDropdownView2.F) {
                        newStyleDropdownView2.getClass();
                        NewStyleDropdownView.this.f315868e.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.widget.NewStyleDropdownView.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (QLog.isColorLevel()) {
                                    QLog.d("NewStyleDropdownView", 2, "arrow clicked and postDelayed 250 run, set icon up and isLastDropDown true");
                                }
                                ((ImageView) view).setImageDrawable(NewStyleDropdownView.this.E);
                                NewStyleDropdownView.this.getClass();
                                NewStyleDropdownView.this.F = true;
                            }
                        }, 500L);
                        ReportController.r(null, "dc00898", "", "", "0X8007367", "0X8007367", 0, 0, "", "", "", "");
                    } else {
                        newStyleDropdownView2.getClass();
                        NewStyleDropdownView.this.f315867d.dismissDropDown();
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        try {
            Field declaredField = this.f315867d.getClass().getSuperclass().getDeclaredField("mPopup");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(this.f315867d);
            obj.getClass().getMethod("setOnDismissListener", PopupWindow.OnDismissListener.class).invoke(obj, this);
        } catch (Exception e17) {
            if (QLog.isDevelopLevel()) {
                QLog.e("NewStyleDropdownView", 4, e17, new Object[0]);
            }
        }
    }

    public ImageView b() {
        return this.f315869f;
    }

    public AutoCompleteTextView c() {
        return this.f315867d;
    }

    public void d() {
        this.D = null;
        this.E = null;
        this.f315868e.setVisibility(8);
    }

    public void f(boolean z16, Object obj) {
        if (z16) {
            this.f315870h.setVisibility(0);
            if (obj instanceof String) {
                com.tencent.mobileqq.login.account.d.f241848a.h(this.f315871i, (String) obj, 140, null);
                return;
            }
            if (obj instanceof Bitmap) {
                this.f315871i.setImageBitmap((Bitmap) obj);
                this.H.setVisibility(0);
                return;
            } else if (obj instanceof Drawable) {
                this.f315871i.setImageDrawable((Drawable) obj);
                this.H.setVisibility(4);
                return;
            } else {
                this.f315871i.setImageResource(R.drawable.csy);
                this.H.setVisibility(0);
                return;
            }
        }
        this.f315870h.setVisibility(8);
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        if (QLog.isColorLevel()) {
            QLog.d("NewStyleDropdownView", 2, "onDismiss set icon down");
        }
        this.f315868e.setImageDrawable(this.D);
        this.f315868e.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.widget.NewStyleDropdownView.2
            @Override // java.lang.Runnable
            public void run() {
                if (QLog.isColorLevel()) {
                    QLog.d("NewStyleDropdownView", 2, "onDismiss arrow postDelayed 500 run and set isLastDropDown false");
                }
                NewStyleDropdownView.this.F = false;
            }
        }, 500L);
    }

    public void setHeadBorder(int i3) {
        this.H.setImageResource(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @SuppressLint({"AppCompatCustomView"})
    /* loaded from: classes20.dex */
    public class a extends AutoCompleteTextView {

        /* renamed from: d, reason: collision with root package name */
        private boolean f315876d;

        public a(Context context) {
            super(context);
            setId(526);
            this.f315876d = true;
        }

        @Override // android.widget.AutoCompleteTextView
        public boolean enoughToFilter() {
            return true;
        }

        @Override // android.widget.AutoCompleteTextView
        public boolean isPopupShowing() {
            if (this.f315876d) {
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
            } catch (Exception e16) {
                if (QLog.isDevelopLevel()) {
                    QLog.e("NewStyleDropdownView", 4, e16, new Object[0]);
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public void showDropDown() {
            try {
                super.showDropDown();
                try {
                    Field declaredField = getClass().getSuperclass().getDeclaredField("mDropDownList");
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(this);
                    obj.getClass().getSuperclass().getMethod("setDividerHeight", Integer.TYPE).invoke(obj, 0);
                    obj.getClass().getSuperclass().getMethod("setVerticalScrollBarEnabled", Boolean.TYPE).invoke(obj, Boolean.FALSE);
                } catch (Exception unused) {
                    try {
                        Field declaredField2 = getClass().getSuperclass().getDeclaredField("mPopup");
                        declaredField2.setAccessible(true);
                        Object obj2 = declaredField2.get(this);
                        Field declaredField3 = obj2.getClass().getDeclaredField("mDropDownList");
                        declaredField3.setAccessible(true);
                        Object obj3 = declaredField3.get(obj2);
                        obj3.getClass().getSuperclass().getMethod("setDividerHeight", Integer.TYPE).invoke(obj3, 0);
                        obj3.getClass().getSuperclass().getMethod("setVerticalScrollBarEnabled", Boolean.TYPE).invoke(obj3, Boolean.FALSE);
                        if (obj2 instanceof PopupWindow) {
                            ((PopupWindow) obj2).setAnimationStyle(R.anim.f155031h7);
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("NewStyleDropdownView", 2, " showDropDown popupWindow:" + obj2);
                        }
                        if (obj2 instanceof ListPopupWindow) {
                            ListPopupWindow listPopupWindow = (ListPopupWindow) obj2;
                            if (listPopupWindow.getListView() != null) {
                                ListView listView = listPopupWindow.getListView();
                                LoginPopupMaskView loginPopupMaskView = null;
                                try {
                                    listView.setPadding(ViewUtils.dip2px(13.0f), 0, ViewUtils.dip2px(13.0f), 0);
                                    listView.setOverScrollMode(2);
                                    listView.setVerticalScrollBarEnabled(false);
                                    listView.setDivider(null);
                                    listView.setDividerHeight(0);
                                } catch (Throwable th5) {
                                    QLog.e("NewStyleDropdownView", 1, " showDropDown error:" + th5.getMessage());
                                }
                                ViewParent parent = listView.getParent();
                                if (parent instanceof FrameLayout) {
                                    FrameLayout frameLayout = (FrameLayout) parent;
                                    int count = getAdapter().getCount();
                                    boolean z16 = false;
                                    boolean z17 = false;
                                    for (int i3 = 0; i3 < frameLayout.getChildCount(); i3++) {
                                        if (frameLayout.getChildAt(i3) != null && (frameLayout.getChildAt(i3) instanceof LoginPopupMaskView)) {
                                            loginPopupMaskView = (LoginPopupMaskView) frameLayout.getChildAt(i3);
                                            z16 = true;
                                        } else if (frameLayout.getChildAt(i3) != null && (frameLayout.getChildAt(i3) instanceof LoginPopupRightMaskView)) {
                                            z17 = true;
                                        }
                                    }
                                    if (QLog.isColorLevel()) {
                                        QLog.d("NewStyleDropdownView", 2, " showDropDown find: " + z16 + " count: " + count);
                                    }
                                    if (!z17) {
                                        LoginPopupRightMaskView loginPopupRightMaskView = new LoginPopupRightMaskView(frameLayout.getContext());
                                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewUtils.dip2px(20.0f), -1);
                                        layoutParams.gravity = 5;
                                        frameLayout.addView(loginPopupRightMaskView, layoutParams);
                                    }
                                    if (loginPopupMaskView != null) {
                                        if (count > 4) {
                                            loginPopupMaskView.setVisibility(0);
                                            return;
                                        } else {
                                            loginPopupMaskView.setVisibility(8);
                                            return;
                                        }
                                    }
                                    if (!z16 && count > 4) {
                                        LoginPopupMaskView loginPopupMaskView2 = new LoginPopupMaskView(frameLayout.getContext());
                                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, ViewUtils.dip2px(14.0f));
                                        layoutParams2.bottomMargin = 0;
                                        layoutParams2.gravity = 80;
                                        frameLayout.addView(loginPopupMaskView2, layoutParams2);
                                    }
                                }
                            }
                        }
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.d("NewStyleDropdownView", 2, " showDropDown error::" + e16.getMessage());
                        }
                    }
                }
            } catch (OutOfMemoryError e17) {
                e17.printStackTrace();
            }
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            setId(526);
            this.f315876d = true;
        }

        public a(Context context, AttributeSet attributeSet, int i3) {
            super(context, attributeSet, i3);
            setId(526);
            this.f315876d = true;
        }

        @Override // android.widget.AutoCompleteTextView
        protected void performFiltering(CharSequence charSequence, int i3) {
        }
    }

    public NewStyleDropdownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f315872m = new RelativeLayout.LayoutParams(-1, -1);
        this.F = false;
        this.f315867d = new a(context, attributeSet);
        e(context);
    }

    @TargetApi(11)
    public NewStyleDropdownView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f315872m = new RelativeLayout.LayoutParams(-1, -1);
        this.F = false;
        this.f315867d = new a(context, attributeSet, i3);
        e(context);
    }
}
