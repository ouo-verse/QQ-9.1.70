package com.qzone.business.plusunion.plusoperation;

import com.tencent.image.ApngImage;
import cooperation.qzone.util.QZLog;

/* loaded from: classes39.dex */
class PlusMenuDecorates$5$1$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ d f44660d;

    @Override // java.lang.Runnable
    public void run() {
        ApngImage.pauseByTag(this.f44660d.f44680f.f44681a);
        this.f44660d.f44678d.setVisibility(0);
        QZLog.i("PlusMenuDecorates", 2, "\u64ad\u653e\u5b8c\u6bd5 setDrawable successs");
        this.f44660d.f44679e.setVisibility(8);
        this.f44660d.f44679e.setImageDrawable(null);
    }
}
