package com.tencent.mobileqq.onlinestatus.utils;

import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes16.dex */
public class e {
    public static int a(AppRuntime.Status status) {
        if (status == AppRuntime.Status.away) {
            return 1;
        }
        if (status == AppRuntime.Status.busy) {
            return 2;
        }
        if (status == AppRuntime.Status.dnd) {
            return 3;
        }
        return -1;
    }
}
