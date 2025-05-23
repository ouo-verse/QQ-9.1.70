package com.tencent.mobileqq.activity.aio.intimate;

import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class c extends com.tencent.relation.common.widget.banner.adapter.e<f61.a> {
    public c(List<f61.a> list) {
        super(list);
    }

    @Override // com.tencent.relation.common.widget.banner.adapter.d
    /* renamed from: u0, reason: merged with bridge method [inline-methods] */
    public void p0(com.tencent.relation.common.widget.banner.holder.a aVar, f61.a aVar2, int i3, int i16) {
        URLDrawable drawable;
        super.p0(aVar, aVar2, i3, i16);
        String str = aVar2.f397889a;
        QLog.d("IntimateBannerAdapter", 1, "headerUrl\uff1a" + str);
        if (TextUtils.isEmpty(str) || (drawable = URLDrawable.getDrawable(str, URLDrawable.URLDrawableOptions.obtain())) == null) {
            return;
        }
        if (drawable.getStatus() == 2) {
            QLog.d("IntimateBannerAdapter", 1, "IntimateBannerAdapter restartDownload");
            drawable.restartDownload();
        } else {
            QLog.d("IntimateBannerAdapter", 1, "IntimateBannerAdapter success");
            aVar.E.setImageDrawable(drawable);
        }
    }
}
