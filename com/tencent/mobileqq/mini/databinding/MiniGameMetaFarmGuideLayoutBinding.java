package com.tencent.mobileqq.mini.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MiniGameMetaFarmGuideLayoutBinding implements ViewBinding {
    public final URLImageView btnClose;
    public final QUIButton btnOpenFarmCard;
    public final URLImageView imgGuide;
    public final RelativeLayout metaFarmGuideContainer;
    public final RelativeLayout metaFarmGuideRoot;
    public final View metaFarmGuideTopView;
    private final RelativeLayout rootView;
    public final TextView txtDesc;
    public final TextView txtTitle;

    MiniGameMetaFarmGuideLayoutBinding(RelativeLayout relativeLayout, URLImageView uRLImageView, QUIButton qUIButton, URLImageView uRLImageView2, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, View view, TextView textView, TextView textView2) {
        this.rootView = relativeLayout;
        this.btnClose = uRLImageView;
        this.btnOpenFarmCard = qUIButton;
        this.imgGuide = uRLImageView2;
        this.metaFarmGuideContainer = relativeLayout2;
        this.metaFarmGuideRoot = relativeLayout3;
        this.metaFarmGuideTopView = view;
        this.txtDesc = textView;
        this.txtTitle = textView2;
    }

    public static MiniGameMetaFarmGuideLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniGameMetaFarmGuideLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dk5, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static MiniGameMetaFarmGuideLayoutBinding bind(View view) {
        int i3 = R.id.rcf;
        URLImageView uRLImageView = (URLImageView) ViewBindings.findChildViewById(view, R.id.rcf);
        if (uRLImageView != null) {
            i3 = R.id.rcj;
            QUIButton qUIButton = (QUIButton) ViewBindings.findChildViewById(view, R.id.rcj);
            if (qUIButton != null) {
                i3 = R.id.f163677re4;
                URLImageView uRLImageView2 = (URLImageView) ViewBindings.findChildViewById(view, R.id.f163677re4);
                if (uRLImageView2 != null) {
                    i3 = R.id.rf5;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rf5);
                    if (relativeLayout != null) {
                        RelativeLayout relativeLayout2 = (RelativeLayout) view;
                        i3 = R.id.rf7;
                        View findChildViewById = ViewBindings.findChildViewById(view, R.id.rf7);
                        if (findChildViewById != null) {
                            i3 = R.id.rlv;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.rlv);
                            if (textView != null) {
                                i3 = R.id.rly;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.rly);
                                if (textView2 != null) {
                                    return new MiniGameMetaFarmGuideLayoutBinding(relativeLayout2, uRLImageView, qUIButton, uRLImageView2, relativeLayout, relativeLayout2, findChildViewById, textView, textView2);
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
