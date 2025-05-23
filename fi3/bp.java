package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.zplan.aio.panel.entrance.view.SpaceEntranceBackground;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class bp implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f399136a;

    /* renamed from: b, reason: collision with root package name */
    public final SpaceEntranceBackground f399137b;

    /* renamed from: c, reason: collision with root package name */
    public final View f399138c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f399139d;

    bp(ConstraintLayout constraintLayout, SpaceEntranceBackground spaceEntranceBackground, View view, TextView textView) {
        this.f399136a = constraintLayout;
        this.f399137b = spaceEntranceBackground;
        this.f399138c = view;
        this.f399139d = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f399136a;
    }

    public static bp g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static bp e(View view) {
        int i3 = R.id.f163638r70;
        SpaceEntranceBackground spaceEntranceBackground = (SpaceEntranceBackground) ViewBindings.findChildViewById(view, R.id.f163638r70);
        if (spaceEntranceBackground != null) {
            i3 = R.id.f163640r72;
            View findChildViewById = ViewBindings.findChildViewById(view, R.id.f163640r72);
            if (findChildViewById != null) {
                i3 = R.id.f163641r73;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f163641r73);
                if (textView != null) {
                    return new bp((ConstraintLayout) view, spaceEntranceBackground, findChildViewById, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static bp h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.ddp, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
