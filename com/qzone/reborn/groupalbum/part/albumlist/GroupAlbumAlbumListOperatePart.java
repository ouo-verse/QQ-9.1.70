package com.qzone.reborn.groupalbum.part.albumlist;

import android.app.Activity;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.albumx.common.bean.CommonAlbumListBean;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.qzone.reborn.groupalbum.bean.init.GroupAlbumCreateAlbumInitBean;
import com.qzone.reborn.groupalbum.bean.init.GroupUploadAlbumInitBean;
import com.qzone.reborn.groupalbum.dialog.GroupAlbumCreateAlbumDialog;
import com.qzone.reborn.groupalbum.event.GroupAlbumDeleteFeedEvent;
import com.qzone.reborn.groupalbum.event.GroupAlbumDeleteMediaEvent;
import com.qzone.reborn.groupalbum.event.GroupAlbumEditAlbumEvent;
import com.qzone.reborn.groupalbum.event.GroupAlbumUploadAlbumEvent;
import com.qzone.reborn.intimate.bean.QZoneIntimateSpaceBean;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.bl;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.AlbumInfo;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import nk.at;

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ?2\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001@B\u0011\u0012\b\b\u0002\u0010.\u001a\u00020)\u00a2\u0006\u0004\b=\u0010>J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\nH\u0002J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J#\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0010H\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0015\u001a\u00020\u0005H\u0002J\u0018\u0010\u0016\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\nH\u0002J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0012\u0010\u001f\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010 \u001a\u00020\u0005H\u0016J$\u0010$\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\"0!j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\"`#H\u0016J\u0012\u0010%\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010(\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010&H\u0016R\u0017\u0010.\u001a\u00020)8\u0006\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0016\u00101\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00108\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;\u00a8\u0006A"}, d2 = {"Lcom/qzone/reborn/groupalbum/part/albumlist/GroupAlbumAlbumListOperatePart;", "Lcom/qzone/reborn/base/k;", "Lai/a;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "initViewModel", "Lcom/qzone/reborn/groupalbum/event/GroupAlbumUploadAlbumEvent;", "event", "K9", "Lcom/qzone/reborn/groupalbum/event/GroupAlbumEditAlbumEvent;", "L9", "Lcom/qzone/reborn/albumx/common/bean/CommonAlbumListBean;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "P9", "", "localTopFlag", "eventTopFlag", "M9", "(Ljava/lang/Long;Ljava/lang/Long;)Z", "G9", "J9", "", "position", "I9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "e", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "onReceiveEvent", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "", "d", "Ljava/lang/String;", "getPageId", "()Ljava/lang/String;", "pageId", "Lcom/qzone/reborn/groupalbum/viewmodel/g;", "Lcom/qzone/reborn/groupalbum/viewmodel/g;", "mAlbumViewModel", "Lnk/at;", "f", "Lnk/at;", "mMainTabViewModel", tl.h.F, "Ljava/lang/Integer;", "mSpaceType", "Lcom/qzone/reborn/groupalbum/dialog/GroupAlbumCreateAlbumDialog;", "i", "Lcom/qzone/reborn/groupalbum/dialog/GroupAlbumCreateAlbumDialog;", "createAlbumDialog", "<init>", "(Ljava/lang/String;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class GroupAlbumAlbumListOperatePart extends com.qzone.reborn.base.k implements ai.a, SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String pageId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.groupalbum.viewmodel.g mAlbumViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private at mMainTabViewModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Integer mSpaceType;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private GroupAlbumCreateAlbumDialog createAlbumDialog;

    public GroupAlbumAlbumListOperatePart(String pageId) {
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        this.pageId = pageId;
    }

    private final void G9() {
        RFWLog.i("GroupAlbumAlbumListOperatePart", RFWLog.USR, "create album success and refresh");
        RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.qzone.reborn.groupalbum.part.albumlist.j
            @Override // java.lang.Runnable
            public final void run() {
                GroupAlbumAlbumListOperatePart.H9(GroupAlbumAlbumListOperatePart.this);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(GroupAlbumAlbumListOperatePart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.qzone.reborn.groupalbum.viewmodel.g gVar = null;
        this$0.broadcastMessage("QZONE_INTIMATE_SCROLL_TOP", null);
        com.qzone.reborn.groupalbum.viewmodel.g gVar2 = this$0.mAlbumViewModel;
        if (gVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
        } else {
            gVar = gVar2;
        }
        gVar.f2(false);
    }

    private final void I9(int position) {
        RFWLog.i("GroupAlbumAlbumListOperatePart", RFWLog.USR, "delete album success and refresh adapter");
        com.qzone.reborn.groupalbum.viewmodel.g gVar = this.mAlbumViewModel;
        com.qzone.reborn.groupalbum.viewmodel.g gVar2 = null;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
            gVar = null;
        }
        if (position < gVar.X1().size()) {
            com.qzone.reborn.groupalbum.viewmodel.g gVar3 = this.mAlbumViewModel;
            if (gVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
                gVar3 = null;
            }
            gVar3.X1().remove(position);
        }
        com.qzone.reborn.groupalbum.viewmodel.g gVar4 = this.mAlbumViewModel;
        if (gVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
            gVar4 = null;
        }
        if (gVar4.X1().size() == 1) {
            com.qzone.reborn.groupalbum.viewmodel.g gVar5 = this.mAlbumViewModel;
            if (gVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
                gVar5 = null;
            }
            if (gVar5.X1().get(0).getItemType() == 2) {
                com.qzone.reborn.groupalbum.viewmodel.g gVar6 = this.mAlbumViewModel;
                if (gVar6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
                    gVar6 = null;
                }
                gVar6.X1().remove(0);
            }
        }
        com.qzone.reborn.groupalbum.viewmodel.g gVar7 = this.mAlbumViewModel;
        if (gVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
            gVar7 = null;
        }
        gVar7.e2();
        com.qzone.reborn.groupalbum.viewmodel.g gVar8 = this.mAlbumViewModel;
        if (gVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
        } else {
            gVar2 = gVar8;
        }
        gVar2.f2(false);
    }

    private final void J9(CommonAlbumListBean item, GroupAlbumEditAlbumEvent event) {
        CommonAlbumInfo editAlbum;
        RFWLog.i("GroupAlbumAlbumListOperatePart", RFWLog.USR, "edit album success and refresh adapter");
        CommonAlbumInfo editAlbum2 = event.getEditAlbum();
        boolean z16 = false;
        if (editAlbum2 != null && editAlbum2.getUploadNumber() == 0) {
            z16 = true;
        }
        if (z16 && (editAlbum = event.getEditAlbum()) != null) {
            editAlbum.b0(new CommonStMedia());
        }
        CommonAlbumInfo editAlbum3 = event.getEditAlbum();
        if (editAlbum3 == null) {
            editAlbum3 = new CommonAlbumInfo();
        }
        item.setAlbumInfo(editAlbum3);
        com.qzone.reborn.groupalbum.viewmodel.g gVar = this.mAlbumViewModel;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
            gVar = null;
        }
        gVar.e2();
    }

    private final void K9(GroupAlbumUploadAlbumEvent event) {
        Object obj;
        com.qzone.reborn.groupalbum.viewmodel.g gVar = this.mAlbumViewModel;
        com.qzone.reborn.groupalbum.viewmodel.g gVar2 = null;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
            gVar = null;
        }
        if (!bl.b(gVar.X1())) {
            com.qzone.reborn.groupalbum.viewmodel.g gVar3 = this.mAlbumViewModel;
            if (gVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
                gVar3 = null;
            }
            if (gVar3.b2()) {
                com.qzone.reborn.groupalbum.viewmodel.g gVar4 = this.mAlbumViewModel;
                if (gVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
                    gVar4 = null;
                }
                Iterator<T> it = gVar4.X1().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    } else {
                        obj = it.next();
                        if (Intrinsics.areEqual(event.getAlbumId(), ((CommonAlbumListBean) obj).getAlbumInfo().getAlbumId())) {
                            break;
                        }
                    }
                }
                if (((CommonAlbumListBean) obj) != null) {
                    com.qzone.reborn.groupalbum.viewmodel.g gVar5 = this.mAlbumViewModel;
                    if (gVar5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
                    } else {
                        gVar2 = gVar5;
                    }
                    gVar2.f2(false);
                    return;
                }
                return;
            }
        }
        RFWLog.e("GroupAlbumAlbumListOperatePart", RFWLog.USR, "album list is none or is not owner");
    }

    private final void L9(GroupAlbumEditAlbumEvent event) {
        com.qzone.reborn.groupalbum.viewmodel.g gVar = this.mAlbumViewModel;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
            gVar = null;
        }
        if (!gVar.b2()) {
            RFWLog.e("GroupAlbumAlbumListOperatePart", RFWLog.USR, "space album is not owner");
            return;
        }
        if (event.getAddAlbum() != null) {
            G9();
            return;
        }
        com.qzone.reborn.groupalbum.viewmodel.g gVar2 = this.mAlbumViewModel;
        if (gVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
            gVar2 = null;
        }
        int size = gVar2.X1().size() - 1;
        if (size < 0) {
            return;
        }
        while (true) {
            int i3 = size - 1;
            com.qzone.reborn.groupalbum.viewmodel.g gVar3 = this.mAlbumViewModel;
            if (gVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
                gVar3 = null;
            }
            CommonAlbumListBean commonAlbumListBean = gVar3.X1().get(size);
            if (P9(event, commonAlbumListBean)) {
                return;
            }
            CommonAlbumInfo editAlbum = event.getEditAlbum();
            if (Intrinsics.areEqual(editAlbum != null ? editAlbum.getAlbumId() : null, commonAlbumListBean.getAlbumInfo().getAlbumId())) {
                J9(commonAlbumListBean, event);
                return;
            }
            CommonAlbumInfo deleteAlbum = event.getDeleteAlbum();
            if (Intrinsics.areEqual(deleteAlbum != null ? deleteAlbum.getAlbumId() : null, commonAlbumListBean.getAlbumInfo().getAlbumId())) {
                I9(size);
                return;
            } else if (i3 < 0) {
                return;
            } else {
                size = i3;
            }
        }
    }

    private final boolean M9(Long localTopFlag, Long eventTopFlag) {
        return !Intrinsics.areEqual(localTopFlag, eventTopFlag);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(GroupAlbumAlbumListOperatePart this$0, boolean z16, AlbumInfo albumInfo) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (albumInfo == null) {
            str = "";
        } else {
            str = "name:" + albumInfo.name + ", desc:" + albumInfo.desc + ", spaceId:" + albumInfo.owner;
        }
        QLog.d("GroupAlbumAlbumListOperatePart", 1, "isSuccess:" + z16 + ", albumInfo -> " + str);
        if (z16) {
            oi.c m3 = ho.i.m();
            Activity activity = this$0.getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            com.qzone.reborn.groupalbum.viewmodel.g gVar = this$0.mAlbumViewModel;
            if (gVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
                gVar = null;
            }
            String groupId = gVar.Z1().getGroupId();
            Integer num = this$0.mSpaceType;
            int intValue = num != null ? num.intValue() : -1;
            Intrinsics.checkNotNullExpressionValue(albumInfo, "albumInfo");
            GroupUploadAlbumInitBean groupUploadAlbumInitBean = new GroupUploadAlbumInitBean(groupId, intValue, false, xh.a.a(albumInfo), 4, 4, null);
            groupUploadAlbumInitBean.setInsertSpacePage(2);
            Unit unit = Unit.INSTANCE;
            m3.n(activity, groupUploadAlbumInitBean);
        }
    }

    private final boolean P9(GroupAlbumEditAlbumEvent event, CommonAlbumListBean item) {
        CommonAlbumInfo editAlbum = event.getEditAlbum();
        com.qzone.reborn.groupalbum.viewmodel.g gVar = null;
        if (Intrinsics.areEqual(editAlbum != null ? editAlbum.getAlbumId() : null, item.getAlbumInfo().getAlbumId())) {
            CommonAlbumInfo editAlbum2 = event.getEditAlbum();
            if (M9(editAlbum2 != null ? Long.valueOf(editAlbum2.getTopFlag()) : null, Long.valueOf(item.getAlbumInfo().getTopFlag()))) {
                RFWLog.i("GroupAlbumAlbumListOperatePart", RFWLog.USR, "hasDiffTopFlag and refresh");
                broadcastMessage("QZONE_INTIMATE_SCROLL_TOP", null);
                com.qzone.reborn.groupalbum.viewmodel.g gVar2 = this.mAlbumViewModel;
                if (gVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
                } else {
                    gVar = gVar2;
                }
                gVar.f2(false);
                return true;
            }
        }
        return false;
    }

    private final void initViewModel() {
        ViewModel viewModel = getViewModel(com.qzone.reborn.groupalbum.viewmodel.g.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(GroupAlbumA\u2026istViewModel::class.java)");
        this.mAlbumViewModel = (com.qzone.reborn.groupalbum.viewmodel.g) viewModel;
        ViewModel x95 = x9(at.class);
        Intrinsics.checkNotNullExpressionValue(x95, "getOuterViewModel(QZoneI\u2026TabViewModel::class.java)");
        at atVar = (at) x95;
        this.mMainTabViewModel = atVar;
        if (atVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMainTabViewModel");
            atVar = null;
        }
        MutableLiveData<UIStateData<QZoneIntimateSpaceBean>> U1 = atVar.U1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<UIStateData<QZoneIntimateSpaceBean>, Unit> function1 = new Function1<UIStateData<QZoneIntimateSpaceBean>, Unit>() { // from class: com.qzone.reborn.groupalbum.part.albumlist.GroupAlbumAlbumListOperatePart$initViewModel$1
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
                if (uIStateData.getData() != null) {
                    GroupAlbumAlbumListOperatePart.this.mSpaceType = Integer.valueOf(uIStateData.getData().getSpaceType());
                }
            }
        };
        U1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.groupalbum.part.albumlist.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GroupAlbumAlbumListOperatePart.N9(Function1.this, obj);
            }
        });
    }

    @Override // ai.a
    public void e() {
        com.qzone.reborn.groupalbum.viewmodel.g gVar = this.mAlbumViewModel;
        com.qzone.reborn.groupalbum.viewmodel.g gVar2 = null;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
            gVar = null;
        }
        if (TextUtils.isEmpty(gVar.Z1().getGroupId())) {
            return;
        }
        com.qzone.reborn.groupalbum.viewmodel.g gVar3 = this.mAlbumViewModel;
        if (gVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
        } else {
            gVar2 = gVar3;
        }
        GroupAlbumCreateAlbumInitBean groupAlbumCreateAlbumInitBean = new GroupAlbumCreateAlbumInitBean(gVar2.Z1().getGroupId());
        groupAlbumCreateAlbumInitBean.setPageId(this.pageId);
        Integer num = this.mSpaceType;
        groupAlbumCreateAlbumInitBean.setSpaceType(num != null ? num.intValue() : -1);
        GroupAlbumCreateAlbumDialog groupAlbumCreateAlbumDialog = new GroupAlbumCreateAlbumDialog(getActivity(), groupAlbumCreateAlbumInitBean);
        groupAlbumCreateAlbumDialog.r0(new GroupAlbumCreateAlbumDialog.a() { // from class: com.qzone.reborn.groupalbum.part.albumlist.h
            @Override // com.qzone.reborn.groupalbum.dialog.GroupAlbumCreateAlbumDialog.a
            public final void a(boolean z16, AlbumInfo albumInfo) {
                GroupAlbumAlbumListOperatePart.O9(GroupAlbumAlbumListOperatePart.this, z16, albumInfo);
            }
        });
        groupAlbumCreateAlbumDialog.show();
        this.createAlbumDialog = groupAlbumCreateAlbumDialog;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        GroupAlbumCreateAlbumDialog groupAlbumCreateAlbumDialog = this.createAlbumDialog;
        if (groupAlbumCreateAlbumDialog != null) {
            groupAlbumCreateAlbumDialog.dismiss();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        SimpleEventBus.getInstance().registerReceiver(this);
        registerIoc(this, ai.a.class);
        initViewModel();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (event instanceof GroupAlbumEditAlbumEvent) {
            L9((GroupAlbumEditAlbumEvent) event);
            return;
        }
        if (event instanceof GroupAlbumUploadAlbumEvent) {
            K9((GroupAlbumUploadAlbumEvent) event);
            return;
        }
        if ((event instanceof GroupAlbumDeleteMediaEvent) || (event instanceof GroupAlbumDeleteFeedEvent)) {
            com.qzone.reborn.groupalbum.viewmodel.g gVar = this.mAlbumViewModel;
            if (gVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
                gVar = null;
            }
            gVar.f2(false);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(GroupAlbumEditAlbumEvent.class, GroupAlbumUploadAlbumEvent.class, GroupAlbumDeleteMediaEvent.class, GroupAlbumDeleteFeedEvent.class);
        return arrayListOf;
    }
}
