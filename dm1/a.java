package dm1;

import com.tencent.input.base.mvicompat.f;
import com.tencent.mobileqq.guild.feed.nativepublish.content.monitor.FeedEditorRestrictionSupervisorVMDelegate;
import com.tencent.mobileqq.guild.feed.nativepublish.publish.FeedEditorMediaUploadTaskQueueVMDelegate;
import com.tencent.mobileqq.guild.feed.nativepublish.publish.PublishFeedInterceptorVMDelegate;
import com.tencent.mobileqq.guild.feed.nativepublish.publish.PublishFeedVMDelegate;
import com.tencent.mobileqq.guild.feed.nativepublish.usecase.FeedEditorContentVMDelegate;
import com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.FeedEditorDraftUseCaseVMDelegate;
import com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.FeedEditorInitUseCaseVMDelegate;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.mvvm.BaseVB;
import com.tencent.mvi.mvvm.BaseVM;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 \u00122,\u0012(\u0012&\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u00050\u0002j\n\u0012\u0002\b\u0003\u0012\u0002\b\u0003`\u00060\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J4\u0010\u000f\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\n0\u000e0\r2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007j\u0002`\u000bH\u0016\u00a8\u0006\u0013"}, d2 = {"Ldm1/a;", "Ldm1/d;", "Lcom/tencent/mvi/mvvm/BaseVB;", "Lcom/tencent/base/api/runtime/a;", "Lzl1/a;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/FeedEditorContext;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/EditorBaseVB;", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "Lcom/tencent/mvi/api/runtime/b;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/GenericBaseVM;", "vm", "", "Lcom/tencent/input/base/mvicompat/f;", "g", "<init>", "()V", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class a implements d<BaseVB<?, ?, com.tencent.base.api.runtime.a<zl1.a>>> {
    @Override // dm1.d
    @NotNull
    public List<f<? extends com.tencent.mvi.api.runtime.b>> g(@NotNull BaseVM<ol3.b, MviUIState, com.tencent.mvi.api.runtime.b> vm5) {
        List<f<? extends com.tencent.mvi.api.runtime.b>> listOf;
        Intrinsics.checkNotNullParameter(vm5, "vm");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new f[]{new com.tencent.mobileqq.guild.feed.nativepublish.root.c(), new FeedEditorDraftUseCaseVMDelegate(vm5), new PublishFeedVMDelegate(), new FeedEditorMediaUploadTaskQueueVMDelegate(), new PublishFeedInterceptorVMDelegate(), new FeedEditorContentVMDelegate(null, 1, null), new FeedEditorRestrictionSupervisorVMDelegate(null, null, 3, null), new FeedEditorInitUseCaseVMDelegate(vm5), new com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.d()});
        return listOf;
    }
}
