package com.tencent.luggage.wxa.i5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import com.tencent.mobileqq.R;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final View f129470a;

    /* renamed from: b, reason: collision with root package name */
    public final ThreeDotsLoadingView f129471b;

    /* renamed from: c, reason: collision with root package name */
    public final View f129472c;

    /* renamed from: d, reason: collision with root package name */
    public final View f129473d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f129474e;

    public b(ViewGroup parent, int i3) {
        ThreeDotsLoadingView threeDotsLoadingView;
        TextView textView;
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.dya, parent, false);
        this.f129470a = inflate;
        if (inflate != null) {
            threeDotsLoadingView = (ThreeDotsLoadingView) inflate.findViewById(R.id.efs);
        } else {
            threeDotsLoadingView = null;
        }
        this.f129471b = threeDotsLoadingView;
        this.f129472c = inflate != null ? inflate.findViewById(R.id.vde) : null;
        this.f129473d = inflate;
        this.f129474e = true;
        if (inflate != null && (textView = (TextView) inflate.findViewById(R.id.vdd)) != null) {
            textView.setText(i3);
        }
        a(true);
    }

    public final View a() {
        return this.f129473d;
    }

    public final boolean b() {
        return this.f129474e;
    }

    public final void a(boolean z16) {
        this.f129474e = z16;
        if (z16) {
            ThreeDotsLoadingView threeDotsLoadingView = this.f129471b;
            if (threeDotsLoadingView != null) {
                threeDotsLoadingView.setVisibility(0);
                threeDotsLoadingView.startLoadingAnimation();
            }
            View view = this.f129472c;
            if (view == null) {
                return;
            }
            view.setVisibility(8);
            return;
        }
        ThreeDotsLoadingView threeDotsLoadingView2 = this.f129471b;
        if (threeDotsLoadingView2 != null) {
            threeDotsLoadingView2.stopLoadingAnimation();
            threeDotsLoadingView2.setVisibility(8);
        }
        View view2 = this.f129472c;
        if (view2 == null) {
            return;
        }
        view2.setVisibility(0);
    }
}
