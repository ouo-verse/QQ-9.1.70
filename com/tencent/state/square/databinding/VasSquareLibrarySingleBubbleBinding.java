package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.state.view.CircleBoarderImageView;
import com.tencent.state.view.SquareImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareLibrarySingleBubbleBinding implements ViewBinding {
    public final LinearLayout deskGroupSingleBubble;
    public final TextView focusTime;
    public final LinearLayout likeButton;
    public final SquareImageView likeIcon;
    public final TextView likeNum;
    public final TextView likeReddot;
    public final FrameLayout likeView;
    private final LinearLayout rootView;
    public final TextView tileContent;
    public final CircleBoarderImageView userIcon;
    public final LinearLayout userInfo;
    public final TextView userName;

    VasSquareLibrarySingleBubbleBinding(LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, LinearLayout linearLayout3, SquareImageView squareImageView, TextView textView2, TextView textView3, FrameLayout frameLayout, TextView textView4, CircleBoarderImageView circleBoarderImageView, LinearLayout linearLayout4, TextView textView5) {
        this.rootView = linearLayout;
        this.deskGroupSingleBubble = linearLayout2;
        this.focusTime = textView;
        this.likeButton = linearLayout3;
        this.likeIcon = squareImageView;
        this.likeNum = textView2;
        this.likeReddot = textView3;
        this.likeView = frameLayout;
        this.tileContent = textView4;
        this.userIcon = circleBoarderImageView;
        this.userInfo = linearLayout4;
        this.userName = textView5;
    }

    public static VasSquareLibrarySingleBubbleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareLibrarySingleBubbleBinding bind(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i3 = R.id.pv6;
        TextView textView = (TextView) view.findViewById(R.id.pv6);
        if (textView != null) {
            i3 = R.id.f163444q53;
            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.f163444q53);
            if (linearLayout2 != null) {
                i3 = R.id.q57;
                SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.q57);
                if (squareImageView != null) {
                    i3 = R.id.q5_;
                    TextView textView2 = (TextView) view.findViewById(R.id.q5_);
                    if (textView2 != null) {
                        i3 = R.id.q5a;
                        TextView textView3 = (TextView) view.findViewById(R.id.q5a);
                        if (textView3 != null) {
                            i3 = R.id.q5f;
                            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.q5f);
                            if (frameLayout != null) {
                                i3 = R.id.qqw;
                                TextView textView4 = (TextView) view.findViewById(R.id.qqw);
                                if (textView4 != null) {
                                    i3 = R.id.qw9;
                                    CircleBoarderImageView circleBoarderImageView = (CircleBoarderImageView) view.findViewById(R.id.qw9);
                                    if (circleBoarderImageView != null) {
                                        i3 = R.id.qw_;
                                        LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.qw_);
                                        if (linearLayout3 != null) {
                                            i3 = R.id.qwb;
                                            TextView textView5 = (TextView) view.findViewById(R.id.qwb);
                                            if (textView5 != null) {
                                                return new VasSquareLibrarySingleBubbleBinding((LinearLayout) view, linearLayout, textView, linearLayout2, squareImageView, textView2, textView3, frameLayout, textView4, circleBoarderImageView, linearLayout3, textView5);
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

    public static VasSquareLibrarySingleBubbleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d5y, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
