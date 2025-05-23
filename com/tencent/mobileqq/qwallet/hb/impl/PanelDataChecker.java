package com.tencent.mobileqq.qwallet.hb.impl;

import com.qwallet.temp.IQWalletTemp;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.IQWalletFestivalHbApi;
import com.tencent.mobileqq.qwallet.hb.send.PanelEntryData;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0002H\u0002J\u0019\u0010\u000b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ!\u0010\u000e\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002\u00a2\u0006\u0004\b\u000e\u0010\bJ#\u0010\u000f\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007\u00a2\u0006\u0004\b\u000f\u0010\bJ!\u0010\u0010\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002\u00a2\u0006\u0004\b\u0010\u0010\bJ!\u0010\u0011\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002\u00a2\u0006\u0004\b\u0011\u0010\bJ!\u0010\u0012\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002\u00a2\u0006\u0004\b\u0012\u0010\bJ!\u0010\u0013\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007\u00a2\u0006\u0004\b\u0013\u0010\bRR\u0010\u001a\u001a@\u0012\u0004\u0012\u00020\u0002\u00126\u00124\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u00150\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/impl/PanelDataChecker;", "", "", "curType", "Lcom/tencent/mobileqq/qwallet/hb/send/PanelEntryData;", "panelData", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Ljava/lang/Integer;Lcom/tencent/mobileqq/qwallet/hb/send/PanelEntryData;)Z", "type", "e", "f", "(Ljava/lang/Integer;)Z", ShortVideoConstants.PARAM_KEY_SESSION_TYPE, "g", "l", "j", "k", tl.h.F, "i", "", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "b", "Ljava/util/Map;", "mTypeCheckerMap", "<init>", "()V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class PanelDataChecker {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final PanelDataChecker f277484a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<Integer, Function2<Integer, PanelEntryData, Boolean>> mTypeCheckerMap;

    static {
        Map<Integer, Function2<Integer, PanelEntryData, Boolean>> mutableMapOf;
        PanelDataChecker panelDataChecker = new PanelDataChecker();
        f277484a = panelDataChecker;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(0, new PanelDataChecker$mTypeCheckerMap$1(panelDataChecker)), TuplesKt.to(1, new PanelDataChecker$mTypeCheckerMap$2(panelDataChecker)), TuplesKt.to(2, new PanelDataChecker$mTypeCheckerMap$3(panelDataChecker)), TuplesKt.to(6, new PanelDataChecker$mTypeCheckerMap$4(panelDataChecker)), TuplesKt.to(11, new PanelDataChecker$mTypeCheckerMap$5(panelDataChecker)), TuplesKt.to(18, new PanelDataChecker$mTypeCheckerMap$6(panelDataChecker)));
        mTypeCheckerMap = mutableMapOf;
    }

    PanelDataChecker() {
    }

    private final boolean e(int type) {
        if (type == 1 || type == 3000) {
            return true;
        }
        return false;
    }

    private final boolean f(Integer type) {
        if (type != null && type.intValue() == 10014) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean g(Integer sessionType, PanelEntryData panelData) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean h(Integer sessionType, PanelEntryData panelData) {
        if (sessionType != null && !e(sessionType.intValue()) && !f(sessionType)) {
            return false;
        }
        return true;
    }

    @JvmStatic
    public static final boolean i(@Nullable Integer sessionType, @NotNull PanelEntryData panelData) {
        Intrinsics.checkNotNullParameter(panelData, "panelData");
        return ((IQWalletFestivalHbApi) QRoute.api(IQWalletFestivalHbApi.class)).verifyPanelData(sessionType, panelData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean j(Integer sessionType, PanelEntryData panelData) {
        if (sessionType != null && ((IQWalletTemp) QRoute.api(IQWalletTemp.class)).isTempConv(sessionType.intValue())) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean k(Integer sessionType, PanelEntryData panelData) {
        if (sessionType != null && ((IQWalletTemp) QRoute.api(IQWalletTemp.class)).isTempConv(sessionType.intValue())) {
            return false;
        }
        return true;
    }

    @JvmStatic
    public static final boolean l(@Nullable Integer sessionType, @Nullable PanelEntryData panelData) {
        if (sessionType != null) {
            PanelDataChecker panelDataChecker = f277484a;
            if (!panelDataChecker.e(sessionType.intValue()) && !panelDataChecker.f(sessionType)) {
                return false;
            }
        }
        return true;
    }

    @JvmStatic
    public static final boolean m(@Nullable Integer curType, @NotNull PanelEntryData panelData) {
        Intrinsics.checkNotNullParameter(panelData, "panelData");
        if (curType != null && ((IQWalletTemp) QRoute.api(IQWalletTemp.class)).isTempConv(curType.intValue()) && panelData.getType() != 0) {
            return false;
        }
        if (f277484a.f(curType)) {
            if ((panelData.getAioScene() & 2) == 0) {
                return false;
            }
        } else if ((panelData.getAioScene() & 1) == 0) {
            return false;
        }
        Function2<Integer, PanelEntryData, Boolean> function2 = mTypeCheckerMap.get(Integer.valueOf(panelData.getType()));
        if (function2 == null) {
            return true;
        }
        return function2.invoke(curType, panelData).booleanValue();
    }
}
