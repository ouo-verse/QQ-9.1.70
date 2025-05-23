package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.state.library.view.LibraryTableView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareItemLibraryTableBinding implements ViewBinding {
    private final RelativeLayout rootView;
    public final LibraryTableView tableView;

    VasSquareItemLibraryTableBinding(RelativeLayout relativeLayout, LibraryTableView libraryTableView) {
        this.rootView = relativeLayout;
        this.tableView = libraryTableView;
    }

    public static VasSquareItemLibraryTableBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareItemLibraryTableBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d5l, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareItemLibraryTableBinding bind(View view) {
        LibraryTableView libraryTableView = (LibraryTableView) view.findViewById(R.id.qpd);
        if (libraryTableView != null) {
            return new VasSquareItemLibraryTableBinding((RelativeLayout) view, libraryTableView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.qpd)));
    }
}
