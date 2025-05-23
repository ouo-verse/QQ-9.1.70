package com.tencent.qqnt.chathistory.ui.file.troop;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.teamwork.api.IGroupTeamWorkHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.chathistory.bridge.IHistoryBridgeInterface;
import com.tencent.qqnt.chathistory.ui.base.BaseHistoryFragment;
import com.tencent.qqnt.chathistory.ui.category.BaseSubCategoryFragment;
import com.tencent.qqnt.chathistory.ui.category.c;
import com.tencent.qqnt.chathistory.ui.test.TestFragment;
import com.tencent.qqnt.chathistory.ui.widget.bottomBar.BottomBarOperationType;
import com.tencent.qqnt.chathistory.ui.widget.bottomBar.BottomBarType;
import com.tencent.qqnt.chathistory.util.d;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00010B\u0011\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001c\u00a2\u0006\u0004\b.\u0010/J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0004H\u0002J&\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u001b\u001a\u00020\u0006H\u0016R\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\u001eR\u001e\u0010&\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R*\u0010-\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\"8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010%\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,\u00a8\u00061"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/file/troop/ChatHistoryTroopFileFragment;", "Lcom/tencent/qqnt/chathistory/ui/category/BaseSubCategoryFragment;", "Lcom/tencent/qqnt/chathistory/ui/file/troop/b;", "Lcom/tencent/qqnt/chathistory/ui/category/c;", "", "isSelectModel", "", "Fh", "Lh", "", "Hh", "Lcom/tencent/qqnt/chathistory/ui/widget/bottomBar/BottomBarOperationType;", "operationType", "Kh", "Gh", "enable", "Jh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "uh", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "E", "I", "source", UserInfo.SEX_FEMALE, "containerId", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/qqnt/chathistory/bridge/IHistoryBridgeInterface;", "G", "Ljava/lang/ref/WeakReference;", "bridge", "Lcom/tencent/qqnt/chathistory/ui/category/c$b;", "H", "Ih", "()Ljava/lang/ref/WeakReference;", "y5", "(Ljava/lang/ref/WeakReference;)V", "titleRightDelegate", "<init>", "(I)V", "a", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class ChatHistoryTroopFileFragment extends BaseSubCategoryFragment<com.tencent.qqnt.chathistory.ui.file.troop.b> implements com.tencent.qqnt.chathistory.ui.category.c {
    static IPatchRedirector $redirector_;

    @NotNull
    private static final a I;

    /* renamed from: E, reason: from kotlin metadata */
    private final int source;

    /* renamed from: F, reason: from kotlin metadata */
    private int containerId;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private WeakReference<IHistoryBridgeInterface> bridge;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private WeakReference<c.b> titleRightDelegate;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/file/troop/ChatHistoryTroopFileFragment$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    private static final class a {
        static IPatchRedirector $redirector_;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public /* synthetic */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f353677a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46349);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[BottomBarOperationType.values().length];
            try {
                iArr[BottomBarOperationType.FORWARD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BottomBarOperationType.DOWNLOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BottomBarOperationType.FAVORITE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[BottomBarOperationType.WEIYUN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[BottomBarOperationType.DELETE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f353677a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J-\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005H\u0016\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"com/tencent/qqnt/chathistory/ui/file/troop/ChatHistoryTroopFileFragment$c", "Lcom/tencent/qqnt/chathistory/bridge/IHistoryBridgeInterface$b;", "", "action", "", "", "args", "invoke", "(I[Ljava/lang/Object;)Ljava/lang/Object;", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class c implements IHistoryBridgeInterface.b {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatHistoryTroopFileFragment.this);
            }
        }

        @Override // com.tencent.qqnt.chathistory.bridge.IHistoryBridgeInterface.b
        @Nullable
        public Object invoke(int action, @NotNull Object... args) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return iPatchRedirector.redirect((short) 2, (Object) this, action, (Object) args);
            }
            Intrinsics.checkNotNullParameter(args, "args");
            d dVar = d.f354054a;
            String arrays = Arrays.toString(args);
            Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
            dVar.a("ChatHistoryTroopFileFragment", "nTInvoke  action " + action + "  " + arrays + " ");
            if (action == 3) {
                ChatHistoryTroopFileFragment.this.Gh();
                return null;
            }
            if (action != 4) {
                if (action != 6) {
                    if (action == 7 && ChatHistoryTroopFileFragment.this.isResumed()) {
                        ChatHistoryTroopFileFragment chatHistoryTroopFileFragment = ChatHistoryTroopFileFragment.this;
                        Object obj = args[0];
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                        chatHistoryTroopFileFragment.Jh(((Boolean) obj).booleanValue());
                        return null;
                    }
                    return null;
                }
                ChatHistoryTroopFileFragment chatHistoryTroopFileFragment2 = ChatHistoryTroopFileFragment.this;
                Object obj2 = args[0];
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                boolean booleanValue = ((Boolean) obj2).booleanValue();
                Object obj3 = args[1];
                Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Boolean");
                chatHistoryTroopFileFragment2.vh(booleanValue, ((Boolean) obj3).booleanValue());
                return null;
            }
            ChatHistoryTroopFileFragment chatHistoryTroopFileFragment3 = ChatHistoryTroopFileFragment.this;
            Object obj4 = args[0];
            Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.Boolean");
            chatHistoryTroopFileFragment3.Fh(((Boolean) obj4).booleanValue());
            return null;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46355);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            I = new a(null);
        }
    }

    public ChatHistoryTroopFileFragment() {
        this(0, 1, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            return;
        }
        iPatchRedirector.redirect((short) 10, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Fh(boolean isSelectModel) {
        d.f354054a.a("ChatHistoryTroopFileFragment", " changeShowState  isSelectModel " + isSelectModel + " ");
        Lh(isSelectModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Gh() {
        c.b bVar;
        d.f354054a.a("ChatHistoryTroopFileFragment", "exitTroopFileSelectMode");
        WeakReference<c.b> Ih = Ih();
        if (Ih != null && (bVar = Ih.get()) != null) {
            bVar.k8(requireContext().getString(R.string.f170728zk1));
        }
        sh();
    }

    private final String Hh(boolean isSelectModel) {
        int i3;
        BaseApplication context = BaseApplication.getContext();
        if (isSelectModel) {
            i3 = R.string.f170727zk0;
        } else {
            i3 = R.string.f170728zk1;
        }
        String string = context.getString(i3);
        Intrinsics.checkNotNullExpressionValue(string, "getContext().getString(i\u2026_find_by_category_choose)");
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Jh(boolean enable) {
        c.b bVar;
        WeakReference<c.b> Ih = Ih();
        if (Ih != null && (bVar = Ih.get()) != null) {
            bVar.setEnable(enable);
        }
        d.f354054a.a("ChatHistoryTroopFileFragment", "setRightEnable " + enable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Kh(BottomBarOperationType operationType) {
        IHistoryBridgeInterface iHistoryBridgeInterface;
        IHistoryBridgeInterface iHistoryBridgeInterface2;
        IHistoryBridgeInterface iHistoryBridgeInterface3;
        IHistoryBridgeInterface iHistoryBridgeInterface4;
        WeakReference<IHistoryBridgeInterface> weakReference;
        IHistoryBridgeInterface iHistoryBridgeInterface5;
        int i3 = b.f353677a[operationType.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 == 5 && (weakReference = this.bridge) != null && (iHistoryBridgeInterface5 = weakReference.get()) != null) {
                            iHistoryBridgeInterface5.invoke(5, IHistoryBridgeInterface.TroopFileActionType.DELETE);
                            return;
                        }
                        return;
                    }
                    WeakReference<IHistoryBridgeInterface> weakReference2 = this.bridge;
                    if (weakReference2 != null && (iHistoryBridgeInterface4 = weakReference2.get()) != null) {
                        iHistoryBridgeInterface4.invoke(5, IHistoryBridgeInterface.TroopFileActionType.WEIYUN);
                        return;
                    }
                    return;
                }
                WeakReference<IHistoryBridgeInterface> weakReference3 = this.bridge;
                if (weakReference3 != null && (iHistoryBridgeInterface3 = weakReference3.get()) != null) {
                    iHistoryBridgeInterface3.invoke(5, IHistoryBridgeInterface.TroopFileActionType.FAVORITE);
                    return;
                }
                return;
            }
            WeakReference<IHistoryBridgeInterface> weakReference4 = this.bridge;
            if (weakReference4 != null && (iHistoryBridgeInterface2 = weakReference4.get()) != null) {
                iHistoryBridgeInterface2.invoke(5, IHistoryBridgeInterface.TroopFileActionType.DOWNLOAD);
                return;
            }
            return;
        }
        WeakReference<IHistoryBridgeInterface> weakReference5 = this.bridge;
        if (weakReference5 != null && (iHistoryBridgeInterface = weakReference5.get()) != null) {
            iHistoryBridgeInterface.invoke(5, IHistoryBridgeInterface.TroopFileActionType.FORWARD);
        }
    }

    private final void Lh(final boolean isSelectModel) {
        WeakReference<c.b> Ih;
        c.b bVar;
        if (isResumed() && (Ih = Ih()) != null && (bVar = Ih.get()) != null) {
            bVar.f3(Hh(isSelectModel), new View.OnClickListener() { // from class: com.tencent.qqnt.chathistory.ui.file.troop.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ChatHistoryTroopFileFragment.Mh(isSelectModel, this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void Mh(boolean z16, final ChatHistoryTroopFileFragment this$0, View view) {
        IHistoryBridgeInterface iHistoryBridgeInterface;
        IHistoryBridgeInterface iHistoryBridgeInterface2;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16) {
            WeakReference<IHistoryBridgeInterface> weakReference = this$0.bridge;
            if (weakReference != null && (iHistoryBridgeInterface2 = weakReference.get()) != null) {
                iHistoryBridgeInterface2.invoke(3, new Object[0]);
            }
            this$0.sh();
        } else {
            WeakReference<IHistoryBridgeInterface> weakReference2 = this$0.bridge;
            if (weakReference2 != null && (iHistoryBridgeInterface = weakReference2.get()) != null) {
                iHistoryBridgeInterface.invoke(2, new Object[0]);
            }
            this$0.yh(((com.tencent.qqnt.chathistory.ui.file.troop.b) this$0.rh()).M1(), ((com.tencent.qqnt.chathistory.ui.file.troop.b) this$0.rh()).N1(), BottomBarType.FILE, new Function1<BottomBarOperationType, Unit>() { // from class: com.tencent.qqnt.chathistory.ui.file.troop.ChatHistoryTroopFileFragment$updateRightBtn$1$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatHistoryTroopFileFragment.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(BottomBarOperationType bottomBarOperationType) {
                    invoke2(bottomBarOperationType);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull BottomBarOperationType it) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    } else {
                        Intrinsics.checkNotNullParameter(it, "it");
                        ChatHistoryTroopFileFragment.this.Kh(it);
                    }
                }
            });
            BaseHistoryFragment.wh(this$0, false, false, 2, null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Nullable
    public WeakReference<c.b> Ih() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (WeakReference) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.titleRightDelegate;
    }

    @Override // com.tencent.qqnt.chathistory.ui.category.c
    public void ff() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            c.a.a(this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onDestroy();
        d.f354054a.a("ChatHistoryTroopFileFragment", "onDestroy " + this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Fragment fragment;
        IHistoryBridgeInterface newInstance;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Fragment findFragmentByTag = getChildFragmentManager().findFragmentByTag("ChatHistoryTroopFileFragment");
        if (findFragmentByTag != null) {
            getChildFragmentManager().beginTransaction().attach(findFragmentByTag);
            return;
        }
        Class<IHistoryBridgeInterface> cls = com.tencent.qqnt.chathistory.inject.a.f353321a.get("groupFile");
        Fragment fragment2 = null;
        if (cls != null && (newInstance = cls.newInstance()) != 0) {
            this.bridge = new WeakReference<>(newInstance);
            newInstance.q8(new c());
            fragment = newInstance;
        } else {
            fragment = null;
        }
        if (fragment instanceof Fragment) {
            fragment2 = fragment;
        }
        if (fragment2 == null) {
            fragment2 = new TestFragment(R.string.f170384pb);
        }
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        int i3 = this.containerId;
        Bundle bundle = new Bundle();
        bundle.putString(IGroupTeamWorkHandler.KEY_GROUP_CODE, ((com.tencent.qqnt.chathistory.ui.file.troop.b) rh()).N1());
        bundle.putInt("key_source", this.source);
        fragment2.setArguments(bundle);
        Unit unit = Unit.INSTANCE;
        beginTransaction.add(i3, fragment2, "ChatHistoryTroopFileFragment").commitAllowingStateLoss();
    }

    @Override // com.tencent.qqnt.chathistory.ui.category.c
    public void t6() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            c.a.b(this);
        }
    }

    @Override // com.tencent.qqnt.chathistory.ui.base.BaseHistoryFragment
    @Nullable
    public View uh(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, this, inflater, container, savedInstanceState);
        }
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        d.f354054a.a("ChatHistoryTroopFileFragment", "onCreateFragmentView " + this.containerId);
        Context context = getContext();
        if (context != null) {
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            frameLayout.setId(this.containerId);
            return frameLayout;
        }
        return null;
    }

    @Override // com.tencent.qqnt.chathistory.ui.category.c
    public void y5(@Nullable WeakReference<c.b> weakReference) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) weakReference);
        } else {
            this.titleRightDelegate = weakReference;
        }
    }

    public ChatHistoryTroopFileFragment(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
        } else {
            this.source = i3;
            this.containerId = View.generateViewId();
        }
    }

    public /* synthetic */ ChatHistoryTroopFileFragment(int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }
}
