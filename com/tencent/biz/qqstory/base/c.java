package com.tencent.biz.qqstory.base;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c {
    public static Dispatcher a() {
        return Dispatchers.get(ThreadManagerV2.getSubThreadLooper());
    }
}
