package com.tencent.mobileqq.wink.model;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import tl.h;
import uq3.k;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0014\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00030\u0002J\u0006\u0010\b\u001a\u00020\u0007R\u001b\u0010\r\u001a\u00020\t8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\n\u001a\u0004\b\u000b\u0010\fR'\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0013\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0015\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/wink/model/QQWinkPublishTagGuideManager;", "", "Lkotlin/Pair;", "", h.F, "", "g", "", "b", "Ljava/text/SimpleDateFormat;", "Lkotlin/Lazy;", "c", "()Ljava/text/SimpleDateFormat;", "formatter", "f", "()Lkotlin/Pair;", "negFeedbackLimits", "e", "()I", "negFeedbackCountLimitForever", "d", "negFeedbackCountLimit7days", "<init>", "()V", "qq-wink-temp-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class QQWinkPublishTagGuideManager {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final QQWinkPublishTagGuideManager f323986a = new QQWinkPublishTagGuideManager();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy formatter;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy negFeedbackLimits;

    static {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<SimpleDateFormat>() { // from class: com.tencent.mobileqq.wink.model.QQWinkPublishTagGuideManager$formatter$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SimpleDateFormat invoke() {
                return new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT, Locale.getDefault());
            }
        });
        formatter = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Pair<? extends Integer, ? extends Integer>>() { // from class: com.tencent.mobileqq.wink.model.QQWinkPublishTagGuideManager$negFeedbackLimits$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Pair<? extends Integer, ? extends Integer> invoke() {
                Pair<? extends Integer, ? extends Integer> h16;
                h16 = QQWinkPublishTagGuideManager.f323986a.h();
                return h16;
            }
        });
        negFeedbackLimits = lazy2;
    }

    QQWinkPublishTagGuideManager() {
    }

    private final Pair<Integer, Integer> f() {
        return (Pair) negFeedbackLimits.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Pair<Integer, Integer> h() {
        boolean isBlank;
        Object obj;
        Object obj2;
        Pair<Integer, Integer> pair;
        String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("102627", "");
        isBlank = StringsKt__StringsJVMKt.isBlank(loadAsString);
        Object obj3 = 3;
        Object obj4 = 5;
        if (isBlank) {
            pair = TuplesKt.to(obj4, obj3);
        } else {
            try {
                Result.Companion companion = Result.INSTANCE;
                obj = Result.m476constructorimpl(Integer.valueOf(new JSONObject(loadAsString).optInt("close_times_for_show_never", 5)));
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                obj = Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            if (Result.m479exceptionOrNullimpl(obj) == null) {
                obj4 = obj;
            }
            int intValue = ((Number) obj4).intValue();
            try {
                obj2 = Result.m476constructorimpl(Integer.valueOf(new JSONObject(loadAsString).optInt("close_times_for_show_after_7_days", 3)));
            } catch (Throwable th6) {
                Result.Companion companion3 = Result.INSTANCE;
                obj2 = Result.m476constructorimpl(ResultKt.createFailure(th6));
            }
            if (Result.m479exceptionOrNullimpl(obj2) == null) {
                obj3 = obj2;
            }
            pair = TuplesKt.to(Integer.valueOf(intValue), Integer.valueOf(((Number) obj3).intValue()));
        }
        QLog.i("QQWinkPublishTagGuideManager", 1, "[initNegFeedbackCountLimit] " + pair);
        return pair;
    }

    public final void b() {
        k.a().r("mmkv_key_publish_tag_guide_neg_feedback");
    }

    @NotNull
    public final SimpleDateFormat c() {
        return (SimpleDateFormat) formatter.getValue();
    }

    public final int d() {
        return f().getSecond().intValue();
    }

    public final int e() {
        return f().getFirst().intValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0047, code lost:
    
        r1 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r1);
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Pair<String, Integer> g() {
        String str;
        List<String> groupValues;
        Integer intOrNull;
        List<String> groupValues2;
        String record = k.a().h("mmkv_key_publish_tag_guide_neg_feedback", "");
        Regex regex = new Regex("(\\d{4}-\\d{2}-\\d{2})-(\\d)");
        Intrinsics.checkNotNullExpressionValue(record, "record");
        int i3 = 0;
        MatchResult find$default = Regex.find$default(regex, record, 0, 2, null);
        if (find$default == null || (groupValues2 = find$default.getGroupValues()) == null || (str = groupValues2.get(1)) == null) {
            str = "1970-01-01";
        }
        if (find$default != null && (groupValues = find$default.getGroupValues()) != null && (r1 = groupValues.get(2)) != null && intOrNull != null) {
            i3 = intOrNull.intValue();
        }
        QLog.i("QQWinkPublishTagGuideManager", 1, "[getNegFeedbackRecord] record=" + record + ", time=" + str + ", count=" + i3);
        return new Pair<>(str, Integer.valueOf(i3));
    }
}
