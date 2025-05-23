package com.tencent.mm.plugin.appbrand.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0017\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mm/plugin/appbrand/widget/AppBrandActionBarCustomImageView;", "Landroid/widget/ImageView;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "luggage-wxa-app_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes9.dex */
public final class AppBrandActionBarCustomImageView extends ImageView {
    public AppBrandActionBarCustomImageView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        if (event != null) {
            int action = event.getAction();
            if (action != 0) {
                if (action == 1) {
                    setAlpha(1.0f);
                }
            } else {
                setAlpha(0.5f);
            }
        }
        return super.onTouchEvent(event);
    }
}
