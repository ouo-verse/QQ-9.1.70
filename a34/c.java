package a34;

import a34.a;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00192\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001c\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0016J&\u0010\u0012\u001a\u00020\u00112\b\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016R\u0014\u0010\u0016\u001a\u00020\u00138BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"La34/c;", "Lcom/tencent/aio/base/mvvm/a;", "La34/a;", "", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet$c;", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lcom/tencent/aio/api/runtime/a;", "createVM", "view", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "shareActionSheet", "", "w6", "Landroid/widget/FrameLayout;", "d1", "()Landroid/widget/FrameLayout;", "mShareSelectBarContainer", "<init>", "()V", "d", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class c extends com.tencent.aio.base.mvvm.a<a, Object> implements ShareActionSheet.c {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void c1(c this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(a.C0009a.f25436d);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final FrameLayout d1() {
        FrameLayout frameLayout = new FrameLayout(getMContext());
        frameLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
        param.context = getMContext();
        com.tencent.robot.aio.share.c cVar = new com.tencent.robot.aio.share.c(param);
        cVar.setItemClickListenerV3(this);
        cVar.setClickCancelBtnListener(new View.OnClickListener() { // from class: a34.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.c1(c.this, view);
            }
        });
        View o06 = cVar.o0();
        if (o06 != null) {
            frameLayout.addView(o06);
        }
        return frameLayout;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    public BaseVM<a, Object, com.tencent.aio.api.runtime.a> createVM() {
        return new d();
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        return d1();
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.c
    public void w6(@Nullable View view, @Nullable ShareActionSheetBuilder.ActionSheetItem item, @Nullable ShareActionSheet shareActionSheet) {
        if (item != null) {
            sendIntent(new a.OnShareItemClick(item));
        }
    }
}
