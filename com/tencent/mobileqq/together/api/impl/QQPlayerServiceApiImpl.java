package com.tencent.mobileqq.together.api.impl;

import com.tencent.mobileqq.listentogether.player.QQMusicPlayService;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.together.api.IQQPlayerServiceApi;

/* loaded from: classes9.dex */
public class QQPlayerServiceApiImpl implements IQQPlayerServiceApi {
    @Override // com.tencent.mobileqq.together.api.IQQPlayerServiceApi
    public String getQQPlayerServiceToken() {
        return QQPlayerService.o0();
    }

    @Override // com.tencent.mobileqq.together.api.IQQPlayerServiceApi
    public boolean isListeningTogether() {
        if (QQMusicPlayService.K() && QQMusicPlayService.C() != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.together.api.IQQPlayerServiceApi
    public boolean isPlayStateCompletion(int i3) {
        if (i3 == 8) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.together.api.IQQPlayerServiceApi
    public boolean isPlayStateError(int i3) {
        if (i3 != 5 && i3 != 7) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.together.api.IQQPlayerServiceApi
    public boolean isPlayStatePause(int i3) {
        if (i3 == 3) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.together.api.IQQPlayerServiceApi
    public boolean isPlayStatePlaying(int i3) {
        if (i3 == 2) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.together.api.IQQPlayerServiceApi
    public boolean isPlayStateStop(int i3) {
        if (i3 == 4) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.together.api.IQQPlayerServiceApi
    public boolean isQQPlayServicePlaying() {
        if (QQPlayerService.s0() && QQPlayerService.b0() != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.together.api.IQQPlayerServiceApi
    public boolean isStateCompletion(int i3) {
        if (i3 == 8) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.together.api.IQQPlayerServiceApi
    public boolean isStateError(int i3) {
        if (i3 == 5) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.together.api.IQQPlayerServiceApi
    public boolean isStatePause(int i3) {
        if (i3 == 3) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.together.api.IQQPlayerServiceApi
    public boolean isStatePlaying(int i3) {
        if (i3 == 2) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.together.api.IQQPlayerServiceApi
    public boolean isStateStop(int i3) {
        if (i3 == 4) {
            return true;
        }
        return false;
    }
}
