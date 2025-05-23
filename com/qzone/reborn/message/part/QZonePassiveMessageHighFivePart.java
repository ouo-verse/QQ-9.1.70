package com.qzone.reborn.message.part;

import android.view.View;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\u001eB\u0019\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\f\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u001f\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/qzone/reborn/message/part/QZonePassiveMessageHighFivePart;", "Lcom/qzone/reborn/base/k;", "Ldl/c;", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "", "C9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", com.tencent.luggage.wxa.c8.c.G, "p7", "Ljava/lang/Class;", "Lhl/d;", "d", "Ljava/lang/Class;", "getViewModelClass", "()Ljava/lang/Class;", "viewModelClass", "e", "Lhl/d;", "messageViewModel", "Lxg/e;", "f", "Lxg/e;", "likeClickProcess", "<init>", "(Ljava/lang/Class;)V", tl.h.F, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZonePassiveMessageHighFivePart extends com.qzone.reborn.base.k implements dl.c {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Class<? extends hl.d> viewModelClass;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private hl.d messageViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private xg.e likeClickProcess;

    public /* synthetic */ QZonePassiveMessageHighFivePart(Class cls, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? hl.d.class : cls);
    }

    private final void C9(BusinessFeedData feedData) {
        hl.d dVar = this.messageViewModel;
        if (dVar != null) {
            dVar.f2(feedData, new Function1<BusinessFeedData, Unit>() { // from class: com.qzone.reborn.message.part.QZonePassiveMessageHighFivePart$updateHighFiveInfo$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(BusinessFeedData businessFeedData) {
                    invoke2(businessFeedData);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(BusinessFeedData businessFeedData) {
                    if (businessFeedData != null) {
                        businessFeedData.hasHighFive = true;
                    }
                    if (businessFeedData == null) {
                        return;
                    }
                    businessFeedData.isFakeHighFive = true;
                }
            });
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        registerIoc(this, dl.c.class);
        this.messageViewModel = (hl.d) getViewModel(this.viewModelClass);
    }

    public QZonePassiveMessageHighFivePart(Class<? extends hl.d> viewModelClass) {
        Intrinsics.checkNotNullParameter(viewModelClass, "viewModelClass");
        this.viewModelClass = viewModelClass;
    }

    @Override // dl.c
    public void p7(BusinessFeedData feedData, int pos) {
        if (feedData == null) {
            RFWLog.e("QZonePassiveMessageHighFivePart", RFWLog.USR, "[doHighFive] feedData is null");
            return;
        }
        if (this.likeClickProcess == null) {
            this.likeClickProcess = new xg.e();
        }
        xg.e eVar = this.likeClickProcess;
        if (eVar != null) {
            eVar.c(feedData, true, getActivity());
        }
        C9(feedData);
    }
}
