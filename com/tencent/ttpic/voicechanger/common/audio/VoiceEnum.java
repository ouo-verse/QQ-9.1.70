package com.tencent.ttpic.voicechanger.common.audio;

import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public enum VoiceEnum {
    naughtyKid("\u718a\u5b69\u5b50", 6, -1, false),
    strongCurrent("\u5f3a\u7535\u6d41", 10, 4, false),
    heavyMachine("\u91cd\u673a\u68b0", 10, 20, false),
    cagedAnimal("\u56f0\u517d", 13, 1, false),
    flu("\u611f\u5192", 536936433, 50, false),
    foreigner("\u6b6a\u679c\u4ec1", -1, 5, false),
    heavyMetal("\u91cd\u91d1\u5c5e", -1, 9, false),
    fatMan("\u6b7b\u80a5\u4ed4", 13, -1, false),
    loli("\u841d\u8389", 4, -1, false),
    uncle("\u5927\u53d4", 5, -1, false),
    ethereal("\u7a7a\u7075", -1, 2, false);

    private int environment;
    private String name;
    private boolean speedChange;
    private int voiceKind;

    VoiceEnum(String str, int i3, int i16, boolean z16) {
        this.name = str;
        this.voiceKind = i3;
        this.environment = i16;
        this.speedChange = z16;
    }

    public static VoiceEnum getDefault() {
        return loli;
    }

    public static String getNameByValues(int i3, int i16) {
        for (VoiceEnum voiceEnum : values()) {
            if (i3 == voiceEnum.voiceKind && i16 == voiceEnum.environment) {
                return voiceEnum.name;
            }
        }
        return getDefault().name;
    }

    public static VoiceEnum getVoiceByName(String str) {
        for (VoiceEnum voiceEnum : values()) {
            if (voiceEnum.name.equals(str)) {
                return voiceEnum;
            }
        }
        return getDefault();
    }

    public static VoiceEnum getVoiceByValues(int i3, int i16) {
        for (VoiceEnum voiceEnum : values()) {
            if (i3 == voiceEnum.voiceKind && i16 == voiceEnum.environment) {
                return voiceEnum;
            }
        }
        return getDefault();
    }

    public static List<String> getVoiceNameList() {
        ArrayList arrayList = new ArrayList();
        for (VoiceEnum voiceEnum : values()) {
            arrayList.add(voiceEnum.name);
        }
        return arrayList;
    }

    public int getEnvironment() {
        return this.environment;
    }

    public String getName() {
        return this.name;
    }

    public int getVoiceKind() {
        return this.voiceKind;
    }

    @Override // java.lang.Enum
    public String toString() {
        return super.toString() + this.name + "(" + this.voiceKind + ", " + this.environment + ", " + this.speedChange + ")";
    }
}
