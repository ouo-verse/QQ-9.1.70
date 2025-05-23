package com.tencent.luggage.wxa.l7;

import com.tencent.luggage.wxaapi.WxaAppCustomActionSheetDelegate;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c extends d {

    /* renamed from: n, reason: collision with root package name */
    public final WxaAppCustomActionSheetDelegate.ActionItem f133102n;

    /* renamed from: o, reason: collision with root package name */
    public final String f133103o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(WxaAppCustomActionSheetDelegate.ActionItem actionStruct, int i3, String str, int i16, String str2, b delegate) {
        super(i3, str, i16, true, 0, delegate);
        Intrinsics.checkNotNullParameter(actionStruct, "actionStruct");
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.f133102n = actionStruct;
        this.f133103o = str2;
    }

    public final WxaAppCustomActionSheetDelegate.ActionItem h() {
        return this.f133102n;
    }

    public final int i() {
        return this.f133102n.f146880i;
    }

    public final int j() {
        return this.f133102n.f146881m;
    }

    public final String k() {
        return this.f133103o;
    }

    public final WxaAppCustomActionSheetDelegate.ActionType l() {
        WxaAppCustomActionSheetDelegate.ActionType actionType = this.f133102n.f146876d;
        Intrinsics.checkNotNullExpressionValue(actionType, "actionStruct.type");
        return actionType;
    }
}
