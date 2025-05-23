package com.tencent.mobileqq.zplan.smallhome.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.zplan.luabridge.LuaArgument;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0003\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/zplan/smallhome/event/ZPlanUEShowDialogEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "title", "", "msg", "confirmBtn", "cancelBtn", "argument", "Lcom/tencent/zplan/luabridge/LuaArgument;", "nativeScheme", "dialogType", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/zplan/luabridge/LuaArgument;Ljava/lang/String;I)V", "getArgument", "()Lcom/tencent/zplan/luabridge/LuaArgument;", "getCancelBtn", "()Ljava/lang/String;", "getConfirmBtn", "getDialogType", "()I", "getMsg", "getNativeScheme", "getTitle", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class ZPlanUEShowDialogEvent extends SimpleBaseEvent {
    private final LuaArgument argument;
    private final String cancelBtn;
    private final String confirmBtn;
    private final int dialogType;
    private final String msg;
    private final String nativeScheme;
    private final String title;

    public /* synthetic */ ZPlanUEShowDialogEvent(String str, String str2, String str3, String str4, LuaArgument luaArgument, String str5, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i16 & 8) != 0 ? "" : str4, (i16 & 16) != 0 ? null : luaArgument, (i16 & 32) != 0 ? null : str5, (i16 & 64) != 0 ? 0 : i3);
    }

    public final LuaArgument getArgument() {
        return this.argument;
    }

    public final String getCancelBtn() {
        return this.cancelBtn;
    }

    public final String getConfirmBtn() {
        return this.confirmBtn;
    }

    public final int getDialogType() {
        return this.dialogType;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final String getNativeScheme() {
        return this.nativeScheme;
    }

    public final String getTitle() {
        return this.title;
    }

    public ZPlanUEShowDialogEvent(String title, String msg2, String confirmBtn, String cancelBtn, LuaArgument luaArgument, String str, @DialogType int i3) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(confirmBtn, "confirmBtn");
        Intrinsics.checkNotNullParameter(cancelBtn, "cancelBtn");
        this.title = title;
        this.msg = msg2;
        this.confirmBtn = confirmBtn;
        this.cancelBtn = cancelBtn;
        this.argument = luaArgument;
        this.nativeScheme = str;
        this.dialogType = i3;
    }
}
