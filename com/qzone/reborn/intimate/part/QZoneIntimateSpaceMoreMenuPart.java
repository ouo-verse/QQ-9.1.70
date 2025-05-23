package com.qzone.reborn.intimate.part;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.intimate.bean.QZIntimateSettingItemBean;
import com.qzone.reborn.intimate.bean.QZoneIntimateSpaceBean;
import com.qzone.reborn.intimate.bean.init.QZIntimateSettingPageBean;
import com.qzone.reborn.intimate.event.QZIntimateEnableSyncFromQZoneEvent;
import com.qzone.reborn.intimate.event.QZIntimateModifyAnniversaryEvent;
import com.qzone.reborn.intimate.event.QZIntimateModifySettingEvent;
import com.qzone.reborn.intimate.event.QZIntimateShowSettingDialogEvent;
import com.qzone.reborn.intimate.event.QZoneIntimateSpaceDisplayRightEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.partner.signin.pb.GeneralSigninPB$Setting;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.widget.selectorview.QActionSheet;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import ij.QZIntimateCheckInInfoBean;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;

@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 K2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001LB\u0007\u00a2\u0006\u0004\bI\u0010JJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\fH\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000eH\u0002J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u001c\u0010\u001b\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\u001c\u0010 \u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010!\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J$\u0010%\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030#0\"j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030#`$H\u0016J\u0012\u0010&\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0016R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00100\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010D\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010F\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010,R\u0016\u0010H\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010,\u00a8\u0006M"}, d2 = {"Lcom/qzone/reborn/intimate/part/QZoneIntimateSpaceMoreMenuPart;", "Lcom/qzone/reborn/base/k;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "initViewModel", "X9", "V9", "N9", "Lcom/qzone/reborn/intimate/event/QZoneIntimateSpaceDisplayRightEvent;", "event", "R9", "Lcom/qzone/reborn/intimate/event/QZIntimateModifyAnniversaryEvent;", "P9", "Lcom/qzone/reborn/intimate/event/QZIntimateModifySettingEvent;", "Q9", "", "settingKey", "", com.tencent.mobileqq.msf.core.f0.c.e.h.f248218g, "O9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "action", "", "args", "handleBroadcastMessage", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "onReceiveEvent", "Lcom/qzone/reborn/intimate/bean/QZoneIntimateSpaceBean;", "d", "Lcom/qzone/reborn/intimate/bean/QZoneIntimateSpaceBean;", "mSpaceBean", "e", "Z", "mIsSpacePrivate", "f", "Landroid/view/View;", "mIvMore", "Lnk/at;", tl.h.F, "Lnk/at;", "mMainTabViewModel", "Lnk/h;", "i", "Lnk/h;", "migrationViewModel", "Lnk/i;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lnk/i;", "resourceViewModel", "Lnk/p;", BdhLogUtil.LogTag.Tag_Conn, "Lnk/p;", "settingViewModel", "Lnk/b;", "D", "Lnk/b;", "checkInViewModel", "E", "isNeedShowSyncLoverSpaceEntrance", UserInfo.SEX_FEMALE, "isEnableSync", "<init>", "()V", "G", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneIntimateSpaceMoreMenuPart extends com.qzone.reborn.base.k implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    private nk.p settingViewModel;

    /* renamed from: D, reason: from kotlin metadata */
    private nk.b checkInViewModel;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isNeedShowSyncLoverSpaceEntrance;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isEnableSync;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private QZoneIntimateSpaceBean mSpaceBean;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean mIsSpacePrivate = true;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View mIvMore;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private nk.at mMainTabViewModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private nk.h migrationViewModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private nk.i resourceViewModel;

    private final void N9() {
        View view = this.mIvMore;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvMore");
            view = null;
        }
        fo.c.o(view, "em_qz_set_button", null);
    }

    private final void O9(String settingKey, boolean isOpen) {
        String str;
        String str2;
        nk.p pVar = this.settingViewModel;
        if (pVar != null) {
            nk.at atVar = this.mMainTabViewModel;
            if (atVar == null || (str = atVar.getMSpaceId()) == null) {
                str = "";
            }
            if (isOpen) {
                str2 = "true";
            } else {
                str2 = "false";
            }
            pVar.T1(settingKey, str, str2);
        }
    }

    private final void P9(QZIntimateModifyAnniversaryEvent event) {
        nk.at atVar = this.mMainTabViewModel;
        if (atVar != null) {
            atVar.c2(event.getTimestampInSecond(), true);
        }
    }

    private final void Q9(QZIntimateModifySettingEvent event) {
        QZIntimateSettingItemBean settingItem = event.getSettingItem();
        O9(settingItem.getKey(), TextUtils.equals("true", settingItem.getValue()));
    }

    private final void R9(QZoneIntimateSpaceDisplayRightEvent event) {
        QZoneIntimateSpaceBean data;
        if (this.mMainTabViewModel == null) {
            QLog.e("QZoneIntimateSpaceMoreMenuPart", 1, "[handleSpaceDisplayRightEvent] view model is null");
            return;
        }
        QLog.e("QZoneIntimateSpaceMoreMenuPart", 1, "[handleSpaceDisplayRightEvent] event spaceId = " + event.getSpaceId() + ", displayRight = " + event.getSpaceDisplayRight());
        nk.at atVar = this.mMainTabViewModel;
        Intrinsics.checkNotNull(atVar);
        if (TextUtils.equals(atVar.getMSpaceId(), event.getSpaceId())) {
            nk.at atVar2 = this.mMainTabViewModel;
            Intrinsics.checkNotNull(atVar2);
            UIStateData<QZoneIntimateSpaceBean> value = atVar2.U1().getValue();
            if (value == null || (data = value.getData()) == null) {
                return;
            }
            data.setDisplayRight(event.getSpaceDisplayRight());
            data.setFromRefreshSpace(false);
            UIStateData<QZoneIntimateSpaceBean> data2 = UIStateData.obtainSuccess(false).setData(false, data);
            nk.at atVar3 = this.mMainTabViewModel;
            Intrinsics.checkNotNull(atVar3);
            atVar3.U1().postValue(data2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void V9() {
        QZoneIntimateSpaceBean qZoneIntimateSpaceBean = this.mSpaceBean;
        if (qZoneIntimateSpaceBean != null) {
            Intrinsics.checkNotNull(qZoneIntimateSpaceBean);
            if (qZoneIntimateSpaceBean.supportModifyAnniversary()) {
                QZoneIntimateSpaceBean qZoneIntimateSpaceBean2 = this.mSpaceBean;
                Intrinsics.checkNotNull(qZoneIntimateSpaceBean2);
                long anniversary = qZoneIntimateSpaceBean2.getAnniversary() * 1000;
                String title = com.qzone.util.l.a(R.string.wbn);
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                Intrinsics.checkNotNullExpressionValue(title, "title");
                com.qzone.reborn.widget.g gVar = new com.qzone.reborn.widget.g(context, title);
                gVar.M(anniversary);
                gVar.i(new b(gVar, this));
                if (gVar.L() != null) {
                    fo.c.m(gVar.L(), "pg_qz_couple_anniversary_revision");
                }
                gVar.m();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W9(QZoneIntimateSpaceMoreMenuPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.X9();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void X9() {
        String str;
        MutableLiveData<List<QZIntimateSettingItemBean>> P1;
        String migrateAuthUrl;
        QZIntimateSettingPageBean qZIntimateSettingPageBean = new QZIntimateSettingPageBean();
        nk.at atVar = this.mMainTabViewModel;
        String str2 = "";
        if (atVar == null || (str = atVar.getMSpaceId()) == null) {
            str = "";
        }
        qZIntimateSettingPageBean.setSpaceId(str);
        QZoneIntimateSpaceBean qZoneIntimateSpaceBean = this.mSpaceBean;
        qZIntimateSettingPageBean.setSpaceType(qZoneIntimateSpaceBean != null ? qZoneIntimateSpaceBean.getSpaceType() : -1);
        qZIntimateSettingPageBean.setNeedShowSyncLoverSpaceEntrance(this.isNeedShowSyncLoverSpaceEntrance);
        qZIntimateSettingPageBean.setEnableSyncQZoneAlbum(this.isEnableSync);
        nk.i iVar = this.resourceViewModel;
        if (iVar != null && (migrateAuthUrl = iVar.getMigrateAuthUrl()) != null) {
            str2 = migrateAuthUrl;
        }
        qZIntimateSettingPageBean.setMigrateAuthUrl(str2);
        qZIntimateSettingPageBean.setSpaceDataReady(this.mSpaceBean != null);
        QZoneIntimateSpaceBean qZoneIntimateSpaceBean2 = this.mSpaceBean;
        qZIntimateSettingPageBean.setSpacePrivate(qZoneIntimateSpaceBean2 != null && qZoneIntimateSpaceBean2.getDisplayRight() == 0);
        QZoneIntimateSpaceBean qZoneIntimateSpaceBean3 = this.mSpaceBean;
        qZIntimateSettingPageBean.setSupportModifyAnniversary(qZoneIntimateSpaceBean3 != null && qZoneIntimateSpaceBean3.supportModifyAnniversary());
        QZoneIntimateSpaceBean qZoneIntimateSpaceBean4 = this.mSpaceBean;
        qZIntimateSettingPageBean.setAnniversary(qZoneIntimateSpaceBean4 != null ? qZoneIntimateSpaceBean4.getAnniversary() : 0L);
        nk.p pVar = this.settingViewModel;
        List<QZIntimateSettingItemBean> value = (pVar == null || (P1 = pVar.P1()) == null) ? null : P1.getValue();
        if (value == null) {
            value = new ArrayList<>();
        }
        qZIntimateSettingPageBean.setSettingList(value);
        ho.i.o().w(getContext(), qZIntimateSettingPageBean);
    }

    private final void initViewModel() {
        MutableLiveData<UIStateData<QZIntimateCheckInInfoBean>> b26;
        MutableLiveData<Boolean> P1;
        MutableLiveData<UIStateData<QZoneIntimateSpaceBean>> U1;
        this.resourceViewModel = (nk.i) getViewModel(nk.i.class);
        nk.at atVar = (nk.at) getViewModel(nk.at.class);
        this.mMainTabViewModel = atVar;
        if (atVar != null && (U1 = atVar.U1()) != null) {
            LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
            final Function1<UIStateData<QZoneIntimateSpaceBean>, Unit> function1 = new Function1<UIStateData<QZoneIntimateSpaceBean>, Unit>() { // from class: com.qzone.reborn.intimate.part.QZoneIntimateSpaceMoreMenuPart$initViewModel$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(UIStateData<QZoneIntimateSpaceBean> uIStateData) {
                    invoke2(uIStateData);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(UIStateData<QZoneIntimateSpaceBean> uIStateData) {
                    QZoneIntimateSpaceBean qZoneIntimateSpaceBean;
                    View view;
                    QZoneIntimateSpaceBean qZoneIntimateSpaceBean2;
                    View view2;
                    if (uIStateData == null || uIStateData.getData() == null) {
                        return;
                    }
                    QZoneIntimateSpaceMoreMenuPart.this.mSpaceBean = uIStateData.getData();
                    qZoneIntimateSpaceBean = QZoneIntimateSpaceMoreMenuPart.this.mSpaceBean;
                    View view3 = null;
                    if (qZoneIntimateSpaceBean != null && qZoneIntimateSpaceBean.isMasterSpace()) {
                        view2 = QZoneIntimateSpaceMoreMenuPart.this.mIvMore;
                        if (view2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mIvMore");
                        } else {
                            view3 = view2;
                        }
                        view3.setVisibility(0);
                    } else {
                        view = QZoneIntimateSpaceMoreMenuPart.this.mIvMore;
                        if (view == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mIvMore");
                        } else {
                            view3 = view;
                        }
                        view3.setVisibility(8);
                    }
                    QZoneIntimateSpaceMoreMenuPart qZoneIntimateSpaceMoreMenuPart = QZoneIntimateSpaceMoreMenuPart.this;
                    qZoneIntimateSpaceBean2 = qZoneIntimateSpaceMoreMenuPart.mSpaceBean;
                    qZoneIntimateSpaceMoreMenuPart.mIsSpacePrivate = qZoneIntimateSpaceBean2 != null && qZoneIntimateSpaceBean2.getDisplayRight() == 0;
                }
            };
            U1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.intimate.part.ci
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QZoneIntimateSpaceMoreMenuPart.S9(Function1.this, obj);
                }
            });
        }
        nk.h hVar = (nk.h) getViewModel(nk.h.class);
        this.migrationViewModel = hVar;
        if (hVar != null && (P1 = hVar.P1()) != null) {
            Fragment hostFragment = getHostFragment();
            final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.qzone.reborn.intimate.part.QZoneIntimateSpaceMoreMenuPart$initViewModel$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke2(bool);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Boolean bool) {
                    if (bool == null) {
                        return;
                    }
                    QZoneIntimateSpaceMoreMenuPart.this.isNeedShowSyncLoverSpaceEntrance = bool.booleanValue();
                }
            };
            P1.observe(hostFragment, new Observer() { // from class: com.qzone.reborn.intimate.part.cj
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QZoneIntimateSpaceMoreMenuPart.T9(Function1.this, obj);
                }
            });
        }
        this.settingViewModel = (nk.p) getViewModel(nk.p.class);
        nk.b bVar = (nk.b) getViewModel(nk.b.class);
        this.checkInViewModel = bVar;
        if (bVar == null || (b26 = bVar.b2()) == null) {
            return;
        }
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<UIStateData<QZIntimateCheckInInfoBean>, Unit> function13 = new Function1<UIStateData<QZIntimateCheckInInfoBean>, Unit>() { // from class: com.qzone.reborn.intimate.part.QZoneIntimateSpaceMoreMenuPart$initViewModel$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<QZIntimateCheckInInfoBean> uIStateData) {
                invoke2(uIStateData);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:10:0x002d, code lost:
            
                r0 = r7.this$0.settingViewModel;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2(UIStateData<QZIntimateCheckInInfoBean> uIStateData) {
                nk.p pVar;
                MutableLiveData<List<QZIntimateSettingItemBean>> P12;
                nk.p pVar2;
                String str;
                if (uIStateData == null || uIStateData.getData() == null) {
                    return;
                }
                if (uIStateData.getData().j().isEmpty()) {
                    QLog.i("QZoneIntimateSpaceMoreMenuPart", 1, "setting data is null, try to get again");
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    if (peekAppRuntime == null || pVar2 == null) {
                        return;
                    }
                    nk.at atVar2 = QZoneIntimateSpaceMoreMenuPart.this.mMainTabViewModel;
                    if (atVar2 == null || (str = atVar2.getMSpaceId()) == null) {
                        str = "";
                    }
                    pVar2.Q1(peekAppRuntime, str);
                    return;
                }
                for (GeneralSigninPB$Setting generalSigninPB$Setting : uIStateData.getData().j()) {
                    QLog.i("QZoneIntimateSpaceMoreMenuPart", 2, "setting key name is " + generalSigninPB$Setting.name.get() + ", desc is " + generalSigninPB$Setting.desc.get() + ", value is " + generalSigninPB$Setting.value.get());
                }
                pVar = QZoneIntimateSpaceMoreMenuPart.this.settingViewModel;
                if (pVar == null || (P12 = pVar.P1()) == null) {
                    return;
                }
                P12.postValue(ef.d.p(uIStateData.getData().j()));
            }
        };
        b26.observe(lifecycleOwner2, new Observer() { // from class: com.qzone.reborn.intimate.part.ck
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneIntimateSpaceMoreMenuPart.U9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String action, Object args) {
        super.handleBroadcastMessage(action, args);
        if (Intrinsics.areEqual(action, "INTIMATE_MODIFY_ANNIVERSARY")) {
            V9();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.n65);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026zone_intimate_title_more)");
        this.mIvMore = findViewById;
        View view = null;
        if (findViewById == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvMore");
            findViewById = null;
        }
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.intimate.part.ch
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QZoneIntimateSpaceMoreMenuPart.W9(QZoneIntimateSpaceMoreMenuPart.this, view2);
            }
        });
        initViewModel();
        N9();
        View view2 = this.mIvMore;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvMore");
        } else {
            view = view2;
        }
        AccessibilityUtil.s(view, com.qzone.util.l.a(R.string.f2202268j));
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (event instanceof QZoneIntimateSpaceDisplayRightEvent) {
            R9((QZoneIntimateSpaceDisplayRightEvent) event);
            return;
        }
        if (event instanceof QZIntimateEnableSyncFromQZoneEvent) {
            this.isEnableSync = ((QZIntimateEnableSyncFromQZoneEvent) event).getIsEnableSync();
            return;
        }
        if (event instanceof QZIntimateShowSettingDialogEvent) {
            X9();
        } else if (event instanceof QZIntimateModifyAnniversaryEvent) {
            P9((QZIntimateModifyAnniversaryEvent) event);
        } else if (event instanceof QZIntimateModifySettingEvent) {
            Q9((QZIntimateModifySettingEvent) event);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QZoneIntimateSpaceDisplayRightEvent.class, QZIntimateEnableSyncFromQZoneEvent.class, QZIntimateShowSettingDialogEvent.class, QZIntimateModifySettingEvent.class, QZIntimateModifyAnniversaryEvent.class);
        return arrayListOf;
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/qzone/reborn/intimate/part/QZoneIntimateSpaceMoreMenuPart$b", "Lcom/tencent/mobileqq/widget/selectorview/QActionSheet$f;", "", "onDismiss", "t", "onConfirm", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements QActionSheet.f {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.qzone.reborn.widget.g f57293d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QZoneIntimateSpaceMoreMenuPart f57294e;

        b(com.qzone.reborn.widget.g gVar, QZoneIntimateSpaceMoreMenuPart qZoneIntimateSpaceMoreMenuPart) {
            this.f57293d = gVar;
            this.f57294e = qZoneIntimateSpaceMoreMenuPart;
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void onConfirm() {
            long K = this.f57293d.K() / 1000;
            nk.at atVar = this.f57294e.mMainTabViewModel;
            if (atVar != null) {
                atVar.c2(K, true);
            }
            fo.c.c("ev_qz_anniversary_modification_confirmation_button_clck", null);
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void onDismiss() {
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void t() {
        }
    }
}
