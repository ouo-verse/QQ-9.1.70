package com.tencent.mobileqq.guild.util;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000M\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0005*\u0001\u0019\u001ax\u0010\u0012\u001a\u00020\u0010*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2%\b\u0002\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000b\u00a2\u0006\u0004\b\u0012\u0010\u0013\u001a\u0016\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016\"\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/util/t;", "", "url", "Landroid/widget/ImageView;", "targetView", "", "requestWidth", "requestHeight", "Landroid/graphics/drawable/Drawable;", "loadingDrawable", "failedDrawable", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "Lkotlin/ParameterName;", "name", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "bitmapLoaded", "b", "(Lcom/tencent/mobileqq/guild/util/t;Ljava/lang/String;Landroid/widget/ImageView;Ljava/lang/Integer;Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Lkotlin/jvm/functions/Function1;)V", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "d", "com/tencent/mobileqq/guild/util/w$b", "a", "Lcom/tencent/mobileqq/guild/util/w$b;", "loggableListener", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class w {

    /* renamed from: a */
    @NotNull
    private static final b f235705a = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/util/w$a", "Lcom/tencent/mobileqq/guild/picload/listener/GuildPicStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a extends GuildPicStateListener {

        /* renamed from: e */
        final /* synthetic */ Function1<Bitmap, Unit> f235706e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(Function1<? super Bitmap, Unit> function1) {
            super(true);
            this.f235706e = function1;
        }

        @Override // com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener
        public void c(@NotNull LoadState state, @NotNull Option option) {
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(option, "option");
            if (state == LoadState.STATE_SUCCESS && option.getResultBitMap() != null) {
                Function1<Bitmap, Unit> function1 = this.f235706e;
                Bitmap resultBitMap = option.getResultBitMap();
                Intrinsics.checkNotNullExpressionValue(resultBitMap, "option.resultBitMap");
                function1.invoke(resultBitMap);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/util/w$b", "Lcom/tencent/mobileqq/guild/picload/listener/GuildPicStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends GuildPicStateListener {
        b() {
            super(true);
        }

        @Override // com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener
        public void c(@NotNull LoadState state, @NotNull Option option) {
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(option, "option");
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().c("Guild.comm.GuildImageUtils.Async", 2, "onStateChang() loadImage " + option.getUrl() + " state=" + state.name());
            }
            w.d(state, option);
        }
    }

    public static final void b(@NotNull t tVar, @NotNull String url, @NotNull ImageView targetView, @Nullable Integer num, @Nullable Integer num2, @Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Function1<? super Bitmap, Unit> function1) {
        IPicLoadStateListener b16;
        Intrinsics.checkNotNullParameter(tVar, "<this>");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            Logger.a d16 = logger.d();
            int identityHashCode = System.identityHashCode(targetView);
            d16.c("Guild.comm.GuildImageUtils.Async", 2, tVar.getClass().getName() + ".loadImage() load " + url + " into [" + identityHashCode + "] " + targetView + "(" + num + "," + num2 + ")");
        }
        Option failDrawable = v.c(url, targetView, num, num2).setLoadingDrawable(drawable).setFailDrawable(drawable2);
        if (function1 == null) {
            b16 = f235705a;
        } else {
            b16 = GuildPicStateListener.b(f235705a, new a(function1));
        }
        com.tencent.mobileqq.guild.picload.e.a().f(failDrawable, b16);
    }

    public static /* synthetic */ void c(t tVar, String str, ImageView imageView, Integer num, Integer num2, Drawable drawable, Drawable drawable2, Function1 function1, int i3, Object obj) {
        Integer num3;
        Integer num4;
        Drawable drawable3;
        Drawable drawable4;
        Function1 function12;
        if ((i3 & 4) != 0) {
            num3 = null;
        } else {
            num3 = num;
        }
        if ((i3 & 8) != 0) {
            num4 = null;
        } else {
            num4 = num2;
        }
        if ((i3 & 16) != 0) {
            drawable3 = null;
        } else {
            drawable3 = drawable;
        }
        if ((i3 & 32) != 0) {
            drawable4 = null;
        } else {
            drawable4 = drawable2;
        }
        if ((i3 & 64) != 0) {
            function12 = null;
        } else {
            function12 = function1;
        }
        b(tVar, str, imageView, num3, num4, drawable3, drawable4, function12);
    }

    public static final void d(@NotNull LoadState state, @NotNull Option option) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(option, "option");
        ImageView targetView = option.getTargetView();
        if (targetView == null) {
            return;
        }
        Object tag = targetView.getTag(R.id.wiq);
        if (!(tag instanceof String)) {
            return;
        }
        com.tencent.mobileqq.guild.performance.report.t.b(state, option, (String) tag);
    }
}
