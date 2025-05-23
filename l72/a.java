package l72;

import android.content.Context;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.mobileqq.aio.input.adorn.a;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.aio.api.IAIOInputBarApi;
import com.tencent.qqnt.aio.api.IInputBarAdornSuiteApi;
import com.tencent.qqnt.aio.assistedchat.api.IAssistedChatApi;
import com.tencent.qqnt.aio.bottombar.sectionbar.api.IBottomSectionBarApi;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J<\u0010\r\u001a.\u0012*\u0012(\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0006\u0012\u0006\b\u0000\u0012\u00020\u00020\tj\n\u0012\u0006\b\u0000\u0012\u00020\u0002`\f0\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J2\u0010\u0012\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u000e0\u000fj\u0002`\u00110\b2\u0006\u0010\u0007\u001a\u00020\u000eH\u0016J\u0018\u0010\u0015\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0014\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013H\u0016\u00a8\u0006\u0018"}, d2 = {"Ll72/a;", "Lcom/tencent/mobileqq/aio/input/adorn/a;", "Lcom/tencent/mobileqq/aio/input/inputbar/viewbinding/a;", "Landroid/content/Context;", "context", "f", "Lcom/tencent/mobileqq/aio/input/adorn/b;", "host", "", "Lcom/tencent/input/base/mvicompat/c;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVBDelegate;", "e", "Lcom/tencent/mobileqq/aio/input/adorn/c;", "Lcom/tencent/input/base/mvicompat/e;", "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVMDelegate;", "c", "Lcom/tencent/aio/base/mvvm/a;", "", "a", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a implements com.tencent.mobileqq.aio.input.adorn.a<com.tencent.mobileqq.aio.input.inputbar.viewbinding.a> {

    /* renamed from: b, reason: collision with root package name */
    private static final List<Integer> f413908b;

    static {
        List<Integer> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(com.tencent.mobileqq.aio.input.adorn.d.f189166c), Integer.valueOf(com.tencent.mobileqq.aio.input.adorn.d.f189167d), Integer.valueOf(com.tencent.mobileqq.aio.input.adorn.d.f189168e), Integer.valueOf(com.tencent.mobileqq.aio.input.adorn.d.f189165b), Integer.valueOf(com.tencent.mobileqq.aio.input.adorn.d.f189170g), Integer.valueOf(com.tencent.mobileqq.aio.input.adorn.d.f189171h), Integer.valueOf(com.tencent.mobileqq.aio.input.adorn.d.f189176m)});
        f413908b = listOf;
    }

    @Override // com.tencent.mobileqq.aio.input.adorn.a
    public com.tencent.aio.base.mvvm.a<Object, Object> a() {
        return ((IBottomSectionBarApi) QRoute.api(IBottomSectionBarApi.class)).getBottomSectionBarVB();
    }

    @Override // com.tencent.mobileqq.aio.input.adorn.a
    public List<com.tencent.input.base.mvicompat.e<at.a, InputUIState, com.tencent.aio.api.runtime.a, com.tencent.mobileqq.aio.input.adorn.c>> c(com.tencent.mobileqq.aio.input.adorn.c host) {
        List listOf;
        List<com.tencent.input.base.mvicompat.e<at.a, InputUIState, com.tencent.aio.api.runtime.a, com.tencent.mobileqq.aio.input.adorn.c>> plus;
        Intrinsics.checkNotNullParameter(host, "host");
        List<com.tencent.input.base.mvicompat.e<at.a, InputUIState, com.tencent.aio.api.runtime.a, com.tencent.mobileqq.aio.input.adorn.c>> vMDelegateList = ((IInputBarAdornSuiteApi) QRoute.api(IInputBarAdornSuiteApi.class)).getVMDelegateList(host, f413908b);
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.input.base.mvicompat.e[]{new f(host), ((IAssistedChatApi) QRoute.api(IAssistedChatApi.class)).getAssistedChatInputVMDelegate(host)});
        plus = CollectionsKt___CollectionsKt.plus((Collection) vMDelegateList, (Iterable) listOf);
        return plus;
    }

    @Override // com.tencent.mobileqq.aio.input.adorn.a
    public boolean d() {
        return a.C7250a.b(this);
    }

    @Override // com.tencent.mobileqq.aio.input.adorn.a
    public List<com.tencent.input.base.mvicompat.c<at.a, InputUIState, com.tencent.mobileqq.aio.input.adorn.b, ? super com.tencent.mobileqq.aio.input.inputbar.viewbinding.a>> e(com.tencent.mobileqq.aio.input.adorn.b host) {
        List listOf;
        List<com.tencent.input.base.mvicompat.c<at.a, InputUIState, com.tencent.mobileqq.aio.input.adorn.b, ? super com.tencent.mobileqq.aio.input.inputbar.viewbinding.a>> plus;
        Intrinsics.checkNotNullParameter(host, "host");
        List<com.tencent.input.base.mvicompat.c<at.a, InputUIState, com.tencent.mobileqq.aio.input.adorn.b, ?>> vBDelegateList = ((IInputBarAdornSuiteApi) QRoute.api(IInputBarAdornSuiteApi.class)).getVBDelegateList(host, f413908b);
        Intrinsics.checkNotNull(vBDelegateList, "null cannot be cast to non-null type kotlin.collections.List<com.tencent.input.base.mvicompat.IVBDelegate<com.tencent.aio.base.mvi.part.InputMviIntent, com.tencent.aio.base.mvi.part.InputUIState, com.tencent.mobileqq.aio.input.adorn.IInputBarVBDelegateHost, in com.tencent.mobileqq.aio.input.adorn.InputViewBinding>{ com.tencent.mobileqq.aio.input.adorn.IInputBarAdornApiKt.IInputBarVBDelegate<in com.tencent.mobileqq.aio.input.adorn.InputViewBinding> }>");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.input.base.mvicompat.c[]{new e(host), ((IAssistedChatApi) QRoute.api(IAssistedChatApi.class)).getAssistedChatInputVBDelegate(host), ((IAIOInputBarApi) QRoute.api(IAIOInputBarApi.class)).getSendBtnCompactVB(host)});
        plus = CollectionsKt___CollectionsKt.plus((Collection) vBDelegateList, (Iterable) listOf);
        return plus;
    }

    @Override // com.tencent.mobileqq.aio.input.adorn.a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.aio.input.inputbar.viewbinding.a b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new com.tencent.mobileqq.aio.input.inputbar.viewbinding.a(context);
    }
}
