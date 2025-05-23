package com.tencent.mobileqq.search.model;

import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\bB\u0018\u0000 o2\u00020\u0001:\u0001pB\u0007\u00a2\u0006\u0004\bm\u0010nJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002R\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R$\u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R$\u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0010\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\"\u0010\u001e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001e\u0010 \"\u0004\b!\u0010\"R\"\u0010#\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\u001f\u001a\u0004\b#\u0010 \"\u0004\b$\u0010\"R\"\u0010&\u001a\u00020%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010,\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010\u001f\u001a\u0004\b,\u0010 \"\u0004\b-\u0010\"RB\u00100\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020%\u0018\u00010.j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020%\u0018\u0001`/8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u00106\u001a\u00020%8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010'\u001a\u0004\b7\u0010)\"\u0004\b8\u0010+R\"\u00109\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010\n\u001a\u0004\b:\u0010\f\"\u0004\b;\u0010\u000eR\"\u0010<\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b<\u0010\u001f\u001a\u0004\b<\u0010 \"\u0004\b=\u0010\"R\"\u0010>\u001a\u00020%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010'\u001a\u0004\b?\u0010)\"\u0004\b@\u0010+R\"\u0010A\u001a\u00020%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010'\u001a\u0004\bB\u0010)\"\u0004\bC\u0010+R\"\u0010D\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bD\u0010\u001f\u001a\u0004\bE\u0010 \"\u0004\bF\u0010\"R\"\u0010G\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bG\u0010\u001f\u001a\u0004\bH\u0010 \"\u0004\bI\u0010\"R\"\u0010J\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bJ\u0010\n\u001a\u0004\bK\u0010\f\"\u0004\bL\u0010\u000eR\"\u0010M\u001a\u00020%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bM\u0010'\u001a\u0004\bN\u0010)\"\u0004\bO\u0010+R\"\u0010P\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bP\u0010\n\u001a\u0004\bQ\u0010\f\"\u0004\bR\u0010\u000eR\"\u0010S\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bS\u0010\n\u001a\u0004\bT\u0010\f\"\u0004\bU\u0010\u000eR\"\u0010V\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bV\u0010\u001f\u001a\u0004\bV\u0010 \"\u0004\bW\u0010\"R\"\u0010X\u001a\u00020%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bX\u0010'\u001a\u0004\bY\u0010)\"\u0004\bZ\u0010+R\"\u0010[\u001a\u00020%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b[\u0010'\u001a\u0004\b\\\u0010)\"\u0004\b]\u0010+R$\u0010^\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b^\u0010\u0010\u001a\u0004\b_\u0010\u0012\"\u0004\b`\u0010\u0014R\"\u0010a\u001a\u00020%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\ba\u0010'\u001a\u0004\bb\u0010)\"\u0004\bc\u0010+R$\u0010d\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bd\u0010\u0010\u001a\u0004\be\u0010\u0012\"\u0004\bf\u0010\u0014R$\u0010g\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bg\u0010\u0010\u001a\u0004\bh\u0010\u0012\"\u0004\bi\u0010\u0014R\"\u0010j\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bj\u0010\n\u001a\u0004\bk\u0010\f\"\u0004\bl\u0010\u000e\u00a8\u0006q"}, d2 = {"Lcom/tencent/mobileqq/search/model/PublicAccountInfoForSearch;", "Lcom/tencent/mobileqq/persistence/Entity;", "", "isHideInContacts", "", "getUinString", "isNeedShow", "isVisible", "", "uin", "J", "getUin", "()J", "setUin", "(J)V", "uid", "Ljava/lang/String;", "getUid", "()Ljava/lang/String;", "setUid", "(Ljava/lang/String;)V", "name", "getName", "setName", "displayNumber", "getDisplayNumber", "setDisplayNumber", "summary", "getSummary", "setSummary", "isRecvMsg", "Z", "()Z", "setRecvMsg", "(Z)V", "isRecvPush", "setRecvPush", "", "clickCount", "I", "getClickCount", "()I", "setClickCount", "(I)V", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_IS_OFF_LINE, "setOffLine", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Marks", "Ljava/util/HashMap;", "getMarks", "()Ljava/util/HashMap;", "setMarks", "(Ljava/util/HashMap;)V", "orderForMark", "getOrderForMark", "setOrderForMark", "certifiedGrade", "getCertifiedGrade", "setCertifiedGrade", "isSyncLbs", "setSyncLbs", "showFlag", "getShowFlag", "setShowFlag", "mShowMsgFlag", "getMShowMsgFlag", "setMShowMsgFlag", "mIsAgreeSyncLbs", "getMIsAgreeSyncLbs", "setMIsAgreeSyncLbs", "mIsSyncLbsSelected", "getMIsSyncLbsSelected", "setMIsSyncLbsSelected", "dateTime", "getDateTime", "setDateTime", CommonConstant.KEY_ACCOUNT_FLAG, "getAccountFlag", "setAccountFlag", "accountFlag2", "getAccountFlag2", "setAccountFlag2", "eqqAccountFlag", "getEqqAccountFlag", "setEqqAccountFlag", "isShieldMsg", "setShieldMsg", "messageSettingFlag", "getMessageSettingFlag", "setMessageSettingFlag", "extendType", "getExtendType", "setExtendType", "uinStr", "getUinStr", "setUinStr", "mComparePartInt", "getMComparePartInt", "setMComparePartInt", "mCompareSpell", "getMCompareSpell", "setMCompareSpell", "logo", "getLogo", "setLogo", "lastAIOReadTime", "getLastAIOReadTime", "setLastAIOReadTime", "<init>", "()V", "Companion", "a", "qqsearch-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class PublicAccountInfoForSearch extends Entity {

    @notColumn
    @Nullable
    private HashMap<String, Integer> Marks;
    private int accountFlag;
    private long accountFlag2;
    private long certifiedGrade;
    private int clickCount;
    private long dateTime;

    @Nullable
    private String displayNumber;
    private long eqqAccountFlag;
    private int extendType;

    @notColumn
    private boolean isOffLine;
    private boolean isRecvMsg;
    private boolean isRecvPush;
    private boolean isShieldMsg;
    private boolean isSyncLbs;
    private long lastAIOReadTime;

    @Nullable
    private String logo;
    private int mComparePartInt;

    @Nullable
    private String mCompareSpell;
    private boolean mIsAgreeSyncLbs;
    private boolean mIsSyncLbsSelected;
    private int mShowMsgFlag;
    private int messageSettingFlag;

    @NotNull
    private String name = "";

    @notColumn
    private int orderForMark;
    private int showFlag;

    @Nullable
    private String summary;

    @Nullable
    private String uid;

    @unique
    private long uin;

    @notColumn
    @Nullable
    private String uinStr;
    private static final int SHOW_FLAG_YES = 1;
    private static final int SHOW_FLAG_NO = 2;
    private static final int SHOW_FLAG_INVISIBLE_BIT = 2048;
    private static final int SHOW_MSG_FLAG_TYPE = 5;

    private final boolean isHideInContacts() {
        if ((SHOW_FLAG_INVISIBLE_BIT & this.accountFlag) != 0) {
            return true;
        }
        return false;
    }

    public final int getAccountFlag() {
        return this.accountFlag;
    }

    public final long getAccountFlag2() {
        return this.accountFlag2;
    }

    public final long getCertifiedGrade() {
        return this.certifiedGrade;
    }

    public final int getClickCount() {
        return this.clickCount;
    }

    public final long getDateTime() {
        return this.dateTime;
    }

    @Nullable
    public final String getDisplayNumber() {
        return this.displayNumber;
    }

    public final long getEqqAccountFlag() {
        return this.eqqAccountFlag;
    }

    public final int getExtendType() {
        return this.extendType;
    }

    public final long getLastAIOReadTime() {
        return this.lastAIOReadTime;
    }

    @Nullable
    public final String getLogo() {
        return this.logo;
    }

    public final int getMComparePartInt() {
        return this.mComparePartInt;
    }

    @Nullable
    public final String getMCompareSpell() {
        return this.mCompareSpell;
    }

    public final boolean getMIsAgreeSyncLbs() {
        return this.mIsAgreeSyncLbs;
    }

    public final boolean getMIsSyncLbsSelected() {
        return this.mIsSyncLbsSelected;
    }

    public final int getMShowMsgFlag() {
        return this.mShowMsgFlag;
    }

    @Nullable
    public final HashMap<String, Integer> getMarks() {
        return this.Marks;
    }

    public final int getMessageSettingFlag() {
        return this.messageSettingFlag;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final int getOrderForMark() {
        return this.orderForMark;
    }

    public final int getShowFlag() {
        return this.showFlag;
    }

    @Nullable
    public final String getSummary() {
        return this.summary;
    }

    @Nullable
    public final String getUid() {
        return this.uid;
    }

    public final long getUin() {
        return this.uin;
    }

    @Nullable
    public final String getUinStr() {
        return this.uinStr;
    }

    @Nullable
    public final String getUinString() {
        if (this.uinStr == null) {
            this.uinStr = String.valueOf(this.uin);
        }
        return this.uinStr;
    }

    public final boolean isNeedShow() {
        if (SHOW_FLAG_YES == this.showFlag) {
            return true;
        }
        return false;
    }

    /* renamed from: isOffLine, reason: from getter */
    public final boolean getIsOffLine() {
        return this.isOffLine;
    }

    /* renamed from: isRecvMsg, reason: from getter */
    public final boolean getIsRecvMsg() {
        return this.isRecvMsg;
    }

    /* renamed from: isRecvPush, reason: from getter */
    public final boolean getIsRecvPush() {
        return this.isRecvPush;
    }

    /* renamed from: isShieldMsg, reason: from getter */
    public final boolean getIsShieldMsg() {
        return this.isShieldMsg;
    }

    /* renamed from: isSyncLbs, reason: from getter */
    public final boolean getIsSyncLbs() {
        return this.isSyncLbs;
    }

    public final boolean isVisible() {
        if (SHOW_FLAG_YES == this.showFlag) {
            return true;
        }
        return false;
    }

    public final void setAccountFlag(int i3) {
        this.accountFlag = i3;
    }

    public final void setAccountFlag2(long j3) {
        this.accountFlag2 = j3;
    }

    public final void setCertifiedGrade(long j3) {
        this.certifiedGrade = j3;
    }

    public final void setClickCount(int i3) {
        this.clickCount = i3;
    }

    public final void setDateTime(long j3) {
        this.dateTime = j3;
    }

    public final void setDisplayNumber(@Nullable String str) {
        this.displayNumber = str;
    }

    public final void setEqqAccountFlag(long j3) {
        this.eqqAccountFlag = j3;
    }

    public final void setExtendType(int i3) {
        this.extendType = i3;
    }

    public final void setLastAIOReadTime(long j3) {
        this.lastAIOReadTime = j3;
    }

    public final void setLogo(@Nullable String str) {
        this.logo = str;
    }

    public final void setMComparePartInt(int i3) {
        this.mComparePartInt = i3;
    }

    public final void setMCompareSpell(@Nullable String str) {
        this.mCompareSpell = str;
    }

    public final void setMIsAgreeSyncLbs(boolean z16) {
        this.mIsAgreeSyncLbs = z16;
    }

    public final void setMIsSyncLbsSelected(boolean z16) {
        this.mIsSyncLbsSelected = z16;
    }

    public final void setMShowMsgFlag(int i3) {
        this.mShowMsgFlag = i3;
    }

    public final void setMarks(@Nullable HashMap<String, Integer> hashMap) {
        this.Marks = hashMap;
    }

    public final void setMessageSettingFlag(int i3) {
        this.messageSettingFlag = i3;
    }

    public final void setName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final void setOffLine(boolean z16) {
        this.isOffLine = z16;
    }

    public final void setOrderForMark(int i3) {
        this.orderForMark = i3;
    }

    public final void setRecvMsg(boolean z16) {
        this.isRecvMsg = z16;
    }

    public final void setRecvPush(boolean z16) {
        this.isRecvPush = z16;
    }

    public final void setShieldMsg(boolean z16) {
        this.isShieldMsg = z16;
    }

    public final void setShowFlag(int i3) {
        this.showFlag = i3;
    }

    public final void setSummary(@Nullable String str) {
        this.summary = str;
    }

    public final void setSyncLbs(boolean z16) {
        this.isSyncLbs = z16;
    }

    public final void setUid(@Nullable String str) {
        this.uid = str;
    }

    public final void setUin(long j3) {
        this.uin = j3;
    }

    public final void setUinStr(@Nullable String str) {
        this.uinStr = str;
    }
}
