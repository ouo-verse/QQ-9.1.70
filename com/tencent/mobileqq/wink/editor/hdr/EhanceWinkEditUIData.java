package com.tencent.mobileqq.wink.editor.hdr;

import com.tencent.mobileqq.wink.editor.draft.WinkEditUIData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0004\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/hdr/EhanceWinkEditUIData;", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditUIData;", "", "updateInner", "", "showed", "saveUIDraft", "getUIDraft", "saveEnhanceDialogShowed", "getEnhanceDialogShowed", "Lcom/tencent/mobileqq/wink/editor/hdr/q;", "tag", "<init>", "(Lcom/tencent/mobileqq/wink/editor/hdr/q;)V", "Companion", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class EhanceWinkEditUIData extends WinkEditUIData {

    @NotNull
    public static final String enhanceBubbleShowed = "enhanceBubbleShowed";

    @NotNull
    public static final String enhanceDialogShowed = "enhanceDialogShowed";
    private static final long serialVersionUID = -3795231140454996516L;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EhanceWinkEditUIData(@NotNull q tag) {
        super(tag);
        Intrinsics.checkNotNullParameter(tag, "tag");
    }

    public final boolean getEnhanceDialogShowed() {
        if (getInt(enhanceDialogShowed, 0) <= 0) {
            return false;
        }
        return true;
    }

    public final boolean getUIDraft() {
        if (getInt(enhanceBubbleShowed, 0) <= 0) {
            return false;
        }
        return true;
    }

    public final void saveEnhanceDialogShowed(boolean showed) {
        putInt(enhanceDialogShowed, showed ? 1 : 0);
    }

    public final void saveUIDraft(boolean showed) {
        putInt(enhanceBubbleShowed, showed ? 1 : 0);
    }

    @Override // com.tencent.mobileqq.wink.editor.draft.WinkEditUIData
    protected void updateInner() {
    }
}
