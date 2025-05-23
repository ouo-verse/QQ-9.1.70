package com.tencent.mobileqq.guild.feed.nativepublish.root;

import android.view.View;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.mvvm.BaseVB;
import dm1.d;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001j\u0002`\u0005B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J0\u0010\r\u001a\"\u0012\u001e\u0012\u001c\u0012\u0006\b\u0001\u0012\u00020\u0002\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001j\u0002`\f0\u000b2\u0006\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/root/e;", "Lcom/tencent/mvi/mvvm/BaseVB;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "Lcom/tencent/mvi/api/runtime/b;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/GenericBaseVB;", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "hostView", "", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/GenericChildBaseVB;", "initializeChildVB", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
final class e extends BaseVB<ol3.b, MviUIState, com.tencent.mvi.api.runtime.b> {
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<BaseVB<? extends ol3.b, ? extends MviUIState, com.tencent.mvi.api.runtime.b>> initializeChildVB(@NotNull View hostView) {
        dm1.d b16;
        List<BaseVB<? extends ol3.b, ? extends MviUIState, com.tencent.mvi.api.runtime.b>> emptyList;
        d.c e16;
        Intrinsics.checkNotNullParameter(hostView, "hostView");
        b16 = b.b(this);
        if (b16 == null || (e16 = b16.e()) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        LinkedList linkedList = new LinkedList();
        BaseVB buildTitleVB = e16.buildTitleVB();
        if (buildTitleVB != null) {
            linkedList.add(buildTitleVB);
        }
        BaseVB f16 = e16.f();
        if (f16 != null) {
            linkedList.add(f16);
        }
        BaseVB d16 = e16.d();
        if (d16 != null) {
            linkedList.add(d16);
            return linkedList;
        }
        return linkedList;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        dm1.d b16;
        d.c e16;
        View onCreateView;
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        b16 = b.b(this);
        if (b16 == null || (e16 = b16.e()) == null || (onCreateView = e16.onCreateView(createViewParams)) == null) {
            return createViewParams.b();
        }
        return onCreateView;
    }
}
