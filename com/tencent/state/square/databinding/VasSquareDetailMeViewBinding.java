package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.state.square.detail.DetailCommonView;
import com.tencent.state.square.location.LocationIconView;
import com.tencent.state.square.pickfriend.PickFriendView;
import com.tencent.state.status.SquareOnlineStatusViewPanel;
import com.tencent.state.view.AvatarOnlineStatusDetailBubble;
import com.tencent.state.view.BubbleStickersBanner;
import com.tencent.state.view.SquareImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareDetailMeViewBinding implements ViewBinding {
    public final AvatarOnlineStatusDetailBubble avatarBubble;
    public final FrameLayout avatarBubbleContainer;
    public final RelativeLayout avatarLocationView;
    public final RelativeLayout blindBoxContainer;
    public final TextView blindBoxText;
    public final TextView blindBoxTips;
    public final FrameLayout btnBlindBox;
    public final SquareImageView btnBlindBoxIc;
    public final SquareImageView btnFlowerEntry;
    public final LinearLayout buttons;
    public final LinearLayout changeStatusContainer;
    public final SquareImageView chatOrStatusIcon;
    public final TextView chatOrStatusText;
    public final DetailCommonView commonView;
    public final FrameLayout configInteraction;
    public final SquareImageView configInteractionIcon;
    public final TextView customTextTitle;
    public final LinearLayout customTextTitleGroup;
    public final View darkView;
    public final SquareImageView editCustomClearIcon;
    public final TextView editCustomTextNum;
    public final TextView flowerCountText;
    public final FrameLayout flowerEntry;
    public final TextView goBlindBox;
    public final LinearLayout hostFocusView;
    public final VasSquareInteractionRecordLayoutBinding interactionRecord;
    public final FrameLayout interactionRecordBtnContainer;
    public final SquareImageView lockIcon;
    public final SquareImageView newStatusImage;
    public final RelativeLayout newStatusRedDotContainer;
    public final RecyclerView onlineStatusMultiActionPanel;
    public final FrameLayout onlineStatusMultiActionPanelContainer;
    public final View onlineStatusMultiSelectedMasker;
    public final SquareOnlineStatusViewPanel onlineStatusPanel;
    public final VasSquareDatailMultiOperatorBinding operatorContainer;
    public final RelativeLayout pageButtons;
    public final SquareImageView posterLoadingIc;
    public final RelativeLayout posterLoadingView;
    public final Button publish;
    private final View rootView;
    public final LocationIconView selectLocationBar;
    public final PickFriendView selector;
    public final TextView stateLoadingTips;
    public final LinearLayout stateLoadingView;
    public final BubbleStickersBanner stickersBanner;
    public final Button textEditComplete;

    VasSquareDetailMeViewBinding(View view, AvatarOnlineStatusDetailBubble avatarOnlineStatusDetailBubble, FrameLayout frameLayout, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, TextView textView, TextView textView2, FrameLayout frameLayout2, SquareImageView squareImageView, SquareImageView squareImageView2, LinearLayout linearLayout, LinearLayout linearLayout2, SquareImageView squareImageView3, TextView textView3, DetailCommonView detailCommonView, FrameLayout frameLayout3, SquareImageView squareImageView4, TextView textView4, LinearLayout linearLayout3, View view2, SquareImageView squareImageView5, TextView textView5, TextView textView6, FrameLayout frameLayout4, TextView textView7, LinearLayout linearLayout4, VasSquareInteractionRecordLayoutBinding vasSquareInteractionRecordLayoutBinding, FrameLayout frameLayout5, SquareImageView squareImageView6, SquareImageView squareImageView7, RelativeLayout relativeLayout3, RecyclerView recyclerView, FrameLayout frameLayout6, View view3, SquareOnlineStatusViewPanel squareOnlineStatusViewPanel, VasSquareDatailMultiOperatorBinding vasSquareDatailMultiOperatorBinding, RelativeLayout relativeLayout4, SquareImageView squareImageView8, RelativeLayout relativeLayout5, Button button, LocationIconView locationIconView, PickFriendView pickFriendView, TextView textView8, LinearLayout linearLayout5, BubbleStickersBanner bubbleStickersBanner, Button button2) {
        this.rootView = view;
        this.avatarBubble = avatarOnlineStatusDetailBubble;
        this.avatarBubbleContainer = frameLayout;
        this.avatarLocationView = relativeLayout;
        this.blindBoxContainer = relativeLayout2;
        this.blindBoxText = textView;
        this.blindBoxTips = textView2;
        this.btnBlindBox = frameLayout2;
        this.btnBlindBoxIc = squareImageView;
        this.btnFlowerEntry = squareImageView2;
        this.buttons = linearLayout;
        this.changeStatusContainer = linearLayout2;
        this.chatOrStatusIcon = squareImageView3;
        this.chatOrStatusText = textView3;
        this.commonView = detailCommonView;
        this.configInteraction = frameLayout3;
        this.configInteractionIcon = squareImageView4;
        this.customTextTitle = textView4;
        this.customTextTitleGroup = linearLayout3;
        this.darkView = view2;
        this.editCustomClearIcon = squareImageView5;
        this.editCustomTextNum = textView5;
        this.flowerCountText = textView6;
        this.flowerEntry = frameLayout4;
        this.goBlindBox = textView7;
        this.hostFocusView = linearLayout4;
        this.interactionRecord = vasSquareInteractionRecordLayoutBinding;
        this.interactionRecordBtnContainer = frameLayout5;
        this.lockIcon = squareImageView6;
        this.newStatusImage = squareImageView7;
        this.newStatusRedDotContainer = relativeLayout3;
        this.onlineStatusMultiActionPanel = recyclerView;
        this.onlineStatusMultiActionPanelContainer = frameLayout6;
        this.onlineStatusMultiSelectedMasker = view3;
        this.onlineStatusPanel = squareOnlineStatusViewPanel;
        this.operatorContainer = vasSquareDatailMultiOperatorBinding;
        this.pageButtons = relativeLayout4;
        this.posterLoadingIc = squareImageView8;
        this.posterLoadingView = relativeLayout5;
        this.publish = button;
        this.selectLocationBar = locationIconView;
        this.selector = pickFriendView;
        this.stateLoadingTips = textView8;
        this.stateLoadingView = linearLayout5;
        this.stickersBanner = bubbleStickersBanner;
        this.textEditComplete = button2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static VasSquareDetailMeViewBinding bind(View view) {
        int i3 = R.id.pbm;
        AvatarOnlineStatusDetailBubble avatarOnlineStatusDetailBubble = (AvatarOnlineStatusDetailBubble) view.findViewById(R.id.pbm);
        if (avatarOnlineStatusDetailBubble != null) {
            i3 = R.id.pbn;
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.pbn);
            if (frameLayout != null) {
                i3 = R.id.f163295pc4;
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.f163295pc4);
                if (relativeLayout != null) {
                    i3 = R.id.pdz;
                    RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.pdz);
                    if (relativeLayout2 != null) {
                        i3 = R.id.pe7;
                        TextView textView = (TextView) view.findViewById(R.id.pe7);
                        if (textView != null) {
                            i3 = R.id.pe8;
                            TextView textView2 = (TextView) view.findViewById(R.id.pe8);
                            if (textView2 != null) {
                                i3 = R.id.pfc;
                                FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.pfc);
                                if (frameLayout2 != null) {
                                    i3 = R.id.pfd;
                                    SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.pfd);
                                    if (squareImageView != null) {
                                        i3 = R.id.f163315pg4;
                                        SquareImageView squareImageView2 = (SquareImageView) view.findViewById(R.id.f163315pg4);
                                        if (squareImageView2 != null) {
                                            i3 = R.id.phl;
                                            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.phl);
                                            if (linearLayout != null) {
                                                i3 = R.id.f163326pj0;
                                                LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.f163326pj0);
                                                if (linearLayout2 != null) {
                                                    i3 = R.id.f163330pj4;
                                                    SquareImageView squareImageView3 = (SquareImageView) view.findViewById(R.id.f163330pj4);
                                                    if (squareImageView3 != null) {
                                                        i3 = R.id.pj5;
                                                        TextView textView3 = (TextView) view.findViewById(R.id.pj5);
                                                        if (textView3 != null) {
                                                            i3 = R.id.plf;
                                                            DetailCommonView detailCommonView = (DetailCommonView) view.findViewById(R.id.plf);
                                                            if (detailCommonView != null) {
                                                                i3 = R.id.plk;
                                                                FrameLayout frameLayout3 = (FrameLayout) view.findViewById(R.id.plk);
                                                                if (frameLayout3 != null) {
                                                                    i3 = R.id.pll;
                                                                    SquareImageView squareImageView4 = (SquareImageView) view.findViewById(R.id.pll);
                                                                    if (squareImageView4 != null) {
                                                                        i3 = R.id.po9;
                                                                        TextView textView4 = (TextView) view.findViewById(R.id.po9);
                                                                        if (textView4 != null) {
                                                                            i3 = R.id.po_;
                                                                            LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.po_);
                                                                            if (linearLayout3 != null) {
                                                                                i3 = R.id.poc;
                                                                                View findViewById = view.findViewById(R.id.poc);
                                                                                if (findViewById != null) {
                                                                                    i3 = R.id.f163368pr2;
                                                                                    SquareImageView squareImageView5 = (SquareImageView) view.findViewById(R.id.f163368pr2);
                                                                                    if (squareImageView5 != null) {
                                                                                        i3 = R.id.f163369pr3;
                                                                                        TextView textView5 = (TextView) view.findViewById(R.id.f163369pr3);
                                                                                        if (textView5 != null) {
                                                                                            i3 = R.id.pux;
                                                                                            TextView textView6 = (TextView) view.findViewById(R.id.pux);
                                                                                            if (textView6 != null) {
                                                                                                i3 = R.id.puy;
                                                                                                FrameLayout frameLayout4 = (FrameLayout) view.findViewById(R.id.puy);
                                                                                                if (frameLayout4 != null) {
                                                                                                    i3 = R.id.pwy;
                                                                                                    TextView textView7 = (TextView) view.findViewById(R.id.pwy);
                                                                                                    if (textView7 != null) {
                                                                                                        i3 = R.id.q08;
                                                                                                        LinearLayout linearLayout4 = (LinearLayout) view.findViewById(R.id.q08);
                                                                                                        if (linearLayout4 != null) {
                                                                                                            i3 = R.id.q26;
                                                                                                            View findViewById2 = view.findViewById(R.id.q26);
                                                                                                            if (findViewById2 != null) {
                                                                                                                VasSquareInteractionRecordLayoutBinding bind = VasSquareInteractionRecordLayoutBinding.bind(findViewById2);
                                                                                                                i3 = R.id.q27;
                                                                                                                FrameLayout frameLayout5 = (FrameLayout) view.findViewById(R.id.q27);
                                                                                                                if (frameLayout5 != null) {
                                                                                                                    i3 = R.id.q76;
                                                                                                                    SquareImageView squareImageView6 = (SquareImageView) view.findViewById(R.id.q76);
                                                                                                                    if (squareImageView6 != null) {
                                                                                                                        i3 = R.id.q_d;
                                                                                                                        SquareImageView squareImageView7 = (SquareImageView) view.findViewById(R.id.q_d);
                                                                                                                        if (squareImageView7 != null) {
                                                                                                                            i3 = R.id.q_e;
                                                                                                                            RelativeLayout relativeLayout3 = (RelativeLayout) view.findViewById(R.id.q_e);
                                                                                                                            if (relativeLayout3 != null) {
                                                                                                                                i3 = R.id.q_u;
                                                                                                                                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.q_u);
                                                                                                                                if (recyclerView != null) {
                                                                                                                                    i3 = R.id.q_v;
                                                                                                                                    FrameLayout frameLayout6 = (FrameLayout) view.findViewById(R.id.q_v);
                                                                                                                                    if (frameLayout6 != null) {
                                                                                                                                        i3 = R.id.q_w;
                                                                                                                                        View findViewById3 = view.findViewById(R.id.q_w);
                                                                                                                                        if (findViewById3 != null) {
                                                                                                                                            i3 = R.id.q_x;
                                                                                                                                            SquareOnlineStatusViewPanel squareOnlineStatusViewPanel = (SquareOnlineStatusViewPanel) view.findViewById(R.id.q_x);
                                                                                                                                            if (squareOnlineStatusViewPanel != null) {
                                                                                                                                                i3 = R.id.qa7;
                                                                                                                                                View findViewById4 = view.findViewById(R.id.qa7);
                                                                                                                                                if (findViewById4 != null) {
                                                                                                                                                    VasSquareDatailMultiOperatorBinding bind2 = VasSquareDatailMultiOperatorBinding.bind(findViewById4);
                                                                                                                                                    i3 = R.id.qbb;
                                                                                                                                                    RelativeLayout relativeLayout4 = (RelativeLayout) view.findViewById(R.id.qbb);
                                                                                                                                                    if (relativeLayout4 != null) {
                                                                                                                                                        i3 = R.id.qda;
                                                                                                                                                        SquareImageView squareImageView8 = (SquareImageView) view.findViewById(R.id.qda);
                                                                                                                                                        if (squareImageView8 != null) {
                                                                                                                                                            i3 = R.id.qdb;
                                                                                                                                                            RelativeLayout relativeLayout5 = (RelativeLayout) view.findViewById(R.id.qdb);
                                                                                                                                                            if (relativeLayout5 != null) {
                                                                                                                                                                i3 = R.id.qei;
                                                                                                                                                                Button button = (Button) view.findViewById(R.id.qei);
                                                                                                                                                                if (button != null) {
                                                                                                                                                                    i3 = R.id.qjx;
                                                                                                                                                                    LocationIconView locationIconView = (LocationIconView) view.findViewById(R.id.qjx);
                                                                                                                                                                    if (locationIconView != null) {
                                                                                                                                                                        i3 = R.id.qk8;
                                                                                                                                                                        PickFriendView pickFriendView = (PickFriendView) view.findViewById(R.id.qk8);
                                                                                                                                                                        if (pickFriendView != null) {
                                                                                                                                                                            i3 = R.id.qnc;
                                                                                                                                                                            TextView textView8 = (TextView) view.findViewById(R.id.qnc);
                                                                                                                                                                            if (textView8 != null) {
                                                                                                                                                                                i3 = R.id.qnd;
                                                                                                                                                                                LinearLayout linearLayout5 = (LinearLayout) view.findViewById(R.id.qnd);
                                                                                                                                                                                if (linearLayout5 != null) {
                                                                                                                                                                                    i3 = R.id.qnn;
                                                                                                                                                                                    BubbleStickersBanner bubbleStickersBanner = (BubbleStickersBanner) view.findViewById(R.id.qnn);
                                                                                                                                                                                    if (bubbleStickersBanner != null) {
                                                                                                                                                                                        i3 = R.id.qqg;
                                                                                                                                                                                        Button button2 = (Button) view.findViewById(R.id.qqg);
                                                                                                                                                                                        if (button2 != null) {
                                                                                                                                                                                            return new VasSquareDetailMeViewBinding(view, avatarOnlineStatusDetailBubble, frameLayout, relativeLayout, relativeLayout2, textView, textView2, frameLayout2, squareImageView, squareImageView2, linearLayout, linearLayout2, squareImageView3, textView3, detailCommonView, frameLayout3, squareImageView4, textView4, linearLayout3, findViewById, squareImageView5, textView5, textView6, frameLayout4, textView7, linearLayout4, bind, frameLayout5, squareImageView6, squareImageView7, relativeLayout3, recyclerView, frameLayout6, findViewById3, squareOnlineStatusViewPanel, bind2, relativeLayout4, squareImageView8, relativeLayout5, button, locationIconView, pickFriendView, textView8, linearLayout5, bubbleStickersBanner, button2);
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
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static VasSquareDetailMeViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.f167403d44, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
