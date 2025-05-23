package com.tencent.mobileqq.activity.miniaio;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes10.dex */
public class MiniMsgIPCClient extends QIPCModule {
    static IPatchRedirector $redirector_ = null;
    public static final String MODULE_NAME = "mini_msg_client_module";
    public static final String TAG = "mini_msg_IPCClient";
    private static MiniMsgIPCClient sInstance;
    private ConcurrentHashMap<Integer, f> mBusinessInfoMap;
    private MiniMsgUser mMiniUser;

    public MiniMsgIPCClient(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        } else {
            this.mBusinessInfoMap = new ConcurrentHashMap<>();
        }
    }

    public static MiniMsgIPCClient getInstance() {
        if (sInstance == null) {
            synchronized (MiniMsgIPCClient.class) {
                if (sInstance == null) {
                    sInstance = new MiniMsgIPCClient(MODULE_NAME);
                }
            }
        }
        return sInstance;
    }

    public static Bundle getModuleBundle() {
        Bundle bundle = new Bundle();
        bundle.putString(MiniChatConstants.PARAM_PROC_NAME, BaseApplicationImpl.getApplication().getQQProcessName());
        bundle.putString(MiniChatConstants.PARAM_PROC_MODULENAME, MODULE_NAME);
        return bundle;
    }

    private void notifyShowWindow() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.mobileqq.activity.miniaio.MiniMsgIPCClient.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) MiniMsgIPCClient.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    com.tencent.mobileqq.intervideo.yiqikan.g.k().s(BaseApplication.getContext());
                }
            }
        });
    }

    public static void onProcessBackground(int i3) {
        Bundle moduleBundle = getModuleBundle();
        moduleBundle.putInt(MiniChatConstants.PARAM_PROC_BUSINAME, i3);
        QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", MiniChatConstants.CMD_PROC_BACKGROUND, moduleBundle, null);
    }

    public static void onProcessForeGround(int i3) {
        Bundle moduleBundle = getModuleBundle();
        moduleBundle.putInt(MiniChatConstants.PARAM_PROC_BUSINAME, i3);
        QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", MiniChatConstants.CMD_PROC_FOREGROUND, moduleBundle, null);
    }

    public static void register() {
    }

    public static void unregister() {
    }

    public void clearBusiness(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
            return;
        }
        this.mBusinessInfoMap.remove(Integer.valueOf(i3));
        Bundle moduleBundle = getModuleBundle();
        moduleBundle.putInt(MiniChatConstants.PARAM_CMD_BUSIID, i3);
        QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", MiniChatConstants.CMD_MINI_CLEAR_BUSINESS, moduleBundle, null);
    }

    public f getBusinessInfo(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (f) iPatchRedirector.redirect((short) 7, (Object) this, i3);
        }
        return this.mBusinessInfoMap.get(Integer.valueOf(i3));
    }

    public MiniMsgUser getMiniUser() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (MiniMsgUser) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mMiniUser;
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 2, this, str, bundle, Integer.valueOf(i3));
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onCall.action = " + str);
        }
        if (MiniChatConstants.ACTION_SYNC_UNREADCOUNT.equals(str)) {
            int i16 = bundle.getInt(MiniChatConstants.PARAM_PROC_BADGE_COUNT);
            synchronized (MiniMsgIPCClient.class) {
                MiniMsgUser miniMsgUser = this.mMiniUser;
                if (miniMsgUser != null) {
                    miniMsgUser.updateUnreadCountSync(i16);
                }
            }
            return null;
        }
        if (MiniChatConstants.ACTION_MSG_TAB_BACK_REFRESH.equals(str)) {
            int i17 = bundle.getInt(MiniChatConstants.PARAM_PROC_BADGE_COUNT);
            synchronized (MiniMsgIPCClient.class) {
                MiniMsgUser miniMsgUser2 = this.mMiniUser;
                if (miniMsgUser2 != null) {
                    miniMsgUser2.updateWhenBackFromMiniChat(i17);
                }
            }
            return null;
        }
        if (MiniChatConstants.ACTION_GET_UNREAD.equals(str)) {
            int i18 = bundle.getInt(MiniChatConstants.PARAM_PROC_BADGE_COUNT);
            synchronized (MiniMsgIPCClient.class) {
                MiniMsgUser miniMsgUser3 = this.mMiniUser;
                if (miniMsgUser3 != null) {
                    miniMsgUser3.updateUnreadCountGet(i18);
                }
            }
            return null;
        }
        if (MiniChatConstants.ACTION_MINI_MSGTAB_NOTIFY_TO_CONVERSATION.equals(str)) {
            synchronized (MiniMsgIPCClient.class) {
                notifyShowWindow();
                MiniMsgUser miniMsgUser4 = this.mMiniUser;
                if (miniMsgUser4 != null) {
                    miniMsgUser4.notifyGoToConversation();
                }
            }
            return null;
        }
        if (MiniChatConstants.ACTION_MINI_AIO_TO_AIO.equals(str)) {
            synchronized (MiniMsgIPCClient.class) {
                notifyShowWindow();
                MiniMsgUser miniMsgUser5 = this.mMiniUser;
                if (miniMsgUser5 != null) {
                    miniMsgUser5.notifyFromMiniAIOToAIO();
                }
            }
            return null;
        }
        if (MiniChatConstants.ACTION_MINI_START_MINI_AIO.equals(str)) {
            MiniChatActivity.I2(bundle);
            return null;
        }
        return null;
    }

    public void removetMiniUser(MiniMsgUser miniMsgUser) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) miniMsgUser);
        } else if (this.mMiniUser == miniMsgUser) {
            synchronized (MiniMsgIPCClient.class) {
                if (this.mMiniUser == miniMsgUser) {
                    this.mMiniUser = null;
                }
            }
        }
    }

    public void setMiniUser(MiniMsgUser miniMsgUser) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) miniMsgUser);
        } else if (this.mMiniUser != miniMsgUser) {
            synchronized (MiniMsgIPCClient.class) {
                this.mMiniUser = miniMsgUser;
            }
        }
    }

    public void syncGetUnread() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", MiniChatConstants.CMD_GET_UNREAD, getModuleBundle(), null);
        }
    }

    public static void register(int i3, String str) {
        ConcurrentHashMap<Integer, f> concurrentHashMap = getInstance().mBusinessInfoMap;
        if (concurrentHashMap.containsKey(Integer.valueOf(i3))) {
            return;
        }
        f fVar = new f();
        fVar.f183480a = i3;
        concurrentHashMap.put(Integer.valueOf(i3), fVar);
        try {
            QIPCClientHelper.getInstance().register(getInstance());
        } catch (Exception e16) {
            QLog.e(TAG, 1, "register ipc module error.", e16);
        }
    }

    public static void unregister(String str, String str2) {
        ConcurrentHashMap<Integer, f> concurrentHashMap = getInstance().mBusinessInfoMap;
        if (concurrentHashMap.containsKey(str)) {
            concurrentHashMap.remove(str);
        }
    }
}
