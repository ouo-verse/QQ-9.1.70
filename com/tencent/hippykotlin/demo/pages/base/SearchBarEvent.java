package com.tencent.hippykotlin.demo.pages.base;

import com.tencent.kuikly.core.base.event.Event;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class SearchBarEvent extends Event {
    public Function1<Object, ? extends Object> onClickBack;
    public Function1<Object, ? extends Object> onClickCancel;
    public Function1<Object, ? extends Object> onClickSearch;
    public Function1<Object, ? extends Object> onTextChanged;
}
