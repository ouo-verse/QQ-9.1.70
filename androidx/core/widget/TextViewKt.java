package androidx.core.widget;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0083\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022d\b\u0006\u0010\u0003\u001a^\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u00042d\b\u0006\u0010\u000e\u001a^\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\r0\u00042%\b\u0006\u0010\u0010\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0012\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\r0\u0011H\u0086\b\u00f8\u0001\u0000\u001a7\u0010\u0013\u001a\u00020\u0001*\u00020\u00022%\b\u0004\u0010\u0014\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0012\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\r0\u0011H\u0086\b\u00f8\u0001\u0000\u001av\u0010\u0015\u001a\u00020\u0001*\u00020\u00022d\b\u0004\u0010\u0014\u001a^\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0004H\u0086\b\u00f8\u0001\u0000\u001av\u0010\u0016\u001a\u00020\u0001*\u00020\u00022d\b\u0004\u0010\u0014\u001a^\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\r0\u0004H\u0086\b\u00f8\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u0017"}, d2 = {"addTextChangedListener", "Landroid/text/TextWatcher;", "Landroid/widget/TextView;", "beforeTextChanged", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "text", "", "start", "count", "after", "", "onTextChanged", "before", "afterTextChanged", "Lkotlin/Function1;", "Landroid/text/Editable;", "doAfterTextChanged", "action", "doBeforeTextChanged", "doOnTextChanged", "core-ktx_release"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class TextViewKt {
    @NotNull
    public static final TextWatcher addTextChangedListener(@NotNull TextView addTextChangedListener, @NotNull Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> beforeTextChanged, @NotNull Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> onTextChanged, @NotNull Function1<? super Editable, Unit> afterTextChanged) {
        Intrinsics.checkNotNullParameter(addTextChangedListener, "$this$addTextChangedListener");
        Intrinsics.checkNotNullParameter(beforeTextChanged, "beforeTextChanged");
        Intrinsics.checkNotNullParameter(onTextChanged, "onTextChanged");
        Intrinsics.checkNotNullParameter(afterTextChanged, "afterTextChanged");
        TextViewKt$addTextChangedListener$textWatcher$1 textViewKt$addTextChangedListener$textWatcher$1 = new TextViewKt$addTextChangedListener$textWatcher$1(afterTextChanged, beforeTextChanged, onTextChanged);
        addTextChangedListener.addTextChangedListener(textViewKt$addTextChangedListener$textWatcher$1);
        return textViewKt$addTextChangedListener$textWatcher$1;
    }

    public static /* synthetic */ TextWatcher addTextChangedListener$default(TextView addTextChangedListener, Function4 beforeTextChanged, Function4 onTextChanged, Function1 afterTextChanged, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            beforeTextChanged = new Function4<CharSequence, Integer, Integer, Integer, Unit>() { // from class: androidx.core.widget.TextViewKt$addTextChangedListener$1
                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(CharSequence charSequence, Integer num, Integer num2, Integer num3) {
                    invoke(charSequence, num.intValue(), num2.intValue(), num3.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable CharSequence charSequence, int i16, int i17, int i18) {
                }
            };
        }
        if ((i3 & 2) != 0) {
            onTextChanged = new Function4<CharSequence, Integer, Integer, Integer, Unit>() { // from class: androidx.core.widget.TextViewKt$addTextChangedListener$2
                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(CharSequence charSequence, Integer num, Integer num2, Integer num3) {
                    invoke(charSequence, num.intValue(), num2.intValue(), num3.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable CharSequence charSequence, int i16, int i17, int i18) {
                }
            };
        }
        if ((i3 & 4) != 0) {
            afterTextChanged = new Function1<Editable, Unit>() { // from class: androidx.core.widget.TextViewKt$addTextChangedListener$3
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
                    invoke2(editable);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Editable editable) {
                }
            };
        }
        Intrinsics.checkNotNullParameter(addTextChangedListener, "$this$addTextChangedListener");
        Intrinsics.checkNotNullParameter(beforeTextChanged, "beforeTextChanged");
        Intrinsics.checkNotNullParameter(onTextChanged, "onTextChanged");
        Intrinsics.checkNotNullParameter(afterTextChanged, "afterTextChanged");
        TextViewKt$addTextChangedListener$textWatcher$1 textViewKt$addTextChangedListener$textWatcher$1 = new TextViewKt$addTextChangedListener$textWatcher$1(afterTextChanged, beforeTextChanged, onTextChanged);
        addTextChangedListener.addTextChangedListener(textViewKt$addTextChangedListener$textWatcher$1);
        return textViewKt$addTextChangedListener$textWatcher$1;
    }

    @NotNull
    public static final TextWatcher doAfterTextChanged(@NotNull TextView doAfterTextChanged, @NotNull final Function1<? super Editable, Unit> action) {
        Intrinsics.checkNotNullParameter(doAfterTextChanged, "$this$doAfterTextChanged");
        Intrinsics.checkNotNullParameter(action, "action");
        TextWatcher textWatcher = new TextWatcher() { // from class: androidx.core.widget.TextViewKt$doAfterTextChanged$$inlined$addTextChangedListener$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(@Nullable Editable s16) {
                Function1.this.invoke(s16);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@Nullable CharSequence text, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@Nullable CharSequence text, int start, int before, int count) {
            }
        };
        doAfterTextChanged.addTextChangedListener(textWatcher);
        return textWatcher;
    }

    @NotNull
    public static final TextWatcher doBeforeTextChanged(@NotNull TextView doBeforeTextChanged, @NotNull final Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> action) {
        Intrinsics.checkNotNullParameter(doBeforeTextChanged, "$this$doBeforeTextChanged");
        Intrinsics.checkNotNullParameter(action, "action");
        TextWatcher textWatcher = new TextWatcher() { // from class: androidx.core.widget.TextViewKt$doBeforeTextChanged$$inlined$addTextChangedListener$1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(@Nullable CharSequence text, int start, int count, int after) {
                Function4.this.invoke(text, Integer.valueOf(start), Integer.valueOf(count), Integer.valueOf(after));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(@Nullable Editable s16) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@Nullable CharSequence text, int start, int before, int count) {
            }
        };
        doBeforeTextChanged.addTextChangedListener(textWatcher);
        return textWatcher;
    }

    @NotNull
    public static final TextWatcher doOnTextChanged(@NotNull TextView doOnTextChanged, @NotNull final Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> action) {
        Intrinsics.checkNotNullParameter(doOnTextChanged, "$this$doOnTextChanged");
        Intrinsics.checkNotNullParameter(action, "action");
        TextWatcher textWatcher = new TextWatcher() { // from class: androidx.core.widget.TextViewKt$doOnTextChanged$$inlined$addTextChangedListener$1
            @Override // android.text.TextWatcher
            public void onTextChanged(@Nullable CharSequence text, int start, int before, int count) {
                Function4.this.invoke(text, Integer.valueOf(start), Integer.valueOf(before), Integer.valueOf(count));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(@Nullable Editable s16) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@Nullable CharSequence text, int start, int count, int after) {
            }
        };
        doOnTextChanged.addTextChangedListener(textWatcher);
        return textWatcher;
    }
}
