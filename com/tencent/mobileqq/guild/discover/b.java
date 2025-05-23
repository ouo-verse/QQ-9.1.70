package com.tencent.mobileqq.guild.discover;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/guild/discover/b;", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    private static final int f216497b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final ColorDrawable f216498c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final ColorDrawable f216499d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final com.tencent.mobileqq.guild.discover.widget.c f216500e;

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006J6\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006JB\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006R\u0017\u0010\u0012\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/discover/b$a;", "", "Landroid/widget/ImageView;", "imageView", "", "url", "Lcom/tencent/mobileqq/guild/picload/listener/GuildPicStateListener;", "callBack", "", "d", "", "requestW", "requestH", "c", "Landroid/graphics/drawable/Drawable;", "loadingDrawable", "b", "Landroid/graphics/drawable/ColorDrawable;", "imgLoadingDrawable", "Landroid/graphics/drawable/ColorDrawable;", "a", "()Landroid/graphics/drawable/ColorDrawable;", "undefine", "I", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.discover.b$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/discover/b$a$a", "Lcom/tencent/mobileqq/guild/picload/listener/GuildPicStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.discover.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes13.dex */
        public static final class C7713a extends GuildPicStateListener {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f216501e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C7713a(String str) {
                super(true);
                this.f216501e = str;
            }

            @Override // com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener
            public void c(@NotNull LoadState state, @NotNull Option option) {
                Intrinsics.checkNotNullParameter(state, "state");
                Intrinsics.checkNotNullParameter(option, "option");
                if (state == LoadState.STATE_SUCCESS && option.getResultBitMap() != null) {
                    h12.c.c(this.f216501e, new BitmapDrawable(BaseApplication.getContext().getResources(), option.getResultBitMap()));
                }
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void e(Companion companion, ImageView imageView, String str, int i3, int i16, Drawable drawable, GuildPicStateListener guildPicStateListener, int i17, Object obj) {
            int i18;
            int i19;
            Drawable drawable2;
            GuildPicStateListener guildPicStateListener2;
            if ((i17 & 4) != 0) {
                i18 = -1;
            } else {
                i18 = i3;
            }
            if ((i17 & 8) != 0) {
                i19 = -1;
            } else {
                i19 = i16;
            }
            if ((i17 & 16) != 0) {
                drawable2 = companion.a();
            } else {
                drawable2 = drawable;
            }
            if ((i17 & 32) != 0) {
                guildPicStateListener2 = null;
            } else {
                guildPicStateListener2 = guildPicStateListener;
            }
            companion.b(imageView, str, i18, i19, drawable2, guildPicStateListener2);
        }

        public static /* synthetic */ void f(Companion companion, ImageView imageView, String str, int i3, int i16, GuildPicStateListener guildPicStateListener, int i17, Object obj) {
            int i18;
            int i19;
            if ((i17 & 4) != 0) {
                i18 = -1;
            } else {
                i18 = i3;
            }
            if ((i17 & 8) != 0) {
                i19 = -1;
            } else {
                i19 = i16;
            }
            if ((i17 & 16) != 0) {
                guildPicStateListener = null;
            }
            companion.c(imageView, str, i18, i19, guildPicStateListener);
        }

        public static /* synthetic */ void g(Companion companion, ImageView imageView, String str, GuildPicStateListener guildPicStateListener, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                guildPicStateListener = null;
            }
            companion.d(imageView, str, guildPicStateListener);
        }

        @NotNull
        public final ColorDrawable a() {
            return b.f216498c;
        }

        public final void b(@NotNull ImageView imageView, @NotNull String url, int requestW, int requestH, @Nullable Drawable loadingDrawable, @Nullable GuildPicStateListener callBack) {
            CharSequence trim;
            boolean z16;
            Intrinsics.checkNotNullParameter(imageView, "imageView");
            Intrinsics.checkNotNullParameter(url, "url");
            trim = StringsKt__StringsKt.trim((CharSequence) url);
            if (trim.toString().length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                imageView.setImageDrawable(loadingDrawable);
                return;
            }
            Option url2 = new Option().setTargetView(imageView).setNeedFilterUrl(false).setUrl(url);
            url2.setLoadingDrawable(loadingDrawable);
            if (requestW != -1 && requestH != -1) {
                url2.setRequestWidth(requestW);
                url2.setRequestHeight(requestH);
            }
            if (callBack != null) {
                com.tencent.mobileqq.guild.picload.e.a().f(url2, callBack);
            } else {
                com.tencent.mobileqq.guild.picload.e.a().f(url2, new C7713a(url));
            }
        }

        public final void c(@NotNull ImageView imageView, @NotNull String url, int requestW, int requestH, @Nullable GuildPicStateListener callBack) {
            Intrinsics.checkNotNullParameter(imageView, "imageView");
            Intrinsics.checkNotNullParameter(url, "url");
            b(imageView, url, requestW, requestH, a(), callBack);
        }

        public final void d(@NotNull ImageView imageView, @NotNull String url, @Nullable GuildPicStateListener callBack) {
            Intrinsics.checkNotNullParameter(imageView, "imageView");
            Intrinsics.checkNotNullParameter(url, "url");
            c(imageView, url, -1, -1, callBack);
        }

        Companion() {
        }
    }

    static {
        int color = BaseApplication.getContext().getResources().getColor(R.color.f157116k8);
        f216497b = color;
        f216498c = new ColorDrawable(color);
        f216499d = new ColorDrawable(0);
        f216500e = new com.tencent.mobileqq.guild.discover.widget.c();
    }
}
