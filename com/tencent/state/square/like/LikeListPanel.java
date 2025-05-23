package com.tencent.state.square.like;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.state.square.SquareUtil;
import com.tencent.state.square.databinding.VasSquareLikeListPanelBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/state/square/like/LikeListPanel;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "adapter", "Lcom/tencent/state/square/like/LikeListAdapter;", "binding", "Lcom/tencent/state/square/databinding/VasSquareLikeListPanelBinding;", "initRecycle", "", "initWindow", "setData", "likeListInfo", "Lcom/tencent/state/square/like/LikeListInfo;", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class LikeListPanel extends Dialog {
    private static final String TAG = "LikeListPanel";
    private final LikeListAdapter adapter;
    private final VasSquareLikeListPanelBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LikeListPanel(Context context) {
        super(context, R.style.f243250a);
        Intrinsics.checkNotNullParameter(context, "context");
        this.adapter = new LikeListAdapter();
        VasSquareLikeListPanelBinding inflate = VasSquareLikeListPanelBinding.inflate(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareLikeListPanelBi\u2026utInflater.from(context))");
        this.binding = inflate;
        setContentView(inflate.getMRv());
        inflate.vasSquareLikeListPanelDragIcon.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.like.LikeListPanel.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LikeListPanel.this.dismiss();
            }
        });
        initWindow();
        initRecycle();
    }

    private final void initRecycle() {
        RecyclerView recyclerView = this.binding.list;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.list");
        recyclerView.setAdapter(this.adapter);
        RecyclerView recyclerView2 = this.binding.list;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.list");
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
    }

    public final void setData(LikeListInfo likeListInfo) {
        Intrinsics.checkNotNullParameter(likeListInfo, "likeListInfo");
        this.adapter.setDataList(likeListInfo.getList());
    }

    private final void initWindow() {
        setCanceledOnTouchOutside(true);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(80);
        }
        Window window2 = getWindow();
        if (window2 != null) {
            window2.setLayout(SquareUtil.getScreenWidth$default(SquareUtil.INSTANCE, 0.0f, 1, null), -2);
        }
        Window window3 = getWindow();
        if (window3 != null) {
            window3.setWindowAnimations(R.style.f243260b);
        }
    }
}
