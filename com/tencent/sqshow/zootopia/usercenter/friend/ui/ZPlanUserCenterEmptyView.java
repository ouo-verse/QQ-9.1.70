package com.tencent.sqshow.zootopia.usercenter.friend.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u001eB\u0011\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u00a2\u0006\u0004\b\u0019\u0010\u001aB\u001b\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u00a2\u0006\u0004\b\u0019\u0010\u001dJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\"\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u000f\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/sqshow/zootopia/usercenter/friend/ui/ZPlanUserCenterEmptyView;", "Landroid/widget/LinearLayout;", "", "resId", "", IECSearchBar.METHOD_SET_TEXT, "Lcom/tencent/sqshow/zootopia/usercenter/friend/ui/ZPlanUserCenterEmptyView$MODE;", "mode", "", "needRetry", "Landroid/view/View$OnClickListener;", "onClickListener", "setMode", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "textView", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "imageView", "f", "retryView", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "MODE", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanUserCenterEmptyView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TextView textView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView imageView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView retryView;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/sqshow/zootopia/usercenter/friend/ui/ZPlanUserCenterEmptyView$MODE;", "", "(Ljava/lang/String;I)V", "MODE_EMPTY_PRODUCT", "MODE_NO_NETWORK", "MODE_EMPTY_CONTENT", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public enum MODE {
        MODE_EMPTY_PRODUCT,
        MODE_NO_NETWORK,
        MODE_EMPTY_CONTENT
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f373145a;

        static {
            int[] iArr = new int[MODE.values().length];
            try {
                iArr[MODE.MODE_EMPTY_PRODUCT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MODE.MODE_NO_NETWORK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MODE.MODE_EMPTY_CONTENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f373145a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanUserCenterEmptyView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.f167469dh3, this);
        this.textView = (TextView) findViewById(R.id.r9e);
        this.imageView = (ImageView) findViewById(R.id.r9c);
        this.retryView = (TextView) findViewById(R.id.r9d);
        setOrientation(1);
        setGravity(17);
    }

    public final void setMode(MODE mode, boolean needRetry, View.OnClickListener onClickListener) {
        ImageView imageView;
        Intrinsics.checkNotNullParameter(mode, "mode");
        int i3 = a.f373145a[mode.ordinal()];
        if (i3 == 1) {
            ImageView imageView2 = this.imageView;
            if (imageView2 != null) {
                imageView2.setImageResource(R.drawable.iiv);
            }
        } else if (i3 == 2) {
            ImageView imageView3 = this.imageView;
            if (imageView3 != null) {
                imageView3.setImageResource(R.drawable.iix);
            }
        } else if (i3 == 3 && (imageView = this.imageView) != null) {
            imageView.setImageResource(R.drawable.ifg);
        }
        if (needRetry) {
            TextView textView = this.retryView;
            if (textView != null) {
                textView.setVisibility(0);
            }
            TextView textView2 = this.retryView;
            if (textView2 != null) {
                textView2.setOnClickListener(onClickListener);
            }
        }
    }

    public final void setText(int resId) {
        TextView textView = this.textView;
        if (textView != null) {
            textView.setText(resId);
        }
    }

    public static /* synthetic */ void setMode$default(ZPlanUserCenterEmptyView zPlanUserCenterEmptyView, MODE mode, boolean z16, View.OnClickListener onClickListener, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            onClickListener = null;
        }
        zPlanUserCenterEmptyView.setMode(mode, z16, onClickListener);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanUserCenterEmptyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.f167469dh3, this);
        this.textView = (TextView) findViewById(R.id.r9e);
        this.imageView = (ImageView) findViewById(R.id.r9c);
        this.retryView = (TextView) findViewById(R.id.r9d);
        setOrientation(1);
        setGravity(17);
    }
}
