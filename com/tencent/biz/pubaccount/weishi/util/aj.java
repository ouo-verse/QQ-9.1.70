package com.tencent.biz.pubaccount.weishi.util;

import android.app.Activity;
import android.graphics.Color;
import android.view.Window;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/util/aj;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "color", "", "a", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class aj {

    /* renamed from: a, reason: collision with root package name */
    public static final aj f81702a = new aj();

    aj() {
    }

    @JvmStatic
    public static final void a(Activity activity, int color) {
        Window window;
        if (activity == null || (window = activity.getWindow()) == null) {
            return;
        }
        if (color == -16777216) {
            color = Color.rgb(1, 1, 1);
        }
        com.tencent.mobileqq.theme.a.e(window, color);
    }
}
