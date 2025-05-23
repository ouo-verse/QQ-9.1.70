package com.tencent.qqnt.msgselect;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqnt.msgselect.helper.MsgSelectHelper;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ts.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 &2\u00020\u0001:\u0001'B\u0007\u00a2\u0006\u0004\b$\u0010%J3\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004H\u0002J\b\u0010\f\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0005H\u0002J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0005H\u0002J$\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005H\u0016R\u001b\u0010\u001f\u001a\u00020\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006("}, d2 = {"Lcom/tencent/qqnt/msgselect/MsgSelectFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "code", "Lkotlin/Function1;", "Landroid/os/Bundle;", "Lkotlin/ParameterName;", "name", "data", "", "unit", "vh", "wh", "bundle", "uh", "Lcom/tencent/aio/data/AIOParam;", "aioParam", "rh", "sh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "Landroid/widget/FrameLayout;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "th", "()Landroid/widget/FrameLayout;", "mRootView", "Lus/a;", "D", "Lus/a;", "mIChatFragmentProvider", "<init>", "()V", "E", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class MsgSelectFragment extends QPublicBaseFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy mRootView;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private us.a mIChatFragmentProvider;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/msgselect/MsgSelectFragment$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.msgselect.MsgSelectFragment$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/msgselect/MsgSelectFragment$b", "Lcom/tencent/aio/runtime/message/b;", "Landroid/os/Bundle;", "data", "", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class b implements com.tencent.aio.runtime.message.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Bundle, Unit> f359722a;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function1<? super Bundle, Unit> function1) {
            this.f359722a = function1;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) function1);
            }
        }

        @Override // com.tencent.aio.runtime.message.b
        public void a(@NotNull Bundle data) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) data);
            } else {
                Intrinsics.checkNotNullParameter(data, "data");
                this.f359722a.invoke(data);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65776);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public MsgSelectFragment() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>() { // from class: com.tencent.qqnt.msgselect.MsgSelectFragment$mRootView$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MsgSelectFragment.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final FrameLayout invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (FrameLayout) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    FrameLayout frameLayout = new FrameLayout(MsgSelectFragment.this.requireContext());
                    frameLayout.setId(View.generateViewId());
                    return frameLayout;
                }
            });
            this.mRootView = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void rh(AIOParam aioParam) {
        HashMap<String, Object> hashMap = new HashMap<>();
        com.tencent.qqnt.msgselect.DTReport.a aVar = new com.tencent.qqnt.msgselect.DTReport.a();
        hashMap.put("aio_type", Integer.valueOf(aioParam.r().c().e()));
        hashMap.put("group_id", "");
        if (aioParam.r().c().e() == 2) {
            hashMap.put("group_id", aioParam.r().c().j());
            try {
                aVar.c(Long.parseLong(aioParam.r().c().j()));
            } catch (Exception e16) {
                QLog.e("MsgSelectFragment", 1, "showMsgSelectPage peerUid error: " + e16);
            }
        }
        com.tencent.qqnt.msgselect.DTReport.b.f359718a.a(th(), aVar, hashMap);
    }

    private final void sh(Bundle bundle) {
        MsgSelectHelper.Companion companion = MsgSelectHelper.INSTANCE;
        Object obj = bundle.get(companion.a());
        if (obj != null && ((Boolean) obj).booleanValue()) {
            int i3 = bundle.getInt(companion.b(), 0);
            HashMap hashMap = new HashMap();
            hashMap.put("selected_messages_number", String.valueOf(i3));
            com.tencent.qqnt.msgselect.DTReport.b.e("em_bas_the_finish_button", hashMap);
        } else {
            com.tencent.qqnt.msgselect.DTReport.b.e("em_bas_cancel_button", new HashMap());
        }
        com.tencent.qqnt.msgselect.DTReport.b.f359718a.c(th(), new HashMap<>());
    }

    private final FrameLayout th() {
        return (FrameLayout) this.mRootView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void uh(Bundle bundle) {
        sh(bundle);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setResult(-1, new Intent().putExtras(bundle));
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void vh(String code, Function1<? super Bundle, Unit> unit) {
        us.a aVar = this.mIChatFragmentProvider;
        if (aVar != null) {
            aVar.i(code, new b(unit));
        }
    }

    private final void wh() {
        String str;
        int i3;
        String str2;
        Intent intent;
        Intent intent2;
        Intent intent3;
        Intent intent4;
        FragmentActivity activity = getActivity();
        Bundle bundle = null;
        if (activity != null && (intent4 = activity.getIntent()) != null) {
            str = intent4.getStringExtra("key_peerId");
        } else {
            str = null;
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null && (intent3 = activity2.getIntent()) != null) {
            i3 = intent3.getIntExtra("key_chat_type", 0);
        } else {
            i3 = 0;
        }
        FragmentActivity activity3 = getActivity();
        if (activity3 == null || (intent2 = activity3.getIntent()) == null || (str2 = intent2.getStringExtra("key_chat_name")) == null) {
            str2 = "";
        }
        if (TextUtils.isEmpty(str)) {
            QLog.i("MsgSelectFragment", 1, "[showMsgSelectPage]: peerId is invalid");
            return;
        }
        QLog.i("MsgSelectFragment", 1, "peerId = " + str + ", chatType = " + i3);
        Intrinsics.checkNotNull(str);
        AIOSession aIOSession = new AIOSession(new AIOContact(i3, str, "", str2));
        AIOParam.a i16 = new AIOParam.a().i(false);
        String name = d.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "MsgSelectFactory::class.java.name");
        AIOParam.a h16 = i16.e(name).h(aIOSession);
        FragmentActivity activity4 = getActivity();
        if (activity4 != null && (intent = activity4.getIntent()) != null) {
            bundle = intent.getExtras();
        }
        AIOParam c16 = h16.a(new Bundle(bundle)).c();
        com.tencent.aio.main.engine.b bVar = com.tencent.aio.main.engine.b.f69377a;
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        us.a d16 = com.tencent.aio.main.engine.b.d(bVar, c16, childFragmentManager, th().getId(), null, 8, null);
        d16.g().b(new e.a() { // from class: com.tencent.qqnt.msgselect.MsgSelectFragment$showMsgSelectPage$1$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) MsgSelectFragment.this);
                }
            }

            @Override // ts.e.a
            public void attachViewTree() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    final MsgSelectFragment msgSelectFragment = MsgSelectFragment.this;
                    msgSelectFragment.vh("close_msg_select", new Function1<Bundle, Unit>() { // from class: com.tencent.qqnt.msgselect.MsgSelectFragment$showMsgSelectPage$1$1$attachViewTree$1
                        static IPatchRedirector $redirector_;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MsgSelectFragment.this);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Bundle bundle2) {
                            invoke2(bundle2);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull Bundle it) {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                            } else {
                                Intrinsics.checkNotNullParameter(it, "it");
                                MsgSelectFragment.this.uh(it);
                            }
                        }
                    });
                }
            }
        });
        this.mIChatFragmentProvider = d16;
        rh(c16);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View th5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            th5 = (View) iPatchRedirector.redirect((short) 2, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            wh();
            th5 = th();
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, th5);
        return th5;
    }
}
