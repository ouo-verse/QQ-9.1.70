package com.tencent.mobileqq.wink.event;

import android.content.Intent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010\nR\u0013\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/wink/event/WinkFinishActivityEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "isForceFinish", "", "isDirectFinish", "(ZZ)V", QzoneIPCModule.RESULT_CODE, "", "data", "Landroid/content/Intent;", "(ZZILandroid/content/Intent;)V", "getData", "()Landroid/content/Intent;", "()Z", "getResultCode", "()I", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class WinkFinishActivityEvent extends SimpleBaseEvent {

    @Nullable
    private final Intent data;
    private final boolean isDirectFinish;
    private final boolean isForceFinish;
    private final int resultCode;

    public WinkFinishActivityEvent() {
        this(false, false, 0, null, 15, null);
    }

    @Nullable
    public final Intent getData() {
        return this.data;
    }

    public final int getResultCode() {
        return this.resultCode;
    }

    /* renamed from: isDirectFinish, reason: from getter */
    public final boolean getIsDirectFinish() {
        return this.isDirectFinish;
    }

    /* renamed from: isForceFinish, reason: from getter */
    public final boolean getIsForceFinish() {
        return this.isForceFinish;
    }

    public /* synthetic */ WinkFinishActivityEvent(boolean z16, boolean z17, int i3, Intent intent, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? false : z16, (i16 & 2) != 0 ? true : z17, (i16 & 4) != 0 ? 0 : i3, (i16 & 8) != 0 ? null : intent);
    }

    public WinkFinishActivityEvent(boolean z16, boolean z17, int i3, @Nullable Intent intent) {
        this.isForceFinish = z16;
        this.isDirectFinish = z17;
        this.resultCode = i3;
        this.data = intent;
    }

    public WinkFinishActivityEvent(boolean z16, boolean z17) {
        this(z17, z16, 0, null);
    }
}
