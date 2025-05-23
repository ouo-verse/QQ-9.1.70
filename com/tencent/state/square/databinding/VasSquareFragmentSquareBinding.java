package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.state.square.SquareView;
import com.tencent.state.view.SquareImageView;
import com.tencent.state.view.VasSquareMainShareView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareFragmentSquareBinding implements ViewBinding {
    public final SquareImageView back;
    public final LinearLayout bottomContainer;
    public final FrameLayout bottomNormalArea;
    public final SquareImageView btnCollectCard;
    public final Button btnNewMessage;
    public final Button btnOutMessage;
    public final Button btnSetTop;
    public final LinearLayout dynamicDebugger;
    public final LinearLayout leftContainer;
    public final SquareImageView location;
    public final LinearLayout logoContainer;
    public final SquareImageView msgBoxIcon;
    public final FrameLayout msgBoxIconContainer;
    public final TextView msgBoxReddot;
    public final SquareImageView portal;
    public final VasSquareMainShareView poster;
    public final FrameLayout quickPublishEntry;
    public final SquareImageView quickPublishEntryBtn;
    public final LinearLayout quickPublishEntryTips;
    public final TextView quickPublishEntryTipsText;
    public final LinearLayout quickSeatBtn;
    public final LinearLayout rbContainer;
    public final VasSquareErrorViewBinding requestErrorBackground;
    public final LinearLayout rightTopIconsContainer;
    private final FrameLayout rootView;
    public final SquareImageView setting;
    public final RelativeLayout speaker;
    public final SquareImageView speakerPhoneImage;
    public final TextView speakerPhoneText;
    public final FrameLayout square;
    public final SquareImageView squareRuleIcon;
    public final View squareTopBar;
    public final SquareView squareView;
    public final SquareImageView taskButton;
    public final View taskRedDot;
    public final TextView title;
    public final RelativeLayout titleContainer;
    public final LinearLayout topTipsBubble;
    public final SquareImageView topTipsBubbleIcon;
    public final TextView topTipsBubbleText;

    VasSquareFragmentSquareBinding(FrameLayout frameLayout, SquareImageView squareImageView, LinearLayout linearLayout, FrameLayout frameLayout2, SquareImageView squareImageView2, Button button, Button button2, Button button3, LinearLayout linearLayout2, LinearLayout linearLayout3, SquareImageView squareImageView3, LinearLayout linearLayout4, SquareImageView squareImageView4, FrameLayout frameLayout3, TextView textView, SquareImageView squareImageView5, VasSquareMainShareView vasSquareMainShareView, FrameLayout frameLayout4, SquareImageView squareImageView6, LinearLayout linearLayout5, TextView textView2, LinearLayout linearLayout6, LinearLayout linearLayout7, VasSquareErrorViewBinding vasSquareErrorViewBinding, LinearLayout linearLayout8, SquareImageView squareImageView7, RelativeLayout relativeLayout, SquareImageView squareImageView8, TextView textView3, FrameLayout frameLayout5, SquareImageView squareImageView9, View view, SquareView squareView, SquareImageView squareImageView10, View view2, TextView textView4, RelativeLayout relativeLayout2, LinearLayout linearLayout9, SquareImageView squareImageView11, TextView textView5) {
        this.rootView = frameLayout;
        this.back = squareImageView;
        this.bottomContainer = linearLayout;
        this.bottomNormalArea = frameLayout2;
        this.btnCollectCard = squareImageView2;
        this.btnNewMessage = button;
        this.btnOutMessage = button2;
        this.btnSetTop = button3;
        this.dynamicDebugger = linearLayout2;
        this.leftContainer = linearLayout3;
        this.location = squareImageView3;
        this.logoContainer = linearLayout4;
        this.msgBoxIcon = squareImageView4;
        this.msgBoxIconContainer = frameLayout3;
        this.msgBoxReddot = textView;
        this.portal = squareImageView5;
        this.poster = vasSquareMainShareView;
        this.quickPublishEntry = frameLayout4;
        this.quickPublishEntryBtn = squareImageView6;
        this.quickPublishEntryTips = linearLayout5;
        this.quickPublishEntryTipsText = textView2;
        this.quickSeatBtn = linearLayout6;
        this.rbContainer = linearLayout7;
        this.requestErrorBackground = vasSquareErrorViewBinding;
        this.rightTopIconsContainer = linearLayout8;
        this.setting = squareImageView7;
        this.speaker = relativeLayout;
        this.speakerPhoneImage = squareImageView8;
        this.speakerPhoneText = textView3;
        this.square = frameLayout5;
        this.squareRuleIcon = squareImageView9;
        this.squareTopBar = view;
        this.squareView = squareView;
        this.taskButton = squareImageView10;
        this.taskRedDot = view2;
        this.title = textView4;
        this.titleContainer = relativeLayout2;
        this.topTipsBubble = linearLayout9;
        this.topTipsBubbleIcon = squareImageView11;
        this.topTipsBubbleText = textView5;
    }

    public static VasSquareFragmentSquareBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareFragmentSquareBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d4s, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareFragmentSquareBinding bind(View view) {
        int i3 = R.id.pcx;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.pcx);
        if (squareImageView != null) {
            i3 = R.id.peq;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.peq);
            if (linearLayout != null) {
                i3 = R.id.pes;
                FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.pes);
                if (frameLayout != null) {
                    i3 = R.id.pfn;
                    SquareImageView squareImageView2 = (SquareImageView) view.findViewById(R.id.pfn);
                    if (squareImageView2 != null) {
                        i3 = R.id.pga;
                        Button button = (Button) view.findViewById(R.id.pga);
                        if (button != null) {
                            i3 = R.id.pgc;
                            Button button2 = (Button) view.findViewById(R.id.pgc);
                            if (button2 != null) {
                                i3 = R.id.pgh;
                                Button button3 = (Button) view.findViewById(R.id.pgh);
                                if (button3 != null) {
                                    i3 = R.id.pqv;
                                    LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.pqv);
                                    if (linearLayout2 != null) {
                                        i3 = R.id.q4t;
                                        LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.q4t);
                                        if (linearLayout3 != null) {
                                            i3 = R.id.f163453q71;
                                            SquareImageView squareImageView3 = (SquareImageView) view.findViewById(R.id.f163453q71);
                                            if (squareImageView3 != null) {
                                                i3 = R.id.q79;
                                                LinearLayout linearLayout4 = (LinearLayout) view.findViewById(R.id.q79);
                                                if (linearLayout4 != null) {
                                                    i3 = R.id.q9m;
                                                    SquareImageView squareImageView4 = (SquareImageView) view.findViewById(R.id.q9m);
                                                    if (squareImageView4 != null) {
                                                        i3 = R.id.q9n;
                                                        FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.q9n);
                                                        if (frameLayout2 != null) {
                                                            i3 = R.id.q9o;
                                                            TextView textView = (TextView) view.findViewById(R.id.q9o);
                                                            if (textView != null) {
                                                                i3 = R.id.qd9;
                                                                SquareImageView squareImageView5 = (SquareImageView) view.findViewById(R.id.qd9);
                                                                if (squareImageView5 != null) {
                                                                    i3 = R.id.qd_;
                                                                    VasSquareMainShareView vasSquareMainShareView = (VasSquareMainShareView) view.findViewById(R.id.qd_);
                                                                    if (vasSquareMainShareView != null) {
                                                                        i3 = R.id.qf9;
                                                                        FrameLayout frameLayout3 = (FrameLayout) view.findViewById(R.id.qf9);
                                                                        if (frameLayout3 != null) {
                                                                            i3 = R.id.qf_;
                                                                            SquareImageView squareImageView6 = (SquareImageView) view.findViewById(R.id.qf_);
                                                                            if (squareImageView6 != null) {
                                                                                i3 = R.id.qfa;
                                                                                LinearLayout linearLayout5 = (LinearLayout) view.findViewById(R.id.qfa);
                                                                                if (linearLayout5 != null) {
                                                                                    i3 = R.id.qfb;
                                                                                    TextView textView2 = (TextView) view.findViewById(R.id.qfb);
                                                                                    if (textView2 != null) {
                                                                                        i3 = R.id.qfc;
                                                                                        LinearLayout linearLayout6 = (LinearLayout) view.findViewById(R.id.qfc);
                                                                                        if (linearLayout6 != null) {
                                                                                            i3 = R.id.qfi;
                                                                                            LinearLayout linearLayout7 = (LinearLayout) view.findViewById(R.id.qfi);
                                                                                            if (linearLayout7 != null) {
                                                                                                i3 = R.id.qh9;
                                                                                                View findViewById = view.findViewById(R.id.qh9);
                                                                                                if (findViewById != null) {
                                                                                                    VasSquareErrorViewBinding bind = VasSquareErrorViewBinding.bind(findViewById);
                                                                                                    i3 = R.id.qhx;
                                                                                                    LinearLayout linearLayout8 = (LinearLayout) view.findViewById(R.id.qhx);
                                                                                                    if (linearLayout8 != null) {
                                                                                                        i3 = R.id.qkk;
                                                                                                        SquareImageView squareImageView7 = (SquareImageView) view.findViewById(R.id.qkk);
                                                                                                        if (squareImageView7 != null) {
                                                                                                            i3 = R.id.qmr;
                                                                                                            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.qmr);
                                                                                                            if (relativeLayout != null) {
                                                                                                                i3 = R.id.qms;
                                                                                                                SquareImageView squareImageView8 = (SquareImageView) view.findViewById(R.id.qms);
                                                                                                                if (squareImageView8 != null) {
                                                                                                                    i3 = R.id.qmt;
                                                                                                                    TextView textView3 = (TextView) view.findViewById(R.id.qmt);
                                                                                                                    if (textView3 != null) {
                                                                                                                        FrameLayout frameLayout4 = (FrameLayout) view;
                                                                                                                        i3 = R.id.qn6;
                                                                                                                        SquareImageView squareImageView9 = (SquareImageView) view.findViewById(R.id.qn6);
                                                                                                                        if (squareImageView9 != null) {
                                                                                                                            i3 = R.id.qn9;
                                                                                                                            View findViewById2 = view.findViewById(R.id.qn9);
                                                                                                                            if (findViewById2 != null) {
                                                                                                                                i3 = R.id.qn_;
                                                                                                                                SquareView squareView = (SquareView) view.findViewById(R.id.qn_);
                                                                                                                                if (squareView != null) {
                                                                                                                                    i3 = R.id.qpn;
                                                                                                                                    SquareImageView squareImageView10 = (SquareImageView) view.findViewById(R.id.qpn);
                                                                                                                                    if (squareImageView10 != null) {
                                                                                                                                        i3 = R.id.f163551qq4;
                                                                                                                                        View findViewById3 = view.findViewById(R.id.f163551qq4);
                                                                                                                                        if (findViewById3 != null) {
                                                                                                                                            i3 = R.id.qr6;
                                                                                                                                            TextView textView4 = (TextView) view.findViewById(R.id.qr6);
                                                                                                                                            if (textView4 != null) {
                                                                                                                                                i3 = R.id.qro;
                                                                                                                                                RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.qro);
                                                                                                                                                if (relativeLayout2 != null) {
                                                                                                                                                    i3 = R.id.qsg;
                                                                                                                                                    LinearLayout linearLayout9 = (LinearLayout) view.findViewById(R.id.qsg);
                                                                                                                                                    if (linearLayout9 != null) {
                                                                                                                                                        i3 = R.id.qsh;
                                                                                                                                                        SquareImageView squareImageView11 = (SquareImageView) view.findViewById(R.id.qsh);
                                                                                                                                                        if (squareImageView11 != null) {
                                                                                                                                                            i3 = R.id.qsi;
                                                                                                                                                            TextView textView5 = (TextView) view.findViewById(R.id.qsi);
                                                                                                                                                            if (textView5 != null) {
                                                                                                                                                                return new VasSquareFragmentSquareBinding(frameLayout4, squareImageView, linearLayout, frameLayout, squareImageView2, button, button2, button3, linearLayout2, linearLayout3, squareImageView3, linearLayout4, squareImageView4, frameLayout2, textView, squareImageView5, vasSquareMainShareView, frameLayout3, squareImageView6, linearLayout5, textView2, linearLayout6, linearLayout7, bind, linearLayout8, squareImageView7, relativeLayout, squareImageView8, textView3, frameLayout4, squareImageView9, findViewById2, squareView, squareImageView10, findViewById3, textView4, relativeLayout2, linearLayout9, squareImageView11, textView5);
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
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
