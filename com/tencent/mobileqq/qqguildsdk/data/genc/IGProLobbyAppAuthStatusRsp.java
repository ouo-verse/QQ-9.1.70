package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

/* loaded from: classes17.dex */
public interface IGProLobbyAppAuthStatusRsp extends Serializable {
    String getAuthCode();

    int getAuthStatus();

    String getOpenId();

    String toString();
}
