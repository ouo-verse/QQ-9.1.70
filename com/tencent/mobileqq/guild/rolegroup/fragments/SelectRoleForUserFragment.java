package com.tencent.mobileqq.guild.rolegroup.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.base.GuildProgressDialog;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.base.extension.m;
import com.tencent.mobileqq.guild.base.extension.q;
import com.tencent.mobileqq.guild.rolegroup.viewmodel.SelectRoleLogic;
import com.tencent.mobileqq.guild.rolegroup.viewmodel.r;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cn;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.guild.widget.GuildDefaultThemeNavBarCommon;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import ef1.c;
import iy1.d;
import java.io.Serializable;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import mqq.app.Constants;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yx1.RoleSelectItem;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0087\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\u000f\u0018\u0000 C2\u00020\u0001:\u0002DEB\u0007\u00a2\u0006\u0004\bA\u0010BJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J \u0010\r\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u000f\u0010\u0010\u001a\u00020\u000fH\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0002H\u0002J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0016\u001a\u00020\tH\u0014J&\u0010\u001d\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0014J\b\u0010\u001e\u001a\u00020\u0002H\u0016R\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u001b\u0010<\u001a\u0002078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u0014\u0010@\u001a\u00020=8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b>\u0010?\u00a8\u0006F"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/fragments/SelectRoleForUserFragment;", "Lcom/tencent/mobileqq/guild/base/QQGuildTitleBarFragment;", "", "Nh", "Mh", "initTitleBar", "Ph", "Lyx1/e;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "position", "", "checked", "Qh", "Sh", "com/tencent/mobileqq/guild/rolegroup/fragments/SelectRoleForUserFragment$c", "Kh", "()Lcom/tencent/mobileqq/guild/rolegroup/fragments/SelectRoleForUserFragment$c;", "initDtReport", "Lcf1/b;", "event", "Rh", "getContentLayoutId", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", DKHippyEvent.EVENT_STOP, "Landroidx/recyclerview/widget/RecyclerView;", "T", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lyx1/c;", "U", "Lyx1/c;", "adapter", "Lcom/tencent/mobileqq/guild/rolegroup/fragments/SelectRoleForUserFragment$Param;", "V", "Lcom/tencent/mobileqq/guild/rolegroup/fragments/SelectRoleForUserFragment$Param;", "params", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/r;", "W", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/r;", "viewModel", "Lcom/tencent/mobileqq/guild/base/GuildProgressDialog;", "X", "Lcom/tencent/mobileqq/guild/base/GuildProgressDialog;", "loadingDialog", "Liy1/d;", "Y", "Liy1/d;", "singleRevokeRoleDialog", "Lcom/tencent/mobileqq/guild/widget/GuildDefaultThemeNavBarCommon;", "Z", "Lkotlin/Lazy;", "Lh", "()Lcom/tencent/mobileqq/guild/widget/GuildDefaultThemeNavBarCommon;", "titleBar", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "contentView", "<init>", "()V", "a0", "a", "Param", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class SelectRoleForUserFragment extends QQGuildTitleBarFragment {

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: T, reason: from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: U, reason: from kotlin metadata */
    private yx1.c adapter;

    /* renamed from: V, reason: from kotlin metadata */
    private Param params;

    /* renamed from: W, reason: from kotlin metadata */
    private r viewModel;

    /* renamed from: X, reason: from kotlin metadata */
    private GuildProgressDialog loadingDialog;

    /* renamed from: Y, reason: from kotlin metadata */
    @Nullable
    private iy1.d singleRevokeRoleDialog;

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    private final Lazy titleBar;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u00d6\u0003J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001J\t\u0010\u0015\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/fragments/SelectRoleForUserFragment$Param;", "Ljava/io/Serializable;", "guildId", "", "channelId", "tinyId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getChannelId", "()Ljava/lang/String;", "getGuildId", "getTinyId", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public static final /* data */ class Param implements Serializable {

        @NotNull
        private final String channelId;

        @NotNull
        private final String guildId;

        @NotNull
        private final String tinyId;

        public Param(@NotNull String guildId, @NotNull String channelId, @NotNull String tinyId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            Intrinsics.checkNotNullParameter(tinyId, "tinyId");
            this.guildId = guildId;
            this.channelId = channelId;
            this.tinyId = tinyId;
        }

        public static /* synthetic */ Param copy$default(Param param, String str, String str2, String str3, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = param.guildId;
            }
            if ((i3 & 2) != 0) {
                str2 = param.channelId;
            }
            if ((i3 & 4) != 0) {
                str3 = param.tinyId;
            }
            return param.copy(str, str2, str3);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getGuildId() {
            return this.guildId;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final String getChannelId() {
            return this.channelId;
        }

        @NotNull
        /* renamed from: component3, reason: from getter */
        public final String getTinyId() {
            return this.tinyId;
        }

        @NotNull
        public final Param copy(@NotNull String guildId, @NotNull String channelId, @NotNull String tinyId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            Intrinsics.checkNotNullParameter(tinyId, "tinyId");
            return new Param(guildId, channelId, tinyId);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Param)) {
                return false;
            }
            Param param = (Param) other;
            if (Intrinsics.areEqual(this.guildId, param.guildId) && Intrinsics.areEqual(this.channelId, param.channelId) && Intrinsics.areEqual(this.tinyId, param.tinyId)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final String getChannelId() {
            return this.channelId;
        }

        @NotNull
        public final String getGuildId() {
            return this.guildId;
        }

        @NotNull
        public final String getTinyId() {
            return this.tinyId;
        }

        public int hashCode() {
            return (((this.guildId.hashCode() * 31) + this.channelId.hashCode()) * 31) + this.tinyId.hashCode();
        }

        @NotNull
        public String toString() {
            return "Param(guildId=" + this.guildId + ", channelId=" + this.channelId + ", tinyId=" + this.tinyId + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/fragments/SelectRoleForUserFragment$a;", "", "", "guildId", "channelId", "tinyId", "Landroid/content/Intent;", "a", "PARAM_FRAGMENT", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.rolegroup.fragments.SelectRoleForUserFragment$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final Intent a(@NotNull String guildId, @NotNull String channelId, @NotNull String tinyId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            Intrinsics.checkNotNullParameter(tinyId, "tinyId");
            Intent intent = new Intent();
            intent.putExtra("PARAM_FRAGMENT", new Param(guildId, channelId, tinyId));
            return intent;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f232479a;

        static {
            int[] iArr = new int[SelectRoleLogic.RunningState.values().length];
            try {
                iArr[SelectRoleLogic.RunningState.REQUESTING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SelectRoleLogic.RunningState.SUBMITTING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SelectRoleLogic.RunningState.FINISH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SelectRoleLogic.RunningState.SUBMIT_ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[SelectRoleLogic.RunningState.REQUEST_ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f232479a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/rolegroup/fragments/SelectRoleForUserFragment$c", "Lcom/tencent/mobileqq/guild/widget/GuildDefaultThemeNavBarCommon$b;", "Landroid/view/View;", "v", "", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "onItemSelect", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c extends GuildDefaultThemeNavBarCommon.b {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.widget.GuildDefaultThemeNavBarCommon.a
        public void onItemSelect(@NotNull View v3, int item) {
            Intrinsics.checkNotNullParameter(v3, "v");
            if (item != 1) {
                if (item != 2) {
                    if (item != 8) {
                        return;
                    }
                } else {
                    SelectRoleForUserFragment selectRoleForUserFragment = SelectRoleForUserFragment.this;
                    if (!o.c("fastClickGuard")) {
                        r rVar = selectRoleForUserFragment.viewModel;
                        if (rVar == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                            rVar = null;
                        }
                        rVar.c2();
                        return;
                    }
                    return;
                }
            }
            SelectRoleForUserFragment selectRoleForUserFragment2 = SelectRoleForUserFragment.this;
            if (!o.c("fastClickGuard")) {
                selectRoleForUserFragment2.requireActivity().onBackPressed();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d implements ViewModelProvider.Factory {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewModelStoreOwner f232481a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ SelectRoleForUserFragment f232482b;

        public d(ViewModelStoreOwner viewModelStoreOwner, SelectRoleForUserFragment selectRoleForUserFragment) {
            this.f232481a = viewModelStoreOwner;
            this.f232482b = selectRoleForUserFragment;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> p06) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            long m1963markNowz9LOYto = TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto();
            Param param = this.f232482b.params;
            if (param == null) {
                Intrinsics.throwUninitializedPropertyAccessException("params");
                param = null;
            }
            String guildId = param.getGuildId();
            Param param2 = this.f232482b.params;
            if (param2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("params");
                param2 = null;
            }
            String channelId = param2.getChannelId();
            Param param3 = this.f232482b.params;
            if (param3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("params");
                param3 = null;
            }
            TimedValue timedValue = new TimedValue(new r(guildId, channelId, param3.getTinyId(), com.tencent.mobileqq.guild.rolegroup.model.repositories.r.f232798e), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(m1963markNowz9LOYto), null);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildViewModelProvider", 2, "create " + m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
            }
            return (T) timedValue.getValue();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class e<T> implements Observer {
        public e() {
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            List<T> list = (List) t16;
            yx1.c cVar = SelectRoleForUserFragment.this.adapter;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                cVar = null;
            }
            cVar.submitList(list);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class f<T> implements Observer {
        public f() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            ((Boolean) t16).booleanValue();
            FragmentActivity activity = SelectRoleForUserFragment.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class g<T> implements Observer {
        public g() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            GuildProgressDialog guildProgressDialog;
            GuildProgressDialog guildProgressDialog2;
            int i3 = b.f232479a[((SelectRoleLogic.RunningState) t16).ordinal()];
            GuildProgressDialog guildProgressDialog3 = null;
            if (i3 == 1) {
                GuildProgressDialog guildProgressDialog4 = SelectRoleForUserFragment.this.loadingDialog;
                if (guildProgressDialog4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("loadingDialog");
                    guildProgressDialog = null;
                } else {
                    guildProgressDialog = guildProgressDialog4;
                }
                GuildProgressDialog.f(guildProgressDialog, "\u52a0\u8f7d\u6570\u636e\u4e2d", 0L, 2, null);
                return;
            }
            if (i3 == 2) {
                GuildProgressDialog guildProgressDialog5 = SelectRoleForUserFragment.this.loadingDialog;
                if (guildProgressDialog5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("loadingDialog");
                    guildProgressDialog2 = null;
                } else {
                    guildProgressDialog2 = guildProgressDialog5;
                }
                GuildProgressDialog.f(guildProgressDialog2, "\u4fdd\u5b58\u4e2d", 0L, 2, null);
                return;
            }
            if (i3 == 3) {
                GuildProgressDialog guildProgressDialog6 = SelectRoleForUserFragment.this.loadingDialog;
                if (guildProgressDialog6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("loadingDialog");
                } else {
                    guildProgressDialog3 = guildProgressDialog6;
                }
                guildProgressDialog3.c();
                return;
            }
            if (i3 == 4) {
                GuildProgressDialog guildProgressDialog7 = SelectRoleForUserFragment.this.loadingDialog;
                if (guildProgressDialog7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("loadingDialog");
                } else {
                    guildProgressDialog3 = guildProgressDialog7;
                }
                guildProgressDialog3.c();
                return;
            }
            if (i3 == 5) {
                GuildProgressDialog guildProgressDialog8 = SelectRoleForUserFragment.this.loadingDialog;
                if (guildProgressDialog8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("loadingDialog");
                } else {
                    guildProgressDialog3 = guildProgressDialog8;
                }
                guildProgressDialog3.c();
                SelectRoleForUserFragment.this.onBackEvent();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class h<T> implements Observer {
        public h() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            SelectRoleForUserFragment.this.Rh((cf1.b) t16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class i<T> implements Observer {
        public i() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            SelectRoleForUserFragment.this.getRightTextView().setEnabled(((Boolean) t16).booleanValue());
        }
    }

    public SelectRoleForUserFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<GuildDefaultThemeNavBarCommon>() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.SelectRoleForUserFragment$titleBar$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildDefaultThemeNavBarCommon invoke() {
                View titleBarView = SelectRoleForUserFragment.this.getTitleBarView();
                Intrinsics.checkNotNull(titleBarView, "null cannot be cast to non-null type com.tencent.mobileqq.guild.widget.GuildDefaultThemeNavBarCommon");
                return (GuildDefaultThemeNavBarCommon) titleBarView;
            }
        });
        this.titleBar = lazy;
    }

    private final c Kh() {
        return new c();
    }

    private final GuildDefaultThemeNavBarCommon Lh() {
        return (GuildDefaultThemeNavBarCommon) this.titleBar.getValue();
    }

    private final void Mh() {
        Boolean bool;
        Long l3;
        String str;
        String str2 = "";
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        IGPSService iGPSService = (IGPSService) S0;
        Param param = this.params;
        yx1.c cVar = null;
        if (param == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
            param = null;
        }
        IGProChannelInfo channelInfo = iGPSService.getChannelInfo(param.getChannelId());
        if (channelInfo != null) {
            bool = Boolean.valueOf(channelInfo.isHiddenPostChannel());
        } else {
            bool = null;
        }
        if (Intrinsics.areEqual(bool, Boolean.FALSE)) {
            str2 = channelInfo.getChannelName();
        }
        String str3 = str2;
        SelectRoleForUserFragment$initRecyclerView$1 selectRoleForUserFragment$initRecyclerView$1 = new SelectRoleForUserFragment$initRecyclerView$1(this);
        Param param2 = this.params;
        if (param2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
            param2 = null;
        }
        String channelId = param2.getChannelId();
        if (channelInfo != null) {
            l3 = Long.valueOf(channelInfo.getCategoryId());
        } else {
            l3 = null;
        }
        if (channelInfo != null) {
            str = channelInfo.getCategoryName();
        } else {
            str = null;
        }
        this.adapter = new yx1.c(selectRoleForUserFragment$initRecyclerView$1, channelId, str3, l3, str);
        View findViewById = getContentView().findViewById(R.id.eap);
        Intrinsics.checkNotNullExpressionValue(findViewById, "contentView.findViewById(R.id.list)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.recyclerView = recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.setItemAnimator(null);
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView2 = null;
        }
        recyclerView2.setLayoutManager(new LinearLayoutManager(getActivity()));
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView3 = null;
        }
        q.b(recyclerView3, 0, 0, 3, null);
        RecyclerView recyclerView4 = this.recyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView4 = null;
        }
        yx1.c cVar2 = this.adapter;
        if (cVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            cVar = cVar2;
        }
        recyclerView4.setAdapter(cVar);
    }

    private final void Nh() {
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        this.loadingDialog = new GuildProgressDialog(requireActivity, 0L, 2, null);
        Mh();
        initTitleBar();
        Ph();
    }

    @JvmStatic
    @NotNull
    public static final Intent Oh(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        return INSTANCE.a(str, str2, str3);
    }

    private final void Ph() {
        r rVar = this.viewModel;
        r rVar2 = null;
        if (rVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            rVar = null;
        }
        LiveData<List<RoleSelectItem>> T1 = rVar.T1();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        T1.observe(viewLifecycleOwner, new e());
        r rVar3 = this.viewModel;
        if (rVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            rVar3 = null;
        }
        LiveData<Boolean> R1 = rVar3.R1();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "viewLifecycleOwner");
        R1.observe(viewLifecycleOwner2, new f());
        r rVar4 = this.viewModel;
        if (rVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            rVar4 = null;
        }
        LiveData<SelectRoleLogic.RunningState> U1 = rVar4.U1();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "viewLifecycleOwner");
        U1.observe(viewLifecycleOwner3, new g());
        r rVar5 = this.viewModel;
        if (rVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            rVar5 = null;
        }
        cn<cf1.b> toastEvent = rVar5.getToastEvent();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "viewLifecycleOwner");
        toastEvent.observe(viewLifecycleOwner4, new h());
        r rVar6 = this.viewModel;
        if (rVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            rVar2 = rVar6;
        }
        LiveData<Boolean> S1 = rVar2.S1();
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner5, "viewLifecycleOwner");
        S1.observe(viewLifecycleOwner5, new i());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Qh(RoleSelectItem item, int position, boolean checked) {
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.rg.SelectUserRoleFragment", 2, "onItemToggleSelected - " + item + " - " + position + " - " + checked);
        }
        if (item.getRole().w() && checked) {
            Sh(item);
            return;
        }
        r rVar = this.viewModel;
        if (rVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            rVar = null;
        }
        rVar.b2(item, checked);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Rh(cf1.b event) {
        if (event.f30775b != 0) {
            SecurityTipHelperKt.G(getContext(), event, null, 4, null);
        } else {
            QQToast.makeText(getContext(), 2, event.f30774a, 1).show();
        }
    }

    private final void Sh(final RoleSelectItem item) {
        Context context = getContext();
        if (context != null) {
            d.Companion companion = iy1.d.INSTANCE;
            r rVar = this.viewModel;
            Param param = null;
            if (rVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                rVar = null;
            }
            String targetTinyId = rVar.getTargetTinyId();
            Param param2 = this.params;
            if (param2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("params");
            } else {
                param = param2;
            }
            this.singleRevokeRoleDialog = companion.b(context, targetTinyId, param.getGuildId(), new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SelectRoleForUserFragment.Th(SelectRoleForUserFragment.this, item, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Th(SelectRoleForUserFragment this$0, RoleSelectItem item, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        r rVar = this$0.viewModel;
        if (rVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            rVar = null;
        }
        rVar.b2(item, true);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final View getContentView() {
        View mContentView = this.P;
        Intrinsics.checkNotNullExpressionValue(mContentView, "mContentView");
        return mContentView;
    }

    private final void initDtReport() {
        View view;
        View contentView = getContentView();
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        Param param = this.params;
        if (param == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
            param = null;
        }
        String guildId = param.getGuildId();
        Object parent = contentView.getParent();
        if (parent instanceof View) {
            view = (View) parent;
        } else {
            view = null;
        }
        if (view != null) {
            contentView = view;
        }
        VideoReport.addToDetectionWhitelist(requireActivity);
        VideoReport.setPageId(contentView, "pg_sgrp_role_profile_edit");
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setGuildPageParams(contentView, guildId, null);
        TextView textView = this.F;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
        ClickPolicy clickPolicy = ClickPolicy.REPORT_ALL;
        VideoReport.setElementId(textView, "em_sgrp_role_new_button");
        VideoReport.setElementExposePolicy(textView, exposurePolicy);
        VideoReport.setElementClickPolicy(textView, clickPolicy);
    }

    private final void initTitleBar() {
        Lh().setTitle(getString(R.string.f155681i6));
        Lh().setLeftText(R.string.f140850f3);
        Lh().setRightText(R.string.f143340lt);
        Lh().setOnItemSelectListener(Kh());
        this.F.setTextColor(AppCompatResources.getColorStateList(requireContext(), R.color.bth));
        this.F.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void doOnCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.doOnCreateView(inflater, container, savedInstanceState);
        Bundle requireArguments = requireArguments();
        Intrinsics.checkNotNullExpressionValue(requireArguments, "requireArguments()");
        Serializable serializable = requireArguments.getSerializable("PARAM_FRAGMENT");
        Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type com.tencent.mobileqq.guild.rolegroup.fragments.SelectRoleForUserFragment.Param");
        this.params = (Param) serializable;
        c.Companion companion = ef1.c.INSTANCE;
        ViewModel viewModel = new ViewModelProvider(this, new d(this, this)).get(r.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
        this.viewModel = (r) viewModel;
        Nh();
        r rVar = this.viewModel;
        if (rVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            rVar = null;
        }
        rVar.Z1();
        initDtReport();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.esa;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        iy1.d dVar;
        super.onStop();
        iy1.d dVar2 = this.singleRevokeRoleDialog;
        boolean z16 = false;
        if (dVar2 != null && dVar2.isShowing()) {
            z16 = true;
        }
        if (z16 && (dVar = this.singleRevokeRoleDialog) != null) {
            dVar.dismiss();
        }
    }
}
