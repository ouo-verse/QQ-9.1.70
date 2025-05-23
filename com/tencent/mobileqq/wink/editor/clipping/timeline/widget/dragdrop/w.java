package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop;

import com.tencent.autotemplate.filter.TAVOneClickFilmStickerEffect;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u001a&\u0010\u0006\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0000\u00a8\u0006\u0007"}, d2 = {"", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/y;", "trackList", "", "trackType", TAVOneClickFilmStickerEffect.TRACK_INDEX, "a", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class w {
    @NotNull
    public static final y a(@NotNull List<y> trackList, int i3, int i16) {
        Intrinsics.checkNotNullParameter(trackList, "trackList");
        y yVar = new y();
        yVar.r(i3);
        if (i16 <= trackList.size() && i16 >= 0) {
            yVar.n(i16);
            trackList.add(i16, yVar);
        } else {
            yVar.n(trackList.size());
            trackList.add(yVar);
        }
        return yVar;
    }
}
