package com.tencent.state.mmkv;

import cooperation.qzone.remote.logic.RemoteHandleConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B3\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00028\u0000\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nR\u0013\u0010\u0006\u001a\u00028\u0000\u00a2\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/state/mmkv/MigrateItem;", "T", "", "sourceKey", "", "targetKey", RemoteHandleConst.PARAM_DEFAULT_VALUE, "postFix", "ignoreFillUin", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Z)V", "getDefaultValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getIgnoreFillUin", "()Z", "getPostFix", "()Ljava/lang/String;", "getSourceKey", "getTargetKey", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
final class MigrateItem<T> {
    private final T defaultValue;
    private final boolean ignoreFillUin;
    private final String postFix;
    private final String sourceKey;
    private final String targetKey;

    public MigrateItem(String sourceKey, String targetKey, T t16, String postFix, boolean z16) {
        Intrinsics.checkNotNullParameter(sourceKey, "sourceKey");
        Intrinsics.checkNotNullParameter(targetKey, "targetKey");
        Intrinsics.checkNotNullParameter(postFix, "postFix");
        this.sourceKey = sourceKey;
        this.targetKey = targetKey;
        this.defaultValue = t16;
        this.postFix = postFix;
        this.ignoreFillUin = z16;
    }

    public final T getDefaultValue() {
        return this.defaultValue;
    }

    public final boolean getIgnoreFillUin() {
        return this.ignoreFillUin;
    }

    public final String getPostFix() {
        return this.postFix;
    }

    public final String getSourceKey() {
        return this.sourceKey;
    }

    public final String getTargetKey() {
        return this.targetKey;
    }

    public /* synthetic */ MigrateItem(String str, String str2, Object obj, String str3, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? str : str2, obj, (i3 & 8) != 0 ? "" : str3, (i3 & 16) != 0 ? false : z16);
    }
}
