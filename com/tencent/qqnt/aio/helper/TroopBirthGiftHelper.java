package com.tencent.qqnt.aio.helper;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.format.DateUtils;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.aio.api.help.b;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.mobileqq.aio.event.AIOTroopGiftEvent;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mobileqq.vas.VasMMKV;
import com.tencent.mobileqq.vas.api.IPbProtocol;
import com.tencent.mobileqq.vas.api.ITroopGiftApi;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.helper.TroopBirthGiftHelper;
import com.tencent.trpcprotocol.qqva.va_group_gift.service.GroupGiftBirth$QueryBirthMembersReq;
import com.tencent.trpcprotocol.qqva.va_group_gift.service.GroupGiftBirth$QueryBirthMembersRsp;
import com.tencent.trpcprotocol.qqva.va_group_gift.service.GroupGiftBirth$UserBirth;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u00182\u00020\u00012\u00020\u00022\u00020\u0003:\u0002/0B\u0007\u00a2\u0006\u0004\b-\u0010.J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u001c\u0010\n\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\bH\u0002J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0019\u001a\u00020\bH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\u0010\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u0013H\u0016J\b\u0010\u001e\u001a\u00020\u0004H\u0016J\u000e\u0010 \u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u0007R\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u00061"}, d2 = {"Lcom/tencent/qqnt/aio/helper/TroopBirthGiftHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/aio/api/help/b;", "Lcom/tencent/mvi/base/route/g;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Function1;", "", "", "callback", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, ReportConstant.COSTREPORT_PREFIX, "", "birthListBytes", "j", "", InnerAudioPlugin.AUDIO_PROPERTY_CURRENTTIME, DomainData.DOMAIN_NAME, "", "getId", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", tl.h.F, "i", "", "interestedIn", "state", "onMoveToState", "getTag", "needForce", "r", "Landroid/os/Handler;", "d", "Landroid/os/Handler;", "mUiHandler", "Lcom/tencent/aio/api/runtime/a;", "e", "Lcom/tencent/aio/api/runtime/a;", "mAioContext", "Lcom/tencent/mvi/base/route/a;", "f", "Lcom/tencent/mvi/base/route/a;", "action1", "<init>", "()V", "Companion", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes23.dex */
public final class TroopBirthGiftHelper implements com.tencent.aio.main.businesshelper.h, com.tencent.aio.api.help.b, com.tencent.mvi.base.route.g {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler mUiHandler;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.aio.api.runtime.a mAioContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mvi.base.route.a action1;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u0017\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b4\u00105J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J$\u0010\f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00022\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\nH\u0002J$\u0010\r\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00022\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\nH\u0002J,\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\nH\u0002J\u0016\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00122\u0006\u0010\u0007\u001a\u00020\u0002J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016JD\u0010!\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001d2\u0014\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001fJ\u0010\u0010#\u001a\u00020\u00022\b\u0010\"\u001a\u0004\u0018\u00010\u0002J\"\u0010$\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00022\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\nR\u0014\u0010%\u001a\u00020\u001d8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020\u001d8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b'\u0010&R\u0014\u0010(\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b*\u0010)R\u0014\u0010+\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b+\u0010)R\u0014\u0010,\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b,\u0010)R\u0014\u0010-\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b-\u0010)R\u0014\u0010.\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b.\u0010)R\u0014\u0010/\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b/\u0010)R\u0014\u00100\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b0\u0010)R\u0014\u00101\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b1\u0010)R\u0014\u00102\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b2\u0010)R\u0014\u00103\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b3\u0010)\u00a8\u00066"}, d2 = {"Lcom/tencent/qqnt/aio/helper/TroopBirthGiftHelper$Companion;", "", "", "f", "friendUin", "", "k", "peerUin", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lkotlin/Function1;", "callback", "j", DomainData.DOMAIN_NAME, "", "lastShowTime", "now", "l", "", "Lcom/tencent/trpcprotocol/qqva/va_group_gift/service/GroupGiftBirth$UserBirth;", "o", "time", "Landroid/content/Context;", "context", "g", "pageId", "itemId", "subItemId", "itemType", "", "actionId", "", "busiInfoMap", "p", "birthdayDate", tl.h.F, "i", "REPORT_ACTION_CLICK", "I", "REPORT_ACTION_EXPOSE", "REPORT_ITEM_BIRTH_BANNER", "Ljava/lang/String;", "REPORT_ITEM_ENTRANCE", "REPORT_ITEM_PICK_AVATAR", "REPORT_ITEM_PICK_SEND", "REPORT_ITEM_TOGETHER_BANNER", "REPORT_PAGE_ARK", "REPORT_PAGE_DIALOG", "REPORT_PAGE_ENTRANCE", "REPORT_PAGE_PICK", "SSO_QUERY_BIRTH_MEMBERS", "TAG", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
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

        /* JADX INFO: Access modifiers changed from: private */
        public final String f() {
            String str;
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                str = peekAppRuntime.getCurrentUin();
            } else {
                str = null;
            }
            if (str == null) {
                return "";
            }
            return str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void j(String peerUin, Function1<? super Boolean, Unit> callback) {
            l(VasMMKV.INSTANCE.getTroopBirthGift(f()).decodeLong("lastClickTime_" + peerUin, 0L), NetConnInfoCenter.getServerTimeMillis(), callback);
        }

        private final boolean k(String friendUin) {
            long decodeLong = VasMMKV.INSTANCE.getTroopBirthGift(f()).decodeLong("validTime_" + friendUin, 0L);
            long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
            QLog.i("TroopBirthGiftHelper", 1, "cache validated, validTime:" + decodeLong + " now:" + serverTimeMillis);
            if (serverTimeMillis > decodeLong) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void l(final long lastShowTime, final long now, final Function1<? super Boolean, Unit> callback) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.helper.do
                @Override // java.lang.Runnable
                public final void run() {
                    TroopBirthGiftHelper.Companion.m(lastShowTime, now, callback);
                }
            }, 16, null, false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void m(long j3, long j16, Function1 callback) {
            Intrinsics.checkNotNullParameter(callback, "$callback");
            Date date = new Date(j3);
            Date date2 = new Date(j16);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtil.DATE_FORMAT_8);
            callback.invoke(Boolean.valueOf(Intrinsics.areEqual(simpleDateFormat.format(date), simpleDateFormat.format(date2))));
        }

        private final void n(String peerUin, Function1<? super Boolean, Unit> callback) {
            l(VasMMKV.INSTANCE.getTroopBirthGift(f()).decodeLong("lastShowTime_" + peerUin, 0L), NetConnInfoCenter.getServerTimeMillis(), callback);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void q(String peerUin) {
            long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
            VasMMKV.INSTANCE.getTroopBirthGift(f()).encodeLong("lastClickTime_" + peerUin, serverTimeMillis);
        }

        @NotNull
        public final String g(long time, @Nullable Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, this, Long.valueOf(time), context);
            }
            if (com.tencent.mobileqq.activity.activateFriend.p.c(time)) {
                return "\u4eca\u5929";
            }
            if (com.tencent.mobileqq.activity.activateFriend.p.d(time)) {
                return "\u660e\u5929";
            }
            new Date().setTime(time);
            String formatDateTime = DateUtils.formatDateTime(context, time, 8);
            Intrinsics.checkNotNullExpressionValue(formatDateTime, "{\n                    va\u2026O_YEAR)\n                }");
            return formatDateTime;
        }

        @NotNull
        public final String h(@Nullable String birthdayDate) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) birthdayDate);
            }
            if (Intrinsics.areEqual(birthdayDate, "\u4eca\u5929")) {
                return "1";
            }
            if (Intrinsics.areEqual(birthdayDate, "\u660e\u5929")) {
                return "2";
            }
            return "4";
        }

        public final void i(@NotNull final String peerUin, @NotNull final Function1<? super Boolean, Unit> callback) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) peerUin, (Object) callback);
                return;
            }
            Intrinsics.checkNotNullParameter(peerUin, "peerUin");
            Intrinsics.checkNotNullParameter(callback, "callback");
            n(peerUin, new Function1<Boolean, Unit>(callback, peerUin) { // from class: com.tencent.qqnt.aio.helper.TroopBirthGiftHelper$Companion$isBirthClick$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Function1<Boolean, Unit> $callback;
                final /* synthetic */ String $peerUin;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.$callback = callback;
                    this.$peerUin = peerUin;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) callback, (Object) peerUin);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, z16);
                    } else {
                        if (!z16) {
                            this.$callback.invoke(Boolean.FALSE);
                            return;
                        }
                        TroopBirthGiftHelper.Companion companion = TroopBirthGiftHelper.INSTANCE;
                        String str = this.$peerUin;
                        companion.j(str, new Function1<Boolean, Unit>(str, this.$callback) { // from class: com.tencent.qqnt.aio.helper.TroopBirthGiftHelper$Companion$isBirthClick$1.1
                            static IPatchRedirector $redirector_;
                            final /* synthetic */ Function1<Boolean, Unit> $callback;
                            final /* synthetic */ String $peerUin;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                                this.$peerUin = str;
                                this.$callback = r5;
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) str, (Object) r5);
                                }
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                invoke(bool.booleanValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(boolean z17) {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this, z17);
                                    return;
                                }
                                if (!z17) {
                                    TroopBirthGiftHelper.INSTANCE.q(this.$peerUin);
                                }
                                this.$callback.invoke(Boolean.valueOf(!z17));
                            }
                        });
                    }
                }
            });
        }

        @NotNull
        public final List<GroupGiftBirth$UserBirth> o(@NotNull String peerUin) {
            List<GroupGiftBirth$UserBirth> emptyList;
            List<GroupGiftBirth$UserBirth> emptyList2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) peerUin);
            }
            Intrinsics.checkNotNullParameter(peerUin, "peerUin");
            if (k(peerUin)) {
                VasMMKV.Companion companion = VasMMKV.INSTANCE;
                companion.getTroopBirthGift(peerUin).removeKey("validTime_" + peerUin);
                companion.getTroopBirthGift(f()).removeKey("birth_list_" + peerUin);
                emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                return emptyList2;
            }
            byte[] decodeBytes = VasMMKV.INSTANCE.getTroopBirthGift(f()).decodeBytes("birth_list_" + peerUin, null);
            if (decodeBytes == null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                return emptyList;
            }
            GroupGiftBirth$QueryBirthMembersRsp groupGiftBirth$QueryBirthMembersRsp = new GroupGiftBirth$QueryBirthMembersRsp();
            try {
                groupGiftBirth$QueryBirthMembersRsp.mergeFrom(decodeBytes);
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
            }
            List<GroupGiftBirth$UserBirth> list = groupGiftBirth$QueryBirthMembersRsp.birth_list.get();
            Intrinsics.checkNotNullExpressionValue(list, "rspData.birth_list.get()");
            return list;
        }

        public final void p(@NotNull String pageId, @NotNull String itemId, @NotNull String subItemId, @NotNull String itemType, int actionId, @Nullable Map<String, String> busiInfoMap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, pageId, itemId, subItemId, itemType, Integer.valueOf(actionId), busiInfoMap);
                return;
            }
            Intrinsics.checkNotNullParameter(pageId, "pageId");
            Intrinsics.checkNotNullParameter(itemId, "itemId");
            Intrinsics.checkNotNullParameter(subItemId, "subItemId");
            Intrinsics.checkNotNullParameter(itemType, "itemType");
            ((ITroopGiftApi) QRoute.api(ITroopGiftApi.class)).reportTroopBirthGift(pageId, itemId, subItemId, itemType, actionId, busiInfoMap);
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
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0010\u0010\u0011J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u001c\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/aio/helper/TroopBirthGiftHelper$a;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "", "type", "", "isSuccess", "", "data", "", "onUpdate", "Lmqq/util/WeakReference;", "Lcom/tencent/qqnt/aio/helper/TroopBirthGiftHelper;", "d", "Lmqq/util/WeakReference;", "weakView", "helper", "<init>", "(Lcom/tencent/qqnt/aio/helper/TroopBirthGiftHelper;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class a implements BusinessObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<TroopBirthGiftHelper> weakView;

        public a(@NotNull TroopBirthGiftHelper helper) {
            Intrinsics.checkNotNullParameter(helper, "helper");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) helper);
            } else {
                this.weakView = new WeakReference<>(helper);
            }
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int type, boolean isSuccess, @Nullable Object data) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(type), Boolean.valueOf(isSuccess), data);
                return;
            }
            TroopBirthGiftHelper troopBirthGiftHelper = this.weakView.get();
            if (troopBirthGiftHelper == null) {
                return;
            }
            if (isSuccess) {
                GroupGiftBirth$QueryBirthMembersRsp groupGiftBirth$QueryBirthMembersRsp = new GroupGiftBirth$QueryBirthMembersRsp();
                try {
                    Intrinsics.checkNotNull(data, "null cannot be cast to non-null type kotlin.ByteArray");
                    groupGiftBirth$QueryBirthMembersRsp.mergeFrom((byte[]) data);
                    if (groupGiftBirth$QueryBirthMembersRsp.code.get() == 0) {
                        troopBirthGiftHelper.j((byte[]) data);
                        troopBirthGiftHelper.s();
                        return;
                    }
                    return;
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.e("TroopBirthGiftHelper", 1, "onUpdate mergeFrom bytes failed:" + e16);
                    return;
                }
            }
            QLog.e("TroopBirthGiftHelper", 1, "onUpdate req failed");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/aio/helper/TroopBirthGiftHelper$b", "Lcom/tencent/mvi/base/route/a;", "", "sticky", "Lcom/tencent/mvi/base/route/MsgIntent;", "msgIntent", "", "call", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopBirthGiftHelper.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent msgIntent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) msgIntent);
                return;
            }
            Intrinsics.checkNotNullParameter(msgIntent, "msgIntent");
            if (msgIntent instanceof AIOTroopGiftEvent.RequestBirthListEvent) {
                TroopBirthGiftHelper.this.r(((AIOTroopGiftEvent.RequestBirthListEvent) msgIntent).a());
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return false;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63597);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopBirthGiftHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mUiHandler = new Handler(Looper.getMainLooper());
            this.action1 = new b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(byte[] birthListBytes) {
        VasMMKV.Companion companion = VasMMKV.INSTANCE;
        Companion companion2 = INSTANCE;
        companion.getTroopBirthGift(companion2.f()).encodeBytes("birth_list_" + m(), birthListBytes);
        long n3 = n(NetConnInfoCenter.getServerTimeMillis());
        companion.getTroopBirthGift(companion2.f()).encodeLong("validTime_" + m(), n3);
        companion.getTroopBirthGift(companion2.f()).encodeBytes("birth_list_" + m(), birthListBytes);
    }

    private final void k(final Function1<? super Boolean, Unit> callback) {
        String m3 = m();
        VasMMKV.Companion companion = VasMMKV.INSTANCE;
        Companion companion2 = INSTANCE;
        companion2.l(companion.getTroopBirthGift(companion2.f()).decodeLong("lastReqTime_" + m3, 0L), NetConnInfoCenter.getServerTimeMillis(), new Function1<Boolean, Unit>(callback) { // from class: com.tencent.qqnt.aio.helper.TroopBirthGiftHelper$enableRequestBirthGift$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Function1<Boolean, Unit> $callback;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
                this.$callback = callback;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) callback);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    this.$callback.invoke(Boolean.valueOf(!z16));
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this, z16);
                }
            }
        });
    }

    private final String m() {
        com.tencent.aio.api.runtime.a aVar = this.mAioContext;
        Intrinsics.checkNotNull(aVar);
        return aVar.g().r().c().j();
    }

    private final long n(long currentTime) {
        Date date = new Date(currentTime);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(5, 1);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        long timeInMillis = calendar.getTimeInMillis();
        QLog.i("TroopBirthGiftHelper", 1, "validTime is:" + timeInMillis);
        return timeInMillis;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(com.tencent.aio.main.businesshelper.b param, TroopBirthGiftHelper this$0) {
        Intrinsics.checkNotNullParameter(param, "$param");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        param.a().e().f(this$0, this$0.action1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(TroopBirthGiftHelper this$0) {
        com.tencent.mvi.base.route.j e16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.aio.api.runtime.a aVar = this$0.mAioContext;
        if (aVar != null && (e16 = aVar.e()) != null) {
            e16.i(this$0, this$0.action1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q() {
        String m3 = m();
        GroupGiftBirth$QueryBirthMembersReq groupGiftBirth$QueryBirthMembersReq = new GroupGiftBirth$QueryBirthMembersReq();
        try {
            groupGiftBirth$QueryBirthMembersReq.group_id.set(Long.parseLong(m3));
            IPbProtocol pbRequest = VasUtil.getService().getPbRequest();
            byte[] byteArray = groupGiftBirth$QueryBirthMembersReq.toByteArray();
            Intrinsics.checkNotNullExpressionValue(byteArray, "req.toByteArray()");
            Charset forName = Charset.forName("ISO8859_1");
            Intrinsics.checkNotNullExpressionValue(forName, "forName(charsetName)");
            pbRequest.request("trpc.qqva.group_gift_birth.Service.SsoQueryBirthMembers", new String(byteArray, forName), new a(this));
        } catch (UnsupportedEncodingException e16) {
            QLog.e("TroopBirthGiftHelper", 1, "Encoding error: " + e16);
        } catch (NumberFormatException e17) {
            QLog.e("TroopBirthGiftHelper", 1, "parse troop uin error:" + e17);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s() {
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        VasMMKV.INSTANCE.getTroopBirthGift(INSTANCE.f()).encodeLong("lastReqTime_" + m(), serverTimeMillis);
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return cw.f350691z;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Set) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.event.AIOTroopGiftEvent.RequestBirthListEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOTroopGiftEvent.UpdateBirthGiftEntranceEvent");
        return hashSet;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (Set) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return new HashSet();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return "TroopBirthGiftHelper";
    }

    @Override // com.tencent.aio.api.help.b
    public void h(@NotNull final com.tencent.aio.main.businesshelper.b param) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) param);
            return;
        }
        Intrinsics.checkNotNullParameter(param, "param");
        b.a.a(this, param);
        this.mUiHandler.post(new Runnable() { // from class: com.tencent.qqnt.aio.helper.dm
            @Override // java.lang.Runnable
            public final void run() {
                TroopBirthGiftHelper.o(com.tencent.aio.main.businesshelper.b.this, this);
            }
        });
    }

    @Override // com.tencent.aio.api.help.b
    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            b.a.b(this);
            this.mUiHandler.post(new Runnable() { // from class: com.tencent.qqnt.aio.helper.dn
                @Override // java.lang.Runnable
                public final void run() {
                    TroopBirthGiftHelper.p(TroopBirthGiftHelper.this);
                }
            });
        }
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (int[]) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return new int[]{0};
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) param);
            return;
        }
        Intrinsics.checkNotNullParameter(param, "param");
        QLog.i("TroopBirthGiftHelper", 4, "TroopBirthGiftHelper init");
        this.mAioContext = param.a();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            h.a.b(this);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, state);
        } else if (state == 0) {
            k(new Function1<Boolean, Unit>() { // from class: com.tencent.qqnt.aio.helper.TroopBirthGiftHelper$onMoveToState$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopBirthGiftHelper.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, z16);
                    } else if (z16) {
                        TroopBirthGiftHelper.this.r(false);
                    }
                }
            });
        }
    }

    public final void r(boolean needForce) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, needForce);
        } else if (needForce) {
            q();
        } else {
            k(new Function1<Boolean, Unit>() { // from class: com.tencent.qqnt.aio.helper.TroopBirthGiftHelper$sendReqForBirthGiftList$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopBirthGiftHelper.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, z16);
                    } else if (z16) {
                        TroopBirthGiftHelper.this.q();
                    }
                }
            });
        }
    }
}
