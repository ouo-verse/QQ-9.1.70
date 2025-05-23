package com.qzone.luan;

import com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment;
import com.qzone.album.business.albumlist.fragment.AlbumListTabFragment;
import com.qzone.album.business.albumlist.fragment.AlbumRecentTabFragment;
import com.qzone.album.business.albumlist.fragment.AlbumVideoTabFragment;
import com.qzone.album.ui.widget.QzoneSwipPullRefreshListView;
import com.qzone.common.activities.base.BaseFeedFragmentContainerImp;
import com.qzone.common.activities.base.BaseFeedFragmentDropDownImp;
import com.qzone.common.activities.base.BaseFeedFragmentEventImp;
import com.qzone.common.activities.base.BaseFeedFragmentFeedImp;
import com.qzone.common.activities.base.BaseFeedFragmentFeedPresenterImp;
import com.qzone.common.activities.base.BaseFragment;
import com.qzone.common.activities.base.BaseFragmentContainerImp;
import com.qzone.common.activities.base.BaseFragmentFootBannerImp;
import com.qzone.common.activities.base.CustomListViewFragment;
import com.qzone.common.activities.base.PhotoActivity;
import com.qzone.common.activities.base.QZoneBaseFeedFragment;
import com.qzone.common.activities.base.QZoneTitleBarFragment;
import com.qzone.feed.ui.activity.EmptyFragment;
import com.qzone.feed.ui.activity.QZoneMyFeedFragment;
import com.qzone.proxy.feedcomponent.FeedEnvImpl;
import com.qzone.publish.ui.activity.QZonePublishMoodActivity;
import com.qzone.publish.ui.activity.QZonePublishMoodBaseActivity;
import com.qzone.publish.ui.activity.QZonePublishMoodNewStyleActivity;
import com.qzone.publish.ui.activity.QZoneUploadPhotoActivity;
import com.qzone.widget.QZoneHomePageListView;
import com.qzone.widget.QZonePullToRefreshListView;
import com.qzone.widget.QZoneXPullToRefreshListView;
import com.tencent.luan.ioc.AbstractInjectConstructor;
import com.tencent.luan.ioc.EmptyInjectMethod;
import com.tencent.luan.ioc.InjectConstructor;
import com.tencent.luan.ioc.InjectMethod;
import com.tencent.luan.ioc.Injector;
import com.tencent.luan.ioc.LuanInjectService;
import com.tencent.luan.ioc.ProvideMethod;
import com.tencent.luan.ioc.index.IndexInjectInfoService;
import com.tencent.pubaccount.publish.QQPublicAccountPublishFeedFragment;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class LuanIndexInjectInfoService implements IndexInjectInfoService {
    private final Map<Class<?>, InjectConstructor<?>> classInjectConstructorMap;
    private final Map<Class<?>, InjectMethod> classInjectMethodsMap;
    private final Map<Class<?>, List<ProvideMethod<?>>> classProvideMethodsMap;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements InjectMethod {
        a() {
        }

        @Override // com.tencent.luan.ioc.InjectMethod
        public void invoke(Object obj, Injector injector) {
            ((com.qzone.common.activities.base.o) obj).setContainer((d5.u) injector.getOrCreateObject(d5.u.class));
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class aa implements InjectMethod {
        aa() {
        }

        @Override // com.tencent.luan.ioc.InjectMethod
        public void invoke(Object obj, Injector injector) {
            QZoneHomePageListView qZoneHomePageListView = (QZoneHomePageListView) obj;
            qZoneHomePageListView.setCoverInf((d5.e) injector.getOrCreateObject("PullToRefreshListViewCoverImp"));
            qZoneHomePageListView.setToastInf((d5.ae) injector.getOrCreateObject("BaseFragmentToastImp"));
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class ab implements InjectMethod {
        ab() {
        }

        @Override // com.tencent.luan.ioc.InjectMethod
        public void invoke(Object obj, Injector injector) {
            QzoneSwipPullRefreshListView qzoneSwipPullRefreshListView = (QzoneSwipPullRefreshListView) obj;
            qzoneSwipPullRefreshListView.setCoverInf((d5.e) injector.getOrCreateObject("PullToRefreshListViewCoverImp"));
            qzoneSwipPullRefreshListView.setToastInf((d5.ae) injector.getOrCreateObject("BaseFragmentToastImp"));
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class ac implements InjectMethod {
        ac() {
        }

        @Override // com.tencent.luan.ioc.InjectMethod
        public void invoke(Object obj, Injector injector) {
            QZoneXPullToRefreshListView qZoneXPullToRefreshListView = (QZoneXPullToRefreshListView) obj;
            qZoneXPullToRefreshListView.setCoverInf((d5.e) injector.getOrCreateObject("PullToRefreshListViewCoverImp"));
            qZoneXPullToRefreshListView.setToastInf((d5.ae) injector.getOrCreateObject("BaseFragmentToastImp"));
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class ad extends AbstractInjectConstructor<FeedEnvImpl> {
        ad(Class cls, int i3) {
            super(cls, i3);
        }

        @Override // com.tencent.luan.ioc.InjectConstructor
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public FeedEnvImpl newInstance(Injector injector) {
            return new FeedEnvImpl();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class ae extends AbstractInjectConstructor<com.qzone.proxy.feedcomponent.f> {
        ae(Class cls, int i3) {
            super(cls, i3);
        }

        @Override // com.tencent.luan.ioc.InjectConstructor
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.qzone.proxy.feedcomponent.f newInstance(Injector injector) {
            return new com.qzone.proxy.feedcomponent.f();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class af extends AbstractInjectConstructor<com.qzone.proxy.feedcomponent.g> {
        af(Class cls, int i3) {
            super(cls, i3);
        }

        @Override // com.tencent.luan.ioc.InjectConstructor
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.qzone.proxy.feedcomponent.g newInstance(Injector injector) {
            return new com.qzone.proxy.feedcomponent.g();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class ag implements InjectMethod {
        ag() {
        }

        @Override // com.tencent.luan.ioc.InjectMethod
        public void invoke(Object obj, Injector injector) {
            QZoneBaseFeedFragment qZoneBaseFeedFragment = (QZoneBaseFeedFragment) obj;
            qZoneBaseFeedFragment.setEventInf((d5.i) injector.getOrCreateObject(BaseFeedFragmentEventImp.class));
            qZoneBaseFeedFragment.setRecommendFriendInf((d5.aa) injector.getOrCreateObject("BaseFeedFragmentRecommendFriendImp"));
            qZoneBaseFeedFragment.setPushInf((d5.y) injector.getOrCreateObject("BaseFeedFragmentPushImp"));
            qZoneBaseFeedFragment.setJumpInf((d5.t) injector.getOrCreateObject("BaseFeedFragmentJumpImp"));
            qZoneBaseFeedFragment.setFavorInf((d5.j) injector.getOrCreateObject("BaseFeedFragmentFavorImp"));
            qZoneBaseFeedFragment.setSchemeInf((d5.ac) injector.getOrCreateObject("BaseFeedFragmentSchemeImp"));
            qZoneBaseFeedFragment.setShareInf((d5.ad) injector.getOrCreateObject("BaseFeedFragmentShareImp"));
            qZoneBaseFeedFragment.setQDialogInf((d5.z) injector.getOrCreateObject("BaseFeedFragmentQDialogImp"));
            qZoneBaseFeedFragment.setForbiddenViewInf((d5.q) injector.getOrCreateObject("BaseFeedFragmentForbiddenViewImp"));
            qZoneBaseFeedFragment.setPopupWindowInf((d5.h) injector.getOrCreateObject("BaseFeedFragmentDropDownImp"));
            qZoneBaseFeedFragment.setCoverInf((d5.e) injector.getOrCreateObject("BaseFeedFragmentCoverImp"));
            qZoneBaseFeedFragment.setFeedPresenterInf((d5.o) injector.getOrCreateObject(BaseFeedFragmentFeedPresenterImp.class));
            qZoneBaseFeedFragment.setImageInf((d5.s) injector.getOrCreateObject("BaseFeedFragmentImageImp"));
            qZoneBaseFeedFragment.setAlbumInf((d5.a) injector.getOrCreateObject("BaseFeedFragmentAlbumImp"));
            qZoneBaseFeedFragment.setAudioInf((d5.b) injector.getOrCreateObject("BaseFeedFragmentAudioImp"));
            qZoneBaseFeedFragment.setWeiShiInf((d5.ag) injector.getOrCreateObject("BaseFeedFragmentWeiShiImp"));
            qZoneBaseFeedFragment.setFeedInf((d5.l) injector.getOrCreateObject(BaseFeedFragmentFeedImp.class));
            qZoneBaseFeedFragment.setContainerInf((d5.u) injector.getOrCreateObject(BaseFeedFragmentContainerImp.class));
            qZoneBaseFeedFragment.setDateInf((d5.f) injector.getOrCreateObject("CustomListViewFragmentDateImp"));
            qZoneBaseFeedFragment.setPublishQueueInf((d5.x) injector.getOrCreateObject("CustomListViewFragmentPublishQueueImp"));
            qZoneBaseFeedFragment.setFootBannerInf((d5.p) injector.getOrCreateObject(BaseFragmentFootBannerImp.class));
            qZoneBaseFeedFragment.setPageDataInf((d5.v) injector.getOrCreateObject("BaseFragmentPageDataImp"));
            qZoneBaseFeedFragment.setConfigInf((d5.c) injector.getOrCreateObject("BaseFragmentConfigImp"));
            qZoneBaseFeedFragment.setVideoWindowPlayInf((d5.af) injector.getOrCreateObject("BaseFragmentVideoWindowPlayImp"));
            qZoneBaseFeedFragment.setToastInf((d5.ae) injector.getOrCreateObject("BaseFragmentToastImp"));
            qZoneBaseFeedFragment.setReporterInf((d5.ab) injector.getOrCreateObject("BaseFragmentReporter"));
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class ah extends AbstractInjectConstructor<com.qzone.widget.j> {
        ah(Class cls, int i3) {
            super(cls, i3);
        }

        @Override // com.tencent.luan.ioc.InjectConstructor
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.qzone.widget.j newInstance(Injector injector) {
            return new com.qzone.widget.j();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class ai extends AbstractInjectConstructor<com.qzone.common.activities.base.ae> {
        ai(Class cls, int i3) {
            super(cls, i3);
        }

        @Override // com.tencent.luan.ioc.InjectConstructor
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.qzone.common.activities.base.ae newInstance(Injector injector) {
            return new com.qzone.common.activities.base.ae();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class aj extends AbstractInjectConstructor<com.qzone.common.activities.base.q> {
        aj(Class cls, int i3) {
            super(cls, i3);
        }

        @Override // com.tencent.luan.ioc.InjectConstructor
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.qzone.common.activities.base.q newInstance(Injector injector) {
            return new com.qzone.common.activities.base.q();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class ak extends AbstractInjectConstructor<com.qzone.common.activities.base.m> {
        ak(Class cls, int i3) {
            super(cls, i3);
        }

        @Override // com.tencent.luan.ioc.InjectConstructor
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.qzone.common.activities.base.m newInstance(Injector injector) {
            return new com.qzone.common.activities.base.m();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class al extends AbstractInjectConstructor<com.qzone.common.activities.base.u> {
        al(Class cls, int i3) {
            super(cls, i3);
        }

        @Override // com.tencent.luan.ioc.InjectConstructor
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.qzone.common.activities.base.u newInstance(Injector injector) {
            return new com.qzone.common.activities.base.u();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class am extends AbstractInjectConstructor<com.qzone.common.activities.base.w> {
        am(Class cls, int i3) {
            super(cls, i3);
        }

        @Override // com.tencent.luan.ioc.InjectConstructor
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.qzone.common.activities.base.w newInstance(Injector injector) {
            return new com.qzone.common.activities.base.w();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class an extends AbstractInjectConstructor<com.qzone.common.activities.base.af> {
        an(Class cls, int i3) {
            super(cls, i3);
        }

        @Override // com.tencent.luan.ioc.InjectConstructor
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.qzone.common.activities.base.af newInstance(Injector injector) {
            return new com.qzone.common.activities.base.af();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class ao extends AbstractInjectConstructor<com.qzone.common.activities.base.ag> {
        ao(Class cls, int i3) {
            super(cls, i3);
        }

        @Override // com.tencent.luan.ioc.InjectConstructor
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.qzone.common.activities.base.ag newInstance(Injector injector) {
            return new com.qzone.common.activities.base.ag();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class ap extends AbstractInjectConstructor<com.qzone.common.activities.base.v> {
        ap(Class cls, int i3) {
            super(cls, i3);
        }

        @Override // com.tencent.luan.ioc.InjectConstructor
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.qzone.common.activities.base.v newInstance(Injector injector) {
            return new com.qzone.common.activities.base.v();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class aq extends AbstractInjectConstructor<com.qzone.common.activities.base.p> {
        aq(Class cls, int i3) {
            super(cls, i3);
        }

        @Override // com.tencent.luan.ioc.InjectConstructor
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.qzone.common.activities.base.p newInstance(Injector injector) {
            return new com.qzone.common.activities.base.p();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class ar implements InjectMethod {
        ar() {
        }

        @Override // com.tencent.luan.ioc.InjectMethod
        public void invoke(Object obj, Injector injector) {
            BaseFragment baseFragment = (BaseFragment) obj;
            baseFragment.setContainerInf((d5.u) injector.getOrCreateObject(BaseFragmentContainerImp.class));
            baseFragment.setFootBannerInf((d5.p) injector.getOrCreateObject(BaseFragmentFootBannerImp.class));
            baseFragment.setPageDataInf((d5.v) injector.getOrCreateObject("BaseFragmentPageDataImp"));
            baseFragment.setConfigInf((d5.c) injector.getOrCreateObject("BaseFragmentConfigImp"));
            baseFragment.setVideoWindowPlayInf((d5.af) injector.getOrCreateObject("BaseFragmentVideoWindowPlayImp"));
            baseFragment.setToastInf((d5.ae) injector.getOrCreateObject("BaseFragmentToastImp"));
            baseFragment.setReporterInf((d5.ab) injector.getOrCreateObject("BaseFragmentReporter"));
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class as extends AbstractInjectConstructor<BaseFeedFragmentFeedImp> {
        as(Class cls, int i3) {
            super(cls, i3);
        }

        @Override // com.tencent.luan.ioc.InjectConstructor
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BaseFeedFragmentFeedImp newInstance(Injector injector) {
            return new BaseFeedFragmentFeedImp();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class at extends AbstractInjectConstructor<com.qzone.common.activities.base.ab> {
        at(Class cls, int i3) {
            super(cls, i3);
        }

        @Override // com.tencent.luan.ioc.InjectConstructor
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.qzone.common.activities.base.ab newInstance(Injector injector) {
            return new com.qzone.common.activities.base.ab();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class au extends AbstractInjectConstructor<com.qzone.common.activities.base.ad> {
        au(Class cls, int i3) {
            super(cls, i3);
        }

        @Override // com.tencent.luan.ioc.InjectConstructor
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.qzone.common.activities.base.ad newInstance(Injector injector) {
            return new com.qzone.common.activities.base.ad();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class av extends AbstractInjectConstructor<com.qzone.common.activities.base.t> {
        av(Class cls, int i3) {
            super(cls, i3);
        }

        @Override // com.tencent.luan.ioc.InjectConstructor
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.qzone.common.activities.base.t newInstance(Injector injector) {
            return new com.qzone.common.activities.base.t();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class aw extends AbstractInjectConstructor<BaseFragmentContainerImp> {
        aw(Class cls, int i3) {
            super(cls, i3);
        }

        @Override // com.tencent.luan.ioc.InjectConstructor
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BaseFragmentContainerImp newInstance(Injector injector) {
            return new BaseFragmentContainerImp((BaseFragment) injector.getOrCreateObject(BaseFragment.class));
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class ax extends AbstractInjectConstructor<com.qzone.common.activities.base.n> {
        ax(Class cls, int i3) {
            super(cls, i3);
        }

        @Override // com.tencent.luan.ioc.InjectConstructor
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.qzone.common.activities.base.n newInstance(Injector injector) {
            return new com.qzone.common.activities.base.n();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class ay extends AbstractInjectConstructor<com.qzone.common.activities.base.r> {
        ay(Class cls, int i3) {
            super(cls, i3);
        }

        @Override // com.tencent.luan.ioc.InjectConstructor
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.qzone.common.activities.base.r newInstance(Injector injector) {
            return new com.qzone.common.activities.base.r();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class az extends AbstractInjectConstructor<com.qzone.common.activities.base.o> {
        az(Class cls, int i3) {
            super(cls, i3);
        }

        @Override // com.tencent.luan.ioc.InjectConstructor
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.qzone.common.activities.base.o newInstance(Injector injector) {
            return new com.qzone.common.activities.base.o();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b implements InjectMethod {
        b() {
        }

        @Override // com.tencent.luan.ioc.InjectMethod
        public void invoke(Object obj, Injector injector) {
            ((BaseFragmentFootBannerImp) obj).setContainer((d5.u) injector.getOrCreateObject(d5.u.class));
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class ba extends AbstractInjectConstructor<com.qzone.common.activities.base.l> {
        ba(Class cls, int i3) {
            super(cls, i3);
        }

        @Override // com.tencent.luan.ioc.InjectConstructor
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.qzone.common.activities.base.l newInstance(Injector injector) {
            return new com.qzone.common.activities.base.l();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class bb extends AbstractInjectConstructor<BaseFragmentFootBannerImp> {
        bb(Class cls, int i3) {
            super(cls, i3);
        }

        @Override // com.tencent.luan.ioc.InjectConstructor
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BaseFragmentFootBannerImp newInstance(Injector injector) {
            return new BaseFragmentFootBannerImp();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class bc implements InjectMethod {
        bc() {
        }

        @Override // com.tencent.luan.ioc.InjectMethod
        public void invoke(Object obj, Injector injector) {
            ((com.qzone.common.activities.base.v) obj).setContainer((d5.u) injector.getOrCreateObject(d5.u.class));
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class bd extends AbstractInjectConstructor<com.qzone.common.activities.base.ah> {
        bd(Class cls, int i3) {
            super(cls, i3);
        }

        @Override // com.tencent.luan.ioc.InjectConstructor
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.qzone.common.activities.base.ah newInstance(Injector injector) {
            return new com.qzone.common.activities.base.ah();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class be extends AbstractInjectConstructor<BaseFeedFragmentEventImp> {
        be(Class cls, int i3) {
            super(cls, i3);
        }

        @Override // com.tencent.luan.ioc.InjectConstructor
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BaseFeedFragmentEventImp newInstance(Injector injector) {
            return new BaseFeedFragmentEventImp((QZoneBaseFeedFragment) injector.getOrCreateObject(QZoneBaseFeedFragment.class));
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class bf extends AbstractInjectConstructor<BaseFeedFragmentDropDownImp> {
        bf(Class cls, int i3) {
            super(cls, i3);
        }

        @Override // com.tencent.luan.ioc.InjectConstructor
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BaseFeedFragmentDropDownImp newInstance(Injector injector) {
            return new BaseFeedFragmentDropDownImp();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class bg extends AbstractInjectConstructor<com.qzone.common.activities.base.x> {
        bg(Class cls, int i3) {
            super(cls, i3);
        }

        @Override // com.tencent.luan.ioc.InjectConstructor
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.qzone.common.activities.base.x newInstance(Injector injector) {
            return new com.qzone.common.activities.base.x();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class bh extends AbstractInjectConstructor<BaseFeedFragmentContainerImp> {
        bh(Class cls, int i3) {
            super(cls, i3);
        }

        @Override // com.tencent.luan.ioc.InjectConstructor
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BaseFeedFragmentContainerImp newInstance(Injector injector) {
            return new BaseFeedFragmentContainerImp((QZoneBaseFeedFragment) injector.getOrCreateObject(QZoneBaseFeedFragment.class));
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class bi extends AbstractInjectConstructor<BaseFeedFragmentFeedPresenterImp> {
        bi(Class cls, int i3) {
            super(cls, i3);
        }

        @Override // com.tencent.luan.ioc.InjectConstructor
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BaseFeedFragmentFeedPresenterImp newInstance(Injector injector) {
            return new BaseFeedFragmentFeedPresenterImp();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class bj extends AbstractInjectConstructor<com.qzone.common.activities.base.ac> {
        bj(Class cls, int i3) {
            super(cls, i3);
        }

        @Override // com.tencent.luan.ioc.InjectConstructor
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.qzone.common.activities.base.ac newInstance(Injector injector) {
            return new com.qzone.common.activities.base.ac();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class bk extends AbstractInjectConstructor<com.qzone.common.activities.base.s> {
        bk(Class cls, int i3) {
            super(cls, i3);
        }

        @Override // com.tencent.luan.ioc.InjectConstructor
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.qzone.common.activities.base.s newInstance(Injector injector) {
            return new com.qzone.common.activities.base.s();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class bl extends AbstractInjectConstructor<com.qzone.feed.ui.activity.c> {
        bl(Class cls, int i3) {
            super(cls, i3);
        }

        @Override // com.tencent.luan.ioc.InjectConstructor
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.qzone.feed.ui.activity.c newInstance(Injector injector) {
            return new com.qzone.feed.ui.activity.c();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class bm extends AbstractInjectConstructor<com.qzone.feed.ui.activity.b> {
        bm(Class cls, int i3) {
            super(cls, i3);
        }

        @Override // com.tencent.luan.ioc.InjectConstructor
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.qzone.feed.ui.activity.b newInstance(Injector injector) {
            return new com.qzone.feed.ui.activity.b();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class bn implements InjectMethod {
        bn() {
        }

        @Override // com.tencent.luan.ioc.InjectMethod
        public void invoke(Object obj, Injector injector) {
            ((com.qzone.common.activities.base.p) obj).setContainer((d5.u) injector.getOrCreateObject(d5.u.class));
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class bo extends AbstractInjectConstructor<com.qzone.feed.ui.activity.a> {
        bo(Class cls, int i3) {
            super(cls, i3);
        }

        @Override // com.tencent.luan.ioc.InjectConstructor
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.qzone.feed.ui.activity.a newInstance(Injector injector) {
            return new com.qzone.feed.ui.activity.a();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class bp extends AbstractInjectConstructor<com.qzone.feed.ui.activity.d> {
        bp(Class cls, int i3) {
            super(cls, i3);
        }

        @Override // com.tencent.luan.ioc.InjectConstructor
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.qzone.feed.ui.activity.d newInstance(Injector injector) {
            return new com.qzone.feed.ui.activity.d();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class bq implements InjectMethod {
        bq() {
        }

        @Override // com.tencent.luan.ioc.InjectMethod
        public void invoke(Object obj, Injector injector) {
            ((BaseFeedFragmentFeedImp) obj).setContainer((d5.u) injector.getOrCreateObject(d5.u.class));
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class br implements InjectMethod {
        br() {
        }

        @Override // com.tencent.luan.ioc.InjectMethod
        public void invoke(Object obj, Injector injector) {
            com.qzone.common.activities.base.t tVar = (com.qzone.common.activities.base.t) obj;
            tVar.setContainer((d5.u) injector.getOrCreateObject(d5.u.class));
            tVar.setFavorInf((d5.j) injector.getOrCreateObject("BaseFeedFragmentFavorImp"));
            tVar.setFeedPresenterInf((d5.o) injector.getOrCreateObject(d5.o.class));
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class bs implements InjectMethod {
        bs() {
        }

        @Override // com.tencent.luan.ioc.InjectMethod
        public void invoke(Object obj, Injector injector) {
            com.qzone.common.activities.base.r rVar = (com.qzone.common.activities.base.r) obj;
            rVar.setContainer((d5.u) injector.getOrCreateObject(d5.u.class));
            rVar.setConfigInf((d5.c) injector.getOrCreateObject("BaseFragmentConfigImp"));
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class c implements InjectMethod {
        c() {
        }

        @Override // com.tencent.luan.ioc.InjectMethod
        public void invoke(Object obj, Injector injector) {
            CustomListViewFragment customListViewFragment = (CustomListViewFragment) obj;
            customListViewFragment.setDateInf((d5.f) injector.getOrCreateObject("CustomListViewFragmentDateImp"));
            customListViewFragment.setPublishQueueInf((d5.x) injector.getOrCreateObject("CustomListViewFragmentPublishQueueImp"));
            customListViewFragment.setContainerInf((d5.u) injector.getOrCreateObject(BaseFragmentContainerImp.class));
            customListViewFragment.setFootBannerInf((d5.p) injector.getOrCreateObject(BaseFragmentFootBannerImp.class));
            customListViewFragment.setPageDataInf((d5.v) injector.getOrCreateObject("BaseFragmentPageDataImp"));
            customListViewFragment.setConfigInf((d5.c) injector.getOrCreateObject("BaseFragmentConfigImp"));
            customListViewFragment.setVideoWindowPlayInf((d5.af) injector.getOrCreateObject("BaseFragmentVideoWindowPlayImp"));
            customListViewFragment.setToastInf((d5.ae) injector.getOrCreateObject("BaseFragmentToastImp"));
            customListViewFragment.setReporterInf((d5.ab) injector.getOrCreateObject("BaseFragmentReporter"));
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class d implements InjectMethod {
        d() {
        }

        @Override // com.tencent.luan.ioc.InjectMethod
        public void invoke(Object obj, Injector injector) {
            ((BaseFeedFragmentEventImp) obj).setFeedInf((d5.l) injector.getOrCreateObject(d5.l.class));
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class e implements InjectMethod {
        e() {
        }

        @Override // com.tencent.luan.ioc.InjectMethod
        public void invoke(Object obj, Injector injector) {
            BaseFeedFragmentDropDownImp baseFeedFragmentDropDownImp = (BaseFeedFragmentDropDownImp) obj;
            baseFeedFragmentDropDownImp.setContainer((d5.u) injector.getOrCreateObject(d5.u.class));
            baseFeedFragmentDropDownImp.setConfigInf((d5.c) injector.getOrCreateObject("BaseFragmentConfigImp"));
            baseFeedFragmentDropDownImp.setFavorInf((d5.j) injector.getOrCreateObject("BaseFeedFragmentFavorImp"));
            baseFeedFragmentDropDownImp.setJumpInf((d5.t) injector.getOrCreateObject("BaseFeedFragmentJumpImp"));
            baseFeedFragmentDropDownImp.setEventInf((d5.i) injector.getOrCreateObject(d5.i.class));
            baseFeedFragmentDropDownImp.setToastInf((d5.ae) injector.getOrCreateObject("BaseFragmentToastImp"));
            baseFeedFragmentDropDownImp.setSchemeInf((d5.ac) injector.getOrCreateObject("BaseFeedFragmentSchemeImp"));
            baseFeedFragmentDropDownImp.setBaseFeedPresenterImp((BaseFeedFragmentFeedPresenterImp) injector.getOrCreateObject(BaseFeedFragmentFeedPresenterImp.class));
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class f implements InjectMethod {
        f() {
        }

        @Override // com.tencent.luan.ioc.InjectMethod
        public void invoke(Object obj, Injector injector) {
            ((com.qzone.common.activities.base.x) obj).setContainer((d5.u) injector.getOrCreateObject(d5.u.class));
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class g implements InjectMethod {
        g() {
        }

        @Override // com.tencent.luan.ioc.InjectMethod
        public void invoke(Object obj, Injector injector) {
            ((BaseFeedFragmentFeedPresenterImp) obj).setContainer((d5.u) injector.getOrCreateObject(d5.u.class));
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class h implements InjectMethod {
        h() {
        }

        @Override // com.tencent.luan.ioc.InjectMethod
        public void invoke(Object obj, Injector injector) {
            ((com.qzone.common.activities.base.ac) obj).setFootBannerInf((d5.p) injector.getOrCreateObject(d5.p.class));
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class i implements InjectMethod {
        i() {
        }

        @Override // com.tencent.luan.ioc.InjectMethod
        public void invoke(Object obj, Injector injector) {
            com.qzone.common.activities.base.s sVar = (com.qzone.common.activities.base.s) obj;
            sVar.setContainer((d5.u) injector.getOrCreateObject(d5.u.class));
            sVar.setConfig((d5.c) injector.getOrCreateObject("BaseFragmentConfigImp"));
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class j implements InjectMethod {
        j() {
        }

        @Override // com.tencent.luan.ioc.InjectMethod
        public void invoke(Object obj, Injector injector) {
            QZoneMyFeedFragment qZoneMyFeedFragment = (QZoneMyFeedFragment) obj;
            qZoneMyFeedFragment.setReporterInf((d5.ab) injector.getOrCreateObject("MyFeedFragmentReporter"));
            qZoneMyFeedFragment.setForbiddenViewInf((d5.q) injector.getOrCreateObject("MyFeedFragmentForbiddenViewImp"));
            qZoneMyFeedFragment.setFeedPresenterInf((d5.o) injector.getOrCreateObject(com.qzone.feed.ui.activity.b.class));
            qZoneMyFeedFragment.setEventInf((d5.i) injector.getOrCreateObject(BaseFeedFragmentEventImp.class));
            qZoneMyFeedFragment.setRecommendFriendInf((d5.aa) injector.getOrCreateObject("BaseFeedFragmentRecommendFriendImp"));
            qZoneMyFeedFragment.setPushInf((d5.y) injector.getOrCreateObject("BaseFeedFragmentPushImp"));
            qZoneMyFeedFragment.setJumpInf((d5.t) injector.getOrCreateObject("BaseFeedFragmentJumpImp"));
            qZoneMyFeedFragment.setFavorInf((d5.j) injector.getOrCreateObject("BaseFeedFragmentFavorImp"));
            qZoneMyFeedFragment.setSchemeInf((d5.ac) injector.getOrCreateObject("BaseFeedFragmentSchemeImp"));
            qZoneMyFeedFragment.setShareInf((d5.ad) injector.getOrCreateObject("BaseFeedFragmentShareImp"));
            qZoneMyFeedFragment.setQDialogInf((d5.z) injector.getOrCreateObject("BaseFeedFragmentQDialogImp"));
            qZoneMyFeedFragment.setPopupWindowInf((d5.h) injector.getOrCreateObject("BaseFeedFragmentDropDownImp"));
            qZoneMyFeedFragment.setCoverInf((d5.e) injector.getOrCreateObject("BaseFeedFragmentCoverImp"));
            qZoneMyFeedFragment.setImageInf((d5.s) injector.getOrCreateObject("BaseFeedFragmentImageImp"));
            qZoneMyFeedFragment.setAlbumInf((d5.a) injector.getOrCreateObject("BaseFeedFragmentAlbumImp"));
            qZoneMyFeedFragment.setAudioInf((d5.b) injector.getOrCreateObject("BaseFeedFragmentAudioImp"));
            qZoneMyFeedFragment.setWeiShiInf((d5.ag) injector.getOrCreateObject("BaseFeedFragmentWeiShiImp"));
            qZoneMyFeedFragment.setFeedInf((d5.l) injector.getOrCreateObject(BaseFeedFragmentFeedImp.class));
            qZoneMyFeedFragment.setContainerInf((d5.u) injector.getOrCreateObject(BaseFeedFragmentContainerImp.class));
            qZoneMyFeedFragment.setDateInf((d5.f) injector.getOrCreateObject("CustomListViewFragmentDateImp"));
            qZoneMyFeedFragment.setPublishQueueInf((d5.x) injector.getOrCreateObject("CustomListViewFragmentPublishQueueImp"));
            qZoneMyFeedFragment.setFootBannerInf((d5.p) injector.getOrCreateObject(BaseFragmentFootBannerImp.class));
            qZoneMyFeedFragment.setPageDataInf((d5.v) injector.getOrCreateObject("BaseFragmentPageDataImp"));
            qZoneMyFeedFragment.setConfigInf((d5.c) injector.getOrCreateObject("BaseFragmentConfigImp"));
            qZoneMyFeedFragment.setVideoWindowPlayInf((d5.af) injector.getOrCreateObject("BaseFragmentVideoWindowPlayImp"));
            qZoneMyFeedFragment.setToastInf((d5.ae) injector.getOrCreateObject("BaseFragmentToastImp"));
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class k implements InjectMethod {
        k() {
        }

        @Override // com.tencent.luan.ioc.InjectMethod
        public void invoke(Object obj, Injector injector) {
            QZonePullToRefreshListView qZonePullToRefreshListView = (QZonePullToRefreshListView) obj;
            qZonePullToRefreshListView.setCoverInf((d5.e) injector.getOrCreateObject("PullToRefreshListViewCoverImp"));
            qZonePullToRefreshListView.setToastInf((d5.ae) injector.getOrCreateObject("BaseFragmentToastImp"));
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class l implements InjectMethod {
        l() {
        }

        @Override // com.tencent.luan.ioc.InjectMethod
        public void invoke(Object obj, Injector injector) {
            ((com.qzone.feed.ui.activity.c) obj).setContainer((d5.u) injector.getOrCreateObject(d5.u.class));
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class m implements InjectMethod {
        m() {
        }

        @Override // com.tencent.luan.ioc.InjectMethod
        public void invoke(Object obj, Injector injector) {
            ((com.qzone.feed.ui.activity.b) obj).setContainer((d5.u) injector.getOrCreateObject(d5.u.class));
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class n implements InjectMethod {
        n() {
        }

        @Override // com.tencent.luan.ioc.InjectMethod
        public void invoke(Object obj, Injector injector) {
            QQPublicAccountPublishFeedFragment qQPublicAccountPublishFeedFragment = (QQPublicAccountPublishFeedFragment) obj;
            qQPublicAccountPublishFeedFragment.setContainerInf((d5.u) injector.getOrCreateObject(BaseFragmentContainerImp.class));
            qQPublicAccountPublishFeedFragment.setFootBannerInf((d5.p) injector.getOrCreateObject(BaseFragmentFootBannerImp.class));
            qQPublicAccountPublishFeedFragment.setPageDataInf((d5.v) injector.getOrCreateObject("BaseFragmentPageDataImp"));
            qQPublicAccountPublishFeedFragment.setConfigInf((d5.c) injector.getOrCreateObject("BaseFragmentConfigImp"));
            qQPublicAccountPublishFeedFragment.setVideoWindowPlayInf((d5.af) injector.getOrCreateObject("BaseFragmentVideoWindowPlayImp"));
            qQPublicAccountPublishFeedFragment.setToastInf((d5.ae) injector.getOrCreateObject("BaseFragmentToastImp"));
            qQPublicAccountPublishFeedFragment.setReporterInf((d5.ab) injector.getOrCreateObject("BaseFragmentReporter"));
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class o implements InjectMethod {
        o() {
        }

        @Override // com.tencent.luan.ioc.InjectMethod
        public void invoke(Object obj, Injector injector) {
            QZoneTitleBarFragment qZoneTitleBarFragment = (QZoneTitleBarFragment) obj;
            qZoneTitleBarFragment.setContainerInf((d5.u) injector.getOrCreateObject(BaseFragmentContainerImp.class));
            qZoneTitleBarFragment.setFootBannerInf((d5.p) injector.getOrCreateObject(BaseFragmentFootBannerImp.class));
            qZoneTitleBarFragment.setPageDataInf((d5.v) injector.getOrCreateObject("BaseFragmentPageDataImp"));
            qZoneTitleBarFragment.setConfigInf((d5.c) injector.getOrCreateObject("BaseFragmentConfigImp"));
            qZoneTitleBarFragment.setVideoWindowPlayInf((d5.af) injector.getOrCreateObject("BaseFragmentVideoWindowPlayImp"));
            qZoneTitleBarFragment.setToastInf((d5.ae) injector.getOrCreateObject("BaseFragmentToastImp"));
            qZoneTitleBarFragment.setReporterInf((d5.ab) injector.getOrCreateObject("BaseFragmentReporter"));
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class p implements InjectMethod {
        p() {
        }

        @Override // com.tencent.luan.ioc.InjectMethod
        public void invoke(Object obj, Injector injector) {
            PhotoActivity photoActivity = (PhotoActivity) obj;
            photoActivity.setContainerInf((d5.u) injector.getOrCreateObject(BaseFragmentContainerImp.class));
            photoActivity.setFootBannerInf((d5.p) injector.getOrCreateObject(BaseFragmentFootBannerImp.class));
            photoActivity.setPageDataInf((d5.v) injector.getOrCreateObject("BaseFragmentPageDataImp"));
            photoActivity.setConfigInf((d5.c) injector.getOrCreateObject("BaseFragmentConfigImp"));
            photoActivity.setVideoWindowPlayInf((d5.af) injector.getOrCreateObject("BaseFragmentVideoWindowPlayImp"));
            photoActivity.setToastInf((d5.ae) injector.getOrCreateObject("BaseFragmentToastImp"));
            photoActivity.setReporterInf((d5.ab) injector.getOrCreateObject("BaseFragmentReporter"));
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class q implements InjectMethod {
        q() {
        }

        @Override // com.tencent.luan.ioc.InjectMethod
        public void invoke(Object obj, Injector injector) {
            QZonePublishMoodNewStyleActivity qZonePublishMoodNewStyleActivity = (QZonePublishMoodNewStyleActivity) obj;
            qZonePublishMoodNewStyleActivity.setContainerInf((d5.u) injector.getOrCreateObject(BaseFragmentContainerImp.class));
            qZonePublishMoodNewStyleActivity.setFootBannerInf((d5.p) injector.getOrCreateObject(BaseFragmentFootBannerImp.class));
            qZonePublishMoodNewStyleActivity.setPageDataInf((d5.v) injector.getOrCreateObject("BaseFragmentPageDataImp"));
            qZonePublishMoodNewStyleActivity.setConfigInf((d5.c) injector.getOrCreateObject("BaseFragmentConfigImp"));
            qZonePublishMoodNewStyleActivity.setVideoWindowPlayInf((d5.af) injector.getOrCreateObject("BaseFragmentVideoWindowPlayImp"));
            qZonePublishMoodNewStyleActivity.setToastInf((d5.ae) injector.getOrCreateObject("BaseFragmentToastImp"));
            qZonePublishMoodNewStyleActivity.setReporterInf((d5.ab) injector.getOrCreateObject("BaseFragmentReporter"));
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class r implements InjectMethod {
        r() {
        }

        @Override // com.tencent.luan.ioc.InjectMethod
        public void invoke(Object obj, Injector injector) {
            QZonePublishMoodBaseActivity qZonePublishMoodBaseActivity = (QZonePublishMoodBaseActivity) obj;
            qZonePublishMoodBaseActivity.setContainerInf((d5.u) injector.getOrCreateObject(BaseFragmentContainerImp.class));
            qZonePublishMoodBaseActivity.setFootBannerInf((d5.p) injector.getOrCreateObject(BaseFragmentFootBannerImp.class));
            qZonePublishMoodBaseActivity.setPageDataInf((d5.v) injector.getOrCreateObject("BaseFragmentPageDataImp"));
            qZonePublishMoodBaseActivity.setConfigInf((d5.c) injector.getOrCreateObject("BaseFragmentConfigImp"));
            qZonePublishMoodBaseActivity.setVideoWindowPlayInf((d5.af) injector.getOrCreateObject("BaseFragmentVideoWindowPlayImp"));
            qZonePublishMoodBaseActivity.setToastInf((d5.ae) injector.getOrCreateObject("BaseFragmentToastImp"));
            qZonePublishMoodBaseActivity.setReporterInf((d5.ab) injector.getOrCreateObject("BaseFragmentReporter"));
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class s implements InjectMethod {
        s() {
        }

        @Override // com.tencent.luan.ioc.InjectMethod
        public void invoke(Object obj, Injector injector) {
            QZoneUploadPhotoActivity qZoneUploadPhotoActivity = (QZoneUploadPhotoActivity) obj;
            qZoneUploadPhotoActivity.setContainerInf((d5.u) injector.getOrCreateObject(BaseFragmentContainerImp.class));
            qZoneUploadPhotoActivity.setFootBannerInf((d5.p) injector.getOrCreateObject(BaseFragmentFootBannerImp.class));
            qZoneUploadPhotoActivity.setPageDataInf((d5.v) injector.getOrCreateObject("BaseFragmentPageDataImp"));
            qZoneUploadPhotoActivity.setConfigInf((d5.c) injector.getOrCreateObject("BaseFragmentConfigImp"));
            qZoneUploadPhotoActivity.setVideoWindowPlayInf((d5.af) injector.getOrCreateObject("BaseFragmentVideoWindowPlayImp"));
            qZoneUploadPhotoActivity.setToastInf((d5.ae) injector.getOrCreateObject("BaseFragmentToastImp"));
            qZoneUploadPhotoActivity.setReporterInf((d5.ab) injector.getOrCreateObject("BaseFragmentReporter"));
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class t implements InjectMethod {
        t() {
        }

        @Override // com.tencent.luan.ioc.InjectMethod
        public void invoke(Object obj, Injector injector) {
            QZonePublishMoodActivity qZonePublishMoodActivity = (QZonePublishMoodActivity) obj;
            qZonePublishMoodActivity.setContainerInf((d5.u) injector.getOrCreateObject(BaseFragmentContainerImp.class));
            qZonePublishMoodActivity.setFootBannerInf((d5.p) injector.getOrCreateObject(BaseFragmentFootBannerImp.class));
            qZonePublishMoodActivity.setPageDataInf((d5.v) injector.getOrCreateObject("BaseFragmentPageDataImp"));
            qZonePublishMoodActivity.setConfigInf((d5.c) injector.getOrCreateObject("BaseFragmentConfigImp"));
            qZonePublishMoodActivity.setVideoWindowPlayInf((d5.af) injector.getOrCreateObject("BaseFragmentVideoWindowPlayImp"));
            qZonePublishMoodActivity.setToastInf((d5.ae) injector.getOrCreateObject("BaseFragmentToastImp"));
            qZonePublishMoodActivity.setReporterInf((d5.ab) injector.getOrCreateObject("BaseFragmentReporter"));
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class u implements InjectMethod {
        u() {
        }

        @Override // com.tencent.luan.ioc.InjectMethod
        public void invoke(Object obj, Injector injector) {
            EmptyFragment emptyFragment = (EmptyFragment) obj;
            emptyFragment.setContainerInf((d5.u) injector.getOrCreateObject(BaseFragmentContainerImp.class));
            emptyFragment.setFootBannerInf((d5.p) injector.getOrCreateObject(BaseFragmentFootBannerImp.class));
            emptyFragment.setPageDataInf((d5.v) injector.getOrCreateObject("BaseFragmentPageDataImp"));
            emptyFragment.setConfigInf((d5.c) injector.getOrCreateObject("BaseFragmentConfigImp"));
            emptyFragment.setVideoWindowPlayInf((d5.af) injector.getOrCreateObject("BaseFragmentVideoWindowPlayImp"));
            emptyFragment.setToastInf((d5.ae) injector.getOrCreateObject("BaseFragmentToastImp"));
            emptyFragment.setReporterInf((d5.ab) injector.getOrCreateObject("BaseFragmentReporter"));
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class v implements InjectMethod {
        v() {
        }

        @Override // com.tencent.luan.ioc.InjectMethod
        public void invoke(Object obj, Injector injector) {
            ((com.qzone.common.activities.base.w) obj).setContainer((d5.u) injector.getOrCreateObject(d5.u.class));
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class w implements InjectMethod {
        w() {
        }

        @Override // com.tencent.luan.ioc.InjectMethod
        public void invoke(Object obj, Injector injector) {
            AlbumBaseTabFragment albumBaseTabFragment = (AlbumBaseTabFragment) obj;
            albumBaseTabFragment.setContainerInf((d5.u) injector.getOrCreateObject(BaseFragmentContainerImp.class));
            albumBaseTabFragment.setFootBannerInf((d5.p) injector.getOrCreateObject(BaseFragmentFootBannerImp.class));
            albumBaseTabFragment.setPageDataInf((d5.v) injector.getOrCreateObject("BaseFragmentPageDataImp"));
            albumBaseTabFragment.setConfigInf((d5.c) injector.getOrCreateObject("BaseFragmentConfigImp"));
            albumBaseTabFragment.setVideoWindowPlayInf((d5.af) injector.getOrCreateObject("BaseFragmentVideoWindowPlayImp"));
            albumBaseTabFragment.setToastInf((d5.ae) injector.getOrCreateObject("BaseFragmentToastImp"));
            albumBaseTabFragment.setReporterInf((d5.ab) injector.getOrCreateObject("BaseFragmentReporter"));
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class x implements InjectMethod {
        x() {
        }

        @Override // com.tencent.luan.ioc.InjectMethod
        public void invoke(Object obj, Injector injector) {
            AlbumListTabFragment albumListTabFragment = (AlbumListTabFragment) obj;
            albumListTabFragment.setContainerInf((d5.u) injector.getOrCreateObject(BaseFragmentContainerImp.class));
            albumListTabFragment.setFootBannerInf((d5.p) injector.getOrCreateObject(BaseFragmentFootBannerImp.class));
            albumListTabFragment.setPageDataInf((d5.v) injector.getOrCreateObject("BaseFragmentPageDataImp"));
            albumListTabFragment.setConfigInf((d5.c) injector.getOrCreateObject("BaseFragmentConfigImp"));
            albumListTabFragment.setVideoWindowPlayInf((d5.af) injector.getOrCreateObject("BaseFragmentVideoWindowPlayImp"));
            albumListTabFragment.setToastInf((d5.ae) injector.getOrCreateObject("BaseFragmentToastImp"));
            albumListTabFragment.setReporterInf((d5.ab) injector.getOrCreateObject("BaseFragmentReporter"));
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class y implements InjectMethod {
        y() {
        }

        @Override // com.tencent.luan.ioc.InjectMethod
        public void invoke(Object obj, Injector injector) {
            AlbumVideoTabFragment albumVideoTabFragment = (AlbumVideoTabFragment) obj;
            albumVideoTabFragment.setContainerInf((d5.u) injector.getOrCreateObject(BaseFragmentContainerImp.class));
            albumVideoTabFragment.setFootBannerInf((d5.p) injector.getOrCreateObject(BaseFragmentFootBannerImp.class));
            albumVideoTabFragment.setPageDataInf((d5.v) injector.getOrCreateObject("BaseFragmentPageDataImp"));
            albumVideoTabFragment.setConfigInf((d5.c) injector.getOrCreateObject("BaseFragmentConfigImp"));
            albumVideoTabFragment.setVideoWindowPlayInf((d5.af) injector.getOrCreateObject("BaseFragmentVideoWindowPlayImp"));
            albumVideoTabFragment.setToastInf((d5.ae) injector.getOrCreateObject("BaseFragmentToastImp"));
            albumVideoTabFragment.setReporterInf((d5.ab) injector.getOrCreateObject("BaseFragmentReporter"));
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class z implements InjectMethod {
        z() {
        }

        @Override // com.tencent.luan.ioc.InjectMethod
        public void invoke(Object obj, Injector injector) {
            AlbumRecentTabFragment albumRecentTabFragment = (AlbumRecentTabFragment) obj;
            albumRecentTabFragment.setContainerInf((d5.u) injector.getOrCreateObject(BaseFragmentContainerImp.class));
            albumRecentTabFragment.setFootBannerInf((d5.p) injector.getOrCreateObject(BaseFragmentFootBannerImp.class));
            albumRecentTabFragment.setPageDataInf((d5.v) injector.getOrCreateObject("BaseFragmentPageDataImp"));
            albumRecentTabFragment.setConfigInf((d5.c) injector.getOrCreateObject("BaseFragmentConfigImp"));
            albumRecentTabFragment.setVideoWindowPlayInf((d5.af) injector.getOrCreateObject("BaseFragmentVideoWindowPlayImp"));
            albumRecentTabFragment.setToastInf((d5.ae) injector.getOrCreateObject("BaseFragmentToastImp"));
            albumRecentTabFragment.setReporterInf((d5.ab) injector.getOrCreateObject("BaseFragmentReporter"));
        }
    }

    private void invokeCommentSection(QZoneBaseFeedFragment qZoneBaseFeedFragment, Injector injector) {
        qZoneBaseFeedFragment.setRecommendFriendInf((d5.aa) injector.getOrCreateObject("BaseFeedFragmentRecommendFriendImp"));
        qZoneBaseFeedFragment.setPushInf((d5.y) injector.getOrCreateObject("BaseFeedFragmentPushImp"));
        qZoneBaseFeedFragment.setJumpInf((d5.t) injector.getOrCreateObject("BaseFeedFragmentJumpImp"));
        qZoneBaseFeedFragment.setFavorInf((d5.j) injector.getOrCreateObject("BaseFeedFragmentFavorImp"));
        qZoneBaseFeedFragment.setSchemeInf((d5.ac) injector.getOrCreateObject("BaseFeedFragmentSchemeImp"));
        qZoneBaseFeedFragment.setShareInf((d5.ad) injector.getOrCreateObject("BaseFeedFragmentShareImp"));
        qZoneBaseFeedFragment.setQDialogInf((d5.z) injector.getOrCreateObject("BaseFeedFragmentQDialogImp"));
        qZoneBaseFeedFragment.setForbiddenViewInf((d5.q) injector.getOrCreateObject("BaseFeedFragmentForbiddenViewImp"));
        qZoneBaseFeedFragment.setPopupWindowInf((d5.h) injector.getOrCreateObject("BaseFeedFragmentDropDownImp"));
        qZoneBaseFeedFragment.setCoverInf((d5.e) injector.getOrCreateObject("BaseFeedFragmentCoverImp"));
        qZoneBaseFeedFragment.setFeedPresenterInf((d5.o) injector.getOrCreateObject(BaseFeedFragmentFeedPresenterImp.class));
        qZoneBaseFeedFragment.setImageInf((d5.s) injector.getOrCreateObject("BaseFeedFragmentImageImp"));
        qZoneBaseFeedFragment.setAlbumInf((d5.a) injector.getOrCreateObject("BaseFeedFragmentAlbumImp"));
        qZoneBaseFeedFragment.setAudioInf((d5.b) injector.getOrCreateObject("BaseFeedFragmentAudioImp"));
        qZoneBaseFeedFragment.setWeiShiInf((d5.ag) injector.getOrCreateObject("BaseFeedFragmentWeiShiImp"));
        qZoneBaseFeedFragment.setFeedInf((d5.l) injector.getOrCreateObject(BaseFeedFragmentFeedImp.class));
        qZoneBaseFeedFragment.setContainerInf((d5.u) injector.getOrCreateObject(BaseFeedFragmentContainerImp.class));
        qZoneBaseFeedFragment.setDateInf((d5.f) injector.getOrCreateObject("CustomListViewFragmentDateImp"));
        qZoneBaseFeedFragment.setPublishQueueInf((d5.x) injector.getOrCreateObject("CustomListViewFragmentPublishQueueImp"));
        qZoneBaseFeedFragment.setFootBannerInf((d5.p) injector.getOrCreateObject(BaseFragmentFootBannerImp.class));
        qZoneBaseFeedFragment.setPageDataInf((d5.v) injector.getOrCreateObject("BaseFragmentPageDataImp"));
        qZoneBaseFeedFragment.setConfigInf((d5.c) injector.getOrCreateObject("BaseFragmentConfigImp"));
        qZoneBaseFeedFragment.setVideoWindowPlayInf((d5.af) injector.getOrCreateObject("BaseFragmentVideoWindowPlayImp"));
        qZoneBaseFeedFragment.setToastInf((d5.ae) injector.getOrCreateObject("BaseFragmentToastImp"));
    }

    @Override // com.tencent.luan.ioc.index.IndexInjectInfoService
    public List<ProvideMethod<?>> getAllDeclareProvideMethods(Class<?> cls) {
        return this.classProvideMethodsMap.get(cls);
    }

    @Override // com.tencent.luan.ioc.index.IndexInjectInfoService
    public InjectMethod getAllInjectMethods(Class<?> cls) {
        return this.classInjectMethodsMap.get(cls);
    }

    @Override // com.tencent.luan.ioc.index.IndexInjectInfoService
    public InjectConstructor<?> getDeclareInjectConstructor(Class<?> cls) {
        return this.classInjectConstructorMap.get(cls);
    }

    public LuanInjectService.Builder getModuleQZoneMainInjectServiceBuilder() {
        return new LuanInjectService.Builder().addIndexInfo(this).addNamedType(com.qzone.widget.j.class).addNamedType(com.qzone.common.activities.base.ae.class).addNamedType(com.qzone.common.activities.base.q.class).addNamedType(com.qzone.common.activities.base.m.class).addNamedType(com.qzone.common.activities.base.u.class).addNamedType(com.qzone.common.activities.base.w.class).addNamedType(com.qzone.common.activities.base.af.class).addNamedType(com.qzone.common.activities.base.ag.class).addNamedType(com.qzone.common.activities.base.v.class).addNamedType(com.qzone.common.activities.base.p.class).addNamedType(com.qzone.common.activities.base.ab.class).addNamedType(com.qzone.common.activities.base.ad.class).addNamedType(com.qzone.common.activities.base.t.class).addNamedType(com.qzone.common.activities.base.n.class).addNamedType(com.qzone.common.activities.base.r.class).addNamedType(com.qzone.common.activities.base.o.class).addNamedType(com.qzone.common.activities.base.l.class).addNamedType(com.qzone.common.activities.base.ah.class).addNamedType(BaseFeedFragmentDropDownImp.class).addNamedType(com.qzone.common.activities.base.x.class).addNamedType(com.qzone.common.activities.base.ac.class).addNamedType(com.qzone.common.activities.base.s.class).addNamedType(com.qzone.feed.ui.activity.c.class).addNamedType(com.qzone.feed.ui.activity.a.class).addNamedType(com.qzone.feed.ui.activity.d.class);
    }

    public LuanIndexInjectInfoService() {
        HashMap hashMap = new HashMap();
        hashMap.put(FeedEnvImpl.class, new EmptyInjectMethod());
        hashMap.put(com.qzone.proxy.feedcomponent.f.class, new EmptyInjectMethod());
        hashMap.put(com.qzone.proxy.feedcomponent.g.class, new EmptyInjectMethod());
        hashMap.put(com.qzone.widget.j.class, new EmptyInjectMethod());
        hashMap.put(QZonePullToRefreshListView.class, new k());
        hashMap.put(com.qzone.common.activities.base.ae.class, new EmptyInjectMethod());
        hashMap.put(com.qzone.common.activities.base.q.class, new EmptyInjectMethod());
        hashMap.put(com.qzone.common.activities.base.m.class, new EmptyInjectMethod());
        hashMap.put(com.qzone.common.activities.base.u.class, new EmptyInjectMethod());
        hashMap.put(com.qzone.common.activities.base.w.class, new v());
        hashMap.put(com.qzone.common.activities.base.af.class, new EmptyInjectMethod());
        hashMap.put(com.qzone.common.activities.base.ag.class, new EmptyInjectMethod());
        hashMap.put(QZoneBaseFeedFragment.class, new ag());
        hashMap.put(BaseFragment.class, new ar());
        hashMap.put(com.qzone.common.activities.base.v.class, new bc());
        hashMap.put(com.qzone.common.activities.base.p.class, new bn());
        hashMap.put(BaseFeedFragmentFeedImp.class, new bq());
        hashMap.put(com.qzone.common.activities.base.ab.class, new EmptyInjectMethod());
        hashMap.put(com.qzone.common.activities.base.ad.class, new EmptyInjectMethod());
        hashMap.put(com.qzone.common.activities.base.t.class, new br());
        hashMap.put(BaseFragmentContainerImp.class, new EmptyInjectMethod());
        hashMap.put(com.qzone.common.activities.base.n.class, new EmptyInjectMethod());
        hashMap.put(com.qzone.common.activities.base.r.class, new bs());
        hashMap.put(com.qzone.common.activities.base.o.class, new a());
        hashMap.put(com.qzone.common.activities.base.l.class, new EmptyInjectMethod());
        hashMap.put(BaseFragmentFootBannerImp.class, new b());
        hashMap.put(CustomListViewFragment.class, new c());
        hashMap.put(com.qzone.common.activities.base.ah.class, new EmptyInjectMethod());
        hashMap.put(BaseFeedFragmentEventImp.class, new d());
        hashMap.put(BaseFeedFragmentDropDownImp.class, new e());
        hashMap.put(com.qzone.common.activities.base.x.class, new f());
        hashMap.put(BaseFeedFragmentContainerImp.class, new EmptyInjectMethod());
        hashMap.put(BaseFeedFragmentFeedPresenterImp.class, new g());
        hashMap.put(com.qzone.common.activities.base.ac.class, new h());
        hashMap.put(com.qzone.common.activities.base.s.class, new i());
        hashMap.put(QZoneMyFeedFragment.class, new j());
        hashMap.put(com.qzone.feed.ui.activity.c.class, new l());
        hashMap.put(com.qzone.feed.ui.activity.b.class, new m());
        hashMap.put(com.qzone.feed.ui.activity.d.class, new EmptyInjectMethod());
        hashMap.put(QQPublicAccountPublishFeedFragment.class, new n());
        hashMap.put(QZoneTitleBarFragment.class, new o());
        hashMap.put(PhotoActivity.class, new p());
        hashMap.put(QZonePublishMoodNewStyleActivity.class, new q());
        hashMap.put(QZonePublishMoodBaseActivity.class, new r());
        hashMap.put(QZoneUploadPhotoActivity.class, new s());
        hashMap.put(QZonePublishMoodActivity.class, new t());
        hashMap.put(EmptyFragment.class, new u());
        hashMap.put(AlbumBaseTabFragment.class, new w());
        hashMap.put(AlbumListTabFragment.class, new x());
        hashMap.put(AlbumVideoTabFragment.class, new y());
        hashMap.put(AlbumRecentTabFragment.class, new z());
        hashMap.put(QZoneHomePageListView.class, new aa());
        hashMap.put(QzoneSwipPullRefreshListView.class, new ab());
        hashMap.put(QZoneXPullToRefreshListView.class, new ac());
        this.classInjectMethodsMap = Collections.unmodifiableMap(hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(FeedEnvImpl.class, new ad(FeedEnvImpl.class, 2));
        hashMap2.put(com.qzone.proxy.feedcomponent.f.class, new ae(com.qzone.proxy.feedcomponent.f.class, 2));
        hashMap2.put(com.qzone.proxy.feedcomponent.g.class, new af(com.qzone.proxy.feedcomponent.g.class, 2));
        hashMap2.put(com.qzone.widget.j.class, new ah(com.qzone.widget.j.class, 1));
        hashMap2.put(com.qzone.common.activities.base.ae.class, new ai(com.qzone.common.activities.base.ae.class, 1));
        hashMap2.put(com.qzone.common.activities.base.q.class, new aj(com.qzone.common.activities.base.q.class, 0));
        hashMap2.put(com.qzone.common.activities.base.m.class, new ak(com.qzone.common.activities.base.m.class, 0));
        hashMap2.put(com.qzone.common.activities.base.u.class, new al(com.qzone.common.activities.base.u.class, 0));
        hashMap2.put(com.qzone.common.activities.base.w.class, new am(com.qzone.common.activities.base.w.class, 0));
        hashMap2.put(com.qzone.common.activities.base.af.class, new an(com.qzone.common.activities.base.af.class, 0));
        hashMap2.put(com.qzone.common.activities.base.ag.class, new ao(com.qzone.common.activities.base.ag.class, 1));
        hashMap2.put(com.qzone.common.activities.base.v.class, new ap(com.qzone.common.activities.base.v.class, 0));
        hashMap2.put(com.qzone.common.activities.base.p.class, new aq(com.qzone.common.activities.base.p.class, 0));
        hashMap2.put(BaseFeedFragmentFeedImp.class, new as(BaseFeedFragmentFeedImp.class, 0));
        hashMap2.put(com.qzone.common.activities.base.ab.class, new at(com.qzone.common.activities.base.ab.class, 0));
        hashMap2.put(com.qzone.common.activities.base.ad.class, new au(com.qzone.common.activities.base.ad.class, 0));
        hashMap2.put(com.qzone.common.activities.base.t.class, new av(com.qzone.common.activities.base.t.class, 0));
        hashMap2.put(BaseFragmentContainerImp.class, new aw(BaseFragmentContainerImp.class, 0));
        hashMap2.put(com.qzone.common.activities.base.n.class, new ax(com.qzone.common.activities.base.n.class, 0));
        hashMap2.put(com.qzone.common.activities.base.r.class, new ay(com.qzone.common.activities.base.r.class, 0));
        hashMap2.put(com.qzone.common.activities.base.o.class, new az(com.qzone.common.activities.base.o.class, 0));
        hashMap2.put(com.qzone.common.activities.base.l.class, new ba(com.qzone.common.activities.base.l.class, 0));
        hashMap2.put(BaseFragmentFootBannerImp.class, new bb(BaseFragmentFootBannerImp.class, 0));
        hashMap2.put(com.qzone.common.activities.base.ah.class, new bd(com.qzone.common.activities.base.ah.class, 0));
        hashMap2.put(BaseFeedFragmentEventImp.class, new be(BaseFeedFragmentEventImp.class, 0));
        hashMap2.put(BaseFeedFragmentDropDownImp.class, new bf(BaseFeedFragmentDropDownImp.class, 0));
        hashMap2.put(com.qzone.common.activities.base.x.class, new bg(com.qzone.common.activities.base.x.class, 0));
        hashMap2.put(BaseFeedFragmentContainerImp.class, new bh(BaseFeedFragmentContainerImp.class, 0));
        hashMap2.put(BaseFeedFragmentFeedPresenterImp.class, new bi(BaseFeedFragmentFeedPresenterImp.class, 0));
        hashMap2.put(com.qzone.common.activities.base.ac.class, new bj(com.qzone.common.activities.base.ac.class, 0));
        hashMap2.put(com.qzone.common.activities.base.s.class, new bk(com.qzone.common.activities.base.s.class, 0));
        hashMap2.put(com.qzone.feed.ui.activity.c.class, new bl(com.qzone.feed.ui.activity.c.class, 0));
        hashMap2.put(com.qzone.feed.ui.activity.b.class, new bm(com.qzone.feed.ui.activity.b.class, 0));
        hashMap2.put(com.qzone.feed.ui.activity.a.class, new bo(com.qzone.feed.ui.activity.a.class, 0));
        hashMap2.put(com.qzone.feed.ui.activity.d.class, new bp(com.qzone.feed.ui.activity.d.class, 0));
        this.classInjectConstructorMap = Collections.unmodifiableMap(hashMap2);
        this.classProvideMethodsMap = Collections.unmodifiableMap(new HashMap());
    }
}
