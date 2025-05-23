package com.qzone.album.business.photolist.ui.listitem;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.qzone.album.business.photolist.adapter.a;
import com.qzone.album.data.model.PhotoCacheData;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.proxy.feedcomponent.widget.SafeTextView;
import com.tencent.mobileqq.R;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import s4.d;

/* compiled from: P */
/* loaded from: classes39.dex */
public class NoShootTimeTitleLayout extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    private CellTextView f43622d;

    /* renamed from: e, reason: collision with root package name */
    private CellTextView f43623e;

    /* renamed from: f, reason: collision with root package name */
    private SafeTextView f43624f;

    /* renamed from: h, reason: collision with root package name */
    private SafeTextView f43625h;

    /* renamed from: i, reason: collision with root package name */
    private SafeTextView f43626i;

    public NoShootTimeTitleLayout(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.f168988bg3, this);
        this.f43624f = (SafeTextView) inflate.findViewById(R.id.dar);
        this.f43625h = (SafeTextView) inflate.findViewById(R.id.daq);
        this.f43626i = (SafeTextView) inflate.findViewById(R.id.dap);
        this.f43622d = (CellTextView) inflate.findViewById(R.id.dat);
        this.f43623e = (CellTextView) inflate.findViewById(R.id.das);
    }

    public void b(int i3, a aVar, x4.a aVar2, PhotoCacheData[] photoCacheDataArr, d dVar, boolean z16) {
        this.f43623e.setVisibility(0);
        this.f43624f.setVisibility(8);
        this.f43625h.setVisibility(8);
        this.f43626i.setVisibility(8);
        this.f43622d.setText(R.string.gby);
        if (1 == i3 || 2 == i3 || 3 == i3 || 7 == i3) {
            this.f43625h.setVisibility(0);
            return;
        }
        if (5 == i3) {
            this.f43623e.setVisibility(8);
            this.f43622d.setText(aVar.n(photoCacheDataArr[0]));
            this.f43625h.setVisibility(0);
        } else {
            if (4 == i3) {
                this.f43623e.setVisibility(8);
                this.f43622d.setText(aVar.n(photoCacheDataArr[0]));
                this.f43626i.setVisibility(0);
                this.f43626i.setOnClickListener(aVar2.x(photoCacheDataArr, dVar));
                LpReportInfo_pf00064.allReport(326, 3, 4);
                return;
            }
            if (i3 == 0 && z16 && aVar2.h()) {
                this.f43624f.setVisibility(0);
                this.f43624f.setOnClickListener(aVar2.i());
                LpReportInfo_pf00064.allReport(326, 2, 43);
            }
        }
    }

    public void setFont(int i3, String str, int i16) {
        this.f43622d.setFont(i3, str, i16);
        this.f43623e.setFont(i3, str, i16);
    }

    public NoShootTimeTitleLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public void setBtnSelected(boolean z16, View.OnClickListener onClickListener) {
        if (z16) {
            this.f43625h.setSelected(true);
            this.f43625h.setText(getResources().getString(R.string.gcv));
        } else {
            this.f43625h.setSelected(false);
            this.f43625h.setText(getResources().getString(R.string.gcc));
        }
        this.f43625h.setOnClickListener(onClickListener);
    }
}
