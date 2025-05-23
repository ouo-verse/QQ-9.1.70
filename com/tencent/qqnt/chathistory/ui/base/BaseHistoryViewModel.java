package com.tencent.qqnt.chathistory.ui.base;

import android.app.Activity;
import android.content.Intent;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqnt.base.mvi.BaseViewModel;
import com.tencent.qqnt.base.mvi.a;
import com.tencent.qqnt.base.mvi.b;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\b&\u0018\u0000 &*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005:\u0001'B\u0007\u00a2\u0006\u0004\b$\u0010%J7\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\b2\u001b\b\u0002\u0010\u000e\u001a\u0015\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\n\u00a2\u0006\u0002\b\rR\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001d\u001a\u00020\u00188FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010!\u001a\u00020\u001e8F\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0013\u0010#\u001a\u0004\u0018\u00010\u00188F\u00a2\u0006\u0006\u001a\u0004\b\"\u0010\u001c\u00a8\u0006("}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/base/BaseHistoryViewModel;", "Lcom/tencent/qqnt/base/mvi/a;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/qqnt/base/mvi/b;", "I", "Lcom/tencent/qqnt/base/mvi/BaseViewModel;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Ljava/lang/Class;", "clazz", "Lkotlin/Function1;", "Landroid/content/Intent;", "", "Lkotlin/ExtensionFunctionType;", "intentWrapper", "Q1", "Lcom/tencent/qqnt/chathistory/business/a;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqnt/chathistory/business/a;", "L1", "()Lcom/tencent/qqnt/chathistory/business/a;", "P1", "(Lcom/tencent/qqnt/chathistory/business/a;)V", "businessViewModel", "", "D", "Lkotlin/Lazy;", "N1", "()Ljava/lang/String;", "peerId", "", "M1", "()I", "chatType", "O1", "peerName", "<init>", "()V", "E", "a", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public abstract class BaseHistoryViewModel<S extends com.tencent.qqnt.base.mvi.a, I extends com.tencent.qqnt.base.mvi.b> extends BaseViewModel<S, I> {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    public com.tencent.qqnt.chathistory.business.a businessViewModel;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy peerId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/base/BaseHistoryViewModel$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chathistory.ui.base.BaseHistoryViewModel$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33003);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public BaseHistoryViewModel() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>(this) { // from class: com.tencent.qqnt.chathistory.ui.base.BaseHistoryViewModel$peerId$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ BaseHistoryViewModel<S, I> this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? this.this$0.L1().O1() : (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.peerId = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final com.tencent.qqnt.chathistory.business.a L1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.qqnt.chathistory.business.a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        com.tencent.qqnt.chathistory.business.a aVar = this.businessViewModel;
        if (aVar != null) {
            return aVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("businessViewModel");
        return null;
    }

    public final int M1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return L1().L1();
    }

    @NotNull
    public final String N1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return (String) this.peerId.getValue();
    }

    @Nullable
    public final String O1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return L1().P1();
    }

    public final void P1(@NotNull com.tencent.qqnt.chathistory.business.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        } else {
            Intrinsics.checkNotNullParameter(aVar, "<set-?>");
            this.businessViewModel = aVar;
        }
    }

    public final void Q1(@NotNull Activity activity, @NotNull Class<?> clazz, @Nullable Function1<? super Intent, Unit> intentWrapper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, activity, clazz, intentWrapper);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intent intent = new Intent(activity, activity.getClass());
        intent.putExtra("frameKey", clazz.getName());
        intent.putExtra("nt_chat_history_chatType", M1());
        intent.putExtra("nt_chat_history_peerId", N1());
        intent.putExtra("nt_chat_history_session_name", O1());
        if (intentWrapper != null) {
            intentWrapper.invoke(intent);
        }
        com.tencent.qqnt.chathistory.util.d.f354054a.a("ChatHistoryViewModel", "start Bundle " + intent.getExtras());
        activity.startActivity(intent);
    }
}
