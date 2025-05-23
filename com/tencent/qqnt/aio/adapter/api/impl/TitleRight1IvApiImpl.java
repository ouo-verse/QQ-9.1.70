package com.tencent.qqnt.aio.adapter.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatSettingFragment;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.notifyservice.NotifyServiceBisConfigFragment;
import com.tencent.mobileqq.activity.notifyservice.NotifyServiceItemListFragment;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.nt.misc.api.IJumpApi;
import com.tencent.mobileqq.pad.LaunchMode;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyRouter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.util.BusinessUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.ITitleRight1IvApi;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.BuddySource;
import com.tencent.qqnt.kernel.nativeinterface.IGetTempChatInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGetUinInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.PeerUid;
import com.tencent.qqnt.kernel.nativeinterface.TempChatInfo;
import com.tencent.qqnt.troop.ITroopListRepoApi;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0006\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J(\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0006\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u0004H\u0016\u00a8\u0006!"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/TitleRight1IvApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/ITitleRight1IvApi;", "Lcom/tencent/aio/api/runtime/a;", "context", "Ljava/lang/Class;", "Landroid/app/Activity;", "toClass", "", "jumpActivity", "openNearbySetting", "openNearbyProSetting", "openMatchFriendSetting", "openStrangeSetting", "openCRMSetting", "openFriendVerifySetting", "openContactStrangeSetting", "openStateSquareTempSetting", "openNotifyServiceItemList", "openNotifyServiceItemSetting", "openC2CSetting", "Landroid/content/Context;", "Lcom/tencent/aio/data/AIOContact;", "contact", "", "uin", "", "isScaleChat", "openPublicAccountDetail", "onRight1IvClick", "<init>", "()V", "Companion", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class TitleRight1IvApiImpl implements ITitleRight1IvApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String TAG = "TitleRight1IvApiImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/TitleRight1IvApiImpl$a;", "", "Lcom/tencent/aio/api/runtime/a;", "context", "", "b", "c", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.adapter.api.impl.TitleRight1IvApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void b(com.tencent.aio.api.runtime.a context) {
            String DATALINE_PHONE_UIN;
            String j3 = context.g().r().c().j();
            if (Intrinsics.areEqual(PeerUid.DATALINE_PC_UID, j3)) {
                DATALINE_PHONE_UIN = AppConstants.DATALINE_PC_UIN;
                Intrinsics.checkNotNullExpressionValue(DATALINE_PHONE_UIN, "DATALINE_PC_UIN");
            } else if (Intrinsics.areEqual(PeerUid.DATALINE_PAD_UID, j3)) {
                DATALINE_PHONE_UIN = AppConstants.DATALINE_IPAD_UIN;
                Intrinsics.checkNotNullExpressionValue(DATALINE_PHONE_UIN, "DATALINE_IPAD_UIN");
            } else {
                DATALINE_PHONE_UIN = AppConstants.DATALINE_PHONE_UIN;
                Intrinsics.checkNotNullExpressionValue(DATALINE_PHONE_UIN, "DATALINE_PHONE_UIN");
            }
            String b16 = com.dataline.compose.d.f32301a.b(DATALINE_PHONE_UIN);
            IQQKuiklyRouter iQQKuiklyRouter = (IQQKuiklyRouter) QRoute.api(IQQKuiklyRouter.class);
            FragmentActivity requireActivity = context.c().requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "context.fragment.requireActivity()");
            iQQKuiklyRouter.jump(requireActivity, b16);
        }

        public final void c(com.tencent.aio.api.runtime.a context) {
            Context context2;
            Intrinsics.checkNotNullParameter(context, "context");
            String j3 = context.g().r().c().j();
            if (Utils.G(j3) && BusinessUtils.X(context.c().getActivity())) {
                return;
            }
            QRouteApi api = QRoute.api(ITroopListRepoApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(ITroopListRepoApi::class.java)");
            if (ITroopListRepoApi.a.b((ITroopListRepoApi) api, j3, TitleRight1IvApiImpl.TAG, false, 4, null)) {
                Fragment c16 = context.c();
                if (c16 == null || (context2 = c16.getContext()) == null) {
                    return;
                }
                QQToast.makeText(context2, 1, R.string.dph, 0).show();
                return;
            }
            boolean z16 = context.g().l().getBoolean("key_is_scale_chat");
            Intent intent = new Intent();
            intent.putExtra(AppConstants.Key.TROOP_CODE, j3);
            intent.putExtra("troop_uin", j3);
            intent.putExtra("KEY_IS_FROM_SCALE_CHAT", z16);
            TroopUtils.J(context.c().getActivity(), intent.getExtras(), 1, 2000);
        }

        Companion() {
        }
    }

    private final void openC2CSetting(com.tencent.aio.api.runtime.a context) {
        final FragmentActivity activity;
        HashSet<String> hashSetOf;
        Fragment c16 = context.c();
        if (c16 == null || (activity = c16.getActivity()) == null) {
            return;
        }
        final AIOContact c17 = context.g().r().c();
        AIOParam g16 = context.g();
        Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
        String uin = su3.b.a(g16).f179557e;
        final boolean z16 = context.g().l().getBoolean("key_is_scale_chat");
        if (!TextUtils.isEmpty(uin)) {
            Intrinsics.checkNotNullExpressionValue(uin, "uin");
            openC2CSetting(activity, c17, uin, z16);
            return;
        }
        com.tencent.qqnt.kernel.api.ag uixConvertService = ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "")).getUixConvertService();
        if (uixConvertService != null) {
            hashSetOf = SetsKt__SetsKt.hashSetOf(c17.j());
            uixConvertService.getUin(hashSetOf, new IKernelGetUinInfoCallback() { // from class: com.tencent.qqnt.aio.adapter.api.impl.bd
                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGetUinInfoCallback
                public final void onResult(HashMap hashMap) {
                    TitleRight1IvApiImpl.openC2CSetting$lambda$9$lambda$8(AIOContact.this, this, activity, z16, hashMap);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openC2CSetting$lambda$9$lambda$8(AIOContact contact, TitleRight1IvApiImpl this$0, FragmentActivity this_apply, boolean z16, HashMap hashMap) {
        Long l3;
        Intrinsics.checkNotNullParameter(contact, "$contact");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        String valueOf = (hashMap == null || (l3 = (Long) hashMap.get(contact.j())) == null) ? null : String.valueOf(l3);
        if (valueOf == null || valueOf.length() == 0) {
            QLog.d("ChatSettingApiImpl", 1, "[openC2CSetting] open fail. uin=" + valueOf);
            return;
        }
        this$0.openC2CSetting(this_apply, contact, valueOf, z16);
    }

    private final void openCRMSetting(com.tencent.aio.api.runtime.a context) {
        FragmentActivity activity;
        Boolean isBuddy;
        AIOContact c16 = context.g().r().c();
        com.tencent.qqnt.kernel.api.m buddyService = ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "")).getBuddyService();
        boolean z16 = false;
        if (!TextUtils.isEmpty(c16.j())) {
            if (buddyService != null && (isBuddy = buddyService.isBuddy(c16.j())) != null) {
                z16 = isBuddy.booleanValue();
            }
            QLog.d(TAG, 1, "[openCRMSetting] peerUid:" + c16.j() + " isBuddy:" + z16);
        }
        if (z16) {
            openC2CSetting(context);
            return;
        }
        Intent intent = new Intent();
        AIOParam g16 = context.g();
        Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
        intent.putExtra("uin", su3.b.a(g16).f179557e);
        intent.putExtra("KEY_UID", c16.j());
        intent.putExtra("uinname", context.g().l().getString("key_chat_name"));
        AIOParam g17 = context.g();
        Intrinsics.checkNotNullExpressionValue(g17, "context.aioParam");
        intent.putExtra("uintype", su3.b.a(g17).f179555d);
        intent.putExtra(AppConstants.Key.ADD_FRIEND_SOURCE_ID, BuddySource.DEFAULT);
        Fragment c17 = context.c();
        if (c17 == null || (activity = c17.getActivity()) == null) {
            return;
        }
        QPublicFragmentActivity.startForResult(activity, intent, (Class<? extends QPublicBaseFragment>) ChatSettingFragment.class, 2000);
    }

    private final void openContactStrangeSetting(com.tencent.aio.api.runtime.a context) {
        FragmentActivity activity;
        AIOContact c16 = context.g().r().c();
        Intent intent = new Intent();
        AIOParam g16 = context.g();
        Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
        intent.putExtra("uin", su3.b.a(g16).f179557e);
        intent.putExtra("KEY_UID", c16.j());
        intent.putExtra("uinname", c16.g());
        AIOParam g17 = context.g();
        Intrinsics.checkNotNullExpressionValue(g17, "context.aioParam");
        intent.putExtra("uintype", su3.b.a(g17).f179555d);
        intent.putExtra(AppConstants.Key.ADD_FRIEND_SOURCE_ID, BuddySource.DEFAULT);
        Fragment c17 = context.c();
        if (c17 == null || (activity = c17.getActivity()) == null) {
            return;
        }
        QPublicFragmentActivity.startForResult(activity, intent, (Class<? extends QPublicBaseFragment>) ChatSettingFragment.class, 2000);
    }

    private final void openFriendVerifySetting(com.tencent.aio.api.runtime.a context) {
        FragmentActivity activity;
        AIOContact c16 = context.g().r().c();
        Intent intent = new Intent();
        Bundle l3 = context.g().l();
        AIOParam g16 = context.g();
        Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
        intent.putExtra("uin", su3.b.a(g16).f179557e);
        intent.putExtra("KEY_UID", c16.j());
        intent.putExtra("uinname", l3.getString("key_chat_name"));
        AIOParam g17 = context.g();
        Intrinsics.checkNotNullExpressionValue(g17, "context.aioParam");
        intent.putExtra("uintype", su3.b.a(g17).f179555d);
        intent.putExtra(AppConstants.Key.ADD_FRIEND_SOURCE_ID, l3.getInt(AppConstants.Key.ADD_FRIEND_SOURCE_ID));
        Fragment c17 = context.c();
        if (c17 == null || (activity = c17.getActivity()) == null) {
            return;
        }
        QPublicFragmentActivity.startForResult(activity, intent, (Class<? extends QPublicBaseFragment>) ChatSettingFragment.class, 2000);
    }

    private final void openMatchFriendSetting(com.tencent.aio.api.runtime.a context) {
        FragmentActivity activity;
        AIOContact c16 = context.g().r().c();
        Intent intent = new Intent();
        Bundle l3 = context.g().l();
        AIOParam g16 = context.g();
        Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
        intent.putExtra("uin", su3.b.a(g16).f179557e);
        intent.putExtra("KEY_UID", c16.j());
        AIOParam g17 = context.g();
        Intrinsics.checkNotNullExpressionValue(g17, "context.aioParam");
        intent.putExtra("uintype", su3.b.a(g17).f179555d);
        intent.putExtra("uinname", l3.getString("uinname"));
        intent.putExtra("key_match_friend_self_open_id", l3.getString("key_match_friend_self_open_id"));
        intent.putExtra("key_match_friend_open_id", l3.getString("key_match_friend_open_id"));
        intent.putExtra("key_match_friend_avatar_url", l3.getString("key_match_friend_avatar_url"));
        intent.putExtra("key_match_friend_source", l3.getInt("key_match_friend_source"));
        intent.putExtra("recom_trace", l3.getString("recom_trace", ""));
        Fragment c17 = context.c();
        if (c17 == null || (activity = c17.getActivity()) == null) {
            return;
        }
        QPublicFragmentActivity.start(activity, intent, ChatSettingFragment.class);
    }

    private final void openNearbyProSetting(com.tencent.aio.api.runtime.a context) {
        ((IJumpApi) QRoute.api(IJumpApi.class)).doJumpAction(context.c().requireContext(), "mqqapi://kuikly/open?target=52&channel=2&version=1&src_type=app&page_name=nearby_aio_setting&tid=" + context.g().r().c().j() + "&nickname=" + context.g().r().c().g() + "&chat_type=" + String.valueOf(context.g().r().c().e()));
    }

    private final void openNearbySetting(com.tencent.aio.api.runtime.a context) {
        FragmentActivity activity;
        AIOContact c16 = context.g().r().c();
        context.g().l();
        Intent intent = new Intent();
        AIOParam g16 = context.g();
        Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
        intent.putExtra("uin", su3.b.a(g16).f179557e);
        intent.putExtra("KEY_UID", c16.j());
        intent.putExtra("uinname", c16.g());
        AIOParam g17 = context.g();
        Intrinsics.checkNotNullExpressionValue(g17, "context.aioParam");
        intent.putExtra("uintype", su3.b.a(g17).f179555d);
        intent.putExtra(AppConstants.Key.ADD_FRIEND_SOURCE_ID, 3007);
        intent.putExtra(AppConstants.Key.FOLLOW_FLAG, context.g().l().getBoolean("nearby_is_follow", false));
        Fragment c17 = context.c();
        if (c17 == null || (activity = c17.getActivity()) == null) {
            return;
        }
        QPublicFragmentActivity.startForResult(activity, intent, (Class<? extends QPublicBaseFragment>) ChatSettingFragment.class, 2000);
    }

    private final void openNotifyServiceItemList(com.tencent.aio.api.runtime.a context) {
        AIOContact c16 = context.g().r().c();
        Intent intent = new Intent();
        intent.putExtra("uin", c16.j());
        intent.putExtra("KEY_UID", c16.j());
        intent.putExtra("uinname", c16.g());
        intent.putExtra("uintype", 1006);
        intent.putExtra(AppConstants.Key.ADD_FRIEND_SOURCE_ID, BuddySource.DEFAULT);
        QPublicFragmentActivity.start(context.c().getActivity(), intent, NotifyServiceItemListFragment.class);
    }

    private final void openNotifyServiceItemSetting(com.tencent.aio.api.runtime.a context) {
        Bundle l3 = context.g().l();
        Long valueOf = l3 != null ? Long.valueOf(l3.getLong("key_notify_app_id")) : null;
        Bundle l16 = context.g().l();
        Integer valueOf2 = l16 != null ? Integer.valueOf(l16.getInt("key_notify_app_type")) : null;
        AIOContact c16 = context.g().r().c();
        Intent intent = new Intent();
        intent.putExtra("uin", c16.j());
        intent.putExtra("KEY_UID", c16.j());
        intent.putExtra("uinname", c16.g());
        intent.putExtra("uintype", 1006);
        intent.putExtra(AppConstants.Key.ADD_FRIEND_SOURCE_ID, BuddySource.DEFAULT);
        intent.putExtra("key_notify_app_id", valueOf);
        intent.putExtra("key_notify_app_type", valueOf2);
        QPublicFragmentActivity.start(context.c().getActivity(), intent, NotifyServiceBisConfigFragment.class);
    }

    private final void openPublicAccountDetail(com.tencent.aio.api.runtime.a context) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AIOContact c16 = context.g().r().c();
        long j3 = context.g().l().getLong("key_peerUin", -1L);
        if (j3 < 0) {
            QLog.e("PublicAccount", 1, "[openPublicAccountDetail] open fail. uid=" + c16.j());
            return;
        }
        String valueOf = String.valueOf(j3);
        Intent intent = new Intent();
        intent.putExtra(IPublicAccountUtil.NEED_FINISH, true);
        intent.putExtra("uin", valueOf);
        intent.putExtra("uinname", c16.g());
        intent.putExtra("uintype", 1008);
        IPublicAccountUtil iPublicAccountUtil = (IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class);
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        Fragment c17 = context.c();
        iPublicAccountUtil.gotoProfileForResult(intent, appInterface, c17 != null ? c17.getActivity() : null, valueOf, -1, 2000, 1, ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).isComeFromReadInJoy());
    }

    private final void openStateSquareTempSetting(com.tencent.aio.api.runtime.a context) {
        FragmentActivity activity;
        AIOContact c16 = context.g().r().c();
        Intent intent = new Intent();
        AIOParam g16 = context.g();
        Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
        intent.putExtra("uin", su3.b.a(g16).f179557e);
        intent.putExtra("KEY_UID", c16.j());
        intent.putExtra("uinname", c16.g());
        intent.putExtra("uintype", 10019);
        intent.putExtra(AppConstants.Key.ADD_FRIEND_SOURCE_ID, BuddySource.DEFAULT);
        Fragment c17 = context.c();
        if (c17 == null || (activity = c17.getActivity()) == null) {
            return;
        }
        QPublicFragmentActivity.startForResult(activity, intent, (Class<? extends QPublicBaseFragment>) ChatSettingFragment.class, 2000);
    }

    private final void openStrangeSetting(final com.tencent.aio.api.runtime.a context) {
        final AIOContact c16 = context.g().r().c();
        final Intent intent = new Intent();
        com.tencent.qqnt.kernel.api.w msgService = ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "")).getMsgService();
        if (msgService != null) {
            msgService.getTempChatInfo(100, c16.j(), new IGetTempChatInfoCallback() { // from class: com.tencent.qqnt.aio.adapter.api.impl.be
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetTempChatInfoCallback
                public final void onResult(int i3, String str, TempChatInfo tempChatInfo) {
                    TitleRight1IvApiImpl.openStrangeSetting$lambda$3(intent, context, c16, i3, str, tempChatInfo);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openStrangeSetting$lambda$3(Intent intent, com.tencent.aio.api.runtime.a context, AIOContact contact, int i3, String str, TempChatInfo tempChatInfo) {
        FragmentActivity activity;
        Intrinsics.checkNotNullParameter(intent, "$intent");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(contact, "$contact");
        if (i3 == 0) {
            String str2 = tempChatInfo.groupCode;
            AIOParam g16 = context.g();
            Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
            intent.putExtra("uin", su3.b.a(g16).f179557e);
            intent.putExtra("uinname", contact.g());
            intent.putExtra("KEY_UID", contact.j());
            AIOParam g17 = context.g();
            Intrinsics.checkNotNullExpressionValue(g17, "context.aioParam");
            intent.putExtra("uintype", su3.b.a(g17).f179555d);
            intent.putExtra("troop_uin", str2);
            intent.putExtra(AppConstants.Key.REAL_TROOP_UIN, str2);
            intent.putExtra(AppConstants.Key.ADD_FRIEND_SOURCE_ID, BuddySource.DEFAULT);
            Fragment c16 = context.c();
            if (c16 == null || (activity = c16.getActivity()) == null) {
                return;
            }
            QPublicFragmentActivity.startForResult(activity, intent, (Class<? extends QPublicBaseFragment>) ChatSettingFragment.class, 2000);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.ITitleRight1IvApi
    public void onRight1IvClick(com.tencent.aio.api.runtime.a context, Class<? extends Activity> toClass) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (QLog.isColorLevel()) {
            AIOParam g16 = context.g();
            Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
            int i3 = su3.b.a(g16).f179555d;
            AIOParam g17 = context.g();
            Intrinsics.checkNotNullExpressionValue(g17, "context.aioParam");
            QLog.d(TAG, 2, "doOnRight1IvClick uinType: " + i3 + ", uin: " + su3.b.a(g17).f179557e);
        }
        int e16 = context.g().r().c().e();
        if (e16 == 1) {
            openC2CSetting(context);
            return;
        }
        if (e16 == 2) {
            INSTANCE.c(context);
            return;
        }
        if (e16 == 8) {
            INSTANCE.b(context);
            return;
        }
        if (e16 == 106) {
            openNearbySetting(context);
            return;
        }
        if (e16 == 111) {
            openContactStrangeSetting(context);
            return;
        }
        if (e16 == 113) {
            openStrangeSetting(context);
            return;
        }
        if (e16 == 115) {
            openStateSquareTempSetting(context);
            return;
        }
        if (e16 != 201) {
            switch (e16) {
                case 100:
                    openStrangeSetting(context);
                    return;
                case 101:
                    openFriendVerifySetting(context);
                    return;
                case 102:
                    openCRMSetting(context);
                    return;
                case 103:
                    openPublicAccountDetail(context);
                    return;
                case 104:
                    openMatchFriendSetting(context);
                    return;
                default:
                    switch (e16) {
                        case 117:
                            openStrangeSetting(context);
                            return;
                        case 118:
                            openNotifyServiceItemList(context);
                            return;
                        case 119:
                            openNearbyProSetting(context);
                            return;
                        default:
                            jumpActivity(context, toClass);
                            return;
                    }
            }
        }
        openNotifyServiceItemSetting(context);
    }

    private final void jumpActivity(com.tencent.aio.api.runtime.a context, Class<? extends Activity> toClass) {
        if (toClass == null) {
            QLog.d(TAG, 1, "jumpActivity not support chatType = " + context.g().r().c().e());
            return;
        }
        Intent intent = new Intent(context.c().getContext(), toClass);
        intent.putExtra("key_peerId", context.g().r().c().j());
        intent.putExtra("key_chat_type", context.g().r().c().e());
        intent.putExtra("key_chat_name", context.g().r().c().g());
        FragmentActivity activity = context.c().getActivity();
        if (activity != null) {
            activity.startActivity(intent);
        }
    }

    private final void openC2CSetting(Context context, AIOContact contact, String uin, boolean isScaleChat) {
        if (AppSetting.t(BaseApplication.context) && (context instanceof com.tencent.mobileqq.pad.l)) {
            Bundle bundle = new Bundle();
            bundle.putString("uin", uin);
            bundle.putString("KEY_UID", contact.j());
            bundle.putString("uinname", contact.g());
            bundle.putInt("uintype", 0);
            bundle.putBoolean("KEY_IS_FROM_SCALE_CHAT", isScaleChat);
            com.tencent.mobileqq.pad.i.e(context, bundle, ChatSettingFragment.class, new com.tencent.mobileqq.pad.b().e(false).g(false).h(LaunchMode.standard).a());
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("uin", uin);
        intent.putExtra("KEY_UID", contact.j());
        intent.putExtra("uinname", contact.g());
        intent.putExtra("uintype", 0);
        intent.putExtra("KEY_IS_FROM_SCALE_CHAT", isScaleChat);
        QPublicFragmentActivity.start(context, intent, ChatSettingFragment.class);
    }
}
