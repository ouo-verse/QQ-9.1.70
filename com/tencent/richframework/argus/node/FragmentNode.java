package com.tencent.richframework.argus.node;

import android.app.Application;
import android.content.res.Resources;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.util.RFWStringBuilderUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u000f\u001a\u00020\bH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\u000e\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/richframework/argus/node/FragmentNode;", "Lcom/tencent/richframework/argus/node/ArgusNode;", "Landroidx/fragment/app/Fragment;", "fragmentView", "Landroid/view/View;", "fragment", "(Landroid/view/View;Landroidx/fragment/app/Fragment;)V", "fragmentClassName", "", "fragmentId", "fragmentTag", "fragmentViewId", "isSelfVisible", "", "()Z", "toString", "lifecycle_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class FragmentNode extends ArgusNode<Fragment> {
    private final String fragmentClassName;
    private String fragmentId;
    private final String fragmentTag;
    private String fragmentViewId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentNode(@NotNull View fragmentView, @NotNull Fragment fragment) {
        super(fragmentView, fragment);
        int i3;
        Intrinsics.checkNotNullParameter(fragmentView, "fragmentView");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.fragmentClassName = getClassDesc(fragment);
        if (fragment.getId() != -1) {
            try {
                Application application = RFWApplication.getApplication();
                Intrinsics.checkNotNullExpressionValue(application, "RFWApplication.getApplication()");
                this.fragmentId = application.getResources().getResourceName(fragment.getId());
            } catch (Resources.NotFoundException unused) {
            }
        }
        View view = fragment.getView();
        if (view != null) {
            i3 = view.getId();
        } else {
            i3 = 0;
        }
        if (i3 != 0) {
            try {
                Application application2 = RFWApplication.getApplication();
                Intrinsics.checkNotNullExpressionValue(application2, "RFWApplication.getApplication()");
                this.fragmentViewId = application2.getResources().getResourceName(i3);
            } catch (Resources.NotFoundException unused2) {
            }
        }
        this.fragmentTag = fragment.getTag();
    }

    @Override // com.tencent.richframework.argus.node.ArgusNode
    public boolean isSelfVisible() {
        Fragment fragment = getContainerWrf().get();
        if (fragment != null && fragment.isVisible() && super.isSelfVisible()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.richframework.argus.node.ArgusNode
    @NotNull
    public String toString() {
        String string = RFWStringBuilderUtils.getString("FragmentNode(cls=", this.fragmentClassName, " fTag=", this.fragmentTag, " vId=", this.fragmentViewId, " fId=", this.fragmentId, " aTag=", getAnnotationTags());
        Intrinsics.checkNotNullExpressionValue(string, "RFWStringBuilderUtils.ge\u2026 annotationTags\n        )");
        return string;
    }
}
