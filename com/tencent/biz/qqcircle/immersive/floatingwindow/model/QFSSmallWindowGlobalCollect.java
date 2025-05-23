package com.tencent.biz.qqcircle.immersive.floatingwindow.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Argus;
import com.tencent.biz.qcircleshadow.libmanager.QCircleListenerProxyManager;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.guild.config.GuildQUIProfileConfig;
import com.tencent.mobileqq.qcircle.api.event.QFSSceneChangeEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.argus.node.ArgusNode;
import com.tencent.richframework.argus.node.TabHostNode;
import com.tencent.richframework.argus.page.PageInfo;
import com.tencent.richframework.argus.page.PageInfoPO;
import com.tencent.richframework.argus.page.db.HistoryPageChange;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.scene.QFSSceneChangeProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSSmallWindowGlobalCollect implements SimpleEventReceiver, com.tencent.mobileqq.qcircle.api.a {
    private static volatile QFSSmallWindowGlobalCollect E;
    private static final Set<String> F;
    private static final Set<String> G;
    private static final Set<String> H;
    private static final Set<String> I;
    private static final Set<String> J;

    /* renamed from: e, reason: collision with root package name */
    private SmallWindowTask f86394e;

    /* renamed from: f, reason: collision with root package name */
    private PageInfo f86395f;

    /* renamed from: i, reason: collision with root package name */
    private b f86397i;

    /* renamed from: m, reason: collision with root package name */
    private c f86398m;

    /* renamed from: h, reason: collision with root package name */
    private String f86396h = "";
    private String C = "";
    private String D = "";

    /* renamed from: d, reason: collision with root package name */
    private final com.tencent.biz.qqcircle.immersive.floatingwindow.model.a f86393d = new com.tencent.biz.qqcircle.immersive.floatingwindow.model.a();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class SmallWindowTask implements Runnable {
        SmallWindowTask() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!QFSSmallWindowGlobalCollect.k().f86393d.g()) {
                QFSSmallWindowGlobalCollect.k().u(true, 2);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface b {
        void g(String str);
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface c {
        void p(String str);
    }

    static {
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        F = copyOnWriteArraySet;
        CopyOnWriteArraySet copyOnWriteArraySet2 = new CopyOnWriteArraySet();
        G = copyOnWriteArraySet2;
        CopyOnWriteArraySet copyOnWriteArraySet3 = new CopyOnWriteArraySet();
        H = copyOnWriteArraySet3;
        CopyOnWriteArraySet copyOnWriteArraySet4 = new CopyOnWriteArraySet();
        I = copyOnWriteArraySet4;
        CopyOnWriteArraySet copyOnWriteArraySet5 = new CopyOnWriteArraySet();
        J = copyOnWriteArraySet5;
        copyOnWriteArraySet.add("com.tencent.mobileqq.profilecard.fragment.FriendProfileCardFragment");
        copyOnWriteArraySet.add("com.tencent.mobileqq.guild.feed.gallery.GuildFeedGalleryFragment");
        copyOnWriteArraySet.add("com.tencent.mobileqq.minigame.publicaccount.hippy.MiniGamePAHippyFragment");
        copyOnWriteArraySet.add(GuildQUIProfileConfig.AIO_CLASS_NAME);
        copyOnWriteArraySet.add("com.tencent.biz.pubaccount.weishi.main.WSMainContainerFragment");
        copyOnWriteArraySet.add("com.tencent.mobileqq.activity.home.chats.troophelper.TroopHelperFragment");
        copyOnWriteArraySet.add("com.tencent.mobileqq.search.fragment.UniteSearchFragment");
        copyOnWriteArraySet.add("com.tencent.mobileqq.search.fragment.SearchEntryFragment");
        copyOnWriteArraySet.add("com.tencent.mobileqq.search.fragment.GroupSearchFragment");
        copyOnWriteArraySet2.add("com.tencent.mobileqq.guild.feed.webbundle.GuildFeedDetailWebBundleFragment");
        copyOnWriteArraySet2.add("com.tencent.mobileqq.newfriend.ui.fragment.NewFriendFragment");
        copyOnWriteArraySet2.add("com.tencent.mobileqq.troop.troopnotification.ui.TroopNotificationFragment");
        copyOnWriteArraySet2.add("com.tencent.mobileqq.qqlivehall.iv.QQLiveHallHippyFragment");
        copyOnWriteArraySet3.add("com.tencent.mobileqq.activity.contacts.base.Contacts");
        copyOnWriteArraySet3.add("com.tencent.mobileqq.activity.home.Conversation");
        copyOnWriteArraySet3.add("com.tencent.mobileqq.guild.mainframe.GuildFragmentDelegateFrame");
        copyOnWriteArraySet3.add("com.tencent.mobileqq.leba.Leba");
        copyOnWriteArraySet3.add("com.tencent.mobileqq.gamecenter.qa.metadream.MetaDreamFrame");
        copyOnWriteArraySet3.add("com.tencent.mobileqq.activity.leba.QzoneFrame");
        copyOnWriteArraySet3.add("com.tencent.mobileqq.activity.qcircle.QCircleFrame");
        copyOnWriteArraySet4.add("com.tencent.richframework.gallery.QQGalleryActivity");
        copyOnWriteArraySet4.add("com.tencent.mobileqq.guild.feed.gallery.GuildFeedGalleryFragment");
        copyOnWriteArraySet4.add("QZoneFeedxLayerFragment");
        copyOnWriteArraySet4.add("QZoneSingleVideoLayerFragment");
        copyOnWriteArraySet4.add("com.tencent.biz.pubaccount.weishi.main.WSMainContainerFragment");
        copyOnWriteArraySet5.add("com.tencent.mobileqq.guild.live.fragment.QQGuildLiveRoomFragment");
    }

    QFSSmallWindowGlobalCollect() {
        Argus.INSTANCE.registerComponentCallback(new a());
        QFSSceneChangeProxy.setRegisterSceneChangeEvent(true);
        SimpleEventBus.getInstance().registerReceiver(this);
        QCircleListenerProxyManager.getInstance().setSceneChangeCallback(this);
    }

    private void c() {
        if (this.f86394e != null) {
            RFWThreadManager.getUIHandler().removeCallbacks(this.f86394e);
        }
    }

    private void e(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        h(str);
        if (!G.contains(str) && !F.contains(str)) {
            if (H.contains(str)) {
                if (!TextUtils.equals(this.D, str)) {
                    QLog.d("QFP-QFSSmallWindowGlobalCollect", 1, "[handlerBeginScene] sceneName: " + str);
                    this.D = str;
                }
                x();
                return;
            }
            return;
        }
        c();
        k().u(false, 4);
    }

    private void f(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        g(str);
        if (G.contains(str)) {
            r(this.f86395f);
        } else if (F.contains(str) && !TextUtils.isEmpty(this.f86396h) && TextUtils.equals(this.f86396h, str)) {
            r(this.f86395f);
        }
    }

    private void g(String str) {
        if (!TextUtils.isEmpty(str) && I.contains(str)) {
            m(str);
        }
    }

    private void h(String str) {
        if (!TextUtils.isEmpty(str) && J.contains(str)) {
            n(str);
        }
    }

    private void i(QFSSceneChangeEvent qFSSceneChangeEvent) {
        if (qFSSceneChangeEvent.getSceneType() == 0) {
            e(qFSSceneChangeEvent.getSceneName());
        } else if (qFSSceneChangeEvent.getSceneType() == 1) {
            f(qFSSceneChangeEvent.getSceneName());
        }
    }

    public static QFSSmallWindowGlobalCollect k() {
        if (E == null) {
            synchronized (QFSSmallWindowGlobalCollect.class) {
                if (E == null) {
                    E = new QFSSmallWindowGlobalCollect();
                }
            }
        }
        return E;
    }

    private boolean l(PageInfo pageInfo) {
        Set<ArgusNode<?>> allVisibleNode;
        if (pageInfo == null) {
            allVisibleNode = null;
        } else {
            allVisibleNode = pageInfo.getAllVisibleNode();
        }
        if (allVisibleNode != null && !allVisibleNode.isEmpty()) {
            boolean z16 = false;
            boolean z17 = false;
            for (ArgusNode<?> argusNode : allVisibleNode) {
                if (argusNode instanceof TabHostNode) {
                    z16 = true;
                }
                String argusNode2 = argusNode.toString();
                Iterator<String> it = F.iterator();
                while (true) {
                    if (it.hasNext()) {
                        String next = it.next();
                        if (argusNode2.contains(next)) {
                            this.f86396h = next;
                            z17 = true;
                            break;
                        }
                    }
                }
            }
            this.f86395f = pageInfo;
            if (!z16 || z17) {
                return false;
            }
            return true;
        }
        return this.f86393d.g();
    }

    private void m(String str) {
        b bVar = this.f86397i;
        if (bVar == null) {
            return;
        }
        bVar.g(str);
    }

    private void n(String str) {
        c cVar = this.f86398m;
        if (cVar == null) {
            return;
        }
        cVar.p(str);
    }

    private void r(PageInfo pageInfo) {
        Set<ArgusNode<?>> allVisibleNode;
        if (pageInfo == null) {
            allVisibleNode = null;
        } else {
            allVisibleNode = pageInfo.getAllVisibleNode();
        }
        if (allVisibleNode != null && !allVisibleNode.isEmpty()) {
            boolean z16 = false;
            boolean z17 = false;
            boolean z18 = false;
            for (ArgusNode<?> argusNode : allVisibleNode) {
                if (argusNode instanceof TabHostNode) {
                    z17 = true;
                }
                String argusNode2 = argusNode.toString();
                Iterator<String> it = F.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (argusNode2.contains(it.next())) {
                            z18 = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (!this.f86393d.g()) {
                QLog.d("QFP-QFSSmallWindowGlobalCollect", 1, "[updateBlackPageArgusTop] isExistsHostBlock: " + z17 + " | isHasBlackList: " + z18);
                if (z17 && !z18) {
                    z16 = true;
                }
                u(z16, 3);
            }
        }
    }

    private void x() {
        if (this.f86394e == null) {
            this.f86394e = new SmallWindowTask();
        }
        RFWThreadManager.getUIHandler().removeCallbacks(this.f86394e);
        RFWThreadManager.getUIHandler().postDelayed(this.f86394e, 100L);
    }

    @Override // com.tencent.mobileqq.qcircle.api.a
    public void a(QFSSceneChangeEvent qFSSceneChangeEvent) {
        i(qFSSceneChangeEvent);
    }

    public com.tencent.biz.qqcircle.immersive.floatingwindow.model.a d() {
        return this.f86393d;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSSceneChangeEvent.class);
        return arrayList;
    }

    public void j(FrameFragment frameFragment) {
        this.f86393d.l(frameFragment);
        QLog.e("QFP-QFSSmallWindowGlobalCollect", 1, "[injectInitFrameFragment]");
    }

    public void o(int i3) {
        this.f86393d.h(i3);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSSceneChangeEvent) {
            i((QFSSceneChangeEvent) simpleBaseEvent);
        }
    }

    public void p(QCircleBaseFragment qCircleBaseFragment, String str) {
        this.f86393d.k(qCircleBaseFragment);
        this.f86393d.j(str);
        this.f86393d.i(false);
        if (!TextUtils.equals(this.C, str)) {
            QLog.d("QFP-QFSSmallWindowGlobalCollect", 1, "[recordCurrentFragment] daTongPageId: " + str);
            this.C = str;
        }
    }

    public void q(FrameFragment frameFragment, int i3, int i16) {
        this.f86393d.l(frameFragment);
        this.f86393d.m(i3);
        QLog.e("QFP-QFSSmallWindowGlobalCollect", 1, "[recordFrameState] preTabIndex: " + i3 + " | tabIndex: " + i16);
    }

    public void s(b bVar) {
        this.f86397i = bVar;
    }

    public void t(c cVar) {
        this.f86398m = cVar;
    }

    public void u(boolean z16, int i3) {
        this.f86393d.n(z16);
    }

    public boolean v(PageInfo pageInfo) {
        try {
            return l(pageInfo);
        } catch (Throwable th5) {
            QLog.d("QFP-QFSSmallWindowGlobalCollect", 4, "[tryIsPageArgusTopLayer] error: ", th5);
            return false;
        }
    }

    public void w() {
        this.f86393d.i(true);
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements Argus.ComponentCallback {
        a() {
        }

        @Override // androidx.fragment.app.Argus.ComponentCallback
        public void onPageChange(@Nullable PageInfo pageInfo, @Nullable PageInfoPO pageInfoPO, @NonNull PageInfo pageInfo2, @NonNull PageInfoPO pageInfoPO2, @Nullable PageInfoPO pageInfoPO3, @NonNull Argus.MergeResult mergeResult) {
            QFSSmallWindowGlobalCollect.k().u(QFSSmallWindowGlobalCollect.k().v(pageInfo2), 1);
        }

        @Override // androidx.fragment.app.Argus.ComponentCallback
        public void onPredictResult(@Nullable PageInfo pageInfo, @NonNull List<? extends HistoryPageChange> list) {
        }
    }
}
