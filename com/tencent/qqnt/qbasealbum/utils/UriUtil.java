package com.tencent.qqnt.qbasealbum.utils;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.FileUriExposedException;
import android.widget.ImageView;
import com.tencent.libra.LoadState;
import com.tencent.libra.base.model.UriModel;
import com.tencent.libra.download.LibraGroupKey;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.pic.api.IPicAIOApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import java.io.File;
import java.io.FileNotFoundException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0016\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u000f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u0010R\u001b\u0010\u0017\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/utils/UriUtil;", "", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "info", "Lcom/tencent/libra/base/model/UriModel;", "g", "", "path", "f", "Landroid/widget/ImageView;", "view", "Lcom/tencent/libra/request/Option;", "e", "", "i", "k", "", "isEdit", "c", "b", "Lkotlin/Lazy;", tl.h.F, "()Z", "useUri", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class UriUtil {
    static IPatchRedirector $redirector_;

    /* renamed from: a */
    @NotNull
    public static final UriUtil f361640a;

    /* renamed from: b, reason: from kotlin metadata */
    @NotNull
    private static final Lazy useUri;

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45302);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        f361640a = new UriUtil();
        lazy = LazyKt__LazyJVMKt.lazy(UriUtil$useUri$2.INSTANCE);
        useUri = lazy;
    }

    UriUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static /* synthetic */ String d(UriUtil uriUtil, LocalMediaInfo localMediaInfo, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        return uriUtil.c(localMediaInfo, z16);
    }

    private final UriModel g(LocalMediaInfo info) {
        if (com.tencent.qqnt.qbasealbum.ktx.b.o(info)) {
            return new UriModel(com.tencent.qqnt.qbasealbum.ktx.b.i(info));
        }
        return new UriModel(com.tencent.qqnt.qbasealbum.ktx.b.d(info));
    }

    private final boolean h() {
        return ((Boolean) useUri.getValue()).booleanValue();
    }

    public static final void l(LocalMediaInfo info, ImageView view, LoadState loadState, Option option) {
        Bitmap resultBitMap;
        Drawable drawable;
        Intrinsics.checkNotNullParameter(info, "$info");
        Intrinsics.checkNotNullParameter(view, "$view");
        if (loadState != LoadState.STATE_SUCCESS) {
            return;
        }
        Pair pair = null;
        if (com.tencent.qqnt.qbasealbum.ktx.b.m(info)) {
            Object animatable = option.getAnimatable();
            if (animatable instanceof Drawable) {
                drawable = (Drawable) animatable;
            } else {
                drawable = null;
            }
            if (drawable != null) {
                pair = TuplesKt.to(Integer.valueOf(drawable.getIntrinsicWidth()), Integer.valueOf(drawable.getIntrinsicHeight()));
            }
        } else if (option != null && (resultBitMap = option.getResultBitMap()) != null) {
            pair = TuplesKt.to(Integer.valueOf(resultBitMap.getWidth()), Integer.valueOf(resultBitMap.getHeight()));
        }
        if (pair == null) {
            ox3.a.f("UriUtil", new Function0<String>() { // from class: com.tencent.qqnt.qbasealbum.utils.UriUtil$loadMediaForPanelThumb$1$3$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) LocalMediaInfo.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                    return "bitmap decode error, path: " + LocalMediaInfo.this.getPath();
                }
            });
        } else {
            h.f361657a.b(view, ((Number) pair.component1()).intValue(), ((Number) pair.component2()).intValue());
        }
    }

    @NotNull
    public final String c(@NotNull LocalMediaInfo info, boolean isEdit) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, this, info, Boolean.valueOf(isEdit));
        }
        Intrinsics.checkNotNullParameter(info, "info");
        if (!h()) {
            String path = info.getPath();
            if (path == null) {
                return "";
            }
            return path;
        }
        if (!isEdit && !com.tencent.qqnt.qbasealbum.ktx.b.j(info)) {
            if (com.tencent.qqnt.qbasealbum.ktx.b.o(info)) {
                String uri = com.tencent.qqnt.qbasealbum.ktx.b.i(info).toString();
                Intrinsics.checkNotNullExpressionValue(uri, "info.getVideoUri().toString()");
                return uri;
            }
            String uri2 = com.tencent.qqnt.qbasealbum.ktx.b.d(info).toString();
            Intrinsics.checkNotNullExpressionValue(uri2, "info.getImageUri().toString()");
            return uri2;
        }
        return f(info.getPath());
    }

    @NotNull
    public final Option e(@NotNull ImageView view, @NotNull LocalMediaInfo info) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Option) iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, (Object) info);
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(info, "info");
        Option option = Option.obtain().setTargetView(view);
        if (info.getPath() == null) {
            Intrinsics.checkNotNullExpressionValue(option, "option");
            return option;
        }
        UriUtil uriUtil = f361640a;
        if (!uriUtil.h()) {
            option.setUrl(info.getPath());
        }
        if (com.tencent.qqnt.qbasealbum.ktx.b.o(info)) {
            option.setPreferDecoder(f11.a.class);
        }
        if (com.tencent.qqnt.qbasealbum.ktx.b.m(info)) {
            option.setPreferDecoder(com.tencent.libra.extension.gif.h.class);
        }
        if (uriUtil.h() && com.tencent.qqnt.qbasealbum.ktx.b.j(info)) {
            option.setModel(new UriModel(uriUtil.f(info.getPath())));
        } else if (uriUtil.h()) {
            option.setModel(uriUtil.g(info));
        }
        com.tencent.libra.util.a aVar = com.tencent.libra.util.a.f118813a;
        Intrinsics.checkNotNullExpressionValue(option, "getOption$lambda$3");
        aVar.q(option, true);
        LibraGroupKey libraGroupKey = new LibraGroupKey(info.getPath());
        libraGroupKey.setCacheStrategy(LibraGroupKey.CacheStrategy.HIGHEST);
        option.setGroupKey(libraGroupKey);
        Intrinsics.checkNotNullExpressionValue(option, "option");
        return option;
    }

    @NotNull
    public final String f(@Nullable String path) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) path);
        }
        String str = null;
        if (Build.VERSION.SDK_INT >= 24) {
            if (path != null) {
                try {
                    str = Uri.fromFile(new File(path)).toString();
                } catch (FileUriExposedException e16) {
                    ox3.a.c("UriUtil", new Function0<String>() { // from class: com.tencent.qqnt.qbasealbum.utils.UriUtil$getUriFromPath$2
                        static IPatchRedirector $redirector_;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(0);
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FileUriExposedException.this);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function0
                        @NotNull
                        public final String invoke() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                            }
                            return "getUriFromPath fail e: " + FileUriExposedException.this;
                        }
                    });
                } catch (FileNotFoundException e17) {
                    ox3.a.c("UriUtil", new Function0<String>(e17) { // from class: com.tencent.qqnt.qbasealbum.utils.UriUtil$getUriFromPath$3
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ FileNotFoundException $e;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                            this.$e = e17;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) e17);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function0
                        @NotNull
                        public final String invoke() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                            }
                            return "getUriFromPath fail e: " + this.$e;
                        }
                    });
                }
            }
            if (str == null) {
                return "";
            }
            return str;
        }
        if (path != null) {
            try {
                str = Uri.fromFile(new File(path)).toString();
            } catch (FileNotFoundException e18) {
                ox3.a.c("UriUtil", new Function0<String>(e18) { // from class: com.tencent.qqnt.qbasealbum.utils.UriUtil$getUriFromPath$5
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ FileNotFoundException $e;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.$e = e18;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) e18);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final String invoke() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                        }
                        return "getUriFromPath fail e: " + this.$e;
                    }
                });
            }
        }
        if (str == null) {
            return "";
        }
        return str;
        return "";
    }

    public final void i(@NotNull ImageView view, @NotNull LocalMediaInfo info) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view, (Object) info);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(info, "info");
        ((IPicAIOApi) QRoute.api(IPicAIOApi.class)).loadPic(e(view, info), new IPicLoadStateListener() { // from class: com.tencent.qqnt.qbasealbum.utils.j
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                UriUtil.j(loadState, option);
            }
        });
    }

    public final void k(@NotNull final ImageView view, @NotNull final LocalMediaInfo info) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view, (Object) info);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(info, "info");
        ((IPicAIOApi) QRoute.api(IPicAIOApi.class)).loadPic(e(view, info), new IPicLoadStateListener() { // from class: com.tencent.qqnt.qbasealbum.utils.k
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                UriUtil.l(LocalMediaInfo.this, view, loadState, option);
            }
        });
    }

    public static final void j(LoadState loadState, Option option) {
    }
}
