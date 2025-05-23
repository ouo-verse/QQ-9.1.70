package com.tencent.biz.qqcircle.immersive.utils;

import android.view.View;
import android.view.ViewStub;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes4.dex */
public class al {
    private static ViewStub a(@Nullable View view) {
        ViewStub viewStub;
        int folderUIType = QCircleHostGlobalInfo.getFolderUIType();
        if (folderUIType != 2) {
            if (folderUIType != 3) {
                QLog.e("QFSPartUtils", 1, "getToolBarByUIType error,invalid UIType:", Integer.valueOf(QCircleHostGlobalInfo.getFolderUIType()));
                viewStub = null;
            } else {
                viewStub = (ViewStub) view.findViewById(R.id.f46661v7);
            }
        } else {
            viewStub = (ViewStub) view.findViewById(R.id.f46651v6);
        }
        QLog.d("QFSPartUtils", 1, "getToolBarByUIType:", Integer.valueOf(QCircleHostGlobalInfo.getFolderUIType()));
        return viewStub;
    }

    public static void b(@Nullable View view) {
        ViewStub a16 = a(view);
        if (a16 != null) {
            a16.inflate();
        }
    }
}
