package com.tencent.mobileqq.multiforward.title;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aio.data.AIOContact;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.MsgRecordParams;
import com.tencent.mobileqq.aio.title.AIOTitleUIState;
import com.tencent.mobileqq.aio.title.n;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.base.route.j;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IMsgForwardApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import defpackage.MsgListUtil;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00132\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/multiforward/title/b;", "Lcom/tencent/qqnt/aio/baseVM/a;", "Lcom/tencent/mobileqq/aio/title/n;", "Lcom/tencent/mobileqq/aio/title/AIOTitleUIState;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", "intent", DomainData.DOMAIN_NAME, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "e", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "multiForwardMsgItem", "<init>", "()V", "f", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class b extends com.tencent.qqnt.aio.baseVM.a<n, AIOTitleUIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AIOMsgItem multiForwardMsgItem;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/multiforward/title/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.multiforward.title.b$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65410);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void l() {
        FragmentActivity activity = ((com.tencent.aio.api.runtime.a) getMContext()).c().getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void m() {
        Object orNull;
        MsgRecordParams msgRecordParams;
        if (this.multiForwardMsgItem == null) {
            com.tencent.qqnt.aio.utils.multiForward.a aVar = com.tencent.qqnt.aio.utils.multiForward.a.f352306a;
            if (!aVar.a().isEmpty()) {
                if (QLog.isColorLevel()) {
                    QLog.d("MultiForwardTitleVM", 2, "[forwardMsg] multiForwardMsgItem is empty and stack not empty");
                }
                MsgRecord peek = aVar.a().peek();
                ArrayList arrayList = new ArrayList();
                arrayList.add(peek);
                orNull = CollectionsKt___CollectionsKt.getOrNull(MsgListUtil.q(MsgListUtil.f24918a, arrayList, null, null, 4, null), 0);
                this.multiForwardMsgItem = (AIOMsgItem) orNull;
                MsgRecordParams msgRecordParams2 = (MsgRecordParams) ((com.tencent.aio.api.runtime.a) getMContext()).g().l().getParcelable("key_multiforward_parent_msg_record");
                AIOMsgItem aIOMsgItem = this.multiForwardMsgItem;
                if (aIOMsgItem != null) {
                    if (msgRecordParams2 != null) {
                        msgRecordParams = msgRecordParams2.c();
                    } else {
                        msgRecordParams = null;
                    }
                    aIOMsgItem.J1(msgRecordParams);
                }
            }
        }
        AIOMsgItem aIOMsgItem2 = this.multiForwardMsgItem;
        if (aIOMsgItem2 != null) {
            IMsgForwardApi iMsgForwardApi = (IMsgForwardApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IMsgForwardApi.class);
            Context requireContext = ((com.tencent.aio.api.runtime.a) getMContext()).c().requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "mContext.fragment.requireContext()");
            AIOContact c16 = ((com.tencent.aio.api.runtime.a) getMContext()).g().r().c();
            j e16 = ((com.tencent.aio.api.runtime.a) getMContext()).e();
            Intrinsics.checkNotNullExpressionValue(e16, "mContext.messenger");
            iMsgForwardApi.forwardMsgSelect(requireContext, c16, aIOMsgItem2, e16);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull n intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof n.e) {
            ((n.e) intent).b(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().g());
        } else if (intent instanceof n.o) {
            l();
        } else if (intent instanceof n.h) {
            m();
        }
    }

    @Override // com.tencent.qqnt.aio.baseVM.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onDestroy();
        com.tencent.qqnt.aio.utils.multiForward.a aVar = com.tencent.qqnt.aio.utils.multiForward.a.f352306a;
        if (!aVar.a().isEmpty()) {
            aVar.a().pop();
        }
    }

    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        } else {
            Intrinsics.checkNotNullParameter(context, "context");
            super.onCreate(context);
        }
    }
}
