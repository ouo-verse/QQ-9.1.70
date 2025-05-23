package com.tencent.mobileqq.flock.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileCardConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.mobileqq.troop.troopjoin.TryJoinTroopResult;
import com.tencent.mobileqq.troop.troopjoin.api.ITroopJoinApi;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/flock/utils/FlockJumpHelper;", "", "a", "Companion", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FlockJumpHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004J\u001e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fJF\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\f2\b\b\u0002\u0010\u0013\u001a\u00020\u00122\u001c\b\u0002\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0014R\u0014\u0010\u0018\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/flock/utils/FlockJumpHelper$Companion;", "", "Landroid/content/Context;", "context", "", "troopId", "", "e", "uin", "f", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "subID", "b", "Lcom/tencent/mobileqq/troop/troopjoin/a;", "param", "groupStatus", "", "needJumpAIO", "Lkotlin/Function2;", "Lcom/tencent/mobileqq/troop/troopjoin/TryJoinTroopResult;", "callback", "c", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
                return;
            }
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) defaultConstructorMarker);
        }

        public static /* synthetic */ void d(Companion companion, Context context, com.tencent.mobileqq.troop.troopjoin.a aVar, int i3, boolean z16, Function2 function2, int i16, Object obj) {
            if ((i16 & 8) != 0) {
                z16 = true;
            }
            boolean z17 = z16;
            if ((i16 & 16) != 0) {
                function2 = null;
            }
            companion.c(context, aVar, i3, z17, function2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void e(Context context, String troopId) {
            ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, RouterConstants.UI_ROUTE_CHAT_ACTVITY);
            activityURIRequest.extra().putBoolean("open_chatfragment", true);
            activityURIRequest.extra().putString("uinname", context.getString(R.string.f199154on));
            activityURIRequest.extra().putString("uin", troopId);
            activityURIRequest.extra().putInt("uintype", 1);
            activityURIRequest.setFlags(268435456);
            QRoute.startUri(activityURIRequest, (o) null);
        }

        public final void b(@NotNull Activity activity, @NotNull String uin, int subID) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, activity, uin, Integer.valueOf(subID));
                return;
            }
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(uin, "uin");
            Intent startAddFriend = ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(activity, 1, uin, "", 3102, subID, null, null, null, null, null);
            Intrinsics.checkNotNullExpressionValue(startAddFriend, "api(\n                IAd\u2026       null\n            )");
            ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriend(activity, startAddFriend);
        }

        public final void c(@NotNull final Context context, @NotNull final com.tencent.mobileqq.troop.troopjoin.a param, int groupStatus, final boolean needJumpAIO, @Nullable final Function2<? super TryJoinTroopResult, ? super Integer, Unit> callback) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, context, param, Integer.valueOf(groupStatus), Boolean.valueOf(needJumpAIO), callback);
                return;
            }
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(param, "param");
            if (groupStatus == 1) {
                QQToast.makeText(context, "\u642d\u5b50\u7fa4\u5df2\u89e3\u6563\uff0c\u53ef\u54a8\u8be2\u53d1\u8d77\u8005", 0).show();
            } else {
                ((ITroopJoinApi) QRoute.api(ITroopJoinApi.class)).tryLaunchJoinTroop(context, param, false, new Function2<TryJoinTroopResult, Integer, Unit>(needJumpAIO, context, param, callback) { // from class: com.tencent.mobileqq.flock.utils.FlockJumpHelper$Companion$joinTroop$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ Function2<TryJoinTroopResult, Integer, Unit> $callback;
                    final /* synthetic */ Context $context;
                    final /* synthetic */ boolean $needJumpAIO;
                    final /* synthetic */ com.tencent.mobileqq.troop.troopjoin.a $param;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                        this.$needJumpAIO = needJumpAIO;
                        this.$context = context;
                        this.$param = param;
                        this.$callback = callback;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, Boolean.valueOf(needJumpAIO), context, param, callback);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(TryJoinTroopResult tryJoinTroopResult, Integer num) {
                        invoke(tryJoinTroopResult, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull TryJoinTroopResult result, int i3) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) result, i3);
                            return;
                        }
                        Intrinsics.checkNotNullParameter(result, "result");
                        if (this.$needJumpAIO && result == TryJoinTroopResult.HAS_JOINED) {
                            FlockJumpHelper.INSTANCE.e(this.$context, this.$param.f());
                        }
                        Function2<TryJoinTroopResult, Integer, Unit> function2 = this.$callback;
                        if (function2 != null) {
                            function2.invoke(result, Integer.valueOf(i3));
                        }
                    }
                });
            }
        }

        public final void f(@NotNull Context context, @NotNull String uin) {
            String str;
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) uin);
                return;
            }
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(uin, "uin");
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                str = peekAppRuntime.getAccount();
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(uin, str)) {
                i3 = 0;
            } else {
                String uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(uin);
                IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
                Intrinsics.checkNotNullExpressionValue(uid, "uid");
                if (iFriendsInfoService.isFriend(uid, "FlockJumpHelper")) {
                    i3 = 1;
                } else {
                    i3 = 126;
                }
            }
            QRouteApi api = QRoute.api(IProfileCardApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IProfileCardApi::class.java)");
            AllInOne allInOne = new AllInOne(uin, i3);
            allInOne.profileEntryType = 130;
            allInOne.sourceID = 3102;
            allInOne.subSourceId = 1;
            allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SOURCE_ID, 13);
            allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SUB_SOURCE_ID, 41);
            ((IProfileCardApi) api).openProfileCard(context, allInOne);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49487);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            INSTANCE = new Companion(null);
        }
    }
}
