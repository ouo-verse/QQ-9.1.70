package com.tencent.mobileqq.guild.feed.nativedetail.bottom.input;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\n\n\u0002\b\f\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\nB7\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0004\u0012\u0006\u0010\u001c\u001a\u00020\u0018\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0004\b\"\u0010#J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0017\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0015\u001a\u0004\b\u0010\u0010\u0016R\u0017\u0010\u001c\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0019\u0010\u001bR$\u0010!\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u001d\u001a\u0004\b\n\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/i;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/InputFunctionType;", "a", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/InputFunctionType;", "c", "()Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/InputFunctionType;", "inputFunctionType", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/h;", "b", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/h;", "e", "()Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/h;", "replyCommentArgs", "I", "()I", "extOperate", "", "d", ExifInterface.LATITUDE_SOUTH, "()S", "invokeFrom", "Ljava/lang/Object;", "()Ljava/lang/Object;", "f", "(Ljava/lang/Object;)V", "extObj", "<init>", "(Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/InputFunctionType;Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/h;ISLjava/lang/Object;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.i, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class ShowInputComponentArgs {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final InputFunctionType inputFunctionType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final ReplyCommentArgs replyCommentArgs;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int extOperate;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final short invokeFrom;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private Object extObj;

    public ShowInputComponentArgs(@NotNull InputFunctionType inputFunctionType, @Nullable ReplyCommentArgs replyCommentArgs, int i3, short s16, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(inputFunctionType, "inputFunctionType");
        this.inputFunctionType = inputFunctionType;
        this.replyCommentArgs = replyCommentArgs;
        this.extOperate = i3;
        this.invokeFrom = s16;
        this.extObj = obj;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final Object getExtObj() {
        return this.extObj;
    }

    /* renamed from: b, reason: from getter */
    public final int getExtOperate() {
        return this.extOperate;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final InputFunctionType getInputFunctionType() {
        return this.inputFunctionType;
    }

    /* renamed from: d, reason: from getter */
    public final short getInvokeFrom() {
        return this.invokeFrom;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final ReplyCommentArgs getReplyCommentArgs() {
        return this.replyCommentArgs;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShowInputComponentArgs)) {
            return false;
        }
        ShowInputComponentArgs showInputComponentArgs = (ShowInputComponentArgs) other;
        if (this.inputFunctionType == showInputComponentArgs.inputFunctionType && Intrinsics.areEqual(this.replyCommentArgs, showInputComponentArgs.replyCommentArgs) && this.extOperate == showInputComponentArgs.extOperate && this.invokeFrom == showInputComponentArgs.invokeFrom && Intrinsics.areEqual(this.extObj, showInputComponentArgs.extObj)) {
            return true;
        }
        return false;
    }

    public final void f(@Nullable Object obj) {
        this.extObj = obj;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = this.inputFunctionType.hashCode() * 31;
        ReplyCommentArgs replyCommentArgs = this.replyCommentArgs;
        int i3 = 0;
        if (replyCommentArgs == null) {
            hashCode = 0;
        } else {
            hashCode = replyCommentArgs.hashCode();
        }
        int i16 = (((((hashCode2 + hashCode) * 31) + this.extOperate) * 31) + this.invokeFrom) * 31;
        Object obj = this.extObj;
        if (obj != null) {
            i3 = obj.hashCode();
        }
        return i16 + i3;
    }

    @NotNull
    public String toString() {
        InputFunctionType inputFunctionType = this.inputFunctionType;
        ReplyCommentArgs replyCommentArgs = this.replyCommentArgs;
        int i3 = this.extOperate;
        short s16 = this.invokeFrom;
        return "ShowInputComponentArgs(inputFunctionType=" + inputFunctionType + ", replyCommentArgs=" + replyCommentArgs + ", extOperate=" + i3 + ", invokeFrom=" + ((int) s16) + ", extObj=" + this.extObj + ")";
    }

    public /* synthetic */ ShowInputComponentArgs(InputFunctionType inputFunctionType, ReplyCommentArgs replyCommentArgs, int i3, short s16, Object obj, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(inputFunctionType, replyCommentArgs, (i16 & 4) != 0 ? 0 : i3, s16, (i16 & 16) != 0 ? null : obj);
    }
}
