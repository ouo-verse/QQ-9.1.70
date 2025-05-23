package com.tencent.filament.zplan.util;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequenceBuilderKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0010\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000\u001a\u001a\u0010\u0007\u001a\u00020\u0000*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0000\u00a8\u0006\b"}, d2 = {"Lorg/json/JSONArray;", "Lkotlin/sequences/Sequence;", "", "a", "Lorg/json/JSONObject;", "name", AdMetricTag.FALLBACK, "b", "zplan-android_release"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class JsonUtilKt {
    @NotNull
    public static final Sequence<String> a(@NotNull JSONArray asStringSequence) {
        Sequence<String> sequence;
        Intrinsics.checkNotNullParameter(asStringSequence, "$this$asStringSequence");
        sequence = SequencesKt__SequenceBuilderKt.sequence(new JsonUtilKt$asStringSequence$1(asStringSequence, null));
        return sequence;
    }

    @NotNull
    public static final JSONArray b(@NotNull JSONObject optJSONArray, @NotNull String name, @NotNull JSONArray fallback) {
        Intrinsics.checkNotNullParameter(optJSONArray, "$this$optJSONArray");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(fallback, "fallback");
        JSONArray optJSONArray2 = optJSONArray.optJSONArray(name);
        if (optJSONArray2 != null) {
            return optJSONArray2;
        }
        return fallback;
    }
}
