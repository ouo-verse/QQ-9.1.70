package com.tencent.mobileqq.wink.dailysign;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.winkreport.dengta.WinkDengtaReportConstant;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0019\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 a2\u00020\u0001:\u0001bBS\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u00a2\u0006\u0004\b\\\u0010]B\u0011\b\u0016\u0012\u0006\u0010_\u001a\u00020^\u00a2\u0006\u0004\b\\\u0010`J\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002J\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002JR\u0010\r\u001a\u00020\u00002\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n2\b\b\u0002\u0010\f\u001a\u00020\u0003R*\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R0\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\f\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0013\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u0017R*\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u000e\u001a\u0004\b\"\u0010\u0010\"\u0004\b#\u0010\u0012R(\u0010&\u001a\b\u0012\u0004\u0012\u00020%0$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010\u000e\u001a\u0004\b'\u0010\u0010\"\u0004\b(\u0010\u0012R\"\u0010*\u001a\u00020)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R$\u00100\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R>\u00109\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020706j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u000207`88\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R$\u0010A\u001a\u00020?2\u0006\u0010@\u001a\u00020?8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR$\u0010G\u001a\u00020?2\u0006\u0010@\u001a\u00020?8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bE\u0010B\"\u0004\bF\u0010DR$\u0010J\u001a\u00020?2\u0006\u0010@\u001a\u00020?8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bH\u0010B\"\u0004\bI\u0010DR$\u0010O\u001a\u0002072\u0006\u0010@\u001a\u0002078F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR$\u0010R\u001a\u0002072\u0006\u0010@\u001a\u0002078F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bP\u0010L\"\u0004\bQ\u0010NR$\u0010U\u001a\u0002072\u0006\u0010@\u001a\u0002078F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bS\u0010L\"\u0004\bT\u0010NR$\u0010X\u001a\u0002072\u0006\u0010@\u001a\u0002078F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bV\u0010L\"\u0004\bW\u0010NR$\u0010[\u001a\u0002072\u0006\u0010@\u001a\u0002078F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bY\u0010L\"\u0004\bZ\u0010N\u00a8\u0006c"}, d2 = {"Lcom/tencent/mobileqq/wink/dailysign/DailySignConfig;", "Ljava/io/Serializable;", "Lkotlin/Pair;", "", "getTemplateType", "generateQzoneTemplateType", "", "originMediaPath", "textContent", "missionId", "", "assetDataMap", "from", "copy", "Ljava/util/List;", "getOriginMediaPath", "()Ljava/util/List;", "setOriginMediaPath", "(Ljava/util/List;)V", "Ljava/lang/String;", "getTextContent", "()Ljava/lang/String;", "setTextContent", "(Ljava/lang/String;)V", "getMissionId", "setMissionId", "Ljava/util/Map;", "getAssetDataMap", "()Ljava/util/Map;", "setAssetDataMap", "(Ljava/util/Map;)V", "getFrom", "setFrom", "mediaPath", "getMediaPath", "setMediaPath", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "backGroundPic", "getBackGroundPic", "setBackGroundPic", "", "backGroundPicIndex", "I", "getBackGroundPicIndex", "()I", "setBackGroundPicIndex", "(I)V", "metaMaterial", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "getMetaMaterial", "()Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "setMetaMaterial", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)V", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "costMap", "Ljava/util/HashMap;", "getCostMap", "()Ljava/util/HashMap;", "setCostMap", "(Ljava/util/HashMap;)V", "", "value", "isInited", "()Z", "setInited", "(Z)V", "getNeedDownLoadSo", "setNeedDownLoadSo", "needDownLoadSo", "getNeedDownLoadTemplate", "setNeedDownLoadTemplate", "needDownLoadTemplate", "getDownLoadSoTime", "()J", "setDownLoadSoTime", "(J)V", "downLoadSoTime", "getLoadMateTime", "setLoadMateTime", "loadMateTime", "getLoadPicTime", "setLoadPicTime", "loadPicTime", "getStartTime", "setStartTime", "startTime", "getLoadAllResourceTime", "setLoadAllResourceTime", WinkDengtaReportConstant.Params.AVATAR_SHARE_LOAD_ALL_RESOURCE_TIME, "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)V", "Lcom/tencent/mobileqq/wink/dailysign/af;", "dailySignInfo", "(Lcom/tencent/mobileqq/wink/dailysign/af;)V", "Companion", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class DailySignConfig implements Serializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private Map<String, String> assetDataMap;

    @NotNull
    private List<MetaMaterial> backGroundPic;
    private int backGroundPicIndex;

    @NotNull
    private HashMap<String, Long> costMap;

    @NotNull
    private String from;

    @Nullable
    private List<String> mediaPath;

    @Nullable
    private MetaMaterial metaMaterial;

    @Nullable
    private String missionId;

    @Nullable
    private List<String> originMediaPath;

    @Nullable
    private String textContent;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/wink/dailysign/DailySignConfig$a;", "", "", "row", "", "a", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.dailysign.DailySignConfig$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String a(int row) {
            if (row < 10) {
                return "0" + row;
            }
            return String.valueOf(row);
        }

        Companion() {
        }
    }

    public DailySignConfig() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ DailySignConfig copy$default(DailySignConfig dailySignConfig, List list, String str, String str2, Map map, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = dailySignConfig.originMediaPath;
        }
        if ((i3 & 2) != 0) {
            str = dailySignConfig.textContent;
        }
        String str4 = str;
        if ((i3 & 4) != 0) {
            str2 = dailySignConfig.missionId;
        }
        String str5 = str2;
        if ((i3 & 8) != 0) {
            map = dailySignConfig.assetDataMap;
        }
        Map map2 = map;
        if ((i3 & 16) != 0) {
            str3 = dailySignConfig.from;
        }
        return dailySignConfig.copy(list, str4, str5, map2, str3);
    }

    @NotNull
    public final DailySignConfig copy(@Nullable List<String> originMediaPath, @Nullable String textContent, @Nullable String missionId, @Nullable Map<String, String> assetDataMap, @NotNull String from) {
        Intrinsics.checkNotNullParameter(from, "from");
        DailySignConfig dailySignConfig = new DailySignConfig(originMediaPath, textContent, missionId, assetDataMap, from);
        dailySignConfig.mediaPath = this.mediaPath;
        dailySignConfig.backGroundPic = this.backGroundPic;
        dailySignConfig.backGroundPicIndex = this.backGroundPicIndex;
        dailySignConfig.metaMaterial = this.metaMaterial;
        Object clone = this.costMap.clone();
        Intrinsics.checkNotNull(clone, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Long>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.Long> }");
        dailySignConfig.costMap = (HashMap) clone;
        dailySignConfig.setInited(isInited());
        dailySignConfig.setNeedDownLoadSo(getNeedDownLoadSo());
        dailySignConfig.setNeedDownLoadTemplate(getNeedDownLoadTemplate());
        dailySignConfig.setDownLoadSoTime(getDownLoadSoTime());
        dailySignConfig.setLoadMateTime(getLoadMateTime());
        dailySignConfig.setLoadPicTime(getLoadPicTime());
        dailySignConfig.setStartTime(getStartTime());
        dailySignConfig.setLoadAllResourceTime(getLoadAllResourceTime());
        return dailySignConfig;
    }

    @NotNull
    public final Pair<String, String> generateQzoneTemplateType() {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        List<String> list = this.originMediaPath;
        boolean z27 = false;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            String str = this.textContent;
            if (str != null && str.length() != 0) {
                z26 = false;
            } else {
                z26 = true;
            }
            if (!z26) {
                return TuplesKt.to("qzoneTextImage", "3");
            }
        }
        List<String> list2 = this.originMediaPath;
        if (list2 != null && !list2.isEmpty()) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z17) {
            String str2 = this.textContent;
            if (str2 != null && str2.length() != 0) {
                z19 = false;
            } else {
                z19 = true;
            }
            if (!z19) {
                return TuplesKt.to("qzoneOnlyText", "2");
            }
        }
        List<String> list3 = this.originMediaPath;
        if (list3 != null && !list3.isEmpty()) {
            z18 = false;
        } else {
            z18 = true;
        }
        if (!z18) {
            String str3 = this.textContent;
            if (str3 == null || str3.length() == 0) {
                z27 = true;
            }
            if (z27) {
                return TuplesKt.to("qzoneOnlyImage", "1");
            }
        }
        return TuplesKt.to("normal", "0");
    }

    @Nullable
    public final Map<String, String> getAssetDataMap() {
        return this.assetDataMap;
    }

    @NotNull
    public final List<MetaMaterial> getBackGroundPic() {
        return this.backGroundPic;
    }

    public final int getBackGroundPicIndex() {
        return this.backGroundPicIndex;
    }

    @NotNull
    public final HashMap<String, Long> getCostMap() {
        return this.costMap;
    }

    public final long getDownLoadSoTime() {
        Long l3 = this.costMap.get("downLoadSoTime");
        if (l3 == null) {
            return 0L;
        }
        return l3.longValue();
    }

    @NotNull
    public final String getFrom() {
        return this.from;
    }

    public final long getLoadAllResourceTime() {
        Long l3 = this.costMap.get(WinkDengtaReportConstant.Params.AVATAR_SHARE_LOAD_ALL_RESOURCE_TIME);
        if (l3 == null) {
            return 0L;
        }
        return l3.longValue();
    }

    public final long getLoadMateTime() {
        Long l3 = this.costMap.get("loadMateTime");
        if (l3 == null) {
            return 0L;
        }
        return l3.longValue();
    }

    public final long getLoadPicTime() {
        Long l3 = this.costMap.get("loadPicTime");
        if (l3 == null) {
            return 0L;
        }
        return l3.longValue();
    }

    @Nullable
    public final List<String> getMediaPath() {
        return this.mediaPath;
    }

    @Nullable
    public final MetaMaterial getMetaMaterial() {
        return this.metaMaterial;
    }

    @Nullable
    public final String getMissionId() {
        return this.missionId;
    }

    public final boolean getNeedDownLoadSo() {
        Long l3 = this.costMap.get("needDownloadSo");
        if (l3 != null && l3.longValue() == 1) {
            return true;
        }
        return false;
    }

    public final boolean getNeedDownLoadTemplate() {
        Long l3 = this.costMap.get("needDownloadTemplate");
        if (l3 != null && l3.longValue() == 1) {
            return true;
        }
        return false;
    }

    @Nullable
    public final List<String> getOriginMediaPath() {
        return this.originMediaPath;
    }

    public final long getStartTime() {
        Long l3 = this.costMap.get("startTime");
        if (l3 == null) {
            return 0L;
        }
        return l3.longValue();
    }

    @NotNull
    public final Pair<String, String> getTemplateType() {
        if (Intrinsics.areEqual(this.from, "QZONE")) {
            return generateQzoneTemplateType();
        }
        return TuplesKt.to("normal", "0");
    }

    @Nullable
    public final String getTextContent() {
        return this.textContent;
    }

    public final boolean isInited() {
        Long l3 = this.costMap.get("isInited");
        if (l3 != null && l3.longValue() == 1) {
            return true;
        }
        return false;
    }

    public final void setAssetDataMap(@Nullable Map<String, String> map) {
        this.assetDataMap = map;
    }

    public final void setBackGroundPic(@NotNull List<MetaMaterial> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.backGroundPic = list;
    }

    public final void setBackGroundPicIndex(int i3) {
        this.backGroundPicIndex = i3;
    }

    public final void setCostMap(@NotNull HashMap<String, Long> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "<set-?>");
        this.costMap = hashMap;
    }

    public final void setDownLoadSoTime(long j3) {
        this.costMap.put("downLoadSoTime", Long.valueOf(j3));
    }

    public final void setFrom(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.from = str;
    }

    public final void setInited(boolean z16) {
        long j3;
        HashMap<String, Long> hashMap = this.costMap;
        if (z16) {
            j3 = 1;
        } else {
            j3 = 0;
        }
        hashMap.put("isInited", Long.valueOf(j3));
    }

    public final void setLoadAllResourceTime(long j3) {
        this.costMap.put(WinkDengtaReportConstant.Params.AVATAR_SHARE_LOAD_ALL_RESOURCE_TIME, Long.valueOf(j3));
    }

    public final void setLoadMateTime(long j3) {
        this.costMap.put("loadMateTime", Long.valueOf(j3));
    }

    public final void setLoadPicTime(long j3) {
        this.costMap.put("loadPicTime", Long.valueOf(j3));
    }

    public final void setMediaPath(@Nullable List<String> list) {
        this.mediaPath = list;
    }

    public final void setMetaMaterial(@Nullable MetaMaterial metaMaterial) {
        this.metaMaterial = metaMaterial;
    }

    public final void setMissionId(@Nullable String str) {
        this.missionId = str;
    }

    public final void setNeedDownLoadSo(boolean z16) {
        long j3;
        HashMap<String, Long> hashMap = this.costMap;
        if (z16) {
            j3 = 1;
        } else {
            j3 = 0;
        }
        hashMap.put("needDownloadSo", Long.valueOf(j3));
    }

    public final void setNeedDownLoadTemplate(boolean z16) {
        long j3;
        HashMap<String, Long> hashMap = this.costMap;
        if (z16) {
            j3 = 1;
        } else {
            j3 = 0;
        }
        hashMap.put("needDownloadTemplate", Long.valueOf(j3));
    }

    public final void setOriginMediaPath(@Nullable List<String> list) {
        this.originMediaPath = list;
    }

    public final void setStartTime(long j3) {
        this.costMap.put("startTime", Long.valueOf(j3));
    }

    public final void setTextContent(@Nullable String str) {
        this.textContent = str;
    }

    public DailySignConfig(@Nullable List<String> list, @Nullable String str, @Nullable String str2, @Nullable Map<String, String> map, @NotNull String from) {
        Intrinsics.checkNotNullParameter(from, "from");
        this.originMediaPath = list;
        this.textContent = str;
        this.missionId = str2;
        this.assetDataMap = map;
        this.from = from;
        this.backGroundPic = new ArrayList();
        this.backGroundPicIndex = -1;
        HashMap<String, Long> hashMap = new HashMap<>();
        hashMap.put("isInited", 0L);
        hashMap.put("needDownloadSo", 0L);
        hashMap.put("needDownloadTemplate", 0L);
        hashMap.put("downLoadSoTime", 0L);
        hashMap.put("loadMateTime", 0L);
        hashMap.put("loadPicTime", 0L);
        hashMap.put("startTime", 0L);
        hashMap.put(WinkDengtaReportConstant.Params.AVATAR_SHARE_LOAD_ALL_RESOURCE_TIME, 0L);
        this.costMap = hashMap;
    }

    public /* synthetic */ DailySignConfig(List list, String str, String str2, Map map, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : list, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? null : str2, (i3 & 8) == 0 ? map : null, (i3 & 16) != 0 ? "QCIRCLE" : str3);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DailySignConfig(@NotNull af dailySignInfo) {
        this(null, null, null, null, null, 31, null);
        Intrinsics.checkNotNullParameter(dailySignInfo, "dailySignInfo");
        this.originMediaPath = dailySignInfo.b();
        this.textContent = dailySignInfo.getTextContent();
        this.missionId = dailySignInfo.getMissionId();
    }
}
