package cm4;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import bm4.a;
import bo4.e;
import cm4.a;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.newnearby.INearbyAddFriendHelper;
import com.tencent.mobileqq.newnearby.INearbyAioHelper;
import com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.timi.game.databasecore.impl.livedata.LoadDataWrapper;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;
import common.config.service.QzoneConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass$QQUserId;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\u0018\u0000 ?2\u00020\u0001:\u00017B\u0007\u00a2\u0006\u0004\b=\u0010>JP\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0002J\u0012\u0010\u0014\u001a\u00020\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J0\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u000bH\u0002J\u0012\u0010\u001c\u001a\u00020\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u0018\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J \u0010\"\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020 H\u0016J\u001e\u0010'\u001a\u00020\u000f2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020$0#2\u0006\u0010!\u001a\u00020&H\u0016J0\u0010)\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0006H\u0016J0\u0010*\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0006H\u0016J8\u0010,\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0006H\u0016J@\u0010/\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u0006H\u0016J(\u00101\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u000bH\u0016J(\u00105\u001a\u00020\u000f2\u0006\u00102\u001a\u00020$2\u0006\u00103\u001a\u00020$2\u0006\u00104\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0006H\u0016J\b\u00106\u001a\u00020\u000fH\u0016R\u0014\u00109\u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0014\u0010<\u001a\u00020\u00068\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b:\u0010;\u00a8\u0006@"}, d2 = {"Lcm4/c;", "Lbm4/a;", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "uin", "", "source", "subSource", "showName", "reqCode", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "qqUserId", VirtualAppProxy.KEY_GAME_ID, "scene", "", "S3", "", "V3", "T3", "W3", "matchRelationSource", "", "token", "qqId", "X3", "Landroid/content/Context;", "context", "init", "Lmqq/app/AppRuntime;", "app", "H3", "Lcom/tencent/mobileqq/newnearby/INearbyAddFriendHelper$c;", "listener", "Q0", "", "", "tinyIdList", "Lcom/tencent/mobileqq/newnearby/INearbyAddFriendHelper$b;", "h3", "friendUserId", "B3", "z2", "initiatorId", "k0", "subId", WadlProxyConsts.SCENE_ID, "w3", "from", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "fromTinyId", "toTinyId", "nick", "B0", "o2", "a", "Ljava/lang/String;", "TAG", "b", "I", "ADD_FRIEND_NEARBY_SUB_ID", "<init>", "()V", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class c implements bm4.a {

    /* renamed from: d, reason: collision with root package name */
    private static final int f31110d = 3;

    /* renamed from: e, reason: collision with root package name */
    private static final int f31111e = 4;

    /* renamed from: f, reason: collision with root package name */
    private static final int f31112f = 5;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG = "TGRelationshipServiceUtil";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int ADD_FRIEND_NEARBY_SUB_ID = 25;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"cm4/c$b", "Lcom/tencent/timi/game/utils/IResultListener;", "Lcom/tencent/timi/game/userinfo/api/IUserInfo;", "friendUserInfo", "", "a", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements IResultListener<IUserInfo> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ INearbyAddFriendHelper.c f31115a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f31116b;

        b(INearbyAddFriendHelper.c cVar, c cVar2) {
            this.f31115a = cVar;
            this.f31116b = cVar2;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable IUserInfo friendUserInfo) {
            e d16;
            if (friendUserInfo != null && (d16 = friendUserInfo.d()) != null) {
                ((INearbyAddFriendHelper) QRoute.api(INearbyAddFriendHelper.class)).isFriend(d16.b(), this.f31115a);
            }
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
            l.e(this.f31116b.TAG, "isQQFriend -> getUserInfoFromDBOrNet error: errorCode == " + errorCode + ",errorMEssage == " + errorMessage);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"cm4/c$c", "Lcm4/a$a;", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "token", "", "b", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: cm4.c$c, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static final class C0206c implements a.InterfaceC0205a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f31118b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f31119c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CommonOuterClass$QQUserId f31120d;

        C0206c(String str, int i3, CommonOuterClass$QQUserId commonOuterClass$QQUserId) {
            this.f31118b = str;
            this.f31119c = i3;
            this.f31120d = commonOuterClass$QQUserId;
        }

        @Override // cm4.a.InterfaceC0205a
        public void a(@Nullable QBaseActivity activity) {
            l.e(c.this.TAG, "openChatPage onError");
            if (c.this.W3(activity)) {
                QQToast.makeText(activity, "\u4fe1\u606f\u83b7\u53d6\u5931\u8d25", 0).show();
                wf4.a aVar = wf4.a.f445618a;
                Intrinsics.checkNotNull(activity);
                aVar.a(activity);
            }
        }

        @Override // cm4.a.InterfaceC0205a
        public void b(@Nullable QBaseActivity activity, @NotNull byte[] token) {
            Intrinsics.checkNotNullParameter(token, "token");
            if (c.this.W3(activity)) {
                c cVar = c.this;
                Intrinsics.checkNotNull(activity);
                cVar.X3(activity, this.f31118b, this.f31119c, token, this.f31120d);
                wf4.a.f445618a.a(activity);
                return;
            }
            l.e(c.this.TAG, "openChatPage activity is invalid");
        }
    }

    private final void S3(QBaseActivity activity, String uin, int source, int subSource, String showName, int reqCode, CommonOuterClass$QQUserId qqUserId, int gameId, int scene) {
        String str;
        IUserInfo iUserInfo;
        e d16;
        if (TextUtils.isEmpty(showName)) {
            str = "--";
        } else {
            str = showName;
        }
        if (V3(qqUserId)) {
            LoadDataWrapper<? extends IUserInfo> value = ((bo4.d) mm4.b.b(bo4.d.class)).w2(qqUserId).getValue();
            if (value != null) {
                iUserInfo = value.b();
            } else {
                iUserInfo = null;
            }
            if (iUserInfo != null && (d16 = iUserInfo.d()) != null) {
                ((INearbyAddFriendHelper) QRoute.api(INearbyAddFriendHelper.class)).addFriendFromYQ(d16.b(), subSource, gameId, scene);
                return;
            }
            return;
        }
        ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriendForResult(activity, ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(BaseApplication.getContext(), 1, uin, "", source, subSource, str, null, null, "\u8fd4\u56de", null), reqCode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int T3(int gameId) {
        if (gameId != 101) {
            if (gameId != 104) {
                return 1;
            }
            return 7;
        }
        return 6;
    }

    private final boolean V3(CommonOuterClass$QQUserId qqUserId) {
        if (qqUserId.user_from.get() == 4) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean W3(QBaseActivity activity) {
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X3(final QBaseActivity activity, String uin, final int matchRelationSource, byte[] token, CommonOuterClass$QQUserId qqId) {
        l.b(this.TAG, "realOpenChatPage ");
        ILimitChatUtils iLimitChatUtils = (ILimitChatUtils) QRoute.api(ILimitChatUtils.class);
        AppRuntime appRuntime = activity.getAppRuntime();
        Intrinsics.checkNotNullExpressionValue(appRuntime, "activity.appRuntime");
        iLimitChatUtils.saveTempC2cSignature(appRuntime, uin, token);
        final Intent intent = new Intent();
        intent.setClassName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.ChatActivity");
        intent.putExtra("uin", uin);
        AppRuntime appRuntime2 = activity.getAppRuntime();
        Intrinsics.checkNotNullExpressionValue(appRuntime2, "activity.appRuntime");
        Q0(qqId, appRuntime2, new INearbyAddFriendHelper.c() { // from class: cm4.b
            @Override // com.tencent.mobileqq.newnearby.INearbyAddFriendHelper.c
            public final void a(boolean z16) {
                c.Y3(intent, matchRelationSource, activity, z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y3(Intent aioIntent, int i3, QBaseActivity activity, boolean z16) {
        Intrinsics.checkNotNullParameter(aioIntent, "$aioIntent");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        if (z16) {
            aioIntent.putExtra("uintype", 0);
        } else {
            aioIntent.putExtra("uintype", 1044);
        }
        aioIntent.setFlags(67108864);
        aioIntent.putExtra(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, 21);
        aioIntent.putExtra(ILimitChatUtils.EXT_KEY_LIMIT_CHAT_MATCH_RELATION_SOURCE, i3);
        activity.startActivity(aioIntent);
    }

    @Override // bm4.a
    public void B0(long fromTinyId, long toTinyId, @NotNull String nick, int gameId) {
        Intrinsics.checkNotNullParameter(nick, "nick");
        dm4.a.f394279a.a(fromTinyId, toTinyId, new d(toTinyId, this, gameId, nick));
    }

    @Override // bm4.a
    public void B3(@NotNull QBaseActivity activity, @NotNull String uin, @NotNull String showName, @NotNull CommonOuterClass$QQUserId friendUserId, int gameId) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(showName, "showName");
        Intrinsics.checkNotNullParameter(friendUserId, "friendUserId");
        S3(activity, uin, 3094, 18, showName, U3(), friendUserId, gameId, f31110d);
    }

    @Override // bm4.a
    public boolean H3(@NotNull String uin, @NotNull AppRuntime app) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(app, "app");
        String uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(uin);
        IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
        Intrinsics.checkNotNullExpressionValue(uid, "uid");
        return iFriendsInfoService.isFriend(uid, this.TAG);
    }

    @Override // bm4.a
    public void Q(@NotNull QBaseActivity activity, @NotNull String uin, int from, @NotNull CommonOuterClass$QQUserId qqId) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(qqId, "qqId");
        C0206c c0206c = new C0206c(uin, from, qqId);
        l.b(this.TAG, "openChatPage start");
        wf4.a.f445618a.c(activity);
        a.f31102a.a(activity, uin, qqId, c0206c);
    }

    @Override // bm4.a
    public void Q0(@NotNull CommonOuterClass$QQUserId qqUserId, @NotNull AppRuntime app, @NotNull INearbyAddFriendHelper.c listener) {
        Intrinsics.checkNotNullParameter(qqUserId, "qqUserId");
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (V3(qqUserId)) {
            ((bo4.d) mm4.b.b(bo4.d.class)).I3(qqUserId, new b(listener, this));
        } else {
            listener.a(H3(String.valueOf(qqUserId.uid.get()), app));
        }
    }

    public int U3() {
        return a.C0137a.a(this);
    }

    @Override // bm4.a
    public void h3(@NotNull List<Long> tinyIdList, @NotNull INearbyAddFriendHelper.b listener) {
        Intrinsics.checkNotNullParameter(tinyIdList, "tinyIdList");
        Intrinsics.checkNotNullParameter(listener, "listener");
        ((INearbyAddFriendHelper) QRoute.api(INearbyAddFriendHelper.class)).isFriend(tinyIdList, listener);
    }

    @Override // bm4.a
    public void k0(@NotNull QBaseActivity activity, @NotNull CommonOuterClass$QQUserId initiatorId, @NotNull String uin, @NotNull String showName, @NotNull CommonOuterClass$QQUserId qqUserId, int gameId) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(initiatorId, "initiatorId");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(showName, "showName");
        Intrinsics.checkNotNullParameter(qqUserId, "qqUserId");
        if (initiatorId.user_from.get() == 2) {
            S3(activity, uin, 3097, 19, showName, U3(), qqUserId, gameId, f31111e);
        } else {
            S3(activity, uin, 3094, 19, showName, U3(), qqUserId, gameId, f31111e);
        }
    }

    @Override // bm4.a
    public void w3(@NotNull QBaseActivity activity, @NotNull String uin, @NotNull String showName, @NotNull CommonOuterClass$QQUserId friendUserId, int gameId, int subId, int sceneId) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(showName, "showName");
        Intrinsics.checkNotNullParameter(friendUserId, "friendUserId");
        if (friendUserId.user_from.get() == 4) {
            l.b(this.TAG, "addQQFriendByPortalNearBy " + subId + " " + sceneId + " " + gameId);
            S3(activity, uin, 0, subId, showName, U3(), friendUserId, gameId, sceneId);
        }
    }

    @Override // bm4.a
    public void z2(@NotNull QBaseActivity activity, @NotNull String uin, @NotNull String showName, @NotNull CommonOuterClass$QQUserId qqUserId, int gameId) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(showName, "showName");
        Intrinsics.checkNotNullParameter(qqUserId, "qqUserId");
        S3(activity, uin, 3094, 18, showName, U3(), qqUserId, gameId, f31110d);
    }

    @Override // mm4.a
    public void o2() {
    }

    @Override // mm4.a
    public void init(@Nullable Context context) {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"cm4/c$d", "Lcom/tencent/timi/game/utils/IResultListener;", "", "result", "", "a", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class d implements IResultListener<byte[]> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f31121a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f31122b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f31123c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f31124d;

        d(long j3, c cVar, int i3, String str) {
            this.f31121a = j3;
            this.f31122b = cVar;
            this.f31123c = i3;
            this.f31124d = str;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable byte[] result) {
            if (result != null) {
                long j3 = this.f31121a;
                c cVar = this.f31122b;
                int i3 = this.f31123c;
                ((INearbyAioHelper) QRoute.api(INearbyAioHelper.class)).openAioFromYQYL(j3, cVar.T3(i3), this.f31124d, result);
            }
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
        }
    }
}
