package com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes31.dex */
public final class QPlusLiveStatus implements ISSOReqModel, ISSORspModel<QPlusLiveStatus> {
    public final String cover;
    public final String headImgUrl;
    public final String jumpUrl;
    public final String name;
    public final long roomId;
    public final int stat;
    public final long uid;
    public final int videoBeginTimestamp;

    public QPlusLiveStatus() {
        this(0L, 0L, 0, 0, null, null, null, null, 255, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.u("uid", this.uid);
        eVar.u(AudienceReportConst.ROOM_ID, this.roomId);
        eVar.t("stat", this.stat);
        eVar.t("video_begin_timestamp", this.videoBeginTimestamp);
        eVar.v("jump_url", this.jumpUrl);
        eVar.v("name", this.name);
        eVar.v("head_img_url", this.headImgUrl);
        eVar.v("cover", this.cover);
        return eVar;
    }

    public QPlusLiveStatus(long j3, long j16, int i3, int i16, String str, String str2, String str3, String str4) {
        this.uid = j3;
        this.roomId = j16;
        this.stat = i3;
        this.videoBeginTimestamp = i16;
        this.jumpUrl = str;
        this.name = str2;
        this.headImgUrl = str3;
        this.cover = str4;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QPlusLiveStatus decode(e eVar) {
        return new QPlusLiveStatus(eVar.o("uid", 0L), eVar.o(AudienceReportConst.ROOM_ID, 0L), eVar.k("stat", 0), eVar.k("video_begin_timestamp", 0), eVar.q("jump_url", ""), eVar.q("name", ""), eVar.q("head_img_url", ""), eVar.q("cover", ""));
    }

    public /* synthetic */ QPlusLiveStatus(long j3, long j16, int i3, int i16, String str, String str2, String str3, String str4, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(0L, 0L, 0, 0, "", "", "", "");
    }
}
