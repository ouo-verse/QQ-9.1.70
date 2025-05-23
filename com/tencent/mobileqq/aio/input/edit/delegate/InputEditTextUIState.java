package com.tencent.mobileqq.aio.input.edit.delegate;

import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0014\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0014\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "()V", "AddNewLineUIState", "AppendContentToEditTextUIState", "BackSpaceInEditTextUIState", "ClearEditTextContentUIState", "ClearEditTextFocusUIState", "HideKeyboardUIState", "InsertInSelectionUIState", "PostToDoRunnableUIState", "ReplaceTextToEditTextUIState", "RequestEditTextFocusUIState", "SelectAllUIState", "SetAIBusinessFlag", "SetEditTextContentUIState", "SetEnableStatusUIState", "SetHintTextUIState", "SetSelectionUIState", "ShowKeyboardUIState", "UpdateRobotDrawDataUIState", "UpdateRobotPromptFunctionDataUIState", "UpdateRobotWriteDataUIState", "Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState$AddNewLineUIState;", "Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState$AppendContentToEditTextUIState;", "Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState$BackSpaceInEditTextUIState;", "Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState$ClearEditTextContentUIState;", "Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState$ClearEditTextFocusUIState;", "Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState$HideKeyboardUIState;", "Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState$InsertInSelectionUIState;", "Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState$PostToDoRunnableUIState;", "Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState$ReplaceTextToEditTextUIState;", "Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState$RequestEditTextFocusUIState;", "Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState$SelectAllUIState;", "Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState$SetAIBusinessFlag;", "Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState$SetEditTextContentUIState;", "Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState$SetEnableStatusUIState;", "Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState$SetHintTextUIState;", "Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState$SetSelectionUIState;", "Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState$ShowKeyboardUIState;", "Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState$UpdateRobotDrawDataUIState;", "Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState$UpdateRobotPromptFunctionDataUIState;", "Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState$UpdateRobotWriteDataUIState;", "aio_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes10.dex */
public abstract class InputEditTextUIState implements InputUIState {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState$AddNewLineUIState;", "Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState;", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes10.dex */
    public static final class AddNewLineUIState extends InputEditTextUIState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final AddNewLineUIState f189469d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55007);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f189469d = new AddNewLineUIState();
            }
        }

        AddNewLineUIState() {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState$AppendContentToEditTextUIState;", "Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "d", "Ljava/lang/CharSequence;", "a", "()Ljava/lang/CharSequence;", "content", "<init>", "(Ljava/lang/CharSequence;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final /* data */ class AppendContentToEditTextUIState extends InputEditTextUIState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final CharSequence content;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AppendContentToEditTextUIState(@NotNull CharSequence content) {
            super(null);
            Intrinsics.checkNotNullParameter(content, "content");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) content);
            } else {
                this.content = content;
            }
        }

        @NotNull
        public final CharSequence a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (CharSequence) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.content;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if ((other instanceof AppendContentToEditTextUIState) && Intrinsics.areEqual(this.content, ((AppendContentToEditTextUIState) other).content)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.content.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return "AppendContentToEditTextUIState(content=" + ((Object) this.content) + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState$BackSpaceInEditTextUIState;", "Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState;", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes10.dex */
    public static final class BackSpaceInEditTextUIState extends InputEditTextUIState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final BackSpaceInEditTextUIState f189471d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55017);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f189471d = new BackSpaceInEditTextUIState();
            }
        }

        BackSpaceInEditTextUIState() {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState$ClearEditTextContentUIState;", "Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState;", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes10.dex */
    public static final class ClearEditTextContentUIState extends InputEditTextUIState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final ClearEditTextContentUIState f189472d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55018);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f189472d = new ClearEditTextContentUIState();
            }
        }

        ClearEditTextContentUIState() {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState$ClearEditTextFocusUIState;", "Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState;", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes10.dex */
    public static final class ClearEditTextFocusUIState extends InputEditTextUIState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final ClearEditTextFocusUIState f189473d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55019);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f189473d = new ClearEditTextFocusUIState();
            }
        }

        ClearEditTextFocusUIState() {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState$HideKeyboardUIState;", "Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState;", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes10.dex */
    public static final class HideKeyboardUIState extends InputEditTextUIState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final HideKeyboardUIState f189474d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55020);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f189474d = new HideKeyboardUIState();
            }
        }

        HideKeyboardUIState() {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState$InsertInSelectionUIState;", "Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "d", "Ljava/lang/CharSequence;", "a", "()Ljava/lang/CharSequence;", "content", "<init>", "(Ljava/lang/CharSequence;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final /* data */ class InsertInSelectionUIState extends InputEditTextUIState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final CharSequence content;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InsertInSelectionUIState(@NotNull CharSequence content) {
            super(null);
            Intrinsics.checkNotNullParameter(content, "content");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) content);
            } else {
                this.content = content;
            }
        }

        @NotNull
        public final CharSequence a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (CharSequence) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.content;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if ((other instanceof InsertInSelectionUIState) && Intrinsics.areEqual(this.content, ((InsertInSelectionUIState) other).content)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.content.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return "InsertInSelectionUIState(content=" + ((Object) this.content) + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState$PostToDoRunnableUIState;", "Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/Runnable;", "d", "Ljava/lang/Runnable;", "a", "()Ljava/lang/Runnable;", "runnable", "<init>", "(Ljava/lang/Runnable;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final /* data */ class PostToDoRunnableUIState extends InputEditTextUIState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Runnable runnable;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PostToDoRunnableUIState(@NotNull Runnable runnable) {
            super(null);
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) runnable);
            } else {
                this.runnable = runnable;
            }
        }

        @NotNull
        public final Runnable a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Runnable) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.runnable;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if ((other instanceof PostToDoRunnableUIState) && Intrinsics.areEqual(this.runnable, ((PostToDoRunnableUIState) other).runnable)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.runnable.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return "PostToDoRunnableUIState(runnable=" + this.runnable + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0017\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState$ReplaceTextToEditTextUIState;", "Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "d", "Ljava/lang/CharSequence;", "a", "()Ljava/lang/CharSequence;", "content", "e", "I", "c", "()I", "start", "f", "b", "end", "<init>", "(Ljava/lang/CharSequence;II)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final /* data */ class ReplaceTextToEditTextUIState extends InputEditTextUIState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final CharSequence content;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int start;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final int end;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ReplaceTextToEditTextUIState(@NotNull CharSequence content, int i3, int i16) {
            super(null);
            Intrinsics.checkNotNullParameter(content, "content");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, content, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            this.content = content;
            this.start = i3;
            this.end = i16;
        }

        @NotNull
        public final CharSequence a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (CharSequence) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.content;
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.end;
        }

        public final int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.start;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof ReplaceTextToEditTextUIState)) {
                return false;
            }
            ReplaceTextToEditTextUIState replaceTextToEditTextUIState = (ReplaceTextToEditTextUIState) other;
            if (Intrinsics.areEqual(this.content, replaceTextToEditTextUIState.content) && this.start == replaceTextToEditTextUIState.start && this.end == replaceTextToEditTextUIState.end) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
            }
            return (((this.content.hashCode() * 31) + this.start) * 31) + this.end;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (String) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            CharSequence charSequence = this.content;
            return "ReplaceTextToEditTextUIState(content=" + ((Object) charSequence) + ", start=" + this.start + ", end=" + this.end + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState$RequestEditTextFocusUIState;", "Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState;", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes10.dex */
    public static final class RequestEditTextFocusUIState extends InputEditTextUIState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final RequestEditTextFocusUIState f189480d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55024);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f189480d = new RequestEditTextFocusUIState();
            }
        }

        RequestEditTextFocusUIState() {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState$SelectAllUIState;", "Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState;", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes10.dex */
    public static final class SelectAllUIState extends InputEditTextUIState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final SelectAllUIState f189481d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55025);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f189481d = new SelectAllUIState();
            }
        }

        SelectAllUIState() {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState$SetAIBusinessFlag;", "Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "I", "a", "()I", "type", "<init>", "(I)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final /* data */ class SetAIBusinessFlag extends InputEditTextUIState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int type;

        public SetAIBusinessFlag(int i3) {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3);
            } else {
                this.type = i3;
            }
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.type;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if ((other instanceof SetAIBusinessFlag) && this.type == ((SetAIBusinessFlag) other).type) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.type;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return "SetAIBusinessFlag(type=" + this.type + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState$SetEditTextContentUIState;", "Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "d", "Ljava/lang/CharSequence;", "a", "()Ljava/lang/CharSequence;", "content", "<init>", "(Ljava/lang/CharSequence;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final /* data */ class SetEditTextContentUIState extends InputEditTextUIState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final CharSequence content;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SetEditTextContentUIState(@NotNull CharSequence content) {
            super(null);
            Intrinsics.checkNotNullParameter(content, "content");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) content);
            } else {
                this.content = content;
            }
        }

        @NotNull
        public final CharSequence a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (CharSequence) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.content;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if ((other instanceof SetEditTextContentUIState) && Intrinsics.areEqual(this.content, ((SetEditTextContentUIState) other).content)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.content.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return "SetEditTextContentUIState(content=" + ((Object) this.content) + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\b\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState$SetEnableStatusUIState;", "Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "invokerSignature", "e", "Z", "b", "()Z", "isEnable", "<init>", "(Ljava/lang/String;Z)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final /* data */ class SetEnableStatusUIState extends InputEditTextUIState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String invokerSignature;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final boolean isEnable;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SetEnableStatusUIState(@NotNull String invokerSignature, boolean z16) {
            super(null);
            Intrinsics.checkNotNullParameter(invokerSignature, "invokerSignature");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, invokerSignature, Boolean.valueOf(z16));
            } else {
                this.invokerSignature = invokerSignature;
                this.isEnable = z16;
            }
        }

        @NotNull
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.invokerSignature;
        }

        public final boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return this.isEnable;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof SetEnableStatusUIState)) {
                return false;
            }
            SetEnableStatusUIState setEnableStatusUIState = (SetEnableStatusUIState) other;
            if (Intrinsics.areEqual(this.invokerSignature, setEnableStatusUIState.invokerSignature) && this.isEnable == setEnableStatusUIState.isEnable) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
            }
            int hashCode = this.invokerSignature.hashCode() * 31;
            boolean z16 = this.isEnable;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return hashCode + i3;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return "SetEnableStatusUIState(invokerSignature=" + this.invokerSignature + ", isEnable=" + this.isEnable + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState$SetHintTextUIState;", "Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "d", "Ljava/lang/CharSequence;", "a", "()Ljava/lang/CharSequence;", "hintText", "<init>", "(Ljava/lang/CharSequence;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final /* data */ class SetHintTextUIState extends InputEditTextUIState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final CharSequence hintText;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SetHintTextUIState(@NotNull CharSequence hintText) {
            super(null);
            Intrinsics.checkNotNullParameter(hintText, "hintText");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) hintText);
            } else {
                this.hintText = hintText;
            }
        }

        @NotNull
        public final CharSequence a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (CharSequence) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.hintText;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if ((other instanceof SetHintTextUIState) && Intrinsics.areEqual(this.hintText, ((SetHintTextUIState) other).hintText)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.hintText.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return "SetHintTextUIState(hintText=" + ((Object) this.hintText) + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState$SetSelectionUIState;", "Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "I", "a", "()I", "position", "<init>", "(I)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final /* data */ class SetSelectionUIState extends InputEditTextUIState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int position;

        public SetSelectionUIState(int i3) {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3);
            } else {
                this.position = i3;
            }
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.position;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if ((other instanceof SetSelectionUIState) && this.position == ((SetSelectionUIState) other).position) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.position;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return "SetSelectionUIState(position=" + this.position + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState$ShowKeyboardUIState;", "Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "d", "J", "a", "()J", "delayTime", "<init>", "(J)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final /* data */ class ShowKeyboardUIState extends InputEditTextUIState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final long delayTime;

        public ShowKeyboardUIState() {
            this(0L, 1, null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
                return;
            }
            iPatchRedirector.redirect((short) 9, (Object) this);
        }

        public final long a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
            }
            return this.delayTime;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if ((other instanceof ShowKeyboardUIState) && this.delayTime == ((ShowKeyboardUIState) other).delayTime) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
            }
            return androidx.fragment.app.a.a(this.delayTime);
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (String) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return "ShowKeyboardUIState(delayTime=" + this.delayTime + ")";
        }

        public ShowKeyboardUIState(long j3) {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.delayTime = j3;
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this, j3);
            }
        }

        public /* synthetic */ ShowKeyboardUIState(long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? 0L : j3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Integer.valueOf(i3), defaultConstructorMarker);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0012\u001a\u0004\b\n\u0010\u0013R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0017\u0010\u0013R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0012\u001a\u0004\b\u001a\u0010\u0013R\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001d\u0010\u0013\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState$UpdateRobotDrawDataUIState;", "Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "I", "f", "()I", "setType", "(I)V", "type", "e", "Ljava/lang/String;", "()Ljava/lang/String;", "styleName", "styleData", tl.h.F, "c", "requireName", "i", "b", "requireData", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "callbackData", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final /* data */ class UpdateRobotDrawDataUIState extends InputEditTextUIState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int type;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final String styleName;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final String styleData;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final String requireName;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final String requireData;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final String callbackData;

        public UpdateRobotDrawDataUIState(int i3, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), str, str2, str3, str4, str5);
                return;
            }
            this.type = i3;
            this.styleName = str;
            this.styleData = str2;
            this.requireName = str3;
            this.requireData = str4;
            this.callbackData = str5;
        }

        @Nullable
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (String) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return this.callbackData;
        }

        @Nullable
        public final String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (String) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return this.requireData;
        }

        @Nullable
        public final String c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return this.requireName;
        }

        @Nullable
        public final String d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (String) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.styleData;
        }

        @Nullable
        public final String e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.styleName;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof UpdateRobotDrawDataUIState)) {
                return false;
            }
            UpdateRobotDrawDataUIState updateRobotDrawDataUIState = (UpdateRobotDrawDataUIState) other;
            if (this.type == updateRobotDrawDataUIState.type && Intrinsics.areEqual(this.styleName, updateRobotDrawDataUIState.styleName) && Intrinsics.areEqual(this.styleData, updateRobotDrawDataUIState.styleData) && Intrinsics.areEqual(this.requireName, updateRobotDrawDataUIState.requireName) && Intrinsics.areEqual(this.requireData, updateRobotDrawDataUIState.requireData) && Intrinsics.areEqual(this.callbackData, updateRobotDrawDataUIState.callbackData)) {
                return true;
            }
            return false;
        }

        public final int f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.type;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            int hashCode3;
            int hashCode4;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
            }
            int i3 = this.type * 31;
            String str = this.styleName;
            int i16 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i17 = (i3 + hashCode) * 31;
            String str2 = this.styleData;
            if (str2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str2.hashCode();
            }
            int i18 = (i17 + hashCode2) * 31;
            String str3 = this.requireName;
            if (str3 == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = str3.hashCode();
            }
            int i19 = (i18 + hashCode3) * 31;
            String str4 = this.requireData;
            if (str4 == null) {
                hashCode4 = 0;
            } else {
                hashCode4 = str4.hashCode();
            }
            int i26 = (i19 + hashCode4) * 31;
            String str5 = this.callbackData;
            if (str5 != null) {
                i16 = str5.hashCode();
            }
            return i26 + i16;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return (String) iPatchRedirector.redirect((short) 17, (Object) this);
            }
            return "UpdateRobotDrawDataUIState(type=" + this.type + ", styleName=" + this.styleName + ", styleData=" + this.styleData + ", requireName=" + this.requireName + ", requireData=" + this.requireData + ", callbackData=" + this.callbackData + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001Bi\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012B\u0010 \u001a>\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0019\u0018\u00010\u0018j&\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0019j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u001b\u0018\u0001`\u001a\u00a2\u0006\u0004\b!\u0010\"J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013RS\u0010 \u001a>\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0019\u0018\u00010\u0018j&\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0019j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u001b\u0018\u0001`\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState$UpdateRobotPromptFunctionDataUIState;", "Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "I", "()I", "setType", "(I)V", "type", "e", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "template", "f", "b", "placeHolder", "Ljava/util/ArrayList;", "Ljava/util/HashMap;", "Lkotlin/collections/ArrayList;", "Lkotlin/collections/HashMap;", tl.h.F, "Ljava/util/ArrayList;", "a", "()Ljava/util/ArrayList;", "data", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final /* data */ class UpdateRobotPromptFunctionDataUIState extends InputEditTextUIState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int type;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final String template;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final String placeHolder;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final ArrayList<HashMap<String, String>> data;

        public UpdateRobotPromptFunctionDataUIState(int i3, @Nullable String str, @Nullable String str2, @Nullable ArrayList<HashMap<String, String>> arrayList) {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), str, str2, arrayList);
                return;
            }
            this.type = i3;
            this.template = str;
            this.placeHolder = str2;
            this.data = arrayList;
        }

        @Nullable
        public final ArrayList<HashMap<String, String>> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (ArrayList) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return this.data;
        }

        @Nullable
        public final String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (String) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.placeHolder;
        }

        @Nullable
        public final String c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.template;
        }

        public final int d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.type;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof UpdateRobotPromptFunctionDataUIState)) {
                return false;
            }
            UpdateRobotPromptFunctionDataUIState updateRobotPromptFunctionDataUIState = (UpdateRobotPromptFunctionDataUIState) other;
            if (this.type == updateRobotPromptFunctionDataUIState.type && Intrinsics.areEqual(this.template, updateRobotPromptFunctionDataUIState.template) && Intrinsics.areEqual(this.placeHolder, updateRobotPromptFunctionDataUIState.placeHolder) && Intrinsics.areEqual(this.data, updateRobotPromptFunctionDataUIState.data)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
            }
            int i3 = this.type * 31;
            String str = this.template;
            int i16 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i17 = (i3 + hashCode) * 31;
            String str2 = this.placeHolder;
            if (str2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str2.hashCode();
            }
            int i18 = (i17 + hashCode2) * 31;
            ArrayList<HashMap<String, String>> arrayList = this.data;
            if (arrayList != null) {
                i16 = arrayList.hashCode();
            }
            return i18 + i16;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (String) iPatchRedirector.redirect((short) 13, (Object) this);
            }
            return "UpdateRobotPromptFunctionDataUIState(type=" + this.type + ", template=" + this.template + ", placeHolder=" + this.placeHolder + ", data=" + this.data + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B{\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\u001a\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0010j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u0011\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012B\u0010 \u001a>\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u001c\u0018\u00010\u0010j&\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u001cj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u001d\u0018\u0001`\u0011\u00a2\u0006\u0004\b!\u0010\"J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR+\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0010j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aRS\u0010 \u001a>\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u001c\u0018\u00010\u0010j&\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u001cj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u001d\u0018\u0001`\u00118\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0013\u001a\u0004\b\u001f\u0010\u0015\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState$UpdateRobotWriteDataUIState;", "Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "I", "()I", "setType", "(I)V", "type", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "e", "Ljava/util/ArrayList;", "c", "()Ljava/util/ArrayList;", "template", "f", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "placeHolder", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", tl.h.F, "a", "data", "<init>", "(ILjava/util/ArrayList;Ljava/lang/String;Ljava/util/ArrayList;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final /* data */ class UpdateRobotWriteDataUIState extends InputEditTextUIState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int type;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final ArrayList<String> template;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final String placeHolder;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final ArrayList<HashMap<String, String>> data;

        public UpdateRobotWriteDataUIState(int i3, @Nullable ArrayList<String> arrayList, @Nullable String str, @Nullable ArrayList<HashMap<String, String>> arrayList2) {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), arrayList, str, arrayList2);
                return;
            }
            this.type = i3;
            this.template = arrayList;
            this.placeHolder = str;
            this.data = arrayList2;
        }

        @Nullable
        public final ArrayList<HashMap<String, String>> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (ArrayList) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return this.data;
        }

        @Nullable
        public final String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (String) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.placeHolder;
        }

        @Nullable
        public final ArrayList<String> c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (ArrayList) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.template;
        }

        public final int d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.type;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof UpdateRobotWriteDataUIState)) {
                return false;
            }
            UpdateRobotWriteDataUIState updateRobotWriteDataUIState = (UpdateRobotWriteDataUIState) other;
            if (this.type == updateRobotWriteDataUIState.type && Intrinsics.areEqual(this.template, updateRobotWriteDataUIState.template) && Intrinsics.areEqual(this.placeHolder, updateRobotWriteDataUIState.placeHolder) && Intrinsics.areEqual(this.data, updateRobotWriteDataUIState.data)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
            }
            int i3 = this.type * 31;
            ArrayList<String> arrayList = this.template;
            int i16 = 0;
            if (arrayList == null) {
                hashCode = 0;
            } else {
                hashCode = arrayList.hashCode();
            }
            int i17 = (i3 + hashCode) * 31;
            String str = this.placeHolder;
            if (str == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str.hashCode();
            }
            int i18 = (i17 + hashCode2) * 31;
            ArrayList<HashMap<String, String>> arrayList2 = this.data;
            if (arrayList2 != null) {
                i16 = arrayList2.hashCode();
            }
            return i18 + i16;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (String) iPatchRedirector.redirect((short) 13, (Object) this);
            }
            return "UpdateRobotWriteDataUIState(type=" + this.type + ", template=" + this.template + ", placeHolder=" + this.placeHolder + ", data=" + this.data + ")";
        }
    }

    public /* synthetic */ InputEditTextUIState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return com.tencent.mvi.base.route.h.a(this);
    }

    InputEditTextUIState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }
}
