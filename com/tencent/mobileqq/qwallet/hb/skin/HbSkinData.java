package com.tencent.mobileqq.qwallet.hb.skin;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.TypeConverters;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qwallet.hb.skin.local.f;
import com.tencent.mobileqq.qwallet.hb.skin.local.g;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.TextNode;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@TypeConverters({g.class, f.class})
@Entity(primaryKeys = {"skinId", "outerSkinId", "skinFrom"}, tableName = "hb_skin_table")
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b1\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000b\b\u0087\b\u0018\u0000 Y2\u00020\u0001:\u0003-Z[B\u00cd\u0001\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\u0006\u0010\u0019\u001a\u00020\t\u0012\u0006\u0010\u001c\u001a\u00020\u0004\u0012\u0006\u0010\u001f\u001a\u00020\u0004\u0012\u0006\u0010\"\u001a\u00020\u0004\u0012\b\u0010%\u001a\u0004\u0018\u00010\t\u0012\b\u0010(\u001a\u0004\u0018\u00010\t\u0012\b\u0010+\u001a\u0004\u0018\u00010\t\u0012\b\u0010.\u001a\u0004\u0018\u00010\t\u0012\b\u00101\u001a\u0004\u0018\u00010\t\u0012\b\u00104\u001a\u0004\u0018\u00010\t\u0012\b\u00106\u001a\u0004\u0018\u00010\t\u0012\b\u00107\u001a\u0004\u0018\u00010\t\u0012\b\u0010:\u001a\u0004\u0018\u00010\t\u0012\b\u0010=\u001a\u0004\u0018\u00010\t\u0012\b\u0010?\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010E\u001a\u00020@\u0012\u0016\u0010M\u001a\u0012\u0012\u0004\u0012\u00020G0Fj\b\u0012\u0004\u0012\u00020G`H\u0012\u0006\u0010P\u001a\u00020\t\u0012\u0006\u0010U\u001a\u00020Q\u00a2\u0006\u0004\bV\u0010WB\u0011\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\bV\u0010XJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\t\u0010\u000b\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u00d6\u0003R\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001c\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u001b\u0010\u0013R\u0017\u0010\u001f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0011\u001a\u0004\b\u001e\u0010\u0013R\u0017\u0010\"\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b \u0010\u0011\u001a\u0004\b!\u0010\u0013R\u0019\u0010%\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b#\u0010\u0016\u001a\u0004\b$\u0010\u0018R\u0019\u0010(\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b&\u0010\u0016\u001a\u0004\b'\u0010\u0018R\u0019\u0010+\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b)\u0010\u0016\u001a\u0004\b*\u0010\u0018R\u0019\u0010.\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b,\u0010\u0016\u001a\u0004\b-\u0010\u0018R\u0019\u00101\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b/\u0010\u0016\u001a\u0004\b0\u0010\u0018R\u0019\u00104\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b2\u0010\u0016\u001a\u0004\b3\u0010\u0018R\u0019\u00106\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b5\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u0019\u00107\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0016\u001a\u0004\b\u0015\u0010\u0018R\u0019\u0010:\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b8\u0010\u0016\u001a\u0004\b9\u0010\u0018R\u0019\u0010=\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b;\u0010\u0016\u001a\u0004\b<\u0010\u0018R\u0019\u0010?\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b>\u0010\u0016\u001a\u0004\b#\u0010\u0018R\u0017\u0010E\u001a\u00020@8\u0006\u00a2\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR'\u0010M\u001a\u0012\u0012\u0004\u0012\u00020G0Fj\b\u0012\u0004\u0012\u00020G`H8\u0006\u00a2\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010LR\u0017\u0010P\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\bN\u0010\u0016\u001a\u0004\bO\u0010\u0018R\u0017\u0010U\u001a\u00020Q8\u0006\u00a2\u0006\f\n\u0004\bR\u00108\u001a\u0004\bS\u0010T\u00a8\u0006\\"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/skin/HbSkinData;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "toString", "hashCode", "", "other", "", "equals", "d", "I", "r", "()I", "skinId", "e", "Ljava/lang/String;", "l", "()Ljava/lang/String;", "outerSkinId", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "skinFrom", h.F, ReportConstant.COSTREPORT_PREFIX, "skinType", "i", "p", "price", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getTitle", "title", BdhLogUtil.LogTag.Tag_Conn, "k", "merchantName", "D", "j", "merchantLogoUrl", "E", "a", "activityEntryName", UserInfo.SEX_FEMALE, "c", "activityUrl", "G", "b", "activityIcon", "H", "defaultSkinUrl", "aioResUrl", "J", "o", "popResUrl", "K", DomainData.DOMAIN_NAME, "popOpenUrl", "L", "popBrokenUrl", "Lcom/tencent/mobileqq/qwallet/hb/skin/HbSkinData$Tail;", "M", "Lcom/tencent/mobileqq/qwallet/hb/skin/HbSkinData$Tail;", "u", "()Lcom/tencent/mobileqq/qwallet/hb/skin/HbSkinData$Tail;", TextNode.MODE_TAIL, "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qwallet/hb/skin/HbSkinData$StoryRes;", "Lkotlin/collections/ArrayList;", "N", "Ljava/util/ArrayList;", "t", "()Ljava/util/ArrayList;", "storyResList", "P", "v", "version", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "g", "()J", "expireTimeMs", "<init>", "(ILjava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/qwallet/hb/skin/HbSkinData$Tail;Ljava/util/ArrayList;Ljava/lang/String;J)V", "(Landroid/os/Parcel;)V", "CREATOR", "StoryRes", "Tail", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final /* data */ class HbSkinData implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata and from toString */
    @Nullable
    private final String merchantName;

    /* renamed from: D, reason: from kotlin metadata and from toString */
    @Nullable
    private final String merchantLogoUrl;

    /* renamed from: E, reason: from kotlin metadata and from toString */
    @Nullable
    private final String activityEntryName;

    /* renamed from: F, reason: from kotlin metadata and from toString */
    @Nullable
    private final String activityUrl;

    /* renamed from: G, reason: from kotlin metadata and from toString */
    @Nullable
    private final String activityIcon;

    /* renamed from: H, reason: from kotlin metadata and from toString */
    @Nullable
    private final String defaultSkinUrl;

    /* renamed from: I, reason: from kotlin metadata and from toString */
    @Nullable
    private final String aioResUrl;

    /* renamed from: J, reason: from kotlin metadata and from toString */
    @Nullable
    private final String popResUrl;

    /* renamed from: K, reason: from kotlin metadata and from toString */
    @Nullable
    private final String popOpenUrl;

    /* renamed from: L, reason: from kotlin metadata and from toString */
    @Nullable
    private final String popBrokenUrl;

    /* renamed from: M, reason: from kotlin metadata and from toString */
    @NotNull
    private final Tail tail;

    /* renamed from: N, reason: from kotlin metadata and from toString */
    @NotNull
    private final ArrayList<StoryRes> storyResList;

    /* renamed from: P, reason: from kotlin metadata and from toString */
    @NotNull
    private final String version;

    /* renamed from: Q, reason: from kotlin metadata and from toString */
    private final long expireTimeMs;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int skinId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String outerSkinId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final int skinFrom;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final int skinType;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private final int price;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String title;

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0001\u0017B#\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u001d\u0010\u001eB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\t\u0010\u000b\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u00d6\u0003R\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001b\u0010\u0018\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/skin/HbSkinData$StoryRes;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "toString", "hashCode", "", "other", "", "equals", "d", "I", "b", "()I", "resType", "e", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "imgUrl", "f", "c", AppConstants.Key.KEY_QZONE_VIDEO_URL, "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "(Landroid/os/Parcel;)V", "CREATOR", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final /* data */ class StoryRes implements Parcelable {

        /* renamed from: CREATOR, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int resType;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String imgUrl;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String videoUrl;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\t\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/skin/HbSkinData$StoryRes$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/qwallet/hb/skin/HbSkinData$StoryRes;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/qwallet/hb/skin/HbSkinData$StoryRes;", "RES_TYPE_APNG", "I", "RES_TYPE_IMAGE", "RES_TYPE_MP4", "<init>", "()V", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.qwallet.hb.skin.HbSkinData$StoryRes$a, reason: from kotlin metadata */
        /* loaded from: classes16.dex */
        public static final class Companion implements Parcelable.Creator<StoryRes> {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public StoryRes createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new StoryRes(parcel);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public StoryRes[] newArray(int size) {
                return new StoryRes[size];
            }

            Companion() {
            }
        }

        public StoryRes(int i3, @Nullable String str, @Nullable String str2) {
            this.resType = i3;
            this.imgUrl = str;
            this.videoUrl = str2;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final String getImgUrl() {
            return this.imgUrl;
        }

        /* renamed from: b, reason: from getter */
        public final int getResType() {
            return this.resType;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final String getVideoUrl() {
            return this.videoUrl;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoryRes)) {
                return false;
            }
            StoryRes storyRes = (StoryRes) other;
            if (this.resType == storyRes.resType && Intrinsics.areEqual(this.imgUrl, storyRes.imgUrl) && Intrinsics.areEqual(this.videoUrl, storyRes.videoUrl)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int i3 = this.resType * 31;
            String str = this.imgUrl;
            int i16 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i17 = (i3 + hashCode) * 31;
            String str2 = this.videoUrl;
            if (str2 != null) {
                i16 = str2.hashCode();
            }
            return i17 + i16;
        }

        @NotNull
        public String toString() {
            return "StoryRes(resType=" + this.resType + ", imgUrl=" + this.imgUrl + ", videoUrl=" + this.videoUrl + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeInt(this.resType);
            parcel.writeString(this.imgUrl);
            parcel.writeString(this.videoUrl);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public StoryRes(@NotNull Parcel parcel) {
            this(parcel.readInt(), parcel.readString(), parcel.readString());
            Intrinsics.checkNotNullParameter(parcel, "parcel");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u0012B%\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u001b\u0010\u001cB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001dJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\t\u0010\u000b\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u00d6\u0003R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0019\u0010\u0013\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/skin/HbSkinData$Tail;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "toString", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "color", "e", "b", "url", "f", "c", "word", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "(Landroid/os/Parcel;)V", "CREATOR", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final /* data */ class Tail implements Parcelable {

        /* renamed from: CREATOR, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String color;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String url;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String word;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/skin/HbSkinData$Tail$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/qwallet/hb/skin/HbSkinData$Tail;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/qwallet/hb/skin/HbSkinData$Tail;", "<init>", "()V", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.qwallet.hb.skin.HbSkinData$Tail$a, reason: from kotlin metadata */
        /* loaded from: classes16.dex */
        public static final class Companion implements Parcelable.Creator<Tail> {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Tail createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Tail(parcel);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Tail[] newArray(int size) {
                return new Tail[size];
            }

            Companion() {
            }
        }

        public Tail(@Nullable String str, @Nullable String str2, @Nullable String str3) {
            this.color = str;
            this.url = str2;
            this.word = str3;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final String getColor() {
            return this.color;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final String getWord() {
            return this.word;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Tail)) {
                return false;
            }
            Tail tail = (Tail) other;
            if (Intrinsics.areEqual(this.color, tail.color) && Intrinsics.areEqual(this.url, tail.url) && Intrinsics.areEqual(this.word, tail.word)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            String str = this.color;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = hashCode * 31;
            String str2 = this.url;
            if (str2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str2.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            String str3 = this.word;
            if (str3 != null) {
                i3 = str3.hashCode();
            }
            return i17 + i3;
        }

        @NotNull
        public String toString() {
            return "Tail(color=" + this.color + ", url=" + this.url + ", word=" + this.word + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.color);
            parcel.writeString(this.url);
            parcel.writeString(this.word);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Tail(@NotNull Parcel parcel) {
            this(parcel.readString(), parcel.readString(), parcel.readString());
            Intrinsics.checkNotNullParameter(parcel, "parcel");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\nJ\u001e\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r2\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0006R\u0014\u0010\u0012\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/skin/HbSkinData$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/qwallet/hb/skin/HbSkinData;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "d", "(I)[Lcom/tencent/mobileqq/qwallet/hb/skin/HbSkinData;", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qwallet/hb/skin/HbSkinData$StoryRes;", "Lkotlin/collections/ArrayList;", "b", "skinType", "", "c", "SKIN_TYPE_DEFAULT", "I", "SKIN_TYPE_DETAIL", "SKIN_TYPE_FESTIVAL", "SKIN_TYPE_QCIRCLE_DETAIL", "<init>", "()V", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.hb.skin.HbSkinData$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion implements Parcelable.Creator<HbSkinData> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public HbSkinData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new HbSkinData(parcel);
        }

        @NotNull
        public final ArrayList<StoryRes> b(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            ArrayList<StoryRes> arrayList = new ArrayList<>();
            if (Build.VERSION.SDK_INT >= 29) {
                parcel.readParcelableList(arrayList, StoryRes.class.getClassLoader());
            } else {
                int readInt = parcel.readInt();
                for (int i3 = 0; i3 < readInt; i3++) {
                    StoryRes storyRes = (StoryRes) parcel.readParcelable(StoryRes.class.getClassLoader());
                    if (storyRes != null) {
                        arrayList.add(storyRes);
                    }
                }
            }
            return arrayList;
        }

        public final boolean c(int skinType) {
            if (skinType == 4) {
                return true;
            }
            return false;
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public HbSkinData[] newArray(int size) {
            return new HbSkinData[size];
        }

        Companion() {
        }
    }

    public HbSkinData(int i3, @NotNull String outerSkinId, int i16, int i17, int i18, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable String str11, @NotNull Tail tail, @NotNull ArrayList<StoryRes> storyResList, @NotNull String version, long j3) {
        Intrinsics.checkNotNullParameter(outerSkinId, "outerSkinId");
        Intrinsics.checkNotNullParameter(tail, "tail");
        Intrinsics.checkNotNullParameter(storyResList, "storyResList");
        Intrinsics.checkNotNullParameter(version, "version");
        this.skinId = i3;
        this.outerSkinId = outerSkinId;
        this.skinFrom = i16;
        this.skinType = i17;
        this.price = i18;
        this.title = str;
        this.merchantName = str2;
        this.merchantLogoUrl = str3;
        this.activityEntryName = str4;
        this.activityUrl = str5;
        this.activityIcon = str6;
        this.defaultSkinUrl = str7;
        this.aioResUrl = str8;
        this.popResUrl = str9;
        this.popOpenUrl = str10;
        this.popBrokenUrl = str11;
        this.tail = tail;
        this.storyResList = storyResList;
        this.version = version;
        this.expireTimeMs = j3;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getActivityEntryName() {
        return this.activityEntryName;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getActivityIcon() {
        return this.activityIcon;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final String getActivityUrl() {
        return this.activityUrl;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final String getAioResUrl() {
        return this.aioResUrl;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HbSkinData)) {
            return false;
        }
        HbSkinData hbSkinData = (HbSkinData) other;
        if (this.skinId == hbSkinData.skinId && Intrinsics.areEqual(this.outerSkinId, hbSkinData.outerSkinId) && this.skinFrom == hbSkinData.skinFrom && this.skinType == hbSkinData.skinType && this.price == hbSkinData.price && Intrinsics.areEqual(this.title, hbSkinData.title) && Intrinsics.areEqual(this.merchantName, hbSkinData.merchantName) && Intrinsics.areEqual(this.merchantLogoUrl, hbSkinData.merchantLogoUrl) && Intrinsics.areEqual(this.activityEntryName, hbSkinData.activityEntryName) && Intrinsics.areEqual(this.activityUrl, hbSkinData.activityUrl) && Intrinsics.areEqual(this.activityIcon, hbSkinData.activityIcon) && Intrinsics.areEqual(this.defaultSkinUrl, hbSkinData.defaultSkinUrl) && Intrinsics.areEqual(this.aioResUrl, hbSkinData.aioResUrl) && Intrinsics.areEqual(this.popResUrl, hbSkinData.popResUrl) && Intrinsics.areEqual(this.popOpenUrl, hbSkinData.popOpenUrl) && Intrinsics.areEqual(this.popBrokenUrl, hbSkinData.popBrokenUrl) && Intrinsics.areEqual(this.tail, hbSkinData.tail) && Intrinsics.areEqual(this.storyResList, hbSkinData.storyResList) && Intrinsics.areEqual(this.version, hbSkinData.version) && this.expireTimeMs == hbSkinData.expireTimeMs) {
            return true;
        }
        return false;
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final String getDefaultSkinUrl() {
        return this.defaultSkinUrl;
    }

    /* renamed from: g, reason: from getter */
    public final long getExpireTimeMs() {
        return this.expireTimeMs;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        int hashCode7;
        int hashCode8;
        int hashCode9;
        int hashCode10;
        int hashCode11 = ((((((((this.skinId * 31) + this.outerSkinId.hashCode()) * 31) + this.skinFrom) * 31) + this.skinType) * 31) + this.price) * 31;
        String str = this.title;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = (hashCode11 + hashCode) * 31;
        String str2 = this.merchantName;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        String str3 = this.merchantLogoUrl;
        if (str3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str3.hashCode();
        }
        int i18 = (i17 + hashCode3) * 31;
        String str4 = this.activityEntryName;
        if (str4 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = str4.hashCode();
        }
        int i19 = (i18 + hashCode4) * 31;
        String str5 = this.activityUrl;
        if (str5 == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = str5.hashCode();
        }
        int i26 = (i19 + hashCode5) * 31;
        String str6 = this.activityIcon;
        if (str6 == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = str6.hashCode();
        }
        int i27 = (i26 + hashCode6) * 31;
        String str7 = this.defaultSkinUrl;
        if (str7 == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = str7.hashCode();
        }
        int i28 = (i27 + hashCode7) * 31;
        String str8 = this.aioResUrl;
        if (str8 == null) {
            hashCode8 = 0;
        } else {
            hashCode8 = str8.hashCode();
        }
        int i29 = (i28 + hashCode8) * 31;
        String str9 = this.popResUrl;
        if (str9 == null) {
            hashCode9 = 0;
        } else {
            hashCode9 = str9.hashCode();
        }
        int i36 = (i29 + hashCode9) * 31;
        String str10 = this.popOpenUrl;
        if (str10 == null) {
            hashCode10 = 0;
        } else {
            hashCode10 = str10.hashCode();
        }
        int i37 = (i36 + hashCode10) * 31;
        String str11 = this.popBrokenUrl;
        if (str11 != null) {
            i3 = str11.hashCode();
        }
        return ((((((((i37 + i3) * 31) + this.tail.hashCode()) * 31) + this.storyResList.hashCode()) * 31) + this.version.hashCode()) * 31) + androidx.fragment.app.a.a(this.expireTimeMs);
    }

    @Nullable
    /* renamed from: j, reason: from getter */
    public final String getMerchantLogoUrl() {
        return this.merchantLogoUrl;
    }

    @Nullable
    /* renamed from: k, reason: from getter */
    public final String getMerchantName() {
        return this.merchantName;
    }

    @NotNull
    /* renamed from: l, reason: from getter */
    public final String getOuterSkinId() {
        return this.outerSkinId;
    }

    @Nullable
    /* renamed from: m, reason: from getter */
    public final String getPopBrokenUrl() {
        return this.popBrokenUrl;
    }

    @Nullable
    /* renamed from: n, reason: from getter */
    public final String getPopOpenUrl() {
        return this.popOpenUrl;
    }

    @Nullable
    /* renamed from: o, reason: from getter */
    public final String getPopResUrl() {
        return this.popResUrl;
    }

    /* renamed from: p, reason: from getter */
    public final int getPrice() {
        return this.price;
    }

    /* renamed from: q, reason: from getter */
    public final int getSkinFrom() {
        return this.skinFrom;
    }

    /* renamed from: r, reason: from getter */
    public final int getSkinId() {
        return this.skinId;
    }

    /* renamed from: s, reason: from getter */
    public final int getSkinType() {
        return this.skinType;
    }

    @NotNull
    public final ArrayList<StoryRes> t() {
        return this.storyResList;
    }

    @NotNull
    public String toString() {
        return "HbSkinData(skinId=" + this.skinId + ", outerSkinId=" + this.outerSkinId + ", skinFrom=" + this.skinFrom + ", skinType=" + this.skinType + ", price=" + this.price + ", title=" + this.title + ", merchantName=" + this.merchantName + ", merchantLogoUrl=" + this.merchantLogoUrl + ", activityEntryName=" + this.activityEntryName + ", activityUrl=" + this.activityUrl + ", activityIcon=" + this.activityIcon + ", defaultSkinUrl=" + this.defaultSkinUrl + ", aioResUrl=" + this.aioResUrl + ", popResUrl=" + this.popResUrl + ", popOpenUrl=" + this.popOpenUrl + ", popBrokenUrl=" + this.popBrokenUrl + ", tail=" + this.tail + ", storyResList=" + this.storyResList + ", version=" + this.version + ", expireTimeMs=" + this.expireTimeMs + ')';
    }

    @NotNull
    /* renamed from: u, reason: from getter */
    public final Tail getTail() {
        return this.tail;
    }

    @NotNull
    /* renamed from: v, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.skinId);
        parcel.writeString(this.outerSkinId);
        parcel.writeInt(this.skinFrom);
        parcel.writeInt(this.skinType);
        parcel.writeInt(this.price);
        parcel.writeString(this.title);
        parcel.writeString(this.merchantName);
        parcel.writeString(this.merchantLogoUrl);
        parcel.writeString(this.activityEntryName);
        parcel.writeString(this.activityUrl);
        parcel.writeString(this.activityIcon);
        parcel.writeString(this.defaultSkinUrl);
        parcel.writeString(this.aioResUrl);
        parcel.writeString(this.popResUrl);
        parcel.writeString(this.popOpenUrl);
        parcel.writeString(this.popBrokenUrl);
        parcel.writeParcelable(this.tail, flags);
        if (Build.VERSION.SDK_INT >= 29) {
            parcel.writeParcelableList(this.storyResList, flags);
        } else {
            parcel.writeInt(this.storyResList.size());
            Iterator<T> it = this.storyResList.iterator();
            while (it.hasNext()) {
                parcel.writeParcelable((StoryRes) it.next(), flags);
            }
        }
        parcel.writeString(this.version);
        parcel.writeLong(this.expireTimeMs);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @Ignore
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public HbSkinData(@NotNull Parcel parcel) {
        this(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r1, r20, r2 == null ? r19 : r2, parcel.readLong());
        String str;
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        int readInt = parcel.readInt();
        String readString = parcel.readString();
        String str2 = readString == null ? "" : readString;
        int readInt2 = parcel.readInt();
        int readInt3 = parcel.readInt();
        int readInt4 = parcel.readInt();
        String readString2 = parcel.readString();
        String readString3 = parcel.readString();
        String readString4 = parcel.readString();
        String readString5 = parcel.readString();
        String readString6 = parcel.readString();
        String readString7 = parcel.readString();
        String readString8 = parcel.readString();
        String readString9 = parcel.readString();
        String readString10 = parcel.readString();
        String readString11 = parcel.readString();
        String readString12 = parcel.readString();
        Tail tail = (Tail) parcel.readParcelable(Tail.class.getClassLoader());
        if (tail == null) {
            str = "";
            tail = new Tail(null, null, null);
        } else {
            str = "";
        }
        ArrayList<StoryRes> b16 = INSTANCE.b(parcel);
        String readString13 = parcel.readString();
    }
}
