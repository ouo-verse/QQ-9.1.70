package com.tencent.qqnt.chathistory.ui.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vaswebviewplugin.MessageRoamJsPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chathistory.bridge.IC2CChatHistoryVasApi;
import com.tencent.qqnt.chathistory.datatracker.HistoryDtReportHelper;
import com.tencent.qqnt.chathistory.ui.base.BaseHistoryFragment;
import com.tencent.qqnt.chathistory.ui.dialog.SearchChatHistoryDialog;
import com.tencent.qqnt.chathistory.ui.menu.data.a;
import com.tencent.qqnt.chathistory.ui.menu.data.b;
import com.tencent.qqnt.chathistory.ui.menu.viewmodel.ChatHistorySearchViewModel;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.msg.f;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 +2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001,B\u0007\u00a2\u0006\u0004\b)\u0010*J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J&\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0012\u001a\u00020\u0005H\u0016R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001b\u0010 \u001a\u00020\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u001b\u0010(\u001a\u00020%8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010\u001d\u001a\u0004\b&\u0010'\u00a8\u0006-"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/menu/ChatHistoryMenuFragment;", "Lcom/tencent/qqnt/chathistory/ui/base/BaseHistoryFragment;", "Lcom/tencent/qqnt/chathistory/ui/menu/viewmodel/ChatHistorySearchViewModel;", "", "Hh", "", "Mh", "Lh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "uh", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "th", "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "E", "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "titleBarLayout", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "vasTipsView", "Lcom/tencent/qqnt/chathistory/bridge/IC2CChatHistoryVasApi;", "G", "Lkotlin/Lazy;", "Jh", "()Lcom/tencent/qqnt/chathistory/bridge/IC2CChatHistoryVasApi;", "vipHelper", "", "H", "I", MessageRoamJsPlugin.USERTYPE, "Landroid/widget/RelativeLayout;", "Ih", "()Landroid/widget/RelativeLayout;", "contentView", "<init>", "()V", "J", "a", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class ChatHistoryMenuFragment extends BaseHistoryFragment<ChatHistorySearchViewModel> {
    static IPatchRedirector $redirector_;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: E, reason: from kotlin metadata */
    private QUISecNavBar titleBarLayout;

    /* renamed from: F, reason: from kotlin metadata */
    private ImageView vasTipsView;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy vipHelper;

    /* renamed from: H, reason: from kotlin metadata */
    private int userType;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy contentView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/menu/ChatHistoryMenuFragment$a;", "", "", "NUM_ITEM_PER_ROW", "I", "", "SEARCH_BOX_HEIGHT_DP", UserInfo.SEX_FEMALE, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chathistory.ui.menu.ChatHistoryMenuFragment$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\u000b\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\n\u00a8\u0006\f"}, d2 = {"com/tencent/qqnt/chathistory/ui/menu/ChatHistoryMenuFragment$b", "Lcom/tencent/biz/qui/quisecnavbar/a;", "Landroid/view/View;", "view", "", "a", "", "b", "", "getDrawable", "()I", "drawable", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b extends com.tencent.biz.qui.quisecnavbar.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatHistoryMenuFragment.this);
            }
        }

        @Override // com.tencent.biz.qui.quisecnavbar.a, com.tencent.biz.qui.quisecnavbar.b
        public void a(@Nullable View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
                return;
            }
            com.tencent.qqnt.chathistory.service.c cVar = com.tencent.qqnt.chathistory.service.c.f353330a;
            Context requireContext = ChatHistoryMenuFragment.this.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            cVar.a(requireContext, ChatHistoryMenuFragment.this.rh().N1());
        }

        @Override // com.tencent.biz.qui.quisecnavbar.a, com.tencent.biz.qui.quisecnavbar.b
        @NotNull
        public String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            String string = ChatHistoryMenuFragment.this.getString(R.string.hhb);
            Intrinsics.checkNotNullExpressionValue(string, "getString(com.tencent.mo\u2026ui.R.string.setting_help)");
            return string;
        }

        @Override // com.tencent.biz.qui.quisecnavbar.b
        public int getDrawable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return R.drawable.qui_chat_history_menu_title_right_selector;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48652);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ChatHistoryMenuFragment() {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(ChatHistoryMenuFragment$vipHelper$2.INSTANCE);
            this.vipHelper = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new ChatHistoryMenuFragment$contentView$2(this));
            this.contentView = lazy2;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean Hh() {
        int i3;
        Long longOrNull;
        w msgService;
        Integer curChatImportStatusByUin;
        w msgService2;
        Integer dataImportUserLevel;
        IKernelService i16 = f.i();
        boolean z16 = false;
        if (i16 != null && (msgService2 = i16.getMsgService()) != null && (dataImportUserLevel = msgService2.getDataImportUserLevel()) != null) {
            i3 = dataImportUserLevel.intValue();
        } else {
            i3 = 0;
        }
        this.userType = i3;
        if (i3 == 3) {
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(HistoryDtReportHelper.INSTANCE.a().d(rh()));
            if (longOrNull == null) {
                QLog.d("ChatHistoryMenuFragmentDebug", 1, "checkMsgImportNotFinishForHighUser:: uin is null");
                return false;
            }
            IKernelService i17 = f.i();
            if (i17 != null && (msgService = i17.getMsgService()) != null && (curChatImportStatusByUin = msgService.getCurChatImportStatusByUin(longOrNull.longValue(), rh().M1())) != null && curChatImportStatusByUin.intValue() == 1) {
                z16 = true;
            }
            QLog.d("ChatHistoryMenuFragmentDebug", 1, "checkMsgImportNotFinishForHighUser:: result = " + z16);
            return z16;
        }
        QLog.d("ChatHistoryMenuFragmentDebug", 1, "checkMsgImportNotFinishForHighUser:: cur userType is not high, return");
        return false;
    }

    private final RelativeLayout Ih() {
        return (RelativeLayout) this.contentView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IC2CChatHistoryVasApi Jh() {
        return (IC2CChatHistoryVasApi) this.vipHelper.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Kh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Lh() {
        com.tencent.qqnt.chathistory.util.d.f354054a.a("ChatHistoryMenuFragmentDebug", "setRight " + rh().M1());
        b bVar = new b();
        QUISecNavBar qUISecNavBar = this.titleBarLayout;
        QUISecNavBar qUISecNavBar2 = null;
        if (qUISecNavBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBarLayout");
            qUISecNavBar = null;
        }
        qUISecNavBar.d(bVar);
        boolean z16 = true;
        if (rh().M1() != 1) {
            z16 = false;
        }
        QUISecNavBar qUISecNavBar3 = this.titleBarLayout;
        if (qUISecNavBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBarLayout");
        } else {
            qUISecNavBar2 = qUISecNavBar3;
        }
        qUISecNavBar2.setRightIconVisible(bVar, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Mh() {
        new SearchChatHistoryDialog(rh()).show(getChildFragmentManager(), "searchDialog");
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        if (rh().M1() == 1) {
            Jh().requestTipsData(new Function1<com.tencent.qqnt.chathistory.bridge.a, Unit>() { // from class: com.tencent.qqnt.chathistory.ui.menu.ChatHistoryMenuFragment$onViewCreated$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* compiled from: P */
                @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
                @DebugMetadata(c = "com.tencent.qqnt.chathistory.ui.menu.ChatHistoryMenuFragment$onViewCreated$1$1", f = "ChatHistoryMenuFragment.kt", i = {}, l = {227}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: com.tencent.qqnt.chathistory.ui.menu.ChatHistoryMenuFragment$onViewCreated$1$1, reason: invalid class name */
                /* loaded from: classes23.dex */
                public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ com.tencent.qqnt.chathistory.bridge.a $data;
                    int label;
                    final /* synthetic */ ChatHistoryMenuFragment this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(ChatHistoryMenuFragment chatHistoryMenuFragment, com.tencent.qqnt.chathistory.bridge.a aVar, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.this$0 = chatHistoryMenuFragment;
                        this.$data = aVar;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, chatHistoryMenuFragment, aVar, continuation);
                        }
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @NotNull
                    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
                        }
                        return new AnonymousClass1(this.this$0, this.$data, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        Object coroutine_suspended;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i3 = this.label;
                            if (i3 != 0) {
                                if (i3 == 1) {
                                    ResultKt.throwOnFailure(obj);
                                } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            } else {
                                ResultKt.throwOnFailure(obj);
                                ChatHistorySearchViewModel rh5 = this.this$0.rh();
                                b.C9545b c9545b = new b.C9545b(this.$data.a(), this.$data.b());
                                this.label = 1;
                                if (rh5.sendUserIntent(c9545b, this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            return Unit.INSTANCE;
                        }
                        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    @Nullable
                    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatHistoryMenuFragment.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.qqnt.chathistory.bridge.a aVar) {
                    invoke2(aVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull com.tencent.qqnt.chathistory.bridge.a data) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) data);
                    } else {
                        Intrinsics.checkNotNullParameter(data, "data");
                        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(ChatHistoryMenuFragment.this), null, null, new AnonymousClass1(ChatHistoryMenuFragment.this, data, null), 3, null);
                    }
                }
            });
        }
    }

    @Override // com.tencent.qqnt.chathistory.ui.base.BaseHistoryFragment
    public void th() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        LiveData obtainUiState = rh().obtainUiState();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<com.tencent.qqnt.chathistory.ui.menu.data.a, Unit> function1 = new Function1<com.tencent.qqnt.chathistory.ui.menu.data.a, Unit>() { // from class: com.tencent.qqnt.chathistory.ui.menu.ChatHistoryMenuFragment$observerUISate$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatHistoryMenuFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.qqnt.chathistory.ui.menu.data.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.qqnt.chathistory.ui.menu.data.a aVar) {
                IC2CChatHistoryVasApi Jh;
                ImageView imageView;
                ImageView imageView2;
                ImageView imageView3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) aVar);
                    return;
                }
                if (aVar instanceof a.c) {
                    Jh = ChatHistoryMenuFragment.this.Jh();
                    a.c cVar = (a.c) aVar;
                    Drawable tipsDrawable = Jh.getTipsDrawable(cVar.a());
                    imageView = ChatHistoryMenuFragment.this.vasTipsView;
                    ImageView imageView4 = null;
                    if (imageView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("vasTipsView");
                        imageView = null;
                    }
                    imageView.setImageDrawable(tipsDrawable);
                    imageView2 = ChatHistoryMenuFragment.this.vasTipsView;
                    if (imageView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("vasTipsView");
                        imageView2 = null;
                    }
                    imageView2.setTag(cVar.b());
                    imageView3 = ChatHistoryMenuFragment.this.vasTipsView;
                    if (imageView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("vasTipsView");
                    } else {
                        imageView4 = imageView3;
                    }
                    imageView4.setVisibility(0);
                }
            }
        };
        obtainUiState.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.qqnt.chathistory.ui.menu.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ChatHistoryMenuFragment.Kh(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.qqnt.chathistory.ui.base.BaseHistoryFragment
    @Nullable
    public View uh(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Map<String, Object> mutableMapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, this, inflater, container, savedInstanceState);
        }
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        HistoryDtReportHelper.Companion companion = HistoryDtReportHelper.INSTANCE;
        HistoryDtReportHelper a16 = companion.a();
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        RelativeLayout Ih = Ih();
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("touin", companion.a().d(rh())), TuplesKt.to("aio_type", String.valueOf(rh().M1())), TuplesKt.to(TPReportKeys.LiveExKeys.LICE_FX_TUID, rh().N1()));
        a16.v(requireActivity, Ih, "pg_bas_chat_history_navigation", mutableMapOf);
        Lh();
        return Ih();
    }
}
