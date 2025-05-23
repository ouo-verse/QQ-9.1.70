package com.tencent.mobileqq.wink.magicstudio;

import android.content.Intent;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\r\u0010\u000bR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "requestCode", "b", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "c", "Landroid/content/Intent;", "getData", "()Landroid/content/Intent;", "data", "<init>", "(IILandroid/content/Intent;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.magicstudio.e, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class MagicStudioActivityResult {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int requestCode;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int resultCode;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Intent data;

    public MagicStudioActivityResult(int i3, int i16, @Nullable Intent intent) {
        this.requestCode = i3;
        this.resultCode = i16;
        this.data = intent;
    }

    /* renamed from: a, reason: from getter */
    public final int getRequestCode() {
        return this.requestCode;
    }

    /* renamed from: b, reason: from getter */
    public final int getResultCode() {
        return this.resultCode;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MagicStudioActivityResult)) {
            return false;
        }
        MagicStudioActivityResult magicStudioActivityResult = (MagicStudioActivityResult) other;
        if (this.requestCode == magicStudioActivityResult.requestCode && this.resultCode == magicStudioActivityResult.resultCode && Intrinsics.areEqual(this.data, magicStudioActivityResult.data)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int i3 = ((this.requestCode * 31) + this.resultCode) * 31;
        Intent intent = this.data;
        if (intent == null) {
            hashCode = 0;
        } else {
            hashCode = intent.hashCode();
        }
        return i3 + hashCode;
    }

    @NotNull
    public String toString() {
        return "MagicStudioActivityResult(requestCode=" + this.requestCode + ", resultCode=" + this.resultCode + ", data=" + this.data + ")";
    }
}
