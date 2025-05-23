package com.tencent.mobileqq.guild.theme;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import androidx.annotation.DrawableRes;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.GuildBannerPalette;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.bc;
import com.tencent.mobileqq.guild.util.k;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.theme.SkinnableNinePatchDrawable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\u0007J\"\u0010\f\u001a\u00020\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\nH\u0002J\"\u0010\u0010\u001a\u00020\u00022\b\b\u0001\u0010\r\u001a\u00020\u00062\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\nH\u0002J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000e*\u0004\u0018\u00010\u0011H\u0002J\u0018\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\b2\b\b\u0001\u0010\r\u001a\u00020\u0006R\"\u0010\u0017\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\n0\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\"\u0010\u001c\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\n0\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0016R \u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/theme/QuiBitmapResourceObtainColorHelper;", "", "", "j", "Landroid/content/Context;", "context", "", "res", "Landroidx/lifecycle/LiveData;", "g", "Landroidx/lifecycle/MutableLiveData;", "liveData", tl.h.F, "resId", "Landroid/graphics/Bitmap;", "colorLiveData", "f", "Landroid/graphics/drawable/Drawable;", "i", "e", "Landroid/util/SparseArray;", "b", "Landroid/util/SparseArray;", "liveDataMap", "c", "Landroidx/lifecycle/MutableLiveData;", "liveDataMapNotInVas", "d", "bubbleColorLiveDataMap", "", "Ljava/util/Map;", "tokenVasMap", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class QuiBitmapResourceObtainColorHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final QuiBitmapResourceObtainColorHelper f235295a = new QuiBitmapResourceObtainColorHelper();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final SparseArray<MutableLiveData<Integer>> liveDataMap = new SparseArray<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final MutableLiveData<Integer> liveDataMapNotInVas = new MutableLiveData<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final SparseArray<MutableLiveData<Bitmap>> bubbleColorLiveDataMap = new SparseArray<>(2);

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<Integer, Integer> tokenVasMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/theme/QuiBitmapResourceObtainColorHelper$a", "Lcom/tencent/mobileqq/guild/theme/d;", "", "onThemeChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a implements d {
        a() {
        }

        @Override // com.tencent.mobileqq.guild.theme.d
        public void onThemeChanged() {
            Logger.f235387a.d().d("QuiBitmapResourceObtainColorHelper", 1, "onThemeChanged, isVasTheme: " + QQTheme.isVasTheme());
            SparseArray sparseArray = QuiBitmapResourceObtainColorHelper.liveDataMap;
            int size = sparseArray.size();
            for (int i3 = 0; i3 < size; i3++) {
                QuiBitmapResourceObtainColorHelper.f235295a.h(sparseArray.keyAt(i3), (MutableLiveData) sparseArray.valueAt(i3));
            }
            QuiBitmapResourceObtainColorHelper.f235295a.j();
        }
    }

    static {
        Map<Integer, Integer> mapOf;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(Integer.valueOf(R.drawable.qui_common_bg_bottom_standard_bg), Integer.valueOf(R.drawable.skin_background)));
        tokenVasMap = mapOf;
        GuildThemeManager.g(new a());
    }

    QuiBitmapResourceObtainColorHelper() {
    }

    private final void f(@DrawableRes int resId, MutableLiveData<Bitmap> colorLiveData) {
        k kVar = new k();
        Drawable m3 = QQGuildUIUtil.m(resId);
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.d.f261782e);
        Intrinsics.checkNotNull(f16);
        CorountineFunKt.e(f16, "QuiBitmapResourceObtainColorHelper obtainBubbleDrawableAsyncInternal", null, null, null, new QuiBitmapResourceObtainColorHelper$obtainBubbleDrawableAsyncInternal$1(m3, colorLiveData, kVar, resId, null), 14, null);
    }

    @JvmStatic
    @NotNull
    public static final LiveData<Integer> g(@NotNull Context context, @DrawableRes int res) {
        Intrinsics.checkNotNullParameter(context, "context");
        Resources resources = context.getResources();
        if ((resources instanceof com.tencent.mobileqq.guild.quiprofile.c) && ((com.tencent.mobileqq.guild.quiprofile.c) resources).getIsVasThemeDisabled()) {
            return liveDataMapNotInVas;
        }
        SparseArray<MutableLiveData<Integer>> sparseArray = liveDataMap;
        MutableLiveData<Integer> mutableLiveData = sparseArray.get(res);
        if (mutableLiveData == null) {
            MutableLiveData<Integer> mutableLiveData2 = new MutableLiveData<>();
            sparseArray.put(res, mutableLiveData2);
            f235295a.h(res, mutableLiveData2);
            return mutableLiveData2;
        }
        return mutableLiveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [T, android.graphics.Bitmap] */
    public final void h(@DrawableRes final int res, final MutableLiveData<Integer> liveData) {
        final int i3;
        String str;
        Integer num;
        Integer num2 = null;
        if (!QQTheme.isVasTheme()) {
            Logger.f235387a.d().d("QuiBitmapResourceObtainColorHelper", 1, "obtainColor(isVasTheme: false): null");
            liveData.setValue(null);
            return;
        }
        final String currentThemeId = QQTheme.getCurrentThemeId();
        Integer num3 = tokenVasMap.get(Integer.valueOf(res));
        if (num3 != null) {
            i3 = num3.intValue();
        } else {
            i3 = res;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? i16 = i(QQGuildUIUtil.m(i3));
        objectRef.element = i16;
        if (i16 != 0 && (i16.getWidth() > 20 || ((Bitmap) objectRef.element).getHeight() > 20)) {
            GuildBannerPalette.g((Bitmap) objectRef.element, new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.guild.theme.QuiBitmapResourceObtainColorHelper$obtainColorInVasTheme$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num4) {
                    invoke(num4.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i17) {
                    if (Intrinsics.areEqual(currentThemeId, QQTheme.getCurrentThemeId())) {
                        liveData.setValue(Integer.valueOf(i17));
                        Logger logger = Logger.f235387a;
                        String str2 = currentThemeId;
                        int i18 = res;
                        int i19 = i3;
                        Ref.ObjectRef<Bitmap> objectRef2 = objectRef;
                        logger.d().d("QuiBitmapResourceObtainColorHelper", 1, "obtainColor2(themeId: " + str2 + ", res: " + i18 + ", resVas:" + i19 + "): " + Integer.toHexString(i17) + ", bitmap: " + objectRef2.element.getWidth() + ", " + objectRef2.element.getHeight());
                        return;
                    }
                    Logger logger2 = Logger.f235387a;
                    int i26 = res;
                    int i27 = i3;
                    String str3 = currentThemeId;
                    logger2.d().w("QuiBitmapResourceObtainColorHelper", 1, "obtainColor3(res: " + i26 + ", resVas:" + i27 + ") themeId changed\uff1a " + str3 + " -> " + QQTheme.getCurrentThemeId());
                }
            });
            return;
        }
        Integer d16 = bc.f235460a.d(res);
        Logger.a d17 = Logger.f235387a.d();
        if (d16 != null) {
            str = Integer.toHexString(d16.intValue());
        } else {
            str = null;
        }
        Bitmap bitmap = (Bitmap) objectRef.element;
        if (bitmap != null) {
            num = Integer.valueOf(bitmap.getWidth());
        } else {
            num = null;
        }
        Bitmap bitmap2 = (Bitmap) objectRef.element;
        if (bitmap2 != null) {
            num2 = Integer.valueOf(bitmap2.getHeight());
        }
        d17.w("QuiBitmapResourceObtainColorHelper", 1, "obtainColor1(themeId: " + currentThemeId + ", res: " + res + ", resVas:" + i3 + "): " + str + ", bitmap: " + num + ", " + num2);
        liveData.setValue(d16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap i(Drawable drawable) {
        if (drawable instanceof SkinnableBitmapDrawable) {
            return ((SkinnableBitmapDrawable) drawable).getBitmap();
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        if (drawable instanceof SkinnableNinePatchDrawable) {
            return ((SkinnableNinePatchDrawable) drawable).getBitmap();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        boolean isVasTheme = QQTheme.isVasTheme();
        SparseArray<MutableLiveData<Bitmap>> sparseArray = bubbleColorLiveDataMap;
        int size = sparseArray.size();
        for (int i3 = 0; i3 < size; i3++) {
            int keyAt = sparseArray.keyAt(i3);
            MutableLiveData<Bitmap> valueAt = sparseArray.valueAt(i3);
            if (isVasTheme) {
                f235295a.f(keyAt, valueAt);
            } else {
                Logger.f235387a.d().d("QuiBitmapResourceObtainColorHelper", 1, "[obtainBubbleColor] isVas=false: null");
                valueAt.setValue(null);
            }
        }
    }

    @NotNull
    public final LiveData<Bitmap> e(@DrawableRes int resId) {
        SparseArray<MutableLiveData<Bitmap>> sparseArray = bubbleColorLiveDataMap;
        MutableLiveData<Bitmap> mutableLiveData = sparseArray.get(resId);
        if (mutableLiveData == null) {
            mutableLiveData = new MutableLiveData<>();
            sparseArray.put(resId, mutableLiveData);
            if (QQTheme.isVasTheme()) {
                f235295a.f(resId, mutableLiveData);
            } else {
                Logger.f235387a.d().d("QuiBitmapResourceObtainColorHelper", 1, "[obtainBubbleColor] resId=" + resId + " isVasTheme=false");
                mutableLiveData.setValue(null);
            }
        }
        return mutableLiveData;
    }
}
