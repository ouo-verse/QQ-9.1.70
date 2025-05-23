package com.qzone.reborn.feedx.part;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.qzone.business.share.ThirdPartShareLogic;
import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.IObserver;

/* compiled from: P */
/* loaded from: classes37.dex */
public class bh extends g implements IObserver.main {

    /* renamed from: d, reason: collision with root package name */
    private ThirdPartShareLogic f55046d;

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        ThirdPartShareLogic thirdPartShareLogic = this.f55046d;
        if (thirdPartShareLogic == null || i3 != 103) {
            return;
        }
        if (i16 == -1) {
            thirdPartShareLogic.f44759m.onShareResult(true, 0, null);
        } else {
            thirdPartShareLogic.m();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        ThirdPartShareLogic thirdPartShareLogic = this.f55046d;
        if (thirdPartShareLogic != null) {
            thirdPartShareLogic.q();
        }
        return super.onBackEvent();
    }

    @Override // com.qzone.common.event.IObserver.main
    public void onEventUIThread(Event event) {
        if ("Feed".equals(event.source.getName()) && event.what == 14 && C9() != null) {
            C9().P1();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (ThirdPartShareLogic.x(intent)) {
            if (this.f55046d == null) {
                this.f55046d = new ThirdPartShareLogic();
            }
            this.f55046d.A(intent);
            this.f55046d.w(getActivity());
            this.f55046d.z(false);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        if (ThirdPartShareLogic.x(activity.getIntent())) {
            if (this.f55046d == null) {
                this.f55046d = new ThirdPartShareLogic();
            }
            this.f55046d.z(true);
            this.f55046d.A(activity.getIntent());
        }
        EventCenter.getInstance().addUIObserver(this, "Feed", 14);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        EventCenter.getInstance().removeObserver(this);
        ThirdPartShareLogic thirdPartShareLogic = this.f55046d;
        if (thirdPartShareLogic != null) {
            thirdPartShareLogic.p();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        ThirdPartShareLogic thirdPartShareLogic = this.f55046d;
        if (thirdPartShareLogic != null) {
            thirdPartShareLogic.y();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onWindowFocusChanged(boolean z16) {
        ThirdPartShareLogic thirdPartShareLogic;
        super.onWindowFocusChanged(z16);
        if (z16 && (thirdPartShareLogic = this.f55046d) != null && thirdPartShareLogic.t()) {
            this.f55046d.w(getActivity());
            this.f55046d.z(false);
        }
    }
}
