package com.tencent.mobileqq.guild.discoveryv2.content.recommend;

import com.tencent.mobileqq.guild.base.repository.AccountChangedNotifier;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R$\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR<\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u000e2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u000e8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/a;", "Lcom/tencent/mobileqq/guild/base/repository/a;", "", "c", "", "account", "onAccountChanged", "", "<set-?>", "e", "I", "b", "()I", "TOTAL_PLAYING_MAX_COUNT", "", "f", "Ljava/util/Map;", "a", "()Ljava/util/Map;", "MAX_PLAYING_COUNT_BY_TYPE", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a implements com.tencent.mobileqq.guild.base.repository.a {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f217096d;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static int TOTAL_PLAYING_MAX_COUNT;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static Map<String, Integer> MAX_PLAYING_COUNT_BY_TYPE;

    static {
        Map<String, Integer> mapOf;
        a aVar = new a();
        f217096d = aVar;
        TOTAL_PLAYING_MAX_COUNT = 2;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("Ad", 2), TuplesKt.to("VideoFeed", 0), TuplesKt.to("Live", 1));
        MAX_PLAYING_COUNT_BY_TYPE = mapOf;
        aVar.c();
        AccountChangedNotifier.f214789d.a(aVar);
    }

    a() {
    }

    private final void c() {
        Object m476constructorimpl;
        JSONObject optJSONObject;
        Map emptyMap;
        Sequence asSequence;
        String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("MVPFeedsConfig", "");
        try {
            Result.Companion companion = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(new JSONObject(loadAsString));
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        if (Result.m482isFailureimpl(m476constructorimpl)) {
            m476constructorimpl = null;
        }
        JSONObject jSONObject = (JSONObject) m476constructorimpl;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("videoPlayConfig")) == null) {
            return;
        }
        TOTAL_PLAYING_MAX_COUNT = optJSONObject.optInt("maxPlayingCount", 2);
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("supportTypes");
        if (optJSONObject2 == null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
        } else {
            Iterator keys = optJSONObject2.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "supportTypesJson.keys()");
            asSequence = SequencesKt__SequencesKt.asSequence(keys);
            emptyMap = new LinkedHashMap();
            for (Object obj : asSequence) {
                emptyMap.put(obj, Integer.valueOf(optJSONObject2.optInt((String) obj, 2)));
            }
        }
        MAX_PLAYING_COUNT_BY_TYPE = emptyMap;
        Logger.f235387a.d().d("MVPFeedsPlayConfig", 1, "refreshConfig: " + jSONObject);
    }

    @NotNull
    public final Map<String, Integer> a() {
        return MAX_PLAYING_COUNT_BY_TYPE;
    }

    public final int b() {
        return TOTAL_PLAYING_MAX_COUNT;
    }

    @Override // com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        c();
    }
}
