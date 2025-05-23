package com.tencent.mobileqq.troop.homework.api.impl;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.ark.ark;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.homework.api.IHWTroopUIApi;
import com.tencent.mobileqq.troop.homework.clockin.detail.HWClockInDetailFragment;
import com.tencent.mobileqq.troop.homework.clockin.list.HWClockInListFragment;
import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import com.tencent.mobileqq.troop.homework.historymsg.TroopTeacherMsgRootFragment;
import com.tencent.mobileqq.troop.homework.notice.HWNoticeUtils;
import com.tencent.mobileqq.troop.homework.notice.detail.HWNoticeDetailFragment;
import com.tencent.mobileqq.troop.homework.notice.list.HWNoticeListBaseFragment;
import com.tencent.mobileqq.troop.homework.parser.c;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troop.TroopInfoRepo;
import com.tencent.state.data.SquareJSConst;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u0000 52\u00020\u0001:\u00016B\u0007\u00a2\u0006\u0004\b3\u00104J(\u0010\t\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0019\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJR\u0010\u0017\u001a\u00020\u00162\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u000426\u0010\u0015\u001a2\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00070\u0011H\u0002J\u001a\u0010\u0018\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\u0019\u001a\u00020\u00162\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J&\u0010\u001c\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016JB\u0010\"\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u001a\u0010 \u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001ej\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u001f2\b\u0010!\u001a\u0004\u0018\u00010\u001aH\u0016JA\u0010%\u001a\u00020\u00162\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010#\u001a\u0004\u0018\u00010\u00042\b\u0010$\u001a\u0004\u0018\u00010\fH\u0016\u00a2\u0006\u0004\b%\u0010&J7\u0010%\u001a\u00020\u00162\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010#\u001a\u0004\u0018\u00010\u0004H\u0016\u00a2\u0006\u0004\b%\u0010'J\u001c\u0010%\u001a\u00020\u00162\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010(\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J*\u0010*\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\fH\u0016J\"\u0010+\u001a\u00020\u00162\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004H\u0016J\u001a\u0010,\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J*\u0010.\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\fH\u0016J\u000e\u00101\u001a\b\u0012\u0004\u0012\u0002000/H\u0016J\b\u00102\u001a\u00020\u0016H\u0016\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/api/impl/HWTroopUIApiImpl;", "Lcom/tencent/mobileqq/troop/homework/api/IHWTroopUIApi;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "troopUin", "Lkotlin/Function0;", "", "block", "handleWhenHasRole", "", "chatType", "Lcom/tencent/mobileqq/troop/homework/api/IHWTroopUIApi$DetailPageFrom;", "convertDetailPageFrom", "(Ljava/lang/Integer;)Lcom/tencent/mobileqq/troop/homework/api/IHWTroopUIApi$DetailPageFrom;", "url", "bizKeyId", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "bizId", "action", "", "handleBizActionByUrl", "gotoSetHWRoleTypeInTroop", "isValidActivity", "Landroid/os/Bundle;", "extras", "startPublishHomeWorkFragment", "title", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", SquareJSConst.Params.PARAMS_UIN_LIST, "extData", "openTeacherHistoryMsgPage", ark.APP_SPECIFIC_BIZSRC, "from", "handleHttpUrl", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/tencent/mobileqq/troop/homework/api/IHWTroopUIApi$DetailPageFrom;)Z", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Z", "openNoticeListPage", "noticeId", "openNoticeDetailPage", "isHWUrlAndEquals", "openClockInListPage", "clockInId", "openClockInDetailPage", "Ljava/lang/Class;", "", "getTeacherHistoryMsgParser", "isSwitchOn", "<init>", "()V", "Companion", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class HWTroopUIApiImpl implements IHWTroopUIApi {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    private static final String CONFIG_SET_ID = "105784";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String KEY_CLOCK_IN_ID = "taskid";

    @NotNull
    private static final String KEY_GROUP_ID = "gid";

    @NotNull
    private static final String KEY_NOTICE_ID = "noticeid";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/api/impl/HWTroopUIApiImpl$a;", "", "", "CONFIG_SET_ID", "Ljava/lang/String;", "KEY_CLOCK_IN_ID", "KEY_GROUP_ID", "KEY_NOTICE_ID", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.api.impl.HWTroopUIApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41341);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public HWTroopUIApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final IHWTroopUIApi.DetailPageFrom convertDetailPageFrom(Integer chatType) {
        IHWTroopUIApi.DetailPageFrom detailPageFrom = IHWTroopUIApi.DetailPageFrom.OTHER;
        if (chatType != null && 1 == chatType.intValue()) {
            return IHWTroopUIApi.DetailPageFrom.C2C_ARK;
        }
        if (chatType != null && 2 == chatType.intValue()) {
            return IHWTroopUIApi.DetailPageFrom.GROUP_ARK;
        }
        return detailPageFrom;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void gotoSetHWRoleTypeInTroop(final Activity activity, final String troopUin) {
        if (!isValidActivity(activity)) {
            return;
        }
        QQToastUtil.showQQToastInUiThread(0, "\u8bf7\u5148\u5b8c\u6210\u8eab\u4efd\u4fe1\u606f\u586b\u5199");
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.troop.homework.api.impl.a
            @Override // java.lang.Runnable
            public final void run() {
                HWTroopUIApiImpl.gotoSetHWRoleTypeInTroop$lambda$4(activity, troopUin);
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void gotoSetHWRoleTypeInTroop$lambda$4(Activity activity, String troopUin) {
        Intrinsics.checkNotNullParameter(troopUin, "$troopUin");
        Intrinsics.checkNotNull(activity);
        HWNoticeUtils.h(activity, troopUin);
    }

    private final boolean handleBizActionByUrl(String url, String bizKeyId, Function2<? super String, ? super String, Unit> action) {
        String queryParameter;
        boolean z16;
        boolean z17;
        try {
            Uri parse = Uri.parse(url);
            String queryParameter2 = parse.getQueryParameter("gid");
            if (queryParameter2 == null || (queryParameter = parse.getQueryParameter(bizKeyId)) == null) {
                return false;
            }
            if (queryParameter2.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                if (bizKeyId.length() == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z17 && StringUtils.isNumeric(queryParameter2)) {
                    QLog.i("HW.", 1, "handleBizActionByUrl, troop:" + queryParameter2 + ", bizKeyId:" + queryParameter);
                    action.invoke(queryParameter2, queryParameter);
                    return true;
                }
            }
            QLog.e("HW.", 1, "handleBizActionByUrl url, params err, url:" + url);
            return false;
        } catch (Throwable th5) {
            QLog.e("HW.", 1, "handleBizActionByUrl url:" + url + ", err:" + th5.getMessage());
            return false;
        }
    }

    private final void handleWhenHasRole(final Activity activity, final String troopUin, final Function0<Unit> block) {
        boolean z16;
        TroopInfo troopInfoFromCache = TroopInfoRepo.INSTANCE.getTroopInfoFromCache(troopUin);
        if (troopInfoFromCache != null && troopInfoFromCache.isHomeworkTroop()) {
            z16 = true;
        } else {
            z16 = false;
        }
        Long l3 = null;
        if (!z16) {
            if (troopInfoFromCache != null) {
                l3 = Long.valueOf(troopInfoFromCache.dwGroupClassExt);
            }
            QLog.e("HW.", 1, "handleWhenHasRole, not homework troop, classExt:" + l3);
            QQToastUtil.showQQToastInUiThread(1, "\u8bf7\u4fee\u6539\u7fa4\u5206\u7c7b\u4e3a\u8001\u5e08\u5bb6\u957f\u540e\u4f7f\u7528");
            return;
        }
        HWNoticeUtils.b(troopUin, false, new Function1<Boolean, Unit>(activity, troopUin, block) { // from class: com.tencent.mobileqq.troop.homework.api.impl.HWTroopUIApiImpl$handleWhenHasRole$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ Activity $activity;
            final /* synthetic */ Function0<Unit> $block;
            final /* synthetic */ String $troopUin;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$activity = activity;
                this.$troopUin = troopUin;
                this.$block = block;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, HWTroopUIApiImpl.this, activity, troopUin, block);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z17) {
                boolean isValidActivity;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, z17);
                    return;
                }
                if (!z17) {
                    HWTroopUIApiImpl.this.gotoSetHWRoleTypeInTroop(this.$activity, this.$troopUin);
                    return;
                }
                isValidActivity = HWTroopUIApiImpl.this.isValidActivity(this.$activity);
                if (isValidActivity) {
                    this.$block.invoke();
                }
            }
        }, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isValidActivity(Activity activity) {
        if (activity != null && !activity.isDestroyed() && !activity.isFinishing()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.troop.homework.api.IHWTroopUIApi
    @NotNull
    public Class<Object> getTeacherHistoryMsgParser() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Class) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return c.class;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0078, code lost:
    
        if (r9 == true) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006f  */
    @Override // com.tencent.mobileqq.troop.homework.api.IHWTroopUIApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleHttpUrl(@Nullable final Activity activity, @Nullable String url, @Nullable Integer chatType, @Nullable String bizSrc, @Nullable final IHWTroopUIApi.DetailPageFrom from) {
        boolean z16;
        boolean contains$default;
        boolean contains$default2;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, activity, url, chatType, bizSrc, from)).booleanValue();
        }
        if (!(bizSrc == null || bizSrc.length() == 0) && !Intrinsics.areEqual(bizSrc, IHWTroopUIApi.NOTICE_ARK_ID) && !Intrinsics.areEqual(bizSrc, IHWTroopUIApi.CLOCK_IN_ARK_ID)) {
            return false;
        }
        if (from == null) {
            from = convertDetailPageFrom(chatType);
        }
        if (url != null) {
            contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) "scene=familyGroupNotification", false, 2, (Object) null);
            if (contains$default2) {
                z16 = true;
                if (!z16) {
                    return handleBizActionByUrl(url, KEY_NOTICE_ID, new Function2<String, String, Unit>(activity, from) { // from class: com.tencent.mobileqq.troop.homework.api.impl.HWTroopUIApiImpl$handleHttpUrl$1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ Activity $activity;
                        final /* synthetic */ IHWTroopUIApi.DetailPageFrom $realFrom;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                            this.$activity = activity;
                            this.$realFrom = from;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, HWTroopUIApiImpl.this, activity, from);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(String str, String str2) {
                            invoke2(str, str2);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull String troopUin, @NotNull String bizId) {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this, (Object) troopUin, (Object) bizId);
                                return;
                            }
                            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
                            Intrinsics.checkNotNullParameter(bizId, "bizId");
                            HWTroopUIApiImpl.this.openNoticeDetailPage(this.$activity, troopUin, bizId, this.$realFrom);
                        }
                    });
                }
                if (url != null) {
                    contains$default = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) "scene=familyGroupCheckin", false, 2, (Object) null);
                }
                z17 = false;
                if (z17) {
                    return handleBizActionByUrl(url, "taskid", new Function2<String, String, Unit>(activity, from) { // from class: com.tencent.mobileqq.troop.homework.api.impl.HWTroopUIApiImpl$handleHttpUrl$2
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ Activity $activity;
                        final /* synthetic */ IHWTroopUIApi.DetailPageFrom $realFrom;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                            this.$activity = activity;
                            this.$realFrom = from;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, HWTroopUIApiImpl.this, activity, from);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(String str, String str2) {
                            invoke2(str, str2);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull String troopUin, @NotNull String bizId) {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this, (Object) troopUin, (Object) bizId);
                                return;
                            }
                            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
                            Intrinsics.checkNotNullParameter(bizId, "bizId");
                            HWTroopUIApiImpl.this.openClockInDetailPage(this.$activity, troopUin, bizId, this.$realFrom);
                        }
                    });
                }
                return false;
            }
        }
        z16 = false;
        if (!z16) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0077, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r4, r9) != false) goto L37;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0073 A[Catch: all -> 0x007c, TRY_LEAVE, TryCatch #0 {all -> 0x007c, blocks: (B:16:0x0054, B:20:0x0065, B:23:0x006d, B:25:0x0073), top: B:15:0x0054 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    @Override // com.tencent.mobileqq.troop.homework.api.IHWTroopUIApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean isHWUrlAndEquals(@Nullable String url, @NotNull String troopUin, @NotNull String bizId) {
        boolean z16;
        boolean z17;
        String str;
        boolean contains$default;
        String queryParameter;
        String queryParameter2;
        boolean contains$default2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, this, url, troopUin, bizId)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(bizId, "bizId");
        boolean z18 = true;
        try {
            if (url != null) {
                contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) "scene=familyGroupNotification", false, 2, (Object) null);
                if (contains$default2) {
                    z16 = true;
                    if (!z16) {
                        str = KEY_NOTICE_ID;
                    } else {
                        if (url != null) {
                            contains$default = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) "scene=familyGroupCheckin", false, 2, (Object) null);
                            if (contains$default) {
                                z17 = true;
                                if (z17) {
                                    return false;
                                }
                                str = "taskid";
                            }
                        }
                        z17 = false;
                        if (z17) {
                        }
                    }
                    Uri parse = Uri.parse(url);
                    queryParameter = parse.getQueryParameter("gid");
                    String str2 = "";
                    if (queryParameter == null) {
                        queryParameter = "";
                    }
                    queryParameter2 = parse.getQueryParameter(str);
                    if (queryParameter2 == null) {
                        str2 = queryParameter2;
                    }
                    if (Intrinsics.areEqual(queryParameter, troopUin)) {
                    }
                    z18 = false;
                    return z18;
                }
            }
            Uri parse2 = Uri.parse(url);
            queryParameter = parse2.getQueryParameter("gid");
            String str22 = "";
            if (queryParameter == null) {
            }
            queryParameter2 = parse2.getQueryParameter(str);
            if (queryParameter2 == null) {
            }
            if (Intrinsics.areEqual(queryParameter, troopUin)) {
            }
            z18 = false;
            return z18;
        } catch (Throwable unused) {
            return false;
        }
        z16 = false;
        if (!z16) {
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.api.IHWTroopUIApi
    public boolean isSwitchOn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(CONFIG_SET_ID, false);
    }

    @Override // com.tencent.mobileqq.troop.homework.api.IHWTroopUIApi
    public void openClockInDetailPage(@Nullable Activity activity, @NotNull final String troopUin, @NotNull final String clockInId, @NotNull final IHWTroopUIApi.DetailPageFrom from) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, activity, troopUin, clockInId, from);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(clockInId, "clockInId");
        Intrinsics.checkNotNullParameter(from, "from");
        if (!NetworkUtil.isNetworkAvailable()) {
            QQToastUtil.showQQToast(0, R.string.f171139ci4);
        } else {
            handleWhenHasRole(activity, troopUin, new Function0<Unit>(troopUin, clockInId, from) { // from class: com.tencent.mobileqq.troop.homework.api.impl.HWTroopUIApiImpl$openClockInDetailPage$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ String $clockInId;
                final /* synthetic */ IHWTroopUIApi.DetailPageFrom $from;
                final /* synthetic */ String $troopUin;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$troopUin = troopUin;
                    this.$clockInId = clockInId;
                    this.$from = from;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, troopUin, clockInId, from);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        HWClockInDetailFragment.INSTANCE.a(this.$troopUin, this.$clockInId, this.$from);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.api.IHWTroopUIApi
    public void openClockInListPage(@Nullable Activity activity, @NotNull final String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) activity, (Object) troopUin);
        } else {
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            handleWhenHasRole(activity, troopUin, new Function0<Unit>(troopUin) { // from class: com.tencent.mobileqq.troop.homework.api.impl.HWTroopUIApiImpl$openClockInListPage$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ String $troopUin;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$troopUin = troopUin;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) troopUin);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        HWClockInListFragment.INSTANCE.a(this.$troopUin);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.api.IHWTroopUIApi
    public void openNoticeDetailPage(@Nullable final Activity activity, @NotNull final String troopUin, @NotNull final String noticeId, @NotNull final IHWTroopUIApi.DetailPageFrom from) {
        TroopInfo troopInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, activity, troopUin, noticeId, from);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(noticeId, "noticeId");
        Intrinsics.checkNotNullParameter(from, "from");
        ITroopInfoService iTroopInfoService = (ITroopInfoService) bg.l(ITroopInfoService.class);
        if (iTroopInfoService != null) {
            troopInfo = iTroopInfoService.findTroopInfo(troopUin);
        } else {
            troopInfo = null;
        }
        if (troopInfo == null) {
            QLog.w("HW.Notice.", 1, "openNoticeDetailPage, can not find troop info.");
            QQToastUtil.showQQToastInUiThread(1, "\u6682\u65e0\u67e5\u770b\u8be5\u901a\u77e5\u6743\u9650");
        } else {
            handleWhenHasRole(activity, troopUin, new Function0<Unit>(activity, troopUin, noticeId, from) { // from class: com.tencent.mobileqq.troop.homework.api.impl.HWTroopUIApiImpl$openNoticeDetailPage$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Activity $activity;
                final /* synthetic */ IHWTroopUIApi.DetailPageFrom $from;
                final /* synthetic */ String $noticeId;
                final /* synthetic */ String $troopUin;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$activity = activity;
                    this.$troopUin = troopUin;
                    this.$noticeId = noticeId;
                    this.$from = from;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, activity, troopUin, noticeId, from);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        HWNoticeDetailFragment.INSTANCE.a(this.$activity, this.$troopUin, this.$noticeId, this.$from);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.api.IHWTroopUIApi
    public void openNoticeListPage(@Nullable Activity activity, @NotNull final String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity, (Object) troopUin);
        } else {
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            handleWhenHasRole(activity, troopUin, new Function0<Unit>(troopUin) { // from class: com.tencent.mobileqq.troop.homework.api.impl.HWTroopUIApiImpl$openNoticeListPage$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ String $troopUin;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$troopUin = troopUin;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) troopUin);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        HWNoticeListBaseFragment.INSTANCE.a(this.$troopUin);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.api.IHWTroopUIApi
    public void openTeacherHistoryMsgPage(@Nullable String title, @Nullable String troopUin, @Nullable ArrayList<String> uinList, @Nullable Bundle extData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, title, troopUin, uinList, extData);
        } else {
            TroopTeacherMsgRootFragment.INSTANCE.a(title, troopUin, uinList, extData);
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.api.IHWTroopUIApi
    public void startPublishHomeWorkFragment(@Nullable Activity activity, @Nullable Bundle extras, @Nullable String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, activity, extras, troopUin);
        } else {
            PublishHomeWorkFragment.Gi(activity, extras, troopUin);
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.api.IHWTroopUIApi
    public boolean handleHttpUrl(@Nullable Activity activity, @Nullable String url, @Nullable Integer chatType, @Nullable String bizSrc) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? handleHttpUrl(activity, url, chatType, bizSrc, null) : ((Boolean) iPatchRedirector.redirect((short) 5, this, activity, url, chatType, bizSrc)).booleanValue();
    }

    @Override // com.tencent.mobileqq.troop.homework.api.IHWTroopUIApi
    public boolean handleHttpUrl(@Nullable Activity activity, @Nullable String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? handleHttpUrl(activity, url, null, null, null) : ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity, (Object) url)).booleanValue();
    }
}
