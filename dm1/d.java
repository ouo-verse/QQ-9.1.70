package dm1;

import androidx.viewbinding.ViewBinding;
import com.tencent.input.base.mvicompat.f;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.mvvm.BaseVB;
import com.tencent.mvi.mvvm.BaseVM;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0014\b\u0000\u0010\u0002*\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00012\u00020\u0003:\u0003\u001d\u0007\u0015J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0011\u0010\b\u001a\u0004\u0018\u00018\u0000H&\u00a2\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\n\u0010\tJ4\u0010\u0013\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\u00120\u00112\u001c\u0010\u0010\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\u000bj\u0002`\u000fH&R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00148&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00188&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001c8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006 "}, d2 = {"Ldm1/d;", "Lcom/tencent/mvi/mvvm/BaseVB;", "VB", "", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroidx/viewbinding/ViewBinding;", "b", "d", "()Lcom/tencent/mvi/mvvm/BaseVB;", "f", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "Lcom/tencent/mvi/api/runtime/b;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/GenericBaseVM;", "vm", "", "Lcom/tencent/input/base/mvicompat/f;", "g", "Ldm1/d$a;", "c", "()Ldm1/d$a;", "firstLayer", "Ldm1/d$c;", "e", "()Ldm1/d$c;", "secondLayer", "Ldm1/d$b;", "a", "()Ldm1/d$b;", "rootLayerBlueprint", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface d<VB extends BaseVB<?, ?, ?>> {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\bf\u0018\u0000*\u0014\b\u0001\u0010\u0002*\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00012\u00020\u0003J\u001e\u0010\u0007\u001a\u0018\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00010\u0004j\b\u0012\u0004\u0012\u00028\u0001`\u0006H&J\"\u0010\b\u001a\u001c\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00028\u0001\u0018\u0001`\u0006H&J$\u0010\n\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00010\u0004j\b\u0012\u0004\u0012\u00028\u0001`\u00060\tH&R\u0014\u0010\u000e\u001a\u00020\u000b8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\r\u00a8\u0006\u000f"}, d2 = {"Ldm1/d$a;", "Lcom/tencent/mvi/mvvm/BaseVB;", "VB", "Ldm1/e;", "Lkotlin/Pair;", "", "Lcom/tencent/mobileqq/guild/feed/nativepublish/factory/ChildVBNode;", "c", "e", "", "a", "", "b", "()[I", "sequencesOfVBs", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface a<VB extends BaseVB<?, ?, ?>> extends e {
        @NotNull
        List<Pair<Integer, VB>> a();

        @NotNull
        int[] b();

        @NotNull
        Pair<Integer, VB> c();

        @Nullable
        Pair<Integer, VB> e();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0014\b\u0001\u0010\u0002*\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00012\u00020\u0003J\u000f\u0010\u0004\u001a\u00028\u0001H&\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\t\u001a\u00020\u00068&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\n"}, d2 = {"Ldm1/d$b;", "Lcom/tencent/mvi/mvvm/BaseVB;", "VB", "", "b", "()Lcom/tencent/mvi/mvvm/BaseVB;", "Ldm1/e;", "a", "()Ldm1/e;", "contentLayerContainerBuilder", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface b<VB extends BaseVB<?, ?, ?>> {
        @NotNull
        e a();

        @NotNull
        VB b();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000*\u0014\b\u0001\u0010\u0002*\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00012\u00020\u0003J\u0011\u0010\u0004\u001a\u0004\u0018\u00018\u0001H&\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0006\u001a\u0004\u0018\u00018\u0001H&\u00a2\u0006\u0004\b\u0006\u0010\u0005J\u0011\u0010\u0007\u001a\u0004\u0018\u00018\u0001H&\u00a2\u0006\u0004\b\u0007\u0010\u0005\u00a8\u0006\b"}, d2 = {"Ldm1/d$c;", "Lcom/tencent/mvi/mvvm/BaseVB;", "VB", "Ldm1/e;", "buildTitleVB", "()Lcom/tencent/mvi/mvvm/BaseVB;", "f", "d", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface c<VB extends BaseVB<?, ?, ?>> extends e {
        @Nullable
        VB buildTitleVB();

        @Nullable
        VB d();

        @Nullable
        VB f();
    }

    @Nullable
    b<VB> a();

    @NotNull
    ViewBinding b(@NotNull com.tencent.mvi.api.help.a createViewParams);

    @NotNull
    a<VB> c();

    @Nullable
    VB d();

    @NotNull
    c<VB> e();

    @NotNull
    VB f();

    @NotNull
    List<f<? extends com.tencent.mvi.api.runtime.b>> g(@NotNull BaseVM<ol3.b, MviUIState, com.tencent.mvi.api.runtime.b> vm5);
}
