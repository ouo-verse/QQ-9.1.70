package com.tencent.mobileqq.qqvideoedit.editor.background.uimanager;

import com.tencent.mobileqq.qqvideoedit.editor.background.border.EditViewContext;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.MediaClip;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0006\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/background/uimanager/d;", "Lcom/tencent/mobileqq/qqvideoedit/editor/background/uimanager/a;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaClip;", "Lcom/tencent/mobileqq/qqvideoedit/editor/background/border/EditViewContext;", "c", "Lcom/tencent/mobileqq/qqvideoedit/editor/background/border/EditViewContext;", "editContext", "<init>", "(Lcom/tencent/mobileqq/qqvideoedit/editor/background/border/EditViewContext;)V", "d", "a", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class d extends a<MediaClip> {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final EditViewContext editContext;

    public d(@NotNull EditViewContext editContext) {
        Intrinsics.checkNotNullParameter(editContext, "editContext");
        this.editContext = editContext;
    }
}
