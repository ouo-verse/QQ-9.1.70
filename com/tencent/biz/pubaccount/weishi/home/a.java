package com.tencent.biz.pubaccount.weishi.home;

import UserGrowth.stPublisherRsp;
import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.List;
import kotlin.Metadata;
import tl.h;
import vy.WSNavigationBarInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\tH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000eH&J\b\u0010\u0012\u001a\u00020\u0011H&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0011H&J\u001a\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H&\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/home/a;", "Lcom/tencent/biz/pubaccount/weishi/d;", "Lcom/tencent/biz/pubaccount/weishi/home/b;", "", "g", "doOnDestroy", "Landroid/os/Bundle;", "bundle", "o", "", "Lcom/tencent/mobileqq/app/QBaseFragment;", h.F, "Lvy/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "position", "onPageSelected", "", "e", "barId", "b0", "Landroid/content/Context;", "context", "LUserGrowth/stPublisherRsp;", "resp", "v0", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public interface a extends com.tencent.biz.pubaccount.weishi.d<b> {
    void b0(String barId);

    void doOnDestroy();

    String e();

    void g();

    List<QBaseFragment> h();

    void o(Bundle bundle);

    void onPageSelected(int position);

    List<WSNavigationBarInfo> q();

    void v0(Context context, stPublisherRsp resp);
}
