package com.tencent.state.square.bubblesetting;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.state.service.ZTPSquareRewardService;
import com.tencent.state.square.SquareUtil;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.databinding.VasSquareBubbleSettingPannelBinding;
import com.tencent.state.square.tasks.SquareTaskSheet;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mt4.i;
import mt4.k;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0003J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/state/square/bubblesetting/BubbleSettingSheet;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "adapter", "Lcom/tencent/state/square/bubblesetting/BubbleAdapter;", "binding", "Lcom/tencent/state/square/databinding/VasSquareBubbleSettingPannelBinding;", "initBubbleList", "", "initWindow", "onWindowFocusChanged", "hasFocus", "", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class BubbleSettingSheet extends Dialog {
    private static final double MAX_HEIGHT_RATIO = 0.84d;
    private static final String TAG = "BubbleSettingSheet";
    private BubbleAdapter adapter;
    private VasSquareBubbleSettingPannelBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BubbleSettingSheet(Context context) {
        super(context, R.style.f243250a);
        Intrinsics.checkNotNullParameter(context, "context");
        VasSquareBubbleSettingPannelBinding inflate = VasSquareBubbleSettingPannelBinding.inflate(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareBubbleSettingPa\u2026utInflater.from(context))");
        this.binding = inflate;
        this.adapter = new BubbleAdapter();
        setContentView(this.binding.getMRv());
        initWindow();
        initBubbleList();
        this.binding.close.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.bubblesetting.BubbleSettingSheet.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BubbleSettingSheet.this.dismiss();
            }
        });
    }

    private final void initBubbleList() {
        final WeakReference weakReference = new WeakReference(this);
        this.adapter.setOnGetMoreEffect(new Function0<Unit>() { // from class: com.tencent.state.square.bubblesetting.BubbleSettingSheet$initBubbleList$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                BubbleSettingSheet it = (BubbleSettingSheet) weakReference.get();
                if (it != null) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    Context context = it.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "it.context");
                    new SquareTaskSheet(context, 0).show();
                }
                BubbleSettingSheet bubbleSettingSheet = (BubbleSettingSheet) weakReference.get();
                if (bubbleSettingSheet != null) {
                    bubbleSettingSheet.dismiss();
                }
            }
        });
        RecyclerView recyclerView = this.binding.bubbleList;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.bubbleList");
        recyclerView.setAdapter(this.adapter);
        RecyclerView recyclerView2 = this.binding.bubbleList;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.bubbleList");
        recyclerView2.setLayoutManager(new GridLayoutManager(getContext(), 3, 1, false));
        this.binding.bubbleList.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.tencent.state.square.bubblesetting.BubbleSettingSheet$initBubbleList$2
            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                Intrinsics.checkNotNullParameter(outRect, "outRect");
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(parent, "parent");
                Intrinsics.checkNotNullParameter(state, "state");
                int childAdapterPosition = parent.getChildAdapterPosition(view) % 3;
                if (childAdapterPosition == 0) {
                    outRect.left = ViewExtensionsKt.dip(parent.getContext(), 15);
                    outRect.right = 0;
                } else if (childAdapterPosition == 1) {
                    outRect.left = ViewExtensionsKt.dip(parent.getContext(), 10);
                    outRect.right = ViewExtensionsKt.dip(parent.getContext(), 10);
                } else {
                    if (childAdapterPosition != 2) {
                        return;
                    }
                    outRect.left = 0;
                    outRect.right = ViewExtensionsKt.dip(parent.getContext(), 15);
                }
            }
        });
        ZTPSquareRewardService.INSTANCE.getSkins(new int[]{3}, new Function1<i, Unit>() { // from class: com.tencent.state.square.bubblesetting.BubbleSettingSheet$initBubbleList$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(i iVar) {
                invoke2(iVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(i iVar) {
                k kVar;
                BubbleAdapter bubbleAdapter;
                BubbleAdapter bubbleAdapter2;
                k[] kVarArr;
                Object orNull;
                if (iVar == null || (kVarArr = iVar.f417587a) == null) {
                    kVar = null;
                } else {
                    orNull = ArraysKt___ArraysKt.getOrNull(kVarArr, 0);
                    kVar = (k) orNull;
                }
                if (kVar != null) {
                    bubbleAdapter = BubbleSettingSheet.this.adapter;
                    bubbleAdapter.setSkinGroup(SquareBubbleSkinKt.parse(kVar));
                    bubbleAdapter2 = BubbleSettingSheet.this.adapter;
                    bubbleAdapter2.notifyDataSetChanged();
                }
            }
        });
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean hasFocus) {
        WindowManager.LayoutParams attributes;
        View decorView;
        Window window = getWindow();
        if (window != null) {
            window.setGravity(80);
        }
        Window window2 = getWindow();
        if (window2 == null || (attributes = window2.getAttributes()) == null) {
            return;
        }
        attributes.width = SquareUtil.getScreenWidth$default(SquareUtil.INSTANCE, 0.0f, 1, null);
        if (!hasFocus) {
            attributes.height = -2;
        } else {
            double screenHeight$default = SquareUtil.getScreenHeight$default(r1, 0.0f, 1, null) * MAX_HEIGHT_RATIO;
            Window window3 = getWindow();
            if (window3 == null || (decorView = window3.getDecorView()) == null) {
                return;
            }
            if (decorView.getHeight() >= screenHeight$default) {
                attributes.height = (int) screenHeight$default;
            }
        }
        Window window4 = getWindow();
        if (window4 != null) {
            window4.setAttributes(attributes);
        }
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
