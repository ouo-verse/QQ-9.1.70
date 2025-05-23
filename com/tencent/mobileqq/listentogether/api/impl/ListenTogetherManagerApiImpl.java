package com.tencent.mobileqq.listentogether.api.impl;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.api.IListenTogetherManagerApi;
import com.tencent.mobileqq.listentogether.k;
import com.tencent.mobileqq.listentogether.lyrics.ProfileMusicBoxController;
import com.tencent.mobileqq.music.SongInfo;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016J\u001a\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\u0012\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u0010\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\u001a\u0010\u0018\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\b\u001a\u00020\u0017H\u0016R\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u00198BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/listentogether/api/impl/ListenTogetherManagerApiImpl;", "Lcom/tencent/mobileqq/listentogether/api/IListenTogetherManagerApi;", "Ljava/lang/Class;", "Lmqq/manager/Manager;", "getListenTogetherManager", "", "type", "", "uin", "", "isListenTogetherOpen", "isJoinSession", "Lorg/json/JSONObject;", "jsonObject", "", "startAioShareTogetherListen", "checkAndShowAioShareMusic", "Lcom/tencent/mobileqq/listentogether/k;", "change", "setPlayChange", "pauseMusic", "Lcom/tencent/mobileqq/music/SongInfo;", "song", "", "shouldPlayMusic", "Lcom/tencent/mobileqq/listentogether/ListenTogetherManager;", "getManager", "()Lcom/tencent/mobileqq/listentogether/ListenTogetherManager;", "manager", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class ListenTogetherManagerApiImpl implements IListenTogetherManagerApi {
    private final ListenTogetherManager getManager() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
        if (qQAppInterface == null) {
            return null;
        }
        return ListenTogetherManager.J(qQAppInterface);
    }

    @Override // com.tencent.mobileqq.listentogether.api.IListenTogetherManagerApi
    public void checkAndShowAioShareMusic(JSONObject jsonObject) {
        ListenTogetherManager manager = getManager();
        if (manager != null) {
            manager.F(jsonObject);
        }
    }

    @Override // com.tencent.mobileqq.listentogether.api.IListenTogetherManagerApi
    public Class<? extends Manager> getListenTogetherManager() {
        return ListenTogetherManager.class;
    }

    @Override // com.tencent.mobileqq.listentogether.api.IListenTogetherManagerApi
    public boolean isJoinSession() {
        ListenTogetherManager manager = getManager();
        if (manager != null) {
            return manager.f0();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.listentogether.api.IListenTogetherManagerApi
    public boolean isListenTogetherOpen(int type, String uin) {
        ListenTogetherManager manager = getManager();
        if (manager != null) {
            return manager.g0(type, uin);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.listentogether.api.IListenTogetherManagerApi
    public void pauseMusic() {
        ProfileMusicBoxController W;
        ListenTogetherManager manager = getManager();
        if (manager == null || (W = manager.W()) == null) {
            return;
        }
        W.l0();
    }

    @Override // com.tencent.mobileqq.listentogether.api.IListenTogetherManagerApi
    public void setPlayChange(k change) {
        ProfileMusicBoxController W;
        ListenTogetherManager manager = getManager();
        if (manager == null || (W = manager.W()) == null) {
            return;
        }
        W.s0(change);
    }

    @Override // com.tencent.mobileqq.listentogether.api.IListenTogetherManagerApi
    public void shouldPlayMusic(SongInfo song, long uin) {
        ProfileMusicBoxController W;
        ListenTogetherManager manager = getManager();
        if (manager == null || (W = manager.W()) == null) {
            return;
        }
        W.t0(uin, song);
    }

    @Override // com.tencent.mobileqq.listentogether.api.IListenTogetherManagerApi
    public void startAioShareTogetherListen(JSONObject jsonObject) {
        ListenTogetherManager manager = getManager();
        if (manager != null) {
            manager.C1(jsonObject);
        }
    }
}
