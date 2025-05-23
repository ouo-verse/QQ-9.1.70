package com.tencent.mobileqq.guild.mainframe.create;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.guild.mainframe.create.GuildCreateFragment;
import com.tencent.mobileqq.guild.mainframe.create.dialog.GuildCreatePolicyDialog;
import com.tencent.mobileqq.guild.mainframe.create.m;
import com.tencent.mobileqq.guild.mainframe.create.removemember.GuildRemoveMemberFragment;
import com.tencent.mobileqq.guild.mainframe.create.widget.GuildCreateMemberRecyclerView;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.bt;
import com.tencent.mobileqq.guild.util.bw;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cn;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.guild.widget.GuildDefaultThemeNavBarCommon;
import com.tencent.mobileqq.guild.window.s;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.util.InputMethodUtil;
import com.tencent.util.LoadingUtil;
import com.tencent.util.QQToastUtil;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tr1.c;
import ur1.GuildCreateMemberData;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c9\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n*\u0001\u0006\u0018\u0000 n2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001oB\u0007\u00a2\u0006\u0004\bl\u0010mJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\tH\u0002J\b\u0010\u000f\u001a\u00020\tH\u0002J\b\u0010\u0010\u001a\u00020\tH\u0002J\b\u0010\u0011\u001a\u00020\tH\u0002J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002J\u0012\u0010\u0019\u001a\u00020\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0016H\u0002J\b\u0010\u001a\u001a\u00020\tH\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0014J\b\u0010\u001d\u001a\u00020\u001bH\u0014J\b\u0010\u001e\u001a\u00020\u001bH\u0014J$\u0010%\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u001f2\b\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010$\u001a\u0004\u0018\u00010#H\u0014J\u001a\u0010(\u001a\u00020\t2\u0006\u0010'\u001a\u00020&2\b\u0010$\u001a\u0004\u0018\u00010#H\u0016J\u0012\u0010*\u001a\u00020\t2\b\u0010)\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010+\u001a\u00020\fH\u0016J\u0012\u0010.\u001a\u00020\f2\b\u0010-\u001a\u0004\u0018\u00010,H\u0016J\b\u0010/\u001a\u00020\tH\u0016J\"\u00104\u001a\u00020\t2\u0006\u00100\u001a\u00020\u001b2\u0006\u00101\u001a\u00020\u001b2\b\u00103\u001a\u0004\u0018\u000102H\u0016J\u0010\u00106\u001a\u00020\t2\u0006\u00105\u001a\u00020&H\u0016J\b\u00107\u001a\u00020\fH\u0016J\b\u00108\u001a\u00020\fH\u0016J\b\u00109\u001a\u00020\fH\u0016J\b\u0010:\u001a\u00020\fH\u0016R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010E\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010M\u001a\u00020J8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010Q\u001a\u00020N8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010U\u001a\u00020R8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0018\u0010Y\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010]\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010a\u001a\u00020^8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010e\u001a\u00020b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bc\u0010dR\u001b\u0010k\u001a\u00020f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bg\u0010h\u001a\u0004\bi\u0010j\u00a8\u0006p"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/create/GuildCreateFragment;", "Lcom/tencent/mobileqq/guild/base/QQGuildTitleBarFragment;", "Lcom/tencent/mobileqq/pad/d;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mobileqq/guild/widget/GuildDefaultThemeNavBarCommon$a;", "Th", "com/tencent/mobileqq/guild/mainframe/create/GuildCreateFragment$d", "di", "()Lcom/tencent/mobileqq/guild/mainframe/create/GuildCreateFragment$d;", "", "initView", "Wh", "", "ci", "initViewModel", "Vh", "gi", "hi", "", "guildId", "Sh", "Rh", "Landroid/app/Activity;", "fi", "curActivity", "bi", "initDtReport", "", "getContentLayoutId", "qh", "ph", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "initWindowStyleAndAnimation", "needDispatchTouchEvent", "Landroid/view/MotionEvent;", "ev", "dispatchTouchEvent", "onFinish", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "v", NodeProps.ON_CLICK, "onBackEvent", "isWrapContent", "shouldDispatchActivityResult", "shouldDispatchPostThemeChanged", "Landroid/widget/ImageView;", "T", "Landroid/widget/ImageView;", "guildIcon", "Lcom/tencent/mobileqq/guild/mainframe/create/GuildNameInputView;", "U", "Lcom/tencent/mobileqq/guild/mainframe/create/GuildNameInputView;", "guildNameInput", "V", "Landroid/view/View;", "policyLayout", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "W", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "policyCheckBox", "Landroid/widget/TextView;", "X", "Landroid/widget/TextView;", "policyTips", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "Y", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "createButton", "Lcom/tencent/mobileqq/guild/mainframe/create/widget/GuildCreateMemberRecyclerView;", "Z", "Lcom/tencent/mobileqq/guild/mainframe/create/widget/GuildCreateMemberRecyclerView;", "memberView", "Lcom/tencent/mobileqq/guild/mainframe/create/dialog/GuildCreatePolicyDialog;", "a0", "Lcom/tencent/mobileqq/guild/mainframe/create/dialog/GuildCreatePolicyDialog;", "policyDialog", "Landroid/app/Dialog;", "b0", "Landroid/app/Dialog;", "loadingDialog", "Lcom/tencent/mobileqq/guild/mainframe/create/m;", "c0", "Lcom/tencent/mobileqq/guild/mainframe/create/m;", "viewModel", "Lcom/tencent/mobileqq/guild/window/s;", "d0", "Lcom/tencent/mobileqq/guild/window/s;", "mSoftKeyboardStateHelper", "Lur1/d;", "e0", "Lkotlin/Lazy;", "Uh", "()Lur1/d;", "memberCallback", "<init>", "()V", "f0", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildCreateFragment extends QQGuildTitleBarFragment implements com.tencent.mobileqq.pad.d, View.OnClickListener {

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: T, reason: from kotlin metadata */
    private ImageView guildIcon;

    /* renamed from: U, reason: from kotlin metadata */
    private GuildNameInputView guildNameInput;

    /* renamed from: V, reason: from kotlin metadata */
    private View policyLayout;

    /* renamed from: W, reason: from kotlin metadata */
    private QUICheckBox policyCheckBox;

    /* renamed from: X, reason: from kotlin metadata */
    private TextView policyTips;

    /* renamed from: Y, reason: from kotlin metadata */
    private QUIButton createButton;

    /* renamed from: Z, reason: from kotlin metadata */
    private GuildCreateMemberRecyclerView memberView;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildCreatePolicyDialog policyDialog;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Dialog loadingDialog;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private m viewModel;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private s mSoftKeyboardStateHelper;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy memberCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\bR\u0014\u0010\u000f\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\bR\u0014\u0010\u0010\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\b\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/create/GuildCreateFragment$a;", "", "Landroid/content/Context;", "context", "", "a", "", "GUILD_MEMBER_LIMIT_TIPS", "Ljava/lang/String;", "GUILD_NAME_EMPTY_TIPS", "", "INVITE_FRIENDS_REQUEST_CODE", "I", "REMOVE_FRIENDS_REQUEST_CODE", "TAG", "URL_GUILD_NAMING_TIPS", "URL_PRIVATE_SERVICE_PROTOCOL", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.mainframe.create.GuildCreateFragment$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            GuildSplitViewUtils.p(GuildSplitViewUtils.f235370a, context, qw1.b.r(new Intent(), com.tencent.mobileqq.guild.util.report.b.a("guild_create")), GuildCreateFragment.class, null, 8, null);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/mainframe/create/GuildCreateFragment$b", "Lcom/tencent/mobileqq/guild/widget/GuildDefaultThemeNavBarCommon$a;", "Landroid/view/View;", "view", "", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "onItemSelect", "v", "", "onItemLongClick", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements GuildDefaultThemeNavBarCommon.a {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.widget.GuildDefaultThemeNavBarCommon.a
        public boolean onItemLongClick(@Nullable View v3, int item) {
            return false;
        }

        @Override // com.tencent.mobileqq.guild.widget.GuildDefaultThemeNavBarCommon.a
        public void onItemSelect(@NotNull View view, int item) {
            Intrinsics.checkNotNullParameter(view, "view");
            boolean z16 = true;
            if (item == 1) {
                GuildCreateFragment guildCreateFragment = GuildCreateFragment.this;
                if (!o.c("fastClickGuard") && guildCreateFragment.getActivity() != null) {
                    FragmentActivity activity = guildCreateFragment.getActivity();
                    if (activity == null || !activity.isFinishing()) {
                        z16 = false;
                    }
                    if (!z16) {
                        GuildSplitViewUtils.u(GuildSplitViewUtils.f235370a, guildCreateFragment.getActivity(), false, 2, null);
                    }
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/mainframe/create/GuildCreateFragment$c", "Lcom/tencent/mobileqq/guild/window/s$c;", "", "keyboardHeightInPx", "", "onSoftKeyboardOpened", "onSoftKeyboardClosed", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements s.c {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.window.s.c
        public void onSoftKeyboardClosed() {
            View view = GuildCreateFragment.this.getView();
            if (view != null) {
                view.requestFocus();
            }
        }

        @Override // com.tencent.mobileqq.guild.window.s.c
        public void onSoftKeyboardOpened(int keyboardHeightInPx) {
            Logger logger = Logger.f235387a;
            GuildCreateFragment guildCreateFragment = GuildCreateFragment.this;
            if (QLog.isDevelopLevel()) {
                Log.d("GuildCreateFragment", "[onSoftKeyboardOpened] " + guildCreateFragment.requireActivity().getCurrentFocus());
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/mainframe/create/GuildCreateFragment$d", "Lur1/d;", "Lur1/e;", "data", "", "a", "b", "Landroid/view/View;", "view", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d implements ur1.d {
        d() {
        }

        @Override // ur1.d
        public void a(@NotNull GuildCreateMemberData data) {
            int coerceAtMost;
            Intrinsics.checkNotNullParameter(data, "data");
            if (!data.getEnable()) {
                QQToastUtil.showQQToast(0, "\u5df2\u8fbe\u4e0a\u9650\uff0c\u521b\u5efa\u540e\u7ee7\u7eed\u6dfb\u52a0\u6210\u5458");
                return;
            }
            FragmentActivity requireActivity = GuildCreateFragment.this.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            bg bgVar = bg.f302144a;
            m mVar = GuildCreateFragment.this.viewModel;
            m mVar2 = null;
            if (mVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                mVar = null;
            }
            ArrayList n3 = bgVar.n(mVar.W1());
            m mVar3 = GuildCreateFragment.this.viewModel;
            if (mVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                mVar2 = mVar3;
            }
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(mVar2.b2(), 100);
            yz1.g.h(requireActivity, 0L, n3, coerceAtMost, 0, 6667, BundleKt.bundleOf(TuplesKt.to("key_invite_friend_show_confirm_dialog", Boolean.FALSE), TuplesKt.to("key_invite_friend_title", Integer.valueOf(R.string.f138670_7)), TuplesKt.to("key_invite_friend_button", Integer.valueOf(R.string.f138660_6))), 16, null);
        }

        @Override // ur1.d
        public void b() {
            GuildRemoveMemberFragment.Companion companion = GuildRemoveMemberFragment.INSTANCE;
            FragmentActivity requireActivity = GuildCreateFragment.this.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            m mVar = GuildCreateFragment.this.viewModel;
            if (mVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                mVar = null;
            }
            companion.a(requireActivity, 6666, mVar.a2());
        }

        @Override // ur1.d
        public void c(@NotNull View view, @NotNull GuildCreateMemberData data) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(data, "data");
            int userType = data.getUserType();
            if (userType != 3) {
                if (userType == 4) {
                    VideoReport.setElementReuseIdentifier(view, data.getAvatarId() + "_" + data.getUserType());
                    bt.d(view, "em_sgrp_remove", null, null, null, EndExposurePolicy.REPORT_NONE, 28, null);
                    return;
                }
                return;
            }
            VideoReport.setElementReuseIdentifier(view, data.getAvatarId() + "_" + data.getUserType());
            bt.d(view, "em_sgrp_member_list_invite_member", null, null, ExposurePolicy.REPORT_NONE, EndExposurePolicy.REPORT_NONE, 12, null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/mainframe/create/GuildCreateFragment$e", "Ltr1/c;", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class e implements tr1.c {
        e() {
        }

        @Override // tr1.c
        public void a() {
            QUICheckBox qUICheckBox = GuildCreateFragment.this.policyCheckBox;
            if (qUICheckBox == null) {
                Intrinsics.throwUninitializedPropertyAccessException("policyCheckBox");
                qUICheckBox = null;
            }
            qUICheckBox.setChecked(true);
            GuildCreateFragment.this.hi();
        }

        @Override // tr1.c
        public void b() {
            c.a.a(this);
        }
    }

    public GuildCreateFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<d>() { // from class: com.tencent.mobileqq.guild.mainframe.create.GuildCreateFragment$memberCallback$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildCreateFragment.d invoke() {
                GuildCreateFragment.d di5;
                di5 = GuildCreateFragment.this.di();
                return di5;
            }
        });
        this.memberCallback = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Rh(String guildId) {
        Unit unit;
        JumpGuildParam jumpGuildParam = new JumpGuildParam(guildId, "");
        Activity fi5 = fi();
        if (fi5 != null) {
            ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).gotoConversationGuild(fi5, jumpGuildParam);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        boolean z16 = true;
        if (unit == null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("[closeAndJumpGuild] safeGetActivity null!");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("GuildCreateFragment", 1, (String) it.next(), null);
            }
        }
        if (getActivity() != null) {
            FragmentActivity activity = getActivity();
            if (activity == null || !activity.isFinishing()) {
                z16 = false;
            }
            if (!z16) {
                GuildSplitViewUtils.u(GuildSplitViewUtils.f235370a, getActivity(), false, 2, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Sh(String guildId) {
        Logger.f235387a.d().d("GuildCreateFragment", 1, "[createGuildSuccess] guildId " + guildId);
        GuildMainFrameUtils.k(guildId, new GuildCreateFragment$createGuildSuccess$2(this, guildId));
    }

    private final GuildDefaultThemeNavBarCommon.a Th() {
        return new b();
    }

    private final ur1.d Uh() {
        return (ur1.d) this.memberCallback.getValue();
    }

    private final void Vh() {
        s sVar = new s(requireActivity().getWindow().getDecorView());
        this.mSoftKeyboardStateHelper = sVar;
        sVar.g(new c());
    }

    private final void Wh() {
        TextView textView;
        View view = null;
        if (ci()) {
            View view2 = this.policyLayout;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("policyLayout");
                view2 = null;
            }
            view2.setVisibility(0);
            int dpToPx = ViewUtils.dpToPx(32.0f);
            int dpToPx2 = ViewUtils.dpToPx(12.0f);
            Rect rect = new Rect(dpToPx, dpToPx2, dpToPx, dpToPx2);
            QUICheckBox qUICheckBox = this.policyCheckBox;
            if (qUICheckBox == null) {
                Intrinsics.throwUninitializedPropertyAccessException("policyCheckBox");
                qUICheckBox = null;
            }
            j.d(qUICheckBox, rect);
            TextView textView2 = this.policyTips;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("policyTips");
                textView = null;
            } else {
                textView = textView2;
            }
            j.g(textView, R.string.f142920ko, R.string.f142930kp, "https://qun.qq.com/guild/h5/static-pages/index.html?pageId=guildLicense", null, null, 48, null);
            return;
        }
        View view3 = this.policyLayout;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("policyLayout");
        } else {
            view = view3;
        }
        view.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Xh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Yh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Zh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ai(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final boolean bi(Activity curActivity) {
        if (curActivity != null && !curActivity.isFinishing() && !curActivity.isDestroyed()) {
            return true;
        }
        return false;
    }

    private final boolean ci() {
        boolean z16;
        boolean z17;
        List<IGProGuildInfo> guildList = ((IGPSService) ch.R0(IGPSService.class)).getGuildList();
        Intrinsics.checkNotNullExpressionValue(guildList, "runtimeService(IGPSService::class.java).guildList");
        List<IGProGuildInfo> list = guildList;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((IGProGuildInfo) it.next()).getUserType() == 2) {
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
        z17 = false;
        if (!z17 && !bw.f235485a.q()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final d di() {
        return new d();
    }

    @JvmStatic
    public static final void ei(@NotNull Context context) {
        INSTANCE.a(context);
    }

    private final Activity fi() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            activity = QBaseActivity.sTopActivity;
        }
        if (!bi(activity)) {
            return null;
        }
        return activity;
    }

    private final void gi() {
        GuildCreatePolicyDialog guildCreatePolicyDialog = this.policyDialog;
        if (guildCreatePolicyDialog != null) {
            guildCreatePolicyDialog.dismiss();
        }
        GuildCreatePolicyDialog guildCreatePolicyDialog2 = new GuildCreatePolicyDialog();
        guildCreatePolicyDialog2.rh(new e());
        this.policyDialog = guildCreatePolicyDialog2;
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "this.childFragmentManager");
        com.tencent.mobileqq.guild.base.extension.d.a(guildCreatePolicyDialog2, childFragmentManager, "GuildCreateFragment");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hi() {
        CharSequence trim;
        boolean z16;
        String take;
        GuildNameInputView guildNameInputView = this.guildNameInput;
        m mVar = null;
        if (guildNameInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildNameInput");
            guildNameInputView = null;
        }
        trim = StringsKt__StringsKt.trim((CharSequence) guildNameInputView.k());
        String obj = trim.toString();
        boolean z17 = false;
        if (obj.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QQToastUtil.showQQToast(0, "\u8bf7\u586b\u5199\u9891\u9053\u540d\u79f0");
            return;
        }
        View view = this.policyLayout;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("policyLayout");
            view = null;
        }
        if (view.getVisibility() == 0) {
            z17 = true;
        }
        if (z17) {
            QUICheckBox qUICheckBox = this.policyCheckBox;
            if (qUICheckBox == null) {
                Intrinsics.throwUninitializedPropertyAccessException("policyCheckBox");
                qUICheckBox = null;
            }
            if (!qUICheckBox.isChecked() && ci()) {
                bw.f235485a.U0(true);
                gi();
                return;
            }
        }
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            Logger.a d16 = logger.d();
            take = StringsKt___StringsKt.take(obj, 2);
            d16.d("GuildCreateFragment", 2, "[trySubmitCreateGuildRequest] guildName " + take + "(" + obj.length() + ")");
        }
        m mVar2 = this.viewModel;
        if (mVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            mVar = mVar2;
        }
        mVar.g2(obj);
    }

    private final void initDtReport() {
        Map mapOf;
        VideoReport.addToDetectionWhitelist(getQBaseActivity());
        VideoReport.setPageId(this.N, "pg_sgrp_create");
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("sgrp_stream_pgin_source_name", com.tencent.mobileqq.guild.report.b.c()), TuplesKt.to("sgrp_session_id", com.tencent.mobileqq.guild.report.b.e()), TuplesKt.to("sgrp_visit_from", com.tencent.mobileqq.guild.report.b.f()));
        VideoReport.setPageParams(this.N, new PageParams((Map<String, ?>) mapOf));
    }

    private final void initView() {
        IPerformanceReportTask g16;
        View findViewById = this.P.findViewById(R.id.uay);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mContentView.findViewById(R.id.create_guild_btn)");
        this.createButton = (QUIButton) findViewById;
        View findViewById2 = this.P.findViewById(R.id.f164927ub0);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mContentView.findViewByI\u2026te_privacy_policy_layout)");
        this.policyLayout = findViewById2;
        View findViewById3 = this.P.findViewById(R.id.uaz);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mContentView.findViewByI\u2026eate_policy_check_clause)");
        this.policyCheckBox = (QUICheckBox) findViewById3;
        View findViewById4 = this.P.findViewById(R.id.f164928ub1);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "mContentView.findViewByI\u2026eate_privacy_policy_text)");
        this.policyTips = (TextView) findViewById4;
        View findViewById5 = this.P.findViewById(R.id.f165581ws1);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "mContentView.findViewById(R.id.guild_name_input)");
        this.guildNameInput = (GuildNameInputView) findViewById5;
        View findViewById6 = this.P.findViewById(R.id.z2_);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "mContentView.findViewById(R.id.member_view)");
        this.memberView = (GuildCreateMemberRecyclerView) findViewById6;
        View findViewById7 = this.P.findViewById(R.id.wic);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "mContentView.findViewById(R.id.guild_icon)");
        ImageView imageView = (ImageView) findViewById7;
        this.guildIcon = imageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildIcon");
            imageView = null;
        }
        GuildUIUtils.d(imageView, R.drawable.guild_circle_icon, Integer.valueOf(R.color.qui_common_text_primary));
        Wh();
        QUIButton qUIButton = this.createButton;
        if (qUIButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("createButton");
            qUIButton = null;
        }
        qUIButton.setOnClickListener(this);
        GuildCreateMemberRecyclerView guildCreateMemberRecyclerView = this.memberView;
        if (guildCreateMemberRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memberView");
            guildCreateMemberRecyclerView = null;
        }
        guildCreateMemberRecyclerView.setCallback(Uh());
        Bundle arguments = getArguments();
        if (arguments != null && (g16 = qw1.b.g(arguments, null, 1, null)) != null) {
            GuildCreateMemberRecyclerView guildCreateMemberRecyclerView2 = this.memberView;
            if (guildCreateMemberRecyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("memberView");
                guildCreateMemberRecyclerView2 = null;
            }
            qw1.b.q(g16, guildCreateMemberRecyclerView2, null, 2, null);
        }
    }

    private final void initViewModel() {
        m a16;
        if (GuildSplitViewUtils.f235370a.n(requireActivity())) {
            a16 = m.INSTANCE.a(this);
        } else {
            m.Companion companion = m.INSTANCE;
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            a16 = companion.a(requireActivity);
        }
        this.viewModel = a16;
        m mVar = null;
        if (a16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            a16 = null;
        }
        LiveData<CreateResult> U1 = a16.U1();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<CreateResult, Unit> function1 = new Function1<CreateResult, Unit>() { // from class: com.tencent.mobileqq.guild.mainframe.create.GuildCreateFragment$initViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CreateResult createResult) {
                invoke2(createResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CreateResult createResult) {
                Dialog dialog;
                if (createResult.getResult() != 0 || !ch.p(createResult.getSecRet())) {
                    dialog = GuildCreateFragment.this.loadingDialog;
                    if (dialog != null) {
                        dialog.dismiss();
                    }
                    SecurityTipHelperKt.G(BaseApplication.getContext(), new cf1.b(createResult.getResult(), createResult.getErrMsg(), createResult.getSecRet()), null, 4, null);
                    return;
                }
                String guildId = createResult.getGuildId();
                if (guildId == null || guildId.length() == 0) {
                    return;
                }
                GuildCreateFragment.this.Sh(createResult.getGuildId());
            }
        };
        U1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.mainframe.create.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildCreateFragment.Xh(Function1.this, obj);
            }
        });
        m mVar2 = this.viewModel;
        if (mVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            mVar2 = null;
        }
        LiveData<List<GuildCreateMemberData>> Z1 = mVar2.Z1();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final GuildCreateFragment$initViewModel$2 guildCreateFragment$initViewModel$2 = new GuildCreateFragment$initViewModel$2(this);
        Z1.observe(viewLifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.guild.mainframe.create.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildCreateFragment.Yh(Function1.this, obj);
            }
        });
        m mVar3 = this.viewModel;
        if (mVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            mVar3 = null;
        }
        cn<String> X1 = mVar3.X1();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        final Function1<String, Unit> function12 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.guild.mainframe.create.GuildCreateFragment$initViewModel$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String guildName) {
                GuildNameInputView guildNameInputView;
                Logger logger = Logger.f235387a;
                if (QLog.isDevelopLevel()) {
                    Log.d("GuildCreateFragment", "initGuildName: " + guildName);
                }
                guildNameInputView = GuildCreateFragment.this.guildNameInput;
                if (guildNameInputView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("guildNameInput");
                    guildNameInputView = null;
                }
                Intrinsics.checkNotNullExpressionValue(guildName, "guildName");
                guildNameInputView.l(guildName);
            }
        };
        X1.observe(viewLifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.guild.mainframe.create.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildCreateFragment.Zh(Function1.this, obj);
            }
        });
        m mVar4 = this.viewModel;
        if (mVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            mVar = mVar4;
        }
        cn<Boolean> c26 = mVar.c2();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function13 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.mainframe.create.GuildCreateFragment$initViewModel$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                Dialog dialog;
                Dialog dialog2;
                dialog = GuildCreateFragment.this.loadingDialog;
                if (dialog != null) {
                    dialog.dismiss();
                }
                GuildCreateFragment guildCreateFragment = GuildCreateFragment.this;
                guildCreateFragment.loadingDialog = LoadingUtil.showOnlyLoadingImageDialog(guildCreateFragment.getContext(), 1, false);
                dialog2 = GuildCreateFragment.this.loadingDialog;
                if (dialog2 != null) {
                    dialog2.show();
                }
            }
        };
        c26.observe(viewLifecycleOwner4, new Observer() { // from class: com.tencent.mobileqq.guild.mainframe.create.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildCreateFragment.ai(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment
    public boolean dispatchTouchEvent(@Nullable MotionEvent ev5) {
        boolean z16 = false;
        if (ev5 != null && ev5.getAction() == 0) {
            z16 = true;
        }
        if (z16) {
            View currentFocus = requireActivity().getCurrentFocus();
            if (currentFocus instanceof EditText) {
                Rect rect = new Rect();
                GuildNameInputView guildNameInputView = this.guildNameInput;
                GuildNameInputView guildNameInputView2 = null;
                if (guildNameInputView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("guildNameInput");
                    guildNameInputView = null;
                }
                guildNameInputView.getGlobalVisibleRect(rect);
                if (!rect.contains((int) ev5.getRawX(), (int) ev5.getRawY())) {
                    ((EditText) currentFocus).clearFocus();
                    GuildNameInputView guildNameInputView3 = this.guildNameInput;
                    if (guildNameInputView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("guildNameInput");
                    } else {
                        guildNameInputView2 = guildNameInputView3;
                    }
                    InputMethodUtil.hide(guildNameInputView2);
                }
            }
        }
        return super.dispatchTouchEvent(ev5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void doOnCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        super.doOnCreateView(inflater, container, savedInstanceState);
        initView();
        Vh();
        initViewModel();
        GuildSplitViewUtils.f235370a.B(this.N);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f168057ek4;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(@Nullable Activity activity) {
        Window window;
        super.initWindowStyleAndAnimation(activity);
        if (activity != null && (window = activity.getWindow()) != null) {
            window.setSoftInputMode(35);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment
    public boolean needDispatchTouchEvent() {
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        ArrayList<String> arrayList;
        int collectionSizeOrDefault;
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildCreateFragment", 2, "onActivityResult " + requestCode + ", " + resultCode);
        }
        if (-1 == resultCode) {
            m mVar = null;
            if (requestCode != 6666) {
                if (requestCode == 6667) {
                    m mVar2 = this.viewModel;
                    if (mVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    } else {
                        mVar = mVar2;
                    }
                    if (data == null) {
                        data = new Intent();
                    }
                    ArrayList<yz1.InviteFriendsData> c16 = yz1.g.c(data);
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(c16, 10);
                    ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                    for (yz1.InviteFriendsData inviteFriendsData : c16) {
                        arrayList2.add(new InviteFriendsData(inviteFriendsData.getUin(), inviteFriendsData.getName()));
                    }
                    mVar.R1(arrayList2);
                    return;
                }
                return;
            }
            if (data != null) {
                arrayList = data.getStringArrayListExtra("PARAM_MEMBER_LIST");
            } else {
                arrayList = null;
            }
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            m mVar3 = this.viewModel;
            if (mVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                mVar = mVar3;
            }
            mVar.f2(arrayList);
        }
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        return GuildSplitViewUtils.u(GuildSplitViewUtils.f235370a, getActivity(), false, 2, null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        Map<String, ? extends Object> mapOf;
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        if (!QQGuildUIUtil.v()) {
            QUIButton qUIButton = this.createButton;
            m mVar = null;
            if (qUIButton == null) {
                Intrinsics.throwUninitializedPropertyAccessException("createButton");
                qUIButton = null;
            }
            if (Intrinsics.areEqual(v3, qUIButton)) {
                m mVar2 = this.viewModel;
                if (mVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                } else {
                    mVar = mVar2;
                }
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_create_member_num", Integer.valueOf(mVar.W1().size())));
                bt.f235484a.g(v3, "em_sgrp_create_button", "clck", mapOf);
                hi();
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        Dialog dialog;
        Dialog dialog2 = this.loadingDialog;
        boolean z16 = false;
        if (dialog2 != null && dialog2.isShowing()) {
            z16 = true;
        }
        if (z16 && (dialog = this.loadingDialog) != null) {
            dialog.dismiss();
        }
        super.onFinish();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        rh();
        View titleBarView = getTitleBarView();
        Intrinsics.checkNotNull(titleBarView, "null cannot be cast to non-null type com.tencent.mobileqq.guild.widget.GuildDefaultThemeNavBarCommon");
        GuildDefaultThemeNavBarCommon guildDefaultThemeNavBarCommon = (GuildDefaultThemeNavBarCommon) titleBarView;
        guildDefaultThemeNavBarCommon.f().setBackgroundResource(R.drawable.qui_chevron_left_icon_nav_secondary);
        guildDefaultThemeNavBarCommon.setOnItemSelectListener(Th());
        initDtReport();
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    protected int ph() {
        return GuildSplitViewUtils.f235370a.m(getActivity(), R.color.qui_common_bg_bottom_light);
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    protected int qh() {
        return R.drawable.qui_common_bg_bottom_light_bg;
    }

    @Override // com.tencent.mobileqq.pad.d
    public boolean shouldDispatchActivityResult() {
        return true;
    }

    @Override // com.tencent.mobileqq.pad.d
    public boolean shouldDispatchPostThemeChanged() {
        return true;
    }
}
