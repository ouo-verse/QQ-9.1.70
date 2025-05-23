package com.tencent.mobileqq.guild.rolegroup.bindpermission;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.api.RoleGroupUserUIData;
import com.tencent.mobileqq.guild.base.QQGuildTokenTitleBarFragment;
import com.tencent.mobileqq.guild.data.w;
import com.tencent.mobileqq.guild.rolegroup.adapters.previewavatar.a;
import com.tencent.mobileqq.guild.rolegroup.bindpermission.GuildBindPermissionActionFactory;
import com.tencent.mobileqq.guild.rolegroup.bindpermission.actions.PermissionSwitchStatus;
import com.tencent.mobileqq.guild.rolegroup.fragments.GuildRoleGroupSelectDialog;
import com.tencent.mobileqq.guild.rolegroup.fragments.memberlist.GuildCommonViewMemberFragment;
import com.tencent.mobileqq.guild.rolegroup.fragments.memberlist.GuildRoleMemberParamData;
import com.tencent.mobileqq.guild.rolegroup.model.data.GuildRoleGroupSelectModel;
import com.tencent.mobileqq.guild.rolegroup.view.previewavatar.GuildRoleMemberPreviewView;
import com.tencent.mobileqq.guild.rolegroup.view.rolelabelpanel.RoleLabelData;
import com.tencent.mobileqq.guild.rolegroup.view.rolelabelpanel.RoleLabelPanel;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.mini.servlet.MiniAppAddPhoneNumberServlet;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGlobalBanner;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qzone.QzoneIPCModule;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.Constants;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yz1.q;

@Metadata(d1 = {"\u0000\u009f\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b*\u0001-\b\u0016\u0018\u0000 h2\u00020\u00012\u00020\u0002:\u0001iB\u0007\u00a2\u0006\u0004\bf\u0010gJ\b\u0010\u0004\u001a\u00020\u0003H\u0014J\b\u0010\u0005\u001a\u00020\u0003H\u0014J\b\u0010\u0006\u001a\u00020\u0003H\u0014J&\u0010\u000e\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014J\u001a\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0012H\u0014J\u0012\u0010\u0016\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0017\u001a\u00020\rH\u0014J\"\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016JH\u0010#\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001e\u001a\u00020\u001d2,\b\u0002\u0010\"\u001a&\u0012\u0004\u0012\u00020\u001d\u0012\u0006\u0012\u0004\u0018\u00010 \u0018\u00010\u001fj\u0012\u0012\u0004\u0012\u00020\u001d\u0012\u0006\u0012\u0004\u0018\u00010 \u0018\u0001`!H\u0004J\b\u0010%\u001a\u00020$H\u0016J\b\u0010&\u001a\u00020\rH\u0016J\b\u0010'\u001a\u00020\rH\u0016J\u0010\u0010(\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010)\u001a\u00020\rH\u0002J\b\u0010*\u001a\u00020\rH\u0002J\b\u0010,\u001a\u00020+H\u0002J\u000f\u0010.\u001a\u00020-H\u0002\u00a2\u0006\u0004\b.\u0010/J\b\u00100\u001a\u00020\rH\u0002J\u0013\u00101\u001a\u00020$H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b1\u00102J\u0014\u00103\u001a\u00020\r2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000fH\u0002J\u0014\u00104\u001a\u00020\r2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000fH\u0002J\u0014\u00105\u001a\u00020\r2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000fH\u0002J\u0014\u00106\u001a\u00020\r2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000fH\u0002J\u0010\u00108\u001a\u00020\r2\u0006\u00107\u001a\u00020$H\u0002J\b\u00109\u001a\u00020\rH\u0002J\b\u0010:\u001a\u00020\rH\u0002R\u0016\u0010=\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010C\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bB\u0010<R\u0016\u0010E\u001a\u00020>8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bD\u0010@R\u0016\u0010G\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bF\u0010<R\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010M\u001a\u00020H8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bL\u0010JR\u0016\u0010Q\u001a\u00020N8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010S\u001a\u00020H8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bR\u0010JR\u0016\u0010U\u001a\u00020H8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bT\u0010JR\u0016\u0010Y\u001a\u00020V8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bW\u0010XR\"\u0010a\u001a\u00020Z8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\u0016\u0010e\u001a\u00020b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bc\u0010d\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006j"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/GuildBindPermissionFragment;", "Lcom/tencent/mobileqq/guild/base/QQGuildTokenTitleBarFragment;", "Landroid/view/View$OnClickListener;", "", "getContentLayoutId", "qh", "ph", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "doOnCreateView", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/actions/PermissionSwitchStatus;", "type", "ki", "v", NodeProps.ON_CLICK, "Yh", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "", "id", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "param", "ei", "", "onBackEvent", "onResume", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "initView", "Ph", "initData", "Lcom/tencent/mobileqq/guild/rolegroup/adapters/previewavatar/a$a;", "Sh", "com/tencent/mobileqq/guild/rolegroup/bindpermission/GuildBindPermissionFragment$c", "Rh", "()Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/GuildBindPermissionFragment$c;", "bi", WidgetCacheLunarData.JI, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Vh", "Zh", "Xh", "ai", MiniAppAddPhoneNumberServlet.KEY_IS_SAVE, "Qh", "hi", "gi", "T", "Landroid/view/View;", "mBindAllContainer", "Landroid/widget/ImageView;", "U", "Landroid/widget/ImageView;", "mBindAllIv", "V", "mBindPartContainer", "W", "mBindPartIv", "X", "mBindRoleAndUserContainer", "Landroid/widget/TextView;", "Y", "Landroid/widget/TextView;", "mBindRoleNumTv", "Z", "mBindRoleManageTv", "Lcom/tencent/mobileqq/guild/rolegroup/view/rolelabelpanel/RoleLabelPanel;", "a0", "Lcom/tencent/mobileqq/guild/rolegroup/view/rolelabelpanel/RoleLabelPanel;", "mBindRolePanel", "b0", "mBindUserNumTv", "c0", "mBindUserManageTv", "Lcom/tencent/mobileqq/guild/rolegroup/view/previewavatar/GuildRoleMemberPreviewView;", "d0", "Lcom/tencent/mobileqq/guild/rolegroup/view/previewavatar/GuildRoleMemberPreviewView;", "mBindUserPanel", "Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/GuildBindPermissionParam;", "e0", "Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/GuildBindPermissionParam;", "Uh", "()Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/GuildBindPermissionParam;", "ii", "(Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/GuildBindPermissionParam;)V", "mParam", "Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/k;", "f0", "Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/k;", "mFetchActionViewModel", "<init>", "()V", "g0", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public class GuildBindPermissionFragment extends QQGuildTokenTitleBarFragment implements View.OnClickListener {

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: T, reason: from kotlin metadata */
    private View mBindAllContainer;

    /* renamed from: U, reason: from kotlin metadata */
    private ImageView mBindAllIv;

    /* renamed from: V, reason: from kotlin metadata */
    private View mBindPartContainer;

    /* renamed from: W, reason: from kotlin metadata */
    private ImageView mBindPartIv;

    /* renamed from: X, reason: from kotlin metadata */
    private View mBindRoleAndUserContainer;

    /* renamed from: Y, reason: from kotlin metadata */
    private TextView mBindRoleNumTv;

    /* renamed from: Z, reason: from kotlin metadata */
    private TextView mBindRoleManageTv;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private RoleLabelPanel mBindRolePanel;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private TextView mBindUserNumTv;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private TextView mBindUserManageTv;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private GuildRoleMemberPreviewView mBindUserPanel;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    protected GuildBindPermissionParam mParam;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.guild.rolegroup.bindpermission.k mFetchActionViewModel;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/GuildBindPermissionFragment$a;", "", "Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/GuildBindPermissionParam;", "param", "", "b", "Lcom/tencent/mobileqq/app/QBaseFragment;", "context", "a", "", "GUILD_BIND_PERMISSION_PARAM", "Ljava/lang/String;", "SELECTED_ROLES_CACHE_DATA", "SELECTED_USERS_CACHE_DATA", "TAG", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.rolegroup.bindpermission.GuildBindPermissionFragment$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(@NotNull QBaseFragment context, @NotNull GuildBindPermissionParam param) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(param, "param");
            Intent intent = new Intent();
            intent.putExtras(BundleKt.bundleOf(TuplesKt.to("GUILD_BIND_PERMISSION_PARAM", param)));
            QPublicFragmentActivity.b.g(context, intent, QPublicFragmentActivity.class, GuildBindPermissionFragment.class, param.getRequestCode());
        }

        @JvmStatic
        public final void b(@NotNull GuildBindPermissionParam param) {
            Intrinsics.checkNotNullParameter(param, "param");
            Intent intent = new Intent();
            intent.putExtras(BundleKt.bundleOf(TuplesKt.to("GUILD_BIND_PERMISSION_PARAM", param)));
            QPublicFragmentActivity.b.d(intent, QPublicFragmentActivity.class, GuildBindPermissionFragment.class);
        }

        Companion() {
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f232355a;

        static {
            int[] iArr = new int[PermissionSwitchStatus.values().length];
            try {
                iArr[PermissionSwitchStatus.TYPE_ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PermissionSwitchStatus.TYPE_PART.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f232355a = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/rolegroup/bindpermission/GuildBindPermissionFragment$c", "Lhy1/g;", "Landroid/view/View;", "v", "", "c", "Lcom/tencent/mobileqq/guild/rolegroup/view/rolelabelpanel/RoleLabelData;", "roleData", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements hy1.g {
        c() {
        }

        @Override // hy1.g
        public boolean a(@NotNull View v3, @NotNull RoleLabelData roleData) {
            Intrinsics.checkNotNullParameter(v3, "v");
            Intrinsics.checkNotNullParameter(roleData, "roleData");
            return false;
        }

        @Override // hy1.g
        public boolean b(@NotNull View v3) {
            Intrinsics.checkNotNullParameter(v3, "v");
            GuildBindPermissionFragment.this.Zh(v3);
            return true;
        }

        @Override // hy1.g
        public boolean c(@NotNull View v3) {
            Intrinsics.checkNotNullParameter(v3, "v");
            GuildBindPermissionFragment.this.Vh(v3);
            return true;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d<T> implements Observer {
        public d() {
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            List<RoleLabelData> list = (List) t16;
            RoleLabelPanel roleLabelPanel = GuildBindPermissionFragment.this.mBindRolePanel;
            if (roleLabelPanel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBindRolePanel");
                roleLabelPanel = null;
            }
            roleLabelPanel.f(list);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class e<T> implements Observer {
        public e() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            int intValue = ((Number) t16).intValue();
            TextView textView = GuildBindPermissionFragment.this.mBindRoleNumTv;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBindRoleNumTv");
                textView = null;
            }
            textView.setText(String.format(GuildBindPermissionFragment.this.getResources().getString(R.string.f154351ek), Integer.valueOf(intValue)));
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class f<T> implements Observer {
        public f() {
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            List<a.b> list = (List) t16;
            GuildRoleMemberPreviewView guildRoleMemberPreviewView = GuildBindPermissionFragment.this.mBindUserPanel;
            if (guildRoleMemberPreviewView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBindUserPanel");
                guildRoleMemberPreviewView = null;
            }
            guildRoleMemberPreviewView.setPreviewItemDataWithNickname(list, true);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class g<T> implements Observer {
        public g() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            int intValue = ((Number) t16).intValue();
            TextView textView = GuildBindPermissionFragment.this.mBindUserNumTv;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBindUserNumTv");
                textView = null;
            }
            textView.setText(String.format(GuildBindPermissionFragment.this.getResources().getString(R.string.f154321eh), Integer.valueOf(intValue)));
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class h<T> implements Observer {
        public h() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            GuildBindPermissionFragment.this.ki((PermissionSwitchStatus) t16);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class i<T> implements Observer {
        public i() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            FragmentActivity activity;
            if (((Boolean) t16).booleanValue() && (activity = GuildBindPermissionFragment.this.getActivity()) != null && !activity.isFinishing()) {
                activity.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "dialogInner", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", NodeProps.ON_CLICK}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public static final class j implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Continuation<Boolean> f232363d;

        /* JADX WARN: Multi-variable type inference failed */
        j(Continuation<? super Boolean> continuation) {
            this.f232363d = continuation;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i3) {
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
            Continuation<Boolean> continuation = this.f232363d;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(Boolean.TRUE));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "dialogInner", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", NodeProps.ON_CLICK}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public static final class k implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Continuation<Boolean> f232364d;

        /* JADX WARN: Multi-variable type inference failed */
        k(Continuation<? super Boolean> continuation) {
            this.f232364d = continuation;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i3) {
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
            Continuation<Boolean> continuation = this.f232364d;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(Boolean.FALSE));
        }
    }

    private final void Ph() {
        View view = this.mBindAllContainer;
        RoleLabelPanel roleLabelPanel = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBindAllContainer");
            view = null;
        }
        view.setOnClickListener(this);
        View view2 = this.mBindPartContainer;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBindPartContainer");
            view2 = null;
        }
        view2.setOnClickListener(this);
        TextView textView = this.mBindRoleManageTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBindRoleManageTv");
            textView = null;
        }
        textView.setOnClickListener(this);
        TextView textView2 = this.mBindUserManageTv;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBindUserManageTv");
            textView2 = null;
        }
        textView2.setOnClickListener(this);
        GuildRoleMemberPreviewView guildRoleMemberPreviewView = this.mBindUserPanel;
        if (guildRoleMemberPreviewView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBindUserPanel");
            guildRoleMemberPreviewView = null;
        }
        guildRoleMemberPreviewView.c(Sh());
        RoleLabelPanel roleLabelPanel2 = this.mBindRolePanel;
        if (roleLabelPanel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBindRolePanel");
        } else {
            roleLabelPanel = roleLabelPanel2;
        }
        roleLabelPanel.setOnLabelClickListener(Rh());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.tencent.mobileqq.guild.api.RoleGroupUserUIData[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r1v9, types: [com.tencent.mobileqq.guild.rolegroup.view.rolelabelpanel.RoleLabelData[], java.io.Serializable] */
    private final void Qh(boolean isSave) {
        com.tencent.mobileqq.guild.rolegroup.bindpermission.k kVar = this.mFetchActionViewModel;
        com.tencent.mobileqq.guild.rolegroup.bindpermission.k kVar2 = null;
        if (kVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFetchActionViewModel");
            kVar = null;
        }
        int i3 = 0;
        Object[] array = kVar.t2().toArray(new RoleGroupUserUIData[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        ?? r06 = (RoleGroupUserUIData[]) array;
        com.tencent.mobileqq.guild.rolegroup.bindpermission.k kVar3 = this.mFetchActionViewModel;
        if (kVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFetchActionViewModel");
        } else {
            kVar2 = kVar3;
        }
        List<RoleLabelData> value = kVar2.s2().getValue();
        if (value == null) {
            value = new ArrayList<>();
        }
        Object[] array2 = value.toArray(new RoleLabelData[0]);
        Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        ?? r16 = (RoleLabelData[]) array2;
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.rg.BindPermission.AllOrPartFragment", 2, "closePageWhenCreating isSave:" + isSave + " roles:" + r16.length + " users:" + r06.length);
        }
        Intent intent = new Intent();
        intent.putExtra("SELECTED_USERS_CACHE_DATA", (Serializable) r06);
        intent.putExtra("SELECTED_ROLES_CACHE_DATA", (Serializable) r16);
        if (isSave) {
            i3 = -1;
        }
        requireActivity().setResult(i3, intent);
    }

    private final c Rh() {
        return new c();
    }

    private final a.InterfaceC7880a Sh() {
        return new a.InterfaceC7880a() { // from class: com.tencent.mobileqq.guild.rolegroup.bindpermission.d
            @Override // com.tencent.mobileqq.guild.rolegroup.adapters.previewavatar.a.InterfaceC7880a
            public final void a(View view, a.b bVar) {
                GuildBindPermissionFragment.Th(GuildBindPermissionFragment.this, view, bVar);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Th(GuildBindPermissionFragment this$0, View view, a.b bVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i3 = bVar.f232295a;
        if (i3 != 0) {
            if (i3 == 1) {
                this$0.ai(view);
                return;
            }
            return;
        }
        this$0.Xh(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Vh(View v3) {
        List<String> emptyList;
        int collectionSizeOrDefault;
        fi(this, v3, "em_sgrp_role_add", null, 4, null);
        GuildRoleGroupSelectModel.b l3 = new GuildRoleGroupSelectModel.b().m(Uh().getRequestType().getAddRoleType()).n(Uh().getGuildId()).k(Uh().getChannelId()).l(Uh().getChannelType());
        com.tencent.mobileqq.guild.rolegroup.bindpermission.k kVar = this.mFetchActionViewModel;
        if (kVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFetchActionViewModel");
            kVar = null;
        }
        List<RoleLabelData> value = kVar.s2().getValue();
        if (value == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        } else {
            List<RoleLabelData> list = value;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            emptyList = new ArrayList<>(collectionSizeOrDefault);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                emptyList.add(((RoleLabelData) it.next()).getRoleId());
            }
        }
        GuildRoleGroupSelectDialog.Hh(getParentFragmentManager(), l3.o(emptyList).p(!Uh().getIsCreating()).j(new GuildRoleGroupSelectDialog.a() { // from class: com.tencent.mobileqq.guild.rolegroup.bindpermission.a
            @Override // com.tencent.mobileqq.guild.rolegroup.fragments.GuildRoleGroupSelectDialog.a
            public final void a(List list2, List list3) {
                GuildBindPermissionFragment.Wh(GuildBindPermissionFragment.this, list2, list3);
            }
        }).i());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Wh(GuildBindPermissionFragment this$0, List normalRoles, List lvRoles) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Logger.f235387a.d().d("Guild.rg.BindPermission.AllOrPartFragment", 1, "handleCLickAddRole SelectRoleDialog finish normalRoles:" + normalRoles + " lvRoles:" + lvRoles);
        com.tencent.mobileqq.guild.rolegroup.bindpermission.k kVar = this$0.mFetchActionViewModel;
        com.tencent.mobileqq.guild.rolegroup.bindpermission.k kVar2 = null;
        if (kVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFetchActionViewModel");
            kVar = null;
        }
        Intrinsics.checkNotNullExpressionValue(normalRoles, "normalRoles");
        Intrinsics.checkNotNullExpressionValue(lvRoles, "lvRoles");
        kVar.D2(normalRoles, lvRoles);
        if (!this$0.Uh().getIsCreating()) {
            com.tencent.mobileqq.guild.rolegroup.bindpermission.k kVar3 = this$0.mFetchActionViewModel;
            if (kVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFetchActionViewModel");
            } else {
                kVar2 = kVar3;
            }
            kVar2.i2("bindPermission handleCLickAddRole");
        }
    }

    private final void Xh(View v3) {
        int collectionSizeOrDefault;
        fi(this, v3, "em_sgrp_member_add", null, 4, null);
        FragmentActivity requireActivity = requireActivity();
        GuildRoleMemberParamData subChannelId = new GuildRoleMemberParamData(Uh().getGuildId(), Uh().getPermissionWord().getAddMemberTitleStr(), !Uh().getIsCreating() ? 1 : 0, Uh().getRequestType().getAddUserType()).setSubChannelId(Uh().getChannelId());
        com.tencent.mobileqq.guild.rolegroup.bindpermission.k kVar = this.mFetchActionViewModel;
        com.tencent.mobileqq.guild.rolegroup.bindpermission.k kVar2 = null;
        if (kVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFetchActionViewModel");
            kVar = null;
        }
        List<RoleGroupUserUIData> t26 = kVar.t2();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(t26, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = t26.iterator();
        while (it.hasNext()) {
            arrayList.add(((RoleGroupUserUIData) it.next()).getMTinyId());
        }
        GuildRoleMemberParamData selectedIdList = subChannelId.setSelectedIdList(arrayList);
        com.tencent.mobileqq.guild.rolegroup.bindpermission.k kVar3 = this.mFetchActionViewModel;
        if (kVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFetchActionViewModel");
        } else {
            kVar2 = kVar3;
        }
        GuildCommonViewMemberFragment.ki(requireActivity, selectedIdList.setSelectedUIList(kVar2.t2()).setActivityRequestCode(2005));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Zh(View v3) {
        fi(this, v3, "em_sgrp_role_manage", null, 4, null);
        if (Uh().getIsCreating()) {
            GuildBindPermissionParam Uh = Uh();
            com.tencent.mobileqq.guild.rolegroup.bindpermission.k kVar = this.mFetchActionViewModel;
            if (kVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFetchActionViewModel");
                kVar = null;
            }
            List<RoleLabelData> value = kVar.s2().getValue();
            if (value == null) {
                value = new ArrayList<>();
            }
            Object[] array = value.toArray(new RoleLabelData[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            Uh.setSelectRoles((RoleLabelData[]) array);
        }
        GuildBindPermissionRoleListFragment.INSTANCE.b(this, Uh());
    }

    private final void ai(View v3) {
        int i3;
        int collectionSizeOrDefault;
        fi(this, v3, "em_sgrp_member_manage", null, 4, null);
        FragmentActivity requireActivity = requireActivity();
        String guildId = Uh().getGuildId();
        String manageMemberTitleStr = Uh().getPermissionWord().getManageMemberTitleStr();
        if (Uh().getIsCreating()) {
            i3 = 5;
        } else {
            i3 = 2;
        }
        GuildRoleMemberParamData subChannelId = new GuildRoleMemberParamData(guildId, manageMemberTitleStr, i3, Uh().getRequestType().getManageUserType()).setSubChannelId(Uh().getChannelId());
        com.tencent.mobileqq.guild.rolegroup.bindpermission.k kVar = this.mFetchActionViewModel;
        com.tencent.mobileqq.guild.rolegroup.bindpermission.k kVar2 = null;
        if (kVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFetchActionViewModel");
            kVar = null;
        }
        List<RoleGroupUserUIData> t26 = kVar.t2();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(t26, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = t26.iterator();
        while (it.hasNext()) {
            arrayList.add(((RoleGroupUserUIData) it.next()).getMTinyId());
        }
        GuildRoleMemberParamData selectedIdList = subChannelId.setSelectedIdList(arrayList);
        com.tencent.mobileqq.guild.rolegroup.bindpermission.k kVar3 = this.mFetchActionViewModel;
        if (kVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFetchActionViewModel");
        } else {
            kVar2 = kVar3;
        }
        GuildCommonViewMemberFragment.ki(requireActivity, selectedIdList.setSelectedUIList(kVar2.t2()).setActivityRequestCode(2005));
    }

    private final void bi() {
        com.tencent.mobileqq.guild.rolegroup.bindpermission.k kVar = null;
        if (Uh().getRequestType().getBindPermissionType() != GuildBindPermissionActionFactory.FetchType.FETCH_WHO_CAN_SEE) {
            com.tencent.mobileqq.guild.rolegroup.bindpermission.k kVar2 = this.mFetchActionViewModel;
            if (kVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFetchActionViewModel");
            } else {
                kVar = kVar2;
            }
            kVar.Z1(PermissionSwitchStatus.TYPE_PART);
            return;
        }
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.e.f261783e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "Guild.rg.BindPermission.AllOrPartFragment handleClickPart", null, null, null, new GuildBindPermissionFragment$handleClickPart$1(this, null), 14, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ci(GuildBindPermissionFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Qh(true);
        super.onBackEvent();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void di(GuildBindPermissionFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Qh(false);
        super.onBackEvent();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void fi(GuildBindPermissionFragment guildBindPermissionFragment, View view, String str, HashMap hashMap, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 4) != 0) {
                hashMap = null;
            }
            guildBindPermissionFragment.ei(view, str, hashMap);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportDTClick");
    }

    private final void gi() {
        View view = this.mBindAllContainer;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBindAllContainer");
            view = null;
        }
        VideoReport.setElementId(view, Uh().getDtReportParam().getElementAllId());
        View view3 = this.mBindAllContainer;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBindAllContainer");
            view3 = null;
        }
        ClickPolicy clickPolicy = ClickPolicy.REPORT_ALL;
        VideoReport.setElementClickPolicy(view3, clickPolicy);
        View view4 = this.mBindAllContainer;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBindAllContainer");
            view4 = null;
        }
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
        VideoReport.setElementExposePolicy(view4, exposurePolicy);
        View view5 = this.mBindPartContainer;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBindPartContainer");
            view5 = null;
        }
        VideoReport.setElementId(view5, Uh().getDtReportParam().getElementPartId());
        View view6 = this.mBindPartContainer;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBindPartContainer");
            view6 = null;
        }
        VideoReport.setElementClickPolicy(view6, clickPolicy);
        View view7 = this.mBindPartContainer;
        if (view7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBindPartContainer");
        } else {
            view2 = view7;
        }
        VideoReport.setElementExposePolicy(view2, exposurePolicy);
    }

    private final void hi() {
        HashMap hashMapOf;
        VideoReport.addToDetectionWhitelist(requireActivity());
        VideoReport.setPageId(this.P, Uh().getDtReportParam().getPageId());
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("sgrp_sub_channel_id", Uh().getChannelId()));
        w.a(hashMapOf);
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setGuildPageParams(this.P, Uh().getGuildId(), hashMapOf);
    }

    private final void initData() {
        com.tencent.mobileqq.guild.rolegroup.bindpermission.k kVar = (com.tencent.mobileqq.guild.rolegroup.bindpermission.k) ef1.c.INSTANCE.c(this, com.tencent.mobileqq.guild.rolegroup.bindpermission.k.class, new Function0<com.tencent.mobileqq.guild.rolegroup.bindpermission.k>() { // from class: com.tencent.mobileqq.guild.rolegroup.bindpermission.GuildBindPermissionFragment$initData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final k invoke() {
                return new k(GuildBindPermissionFragment.this.Uh().getGuildId(), GuildBindPermissionFragment.this.Uh().getChannelId(), GuildBindPermissionFragment.this.Uh().getRequestType().getBindPermissionType(), GuildBindPermissionFragment.this.Uh().getChannelType(), false, false, false, 112, null);
            }
        });
        this.mFetchActionViewModel = kVar;
        View view = null;
        if (kVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFetchActionViewModel");
            kVar = null;
        }
        LiveData<List<RoleLabelData>> s26 = kVar.s2();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        s26.observe(viewLifecycleOwner, new d());
        com.tencent.mobileqq.guild.rolegroup.bindpermission.k kVar2 = this.mFetchActionViewModel;
        if (kVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFetchActionViewModel");
            kVar2 = null;
        }
        LiveData<Integer> r26 = kVar2.r2();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "viewLifecycleOwner");
        r26.observe(viewLifecycleOwner2, new e());
        com.tencent.mobileqq.guild.rolegroup.bindpermission.k kVar3 = this.mFetchActionViewModel;
        if (kVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFetchActionViewModel");
            kVar3 = null;
        }
        LiveData<List<a.b>> v26 = kVar3.v2();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "viewLifecycleOwner");
        v26.observe(viewLifecycleOwner3, new f());
        com.tencent.mobileqq.guild.rolegroup.bindpermission.k kVar4 = this.mFetchActionViewModel;
        if (kVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFetchActionViewModel");
            kVar4 = null;
        }
        LiveData<Integer> u26 = kVar4.u2();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "viewLifecycleOwner");
        u26.observe(viewLifecycleOwner4, new g());
        com.tencent.mobileqq.guild.rolegroup.bindpermission.k kVar5 = this.mFetchActionViewModel;
        if (kVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFetchActionViewModel");
            kVar5 = null;
        }
        LiveData<PermissionSwitchStatus> p26 = kVar5.p2();
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner5, "viewLifecycleOwner");
        p26.observe(viewLifecycleOwner5, new h());
        com.tencent.mobileqq.guild.rolegroup.bindpermission.k kVar6 = this.mFetchActionViewModel;
        if (kVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFetchActionViewModel");
            kVar6 = null;
        }
        LiveData<Boolean> n26 = kVar6.n2();
        LifecycleOwner viewLifecycleOwner6 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner6, "viewLifecycleOwner");
        n26.observe(viewLifecycleOwner6, new i());
        if (Uh().getIsCreating()) {
            com.tencent.mobileqq.guild.rolegroup.bindpermission.k kVar7 = this.mFetchActionViewModel;
            if (kVar7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFetchActionViewModel");
                kVar7 = null;
            }
            kVar7.E2(Uh().getSelectUsers());
            com.tencent.mobileqq.guild.rolegroup.bindpermission.k kVar8 = this.mFetchActionViewModel;
            if (kVar8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFetchActionViewModel");
                kVar8 = null;
            }
            kVar8.C2(Uh().getSelectRoles());
            View view2 = this.mBindAllContainer;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBindAllContainer");
                view2 = null;
            }
            view2.setVisibility(8);
            View view3 = this.mBindPartContainer;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBindPartContainer");
            } else {
                view = view3;
            }
            view.setVisibility(8);
        }
    }

    private final void initView(View view) {
        boolean z16;
        View findViewById = view.findViewById(R.id.w0n);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.g\u2026ission_all_btn_container)");
        this.mBindAllContainer = findViewById;
        View findViewById2 = view.findViewById(R.id.w0o);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.g\u2026d_bind_permission_all_iv)");
        this.mBindAllIv = (ImageView) findViewById2;
        View findViewById3 = view.findViewById(R.id.w0r);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.g\u2026ssion_part_btn_container)");
        this.mBindPartContainer = findViewById3;
        View findViewById4 = view.findViewById(R.id.w0s);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.g\u2026_bind_permission_part_iv)");
        this.mBindPartIv = (ImageView) findViewById4;
        View findViewById5 = view.findViewById(R.id.w0q);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.g\u2026rmission_panel_container)");
        this.mBindRoleAndUserContainer = findViewById5;
        View findViewById6 = view.findViewById(R.id.w0v);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.guild_bind_role_num_tv)");
        this.mBindRoleNumTv = (TextView) findViewById6;
        View findViewById7 = view.findViewById(R.id.w0u);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "view.findViewById(R.id.guild_bind_role_manage_tv)");
        this.mBindRoleManageTv = (TextView) findViewById7;
        View findViewById8 = view.findViewById(R.id.w0w);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "view.findViewById(R.id.guild_bind_role_panel)");
        this.mBindRolePanel = (RoleLabelPanel) findViewById8;
        View findViewById9 = view.findViewById(R.id.w0y);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "view.findViewById(R.id.guild_bind_user_num_tv)");
        this.mBindUserNumTv = (TextView) findViewById9;
        View findViewById10 = view.findViewById(R.id.w0x);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "view.findViewById(R.id.guild_bind_user_manage_tv)");
        this.mBindUserManageTv = (TextView) findViewById10;
        View findViewById11 = view.findViewById(R.id.w0z);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "view.findViewById(R.id.guild_bind_user_panel)");
        this.mBindUserPanel = (GuildRoleMemberPreviewView) findViewById11;
        if (Uh().getChannelId().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        GuildRoleMemberPreviewView guildRoleMemberPreviewView = null;
        if (z16) {
            IRuntimeService S0 = ch.S0(IGPSService.class, "");
            Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
            IGProChannelInfo channelInfo = ((IGPSService) S0).getChannelInfo(Uh().getChannelId());
            if (channelInfo == null) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                String str = "channelInfo is null " + Uh() + " cId:" + Uh().getChannelId();
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("Guild.rg.BindPermission.AllOrPartFragment", 1, (String) it.next(), null);
                }
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    activity.finish();
                }
            }
            super.zh(Uh().getPermissionWord().getTitleStr(), channelInfo.getChannelName());
        } else {
            this.E.setText(Uh().getPermissionWord().getTitleStr());
        }
        if (Uh().getIsCreating()) {
            setRightButtonText(getResources().getString(R.string.f143340lt), new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.rolegroup.bindpermission.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    GuildBindPermissionFragment.ci(GuildBindPermissionFragment.this, view2);
                }
            });
            super.setLeftButton(getResources().getString(R.string.f140850f3), new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.rolegroup.bindpermission.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    GuildBindPermissionFragment.di(GuildBindPermissionFragment.this, view2);
                }
            });
        } else {
            this.F.setVisibility(8);
        }
        View findViewById12 = view.findViewById(R.id.w0p);
        Intrinsics.checkNotNull(findViewById12, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById12).setText(Uh().getPermissionWord().getAllBtnStr());
        View findViewById13 = view.findViewById(R.id.w0t);
        Intrinsics.checkNotNull(findViewById13, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById13).setText(Uh().getPermissionWord().getPartBtnStr());
        if (QQGuildUIUtil.y() || QQGuildUIUtil.w()) {
            GuildRoleMemberPreviewView guildRoleMemberPreviewView2 = this.mBindUserPanel;
            if (guildRoleMemberPreviewView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBindUserPanel");
            } else {
                guildRoleMemberPreviewView = guildRoleMemberPreviewView2;
            }
            guildRoleMemberPreviewView.setTargetArrange(3, q.f451648a.b(bi.d()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object ji(Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        IGProGlobalBanner globalBanner = xq1.c.j(Uh().getGuildId()).getGlobalBanner();
        if (globalBanner != null && Intrinsics.areEqual(String.valueOf(globalBanner.getBizId().getChannelId()), Uh().getChannelId()) && xq1.c.q(Uh().getGuildId())) {
            QQCustomDialog message = DialogUtil.createCustomDialog(getContext(), 0).setMessage(getString(R.string.f1518918x));
            message.setPositiveButton(getString(R.string.f143520ma), new j(safeContinuation));
            message.setNegativeButton(getString(R.string.f140850f3), new k(safeContinuation));
            message.show();
        } else {
            Result.Companion companion = Result.INSTANCE;
            safeContinuation.resumeWith(Result.m476constructorimpl(Boxing.boxBoolean(true)));
        }
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final GuildBindPermissionParam Uh() {
        GuildBindPermissionParam guildBindPermissionParam = this.mParam;
        if (guildBindPermissionParam != null) {
            return guildBindPermissionParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mParam");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Yh() {
        com.tencent.mobileqq.guild.rolegroup.bindpermission.k kVar = this.mFetchActionViewModel;
        if (kVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFetchActionViewModel");
            kVar = null;
        }
        kVar.Z1(PermissionSwitchStatus.TYPE_ALL);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void doOnCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.doOnCreateView(inflater, container, savedInstanceState);
        Serializable serializable = requireArguments().getSerializable("GUILD_BIND_PERMISSION_PARAM");
        Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type com.tencent.mobileqq.guild.rolegroup.bindpermission.GuildBindPermissionParam");
        ii((GuildBindPermissionParam) serializable);
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.rg.BindPermission.AllOrPartFragment", 2, "param:" + Uh());
        }
    }

    protected final void ei(@Nullable View v3, @NotNull String id5, @Nullable HashMap<String, Object> param) {
        Intrinsics.checkNotNullParameter(id5, "id");
        VideoReport.setElementId(v3, id5);
        VideoReport.setElementClickPolicy(v3, ClickPolicy.REPORT_ALL);
        VideoReport.setElementExposePolicy(v3, ExposurePolicy.REPORT_NONE);
        VideoReport.reportEvent("clck", id5, param);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f168039eh1;
    }

    protected final void ii(@NotNull GuildBindPermissionParam guildBindPermissionParam) {
        Intrinsics.checkNotNullParameter(guildBindPermissionParam, "<set-?>");
        this.mParam = guildBindPermissionParam;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ki(@NotNull PermissionSwitchStatus type) {
        Intrinsics.checkNotNullParameter(type, "type");
        int i3 = b.f232355a[type.ordinal()];
        com.tencent.mobileqq.guild.rolegroup.bindpermission.k kVar = null;
        if (i3 != 1) {
            if (i3 == 2) {
                ImageView imageView = this.mBindAllIv;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBindAllIv");
                    imageView = null;
                }
                imageView.setVisibility(8);
                ImageView imageView2 = this.mBindPartIv;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBindPartIv");
                    imageView2 = null;
                }
                imageView2.setVisibility(0);
                View view = this.mBindRoleAndUserContainer;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBindRoleAndUserContainer");
                    view = null;
                }
                view.setVisibility(0);
                com.tencent.mobileqq.guild.rolegroup.bindpermission.k kVar2 = this.mFetchActionViewModel;
                if (kVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mFetchActionViewModel");
                    kVar2 = null;
                }
                kVar2.i2("updatePermissionSwitchType");
                com.tencent.mobileqq.guild.rolegroup.bindpermission.k kVar3 = this.mFetchActionViewModel;
                if (kVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mFetchActionViewModel");
                } else {
                    kVar = kVar3;
                }
                kVar.j2();
                return;
            }
            return;
        }
        ImageView imageView3 = this.mBindAllIv;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBindAllIv");
            imageView3 = null;
        }
        imageView3.setVisibility(0);
        ImageView imageView4 = this.mBindPartIv;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBindPartIv");
            imageView4 = null;
        }
        imageView4.setVisibility(8);
        View view2 = this.mBindRoleAndUserContainer;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBindRoleAndUserContainer");
            view2 = null;
        }
        view2.setVisibility(8);
        if (!Uh().getIsCreating()) {
            com.tencent.mobileqq.guild.rolegroup.bindpermission.k kVar4 = this.mFetchActionViewModel;
            if (kVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFetchActionViewModel");
            } else {
                kVar = kVar4;
            }
            kVar.a2();
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Object serializableExtra;
        List<RoleLabelData> mutableList;
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1 && data != null) {
            com.tencent.mobileqq.guild.rolegroup.bindpermission.k kVar = null;
            if (requestCode == 2005) {
                Object serializableExtra2 = data.getSerializableExtra("selected_ui_array");
                if (serializableExtra2 == null) {
                    return;
                }
                com.tencent.mobileqq.guild.rolegroup.bindpermission.k kVar2 = this.mFetchActionViewModel;
                if (kVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mFetchActionViewModel");
                } else {
                    kVar = kVar2;
                }
                RoleGroupUserUIData[] roleGroupUserUIDataArr = (RoleGroupUserUIData[]) serializableExtra2;
                ArrayList arrayList = new ArrayList(roleGroupUserUIDataArr.length);
                for (RoleGroupUserUIData roleGroupUserUIData : roleGroupUserUIDataArr) {
                    arrayList.add(roleGroupUserUIData);
                }
                kVar.E2(arrayList);
                return;
            }
            if (requestCode != Uh().getRequestCode() || (serializableExtra = data.getSerializableExtra("SELECTED_USERS_CACHE_DATA")) == null) {
                return;
            }
            com.tencent.mobileqq.guild.rolegroup.bindpermission.k kVar3 = this.mFetchActionViewModel;
            if (kVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFetchActionViewModel");
            } else {
                kVar = kVar3;
            }
            mutableList = ArraysKt___ArraysKt.toMutableList((RoleLabelData[]) serializableExtra);
            kVar.C2(mutableList);
        }
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        Qh(false);
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (!QQGuildUIUtil.v()) {
            View view = this.mBindAllContainer;
            TextView textView = null;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBindAllContainer");
                view = null;
            }
            if (Intrinsics.areEqual(v3, view)) {
                Yh();
            } else {
                View view2 = this.mBindPartContainer;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBindPartContainer");
                    view2 = null;
                }
                if (Intrinsics.areEqual(v3, view2)) {
                    bi();
                } else {
                    TextView textView2 = this.mBindRoleManageTv;
                    if (textView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBindRoleManageTv");
                        textView2 = null;
                    }
                    if (Intrinsics.areEqual(v3, textView2)) {
                        Zh(v3);
                    } else {
                        TextView textView3 = this.mBindUserManageTv;
                        if (textView3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mBindUserManageTv");
                        } else {
                            textView = textView3;
                        }
                        if (Intrinsics.areEqual(v3, textView)) {
                            ai(v3);
                        }
                    }
                }
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.tencent.mobileqq.guild.rolegroup.bindpermission.k kVar = this.mFetchActionViewModel;
        if (kVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFetchActionViewModel");
            kVar = null;
        }
        kVar.onDestroy();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        com.tencent.mobileqq.guild.rolegroup.bindpermission.k kVar = this.mFetchActionViewModel;
        com.tencent.mobileqq.guild.rolegroup.bindpermission.k kVar2 = null;
        if (kVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFetchActionViewModel");
            kVar = null;
        }
        kVar.onResume();
        if (!Uh().getIsCreating()) {
            com.tencent.mobileqq.guild.rolegroup.bindpermission.k kVar3 = this.mFetchActionViewModel;
            if (kVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFetchActionViewModel");
                kVar3 = null;
            }
            kVar3.z2();
            com.tencent.mobileqq.guild.rolegroup.bindpermission.k kVar4 = this.mFetchActionViewModel;
            if (kVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFetchActionViewModel");
                kVar4 = null;
            }
            if (kVar4.p2().getValue() == PermissionSwitchStatus.TYPE_PART) {
                com.tencent.mobileqq.guild.rolegroup.bindpermission.k kVar5 = this.mFetchActionViewModel;
                if (kVar5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mFetchActionViewModel");
                    kVar5 = null;
                }
                kVar5.i2("bindPermission onResume");
                com.tencent.mobileqq.guild.rolegroup.bindpermission.k kVar6 = this.mFetchActionViewModel;
                if (kVar6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mFetchActionViewModel");
                } else {
                    kVar2 = kVar6;
                }
                kVar2.j2();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        Ph();
        initData();
        hi();
        gi();
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildTokenTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    protected int ph() {
        return R.color.ajr;
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildTokenTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    protected int qh() {
        return R.drawable.lvj;
    }
}
