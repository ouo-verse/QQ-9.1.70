package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.state.view.SquareImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareLibraryTitleContainerBinding implements ViewBinding {
    public final SquareImageView back;
    public final FrameLayout btnMsgBox;
    public final RelativeLayout calendar;
    public final SquareImageView calendarRedDot;
    public final SquareImageView endFocus;
    public final SquareImageView iconCalendar;
    private final View rootView;
    public final TextView title;

    VasSquareLibraryTitleContainerBinding(View view, SquareImageView squareImageView, FrameLayout frameLayout, RelativeLayout relativeLayout, SquareImageView squareImageView2, SquareImageView squareImageView3, SquareImageView squareImageView4, TextView textView) {
        this.rootView = view;
        this.back = squareImageView;
        this.btnMsgBox = frameLayout;
        this.calendar = relativeLayout;
        this.calendarRedDot = squareImageView2;
        this.endFocus = squareImageView3;
        this.iconCalendar = squareImageView4;
        this.title = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static VasSquareLibraryTitleContainerBinding bind(View view) {
        int i3 = R.id.pcx;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.pcx);
        if (squareImageView != null) {
            i3 = R.id.pg9;
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.pg9);
            if (frameLayout != null) {
                i3 = R.id.phu;
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.phu);
                if (relativeLayout != null) {
                    i3 = R.id.phy;
                    SquareImageView squareImageView2 = (SquareImageView) view.findViewById(R.id.phy);
                    if (squareImageView2 != null) {
                        i3 = R.id.pry;
                        SquareImageView squareImageView3 = (SquareImageView) view.findViewById(R.id.pry);
                        if (squareImageView3 != null) {
                            i3 = R.id.q0j;
                            SquareImageView squareImageView4 = (SquareImageView) view.findViewById(R.id.q0j);
                            if (squareImageView4 != null) {
                                i3 = R.id.qr6;
                                TextView textView = (TextView) view.findViewById(R.id.qr6);
                                if (textView != null) {
                                    return new VasSquareLibraryTitleContainerBinding(view, squareImageView, frameLayout, relativeLayout, squareImageView2, squareImageView3, squareImageView4, textView);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static VasSquareLibraryTitleContainerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.f167414d63, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
