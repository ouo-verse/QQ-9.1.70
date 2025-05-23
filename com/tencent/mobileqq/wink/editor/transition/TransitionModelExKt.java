package com.tencent.mobileqq.wink.editor.transition;

import android.content.Context;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.ResourceModel;
import com.tencent.videocut.model.SizeF;
import com.tencent.videocut.model.TransitionModel;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\u001a\u000e\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u001e\u0010\b\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006\u001a0\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00020\u000f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0002\u001a\u0012\u0010\u0012\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\nH\u0002\u00a8\u0006\u0013"}, d2 = {"Landroid/content/Context;", "context", "Lcom/tencent/videocut/model/TransitionModel;", "d", "", "pagName", "", "duration", "c", "", "Lcom/tencent/videocut/model/MediaClip;", "videos", "", "applyAll", "model", "", "a", "clip", "b", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class TransitionModelExKt {
    @NotNull
    public static final Map<String, TransitionModel> a(@NotNull final List<? extends MediaClip> videos, boolean z16, @NotNull TransitionModel model) {
        Object orNull;
        TransitionModel copy;
        int lastIndex;
        String uuid;
        int i3;
        Function1<Integer, String> function1;
        TransitionModel copy2;
        LinkedHashMap linkedHashMap;
        Intrinsics.checkNotNullParameter(videos, "videos");
        Intrinsics.checkNotNullParameter(model, "model");
        Function1<Integer, String> function12 = new Function1<Integer, String>() { // from class: com.tencent.mobileqq.wink.editor.transition.TransitionModelExKt$bindVideoWithTransition$getVideoId$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ String invoke(Integer num) {
                return invoke(num.intValue());
            }

            @NotNull
            public final String invoke(int i16) {
                Object orNull2;
                ResourceModel resourceModel;
                String str;
                orNull2 = CollectionsKt___CollectionsKt.getOrNull(videos, i16);
                MediaClip mediaClip = (MediaClip) orNull2;
                return (mediaClip == null || (resourceModel = mediaClip.resource) == null || (str = resourceModel.id) == null) ? "" : str;
            }
        };
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        if (z16) {
            int i16 = model.position;
            int i17 = 0;
            for (Object obj : videos) {
                int i18 = i17 + 1;
                if (i17 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                MediaClip mediaClip = (MediaClip) obj;
                lastIndex = CollectionsKt__CollectionsKt.getLastIndex(videos);
                if (i17 == lastIndex) {
                    i3 = i16;
                    function1 = function12;
                    linkedHashMap = linkedHashMap2;
                } else {
                    if (i16 == i17) {
                        uuid = model.id;
                    } else {
                        uuid = UUID.randomUUID().toString();
                        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
                    }
                    String valueOf = String.valueOf(i17);
                    i3 = i16;
                    function1 = function12;
                    copy2 = model.copy((r24 & 1) != 0 ? model.id : uuid, (r24 & 2) != 0 ? model.path : null, (r24 & 4) != 0 ? Integer.valueOf(model.position) : Integer.valueOf(i17), (r24 & 8) != 0 ? Long.valueOf(model.duration) : null, (r24 & 16) != 0 ? model.landscapePagPath : null, (r24 & 32) != 0 ? model.pagPath : null, (r24 & 64) != 0 ? Boolean.valueOf(model.isLandscape) : Boolean.valueOf(b(mediaClip)), (r24 & 128) != 0 ? model.resId : null, (r24 & 256) != 0 ? model.relatedClipId : function12.invoke(Integer.valueOf(i17)), (r24 & 512) != 0 ? model.categoryId : null, (r24 & 1024) != 0 ? model.unknownFields() : null);
                    linkedHashMap = linkedHashMap2;
                    linkedHashMap.put(valueOf, copy2);
                }
                linkedHashMap2 = linkedHashMap;
                i17 = i18;
                i16 = i3;
                function12 = function1;
            }
            return linkedHashMap2;
        }
        int i19 = model.position;
        String valueOf2 = String.valueOf(i19);
        orNull = CollectionsKt___CollectionsKt.getOrNull(videos, i19);
        copy = model.copy((r24 & 1) != 0 ? model.id : null, (r24 & 2) != 0 ? model.path : null, (r24 & 4) != 0 ? Integer.valueOf(model.position) : null, (r24 & 8) != 0 ? Long.valueOf(model.duration) : null, (r24 & 16) != 0 ? model.landscapePagPath : null, (r24 & 32) != 0 ? model.pagPath : null, (r24 & 64) != 0 ? Boolean.valueOf(model.isLandscape) : Boolean.valueOf(b((MediaClip) orNull)), (r24 & 128) != 0 ? model.resId : null, (r24 & 256) != 0 ? model.relatedClipId : function12.invoke(Integer.valueOf(i19)), (r24 & 512) != 0 ? model.categoryId : null, (r24 & 1024) != 0 ? model.unknownFields() : null);
        linkedHashMap2.put(valueOf2, copy);
        return linkedHashMap2;
    }

    private static final boolean b(MediaClip mediaClip) {
        ResourceModel resourceModel;
        SizeF sizeF;
        if (mediaClip == null || (resourceModel = mediaClip.resource) == null || (sizeF = resourceModel.size) == null || sizeF.height > sizeF.width) {
            return false;
        }
        return true;
    }

    @NotNull
    public static final TransitionModel c(@NotNull Context context, @NotNull String pagName, long j3) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pagName, "pagName");
        String pagFolderPath = TransitionResourceManager.f(context);
        String pagPath = TransitionResourceManager.e(context, pagName);
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        Intrinsics.checkNotNullExpressionValue(pagFolderPath, "pagFolderPath");
        Intrinsics.checkNotNullExpressionValue(pagPath, "pagPath");
        return new TransitionModel(uuid, pagFolderPath, 0, j3, pagPath, pagPath, false, pagName, "", "", null, 1024, null);
    }

    @NotNull
    public static final TransitionModel d(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return c(context, "ZC_jichu_huadong", 1000000L);
    }
}
