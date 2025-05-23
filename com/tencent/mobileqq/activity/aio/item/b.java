package com.tencent.mobileqq.activity.aio.item;

import android.text.TextUtils;
import com.tencent.ark.open.appmanage.AppManageInfoStorage;
import com.tencent.ark.open.appmanage.Utility;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkBabyqCardInfo;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.RecommendCommonMessage;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b extends ArkAppContainer {

    /* renamed from: s, reason: collision with root package name */
    private static final Set<WeakReference<b>> f179439s = Collections.synchronizedSet(new HashSet());

    /* renamed from: l, reason: collision with root package name */
    public WeakReference<MessageForArkApp> f179440l;

    /* renamed from: m, reason: collision with root package name */
    private WeakReference<ArkBabyqCardInfo> f179441m;

    /* renamed from: n, reason: collision with root package name */
    private WeakReference<RecommendCommonMessage> f179442n;

    /* renamed from: o, reason: collision with root package name */
    private WeakReference<RecommendCommonMessage.ArkMsgAppInfo> f179443o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f179444p = false;

    /* renamed from: q, reason: collision with root package name */
    public boolean f179445q = false;

    /* renamed from: r, reason: collision with root package name */
    protected WeakReference<b> f179446r;

    public b() {
        WeakReference<b> weakReference = new WeakReference<>(this);
        this.f179446r = weakReference;
        f179439s.add(weakReference);
        c.l();
        c.o(this.f179446r);
    }

    public static void doArkAppEvent(int i3) {
        QLog.i("ArkApp.ArkAioContainerWrapper", 1, String.format(Locale.CHINA, "doArkAppEvent type:%d", Integer.valueOf(i3)));
        if (i3 == 0) {
            com.tencent.mobileqq.ark.api.silk.a.c();
        }
        if (i3 == 2) {
            c.l();
            c.f();
        }
        Set<WeakReference<b>> set = f179439s;
        synchronized (set) {
            Iterator<WeakReference<b>> it = set.iterator();
            while (it.hasNext()) {
                WeakReference<b> next = it.next();
                if (next != null && next.get() != null) {
                    b bVar = next.get();
                    bVar.doOnEvent(i3);
                    if (i3 == 2) {
                        k(bVar);
                    }
                }
                QLog.i("ArkApp.ArkAioContainerWrapper", 1, "doArkAppEvent.(item == null || item.get() == null)");
                it.remove();
            }
            if (i3 == 2) {
                f179439s.clear();
            }
        }
    }

    public static void k(b bVar) {
        WeakReference<MessageForArkApp> weakReference = bVar.f179440l;
        if (weakReference != null && weakReference.get() != null) {
            weakReference.get().arkContainer = null;
        }
        WeakReference<RecommendCommonMessage> weakReference2 = bVar.f179442n;
        if (weakReference2 != null && weakReference2.get() != null) {
            weakReference2.get().mOldAppInfo.mArkContainer = null;
        }
        WeakReference<RecommendCommonMessage.ArkMsgAppInfo> weakReference3 = bVar.f179443o;
        if (weakReference3 != null && weakReference3.get() != null) {
            weakReference3.get().mArkContainer = null;
        }
        WeakReference<ArkBabyqCardInfo> weakReference4 = bVar.f179441m;
        if (weakReference4 != null && weakReference4.get() != null) {
            weakReference4.get().mArkBabyqContainer = null;
        }
    }

    public static MessageForArkApp l(String str) {
        WeakReference<b> next;
        b bVar;
        WeakReference<MessageForArkApp> weakReference;
        MessageForArkApp messageForArkApp;
        Set<WeakReference<b>> set = f179439s;
        synchronized (set) {
            Iterator<WeakReference<b>> it = set.iterator();
            while (it.hasNext() && (next = it.next()) != null && (bVar = next.get()) != null && (weakReference = bVar.f179440l) != null && (messageForArkApp = weakReference.get()) != null) {
                if (str.equals(messageForArkApp.getExtInfoFromExtStr("pa_msgId")) || str.equals(String.valueOf(messageForArkApp.uniseq))) {
                    return weakReference.get();
                }
            }
            return null;
        }
    }

    public static void m(b bVar) {
        if (bVar == null) {
            return;
        }
        Set<WeakReference<b>> set = f179439s;
        synchronized (set) {
            set.remove(bVar.f179446r);
        }
    }

    @Override // com.tencent.ark.ArkViewModelBase
    public void activateView(boolean z16, boolean z17) {
        boolean z18 = this.mIsActivated;
        super.activateView(z16, z17);
        if (z18 == this.mIsActivated) {
            return;
        }
        if (this.mIsActivated) {
            c.l();
            c.o(this.f179446r);
        } else {
            c.l();
            c.p(this.f179446r);
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.item.ArkAppContainer
    public String c(String str) {
        ArkAppMessage arkAppMessage;
        String str2 = "";
        if (str == null) {
            return "";
        }
        WeakReference<MessageForArkApp> weakReference = this.f179440l;
        if (weakReference == null) {
            return str;
        }
        MessageForArkApp messageForArkApp = weakReference.get();
        if (messageForArkApp != null && (arkAppMessage = messageForArkApp.ark_app_message) != null) {
            String str3 = arkAppMessage.appName;
            String loadAppDesc = AppManageInfoStorage.loadAppDesc(str3);
            if (TextUtils.isEmpty(loadAppDesc)) {
                if (Utility.isValidAppName(str3)) {
                    str2 = str3;
                }
            } else {
                str2 = loadAppDesc;
            }
            if (messageForArkApp.ark_app_message.appDesc != null) {
                str = str.replace("%APP_DESC%", str2).replace("$APP_DESC$", str2);
            }
            if (messageForArkApp.ark_app_message.appName != null) {
                str = str.replace("%APP_NAME%", str3).replace("$APP_NAME$", str3);
            }
            String str4 = messageForArkApp.ark_app_message.promptText;
            if (str4 != null) {
                return str.replace("%PROMPT%", str4).replace("$PROMPT$", messageForArkApp.ark_app_message.promptText);
            }
            return str;
        }
        return str;
    }

    @Override // com.tencent.ark.aio.BaseArkAppContainer, com.tencent.ark.ArkViewModelBase
    protected void destroy() {
        super.destroy();
        c.l();
        c.q(this.f179446r);
    }

    @Override // com.tencent.ark.aio.BaseArkAppContainer
    public void detachFromStatusBar() {
        this.f179445q = false;
        if (this.f179444p) {
            super.doOnEvent(2);
        }
    }

    @Override // com.tencent.ark.aio.BaseArkAppContainer, com.tencent.ark.ArkViewModelBase
    public void doOnEvent(int i3) {
        if (i3 == 2 && this.f179445q) {
            this.f179444p = true;
        } else {
            super.doOnEvent(i3);
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.item.ArkAppContainer
    public String f() {
        MessageForArkApp messageForArkApp;
        WeakReference<MessageForArkApp> weakReference = this.f179440l;
        if (weakReference == null || (messageForArkApp = weakReference.get()) == null) {
            return "";
        }
        return messageForArkApp.ark_app_message.config;
    }

    @Override // com.tencent.ark.ArkViewModelBase
    public String getViewId() {
        MessageForArkApp messageForArkApp;
        WeakReference<MessageForArkApp> weakReference = this.f179440l;
        if (weakReference == null || (messageForArkApp = weakReference.get()) == null) {
            return null;
        }
        String extInfoFromExtStr = messageForArkApp.getExtInfoFromExtStr("pa_msgId");
        if (!TextUtils.isEmpty(extInfoFromExtStr)) {
            return extInfoFromExtStr;
        }
        return String.valueOf(messageForArkApp.uniseq);
    }
}
