package com.qzone.reborn.groupalbum.reship.part;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.qzone.reborn.groupalbum.event.GroupAlbumMainPageTabChangeEvent;
import com.qzone.reborn.groupalbum.reship.bean.GroupAIOReshipInitBean;
import com.qzone.reborn.groupalbum.selectmedia.event.ChatHistorySelectMediaFinishEvent;
import com.qzone.reborn.part.publish.common.mediapick.QZoneMediaPickInfo;
import com.qzone.reborn.part.publish.common.uploadAlbum.QZonePublishUploadAlbumPart;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qzonehub.api.IQZoneRouteApi;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000  2\u00020\u0001:\u0001!B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016R#\u0010\u0014\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R#\u0010\u001d\u001a\n \u000f*\u0004\u0018\u00010\u00190\u00198DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006\""}, d2 = {"Lcom/qzone/reborn/groupalbum/reship/part/GroupAIOReshipPart;", "Lcom/qzone/reborn/part/publish/common/uploadAlbum/QZonePublishUploadAlbumPart;", "", "S9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "G9", "L9", "Lni/c;", "kotlin.jvm.PlatformType", "i", "Lkotlin/Lazy;", "R9", "()Lni/c;", "uploadVm", "Lcom/qzone/reborn/groupalbum/reship/bean/GroupAIOReshipInitBean;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/groupalbum/reship/bean/GroupAIOReshipInitBean;", "mInitBean", "Lcom/qzone/reborn/groupalbum/upload/selectalbum/f;", BdhLogUtil.LogTag.Tag_Conn, "Q9", "()Lcom/qzone/reborn/groupalbum/upload/selectalbum/f;", "selectAlbumBarVm", "<init>", "()V", "D", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class GroupAIOReshipPart extends QZonePublishUploadAlbumPart {

    /* renamed from: C, reason: from kotlin metadata */
    private final Lazy selectAlbumBarVm;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Lazy uploadVm;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private GroupAIOReshipInitBean mInitBean;

    public GroupAIOReshipPart() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ni.c>() { // from class: com.qzone.reborn.groupalbum.reship.part.GroupAIOReshipPart$uploadVm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ni.c invoke() {
                return (ni.c) GroupAIOReshipPart.this.getViewModel(ni.c.class);
            }
        });
        this.uploadVm = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<com.qzone.reborn.groupalbum.upload.selectalbum.f>() { // from class: com.qzone.reborn.groupalbum.reship.part.GroupAIOReshipPart$selectAlbumBarVm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.qzone.reborn.groupalbum.upload.selectalbum.f invoke() {
                return (com.qzone.reborn.groupalbum.upload.selectalbum.f) GroupAIOReshipPart.this.getViewModel(com.qzone.reborn.groupalbum.upload.selectalbum.f.class);
            }
        });
        this.selectAlbumBarVm = lazy2;
    }

    private final ni.c R9() {
        return (ni.c) this.uploadVm.getValue();
    }

    private final void S9() {
        GroupAIOReshipInitBean groupAIOReshipInitBean = this.mInitBean;
        if (groupAIOReshipInitBean != null) {
            int fromType = groupAIOReshipInitBean.getFromType();
            if (fromType == 5) {
                SimpleEventBus.getInstance().dispatchEvent(new ChatHistorySelectMediaFinishEvent(groupAIOReshipInitBean.getGroupId()));
                return;
            }
            if (fromType == 6) {
                SimpleEventBus.getInstance().dispatchEvent(new ChatHistorySelectMediaFinishEvent(groupAIOReshipInitBean.getGroupId()));
                ((IQZoneRouteApi) QRoute.api(IQZoneRouteApi.class)).launchQZoneScheme(getContext(), "mqzone://arouse/groupalbum/homealbum?groupid=" + groupAIOReshipInitBean.getGroupId());
                return;
            }
            if (fromType != 7) {
                ((IQZoneRouteApi) QRoute.api(IQZoneRouteApi.class)).launchQZoneScheme(getContext(), "mqzone://arouse/groupalbum/homealbum?groupid=" + groupAIOReshipInitBean.getGroupId());
                return;
            }
            SimpleEventBus.getInstance().dispatchEvent(new ChatHistorySelectMediaFinishEvent(groupAIOReshipInitBean.getGroupId()));
            SimpleEventBus.getInstance().dispatchEvent(new GroupAlbumMainPageTabChangeEvent(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.qzone.reborn.part.publish.common.uploadAlbum.QZonePublishUploadAlbumPart
    public void G9() {
        ni.c R9 = R9();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        com.qzone.reborn.part.publish.common.inputarea.d inputAreaVm = H9();
        Intrinsics.checkNotNullExpressionValue(inputAreaVm, "inputAreaVm");
        sl.b locationVm = I9();
        Intrinsics.checkNotNullExpressionValue(locationVm, "locationVm");
        com.qzone.reborn.groupalbum.upload.selectalbum.f selectAlbumBarVm = Q9();
        Intrinsics.checkNotNullExpressionValue(selectAlbumBarVm, "selectAlbumBarVm");
        tl.h mediaPickerVm = J9();
        Intrinsics.checkNotNullExpressionValue(mediaPickerVm, "mediaPickerVm");
        if (R9.d2(context, inputAreaVm, locationVm, selectAlbumBarVm, mediaPickerVm)) {
            S9();
            getPartHost().getHostActivity().finish();
        }
    }

    protected final com.qzone.reborn.groupalbum.upload.selectalbum.f Q9() {
        return (com.qzone.reborn.groupalbum.upload.selectalbum.f) this.selectAlbumBarVm.getValue();
    }

    @Override // com.qzone.reborn.part.publish.common.uploadAlbum.QZonePublishUploadAlbumPart, com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        LiveData<String> h26 = R9().h2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.qzone.reborn.groupalbum.reship.part.GroupAIOReshipPart$onInitView$1
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
                QQToast.makeText(GroupAIOReshipPart.this.getContext(), str, 1, 0).show();
            }
        };
        h26.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.groupalbum.reship.part.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GroupAIOReshipPart.T9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        Intent intent;
        super.onPartCreate(activity, savedInstanceState);
        Serializable serializableExtra = (activity == null || (intent = activity.getIntent()) == null) ? null : intent.getSerializableExtra("key_bundle_common_init_bean");
        this.mInitBean = serializableExtra instanceof GroupAIOReshipInitBean ? (GroupAIOReshipInitBean) serializableExtra : null;
        ni.c R9 = R9();
        GroupAIOReshipInitBean groupAIOReshipInitBean = this.mInitBean;
        QZoneMediaPickInfo P1 = R9.P1(groupAIOReshipInitBean != null ? groupAIOReshipInitBean.getDate() : null);
        if (P1 != null) {
            J9().N1(P1);
        }
    }

    @Override // com.qzone.reborn.part.publish.common.uploadAlbum.QZonePublishUploadAlbumPart
    public void L9() {
    }
}
