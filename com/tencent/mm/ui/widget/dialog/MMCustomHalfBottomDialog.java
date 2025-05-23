package com.tencent.mm.ui.widget.dialog;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.tencent.luggage.wxa.lo.p;
import com.tencent.luggage.wxa.lo.q;
import com.tencent.mobileqq.R;
import java.util.LinkedList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
/* loaded from: classes9.dex */
public class MMCustomHalfBottomDialog implements ViewTreeObserver.OnGlobalLayoutListener {
    public OnPassiveDismissListener C;
    public boolean D;
    public LinearLayout E;
    public View F;
    public TextView G;
    public CancelBtnCallBack H;
    public int I;
    public int J;
    public boolean K;
    public int L;
    public ViewGroup M;
    public ViewGroup N;
    public LinkedList O;
    public p P;
    public boolean Q;
    public boolean R;

    /* renamed from: a, reason: collision with root package name */
    public Dialog f153039a;

    /* renamed from: b, reason: collision with root package name */
    public Context f153040b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f153041c;

    /* renamed from: d, reason: collision with root package name */
    public int f153042d;

    /* renamed from: e, reason: collision with root package name */
    public int f153043e;

    /* renamed from: f, reason: collision with root package name */
    public View f153044f;

    /* renamed from: g, reason: collision with root package name */
    public ViewTreeObserver f153045g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f153046h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f153047i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f153048j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f153049k;

    /* renamed from: l, reason: collision with root package name */
    public BottomSheetBehavior f153050l;

    /* renamed from: m, reason: collision with root package name */
    public OnDismissListener f153051m;
    public View rootView;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface CancelBtnCallBack {
        void onClick();
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface OnDismissListener {
        void onDismiss();
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface OnPassiveDismissListener {
        void onDismiss();
    }

    public MMCustomHalfBottomDialog(Context context) {
        this(context, 0);
        a(context);
    }

    public void autoWhite5() {
        this.M.setBackgroundResource(R.drawable.m0p);
    }

    public View findViewById(int i3) {
        return this.f153039a.findViewById(i3);
    }

    public void forceDark() {
        this.M.setBackgroundResource(R.drawable.m0m);
    }

    public void forceLight() {
        this.M.setBackgroundResource(R.drawable.m0q);
    }

    public void forceTransparent() {
        this.M.setBackgroundColor(this.f153040b.getResources().getColor(R.color.ajr));
    }

    @Nullable
    public BottomSheetBehavior getBottomSheetBehavior() {
        return this.f153050l;
    }

    public LinkedList<CustomBottomSheetPage> getChildPages() {
        return this.O;
    }

    public ViewGroup getContentContainer() {
        return this.M;
    }

    public Dialog getDialog() {
        return this.f153039a;
    }

    public ViewGroup getPageContainer() {
        return this.N;
    }

    public View getRootView() {
        return this.rootView;
    }

    public Window getWindow() {
        Dialog dialog = this.f153039a;
        if (dialog != null) {
            return dialog.getWindow();
        }
        return null;
    }

    public void hideBottomPage(final CustomBottomSheetPage customBottomSheetPage, boolean z16) {
        final View childAt = this.N.getChildAt(this.O.indexOf(customBottomSheetPage));
        if (childAt == null) {
            return;
        }
        if (!z16) {
            childAt.setVisibility(8);
            customBottomSheetPage.onPagePopped();
            customBottomSheetPage.f153064a = null;
            this.O.remove(customBottomSheetPage);
            this.N.removeView(childAt);
            return;
        }
        this.P.d(childAt, new Function0<Unit>() { // from class: com.tencent.mm.ui.widget.dialog.MMCustomHalfBottomDialog.4
            @Override // kotlin.jvm.functions.Function0
            public Unit invoke() {
                childAt.setVisibility(8);
                customBottomSheetPage.onPagePopped();
                customBottomSheetPage.f153064a = null;
                MMCustomHalfBottomDialog.this.O.remove(customBottomSheetPage);
                MMCustomHalfBottomDialog.this.N.removeView(childAt);
                return Unit.INSTANCE;
            }
        }, this.N.getWidth());
    }

    public void hideCancelBtn(boolean z16) {
        LinearLayout linearLayout = this.E;
        if (linearLayout == null) {
            return;
        }
        if (z16) {
            linearLayout.setVisibility(8);
        } else {
            linearLayout.setVisibility(0);
        }
    }

    public void initDialog(Context context, int i3, boolean z16, boolean z17) {
        this.f153040b = context;
        a(context);
        this.f153049k = z17;
        Context context2 = this.f153040b;
        if (context2 instanceof Activity) {
            this.f153044f = ((ViewGroup) ((Activity) context2).getWindow().getDecorView()).findViewById(android.R.id.content);
        }
        this.I = i3;
        a(this.f153040b, z16);
    }

    public boolean isShowing() {
        Dialog dialog = this.f153039a;
        if (dialog != null && dialog.isShowing()) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (isShowing()) {
            View view = this.f153044f;
            if (view != null && (view.isShown() || view.getVisibility() == 0)) {
                if (isShowing()) {
                    if (this.f153041c == b() && this.f153042d == a()) {
                        if (this.f153043e != this.M.getHeight()) {
                            this.f153043e = this.M.getHeight();
                            int width = this.M.getWidth();
                            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.N.getLayoutParams();
                            layoutParams.height = this.f153043e;
                            layoutParams.width = width;
                            layoutParams.gravity = 85;
                            this.N.setLayoutParams(layoutParams);
                            return;
                        }
                        return;
                    }
                    tryHide();
                    return;
                }
                return;
            }
            tryHide();
        }
    }

    public void popBottomPage(CustomBottomSheetPage customBottomSheetPage) {
        View view;
        if (!this.O.contains(customBottomSheetPage)) {
            return;
        }
        int indexOf = this.O.indexOf(customBottomSheetPage);
        if (indexOf > 0) {
            view = this.N.getChildAt(indexOf - 1);
        } else {
            view = this.M;
        }
        view.setVisibility(0);
        this.P.a(view, null, this.N.getWidth());
        hideBottomPage((CustomBottomSheetPage) this.O.peekLast(), true);
        int indexOf2 = this.O.indexOf(customBottomSheetPage);
        if (indexOf2 < 0) {
            return;
        }
        for (int size = this.O.size() - 2; size >= indexOf2; size--) {
            hideBottomPage((CustomBottomSheetPage) this.O.get(size), false);
        }
    }

    public boolean popTopPage() {
        if (this.O.isEmpty()) {
            return false;
        }
        popBottomPage((CustomBottomSheetPage) this.O.getLast());
        return true;
    }

    public void pushBottomPage(CustomBottomSheetPage customBottomSheetPage) {
        boolean z16;
        if (customBottomSheetPage == null) {
            return;
        }
        Dialog dialog = this.f153039a;
        if (dialog != null && !dialog.isShowing()) {
            z16 = true;
        } else {
            z16 = false;
        }
        View view = customBottomSheetPage.getView(this.N.getContext());
        if (view == null) {
            return;
        }
        customBottomSheetPage.f153064a = this;
        this.O.add(customBottomSheetPage);
        view.setVisibility(8);
        this.N.addView(view);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.gravity = 80;
        view.setLayoutParams(layoutParams);
        a(customBottomSheetPage, z16);
    }

    public void resetTransparentBg() {
        Dialog dialog = this.f153039a;
        if (dialog != null) {
            dialog.getWindow().setDimAmount(1.0f);
        }
    }

    public void setCancelOutSize(boolean z16) {
        Dialog dialog = this.f153039a;
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(z16);
            this.f153039a.setCancelable(z16);
        }
    }

    public void setCancelSpaceVisible(boolean z16) {
        int i3;
        View view = this.F;
        if (view != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view.setVisibility(i3);
        }
    }

    public void setCancelTvColor(int i3) {
        TextView textView = this.G;
        if (textView != null) {
            textView.setTextColor(i3);
        }
    }

    public MMCustomHalfBottomDialog setCustomView(int i3) {
        LayoutInflater.from(this.rootView.getContext()).inflate(i3, this.M, true);
        return this;
    }

    public void setEnableBehavior(boolean z16) {
        this.Q = z16;
    }

    public void setHideNavigationFullScreen(Boolean bool) {
        this.f153048j = bool.booleanValue();
    }

    public void setIfContainSoftInput(Boolean bool) {
        this.R = bool.booleanValue();
    }

    public void setIsCanHide(boolean z16) {
        this.K = z16;
    }

    @TargetApi(23)
    public void setLightStatusBar(boolean z16) {
        this.f153046h = z16;
    }

    public void setNewLandscapeMaxWidth(int i3) {
        this.L = i3;
    }

    public void setNotDestroy(boolean z16) {
        this.f153047i = z16;
    }

    public void setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        Dialog dialog = this.f153039a;
        if (dialog != null) {
            dialog.setOnCancelListener(onCancelListener);
        }
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.f153051m = onDismissListener;
    }

    public void setOnPassiveDismissListener(OnPassiveDismissListener onPassiveDismissListener) {
        this.C = onPassiveDismissListener;
    }

    public void setTransparentBg() {
        Dialog dialog = this.f153039a;
        if (dialog != null) {
            dialog.getWindow().setDimAmount(0.0f);
        }
    }

    public MMCustomHalfBottomDialog showAlwaysDark(boolean z16) {
        if (this.rootView != null) {
            if (z16) {
                this.M.setBackgroundResource(R.drawable.m0m);
                this.F.setBackgroundColor(this.f153040b.getResources().getColor(R.color.aqq));
                this.G.setTextColor(this.f153040b.getResources().getColor(R.color.anp));
                this.G.setBackgroundResource(R.drawable.jkg);
            } else {
                this.M.setBackgroundResource(R.drawable.m0p);
            }
        }
        return this;
    }

    public void tryHide(boolean z16) {
        setNotDestroy(z16);
        tryHide();
    }

    public void tryShow() {
        this.f153041c = b();
        this.f153042d = a();
        if (this.f153039a != null) {
            boolean z16 = false;
            ((ViewGroup) this.rootView.getParent()).setVisibility(0);
            c();
            this.f153039a.getWindow().addFlags(Integer.MIN_VALUE);
            if (this.f153046h) {
                e();
            }
            if (this.f153048j) {
                this.f153039a.getWindow().setFlags(8, 8);
                this.f153039a.getWindow().addFlags(131200);
                this.f153039a.getWindow().getDecorView().setSystemUiVisibility(6);
            } else {
                this.f153039a.getWindow().clearFlags(8);
                this.f153039a.getWindow().clearFlags(131072);
                this.f153039a.getWindow().clearFlags(128);
                this.f153039a.getWindow().getDecorView().setSystemUiVisibility(0);
            }
            if (this.f153048j && this.R) {
                this.f153039a.getWindow().clearFlags(8);
                this.f153039a.getWindow().clearFlags(131072);
            }
            View view = this.f153044f;
            if (view != null) {
                if (this.f153045g == null) {
                    z16 = true;
                }
                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                this.f153045g = viewTreeObserver;
                if (z16) {
                    viewTreeObserver.addOnGlobalLayoutListener(this);
                }
            }
            Context context = this.f153040b;
            if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
                this.f153039a.show();
            }
            BottomSheetBehavior bottomSheetBehavior = this.f153050l;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.setHideable(this.K);
            }
        }
    }

    public void upCornerBg0R12() {
        this.M.setBackgroundResource(R.drawable.m0k);
    }

    public final boolean b() {
        return this.f153040b.getResources().getConfiguration().orientation == 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.rootView.getLayoutParams();
        if (!this.f153049k && this.f153041c && this.f153044f != null && this.Q) {
            Rect rect = new Rect();
            this.f153044f.getWindowVisibleDisplayFrame(rect);
            layoutParams.width = Math.min(rect.right, rect.bottom);
            layoutParams.gravity = 1;
            final ViewParent parent = this.rootView.getParent();
            if (parent instanceof View) {
                ((View) parent).setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mm.ui.widget.dialog.MMCustomHalfBottomDialog.5

                    /* renamed from: a, reason: collision with root package name */
                    public boolean f153059a = false;

                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        parent.getParent().requestDisallowInterceptTouchEvent(true);
                        int action = motionEvent.getAction();
                        if (action != 0) {
                            if (action != 1) {
                                if (action == 3) {
                                    this.f153059a = false;
                                }
                            } else {
                                if (this.f153059a) {
                                    MMCustomHalfBottomDialog.this.tryHide();
                                }
                                this.f153059a = false;
                            }
                        } else {
                            this.f153059a = true;
                        }
                        return true;
                    }
                });
            }
            if (parent instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) parent;
                if (viewGroup.getLayoutParams() instanceof CoordinatorLayout.LayoutParams) {
                    CoordinatorLayout.LayoutParams layoutParams2 = (CoordinatorLayout.LayoutParams) viewGroup.getLayoutParams();
                    BottomSheetBehavior<FrameLayout> bottomSheetBehavior = new BottomSheetBehavior<FrameLayout>() { // from class: com.tencent.mm.ui.widget.dialog.MMCustomHalfBottomDialog.6
                        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
                        public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FrameLayout frameLayout, @NonNull View view, @NonNull View view2, int i3, int i16) {
                            return false;
                        }
                    };
                    bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.e() { // from class: com.tencent.mm.ui.widget.dialog.MMCustomHalfBottomDialog.7
                        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
                        public void onStateChanged(@NonNull View view, int i3) {
                            if (i3 == 4 && MMCustomHalfBottomDialog.this.b() && MMCustomHalfBottomDialog.this.f153039a.isShowing()) {
                                MMCustomHalfBottomDialog.this.tryHide();
                            }
                        }

                        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
                        public void onSlide(@NonNull View view, float f16) {
                        }
                    });
                    layoutParams2.setBehavior(bottomSheetBehavior);
                    this.f153050l = bottomSheetBehavior;
                    d();
                }
            }
        }
        if (this.f153041c && this.f153044f != null) {
            Rect rect2 = new Rect();
            this.f153044f.getWindowVisibleDisplayFrame(rect2);
            if (this.f153049k) {
                layoutParams.width = (int) ((rect2.right * 1.0f) / 2.0f);
                int i3 = this.L;
                if (i3 != 0) {
                    layoutParams.width = i3;
                }
                if (q.g(this.f153040b)) {
                    layoutParams.height = rect2.bottom - q.f(this.f153040b);
                } else {
                    layoutParams.height = rect2.bottom;
                }
            } else {
                layoutParams.width = Math.min(rect2.right, rect2.bottom);
                int i16 = this.L;
                if (i16 != 0) {
                    layoutParams.width = i16;
                }
            }
        }
        this.rootView.setLayoutParams(layoutParams);
    }

    public void d() {
        BottomSheetBehavior bottomSheetBehavior = this.f153050l;
        if (bottomSheetBehavior != null) {
            if (this.I > 0) {
                bottomSheetBehavior.setState(4);
                this.f153050l.setPeekHeight(this.I);
            } else {
                bottomSheetBehavior.setState(3);
            }
        }
    }

    public final void e() {
        Dialog dialog = this.f153039a;
        if (dialog != null) {
            dialog.getWindow().getDecorView().setSystemUiVisibility(9216);
            this.f153039a.getWindow().setStatusBarColor(0);
        }
    }

    public MMCustomHalfBottomDialog setCustomView(View view) {
        this.M.addView(view, 0);
        return this;
    }

    public MMCustomHalfBottomDialog(Context context, int i3) {
        this(context, i3, false);
        a(context);
    }

    public MMCustomHalfBottomDialog setCustomView(View view, FrameLayout.LayoutParams layoutParams) {
        this.M.addView(view, 0, layoutParams);
        return this;
    }

    public void tryHide() {
        Dialog dialog = this.f153039a;
        if (dialog != null) {
            Context context = this.f153040b;
            if (context instanceof Activity) {
                if (context != null && !((Activity) context).isFinishing() && !((Activity) this.f153040b).isDestroyed()) {
                    this.D = true;
                    this.f153039a.dismiss();
                }
            } else {
                this.D = true;
                dialog.dismiss();
            }
            BottomSheetBehavior bottomSheetBehavior = this.f153050l;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.setHideable(true);
            }
        }
    }

    public final void a(Context context) {
        this.P = new p(context);
    }

    public MMCustomHalfBottomDialog(Context context, boolean z16) {
        this(context, 0, z16, false);
        a(context);
    }

    public final int a() {
        Context context = this.f153040b;
        if (context instanceof Activity) {
            return ((Activity) context).getWindow().getWindowManager().getDefaultDisplay().getRotation();
        }
        return 0;
    }

    public MMCustomHalfBottomDialog(Context context, int i3, boolean z16) {
        this(context, i3, false, z16);
    }

    public void a(Context context, boolean z16) {
        if (this.f153049k) {
            this.f153039a = new CustomSheetDialog(context);
        } else if (z16) {
            this.f153039a = new NewBottomSheetDialog(context, R.style.f173406a03);
        } else {
            this.f153039a = new com.google.android.material.bottomsheet.a(context, this.J);
        }
        View inflate = View.inflate(context, R.layout.f168298fk0, null);
        this.rootView = inflate;
        this.M = (ViewGroup) inflate.findViewById(R.id.tak);
        this.N = (ViewGroup) this.rootView.findViewById(R.id.tar);
        this.E = (LinearLayout) this.rootView.findViewById(R.id.taj);
        this.F = this.rootView.findViewById(R.id.tlk);
        this.G = (TextView) this.rootView.findViewById(R.id.tll);
        this.E.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mm.ui.widget.dialog.MMCustomHalfBottomDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MMCustomHalfBottomDialog.this.tryHide();
                if (MMCustomHalfBottomDialog.this.H != null) {
                    MMCustomHalfBottomDialog.this.H.onClick();
                }
            }
        });
        this.f153041c = b();
        this.f153039a.requestWindowFeature(1);
        this.f153039a.setContentView(this.rootView);
        if (!this.f153049k && !z16) {
            this.f153050l = BottomSheetBehavior.from((View) this.rootView.getParent());
            d();
        }
        this.f153039a.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.tencent.mm.ui.widget.dialog.a
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
                boolean a16;
                a16 = MMCustomHalfBottomDialog.this.a(dialogInterface, i3, keyEvent);
                return a16;
            }
        });
        this.f153039a.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mm.ui.widget.dialog.MMCustomHalfBottomDialog.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (MMCustomHalfBottomDialog.this.f153045g != null) {
                    if (!MMCustomHalfBottomDialog.this.f153045g.isAlive()) {
                        MMCustomHalfBottomDialog mMCustomHalfBottomDialog = MMCustomHalfBottomDialog.this;
                        mMCustomHalfBottomDialog.f153045g = mMCustomHalfBottomDialog.f153044f.getViewTreeObserver();
                    }
                    MMCustomHalfBottomDialog.this.f153045g.removeGlobalOnLayoutListener(MMCustomHalfBottomDialog.this);
                    MMCustomHalfBottomDialog.this.f153045g = null;
                }
                if (!MMCustomHalfBottomDialog.this.f153047i) {
                    MMCustomHalfBottomDialog.this.f153039a = null;
                }
                if (MMCustomHalfBottomDialog.this.f153051m != null) {
                    MMCustomHalfBottomDialog.this.f153051m.onDismiss();
                }
                if (MMCustomHalfBottomDialog.this.C != null && !MMCustomHalfBottomDialog.this.D) {
                    MMCustomHalfBottomDialog.this.C.onDismiss();
                }
                MMCustomHalfBottomDialog.this.M.setTranslationX(0.0f);
                MMCustomHalfBottomDialog.this.M.setVisibility(0);
                MMCustomHalfBottomDialog.this.N.removeAllViews();
                MMCustomHalfBottomDialog.this.O.clear();
            }
        });
    }

    public MMCustomHalfBottomDialog(Context context, int i3, boolean z16, boolean z17) {
        this.f153041c = false;
        this.f153047i = false;
        this.f153048j = false;
        this.f153049k = false;
        this.f153051m = null;
        this.C = null;
        this.D = false;
        this.J = R.style.f246458y;
        this.L = 0;
        this.O = new LinkedList();
        this.Q = true;
        this.R = false;
        initDialog(context, i3, z16, z17);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static abstract class CustomBottomSheetPage {

        /* renamed from: a, reason: collision with root package name */
        public MMCustomHalfBottomDialog f153064a;

        @Nullable
        public MMCustomHalfBottomDialog getBottomSheet() {
            return this.f153064a;
        }

        public ViewGroup getRootView() {
            MMCustomHalfBottomDialog mMCustomHalfBottomDialog = this.f153064a;
            if (mMCustomHalfBottomDialog != null) {
                return mMCustomHalfBottomDialog.N;
            }
            return null;
        }

        @NonNull
        public abstract View getView(@NonNull Context context);

        public void pop() {
            MMCustomHalfBottomDialog mMCustomHalfBottomDialog = this.f153064a;
            if (mMCustomHalfBottomDialog != null) {
                mMCustomHalfBottomDialog.popBottomPage(this);
            }
        }

        public void setmBottomSheet(MMCustomHalfBottomDialog mMCustomHalfBottomDialog) {
            this.f153064a = mMCustomHalfBottomDialog;
        }

        public void onPagePopped() {
        }

        public void onPagePushed() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean a(DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
        if (i3 != 4) {
            return false;
        }
        if (popTopPage()) {
            return true;
        }
        dialogInterface.dismiss();
        return true;
    }

    public final void a(CustomBottomSheetPage customBottomSheetPage, boolean z16) {
        int indexOf;
        View childAt;
        final View view;
        if (this.O.contains(customBottomSheetPage) && (childAt = this.N.getChildAt((indexOf = this.O.indexOf(customBottomSheetPage)))) != null) {
            if (indexOf > 0) {
                view = this.N.getChildAt(indexOf - 1);
            } else {
                view = this.M;
            }
            childAt.setVisibility(0);
            customBottomSheetPage.onPagePushed();
            childAt.setTranslationX(z16 ? 0.0f : this.N.getWidth());
            if (z16) {
                return;
            }
            this.P.b(childAt, null, this.N.getWidth());
            if (view != null) {
                this.P.c(view, new Function0<Unit>() { // from class: com.tencent.mm.ui.widget.dialog.MMCustomHalfBottomDialog.3
                    @Override // kotlin.jvm.functions.Function0
                    public Unit invoke() {
                        view.setVisibility(4);
                        return Unit.INSTANCE;
                    }
                }, this.N.getWidth());
            }
        }
    }
}
