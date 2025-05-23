package com.tencent.mobileqq.guild.aiocombinestyle.imagestrategy;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.annotation.DrawableRes;
import androidx.core.content.ContextCompat;
import com.tencent.guild.aio.component.combinestyle.ae;
import com.tencent.guild.aio.component.combinestyle.ag;
import com.tencent.guild.aio.component.combinestyle.ah;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0012\u0018\u00002\u00020\u0001BC\u0012\b\b\u0001\u0010\u000e\u001a\u00020\n\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u001b\u001a\u00020\n\u0012\b\b\u0002\u0010\u001e\u001a\u00020\n\u00a2\u0006\u0004\b\u001f\u0010 J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0016R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001f\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001b\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u000b\u001a\u0004\b\u001a\u0010\rR\u0017\u0010\u001e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001d\u0010\r\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/aiocombinestyle/imagestrategy/d;", "Lcom/tencent/guild/aio/component/combinestyle/ah;", "Landroid/content/Context;", "context", "Lcom/tencent/guild/aio/component/combinestyle/ag;", "callback", "", "a", "Landroid/graphics/drawable/Drawable;", "d", "", "I", "getRes", "()I", "res", "", "b", "Ljava/util/List;", "getDrawableBounds", "()Ljava/util/List;", "drawableBounds", "c", "Landroid/graphics/drawable/Drawable;", "getDefaultDrawable", "()Landroid/graphics/drawable/Drawable;", "defaultDrawable", "getDrawablePaddingLeft", "drawablePaddingLeft", "e", "getDrawablePaddingRight", "drawablePaddingRight", "<init>", "(ILjava/util/List;Landroid/graphics/drawable/Drawable;II)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class d implements ah {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int res;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final List<Integer> drawableBounds;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Drawable defaultDrawable;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int drawablePaddingLeft;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int drawablePaddingRight;

    public d(@DrawableRes int i3, @Nullable List<Integer> list, @Nullable Drawable drawable, int i16, int i17) {
        this.res = i3;
        this.drawableBounds = list;
        this.defaultDrawable = drawable;
        this.drawablePaddingLeft = i16;
        this.drawablePaddingRight = i17;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0052  */
    @Override // com.tencent.guild.aio.component.combinestyle.ah
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(@NotNull Context context, @NotNull ag callback) {
        int i3;
        List<Integer> list;
        List<Integer> list2;
        int f16;
        List<Integer> list3;
        int e16;
        Object orNull;
        Object orNull2;
        Object orNull3;
        Object orNull4;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Drawable drawable = ContextCompat.getDrawable(context, this.res);
        if (drawable != null) {
            List<Integer> list4 = this.drawableBounds;
            int i16 = 0;
            if (list4 != null) {
                orNull4 = CollectionsKt___CollectionsKt.getOrNull(list4, 0);
                Integer num = (Integer) orNull4;
                if (num != null) {
                    i3 = num.intValue();
                    list = this.drawableBounds;
                    if (list != null) {
                        orNull3 = CollectionsKt___CollectionsKt.getOrNull(list, 1);
                        Integer num2 = (Integer) orNull3;
                        if (num2 != null) {
                            i16 = num2.intValue();
                        }
                    }
                    list2 = this.drawableBounds;
                    if (list2 != null) {
                        orNull2 = CollectionsKt___CollectionsKt.getOrNull(list2, 2);
                        Integer num3 = (Integer) orNull2;
                        if (num3 != null) {
                            f16 = num3.intValue();
                            list3 = this.drawableBounds;
                            if (list3 != null) {
                                orNull = CollectionsKt___CollectionsKt.getOrNull(list3, 3);
                                Integer num4 = (Integer) orNull;
                                if (num4 != null) {
                                    e16 = num4.intValue();
                                    drawable.setBounds(i3, i16, f16, e16);
                                    callback.onLoaded(drawable);
                                }
                            }
                            e16 = ae.e();
                            drawable.setBounds(i3, i16, f16, e16);
                            callback.onLoaded(drawable);
                        }
                    }
                    f16 = ae.f();
                    list3 = this.drawableBounds;
                    if (list3 != null) {
                    }
                    e16 = ae.e();
                    drawable.setBounds(i3, i16, f16, e16);
                    callback.onLoaded(drawable);
                }
            }
            i3 = 0;
            list = this.drawableBounds;
            if (list != null) {
            }
            list2 = this.drawableBounds;
            if (list2 != null) {
            }
            f16 = ae.f();
            list3 = this.drawableBounds;
            if (list3 != null) {
            }
            e16 = ae.e();
            drawable.setBounds(i3, i16, f16, e16);
            callback.onLoaded(drawable);
        }
    }

    @Override // com.tencent.guild.aio.component.combinestyle.ah
    @Nullable
    /* renamed from: d, reason: from getter */
    public Drawable getDefaultDrawable() {
        return this.defaultDrawable;
    }

    public /* synthetic */ d(int i3, List list, Drawable drawable, int i16, int i17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i18 & 2) != 0 ? null : list, (i18 & 4) != 0 ? null : drawable, (i18 & 8) != 0 ? -1 : i16, (i18 & 16) != 0 ? -1 : i17);
    }
}
