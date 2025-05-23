package nr2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class ay implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f420950a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final Button f420951b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final RecyclerView f420952c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final Button f420953d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final Button f420954e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f420955f;

    ay(@NonNull ConstraintLayout constraintLayout, @NonNull Button button, @NonNull RecyclerView recyclerView, @NonNull Button button2, @NonNull Button button3, @NonNull TextView textView) {
        this.f420950a = constraintLayout;
        this.f420951b = button;
        this.f420952c = recyclerView;
        this.f420953d = button2;
        this.f420954e = button3;
        this.f420955f = textView;
    }

    @NonNull
    public static ay e(@NonNull View view) {
        int i3 = R.id.yrm;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.yrm);
        if (button != null) {
            i3 = R.id.i4l;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.i4l);
            if (recyclerView != null) {
                i3 = R.id.f83014if;
                Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.f83014if);
                if (button2 != null) {
                    i3 = R.id.f85714pp;
                    Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.f85714pp);
                    if (button3 != null) {
                        i3 = R.id.jfq;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.jfq);
                        if (textView != null) {
                            return new ay((ConstraintLayout) view, button, recyclerView, button2, button3, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static ay g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.hx_, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f420950a;
    }
}
