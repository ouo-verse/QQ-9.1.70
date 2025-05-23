package com.tencent.mobileqq.matchfriend.reborn.userinfo;

import com.tencent.mobileqq.matchfriend.bean.QQStrangerUserInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.transaction.PersistOrReplaceTransaction;
import com.tencent.mobileqq.persistence.transaction.UpdateTransaction;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.AppRuntime;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \r2\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0007J\u0016\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\u0004R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/userinfo/e;", "", "Lcom/tencent/mobileqq/matchfriend/bean/QQStrangerUserInfo;", ITVKPlayerEventListener.KEY_USER_INFO, "", "d", "", "c", "", "chatType", "", "tinyId", "a", "b", "Lcom/tencent/mobileqq/persistence/EntityManager;", "Lcom/tencent/mobileqq/persistence/EntityManager;", "entityManager", "Lmqq/app/AppRuntime;", "appInterface", "<init>", "(Lmqq/app/AppRuntime;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private EntityManager entityManager;

    public e(AppRuntime appInterface) {
        Intrinsics.checkNotNullParameter(appInterface, "appInterface");
        this.entityManager = appInterface.getEntityManagerFactory().createEntityManager();
    }

    public final void a(int chatType, String tinyId) {
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        long nanoTime = System.nanoTime();
        EntityManager entityManager = this.entityManager;
        Integer valueOf = entityManager != null ? Integer.valueOf(entityManager.delete(Reflection.getOrCreateKotlinClass(QQStrangerUserInfo.class).getSimpleName(), "chatType=? AND tinyId=?", new String[]{String.valueOf(chatType), tinyId})) : null;
        long nanoTime2 = System.nanoTime() - nanoTime;
        if (QLog.isDevelopLevel()) {
            QLog.d("QQStrangerUserInfoStorage", 1, "[delete] cost:" + nanoTime2 + "(ns), count=" + valueOf);
        }
    }

    public final void b() {
        long nanoTime = System.nanoTime();
        EntityManager entityManager = this.entityManager;
        Boolean valueOf = entityManager != null ? Boolean.valueOf(entityManager.drop(QQStrangerUserInfo.class)) : null;
        long nanoTime2 = System.nanoTime() - nanoTime;
        if (QLog.isDevelopLevel()) {
            QLog.d("QQStrangerUserInfoStorage", 1, "[deleteAll] cost:" + nanoTime2 + "(ns), result=" + valueOf);
        }
    }

    public final List<QQStrangerUserInfo> c() {
        ArrayList arrayList = new ArrayList();
        long nanoTime = System.nanoTime();
        EntityManager entityManager = this.entityManager;
        List<? extends Entity> query = entityManager != null ? entityManager.query(QQStrangerUserInfo.class, true, null, null, null, null, "", null) : null;
        List<? extends Entity> list = query instanceof List ? query : null;
        if (list != null) {
            arrayList.addAll(list);
        }
        long nanoTime2 = System.nanoTime() - nanoTime;
        if (QLog.isDevelopLevel()) {
            QLog.d("QQStrangerUserInfoStorage", 1, "[getAll] cost:" + nanoTime2 + "(ns), resultSize=" + arrayList.size());
        }
        return arrayList;
    }

    public final void d(QQStrangerUserInfo userInfo) {
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        long nanoTime = System.nanoTime();
        ArrayList arrayList = new ArrayList();
        if (userInfo.getStatus() == 1000) {
            arrayList.add(new PersistOrReplaceTransaction(userInfo));
        } else if (userInfo.getStatus() == 1001 || userInfo.getStatus() == 1002) {
            arrayList.add(new UpdateTransaction(userInfo));
        }
        EntityManager entityManager = this.entityManager;
        Boolean valueOf = entityManager != null ? Boolean.valueOf(entityManager.doMultiDBOperateByTransaction(arrayList)) : null;
        long nanoTime2 = System.nanoTime() - nanoTime;
        if (QLog.isDevelopLevel()) {
            QLog.d("QQStrangerUserInfoStorage", 1, "[upsert] cost:" + nanoTime2 + "(ns), result=" + valueOf);
        }
    }
}
