package com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.detail.model.BoxType$EnumUnboxingSharedUtility;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1;
import f25.j;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class AdelieTtsInfo {
    public final MutableState playState$delegate;
    public final MutableState state$delegate;
    public String taskId;
    public String ttsExample;
    public String ttsId;
    public j ttsInfo;
    public final MutableState ttsName$delegate;
    public final int type;
    public final int userNum;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AdelieTtsInfo() {
        this(r2, r2, 0, 31);
        String str = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final TtsPlayState getPlayState() {
        return (TtsPlayState) this.playState$delegate.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final AdelieMyTtsVoiceState getState() {
        return (AdelieMyTtsVoiceState) this.state$delegate.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String getTtsName() {
        return (String) this.ttsName$delegate.getValue();
    }

    public final int hashCode() {
        return this.userNum + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.taskId, (BoxType$EnumUnboxingSharedUtility.ordinal(this.type) + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.ttsExample, this.ttsId.hashCode() * 31, 31)) * 31, 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("AdelieTtsInfo(ttsId=");
        m3.append(this.ttsId);
        m3.append(", ttsExample=");
        m3.append(this.ttsExample);
        m3.append(", type=");
        m3.append(AdelieTtsInfoType$EnumUnboxingLocalUtility.stringValueOf(this.type));
        m3.append(", taskId=");
        m3.append(this.taskId);
        m3.append(", userNum=");
        return AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1.m(m3, this.userNum, ')');
    }

    public AdelieTtsInfo(String str, String str2, int i3, String str3, int i16) {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        MutableState mutableStateOf$default3;
        this.ttsId = str;
        this.ttsExample = str2;
        this.type = i3;
        this.taskId = str3;
        this.userNum = i16;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TtsPlayState.NONE, null, 2, null);
        this.playState$delegate = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
        this.ttsName$delegate = mutableStateOf$default2;
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(AdelieMyTtsVoiceState.SUCCESS, null, 2, null);
        this.state$delegate = mutableStateOf$default3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdelieTtsInfo)) {
            return false;
        }
        AdelieTtsInfo adelieTtsInfo = (AdelieTtsInfo) obj;
        return Intrinsics.areEqual(this.ttsId, adelieTtsInfo.ttsId) && Intrinsics.areEqual(this.ttsExample, adelieTtsInfo.ttsExample) && this.type == adelieTtsInfo.type && Intrinsics.areEqual(this.taskId, adelieTtsInfo.taskId) && this.userNum == adelieTtsInfo.userNum;
    }

    public /* synthetic */ AdelieTtsInfo(String str, String str2, int i3, int i16) {
        this((i16 & 1) != 0 ? "none_voice" : str, (i16 & 2) != 0 ? "" : str2, (i16 & 4) != 0 ? 2 : i3, (i16 & 8) != 0 ? "" : null, 0);
    }
}
