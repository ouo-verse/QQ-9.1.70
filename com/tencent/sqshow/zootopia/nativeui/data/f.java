package com.tencent.sqshow.zootopia.nativeui.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\u0003\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/data/f;", "", "Lcom/tencent/sqshow/zootopia/nativeui/data/AvatarNativeRetainStyle;", "a", "Lcom/tencent/sqshow/zootopia/nativeui/data/AvatarNativeRetainStyle;", "b", "()Lcom/tencent/sqshow/zootopia/nativeui/data/AvatarNativeRetainStyle;", "d", "(Lcom/tencent/sqshow/zootopia/nativeui/data/AvatarNativeRetainStyle;)V", "retainStyle", "Lcom/tencent/sqshow/zootopia/nativeui/data/OrientationMode;", "Lcom/tencent/sqshow/zootopia/nativeui/data/OrientationMode;", "()Lcom/tencent/sqshow/zootopia/nativeui/data/OrientationMode;", "c", "(Lcom/tencent/sqshow/zootopia/nativeui/data/OrientationMode;)V", "orientationMode", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private AvatarNativeRetainStyle retainStyle = AvatarNativeRetainStyle.MENU;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private OrientationMode orientationMode = OrientationMode.PORTRAIT;

    /* renamed from: a, reason: from getter */
    public final OrientationMode getOrientationMode() {
        return this.orientationMode;
    }

    /* renamed from: b, reason: from getter */
    public final AvatarNativeRetainStyle getRetainStyle() {
        return this.retainStyle;
    }

    public final void c(OrientationMode orientationMode) {
        Intrinsics.checkNotNullParameter(orientationMode, "<set-?>");
        this.orientationMode = orientationMode;
    }

    public final void d(AvatarNativeRetainStyle avatarNativeRetainStyle) {
        Intrinsics.checkNotNullParameter(avatarNativeRetainStyle, "<set-?>");
        this.retainStyle = avatarNativeRetainStyle;
    }
}
