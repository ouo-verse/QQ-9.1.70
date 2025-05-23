package com.tencent.mobileqq.zplan.aigc.share;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u0012\b\u0010!\u001a\u0004\u0018\u00010\u001e\u0012\b\u0010#\u001a\u0004\u0018\u00010\u001e\u0012\b\u0010$\u001a\u0004\u0018\u00010\u001e\u0012\b\u0010)\u001a\u0004\u0018\u00010%\u00a2\u0006\u0004\b*\u0010+J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R\u0017\u0010\u001b\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001d\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000f\u001a\u0004\b\u001c\u0010\u0011R\u0019\u0010!\u001a\u0004\u0018\u00010\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u001f\u001a\u0004\b\u0013\u0010 R\u0019\u0010#\u001a\u0004\u0018\u00010\u001e8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u001f\u001a\u0004\b\u0017\u0010 R\u0019\u0010$\u001a\u0004\u0018\u00010\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001f\u001a\u0004\b\u000e\u0010 R\u0019\u0010)\u001a\u0004\u0018\u00010%8\u0006\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b\"\u0010(\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/share/bk;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lmqq/app/AppRuntime;", "a", "Lmqq/app/AppRuntime;", "()Lmqq/app/AppRuntime;", "app", "b", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "name", "c", "f", "prompt", "", "d", "J", tl.h.F, "()J", "ugcId", "getSubPageId", "subPageId", "Landroid/graphics/Bitmap;", "Landroid/graphics/Bitmap;", "()Landroid/graphics/Bitmap;", "bgBitmap", "g", "clothBitmap", "avatarBitmap", "Landroid/graphics/drawable/Drawable;", "i", "Landroid/graphics/drawable/Drawable;", "()Landroid/graphics/drawable/Drawable;", "qqHeadDrawable", "<init>", "(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Landroid/graphics/drawable/Drawable;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.aigc.share.bk, reason: from toString */
/* loaded from: classes35.dex */
public final /* data */ class SuitShareData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final AppRuntime app;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String name;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final String prompt;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final long ugcId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final String subPageId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final Bitmap bgBitmap;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final Bitmap clothBitmap;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final Bitmap avatarBitmap;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private final Drawable qqHeadDrawable;

    public SuitShareData(AppRuntime app, String name, String prompt, long j3, String subPageId, Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Drawable drawable) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(prompt, "prompt");
        Intrinsics.checkNotNullParameter(subPageId, "subPageId");
        this.app = app;
        this.name = name;
        this.prompt = prompt;
        this.ugcId = j3;
        this.subPageId = subPageId;
        this.bgBitmap = bitmap;
        this.clothBitmap = bitmap2;
        this.avatarBitmap = bitmap3;
        this.qqHeadDrawable = drawable;
    }

    /* renamed from: a, reason: from getter */
    public final AppRuntime getApp() {
        return this.app;
    }

    /* renamed from: b, reason: from getter */
    public final Bitmap getAvatarBitmap() {
        return this.avatarBitmap;
    }

    /* renamed from: c, reason: from getter */
    public final Bitmap getBgBitmap() {
        return this.bgBitmap;
    }

    /* renamed from: d, reason: from getter */
    public final Bitmap getClothBitmap() {
        return this.clothBitmap;
    }

    /* renamed from: e, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: f, reason: from getter */
    public final String getPrompt() {
        return this.prompt;
    }

    /* renamed from: g, reason: from getter */
    public final Drawable getQqHeadDrawable() {
        return this.qqHeadDrawable;
    }

    /* renamed from: h, reason: from getter */
    public final long getUgcId() {
        return this.ugcId;
    }

    public int hashCode() {
        int hashCode = ((((((((this.app.hashCode() * 31) + this.name.hashCode()) * 31) + this.prompt.hashCode()) * 31) + com.tencent.mobileqq.vas.banner.c.a(this.ugcId)) * 31) + this.subPageId.hashCode()) * 31;
        Bitmap bitmap = this.bgBitmap;
        int hashCode2 = (hashCode + (bitmap == null ? 0 : bitmap.hashCode())) * 31;
        Bitmap bitmap2 = this.clothBitmap;
        int hashCode3 = (hashCode2 + (bitmap2 == null ? 0 : bitmap2.hashCode())) * 31;
        Bitmap bitmap3 = this.avatarBitmap;
        int hashCode4 = (hashCode3 + (bitmap3 == null ? 0 : bitmap3.hashCode())) * 31;
        Drawable drawable = this.qqHeadDrawable;
        return hashCode4 + (drawable != null ? drawable.hashCode() : 0);
    }

    public String toString() {
        return "SuitShareData(app=" + this.app + ", name=" + this.name + ", prompt=" + this.prompt + ", ugcId=" + this.ugcId + ", subPageId=" + this.subPageId + ", bgBitmap=" + this.bgBitmap + ", clothBitmap=" + this.clothBitmap + ", avatarBitmap=" + this.avatarBitmap + ", qqHeadDrawable=" + this.qqHeadDrawable + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SuitShareData)) {
            return false;
        }
        SuitShareData suitShareData = (SuitShareData) other;
        return Intrinsics.areEqual(this.app, suitShareData.app) && Intrinsics.areEqual(this.name, suitShareData.name) && Intrinsics.areEqual(this.prompt, suitShareData.prompt) && this.ugcId == suitShareData.ugcId && Intrinsics.areEqual(this.subPageId, suitShareData.subPageId) && Intrinsics.areEqual(this.bgBitmap, suitShareData.bgBitmap) && Intrinsics.areEqual(this.clothBitmap, suitShareData.clothBitmap) && Intrinsics.areEqual(this.avatarBitmap, suitShareData.avatarBitmap) && Intrinsics.areEqual(this.qqHeadDrawable, suitShareData.qqHeadDrawable);
    }
}
