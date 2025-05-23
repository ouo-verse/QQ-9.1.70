package com.tencent.mobileqq.selectfriend.eventbus.event;

import android.view.View;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\tR\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/selectfriend/eventbus/event/MyEventClickEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "view", "Landroid/view/View;", "uin", "", "uinType", "", "forwardAbility", "(Landroid/view/View;Ljava/lang/String;II)V", "getForwardAbility", "()I", "getUin", "()Ljava/lang/String;", "getUinType", "getView", "()Landroid/view/View;", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class MyEventClickEvent extends SimpleBaseEvent {
    private final int forwardAbility;
    private final String uin;
    private final int uinType;
    private final View view;

    public MyEventClickEvent(View view, String uin, int i3, int i16) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(uin, "uin");
        this.view = view;
        this.uin = uin;
        this.uinType = i3;
        this.forwardAbility = i16;
    }

    public final int getForwardAbility() {
        return this.forwardAbility;
    }

    public final String getUin() {
        return this.uin;
    }

    public final int getUinType() {
        return this.uinType;
    }

    public final View getView() {
        return this.view;
    }
}
