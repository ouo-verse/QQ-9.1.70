package com.tencent.mobileqq.zplan.servlet.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.zplan.model.ZPlanAvatar;
import com.tencent.mobileqq.zplan.model.b;
import com.tencent.mobileqq.zplan.model.c;
import com.tencent.mobileqq.zplan.model.g;
import com.tencent.mobileqq.zplan.servlet.d;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.state.data.SquareJSConst;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import nk3.f;
import nk3.i;
import nk3.j;
import nk3.k;
import nk3.l;
import nk3.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00a0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&J\u001a\u0010\n\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u0002H&J8\u0010\u000f\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\rH&J\"\u0010\u0010\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH&J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH&J(\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H&J*\u0010\u0017\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH&J0\u0010\u001a\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u00182\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH&J2\u0010#\u001a\u00020\u00042\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00182\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010\"\u001a\u00020!H&J.\u0010'\u001a\u00020\u00042\f\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\u00182\u0006\u0010\u0003\u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020&H&J>\u0010'\u001a\u00020\u00042\f\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\u00182\u0016\u0010*\u001a\u0012\u0012\u0004\u0012\u00020!0(j\b\u0012\u0004\u0012\u00020!`)2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020+H&J\u0018\u0010-\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020!2\u0006\u0010 \u001a\u00020,H&J\u0018\u0010/\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020!2\u0006\u0010 \u001a\u00020.H&J\"\u00102\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020!2\u0006\u00101\u001a\u0002002\b\u0010 \u001a\u0004\u0018\u00010\u001fH&J\u0016\u00106\u001a\u0002052\f\u00104\u001a\b\u0012\u0004\u0012\u00020$03H&J\b\u00108\u001a\u000207H&J\u0010\u00109\u001a\u0002072\u0006\u0010\u0003\u001a\u00020!H&J\u0018\u0010;\u001a\u00020\u00042\u0006\u0010:\u001a\u0002072\u0006\u0010 \u001a\u00020\u001fH&J0\u0010@\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020!2\u0006\u0010<\u001a\u00020\u001d2\u000e\u0010>\u001a\n\u0012\u0004\u0012\u00020=\u0018\u00010\u00182\u0006\u0010 \u001a\u00020?H&\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/zplan/servlet/api/IZPlanRequest;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "uin", "", "queryRegister", "getZPlanAvatarData", "Lcom/tencent/common/app/AppInterface;", "app", "appid", "getZPlanForwardRecentList", "openId", "appId", "Lcom/tencent/mobileqq/zplan/servlet/d;", "listener", "getZPlanAddFriendSetting", "getZPlanEditAvatarSetting", "getIsFriendByUin", "url", NodeProps.CUSTOM_PROP_IMAGE_TYPE, "Lnk3/k;", "picListener", "uploadPic", "getIsFriendByOpenId", "", "openIdList", "getIsFriendByOpenIdList", "Lcom/tencent/mobileqq/zplan/model/b;", "userInfoList", "", "serviceType", "Lnk3/a;", "callback", "", "timeoutMillis", "requestOidb1123", "Lcom/tencent/mobileqq/zplan/model/c;", "userInfoDesList", "Lnk3/p;", "requestOidb1127", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", SquareJSConst.Params.PARAMS_UIN_LIST, "Lnk3/l;", "Lnk3/f;", "getDynamicAvatar", "Lnk3/j;", "getStaticAvatar", "Lcom/tencent/mobileqq/zplan/model/f$a;", "dynamicAvatar", "setDynamicAvatar", "", "keys", "", "getZPlanResourceUrlRequestBusiBuf", "", "isCmshowMonthActiveUser", "isZPlanAioAvatarUser", "isChecked", "setZplanProfileCardSettingSwitch", "handleType", "Lcom/tencent/mobileqq/zplan/model/g;", "infos", "Lnk3/i;", "requestAddDCBackImage", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IZPlanRequest extends QRouteApi {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class a {
        public static /* synthetic */ void a(IZPlanRequest iZPlanRequest, List list, int i3, nk3.a aVar, long j3, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 8) != 0) {
                    j3 = 30000;
                }
                iZPlanRequest.requestOidb1123(list, i3, aVar, j3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: requestOidb1123");
        }
    }

    void getDynamicAvatar(long uin, @NotNull f callback);

    void getIsFriendByOpenId(@Nullable AppInterface app, @NotNull String openId, @NotNull String appId, @NotNull d listener);

    void getIsFriendByOpenIdList(@Nullable AppInterface app, @NotNull List<String> openIdList, @NotNull String appId, @NotNull d listener);

    void getIsFriendByUin(@NotNull String uin, @NotNull d listener);

    void getStaticAvatar(long uin, @NotNull j callback);

    void getZPlanAddFriendSetting(@Nullable AppInterface app, @Nullable String uin, @Nullable String openId, @Nullable String appId, @NotNull d listener);

    void getZPlanAvatarData();

    void getZPlanEditAvatarSetting(@Nullable AppInterface app, @NotNull String uin, @NotNull d listener);

    void getZPlanForwardRecentList(@Nullable AppInterface app, @NotNull String appid);

    @NotNull
    byte[] getZPlanResourceUrlRequestBusiBuf(@NotNull List<c> keys);

    boolean isCmshowMonthActiveUser();

    boolean isZPlanAioAvatarUser(long uin);

    void queryRegister(@NotNull String uin);

    void requestAddDCBackImage(long uin, int handleType, @Nullable List<? extends g> infos, @NotNull i callback);

    void requestOidb1123(@NotNull List<b> userInfoList, int serviceType, @Nullable nk3.a callback, long timeoutMillis);

    void requestOidb1127(@NotNull List<c> userInfoDesList, long uin, int serviceType, @NotNull p callback);

    void requestOidb1127(@NotNull List<c> userInfoDesList, @NotNull ArrayList<Long> uinList, int serviceType, @NotNull l callback);

    void setDynamicAvatar(long uin, @NotNull ZPlanAvatar.ZPlanDynamicAvatar dynamicAvatar, @Nullable nk3.a callback);

    void setZplanProfileCardSettingSwitch(boolean isChecked, @NotNull nk3.a callback);

    void uploadPic(@NotNull String uin, @NotNull String url, @NotNull String imageType, @NotNull k picListener);
}
