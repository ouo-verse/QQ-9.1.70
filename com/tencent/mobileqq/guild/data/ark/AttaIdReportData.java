package com.tencent.mobileqq.guild.data.ark;

import android.os.Parcel;
import android.os.Parcelable;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.guild.report.b;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.p;
import com.tencent.qqnt.kernel.nativeinterface.cq;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0086\b\u0018\u0000 @2\u00020\u0001:\u0001\u0006B\u0085\u0001\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\"\u001a\u00020\u0004\u0012\b\b\u0002\u0010%\u001a\u00020\u0004\u0012\b\b\u0002\u0010(\u001a\u00020\u0004\u0012\b\b\u0002\u0010+\u001a\u00020\u0004\u0012\u0018\b\u0002\u00103\u001a\u0012\u0012\u0004\u0012\u00020\u00040,j\b\u0012\u0004\u0012\u00020\u0004`-\u0012\b\b\u0002\u00106\u001a\u00020\u0004\u0012\b\b\u0002\u00109\u001a\u00020\u0004\u0012\b\b\u0002\u0010<\u001a\u00020\u0004\u00a2\u0006\u0004\b=\u0010>B\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b=\u0010?J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0006\u0010\u0006\u001a\u00020\u0000J\u0006\u0010\b\u001a\u00020\u0007J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\t\u0010\u000e\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u00d6\u0003R\"\u0010\u0019\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001c\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u0016R\u0017\u0010\u001f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0014\u001a\u0004\b\u001e\u0010\u0016R\u0017\u0010\"\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b \u0010\u0014\u001a\u0004\b!\u0010\u0016R\u0017\u0010%\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b#\u0010\u0014\u001a\u0004\b$\u0010\u0016R\u0017\u0010(\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b&\u0010\u0014\u001a\u0004\b'\u0010\u0016R\"\u0010+\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b*\u0010\u0018R2\u00103\u001a\u0012\u0012\u0004\u0012\u00020\u00040,j\b\u0012\u0004\u0012\u00020\u0004`-8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b\u001d\u00100\"\u0004\b1\u00102R\u0017\u00106\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b4\u0010\u0014\u001a\u0004\b5\u0010\u0016R\u0017\u00109\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b7\u0010\u0014\u001a\u0004\b8\u0010\u0016R\u0017\u0010<\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b:\u0010\u0014\u001a\u0004\b;\u0010\u0016\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/guild/data/ark/AttaIdReportData;", "Landroid/os/Parcelable;", "", "describeContents", "", "toString", "a", "Lcom/tencent/mobileqq/qqguildsdk/data/p;", "c", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "g", "(Ljava/lang/String;)V", "attaContentId", "e", "getGuildId", "guildId", "f", "getChannelId", "channelId", h.F, "getContentId", "contentId", "i", "getSharePanelPageSource", "sharePanelPageSource", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getShareContentType", "shareContentType", BdhLogUtil.LogTag.Tag_Conn, "j", "shareSource", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "D", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "k", "(Ljava/util/ArrayList;)V", "toUinList", "E", "getStreamPginSourceName", "streamPginSourceName", UserInfo.SEX_FEMALE, "getVisitFrom", "visitFrom", "G", "getSessionId", "sessionId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "(Landroid/os/Parcel;)V", "CREATOR", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final /* data */ class AttaIdReportData implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private String shareSource;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private ArrayList<String> toUinList;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final String streamPginSourceName;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final String visitFrom;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final String sessionId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String attaContentId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String guildId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String channelId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String contentId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String sharePanelPageSource;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String shareContentType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/data/ark/AttaIdReportData$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/guild/data/ark/AttaIdReportData;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/guild/data/ark/AttaIdReportData;", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.data.ark.AttaIdReportData$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion implements Parcelable.Creator<AttaIdReportData> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AttaIdReportData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AttaIdReportData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AttaIdReportData[] newArray(int size) {
            return new AttaIdReportData[size];
        }

        Companion() {
        }
    }

    public AttaIdReportData() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    @NotNull
    public final AttaIdReportData a() {
        return new AttaIdReportData(this.attaContentId, this.guildId, this.channelId, this.contentId, this.sharePanelPageSource, this.shareContentType, this.shareSource, new ArrayList(this.toUinList), null, null, null, 1792, null);
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getAttaContentId() {
        return this.attaContentId;
    }

    @NotNull
    public final p c() {
        boolean z16;
        p.a aVar = new p.a();
        aVar.c(this.attaContentId);
        aVar.n(String.valueOf(System.currentTimeMillis() / 1000));
        aVar.g(this.guildId);
        String str = this.channelId;
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            str = "0";
        }
        aVar.e(str);
        aVar.f(this.contentId);
        aVar.k(this.sharePanelPageSource);
        aVar.j(this.shareContentType);
        aVar.l(this.shareSource);
        aVar.o(this.toUinList);
        aVar.m(this.streamPginSourceName);
        aVar.q(this.visitFrom);
        aVar.i(this.sessionId);
        aVar.h("1");
        aVar.p("");
        aVar.b(AppSetting.f99551k);
        p d16 = aVar.d();
        Intrinsics.checkNotNullExpressionValue(d16, "gProShareAttaData.build()");
        return d16;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getShareSource() {
        return this.shareSource;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AttaIdReportData)) {
            return false;
        }
        AttaIdReportData attaIdReportData = (AttaIdReportData) other;
        if (Intrinsics.areEqual(this.attaContentId, attaIdReportData.attaContentId) && Intrinsics.areEqual(this.guildId, attaIdReportData.guildId) && Intrinsics.areEqual(this.channelId, attaIdReportData.channelId) && Intrinsics.areEqual(this.contentId, attaIdReportData.contentId) && Intrinsics.areEqual(this.sharePanelPageSource, attaIdReportData.sharePanelPageSource) && Intrinsics.areEqual(this.shareContentType, attaIdReportData.shareContentType) && Intrinsics.areEqual(this.shareSource, attaIdReportData.shareSource) && Intrinsics.areEqual(this.toUinList, attaIdReportData.toUinList) && Intrinsics.areEqual(this.streamPginSourceName, attaIdReportData.streamPginSourceName) && Intrinsics.areEqual(this.visitFrom, attaIdReportData.visitFrom) && Intrinsics.areEqual(this.sessionId, attaIdReportData.sessionId)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final ArrayList<String> f() {
        return this.toUinList;
    }

    public final void g(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.attaContentId = str;
    }

    public int hashCode() {
        return (((((((((((((((((((this.attaContentId.hashCode() * 31) + this.guildId.hashCode()) * 31) + this.channelId.hashCode()) * 31) + this.contentId.hashCode()) * 31) + this.sharePanelPageSource.hashCode()) * 31) + this.shareContentType.hashCode()) * 31) + this.shareSource.hashCode()) * 31) + this.toUinList.hashCode()) * 31) + this.streamPginSourceName.hashCode()) * 31) + this.visitFrom.hashCode()) * 31) + this.sessionId.hashCode();
    }

    public final void j(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.shareSource = str;
    }

    public final void k(@NotNull ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.toUinList = arrayList;
    }

    @NotNull
    public String toString() {
        String joinToString$default;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("attaContentId ");
        sb5.append(this.attaContentId);
        sb5.append(", guildId ");
        sb5.append(this.guildId);
        sb5.append(", channelId ");
        sb5.append(this.channelId);
        sb5.append(", contentId ");
        sb5.append(this.contentId);
        sb5.append(", sharePanelPageSource ");
        sb5.append(this.sharePanelPageSource);
        sb5.append(", shareContentType ");
        sb5.append(this.shareContentType);
        sb5.append(", shareSource ");
        sb5.append(this.shareSource);
        sb5.append(", streamPginSourceName: ");
        sb5.append(this.streamPginSourceName);
        sb5.append(", visitFrom: ");
        sb5.append(this.visitFrom);
        sb5.append(", toUinList ");
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(this.toUinList, null, null, null, 0, null, new Function1<String, CharSequence>() { // from class: com.tencent.mobileqq.guild.data.ark.AttaIdReportData$toString$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(@NotNull String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                String w3 = cq.w(it, 2);
                Intrinsics.checkNotNullExpressionValue(w3, "getFuzzyStr(it, 2)");
                return w3;
            }
        }, 31, null);
        sb5.append(joinToString$default);
        return sb5.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.attaContentId);
        parcel.writeString(this.guildId);
        parcel.writeString(this.channelId);
        parcel.writeString(this.contentId);
        parcel.writeString(this.sharePanelPageSource);
        parcel.writeString(this.shareContentType);
        parcel.writeString(this.shareSource);
        parcel.writeStringList(this.toUinList);
        parcel.writeString(this.streamPginSourceName);
        parcel.writeString(this.visitFrom);
        parcel.writeString(this.sessionId);
    }

    public AttaIdReportData(@NotNull String attaContentId, @NotNull String guildId, @NotNull String channelId, @NotNull String contentId, @NotNull String sharePanelPageSource, @NotNull String shareContentType, @NotNull String shareSource, @NotNull ArrayList<String> toUinList, @NotNull String streamPginSourceName, @NotNull String visitFrom, @NotNull String sessionId) {
        Intrinsics.checkNotNullParameter(attaContentId, "attaContentId");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(contentId, "contentId");
        Intrinsics.checkNotNullParameter(sharePanelPageSource, "sharePanelPageSource");
        Intrinsics.checkNotNullParameter(shareContentType, "shareContentType");
        Intrinsics.checkNotNullParameter(shareSource, "shareSource");
        Intrinsics.checkNotNullParameter(toUinList, "toUinList");
        Intrinsics.checkNotNullParameter(streamPginSourceName, "streamPginSourceName");
        Intrinsics.checkNotNullParameter(visitFrom, "visitFrom");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        this.attaContentId = attaContentId;
        this.guildId = guildId;
        this.channelId = channelId;
        this.contentId = contentId;
        this.sharePanelPageSource = sharePanelPageSource;
        this.shareContentType = shareContentType;
        this.shareSource = shareSource;
        this.toUinList = toUinList;
        this.streamPginSourceName = streamPginSourceName;
        this.visitFrom = visitFrom;
        this.sessionId = sessionId;
    }

    public /* synthetic */ AttaIdReportData(String str, String str2, String str3, String str4, String str5, String str6, String str7, ArrayList arrayList, String str8, String str9, String str10, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "0" : str3, (i3 & 8) != 0 ? "" : str4, (i3 & 16) != 0 ? "" : str5, (i3 & 32) != 0 ? "" : str6, (i3 & 64) == 0 ? str7 : "", (i3 & 128) != 0 ? new ArrayList() : arrayList, (i3 & 256) != 0 ? b.c() : str8, (i3 & 512) != 0 ? b.f() : str9, (i3 & 1024) != 0 ? b.e() : str10);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AttaIdReportData(@NotNull Parcel parcel) {
        this(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r15 == null ? "" : r15);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        String str = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        String str2 = readString2 == null ? "" : readString2;
        String readString3 = parcel.readString();
        String str3 = readString3 == null ? "" : readString3;
        String readString4 = parcel.readString();
        String str4 = readString4 == null ? "" : readString4;
        String readString5 = parcel.readString();
        String str5 = readString5 == null ? "" : readString5;
        String readString6 = parcel.readString();
        String str6 = readString6 == null ? "" : readString6;
        String readString7 = parcel.readString();
        String str7 = readString7 == null ? "" : readString7;
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        ArrayList<String> arrayList = createStringArrayList == null ? new ArrayList<>() : createStringArrayList;
        String readString8 = parcel.readString();
        String str8 = readString8 == null ? "" : readString8;
        String readString9 = parcel.readString();
        String str9 = readString9 == null ? "" : readString9;
        String readString10 = parcel.readString();
    }
}
