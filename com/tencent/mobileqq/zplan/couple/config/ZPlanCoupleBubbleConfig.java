package com.tencent.mobileqq.zplan.couple.config;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\t\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001a\u00a2\u0006\u0004\b \u0010!J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000bR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\r\u0010\u000bR\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0011\u001a\u0004\b\u0010\u0010\u0013R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/zplan/couple/config/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "id", "b", "e", "type", "c", "Ljava/lang/String;", "getJumpUrl", "()Ljava/lang/String;", WadlProxyConsts.KEY_JUMP_URL, "d", "order", "picUrl", "f", "richText", "", "g", "Ljava/lang/Long;", "getShowDuration", "()Ljava/lang/Long;", "showDuration", "<init>", "(IILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.couple.config.a, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class ZPlanCoupleBubbleConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int type;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String jumpUrl;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int order;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String picUrl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String richText;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Long showDuration;

    public ZPlanCoupleBubbleConfig(int i3, int i16, @Nullable String str, int i17, @Nullable String str2, @Nullable String str3, @Nullable Long l3) {
        this.id = i3;
        this.type = i16;
        this.jumpUrl = str;
        this.order = i17;
        this.picUrl = str2;
        this.richText = str3;
        this.showDuration = l3;
    }

    /* renamed from: a, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: b, reason: from getter */
    public final int getOrder() {
        return this.order;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final String getPicUrl() {
        return this.picUrl;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final String getRichText() {
        return this.richText;
    }

    /* renamed from: e, reason: from getter */
    public final int getType() {
        return this.type;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanCoupleBubbleConfig)) {
            return false;
        }
        ZPlanCoupleBubbleConfig zPlanCoupleBubbleConfig = (ZPlanCoupleBubbleConfig) other;
        if (this.id == zPlanCoupleBubbleConfig.id && this.type == zPlanCoupleBubbleConfig.type && Intrinsics.areEqual(this.jumpUrl, zPlanCoupleBubbleConfig.jumpUrl) && this.order == zPlanCoupleBubbleConfig.order && Intrinsics.areEqual(this.picUrl, zPlanCoupleBubbleConfig.picUrl) && Intrinsics.areEqual(this.richText, zPlanCoupleBubbleConfig.richText) && Intrinsics.areEqual(this.showDuration, zPlanCoupleBubbleConfig.showDuration)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int i3 = ((this.id * 31) + this.type) * 31;
        String str = this.jumpUrl;
        int i16 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i17 = (((i3 + hashCode) * 31) + this.order) * 31;
        String str2 = this.picUrl;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i18 = (i17 + hashCode2) * 31;
        String str3 = this.richText;
        if (str3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str3.hashCode();
        }
        int i19 = (i18 + hashCode3) * 31;
        Long l3 = this.showDuration;
        if (l3 != null) {
            i16 = l3.hashCode();
        }
        return i19 + i16;
    }

    @NotNull
    public String toString() {
        return "ZPlanCoupleBubbleConfig(id=" + this.id + ", type=" + this.type + ", jumpUrl=" + this.jumpUrl + ", order=" + this.order + ", picUrl=" + this.picUrl + ", richText=" + this.richText + ", showDuration=" + this.showDuration + ')';
    }
}
