package com.tencent.mobileqq.winkpublish.model.params;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 ?2\u00020\u0001:\u0001?B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0091\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012(\b\u0002\u0010\u0016\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0017j\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u0001`\u0018\u00a2\u0006\u0002\u0010\u0019J\t\u0010+\u001a\u00020\u0006H\u00c6\u0003J)\u0010,\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0017j\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u0001`\u0018H\u00c6\u0003J\t\u0010-\u001a\u00020\bH\u00c6\u0003J\t\u0010.\u001a\u00020\bH\u00c6\u0003J\t\u0010/\u001a\u00020\u000bH\u00c6\u0003J\t\u00100\u001a\u00020\u0006H\u00c6\u0003J\u0011\u00101\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u00c6\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0011H\u00c6\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0013H\u00c6\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0015H\u00c6\u0003J\u009b\u0001\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00062\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152(\b\u0002\u0010\u0016\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0017j\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u0001`\u0018H\u00c6\u0001J\b\u00106\u001a\u00020\u0006H\u0016J\u0013\u00107\u001a\u00020\u000b2\b\u00108\u001a\u0004\u0018\u000109H\u00d6\u0003J\t\u0010:\u001a\u00020\u0006H\u00d6\u0001J\t\u0010;\u001a\u00020\bH\u00d6\u0001J\u0018\u0010<\u001a\u00020=2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010>\u001a\u00020\u0006H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR1\u0010\u0016\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0017j\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u0001`\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010$R\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\t\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001dR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\f\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001b\u00a8\u0006@"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/model/params/WinkPublishParams;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "businessType", "", "clientKey", "", "traceId", "isTruePublish", "", "uploadEntrance", "mediaParamsList", "", "Lcom/tencent/mobileqq/winkpublish/model/params/MediaParams;", "exportParams", "Lcom/tencent/mobileqq/winkpublish/model/params/ExportParams;", "feedParams", "Lcom/tencent/mobileqq/winkpublish/model/params/FeedParams;", "transParams", "Landroid/os/Bundle;", "datongParams", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "(ILjava/lang/String;Ljava/lang/String;ZILjava/util/List;Lcom/tencent/mobileqq/winkpublish/model/params/ExportParams;Lcom/tencent/mobileqq/winkpublish/model/params/FeedParams;Landroid/os/Bundle;Ljava/util/HashMap;)V", "getBusinessType", "()I", "getClientKey", "()Ljava/lang/String;", "getDatongParams", "()Ljava/util/HashMap;", "getExportParams", "()Lcom/tencent/mobileqq/winkpublish/model/params/ExportParams;", "getFeedParams", "()Lcom/tencent/mobileqq/winkpublish/model/params/FeedParams;", "()Z", "getMediaParamsList", "()Ljava/util/List;", "getTraceId", "getTransParams", "()Landroid/os/Bundle;", "getUploadEntrance", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", WadlProxyConsts.FLAGS, "Companion", "qq-winkpublish-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final /* data */ class WinkPublishParams implements Parcelable {

    @NotNull
    private static final String TAG = "WinkPublishParams";
    private final int businessType;

    @NotNull
    private final String clientKey;

    @Nullable
    private final HashMap<String, String> datongParams;

    @Nullable
    private final ExportParams exportParams;

    @Nullable
    private final FeedParams feedParams;
    private final boolean isTruePublish;

    @Nullable
    private final List<MediaParams> mediaParamsList;

    @NotNull
    private final String traceId;

    @Nullable
    private final Bundle transParams;
    private final int uploadEntrance;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<WinkPublishParams> CREATOR = new Parcelable.Creator<WinkPublishParams>() { // from class: com.tencent.mobileqq.winkpublish.model.params.WinkPublishParams$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public WinkPublishParams createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new WinkPublishParams(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public WinkPublishParams[] newArray(int size) {
            return new WinkPublishParams[size];
        }
    };

    /* JADX WARN: Multi-variable type inference failed */
    public WinkPublishParams(int i3, @NotNull String clientKey, @NotNull String traceId, boolean z16, int i16, @Nullable List<? extends MediaParams> list, @Nullable ExportParams exportParams, @Nullable FeedParams feedParams, @Nullable Bundle bundle, @Nullable HashMap<String, String> hashMap) {
        Intrinsics.checkNotNullParameter(clientKey, "clientKey");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        this.businessType = i3;
        this.clientKey = clientKey;
        this.traceId = traceId;
        this.isTruePublish = z16;
        this.uploadEntrance = i16;
        this.mediaParamsList = list;
        this.exportParams = exportParams;
        this.feedParams = feedParams;
        this.transParams = bundle;
        this.datongParams = hashMap;
    }

    public static /* synthetic */ WinkPublishParams copy$default(WinkPublishParams winkPublishParams, int i3, String str, String str2, boolean z16, int i16, List list, ExportParams exportParams, FeedParams feedParams, Bundle bundle, HashMap hashMap, int i17, Object obj) {
        int i18;
        String str3;
        String str4;
        boolean z17;
        int i19;
        List list2;
        ExportParams exportParams2;
        FeedParams feedParams2;
        Bundle bundle2;
        HashMap hashMap2;
        if ((i17 & 1) != 0) {
            i18 = winkPublishParams.businessType;
        } else {
            i18 = i3;
        }
        if ((i17 & 2) != 0) {
            str3 = winkPublishParams.clientKey;
        } else {
            str3 = str;
        }
        if ((i17 & 4) != 0) {
            str4 = winkPublishParams.traceId;
        } else {
            str4 = str2;
        }
        if ((i17 & 8) != 0) {
            z17 = winkPublishParams.isTruePublish;
        } else {
            z17 = z16;
        }
        if ((i17 & 16) != 0) {
            i19 = winkPublishParams.uploadEntrance;
        } else {
            i19 = i16;
        }
        if ((i17 & 32) != 0) {
            list2 = winkPublishParams.mediaParamsList;
        } else {
            list2 = list;
        }
        if ((i17 & 64) != 0) {
            exportParams2 = winkPublishParams.exportParams;
        } else {
            exportParams2 = exportParams;
        }
        if ((i17 & 128) != 0) {
            feedParams2 = winkPublishParams.feedParams;
        } else {
            feedParams2 = feedParams;
        }
        if ((i17 & 256) != 0) {
            bundle2 = winkPublishParams.transParams;
        } else {
            bundle2 = bundle;
        }
        if ((i17 & 512) != 0) {
            hashMap2 = winkPublishParams.datongParams;
        } else {
            hashMap2 = hashMap;
        }
        return winkPublishParams.copy(i18, str3, str4, z17, i19, list2, exportParams2, feedParams2, bundle2, hashMap2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getBusinessType() {
        return this.businessType;
    }

    @Nullable
    public final HashMap<String, String> component10() {
        return this.datongParams;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getClientKey() {
        return this.clientKey;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsTruePublish() {
        return this.isTruePublish;
    }

    /* renamed from: component5, reason: from getter */
    public final int getUploadEntrance() {
        return this.uploadEntrance;
    }

    @Nullable
    public final List<MediaParams> component6() {
        return this.mediaParamsList;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final ExportParams getExportParams() {
        return this.exportParams;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final FeedParams getFeedParams() {
        return this.feedParams;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final Bundle getTransParams() {
        return this.transParams;
    }

    @NotNull
    public final WinkPublishParams copy(int businessType, @NotNull String clientKey, @NotNull String traceId, boolean isTruePublish, int uploadEntrance, @Nullable List<? extends MediaParams> mediaParamsList, @Nullable ExportParams exportParams, @Nullable FeedParams feedParams, @Nullable Bundle transParams, @Nullable HashMap<String, String> datongParams) {
        Intrinsics.checkNotNullParameter(clientKey, "clientKey");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        return new WinkPublishParams(businessType, clientKey, traceId, isTruePublish, uploadEntrance, mediaParamsList, exportParams, feedParams, transParams, datongParams);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WinkPublishParams)) {
            return false;
        }
        WinkPublishParams winkPublishParams = (WinkPublishParams) other;
        if (this.businessType == winkPublishParams.businessType && Intrinsics.areEqual(this.clientKey, winkPublishParams.clientKey) && Intrinsics.areEqual(this.traceId, winkPublishParams.traceId) && this.isTruePublish == winkPublishParams.isTruePublish && this.uploadEntrance == winkPublishParams.uploadEntrance && Intrinsics.areEqual(this.mediaParamsList, winkPublishParams.mediaParamsList) && Intrinsics.areEqual(this.exportParams, winkPublishParams.exportParams) && Intrinsics.areEqual(this.feedParams, winkPublishParams.feedParams) && Intrinsics.areEqual(this.transParams, winkPublishParams.transParams) && Intrinsics.areEqual(this.datongParams, winkPublishParams.datongParams)) {
            return true;
        }
        return false;
    }

    public final int getBusinessType() {
        return this.businessType;
    }

    @NotNull
    public final String getClientKey() {
        return this.clientKey;
    }

    @Nullable
    public final HashMap<String, String> getDatongParams() {
        return this.datongParams;
    }

    @Nullable
    public final ExportParams getExportParams() {
        return this.exportParams;
    }

    @Nullable
    public final FeedParams getFeedParams() {
        return this.feedParams;
    }

    @Nullable
    public final List<MediaParams> getMediaParamsList() {
        return this.mediaParamsList;
    }

    @NotNull
    public final String getTraceId() {
        return this.traceId;
    }

    @Nullable
    public final Bundle getTransParams() {
        return this.transParams;
    }

    public final int getUploadEntrance() {
        return this.uploadEntrance;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5 = ((((this.businessType * 31) + this.clientKey.hashCode()) * 31) + this.traceId.hashCode()) * 31;
        boolean z16 = this.isTruePublish;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (((hashCode5 + i3) * 31) + this.uploadEntrance) * 31;
        List<MediaParams> list = this.mediaParamsList;
        int i17 = 0;
        if (list == null) {
            hashCode = 0;
        } else {
            hashCode = list.hashCode();
        }
        int i18 = (i16 + hashCode) * 31;
        ExportParams exportParams = this.exportParams;
        if (exportParams == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = exportParams.hashCode();
        }
        int i19 = (i18 + hashCode2) * 31;
        FeedParams feedParams = this.feedParams;
        if (feedParams == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = feedParams.hashCode();
        }
        int i26 = (i19 + hashCode3) * 31;
        Bundle bundle = this.transParams;
        if (bundle == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = bundle.hashCode();
        }
        int i27 = (i26 + hashCode4) * 31;
        HashMap<String, String> hashMap = this.datongParams;
        if (hashMap != null) {
            i17 = hashMap.hashCode();
        }
        return i27 + i17;
    }

    public final boolean isTruePublish() {
        return this.isTruePublish;
    }

    @NotNull
    public String toString() {
        return "WinkPublishParams(businessType=" + this.businessType + ", clientKey=" + this.clientKey + ", traceId=" + this.traceId + ", isTruePublish=" + this.isTruePublish + ", uploadEntrance=" + this.uploadEntrance + ", mediaParamsList=" + this.mediaParamsList + ", exportParams=" + this.exportParams + ", feedParams=" + this.feedParams + ", transParams=" + this.transParams + ", datongParams=" + this.datongParams + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.businessType);
        parcel.writeString(this.clientKey);
        parcel.writeString(this.traceId);
        parcel.writeByte(this.isTruePublish ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.uploadEntrance);
        MediaParams.INSTANCE.write(parcel, this.mediaParamsList, flags);
        parcel.writeParcelable(this.exportParams, flags);
        parcel.writeParcelable(this.feedParams, flags);
        parcel.writeBundle(this.transParams);
        parcel.writeSerializable(this.datongParams);
    }

    public /* synthetic */ WinkPublishParams(int i3, String str, String str2, boolean z16, int i16, List list, ExportParams exportParams, FeedParams feedParams, Bundle bundle, HashMap hashMap, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, str, (i17 & 4) != 0 ? "" : str2, (i17 & 8) != 0 ? true : z16, i16, (i17 & 32) != 0 ? null : list, (i17 & 64) != 0 ? null : exportParams, (i17 & 128) != 0 ? null : feedParams, (i17 & 256) != 0 ? null : bundle, (i17 & 512) != 0 ? null : hashMap);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public WinkPublishParams(@NotNull Parcel parcel) {
        this(r2, r3, r4, r5, r6, r7, r8, r9, r10, r13 instanceof HashMap ? (HashMap) r13 : null);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        int readInt = parcel.readInt();
        String readString = parcel.readString();
        String str = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        String str2 = readString2 == null ? "" : readString2;
        boolean z16 = parcel.readByte() != 0;
        int readInt2 = parcel.readInt();
        List<MediaParams> read = MediaParams.INSTANCE.read(parcel);
        ExportParams exportParams = (ExportParams) parcel.readParcelable(ExportParams.class.getClassLoader());
        FeedParams feedParams = (FeedParams) parcel.readParcelable(FeedParams.class.getClassLoader());
        Bundle readBundle = parcel.readBundle(WinkPublishParams.class.getClassLoader());
        Serializable readSerializable = parcel.readSerializable();
    }
}
