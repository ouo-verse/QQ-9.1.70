package jp2;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b\u00a8\u0006\u000e"}, d2 = {"Ljp2/d;", "", "", "enableDirect", "Z", "a", "()Z", "setEnableDirect", "(Z)V", "enableNet", "b", "setEnableNet", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class d {

    @SerializedName("enableDirect")
    private boolean enableDirect = true;

    @SerializedName("enableNet")
    private boolean enableNet = true;

    /* renamed from: a, reason: from getter */
    public final boolean getEnableDirect() {
        return this.enableDirect;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getEnableNet() {
        return this.enableNet;
    }
}
