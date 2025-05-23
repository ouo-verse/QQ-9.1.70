package com.tencent.mobileqq.mini.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MiniAppDesktopMineAdapterViewHolderLayoutBinding implements ViewBinding {
    public final View miniAppDesktopEmptyDragMirror0;
    public final View miniAppDesktopEmptyDragMirror1;
    public final View miniAppDesktopEmptyDragMirror2;
    public final View miniAppDesktopEmptyDragMirror3;
    public final FrameLayout miniAppDesktopEmptyDragMirrorFl0;
    public final FrameLayout miniAppDesktopEmptyDragMirrorFl1;
    public final FrameLayout miniAppDesktopEmptyDragMirrorFl2;
    public final FrameLayout miniAppDesktopEmptyDragMirrorFl3;
    public final LinearLayout miniAppDesktopEmptyDragMirrorLayout;
    public final RelativeLayout miniAppDesktopEmptyGuideLayout;
    public final TextView miniAppDesktopEmptyGuideTv;
    public final RecyclerView miniAppInnerMineRecyclerView;
    public final RelativeLayout miniAppInnerMineRecyclerViewRoot;
    public final MiniAppDesktopAdapterViewHolderTitleLayoutBinding recentTitleLayout;
    private final RelativeLayout rootView;

    MiniAppDesktopMineAdapterViewHolderLayoutBinding(RelativeLayout relativeLayout, View view, View view2, View view3, View view4, FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, FrameLayout frameLayout4, LinearLayout linearLayout, RelativeLayout relativeLayout2, TextView textView, RecyclerView recyclerView, RelativeLayout relativeLayout3, MiniAppDesktopAdapterViewHolderTitleLayoutBinding miniAppDesktopAdapterViewHolderTitleLayoutBinding) {
        this.rootView = relativeLayout;
        this.miniAppDesktopEmptyDragMirror0 = view;
        this.miniAppDesktopEmptyDragMirror1 = view2;
        this.miniAppDesktopEmptyDragMirror2 = view3;
        this.miniAppDesktopEmptyDragMirror3 = view4;
        this.miniAppDesktopEmptyDragMirrorFl0 = frameLayout;
        this.miniAppDesktopEmptyDragMirrorFl1 = frameLayout2;
        this.miniAppDesktopEmptyDragMirrorFl2 = frameLayout3;
        this.miniAppDesktopEmptyDragMirrorFl3 = frameLayout4;
        this.miniAppDesktopEmptyDragMirrorLayout = linearLayout;
        this.miniAppDesktopEmptyGuideLayout = relativeLayout2;
        this.miniAppDesktopEmptyGuideTv = textView;
        this.miniAppInnerMineRecyclerView = recyclerView;
        this.miniAppInnerMineRecyclerViewRoot = relativeLayout3;
        this.recentTitleLayout = miniAppDesktopAdapterViewHolderTitleLayoutBinding;
    }

    public static MiniAppDesktopMineAdapterViewHolderLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniAppDesktopMineAdapterViewHolderLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.did, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static MiniAppDesktopMineAdapterViewHolderLayoutBinding bind(View view) {
        int i3 = R.id.rft;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.rft);
        if (findChildViewById != null) {
            i3 = R.id.rfu;
            View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.rfu);
            if (findChildViewById2 != null) {
                i3 = R.id.rfv;
                View findChildViewById3 = ViewBindings.findChildViewById(view, R.id.rfv);
                if (findChildViewById3 != null) {
                    i3 = R.id.rfw;
                    View findChildViewById4 = ViewBindings.findChildViewById(view, R.id.rfw);
                    if (findChildViewById4 != null) {
                        i3 = R.id.rfx;
                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.rfx);
                        if (frameLayout != null) {
                            i3 = R.id.rfy;
                            FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.rfy);
                            if (frameLayout2 != null) {
                                i3 = R.id.rfz;
                                FrameLayout frameLayout3 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.rfz);
                                if (frameLayout3 != null) {
                                    i3 = R.id.f163683rg0;
                                    FrameLayout frameLayout4 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.f163683rg0);
                                    if (frameLayout4 != null) {
                                        i3 = R.id.f163684rg1;
                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f163684rg1);
                                        if (linearLayout != null) {
                                            i3 = R.id.f163685rg2;
                                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.f163685rg2);
                                            if (relativeLayout != null) {
                                                i3 = R.id.f163686rg3;
                                                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f163686rg3);
                                                if (textView != null) {
                                                    i3 = R.id.rgh;
                                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rgh);
                                                    if (recyclerView != null) {
                                                        RelativeLayout relativeLayout2 = (RelativeLayout) view;
                                                        i3 = R.id.rkx;
                                                        View findChildViewById5 = ViewBindings.findChildViewById(view, R.id.rkx);
                                                        if (findChildViewById5 != null) {
                                                            return new MiniAppDesktopMineAdapterViewHolderLayoutBinding(relativeLayout2, findChildViewById, findChildViewById2, findChildViewById3, findChildViewById4, frameLayout, frameLayout2, frameLayout3, frameLayout4, linearLayout, relativeLayout, textView, recyclerView, relativeLayout2, MiniAppDesktopAdapterViewHolderTitleLayoutBinding.bind(findChildViewById5));
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
