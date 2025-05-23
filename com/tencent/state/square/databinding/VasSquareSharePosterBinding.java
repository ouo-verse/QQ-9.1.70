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
import com.tencent.state.view.AvatarOnlineStatusDetailBubble;
import com.tencent.state.view.BubbleStickersBanner;
import com.tencent.state.view.RoundImageView;
import com.tencent.state.view.SquareImageView;

/* loaded from: classes38.dex */
public final class VasSquareSharePosterBinding implements ViewBinding {
    public final SquareImageView avatar;
    public final AvatarOnlineStatusDetailBubble avatarBubble;
    public final FrameLayout avatarBubbleContainer;
    public final SquareImageView background;
    public final RelativeLayout container;
    public final TextView date;
    public final TextView guestNick;
    public final FrameLayout line;
    public final TextView name;
    public final TextView ownerNick;
    public final RoundImageView qrCode;
    private final View rootView;
    public final TextView status;
    public final BubbleStickersBanner stickersBanner;
    public final TextView subtitle;
    public final SquareImageView tag;

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    VasSquareSharePosterBinding(View view, SquareImageView squareImageView, AvatarOnlineStatusDetailBubble avatarOnlineStatusDetailBubble, FrameLayout frameLayout, SquareImageView squareImageView2, RelativeLayout relativeLayout, TextView textView, TextView textView2, FrameLayout frameLayout2, TextView textView3, TextView textView4, RoundImageView roundImageView, TextView textView5, BubbleStickersBanner bubbleStickersBanner, TextView textView6, SquareImageView squareImageView3) {
        this.rootView = view;
        this.avatar = squareImageView;
        this.avatarBubble = avatarOnlineStatusDetailBubble;
        this.avatarBubbleContainer = frameLayout;
        this.background = squareImageView2;
        this.container = relativeLayout;
        this.date = textView;
        this.guestNick = textView2;
        this.line = frameLayout2;
        this.name = textView3;
        this.ownerNick = textView4;
        this.qrCode = roundImageView;
        this.status = textView5;
        this.stickersBanner = bubbleStickersBanner;
        this.subtitle = textView6;
        this.tag = squareImageView3;
    }

    public static VasSquareSharePosterBinding bind(View view) {
        int i3 = R.id.pax;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.pax);
        if (squareImageView != null) {
            i3 = R.id.pbm;
            AvatarOnlineStatusDetailBubble avatarOnlineStatusDetailBubble = (AvatarOnlineStatusDetailBubble) view.findViewById(R.id.pbm);
            if (avatarOnlineStatusDetailBubble != null) {
                i3 = R.id.pbn;
                FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.pbn);
                if (frameLayout != null) {
                    i3 = R.id.pd8;
                    SquareImageView squareImageView2 = (SquareImageView) view.findViewById(R.id.pd8);
                    if (squareImageView2 != null) {
                        i3 = R.id.plw;
                        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.plw);
                        if (relativeLayout != null) {
                            i3 = R.id.pod;
                            TextView textView = (TextView) view.findViewById(R.id.pod);
                            if (textView != null) {
                                i3 = R.id.f163405py4;
                                TextView textView2 = (TextView) view.findViewById(R.id.f163405py4);
                                if (textView2 != null) {
                                    i3 = R.id.q5h;
                                    FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.q5h);
                                    if (frameLayout2 != null) {
                                        i3 = R.id.q_6;
                                        TextView textView3 = (TextView) view.findViewById(R.id.q_6);
                                        if (textView3 != null) {
                                            i3 = R.id.f163475qb3;
                                            TextView textView4 = (TextView) view.findViewById(R.id.f163475qb3);
                                            if (textView4 != null) {
                                                i3 = R.id.qf6;
                                                RoundImageView roundImageView = (RoundImageView) view.findViewById(R.id.qf6);
                                                if (roundImageView != null) {
                                                    i3 = R.id.qnf;
                                                    TextView textView5 = (TextView) view.findViewById(R.id.qnf);
                                                    if (textView5 != null) {
                                                        i3 = R.id.qnn;
                                                        BubbleStickersBanner bubbleStickersBanner = (BubbleStickersBanner) view.findViewById(R.id.qnn);
                                                        if (bubbleStickersBanner != null) {
                                                            i3 = R.id.qoc;
                                                            TextView textView6 = (TextView) view.findViewById(R.id.qoc);
                                                            if (textView6 != null) {
                                                                i3 = R.id.qpe;
                                                                SquareImageView squareImageView3 = (SquareImageView) view.findViewById(R.id.qpe);
                                                                if (squareImageView3 != null) {
                                                                    return new VasSquareSharePosterBinding(view, squareImageView, avatarOnlineStatusDetailBubble, frameLayout, squareImageView2, relativeLayout, textView, textView2, frameLayout2, textView3, textView4, roundImageView, textView5, bubbleStickersBanner, textView6, squareImageView3);
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

    public static VasSquareSharePosterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.d6s, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
