package com.tencent.mobileqq.emoticonview.ipc.proxy;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aio.data.AIOContact;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.emosm.api.IEmotionSearchManagerService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.utils.a;
import com.tencent.qqnt.kernel.nativeinterface.EmojiHotPicAioType;
import com.tencent.qqnt.kernel.nativeinterface.EmojiHotPicGetHotWordsReqBody;

/* loaded from: classes12.dex */
public class EmotionSearchManagerServiceProxy extends AbsEmoRuntimeServiceProxy<IEmotionSearchManagerService> {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "EmotionSearchManagerServiceProxy";

    public EmotionSearchManagerServiceProxy(BaseQQAppInterface baseQQAppInterface) {
        super(baseQQAppInterface, IEmotionSearchManagerService.class);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseQQAppInterface);
    }

    private boolean isTempChat(int i3) {
        if (i3 != 100 && i3 != 101) {
            return false;
        }
        return true;
    }

    public AIOContact getAioContact(Context context) {
        AIOContact a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (AIOContact) iPatchRedirector.redirect((short) 15, (Object) this, (Object) context);
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 1, "getAioContact: context is FragmentActivity == " + (context instanceof FragmentActivity));
        }
        if ((context instanceof FragmentActivity) && (a16 = a.f352276a.a((FragmentActivity) context)) != null) {
            return a16;
        }
        return new AIOContact(0, "", "", "");
    }

    public int getAioType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this, i3)).intValue();
        }
        if (isTempChat(i3)) {
            return EmojiHotPicAioType.KTEMPORARY.ordinal();
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        return EmojiHotPicAioType.KUNDEFINED.ordinal();
                    }
                    return EmojiHotPicAioType.KCHANNEL.ordinal();
                }
                return EmojiHotPicAioType.KDISCUSS.ordinal();
            }
            return EmojiHotPicAioType.KGROUP.ordinal();
        }
        return EmojiHotPicAioType.KC2C.ordinal();
    }

    public int getChatType(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this, (Object) context)).intValue();
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "getAioType: context is FragmentActivity == " + (context instanceof FragmentActivity));
        }
        if (!(context instanceof FragmentActivity)) {
            return 0;
        }
        AIOContact a16 = a.f352276a.a((FragmentActivity) context);
        if (a16 == null) {
            QLog.e(TAG, 1, "getAioType: aioContact is invalid!");
            return 0;
        }
        return a16.e();
    }

    public void getHotPicTagsData(EmojiHotPicGetHotWordsReqBody emojiHotPicGetHotWordsReqBody, IEmotionSearchManagerService.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) emojiHotPicGetHotWordsReqBody, (Object) bVar);
            return;
        }
        if (this.manager != 0) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "getHotPicTagsData, sceneType:" + emojiHotPicGetHotWordsReqBody.sceneType + ", nick:" + emojiHotPicGetHotWordsReqBody.composeNick);
            }
            ((IEmotionSearchManagerService) this.manager).getHotPicTagsData(emojiHotPicGetHotWordsReqBody, bVar);
            return;
        }
        QLog.i(TAG, 1, "getHotPicTagsData manager is invalid, return null!");
        bVar.onResult(null);
    }

    public IEmotionSearchManagerService.EmotionSearchTask getLastTask(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (IEmotionSearchManagerService.EmotionSearchTask) iPatchRedirector.redirect((short) 8, (Object) this, z16);
        }
        if (this.manager != 0) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 4, "do getLastTask. isComposite=" + z16);
            }
            return ((IEmotionSearchManagerService) this.manager).getLastTask(z16);
        }
        return null;
    }

    public boolean isC2COrTempChat(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, i3)).booleanValue();
        }
        if (i3 == 1 || isTempChat(i3)) {
            return true;
        }
        return false;
    }

    public boolean isGroupOrGuildGroup(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, i3)).booleanValue();
        }
        if (i3 != 2 && i3 != 9 && i3 != 3) {
            return false;
        }
        return true;
    }

    public boolean isGuildOrGuildGroup(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, i3)).booleanValue();
        }
        if (i3 != 4 && i3 != 9) {
            return false;
        }
        return true;
    }

    public void loadMore() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else if (this.manager != 0) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 4, "do loadMore.");
            }
            ((IEmotionSearchManagerService) this.manager).loadMore();
        }
    }

    public void pushEmotionSearchTask(IEmotionSearchManagerService.EmotionSearchTask emotionSearchTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) emotionSearchTask);
        } else if (this.manager != 0) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 4, "do pushEmotionSearchTask.");
            }
            ((IEmotionSearchManagerService) this.manager).pushEmotionSearchTask(emotionSearchTask);
        }
    }

    public void resetData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else if (this.manager != 0) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 4, "do resetData.");
            }
            ((IEmotionSearchManagerService) this.manager).resetData();
        }
    }

    public void setSearchCallBack(IEmotionSearchManagerService.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) aVar);
        } else if (this.manager != 0) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 4, "do searchCallBack.");
            }
            ((IEmotionSearchManagerService) this.manager).setSearchCallBack(aVar);
        }
    }

    public EmotionSearchManagerServiceProxy(BaseQQAppInterface baseQQAppInterface, Class cls) {
        super(baseQQAppInterface, cls);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) baseQQAppInterface, (Object) cls);
    }

    public void resetData(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
            return;
        }
        if (this.manager != 0) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 4, "do resetData. isComposite:" + z16);
            }
            ((IEmotionSearchManagerService) this.manager).resetData(z16);
        }
    }
}
