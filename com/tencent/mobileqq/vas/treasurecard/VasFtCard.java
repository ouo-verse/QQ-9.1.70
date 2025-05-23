package com.tencent.mobileqq.vas.treasurecard;

import android.content.SharedPreferences;
import com.tencent.mobileqq.vaswebviewplugin.TreasureCardJsPlugin;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0006J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J-\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u00d6\u0003J\t\u0010\u0019\u001a\u00020\bH\u00d6\u0001J\u0006\u0010\u001a\u001a\u00020\u001bJ\t\u0010\u001c\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0007\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/vas/treasurecard/VasFtCard;", "Ljava/io/Serializable;", "orderUrl", "", "imageUrl", "message", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "flowThreshold", "", "getFlowThreshold", "()I", "flowThresholdText", "getFlowThresholdText", "()Ljava/lang/String;", "getImageUrl", "getMessage", "getOrderUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toJson", "Lorg/json/JSONObject;", "toString", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final /* data */ class VasFtCard implements Serializable {

    @Nullable
    private final String imageUrl;

    @Nullable
    private final String message;

    @Nullable
    private final String orderUrl;

    public VasFtCard(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        this.orderUrl = str;
        this.imageUrl = str2;
        this.message = str3;
    }

    public static /* synthetic */ VasFtCard copy$default(VasFtCard vasFtCard, String str, String str2, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = vasFtCard.orderUrl;
        }
        if ((i3 & 2) != 0) {
            str2 = vasFtCard.imageUrl;
        }
        if ((i3 & 4) != 0) {
            str3 = vasFtCard.message;
        }
        return vasFtCard.copy(str, str2, str3);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getOrderUrl() {
        return this.orderUrl;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    @NotNull
    public final VasFtCard copy(@Nullable String orderUrl, @Nullable String imageUrl, @Nullable String message) {
        return new VasFtCard(orderUrl, imageUrl, message);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VasFtCard)) {
            return false;
        }
        VasFtCard vasFtCard = (VasFtCard) other;
        if (Intrinsics.areEqual(this.orderUrl, vasFtCard.orderUrl) && Intrinsics.areEqual(this.imageUrl, vasFtCard.imageUrl) && Intrinsics.areEqual(this.message, vasFtCard.message)) {
            return true;
        }
        return false;
    }

    public final int getFlowThreshold() {
        return BaseApplication.getContext().getSharedPreferences(FtConstants.TC_SP_NAME, 4).getInt("flowThreshold", -1);
    }

    @NotNull
    public final String getFlowThresholdText() {
        String string = BaseApplication.getContext().getSharedPreferences(FtConstants.TC_SP_NAME, 4).getString("flowThresholdText", "");
        if (string == null) {
            return "";
        }
        return string;
    }

    @Nullable
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @Nullable
    public final String getMessage() {
        return this.message;
    }

    @Nullable
    public final String getOrderUrl() {
        return this.orderUrl;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        String str = this.orderUrl;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = hashCode * 31;
        String str2 = this.imageUrl;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        String str3 = this.message;
        if (str3 != null) {
            i3 = str3.hashCode();
        }
        return i17 + i3;
    }

    @NotNull
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences(FtConstants.TC_SP_NAME, 4);
        try {
            jSONObject.put("orderUrl", this.orderUrl);
            jSONObject.put("imageUrl", this.imageUrl);
            jSONObject.put("message", this.message);
            jSONObject.put("flowThreshold", sharedPreferences.getInt("flowThreshold", -1));
            jSONObject.put("flowThresholdText", sharedPreferences.getString("flowThresholdText", ""));
        } catch (Exception e16) {
            QLog.d(TreasureCardJsPlugin.BUSINESS_NAME, 2, "toJson error" + e16.getMessage());
        }
        return jSONObject;
    }

    @NotNull
    public String toString() {
        return "VasFtCard(orderUrl=" + this.orderUrl + ", imageUrl=" + this.imageUrl + ", message=" + this.message + ")";
    }
}
