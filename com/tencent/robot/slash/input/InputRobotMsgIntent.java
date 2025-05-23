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
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/robot/slash/input/InputRobotMsgIntent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "()V", "GetDialogIsShowing", "OnTextChangedForRobotAtDialog", "SetSlashCmdToInputEdiText", "Lcom/tencent/robot/slash/input/InputRobotMsgIntent$GetDialogIsShowing;", "Lcom/tencent/robot/slash/input/InputRobotMsgIntent$OnTextChangedForRobotAtDialog;", "Lcom/tencent/robot/slash/input/InputRobotMsgIntent$SetSlashCmdToInputEdiText;", "robot-business-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public abstract class InputRobotMsgIntent implements MsgIntent {

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/robot/slash/input/InputRobotMsgIntent$GetDialogIsShowing;", "Lcom/tencent/robot/slash/input/InputRobotMsgIntent;", "()V", "robot-business-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class GetDialogIsShowing extends InputRobotMsgIntent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final GetDialogIsShowing f368515d = new GetDialogIsShowing();

        GetDialogIsShowing() {
            super(null);
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            return "com.tencent.robot.slash.input.InputRobotMsgIntent.GetDialogIsShowing";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0017\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/robot/slash/input/InputRobotMsgIntent$OnTextChangedForRobotAtDialog;", "Lcom/tencent/robot/slash/input/InputRobotMsgIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "Landroid/text/Spanned;", "d", "Landroid/text/Spanned;", "b", "()Landroid/text/Spanned;", "spannedChar", "e", "I", "a", "()I", "selectionStart", "f", "getLineCount", "lineCount", "<init>", "(Landroid/text/Spanned;II)V", "robot-business-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class OnTextChangedForRobotAtDialog extends InputRobotMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final Spanned spannedChar;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final int selectionStart;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private final int lineCount;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnTextChangedForRobotAtDialog(@NotNull Spanned spannedChar, int i3, int i16) {
            super(null);
            Intrinsics.checkNotNullParameter(spannedChar, "spannedChar");
            this.spannedChar = spannedChar;
            this.selectionStart = i3;
            this.lineCount = i16;
        }

        /* renamed from: a, reason: from getter */
        public final int getSelectionStart() {
            return this.selectionStart;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final Spanned getSpannedChar() {
            return this.spannedChar;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnTextChangedForRobotAtDialog)) {
                return false;
            }
            OnTextChangedForRobotAtDialog onTextChangedForRobotAtDialog = (OnTextChangedForRobotAtDialog) other;
            if (Intrinsics.areEqual(this.spannedChar, onTextChangedForRobotAtDialog.spannedChar) && this.selectionStart == onTextChangedForRobotAtDialog.selectionStart && this.lineCount == onTextChangedForRobotAtDialog.lineCount) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            return "com.tencent.robot.slash.input.InputRobotMsgIntent.OnTextChangedForRobotAtDialog";
        }

        public int hashCode() {
            return (((this.spannedChar.hashCode() * 31) + this.selectionStart) * 31) + this.lineCount;
        }

        @NotNull
        public String toString() {
            Spanned spanned = this.spannedChar;
            return "OnTextChangedForRobotAtDialog(spannedChar=" + ((Object) spanned) + ", selectionStart=" + this.selectionStart + ", lineCount=" + this.lineCount + ")";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/robot/slash/input/InputRobotMsgIntent$SetSlashCmdToInputEdiText;", "Lcom/tencent/robot/slash/input/InputRobotMsgIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "d", "Ljava/lang/CharSequence;", "a", "()Ljava/lang/CharSequence;", "content", "<init>", "(Ljava/lang/CharSequence;)V", "robot-business-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class SetSlashCmdToInputEdiText extends InputRobotMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final CharSequence content;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SetSlashCmdToInputEdiText(@NotNull CharSequence content) {
            super(null);
            Intrinsics.checkNotNullParameter(content, "content");
            this.content = content;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final CharSequence getContent() {
            return this.content;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof SetSlashCmdToInputEdiText) && Intrinsics.areEqual(this.content, ((SetSlashCmdToInputEdiText) other).content)) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            return "com.tencent.robot.slash.input.InputRobotMsgIntent.SetSlashCmdToInputEdiText";
        }

        public int hashCode() {
            return this.content.hashCode();
        }

        @NotNull
        public String toString() {
            return "SetSlashCmdToInputEdiText(content=" + ((Object) this.content) + ")";
        }
    }

    public /* synthetic */ InputRobotMsgIntent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        return MsgIntent.a.a(this);
    }

    InputRobotMsgIntent() {
    }
}
