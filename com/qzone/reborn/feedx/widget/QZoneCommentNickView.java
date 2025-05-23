package com.qzone.reborn.feedx.widget;

import android.content.Context;
import android.graphics.NinePatch;
import android.graphics.drawable.NinePatchDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.text.TextCell;
import com.qzone.publish.ui.model.QzoneBarrageEffectData;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.compat.RFWNinePatchUtils;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 A2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001BB\u0011\b\u0016\u0012\u0006\u0010;\u001a\u00020:\u00a2\u0006\u0004\b<\u0010=B\u001b\b\u0016\u0012\u0006\u0010;\u001a\u00020:\u0012\b\u0010?\u001a\u0004\u0018\u00010>\u00a2\u0006\u0004\b<\u0010@J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0019\u0010\b\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u0006H\u0016J\u001a\u0010\r\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u0006H\u0014J\u000e\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000eJ\u0017\u0010\u0011\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\u0011\u0010\u0012J)\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0006\u0010\u0019\u001a\u00020\u0006J\u000e\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u000eR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010&R*\u0010/\u001a\u0016\u0012\u0004\u0012\u00020+\u0018\u00010*j\n\u0012\u0004\u0012\u00020+\u0018\u0001`,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\"\u00106\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u00108\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u00101\u001a\u0004\b8\u00103\"\u0004\b9\u00105\u00a8\u0006C"}, d2 = {"Lcom/qzone/reborn/feedx/widget/QZoneCommentNickView;", "Lcom/qzone/reborn/widget/QZoneBaseWidgetView;", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "", "x0", "w0", "", "nickTextColor", "v0", "(Ljava/lang/Integer;)I", "getLayoutId", "feedData", com.tencent.luggage.wxa.c8.c.G, "r0", "", "content", "s0", "n0", "(Ljava/lang/Integer;)V", "", "hasVipData", "Lcom/qzone/publish/ui/model/QzoneBarrageEffectData$BarrageEffectInfo;", "effectInfo", "o0", "(ZLjava/lang/Integer;Lcom/qzone/publish/ui/model/QzoneBarrageEffectData$BarrageEffectInfo;)V", "u0", "bubbleBgUrl", "p0", "Landroidx/constraintlayout/widget/ConstraintLayout;", "e", "Landroidx/constraintlayout/widget/ConstraintLayout;", "commentRootLayout", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "commentNickNameBg", "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", tl.h.F, "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", "commentAlignView", "i", "commentContent", "Ljava/util/ArrayList;", "Lcom/qzone/proxy/feedcomponent/text/TextCell;", "Lkotlin/collections/ArrayList;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/ArrayList;", "commentTextCells", BdhLogUtil.LogTag.Tag_Conn, "Z", "getHasBarrageEffect", "()Z", "setHasBarrageEffect", "(Z)V", "hasBarrageEffect", "D", "isFeedDetail", "setFeedDetail", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "E", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneCommentNickView extends QZoneBaseWidgetView<BusinessFeedData> {
    private static final int F = ImmersiveUtils.dpToPx(1.0f);
    private static final int G = ImmersiveUtils.dpToPx(80.0f);
    private static final int H = ImmersiveUtils.dpToPx(30.0f);

    /* renamed from: C, reason: from kotlin metadata */
    private boolean hasBarrageEffect;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isFeedDetail;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ConstraintLayout commentRootLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView commentNickNameBg;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private QZoneRichTextView commentAlignView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QZoneRichTextView commentContent;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ArrayList<TextCell> commentTextCells;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneCommentNickView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        x0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(QZoneCommentNickView this$0, LoadState loadState, Option option) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (loadState.isFinishSuccess() && option.getResultBitMap() != null) {
            if (NinePatch.isNinePatchChunk(option.getResultBitMap().getNinePatchChunk())) {
                NinePatchDrawable ninePatchDrawable = RFWNinePatchUtils.getNinePatchDrawable(option.getResultBitMap());
                if (ninePatchDrawable != null) {
                    ImageView imageView = this$0.commentNickNameBg;
                    if (imageView == null) {
                        return;
                    }
                    imageView.setBackground(ninePatchDrawable);
                    return;
                }
                QLog.e("BaseWidgetView", 1, "[updateCommentNickNameBg] no ninePatchDrawable");
                return;
            }
            return;
        }
        QLog.e("BaseWidgetView", 1, "onStateChange state:" + loadState.isFinishSuccess() + " resultBitmap:" + option.getResultBitMap());
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int v0(Integer nickTextColor) {
        int i3;
        if (!bl.b(this.commentTextCells)) {
            ArrayList<TextCell> arrayList = this.commentTextCells;
            Intrinsics.checkNotNull(arrayList);
            Iterator<TextCell> it = arrayList.iterator();
            while (it.hasNext()) {
                TextCell next = it.next();
                if (next != null) {
                    if (nickTextColor != null) {
                        next.setInnerLinkTextColor(nickTextColor.intValue());
                    }
                    QZoneRichTextView qZoneRichTextView = this.commentContent;
                    if (qZoneRichTextView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("commentContent");
                        qZoneRichTextView = null;
                    }
                    i3 = (int) qZoneRichTextView.getCellWidth(next);
                    return i3 <= u0() ? u0() : i3;
                }
            }
        }
        i3 = 0;
        if (i3 <= u0()) {
        }
    }

    private final void w0() {
        this.commentNickNameBg = new ImageView(getContext());
        QZoneNickNameView qZoneNickNameView = new QZoneNickNameView(getContext());
        this.commentAlignView = qZoneNickNameView;
        Intrinsics.checkNotNull(qZoneNickNameView);
        qZoneNickNameView.setMaxLine(1);
        QZoneRichTextView qZoneRichTextView = this.commentAlignView;
        Intrinsics.checkNotNull(qZoneRichTextView);
        qZoneRichTextView.setId(R.id.nbu);
        QZoneRichTextView qZoneRichTextView2 = this.commentAlignView;
        Intrinsics.checkNotNull(qZoneRichTextView2);
        qZoneRichTextView2.setTextSize(ef.d.b(14));
        ConstraintLayout constraintLayout = this.commentRootLayout;
        ViewGroup viewGroup = null;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commentRootLayout");
            constraintLayout = null;
        }
        QZoneRichTextView qZoneRichTextView3 = this.commentAlignView;
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams.topToTop = R.id.mrm;
        Unit unit = Unit.INSTANCE;
        constraintLayout.addView(qZoneRichTextView3, layoutParams);
        ConstraintLayout constraintLayout2 = this.commentRootLayout;
        if (constraintLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commentRootLayout");
        } else {
            viewGroup = constraintLayout2;
        }
        ImageView imageView = this.commentNickNameBg;
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(-1, -2);
        layoutParams2.topToTop = R.id.nbu;
        layoutParams2.bottomToBottom = R.id.nbu;
        layoutParams2.leftToLeft = 0;
        viewGroup.addView(imageView, layoutParams2);
    }

    private final void x0() {
        ConstraintLayout constraintLayout = new ConstraintLayout(getContext());
        this.commentRootLayout = constraintLayout;
        addView(constraintLayout, new FrameLayout.LayoutParams(-1, -2));
        QZoneNickNameView qZoneNickNameView = new QZoneNickNameView(getContext());
        qZoneNickNameView.setTextColor(qZoneNickNameView.getResources().getColor(R.color.qui_common_text_primary));
        qZoneNickNameView.setTextSize(ef.d.b(14));
        this.commentContent = qZoneNickNameView;
        qZoneNickNameView.setId(R.id.mrm);
        ConstraintLayout constraintLayout2 = this.commentRootLayout;
        QZoneRichTextView qZoneRichTextView = null;
        if (constraintLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commentRootLayout");
            constraintLayout2 = null;
        }
        QZoneRichTextView qZoneRichTextView2 = this.commentContent;
        if (qZoneRichTextView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commentContent");
        } else {
            qZoneRichTextView = qZoneRichTextView2;
        }
        constraintLayout2.addView(qZoneRichTextView, new ConstraintLayout.LayoutParams(-1, -2));
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return 0;
    }

    public final void n0(Integer nickTextColor) {
        ImageView imageView = this.commentNickNameBg;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        QZoneRichTextView qZoneRichTextView = this.commentAlignView;
        if (qZoneRichTextView != null) {
            qZoneRichTextView.setVisibility(8);
        }
        QZoneRichTextView qZoneRichTextView2 = this.commentContent;
        if (qZoneRichTextView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commentContent");
            qZoneRichTextView2 = null;
        }
        qZoneRichTextView2.setMaxLine(-1);
    }

    public final void o0(boolean hasVipData, Integer nickTextColor, QzoneBarrageEffectData.BarrageEffectInfo effectInfo) {
        int v06 = v0(nickTextColor);
        if (v06 == 0) {
            return;
        }
        if (this.commentNickNameBg == null) {
            w0();
        }
        ImageView imageView = this.commentNickNameBg;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        QZoneRichTextView qZoneRichTextView = this.commentAlignView;
        if (qZoneRichTextView != null) {
            qZoneRichTextView.setVisibility(4);
        }
        QZoneRichTextView qZoneRichTextView2 = this.commentAlignView;
        if (qZoneRichTextView2 != null) {
            qZoneRichTextView2.setRichText(" ");
        }
        ImageView imageView2 = this.commentNickNameBg;
        QZoneRichTextView qZoneRichTextView3 = null;
        ViewGroup.LayoutParams layoutParams = imageView2 != null ? imageView2.getLayoutParams() : null;
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = v06 - (hasVipData ? 0 : F);
        if (this.hasBarrageEffect) {
            QZoneRichTextView qZoneRichTextView4 = this.commentContent;
            if (qZoneRichTextView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("commentContent");
                qZoneRichTextView4 = null;
            }
            qZoneRichTextView4.setLineSpace(ImmersiveUtils.dpToPx(2.0f));
            QZoneRichTextView qZoneRichTextView5 = this.commentAlignView;
            if (qZoneRichTextView5 != null) {
                qZoneRichTextView5.setLineSpace(ImmersiveUtils.dpToPx(2.0f));
            }
            QZoneRichTextView qZoneRichTextView6 = this.commentAlignView;
            if (qZoneRichTextView6 != null) {
                qZoneRichTextView6.setBarrageEffect(effectInfo != null, effectInfo);
            }
        } else {
            QZoneRichTextView qZoneRichTextView7 = this.commentContent;
            if (qZoneRichTextView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("commentContent");
                qZoneRichTextView7 = null;
            }
            qZoneRichTextView7.setLineSpace(ImmersiveUtils.dpToPx(8.0f));
            QZoneRichTextView qZoneRichTextView8 = this.commentAlignView;
            if (qZoneRichTextView8 != null) {
                qZoneRichTextView8.setLineSpace(ImmersiveUtils.dpToPx(8.0f));
            }
            QZoneRichTextView qZoneRichTextView9 = this.commentAlignView;
            if (qZoneRichTextView9 != null) {
                qZoneRichTextView9.setBarrageEffect(false, null);
            }
        }
        ImageView imageView3 = this.commentNickNameBg;
        if (imageView3 != null) {
            imageView3.setLayoutParams(layoutParams2);
        }
        if (this.isFeedDetail) {
            QZoneRichTextView qZoneRichTextView10 = this.commentContent;
            if (qZoneRichTextView10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("commentContent");
                qZoneRichTextView10 = null;
            }
            qZoneRichTextView10.setMaxLine(1);
            QZoneRichTextView qZoneRichTextView11 = this.commentContent;
            if (qZoneRichTextView11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("commentContent");
            } else {
                qZoneRichTextView3 = qZoneRichTextView11;
            }
            qZoneRichTextView3.setMaxWidth(u0());
            ImageView imageView4 = this.commentNickNameBg;
            if (imageView4 == null) {
                return;
            }
            imageView4.setMaxWidth(u0());
        }
    }

    public final void p0(String bubbleBgUrl) {
        Intrinsics.checkNotNullParameter(bubbleBgUrl, "bubbleBgUrl");
        if (TextUtils.isEmpty(bubbleBgUrl)) {
            QLog.e("BaseWidgetView", 1, "[bindCommentNickBg] bubbleBgUrl is empty");
            return;
        }
        Option isNinePatch = Option.obtain().setUrl(bubbleBgUrl).setIsNinePatch(true);
        Intrinsics.checkNotNullExpressionValue(isNinePatch, "obtain()\n            .se\u2026    .setIsNinePatch(true)");
        com.tencent.mobileqq.qzone.picload.c.a().i(isNinePatch, new IPicLoadStateListener() { // from class: com.qzone.reborn.feedx.widget.a
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                QZoneCommentNickView.q0(QZoneCommentNickView.this, loadState, option);
            }
        });
    }

    public final void s0(String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        QZoneRichTextView qZoneRichTextView = this.commentContent;
        if (qZoneRichTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commentContent");
            qZoneRichTextView = null;
        }
        this.commentTextCells = qZoneRichTextView.setRichText(content);
    }

    public final void setFeedDetail(boolean z16) {
        this.isFeedDetail = z16;
    }

    public final void setHasBarrageEffect(boolean z16) {
        this.hasBarrageEffect = z16;
    }

    public final int u0() {
        int screenWidth;
        int i3;
        if (this.isFeedDetail) {
            screenWidth = ImmersiveUtils.getScreenWidth();
            i3 = H;
        } else {
            screenWidth = ImmersiveUtils.getScreenWidth();
            i3 = G;
        }
        return screenWidth - i3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneCommentNickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        x0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public void bindData(BusinessFeedData feedData, int pos) {
    }
}
