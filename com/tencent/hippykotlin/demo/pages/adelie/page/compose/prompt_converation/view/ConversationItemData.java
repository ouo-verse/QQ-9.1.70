package com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view;

import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import ap3.a;
import com.tencent.hippykotlin.demo.pages.adelie.common.compose.util.StateHolder;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ConversationItemData {
    public StateHolder<String> answer;
    public a answerInputBoxCoordinates;
    public long focusTime;
    public final State<Boolean> isComplete = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationItemData$isComplete$1
        {
            super(0);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0036  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x001c  */
        @Override // kotlin.jvm.functions.Function0
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Boolean invoke() {
            boolean z16;
            boolean z17;
            boolean isBlank;
            boolean isBlank2;
            String value = ConversationItemData.this.question._state.getValue();
            boolean z18 = false;
            if (value != null) {
                isBlank2 = StringsKt__StringsJVMKt.isBlank(value);
                if (!isBlank2) {
                    z16 = false;
                    if (!z16) {
                        String value2 = ConversationItemData.this.answer._state.getValue();
                        if (value2 != null) {
                            isBlank = StringsKt__StringsJVMKt.isBlank(value2);
                            if (!isBlank) {
                                z17 = false;
                                if (!z17) {
                                    z18 = true;
                                }
                            }
                        }
                        z17 = true;
                        if (!z17) {
                        }
                    }
                    return Boolean.valueOf(z18);
                }
            }
            z16 = true;
            if (!z16) {
            }
            return Boolean.valueOf(z18);
        }
    });
    public final State<Boolean> isEmpty = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationItemData$isEmpty$1
        {
            super(0);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0036  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x001c  */
        @Override // kotlin.jvm.functions.Function0
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Boolean invoke() {
            boolean z16;
            boolean z17;
            boolean isBlank;
            boolean isBlank2;
            String value = ConversationItemData.this.question._state.getValue();
            boolean z18 = false;
            if (value != null) {
                isBlank2 = StringsKt__StringsJVMKt.isBlank(value);
                if (!isBlank2) {
                    z16 = false;
                    if (z16) {
                        String value2 = ConversationItemData.this.answer._state.getValue();
                        if (value2 != null) {
                            isBlank = StringsKt__StringsJVMKt.isBlank(value2);
                            if (!isBlank) {
                                z17 = false;
                                if (z17) {
                                    z18 = true;
                                }
                            }
                        }
                        z17 = true;
                        if (z17) {
                        }
                    }
                    return Boolean.valueOf(z18);
                }
            }
            z16 = true;
            if (z16) {
            }
            return Boolean.valueOf(z18);
        }
    });
    public StateHolder<String> question;
    public a questionInputBoxCoordinates;

    public ConversationItemData(String str, String str2) {
        this.question = new StateHolder<>(str);
        this.answer = new StateHolder<>(str2);
    }

    public final int hashCode() {
        return (this.question._state.getValue() + this.answer._state.getValue()).hashCode();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConversationItemData)) {
            return false;
        }
        ConversationItemData conversationItemData = (ConversationItemData) obj;
        return Intrinsics.areEqual(this.question._state.getValue(), conversationItemData.question._state.getValue()) && Intrinsics.areEqual(this.answer._state.getValue(), conversationItemData.answer._state.getValue());
    }
}
