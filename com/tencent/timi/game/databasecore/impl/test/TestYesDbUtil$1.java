package com.tencent.timi.game.databasecore.impl.test;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.timi.game.databasecore.impl.YesDataBaseHelper;
import com.tencent.timi.game.utils.l;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
class TestYesDbUtil$1 implements Runnable {
    TestYesDbUtil$1() {
    }

    @Override // java.lang.Runnable
    public void run() {
        YesDataBaseHelper f16 = YesDataBaseHelper.f();
        l.i("TestYesDbUtil", "testDb#queryDb -- " + f16.j(TestYesEntity.class));
        TestYesEntity testYesEntity = new TestYesEntity();
        testYesEntity.uid = "1111";
        testYesEntity.openid = System.currentTimeMillis() + "";
        testYesEntity.testValue = 3;
        f16.h(testYesEntity);
        TestYesEntity testYesEntity2 = new TestYesEntity();
        testYesEntity2.uid = "2222";
        testYesEntity2.openid = System.currentTimeMillis() + "";
        testYesEntity2.testValue = 4;
        f16.h(testYesEntity2);
        List<? extends Entity> j3 = f16.j(TestYesEntity.class);
        l.i("TestYesDbUtil", "testDb#queryDb2 after insert -- " + j3);
        if (j3 != null && j3.size() > 0) {
            f16.m(j3.get(0));
            l.i("TestYesDbUtil", "testDb#queryDb3 after delete -- " + f16.j(TestYesEntity.class));
        }
    }
}
