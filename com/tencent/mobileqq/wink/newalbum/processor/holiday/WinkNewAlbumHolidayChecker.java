package com.tencent.mobileqq.wink.newalbum.processor.holiday;

import android.text.TextUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.tencent.ark.ark;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQCustomArkDialogUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J&\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J$\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\fR'\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R'\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/wink/newalbum/processor/holiday/WinkNewAlbumHolidayChecker;", "", "", DownloadInfo.spKey_Config, "defaultConfig", "", "Lcom/tencent/mobileqq/wink/newalbum/processor/holiday/a;", "e", ark.ARKMETADATA_JSON, "holidayMap", "", "f", "Lz83/a;", QQCustomArkDialogUtil.META_DATA, "b", "Lkotlin/Lazy;", "c", "()Ljava/util/Map;", "lunarHolidayMap", "d", "solarHolidayMap", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkNewAlbumHolidayChecker {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final WinkNewAlbumHolidayChecker f324258a = new WinkNewAlbumHolidayChecker();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy lunarHolidayMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy solarHolidayMap;

    static {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Map<String, Festival>>() { // from class: com.tencent.mobileqq.wink.newalbum.processor.holiday.WinkNewAlbumHolidayChecker$lunarHolidayMap$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Map<String, Festival> invoke() {
                Map<String, Festival> e16;
                e16 = WinkNewAlbumHolidayChecker.f324258a.e(w83.b.f445025a.g(), "{\n    \"1_1\": [\"\u6625\u8282\", \"dapian_yuanxiangji\", \"dapian_fuguluxiang\", \"dapian_zaiyujian\", \"dapian_meirixinqing\"],\n    \"1_15\": [\"\u5143\u5bb5\u8282\", \"dapian_yuanxiangji\", \"dapian_fuguluxiang\", \"dapian_zaiyujian\", \"dapian_meirixinqing\"],\n    \"5_5\": [\"\u7aef\u5348\u8282\", \"dapian_yuanxiangji\", \"dapian_fuguluxiang\", \"dapian_zaiyujian\", \"dapian_meirixinqing\"],\n    \"7_7\": [\"\u4e03\u5915\", \"dapian_yuanxiangji\", \"dapian_fuguluxiang\", \"dapian_zaiyujian\", \"dapian_meirixinqing\"],\n    \"8_15\": [\"\u4e2d\u79cb\u8282\", \"dapian_yuanxiangji\", \"dapian_fuguluxiang\", \"dapian_zaiyujian\", \"dapian_meirixinqing\"]\n}");
                return e16;
            }
        });
        lunarHolidayMap = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Map<String, Festival>>() { // from class: com.tencent.mobileqq.wink.newalbum.processor.holiday.WinkNewAlbumHolidayChecker$solarHolidayMap$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Map<String, Festival> invoke() {
                Map<String, Festival> e16;
                e16 = WinkNewAlbumHolidayChecker.f324258a.e(w83.b.f445025a.D(), "{\n    \"1_1\": [\"\u5143\u65e6\", \"dapian_yuanxiangji\", \"dapian_fuguluxiang\", \"dapian_zaiyujian\", \"dapian_meirixinqing\"],\n    \"2_14\": [\"\u60c5\u4eba\u8282\", \"dapian_yuanxiangji\", \"dapian_fuguluxiang\", \"dapian_zaiyujian\", \"dapian_meirixinqing\"],\n    \"5_1\": [\"\u52b3\u52a8\u8282\", \"dapian_yuanxiangji\", \"dapian_fuguluxiang\", \"dapian_zaiyujian\", \"dapian_meirixinqing\"],\n    \"10_1\": [\"\u56fd\u5e86\u8282\", \"dapian_yuanxiangji\", \"dapian_fuguluxiang\", \"dapian_zaiyujian\", \"dapian_meirixinqing\"],\n    \"12_25\": [\"\u5723\u8bde\u8282\", \"dapian_yuanxiangji\", \"dapian_fuguluxiang\", \"dapian_zaiyujian\", \"dapian_meirixinqing\"]\n}");
                return e16;
            }
        });
        solarHolidayMap = lazy2;
    }

    WinkNewAlbumHolidayChecker() {
    }

    private final Map<String, Festival> c() {
        return (Map) lunarHolidayMap.getValue();
    }

    private final Map<String, Festival> d() {
        return (Map) solarHolidayMap.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, Festival> e(String config, String defaultConfig) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (TextUtils.isEmpty(config)) {
            config = defaultConfig;
        } else {
            Intrinsics.checkNotNull(config);
        }
        try {
            f(config, linkedHashMap);
        } catch (Exception e16) {
            QLog.e("WinkNewAlbumHolidayChecker", 1, e16, new Object[0]);
            try {
                linkedHashMap.clear();
                f(defaultConfig, linkedHashMap);
            } catch (Exception e17) {
                QLog.e("WinkNewAlbumHolidayChecker", 1, e17, new Object[0]);
            }
        }
        return linkedHashMap;
    }

    private final void f(String json, Map<String, Festival> holidayMap) {
        List drop;
        int collectionSizeOrDefault;
        JsonObject asJsonObject = new JsonParser().parse(json).getAsJsonObject();
        for (String key : asJsonObject.keySet()) {
            JsonArray jsonArray = asJsonObject.getAsJsonArray(key);
            String festivalName = jsonArray.get(0).getAsString();
            Intrinsics.checkNotNullExpressionValue(jsonArray, "jsonArray");
            drop = CollectionsKt___CollectionsKt.drop(jsonArray, 1);
            List list = drop;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((JsonElement) it.next()).getAsString());
            }
            Intrinsics.checkNotNullExpressionValue(key, "key");
            Intrinsics.checkNotNullExpressionValue(festivalName, "festivalName");
            holidayMap.put(key, new Festival(key, festivalName, arrayList));
        }
    }

    @Nullable
    public final Festival b(@NotNull z83.a metaData) {
        Intrinsics.checkNotNullParameter(metaData, "metaData");
        String str = metaData.getLunarMonth() + "_" + metaData.getLunarDay();
        if (c().containsKey(str)) {
            return c().get(str);
        }
        String str2 = metaData.getMonth() + "_" + metaData.getDayOfMonth();
        if (d().containsKey(str2)) {
            return d().get(str2);
        }
        return null;
    }
}
