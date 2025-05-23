package com.tencent.mobileqq.guild.feed.nativepublish.root;

import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.input.base.mvicompat.ex.VMMessengerProtocolSupport;
import com.tencent.input.base.mvicompat.ex.a;
import com.tencent.mobileqq.guild.feed.nativepublish.root.msgintent.FeedEditorRootMsgIntent;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.j;
import com.tencent.mvi.base.route.k;
import com.tencent.mvi.mvvm.BaseVM;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00012\u00020\u0005BL\u0012C\u0010\u001b\u001a?\u0012)\u0012'\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001j\u0002`\u0013\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00180\u00170\u0012\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0016J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016RQ\u0010\u001b\u001a?\u0012)\u0012'\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001j\u0002`\u0013\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00180\u00170\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\"\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00180\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/root/d;", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "Lcom/tencent/mvi/api/runtime/b;", "Lcom/tencent/input/base/mvicompat/ex/a;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/root/msgintent/FeedEditorRootMsgIntent$RequestFinishActivityMsgIntent;", "event", "", "j", "context", "onCreate", "", "", "J2", "Lcom/tencent/mvi/base/route/MsgIntent;", "E", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lkotlin/Function1;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/GenericBaseVM;", "Lkotlin/ParameterName;", "name", "vm", "", "Lcom/tencent/input/base/mvicompat/f;", "d", "Lkotlin/jvm/functions/Function1;", "pluginsInitializer", "e", "[Lcom/tencent/input/base/mvicompat/f;", "plugins", "Lcom/tencent/input/base/mvicompat/ex/VMMessengerProtocolSupport;", "f", "Lcom/tencent/input/base/mvicompat/ex/VMMessengerProtocolSupport;", "messengerRegistryHelper", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class d extends BaseVM<ol3.b, MviUIState, com.tencent.mvi.api.runtime.b> implements com.tencent.input.base.mvicompat.ex.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<BaseVM<ol3.b, MviUIState, com.tencent.mvi.api.runtime.b>, com.tencent.input.base.mvicompat.f<com.tencent.mvi.api.runtime.b>[]> pluginsInitializer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.input.base.mvicompat.f<com.tencent.mvi.api.runtime.b>[] plugins;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final VMMessengerProtocolSupport messengerRegistryHelper;

    /* JADX WARN: Multi-variable type inference failed */
    public d(@NotNull Function1<? super BaseVM<ol3.b, MviUIState, com.tencent.mvi.api.runtime.b>, com.tencent.input.base.mvicompat.f<com.tencent.mvi.api.runtime.b>[]> pluginsInitializer) {
        Intrinsics.checkNotNullParameter(pluginsInitializer, "pluginsInitializer");
        this.pluginsInitializer = pluginsInitializer;
        this.messengerRegistryHelper = new VMMessengerProtocolSupport(this);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.tencent.mvi.api.runtime.b] */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.tencent.mvi.api.runtime.b] */
    private final void j(FeedEditorRootMsgIntent.RequestFinishActivityMsgIntent event) {
        getMContext().e().h(new FeedEditorRootMsgIntent.OnFinishActivityMsgIntent(event));
        FragmentActivity activity = getMContext().c().getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // com.tencent.input.base.mvicompat.ex.a
    public void E(@NotNull MsgIntent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof FeedEditorRootMsgIntent.RequestFinishActivityMsgIntent) {
            j((FeedEditorRootMsgIntent.RequestFinishActivityMsgIntent) event);
        }
    }

    @Override // com.tencent.input.base.mvicompat.ex.a
    @NotNull
    public k I(@NotNull MsgIntent msgIntent) {
        return a.C5857a.d(this, msgIntent);
    }

    @Override // com.tencent.input.base.mvicompat.ex.a
    @NotNull
    public List<String> J2() {
        List<String> listOf;
        String b16 = com.tencent.mvi.base.route.c.b(FeedEditorRootMsgIntent.RequestFinishActivityMsgIntent.class);
        Intrinsics.checkNotNullExpressionValue(b16, "get(java)");
        String b17 = com.tencent.mvi.base.route.c.b(FeedEditorRootMsgIntent.OnFinishActivityMsgIntent.class);
        Intrinsics.checkNotNullExpressionValue(b17, "get(java)");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{b16, b17});
        return listOf;
    }

    @Override // com.tencent.input.base.mvicompat.ex.a
    @Nullable
    public List<String> f0() {
        return a.C5857a.b(this);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.tencent.mvi.api.runtime.b] */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        Object[] reversedArray;
        super.onDestroy();
        com.tencent.input.base.mvicompat.f<com.tencent.mvi.api.runtime.b>[] fVarArr = this.plugins;
        if (fVarArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("plugins");
            fVarArr = null;
        }
        reversedArray = ArraysKt___ArraysKt.reversedArray(fVarArr);
        for (Object obj : reversedArray) {
            ((com.tencent.input.base.mvicompat.f) obj).onDestroy();
        }
        VMMessengerProtocolSupport vMMessengerProtocolSupport = this.messengerRegistryHelper;
        j e16 = getMContext().e();
        Intrinsics.checkNotNullExpressionValue(e16, "mContext.messenger");
        vMMessengerProtocolSupport.e(e16);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.mvi.api.runtime.b context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate((d) context);
        VMMessengerProtocolSupport vMMessengerProtocolSupport = this.messengerRegistryHelper;
        j e16 = context.e();
        Intrinsics.checkNotNullExpressionValue(e16, "context.messenger");
        vMMessengerProtocolSupport.d(e16);
        com.tencent.input.base.mvicompat.f<com.tencent.mvi.api.runtime.b>[] invoke = this.pluginsInitializer.invoke(this);
        this.plugins = invoke;
        if (invoke == null) {
            Intrinsics.throwUninitializedPropertyAccessException("plugins");
            invoke = null;
        }
        for (com.tencent.input.base.mvicompat.f<com.tencent.mvi.api.runtime.b> fVar : invoke) {
            fVar.b(context, false);
        }
    }
}
