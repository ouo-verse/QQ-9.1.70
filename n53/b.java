package n53;

import android.view.View;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.wink.aiavatar.mainpage.view.WinkAIAvatarGroupLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a8\u0006\f"}, d2 = {"Ln53/b;", "Lcom/tencent/mobileqq/ai/b;", "", "parentCategoryId", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "subCategory", "", "o", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b extends com.tencent.mobileqq.ai.b {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(b this$0, String str, MetaCategory metaCategory) {
        WinkAIAvatarGroupLayout winkAIAvatarGroupLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View view = this$0.itemView;
        if (view instanceof WinkAIAvatarGroupLayout) {
            winkAIAvatarGroupLayout = (WinkAIAvatarGroupLayout) view;
        } else {
            winkAIAvatarGroupLayout = null;
        }
        if (winkAIAvatarGroupLayout != null) {
            winkAIAvatarGroupLayout.e(str, metaCategory);
        }
    }

    public final void o(@Nullable final String parentCategoryId, @Nullable final MetaCategory subCategory) {
        if (subCategory != null) {
            ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: n53.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.p(b.this, parentCategoryId, subCategory);
                }
            });
        }
    }
}
