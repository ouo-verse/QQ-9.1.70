package com.tencent.state.utils;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.image.URLDrawable;
import com.tencent.state.SquareDebug;
import com.tencent.state.map.MapViewHolder;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.view.SquareImageView;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00040\nj\b\u0012\u0004\u0012\u00020\u0004`\u000bH\u0002J(\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\b2\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00040\nj\b\u0012\u0004\u0012\u00020\u0004`\u000bH\u0002J(\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00040\nj\b\u0012\u0004\u0012\u00020\u0004`\u000bH\u0002J\u001a\u0010\u0011\u001a\u00020\u00062\u0012\u0010\u0012\u001a\u000e\u0012\u0002\b\u0003\u0018\u00010\u0013j\u0004\u0018\u0001`\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/state/utils/ViewHolderRecycleChecker;", "", "()V", "TAG", "", "checkChildren", "", Node.CHILDREN_ATTR, "Landroid/view/View;", "resultList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "checkView", "view", "checkViewGroup", "viewGroup", "Landroid/view/ViewGroup;", "onHolderRecycle", "holder", "Lcom/tencent/state/map/MapViewHolder;", "Lcom/tencent/state/map/ViewHolder;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ViewHolderRecycleChecker {
    public static final ViewHolderRecycleChecker INSTANCE = new ViewHolderRecycleChecker();
    private static final String TAG = "SquareDrawable_ViewHolderRecycleChecker";

    ViewHolderRecycleChecker() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkChildren(View children, ArrayList<String> resultList) {
        if (children instanceof ViewGroup) {
            checkViewGroup((ViewGroup) children, resultList);
        } else if (children instanceof View) {
            checkView(children, resultList);
        }
    }

    private final void checkView(View view, ArrayList<String> resultList) {
        if (view instanceof ImageView) {
            if (!(view instanceof SquareImageView)) {
                resultList.add("isNot SquareImageView:" + ViewUtils.INSTANCE.getViewName(view));
                return;
            }
            if (((SquareImageView) view).getDrawable() instanceof URLDrawable) {
                resultList.add("not recycle URLDrawable:" + ViewUtils.INSTANCE.getViewName(view));
            }
        }
    }

    private final void checkViewGroup(ViewGroup viewGroup, final ArrayList<String> resultList) {
        ViewExtensionsKt.forEachChild(viewGroup, new Function1<View, Unit>() { // from class: com.tencent.state.utils.ViewHolderRecycleChecker$checkViewGroup$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                ViewHolderRecycleChecker.INSTANCE.checkChildren(it, resultList);
            }
        });
    }

    /* JADX WARN: Type inference failed for: r5v5, types: [com.tencent.state.map.MapItem] */
    /* JADX WARN: Type inference failed for: r5v9, types: [com.tencent.state.map.MapItem] */
    public final void onHolderRecycle(MapViewHolder<?> holder) {
        View view;
        if (!SquareBaseKt.getSquareCommon().isDebugVersion() || !SquareDebug.INSTANCE.getDrawableMonitor() || holder == null || (view = holder.itemView) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView ?: return");
        ArrayList<String> arrayList = new ArrayList<>();
        checkChildren(view, arrayList);
        for (String str : arrayList) {
            SquareLogger squareLog = SquareBaseKt.getSquareLog();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("unbind, index:");
            sb5.append(Integer.valueOf(holder.getIndex()).intValue());
            sb5.append(", type:");
            ?? data = holder.getData();
            String str2 = null;
            sb5.append(data != 0 ? Integer.valueOf(data.getType()) : null);
            sb5.append(", uin:");
            ?? data2 = holder.getData();
            if (data2 != 0) {
                str2 = data2.getUin();
            }
            sb5.append(str2);
            sb5.append(", ");
            sb5.append(str);
            SquareLogger.DefaultImpls.e$default(squareLog, TAG, sb5.toString(), null, 4, null);
        }
    }
}
