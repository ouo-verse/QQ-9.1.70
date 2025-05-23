package com.tencent.mobileqq.wink.editor.openingending;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0002\u0010\u000bR\u0013\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/openingending/WinkEditorOpeningEndingUpdateEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "videoFilePath", "", "isOpeningClip", "", "missionId", "templateId", "isFromClipping", "aigcData", "Lcom/tencent/mobileqq/wink/editor/openingending/OpeningEndingAigcData;", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ZLcom/tencent/mobileqq/wink/editor/openingending/OpeningEndingAigcData;)V", "getAigcData", "()Lcom/tencent/mobileqq/wink/editor/openingending/OpeningEndingAigcData;", "()Z", "getMissionId", "()Ljava/lang/String;", "getTemplateId", "getVideoFilePath", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class WinkEditorOpeningEndingUpdateEvent extends SimpleBaseEvent {

    @Nullable
    private final OpeningEndingAigcData aigcData;
    private final boolean isFromClipping;
    private final boolean isOpeningClip;

    @NotNull
    private final String missionId;

    @NotNull
    private final String templateId;

    @NotNull
    private final String videoFilePath;

    public /* synthetic */ WinkEditorOpeningEndingUpdateEvent(String str, boolean z16, String str2, String str3, boolean z17, OpeningEndingAigcData openingEndingAigcData, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z16, str2, str3, z17, (i3 & 32) != 0 ? null : openingEndingAigcData);
    }

    @Nullable
    public final OpeningEndingAigcData getAigcData() {
        return this.aigcData;
    }

    @NotNull
    public final String getMissionId() {
        return this.missionId;
    }

    @NotNull
    public final String getTemplateId() {
        return this.templateId;
    }

    @NotNull
    public final String getVideoFilePath() {
        return this.videoFilePath;
    }

    /* renamed from: isFromClipping, reason: from getter */
    public final boolean getIsFromClipping() {
        return this.isFromClipping;
    }

    /* renamed from: isOpeningClip, reason: from getter */
    public final boolean getIsOpeningClip() {
        return this.isOpeningClip;
    }

    public WinkEditorOpeningEndingUpdateEvent(@NotNull String videoFilePath, boolean z16, @NotNull String missionId, @NotNull String templateId, boolean z17, @Nullable OpeningEndingAigcData openingEndingAigcData) {
        Intrinsics.checkNotNullParameter(videoFilePath, "videoFilePath");
        Intrinsics.checkNotNullParameter(missionId, "missionId");
        Intrinsics.checkNotNullParameter(templateId, "templateId");
        this.videoFilePath = videoFilePath;
        this.isOpeningClip = z16;
        this.missionId = missionId;
        this.templateId = templateId;
        this.isFromClipping = z17;
        this.aigcData = openingEndingAigcData;
    }
}
