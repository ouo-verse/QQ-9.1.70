package mh2;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qqgamepub.data.GmpEnterInfoRsp;
import com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameWebPresenter;
import eipc.EIPCResult;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes16.dex */
public interface c extends lh2.a<QQGameWebPresenter> {
    void R0(int i3);

    int Rd();

    void W9(int i3);

    int Wc();

    void Y5(Map<String, Object> map);

    void f7(String str);

    QBaseActivity getBaseActivity();

    void me();

    void n3();

    void o(boolean z16, int i3);

    void o5(EIPCResult eIPCResult);

    void q(GmpEnterInfoRsp gmpEnterInfoRsp, boolean z16);

    void refreshHead(int i3);

    void z2();
}
