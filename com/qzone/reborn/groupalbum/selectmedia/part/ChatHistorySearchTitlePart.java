package com.qzone.reborn.groupalbum.selectmedia.part;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.qzone.reborn.base.k;
import com.qzone.reborn.groupalbum.selectmedia.viewmodel.ChatHistoryMediaViewModel;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016R\"\u0010\u0014\u001a\u00020\u000b8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u001c\u001a\u00020\u00158\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010 \u001a\u00020\u00158\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u0017\u001a\u0004\b\u001e\u0010\u0019\"\u0004\b\u001f\u0010\u001bR\u001b\u0010&\u001a\u00020!8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0018\u0010)\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006,"}, d2 = {"Lcom/qzone/reborn/groupalbum/selectmedia/part/ChatHistorySearchTitlePart;", "Lcom/qzone/reborn/base/k;", "", "K9", "", "state", "Q9", "Lbj/a;", "I9", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "d", "Landroid/view/View;", "F9", "()Landroid/view/View;", "N9", "(Landroid/view/View;)V", "backIcon", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "J9", "()Landroid/widget/TextView;", "P9", "(Landroid/widget/TextView;)V", "titleTv", "f", "H9", "O9", "rightTv", "Lcom/qzone/reborn/groupalbum/selectmedia/viewmodel/ChatHistoryMediaViewModel;", h.F, "Lkotlin/Lazy;", "G9", "()Lcom/qzone/reborn/groupalbum/selectmedia/viewmodel/ChatHistoryMediaViewModel;", "mediaSelectVm", "i", "Lbj/a;", "chatHistorySelectMediaIoc", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class ChatHistorySearchTitlePart extends k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public View backIcon;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public TextView titleTv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public TextView rightTv;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Lazy mediaSelectVm;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private bj.a chatHistorySelectMediaIoc;

    public ChatHistorySearchTitlePart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ChatHistoryMediaViewModel>() { // from class: com.qzone.reborn.groupalbum.selectmedia.part.ChatHistorySearchTitlePart$mediaSelectVm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ChatHistoryMediaViewModel invoke() {
                return (ChatHistoryMediaViewModel) ChatHistorySearchTitlePart.this.getViewModel(ChatHistoryMediaViewModel.class);
            }
        });
        this.mediaSelectVm = lazy;
    }

    private final bj.a I9() {
        if (this.chatHistorySelectMediaIoc == null) {
            this.chatHistorySelectMediaIoc = (bj.a) getIocInterface(bj.a.class);
        }
        return this.chatHistorySelectMediaIoc;
    }

    private final void K9() {
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
        LifecycleOwnerKt.getLifecycleScope(lifecycleOwner).launchWhenStarted(new ChatHistorySearchTitlePart$initStateObserver$1(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(ChatHistorySearchTitlePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            activity.onBackPressed();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(ChatHistorySearchTitlePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        bj.a I9 = this$0.I9();
        if (I9 != null) {
            I9.r8();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q9(boolean state) {
        H9().setClickable(state);
        TextView H9 = H9();
        H9.setTextColor(H9.getResources().getColorStateList(state ? R.color.qui_common_text_primary : R.color.qui_common_text_primary_pressed));
    }

    public final View F9() {
        View view = this.backIcon;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("backIcon");
        return null;
    }

    public final ChatHistoryMediaViewModel G9() {
        Object value = this.mediaSelectVm.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mediaSelectVm>(...)");
        return (ChatHistoryMediaViewModel) value;
    }

    public final TextView H9() {
        TextView textView = this.rightTv;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("rightTv");
        return null;
    }

    public final TextView J9() {
        TextView textView = this.titleTv;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("titleTv");
        return null;
    }

    public final void N9(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.backIcon = view;
    }

    public final void O9(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.rightTv = textView;
    }

    public final void P9(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.titleTv = textView;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "ChatHistorySearchTitlePart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        View findViewById = rootView.findViewById(R.id.lck);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.iv_message_back)");
        N9(findViewById);
        F9().setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.groupalbum.selectmedia.part.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChatHistorySearchTitlePart.L9(ChatHistorySearchTitlePart.this, view);
            }
        });
        View findViewById2 = rootView.findViewById(R.id.nja);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.tv_message_title)");
        P9((TextView) findViewById2);
        J9().setText(getContext().getString(R.string.f132994x));
        View findViewById3 = rootView.findViewById(R.id.njx);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.tv_right_text)");
        O9((TextView) findViewById3);
        H9().setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.groupalbum.selectmedia.part.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChatHistorySearchTitlePart.M9(ChatHistorySearchTitlePart.this, view);
            }
        });
        Q9(false);
        K9();
    }
}
