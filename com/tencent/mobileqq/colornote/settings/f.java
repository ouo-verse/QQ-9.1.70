package com.tencent.mobileqq.colornote.settings;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.core.internal.view.SupportMenu;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes5.dex */
public class f {
    private int b(ColorNote colorNote) {
        int k3 = com.tencent.mobileqq.colornote.data.a.k(colorNote.getServiceType()) & SupportMenu.CATEGORY_MASK;
        if (k3 != 16842752) {
            if (k3 != 16908288) {
                if (k3 != 16973824) {
                    if (k3 != 17039360) {
                        if (k3 != 17104896) {
                            if (k3 != 17367040) {
                                return R.drawable.f161608ea0;
                            }
                            return R.drawable.e__;
                        }
                        return R.drawable.htg;
                    }
                    return R.drawable.hml;
                }
                return R.drawable.e__;
            }
            return R.drawable.hmn;
        }
        return R.drawable.hmm;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v1, types: [android.content.res.Resources] */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v2, types: [android.content.res.Resources] */
    /* JADX WARN: Type inference failed for: r9v4, types: [android.content.res.Resources] */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v9, types: [android.graphics.drawable.Drawable] */
    private Drawable c(Context context, ColorNote colorNote) {
        ?? resources = context.getResources();
        int b16 = b(colorNote);
        try {
            URL url = new URL(colorNote.getPicUrl());
            if (ProtocolDownloaderConstants.PROTOCOL_RES_DRAWABLE.equals(url.getProtocol())) {
                try {
                    resources = resources.getDrawable(Integer.parseInt(url.getHost()));
                } catch (Throwable th5) {
                    Drawable drawable = resources.getDrawable(b16);
                    QLog.e("DefaultFormItemBuilder", 1, "service type: " + colorNote.getServiceType() + " url error.", th5);
                    resources = drawable;
                }
            } else {
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                obtain.mRequestWidth = Utils.n(40.0f, resources);
                obtain.mRequestHeight = Utils.n(40.0f, resources);
                Drawable drawable2 = resources.getDrawable(b16);
                obtain.mLoadingDrawable = drawable2;
                obtain.mFailedDrawable = drawable2;
                resources = URLDrawable.getDrawable(url, obtain);
            }
            return resources;
        } catch (NullPointerException e16) {
            Drawable drawable3 = resources.getDrawable(b16);
            QLog.e("DefaultFormItemBuilder", 1, e16, new Object[0]);
            return drawable3;
        } catch (MalformedURLException e17) {
            Drawable drawable4 = resources.getDrawable(b16);
            QLog.e("DefaultFormItemBuilder", 1, e17, new Object[0]);
            return drawable4;
        }
    }

    public HistoryFormItem a(Context context, ColorNote colorNote) {
        HistoryFormItem historyFormItem = new HistoryFormItem(context);
        historyFormItem.setLeftText(colorNote.getMainTitle());
        historyFormItem.setLeftIcon(c(context, colorNote), context.getResources().getDimensionPixelSize(R.dimen.b_6), context.getResources().getDimensionPixelSize(R.dimen.b_5));
        return historyFormItem;
    }
}
