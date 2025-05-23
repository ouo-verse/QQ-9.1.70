package com.tencent.apkupdate;

import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface ApkUpdateListener {
    void onCheckUpdateFailed(String str);

    void onCheckUpdateSucceed(ArrayList<ApkUpdateDetail> arrayList);
}
