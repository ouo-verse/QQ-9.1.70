package com.tencent.ecommerce.repo.live;

import com.tencent.ark.ark;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u0016\u001a\u00020\u0006\u0012\u0006\u0010\u0018\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0019\u0010\u001aB\u0013\b\u0016\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u00a2\u0006\u0004\b\u0019\u0010\u001dJ\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0016\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0018\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0011\u001a\u0004\b\n\u0010\u0013\"\u0004\b\u0017\u0010\u0015\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/ecommerce/repo/live/p;", "", "", "d", "", "toString", "", "hashCode", "other", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "url", "I", "c", "()I", "setWidth", "(I)V", "width", "setHeight", "height", "<init>", "(Ljava/lang/String;II)V", "Lorg/json/JSONObject;", ark.ARKMETADATA_JSON, "(Lorg/json/JSONObject;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.repo.live.p, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class LivePicInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private String url;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private int width;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private int height;

    public LivePicInfo(String str, int i3, int i16) {
        this.url = str;
        this.width = i3;
        this.height = i16;
    }

    /* renamed from: a, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* renamed from: b, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: c, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    public final boolean d() {
        boolean z16;
        boolean isBlank;
        String str = this.url;
        if (str != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                z16 = false;
                return z16 && this.width > 0 && this.height > 0;
            }
        }
        z16 = true;
        if (z16) {
        }
    }

    public int hashCode() {
        String str = this.url;
        return ((((str != null ? str.hashCode() : 0) * 31) + this.width) * 31) + this.height;
    }

    public String toString() {
        return "LivePicInfo(url=" + this.url + ", width=" + this.width + ", height=" + this.height + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public LivePicInfo(JSONObject jSONObject) {
        this(r0, jSONObject != null ? jSONObject.optInt("width") : 0, jSONObject != null ? jSONObject.optInt("height") : 0);
        String optString;
        String str = "";
        if (jSONObject != null && (optString = jSONObject.optString("url", "")) != null) {
            str = optString;
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LivePicInfo)) {
            return false;
        }
        LivePicInfo livePicInfo = (LivePicInfo) other;
        return Intrinsics.areEqual(this.url, livePicInfo.url) && this.width == livePicInfo.width && this.height == livePicInfo.height;
    }
}
