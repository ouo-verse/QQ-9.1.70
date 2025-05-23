package com.tencent.mobileqq.activity.home.chats;

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.part.Part;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.core.ui.n;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.IAccountCallback;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q3.f;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ac\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 /2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0019BA\u0012\b\b\u0002\u0010R\u001a\u00020L\u0012\b\b\u0002\u0010S\u001a\u00020L\u0012\b\b\u0002\u0010T\u001a\u00020L\u0012\f\u0010U\u001a\b\u0012\u0004\u0012\u00020L0\u0010\u0012\f\u0010V\u001a\b\u0012\u0004\u0012\u00020L0\u0010\u00a2\u0006\u0004\bW\u0010XJ\u001c\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\bH\u0016J\b\u0010\u000f\u001a\u00020\bH\u0016J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0014J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\u0012\u0010\u0016\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0017\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0014H\u0016J\u0010\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0014H\u0016J\u0012\u0010\u001d\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001e\u001a\u00020\bH\u0016J\b\u0010\u001f\u001a\u00020\fH\u0016J\b\u0010!\u001a\u00020 H\u0016J\b\u0010#\u001a\u00020\"H\u0016J\b\u0010%\u001a\u00020$H\u0016J\u0010\u0010(\u001a\u00020\b2\u0006\u0010'\u001a\u00020&H\u0016J\u0018\u0010+\u001a\u00020\b2\u0006\u0010*\u001a\u00020)2\u0006\u0010'\u001a\u00020&H\u0016J\n\u0010-\u001a\u0004\u0018\u00010,H\u0016J\b\u0010/\u001a\u00020.H\u0016J\b\u00100\u001a\u00020\bH\u0016J\b\u00101\u001a\u00020\bH\u0016J\b\u00102\u001a\u00020\bH\u0016J\b\u00103\u001a\u00020\bH\u0016J\u0010\u00106\u001a\u00020.2\u0006\u00105\u001a\u000204H\u0016J\b\u00107\u001a\u00020\bH\u0016J\u0010\u00108\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0014H\u0016J\b\u00109\u001a\u00020\bH\u0016J\u0018\u0010=\u001a\u00020\b2\u0006\u0010;\u001a\u00020:2\u0006\u0010<\u001a\u00020)H\u0016J \u0010@\u001a\u00020\b2\u0006\u0010;\u001a\u00020:2\u0006\u0010>\u001a\u00020)2\u0006\u0010?\u001a\u00020)H\u0016J\b\u0010A\u001a\u00020\bH\u0016J\b\u0010B\u001a\u00020\bH\u0016J\u0012\u0010E\u001a\u00020\b2\b\u0010D\u001a\u0004\u0018\u00010CH\u0016R$\u0010J\u001a\u0012\u0012\u0004\u0012\u00020&0Fj\b\u0012\u0004\u0012\u00020&`G8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u001a\u0010O\u001a\b\u0012\u0004\u0012\u00020L0K8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u001a\u0010Q\u001a\b\u0012\u0004\u0012\u00020L0K8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bP\u0010N\u00a8\u0006Y"}, d2 = {"Lcom/tencent/mobileqq/activity/home/chats/b;", "Lcom/tencent/mobileqq/activity/home/chats/NtBasePartFrame;", "Lmqq/app/IAccountCallback;", "Lcom/tencent/qqnt/chats/biz/main/part/b;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "", "e", "Landroidx/lifecycle/ViewModelStore;", "getViewModelStore", "Landroidx/lifecycle/LifecycleOwner;", "getHostLifecycleOwner", "H", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "Lcom/tencent/biz/richframework/part/Part;", "d", "assembleParts", "Lmqq/app/AppRuntime;", "newRuntime", "onAccountChanged", "onAccountChangeFailed", "app", "a", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lmqq/app/Constants$LogoutReason;", "reason", "onLogout", "L", "getLifecycleOwner", "Landroidx/lifecycle/LifecycleCoroutineScope;", "M9", "Landroidx/lifecycle/ViewModelStoreOwner;", "y", "Landroid/content/Context;", "requireContext", "Lcom/tencent/qqnt/chats/core/ui/n;", "handler", Constants.DEBUG_INFO, "", "index", "Cg", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "E", BdhLogUtil.LogTag.Tag_Req, "M", HippyTKDListViewAdapter.X, "P", "Landroid/os/Message;", "msg", "v", "w", UserInfo.SEX_FEMALE, "g", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", HippyTKDListViewAdapter.SCROLL_STATE, "N", "dx", "dy", "O", "K", "J", "Landroid/content/Intent;", "intent", "u", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/ArrayList;", "backPressList", "", "Lcom/tencent/qqnt/chats/biz/main/part/a;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "priorityPartList", "D", "delayPartList", "titlePart", "chatListPart", "miniProgramPart", "bizPart", "priorityPart", "<init>", "(Lcom/tencent/qqnt/chats/biz/main/part/a;Lcom/tencent/qqnt/chats/biz/main/part/a;Lcom/tencent/qqnt/chats/biz/main/part/a;Ljava/util/List;Ljava/util/List;)V", "qqchat_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class b extends NtBasePartFrame implements IAccountCallback, com.tencent.qqnt.chats.biz.main.part.b {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final List<com.tencent.qqnt.chats.biz.main.part.a> priorityPartList;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final List<com.tencent.qqnt.chats.biz.main.part.a> delayPartList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<n> backPressList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/activity/home/chats/b$a;", "", "", "BOTTOM_PADDING", UserInfo.SEX_FEMALE, "", "TAG", "Ljava/lang/String;", "TOP_PADDING", "<init>", "()V", "qqchat_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.activity.home.chats.b$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21407);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 39)) {
            redirector.redirect((short) 39);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b(@NotNull com.tencent.qqnt.chats.biz.main.part.a titlePart, @NotNull com.tencent.qqnt.chats.biz.main.part.a chatListPart, @NotNull com.tencent.qqnt.chats.biz.main.part.a miniProgramPart, @NotNull List<? extends com.tencent.qqnt.chats.biz.main.part.a> bizPart, @NotNull List<? extends com.tencent.qqnt.chats.biz.main.part.a> priorityPart) {
        List<com.tencent.qqnt.chats.biz.main.part.a> mutableListOf;
        List<com.tencent.qqnt.chats.biz.main.part.a> mutableListOf2;
        Intrinsics.checkNotNullParameter(titlePart, "titlePart");
        Intrinsics.checkNotNullParameter(chatListPart, "chatListPart");
        Intrinsics.checkNotNullParameter(miniProgramPart, "miniProgramPart");
        Intrinsics.checkNotNullParameter(bizPart, "bizPart");
        Intrinsics.checkNotNullParameter(priorityPart, "priorityPart");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, titlePart, chatListPart, miniProgramPart, bizPart, priorityPart);
            return;
        }
        this.backPressList = new ArrayList<>();
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(titlePart, chatListPart);
        Iterator<? extends com.tencent.qqnt.chats.biz.main.part.a> it = priorityPart.iterator();
        while (it.hasNext()) {
            mutableListOf.add(it.next());
        }
        Iterator<com.tencent.qqnt.chats.biz.main.part.a> it5 = mutableListOf.iterator();
        while (it5.hasNext()) {
            it5.next().U9(this);
        }
        this.priorityPartList = mutableListOf;
        mutableListOf2 = CollectionsKt__CollectionsKt.mutableListOf(miniProgramPart);
        Iterator<? extends com.tencent.qqnt.chats.biz.main.part.a> it6 = bizPart.iterator();
        while (it6.hasNext()) {
            mutableListOf2.add(it6.next());
        }
        Iterator<com.tencent.qqnt.chats.biz.main.part.a> it7 = mutableListOf2.iterator();
        while (it7.hasNext()) {
            it7.next().U9(this);
        }
        this.delayPartList = mutableListOf2;
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.b
    public void Cg(int index, @NotNull n handler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, index, (Object) handler);
        } else {
            Intrinsics.checkNotNullParameter(handler, "handler");
            this.backPressList.add(index, handler);
        }
    }

    @Override // com.tencent.mobileqq.activity.home.chats.NtBasePartFrame
    public boolean E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this)).booleanValue();
        }
        Iterator<n> it = this.backPressList.iterator();
        while (it.hasNext()) {
            if (it.next().handleBackPress()) {
                return true;
            }
        }
        return super.D();
    }

    @Override // com.tencent.mobileqq.activity.home.chats.NtBasePartFrame
    public void F(@NotNull AppRuntime app) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) app);
            return;
        }
        Intrinsics.checkNotNullParameter(app, "app");
        QLog.i("chats_moduleMainChatsFragment", 1, "onBeforeAccountChanged");
        Iterator<com.tencent.qqnt.chats.biz.main.part.a> it = this.priorityPartList.iterator();
        while (it.hasNext()) {
            it.next().K9(app);
        }
        if (this.f182864f != null) {
            Iterator<com.tencent.qqnt.chats.biz.main.part.a> it5 = this.delayPartList.iterator();
            while (it5.hasNext()) {
                it5.next().K9(app);
            }
        }
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.b
    public void G4(@NotNull n handler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) handler);
        } else {
            Intrinsics.checkNotNullParameter(handler, "handler");
            this.backPressList.add(handler);
        }
    }

    @Override // com.tencent.mobileqq.activity.home.chats.NtBasePartFrame
    public void H() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.H();
        }
    }

    @Override // com.tencent.mobileqq.activity.home.chats.NtBasePartFrame
    public void J() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this);
            return;
        }
        Iterator<com.tencent.qqnt.chats.biz.main.part.a> it = this.priorityPartList.iterator();
        while (it.hasNext()) {
            it.next().L9();
        }
        if (this.f182864f != null) {
            Iterator<com.tencent.qqnt.chats.biz.main.part.a> it5 = this.delayPartList.iterator();
            while (it5.hasNext()) {
                it5.next().L9();
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.home.chats.NtBasePartFrame
    public void K() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this);
            return;
        }
        Iterator<com.tencent.qqnt.chats.biz.main.part.a> it = this.priorityPartList.iterator();
        while (it.hasNext()) {
            it.next().M9();
        }
        if (this.f182864f != null) {
            Iterator<com.tencent.qqnt.chats.biz.main.part.a> it5 = this.delayPartList.iterator();
            while (it5.hasNext()) {
                it5.next().M9();
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.home.chats.NtBasePartFrame
    public void L() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        super.L();
        Iterator<com.tencent.qqnt.chats.biz.main.part.a> it = this.priorityPartList.iterator();
        while (it.hasNext()) {
            it.next().N9();
        }
        if (this.f182864f != null) {
            Iterator<com.tencent.qqnt.chats.biz.main.part.a> it5 = this.delayPartList.iterator();
            while (it5.hasNext()) {
                it5.next().N9();
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.home.chats.NtBasePartFrame
    public void M() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        Iterator<com.tencent.qqnt.chats.biz.main.part.a> it = this.priorityPartList.iterator();
        while (it.hasNext()) {
            it.next().onPostThemeChanged();
        }
        if (this.f182864f != null) {
            Iterator<com.tencent.qqnt.chats.biz.main.part.a> it5 = this.delayPartList.iterator();
            while (it5.hasNext()) {
                it5.next().onPostThemeChanged();
            }
        }
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.b
    @NotNull
    public LifecycleCoroutineScope M9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (LifecycleCoroutineScope) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        QBaseActivity mHostActivity = this.f182866i;
        Intrinsics.checkNotNullExpressionValue(mHostActivity, "mHostActivity");
        return LifecycleOwnerKt.getLifecycleScope(mHostActivity);
    }

    @Override // com.tencent.mobileqq.activity.home.chats.NtBasePartFrame
    public void N(@NotNull RecyclerView recyclerView, int scrollState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) recyclerView, scrollState);
            return;
        }
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Iterator<com.tencent.qqnt.chats.biz.main.part.a> it = this.priorityPartList.iterator();
        while (it.hasNext()) {
            it.next().O9(recyclerView, scrollState);
        }
        if (this.f182864f != null) {
            Iterator<com.tencent.qqnt.chats.biz.main.part.a> it5 = this.delayPartList.iterator();
            while (it5.hasNext()) {
                it5.next().O9(recyclerView, scrollState);
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.home.chats.NtBasePartFrame
    public void O(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, this, recyclerView, Integer.valueOf(dx5), Integer.valueOf(dy5));
            return;
        }
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Iterator<com.tencent.qqnt.chats.biz.main.part.a> it = this.priorityPartList.iterator();
        while (it.hasNext()) {
            it.next().P9(recyclerView, dx5, dy5);
        }
        if (this.f182864f != null) {
            Iterator<com.tencent.qqnt.chats.biz.main.part.a> it5 = this.delayPartList.iterator();
            while (it5.hasNext()) {
                it5.next().P9(recyclerView, dx5, dy5);
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.home.chats.NtBasePartFrame
    public void P() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
            return;
        }
        Iterator<com.tencent.qqnt.chats.biz.main.part.a> it = this.priorityPartList.iterator();
        while (it.hasNext()) {
            it.next().Q9();
        }
        if (this.f182864f != null) {
            Iterator<com.tencent.qqnt.chats.biz.main.part.a> it5 = this.delayPartList.iterator();
            while (it5.hasNext()) {
                it5.next().Q9();
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.home.chats.NtBasePartFrame
    public void Q(@NotNull AppRuntime app) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) app);
            return;
        }
        Intrinsics.checkNotNullParameter(app, "app");
        QLog.i("chats_moduleMainChatsFragment", 1, "removeObserver");
        Iterator<com.tencent.qqnt.chats.biz.main.part.a> it = this.priorityPartList.iterator();
        while (it.hasNext()) {
            it.next().R9(app);
        }
        Iterator<com.tencent.qqnt.chats.biz.main.part.a> it5 = this.delayPartList.iterator();
        while (it5.hasNext()) {
            it5.next().R9(app);
        }
    }

    @Override // com.tencent.mobileqq.activity.home.chats.NtBasePartFrame
    public void R() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        Iterator<com.tencent.qqnt.chats.biz.main.part.a> it = this.priorityPartList.iterator();
        while (it.hasNext()) {
            it.next().T9();
        }
        if (this.f182864f != null) {
            Iterator<com.tencent.qqnt.chats.biz.main.part.a> it5 = this.delayPartList.iterator();
            while (it5.hasNext()) {
                it5.next().T9();
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.home.chats.NtBasePartFrame
    public void a(@NotNull AppRuntime app) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) app);
            return;
        }
        Intrinsics.checkNotNullParameter(app, "app");
        QLog.i("chats_moduleMainChatsFragment", 1, "addObserver");
        Iterator<com.tencent.qqnt.chats.biz.main.part.a> it = this.priorityPartList.iterator();
        while (it.hasNext()) {
            it.next().A9(app);
        }
        Iterator<com.tencent.qqnt.chats.biz.main.part.a> it5 = this.delayPartList.iterator();
        while (it5.hasNext()) {
            it5.next().A9(app);
        }
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (List) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.delayPartList;
    }

    @Override // com.tencent.mobileqq.activity.home.chats.NtBasePartFrame
    @NotNull
    protected List<Part> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (List) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.priorityPartList;
    }

    @Override // com.tencent.mobileqq.activity.home.chats.NtBasePartFrame
    protected void e(@Nullable LayoutInflater inflater, @Nullable ViewGroup container) {
        View findViewById;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) inflater, (Object) container);
            return;
        }
        if (container == null || (findViewById = this.f182866i.findViewById(R.id.b9o)) == null) {
            return;
        }
        DragFrameLayout dragFrameLayout = (DragFrameLayout) findViewById;
        View findViewById2 = container.findViewById(R.id.yw9);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "container.findViewById(c\u2026i.R.id.main_chats_layout)");
        View findViewById3 = container.findViewById(R.id.yw_);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "container.findViewById(c\u2026in_chats_third_container)");
        View findViewById4 = findViewById2.findViewById(R.id.tug);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "mainChatsLayout.findViewById(R.id.chats_list)");
        RecyclerView recyclerView = (RecyclerView) findViewById4;
        View findViewById5 = findViewById2.findViewById(R.id.f85754pt);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "mainChatsLayout.findView\u2026.qqchat_api.R.id.sk_view)");
        KeyEvent.Callback findViewById6 = findViewById2.findViewById(R.id.f71863pa);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "mainChatsLayout.findView\u2026kit.R.id.recycler_scroll)");
        f fVar = (f) findViewById6;
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById3;
        View findViewById7 = container.findViewById(R.id.j2j);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "container.findViewById(c\u2026hat_api.R.id.statustitle)");
        ViewGroup viewGroup = (ViewGroup) findViewById7;
        int dpToPx = ViewUtils.dpToPx(54.0f);
        int dpToPx2 = ViewUtils.dpToPx(50.0f) + ImmersiveUtils.getStatusBarHeight(requireContext());
        recyclerView.setPadding(0, dpToPx2, 0, dpToPx);
        constraintLayout.setPadding(0, dpToPx2, 0, dpToPx);
        com.tencent.mobileqq.qui.b bVar = com.tencent.mobileqq.qui.b.f276860a;
        bVar.f(recyclerView, dpToPx);
        bVar.f(constraintLayout, dpToPx);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
        marginLayoutParams.topMargin = dpToPx2;
        ((ViewStub) findViewById5).setLayoutParams(marginLayoutParams);
        com.tencent.qqnt.chats.biz.main.a aVar = new com.tencent.qqnt.chats.biz.main.a(container, recyclerView, dragFrameLayout, constraintLayout, (ViewGroup) findViewById2, viewGroup, fVar);
        Iterator<com.tencent.qqnt.chats.biz.main.part.a> it = this.priorityPartList.iterator();
        while (it.hasNext()) {
            it.next().V9(aVar);
        }
        Iterator<com.tencent.qqnt.chats.biz.main.part.a> it5 = this.delayPartList.iterator();
        while (it5.hasNext()) {
            it5.next().V9(aVar);
        }
    }

    @Override // com.tencent.mobileqq.activity.home.chats.NtBasePartFrame
    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this);
            return;
        }
        Iterator<com.tencent.qqnt.chats.biz.main.part.a> it = this.priorityPartList.iterator();
        while (it.hasNext()) {
            it.next().C9();
        }
        if (this.f182864f != null) {
            Iterator<com.tencent.qqnt.chats.biz.main.part.a> it5 = this.delayPartList.iterator();
            while (it5.hasNext()) {
                it5.next().C9();
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    /* renamed from: getHostLifecycleOwner */
    public LifecycleOwner getLifecycleOwner() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (LifecycleOwner) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        QBaseActivity mHostActivity = this.f182866i;
        Intrinsics.checkNotNullExpressionValue(mHostActivity, "mHostActivity");
        return mHostActivity;
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.b
    @NotNull
    public LifecycleOwner getLifecycleOwner() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (LifecycleOwner) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return getLifecycleOwner();
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    @NotNull
    /* renamed from: getViewModelStore */
    public ViewModelStore get_viewModelStore() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ViewModelStore) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        ViewModelStore viewModelStore = this.f182866i.get_viewModelStore();
        Intrinsics.checkNotNullExpressionValue(viewModelStore, "mHostActivity.viewModelStore");
        return viewModelStore;
    }

    @Override // mqq.app.IAccountCallback
    public void onAccountChangeFailed(@Nullable AppRuntime newRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) newRuntime);
            return;
        }
        QLog.i("chats_moduleMainChatsFragment", 1, "onAccountChangeFailed");
        Iterator<com.tencent.qqnt.chats.biz.main.part.a> it = this.priorityPartList.iterator();
        while (it.hasNext()) {
            it.next().onAccountChangeFailed(newRuntime);
        }
        if (this.f182864f != null) {
            Iterator<com.tencent.qqnt.chats.biz.main.part.a> it5 = this.delayPartList.iterator();
            while (it5.hasNext()) {
                it5.next().onAccountChangeFailed(newRuntime);
            }
        }
    }

    @Override // mqq.app.IAccountCallback
    public void onAccountChanged(@Nullable AppRuntime newRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) newRuntime);
            return;
        }
        QLog.i("chats_moduleMainChatsFragment", 1, "onAccountChanged");
        Iterator<com.tencent.qqnt.chats.biz.main.part.a> it = this.priorityPartList.iterator();
        while (it.hasNext()) {
            it.next().onAccountChanged(newRuntime);
        }
        if (this.f182864f != null) {
            Iterator<com.tencent.qqnt.chats.biz.main.part.a> it5 = this.delayPartList.iterator();
            while (it5.hasNext()) {
                it5.next().onAccountChanged(newRuntime);
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.home.chats.NtBasePartFrame
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.onDestroy();
        }
    }

    @Override // mqq.app.IAccountCallback
    public void onLogout(@Nullable Constants.LogoutReason reason) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) reason);
            return;
        }
        QLog.i("chats_moduleMainChatsFragment", 1, "onLogout");
        Iterator<com.tencent.qqnt.chats.biz.main.part.a> it = this.priorityPartList.iterator();
        while (it.hasNext()) {
            it.next().onLogout(reason);
        }
        if (this.f182864f != null) {
            Iterator<com.tencent.qqnt.chats.biz.main.part.a> it5 = this.delayPartList.iterator();
            while (it5.hasNext()) {
                it5.next().T9();
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.home.chats.NtBasePartFrame
    @Nullable
    public String q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (String) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return "chats_moduleMainChatsFragment";
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.b
    @NotNull
    public Context requireContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (Context) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        QBaseActivity mHostActivity = this.f182866i;
        Intrinsics.checkNotNullExpressionValue(mHostActivity, "mHostActivity");
        return mHostActivity;
    }

    @Override // com.tencent.mobileqq.activity.home.chats.NtBasePartFrame
    public void u(@Nullable Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, (Object) intent);
        } else if (intent != null) {
            Iterator<com.tencent.qqnt.chats.biz.main.part.a> it = this.priorityPartList.iterator();
            while (it.hasNext()) {
                it.next().H9(intent);
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.home.chats.NtBasePartFrame
    public boolean v(@NotNull Message msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this, (Object) msg2)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Iterator<com.tencent.qqnt.chats.biz.main.part.a> it = this.priorityPartList.iterator();
        while (it.hasNext()) {
            if (it.next().handleMessage(msg2)) {
                return true;
            }
        }
        if (this.f182864f != null) {
            Iterator<com.tencent.qqnt.chats.biz.main.part.a> it5 = this.delayPartList.iterator();
            while (it5.hasNext()) {
                if (it5.next().handleMessage(msg2)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.activity.home.chats.NtBasePartFrame
    public void w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this);
            return;
        }
        Iterator<com.tencent.qqnt.chats.biz.main.part.a> it = this.priorityPartList.iterator();
        while (it.hasNext()) {
            it.next().I9();
        }
        if (this.f182864f != null) {
            Iterator<com.tencent.qqnt.chats.biz.main.part.a> it5 = this.delayPartList.iterator();
            while (it5.hasNext()) {
                it5.next().I9();
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.home.chats.NtBasePartFrame
    public void x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
            return;
        }
        Iterator<com.tencent.qqnt.chats.biz.main.part.a> it = this.priorityPartList.iterator();
        while (it.hasNext()) {
            it.next().J9();
        }
        if (this.f182864f != null) {
            Iterator<com.tencent.qqnt.chats.biz.main.part.a> it5 = this.delayPartList.iterator();
            while (it5.hasNext()) {
                it5.next().J9();
            }
        }
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.b
    @NotNull
    public ViewModelStoreOwner y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (ViewModelStoreOwner) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this;
    }
}
