package gf;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Message;
import com.qzone.component.banner.Banner;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH&J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\r\u001a\u00020\nH&J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0004H&J\b\u0010\u0010\u001a\u00020\nH&J\b\u0010\u0011\u001a\u00020\nH&J\b\u0010\u0012\u001a\u00020\nH&J\b\u0010\u0013\u001a\u00020\nH&J\u0018\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002H&J \u0010\u001b\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019H&J\u0010\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001cH&J\b\u0010\u001f\u001a\u00020\nH&J\u0010\u0010\"\u001a\u00020\n2\u0006\u0010!\u001a\u00020 H&J\u0010\u0010$\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u0002H&\u00a8\u0006%"}, d2 = {"Lgf/g;", "", "", WadlProxyConsts.BANNER_TYPE, "", "e", "Lcom/qzone/component/banner/Banner;", "k", "Lcom/qzone/feed/business/model/a;", "bannerStruct", "", "b", "i", "a", "adsBannerNeedToExposure", "l", tl.h.F, "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "c", "firstVisiblePosition", "newState", "onScrollStateChanged", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Landroid/os/Message;", "msg", "j", "g", "Landroid/content/res/Configuration;", "configuration", "d", com.tencent.luggage.wxa.c8.c.f123400v, "f", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public interface g {
    void a();

    void b(com.qzone.feed.business.model.a bannerStruct);

    void c();

    void d(Configuration configuration);

    boolean e(int bannerType);

    void f(int alpha);

    void g();

    void h();

    void i(int bannerType);

    void j(Message msg2);

    Banner k(int bannerType);

    void l(boolean adsBannerNeedToExposure);

    void onActivityResult(int requestCode, int resultCode, Intent data);

    void onPause();

    void onResume();

    void onScrollStateChanged(int firstVisiblePosition, int newState);
}
