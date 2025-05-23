package mm1;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.nativepublish.title.SimplifiedFeedEditorTitleMviUIState;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.cw;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mvi.mvvm.BaseVB;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mm1.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import yl1.n;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 62.\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u00060\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u00072\u00020\b:\u00017B\u0017\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u00a2\u0006\u0004\b4\u00105J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\tH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0003H\u0016J\b\u0010\u0015\u001a\u00020\tH\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0003H\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010)\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010&R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R$\u00103\u001a\u00020.2\u0006\u0010/\u001a\u00020.8\u0016@RX\u0096\u000e\u00a2\u0006\f\n\u0004\b\u0015\u00100\u001a\u0004\b1\u00102\u00a8\u00068"}, d2 = {"Lmm1/f;", "Lcom/tencent/mvi/mvvm/BaseVB;", "Lmm1/b;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/title/SimplifiedFeedEditorTitleMviUIState;", "Lcom/tencent/base/api/runtime/a;", "Lzl1/a;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/FeedEditorContext;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/EditorBaseVB;", "Lmm1/a;", "", "g1", "l1", "j1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "Lmm1/g;", "e1", "state", "f1", BdhLogUtil.LogTag.Tag_Conn, "getRoot", "z0", "", "d", "I", "viewId", "Landroid/view/ViewGroup$LayoutParams;", "e", "Landroid/view/ViewGroup$LayoutParams;", "layoutParam", "Landroid/widget/FrameLayout;", "f", "Landroid/widget/FrameLayout;", "mRootLayout", "Landroid/widget/TextView;", h.F, "Landroid/widget/TextView;", "mCancelBnt", "i", "mTitleText", "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/ImageView;", "mArrowView", "", "<set-?>", "Z", "B0", "()Z", "isFollowingFirstLayerTop", "<init>", "(ILandroid/view/ViewGroup$LayoutParams;)V", "D", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class f extends BaseVB<b, SimplifiedFeedEditorTitleMviUIState, com.tencent.base.api.runtime.a<zl1.a>> implements a {
    private static int E = (int) cw.b(10);
    private static int F = (int) cw.b(10);

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isFollowingFirstLayerTop;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int viewId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewGroup.LayoutParams layoutParam;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private FrameLayout mRootLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mCancelBnt;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mTitleText;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView mArrowView;

    public f(int i3, @NotNull ViewGroup.LayoutParams layoutParam) {
        Intrinsics.checkNotNullParameter(layoutParam, "layoutParam");
        this.viewId = i3;
        this.layoutParam = layoutParam;
    }

    private final void g1() {
        final ImageView imageView = new ImageView(getMContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) cw.b(52), (int) cw.b(40));
        imageView.setPadding((int) cw.b(16), E, (int) cw.b(16), F);
        layoutParams.gravity = 8388629;
        imageView.setLayoutParams(layoutParams);
        imageView.setImageResource(R.drawable.guild_icon_publish_arrow_down);
        Context context = imageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        imageView.setImageDrawable(GuildUIUtils.w(context, R.drawable.guild_icon_publish_arrow_down, Integer.valueOf(R.color.qui_common_icon_primary)));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: mm1.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.h1(imageView, this, view);
            }
        });
        if1.a.b(imageView, "em_sgrp_unfold_packup", null, null, ExposurePolicy.REPORT_NONE, ClickPolicy.REPORT_NONE, null, null, null, 230, null);
        this.mArrowView = imageView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h1(ImageView this_apply, final f this$0, View view) {
        Map mutableMapOf;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this_apply.setOnClickListener(new View.OnClickListener() { // from class: mm1.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                f.i1(f.this, view2);
            }
        });
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("sgrp_btn_type", 2));
        VideoReport.reportEvent("clck", view, mutableMapOf);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i1(f this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(new b.a(false));
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void j1() {
        TextView textView = new TextView(getMContext());
        textView.setTextSize(17.0f);
        textView.setText(textView.getResources().getText(R.string.cancel));
        textView.setTextColor(textView.getResources().getColor(R.color.qui_common_text_primary));
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        textView.setPadding((int) cw.b(16), E, (int) cw.b(16), F);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(16);
        textView.setOnClickListener(new View.OnClickListener() { // from class: mm1.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.k1(f.this, view);
            }
        });
        this.mCancelBnt = textView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k1(f this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(b.C10795b.f416956d);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void l1() {
        TextView textView = new TextView(getMContext());
        textView.setTextSize(17.0f);
        textView.setText(textView.getResources().getText(R.string.f1522619x));
        textView.setTextColor(textView.getResources().getColor(R.color.qui_common_text_primary));
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setSingleLine();
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        textView.setPadding((int) cw.b(56), E, (int) cw.b(56), F);
        textView.setGravity(17);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(17);
        this.mTitleText = textView;
    }

    @Override // mm1.a
    /* renamed from: B0, reason: from getter */
    public boolean getIsFollowingFirstLayerTop() {
        return this.isFollowingFirstLayerTop;
    }

    @Override // mm1.a
    public void C() {
        FrameLayout frameLayout = null;
        if (this.mTitleText == null) {
            l1();
            FrameLayout frameLayout2 = this.mRootLayout;
            if (frameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootLayout");
                frameLayout2 = null;
            }
            frameLayout2.addView(this.mTitleText);
        }
        if (this.mArrowView == null) {
            g1();
            FrameLayout frameLayout3 = this.mRootLayout;
            if (frameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootLayout");
            } else {
                frameLayout = frameLayout3;
            }
            frameLayout.addView(this.mArrowView);
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: e1, reason: merged with bridge method [inline-methods] */
    public g getViewModel() {
        return new g();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: f1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull SimplifiedFeedEditorTitleMviUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        int i3 = 0;
        FrameLayout frameLayout = null;
        if (state instanceof SimplifiedFeedEditorTitleMviUIState.EditorTitleVisible) {
            SimplifiedFeedEditorTitleMviUIState.EditorTitleVisible editorTitleVisible = (SimplifiedFeedEditorTitleMviUIState.EditorTitleVisible) state;
            if (editorTitleVisible.getCom.tencent.mtt.hippy.dom.node.NodeProps.VISIBLE java.lang.String()) {
                if (this.mCancelBnt == null) {
                    j1();
                    FrameLayout frameLayout2 = this.mRootLayout;
                    if (frameLayout2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mRootLayout");
                        frameLayout2 = null;
                    }
                    frameLayout2.addView(this.mCancelBnt);
                }
                if (this.mTitleText == null) {
                    l1();
                    FrameLayout frameLayout3 = this.mRootLayout;
                    if (frameLayout3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mRootLayout");
                        frameLayout3 = null;
                    }
                    frameLayout3.addView(this.mTitleText);
                }
                TextView textView = this.mTitleText;
                if (textView != null) {
                    textView.setText(editorTitleVisible.getTitle());
                }
            }
            this.isFollowingFirstLayerTop = editorTitleVisible.getCom.tencent.mtt.hippy.dom.node.NodeProps.VISIBLE java.lang.String();
            FrameLayout frameLayout4 = this.mRootLayout;
            if (frameLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootLayout");
            } else {
                frameLayout = frameLayout4;
            }
            if (!editorTitleVisible.getCom.tencent.mtt.hippy.dom.node.NodeProps.VISIBLE java.lang.String()) {
                i3 = 8;
            }
            frameLayout.setVisibility(i3);
            return;
        }
        if (state instanceof SimplifiedFeedEditorTitleMviUIState.TitleStyle) {
            if (((SimplifiedFeedEditorTitleMviUIState.TitleStyle) state).getStyle() == 1) {
                if (this.mArrowView == null) {
                    g1();
                    FrameLayout frameLayout5 = this.mRootLayout;
                    if (frameLayout5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mRootLayout");
                    } else {
                        frameLayout = frameLayout5;
                    }
                    frameLayout.addView(this.mArrowView);
                }
                ImageView imageView = this.mArrowView;
                if (imageView != null) {
                    imageView.setVisibility(0);
                    return;
                }
                return;
            }
            ImageView imageView2 = this.mArrowView;
            if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
        }
    }

    @Override // mm1.a
    @Nullable
    public View getRoot() {
        FrameLayout frameLayout = this.mRootLayout;
        if (frameLayout == null) {
            return null;
        }
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootLayout");
            frameLayout = null;
        }
        return frameLayout;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        FrameLayout frameLayout = new FrameLayout(createViewParams.a());
        frameLayout.setId(this.viewId);
        frameLayout.setLayoutParams(this.layoutParam);
        this.mRootLayout = frameLayout;
        frameLayout.setVisibility(8);
        n.y(createViewParams.b(), a.class, this);
        FrameLayout frameLayout2 = this.mRootLayout;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootLayout");
            return null;
        }
        return frameLayout2;
    }

    @Override // mm1.a
    public void z0(@NotNull SimplifiedFeedEditorTitleMviUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        BaseVM<I, S, C> mUIModel = getMUIModel();
        if (mUIModel != 0) {
            mUIModel.updateUI(state);
        }
    }
}
