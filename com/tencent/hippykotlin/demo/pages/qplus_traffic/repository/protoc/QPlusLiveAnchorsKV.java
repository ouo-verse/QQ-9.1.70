package com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes31.dex */
public final class QPlusLiveAnchorsKV implements ISSOReqModel, ISSORspModel<QPlusLiveAnchorsKV> {
    public final long key;
    public final QPlusLiveStatus value;

    public QPlusLiveAnchorsKV() {
        this(0L, null, 3, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.u("key", this.key);
        QPlusLiveStatus qPlusLiveStatus = this.value;
        if (qPlusLiveStatus != null) {
            eVar.v("value", qPlusLiveStatus.encode());
        }
        return eVar;
    }

    public QPlusLiveAnchorsKV(long j3, QPlusLiveStatus qPlusLiveStatus) {
        this.key = j3;
        this.value = qPlusLiveStatus;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QPlusLiveAnchorsKV decode(e eVar) {
        long o16 = eVar.o("key", 0L);
        e m3 = eVar.m("value");
        return new QPlusLiveAnchorsKV(o16, m3 != null ? new QPlusLiveStatus(m3.o("uid", 0L), m3.o(AudienceReportConst.ROOM_ID, 0L), m3.k("stat", 0), m3.k("video_begin_timestamp", 0), m3.q("jump_url", ""), m3.q("name", ""), m3.q("head_img_url", ""), m3.q("cover", "")) : null);
    }

    public /* synthetic */ QPlusLiveAnchorsKV(long j3, QPlusLiveStatus qPlusLiveStatus, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(0L, null);
    }
}
