package com.tencent.qqnt.chats.biz.main.part;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.quibadge.QUIBadgeDragLayout;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.biz.lightbusiness.lightinteraction.view.LIAAnimView;
import com.tencent.qqnt.chats.api.IChatsDataRepoCreator;
import com.tencent.qqnt.chats.api.IChatsViewModelCreator;
import com.tencent.qqnt.chats.api.b;
import com.tencent.qqnt.chats.biz.guildhelper.GuildFolderGuideHelper;
import com.tencent.qqnt.chats.biz.main.MainChatsListVB;
import com.tencent.qqnt.chats.config.ChatsListConfig;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.core.ui.ChatsListVB;
import com.tencent.qqnt.chats.core.uievent.a;
import com.tencent.qqnt.chats.core.userintent.b;
import com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo;
import com.tencent.qqnt.chats.utils.ChatsColorCache;
import com.tencent.qqnt.trace.perf.AIOPerfMonitorHelper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.util.LogUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\r\b\u0016\u0018\u0000 i2\u00020\u0001:\u0002jkB\u0007\u00a2\u0006\u0004\bg\u0010hJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016J\u0012\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\u0012\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0013\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0014\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0015\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\u0016\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\tJ\u0006\u0010\u001c\u001a\u00020\u0002J\u000e\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018J\b\u0010\u001e\u001a\u00020\u0002H\u0016J\u0006\u0010 \u001a\u00020\u001fJ\u0010\u0010#\u001a\u00020\u00022\b\u0010\"\u001a\u0004\u0018\u00010!J\u0006\u0010$\u001a\u00020\u0002J\u0006\u0010%\u001a\u00020\u0002J\u0006\u0010&\u001a\u00020\u0002J\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020)0(2\u0006\u0010'\u001a\u00020\u0018J\u0006\u0010+\u001a\u00020\u001fJ\u0010\u0010.\u001a\u00020\u00022\u0006\u0010-\u001a\u00020,H\u0016J\u0012\u00100\u001a\u00020\u00022\b\u0010/\u001a\u0004\u0018\u00010,H\u0016J\u0010\u00103\u001a\u00020\u00022\u0006\u00102\u001a\u000201H\u0016R.\u0010=\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u000206048\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010E\u001a\u00020>8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\"\u0010M\u001a\u00020F8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR3\u0010T\u001a\u001e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\t0Nj\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\t`O8\u0006\u00a2\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010SR\u0016\u0010W\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010Y\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010VR\u0016\u0010[\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010VR\u0018\u0010^\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010]R$\u0010f\u001a\u0004\u0018\u00010_8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010e\u00a8\u0006l"}, d2 = {"Lcom/tencent/qqnt/chats/biz/main/part/c;", "Lcom/tencent/qqnt/chats/biz/main/part/a;", "", "ba", "Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;", "repo", "ra", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lmqq/app/AppRuntime;", "newRuntime", "onAccountChanged", "onPostThemeChanged", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "onPartPause", "onPartStop", "onPartDestroy", "M9", "L9", "", "type", "view", "ma", "ta", "ia", "N9", "", "da", "Lcom/tencent/qqnt/chats/core/ui/listener/a;", "chatsListListener", "la", "ca", "scrollToTop", LocaleUtils.L_JAPANESE, "diff", "", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", "aa", "ea", "Landroid/os/Bundle;", "outState", "ha", Constants.FILE_INSTANCE_STATE, "ga", "Landroid/content/Intent;", "intent", "H9", "Lcom/tencent/qqnt/chats/core/mvi/a;", "Lcom/tencent/qqnt/chats/core/uistate/b;", "Lcom/tencent/qqnt/chats/core/userintent/b;", "f", "Lcom/tencent/qqnt/chats/core/mvi/a;", "Y9", "()Lcom/tencent/qqnt/chats/core/mvi/a;", "pa", "(Lcom/tencent/qqnt/chats/core/mvi/a;)V", "mChatsVM", "Lcom/tencent/qqnt/chats/biz/main/MainChatsListVB;", h.F, "Lcom/tencent/qqnt/chats/biz/main/MainChatsListVB;", "X9", "()Lcom/tencent/qqnt/chats/biz/main/MainChatsListVB;", "oa", "(Lcom/tencent/qqnt/chats/biz/main/MainChatsListVB;)V", "mChatsVB", "Lcom/tencent/qqnt/chats/core/adapter/preload/a;", "i", "Lcom/tencent/qqnt/chats/core/adapter/preload/a;", "Z9", "()Lcom/tencent/qqnt/chats/core/adapter/preload/a;", "qa", "(Lcom/tencent/qqnt/chats/core/adapter/preload/a;)V", "mainPreLoader", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/HashMap;", "getInitHeaderView", "()Ljava/util/HashMap;", "initHeaderView", BdhLogUtil.LogTag.Tag_Conn, "Z", "kernelInitCompleteNotify", "D", "isDrawerOpen", "E", "isResumed", UserInfo.SEX_FEMALE, "Ljava/lang/String;", "curAccount", "Lcom/tencent/qqnt/chats/biz/main/part/c$b;", "G", "Lcom/tencent/qqnt/chats/biz/main/part/c$b;", "getFixedHeaderViewProvider", "()Lcom/tencent/qqnt/chats/biz/main/part/c$b;", "na", "(Lcom/tencent/qqnt/chats/biz/main/part/c$b;)V", "fixedHeaderViewProvider", "<init>", "()V", "H", "a", "b", "chats_view_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public class c extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private boolean kernelInitCompleteNotify;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isDrawerOpen;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isResumed;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private String curAccount;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private b fixedHeaderViewProvider;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> mChatsVM;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public MainChatsListVB mChatsVB;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public com.tencent.qqnt.chats.core.adapter.preload.a mainPreLoader;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Integer, View> initHeaderView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chats/biz/main/part/c$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.biz.main.part.c$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/chats/biz/main/part/c$b;", "", "Landroid/content/Context;", "context", "", "", "Landroid/view/View;", "L0", "chats_view_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public interface b {
        @NotNull
        Map<Integer, View> L0(@NotNull Context context);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40065);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 37)) {
            redirector.redirect((short) 37);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.initHeaderView = new HashMap<>();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentUin();
        } else {
            str = null;
        }
        this.curAccount = str;
        AIOPerfMonitorHelper.f362357a.e();
    }

    private final void ba() {
        if (this.kernelInitCompleteNotify) {
            Y9().o(b.e.f355085a);
        }
        for (Map.Entry<Integer, View> entry : this.initHeaderView.entrySet()) {
            X9().p0(entry.getKey().intValue(), entry.getValue());
        }
    }

    public static /* synthetic */ void sa(c cVar, IRecentContactRepo iRecentContactRepo, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                iRecentContactRepo = null;
            }
            cVar.ra(iRecentContactRepo);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setViewModel");
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.a
    public void H9(@NotNull Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) intent);
        } else {
            Intrinsics.checkNotNullParameter(intent, "intent");
            GuildFolderGuideHelper.f354289a.j(intent);
        }
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.a
    public void L9() {
        com.tencent.qqnt.chats.api.b v3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        super.L9();
        this.isDrawerOpen = false;
        if (this.isResumed && (v3 = X9().v()) != null) {
            View rootView = getPartRootView();
            Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
            b.C9561b.a(v3, rootView, null, null, null, 14, null);
        }
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.a
    public void M9() {
        com.tencent.qqnt.chats.api.b v3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        super.M9();
        this.isDrawerOpen = true;
        if (this.isResumed && (v3 = X9().v()) != null) {
            View rootView = getPartRootView();
            Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
            v3.u(rootView);
        }
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.a
    public void N9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
        } else if (this.mChatsVM == null) {
            this.kernelInitCompleteNotify = true;
        } else {
            Y9().o(b.e.f355085a);
        }
    }

    @NotNull
    public final MainChatsListVB X9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (MainChatsListVB) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        MainChatsListVB mainChatsListVB = this.mChatsVB;
        if (mainChatsListVB != null) {
            return mainChatsListVB;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mChatsVB");
        return null;
    }

    @NotNull
    public final com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> Y9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.qqnt.chats.core.mvi.a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar = this.mChatsVM;
        if (aVar != null) {
            return aVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mChatsVM");
        return null;
    }

    @NotNull
    public final com.tencent.qqnt.chats.core.adapter.preload.a Z9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.qqnt.chats.core.adapter.preload.a) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        com.tencent.qqnt.chats.core.adapter.preload.a aVar = this.mainPreLoader;
        if (aVar != null) {
            return aVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mainPreLoader");
        return null;
    }

    @NotNull
    public final List<g> aa(int diff) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (List) iPatchRedirector.redirect((short) 32, (Object) this, diff);
        }
        return X9().I(diff);
    }

    public final void ca() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
        } else {
            X9().O();
        }
    }

    public final boolean da() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this)).booleanValue();
        }
        return X9().V();
    }

    public final boolean ea() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Boolean) iPatchRedirector.redirect((short) 33, (Object) this)).booleanValue();
        }
        return X9().X();
    }

    public void ga(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) savedInstanceState);
        } else {
            X9().g0(savedInstanceState);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    public String getLogTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return "MainChatsTitlePart";
    }

    public void ha(@NotNull Bundle outState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) outState);
        } else {
            Intrinsics.checkNotNullParameter(outState, "outState");
            X9().h0(outState);
        }
    }

    public final void ia(int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, type);
        } else {
            X9().j0(type);
        }
    }

    public final void ja() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
        } else {
            Y9().n(a.p.f355023a);
        }
    }

    public final void la(@Nullable com.tencent.qqnt.chats.core.ui.listener.a chatsListListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) chatsListListener);
        } else {
            X9().o0(chatsListListener);
        }
    }

    public final void ma(int type, @NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, type, (Object) view);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        if (this.mChatsVB != null) {
            X9().p0(type, view);
        } else {
            this.initHeaderView.put(Integer.valueOf(type), view);
        }
    }

    public final void na(@Nullable b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) bVar);
        } else {
            this.fixedHeaderViewProvider = bVar;
        }
    }

    public final void oa(@NotNull MainChatsListVB mainChatsListVB) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) mainChatsListVB);
        } else {
            Intrinsics.checkNotNullParameter(mainChatsListVB, "<set-?>");
            this.mChatsVB = mainChatsListVB;
        }
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.a, mqq.app.IAccountCallback
    public void onAccountChanged(@Nullable AppRuntime newRuntime) {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) newRuntime);
            return;
        }
        String str3 = null;
        if (this.mChatsVM != null) {
            String wrapLogUin = LogUtil.wrapLogUin(this.curAccount);
            if (newRuntime != null) {
                str2 = newRuntime.getCurrentUin();
            } else {
                str2 = null;
            }
            QLog.d("MainChatsListPart", 1, "onAccountChange, old: " + wrapLogUin + ", new: " + LogUtil.wrapLogUin(str2));
            Y9().o(b.g.f355087a);
        }
        String str4 = this.curAccount;
        boolean z16 = false;
        if (str4 != null) {
            if (newRuntime != null) {
                str = newRuntime.getCurrentUin();
            } else {
                str = null;
            }
            if (str4.equals(str)) {
                z16 = true;
            }
        }
        if (!z16) {
            sa(this, null, 1, null);
            X9().h(Y9());
            X9().p();
        }
        Y9().o(b.f.f355086a);
        if (newRuntime != null) {
            str3 = newRuntime.getCurrentUin();
        }
        this.curAccount = str3;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        IRecentContactRepo iRecentContactRepo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        if (this.mChatsVM == null) {
            if (ChatsListConfig.f354433a.e()) {
                iRecentContactRepo = ((IChatsDataRepoCreator) QRoute.api(IChatsDataRepoCreator.class)).getPreloadMainRepo();
            } else {
                iRecentContactRepo = null;
            }
            ra(iRecentContactRepo);
        }
        QLog.i(getLogTag(), 1, "[onInitView] " + Y9().hashCode());
        ChatsColorCache.f355526a.p();
        oa(new MainChatsListVB(Y9(), new defpackage.d()));
        MainChatsListVB X9 = X9();
        RecyclerView a16 = G9().a();
        QUIBadgeDragLayout b16 = G9().b();
        ConstraintLayout f16 = G9().f();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        ChatsListVB.b bVar = new ChatsListVB.b(a16, b16, f16, context, G9().d(), G9().c(), (LIAAnimView) G9().e().findViewById(R.id.tuf), null, 128, null);
        b bVar2 = this.fixedHeaderViewProvider;
        if (bVar2 != null) {
            Context context2 = rootView.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "rootView.context");
            Map<Integer, View> L0 = bVar2.L0(context2);
            if (L0 != null) {
                bVar.d().putAll(L0);
            }
        }
        X9.d0(bVar);
        ViewConfiguration.get(G9().a().getContext());
        com.tencent.qqnt.chats.core.adapter.preload.a aVar = new com.tencent.qqnt.chats.core.adapter.preload.a();
        Context context3 = rootView.getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "rootView.context");
        aVar.c(context3, E9());
        qa(aVar);
        z9(X9());
        Y9().d(X9());
        Y9().o(b.c.f355083a);
        ba();
        com.tencent.qqnt.chats.data.persistent.c.f355136a.d();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) activity);
            return;
        }
        super.onPartDestroy(activity);
        com.tencent.qqnt.chats.data.persistent.c.f355136a.o();
        com.tencent.qqnt.biz.lightbusiness.d.f353112a.e();
        Y9().o(b.d.f355084a);
        Y9().m(X9());
        X9().e0();
        Z9().e();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(@Nullable Activity activity) {
        com.tencent.qqnt.chats.api.b v3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) activity);
            return;
        }
        super.onPartPause(activity);
        X9().f0();
        Y9().o(b.h.f355088a);
        this.isResumed = false;
        if (!this.isDrawerOpen && (v3 = X9().v()) != null) {
            View rootView = getPartRootView();
            Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
            v3.u(rootView);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        com.tencent.qqnt.chats.api.b v3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) activity);
            return;
        }
        super.onPartResume(activity);
        QLog.i(getLogTag(), 1, "[onPartResume] chatsVm=" + Y9().hashCode());
        X9().onResume();
        Y9().o(b.i.f355089a);
        this.isResumed = true;
        if (!this.isDrawerOpen && (v3 = X9().v()) != null) {
            View rootView = getPartRootView();
            Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
            b.C9561b.a(v3, rootView, null, null, null, 14, null);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStop(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) activity);
            return;
        }
        super.onPartStop(activity);
        X9().onStop();
        Y9().o(b.j.f355090a);
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.a
    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            super.onPostThemeChanged();
            X9().b(a.i.f355014a);
        }
    }

    public final void pa(@NotNull com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        } else {
            Intrinsics.checkNotNullParameter(aVar, "<set-?>");
            this.mChatsVM = aVar;
        }
    }

    public final void qa(@NotNull com.tencent.qqnt.chats.core.adapter.preload.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) aVar);
        } else {
            Intrinsics.checkNotNullParameter(aVar, "<set-?>");
            this.mainPreLoader = aVar;
        }
    }

    public final void ra(@Nullable IRecentContactRepo repo) {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) repo);
            return;
        }
        if (this.mChatsVM != null) {
            obj = Integer.valueOf(Y9().hashCode());
        } else {
            obj = "null";
        }
        pa((com.tencent.qqnt.chats.core.mvi.a) ((IChatsViewModelCreator) QRoute.api(IChatsViewModelCreator.class)).createChatsViewModel(E9(), S9(), repo));
        QLog.i(getLogTag(), 1, "[setViewModel] old=" + obj + ", new=" + Y9().hashCode());
        if (this.mChatsVB != null) {
            Y9().p(X9().v());
        }
    }

    public final void scrollToTop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
        } else {
            X9().n0();
        }
    }

    public final void ta() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
        } else if (this.mChatsVB != null) {
            X9().z0();
        }
    }
}
