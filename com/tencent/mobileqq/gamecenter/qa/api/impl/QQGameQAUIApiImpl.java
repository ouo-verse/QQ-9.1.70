package com.tencent.mobileqq.gamecenter.qa.api.impl;

import androidx.collection.SparseArrayCompat;
import com.tencent.aio.api.factory.g;
import com.tencent.mobileqq.gamecenter.qa.api.IQQGameQAUIApi;
import com.tencent.mobileqq.gamecenter.qa.view.GameQAUI;
import com.tencent.mobileqq.gamecenter.qa.view.i;
import sd1.e;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QQGameQAUIApiImpl implements IQQGameQAUIApi {
    private static final String TAG = "QQGameQAUIApiImpl";
    private final SparseArrayCompat<GameQAUI> mQAUIs = new SparseArrayCompat<>();
    private int mCurrPieSeq = 0;

    @Override // com.tencent.mobileqq.gamecenter.qa.api.IQQGameQAUIApi
    public void bindQAUI(int i3) {
        GameQAUI gameQAUI = getGameQAUI(i3);
        if (gameQAUI == null) {
            return;
        }
        gameQAUI.N();
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.api.IQQGameQAUIApi
    public g createGameQAAioFactory() {
        return new rd1.a();
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.api.IQQGameQAUIApi
    public String getAioFactoryName() {
        return rd1.a.class.getName();
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.api.IQQGameQAUIApi
    public int getAppid(int i3) {
        GameQAUI gameQAUI = getGameQAUI(i3);
        if (gameQAUI == null) {
            return 0;
        }
        return gameQAUI.V();
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.api.IQQGameQAUIApi
    public int getChatListTopMargin(int i3) {
        GameQAUI gameQAUI = getGameQAUI(i3);
        if (gameQAUI == null) {
            return 0;
        }
        return gameQAUI.Y();
    }

    public GameQAUI getGameQAUI(int i3) {
        return this.mQAUIs.get(i3);
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.api.IQQGameQAUIApi
    public Class getJumpParserClass() {
        return i.class;
    }

    public GameQAUI getOrCreateGameQAUI(int i3) {
        GameQAUI gameQAUI = this.mQAUIs.get(i3);
        if (gameQAUI == null) {
            GameQAUI gameQAUI2 = new GameQAUI(null);
            this.mQAUIs.put(i3, gameQAUI2);
            return gameQAUI2;
        }
        return gameQAUI;
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.api.IQQGameQAUIApi
    public void onCreate(int i3, e eVar) {
        this.mCurrPieSeq = i3;
        getOrCreateGameQAUI(i3).M(eVar);
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.api.IQQGameQAUIApi
    public void onDestroy(int i3) {
        GameQAUI gameQAUI = getGameQAUI(i3);
        if (gameQAUI == null) {
            return;
        }
        gameQAUI.u0();
        this.mQAUIs.remove(i3);
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.api.IQQGameQAUIApi
    public void onInputPanelChanged(int i3, boolean z16) {
        GameQAUI gameQAUI = getGameQAUI(i3);
        if (gameQAUI == null) {
            return;
        }
        gameQAUI.w0(z16);
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.api.IQQGameQAUIApi
    public void onPause(int i3) {
        GameQAUI gameQAUI = getGameQAUI(i3);
        if (gameQAUI == null) {
            return;
        }
        gameQAUI.z0();
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.api.IQQGameQAUIApi
    public void onResume(int i3) {
        GameQAUI gameQAUI = getGameQAUI(i3);
        if (gameQAUI == null) {
            return;
        }
        gameQAUI.A0();
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.api.IQQGameQAUIApi
    public void updateSession(int i3, vd1.b bVar) {
        GameQAUI gameQAUI = getGameQAUI(i3);
        if (gameQAUI == null) {
            return;
        }
        gameQAUI.a1(bVar);
    }
}
