package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.state.square.flower.FlowerLayoutView;
import com.tencent.state.square.flower.FlowerMedalTagView;
import com.tencent.state.square.location.LocationView;
import com.tencent.state.view.CircleBoarderImageView;
import com.tencent.state.view.SquareImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareDetailCommonBinding implements ViewBinding {
    public final CircleBoarderImageView avatar;
    public final RelativeLayout avatarImage;
    public final FrameLayout avatarViewContent;
    public final FrameLayout back;
    public final FrameLayout flowerAnimationContainer;
    public final FlowerMedalTagView flowerMedalTag;
    public final FlowerLayoutView flowerView;
    public final LocationView locationInfo;
    public final TextView multiCountDown;
    public final FrameLayout multiParentView;
    public final TextView multiTitle;
    public final LinearLayout multiTitleContainer;
    public final TextView nick;
    public final CircleBoarderImageView partnerAvatar;
    public final LinearLayout partnerContainer;
    public final TextView partnerStatus;
    private final View rootView;
    public final SquareImageView setting;
    public final SquareImageView share;
    public final RelativeLayout titleContainer;

    VasSquareDetailCommonBinding(View view, CircleBoarderImageView circleBoarderImageView, RelativeLayout relativeLayout, FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, FlowerMedalTagView flowerMedalTagView, FlowerLayoutView flowerLayoutView, LocationView locationView, TextView textView, FrameLayout frameLayout4, TextView textView2, LinearLayout linearLayout, TextView textView3, CircleBoarderImageView circleBoarderImageView2, LinearLayout linearLayout2, TextView textView4, SquareImageView squareImageView, SquareImageView squareImageView2, RelativeLayout relativeLayout2) {
        this.rootView = view;
        this.avatar = circleBoarderImageView;
        this.avatarImage = relativeLayout;
        this.avatarViewContent = frameLayout;
        this.back = frameLayout2;
        this.flowerAnimationContainer = frameLayout3;
        this.flowerMedalTag = flowerMedalTagView;
        this.flowerView = flowerLayoutView;
        this.locationInfo = locationView;
        this.multiCountDown = textView;
        this.multiParentView = frameLayout4;
        this.multiTitle = textView2;
        this.multiTitleContainer = linearLayout;
        this.nick = textView3;
        this.partnerAvatar = circleBoarderImageView2;
        this.partnerContainer = linearLayout2;
        this.partnerStatus = textView4;
        this.setting = squareImageView;
        this.share = squareImageView2;
        this.titleContainer = relativeLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static VasSquareDetailCommonBinding bind(View view) {
        int i3 = R.id.pax;
        CircleBoarderImageView circleBoarderImageView = (CircleBoarderImageView) view.findViewById(R.id.pax);
        if (circleBoarderImageView != null) {
            i3 = R.id.pbz;
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.pbz);
            if (relativeLayout != null) {
                i3 = R.id.pct;
                FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.pct);
                if (frameLayout != null) {
                    i3 = R.id.pcx;
                    FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.pcx);
                    if (frameLayout2 != null) {
                        i3 = R.id.puv;
                        FrameLayout frameLayout3 = (FrameLayout) view.findViewById(R.id.puv);
                        if (frameLayout3 != null) {
                            i3 = R.id.f163387pv1;
                            FlowerMedalTagView flowerMedalTagView = (FlowerMedalTagView) view.findViewById(R.id.f163387pv1);
                            if (flowerMedalTagView != null) {
                                i3 = R.id.f163390pv4;
                                FlowerLayoutView flowerLayoutView = (FlowerLayoutView) view.findViewById(R.id.f163390pv4);
                                if (flowerLayoutView != null) {
                                    i3 = R.id.f163456q74;
                                    LocationView locationView = (LocationView) view.findViewById(R.id.f163456q74);
                                    if (locationView != null) {
                                        i3 = R.id.q9v;
                                        TextView textView = (TextView) view.findViewById(R.id.q9v);
                                        if (textView != null) {
                                            i3 = R.id.q9x;
                                            FrameLayout frameLayout4 = (FrameLayout) view.findViewById(R.id.q9x);
                                            if (frameLayout4 != null) {
                                                i3 = R.id.q9y;
                                                TextView textView2 = (TextView) view.findViewById(R.id.q9y);
                                                if (textView2 != null) {
                                                    i3 = R.id.q9z;
                                                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.q9z);
                                                    if (linearLayout != null) {
                                                        i3 = R.id.q_h;
                                                        TextView textView3 = (TextView) view.findViewById(R.id.q_h);
                                                        if (textView3 != null) {
                                                            i3 = R.id.f163477qc0;
                                                            CircleBoarderImageView circleBoarderImageView2 = (CircleBoarderImageView) view.findViewById(R.id.f163477qc0);
                                                            if (circleBoarderImageView2 != null) {
                                                                i3 = R.id.f163478qc1;
                                                                LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.f163478qc1);
                                                                if (linearLayout2 != null) {
                                                                    i3 = R.id.f163479qc2;
                                                                    TextView textView4 = (TextView) view.findViewById(R.id.f163479qc2);
                                                                    if (textView4 != null) {
                                                                        i3 = R.id.qkk;
                                                                        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.qkk);
                                                                        if (squareImageView != null) {
                                                                            i3 = R.id.qku;
                                                                            SquareImageView squareImageView2 = (SquareImageView) view.findViewById(R.id.qku);
                                                                            if (squareImageView2 != null) {
                                                                                i3 = R.id.qro;
                                                                                RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.qro);
                                                                                if (relativeLayout2 != null) {
                                                                                    return new VasSquareDetailCommonBinding(view, circleBoarderImageView, relativeLayout, frameLayout, frameLayout2, frameLayout3, flowerMedalTagView, flowerLayoutView, locationView, textView, frameLayout4, textView2, linearLayout, textView3, circleBoarderImageView2, linearLayout2, textView4, squareImageView, squareImageView2, relativeLayout2);
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
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static VasSquareDetailCommonBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.d3y, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
