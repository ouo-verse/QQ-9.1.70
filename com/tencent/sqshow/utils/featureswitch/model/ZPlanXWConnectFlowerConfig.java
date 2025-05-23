package com.tencent.sqshow.utils.featureswitch.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\u001a\u0010\u0013\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0014\u0010\fR\u001a\u0010\u0015\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0016\u0010\f\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/sqshow/utils/featureswitch/model/ap;", "", "", "toString", "", "hashCode", "other", "", "equals", "experiencePrefixUrl", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "selfPlantBubble", "f", "friendPlantBubble", "b", "removeDialogPromptText", "e", "removeDialogMaxLevelPromptText", "d", "networkExceptionPromptText", "c", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "superqqshow-base-kit_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.utils.featureswitch.model.ap, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class ZPlanXWConnectFlowerConfig {

    @SerializedName("experiencePrefixUrl")
    private final String experiencePrefixUrl;

    @SerializedName("friend_plant_bubble")
    private final String friendPlantBubble;

    @SerializedName("network_exception_prompt_text")
    private final String networkExceptionPromptText;

    @SerializedName("remove_dialog_max_level_prompt_text")
    private final String removeDialogMaxLevelPromptText;

    @SerializedName("remove_dialog_prompt_text")
    private final String removeDialogPromptText;

    @SerializedName("self_plant_bubble")
    private final String selfPlantBubble;

    public ZPlanXWConnectFlowerConfig() {
        this(null, null, null, null, null, null, 63, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getExperiencePrefixUrl() {
        return this.experiencePrefixUrl;
    }

    /* renamed from: b, reason: from getter */
    public final String getFriendPlantBubble() {
        return this.friendPlantBubble;
    }

    /* renamed from: c, reason: from getter */
    public final String getNetworkExceptionPromptText() {
        return this.networkExceptionPromptText;
    }

    /* renamed from: d, reason: from getter */
    public final String getRemoveDialogMaxLevelPromptText() {
        return this.removeDialogMaxLevelPromptText;
    }

    /* renamed from: e, reason: from getter */
    public final String getRemoveDialogPromptText() {
        return this.removeDialogPromptText;
    }

    /* renamed from: f, reason: from getter */
    public final String getSelfPlantBubble() {
        return this.selfPlantBubble;
    }

    public int hashCode() {
        return (((((((((this.experiencePrefixUrl.hashCode() * 31) + this.selfPlantBubble.hashCode()) * 31) + this.friendPlantBubble.hashCode()) * 31) + this.removeDialogPromptText.hashCode()) * 31) + this.removeDialogMaxLevelPromptText.hashCode()) * 31) + this.networkExceptionPromptText.hashCode();
    }

    public String toString() {
        return "ZPlanXWConnectFlowerConfig(experiencePrefixUrl=" + this.experiencePrefixUrl + ", selfPlantBubble=" + this.selfPlantBubble + ", friendPlantBubble=" + this.friendPlantBubble + ", removeDialogPromptText=" + this.removeDialogPromptText + ", removeDialogMaxLevelPromptText=" + this.removeDialogMaxLevelPromptText + ", networkExceptionPromptText=" + this.networkExceptionPromptText + ')';
    }

    public ZPlanXWConnectFlowerConfig(String experiencePrefixUrl, String selfPlantBubble, String friendPlantBubble, String removeDialogPromptText, String removeDialogMaxLevelPromptText, String networkExceptionPromptText) {
        Intrinsics.checkNotNullParameter(experiencePrefixUrl, "experiencePrefixUrl");
        Intrinsics.checkNotNullParameter(selfPlantBubble, "selfPlantBubble");
        Intrinsics.checkNotNullParameter(friendPlantBubble, "friendPlantBubble");
        Intrinsics.checkNotNullParameter(removeDialogPromptText, "removeDialogPromptText");
        Intrinsics.checkNotNullParameter(removeDialogMaxLevelPromptText, "removeDialogMaxLevelPromptText");
        Intrinsics.checkNotNullParameter(networkExceptionPromptText, "networkExceptionPromptText");
        this.experiencePrefixUrl = experiencePrefixUrl;
        this.selfPlantBubble = selfPlantBubble;
        this.friendPlantBubble = friendPlantBubble;
        this.removeDialogPromptText = removeDialogPromptText;
        this.removeDialogMaxLevelPromptText = removeDialogMaxLevelPromptText;
        this.networkExceptionPromptText = networkExceptionPromptText;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanXWConnectFlowerConfig)) {
            return false;
        }
        ZPlanXWConnectFlowerConfig zPlanXWConnectFlowerConfig = (ZPlanXWConnectFlowerConfig) other;
        return Intrinsics.areEqual(this.experiencePrefixUrl, zPlanXWConnectFlowerConfig.experiencePrefixUrl) && Intrinsics.areEqual(this.selfPlantBubble, zPlanXWConnectFlowerConfig.selfPlantBubble) && Intrinsics.areEqual(this.friendPlantBubble, zPlanXWConnectFlowerConfig.friendPlantBubble) && Intrinsics.areEqual(this.removeDialogPromptText, zPlanXWConnectFlowerConfig.removeDialogPromptText) && Intrinsics.areEqual(this.removeDialogMaxLevelPromptText, zPlanXWConnectFlowerConfig.removeDialogMaxLevelPromptText) && Intrinsics.areEqual(this.networkExceptionPromptText, zPlanXWConnectFlowerConfig.networkExceptionPromptText);
    }

    public /* synthetic */ ZPlanXWConnectFlowerConfig(String str, String str2, String str3, String str4, String str5, String str6, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "https://image.superqqshow.qq.com/qq/mini_home/huateng/figures/" : str, (i3 & 2) != 0 ? "https://image.superqqshow.qq.com/qq/mini_home/huateng/msg_bub_self.png" : str2, (i3 & 4) != 0 ? "https://image.superqqshow.qq.com/qq/mini_home/huateng/msg_bub_friend.png" : str3, (i3 & 8) != 0 ? "\u94f2\u9664\u540e\uff0c\u91cd\u65b0\u79cd\u690d\u4f1a\u4ece0\u5f00\u59cb\u751f\u957f\uff0c\u786e\u8ba4\u94f2\u9664\u4e48\uff1f" : str4, (i3 & 16) != 0 ? "\u82b1\u85e4\u5df2\u6ee1\u7ea7\uff0c\u91cd\u65b0\u79cd\u690d\u53ef\u76f4\u63a5\u79cd\u4e0b\u6ee1\u7ea7\u82b1\u85e4\u3002\u94f2\u6389\u6362\u522b\u7684\u82b1\u85e4\u8bd5\u8bd5\u5427~" : str5, (i3 & 32) != 0 ? "\u5f53\u524d\u7f51\u7edc\u4e0d\u53ef\u7528\uff0c\u8bf7\u68c0\u67e5\u7f51\u7edc\u8bbe\u7f6e" : str6);
    }
}
