package com.tencent.mm.ui.widget.menu;

import android.app.Activity;
import android.content.Context;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.luggage.wxa.lo.o;
import com.tencent.luggage.wxa.mo.g;
import com.tencent.mobileqq.R;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public class SubMenuLogic {

    /* renamed from: a, reason: collision with root package name */
    public static DisplayMetrics f153485a;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class SubmnuLocation {
        public int animationStyle;
        public int marginLeft;
        public int marginRight;
        public int marginTop;

        public String toString() {
            return " marginLeft:" + this.marginLeft + " marginRight:" + this.marginRight;
        }
    }

    public static SubmnuLocation calculateIndicatorLocation(Context context, View view, int i3) {
        SubmnuLocation submnuLocation = new SubmnuLocation();
        DisplayMetrics displayMetrics = getDisplayMetrics(context);
        submnuLocation.marginLeft = i3 - 10;
        submnuLocation.marginRight = displayMetrics.widthPixels - (i3 + 10);
        return submnuLocation;
    }

    public static SubmnuLocation calculateLocation(Context context, TextPaint textPaint, List<String> list, g gVar, int i3) {
        SubmnuLocation submnuLocation = new SubmnuLocation();
        DisplayMetrics displayMetrics = getDisplayMetrics(context);
        int maxWidth = getMaxWidth(context, textPaint, list);
        int a16 = o.a(context, 95);
        if (maxWidth < a16) {
            maxWidth = a16;
        }
        int i16 = maxWidth / 2;
        int i17 = i3 - i16;
        if (i17 < 0) {
            submnuLocation.marginLeft = 0;
            submnuLocation.marginRight = displayMetrics.widthPixels - (maxWidth + 0);
        } else {
            int i18 = displayMetrics.widthPixels;
            int i19 = i18 - (i3 + i16);
            if (i19 < 0) {
                submnuLocation.marginLeft = i18 - (maxWidth + 0);
                submnuLocation.marginRight = 0;
            } else {
                submnuLocation.marginLeft = i17;
                submnuLocation.marginRight = i19;
            }
        }
        return submnuLocation;
    }

    public static DisplayMetrics getDisplayMetrics(Context context) {
        if (f153485a == null) {
            f153485a = context.getResources().getDisplayMetrics();
        }
        return f153485a;
    }

    public static int getMaxWidth(Context context, TextPaint textPaint, List<String> list) {
        Iterator<String> it = list.iterator();
        float f16 = 0.0f;
        while (it.hasNext()) {
            float measureText = textPaint.measureText(it.next());
            if (f16 < measureText) {
                f16 = measureText;
            }
        }
        return ((int) f16) + (o.a(context, 30) * 2);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static SubmnuLocation calculateLocation(Context context, int i3, int i16, int i17, int i18, int i19, boolean z16) {
        boolean z17;
        boolean z18;
        SubmnuLocation submnuLocation = new SubmnuLocation();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (context instanceof Activity) {
            ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        } else {
            displayMetrics = getDisplayMetrics(context);
        }
        int a16 = o.a(context, 95);
        if (i3 < a16) {
            i3 = a16;
        }
        boolean z19 = false;
        boolean z26 = true;
        if (i16 < 0) {
            submnuLocation.marginLeft = 0;
            submnuLocation.marginRight = displayMetrics.widthPixels - ((i19 * 2) + i3);
        } else {
            int i26 = displayMetrics.widthPixels;
            int i27 = i16 + i3;
            if (i26 - ((i19 * 2) + i27) < 0) {
                submnuLocation.marginLeft = (i16 - i3) - i19;
                submnuLocation.marginRight = (i26 - i16) - i19;
                z17 = false;
                z18 = true;
                if (i17 >= 0 || i17 > displayMetrics.heightPixels) {
                    i17 = (int) (displayMetrics.heightPixels / 2.0f);
                }
                if (z16) {
                    if (displayMetrics.heightPixels - i17 < (i19 * 3) + i18) {
                        submnuLocation.marginTop = (i17 - i19) - i18;
                        z26 = false;
                        z19 = true;
                    } else {
                        submnuLocation.marginTop = i17 - i19;
                    }
                } else if (i17 < i18 + i19) {
                    submnuLocation.marginTop = i17 - i19;
                } else {
                    submnuLocation.marginTop = (i17 - i19) - i18;
                    z26 = false;
                    z19 = true;
                }
                if (!z19) {
                    submnuLocation.marginTop -= i19 * 2;
                } else if (z26) {
                    submnuLocation.marginTop += i19 * 2;
                }
                if (!z17 && z26) {
                    submnuLocation.animationStyle = R.style.a4k;
                } else if (!z18 && z26) {
                    submnuLocation.animationStyle = R.style.a4m;
                } else if (!z17 && z19) {
                    submnuLocation.animationStyle = R.style.a4j;
                } else if (!z18 && z19) {
                    submnuLocation.animationStyle = R.style.a4l;
                } else {
                    submnuLocation.animationStyle = R.style.a4k;
                }
                return submnuLocation;
            }
            submnuLocation.marginLeft = i16;
            submnuLocation.marginRight = i26 - i27;
        }
        z18 = false;
        z17 = true;
        if (i17 >= 0) {
        }
        i17 = (int) (displayMetrics.heightPixels / 2.0f);
        if (z16) {
        }
        if (!z19) {
        }
        if (!z17) {
        }
        if (!z18) {
        }
        if (!z17) {
        }
        if (!z18) {
        }
        submnuLocation.animationStyle = R.style.a4k;
        return submnuLocation;
    }
}
