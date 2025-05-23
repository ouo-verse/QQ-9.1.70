package com.tencent.mobileqq.widget;

import android.content.SharedPreferences;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;

/* compiled from: P */
/* loaded from: classes20.dex */
public class bp implements View.OnTouchListener {

    /* renamed from: d, reason: collision with root package name */
    public static int f316777d = -1;

    public static int a() {
        int i3 = f316777d;
        if (i3 != 0 && i3 != 1) {
            f316777d = BaseApplicationImpl.sApplication.getSharedPreferences("SP_KEY_PHOTO_LIST_PANEL", 0).getInt("SP_KEY_DRAG_MODE", 1);
        }
        return f316777d;
    }

    public static void b(int i3) {
        if (i3 == 0 || i3 == 1) {
            SharedPreferences.Editor edit = BaseApplicationImpl.sApplication.getSharedPreferences("SP_KEY_PHOTO_LIST_PANEL", 0).edit();
            edit.putInt("SP_KEY_DRAG_MODE", i3);
            edit.commit();
        }
    }
}
