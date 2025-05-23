package com.tencent.kuikly.core.render.android.expand.component.text;

import android.graphics.Paint;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;
import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B-\u0012\b\u0010\f\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u0013\u001a\u00020\t\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0014\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0016R\u0016\u0010\f\u001a\u0004\u0018\u00010\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\"\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/text/g;", "Landroid/text/style/CharacterStyle;", "Landroid/text/style/UpdateAppearance;", "Landroid/text/TextPaint;", "paint", "", "a", "ds", "updateDrawState", "", "d", "Ljava/lang/Float;", "stokeWidth", "", "e", "Ljava/lang/Integer;", "stokeColor", "f", UserInfo.SEX_FEMALE, "fontWeight", "", tl.h.F, "Z", "getInTextStrokeDraw", "()Z", "b", "(Z)V", "inTextStrokeDraw", "<init>", "(Ljava/lang/Float;Ljava/lang/Integer;FZ)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class g extends CharacterStyle implements UpdateAppearance {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Float stokeWidth;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Integer stokeColor;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final float fontWeight;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean inTextStrokeDraw;

    public /* synthetic */ g(Float f16, Integer num, float f17, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(f16, num, f17, (i3 & 8) != 0 ? false : z16);
    }

    private final void a(TextPaint paint) {
        float f16;
        int i3;
        paint.setStyle(Paint.Style.STROKE);
        float f17 = this.fontWeight;
        Float f18 = this.stokeWidth;
        if (f18 != null) {
            f16 = f18.floatValue();
        } else {
            f16 = 0.0f;
        }
        paint.setStrokeWidth(f17 + f16);
        Integer num = this.stokeColor;
        if (num != null) {
            i3 = num.intValue();
        } else {
            i3 = 0;
        }
        paint.setColor(i3);
    }

    public final void b(boolean z16) {
        this.inTextStrokeDraw = z16;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(@Nullable TextPaint ds5) {
        if (this.inTextStrokeDraw && ds5 != null) {
            a(ds5);
        }
    }

    public g(@Nullable Float f16, @Nullable Integer num, float f17, boolean z16) {
        this.stokeWidth = f16;
        this.stokeColor = num;
        this.fontWeight = f17;
        this.inTextStrokeDraw = z16;
    }
}
