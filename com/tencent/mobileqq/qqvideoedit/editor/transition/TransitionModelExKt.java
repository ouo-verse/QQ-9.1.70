package com.tencent.mobileqq.qqvideoedit.editor.transition;

import android.content.Context;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.MediaClip;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.ResourceModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.SizeF;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.TransitionModel;
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
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\u001a\u000e\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u001e\u0010\b\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006\u001a0\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00020\u000f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0002\u001a\u0012\u0010\u0012\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\nH\u0002\u00a8\u0006\u0013"}, d2 = {"Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/TransitionModel;", "d", "", "pagName", "", "duration", "c", "", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaClip;", "videos", "", "applyAll", "model", "", "a", "clip", "b", "qqvideoedit_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class TransitionModelExKt {
    @NotNull
    public static final Map<String, TransitionModel> a(@NotNull final List<MediaClip> videos, boolean z16, @NotNull TransitionModel model) {
        Object orNull;
        int lastIndex;
        String uuid;
        int i3;
        Function1<Integer, String> function1;
        LinkedHashMap linkedHashMap;
        Intrinsics.checkNotNullParameter(videos, "videos");
        Intrinsics.checkNotNullParameter(model, "model");
        Function1<Integer, String> function12 = new Function1<Integer, String>() { // from class: com.tencent.mobileqq.qqvideoedit.editor.transition.TransitionModelExKt$bindVideoWithTransition$getVideoId$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    TransitionModel copy$default = TransitionModel.copy$default(model, uuid, null, Integer.valueOf(i17), null, null, null, Boolean.valueOf(b(mediaClip)), null, function12.invoke(Integer.valueOf(i17)), null, null, 1722, null);
                    linkedHashMap = linkedHashMap2;
                    linkedHashMap.put(valueOf, copy$default);
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
        linkedHashMap2.put(valueOf2, TransitionModel.copy$default(model, null, null, null, null, null, null, Boolean.valueOf(b((MediaClip) orNull)), null, function12.invoke(Integer.valueOf(i19)), null, null, 1727, null));
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
