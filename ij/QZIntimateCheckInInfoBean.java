package ij;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.feedcomponent.model.n;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.partner.signin.pb.GeneralSigninPB$Button;
import com.tencent.mobileqq.partner.signin.pb.GeneralSigninPB$Setting;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010!\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u00df\u0001\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e\u0012\b\b\u0002\u0010)\u001a\u00020\u0002\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010*\u0012\b\b\u0002\u00108\u001a\u00020\u0007\u0012\b\b\u0002\u0010<\u001a\u00020\u001f\u0012\b\b\u0002\u0010@\u001a\u00020\u0007\u0012\b\b\u0002\u0010C\u001a\u00020\u001f\u0012\b\b\u0002\u0010E\u001a\u00020\u0002\u0012\b\b\u0002\u0010G\u001a\u00020\u0002\u0012\b\b\u0002\u0010I\u001a\u00020\u0002\u0012\b\b\u0002\u0010K\u001a\u00020\u0002\u0012\b\b\u0002\u0010M\u001a\u00020\u0002\u0012\n\b\u0002\u0010P\u001a\u0004\u0018\u00010*\u0012\b\b\u0002\u0010S\u001a\u00020\u0007\u0012\b\b\u0002\u0010U\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010X\u001a\b\u0012\u0004\u0012\u00020V0\u001e\u00a2\u0006\u0004\bY\u0010ZJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0011\u0010\u0014R\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000eR\"\u0010\u001d\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\n\u001a\u0004\b\u001b\u0010\f\"\u0004\b\u001c\u0010\u000eR(\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010)\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\n\u001a\u0004\b'\u0010\f\"\u0004\b(\u0010\u000eR$\u00101\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00108\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u0010<\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u0018\u001a\u0004\b2\u00109\"\u0004\b:\u0010;R\"\u0010@\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u00103\u001a\u0004\b>\u00105\"\u0004\b?\u00107R\"\u0010C\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010\u0018\u001a\u0004\b+\u00109\"\u0004\bB\u0010;R\"\u0010E\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\bD\u0010\u000eR\"\u0010G\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010\n\u001a\u0004\b\u0016\u0010\f\"\u0004\bF\u0010\u000eR\"\u0010I\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u001a\u0010\f\"\u0004\bH\u0010\u000eR\"\u0010K\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\n\u001a\u0004\b \u0010\f\"\u0004\bJ\u0010\u000eR\"\u0010M\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u0010\n\u001a\u0004\b\t\u0010\f\"\u0004\bL\u0010\u000eR$\u0010P\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bN\u0010,\u001a\u0004\bA\u0010.\"\u0004\bO\u00100R\"\u0010S\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u00103\u001a\u0004\bQ\u00105\"\u0004\bR\u00107R\"\u0010U\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bL\u00103\u001a\u0004\bN\u00105\"\u0004\bT\u00107R(\u0010X\u001a\b\u0012\u0004\u0012\u00020V0\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bD\u0010!\u001a\u0004\b=\u0010#\"\u0004\bW\u0010%\u00a8\u0006["}, d2 = {"Lij/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getSpaceId", "()Ljava/lang/String;", "G", "(Ljava/lang/String;)V", "spaceId", "b", "I", DomainData.DOMAIN_NAME, "()I", "(I)V", "spaceType", "c", "o", "J", "themeColor", "d", "f", HippyTKDListViewAdapter.X, "calendarUrl", "", "", "e", "Ljava/util/List;", "i", "()Ljava/util/List;", "setMembers", "(Ljava/util/List;)V", "members", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "H", "spaceName", "Lcom/tencent/mobileqq/partner/signin/pb/GeneralSigninPB$Button;", "g", "Lcom/tencent/mobileqq/partner/signin/pb/GeneralSigninPB$Button;", "l", "()Lcom/tencent/mobileqq/partner/signin/pb/GeneralSigninPB$Button;", UserInfo.SEX_FEMALE, "(Lcom/tencent/mobileqq/partner/signin/pb/GeneralSigninPB$Button;)V", "signInBtn", tl.h.F, "Z", "p", "()Z", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "(Z)V", "isFriendCheckInAlready", "()J", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(J)V", "friendUin", "j", "r", BdhLogUtil.LogTag.Tag_Conn, "isSelfCheckInAlready", "k", "y", "checkInDays", "t", "calendarBackgroundUrl", "u", "calendarContent", "v", "calendarContentSource", "w", "calendarTips", ReportConstant.COSTREPORT_PREFIX, "arkShareImgUrl", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "E", "shareBtn", "getSupportResign", "setSupportResign", "supportResign", "B", "isMasterSpace", "Lcom/tencent/mobileqq/partner/signin/pb/GeneralSigninPB$Setting;", "D", "settingList", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/tencent/mobileqq/partner/signin/pb/GeneralSigninPB$Button;ZJZJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/partner/signin/pb/GeneralSigninPB$Button;ZZLjava/util/List;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: ij.b, reason: from toString */
/* loaded from: classes38.dex */
public final /* data */ class QZIntimateCheckInInfoBean {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private String spaceId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private int spaceType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private String themeColor;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private String calendarUrl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private List<Long> members;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private String spaceName;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private GeneralSigninPB$Button signInBtn;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isFriendCheckInAlready;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private long friendUin;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isSelfCheckInAlready;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    private long checkInDays;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    private String calendarBackgroundUrl;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    private String calendarContent;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata and from toString */
    private String calendarContentSource;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata and from toString */
    private String calendarTips;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata and from toString */
    private String arkShareImgUrl;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata and from toString */
    private GeneralSigninPB$Button shareBtn;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean supportResign;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isMasterSpace;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata and from toString */
    private List<GeneralSigninPB$Setting> settingList;

    public QZIntimateCheckInInfoBean() {
        this(null, 0, null, null, null, null, null, false, 0L, false, 0L, null, null, null, null, null, null, false, false, null, 1048575, null);
    }

    public final void A(long j3) {
        this.friendUin = j3;
    }

    public final void B(boolean z16) {
        this.isMasterSpace = z16;
    }

    public final void C(boolean z16) {
        this.isSelfCheckInAlready = z16;
    }

    public final void D(List<GeneralSigninPB$Setting> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.settingList = list;
    }

    public final void E(GeneralSigninPB$Button generalSigninPB$Button) {
        this.shareBtn = generalSigninPB$Button;
    }

    public final void F(GeneralSigninPB$Button generalSigninPB$Button) {
        this.signInBtn = generalSigninPB$Button;
    }

    public final void G(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.spaceId = str;
    }

    public final void H(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.spaceName = str;
    }

    public final void I(int i3) {
        this.spaceType = i3;
    }

    public final void J(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.themeColor = str;
    }

    /* renamed from: a, reason: from getter */
    public final String getArkShareImgUrl() {
        return this.arkShareImgUrl;
    }

    /* renamed from: b, reason: from getter */
    public final String getCalendarBackgroundUrl() {
        return this.calendarBackgroundUrl;
    }

    /* renamed from: c, reason: from getter */
    public final String getCalendarContent() {
        return this.calendarContent;
    }

    /* renamed from: d, reason: from getter */
    public final String getCalendarContentSource() {
        return this.calendarContentSource;
    }

    /* renamed from: e, reason: from getter */
    public final String getCalendarTips() {
        return this.calendarTips;
    }

    /* renamed from: f, reason: from getter */
    public final String getCalendarUrl() {
        return this.calendarUrl;
    }

    /* renamed from: g, reason: from getter */
    public final long getCheckInDays() {
        return this.checkInDays;
    }

    /* renamed from: h, reason: from getter */
    public final long getFriendUin() {
        return this.friendUin;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((((this.spaceId.hashCode() * 31) + this.spaceType) * 31) + this.themeColor.hashCode()) * 31) + this.calendarUrl.hashCode()) * 31) + this.members.hashCode()) * 31) + this.spaceName.hashCode()) * 31;
        GeneralSigninPB$Button generalSigninPB$Button = this.signInBtn;
        int hashCode2 = (hashCode + (generalSigninPB$Button == null ? 0 : generalSigninPB$Button.hashCode())) * 31;
        boolean z16 = this.isFriendCheckInAlready;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int a16 = (((hashCode2 + i3) * 31) + n.a(this.friendUin)) * 31;
        boolean z17 = this.isSelfCheckInAlready;
        int i16 = z17;
        if (z17 != 0) {
            i16 = 1;
        }
        int a17 = (((((((((((((a16 + i16) * 31) + n.a(this.checkInDays)) * 31) + this.calendarBackgroundUrl.hashCode()) * 31) + this.calendarContent.hashCode()) * 31) + this.calendarContentSource.hashCode()) * 31) + this.calendarTips.hashCode()) * 31) + this.arkShareImgUrl.hashCode()) * 31;
        GeneralSigninPB$Button generalSigninPB$Button2 = this.shareBtn;
        int hashCode3 = (a17 + (generalSigninPB$Button2 != null ? generalSigninPB$Button2.hashCode() : 0)) * 31;
        boolean z18 = this.supportResign;
        int i17 = z18;
        if (z18 != 0) {
            i17 = 1;
        }
        int i18 = (hashCode3 + i17) * 31;
        boolean z19 = this.isMasterSpace;
        return ((i18 + (z19 ? 1 : z19 ? 1 : 0)) * 31) + this.settingList.hashCode();
    }

    public final List<Long> i() {
        return this.members;
    }

    public final List<GeneralSigninPB$Setting> j() {
        return this.settingList;
    }

    /* renamed from: k, reason: from getter */
    public final GeneralSigninPB$Button getShareBtn() {
        return this.shareBtn;
    }

    /* renamed from: l, reason: from getter */
    public final GeneralSigninPB$Button getSignInBtn() {
        return this.signInBtn;
    }

    /* renamed from: m, reason: from getter */
    public final String getSpaceName() {
        return this.spaceName;
    }

    /* renamed from: n, reason: from getter */
    public final int getSpaceType() {
        return this.spaceType;
    }

    /* renamed from: o, reason: from getter */
    public final String getThemeColor() {
        return this.themeColor;
    }

    /* renamed from: p, reason: from getter */
    public final boolean getIsFriendCheckInAlready() {
        return this.isFriendCheckInAlready;
    }

    /* renamed from: q, reason: from getter */
    public final boolean getIsMasterSpace() {
        return this.isMasterSpace;
    }

    /* renamed from: r, reason: from getter */
    public final boolean getIsSelfCheckInAlready() {
        return this.isSelfCheckInAlready;
    }

    public final void s(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.arkShareImgUrl = str;
    }

    public final void t(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.calendarBackgroundUrl = str;
    }

    public final void u(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.calendarContent = str;
    }

    public final void v(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.calendarContentSource = str;
    }

    public final void w(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.calendarTips = str;
    }

    public final void x(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.calendarUrl = str;
    }

    public final void y(long j3) {
        this.checkInDays = j3;
    }

    public final void z(boolean z16) {
        this.isFriendCheckInAlready = z16;
    }

    public QZIntimateCheckInInfoBean(String spaceId, int i3, String themeColor, String calendarUrl, List<Long> members, String spaceName, GeneralSigninPB$Button generalSigninPB$Button, boolean z16, long j3, boolean z17, long j16, String calendarBackgroundUrl, String calendarContent, String calendarContentSource, String calendarTips, String arkShareImgUrl, GeneralSigninPB$Button generalSigninPB$Button2, boolean z18, boolean z19, List<GeneralSigninPB$Setting> settingList) {
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        Intrinsics.checkNotNullParameter(themeColor, "themeColor");
        Intrinsics.checkNotNullParameter(calendarUrl, "calendarUrl");
        Intrinsics.checkNotNullParameter(members, "members");
        Intrinsics.checkNotNullParameter(spaceName, "spaceName");
        Intrinsics.checkNotNullParameter(calendarBackgroundUrl, "calendarBackgroundUrl");
        Intrinsics.checkNotNullParameter(calendarContent, "calendarContent");
        Intrinsics.checkNotNullParameter(calendarContentSource, "calendarContentSource");
        Intrinsics.checkNotNullParameter(calendarTips, "calendarTips");
        Intrinsics.checkNotNullParameter(arkShareImgUrl, "arkShareImgUrl");
        Intrinsics.checkNotNullParameter(settingList, "settingList");
        this.spaceId = spaceId;
        this.spaceType = i3;
        this.themeColor = themeColor;
        this.calendarUrl = calendarUrl;
        this.members = members;
        this.spaceName = spaceName;
        this.signInBtn = generalSigninPB$Button;
        this.isFriendCheckInAlready = z16;
        this.friendUin = j3;
        this.isSelfCheckInAlready = z17;
        this.checkInDays = j16;
        this.calendarBackgroundUrl = calendarBackgroundUrl;
        this.calendarContent = calendarContent;
        this.calendarContentSource = calendarContentSource;
        this.calendarTips = calendarTips;
        this.arkShareImgUrl = arkShareImgUrl;
        this.shareBtn = generalSigninPB$Button2;
        this.supportResign = z18;
        this.isMasterSpace = z19;
        this.settingList = settingList;
    }

    public String toString() {
        return "QZIntimateCheckInInfoBean(spaceId=" + this.spaceId + ", spaceType=" + this.spaceType + ", themeColor=" + this.themeColor + ", calendarUrl=" + this.calendarUrl + ", members=" + this.members + ", spaceName=" + this.spaceName + ", signInBtn=" + this.signInBtn + ", isFriendCheckInAlready=" + this.isFriendCheckInAlready + ", friendUin=" + this.friendUin + ", isSelfCheckInAlready=" + this.isSelfCheckInAlready + ", checkInDays=" + this.checkInDays + ", calendarBackgroundUrl=" + this.calendarBackgroundUrl + ", calendarContent=" + this.calendarContent + ", calendarContentSource=" + this.calendarContentSource + ", calendarTips=" + this.calendarTips + ", arkShareImgUrl=" + this.arkShareImgUrl + ", shareBtn=" + this.shareBtn + ", supportResign=" + this.supportResign + ", isMasterSpace=" + this.isMasterSpace + ", settingList=" + this.settingList + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QZIntimateCheckInInfoBean)) {
            return false;
        }
        QZIntimateCheckInInfoBean qZIntimateCheckInInfoBean = (QZIntimateCheckInInfoBean) other;
        return Intrinsics.areEqual(this.spaceId, qZIntimateCheckInInfoBean.spaceId) && this.spaceType == qZIntimateCheckInInfoBean.spaceType && Intrinsics.areEqual(this.themeColor, qZIntimateCheckInInfoBean.themeColor) && Intrinsics.areEqual(this.calendarUrl, qZIntimateCheckInInfoBean.calendarUrl) && Intrinsics.areEqual(this.members, qZIntimateCheckInInfoBean.members) && Intrinsics.areEqual(this.spaceName, qZIntimateCheckInInfoBean.spaceName) && Intrinsics.areEqual(this.signInBtn, qZIntimateCheckInInfoBean.signInBtn) && this.isFriendCheckInAlready == qZIntimateCheckInInfoBean.isFriendCheckInAlready && this.friendUin == qZIntimateCheckInInfoBean.friendUin && this.isSelfCheckInAlready == qZIntimateCheckInInfoBean.isSelfCheckInAlready && this.checkInDays == qZIntimateCheckInInfoBean.checkInDays && Intrinsics.areEqual(this.calendarBackgroundUrl, qZIntimateCheckInInfoBean.calendarBackgroundUrl) && Intrinsics.areEqual(this.calendarContent, qZIntimateCheckInInfoBean.calendarContent) && Intrinsics.areEqual(this.calendarContentSource, qZIntimateCheckInInfoBean.calendarContentSource) && Intrinsics.areEqual(this.calendarTips, qZIntimateCheckInInfoBean.calendarTips) && Intrinsics.areEqual(this.arkShareImgUrl, qZIntimateCheckInInfoBean.arkShareImgUrl) && Intrinsics.areEqual(this.shareBtn, qZIntimateCheckInInfoBean.shareBtn) && this.supportResign == qZIntimateCheckInInfoBean.supportResign && this.isMasterSpace == qZIntimateCheckInInfoBean.isMasterSpace && Intrinsics.areEqual(this.settingList, qZIntimateCheckInInfoBean.settingList);
    }

    public /* synthetic */ QZIntimateCheckInInfoBean(String str, int i3, String str2, String str3, List list, String str4, GeneralSigninPB$Button generalSigninPB$Button, boolean z16, long j3, boolean z17, long j16, String str5, String str6, String str7, String str8, String str9, GeneralSigninPB$Button generalSigninPB$Button2, boolean z18, boolean z19, List list2, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? "" : str, (i16 & 2) != 0 ? -1 : i3, (i16 & 4) != 0 ? "" : str2, (i16 & 8) != 0 ? "" : str3, (i16 & 16) != 0 ? new ArrayList() : list, (i16 & 32) != 0 ? "" : str4, (i16 & 64) != 0 ? null : generalSigninPB$Button, (i16 & 128) != 0 ? false : z16, (i16 & 256) != 0 ? 0L : j3, (i16 & 512) != 0 ? false : z17, (i16 & 1024) == 0 ? j16 : 0L, (i16 & 2048) != 0 ? "" : str5, (i16 & 4096) != 0 ? "" : str6, (i16 & 8192) != 0 ? "" : str7, (i16 & 16384) != 0 ? "" : str8, (i16 & 32768) != 0 ? "" : str9, (i16 & 65536) != 0 ? null : generalSigninPB$Button2, (i16 & 131072) != 0 ? false : z18, (i16 & 262144) != 0 ? false : z19, (i16 & 524288) != 0 ? new ArrayList() : list2);
    }
}
