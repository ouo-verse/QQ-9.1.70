package com.tencent.mobileqq.zootopia.lua;

import com.google.gson.annotations.SerializedName;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.zplan.proxy.api.IZPlanShareProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0012\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018BO\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0006\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u001a\u001a\u00020\u0006\u0012\u0006\u0010\u001c\u001a\u00020\u0004\u0012\u0006\u0010\u001e\u001a\u00020\u0004\u0012\u0006\u0010 \u001a\u00020\u0006\u0012\u0006\u0010\"\u001a\u00020\u0006\u00a2\u0006\u0004\b$\u0010%B\t\b\u0016\u00a2\u0006\u0004\b$\u0010&J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\u000b\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0016\u001a\u00020\u00158\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001a\u0010\f\u001a\u0004\b\u001b\u0010\u000eR\u001a\u0010\u001c\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0010\u001a\u0004\b\u001d\u0010\u0012R\u001a\u0010\u001e\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0010\u001a\u0004\b\u001f\u0010\u0012R\u001a\u0010 \u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b \u0010\f\u001a\u0004\b!\u0010\u000eR\u001a\u0010\"\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\"\u0010\f\u001a\u0004\b#\u0010\u000e\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/zootopia/lua/x;", "", "Lcom/tencent/zplan/proxy/api/IZPlanShareProxy$ShareData;", "d", "", "toString", "", "hashCode", "other", "", "equals", "mSameStyleID", "I", "c", "()I", "mSameStyleName", "Ljava/lang/String;", "getMSameStyleName", "()Ljava/lang/String;", "mContentType", "getMContentType", "", "mMixProgress", UserInfo.SEX_FEMALE, "a", "()F", "mMixState", "b", "mMixMsg", "getMMixMsg", "mUrl", "getMUrl", "mSameStyleMode", "getMSameStyleMode", "mTemplateTab", "getMTemplateTab", "<init>", "(ILjava/lang/String;IFILjava/lang/String;Ljava/lang/String;II)V", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zootopia.lua.x, reason: from toString */
/* loaded from: classes35.dex */
public final /* data */ class ZPlanSameStyleProgress {

    @SerializedName("ContentType")
    private final int mContentType;

    @SerializedName("MixMsg")
    private final String mMixMsg;

    @SerializedName("MixProgress")
    private final float mMixProgress;

    @SerializedName("MixState")
    private final int mMixState;

    @SerializedName("SameStyleID")
    private final int mSameStyleID;

    @SerializedName("SameStyleMode")
    private final int mSameStyleMode;

    @SerializedName("SameStyleName")
    private final String mSameStyleName;

    @SerializedName("TemplateTab")
    private final int mTemplateTab;

    @SerializedName("Url")
    private final String mUrl;

    public ZPlanSameStyleProgress(int i3, String mSameStyleName, int i16, float f16, int i17, String mMixMsg, String mUrl, int i18, int i19) {
        Intrinsics.checkNotNullParameter(mSameStyleName, "mSameStyleName");
        Intrinsics.checkNotNullParameter(mMixMsg, "mMixMsg");
        Intrinsics.checkNotNullParameter(mUrl, "mUrl");
        this.mSameStyleID = i3;
        this.mSameStyleName = mSameStyleName;
        this.mContentType = i16;
        this.mMixProgress = f16;
        this.mMixState = i17;
        this.mMixMsg = mMixMsg;
        this.mUrl = mUrl;
        this.mSameStyleMode = i18;
        this.mTemplateTab = i19;
    }

    /* renamed from: a, reason: from getter */
    public final float getMMixProgress() {
        return this.mMixProgress;
    }

    /* renamed from: b, reason: from getter */
    public final int getMMixState() {
        return this.mMixState;
    }

    /* renamed from: c, reason: from getter */
    public final int getMSameStyleID() {
        return this.mSameStyleID;
    }

    public final IZPlanShareProxy.ShareData d() {
        return new IZPlanShareProxy.ShareData(this.mSameStyleID, this.mContentType, this.mUrl, this.mTemplateTab);
    }

    public int hashCode() {
        return (((((((((((((((this.mSameStyleID * 31) + this.mSameStyleName.hashCode()) * 31) + this.mContentType) * 31) + Float.floatToIntBits(this.mMixProgress)) * 31) + this.mMixState) * 31) + this.mMixMsg.hashCode()) * 31) + this.mUrl.hashCode()) * 31) + this.mSameStyleMode) * 31) + this.mTemplateTab;
    }

    public String toString() {
        return "ZPlanSameStyleProgress(mSameStyleID=" + this.mSameStyleID + ", mSameStyleName=" + this.mSameStyleName + ", mContentType=" + this.mContentType + ", mMixProgress=" + this.mMixProgress + ", mMixState=" + this.mMixState + ", mMixMsg=" + this.mMixMsg + ", mUrl=" + this.mUrl + ", mSameStyleMode=" + this.mSameStyleMode + ", mTemplateTab=" + this.mTemplateTab + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanSameStyleProgress)) {
            return false;
        }
        ZPlanSameStyleProgress zPlanSameStyleProgress = (ZPlanSameStyleProgress) other;
        return this.mSameStyleID == zPlanSameStyleProgress.mSameStyleID && Intrinsics.areEqual(this.mSameStyleName, zPlanSameStyleProgress.mSameStyleName) && this.mContentType == zPlanSameStyleProgress.mContentType && Float.compare(this.mMixProgress, zPlanSameStyleProgress.mMixProgress) == 0 && this.mMixState == zPlanSameStyleProgress.mMixState && Intrinsics.areEqual(this.mMixMsg, zPlanSameStyleProgress.mMixMsg) && Intrinsics.areEqual(this.mUrl, zPlanSameStyleProgress.mUrl) && this.mSameStyleMode == zPlanSameStyleProgress.mSameStyleMode && this.mTemplateTab == zPlanSameStyleProgress.mTemplateTab;
    }

    public ZPlanSameStyleProgress() {
        this(0, "", -1, 0.0f, 0, "", "", 0, 0);
    }
}
