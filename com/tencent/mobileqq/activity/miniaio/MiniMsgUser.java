package com.tencent.mobileqq.activity.miniaio;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.IFeatureServiceProxy;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MiniMsgUser implements Handler.Callback, View.OnClickListener {
    static IPatchRedirector $redirector_ = null;
    private static final String ASYNC_TOGGLE = "mini_msg_user_async_toggle";
    public static final int MSG_HIDE_ENTRY = 4;
    public static final int MSG_HIDE_UNREAD = 3;
    public static final int MSG_SHOW_ENTRY = 0;
    public static final int MSG_UPDATE_UNREAD_GET = 2;
    public static final int MSG_UPDATE_UNREAD_SYNC = 1;
    public static final String TAG = "mini_msg_User";
    private Activity mActivity;
    private boolean mAsyncToggle;
    private boolean mIsAttach;
    private AtomicBoolean mIsDetroy;
    private MiniMsgUserParam mMiniMsgUserParam;
    private Handler mSubHandler;
    private MqqHandler mUIHandler;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface IMiniMsgActionCallback {
        void onFromMiniAIOToAIO();

        void onGoToConversation();

        void onOpenMiniAIOCallback();
    }

    public MiniMsgUser(Activity activity, MiniMsgUserParam miniMsgUserParam) {
        int i3;
        int i16;
        f businessInfo;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity, (Object) miniMsgUserParam);
            return;
        }
        this.mAsyncToggle = false;
        this.mIsDetroy = new AtomicBoolean();
        this.mActivity = activity;
        this.mMiniMsgUserParam = miniMsgUserParam;
        int i18 = miniMsgUserParam.accessType;
        if (i18 == 0) {
            int i19 = miniMsgUserParam.filterMsgType;
            int i26 = miniMsgUserParam.positionX;
            int i27 = miniMsgUserParam.positionY;
            int i28 = miniMsgUserParam.colorType;
            int i29 = miniMsgUserParam.entryType;
            int i36 = miniMsgUserParam.businessName;
            int i37 = miniMsgUserParam.contentIconResId;
            if (i29 == 0 && (businessInfo = MiniMsgIPCClient.getInstance().getBusinessInfo(i36)) != null && businessInfo.f183482c && (i17 = businessInfo.f183484e) > 0) {
                i16 = businessInfo.f183485f;
                i3 = i17;
            } else {
                i3 = i26;
                i16 = i27;
            }
            this.mMiniMsgUserParam.unreadCallback = new e(activity, i19, i29, i28, i37, i3, i16, this);
        } else if (i18 == 1) {
            View view = miniMsgUserParam.entryView;
            if (view != null) {
                view.setOnClickListener(this);
            }
            MiniMsgUserParam miniMsgUserParam2 = this.mMiniMsgUserParam;
            if (miniMsgUserParam2.unreadCallback == null) {
                miniMsgUserParam2.unreadCallback = new d(miniMsgUserParam2.entryView, miniMsgUserParam2.unreadView);
            }
        }
        this.mUIHandler = new MqqHandler(Looper.getMainLooper(), this);
        this.mSubHandler = new Handler(ThreadManagerV2.getQQCommonThreadLooper());
        this.mAsyncToggle = ((IFeatureServiceProxy) QRoute.api(IFeatureServiceProxy.class)).isFeatureSwitchOn(ASYNC_TOGGLE);
    }

    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        this.mIsDetroy.set(true);
        this.mMiniMsgUserParam.unreadCallback.destroy();
        this.mUIHandler.removeCallbacksAndMessages(null);
        this.mActivity = null;
    }

    public IMiniMsgActionCallback getActionCallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (IMiniMsgActionCallback) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        MiniMsgUserParam miniMsgUserParam = this.mMiniMsgUserParam;
        if (miniMsgUserParam != null) {
            return miniMsgUserParam.actionCallback;
        }
        return null;
    }

    public MiniMsgUserParam getParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (MiniMsgUserParam) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.mMiniMsgUserParam;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        MiniMsgUserParam miniMsgUserParam;
        IMiniMsgUnreadCallback iMiniMsgUnreadCallback;
        byte b16;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) message)).booleanValue();
        }
        int i16 = 0;
        boolean z16 = false;
        i16 = 0;
        if (this.mIsDetroy.get()) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "msg_what = " + message.what);
        }
        int i17 = message.arg1;
        f businessInfo = MiniMsgIPCClient.getInstance().getBusinessInfo(this.mMiniMsgUserParam.businessName);
        if (businessInfo == null || (iMiniMsgUnreadCallback = (miniMsgUserParam = this.mMiniMsgUserParam).unreadCallback) == null) {
            return false;
        }
        if (miniMsgUserParam.accessType == 0 && ((i3 = miniMsgUserParam.entryType) == 0 || i3 == 1)) {
            b16 = true;
        } else {
            b16 = false;
        }
        int i18 = message.what;
        if (i18 != 0) {
            if (i18 != 1) {
                if (i18 != 2) {
                    if (i18 != 3) {
                        if (i18 == 4) {
                            businessInfo.f183482c = false;
                            businessInfo.f183481b = false;
                            this.mIsAttach = false;
                            businessInfo.f183483d = 0;
                            iMiniMsgUnreadCallback.hide();
                        }
                    } else {
                        iMiniMsgUnreadCallback.hideUnread();
                        businessInfo.f183481b = false;
                    }
                } else {
                    boolean z17 = !businessInfo.f183481b;
                    if (b16 == false) {
                        if (i17 > 0) {
                            businessInfo.f183483d = i17;
                            return true;
                        }
                    } else {
                        z16 = z17;
                    }
                    iMiniMsgUnreadCallback.updateUnreadCount(i17, z16);
                    businessInfo.f183483d = i17;
                }
            } else {
                if (b16 != false && !businessInfo.f183482c) {
                    boolean show = iMiniMsgUnreadCallback.show(i17);
                    this.mIsAttach = show;
                    businessInfo.f183482c = show;
                } else {
                    iMiniMsgUnreadCallback.updateUnreadCount(i17, false);
                }
                businessInfo.f183481b = true;
                businessInfo.f183483d = i17;
            }
        } else {
            if (businessInfo.f183482c && businessInfo.f183481b) {
                i16 = businessInfo.f183483d;
            }
            boolean show2 = iMiniMsgUnreadCallback.show(i16);
            this.mIsAttach = show2;
            businessInfo.f183482c = show2;
        }
        return true;
    }

    public void hideEntry() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            if (this.mIsDetroy.get()) {
                return;
            }
            this.mUIHandler.obtainMessage(4).sendToTarget();
        }
    }

    public void hideUnread() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.mUIHandler.obtainMessage(3).sendToTarget();
        }
    }

    public void notifyFromMiniAIOToAIO() {
        IMiniMsgActionCallback iMiniMsgActionCallback;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        MiniMsgUserParam miniMsgUserParam = this.mMiniMsgUserParam;
        if (miniMsgUserParam != null && (iMiniMsgActionCallback = miniMsgUserParam.actionCallback) != null) {
            iMiniMsgActionCallback.onFromMiniAIOToAIO();
        }
    }

    public void notifyGoToConversation() {
        IMiniMsgActionCallback iMiniMsgActionCallback;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        MiniMsgUserParam miniMsgUserParam = this.mMiniMsgUserParam;
        if (miniMsgUserParam != null && (iMiniMsgActionCallback = miniMsgUserParam.actionCallback) != null) {
            iMiniMsgActionCallback.onGoToConversation();
        }
    }

    public void onBackground() {
        f businessInfo;
        int[] i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        MiniMsgUserParam miniMsgUserParam = this.mMiniMsgUserParam;
        if (miniMsgUserParam != null) {
            if (miniMsgUserParam.accessType == 0 && miniMsgUserParam.entryType == 0 && (businessInfo = MiniMsgIPCClient.getInstance().getBusinessInfo(this.mMiniMsgUserParam.businessName)) != null && (i3 = ((e) this.mMiniMsgUserParam.unreadCallback).i()) != null) {
                businessInfo.f183484e = i3[0];
                businessInfo.f183485f = i3[1];
            }
            if (this.mAsyncToggle) {
                this.mSubHandler.post(new Runnable() { // from class: com.tencent.mobileqq.activity.miniaio.MiniMsgUser.3
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MiniMsgUser.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            MiniMsgIPCClient.getInstance();
                            MiniMsgIPCClient.onProcessBackground(MiniMsgUser.this.mMiniMsgUserParam.businessName);
                        }
                    }
                });
            } else {
                MiniMsgIPCClient.getInstance();
                MiniMsgIPCClient.onProcessBackground(this.mMiniMsgUserParam.businessName);
            }
            MiniMsgIPCClient.getInstance().removetMiniUser(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) view);
        } else {
            MiniMsgUserParam miniMsgUserParam = this.mMiniMsgUserParam;
            if (miniMsgUserParam != null) {
                IMiniMsgActionCallback iMiniMsgActionCallback = miniMsgUserParam.actionCallback;
                if (iMiniMsgActionCallback != null) {
                    iMiniMsgActionCallback.onOpenMiniAIOCallback();
                }
                Intent intent = new Intent();
                intent.putExtra(MiniChatConstants.KEY_MINI_NEED_UPDATE_UNREAD, true);
                intent.putExtra(MiniChatConstants.KEY_MINI_MSGTAB_BUSINAME, this.mMiniMsgUserParam.businessName);
                intent.putExtra(MiniChatConstants.KEY_MINI_MSGTAB_TYPE, this.mMiniMsgUserParam.filterMsgType);
                intent.putExtra(MiniChatConstants.KEY_MINI_MSGTAB_NEED_FULL_SCREEN, this.mMiniMsgUserParam.isNeedFullScreen);
                intent.putExtra(MiniChatConstants.KEY_MINI_MSGTAB_ISNEED_BACK_CONVERSATION, this.mMiniMsgUserParam.isNeedBackConversation);
                intent.putExtra(MiniChatConstants.KEY_MINI_MSGTAB_CLOSE_WHEN_CHAT_CLOSE, true);
                MiniMsgUserParam miniMsgUserParam2 = this.mMiniMsgUserParam;
                if (miniMsgUserParam2.isNeedBackConversation) {
                    intent.putExtra(MiniChatConstants.KEY_MINI_MSGTAB_BACK_PENDING_INTENT, miniMsgUserParam2.backConversationIntent);
                }
                MiniChatActivity.W2(this.mActivity, intent, this.mMiniMsgUserParam.requestCode);
                hideUnread();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void onForeground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        if (this.mMiniMsgUserParam != null) {
            MiniMsgIPCClient.getInstance();
            MiniMsgIPCClient.register(this.mMiniMsgUserParam.businessName, BaseApplicationImpl.getApplication().getQQProcessName());
            MiniMsgIPCClient.getInstance().setMiniUser(this);
            if (this.mAsyncToggle) {
                this.mSubHandler.post(new Runnable() { // from class: com.tencent.mobileqq.activity.miniaio.MiniMsgUser.2
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MiniMsgUser.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        MiniMsgIPCClient.getInstance().syncGetUnread();
                        MiniMsgIPCClient.getInstance();
                        MiniMsgIPCClient.onProcessForeGround(MiniMsgUser.this.mMiniMsgUserParam.businessName);
                    }
                });
                return;
            }
            MiniMsgIPCClient.getInstance().syncGetUnread();
            MiniMsgIPCClient.getInstance();
            MiniMsgIPCClient.onProcessForeGround(this.mMiniMsgUserParam.businessName);
        }
    }

    public void showEntry() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            if (this.mIsDetroy.get()) {
                return;
            }
            this.mUIHandler.obtainMessage(0).sendToTarget();
        }
    }

    public void showOnFirst() {
        f businessInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        MiniMsgUserParam miniMsgUserParam = this.mMiniMsgUserParam;
        if (miniMsgUserParam != null && miniMsgUserParam.accessType == 0 && (businessInfo = MiniMsgIPCClient.getInstance().getBusinessInfo(this.mMiniMsgUserParam.businessName)) != null && businessInfo.f183482c && !this.mIsAttach) {
            this.mUIHandler.obtainMessage(0).sendToTarget();
            if (this.mAsyncToggle) {
                this.mSubHandler.post(new Runnable() { // from class: com.tencent.mobileqq.activity.miniaio.MiniMsgUser.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MiniMsgUser.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            MiniMsgIPCClient.getInstance().syncGetUnread();
                        }
                    }
                });
            } else {
                MiniMsgIPCClient.getInstance().syncGetUnread();
            }
        }
    }

    public void updateUnreadCountGet(int i3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        if (this.mIsDetroy.get()) {
            return;
        }
        if (i3 == 0) {
            MiniMsgUserParam miniMsgUserParam = this.mMiniMsgUserParam;
            if (miniMsgUserParam.accessType == 0) {
                int i17 = miniMsgUserParam.entryType;
                if (i17 == 0) {
                    i16 = 4;
                } else if (i17 == 1) {
                    i16 = 3;
                }
                Message obtainMessage = this.mUIHandler.obtainMessage(i16);
                obtainMessage.arg1 = i3;
                obtainMessage.sendToTarget();
            }
        }
        i16 = 2;
        Message obtainMessage2 = this.mUIHandler.obtainMessage(i16);
        obtainMessage2.arg1 = i3;
        obtainMessage2.sendToTarget();
    }

    public void updateUnreadCountSync(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 4;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        if (this.mIsDetroy.get()) {
            return;
        }
        if (i3 == 0) {
            MiniMsgUserParam miniMsgUserParam = this.mMiniMsgUserParam;
            if (miniMsgUserParam.accessType == 0) {
                int i17 = miniMsgUserParam.entryType;
                if (i17 != 0) {
                    if (i17 == 1) {
                        i16 = 3;
                    }
                }
                Message obtainMessage = this.mUIHandler.obtainMessage(i16);
                obtainMessage.arg1 = i3;
                obtainMessage.sendToTarget();
            }
        }
        i16 = 1;
        Message obtainMessage2 = this.mUIHandler.obtainMessage(i16);
        obtainMessage2.arg1 = i3;
        obtainMessage2.sendToTarget();
    }

    public void updateWhenBackFromMiniChat(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
            return;
        }
        if (i3 == 0) {
            MiniMsgUserParam miniMsgUserParam = this.mMiniMsgUserParam;
            if (miniMsgUserParam.accessType == 0 && miniMsgUserParam.entryType == 0) {
                this.mUIHandler.obtainMessage(4).sendToTarget();
            }
        }
    }

    public void updateWhenConfigChanged(Configuration configuration, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, configuration, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (this.mIsDetroy.get()) {
            return;
        }
        MiniMsgUserParam miniMsgUserParam = this.mMiniMsgUserParam;
        miniMsgUserParam.positionX = i3;
        miniMsgUserParam.positionY = i16;
        IMiniMsgUnreadCallback iMiniMsgUnreadCallback = miniMsgUserParam.unreadCallback;
        if (iMiniMsgUnreadCallback instanceof e) {
            ((e) iMiniMsgUnreadCallback).l(configuration, i3, i16);
        }
    }

    public static void clear() {
    }
}
