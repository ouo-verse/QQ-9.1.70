package com.tencent.mobileqq.search.business.qcircle.video.game.union;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.search.business.net.view.c;
import lo2.h;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a extends c {
    private QCircleSearchGameUnionView M;

    public a(ViewGroup viewGroup, String str, int i3) {
        q(viewGroup.getContext(), R.layout.fuk, str, i3);
    }

    private void q(Context context, int i3, String str, int i16) {
        if (i3 == 0) {
            this.f433999d = new View(context);
            return;
        }
        View inflate = LayoutInflater.from(context).inflate(i3, (ViewGroup) null, false);
        inflate.setClickable(true);
        inflate.setFocusable(true);
        this.f433999d = inflate;
        if (inflate instanceof QCircleSearchGameUnionView) {
            QCircleSearchGameUnionView qCircleSearchGameUnionView = (QCircleSearchGameUnionView) inflate;
            this.M = qCircleSearchGameUnionView;
            qCircleSearchGameUnionView.b(str, i16);
        }
    }

    public void p(h hVar, int i3) {
        QCircleSearchGameUnionView qCircleSearchGameUnionView = this.M;
        if (qCircleSearchGameUnionView != null) {
            qCircleSearchGameUnionView.a(hVar, i3);
        }
    }
}
