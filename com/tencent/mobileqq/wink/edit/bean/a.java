package com.tencent.mobileqq.wink.edit.bean;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MediaInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import qshadow.ShadowInspirationAI$InspirationMediaInfo;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b&\u0010'J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0006j\b\u0012\u0004\u0012\u00020\u0002`\u0007J\u0016\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002J\"\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00020\fj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0002`\rR\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0011R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0011R\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0011R\u0016\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0016\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001bR$\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0006j\b\u0012\u0004\u0012\u00020\u0002`\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R0\u0010%\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00020\fj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0002`\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/wink/edit/bean/a;", "", "", "path", "", "a", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "b", "", "index", "d", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "c", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MediaInfo;", "Ljava/util/List;", "processedMediaInfos", "Lqshadow/ShadowInspirationAI$InspirationMediaInfo;", "inspirationAIMediaInfos", "mutipleIndexes", "Ljava/lang/String;", "processedExtra", "e", "busiID", "f", "I", "g", "reqId", h.F, "originalMediaIndex", "i", "Ljava/util/ArrayList;", "fullSpaceARLocalMediaFilePathList", "j", "Ljava/util/HashMap;", "localMediaFilePathMap", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public List<? extends MediaInfo> processedMediaInfos;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public List<ShadowInspirationAI$InspirationMediaInfo> inspirationAIMediaInfos;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public List<Integer> mutipleIndexes;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public String processedExtra;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public String busiID;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public int index;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public int reqId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public int originalMediaIndex;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<String> fullSpaceARLocalMediaFilePathList;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Integer, String> localMediaFilePathMap;

    public a() {
        List<? extends MediaInfo> emptyList;
        List<ShadowInspirationAI$InspirationMediaInfo> emptyList2;
        List<Integer> emptyList3;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.processedMediaInfos = emptyList;
        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
        this.inspirationAIMediaInfos = emptyList2;
        emptyList3 = CollectionsKt__CollectionsKt.emptyList();
        this.mutipleIndexes = emptyList3;
        this.processedExtra = "";
        this.busiID = "";
        this.index = -1;
        this.originalMediaIndex = Integer.MAX_VALUE;
        this.fullSpaceARLocalMediaFilePathList = new ArrayList<>();
        this.localMediaFilePathMap = new HashMap<>();
    }

    public final void a(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        this.fullSpaceARLocalMediaFilePathList.add(path);
    }

    @NotNull
    public final ArrayList<String> b() {
        return this.fullSpaceARLocalMediaFilePathList;
    }

    @NotNull
    public final HashMap<Integer, String> c() {
        return this.localMediaFilePathMap;
    }

    public final void d(int index, @NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        this.localMediaFilePathMap.put(Integer.valueOf(index), path);
    }
}
