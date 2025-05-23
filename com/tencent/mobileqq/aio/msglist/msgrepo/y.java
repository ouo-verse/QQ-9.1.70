package com.tencent.mobileqq.aio.msglist.msgrepo;

import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdTianshuFeedData;
import com.tencent.aio.data.AIOParam;
import com.tencent.ark.ark;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.aio.event.AIOMsgEvent;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.BaseMsgRepo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOWeChatGuildApi;
import com.tencent.qqnt.graytips.api.INtGrayTipApi;
import com.tencent.qqnt.graytips.local.LocalGrayTip;
import com.tencent.qqnt.robot.api.IRobotServiceApi;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 <2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001=B\u001f\u0012\u0006\u00105\u001a\u00020\u0002\u0012\u0006\u00107\u001a\u000206\u0012\u0006\u00109\u001a\u000208\u00a2\u0006\u0004\b:\u0010;J\u0016\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0016\u0010\u000e\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\b\u0010\u000f\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\bH\u0002J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0002J\u0018\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u0013H\u0002J\b\u0010\u001e\u001a\u00020\u0006H\u0002J\b\u0010\u001f\u001a\u00020\u0006H\u0002J\b\u0010 \u001a\u00020\u0006H\u0002J\u0010\u0010\"\u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u0013H\u0002J\u0010\u0010%\u001a\u00020\u00062\u0006\u0010$\u001a\u00020#H\u0016J(\u0010*\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040&2\u0006\u0010'\u001a\u00020\u00162\b\u0010)\u001a\u0004\u0018\u00010(H\u0016R\u0014\u0010-\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00104\u001a\u00020\u00168BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b2\u00103\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/msgrepo/y;", "Lcom/tencent/mobileqq/aio/msglist/msgrepo/g;", "Lcom/tencent/mobileqq/aio/msglist/BaseMsgRepo;", "", "Lcom/tencent/aio/data/msglist/a;", "msgItemList", "", "w", "Lcom/tencent/qqnt/aio/adapter/api/IAIOWeChatGuildApi$BIZ_TYPE_WX;", "bizType", "Lorg/json/JSONObject;", "t", "list", "", "p", ReportConstant.COSTREPORT_PREFIX, "v", "type", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "timestamp", "u", "", "str1", "subStr", "Lkotlin/ranges/IntRange;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, ark.ARKMETADATA_JSON, "grayTipID", DomainData.DOMAIN_NAME, HippyTKDListViewAdapter.X, "o", "y", "timeInSeconds", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "g", "", "source", "Landroid/os/Bundle;", "extra", "b", "i", "Ljava/lang/String;", "peerUid", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "chatType", "r", "()Ljava/lang/String;", "KEY_LAST_SEND_MSG_TIME", "msgRepo", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lkotlinx/coroutines/CoroutineScope;", "scope", "<init>", "(Lcom/tencent/mobileqq/aio/msglist/BaseMsgRepo;Lcom/tencent/aio/api/runtime/a;Lkotlinx/coroutines/CoroutineScope;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class y extends g<BaseMsgRepo> {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String peerUid;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int chatType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/msgrepo/y$a;", "", "", "KEY_GRAY_HIGH_TEXT", "Ljava/lang/String;", "KEY_GRAY_HIGH_TEXT_REPLACE", "KEY_GRAY_JUMP_URL", "KEY_GRAY_TEXT", "KEY_SEND_INTERVAL_DAY", "TAG", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.msgrepo.y$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64290);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(@NotNull BaseMsgRepo msgRepo, @NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull CoroutineScope scope) {
        super(msgRepo, aioContext, scope);
        Intrinsics.checkNotNullParameter(msgRepo, "msgRepo");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(scope, "scope");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, msgRepo, aioContext, scope);
        } else {
            this.peerUid = aioContext.g().r().c().j();
            this.chatType = aioContext.g().r().c().e();
        }
    }

    private final String A(long timeInSeconds) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeInSeconds * 1000);
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(calendar.getTime());
        Intrinsics.checkNotNullExpressionValue(format, "dateFormat.format(date.time)");
        return format;
    }

    private final boolean n(JSONObject json, long grayTipID) {
        String tip;
        boolean z16;
        int length;
        int length2;
        String tip2 = json.optString("text", "");
        String highTip = json.optString(QZoneAdTianshuFeedData.KEY_BUTTON_TEXT, "");
        Intrinsics.checkNotNullExpressionValue(tip2, "tip");
        Intrinsics.checkNotNullExpressionValue(highTip, "highTip");
        tip = StringsKt__StringsJVMKt.replace$default(tip2, "{button_text}", highTip, false, 4, (Object) null);
        String jumpUrl = json.optString("jump_url", "");
        QLog.i("WeChatQQMsgAbility", 1, "[addLocalGrayTip]: \u6dfb\u52a0\u5c0f\u7070\u6761\uff1a" + tip + ", " + grayTipID);
        Intrinsics.checkNotNullExpressionValue(tip, "tip");
        if (tip.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.i("WeChatQQMsgAbility", 1, "[addLocalGrayTip]: \u5c0f\u7070\u6761\u6587\u6848\u4e3a\u7a7a\uff0creturn");
            return false;
        }
        Intrinsics.checkNotNullExpressionValue(tip, "tip");
        IntRange q16 = q(tip, highTip);
        if (q16 != null) {
            length = q16.getFirst();
        } else {
            length = tip.length();
        }
        if (q16 != null) {
            length2 = q16.getLast() + 1;
        } else {
            length2 = tip.length();
        }
        String obj = tip.subSequence(0, length).toString();
        String obj2 = tip.subSequence(length, length2).toString();
        String obj3 = tip.subSequence(length2, tip.length()).toString();
        LocalGrayTip.LocalGrayTipBuilder i3 = LocalGrayTip.LocalGrayTipBuilder.i(new LocalGrayTip.LocalGrayTipBuilder(this.peerUid, this.chatType, grayTipID, 0, false, false, null, 120, null), obj, 0, 2, null);
        Intrinsics.checkNotNullExpressionValue(jumpUrl, "jumpUrl");
        LocalGrayTip m3 = LocalGrayTip.LocalGrayTipBuilder.i(i3.h(obj2, new com.tencent.qqnt.graytips.action.t(jumpUrl), 3), obj3, 0, 2, null).m();
        QRouteApi api = QRoute.api(INtGrayTipApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(INtGrayTipApi::class.java)");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
        INtGrayTipApi.a.a((INtGrayTipApi) api, peekAppRuntime, m3, null, 4, null);
        return true;
    }

    private final void o() {
        Integer intOrNull;
        IAIOWeChatGuildApi.BIZ_TYPE_WX biz_type_wx = IAIOWeChatGuildApi.BIZ_TYPE_WX.C2CAIOSEND;
        JSONObject t16 = t(biz_type_wx);
        if (t16 == null) {
            return;
        }
        String intervalDay = t16.optString("interval_days", "");
        Intrinsics.checkNotNullExpressionValue(intervalDay, "intervalDay");
        intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(intervalDay);
        if (intOrNull == null) {
            QLog.i("WeChatQQMsgAbility", 1, "[checkAddGrayTipsWhenSendMsg]: \u5173\u952e\u5929\u67a2\u6570\u636e\u7f3a\u5931:" + intervalDay + "\uff0creturn");
            return;
        }
        long decodeLong = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeLong(r(), 0L);
        if (((int) decodeLong) != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            long j3 = (currentTimeMillis - decodeLong) / 86400;
            QLog.i("WeChatQQMsgAbility", 1, "[checkAddGrayTipsWhenSendMsg]: lastSendMsgTime\uff1a" + A(decodeLong) + ", \u5929\u67a2\u95f4\u9694\u4e3a" + intOrNull + "\u5929, \u5f53\u524d\u65f6\u95f4\uff1a" + A(currentTimeMillis));
            if (j3 < intOrNull.intValue()) {
                QLog.i("WeChatQQMsgAbility", 1, "[checkAddGrayTipsWhenSendMsg]: \u65b0\u6d88\u606f\u5728" + intOrNull + "\u5929\u8303\u56f4\u5185\uff0creturn");
                return;
            }
        } else {
            QLog.i("WeChatQQMsgAbility", 1, "[checkAddGrayTipsWhenSendMsg]: \u672a\u627e\u5230\u4e0a\u6b21\u53d1\u6d88\u606f\u7684\u65f6\u95f4\uff0ccontinue");
        }
        if (n(t16, 10465L)) {
            z(biz_type_wx);
        }
    }

    private final boolean p(List<? extends com.tencent.aio.data.msglist.a> list) {
        Object last;
        AIOMsgItem aIOMsgItem;
        if (!list.isEmpty()) {
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) list);
            if (last instanceof AIOMsgItem) {
                aIOMsgItem = (AIOMsgItem) last;
            } else {
                aIOMsgItem = null;
            }
            if (aIOMsgItem != null) {
                if (!Intrinsics.areEqual(aIOMsgItem.getMsgRecord().senderUid, this.peerUid)) {
                    QLog.i("WeChatQQMsgAbility", 1, "\u6700\u540e\u4e00\u6761\u672a\u8bfb\u6d88\u606f\u4e0d\u662f\u5bf9\u65b9\u53d1\u7684\uff0creturn");
                    return false;
                }
                if (!u(aIOMsgItem.getMsgRecord().msgTime)) {
                    return true;
                }
                QLog.i("WeChatQQMsgAbility", 1, "\u6700\u540e\u4e00\u6761\u672a\u8bfb\u6d88\u606f\u662f\u5f53\u5929\u53d1\u7684\uff0creturn");
            }
            return false;
        }
        QLog.i("WeChatQQMsgAbility", 1, "\u7a7a\u6d88\u606fAIO");
        return false;
    }

    private final IntRange q(String str1, String subStr) {
        int indexOf$default;
        IntRange until;
        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str1, subStr, 0, false, 6, (Object) null);
        if (indexOf$default != -1) {
            until = RangesKt___RangesKt.until(indexOf$default, subStr.length() + indexOf$default);
            return until;
        }
        return null;
    }

    private final String r() {
        String str;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentUin();
        } else {
            str = null;
        }
        if (str == null) {
            return "_last_send_msg_time";
        }
        return str;
    }

    private final boolean s() {
        if (this.chatType == 1) {
            IRobotServiceApi iRobotServiceApi = (IRobotServiceApi) QRoute.api(IRobotServiceApi.class);
            AIOParam g16 = d().g();
            Intrinsics.checkNotNullExpressionValue(g16, "aioContext.aioParam");
            if (!iRobotServiceApi.isRobotUin(su3.c.b(g16))) {
                return true;
            }
        }
        return false;
    }

    private final JSONObject t(IAIOWeChatGuildApi.BIZ_TYPE_WX bizType) {
        JSONObject jSONObject;
        boolean v3 = v();
        QLog.i("WeChatQQMsgAbility", 1, "[isTianShuDataReady]: isWeChatMsgAgentOpen:" + v3);
        if (v3) {
            return null;
        }
        IAIOWeChatGuildApi.a configData = ((IAIOWeChatGuildApi) QRoute.api(IAIOWeChatGuildApi.class)).getConfigData(bizType);
        if (configData != null) {
            jSONObject = configData.getCom.tencent.ark.ark.ARKMETADATA_JSON java.lang.String();
        } else {
            jSONObject = null;
        }
        if (jSONObject == null) {
            QLog.i("WeChatQQMsgAbility", 1, "[isTianShuDataReady]" + bizType + ": \u5929\u67a2\u6ca1\u6709\u6570\u636e\uff0creturn");
            return null;
        }
        QLog.i("WeChatQQMsgAbility", 1, "[isTianShuDataReady]" + bizType + ": \u5929\u67a2\u4e0b\u53d1\u6570\u636e\u5185\u5bb9\uff1a" + configData.getCom.tencent.ark.ark.ARKMETADATA_JSON java.lang.String());
        return configData.getCom.tencent.ark.ark.ARKMETADATA_JSON java.lang.String();
    }

    private final boolean u(long timestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp * 1000);
        Calendar calendar2 = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT, Locale.getDefault());
        String format = simpleDateFormat.format(calendar2.getTime());
        String format2 = simpleDateFormat.format(calendar.getTime());
        QLog.i("WeChatQQMsgAbility", 1, "\u6700\u540e\u4e00\u6761\u6d88\u606f:" + format2 + "\uff0c\u4eca\u5929\uff1a" + format);
        return Intrinsics.areEqual(format, format2);
    }

    private final boolean v() {
        return ((IAIOWeChatGuildApi) QRoute.api(IAIOWeChatGuildApi.class)).isWeChatMsgAgentOpen();
    }

    private final void w(List<? extends com.tencent.aio.data.msglist.a> msgItemList) {
        IAIOWeChatGuildApi.BIZ_TYPE_WX biz_type_wx;
        JSONObject t16;
        if (s() && p(msgItemList) && (t16 = t((biz_type_wx = IAIOWeChatGuildApi.BIZ_TYPE_WX.C2CAIOREC))) != null && n(t16, 10464L)) {
            z(biz_type_wx);
        }
    }

    private final void x() {
        QLog.i("WeChatQQMsgAbility", 1, "[beforeNotifyMsgChange]: \u53d1\u9001\u6d88\u606f");
        if (!s()) {
            QLog.i("WeChatQQMsgAbility", 1, "[onSendMsg]: \u5f53\u524d\u4f1a\u8bdd(" + this.chatType + ")\u4e0d\u652f\u6301\uff0creturn");
            return;
        }
        o();
        y();
    }

    private final void y() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeLong(r(), currentTimeMillis);
        QLog.i("WeChatQQMsgAbility", 1, "[recordSendMsgTime]: " + A(currentTimeMillis));
    }

    private final void z(IAIOWeChatGuildApi.BIZ_TYPE_WX type) {
        QLog.i("WeChatQQMsgAbility", 1, "[reportAppearToTianShu]: \u4e0a\u62a5\u5929\u67a2\uff1a" + type);
        ((IAIOWeChatGuildApi) QRoute.api(IAIOWeChatGuildApi.class)).report(type);
    }

    @Override // com.tencent.mobileqq.aio.msglist.msgrepo.g
    public void b(@NotNull List<com.tencent.aio.data.msglist.a> list, @NotNull String source, @Nullable Bundle extra) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, list, source, extra);
            return;
        }
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(source, "source");
        if (Intrinsics.areEqual(source, "send_msg")) {
            x();
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.msgrepo.g
    public void g(@NotNull MsgIntent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof AIOMsgEvent.OnDisplayUnreadMsg) {
            w(((AIOMsgEvent.OnDisplayUnreadMsg) intent).a());
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.msgrepo.g, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Set) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgEvent.OnDisplayUnreadMsg");
        return hashSet;
    }

    @Override // com.tencent.mobileqq.aio.msglist.msgrepo.g, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Set) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return new HashSet();
    }
}
