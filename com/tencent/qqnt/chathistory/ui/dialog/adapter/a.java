package com.tencent.qqnt.chathistory.ui.dialog.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.RichTextHelper;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.utils.en;
import com.tencent.mobileqq.vaswebviewplugin.MessageRoamJsPlugin;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.adapter.a;
import com.tencent.qqnt.avatar.AvatarSizeType;
import com.tencent.qqnt.avatar.a;
import com.tencent.qqnt.avatar.b;
import com.tencent.qqnt.avatar.e;
import com.tencent.qqnt.base.widget.RoundRectImageView;
import com.tencent.qqnt.chathistory.api.IMsgMigrationApi;
import com.tencent.qqnt.chathistory.datatracker.HistoryDtReportHelper;
import com.tencent.qqnt.chathistory.ui.dialog.adapter.a;
import com.tencent.qqnt.chathistory.ui.menu.viewmodel.ChatHistorySearchViewModel;
import com.tencent.qqnt.chathistory.util.ExtensionsKt;
import com.tencent.qqnt.chathistory.util.MsgRecordExKt;
import com.tencent.qqnt.chathistory.x2k.g;
import com.tencent.qqnt.kernel.api.IUixConvertAdapterApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0000\u0018\u0000 32\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004789:B\u001f\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\u0006\u0010$\u001a\u00020!\u00a2\u0006\u0004\b5\u00106J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005J\u001e\u0010\u0014\u001a\u00020\n2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0007J\u0016\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0005J\u001c\u0010\u0018\u001a\u00020\n2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0013\u001a\u00020\u0012R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R \u0010*\u001a\b\u0012\u0004\u0012\u00020\u00100%8\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00104\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103\u00a8\u0006;"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/dialog/adapter/a;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "onCreateViewHolder", "holder", "position", "", "onBindViewHolder", "getItemCount", "getItemViewType", "n0", "", "Lcom/tencent/qqnt/chathistory/ui/menu/data/model/b;", "newData", "", "hasMore", "q0", "value", "type", "p0", "m0", "Lcom/tencent/qqnt/chathistory/ui/dialog/adapter/d;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqnt/chathistory/ui/dialog/adapter/d;", "listener", "Lcom/tencent/qqnt/chathistory/ui/menu/viewmodel/ChatHistorySearchViewModel;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqnt/chathistory/ui/menu/viewmodel/ChatHistorySearchViewModel;", "viewModel", "Landroidx/lifecycle/LifecycleCoroutineScope;", "D", "Landroidx/lifecycle/LifecycleCoroutineScope;", "lifecycleScope", "", "E", "Ljava/util/List;", "o0", "()Ljava/util/List;", "searchData", "Lcom/tencent/qqnt/chathistory/ui/dialog/adapter/a$b;", UserInfo.SEX_FEMALE, "Lcom/tencent/qqnt/chathistory/ui/dialog/adapter/a$b;", "footerState", "G", "Z", "needShowMsgMigrationTip", "H", "I", MessageRoamJsPlugin.USERTYPE, "<init>", "(Lcom/tencent/qqnt/chathistory/ui/dialog/adapter/d;Lcom/tencent/qqnt/chathistory/ui/menu/viewmodel/ChatHistorySearchViewModel;Landroidx/lifecycle/LifecycleCoroutineScope;)V", "a", "b", "c", "d", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class a extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    static IPatchRedirector $redirector_;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final ChatHistorySearchViewModel viewModel;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final LifecycleCoroutineScope lifecycleScope;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final List<com.tencent.qqnt.chathistory.ui.menu.data.model.b> searchData;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private b footerState;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean needShowMsgMigrationTip;

    /* renamed from: H, reason: from kotlin metadata */
    private int userType;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.chathistory.ui.dialog.adapter.d listener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/dialog/adapter/a$a;", "", "", "item_Data", "I", "item_footer", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chathistory.ui.dialog.adapter.a$a, reason: collision with other inner class name and from kotlin metadata */
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
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/dialog/adapter/a$b;", "", "<init>", "()V", "a", "b", "c", "Lcom/tencent/qqnt/chathistory/ui/dialog/adapter/a$b$a;", "Lcom/tencent/qqnt/chathistory/ui/dialog/adapter/a$b$b;", "Lcom/tencent/qqnt/chathistory/ui/dialog/adapter/a$b$c;", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static abstract class b {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/dialog/adapter/a$b$a;", "Lcom/tencent/qqnt/chathistory/ui/dialog/adapter/a$b;", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.qqnt.chathistory.ui.dialog.adapter.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes23.dex */
        public static final class C9528a extends b {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            @NotNull
            public static final C9528a f353415a;

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39609);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 2)) {
                    redirector.redirect((short) 2);
                } else {
                    f353415a = new C9528a();
                }
            }

            C9528a() {
                super(null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/dialog/adapter/a$b$b;", "Lcom/tencent/qqnt/chathistory/ui/dialog/adapter/a$b;", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.qqnt.chathistory.ui.dialog.adapter.a$b$b, reason: collision with other inner class name */
        /* loaded from: classes23.dex */
        public static final class C9529b extends b {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            @NotNull
            public static final C9529b f353416a;

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39636);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 2)) {
                    redirector.redirect((short) 2);
                } else {
                    f353416a = new C9529b();
                }
            }

            C9529b() {
                super(null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/dialog/adapter/a$b$c;", "Lcom/tencent/qqnt/chathistory/ui/dialog/adapter/a$b;", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes23.dex */
        public static final class c extends b {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            @NotNull
            public static final c f353417a;

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39639);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 2)) {
                    redirector.redirect((short) 2);
                } else {
                    f353417a = new c();
                }
            }

            c() {
                super(null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/dialog/adapter/a$c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "o", "Lcom/tencent/qqnt/chathistory/ui/dialog/adapter/a$b;", "footerState", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqnt/chathistory/x2k/c;", "E", "Lcom/tencent/qqnt/chathistory/x2k/c;", ParseCommon.CONTAINER, "Landroid/widget/ProgressBar;", UserInfo.SEX_FEMALE, "Landroid/widget/ProgressBar;", "progressBar", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "footerTip", "H", "msgMigrationTips", "<init>", "(Lcom/tencent/qqnt/chathistory/ui/dialog/adapter/a;Lcom/tencent/qqnt/chathistory/x2k/c;)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public final class c extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final com.tencent.qqnt.chathistory.x2k.c container;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final ProgressBar progressBar;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private final TextView footerTip;

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private final TextView msgMigrationTips;
        final /* synthetic */ a I;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull a aVar, com.tencent.qqnt.chathistory.x2k.c container) {
            super(container.getMContainer());
            Intrinsics.checkNotNullParameter(container, "container");
            this.I = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar, (Object) container);
                return;
            }
            this.container = container;
            this.progressBar = container.h();
            this.footerTip = container.f();
            this.msgMigrationTips = container.g();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void p(c this$0, a this$1, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            a.Companion companion = com.tencent.qqnt.aio.adapter.a.INSTANCE;
            ((IMsgMigrationApi) companion.a(IMsgMigrationApi.class)).triggerToMigration(this$0.container.e());
            IMsgMigrationApi.a.a((IMsgMigrationApi) companion.a(IMsgMigrationApi.class), "0X800C4DD", this$1.userType, 0, null, null, null, null, 124, null);
            EventCollector.getInstance().onViewClicked(view);
        }

        public final void m(@Nullable b footerState) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) footerState);
                return;
            }
            if (Intrinsics.areEqual(footerState, b.C9529b.f353416a)) {
                this.progressBar.setVisibility(0);
                this.footerTip.setVisibility(8);
                this.msgMigrationTips.setVisibility(8);
            } else if (Intrinsics.areEqual(footerState, b.C9528a.f353415a)) {
                this.progressBar.setVisibility(8);
                this.footerTip.setVisibility(0);
                this.msgMigrationTips.setVisibility(8);
            } else if (Intrinsics.areEqual(footerState, b.c.f353417a)) {
                this.progressBar.setVisibility(8);
                this.footerTip.setVisibility(8);
                this.msgMigrationTips.setVisibility(0);
                QRouteApi api = QRoute.api(IMsgMigrationApi.class);
                Intrinsics.checkNotNullExpressionValue(api, "api(IMsgMigrationApi::class.java)");
                IMsgMigrationApi.a.a((IMsgMigrationApi) api, "0X800C4DC", this.I.userType, 0, null, null, null, null, 124, null);
            }
        }

        public final void o() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            String string = this.container.e().getResources().getString(R.string.f168392fi);
            Intrinsics.checkNotNullExpressionValue(string, "container.context.resour\u2026.msg_migration_tips_jump)");
            String string2 = this.container.e().getResources().getString(R.string.f168382fh);
            Intrinsics.checkNotNullExpressionValue(string2, "container.context.resour\u2026g_migration_tips_content)");
            ArrayList arrayList = new ArrayList();
            final a aVar = this.I;
            arrayList.add(new RichTextHelper.RichTextData(string, new View.OnClickListener() { // from class: com.tencent.qqnt.chathistory.ui.dialog.adapter.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    a.c.p(a.c.this, aVar, view);
                }
            }, true));
            this.msgMigrationTips.setText(RichTextHelper.buildSpannable(string2, this.container.e(), false, arrayList));
            this.msgMigrationTips.setMovementMethod(RichTextHelper.getMovementMethodInstance());
            this.msgMigrationTips.setTextColor(this.container.e().getResources().getColorStateList(R.color.qui_common_text_secondary));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007R\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0014\u0010\u0003\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0017\u00a8\u0006 "}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/dialog/adapter/a$d;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "time", "", "o", "p", "Lcom/tencent/qqnt/chathistory/ui/menu/data/model/b;", "data", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqnt/chathistory/ui/dialog/adapter/a;", "E", "Lcom/tencent/qqnt/chathistory/ui/dialog/adapter/a;", "getAdapter", "()Lcom/tencent/qqnt/chathistory/ui/dialog/adapter/a;", "adapter", "Lcom/tencent/qqnt/base/widget/RoundRectImageView;", UserInfo.SEX_FEMALE, "Lcom/tencent/qqnt/base/widget/RoundRectImageView;", "heaView", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "nickName", "H", "summary", "I", "Landroid/view/View;", "itemView", "<init>", "(Lcom/tencent/qqnt/chathistory/ui/dialog/adapter/a;Landroid/view/View;Lcom/tencent/qqnt/chathistory/ui/dialog/adapter/a;)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public final class d extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final a adapter;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final RoundRectImageView heaView;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private final TextView nickName;

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private final TextView summary;

        /* renamed from: I, reason: from kotlin metadata */
        @NotNull
        private final TextView time;
        final /* synthetic */ a J;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@NotNull a aVar, @NotNull View itemView, a adapter) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            Intrinsics.checkNotNullParameter(adapter, "adapter");
            this.J = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, aVar, itemView, adapter);
                return;
            }
            this.adapter = adapter;
            View findViewById = itemView.findViewById(R.id.icon);
            RoundRectImageView roundRectImageView = (RoundRectImageView) findViewById;
            roundRectImageView.setCornerRadiusAndMode(com.tencent.qqnt.util.view.b.f362999a.b(20), 1);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById<Ro\u2026eView.MODE_ALL)\n        }");
            this.heaView = roundRectImageView;
            View findViewById2 = itemView.findViewById(R.id.text1);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.text1)");
            this.nickName = (TextView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.text2);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.text2)");
            this.summary = (TextView) findViewById3;
            View findViewById4 = itemView.findViewById(R.id.lastMsgTime);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.lastMsgTime)");
            this.time = (TextView) findViewById4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n(com.tencent.qqnt.chathistory.ui.menu.data.model.b data, a this$0, View it) {
            Map<String, Object> mutableMapOf;
            EventCollector.getInstance().onViewClickedBefore(it);
            Intrinsics.checkNotNullParameter(data, "$data");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            HistoryDtReportHelper a16 = HistoryDtReportHelper.INSTANCE.a();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("result_message_type", Integer.valueOf(data.g().msgRecord.msgType)), TuplesKt.to("number_search_results", Integer.valueOf(this$0.o0().size())));
            a16.m(it, "em_bas_search_result_entry", mutableMapOf);
            this$0.listener.i4(data);
            EventCollector.getInstance().onViewClicked(it);
        }

        private final String o(long time) {
            boolean contains$default;
            String timePrefix = en.p(time, true, TuxDateStringUtils.TUX_COMMON_DATE_FORMAT);
            Intrinsics.checkNotNullExpressionValue(timePrefix, "timePrefix");
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) timePrefix, (CharSequence) ":", false, 2, (Object) null);
            if (contains$default) {
                return timePrefix;
            }
            return timePrefix + " " + p(time);
        }

        private final String p(long time) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(time);
            int i3 = calendar.get(11);
            int i16 = calendar.get(12);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i3), Integer.valueOf(i16)}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            return format;
        }

        public final void m(@NotNull final com.tencent.qqnt.chathistory.ui.menu.data.model.b data) {
            boolean z16;
            long j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) data);
                return;
            }
            Intrinsics.checkNotNullParameter(data, "data");
            MsgRecordExKt.f(this.nickName, ExtensionsKt.i(data.g()), com.tencent.qqnt.emotion.constant.b.b());
            CharSequence text = this.nickName.getText();
            Intrinsics.checkNotNullExpressionValue(text, "nickName.text");
            if (text.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                TextView textView = this.nickName;
                int M1 = this.J.viewModel.M1();
                MsgRecord msgRecord = data.g().msgRecord;
                Intrinsics.checkNotNullExpressionValue(msgRecord, "data.searchMsgItem.msgRecord");
                MsgRecordExKt.e(textView, M1, msgRecord, this.J.lifecycleScope, 0, 8, null);
            }
            if (data.h() == null) {
                data.i(ExtensionsKt.t(data.g(), this.J.viewModel.M1(), data.f()));
            }
            this.summary.setText(data.h());
            this.time.setText(o(data.g().msgTime * 1000));
            b.Companion companion = com.tencent.qqnt.avatar.b.INSTANCE;
            b.a aVar = new b.a();
            aVar.g(AvatarSizeType.SMALL);
            aVar.f(0);
            com.tencent.qqnt.avatar.b a16 = aVar.a();
            if (data.g().senderUin == 0) {
                IUixConvertAdapterApi iUixConvertAdapterApi = (IUixConvertAdapterApi) QRoute.api(IUixConvertAdapterApi.class);
                String str = data.g().senderUid;
                Intrinsics.checkNotNullExpressionValue(str, "data.searchMsgItem.senderUid");
                j3 = iUixConvertAdapterApi.getUinFromUid(str);
            } else {
                j3 = data.g().senderUin;
            }
            long j16 = j3;
            a.Companion companion2 = com.tencent.qqnt.avatar.a.INSTANCE;
            Context context = this.heaView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "heaView.context");
            e e16 = companion2.b(context).b(this.heaView).e(a16);
            String str2 = data.g().senderUid;
            Intrinsics.checkNotNullExpressionValue(str2, "data.searchMsgItem.senderUid");
            e.a.b(e16, str2, j16, null, 4, null);
            View view = this.itemView;
            final a aVar2 = this.J;
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.chathistory.ui.dialog.adapter.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    a.d.n(com.tencent.qqnt.chathistory.ui.menu.data.model.b.this, aVar2, view2);
                }
            });
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39660);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a(@NotNull com.tencent.qqnt.chathistory.ui.dialog.adapter.d listener, @NotNull ChatHistorySearchViewModel viewModel, @NotNull LifecycleCoroutineScope lifecycleScope) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(lifecycleScope, "lifecycleScope");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, listener, viewModel, lifecycleScope);
            return;
        }
        this.listener = listener;
        this.viewModel = viewModel;
        this.lifecycleScope = lifecycleScope;
        this.searchData = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        int size = this.searchData.size();
        if (this.footerState == null) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        return size + i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, position)).intValue();
        }
        if (position + 1 > this.searchData.size()) {
            return 1;
        }
        return 0;
    }

    public final void m0(@NotNull List<com.tencent.qqnt.chathistory.ui.menu.data.model.b> newData, boolean hasMore) {
        b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, newData, Boolean.valueOf(hasMore));
            return;
        }
        Intrinsics.checkNotNullParameter(newData, "newData");
        if (this.footerState != null) {
            notifyItemRemoved(this.searchData.size());
        }
        if (hasMore) {
            bVar = b.C9529b.f353416a;
        } else if (this.needShowMsgMigrationTip) {
            bVar = b.c.f353417a;
        } else {
            bVar = b.C9528a.f353415a;
        }
        this.footerState = bVar;
        int size = this.searchData.size();
        this.searchData.addAll(newData);
        notifyItemRangeInserted(size, newData.size());
    }

    public final int n0(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, position)).intValue();
        }
        if (getItemViewType(position) == 1) {
            return -1;
        }
        return this.searchData.get(position).g().msgRecord.msgType;
    }

    @NotNull
    public final List<com.tencent.qqnt.chathistory.ui.menu.data.model.b> o0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.searchData;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) holder, position);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof d) {
            ((d) holder).m(this.searchData.get(position));
        }
        if (holder instanceof c) {
            ((c) holder).m(this.footerState);
            if (Intrinsics.areEqual(this.footerState, b.C9529b.f353416a)) {
                this.listener.s();
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (RecyclerView.ViewHolder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) parent, viewType);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            Context context = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "parent.context");
            return new d(this, new g(context, null, 2, null).getMContainer(), this);
        }
        Context context2 = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "parent.context");
        c cVar = new c(this, new com.tencent.qqnt.chathistory.x2k.c(context2, null, 2, null));
        cVar.o();
        return cVar;
    }

    public final void p0(boolean value, int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Boolean.valueOf(value), Integer.valueOf(type));
        } else {
            this.needShowMsgMigrationTip = value;
            this.userType = type;
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void q0(@NotNull List<com.tencent.qqnt.chathistory.ui.menu.data.model.b> newData, boolean hasMore) {
        b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, newData, Boolean.valueOf(hasMore));
            return;
        }
        Intrinsics.checkNotNullParameter(newData, "newData");
        this.searchData.clear();
        this.searchData.addAll(newData);
        if (this.searchData.isEmpty()) {
            bVar = null;
        } else if (hasMore) {
            bVar = b.C9529b.f353416a;
        } else if (this.needShowMsgMigrationTip) {
            bVar = b.c.f353417a;
        } else {
            bVar = b.C9528a.f353415a;
        }
        this.footerState = bVar;
        notifyDataSetChanged();
    }
}
