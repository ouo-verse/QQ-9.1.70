package com.tencent.mobileqq.qqecommerce.biz.qq;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableWrapper;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/qq/e;", "Landroid/graphics/drawable/DrawableWrapper;", "", "d", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "uin", "", "e", "I", "a", "()I", "type", "Lcom/tencent/mobileqq/app/face/IFaceDecoder;", "f", "Lcom/tencent/mobileqq/app/face/IFaceDecoder;", "faceDecoder", "Landroid/graphics/drawable/Drawable;", "drawable", "<init>", "(Landroid/graphics/drawable/Drawable;Ljava/lang/String;ILcom/tencent/mobileqq/app/face/IFaceDecoder;)V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
final class e extends DrawableWrapper {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String uin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int type;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final IFaceDecoder faceDecoder;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Drawable drawable, String uin, int i3, IFaceDecoder faceDecoder) {
        super(drawable);
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(faceDecoder, "faceDecoder");
        this.uin = uin;
        this.type = i3;
        this.faceDecoder = faceDecoder;
    }

    /* renamed from: a, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* renamed from: b, reason: from getter */
    public final String getUin() {
        return this.uin;
    }
}
