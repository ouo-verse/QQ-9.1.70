package com.tencent.tavkit.composition.builder;

import java.util.HashMap;
import java.util.List;

/* loaded from: classes26.dex */
class AudioParamsInfo {
    List<AudioInfo> audioInfos;
    HashMap<String, AudioTransitionInfo> transitionMap;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AudioParamsInfo(List<AudioInfo> list, HashMap<String, AudioTransitionInfo> hashMap) {
        this.audioInfos = list;
        this.transitionMap = hashMap;
    }
}
