package com.google.android.material.datepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: classes2.dex */
public final class MaterialDatePicker<S> extends DialogFragment {
    static final Object Z = "CONFIRM_BUTTON_TAG";

    /* renamed from: a0, reason: collision with root package name */
    static final Object f33557a0 = "CANCEL_BUTTON_TAG";

    /* renamed from: b0, reason: collision with root package name */
    static final Object f33558b0 = "TOGGLE_BUTTON_TAG";
    private final LinkedHashSet<f<? super S>> C = new LinkedHashSet<>();
    private final LinkedHashSet<View.OnClickListener> D = new LinkedHashSet<>();
    private final LinkedHashSet<DialogInterface.OnCancelListener> E = new LinkedHashSet<>();
    private final LinkedHashSet<DialogInterface.OnDismissListener> F = new LinkedHashSet<>();

    @StyleRes
    private int G;

    @Nullable
    private DateSelector<S> H;
    private PickerFragment<S> I;

    @Nullable
    private CalendarConstraints J;
    private MaterialCalendar<S> K;

    @StringRes
    private int L;
    private CharSequence M;
    private boolean N;
    private int P;

    @StringRes
    private int Q;
    private CharSequence R;

    @StringRes
    private int S;
    private CharSequence T;
    private TextView U;
    private CheckableImageButton V;

    @Nullable
    private MaterialShapeDrawable W;
    private Button X;
    private boolean Y;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public @interface InputMode {
    }

    /* loaded from: classes2.dex */
    class a implements View.OnClickListener {
        a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Iterator it = MaterialDatePicker.this.C.iterator();
            while (it.hasNext()) {
                ((f) it.next()).a(MaterialDatePicker.this.Bh());
            }
            MaterialDatePicker.this.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes2.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Iterator it = MaterialDatePicker.this.D.iterator();
            while (it.hasNext()) {
                ((View.OnClickListener) it.next()).onClick(view);
            }
            MaterialDatePicker.this.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements OnApplyWindowInsetsListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f33561d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f33562e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f33563f;

        c(int i3, View view, int i16) {
            this.f33561d = i3;
            this.f33562e = view;
            this.f33563f = i16;
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            int i3 = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars()).top;
            if (this.f33561d >= 0) {
                this.f33562e.getLayoutParams().height = this.f33561d + i3;
                View view2 = this.f33562e;
                view2.setLayoutParams(view2.getLayoutParams());
            }
            View view3 = this.f33562e;
            view3.setPadding(view3.getPaddingLeft(), this.f33563f + i3, this.f33562e.getPaddingRight(), this.f33562e.getPaddingBottom());
            return windowInsetsCompat;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d extends i<S> {
        d() {
        }

        @Override // com.google.android.material.datepicker.i
        public void a() {
            MaterialDatePicker.this.X.setEnabled(false);
        }

        @Override // com.google.android.material.datepicker.i
        public void b(S s16) {
            MaterialDatePicker.this.Ih();
            MaterialDatePicker.this.X.setEnabled(MaterialDatePicker.this.zh().K());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            MaterialDatePicker.this.X.setEnabled(MaterialDatePicker.this.zh().K());
            MaterialDatePicker.this.V.toggle();
            MaterialDatePicker materialDatePicker = MaterialDatePicker.this;
            materialDatePicker.Jh(materialDatePicker.V);
            MaterialDatePicker.this.Hh();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private static int Ah(@NonNull Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.cse);
        int i3 = Month.j().f33571h;
        return (dimensionPixelOffset * 2) + (resources.getDimensionPixelSize(R.dimen.csk) * i3) + ((i3 - 1) * resources.getDimensionPixelOffset(R.dimen.csy));
    }

    private int Ch(Context context) {
        int i3 = this.G;
        if (i3 != 0) {
            return i3;
        }
        return zh().R(context);
    }

    private void Dh(Context context) {
        boolean z16;
        this.V.setTag(f33558b0);
        this.V.setImageDrawable(xh(context));
        CheckableImageButton checkableImageButton = this.V;
        if (this.P != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        checkableImageButton.setChecked(z16);
        ViewCompat.setAccessibilityDelegate(this.V, null);
        Jh(this.V);
        this.V.setOnClickListener(new e());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean Eh(@NonNull Context context) {
        return Gh(context, android.R.attr.windowFullscreen);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean Fh(@NonNull Context context) {
        return Gh(context, R.attr.ayo);
    }

    static boolean Gh(@NonNull Context context, int i3) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(g1.b.d(context, R.attr.auw, MaterialCalendar.class.getCanonicalName()), new int[]{i3});
        boolean z16 = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hh() {
        PickerFragment<S> pickerFragment;
        int Ch = Ch(requireContext());
        this.K = MaterialCalendar.Hh(zh(), Ch, this.J);
        if (this.V.isChecked()) {
            pickerFragment = MaterialTextInputPicker.rh(zh(), Ch, this.J);
        } else {
            pickerFragment = this.K;
        }
        this.I = pickerFragment;
        Ih();
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.f166339zh2, this.I);
        beginTransaction.commitNow();
        this.I.ph(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ih() {
        String headerText = getHeaderText();
        this.U.setContentDescription(String.format(getString(R.string.f168522fv), headerText));
        this.U.setText(headerText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jh(@NonNull CheckableImageButton checkableImageButton) {
        String string;
        if (this.V.isChecked()) {
            string = checkableImageButton.getContext().getString(R.string.f168772gj);
        } else {
            string = checkableImageButton.getContext().getString(R.string.f168792gl);
        }
        this.V.setContentDescription(string);
    }

    @NonNull
    private static Drawable xh(Context context) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_checked}, AppCompatResources.getDrawable(context, R.drawable.jw8));
        stateListDrawable.addState(new int[0], AppCompatResources.getDrawable(context, R.drawable.jw_));
        return stateListDrawable;
    }

    private void yh(Window window) {
        if (this.Y) {
            return;
        }
        View findViewById = requireView().findViewById(R.id.vgw);
        com.google.android.material.internal.e.a(window, true, ViewUtils.d(findViewById), null);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById, new c(findViewById.getLayoutParams().height, findViewById, findViewById.getPaddingTop()));
        this.Y = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DateSelector<S> zh() {
        if (this.H == null) {
            this.H = (DateSelector) getArguments().getParcelable("DATE_SELECTOR_KEY");
        }
        return this.H;
    }

    @Nullable
    public final S Bh() {
        return zh().X();
    }

    public String getHeaderText() {
        return zh().h(getContext());
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(@NonNull DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnCancelListener> it = this.E.iterator();
        while (it.hasNext()) {
            it.next().onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.G = bundle.getInt("OVERRIDE_THEME_RES_ID");
        this.H = (DateSelector) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.J = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.L = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.M = bundle.getCharSequence("TITLE_TEXT_KEY");
        this.P = bundle.getInt("INPUT_MODE_KEY");
        this.Q = bundle.getInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY");
        this.R = bundle.getCharSequence("POSITIVE_BUTTON_TEXT_KEY");
        this.S = bundle.getInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY");
        this.T = bundle.getCharSequence("NEGATIVE_BUTTON_TEXT_KEY");
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public final Dialog onCreateDialog(@Nullable Bundle bundle) {
        ReportDialog reportDialog = new ReportDialog(requireContext(), Ch(requireContext()));
        Context context = reportDialog.getContext();
        this.N = Eh(context);
        int d16 = g1.b.d(context, R.attr.a8g, MaterialDatePicker.class.getCanonicalName());
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(context, null, R.attr.auw, R.style.arc);
        this.W = materialShapeDrawable;
        materialShapeDrawable.N(context);
        this.W.Y(ColorStateList.valueOf(d16));
        this.W.X(ViewCompat.getElevation(reportDialog.getWindow().getDecorView()));
        return reportDialog;
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public final View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int i3;
        if (this.N) {
            i3 = R.layout.flv;
        } else {
            i3 = R.layout.flu;
        }
        View inflate = layoutInflater.inflate(i3, viewGroup);
        Context context = inflate.getContext();
        if (this.N) {
            inflate.findViewById(R.id.f166339zh2).setLayoutParams(new LinearLayout.LayoutParams(Ah(context), -2));
        } else {
            inflate.findViewById(R.id.f166340zh3).setLayoutParams(new LinearLayout.LayoutParams(Ah(context), -1));
        }
        TextView textView = (TextView) inflate.findViewById(R.id.zhd);
        this.U = textView;
        ViewCompat.setAccessibilityLiveRegion(textView, 1);
        this.V = (CheckableImageButton) inflate.findViewById(R.id.zhf);
        TextView textView2 = (TextView) inflate.findViewById(R.id.zhj);
        CharSequence charSequence = this.M;
        if (charSequence != null) {
            textView2.setText(charSequence);
        } else {
            textView2.setText(this.L);
        }
        Dh(context);
        this.X = (Button) inflate.findViewById(R.id.u49);
        if (zh().K()) {
            this.X.setEnabled(true);
        } else {
            this.X.setEnabled(false);
        }
        this.X.setTag(Z);
        CharSequence charSequence2 = this.R;
        if (charSequence2 != null) {
            this.X.setText(charSequence2);
        } else {
            int i16 = this.Q;
            if (i16 != 0) {
                this.X.setText(i16);
            }
        }
        this.X.setOnClickListener(new a());
        Button button = (Button) inflate.findViewById(R.id.tlh);
        button.setTag(f33557a0);
        CharSequence charSequence3 = this.T;
        if (charSequence3 != null) {
            button.setText(charSequence3);
        } else {
            int i17 = this.S;
            if (i17 != 0) {
                button.setText(i17);
            }
        }
        button.setOnClickListener(new b());
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(@NonNull DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnDismissListener> it = this.F.iterator();
        while (it.hasNext()) {
            it.next().onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.G);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.H);
        CalendarConstraints.b bVar = new CalendarConstraints.b(this.J);
        if (this.K.Ch() != null) {
            bVar.b(this.K.Ch().f33573m);
        }
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", bVar.a());
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.L);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.M);
        bundle.putInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY", this.Q);
        bundle.putCharSequence("POSITIVE_BUTTON_TEXT_KEY", this.R);
        bundle.putInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY", this.S);
        bundle.putCharSequence("NEGATIVE_BUTTON_TEXT_KEY", this.T);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Window window = requireDialog().getWindow();
        if (this.N) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.W);
            yh(window);
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.csm);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.W, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new a1.a(requireDialog(), rect));
        }
        Hh();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        this.I.qh();
        super.onStop();
    }
}
