package com.qzone.reborn.intimate.part.albumlist;

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
import com.qzone.reborn.intimate.bean.QZoneIntimateSpaceBean;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateCreateAlbumDialogInitBean;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateUploadAlbumInitBean;
import com.qzone.reborn.intimate.event.QZoneIntimateDeleteAlbumFeedEvent;
import com.qzone.reborn.intimate.event.QZoneIntimateEditAlbumEvent;
import com.qzone.reborn.intimate.event.QZoneIntimateUploadAlbumEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.bl;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import nj.b;
import nk.at;
import nk.z;
import qzone.QZoneBaseAlbumMeta$AlbumInfo;
import qzone.QZoneBaseMeta$StMedia;

@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 A2\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001BB\u000f\u0012\u0006\u00100\u001a\u00020+\u00a2\u0006\u0004\b?\u0010@J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\fH\u0002J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J#\u0010\u0015\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0012H\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0002J\u0018\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\fH\u0002J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0012\u0010!\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010\"\u001a\u00020\u0005H\u0016J$\u0010&\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040$0#j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040$`%H\u0016J\u0012\u0010'\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010*\u001a\u00020\u00052\b\u0010)\u001a\u0004\u0018\u00010(H\u0016R\u0017\u00100\u001a\u00020+8\u0006\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0016\u00103\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010:\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=\u00a8\u0006C"}, d2 = {"Lcom/qzone/reborn/intimate/part/albumlist/QZoneIntimateAlbumListOperatePart;", "Lcom/qzone/reborn/base/k;", "Lqj/f;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "initViewModel", "Lcom/qzone/reborn/intimate/event/QZoneIntimateDeleteAlbumFeedEvent;", "event", "K9", "Lcom/qzone/reborn/intimate/event/QZoneIntimateUploadAlbumEvent;", "L9", "Lcom/qzone/reborn/intimate/event/QZoneIntimateEditAlbumEvent;", "M9", "Lcom/qzone/reborn/albumx/common/bean/CommonAlbumListBean;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "Q9", "", "localTopFlag", "eventTopFlag", "N9", "(Ljava/lang/Long;Ljava/lang/Long;)Z", "G9", "J9", "", "position", "I9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "e", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "onReceiveEvent", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "", "d", "Ljava/lang/String;", "getPageId", "()Ljava/lang/String;", "pageId", "Lnk/z;", "Lnk/z;", "mAlbumViewModel", "Lnk/at;", "f", "Lnk/at;", "mMainTabViewModel", tl.h.F, "Ljava/lang/Integer;", "mSpaceType", "Lnj/b;", "i", "Lnj/b;", "createAlbumDialog", "<init>", "(Ljava/lang/String;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneIntimateAlbumListOperatePart extends com.qzone.reborn.base.k implements qj.f, SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String pageId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private z mAlbumViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private at mMainTabViewModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Integer mSpaceType;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private nj.b createAlbumDialog;

    public QZoneIntimateAlbumListOperatePart(String pageId) {
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        this.pageId = pageId;
    }

    private final void G9() {
        RFWLog.i("QZoneIntimateAlbumListOperatePart", RFWLog.USR, "create album success and refresh");
        RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.qzone.reborn.intimate.part.albumlist.g
            @Override // java.lang.Runnable
            public final void run() {
                QZoneIntimateAlbumListOperatePart.H9(QZoneIntimateAlbumListOperatePart.this);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(QZoneIntimateAlbumListOperatePart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        z zVar = null;
        this$0.broadcastMessage("QZONE_INTIMATE_SCROLL_TOP", null);
        z zVar2 = this$0.mAlbumViewModel;
        if (zVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
        } else {
            zVar = zVar2;
        }
        zVar.f2(false);
    }

    private final void I9(int position) {
        RFWLog.i("QZoneIntimateAlbumListOperatePart", RFWLog.USR, "delete album success and refresh adapter");
        z zVar = this.mAlbumViewModel;
        z zVar2 = null;
        if (zVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
            zVar = null;
        }
        if (position < zVar.T1().size()) {
            z zVar3 = this.mAlbumViewModel;
            if (zVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
                zVar3 = null;
            }
            zVar3.T1().remove(position);
        }
        z zVar4 = this.mAlbumViewModel;
        if (zVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
            zVar4 = null;
        }
        if (zVar4.T1().size() == 1) {
            z zVar5 = this.mAlbumViewModel;
            if (zVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
                zVar5 = null;
            }
            if (zVar5.T1().get(0).getItemType() == 2) {
                z zVar6 = this.mAlbumViewModel;
                if (zVar6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
                    zVar6 = null;
                }
                zVar6.T1().remove(0);
            }
        }
        z zVar7 = this.mAlbumViewModel;
        if (zVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
        } else {
            zVar2 = zVar7;
        }
        zVar2.e2();
    }

    private final void J9(CommonAlbumListBean item, QZoneIntimateEditAlbumEvent event) {
        CommonAlbumInfo commonAlbumInfo;
        PBUInt64Field pBUInt64Field;
        RFWLog.i("QZoneIntimateAlbumListOperatePart", RFWLog.USR, "edit album success and refresh adapter");
        QZoneBaseAlbumMeta$AlbumInfo editAlbum = event.getEditAlbum();
        boolean z16 = false;
        if (editAlbum != null && (pBUInt64Field = editAlbum.upload_number) != null && pBUInt64Field.get() == 0) {
            z16 = true;
        }
        if (z16) {
            event.getEditAlbum().cover.set(new QZoneBaseMeta$StMedia());
        }
        QZoneBaseAlbumMeta$AlbumInfo editAlbum2 = event.getEditAlbum();
        if (editAlbum2 == null || (commonAlbumInfo = mj.a.b(editAlbum2)) == null) {
            commonAlbumInfo = new CommonAlbumInfo();
        }
        item.setAlbumInfo(commonAlbumInfo);
        z zVar = this.mAlbumViewModel;
        if (zVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
            zVar = null;
        }
        zVar.e2();
    }

    private final void K9(QZoneIntimateDeleteAlbumFeedEvent event) {
        String albumId = event.getAlbumId();
        int deleteNum = event.getDeleteNum();
        z zVar = this.mAlbumViewModel;
        z zVar2 = null;
        if (zVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
            zVar = null;
        }
        if (!bl.b(zVar.T1())) {
            z zVar3 = this.mAlbumViewModel;
            if (zVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
                zVar3 = null;
            }
            if (zVar3.c2()) {
                z zVar4 = this.mAlbumViewModel;
                if (zVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
                    zVar4 = null;
                }
                for (CommonAlbumListBean commonAlbumListBean : zVar4.T1()) {
                    if (TextUtils.equals(commonAlbumListBean.getAlbumInfo().getAlbumId(), albumId)) {
                        long uploadNumber = commonAlbumListBean.getAlbumInfo().getUploadNumber();
                        long j3 = deleteNum;
                        if (uploadNumber >= j3) {
                            commonAlbumListBean.getAlbumInfo().y0(uploadNumber - j3);
                            broadcastMessage("QZONE_INTIMATE_SCROLL_TOP", null);
                            z zVar5 = this.mAlbumViewModel;
                            if (zVar5 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
                            } else {
                                zVar2 = zVar5;
                            }
                            zVar2.f2(false);
                            return;
                        }
                        return;
                    }
                }
                return;
            }
        }
        RFWLog.e("QZoneIntimateAlbumListOperatePart", RFWLog.USR, "album list is none or is not owner");
    }

    private final void L9(QZoneIntimateUploadAlbumEvent event) {
        Object obj;
        z zVar = this.mAlbumViewModel;
        z zVar2 = null;
        if (zVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
            zVar = null;
        }
        if (!bl.b(zVar.T1())) {
            z zVar3 = this.mAlbumViewModel;
            if (zVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
                zVar3 = null;
            }
            if (zVar3.c2()) {
                z zVar4 = this.mAlbumViewModel;
                if (zVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
                    zVar4 = null;
                }
                Iterator<T> it = zVar4.T1().iterator();
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
                    broadcastMessage("QZONE_INTIMATE_SCROLL_TOP", null);
                    z zVar5 = this.mAlbumViewModel;
                    if (zVar5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
                    } else {
                        zVar2 = zVar5;
                    }
                    zVar2.f2(false);
                    return;
                }
                return;
            }
        }
        RFWLog.e("QZoneIntimateAlbumListOperatePart", RFWLog.USR, "album list is none or is not owner");
    }

    private final void M9(QZoneIntimateEditAlbumEvent event) {
        PBStringField pBStringField;
        PBStringField pBStringField2;
        z zVar = this.mAlbumViewModel;
        if (zVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
            zVar = null;
        }
        if (!zVar.c2()) {
            RFWLog.e("QZoneIntimateAlbumListOperatePart", RFWLog.USR, "space album is not owner");
            return;
        }
        if (event.getAddAlbum() != null) {
            G9();
            return;
        }
        z zVar2 = this.mAlbumViewModel;
        if (zVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
            zVar2 = null;
        }
        int size = zVar2.T1().size() - 1;
        if (size < 0) {
            return;
        }
        while (true) {
            int i3 = size - 1;
            z zVar3 = this.mAlbumViewModel;
            if (zVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
                zVar3 = null;
            }
            CommonAlbumListBean commonAlbumListBean = zVar3.T1().get(size);
            if (Q9(event, commonAlbumListBean)) {
                return;
            }
            QZoneBaseAlbumMeta$AlbumInfo editAlbum = event.getEditAlbum();
            if (Intrinsics.areEqual((editAlbum == null || (pBStringField2 = editAlbum.album_id) == null) ? null : pBStringField2.get(), commonAlbumListBean.getAlbumInfo().getAlbumId())) {
                J9(commonAlbumListBean, event);
                return;
            }
            QZoneBaseAlbumMeta$AlbumInfo deleteAlbum = event.getDeleteAlbum();
            if (Intrinsics.areEqual((deleteAlbum == null || (pBStringField = deleteAlbum.album_id) == null) ? null : pBStringField.get(), commonAlbumListBean.getAlbumInfo().getAlbumId())) {
                I9(size);
                return;
            } else if (i3 < 0) {
                return;
            } else {
                size = i3;
            }
        }
    }

    private final boolean N9(Long localTopFlag, Long eventTopFlag) {
        return !Intrinsics.areEqual(localTopFlag, eventTopFlag);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(QZoneIntimateAlbumListOperatePart this$0, boolean z16, QZoneBaseAlbumMeta$AlbumInfo qZoneBaseAlbumMeta$AlbumInfo) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (qZoneBaseAlbumMeta$AlbumInfo == null) {
            str = "";
        } else {
            str = "name:" + qZoneBaseAlbumMeta$AlbumInfo.name.get() + ", desc:" + qZoneBaseAlbumMeta$AlbumInfo.desc.get() + ", spaceId:" + qZoneBaseAlbumMeta$AlbumInfo.owner.get();
        }
        QLog.d("QZoneIntimateAlbumListOperatePart", 1, "isSuccess:" + z16 + ", albumInfo -> " + str);
        if (z16) {
            ck.c o16 = ho.i.o();
            Activity activity = this$0.getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            z zVar = this$0.mAlbumViewModel;
            if (zVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
                zVar = null;
            }
            String mSpaceId = zVar.getMSpaceId();
            Integer num = this$0.mSpaceType;
            QZoneIntimateUploadAlbumInitBean qZoneIntimateUploadAlbumInitBean = new QZoneIntimateUploadAlbumInitBean(mSpaceId, num != null ? num.intValue() : -1, false, qZoneBaseAlbumMeta$AlbumInfo, 4, null);
            qZoneIntimateUploadAlbumInitBean.setInsertSpacePage(2);
            Unit unit = Unit.INSTANCE;
            o16.y(activity, qZoneIntimateUploadAlbumInitBean);
        }
    }

    private final boolean Q9(QZoneIntimateEditAlbumEvent event, CommonAlbumListBean item) {
        PBUInt64Field pBUInt64Field;
        PBStringField pBStringField;
        QZoneBaseAlbumMeta$AlbumInfo editAlbum = event.getEditAlbum();
        z zVar = null;
        if (Intrinsics.areEqual((editAlbum == null || (pBStringField = editAlbum.album_id) == null) ? null : pBStringField.get(), item.getAlbumInfo().getAlbumId())) {
            QZoneBaseAlbumMeta$AlbumInfo editAlbum2 = event.getEditAlbum();
            if (N9((editAlbum2 == null || (pBUInt64Field = editAlbum2.top_flag) == null) ? null : Long.valueOf(pBUInt64Field.get()), Long.valueOf(item.getAlbumInfo().getTopFlag()))) {
                RFWLog.i("QZoneIntimateAlbumListOperatePart", RFWLog.USR, "hasDiffTopFlag and refresh");
                broadcastMessage("QZONE_INTIMATE_SCROLL_TOP", null);
                z zVar2 = this.mAlbumViewModel;
                if (zVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
                } else {
                    zVar = zVar2;
                }
                zVar.f2(false);
                return true;
            }
        }
        return false;
    }

    private final void initViewModel() {
        ViewModel viewModel = getViewModel(z.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneIntima\u2026istViewModel::class.java)");
        this.mAlbumViewModel = (z) viewModel;
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
        final Function1<UIStateData<QZoneIntimateSpaceBean>, Unit> function1 = new Function1<UIStateData<QZoneIntimateSpaceBean>, Unit>() { // from class: com.qzone.reborn.intimate.part.albumlist.QZoneIntimateAlbumListOperatePart$initViewModel$1
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
                    QZoneIntimateAlbumListOperatePart.this.mSpaceType = Integer.valueOf(uIStateData.getData().getSpaceType());
                }
            }
        };
        U1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.intimate.part.albumlist.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneIntimateAlbumListOperatePart.O9(Function1.this, obj);
            }
        });
    }

    @Override // qj.f
    public void e() {
        z zVar = this.mAlbumViewModel;
        z zVar2 = null;
        if (zVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
            zVar = null;
        }
        if (TextUtils.isEmpty(zVar.getMSpaceId())) {
            return;
        }
        QZoneIntimateCreateAlbumDialogInitBean qZoneIntimateCreateAlbumDialogInitBean = new QZoneIntimateCreateAlbumDialogInitBean();
        z zVar3 = this.mAlbumViewModel;
        if (zVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
        } else {
            zVar2 = zVar3;
        }
        qZoneIntimateCreateAlbumDialogInitBean.setSpaceId(zVar2.getMSpaceId());
        qZoneIntimateCreateAlbumDialogInitBean.setPageId(this.pageId);
        Integer num = this.mSpaceType;
        qZoneIntimateCreateAlbumDialogInitBean.setSpaceType(num != null ? num.intValue() : -1);
        nj.b bVar = new nj.b(getActivity(), qZoneIntimateCreateAlbumDialogInitBean);
        bVar.q0(new b.InterfaceC10848b() { // from class: com.qzone.reborn.intimate.part.albumlist.f
            @Override // nj.b.InterfaceC10848b
            public final void a(boolean z16, QZoneBaseAlbumMeta$AlbumInfo qZoneBaseAlbumMeta$AlbumInfo) {
                QZoneIntimateAlbumListOperatePart.P9(QZoneIntimateAlbumListOperatePart.this, z16, qZoneBaseAlbumMeta$AlbumInfo);
            }
        });
        bVar.show();
        this.createAlbumDialog = bVar;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        nj.b bVar = this.createAlbumDialog;
        if (bVar != null) {
            bVar.dismiss();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        SimpleEventBus.getInstance().registerReceiver(this);
        registerIoc(this, qj.f.class);
        initViewModel();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (event instanceof QZoneIntimateEditAlbumEvent) {
            M9((QZoneIntimateEditAlbumEvent) event);
        } else if (event instanceof QZoneIntimateUploadAlbumEvent) {
            L9((QZoneIntimateUploadAlbumEvent) event);
        } else if (event instanceof QZoneIntimateDeleteAlbumFeedEvent) {
            K9((QZoneIntimateDeleteAlbumFeedEvent) event);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QZoneIntimateEditAlbumEvent.class, QZoneIntimateUploadAlbumEvent.class, QZoneIntimateDeleteAlbumFeedEvent.class);
        return arrayListOf;
    }
}
