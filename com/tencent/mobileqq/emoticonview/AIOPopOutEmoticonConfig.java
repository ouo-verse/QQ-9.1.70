package com.tencent.mobileqq.emoticonview;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.aio.event.FaceBubbleMsgEvent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.popanim.PopOutAnimConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.FaceBubbleElement;
import com.tencent.qqnt.kernel.nativeinterface.SmallYellowFaceInfo;
import java.util.Locale;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

/* loaded from: classes12.dex */
public class AIOPopOutEmoticonConfig extends PopOutAnimConfig {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "AIOPopOutEmoticonConfig";
    private WeakReference<com.tencent.aio.api.runtime.a> weakAioContext;
    private WeakReference<ViewGroup> weakAioRootView;
    private WeakReference<a61.c> weakChatPie;
    private WeakReference<ViewGroup> weakRootView;

    public AIOPopOutEmoticonConfig(a61.c cVar, ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cVar, (Object) viewGroup);
        } else if (cVar != null) {
            this.weakChatPie = new WeakReference<>(cVar);
        } else if (viewGroup != null) {
            this.weakRootView = new WeakReference<>(viewGroup);
        }
    }

    private static FaceBubbleElement buildElement(SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo, int i3) {
        String str;
        if (systemAndEmojiEmoticonInfo == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 1, "sendPopEmoMsg emoticonInfo is null");
                return null;
            }
            return null;
        }
        int convertToServer = QQSysFaceUtil.convertToServer(systemAndEmojiEmoticonInfo.code);
        String prueFaceDescription = QQSysFaceUtil.getPrueFaceDescription(QQSysFaceUtil.getFaceDescription(QQSysFaceUtil.convertToLocal(convertToServer)));
        if (prueFaceDescription == null) {
            str = "";
        } else {
            str = prueFaceDescription;
        }
        String format = String.format(Locale.getDefault(), "[%s]x%d", prueFaceDescription, Integer.valueOf(i3));
        String format2 = String.format("[%s]\u8bf7\u4f7f\u7528\u6700\u65b0\u7248\u624b\u673aQQ\u4f53\u9a8c\u65b0\u529f\u80fd\u3002", str);
        SmallYellowFaceInfo smallYellowFaceInfo = new SmallYellowFaceInfo();
        smallYellowFaceInfo.setIndex(convertToServer);
        smallYellowFaceInfo.setCompatibleText(str);
        smallYellowFaceInfo.setText(str);
        FaceBubbleElement faceBubbleElement = new FaceBubbleElement();
        faceBubbleElement.setFaceType(13);
        faceBubbleElement.setFaceCount(Integer.valueOf(i3));
        faceBubbleElement.setFaceSummary(str);
        faceBubbleElement.setContent(format);
        faceBubbleElement.setOldVersionStr(format2);
        faceBubbleElement.setYellowFaceInfo(smallYellowFaceInfo);
        return faceBubbleElement;
    }

    private View getAFRootView() {
        WeakReference<a61.c> weakReference = this.weakChatPie;
        if (weakReference != null && weakReference.get() != null) {
            return this.weakChatPie.get().f25595t;
        }
        WeakReference<ViewGroup> weakReference2 = this.weakRootView;
        if (weakReference2 != null) {
            return weakReference2.get();
        }
        WeakReference<ViewGroup> weakReference3 = this.weakAioRootView;
        if (weakReference3 != null && weakReference3.get() != null) {
            return this.weakAioRootView.get();
        }
        return null;
    }

    public void init() {
        QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) waitAppRuntime;
        } else {
            qQAppInterface = null;
        }
        this.itemCountShowAppear = com.tencent.mobileqq.activity.aio.stickerbubble.b.c(qQAppInterface);
        this.itemCountRecShowAppear = com.tencent.mobileqq.activity.aio.stickerbubble.b.c(qQAppInterface);
        this.supportFeedBack = com.tencent.mobileqq.activity.aio.item.l.k(null);
        this.maxSendCount = com.tencent.mobileqq.activity.aio.item.l.h(qQAppInterface, 10);
        boolean isLoaded = com.tencent.mobileqq.vas.an.h().isLoaded();
        this.apngSoLoaded = isLoaded;
        if (!isLoaded) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.emoticonview.AIOPopOutEmoticonConfig.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOPopOutEmoticonConfig.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        com.tencent.mobileqq.vas.an.h().load(new URLDrawableHandler.Adapter() { // from class: com.tencent.mobileqq.emoticonview.AIOPopOutEmoticonConfig.1.1
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                                }
                            }

                            @Override // com.tencent.image.URLDrawableHandler.Adapter, com.tencent.image.URLDrawableHandler
                            public void onFileDownloadFailed(int i3) {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 3)) {
                                    iPatchRedirector3.redirect((short) 3, (Object) this, i3);
                                    return;
                                }
                                QLog.i(AIOPopOutEmoticonConfig.TAG, 1, "onFileDownloadFailed, errorCode:" + i3);
                            }

                            @Override // com.tencent.image.URLDrawableHandler.Adapter, com.tencent.image.URLDrawableHandler
                            public void onFileDownloadSucceed(long j3) {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this, j3);
                                    return;
                                }
                                AIOPopOutEmoticonConfig.this.apngSoLoaded = true;
                                QLog.i(AIOPopOutEmoticonConfig.TAG, 1, "onFileDownloadSucceed, fileSize:" + j3);
                            }
                        });
                    }
                }
            }, 64, null, false);
        }
        com.tencent.mobileqq.poke.c cVar = com.tencent.mobileqq.poke.c.f258994a;
        if (cVar.g() == null) {
            cVar.k();
        }
        this.typeface = cVar.g();
    }

    @Override // com.tencent.mobileqq.popanim.PopOutAnimConfig
    public void sendPopEmoMsg(SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) systemAndEmojiEmoticonInfo, i3);
            return;
        }
        WeakReference<a61.c> weakReference = this.weakChatPie;
        if (weakReference != null && weakReference.get() != null) {
            a61.c cVar = this.weakChatPie.get();
            ChatActivityFacade.P0(cVar.f(), cVar.m(), i3, systemAndEmojiEmoticonInfo);
            return;
        }
        WeakReference<com.tencent.aio.api.runtime.a> weakReference2 = this.weakAioContext;
        if (weakReference2 != null && weakReference2.get() != null) {
            QLog.d(TAG, 2, "sendPopEmoMsg: emoticonInfo:" + systemAndEmojiEmoticonInfo + " count=" + i3);
            com.tencent.aio.api.runtime.a aVar = this.weakAioContext.get();
            FaceBubbleElement buildElement = buildElement(systemAndEmojiEmoticonInfo, i3);
            if (buildElement != null) {
                aVar.e().h(new FaceBubbleMsgEvent.FaceBubbleSendEvent(buildElement));
            }
        }
    }

    @Override // com.tencent.mobileqq.popanim.PopOutAnimConfig
    public void startShakeAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        View aFRootView = getAFRootView();
        if (aFRootView != null) {
            com.tencent.mobileqq.activity.aio.stickerbubble.b.d(this, aFRootView);
        }
    }

    @Override // com.tencent.mobileqq.popanim.PopOutAnimConfig
    public void stopShakeAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        View aFRootView = getAFRootView();
        if (aFRootView != null) {
            com.tencent.mobileqq.activity.aio.stickerbubble.b.a(this, aFRootView);
        }
    }

    public AIOPopOutEmoticonConfig(com.tencent.aio.api.runtime.a aVar, ViewGroup viewGroup, ViewGroup viewGroup2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, aVar, viewGroup, viewGroup2);
            return;
        }
        if (aVar != null) {
            this.weakAioContext = new WeakReference<>(aVar);
        }
        if (viewGroup != null) {
            this.weakAioRootView = new WeakReference<>(viewGroup);
        } else if (viewGroup2 != null) {
            this.weakRootView = new WeakReference<>(viewGroup2);
        }
    }
}
