package cl;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b,\b\u0086\b\u0018\u0000 22\u00020\u0001:\u0001\tBc\u0012\b\b\u0003\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0003\u0010\u0017\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0004\u0012\b\b\u0002\u0010!\u001a\u00020\u0007\u0012\b\b\u0002\u0010$\u001a\u00020\u0002\u0012\b\b\u0002\u0010&\u001a\u00020\u0004\u0012\b\b\u0002\u0010*\u001a\u00020\u0007\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0000\u00a2\u0006\u0004\b0\u00101J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0017\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\rR\"\u0010\u001a\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\n\u001a\u0004\b\u0018\u0010\u000b\"\u0004\b\u0019\u0010\rR\"\u0010!\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010$\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u0010\u001a\u0004\b\"\u0010\u0011\"\u0004\b#\u0010\u0013R\"\u0010&\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\n\u001a\u0004\b\u001b\u0010\u000b\"\u0004\b%\u0010\rR\"\u0010*\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010\u001c\u001a\u0004\b(\u0010\u001e\"\u0004\b)\u0010 R\u0019\u0010/\u001a\u0004\u0018\u00010\u00008\u0006\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\u00a8\u00063"}, d2 = {"Lcl/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "setActionIconRes", "(I)V", "actionIconRes", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "setActionText", "(Ljava/lang/String;)V", "actionText", "c", "setActionTextColor", "actionTextColor", "d", "setActionType", "actionType", "e", "Z", "g", "()Z", "setShowRapidReply", "(Z)V", "isShowRapidReply", "f", "setRapidReplyRichText", "rapidReplyRichText", "setRapidActionType", "rapidActionType", h.F, "getShouldChangeStateOnClick", "setShouldChangeStateOnClick", "shouldChangeStateOnClick", "i", "Lcl/c;", "getNextState", "()Lcl/c;", "nextState", "<init>", "(ILjava/lang/String;IIZLjava/lang/String;IZLcl/c;)V", "j", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: cl.c, reason: from toString */
/* loaded from: classes39.dex */
public final /* data */ class CommonNoticeInteractiveInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private int actionIconRes;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private String actionText;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private int actionTextColor;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private int actionType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isShowRapidReply;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private String rapidReplyRichText;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private int rapidActionType;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean shouldChangeStateOnClick;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private final CommonNoticeInteractiveInfo nextState;

    public CommonNoticeInteractiveInfo() {
        this(0, null, 0, 0, false, null, 0, false, null, 511, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getActionIconRes() {
        return this.actionIconRes;
    }

    /* renamed from: b, reason: from getter */
    public final String getActionText() {
        return this.actionText;
    }

    /* renamed from: c, reason: from getter */
    public final int getActionTextColor() {
        return this.actionTextColor;
    }

    /* renamed from: d, reason: from getter */
    public final int getActionType() {
        return this.actionType;
    }

    /* renamed from: e, reason: from getter */
    public final int getRapidActionType() {
        return this.rapidActionType;
    }

    /* renamed from: f, reason: from getter */
    public final String getRapidReplyRichText() {
        return this.rapidReplyRichText;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getIsShowRapidReply() {
        return this.isShowRapidReply;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((this.actionIconRes * 31) + this.actionText.hashCode()) * 31) + this.actionTextColor) * 31) + this.actionType) * 31;
        boolean z16 = this.isShowRapidReply;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int hashCode2 = (((((hashCode + i3) * 31) + this.rapidReplyRichText.hashCode()) * 31) + this.rapidActionType) * 31;
        boolean z17 = this.shouldChangeStateOnClick;
        int i16 = (hashCode2 + (z17 ? 1 : z17 ? 1 : 0)) * 31;
        CommonNoticeInteractiveInfo commonNoticeInteractiveInfo = this.nextState;
        return i16 + (commonNoticeInteractiveInfo == null ? 0 : commonNoticeInteractiveInfo.hashCode());
    }

    public String toString() {
        return "CommonNoticeInteractiveInfo(actionIconRes=" + this.actionIconRes + ", actionText=" + this.actionText + ", actionTextColor=" + this.actionTextColor + ", actionType=" + this.actionType + ", isShowRapidReply=" + this.isShowRapidReply + ", rapidReplyRichText=" + this.rapidReplyRichText + ", rapidActionType=" + this.rapidActionType + ", shouldChangeStateOnClick=" + this.shouldChangeStateOnClick + ", nextState=" + this.nextState + ")";
    }

    public CommonNoticeInteractiveInfo(int i3, String actionText, int i16, int i17, boolean z16, String rapidReplyRichText, int i18, boolean z17, CommonNoticeInteractiveInfo commonNoticeInteractiveInfo) {
        Intrinsics.checkNotNullParameter(actionText, "actionText");
        Intrinsics.checkNotNullParameter(rapidReplyRichText, "rapidReplyRichText");
        this.actionIconRes = i3;
        this.actionText = actionText;
        this.actionTextColor = i16;
        this.actionType = i17;
        this.isShowRapidReply = z16;
        this.rapidReplyRichText = rapidReplyRichText;
        this.rapidActionType = i18;
        this.shouldChangeStateOnClick = z17;
        this.nextState = commonNoticeInteractiveInfo;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommonNoticeInteractiveInfo)) {
            return false;
        }
        CommonNoticeInteractiveInfo commonNoticeInteractiveInfo = (CommonNoticeInteractiveInfo) other;
        return this.actionIconRes == commonNoticeInteractiveInfo.actionIconRes && Intrinsics.areEqual(this.actionText, commonNoticeInteractiveInfo.actionText) && this.actionTextColor == commonNoticeInteractiveInfo.actionTextColor && this.actionType == commonNoticeInteractiveInfo.actionType && this.isShowRapidReply == commonNoticeInteractiveInfo.isShowRapidReply && Intrinsics.areEqual(this.rapidReplyRichText, commonNoticeInteractiveInfo.rapidReplyRichText) && this.rapidActionType == commonNoticeInteractiveInfo.rapidActionType && this.shouldChangeStateOnClick == commonNoticeInteractiveInfo.shouldChangeStateOnClick && Intrinsics.areEqual(this.nextState, commonNoticeInteractiveInfo.nextState);
    }

    public /* synthetic */ CommonNoticeInteractiveInfo(int i3, String str, int i16, int i17, boolean z16, String str2, int i18, boolean z17, CommonNoticeInteractiveInfo commonNoticeInteractiveInfo, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this((i19 & 1) != 0 ? 0 : i3, (i19 & 2) != 0 ? "" : str, (i19 & 4) != 0 ? 0 : i16, (i19 & 8) != 0 ? 0 : i17, (i19 & 16) != 0 ? false : z16, (i19 & 32) == 0 ? str2 : "", (i19 & 64) != 0 ? 100 : i18, (i19 & 128) == 0 ? z17 : false, (i19 & 256) != 0 ? null : commonNoticeInteractiveInfo);
    }
}
