package com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class AdelieTtsStartParams$Params {
    public String botDesc;
    public int botGender;
    public String botName;
    public String botPrompt;
    public String botWelcome;
    public String ttsId;

    public AdelieTtsStartParams$Params() {
        this(null, null, null, null, null, 0, 63, null);
    }

    public final int hashCode() {
        return this.botGender + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.botDesc, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.botWelcome, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.botPrompt, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.botName, this.ttsId.hashCode() * 31, 31), 31), 31), 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("Params(ttsId=");
        m3.append(this.ttsId);
        m3.append(", botName=");
        m3.append(this.botName);
        m3.append(", botPrompt=");
        m3.append(this.botPrompt);
        m3.append(", botWelcome=");
        m3.append(this.botWelcome);
        m3.append(", botDesc=");
        m3.append(this.botDesc);
        m3.append(", botGender=");
        return AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1.m(m3, this.botGender, ')');
    }

    public AdelieTtsStartParams$Params(String str, String str2, String str3, String str4, String str5, int i3) {
        this.ttsId = str;
        this.botName = str2;
        this.botPrompt = str3;
        this.botWelcome = str4;
        this.botDesc = str5;
        this.botGender = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdelieTtsStartParams$Params)) {
            return false;
        }
        AdelieTtsStartParams$Params adelieTtsStartParams$Params = (AdelieTtsStartParams$Params) obj;
        return Intrinsics.areEqual(this.ttsId, adelieTtsStartParams$Params.ttsId) && Intrinsics.areEqual(this.botName, adelieTtsStartParams$Params.botName) && Intrinsics.areEqual(this.botPrompt, adelieTtsStartParams$Params.botPrompt) && Intrinsics.areEqual(this.botWelcome, adelieTtsStartParams$Params.botWelcome) && Intrinsics.areEqual(this.botDesc, adelieTtsStartParams$Params.botDesc) && this.botGender == adelieTtsStartParams$Params.botGender;
    }

    public /* synthetic */ AdelieTtsStartParams$Params(String str, String str2, String str3, String str4, String str5, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this("none_voice", "", "", "", "", 0);
    }
}
