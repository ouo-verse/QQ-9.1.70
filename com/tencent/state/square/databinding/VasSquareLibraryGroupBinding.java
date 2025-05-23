package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.state.library.focus.view.FocusGroupView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareLibraryGroupBinding implements ViewBinding {
    public final FocusGroupView groupView;
    private final FrameLayout rootView;

    VasSquareLibraryGroupBinding(FrameLayout frameLayout, FocusGroupView focusGroupView) {
        this.rootView = frameLayout;
        this.groupView = focusGroupView;
    }

    public static VasSquareLibraryGroupBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareLibraryGroupBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d5v, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: getRoot */
    public FrameLayout getMContainer() {
        return this.rootView;
    }

    public static VasSquareLibraryGroupBinding bind(View view) {
        FocusGroupView focusGroupView = (FocusGroupView) view.findViewById(R.id.f163404py3);
        if (focusGroupView != null) {
            return new VasSquareLibraryGroupBinding((FrameLayout) view, focusGroupView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.f163404py3)));
    }
}
