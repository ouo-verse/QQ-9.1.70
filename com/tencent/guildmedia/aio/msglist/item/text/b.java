package com.tencent.guildmedia.aio.msglist.item.text;

import android.view.ViewGroup;
import com.tencent.qqnt.kernel.nativeinterface.FaceElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u0018\u001a\u00020\u0011\u0012\u0006\u0010 \u001a\u00020\u0019\u00a2\u0006\u0004\b!\u0010\"R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0003\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010 \u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/guildmedia/aio/msglist/item/text/b;", "Lcom/tencent/guild/aio/msglist/text/a;", "", "d", "J", "c", "()J", "setMsgSeq", "(J)V", "msgSeq", "Landroid/view/ViewGroup;", "e", "Landroid/view/ViewGroup;", "()Landroid/view/ViewGroup;", "setParentView", "(Landroid/view/ViewGroup;)V", "parentView", "Lcom/tencent/qqnt/kernel/nativeinterface/FaceElement;", "f", "Lcom/tencent/qqnt/kernel/nativeinterface/FaceElement;", "b", "()Lcom/tencent/qqnt/kernel/nativeinterface/FaceElement;", "setFaceElement", "(Lcom/tencent/qqnt/kernel/nativeinterface/FaceElement;)V", "faceElement", "", h.F, "I", "a", "()I", "setEmoFaceId", "(I)V", "emoFaceId", "<init>", "(JLandroid/view/ViewGroup;Lcom/tencent/qqnt/kernel/nativeinterface/FaceElement;I)V", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class b extends com.tencent.guild.aio.msglist.text.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long msgSeq;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup parentView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private FaceElement faceElement;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int emoFaceId;

    public b(long j3, @Nullable ViewGroup viewGroup, @NotNull FaceElement faceElement, int i3) {
        Intrinsics.checkNotNullParameter(faceElement, "faceElement");
        this.msgSeq = j3;
        this.parentView = viewGroup;
        this.faceElement = faceElement;
        this.emoFaceId = i3;
    }

    /* renamed from: a, reason: from getter */
    public final int getEmoFaceId() {
        return this.emoFaceId;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final FaceElement getFaceElement() {
        return this.faceElement;
    }

    /* renamed from: c, reason: from getter */
    public final long getMsgSeq() {
        return this.msgSeq;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final ViewGroup getParentView() {
        return this.parentView;
    }
}
