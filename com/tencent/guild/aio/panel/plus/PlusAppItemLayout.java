package com.tencent.guild.aio.panel.plus;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016B\u001d\b\u0016\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\u0004\b\u0015\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0014J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/guild/aio/panel/plus/PlusAppItemLayout;", "Landroid/widget/RelativeLayout;", "", c.f123400v, "", "a", "onFinishInflate", "Landroid/view/MotionEvent;", "event", "", "onTouchEvent", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "appIconIv", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "appNameTv", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class PlusAppItemLayout extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView appIconIv;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView appNameTv;

    public PlusAppItemLayout(@Nullable Context context) {
        super(context);
    }

    private final void a(float alpha) {
        ImageView imageView = this.appIconIv;
        if (imageView != null) {
            imageView.setAlpha(alpha);
        }
        TextView textView = this.appNameTv;
        if (textView != null) {
            textView.setAlpha(alpha);
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.appIconIv = (ImageView) findViewById(R.id.dcf);
        this.appNameTv = (TextView) findViewById(R.id.textView1);
    }

    @Override // android.view.View
    public boolean onTouchEvent(@Nullable MotionEvent event) {
        Integer num;
        if (event != null) {
            num = Integer.valueOf(event.getAction());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 0) {
            a(0.5f);
        } else {
            boolean z16 = true;
            if ((num == null || num.intValue() != 1) && (num == null || num.intValue() != 3)) {
                z16 = false;
            }
            if (z16) {
                a(1.0f);
            } else if (num == null || num.intValue() != 2) {
                a(1.0f);
            }
        }
        return super.onTouchEvent(event);
    }

    public PlusAppItemLayout(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
