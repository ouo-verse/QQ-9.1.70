package com.tencent.mobileqq.zplan.aigc.data;

import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\t\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010 \u001a\u00020\u0004\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010(\u001a\u00020#\u0012\b\b\u0002\u0010*\u001a\u00020\u0002\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b-\u0010.J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R$\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0017\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013R$\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0017\u0010 \u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u0019\u0010\"\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b!\u0010\u0019\u001a\u0004\b\u0010\u0010\u001bR\"\u0010(\u001a\u00020#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010$\u001a\u0004\b!\u0010%\"\u0004\b&\u0010'R\"\u0010*\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b)\u0010\u001dR$\u0010,\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010\u0019\u001a\u0004\b\u0018\u0010\u001b\"\u0004\b+\u0010\u001d\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/data/l;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/graphics/Bitmap;", "a", "Landroid/graphics/Bitmap;", "()Landroid/graphics/Bitmap;", tl.h.F, "(Landroid/graphics/Bitmap;)V", MimeHelper.IMAGE_SUBTYPE_BITMAP, "b", "I", "getWidth", "()I", "width", "c", "getHeight", "height", "d", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "k", "(Ljava/lang/String;)V", "url", "e", "imageryId", "f", "imageryDesc", "", "J", "()J", "j", "(J)V", "ugcID", "i", "prompt", "setImageryName", "imageryName", "<init>", "(Landroid/graphics/Bitmap;IILjava/lang/String;ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.aigc.data.l, reason: from toString */
/* loaded from: classes35.dex */
public final /* data */ class PatternImage {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private Bitmap bitmap;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int width;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int height;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private String url;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int imageryId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final String imageryDesc;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private long ugcID;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private String prompt;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private String imageryName;

    public PatternImage(Bitmap bitmap, int i3, int i16, String str, int i17, String str2, long j3, String prompt, String str3) {
        Intrinsics.checkNotNullParameter(prompt, "prompt");
        this.bitmap = bitmap;
        this.width = i3;
        this.height = i16;
        this.url = str;
        this.imageryId = i17;
        this.imageryDesc = str2;
        this.ugcID = j3;
        this.prompt = prompt;
        this.imageryName = str3;
    }

    /* renamed from: a, reason: from getter */
    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    /* renamed from: b, reason: from getter */
    public final String getImageryDesc() {
        return this.imageryDesc;
    }

    /* renamed from: c, reason: from getter */
    public final int getImageryId() {
        return this.imageryId;
    }

    /* renamed from: d, reason: from getter */
    public final String getImageryName() {
        return this.imageryName;
    }

    /* renamed from: e, reason: from getter */
    public final String getPrompt() {
        return this.prompt;
    }

    /* renamed from: f, reason: from getter */
    public final long getUgcID() {
        return this.ugcID;
    }

    /* renamed from: g, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public final void h(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public int hashCode() {
        Bitmap bitmap = this.bitmap;
        int hashCode = (((((bitmap == null ? 0 : bitmap.hashCode()) * 31) + this.width) * 31) + this.height) * 31;
        String str = this.url;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.imageryId) * 31;
        String str2 = this.imageryDesc;
        int hashCode3 = (((((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + com.tencent.mobileqq.vas.banner.c.a(this.ugcID)) * 31) + this.prompt.hashCode()) * 31;
        String str3 = this.imageryName;
        return hashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public final void i(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.prompt = str;
    }

    public final void j(long j3) {
        this.ugcID = j3;
    }

    public final void k(String str) {
        this.url = str;
    }

    public String toString() {
        return "PatternImage(bitmap=" + this.bitmap + ", width=" + this.width + ", height=" + this.height + ", url=" + this.url + ", imageryId=" + this.imageryId + ", imageryDesc=" + this.imageryDesc + ", ugcID=" + this.ugcID + ", prompt=" + this.prompt + ", imageryName=" + this.imageryName + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PatternImage)) {
            return false;
        }
        PatternImage patternImage = (PatternImage) other;
        return Intrinsics.areEqual(this.bitmap, patternImage.bitmap) && this.width == patternImage.width && this.height == patternImage.height && Intrinsics.areEqual(this.url, patternImage.url) && this.imageryId == patternImage.imageryId && Intrinsics.areEqual(this.imageryDesc, patternImage.imageryDesc) && this.ugcID == patternImage.ugcID && Intrinsics.areEqual(this.prompt, patternImage.prompt) && Intrinsics.areEqual(this.imageryName, patternImage.imageryName);
    }

    public /* synthetic */ PatternImage(Bitmap bitmap, int i3, int i16, String str, int i17, String str2, long j3, String str3, String str4, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this(bitmap, i3, i16, str, (i18 & 16) != 0 ? 0 : i17, (i18 & 32) != 0 ? null : str2, (i18 & 64) != 0 ? 0L : j3, (i18 & 128) != 0 ? "" : str3, (i18 & 256) != 0 ? "" : str4);
    }
}
