package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import com.tencent.mobileqq.emoticonview.ipc.proxy.AbsEmoRuntimeServiceProxy;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;

/* loaded from: classes12.dex */
public interface IEmoticonMainPanelApp {
    String getAccount();

    <T extends AppRuntime> T getAppRuntime();

    <T extends Context> T getApplication();

    Object getBusinessHandler(String str);

    String getCurrentAccountUin();

    String getCurrentUin();

    <T extends IMqqHandlerProxy> T getHandler(Class cls);

    Object getManager(int i3);

    <T extends IQQMessageFacadeProxy> T getMessageFacade();

    <T extends AppRuntime> T getQQAppInterface();

    AbsEmoRuntimeServiceProxy<? extends IRuntimeService> getRuntimeService(Class cls);

    <T extends IRuntimeService> T getService(Class<T> cls);
}
