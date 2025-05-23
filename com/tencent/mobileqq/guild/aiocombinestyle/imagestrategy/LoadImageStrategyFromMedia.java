package com.tencent.mobileqq.guild.aiocombinestyle.imagestrategy;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.guild.aio.component.combinestyle.ae;
import com.tencent.guild.aio.component.combinestyle.ag;
import com.tencent.guild.aio.component.combinestyle.ah;
import com.tencent.guild.aio.util.ui.UIUtil;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildMediaChannelApi;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u000f\u0018\u00002\u00020\u0001BC\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u001d\u001a\u00020\n\u0012\b\b\u0002\u0010 \u001a\u00020\n\u00a2\u0006\u0004\b!\u0010\"J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0016R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\n8\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001f\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001d\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010 \u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001f\u0010\u001c\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/aiocombinestyle/imagestrategy/LoadImageStrategyFromMedia;", "Lcom/tencent/guild/aio/component/combinestyle/ah;", "Landroid/content/Context;", "context", "Lcom/tencent/guild/aio/component/combinestyle/ag;", "callback", "", "a", "Landroid/graphics/drawable/Drawable;", "d", "", "Ljava/lang/Integer;", "getMaterialId", "()Ljava/lang/Integer;", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "b", "Landroid/graphics/drawable/Drawable;", "getDefaultDrawable", "()Landroid/graphics/drawable/Drawable;", "defaultDrawable", "", "c", "Ljava/util/List;", "getDrawableBounds", "()Ljava/util/List;", "drawableBounds", "I", "getDrawablePaddingLeft", "()I", "drawablePaddingLeft", "e", "getDrawablePaddingRight", "drawablePaddingRight", "<init>", "(Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;Ljava/util/List;II)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class LoadImageStrategyFromMedia implements ah {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Integer materialId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Drawable defaultDrawable;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final List<Integer> drawableBounds;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int drawablePaddingLeft;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int drawablePaddingRight;

    public LoadImageStrategyFromMedia(@Nullable Integer num, @Nullable Drawable drawable, @Nullable List<Integer> list, int i3, int i16) {
        this.materialId = num;
        this.defaultDrawable = drawable;
        this.drawableBounds = list;
        this.drawablePaddingLeft = i3;
        this.drawablePaddingRight = i16;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0044  */
    @Override // com.tencent.guild.aio.component.combinestyle.ah
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(@NotNull Context context, @NotNull final ag callback) {
        final int f16;
        List<Integer> list;
        final int e16;
        Object orNull;
        Object orNull2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Integer num = this.materialId;
        if (num != null) {
            int intValue = num.intValue();
            final URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            Drawable drawable = ResourcesCompat.getDrawable(UIUtil.f112434a.x(), R.color.ajr, null);
            obtain.mLoadingDrawable = drawable;
            obtain.mFailedDrawable = drawable;
            List<Integer> list2 = this.drawableBounds;
            if (list2 != null) {
                orNull2 = CollectionsKt___CollectionsKt.getOrNull(list2, 2);
                Integer num2 = (Integer) orNull2;
                if (num2 != null) {
                    f16 = num2.intValue();
                    list = this.drawableBounds;
                    if (list != null) {
                        orNull = CollectionsKt___CollectionsKt.getOrNull(list, 3);
                        Integer num3 = (Integer) orNull;
                        if (num3 != null) {
                            e16 = num3.intValue();
                            obtain.mLoadingDrawable.setBounds(0, 0, f16, e16);
                            ((IGuildMediaChannelApi) QRoute.api(IGuildMediaChannelApi.class)).getGiftResFilePathByMaterialId(intValue, new Function3<Boolean, Integer, String, Unit>() { // from class: com.tencent.mobileqq.guild.aiocombinestyle.imagestrategy.LoadImageStrategyFromMedia$load$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num4, String str) {
                                    invoke(bool.booleanValue(), num4.intValue(), str);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(boolean z16, int i3, @Nullable String str) {
                                    Drawable drawable2;
                                    if (z16 && !TextUtils.isEmpty(str)) {
                                        drawable2 = URLDrawable.getFileDrawable(str, URLDrawable.URLDrawableOptions.this);
                                        drawable2.setBounds(0, 0, f16, e16);
                                    } else {
                                        drawable2 = ResourcesCompat.getDrawable(UIUtil.f112434a.x(), ((IGuildMediaChannelApi) QRoute.api(IGuildMediaChannelApi.class)).getDefaultGiftDrawableResId(), null);
                                    }
                                    if (drawable2 != null) {
                                        callback.onLoaded(drawable2);
                                    }
                                }
                            });
                        }
                    }
                    e16 = ae.e();
                    obtain.mLoadingDrawable.setBounds(0, 0, f16, e16);
                    ((IGuildMediaChannelApi) QRoute.api(IGuildMediaChannelApi.class)).getGiftResFilePathByMaterialId(intValue, new Function3<Boolean, Integer, String, Unit>() { // from class: com.tencent.mobileqq.guild.aiocombinestyle.imagestrategy.LoadImageStrategyFromMedia$load$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num4, String str) {
                            invoke(bool.booleanValue(), num4.intValue(), str);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z16, int i3, @Nullable String str) {
                            Drawable drawable2;
                            if (z16 && !TextUtils.isEmpty(str)) {
                                drawable2 = URLDrawable.getFileDrawable(str, URLDrawable.URLDrawableOptions.this);
                                drawable2.setBounds(0, 0, f16, e16);
                            } else {
                                drawable2 = ResourcesCompat.getDrawable(UIUtil.f112434a.x(), ((IGuildMediaChannelApi) QRoute.api(IGuildMediaChannelApi.class)).getDefaultGiftDrawableResId(), null);
                            }
                            if (drawable2 != null) {
                                callback.onLoaded(drawable2);
                            }
                        }
                    });
                }
            }
            f16 = ae.f();
            list = this.drawableBounds;
            if (list != null) {
            }
            e16 = ae.e();
            obtain.mLoadingDrawable.setBounds(0, 0, f16, e16);
            ((IGuildMediaChannelApi) QRoute.api(IGuildMediaChannelApi.class)).getGiftResFilePathByMaterialId(intValue, new Function3<Boolean, Integer, String, Unit>() { // from class: com.tencent.mobileqq.guild.aiocombinestyle.imagestrategy.LoadImageStrategyFromMedia$load$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num4, String str) {
                    invoke(bool.booleanValue(), num4.intValue(), str);
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16, int i3, @Nullable String str) {
                    Drawable drawable2;
                    if (z16 && !TextUtils.isEmpty(str)) {
                        drawable2 = URLDrawable.getFileDrawable(str, URLDrawable.URLDrawableOptions.this);
                        drawable2.setBounds(0, 0, f16, e16);
                    } else {
                        drawable2 = ResourcesCompat.getDrawable(UIUtil.f112434a.x(), ((IGuildMediaChannelApi) QRoute.api(IGuildMediaChannelApi.class)).getDefaultGiftDrawableResId(), null);
                    }
                    if (drawable2 != null) {
                        callback.onLoaded(drawable2);
                    }
                }
            });
        }
    }

    @Override // com.tencent.guild.aio.component.combinestyle.ah
    @Nullable
    /* renamed from: d, reason: from getter */
    public Drawable getDefaultDrawable() {
        return this.defaultDrawable;
    }

    public /* synthetic */ LoadImageStrategyFromMedia(Integer num, Drawable drawable, List list, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(num, (i17 & 2) != 0 ? null : drawable, (i17 & 4) != 0 ? null : list, (i17 & 8) != 0 ? -1 : i3, (i17 & 16) != 0 ? -1 : i16);
    }
}
