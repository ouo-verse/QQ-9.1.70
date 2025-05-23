package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.state.library.LibraryMapView;
import com.tencent.state.view.SquareImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareFragmentLibraryBinding implements ViewBinding {
    public final SquareImageView back;
    public final FrameLayout calendar;
    public final SquareImageView calendarRedDot;
    public final LibraryMapView library;
    public final FrameLayout publicChatBtnContainer;
    public final FrameLayout publicChatListContainer;
    private final FrameLayout rootView;
    public final LinearLayout seatButton;
    public final LinearLayout seatButtonWrapper;
    public final SquareImageView seatIcon;
    public final TextView seatText;
    public final TextView title;
    public final RelativeLayout titleContainer;

    VasSquareFragmentLibraryBinding(FrameLayout frameLayout, SquareImageView squareImageView, FrameLayout frameLayout2, SquareImageView squareImageView2, LibraryMapView libraryMapView, FrameLayout frameLayout3, FrameLayout frameLayout4, LinearLayout linearLayout, LinearLayout linearLayout2, SquareImageView squareImageView3, TextView textView, TextView textView2, RelativeLayout relativeLayout) {
        this.rootView = frameLayout;
        this.back = squareImageView;
        this.calendar = frameLayout2;
        this.calendarRedDot = squareImageView2;
        this.library = libraryMapView;
        this.publicChatBtnContainer = frameLayout3;
        this.publicChatListContainer = frameLayout4;
        this.seatButton = linearLayout;
        this.seatButtonWrapper = linearLayout2;
        this.seatIcon = squareImageView3;
        this.seatText = textView;
        this.title = textView2;
        this.titleContainer = relativeLayout;
    }

    public static VasSquareFragmentLibraryBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareFragmentLibraryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d4o, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareFragmentLibraryBinding bind(View view) {
        int i3 = R.id.pcx;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.pcx);
        if (squareImageView != null) {
            i3 = R.id.phu;
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.phu);
            if (frameLayout != null) {
                i3 = R.id.phy;
                SquareImageView squareImageView2 = (SquareImageView) view.findViewById(R.id.phy);
                if (squareImageView2 != null) {
                    i3 = R.id.q4w;
                    LibraryMapView libraryMapView = (LibraryMapView) view.findViewById(R.id.q4w);
                    if (libraryMapView != null) {
                        i3 = R.id.qeg;
                        FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.qeg);
                        if (frameLayout2 != null) {
                            i3 = R.id.qeh;
                            FrameLayout frameLayout3 = (FrameLayout) view.findViewById(R.id.qeh);
                            if (frameLayout3 != null) {
                                i3 = R.id.qjf;
                                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.qjf);
                                if (linearLayout != null) {
                                    i3 = R.id.qjg;
                                    LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.qjg);
                                    if (linearLayout2 != null) {
                                        i3 = R.id.qjh;
                                        SquareImageView squareImageView3 = (SquareImageView) view.findViewById(R.id.qjh);
                                        if (squareImageView3 != null) {
                                            i3 = R.id.qji;
                                            TextView textView = (TextView) view.findViewById(R.id.qji);
                                            if (textView != null) {
                                                i3 = R.id.qr6;
                                                TextView textView2 = (TextView) view.findViewById(R.id.qr6);
                                                if (textView2 != null) {
                                                    i3 = R.id.qro;
                                                    RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.qro);
                                                    if (relativeLayout != null) {
                                                        return new VasSquareFragmentLibraryBinding((FrameLayout) view, squareImageView, frameLayout, squareImageView2, libraryMapView, frameLayout2, frameLayout3, linearLayout, linearLayout2, squareImageView3, textView, textView2, relativeLayout);
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
