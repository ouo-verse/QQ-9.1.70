package com.tencent.mobileqq.minigame.va;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 42\u00020\u0001:\u00014B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\b\u0010/\u001a\u00020\rH\u0016J\b\u00100\u001a\u00020\u001eH\u0016J\u0018\u00101\u001a\u0002022\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00103\u001a\u00020\rH\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000f\"\u0004\b\u001c\u0010\u0011R\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0017\"\u0004\b%\u0010\u0019R\u001a\u0010&\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0017\"\u0004\b(\u0010\u0019R\u001a\u0010)\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u000f\"\u0004\b+\u0010\u0011R\u001a\u0010,\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u000f\"\u0004\b.\u0010\u0011\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/minigame/va/MiniGameDownloadDataWrapper;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "data", "Lcom/tencent/mobileqq/minigame/va/MiniGameDownloadData;", "getData", "()Lcom/tencent/mobileqq/minigame/va/MiniGameDownloadData;", "setData", "(Lcom/tencent/mobileqq/minigame/va/MiniGameDownloadData;)V", VirtualAppProxy.KEY_DOWNLOAD_STATUS, "", "getDownloadStatus", "()I", "setDownloadStatus", "(I)V", "errorCode", "getErrorCode", "setErrorCode", "isAutoInstall", "", "()Z", "setAutoInstall", "(Z)V", "launchScene", "getLaunchScene", "setLaunchScene", "launchVia", "", "getLaunchVia", "()Ljava/lang/String;", "setLaunchVia", "(Ljava/lang/String;)V", "notNotifyWhenDelete", "getNotNotifyWhenDelete", "setNotNotifyWhenDelete", "onlyOnWifi", "getOnlyOnWifi", "setOnlyOnWifi", "progress", HippyQQPagView.FunctionName.GET_PROGRESS, HippyQQPagView.FunctionName.SET_PROGRESS, "scene", "getScene", "setScene", "describeContents", "toString", "writeToParcel", "", WadlProxyConsts.FLAGS, "CREATOR", "qqmini-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public final class MiniGameDownloadDataWrapper implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private MiniGameDownloadData data;
    private int downloadStatus;
    private int errorCode;
    private boolean isAutoInstall;
    private int launchScene;

    @NotNull
    private String launchVia;
    private boolean notNotifyWhenDelete;
    private boolean onlyOnWifi;
    private int progress;
    private int scene;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/minigame/va/MiniGameDownloadDataWrapper$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/minigame/va/MiniGameDownloadDataWrapper;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mobileqq/minigame/va/MiniGameDownloadDataWrapper;", "qqmini-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.minigame.va.MiniGameDownloadDataWrapper$CREATOR, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion implements Parcelable.Creator<MiniGameDownloadDataWrapper> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public MiniGameDownloadDataWrapper createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new MiniGameDownloadDataWrapper(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public MiniGameDownloadDataWrapper[] newArray(int size) {
            return new MiniGameDownloadDataWrapper[size];
        }
    }

    public MiniGameDownloadDataWrapper() {
        this.data = new MiniGameDownloadData();
        this.isAutoInstall = true;
        this.scene = DownloadScene.SCENE_INSTALL_UNKNOW.getScene();
        this.launchVia = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final MiniGameDownloadData getData() {
        return this.data;
    }

    public final int getDownloadStatus() {
        return this.downloadStatus;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final int getLaunchScene() {
        return this.launchScene;
    }

    @NotNull
    public final String getLaunchVia() {
        return this.launchVia;
    }

    public final boolean getNotNotifyWhenDelete() {
        return this.notNotifyWhenDelete;
    }

    public final boolean getOnlyOnWifi() {
        return this.onlyOnWifi;
    }

    public final int getProgress() {
        return this.progress;
    }

    public final int getScene() {
        return this.scene;
    }

    /* renamed from: isAutoInstall, reason: from getter */
    public final boolean getIsAutoInstall() {
        return this.isAutoInstall;
    }

    public final void setAutoInstall(boolean z16) {
        this.isAutoInstall = z16;
    }

    public final void setData(@NotNull MiniGameDownloadData miniGameDownloadData) {
        Intrinsics.checkNotNullParameter(miniGameDownloadData, "<set-?>");
        this.data = miniGameDownloadData;
    }

    public final void setDownloadStatus(int i3) {
        this.downloadStatus = i3;
    }

    public final void setErrorCode(int i3) {
        this.errorCode = i3;
    }

    public final void setLaunchScene(int i3) {
        this.launchScene = i3;
    }

    public final void setLaunchVia(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.launchVia = str;
    }

    public final void setNotNotifyWhenDelete(boolean z16) {
        this.notNotifyWhenDelete = z16;
    }

    public final void setOnlyOnWifi(boolean z16) {
        this.onlyOnWifi = z16;
    }

    public final void setProgress(int i3) {
        this.progress = i3;
    }

    public final void setScene(int i3) {
        this.scene = i3;
    }

    @NotNull
    public String toString() {
        return "(downloadStatus:" + this.downloadStatus + ",progress:" + this.progress + ",isAutoInstall:" + this.isAutoInstall + ",scene:" + this.scene + ",data:" + this.data + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.data, flags);
        parcel.writeInt(this.downloadStatus);
        parcel.writeInt(this.progress);
        parcel.writeInt(this.isAutoInstall ? 1 : 0);
        parcel.writeInt(this.launchScene);
        parcel.writeString(this.launchVia);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MiniGameDownloadDataWrapper(@NotNull Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        MiniGameDownloadData miniGameDownloadData = (MiniGameDownloadData) parcel.readParcelable(MiniGameDownloadData.class.getClassLoader());
        this.data = miniGameDownloadData == null ? new MiniGameDownloadData() : miniGameDownloadData;
        this.downloadStatus = parcel.readInt();
        this.progress = parcel.readInt();
        this.isAutoInstall = parcel.readByte() != 0;
        this.launchScene = parcel.readInt();
        String readString = parcel.readString();
        this.launchVia = readString == null ? "" : readString;
    }
}
