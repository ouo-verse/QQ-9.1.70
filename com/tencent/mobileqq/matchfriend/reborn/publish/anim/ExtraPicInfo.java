package com.tencent.mobileqq.matchfriend.reborn.publish.anim;

import android.content.Context;
import android.graphics.Point;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001Bs\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001b\u0012\"\b\u0002\u0010%\u001a\u001c\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\"\u0018\u00010 \u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b'\u0010(J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u000f\u0010\u0012R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\n\u0010\u0019R\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0014\u0010\u001eR1\u0010%\u001a\u001c\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\"\u0018\u00010 8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010#\u001a\u0004\b\u0017\u0010$R\u0019\u0010&\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\u001c\u0010\u0012\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/publish/anim/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "Ljava/lang/Float;", "g", "()Ljava/lang/Float;", "textPicMargin", "b", "Ljava/lang/Integer;", "f", "()Ljava/lang/Integer;", "startBorderRadius", "c", "endBorderRadius", "Lcom/tencent/mobileqq/matchfriend/reborn/publish/anim/a;", "d", "Lcom/tencent/mobileqq/matchfriend/reborn/publish/anim/a;", "()Lcom/tencent/mobileqq/matchfriend/reborn/publish/anim/a;", "animBorderPadding", "Lcom/tencent/mobileqq/matchfriend/reborn/publish/anim/FeedDisplayType;", "e", "Lcom/tencent/mobileqq/matchfriend/reborn/publish/anim/FeedDisplayType;", "()Lcom/tencent/mobileqq/matchfriend/reborn/publish/anim/FeedDisplayType;", "feedDisplayType", "Lkotlin/Function3;", "Landroid/content/Context;", "Landroid/graphics/Point;", "Lkotlin/jvm/functions/Function3;", "()Lkotlin/jvm/functions/Function3;", "getPicSizeFunc", "picShadeBgTokenId", "<init>", "(Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/tencent/mobileqq/matchfriend/reborn/publish/anim/a;Lcom/tencent/mobileqq/matchfriend/reborn/publish/anim/FeedDisplayType;Lkotlin/jvm/functions/Function3;Ljava/lang/Integer;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.matchfriend.reborn.publish.anim.b, reason: from toString */
/* loaded from: classes33.dex */
public final /* data */ class ExtraPicInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final Float textPicMargin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final Integer startBorderRadius;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final Integer endBorderRadius;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final AnimBorderPadding animBorderPadding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final FeedDisplayType feedDisplayType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final Function3<Context, Integer, Integer, Point> getPicSizeFunc;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final Integer picShadeBgTokenId;

    public ExtraPicInfo() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    /* renamed from: a, reason: from getter */
    public final AnimBorderPadding getAnimBorderPadding() {
        return this.animBorderPadding;
    }

    /* renamed from: b, reason: from getter */
    public final Integer getEndBorderRadius() {
        return this.endBorderRadius;
    }

    /* renamed from: c, reason: from getter */
    public final FeedDisplayType getFeedDisplayType() {
        return this.feedDisplayType;
    }

    public final Function3<Context, Integer, Integer, Point> d() {
        return this.getPicSizeFunc;
    }

    /* renamed from: e, reason: from getter */
    public final Integer getPicShadeBgTokenId() {
        return this.picShadeBgTokenId;
    }

    /* renamed from: f, reason: from getter */
    public final Integer getStartBorderRadius() {
        return this.startBorderRadius;
    }

    /* renamed from: g, reason: from getter */
    public final Float getTextPicMargin() {
        return this.textPicMargin;
    }

    public int hashCode() {
        Float f16 = this.textPicMargin;
        int hashCode = (f16 == null ? 0 : f16.hashCode()) * 31;
        Integer num = this.startBorderRadius;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.endBorderRadius;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        AnimBorderPadding animBorderPadding = this.animBorderPadding;
        int hashCode4 = (hashCode3 + (animBorderPadding == null ? 0 : animBorderPadding.hashCode())) * 31;
        FeedDisplayType feedDisplayType = this.feedDisplayType;
        int hashCode5 = (hashCode4 + (feedDisplayType == null ? 0 : feedDisplayType.hashCode())) * 31;
        Function3<Context, Integer, Integer, Point> function3 = this.getPicSizeFunc;
        int hashCode6 = (hashCode5 + (function3 == null ? 0 : function3.hashCode())) * 31;
        Integer num3 = this.picShadeBgTokenId;
        return hashCode6 + (num3 != null ? num3.hashCode() : 0);
    }

    public String toString() {
        return "ExtraPicInfo(textPicMargin=" + this.textPicMargin + ", startBorderRadius=" + this.startBorderRadius + ", endBorderRadius=" + this.endBorderRadius + ", animBorderPadding=" + this.animBorderPadding + ", feedDisplayType=" + this.feedDisplayType + ", getPicSizeFunc=" + this.getPicSizeFunc + ", picShadeBgTokenId=" + this.picShadeBgTokenId + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ExtraPicInfo(Float f16, Integer num, Integer num2, AnimBorderPadding animBorderPadding, FeedDisplayType feedDisplayType, Function3<? super Context, ? super Integer, ? super Integer, ? extends Point> function3, Integer num3) {
        this.textPicMargin = f16;
        this.startBorderRadius = num;
        this.endBorderRadius = num2;
        this.animBorderPadding = animBorderPadding;
        this.feedDisplayType = feedDisplayType;
        this.getPicSizeFunc = function3;
        this.picShadeBgTokenId = num3;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExtraPicInfo)) {
            return false;
        }
        ExtraPicInfo extraPicInfo = (ExtraPicInfo) other;
        return Intrinsics.areEqual((Object) this.textPicMargin, (Object) extraPicInfo.textPicMargin) && Intrinsics.areEqual(this.startBorderRadius, extraPicInfo.startBorderRadius) && Intrinsics.areEqual(this.endBorderRadius, extraPicInfo.endBorderRadius) && Intrinsics.areEqual(this.animBorderPadding, extraPicInfo.animBorderPadding) && this.feedDisplayType == extraPicInfo.feedDisplayType && Intrinsics.areEqual(this.getPicSizeFunc, extraPicInfo.getPicSizeFunc) && Intrinsics.areEqual(this.picShadeBgTokenId, extraPicInfo.picShadeBgTokenId);
    }

    public /* synthetic */ ExtraPicInfo(Float f16, Integer num, Integer num2, AnimBorderPadding animBorderPadding, FeedDisplayType feedDisplayType, Function3 function3, Integer num3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : f16, (i3 & 2) != 0 ? null : num, (i3 & 4) != 0 ? null : num2, (i3 & 8) != 0 ? null : animBorderPadding, (i3 & 16) != 0 ? null : feedDisplayType, (i3 & 32) != 0 ? null : function3, (i3 & 64) != 0 ? null : num3);
    }
}
