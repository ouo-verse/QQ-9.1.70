package com.tencent.mobileqq.wink.publish.util;

import android.content.Intent;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.selectmember.ResultRecord;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes21.dex */
public class d {

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f325976a;

        /* renamed from: b, reason: collision with root package name */
        public String f325977b;
    }

    public static ArrayList<a> a(Intent intent) {
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(ISelectMemberActivityConstants.PARAM_RESULT_SET);
        if (parcelableArrayListExtra != null) {
            ArrayList<a> arrayList = new ArrayList<>(parcelableArrayListExtra.size());
            Iterator it = parcelableArrayListExtra.iterator();
            while (it.hasNext()) {
                ResultRecord resultRecord = (ResultRecord) it.next();
                a aVar = new a();
                aVar.f325976a = resultRecord.uin;
                aVar.f325977b = resultRecord.name;
                arrayList.add(aVar);
            }
            return arrayList;
        }
        return null;
    }
}
