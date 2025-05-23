package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.QQAudioParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class VideoPic implements ISSOModel {
    public final String cover;
    public final long duration;
    public final int type;
    public final String url;
    public final String vid;

    public VideoPic() {
        this(null, null, 0, 0L, null, 31, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.v("vid", this.vid);
        eVar.v("url", this.url);
        eVar.t("type", this.type);
        eVar.u("duration", this.duration);
        eVar.v("cover", this.cover);
        return eVar;
    }

    public final int hashCode() {
        return this.cover.hashCode() + AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.duration, QQAudioParams$$ExternalSyntheticOutline0.m(this.type, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.url, this.vid.hashCode() * 31, 31), 31), 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("VideoPic(vid=");
        m3.append(this.vid);
        m3.append(", url=");
        m3.append(this.url);
        m3.append(", type=");
        m3.append(this.type);
        m3.append(", duration=");
        m3.append(this.duration);
        m3.append(", cover=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.cover, ')');
    }

    public VideoPic(String str, String str2, int i3, long j3, String str3) {
        this.vid = str;
        this.url = str2;
        this.type = i3;
        this.duration = j3;
        this.cover = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VideoPic)) {
            return false;
        }
        VideoPic videoPic = (VideoPic) obj;
        return Intrinsics.areEqual(this.vid, videoPic.vid) && Intrinsics.areEqual(this.url, videoPic.url) && this.type == videoPic.type && this.duration == videoPic.duration && Intrinsics.areEqual(this.cover, videoPic.cover);
    }

    public /* synthetic */ VideoPic(String str, String str2, int i3, long j3, String str3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "", 0, 0L, "");
    }
}
