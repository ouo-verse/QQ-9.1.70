package com.tencent.sqshow.zootopia.database.test;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.sqshow.zootopia.database.ZplanDataBaseHelper;
import java.util.List;

/* compiled from: P */
/* loaded from: classes34.dex */
class TestZplanDbUtil$1 implements Runnable {
    TestZplanDbUtil$1() {
    }

    @Override // java.lang.Runnable
    public void run() {
        ZplanDataBaseHelper h16 = ZplanDataBaseHelper.h();
        v84.a.e("TestZplanDbUtil", "testDb#queryDb -- " + h16.k(TestZplanEntity.class));
        TestZplanEntity testZplanEntity = new TestZplanEntity();
        testZplanEntity.uid = "1111";
        testZplanEntity.openid = System.currentTimeMillis() + "";
        testZplanEntity.testValue = 3;
        h16.i(testZplanEntity);
        TestZplanEntity testZplanEntity2 = new TestZplanEntity();
        testZplanEntity2.uid = "2222";
        testZplanEntity2.openid = System.currentTimeMillis() + "";
        testZplanEntity2.testValue = 4;
        h16.i(testZplanEntity2);
        List<? extends Entity> k3 = h16.k(TestZplanEntity.class);
        v84.a.e("TestZplanDbUtil", "testDb#queryDb2 after insert -- " + k3);
        if (k3 == null || k3.size() <= 0) {
            return;
        }
        h16.n(k3.get(0));
        v84.a.e("TestZplanDbUtil", "testDb#queryDb3 after delete -- " + h16.k(TestZplanEntity.class));
    }
}
