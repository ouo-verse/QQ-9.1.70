package com.qzone.reborn.feedx.widget.header;

import android.view.View;
import androidx.core.view.ViewCompat;
import com.qzone.common.account.LoginData;
import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.IObserver;
import com.qzone.cover.ui.QZoneTianShuADDecorator;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes37.dex */
public class j extends d implements IObserver.main {

    /* renamed from: f, reason: collision with root package name */
    QZoneTianShuADDecorator f56301f;

    public j(View view) {
        super(view);
        this.f56301f = (QZoneTianShuADDecorator) view.findViewById(R.id.f162857n03);
    }

    @Override // com.qzone.reborn.feedx.widget.header.d
    protected String j() {
        return "QZoneFeedxHeaderTianShuAdElement";
    }

    @Override // com.qzone.reborn.feedx.widget.header.d
    public void l() {
        this.f56301f.c(g(), LoginData.getInstance().getUinString());
        ViewCompat.setImportantForAccessibility(this.f56301f, 2);
        EventCenter.getInstance().addUIObserver(this, "TianShu", 1);
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void onDestroy() {
        EventCenter.getInstance().removeObserver(this);
    }

    @Override // com.qzone.common.event.IObserver.main
    public void onEventUIThread(Event event) {
        if ("TianShu".equals(event.source.getName()) && event.what == 1) {
            this.f56301f.d();
        }
    }
}
