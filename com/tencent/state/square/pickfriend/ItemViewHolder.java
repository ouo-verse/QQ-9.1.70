package com.tencent.state.square.pickfriend;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.databinding.VasSquarePickFriendItemBinding;
import com.tencent.state.square.pickfriend.service.PickFriendItemData;
import com.tencent.state.utils.FaceUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0002\u0018\u0000 \u00132\u00020\u00012\u00020\u0002:\u0001\u0013B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0016J\u0014\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u000bH\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/state/square/pickfriend/ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/state/square/pickfriend/IPickFriendItemViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "binding", "Lcom/tencent/state/square/databinding/VasSquarePickFriendItemBinding;", "currentData", "Lcom/tencent/state/square/pickfriend/service/PickFriendItemData;", "bind", "", "data", "getReportParams", "", "", "", "impEnd", "initReport", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
final class ItemViewHolder extends RecyclerView.ViewHolder implements IPickFriendItemViewHolder {
    private static final String FROM_SOURCE_GUIDE = "em_square_guide_bubble";
    private static final String TAG = "ItemViewHolder";
    private final VasSquarePickFriendItemBinding binding;
    private PickFriendItemData currentData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemViewHolder(View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        VasSquarePickFriendItemBinding bind = VasSquarePickFriendItemBinding.bind(view);
        Intrinsics.checkNotNullExpressionValue(bind, "VasSquarePickFriendItemBinding.bind(view)");
        this.binding = bind;
    }

    private final void initReport() {
        IReporter squareReporter = SquareBaseKt.getSquareReporter();
        LinearLayout mRv = this.binding.getMRv();
        Intrinsics.checkNotNullExpressionValue(mRv, "binding.root");
        squareReporter.setElementInfo(mRv, SquareReportConst.ElementId.ELEMENT_EM_ZPLAN_FRIEND_RECOM, new LinkedHashMap(), false, false);
        SquareBaseKt.getSquareThread().postOnUiDelayed(500L, new Function0<Unit>() { // from class: com.tencent.state.square.pickfriend.ItemViewHolder$initReport$1
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
                VasSquarePickFriendItemBinding vasSquarePickFriendItemBinding;
                Map<String, Object> reportParams;
                IReporter squareReporter2 = SquareBaseKt.getSquareReporter();
                vasSquarePickFriendItemBinding = ItemViewHolder.this.binding;
                LinearLayout mRv2 = vasSquarePickFriendItemBinding.getMRv();
                Intrinsics.checkNotNullExpressionValue(mRv2, "binding.root");
                reportParams = ItemViewHolder.this.getReportParams();
                squareReporter2.reportEvent("imp", mRv2, reportParams);
            }
        });
    }

    @Override // com.tencent.state.square.pickfriend.IPickFriendItemViewHolder
    public void bind(final PickFriendItemData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.currentData = data;
        TextView textView = this.binding.pickFriendNickName;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.pickFriendNickName");
        textView.setText(data.getNickName());
        FaceUtils.INSTANCE.loadHeadIcon(Square.INSTANCE.getConfig().getObtainInstanceHelper().getFaceDecoder(), this.binding.pickFriendHeader, data.getUin(), false, new Function1<String, Boolean>() { // from class: com.tencent.state.square.pickfriend.ItemViewHolder$bind$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(String str) {
                return Boolean.valueOf(invoke2(str));
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2(String str) {
                return TextUtils.equals(str, PickFriendItemData.this.getUin());
            }
        });
        this.binding.getMRv().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.pickfriend.ItemViewHolder$bind$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VasSquarePickFriendItemBinding vasSquarePickFriendItemBinding;
                Map<String, Object> reportParams;
                data.getAction().invoke(data.getUin());
                IReporter squareReporter = SquareBaseKt.getSquareReporter();
                vasSquarePickFriendItemBinding = ItemViewHolder.this.binding;
                LinearLayout mRv = vasSquarePickFriendItemBinding.getMRv();
                Intrinsics.checkNotNullExpressionValue(mRv, "binding.root");
                reportParams = ItemViewHolder.this.getReportParams();
                squareReporter.reportEvent("clck", mRv, reportParams);
            }
        });
        initReport();
    }

    @Override // com.tencent.state.square.pickfriend.IPickFriendItemViewHolder
    public void impEnd() {
        IReporter squareReporter = SquareBaseKt.getSquareReporter();
        LinearLayout mRv = this.binding.getMRv();
        Intrinsics.checkNotNullExpressionValue(mRv, "binding.root");
        squareReporter.reportEvent("imp_end", mRv, getReportParams());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, Object> getReportParams() {
        String str;
        Map<String, Object> mutableMapOf;
        Pair[] pairArr = new Pair[3];
        pairArr[0] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_FRIEND_POS, Integer.valueOf(getAdapterPosition()));
        PickFriendItemData pickFriendItemData = this.currentData;
        pairArr[1] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_RECOM_SOURCE, Integer.valueOf(Intrinsics.areEqual(pickFriendItemData != null ? pickFriendItemData.getRefSource() : null, FROM_SOURCE_GUIDE) ? 2 : 1));
        PickFriendItemData pickFriendItemData2 = this.currentData;
        if (pickFriendItemData2 == null || (str = pickFriendItemData2.getUin()) == null) {
            str = "";
        }
        pairArr[2] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_FRIEND_UIN, str);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        return mutableMapOf;
    }
}
