package com.tencent.mobileqq.aio.msglist.holder.component.msgtail;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.FileMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.msgtail.d;
import com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.g;
import com.tencent.mobileqq.aio.msglist.holder.component.msgtail.ui.AIOEmoReplyAdapter;
import com.tencent.mobileqq.aio.msglist.holder.component.msgtail.ui.MaxWidthRecyclerView;
import com.tencent.mobileqq.aio.msglist.holder.component.msgtail.ui.MsgTailFrameLayout;
import com.tencent.mobileqq.aio.msglist.payload.AIOMsgItemPayloadType;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOEmoReplyApi;
import com.tencent.qqnt.aio.holder.IMsgItemMviUIState;
import com.tencent.qqnt.kernel.nativeinterface.MsgEmojiLikes;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 T2\u00020\u0001:\u0001UB\u000f\u0012\u0006\u00105\u001a\u000202\u00a2\u0006\u0004\bR\u0010SJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\t\u001a\u00020\b2\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J \u0010\u000e\u001a\u00020\b2\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H\u0002J\b\u0010\u000f\u001a\u00020\bH\u0002J\b\u0010\u0010\u001a\u00020\bH\u0002J \u0010\u0011\u001a\u00020\b2\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H\u0002J\u001e\u0010\u0017\u001a\u00020\f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0016\u0010\u0019\u001a\u00020\u00182\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J(\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00022\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H\u0002J\b\u0010\u001d\u001a\u00020\fH\u0002J\b\u0010\u001e\u001a\u00020\fH\u0002J\u0016\u0010\u001f\u001a\u00020\f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J\b\u0010 \u001a\u00020\bH\u0002J\u0010\u0010#\u001a\u00020\b2\u0006\u0010\"\u001a\u00020!H\u0002J&\u0010&\u001a\u00020\b2\u0006\u0010$\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020%2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016J\u0010\u0010)\u001a\u00020\b2\u0006\u0010(\u001a\u00020'H\u0016J\u0010\u0010-\u001a\u00020,2\u0006\u0010+\u001a\u00020*H\u0016J\b\u0010.\u001a\u00020,H\u0016J\u0014\u00101\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020'0/H\u0016R\u0014\u00105\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00108\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010;\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u001b\u0010A\u001a\u00020<8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u001b\u0010F\u001a\u00020B8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bC\u0010>\u001a\u0004\bD\u0010ER#\u0010K\u001a\n G*\u0004\u0018\u00010,0,8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bH\u0010>\u001a\u0004\bI\u0010JR!\u0010Q\u001a\b\u0012\u0004\u0012\u00020M0L8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bN\u0010>\u001a\u0004\bO\u0010P\u00a8\u0006V"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/AIOGeneralMsgTailContentComponent;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/c;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/ui/AIOEmoReplyAdapter;", "y1", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/data/g;", "Lkotlin/collections/ArrayList;", "dataList", "", Constants.BASE_IN_PLUGIN_ID, "N1", "v1", "", "w1", "u1", "M1", "L1", "K1", "", "", "payloads", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "H1", "", "E1", "adapter", "newList", "Q1", "x1", "O1", "J1", "F1", "", "msg", "P1", "position", "Lcom/tencent/aio/data/msglist/a;", "b1", "Lcom/tencent/qqnt/aio/holder/IMsgItemMviUIState;", "state", "g1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "c1", "Lcom/tencent/aio/base/mvvm/b;", "Lcom/tencent/qqnt/aio/holder/a;", "d1", "Landroid/content/Context;", "e", "Landroid/content/Context;", "context", "f", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "aioMsgItem", h.F, "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/ui/AIOEmoReplyAdapter;", "curAdapter", "Lcom/google/android/flexbox/FlexboxLayoutManager;", "i", "Lkotlin/Lazy;", "A1", "()Lcom/google/android/flexbox/FlexboxLayoutManager;", "flexboxLayoutManager", "Landroid/widget/RelativeLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "B1", "()Landroid/widget/RelativeLayout;", "rootContainer", "kotlin.jvm.PlatformType", BdhLogUtil.LogTag.Tag_Conn, "z1", "()Landroid/view/View;", "contentAndReplyView", "", "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/tailitem/processor/a;", "D", "C1", "()Ljava/util/List;", "tailItemsWithCheckers", "<init>", "(Landroid/content/Context;)V", "E", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"ClickableViewAccessibility"})
/* loaded from: classes11.dex */
public final class AIOGeneralMsgTailContentComponent extends com.tencent.mobileqq.aio.msglist.holder.component.c {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy contentAndReplyView;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy tailItemsWithCheckers;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private AIOMsgItem aioMsgItem;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AIOEmoReplyAdapter curAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy flexboxLayoutManager;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy rootContainer;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/AIOGeneralMsgTailContentComponent$a;", "", "", "BUBBLE_MARGIN_DEFAULT", UserInfo.SEX_FEMALE, "BUBBLE_MARGIN_DEFAULT_RIGHT", "BUBBLE_MARGIN_LEFT_FILE", "BUBBLE_MARGIN_LEFT_WITH_FILE_ICON", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.msgtail.AIOGeneralMsgTailContentComponent$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/msgtail/AIOGeneralMsgTailContentComponent$b", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "", "positionStart", "itemCount", "", "onItemRangeChanged", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b extends RecyclerView.AdapterDataObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ AIOEmoReplyAdapter f191234e;

        b(AIOEmoReplyAdapter aIOEmoReplyAdapter) {
            this.f191234e = aIOEmoReplyAdapter;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOGeneralMsgTailContentComponent.this, (Object) aIOEmoReplyAdapter);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int positionStart, int itemCount) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(positionStart), Integer.valueOf(itemCount));
                return;
            }
            AIOGeneralMsgTailContentComponent aIOGeneralMsgTailContentComponent = AIOGeneralMsgTailContentComponent.this;
            AIOMsgItem aIOMsgItem = aIOGeneralMsgTailContentComponent.aioMsgItem;
            if (aIOMsgItem == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioMsgItem");
                aIOMsgItem = null;
            }
            aIOGeneralMsgTailContentComponent.P1("msgSeq:" + aIOMsgItem.getMsgRecord().msgSeq + " ItemRangeChanged: attachToRV:" + AIOGeneralMsgTailContentComponent.this.curAdapter.o0() + " curDataSize:" + this.f191234e.l0().size());
            if (this.f191234e.l0().isEmpty()) {
                AIOGeneralMsgTailContentComponent.this.f1().setVisibility(8);
            } else {
                AIOGeneralMsgTailContentComponent.this.f1().setVisibility(0);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/msgtail/AIOGeneralMsgTailContentComponent$c", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "", "getOldListSize", "getNewListSize", "oldItemPosition", "newItemPosition", "", "areItemsTheSame", "areContentsTheSame", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class c extends DiffUtil.Callback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList<g> f191235a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList<g> f191236b;

        c(ArrayList<g> arrayList, ArrayList<g> arrayList2) {
            this.f191235a = arrayList;
            this.f191236b = arrayList2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) arrayList, (Object) arrayList2);
            }
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(oldItemPosition), Integer.valueOf(newItemPosition))).booleanValue();
            }
            return Intrinsics.areEqual(this.f191235a.get(oldItemPosition), this.f191236b.get(newItemPosition));
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, this, Integer.valueOf(oldItemPosition), Integer.valueOf(newItemPosition))).booleanValue();
            }
            if (this.f191235a.get(oldItemPosition).getType() == this.f191236b.get(newItemPosition).getType()) {
                return true;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getNewListSize() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.f191236b.size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getOldListSize() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.f191235a.size();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62107);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIOGeneralMsgTailContentComponent(@NotNull Context context) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.context = context;
        this.curAdapter = y1();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<FlexboxLayoutManager>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.msgtail.AIOGeneralMsgTailContentComponent$flexboxLayoutManager$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOGeneralMsgTailContentComponent.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FlexboxLayoutManager invoke() {
                Context context2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (FlexboxLayoutManager) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                context2 = AIOGeneralMsgTailContentComponent.this.context;
                FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(context2);
                flexboxLayoutManager.Z(0);
                flexboxLayoutManager.a0(1);
                flexboxLayoutManager.b0(0);
                return flexboxLayoutManager;
            }
        });
        this.flexboxLayoutManager = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<RelativeLayout>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.msgtail.AIOGeneralMsgTailContentComponent$rootContainer$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOGeneralMsgTailContentComponent.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RelativeLayout invoke() {
                Context context2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (RelativeLayout) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                context2 = AIOGeneralMsgTailContentComponent.this.context;
                return new RelativeLayout(context2);
            }
        });
        this.rootContainer = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.msgtail.AIOGeneralMsgTailContentComponent$contentAndReplyView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOGeneralMsgTailContentComponent.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (View) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                Object parent = AIOGeneralMsgTailContentComponent.this.f1().getParent();
                Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
                return ((View) parent).findViewById(R.id.f164907u83);
            }
        });
        this.contentAndReplyView = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(AIOGeneralMsgTailContentComponent$tailItemsWithCheckers$2.INSTANCE);
        this.tailItemsWithCheckers = lazy4;
    }

    private final FlexboxLayoutManager A1() {
        return (FlexboxLayoutManager) this.flexboxLayoutManager.getValue();
    }

    private final RelativeLayout B1() {
        return (RelativeLayout) this.rootContainer.getValue();
    }

    private final List<com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.processor.a> C1() {
        return (List) this.tailItemsWithCheckers.getValue();
    }

    private final void D1(ArrayList<g> dataList) {
        for (com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.processor.a aVar : C1()) {
            AIOMsgItem aIOMsgItem = this.aioMsgItem;
            AIOMsgItem aIOMsgItem2 = null;
            if (aIOMsgItem == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioMsgItem");
                aIOMsgItem = null;
            }
            if (aVar.f(aIOMsgItem)) {
                AIOMsgItem aIOMsgItem3 = this.aioMsgItem;
                if (aIOMsgItem3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("aioMsgItem");
                    aIOMsgItem3 = null;
                }
                P1("msgSeq:" + aIOMsgItem3.getMsgRecord().msgSeq + " show " + Reflection.getOrCreateKotlinClass(aVar.getClass()).getSimpleName());
                AIOMsgItem aIOMsgItem4 = this.aioMsgItem;
                if (aIOMsgItem4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("aioMsgItem");
                    aIOMsgItem4 = null;
                }
                AIOMsgItem aIOMsgItem5 = this.aioMsgItem;
                if (aIOMsgItem5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("aioMsgItem");
                } else {
                    aIOMsgItem2 = aIOMsgItem5;
                }
                dataList.add(0, aVar.b(aIOMsgItem4, aIOMsgItem2.getMsgRecord()));
            }
        }
    }

    private final int E1(List<Object> payloads) {
        boolean z16;
        AIOMsgItem aIOMsgItem = null;
        boolean z17 = false;
        if (payloads.isEmpty()) {
            AIOMsgItem aIOMsgItem2 = this.aioMsgItem;
            if (aIOMsgItem2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioMsgItem");
            } else {
                aIOMsgItem = aIOMsgItem2;
            }
            P1("msgId:" + aIOMsgItem.getMsgRecord().msgId + " handlePayload payload empty");
            return 0;
        }
        AIOMsgItem aIOMsgItem3 = this.aioMsgItem;
        if (aIOMsgItem3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioMsgItem");
        } else {
            aIOMsgItem = aIOMsgItem3;
        }
        P1("msgId:" + aIOMsgItem.getMsgRecord().msgId + " handlePayload payload not empty");
        ArrayList arrayList = new ArrayList();
        for (Object obj : payloads) {
            if (obj instanceof HashMap) {
                arrayList.add(obj);
            }
        }
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (((HashMap) it.next()).get(AIOMsgItemPayloadType.MSG_EMO_REPLY_PAYLOAD) != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    z17 = true;
                    break;
                }
            }
        }
        if (!z17) {
            return 1;
        }
        QLog.d("AIOGeneralMsgTailContentComponent", 1, "hasEmoReplyPayload bindData");
        return 2;
    }

    private final void F1() {
        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.msgtail.b
            @Override // java.lang.Runnable
            public final void run() {
                AIOGeneralMsgTailContentComponent.G1(AIOGeneralMsgTailContentComponent.this);
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G1(AIOGeneralMsgTailContentComponent this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.P1("handleFileItemChange");
        this$0.curAdapter.notifyDataSetChanged();
    }

    private final boolean H1(List<Object> payloads, AIOMsgItem msgItem) {
        int collectionSizeOrDefault;
        List plus;
        boolean z16;
        boolean z17;
        boolean z18;
        List<com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.processor.a> C1 = C1();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(C1, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = C1.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.processor.a) it.next()).e(msgItem, payloads)));
        }
        plus = CollectionsKt___CollectionsKt.plus((Collection<? extends Integer>) ((Collection<? extends Object>) arrayList), Integer.valueOf(E1(payloads)));
        List list = plus;
        boolean z19 = list instanceof Collection;
        boolean z26 = true;
        if (!z19 || !list.isEmpty()) {
            Iterator it5 = list.iterator();
            while (it5.hasNext()) {
                if (((Number) it5.next()).intValue() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    z17 = false;
                    break;
                }
            }
        }
        z17 = true;
        if (z17) {
            return true;
        }
        if (!z19 || !list.isEmpty()) {
            Iterator it6 = list.iterator();
            while (it6.hasNext()) {
                if (((Number) it6.next()).intValue() == 2) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z18) {
                    break;
                }
            }
        }
        z26 = false;
        if (z26) {
            sendIntent(new d.c(msgItem));
            v1();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I1(AIOGeneralMsgTailContentComponent this$0, com.tencent.qqnt.aio.emoreply.h it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        Pair<int[], View> n06 = this$0.curAdapter.n0(it.b());
        it.j(n06.getFirst());
        it.m(n06.getSecond());
        AIOMsgItem aIOMsgItem = this$0.aioMsgItem;
        if (aIOMsgItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioMsgItem");
            aIOMsgItem = null;
        }
        this$0.sendIntent(new d.a(aIOMsgItem, it));
    }

    private final boolean J1(List<Object> payloads) {
        boolean z16;
        ArrayList<HashMap> arrayList = new ArrayList();
        for (Object obj : payloads) {
            if (obj instanceof HashMap) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        for (HashMap hashMap : arrayList) {
            if (hashMap.get(AIOMsgItemPayloadType.FILE_TRANSFER_STATUS_PAYLOAD) == null && hashMap.get(AIOMsgItemPayloadType.RICH_MEDIA_PAYLOAD) == null && hashMap.get(AIOMsgItemPayloadType.SEND_STATUS_PAYLOAD) == null && hashMap.get(AIOMsgItemPayloadType.FILE_TRANSFER_PROGRESS_PAYLOAD) == null && hashMap.get(AIOMsgItemPayloadType.FILE_TRANSFER_END_PAYLOAD) == null) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                return true;
            }
        }
        return false;
    }

    private final void K1(ArrayList<g> dataList) {
        if (!x1()) {
            return;
        }
        AIOMsgItem aIOMsgItem = this.aioMsgItem;
        AIOMsgItem aIOMsgItem2 = null;
        if (aIOMsgItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioMsgItem");
            aIOMsgItem = null;
        }
        long j3 = aIOMsgItem.getMsgRecord().msgSeq;
        AIOMsgItem aIOMsgItem3 = this.aioMsgItem;
        if (aIOMsgItem3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioMsgItem");
            aIOMsgItem3 = null;
        }
        P1("msgSeq:" + j3 + " emojiLikesList size = " + aIOMsgItem3.getMsgRecord().emojiLikesList.size());
        AIOMsgItem aIOMsgItem4 = this.aioMsgItem;
        if (aIOMsgItem4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioMsgItem");
            aIOMsgItem4 = null;
        }
        Intrinsics.checkNotNullExpressionValue(aIOMsgItem4.getMsgRecord().emojiLikesList, "aioMsgItem.msgRecord.emojiLikesList");
        if (!r0.isEmpty()) {
            AIOMsgItem aIOMsgItem5 = this.aioMsgItem;
            if (aIOMsgItem5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioMsgItem");
                aIOMsgItem5 = null;
            }
            ArrayList<MsgEmojiLikes> arrayList = aIOMsgItem5.getMsgRecord().emojiLikesList;
            Intrinsics.checkNotNullExpressionValue(arrayList, "aioMsgItem.msgRecord.emojiLikesList");
            for (MsgEmojiLikes emoji : arrayList) {
                Intrinsics.checkNotNullExpressionValue(emoji, "emoji");
                AIOMsgItem aIOMsgItem6 = this.aioMsgItem;
                if (aIOMsgItem6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("aioMsgItem");
                    aIOMsgItem6 = null;
                }
                com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.b l3 = com.tencent.mobileqq.aio.msglist.holder.component.msgtail.utils.a.l(emoji, aIOMsgItem6.getMsgRecord(), this.curAdapter.m0());
                if (l3.c() >= 0) {
                    dataList.add(l3);
                }
            }
            if (!dataList.isEmpty()) {
                AIOMsgItem aIOMsgItem7 = this.aioMsgItem;
                if (aIOMsgItem7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("aioMsgItem");
                    aIOMsgItem7 = null;
                }
                dataList.add(new com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.a(aIOMsgItem7.getMsgRecord()));
            }
            HashMap hashMap = new HashMap();
            AIOMsgItem aIOMsgItem8 = this.aioMsgItem;
            if (aIOMsgItem8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioMsgItem");
            } else {
                aIOMsgItem2 = aIOMsgItem8;
            }
            hashMap.put("touin", Long.valueOf(aIOMsgItem2.getMsgRecord().senderUin));
            com.tencent.mobileqq.aio.utils.b.q("em_bas_aio_expression_responds_result_area", hashMap);
        }
    }

    private final void L1() {
        float f16;
        RelativeLayout B1 = B1();
        Intrinsics.checkNotNull(B1, "null cannot be cast to non-null type android.view.ViewGroup");
        if (B1.getChildCount() != 0) {
            return;
        }
        MaxWidthRecyclerView maxWidthRecyclerView = new MaxWidthRecyclerView(this.context, null, 0, 6, null);
        maxWidthRecyclerView.setAdapter(this.curAdapter);
        maxWidthRecyclerView.setLayoutManager(A1());
        AIOMsgItem aIOMsgItem = null;
        maxWidthRecyclerView.setItemAnimator(null);
        maxWidthRecyclerView.setFocusable(false);
        RelativeLayout B12 = B1();
        Intrinsics.checkNotNull(B12, "null cannot be cast to non-null type android.view.ViewGroup");
        B12.addView(maxWidthRecyclerView, new RelativeLayout.LayoutParams(-2, -2));
        AIOMsgItem aIOMsgItem2 = this.aioMsgItem;
        if (aIOMsgItem2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioMsgItem");
        } else {
            aIOMsgItem = aIOMsgItem2;
        }
        if (aIOMsgItem instanceof FileMsgItem) {
            f16 = 7.0f;
        } else {
            f16 = 8.0f;
        }
        RelativeLayout B13 = B1();
        Intrinsics.checkNotNull(B13, "null cannot be cast to non-null type android.view.ViewGroup");
        B13.setPadding(x.a(f16), 0, 0, 0);
    }

    private final void M1() {
        float f16;
        RelativeLayout B1 = B1();
        Intrinsics.checkNotNull(B1, "null cannot be cast to non-null type android.view.ViewGroup");
        AIOMsgItem aIOMsgItem = null;
        if (B1.getChildCount() != 0) {
            RelativeLayout B12 = B1();
            Intrinsics.checkNotNull(B12, "null cannot be cast to non-null type android.view.ViewGroup");
            View childAt = B12.getChildAt(0);
            AIOMsgItem aIOMsgItem2 = this.aioMsgItem;
            if (aIOMsgItem2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioMsgItem");
            } else {
                aIOMsgItem = aIOMsgItem2;
            }
            P1("msgseq:" + aIOMsgItem.getMsgRecord().msgSeq + " initSenderUI, already has view:" + childAt);
            return;
        }
        MaxWidthRecyclerView maxWidthRecyclerView = new MaxWidthRecyclerView(this.context, null, 0, 6, null);
        maxWidthRecyclerView.setAdapter(this.curAdapter);
        maxWidthRecyclerView.setLayoutManager(A1());
        maxWidthRecyclerView.setItemAnimator(null);
        maxWidthRecyclerView.setFocusable(false);
        AIOMsgItem aIOMsgItem3 = this.aioMsgItem;
        if (aIOMsgItem3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioMsgItem");
        } else {
            aIOMsgItem = aIOMsgItem3;
        }
        if (aIOMsgItem instanceof FileMsgItem) {
            f16 = -3.0f;
        } else {
            f16 = 0.0f;
        }
        Context context = this.context;
        View contentAndReplyView = z1();
        Intrinsics.checkNotNullExpressionValue(contentAndReplyView, "contentAndReplyView");
        MsgTailFrameLayout msgTailFrameLayout = new MsgTailFrameLayout(context, maxWidthRecyclerView, contentAndReplyView, f16);
        msgTailFrameLayout.addView(maxWidthRecyclerView, new FrameLayout.LayoutParams(-2, -2));
        RelativeLayout B13 = B1();
        Intrinsics.checkNotNull(B13, "null cannot be cast to non-null type android.view.ViewGroup");
        B13.addView(msgTailFrameLayout, new RelativeLayout.LayoutParams(-2, -2));
    }

    private final void N1() {
        AIOMsgItem aIOMsgItem = this.aioMsgItem;
        AIOMsgItem aIOMsgItem2 = null;
        if (aIOMsgItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioMsgItem");
            aIOMsgItem = null;
        }
        if (!aIOMsgItem.isSelf()) {
            if (QLog.isColorLevel()) {
                AIOMsgItem aIOMsgItem3 = this.aioMsgItem;
                if (aIOMsgItem3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("aioMsgItem");
                } else {
                    aIOMsgItem2 = aIOMsgItem3;
                }
                QLog.d("AIOGeneralMsgTailContentComponent", 2, "msgSeq:" + aIOMsgItem2.getMsgRecord().msgSeq + " initReceiverUI");
            }
            L1();
            return;
        }
        if (QLog.isColorLevel()) {
            AIOMsgItem aIOMsgItem4 = this.aioMsgItem;
            if (aIOMsgItem4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioMsgItem");
            } else {
                aIOMsgItem2 = aIOMsgItem4;
            }
            QLog.d("AIOGeneralMsgTailContentComponent", 2, "msgSeq:" + aIOMsgItem2.getMsgRecord().msgSeq + " initSenderUI");
        }
        if (z1() == null) {
            if (QLog.isColorLevel()) {
                QLog.d("AIOGeneralMsgTailContentComponent", 2, "contentAndReplyView = null");
                return;
            }
            return;
        }
        M1();
    }

    private final boolean O1() {
        d.b bVar = new d.b(false, 1, null);
        sendIntent(bVar);
        return bVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P1(String msg2) {
        if (QLog.isDevelopLevel()) {
            QLog.d("AIOGeneralMsgTailContentComponent", 4, msg2);
        }
    }

    private final void Q1(AIOEmoReplyAdapter adapter, ArrayList<g> newList) {
        ArrayList<g> l06 = adapter.l0();
        adapter.t0(newList);
        DiffUtil.calculateDiff(new c(l06, newList), false).dispatchUpdatesTo(adapter);
    }

    private final void u1(ArrayList<g> dataList) {
        RelativeLayout B1 = B1();
        Intrinsics.checkNotNull(B1, "null cannot be cast to non-null type android.view.ViewGroup");
        MsgTailFrameLayout msgTailFrameLayout = null;
        if (B1.getChildCount() == 0) {
            AIOMsgItem aIOMsgItem = this.aioMsgItem;
            if (aIOMsgItem == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioMsgItem");
                aIOMsgItem = null;
            }
            P1("msgseq:" + aIOMsgItem.getMsgRecord().msgSeq + " should init UI");
            N1();
        }
        RelativeLayout B12 = B1();
        Intrinsics.checkNotNull(B12, "null cannot be cast to non-null type android.view.ViewGroup");
        View childAt = B12.getChildAt(0);
        if (childAt instanceof MsgTailFrameLayout) {
            msgTailFrameLayout = (MsgTailFrameLayout) childAt;
        }
        if (msgTailFrameLayout != null) {
            int i3 = 1;
            if (!dataList.isEmpty()) {
                i3 = 2;
            }
            msgTailFrameLayout.setOrderMode(i3);
        }
    }

    private final void v1() {
        ArrayList<g> arrayList = new ArrayList<>();
        D1(arrayList);
        u1(arrayList);
        K1(arrayList);
        AIOMsgItem aIOMsgItem = this.aioMsgItem;
        AIOMsgItem aIOMsgItem2 = null;
        if (aIOMsgItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioMsgItem");
            aIOMsgItem = null;
        }
        P1("msgSeq:" + aIOMsgItem.getMsgRecord().msgSeq + " bindData finished. final dataList: " + arrayList.size());
        if (arrayList.isEmpty()) {
            f1().setVisibility(8);
        } else {
            f1().setVisibility(0);
        }
        AIOMsgItem aIOMsgItem3 = this.aioMsgItem;
        if (aIOMsgItem3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioMsgItem");
        } else {
            aIOMsgItem2 = aIOMsgItem3;
        }
        P1("msgSeq:" + aIOMsgItem2.getMsgRecord().msgSeq + " check rv: " + this.curAdapter.o0());
        Q1(this.curAdapter, arrayList);
    }

    private final boolean w1() {
        boolean z16;
        List<com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.processor.a> C1 = C1();
        if (!(C1 instanceof Collection) || !C1.isEmpty()) {
            for (com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.processor.a aVar : C1) {
                AIOMsgItem aIOMsgItem = this.aioMsgItem;
                if (aIOMsgItem == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("aioMsgItem");
                    aIOMsgItem = null;
                }
                if (aVar.f(aIOMsgItem)) {
                    z16 = true;
                    break;
                }
            }
        }
        z16 = false;
        if (z16 || x1()) {
            return true;
        }
        return false;
    }

    private final boolean x1() {
        boolean z16;
        IAIOEmoReplyApi iAIOEmoReplyApi = (IAIOEmoReplyApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOEmoReplyApi.class);
        AIOMsgItem aIOMsgItem = this.aioMsgItem;
        AIOMsgItem aIOMsgItem2 = null;
        if (aIOMsgItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioMsgItem");
            aIOMsgItem = null;
        }
        if (!iAIOEmoReplyApi.isEmoReplyOpen(aIOMsgItem.getMsgRecord().peerUin)) {
            if (QLog.isColorLevel()) {
                QLog.d("AIOGeneralMsgTailContentComponent", 2, "isEmoReplyOpen false");
            }
            return false;
        }
        AIOMsgItem aIOMsgItem3 = this.aioMsgItem;
        if (aIOMsgItem3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioMsgItem");
            aIOMsgItem3 = null;
        }
        if (aIOMsgItem3.getMsgRecord().chatType != 2) {
            return false;
        }
        AIOMsgItem aIOMsgItem4 = this.aioMsgItem;
        if (aIOMsgItem4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioMsgItem");
            aIOMsgItem4 = null;
        }
        if (com.tencent.mobileqq.aio.utils.d.b0(aIOMsgItem4)) {
            if (QLog.isColorLevel()) {
                QLog.d("AIOGeneralMsgTailContentComponent", 2, "isTogetherForwardDetail");
            }
            return false;
        }
        if (O1()) {
            if (QLog.isColorLevel()) {
                QLog.d("AIOGeneralMsgTailContentComponent", 2, "isFromForwardPreviewAIO");
            }
            return false;
        }
        AIOMsgItem aIOMsgItem5 = this.aioMsgItem;
        if (aIOMsgItem5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioMsgItem");
            aIOMsgItem5 = null;
        }
        if (!com.tencent.mobileqq.aio.msglist.holder.component.msgtail.utils.a.g(aIOMsgItem5)) {
            if (QLog.isColorLevel()) {
                QLog.d("AIOGeneralMsgTailContentComponent", 2, "not in EmoReplyWhiteList");
            }
            return false;
        }
        AIOMsgItem aIOMsgItem6 = this.aioMsgItem;
        if (aIOMsgItem6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioMsgItem");
            aIOMsgItem6 = null;
        }
        ArrayList<MsgEmojiLikes> arrayList = aIOMsgItem6.getMsgRecord().emojiLikesList;
        if (arrayList != null && !arrayList.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            return true;
        }
        if (QLog.isColorLevel()) {
            AIOMsgItem aIOMsgItem7 = this.aioMsgItem;
            if (aIOMsgItem7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioMsgItem");
                aIOMsgItem7 = null;
            }
            QLog.d("AIOGeneralMsgTailContentComponent", 2, "msgseq:" + aIOMsgItem7.getMsgRecord().msgSeq + " emojiLikesList empty");
        }
        if (!this.curAdapter.l0().isEmpty()) {
            if (QLog.isColorLevel()) {
                AIOMsgItem aIOMsgItem8 = this.aioMsgItem;
                if (aIOMsgItem8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("aioMsgItem");
                } else {
                    aIOMsgItem2 = aIOMsgItem8;
                }
                QLog.d("AIOGeneralMsgTailContentComponent", 2, "msgseq:" + aIOMsgItem2.getMsgRecord().msgSeq + " emojiLikesList empty but has other tail item, clear cached data");
            }
            ArrayList<g> arrayList2 = new ArrayList<>();
            Iterator<g> it = this.curAdapter.l0().iterator();
            while (it.hasNext()) {
                g next = it.next();
                if (!(next instanceof com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.a) && !(next instanceof com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.b)) {
                    arrayList2.add(next);
                }
            }
            Q1(this.curAdapter, arrayList2);
        }
        return false;
    }

    private final AIOEmoReplyAdapter y1() {
        AIOEmoReplyAdapter aIOEmoReplyAdapter = new AIOEmoReplyAdapter(new WeakReference(this));
        aIOEmoReplyAdapter.registerAdapterDataObserver(new b(aIOEmoReplyAdapter));
        return aIOEmoReplyAdapter;
    }

    private final View z1() {
        return (View) this.contentAndReplyView.getValue();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(position), msgItem, payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        AIOMsgItem aIOMsgItem = (AIOMsgItem) msgItem;
        this.aioMsgItem = aIOMsgItem;
        boolean H1 = H1(payloads, aIOMsgItem);
        AIOMsgItem aIOMsgItem2 = this.aioMsgItem;
        if (aIOMsgItem2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioMsgItem");
            aIOMsgItem2 = null;
        }
        P1("msgId:" + aIOMsgItem2.getMsgRecord().msgId + " handlePayload needBind=" + H1);
        if (!H1) {
            if (J1(payloads)) {
                F1();
            }
        } else if (w1()) {
            N1();
            v1();
        } else if (!this.curAdapter.l0().isEmpty()) {
            Q1(this.curAdapter, new ArrayList<>());
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    @NotNull
    public View c1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return B1();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c, com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: d1 */
    public com.tencent.aio.base.mvvm.b<com.tencent.qqnt.aio.holder.a, IMsgItemMviUIState> createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.aio.base.mvvm.b) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return new com.tencent.mobileqq.aio.msglist.holder.component.msgtail.c();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c, com.tencent.mvi.mvvm.BaseVB
    /* renamed from: g1 */
    public void handleUIState(@NotNull IMsgItemMviUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof AIOEmoReplySelectState) {
            AIOMsgItem aIOMsgItem = this.aioMsgItem;
            if (aIOMsgItem == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioMsgItem");
                aIOMsgItem = null;
            }
            AIOEmoReplySelectState aIOEmoReplySelectState = (AIOEmoReplySelectState) state;
            if (aIOMsgItem.getMsgRecord().msgId == aIOEmoReplySelectState.d().msgId) {
                QLog.i("AIOGeneralMsgTailContentComponent", 1, "onEmoticonSelected result:" + this.curAdapter.V(aIOEmoReplySelectState.b(), aIOEmoReplySelectState.c(), aIOEmoReplySelectState.d(), aIOEmoReplySelectState.a()));
                return;
            }
            return;
        }
        if (state instanceof AIOEmoReplyRefreshState) {
            AIOEmoReplyRefreshState aIOEmoReplyRefreshState = (AIOEmoReplyRefreshState) state;
            QLog.i("AIOGeneralMsgTailContentComponent", 1, "handle AIOEmoReplyRefreshState  info:" + aIOEmoReplyRefreshState.a());
            com.tencent.qqnt.aio.emoreply.h a16 = aIOEmoReplyRefreshState.a();
            if (a16 != null) {
                this.curAdapter.u0(a16);
            }
            v1();
            final com.tencent.qqnt.aio.emoreply.h a17 = aIOEmoReplyRefreshState.a();
            if (a17 != null) {
                B1().post(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.msgtail.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        AIOGeneralMsgTailContentComponent.I1(AIOGeneralMsgTailContentComponent.this, a17);
                    }
                });
                return;
            }
            return;
        }
        if (state instanceof AIOEmoReplySetVisibleState) {
            this.curAdapter.v0();
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        return f1();
    }
}
