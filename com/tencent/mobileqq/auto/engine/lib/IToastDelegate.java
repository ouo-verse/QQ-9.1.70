package com.tencent.mobileqq.auto.engine.lib;

import android.widget.Toast;

/* compiled from: P */
/* loaded from: classes11.dex */
public interface IToastDelegate {
    int getIconTypeDefault();

    int getIconTypeError();

    int getIconTypeNone();

    int getIconTypeSuccess();

    Toast makeTextAndShow(int i3, String str, int i16);

    Toast showToastByNativeToast(int i3, String str, int i16);
}
