package com.tencent.mobileqq.utils.api.impl;

import android.content.Context;
import com.tencent.mobileqq.utils.ae;
import com.tencent.mobileqq.utils.api.IDBUtils;

/* compiled from: P */
/* loaded from: classes20.dex */
public class DBUtilsImpl implements IDBUtils {
    @Override // com.tencent.mobileqq.utils.api.IDBUtils
    public int getSubAccountVersion(Context context) {
        return ae.a().b(context);
    }

    @Override // com.tencent.mobileqq.utils.api.IDBUtils
    public void setShowSubAccountInRecentList(Context context, String str, boolean z16) {
        ae.a().c(context, str, z16);
    }

    @Override // com.tencent.mobileqq.utils.api.IDBUtils
    public void setSubAccountVersion(Context context) {
        ae.a().d(context);
    }

    @Override // com.tencent.mobileqq.utils.api.IDBUtils
    public boolean showSubAccountInRecentList(Context context, String str) {
        return ae.a().e(context, str);
    }

    @Override // com.tencent.mobileqq.utils.api.IDBUtils
    public boolean subAccountOldVersionUpdate(Context context, String str) {
        return ae.a().f(context, str);
    }
}
