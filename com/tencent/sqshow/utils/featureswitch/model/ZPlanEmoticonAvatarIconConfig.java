package com.tencent.sqshow.utils.featureswitch.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\r\u0010\u000bR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0013\u0010\u0011R\u0017\u0010\u0019\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/sqshow/utils/featureswitch/model/t;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "actionId", "b", "avatarSize", "c", "Ljava/lang/String;", "()Ljava/lang/String;", "defaultFemaleUrl", "d", "defaultMaleUrl", "e", "Z", "getNeedUpload", "()Z", "needUpload", "<init>", "(IILjava/lang/String;Ljava/lang/String;Z)V", "superqqshow-base-kit_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.utils.featureswitch.model.t, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class ZPlanEmoticonAvatarIconConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int actionId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int avatarSize;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final String defaultFemaleUrl;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final String defaultMaleUrl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean needUpload;

    public ZPlanEmoticonAvatarIconConfig(int i3, int i16, String str, String str2, boolean z16) {
        this.actionId = i3;
        this.avatarSize = i16;
        this.defaultFemaleUrl = str;
        this.defaultMaleUrl = str2;
        this.needUpload = z16;
    }

    /* renamed from: a, reason: from getter */
    public final int getActionId() {
        return this.actionId;
    }

    /* renamed from: b, reason: from getter */
    public final int getAvatarSize() {
        return this.avatarSize;
    }

    /* renamed from: c, reason: from getter */
    public final String getDefaultFemaleUrl() {
        return this.defaultFemaleUrl;
    }

    /* renamed from: d, reason: from getter */
    public final String getDefaultMaleUrl() {
        return this.defaultMaleUrl;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3 = ((this.actionId * 31) + this.avatarSize) * 31;
        String str = this.defaultFemaleUrl;
        int hashCode = (i3 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.defaultMaleUrl;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z16 = this.needUpload;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        return hashCode2 + i16;
    }

    public String toString() {
        return "ZPlanEmoticonAvatarIconConfig(actionId=" + this.actionId + ", avatarSize=" + this.avatarSize + ", defaultFemaleUrl=" + this.defaultFemaleUrl + ", defaultMaleUrl=" + this.defaultMaleUrl + ", needUpload=" + this.needUpload + ')';
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanEmoticonAvatarIconConfig)) {
            return false;
        }
        ZPlanEmoticonAvatarIconConfig zPlanEmoticonAvatarIconConfig = (ZPlanEmoticonAvatarIconConfig) other;
        return this.actionId == zPlanEmoticonAvatarIconConfig.actionId && this.avatarSize == zPlanEmoticonAvatarIconConfig.avatarSize && Intrinsics.areEqual(this.defaultFemaleUrl, zPlanEmoticonAvatarIconConfig.defaultFemaleUrl) && Intrinsics.areEqual(this.defaultMaleUrl, zPlanEmoticonAvatarIconConfig.defaultMaleUrl) && this.needUpload == zPlanEmoticonAvatarIconConfig.needUpload;
    }
}
