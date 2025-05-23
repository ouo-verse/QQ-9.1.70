package com.tencent.qqnt.chats.biz.miniaio;

import android.content.Context;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.quibadge.QUIBadgeDragLayout;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorEvent;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqnt.chats.api.IChatsUtil;
import com.tencent.qqnt.chats.api.IChatsViewModelCreator;
import com.tencent.qqnt.chats.api.b;
import com.tencent.qqnt.chats.biz.miniaio.h;
import com.tencent.qqnt.chats.core.adapter.holder.RecentContactItemBinding;
import com.tencent.qqnt.chats.core.ui.ChatsListVB;
import com.tencent.qqnt.chats.core.userintent.a;
import com.tencent.qqnt.chats.core.userintent.b;
import com.tencent.qqnt.chats.view.SkinnableRecycleView;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\bK\u0010LJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\u0000H\u0016J$\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0003H\u0016J\b\u0010\u0015\u001a\u00020\u0003H\u0016J\b\u0010\u0016\u001a\u00020\u0003H\u0016J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0017H\u0016R\"\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u001b\u0010-\u001a\u00020(8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001b\u00100\u001a\u00020(8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b.\u0010*\u001a\u0004\b/\u0010,R\u001b\u00103\u001a\u00020(8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b1\u0010*\u001a\u0004\b2\u0010,R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u00020\u0017088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00109R \u0010@\u001a\b\u0012\u0004\u0012\u00020\u00170;8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u0018\u0010D\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010G\u001a\u00020E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u00105R\u0014\u0010J\u001a\u00020 8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bH\u0010I\u00a8\u0006M"}, d2 = {"Lcom/tencent/qqnt/chats/biz/miniaio/MiniMsgFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/tencent/qqnt/chats/biz/miniaio/b;", "", "Ch", "Gh", "Landroid/view/View;", HippyEngineMonitorEvent.MODULE_LOAD_EVENT_CREATE_VIEW, "Dh", "Hh", "Lcom/tencent/qqnt/chats/core/data/a;", "Bh", "wh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreateView", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/qqnt/chats/biz/miniaio/a;", "event", "Hb", "Lcom/tencent/qqnt/chats/core/mvi/a;", "Lcom/tencent/qqnt/chats/core/uistate/b;", "Lcom/tencent/qqnt/chats/core/userintent/b;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqnt/chats/core/mvi/a;", "mChatsVM", "Lpw3/h;", "D", "Lpw3/h;", "_binding", "Lcom/tencent/qqnt/chats/core/ui/ChatsListVB;", "E", "Lcom/tencent/qqnt/chats/core/ui/ChatsListVB;", "mChatsVB", "", UserInfo.SEX_FEMALE, "Lkotlin/Lazy;", OcrConfig.CHINESE, "()Z", "mIsHorizontal", "G", "Ah", "mNeedHeader", "H", "yh", "mBlockGoToMsgTab", "", "I", "J", "mSelectId", "Lkotlinx/coroutines/channels/Channel;", "Lkotlinx/coroutines/channels/Channel;", "_uiEvent", "Lkotlinx/coroutines/flow/Flow;", "K", "Lkotlinx/coroutines/flow/Flow;", "Va", "()Lkotlinx/coroutines/flow/Flow;", "uiEvent", "", "L", "Ljava/lang/String;", "refPgId", "", "M", "refPgStp", "xh", "()Lpw3/h;", "mBinding", "<init>", "()V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class MiniMsgFragment extends Fragment implements com.tencent.qqnt.chats.biz.miniaio.b {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    private com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> mChatsVM;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private pw3.h _binding;

    /* renamed from: E, reason: from kotlin metadata */
    private ChatsListVB mChatsVB;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy mIsHorizontal;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy mNeedHeader;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy mBlockGoToMsgTab;

    /* renamed from: I, reason: from kotlin metadata */
    private long mSelectId;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Channel<com.tencent.qqnt.chats.biz.miniaio.a> _uiEvent;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Flow<com.tencent.qqnt.chats.biz.miniaio.a> uiEvent;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private String refPgId;

    /* renamed from: M, reason: from kotlin metadata */
    private int refPgStp;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/qqnt/chats/biz/miniaio/MiniMsgFragment$a", "Lcom/tencent/qqnt/chats/core/adapter/h;", "", "position", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/qqnt/chats/core/adapter/holder/RecentContactItemBinding;", "binding", "", "a", "dragType", "f", "chats_view_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class a extends com.tencent.qqnt.chats.core.adapter.h {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MiniMsgFragment.this);
            }
        }

        @Override // com.tencent.qqnt.chats.core.adapter.h
        public void a(int position, @NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item, @NotNull RecentContactItemBinding binding) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(position), item, binding);
                return;
            }
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(binding, "binding");
            if (MiniMsgFragment.this.mSelectId != item.m()) {
                MiniMsgFragment.this.mSelectId = item.m();
                MiniMsgFragment.this._uiEvent.mo2003trySendJP2dKIU(new h.b(new com.tencent.qqnt.chats.biz.miniaio.c(item.n(), item.k(), item.w().e())));
                com.tencent.qqnt.chats.biz.miniaio.horizontal.d.f354359a.b(item.m());
                ChatsListVB chatsListVB = MiniMsgFragment.this.mChatsVB;
                if (chatsListVB == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mChatsVB");
                    chatsListVB = null;
                }
                chatsListVB.Y(com.tencent.qqnt.chats.core.adapter.itemdata.payload.f.f354597a);
            }
        }

        @Override // com.tencent.qqnt.chats.core.adapter.h
        public void f(int position, @NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item, int dragType) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(position), item, Integer.valueOf(dragType));
                return;
            }
            Intrinsics.checkNotNullParameter(item, "item");
            ChatsListVB chatsListVB = MiniMsgFragment.this.mChatsVB;
            if (chatsListVB == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mChatsVB");
                chatsListVB = null;
            }
            chatsListVB.e(new a.h(position, item, dragType));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/qqnt/chats/biz/miniaio/MiniMsgFragment$b", "Lcom/tencent/qqnt/chats/biz/miniaio/e;", "", "position", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "dragType", "", "f", "chats_view_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class b extends e {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MiniMsgFragment.this);
            }
        }

        @Override // com.tencent.qqnt.chats.core.adapter.h
        public void f(int position, @NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item, int dragType) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(position), item, Integer.valueOf(dragType));
                return;
            }
            Intrinsics.checkNotNullParameter(item, "item");
            ChatsListVB chatsListVB = MiniMsgFragment.this.mChatsVB;
            if (chatsListVB == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mChatsVB");
                chatsListVB = null;
            }
            chatsListVB.e(new a.h(position, item, dragType));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/chats/biz/miniaio/MiniMsgFragment$c", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "Landroid/view/MotionEvent;", "e", "", "onSingleTapConfirmed", "chats_view_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class c extends GestureDetector.SimpleOnGestureListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MiniMsgFragment.this);
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(@NotNull MotionEvent e16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) e16)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(e16, "e");
            MiniMsgFragment.this._uiEvent.mo2003trySendJP2dKIU(h.c.f354355a);
            return false;
        }
    }

    public MiniMsgFragment() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.qqnt.chats.biz.miniaio.MiniMsgFragment$mIsHorizontal$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MiniMsgFragment.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Boolean invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Boolean) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    Bundle arguments = MiniMsgFragment.this.getArguments();
                    return Boolean.valueOf(arguments != null ? arguments.getBoolean("key_is_horizontal", false) : false);
                }
            });
            this.mIsHorizontal = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.qqnt.chats.biz.miniaio.MiniMsgFragment$mNeedHeader$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MiniMsgFragment.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Boolean invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Boolean) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    Bundle arguments = MiniMsgFragment.this.getArguments();
                    return Boolean.valueOf(arguments != null ? arguments.getBoolean("key_need_header", false) : false);
                }
            });
            this.mNeedHeader = lazy2;
            lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.qqnt.chats.biz.miniaio.MiniMsgFragment$mBlockGoToMsgTab$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MiniMsgFragment.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Boolean invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Boolean) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    Bundle arguments = MiniMsgFragment.this.getArguments();
                    return Boolean.valueOf(arguments != null ? arguments.getBoolean("key_block_goto_msgTab", false) : false);
                }
            });
            this.mBlockGoToMsgTab = lazy3;
            Channel<com.tencent.qqnt.chats.biz.miniaio.a> Channel$default = ChannelKt.Channel$default(0, null, null, 7, null);
            this._uiEvent = Channel$default;
            this.uiEvent = FlowKt.receiveAsFlow(Channel$default);
            this.refPgStp = 2;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final boolean Ah() {
        return ((Boolean) this.mNeedHeader.getValue()).booleanValue();
    }

    private final com.tencent.qqnt.chats.core.data.a Bh() {
        if (zh()) {
            return new com.tencent.qqnt.chats.biz.miniaio.horizontal.a(new a());
        }
        return new d(new b());
    }

    private final void Ch() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.refPgId = arguments.getString("chat_key_pgid");
            this.refPgStp = arguments.getInt("chat_key_pgstp", 1) + 1;
        }
    }

    private final View Dh() {
        int statusBarHeight;
        this._binding = pw3.h.g(getLayoutInflater());
        if (Ah()) {
            xh().f427840e.setVisibility(0);
            xh().f427838c.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.chats.biz.miniaio.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MiniMsgFragment.Eh(MiniMsgFragment.this, view);
                }
            });
            if (yh()) {
                xh().f427842g.setVisibility(8);
            } else {
                xh().f427842g.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.chats.biz.miniaio.j
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        MiniMsgFragment.Fh(MiniMsgFragment.this, view);
                    }
                });
            }
        } else {
            xh().f427840e.setVisibility(8);
        }
        if (zh()) {
            statusBarHeight = ViewUtils.dpToPx(17.0f);
        } else {
            statusBarHeight = ImmersiveUtils.getStatusBarHeight(getLayoutInflater().getContext());
        }
        xh().getRoot().setPadding(0, statusBarHeight, 0, 0);
        LinearLayout root = xh().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "mBinding.root");
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar = this.mChatsVM;
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVM");
            aVar = null;
        }
        ChatsListVB chatsListVB = new ChatsListVB(aVar, Bh());
        this.mChatsVB = chatsListVB;
        SkinnableRecycleView skinnableRecycleView = xh().f427837b;
        Intrinsics.checkNotNullExpressionValue(skinnableRecycleView, "mBinding.chatsList");
        QUIBadgeDragLayout qUIBadgeDragLayout = xh().f427839d;
        Intrinsics.checkNotNullExpressionValue(qUIBadgeDragLayout, "mBinding.dragArea");
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        chatsListVB.d0(new ChatsListVB.b(skinnableRecycleView, qUIBadgeDragLayout, null, requireContext, null, null, null, null, 240, null));
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar3 = this.mChatsVM;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVM");
            aVar3 = null;
        }
        ChatsListVB chatsListVB2 = this.mChatsVB;
        if (chatsListVB2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVB");
            chatsListVB2 = null;
        }
        aVar3.d(chatsListVB2);
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar4 = this.mChatsVM;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVM");
        } else {
            aVar2 = aVar4;
        }
        aVar2.o(b.c.f355083a);
        if (zh()) {
            Hh();
        }
        ((IChatsUtil) QRoute.api(IChatsUtil.class)).enterOrExitMsgList(7, 1);
        return root;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Eh(MiniMsgFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0._uiEvent.mo2003trySendJP2dKIU(h.c.f354355a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fh(MiniMsgFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0._uiEvent.mo2003trySendJP2dKIU(h.d.f354356a);
    }

    private final void Gh() {
        IChatsViewModelCreator iChatsViewModelCreator = (IChatsViewModelCreator) QRoute.api(IChatsViewModelCreator.class);
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        this.mChatsVM = (com.tencent.qqnt.chats.core.mvi.a) iChatsViewModelCreator.createMiniAioViewModel(lifecycleScope, requireContext);
    }

    private final void Hh() {
        final GestureDetector gestureDetector = new GestureDetector(getActivity(), new c());
        ChatsListVB chatsListVB = this.mChatsVB;
        if (chatsListVB == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVB");
            chatsListVB = null;
        }
        chatsListVB.F().setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.qqnt.chats.biz.miniaio.k
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean Ih;
                Ih = MiniMsgFragment.Ih(gestureDetector, view, motionEvent);
                return Ih;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Ih(GestureDetector gestureDetector, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(gestureDetector, "$gestureDetector");
        gestureDetector.onTouchEvent(motionEvent);
        return false;
    }

    private final View createView() {
        return Dh();
    }

    private final pw3.h xh() {
        pw3.h hVar = this._binding;
        Intrinsics.checkNotNull(hVar);
        return hVar;
    }

    private final boolean yh() {
        return ((Boolean) this.mBlockGoToMsgTab.getValue()).booleanValue();
    }

    private final boolean zh() {
        return ((Boolean) this.mIsHorizontal.getValue()).booleanValue();
    }

    @Override // com.tencent.qqnt.chats.biz.miniaio.b
    public void Hb(@NotNull com.tencent.qqnt.chats.biz.miniaio.a event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) event);
            return;
        }
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof h.a) {
            this.mSelectId = -1L;
            com.tencent.qqnt.chats.biz.miniaio.horizontal.d.f354359a.b(-1L);
            ChatsListVB chatsListVB = this.mChatsVB;
            if (chatsListVB == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mChatsVB");
                chatsListVB = null;
            }
            chatsListVB.Y(com.tencent.qqnt.chats.core.adapter.itemdata.payload.f.f354597a);
        }
    }

    @Override // com.tencent.qqnt.chats.biz.miniaio.b
    @NotNull
    public Flow<com.tencent.qqnt.chats.biz.miniaio.a> Va() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Flow) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.uiEvent;
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, this, inflater, container, savedInstanceState);
        }
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Ch();
        Gh();
        createView();
        LinearLayout root = xh().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "mBinding.root");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        ((IChatsUtil) QRoute.api(IChatsUtil.class)).enterOrExitMsgList(7, 2);
        super.onDestroy();
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar = this.mChatsVM;
        ChatsListVB chatsListVB = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVM");
            aVar = null;
        }
        aVar.o(b.d.f355084a);
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar2 = this.mChatsVM;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVM");
            aVar2 = null;
        }
        ChatsListVB chatsListVB2 = this.mChatsVB;
        if (chatsListVB2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVB");
        } else {
            chatsListVB = chatsListVB2;
        }
        aVar2.m(chatsListVB);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onPause();
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar = this.mChatsVM;
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVM");
            aVar = null;
        }
        aVar.o(b.h.f355088a);
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar3 = this.mChatsVM;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVM");
        } else {
            aVar2 = aVar3;
        }
        com.tencent.qqnt.chats.api.b e16 = aVar2.e();
        if (e16 != null) {
            LinearLayout root = xh().getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "mBinding.root");
            e16.u(root);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onResume();
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar = this.mChatsVM;
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVM");
            aVar = null;
        }
        aVar.o(b.i.f355089a);
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar3 = this.mChatsVM;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVM");
        } else {
            aVar2 = aVar3;
        }
        com.tencent.qqnt.chats.api.b e16 = aVar2.e();
        if (e16 != null) {
            LinearLayout root = xh().getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "mBinding.root");
            b.C9561b.a(e16, root, this.refPgId, Integer.valueOf(this.refPgStp), null, 8, null);
        }
    }

    @Override // com.tencent.qqnt.chats.biz.miniaio.b
    @NotNull
    /* renamed from: wh, reason: merged with bridge method [inline-methods] */
    public MiniMsgFragment getFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (MiniMsgFragment) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this;
    }
}
