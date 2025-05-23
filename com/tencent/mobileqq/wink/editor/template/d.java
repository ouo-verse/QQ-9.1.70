package com.tencent.mobileqq.wink.editor.template;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.wink.editor.sticker.WinkStickerModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\fR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/template/d;", "", "", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "stickerUid", "", "b", "J", "c", "()J", "startTimeUs", "durationUs", "defaultTextContent", "e", "textContent", "Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "stickerModel", "<init>", "(Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String stickerUid;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final long startTimeUs;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final long durationUs;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String defaultTextContent;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String textContent;

    public d(@NotNull WinkStickerModel stickerModel) {
        String str;
        Intrinsics.checkNotNullParameter(stickerModel, "stickerModel");
        this.stickerUid = stickerModel.id;
        this.startTimeUs = stickerModel.startTime;
        this.durationUs = stickerModel.duration;
        MetaMaterial material = stickerModel.getMaterial();
        if (material != null) {
            str = com.tencent.mobileqq.wink.editor.sticker.m.n(material);
        } else {
            str = null;
        }
        this.defaultTextContent = str;
        MetaMaterial material2 = stickerModel.getMaterial();
        String l3 = material2 != null ? com.tencent.mobileqq.wink.editor.sticker.m.l(material2) : null;
        if (l3 != null && l3.length() > com.tencent.mobileqq.wink.editor.sticker.m.H(stickerModel.getMaterial())) {
            l3 = l3.substring(0, com.tencent.mobileqq.wink.editor.sticker.m.H(stickerModel.getMaterial()));
            Intrinsics.checkNotNullExpressionValue(l3, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        }
        this.textContent = l3;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getDefaultTextContent() {
        return this.defaultTextContent;
    }

    /* renamed from: b, reason: from getter */
    public final long getDurationUs() {
        return this.durationUs;
    }

    /* renamed from: c, reason: from getter */
    public final long getStartTimeUs() {
        return this.startTimeUs;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getStickerUid() {
        return this.stickerUid;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final String getTextContent() {
        return this.textContent;
    }
}
