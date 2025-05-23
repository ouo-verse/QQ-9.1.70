package com.tencent.mobileqq.wink.templatelibrary.memoryalbum;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b/\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u00a2\u0006\u0004\b8\u00109J\b\u0010\u0002\u001a\u00020\u0000H\u0016J\t\u0010\u0004\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u00d6\u0003R\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0015\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0017\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\"\u0010\u001c\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001e\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u001d\u0010\u001bR\"\u0010$\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010'\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u001f\u001a\u0004\b\f\u0010!\"\u0004\b&\u0010#R\"\u0010*\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010\u001f\u001a\u0004\b\u0011\u0010!\"\u0004\b)\u0010#R\"\u0010.\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010\u001f\u001a\u0004\b,\u0010!\"\u0004\b-\u0010#R\"\u00105\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0011\u00107\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b6\u0010\u0014\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/l;", "", "a", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "d", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "getMaterial", "()Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "e", "Ljava/lang/String;", "f", "()Ljava/lang/String;", QQWinkConstants.STORY_ID, "i", "storySQL", tl.h.F, "j", DomainData.DOMAIN_NAME, "(Ljava/lang/String;)V", "templateID", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "storyName", "I", "c", "()I", "setMaxPhotoCnt", "(I)V", "maxPhotoCnt", BdhLogUtil.LogTag.Tag_Conn, "setMinPhotoCnt", "minPhotoCnt", "D", "setPriorityIndex", "priorityIndex", "E", "l", "setFixedSegmentsTemplate", "isFixedSegmentsTemplate", UserInfo.SEX_FEMALE, "Z", "k", "()Z", "setUseTodayAsTriggerTime", "(Z)V", "useTodayAsTriggerTime", "b", "logString", "<init>", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.l, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class WinkMemoryAlbumConfig implements Cloneable {

    /* renamed from: C, reason: from kotlin metadata */
    private int minPhotoCnt;

    /* renamed from: D, reason: from kotlin metadata */
    private int priorityIndex;

    /* renamed from: E, reason: from kotlin metadata */
    private int isFixedSegmentsTemplate;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean useTodayAsTriggerTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final MetaMaterial material;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String storyId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String storySQL;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String templateID;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String storyName;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int maxPhotoCnt;

    public WinkMemoryAlbumConfig(@NotNull MetaMaterial material) {
        Intrinsics.checkNotNullParameter(material, "material");
        this.material = material;
        String str = material.f30533id;
        Intrinsics.checkNotNullExpressionValue(str, "material.id");
        this.storyId = str;
        this.storySQL = com.tencent.mobileqq.wink.editor.c.u0(material);
        this.templateID = com.tencent.mobileqq.wink.editor.c.F0(material);
        this.storyName = com.tencent.mobileqq.wink.editor.c.t0(material);
        this.isFixedSegmentsTemplate = -1;
        this.isFixedSegmentsTemplate = com.tencent.mobileqq.wink.editor.c.a1(material);
        this.priorityIndex = com.tencent.mobileqq.wink.editor.c.i0(material);
        this.maxPhotoCnt = com.tencent.mobileqq.wink.editor.c.U(material);
        this.minPhotoCnt = com.tencent.mobileqq.wink.editor.c.X(material);
        this.useTodayAsTriggerTime = com.tencent.mobileqq.wink.editor.c.R0(material);
    }

    @NotNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public WinkMemoryAlbumConfig clone() {
        Object clone = super.clone();
        Intrinsics.checkNotNull(clone, "null cannot be cast to non-null type com.tencent.mobileqq.wink.templatelibrary.memoryalbum.WinkMemoryAlbumConfig");
        return (WinkMemoryAlbumConfig) clone;
    }

    @NotNull
    public final String b() {
        return "{storyId:" + this.storyId + ", storyName:" + this.storyName + ", maxPhotoCnt:" + this.maxPhotoCnt + ", minPhotoCnt:" + this.minPhotoCnt + "}";
    }

    /* renamed from: c, reason: from getter */
    public final int getMaxPhotoCnt() {
        return this.maxPhotoCnt;
    }

    /* renamed from: d, reason: from getter */
    public final int getMinPhotoCnt() {
        return this.minPhotoCnt;
    }

    /* renamed from: e, reason: from getter */
    public final int getPriorityIndex() {
        return this.priorityIndex;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof WinkMemoryAlbumConfig) && Intrinsics.areEqual(this.material, ((WinkMemoryAlbumConfig) other).material)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getStoryId() {
        return this.storyId;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getStoryName() {
        return this.storyName;
    }

    public int hashCode() {
        return this.material.hashCode();
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final String getStorySQL() {
        return this.storySQL;
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public final String getTemplateID() {
        return this.templateID;
    }

    /* renamed from: k, reason: from getter */
    public final boolean getUseTodayAsTriggerTime() {
        return this.useTodayAsTriggerTime;
    }

    /* renamed from: l, reason: from getter */
    public final int getIsFixedSegmentsTemplate() {
        return this.isFixedSegmentsTemplate;
    }

    public final void m(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.storyName = str;
    }

    public final void n(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.templateID = str;
    }

    @NotNull
    public String toString() {
        return "WinkMemoryAlbumConfig(material=" + this.material + ")";
    }
}
