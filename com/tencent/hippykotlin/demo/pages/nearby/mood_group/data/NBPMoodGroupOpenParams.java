package com.tencent.hippykotlin.demo.pages.nearby.mood_group.data;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.QQAudioParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.kuikly.core.pager.g;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* loaded from: classes31.dex */
public final class NBPMoodGroupOpenParams {
    public static final Companion Companion = new Companion();
    public final String attachConfig;
    public final int autoJoin;
    public final int mid;
    public final int source;

    public NBPMoodGroupOpenParams(int i3, int i16, int i17, String str) {
        this.source = i3;
        this.mid = i16;
        this.autoJoin = i17;
        this.attachConfig = str;
    }

    public final int hashCode() {
        int m3 = QQAudioParams$$ExternalSyntheticOutline0.m(this.autoJoin, QQAudioParams$$ExternalSyntheticOutline0.m(this.mid, this.source * 31, 31), 31);
        String str = this.attachConfig;
        return m3 + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("NBPMoodGroupOpenParams(source=");
        m3.append(this.source);
        m3.append(", mid=");
        m3.append(this.mid);
        m3.append(", autoJoin=");
        m3.append(this.autoJoin);
        m3.append(", attachConfig=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.attachConfig, ')');
    }

    /* loaded from: classes31.dex */
    public static final class Companion {
        public final NBPMoodGroupOpenParams parse(g gVar) {
            String str = null;
            try {
                Object[] sharePenetratePageData = QQNearbyModule.Companion.getInstance().getSharePenetratePageData();
                Object orNull = sharePenetratePageData != null ? ArraysKt___ArraysKt.getOrNull(sharePenetratePageData, 0) : null;
                byte[] bArr = orNull instanceof byte[] ? (byte[]) orNull : null;
                if (bArr != null) {
                    str = StringsKt__StringsJVMKt.decodeToString(bArr);
                }
            } catch (Exception unused) {
            }
            QQNearbyModule.Companion.getInstance().setSharePenetratePageData(new byte[0]);
            return new NBPMoodGroupOpenParams(gVar.n().k("nbp_source", 0), gVar.n().j("mid"), gVar.n().k("auto_join", 0), str);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NBPMoodGroupOpenParams)) {
            return false;
        }
        NBPMoodGroupOpenParams nBPMoodGroupOpenParams = (NBPMoodGroupOpenParams) obj;
        return this.source == nBPMoodGroupOpenParams.source && this.mid == nBPMoodGroupOpenParams.mid && this.autoJoin == nBPMoodGroupOpenParams.autoJoin && Intrinsics.areEqual(this.attachConfig, nBPMoodGroupOpenParams.attachConfig);
    }
}
