package com.tencent.guild.aio.msglist.highlight;

import android.os.Bundle;
import android.view.View;
import com.tencent.aio.base.mvi.part.MsgListUiState;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006R\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/guild/aio/msglist/highlight/HighLightViewHolderUIState;", "Lcom/tencent/aio/base/mvi/part/MsgListUiState;", "", "d", "I", "e", "()I", "position", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "c", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "f", "parserId", "Landroid/os/Bundle;", h.F, "Landroid/os/Bundle;", "a", "()Landroid/os/Bundle;", "extra", "Landroid/view/View;", "i", "Landroid/view/View;", "b", "()Landroid/view/View;", "itemView", "<init>", "(ILcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;ILandroid/os/Bundle;Landroid/view/View;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class HighLightViewHolderUIState implements MsgListUiState {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int position;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MsgRecord msgRecord;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int parserId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Bundle extra;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final View itemView;

    public HighLightViewHolderUIState(int i3, @NotNull MsgRecord msgRecord, int i16, @NotNull Bundle extra, @Nullable View view) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(extra, "extra");
        this.position = i3;
        this.msgRecord = msgRecord;
        this.parserId = i16;
        this.extra = extra;
        this.itemView = view;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final Bundle getExtra() {
        return this.extra;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final View getItemView() {
        return this.itemView;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final MsgRecord getMsgRecord() {
        return this.msgRecord;
    }

    /* renamed from: d, reason: from getter */
    public final int getParserId() {
        return this.parserId;
    }

    /* renamed from: e, reason: from getter */
    public final int getPosition() {
        return this.position;
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return com.tencent.mvi.base.route.h.a(this);
    }

    public /* synthetic */ HighLightViewHolderUIState(int i3, MsgRecord msgRecord, int i16, Bundle bundle, View view, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, msgRecord, i16, bundle, (i17 & 16) != 0 ? null : view);
    }
}
