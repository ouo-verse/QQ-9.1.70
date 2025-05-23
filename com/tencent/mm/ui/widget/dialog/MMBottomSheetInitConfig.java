package com.tencent.mm.ui.widget.dialog;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0005\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mm/ui/widget/dialog/MMBottomSheetInitConfig;", "", "", "a", "Z", "isNeedShowDialog", "()Z", "<init>", "(Z)V", "weui-native-android-lib_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class MMBottomSheetInitConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final boolean isNeedShowDialog;

    public MMBottomSheetInitConfig() {
        this(false, 1, null);
    }

    /* renamed from: isNeedShowDialog, reason: from getter */
    public final boolean getIsNeedShowDialog() {
        return this.isNeedShowDialog;
    }

    public MMBottomSheetInitConfig(boolean z16) {
        this.isNeedShowDialog = z16;
    }

    public /* synthetic */ MMBottomSheetInitConfig(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? true : z16);
    }
}
