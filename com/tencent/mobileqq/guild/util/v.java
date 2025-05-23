package com.tencent.mobileqq.guild.util;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.widget.GuildLevelRoleView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b)\u0010*J7\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ7\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0007\u00a2\u0006\u0004\b\f\u0010\u000bJ7\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u0006H\u0007J\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0007J$\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\r2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0007J4\u0010 \u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u00062\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00150\u001dH\u0007J*\u0010%\u001a\u00020\u00152\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010$\u001a\u00020#H\u0007J/\u0010(\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0017\u0010'\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00150\u001d\u00a2\u0006\u0002\b&\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/guild/util/v;", "", "", "url", "", "preDecode", "", "requestWidth", "requestHeight", "Lcom/tencent/libra/request/Option;", "e", "(Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/Integer;)Lcom/tencent/libra/request/Option;", "b", "Landroid/widget/ImageView;", "view", "c", "(Ljava/lang/String;Landroid/widget/ImageView;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/tencent/libra/request/Option;", "Landroid/graphics/Bitmap;", "bitmapOrg", "max", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "i", "targetView", "Landroid/graphics/drawable/Drawable;", "loadingDrawable", "k", "imageView", "colorRes", "Lkotlin/Function1;", "Lcom/tencent/theme/SkinnableBitmapDrawable;", "onResult", "g", "reqW", "reqH", "Lcom/tencent/mobileqq/guild/widget/GuildLevelRoleView$a;", "listener", "f", "Lkotlin/ExtensionFunctionType;", "block", "j", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final v f235697a = new v();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/util/v$a", "Lcom/tencent/mobileqq/guild/picload/listener/GuildPicStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a extends GuildPicStateListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ GuildLevelRoleView.a f235698e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f235699f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f235700h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(GuildLevelRoleView.a aVar, int i3, int i16) {
            super(true);
            this.f235698e = aVar;
            this.f235699f = i3;
            this.f235700h = i16;
        }

        @Override // com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener
        public void c(@NotNull LoadState state, @NotNull Option option) {
            Unit unit;
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(option, "option");
            if (!state.isFinishSuccess()) {
                return;
            }
            Bitmap resultBitMap = option.getResultBitMap();
            if (resultBitMap != null) {
                GuildLevelRoleView.a aVar = this.f235698e;
                int i3 = this.f235699f;
                int i16 = this.f235700h;
                if (resultBitMap.isRecycled()) {
                    Logger logger = Logger.f235387a;
                    Logger.b bVar = new Logger.b();
                    String str = "loadCommonPic onStateChangeCallback resultBitmap: " + resultBitMap + " isRecycled: " + resultBitMap.isRecycled() + " seq: " + option.getSeq();
                    if (str instanceof String) {
                        bVar.a().add(str);
                    }
                    Iterator<T> it = bVar.a().iterator();
                    while (it.hasNext()) {
                        Logger.f235387a.d().b("Guild.comm.GuildImageUtils.Async", 1, (String) it.next(), null);
                    }
                    aVar.a(null);
                } else if (resultBitMap.getWidth() == i3 && resultBitMap.getHeight() == i16) {
                    aVar.a(resultBitMap);
                } else {
                    aVar.a(v.m(resultBitMap, i3));
                }
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                this.f235698e.a(null);
            }
        }
    }

    v() {
    }

    @JvmStatic
    @NotNull
    public static final Option b(@NotNull String url, boolean preDecode, @Nullable Integer requestWidth, @Nullable Integer requestHeight) {
        Intrinsics.checkNotNullParameter(url, "url");
        Option option = new Option().setUrl(url).setPredecode(preDecode).setNeedFilterUrl(false);
        if (preDecode && requestWidth != null && requestHeight != null && requestWidth.intValue() > 0 && requestHeight.intValue() > 0) {
            option.setRequestWidth(requestWidth.intValue()).setRequestHeight(requestHeight.intValue());
        }
        Intrinsics.checkNotNullExpressionValue(option, "option");
        return option;
    }

    @JvmStatic
    @NotNull
    public static final Option c(@NotNull String url, @NotNull ImageView view, @Nullable Integer requestWidth, @Nullable Integer requestHeight) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(view, "view");
        Option option = new Option().setUrl(url).setTargetView(view).setNeedFilterUrl(false);
        if (requestWidth != null && requestHeight != null) {
            option.setRequestWidth(requestWidth.intValue()).setRequestHeight(requestHeight.intValue());
        } else if (view.getLayoutParams() != null) {
            option.setRequestWidth(view.getLayoutParams().width).setRequestHeight(view.getLayoutParams().height);
        }
        Intrinsics.checkNotNullExpressionValue(option, "option");
        return option;
    }

    public static /* synthetic */ Option d(String str, ImageView imageView, Integer num, Integer num2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            num = null;
        }
        if ((i3 & 8) != 0) {
            num2 = null;
        }
        return c(str, imageView, num, num2);
    }

    @JvmStatic
    @NotNull
    public static final Option e(@NotNull String url, boolean preDecode, @Nullable Integer requestWidth, @Nullable Integer requestHeight) {
        Intrinsics.checkNotNullParameter(url, "url");
        Option option = new Option().setUrl(url).setFromPreLoad(true).setPredecode(preDecode).setNeedFilterUrl(false);
        if (preDecode && requestWidth != null && requestHeight != null && requestWidth.intValue() > 0 && requestHeight.intValue() > 0) {
            option.setRequestWidth(requestWidth.intValue()).setRequestHeight(requestHeight.intValue());
        }
        Intrinsics.checkNotNullExpressionValue(option, "option");
        return option;
    }

    @JvmStatic
    public static final void f(@Nullable String url, int reqW, int reqH, @NotNull GuildLevelRoleView.a listener) {
        boolean z16;
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (url != null && url.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            listener.a(null);
        } else {
            com.tencent.mobileqq.guild.u.o(url, reqW, reqH, new a(listener, reqW, reqH));
        }
    }

    @JvmStatic
    public static final void g(@NotNull String url, @NotNull final ImageView imageView, final int colorRes, @NotNull final Function1<? super SkinnableBitmapDrawable, Unit> onResult) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        Intrinsics.checkNotNullParameter(onResult, "onResult");
        f(url, imageView.getWidth(), imageView.getHeight(), new GuildLevelRoleView.a() { // from class: com.tencent.mobileqq.guild.util.u
            @Override // com.tencent.mobileqq.guild.widget.GuildLevelRoleView.a
            public final void a(Bitmap bitmap) {
                v.h(imageView, colorRes, onResult, bitmap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(ImageView imageView, int i3, Function1 onResult, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(imageView, "$imageView");
        Intrinsics.checkNotNullParameter(onResult, "$onResult");
        SkinnableBitmapDrawable skinnableBitmapDrawable = new SkinnableBitmapDrawable(imageView.getResources(), bitmap);
        skinnableBitmapDrawable.mutate2();
        skinnableBitmapDrawable.setColorFilter(new PorterDuffColorFilter(imageView.getContext().getResources().getColor(i3), PorterDuff.Mode.SRC_IN));
        onResult.invoke(skinnableBitmapDrawable);
    }

    @JvmStatic
    public static final void i(@NotNull String url, @NotNull ImageView view) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(view, "view");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.comm.GuildImageUtils", 2, "loadImage() " + url + " into [" + System.identityHashCode(view) + "] " + view);
        }
        com.tencent.mobileqq.guild.picload.e.a().f(d(url, view, null, null, 12, null), w.a());
    }

    @JvmStatic
    public static final void k(@NotNull String url, @NotNull ImageView targetView, @Nullable Drawable loadingDrawable) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        Logger logger = Logger.f235387a;
        if (QLog.isDebugVersion()) {
            logger.d().d("Guild.comm.GuildImageUtils", 1, "loadImageWithLoading " + url + " into [" + System.identityHashCode(targetView) + "] " + targetView);
        }
        com.tencent.mobileqq.guild.picload.e.a().f(d(url, targetView, null, null, 12, null).setLoadingDrawable(loadingDrawable), w.a());
    }

    public static /* synthetic */ void l(String str, ImageView imageView, Drawable drawable, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        }
        k(str, imageView, drawable);
    }

    @JvmStatic
    @Nullable
    public static final Bitmap m(@Nullable Bitmap bitmapOrg, int max) {
        int coerceAtLeast;
        boolean z16;
        Bitmap bitmap = null;
        if (bitmapOrg == null) {
            return null;
        }
        Matrix matrix = new Matrix();
        int width = bitmapOrg.getWidth();
        int height = bitmapOrg.getHeight();
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(width, height);
        float f16 = max / (coerceAtLeast * 1.0f);
        if (f16 == 1.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && f16 > 0.0f) {
            try {
                matrix.postScale(f16, f16);
                bitmap = Bitmap.createBitmap(bitmapOrg, 0, 0, width, height, matrix, true);
            } catch (Exception e16) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                String str = "scaleBitmap : " + e16.getMessage();
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("Guild.comm.GuildImageUtils", 1, (String) it.next(), null);
                }
            } catch (OutOfMemoryError unused) {
                Logger logger2 = Logger.f235387a;
                Logger.b bVar2 = new Logger.b();
                bVar2.a().add("scaleBitmap :  scaleBitmap OOM");
                Iterator<T> it5 = bVar2.a().iterator();
                while (it5.hasNext()) {
                    Logger.f235387a.d().e("Guild.comm.GuildImageUtils", 1, (String) it5.next(), null);
                }
            }
        }
        if (bitmap != null) {
            return bitmap;
        }
        return bitmapOrg;
    }

    public final void j(@NotNull String url, @NotNull ImageView view, @NotNull Function1<? super Option, Unit> block) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(block, "block");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.comm.GuildImageUtils", 2, "loadImage() " + url + " into [" + System.identityHashCode(view) + "] " + view);
        }
        Option d16 = d(url, view, null, null, 12, null);
        block.invoke(d16);
        com.tencent.mobileqq.guild.picload.e.a().f(d16, w.a());
    }
}
