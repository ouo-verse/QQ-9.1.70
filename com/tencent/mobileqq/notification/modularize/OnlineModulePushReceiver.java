package com.tencent.mobileqq.notification.modularize;

import Wallet.a;
import android.app.Notification;
import android.content.Intent;
import android.text.TextUtils;
import com.heytap.databaseengine.utils.DateUtil;
import com.heytap.msp.push.HeytapPushManager;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.delegate.impl.RFWReporter;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.mobileqq.notification.modularize.TianShuPushConfigParser;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.reminder.api.IQQReminderMsgService;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IReminderNotificationApi;
import com.tencent.mobileqq.tianshu.bean.TianshuLockScreenBean;
import com.tencent.mobileqq.tianshu.parser.PushLimitTimeConfigParser;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.dex.sdkupdate.TVKUpdateInfo;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.vip.ad.event.TianshuReceivePushEvent;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import mqq.app.api.ProcessConstant;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0x135.ModulePushPb$Button;
import tencent.im.s2c.msgtype0x210.submsgtype0x135.ModulePushPb$ForcePushInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x135.ModulePushPb$MsgBody;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 &2\u00020\u0001:\u0001!B\u000f\u0012\u0006\u0010#\u001a\u00020 \u00a2\u0006\u0004\b$\u0010%J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\fH\u0002J \u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\fH\u0002J\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0018\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0016\u001a\u00020\u0006H\u0002J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\u001a\u001a\u00020\u00062\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\bJ\u0016\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001dR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/notification/modularize/OnlineModulePushReceiver;", "", "Lcom/tencent/mobileqq/notification/modularize/f;", "pushComponent", "Lcom/tencent/mobileqq/pb/ByteStringMicro;", "extData", "", "l", "", "Ltencent/im/s2c/msgtype0x210/submsgtype0x135/ModulePushPb$Button;", "buttons", "k", "", "g", DomainData.DOMAIN_NAME, "isInBackground", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/notification/modularize/BaseJumpScheme;", "jumpScheme", "r", "o", ReportConstant.COSTREPORT_PREFIX, "j", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "i", "pushList", tl.h.F, "Ltencent/im/s2c/msgtype0x210/submsgtype0x135/ModulePushPb$MsgBody;", "msgBody", "", "from", "f", "Lcom/tencent/mobileqq/app/QQAppInterface;", "a", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "<init>", "(Lcom/tencent/mobileqq/app/QQAppInterface;)V", "b", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class OnlineModulePushReceiver {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final MMKVOptionEntity f254243c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static String f254244d;

    /* renamed from: e, reason: collision with root package name */
    private static int f254245e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private static final TianShuPushConfigParser.b f254246f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    private static final PushLimitTimeConfigParser.b f254247g;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QQAppInterface app;

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b3\u00104J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H\u0002J\u0006\u0010\u0010\u001a\u00020\u0004J\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004J\u001a\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007J\u000e\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0004J\u000e\u0010\u0017\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u0018\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nR\u0017\u0010\u001a\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\"\u0010\u001e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b$\u0010\u001fR\u0014\u0010%\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b%\u0010\u001fR\u0014\u0010&\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b&\u0010\u001fR\u0014\u0010'\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b'\u0010\u001fR\u0014\u0010(\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b(\u0010\u001fR\u0014\u0010)\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b)\u0010\u001fR\u0014\u0010*\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b*\u0010\u001fR\u0016\u0010,\u001a\u0004\u0018\u00010+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010/\u001a\u0004\u0018\u00010.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00101\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/notification/modularize/OnlineModulePushReceiver$a;", "", "", "f", "", tl.h.F, "", "time", "", "l", "Lcom/tencent/mobileqq/notification/modularize/f;", "pushComponent", DomainData.DOMAIN_NAME, "startHour", "endHour", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", "notifyId", "g", "pushKey", "", "p", "d", "c", "k", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "mmkvEntity", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "e", "()Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "uin", "Ljava/lang/String;", "i", "()Ljava/lang/String;", "setUin", "(Ljava/lang/String;)V", "CONFIG_ID", "DEFAULT_UIN", "KEY_PUSH_ID", "KEY_PUSH_REFRESH_TIME", "KEY_TOTAL", "LIMIT_TIME_CONFIG_ID", "SEPARATOR", "Lcom/tencent/mobileqq/tianshu/parser/PushLimitTimeConfigParser$b;", "limitConfig", "Lcom/tencent/mobileqq/tianshu/parser/PushLimitTimeConfigParser$b;", "Lcom/tencent/mobileqq/notification/modularize/TianShuPushConfigParser$b;", "pushConfig", "Lcom/tencent/mobileqq/notification/modularize/TianShuPushConfigParser$b;", MessageForQCircleFeed.MSG_QCIRCLE_FEED_KEY_PUSH_COUNT, "I", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.notification.modularize.OnlineModulePushReceiver$a, reason: from kotlin metadata */
    /* loaded from: classes8.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
                return;
            }
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) defaultConstructorMarker);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int f() {
            boolean contains$default;
            String h16 = h();
            String decodeString = e().decodeString(i() + "_push_refresh_time", "");
            QLog.d("OnlineModulePushReceiver", 1, "getPushCount: ", Integer.valueOf(e().decodeInt(i() + "_push_total", 0)));
            if (!TextUtils.equals(h16, decodeString)) {
                e().encodeInt(i() + "_push_total", 0);
                e().encodeString(i() + "_push_refresh_time", h16);
                String[] keys = e().allKeyArr();
                Intrinsics.checkNotNullExpressionValue(keys, "keys");
                for (String it : keys) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    contains$default = StringsKt__StringsKt.contains$default((CharSequence) it, (CharSequence) "push_id", false, 2, (Object) null);
                    if (contains$default) {
                        OnlineModulePushReceiver.INSTANCE.e().removeKey(it);
                    }
                }
                return 0;
            }
            return e().decodeInt(i() + "_push_total", 0);
        }

        private final String h() {
            String format = new SimpleDateFormat(DateUtil.DATE_FORMAT_8, Locale.getDefault()).format(new Date(System.currentTimeMillis()));
            Intrinsics.checkNotNullExpressionValue(format, "dateFormatter.format(date)");
            return format;
        }

        private final boolean l(long time) {
            return Intrinsics.areEqual(h(), new SimpleDateFormat(DateUtil.DATE_FORMAT_8, Locale.getDefault()).format(new Date(time)));
        }

        private final boolean m(int startHour, int endHour) {
            int i3 = Calendar.getInstance().get(11);
            if (startHour <= endHour) {
                if (startHour <= i3 && i3 < endHour) {
                    return true;
                }
            } else if (i3 >= startHour || i3 < endHour) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String n(f pushComponent) {
            String g16 = g(String.valueOf(pushComponent.notifyId));
            QLog.d("OnlineModulePushReceiver", 1, "jointPushKey pushKey: ", g16);
            return g16;
        }

        public static /* synthetic */ void q(Companion companion, String str, long j3, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                j3 = System.currentTimeMillis();
            }
            companion.p(str, j3);
        }

        public final boolean c(@NotNull f pushComponent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) pushComponent)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(pushComponent, "pushComponent");
            return d(n(pushComponent));
        }

        public final boolean d(@NotNull String pushKey) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) pushKey)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(pushKey, "pushKey");
            long decodeLong = e().decodeLong(pushKey, 0L);
            boolean l3 = l(decodeLong);
            QLog.d("OnlineModulePushReceiver", 1, "checkRules lastPushTime: " + decodeLong + " , isSameDayByToday: " + l3);
            if (decodeLong == 0 || !l3) {
                return true;
            }
            return false;
        }

        @NotNull
        public final MMKVOptionEntity e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return OnlineModulePushReceiver.f254243c;
            }
            return (MMKVOptionEntity) iPatchRedirector.redirect((short) 2, (Object) this);
        }

        @NotNull
        public final String g(@NotNull String notifyId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) notifyId);
            }
            Intrinsics.checkNotNullParameter(notifyId, "notifyId");
            return i() + "_push_id_" + notifyId;
        }

        @NotNull
        public final String i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return OnlineModulePushReceiver.f254244d;
            }
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }

        @NotNull
        public final String j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            SimpleAccount firstSimpleAccount = MobileQQ.sMobileQQ.getFirstSimpleAccount();
            if (firstSimpleAccount != null) {
                String uin = firstSimpleAccount.getUin();
                Intrinsics.checkNotNullExpressionValue(uin, "simpleAccount.uin");
                return uin;
            }
            return TVKUpdateInfo.APP_ID;
        }

        public final boolean k(@NotNull f pushComponent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) pushComponent)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(pushComponent, "pushComponent");
            if (Intrinsics.areEqual(pushComponent.from, "2") && OnlineModulePushReceiver.f254247g != null) {
                return m(OnlineModulePushReceiver.f254247g.a(), OnlineModulePushReceiver.f254247g.b());
            }
            return false;
        }

        @JvmOverloads
        public final void o(@NotNull String pushKey) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this, (Object) pushKey);
            } else {
                Intrinsics.checkNotNullParameter(pushKey, "pushKey");
                q(this, pushKey, 0L, 2, null);
            }
        }

        @JvmOverloads
        public final void p(@NotNull String pushKey, long time) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, pushKey, Long.valueOf(time));
                return;
            }
            Intrinsics.checkNotNullParameter(pushKey, "pushKey");
            QLog.i("OnlineModulePushReceiver", 1, "saveTianShuPush pushKey:" + pushKey + ", time:" + time);
            e().encodeLong(pushKey, time);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/notification/modularize/OnlineModulePushReceiver$b", "LWallet/a$a;", "", NodeProps.ON_CLICK, "onClose", "onFlingUp", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes8.dex */
    public static final class b implements a.InterfaceC0000a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f254249a;

        b(f fVar) {
            this.f254249a = fVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) fVar);
            }
        }

        @Override // Wallet.a.InterfaceC0000a
        public void onClick() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        @Override // Wallet.a.InterfaceC0000a
        public void onClose() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            i iVar = i.f254311a;
            String accountId = RFWApplication.getAccountId();
            Intrinsics.checkNotNullExpressionValue(accountId, "getAccountId()");
            String valueOf = String.valueOf(this.f254249a.com.tencent.qphone.base.BaseConstants.EXTRA_PUSHID java.lang.String);
            f fVar = this.f254249a;
            iVar.d(accountId, 122, valueOf, fVar.triggerInfo, fVar.from);
        }

        @Override // Wallet.a.InterfaceC0000a
        public void onFlingUp() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            i iVar = i.f254311a;
            String accountId = RFWApplication.getAccountId();
            Intrinsics.checkNotNullExpressionValue(accountId, "getAccountId()");
            String valueOf = String.valueOf(this.f254249a.com.tencent.qphone.base.BaseConstants.EXTRA_PUSHID java.lang.String);
            f fVar = this.f254249a;
            iVar.d(accountId, 122, valueOf, fVar.triggerInfo, fVar.from);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59229);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        Companion companion = new Companion(null);
        INSTANCE = companion;
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_TIAN_SHU);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_TIAN_SHU)");
        f254243c = from;
        f254244d = companion.j();
        f254245e = companion.f();
        f254246f = (TianShuPushConfigParser.b) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("tianshu_push");
        f254247g = (PushLimitTimeConfigParser.b) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("tianshu_offline_push_block_time");
    }

    public OnlineModulePushReceiver(@NotNull QQAppInterface app) {
        Intrinsics.checkNotNullParameter(app, "app");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) app);
        } else {
            this.app = app;
        }
    }

    private final boolean g(f pushComponent) {
        if (!pushComponent.c()) {
            QLog.d("OnlineModulePushReceiver", 1, "not need limit id:" + pushComponent.notifyId + ", type:" + pushComponent.com.tencent.mobileqq.activity.QQBrowserActivity.KEY_MSG_TYPE java.lang.String);
            return false;
        }
        int i3 = f254245e;
        TianShuPushConfigParser.b bVar = f254246f;
        Intrinsics.checkNotNull(bVar);
        if (i3 < bVar.a()) {
            return false;
        }
        return true;
    }

    private final void j() {
        IQQReminderMsgService iQQReminderMsgService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (iQQReminderMsgService = (IQQReminderMsgService) peekAppRuntime.getRuntimeService(IQQReminderMsgService.class, ProcessConstant.MULTI)) != null) {
            iQQReminderMsgService.onSystemNotificationShow();
        }
    }

    private final void k(f pushComponent, List<ModulePushPb$Button> buttons) {
        if (buttons.isEmpty()) {
            return;
        }
        for (ModulePushPb$Button modulePushPb$Button : buttons) {
            List<a> list = pushComponent.buttons;
            String str = modulePushPb$Button.desc.get();
            Intrinsics.checkNotNullExpressionValue(str, "button.desc.get()");
            String str2 = modulePushPb$Button.str_url.get();
            Intrinsics.checkNotNullExpressionValue(str2, "button.str_url.get()");
            list.add(new a(str, str2, modulePushPb$Button.uint32_type.get()));
        }
    }

    private final void l(f pushComponent, ByteStringMicro extData) {
        try {
            byte[] byteArray = extData.toByteArray();
            Intrinsics.checkNotNullExpressionValue(byteArray, "extData.toByteArray()");
            Charset charset = Charsets.UTF_8;
            JSONObject jSONObject = new JSONObject(new String(byteArray, charset));
            String tianShuExt = jSONObject.optString("tianshu_ext", "");
            String triggerInfo = jSONObject.optString("trigger_info", "");
            String senderIcon = jSONObject.optString("sender_icon", "");
            Intrinsics.checkNotNullExpressionValue(tianShuExt, "tianShuExt");
            byte[] bytes = tianShuExt.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            pushComponent.bytesExtData = bytes;
            Intrinsics.checkNotNullExpressionValue(triggerInfo, "triggerInfo");
            pushComponent.triggerInfo = triggerInfo;
            Intrinsics.checkNotNullExpressionValue(senderIcon, "senderIcon");
            pushComponent.senderIcon = senderIcon;
        } catch (Exception e16) {
            QLog.e("OnlineModulePushReceiver", 1, e16.getMessage());
        }
    }

    private final void m(f pushComponent) {
        QQNotificationManager.getInstance().cancel("OnlineModulePushReceiver", pushComponent.notifyId);
        String n3 = INSTANCE.n(pushComponent);
        MMKVOptionEntity mMKVOptionEntity = f254243c;
        if (mMKVOptionEntity.containsKey(n3)) {
            mMKVOptionEntity.removeKey(n3);
            if (pushComponent.c()) {
                f254245e--;
                mMKVOptionEntity.encodeInt(f254244d + "_push_total", f254245e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(f pushComponent) {
        if (g(pushComponent)) {
            QLog.w("OnlineModulePushReceiver", 1, "Limit Exceeded \uff01sendPush pushCount: " + f254245e);
            i iVar = i.f254311a;
            String currentUin = this.app.getCurrentUin();
            Intrinsics.checkNotNullExpressionValue(currentUin, "app.currentUin");
            iVar.d(currentUin, 214, String.valueOf(pushComponent.com.tencent.qphone.base.BaseConstants.EXTRA_PUSHID java.lang.String), pushComponent.triggerInfo, pushComponent.from);
            return;
        }
        boolean d16 = e.d(this.app);
        boolean e16 = pushComponent.e();
        boolean f16 = pushComponent.f();
        if (!pushComponent.d() && e.f(this.app)) {
            QLog.w("OnlineModulePushReceiver", 1, "sendPush: called. push need shield");
            i iVar2 = i.f254311a;
            String currentUin2 = this.app.getCurrentUin();
            Intrinsics.checkNotNullExpressionValue(currentUin2, "app.currentUin");
            iVar2.d(currentUin2, 212, String.valueOf(pushComponent.com.tencent.qphone.base.BaseConstants.EXTRA_PUSHID java.lang.String), pushComponent.triggerInfo, pushComponent.from);
            return;
        }
        if (e16 && f16) {
            q(pushComponent, d16);
            return;
        }
        if (e16 && d16) {
            q(pushComponent, d16);
            return;
        }
        if (f16 && !d16) {
            q(pushComponent, d16);
            return;
        }
        i iVar3 = i.f254311a;
        String currentUin3 = this.app.getCurrentUin();
        Intrinsics.checkNotNullExpressionValue(currentUin3, "app.currentUin");
        iVar3.d(currentUin3, 219, String.valueOf(pushComponent.com.tencent.qphone.base.BaseConstants.EXTRA_PUSHID java.lang.String), pushComponent.triggerInfo, pushComponent.from);
        QLog.e("OnlineModulePushReceiver", 1, "sendPush: called. , no need send push. isBackground: " + d16);
    }

    private final void o(f pushComponent, BaseJumpScheme jumpScheme) {
        QLog.d("OnlineModulePushReceiver", 1, "showInSitePush");
        Intent g16 = jumpScheme.g(pushComponent);
        final Wallet.a aVar = new Wallet.a();
        aVar.f25142a = "";
        aVar.f25143b = pushComponent.title;
        aVar.f25154m = 2;
        aVar.f25144c = pushComponent.contentText;
        aVar.f25146e = pushComponent.iconUrl;
        aVar.f25145d = false;
        aVar.f25147f = g16;
        aVar.f25156o = new b(pushComponent);
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.notification.modularize.c
            @Override // java.lang.Runnable
            public final void run() {
                OnlineModulePushReceiver.p(OnlineModulePushReceiver.this, aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(OnlineModulePushReceiver this$0, Wallet.a info) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(info, "$info");
        IRuntimeService runtimeService = this$0.app.getRuntimeService(IQQReminderMsgService.class, ProcessConstant.MULTI);
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IQ\u2026a, ProcessConstant.MULTI)");
        ((IQQReminderMsgService) runtimeService).showRemindDialog(info);
    }

    private final void q(f pushComponent, boolean isInBackground) {
        if (e.b().containsKey(Integer.valueOf(pushComponent.notifyId))) {
            i iVar = i.f254311a;
            String currentUin = this.app.getCurrentUin();
            Intrinsics.checkNotNullExpressionValue(currentUin, "app.currentUin");
            iVar.d(currentUin, 215, String.valueOf(pushComponent.com.tencent.qphone.base.BaseConstants.EXTRA_PUSHID java.lang.String), pushComponent.triggerInfo, pushComponent.from);
            QLog.w("OnlineModulePushReceiver", 1, "onPushReceived , checkRules repeat, pushComponent = " + pushComponent);
            return;
        }
        e.b().put(Integer.valueOf(pushComponent.notifyId), Integer.valueOf(pushComponent.mainBusinessId));
        BaseJumpScheme a16 = com.tencent.mobileqq.notification.modularize.business.d.f254280a.a(pushComponent);
        if (pushComponent.type == 3) {
            o(pushComponent, a16);
        } else if (pushComponent.d()) {
            r(pushComponent, a16, isInBackground);
        } else {
            s(pushComponent, a16);
        }
        SimpleEventBus.getInstance().dispatchEvent(new TianshuReceivePushEvent(pushComponent.com.tencent.qphone.base.BaseConstants.EXTRA_PUSHID java.lang.String, pushComponent.jumpScheme));
        MMKVOptionEntity mMKVOptionEntity = f254243c;
        mMKVOptionEntity.encodeLong(INSTANCE.n(pushComponent), System.currentTimeMillis());
        if (pushComponent.c()) {
            f254245e++;
            mMKVOptionEntity.encodeInt(f254244d + "_push_total", f254245e);
        }
        ReportController.o(null, "dc00898", "", "", "0X800AE73", "0X800AE73", pushComponent.mainBusinessId, 0, String.valueOf(pushComponent.subBusinessId), String.valueOf(pushComponent.com.tencent.qphone.base.BaseConstants.EXTRA_PUSHID java.lang.String), "", "");
        i iVar2 = i.f254311a;
        String currentUin2 = this.app.getCurrentUin();
        Intrinsics.checkNotNullExpressionValue(currentUin2, "app.currentUin");
        iVar2.d(currentUin2, 117, String.valueOf(pushComponent.com.tencent.qphone.base.BaseConstants.EXTRA_PUSHID java.lang.String), pushComponent.triggerInfo, pushComponent.from);
        QLog.d("OnlineModulePushReceiver", 1, "showNotification  pushComponent = " + pushComponent);
    }

    private final void r(f pushComponent, BaseJumpScheme jumpScheme, boolean isInBackground) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        long j3;
        boolean z16;
        String str7;
        String str8;
        QLog.d("OnlineModulePushReceiver", 1, "showStrongPush, forcePushInfo:" + pushComponent.forcePushInfo + ", isInBackground:" + isInBackground);
        if (isInBackground) {
            s(pushComponent, jumpScheme);
        }
        com.tencent.mobileqq.notification.modularize.b bVar = pushComponent.forcePushInfo;
        if (bVar == null || (str = bVar.actionJump) == null) {
            str = "";
        }
        Intent d16 = jumpScheme.d(pushComponent, str);
        com.tencent.mobileqq.notification.modularize.b bVar2 = pushComponent.forcePushInfo;
        if (bVar2 != null) {
            str2 = bVar2.bgUrl;
        } else {
            str2 = null;
        }
        if (bVar2 != null) {
            str3 = bVar2.voiceUrl;
        } else {
            str3 = null;
        }
        if (bVar2 != null) {
            str4 = bVar2.title;
        } else {
            str4 = null;
        }
        if (bVar2 != null) {
            str5 = bVar2.content;
        } else {
            str5 = null;
        }
        if (bVar2 != null) {
            str6 = bVar2.actionText;
        } else {
            str6 = null;
        }
        if (bVar2 != null) {
            j3 = bVar2.duration;
        } else {
            j3 = 10;
        }
        if (bVar2 != null) {
            z16 = bVar2.isLoop;
        } else {
            z16 = false;
        }
        boolean z17 = z16;
        if (bVar2 != null) {
            str7 = bVar2.leftIcon;
        } else {
            str7 = null;
        }
        if (bVar2 != null) {
            str8 = bVar2.bgTitle;
        } else {
            str8 = null;
        }
        TianshuLockScreenBean tianshuLockScreenBean = new TianshuLockScreenBean(str2, str3, str4, str5, str6, d16, j3, z17, str7, str8);
        IReminderNotificationApi iReminderNotificationApi = (IReminderNotificationApi) QRoute.api(IReminderNotificationApi.class);
        BaseApplication context = BaseApplication.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        iReminderNotificationApi.openNotificationActivity(context, tianshuLockScreenBean);
    }

    private final void s(f pushComponent, BaseJumpScheme jumpScheme) {
        QLog.d("OnlineModulePushReceiver", 1, "showSystemNotification");
        Notification b16 = NotificationBuilder.f254239a.b(jumpScheme.i(pushComponent), pushComponent, jumpScheme);
        j();
        QQNotificationManager.getInstance().notify("OnlineModulePushReceiver", pushComponent.notifyId, b16);
        this.app.vibratorAndAudio();
    }

    @NotNull
    public final f f(@NotNull ModulePushPb$MsgBody msgBody, @NotNull String from) {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (f) iPatchRedirector.redirect((short) 4, (Object) this, (Object) msgBody, (Object) from);
        }
        Intrinsics.checkNotNullParameter(msgBody, "msgBody");
        Intrinsics.checkNotNullParameter(from, "from");
        f fVar = new f();
        String str = msgBody.msg_content.str_title.get();
        Intrinsics.checkNotNullExpressionValue(str, "msgBody.msg_content.str_title.get()");
        fVar.title = str;
        String str2 = msgBody.msg_content.msg_image.str_url.get();
        Intrinsics.checkNotNullExpressionValue(str2, "msgBody.msg_content.msg_image.str_url.get()");
        fVar.iconUrl = str2;
        String str3 = msgBody.msg_content.str_desc.get();
        Intrinsics.checkNotNullExpressionValue(str3, "msgBody.msg_content.str_desc.get()");
        fVar.contentText = str3;
        String str4 = msgBody.msg_content.msg_forward.str_url.get();
        Intrinsics.checkNotNullExpressionValue(str4, "msgBody.msg_content.msg_forward.str_url.get()");
        fVar.jumpScheme = str4;
        if (msgBody.msg_content.msg_forward.uint32_type.get() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        fVar.isUrlJump = z16;
        fVar.mainBusinessId = msgBody.int32_service_id.get();
        fVar.subBusinessId = msgBody.int32_sub_service_id.get();
        fVar.notifyId = msgBody.int32_notify_id.get();
        fVar.com.tencent.qphone.base.BaseConstants.EXTRA_PUSHID java.lang.String = msgBody.int32_push_id.get();
        fVar.time = msgBody.uint64_timestamp.get();
        fVar.com.tencent.mobileqq.activity.QQBrowserActivity.KEY_MSG_TYPE java.lang.String = msgBody.msg_type.get();
        if (msgBody.int32_recall_flag.get() == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        fVar.isRevokePush = z17;
        fVar.type = msgBody.int32_type.get();
        byte[] byteArray = msgBody.msg_content.bytes_ext_data.get().toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "msgBody.msg_content.byte\u2026_data.get().toByteArray()");
        fVar.bytesExtData = byteArray;
        fVar.style = msgBody.msg_content.style_type.get();
        ModulePushPb$ForcePushInfo modulePushPb$ForcePushInfo = msgBody.msg_content.force_push_info.get();
        Intrinsics.checkNotNullExpressionValue(modulePushPb$ForcePushInfo, "msgBody.msg_content.force_push_info.get()");
        fVar.forcePushInfo = g.a(modulePushPb$ForcePushInfo);
        ByteStringMicro byteStringMicro = msgBody.msg_content.bytes_ext_data.get();
        Intrinsics.checkNotNullExpressionValue(byteStringMicro, "msgBody.msg_content.bytes_ext_data.get()");
        l(fVar, byteStringMicro);
        List<ModulePushPb$Button> list = msgBody.msg_content.buttons.get();
        Intrinsics.checkNotNullExpressionValue(list, "msgBody.msg_content.buttons.get()");
        k(fVar, list);
        fVar.from = from;
        QLog.d("OnlineModulePushReceiver", 1, "convertPacket  pushComponent = ", fVar);
        return fVar;
    }

    public final void h(@NotNull List<f> pushList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) pushList);
            return;
        }
        Intrinsics.checkNotNullParameter(pushList, "pushList");
        TianShuPushConfigParser.b bVar = f254246f;
        Intrinsics.checkNotNull(bVar);
        int b16 = bVar.b();
        int min = Math.min(b16, pushList.size());
        QLog.d("OnlineModulePushReceiver", 1, "onOfflinePushReceived latestTotal: " + b16 + ", min:" + min);
        if (b16 < 1) {
            return;
        }
        m.f254314a.a();
        for (int i3 = 0; i3 < min; i3++) {
            i(pushList.get(i3));
        }
        if (min >= pushList.size()) {
            return;
        }
        int size = pushList.size();
        while (min < size) {
            f fVar = pushList.get(min);
            i iVar = i.f254311a;
            String currentUin = this.app.getCurrentUin();
            Intrinsics.checkNotNullExpressionValue(currentUin, "app.currentUin");
            iVar.d(currentUin, 217, String.valueOf(fVar.com.tencent.qphone.base.BaseConstants.EXTRA_PUSHID java.lang.String), fVar.triggerInfo, fVar.from);
            min++;
        }
    }

    public final void i(@NotNull final f pushComponent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) pushComponent);
            return;
        }
        Intrinsics.checkNotNullParameter(pushComponent, "pushComponent");
        Companion companion = INSTANCE;
        f254244d = companion.j();
        f254245e = companion.f();
        QLog.d("OnlineModulePushReceiver", 1, "onPushReceived: called. ", "pushComponent: " + pushComponent);
        if (!pushComponent.g()) {
            QLog.e("OnlineModulePushReceiver", 1, "onPushReceived: called. , invalid notify id. pushComponent: " + pushComponent);
            i iVar = i.f254311a;
            String currentUin = this.app.getCurrentUin();
            Intrinsics.checkNotNullExpressionValue(currentUin, "app.currentUin");
            iVar.d(currentUin, 218, String.valueOf(pushComponent.com.tencent.qphone.base.BaseConstants.EXTRA_PUSHID java.lang.String), pushComponent.triggerInfo, pushComponent.from);
            return;
        }
        if (pushComponent.isRevokePush) {
            m(pushComponent);
            return;
        }
        if (!companion.c(pushComponent)) {
            i iVar2 = i.f254311a;
            String currentUin2 = this.app.getCurrentUin();
            Intrinsics.checkNotNullExpressionValue(currentUin2, "app.currentUin");
            iVar2.d(currentUin2, 215, String.valueOf(pushComponent.com.tencent.qphone.base.BaseConstants.EXTRA_PUSHID java.lang.String), pushComponent.triggerInfo, pushComponent.from);
            QLog.w("OnlineModulePushReceiver", 1, "onPushReceived , checkRules repeat, pushComponent = " + pushComponent);
            return;
        }
        if (companion.k(pushComponent)) {
            i iVar3 = i.f254311a;
            String currentUin3 = this.app.getCurrentUin();
            Intrinsics.checkNotNullExpressionValue(currentUin3, "app.currentUin");
            iVar3.d(currentUin3, 216, String.valueOf(pushComponent.com.tencent.qphone.base.BaseConstants.EXTRA_PUSHID java.lang.String), pushComponent.triggerInfo, pushComponent.from);
            QLog.e("OnlineModulePushReceiver", 1, "onPushReceived: called. isLimitTime. pushComponent: " + pushComponent);
            return;
        }
        e.g(new Function0<Unit>(pushComponent) { // from class: com.tencent.mobileqq.notification.modularize.OnlineModulePushReceiver$onPushReceived$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ f $pushComponent;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$pushComponent = pushComponent;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) OnlineModulePushReceiver.this, (Object) pushComponent);
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
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    OnlineModulePushReceiver.this.n(this.$pushComponent);
                } catch (Exception e16) {
                    HashMap hashMap = new HashMap();
                    String packageName = BaseApplication.context.getPackageName();
                    Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
                    hashMap.put("packageName", packageName);
                    String packageName2 = RFWApplication.getApplication().getPackageName();
                    Intrinsics.checkNotNullExpressionValue(packageName2, "getApplication().packageName");
                    hashMap.put("rfw_packageName", packageName2);
                    RFWReporter.reportCommonEvent(HeytapPushManager.EVENT_ID_PUSH_EXCEPTION, hashMap);
                    RFWLog.fatal("OnlineModulePushReceiver", RFWLog.USR, e16);
                }
            }
        });
    }
}
