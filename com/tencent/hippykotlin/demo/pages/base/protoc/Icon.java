package com.tencent.hippykotlin.demo.pages.base.protoc;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class Icon implements ISSOModel {
    public final String eventCode;
    public final String img;

    /* renamed from: msg, reason: collision with root package name */
    public final String f114183msg;
    public final String url;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Icon() {
        this(r0, r0, 15);
        String str = null;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.v("msg", this.f114183msg);
        eVar.v("url", this.url);
        eVar.v("img", this.img);
        eVar.v("event_code", this.eventCode);
        return eVar;
    }

    public final int hashCode() {
        return this.eventCode.hashCode() + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.img, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.url, this.f114183msg.hashCode() * 31, 31), 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("Icon(msg=");
        m3.append(this.f114183msg);
        m3.append(", url=");
        m3.append(this.url);
        m3.append(", img=");
        m3.append(this.img);
        m3.append(", eventCode=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.eventCode, ')');
    }

    public Icon(String str, String str2, String str3, String str4) {
        this.f114183msg = str;
        this.url = str2;
        this.img = str3;
        this.eventCode = str4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Icon)) {
            return false;
        }
        Icon icon = (Icon) obj;
        return Intrinsics.areEqual(this.f114183msg, icon.f114183msg) && Intrinsics.areEqual(this.url, icon.url) && Intrinsics.areEqual(this.img, icon.img) && Intrinsics.areEqual(this.eventCode, icon.eventCode);
    }

    public /* synthetic */ Icon(String str, String str2, int i3) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : null, (i3 & 4) != 0 ? "" : str2, (i3 & 8) == 0 ? null : "");
    }
}
