package com.tencent.mobileqq.emoticon.api;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.emoticon.IVasEmojiManager;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IVasEmojiManagerService extends QRouteApi {
    IVasEmojiManager createVasEmojiManager(BaseQQAppInterface baseQQAppInterface);

    boolean emoticonPkgNeedUpdate(int i3, int i16);

    boolean isAuthorized(IEmoticonMainPanelApp iEmoticonMainPanelApp, int i3);
}
