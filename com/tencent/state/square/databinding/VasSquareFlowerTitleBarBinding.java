package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.state.view.SquareImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareFlowerTitleBarBinding implements ViewBinding {
    public final SquareImageView flowerHelper;
    public final SquareImageView flowerRecords;
    public final TextView flowerTitle;
    public final FrameLayout helperArrow;
    public final RelativeLayout helperContainer;
    public final TextView helperTitle;
    public final TableLayout medalsTable;
    private final View rootView;

    VasSquareFlowerTitleBarBinding(View view, SquareImageView squareImageView, SquareImageView squareImageView2, TextView textView, FrameLayout frameLayout, RelativeLayout relativeLayout, TextView textView2, TableLayout tableLayout) {
        this.rootView = view;
        this.flowerHelper = squareImageView;
        this.flowerRecords = squareImageView2;
        this.flowerTitle = textView;
        this.helperArrow = frameLayout;
        this.helperContainer = relativeLayout;
        this.helperTitle = textView2;
        this.medalsTable = tableLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static VasSquareFlowerTitleBarBinding bind(View view) {
        int i3 = R.id.puz;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.puz);
        if (squareImageView != null) {
            i3 = R.id.f163388pv2;
            SquareImageView squareImageView2 = (SquareImageView) view.findViewById(R.id.f163388pv2);
            if (squareImageView2 != null) {
                i3 = R.id.f163389pv3;
                TextView textView = (TextView) view.findViewById(R.id.f163389pv3);
                if (textView != null) {
                    i3 = R.id.pz8;
                    FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.pz8);
                    if (frameLayout != null) {
                        i3 = R.id.pz9;
                        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.pz9);
                        if (relativeLayout != null) {
                            i3 = R.id.pz_;
                            TextView textView2 = (TextView) view.findViewById(R.id.pz_);
                            if (textView2 != null) {
                                i3 = R.id.q8h;
                                TableLayout tableLayout = (TableLayout) view.findViewById(R.id.q8h);
                                if (tableLayout != null) {
                                    return new VasSquareFlowerTitleBarBinding(view, squareImageView, squareImageView2, textView, frameLayout, relativeLayout, textView2, tableLayout);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static VasSquareFlowerTitleBarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.d4g, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
