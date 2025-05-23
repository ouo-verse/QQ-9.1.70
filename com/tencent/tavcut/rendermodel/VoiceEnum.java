package com.tencent.tavcut.rendermodel;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/tavcut/rendermodel/VoiceEnum;", "", "voiceKind", "", "environment", "(Ljava/lang/String;III)V", "getEnvironment", "()I", "getVoiceKind", "NAUGHTY_KID", "STRONG_CURRENT", "HEAVY_MACHINE", "SLOWLY", "STUTTER", "ONLINE_CELEBRITY", "CAGED_ANIMAL", "FLU", "FOREIGNER", "HEAVY_METAL", "FAT_MAN", "LOLI", "UNCLE", "ETHEREAL", "FREAKY", "FUNNY", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public enum VoiceEnum {
    NAUGHTY_KID(1, 1),
    STRONG_CURRENT(10, 4),
    HEAVY_MACHINE(10, 20),
    SLOWLY(11, -1),
    STUTTER(12, -1),
    ONLINE_CELEBRITY(9, 51),
    CAGED_ANIMAL(13, 1),
    FLU(536936433, 50),
    FOREIGNER(-1, 5),
    HEAVY_METAL(-1, 9),
    FAT_MAN(13, -1),
    LOLI(4, -1),
    UNCLE(5, -1),
    ETHEREAL(-1, 2),
    FREAKY(8, 3),
    FUNNY(7, -1);

    private final int environment;
    private final int voiceKind;

    VoiceEnum(int i3, int i16) {
        this.voiceKind = i3;
        this.environment = i16;
    }

    public final int getEnvironment() {
        return this.environment;
    }

    public final int getVoiceKind() {
        return this.voiceKind;
    }
}
