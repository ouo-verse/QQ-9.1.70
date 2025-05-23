package com.tencent.biz.qqcircle.immersive.views.mixfeed.piccontentdetail;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.QFSBaseFragment;
import com.tencent.biz.qqcircle.immersive.QFSLayerRightProfileFragment;
import com.tencent.biz.qqcircle.immersive.adapter.v;
import com.tencent.biz.qqcircle.immersive.events.QFSEnableSlideRightActionEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSPageIndexEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSSlideRightActionEvent;
import com.tencent.biz.qqcircle.immersive.part.u;
import com.tencent.biz.qqcircle.immersive.views.QFSViewPager;
import com.tencent.biz.qqcircle.utils.cr;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.C11736d;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u00a2\u0006\u0004\b3\u00104J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u001c\u0010\u0010\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0011\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\nH\u0016R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020+0*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101\u00a8\u00065"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/views/mixfeed/piccontentdetail/d;", "Lcom/tencent/biz/qqcircle/immersive/part/u;", "", "E9", "Lcom/tencent/biz/qqcircle/immersive/events/QFSSlideRightActionEvent;", "event", "G9", "Lcom/tencent/biz/qqcircle/immersive/events/QFSEnableSlideRightActionEvent;", "F9", "H9", "", "I9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "onBackEvent", "Lcom/tencent/biz/richframework/part/PartManager;", "d", "Lcom/tencent/biz/richframework/part/PartManager;", "parentPartManager", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "e", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "initBean", "Lcom/tencent/biz/qqcircle/immersive/views/QFSViewPager;", "f", "Lcom/tencent/biz/qqcircle/immersive/views/QFSViewPager;", "viewPager", "Lcom/tencent/biz/qqcircle/immersive/adapter/v;", h.F, "Lcom/tencent/biz/qqcircle/immersive/adapter/v;", "adapter", "Lcom/tencent/biz/qqcircle/immersive/QFSLayerRightProfileFragment;", "i", "Lcom/tencent/biz/qqcircle/immersive/QFSLayerRightProfileFragment;", "profileFragment", "", "Lcom/tencent/biz/qqcircle/immersive/QFSBaseFragment;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "fragmentList", "Lcom/tencent/biz/qqcircle/utils/cr;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/biz/qqcircle/utils/cr;", "eventListener", "<init>", "(Lcom/tencent/biz/richframework/part/PartManager;Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class d extends u {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final cr eventListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PartManager parentPartManager;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QCircleInitBean initBean;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QFSViewPager viewPager;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private v adapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QFSLayerRightProfileFragment profileFragment;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<QFSBaseFragment> fragmentList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J(\u0010\t\u001a\"\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00070\u0006j\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0007`\bH\u0014\u00a8\u0006\n"}, d2 = {"com/tencent/biz/qqcircle/immersive/views/mixfeed/piccontentdetail/d$b", "Lcom/tencent/biz/qqcircle/utils/cr;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b extends cr {
        b() {
        }

        @Override // com.tencent.biz.qqcircle.utils.cr
        @NotNull
        protected ArrayList<Class<? extends SimpleBaseEvent>> a() {
            ArrayList<Class<? extends SimpleBaseEvent>> arrayListOf;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QFSEnableSlideRightActionEvent.class, QFSSlideRightActionEvent.class, QFSPageIndexEvent.class);
            return arrayListOf;
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
            if (event instanceof QFSEnableSlideRightActionEvent) {
                d.this.F9((QFSEnableSlideRightActionEvent) event);
            } else if (event instanceof QFSSlideRightActionEvent) {
                d.this.G9((QFSSlideRightActionEvent) event);
            }
        }
    }

    public d(@NotNull PartManager parentPartManager, @NotNull QCircleInitBean initBean) {
        Intrinsics.checkNotNullParameter(parentPartManager, "parentPartManager");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        this.parentPartManager = parentPartManager;
        this.initBean = initBean;
        this.fragmentList = new ArrayList();
        this.eventListener = new b();
    }

    private final void E9() {
        QFSViewPager qFSViewPager = this.viewPager;
        if (qFSViewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            qFSViewPager = null;
        }
        qFSViewPager.addOnPageChangeListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F9(QFSEnableSlideRightActionEvent event) {
        if (getContext() != null && event.getContextHashCode() == getContext().hashCode()) {
            QFSViewPager qFSViewPager = this.viewPager;
            if (qFSViewPager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                qFSViewPager = null;
            }
            qFSViewPager.setScrollable(event.isEnable());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G9(QFSSlideRightActionEvent event) {
        if (event.getHashCode() != getContext().hashCode()) {
            return;
        }
        QFSLayerRightProfileFragment qFSLayerRightProfileFragment = this.profileFragment;
        if (qFSLayerRightProfileFragment != null) {
            qFSLayerRightProfileFragment.Ai(false);
            qFSLayerRightProfileFragment.ki(event.getClientFromType());
        }
        QFSViewPager qFSViewPager = this.viewPager;
        if (qFSViewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            qFSViewPager = null;
        }
        qFSViewPager.setCurrentItem(1);
    }

    private final void H9() {
        if (uq3.c.s0()) {
            return;
        }
        boolean z16 = true;
        if (I9()) {
            QLog.d(getTAG(), 1, "initProfileFragmentIfNeed return");
            return;
        }
        if (!com.tencent.biz.qqcircle.launcher.c.d()) {
            QLog.d(getTAG(), 1, "initProfileFragmentIfNeed return processId=", Integer.valueOf(MobileQQ.sProcessId));
            return;
        }
        if (getActivity() != null) {
            Activity activity = getActivity();
            if (activity == null || !activity.isFinishing()) {
                z16 = false;
            }
            if (!z16 && this.profileFragment == null) {
                QFSLayerRightProfileFragment qFSLayerRightProfileFragment = new QFSLayerRightProfileFragment();
                this.fragmentList.add(qFSLayerRightProfileFragment);
                qFSLayerRightProfileFragment.zi(QCircleDaTongConstant.PageId.PG_XSJ_CIRCLE_PICTEXT_PAGE);
                this.profileFragment = qFSLayerRightProfileFragment;
                v vVar = this.adapter;
                v vVar2 = null;
                if (vVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    vVar = null;
                }
                vVar.d(this.fragmentList);
                v vVar3 = this.adapter;
                if (vVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                } else {
                    vVar2 = vVar3;
                }
                vVar2.notifyDataSetChanged();
            }
        }
    }

    private final boolean I9() {
        return Intrinsics.areEqual("qfs_personal_tab_all", this.initBean.getLaunchFrom());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(d this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.H9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        QFSViewPager qFSViewPager = this.viewPager;
        QFSViewPager qFSViewPager2 = null;
        if (qFSViewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            qFSViewPager = null;
        }
        if (qFSViewPager.getCurrentItem() != 0) {
            QFSViewPager qFSViewPager3 = this.viewPager;
            if (qFSViewPager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            } else {
                qFSViewPager2 = qFSViewPager3;
            }
            qFSViewPager2.setCurrentItem(0);
            return true;
        }
        List<QFSBaseFragment> list = this.fragmentList;
        QFSViewPager qFSViewPager4 = this.viewPager;
        if (qFSViewPager4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        } else {
            qFSViewPager2 = qFSViewPager4;
        }
        return list.get(qFSViewPager2.getCurrentItem()).onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.vfx);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.fs_folder_viewpager)");
        this.viewPager = (QFSViewPager) findViewById;
        this.adapter = new v(getHostFragment().getChildFragmentManager());
        QFSViewPager qFSViewPager = this.viewPager;
        v vVar = null;
        if (qFSViewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            qFSViewPager = null;
        }
        v vVar2 = this.adapter;
        if (vVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            vVar2 = null;
        }
        qFSViewPager.setAdapter(vVar2);
        QFSViewPager qFSViewPager2 = this.viewPager;
        if (qFSViewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            qFSViewPager2 = null;
        }
        qFSViewPager2.setOffscreenPageLimit(1);
        E9();
        QFSPicDetailContentFragment b16 = QFSPicDetailContentFragment.INSTANCE.b(this.initBean);
        this.fragmentList.add(b16);
        b16.getPartManager().setPartManagerObservers(this.parentPartManager);
        v vVar3 = this.adapter;
        if (vVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            vVar3 = null;
        }
        vVar3.d(this.fragmentList);
        v vVar4 = this.adapter;
        if (vVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            vVar = vVar4;
        }
        vVar.notifyDataSetChanged();
        C11736d.b(800, new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.mixfeed.piccontentdetail.c
            @Override // java.lang.Runnable
            public final void run() {
                d.J9(d.this);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this.eventListener);
        getPageId();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this.eventListener);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/biz/qqcircle/immersive/views/mixfeed/piccontentdetail/d$a", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "", "position", "", "positionOffset", "positionOffsetPixels", "", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "onPageSelected", "state", "onPageScrollStateChanged", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class a implements ViewPager.OnPageChangeListener {
        a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            QFSLayerRightProfileFragment qFSLayerRightProfileFragment;
            if (positionOffset > 0.0f && (qFSLayerRightProfileFragment = d.this.profileFragment) != null) {
                qFSLayerRightProfileFragment.yi();
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
            QLog.i(d.this.getTAG(), 1, "fs_lifecycle onPageSelected mFolderViewPager pos = " + position);
            QFSLayerRightProfileFragment qFSLayerRightProfileFragment = d.this.profileFragment;
            if (qFSLayerRightProfileFragment != null) {
                d dVar = d.this;
                qFSLayerRightProfileFragment.wi((Fragment) dVar.fragmentList.get(position));
                if (position == 1) {
                    QFSViewPager qFSViewPager = dVar.viewPager;
                    if (qFSViewPager == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                        qFSViewPager = null;
                    }
                    qFSLayerRightProfileFragment.Ai(qFSViewPager.c());
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
        }
    }
}
