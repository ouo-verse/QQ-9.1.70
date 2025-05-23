package com.tencent.mobileqq.troop.troopsetting.share.qrcode;

import android.os.Bundle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\rH\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/share/qrcode/QRQZoneShareAction;", "Lcom/tencent/mobileqq/troop/troopsetting/share/qrcode/AbsQRCodeShareAction;", "Lcom/tencent/mobileqq/troop/data/TroopInfoData;", "troopInfoData", "", "shareLink", "Landroid/os/Bundle;", "j", "(Lcom/tencent/mobileqq/troop/data/TroopInfoData;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/troop/troopsetting/share/b;", "shareContext", "", "k", "", "d", "a", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class QRQZoneShareAction extends AbsQRCodeShareAction {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/share/qrcode/QRQZoneShareAction$a;", "", "", "CODE_SHARE_TO_QZONE", "I", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopsetting.share.qrcode.QRQZoneShareAction$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61007);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QRQZoneShareAction() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object j(TroopInfoData troopInfoData, String str, Continuation<? super Bundle> continuation) {
        QRQZoneShareAction$reqTailLink$1 qRQZoneShareAction$reqTailLink$1;
        Object coroutine_suspended;
        int i3;
        Ref.ObjectRef objectRef;
        if (continuation instanceof QRQZoneShareAction$reqTailLink$1) {
            qRQZoneShareAction$reqTailLink$1 = (QRQZoneShareAction$reqTailLink$1) continuation;
            int i16 = qRQZoneShareAction$reqTailLink$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                qRQZoneShareAction$reqTailLink$1.label = i16 - Integer.MIN_VALUE;
                Object obj = qRQZoneShareAction$reqTailLink$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = qRQZoneShareAction$reqTailLink$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        objectRef = (Ref.ObjectRef) qRQZoneShareAction$reqTailLink$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    CoroutineDispatcher io5 = Dispatchers.getIO();
                    QRQZoneShareAction$reqTailLink$2 qRQZoneShareAction$reqTailLink$2 = new QRQZoneShareAction$reqTailLink$2(objectRef2, troopInfoData, str, null);
                    qRQZoneShareAction$reqTailLink$1.L$0 = objectRef2;
                    qRQZoneShareAction$reqTailLink$1.label = 1;
                    if (BuildersKt.withContext(io5, qRQZoneShareAction$reqTailLink$2, qRQZoneShareAction$reqTailLink$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    objectRef = objectRef2;
                }
                return objectRef.element;
            }
        }
        qRQZoneShareAction$reqTailLink$1 = new QRQZoneShareAction$reqTailLink$1(this, continuation);
        Object obj2 = qRQZoneShareAction$reqTailLink$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = qRQZoneShareAction$reqTailLink$1.label;
        if (i3 == 0) {
        }
        return objectRef.element;
    }

    private final void k(com.tencent.mobileqq.troop.troopsetting.share.b shareContext) {
        if (shareContext.e() == null) {
            return;
        }
        QBaseActivity b16 = shareContext.b();
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(b16), null, null, new QRQZoneShareAction$reqTailLinkAndShareToQZone$1(shareContext, this, b16, null), 3, null);
    }

    @Override // com.tencent.mobileqq.troop.troopsetting.share.a
    public void a(@NotNull com.tencent.mobileqq.troop.troopsetting.share.b shareContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) shareContext);
        } else {
            Intrinsics.checkNotNullParameter(shareContext, "shareContext");
            k(shareContext);
        }
    }

    @Override // com.tencent.mobileqq.troop.troopsetting.share.a
    @NotNull
    public List<String> d() {
        List<String> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf("qzoneshuoshuo");
            return listOf;
        }
        return (List) iPatchRedirector.redirect((short) 2, (Object) this);
    }
}
