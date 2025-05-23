package com.tencent.gdtad.basics.adbox;

import com.tencent.gdtad.aditem.GdtAd;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public interface IGdtAdBox {
    void destroy();

    void refresh(List<GdtAd> list);

    void show();
}
