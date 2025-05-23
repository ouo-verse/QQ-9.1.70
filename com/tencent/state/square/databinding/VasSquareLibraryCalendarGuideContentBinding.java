package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.state.view.SquareImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareLibraryCalendarGuideContentBinding implements ViewBinding {
    public final SquareImageView calendarGuideArrowImage;
    public final View calendarGuideFocusView;
    public final SquareImageView calendarGuideMotionImage;
    private final RelativeLayout rootView;

    VasSquareLibraryCalendarGuideContentBinding(RelativeLayout relativeLayout, SquareImageView squareImageView, View view, SquareImageView squareImageView2) {
        this.rootView = relativeLayout;
        this.calendarGuideArrowImage = squareImageView;
        this.calendarGuideFocusView = view;
        this.calendarGuideMotionImage = squareImageView2;
    }

    public static VasSquareLibraryCalendarGuideContentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareLibraryCalendarGuideContentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d5s, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareLibraryCalendarGuideContentBinding bind(View view) {
        int i3 = R.id.phv;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.phv);
        if (squareImageView != null) {
            i3 = R.id.phw;
            View findViewById = view.findViewById(R.id.phw);
            if (findViewById != null) {
                i3 = R.id.phx;
                SquareImageView squareImageView2 = (SquareImageView) view.findViewById(R.id.phx);
                if (squareImageView2 != null) {
                    return new VasSquareLibraryCalendarGuideContentBinding((RelativeLayout) view, squareImageView, findViewById, squareImageView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
