package com.tencent.mobileqq.guild.rolegroup.fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.base.extension.r;
import com.tencent.mobileqq.guild.data.w;
import com.tencent.mobileqq.guild.rolegroup.model.repositories.GuildChannelSelectedData;
import com.tencent.mobileqq.guild.rolegroup.viewmodel.ChannelPermissionEditViewModel;
import com.tencent.mobileqq.guild.util.GuildDebugUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ux1.b;

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\b\u0018\u0000 O2\u00020\u00012\u00020\u0002:\u0001PB\u0007\u00a2\u0006\u0004\bM\u0010NJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0003H\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0010\u001a\u00020\u0003H\u0002J\u001a\u0010\u0014\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u0007H\u0002J\"\u0010\u0016\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007H\u0002J\b\u0010\u0017\u001a\u00020\u0007H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0014J&\u0010 \u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0014J\u0012\u0010\"\u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010$\u001a\u00020#H\u0016R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010*R\u0016\u00100\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00102\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010*R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00108\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010G\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010FR\"\u0010L\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010I0H8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010K\u00a8\u0006Q"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/fragments/ChannelPermissionEditFragment;", "Lcom/tencent/mobileqq/guild/base/QQGuildTitleBarFragment;", "Landroid/view/View$OnClickListener;", "", "Vh", "initView", "", "", "Ph", "initData", "Lri1/a;", "error", "Qh", "Wh", "Lcom/tencent/mobileqq/guild/rolegroup/fragments/j;", "Oh", "Uh", "Landroid/view/View;", "reportView", "elementId", "Sh", "subChannelId", "Th", "getPageId", "", "getContentLayoutId", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", "view", NodeProps.ON_CLICK, "", "onBackEvent", "Lcom/tencent/mobileqq/guild/rolegroup/fragments/ChannelPermissionTypeForRole;", "T", "Lcom/tencent/mobileqq/guild/rolegroup/fragments/ChannelPermissionTypeForRole;", HttpMsg.MTYPE, "U", "Ljava/lang/String;", "mGuildId", "V", "mRoleId", "W", "Z", "mReadOnly", "X", "mRoleName", "Landroid/widget/TextView;", "Y", "Landroid/widget/TextView;", "mSelectAllView", "Landroid/view/View;", "mSelectAllLayout", "Landroidx/recyclerview/widget/RecyclerView;", "a0", "Landroidx/recyclerview/widget/RecyclerView;", "mRecyclerView", "Lux1/b;", "b0", "Lux1/b;", "mAdapter", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/ChannelPermissionEditViewModel;", "c0", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/ChannelPermissionEditViewModel;", "mViewModel", "d0", "Lcom/tencent/mobileqq/guild/rolegroup/fragments/j;", "callback", "", "", "e0", "Ljava/util/Map;", "mDtParam", "<init>", "()V", "f0", "Companion", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class ChannelPermissionEditFragment extends QQGuildTitleBarFragment implements View.OnClickListener {

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: T, reason: from kotlin metadata */
    private ChannelPermissionTypeForRole mType;

    /* renamed from: U, reason: from kotlin metadata */
    private String mGuildId;

    /* renamed from: V, reason: from kotlin metadata */
    private String mRoleId;

    /* renamed from: W, reason: from kotlin metadata */
    private boolean mReadOnly;

    /* renamed from: X, reason: from kotlin metadata */
    @Nullable
    private String mRoleName;

    /* renamed from: Y, reason: from kotlin metadata */
    private TextView mSelectAllView;

    /* renamed from: Z, reason: from kotlin metadata */
    private View mSelectAllLayout;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private RecyclerView mRecyclerView;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private ux1.b mAdapter;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private ChannelPermissionEditViewModel mViewModel;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final j callback = Oh();

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, Object> mDtParam = new HashMap();

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0002\u000f\u0018B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J0\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0007J \u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\tH\u0007R\u0014\u0010\u0010\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0011\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/fragments/ChannelPermissionEditFragment$Companion;", "", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/guild/rolegroup/fragments/ChannelPermissionTypeForRole;", "type", "", "guildId", "roleId", "", "requestCode", "", "b", "Lcom/tencent/mobileqq/guild/rolegroup/fragments/ChannelPermissionEditFragment$Companion$a;", "param", "a", "PERMISSION_TYPE", "Ljava/lang/String;", "READ_ONLY", "ROLE_ID", "ROLE_NAME", "TAG", "<init>", "()V", "Wordings", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class Companion {

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0010\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012R!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006R)\u0010\u000b\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00030\u00030\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0006R!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0006R)\u0010\u0010\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00030\u00030\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\t\u0010\u0006\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/fragments/ChannelPermissionEditFragment$Companion$Wordings;", "", "", "", "b", "Lkotlin/Lazy;", "()Ljava/util/List;", "newVisibleWordings", "kotlin.jvm.PlatformType", "c", "getOldVisibleWordings", "oldVisibleWordings", "d", "a", "newSpeakableWordings", "e", "oldSpeakableWordings", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes14.dex */
        public static final class Wordings {

            /* renamed from: a, reason: collision with root package name */
            @NotNull
            public static final Wordings f232439a = new Wordings();

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private static final Lazy newVisibleWordings;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private static final Lazy oldVisibleWordings;

            /* renamed from: d, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private static final Lazy newSpeakableWordings;

            /* renamed from: e, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private static final Lazy oldSpeakableWordings;

            static {
                Lazy lazy;
                Lazy lazy2;
                Lazy lazy3;
                Lazy lazy4;
                lazy = LazyKt__LazyJVMKt.lazy(new Function0<List<? extends String>>() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.ChannelPermissionEditFragment$Companion$Wordings$newVisibleWordings$2
                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final List<? extends String> invoke() {
                        String replace$default;
                        List<? extends String> listOf;
                        String qqStr = HardCodeUtil.qqStr(R.string.f1503714t);
                        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.guild_modify_all_tips_visible)");
                        replace$default = StringsKt__StringsJVMKt.replace$default(qqStr, "\u5b50\u9891\u9053", "\u5b50\u9891\u9053\u548c\u7248\u5757", false, 4, (Object) null);
                        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{replace$default, "\u67e5\u770b\u6743\u9650"});
                        return listOf;
                    }
                });
                newVisibleWordings = lazy;
                lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<List<? extends String>>() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.ChannelPermissionEditFragment$Companion$Wordings$oldVisibleWordings$2
                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final List<? extends String> invoke() {
                        List<? extends String> listOf;
                        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{HardCodeUtil.qqStr(R.string.f1503714t), HardCodeUtil.qqStr(R.string.f146460u9)});
                        return listOf;
                    }
                });
                oldVisibleWordings = lazy2;
                lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<List<? extends String>>() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.ChannelPermissionEditFragment$Companion$Wordings$newSpeakableWordings$2
                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final List<? extends String> invoke() {
                        String replace$default;
                        List<? extends String> listOf;
                        String qqStr = HardCodeUtil.qqStr(R.string.f1503614s);
                        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.guild_modify_all_tips_speakable)");
                        replace$default = StringsKt__StringsJVMKt.replace$default(qqStr, "\u5b50\u9891\u9053", "\u5b50\u9891\u9053\u548c\u7248\u5757", false, 4, (Object) null);
                        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{replace$default, "\u53d1\u8a00\u6743\u9650"});
                        return listOf;
                    }
                });
                newSpeakableWordings = lazy3;
                lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<List<? extends String>>() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.ChannelPermissionEditFragment$Companion$Wordings$oldSpeakableWordings$2
                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final List<? extends String> invoke() {
                        List<? extends String> listOf;
                        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{HardCodeUtil.qqStr(R.string.f1503614s), HardCodeUtil.qqStr(R.string.f146380u1)});
                        return listOf;
                    }
                });
                oldSpeakableWordings = lazy4;
            }

            Wordings() {
            }

            @NotNull
            public final List<String> a() {
                return (List) newSpeakableWordings.getValue();
            }

            @NotNull
            public final List<String> b() {
                return (List) newVisibleWordings.getValue();
            }

            @NotNull
            public final List<String> c() {
                return (List) oldSpeakableWordings.getValue();
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(@NotNull Context context, @NotNull OpenParam param, int requestCode) {
            boolean isBlank;
            boolean isBlank2;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(param, "param");
            ChannelPermissionTypeForRole type = param.getType();
            String guildId = param.getGuildId();
            String roleId = param.getRoleId();
            String roleName = param.getRoleName();
            boolean readOnly = param.getReadOnly();
            isBlank = StringsKt__StringsJVMKt.isBlank(guildId);
            if (!isBlank) {
                isBlank2 = StringsKt__StringsJVMKt.isBlank(roleId);
                if (!isBlank2) {
                    Intent intent = new Intent();
                    intent.putExtra("extra_guild_id", guildId);
                    intent.putExtra("role_id", roleId);
                    intent.putExtra("permission_type", type);
                    intent.putExtra("read_only", readOnly);
                    intent.putExtra("role_name", roleName);
                    QPublicFragmentActivity.b.f(context, intent, QPublicFragmentActivity.class, ChannelPermissionEditFragment.class, requestCode);
                    return;
                }
            }
            QQToast.makeText(context, 1, context.getResources().getString(R.string.f143560me), 1).show();
        }

        @JvmStatic
        public final void b(@NotNull Context context, @NotNull ChannelPermissionTypeForRole type, @NotNull String guildId, @NotNull String roleId, int requestCode) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(roleId, "roleId");
            a(context, new OpenParam(type, guildId, roleId, null, false, 24, null), requestCode);
        }

        Companion() {
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0003B5\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u0012\u0006\u0010\u0018\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u001e\u001a\u00020\b\u00a2\u0006\u0004\b\u001f\u0010 J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0006\u001a\u00020\u0004H\u00c6\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\t\u0010\t\u001a\u00020\bH\u00c6\u0003J\t\u0010\n\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\f\u001a\u00020\u000bH\u00d6\u0001J\u0013\u0010\u000e\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0018\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015R\u0017\u0010\u001e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/fragments/ChannelPermissionEditFragment$Companion$a;", "", "Lcom/tencent/mobileqq/guild/rolegroup/fragments/ChannelPermissionTypeForRole;", "a", "", "b", "c", "d", "", "e", "toString", "", "hashCode", "other", "equals", "Lcom/tencent/mobileqq/guild/rolegroup/fragments/ChannelPermissionTypeForRole;", "getType", "()Lcom/tencent/mobileqq/guild/rolegroup/fragments/ChannelPermissionTypeForRole;", "type", "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "guildId", "getRoleId", "roleId", "getRoleName", "roleName", "Z", "getReadOnly", "()Z", "readOnly", "<init>", "(Lcom/tencent/mobileqq/guild/rolegroup/fragments/ChannelPermissionTypeForRole;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.rolegroup.fragments.ChannelPermissionEditFragment$Companion$a, reason: from toString */
        /* loaded from: classes14.dex */
        public static final /* data */ class OpenParam {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
            @NotNull
            private final ChannelPermissionTypeForRole type;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
            @NotNull
            private final String guildId;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
            @NotNull
            private final String roleId;

            /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
            @Nullable
            private final String roleName;

            /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
            private final boolean readOnly;

            @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u00002\u00020\u0001B;\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b%\u0010&J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0005J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nJ\u0010\u0010\u000e\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\u0010\u001a\u00020\u000fR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0016\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR$\u0010\u001f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/fragments/ChannelPermissionEditFragment$Companion$a$a;", "", "Lcom/tencent/mobileqq/guild/rolegroup/fragments/ChannelPermissionTypeForRole;", "type", "f", "", "guildId", "b", "roleId", "d", "", "readOnly", "c", "name", "e", "Lcom/tencent/mobileqq/guild/rolegroup/fragments/ChannelPermissionEditFragment$Companion$a;", "a", "Lcom/tencent/mobileqq/guild/rolegroup/fragments/ChannelPermissionTypeForRole;", "getType", "()Lcom/tencent/mobileqq/guild/rolegroup/fragments/ChannelPermissionTypeForRole;", "setType", "(Lcom/tencent/mobileqq/guild/rolegroup/fragments/ChannelPermissionTypeForRole;)V", "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "setGuildId", "(Ljava/lang/String;)V", "getRoleId", "setRoleId", "getRoleName", "setRoleName", "roleName", "Z", "getReadOnly", "()Z", "setReadOnly", "(Z)V", "<init>", "(Lcom/tencent/mobileqq/guild/rolegroup/fragments/ChannelPermissionTypeForRole;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
            /* renamed from: com.tencent.mobileqq.guild.rolegroup.fragments.ChannelPermissionEditFragment$Companion$a$a, reason: collision with other inner class name */
            /* loaded from: classes14.dex */
            public static final class C7881a {

                /* renamed from: a, reason: collision with root package name and from kotlin metadata */
                @NotNull
                private ChannelPermissionTypeForRole type;

                /* renamed from: b, reason: collision with root package name and from kotlin metadata */
                @NotNull
                private String guildId;

                /* renamed from: c, reason: collision with root package name and from kotlin metadata */
                @NotNull
                private String roleId;

                /* renamed from: d, reason: collision with root package name and from kotlin metadata */
                @Nullable
                private String roleName;

                /* renamed from: e, reason: collision with root package name and from kotlin metadata */
                private boolean readOnly;

                public C7881a() {
                    this(null, null, null, null, false, 31, null);
                }

                @NotNull
                public final OpenParam a() {
                    return new OpenParam(this.type, this.guildId, this.roleId, this.roleName, this.readOnly);
                }

                @NotNull
                public final C7881a b(@NotNull String guildId) {
                    Intrinsics.checkNotNullParameter(guildId, "guildId");
                    this.guildId = guildId;
                    return this;
                }

                @NotNull
                public final C7881a c(boolean readOnly) {
                    this.readOnly = readOnly;
                    return this;
                }

                @NotNull
                public final C7881a d(@NotNull String roleId) {
                    Intrinsics.checkNotNullParameter(roleId, "roleId");
                    this.roleId = roleId;
                    return this;
                }

                @NotNull
                public final C7881a e(@Nullable String name) {
                    this.roleName = name;
                    return this;
                }

                @NotNull
                public final C7881a f(@NotNull ChannelPermissionTypeForRole type) {
                    Intrinsics.checkNotNullParameter(type, "type");
                    this.type = type;
                    return this;
                }

                public C7881a(@NotNull ChannelPermissionTypeForRole type, @NotNull String guildId, @NotNull String roleId, @Nullable String str, boolean z16) {
                    Intrinsics.checkNotNullParameter(type, "type");
                    Intrinsics.checkNotNullParameter(guildId, "guildId");
                    Intrinsics.checkNotNullParameter(roleId, "roleId");
                    this.type = type;
                    this.guildId = guildId;
                    this.roleId = roleId;
                    this.roleName = str;
                    this.readOnly = z16;
                }

                public /* synthetic */ C7881a(ChannelPermissionTypeForRole channelPermissionTypeForRole, String str, String str2, String str3, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i3 & 1) != 0 ? ChannelPermissionTypeForRole.ApproveVisible : channelPermissionTypeForRole, (i3 & 2) != 0 ? "" : str, (i3 & 4) == 0 ? str2 : "", (i3 & 8) != 0 ? null : str3, (i3 & 16) != 0 ? false : z16);
                }
            }

            public OpenParam(@NotNull ChannelPermissionTypeForRole type, @NotNull String guildId, @NotNull String roleId, @Nullable String str, boolean z16) {
                Intrinsics.checkNotNullParameter(type, "type");
                Intrinsics.checkNotNullParameter(guildId, "guildId");
                Intrinsics.checkNotNullParameter(roleId, "roleId");
                this.type = type;
                this.guildId = guildId;
                this.roleId = roleId;
                this.roleName = str;
                this.readOnly = z16;
            }

            @NotNull
            /* renamed from: a, reason: from getter */
            public final ChannelPermissionTypeForRole getType() {
                return this.type;
            }

            @NotNull
            /* renamed from: b, reason: from getter */
            public final String getGuildId() {
                return this.guildId;
            }

            @NotNull
            /* renamed from: c, reason: from getter */
            public final String getRoleId() {
                return this.roleId;
            }

            @Nullable
            /* renamed from: d, reason: from getter */
            public final String getRoleName() {
                return this.roleName;
            }

            /* renamed from: e, reason: from getter */
            public final boolean getReadOnly() {
                return this.readOnly;
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof OpenParam)) {
                    return false;
                }
                OpenParam openParam = (OpenParam) other;
                if (this.type == openParam.type && Intrinsics.areEqual(this.guildId, openParam.guildId) && Intrinsics.areEqual(this.roleId, openParam.roleId) && Intrinsics.areEqual(this.roleName, openParam.roleName) && this.readOnly == openParam.readOnly) {
                    return true;
                }
                return false;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                int hashCode;
                int hashCode2 = ((((this.type.hashCode() * 31) + this.guildId.hashCode()) * 31) + this.roleId.hashCode()) * 31;
                String str = this.roleName;
                if (str == null) {
                    hashCode = 0;
                } else {
                    hashCode = str.hashCode();
                }
                int i3 = (hashCode2 + hashCode) * 31;
                boolean z16 = this.readOnly;
                int i16 = z16;
                if (z16 != 0) {
                    i16 = 1;
                }
                return i3 + i16;
            }

            @NotNull
            public String toString() {
                return "OpenParam(type=" + this.type + ", guildId=" + this.guildId + ", roleId=" + this.roleId + ", roleName=" + this.roleName + ", readOnly=" + this.readOnly + ")";
            }

            public /* synthetic */ OpenParam(ChannelPermissionTypeForRole channelPermissionTypeForRole, String str, String str2, String str3, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                this(channelPermissionTypeForRole, str, str2, (i3 & 8) != 0 ? null : str3, (i3 & 16) != 0 ? false : z16);
            }
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f232454a;

        static {
            int[] iArr = new int[ChannelPermissionTypeForRole.values().length];
            try {
                iArr[ChannelPermissionTypeForRole.ApproveVisible.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f232454a = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/rolegroup/fragments/ChannelPermissionEditFragment$b", "Lcom/tencent/mobileqq/guild/rolegroup/fragments/j;", "Landroid/view/View;", "view", "", "channelId", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements j {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.rolegroup.fragments.j
        public void a(@Nullable View view, @NotNull String channelId) {
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            ChannelPermissionEditFragment.this.Th(view, "em_sgrp_subchannel", channelId);
            ChannelPermissionEditViewModel channelPermissionEditViewModel = ChannelPermissionEditFragment.this.mViewModel;
            if (channelPermissionEditViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                channelPermissionEditViewModel = null;
            }
            channelPermissionEditViewModel.m2(channelId);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c<T> implements Observer {
        public c() {
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            int collectionSizeOrDefault;
            List<GuildChannelSelectedData> list = (List) t16;
            if (ChannelPermissionEditFragment.this.mReadOnly) {
                Intrinsics.checkNotNullExpressionValue(list, "it");
                List<GuildChannelSelectedData> list2 = list;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(GuildChannelSelectedData.b((GuildChannelSelectedData) it.next(), 0, null, false, null, false, false, 47, null));
                }
                list = arrayList;
            }
            ux1.b bVar = ChannelPermissionEditFragment.this.mAdapter;
            ChannelPermissionEditViewModel channelPermissionEditViewModel = null;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                bVar = null;
            }
            Intrinsics.checkNotNullExpressionValue(list, "list");
            bVar.setData(list);
            ChannelPermissionEditFragment channelPermissionEditFragment = ChannelPermissionEditFragment.this;
            ChannelPermissionEditViewModel channelPermissionEditViewModel2 = channelPermissionEditFragment.mViewModel;
            if (channelPermissionEditViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            } else {
                channelPermissionEditViewModel = channelPermissionEditViewModel2;
            }
            channelPermissionEditFragment.setRightButtonEnable(channelPermissionEditViewModel.j2());
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d<T> implements Observer {
        public d() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            ri1.a it = (ri1.a) t16;
            ChannelPermissionEditFragment channelPermissionEditFragment = ChannelPermissionEditFragment.this;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            channelPermissionEditFragment.Qh(it);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class e<T> implements Observer {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f232459e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f232460f;

        public e(String str, String str2) {
            this.f232459e = str;
            this.f232460f = str2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            String str;
            Boolean it = (Boolean) t16;
            TextView textView = ChannelPermissionEditFragment.this.mSelectAllView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSelectAllView");
                textView = null;
            }
            Intrinsics.checkNotNullExpressionValue(it, "it");
            if (it.booleanValue()) {
                str = this.f232459e;
            } else {
                str = this.f232460f;
            }
            textView.setText(str);
        }
    }

    private final j Oh() {
        return new b();
    }

    private final List<String> Ph() {
        List emptyList;
        Boolean bool;
        Pair pair;
        String str = this.mGuildId;
        ChannelPermissionTypeForRole channelPermissionTypeForRole = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildId");
            str = null;
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        boolean contains = emptyList.contains(str);
        r rVar = r.f214743a;
        String str2 = "";
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(T::class.java, process)");
        IGProGuildInfo guildInfo = ((IGPSService) S0).getGuildInfo(str);
        if (guildInfo != null) {
            bool = Boolean.valueOf(guildInfo.isMovePostSection());
        } else {
            bool = null;
        }
        if (contains) {
            pair = TuplesKt.to(Boolean.TRUE, "HardCode");
        } else if (bool == null) {
            pair = TuplesKt.to(Boolean.FALSE, "NullGuildInfo");
        } else {
            pair = TuplesKt.to(bool, "GuildInfo");
        }
        GuildDebugUtils guildDebugUtils = GuildDebugUtils.f235333a;
        String str3 = guildDebugUtils.e().get(str);
        if (str3 != null) {
            str2 = str3;
        }
        Intrinsics.checkNotNullExpressionValue(str2, "newFeedSquareResults.get(guildId) ?: \"\"");
        String pair2 = pair.toString();
        if (!Intrinsics.areEqual(str2, pair2)) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GUILD_DEBUG", 2, "isNewFeedSquare " + str + MsgSummary.STR_COLON + pair2);
            }
            guildDebugUtils.e().put(str, pair2);
        }
        boolean booleanValue = ((Boolean) pair.getFirst()).booleanValue();
        ChannelPermissionTypeForRole channelPermissionTypeForRole2 = this.mType;
        if (channelPermissionTypeForRole2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(HttpMsg.MTYPE);
        } else {
            channelPermissionTypeForRole = channelPermissionTypeForRole2;
        }
        if (a.f232454a[channelPermissionTypeForRole.ordinal()] == 1) {
            if (booleanValue) {
                return Companion.Wordings.f232439a.b();
            }
            return Companion.Wordings.f232439a.c();
        }
        if (booleanValue) {
            return Companion.Wordings.f232439a.a();
        }
        return Companion.Wordings.f232439a.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Qh(ri1.a error) {
        IGProSecurityResult iGProSecurityResult;
        if (error.d()) {
            QQToast.makeText(getContext(), 2, QQGuildUIUtil.r(R.string.f155101gl), 1).show();
            super.onBackEvent();
            return;
        }
        int i3 = error.f431477a;
        if (i3 != 10023 && i3 != 180010) {
            Context context = getContext();
            int i16 = error.f431477a;
            String str = error.f431478b;
            Object obj = error.f431479c;
            if (obj instanceof IGProSecurityResult) {
                iGProSecurityResult = (IGProSecurityResult) obj;
            } else {
                iGProSecurityResult = null;
            }
            SecurityTipHelperKt.F(context, i16, str, iGProSecurityResult, QQGuildUIUtil.r(R.string.f155091gk), null, 32, null);
            return;
        }
        QQToast.makeText(getContext(), 1, error.f431478b, 1).show();
    }

    @JvmStatic
    public static final void Rh(@NotNull Context context, @NotNull Companion.OpenParam openParam, int i3) {
        INSTANCE.a(context, openParam, i3);
    }

    private final void Sh(View reportView, String elementId) {
        Th(reportView, elementId, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Th(View reportView, String elementId, String subChannelId) {
        if (reportView == null) {
            return;
        }
        VideoReport.setElementId(reportView, elementId);
        VideoReport.setElementExposePolicy(reportView, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(reportView, ClickPolicy.REPORT_NONE);
        HashMap hashMap = new HashMap(this.mDtParam);
        if (!TextUtils.isEmpty(subChannelId)) {
            hashMap.put("sgrp_sub_channel_id", subChannelId);
        }
        VideoReport.reportEvent("clck", reportView, hashMap);
    }

    private final void Uh() {
        String pageId = getPageId();
        VideoReport.addToDetectionWhitelist(requireActivity());
        VideoReport.setPageId(this.P, pageId);
        w.a(this.mDtParam);
        IGuildDTReportApi iGuildDTReportApi = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
        View view = this.P;
        String str = this.mGuildId;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildId");
            str = null;
        }
        iGuildDTReportApi.setGuildPageParams(view, str, this.mDtParam);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0085, code lost:
    
        if (r0 != false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void Vh() {
        boolean z16;
        boolean z17;
        boolean z18;
        Bundle extras = requireActivity().getIntent().getExtras();
        boolean z19 = true;
        if (extras != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            Object obj = extras.get("permission_type");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.mobileqq.guild.rolegroup.fragments.ChannelPermissionTypeForRole");
            this.mType = (ChannelPermissionTypeForRole) obj;
            String string = extras.getString("extra_guild_id", "");
            Intrinsics.checkNotNullExpressionValue(string, "extras.getString(QQGuild\u2026t.EXTRA_KEY_GUILD_ID, \"\")");
            this.mGuildId = string;
            String string2 = extras.getString("role_id", "");
            Intrinsics.checkNotNullExpressionValue(string2, "extras.getString(ROLE_ID, \"\")");
            this.mRoleId = string2;
            this.mReadOnly = extras.getBoolean("read_only", false);
            this.mRoleName = extras.getString("role_name");
            String str = this.mGuildId;
            String str2 = null;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGuildId");
                str = null;
            }
            if (str.length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                String str3 = this.mRoleId;
                if (str3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRoleId");
                } else {
                    str2 = str3;
                }
                if (str2.length() > 0) {
                    z18 = true;
                } else {
                    z18 = false;
                }
            }
            z19 = false;
            if (z19) {
                return;
            } else {
                throw new IllegalStateException("Guild.rg.ChannelPermissionEditFragment guidId or roleId must not be null".toString());
            }
        }
        throw new IllegalStateException("Guild.rg.ChannelPermissionEditFragment arguments must not be null".toString());
    }

    private final void Wh() {
        DialogUtil.createCustomDialog(getContext(), 230, (String) null, QQGuildUIUtil.r(R.string.f1503814u), QQGuildUIUtil.r(R.string.f1513017b), QQGuildUIUtil.r(R.string.f155081gj), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ChannelPermissionEditFragment.Yh(ChannelPermissionEditFragment.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ChannelPermissionEditFragment.Xh(ChannelPermissionEditFragment.this, dialogInterface, i3);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Xh(ChannelPermissionEditFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
        super.onBackEvent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Yh(ChannelPermissionEditFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ChannelPermissionEditViewModel channelPermissionEditViewModel = this$0.mViewModel;
        if (channelPermissionEditViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            channelPermissionEditViewModel = null;
        }
        channelPermissionEditViewModel.n2();
    }

    private final String getPageId() {
        ChannelPermissionTypeForRole channelPermissionTypeForRole = this.mType;
        ChannelPermissionTypeForRole channelPermissionTypeForRole2 = null;
        if (channelPermissionTypeForRole == null) {
            Intrinsics.throwUninitializedPropertyAccessException(HttpMsg.MTYPE);
            channelPermissionTypeForRole = null;
        }
        if (channelPermissionTypeForRole == ChannelPermissionTypeForRole.ApproveVisible) {
            return "pg_sgrp_visit_role_detail";
        }
        ChannelPermissionTypeForRole channelPermissionTypeForRole3 = this.mType;
        if (channelPermissionTypeForRole3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(HttpMsg.MTYPE);
        } else {
            channelPermissionTypeForRole2 = channelPermissionTypeForRole3;
        }
        if (channelPermissionTypeForRole2 == ChannelPermissionTypeForRole.ApproveSpeak) {
            return "pg_sgrp_speak_role_detail";
        }
        return "";
    }

    private final void initData() {
        List emptyList;
        Boolean bool;
        Pair pair;
        this.mViewModel = (ChannelPermissionEditViewModel) ef1.c.INSTANCE.c(this, ChannelPermissionEditViewModel.class, new Function0<ChannelPermissionEditViewModel>() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.ChannelPermissionEditFragment$initData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ChannelPermissionEditViewModel invoke() {
                ChannelPermissionTypeForRole channelPermissionTypeForRole;
                String str;
                String str2;
                channelPermissionTypeForRole = ChannelPermissionEditFragment.this.mType;
                String str3 = null;
                if (channelPermissionTypeForRole == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(HttpMsg.MTYPE);
                    channelPermissionTypeForRole = null;
                }
                str = ChannelPermissionEditFragment.this.mGuildId;
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mGuildId");
                    str = null;
                }
                str2 = ChannelPermissionEditFragment.this.mRoleId;
                if (str2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRoleId");
                } else {
                    str3 = str2;
                }
                return new ChannelPermissionEditViewModel(channelPermissionTypeForRole, str, str3, ChannelPermissionEditFragment.this.mReadOnly);
            }
        });
        ChannelPermissionTypeForRole channelPermissionTypeForRole = this.mType;
        ChannelPermissionEditViewModel channelPermissionEditViewModel = null;
        if (channelPermissionTypeForRole == null) {
            Intrinsics.throwUninitializedPropertyAccessException(HttpMsg.MTYPE);
            channelPermissionTypeForRole = null;
        }
        String str = this.mGuildId;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildId");
            str = null;
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        boolean contains = emptyList.contains(str);
        r rVar = r.f214743a;
        String str2 = "";
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(T::class.java, process)");
        IGProGuildInfo guildInfo = ((IGPSService) S0).getGuildInfo(str);
        if (guildInfo != null) {
            bool = Boolean.valueOf(guildInfo.isMovePostSection());
        } else {
            bool = null;
        }
        if (contains) {
            pair = TuplesKt.to(Boolean.TRUE, "HardCode");
        } else if (bool == null) {
            pair = TuplesKt.to(Boolean.FALSE, "NullGuildInfo");
        } else {
            pair = TuplesKt.to(bool, "GuildInfo");
        }
        GuildDebugUtils guildDebugUtils = GuildDebugUtils.f235333a;
        String str3 = guildDebugUtils.e().get(str);
        if (str3 != null) {
            str2 = str3;
        }
        Intrinsics.checkNotNullExpressionValue(str2, "newFeedSquareResults.get(guildId) ?: \"\"");
        String pair2 = pair.toString();
        if (!Intrinsics.areEqual(str2, pair2)) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GUILD_DEBUG", 2, "isNewFeedSquare " + str + MsgSummary.STR_COLON + pair2);
            }
            guildDebugUtils.e().put(str, pair2);
        }
        this.mAdapter = new ux1.b(new b.Companion.AdapterParams(channelPermissionTypeForRole, ((Boolean) pair.getFirst()).booleanValue()), this.callback);
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        ux1.b bVar = this.mAdapter;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            bVar = null;
        }
        recyclerView.setAdapter(bVar);
        ChannelPermissionEditViewModel channelPermissionEditViewModel2 = this.mViewModel;
        if (channelPermissionEditViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            channelPermissionEditViewModel2 = null;
        }
        channelPermissionEditViewModel2.f2().observe(this, new c());
        ChannelPermissionEditViewModel channelPermissionEditViewModel3 = this.mViewModel;
        if (channelPermissionEditViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            channelPermissionEditViewModel3 = null;
        }
        channelPermissionEditViewModel3.h2().observe(this, new d());
        String r16 = QQGuildUIUtil.r(R.string.f155621i0);
        String r17 = QQGuildUIUtil.r(R.string.f140870f5);
        ChannelPermissionEditViewModel channelPermissionEditViewModel4 = this.mViewModel;
        if (channelPermissionEditViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            channelPermissionEditViewModel4 = null;
        }
        channelPermissionEditViewModel4.g2().observe(this, new e(r16, r17));
        ChannelPermissionEditViewModel channelPermissionEditViewModel5 = this.mViewModel;
        if (channelPermissionEditViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
        } else {
            channelPermissionEditViewModel = channelPermissionEditViewModel5;
        }
        channelPermissionEditViewModel.initData();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.lang.String] */
    private final void initView() {
        boolean z16;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        IGPSService iGPSService = (IGPSService) S0;
        String str = this.mGuildId;
        View view = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildId");
            str = null;
        }
        String str2 = this.mRoleId;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRoleId");
            str2 = null;
        }
        IGProGuildRoleInfo roleInfo = iGPSService.getRoleInfo(str, str2);
        int i3 = 0;
        if (roleInfo != null) {
            T name = roleInfo.getName();
            if (name.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                name = roleInfo.getLevelSimpleDsc();
            }
            Intrinsics.checkNotNullExpressionValue(name, "it.name.ifEmpty { it.levelSimpleDsc }");
            objectRef.element = name;
        }
        View findViewById = this.P.findViewById(R.id.zd7);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mContentView.findViewByI\u2026id.modify_permission_tip)");
        TextView textView = (TextView) findViewById;
        List<String> Ph = Ph();
        String str3 = Ph.get(0);
        String str4 = Ph.get(1);
        if (this.mReadOnly) {
            if (!TextUtils.isEmpty(this.mRoleName)) {
                super.zh(str4, this.mRoleName);
            } else {
                super.setTitle(str4);
            }
        } else {
            super.zh(str4, (String) objectRef.element);
        }
        textView.setText(str3);
        View findViewById2 = this.P.findViewById(R.id.ilv);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mContentView.findViewById(R.id.select_all)");
        this.mSelectAllView = (TextView) findViewById2;
        View findViewById3 = this.P.findViewById(R.id.f82004fp);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mContentView.findViewById(R.id.select_all_layout)");
        this.mSelectAllLayout = findViewById3;
        View findViewById4 = this.P.findViewById(R.id.ts5);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "mContentView.findViewById(R.id.channel_list)");
        RecyclerView recyclerView = (RecyclerView) findViewById4;
        this.mRecyclerView = recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        TextView textView2 = this.mSelectAllView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSelectAllView");
            textView2 = null;
        }
        textView2.setOnClickListener(this);
        View view2 = this.mSelectAllLayout;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSelectAllLayout");
        } else {
            view = view2;
        }
        if (!(!this.mReadOnly)) {
            i3 = 8;
        }
        view.setVisibility(i3);
        if (this.mReadOnly) {
            super.setLeftButton(R.string.f140850f3, this);
        } else {
            super.setLeftButton(R.string.f140850f3, this);
            super.setRightButton(R.string.f155081gj, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void doOnCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.doOnCreateView(inflater, container, savedInstanceState);
        Vh();
        initView();
        initData();
        Uh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.eij;
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        ChannelPermissionEditViewModel channelPermissionEditViewModel = this.mViewModel;
        if (channelPermissionEditViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            channelPermissionEditViewModel = null;
        }
        if (!channelPermissionEditViewModel.j2()) {
            return super.onBackEvent();
        }
        Wh();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!o.c("fastClickGuard")) {
            if (Intrinsics.areEqual(view, this.D)) {
                Sh(view, "em_sgrp_role_cancel");
                onBackEvent();
            } else {
                ChannelPermissionEditViewModel channelPermissionEditViewModel = null;
                if (Intrinsics.areEqual(view, this.F)) {
                    Sh(view, "em_sgrp_role_save");
                    ChannelPermissionEditViewModel channelPermissionEditViewModel2 = this.mViewModel;
                    if (channelPermissionEditViewModel2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                    } else {
                        channelPermissionEditViewModel = channelPermissionEditViewModel2;
                    }
                    channelPermissionEditViewModel.n2();
                } else {
                    TextView textView = this.mSelectAllView;
                    if (textView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mSelectAllView");
                        textView = null;
                    }
                    if (Intrinsics.areEqual(view, textView)) {
                        Sh(view, "em_sgrp_selectall");
                        ChannelPermissionEditViewModel channelPermissionEditViewModel3 = this.mViewModel;
                        if (channelPermissionEditViewModel3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                        } else {
                            channelPermissionEditViewModel = channelPermissionEditViewModel3;
                        }
                        channelPermissionEditViewModel.i2();
                    }
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
