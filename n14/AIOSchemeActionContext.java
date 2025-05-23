package n14;

import android.os.Bundle;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0018\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016R\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Ln14/a;", "Ln14/c;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/aio/api/runtime/a;", "a", "Lcom/tencent/aio/api/runtime/a;", "()Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "b", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "()Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItemRef", "c", "Ljava/lang/Object;", "()Ljava/lang/Object;", "msgRecord", "Landroid/os/Bundle;", "d", "Landroid/os/Bundle;", "getExtra", "()Landroid/os/Bundle;", "extra", "<init>", "(Lcom/tencent/aio/api/runtime/a;Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;Ljava/lang/Object;Landroid/os/Bundle;)V", "robot-business-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: n14.a, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class AIOSchemeActionContext implements c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final com.tencent.aio.api.runtime.a aioContext;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final AIOMsgItem msgItemRef;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Object msgRecord;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Bundle extra;

    public AIOSchemeActionContext(@NotNull com.tencent.aio.api.runtime.a aioContext, @Nullable AIOMsgItem aIOMsgItem, @Nullable Object obj, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        this.aioContext = aioContext;
        this.msgItemRef = aIOMsgItem;
        this.msgRecord = obj;
        this.extra = bundle;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final com.tencent.aio.api.runtime.a getAioContext() {
        return this.aioContext;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final AIOMsgItem getMsgItemRef() {
        return this.msgItemRef;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final Object getMsgRecord() {
        return this.msgRecord;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AIOSchemeActionContext)) {
            return false;
        }
        AIOSchemeActionContext aIOSchemeActionContext = (AIOSchemeActionContext) other;
        if (Intrinsics.areEqual(this.aioContext, aIOSchemeActionContext.aioContext) && Intrinsics.areEqual(this.msgItemRef, aIOSchemeActionContext.msgItemRef) && Intrinsics.areEqual(this.msgRecord, aIOSchemeActionContext.msgRecord) && Intrinsics.areEqual(this.extra, aIOSchemeActionContext.extra)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3 = this.aioContext.hashCode() * 31;
        AIOMsgItem aIOMsgItem = this.msgItemRef;
        int i3 = 0;
        if (aIOMsgItem == null) {
            hashCode = 0;
        } else {
            hashCode = aIOMsgItem.hashCode();
        }
        int i16 = (hashCode3 + hashCode) * 31;
        Object obj = this.msgRecord;
        if (obj == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = obj.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        Bundle bundle = this.extra;
        if (bundle != null) {
            i3 = bundle.hashCode();
        }
        return i17 + i3;
    }

    @NotNull
    public String toString() {
        return "AIOSchemeActionContext(aioContext=" + this.aioContext + ", msgItemRef=" + this.msgItemRef + ", msgRecord=" + this.msgRecord + ", extra=" + this.extra + ")";
    }

    public /* synthetic */ AIOSchemeActionContext(com.tencent.aio.api.runtime.a aVar, AIOMsgItem aIOMsgItem, Object obj, Bundle bundle, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(aVar, (i3 & 2) != 0 ? null : aIOMsgItem, (i3 & 4) != 0 ? null : obj, (i3 & 8) != 0 ? null : bundle);
    }
}
