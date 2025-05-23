package com.qzone.reborn.widget;

import android.widget.ImageView;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mobileqq.widget.listitem.x.b;
import com.tencent.mobileqq.widget.listitem.x.c;
import com.tencent.qphone.base.util.QLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes37.dex */
public class m<LC extends x.b, RC extends x.c> extends x {
    public m(x.b bVar, x.c cVar) {
        super(bVar, cVar);
        R(new Function2() { // from class: com.qzone.reborn.widget.k
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit X;
                X = m.X((ImageView) obj, (String) obj2);
                return X;
            }
        });
        T(new Function2() { // from class: com.qzone.reborn.widget.l
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit Y;
                Y = m.this.Y((ImageView) obj, (String) obj2);
                return Y;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit X(ImageView imageView, String str) {
        try {
            imageView.setImageDrawable(com.qzone.reborn.feedx.util.e.e(imageView, Long.parseLong(str), new QZoneUserAvatarView.b()));
        } catch (Exception e16) {
            QLog.e("QZoneSingleLineConfig", 1, "load avatar parse uin fail" + e16);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit Y(ImageView imageView, String str) {
        Z(imageView, str);
        return Unit.INSTANCE;
    }

    private void Z(ImageView imageView, String str) {
        com.tencent.mobileqq.qzone.picload.c.a().h(Option.obtain().setUrl(mk.c.f416874a.b(str)).setTargetView(imageView).setFailedDrawableId(R.drawable.trans).setLoadingDrawableId(R.drawable.trans));
    }
}
