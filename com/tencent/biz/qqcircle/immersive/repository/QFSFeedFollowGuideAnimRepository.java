package com.tencent.biz.qqcircle.immersive.repository;

import com.tencent.biz.qqcircle.widgets.comment.b;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;
import uq3.c;
import uq3.k;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0006\u001a\u00020\u0004H\u0007J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0007R\u001b\u0010\u000e\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/repository/QFSFeedFollowGuideAnimRepository;", "", "", "posterUin", "", "a", "c", "", "e", "d", "", "b", "Lkotlin/Lazy;", "()I", "maxPlayCountToAllByConfig", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSFeedFollowGuideAnimRepository {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final QFSFeedFollowGuideAnimRepository f89742a = new QFSFeedFollowGuideAnimRepository();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy maxPlayCountToAllByConfig;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.biz.qqcircle.immersive.repository.QFSFeedFollowGuideAnimRepository$maxPlayCountToAllByConfig$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                Integer X0 = c.X0("qqcircle", "qqcircle_feed_follow_animation_max_play_count", 5);
                QLog.i("QFSFeedFollowGuideAnimRepository", 1, "maxPlayCountToAllByConfig, value = " + X0);
                return X0;
            }
        });
        maxPlayCountToAllByConfig = lazy;
    }

    QFSFeedFollowGuideAnimRepository() {
    }

    @JvmStatic
    public static final boolean a(@NotNull String posterUin) {
        Intrinsics.checkNotNullParameter(posterUin, "posterUin");
        JSONObject jSONObject = new JSONObject(k.a().h("sp_key_left_play_count_to_poster_in_natural_day", "{}"));
        String optString = jSONObject.optString("date");
        String c16 = b.c(System.currentTimeMillis(), "");
        QLog.i("QFSFeedFollowGuideAnimRepository", 1, "canPlayToPosterInNaturalDay, posterUin=" + posterUin + ", currentDate=" + c16 + ", leftPlayCountToPosterJSONObject=" + jSONObject);
        if (Intrinsics.areEqual(c16, optString)) {
            JSONArray jSONArray = jSONObject.getJSONArray("posterList");
            if (jSONArray == null) {
                jSONArray = new JSONArray();
            }
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                if (Intrinsics.areEqual(jSONArray.get(i3), posterUin)) {
                    return false;
                }
            }
        }
        return true;
    }

    private final int b() {
        Object value = maxPlayCountToAllByConfig.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-maxPlayCountToAllByConfig>(...)");
        return ((Number) value).intValue();
    }

    @JvmStatic
    public static final boolean c() {
        QFSFeedFollowGuideAnimRepository qFSFeedFollowGuideAnimRepository = f89742a;
        if (qFSFeedFollowGuideAnimRepository.b() <= 0) {
            QLog.i("QFSFeedFollowGuideAnimRepository", 1, "hasLeftPlayCountToAllInNaturalDay, maxPlayCountToAllByConfig is 0");
            return false;
        }
        JSONObject jSONObject = new JSONObject(k.a().h("sp_key_left_play_count_to_all_in_natural_day", "{}"));
        String optString = jSONObject.optString("date");
        String c16 = b.c(System.currentTimeMillis(), "");
        QLog.i("QFSFeedFollowGuideAnimRepository", 1, "hasLeftPlayCountToAllInNaturalDay,currentDate=" + c16 + ", leftPlayCountToAllJSONObject=" + jSONObject);
        if (Intrinsics.areEqual(c16, optString) && jSONObject.optInt("playCount") >= qFSFeedFollowGuideAnimRepository.b()) {
            return false;
        }
        return true;
    }

    public final void d() {
        int i3 = 1;
        QLog.i("QFSFeedFollowGuideAnimRepository", 1, "increasePlayCountToAllInNatureDay");
        JSONObject jSONObject = new JSONObject(k.a().h("sp_key_left_play_count_to_all_in_natural_day", "{}"));
        String optString = jSONObject.optString("date");
        String c16 = b.c(System.currentTimeMillis(), "");
        if (Intrinsics.areEqual(c16, optString)) {
            i3 = 1 + jSONObject.optInt("playCount");
        }
        jSONObject.put("date", c16);
        jSONObject.put("playCount", i3);
        k.a().p("sp_key_left_play_count_to_all_in_natural_day", jSONObject.toString());
    }

    public final void e(@NotNull String posterUin) {
        JSONArray jSONArray;
        Intrinsics.checkNotNullParameter(posterUin, "posterUin");
        QLog.i("QFSFeedFollowGuideAnimRepository", 1, "increasePlayCountToPosterInNatureDay, posterUin=" + posterUin);
        JSONObject jSONObject = new JSONObject(k.a().h("sp_key_left_play_count_to_poster_in_natural_day", "{}"));
        String optString = jSONObject.optString("date");
        String c16 = b.c(System.currentTimeMillis(), "");
        if (!Intrinsics.areEqual(c16, optString)) {
            jSONArray = new JSONArray();
            jSONArray.mo162put(posterUin);
        } else {
            jSONArray = jSONObject.getJSONArray("posterList");
            if (jSONArray == null) {
                jSONArray = new JSONArray();
            }
            jSONArray.mo162put(posterUin);
        }
        jSONObject.put("date", c16);
        jSONObject.put("posterList", jSONArray);
        k.a().p("sp_key_left_play_count_to_poster_in_natural_day", jSONObject.toString());
    }
}
