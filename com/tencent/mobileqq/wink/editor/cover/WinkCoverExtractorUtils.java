package com.tencent.mobileqq.wink.editor.cover;

import com.tencent.mobileqq.wink.editor.WinkVideoTavCut;
import com.tencent.tavcut.core.session.ICutSession;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.model.StickerModel;
import com.tencent.videocut.render.ComposeRenderLayer;
import com.tencent.videocut.render.utils.c;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/cover/WinkCoverExtractorUtils;", "", "Lcom/tencent/videocut/render/ComposeRenderLayer;", "renderLayerHelper", "Lcom/tencent/videocut/model/MediaModel;", "mediaModel", "", "templatePath", "", "b", "Ljava/lang/Runnable;", "runnable", "Lcom/tencent/tavcut/core/session/ICutSession;", "cutSession", "a", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkCoverExtractorUtils {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final WinkCoverExtractorUtils f319672a = new WinkCoverExtractorUtils();

    WinkCoverExtractorUtils() {
    }

    public final void a(@NotNull final Runnable runnable, @NotNull ICutSession cutSession) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        Intrinsics.checkNotNullParameter(cutSession, "cutSession");
        cutSession.pushCustomCommandSync(new Function1<ICutSession, Unit>() { // from class: com.tencent.mobileqq.wink.editor.cover.WinkCoverExtractorUtils$pushCommand$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ICutSession iCutSession) {
                invoke2(iCutSession);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ICutSession pushCustomCommandSync) {
                Intrinsics.checkNotNullParameter(pushCustomCommandSync, "$this$pushCustomCommandSync");
                runnable.run();
            }
        });
    }

    public final void b(@NotNull ComposeRenderLayer renderLayerHelper, @NotNull MediaModel mediaModel, @NotNull String templatePath) {
        int collectionSizeOrDefault;
        int mapCapacity;
        int coerceAtLeast;
        Map mutableMap;
        MediaModel copy;
        Intrinsics.checkNotNullParameter(renderLayerHelper, "renderLayerHelper");
        Intrinsics.checkNotNullParameter(mediaModel, "mediaModel");
        Intrinsics.checkNotNullParameter(templatePath, "templatePath");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        WinkVideoTavCut.Companion companion = WinkVideoTavCut.INSTANCE;
        arrayList2.addAll(companion.h(templatePath));
        arrayList2.addAll(companion.g(templatePath));
        if (!arrayList2.isEmpty()) {
            arrayList.addAll(c.f384212a.d(arrayList2, templatePath, 720, 1280));
        }
        Map<String, StickerModel> map = mediaModel.stickers;
        ArrayList arrayList3 = new ArrayList(map.size());
        for (Map.Entry<String, StickerModel> entry : map.entrySet()) {
            if (entry.getValue().type != StickerModel.Type.IMAGE_TEMPLATE && entry.getValue().type != StickerModel.Type.TEXT_TEMPLATE) {
                arrayList.add(entry.getValue());
            }
            arrayList3.add(Unit.INSTANCE);
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (Object obj : arrayList) {
            linkedHashMap.put(((StickerModel) obj).id, obj);
        }
        mutableMap = MapsKt__MapsKt.toMutableMap(linkedHashMap);
        copy = mediaModel.copy((r39 & 1) != 0 ? mediaModel.id : null, (r39 & 2) != 0 ? mediaModel.name : null, (r39 & 4) != 0 ? mediaModel.version : null, (r39 & 8) != 0 ? mediaModel.createTime : null, (r39 & 16) != 0 ? mediaModel.updateTime : null, (r39 & 32) != 0 ? mediaModel.duration : null, (r39 & 64) != 0 ? mediaModel.videos : null, (r39 & 128) != 0 ? mediaModel.audios : null, (r39 & 256) != 0 ? mediaModel.stickers : mutableMap, (r39 & 512) != 0 ? mediaModel.backgroundModel : null, (r39 & 1024) != 0 ? mediaModel.filterModels : null, (r39 & 2048) != 0 ? mediaModel.specialEffects : null, (r39 & 4096) != 0 ? mediaModel.transitions : null, (r39 & 8192) != 0 ? mediaModel.templateModel : null, (r39 & 16384) != 0 ? mediaModel.coverInfo : null, (r39 & 32768) != 0 ? mediaModel.exportSetting : null, (r39 & 65536) != 0 ? mediaModel.openHDR : null, (r39 & 131072) != 0 ? mediaModel.hdrModels : null, (r39 & 262144) != 0 ? mediaModel.smoothModels : null, (r39 & 524288) != 0 ? mediaModel.openSuperHDR : null, (r39 & 1048576) != 0 ? mediaModel.unknownFields() : null);
        renderLayerHelper.l(copy);
    }
}
