package com.tencent.av.business.handler;

import android.text.TextUtils;
import com.tencent.av.screenshare.ScreenShareHandler;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static final String f73289a = ScreenShareHandler.class.getName();

    public void a(cu.a aVar) {
        String[] F2 = ScreenShareHandler.F2();
        if (F2 != null && F2.length > 0) {
            for (String str : F2) {
                if (!TextUtils.isEmpty(str)) {
                    aVar.a(str, new String[]{f73289a}, true);
                }
            }
        }
    }
}
