package gf;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Parcelable;
import com.qzone.detail.business.service.QZoneDetailService;
import com.qzone.feed.utils.e;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.tencent.biz.ui.TouchWebView;
import java.io.Serializable;
import java.util.Map;
import n5.d;

/* compiled from: P */
/* loaded from: classes38.dex */
public interface f {
    boolean I1();

    String S6();

    QZoneDetailService T0();

    void U3();

    QZoneDetailService X3();

    d.g Z4();

    void a7();

    Activity getActivity();

    int getAppid();

    String getFeedId();

    Handler getHandler();

    int getRefer();

    Resources getResources();

    String getString(int i3);

    long getUin();

    TouchWebView getWebView();

    boolean isFavorite();

    boolean j6();

    void m1();

    void m7(int i3);

    void n1(BusinessFeedData businessFeedData);

    void w9(int i3);

    void x0(e.a aVar, Serializable serializable, Parcelable parcelable, Map<String, Object> map);
}
