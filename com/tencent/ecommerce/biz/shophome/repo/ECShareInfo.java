package com.tencent.ecommerce.biz.shophome.repo;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\tB9\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\nR\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\t\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/repo/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "arkShareInfo", "b", "picUrl", "c", "title", "d", "desc", "e", "()Ljava/lang/String;", WadlProxyConsts.KEY_JUMP_URL, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "f", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.shophome.repo.b, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class ECShareInfo {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String arkShareInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String picUrl;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final String title;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final String desc;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final String jumpUrl;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/repo/b$a;", "", "Lorg/json/JSONObject;", "jsonObject", "Lcom/tencent/ecommerce/biz/shophome/repo/b;", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.shophome.repo.b$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final ECShareInfo a(JSONObject jsonObject) {
            return new ECShareInfo(jsonObject.optString("share_info"), jsonObject.optString("pic_url"), jsonObject.optString("title"), jsonObject.optString("desc"), jsonObject.optString("jump_url"));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ECShareInfo() {
        this(null, null, null, null, null, 31, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public int hashCode() {
        String str = this.arkShareInfo;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.picUrl;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.title;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.desc;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.jumpUrl;
        return hashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "ECShareInfo(arkShareInfo=" + this.arkShareInfo + ", picUrl=" + this.picUrl + ", title=" + this.title + ", desc=" + this.desc + ", jumpUrl=" + this.jumpUrl + ")";
    }

    public ECShareInfo(String str, String str2, String str3, String str4, String str5) {
        this.arkShareInfo = str;
        this.picUrl = str2;
        this.title = str3;
        this.desc = str4;
        this.jumpUrl = str5;
    }

    public /* synthetic */ ECShareInfo(String str, String str2, String str3, String str4, String str5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? "" : str4, (i3 & 16) != 0 ? "" : str5);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECShareInfo)) {
            return false;
        }
        ECShareInfo eCShareInfo = (ECShareInfo) other;
        return Intrinsics.areEqual(this.arkShareInfo, eCShareInfo.arkShareInfo) && Intrinsics.areEqual(this.picUrl, eCShareInfo.picUrl) && Intrinsics.areEqual(this.title, eCShareInfo.title) && Intrinsics.areEqual(this.desc, eCShareInfo.desc) && Intrinsics.areEqual(this.jumpUrl, eCShareInfo.jumpUrl);
    }
}
