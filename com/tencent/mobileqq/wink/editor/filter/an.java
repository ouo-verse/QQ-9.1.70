package com.tencent.mobileqq.wink.editor.filter;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.videocut.model.MediaType;
import com.tencent.videocut.model.ResourceModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010.\u001a\u00020-\u00a2\u0006\u0004\b/\u00100J+\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u0004\u0018\u00010\u0002J\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\f\u001a\u00020\u0005J\u0017\u0010\r\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u0017\u0010\u0019\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b\u000f\u0010\u0018R\u0017\u0010\u001b\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u001a\u0010\u0018R\"\u0010\"\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0019\u0010'\u001a\u0004\u0018\u00010#8\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010$\u001a\u0004\b%\u0010&R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010\u0010R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010)R\"\u0010,\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0017\u001a\u0004\b(\u0010\u0018\"\u0004\b*\u0010+\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/filter/an;", "", "", ShortVideoConstants.PARAM_KEY_FILTER_ID, "filterName", "", "intensity", "", "k", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "d", "b", "c", "l", "(Ljava/lang/Integer;)V", "a", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "id", tl.h.F, "thumbUrl", "", "J", "()J", "duration", "f", "selectStart", "", "Z", "j", "()Z", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Z)V", "isSelect", "Lcom/tencent/videocut/model/MediaType;", "Lcom/tencent/videocut/model/MediaType;", "i", "()Lcom/tencent/videocut/model/MediaType;", "type", "g", "I", DomainData.DOMAIN_NAME, "(J)V", "startTime", "Lcom/tencent/videocut/model/ResourceModel;", "res", "<init>", "(Lcom/tencent/videocut/model/ResourceModel;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class an {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String thumbUrl;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final long duration;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long selectStart;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isSelect;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final MediaType type;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String filterName;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String filterId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int intensity;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private long startTime;

    public an(@NotNull ResourceModel res) {
        Intrinsics.checkNotNullParameter(res, "res");
        this.id = res.id;
        this.thumbUrl = res.path;
        this.duration = res.scaleDuration;
        long j3 = res.selectStart;
        this.selectStart = j3;
        this.type = res.type;
        this.startTime = j3;
    }

    /* renamed from: a, reason: from getter */
    public final long getDuration() {
        return this.duration;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getFilterId() {
        return this.filterId;
    }

    /* renamed from: c, reason: from getter */
    public final int getIntensity() {
        return this.intensity;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final String getFilterName() {
        return this.filterName;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: f, reason: from getter */
    public final long getSelectStart() {
        return this.selectStart;
    }

    /* renamed from: g, reason: from getter */
    public final long getStartTime() {
        return this.startTime;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getThumbUrl() {
        return this.thumbUrl;
    }

    @Nullable
    /* renamed from: i, reason: from getter */
    public final MediaType getType() {
        return this.type;
    }

    /* renamed from: j, reason: from getter */
    public final boolean getIsSelect() {
        return this.isSelect;
    }

    public final void k(@Nullable String filterId, @Nullable String filterName, @Nullable Integer intensity) {
        this.filterId = filterId;
        this.filterName = filterName;
        if (intensity != null) {
            intensity.intValue();
            this.intensity = intensity.intValue();
        }
    }

    public final void l(@Nullable Integer intensity) {
        if (intensity != null) {
            intensity.intValue();
            this.intensity = intensity.intValue();
        }
    }

    public final void m(boolean z16) {
        this.isSelect = z16;
    }

    public final void n(long j3) {
        this.startTime = j3;
    }
}
