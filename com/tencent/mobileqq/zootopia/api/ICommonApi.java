package com.tencent.mobileqq.zootopia.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import com.tencent.zplan.luabridge.LuaBasePlugin;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pu4.o;
import pu4.p;

/* compiled from: P */
@QRouteFactory(singleton = true)
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0006H&J \u0010\u000e\u001a\u00020\r2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0006\u0018\u00010\u000bH&J\b\u0010\u000f\u001a\u00020\rH&J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H&\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/zootopia/api/ICommonApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/mobileqq/zootopia/api/f;", "getDialogHandler", "", "getSelfGender", "", "Lpu4/o;", "getSelfClothesIdList", "Lpu4/p;", "getSelfClothesInfo", "Lcom/tencent/mobileqq/zootopia/api/e;", "callback", "", "requestSelfClothesInfo", "refreshClothesCache", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "plugin", "registerZootopiaLuaPlugin", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface ICommonApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(ICommonApi iCommonApi, e eVar, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    eVar = null;
                }
                iCommonApi.requestSelfClothesInfo(eVar);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: requestSelfClothesInfo");
        }
    }

    @NotNull
    f getDialogHandler();

    @NotNull
    List<o> getSelfClothesIdList();

    @NotNull
    List<p> getSelfClothesInfo();

    int getSelfGender();

    void refreshClothesCache();

    void registerZootopiaLuaPlugin(@NotNull LuaBasePlugin plugin);

    void requestSelfClothesInfo(@Nullable e<List<p>> callback);
}
