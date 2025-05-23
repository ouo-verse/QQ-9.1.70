package com.tencent.state.publicchat.data;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.state.square.SquareBaseKt;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\u000eJ\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010 \u001a\u00020\u0003H\u00c6\u0003J\t\u0010!\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\"\u001a\u00020\bH\u00c6\u0003J\t\u0010#\u001a\u00020\u0003H\u00c6\u0003J\t\u0010$\u001a\u00020\u000bH\u00c6\u0003J\t\u0010%\u001a\u00020\u000bH\u00c6\u0003J\t\u0010&\u001a\u00020\u000bH\u00c6\u0003JY\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000bH\u00c6\u0001J\u0013\u0010(\u001a\u00020\u000b2\b\u0010)\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010*\u001a\u00020\u0003H\u00d6\u0001J\u0010\u0010+\u001a\u00020\u000b2\b\u0010,\u001a\u0004\u0018\u00010\u0000J\t\u0010-\u001a\u00020\u0016H\u00d6\u0001R\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\r\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u00168F\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0011\u0010\f\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0010\u00a8\u0006."}, d2 = {"Lcom/tencent/state/publicchat/data/ShowMsgPanelParams;", "", HippyTKDListViewAdapter.X, "", "y", "msg", "Lcom/tencent/state/publicchat/data/MsgInfo;", QCircleAlphaUserReporter.KEY_USER, "Lcom/tencent/state/publicchat/data/UserInfo;", "appId", "showReport", "", "showSayHi", IProfileProtocolConst.PARAM_IS_FRIEND, "(IILcom/tencent/state/publicchat/data/MsgInfo;Lcom/tencent/state/publicchat/data/UserInfo;IZZZ)V", "getAppId", "()I", "()Z", "isMyMsg", "getMsg", "()Lcom/tencent/state/publicchat/data/MsgInfo;", "msgUin", "", "getMsgUin", "()Ljava/lang/String;", "getShowReport", "getShowSayHi", "getUser", "()Lcom/tencent/state/publicchat/data/UserInfo;", "getX", "getY", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "isSame", "newParam", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class ShowMsgPanelParams {
    private final int appId;
    private final boolean isFriend;
    private final MsgInfo msg;
    private final boolean showReport;
    private final boolean showSayHi;
    private final UserInfo user;
    private final int x;
    private final int y;

    public ShowMsgPanelParams(int i3, int i16, MsgInfo msg2, UserInfo user, int i17, boolean z16, boolean z17, boolean z18) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(user, "user");
        this.x = i3;
        this.y = i16;
        this.msg = msg2;
        this.user = user;
        this.appId = i17;
        this.showReport = z16;
        this.showSayHi = z17;
        this.isFriend = z18;
    }

    /* renamed from: component1, reason: from getter */
    public final int getX() {
        return this.x;
    }

    /* renamed from: component2, reason: from getter */
    public final int getY() {
        return this.y;
    }

    /* renamed from: component3, reason: from getter */
    public final MsgInfo getMsg() {
        return this.msg;
    }

    /* renamed from: component4, reason: from getter */
    public final UserInfo getUser() {
        return this.user;
    }

    /* renamed from: component5, reason: from getter */
    public final int getAppId() {
        return this.appId;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getShowReport() {
        return this.showReport;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getShowSayHi() {
        return this.showSayHi;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getIsFriend() {
        return this.isFriend;
    }

    public final ShowMsgPanelParams copy(int x16, int y16, MsgInfo msg2, UserInfo user, int appId, boolean showReport, boolean showSayHi, boolean isFriend) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(user, "user");
        return new ShowMsgPanelParams(x16, y16, msg2, user, appId, showReport, showSayHi, isFriend);
    }

    public final int getAppId() {
        return this.appId;
    }

    public final MsgInfo getMsg() {
        return this.msg;
    }

    public final String getMsgUin() {
        return String.valueOf(this.msg.getUser().getUin());
    }

    public final boolean getShowReport() {
        return this.showReport;
    }

    public final boolean getShowSayHi() {
        return this.showSayHi;
    }

    public final UserInfo getUser() {
        return this.user;
    }

    public final int getX() {
        return this.x;
    }

    public final int getY() {
        return this.y;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3 = ((this.x * 31) + this.y) * 31;
        MsgInfo msgInfo = this.msg;
        int hashCode = (i3 + (msgInfo != null ? msgInfo.hashCode() : 0)) * 31;
        UserInfo userInfo = this.user;
        int hashCode2 = (((hashCode + (userInfo != null ? userInfo.hashCode() : 0)) * 31) + this.appId) * 31;
        boolean z16 = this.showReport;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int i17 = (hashCode2 + i16) * 31;
        boolean z17 = this.showSayHi;
        int i18 = z17;
        if (z17 != 0) {
            i18 = 1;
        }
        int i19 = (i17 + i18) * 31;
        boolean z18 = this.isFriend;
        return i19 + (z18 ? 1 : z18 ? 1 : 0);
    }

    public final boolean isFriend() {
        return this.isFriend;
    }

    public final boolean isMyMsg() {
        return Intrinsics.areEqual(getMsgUin(), SquareBaseKt.getSquareCommon().getCurrentAccountUin());
    }

    public String toString() {
        return "ShowMsgPanelParams(x=" + this.x + ", y=" + this.y + ", msg=" + this.msg + ", user=" + this.user + ", appId=" + this.appId + ", showReport=" + this.showReport + ", showSayHi=" + this.showSayHi + ", isFriend=" + this.isFriend + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShowMsgPanelParams)) {
            return false;
        }
        ShowMsgPanelParams showMsgPanelParams = (ShowMsgPanelParams) other;
        return this.x == showMsgPanelParams.x && this.y == showMsgPanelParams.y && Intrinsics.areEqual(this.msg, showMsgPanelParams.msg) && Intrinsics.areEqual(this.user, showMsgPanelParams.user) && this.appId == showMsgPanelParams.appId && this.showReport == showMsgPanelParams.showReport && this.showSayHi == showMsgPanelParams.showSayHi && this.isFriend == showMsgPanelParams.isFriend;
    }

    public final boolean isSame(ShowMsgPanelParams newParam) {
        return newParam != null && this.x == newParam.x && this.y == newParam.y && this.msg.getHeader().getMsgId() == newParam.msg.getHeader().getMsgId() && this.appId == newParam.appId && this.showReport == newParam.showReport;
    }
}
