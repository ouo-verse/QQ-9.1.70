package com.tencent.minibox.common.exception;

import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/minibox/common/exception/AttaUserAdvice;", "", "", "b", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "setAdvice", "(Ljava/lang/String;)V", "advice", "Ljava/util/ArrayList;", "Lcom/tencent/minibox/common/exception/AttaUserAdvice$Type;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "typeList", "<init>", "()V", "Type", "MiniBoxCommon_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes9.dex */
public final class AttaUserAdvice {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String advice = "";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<Type> typeList = new ArrayList<>();

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/minibox/common/exception/AttaUserAdvice$Type;", "", "value", "", "(Ljava/lang/String;II)V", HippyTextInputController.COMMAND_getValue, "()I", "PLAY_ERROR", "DYSFUNCTION", "NEED_LOGIN", "NEED_UPDATE", "GAME_LAG", "BLACK_SCREEN", "OTHER", "MiniBoxCommon_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes9.dex */
    public enum Type {
        PLAY_ERROR(1),
        DYSFUNCTION(2),
        NEED_LOGIN(3),
        NEED_UPDATE(4),
        GAME_LAG(5),
        BLACK_SCREEN(6),
        OTHER(7);

        private final int value;

        Type(int i3) {
            this.value = i3;
        }

        public final int getValue() {
            return this.value;
        }
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getAdvice() {
        return this.advice;
    }

    @NotNull
    public final String b() {
        int lastIndex;
        if (this.typeList.isEmpty()) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        Iterator<T> it = this.typeList.iterator();
        while (it.hasNext()) {
            sb5.append(((Type) it.next()).getValue());
            sb5.append(",");
        }
        lastIndex = StringsKt__StringsKt.getLastIndex(sb5);
        sb5.deleteCharAt(lastIndex);
        String sb6 = sb5.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb6, "typeStrBuilder.toString()");
        return sb6;
    }
}
