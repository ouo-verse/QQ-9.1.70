package com.tencent.ecommerce.biz.live.ui.viewholder;

import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0019\u001a\u00020\u0006\u0012\u0016\b\u0002\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001aj\u0004\u0018\u0001`\u001b\u00a2\u0006\u0004\b\u001f\u0010 J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\bR\"\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001aj\u0004\u0018\u0001`\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/ecommerce/biz/live/ui/viewholder/d;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "loadStatus", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "E", "Landroid/view/View;", "noMoreLayout", UserInfo.SEX_FEMALE, "loadingLayout", "Landroid/widget/ImageView;", "G", "Landroid/widget/ImageView;", "loadingIcon", "Landroid/widget/TextView;", "H", "Landroid/widget/TextView;", "contentView", "Landroid/view/animation/RotateAnimation;", "I", "Landroid/view/animation/RotateAnimation;", "anim", "J", "view", "Lkotlin/Function0;", "Lcom/tencent/ecommerce/biz/live/ui/adapter/FooterRetryClick;", "K", "Lkotlin/jvm/functions/Function0;", "onFooterRetryClick", "<init>", "(Landroid/view/View;Lkotlin/jvm/functions/Function0;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class d extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    private View noMoreLayout;

    /* renamed from: F, reason: from kotlin metadata */
    private View loadingLayout;

    /* renamed from: G, reason: from kotlin metadata */
    private ImageView loadingIcon;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView contentView;

    /* renamed from: I, reason: from kotlin metadata */
    private final RotateAnimation anim;

    /* renamed from: J, reason: from kotlin metadata */
    private final View view;

    /* renamed from: K, reason: from kotlin metadata */
    private final Function0<Unit> onFooterRetryClick;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Function0 function0 = d.this.onFooterRetryClick;
            if (function0 != null) {
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public d(View view, Function0<Unit> function0) {
        super(view);
        this.view = view;
        this.onFooterRetryClick = function0;
        this.noMoreLayout = view.findViewById(R.id.f163073o53);
        this.loadingLayout = view.findViewById(R.id.o3o);
        this.loadingIcon = (ImageView) view.findViewById(R.id.o3n);
        this.contentView = (TextView) view.findViewById(R.id.nuq);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(1000L);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setFillAfter(true);
        Unit unit = Unit.INSTANCE;
        this.anim = rotateAnimation;
    }

    public final void m(int loadStatus) {
        if (loadStatus == 0) {
            this.loadingLayout.setVisibility(0);
            this.noMoreLayout.setVisibility(8);
            this.loadingIcon.startAnimation(this.anim);
            return;
        }
        this.noMoreLayout.setVisibility(0);
        this.loadingLayout.setVisibility(8);
        this.loadingIcon.clearAnimation();
        if (loadStatus == 1) {
            this.contentView.setText(this.view.getContext().getResources().getString(R.string.wnq));
        } else {
            this.contentView.setText(this.view.getContext().getResources().getString(R.string.wno));
            this.contentView.setOnClickListener(new a());
        }
    }
}
