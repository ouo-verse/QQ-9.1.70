package com.tencent.mobileqq.guild.feed.nativepublish.feature;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.nativepublish.FeedEditorConfiguration;
import com.tencent.mobileqq.guild.feed.nativepublish.root.msgintent.FeedEditorRootMsgIntent;
import com.tencent.mobileqq.guild.feed.nativepublish.viewbinding.SimplifiedFeedEditorViewBinding;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.base.route.j;
import com.tencent.mvi.mvvm.BaseVB;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.mvi.mvvm.framework.FrameworkVM;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ:\u0010\u000b\u001a.\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\t0\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\n2\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/FeedEditorDefaultBusinessImpl;", "", "Landroid/view/ViewGroup$LayoutParams;", "param", "Lcom/tencent/mvi/mvvm/BaseVB;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "Lcom/tencent/base/api/runtime/a;", "Lzl1/a;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/FeedEditorContext;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/EditorBaseVB;", "a", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedEditorDefaultBusinessImpl {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final FeedEditorDefaultBusinessImpl f221958a = new FeedEditorDefaultBusinessImpl();

    FeedEditorDefaultBusinessImpl() {
    }

    @NotNull
    public final BaseVB<ol3.b, MviUIState, com.tencent.base.api.runtime.a<zl1.a>> a(@NotNull final ViewGroup.LayoutParams param) {
        Intrinsics.checkNotNullParameter(param, "param");
        return new BaseVB<ol3.b, MviUIState, com.tencent.base.api.runtime.a<zl1.a>>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.feature.FeedEditorDefaultBusinessImpl$makeBackgroundVB$1

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u00060\u0001\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/feed/nativepublish/feature/FeedEditorDefaultBusinessImpl$makeBackgroundVB$1$a", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "Lcom/tencent/base/api/runtime/a;", "Lzl1/a;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/FeedEditorContext;", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes13.dex */
            public static final class a extends BaseVM<ol3.b, MviUIState, com.tencent.base.api.runtime.a<zl1.a>> {
                a() {
                }
            }

            @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
            @NotNull
            /* renamed from: b1, reason: merged with bridge method [inline-methods] */
            public a createVM() {
                return new a();
            }

            @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
            public void bindViewAndData() {
                com.tencent.base.api.runtime.a aVar;
                zl1.a aVar2;
                FeedEditorConfiguration configuration;
                FrameworkVM mUIModel = getMUIModel();
                boolean z16 = false;
                if (mUIModel != null && (aVar = (com.tencent.base.api.runtime.a) mUIModel.getMContext()) != null && (aVar2 = (zl1.a) aVar.h()) != null && (configuration = aVar2.getConfiguration()) != null && configuration.getIsDisableClickTransparentBackground()) {
                    z16 = true;
                }
                if (z16) {
                    return;
                }
                jt1.b.b(getHostView(), new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.feature.FeedEditorDefaultBusinessImpl$makeBackgroundVB$1$bindViewAndData$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(View view) {
                        invoke2(view);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull View it) {
                        com.tencent.base.api.runtime.a aVar3;
                        j e16;
                        Intrinsics.checkNotNullParameter(it, "it");
                        FrameworkVM mUIModel2 = getMUIModel();
                        if (mUIModel2 == null || (aVar3 = (com.tencent.base.api.runtime.a) mUIModel2.getSafetyContext()) == null || (e16 = aVar3.e()) == null) {
                            return;
                        }
                        e16.h(new FeedEditorRootMsgIntent.TriggerCloseEditorAnyway(2));
                    }
                });
            }

            @Override // com.tencent.mvi.mvvm.b
            @NotNull
            public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
                Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
                View view = new View(createViewParams.a());
                ViewGroup.LayoutParams layoutParams = param;
                view.setId(SimplifiedFeedEditorViewBinding.INSTANCE.i());
                view.setLayoutParams(layoutParams);
                view.setBackground(new ColorDrawable(view.getContext().getResources().getColor(R.color.qui_common_fill_allblack_medium)));
                return view;
            }
        };
    }
}
