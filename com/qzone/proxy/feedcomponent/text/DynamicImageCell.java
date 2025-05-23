package com.qzone.proxy.feedcomponent.text;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import ch.j;
import com.qzone.util.ar;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.FastDynamicDrawable;
import cooperation.qzone.mobilereport.MobileReportManager;
import cooperation.qzone.report.lp.LpReportInfo_dc04586;
import x8.d;

/* compiled from: P */
/* loaded from: classes39.dex */
public class DynamicImageCell extends UserNameCell {
    private Rect curRect;
    private Drawable drawable;
    private String from;
    private String itemId;
    private String jumpUrl;
    private boolean needColon;

    public DynamicImageCell(final View view, int i3, String str, String str2, d.a aVar) {
        super(i3, str, str2);
        this.jumpUrl = aVar.f447401d;
        this.needColon = aVar.f447402e.booleanValue();
        this.from = aVar.f447399b;
        this.itemId = String.valueOf(aVar.f447398a);
        ch.j.f(aVar, new j.b() { // from class: com.qzone.proxy.feedcomponent.text.b
            @Override // ch.j.b
            public final void onResult(String str3) {
                DynamicImageCell.this.d(view, str3);
            }
        });
        MobileReportManager.getInstance().reportAction(this.itemId, "4", LpReportInfo_dc04586.APPID, this.from, "", 101, 0, System.currentTimeMillis());
    }

    private int c() {
        return this.needColon ? 20 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(View view, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        FastDynamicDrawable a16 = com.tencent.cachedrawable.dynamicdrawable.api.a.a().d(str).a();
        this.drawable = a16;
        a16.setCallback(view);
        view.requestLayout();
        view.invalidate();
    }

    @Override // com.qzone.proxy.feedcomponent.text.UserNameCell, com.qzone.proxy.feedcomponent.text.ColorTextCell, com.qzone.proxy.feedcomponent.text.TextCell
    public void draw(Canvas canvas, Paint paint, int i3, Rect rect, int i16, int i17, Bitmap bitmap) {
        super.draw(canvas, paint, i3, rect, i16, i17, bitmap);
        this.curRect = rect;
        Drawable drawable = this.drawable;
        if (drawable != null) {
            drawable.setBounds((rect.right - getDrawableWidth()) + ar.e(3.0f), rect.top, (rect.right - c()) - ar.d(2.0f), rect.bottom);
            this.drawable.draw(canvas);
        }
        if (this.needColon) {
            Rect rect2 = new Rect();
            rect2.left = rect.right - c();
            int i18 = rect.top;
            rect2.top = i18;
            rect2.right = rect.right;
            rect2.bottom = rect.bottom;
            if (paint instanceof d) {
                etPaintDrawText(":", i3, rect2, canvas, bitmap, paint);
            } else {
                canvasDrawText(canvas, ":", rect2, i18 + ((int) (((i3 - getDescent(paint)) - getAscent(paint)) / 2.0f)), paint);
            }
        }
    }

    public boolean isClickVipIcon(float f16, float f17) {
        Rect rect = this.curRect;
        if (rect == null) {
            return false;
        }
        int i3 = rect.right;
        return ((float) i3) > f16 && ((float) (i3 - getDrawableWidth())) < f16;
    }

    public int getDrawableWidth() {
        return ar.e(30.0f) + ar.e(5.0f) + c();
    }

    public void jumpH5Url(Context context) {
        if (context == null) {
            return;
        }
        MobileReportManager.getInstance().reportAction(this.itemId, "4", LpReportInfo_dc04586.APPID, this.from, "", 102, 0, System.currentTimeMillis());
        ch.j.h(context, this.jumpUrl);
    }
}
