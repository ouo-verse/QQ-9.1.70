package com.tencent.mobileqq.zplan.servlet.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.zplan.aio.a;
import com.tencent.mobileqq.zplan.ipc.business.c;
import com.tencent.mobileqq.zplan.ipc.business.e;
import com.tencent.mobileqq.zplan.model.ZPlanAvatar;
import com.tencent.mobileqq.zplan.model.g;
import com.tencent.mobileqq.zplan.servlet.ZPlanRequest;
import com.tencent.mobileqq.zplan.servlet.ZPlanUserInfoRequest;
import com.tencent.mobileqq.zplan.servlet.api.IZPlanRequest;
import com.tencent.mobileqq.zplan.servlet.avatar.CachedZPlanAvatarRequest;
import com.tencent.mobileqq.zplan.servlet.d;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.state.data.SquareJSConst;
import java.util.ArrayList;
import java.util.List;
import k74.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nk3.f;
import nk3.j;
import nk3.k;
import nk3.l;
import nk3.p;

@Metadata(d1 = {"\u0000\u00a0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 C2\u00020\u0001:\u0001DB\u0007\u00a2\u0006\u0004\bA\u0010BJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u001a\u0010\n\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0016J8\u0010\u000f\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016J\"\u0010\u0010\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016J(\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J*\u0010\u0017\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016J0\u0010\u001a\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u00182\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016J0\u0010#\u001a\u00020\u00042\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00182\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\"\u001a\u00020!H\u0016J.\u0010'\u001a\u00020\u00042\f\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\u00182\u0006\u0010\u0003\u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020&H\u0016J>\u0010'\u001a\u00020\u00042\f\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\u00182\u0016\u0010*\u001a\u0012\u0012\u0004\u0012\u00020!0(j\b\u0012\u0004\u0012\u00020!`)2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020+H\u0016J\u0018\u0010-\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020!2\u0006\u0010 \u001a\u00020,H\u0016J\u0018\u0010/\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020!2\u0006\u0010 \u001a\u00020.H\u0016J\"\u00102\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020!2\u0006\u00101\u001a\u0002002\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\u0016\u00106\u001a\u0002052\f\u00104\u001a\b\u0012\u0004\u0012\u00020$03H\u0016J\b\u00108\u001a\u000207H\u0016J\u0010\u00109\u001a\u0002072\u0006\u0010\u0003\u001a\u00020!H\u0016J\u0018\u0010;\u001a\u00020\u00042\u0006\u0010:\u001a\u0002072\u0006\u0010 \u001a\u00020\u001fH\u0016J0\u0010@\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020!2\u0006\u0010<\u001a\u00020\u001d2\u000e\u0010>\u001a\n\u0012\u0004\u0012\u00020=\u0018\u00010\u00182\u0006\u0010 \u001a\u00020?H\u0016\u00a8\u0006E"}, d2 = {"Lcom/tencent/mobileqq/zplan/servlet/api/impl/ZPlanRequestImpl;", "Lcom/tencent/mobileqq/zplan/servlet/api/IZPlanRequest;", "", "uin", "", "queryRegister", "getZPlanAvatarData", "Lcom/tencent/common/app/AppInterface;", "app", "appid", "getZPlanForwardRecentList", "openId", "appId", "Lcom/tencent/mobileqq/zplan/servlet/d;", "listener", "getZPlanAddFriendSetting", "getZPlanEditAvatarSetting", "getIsFriendByUin", "url", NodeProps.CUSTOM_PROP_IMAGE_TYPE, "Lnk3/k;", "picListener", "uploadPic", "getIsFriendByOpenId", "", "openIdList", "getIsFriendByOpenIdList", "Lcom/tencent/mobileqq/zplan/model/b;", "userInfoList", "", "serviceType", "Lnk3/a;", "callback", "", "timeoutMillis", "requestOidb1123", "Lcom/tencent/mobileqq/zplan/model/c;", "userInfoDesList", "Lnk3/p;", "requestOidb1127", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", SquareJSConst.Params.PARAMS_UIN_LIST, "Lnk3/l;", "Lnk3/f;", "getDynamicAvatar", "Lnk3/j;", "getStaticAvatar", "Lcom/tencent/mobileqq/zplan/model/f$a;", "dynamicAvatar", "setDynamicAvatar", "", "keys", "", "getZPlanResourceUrlRequestBusiBuf", "", "isCmshowMonthActiveUser", "isZPlanAioAvatarUser", "isChecked", "setZplanProfileCardSettingSwitch", "handleType", "Lcom/tencent/mobileqq/zplan/model/g;", "infos", "Lnk3/i;", "requestAddDCBackImage", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanRequestImpl implements IZPlanRequest {
    public static final String TAG = "[zplan]ZPlanRequestImpl";

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/servlet/api/impl/ZPlanRequestImpl$b", "Lcom/tencent/mobileqq/zplan/ipc/business/c$a;", "", IProfileProtocolConst.PARAM_IS_FRIEND, "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements c.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f335389a;

        b(d dVar) {
            this.f335389a = dVar;
        }

        @Override // com.tencent.mobileqq.zplan.ipc.business.c.a
        public void a(boolean isFriend) {
            this.f335389a.a(true, Boolean.valueOf(isFriend));
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/servlet/api/impl/ZPlanRequestImpl$c", "Lcom/tencent/mobileqq/zplan/ipc/business/e$a;", "", "isSuccess", "", "url", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements e.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ k f335390a;

        c(k kVar) {
            this.f335390a = kVar;
        }

        @Override // com.tencent.mobileqq.zplan.ipc.business.e.a
        public void a(boolean isSuccess, String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            this.f335390a.a(Boolean.valueOf(isSuccess), url);
        }
    }

    @Override // com.tencent.mobileqq.zplan.servlet.api.IZPlanRequest
    public void getDynamicAvatar(long uin, f callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        CachedZPlanAvatarRequest.f335391a.g(uin, callback);
    }

    @Override // com.tencent.mobileqq.zplan.servlet.api.IZPlanRequest
    public void getIsFriendByOpenId(AppInterface app, String openId, String appId, d listener) {
        Intrinsics.checkNotNullParameter(openId, "openId");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(listener, "listener");
        ZPlanRequest.f335367a.v(app, openId, appId, listener);
    }

    @Override // com.tencent.mobileqq.zplan.servlet.api.IZPlanRequest
    public void getIsFriendByOpenIdList(AppInterface app, List<String> openIdList, String appId, d listener) {
        Intrinsics.checkNotNullParameter(openIdList, "openIdList");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(listener, "listener");
        ZPlanRequest.f335367a.w(app, openIdList, appId, listener);
    }

    @Override // com.tencent.mobileqq.zplan.servlet.api.IZPlanRequest
    public void getIsFriendByUin(String uin, d listener) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(listener, "listener");
        ((com.tencent.mobileqq.zplan.ipc.business.c) i.INSTANCE.a(com.tencent.mobileqq.zplan.ipc.business.c.class)).isFriend(uin, new b(listener));
    }

    @Override // com.tencent.mobileqq.zplan.servlet.api.IZPlanRequest
    public void getStaticAvatar(long uin, j callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        CachedZPlanAvatarRequest.f335391a.i(uin, callback);
    }

    @Override // com.tencent.mobileqq.zplan.servlet.api.IZPlanRequest
    public void getZPlanAddFriendSetting(AppInterface app, String uin, String openId, String appId, d listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        ZPlanRequest.f335367a.n(app, uin, openId, appId, listener);
    }

    @Override // com.tencent.mobileqq.zplan.servlet.api.IZPlanRequest
    public void getZPlanAvatarData() {
        ZPlanRequest.f335367a.m();
    }

    @Override // com.tencent.mobileqq.zplan.servlet.api.IZPlanRequest
    public void getZPlanEditAvatarSetting(AppInterface app, String uin, d listener) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(listener, "listener");
        ZPlanRequest.f335367a.o(app, uin, listener);
    }

    @Override // com.tencent.mobileqq.zplan.servlet.api.IZPlanRequest
    public void getZPlanForwardRecentList(AppInterface app, String appid) {
        Intrinsics.checkNotNullParameter(appid, "appid");
        ZPlanRequest.f335367a.p(app, appid);
    }

    @Override // com.tencent.mobileqq.zplan.servlet.api.IZPlanRequest
    public byte[] getZPlanResourceUrlRequestBusiBuf(List<com.tencent.mobileqq.zplan.model.c> keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        return ZPlanRequest.f335367a.q(keys);
    }

    @Override // com.tencent.mobileqq.zplan.servlet.api.IZPlanRequest
    public boolean isCmshowMonthActiveUser() {
        return com.tencent.mobileqq.zplan.setting.c.a();
    }

    @Override // com.tencent.mobileqq.zplan.servlet.api.IZPlanRequest
    public boolean isZPlanAioAvatarUser(long uin) {
        return a.INSTANCE.a(uin);
    }

    @Override // com.tencent.mobileqq.zplan.servlet.api.IZPlanRequest
    public void queryRegister(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        ZPlanRequest.f335367a.u(uin);
    }

    @Override // com.tencent.mobileqq.zplan.servlet.api.IZPlanRequest
    public void requestAddDCBackImage(long uin, int handleType, List<? extends g> infos, nk3.i callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ZPlanUserInfoRequest.f335380a.s(uin, handleType, infos, callback);
    }

    @Override // com.tencent.mobileqq.zplan.servlet.api.IZPlanRequest
    public void requestOidb1123(List<com.tencent.mobileqq.zplan.model.b> userInfoList, int serviceType, nk3.a callback, long timeoutMillis) {
        Intrinsics.checkNotNullParameter(userInfoList, "userInfoList");
        ZPlanUserInfoRequest.f335380a.o(4387, serviceType, userInfoList, null, callback, timeoutMillis);
    }

    @Override // com.tencent.mobileqq.zplan.servlet.api.IZPlanRequest
    public void requestOidb1127(List<com.tencent.mobileqq.zplan.model.c> userInfoDesList, long uin, int serviceType, p callback) {
        Intrinsics.checkNotNullParameter(userInfoDesList, "userInfoDesList");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ZPlanUserInfoRequest.f335380a.q(userInfoDesList, uin, serviceType, callback);
    }

    @Override // com.tencent.mobileqq.zplan.servlet.api.IZPlanRequest
    public void setDynamicAvatar(long uin, ZPlanAvatar.ZPlanDynamicAvatar dynamicAvatar, nk3.a callback) {
        Intrinsics.checkNotNullParameter(dynamicAvatar, "dynamicAvatar");
        CachedZPlanAvatarRequest.f335391a.j(uin, dynamicAvatar, callback);
    }

    @Override // com.tencent.mobileqq.zplan.servlet.api.IZPlanRequest
    public void setZplanProfileCardSettingSwitch(boolean isChecked, nk3.a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ZPlanRequest.f335367a.z(isChecked, callback);
    }

    @Override // com.tencent.mobileqq.zplan.servlet.api.IZPlanRequest
    public void uploadPic(String uin, String url, String imageType, k picListener) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(imageType, "imageType");
        Intrinsics.checkNotNullParameter(picListener, "picListener");
        ((e) i.INSTANCE.a(e.class)).upLoadPic(uin, url, imageType, new c(picListener));
    }

    @Override // com.tencent.mobileqq.zplan.servlet.api.IZPlanRequest
    public void requestOidb1127(List<com.tencent.mobileqq.zplan.model.c> userInfoDesList, ArrayList<Long> uinList, int serviceType, l callback) {
        Intrinsics.checkNotNullParameter(userInfoDesList, "userInfoDesList");
        Intrinsics.checkNotNullParameter(uinList, "uinList");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ZPlanUserInfoRequest.f335380a.r(userInfoDesList, uinList, serviceType, callback);
    }
}
