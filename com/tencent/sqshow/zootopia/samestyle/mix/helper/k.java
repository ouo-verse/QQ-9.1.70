package com.tencent.sqshow.zootopia.samestyle.mix.helper;

import android.widget.FrameLayout;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.zplan.share.ZPlanShareLaunchParam;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0005\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0016R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\f\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/sqshow/zootopia/samestyle/mix/helper/k;", "Lcom/tencent/sqshow/zootopia/samestyle/mix/helper/d;", "", "o", DomainData.DOMAIN_NAME, "Lsb4/a;", "D", "Lsb4/a;", "previewPage", "Lcom/tencent/image/URLImageView;", "E", "Lcom/tencent/image/URLImageView;", "mPreviewImageView", "<init>", "(Lsb4/a;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class k extends d {

    /* renamed from: D, reason: from kotlin metadata */
    private final sb4.a previewPage;

    /* renamed from: E, reason: from kotlin metadata */
    private URLImageView mPreviewImageView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(sb4.a previewPage) {
        super(previewPage.getF372926a(), previewPage.getF372927b(), previewPage.getF372928c(), previewPage.getF372929d(), previewPage.b(), previewPage.getLifecycleOwner(), previewPage.getSource());
        Intrinsics.checkNotNullParameter(previewPage, "previewPage");
        this.previewPage = previewPage;
    }

    private final void o() {
        getMBinding().f419268w.setVisibility(8);
        URLImageView uRLImageView = new URLImageView(getMContext());
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mPlayGifImage = true;
        uRLImageView.setImageDrawable(URLDrawable.getDrawable(getMTemplate().getPreviewUrl(), obtain));
        uRLImageView.setAdjustViewBounds(true);
        this.mPreviewImageView = uRLImageView;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 81;
        getMBinding().f419260o.addView(uRLImageView, layoutParams);
        id3.d mReporter = getMReporter();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(ZPlanShareLaunchParam.KEY_BIZ_SAMESTYLE_ID, Integer.valueOf(getMTemplate().getId()));
        Unit unit = Unit.INSTANCE;
        id3.d.h(mReporter, uRLImageView, "em_zplan_samestyle_preview_content", linkedHashMap, false, false, null, 56, null);
    }

    public void n() {
        o();
    }
}
