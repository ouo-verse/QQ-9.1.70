package com.tencent.mobileqq.winkpublish.report;

import android.os.Parcel;
import android.os.Parcelable;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\t\n\u0002\b\u0019\b\u0086\b\u0018\u0000 B2\u00020\u0001:\u0002-\u0012Bk\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0004\u0012\b\b\u0002\u0010!\u001a\u00020\t\u0012\b\b\u0002\u0010%\u001a\u00020\u0004\u0012\b\b\u0002\u0010)\u001a\u00020\t\u0012\b\b\u0002\u00100\u001a\u00020*\u0012\b\b\u0002\u00104\u001a\u00020\t\u0012\b\b\u0002\u00107\u001a\u00020\t\u0012\b\b\u0002\u0010:\u001a\u00020\t\u0012\b\b\u0002\u0010>\u001a\u00020\t\u00a2\u0006\u0004\b?\u0010@B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b?\u0010AJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\t\u0010\u000b\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u00d6\u0003R\"\u0010\u0016\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001a\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\"\u0010!\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010%\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u0011\u001a\u0004\b#\u0010\u0013\"\u0004\b$\u0010\u0015R\"\u0010)\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010\u001c\u001a\u0004\b'\u0010\u001e\"\u0004\b(\u0010 R\"\u00100\u001a\u00020*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b+\u0010/R\"\u00104\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u0010\u001c\u001a\u0004\b2\u0010\u001e\"\u0004\b3\u0010 R\"\u00107\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u0010\u001c\u001a\u0004\b\u0017\u0010\u001e\"\u0004\b6\u0010 R\"\u0010:\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u0010\u001c\u001a\u0004\b\u001b\u0010\u001e\"\u0004\b9\u0010 R\"\u0010>\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010\u001c\u001a\u0004\b<\u0010\u001e\"\u0004\b=\u0010 \u00a8\u0006C"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/report/WinkDc5507ReportData;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "toString", "hashCode", "", "other", "", "equals", "d", "I", "b", "()I", DomainData.DOMAIN_NAME, "(I)V", "actionType", "e", "l", "v", "subActionType", "f", "Ljava/lang/String;", "g", "()Ljava/lang/String;", ReportConstant.COSTREPORT_PREFIX, "(Ljava/lang/String;)V", "feedId", h.F, "j", "t", "position", "i", "k", "u", "sealTransfer", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "J", "a", "()J", "(J)V", "actTime", BdhLogUtil.LogTag.Tag_Conn, "c", "p", "ext4", "D", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "ext5", "E", "r", "ext6", UserInfo.SEX_FEMALE, "getAuthorUin", "o", "authorUin", "<init>", "(IILjava/lang/String;ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "(Landroid/os/Parcel;)V", "CREATOR", "qq-winkpublish-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final /* data */ class WinkDc5507ReportData implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata and from toString */
    @NotNull
    private String ext4;

    /* renamed from: D, reason: from kotlin metadata and from toString */
    @NotNull
    private String ext5;

    /* renamed from: E, reason: from kotlin metadata and from toString */
    @NotNull
    private String ext6;

    /* renamed from: F, reason: from kotlin metadata and from toString */
    @NotNull
    private String authorUin;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private int actionType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private int subActionType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String feedId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private int position;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String sealTransfer;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    private long actTime;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0007\u0010\u0005J\u0010\u0010\n\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0017\u0010\f\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\f\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\bJ\u0017\u0010\u0011\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u0016\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u0018\u001a\u00020\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\bJ\u0006\u0010\u001a\u001a\u00020\u0019R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/report/WinkDc5507ReportData$a;", "", "", "actionType", "b", "(Ljava/lang/Integer;)Lcom/tencent/mobileqq/winkpublish/report/WinkDc5507ReportData$a;", "subActionType", "j", "", "feedId", "g", "position", h.F, "sealTransfer", "i", "", "actTime", "a", "(Ljava/lang/Long;)Lcom/tencent/mobileqq/winkpublish/report/WinkDc5507ReportData$a;", "ext4", "e", "ext5", "f", "uin", "c", "Lcom/tencent/mobileqq/winkpublish/report/WinkDc5507ReportData;", "d", "Lcom/tencent/mobileqq/winkpublish/report/WinkDc5507ReportData;", "data", "<init>", "()V", "qq-winkpublish-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WinkDc5507ReportData data = new WinkDc5507ReportData(0, 0, null, 0, null, 0, null, null, null, null, 1023, null);

        @NotNull
        public final a a(@Nullable Long actTime) {
            long j3;
            WinkDc5507ReportData winkDc5507ReportData = this.data;
            if (actTime != null) {
                j3 = actTime.longValue();
            } else {
                j3 = 0;
            }
            winkDc5507ReportData.m(j3);
            return this;
        }

        @NotNull
        public final a b(@Nullable Integer actionType) {
            int i3;
            WinkDc5507ReportData winkDc5507ReportData = this.data;
            if (actionType != null) {
                i3 = actionType.intValue();
            } else {
                i3 = 0;
            }
            winkDc5507ReportData.n(i3);
            return this;
        }

        @NotNull
        public final a c(@Nullable String uin) {
            WinkDc5507ReportData winkDc5507ReportData = this.data;
            if (uin == null) {
                uin = "";
            }
            winkDc5507ReportData.o(uin);
            return this;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final WinkDc5507ReportData getData() {
            return this.data;
        }

        @NotNull
        public final a e(@Nullable String ext4) {
            WinkDc5507ReportData winkDc5507ReportData = this.data;
            if (ext4 == null) {
                ext4 = "";
            }
            winkDc5507ReportData.p(ext4);
            return this;
        }

        @NotNull
        public final a f(@Nullable String ext5) {
            WinkDc5507ReportData winkDc5507ReportData = this.data;
            if (ext5 == null) {
                ext5 = "";
            }
            winkDc5507ReportData.q(ext5);
            return this;
        }

        @NotNull
        public final a g(@Nullable String feedId) {
            WinkDc5507ReportData winkDc5507ReportData = this.data;
            if (feedId == null) {
                feedId = "";
            }
            winkDc5507ReportData.s(feedId);
            return this;
        }

        @NotNull
        public final a h(@Nullable Integer position) {
            int i3;
            WinkDc5507ReportData winkDc5507ReportData = this.data;
            if (position != null) {
                i3 = position.intValue();
            } else {
                i3 = 0;
            }
            winkDc5507ReportData.t(i3);
            return this;
        }

        @NotNull
        public final a i(@Nullable String sealTransfer) {
            WinkDc5507ReportData winkDc5507ReportData = this.data;
            if (sealTransfer == null) {
                sealTransfer = "";
            }
            winkDc5507ReportData.u(sealTransfer);
            return this;
        }

        @NotNull
        public final a j(@Nullable Integer subActionType) {
            int i3;
            WinkDc5507ReportData winkDc5507ReportData = this.data;
            if (subActionType != null) {
                i3 = subActionType.intValue();
            } else {
                i3 = 0;
            }
            winkDc5507ReportData.v(i3);
            return this;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/report/WinkDc5507ReportData$b;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/winkpublish/report/WinkDc5507ReportData;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/winkpublish/report/WinkDc5507ReportData;", "<init>", "()V", "qq-winkpublish-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.winkpublish.report.WinkDc5507ReportData$b, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion implements Parcelable.Creator<WinkDc5507ReportData> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public WinkDc5507ReportData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new WinkDc5507ReportData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public WinkDc5507ReportData[] newArray(int size) {
            return new WinkDc5507ReportData[size];
        }

        Companion() {
        }
    }

    public WinkDc5507ReportData() {
        this(0, 0, null, 0, null, 0L, null, null, null, null, 1023, null);
    }

    /* renamed from: a, reason: from getter */
    public final long getActTime() {
        return this.actTime;
    }

    /* renamed from: b, reason: from getter */
    public final int getActionType() {
        return this.actionType;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getExt4() {
        return this.ext4;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getExt5() {
        return this.ext5;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WinkDc5507ReportData)) {
            return false;
        }
        WinkDc5507ReportData winkDc5507ReportData = (WinkDc5507ReportData) other;
        if (this.actionType == winkDc5507ReportData.actionType && this.subActionType == winkDc5507ReportData.subActionType && Intrinsics.areEqual(this.feedId, winkDc5507ReportData.feedId) && this.position == winkDc5507ReportData.position && Intrinsics.areEqual(this.sealTransfer, winkDc5507ReportData.sealTransfer) && this.actTime == winkDc5507ReportData.actTime && Intrinsics.areEqual(this.ext4, winkDc5507ReportData.ext4) && Intrinsics.areEqual(this.ext5, winkDc5507ReportData.ext5) && Intrinsics.areEqual(this.ext6, winkDc5507ReportData.ext6) && Intrinsics.areEqual(this.authorUin, winkDc5507ReportData.authorUin)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getExt6() {
        return this.ext6;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getFeedId() {
        return this.feedId;
    }

    public int hashCode() {
        return (((((((((((((((((this.actionType * 31) + this.subActionType) * 31) + this.feedId.hashCode()) * 31) + this.position) * 31) + this.sealTransfer.hashCode()) * 31) + androidx.fragment.app.a.a(this.actTime)) * 31) + this.ext4.hashCode()) * 31) + this.ext5.hashCode()) * 31) + this.ext6.hashCode()) * 31) + this.authorUin.hashCode();
    }

    /* renamed from: j, reason: from getter */
    public final int getPosition() {
        return this.position;
    }

    @NotNull
    /* renamed from: k, reason: from getter */
    public final String getSealTransfer() {
        return this.sealTransfer;
    }

    /* renamed from: l, reason: from getter */
    public final int getSubActionType() {
        return this.subActionType;
    }

    public final void m(long j3) {
        this.actTime = j3;
    }

    public final void n(int i3) {
        this.actionType = i3;
    }

    public final void o(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.authorUin = str;
    }

    public final void p(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ext4 = str;
    }

    public final void q(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ext5 = str;
    }

    public final void r(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ext6 = str;
    }

    public final void s(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.feedId = str;
    }

    public final void t(int i3) {
        this.position = i3;
    }

    @NotNull
    public String toString() {
        return "WinkDc5507ReportData(actionType=" + this.actionType + ", subActionType=" + this.subActionType + ", feedId=" + this.feedId + ", position=" + this.position + ", sealTransfer=" + this.sealTransfer + ", actTime=" + this.actTime + ", ext4=" + this.ext4 + ", ext5=" + this.ext5 + ", ext6=" + this.ext6 + ", authorUin=" + this.authorUin + ")";
    }

    public final void u(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sealTransfer = str;
    }

    public final void v(int i3) {
        this.subActionType = i3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.actionType);
        parcel.writeInt(this.subActionType);
        parcel.writeString(this.feedId);
        parcel.writeInt(this.position);
        parcel.writeString(this.sealTransfer);
        parcel.writeLong(this.actTime);
        parcel.writeString(this.ext4);
        parcel.writeString(this.ext5);
        parcel.writeString(this.ext6);
        parcel.writeString(this.authorUin);
    }

    public WinkDc5507ReportData(int i3, int i16, @NotNull String feedId, int i17, @NotNull String sealTransfer, long j3, @NotNull String ext4, @NotNull String ext5, @NotNull String ext6, @NotNull String authorUin) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(sealTransfer, "sealTransfer");
        Intrinsics.checkNotNullParameter(ext4, "ext4");
        Intrinsics.checkNotNullParameter(ext5, "ext5");
        Intrinsics.checkNotNullParameter(ext6, "ext6");
        Intrinsics.checkNotNullParameter(authorUin, "authorUin");
        this.actionType = i3;
        this.subActionType = i16;
        this.feedId = feedId;
        this.position = i17;
        this.sealTransfer = sealTransfer;
        this.actTime = j3;
        this.ext4 = ext4;
        this.ext5 = ext5;
        this.ext6 = ext6;
        this.authorUin = authorUin;
    }

    public /* synthetic */ WinkDc5507ReportData(int i3, int i16, String str, int i17, String str2, long j3, String str3, String str4, String str5, String str6, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this((i18 & 1) != 0 ? 0 : i3, (i18 & 2) != 0 ? 0 : i16, (i18 & 4) != 0 ? "" : str, (i18 & 8) == 0 ? i17 : 0, (i18 & 16) != 0 ? "" : str2, (i18 & 32) != 0 ? 0L : j3, (i18 & 64) != 0 ? "" : str3, (i18 & 128) != 0 ? "" : str4, (i18 & 256) != 0 ? "" : str5, (i18 & 512) == 0 ? str6 : "");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public WinkDc5507ReportData(@NotNull Parcel parcel) {
        this(r2, r3, r4, r5, r6, r7, r9, r10, r11, r14 == null ? "" : r14);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        int readInt = parcel.readInt();
        int readInt2 = parcel.readInt();
        String readString = parcel.readString();
        String str = readString == null ? "" : readString;
        int readInt3 = parcel.readInt();
        String readString2 = parcel.readString();
        String str2 = readString2 == null ? "" : readString2;
        long readLong = parcel.readLong();
        String readString3 = parcel.readString();
        String str3 = readString3 == null ? "" : readString3;
        String readString4 = parcel.readString();
        String str4 = readString4 == null ? "" : readString4;
        String readString5 = parcel.readString();
        String str5 = readString5 == null ? "" : readString5;
        String readString6 = parcel.readString();
    }
}
