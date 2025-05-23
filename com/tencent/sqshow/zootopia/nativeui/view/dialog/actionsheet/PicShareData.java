package com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.sqshow.utils.featureswitch.model.ZPlanShareItem;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u001e\u00a2\u0006\u0004\b$\u0010%J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\t\u0010\u0010R\u0017\u0010\u0016\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015R$\u0010\u001d\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u000e\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010#\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u001f\u001a\u0004\b\u0018\u0010 \"\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/dialog/actionsheet/s;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "time", "b", "I", "()I", "actionId", "Lcom/tencent/sqshow/utils/featureswitch/model/aj;", "c", "Lcom/tencent/sqshow/utils/featureswitch/model/aj;", "()Lcom/tencent/sqshow/utils/featureswitch/model/aj;", DownloadInfo.spKey_Config, "Landroid/graphics/drawable/Drawable;", "d", "Landroid/graphics/drawable/Drawable;", "()Landroid/graphics/drawable/Drawable;", "f", "(Landroid/graphics/drawable/Drawable;)V", "avatarDrawable", "Landroid/graphics/Bitmap;", "Landroid/graphics/Bitmap;", "()Landroid/graphics/Bitmap;", "g", "(Landroid/graphics/Bitmap;)V", "qrCodeBitmap", "<init>", "(Ljava/lang/String;ILcom/tencent/sqshow/utils/featureswitch/model/aj;Landroid/graphics/drawable/Drawable;Landroid/graphics/Bitmap;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet.s, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class PicShareData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String time;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int actionId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final ZPlanShareItem config;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private Drawable avatarDrawable;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private Bitmap qrCodeBitmap;

    public PicShareData() {
        this(null, 0, null, null, null, 31, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getActionId() {
        return this.actionId;
    }

    /* renamed from: b, reason: from getter */
    public final Drawable getAvatarDrawable() {
        return this.avatarDrawable;
    }

    /* renamed from: c, reason: from getter */
    public final ZPlanShareItem getConfig() {
        return this.config;
    }

    /* renamed from: d, reason: from getter */
    public final Bitmap getQrCodeBitmap() {
        return this.qrCodeBitmap;
    }

    /* renamed from: e, reason: from getter */
    public final String getTime() {
        return this.time;
    }

    public final void f(Drawable drawable) {
        this.avatarDrawable = drawable;
    }

    public final void g(Bitmap bitmap) {
        this.qrCodeBitmap = bitmap;
    }

    public int hashCode() {
        int hashCode = ((((this.time.hashCode() * 31) + this.actionId) * 31) + this.config.hashCode()) * 31;
        Drawable drawable = this.avatarDrawable;
        int hashCode2 = (hashCode + (drawable == null ? 0 : drawable.hashCode())) * 31;
        Bitmap bitmap = this.qrCodeBitmap;
        return hashCode2 + (bitmap != null ? bitmap.hashCode() : 0);
    }

    public String toString() {
        return "PicShareData(time=" + this.time + ", actionId=" + this.actionId + ", config=" + this.config + ", avatarDrawable=" + this.avatarDrawable + ", qrCodeBitmap=" + this.qrCodeBitmap + ")";
    }

    public PicShareData(String time, int i3, ZPlanShareItem config, Drawable drawable, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(config, "config");
        this.time = time;
        this.actionId = i3;
        this.config = config;
        this.avatarDrawable = drawable;
        this.qrCodeBitmap = bitmap;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PicShareData)) {
            return false;
        }
        PicShareData picShareData = (PicShareData) other;
        return Intrinsics.areEqual(this.time, picShareData.time) && this.actionId == picShareData.actionId && Intrinsics.areEqual(this.config, picShareData.config) && Intrinsics.areEqual(this.avatarDrawable, picShareData.avatarDrawable) && Intrinsics.areEqual(this.qrCodeBitmap, picShareData.qrCodeBitmap);
    }

    public /* synthetic */ PicShareData(String str, int i3, ZPlanShareItem zPlanShareItem, Drawable drawable, Bitmap bitmap, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? r.c() : str, (i16 & 2) != 0 ? 0 : i3, (i16 & 4) != 0 ? new ZPlanShareItem(0, null, null, null, null, null, null, 127, null) : zPlanShareItem, (i16 & 8) != 0 ? null : drawable, (i16 & 16) == 0 ? bitmap : null);
    }
}
