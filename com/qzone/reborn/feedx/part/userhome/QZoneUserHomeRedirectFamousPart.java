package com.qzone.reborn.feedx.part.userhome;

import android.app.Activity;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.EventSource;
import com.qzone.common.event.IObserver;
import com.qzone.reborn.route.QZoneUserHomeBean;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b \u0010!J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0016J\u0012\u0010\u000e\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0012\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016R\u0016\u0010\u0016\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0015\u00a8\u0006\""}, d2 = {"Lcom/qzone/reborn/feedx/part/userhome/QZoneUserHomeRedirectFamousPart;", "Lcom/qzone/reborn/feedx/part/g;", "Lcom/qzone/common/event/IObserver$main;", "Lx6/a;", ITVKPlayerEventListener.KEY_USER_INFO, "", "I9", "", "J9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "", "getLogTag", "Lcom/qzone/common/event/Event;", "event", "onEventUIThread", "d", "Z", "mHasRedirect", "e", "Lx6/a;", "mUserInfo", "Lcom/qzone/reborn/feedx/viewmodel/w;", "f", "Lcom/qzone/reborn/feedx/viewmodel/w;", "mUserHomeViewModel", tl.h.F, "mHasCheckRedirect", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class QZoneUserHomeRedirectFamousPart extends com.qzone.reborn.feedx.part.g implements IObserver.main {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean mHasRedirect;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private x6.a mUserInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.feedx.viewmodel.w mUserHomeViewModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mHasCheckRedirect;

    private final boolean J9(x6.a userInfo) {
        return vo.d.b().d(userInfo.uin) || userInfo.isFamousUser();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneUserHomeRedirectFamousPart";
    }

    @Override // com.qzone.reborn.feedx.part.g, com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        ViewModel viewModel = getViewModel(com.qzone.reborn.feedx.viewmodel.w.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneUserHomeViewModel::class.java)");
        com.qzone.reborn.feedx.viewmodel.w wVar = (com.qzone.reborn.feedx.viewmodel.w) viewModel;
        this.mUserHomeViewModel = wVar;
        if (wVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
            wVar = null;
        }
        MutableLiveData<x6.a> C2 = wVar.C2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<x6.a, Unit> function1 = new Function1<x6.a, Unit>() { // from class: com.qzone.reborn.feedx.part.userhome.QZoneUserHomeRedirectFamousPart$onInitView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(x6.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(x6.a aVar) {
                boolean z16;
                QZoneUserHomeRedirectFamousPart.this.mUserInfo = aVar;
                z16 = QZoneUserHomeRedirectFamousPart.this.mHasCheckRedirect;
                if (z16) {
                    return;
                }
                QZoneUserHomeRedirectFamousPart.this.I9(aVar);
                QZoneUserHomeRedirectFamousPart.this.mHasCheckRedirect = true;
            }
        };
        C2.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.feedx.part.userhome.q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneUserHomeRedirectFamousPart.K9(Function1.this, obj);
            }
        });
        EventCenter.getInstance().addUIObserver(this, "Feed", 29);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        EventCenter.getInstance().removeObserver(this);
    }

    @Override // com.qzone.common.event.IObserver.main
    public void onEventUIThread(Event event) {
        EventSource eventSource;
        if (!Intrinsics.areEqual("Feed", (event == null || (eventSource = event.source) == null) ? null : eventSource.getName()) || event.what != 29 || this.mUserInfo == null || getActivity() == null || getActivity().isFinishing()) {
            return;
        }
        x6.a aVar = this.mUserInfo;
        Intrinsics.checkNotNull(aVar);
        I9(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I9(x6.a userInfo) {
        if (this.mHasRedirect || userInfo == null || !J9(userInfo) || userInfo.isLimitRelationship()) {
            return;
        }
        QZoneUserHomeBean qZoneUserHomeBean = new QZoneUserHomeBean(0L, null, null, null, false, null, null, 0, null, false, false, 0, 4095, null);
        qZoneUserHomeBean.setUin(userInfo.uin);
        qZoneUserHomeBean.setShowFacade(false);
        ho.i.z().g(getActivity(), qZoneUserHomeBean);
        this.mHasRedirect = true;
        getActivity().finish();
    }
}
