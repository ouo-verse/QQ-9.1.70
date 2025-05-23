package com.tencent.mobileqq.vas.aiotip.api.impl;

import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.vas.VipNtMMKV;
import com.tencent.mobileqq.vas.aiotip.api.IVasAioTipManager;
import com.tencent.mobileqq.vas.aiotip.api.IVasAioTipService;
import com.tencent.mobileqq.vas.aiotip.api.KeywordLimitConfig;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.toggle.UnitedProxy;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.a;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IMsgsRspOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.MsgsReq;
import com.tencent.qqnt.kernel.nativeinterface.MsgsRsp;
import com.tencent.qqnt.kernel.nativeinterface.TextElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 #2\u00020\u0001:\u0001$B\u0007\u00a2\u0006\u0004\b!\u0010\"J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J \u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0002J(\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0006H\u0002J\u0018\u0010\u0019\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u000fH\u0016J\u0018\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u0006H\u0016J\u0010\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0018\u0010 \u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/vas/aiotip/api/impl/VasAioTipServiceImpl;", "Lcom/tencent/mobileqq/vas/aiotip/api/IVasAioTipService;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "contact", "", "isCheck", "", "checkCountAndTryInsertMsgRoamTips", "isCanInsertMsgRoamTips", "", "getTodayStartSeq", "", "curType", "", "curAccountUin", "curFriendUin", "needKeywordDetect", "msgLowCase", "chatType", "friendUin", "isSender", "doDetectKeyword", "fromUin", "tryTriggerExpireAioTips", "Lcom/tencent/qqnt/msg/d;", "msg", "tryKeywordsAioTips", "Lcom/tencent/aio/data/AIOParam;", "param", "tryTriggerMsgRoamAioTipsWhenEnterAio", "tryTriggerMsgRoamAioTipsWhenSendReceive", "<init>", "()V", "Companion", "a", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasAioTipServiceImpl implements IVasAioTipService {

    @NotNull
    public static final String KEY_LAST_SHOW_GRAY_TIPS_TIME = "lastShowGrayTipsTime_";

    @NotNull
    private static final String LAST_PULL_INDIVIDUAL_EXPIRE_INTO_TIME = "last_pull_individual_expire_info_time";

    @NotNull
    private static final String TAG = "VasAioTipServiceImpl";
    private static final int _24H = 86400000;
    private static volatile boolean isRequestExpired;
    private static final boolean isVasMsgRoamingGuideGrayTipsEnable;
    private static final int needCount;

    @NotNull
    private static final UnitedProxy vasMsgRoamingGuideGrayTips;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/vas/aiotip/api/impl/VasAioTipServiceImpl$b", "Lcom/tencent/qqnt/kernel/nativeinterface/IMsgsRspOperateCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgsRsp;", "msgsRsp", "", "onResult", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b implements IMsgsRspOperateCallback {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f308394b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f308395c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f308396d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f308397e;

        b(long j3, String str, int i3, long j16) {
            this.f308394b = j3;
            this.f308395c = str;
            this.f308396d = i3;
            this.f308397e = j16;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgsRspOperateCallback
        public void onResult(@Nullable MsgsRsp msgsRsp) {
            int i3;
            boolean z16;
            if (msgsRsp == null || msgsRsp.result != 0) {
                return;
            }
            QLog.i(VasAioTipServiceImpl.TAG, 1, "get last msg list, count:" + msgsRsp.msgList.size());
            if (msgsRsp.msgList.size() >= VasAioTipServiceImpl.needCount) {
                long todayStartSeq = VasAioTipServiceImpl.this.getTodayStartSeq();
                ArrayList<MsgRecord> arrayList = msgsRsp.msgList;
                Intrinsics.checkNotNullExpressionValue(arrayList, "rsp.msgList");
                boolean z17 = false;
                if ((arrayList instanceof Collection) && arrayList.isEmpty()) {
                    i3 = 0;
                } else {
                    i3 = 0;
                    for (MsgRecord msgRecord : arrayList) {
                        if (msgRecord.msgTime > todayStartSeq && msgRecord.msgType != 5) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16 && (i3 = i3 + 1) < 0) {
                            CollectionsKt__CollectionsKt.throwCountOverflow();
                        }
                    }
                }
                if (i3 >= VasAioTipServiceImpl.needCount) {
                    z17 = true;
                }
                QLog.i(VasAioTipServiceImpl.TAG, 1, "get filter last msg list, count:" + i3 + " insert: " + z17);
                long uptimeMillis = SystemClock.uptimeMillis() - this.f308394b;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("traces time: ");
                sb5.append(uptimeMillis);
                QLog.i(VasAioTipServiceImpl.TAG, 1, sb5.toString());
                if (z17) {
                    VipNtMMKV.INSTANCE.getCommon(this.f308395c).encodeLong("vas_msg_roam_tips_2", System.currentTimeMillis() / 1000);
                    a.Companion companion = com.tencent.qqnt.aio.adapter.a.INSTANCE;
                    int transformFrom = ((IVasAioTipManager) companion.a(IVasAioTipManager.class)).transformFrom(this.f308396d);
                    IVasAioTipManager iVasAioTipManager = (IVasAioTipManager) companion.a(IVasAioTipManager.class);
                    long j3 = this.f308397e;
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(j3);
                    String sb7 = sb6.toString();
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put("matchKey", "\u6d88\u606f\u6f2b\u6e38");
                    Unit unit = Unit.INSTANCE;
                    iVasAioTipManager.requestUnitGrayTips(3, transformFrom, sb7, linkedHashMap, null);
                }
            }
        }
    }

    static {
        UnitedProxy a16 = ar.INSTANCE.a("shouyouye", "2024-03-26", "vas_msg_roaming_guide_gray_tips");
        vasMsgRoamingGuideGrayTips = a16;
        isVasMsgRoamingGuideGrayTipsEnable = a16.isEnable(true);
        needCount = a16.getJson().optInt("trigger_msg_count", 5);
    }

    private final void checkCountAndTryInsertMsgRoamTips(final MsgRecord msgRecord, final Contact contact, boolean isCheck) {
        if ((isCheck && !isCanInsertMsgRoamTips()) || msgRecord.chatType != 1) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.aiotip.api.impl.a
            @Override // java.lang.Runnable
            public final void run() {
                VasAioTipServiceImpl.checkCountAndTryInsertMsgRoamTips$lambda$8(MsgRecord.this, contact, this);
            }
        }, 16, null, false);
    }

    static /* synthetic */ void checkCountAndTryInsertMsgRoamTips$default(VasAioTipServiceImpl vasAioTipServiceImpl, MsgRecord msgRecord, Contact contact, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = true;
        }
        vasAioTipServiceImpl.checkCountAndTryInsertMsgRoamTips(msgRecord, contact, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkCountAndTryInsertMsgRoamTips$lambda$8(MsgRecord msgRecord, Contact contact, VasAioTipServiceImpl this$0) {
        String str;
        AppRuntime peekAppRuntime;
        Intrinsics.checkNotNullParameter(msgRecord, "$msgRecord");
        Intrinsics.checkNotNullParameter(contact, "$contact");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ != null && (peekAppRuntime = mobileQQ.peekAppRuntime()) != null) {
            str = peekAppRuntime.getCurrentAccountUin();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        String str2 = str;
        long uptimeMillis = SystemClock.uptimeMillis();
        int i3 = msgRecord.chatType;
        long j3 = msgRecord.peerUin;
        MsgsReq msgsReq = new MsgsReq();
        msgsReq.peer = contact;
        msgsReq.byType = 1;
        long j16 = msgRecord.msgId;
        msgsReq.msgId = j16;
        msgsReq.cnt = needCount * 3;
        msgsReq.queryOrder = true;
        msgsReq.includeSelf = true;
        QLog.i(TAG, 1, "get last msg:" + j16);
        ((IMsgService) QRoute.api(IMsgService.class)).getMsgsExt(msgsReq, new b(uptimeMillis, str2, i3, j3));
    }

    private final boolean doDetectKeyword(String msgLowCase, int chatType, String friendUin, boolean isSender) {
        boolean contains$default;
        String str;
        boolean z16;
        boolean contains$default2;
        for (String str2 : ((IVasAioTipManager) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IVasAioTipManager.class)).getKeywords()) {
            if (!TextUtils.isEmpty(str2)) {
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) msgLowCase, (CharSequence) str2, false, 2, (Object) null);
                if (contains$default) {
                    String[] dirtyWords = ((IVasAioTipManager) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IVasAioTipManager.class)).getDirtyWords();
                    if (dirtyWords != null) {
                        if (dirtyWords.length == 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (!z16) {
                            for (String str3 : dirtyWords) {
                                if (!TextUtils.isEmpty(str3)) {
                                    contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) msgLowCase, (CharSequence) str3, false, 2, (Object) null);
                                    if (contains$default2) {
                                        QLog.d(TAG, 4, "detected Keyword but contain dirty word, keyword=" + str2 + ", dirty word=" + str3);
                                        return false;
                                    }
                                }
                            }
                        }
                    }
                    QLog.d(TAG, 4, "detected Keyword, keyword=" + str2);
                    a.Companion companion = com.tencent.qqnt.aio.adapter.a.INSTANCE;
                    int transformFrom = ((IVasAioTipManager) companion.a(IVasAioTipManager.class)).transformFrom(chatType);
                    HashMap hashMap = new HashMap();
                    hashMap.put("matchKey", str2);
                    if (isSender) {
                        str = "1";
                    } else {
                        str = "0";
                    }
                    hashMap.put(QQBrowserActivity.KEY_MSG_TYPE, str);
                    ((IVasAioTipManager) companion.a(IVasAioTipManager.class)).requestUnitGrayTips(1, transformFrom, friendUin, hashMap, null);
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long getTodayStartSeq() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTime().getTime() / 1000;
    }

    private final boolean isCanInsertMsgRoamTips() {
        String str;
        AppRuntime peekAppRuntime;
        boolean z16 = isVasMsgRoamingGuideGrayTipsEnable;
        QLog.i(TAG, 1, "MsgRoamingGuideGrayTips: " + z16);
        if (!z16) {
            return false;
        }
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ != null && (peekAppRuntime = mobileQQ.peekAppRuntime()) != null) {
            str = peekAppRuntime.getCurrentAccountUin();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        VipNtMMKV.Companion companion = VipNtMMKV.INSTANCE;
        long decodeLong = companion.getCommon(str).decodeLong("vas_msg_roam_tips_2", 0L);
        if (decodeLong == 0) {
            long decodeLong2 = companion.getCommon(str).decodeLong("vas_msg_roam_tips", 0L);
            companion.getCommon(str).removeKey("vas_msg_roam_tips");
            decodeLong = decodeLong2;
        }
        long time = new Date().getTime() / 1000;
        if (decodeLong > 0) {
            long j3 = time - decodeLong;
            if (j3 < 86400) {
                QLog.i(TAG, 1, "tips in one day, cur: " + time + " pre: " + decodeLong + " diff: " + j3 + " ");
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean needKeywordDetect(int curType, String curAccountUin, String curFriendUin) {
        int c2cEnable;
        long c2cFreq;
        int i3;
        long j3;
        a.Companion companion = com.tencent.qqnt.aio.adapter.a.INSTANCE;
        KeywordLimitConfig keywordLimitConfig = ((IVasAioTipManager) companion.a(IVasAioTipManager.class)).getKeywordLimitConfig();
        if (curType != 1) {
            if (curType != 2) {
                if (curType != 3) {
                    j3 = 86400;
                    i3 = 0;
                    if (i3 != 0) {
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 4, "VIP Keyword Function is closed.");
                        }
                        return false;
                    }
                    if (System.currentTimeMillis() - VipNtMMKV.INSTANCE.getCommon(curAccountUin).decodeLong(KEY_LAST_SHOW_GRAY_TIPS_TIME + curType + "_" + curFriendUin, 0L) < 1000 * j3) {
                        QLog.d(TAG, 4, "VIP Keyword Function frequency = " + j3 + "s, so need not detect keyword.");
                        return false;
                    }
                    return ((IVasAioTipManager) companion.a(IVasAioTipManager.class)).isGray(curType, curFriendUin);
                }
                c2cEnable = keywordLimitConfig.getDiscussEnable();
                c2cFreq = keywordLimitConfig.getDiscussFreq();
            } else {
                c2cEnable = keywordLimitConfig.getGroupEnable();
                c2cFreq = keywordLimitConfig.getGroupFreq();
            }
        } else {
            c2cEnable = keywordLimitConfig.getC2cEnable();
            c2cFreq = keywordLimitConfig.getC2cFreq();
        }
        long j16 = c2cFreq;
        i3 = c2cEnable;
        j3 = j16;
        if (i3 != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void tryKeywordsAioTips$lambda$3(com.tencent.qqnt.msg.d msg2, VasAioTipServiceImpl this$0, boolean z16) {
        String str;
        String content;
        AppRuntime peekAppRuntime;
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ != null && (peekAppRuntime = mobileQQ.peekAppRuntime()) != null) {
            str = peekAppRuntime.getCurrentAccountUin();
        } else {
            str = null;
        }
        String str2 = "";
        if (str == null) {
            str = "";
        }
        long j3 = msg2.a().peerUin;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(j3);
        String sb6 = sb5.toString();
        int i3 = msg2.a().chatType;
        if (!this$0.needKeywordDetect(i3, str, sb6)) {
            QLog.i(TAG, 1, "check need keyword detect fail");
            return;
        }
        try {
            Iterator it = new ArrayList(msg2.a().elements).iterator();
            while (it.hasNext()) {
                TextElement textElement = ((MsgElement) it.next()).textElement;
                if (textElement != null && (content = textElement.content) != null) {
                    Intrinsics.checkNotNullExpressionValue(content, "content");
                    if (!TextUtils.isEmpty(content)) {
                        str2 = ((Object) str2) + content;
                    }
                }
            }
        } catch (Exception e16) {
            QLog.w(TAG, 1, "E:" + e16);
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        String lowerCase = str2.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        if (this$0.doDetectKeyword(lowerCase, i3, sb6, z16)) {
            VipNtMMKV.INSTANCE.getCommon(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin()).encodeLong(KEY_LAST_SHOW_GRAY_TIPS_TIME + i3 + "_" + sb6, System.currentTimeMillis());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void tryTriggerExpireAioTips$lambda$0(int i3, String fromUin) {
        Intrinsics.checkNotNullParameter(fromUin, "$fromUin");
        if (isRequestExpired) {
            isRequestExpired = true;
            return;
        }
        if (i3 != 1 && i3 != 2 && i3 != 3) {
            return;
        }
        QLog.i(TAG, 1, "tryTriggerExpireAioTips");
        SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences(MobileQQ.sMobileQQ.peekAppRuntime().getAccount(), 4);
        if (System.currentTimeMillis() - sharedPreferences.getLong(LAST_PULL_INDIVIDUAL_EXPIRE_INTO_TIME, 0L) > 86400000) {
            a.Companion companion = com.tencent.qqnt.aio.adapter.a.INSTANCE;
            ((IVasAioTipManager) companion.a(IVasAioTipManager.class)).requestUnitGrayTips(2, ((IVasAioTipManager) companion.a(IVasAioTipManager.class)).transformFrom(i3), fromUin, null, null);
            sharedPreferences.edit().putLong(LAST_PULL_INDIVIDUAL_EXPIRE_INTO_TIME, System.currentTimeMillis()).apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void tryTriggerMsgRoamAioTipsWhenEnterAio$lambda$6(final VasAioTipServiceImpl this$0, AIOParam param) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(param, "$param");
        if (this$0.isCanInsertMsgRoamTips()) {
            AIOSession r16 = param.r();
            final Contact contact = new Contact(r16.c().e(), r16.c().j(), r16.c().f());
            ((IMsgService) QRoute.api(IMsgService.class)).getLatestDbMsgs(contact, 1, new IMsgOperateCallback() { // from class: com.tencent.mobileqq.vas.aiotip.api.impl.d
                @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
                public final void onResult(int i3, String str, ArrayList arrayList) {
                    VasAioTipServiceImpl.tryTriggerMsgRoamAioTipsWhenEnterAio$lambda$6$lambda$5$lambda$4(VasAioTipServiceImpl.this, contact, i3, str, arrayList);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void tryTriggerMsgRoamAioTipsWhenEnterAio$lambda$6$lambda$5$lambda$4(VasAioTipServiceImpl this$0, Contact contact, int i3, String str, ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(contact, "$contact");
        if (i3 == 0 && arrayList.size() > 0) {
            MsgRecord get = (MsgRecord) arrayList.get(0);
            Intrinsics.checkNotNullExpressionValue(get, "get");
            this$0.checkCountAndTryInsertMsgRoamTips(get, contact, false);
        }
    }

    @Override // com.tencent.mobileqq.vas.aiotip.api.IVasAioTipService
    public void tryKeywordsAioTips(@NotNull final com.tencent.qqnt.msg.d msg2, final boolean isSender) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (SimpleUIUtil.getSimpleUISwitch()) {
            return;
        }
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.vas.aiotip.api.impl.e
            @Override // java.lang.Runnable
            public final void run() {
                VasAioTipServiceImpl.tryKeywordsAioTips$lambda$3(com.tencent.qqnt.msg.d.this, this, isSender);
            }
        }, 16, null, false, 1000L);
    }

    @Override // com.tencent.mobileqq.vas.aiotip.api.IVasAioTipService
    public void tryTriggerExpireAioTips(final int curType, @NotNull final String fromUin) {
        Intrinsics.checkNotNullParameter(fromUin, "fromUin");
        if (SimpleUIUtil.getSimpleUISwitch()) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.aiotip.api.impl.c
            @Override // java.lang.Runnable
            public final void run() {
                VasAioTipServiceImpl.tryTriggerExpireAioTips$lambda$0(curType, fromUin);
            }
        }, 16, null, false);
    }

    @Override // com.tencent.mobileqq.vas.aiotip.api.IVasAioTipService
    public void tryTriggerMsgRoamAioTipsWhenEnterAio(@NotNull final AIOParam param) {
        Intrinsics.checkNotNullParameter(param, "param");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.aiotip.api.impl.b
            @Override // java.lang.Runnable
            public final void run() {
                VasAioTipServiceImpl.tryTriggerMsgRoamAioTipsWhenEnterAio$lambda$6(VasAioTipServiceImpl.this, param);
            }
        }, 16, null, false);
    }

    @Override // com.tencent.mobileqq.vas.aiotip.api.IVasAioTipService
    public void tryTriggerMsgRoamAioTipsWhenSendReceive(@NotNull MsgRecord msgRecord, @NotNull Contact contact) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(contact, "contact");
        checkCountAndTryInsertMsgRoamTips$default(this, msgRecord, contact, false, 4, null);
    }
}
