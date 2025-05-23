package com.tencent.mobileqq.zplan.proxy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.api.IZPlanFriendApi;
import com.tencent.mobileqq.zplan.friend.FriendInfo;
import com.tencent.mobileqq.zplan.friend.FriendRepository;
import com.tencent.mobileqq.zplan.friend.Gender;
import com.tencent.mobileqq.zplan.friend.r;
import com.tencent.mobileqq.zplan.ipc.business.a;
import com.tencent.mobileqq.zplan.servlet.api.IZPlanRequest;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.activity.ZplanHostActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001f2\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b*\u0010+J\"\u0010\u0007\u001a\u00020\u00052\u0018\u0010\u0006\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\u00050\u0002H\u0016J<\u0010\u000b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00032$\u0010\u0006\u001a \u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\n0\u0003\u0012\u0004\u0012\u00020\u00050\u0002H\u0016J&\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00042\u0014\u0010\u0006\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u0002H\u0016J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0004H\u0016J \u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0004H\u0016J6\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00172\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u0017H\u0016J6\u0010\u001e\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\bH\u0016J:\u0010\u001f\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00050\u0002H\u0016J:\u0010 \u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00050\u0002H\u0016J@\u0010#\u001a\u00020\u00052\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0010\u001a\u00020\u00042 \u0010\u0006\u001a\u001c\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0011\u0018\u00010\"\u0012\u0004\u0012\u00020\u00050\u0002H\u0016J\u0018\u0010&\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u0004H\u0016R\u0018\u0010)\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010(\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/zplan/proxy/QQZPlanFriendProxy;", "Lzx4/e;", "Lkotlin/Function1;", "", "", "", "cb", "j", "", "genderList", "Lkotlin/Pair;", "g", "uin", tl.h.F, "path", "i", "appId", "", "isSupportMultiSelect", "arkShareContent", "a", "maxSelectNum", "templateID", "", "preselection", "preselectionSex", "k", "openId", "sourceId", "subSourceId", "c", "b", "d", "openIdList", "", "f", "scene", "imagePath", "e", "Lcom/tencent/mobileqq/zplan/friend/FriendRepository;", "Lcom/tencent/mobileqq/zplan/friend/FriendRepository;", "repository", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class QQZPlanFriendProxy implements zx4.e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private FriendRepository repository;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/proxy/QQZPlanFriendProxy$b", "Lcom/tencent/mobileqq/zplan/servlet/d;", "", "success", "", "result", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements com.tencent.mobileqq.zplan.servlet.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Boolean, Unit> f334943a;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function1<? super Boolean, Unit> function1) {
            this.f334943a = function1;
        }

        @Override // com.tencent.mobileqq.zplan.servlet.d
        public void a(boolean success, Object result) {
            boolean z16;
            Function1<Boolean, Unit> function1 = this.f334943a;
            if (success) {
                Intrinsics.checkNotNull(result, "null cannot be cast to non-null type kotlin.Boolean");
                if (((Boolean) result).booleanValue()) {
                    z16 = true;
                    function1.invoke(Boolean.valueOf(z16));
                }
            }
            z16 = false;
            function1.invoke(Boolean.valueOf(z16));
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/proxy/QQZPlanFriendProxy$c", "Lcom/tencent/mobileqq/zplan/servlet/d;", "", "success", "", "result", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements com.tencent.mobileqq.zplan.servlet.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Boolean, Unit> f334944a;

        /* JADX WARN: Multi-variable type inference failed */
        c(Function1<? super Boolean, Unit> function1) {
            this.f334944a = function1;
        }

        @Override // com.tencent.mobileqq.zplan.servlet.d
        public void a(boolean success, Object result) {
            boolean z16;
            Function1<Boolean, Unit> function1 = this.f334944a;
            if (success) {
                Intrinsics.checkNotNull(result, "null cannot be cast to non-null type kotlin.Boolean");
                if (((Boolean) result).booleanValue()) {
                    z16 = true;
                    function1.invoke(Boolean.valueOf(z16));
                }
            }
            z16 = false;
            function1.invoke(Boolean.valueOf(z16));
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/proxy/QQZPlanFriendProxy$d", "Lcom/tencent/mobileqq/zplan/servlet/d;", "", "success", "", "result", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements com.tencent.mobileqq.zplan.servlet.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Boolean, Unit> f334945a;

        /* JADX WARN: Multi-variable type inference failed */
        d(Function1<? super Boolean, Unit> function1) {
            this.f334945a = function1;
        }

        @Override // com.tencent.mobileqq.zplan.servlet.d
        public void a(boolean success, Object result) {
            boolean z16;
            Function1<Boolean, Unit> function1 = this.f334945a;
            if (success) {
                Intrinsics.checkNotNull(result, "null cannot be cast to non-null type kotlin.Boolean");
                if (((Boolean) result).booleanValue()) {
                    z16 = true;
                    function1.invoke(Boolean.valueOf(z16));
                }
            }
            z16 = false;
            function1.invoke(Boolean.valueOf(z16));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(Function1 cb5, boolean z16, String str) {
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        QLog.i("ZPlanSameStyle", 1, "get user avatar result = " + z16 + ", path = " + str);
        cb5.invoke(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(int i3, List preselection, List preselectionSex, String str) {
        Intrinsics.checkNotNullParameter(preselection, "$preselection");
        Intrinsics.checkNotNullParameter(preselectionSex, "$preselectionSex");
        Context context = Foreground.getTopActivity();
        if (context == null) {
            context = BaseApplication.context;
            Intrinsics.checkNotNullExpressionValue(context, "context");
        }
        ZplanHostActivity.Companion companion = ZplanHostActivity.INSTANCE;
        Bundle bundle = new Bundle();
        bundle.putInt("max_select_num", i3);
        bundle.putStringArrayList("pre_selection", new ArrayList<>(preselection));
        bundle.putIntegerArrayList("pre_selection_sex", new ArrayList<>(preselectionSex));
        bundle.putString("template_id", str);
        Unit unit = Unit.INSTANCE;
        ZplanHostActivity.Companion.c(companion, context, com.tencent.mobileqq.zplan.friend.q.class, bundle, 0, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(boolean z16, String str) {
        QLog.i("ZPlanSameStyle", 1, "record user role result: " + z16 + ", url = " + str);
    }

    @Override // zx4.e
    public void a(String appId, boolean isSupportMultiSelect, String arkShareContent) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(arkShareContent, "arkShareContent");
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(arkShareContent);
            Intent intent = new Intent();
            intent.putExtra("forward_type", 49);
            intent.putExtra("is_ark_display_share", true);
            intent.putExtra("forward_ark_app_name", jSONObject.optString("app"));
            intent.putExtra("forward_ark_app_view", jSONObject.optString("view"));
            intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_CONFIG, jSONObject.optString(DownloadInfo.spKey_Config));
            intent.putExtra("forward_ark_app_ver", jSONObject.optString("ver"));
            intent.putExtra("desc", jSONObject.optString("desc"));
            intent.putExtra("forward_ark_app_prompt", jSONObject.optString("prompt"));
            intent.putExtra("forward_ark_app_meta", jSONObject.optString(PublicAccountMessageUtilImpl.META_NAME));
            ((IZPlanFriendApi) QRoute.api(IZPlanFriendApi.class)).openNativeForwardRecentPage(topActivity, intent, appId, isSupportMultiSelect, 0);
        } catch (Exception e16) {
            QLog.e("ZPlanSameStyle", 1, "openForwardRecentPage error", e16);
        }
    }

    @Override // zx4.e
    public void b(String uin, String openId, String appId, Function1<? super Boolean, Unit> cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        Intrinsics.checkNotNull(waitAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        ((IZPlanRequest) QRoute.api(IZPlanRequest.class)).getZPlanAddFriendSetting((AppInterface) waitAppRuntime, uin, openId, appId, new b(cb5));
    }

    @Override // zx4.e
    public void c(final String uin, final String openId, final String appId, final int sourceId, final int subSourceId) {
        final Activity topActivity = Foreground.getTopActivity();
        b(uin, openId, appId, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.zplan.proxy.QQZPlanFriendProxy$addFriend$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                Intent startAddFriend;
                if (topActivity == null) {
                    ((com.tencent.mobileqq.zplan.ipc.business.c) k74.i.INSTANCE.a(com.tencent.mobileqq.zplan.ipc.business.c.class)).addFriend(Boolean.valueOf(z16), uin, openId, appId, sourceId, subSourceId);
                    return;
                }
                if (z16) {
                    String str = uin;
                    if (str == null || str.length() == 0) {
                        QLog.d("ZPlanSameStyle", 1, "addFriend type is openid");
                        startAddFriend = ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(topActivity, 3, openId, appId, sourceId, subSourceId, null, null, null, "", null);
                        Intrinsics.checkNotNullExpressionValue(startAddFriend, "{\n                      \u2026  )\n                    }");
                    } else {
                        QLog.d("ZPlanSameStyle", 1, "addFriend type is uin");
                        startAddFriend = ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(topActivity, 1, uin, "", sourceId, subSourceId, null, null, null, "", null);
                        Intrinsics.checkNotNullExpressionValue(startAddFriend, "{\n                      \u2026  )\n                    }");
                    }
                    ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriend(topActivity, startAddFriend);
                    return;
                }
                QLog.d("ZPlanSameStyle", 1, "addFriend error");
                ((IZPlanFriendApi) QRoute.api(IZPlanFriendApi.class)).showRefuseAddFriendDialog(topActivity);
            }
        });
    }

    @Override // zx4.e
    public void d(String uin, String openId, String appId, Function1<? super Boolean, Unit> cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        Intrinsics.checkNotNull(waitAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        AppInterface appInterface = (AppInterface) waitAppRuntime;
        if (uin == null || uin.length() == 0) {
            IZPlanRequest iZPlanRequest = (IZPlanRequest) QRoute.api(IZPlanRequest.class);
            Intrinsics.checkNotNull(openId);
            Intrinsics.checkNotNull(appId);
            iZPlanRequest.getIsFriendByOpenId(appInterface, openId, appId, new c(cb5));
            return;
        }
        ((IZPlanRequest) QRoute.api(IZPlanRequest.class)).getIsFriendByUin(uin, new d(cb5));
    }

    @Override // zx4.e
    public void e(int scene, String imagePath) {
        Intrinsics.checkNotNullParameter(imagePath, "imagePath");
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity == null) {
            return;
        }
        ((IZPlanApi) QRoute.api(IZPlanApi.class)).setZPlanBackgroundImage(topActivity, imagePath);
    }

    @Override // zx4.e
    public void f(List<String> openIdList, String appId, Function1<? super Map<String, Boolean>, Unit> cb5) {
        Intrinsics.checkNotNullParameter(openIdList, "openIdList");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        Intrinsics.checkNotNull(waitAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        ((IZPlanRequest) QRoute.api(IZPlanRequest.class)).getIsFriendByOpenIdList((AppInterface) waitAppRuntime, openIdList, appId, new e(cb5));
    }

    @Override // zx4.e
    public void g(final List<Integer> genderList, final Function1<? super List<Pair<String, String>>, Unit> cb5) {
        Unit unit;
        Intrinsics.checkNotNullParameter(genderList, "genderList");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        AppInterface appInterface = (AppInterface) peekAppRuntime;
        if (this.repository == null) {
            this.repository = new FriendRepository(appInterface);
        }
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        FriendRepository friendRepository = this.repository;
        if (friendRepository != null) {
            friendRepository.d(new Function1<List<? extends FriendInfo>, Unit>() { // from class: com.tencent.mobileqq.zplan.proxy.QQZPlanFriendProxy$getDefaultFriends$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<? extends FriendInfo> list) {
                    invoke2((List<FriendInfo>) list);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(List<FriendInfo> allFrindsInfo) {
                    Object obj;
                    FriendInfo friendInfo;
                    Integer gender;
                    Integer gender2;
                    Object obj2;
                    Intrinsics.checkNotNullParameter(allFrindsInfo, "allFrindsInfo");
                    List<Integer> list = genderList;
                    ArrayList<FriendInfo> arrayList3 = arrayList;
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        int intValue = ((Number) it.next()).intValue();
                        Object obj3 = null;
                        if (intValue == Gender.ALL.getGender()) {
                            Iterator<T> it5 = allFrindsInfo.iterator();
                            while (true) {
                                if (it5.hasNext()) {
                                    obj2 = it5.next();
                                    if (!arrayList3.contains((FriendInfo) obj2)) {
                                        break;
                                    }
                                } else {
                                    obj2 = null;
                                    break;
                                }
                            }
                            friendInfo = (FriendInfo) obj2;
                        } else {
                            Iterator<T> it6 = allFrindsInfo.iterator();
                            while (true) {
                                if (!it6.hasNext()) {
                                    obj = null;
                                    break;
                                }
                                obj = it6.next();
                                FriendInfo friendInfo2 = (FriendInfo) obj;
                                if ((arrayList3.contains(friendInfo2) || (gender = friendInfo2.getGender()) == null || gender.intValue() != intValue) ? false : true) {
                                    break;
                                }
                            }
                            friendInfo = (FriendInfo) obj;
                        }
                        if (friendInfo == null) {
                            Iterator<T> it7 = allFrindsInfo.iterator();
                            while (true) {
                                if (!it7.hasNext()) {
                                    break;
                                }
                                Object next = it7.next();
                                if (intValue == Gender.ALL.getGender() || ((gender2 = ((FriendInfo) next).getGender()) != null && intValue == gender2.intValue())) {
                                    obj3 = next;
                                    break;
                                }
                            }
                            friendInfo = (FriendInfo) obj3;
                        }
                        if (friendInfo != null) {
                            arrayList3.add(friendInfo);
                        }
                    }
                    ArrayList<FriendInfo> arrayList4 = arrayList;
                    ArrayList<Pair<String, String>> arrayList5 = arrayList2;
                    for (FriendInfo friendInfo3 : arrayList4) {
                        String uin = friendInfo3.getUin();
                        String name = friendInfo3.getName();
                        if (name == null) {
                            name = "";
                        }
                        arrayList5.add(new Pair<>(uin, name));
                    }
                    cb5.invoke(arrayList2);
                }
            });
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            cb5.invoke(arrayList2);
        }
    }

    @Override // zx4.e
    public void h(String uin, final Function1<? super String, Unit> cb5) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        QLog.i("ZPlanSameStyle", 1, "start get avatar of " + uin + " via ipc");
        ((com.tencent.mobileqq.zplan.ipc.business.a) k74.i.INSTANCE.a(com.tencent.mobileqq.zplan.ipc.business.a.class)).getUserAvatar(uin, new a.b() { // from class: com.tencent.mobileqq.zplan.proxy.j
            @Override // com.tencent.mobileqq.zplan.ipc.business.a.b
            public final void onResult(boolean z16, String str) {
                QQZPlanFriendProxy.o(Function1.this, z16, str);
            }
        });
    }

    @Override // zx4.e
    public void i(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        ((com.tencent.mobileqq.zplan.ipc.business.a) k74.i.INSTANCE.a(com.tencent.mobileqq.zplan.ipc.business.a.class)).saveUserRoleImage(path, new a.e() { // from class: com.tencent.mobileqq.zplan.proxy.i
            @Override // com.tencent.mobileqq.zplan.ipc.business.a.e
            public final void a(boolean z16, String str) {
                QQZPlanFriendProxy.q(z16, str);
            }
        });
    }

    @Override // zx4.e
    public void j(final Function1<? super List<String>, Unit> cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        Intrinsics.checkNotNull(waitAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        final AppInterface appInterface = (AppInterface) waitAppRuntime;
        com.tencent.mobileqq.zplan.friend.r.f333732a.d(appInterface, 1, new Function1<List<? extends r.RoleInfo>, Unit>() { // from class: com.tencent.mobileqq.zplan.proxy.QQZPlanFriendProxy$getDefaultFriends$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends r.RoleInfo> list) {
                invoke2((List<r.RoleInfo>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<r.RoleInfo> roleList) {
                Intrinsics.checkNotNullParameter(roleList, "roleList");
                final ArrayList arrayList = new ArrayList();
                Iterator<T> it = roleList.iterator();
                while (it.hasNext()) {
                    arrayList.add(((r.RoleInfo) it.next()).getUin());
                }
                com.tencent.mobileqq.zplan.friend.r rVar = com.tencent.mobileqq.zplan.friend.r.f333732a;
                AppInterface appInterface2 = AppInterface.this;
                final Function1<List<String>, Unit> function1 = cb5;
                rVar.d(appInterface2, 0, new Function1<List<? extends r.RoleInfo>, Unit>() { // from class: com.tencent.mobileqq.zplan.proxy.QQZPlanFriendProxy$getDefaultFriends$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(List<? extends r.RoleInfo> list) {
                        invoke2((List<r.RoleInfo>) list);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(List<r.RoleInfo> botList) {
                        Intrinsics.checkNotNullParameter(botList, "botList");
                        ArrayList<String> arrayList2 = arrayList;
                        Iterator<T> it5 = botList.iterator();
                        while (it5.hasNext()) {
                            arrayList2.add(((r.RoleInfo) it5.next()).getUin());
                        }
                        function1.invoke(arrayList);
                    }
                });
            }
        });
    }

    @Override // zx4.e
    public void k(final int maxSelectNum, final String templateID, final List<String> preselection, final List<Integer> preselectionSex) {
        Intrinsics.checkNotNullParameter(preselection, "preselection");
        Intrinsics.checkNotNullParameter(preselectionSex, "preselectionSex");
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.proxy.h
            @Override // java.lang.Runnable
            public final void run() {
                QQZPlanFriendProxy.p(maxSelectNum, preselection, preselectionSex, templateID);
            }
        });
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/proxy/QQZPlanFriendProxy$e", "Lcom/tencent/mobileqq/zplan/servlet/d;", "", "success", "", "result", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class e implements com.tencent.mobileqq.zplan.servlet.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Map<String, Boolean>, Unit> f334946a;

        /* JADX WARN: Multi-variable type inference failed */
        e(Function1<? super Map<String, Boolean>, Unit> function1) {
            this.f334946a = function1;
        }

        @Override // com.tencent.mobileqq.zplan.servlet.d
        public void a(boolean success, Object result) {
            if (success && result != null) {
                this.f334946a.invoke((Map) result);
            } else {
                this.f334946a.invoke(null);
            }
        }
    }
}
