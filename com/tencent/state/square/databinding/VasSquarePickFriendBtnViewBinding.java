package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.state.view.CircleBoarderImageView;
import com.tencent.state.view.SquareImageView;

/* loaded from: classes38.dex */
public final class VasSquarePickFriendBtnViewBinding implements ViewBinding {
    public final CircleBoarderImageView image;
    public final RecyclerView list;
    public final RelativeLayout listContainer;
    public final LinearLayout pickBtn;
    private final RelativeLayout rootView;
    public final SquareImageView selectFriendArrow;
    public final SquareImageView selectImage;
    public final SquareImageView selectMoreFriend;
    public final TextView selectNickName;
    public final TextView selected;

    VasSquarePickFriendBtnViewBinding(RelativeLayout relativeLayout, CircleBoarderImageView circleBoarderImageView, RecyclerView recyclerView, RelativeLayout relativeLayout2, LinearLayout linearLayout, SquareImageView squareImageView, SquareImageView squareImageView2, SquareImageView squareImageView3, TextView textView, TextView textView2) {
        this.rootView = relativeLayout;
        this.image = circleBoarderImageView;
        this.list = recyclerView;
        this.listContainer = relativeLayout2;
        this.pickBtn = linearLayout;
        this.selectFriendArrow = squareImageView;
        this.selectImage = squareImageView2;
        this.selectMoreFriend = squareImageView3;
        this.selectNickName = textView;
        this.selected = textView2;
    }

    public static VasSquarePickFriendBtnViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquarePickFriendBtnViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d6l, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static VasSquarePickFriendBtnViewBinding bind(View view) {
        int i3 = R.id.q1_;
        CircleBoarderImageView circleBoarderImageView = (CircleBoarderImageView) view.findViewById(R.id.q1_);
        if (circleBoarderImageView != null) {
            i3 = R.id.q5l;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.q5l);
            if (recyclerView != null) {
                i3 = R.id.q5n;
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.q5n);
                if (relativeLayout != null) {
                    i3 = R.id.qce;
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.qce);
                    if (linearLayout != null) {
                        i3 = R.id.qju;
                        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.qju);
                        if (squareImageView != null) {
                            i3 = R.id.qjv;
                            SquareImageView squareImageView2 = (SquareImageView) view.findViewById(R.id.qjv);
                            if (squareImageView2 != null) {
                                i3 = R.id.qjy;
                                SquareImageView squareImageView3 = (SquareImageView) view.findViewById(R.id.qjy);
                                if (squareImageView3 != null) {
                                    i3 = R.id.qjz;
                                    TextView textView = (TextView) view.findViewById(R.id.qjz);
                                    if (textView != null) {
                                        i3 = R.id.f163519qk2;
                                        TextView textView2 = (TextView) view.findViewById(R.id.f163519qk2);
                                        if (textView2 != null) {
                                            return new VasSquarePickFriendBtnViewBinding((RelativeLayout) view, circleBoarderImageView, recyclerView, relativeLayout, linearLayout, squareImageView, squareImageView2, squareImageView3, textView, textView2);
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
