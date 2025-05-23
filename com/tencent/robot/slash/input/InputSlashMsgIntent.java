package com.tencent.robot.slash.input;

import android.text.Spanned;
import com.tencent.mvi.annotation.AutoEventName;
import com.tencent.mvi.base.route.MsgIntent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/robot/slash/input/InputSlashMsgIntent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "()V", "DismissSlashDialog", "GetSlashDialogIsSowing", "OnTextChangedForSlashDialog", "Lcom/tencent/robot/slash/input/InputSlashMsgIntent$DismissSlashDialog;", "Lcom/tencent/robot/slash/input/InputSlashMsgIntent$GetSlashDialogIsSowing;", "Lcom/tencent/robot/slash/input/InputSlashMsgIntent$OnTextChangedForSlashDialog;", "robot-business-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public abstract class InputSlashMsgIntent implements MsgIntent {

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/robot/slash/input/InputSlashMsgIntent$DismissSlashDialog;", "Lcom/tencent/robot/slash/input/InputSlashMsgIntent;", "()V", "robot-business-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class DismissSlashDialog extends InputSlashMsgIntent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final DismissSlashDialog f368520d = new DismissSlashDialog();

        DismissSlashDialog() {
            super(null);
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            return "com.tencent.robot.slash.input.InputSlashMsgIntent.DismissSlashDialog";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/robot/slash/input/InputSlashMsgIntent$GetSlashDialogIsSowing;", "Lcom/tencent/robot/slash/input/InputSlashMsgIntent;", "()V", "robot-business-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class GetSlashDialogIsSowing extends InputSlashMsgIntent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final GetSlashDialogIsSowing f368521d = new GetSlashDialogIsSowing();

        GetSlashDialogIsSowing() {
            super(null);
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            return "com.tencent.robot.slash.input.InputSlashMsgIntent.GetSlashDialogIsSowing";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0017\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/robot/slash/input/InputSlashMsgIntent$OnTextChangedForSlashDialog;", "Lcom/tencent/robot/slash/input/InputSlashMsgIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "Landroid/text/Spanned;", "d", "Landroid/text/Spanned;", "b", "()Landroid/text/Spanned;", "spannedChars", "e", "I", "a", "()I", "selectionStart", "f", "getLineCount", "lineCount", "<init>", "(Landroid/text/Spanned;II)V", "robot-business-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class OnTextChangedForSlashDialog extends InputSlashMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final Spanned spannedChars;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final int selectionStart;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private final int lineCount;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnTextChangedForSlashDialog(@NotNull Spanned spannedChars, int i3, int i16) {
            super(null);
            Intrinsics.checkNotNullParameter(spannedChars, "spannedChars");
            this.spannedChars = spannedChars;
            this.selectionStart = i3;
            this.lineCount = i16;
        }

        /* renamed from: a, reason: from getter */
        public final int getSelectionStart() {
            return this.selectionStart;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final Spanned getSpannedChars() {
            return this.spannedChars;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnTextChangedForSlashDialog)) {
                return false;
            }
            OnTextChangedForSlashDialog onTextChangedForSlashDialog = (OnTextChangedForSlashDialog) other;
            if (Intrinsics.areEqual(this.spannedChars, onTextChangedForSlashDialog.spannedChars) && this.selectionStart == onTextChangedForSlashDialog.selectionStart && this.lineCount == onTextChangedForSlashDialog.lineCount) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            return "com.tencent.robot.slash.input.InputSlashMsgIntent.OnTextChangedForSlashDialog";
        }

        public int hashCode() {
            return (((this.spannedChars.hashCode() * 31) + this.selectionStart) * 31) + this.lineCount;
        }

        @NotNull
        public String toString() {
            Spanned spanned = this.spannedChars;
            return "OnTextChangedForSlashDialog(spannedChars=" + ((Object) spanned) + ", selectionStart=" + this.selectionStart + ", lineCount=" + this.lineCount + ")";
        }
    }

    public /* synthetic */ InputSlashMsgIntent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        return MsgIntent.a.a(this);
    }

    InputSlashMsgIntent() {
    }
}
