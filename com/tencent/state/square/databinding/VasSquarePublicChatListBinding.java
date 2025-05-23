package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.state.view.SquareImageView;

/* loaded from: classes38.dex */
public final class VasSquarePublicChatListBinding implements ViewBinding {
    public final SquareImageView avatarBubbleIcon;
    public final LinearLayout chatList;
    public final LinearLayout foldBtn;
    public final EditText msgInputBox;
    public final RelativeLayout msgPanel;
    public final SquareImageView msgPanelArrow;
    public final RecyclerView msgsContainer;
    public final View offsetLocator;
    public final LinearLayout panelContainer;
    private final CoordinatorLayout rootView;
    public final TextView unreadNumBtn;
    public final FrameLayout unreadNumWrapper;

    VasSquarePublicChatListBinding(CoordinatorLayout coordinatorLayout, SquareImageView squareImageView, LinearLayout linearLayout, LinearLayout linearLayout2, EditText editText, RelativeLayout relativeLayout, SquareImageView squareImageView2, RecyclerView recyclerView, View view, LinearLayout linearLayout3, TextView textView, FrameLayout frameLayout) {
        this.rootView = coordinatorLayout;
        this.avatarBubbleIcon = squareImageView;
        this.chatList = linearLayout;
        this.foldBtn = linearLayout2;
        this.msgInputBox = editText;
        this.msgPanel = relativeLayout;
        this.msgPanelArrow = squareImageView2;
        this.msgsContainer = recyclerView;
        this.offsetLocator = view;
        this.panelContainer = linearLayout3;
        this.unreadNumBtn = textView;
        this.unreadNumWrapper = frameLayout;
    }

    public static VasSquarePublicChatListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquarePublicChatListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d6n, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public CoordinatorLayout getRoot() {
        return this.rootView;
    }

    public static VasSquarePublicChatListBinding bind(View view) {
        int i3 = R.id.pbp;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.pbp);
        if (squareImageView != null) {
            i3 = R.id.f163329pj3;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.f163329pj3);
            if (linearLayout != null) {
                i3 = R.id.pv8;
                LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.pv8);
                if (linearLayout2 != null) {
                    i3 = R.id.q9q;
                    EditText editText = (EditText) view.findViewById(R.id.q9q);
                    if (editText != null) {
                        i3 = R.id.q9r;
                        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.q9r);
                        if (relativeLayout != null) {
                            i3 = R.id.q9s;
                            SquareImageView squareImageView2 = (SquareImageView) view.findViewById(R.id.q9s);
                            if (squareImageView2 != null) {
                                i3 = R.id.q9u;
                                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.q9u);
                                if (recyclerView != null) {
                                    i3 = R.id.q_o;
                                    View findViewById = view.findViewById(R.id.q_o);
                                    if (findViewById != null) {
                                        i3 = R.id.qbk;
                                        LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.qbk);
                                        if (linearLayout3 != null) {
                                            i3 = R.id.qva;
                                            TextView textView = (TextView) view.findViewById(R.id.qva);
                                            if (textView != null) {
                                                i3 = R.id.qvb;
                                                FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.qvb);
                                                if (frameLayout != null) {
                                                    return new VasSquarePublicChatListBinding((CoordinatorLayout) view, squareImageView, linearLayout, linearLayout2, editText, relativeLayout, squareImageView2, recyclerView, findViewById, linearLayout3, textView, frameLayout);
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
