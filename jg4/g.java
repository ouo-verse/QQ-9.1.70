package jg4;

import android.view.View;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataBase;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataEnter;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataInit;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPrepare;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPullInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPushInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataThirdPushCheck;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface g {
    void a();

    void b();

    void c(int i3, int i16, String str);

    void d(boolean z16, QQLiveAnchorDataPushInfo qQLiveAnchorDataPushInfo, String str, String str2);

    void e(boolean z16, QQLiveAnchorDataEnter qQLiveAnchorDataEnter);

    void f();

    void g(boolean z16, QQLiveAnchorDataPrepare qQLiveAnchorDataPrepare);

    void h();

    void i(boolean z16, QQLiveAnchorDataBase qQLiveAnchorDataBase, View view);

    void j(boolean z16, QQLiveAnchorDataInit qQLiveAnchorDataInit);

    void k(boolean z16);

    void l(int i3, String str);

    void onGetPullInfo(QQLiveAnchorDataPullInfo qQLiveAnchorDataPullInfo);

    void onThirdPushChecked(QQLiveAnchorDataThirdPushCheck qQLiveAnchorDataThirdPushCheck);
}
