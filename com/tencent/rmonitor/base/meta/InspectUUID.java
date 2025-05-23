package com.tencent.rmonitor.base.meta;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.bugly.common.utils.RecyclablePool;
import com.vivo.push.PushClientConstants;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/rmonitor/base/meta/InspectUUID;", "Lcom/tencent/bugly/common/utils/RecyclablePool$Recyclable;", "()V", "cache", "", PushClientConstants.TAG_CLASS_NAME, PublicAccountMessageUtilImpl.ITEM_DIGEST_NAME, "uuid", "weakObj", "Ljava/lang/ref/WeakReference;", "", "reset", "", "toString", "rmonitor-core_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes25.dex */
public final class InspectUUID extends RecyclablePool.Recyclable {

    @JvmField
    @Nullable
    public WeakReference<Object> weakObj;

    @JvmField
    @NotNull
    public String className = "";

    @JvmField
    @NotNull
    public String digest = "";

    @JvmField
    @NotNull
    public String uuid = "";

    @JvmField
    @NotNull
    public String cache = "";

    @Override // com.tencent.bugly.common.utils.RecyclablePool.Recyclable
    public void reset() {
        this.weakObj = null;
        this.digest = "";
        this.uuid = "";
        this.className = "";
        this.cache = "";
    }

    @NotNull
    public String toString() {
        boolean z16;
        if (this.cache.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            StringBuilder sb5 = new StringBuilder(64);
            sb5.append(this.className);
            sb5.append("@");
            String str = this.uuid;
            if (str != null) {
                sb5.append(str);
            }
            if (!TextUtils.isEmpty(this.digest)) {
                sb5.append("_");
                sb5.append(this.digest);
            }
            String sb6 = sb5.toString();
            Intrinsics.checkExpressionValueIsNotNull(sb6, "StringBuilder(64).apply \u2026\n            }.toString()");
            this.cache = sb6;
        }
        return this.cache;
    }
}
