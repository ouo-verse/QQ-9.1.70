package com.qzone.reborn.albumx.qzonex.part.albumlist;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.albumx.common.bean.CommonAlbumListBean;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxCreateAlbumInitBean;
import com.qzone.reborn.albumx.qzonex.bean.upload.QZAlbumxUploadAlbumInitBean;
import com.qzone.reborn.albumx.qzonex.event.QZAlbumxDeleteMediaEvent;
import com.qzone.reborn.albumx.qzonex.event.QZAlbumxEditAlbumEvent;
import com.qzone.reborn.albumx.qzonex.event.QZAlbumxUpdateAlbumEvent;
import com.qzone.reborn.albumx.qzonex.event.QZAlbumxUploadAlbumEvent;
import com.qzone.reborn.albumx.qzonex.view.g;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.utils.bl;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.AlbumInfo;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import nc.ae;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 62\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u00017B\u0007\u00a2\u0006\u0004\b4\u00105J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\fH\u0002J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J#\u0010\u0015\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0012H\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0002J\u0018\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\fH\u0002J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0012\u0010\u001e\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u0005H\u0016J$\u0010#\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040!0 j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040!`\"H\u0016J\u0012\u0010$\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010'\u001a\u00020\u00052\b\u0010&\u001a\u0004\u0018\u00010%H\u0016J\"\u0010,\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\u00192\b\u0010+\u001a\u0004\u0018\u00010*H\u0016R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00103\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u00102\u00a8\u00068"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/albumlist/l;", "Lcom/qzone/reborn/base/k;", "Lhb/a;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "initViewModel", "Lcom/qzone/reborn/albumx/qzonex/event/QZAlbumxUpdateAlbumEvent;", "event", "K9", "Lcom/qzone/reborn/albumx/qzonex/event/QZAlbumxUploadAlbumEvent;", "I9", "Lcom/qzone/reborn/albumx/qzonex/event/QZAlbumxEditAlbumEvent;", "J9", "Lcom/qzone/reborn/albumx/common/bean/CommonAlbumListBean;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "N9", "", "localTopFlag", "eventTopFlag", "L9", "(Ljava/lang/Long;Ljava/lang/Long;)Z", "E9", "H9", "", "position", "G9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "e", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "onReceiveEvent", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Lcom/qzone/reborn/albumx/qzonex/view/g;", "d", "Lcom/qzone/reborn/albumx/qzonex/view/g;", "createAlbumDialog", "Lnc/ae;", "Lnc/ae;", "albumViewModel", "<init>", "()V", "f", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class l extends com.qzone.reborn.base.k implements hb.a, SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.albumx.qzonex.view.g createAlbumDialog;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ae albumViewModel;

    private final void E9() {
        RFWLog.i("QZAlbumxAlbumListOperatePart", RFWLog.USR, "create album success and refresh");
        RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.qzone.reborn.albumx.qzonex.part.albumlist.k
            @Override // java.lang.Runnable
            public final void run() {
                l.F9(l.this);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(l this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ae aeVar = this$0.albumViewModel;
        if (aeVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumViewModel");
            aeVar = null;
        }
        aeVar.h2(false, false);
    }

    private final void G9(int position) {
        RFWLog.i("QZAlbumxAlbumListOperatePart", RFWLog.USR, "delete album success and refresh adapter.  position=" + position);
        ae aeVar = this.albumViewModel;
        if (aeVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumViewModel");
            aeVar = null;
        }
        aeVar.h2(false, false);
    }

    private final void H9(CommonAlbumListBean item, QZAlbumxEditAlbumEvent event) {
        CommonAlbumInfo editAlbum;
        RFWLog.i("QZAlbumxAlbumListOperatePart", RFWLog.USR, "edit album success and refresh adapter");
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
        ae aeVar = this.albumViewModel;
        if (aeVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumViewModel");
            aeVar = null;
        }
        aeVar.g2();
    }

    private final void I9(QZAlbumxUploadAlbumEvent event) {
        ae aeVar = this.albumViewModel;
        ae aeVar2 = null;
        if (aeVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumViewModel");
            aeVar = null;
        }
        if (!bl.b(aeVar.X1())) {
            ae aeVar3 = this.albumViewModel;
            if (aeVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("albumViewModel");
                aeVar3 = null;
            }
            if (aeVar3.d2()) {
                ae aeVar4 = this.albumViewModel;
                if (aeVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("albumViewModel");
                } else {
                    aeVar2 = aeVar4;
                }
                aeVar2.h2(false, false);
                return;
            }
        }
        RFWLog.e("QZAlbumxAlbumListOperatePart", RFWLog.USR, "album list is none or is not owner");
    }

    private final void J9(QZAlbumxEditAlbumEvent event) {
        ae aeVar = this.albumViewModel;
        if (aeVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumViewModel");
            aeVar = null;
        }
        if (!aeVar.d2()) {
            RFWLog.e("QZAlbumxAlbumListOperatePart", RFWLog.USR, "space album is not owner");
            return;
        }
        if (event.getAddAlbum() != null) {
            E9();
            return;
        }
        ae aeVar2 = this.albumViewModel;
        if (aeVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumViewModel");
            aeVar2 = null;
        }
        int size = aeVar2.X1().size() - 1;
        if (size < 0) {
            return;
        }
        while (true) {
            int i3 = size - 1;
            ae aeVar3 = this.albumViewModel;
            if (aeVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("albumViewModel");
                aeVar3 = null;
            }
            CommonAlbumListBean commonAlbumListBean = aeVar3.X1().get(size);
            if (N9(event, commonAlbumListBean)) {
                return;
            }
            CommonAlbumInfo editAlbum = event.getEditAlbum();
            if (Intrinsics.areEqual(editAlbum != null ? editAlbum.getAlbumId() : null, commonAlbumListBean.getAlbumInfo().getAlbumId())) {
                H9(commonAlbumListBean, event);
                return;
            }
            CommonAlbumInfo deleteAlbum = event.getDeleteAlbum();
            if (Intrinsics.areEqual(deleteAlbum != null ? deleteAlbum.getAlbumId() : null, commonAlbumListBean.getAlbumInfo().getAlbumId())) {
                G9(size);
                return;
            } else if (i3 < 0) {
                return;
            } else {
                size = i3;
            }
        }
    }

    private final void K9(QZAlbumxUpdateAlbumEvent event) {
        ae aeVar = this.albumViewModel;
        ae aeVar2 = null;
        if (aeVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumViewModel");
            aeVar = null;
        }
        if (!bl.b(aeVar.X1())) {
            ae aeVar3 = this.albumViewModel;
            if (aeVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("albumViewModel");
                aeVar3 = null;
            }
            if (aeVar3.d2()) {
                ae aeVar4 = this.albumViewModel;
                if (aeVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("albumViewModel");
                } else {
                    aeVar2 = aeVar4;
                }
                aeVar2.h2(false, false);
                return;
            }
        }
        RFWLog.e("QZAlbumxAlbumListOperatePart", RFWLog.USR, "[handleUpdateAlbumEvent] album list is none or is not owner");
    }

    private final boolean L9(Long localTopFlag, Long eventTopFlag) {
        return !Intrinsics.areEqual(localTopFlag, eventTopFlag);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(l this$0, boolean z16, AlbumInfo albumInfo) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (albumInfo == null) {
            str = "";
        } else {
            str = "name:" + albumInfo.name + ", desc:" + albumInfo.desc + ", owner:" + albumInfo.owner + ", permissionType:" + albumInfo.permission.permissionType;
        }
        QLog.d("QZAlbumxAlbumListOperatePart", 1, "isSuccess:" + z16 + ", albumInfo -> " + str);
        if (z16) {
            vb.b x16 = ho.i.x();
            Intrinsics.checkNotNullExpressionValue(x16, "qzAlbumx()");
            Activity activity = this$0.getActivity();
            ae aeVar = this$0.albumViewModel;
            if (aeVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("albumViewModel");
                aeVar = null;
            }
            String uin = aeVar.a2().getUin();
            Intrinsics.checkNotNullExpressionValue(albumInfo, "albumInfo");
            vb.b.m(x16, activity, new QZAlbumxUploadAlbumInitBean(uin, -1, false, xh.a.a(albumInfo), 3, 4, null), null, 4, null);
        }
    }

    private final boolean N9(QZAlbumxEditAlbumEvent event, CommonAlbumListBean item) {
        CommonAlbumInfo editAlbum = event.getEditAlbum();
        ae aeVar = null;
        if (Intrinsics.areEqual(editAlbum != null ? editAlbum.getAlbumId() : null, item.getAlbumInfo().getAlbumId())) {
            CommonAlbumInfo editAlbum2 = event.getEditAlbum();
            if (L9(editAlbum2 != null ? Long.valueOf(editAlbum2.getTopFlag()) : null, Long.valueOf(item.getAlbumInfo().getTopFlag()))) {
                RFWLog.i("QZAlbumxAlbumListOperatePart", RFWLog.USR, "hasDiffTopFlag and refresh");
                broadcastMessage("QZONE_INTIMATE_SCROLL_TOP", null);
                ae aeVar2 = this.albumViewModel;
                if (aeVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("albumViewModel");
                } else {
                    aeVar = aeVar2;
                }
                aeVar.h2(false, false);
                return true;
            }
        }
        return false;
    }

    private final void initViewModel() {
        ViewModel viewModel = getViewModel(ae.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZAlbumxAlb\u2026istViewModel::class.java)");
        this.albumViewModel = (ae) viewModel;
    }

    @Override // hb.a
    public void e() {
        ae aeVar = this.albumViewModel;
        ae aeVar2 = null;
        if (aeVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumViewModel");
            aeVar = null;
        }
        if (TextUtils.isEmpty(aeVar.a2().getUin())) {
            return;
        }
        ae aeVar3 = this.albumViewModel;
        if (aeVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumViewModel");
        } else {
            aeVar2 = aeVar3;
        }
        com.qzone.reborn.albumx.qzonex.view.g gVar = new com.qzone.reborn.albumx.qzonex.view.g(getActivity(), new QZAlbumxCreateAlbumInitBean(aeVar2.a2().getUin()));
        gVar.E0(new g.a() { // from class: com.qzone.reborn.albumx.qzonex.part.albumlist.j
            @Override // com.qzone.reborn.albumx.qzonex.view.g.a
            public final void a(boolean z16, AlbumInfo albumInfo) {
                l.M9(l.this, z16, albumInfo);
            }
        });
        gVar.show();
        this.createAlbumDialog = gVar;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        com.qzone.reborn.albumx.qzonex.view.g gVar = this.createAlbumDialog;
        if (gVar != null) {
            gVar.A0(requestCode, resultCode, data);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        SimpleEventBus.getInstance().registerReceiver(this);
        registerIoc(this, hb.a.class);
        initViewModel();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (event instanceof QZAlbumxEditAlbumEvent) {
            J9((QZAlbumxEditAlbumEvent) event);
            return;
        }
        if (event instanceof QZAlbumxUploadAlbumEvent) {
            I9((QZAlbumxUploadAlbumEvent) event);
            return;
        }
        if (event instanceof QZAlbumxDeleteMediaEvent) {
            ae aeVar = this.albumViewModel;
            if (aeVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("albumViewModel");
                aeVar = null;
            }
            aeVar.h2(false, false);
            return;
        }
        if (event instanceof QZAlbumxUpdateAlbumEvent) {
            K9((QZAlbumxUpdateAlbumEvent) event);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QZAlbumxEditAlbumEvent.class, QZAlbumxUploadAlbumEvent.class, QZAlbumxDeleteMediaEvent.class, QZAlbumxUpdateAlbumEvent.class);
        return arrayListOf;
    }
}
