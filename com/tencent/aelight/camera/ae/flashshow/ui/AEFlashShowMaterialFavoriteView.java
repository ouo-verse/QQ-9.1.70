package com.tencent.aelight.camera.ae.flashshow.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\"\u001a\u00020!\u00a2\u0006\u0004\b#\u0010$B\u001b\b\u0016\u0012\u0006\u0010\"\u001a\u00020!\u0012\b\u0010&\u001a\u0004\u0018\u00010%\u00a2\u0006\u0004\b#\u0010'B#\b\u0016\u0012\u0006\u0010\"\u001a\u00020!\u0012\b\u0010&\u001a\u0004\u0018\u00010%\u0012\u0006\u0010(\u001a\u00020\b\u00a2\u0006\u0004\b#\u0010)J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016R\u0018\u0010\r\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R$\u0010 \u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u0006*"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/ui/AEFlashShowMaterialFavoriteView;", "Landroid/widget/RelativeLayout;", "", "b", "d", "", "favorite", "setFavorite", "", "visibility", "setVisibility", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "ivFavorite", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "tvFavorite", "Landroid/widget/LinearLayout;", "f", "Landroid/widget/LinearLayout;", "llFavorite", tl.h.F, "Z", "favoriteState", "Lcom/tencent/aelight/camera/ae/flashshow/ui/dr;", "i", "Lcom/tencent/aelight/camera/ae/flashshow/ui/dr;", "getListener", "()Lcom/tencent/aelight/camera/ae/flashshow/ui/dr;", "setListener", "(Lcom/tencent/aelight/camera/ae/flashshow/ui/dr;)V", "listener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class AEFlashShowMaterialFavoriteView extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ImageView ivFavorite;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView tvFavorite;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private LinearLayout llFavorite;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean favoriteState;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private dr listener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AEFlashShowMaterialFavoriteView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.dlp, (ViewGroup) this, true);
        setBackgroundResource(R.drawable.irt);
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(AEFlashShowMaterialFavoriteView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dr drVar = this$0.listener;
        if (drVar != null) {
            drVar.a();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void d() {
        if (this.favoriteState) {
            ImageView imageView = this.ivFavorite;
            if (imageView != null) {
                imageView.setImageResource(R.drawable.iwc);
            }
            TextView textView = this.tvFavorite;
            if (textView == null) {
                return;
            }
            textView.setText(getContext().getString(R.string.y0j));
            return;
        }
        ImageView imageView2 = this.ivFavorite;
        if (imageView2 != null) {
            imageView2.setImageResource(R.drawable.iwd);
        }
        TextView textView2 = this.tvFavorite;
        if (textView2 == null) {
            return;
        }
        textView2.setText(getContext().getString(R.string.y0i));
    }

    public final void setFavorite(boolean favorite) {
        if (this.favoriteState == favorite) {
            return;
        }
        this.favoriteState = favorite;
        d();
    }

    public final void setListener(dr drVar) {
        this.listener = drVar;
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
    }

    private final void b() {
        this.llFavorite = (LinearLayout) findViewById(R.id.rwk);
        this.ivFavorite = (ImageView) findViewById(R.id.rvt);
        this.tvFavorite = (TextView) findViewById(R.id.s3m);
        d();
        LinearLayout linearLayout = this.llFavorite;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.bh
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AEFlashShowMaterialFavoriteView.c(AEFlashShowMaterialFavoriteView.this, view);
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AEFlashShowMaterialFavoriteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.dlp, (ViewGroup) this, true);
        setBackgroundResource(R.drawable.irt);
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AEFlashShowMaterialFavoriteView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.dlp, (ViewGroup) this, true);
        setBackgroundResource(R.drawable.irt);
        b();
    }
}
