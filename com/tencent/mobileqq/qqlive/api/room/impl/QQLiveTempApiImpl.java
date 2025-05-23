package com.tencent.mobileqq.qqlive.api.room.impl;

import android.content.Context;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.gaudio.AVObserver;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.IQQLiveUtil;
import com.tencent.mobileqq.qqlive.api.room.IQQLiveTempApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import eq2.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000?\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\b\u0006*\u0001\u0014\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016JB\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\r\u0010\u0013\u001a\u00020\u0014H\u0002\u00a2\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\bH\u0016J\b\u0010\u0017\u001a\u00020\bH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/room/impl/QQLiveTempApiImpl;", "Lcom/tencent/mobileqq/qqlive/api/room/IQQLiveTempApi;", "()V", "qqLiveAVObserver", "Lcom/tencent/av/gaudio/AVObserver;", "isAudioChating", "", "launchAppWithTokens", "", "app", "Lcom/tencent/common/app/AppInterface;", "context", "Landroid/content/Context;", "appid", "", "params", "packageName", WadlProxyConsts.FLAGS, "", "obtainObserver", "com/tencent/mobileqq/qqlive/api/room/impl/QQLiveTempApiImpl$obtainObserver$1", "()Lcom/tencent/mobileqq/qqlive/api/room/impl/QQLiveTempApiImpl$obtainObserver$1;", "registerQQLiveChatObserver", "removeQQLiveChatObserver", "Companion", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final class QQLiveTempApiImpl implements IQQLiveTempApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "QQLiveChatObserverManager";

    @Nullable
    private AVObserver qqLiveAVObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/room/impl/QQLiveTempApiImpl$Companion;", "", "()V", "TAG", "", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59956);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQLiveTempApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.tencent.mobileqq.qqlive.api.room.impl.QQLiveTempApiImpl$obtainObserver$1] */
    private final QQLiveTempApiImpl$obtainObserver$1 obtainObserver() {
        return new AVObserver() { // from class: com.tencent.mobileqq.qqlive.api.room.impl.QQLiveTempApiImpl$obtainObserver$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.av.gaudio.AVObserver
            public void onAudioChatting(int uinType, @Nullable String peerUin, @Nullable String extraUin) {
                QQAppInterface qQAppInterface;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Integer.valueOf(uinType), peerUin, extraUin);
                    return;
                }
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime instanceof QQAppInterface) {
                    qQAppInterface = (QQAppInterface) peekAppRuntime;
                } else {
                    qQAppInterface = null;
                }
                if (qQAppInterface == null) {
                    return;
                }
                ((IQQLiveUtil) QRoute.api(IQQLiveUtil.class)).notifyChatAudioChange(AVNotifyCenter.V(), qQAppInterface.getAVNotifyCenter().U());
            }
        };
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.IQQLiveTempApi
    public boolean isAudioChating() {
        QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null) {
            return false;
        }
        return qQAppInterface.getAVNotifyCenter().U();
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.IQQLiveTempApi
    public void launchAppWithTokens(@Nullable AppInterface app, @Nullable Context context, @Nullable String appid, @Nullable String params, @Nullable String packageName, int flags) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, app, context, appid, params, packageName, Integer.valueOf(flags));
        } else {
            new a().d(app, context, appid, params, packageName, flags);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.IQQLiveTempApi
    public void registerQQLiveChatObserver() {
        QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null) {
            QLog.e(TAG, 1, "registerQQLiveChatObserver app is null");
        } else if (this.qqLiveAVObserver == null) {
            QQLiveTempApiImpl$obtainObserver$1 obtainObserver = obtainObserver();
            this.qqLiveAVObserver = obtainObserver;
            qQAppInterface.getAVNotifyCenter().addObserver(obtainObserver);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.IQQLiveTempApi
    public void removeQQLiveChatObserver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        AVObserver aVObserver = this.qqLiveAVObserver;
        QQAppInterface qQAppInterface = null;
        this.qqLiveAVObserver = null;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        }
        if (qQAppInterface == null) {
            QLog.e(TAG, 1, "removeQQLiveChatObserver app is null");
        } else if (aVObserver != null) {
            qQAppInterface.getAVNotifyCenter().deleteObserver(aVObserver);
        }
    }
}
