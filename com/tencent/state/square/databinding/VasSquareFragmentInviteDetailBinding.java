package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.state.square.avatar.filament.SquareAvatarFilamentView;
import com.tencent.state.view.AvatarOnlineStatusDetailBubble;
import com.tencent.state.view.SquareImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareFragmentInviteDetailBinding implements ViewBinding {
    public final TextView accept;
    public final SquareAvatarFilamentView avatar;
    public final AvatarOnlineStatusDetailBubble avatarBubble;
    public final RelativeLayout avatarLocationView;
    public final SquareImageView back;
    public final SquareImageView background;
    public final TextView customTextTitle;
    public final LinearLayout customTextTitleGroup;
    public final View darkView;
    public final SquareImageView editCustomClearIcon;
    public final TextView editCustomTextNum;
    public final SquareImageView end;
    public final TextView jumpBtn;
    public final RelativeLayout previewContainer;
    public final SquareImageView previewImage;
    public final RelativeLayout previewTitleContainer;
    public final VasSquareErrorViewBinding requestErrorBackground;
    private final ScrollView rootView;
    public final SquareImageView senderIcon;
    public final TextView senderStatus;
    public final LinearLayout statusContainer;
    public final Button textEditComplete;
    public final TextView tipsText;
    public final TextView title;
    public final RelativeLayout titleContainer;

    VasSquareFragmentInviteDetailBinding(ScrollView scrollView, TextView textView, SquareAvatarFilamentView squareAvatarFilamentView, AvatarOnlineStatusDetailBubble avatarOnlineStatusDetailBubble, RelativeLayout relativeLayout, SquareImageView squareImageView, SquareImageView squareImageView2, TextView textView2, LinearLayout linearLayout, View view, SquareImageView squareImageView3, TextView textView3, SquareImageView squareImageView4, TextView textView4, RelativeLayout relativeLayout2, SquareImageView squareImageView5, RelativeLayout relativeLayout3, VasSquareErrorViewBinding vasSquareErrorViewBinding, SquareImageView squareImageView6, TextView textView5, LinearLayout linearLayout2, Button button, TextView textView6, TextView textView7, RelativeLayout relativeLayout4) {
        this.rootView = scrollView;
        this.accept = textView;
        this.avatar = squareAvatarFilamentView;
        this.avatarBubble = avatarOnlineStatusDetailBubble;
        this.avatarLocationView = relativeLayout;
        this.back = squareImageView;
        this.background = squareImageView2;
        this.customTextTitle = textView2;
        this.customTextTitleGroup = linearLayout;
        this.darkView = view;
        this.editCustomClearIcon = squareImageView3;
        this.editCustomTextNum = textView3;
        this.end = squareImageView4;
        this.jumpBtn = textView4;
        this.previewContainer = relativeLayout2;
        this.previewImage = squareImageView5;
        this.previewTitleContainer = relativeLayout3;
        this.requestErrorBackground = vasSquareErrorViewBinding;
        this.senderIcon = squareImageView6;
        this.senderStatus = textView5;
        this.statusContainer = linearLayout2;
        this.textEditComplete = button;
        this.tipsText = textView6;
        this.title = textView7;
        this.titleContainer = relativeLayout4;
    }

    public static VasSquareFragmentInviteDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareFragmentInviteDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d4n, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public ScrollView getRoot() {
        return this.rootView;
    }

    public static VasSquareFragmentInviteDetailBinding bind(View view) {
        int i3 = R.id.p9r;
        TextView textView = (TextView) view.findViewById(R.id.p9r);
        if (textView != null) {
            i3 = R.id.pax;
            SquareAvatarFilamentView squareAvatarFilamentView = (SquareAvatarFilamentView) view.findViewById(R.id.pax);
            if (squareAvatarFilamentView != null) {
                i3 = R.id.pbm;
                AvatarOnlineStatusDetailBubble avatarOnlineStatusDetailBubble = (AvatarOnlineStatusDetailBubble) view.findViewById(R.id.pbm);
                if (avatarOnlineStatusDetailBubble != null) {
                    i3 = R.id.f163295pc4;
                    RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.f163295pc4);
                    if (relativeLayout != null) {
                        i3 = R.id.pcx;
                        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.pcx);
                        if (squareImageView != null) {
                            i3 = R.id.pd8;
                            SquareImageView squareImageView2 = (SquareImageView) view.findViewById(R.id.pd8);
                            if (squareImageView2 != null) {
                                i3 = R.id.po9;
                                TextView textView2 = (TextView) view.findViewById(R.id.po9);
                                if (textView2 != null) {
                                    i3 = R.id.po_;
                                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.po_);
                                    if (linearLayout != null) {
                                        i3 = R.id.poc;
                                        View findViewById = view.findViewById(R.id.poc);
                                        if (findViewById != null) {
                                            i3 = R.id.f163368pr2;
                                            SquareImageView squareImageView3 = (SquareImageView) view.findViewById(R.id.f163368pr2);
                                            if (squareImageView3 != null) {
                                                i3 = R.id.f163369pr3;
                                                TextView textView3 = (TextView) view.findViewById(R.id.f163369pr3);
                                                if (textView3 != null) {
                                                    i3 = R.id.prx;
                                                    SquareImageView squareImageView4 = (SquareImageView) view.findViewById(R.id.prx);
                                                    if (squareImageView4 != null) {
                                                        i3 = R.id.q4c;
                                                        TextView textView4 = (TextView) view.findViewById(R.id.q4c);
                                                        if (textView4 != null) {
                                                            i3 = R.id.qdl;
                                                            RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.qdl);
                                                            if (relativeLayout2 != null) {
                                                                i3 = R.id.qdm;
                                                                SquareImageView squareImageView5 = (SquareImageView) view.findViewById(R.id.qdm);
                                                                if (squareImageView5 != null) {
                                                                    i3 = R.id.qdn;
                                                                    RelativeLayout relativeLayout3 = (RelativeLayout) view.findViewById(R.id.qdn);
                                                                    if (relativeLayout3 != null) {
                                                                        i3 = R.id.qh9;
                                                                        View findViewById2 = view.findViewById(R.id.qh9);
                                                                        if (findViewById2 != null) {
                                                                            VasSquareErrorViewBinding bind = VasSquareErrorViewBinding.bind(findViewById2);
                                                                            i3 = R.id.qke;
                                                                            SquareImageView squareImageView6 = (SquareImageView) view.findViewById(R.id.qke);
                                                                            if (squareImageView6 != null) {
                                                                                i3 = R.id.qkg;
                                                                                TextView textView5 = (TextView) view.findViewById(R.id.qkg);
                                                                                if (textView5 != null) {
                                                                                    i3 = R.id.qnk;
                                                                                    LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.qnk);
                                                                                    if (linearLayout2 != null) {
                                                                                        i3 = R.id.qqg;
                                                                                        Button button = (Button) view.findViewById(R.id.qqg);
                                                                                        if (button != null) {
                                                                                            i3 = R.id.f163553qr1;
                                                                                            TextView textView6 = (TextView) view.findViewById(R.id.f163553qr1);
                                                                                            if (textView6 != null) {
                                                                                                i3 = R.id.qr6;
                                                                                                TextView textView7 = (TextView) view.findViewById(R.id.qr6);
                                                                                                if (textView7 != null) {
                                                                                                    i3 = R.id.qro;
                                                                                                    RelativeLayout relativeLayout4 = (RelativeLayout) view.findViewById(R.id.qro);
                                                                                                    if (relativeLayout4 != null) {
                                                                                                        return new VasSquareFragmentInviteDetailBinding((ScrollView) view, textView, squareAvatarFilamentView, avatarOnlineStatusDetailBubble, relativeLayout, squareImageView, squareImageView2, textView2, linearLayout, findViewById, squareImageView3, textView3, squareImageView4, textView4, relativeLayout2, squareImageView5, relativeLayout3, bind, squareImageView6, textView5, linearLayout2, button, textView6, textView7, relativeLayout4);
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
