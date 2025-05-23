package com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts;

import com.tencent.hippykotlin.demo.pages.adelie.common.compose.util.ListStateHolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class AdelieTtsDataManager {
    public static final AdelieTtsDataManager INSTANCE = new AdelieTtsDataManager();
    public static final ListStateHolder<AdelieTtsInfo> myTtsInfoList = new ListStateHolder<>();
    public static AdelieTtsInfo noneVoiceTtsInfo = new AdelieTtsInfo(null, null, 0, 31);
    public static final List<AdelieTtsInfo> officialTtsInfoList = new ArrayList();
    public static final List<AdelieTtsInfo> ttsInfoList = new ArrayList();
    public static String preSelectTtsId = "";

    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.List<com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsInfo>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.util.List<com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsInfo>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.util.List<com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsInfo>, java.util.ArrayList] */
    public final void addTtsInfo(AdelieTtsInfo adelieTtsInfo, int i3) {
        int size;
        Integer valueOf = Integer.valueOf(i3);
        if (!(valueOf.intValue() != -1)) {
            valueOf = null;
        }
        if (valueOf != null) {
            size = valueOf.intValue();
        } else {
            size = ttsInfoList.size();
        }
        ttsInfoList.add(size, adelieTtsInfo);
        int i16 = adelieTtsInfo.type;
        if (i16 == 1) {
            noneVoiceTtsInfo = adelieTtsInfo;
        } else if (i16 == 2) {
            officialTtsInfoList.add(adelieTtsInfo);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List<com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsInfo>, java.util.ArrayList] */
    public final AdelieTtsInfo getSelectTtsInfo() {
        Object obj;
        Iterator it = ttsInfoList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            AdelieTtsInfo adelieTtsInfo = (AdelieTtsInfo) obj;
            if (adelieTtsInfo.getPlayState() == TtsPlayState.PLAYING || adelieTtsInfo.getPlayState() == TtsPlayState.COMPLETED) {
                break;
            }
        }
        return (AdelieTtsInfo) obj;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List<com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsInfo>, java.util.ArrayList] */
    public final AdelieTtsInfo getTtsInfoById(String str) {
        Object obj;
        Iterator it = ttsInfoList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((AdelieTtsInfo) obj).ttsId, str)) {
                break;
            }
        }
        return (AdelieTtsInfo) obj;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List<com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsInfo>, java.util.ArrayList] */
    public final AdelieTtsInfo getTtsInfoByTaskId(String str) {
        Object obj;
        Iterator it = ttsInfoList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((AdelieTtsInfo) obj).taskId, str)) {
                break;
            }
        }
        return (AdelieTtsInfo) obj;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List<com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsInfo>, java.util.ArrayList] */
    public final boolean hasVoiceIsCreate() {
        Object obj;
        Iterator it = ttsInfoList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((AdelieTtsInfo) obj).getState() == AdelieMyTtsVoiceState.LOADING) {
                break;
            }
        }
        return obj != null;
    }
}
