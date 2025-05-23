package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.QQAudioParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import cooperation.peak.PeakConstants;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class PicInfo implements ISSOModel {
    public final String desc;
    public final int height;
    public final int thumbnailHeight;
    public final String thumbnailUrl;
    public final int thumbnailWidth;
    public final String url;
    public final int width;

    public PicInfo() {
        this(null, 0, 0, null, null, 0, 0, 127, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.v("url", this.url);
        eVar.t("width", this.width);
        eVar.t("height", this.height);
        eVar.v("desc", this.desc);
        eVar.v("thumbnail_url", this.thumbnailUrl);
        eVar.t(PeakConstants.VIDEO_THUMBNAIL_WIDTH, this.thumbnailWidth);
        eVar.t(PeakConstants.VIDEO_THUMBNAIL_HEIGHT, this.thumbnailHeight);
        return eVar;
    }

    public final int hashCode() {
        return this.thumbnailHeight + QQAudioParams$$ExternalSyntheticOutline0.m(this.thumbnailWidth, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.thumbnailUrl, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.desc, QQAudioParams$$ExternalSyntheticOutline0.m(this.height, QQAudioParams$$ExternalSyntheticOutline0.m(this.width, this.url.hashCode() * 31, 31), 31), 31), 31), 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("PicInfo(url=");
        m3.append(this.url);
        m3.append(", width=");
        m3.append(this.width);
        m3.append(", height=");
        m3.append(this.height);
        m3.append(", desc=");
        m3.append(this.desc);
        m3.append(", thumbnailUrl=");
        m3.append(this.thumbnailUrl);
        m3.append(", thumbnailWidth=");
        m3.append(this.thumbnailWidth);
        m3.append(", thumbnailHeight=");
        return AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1.m(m3, this.thumbnailHeight, ')');
    }

    public PicInfo(String str, int i3, int i16, String str2, String str3, int i17, int i18) {
        this.url = str;
        this.width = i3;
        this.height = i16;
        this.desc = str2;
        this.thumbnailUrl = str3;
        this.thumbnailWidth = i17;
        this.thumbnailHeight = i18;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PicInfo)) {
            return false;
        }
        PicInfo picInfo = (PicInfo) obj;
        return Intrinsics.areEqual(this.url, picInfo.url) && this.width == picInfo.width && this.height == picInfo.height && Intrinsics.areEqual(this.desc, picInfo.desc) && Intrinsics.areEqual(this.thumbnailUrl, picInfo.thumbnailUrl) && this.thumbnailWidth == picInfo.thumbnailWidth && this.thumbnailHeight == picInfo.thumbnailHeight;
    }

    public /* synthetic */ PicInfo(String str, int i3, int i16, String str2, String str3, int i17, int i18, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this("", 0, 0, "", "", 0, 0);
    }
}
