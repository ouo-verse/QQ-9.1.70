package com.tencent.mobileqq.vas.font.drawable;

import android.graphics.Bitmap;
import com.etrump.mixlayout.e;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public WeakReference<ETDrawable> f309162a;

    /* renamed from: b, reason: collision with root package name */
    public long f309163b;

    /* renamed from: c, reason: collision with root package name */
    public long f309164c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f309165d = -1;

    /* renamed from: e, reason: collision with root package name */
    public e f309166e;

    /* renamed from: f, reason: collision with root package name */
    public Bitmap f309167f;

    public static a a(ETDrawable eTDrawable) {
        if (eTDrawable.getDecoration() == null) {
            return null;
        }
        a aVar = new a();
        aVar.f309162a = new WeakReference<>(eTDrawable);
        aVar.f309163b = eTDrawable.getMsgId();
        aVar.f309166e = eTDrawable.getCom.google.android.exoplayer2.text.ttml.TtmlNode.TAG_LAYOUT java.lang.String();
        aVar.f309165d = eTDrawable.getDecoration().currentFrameIndex();
        aVar.f309167f = eTDrawable.getBitmapLocker().getCom.tencent.mobileqq.activity.photo.MimeHelper.IMAGE_SUBTYPE_BITMAP java.lang.String();
        aVar.f309164c = System.currentTimeMillis();
        return aVar;
    }
}
