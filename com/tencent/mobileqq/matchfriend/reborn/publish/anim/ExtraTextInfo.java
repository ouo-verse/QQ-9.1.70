package com.tencent.mobileqq.matchfriend.reborn.publish.anim;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\u001c\b\u0002\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u000f\u0010\rR+\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\n\u0010\u0016R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u0014\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/publish/anim/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "Ljava/lang/Float;", "d", "()Ljava/lang/Float;", "textStartFontSize", "b", "textEndFontSize", "Lkotlin/Function2;", "Landroid/content/Context;", "Lcom/tencent/mobileqq/matchfriend/reborn/publish/anim/o;", "c", "Lkotlin/jvm/functions/Function2;", "()Lkotlin/jvm/functions/Function2;", "textDisplayFunc", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "textShadeBgTokenId", "<init>", "(Ljava/lang/Float;Ljava/lang/Float;Lkotlin/jvm/functions/Function2;Ljava/lang/Integer;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.matchfriend.reborn.publish.anim.c, reason: from toString */
/* loaded from: classes33.dex */
public final /* data */ class ExtraTextInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final Float textStartFontSize;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final Float textEndFontSize;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final Function2<Context, String, TextInfo> textDisplayFunc;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final Integer textShadeBgTokenId;

    public ExtraTextInfo() {
        this(null, null, null, null, 15, null);
    }

    public final Function2<Context, String, TextInfo> a() {
        return this.textDisplayFunc;
    }

    /* renamed from: b, reason: from getter */
    public final Float getTextEndFontSize() {
        return this.textEndFontSize;
    }

    /* renamed from: c, reason: from getter */
    public final Integer getTextShadeBgTokenId() {
        return this.textShadeBgTokenId;
    }

    /* renamed from: d, reason: from getter */
    public final Float getTextStartFontSize() {
        return this.textStartFontSize;
    }

    public int hashCode() {
        Float f16 = this.textStartFontSize;
        int hashCode = (f16 == null ? 0 : f16.hashCode()) * 31;
        Float f17 = this.textEndFontSize;
        int hashCode2 = (hashCode + (f17 == null ? 0 : f17.hashCode())) * 31;
        Function2<Context, String, TextInfo> function2 = this.textDisplayFunc;
        int hashCode3 = (hashCode2 + (function2 == null ? 0 : function2.hashCode())) * 31;
        Integer num = this.textShadeBgTokenId;
        return hashCode3 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "ExtraTextInfo(textStartFontSize=" + this.textStartFontSize + ", textEndFontSize=" + this.textEndFontSize + ", textDisplayFunc=" + this.textDisplayFunc + ", textShadeBgTokenId=" + this.textShadeBgTokenId + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ExtraTextInfo(Float f16, Float f17, Function2<? super Context, ? super String, TextInfo> function2, Integer num) {
        this.textStartFontSize = f16;
        this.textEndFontSize = f17;
        this.textDisplayFunc = function2;
        this.textShadeBgTokenId = num;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExtraTextInfo)) {
            return false;
        }
        ExtraTextInfo extraTextInfo = (ExtraTextInfo) other;
        return Intrinsics.areEqual((Object) this.textStartFontSize, (Object) extraTextInfo.textStartFontSize) && Intrinsics.areEqual((Object) this.textEndFontSize, (Object) extraTextInfo.textEndFontSize) && Intrinsics.areEqual(this.textDisplayFunc, extraTextInfo.textDisplayFunc) && Intrinsics.areEqual(this.textShadeBgTokenId, extraTextInfo.textShadeBgTokenId);
    }

    public /* synthetic */ ExtraTextInfo(Float f16, Float f17, Function2 function2, Integer num, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : f16, (i3 & 2) != 0 ? null : f17, (i3 & 4) != 0 ? null : function2, (i3 & 8) != 0 ? null : num);
    }
}
