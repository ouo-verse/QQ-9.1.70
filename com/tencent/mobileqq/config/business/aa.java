package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import com.tencent.freesia.IConfigData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\"\u0010\f\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/config/business/aa;", "Lcom/tencent/freesia/IConfigData;", "", "content", "", "b", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setConfigStr$AQQLiteModule_release", "(Ljava/lang/String;)V", "configStr", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class aa implements IConfigData {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String configStr = "";

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getConfigStr() {
        return this.configStr;
    }

    public final void b(@Nullable String content) {
        if (TextUtils.isEmpty(content)) {
            return;
        }
        Intrinsics.checkNotNull(content);
        this.configStr = content;
    }
}
