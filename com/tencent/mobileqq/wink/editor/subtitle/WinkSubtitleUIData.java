package com.tencent.mobileqq.wink.editor.subtitle;

import com.tencent.mobileqq.wink.editor.draft.WinkEditUIData;
import com.tencent.mobileqq.wink.editor.subtitle.source.Subtitle;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u0017\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\b\u001a\u00020\u0004J\u0016\u0010\f\u001a\u00020\u00022\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tJ\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/subtitle/WinkSubtitleUIData;", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditUIData;", "", "updateInner", "", HippyControllerProps.BOOLEAN, "saveBilingualStatus", "(Ljava/lang/Boolean;)V", "getBilingualStatus", "", "Lcom/tencent/mobileqq/wink/editor/subtitle/source/Subtitle;", "list", "saveSubtitleList", "getSubtitleList", "Lcom/tencent/mobileqq/wink/editor/d;", "part", "<init>", "(Lcom/tencent/mobileqq/wink/editor/d;)V", "Companion", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkSubtitleUIData extends WinkEditUIData {

    @NotNull
    private static final String Bilingual_STATUS = "Bilingual_STATUS";

    @NotNull
    private static final String SUBTITLE_LIST = "SUBTITLE_LIST";

    @NotNull
    private static final String TAG = "WinkSubtitleUIData";
    private static final long serialVersionUID = 1218253800482475276L;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkSubtitleUIData(@NotNull com.tencent.mobileqq.wink.editor.d part) {
        super(part);
        Intrinsics.checkNotNullParameter(part, "part");
    }

    public final boolean getBilingualStatus() {
        if (getInt(Bilingual_STATUS, 0) != 1) {
            return false;
        }
        return true;
    }

    @Nullable
    public final List<Subtitle> getSubtitleList() {
        List<Subtitle> list;
        Serializable serializable = getSerializable(SUBTITLE_LIST, null);
        if (serializable != null) {
            list = CollectionsKt___CollectionsKt.toList((ArrayList) serializable);
            return list;
        }
        return null;
    }

    public final void saveBilingualStatus(@Nullable Boolean r26) {
        putInt(Bilingual_STATUS, Intrinsics.areEqual(r26, Boolean.TRUE) ? 1 : 0);
    }

    public final void saveSubtitleList(@Nullable List<Subtitle> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            arrayList.addAll(list);
        }
        putSerializable(SUBTITLE_LIST, arrayList);
    }

    @Override // com.tencent.mobileqq.wink.editor.draft.WinkEditUIData
    protected void updateInner() {
    }
}
