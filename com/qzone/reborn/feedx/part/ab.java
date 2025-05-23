package com.qzone.reborn.feedx.part;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import com.qzone.business.tianshu.j;
import com.qzone.business.tianshu.model.QZoneFeedGuideTianshuInfo;
import com.qzone.reborn.feedx.widget.halfscreen.QZoneFeedxBaseFloatingView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001\"B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\u000b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u000e\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u001c\u0010\u0011\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0012\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006#"}, d2 = {"Lcom/qzone/reborn/feedx/part/ab;", "Lcom/qzone/reborn/base/k;", "Lcom/qzone/business/tianshu/j$b;", "", "D9", "", "C9", "", "E9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "Lcom/qzone/business/tianshu/model/QZoneFeedGuideTianshuInfo;", "tianshuInfo", "N1", "onPartPause", "Lcom/qzone/reborn/feedx/viewmodel/q;", "d", "Lcom/qzone/reborn/feedx/viewmodel/q;", "mFeedDataViewModel", "Lsh/a;", "e", "Lsh/a;", "mFloatingViewFactory", "Lsh/d;", "f", "Lsh/d;", "mHalfScreenFloatDialog", "<init>", "()V", tl.h.F, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class ab extends com.qzone.reborn.base.k implements j.b {

    /* renamed from: i, reason: collision with root package name */
    private static boolean f54983i;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.feedx.viewmodel.q mFeedDataViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private sh.a mFloatingViewFactory;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private sh.d mHalfScreenFloatDialog;

    private final boolean C9() {
        sh.a aVar = this.mFloatingViewFactory;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFloatingViewFactory");
            aVar = null;
        }
        return aVar.b() == 1;
    }

    private final String D9() {
        Bundle arguments;
        Intent intent;
        Activity activity = getActivity();
        String stringExtra = (activity == null || (intent = activity.getIntent()) == null) ? null : intent.getStringExtra("refer");
        if (!TextUtils.isEmpty(stringExtra)) {
            return stringExtra;
        }
        Fragment hostFragment = getHostFragment();
        if (hostFragment == null || (arguments = hostFragment.getArguments()) == null) {
            return null;
        }
        return arguments.getString("refer");
    }

    private final void E9() {
        boolean f16 = com.tencent.mobileqq.activity.leba.utils.a.f();
        boolean z16 = f54983i;
        if (!z16 && !f16) {
            com.qzone.business.tianshu.j.INSTANCE.a().l(getActivity(), this);
            return;
        }
        QLog.e("QZoneFeedxHalfScreenFloatingPart", 1, "[initData] isShow:" + z16 + "|" + f16);
    }

    @Override // com.qzone.business.tianshu.j.b
    public void N1(Activity activity, QZoneFeedGuideTianshuInfo tianshuInfo) {
        if (!C9() || activity == null) {
            return;
        }
        QLog.d("QZoneFeedxHalfScreenFloatingPart", 1, "[onInitFinish] tianshuInfo\uff1a" + tianshuInfo);
        f54983i = true;
        sh.a aVar = this.mFloatingViewFactory;
        QZoneFeedxBaseFloatingView qZoneFeedxBaseFloatingView = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFloatingViewFactory");
            aVar = null;
        }
        QZoneFeedxBaseFloatingView a16 = aVar.a();
        if (a16 != null) {
            a16.setData(tianshuInfo);
            qZoneFeedxBaseFloatingView = a16;
        }
        sh.d dVar = new sh.d(activity, qZoneFeedxBaseFloatingView);
        this.mHalfScreenFloatDialog = dVar;
        Intrinsics.checkNotNull(dVar);
        dVar.show();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        ViewModel viewModel = getViewModel(com.qzone.reborn.feedx.viewmodel.q.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneFriend\u2026ataViewModel::class.java)");
        this.mFeedDataViewModel = (com.qzone.reborn.feedx.viewmodel.q) viewModel;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.mFloatingViewFactory = new sh.a(context, D9());
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        if (C9()) {
            f54983i = true;
        }
        sh.d dVar = this.mHalfScreenFloatDialog;
        if (dVar != null) {
            dVar.dismiss();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        if (C9()) {
            E9();
        }
    }
}
