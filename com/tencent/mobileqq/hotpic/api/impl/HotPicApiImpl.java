package com.tencent.mobileqq.hotpic.api.impl;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.mobileqq.hotpic.HotPicManager;
import com.tencent.mobileqq.hotpic.HotPicSendData;
import com.tencent.mobileqq.hotpic.HotPicTagInfo;
import com.tencent.mobileqq.hotpic.api.IHotPicApi;
import com.tencent.mobileqq.hotpic.b;
import com.tencent.mobileqq.hotpic.f;
import com.tencent.mobileqq.hotpic.h;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ,2\u00020\u0001:\u0001-B\u0007\u00a2\u0006\u0004\b*\u0010+J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0018\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0017\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0018\u001a\u00020\rH\u0016J\u001a\u0010\u001b\u001a\u00020\u00122\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0018\u001a\u00020\rH\u0016J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u0015H\u0016J\b\u0010\u001e\u001a\u00020\u0012H\u0016J\b\u0010\u001f\u001a\u00020\u0012H\u0016J\b\u0010 \u001a\u00020\u0019H\u0016J\b\u0010!\u001a\u00020\u0012H\u0016J\u0010\u0010$\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\"H\u0016J\u000e\u0010'\u001a\b\u0012\u0004\u0012\u00020&0%H\u0016J \u0010(\u001a\b\u0012\u0004\u0012\u00020\"0\u00142\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0018\u001a\u00020\rH\u0016J\u001a\u0010)\u001a\u00020\u00192\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0018\u001a\u00020\rH\u0016\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/hotpic/api/impl/HotPicApiImpl;", "Lcom/tencent/mobileqq/hotpic/api/IHotPicApi;", "Lmqq/manager/Manager;", "manager", "getHotPicManager", "", "url", "Ljava/net/URL;", "getHotPicURL", "Ljava/io/File;", "getDiskFile", "getDiskFilePath", "uin", "", "getHotPicRedDotStatus", "getURL", "Lcom/tencent/mobileqq/hotpic/f;", "listener", "", "initHotPicManager", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/hotpic/HotPicTagInfo;", "getHotPicTags", "getLastClickId", "tagId", "", "checkData", "requestHotPicList", "hotPicTagInfo", "processData", "clearHotPicListener", "cleanResource", "isNeedGuide", "markGuide", "Lcom/tencent/mobileqq/hotpic/HotPicData;", "sendPic", "addSendPic", "Ljava/util/LinkedList;", "Lcom/tencent/mobileqq/hotpic/HotPicSendData;", "getRecentSendPics", "getHotPics", "checkIsNoMoreIndex", "<init>", "()V", "Companion", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class HotPicApiImpl implements IHotPicApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "HotPicManagerHotPicApiImpl";

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/hotpic/api/impl/HotPicApiImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.hotpic.api.impl.HotPicApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes9.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58537);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 22)) {
            redirector.redirect((short) 22);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public HotPicApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.hotpic.api.IHotPicApi
    public void addSendPic(@NotNull HotPicData sendPic) {
        QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) sendPic);
            return;
        }
        Intrinsics.checkNotNullParameter(sendPic, "sendPic");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        Manager k3 = HotPicManager.k(qQAppInterface);
        if (!(k3 instanceof HotPicManager)) {
            QLog.i(TAG, 1, "addSendPic: is not hot pic manager");
        } else {
            ((HotPicManager) k3).c(sendPic);
        }
    }

    @Override // com.tencent.mobileqq.hotpic.api.IHotPicApi
    public boolean checkData(@Nullable Manager manager, int tagId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) manager, tagId)).booleanValue();
        }
        Manager hotPicManager = getHotPicManager(manager);
        if (!(hotPicManager instanceof HotPicManager)) {
            QLog.i(TAG, 1, "checkData: is not hot pic manager");
            return false;
        }
        return ((HotPicManager) hotPicManager).d(tagId);
    }

    @Override // com.tencent.mobileqq.hotpic.api.IHotPicApi
    public boolean checkIsNoMoreIndex(@Nullable Manager manager, int tagId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this, (Object) manager, tagId)).booleanValue();
        }
        Manager hotPicManager = getHotPicManager(manager);
        if (!(hotPicManager instanceof HotPicManager)) {
            QLog.i(TAG, 1, "checkIsNoMoreIndex: is not hot pic manager");
            return false;
        }
        return ((HotPicManager) hotPicManager).e(tagId);
    }

    @Override // com.tencent.mobileqq.hotpic.api.IHotPicApi
    public void cleanResource() {
        QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        Manager k3 = HotPicManager.k(qQAppInterface);
        if (!(k3 instanceof HotPicManager)) {
            QLog.i(TAG, 1, "cleanResource: is not hot pic manager");
        } else {
            ((HotPicManager) k3).g();
        }
    }

    @Override // com.tencent.mobileqq.hotpic.api.IHotPicApi
    public void clearHotPicListener() {
        QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        Manager k3 = HotPicManager.k(qQAppInterface);
        if (!(k3 instanceof HotPicManager)) {
            QLog.i(TAG, 1, "clearHotPicListener: is not hot pic manager");
        } else {
            ((HotPicManager) k3).B(null);
        }
    }

    @Override // com.tencent.mobileqq.hotpic.api.IHotPicApi
    @Nullable
    public File getDiskFile(@NotNull String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (File) iPatchRedirector.redirect((short) 3, (Object) this, (Object) url);
        }
        Intrinsics.checkNotNullParameter(url, "url");
        return b.getDiskFile(url);
    }

    @Override // com.tencent.mobileqq.hotpic.api.IHotPicApi
    @NotNull
    public String getDiskFilePath(@NotNull String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) url);
        }
        Intrinsics.checkNotNullParameter(url, "url");
        String b16 = b.b(url);
        Intrinsics.checkNotNullExpressionValue(b16, "getDishFilePath(url)");
        return b16;
    }

    @Override // com.tencent.mobileqq.hotpic.api.IHotPicApi
    @Nullable
    public Manager getHotPicManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Manager) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        return HotPicManager.k(peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null);
    }

    @Override // com.tencent.mobileqq.hotpic.api.IHotPicApi
    public int getHotPicRedDotStatus(@NotNull String uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, (Object) uin)).intValue();
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        return ShortVideoUtils.getHotPicRedDotStatus(uin) ? 1 : 0;
    }

    @Override // com.tencent.mobileqq.hotpic.api.IHotPicApi
    @NotNull
    public ArrayList<HotPicTagInfo> getHotPicTags(@Nullable Manager manager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (ArrayList) iPatchRedirector.redirect((short) 9, (Object) this, (Object) manager);
        }
        if (!(manager instanceof HotPicManager)) {
            QLog.i(TAG, 1, "getHotPicTags: is not hot pic manager");
            return new ArrayList<>();
        }
        ArrayList<HotPicTagInfo> p16 = ((HotPicManager) manager).p();
        Intrinsics.checkNotNullExpressionValue(p16, "manager.tags");
        return p16;
    }

    @Override // com.tencent.mobileqq.hotpic.api.IHotPicApi
    @Nullable
    public URL getHotPicURL(@NotNull String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (URL) iPatchRedirector.redirect((short) 2, (Object) this, (Object) url);
        }
        Intrinsics.checkNotNullParameter(url, "url");
        return h.f(url);
    }

    @Override // com.tencent.mobileqq.hotpic.api.IHotPicApi
    @NotNull
    public ArrayList<HotPicData> getHotPics(@Nullable Manager manager, int tagId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (ArrayList) iPatchRedirector.redirect((short) 20, (Object) this, (Object) manager, tagId);
        }
        if (!(manager instanceof HotPicManager)) {
            QLog.i(TAG, 1, "getHotPics: is not hot pic manager");
            return new ArrayList<>();
        }
        ArrayList<HotPicData> l3 = ((HotPicManager) manager).l(tagId);
        Intrinsics.checkNotNullExpressionValue(l3, "manager.getHotPics(tagId)");
        return l3;
    }

    @Override // com.tencent.mobileqq.hotpic.api.IHotPicApi
    public int getLastClickId(@Nullable Manager manager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this, (Object) manager)).intValue();
        }
        if (!(manager instanceof HotPicManager)) {
            QLog.i(TAG, 1, "getLastClickId: is not hot pic manager");
            return 0;
        }
        return ((HotPicManager) manager).M;
    }

    @Override // com.tencent.mobileqq.hotpic.api.IHotPicApi
    @NotNull
    public LinkedList<HotPicSendData> getRecentSendPics() {
        QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (LinkedList) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        Manager k3 = HotPicManager.k(qQAppInterface);
        if (!(k3 instanceof HotPicManager)) {
            QLog.i(TAG, 1, "getRecentSendPics: is not hot pic manager");
            return new LinkedList<>();
        }
        LinkedList<HotPicSendData> o16 = ((HotPicManager) k3).o();
        Intrinsics.checkNotNullExpressionValue(o16, "manager.recentSendPics");
        return o16;
    }

    @Override // com.tencent.mobileqq.hotpic.api.IHotPicApi
    @Nullable
    public URL getURL(@NotNull String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (URL) iPatchRedirector.redirect((short) 6, (Object) this, (Object) url);
        }
        Intrinsics.checkNotNullParameter(url, "url");
        return b.getURL(url);
    }

    @Override // com.tencent.mobileqq.hotpic.api.IHotPicApi
    public void initHotPicManager(@Nullable Manager manager, @NotNull f listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) manager, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (!(manager instanceof HotPicManager)) {
            QLog.i(TAG, 1, "initHotPicManager: is not hot pic manager");
            return;
        }
        HotPicManager hotPicManager = (HotPicManager) manager;
        hotPicManager.B(listener);
        hotPicManager.s();
        hotPicManager.u();
    }

    @Override // com.tencent.mobileqq.hotpic.api.IHotPicApi
    public boolean isNeedGuide() {
        QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        Manager k3 = HotPicManager.k(qQAppInterface);
        if (!(k3 instanceof HotPicManager)) {
            QLog.i(TAG, 1, "isNeedGuide: is not hot pic manager");
            return false;
        }
        return ((HotPicManager) k3).f236941f;
    }

    @Override // com.tencent.mobileqq.hotpic.api.IHotPicApi
    public void markGuide() {
        QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        Manager k3 = HotPicManager.k(qQAppInterface);
        if (!(k3 instanceof HotPicManager)) {
            QLog.i(TAG, 1, "markGuide: is not hot pic manager");
        } else {
            ((HotPicManager) k3).t();
        }
    }

    @Override // com.tencent.mobileqq.hotpic.api.IHotPicApi
    public void processData(@NotNull HotPicTagInfo hotPicTagInfo) {
        QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) hotPicTagInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(hotPicTagInfo, "hotPicTagInfo");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        Manager k3 = HotPicManager.k(qQAppInterface);
        if (!(k3 instanceof HotPicManager)) {
            QLog.i(TAG, 1, "processData: is not hot pic manager");
        } else {
            ((HotPicManager) k3).v(hotPicTagInfo);
        }
    }

    @Override // com.tencent.mobileqq.hotpic.api.IHotPicApi
    public void requestHotPicList(@Nullable Manager manager, int tagId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) manager, tagId);
            return;
        }
        Manager hotPicManager = getHotPicManager(manager);
        if (!(hotPicManager instanceof HotPicManager)) {
            QLog.i(TAG, 1, "requestHotPicList: is not hot pic manager");
        } else {
            ((HotPicManager) hotPicManager).y(tagId);
        }
    }

    private final Manager getHotPicManager(Manager manager) {
        if (manager != null) {
            return manager;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        return HotPicManager.k(peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null);
    }
}
