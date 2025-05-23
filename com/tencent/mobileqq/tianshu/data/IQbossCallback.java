package com.tencent.mobileqq.tianshu.data;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes18.dex */
public interface IQbossCallback {
    void getQbossFail(int i3, String str, String str2, ArrayList<Integer> arrayList);

    void getQbossSuccess(Bundle bundle, String str, AppInterface appInterface);
}
