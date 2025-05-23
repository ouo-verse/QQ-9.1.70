package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.state.square.location.SquareAvatarMotionLockBar;
import com.tencent.state.view.StatusPanelTitleListView;

/* loaded from: classes38.dex */
public final class VasSquareCommonItemPanelBinding implements ViewBinding {
    public final CardView activityPanel;
    public final TextView activityTime;
    public final LinearLayout activityTimeContainer;
    public final SquareAvatarMotionLockBar motionLockBar;
    public final ViewPager onlineStatusViewpager;
    public final LinearLayout panelLoadFail;
    public final LinearLayout panelRoot;
    private final View rootView;
    public final StatusPanelTitleListView titleView;

    VasSquareCommonItemPanelBinding(View view, CardView cardView, TextView textView, LinearLayout linearLayout, SquareAvatarMotionLockBar squareAvatarMotionLockBar, ViewPager viewPager, LinearLayout linearLayout2, LinearLayout linearLayout3, StatusPanelTitleListView statusPanelTitleListView) {
        this.rootView = view;
        this.activityPanel = cardView;
        this.activityTime = textView;
        this.activityTimeContainer = linearLayout;
        this.motionLockBar = squareAvatarMotionLockBar;
        this.onlineStatusViewpager = viewPager;
        this.panelLoadFail = linearLayout2;
        this.panelRoot = linearLayout3;
        this.titleView = statusPanelTitleListView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static VasSquareCommonItemPanelBinding bind(View view) {
        int i3 = R.id.p_2;
        CardView cardView = (CardView) view.findViewById(R.id.p_2);
        if (cardView != null) {
            i3 = R.id.p_3;
            TextView textView = (TextView) view.findViewById(R.id.p_3);
            if (textView != null) {
                i3 = R.id.p_4;
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.p_4);
                if (linearLayout != null) {
                    i3 = R.id.q9k;
                    SquareAvatarMotionLockBar squareAvatarMotionLockBar = (SquareAvatarMotionLockBar) view.findViewById(R.id.q9k);
                    if (squareAvatarMotionLockBar != null) {
                        i3 = R.id.f163467qa0;
                        ViewPager viewPager = (ViewPager) view.findViewById(R.id.f163467qa0);
                        if (viewPager != null) {
                            i3 = R.id.qbm;
                            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.qbm);
                            if (linearLayout2 != null) {
                                i3 = R.id.qbn;
                                LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.qbn);
                                if (linearLayout3 != null) {
                                    i3 = R.id.qrx;
                                    StatusPanelTitleListView statusPanelTitleListView = (StatusPanelTitleListView) view.findViewById(R.id.qrx);
                                    if (statusPanelTitleListView != null) {
                                        return new VasSquareCommonItemPanelBinding(view, cardView, textView, linearLayout, squareAvatarMotionLockBar, viewPager, linearLayout2, linearLayout3, statusPanelTitleListView);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static VasSquareCommonItemPanelBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.d3v, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
