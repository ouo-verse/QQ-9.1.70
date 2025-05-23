package com.qzone.business.lbsv2.business;

import android.os.Handler;
import com.qzone.proxy.personalitycomponent.model.WidgetWeatherData;
import cooperation.qzone.model.GpsInfo4LocalImage;
import cooperation.qzone.model.LocalImageShootInfo;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public interface d {
    void A(Handler handler, int i3, ArrayList<GpsInfo4LocalImage> arrayList, int i16);

    void B(Handler handler, String str, String str2, boolean z16, int i3, LocalImageShootInfo localImageShootInfo);

    void a(Handler handler, String str, String str2, int i3);

    void b(Handler handler, int i3);

    void f(Handler handler, int i3, ArrayList<GpsInfo4LocalImage> arrayList, int i16, String str);

    void i(Handler handler, String str, int i3);

    void k(Handler handler, int i3, ArrayList<GpsInfo4LocalImage> arrayList, int i16);

    void m(Handler handler, String str, int i3, int i16, boolean z16, LocalImageShootInfo localImageShootInfo, ArrayList<String> arrayList);

    void n(Handler handler, int i3, LocalImageShootInfo localImageShootInfo, int i16, int i17);

    WidgetWeatherData q(boolean z16);

    void y(Handler handler, String str, int i3, int i16, boolean z16, ArrayList<String> arrayList);
}
