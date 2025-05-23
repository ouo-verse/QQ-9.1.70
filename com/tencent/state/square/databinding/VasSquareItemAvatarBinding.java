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
import com.tencent.state.square.flower.FlowerLayoutView;
import com.tencent.state.view.AvatarOnlineStatusSimpleBubble;
import com.tencent.state.view.BubbleStickersBanner;
import com.tencent.state.view.ComposedAvatarView;
import com.tencent.state.view.SquareImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareItemAvatarBinding implements ViewBinding {
    public final RelativeLayout avatarContainer;
    public final TextView avatarError;
    public final LinearLayout avatarLabelContainer;
    public final FrameLayout avatarLocation;
    public final LinearLayout avatarMessage;
    public final SquareImageView avatarMessageBottom;
    public final RelativeLayout avatarMessageContainer;
    public final VasSquareItemAvatarMessagePreviewBinding avatarMessagePreview1;
    public final VasSquareItemAvatarMessagePreviewBinding avatarMessagePreview2;
    public final FrameLayout avatarMessagePreviewContainer;
    public final LinearLayout avatarMessageTop;
    public final TextView avatarMessageUnreadCount;
    public final RelativeLayout avatarPttMessage;
    public final SquareImageView avatarPttMessageIcon;
    public final FrameLayout avatarPublishStatusBubble;
    public final FrameLayout avatarTopContentContainer;
    public final FrameLayout bornPag;
    public final ComposedAvatarView composedAvatar;
    public final SquareImageView flIcon;
    public final TextView flText;
    public final LinearLayout flagsContainer;
    public final LinearLayout floatFlagsContainer;
    public final TextView flowerCount;
    public final LinearLayout flowerLabel;
    public final FlowerLayoutView flowerView;
    public final LinearLayout footLabel;
    public final SquareImageView footLabelIcon;
    public final TextView footLabelText;
    public final SquareImageView iconNewStatus;
    public final FrameLayout masterNoviceGuideAnim;
    public final FrameLayout ringPag;
    private final FrameLayout rootView;
    public final AvatarOnlineStatusSimpleBubble squareAvatarBubble;
    public final LinearLayout squareAvatarBubbleTop;
    public final VasSquareQzoneFeedBubbleBinding squareAvatarFeedsBubble;
    public final FrameLayout squareAvatarHeartContainer;
    public final BubbleStickersBanner stickersBanner;

    VasSquareItemAvatarBinding(FrameLayout frameLayout, RelativeLayout relativeLayout, TextView textView, LinearLayout linearLayout, FrameLayout frameLayout2, LinearLayout linearLayout2, SquareImageView squareImageView, RelativeLayout relativeLayout2, VasSquareItemAvatarMessagePreviewBinding vasSquareItemAvatarMessagePreviewBinding, VasSquareItemAvatarMessagePreviewBinding vasSquareItemAvatarMessagePreviewBinding2, FrameLayout frameLayout3, LinearLayout linearLayout3, TextView textView2, RelativeLayout relativeLayout3, SquareImageView squareImageView2, FrameLayout frameLayout4, FrameLayout frameLayout5, FrameLayout frameLayout6, ComposedAvatarView composedAvatarView, SquareImageView squareImageView3, TextView textView3, LinearLayout linearLayout4, LinearLayout linearLayout5, TextView textView4, LinearLayout linearLayout6, FlowerLayoutView flowerLayoutView, LinearLayout linearLayout7, SquareImageView squareImageView4, TextView textView5, SquareImageView squareImageView5, FrameLayout frameLayout7, FrameLayout frameLayout8, AvatarOnlineStatusSimpleBubble avatarOnlineStatusSimpleBubble, LinearLayout linearLayout8, VasSquareQzoneFeedBubbleBinding vasSquareQzoneFeedBubbleBinding, FrameLayout frameLayout9, BubbleStickersBanner bubbleStickersBanner) {
        this.rootView = frameLayout;
        this.avatarContainer = relativeLayout;
        this.avatarError = textView;
        this.avatarLabelContainer = linearLayout;
        this.avatarLocation = frameLayout2;
        this.avatarMessage = linearLayout2;
        this.avatarMessageBottom = squareImageView;
        this.avatarMessageContainer = relativeLayout2;
        this.avatarMessagePreview1 = vasSquareItemAvatarMessagePreviewBinding;
        this.avatarMessagePreview2 = vasSquareItemAvatarMessagePreviewBinding2;
        this.avatarMessagePreviewContainer = frameLayout3;
        this.avatarMessageTop = linearLayout3;
        this.avatarMessageUnreadCount = textView2;
        this.avatarPttMessage = relativeLayout3;
        this.avatarPttMessageIcon = squareImageView2;
        this.avatarPublishStatusBubble = frameLayout4;
        this.avatarTopContentContainer = frameLayout5;
        this.bornPag = frameLayout6;
        this.composedAvatar = composedAvatarView;
        this.flIcon = squareImageView3;
        this.flText = textView3;
        this.flagsContainer = linearLayout4;
        this.floatFlagsContainer = linearLayout5;
        this.flowerCount = textView4;
        this.flowerLabel = linearLayout6;
        this.flowerView = flowerLayoutView;
        this.footLabel = linearLayout7;
        this.footLabelIcon = squareImageView4;
        this.footLabelText = textView5;
        this.iconNewStatus = squareImageView5;
        this.masterNoviceGuideAnim = frameLayout7;
        this.ringPag = frameLayout8;
        this.squareAvatarBubble = avatarOnlineStatusSimpleBubble;
        this.squareAvatarBubbleTop = linearLayout8;
        this.squareAvatarFeedsBubble = vasSquareQzoneFeedBubbleBinding;
        this.squareAvatarHeartContainer = frameLayout9;
        this.stickersBanner = bubbleStickersBanner;
    }

    public static VasSquareItemAvatarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareItemAvatarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d56, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareItemAvatarBinding bind(View view) {
        int i3 = R.id.pbu;
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.pbu);
        if (relativeLayout != null) {
            i3 = R.id.pbw;
            TextView textView = (TextView) view.findViewById(R.id.pbw);
            if (textView != null) {
                i3 = R.id.f163292pc1;
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.f163292pc1);
                if (linearLayout != null) {
                    i3 = R.id.f163294pc3;
                    FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.f163294pc3);
                    if (frameLayout != null) {
                        i3 = R.id.pc6;
                        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.pc6);
                        if (linearLayout2 != null) {
                            i3 = R.id.pc7;
                            SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.pc7);
                            if (squareImageView != null) {
                                i3 = R.id.pc8;
                                RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.pc8);
                                if (relativeLayout2 != null) {
                                    i3 = R.id.pc9;
                                    View findViewById = view.findViewById(R.id.pc9);
                                    if (findViewById != null) {
                                        VasSquareItemAvatarMessagePreviewBinding bind = VasSquareItemAvatarMessagePreviewBinding.bind(findViewById);
                                        i3 = R.id.pc_;
                                        View findViewById2 = view.findViewById(R.id.pc_);
                                        if (findViewById2 != null) {
                                            VasSquareItemAvatarMessagePreviewBinding bind2 = VasSquareItemAvatarMessagePreviewBinding.bind(findViewById2);
                                            i3 = R.id.pca;
                                            FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.pca);
                                            if (frameLayout2 != null) {
                                                i3 = R.id.pcd;
                                                LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.pcd);
                                                if (linearLayout3 != null) {
                                                    i3 = R.id.pce;
                                                    TextView textView2 = (TextView) view.findViewById(R.id.pce);
                                                    if (textView2 != null) {
                                                        i3 = R.id.pcj;
                                                        RelativeLayout relativeLayout3 = (RelativeLayout) view.findViewById(R.id.pcj);
                                                        if (relativeLayout3 != null) {
                                                            i3 = R.id.pck;
                                                            SquareImageView squareImageView2 = (SquareImageView) view.findViewById(R.id.pck);
                                                            if (squareImageView2 != null) {
                                                                i3 = R.id.pcl;
                                                                FrameLayout frameLayout3 = (FrameLayout) view.findViewById(R.id.pcl);
                                                                if (frameLayout3 != null) {
                                                                    i3 = R.id.pcr;
                                                                    FrameLayout frameLayout4 = (FrameLayout) view.findViewById(R.id.pcr);
                                                                    if (frameLayout4 != null) {
                                                                        i3 = R.id.pef;
                                                                        FrameLayout frameLayout5 = (FrameLayout) view.findViewById(R.id.pef);
                                                                        if (frameLayout5 != null) {
                                                                            i3 = R.id.plj;
                                                                            ComposedAvatarView composedAvatarView = (ComposedAvatarView) view.findViewById(R.id.plj);
                                                                            if (composedAvatarView != null) {
                                                                                i3 = R.id.pug;
                                                                                SquareImageView squareImageView3 = (SquareImageView) view.findViewById(R.id.pug);
                                                                                if (squareImageView3 != null) {
                                                                                    i3 = R.id.puh;
                                                                                    TextView textView3 = (TextView) view.findViewById(R.id.puh);
                                                                                    if (textView3 != null) {
                                                                                        i3 = R.id.pui;
                                                                                        LinearLayout linearLayout4 = (LinearLayout) view.findViewById(R.id.pui);
                                                                                        if (linearLayout4 != null) {
                                                                                            i3 = R.id.pul;
                                                                                            LinearLayout linearLayout5 = (LinearLayout) view.findViewById(R.id.pul);
                                                                                            if (linearLayout5 != null) {
                                                                                                i3 = R.id.puw;
                                                                                                TextView textView4 = (TextView) view.findViewById(R.id.puw);
                                                                                                if (textView4 != null) {
                                                                                                    i3 = R.id.f163386pv0;
                                                                                                    LinearLayout linearLayout6 = (LinearLayout) view.findViewById(R.id.f163386pv0);
                                                                                                    if (linearLayout6 != null) {
                                                                                                        i3 = R.id.f163390pv4;
                                                                                                        FlowerLayoutView flowerLayoutView = (FlowerLayoutView) view.findViewById(R.id.f163390pv4);
                                                                                                        if (flowerLayoutView != null) {
                                                                                                            i3 = R.id.pvh;
                                                                                                            LinearLayout linearLayout7 = (LinearLayout) view.findViewById(R.id.pvh);
                                                                                                            if (linearLayout7 != null) {
                                                                                                                i3 = R.id.pvi;
                                                                                                                SquareImageView squareImageView4 = (SquareImageView) view.findViewById(R.id.pvi);
                                                                                                                if (squareImageView4 != null) {
                                                                                                                    i3 = R.id.pvj;
                                                                                                                    TextView textView5 = (TextView) view.findViewById(R.id.pvj);
                                                                                                                    if (textView5 != null) {
                                                                                                                        i3 = R.id.q0t;
                                                                                                                        SquareImageView squareImageView5 = (SquareImageView) view.findViewById(R.id.q0t);
                                                                                                                        if (squareImageView5 != null) {
                                                                                                                            i3 = R.id.q7z;
                                                                                                                            FrameLayout frameLayout6 = (FrameLayout) view.findViewById(R.id.q7z);
                                                                                                                            if (frameLayout6 != null) {
                                                                                                                                i3 = R.id.qhz;
                                                                                                                                FrameLayout frameLayout7 = (FrameLayout) view.findViewById(R.id.qhz);
                                                                                                                                if (frameLayout7 != null) {
                                                                                                                                    i3 = R.id.qmx;
                                                                                                                                    AvatarOnlineStatusSimpleBubble avatarOnlineStatusSimpleBubble = (AvatarOnlineStatusSimpleBubble) view.findViewById(R.id.qmx);
                                                                                                                                    if (avatarOnlineStatusSimpleBubble != null) {
                                                                                                                                        i3 = R.id.qmy;
                                                                                                                                        LinearLayout linearLayout8 = (LinearLayout) view.findViewById(R.id.qmy);
                                                                                                                                        if (linearLayout8 != null) {
                                                                                                                                            i3 = R.id.qmz;
                                                                                                                                            View findViewById3 = view.findViewById(R.id.qmz);
                                                                                                                                            if (findViewById3 != null) {
                                                                                                                                                VasSquareQzoneFeedBubbleBinding bind3 = VasSquareQzoneFeedBubbleBinding.bind(findViewById3);
                                                                                                                                                i3 = R.id.f163532qn0;
                                                                                                                                                FrameLayout frameLayout8 = (FrameLayout) view.findViewById(R.id.f163532qn0);
                                                                                                                                                if (frameLayout8 != null) {
                                                                                                                                                    i3 = R.id.qnn;
                                                                                                                                                    BubbleStickersBanner bubbleStickersBanner = (BubbleStickersBanner) view.findViewById(R.id.qnn);
                                                                                                                                                    if (bubbleStickersBanner != null) {
                                                                                                                                                        return new VasSquareItemAvatarBinding((FrameLayout) view, relativeLayout, textView, linearLayout, frameLayout, linearLayout2, squareImageView, relativeLayout2, bind, bind2, frameLayout2, linearLayout3, textView2, relativeLayout3, squareImageView2, frameLayout3, frameLayout4, frameLayout5, composedAvatarView, squareImageView3, textView3, linearLayout4, linearLayout5, textView4, linearLayout6, flowerLayoutView, linearLayout7, squareImageView4, textView5, squareImageView5, frameLayout6, frameLayout7, avatarOnlineStatusSimpleBubble, linearLayout8, bind3, frameLayout8, bubbleStickersBanner);
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
}
