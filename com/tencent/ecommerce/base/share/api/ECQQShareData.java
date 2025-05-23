package com.tencent.ecommerce.base.share.api;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0016\u001a\u0004\b\u000e\u0010\u0017R\u0017\u0010\u001d\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u001e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u0006!"}, d2 = {"Lcom/tencent/ecommerce/base/share/api/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "shareToFriendUin", "b", "d", "shareToFriendUinName", "I", "e", "()I", "shareToFriendUinType", "Lorg/json/JSONObject;", "Lorg/json/JSONObject;", "()Lorg/json/JSONObject;", "shareJson", "Lcom/tencent/ecommerce/base/share/api/ShareType;", "Lcom/tencent/ecommerce/base/share/api/ShareType;", "f", "()Lcom/tencent/ecommerce/base/share/api/ShareType;", "shareType", "picPath", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILorg/json/JSONObject;Lcom/tencent/ecommerce/base/share/api/ShareType;Ljava/lang/String;)V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.base.share.api.c, reason: from toString */
/* loaded from: classes5.dex */
public final /* data */ class ECQQShareData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String shareToFriendUin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String shareToFriendUinName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int shareToFriendUinType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final JSONObject shareJson;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final ShareType shareType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String picPath;

    public ECQQShareData() {
        this(null, null, 0, null, null, null, 63, null);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getPicPath() {
        return this.picPath;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final JSONObject getShareJson() {
        return this.shareJson;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getShareToFriendUin() {
        return this.shareToFriendUin;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getShareToFriendUinName() {
        return this.shareToFriendUinName;
    }

    /* renamed from: e, reason: from getter */
    public final int getShareToFriendUinType() {
        return this.shareToFriendUinType;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof ECQQShareData) {
                ECQQShareData eCQQShareData = (ECQQShareData) other;
                if (!Intrinsics.areEqual(this.shareToFriendUin, eCQQShareData.shareToFriendUin) || !Intrinsics.areEqual(this.shareToFriendUinName, eCQQShareData.shareToFriendUinName) || this.shareToFriendUinType != eCQQShareData.shareToFriendUinType || !Intrinsics.areEqual(this.shareJson, eCQQShareData.shareJson) || !Intrinsics.areEqual(this.shareType, eCQQShareData.shareType) || !Intrinsics.areEqual(this.picPath, eCQQShareData.picPath)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final ShareType getShareType() {
        return this.shareType;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        String str = this.shareToFriendUin;
        int i19 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i26 = i3 * 31;
        String str2 = this.shareToFriendUinName;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i27 = (((i26 + i16) * 31) + this.shareToFriendUinType) * 31;
        JSONObject jSONObject = this.shareJson;
        if (jSONObject != null) {
            i17 = jSONObject.hashCode();
        } else {
            i17 = 0;
        }
        int i28 = (i27 + i17) * 31;
        ShareType shareType = this.shareType;
        if (shareType != null) {
            i18 = shareType.hashCode();
        } else {
            i18 = 0;
        }
        int i29 = (i28 + i18) * 31;
        String str3 = this.picPath;
        if (str3 != null) {
            i19 = str3.hashCode();
        }
        return i29 + i19;
    }

    @NotNull
    public String toString() {
        return "ECQQShareData(shareToFriendUin=" + this.shareToFriendUin + ", shareToFriendUinName=" + this.shareToFriendUinName + ", shareToFriendUinType=" + this.shareToFriendUinType + ", shareJson=" + this.shareJson + ", shareType=" + this.shareType + ", picPath=" + this.picPath + ")";
    }

    public ECQQShareData(@NotNull String str, @NotNull String str2, int i3, @Nullable JSONObject jSONObject, @NotNull ShareType shareType, @NotNull String str3) {
        this.shareToFriendUin = str;
        this.shareToFriendUinName = str2;
        this.shareToFriendUinType = i3;
        this.shareJson = jSONObject;
        this.shareType = shareType;
        this.picPath = str3;
    }

    public /* synthetic */ ECQQShareData(String str, String str2, int i3, JSONObject jSONObject, ShareType shareType, String str3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? "" : str, (i16 & 2) != 0 ? "" : str2, (i16 & 4) != 0 ? -1 : i3, (i16 & 8) != 0 ? null : jSONObject, (i16 & 16) != 0 ? ShareType.IMAGE_AND_TEXT_SHARE_TYPE : shareType, (i16 & 32) != 0 ? "" : str3);
    }
}
