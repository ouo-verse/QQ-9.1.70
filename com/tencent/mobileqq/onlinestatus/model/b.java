package com.tencent.mobileqq.onlinestatus.model;

import com.qq.e.comm.managers.plugin.PM;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0016R\u0017\u0010\n\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\f\u001a\u0004\b\u000b\u0010\u000e\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/model/b;", "", "", QzoneZipCacheHelper.DIR, "a", "toString", "Lcom/tencent/mobileqq/onlinestatus/model/a;", "Lcom/tencent/mobileqq/onlinestatus/model/a;", "d", "()Lcom/tencent/mobileqq/onlinestatus/model/a;", "key", "b", "Ljava/lang/String;", "c", "()Ljava/lang/String;", PM.BASE, "setAction", "(Ljava/lang/String;)V", "action", "baseResDir", "actionResDir", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/onlinestatus/model/a;)V", "qqonlinestatus-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a key;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String base;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String action;

    public b(@NotNull String baseResDir, @NotNull String actionResDir, @NotNull a key) {
        Intrinsics.checkNotNullParameter(baseResDir, "baseResDir");
        Intrinsics.checkNotNullParameter(actionResDir, "actionResDir");
        Intrinsics.checkNotNullParameter(key, "key");
        this.key = key;
        this.base = a(baseResDir);
        this.action = a(actionResDir);
    }

    private final String a(String dir) {
        boolean endsWith$default;
        String separator = File.separator;
        Intrinsics.checkNotNullExpressionValue(separator, "separator");
        endsWith$default = StringsKt__StringsJVMKt.endsWith$default(dir, separator, false, 2, null);
        if (!endsWith$default) {
            return dir + separator;
        }
        return dir;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getAction() {
        return this.action;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getBase() {
        return this.base;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final a getKey() {
        return this.key;
    }

    @NotNull
    public String toString() {
        return "{key:" + this.key + ",base:" + this.base + ",action=" + this.action + '}';
    }
}
