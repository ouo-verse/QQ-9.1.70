package com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieKuiklyBaseModule;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class AdelieCategoryHomeTrace {
    public long createPagerStartTime;
    public long dataShowTime;
    public long errorCode;
    public long errorTime;
    public long firstFrameTime;
    public boolean hasLocalCache;
    public boolean hasReported;
    public long pageShowTime;
    public final long startTime;

    public AdelieCategoryHomeTrace(long j3) {
        this.startTime = j3;
    }

    public final e dump() {
        String str;
        e eVar = new e();
        eVar.u("result_code", this.errorCode);
        eVar.u("start_to_create_pager_cost", this.createPagerStartTime - this.startTime);
        eVar.u("start_to_resume_cost", this.pageShowTime - this.startTime);
        eVar.u("start_to_first_frame_cost", this.firstFrameTime - this.startTime);
        eVar.u("start_to_data_show_cost", this.dataShowTime - this.startTime);
        eVar.u("start_to_error_cost", this.errorTime - this.startTime);
        if (this.hasLocalCache) {
            str = "1";
        } else {
            str = "0";
        }
        eVar.v("has_local_cache", str);
        return eVar;
    }

    public final boolean isReadyToReport() {
        return this.firstFrameTime > 0 && this.dataShowTime > 0 && this.pageShowTime > 0;
    }

    public final void report() {
        if (this.hasReported) {
            return;
        }
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("trace=");
        m3.append(dump());
        kLog.i("AdelieCategoryHomeTrace", m3.toString());
        this.hasReported = true;
        ((AdelieKuiklyBaseModule) c.f117352a.g().acquireModule("AdelieKuiklyBaseModule")).reportBeacon("adelie_category_home_page_nt_compose", dump());
    }
}
