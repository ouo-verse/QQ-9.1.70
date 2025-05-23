package com.qzone.proxy.vipcomponent;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import cooperation.vip.vipcomponent.util.VipResourcesListener;

/* compiled from: P */
/* loaded from: classes39.dex */
public interface IVipComponentUI {
    Drawable getComVipIcon(int i3, int i16, boolean z16, boolean z17, boolean z18, String str, int i17, String str2, VipResourcesListener vipResourcesListener);

    Drawable getStarVipIcon(int i3, int i16, boolean z16, boolean z17, int i17, int i18, VipResourcesListener vipResourcesListener);

    Drawable getStarVipIcon(int i3, int i16, boolean z16, boolean z17, int i17, VipResourcesListener vipResourcesListener);

    Class<?> getYellowOpenVipActivityClass();

    Drawable getYellowVipIcon(int i3, int i16, boolean z16, boolean z17, String str, int i17, int i18, String str2, VipResourcesListener vipResourcesListener);

    Drawable getYellowVipIcon(int i3, int i16, boolean z16, boolean z17, String str, int i17, int i18, String str2, VipResourcesListener vipResourcesListener, int i19);

    Drawable getYellowVipIcon(int i3, int i16, boolean z16, boolean z17, String str, int i17, VipResourcesListener vipResourcesListener);

    void goOpenStarVip(Context context, Intent intent);

    void goOpenYellowVip(Context context, Intent intent, int i3);
}
