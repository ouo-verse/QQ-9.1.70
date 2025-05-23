package com.tencent.mobileqq.search.business.qcircle.video.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.search.model.v;
import lo2.z;

/* compiled from: P */
/* loaded from: classes18.dex */
public abstract class b extends com.tencent.mobileqq.search.business.net.view.c {
    private QCircleSearchDoubleVideoView M;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(ViewGroup viewGroup, String str, String str2, v vVar) {
        r(viewGroup.getContext(), q(vVar), str, str2);
    }

    private void r(Context context, int i3, String str, String str2) {
        if (i3 == 0) {
            this.f433999d = new View(context);
            return;
        }
        View inflate = LayoutInflater.from(context).inflate(i3, (ViewGroup) null, false);
        inflate.setBackgroundResource(R.drawable.qui_common_fill_light_primary_bg_selector);
        inflate.setClickable(true);
        inflate.setFocusable(true);
        this.f433999d = inflate;
        if (inflate instanceof QCircleSearchDoubleVideoView) {
            QCircleSearchDoubleVideoView qCircleSearchDoubleVideoView = (QCircleSearchDoubleVideoView) inflate;
            this.M = qCircleSearchDoubleVideoView;
            qCircleSearchDoubleVideoView.j();
            this.M.setHotSearchKeyWordId(str);
            this.M.setSearchKeyWord(str2);
        }
    }

    public void p(z zVar) {
        QCircleSearchDoubleVideoView qCircleSearchDoubleVideoView = this.M;
        if (qCircleSearchDoubleVideoView != null) {
            qCircleSearchDoubleVideoView.d(zVar);
        }
    }

    protected int q(v vVar) {
        return 0;
    }
}
