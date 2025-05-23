package mh2;

import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.qqgamepub.data.GmpEnterInfoRsp;
import com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameHippyBasePresenter;

/* compiled from: P */
/* loaded from: classes16.dex */
public interface b<P extends QQGameHippyBasePresenter> extends a<P> {
    void N5(int i3);

    void R0(int i3);

    ViewPager n0();

    void o(boolean z16, int i3);

    void q(GmpEnterInfoRsp gmpEnterInfoRsp, boolean z16);

    void refreshHead(int i3);
}
