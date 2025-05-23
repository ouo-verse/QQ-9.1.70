package com.qzone.common.activities.base;

import android.view.View;
import android.widget.FrameLayout;
import com.qzone.proxy.covercomponent.ui.IQZoneCoverContainer;
import com.qzone.widget.FillLinearLayout;
import com.qzone.widget.FrameLayoutForListViewItem;
import com.tencent.luan.ioc.annotation.Inject;
import com.tencent.luan.ioc.annotation.Named;
import com.tencent.mobileqq.utils.ViewUtils;

/* compiled from: P */
@Named("BaseFeedFragmentCoverImp")
/* loaded from: classes39.dex */
public class n implements d5.e<IQZoneCoverContainer> {

    /* renamed from: a, reason: collision with root package name */
    private IQZoneCoverContainer f45527a = null;

    @Inject
    public n() {
    }

    @Override // d5.e
    public int a() {
        return 0;
    }

    @Override // d5.e
    public FrameLayout getAttachView() {
        IQZoneCoverContainer iQZoneCoverContainer = this.f45527a;
        if (iQZoneCoverContainer == null) {
            return null;
        }
        return iQZoneCoverContainer.getAttachView();
    }

    @Override // d5.e
    public void onDestroy() {
        IQZoneCoverContainer iQZoneCoverContainer = this.f45527a;
        if (iQZoneCoverContainer != null) {
            iQZoneCoverContainer.onDestory();
            this.f45527a = null;
        }
    }

    @Override // d5.e
    public void b(View view) {
        IQZoneCoverContainer iQZoneCoverContainer;
        if (view == null || (iQZoneCoverContainer = this.f45527a) == null || iQZoneCoverContainer.getCoverType() != 18) {
            return;
        }
        if (!(view instanceof FrameLayoutForListViewItem) && !(view instanceof FillLinearLayout)) {
            this.f45527a.onPause();
            return;
        }
        if (view.getTop() <= (-ViewUtils.getScreenWidth())) {
            this.f45527a.onPause();
            return;
        }
        this.f45527a.onResume();
        int coverType = this.f45527a.getCoverType();
        if (coverType == 9 || coverType == 15 || coverType == 19 || coverType == 16 || coverType == 18 || coverType == 10) {
            wo.a.a(coverType);
        }
    }
}
