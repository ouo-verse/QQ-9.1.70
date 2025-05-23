package com.tencent.ecommerce.base.share.api;

import android.content.Intent;
import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\fR\u0017\u0010\u0016\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0014\u001a\u0004\b\t\u0010\u0015R\u0017\u0010\u001a\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0018\u001a\u0004\b\u0010\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/ecommerce/base/share/api/h;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "id", "e", "shotLabel", "c", "d", "longLabel", "Landroid/graphics/Bitmap;", "Landroid/graphics/Bitmap;", "()Landroid/graphics/Bitmap;", "icon", "Landroid/content/Intent;", "Landroid/content/Intent;", "()Landroid/content/Intent;", "intent", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/graphics/Bitmap;Landroid/content/Intent;)V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.base.share.api.h, reason: from toString */
/* loaded from: classes5.dex */
public final /* data */ class ShortCutInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String shotLabel;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String longLabel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Bitmap icon;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Intent intent;

    public ShortCutInfo(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Bitmap bitmap, @NotNull Intent intent) {
        this.id = str;
        this.shotLabel = str2;
        this.longLabel = str3;
        this.icon = bitmap;
        this.intent = intent;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final Bitmap getIcon() {
        return this.icon;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final Intent getIntent() {
        return this.intent;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getLongLabel() {
        return this.longLabel;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getShotLabel() {
        return this.shotLabel;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof ShortCutInfo) {
                ShortCutInfo shortCutInfo = (ShortCutInfo) other;
                if (!Intrinsics.areEqual(this.id, shortCutInfo.id) || !Intrinsics.areEqual(this.shotLabel, shortCutInfo.shotLabel) || !Intrinsics.areEqual(this.longLabel, shortCutInfo.longLabel) || !Intrinsics.areEqual(this.icon, shortCutInfo.icon) || !Intrinsics.areEqual(this.intent, shortCutInfo.intent)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        String str = this.id;
        int i19 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i26 = i3 * 31;
        String str2 = this.shotLabel;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i27 = (i26 + i16) * 31;
        String str3 = this.longLabel;
        if (str3 != null) {
            i17 = str3.hashCode();
        } else {
            i17 = 0;
        }
        int i28 = (i27 + i17) * 31;
        Bitmap bitmap = this.icon;
        if (bitmap != null) {
            i18 = bitmap.hashCode();
        } else {
            i18 = 0;
        }
        int i29 = (i28 + i18) * 31;
        Intent intent = this.intent;
        if (intent != null) {
            i19 = intent.hashCode();
        }
        return i29 + i19;
    }

    @NotNull
    public String toString() {
        return "ShortCutInfo(id=" + this.id + ", shotLabel=" + this.shotLabel + ", longLabel=" + this.longLabel + ", icon=" + this.icon + ", intent=" + this.intent + ")";
    }
}
