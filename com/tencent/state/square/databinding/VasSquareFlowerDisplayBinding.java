package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.state.square.avatar.SquareAvatarView;
import com.tencent.state.square.flower.FlowerLayoutView;
import com.tencent.state.view.SquareImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareFlowerDisplayBinding implements ViewBinding {
    public final SquareAvatarView avatar;
    public final SquareImageView background;
    public final RelativeLayout content;
    public final SquareImageView currentMedal;
    public final FlowerLayoutView flowerView;
    public final View medalProgressIndicator;
    public final View medalProgressIndicatorEmpty;
    public final TextView medalSubTitle;
    public final TextView medalTitle;
    public final SquareImageView nextMedal;
    private final RelativeLayout rootView;
    public final TextView tips2;
    public final TextView todayCount;
    public final TextView totalCount;

    VasSquareFlowerDisplayBinding(RelativeLayout relativeLayout, SquareAvatarView squareAvatarView, SquareImageView squareImageView, RelativeLayout relativeLayout2, SquareImageView squareImageView2, FlowerLayoutView flowerLayoutView, View view, View view2, TextView textView, TextView textView2, SquareImageView squareImageView3, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = relativeLayout;
        this.avatar = squareAvatarView;
        this.background = squareImageView;
        this.content = relativeLayout2;
        this.currentMedal = squareImageView2;
        this.flowerView = flowerLayoutView;
        this.medalProgressIndicator = view;
        this.medalProgressIndicatorEmpty = view2;
        this.medalSubTitle = textView;
        this.medalTitle = textView2;
        this.nextMedal = squareImageView3;
        this.tips2 = textView3;
        this.todayCount = textView4;
        this.totalCount = textView5;
    }

    public static VasSquareFlowerDisplayBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareFlowerDisplayBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d4d, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: getRoot */
    public RelativeLayout getMContainer() {
        return this.rootView;
    }

    public static VasSquareFlowerDisplayBinding bind(View view) {
        int i3 = R.id.pax;
        SquareAvatarView squareAvatarView = (SquareAvatarView) view.findViewById(R.id.pax);
        if (squareAvatarView != null) {
            i3 = R.id.pd8;
            SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.pd8);
            if (squareImageView != null) {
                i3 = R.id.f163344pm3;
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.f163344pm3);
                if (relativeLayout != null) {
                    i3 = R.id.pnk;
                    SquareImageView squareImageView2 = (SquareImageView) view.findViewById(R.id.pnk);
                    if (squareImageView2 != null) {
                        i3 = R.id.f163390pv4;
                        FlowerLayoutView flowerLayoutView = (FlowerLayoutView) view.findViewById(R.id.f163390pv4);
                        if (flowerLayoutView != null) {
                            i3 = R.id.q8d;
                            View findViewById = view.findViewById(R.id.q8d);
                            if (findViewById != null) {
                                i3 = R.id.q8e;
                                View findViewById2 = view.findViewById(R.id.q8e);
                                if (findViewById2 != null) {
                                    i3 = R.id.q8f;
                                    TextView textView = (TextView) view.findViewById(R.id.q8f);
                                    if (textView != null) {
                                        i3 = R.id.q8g;
                                        TextView textView2 = (TextView) view.findViewById(R.id.q8g);
                                        if (textView2 != null) {
                                            i3 = R.id.q_g;
                                            SquareImageView squareImageView3 = (SquareImageView) view.findViewById(R.id.q_g);
                                            if (squareImageView3 != null) {
                                                i3 = R.id.f163552qr0;
                                                TextView textView3 = (TextView) view.findViewById(R.id.f163552qr0);
                                                if (textView3 != null) {
                                                    i3 = R.id.f163561qs4;
                                                    TextView textView4 = (TextView) view.findViewById(R.id.f163561qs4);
                                                    if (textView4 != null) {
                                                        i3 = R.id.qsk;
                                                        TextView textView5 = (TextView) view.findViewById(R.id.qsk);
                                                        if (textView5 != null) {
                                                            return new VasSquareFlowerDisplayBinding((RelativeLayout) view, squareAvatarView, squareImageView, relativeLayout, squareImageView2, flowerLayoutView, findViewById, findViewById2, textView, textView2, squareImageView3, textView3, textView4, textView5);
                                                        }
                                                    }
                                                }
                                            }
                                        }
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
}
