package com.tencent.state.square.chatland.setting;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.state.service.ZTPSquareRewardService;
import com.tencent.state.square.SquareUtil;
import com.tencent.state.square.bubblesetting.SquareBubbleSkinKt;
import com.tencent.state.square.chatland.setting.ChatLandSettingAdapter;
import com.tencent.state.square.chatland.setting.ChatLandSettingSheet;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0003J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0010\u001a\u00020\u000eH\u0002J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/state/square/chatland/setting/ChatLandSettingSheet;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "source", "", "(Landroid/content/Context;I)V", "adapter", "Lcom/tencent/state/square/chatland/setting/ChatLandSettingAdapter;", "binding", "Lcom/tencent/state/square/databinding/VasSquareBubbleSettingPannelBinding;", "getSource", "()I", "fetchChatLandSkins", "", "initBubbleList", "initWindow", "onWindowFocusChanged", "hasFocus", "", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ChatLandSettingSheet extends Dialog {
    private static final float MAX_HEIGHT_RATIO = 0.84f;
    private static final String TAG = "ChatLandSettingSheet";
    private ChatLandSettingAdapter adapter;
    private VasSquareBubbleSettingPannelBinding binding;
    private final int source;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[ChatLandSettingAdapter.ViewHolderType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[ChatLandSettingAdapter.ViewHolderType.TITLE.ordinal()] = 1;
            int[] iArr2 = new int[ChatLandSettingAdapter.ViewHolderType.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[ChatLandSettingAdapter.ViewHolderType.ITEM.ordinal()] = 1;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatLandSettingSheet(Context context, int i3) {
        super(context, R.style.f243250a);
        Intrinsics.checkNotNullParameter(context, "context");
        this.source = i3;
        VasSquareBubbleSettingPannelBinding inflate = VasSquareBubbleSettingPannelBinding.inflate(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareBubbleSettingPa\u2026utInflater.from(context))");
        this.binding = inflate;
        this.adapter = new ChatLandSettingAdapter();
        setContentView(this.binding.getMContainer());
        TextView textView = this.binding.title;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.title");
        textView.setText("\u804a\u5929\u5730\u5757\u8bbe\u7f6e");
        this.binding.close.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.chatland.setting.ChatLandSettingSheet.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChatLandSettingSheet.this.dismiss();
            }
        });
        initWindow();
        initBubbleList();
        fetchChatLandSkins();
    }

    private final void fetchChatLandSkins() {
        ZTPSquareRewardService.INSTANCE.getSkins(new int[]{1, 2}, new Function1<i, Unit>() { // from class: com.tencent.state.square.chatland.setting.ChatLandSettingSheet$fetchChatLandSkins$1
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
                ChatLandSettingAdapter chatLandSettingAdapter;
                ChatLandSettingAdapter chatLandSettingAdapter2;
                k[] kVarArr;
                Object orNull;
                ChatLandSettingAdapter chatLandSettingAdapter3;
                k[] kVarArr2;
                Object orNull2;
                k kVar2 = null;
                if (iVar == null || (kVarArr2 = iVar.f417587a) == null) {
                    kVar = null;
                } else {
                    orNull2 = ArraysKt___ArraysKt.getOrNull(kVarArr2, 0);
                    kVar = (k) orNull2;
                }
                if (kVar != null) {
                    chatLandSettingAdapter3 = ChatLandSettingSheet.this.adapter;
                    chatLandSettingAdapter3.setBroadcastSkinGroup(SquareBubbleSkinKt.parse(kVar));
                }
                if (iVar != null && (kVarArr = iVar.f417587a) != null) {
                    orNull = ArraysKt___ArraysKt.getOrNull(kVarArr, 1);
                    kVar2 = (k) orNull;
                }
                if (kVar2 != null) {
                    chatLandSettingAdapter2 = ChatLandSettingSheet.this.adapter;
                    chatLandSettingAdapter2.setFocusSkinGroup(SquareBubbleSkinKt.parse(kVar2));
                }
                chatLandSettingAdapter = ChatLandSettingSheet.this.adapter;
                chatLandSettingAdapter.notifyDataSetChanged();
            }
        });
    }

    private final void initBubbleList() {
        final WeakReference weakReference = new WeakReference(this);
        this.adapter.setOnGetMoreEffect(new Function0<Unit>() { // from class: com.tencent.state.square.chatland.setting.ChatLandSettingSheet$initBubbleList$1
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
                ChatLandSettingSheet it = (ChatLandSettingSheet) weakReference.get();
                if (it != null) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    Context context = it.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "it.context");
                    new SquareTaskSheet(context, ChatLandSettingSheet.this.getSource()).show();
                }
                ChatLandSettingSheet chatLandSettingSheet = (ChatLandSettingSheet) weakReference.get();
                if (chatLandSettingSheet != null) {
                    chatLandSettingSheet.dismiss();
                }
            }
        });
        RecyclerView recyclerView = this.binding.bubbleList;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.bubbleList");
        recyclerView.setAdapter(this.adapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.tencent.state.square.chatland.setting.ChatLandSettingSheet$initBubbleList$2
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int position) {
                ChatLandSettingAdapter chatLandSettingAdapter;
                ChatLandSettingAdapter.ViewHolderType.Companion companion = ChatLandSettingAdapter.ViewHolderType.INSTANCE;
                chatLandSettingAdapter = ChatLandSettingSheet.this.adapter;
                return ChatLandSettingSheet.WhenMappings.$EnumSwitchMapping$0[companion.fromInt(chatLandSettingAdapter.getItemViewType(position)).ordinal()] != 1 ? 1 : 3;
            }
        });
        RecyclerView recyclerView2 = this.binding.bubbleList;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.bubbleList");
        recyclerView2.setLayoutManager(gridLayoutManager);
        this.binding.bubbleList.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.tencent.state.square.chatland.setting.ChatLandSettingSheet$initBubbleList$3
            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                ChatLandSettingAdapter chatLandSettingAdapter;
                ChatLandSettingAdapter chatLandSettingAdapter2;
                Intrinsics.checkNotNullParameter(outRect, "outRect");
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(parent, "parent");
                Intrinsics.checkNotNullParameter(state, "state");
                int childAdapterPosition = parent.getChildAdapterPosition(view);
                ChatLandSettingAdapter.ViewHolderType.Companion companion = ChatLandSettingAdapter.ViewHolderType.INSTANCE;
                RecyclerView.Adapter adapter = parent.getAdapter();
                if (ChatLandSettingSheet.WhenMappings.$EnumSwitchMapping$1[companion.fromInt(adapter != null ? adapter.getItemViewType(childAdapterPosition) : 0).ordinal()] == 1) {
                    int i3 = childAdapterPosition - 1;
                    chatLandSettingAdapter = ChatLandSettingSheet.this.adapter;
                    if (childAdapterPosition > chatLandSettingAdapter.getBroadcastSkinGroup().getSkins().size()) {
                        chatLandSettingAdapter2 = ChatLandSettingSheet.this.adapter;
                        i3 = (childAdapterPosition - 2) - chatLandSettingAdapter2.getBroadcastSkinGroup().getSkins().size();
                    }
                    int i16 = i3 % 3;
                    if (i16 == 0) {
                        outRect.left = ViewExtensionsKt.dip(parent.getContext(), 15);
                        outRect.right = 0;
                        return;
                    } else if (i16 == 1) {
                        outRect.left = ViewExtensionsKt.dip(parent.getContext(), 10);
                        outRect.right = ViewExtensionsKt.dip(parent.getContext(), 10);
                        return;
                    } else {
                        if (i16 != 2) {
                            return;
                        }
                        outRect.left = 0;
                        outRect.right = ViewExtensionsKt.dip(parent.getContext(), 15);
                        return;
                    }
                }
                outRect.left = ViewExtensionsKt.dip(parent.getContext(), 15);
                outRect.right = ViewExtensionsKt.dip(parent.getContext(), 15);
            }
        });
    }

    public final int getSource() {
        return this.source;
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
            float screenHeight$default = SquareUtil.getScreenHeight$default(r1, 0.0f, 1, null) * MAX_HEIGHT_RATIO;
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
