package com.tencent.state.square.holder.component.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.EntranceLink;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.IRouter;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.api.ISquarePagView;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.data.SquareBlindBoxEntranceInfo;
import com.tencent.state.square.databinding.VasSquareAvatarComponentBliandBoxBinding;
import com.tencent.state.square.resource.PAGLoader;
import com.tencent.state.square.resource.PAGLoaderOption;
import com.tencent.state.square.resource.PagPreloadManager;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0014\u001a\u00020\u0012H\u0014J\u0006\u0010\u0015\u001a\u00020\u0012J\u000e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u000eJ\u000e\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0007R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/state/square/holder/component/view/BlindBoxView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/tencent/state/square/databinding/VasSquareAvatarComponentBliandBoxBinding;", "blindBoxPag", "Lcom/tencent/state/square/api/ISquarePagView;", "currentData", "Lcom/tencent/state/square/data/SquareBlindBoxEntranceInfo;", "reporter", "Lcom/tencent/state/square/IReporter;", "hide", "", "initPag", NodeProps.ON_ATTACHED_TO_WINDOW, "show", "updateData", "data", "updateLayout", "id", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class BlindBoxView extends FrameLayout {
    private final VasSquareAvatarComponentBliandBoxBinding binding;
    private ISquarePagView blindBoxPag;
    private SquareBlindBoxEntranceInfo currentData;
    private IReporter reporter;

    public BlindBoxView(Context context) {
        this(context, null, 0, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initPag() {
        if (this.blindBoxPag == null) {
            ICommonUtils commonUtils = SquareBase.INSTANCE.getConfig().getCommonUtils();
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            ISquarePagView pagImageView = commonUtils.getPagImageView(context);
            this.blindBoxPag = pagImageView;
            if (pagImageView != null) {
                this.binding.blindBox.removeAllViews();
                this.binding.blindBox.addView(pagImageView.getView(), new FrameLayout.LayoutParams(-1, -1));
            }
        }
        ISquarePagView iSquarePagView = this.blindBoxPag;
        if (iSquarePagView != null) {
            PAGLoader.INSTANCE.playPAG(PagPreloadManager.BLIND_BOX_PAG, PagPreloadManager.BLIND_BOX_PAG_FILE_NAME, iSquarePagView, new PAGLoaderOption(Integer.MAX_VALUE));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        IReporter iReporter = this.reporter;
        FrameLayout frameLayout = this.binding.blindBox;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.blindBox");
        iReporter.setElementInfo(frameLayout, SquareReportConst.ElementId.ELEMENT_ID_SQUARE_BLIND_BOX, new LinkedHashMap(), false, false);
        this.binding.blindBoxHotArea.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.holder.component.view.BlindBoxView$onAttachedToWindow$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SquareBlindBoxEntranceInfo squareBlindBoxEntranceInfo;
                String linkUrl;
                IReporter iReporter2;
                VasSquareAvatarComponentBliandBoxBinding vasSquareAvatarComponentBliandBoxBinding;
                squareBlindBoxEntranceInfo = BlindBoxView.this.currentData;
                if (squareBlindBoxEntranceInfo == null || (linkUrl = squareBlindBoxEntranceInfo.getLinkUrl()) == null) {
                    return;
                }
                IRouter router = Square.INSTANCE.getConfig().getRouter();
                Context context = BlindBoxView.this.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                router.routeLink(context, new EntranceLink(linkUrl, 2));
                iReporter2 = BlindBoxView.this.reporter;
                vasSquareAvatarComponentBliandBoxBinding = BlindBoxView.this.binding;
                FrameLayout frameLayout2 = vasSquareAvatarComponentBliandBoxBinding.blindBox;
                Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.blindBox");
                iReporter2.reportEvent("clck", frameLayout2, new LinkedHashMap());
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000f, code lost:
    
        if (r4.isShow() == true) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void updateData(SquareBlindBoxEntranceInfo data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.currentData = data;
        boolean z16 = data != null;
        if (z16) {
            show();
            SquareBaseKt.getSquareThread().postOnUiDelayed(300L, new Function0<Unit>() { // from class: com.tencent.state.square.holder.component.view.BlindBoxView$updateData$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    BlindBoxView.this.initPag();
                }
            });
            IReporter iReporter = this.reporter;
            FrameLayout frameLayout = this.binding.blindBox;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.blindBox");
            iReporter.reportEvent("imp", frameLayout, new LinkedHashMap());
            return;
        }
        hide();
    }

    public final void updateLayout(int id5) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = null;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        if (layoutParams2 != null) {
            layoutParams2.addRule(8, id5);
            setTranslationX(ViewExtensionsKt.dip(getContext(), -50));
            layoutParams2.bottomMargin = ViewExtensionsKt.dip(getContext(), 24);
            layoutParams2.addRule(14, -1);
        }
    }

    public BlindBoxView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public final void show() {
        setVisibility(0);
    }

    public /* synthetic */ BlindBoxView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    public final void hide() {
        setVisibility(8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BlindBoxView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        VasSquareAvatarComponentBliandBoxBinding inflate = VasSquareAvatarComponentBliandBoxBinding.inflate(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareAvatarComponent\u2026ater.from(context), this)");
        this.binding = inflate;
        this.reporter = SquareBase.INSTANCE.getConfig().getReporter();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) (layoutParams instanceof RelativeLayout.LayoutParams ? layoutParams : null);
        if (layoutParams2 != null) {
            layoutParams2.width = -2;
            layoutParams2.height = -2;
        }
    }
}
