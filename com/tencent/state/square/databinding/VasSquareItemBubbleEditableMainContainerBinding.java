package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.state.view.SquareImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareItemBubbleEditableMainContainerBinding implements ViewBinding {
    public final SquareImageView bubbleEditIcon;
    public final EditText bubbleEditText;
    public final SquareImageView bubblePenIcon;
    public final FrameLayout editableBubbleMainContainer;
    private final View rootView;

    VasSquareItemBubbleEditableMainContainerBinding(View view, SquareImageView squareImageView, EditText editText, SquareImageView squareImageView2, FrameLayout frameLayout) {
        this.rootView = view;
        this.bubbleEditIcon = squareImageView;
        this.bubbleEditText = editText;
        this.bubblePenIcon = squareImageView2;
        this.editableBubbleMainContainer = frameLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static VasSquareItemBubbleEditableMainContainerBinding bind(View view) {
        int i3 = R.id.pgx;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.pgx);
        if (squareImageView != null) {
            i3 = R.id.pgy;
            EditText editText = (EditText) view.findViewById(R.id.pgy);
            if (editText != null) {
                i3 = R.id.ph5;
                SquareImageView squareImageView2 = (SquareImageView) view.findViewById(R.id.ph5);
                if (squareImageView2 != null) {
                    i3 = R.id.pr7;
                    FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.pr7);
                    if (frameLayout != null) {
                        return new VasSquareItemBubbleEditableMainContainerBinding(view, squareImageView, editText, squareImageView2, frameLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static VasSquareItemBubbleEditableMainContainerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.d58, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
