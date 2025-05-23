package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.state.library.focus.view.FocusCommonView;
import com.tencent.state.library.view.LibraryTableView;
import com.tencent.state.square.avatar.SquareAvatarView;
import com.tencent.state.template.publicchat.view.CallMateButtonView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareLibraryGroupViewBinding implements ViewBinding {
    public final CallMateButtonView callMateBtn;
    public final FocusCommonView commonView;
    public final LinearLayout customBubbleParent;
    public final LinearLayout customChatBox;
    public final LinearLayout customChatBubble;
    public final LinearLayout customChatView;
    public final TextView customNewMessageRedPoint;
    public final TextView customNewMessageTips;
    public final SquareAvatarView leftAvatarImage;
    public final LibraryTableView leftTab;
    public final SquareAvatarView rightAvatarImage;
    public final LibraryTableView rightTab;
    private final View rootView;

    VasSquareLibraryGroupViewBinding(View view, CallMateButtonView callMateButtonView, FocusCommonView focusCommonView, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, TextView textView, TextView textView2, SquareAvatarView squareAvatarView, LibraryTableView libraryTableView, SquareAvatarView squareAvatarView2, LibraryTableView libraryTableView2) {
        this.rootView = view;
        this.callMateBtn = callMateButtonView;
        this.commonView = focusCommonView;
        this.customBubbleParent = linearLayout;
        this.customChatBox = linearLayout2;
        this.customChatBubble = linearLayout3;
        this.customChatView = linearLayout4;
        this.customNewMessageRedPoint = textView;
        this.customNewMessageTips = textView2;
        this.leftAvatarImage = squareAvatarView;
        this.leftTab = libraryTableView;
        this.rightAvatarImage = squareAvatarView2;
        this.rightTab = libraryTableView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: getRoot */
    public View getMRv() {
        return this.rootView;
    }

    public static VasSquareLibraryGroupViewBinding bind(View view) {
        int i3 = R.id.phz;
        CallMateButtonView callMateButtonView = (CallMateButtonView) view.findViewById(R.id.phz);
        if (callMateButtonView != null) {
            i3 = R.id.plf;
            FocusCommonView focusCommonView = (FocusCommonView) view.findViewById(R.id.plf);
            if (focusCommonView != null) {
                i3 = R.id.pnu;
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.pnu);
                if (linearLayout != null) {
                    i3 = R.id.pnv;
                    LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.pnv);
                    if (linearLayout2 != null) {
                        i3 = R.id.pnw;
                        LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.pnw);
                        if (linearLayout3 != null) {
                            i3 = R.id.pny;
                            LinearLayout linearLayout4 = (LinearLayout) view.findViewById(R.id.pny);
                            if (linearLayout4 != null) {
                                i3 = R.id.f163354po3;
                                TextView textView = (TextView) view.findViewById(R.id.f163354po3);
                                if (textView != null) {
                                    i3 = R.id.f163355po4;
                                    TextView textView2 = (TextView) view.findViewById(R.id.f163355po4);
                                    if (textView2 != null) {
                                        i3 = R.id.q4r;
                                        SquareAvatarView squareAvatarView = (SquareAvatarView) view.findViewById(R.id.q4r);
                                        if (squareAvatarView != null) {
                                            i3 = R.id.q4u;
                                            LibraryTableView libraryTableView = (LibraryTableView) view.findViewById(R.id.q4u);
                                            if (libraryTableView != null) {
                                                i3 = R.id.qhu;
                                                SquareAvatarView squareAvatarView2 = (SquareAvatarView) view.findViewById(R.id.qhu);
                                                if (squareAvatarView2 != null) {
                                                    i3 = R.id.qhw;
                                                    LibraryTableView libraryTableView2 = (LibraryTableView) view.findViewById(R.id.qhw);
                                                    if (libraryTableView2 != null) {
                                                        return new VasSquareLibraryGroupViewBinding(view, callMateButtonView, focusCommonView, linearLayout, linearLayout2, linearLayout3, linearLayout4, textView, textView2, squareAvatarView, libraryTableView, squareAvatarView2, libraryTableView2);
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

    public static VasSquareLibraryGroupViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.d5w, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
