package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareAvatarBubbleDetailBinding implements ViewBinding {
    public final LinearLayout bubbleHeaderSongContainer;
    public final TextView bubbleHeaderSongPrefix;
    public final TextView customPublishTimeText;
    public final TextView customPublishTitleNow;
    public final LinearLayout customPublishTitleView;
    private final View rootView;

    VasSquareAvatarBubbleDetailBinding(View view, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, LinearLayout linearLayout2) {
        this.rootView = view;
        this.bubbleHeaderSongContainer = linearLayout;
        this.bubbleHeaderSongPrefix = textView;
        this.customPublishTimeText = textView2;
        this.customPublishTitleNow = textView3;
        this.customPublishTitleView = linearLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static VasSquareAvatarBubbleDetailBinding bind(View view) {
        int i3 = R.id.pgz;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.pgz);
        if (linearLayout != null) {
            i3 = R.id.f163316ph0;
            TextView textView = (TextView) view.findViewById(R.id.f163316ph0);
            if (textView != null) {
                i3 = R.id.po5;
                TextView textView2 = (TextView) view.findViewById(R.id.po5);
                if (textView2 != null) {
                    i3 = R.id.po6;
                    TextView textView3 = (TextView) view.findViewById(R.id.po6);
                    if (textView3 != null) {
                        i3 = R.id.po7;
                        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.po7);
                        if (linearLayout2 != null) {
                            return new VasSquareAvatarBubbleDetailBinding(view, linearLayout, textView, textView2, textView3, linearLayout2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static VasSquareAvatarBubbleDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.d3_, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
