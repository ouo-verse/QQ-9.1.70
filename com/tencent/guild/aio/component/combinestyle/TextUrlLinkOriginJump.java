package com.tencent.guild.aio.component.combinestyle;

import android.view.View;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/guild/aio/component/combinestyle/TextUrlLinkOriginJump;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "", "d", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "url", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "e", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "a", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Landroid/view/View;", "f", "Landroid/view/View;", "c", "()Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "<init>", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;Landroid/view/View;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class TextUrlLinkOriginJump implements MviUIState {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String url;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MsgRecord msgRecord;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View widget;

    public TextUrlLinkOriginJump(@NotNull String url, @NotNull MsgRecord msgRecord, @NotNull View widget) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(widget, "widget");
        this.url = url;
        this.msgRecord = msgRecord;
        this.widget = widget;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final MsgRecord getMsgRecord() {
        return this.msgRecord;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final View getWidget() {
        return this.widget;
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return com.tencent.mvi.base.route.h.a(this);
    }
}
