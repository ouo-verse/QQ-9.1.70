package com.tencent.qqmini.sdk.server.launch;

import android.net.Uri;
import androidx.annotation.VisibleForTesting;
import com.tencent.ditto.shell.LayoutAttrDefine;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\bJ\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0005H\u0016J\u0006\u0010\u0017\u001a\u00020\u0003J\b\u0010\u0018\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qqmini/sdk/server/launch/AppIdentity;", "", "appId", "", "verType", "", "version", "name", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", LayoutAttrDefine.CLICK_URI, "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "uri$delegate", "Lkotlin/Lazy;", "getVerType", "()I", "equals", "", "other", "hashCode", "toSimpleString", "toString", "lib_miniserver_internalRelease"}, k = 1, mv = {1, 1, 16})
@VisibleForTesting
/* loaded from: classes23.dex */
public final class AppIdentity {

    @NotNull
    private final String appId;
    private final String name;

    /* renamed from: uri$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy uri;
    private final int verType;
    private final String version;

    public AppIdentity(@NotNull String appId, int i3, @Nullable String str, @Nullable String str2) {
        Lazy lazy;
        Intrinsics.checkParameterIsNotNull(appId, "appId");
        this.appId = appId;
        this.verType = i3;
        this.version = str;
        this.name = str2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Uri>() { // from class: com.tencent.qqmini.sdk.server.launch.AppIdentity$uri$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Uri invoke() {
                return Uri.parse("miniapp://launch/" + Uri.encode(AppIdentity.this.getAppId()) + '/' + AppIdentity.this.getVerType());
            }
        });
        this.uri = lazy;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppIdentity)) {
            return false;
        }
        AppIdentity appIdentity = (AppIdentity) other;
        if (!(!Intrinsics.areEqual(this.appId, appIdentity.appId)) && this.verType == appIdentity.verType) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getAppId() {
        return this.appId;
    }

    @NotNull
    public final Uri getUri() {
        return (Uri) this.uri.getValue();
    }

    public final int getVerType() {
        return this.verType;
    }

    public int hashCode() {
        return (this.appId.hashCode() * 31) + this.verType;
    }

    @NotNull
    public final String toSimpleString() {
        return "(appId='" + this.appId + "', name='" + this.name + "')";
    }

    @NotNull
    public String toString() {
        return "AppIdentity(appId='" + this.appId + "', name='" + this.name + "', verType=" + this.verType + ", version='" + this.version + "')";
    }

    public /* synthetic */ AppIdentity(String str, int i3, String str2, String str3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i3, (i16 & 4) != 0 ? "" : str2, (i16 & 8) != 0 ? "" : str3);
    }
}
