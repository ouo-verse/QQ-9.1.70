package com.tencent.icgame.game.liveroom.impl.room.event;

import android.content.Intent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J)\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/event/OnActivityResultEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "requestCode", "", QzoneIPCModule.RESULT_CODE, "data", "Landroid/content/Intent;", "(IILandroid/content/Intent;)V", "getData", "()Landroid/content/Intent;", "getRequestCode", "()I", "getResultCode", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class OnActivityResultEvent extends SimpleBaseEvent {

    @Nullable
    private final Intent data;
    private final int requestCode;
    private final int resultCode;

    public OnActivityResultEvent(int i3, int i16, @Nullable Intent intent) {
        this.requestCode = i3;
        this.resultCode = i16;
        this.data = intent;
    }

    public static /* synthetic */ OnActivityResultEvent copy$default(OnActivityResultEvent onActivityResultEvent, int i3, int i16, Intent intent, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            i3 = onActivityResultEvent.requestCode;
        }
        if ((i17 & 2) != 0) {
            i16 = onActivityResultEvent.resultCode;
        }
        if ((i17 & 4) != 0) {
            intent = onActivityResultEvent.data;
        }
        return onActivityResultEvent.copy(i3, i16, intent);
    }

    /* renamed from: component1, reason: from getter */
    public final int getRequestCode() {
        return this.requestCode;
    }

    /* renamed from: component2, reason: from getter */
    public final int getResultCode() {
        return this.resultCode;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Intent getData() {
        return this.data;
    }

    @NotNull
    public final OnActivityResultEvent copy(int requestCode, int resultCode, @Nullable Intent data) {
        return new OnActivityResultEvent(requestCode, resultCode, data);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OnActivityResultEvent)) {
            return false;
        }
        OnActivityResultEvent onActivityResultEvent = (OnActivityResultEvent) other;
        if (this.requestCode == onActivityResultEvent.requestCode && this.resultCode == onActivityResultEvent.resultCode && Intrinsics.areEqual(this.data, onActivityResultEvent.data)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final Intent getData() {
        return this.data;
    }

    public final int getRequestCode() {
        return this.requestCode;
    }

    public final int getResultCode() {
        return this.resultCode;
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
        return "OnActivityResultEvent(requestCode=" + this.requestCode + ", resultCode=" + this.resultCode + ", data=" + this.data + ")";
    }
}
