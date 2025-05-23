package com.qzone.reborn.route;

import com.qzone.proxy.feedcomponent.model.n;
import com.tencent.mobileqq.app.AppConstants;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b1\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u00a2\u0006\u0002\u0010\u0012J\t\u00100\u001a\u00020\u0003H\u00c6\u0003J\t\u00101\u001a\u00020\tH\u00c6\u0003J\t\u00102\u001a\u00020\tH\u00c6\u0003J\t\u00103\u001a\u00020\rH\u00c6\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u00107\u001a\u00020\tH\u00c6\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010:\u001a\u00020\rH\u00c6\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u008d\u0001\u0010<\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\t2\b\b\u0002\u0010\u0011\u001a\u00020\rH\u00c6\u0001J\u0013\u0010=\u001a\u00020\t2\b\u0010>\u001a\u0004\u0018\u00010?H\u00d6\u0003J\t\u0010@\u001a\u00020\rH\u00d6\u0001J\t\u0010A\u001a\u00020\u0005H\u00d6\u0001R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR\u001a\u0010\u000f\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010!\"\u0004\b\"\u0010#R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010!\"\u0004\b$\u0010#R\u001a\u0010\u0010\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010!\"\u0004\b%\u0010#R\u001a\u0010\u0011\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0014\"\u0004\b'\u0010\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0018\"\u0004\b)\u0010\u001aR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0018\"\u0004\b/\u0010\u001a\u00a8\u0006B"}, d2 = {"Lcom/qzone/reborn/route/QZoneUserHomeBean;", "Ljava/io/Serializable;", "uin", "", AppConstants.Key.KEY_QZONE_UGCKEY, "", "uuid", "extInfo", "isFromQAV", "", "bottomBubbleUrl", "bottomBubbleText", "actionType", "", "actionUrl", "isFamousSpace", "isShowFacade", "loginFrom", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ILjava/lang/String;ZZI)V", "getActionType", "()I", "setActionType", "(I)V", "getActionUrl", "()Ljava/lang/String;", "setActionUrl", "(Ljava/lang/String;)V", "getBottomBubbleText", "setBottomBubbleText", "getBottomBubbleUrl", "setBottomBubbleUrl", "getExtInfo", "setExtInfo", "()Z", "setFamousSpace", "(Z)V", "setFromQAV", "setShowFacade", "getLoginFrom", "setLoginFrom", "getUgcKey", "setUgcKey", "getUin", "()J", "setUin", "(J)V", "getUuid", "setUuid", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "toString", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final /* data */ class QZoneUserHomeBean implements Serializable {
    private int actionType;
    private String actionUrl;
    private String bottomBubbleText;
    private String bottomBubbleUrl;
    private String extInfo;
    private boolean isFamousSpace;
    private boolean isFromQAV;
    private boolean isShowFacade;
    private int loginFrom;
    private String ugcKey;
    private long uin;
    private String uuid;

    public QZoneUserHomeBean() {
        this(0L, null, null, null, false, null, null, 0, null, false, false, 0, 4095, null);
    }

    /* renamed from: component1, reason: from getter */
    public final long getUin() {
        return this.uin;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getIsFamousSpace() {
        return this.isFamousSpace;
    }

    /* renamed from: component11, reason: from getter */
    public final boolean getIsShowFacade() {
        return this.isShowFacade;
    }

    /* renamed from: component12, reason: from getter */
    public final int getLoginFrom() {
        return this.loginFrom;
    }

    /* renamed from: component2, reason: from getter */
    public final String getUgcKey() {
        return this.ugcKey;
    }

    /* renamed from: component3, reason: from getter */
    public final String getUuid() {
        return this.uuid;
    }

    /* renamed from: component4, reason: from getter */
    public final String getExtInfo() {
        return this.extInfo;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getIsFromQAV() {
        return this.isFromQAV;
    }

    /* renamed from: component6, reason: from getter */
    public final String getBottomBubbleUrl() {
        return this.bottomBubbleUrl;
    }

    /* renamed from: component7, reason: from getter */
    public final String getBottomBubbleText() {
        return this.bottomBubbleText;
    }

    /* renamed from: component8, reason: from getter */
    public final int getActionType() {
        return this.actionType;
    }

    /* renamed from: component9, reason: from getter */
    public final String getActionUrl() {
        return this.actionUrl;
    }

    public final QZoneUserHomeBean copy(long uin, String ugcKey, String uuid, String extInfo, boolean isFromQAV, String bottomBubbleUrl, String bottomBubbleText, int actionType, String actionUrl, boolean isFamousSpace, boolean isShowFacade, int loginFrom) {
        return new QZoneUserHomeBean(uin, ugcKey, uuid, extInfo, isFromQAV, bottomBubbleUrl, bottomBubbleText, actionType, actionUrl, isFamousSpace, isShowFacade, loginFrom);
    }

    public final int getActionType() {
        return this.actionType;
    }

    public final String getActionUrl() {
        return this.actionUrl;
    }

    public final String getBottomBubbleText() {
        return this.bottomBubbleText;
    }

    public final String getBottomBubbleUrl() {
        return this.bottomBubbleUrl;
    }

    public final String getExtInfo() {
        return this.extInfo;
    }

    public final int getLoginFrom() {
        return this.loginFrom;
    }

    public final String getUgcKey() {
        return this.ugcKey;
    }

    public final long getUin() {
        return this.uin;
    }

    public final String getUuid() {
        return this.uuid;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int a16 = n.a(this.uin) * 31;
        String str = this.ugcKey;
        int hashCode = (a16 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.uuid;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.extInfo;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        boolean z16 = this.isFromQAV;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode3 + i3) * 31;
        String str4 = this.bottomBubbleUrl;
        int hashCode4 = (i16 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.bottomBubbleText;
        int hashCode5 = (((hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31) + this.actionType) * 31;
        String str6 = this.actionUrl;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        boolean z17 = this.isFamousSpace;
        int i17 = z17;
        if (z17 != 0) {
            i17 = 1;
        }
        int i18 = (hashCode6 + i17) * 31;
        boolean z18 = this.isShowFacade;
        return ((i18 + (z18 ? 1 : z18 ? 1 : 0)) * 31) + this.loginFrom;
    }

    public final boolean isFamousSpace() {
        return this.isFamousSpace;
    }

    public final boolean isFromQAV() {
        return this.isFromQAV;
    }

    public final boolean isShowFacade() {
        return this.isShowFacade;
    }

    public final void setActionType(int i3) {
        this.actionType = i3;
    }

    public final void setActionUrl(String str) {
        this.actionUrl = str;
    }

    public final void setBottomBubbleText(String str) {
        this.bottomBubbleText = str;
    }

    public final void setBottomBubbleUrl(String str) {
        this.bottomBubbleUrl = str;
    }

    public final void setExtInfo(String str) {
        this.extInfo = str;
    }

    public final void setFamousSpace(boolean z16) {
        this.isFamousSpace = z16;
    }

    public final void setFromQAV(boolean z16) {
        this.isFromQAV = z16;
    }

    public final void setLoginFrom(int i3) {
        this.loginFrom = i3;
    }

    public final void setShowFacade(boolean z16) {
        this.isShowFacade = z16;
    }

    public final void setUgcKey(String str) {
        this.ugcKey = str;
    }

    public final void setUin(long j3) {
        this.uin = j3;
    }

    public final void setUuid(String str) {
        this.uuid = str;
    }

    public String toString() {
        return "QZoneUserHomeBean(uin=" + this.uin + ", ugcKey=" + this.ugcKey + ", uuid=" + this.uuid + ", extInfo=" + this.extInfo + ", isFromQAV=" + this.isFromQAV + ", bottomBubbleUrl=" + this.bottomBubbleUrl + ", bottomBubbleText=" + this.bottomBubbleText + ", actionType=" + this.actionType + ", actionUrl=" + this.actionUrl + ", isFamousSpace=" + this.isFamousSpace + ", isShowFacade=" + this.isShowFacade + ", loginFrom=" + this.loginFrom + ")";
    }

    public QZoneUserHomeBean(long j3, String str, String str2, String str3, boolean z16, String str4, String str5, int i3, String str6, boolean z17, boolean z18, int i16) {
        this.uin = j3;
        this.ugcKey = str;
        this.uuid = str2;
        this.extInfo = str3;
        this.isFromQAV = z16;
        this.bottomBubbleUrl = str4;
        this.bottomBubbleText = str5;
        this.actionType = i3;
        this.actionUrl = str6;
        this.isFamousSpace = z17;
        this.isShowFacade = z18;
        this.loginFrom = i16;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QZoneUserHomeBean)) {
            return false;
        }
        QZoneUserHomeBean qZoneUserHomeBean = (QZoneUserHomeBean) other;
        return this.uin == qZoneUserHomeBean.uin && Intrinsics.areEqual(this.ugcKey, qZoneUserHomeBean.ugcKey) && Intrinsics.areEqual(this.uuid, qZoneUserHomeBean.uuid) && Intrinsics.areEqual(this.extInfo, qZoneUserHomeBean.extInfo) && this.isFromQAV == qZoneUserHomeBean.isFromQAV && Intrinsics.areEqual(this.bottomBubbleUrl, qZoneUserHomeBean.bottomBubbleUrl) && Intrinsics.areEqual(this.bottomBubbleText, qZoneUserHomeBean.bottomBubbleText) && this.actionType == qZoneUserHomeBean.actionType && Intrinsics.areEqual(this.actionUrl, qZoneUserHomeBean.actionUrl) && this.isFamousSpace == qZoneUserHomeBean.isFamousSpace && this.isShowFacade == qZoneUserHomeBean.isShowFacade && this.loginFrom == qZoneUserHomeBean.loginFrom;
    }

    public /* synthetic */ QZoneUserHomeBean(long j3, String str, String str2, String str3, boolean z16, String str4, String str5, int i3, String str6, boolean z17, boolean z18, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? 0L : j3, (i17 & 2) != 0 ? null : str, (i17 & 4) != 0 ? null : str2, (i17 & 8) != 0 ? null : str3, (i17 & 16) != 0 ? false : z16, (i17 & 32) != 0 ? null : str4, (i17 & 64) == 0 ? str5 : null, (i17 & 128) != 0 ? 0 : i3, (i17 & 256) != 0 ? "" : str6, (i17 & 512) != 0 ? false : z17, (i17 & 1024) != 0 ? true : z18, (i17 & 2048) == 0 ? i16 : 0);
    }
}
