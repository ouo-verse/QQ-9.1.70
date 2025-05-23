package com.tencent.mobileqq.guild.homev2.parts;

import android.view.View;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/parts/GuildHomeV2BanPart;", "Lcom/tencent/mobileqq/guild/homev2/parts/a;", "", "initData", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "e", "Landroid/view/View;", "bannedContainer", "<init>", "()V", "f", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHomeV2BanPart extends a {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View bannedContainer;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void initData() {
        LiveData asLiveData$default = FlowLiveDataConversions.asLiveData$default(C9().P1(), (CoroutineContext) null, 0L, 3, (Object) null);
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final GuildHomeV2BanPart$initData$1 guildHomeV2BanPart$initData$1 = new GuildHomeV2BanPart$initData$1(this);
        asLiveData$default.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.homev2.parts.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildHomeV2BanPart.H9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        initData();
    }
}
