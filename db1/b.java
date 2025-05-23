package db1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.dataline.qqnt.widget.WaitTextView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes10.dex */
public final class b implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f393504a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final Button f393505b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ProgressBar f393506c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f393507d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f393508e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f393509f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final RecyclerView f393510g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final WaitTextView f393511h;

    b(@NonNull LinearLayout linearLayout, @NonNull Button button, @NonNull ProgressBar progressBar, @NonNull TextView textView, @NonNull TextView textView2, @NonNull RelativeLayout relativeLayout, @NonNull RecyclerView recyclerView, @NonNull WaitTextView waitTextView) {
        this.f393504a = linearLayout;
        this.f393505b = button;
        this.f393506c = progressBar;
        this.f393507d = textView;
        this.f393508e = textView2;
        this.f393509f = relativeLayout;
        this.f393510g = recyclerView;
        this.f393511h = waitTextView;
    }

    @NonNull
    public static b e(@NonNull View view) {
        int i3 = R.id.f165750dc0;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.f165750dc0);
        if (button != null) {
            i3 = R.id.dc7;
            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.dc7);
            if (progressBar != null) {
                i3 = R.id.dcc;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.dcc);
                if (textView != null) {
                    i3 = R.id.dcd;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.dcd);
                    if (textView2 != null) {
                        i3 = R.id.icw;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.icw);
                        if (relativeLayout != null) {
                            i3 = R.id.f791348y;
                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.f791348y);
                            if (recyclerView != null) {
                                i3 = R.id.k_3;
                                WaitTextView waitTextView = (WaitTextView) ViewBindings.findChildViewById(view, R.id.k_3);
                                if (waitTextView != null) {
                                    return new b((LinearLayout) view, button, progressBar, textView, textView2, relativeLayout, recyclerView, waitTextView);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static b g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static b h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.e5e, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f393504a;
    }
}
