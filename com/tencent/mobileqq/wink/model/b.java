package com.tencent.mobileqq.wink.model;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0012\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006J\u001a\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\nJ\u0016\u0010\u000e\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\u000f\u001a\u00020\u0004R\"\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0010R\"\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010R*\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00028\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0015\u001a\u0004\b\u0012\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/wink/model/b;", "", "", "tagTitle", "", "e", "Lkotlin/Pair;", "b", "tagName", NodeProps.VISIBLE, "", h.F, "f", "a", "g", "d", "Lkotlin/Pair;", "isShowChallengeFromCapture", "c", "isShowChallengeFromEditor", "value", "Ljava/lang/String;", "()Ljava/lang/String;", "i", "(Ljava/lang/String;)V", "manualDeletedChallengeTagInEditor", "<init>", "()V", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f324006a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public static Pair<String, Boolean> isShowChallengeFromCapture;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public static Pair<String, Boolean> isShowChallengeFromEditor;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String manualDeletedChallengeTagInEditor;

    static {
        Boolean bool = Boolean.FALSE;
        isShowChallengeFromCapture = new Pair<>("", bool);
        isShowChallengeFromEditor = new Pair<>("", bool);
        manualDeletedChallengeTagInEditor = "";
    }

    b() {
    }

    public final void a() {
        QLog.d("WinkGlobalChallengeData", 1, "clearAll... isShowChallengeFromCapture:" + isShowChallengeFromCapture + " isShowChallengeFromEditor:" + isShowChallengeFromEditor);
        Boolean bool = Boolean.FALSE;
        isShowChallengeFromCapture = new Pair<>("", bool);
        isShowChallengeFromEditor = new Pair<>("", bool);
    }

    @Nullable
    public final Pair<String, Boolean> b() {
        boolean isBlank;
        boolean isBlank2;
        isBlank = StringsKt__StringsJVMKt.isBlank(isShowChallengeFromEditor.getFirst());
        if (!(!isBlank)) {
            isBlank2 = StringsKt__StringsJVMKt.isBlank(isShowChallengeFromCapture.getFirst());
            if (!isBlank2) {
                return isShowChallengeFromCapture;
            }
            return null;
        }
        return isShowChallengeFromEditor;
    }

    @NotNull
    public final String c() {
        return manualDeletedChallengeTagInEditor;
    }

    public final boolean d() {
        boolean studyModeSwitch = ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch();
        QLog.d("WinkGlobalChallengeData", 4, "isNeedSetChallengeData... studyMode:" + studyModeSwitch);
        return !studyModeSwitch;
    }

    public final boolean e(@Nullable String tagTitle) {
        boolean isBlank;
        if (Intrinsics.areEqual(isShowChallengeFromCapture.getFirst(), tagTitle)) {
            isBlank = StringsKt__StringsJVMKt.isBlank(tagTitle);
            if (!isBlank) {
                return isShowChallengeFromCapture.getSecond().booleanValue();
            }
        }
        return false;
    }

    public final boolean f() {
        boolean isBlank;
        boolean isBlank2;
        isBlank = StringsKt__StringsJVMKt.isBlank(isShowChallengeFromEditor.getFirst());
        if (!(!isBlank)) {
            isBlank2 = StringsKt__StringsJVMKt.isBlank(isShowChallengeFromCapture.getFirst());
            if (!isBlank2) {
                return isShowChallengeFromCapture.getSecond().booleanValue();
            }
            return false;
        }
        return isShowChallengeFromEditor.getSecond().booleanValue();
    }

    public final void g(@NotNull String tagName, boolean visible) {
        Intrinsics.checkNotNullParameter(tagName, "tagName");
        if (visible) {
            isShowChallengeFromEditor = new Pair<>(tagName, Boolean.TRUE);
            if (!Intrinsics.areEqual(isShowChallengeFromCapture.getFirst(), tagName)) {
                isShowChallengeFromCapture = new Pair<>("", Boolean.FALSE);
            }
        } else if (!visible) {
            isShowChallengeFromEditor = new Pair<>(isShowChallengeFromEditor.getFirst(), Boolean.FALSE);
        }
        QLog.d("WinkGlobalChallengeData", 1, "setEditor... isShowChallengeFromCapture:" + isShowChallengeFromCapture + " isShowChallengeFromEditor:" + isShowChallengeFromEditor);
    }

    public final void h(@Nullable String tagName, boolean visible) {
        boolean isBlank;
        boolean isBlank2;
        boolean isBlank3;
        boolean isBlank4;
        QLog.d("WinkGlobalChallengeData", 1, "setHighChallengeTopic... isShowChallengeFromCapture:" + isShowChallengeFromCapture + " isShowChallengeFromEditor:" + isShowChallengeFromEditor + " tagName:" + tagName + " visible:" + visible);
        if (tagName == null) {
            isBlank3 = StringsKt__StringsJVMKt.isBlank(isShowChallengeFromEditor.getFirst());
            if (!isBlank3) {
                isShowChallengeFromEditor = new Pair<>(isShowChallengeFromEditor.getFirst(), Boolean.valueOf(visible));
            }
            isBlank4 = StringsKt__StringsJVMKt.isBlank(isShowChallengeFromCapture.getFirst());
            if (!isBlank4) {
                isShowChallengeFromCapture = new Pair<>(isShowChallengeFromCapture.getFirst(), Boolean.valueOf(visible));
                return;
            }
            return;
        }
        isBlank = StringsKt__StringsJVMKt.isBlank(isShowChallengeFromEditor.getFirst());
        if ((!isBlank) && Intrinsics.areEqual(tagName, isShowChallengeFromEditor.getFirst())) {
            isShowChallengeFromEditor = new Pair<>(isShowChallengeFromEditor.getFirst(), Boolean.valueOf(visible));
        }
        isBlank2 = StringsKt__StringsJVMKt.isBlank(isShowChallengeFromCapture.getFirst());
        if ((!isBlank2) && Intrinsics.areEqual(tagName, isShowChallengeFromCapture.getFirst())) {
            isShowChallengeFromCapture = new Pair<>(isShowChallengeFromCapture.getFirst(), Boolean.valueOf(visible));
        }
    }

    public final void i(@NotNull String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        manualDeletedChallengeTagInEditor = value;
        QLog.i("WinkGlobalChallengeData", 1, "manualDeletedChallengeTagInEditor=" + value);
    }
}
