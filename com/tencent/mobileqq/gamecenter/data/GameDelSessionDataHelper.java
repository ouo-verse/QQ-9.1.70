package com.tencent.mobileqq.gamecenter.data;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.msginfo.GameCenterSessionInfo;
import com.tencent.mobileqq.gamecenter.msginfo.GameDelSessionRecord;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GameDelSessionDataHelper extends a implements j {

    /* renamed from: b, reason: collision with root package name */
    private Map<String, GameDelSessionRecord> f211958b;

    public GameDelSessionDataHelper(EntityManager entityManager) {
        super(entityManager);
        this.f211958b = Collections.synchronizedMap(new HashMap());
    }

    public static void g(String str) {
        try {
            if (QLog.isColorLevel()) {
                QLog.d("GameCenterMsg.DelGameSessionDataHelper", 2, "[delGameSession], json:" + str);
            }
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                h(jSONArray.optString(i3));
            }
            Intent intent = new Intent("action_qgame_messgae_change");
            intent.setPackage(com.tencent.mobileqq.gamecenter.utils.f.n().getApplication().getPackageName());
            Bundle bundle = new Bundle();
            bundle.putBoolean("is_update_publicaccount_only", true);
            intent.putExtras(bundle);
            com.tencent.mobileqq.gamecenter.utils.f.n().getApplication().sendBroadcast(intent);
        } catch (Throwable th5) {
            QLog.e("GameCenterMsg.DelGameSessionDataHelper", 1, th5, new Object[0]);
        }
    }

    private static void h(final String str) {
        QLog.i("GameCenterMsg.DelGameSessionDataHelper", 1, "[handleDelSession], sessionId:" + str);
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.data.GameDelSessionDataHelper.2
            @Override // java.lang.Runnable
            public void run() {
                IGameMsgManagerService iGameMsgManagerService = (IGameMsgManagerService) com.tencent.mobileqq.gamecenter.utils.f.n().getRuntimeService(IGameMsgManagerService.class, "");
                j sessionDelDataHelper = iGameMsgManagerService.getSessionDelDataHelper();
                if (sessionDelDataHelper == null) {
                    QLog.w("GameCenterMsg.DelGameSessionDataHelper", 1, "dataVisitor is null.");
                    return;
                }
                GameCenterSessionInfo sessionInfoByUin = iGameMsgManagerService.getSessionInfoByUin(str);
                if (sessionInfoByUin == null) {
                    QLog.w("GameCenterMsg.DelGameSessionDataHelper", 1, "sessionInfo is null.");
                    return;
                }
                GameDelSessionRecord gameDelSessionRecord = new GameDelSessionRecord();
                gameDelSessionRecord.mUin = str;
                iGameMsgManagerService.setRead(sessionInfoByUin);
                sessionDelDataHelper.c(gameDelSessionRecord);
            }
        });
    }

    public static void j(final String str, final j jVar) {
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.data.GameDelSessionDataHelper.1
            @Override // java.lang.Runnable
            public void run() {
                if (j.this == null) {
                    return;
                }
                GameDelSessionRecord gameDelSessionRecord = new GameDelSessionRecord();
                gameDelSessionRecord.mUin = str;
                j.this.a(gameDelSessionRecord);
            }
        });
    }

    @Override // com.tencent.mobileqq.gamecenter.data.j
    public boolean a(Entity entity) {
        if (!(entity instanceof GameDelSessionRecord)) {
            return false;
        }
        try {
            GameDelSessionRecord gameDelSessionRecord = (GameDelSessionRecord) entity;
            if (TextUtils.isEmpty(gameDelSessionRecord.mUin) || this.f211958b.get(gameDelSessionRecord.mUin) == null) {
                return false;
            }
            gameDelSessionRecord.setStatus(1001);
            QLog.i("GameCenterMsg.DelGameSessionDataHelper", 1, "[removeDelItem], start to remove. size:" + this.f211958b.size());
            if (!super.d(entity, "mUin=?", new String[]{gameDelSessionRecord.mUin})) {
                return false;
            }
            this.f211958b.remove(gameDelSessionRecord.mUin);
            QLog.i("GameCenterMsg.DelGameSessionDataHelper", 1, "Remove succeeds. size:" + this.f211958b.size());
            return true;
        } catch (Throwable th5) {
            QLog.e("GameCenterMsg.DelGameSessionDataHelper", 1, th5, new Object[0]);
            return false;
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.data.j
    public boolean b(Entity entity) {
        if (!(entity instanceof GameDelSessionRecord) || this.f211958b.get(((GameDelSessionRecord) entity).mUin) == null) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.gamecenter.data.j
    public boolean c(Entity entity) {
        QLog.i("GameCenterMsg.DelGameSessionDataHelper", 1, "[addDelItem]");
        try {
            if (!(entity instanceof GameDelSessionRecord)) {
                return false;
            }
            GameDelSessionRecord gameDelSessionRecord = (GameDelSessionRecord) entity;
            if (TextUtils.isEmpty(gameDelSessionRecord.mUin)) {
                return false;
            }
            if (this.f211958b.get(gameDelSessionRecord.mUin) != null) {
                QLog.i("GameCenterMsg.DelGameSessionDataHelper", 1, "item already exists.");
                return false;
            }
            if (!super.e(entity)) {
                return false;
            }
            this.f211958b.put(gameDelSessionRecord.mUin, gameDelSessionRecord);
            QLog.i("GameCenterMsg.DelGameSessionDataHelper", 1, "Add succeeds.");
            return true;
        } catch (Throwable th5) {
            QLog.e("GameCenterMsg.DelGameSessionDataHelper", 1, th5, new Object[0]);
            return false;
        }
    }

    public void i() {
        try {
            QLog.i("GameCenterMsg.DelGameSessionDataHelper", 1, "[initCache]");
            ArrayList arrayList = (ArrayList) this.f211986a.query(GameDelSessionRecord.class);
            if (arrayList != null && arrayList.size() != 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Entity entity = (Entity) it.next();
                    if (entity != null) {
                        GameDelSessionRecord gameDelSessionRecord = (GameDelSessionRecord) entity;
                        if (!TextUtils.isEmpty(gameDelSessionRecord.mUin)) {
                            this.f211958b.put(gameDelSessionRecord.mUin, gameDelSessionRecord);
                        }
                    }
                }
                QLog.i("GameCenterMsg.DelGameSessionDataHelper", 1, "delSession.size:" + this.f211958b.size());
            }
        } catch (Throwable th5) {
            QLog.e("GameCenterMsg.DelGameSessionDataHelper", 1, th5.getMessage());
        }
    }
}
