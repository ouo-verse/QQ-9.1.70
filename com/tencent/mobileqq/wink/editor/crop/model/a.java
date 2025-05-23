package com.tencent.mobileqq.wink.editor.crop.model;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.videocut.model.MediaType;
import com.tencent.videocut.model.ResourceModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010 \u001a\u00020\u001f\u00a2\u0006\u0004\b!\u0010\"R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0003\u0010\rR\u0017\u0010\u0012\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0010\u001a\u0004\b\u000b\u0010\u0011R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u001c\u001a\u0004\b\u0014\u0010\u001d\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/crop/model/a;", "", "", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "id", "d", "thumbUrl", "", "c", UserInfo.SEX_FEMALE, "()F", "durationS", "", "J", "()J", "selectStart", "", "e", "Z", "f", "()Z", "g", "(Z)V", "isSelect", "Lcom/tencent/videocut/model/MediaType;", "Lcom/tencent/videocut/model/MediaType;", "()Lcom/tencent/videocut/model/MediaType;", "type", "Lcom/tencent/videocut/model/ResourceModel;", "res", "<init>", "(Lcom/tencent/videocut/model/ResourceModel;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String thumbUrl;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final float durationS;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long selectStart;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isSelect;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final MediaType type;

    public a(@NotNull ResourceModel res) {
        int roundToInt;
        Intrinsics.checkNotNullParameter(res, "res");
        this.id = res.id;
        this.thumbUrl = res.path;
        roundToInt = MathKt__MathJVMKt.roundToInt(((float) res.scaleDuration) / 10000.0f);
        this.durationS = roundToInt / 100.0f;
        this.selectStart = res.selectStart;
        this.type = res.type;
    }

    /* renamed from: a, reason: from getter */
    public final float getDurationS() {
        return this.durationS;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: c, reason: from getter */
    public final long getSelectStart() {
        return this.selectStart;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getThumbUrl() {
        return this.thumbUrl;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final MediaType getType() {
        return this.type;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getIsSelect() {
        return this.isSelect;
    }

    public final void g(boolean z16) {
        this.isSelect = z16;
    }
}
