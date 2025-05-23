package com.tencent.mobileqq.richmedia;

import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b \u0010!J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0002J\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\u000eJ\u0014\u0010\u0012\u001a\u00020\u00062\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0010J\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0010J\u000e\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014J\u0006\u0010\u0017\u001a\u00020\u0014J\u0006\u0010\u0018\u001a\u00020\u0006R \u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R \u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0019R\u001e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/richmedia/e;", "", "", "dependName", "Lcom/tencent/mobileqq/richmedia/depend/c;", "depend", "", "g", "d", "mediaId", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "itemInfo", "a", tl.h.F, "Ljava/util/concurrent/ConcurrentHashMap;", "e", "", VideoTemplateParser.ITEM_LIST, "j", "f", "", "index", "i", "c", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "dependHashMap", "downloadHashMap", "Ljava/util/List;", "richMediaDataList", "I", "currentIndex", "<init>", "()V", "RichMediaBrowser_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f281568a = new e();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, com.tencent.mobileqq.richmedia.depend.c> dependHashMap = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, RFWLayerItemMediaInfo> downloadHashMap = new ConcurrentHashMap<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static List<? extends RFWLayerItemMediaInfo> richMediaDataList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static int currentIndex;

    e() {
    }

    public final void a(@NotNull String mediaId, @NotNull RFWLayerItemMediaInfo itemInfo) {
        Intrinsics.checkNotNullParameter(mediaId, "mediaId");
        Intrinsics.checkNotNullParameter(itemInfo, "itemInfo");
        downloadHashMap.put(mediaId, itemInfo);
    }

    public final void b() {
        dependHashMap.clear();
        downloadHashMap.clear();
        richMediaDataList = null;
    }

    public final int c() {
        return currentIndex;
    }

    @Nullable
    public final com.tencent.mobileqq.richmedia.depend.c d(@NotNull String dependName) {
        Intrinsics.checkNotNullParameter(dependName, "dependName");
        return dependHashMap.get(dependName);
    }

    @NotNull
    public final ConcurrentHashMap<String, RFWLayerItemMediaInfo> e() {
        return downloadHashMap;
    }

    @Nullable
    public final List<RFWLayerItemMediaInfo> f() {
        return richMediaDataList;
    }

    public final void g(@NotNull String dependName, @NotNull com.tencent.mobileqq.richmedia.depend.c depend) {
        Intrinsics.checkNotNullParameter(dependName, "dependName");
        Intrinsics.checkNotNullParameter(depend, "depend");
        dependHashMap.put(dependName, depend);
    }

    public final void h(@NotNull String mediaId) {
        Intrinsics.checkNotNullParameter(mediaId, "mediaId");
        downloadHashMap.remove(mediaId);
    }

    public final void i(int index) {
        currentIndex = index;
    }

    public final void j(@NotNull List<? extends RFWLayerItemMediaInfo> itemList) {
        Intrinsics.checkNotNullParameter(itemList, "itemList");
        richMediaDataList = itemList;
    }
}
