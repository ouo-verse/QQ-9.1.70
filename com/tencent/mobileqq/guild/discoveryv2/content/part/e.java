package com.tencent.mobileqq.guild.discoveryv2.content.part;

import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.PlayableManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/part/e;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/part/MVPFeedsPart;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "", "e", "I", "rvId", "Landroidx/recyclerview/widget/RecyclerView;", "f", "Landroidx/recyclerview/widget/RecyclerView;", "rv", "<init>", "(I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class e extends MVPFeedsPart {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int rvId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RecyclerView rv;

    public e(int i3) {
        this.rvId = i3;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        RecyclerView recyclerView;
        PlayableManager playableManager;
        if (rootView == null || (recyclerView = (RecyclerView) rootView.findViewById(this.rvId)) == null) {
            return;
        }
        this.rv = recyclerView;
        com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.c g16 = x9().g();
        RecyclerView recyclerView2 = null;
        if (g16 instanceof PlayableManager) {
            playableManager = (PlayableManager) g16;
        } else {
            playableManager = null;
        }
        if (playableManager != null) {
            Lifecycle lifecycle = d.a(this).getLifecycle();
            Intrinsics.checkNotNullExpressionValue(lifecycle, "hostLifecycleOwner.lifecycle");
            RecyclerView recyclerView3 = this.rv;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rv");
            } else {
                recyclerView2 = recyclerView3;
            }
            playableManager.j(lifecycle, recyclerView2);
        }
    }

    public /* synthetic */ e(int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? R.id.uiw : i3);
    }
}
