package com.qzone.reborn.groupalbum.reship.part;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.qzone.reborn.groupalbum.reship.bean.GroupAlbumReshipInitBean;
import com.qzone.widget.ExtendGridView;
import com.tencent.util.ArrayUtils;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public class b extends tl.g {
    private ni.h G;
    private GroupAlbumReshipInitBean H;

    public b(tl.a aVar) {
        super(aVar);
    }

    @Override // tl.g
    protected void U9(int i3) {
        ni.h hVar = this.G;
        if (hVar == null) {
            return;
        }
        List<CommonStMedia> O1 = hVar.O1();
        if (ArrayUtils.isOutOfArrayIndex(i3, O1)) {
            return;
        }
        O1.remove(i3);
        this.G.P1().postValue(O1);
    }

    @Override // tl.g
    protected void V9(String str) {
        ni.h hVar = this.G;
        if (hVar == null) {
            return;
        }
        List<CommonStMedia> O1 = hVar.O1();
        if (O1.isEmpty()) {
            return;
        }
        int i3 = 0;
        while (true) {
            if (i3 >= O1.size()) {
                i3 = -1;
                break;
            } else if (TextUtils.equals(str, O1.get(i3).l())) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 != -1) {
            O1.remove(i3);
            this.G.P1().postValue(O1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tl.g
    public void W9() {
        super.W9();
        ni.h hVar = (ni.h) getViewModel(ni.h.class);
        this.G = hVar;
        if (hVar != null) {
            this.H = hVar.getInitBean();
        }
        e9.a aVar = this.f436498e;
        if (aVar == null || this.H == null) {
            return;
        }
        aVar.r0(true);
        this.f436498e.z0(this.H.getOverLimitNum());
    }

    @Override // tl.g
    protected boolean Z9() {
        return false;
    }

    @Override // tl.g
    protected void ia(ExtendGridView extendGridView, int i3, List<String> list, View view) {
        ni.h hVar = this.G;
        if (hVar == null || ArrayUtils.isOutOfArrayIndex(0, hVar.O1())) {
            return;
        }
        ei.a.f396299a.e(getContext(), view instanceof ImageView ? (ImageView) view : null, this.G.O1().get(i3));
    }

    @Override // tl.g
    protected void la() {
        this.f436499f = ((tl.h) getViewModel(tl.h.class)).P1().getValue();
        HashMap<String, ShuoshuoVideoInfo> R1 = ((tl.h) getViewModel(tl.h.class)).R1();
        for (String str : R1.keySet()) {
            this.f436502m.put(str, R1.get(str));
        }
        ja();
    }

    @Override // tl.g, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
    }
}
