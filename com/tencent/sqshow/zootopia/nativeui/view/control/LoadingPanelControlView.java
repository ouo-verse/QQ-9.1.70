package com.tencent.sqshow.zootopia.nativeui.view.control;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.sqshow.zootopia.nativeui.view.AvatarPanelViewData;
import com.tencent.sqshow.zootopia.nativeui.view.control.LoadingPanelControlView;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010\u0003\u001a\u00020\u0002R$\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/control/LoadingPanelControlView;", "Lcom/tencent/sqshow/zootopia/nativeui/view/control/AvatarPanelControlView;", "", "l", "Ljava/util/ArrayList;", "Lcom/tencent/sqshow/zootopia/nativeui/view/AvatarPanelViewData;", "Lkotlin/collections/ArrayList;", "G", "Ljava/util/ArrayList;", "mLoadingFakeData", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class LoadingPanelControlView extends AvatarPanelControlView {

    /* renamed from: G, reason: from kotlin metadata */
    private final ArrayList<AvatarPanelViewData> mLoadingFakeData;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LoadingPanelControlView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(LoadingPanelControlView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.l();
    }

    public final void l() {
        AvatarPanelControlView.setData$default(this, this.mLoadingFakeData, null, false, true, 6, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LoadingPanelControlView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ LoadingPanelControlView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadingPanelControlView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        ArrayList<AvatarPanelViewData> arrayList = new ArrayList<>();
        this.mLoadingFakeData = arrayList;
        AvatarPanelViewData avatarPanelViewData = new AvatarPanelViewData("0", null, null, R.drawable.ied, true, "\u634f\u8138", 6, null);
        AvatarPanelViewData avatarPanelViewData2 = new AvatarPanelViewData("1", null, null, R.drawable.iec, true, "\u6362\u88c5", 6, null);
        AvatarPanelViewData avatarPanelViewData3 = new AvatarPanelViewData("2", null, null, R.drawable.ieb, true, "\u80cc\u5305", 6, null);
        arrayList.add(avatarPanelViewData);
        arrayList.add(avatarPanelViewData2);
        arrayList.add(avatarPanelViewData3);
        post(new Runnable() { // from class: ea4.b
            @Override // java.lang.Runnable
            public final void run() {
                LoadingPanelControlView.k(LoadingPanelControlView.this);
            }
        });
    }
}
