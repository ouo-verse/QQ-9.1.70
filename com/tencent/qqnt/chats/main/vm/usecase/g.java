package com.tencent.qqnt.chats.main.vm.usecase;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.qqnt.chats.core.ui.third.p013const.ThirdViewEnum;
import com.tencent.qqnt.chats.main.func.littleear.MainChatEarClickUseCase;
import com.tencent.qqnt.chats.main.vm.usecase.thirdview.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 \u00172\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016JG\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006H\u0086\u0002\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u0082\u0002\u000f\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\n\u0002\b\u0019\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/chats/main/vm/usecase/g;", "", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/chats/core/ui/third/const/ThirdViewEnum;", "viewType", "", "", "extras", "Lkotlin/Result;", "Lcom/tencent/qqnt/chats/main/vm/usecase/result/a;", "a", "(Landroid/content/Context;Lcom/tencent/qqnt/chats/core/ui/third/const/ThirdViewEnum;Ljava/util/Map;)Ljava/lang/Object;", "", "Lcom/tencent/qqnt/chats/main/vm/usecase/thirdview/b;", "Ljava/util/List;", "subUseCase", "Lcom/tencent/qqnt/chats/main/vm/usecase/thirdview/a;", "b", "Lcom/tencent/qqnt/chats/main/vm/usecase/thirdview/a;", "defaultThirdViewClickUseCase", "<init>", "()V", "c", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public class g {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Chats/Inject_ThirdView.yml", version = 2)
    @NotNull
    private static final ArrayList<Class<com.tencent.qqnt.chats.main.vm.usecase.thirdview.b>> f355496d;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<com.tencent.qqnt.chats.main.vm.usecase.thirdview.b> subUseCase;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.chats.main.vm.usecase.thirdview.a defaultThirdViewClickUseCase;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chats/main/vm/usecase/g$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.main.vm.usecase.g$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46266);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        INSTANCE = new Companion(null);
        ArrayList<Class<com.tencent.qqnt.chats.main.vm.usecase.thirdview.b>> arrayList = new ArrayList<>();
        f355496d = arrayList;
        arrayList.add(MainChatEarClickUseCase.class);
    }

    public g() {
        int collectionSizeOrDefault;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        ArrayList<Class<com.tencent.qqnt.chats.main.vm.usecase.thirdview.b>> arrayList = f355496d;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            Object newInstance = ((Class) it.next()).newInstance();
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.tencent.qqnt.chats.main.vm.usecase.thirdview.IThirdViewClickUseCase");
            arrayList2.add((com.tencent.qqnt.chats.main.vm.usecase.thirdview.b) newInstance);
        }
        this.subUseCase = arrayList2;
        this.defaultThirdViewClickUseCase = new com.tencent.qqnt.chats.main.vm.usecase.thirdview.a();
    }

    @NotNull
    public final Object a(@NotNull Context context, @NotNull ThirdViewEnum viewType, @Nullable Map<String, ? extends Object> extras) {
        Result result;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, this, context, viewType, extras);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewType, "viewType");
        b.a aVar = new b.a(context, viewType, extras);
        if (this.subUseCase.isEmpty()) {
            Result.Companion companion = Result.INSTANCE;
            return Result.m476constructorimpl(this.defaultThirdViewClickUseCase.b(aVar));
        }
        Iterator<T> it = this.subUseCase.iterator();
        while (true) {
            if (it.hasNext()) {
                com.tencent.qqnt.chats.main.vm.usecase.thirdview.b bVar = (com.tencent.qqnt.chats.main.vm.usecase.thirdview.b) it.next();
                if (bVar.a(aVar)) {
                    Result.Companion companion2 = Result.INSTANCE;
                    result = Result.m475boximpl(Result.m476constructorimpl(bVar.b(aVar)));
                    break;
                }
            } else {
                result = null;
                break;
            }
        }
        boolean z16 = false;
        if (result != null && Result.m483isSuccessimpl(result.getValue())) {
            z16 = true;
        }
        if (!z16) {
            Result.Companion companion3 = Result.INSTANCE;
            return Result.m476constructorimpl(this.defaultThirdViewClickUseCase.b(aVar));
        }
        Intrinsics.checkNotNull(result);
        return result.getValue();
    }
}
