package com.qzone.reborn.intimate.part.albumDetail;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateAlbumDetailInitBean;
import com.qzone.reborn.intimate.event.QZoneIntimateEditAlbumEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.ArrayUtils;
import cooperation.qzone.util.QZonePermission;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import nk.w;
import qzone.QZoneBaseAlbumMeta$AlbumInfo;
import qzone.QZoneBaseMeta$StMedia;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007\u00a2\u0006\u0004\b-\u0010.J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J \u0010\u000b\u001a\u00020\u00042\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tH\u0002J*\u0010\u000e\u001a\u00020\u00042\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0012\u0010\u001b\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0014J\b\u0010\u001e\u001a\u00020\u001cH\u0014J\b\u0010\u001f\u001a\u00020\u001cH\u0014J \u0010 \u001a\u00020\u00042\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tH\u0014J \u0010!\u001a\u00020\u00042\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tH\u0014J \u0010\"\u001a\u00020\u00042\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tH\u0014J\u0012\u0010#\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010%\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030$0\u0007j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030$`\tH\u0016R$\u0010,\u001a\u00020&2\u0006\u0010'\u001a\u00020&8\u0006@BX\u0086.\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\u00a8\u0006/"}, d2 = {"Lcom/qzone/reborn/intimate/part/albumDetail/QZoneIntimateAlbumDetailOperatePanelPart;", "Lcom/qzone/reborn/albumx/common/part/i;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "Da", "wa", "Ljava/util/ArrayList;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", "Lkotlin/collections/ArrayList;", "mediaList", "Aa", "Landroid/content/DialogInterface;", "dialog", "va", "Ea", "Lcom/qzone/reborn/intimate/event/QZoneIntimateEditAlbumEvent;", "event", "Ga", "Lcom/qzone/reborn/albumx/common/viewmodel/a;", "info", "Ha", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "", "V9", "U9", "W9", "Q9", "P9", "S9", "onReceiveEvent", "Ljava/lang/Class;", "getEventClass", "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateAlbumDetailInitBean;", "<set-?>", "J", "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateAlbumDetailInitBean;", "Fa", "()Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateAlbumDetailInitBean;", "initBean", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneIntimateAlbumDetailOperatePanelPart extends com.qzone.reborn.albumx.common.part.i implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: J, reason: from kotlin metadata */
    private QZoneIntimateAlbumDetailInitBean initBean;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/qzone/reborn/intimate/part/albumDetail/QZoneIntimateAlbumDetailOperatePanelPart$a", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class a extends QQPermission.BasePermissionsListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList<CommonStMedia> f57321b;

        a(ArrayList<CommonStMedia> arrayList) {
            this.f57321b = arrayList;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            QZoneIntimateAlbumDetailOperatePanelPart.this.L9().m2(QZoneIntimateAlbumDetailOperatePanelPart.this.Fa().getSpaceId(), String.valueOf(QZoneIntimateAlbumDetailOperatePanelPart.this.Fa().getSpaceType()), this.f57321b);
        }
    }

    private final void Aa(final ArrayList<CommonStMedia> mediaList) {
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getContext(), 230, HardCodeUtil.qqStr(R.string.sxp), HardCodeUtil.qqStr(R.string.stc), HardCodeUtil.qqStr(R.string.sqw), HardCodeUtil.qqStr(R.string.srk), new DialogInterface.OnClickListener() { // from class: com.qzone.reborn.intimate.part.albumDetail.k
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                QZoneIntimateAlbumDetailOperatePanelPart.Ba(QZoneIntimateAlbumDetailOperatePanelPart.this, mediaList, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.qzone.reborn.intimate.part.albumDetail.l
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                QZoneIntimateAlbumDetailOperatePanelPart.Ca(dialogInterface, i3);
            }
        });
        Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createCustomDialog(\n    \u2026nt -> dialog1.dismiss() }");
        createCustomDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ba(QZoneIntimateAlbumDetailOperatePanelPart this$0, ArrayList mediaList, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(mediaList, "$mediaList");
        this$0.va(mediaList, dialogInterface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ca(DialogInterface dialog1, int i3) {
        Intrinsics.checkNotNullParameter(dialog1, "dialog1");
        dialog1.dismiss();
    }

    private final void Da() {
        fo.c.o(I9(), "em_qz_download", null);
        fo.c.o(H9(), WinkDaTongReportConstant.ElementId.EM_QZ_HISTORY_DELETE, null);
    }

    private final void Ea() {
        if (F9().M1().getValue() == null) {
            return;
        }
        sj.e eVar = new sj.e();
        eVar.l(Fa().getSpaceId());
        CommonAlbumInfo value = F9().M1().getValue();
        eVar.e(value != null ? value.getAlbumId() : null);
        eVar.g(L9().W1());
        eVar.h(0);
        com.qzone.reborn.albumx.common.viewmodel.b F9 = F9();
        Intrinsics.checkNotNull(F9, "null cannot be cast to non-null type com.qzone.reborn.intimate.viewmodel.QZoneIntimateAlbumDetailViewModel");
        eVar.k(((w) F9).getDataRepo());
        L9().T1(eVar);
        L9().Q1();
    }

    private final void Ga(QZoneIntimateEditAlbumEvent event) {
        QZoneBaseAlbumMeta$AlbumInfo editAlbum;
        if (Intrinsics.areEqual(event.getSpaceId(), Fa().getSpaceId()) && (editAlbum = event.getEditAlbum()) != null && editAlbum.upload_number.get() == 0) {
            F9().b2(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ha(com.qzone.reborn.albumx.common.viewmodel.a info) {
        if (info.c()) {
            QQToast.makeText(BaseApplication.getContext(), 5, R.string.slz, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ia(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void va(ArrayList<CommonStMedia> mediaList, DialogInterface dialog) {
        ArrayList<QZoneBaseMeta$StMedia> arrayList = new ArrayList<>();
        Iterator<T> it = mediaList.iterator();
        while (it.hasNext()) {
            arrayList.add(xh.e.i((CommonStMedia) it.next()));
        }
        if (bk.e.f28497a.d(arrayList)) {
            if (dialog != null) {
                dialog.dismiss();
            }
            L9().d2().postValue(Boolean.FALSE);
            L9().b2().clear();
            QQToast.makeText(BaseApplication.getContext(), 1, R.string.stc, 0).show();
            return;
        }
        wa();
    }

    private final void wa() {
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getContext(), 230, HardCodeUtil.qqStr(R.string.ssh), HardCodeUtil.qqStr(R.string.srn), HardCodeUtil.qqStr(R.string.sqw), HardCodeUtil.qqStr(R.string.srk), new DialogInterface.OnClickListener() { // from class: com.qzone.reborn.intimate.part.albumDetail.m
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                QZoneIntimateAlbumDetailOperatePanelPart.xa(QZoneIntimateAlbumDetailOperatePanelPart.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.qzone.reborn.intimate.part.albumDetail.n
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                QZoneIntimateAlbumDetailOperatePanelPart.za(dialogInterface, i3);
            }
        });
        Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createCustomDialog(\n    \u2026nt -> dialog1.dismiss() }");
        createCustomDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xa(QZoneIntimateAlbumDetailOperatePanelPart this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.L9().d2().postValue(Boolean.FALSE);
        this$0.Ea();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void za(DialogInterface dialog1, int i3) {
        Intrinsics.checkNotNullParameter(dialog1, "dialog1");
        dialog1.dismiss();
    }

    public final QZoneIntimateAlbumDetailInitBean Fa() {
        QZoneIntimateAlbumDetailInitBean qZoneIntimateAlbumDetailInitBean = this.initBean;
        if (qZoneIntimateAlbumDetailInitBean != null) {
            return qZoneIntimateAlbumDetailInitBean;
        }
        Intrinsics.throwUninitializedPropertyAccessException("initBean");
        return null;
    }

    @Override // com.qzone.reborn.albumx.common.part.i
    protected void P9(ArrayList<CommonStMedia> mediaList) {
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        if (ArrayUtils.isOutOfArrayIndex(0, mediaList)) {
            QQToast.makeText(BaseApplication.getContext(), 1, R.string.to9, 0).show();
            return;
        }
        ArrayList<QZoneBaseMeta$StMedia> arrayList = new ArrayList<>();
        Iterator<T> it = mediaList.iterator();
        while (it.hasNext()) {
            arrayList.add(xh.e.i((CommonStMedia) it.next()));
        }
        if (bk.e.f28497a.e(arrayList)) {
            wa();
        } else {
            Aa(mediaList);
        }
    }

    @Override // com.qzone.reborn.albumx.common.part.i
    protected void Q9(ArrayList<CommonStMedia> mediaList) {
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        if (ArrayUtils.isOutOfArrayIndex(0, mediaList)) {
            QQToast.makeText(BaseApplication.getContext(), 1, R.string.to9, 0).show();
        } else if (QZonePermission.requestStoragePermission(getActivity(), new a(mediaList), QQPermissionConstants.Business.SCENE.QQ_QZONE_SAVE_MEDIA_TO_ALBUM)) {
            L9().m2(Fa().getSpaceId(), String.valueOf(Fa().getSpaceType()), mediaList);
        }
    }

    @Override // com.qzone.reborn.albumx.common.part.i
    protected void S9(ArrayList<CommonStMedia> mediaList) {
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
    }

    @Override // com.qzone.reborn.albumx.common.part.i
    protected boolean U9() {
        return true;
    }

    @Override // com.qzone.reborn.albumx.common.part.i
    protected boolean V9() {
        return true;
    }

    @Override // com.qzone.reborn.albumx.common.part.i
    protected boolean W9() {
        return false;
    }

    @Override // com.qzone.reborn.albumx.common.part.i, com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intent intent;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        SimpleEventBus.getInstance().registerReceiver(this);
        Activity activity = getActivity();
        Serializable serializableExtra = (activity == null || (intent = activity.getIntent()) == null) ? null : intent.getSerializableExtra("key_bundle_common_init_bean");
        QZoneIntimateAlbumDetailInitBean qZoneIntimateAlbumDetailInitBean = serializableExtra instanceof QZoneIntimateAlbumDetailInitBean ? (QZoneIntimateAlbumDetailInitBean) serializableExtra : null;
        Intrinsics.checkNotNull(qZoneIntimateAlbumDetailInitBean);
        this.initBean = qZoneIntimateAlbumDetailInitBean;
        MutableLiveData<com.qzone.reborn.albumx.common.viewmodel.a> X1 = L9().X1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<com.qzone.reborn.albumx.common.viewmodel.a, Unit> function1 = new Function1<com.qzone.reborn.albumx.common.viewmodel.a, Unit>() { // from class: com.qzone.reborn.intimate.part.albumDetail.QZoneIntimateAlbumDetailOperatePanelPart$onInitView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.qzone.reborn.albumx.common.viewmodel.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.qzone.reborn.albumx.common.viewmodel.a aVar) {
                if (aVar == null) {
                    return;
                }
                QZoneIntimateAlbumDetailOperatePanelPart.this.Ha(aVar);
            }
        };
        X1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.intimate.part.albumDetail.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneIntimateAlbumDetailOperatePanelPart.Ia(Function1.this, obj);
            }
        });
        Da();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (event instanceof QZoneIntimateEditAlbumEvent) {
            Ga((QZoneIntimateEditAlbumEvent) event);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QZoneIntimateEditAlbumEvent.class);
        return arrayListOf;
    }
}
