package com.qzone.reborn.groupalbum.upload;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.groupalbum.bean.init.GroupAlbumAlbumDetailInitBean;
import com.qzone.reborn.groupalbum.bean.init.GroupUploadAlbumInitBean;
import com.qzone.reborn.groupalbum.event.GroupAlbumMainPageTabChangeEvent;
import com.qzone.reborn.groupalbum.upload.selectalbum.f;
import com.qzone.reborn.part.publish.common.inputarea.d;
import com.qzone.reborn.part.publish.common.uploadAlbum.QZonePublishUploadAlbumPart;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qzonehub.api.IQZoneRouteApi;
import ho.i;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import tl.h;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000  2\u00020\u0001:\u0001!B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016R#\u0010\u0014\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R#\u0010\u001d\u001a\n \u000f*\u0004\u0018\u00010\u00190\u00198DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006\""}, d2 = {"Lcom/qzone/reborn/groupalbum/upload/GroupUploadAlbumPart;", "Lcom/qzone/reborn/part/publish/common/uploadAlbum/QZonePublishUploadAlbumPart;", "", "S9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "G9", "L9", "Lcom/qzone/reborn/groupalbum/upload/c;", "kotlin.jvm.PlatformType", "i", "Lkotlin/Lazy;", "R9", "()Lcom/qzone/reborn/groupalbum/upload/c;", "uploadVm", "Lcom/qzone/reborn/groupalbum/bean/init/GroupUploadAlbumInitBean;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/groupalbum/bean/init/GroupUploadAlbumInitBean;", "mInitBean", "Lcom/qzone/reborn/groupalbum/upload/selectalbum/f;", BdhLogUtil.LogTag.Tag_Conn, "Q9", "()Lcom/qzone/reborn/groupalbum/upload/selectalbum/f;", "selectAlbumBarVm", "<init>", "()V", "D", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class GroupUploadAlbumPart extends QZonePublishUploadAlbumPart {

    /* renamed from: C, reason: from kotlin metadata */
    private final Lazy selectAlbumBarVm;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Lazy uploadVm;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private GroupUploadAlbumInitBean mInitBean;

    public GroupUploadAlbumPart() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<c>() { // from class: com.qzone.reborn.groupalbum.upload.GroupUploadAlbumPart$uploadVm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final c invoke() {
                return (c) GroupUploadAlbumPart.this.getViewModel(c.class);
            }
        });
        this.uploadVm = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<f>() { // from class: com.qzone.reborn.groupalbum.upload.GroupUploadAlbumPart$selectAlbumBarVm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final f invoke() {
                return (f) GroupUploadAlbumPart.this.getViewModel(f.class);
            }
        });
        this.selectAlbumBarVm = lazy2;
    }

    private final c R9() {
        return (c) this.uploadVm.getValue();
    }

    private final void S9() {
        String str;
        String name;
        GroupUploadAlbumInitBean groupUploadAlbumInitBean = this.mInitBean;
        if (groupUploadAlbumInitBean != null) {
            int fromType = groupUploadAlbumInitBean.getFromType();
            if (fromType == 2) {
                SimpleEventBus.getInstance().dispatchEvent(new GroupAlbumMainPageTabChangeEvent(0));
                return;
            }
            if (fromType != 4) {
                if (fromType == 5 || fromType == 6) {
                    ((IQZoneRouteApi) QRoute.api(IQZoneRouteApi.class)).launchQZoneScheme(getContext(), "mqzone://arouse/groupalbum/homealbum?groupid=" + groupUploadAlbumInitBean.getGroupId());
                    return;
                }
                return;
            }
            GroupAlbumAlbumDetailInitBean groupAlbumAlbumDetailInitBean = new GroupAlbumAlbumDetailInitBean(groupUploadAlbumInitBean.getGroupId());
            CommonAlbumInfo albumInfo = groupUploadAlbumInitBean.getAlbumInfo();
            String str2 = "";
            if (albumInfo == null || (str = albumInfo.getAlbumId()) == null) {
                str = "";
            }
            groupAlbumAlbumDetailInitBean.setAlbumId(str);
            CommonAlbumInfo albumInfo2 = groupUploadAlbumInitBean.getAlbumInfo();
            if (albumInfo2 != null && (name = albumInfo2.getName()) != null) {
                str2 = name;
            }
            groupAlbumAlbumDetailInitBean.setAlbumName(str2);
            oi.c m3 = i.m();
            Activity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            m3.h(activity, groupAlbumAlbumDetailInitBean);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.qzone.reborn.part.publish.common.uploadAlbum.QZonePublishUploadAlbumPart
    public void G9() {
        c R9 = R9();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        d inputAreaVm = H9();
        Intrinsics.checkNotNullExpressionValue(inputAreaVm, "inputAreaVm");
        sl.b locationVm = I9();
        Intrinsics.checkNotNullExpressionValue(locationVm, "locationVm");
        f selectAlbumBarVm = Q9();
        Intrinsics.checkNotNullExpressionValue(selectAlbumBarVm, "selectAlbumBarVm");
        h mediaPickerVm = J9();
        Intrinsics.checkNotNullExpressionValue(mediaPickerVm, "mediaPickerVm");
        if (R9.Z1(context, inputAreaVm, locationVm, selectAlbumBarVm, mediaPickerVm)) {
            S9();
            getPartHost().getHostActivity().finish();
        }
    }

    @Override // com.qzone.reborn.part.publish.common.uploadAlbum.QZonePublishUploadAlbumPart
    public void L9() {
        String str;
        String name;
        GroupUploadAlbumInitBean groupUploadAlbumInitBean = this.mInitBean;
        if (groupUploadAlbumInitBean == null || groupUploadAlbumInitBean.getFromType() != 4) {
            return;
        }
        GroupAlbumAlbumDetailInitBean groupAlbumAlbumDetailInitBean = new GroupAlbumAlbumDetailInitBean(groupUploadAlbumInitBean.getGroupId());
        CommonAlbumInfo albumInfo = groupUploadAlbumInitBean.getAlbumInfo();
        String str2 = "";
        if (albumInfo == null || (str = albumInfo.getAlbumId()) == null) {
            str = "";
        }
        groupAlbumAlbumDetailInitBean.setAlbumId(str);
        CommonAlbumInfo albumInfo2 = groupUploadAlbumInitBean.getAlbumInfo();
        if (albumInfo2 != null && (name = albumInfo2.getName()) != null) {
            str2 = name;
        }
        groupAlbumAlbumDetailInitBean.setAlbumName(str2);
        oi.c m3 = i.m();
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        m3.h(activity, groupAlbumAlbumDetailInitBean);
    }

    protected final f Q9() {
        return (f) this.selectAlbumBarVm.getValue();
    }

    @Override // com.qzone.reborn.part.publish.common.uploadAlbum.QZonePublishUploadAlbumPart, com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        LiveData<String> f26 = R9().f2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.qzone.reborn.groupalbum.upload.GroupUploadAlbumPart$onInitView$1
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
                QQToast.makeText(GroupUploadAlbumPart.this.getContext(), str, 1, 0).show();
            }
        };
        f26.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.groupalbum.upload.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GroupUploadAlbumPart.T9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        Intent intent;
        super.onPartCreate(activity, savedInstanceState);
        Serializable serializableExtra = (activity == null || (intent = activity.getIntent()) == null) ? null : intent.getSerializableExtra("key_bundle_common_init_bean");
        this.mInitBean = serializableExtra instanceof GroupUploadAlbumInitBean ? (GroupUploadAlbumInitBean) serializableExtra : null;
    }
}
