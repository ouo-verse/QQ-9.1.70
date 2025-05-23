package com.tencent.timi.game.component.gamecore.impl.config;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.databasecore.impl.YesDataBaseHelper;
import com.tencent.timi.game.utils.i;
import com.tencent.timi.game.utils.l;
import com.tencent.timi.game.utils.w;
import fg4.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import pl4.d;
import trpc.yes.common.GameDataServerOuterClass$GetAllGameConfigRsp;
import trpc.yes.common.YesGameInfoOuterClass$GameConfigInfo;

/* compiled from: P */
/* loaded from: classes26.dex */
public class GameConfigManager {

    /* renamed from: d, reason: collision with root package name */
    private static volatile GameConfigManager f376743d;

    /* renamed from: e, reason: collision with root package name */
    private static final HashMap<Integer, Integer> f376744e = new HashMap<Integer, Integer>() { // from class: com.tencent.timi.game.component.gamecore.impl.config.GameConfigManager.1
        {
            put(101, 1);
            put(102, 6);
            put(104, 8);
            put(103, 7);
            put(105, 9);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private HashMap<Integer, Integer> f376745a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private HashMap<Integer, YesGameInfoOuterClass$GameConfigInfo> f376746b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private boolean f376747c = false;

    public GameConfigManager() {
        this.f376745a.putAll(f376744e);
    }

    public static void d() {
        synchronized (GameConfigManager.class) {
            if (f376743d != null) {
                f376743d.e();
                f376743d = null;
            }
        }
    }

    private void e() {
        this.f376746b.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        for (Map.Entry<Integer, YesGameInfoOuterClass$GameConfigInfo> entry : this.f376746b.entrySet()) {
            int i3 = entry.getValue().game_room_type.get();
            if (i3 > 0) {
                this.f376745a.put(entry.getKey(), Integer.valueOf(i3));
            }
        }
    }

    public static GameConfigManager j() {
        if (f376743d == null) {
            synchronized (GameConfigManager.class) {
                if (f376743d == null) {
                    f376743d = new GameConfigManager();
                }
            }
        }
        return f376743d;
    }

    private void l(i iVar) {
        l.i("GameConfigManager", "readFromDb start");
        w.a(new Runnable(iVar) { // from class: com.tencent.timi.game.component.gamecore.impl.config.GameConfigManager.2
            @Override // java.lang.Runnable
            public void run() {
                final HashMap hashMap = new HashMap();
                List<? extends Entity> j3 = YesDataBaseHelper.f().j(GameConfigInfoEntity.class);
                if (j3 != null && j3.size() > 0) {
                    for (int i3 = 0; i3 < j3.size(); i3++) {
                        GameConfigInfoEntity gameConfigInfoEntity = (GameConfigInfoEntity) j3.get(i3);
                        YesGameInfoOuterClass$GameConfigInfo gameConfigInfo = gameConfigInfoEntity.getGameConfigInfo();
                        if (gameConfigInfo != null) {
                            hashMap.put(Integer.valueOf(gameConfigInfoEntity.yesGameId), gameConfigInfo);
                        }
                    }
                }
                w.c(new Runnable() { // from class: com.tencent.timi.game.component.gamecore.impl.config.GameConfigManager.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        GameConfigManager.this.f376746b.putAll(hashMap);
                        GameConfigManager.this.f();
                        l.i("GameConfigManager", "readFromDb finish - map.size = " + GameConfigManager.this.f376746b.size());
                        getClass();
                    }
                });
            }
        });
    }

    private void m(final YesGameInfoOuterClass$GameConfigInfo yesGameInfoOuterClass$GameConfigInfo) {
        if (yesGameInfoOuterClass$GameConfigInfo != null) {
            w.a(new Runnable() { // from class: com.tencent.timi.game.component.gamecore.impl.config.GameConfigManager.3
                @Override // java.lang.Runnable
                public void run() {
                    GameConfigInfoEntity gameConfigInfoEntity = new GameConfigInfoEntity();
                    gameConfigInfoEntity.saveInfo(yesGameInfoOuterClass$GameConfigInfo);
                    YesDataBaseHelper.f().h(gameConfigInfoEntity);
                }
            });
        }
    }

    public void g() {
        l.i("GameConfigManager", "getAllGameConfigs - " + this.f376747c);
        if (this.f376747c) {
            return;
        }
        f.e(new d<GameDataServerOuterClass$GetAllGameConfigRsp>() { // from class: com.tencent.timi.game.component.gamecore.impl.config.GameConfigManager.4
            @Override // pl4.d
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public void b(boolean z16, int i3, int i16, int i17, String str, String str2, @Nullable GameDataServerOuterClass$GetAllGameConfigRsp gameDataServerOuterClass$GetAllGameConfigRsp, @Nullable FromServiceMsg fromServiceMsg) {
                l.e("GameConfigManager", "getAllGameConfigs error - " + i16 + " - " + str2);
            }

            @Override // pl4.d
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public void a(GameDataServerOuterClass$GetAllGameConfigRsp gameDataServerOuterClass$GetAllGameConfigRsp, FromServiceMsg fromServiceMsg) {
                if (gameDataServerOuterClass$GetAllGameConfigRsp != null && gameDataServerOuterClass$GetAllGameConfigRsp.config_list.size() > 0) {
                    GameConfigManager.this.f376747c = true;
                    final ArrayList arrayList = new ArrayList();
                    for (YesGameInfoOuterClass$GameConfigInfo yesGameInfoOuterClass$GameConfigInfo : gameDataServerOuterClass$GetAllGameConfigRsp.config_list.get()) {
                        if (yesGameInfoOuterClass$GameConfigInfo != null && yesGameInfoOuterClass$GameConfigInfo.has() && yesGameInfoOuterClass$GameConfigInfo.game_id.has()) {
                            GameConfigManager.this.f376746b.put(Integer.valueOf(yesGameInfoOuterClass$GameConfigInfo.game_id.get()), yesGameInfoOuterClass$GameConfigInfo);
                            GameConfigInfoEntity gameConfigInfoEntity = new GameConfigInfoEntity();
                            gameConfigInfoEntity.saveInfo(yesGameInfoOuterClass$GameConfigInfo);
                            arrayList.add(gameConfigInfoEntity);
                        }
                    }
                    GameConfigManager.this.f();
                    if (arrayList.size() > 0) {
                        w.a(new Runnable() { // from class: com.tencent.timi.game.component.gamecore.impl.config.GameConfigManager.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                YesDataBaseHelper.f().i(arrayList);
                            }
                        });
                    }
                }
            }
        });
    }

    public HashMap<Integer, Integer> h() {
        return this.f376745a;
    }

    public YesGameInfoOuterClass$GameConfigInfo i(int i3) {
        YesGameInfoOuterClass$GameConfigInfo yesGameInfoOuterClass$GameConfigInfo = this.f376746b.get(Integer.valueOf(i3));
        if (yesGameInfoOuterClass$GameConfigInfo == null) {
            YesGameInfoOuterClass$GameConfigInfo yesGameInfoOuterClass$GameConfigInfo2 = new YesGameInfoOuterClass$GameConfigInfo();
            yesGameInfoOuterClass$GameConfigInfo2.game_id.set(i3);
            return yesGameInfoOuterClass$GameConfigInfo2;
        }
        return yesGameInfoOuterClass$GameConfigInfo;
    }

    public void k(i iVar) {
        l.i("GameConfigManager", "initCache, map.size = " + this.f376746b.size() + ", " + iVar);
        if (this.f376746b.size() == 0) {
            Iterator<Map.Entry<Integer, Integer>> it = f376744e.entrySet().iterator();
            while (it.hasNext()) {
                int intValue = it.next().getKey().intValue();
                YesGameInfoOuterClass$GameConfigInfo a16 = a.a(intValue);
                if (a16 != null) {
                    this.f376746b.put(Integer.valueOf(intValue), a16);
                }
            }
            l(iVar);
            return;
        }
        if (iVar != null) {
            iVar.a();
        }
    }

    public void n(int i3, YesGameInfoOuterClass$GameConfigInfo yesGameInfoOuterClass$GameConfigInfo) {
        if (yesGameInfoOuterClass$GameConfigInfo != null) {
            this.f376746b.put(Integer.valueOf(i3), yesGameInfoOuterClass$GameConfigInfo);
            f();
        }
        m(yesGameInfoOuterClass$GameConfigInfo);
    }
}
