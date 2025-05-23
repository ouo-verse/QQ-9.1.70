package com.tencent.mobileqq.vas.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import com.tencent.mobileqq.vas.data.SmallHomeGroupSettingData;
import com.tencent.mobileqq.vas.data.VasTroopSmallHomeInfo;
import com.tencent.mobileqq.vas.transit.TransitPageInfo;
import com.tencent.mobileqq.vas.transit.VisitorInfo;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@QRouteFactory(singleton = true)
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fJ$\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H&J$\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\u0004H&J&\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0007\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u00060\u0004H&J2\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00060\u000fH&J \u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H&J\u0018\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0019H&J\u0018\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u000bH&\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/vas/api/IVasZplanGroupApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "groupId", "Lkotlin/Function1;", "", "", "callback", "getSmallHomeNickEntrance", "Lcom/tencent/mobileqq/vas/data/g;", "getSmallHomeTopEntrance", "Lcom/tencent/mobileqq/vas/data/SmallHomeGroupSettingData;", "getSmallHomeGroupSetting", "", "currentState", "Lkotlin/Function2;", "", "setSmallHomeGroupSetting", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/vas/transit/TransitPageInfo;", "info", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "openSmallHomeTransitPage", "Lcom/tencent/mobileqq/vas/transit/VisitorInfo;", "visitorInfo", "openHippyRankPage", "data", "openSmallHomeGroupSettingPage", "Companion", "a", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVasZplanGroupApi extends QRouteApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f308454a;
    public static final int GROUP_SETTING_SWITCH_OFF = 2;
    public static final int GROUP_SETTING_SWITCH_ON = 1;
    public static final int GROUP_SETTING_SWITCH_UNKNOWN = 0;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/vas/api/IVasZplanGroupApi$a;", "", "<init>", "()V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.api.IVasZplanGroupApi$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f308454a = new Companion();

        Companion() {
        }
    }

    void getSmallHomeGroupSetting(long groupId, @NotNull Function1<? super SmallHomeGroupSettingData, Unit> callback);

    void getSmallHomeNickEntrance(long groupId, @NotNull Function1<? super Boolean, Unit> callback);

    void getSmallHomeTopEntrance(long groupId, @NotNull Function1<? super VasTroopSmallHomeInfo, Unit> callback);

    void openHippyRankPage(@NotNull Context context, @NotNull VisitorInfo visitorInfo);

    void openSmallHomeGroupSettingPage(@NotNull Context context, @NotNull SmallHomeGroupSettingData data);

    void openSmallHomeTransitPage(@NotNull Context context, @NotNull TransitPageInfo info, @NotNull ZootopiaSource source);

    void setSmallHomeGroupSetting(long groupId, int currentState, @NotNull Function2<? super Integer, ? super String, Unit> callback);
}
