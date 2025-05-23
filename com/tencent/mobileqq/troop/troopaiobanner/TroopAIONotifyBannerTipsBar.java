package com.tencent.mobileqq.troop.troopaiobanner;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.notification.AIONotificationBusiId;
import com.tencent.mobileqq.aio.notification.IAIONotificationUIModel;
import com.tencent.mobileqq.aio.notification.d;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberNickInfo;
import com.tencent.mobileqq.dt.api.IO3NotifyBannerApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.troop.homework.api.IHWTroopUIApi;
import com.tencent.mobileqq.troop.troopgame.api.a;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupExt;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.qzonehub.api.utils.IQZoneGroupAlbumArkUtil;
import com.tencent.trpcprotocol.iqun.group_top_banner_notify.group_top_banner_notify.GroupTopBannerNotifyPB$GameTeamUpBanner;
import com.tencent.trpcprotocol.iqun.group_top_banner_notify.group_top_banner_notify.GroupTopBannerNotifyPB$NotifyBanner;
import com.tencent.trpcprotocol.iqun.group_top_banner_notify.group_top_banner_notify.GroupTopBannerNotifyPB$QueryTopBannerInfoRsp;
import com.tencent.trpcprotocol.iqun.group_top_banner_notify.group_top_banner_notify.GroupTopBannerNotifyPB$TodoBanner;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0085\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001C\u0018\u0000 %2\u00020\u0001:\u0001SB\u0007\u00a2\u0006\u0004\bQ\u0010RJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J7\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0016\u0010\u000b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n0\t\"\u0004\u0018\u00010\nH\u0016\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u000f\u001a\u00020\fH\u0002J\b\u0010\u0010\u001a\u00020\fH\u0002J\b\u0010\u0011\u001a\u00020\fH\u0002J\b\u0010\u0012\u001a\u00020\fH\u0002J\b\u0010\u0013\u001a\u00020\fH\u0002J\b\u0010\u0014\u001a\u00020\fH\u0002J\u001c\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00152\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002J\"\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002J \u0010\u001d\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J$\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00152\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002J$\u0010!\u001a\u00020 2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002J\u0010\u0010\"\u001a\u00020 2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J$\u0010%\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00152\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\f0#H\u0002J\u001a\u0010&\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002J\u001a\u0010'\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002J\u0010\u0010(\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010)\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0014\u0010+\u001a\u00020\f2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0017H\u0002J$\u0010,\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00152\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\f0#H\u0002J\u0010\u0010-\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010.\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010/\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u00100\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u00101\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010>\u001a\u00020<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010=R \u0010B\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00170?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010E\u001a\u00020C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010DR\u0016\u0010I\u001a\u0004\u0018\u00010F8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bG\u0010HR\u0014\u0010L\u001a\u00020\u00178BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bJ\u0010KR\u0016\u0010P\u001a\u0004\u0018\u00010M8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bN\u0010O\u00a8\u0006T"}, d2 = {"Lcom/tencent/mobileqq/troop/troopaiobanner/TroopAIONotifyBannerTipsBar;", "Lcom/tencent/mobileqq/aio/notification/d;", "", "Lcom/tencent/mobileqq/aio/notification/AIONotificationBusiId;", tl.h.F, "Lcom/tencent/mobileqq/aio/notification/c;", "notificationManager", "", "eventType", "", "", "params", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/mobileqq/aio/notification/c;I[Ljava/lang/Object;)V", "P", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, ExifInterface.LATITUDE_SOUTH, BdhLogUtil.LogTag.Tag_Req, "b0", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/trpcprotocol/iqun/group_top_banner_notify/group_top_banner_notify/GroupTopBannerNotifyPB$QueryTopBannerInfoRsp;", "bannerInfo", "", "msgId", "d0", "bannerToken", "c0", "bannerBizType", "O", "a0", "content", "Lcom/tencent/mobileqq/aio/notification/IAIONotificationUIModel;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "E", "Lkotlin/Function1;", "callback", BdhLogUtil.LogTag.Tag_Conn, "I", "K", "V", "W", "errMsg", "Y", UserInfo.SEX_FEMALE, "J", "N", "H", "L", "M", "d", "Lcom/tencent/mobileqq/aio/notification/c;", "Lcom/tencent/mobileqq/troop/troopaiobanner/c;", "e", "Lcom/tencent/mobileqq/troop/troopaiobanner/c;", "bannerManager", "Lcom/tencent/mobileqq/troop/troopaiobanner/TroopAIONotifyBannerModel;", "f", "Lcom/tencent/mobileqq/troop/troopaiobanner/TroopAIONotifyBannerModel;", "bannerModel", "", "Z", "inited", "", "i", "Ljava/util/Map;", "tokenMap", "com/tencent/mobileqq/troop/troopaiobanner/TroopAIONotifyBannerTipsBar$b", "Lcom/tencent/mobileqq/troop/troopaiobanner/TroopAIONotifyBannerTipsBar$b;", "gameSwitchObserver", "Lcom/tencent/aio/api/runtime/a;", "B", "()Lcom/tencent/aio/api/runtime/a;", "aioContext", "G", "()Ljava/lang/String;", "troopUin", "Landroid/content/Context;", "D", "()Landroid/content/Context;", "context", "<init>", "()V", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopAIONotifyBannerTipsBar implements com.tencent.mobileqq.aio.notification.d {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final Map<Integer, Pair<AIONotificationBusiId, String>> D;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.aio.notification.c notificationManager;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c bannerManager;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TroopAIONotifyBannerModel bannerModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean inited;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<Integer, String> tokenMap;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b gameSwitchObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/troopaiobanner/TroopAIONotifyBannerTipsBar$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopaiobanner.TroopAIONotifyBannerTipsBar$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/troop/troopaiobanner/TroopAIONotifyBannerTipsBar$b", "Lcom/tencent/mobileqq/troop/troopgame/api/b;", "", "isSuccess", "", "uin", "errCode", "", "errInfo", "", "onModifyMemberGameCardSwitch", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b extends com.tencent.mobileqq.troop.troopgame.api.b {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAIONotifyBannerTipsBar.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.troopgame.api.b
        protected void onModifyMemberGameCardSwitch(boolean isSuccess, long uin, long errCode, @Nullable String errInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), Long.valueOf(uin), Long.valueOf(errCode), errInfo);
                return;
            }
            if (Intrinsics.areEqual(TroopAIONotifyBannerTipsBar.this.G(), String.valueOf(uin)) && isSuccess) {
                QLog.i("TroopAIONotifyBannerTipsBar", 1, "[onModifyMemberGameCardSwitch] queryTroopGameBanner again. code: " + errCode + ", errInfo: " + errInfo);
                TroopAIONotifyBannerModel troopAIONotifyBannerModel = TroopAIONotifyBannerTipsBar.this.bannerModel;
                if (troopAIONotifyBannerModel != null) {
                    troopAIONotifyBannerModel.m();
                }
            }
        }
    }

    static {
        HashMap hashMapOf;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62450);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        INSTANCE = new Companion(null);
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(4, new Pair(AIONotificationBusiId.TROOP_HW_NOTICE, "[\u73ed\u7ea7\u901a\u77e5]")), TuplesKt.to(5, new Pair(AIONotificationBusiId.TROOP_HW_CLOCK_IN, "[\u73ed\u7ea7\u6253\u5361]")));
        D = hashMapOf;
    }

    public TroopAIONotifyBannerTipsBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.tokenMap = new LinkedHashMap();
        this.gameSwitchObserver = new b();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.troop.troopaiobanner.h
            @Override // java.lang.Runnable
            public final void run() {
                TroopAIONotifyBannerTipsBar.f();
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IAIONotificationUIModel A(final GroupTopBannerNotifyPB$QueryTopBannerInfoRsp bannerInfo, String content, final String msgId) {
        int i3;
        AIOParam g16;
        AIOSession r16;
        AIOContact c16;
        switch (bannerInfo.biz_type.get()) {
            case 2:
                return new IAIONotificationUIModel.b(AIONotificationBusiId.TROOP_GAME_JOIN, content, IAIONotificationUIModel.ActionIcon.CLICKABLE_ARROW, null, 0, new Function2<IAIONotificationUIModel, Integer, Unit>(bannerInfo) { // from class: com.tencent.mobileqq.troop.troopaiobanner.TroopAIONotifyBannerTipsBar$createUIModule$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ GroupTopBannerNotifyPB$QueryTopBannerInfoRsp $bannerInfo;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                        this.$bannerInfo = bannerInfo;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAIONotifyBannerTipsBar.this, (Object) bannerInfo);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(IAIONotificationUIModel iAIONotificationUIModel, Integer num) {
                        invoke(iAIONotificationUIModel, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull IAIONotificationUIModel iAIONotificationUIModel, int i16) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iAIONotificationUIModel, i16);
                            return;
                        }
                        Intrinsics.checkNotNullParameter(iAIONotificationUIModel, "<anonymous parameter 0>");
                        if (i16 == 1 || i16 == 2 || i16 == 3) {
                            TroopAIONotifyBannerTipsBar.this.W(this.$bannerInfo);
                        }
                    }
                }, 24, null);
            case 3:
                return new IAIONotificationUIModel.b(AIONotificationBusiId.TROOP_META_DREAM_TEAM, content, IAIONotificationUIModel.ActionIcon.CLICKABLE_ARROW, null, 0, new Function2<IAIONotificationUIModel, Integer, Unit>(bannerInfo, msgId) { // from class: com.tencent.mobileqq.troop.troopaiobanner.TroopAIONotifyBannerTipsBar$createUIModule$3
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ GroupTopBannerNotifyPB$QueryTopBannerInfoRsp $bannerInfo;
                    final /* synthetic */ String $msgId;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                        this.$bannerInfo = bannerInfo;
                        this.$msgId = msgId;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, TroopAIONotifyBannerTipsBar.this, bannerInfo, msgId);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(IAIONotificationUIModel iAIONotificationUIModel, Integer num) {
                        invoke(iAIONotificationUIModel, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull IAIONotificationUIModel iAIONotificationUIModel, int i16) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iAIONotificationUIModel, i16);
                            return;
                        }
                        Intrinsics.checkNotNullParameter(iAIONotificationUIModel, "<anonymous parameter 0>");
                        if (i16 == 1 || i16 == 2 || i16 == 3) {
                            TroopAIONotifyBannerTipsBar.this.I(this.$bannerInfo, this.$msgId);
                        }
                    }
                }, 24, null);
            case 4:
            case 5:
                return E(bannerInfo);
            case 6:
                return new IAIONotificationUIModel.b(AIONotificationBusiId.TROOP_GROUP_ALBUM, content, IAIONotificationUIModel.ActionIcon.CLOSE, null, 0, new Function2<IAIONotificationUIModel, Integer, Unit>(bannerInfo) { // from class: com.tencent.mobileqq.troop.troopaiobanner.TroopAIONotifyBannerTipsBar$createUIModule$4
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ GroupTopBannerNotifyPB$QueryTopBannerInfoRsp $bannerInfo;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                        this.$bannerInfo = bannerInfo;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAIONotifyBannerTipsBar.this, (Object) bannerInfo);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(IAIONotificationUIModel iAIONotificationUIModel, Integer num) {
                        invoke(iAIONotificationUIModel, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull IAIONotificationUIModel iAIONotificationUIModel, int i16) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iAIONotificationUIModel, i16);
                            return;
                        }
                        Intrinsics.checkNotNullParameter(iAIONotificationUIModel, "<anonymous parameter 0>");
                        if (i16 != 1) {
                            if (i16 == 2) {
                                TroopAIONotifyBannerTipsBar.this.J(this.$bannerInfo);
                                return;
                            } else if (i16 != 3) {
                                return;
                            }
                        }
                        TroopAIONotifyBannerTipsBar.this.N(this.$bannerInfo);
                    }
                }, 24, null);
            case 7:
                return new IAIONotificationUIModel.b(AIONotificationBusiId.TROOP_ASSIGN_HW_NOTIFY_BAR, content, IAIONotificationUIModel.ActionIcon.CLOSE, null, 0, new Function2<IAIONotificationUIModel, Integer, Unit>(bannerInfo) { // from class: com.tencent.mobileqq.troop.troopaiobanner.TroopAIONotifyBannerTipsBar$createUIModule$5
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ GroupTopBannerNotifyPB$QueryTopBannerInfoRsp $bannerInfo;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                        this.$bannerInfo = bannerInfo;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAIONotifyBannerTipsBar.this, (Object) bannerInfo);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(IAIONotificationUIModel iAIONotificationUIModel, Integer num) {
                        invoke(iAIONotificationUIModel, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull IAIONotificationUIModel iAIONotificationUIModel, int i16) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iAIONotificationUIModel, i16);
                            return;
                        }
                        Intrinsics.checkNotNullParameter(iAIONotificationUIModel, "<anonymous parameter 0>");
                        if (i16 != 1) {
                            if (i16 != 2) {
                                if (i16 != 3) {
                                    if (i16 != 100) {
                                        return;
                                    }
                                }
                            }
                            TroopAIONotifyBannerTipsBar.this.J(this.$bannerInfo);
                            return;
                        }
                        TroopAIONotifyBannerTipsBar.this.H(this.$bannerInfo);
                    }
                }, 24, null);
            case 8:
                return new IAIONotificationUIModel.b(AIONotificationBusiId.TROOP_WANGZHE_REPORT, content, IAIONotificationUIModel.ActionIcon.CLOSE, null, 0, new Function2<IAIONotificationUIModel, Integer, Unit>(bannerInfo) { // from class: com.tencent.mobileqq.troop.troopaiobanner.TroopAIONotifyBannerTipsBar$createUIModule$6
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ GroupTopBannerNotifyPB$QueryTopBannerInfoRsp $bannerInfo;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                        this.$bannerInfo = bannerInfo;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAIONotifyBannerTipsBar.this, (Object) bannerInfo);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(IAIONotificationUIModel iAIONotificationUIModel, Integer num) {
                        invoke(iAIONotificationUIModel, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull IAIONotificationUIModel iAIONotificationUIModel, int i16) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iAIONotificationUIModel, i16);
                            return;
                        }
                        Intrinsics.checkNotNullParameter(iAIONotificationUIModel, "<anonymous parameter 0>");
                        if (i16 == 1) {
                            TroopAIONotifyBannerTipsBar.this.V(this.$bannerInfo);
                        } else {
                            if (i16 != 2) {
                                return;
                            }
                            TroopAIONotifyBannerTipsBar.this.J(this.$bannerInfo);
                        }
                    }
                }, 24, null);
            case 9:
                IO3NotifyBannerApi iO3NotifyBannerApi = (IO3NotifyBannerApi) QRoute.api(IO3NotifyBannerApi.class);
                String str = bannerInfo.notify_banner.url.get();
                String G = G();
                com.tencent.aio.api.runtime.a B = B();
                if (B != null && (g16 = B.g()) != null && (r16 = g16.r()) != null && (c16 = r16.c()) != null) {
                    i3 = c16.e();
                } else {
                    i3 = 0;
                }
                iO3NotifyBannerApi.onNotifyBannerCreate(str, G, i3);
                return new IAIONotificationUIModel.b(AIONotificationBusiId.FRAUD, content, IAIONotificationUIModel.ActionIcon.CLOSE, null, 0, new Function2<IAIONotificationUIModel, Integer, Unit>(this) { // from class: com.tencent.mobileqq.troop.troopaiobanner.TroopAIONotifyBannerTipsBar$createUIModule$7
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ TroopAIONotifyBannerTipsBar this$0;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                        this.this$0 = this;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) GroupTopBannerNotifyPB$QueryTopBannerInfoRsp.this, (Object) this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(IAIONotificationUIModel iAIONotificationUIModel, Integer num) {
                        invoke(iAIONotificationUIModel, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull IAIONotificationUIModel iAIONotificationUIModel, int i16) {
                        com.tencent.aio.api.runtime.a B2;
                        AIOParam g17;
                        AIOSession r17;
                        AIOContact c17;
                        com.tencent.aio.api.runtime.a B3;
                        AIOParam g18;
                        AIOSession r18;
                        AIOContact c18;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iAIONotificationUIModel, i16);
                            return;
                        }
                        Intrinsics.checkNotNullParameter(iAIONotificationUIModel, "<anonymous parameter 0>");
                        int i17 = 0;
                        if (i16 == 1) {
                            IO3NotifyBannerApi iO3NotifyBannerApi2 = (IO3NotifyBannerApi) QRoute.api(IO3NotifyBannerApi.class);
                            String str2 = GroupTopBannerNotifyPB$QueryTopBannerInfoRsp.this.notify_banner.url.get();
                            String G2 = this.this$0.G();
                            B2 = this.this$0.B();
                            if (B2 != null && (g17 = B2.g()) != null && (r17 = g17.r()) != null && (c17 = r17.c()) != null) {
                                i17 = c17.e();
                            }
                            iO3NotifyBannerApi2.onNotifyBannerClick(str2, G2, i17, 1);
                            this.this$0.L(GroupTopBannerNotifyPB$QueryTopBannerInfoRsp.this);
                            return;
                        }
                        if (i16 != 2) {
                            return;
                        }
                        IO3NotifyBannerApi iO3NotifyBannerApi3 = (IO3NotifyBannerApi) QRoute.api(IO3NotifyBannerApi.class);
                        String str3 = GroupTopBannerNotifyPB$QueryTopBannerInfoRsp.this.notify_banner.url.get();
                        String G3 = this.this$0.G();
                        B3 = this.this$0.B();
                        if (B3 != null && (g18 = B3.g()) != null && (r18 = g18.r()) != null && (c18 = r18.c()) != null) {
                            i17 = c18.e();
                        }
                        iO3NotifyBannerApi3.onNotifyBannerClick(str3, G3, i17, 3);
                        this.this$0.J(GroupTopBannerNotifyPB$QueryTopBannerInfoRsp.this);
                    }
                }, 24, null);
            case 10:
            default:
                return new IAIONotificationUIModel.b(AIONotificationBusiId.TROOP_GAME_TEAM, content, IAIONotificationUIModel.ActionIcon.CLICKABLE_ARROW, null, 0, new Function2<IAIONotificationUIModel, Integer, Unit>(bannerInfo, msgId) { // from class: com.tencent.mobileqq.troop.troopaiobanner.TroopAIONotifyBannerTipsBar$createUIModule$9
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ GroupTopBannerNotifyPB$QueryTopBannerInfoRsp $bannerInfo;
                    final /* synthetic */ String $msgId;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                        this.$bannerInfo = bannerInfo;
                        this.$msgId = msgId;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, TroopAIONotifyBannerTipsBar.this, bannerInfo, msgId);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(IAIONotificationUIModel iAIONotificationUIModel, Integer num) {
                        invoke(iAIONotificationUIModel, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull IAIONotificationUIModel iAIONotificationUIModel, int i16) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iAIONotificationUIModel, i16);
                            return;
                        }
                        Intrinsics.checkNotNullParameter(iAIONotificationUIModel, "<anonymous parameter 0>");
                        if (i16 == 1 || i16 == 2 || i16 == 3) {
                            TroopAIONotifyBannerTipsBar.this.I(this.$bannerInfo, this.$msgId);
                        }
                    }
                }, 24, null);
            case 11:
                return new IAIONotificationUIModel.b(AIONotificationBusiId.TROOP_TEAM_UP, content, IAIONotificationUIModel.ActionIcon.CLICKABLE_ARROW, null, 0, new Function2<IAIONotificationUIModel, Integer, Unit>(bannerInfo) { // from class: com.tencent.mobileqq.troop.troopaiobanner.TroopAIONotifyBannerTipsBar$createUIModule$8
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ GroupTopBannerNotifyPB$QueryTopBannerInfoRsp $bannerInfo;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                        this.$bannerInfo = bannerInfo;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAIONotifyBannerTipsBar.this, (Object) bannerInfo);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(IAIONotificationUIModel iAIONotificationUIModel, Integer num) {
                        invoke(iAIONotificationUIModel, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull IAIONotificationUIModel iAIONotificationUIModel, int i16) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iAIONotificationUIModel, i16);
                            return;
                        }
                        Intrinsics.checkNotNullParameter(iAIONotificationUIModel, "<anonymous parameter 0>");
                        if (i16 == 1 || i16 == 2 || i16 == 3) {
                            TroopAIONotifyBannerTipsBar.this.M(this.$bannerInfo);
                        }
                    }
                }, 24, null);
            case 12:
                return new IAIONotificationUIModel.b(AIONotificationBusiId.TROOP_META_DREAM_FARM, content, IAIONotificationUIModel.ActionIcon.CLICKABLE_ARROW, null, 0, new Function2<IAIONotificationUIModel, Integer, Unit>(bannerInfo, msgId) { // from class: com.tencent.mobileqq.troop.troopaiobanner.TroopAIONotifyBannerTipsBar$createUIModule$2
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ GroupTopBannerNotifyPB$QueryTopBannerInfoRsp $bannerInfo;
                    final /* synthetic */ String $msgId;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                        this.$bannerInfo = bannerInfo;
                        this.$msgId = msgId;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, TroopAIONotifyBannerTipsBar.this, bannerInfo, msgId);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(IAIONotificationUIModel iAIONotificationUIModel, Integer num) {
                        invoke(iAIONotificationUIModel, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull IAIONotificationUIModel iAIONotificationUIModel, int i16) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iAIONotificationUIModel, i16);
                            return;
                        }
                        Intrinsics.checkNotNullParameter(iAIONotificationUIModel, "<anonymous parameter 0>");
                        if (i16 == 1 || i16 == 2 || i16 == 3) {
                            TroopAIONotifyBannerTipsBar.this.K(this.$bannerInfo, this.$msgId);
                        }
                    }
                }, 24, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.aio.api.runtime.a B() {
        com.tencent.mobileqq.aio.notification.c cVar = this.notificationManager;
        if (cVar != null) {
            return cVar.a();
        }
        return null;
    }

    private final void C(GroupTopBannerNotifyPB$QueryTopBannerInfoRsp bannerInfo, final Function1<? super String, Unit> callback) {
        PBStringField pBStringField;
        PBStringField pBStringField2;
        PBStringField pBStringField3;
        PBStringField pBStringField4;
        String str = "";
        String str2 = null;
        if (bannerInfo.biz_type.get() != 4 && bannerInfo.biz_type.get() != 5) {
            if (bannerInfo.biz_type.get() != 8 && bannerInfo.biz_type.get() != 9 && bannerInfo.biz_type.get() != 12) {
                if (bannerInfo.biz_type.get() == 11) {
                    GroupTopBannerNotifyPB$NotifyBanner groupTopBannerNotifyPB$NotifyBanner = bannerInfo.notify_banner;
                    if (groupTopBannerNotifyPB$NotifyBanner != null && (pBStringField4 = groupTopBannerNotifyPB$NotifyBanner.text) != null) {
                        str2 = pBStringField4.get();
                    }
                    if (str2 != null) {
                        str = str2;
                    }
                    callback.invoke(str);
                    return;
                }
                if (bannerInfo.biz_type.get() == 6) {
                    F(bannerInfo, callback);
                    return;
                }
                GroupTopBannerNotifyPB$NotifyBanner groupTopBannerNotifyPB$NotifyBanner2 = bannerInfo.notify_banner.get();
                if (bannerInfo.biz_type.get() == 7 && groupTopBannerNotifyPB$NotifyBanner2 != null) {
                    String str3 = groupTopBannerNotifyPB$NotifyBanner2.text.get();
                    Intrinsics.checkNotNullExpressionValue(str3, "notifyBanner.text.get()");
                    callback.invoke(str3);
                    return;
                }
                final GroupTopBannerNotifyPB$GameTeamUpBanner groupTopBannerNotifyPB$GameTeamUpBanner = bannerInfo.team_up_banner.get();
                if (groupTopBannerNotifyPB$GameTeamUpBanner == null) {
                    GroupTopBannerNotifyPB$TodoBanner groupTopBannerNotifyPB$TodoBanner = bannerInfo.to_do_banner;
                    if (groupTopBannerNotifyPB$TodoBanner != null && (pBStringField3 = groupTopBannerNotifyPB$TodoBanner.text) != null) {
                        str2 = pBStringField3.get();
                    }
                    if (str2 != null) {
                        str = str2;
                    }
                    callback.invoke(str);
                    return;
                }
                if (groupTopBannerNotifyPB$GameTeamUpBanner.is_multi.get()) {
                    String str4 = groupTopBannerNotifyPB$GameTeamUpBanner.multi_group_text.get();
                    Intrinsics.checkNotNullExpressionValue(str4, "teamUpBanner.multi_group_text.get()");
                    callback.invoke(str4);
                    return;
                } else {
                    final long j3 = groupTopBannerNotifyPB$GameTeamUpBanner.team_leader.get();
                    ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberName(G(), String.valueOf(j3), "TroopAIONotifyBannerTipsBar", new Function1<TroopMemberNickInfo, Unit>(j3, groupTopBannerNotifyPB$GameTeamUpBanner, callback) { // from class: com.tencent.mobileqq.troop.troopaiobanner.TroopAIONotifyBannerTipsBar$getBannerContent$1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ Function1<String, Unit> $callback;
                        final /* synthetic */ long $teamLeaderUin;
                        final /* synthetic */ GroupTopBannerNotifyPB$GameTeamUpBanner $teamUpBanner;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                            this.$teamLeaderUin = j3;
                            this.$teamUpBanner = groupTopBannerNotifyPB$GameTeamUpBanner;
                            this.$callback = callback;
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), groupTopBannerNotifyPB$GameTeamUpBanner, callback);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TroopMemberNickInfo troopMemberNickInfo) {
                            invoke2(troopMemberNickInfo);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@Nullable TroopMemberNickInfo troopMemberNickInfo) {
                            String valueOf;
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopMemberNickInfo);
                                return;
                            }
                            if (troopMemberNickInfo == null || (valueOf = troopMemberNickInfo.getShowName()) == null) {
                                valueOf = String.valueOf(this.$teamLeaderUin);
                            }
                            this.$callback.invoke(valueOf + this.$teamUpBanner.single_group_text.get());
                        }
                    });
                    return;
                }
            }
            GroupTopBannerNotifyPB$NotifyBanner groupTopBannerNotifyPB$NotifyBanner3 = bannerInfo.notify_banner;
            if (groupTopBannerNotifyPB$NotifyBanner3 != null && (pBStringField2 = groupTopBannerNotifyPB$NotifyBanner3.text) != null) {
                str2 = pBStringField2.get();
            }
            if (str2 != null) {
                str = str2;
            }
            callback.invoke(str);
            return;
        }
        GroupTopBannerNotifyPB$TodoBanner groupTopBannerNotifyPB$TodoBanner2 = bannerInfo.to_do_banner;
        if (groupTopBannerNotifyPB$TodoBanner2 != null && (pBStringField = groupTopBannerNotifyPB$TodoBanner2.text) != null) {
            str2 = pBStringField.get();
        }
        if (str2 != null) {
            str = str2;
        }
        callback.invoke(str);
    }

    private final Context D() {
        Fragment c16;
        com.tencent.aio.api.runtime.a B = B();
        if (B != null && (c16 = B.c()) != null) {
            return c16.getContext();
        }
        return null;
    }

    private final IAIONotificationUIModel E(final GroupTopBannerNotifyPB$QueryTopBannerInfoRsp bannerInfo) {
        String str;
        PBStringField pBStringField;
        Pair<AIONotificationBusiId, String> pair = D.get(Integer.valueOf(bannerInfo.biz_type.get()));
        Intrinsics.checkNotNull(pair, "null cannot be cast to non-null type kotlin.Pair<com.tencent.mobileqq.aio.notification.AIONotificationBusiId, kotlin.String>");
        Pair<AIONotificationBusiId, String> pair2 = pair;
        AIONotificationBusiId component1 = pair2.component1();
        String component2 = pair2.component2();
        IAIONotificationUIModel.c.Companion companion = IAIONotificationUIModel.c.INSTANCE;
        GroupTopBannerNotifyPB$TodoBanner groupTopBannerNotifyPB$TodoBanner = bannerInfo.to_do_banner;
        if (groupTopBannerNotifyPB$TodoBanner != null && (pBStringField = groupTopBannerNotifyPB$TodoBanner.text) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        IAIONotificationUIModel.c a16 = companion.a(component1, component2, str, new Function2<IAIONotificationUIModel, Integer, Unit>(this) { // from class: com.tencent.mobileqq.troop.troopaiobanner.TroopAIONotifyBannerTipsBar$getHomeworkUIModel$model$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ TroopAIONotifyBannerTipsBar this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
                this.this$0 = this;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) GroupTopBannerNotifyPB$QueryTopBannerInfoRsp.this, (Object) this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(IAIONotificationUIModel iAIONotificationUIModel, Integer num) {
                invoke(iAIONotificationUIModel, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull IAIONotificationUIModel iAIONotificationUIModel, int i3) {
                com.tencent.mobileqq.aio.notification.c cVar;
                com.tencent.aio.api.runtime.a a17;
                Fragment c16;
                FragmentActivity activity;
                PBStringField pBStringField2;
                Map map;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) iAIONotificationUIModel, i3);
                    return;
                }
                Intrinsics.checkNotNullParameter(iAIONotificationUIModel, "<anonymous parameter 0>");
                if (i3 != 1) {
                    if (i3 == 2 || i3 == 3) {
                        int i16 = GroupTopBannerNotifyPB$QueryTopBannerInfoRsp.this.biz_type.get();
                        TroopAIONotifyBannerTipsBar troopAIONotifyBannerTipsBar = this.this$0;
                        map = troopAIONotifyBannerTipsBar.tokenMap;
                        Object obj = map.get(Integer.valueOf(i16));
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(obj);
                        troopAIONotifyBannerTipsBar.O(i16, sb5.toString(), GroupTopBannerNotifyPB$QueryTopBannerInfoRsp.this);
                        return;
                    }
                    return;
                }
                cVar = this.this$0.notificationManager;
                if (cVar == null || (a17 = cVar.a()) == null || (c16 = a17.c()) == null || (activity = c16.getActivity()) == null) {
                    return;
                }
                GroupTopBannerNotifyPB$QueryTopBannerInfoRsp groupTopBannerNotifyPB$QueryTopBannerInfoRsp = GroupTopBannerNotifyPB$QueryTopBannerInfoRsp.this;
                QRouteApi api = QRoute.api(IHWTroopUIApi.class);
                Intrinsics.checkNotNullExpressionValue(api, "api(IHWTroopUIApi::class.java)");
                IHWTroopUIApi iHWTroopUIApi = (IHWTroopUIApi) api;
                GroupTopBannerNotifyPB$TodoBanner groupTopBannerNotifyPB$TodoBanner2 = groupTopBannerNotifyPB$QueryTopBannerInfoRsp.to_do_banner;
                IHWTroopUIApi.b.a(iHWTroopUIApi, activity, (groupTopBannerNotifyPB$TodoBanner2 == null || (pBStringField2 = groupTopBannerNotifyPB$TodoBanner2.url) == null) ? null : pBStringField2.get(), null, null, IHWTroopUIApi.DetailPageFrom.GROUP_BAR, 12, null);
            }
        });
        PBBoolField pBBoolField = bannerInfo.to_do_banner.is_exposure;
        boolean z16 = false;
        if (pBBoolField != null && pBBoolField.get()) {
            z16 = true;
        }
        if (z16) {
            a16.j("\u5b8c\u6210");
            a16.i(IAIONotificationUIModel.ActionIcon.NONE);
        } else {
            a16.j("");
            a16.i(IAIONotificationUIModel.ActionIcon.ARROW);
        }
        return a16;
    }

    private final void F(final GroupTopBannerNotifyPB$QueryTopBannerInfoRsp bannerInfo, final Function1<? super String, Unit> callback) {
        final long j3 = bannerInfo.interaction_banner.user.get();
        ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberName(G(), String.valueOf(j3), "TroopAIONotifyBannerTipsBar", new Function1<TroopMemberNickInfo, Unit>(j3, callback, bannerInfo) { // from class: com.tencent.mobileqq.troop.troopaiobanner.TroopAIONotifyBannerTipsBar$getTroopGroupAlbumContent$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ GroupTopBannerNotifyPB$QueryTopBannerInfoRsp $bannerInfo;
            final /* synthetic */ Function1<String, Unit> $callback;
            final /* synthetic */ long $uin;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$uin = j3;
                this.$callback = callback;
                this.$bannerInfo = bannerInfo;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), callback, bannerInfo);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TroopMemberNickInfo troopMemberNickInfo) {
                invoke2(troopMemberNickInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable TroopMemberNickInfo troopMemberNickInfo) {
                String valueOf;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopMemberNickInfo);
                    return;
                }
                if (troopMemberNickInfo == null || (valueOf = troopMemberNickInfo.getShowName()) == null) {
                    valueOf = String.valueOf(this.$uin);
                }
                this.$callback.invoke(valueOf + this.$bannerInfo.interaction_banner.single_group_text.get());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String G() {
        AIOParam g16;
        AIOSession r16;
        AIOContact c16;
        String j3;
        com.tencent.aio.api.runtime.a B = B();
        if (B == null || (g16 = B.g()) == null || (r16 = g16.r()) == null || (c16 = r16.c()) == null || (j3 = c16.j()) == null) {
            return "";
        }
        return j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H(GroupTopBannerNotifyPB$QueryTopBannerInfoRsp bannerInfo) {
        J(bannerInfo);
        if (bannerInfo.notify_banner.has() && bannerInfo.notify_banner.url.has()) {
            QRoute.createNavigator(D(), RouterConstants.UI_ROUTE_BROWSER).withString("url", bannerInfo.notify_banner.url.get()).request();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I(GroupTopBannerNotifyPB$QueryTopBannerInfoRsp bannerInfo, String msgId) {
        Activity activity;
        Context D2 = D();
        if (D2 != null) {
            String str = bannerInfo.team_up_banner.url.get();
            ax axVar = null;
            if (D2 instanceof Activity) {
                activity = (Activity) D2;
            } else {
                activity = null;
            }
            if (activity != null) {
                axVar = bi.c(TroopUtils.f(), activity, str);
            }
            if (axVar != null) {
                axVar.b();
            } else {
                QRoute.createNavigator(D2, RouterConstants.UI_ROUTE_BROWSER).withString("url", str).request();
            }
        }
        TroopAIONotifyBannerModel troopAIONotifyBannerModel = this.bannerModel;
        if (troopAIONotifyBannerModel != null) {
            int i3 = bannerInfo.biz_type.get();
            if (msgId == null) {
                msgId = "";
            }
            troopAIONotifyBannerModel.p(new a(i3, msgId));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J(GroupTopBannerNotifyPB$QueryTopBannerInfoRsp bannerInfo) {
        int i3 = bannerInfo.biz_type.get();
        String str = this.tokenMap.get(Integer.valueOf(i3));
        StringBuilder sb5 = new StringBuilder();
        sb5.append((Object) str);
        O(i3, sb5.toString(), bannerInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K(GroupTopBannerNotifyPB$QueryTopBannerInfoRsp bannerInfo, String msgId) {
        Activity activity;
        if (!NetworkUtil.isNetworkAvailable()) {
            QQToast.makeText(BaseApplication.context, "\u7f51\u7edc\u4e0d\u53ef\u7528", 0).show();
            return;
        }
        J(bannerInfo);
        Context D2 = D();
        if (D2 != null) {
            String str = bannerInfo.notify_banner.url.get();
            ax axVar = null;
            if (D2 instanceof Activity) {
                activity = (Activity) D2;
            } else {
                activity = null;
            }
            if (activity != null) {
                axVar = bi.c(TroopUtils.f(), activity, str);
            }
            if (axVar != null) {
                axVar.b();
            } else {
                QRoute.createNavigator(D2, RouterConstants.UI_ROUTE_BROWSER).withString("url", str).request();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L(GroupTopBannerNotifyPB$QueryTopBannerInfoRsp bannerInfo) {
        boolean startsWith$default;
        Activity activity;
        AIOParam g16;
        AIOSession r16;
        AIOContact c16;
        J(bannerInfo);
        String url = bannerInfo.notify_banner.url.get();
        if (TextUtils.isEmpty(url)) {
            QLog.e("TroopAIONotifyBannerTipsBar", 1, "O3NotifyBanner url is empty");
            return;
        }
        Context D2 = D();
        if (D2 == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(url, "url");
        int i3 = 0;
        ax axVar = null;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, "mqqapi://o3/report", false, 2, null);
        if (startsWith$default) {
            String G = G();
            com.tencent.aio.api.runtime.a B = B();
            if (B != null && (g16 = B.g()) != null && (r16 = g16.r()) != null && (c16 = r16.c()) != null) {
                i3 = c16.e();
            }
            url = ((Object) url) + "&uid=" + G + "&chat_type=" + i3 + "&gray_tip_time=" + (System.currentTimeMillis() / 1000) + "&src=2";
        }
        if (D2 instanceof Activity) {
            activity = (Activity) D2;
        } else {
            activity = null;
        }
        if (activity != null) {
            axVar = bi.c(TroopUtils.f(), activity, url);
        }
        if (axVar != null) {
            axVar.b();
        } else {
            QRoute.createNavigator(D2, RouterConstants.UI_ROUTE_BROWSER).withString("url", url).request();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M(GroupTopBannerNotifyPB$QueryTopBannerInfoRsp bannerInfo) {
        Activity activity;
        J(bannerInfo);
        if (bannerInfo.notify_banner.has() && bannerInfo.notify_banner.url.has()) {
            String str = bannerInfo.notify_banner.url.get();
            Context D2 = D();
            ax axVar = null;
            if (D2 instanceof Activity) {
                activity = (Activity) D2;
            } else {
                activity = null;
            }
            if (activity != null) {
                axVar = bi.c(TroopUtils.f(), activity, str);
            }
            if (axVar != null) {
                axVar.b();
            } else {
                QRoute.createNavigator(D(), RouterConstants.UI_ROUTE_BROWSER).withString("url", str).request();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N(GroupTopBannerNotifyPB$QueryTopBannerInfoRsp bannerInfo) {
        if (!NetworkUtil.isNetworkAvailable()) {
            QQToast.makeText(BaseApplication.context, "\u7f51\u7edc\u4e0d\u53ef\u7528", 0).show();
            return;
        }
        J(bannerInfo);
        String str = bannerInfo.interaction_banner.url.get();
        if (str != null) {
            ((IQZoneGroupAlbumArkUtil) QRoute.api(IQZoneGroupAlbumArkUtil.class)).handleGroupArkUrl(D(), str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O(int bannerBizType, final String bannerToken, GroupTopBannerNotifyPB$QueryTopBannerInfoRsp bannerInfo) {
        final Pair<GroupTopBannerNotifyPB$QueryTopBannerInfoRsp, String> f16;
        this.tokenMap.remove(Integer.valueOf(bannerBizType));
        TroopAIONotifyBannerModel troopAIONotifyBannerModel = this.bannerModel;
        if (troopAIONotifyBannerModel != null && (f16 = troopAIONotifyBannerModel.f(bannerInfo)) != null) {
            this.tokenMap.put(Integer.valueOf(f16.getFirst().biz_type.get()), bannerToken);
            C(f16.getFirst(), new Function1<String, Unit>(bannerToken, f16) { // from class: com.tencent.mobileqq.troop.troopaiobanner.TroopAIONotifyBannerTipsBar$hideBanner$1$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ String $bannerToken;
                final /* synthetic */ Pair<GroupTopBannerNotifyPB$QueryTopBannerInfoRsp, String> $newBannerInfo;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$bannerToken = bannerToken;
                    this.$newBannerInfo = f16;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, TroopAIONotifyBannerTipsBar.this, bannerToken, f16);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull String it) {
                    com.tencent.mobileqq.aio.notification.c cVar;
                    IAIONotificationUIModel A;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(it, "it");
                    cVar = TroopAIONotifyBannerTipsBar.this.notificationManager;
                    if (cVar != null) {
                        String str = this.$bannerToken;
                        A = TroopAIONotifyBannerTipsBar.this.A(this.$newBannerInfo.getFirst(), it, this.$newBannerInfo.getSecond());
                        cVar.j(str, A);
                    }
                }
            });
        } else {
            com.tencent.mobileqq.aio.notification.c cVar = this.notificationManager;
            if (cVar != null) {
                cVar.g(bannerToken);
            }
        }
        switch (bannerBizType) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 11:
            case 12:
                TroopAIONotifyBannerModel troopAIONotifyBannerModel2 = this.bannerModel;
                if (troopAIONotifyBannerModel2 != null) {
                    troopAIONotifyBannerModel2.o(bannerInfo);
                    return;
                }
                return;
            case 10:
            default:
                return;
        }
    }

    private final void P() {
        if (this.inited) {
            return;
        }
        this.inited = true;
        Q();
        S();
        TroopAIONotifyBannerModel troopAIONotifyBannerModel = this.bannerModel;
        if (troopAIONotifyBannerModel != null) {
            troopAIONotifyBannerModel.m();
        }
    }

    private final void Q() {
        AppInterface appInterface;
        Manager manager;
        c cVar;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        TroopAIONotifyBannerModel troopAIONotifyBannerModel = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            manager = appInterface.getManager(QQManagerFactory.TROOP_GAME_BANNER_MANAGER);
        } else {
            manager = null;
        }
        if (manager instanceof c) {
            cVar = (c) manager;
        } else {
            cVar = null;
        }
        this.bannerManager = cVar;
        if (cVar != null) {
            troopAIONotifyBannerModel = cVar.b(G());
        }
        this.bannerModel = troopAIONotifyBannerModel;
    }

    private final void R() {
        QQAppInterface f16 = TroopUtils.f();
        if (f16 != null) {
            f16.addObserver(this.gameSwitchObserver);
        }
    }

    private final void S() {
        LifecycleOwner d16;
        MutableLiveData<Pair<GroupTopBannerNotifyPB$QueryTopBannerInfoRsp, String>> e16;
        MutableLiveData<a> g16;
        com.tencent.aio.api.runtime.a B = B();
        if (B != null && (d16 = B.d()) != null) {
            TroopAIONotifyBannerModel troopAIONotifyBannerModel = this.bannerModel;
            if (troopAIONotifyBannerModel != null && (g16 = troopAIONotifyBannerModel.g()) != null) {
                final Function1<a, Unit> function1 = new Function1<a, Unit>() { // from class: com.tencent.mobileqq.troop.troopaiobanner.TroopAIONotifyBannerTipsBar$initObserver$1$1
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAIONotifyBannerTipsBar.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(a aVar) {
                        invoke2(aVar);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable a aVar) {
                        TroopAIONotifyBannerModel troopAIONotifyBannerModel2;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
                        } else {
                            if (aVar == null || (troopAIONotifyBannerModel2 = TroopAIONotifyBannerTipsBar.this.bannerModel) == null) {
                                return;
                            }
                            troopAIONotifyBannerModel2.p(aVar);
                        }
                    }
                };
                g16.observe(d16, new Observer() { // from class: com.tencent.mobileqq.troop.troopaiobanner.i
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        TroopAIONotifyBannerTipsBar.T(Function1.this, obj);
                    }
                });
            }
            TroopAIONotifyBannerModel troopAIONotifyBannerModel2 = this.bannerModel;
            if (troopAIONotifyBannerModel2 != null && (e16 = troopAIONotifyBannerModel2.e()) != null) {
                final Function1<Pair<? extends GroupTopBannerNotifyPB$QueryTopBannerInfoRsp, ? extends String>, Unit> function12 = new Function1<Pair<? extends GroupTopBannerNotifyPB$QueryTopBannerInfoRsp, ? extends String>, Unit>() { // from class: com.tencent.mobileqq.troop.troopaiobanner.TroopAIONotifyBannerTipsBar$initObserver$1$2
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAIONotifyBannerTipsBar.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends GroupTopBannerNotifyPB$QueryTopBannerInfoRsp, ? extends String> pair) {
                        invoke2((Pair<GroupTopBannerNotifyPB$QueryTopBannerInfoRsp, String>) pair);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Pair<GroupTopBannerNotifyPB$QueryTopBannerInfoRsp, String> pair) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) pair);
                        } else {
                            if (pair == null) {
                                return;
                            }
                            TroopAIONotifyBannerTipsBar.this.d0(pair.getFirst(), pair.getSecond());
                        }
                    }
                };
                e16.observe(d16, new Observer() { // from class: com.tencent.mobileqq.troop.troopaiobanner.j
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        TroopAIONotifyBannerTipsBar.U(Function1.this, obj);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V(GroupTopBannerNotifyPB$QueryTopBannerInfoRsp bannerInfo) {
        Activity activity;
        J(bannerInfo);
        Context D2 = D();
        if (D2 != null) {
            String str = bannerInfo.notify_banner.url.get();
            ax axVar = null;
            if (D2 instanceof Activity) {
                activity = (Activity) D2;
            } else {
                activity = null;
            }
            if (activity != null) {
                axVar = bi.c(TroopUtils.f(), activity, str);
            }
            if (axVar != null) {
                axVar.b();
            } else {
                QRoute.createNavigator(D2, RouterConstants.UI_ROUTE_BROWSER).withString("url", str).request();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W(final GroupTopBannerNotifyPB$QueryTopBannerInfoRsp bannerInfo) {
        com.tencent.mobileqq.troop.troopgame.api.a aVar;
        if (FastClickUtils.isFastDoubleClick("onPlayTogetherBannerClicked")) {
            return;
        }
        QLog.i("TroopAIONotifyBannerTipsBar", 1, "[onPlayTogetherBannerClicked] troopUin: " + G());
        if (TextUtils.isEmpty(G())) {
            QLog.w("TroopAIONotifyBannerTipsBar", 1, "[onPlayTogetherBannerClicked] failed. troopUin is empty");
            Z(this, null, 1, null);
            return;
        }
        Object businessHandler = TroopUtils.f().getBusinessHandler(((ITroopHandlerNameApi) QRoute.api(ITroopHandlerNameApi.class)).getTroopGameHandlerName());
        if (businessHandler instanceof com.tencent.mobileqq.troop.troopgame.api.a) {
            aVar = (com.tencent.mobileqq.troop.troopgame.api.a) businessHandler;
        } else {
            aVar = null;
        }
        if (aVar == null) {
            QLog.i("TroopAIONotifyBannerTipsBar", 1, "[onPlayTogetherBannerClicked] failed. troopHandler is null");
            Z(this, null, 1, null);
        } else {
            aVar.U0(G(), new a.InterfaceC8809a() { // from class: com.tencent.mobileqq.troop.troopaiobanner.k
                @Override // com.tencent.mobileqq.troop.troopgame.api.a.InterfaceC8809a
                public final void a(boolean z16, boolean z17) {
                    TroopAIONotifyBannerTipsBar.X(TroopAIONotifyBannerTipsBar.this, bannerInfo, z16, z17);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(TroopAIONotifyBannerTipsBar this$0, GroupTopBannerNotifyPB$QueryTopBannerInfoRsp bannerInfo, boolean z16, boolean z17) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bannerInfo, "$bannerInfo");
        if (!z16) {
            this$0.Y(HardCodeUtil.qqStr(R.string.f180433b2));
            return;
        }
        if (!z17) {
            QQToast.makeText(BaseApplication.context, HardCodeUtil.qqStr(R.string.f180443b3), 0).show();
        } else {
            Context D2 = this$0.D();
            if (D2 != null) {
                QRoute.createNavigator(D2, RouterConstants.UI_ROUTE_BROWSER).withString("url", bannerInfo.team_up_banner.url.get()).request();
            }
        }
    }

    private final void Y(String errMsg) {
        if (TextUtils.isEmpty(errMsg)) {
            errMsg = HardCodeUtil.qqStr(R.string.cpp);
        }
        QLog.w("TroopAIONotifyBannerTipsBar", 1, "[onPlayTogetherBannerFailed] " + errMsg);
        QQToast.makeText(BaseApplication.context, errMsg, 0).show();
    }

    static /* synthetic */ void Z(TroopAIONotifyBannerTipsBar troopAIONotifyBannerTipsBar, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        troopAIONotifyBannerTipsBar.Y(str);
    }

    private final void a0(final int bannerBizType, final GroupTopBannerNotifyPB$QueryTopBannerInfoRsp bannerInfo, final String msgId) {
        Pair<GroupTopBannerNotifyPB$QueryTopBannerInfoRsp, String> pair;
        TroopAIONotifyBannerModel troopAIONotifyBannerModel = this.bannerModel;
        if (troopAIONotifyBannerModel != null) {
            pair = troopAIONotifyBannerModel.f(bannerInfo);
        } else {
            pair = null;
        }
        if (pair == null || !this.tokenMap.containsKey(Integer.valueOf(pair.getFirst().biz_type.get()))) {
            C(bannerInfo, new Function1<String, Unit>(bannerInfo, msgId, bannerBizType) { // from class: com.tencent.mobileqq.troop.troopaiobanner.TroopAIONotifyBannerTipsBar$showBanner$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $bannerBizType;
                final /* synthetic */ GroupTopBannerNotifyPB$QueryTopBannerInfoRsp $bannerInfo;
                final /* synthetic */ String $msgId;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$bannerInfo = bannerInfo;
                    this.$msgId = msgId;
                    this.$bannerBizType = bannerBizType;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, TroopAIONotifyBannerTipsBar.this, bannerInfo, msgId, Integer.valueOf(bannerBizType));
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull String it) {
                    com.tencent.mobileqq.aio.notification.c cVar;
                    IAIONotificationUIModel A;
                    Map map;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(it, "it");
                    cVar = TroopAIONotifyBannerTipsBar.this.notificationManager;
                    if (cVar != null) {
                        A = TroopAIONotifyBannerTipsBar.this.A(this.$bannerInfo, it, this.$msgId);
                        String c16 = cVar.c(A);
                        if (c16 != null) {
                            TroopAIONotifyBannerTipsBar troopAIONotifyBannerTipsBar = TroopAIONotifyBannerTipsBar.this;
                            Integer valueOf = Integer.valueOf(this.$bannerBizType);
                            map = troopAIONotifyBannerTipsBar.tokenMap;
                            map.put(valueOf, c16);
                        }
                    }
                }
            });
        }
    }

    private final void b0() {
        QQAppInterface f16 = TroopUtils.f();
        if (f16 != null) {
            f16.removeObserver(this.gameSwitchObserver);
        }
    }

    private final void c0(final String bannerToken, final GroupTopBannerNotifyPB$QueryTopBannerInfoRsp bannerInfo, final String msgId) {
        C(bannerInfo, new Function1<String, Unit>(bannerToken, bannerInfo, msgId) { // from class: com.tencent.mobileqq.troop.troopaiobanner.TroopAIONotifyBannerTipsBar$updateBannerContent$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ GroupTopBannerNotifyPB$QueryTopBannerInfoRsp $bannerInfo;
            final /* synthetic */ String $bannerToken;
            final /* synthetic */ String $msgId;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$bannerToken = bannerToken;
                this.$bannerInfo = bannerInfo;
                this.$msgId = msgId;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, TroopAIONotifyBannerTipsBar.this, bannerToken, bannerInfo, msgId);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String it) {
                com.tencent.mobileqq.aio.notification.c cVar;
                IAIONotificationUIModel A;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                Intrinsics.checkNotNullParameter(it, "it");
                cVar = TroopAIONotifyBannerTipsBar.this.notificationManager;
                if (cVar != null) {
                    String str = this.$bannerToken;
                    A = TroopAIONotifyBannerTipsBar.this.A(this.$bannerInfo, it, this.$msgId);
                    cVar.j(str, A);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void d0(GroupTopBannerNotifyPB$QueryTopBannerInfoRsp bannerInfo, String msgId) {
        boolean z16;
        String str;
        boolean z17;
        boolean z18;
        TroopAIONotifyBannerModel troopAIONotifyBannerModel;
        boolean z19;
        long j3;
        boolean z26;
        boolean z27;
        GroupExt groupExt;
        boolean z28 = true;
        if (this.notificationManager == null) {
            QLog.i("TroopAIONotifyBannerTipsBar", 1, "[updateBannerUI] notificationManager == null");
            return;
        }
        int i3 = bannerInfo.biz_type.get();
        IRuntimeService runtimeService = TroopUtils.f().getRuntimeService(ITroopInfoService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "getAppInterface().getRun\u2026va, ProcessConstant.MAIN)");
        TroopInfo troopInfo = ((ITroopInfoService) runtimeService).getTroopInfo(G());
        boolean isStudyMode = ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).isStudyMode();
        if (!isStudyMode) {
            if (i3 == 2) {
                if (troopInfo != null && (groupExt = troopInfo.groupExt) != null) {
                    j3 = groupExt.gangUpId;
                } else {
                    j3 = 0;
                }
                if (j3 > 0) {
                    z26 = true;
                } else {
                    z26 = false;
                }
                if (troopInfo != null) {
                    z27 = troopInfo.shouldShowPlayTogetherStatus();
                } else {
                    z27 = false;
                }
                QLog.i("TroopAIONotifyBannerTipsBar", 1, "[updateBannerUI] playTogether. resp:" + bannerInfo.is_disappear.get() + " isGangUp:" + z26 + ", status:" + z27);
                if (!bannerInfo.is_disappear.get() && z27) {
                    z19 = false;
                } else {
                    z19 = true;
                }
            } else {
                QLog.i("TroopAIONotifyBannerTipsBar", 1, "[updateBannerUI] others. resp:" + bannerInfo.is_disappear.get());
                z19 = bannerInfo.is_disappear.get();
            }
            if (!z19) {
                z16 = false;
                str = this.tokenMap.get(Integer.valueOf(i3));
                QLog.i("TroopAIONotifyBannerTipsBar", 1, "[updateBannerUI] bannerInfo: " + f.a(bannerInfo) + ", token: " + str + ", studyMode: " + isStudyMode);
                if (str == null && str.length() != 0) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                if (z17 && !z16) {
                    c0(str, bannerInfo, msgId);
                } else {
                    if (str == null && str.length() != 0) {
                        z18 = false;
                    } else {
                        z18 = true;
                    }
                    if (z18 && z16) {
                        O(i3, str, bannerInfo);
                    } else {
                        if (str != null && str.length() != 0) {
                            z28 = false;
                        }
                        if (z28 && !z16) {
                            a0(i3, bannerInfo, msgId);
                        }
                    }
                }
                troopAIONotifyBannerModel = this.bannerModel;
                if (troopAIONotifyBannerModel == null) {
                    troopAIONotifyBannerModel.j(i3);
                    return;
                }
                return;
            }
        }
        z16 = true;
        str = this.tokenMap.get(Integer.valueOf(i3));
        QLog.i("TroopAIONotifyBannerTipsBar", 1, "[updateBannerUI] bannerInfo: " + f.a(bannerInfo) + ", token: " + str + ", studyMode: " + isStudyMode);
        if (str == null) {
        }
        z17 = true;
        if (z17) {
        }
        if (str == null) {
        }
        z18 = true;
        if (z18) {
        }
        if (str != null) {
            z28 = false;
        }
        if (z28) {
            a0(i3, bannerInfo, msgId);
        }
        troopAIONotifyBannerModel = this.bannerModel;
        if (troopAIONotifyBannerModel == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f() {
        AppInterface appInterface;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Manager manager = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            manager = appInterface.getManager(QQManagerFactory.TROOP_GAME_BANNER_MANAGER);
        }
        if (manager instanceof c) {
        }
    }

    private final void z() {
        MutableLiveData<Pair<GroupTopBannerNotifyPB$QueryTopBannerInfoRsp, String>> e16;
        MutableLiveData<a> g16;
        TroopAIONotifyBannerModel troopAIONotifyBannerModel = this.bannerModel;
        if (troopAIONotifyBannerModel != null && (g16 = troopAIONotifyBannerModel.g()) != null) {
            g16.postValue(null);
        }
        TroopAIONotifyBannerModel troopAIONotifyBannerModel2 = this.bannerModel;
        if (troopAIONotifyBannerModel2 != null && (e16 = troopAIONotifyBannerModel2.e()) != null) {
            e16.postValue(null);
        }
    }

    @Override // com.tencent.mobileqq.aio.notification.d
    @NotNull
    public List<AIONotificationBusiId> h() {
        List<AIONotificationBusiId> mutableListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(AIONotificationBusiId.TROOP_GAME_TEAM, AIONotificationBusiId.TROOP_GAME_JOIN, AIONotificationBusiId.TROOP_META_DREAM_TEAM, AIONotificationBusiId.TROOP_META_DREAM_FARM, AIONotificationBusiId.TROOP_HW_NOTICE, AIONotificationBusiId.TROOP_HW_CLOCK_IN, AIONotificationBusiId.TROOP_GROUP_ALBUM, AIONotificationBusiId.TROOP_ASSIGN_HW_NOTIFY_BAR, AIONotificationBusiId.TROOP_WANGZHE_REPORT, AIONotificationBusiId.TROOP_TEAM_UP);
            return mutableListOf;
        }
        return (List) iPatchRedirector.redirect((short) 2, (Object) this);
    }

    @Override // com.tencent.mobileqq.aio.notification.d
    public void m(@NotNull com.tencent.mobileqq.aio.notification.c notificationManager, int eventType, @NotNull Object... params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, notificationManager, Integer.valueOf(eventType), params);
            return;
        }
        Intrinsics.checkNotNullParameter(notificationManager, "notificationManager");
        Intrinsics.checkNotNullParameter(params, "params");
        if (notificationManager.a().g().r().c().e() != 2) {
            return;
        }
        this.notificationManager = notificationManager;
        d.Companion companion = com.tencent.mobileqq.aio.notification.d.INSTANCE;
        if (eventType == companion.e()) {
            P();
            return;
        }
        if (eventType == companion.b()) {
            R();
        } else if (eventType == companion.c()) {
            b0();
            z();
        }
    }
}
