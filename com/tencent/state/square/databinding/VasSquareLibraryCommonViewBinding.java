package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.state.library.focus.view.LibraryFocusTimeBubble;
import com.tencent.state.library.focus.view.LibraryTitleContainer;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareLibraryCommonViewBinding implements ViewBinding {
    public final LibraryFocusTimeBubble focusTimeBubble;
    private final View rootView;
    public final LibraryTitleContainer titleContainer;

    VasSquareLibraryCommonViewBinding(View view, LibraryFocusTimeBubble libraryFocusTimeBubble, LibraryTitleContainer libraryTitleContainer) {
        this.rootView = view;
        this.focusTimeBubble = libraryFocusTimeBubble;
        this.titleContainer = libraryTitleContainer;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: getRoot */
    public View getMContainer() {
        return this.rootView;
    }

    public static VasSquareLibraryCommonViewBinding bind(View view) {
        int i3 = R.id.pv7;
        LibraryFocusTimeBubble libraryFocusTimeBubble = (LibraryFocusTimeBubble) view.findViewById(R.id.pv7);
        if (libraryFocusTimeBubble != null) {
            i3 = R.id.qro;
            LibraryTitleContainer libraryTitleContainer = (LibraryTitleContainer) view.findViewById(R.id.qro);
            if (libraryTitleContainer != null) {
                return new VasSquareLibraryCommonViewBinding(view, libraryFocusTimeBubble, libraryTitleContainer);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static VasSquareLibraryCommonViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.d5u, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
