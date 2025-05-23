package k81;

import com.tencent.qqnt.kernel.nativeinterface.ModelDisableStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u007f\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\t\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0002\u0012\b\b\u0002\u0010 \u001a\u00020\u0002\u0012\b\b\u0002\u0010\"\u001a\u00020\u0002\u0012\b\b\u0002\u0010#\u001a\u00020\u0002\u0012\b\b\u0002\u0010%\u001a\u00020\u0002\u0012\b\b\u0002\u0010*\u001a\u00020\u0007\u0012\b\b\u0002\u0010/\u001a\u00020+\u00a2\u0006\u0004\b0\u00101J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0015\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\fR\u0017\u0010\u0019\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0013\u0010\u0018R\u0017\u0010\u001c\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u000f\u001a\u0004\b\u001b\u0010\u0011R\u0017\u0010\u001e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u000f\u001a\u0004\b\u001d\u0010\u0011R\u0017\u0010 \u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000f\u001a\u0004\b\u001f\u0010\u0011R\u0017\u0010\"\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b!\u0010\u0011R\u0017\u0010#\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u000f\u001a\u0004\b\u0016\u0010\u0011R\u0017\u0010%\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b$\u0010\u000f\u001a\u0004\b\u000e\u0010\u0011R\"\u0010*\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b$\u0010(\"\u0004\b&\u0010)R\u0017\u0010/\u001a\u00020+8\u0006\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b\u001a\u0010.\u00a8\u00062"}, d2 = {"Lk81/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "()J", "appID", "b", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "robotUid", "c", h.F, "robotUin", "d", "I", "()I", "chatType", "e", "getModelIcon", "modelIcon", "f", "modelID", "i", "title", "getAioTitle", "aioTitle", "desc", "j", "callBackData", "k", "Z", "()Z", "(Z)V", "isSelected", "Lcom/tencent/qqnt/kernel/nativeinterface/ModelDisableStyle;", "l", "Lcom/tencent/qqnt/kernel/nativeinterface/ModelDisableStyle;", "()Lcom/tencent/qqnt/kernel/nativeinterface/ModelDisableStyle;", "disableStyle", "<init>", "(JLjava/lang/String;JILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/tencent/qqnt/kernel/nativeinterface/ModelDisableStyle;)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: k81.a, reason: from toString */
/* loaded from: classes11.dex */
public final /* data */ class RobotAIModelData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long appID;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String robotUid;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final long robotUin;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int chatType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String modelIcon;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String modelID;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String title;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String aioTitle;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String desc;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String callBackData;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isSelected;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final ModelDisableStyle disableStyle;

    public RobotAIModelData() {
        this(0L, null, 0L, 0, null, null, null, null, null, null, false, null, 4095, null);
    }

    /* renamed from: a, reason: from getter */
    public final long getAppID() {
        return this.appID;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getCallBackData() {
        return this.callBackData;
    }

    /* renamed from: c, reason: from getter */
    public final int getChatType() {
        return this.chatType;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final ModelDisableStyle getDisableStyle() {
        return this.disableStyle;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RobotAIModelData)) {
            return false;
        }
        RobotAIModelData robotAIModelData = (RobotAIModelData) other;
        if (this.appID == robotAIModelData.appID && Intrinsics.areEqual(this.robotUid, robotAIModelData.robotUid) && this.robotUin == robotAIModelData.robotUin && this.chatType == robotAIModelData.chatType && Intrinsics.areEqual(this.modelIcon, robotAIModelData.modelIcon) && Intrinsics.areEqual(this.modelID, robotAIModelData.modelID) && Intrinsics.areEqual(this.title, robotAIModelData.title) && Intrinsics.areEqual(this.aioTitle, robotAIModelData.aioTitle) && Intrinsics.areEqual(this.desc, robotAIModelData.desc) && Intrinsics.areEqual(this.callBackData, robotAIModelData.callBackData) && this.isSelected == robotAIModelData.isSelected && this.disableStyle == robotAIModelData.disableStyle) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getModelID() {
        return this.modelID;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getRobotUid() {
        return this.robotUid;
    }

    /* renamed from: h, reason: from getter */
    public final long getRobotUin() {
        return this.robotUin;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int a16 = ((((((((((((((((((androidx.fragment.app.a.a(this.appID) * 31) + this.robotUid.hashCode()) * 31) + androidx.fragment.app.a.a(this.robotUin)) * 31) + this.chatType) * 31) + this.modelIcon.hashCode()) * 31) + this.modelID.hashCode()) * 31) + this.title.hashCode()) * 31) + this.aioTitle.hashCode()) * 31) + this.desc.hashCode()) * 31) + this.callBackData.hashCode()) * 31;
        boolean z16 = this.isSelected;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return ((a16 + i3) * 31) + this.disableStyle.hashCode();
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: j, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    public final void k(boolean z16) {
        this.isSelected = z16;
    }

    @NotNull
    public String toString() {
        return "RobotAIModelData(appID=" + this.appID + ", robotUid=" + this.robotUid + ", robotUin=" + this.robotUin + ", chatType=" + this.chatType + ", modelIcon=" + this.modelIcon + ", modelID=" + this.modelID + ", title=" + this.title + ", aioTitle=" + this.aioTitle + ", desc=" + this.desc + ", callBackData=" + this.callBackData + ", isSelected=" + this.isSelected + ", disableStyle=" + this.disableStyle + ")";
    }

    public RobotAIModelData(long j3, @NotNull String robotUid, long j16, int i3, @NotNull String modelIcon, @NotNull String modelID, @NotNull String title, @NotNull String aioTitle, @NotNull String desc, @NotNull String callBackData, boolean z16, @NotNull ModelDisableStyle disableStyle) {
        Intrinsics.checkNotNullParameter(robotUid, "robotUid");
        Intrinsics.checkNotNullParameter(modelIcon, "modelIcon");
        Intrinsics.checkNotNullParameter(modelID, "modelID");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(aioTitle, "aioTitle");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(callBackData, "callBackData");
        Intrinsics.checkNotNullParameter(disableStyle, "disableStyle");
        this.appID = j3;
        this.robotUid = robotUid;
        this.robotUin = j16;
        this.chatType = i3;
        this.modelIcon = modelIcon;
        this.modelID = modelID;
        this.title = title;
        this.aioTitle = aioTitle;
        this.desc = desc;
        this.callBackData = callBackData;
        this.isSelected = z16;
        this.disableStyle = disableStyle;
    }

    public /* synthetic */ RobotAIModelData(long j3, String str, long j16, int i3, String str2, String str3, String str4, String str5, String str6, String str7, boolean z16, ModelDisableStyle modelDisableStyle, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0L : j3, (i16 & 2) != 0 ? "" : str, (i16 & 4) == 0 ? j16 : 0L, (i16 & 8) != 0 ? 1 : i3, (i16 & 16) != 0 ? "" : str2, (i16 & 32) != 0 ? "" : str3, (i16 & 64) != 0 ? "" : str4, (i16 & 128) != 0 ? "" : str5, (i16 & 256) != 0 ? "" : str6, (i16 & 512) == 0 ? str7 : "", (i16 & 1024) != 0 ? false : z16, (i16 & 2048) != 0 ? ModelDisableStyle.KMDSENABLE : modelDisableStyle);
    }
}
