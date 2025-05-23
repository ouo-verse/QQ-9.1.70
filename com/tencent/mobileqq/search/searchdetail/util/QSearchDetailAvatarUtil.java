package com.tencent.mobileqq.search.searchdetail.util;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchUtilFetcher;
import java.lang.ref.WeakReference;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004R\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000bR\"\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/util/QSearchDetailAvatarUtil;", "", "Lcom/tencent/mobileqq/app/face/IFaceDecoder;", "b", "", "uin", "Landroid/graphics/drawable/Drawable;", "d", "troopUin", "f", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "faceDecoderRef", "Ljava/util/WeakHashMap;", "Lcom/tencent/mobileqq/search/searchdetail/util/a;", "c", "Ljava/util/WeakHashMap;", "drawableMap", "Lcom/tencent/mobileqq/search/api/ISearchUtilFetcher;", "Lkotlin/Lazy;", "e", "()Lcom/tencent/mobileqq/search/api/ISearchUtilFetcher;", "faceFetcher", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class QSearchDetailAvatarUtil {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static WeakReference<IFaceDecoder> faceDecoderRef;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy faceFetcher;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final QSearchDetailAvatarUtil f284719a = new QSearchDetailAvatarUtil();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final WeakHashMap<a, Object> drawableMap = new WeakHashMap<>();

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ISearchUtilFetcher>() { // from class: com.tencent.mobileqq.search.searchdetail.util.QSearchDetailAvatarUtil$faceFetcher$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ISearchUtilFetcher invoke() {
                return (ISearchUtilFetcher) QRoute.api(ISearchUtilFetcher.class);
            }
        });
        faceFetcher = lazy;
    }

    QSearchDetailAvatarUtil() {
    }

    private final IFaceDecoder b() {
        IFaceDecoder iFaceDecoder;
        WeakReference<IFaceDecoder> weakReference = faceDecoderRef;
        if (weakReference != null) {
            iFaceDecoder = weakReference.get();
        } else {
            iFaceDecoder = null;
        }
        if (iFaceDecoder != null) {
            return iFaceDecoder;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        AppInterface appInterface = (AppInterface) peekAppRuntime;
        IFaceDecoder iQQAvatarService = ((IQQAvatarService) appInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(appInterface);
        iQQAvatarService.setDecodeTaskCompletionListener(new DecodeTaskCompletionListener() { // from class: com.tencent.mobileqq.search.searchdetail.util.g
            @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
            public final void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
                QSearchDetailAvatarUtil.c(i3, i16, str, bitmap);
            }
        });
        faceDecoderRef = new WeakReference<>(iQQAvatarService);
        return iQQAvatarService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(int i3, int i16, String str, Bitmap bitmap) {
        IFaceDecoder iFaceDecoder;
        WeakReference<IFaceDecoder> weakReference = faceDecoderRef;
        boolean z16 = false;
        if (weakReference != null && (iFaceDecoder = weakReference.get()) != null && !iFaceDecoder.isPausing()) {
            z16 = true;
        }
        if (!z16) {
            return;
        }
        Set<a> keySet = drawableMap.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "drawableMap.keys");
        for (a aVar : keySet) {
            if (aVar.getType() == i16 && Intrinsics.areEqual(aVar.getUin(), str)) {
                aVar.setDrawable(new BitmapDrawable(bitmap));
            }
        }
    }

    private final ISearchUtilFetcher e() {
        return (ISearchUtilFetcher) faceFetcher.getValue();
    }

    @NotNull
    public final Drawable d(@NotNull String uin) {
        Drawable drawable;
        Intrinsics.checkNotNullParameter(uin, "uin");
        IFaceDecoder b16 = b();
        ISearchUtilFetcher e16 = e();
        if (e16 != null) {
            drawable = e16.getFaceBitmap(b16, uin, 1);
        } else {
            drawable = null;
        }
        a aVar = new a(drawable, uin, 1, b16);
        drawableMap.put(aVar, null);
        return aVar;
    }

    @NotNull
    public final Drawable f(@NotNull String troopUin) {
        Drawable drawable;
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        IFaceDecoder b16 = b();
        ISearchUtilFetcher e16 = e();
        if (e16 != null) {
            drawable = e16.getFaceBitmap(b16, troopUin, 4);
        } else {
            drawable = null;
        }
        a aVar = new a(drawable, troopUin, 4, b16);
        drawableMap.put(aVar, null);
        return aVar;
    }
}
