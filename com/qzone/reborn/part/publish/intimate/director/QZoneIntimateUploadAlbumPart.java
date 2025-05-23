package com.qzone.reborn.part.publish.intimate.director;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateAlbumDetailInitBean;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateMainPageInitBean;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateUploadAlbumInitBean;
import com.qzone.reborn.intimate.event.QZoneIntimateUpdateSpaceInfoEvent;
import com.qzone.reborn.part.publish.common.uploadAlbum.QZonePublishUploadAlbumPart;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import ho.i;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import qzone.QZoneBaseAlbumMeta$AlbumInfo;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 )2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001*B\u0007\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u001c\u0010\u000b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u000e\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016J\u0012\u0010\u0013\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0014\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00150\u0014H\u0016R#\u0010\u001d\u001a\n \u0018*\u0004\u0018\u00010\u00170\u00178DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR#\u0010\"\u001a\n \u0018*\u0004\u0018\u00010\u001e0\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006+"}, d2 = {"Lcom/qzone/reborn/part/publish/intimate/director/QZoneIntimateUploadAlbumPart;", "Lcom/qzone/reborn/part/publish/common/uploadAlbum/QZonePublishUploadAlbumPart;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/qzone/reborn/intimate/event/QZoneIntimateUpdateSpaceInfoEvent;", "", "getLogTag", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onPartCreate", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "G9", "L9", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Lcom/qzone/reborn/part/publish/common/selectalbum/c;", "kotlin.jvm.PlatformType", "i", "Lkotlin/Lazy;", "Q9", "()Lcom/qzone/reborn/part/publish/common/selectalbum/c;", "selectAlbumBarVm", "Lcom/qzone/reborn/part/publish/intimate/director/h;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "R9", "()Lcom/qzone/reborn/part/publish/intimate/director/h;", "uploadVm", "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateUploadAlbumInitBean;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateUploadAlbumInitBean;", "mInitBean", "<init>", "()V", "D", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneIntimateUploadAlbumPart extends QZonePublishUploadAlbumPart implements SimpleEventReceiver<QZoneIntimateUpdateSpaceInfoEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    private QZoneIntimateUploadAlbumInitBean mInitBean;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Lazy selectAlbumBarVm;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Lazy uploadVm;

    public QZoneIntimateUploadAlbumPart() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.qzone.reborn.part.publish.common.selectalbum.c>() { // from class: com.qzone.reborn.part.publish.intimate.director.QZoneIntimateUploadAlbumPart$selectAlbumBarVm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.qzone.reborn.part.publish.common.selectalbum.c invoke() {
                return (com.qzone.reborn.part.publish.common.selectalbum.c) QZoneIntimateUploadAlbumPart.this.getViewModel(com.qzone.reborn.part.publish.common.selectalbum.c.class);
            }
        });
        this.selectAlbumBarVm = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<h>() { // from class: com.qzone.reborn.part.publish.intimate.director.QZoneIntimateUploadAlbumPart$uploadVm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                return (h) QZoneIntimateUploadAlbumPart.this.getViewModel(h.class);
            }
        });
        this.uploadVm = lazy2;
    }

    private final h R9() {
        return (h) this.uploadVm.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.qzone.reborn.part.publish.common.uploadAlbum.QZonePublishUploadAlbumPart
    public void G9() {
        h R9 = R9();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        com.qzone.reborn.part.publish.common.inputarea.d inputAreaVm = H9();
        Intrinsics.checkNotNullExpressionValue(inputAreaVm, "inputAreaVm");
        sl.b locationVm = I9();
        Intrinsics.checkNotNullExpressionValue(locationVm, "locationVm");
        com.qzone.reborn.part.publish.common.selectalbum.c selectAlbumBarVm = Q9();
        Intrinsics.checkNotNullExpressionValue(selectAlbumBarVm, "selectAlbumBarVm");
        tl.h mediaPickerVm = J9();
        Intrinsics.checkNotNullExpressionValue(mediaPickerVm, "mediaPickerVm");
        if (R9.Z1(context, inputAreaVm, locationVm, selectAlbumBarVm, mediaPickerVm)) {
            L9();
            getPartHost().getHostActivity().finish();
        }
    }

    @Override // com.qzone.reborn.part.publish.common.uploadAlbum.QZonePublishUploadAlbumPart
    public void L9() {
        PBStringField pBStringField;
        QZoneIntimateUploadAlbumInitBean qZoneIntimateUploadAlbumInitBean = this.mInitBean;
        if (qZoneIntimateUploadAlbumInitBean != null) {
            int insertSpacePage = qZoneIntimateUploadAlbumInitBean.getInsertSpacePage();
            if (insertSpacePage == 1) {
                String spaceId = qZoneIntimateUploadAlbumInitBean.getSpaceId();
                QZoneIntimateMainPageInitBean qZoneIntimateMainPageInitBean = new QZoneIntimateMainPageInitBean();
                qZoneIntimateMainPageInitBean.setSpaceId(spaceId);
                ck.c o16 = i.o();
                Activity activity = getActivity();
                Intrinsics.checkNotNullExpressionValue(activity, "activity");
                o16.r(activity, qZoneIntimateMainPageInitBean);
                return;
            }
            if (insertSpacePage != 2) {
                return;
            }
            QZoneIntimateAlbumDetailInitBean qZoneIntimateAlbumDetailInitBean = new QZoneIntimateAlbumDetailInitBean();
            qZoneIntimateAlbumDetailInitBean.setSpaceId(qZoneIntimateUploadAlbumInitBean.getSpaceId());
            QZoneBaseAlbumMeta$AlbumInfo albumInfo = qZoneIntimateUploadAlbumInitBean.getAlbumInfo();
            String str = (albumInfo == null || (pBStringField = albumInfo.album_id) == null) ? null : pBStringField.get();
            if (str == null) {
                str = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str, "it.albumInfo?.album_id?.get() ?: \"\"");
            }
            qZoneIntimateAlbumDetailInitBean.setAlbumId(str);
            qZoneIntimateAlbumDetailInitBean.setSpaceType(qZoneIntimateUploadAlbumInitBean.getSpaceType());
            ck.c o17 = i.o();
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            o17.j(context, qZoneIntimateAlbumDetailInitBean);
        }
    }

    protected final com.qzone.reborn.part.publish.common.selectalbum.c Q9() {
        return (com.qzone.reborn.part.publish.common.selectalbum.c) this.selectAlbumBarVm.getValue();
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneIntimateUploadAlbumPart";
    }

    @Override // com.qzone.reborn.part.publish.common.uploadAlbum.QZonePublishUploadAlbumPart, com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        LiveData<String> d26 = R9().d2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.qzone.reborn.part.publish.intimate.director.QZoneIntimateUploadAlbumPart$onInitView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                QQToast.makeText(QZoneIntimateUploadAlbumPart.this.getContext(), str, 1, 0).show();
            }
        };
        d26.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.part.publish.intimate.director.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneIntimateUploadAlbumPart.S9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        Intent intent;
        super.onPartCreate(activity, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
        Serializable serializableExtra = (activity == null || (intent = activity.getIntent()) == null) ? null : intent.getSerializableExtra("key_bundle_common_init_bean");
        this.mInitBean = serializableExtra instanceof QZoneIntimateUploadAlbumInitBean ? (QZoneIntimateUploadAlbumInitBean) serializableExtra : null;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (event instanceof QZoneIntimateUpdateSpaceInfoEvent) {
            R9().f2(((QZoneIntimateUpdateSpaceInfoEvent) event).getSpaceId());
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<QZoneIntimateUpdateSpaceInfoEvent>> getEventClass() {
        ArrayList<Class<QZoneIntimateUpdateSpaceInfoEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QZoneIntimateUpdateSpaceInfoEvent.class);
        return arrayListOf;
    }
}
