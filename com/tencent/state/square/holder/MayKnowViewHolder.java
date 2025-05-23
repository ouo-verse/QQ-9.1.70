package com.tencent.state.square.holder;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.state.data.Gender;
import com.tencent.state.map.IMapViewListener;
import com.tencent.state.map.Location;
import com.tencent.state.map.MapItem;
import com.tencent.state.map.MapItemController;
import com.tencent.state.map.MapViewHolder;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareUtil;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.data.SquareMayKnowItem;
import com.tencent.state.square.databinding.VasSquareItemMayKnowBinding;
import com.tencent.state.square.mayknow.MayKnowLabel;
import com.tencent.state.utils.RegexUtils;
import com.tencent.state.view.SquareImageView;
import com.tencent.state.view.SquareMayKnowLabelView;
import com.tencent.state.view.SquareTabLayout;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0001\"B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0002H\u0002J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0002H\u0002J\u0012\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010\u0013\u001a\u00020\rH\u0002J\u0018\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0014J\u0012\u0010\u0017\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0012\u0010!\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\u001bH\u0014R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/tencent/state/square/holder/MayKnowViewHolder;", "Lcom/tencent/state/map/MapViewHolder;", "Lcom/tencent/state/square/data/SquareMayKnowItem;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnLongClickListener;", "binding", "Lcom/tencent/state/square/databinding/VasSquareItemMayKnowBinding;", "(Lcom/tencent/state/square/databinding/VasSquareItemMayKnowBinding;)V", "getBinding", "()Lcom/tencent/state/square/databinding/VasSquareItemMayKnowBinding;", "reporter", "Lcom/tencent/state/square/IReporter;", "bindAvatar", "", "data", "bindLabels", "bindReason", "reason", "", "bindReport", "doBind", "index", "", NodeProps.ON_CLICK, "v", "Landroid/view/View;", "onFirstScreenCompleted", "Lcom/tencent/state/map/MapItem;", NodeProps.ON_LONG_CLICK, "", "resizeAvatar", "location", "Lcom/tencent/state/map/Location;", "transform", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class MayKnowViewHolder extends MapViewHolder<SquareMayKnowItem> implements View.OnClickListener, View.OnLongClickListener {
    private static final String TAG = "MayKnowViewHolder";
    private final VasSquareItemMayKnowBinding binding;
    private final IReporter reporter;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MayKnowViewHolder(VasSquareItemMayKnowBinding binding) {
        super(r0);
        Intrinsics.checkNotNullParameter(binding, "binding");
        LinearLayout mContainer = binding.getMContainer();
        Intrinsics.checkNotNullExpressionValue(mContainer, "binding.root");
        this.binding = binding;
        this.reporter = Square.INSTANCE.getConfig().getReporter();
    }

    private final void bindAvatar(SquareMayKnowItem data) {
        String maleUrl;
        if (data.getGender() == Gender.FEMALE.ordinal()) {
            maleUrl = data.getFemaleUrl();
        } else {
            maleUrl = data.getMaleUrl();
        }
        if (RegexUtils.isValidUrl$default(RegexUtils.INSTANCE, maleUrl, false, 2, null)) {
            this.binding.squareMayKnowEntrance.setImageDrawable(URLDrawable.getDrawable(maleUrl, SquareUtil.getUrlDrawableOptions$default(SquareUtil.INSTANCE, null, null, 3, null)));
            SquareImageView squareImageView = this.binding.squareMayKnowEntrance;
            Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.squareMayKnowEntrance");
            squareImageView.getLayoutParams().width = data.getLocation().getWidth();
            SquareImageView squareImageView2 = this.binding.squareMayKnowEntrance;
            Intrinsics.checkNotNullExpressionValue(squareImageView2, "binding.squareMayKnowEntrance");
            squareImageView2.getLayoutParams().height = data.getLocation().getHeight();
        }
    }

    private final void bindLabels(SquareMayKnowItem data) {
        Integer valueOf;
        boolean isBlank;
        this.binding.squareMayKnowLabelContainer.removeAllViews();
        int gender = data.getGender();
        String str = null;
        if (gender == Gender.MALE.ordinal()) {
            valueOf = Integer.valueOf(R.drawable.f159813ia2);
        } else {
            valueOf = gender == Gender.FEMALE.ordinal() ? Integer.valueOf(R.drawable.i9o) : null;
        }
        if (data.getAge() != 0) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(data.getAge());
            sb5.append('\u5c81');
            str = sb5.toString();
        }
        if (valueOf != null && str != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                SquareTabLayout squareTabLayout = this.binding.squareMayKnowLabelContainer;
                View itemView = this.itemView;
                Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                Context context = itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
                SquareMayKnowLabelView squareMayKnowLabelView = new SquareMayKnowLabelView(context);
                squareMayKnowLabelView.updateView(str, valueOf, ViewExtensionsKt.dip(squareMayKnowLabelView.getContext(), 2));
                Unit unit = Unit.INSTANCE;
                squareTabLayout.addView(squareMayKnowLabelView);
            }
        }
        for (MayKnowLabel mayKnowLabel : data.getLabels()) {
            SquareTabLayout squareTabLayout2 = this.binding.squareMayKnowLabelContainer;
            View itemView2 = this.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView2, "itemView");
            Context context2 = itemView2.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "itemView.context");
            SquareMayKnowLabelView squareMayKnowLabelView2 = new SquareMayKnowLabelView(context2);
            String name = mayKnowLabel.getName();
            View itemView3 = this.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView3, "itemView");
            SquareMayKnowLabelView.updateView$default(squareMayKnowLabelView2, name, null, ViewExtensionsKt.dip(itemView3.getContext(), 2), 2, null);
            Unit unit2 = Unit.INSTANCE;
            squareTabLayout2.addView(squareMayKnowLabelView2);
        }
    }

    private final void bindReport() {
        IReporter iReporter = this.reporter;
        LinearLayout mContainer = this.binding.getMContainer();
        Intrinsics.checkNotNullExpressionValue(mContainer, "binding.root");
        iReporter.setElementInfo(mContainer, SquareReportConst.ElementId.ELEMENT_ID_MAY_KNOW_ENTRANCE, new LinkedHashMap(), false, false);
        this.reporter.reportEvent("imp", new LinkedHashMap());
    }

    private final void resizeAvatar(Location location) {
        SquareImageView squareImageView = this.binding.squareMayKnowEntrance;
        Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.squareMayKnowEntrance");
        ViewGroup.LayoutParams layoutParams = squareImageView.getLayoutParams();
        if (layoutParams == null) {
            View itemView = this.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            layoutParams = new LinearLayout.LayoutParams(itemView.getContext(), (AttributeSet) null);
        }
        layoutParams.width = location.getWidth();
        layoutParams.height = location.getHeight();
        SquareImageView squareImageView2 = this.binding.squareMayKnowEntrance;
        Intrinsics.checkNotNullExpressionValue(squareImageView2, "binding.squareMayKnowEntrance");
        squareImageView2.setLayoutParams(layoutParams);
    }

    public final VasSquareItemMayKnowBinding getBinding() {
        return this.binding;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        IMapViewListener listener;
        MapItemController controller = getController();
        if (controller != null && (listener = controller.getListener()) != null) {
            IMapViewListener.DefaultImpls.onItemClicked$default(listener, this, getIndex(), getData(), 7, null, 16, null);
        }
        if (v3 != null) {
            this.reporter.reportEvent("clck", v3, new LinkedHashMap());
        }
    }

    @Override // com.tencent.state.map.MapViewHolder
    public void onFirstScreenCompleted(MapItem data, int index) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View v3) {
        IMapViewListener listener;
        MapItemController controller = getController();
        if (controller == null || (listener = controller.getListener()) == null) {
            return true;
        }
        listener.onItemLongClick(this, getIndex(), getData(), 7);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.state.map.MapViewHolder
    public void doBind(SquareMayKnowItem data, int index) {
        Intrinsics.checkNotNullParameter(data, "data");
        resizeAvatar(data.getLocation());
        bindAvatar(data);
        bindLabels(data);
        bindReason(data.getReason());
        this.binding.getMContainer().setOnClickListener(this);
        this.binding.getMContainer().setOnLongClickListener(this);
        bindReport();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.state.map.MapViewHolder
    public SquareMayKnowItem transform(MapItem data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (!(data instanceof SquareMayKnowItem)) {
            data = null;
        }
        return (SquareMayKnowItem) data;
    }

    private final void bindReason(String reason) {
        if (reason == null || reason.length() == 0) {
            TextView textView = this.binding.squareMayKnowReason;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.squareMayKnowReason");
            textView.setVisibility(8);
        } else {
            TextView textView2 = this.binding.squareMayKnowReason;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.squareMayKnowReason");
            textView2.setVisibility(0);
            TextView textView3 = this.binding.squareMayKnowReason;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.squareMayKnowReason");
            textView3.setText(reason);
        }
    }
}
