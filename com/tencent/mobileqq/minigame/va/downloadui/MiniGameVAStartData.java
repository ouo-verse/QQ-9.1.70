package com.tencent.mobileqq.minigame.va.downloadui;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.minigame.config.MiniGameVAInterceptConfig;
import com.tencent.mobileqq.minigame.va.MiniGameDownloadDataWrapper;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001bH\u0016R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/minigame/va/downloadui/MiniGameVAStartData;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", DownloadInfo.spKey_Config, "Lcom/tencent/mobileqq/minigame/config/MiniGameVAInterceptConfig$VAInterceptConfig;", "dataWrapper", "Lcom/tencent/mobileqq/minigame/va/MiniGameDownloadDataWrapper;", "(Lcom/tencent/mobileqq/minigame/config/MiniGameVAInterceptConfig$VAInterceptConfig;Lcom/tencent/mobileqq/minigame/va/MiniGameDownloadDataWrapper;)V", "getConfig", "()Lcom/tencent/mobileqq/minigame/config/MiniGameVAInterceptConfig$VAInterceptConfig;", "getDataWrapper", "()Lcom/tencent/mobileqq/minigame/va/MiniGameDownloadDataWrapper;", "needInstall", "", "getNeedInstall", "()Z", "setNeedInstall", "(Z)V", "uriData", "", "getUriData", "()Ljava/lang/String;", "setUriData", "(Ljava/lang/String;)V", "describeContents", "", "writeToParcel", "", WadlProxyConsts.FLAGS, "CREATOR", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniGameVAStartData implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final MiniGameVAInterceptConfig.VAInterceptConfig config;
    private final MiniGameDownloadDataWrapper dataWrapper;
    private boolean needInstall;
    private String uriData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/minigame/va/downloadui/MiniGameVAStartData$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/minigame/va/downloadui/MiniGameVAStartData;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mobileqq/minigame/va/downloadui/MiniGameVAStartData;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.minigame.va.downloadui.MiniGameVAStartData$CREATOR, reason: from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion implements Parcelable.Creator<MiniGameVAStartData> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MiniGameVAStartData createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new MiniGameVAStartData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MiniGameVAStartData[] newArray(int size) {
            return new MiniGameVAStartData[size];
        }
    }

    public MiniGameVAStartData(MiniGameVAInterceptConfig.VAInterceptConfig config, MiniGameDownloadDataWrapper dataWrapper) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(dataWrapper, "dataWrapper");
        this.config = config;
        this.dataWrapper = dataWrapper;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final MiniGameVAInterceptConfig.VAInterceptConfig getConfig() {
        return this.config;
    }

    public final MiniGameDownloadDataWrapper getDataWrapper() {
        return this.dataWrapper;
    }

    public final boolean getNeedInstall() {
        return this.needInstall;
    }

    public final String getUriData() {
        return this.uriData;
    }

    public final void setNeedInstall(boolean z16) {
        this.needInstall = z16;
    }

    public final void setUriData(String str) {
        this.uriData = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.config, flags);
        parcel.writeParcelable(this.dataWrapper, flags);
        parcel.writeByte(this.needInstall ? (byte) 1 : (byte) 0);
        parcel.writeString(this.uriData);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MiniGameVAStartData(Parcel parcel) {
        this((MiniGameVAInterceptConfig.VAInterceptConfig) r0, (MiniGameDownloadDataWrapper) r1);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Parcelable readParcelable = parcel.readParcelable(MiniGameVAInterceptConfig.VAInterceptConfig.class.getClassLoader());
        Intrinsics.checkNotNull(readParcelable);
        Parcelable readParcelable2 = parcel.readParcelable(MiniGameDownloadDataWrapper.class.getClassLoader());
        Intrinsics.checkNotNull(readParcelable2);
        this.needInstall = parcel.readByte() != 0;
        this.uriData = parcel.readString();
    }
}
