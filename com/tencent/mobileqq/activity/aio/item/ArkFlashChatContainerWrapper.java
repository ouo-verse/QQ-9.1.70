package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.ArkViewModelBase;
import com.tencent.ark.ark;
import com.tencent.ark.open.ArkAppInfo;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ArkFlashChatContainerWrapper extends ArkAppContainer {

    /* renamed from: q, reason: collision with root package name */
    private static final List<WeakReference<ArkFlashChatContainerWrapper>> f179287q = Collections.synchronizedList(new ArrayList());

    /* renamed from: r, reason: collision with root package name */
    private static final List<WeakReference<ArkFlashChatContainerWrapper>> f179288r = Collections.synchronizedList(new ArrayList());

    /* renamed from: l, reason: collision with root package name */
    private WeakReference<MessageForArkFlashChat> f179289l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f179290m;

    /* renamed from: n, reason: collision with root package name */
    public int f179291n;

    /* renamed from: o, reason: collision with root package name */
    public WeakReference<QQAppInterface> f179292o;

    /* renamed from: p, reason: collision with root package name */
    private com.tencent.mobileqq.flashchat.b f179293p;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class TouchRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private int f179300d;

        /* renamed from: e, reason: collision with root package name */
        private ark.Container f179301e;

        /* renamed from: f, reason: collision with root package name */
        private int[] f179302f;

        /* renamed from: h, reason: collision with root package name */
        private float[] f179303h;

        /* renamed from: i, reason: collision with root package name */
        private float[] f179304i;

        public TouchRunnable(MotionEvent motionEvent, ark.Container container, float f16) {
            int actionMasked = motionEvent.getActionMasked();
            this.f179300d = actionMasked;
            this.f179301e = container;
            if (actionMasked != 5 && actionMasked != 6) {
                int pointerCount = motionEvent.getPointerCount();
                pointerCount = pointerCount > ark.arkGetMaxTouchPoints() ? ark.arkGetMaxTouchPoints() : pointerCount;
                this.f179302f = new int[pointerCount];
                this.f179303h = new float[pointerCount];
                this.f179304i = new float[pointerCount];
                for (int i3 = 0; i3 < pointerCount; i3++) {
                    this.f179302f[i3] = motionEvent.getPointerId(i3);
                    this.f179303h[i3] = motionEvent.getX(i3) / f16;
                    this.f179304i[i3] = motionEvent.getY(i3) / f16;
                }
                return;
            }
            this.f179302f = new int[1];
            this.f179303h = new float[1];
            this.f179304i = new float[1];
            int actionIndex = motionEvent.getActionIndex();
            this.f179302f[0] = motionEvent.getPointerId(actionIndex);
            this.f179303h[0] = motionEvent.getX(actionIndex) / f16;
            this.f179304i[0] = motionEvent.getY(actionIndex) / f16;
        }

        @Override // java.lang.Runnable
        public void run() {
            MessageForArkFlashChat messageForArkFlashChat;
            int i3 = this.f179300d;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 != 5) {
                                if (i3 != 6) {
                                    return;
                                }
                            }
                        } else {
                            ark.Container container = this.f179301e;
                            float[] fArr = this.f179303h;
                            float[] fArr2 = this.f179304i;
                            int[] iArr = this.f179302f;
                            container.TouchCancel(fArr, fArr2, iArr, iArr.length);
                            return;
                        }
                    } else {
                        ark.Container container2 = this.f179301e;
                        float[] fArr3 = this.f179303h;
                        float[] fArr4 = this.f179304i;
                        int[] iArr2 = this.f179302f;
                        container2.TouchMove(fArr3, fArr4, iArr2, iArr2.length);
                        return;
                    }
                }
                QQAppInterface qQAppInterface = ArkFlashChatContainerWrapper.this.f179292o.get();
                if (qQAppInterface != null) {
                    FlashChatManager flashChatManager = (FlashChatManager) qQAppInterface.getManager(QQManagerFactory.FLASH_CHAT_MANAGER);
                    if (ArkFlashChatContainerWrapper.this.f179289l != null && (messageForArkFlashChat = (MessageForArkFlashChat) ArkFlashChatContainerWrapper.this.f179289l.get()) != null && !flashChatManager.t(messageForArkFlashChat)) {
                        flashChatManager.D(null);
                        flashChatManager.a(messageForArkFlashChat);
                    }
                }
                ark.Container container3 = this.f179301e;
                float[] fArr5 = this.f179303h;
                float[] fArr6 = this.f179304i;
                int[] iArr3 = this.f179302f;
                container3.TouchEnd(fArr5, fArr6, iArr3, iArr3.length);
                return;
            }
            ark.Container container4 = this.f179301e;
            float[] fArr7 = this.f179303h;
            float[] fArr8 = this.f179304i;
            int[] iArr4 = this.f179302f;
            container4.TouchStart(fArr7, fArr8, iArr4, iArr4.length);
        }
    }

    public ArkFlashChatContainerWrapper() {
        this(true);
    }

    @Override // com.tencent.mobileqq.activity.aio.item.ArkAppContainer
    public String c(String str) {
        ArkFlashChatMessage arkFlashChatMessage;
        if (str == null) {
            return "";
        }
        WeakReference<MessageForArkFlashChat> weakReference = this.f179289l;
        if (weakReference == null) {
            return str;
        }
        MessageForArkFlashChat messageForArkFlashChat = weakReference.get();
        if (messageForArkFlashChat != null && (arkFlashChatMessage = messageForArkFlashChat.ark_app_message) != null) {
            String str2 = arkFlashChatMessage.appDesc;
            if (str2 != null) {
                str = str.replace("%APP_DESC%", str2).replace("$APP_DESC$", messageForArkFlashChat.ark_app_message.appDesc);
            }
            String str3 = messageForArkFlashChat.ark_app_message.appName;
            if (str3 != null) {
                str = str.replace("%APP_NAME%", str3).replace("$APP_NAME$", messageForArkFlashChat.ark_app_message.appName);
            }
            String str4 = messageForArkFlashChat.ark_app_message.promptText;
            if (str4 != null) {
                return str.replace("%PROMPT%", str4).replace("$PROMPT$", messageForArkFlashChat.ark_app_message.promptText);
            }
            return str;
        }
        return str;
    }

    @Override // com.tencent.mobileqq.activity.aio.item.ArkAppContainer
    public String f() {
        MessageForArkFlashChat messageForArkFlashChat;
        WeakReference<MessageForArkFlashChat> weakReference = this.f179289l;
        if (weakReference == null || (messageForArkFlashChat = weakReference.get()) == null) {
            return "";
        }
        return messageForArkFlashChat.ark_app_message.config;
    }

    @Override // com.tencent.ark.ArkViewModelBase
    public String getViewId() {
        MessageForArkFlashChat messageForArkFlashChat;
        WeakReference<MessageForArkFlashChat> weakReference = this.f179289l;
        if (weakReference == null || (messageForArkFlashChat = weakReference.get()) == null) {
            return null;
        }
        String extInfoFromExtStr = messageForArkFlashChat.getExtInfoFromExtStr("pa_msgId");
        if (!TextUtils.isEmpty(extInfoFromExtStr)) {
            return extInfoFromExtStr;
        }
        return String.valueOf(messageForArkFlashChat.uniseq);
    }

    @Override // com.tencent.ark.aio.BaseArkAppContainer, com.tencent.ark.ArkViewModelBase
    public boolean onLoadApp(ArkViewModelBase.AppInfo appInfo) {
        QQAppInterface e16 = ArkAppContainer.e();
        if (e16 == null) {
            this.mInit = false;
            this.mLoadFailed = true;
            ArkViewImplement arkViewImplement = this.mViewImpl;
            if (arkViewImplement != null) {
                arkViewImplement.onLoadFailed(null, this.mErrorInfo.retCode, true);
            }
            return true;
        }
        this.f179266c.beginOfGetApp = System.currentTimeMillis();
        FlashChatManager flashChatManager = (FlashChatManager) e16.getManager(QQManagerFactory.FLASH_CHAT_MANAGER);
        int i3 = this.f179291n;
        ArkViewModelBase.AppInfo appInfo2 = this.mAppInfo;
        final String i16 = flashChatManager.i(i3, appInfo2.name, appInfo2.appMinVersion);
        if (i16 != null) {
            ArkDispatchTask.getInstance().post(this.mAppInfo.name, new Runnable() { // from class: com.tencent.mobileqq.activity.aio.item.ArkFlashChatContainerWrapper.1
                @Override // java.lang.Runnable
                public void run() {
                    ArkAppInfo.TimeRecord timeRecord = ArkFlashChatContainerWrapper.this.f179266c;
                    timeRecord.getAppFromLocal = true;
                    timeRecord.endOfGetApp = System.currentTimeMillis();
                    if (QLog.isColorLevel()) {
                        QLog.i("ArkApp", 2, String.format("getAppPathByNameFromLocal.in.wrapper: %h", this));
                    }
                    ArkDispatchTask.getInstance().postToMainThread(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.item.ArkFlashChatContainerWrapper.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (((ArkViewModelBase) ArkFlashChatContainerWrapper.this).mViewImpl != null) {
                                ((ArkViewModelBase) ArkFlashChatContainerWrapper.this).mViewImpl.onLoading();
                            }
                        }
                    });
                    ArkFlashChatContainerWrapper.this.loadArkApp(i16, 0, null);
                }
            });
            return true;
        }
        ArkViewImplement arkViewImplement2 = this.mViewImpl;
        if (arkViewImplement2 != null) {
            arkViewImplement2.onLoading();
        }
        if (QLog.isColorLevel()) {
            QLog.i("ArkApp", 2, String.format("request from url", this));
        }
        e16.registObserver(this.f179293p);
        flashChatManager.h(this.f179291n);
        return false;
    }

    @Override // com.tencent.ark.ArkViewModelBase
    public boolean onTouch(View view, MotionEvent motionEvent) {
        ark.Container container;
        if (!this.f179290m || (container = this.mContainer) == null || container == null) {
            return false;
        }
        ArkDispatchTask.getInstance().post(this.mAppInfo.name, new TouchRunnable(motionEvent, this.mContainer, this.mAppInfo.scale));
        return true;
    }

    public boolean w(QQAppInterface qQAppInterface, Context context, String str, String str2, String str3, int i3, String str4, float f16, SessionInfo sessionInfo, float f17, float f18, float f19, float f26, MessageForArkFlashChat messageForArkFlashChat) {
        this.f179291n = i3;
        this.f179292o = new WeakReference<>(qQAppInterface);
        if (messageForArkFlashChat != null) {
            this.f179289l = new WeakReference<>(messageForArkFlashChat);
        }
        if (!super.h(str, str2, "", str3, str4, f16, sessionInfo)) {
            if (QLog.isColorLevel()) {
                QLog.d("ArkApp.ArkAioContainerWrapper", 4, String.format("super.init return false!!! wrapper: %h.", this));
            }
            return false;
        }
        setFixSize((int) f17, (int) f18);
        setMaxSize((int) f19, (int) f26);
        return true;
    }

    public ArkFlashChatContainerWrapper(boolean z16) {
        super(false);
        this.f179290m = false;
        this.f179293p = new com.tencent.mobileqq.flashchat.b() { // from class: com.tencent.mobileqq.activity.aio.item.ArkFlashChatContainerWrapper.2
            @Override // com.tencent.mobileqq.flashchat.b
            public void a(final boolean z17, final Bundle bundle) {
                ArkDispatchTask.getInstance().postDelayed(((ArkViewModelBase) ArkFlashChatContainerWrapper.this).mAppInfo.name, new Runnable() { // from class: com.tencent.mobileqq.activity.aio.item.ArkFlashChatContainerWrapper.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int i3;
                        int i16;
                        if (z17) {
                            Bundle bundle2 = bundle;
                            if (bundle2 != null && (i16 = bundle2.getInt("resourceId")) != -1 && ArkFlashChatContainerWrapper.this.f179291n == i16) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("ArkApp", 2, "onDownloadRes onSuccess resouceId " + i16);
                                }
                                QQAppInterface e16 = ArkAppContainer.e();
                                if (e16 != null) {
                                    FlashChatManager flashChatManager = (FlashChatManager) e16.getManager(QQManagerFactory.FLASH_CHAT_MANAGER);
                                    ArkViewModelBase.AppInfo appInfo = ((ArkViewModelBase) ArkFlashChatContainerWrapper.this).mAppInfo;
                                    ArkFlashChatContainerWrapper arkFlashChatContainerWrapper = ArkFlashChatContainerWrapper.this;
                                    appInfo.path = flashChatManager.i(arkFlashChatContainerWrapper.f179291n, ((ArkViewModelBase) arkFlashChatContainerWrapper).mAppInfo.name, ((ArkViewModelBase) ArkFlashChatContainerWrapper.this).mAppInfo.appMinVersion);
                                    ArkFlashChatContainerWrapper arkFlashChatContainerWrapper2 = ArkFlashChatContainerWrapper.this;
                                    arkFlashChatContainerWrapper2.loadArkApp(((ArkViewModelBase) arkFlashChatContainerWrapper2).mAppInfo.path, 0, null);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        Bundle bundle3 = bundle;
                        if (bundle3 != null && (i3 = bundle3.getInt("resourceId")) != -1 && ArkFlashChatContainerWrapper.this.f179291n == i3) {
                            if (QLog.isColorLevel()) {
                                QLog.d("ArkApp.ArkAioContainerWrapper", 2, "onDownloadRes onError resouceId " + i3);
                            }
                            ArkFlashChatContainerWrapper arkFlashChatContainerWrapper3 = ArkFlashChatContainerWrapper.this;
                            arkFlashChatContainerWrapper3.loadArkApp(((ArkViewModelBase) arkFlashChatContainerWrapper3).mAppInfo.path, -2, null);
                        }
                    }
                }, 1000L);
            }
        };
        if (z16) {
            f179287q.add(new WeakReference<>(this));
        } else {
            f179288r.add(new WeakReference<>(this));
        }
        this.f179290m = z16;
    }
}
