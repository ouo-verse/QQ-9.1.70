package com.tencent.mobileqq.zplan.aigc.share;

import android.graphics.Bitmap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B{\u0012\u0006\u0010\r\u001a\u00020\t\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0013\u0012\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u001c\u0012\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u001c\u0012\u0006\u0010$\u001a\u00020\u0013\u0012\u0006\u0010&\u001a\u00020\u0013\u0012\b\u0010+\u001a\u0004\u0018\u00010'\u0012\b\u0010,\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b-\u0010.J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u000e\u0010\u0017R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0015\u001a\u0004\b\u0014\u0010\u0017R\u001f\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001f\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u001c8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u001e\u001a\u0004\b\"\u0010 R\u0017\u0010$\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0015\u001a\u0004\b\u001d\u0010\u0017R\u0017\u0010&\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0015\u001a\u0004\b%\u0010\u0017R\u0019\u0010+\u001a\u0004\u0018\u00010'8\u0006\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b\u0019\u0010*R\u0019\u0010,\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b%\u0010\u000f\u001a\u0004\b(\u0010\u0011\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/share/m;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lmqq/app/AppRuntime;", "a", "Lmqq/app/AppRuntime;", "()Lmqq/app/AppRuntime;", "app", "b", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "feedId", "Landroid/graphics/Bitmap;", "c", "Landroid/graphics/Bitmap;", "i", "()Landroid/graphics/Bitmap;", "maskBitmap", "d", "avatarBitmap", "backgroundBitmap", "", "f", "Ljava/util/List;", tl.h.F, "()Ljava/util/List;", "itemBitmaps", "g", "itemBgBitmaps", "goodLookBubbleBitmap", "k", "veryGoodLookBubbleBitmap", "", "j", "Ljava/lang/Long;", "()Ljava/lang/Long;", "createTs", "nickName", "<init>", "(Lmqq/app/AppRuntime;Ljava/lang/String;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Ljava/util/List;Ljava/util/List;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Ljava/lang/Long;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.aigc.share.m, reason: from toString */
/* loaded from: classes35.dex */
public final /* data */ class SuitOutfitShareData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final AppRuntime app;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String feedId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final Bitmap maskBitmap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final Bitmap avatarBitmap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final Bitmap backgroundBitmap;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<Bitmap> itemBitmaps;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<Bitmap> itemBgBitmaps;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final Bitmap goodLookBubbleBitmap;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private final Bitmap veryGoodLookBubbleBitmap;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private final Long createTs;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    private final String nickName;

    public SuitOutfitShareData(AppRuntime app, String str, Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, List<Bitmap> list, List<Bitmap> list2, Bitmap goodLookBubbleBitmap, Bitmap veryGoodLookBubbleBitmap, Long l3, String str2) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(goodLookBubbleBitmap, "goodLookBubbleBitmap");
        Intrinsics.checkNotNullParameter(veryGoodLookBubbleBitmap, "veryGoodLookBubbleBitmap");
        this.app = app;
        this.feedId = str;
        this.maskBitmap = bitmap;
        this.avatarBitmap = bitmap2;
        this.backgroundBitmap = bitmap3;
        this.itemBitmaps = list;
        this.itemBgBitmaps = list2;
        this.goodLookBubbleBitmap = goodLookBubbleBitmap;
        this.veryGoodLookBubbleBitmap = veryGoodLookBubbleBitmap;
        this.createTs = l3;
        this.nickName = str2;
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
    public final Bitmap getBackgroundBitmap() {
        return this.backgroundBitmap;
    }

    /* renamed from: d, reason: from getter */
    public final Long getCreateTs() {
        return this.createTs;
    }

    /* renamed from: e, reason: from getter */
    public final String getFeedId() {
        return this.feedId;
    }

    /* renamed from: f, reason: from getter */
    public final Bitmap getGoodLookBubbleBitmap() {
        return this.goodLookBubbleBitmap;
    }

    public final List<Bitmap> g() {
        return this.itemBgBitmaps;
    }

    public final List<Bitmap> h() {
        return this.itemBitmaps;
    }

    public int hashCode() {
        int hashCode = this.app.hashCode() * 31;
        String str = this.feedId;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Bitmap bitmap = this.maskBitmap;
        int hashCode3 = (hashCode2 + (bitmap == null ? 0 : bitmap.hashCode())) * 31;
        Bitmap bitmap2 = this.avatarBitmap;
        int hashCode4 = (hashCode3 + (bitmap2 == null ? 0 : bitmap2.hashCode())) * 31;
        Bitmap bitmap3 = this.backgroundBitmap;
        int hashCode5 = (hashCode4 + (bitmap3 == null ? 0 : bitmap3.hashCode())) * 31;
        List<Bitmap> list = this.itemBitmaps;
        int hashCode6 = (hashCode5 + (list == null ? 0 : list.hashCode())) * 31;
        List<Bitmap> list2 = this.itemBgBitmaps;
        int hashCode7 = (((((hashCode6 + (list2 == null ? 0 : list2.hashCode())) * 31) + this.goodLookBubbleBitmap.hashCode()) * 31) + this.veryGoodLookBubbleBitmap.hashCode()) * 31;
        Long l3 = this.createTs;
        int hashCode8 = (hashCode7 + (l3 == null ? 0 : l3.hashCode())) * 31;
        String str2 = this.nickName;
        return hashCode8 + (str2 != null ? str2.hashCode() : 0);
    }

    /* renamed from: i, reason: from getter */
    public final Bitmap getMaskBitmap() {
        return this.maskBitmap;
    }

    /* renamed from: j, reason: from getter */
    public final String getNickName() {
        return this.nickName;
    }

    /* renamed from: k, reason: from getter */
    public final Bitmap getVeryGoodLookBubbleBitmap() {
        return this.veryGoodLookBubbleBitmap;
    }

    public String toString() {
        return "SuitOutfitShareData(app=" + this.app + ", feedId=" + this.feedId + ", maskBitmap=" + this.maskBitmap + ", avatarBitmap=" + this.avatarBitmap + ", backgroundBitmap=" + this.backgroundBitmap + ", itemBitmaps=" + this.itemBitmaps + ", itemBgBitmaps=" + this.itemBgBitmaps + ", goodLookBubbleBitmap=" + this.goodLookBubbleBitmap + ", veryGoodLookBubbleBitmap=" + this.veryGoodLookBubbleBitmap + ", createTs=" + this.createTs + ", nickName=" + this.nickName + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SuitOutfitShareData)) {
            return false;
        }
        SuitOutfitShareData suitOutfitShareData = (SuitOutfitShareData) other;
        return Intrinsics.areEqual(this.app, suitOutfitShareData.app) && Intrinsics.areEqual(this.feedId, suitOutfitShareData.feedId) && Intrinsics.areEqual(this.maskBitmap, suitOutfitShareData.maskBitmap) && Intrinsics.areEqual(this.avatarBitmap, suitOutfitShareData.avatarBitmap) && Intrinsics.areEqual(this.backgroundBitmap, suitOutfitShareData.backgroundBitmap) && Intrinsics.areEqual(this.itemBitmaps, suitOutfitShareData.itemBitmaps) && Intrinsics.areEqual(this.itemBgBitmaps, suitOutfitShareData.itemBgBitmaps) && Intrinsics.areEqual(this.goodLookBubbleBitmap, suitOutfitShareData.goodLookBubbleBitmap) && Intrinsics.areEqual(this.veryGoodLookBubbleBitmap, suitOutfitShareData.veryGoodLookBubbleBitmap) && Intrinsics.areEqual(this.createTs, suitOutfitShareData.createTs) && Intrinsics.areEqual(this.nickName, suitOutfitShareData.nickName);
    }
}
