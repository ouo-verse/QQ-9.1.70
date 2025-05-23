package com.tencent.mm.ui.widget.dialog;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.tencent.luggage.wxa.lo.n;
import com.tencent.mm.ui.widget.button.WeButton;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes9.dex */
public class MMHalfBottomDialog implements ViewTreeObserver.OnGlobalLayoutListener {
    public static final int BUTTON_COLOR_BLUE = 4;
    public static final int BUTTON_COLOR_GRAY = 1;
    public static final int BUTTON_COLOR_GREEN = 0;
    public static final int BUTTON_COLOR_ORANGE = 5;
    public static final int BUTTON_COLOR_RED = 2;
    public static final int BUTTON_COLOR_WHITE = 6;
    public static final int BUTTON_COLOR_YELLOW = 3;
    public static final int BUTTON_STYLE_DOUBLE = 1;
    public static final int BUTTON_STYLE_DOUBLE_UPDOWN = 3;
    public static final int BUTTON_STYLE_HIDE = 0;
    public static final int BUTTON_STYLE_SINGLE = 2;
    public static final int HEADER_STYLE_CUSTOM = 3;
    public static final int HEADER_STYLE_DOWN_ARROW = 1;
    public static final int HEADER_STYLE_HIDE = 0;
    public static final int HEADER_STYLE_LEFT_DOWN_ARROW = 4;
    public static final int HEADER_STYLE_LRFT_TITLE = 2;
    public static final String TAG = "MicroMsg.MMHalfBottomDialog";
    public LinearLayout C;
    public LinearLayout D;
    public Button E;
    public Button F;
    public WeButton G;
    public WeButton H;
    public Button I;
    public LinearLayout J;
    public LinearLayout K;
    public LinearLayout L;
    public LinearLayout M;
    public TextView N;
    public IBtnCallBack O;
    public IBtnCallBack P;
    public IBtnCallBack Q;
    public View R;
    public boolean S;
    public boolean T;
    public int U;
    public IDismissDialogClickCallBack V;
    public IManualHideCallBack W;
    public IUpdateViewListener X;

    /* renamed from: a, reason: collision with root package name */
    public NewBottomSheetDialog f153103a;

    /* renamed from: b, reason: collision with root package name */
    public Builder f153104b;

    /* renamed from: c, reason: collision with root package name */
    public Context f153105c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f153106d;

    /* renamed from: e, reason: collision with root package name */
    public int f153107e;

    /* renamed from: f, reason: collision with root package name */
    public View f153108f;

    /* renamed from: g, reason: collision with root package name */
    public ViewTreeObserver f153109g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f153110h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f153111i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f153112j;

    /* renamed from: k, reason: collision with root package name */
    public BottomSheetBehavior f153113k;

    /* renamed from: l, reason: collision with root package name */
    public int f153114l;

    /* renamed from: m, reason: collision with root package name */
    public int f153115m;
    public View rootView;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        public Context f153134a;

        /* renamed from: b, reason: collision with root package name */
        public HalfDialogParams f153135b = new HalfDialogParams();

        public Builder(Context context) {
            this.f153134a = context;
        }

        public MMHalfBottomDialog create() {
            MMHalfBottomDialog mMHalfBottomDialog = new MMHalfBottomDialog(this.f153134a);
            mMHalfBottomDialog.apply(this.f153135b);
            return mMHalfBottomDialog;
        }

        public DialogInterface.OnCancelListener getCancelListener() {
            return this.f153135b.f152875i;
        }

        public IDismissDialogClickCallBack getDismissListener() {
            return this.f153135b.f152877k;
        }

        public IManualHideCallBack getHideCallBack() {
            return this.f153135b.f152876j;
        }

        public DialogInterface.OnShowListener getShowListener() {
            return this.f153135b.f152879m;
        }

        public Builder setContext(Context context) {
            this.f153134a = context;
            return this;
        }

        public Builder setCustomView(int i3) {
            this.f153135b.f152874h = i3;
            return this;
        }

        public Builder setDismissListener(IDismissDialogClickCallBack iDismissDialogClickCallBack) {
            this.f153135b.f152877k = iDismissDialogClickCallBack;
            return this;
        }

        public Builder setHeaderText(CharSequence charSequence) {
            this.f153135b.f152873g = charSequence;
            return this;
        }

        public Builder setManualHideListener(IManualHideCallBack iManualHideCallBack) {
            this.f153135b.f152876j = iManualHideCallBack;
            return this;
        }

        public Builder setOnShowListener(DialogInterface.OnShowListener onShowListener) {
            this.f153135b.f152879m = onShowListener;
            return this;
        }

        public Builder setSingleBtnColorStyle(int i3) {
            this.f153135b.f152872f = i3;
            return this;
        }

        public Builder setSingleBtnText(CharSequence charSequence) {
            this.f153135b.f152871e = charSequence;
            return this;
        }

        public Builder setStyle(int i3, int i16, boolean z16) {
            HalfDialogParams halfDialogParams = this.f153135b;
            halfDialogParams.f152867a = i3;
            halfDialogParams.f152868b = i16;
            halfDialogParams.f152869c = z16;
            return this;
        }

        public Builder setUpdateViewLister(IUpdateViewListener iUpdateViewListener) {
            this.f153135b.f152878l = iUpdateViewListener;
            return this;
        }

        public void show() {
            create().tryShow();
        }

        public Builder setCustomView(View view) {
            this.f153135b.f152870d = view;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface IBtnCallBack {
        void onClick();
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface IDismissDialogClickCallBack {
        void dismiss();
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface IManualHideCallBack {
        void hide(Dialog dialog, int i3);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface IOnShownListener {
        void onShown();
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface IUpdateViewListener {
        void update();
    }

    public MMHalfBottomDialog(Context context) {
        this.f153106d = false;
        this.f153111i = false;
        this.f153112j = false;
        this.S = true;
        this.T = false;
        this.f153105c = context;
        this.f153114l = 0;
        this.f153115m = 0;
        a(context);
    }

    public int a() {
        return R.layout.fk6;
    }

    public void apply(HalfDialogParams halfDialogParams) {
        NewBottomSheetDialog newBottomSheetDialog;
        int i3 = halfDialogParams.f152867a;
        if (i3 != 0) {
            this.f153114l = i3;
            c();
        }
        int i16 = halfDialogParams.f152868b;
        if (i16 != 0) {
            this.f153115m = i16;
            d();
        }
        NewBottomSheetDialog newBottomSheetDialog2 = this.f153103a;
        if (newBottomSheetDialog2 != null) {
            newBottomSheetDialog2.setCancelable(halfDialogParams.f152869c);
            this.f153103a.setWindowCloseOnTouchOutside(halfDialogParams.f152869c);
        }
        CharSequence charSequence = halfDialogParams.f152871e;
        if (charSequence != null) {
            setSingleBtnText(charSequence);
        }
        int i17 = halfDialogParams.f152872f;
        if (i17 != 0) {
            setSingleBtnColorStyle(i17);
        }
        CharSequence charSequence2 = halfDialogParams.f152873g;
        if (charSequence2 != null) {
            setHeaderText(charSequence2);
        }
        int i18 = halfDialogParams.f152874h;
        if (i18 != 0) {
            setCustomView(i18);
        }
        View view = halfDialogParams.f152870d;
        if (view != null) {
            setCustomView(view);
        }
        IDismissDialogClickCallBack iDismissDialogClickCallBack = halfDialogParams.f152877k;
        if (iDismissDialogClickCallBack != null) {
            setDismissDialogClickCallBack(iDismissDialogClickCallBack);
        }
        IManualHideCallBack iManualHideCallBack = halfDialogParams.f152876j;
        if (iManualHideCallBack != null) {
            setHideCallBack(iManualHideCallBack);
        }
        IUpdateViewListener iUpdateViewListener = halfDialogParams.f152878l;
        if (iUpdateViewListener != null) {
            setUpdateViewListener(iUpdateViewListener);
        }
        DialogInterface.OnShowListener onShowListener = halfDialogParams.f152879m;
        if (onShowListener != null && (newBottomSheetDialog = this.f153103a) != null) {
            newBottomSheetDialog.setOnShowListener(onShowListener);
        }
    }

    public void dismissDestroy(boolean z16) {
        this.f153111i = z16;
    }

    public void enableRightBtn(boolean z16) {
        Button button = this.F;
        if (button != null) {
            button.setEnabled(z16);
        }
    }

    public WeButton getBtnDown() {
        return this.H;
    }

    public Button getBtnLeft() {
        return this.E;
    }

    public Button getBtnRight() {
        return this.F;
    }

    public Button getBtnSingle() {
        return this.I;
    }

    public WeButton getBtnUp() {
        return this.G;
    }

    public Dialog getDialog() {
        return this.f153103a;
    }

    public IDismissDialogClickCallBack getDismissDialogClickCallBack() {
        return this.V;
    }

    public TextView getHeaderText() {
        return this.N;
    }

    public View getRootView() {
        return this.rootView;
    }

    public boolean isShowing() {
        NewBottomSheetDialog newBottomSheetDialog = this.f153103a;
        if (newBottomSheetDialog != null && newBottomSheetDialog.isShowing()) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (isShowing()) {
            View view = this.f153108f;
            if (view != null && (view.isShown() || view.getVisibility() == 0)) {
                if (isShowing()) {
                    if (this.f153106d != e() || this.f153107e != b()) {
                        tryHide();
                        return;
                    }
                    return;
                }
                return;
            }
            tryHide();
        }
    }

    public MMHalfBottomDialog setCustomView(int i3) {
        LinearLayout linearLayout = this.M;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
            LayoutInflater.from(this.rootView.getContext()).inflate(i3, (ViewGroup) this.M, true);
        }
        Builder builder = this.f153104b;
        if (builder != null) {
            builder.setCustomView(i3);
        }
        return this;
    }

    public void setDismissDialogClickCallBack(IDismissDialogClickCallBack iDismissDialogClickCallBack) {
        this.V = iDismissDialogClickCallBack;
        Builder builder = this.f153104b;
        if (builder != null) {
            builder.setDismissListener(iDismissDialogClickCallBack);
        }
    }

    public void setDoubleBtnClickListener(IBtnCallBack iBtnCallBack, IBtnCallBack iBtnCallBack2) {
        this.O = iBtnCallBack;
        this.P = iBtnCallBack2;
    }

    public void setDoubleBtnEnable(boolean z16, boolean z17) {
        Button button = this.E;
        if (button != null && this.F != null) {
            button.setEnabled(z16);
            this.F.setEnabled(z17);
        }
        WeButton weButton = this.H;
        if (weButton != null && this.G != null) {
            weButton.setEnabled(z16);
            this.G.setEnabled(z17);
        }
    }

    public void setDoubleBtnText(final CharSequence charSequence, final CharSequence charSequence2) {
        Button button = this.E;
        if (button != null && this.F != null) {
            button.setText(charSequence);
            this.F.setText(charSequence2);
            this.E.post(new Runnable() { // from class: com.tencent.mm.ui.widget.dialog.MMHalfBottomDialog.2
                @Override // java.lang.Runnable
                public void run() {
                    Layout layout = MMHalfBottomDialog.this.E.getLayout();
                    if (layout != null && layout.getEllipsisCount(0) > 0) {
                        n.c(MMHalfBottomDialog.TAG, "RightButton text too long, show updown mode!!", new Object[0]);
                        MMHalfBottomDialog.this.a(charSequence, charSequence2);
                    }
                }
            });
            this.F.post(new Runnable() { // from class: com.tencent.mm.ui.widget.dialog.MMHalfBottomDialog.3
                @Override // java.lang.Runnable
                public void run() {
                    Layout layout = MMHalfBottomDialog.this.F.getLayout();
                    if (layout != null && layout.getEllipsisCount(0) > 0) {
                        n.c(MMHalfBottomDialog.TAG, "RightButton text too long, show updown mode!!", new Object[0]);
                        MMHalfBottomDialog.this.a(charSequence, charSequence2);
                    }
                }
            });
        }
        WeButton weButton = this.H;
        if (weButton != null && this.G != null) {
            weButton.setText(charSequence);
            this.G.setText(charSequence2);
        }
    }

    public void setDoubleDownBtnBackgroundColor(int i3) {
        WeButton weButton = this.H;
        if (weButton != null) {
            weButton.setBackgroundColor(i3);
        }
    }

    public void setDoubleDownBtnTextColor(int i3) {
        WeButton weButton = this.H;
        if (weButton != null) {
            weButton.setTextColor(i3);
        }
    }

    public void setDoubleLeftBtnColorStyle(int i3) {
        Button button = this.E;
        if (button != null) {
            if (i3 != 0) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 != 5) {
                                if (i3 == 6) {
                                    button.setBackgroundColor(this.f153105c.getResources().getColor(R.color.aq9));
                                    return;
                                }
                                return;
                            }
                            button.setBackgroundColor(this.f153105c.getResources().getColor(R.color.av7));
                            return;
                        }
                        button.setBackgroundColor(this.f153105c.getResources().getColor(R.color.aol));
                        return;
                    }
                    button.setBackgroundColor(this.f153105c.getResources().getColor(R.color.b27));
                    return;
                }
                button.setBackgroundColor(this.f153105c.getResources().getColor(R.color.f156628aq1));
                return;
            }
            button.setBackgroundColor(this.f153105c.getResources().getColor(R.color.aq5));
        }
    }

    public void setDoubleRightBtnColorStyle(int i3) {
        Button button = this.F;
        if (button != null) {
            if (i3 != 0) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 != 5) {
                                if (i3 == 6) {
                                    button.setBackgroundColor(this.f153105c.getResources().getColor(R.color.aq9));
                                    return;
                                }
                                return;
                            }
                            button.setBackgroundColor(this.f153105c.getResources().getColor(R.color.av7));
                            return;
                        }
                        button.setBackgroundColor(this.f153105c.getResources().getColor(R.color.aol));
                        return;
                    }
                    button.setBackgroundColor(this.f153105c.getResources().getColor(R.color.b27));
                    return;
                }
                button.setBackgroundColor(this.f153105c.getResources().getColor(R.color.f156628aq1));
                return;
            }
            button.setBackgroundColor(this.f153105c.getResources().getColor(R.color.aq5));
        }
    }

    public void setDoubleUpBtnBackgroundColor(int i3) {
        WeButton weButton = this.G;
        if (weButton != null) {
            weButton.setBackgroundColor(i3);
        }
    }

    public void setDoubleUpBtnTextColor(int i3) {
        WeButton weButton = this.G;
        if (weButton != null) {
            weButton.setTextColor(i3);
        }
    }

    public void setDownBtnBackgroundColor(int i3) {
        WeButton weButton = this.H;
        if (weButton != null) {
            weButton.setBackgroundColor(i3);
        }
    }

    public void setFooterView(View view) {
        LinearLayout linearLayout = this.K;
        if (linearLayout != null) {
            if (view == null) {
                linearLayout.setVisibility(8);
                this.L.setVisibility(8);
                return;
            }
            if (this.f153114l == 3) {
                linearLayout.setVisibility(8);
                this.L.setVisibility(0);
                this.L.removeAllViews();
                this.L.setGravity(17);
                this.L.addView(view, -1, -2);
                return;
            }
            this.L.setVisibility(8);
            this.K.setVisibility(0);
            this.K.removeAllViews();
            this.K.setGravity(17);
            this.K.addView(view, -1, -2);
        }
    }

    public void setHeaderText(CharSequence charSequence) {
        TextView textView = this.N;
        if (textView != null) {
            textView.setText(charSequence);
        }
        Builder builder = this.f153104b;
        if (builder != null) {
            builder.setHeaderText(charSequence);
        }
    }

    public void setHeaderView(View view) {
        LinearLayout linearLayout = this.J;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
            this.J.removeAllViews();
            this.J.setGravity(17);
            this.J.addView(view, -1, -2);
        }
    }

    public void setHeaderViewWrapContent(View view) {
        LinearLayout linearLayout = this.J;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.J.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            this.J.setLayoutParams(layoutParams);
            this.J.removeAllViews();
            this.J.setGravity(17);
            this.J.addView(view, -1, -2);
        }
    }

    public void setHeight(int i3) {
        if (i3 != 0) {
            this.U = i3;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.rootView.getLayoutParams();
            layoutParams.height = i3;
            this.rootView.setLayoutParams(layoutParams);
            this.rootView.invalidate();
        }
    }

    public void setHideCallBack(IManualHideCallBack iManualHideCallBack) {
        this.W = iManualHideCallBack;
        Builder builder = this.f153104b;
        if (builder != null) {
            builder.setManualHideListener(iManualHideCallBack);
        }
    }

    public void setLeftBtnTextColor(int i3) {
        Button button = this.E;
        if (button != null) {
            button.setTextColor(i3);
        }
    }

    @TargetApi(23)
    public void setLightStatusBar(boolean z16) {
        this.f153110h = z16;
    }

    public void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        this.f153103a.setOnKeyListener(onKeyListener);
    }

    public void setOnShowListener(DialogInterface.OnShowListener onShowListener) {
        NewBottomSheetDialog newBottomSheetDialog = this.f153103a;
        if (newBottomSheetDialog != null) {
            newBottomSheetDialog.setOnShowListener(onShowListener);
        }
        Builder builder = this.f153104b;
        if (builder != null) {
            builder.setOnShowListener(onShowListener);
        }
    }

    public void setRightBtnTextColor(int i3) {
        Button button = this.F;
        if (button != null) {
            button.setTextColor(i3);
        }
    }

    public void setSingleBtnClickListener(IBtnCallBack iBtnCallBack) {
        this.Q = iBtnCallBack;
    }

    public void setSingleBtnColorStyle(int i3) {
        int color;
        int i16;
        Resources resources;
        Button button = this.I;
        if (button != null) {
            boolean z16 = this.T;
            int i17 = R.color.bdm;
            if (z16) {
                color = this.f153105c.getResources().getColor(R.color.bdj);
            } else {
                color = this.f153105c.getResources().getColor(R.color.bdm);
            }
            button.setTextColor(color);
            switch (i3) {
                case 0:
                    this.I.setBackgroundColor(this.f153105c.getResources().getColor(R.color.aq5));
                    break;
                case 1:
                    Button button2 = this.I;
                    Resources resources2 = this.f153105c.getResources();
                    if (this.T) {
                        i16 = R.color.f156616an3;
                    } else {
                        i16 = R.color.bks;
                    }
                    button2.setBackgroundColor(resources2.getColor(i16));
                    Button button3 = this.I;
                    if (this.T) {
                        resources = this.f153105c.getResources();
                    } else {
                        resources = this.f153105c.getResources();
                        i17 = R.color.cyu;
                    }
                    button3.setTextColor(resources.getColor(i17));
                    break;
                case 2:
                    this.I.setBackgroundColor(this.f153105c.getResources().getColor(R.color.f156628aq1));
                    break;
                case 3:
                    this.I.setBackgroundColor(this.f153105c.getResources().getColor(R.color.b27));
                    break;
                case 4:
                    this.I.setBackgroundColor(this.f153105c.getResources().getColor(R.color.aol));
                    break;
                case 5:
                    this.I.setBackgroundColor(this.f153105c.getResources().getColor(R.color.aq5));
                case 6:
                    this.I.setBackgroundColor(this.f153105c.getResources().getColor(R.color.anp));
                    this.I.setTextColor(this.f153105c.getResources().getColor(R.color.b_d));
                    break;
            }
        }
        Builder builder = this.f153104b;
        if (builder != null) {
            builder.setSingleBtnColorStyle(i3);
        }
    }

    public void setSingleBtnText(CharSequence charSequence) {
        Button button = this.I;
        if (button != null) {
            button.setText(charSequence);
        }
        Builder builder = this.f153104b;
        if (builder != null) {
            builder.setSingleBtnText(charSequence);
        }
    }

    public void setSingleBtnTextColor(int i3) {
        Button button = this.I;
        if (button != null) {
            button.setTextColor(i3);
        }
    }

    public void setSoftInputMode(int i3) {
        this.f153103a.getWindow().getAttributes().softInputMode = i3;
    }

    public void setUpBtnBackgroundColor(int i3) {
        WeButton weButton = this.G;
        if (weButton != null) {
            weButton.setBackgroundColor(i3);
        }
    }

    public void setUpdateViewListener(IUpdateViewListener iUpdateViewListener) {
        this.X = iUpdateViewListener;
    }

    public void setWidth(int i3) {
        if (i3 != 0) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.rootView.getLayoutParams();
            layoutParams.width = i3;
            this.rootView.setLayoutParams(layoutParams);
            this.rootView.invalidate();
        }
    }

    public void tryHide() {
        NewBottomSheetDialog newBottomSheetDialog = this.f153103a;
        if (newBottomSheetDialog != null) {
            Context context = this.f153105c;
            if (context instanceof Activity) {
                if (context != null && !((Activity) context).isFinishing() && !((Activity) this.f153105c).isDestroyed()) {
                    this.f153103a.dismiss();
                }
            } else {
                newBottomSheetDialog.dismiss();
            }
            BottomSheetBehavior bottomSheetBehavior = this.f153113k;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.setHideable(true);
                return;
            }
            return;
        }
        IDismissDialogClickCallBack iDismissDialogClickCallBack = this.V;
        if (iDismissDialogClickCallBack != null) {
            iDismissDialogClickCallBack.dismiss();
        }
    }

    public void tryShow() {
        boolean z16;
        this.f153106d = e();
        this.f153107e = b();
        if (!(this.f153105c instanceof Activity)) {
            com.tencent.luggage.wxa.lo.a.a(this.f153104b);
            Intent intent = new Intent(this.f153105c, (Class<?>) com.tencent.luggage.wxa.lo.a.class);
            intent.setFlags(335544320);
            intent.putExtra("dialog_scene", 3);
            Context context = this.f153105c;
            com.tencent.luggage.wxa.fa.b.a(context, intent);
            context.startActivity(intent);
            return;
        }
        if (this.f153103a != null) {
            ((ViewGroup) this.rootView.getParent()).setVisibility(0);
            f();
            this.f153103a.getWindow().addFlags(Integer.MIN_VALUE);
            if (this.f153110h) {
                g();
            }
            if (this.f153112j) {
                this.f153103a.getWindow().setFlags(8, 8);
                this.f153103a.getWindow().addFlags(131200);
                this.f153103a.getWindow().getDecorView().setSystemUiVisibility(6);
            } else {
                this.f153103a.getWindow().clearFlags(8);
                this.f153103a.getWindow().clearFlags(131072);
                this.f153103a.getWindow().clearFlags(128);
                this.f153103a.getWindow().getDecorView().setSystemUiVisibility(0);
            }
            View view = this.f153108f;
            if (view != null) {
                if (this.f153109g == null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                this.f153109g = viewTreeObserver;
                if (z16) {
                    viewTreeObserver.addOnGlobalLayoutListener(this);
                }
            }
            Context context2 = this.f153105c;
            if (context2 instanceof Activity) {
                if (!((Activity) context2).isFinishing()) {
                    this.f153103a.show();
                }
            } else {
                com.tencent.luggage.wxa.lo.a.a(this.f153104b);
                Intent intent2 = new Intent(this.f153105c, (Class<?>) com.tencent.luggage.wxa.lo.a.class);
                intent2.setFlags(335544320);
                intent2.putExtra("dialog_scene", 3);
                Context context3 = this.f153105c;
                com.tencent.luggage.wxa.fa.b.a(context3, intent2);
                context3.startActivity(intent2);
            }
            BottomSheetBehavior bottomSheetBehavior = this.f153113k;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.setHideable(false);
            }
        }
    }

    public final int b() {
        Context context = this.f153105c;
        if (context instanceof Activity) {
            return ((Activity) context).getWindow().getWindowManager().getDefaultDisplay().getRotation();
        }
        return 0;
    }

    public final void c() {
        this.C = (LinearLayout) this.rootView.findViewById(R.id.tf8);
        this.E = (Button) this.rootView.findViewById(R.id.te6);
        this.F = (Button) this.rootView.findViewById(R.id.te7);
        this.I = (Button) this.rootView.findViewById(R.id.f164686th3);
        this.D = (LinearLayout) this.rootView.findViewById(R.id.tf9);
        this.G = (WeButton) this.rootView.findViewById(R.id.te8);
        this.H = (WeButton) this.rootView.findViewById(R.id.te5);
        int i3 = this.f153114l;
        if (i3 == 0) {
            this.C.setVisibility(8);
            this.D.setVisibility(8);
            return;
        }
        if (i3 == 1) {
            this.D.setVisibility(8);
            this.C.setVisibility(0);
            this.I.setVisibility(8);
            this.E.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mm.ui.widget.dialog.MMHalfBottomDialog.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MMHalfBottomDialog.this.O != null) {
                        MMHalfBottomDialog.this.O.onClick();
                    }
                }
            });
            this.F.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mm.ui.widget.dialog.MMHalfBottomDialog.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MMHalfBottomDialog.this.P != null) {
                        MMHalfBottomDialog.this.P.onClick();
                    }
                }
            });
            return;
        }
        if (i3 == 2) {
            this.D.setVisibility(8);
            this.C.setVisibility(0);
            this.E.setVisibility(8);
            this.F.setVisibility(8);
            this.I.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mm.ui.widget.dialog.MMHalfBottomDialog.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MMHalfBottomDialog.this.Q != null) {
                        MMHalfBottomDialog.this.Q.onClick();
                    }
                }
            });
            return;
        }
        if (i3 != 3) {
            return;
        }
        this.D.setVisibility(0);
        this.C.setVisibility(8);
        this.H.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mm.ui.widget.dialog.MMHalfBottomDialog.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MMHalfBottomDialog.this.O != null) {
                    MMHalfBottomDialog.this.O.onClick();
                }
            }
        });
        this.G.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mm.ui.widget.dialog.MMHalfBottomDialog.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MMHalfBottomDialog.this.P != null) {
                    MMHalfBottomDialog.this.P.onClick();
                }
            }
        });
    }

    public final void d() {
        LinearLayout linearLayout = this.J;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
            int i3 = this.f153115m;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        View inflate = LayoutInflater.from(this.f153105c).inflate(R.layout.f_l, (ViewGroup) null);
                        this.N = (TextView) inflate.findViewById(R.id.f166992jq2);
                        this.J.removeAllViews();
                        this.J.setGravity(17);
                        this.J.addView(inflate, -1, -2);
                        return;
                    }
                    if (i3 != 4) {
                        return;
                    }
                }
                View inflate2 = LayoutInflater.from(this.f153105c).inflate(R.layout.f_k, (ViewGroup) null);
                View findViewById = inflate2.findViewById(R.id.tzk);
                View findViewById2 = inflate2.findViewById(R.id.f166039yh1);
                int i16 = this.f153115m;
                if (i16 == 1) {
                    findViewById2.setVisibility(8);
                    findViewById.setVisibility(0);
                    WeImageView weImageView = (WeImageView) inflate2.findViewById(R.id.azb);
                    if (this.T) {
                        findViewById.setBackgroundResource(R.drawable.jsj);
                        weImageView.setIconColor(this.f153105c.getResources().getColor(R.color.anp));
                    }
                    findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mm.ui.widget.dialog.MMHalfBottomDialog.11
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            MMHalfBottomDialog.this.tryHide();
                        }
                    });
                } else if (i16 == 4) {
                    findViewById2.setVisibility(0);
                    findViewById.setVisibility(8);
                    findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mm.ui.widget.dialog.MMHalfBottomDialog.12
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            MMHalfBottomDialog.this.tryHide();
                        }
                    });
                }
                this.J.removeAllViews();
                this.J.setGravity(17);
                this.J.addView(inflate2, -1, -2);
                return;
            }
            this.J.setVisibility(8);
        }
    }

    public final boolean e() {
        return this.f153105c.getResources().getConfiguration().orientation == 2;
    }

    public final void f() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.rootView.getLayoutParams();
        if (this.f153106d && this.f153108f != null) {
            Rect rect = new Rect();
            this.f153108f.getWindowVisibleDisplayFrame(rect);
            layoutParams.width = Math.min(rect.right, rect.bottom);
        }
        this.rootView.setLayoutParams(layoutParams);
    }

    public final void g() {
        NewBottomSheetDialog newBottomSheetDialog = this.f153103a;
        if (newBottomSheetDialog != null) {
            newBottomSheetDialog.getWindow().getDecorView().setSystemUiVisibility(9216);
            this.f153103a.getWindow().setStatusBarColor(0);
        }
    }

    public final void a(Context context) {
        Context context2 = this.f153105c;
        if (context2 instanceof Activity) {
            this.f153108f = ((ViewGroup) ((Activity) context2).getWindow().getDecorView()).findViewById(android.R.id.content);
            this.f153103a = new NewBottomSheetDialog(context, R.style.f173406a03);
            View inflate = View.inflate(context, a(), null);
            this.rootView = inflate;
            if (inflate != null && this.T) {
                inflate.setBackgroundResource(R.drawable.m0m);
            }
            this.J = (LinearLayout) this.rootView.findViewById(R.id.tat);
            this.K = (LinearLayout) this.rootView.findViewById(R.id.tam);
            this.L = (LinearLayout) this.rootView.findViewById(R.id.tao);
            this.M = (LinearLayout) this.rootView.findViewById(R.id.tal);
            this.R = this.rootView.findViewById(R.id.f100595sx);
            c();
            d();
            this.f153106d = e();
            this.f153103a.setContentView(this.rootView);
            this.f153103a.setCancelable(this.S);
            this.f153103a.setWindowCloseOnTouchOutside(this.S);
            this.f153103a.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mm.ui.widget.dialog.MMHalfBottomDialog.1
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (MMHalfBottomDialog.this.V != null) {
                        MMHalfBottomDialog.this.V.dismiss();
                        dialogInterface.dismiss();
                    }
                    if (MMHalfBottomDialog.this.f153109g != null) {
                        if (!MMHalfBottomDialog.this.f153109g.isAlive()) {
                            MMHalfBottomDialog mMHalfBottomDialog = MMHalfBottomDialog.this;
                            mMHalfBottomDialog.f153109g = mMHalfBottomDialog.f153108f.getViewTreeObserver();
                        }
                        MMHalfBottomDialog.this.f153109g.removeGlobalOnLayoutListener(MMHalfBottomDialog.this);
                        MMHalfBottomDialog.this.f153109g = null;
                    }
                    if (!MMHalfBottomDialog.this.f153111i) {
                        MMHalfBottomDialog.this.f153103a = null;
                    }
                }
            });
            Builder builder = this.f153104b;
            if (builder != null) {
                builder.setDismissListener(this.V);
                return;
            }
            return;
        }
        Builder builder2 = new Builder(context2);
        this.f153104b = builder2;
        builder2.setStyle(this.f153114l, this.f153115m, this.S);
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout = this.M;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
            this.M.removeAllViews();
            this.M.setGravity(17);
            this.M.addView(view, -1, -2);
            Button button = (Button) this.M.findViewById(R.id.f8w);
            Button button2 = (Button) this.M.findViewById(R.id.aou);
            if (button != null) {
                button.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mm.ui.widget.dialog.MMHalfBottomDialog.13
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (MMHalfBottomDialog.this.W != null) {
                            MMHalfBottomDialog.this.W.hide(MMHalfBottomDialog.this.f153103a, 1);
                        }
                    }
                });
            }
            if (button2 != null) {
                button2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mm.ui.widget.dialog.MMHalfBottomDialog.14
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (MMHalfBottomDialog.this.W != null) {
                            MMHalfBottomDialog.this.W.hide(MMHalfBottomDialog.this.f153103a, 0);
                        }
                    }
                });
            }
        }
        Builder builder = this.f153104b;
        if (builder != null) {
            builder.setCustomView(view);
        }
    }

    public MMHalfBottomDialog(Context context, int i3, int i16) {
        this.f153106d = false;
        this.f153111i = false;
        this.f153112j = false;
        this.S = true;
        this.T = false;
        this.f153105c = context;
        this.f153114l = i3;
        this.f153115m = i16;
        a(context);
    }

    public void setCustomView(View view, int i3, int i16) {
        LinearLayout linearLayout = this.M;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
            this.M.removeAllViews();
            this.M.setGravity(17);
            this.M.addView(view, -1, -2);
            this.M.setPadding(i3, 0, i16, 0);
        }
    }

    public MMHalfBottomDialog(Context context, int i3, int i16, boolean z16) {
        this.f153106d = false;
        this.f153111i = false;
        this.f153112j = false;
        this.T = false;
        this.f153105c = context;
        this.f153114l = i3;
        this.f153115m = i16;
        this.S = z16;
        a(context);
    }

    public void setPeekHeight(int i3) {
    }

    public final void a(CharSequence charSequence, CharSequence charSequence2) {
        this.D.setVisibility(0);
        this.C.setVisibility(8);
        WeButton weButton = this.H;
        if (weButton == null || this.G == null) {
            return;
        }
        weButton.setText(charSequence);
        this.G.setText(charSequence2);
        this.H.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mm.ui.widget.dialog.MMHalfBottomDialog.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MMHalfBottomDialog.this.O != null) {
                    MMHalfBottomDialog.this.O.onClick();
                }
            }
        });
        this.G.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mm.ui.widget.dialog.MMHalfBottomDialog.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MMHalfBottomDialog.this.P != null) {
                    MMHalfBottomDialog.this.P.onClick();
                }
            }
        });
    }

    public MMHalfBottomDialog(Context context, int i3, int i16, boolean z16, boolean z17) {
        this.f153106d = false;
        this.f153111i = false;
        this.f153112j = false;
        this.f153105c = context;
        this.f153114l = i3;
        this.f153115m = i16;
        this.S = z16;
        this.T = z17;
        a(context);
    }
}
