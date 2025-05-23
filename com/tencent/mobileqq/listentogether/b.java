package com.tencent.mobileqq.listentogether;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.util.cu;
import java.io.File;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static String f240893a;

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f240894b;

    static {
        if (cu.e()) {
            f240893a = new File(BaseApplicationImpl.getApplication().getExternalFilesDir(null), "ListenTogether_v828").getAbsolutePath();
        } else {
            f240893a = new File(BaseApplicationImpl.getApplication().getFilesDir(), "ListenTogether_v828").getAbsolutePath();
        }
        f240894b = new int[]{-1182476, -16725252, -16717828, 2136267007, -1567, -996497, -1356, 2147468069, -924417, -9253895, -218377, 2147454710};
    }
}
