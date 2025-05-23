package com.qzone.reborn.message.part;

import android.view.View;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellLocalInfo;
import com.qzone.reborn.base.n;
import com.qzone.util.ToastUtil;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import common.config.service.QzoneConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0001\u001aB\u0019\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\f\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u001f\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lcom/qzone/reborn/message/part/QZonePassiveMessageJoinAlbumPart;", "Lcom/qzone/reborn/base/k;", "Ldl/d;", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "", "D9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", com.tencent.luggage.wxa.c8.c.G, ICustomDataEditor.STRING_PARAM_7, "Ljava/lang/Class;", "Lhl/d;", "d", "Ljava/lang/Class;", "getViewModelClass", "()Ljava/lang/Class;", "viewModelClass", "e", "Lhl/d;", "mMessageViewModel", "<init>", "(Ljava/lang/Class;)V", "f", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZonePassiveMessageJoinAlbumPart extends com.qzone.reborn.base.k implements dl.d {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Class<? extends hl.d> viewModelClass;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private hl.d mMessageViewModel;

    public /* synthetic */ QZonePassiveMessageJoinAlbumPart(Class cls, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? hl.d.class : cls);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        registerIoc(this, dl.d.class);
        this.mMessageViewModel = (hl.d) getViewModel(this.viewModelClass);
    }

    @Override // dl.d
    public void s7(BusinessFeedData feedData, int pos) {
        if (feedData == null) {
            RFWLog.e("QZonePassiveMessageJoinAlbumPart", RFWLog.USR, "[allowJoinAlbum] feedData is null");
            return;
        }
        CellLocalInfo localInfoV2 = feedData.getLocalInfoV2();
        if ((localInfoV2 == null || localInfoV2.canJoinAlbum) ? false : true) {
            CellLocalInfo localInfoV22 = feedData.getLocalInfoV2();
            if (localInfoV22 != null && localInfoV22.joinedAlbum) {
                RFWLog.e("QZonePassiveMessageJoinAlbumPart", RFWLog.USR, "[allowJoinAlbum] already joined album");
                return;
            }
        }
        hl.d dVar = this.mMessageViewModel;
        if (dVar != null) {
            dVar.T1(feedData, new b(feedData));
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J*\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"com/qzone/reborn/message/part/QZonePassiveMessageJoinAlbumPart$b", "Lcom/qzone/reborn/base/n$a;", "", "t", "", "retCode", "", "msg", "", "isFinish", "", "onSuccess", "errorCode", "errorMsg", "onFailure", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements n.a<Object> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ BusinessFeedData f58293b;

        b(BusinessFeedData businessFeedData) {
            this.f58293b = businessFeedData;
        }

        @Override // com.qzone.reborn.base.n.a
        public void onSuccess(Object t16, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QZonePassiveMessageJoinAlbumPart.this.D9(this.f58293b);
        }

        @Override // com.qzone.reborn.base.n.a
        public void onFailure(long errorCode, String errorMsg) {
            if (errorMsg == null || errorMsg.length() == 0) {
                errorMsg = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastAllowJoinAlbumFail", "\u64cd\u4f5c\u5931\u8d25");
            }
            ToastUtil.s(errorMsg, 4);
        }
    }

    public QZonePassiveMessageJoinAlbumPart(Class<? extends hl.d> viewModelClass) {
        Intrinsics.checkNotNullParameter(viewModelClass, "viewModelClass");
        this.viewModelClass = viewModelClass;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D9(BusinessFeedData feedData) {
        if (feedData == null) {
            RFWLog.e("QZonePassiveMessageJoinAlbumPart", RFWLog.USR, "[updateAllowInfo] feedData is null");
            return;
        }
        hl.d dVar = this.mMessageViewModel;
        if (dVar != null) {
            dVar.f2(feedData, new Function1<BusinessFeedData, Unit>() { // from class: com.qzone.reborn.message.part.QZonePassiveMessageJoinAlbumPart$updateAllowInfo$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(BusinessFeedData businessFeedData) {
                    invoke2(businessFeedData);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(BusinessFeedData businessFeedData) {
                    CellLocalInfo localInfoV2 = businessFeedData != null ? businessFeedData.getLocalInfoV2() : null;
                    if (localInfoV2 != null) {
                        localInfoV2.canJoinAlbum = false;
                    }
                    CellLocalInfo localInfoV22 = businessFeedData != null ? businessFeedData.getLocalInfoV2() : null;
                    if (localInfoV22 == null) {
                        return;
                    }
                    localInfoV22.joinedAlbum = true;
                }
            });
        }
        ToastUtil.s(com.qzone.util.l.a(R.string.w_q), 5);
    }
}
