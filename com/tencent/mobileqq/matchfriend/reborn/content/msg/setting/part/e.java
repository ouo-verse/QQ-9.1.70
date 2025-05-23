package com.tencent.mobileqq.matchfriend.reborn.content.msg.setting.part;

import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/setting/part/e;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "d", "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "secNavBar", "<init>", "(Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class e extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final QUISecNavBar secNavBar;

    public e(QUISecNavBar secNavBar) {
        Intrinsics.checkNotNullParameter(secNavBar, "secNavBar");
        this.secNavBar = secNavBar;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        QUISecNavBar qUISecNavBar = this.secNavBar;
        qUISecNavBar.setAutoAdaptTransparent(false);
        qUISecNavBar.setTitleAlpha(0.0f);
        qUISecNavBar.setLeftType(2);
        qUISecNavBar.setCenterType(1);
        qUISecNavBar.setCenterText(qUISecNavBar.getResources().getString(R.string.x3_));
        qUISecNavBar.setRightType(0);
    }
}
