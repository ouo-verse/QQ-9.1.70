package com.tencent.mobileqq.guild.inbox.centerpanel.income;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.richframework.compat.RFWImmersiveUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.api.IGuildWebApi;
import com.tencent.mobileqq.guild.message.directmessage.model.data.InboxNoticeNode;
import com.tencent.mobileqq.guild.message.directmessage.model.repositories.InboxNoticeNodeRepository;
import com.tencent.mobileqq.guild.message.directmessage.model.repositories.m;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.bz;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.guild.widget.OverScrollRecyclerViewWithHeaderFooter;
import com.tencent.mobileqq.guild.widget.RecyclerViewWithHeaderFooter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGProSession;
import com.tencent.mobileqq.qqguildsdk.data.co;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProContact;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGuildOperateCallback;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import oh1.DrawableType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vp1.cm;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a3\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f*\u0001\u0011\u0018\u0000 T2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001UB\u0013\b\u0016\u0012\b\u0010P\u001a\u0004\u0018\u00010/\u00a2\u0006\u0004\bQ\u0010RB\t\b\u0016\u00a2\u0006\u0004\bQ\u0010SJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J \u0010\u0010\u001a\u00020\u00042\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eH\u0002J\u000f\u0010\u0012\u001a\u00020\u0011H\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u0004H\u0002J\b\u0010\u0018\u001a\u00020\u0004H\u0002J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J$\u0010\"\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\b\u0010$\u001a\u00020#H\u0016J\b\u0010%\u001a\u00020\u0004H\u0016J\u0016\u0010)\u001a\u00020\u00042\f\u0010(\u001a\b\u0012\u0004\u0012\u00020'0&H\u0016J\u0006\u0010*\u001a\u00020\u0004J\b\u0010+\u001a\u00020#H\u0016J\u0010\u0010.\u001a\u00020\u00042\u0006\u0010-\u001a\u00020,H\u0016R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00109\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u001c\u0010B\u001a\b\u0012\u0004\u0012\u00020?0>8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010E\u001a\u00020?8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u001d\u0010O\u001a\u0004\u0018\u00010J8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\u00a8\u0006V"}, d2 = {"Lcom/tencent/mobileqq/guild/inbox/centerpanel/income/GuildNoticeIncomeFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "Lcom/tencent/mobileqq/guild/message/directmessage/model/repositories/m;", "", "Ch", "initView", "initViewModel", "initTitleBar", "Jh", "Lh", "Mh", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqguildsdk/data/co;", "Lkotlin/collections/ArrayList;", "notices", "Gh", "com/tencent/mobileqq/guild/inbox/centerpanel/income/GuildNoticeIncomeFragment$b", "Eh", "()Lcom/tencent/mobileqq/guild/inbox/centerpanel/income/GuildNoticeIncomeFragment$b;", "", "url", "Ih", "Qh", "Th", "Landroid/view/View;", "root", "Kh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreateView", "", "onBackEvent", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "Lcom/tencent/mobileqq/guild/message/directmessage/model/data/b;", "list", "d9", "Sh", "needImmersive", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "initWindowStyleAndAnimation", "Lcom/tencent/mobileqq/guild/mainframe/i;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/mainframe/i;", "mainViewContext", "Lvp1/cm;", "D", "Lvp1/cm;", "binding", "E", "Landroid/view/View;", "mLoadingView", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "mNoMoreContentView", "Lcom/tencent/mobileqq/guild/widget/RecyclerViewWithHeaderFooter$c;", "Lcom/tencent/mobileqq/guild/inbox/centerpanel/income/GuildIncomeNoticeAdapter;", "G", "Lcom/tencent/mobileqq/guild/widget/RecyclerViewWithHeaderFooter$c;", "mFooterAdapter", "H", "Lcom/tencent/mobileqq/guild/inbox/centerpanel/income/GuildIncomeNoticeAdapter;", "mAdapter", "Lcom/tencent/mobileqq/guild/inbox/centerpanel/income/f;", "I", "Lcom/tencent/mobileqq/guild/inbox/centerpanel/income/f;", "mViewModel", "", "J", "Lkotlin/Lazy;", "Fh", "()Ljava/lang/Integer;", "fragmentType", "mainContext", "<init>", "(Lcom/tencent/mobileqq/guild/mainframe/i;)V", "()V", "K", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildNoticeIncomeFragment extends QPublicBaseFragment implements m {

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.guild.mainframe.i mainViewContext;

    /* renamed from: D, reason: from kotlin metadata */
    private cm binding;

    /* renamed from: E, reason: from kotlin metadata */
    private View mLoadingView;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView mNoMoreContentView;

    /* renamed from: G, reason: from kotlin metadata */
    private RecyclerViewWithHeaderFooter.c<GuildIncomeNoticeAdapter> mFooterAdapter;

    /* renamed from: H, reason: from kotlin metadata */
    private GuildIncomeNoticeAdapter mAdapter;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private f mViewModel = new f();

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy fragmentType;

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/inbox/centerpanel/income/GuildNoticeIncomeFragment$a;", "", "Landroid/content/Context;", "context", "", "b", "Lcom/tencent/mobileqq/guild/mainframe/i;", "mainViewContext", "Lcom/tencent/mobileqq/guild/inbox/centerpanel/income/GuildNoticeIncomeFragment;", "a", "", "FRAG_TYPE_IN_MAIN_FRAME_PANEL", "I", "FRAG_TYPE_SINGLE_PAGE", "", "KEY_FRAG_TYPE", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.inbox.centerpanel.income.GuildNoticeIncomeFragment$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final GuildNoticeIncomeFragment a(@NotNull com.tencent.mobileqq.guild.mainframe.i mainViewContext) {
            Intrinsics.checkNotNullParameter(mainViewContext, "mainViewContext");
            GuildNoticeIncomeFragment guildNoticeIncomeFragment = new GuildNoticeIncomeFragment(mainViewContext);
            Bundle bundle = new Bundle();
            bundle.putInt("key_fragment_type", 1);
            guildNoticeIncomeFragment.setArguments(bundle);
            return guildNoticeIncomeFragment;
        }

        public final void b(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            Bundle bundle = new Bundle();
            bundle.putInt("key_fragment_type", 2);
            intent.putExtras(bundle);
            QPublicFragmentActivity.b.b(context, intent, QPublicFragmentActivity.class, GuildNoticeIncomeFragment.class);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/inbox/centerpanel/income/GuildNoticeIncomeFragment$b", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (newState != 0) {
                return;
            }
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (!(layoutManager instanceof LinearLayoutManager)) {
                return;
            }
            int findLastVisibleItemPosition = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
            GuildIncomeNoticeAdapter guildIncomeNoticeAdapter = GuildNoticeIncomeFragment.this.mAdapter;
            TextView textView = null;
            if (guildIncomeNoticeAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                guildIncomeNoticeAdapter = null;
            }
            if (guildIncomeNoticeAdapter.getNUM_BACKGOURND_ICON() - findLastVisibleItemPosition < 10 && !GuildNoticeIncomeFragment.this.mViewModel.getMIsEnd()) {
                GuildNoticeIncomeFragment.this.mViewModel.loadMore();
                return;
            }
            if (GuildNoticeIncomeFragment.this.mViewModel.getMIsEnd()) {
                TextView textView2 = GuildNoticeIncomeFragment.this.mNoMoreContentView;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNoMoreContentView");
                } else {
                    textView = textView2;
                }
                textView.setVisibility(0);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c<T> implements Observer {
        public c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            ArrayList it = (ArrayList) t16;
            GuildNoticeIncomeFragment guildNoticeIncomeFragment = GuildNoticeIncomeFragment.this;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            guildNoticeIncomeFragment.Gh(it);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d<T> implements Observer {
        public d() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            int i3;
            Boolean it = (Boolean) t16;
            View view = GuildNoticeIncomeFragment.this.mLoadingView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLoadingView");
                view = null;
            }
            Intrinsics.checkNotNullExpressionValue(it, "it");
            if (it.booleanValue()) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view.setVisibility(i3);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class e<T> implements Observer {
        public e() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            Boolean it = (Boolean) t16;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            cm cmVar = null;
            if (it.booleanValue()) {
                cm cmVar2 = GuildNoticeIncomeFragment.this.binding;
                if (cmVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    cmVar = cmVar2;
                }
                cmVar.f442733d.setVisibility(0);
                return;
            }
            cm cmVar3 = GuildNoticeIncomeFragment.this.binding;
            if (cmVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                cmVar = cmVar3;
            }
            cmVar.f442733d.setVisibility(8);
        }
    }

    public GuildNoticeIncomeFragment(@Nullable com.tencent.mobileqq.guild.mainframe.i iVar) {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.guild.inbox.centerpanel.income.GuildNoticeIncomeFragment$fragmentType$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Integer invoke() {
                Bundle arguments = GuildNoticeIncomeFragment.this.getArguments();
                if (arguments != null) {
                    return Integer.valueOf(arguments.getInt("key_fragment_type", -1));
                }
                return null;
            }
        });
        this.fragmentType = lazy;
        this.mainViewContext = iVar;
    }

    private final void Ch() {
        uh2.c gProGuildMsgService = ((IGProSession) bz.b(IGProSession.class)).getGProGuildMsgService();
        if (gProGuildMsgService != null) {
            gProGuildMsgService.clearGuildReadSceneV2(new GProContact(62, "101", "101"), 11, new IGuildOperateCallback() { // from class: com.tencent.mobileqq.guild.inbox.centerpanel.income.k
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGuildOperateCallback
                public final void onResult(int i3, String str) {
                    GuildNoticeIncomeFragment.Dh(i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Dh(int i3, String str) {
        QLog.e("Guild.C2C.GuildNoticeIncomeFragment", 1, "clearUnread: result = " + i3 + ", errMsg = " + str);
    }

    private final b Eh() {
        return new b();
    }

    private final Integer Fh() {
        return (Integer) this.fragmentType.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Gh(ArrayList<co> notices) {
        int i3 = 8;
        GuildIncomeNoticeAdapter guildIncomeNoticeAdapter = null;
        if (notices.isEmpty()) {
            cm cmVar = this.binding;
            if (cmVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                cmVar = null;
            }
            cmVar.f442735f.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.inbox.centerpanel.income.g
                @Override // java.lang.Runnable
                public final void run() {
                    GuildNoticeIncomeFragment.Hh(GuildNoticeIncomeFragment.this);
                }
            }, 1000L);
        } else {
            cm cmVar2 = this.binding;
            if (cmVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                cmVar2 = null;
            }
            LinearLayout linearLayout = cmVar2.f442735f;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.guildNoticePlaceholderLayout");
            linearLayout.setVisibility(8);
        }
        cm cmVar3 = this.binding;
        if (cmVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cmVar3 = null;
        }
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter = cmVar3.f442731b;
        Intrinsics.checkNotNullExpressionValue(overScrollRecyclerViewWithHeaderFooter, "binding.guildIncomeNoticeList");
        if (!notices.isEmpty()) {
            i3 = 0;
        }
        overScrollRecyclerViewWithHeaderFooter.setVisibility(i3);
        GuildIncomeNoticeAdapter guildIncomeNoticeAdapter2 = this.mAdapter;
        if (guildIncomeNoticeAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
        } else {
            guildIncomeNoticeAdapter = guildIncomeNoticeAdapter2;
        }
        guildIncomeNoticeAdapter.setData(notices);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hh(GuildNoticeIncomeFragment this$0) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        cm cmVar = this$0.binding;
        if (cmVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cmVar = null;
        }
        LinearLayout linearLayout = cmVar.f442735f;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.guildNoticePlaceholderLayout");
        ArrayList<co> value = this$0.mViewModel.e2().getValue();
        int i3 = 0;
        if (value != null && !value.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            i3 = 8;
        }
        linearLayout.setVisibility(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ih(String url) {
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.C2C.GuildNoticeIncomeFragment", 2, "handleJumpTargetH5 url:" + url);
        }
        QRouteApi api = QRoute.api(IGuildWebApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IGuildWebApi::class.java)");
        IGuildWebApi.a.a((IGuildWebApi) api, getActivity(), url, null, null, null, 28, null);
    }

    private final void Jh() {
        cm cmVar = this.binding;
        cm cmVar2 = null;
        if (cmVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cmVar = null;
        }
        cmVar.f442735f.setVisibility(8);
        QUIEmptyState.Builder imageType = new QUIEmptyState.Builder(getContext()).setImageType(12);
        String qqStr = HardCodeUtil.qqStr(R.string.f1513917k);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.guild_notice_empty_view_text)");
        QUIEmptyState build = imageType.setTitle(qqStr).setHalfScreenState(false).setBackgroundColorType(0).build();
        cm cmVar3 = this.binding;
        if (cmVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            cmVar2 = cmVar3;
        }
        cmVar2.f442735f.addView(build);
    }

    private final void Kh(View root) {
        View findViewById = root.findViewById(R.id.xl7);
        Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(R.id.immersive_bar)");
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        layoutParams2.height = ImmersiveUtils.getStatusBarHeight(getContext());
        layoutParams2.width = -1;
        findViewById.setLayoutParams(layoutParams2);
        findViewById.setBackgroundResource(R.drawable.qui_common_bg_bottom_light_bg);
    }

    private final void Lh() {
        cm cmVar = null;
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.eju, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.\u2026common_progressbar, null)");
        this.mLoadingView = inflate;
        cm cmVar2 = this.binding;
        if (cmVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cmVar2 = null;
        }
        cmVar2.f442731b.setLayoutManager(new LinearLayoutManager(getContext()));
        GuildIncomeNoticeAdapter guildIncomeNoticeAdapter = new GuildIncomeNoticeAdapter(new GuildNoticeIncomeFragment$initListView$1(this));
        this.mAdapter = guildIncomeNoticeAdapter;
        RecyclerViewWithHeaderFooter.c<GuildIncomeNoticeAdapter> cVar = new RecyclerViewWithHeaderFooter.c<>(guildIncomeNoticeAdapter);
        this.mFooterAdapter = cVar;
        TextView textView = this.mNoMoreContentView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNoMoreContentView");
            textView = null;
        }
        cVar.k0(textView);
        RecyclerViewWithHeaderFooter.c<GuildIncomeNoticeAdapter> cVar2 = this.mFooterAdapter;
        if (cVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFooterAdapter");
            cVar2 = null;
        }
        View view = this.mLoadingView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoadingView");
            view = null;
        }
        cVar2.k0(view);
        cm cmVar3 = this.binding;
        if (cmVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cmVar3 = null;
        }
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter = cmVar3.f442731b;
        RecyclerViewWithHeaderFooter.c<GuildIncomeNoticeAdapter> cVar3 = this.mFooterAdapter;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFooterAdapter");
            cVar3 = null;
        }
        overScrollRecyclerViewWithHeaderFooter.setAdapter(cVar3);
        cm cmVar4 = this.binding;
        if (cmVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            cmVar = cmVar4;
        }
        cmVar.f442731b.addOnScrollListener(Eh());
    }

    private final void Mh() {
        TextView textView = new TextView(getContext());
        this.mNoMoreContentView = textView;
        textView.setText(R.string.f1514517q);
        TextView textView2 = this.mNoMoreContentView;
        TextView textView3 = null;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNoMoreContentView");
            textView2 = null;
        }
        textView2.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        TextView textView4 = this.mNoMoreContentView;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNoMoreContentView");
            textView4 = null;
        }
        textView4.setLayoutParams(layoutParams);
        TextView textView5 = this.mNoMoreContentView;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNoMoreContentView");
            textView5 = null;
        }
        textView5.setPadding(0, QQGuildUIUtil.f(16.0f), 0, QQGuildUIUtil.f(10.0f));
        TextView textView6 = this.mNoMoreContentView;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNoMoreContentView");
            textView6 = null;
        }
        oh1.a.a(textView6, R.color.qui_common_text_tertiary);
        TextView textView7 = this.mNoMoreContentView;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNoMoreContentView");
            textView7 = null;
        }
        textView7.setTextSize(13.0f);
        TextView textView8 = this.mNoMoreContentView;
        if (textView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNoMoreContentView");
        } else {
            textView3 = textView8;
        }
        textView3.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Nh(GuildNoticeIncomeFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onBackEvent();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oh(GuildNoticeIncomeFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onBackEvent();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ph(GuildNoticeIncomeFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!o.c("fastClickGuard")) {
            this$0.Qh();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Qh() {
        Object actionSheetHelperCreateDialog = ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).actionSheetHelperCreateDialog(getContext(), null);
        Intrinsics.checkNotNull(actionSheetHelperCreateDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        final ActionSheet actionSheet = (ActionSheet) actionSheetHelperCreateDialog;
        actionSheet.addRadioButton(BaseApplication.context.getResources().getString(R.string.f1514117m), Intrinsics.areEqual(this.mViewModel.g2().getValue(), Boolean.TRUE));
        actionSheet.addRadioButton(BaseApplication.context.getResources().getString(R.string.f15120172), Intrinsics.areEqual(this.mViewModel.g2().getValue(), Boolean.FALSE));
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.guild.inbox.centerpanel.income.l
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                GuildNoticeIncomeFragment.Rh(GuildNoticeIncomeFragment.this, actionSheet, view, i3);
            }
        });
        actionSheet.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Rh(GuildNoticeIncomeFragment this$0, ActionSheet sheet, View view, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(sheet, "$sheet");
        this$0.mViewModel.l2(i3);
        try {
            sheet.dismiss();
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i("GuildSettingJumpViewModel", 2, e16.toString());
            }
        }
    }

    private final void Th() {
        VideoReport.addToDetectionWhitelist(getActivity());
        cm cmVar = this.binding;
        cm cmVar2 = null;
        if (cmVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cmVar = null;
        }
        VideoReport.setPageId(cmVar.getRoot(), "pg_sgrp_account_change_notice");
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        cm cmVar3 = this.binding;
        if (cmVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cmVar3 = null;
        }
        VideoReport.setPageParams(cmVar3.getRoot(), new PageParams(hashMap));
        cm cmVar4 = this.binding;
        if (cmVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            cmVar2 = cmVar4;
        }
        VideoReport.ignorePageInOutEvent(cmVar2.getRoot(), true);
    }

    private final void initTitleBar() {
        cm cmVar = this.binding;
        cm cmVar2 = null;
        if (cmVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cmVar = null;
        }
        cmVar.f442734e.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.inbox.centerpanel.income.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildNoticeIncomeFragment.Nh(GuildNoticeIncomeFragment.this, view);
            }
        });
        cm cmVar3 = this.binding;
        if (cmVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cmVar3 = null;
        }
        cmVar3.f442736g.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.inbox.centerpanel.income.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildNoticeIncomeFragment.Oh(GuildNoticeIncomeFragment.this, view);
            }
        });
        cm cmVar4 = this.binding;
        if (cmVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cmVar4 = null;
        }
        cmVar4.f442732c.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.inbox.centerpanel.income.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildNoticeIncomeFragment.Ph(GuildNoticeIncomeFragment.this, view);
            }
        });
        DrawableType drawableType = new DrawableType(R.drawable.guild_skin_top_back_left_icon, Integer.valueOf(R.color.qui_common_icon_primary));
        cm cmVar5 = this.binding;
        if (cmVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cmVar5 = null;
        }
        ImageView imageView = cmVar5.f442734e;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.guildIvNoticeBack");
        drawableType.b(imageView);
        DrawableType drawableType2 = new DrawableType(R.drawable.qui_more, Integer.valueOf(R.color.qui_common_icon_primary));
        cm cmVar6 = this.binding;
        if (cmVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cmVar6 = null;
        }
        ImageView imageView2 = cmVar6.f442732c;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.guildIvMore");
        drawableType2.b(imageView2);
        DrawableType drawableType3 = new DrawableType(R.drawable.guild_direct_msg_disturb_icon, Integer.valueOf(R.color.qui_common_icon_primary));
        cm cmVar7 = this.binding;
        if (cmVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            cmVar2 = cmVar7;
        }
        ImageView imageView3 = cmVar2.f442733d;
        Intrinsics.checkNotNullExpressionValue(imageView3, "binding.guildIvMsgNoDisturb");
        drawableType3.b(imageView3);
    }

    private final void initView() {
        initTitleBar();
        Jh();
        Mh();
        Lh();
    }

    private final void initViewModel() {
        MutableLiveData<ArrayList<co>> e26 = this.mViewModel.e2();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        e26.observe(viewLifecycleOwner, new c());
        MutableLiveData<Boolean> f26 = this.mViewModel.f2();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "viewLifecycleOwner");
        f26.observe(viewLifecycleOwner2, new d());
        MutableLiveData<Boolean> j26 = this.mViewModel.j2();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "viewLifecycleOwner");
        j26.observe(viewLifecycleOwner3, new e());
        this.mViewModel.addListener();
        cm cmVar = this.binding;
        if (cmVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cmVar = null;
        }
        LinearLayout root = cmVar.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        Kh(root);
        Integer Fh = Fh();
        if (Fh != null && Fh.intValue() == 2) {
            Sh();
        }
    }

    public final void Sh() {
        this.mViewModel.initData();
    }

    @Override // com.tencent.mobileqq.guild.message.directmessage.model.repositories.m
    public void d9(@NotNull List<InboxNoticeNode> list) {
        boolean z16;
        Object obj;
        boolean z17;
        Intrinsics.checkNotNullParameter(list, "list");
        Iterator<T> it = list.iterator();
        while (true) {
            z16 = false;
            if (it.hasNext()) {
                obj = it.next();
                if (5 == ((InboxNoticeNode) obj).getType()) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        InboxNoticeNode inboxNoticeNode = (InboxNoticeNode) obj;
        if (inboxNoticeNode != null && !inboxNoticeNode.getIsVisible()) {
            z16 = true;
        }
        if (z16) {
            Logger.f235387a.d().d("Guild.C2C.GuildNoticeIncomeFragment", 1, "[onInboxNoticeNodeChanged] remove guild assistant finish activity");
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.initWindowStyleAndAnimation(activity);
        Window window = activity.getWindow();
        if (window != null) {
            RFWImmersiveUtils.setImmersiveLayout(window, false);
            RFWImmersiveUtils.setTransparentStatusBar(window);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        Integer Fh = Fh();
        if (Fh != null && Fh.intValue() == 1) {
            com.tencent.mobileqq.guild.mainframe.i iVar = this.mainViewContext;
            if (iVar != null) {
                iVar.guildCenterPanelInOrOut(2, true);
                return false;
            }
            return false;
        }
        if (Fh != null && Fh.intValue() == 2) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        cm g16 = cm.g(inflater);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater)");
        this.binding = g16;
        initView();
        initViewModel();
        Th();
        InboxNoticeNodeRepository.k(this);
        Ch();
        cm cmVar = this.binding;
        if (cmVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cmVar = null;
        }
        LinearLayout root = cmVar.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, root);
        return root;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mViewModel.removeListener();
        InboxNoticeNodeRepository.z(this);
    }

    public GuildNoticeIncomeFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.guild.inbox.centerpanel.income.GuildNoticeIncomeFragment$fragmentType$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Integer invoke() {
                Bundle arguments = GuildNoticeIncomeFragment.this.getArguments();
                if (arguments != null) {
                    return Integer.valueOf(arguments.getInt("key_fragment_type", -1));
                }
                return null;
            }
        });
        this.fragmentType = lazy;
    }
}
