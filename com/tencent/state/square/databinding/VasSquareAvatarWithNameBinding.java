package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.state.square.avatar.SquareAvatarView;
import com.tencent.state.view.SquareImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareAvatarWithNameBinding implements ViewBinding {
    public final SquareAvatarView avatarImage;
    public final SquareImageView avatarIntimateIcon;
    public final FrameLayout avatarNameContainer;
    public final TextView avatarNameUnread;
    public final TextView avatarText;
    private final View rootView;

    VasSquareAvatarWithNameBinding(View view, SquareAvatarView squareAvatarView, SquareImageView squareImageView, FrameLayout frameLayout, TextView textView, TextView textView2) {
        this.rootView = view;
        this.avatarImage = squareAvatarView;
        this.avatarIntimateIcon = squareImageView;
        this.avatarNameContainer = frameLayout;
        this.avatarNameUnread = textView;
        this.avatarText = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static VasSquareAvatarWithNameBinding bind(View view) {
        int i3 = R.id.pbz;
        SquareAvatarView squareAvatarView = (SquareAvatarView) view.findViewById(R.id.pbz);
        if (squareAvatarView != null) {
            i3 = R.id.f163291pc0;
            SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.f163291pc0);
            if (squareImageView != null) {
                i3 = R.id.pcg;
                FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.pcg);
                if (frameLayout != null) {
                    i3 = R.id.pci;
                    TextView textView = (TextView) view.findViewById(R.id.pci);
                    if (textView != null) {
                        i3 = R.id.pcq;
                        TextView textView2 = (TextView) view.findViewById(R.id.pcq);
                        if (textView2 != null) {
                            return new VasSquareAvatarWithNameBinding(view, squareAvatarView, squareImageView, frameLayout, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static VasSquareAvatarWithNameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.d3e, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
