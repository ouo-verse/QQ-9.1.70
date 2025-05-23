package com.qzone.reborn.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.widget.RFWSquareImageView;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010(\u001a\u0004\u0018\u00010'\u00a2\u0006\u0004\b)\u0010*B\u001d\b\u0016\u0012\b\u0010(\u001a\u0004\u0018\u00010'\u0012\b\u0010,\u001a\u0004\u0018\u00010+\u00a2\u0006\u0004\b)\u0010-B%\b\u0016\u0012\b\u0010(\u001a\u0004\u0018\u00010'\u0012\b\u0010,\u001a\u0004\u0018\u00010+\u0012\u0006\u0010.\u001a\u00020\r\u00a2\u0006\u0004\b)\u0010/J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0017J&\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0007R\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0018\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\"\u0010\u001f\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010&\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%\u00a8\u00060"}, d2 = {"Lcom/qzone/reborn/widget/QZonePublishSquareImageView;", "Lcom/tencent/biz/richframework/widget/RFWSquareImageView;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "draw", "", "url", "", "loadVideoCover", "Lcom/tencent/libra/listener/IPicLoadStateListener;", "listener", "f", "", "d", "I", "getRequestHeight", "()I", "setRequestHeight", "(I)V", "requestHeight", "e", "getRequestWidth", "setRequestWidth", "requestWidth", "Lcom/tencent/libra/request/Option;", "Lcom/tencent/libra/request/Option;", "c", "()Lcom/tencent/libra/request/Option;", "setOption", "(Lcom/tencent/libra/request/Option;)V", "option", tl.h.F, "Lcom/tencent/libra/listener/IPicLoadStateListener;", "getDefaultLoadListener", "()Lcom/tencent/libra/listener/IPicLoadStateListener;", "setDefaultLoadListener", "(Lcom/tencent/libra/listener/IPicLoadStateListener;)V", "defaultLoadListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZonePublishSquareImageView extends RFWSquareImageView {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int requestHeight;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int requestWidth;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Option option;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private IPicLoadStateListener defaultLoadListener;

    public QZonePublishSquareImageView(Context context) {
        super(context);
        this.requestHeight = -1;
        this.requestWidth = -1;
        Option obtain = Option.obtain();
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain()");
        this.option = obtain;
        this.defaultLoadListener = new IPicLoadStateListener() { // from class: com.qzone.reborn.widget.j
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                QZonePublishSquareImageView.b(loadState, option);
            }
        };
    }

    /* renamed from: c, reason: from getter */
    public final Option getOption() {
        return this.option;
    }

    public final void d(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        g(this, url, false, null, 6, null);
    }

    @Override // com.tencent.biz.richframework.widget.RFWSquareImageView, android.view.View
    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.draw(canvas);
        if (getDrawable() == null || getDrawable().getCallback() == this) {
            return;
        }
        getDrawable().setCallback(this);
    }

    public final void e(String url, boolean z16) {
        Intrinsics.checkNotNullParameter(url, "url");
        g(this, url, z16, null, 4, null);
    }

    public final void f(String url, boolean loadVideoCover, IPicLoadStateListener listener) {
        Intrinsics.checkNotNullParameter(url, "url");
        Option e16 = com.tencent.mobileqq.qzone.picload.c.e(url);
        e16.setTargetView(this);
        int i3 = this.requestWidth;
        if (i3 == -1) {
            i3 = getLayoutParams().width;
        }
        e16.setRequestWidth(i3);
        int i16 = this.requestHeight;
        if (i16 == -1) {
            i16 = getLayoutParams().width;
        }
        e16.setRequestHeight(i16);
        e16.setLoadingDrawableId(R.drawable.asd);
        e16.setFailedDrawableId(R.drawable.asd);
        if (loadVideoCover) {
            e16.setPreferDecoder(f11.a.class);
        }
        Intrinsics.checkNotNullExpressionValue(e16, "getThumbOption(url).also\u2026)\n            }\n        }");
        this.option = e16;
        if (listener == null) {
            listener = this.defaultLoadListener;
        }
        com.tencent.mobileqq.qzone.picload.c.a().i(this.option, listener);
    }

    public final void setDefaultLoadListener(IPicLoadStateListener iPicLoadStateListener) {
        Intrinsics.checkNotNullParameter(iPicLoadStateListener, "<set-?>");
        this.defaultLoadListener = iPicLoadStateListener;
    }

    public final void setOption(Option option) {
        Intrinsics.checkNotNullParameter(option, "<set-?>");
        this.option = option;
    }

    public final void setRequestHeight(int i3) {
        this.requestHeight = i3;
    }

    public final void setRequestWidth(int i3) {
        this.requestWidth = i3;
    }

    public QZonePublishSquareImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.requestHeight = -1;
        this.requestWidth = -1;
        Option obtain = Option.obtain();
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain()");
        this.option = obtain;
        this.defaultLoadListener = new IPicLoadStateListener() { // from class: com.qzone.reborn.widget.j
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                QZonePublishSquareImageView.b(loadState, option);
            }
        };
    }

    public QZonePublishSquareImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.requestHeight = -1;
        this.requestWidth = -1;
        Option obtain = Option.obtain();
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain()");
        this.option = obtain;
        this.defaultLoadListener = new IPicLoadStateListener() { // from class: com.qzone.reborn.widget.j
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                QZonePublishSquareImageView.b(loadState, option);
            }
        };
    }

    public static /* synthetic */ void g(QZonePublishSquareImageView qZonePublishSquareImageView, String str, boolean z16, IPicLoadStateListener iPicLoadStateListener, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        if ((i3 & 4) != 0) {
            iPicLoadStateListener = null;
        }
        qZonePublishSquareImageView.f(str, z16, iPicLoadStateListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LoadState loadState, Option option) {
    }
}
