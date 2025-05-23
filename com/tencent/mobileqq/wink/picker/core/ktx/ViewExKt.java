package com.tencent.mobileqq.wink.picker.core.ktx;

import android.graphics.drawable.Animatable;
import android.widget.ImageView;
import com.tencent.libra.LoadState;
import com.tencent.libra.extension.gif.h;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.emoticon.QQSysFaceSwitcher;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.image.f;
import com.tencent.mobileqq.vas.image.j;
import com.tencent.mobileqq.wink.picker.MediaType;
import com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment;
import com.tencent.qqnt.emotion.pic.libra.d;
import com.tencent.widget.immersive.ImmersiveUtils;
import e93.i;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a\u0014\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u0005\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a6\u0010\r\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002\u001a*\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH\u0002\u001a\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u000fH\u0002\u001a\u0006\u0010\u0013\u001a\u00020\u0003\"\u001b\u0010\u0019\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0016\u0010\u001c\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\"\u0015\u0010\u001f\u001a\u00020\t*\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\"\u0015\u0010\u001f\u001a\u00020\t*\u00020 8F\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"\u00a8\u0006#"}, d2 = {"Landroid/widget/ImageView;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", QAdVrReportParams.ParamKey.MEDIA, "", DomainData.DOMAIN_NAME, "l", "imageView", "", "imageUrl", "", "requestSize", "Lcom/tencent/libra/listener/IPicLoadStateListener;", "listener", "i", "url", "Lcom/tencent/libra/request/Option;", "f", "option", "k", "g", "", "a", "Lkotlin/Lazy;", "e", "()Z", "enableApngSoDecoder", "b", "Z", "isApngSoLoaded", "d", "(I)I", "dp", "", "c", "(F)I", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class ViewExKt {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final Lazy f324504a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f324505b;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f324506a;

        static {
            int[] iArr = new int[MediaType.values().length];
            try {
                iArr[MediaType.LOCAL_IMAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MediaType.LOCAL_VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MediaType.QZONE_IMAGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MediaType.QZONE_VIDEO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f324506a = iArr;
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.wink.picker.core.ktx.ViewExKt$enableApngSoDecoder$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                return Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("wink_enable_apng_so_decoder", false));
            }
        });
        f324504a = lazy;
    }

    public static final int c(float f16) {
        return ImmersiveUtils.dpToPx(f16);
    }

    public static final int d(int i3) {
        return c(i3);
    }

    private static final boolean e() {
        return ((Boolean) f324504a.getValue()).booleanValue();
    }

    private static final Option f(ImageView imageView, LocalMediaInfo localMediaInfo, String str, int i3) {
        Option getOption$lambda$4 = Option.obtain();
        getOption$lambda$4.setTargetView(imageView);
        getOption$lambda$4.setUrl(str);
        getOption$lambda$4.setRequestWidth(i3);
        getOption$lambda$4.setRequestHeight(i3);
        WinkMediaPickerMainBaseFragment.Companion companion = WinkMediaPickerMainBaseFragment.INSTANCE;
        getOption$lambda$4.setLoadingDrawable(companion.b());
        getOption$lambda$4.setFailedDrawable(companion.a());
        if (i3 != 0) {
            com.tencent.libra.util.a aVar = com.tencent.libra.util.a.f118813a;
            Intrinsics.checkNotNullExpressionValue(getOption$lambda$4, "getOption$lambda$4");
            aVar.q(getOption$lambda$4, true);
        }
        if (i.E(localMediaInfo)) {
            getOption$lambda$4.setPreferDecoder(d11.a.class);
        } else if (i.I(localMediaInfo)) {
            getOption$lambda$4.setPreferDecoder(f11.a.class);
        } else if (i.F(localMediaInfo)) {
            getOption$lambda$4.setPreferDecoder(h.class);
        } else {
            Intrinsics.checkNotNullExpressionValue(getOption$lambda$4, "this");
            k(getOption$lambda$4);
        }
        Intrinsics.checkNotNullExpressionValue(getOption$lambda$4, "obtain().apply {\n       \u2026        }\n        }\n    }");
        return getOption$lambda$4;
    }

    public static final void g() {
        if (!f324505b && !f.f309589a.isApngSoLoaded()) {
            f324505b = true;
            w53.b.f("ViewEx", "requestLoadApngSo start");
            f.f309589a.a(new j.a() { // from class: com.tencent.mobileqq.wink.picker.core.ktx.b
                @Override // com.tencent.mobileqq.vas.image.j.a
                public final void onResult(boolean z16) {
                    ViewExKt.h(z16);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(boolean z16) {
        w53.b.f("ViewEx", "requestLoadApngSo result: " + z16);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001e, code lost:
    
        if (r3 == null) goto L12;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void i(ImageView imageView, LocalMediaInfo localMediaInfo, String path, int i3, IPicLoadStateListener iPicLoadStateListener) {
        boolean z16;
        boolean isBlank;
        boolean isBlank2;
        boolean isBlank3;
        if (path != null) {
            isBlank2 = StringsKt__StringsJVMKt.isBlank(path);
            if (isBlank2) {
                path = localMediaInfo.path;
                if (path != null) {
                    Intrinsics.checkNotNullExpressionValue(path, "path");
                    isBlank3 = StringsKt__StringsJVMKt.isBlank(path);
                    if (isBlank3) {
                        path = i.w(localMediaInfo);
                    }
                } else {
                    path = null;
                }
            }
        }
        path = i.w(localMediaInfo);
        if (path == null) {
            path = localMediaInfo.path;
        }
        if (path != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(path);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    imageView.setImageDrawable(WinkMediaPickerMainBaseFragment.INSTANCE.a());
                    return;
                } else {
                    QQPicLoader.f201806a.e(f(imageView, localMediaInfo, path, i3), iPicLoadStateListener);
                    return;
                }
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    static /* synthetic */ void j(ImageView imageView, LocalMediaInfo localMediaInfo, String str, int i3, IPicLoadStateListener iPicLoadStateListener, int i16, Object obj) {
        if ((i16 & 16) != 0) {
            iPicLoadStateListener = null;
        }
        i(imageView, localMediaInfo, str, i3, iPicLoadStateListener);
    }

    private static final void k(Option option) {
        if (!e()) {
            return;
        }
        g();
        if (QQSysFaceSwitcher.f204652a.t()) {
            option.setPreferDecoder(c11.b.class);
        } else {
            option.setPreferDecoder(d.class);
        }
    }

    public static final void l(@NotNull ImageView imageView, @NotNull LocalMediaInfo media) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(media, "media");
        IPicLoadStateListener iPicLoadStateListener = new IPicLoadStateListener() { // from class: com.tencent.mobileqq.wink.picker.core.ktx.c
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                ViewExKt.m(loadState, option);
            }
        };
        int i3 = a.f324506a[i.r(media).ordinal()];
        if (i3 != 1) {
            if (i3 == 3) {
                QQPicLoader.f201806a.e(f(imageView, media, i.j(media), 0), iPicLoadStateListener);
                return;
            }
            return;
        }
        i(imageView, media, null, 0, iPicLoadStateListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0008, code lost:
    
        if (r2.isFinishSuccess() == true) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m(LoadState loadState, Option option) {
        boolean z16;
        Animatable animatable;
        if (loadState != null) {
            z16 = true;
        }
        z16 = false;
        if (z16) {
            r01.c cVar = null;
            if (option != null) {
                animatable = option.getAnimatable();
            } else {
                animatable = null;
            }
            if (animatable instanceof r01.c) {
                cVar = (r01.c) animatable;
            }
            if (cVar != null) {
                cVar.setLoopCount(0);
                cVar.start();
            }
        }
    }

    public static final void n(@NotNull ImageView imageView, @NotNull LocalMediaInfo media) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(media, "media");
        int i3 = a.f324506a[i.r(media).ordinal()];
        boolean z16 = true;
        if (i3 != 1 && i3 != 2) {
            if (i3 == 3 || i3 == 4) {
                j(imageView, media, null, 300, null, 16, null);
                return;
            }
            return;
        }
        String str = media.missionID;
        if (str != null && str.length() != 0) {
            z16 = false;
        }
        if (!z16 && FileUtils.fileExists(media.thumbnailPath)) {
            j(imageView, media, media.thumbnailPath, 300, null, 16, null);
        } else {
            j(imageView, media, null, 300, null, 16, null);
        }
    }
}
