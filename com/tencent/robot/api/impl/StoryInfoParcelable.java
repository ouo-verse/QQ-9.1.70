package com.tencent.robot.api.impl;

import android.os.Parcel;
import android.os.Parcelable;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b7\u0018\u0000 G2\u00020\u0001:\u0001'B\u0007\u00a2\u0006\u0004\bD\u0010EB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\bD\u0010FJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001b\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\"\u0010\u001f\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u0013\u001a\u0004\b\u001d\u0010\u0015\"\u0004\b\u001e\u0010\u0017R\"\u0010\"\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u0013\u001a\u0004\b\u0012\u0010\u0015\"\u0004\b!\u0010\u0017R\"\u0010%\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0013\u001a\u0004\b#\u0010\u0015\"\u0004\b$\u0010\u0017R\"\u0010)\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010\u0013\u001a\u0004\b'\u0010\u0015\"\u0004\b(\u0010\u0017R\"\u0010-\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010\u0013\u001a\u0004\b+\u0010\u0015\"\u0004\b,\u0010\u0017R\"\u00101\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010\u0013\u001a\u0004\b/\u0010\u0015\"\u0004\b0\u0010\u0017R\"\u00105\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010\u0013\u001a\u0004\b3\u0010\u0015\"\u0004\b4\u0010\u0017R\"\u00109\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010\u0013\u001a\u0004\b7\u0010\u0015\"\u0004\b8\u0010\u0017R\"\u0010=\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010\u0013\u001a\u0004\b;\u0010\u0015\"\u0004\b<\u0010\u0017R\"\u0010C\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010B\u00a8\u0006H"}, d2 = {"Lcom/tencent/robot/api/impl/StoryInfoParcelable;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "d", "J", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()J", HippyTKDListViewAdapter.X, "(J)V", QQWinkConstants.STORY_ID, "", "e", "Ljava/lang/String;", "getUin", "()Ljava/lang/String;", "setUin", "(Ljava/lang/String;)V", "uin", "f", ReportConstant.COSTREPORT_PREFIX, "name", tl.h.F, "getTitle", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "title", "i", "r", "introduce", "l", "w", "pic", BdhLogUtil.LogTag.Tag_Conn, "a", "o", "dayBackground", "D", "g", "t", "nightBackground", "E", "b", "p", "dayBackgroundColor", UserInfo.SEX_FEMALE, "j", "u", "nightBackgroundColor", "G", "c", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "dayDynamicPic", "H", "k", "v", "nightDynamicPic", "I", DomainData.DOMAIN_NAME, "()I", "y", "(I)V", "storyType", "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class StoryInfoParcelable implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private String dayBackground;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private String nightBackground;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private String dayBackgroundColor;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private String nightBackgroundColor;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private String dayDynamicPic;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private String nightDynamicPic;

    /* renamed from: I, reason: from kotlin metadata */
    private int storyType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long storyId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String uin;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String name;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String title;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String introduce;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String pic;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/robot/api/impl/StoryInfoParcelable$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/robot/api/impl/StoryInfoParcelable;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/robot/api/impl/StoryInfoParcelable;", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.api.impl.StoryInfoParcelable$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion implements Parcelable.Creator<StoryInfoParcelable> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public StoryInfoParcelable createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new StoryInfoParcelable(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public StoryInfoParcelable[] newArray(int size) {
            return new StoryInfoParcelable[size];
        }

        Companion() {
        }
    }

    public StoryInfoParcelable() {
        this.uin = "";
        this.name = "";
        this.title = "";
        this.introduce = "";
        this.pic = "";
        this.dayBackground = "";
        this.nightBackground = "";
        this.dayBackgroundColor = "";
        this.nightBackgroundColor = "";
        this.dayDynamicPic = "";
        this.nightDynamicPic = "";
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getDayBackground() {
        return this.dayBackground;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getDayBackgroundColor() {
        return this.dayBackgroundColor;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getDayDynamicPic() {
        return this.dayDynamicPic;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getIntroduce() {
        return this.introduce;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getNightBackground() {
        return this.nightBackground;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public final String getNightBackgroundColor() {
        return this.nightBackgroundColor;
    }

    @NotNull
    /* renamed from: k, reason: from getter */
    public final String getNightDynamicPic() {
        return this.nightDynamicPic;
    }

    @NotNull
    /* renamed from: l, reason: from getter */
    public final String getPic() {
        return this.pic;
    }

    /* renamed from: m, reason: from getter */
    public final long getStoryId() {
        return this.storyId;
    }

    /* renamed from: n, reason: from getter */
    public final int getStoryType() {
        return this.storyType;
    }

    public final void o(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.dayBackground = str;
    }

    public final void p(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.dayBackgroundColor = str;
    }

    public final void q(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.dayDynamicPic = str;
    }

    public final void r(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.introduce = str;
    }

    public final void s(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final void t(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.nightBackground = str;
    }

    public final void u(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.nightBackgroundColor = str;
    }

    public final void v(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.nightDynamicPic = str;
    }

    public final void w(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.pic = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.storyId);
        parcel.writeString(this.uin);
        parcel.writeString(this.name);
        parcel.writeString(this.title);
        parcel.writeString(this.introduce);
        parcel.writeString(this.pic);
        parcel.writeString(this.dayBackground);
        parcel.writeString(this.nightBackground);
        parcel.writeString(this.dayBackgroundColor);
        parcel.writeString(this.nightBackgroundColor);
        parcel.writeString(this.dayDynamicPic);
        parcel.writeString(this.nightDynamicPic);
        parcel.writeInt(this.storyType);
    }

    public final void x(long j3) {
        this.storyId = j3;
    }

    public final void y(int i3) {
        this.storyType = i3;
    }

    public final void z(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StoryInfoParcelable(@NotNull Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.storyId = parcel.readLong();
        String readString = parcel.readString();
        this.uin = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        this.name = readString2 == null ? "" : readString2;
        String readString3 = parcel.readString();
        this.title = readString3 == null ? "" : readString3;
        String readString4 = parcel.readString();
        this.introduce = readString4 == null ? "" : readString4;
        String readString5 = parcel.readString();
        this.pic = readString5 == null ? "" : readString5;
        String readString6 = parcel.readString();
        this.dayBackground = readString6 == null ? "" : readString6;
        String readString7 = parcel.readString();
        this.nightBackground = readString7 == null ? "" : readString7;
        String readString8 = parcel.readString();
        this.dayBackgroundColor = readString8 == null ? "" : readString8;
        String readString9 = parcel.readString();
        this.nightBackgroundColor = readString9 == null ? "" : readString9;
        String readString10 = parcel.readString();
        this.dayDynamicPic = readString10 == null ? "" : readString10;
        String readString11 = parcel.readString();
        this.nightDynamicPic = readString11 != null ? readString11 : "";
        this.storyType = parcel.readInt();
    }
}
