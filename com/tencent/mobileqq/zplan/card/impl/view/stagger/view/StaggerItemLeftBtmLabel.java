package com.tencent.mobileqq.zplan.card.impl.view.stagger.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.sqshow.zootopia.utils.i;
import com.tencent.sqshow.zootopia.utils.q;
import com.tencent.xweb.FileReaderHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l84.b;
import pu4.g;
import pv4.u;
import zf3.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001c\u0010\u0014\u001a\n \u0011*\u0004\u0018\u00010\u00100\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/stagger/view/StaggerItemLeftBtmLabel;", "Landroid/widget/LinearLayout;", "Lpu4/g;", "icon", "Lpv4/u;", FileReaderHelper.TXT_EXT, "", "a", "Lcom/tencent/image/URLImageView;", "d", "Lcom/tencent/image/URLImageView;", "mIcon", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "mTxt", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "f", "Landroid/graphics/drawable/Drawable;", "mDefaultDrawable", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class StaggerItemLeftBtmLabel extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final URLImageView mIcon;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final TextView mTxt;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Drawable mDefaultDrawable;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StaggerItemLeftBtmLabel(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        URLImageView uRLImageView = new URLImageView(context);
        this.mIcon = uRLImageView;
        TextView textView = new TextView(context);
        this.mTxt = textView;
        this.mDefaultDrawable = q.b(R.drawable.gym);
        setOrientation(0);
        d dVar = d.f452428a;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dVar.d(), dVar.c());
        layoutParams.gravity = 16;
        addView(uRLImageView, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.leftMargin = i.a(4.5f);
        textView.setTextSize(1, 12.0f);
        addView(textView, layoutParams2);
    }

    public final void a(g icon, u txt) {
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(txt, "txt");
        URLImageView uRLImageView = this.mIcon;
        Drawable mDefaultDrawable = this.mDefaultDrawable;
        Intrinsics.checkNotNullExpressionValue(mDefaultDrawable, "mDefaultDrawable");
        CommonExKt.r(uRLImageView, icon, mDefaultDrawable);
        this.mIcon.setScaleType(ImageView.ScaleType.FIT_XY);
        b.a(this.mTxt, txt, -1);
    }
}
