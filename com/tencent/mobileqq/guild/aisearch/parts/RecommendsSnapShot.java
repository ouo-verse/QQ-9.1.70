package com.tencent.mobileqq.guild.aisearch.parts;

import com.tencent.mobileqq.guild.aisearch.models.AISearchRecommendRepository;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/parts/RecommendsSnapShot;", "", "", "a", "", "Lcom/tencent/mobileqq/guild/aisearch/models/AISearchRecommendRepository$RecommendItem;", "snapshot", "", "c", "b", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "TAG", "Lcom/tencent/mobileqq/guild/base/a;", "Lcom/tencent/mobileqq/qmmkv/v2/MMKVOptionEntityV2;", "Lcom/tencent/mobileqq/guild/base/a;", "getMmkv", "()Lcom/tencent/mobileqq/guild/base/a;", "mmkv", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class RecommendsSnapShot {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final RecommendsSnapShot f214217a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String TAG;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final com.tencent.mobileqq.guild.base.a<MMKVOptionEntityV2> mmkv;

    static {
        RecommendsSnapShot recommendsSnapShot = new RecommendsSnapShot();
        f214217a = recommendsSnapShot;
        TAG = recommendsSnapShot.a();
        mmkv = new RecommendsSnapShot$special$$inlined$newAccountAwareServiceHolder$default$1(null, null);
    }

    RecommendsSnapShot() {
    }

    private final String a() {
        return "RecommendsSnapShot";
    }

    @NotNull
    public final List<AISearchRecommendRepository.RecommendItem> b() {
        Integer num;
        List<AISearchRecommendRepository.RecommendItem> listOf;
        long currentTimeMillis = System.currentTimeMillis();
        List<AISearchRecommendRepository.RecommendItem> a16 = AISearchRecommendRepository.RecommendItem.INSTANCE.a(mmkv.getValue().getBytes(f214217a.a(), new byte[0]));
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        Logger logger = Logger.f235387a;
        String str = TAG;
        Logger.a d16 = logger.d();
        if (a16 != null) {
            num = Integer.valueOf(a16.size());
        } else {
            num = null;
        }
        d16.i(str, 1, "load mmkv size=" + num + " cost=" + currentTimeMillis2);
        if (a16 == null) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(new AISearchRecommendRepository.RecommendItem.TitleText("\u6b22\u8fce\u4f7f\u7528\u9891\u9053\u95ee\u95ee", "\u57fa\u4e8eAI\u6df1\u5ea6\u89e3\u6790\u6d77\u91cf\u9891\u9053\u5185\u5bb9\uff0c\u5e2e\u4f60\u5feb\u901f\u627e\u7b54\u6848"));
            return listOf;
        }
        return a16;
    }

    public final void c(@NotNull List<? extends AISearchRecommendRepository.RecommendItem> snapshot) {
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        Logger logger = Logger.f235387a;
        logger.d().i(TAG, 1, "save mmkv");
        mmkv.getValue().putBytes(a(), AISearchRecommendRepository.RecommendItem.INSTANCE.b(snapshot));
    }
}
