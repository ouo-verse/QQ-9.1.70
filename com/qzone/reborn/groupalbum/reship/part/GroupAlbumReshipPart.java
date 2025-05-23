package com.qzone.reborn.groupalbum.reship.part;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.qzone.reborn.groupalbum.reship.bean.GroupAlbumReshipInitBean;
import com.qzone.reborn.part.publish.common.uploadAlbum.QZonePublishUploadAlbumPart;
import com.qzone.widget.dynamicgridview.DynamicArrayList;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.ArrayUtils;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 (2\u00020\u0001:\u0001)B\u0007\u00a2\u0006\u0004\b&\u0010'J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016R#\u0010\u0013\u001a\n \u000e*\u0004\u0018\u00010\r0\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R#\u0010\u0018\u001a\n \u000e*\u0004\u0018\u00010\u00140\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0017R#\u0010\u001d\u001a\n \u000e*\u0004\u0018\u00010\u00190\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006*"}, d2 = {"Lcom/qzone/reborn/groupalbum/reship/part/GroupAlbumReshipPart;", "Lcom/qzone/reborn/part/publish/common/uploadAlbum/QZonePublishUploadAlbumPart;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "", "action", "", "args", "handleBroadcastMessage", "G9", "L9", "Lni/h;", "kotlin.jvm.PlatformType", "i", "Lkotlin/Lazy;", "U9", "()Lni/h;", "reshipViewModel", "Lni/e;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "V9", "()Lni/e;", "selectViewModel", "Lvl/f;", BdhLogUtil.LogTag.Tag_Conn, "W9", "()Lvl/f;", "titleViewModel", "Lcom/qzone/reborn/groupalbum/reship/bean/GroupAlbumReshipInitBean;", "D", "Lcom/qzone/reborn/groupalbum/reship/bean/GroupAlbumReshipInitBean;", "initBean", "", "E", "Z", "hasInit", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class GroupAlbumReshipPart extends QZonePublishUploadAlbumPart {

    /* renamed from: C, reason: from kotlin metadata */
    private final Lazy titleViewModel;

    /* renamed from: D, reason: from kotlin metadata */
    private GroupAlbumReshipInitBean initBean;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean hasInit;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Lazy reshipViewModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Lazy selectViewModel;

    public GroupAlbumReshipPart() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ni.h>() { // from class: com.qzone.reborn.groupalbum.reship.part.GroupAlbumReshipPart$reshipViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ni.h invoke() {
                return (ni.h) GroupAlbumReshipPart.this.getViewModel(ni.h.class);
            }
        });
        this.reshipViewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ni.e>() { // from class: com.qzone.reborn.groupalbum.reship.part.GroupAlbumReshipPart$selectViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ni.e invoke() {
                return (ni.e) GroupAlbumReshipPart.this.getViewModel(ni.e.class);
            }
        });
        this.selectViewModel = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<vl.f>() { // from class: com.qzone.reborn.groupalbum.reship.part.GroupAlbumReshipPart$titleViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final vl.f invoke() {
                return (vl.f) GroupAlbumReshipPart.this.getViewModel(vl.f.class);
            }
        });
        this.titleViewModel = lazy3;
    }

    private final ni.h U9() {
        return (ni.h) this.reshipViewModel.getValue();
    }

    private final ni.e V9() {
        return (ni.e) this.selectViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final vl.f W9() {
        return (vl.f) this.titleViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.qzone.reborn.part.publish.common.uploadAlbum.QZonePublishUploadAlbumPart
    public void G9() {
        if (U9().O1().isEmpty()) {
            QQToast.makeText(BaseApplication.getContext(), 4, R.string.to7, 0).show();
            return;
        }
        ni.h U9 = U9();
        com.qzone.reborn.part.publish.common.inputarea.d inputAreaVm = H9();
        Intrinsics.checkNotNullExpressionValue(inputAreaVm, "inputAreaVm");
        ni.e selectViewModel = V9();
        Intrinsics.checkNotNullExpressionValue(selectViewModel, "selectViewModel");
        tl.h mediaPickerVm = J9();
        Intrinsics.checkNotNullExpressionValue(mediaPickerVm, "mediaPickerVm");
        U9.M1(inputAreaVm, selectViewModel, mediaPickerVm);
    }

    @Override // com.qzone.reborn.part.publish.common.uploadAlbum.QZonePublishUploadAlbumPart, com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String action, Object args) {
        super.handleBroadcastMessage(action, args);
    }

    @Override // com.qzone.reborn.part.publish.common.uploadAlbum.QZonePublishUploadAlbumPart, com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        GroupAlbumReshipInitBean initBean = U9().getInitBean();
        this.initBean = initBean;
        if (initBean != null) {
            if (ArrayUtils.isOutOfArrayIndex(0, initBean != null ? initBean.getMediaList() : null)) {
                return;
            }
            DynamicArrayList<String> dynamicArrayList = new DynamicArrayList<>();
            HashMap<String, ShuoshuoVideoInfo> hashMap = new HashMap<>();
            GroupAlbumReshipInitBean groupAlbumReshipInitBean = this.initBean;
            Intrinsics.checkNotNull(groupAlbumReshipInitBean);
            for (CommonStMedia commonStMedia : groupAlbumReshipInitBean.getMediaList()) {
                dynamicArrayList.add(commonStMedia.l());
                if (commonStMedia.u()) {
                    ShuoshuoVideoInfo shuoshuoVideoInfo = new ShuoshuoVideoInfo();
                    shuoshuoVideoInfo.mCoverUrl = commonStMedia.t();
                    shuoshuoVideoInfo.mDuration = commonStMedia.getVideo().getVideoTime();
                    hashMap.put(commonStMedia.l(), shuoshuoVideoInfo);
                }
            }
            J9().b2(hashMap);
            J9().P1().setValue(dynamicArrayList);
            MutableLiveData<Boolean> Q1 = U9().Q1();
            Fragment hostFragment = getHostFragment();
            final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.qzone.reborn.groupalbum.reship.part.GroupAlbumReshipPart$onInitView$1
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
                public final void invoke2(Boolean it) {
                    boolean z16;
                    z16 = GroupAlbumReshipPart.this.hasInit;
                    if (!z16) {
                        GroupAlbumReshipPart.this.hasInit = true;
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    if (it.booleanValue()) {
                        QQToast.makeText(BaseApplication.getContext(), 5, R.string.f169547v60, 0).show();
                        GroupAlbumReshipPart.this.getActivity().finish();
                    } else {
                        QQToast.makeText(BaseApplication.getContext(), 4, R.string.v58, 0).show();
                    }
                }
            };
            Q1.observe(hostFragment, new Observer() { // from class: com.qzone.reborn.groupalbum.reship.part.c
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    GroupAlbumReshipPart.X9(Function1.this, obj);
                }
            });
            MutableLiveData<List<CommonStMedia>> P1 = U9().P1();
            Fragment hostFragment2 = getHostFragment();
            final Function1<List<CommonStMedia>, Unit> function12 = new Function1<List<CommonStMedia>, Unit>() { // from class: com.qzone.reborn.groupalbum.reship.part.GroupAlbumReshipPart$onInitView$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<CommonStMedia> list) {
                    invoke2(list);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(List<CommonStMedia> it) {
                    vl.f W9;
                    W9 = GroupAlbumReshipPart.this.W9();
                    MutableLiveData<Boolean> O1 = W9.O1();
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    O1.postValue(Boolean.valueOf(!it.isEmpty()));
                    if (it.isEmpty()) {
                        QQToast.makeText(BaseApplication.getContext(), 4, R.string.to7, 0).show();
                        GroupAlbumReshipPart.this.getActivity().finish();
                    }
                }
            };
            P1.observe(hostFragment2, new Observer() { // from class: com.qzone.reborn.groupalbum.reship.part.d
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    GroupAlbumReshipPart.Y9(Function1.this, obj);
                }
            });
            broadcastMessage("REFRESH_UPLOAD_PAGE_GRID_LIST", Boolean.FALSE);
        }
    }

    @Override // com.qzone.reborn.part.publish.common.uploadAlbum.QZonePublishUploadAlbumPart
    public void L9() {
    }
}
