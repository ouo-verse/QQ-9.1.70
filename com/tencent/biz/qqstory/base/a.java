package com.tencent.biz.qqstory.base;

import com.tribe.async.dispatch.Dispatcher;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a implements Dispatcher.Event {

    /* renamed from: d, reason: collision with root package name */
    public ErrorMessage f93986d = new ErrorMessage();

    public String toString() {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("{\"_class\":\"SimpleBaseEvent\", \"errorInfo\":");
        if (this.f93986d == null) {
            str = "null";
        } else {
            str = "\"" + this.f93986d + "\"";
        }
        sb5.append(str);
        sb5.append("}");
        return sb5.toString();
    }
}
