package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.state.view.CircleBoarderImageView;
import com.tencent.state.view.SquareImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareLibraryBubbleBinding implements ViewBinding {
    public final LinearLayout deskGroupBubble;
    public final TextView groupFocusTime;
    public final TextView groupTitle;
    public final VasSquareLibrarySingleBubbleBinding leftBubble;
    public final TextView likeReddot;
    public final VasSquareLibrarySingleBubbleBinding rightBubble;
    private final View rootView;
    public final LinearLayout singleBubble;
    public final TextView singleFocusTime;
    public final LinearLayout singleLikeButton;
    public final SquareImageView singleLikeIcon;
    public final TextView singleLikeNum;
    public final FrameLayout singleLikeView;
    public final TextView singleTextContent;
    public final TextView singleTitle;
    public final CircleBoarderImageView singleUserIcon;
    public final LinearLayout singleUserInfo;
    public final TextView singleUserName;

    VasSquareLibraryBubbleBinding(View view, LinearLayout linearLayout, TextView textView, TextView textView2, VasSquareLibrarySingleBubbleBinding vasSquareLibrarySingleBubbleBinding, TextView textView3, VasSquareLibrarySingleBubbleBinding vasSquareLibrarySingleBubbleBinding2, LinearLayout linearLayout2, TextView textView4, LinearLayout linearLayout3, SquareImageView squareImageView, TextView textView5, FrameLayout frameLayout, TextView textView6, TextView textView7, CircleBoarderImageView circleBoarderImageView, LinearLayout linearLayout4, TextView textView8) {
        this.rootView = view;
        this.deskGroupBubble = linearLayout;
        this.groupFocusTime = textView;
        this.groupTitle = textView2;
        this.leftBubble = vasSquareLibrarySingleBubbleBinding;
        this.likeReddot = textView3;
        this.rightBubble = vasSquareLibrarySingleBubbleBinding2;
        this.singleBubble = linearLayout2;
        this.singleFocusTime = textView4;
        this.singleLikeButton = linearLayout3;
        this.singleLikeIcon = squareImageView;
        this.singleLikeNum = textView5;
        this.singleLikeView = frameLayout;
        this.singleTextContent = textView6;
        this.singleTitle = textView7;
        this.singleUserIcon = circleBoarderImageView;
        this.singleUserInfo = linearLayout4;
        this.singleUserName = textView8;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static VasSquareLibraryBubbleBinding bind(View view) {
        int i3 = R.id.poy;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.poy);
        if (linearLayout != null) {
            i3 = R.id.pxz;
            TextView textView = (TextView) view.findViewById(R.id.pxz);
            if (textView != null) {
                i3 = R.id.f163403py2;
                TextView textView2 = (TextView) view.findViewById(R.id.f163403py2);
                if (textView2 != null) {
                    i3 = R.id.q4s;
                    View findViewById = view.findViewById(R.id.q4s);
                    if (findViewById != null) {
                        VasSquareLibrarySingleBubbleBinding bind = VasSquareLibrarySingleBubbleBinding.bind(findViewById);
                        i3 = R.id.q5a;
                        TextView textView3 = (TextView) view.findViewById(R.id.q5a);
                        if (textView3 != null) {
                            i3 = R.id.qhv;
                            View findViewById2 = view.findViewById(R.id.qhv);
                            if (findViewById2 != null) {
                                VasSquareLibrarySingleBubbleBinding bind2 = VasSquareLibrarySingleBubbleBinding.bind(findViewById2);
                                i3 = R.id.f163528qm1;
                                LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.f163528qm1);
                                if (linearLayout2 != null) {
                                    i3 = R.id.f163529qm2;
                                    TextView textView4 = (TextView) view.findViewById(R.id.f163529qm2);
                                    if (textView4 != null) {
                                        i3 = R.id.f163530qm3;
                                        LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.f163530qm3);
                                        if (linearLayout3 != null) {
                                            i3 = R.id.f163531qm4;
                                            SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.f163531qm4);
                                            if (squareImageView != null) {
                                                i3 = R.id.qm5;
                                                TextView textView5 = (TextView) view.findViewById(R.id.qm5);
                                                if (textView5 != null) {
                                                    i3 = R.id.qm6;
                                                    FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.qm6);
                                                    if (frameLayout != null) {
                                                        i3 = R.id.qm_;
                                                        TextView textView6 = (TextView) view.findViewById(R.id.qm_);
                                                        if (textView6 != null) {
                                                            i3 = R.id.qma;
                                                            TextView textView7 = (TextView) view.findViewById(R.id.qma);
                                                            if (textView7 != null) {
                                                                i3 = R.id.qmb;
                                                                CircleBoarderImageView circleBoarderImageView = (CircleBoarderImageView) view.findViewById(R.id.qmb);
                                                                if (circleBoarderImageView != null) {
                                                                    i3 = R.id.qmc;
                                                                    LinearLayout linearLayout4 = (LinearLayout) view.findViewById(R.id.qmc);
                                                                    if (linearLayout4 != null) {
                                                                        i3 = R.id.qmd;
                                                                        TextView textView8 = (TextView) view.findViewById(R.id.qmd);
                                                                        if (textView8 != null) {
                                                                            return new VasSquareLibraryBubbleBinding(view, linearLayout, textView, textView2, bind, textView3, bind2, linearLayout2, textView4, linearLayout3, squareImageView, textView5, frameLayout, textView6, textView7, circleBoarderImageView, linearLayout4, textView8);
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

    public static VasSquareLibraryBubbleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.d5r, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
