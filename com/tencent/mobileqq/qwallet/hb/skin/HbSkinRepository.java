package com.tencent.mobileqq.qwallet.hb.skin;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tencent.mobileqq.qwallet.hb.skin.local.HbSkinLocalDataSource;
import com.tencent.mobileqq.qwallet.hb.skin.remote.HbSkinRemoteDataSource;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import com.tencent.xweb.FileReaderHelper;
import cooperation.qwallet.plugin.QWalletPicHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sk2.QWalletHbCommonConfig;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b$\u0010%J\"\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002JC\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00022!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\bJE\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00022#\u0010\r\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000f\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\f0\bJ&\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0002JG\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00022#\u0010\r\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000f\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\f0\bJ\u0010\u0010\u0016\u001a\u00020\f2\b\b\u0002\u0010\u0015\u001a\u00020\u0014J\u0018\u0010\u0019\u001a\u00020\f2\u0010\u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0017J\u0018\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004RT\u0010#\u001aB\u0012\f\u0012\n \u001f*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n \u001f*\u0004\u0018\u00010\u000f0\u000f \u001f* \u0012\f\u0012\n \u001f*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n \u001f*\u0004\u0018\u00010\u000f0\u000f\u0018\u00010 0\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/skin/HbSkinRepository;", "", "", "skinId", "", "outerSkinId", "skinFrom", "c", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "skinType", "", "receiver", "g", "Lcom/tencent/mobileqq/qwallet/hb/skin/HbSkinData;", "hbSkinData", "d", "e", "i", "", FileReaderHelper.OPEN_FILE_FROM_FORCE, "k", "", "skinIdList", "j", "Landroid/widget/ImageView;", "openView", "openIconUrl", h.F, "", "kotlin.jvm.PlatformType", "", "b", "Ljava/util/Map;", "skinCacheMap", "<init>", "()V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class HbSkinRepository {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final HbSkinRepository f277840a = new HbSkinRepository();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Map<String, HbSkinData> skinCacheMap = Collections.synchronizedMap(new LRULinkedHashMap(30));

    HbSkinRepository() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String c(int skinId, String outerSkinId, int skinFrom) {
        return skinId + "-" + outerSkinId + "-" + skinFrom;
    }

    public static /* synthetic */ HbSkinData f(HbSkinRepository hbSkinRepository, int i3, String str, int i16, int i17, Object obj) {
        if ((i17 & 2) != 0) {
            str = "";
        }
        if ((i17 & 4) != 0) {
            i16 = 0;
        }
        return hbSkinRepository.e(i3, str, i16);
    }

    public final void d(int skinId, @Nullable String outerSkinId, int skinFrom, @NotNull Function1<? super HbSkinData, Unit> receiver) {
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        HbSkinData e16 = e(skinId, outerSkinId, skinFrom);
        if (e16 != null) {
            QLog.i("HbSkinRepository", 1, "localHbSkinData = " + e16);
            receiver.invoke(e16);
            return;
        }
        i(skinId, outerSkinId, skinFrom, receiver);
    }

    @Nullable
    public final HbSkinData e(int skinId, @Nullable String outerSkinId, int skinFrom) {
        String c16 = c(skinId, outerSkinId, skinFrom);
        Map<String, HbSkinData> skinCacheMap2 = skinCacheMap;
        HbSkinData hbSkinData = skinCacheMap2.get(c16);
        if (hbSkinData != null) {
            return hbSkinData;
        }
        HbSkinLocalDataSource hbSkinLocalDataSource = HbSkinLocalDataSource.f277855a;
        if (outerSkinId == null) {
            outerSkinId = "";
        }
        HbSkinData e16 = hbSkinLocalDataSource.e(skinId, outerSkinId, skinFrom);
        if (e16 != null) {
            Intrinsics.checkNotNullExpressionValue(skinCacheMap2, "skinCacheMap");
            skinCacheMap2.put(c16, e16);
        }
        return e16;
    }

    public final void g(int skinId, @Nullable String outerSkinId, int skinFrom, @NotNull final Function1<? super Integer, Unit> receiver) {
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        d(skinId, outerSkinId, skinFrom, new Function1<HbSkinData, Unit>() { // from class: com.tencent.mobileqq.qwallet.hb.skin.HbSkinRepository$getSkinType$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HbSkinData hbSkinData) {
                invoke2(hbSkinData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable HbSkinData hbSkinData) {
                receiver.invoke(Integer.valueOf(hbSkinData != null ? hbSkinData.getSkinType() : 0));
            }
        });
    }

    public final void h(@NotNull ImageView openView, @Nullable String openIconUrl) {
        boolean z16;
        Intrinsics.checkNotNullParameter(openView, "openView");
        Drawable drawable = ContextCompat.getDrawable(openView.getContext(), R.drawable.nvm);
        boolean z17 = false;
        if (openIconUrl != null && openIconUrl.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            String hbOpenUrl = ((QWalletHbCommonConfig) ((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).getConfig(IQWalletUnitedConfigApi.QWALLET_HB_COMMON_CONFIG, new QWalletHbCommonConfig(null, null, false, false, 15, null))).getHbOpenUrl();
            if (hbOpenUrl == null || hbOpenUrl.length() == 0) {
                z17 = true;
            }
            if (!z17) {
                drawable = QWalletPicHelper.getNetDrawableForQWallet(hbOpenUrl, drawable);
            }
        } else {
            drawable = QWalletPicHelper.getNetDrawableForQWallet(openIconUrl, drawable);
        }
        openView.setImageDrawable(drawable);
    }

    public final void i(final int skinId, @Nullable final String outerSkinId, final int skinFrom, @NotNull final Function1<? super HbSkinData, Unit> receiver) {
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        HbSkinRemoteDataSource.f277873a.i(skinId, outerSkinId, skinFrom, new Function2<HbSkinRemoteDataSource.ResultCode, HbSkinData, Unit>() { // from class: com.tencent.mobileqq.qwallet.hb.skin.HbSkinRepository$updateSkinData$1

            /* compiled from: P */
            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            /* loaded from: classes16.dex */
            public /* synthetic */ class a {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f277842a;

                static {
                    int[] iArr = new int[HbSkinRemoteDataSource.ResultCode.values().length];
                    try {
                        iArr[HbSkinRemoteDataSource.ResultCode.SUCCESS.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    f277842a = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(HbSkinRemoteDataSource.ResultCode resultCode, HbSkinData hbSkinData) {
                invoke2(resultCode, hbSkinData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull HbSkinRemoteDataSource.ResultCode resultCode, @Nullable HbSkinData hbSkinData) {
                Map skinCacheMap2;
                String c16;
                Intrinsics.checkNotNullParameter(resultCode, "resultCode");
                receiver.invoke(hbSkinData);
                if (a.f277842a[resultCode.ordinal()] != 1) {
                    QLog.e("HbSkinRepository", 1, "responseSkinData: result failed");
                    return;
                }
                if (hbSkinData != null) {
                    QLog.i("HbSkinRepository", 1, "responseSkinData = " + hbSkinData);
                    skinCacheMap2 = HbSkinRepository.skinCacheMap;
                    Intrinsics.checkNotNullExpressionValue(skinCacheMap2, "skinCacheMap");
                    c16 = HbSkinRepository.f277840a.c(skinId, outerSkinId, skinFrom);
                    skinCacheMap2.put(c16, hbSkinData);
                    HbSkinLocalDataSource.f277855a.f(hbSkinData);
                    return;
                }
                QLog.e("HbSkinRepository", 1, "responseSkinData: result success but version is null or skinList is null");
            }
        });
    }

    public final void j(@Nullable List<Integer> skinIdList) {
        List list;
        HbSkinRemoteDataSource hbSkinRemoteDataSource = HbSkinRemoteDataSource.f277873a;
        if (skinIdList != null) {
            list = CollectionsKt___CollectionsKt.filterNotNull(skinIdList);
        } else {
            list = null;
        }
        HbSkinRemoteDataSource.m(hbSkinRemoteDataSource, "", list, null, 0, new Function3<HbSkinRemoteDataSource.ResultCode, String, List<? extends HbSkinData>, Unit>() { // from class: com.tencent.mobileqq.qwallet.hb.skin.HbSkinRepository$updateSkinDataList$2

            /* compiled from: P */
            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            /* loaded from: classes16.dex */
            public /* synthetic */ class a {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f277844a;

                static {
                    int[] iArr = new int[HbSkinRemoteDataSource.ResultCode.values().length];
                    try {
                        iArr[HbSkinRemoteDataSource.ResultCode.SUCCESS.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    f277844a = iArr;
                }
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(HbSkinRemoteDataSource.ResultCode resultCode, String str, List<? extends HbSkinData> list2) {
                invoke2(resultCode, str, (List<HbSkinData>) list2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull HbSkinRemoteDataSource.ResultCode resultCode, @Nullable String str, @Nullable List<HbSkinData> list2) {
                int collectionSizeOrDefault;
                Intrinsics.checkNotNullParameter(resultCode, "resultCode");
                if (a.f277844a[resultCode.ordinal()] != 1) {
                    QLog.e("HbSkinRepository", 1, "updateSkinDataList: result " + resultCode);
                    return;
                }
                if (list2 != null && str != null) {
                    List<HbSkinData> list3 = list2;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                    Iterator<T> it = list3.iterator();
                    while (it.hasNext()) {
                        arrayList.add(Integer.valueOf(((HbSkinData) it.next()).getSkinId()));
                    }
                    QLog.i("HbSkinRepository", 1, "updateSkinDataList: " + arrayList);
                    HbSkinLocalDataSource.f277855a.j(list2);
                    return;
                }
                QLog.e("HbSkinRepository", 1, "updateSkinDataList: result success but version is null or skinList is null");
            }
        }, 12, null);
    }

    public final void k(boolean force) {
        HbSkinRemoteDataSource.f277873a.e(force, new Function3<HbSkinRemoteDataSource.ResultCode, String, List<? extends HbSkinData>, Unit>() { // from class: com.tencent.mobileqq.qwallet.hb.skin.HbSkinRepository$updateSkinDataList$1

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: P */
            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.qwallet.hb.skin.HbSkinRepository$updateSkinDataList$1$1, reason: invalid class name */
            /* loaded from: classes16.dex */
            public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<String, Unit> {
                AnonymousClass1(Object obj) {
                    super(1, obj, HbSkinRemoteDataSource.class, "updateLocalVersion", "updateLocalVersion(Ljava/lang/String;)V", 0);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull String p06) {
                    Intrinsics.checkNotNullParameter(p06, "p0");
                    ((HbSkinRemoteDataSource) this.receiver).o(p06);
                }
            }

            /* compiled from: P */
            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            /* loaded from: classes16.dex */
            public /* synthetic */ class a {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f277843a;

                static {
                    int[] iArr = new int[HbSkinRemoteDataSource.ResultCode.values().length];
                    try {
                        iArr[HbSkinRemoteDataSource.ResultCode.SUCCESS.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    f277843a = iArr;
                }
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(HbSkinRemoteDataSource.ResultCode resultCode, String str, List<? extends HbSkinData> list) {
                invoke2(resultCode, str, (List<HbSkinData>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull HbSkinRemoteDataSource.ResultCode resultCode, @Nullable String str, @Nullable List<HbSkinData> list) {
                Intrinsics.checkNotNullParameter(resultCode, "resultCode");
                if (a.f277843a[resultCode.ordinal()] != 1) {
                    QLog.e("HbSkinRepository", 1, "updateSkinData: result " + resultCode);
                    return;
                }
                if (list != null && str != null) {
                    QLog.i("HbSkinRepository", 1, "updateSkinData: skin list size = " + list.size());
                    HbSkinLocalDataSource.f277855a.g(list, str, new AnonymousClass1(HbSkinRemoteDataSource.f277873a));
                    return;
                }
                QLog.e("HbSkinRepository", 1, "updateSkinData: result success but version is null or skinList is null");
            }
        });
    }
}
