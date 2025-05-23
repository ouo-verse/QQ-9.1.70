package dm1;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.guild.feed.nativepublish.edittext.GuildFeedEditTextVB;
import com.tencent.mobileqq.guild.feed.nativepublish.feature.FeedEditorDefaultBusinessImpl;
import com.tencent.mobileqq.guild.feed.nativepublish.feature.FeedEditorGlobalVB;
import com.tencent.mobileqq.guild.feed.nativepublish.feature.f;
import com.tencent.mobileqq.guild.feed.nativepublish.functionbar.GuildFeedSimplifiedPublishFunctionBarVB;
import com.tencent.mobileqq.guild.feed.nativepublish.mediapreview.GuildFeedPublishMediaPreviewVB;
import com.tencent.mobileqq.guild.feed.nativepublish.viewbinding.SimplifiedFeedEditorViewBinding;
import com.tencent.mvi.mvvm.BaseVB;
import dm1.b;
import dm1.d;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b#\u0010$J,\u0010\u0007\u001a&\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u00050\u0002j\n\u0012\u0002\b\u0003\u0012\u0002\b\u0003`\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J,\u0010\f\u001a&\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u00050\u0002j\n\u0012\u0002\b\u0003\u0012\u0002\b\u0003`\u0006H\u0016J,\u0010\r\u001a&\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u00050\u0002j\n\u0012\u0002\b\u0003\u0012\u0002\b\u0003`\u0006H\u0016R\u0016\u0010\u0010\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013RD\u0010\u0019\u001a,\u0012(\u0012&\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u00050\u0002j\n\u0012\u0002\b\u0003\u0012\u0002\b\u0003`\u00060\u00158\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018RD\u0010\u001e\u001a,\u0012(\u0012&\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u00050\u0002j\n\u0012\u0002\b\u0003\u0012\u0002\b\u0003`\u00060\u001a8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0012\u0010\u001dRD\u0010\"\u001a,\u0012(\u0012&\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u00050\u0002j\n\u0012\u0002\b\u0003\u0012\u0002\b\u0003`\u00060\u001f8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\f\u0010 \u001a\u0004\b\u001b\u0010!\u00a8\u0006%"}, d2 = {"Ldm1/b;", "Ldm1/a;", "Lcom/tencent/mvi/mvvm/BaseVB;", "Lcom/tencent/base/api/runtime/a;", "Lzl1/a;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/FeedEditorContext;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/EditorBaseVB;", "i", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroidx/viewbinding/ViewBinding;", "b", "f", "d", "Lcom/tencent/mobileqq/guild/feed/nativepublish/viewbinding/SimplifiedFeedEditorViewBinding;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/viewbinding/SimplifiedFeedEditorViewBinding;", "viewBinding", "Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/f;", "c", "Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/f;", "globalScope", "Ldm1/d$b;", "Ldm1/d$b;", "a", "()Ldm1/d$b;", "rootLayerBlueprint", "Ldm1/d$a;", "e", "Ldm1/d$a;", "()Ldm1/d$a;", "firstLayer", "Ldm1/d$c;", "Ldm1/d$c;", "()Ldm1/d$c;", "secondLayer", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b extends dm1.a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private SimplifiedFeedEditorViewBinding viewBinding;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f globalScope = new f();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d.b<BaseVB<?, ?, com.tencent.base.api.runtime.a<zl1.a>>> rootLayerBlueprint = new C10192b(this);

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d.a<BaseVB<?, ?, com.tencent.base.api.runtime.a<zl1.a>>> firstLayer = new a();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d.c<BaseVB<?, ?, com.tencent.base.api.runtime.a<zl1.a>>> secondLayer = new c();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000G\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002,\u0012(\u0012&\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u00050\u0002j\n\u0012\u0002\b\u0003\u0012\u0002\b\u0003`\u00060\u0001J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016JZ\u0010\u000e\u001aT\u0012\u0004\u0012\u00020\f\u0012\u001c\u0012\u001a\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u00050\u00020\u000bj,\u0012(\u0012&\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u00050\u0002j\n\u0012\u0002\b\u0003\u0012\u0002\b\u0003`\u0006`\rH\u0016JZ\u0010\u000f\u001aT\u0012\u0004\u0012\u00020\f\u0012\u001c\u0012\u001a\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u00050\u00020\u000bj,\u0012(\u0012&\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u00050\u0002j\n\u0012\u0002\b\u0003\u0012\u0002\b\u0003`\u0006`\rH\u0016J`\u0010\u0011\u001aZ\u0012V\u0012T\u0012\u0004\u0012\u00020\f\u0012\u001c\u0012\u001a\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u00050\u00020\u000bj,\u0012(\u0012&\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u00050\u0002j\n\u0012\u0002\b\u0003\u0012\u0002\b\u0003`\u0006`\r0\u0010H\u0016R\u001a\u0010\u0016\u001a\u00020\u00128\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0017"}, d2 = {"dm1/b$a", "Ldm1/d$a;", "Lcom/tencent/mvi/mvvm/BaseVB;", "Lcom/tencent/base/api/runtime/a;", "Lzl1/a;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/FeedEditorContext;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/EditorBaseVB;", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "Lkotlin/Pair;", "", "Lcom/tencent/mobileqq/guild/feed/nativepublish/factory/ChildVBNode;", "c", "e", "", "a", "", "[I", "b", "()[I", "sequencesOfVBs", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements d.a<BaseVB<?, ?, com.tencent.base.api.runtime.a<zl1.a>>> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final int[] sequencesOfVBs = new int[0];

        a() {
        }

        @Override // dm1.d.a
        @NotNull
        public List<Pair<Integer, BaseVB<?, ?, com.tencent.base.api.runtime.a<zl1.a>>>> a() {
            List<Pair<Integer, BaseVB<?, ?, com.tencent.base.api.runtime.a<zl1.a>>>> emptyList;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }

        @Override // dm1.d.a
        @NotNull
        /* renamed from: b, reason: from getter */
        public int[] getSequencesOfVBs() {
            return this.sequencesOfVBs;
        }

        @Override // dm1.d.a
        @NotNull
        public Pair<Integer, BaseVB<?, ?, com.tencent.base.api.runtime.a<zl1.a>>> c() {
            return TuplesKt.to(1, new GuildFeedEditTextVB(SimplifiedFeedEditorViewBinding.INSTANCE.e(), com.tencent.mobileqq.guild.feed.nativepublish.viewbinding.b.INSTANCE.b()));
        }

        @Override // dm1.d.a
        @NotNull
        public Pair<Integer, BaseVB<?, ?, com.tencent.base.api.runtime.a<zl1.a>>> e() {
            ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-1, -2);
            SimplifiedFeedEditorViewBinding.Companion companion = SimplifiedFeedEditorViewBinding.INSTANCE;
            layoutParams.topToBottom = companion.e();
            layoutParams.bottomToBottom = 0;
            return TuplesKt.to(2, new GuildFeedPublishMediaPreviewVB(companion.g(), layoutParams));
        }

        @Override // dm1.e
        @NotNull
        public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
            Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
            SimplifiedFeedEditorViewBinding simplifiedFeedEditorViewBinding = b.this.viewBinding;
            if (simplifiedFeedEditorViewBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                simplifiedFeedEditorViewBinding = null;
            }
            return simplifiedFeedEditorViewBinding.m(createViewParams.a());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002,\u0012(\u0012&\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u00050\u0002j\n\u0012\u0002\b\u0003\u0012\u0002\b\u0003`\u00060\u0001J,\u0010\u0007\u001a&\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u00050\u0002j\n\u0012\u0002\b\u0003\u0012\u0002\b\u0003`\u0006H\u0016R\u001a\u0010\f\u001a\u00020\b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\u00a8\u0006\r"}, d2 = {"dm1/b$b", "Ldm1/d$b;", "Lcom/tencent/mvi/mvvm/BaseVB;", "Lcom/tencent/base/api/runtime/a;", "Lzl1/a;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/FeedEditorContext;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/EditorBaseVB;", "b", "Ldm1/e;", "a", "Ldm1/e;", "()Ldm1/e;", "contentLayerContainerBuilder", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: dm1.b$b, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static final class C10192b implements d.b<BaseVB<?, ?, com.tencent.base.api.runtime.a<zl1.a>>> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final e contentLayerContainerBuilder;

        C10192b(final b bVar) {
            this.contentLayerContainerBuilder = new e() { // from class: dm1.c
                @Override // dm1.e
                public final View onCreateView(com.tencent.mvi.api.help.a aVar) {
                    View d16;
                    d16 = b.C10192b.d(b.this, aVar);
                    return d16;
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final View d(b this$0, com.tencent.mvi.api.help.a it) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(it, "it");
            SimplifiedFeedEditorViewBinding simplifiedFeedEditorViewBinding = this$0.viewBinding;
            if (simplifiedFeedEditorViewBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                simplifiedFeedEditorViewBinding = null;
            }
            return simplifiedFeedEditorViewBinding.getConstraintFixFrame();
        }

        @Override // dm1.d.b
        @NotNull
        /* renamed from: a, reason: from getter */
        public e getContentLayerContainerBuilder() {
            return this.contentLayerContainerBuilder;
        }

        @Override // dm1.d.b
        @NotNull
        public BaseVB<?, ?, com.tencent.base.api.runtime.a<zl1.a>> b() {
            return FeedEditorDefaultBusinessImpl.f221958a.a(new FrameLayout.LayoutParams(-1, -1));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002,\u0012(\u0012&\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u00050\u0002j\n\u0012\u0002\b\u0003\u0012\u0002\b\u0003`\u00060\u0001J0\u0010\u0007\u001a*\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u0005\u0018\u00010\u0002j\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u0001`\u0006H\u0016J0\u0010\b\u001a*\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u0005\u0018\u00010\u0002j\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u0001`\u0006H\u0016J,\u0010\t\u001a&\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u00050\u0002j\n\u0012\u0002\b\u0003\u0012\u0002\b\u0003`\u0006H\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u000e"}, d2 = {"dm1/b$c", "Ldm1/d$c;", "Lcom/tencent/mvi/mvvm/BaseVB;", "Lcom/tencent/base/api/runtime/a;", "Lzl1/a;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/FeedEditorContext;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/EditorBaseVB;", "buildTitleVB", "f", "d", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements d.c<BaseVB<?, ?, com.tencent.base.api.runtime.a<zl1.a>>> {
        c() {
        }

        @Override // dm1.d.c
        @Nullable
        public BaseVB<?, ?, com.tencent.base.api.runtime.a<zl1.a>> buildTitleVB() {
            return null;
        }

        @Override // dm1.d.c
        @NotNull
        public BaseVB<?, ?, com.tencent.base.api.runtime.a<zl1.a>> d() {
            return new im1.a(new LinearLayout.LayoutParams(-1, 0));
        }

        @Override // dm1.d.c
        @Nullable
        public BaseVB<?, ?, com.tencent.base.api.runtime.a<zl1.a>> f() {
            return new GuildFeedSimplifiedPublishFunctionBarVB();
        }

        @Override // dm1.e
        @NotNull
        public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
            Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
            SimplifiedFeedEditorViewBinding simplifiedFeedEditorViewBinding = b.this.viewBinding;
            if (simplifiedFeedEditorViewBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                simplifiedFeedEditorViewBinding = null;
            }
            return simplifiedFeedEditorViewBinding.getBottomLinearLayout();
        }
    }

    private final BaseVB<?, ?, com.tencent.base.api.runtime.a<zl1.a>> i() {
        SimplifiedFeedEditorViewBinding.Companion companion = SimplifiedFeedEditorViewBinding.INSTANCE;
        return new mm1.f(companion.j(), companion.l());
    }

    @Override // dm1.d
    @NotNull
    public d.b<BaseVB<?, ?, com.tencent.base.api.runtime.a<zl1.a>>> a() {
        return this.rootLayerBlueprint;
    }

    @Override // dm1.d
    @NotNull
    public ViewBinding b(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        SimplifiedFeedEditorViewBinding simplifiedFeedEditorViewBinding = new SimplifiedFeedEditorViewBinding(createViewParams.a());
        this.viewBinding = simplifiedFeedEditorViewBinding;
        return simplifiedFeedEditorViewBinding;
    }

    @Override // dm1.d
    @NotNull
    public d.a<BaseVB<?, ?, com.tencent.base.api.runtime.a<zl1.a>>> c() {
        return this.firstLayer;
    }

    @Override // dm1.d
    @NotNull
    public BaseVB<?, ?, com.tencent.base.api.runtime.a<zl1.a>> d() {
        return i();
    }

    @Override // dm1.d
    @NotNull
    public d.c<BaseVB<?, ?, com.tencent.base.api.runtime.a<zl1.a>>> e() {
        return this.secondLayer;
    }

    @Override // dm1.d
    @NotNull
    public BaseVB<?, ?, com.tencent.base.api.runtime.a<zl1.a>> f() {
        return new FeedEditorGlobalVB(this.globalScope);
    }
}
