package com.tencent.qqnt.emotion.ipc.proxy;

import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmojiManagerServiceProxy;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.emotion.api.IEmojiManagerService;
import com.tencent.qqnt.emotion.api.INTEmoticonPanelIpcService;
import eipc.EIPCResult;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes24.dex */
public class b extends a<IEmojiManagerService> {
    static IPatchRedirector $redirector_;

    public b(BaseQQAppInterface baseQQAppInterface) {
        super(baseQQAppInterface, IEmojiManagerService.class);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseQQAppInterface);
        }
    }

    public static EIPCResult a(AppRuntime appRuntime, String str, Bundle bundle, int i3) {
        if (EmojiManagerServiceProxy.ACTION_EMOJIMANAGER_TASKSFILEEXISTS.equals(str)) {
            return d((BaseQQAppInterface) appRuntime, str, bundle, i3);
        }
        if (EmojiManagerServiceProxy.ACTION_EMOJIMANAGER_DOWNLOADAIOEMOTICON.equals(str)) {
            return c((BaseQQAppInterface) appRuntime, str, bundle, i3);
        }
        return null;
    }

    public static EIPCResult c(BaseQQAppInterface baseQQAppInterface, String str, Bundle bundle, int i3) {
        boolean downloadAIOEmoticon = ((IEmojiManagerService) baseQQAppInterface.getRuntimeService(IEmojiManagerService.class)).downloadAIOEmoticon((Emoticon) bundle.getSerializable(EmojiManagerServiceProxy.EMOTICON_PACKAGE), bundle.getInt(EmojiManagerServiceProxy.EMOTICON_TASKS));
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean(EmojiManagerServiceProxy.EMOTICON_TASKS_DOWNLOAD, downloadAIOEmoticon);
        return EIPCResult.createSuccessResult(bundle2);
    }

    public static EIPCResult d(BaseQQAppInterface baseQQAppInterface, String str, Bundle bundle, int i3) {
        boolean tasksFileExists = ((IEmojiManagerService) baseQQAppInterface.getRuntimeService(IEmojiManagerService.class)).tasksFileExists((Emoticon) bundle.getSerializable(EmojiManagerServiceProxy.EMOTICON_PACKAGE), bundle.getInt(EmojiManagerServiceProxy.EMOTICON_TASKS));
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean(EmojiManagerServiceProxy.EMOTICON_TASKS_FILEEXISTS, tasksFileExists);
        return EIPCResult.createSuccessResult(bundle2);
    }

    public boolean b(Emoticon emoticon, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) emoticon, i3)).booleanValue();
        }
        T t16 = this.f356288b;
        if (t16 != 0) {
            return ((IEmojiManagerService) t16).downloadAIOEmoticon(emoticon, i3);
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable(EmojiManagerServiceProxy.EMOTICON_PACKAGE, emoticon);
        bundle.putInt(EmojiManagerServiceProxy.EMOTICON_TASKS, i3);
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), INTEmoticonPanelIpcService.NT_EMOTICON_MAINPANEL_IPC_NAME, EmojiManagerServiceProxy.ACTION_EMOJIMANAGER_DOWNLOADAIOEMOTICON, bundle);
        if (callServer != null && callServer.isSuccess()) {
            return callServer.data.getBoolean(EmojiManagerServiceProxy.EMOTICON_TASKS_DOWNLOAD);
        }
        if (QLog.isDevelopLevel()) {
            QLog.e(EmojiManagerServiceProxy.TAG, 4, "downloadAIOEmoticon fail.");
            return false;
        }
        return false;
    }

    public boolean e(Emoticon emoticon, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) emoticon, i3)).booleanValue();
        }
        T t16 = this.f356288b;
        if (t16 != 0) {
            return ((IEmojiManagerService) t16).tasksFileExists(emoticon, i3);
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable(EmojiManagerServiceProxy.EMOTICON_PACKAGE, emoticon);
        bundle.putInt(EmojiManagerServiceProxy.EMOTICON_TASKS, i3);
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), INTEmoticonPanelIpcService.NT_EMOTICON_MAINPANEL_IPC_NAME, EmojiManagerServiceProxy.ACTION_EMOJIMANAGER_TASKSFILEEXISTS, bundle);
        if (callServer != null && callServer.isSuccess()) {
            return callServer.data.getBoolean(EmojiManagerServiceProxy.EMOTICON_TASKS_FILEEXISTS);
        }
        if (QLog.isDevelopLevel()) {
            QLog.e(EmojiManagerServiceProxy.TAG, 4, "tasksFileExists fail.");
            return false;
        }
        return false;
    }
}
