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
import com.tencent.state.square.detail.DetailCommonView;
import com.tencent.state.view.AvatarOnlineStatusDetailBubble;
import com.tencent.state.view.SquareImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareDetailGuestViewBinding implements ViewBinding {
    public final AvatarOnlineStatusDetailBubble avatarBubble;
    public final RelativeLayout avatarLocationView;
    public final DetailCommonView commonView;
    public final FrameLayout customAddFriendContainer;
    public final SquareImageView customAddFriendIcon;
    public final TextView customAddFriendTips;
    public final FrameLayout customAddSquareContainer;
    public final SquareImageView customAddSquareIcon;
    public final TextView customAddSquareTips;
    public final LinearLayout customBottomContainer;
    public final LinearLayout customBottomSubContainer;
    public final LinearLayout customChatBubble;
    public final LinearLayout customChatBubbleContainer;
    public final LinearLayout customDoubleClickView;
    public final TextView customNewMessageRedPoint;
    public final TextView customNewMessageTips;
    public final FrameLayout customView;
    public final SquareImageView isClickIcon;
    public final VasSquareDatailMultiOperatorBinding operatorContainer;
    public final TextView paiYiPaiTips;
    private final View rootView;

    VasSquareDetailGuestViewBinding(View view, AvatarOnlineStatusDetailBubble avatarOnlineStatusDetailBubble, RelativeLayout relativeLayout, DetailCommonView detailCommonView, FrameLayout frameLayout, SquareImageView squareImageView, TextView textView, FrameLayout frameLayout2, SquareImageView squareImageView2, TextView textView2, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, TextView textView3, TextView textView4, FrameLayout frameLayout3, SquareImageView squareImageView3, VasSquareDatailMultiOperatorBinding vasSquareDatailMultiOperatorBinding, TextView textView5) {
        this.rootView = view;
        this.avatarBubble = avatarOnlineStatusDetailBubble;
        this.avatarLocationView = relativeLayout;
        this.commonView = detailCommonView;
        this.customAddFriendContainer = frameLayout;
        this.customAddFriendIcon = squareImageView;
        this.customAddFriendTips = textView;
        this.customAddSquareContainer = frameLayout2;
        this.customAddSquareIcon = squareImageView2;
        this.customAddSquareTips = textView2;
        this.customBottomContainer = linearLayout;
        this.customBottomSubContainer = linearLayout2;
        this.customChatBubble = linearLayout3;
        this.customChatBubbleContainer = linearLayout4;
        this.customDoubleClickView = linearLayout5;
        this.customNewMessageRedPoint = textView3;
        this.customNewMessageTips = textView4;
        this.customView = frameLayout3;
        this.isClickIcon = squareImageView3;
        this.operatorContainer = vasSquareDatailMultiOperatorBinding;
        this.paiYiPaiTips = textView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static VasSquareDetailGuestViewBinding bind(View view) {
        int i3 = R.id.pbm;
        AvatarOnlineStatusDetailBubble avatarOnlineStatusDetailBubble = (AvatarOnlineStatusDetailBubble) view.findViewById(R.id.pbm);
        if (avatarOnlineStatusDetailBubble != null) {
            i3 = R.id.f163295pc4;
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.f163295pc4);
            if (relativeLayout != null) {
                i3 = R.id.plf;
                DetailCommonView detailCommonView = (DetailCommonView) view.findViewById(R.id.plf);
                if (detailCommonView != null) {
                    i3 = R.id.pnm;
                    FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.pnm);
                    if (frameLayout != null) {
                        i3 = R.id.pnn;
                        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.pnn);
                        if (squareImageView != null) {
                            i3 = R.id.pno;
                            TextView textView = (TextView) view.findViewById(R.id.pno);
                            if (textView != null) {
                                i3 = R.id.pnp;
                                FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.pnp);
                                if (frameLayout2 != null) {
                                    i3 = R.id.pnq;
                                    SquareImageView squareImageView2 = (SquareImageView) view.findViewById(R.id.pnq);
                                    if (squareImageView2 != null) {
                                        i3 = R.id.pnr;
                                        TextView textView2 = (TextView) view.findViewById(R.id.pnr);
                                        if (textView2 != null) {
                                            i3 = R.id.pns;
                                            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.pns);
                                            if (linearLayout != null) {
                                                i3 = R.id.pnt;
                                                LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.pnt);
                                                if (linearLayout2 != null) {
                                                    i3 = R.id.pnw;
                                                    LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.pnw);
                                                    if (linearLayout3 != null) {
                                                        i3 = R.id.pnx;
                                                        LinearLayout linearLayout4 = (LinearLayout) view.findViewById(R.id.pnx);
                                                        if (linearLayout4 != null) {
                                                            i3 = R.id.f163353po2;
                                                            LinearLayout linearLayout5 = (LinearLayout) view.findViewById(R.id.f163353po2);
                                                            if (linearLayout5 != null) {
                                                                i3 = R.id.f163354po3;
                                                                TextView textView3 = (TextView) view.findViewById(R.id.f163354po3);
                                                                if (textView3 != null) {
                                                                    i3 = R.id.f163355po4;
                                                                    TextView textView4 = (TextView) view.findViewById(R.id.f163355po4);
                                                                    if (textView4 != null) {
                                                                        i3 = R.id.poa;
                                                                        FrameLayout frameLayout3 = (FrameLayout) view.findViewById(R.id.poa);
                                                                        if (frameLayout3 != null) {
                                                                            i3 = R.id.q2s;
                                                                            SquareImageView squareImageView3 = (SquareImageView) view.findViewById(R.id.q2s);
                                                                            if (squareImageView3 != null) {
                                                                                i3 = R.id.qa7;
                                                                                View findViewById = view.findViewById(R.id.qa7);
                                                                                if (findViewById != null) {
                                                                                    VasSquareDatailMultiOperatorBinding bind = VasSquareDatailMultiOperatorBinding.bind(findViewById);
                                                                                    i3 = R.id.qbe;
                                                                                    TextView textView5 = (TextView) view.findViewById(R.id.qbe);
                                                                                    if (textView5 != null) {
                                                                                        return new VasSquareDetailGuestViewBinding(view, avatarOnlineStatusDetailBubble, relativeLayout, detailCommonView, frameLayout, squareImageView, textView, frameLayout2, squareImageView2, textView2, linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5, textView3, textView4, frameLayout3, squareImageView3, bind, textView5);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static VasSquareDetailGuestViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.d3z, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
