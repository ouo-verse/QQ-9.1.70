package com.tencent.mobileqq.settings.fragment.permissionprivacy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.nthiddenchat.NTHiddenChatFragment;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.fragment.blacklist.BlackListFragment;
import com.tencent.mobileqq.guild.guildtab.IGuildUserService;
import com.tencent.mobileqq.mutualmark.oldlogic.FriendIntimateRelationshipHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.setting.fragment.BaseSettingFragment;
import com.tencent.mobileqq.setting.widget.SettingOverScrollRecyclerView;
import com.tencent.mobileqq.settings.IQQSettingApi;
import com.tencent.mobileqq.settings.fragment.ChatOnlyPermissionFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.listitem.DataObserver;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.QUIListItemStyle;
import com.tencent.mobileqq.widget.listitem.QUISingleLineListItem;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzoneIPCModule;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 @2\u00020\u0001:\u0001AB\u0007\u00a2\u0006\u0004\b>\u0010?J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u0018\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u0018\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u001a\u0010\"\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\b\u0010$\u001a\u00020#H\u0016J\b\u0010%\u001a\u00020\u001dH\u0016J\b\u0010&\u001a\u00020\u001dH\u0016J\u0006\u0010'\u001a\u00020\u001dJ\"\u0010-\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020(2\b\u0010,\u001a\u0004\u0018\u00010+H\u0016R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\"\u00109\u001a\u0002028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u0010<\u00a8\u0006B"}, d2 = {"Lcom/tencent/mobileqq/settings/fragment/permissionprivacy/PermissionPrivacyFragmentKotlin;", "Lcom/tencent/mobileqq/setting/fragment/BaseSettingFragment;", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "Di", "()[Lcom/tencent/mobileqq/widget/listitem/Group;", "Ji", "Hi", "Ii", "Lcom/tencent/mobileqq/widget/listitem/w;", "Lcom/tencent/mobileqq/widget/listitem/QUISingleLineListItem;", "Wi", "Ki", "Zi", "dj", "pi", "Ei", "si", "li", "Ri", "kj", "Ai", "hj", "wi", "Ni", "Landroid/view/View;", "view", "", "id", "", "pj", "oj", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "onBackEvent", "onResume", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "init", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "J", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "recyclerViewAdapter", "Lcom/tencent/mobileqq/app/QQAppInterface;", "K", "Lcom/tencent/mobileqq/app/QQAppInterface;", "Vi", "()Lcom/tencent/mobileqq/app/QQAppInterface;", "qj", "(Lcom/tencent/mobileqq/app/QQAppInterface;)V", "mApp", "Lcom/tencent/mobileqq/settings/fragment/permissionprivacy/al;", "L", "Lcom/tencent/mobileqq/settings/fragment/permissionprivacy/al;", "privacyHelper", "<init>", "()V", "M", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class PermissionPrivacyFragmentKotlin extends BaseSettingFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final QUIListItemAdapter recyclerViewAdapter;

    /* renamed from: K, reason: from kotlin metadata */
    public QQAppInterface mApp;

    /* renamed from: L, reason: from kotlin metadata */
    private al privacyHelper;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/settings/fragment/permissionprivacy/PermissionPrivacyFragmentKotlin$a;", "", "Landroid/content/Context;", "context", "", "b", "a", "", "START_REQ_FOR_SPECIAL_CARE_LIST", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.settings.fragment.permissionprivacy.PermissionPrivacyFragmentKotlin$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        public final void a(@Nullable Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
                return;
            }
            QLog.d("PermissionPrivacyFragment", 2, "gotoFriendFindMeSettingBrowser context:" + context);
            if (context != null && com.tencent.mobileqq.webview.util.w.a(1000L)) {
                context.startActivity(new Intent(context, (Class<?>) QQBrowserActivity.class).putExtra("url", "https://ti.qq.com/friendshipauth/find?_wv=3&_bid=173&_cntclr=00000000"));
            }
        }

        public final void b(@Nullable Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
                return;
            }
            QLog.d("PermissionPrivacyFragment", 2, "gotoFriendSettingBrowser context:" + context);
            if (context != null && com.tencent.mobileqq.webview.util.w.a(1000L)) {
                context.startActivity(new Intent(context, (Class<?>) QQBrowserActivity.class).putExtra("url", "https://ti.qq.com/friendship_auth/index.html?_wv=3&_bid=173&_cntclr=00000000#p1"));
            }
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60394);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public PermissionPrivacyFragmentKotlin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.recyclerViewAdapter = new QUIListItemAdapter(QUIListItemStyle.Card, false, false, 6, null);
        }
    }

    private final com.tencent.mobileqq.widget.listitem.w<QUISingleLineListItem> Ai() {
        String qqStr = HardCodeUtil.qqStr(R.string.f202944yv);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.qq_privacy_chat_only_friends)");
        com.tencent.mobileqq.widget.listitem.x xVar = new com.tencent.mobileqq.widget.listitem.x(new x.b.C8996b(qqStr, R.drawable.qui_message), new x.c.g("", false, false, 6, null));
        xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.settings.fragment.permissionprivacy.ad
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PermissionPrivacyFragmentKotlin.Bi(PermissionPrivacyFragmentKotlin.this, view);
            }
        });
        xVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.settings.fragment.permissionprivacy.ae
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                PermissionPrivacyFragmentKotlin.Ci(PermissionPrivacyFragmentKotlin.this, view);
            }
        });
        return xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Bi(PermissionPrivacyFragmentKotlin this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PublicFragmentActivity.start(this$0.getQBaseActivity(), ChatOnlyPermissionFragment.class);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ci(PermissionPrivacyFragmentKotlin this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "view");
        this$0.pj(view, "em_bas_chat_only_with_friends");
    }

    private final Group[] Di() {
        return new Group[]{Ji(), Hi(), Ii()};
    }

    private final com.tencent.mobileqq.widget.listitem.w<QUISingleLineListItem> Ei() {
        ReportController.y(Vi(), "0X800B7EC");
        String title = HardCodeUtil.qqStr(R.string.f202954yw);
        Intrinsics.checkNotNullExpressionValue(title, "title");
        com.tencent.mobileqq.widget.listitem.x xVar = new com.tencent.mobileqq.widget.listitem.x(new x.b.C8996b(title, R.drawable.qui_search), new x.c.g("", false, false, 6, null));
        xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.settings.fragment.permissionprivacy.af
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PermissionPrivacyFragmentKotlin.Fi(PermissionPrivacyFragmentKotlin.this, view);
            }
        });
        xVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.settings.fragment.permissionprivacy.ag
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                PermissionPrivacyFragmentKotlin.Gi(PermissionPrivacyFragmentKotlin.this, view);
            }
        });
        return xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fi(PermissionPrivacyFragmentKotlin this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        INSTANCE.a(this$0.getQBaseActivity());
        ReportController.y(this$0.Vi(), "0X800B850");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gi(PermissionPrivacyFragmentKotlin this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "view");
        this$0.pj(view, "em_bas_find_my_way");
    }

    private final Group Hi() {
        return new Group("\u597d\u53cb", wi(), hj(), Ai(), kj(), Ni(), Ri());
    }

    private final Group Ii() {
        return new Group("\u597d\u53cb\u6743\u9650", Wi(), Ki(), dj(), Zi());
    }

    private final Group Ji() {
        return new Group("\u964c\u751f\u4eba", Ei(), pi(), si(), li());
    }

    private final com.tencent.mobileqq.widget.listitem.w<QUISingleLineListItem> Ki() {
        String qqStr = HardCodeUtil.qqStr(R.string.f202964yx);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.qq_privacy_guild_permission)");
        com.tencent.mobileqq.widget.listitem.x xVar = new com.tencent.mobileqq.widget.listitem.x(new x.b.C8996b(qqStr, R.drawable.qui_channel), new x.c.g("", false, false, 6, null));
        xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.settings.fragment.permissionprivacy.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PermissionPrivacyFragmentKotlin.Li(PermissionPrivacyFragmentKotlin.this, view);
            }
        });
        xVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.settings.fragment.permissionprivacy.v
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                PermissionPrivacyFragmentKotlin.Mi(PermissionPrivacyFragmentKotlin.this, view);
            }
        });
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        xVar.l(viewLifecycleOwner, this.recyclerViewAdapter).g(((IGuildUserService) Vi().getRuntimeService(IGuildUserService.class, "")).isGuildTabSetting());
        return xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Li(PermissionPrivacyFragmentKotlin this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IQQSettingApi iQQSettingApi = (IQQSettingApi) QRoute.api(IQQSettingApi.class);
        QBaseActivity qBaseActivity = this$0.getQBaseActivity();
        Intrinsics.checkNotNullExpressionValue(qBaseActivity, "qBaseActivity");
        iQQSettingApi.launcherGuildPermissionSetting(qBaseActivity, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Mi(PermissionPrivacyFragmentKotlin this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "view");
        this$0.pj(view, "em_bas_channel_authority");
    }

    private final com.tencent.mobileqq.widget.listitem.w<QUISingleLineListItem> Ni() {
        ReportController.y(Vi(), "0X800B7F2");
        String qqStr = HardCodeUtil.qqStr(R.string.ixy);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.qq_hidden_chat)");
        final com.tencent.mobileqq.widget.listitem.x xVar = new com.tencent.mobileqq.widget.listitem.x(new x.b.C8996b(qqStr, R.drawable.qui_eye_off), new x.c.g("", false, false, 6, null));
        al alVar = this.privacyHelper;
        al alVar2 = null;
        if (alVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("privacyHelper");
            alVar = null;
        }
        MutableLiveData<String> j3 = alVar.j();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<String, Unit> function1 = new Function1<String, Unit>(xVar, this) { // from class: com.tencent.mobileqq.settings.fragment.permissionprivacy.PermissionPrivacyFragmentKotlin$getHiddenChatConfig$config$1$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> $this_apply;
            final /* synthetic */ PermissionPrivacyFragmentKotlin this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$this_apply = xVar;
                this.this$0 = this;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) xVar, (Object) this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                QUIListItemAdapter qUIListItemAdapter;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                x.c.g O = this.$this_apply.O();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                O.h(it);
                qUIListItemAdapter = this.this$0.recyclerViewAdapter;
                qUIListItemAdapter.l0(this.$this_apply);
            }
        };
        j3.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.settings.fragment.permissionprivacy.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PermissionPrivacyFragmentKotlin.Oi(Function1.this, obj);
            }
        });
        xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.settings.fragment.permissionprivacy.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PermissionPrivacyFragmentKotlin.Pi(PermissionPrivacyFragmentKotlin.this, view);
            }
        });
        xVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.settings.fragment.permissionprivacy.d
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                PermissionPrivacyFragmentKotlin.Qi(PermissionPrivacyFragmentKotlin.this, view);
            }
        });
        DataObserver<com.tencent.mobileqq.widget.listitem.a<com.tencent.mobileqq.widget.listitem.ac<V>>> l3 = xVar.l(this, this.recyclerViewAdapter);
        al alVar3 = this.privacyHelper;
        if (alVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("privacyHelper");
        } else {
            alVar2 = alVar3;
        }
        l3.e(alVar2.k()).d();
        return xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Pi(PermissionPrivacyFragmentKotlin this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ReportController.y(this$0.Vi(), "0X800B856");
        NTHiddenChatFragment.Companion companion = NTHiddenChatFragment.INSTANCE;
        QBaseActivity qBaseActivity = this$0.getQBaseActivity();
        Intrinsics.checkNotNullExpressionValue(qBaseActivity, "qBaseActivity");
        companion.a(qBaseActivity, 1, new Intent());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qi(PermissionPrivacyFragmentKotlin this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "view");
        this$0.pj(view, "em_bas_hidden_session");
    }

    private final com.tencent.mobileqq.widget.listitem.w<QUISingleLineListItem> Ri() {
        String qqStr = HardCodeUtil.qqStr(R.string.f171520fs3);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.qq_setting_intimate_relationship)");
        final com.tencent.mobileqq.widget.listitem.x xVar = new com.tencent.mobileqq.widget.listitem.x(new x.b.C8996b(qqStr, R.drawable.qui_intimate), new x.c.g("", false, false, 6, null));
        al alVar = this.privacyHelper;
        al alVar2 = null;
        if (alVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("privacyHelper");
            alVar = null;
        }
        MutableLiveData<String> l3 = alVar.l();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<String, Unit> function1 = new Function1<String, Unit>(xVar) { // from class: com.tencent.mobileqq.settings.fragment.permissionprivacy.PermissionPrivacyFragmentKotlin$getIntimateConfig$config$1$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> $this_apply;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$this_apply = xVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) PermissionPrivacyFragmentKotlin.this, (Object) xVar);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                QUIListItemAdapter qUIListItemAdapter;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                } else {
                    qUIListItemAdapter = PermissionPrivacyFragmentKotlin.this.recyclerViewAdapter;
                    qUIListItemAdapter.l0(this.$this_apply);
                }
            }
        };
        l3.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.settings.fragment.permissionprivacy.x
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PermissionPrivacyFragmentKotlin.Si(Function1.this, obj);
            }
        });
        xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.settings.fragment.permissionprivacy.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PermissionPrivacyFragmentKotlin.Ti(PermissionPrivacyFragmentKotlin.this, view);
            }
        });
        xVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.settings.fragment.permissionprivacy.z
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                PermissionPrivacyFragmentKotlin.Ui(PermissionPrivacyFragmentKotlin.this, view);
            }
        });
        DataObserver<com.tencent.mobileqq.widget.listitem.a<com.tencent.mobileqq.widget.listitem.ac<V>>> l16 = xVar.l(this, this.recyclerViewAdapter);
        al alVar3 = this.privacyHelper;
        if (alVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("privacyHelper");
        } else {
            alVar2 = alVar3;
        }
        l16.e(alVar2.m()).d();
        return xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Si(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ti(PermissionPrivacyFragmentKotlin this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ReportController.y(this$0.Vi(), "0X800B853");
        String o16 = FriendIntimateRelationshipHelper.o();
        QLog.d("PermissionPrivacyFragment", 2, "click qq_setting_intimate_relationship url:" + o16);
        if (!TextUtils.isEmpty(o16)) {
            this$0.startActivity(new Intent(this$0.getQBaseActivity(), (Class<?>) QQBrowserActivity.class).putExtra("url", o16));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ui(PermissionPrivacyFragmentKotlin this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "view");
        this$0.pj(view, "em_bas_chum");
    }

    private final com.tencent.mobileqq.widget.listitem.w<QUISingleLineListItem> Wi() {
        String qqStr = HardCodeUtil.qqStr(R.string.f202974yy);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.qq_privacy_qzone_permission)");
        com.tencent.mobileqq.widget.listitem.x xVar = new com.tencent.mobileqq.widget.listitem.x(new x.b.C8996b(qqStr, R.drawable.qui_qq_zone), new x.c.g("", false, false, 6, null));
        xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.settings.fragment.permissionprivacy.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PermissionPrivacyFragmentKotlin.Xi(PermissionPrivacyFragmentKotlin.this, view);
            }
        });
        xVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.settings.fragment.permissionprivacy.r
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                PermissionPrivacyFragmentKotlin.Yi(PermissionPrivacyFragmentKotlin.this, view);
            }
        });
        return xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Xi(PermissionPrivacyFragmentKotlin this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
        userInfo.qzone_uin = this$0.Vi().getCurrentAccountUin();
        userInfo.nickname = this$0.Vi().getCurrentNickname();
        QZoneHelper.forwardToPermissionSetting(this$0.getQBaseActivity(), userInfo, -1);
        ReportController.o(this$0.Vi(), "CliOper", "", "", "Setting_tab", "0X8009C06", 0, 0, "", "", "", "");
        ReportController.y(this$0.Vi(), "0X800B85F");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Yi(PermissionPrivacyFragmentKotlin this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "view");
        this$0.pj(view, "em_bas_spatial_permission");
    }

    private final com.tencent.mobileqq.widget.listitem.w<QUISingleLineListItem> Zi() {
        ReportController.y(Vi(), "0X800B7FF");
        String title = HardCodeUtil.qqStr(R.string.f202984yz);
        boolean visibilityForInputStatus = Vi().getVisibilityForInputStatus(false);
        Intrinsics.checkNotNullExpressionValue(title, "title");
        final com.tencent.mobileqq.widget.listitem.x xVar = new com.tencent.mobileqq.widget.listitem.x(new x.b.C8996b(title, R.drawable.qui_keyboard_circle), new x.c.f(visibilityForInputStatus, new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.settings.fragment.permissionprivacy.n
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                PermissionPrivacyFragmentKotlin.cj(PermissionPrivacyFragmentKotlin.this, compoundButton, z16);
            }
        }));
        al alVar = this.privacyHelper;
        if (alVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("privacyHelper");
            alVar = null;
        }
        MutableLiveData<Boolean> o16 = alVar.o();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>(xVar, this) { // from class: com.tencent.mobileqq.settings.fragment.permissionprivacy.PermissionPrivacyFragmentKotlin$getShowMyInputStatusConfig$2$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.f> $this_apply;
            final /* synthetic */ PermissionPrivacyFragmentKotlin this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$this_apply = xVar;
                this.this$0 = this;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) xVar, (Object) this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                QUIListItemAdapter adapter;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                x.c.f O = this.$this_apply.O();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                O.f(it.booleanValue());
                SettingOverScrollRecyclerView wh5 = this.this$0.wh();
                if (wh5 == null || (adapter = wh5.getAdapter()) == null) {
                    return;
                }
                adapter.l0(this.$this_apply);
            }
        };
        o16.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.settings.fragment.permissionprivacy.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PermissionPrivacyFragmentKotlin.aj(Function1.this, obj);
            }
        });
        xVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.settings.fragment.permissionprivacy.p
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                PermissionPrivacyFragmentKotlin.bj(PermissionPrivacyFragmentKotlin.this, view);
            }
        });
        return xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aj(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bj(PermissionPrivacyFragmentKotlin this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "view");
        this$0.pj(view, "em_bas_my_input_status_is_visible");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cj(PermissionPrivacyFragmentKotlin this$0, CompoundButton view, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(view, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!NetworkUtil.isNetSupport(this$0.getQBaseActivity())) {
            al alVar = this$0.privacyHelper;
            al alVar2 = null;
            if (alVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("privacyHelper");
                alVar = null;
            }
            alVar.v(R.string.cjl, 1);
            al alVar3 = this$0.privacyHelper;
            if (alVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("privacyHelper");
            } else {
                alVar2 = alVar3;
            }
            alVar2.o().postValue(Boolean.valueOf(!z16));
        } else {
            this$0.Vi().setVisibilityForInputStatus(z16, true);
            ReportController.o(this$0.Vi(), "dc00898", "", "", "0X800B863", "0X800B863", z16 ? 1 : 0, 0, "", "", "", "");
            Intrinsics.checkNotNullExpressionValue(view, "view");
            this$0.oj(view, "em_bas_my_input_status_is_visible");
        }
        EventCollector.getInstance().onCompoundButtonChecked(view, z16);
    }

    private final com.tencent.mobileqq.widget.listitem.w<QUISingleLineListItem> dj() {
        ReportController.y(Vi(), "0X800B7FE");
        String title = HardCodeUtil.qqStr(R.string.f202994z0);
        boolean visibilityForNetWorkStatus = Vi().getVisibilityForNetWorkStatus(false);
        Intrinsics.checkNotNullExpressionValue(title, "title");
        final com.tencent.mobileqq.widget.listitem.x xVar = new com.tencent.mobileqq.widget.listitem.x(new x.b.C8996b(title, R.drawable.qui_qqstatus), new x.c.f(visibilityForNetWorkStatus, new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.settings.fragment.permissionprivacy.e
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                PermissionPrivacyFragmentKotlin.ej(PermissionPrivacyFragmentKotlin.this, compoundButton, z16);
            }
        }));
        al alVar = this.privacyHelper;
        if (alVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("privacyHelper");
            alVar = null;
        }
        MutableLiveData<Boolean> p16 = alVar.p();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>(xVar, this) { // from class: com.tencent.mobileqq.settings.fragment.permissionprivacy.PermissionPrivacyFragmentKotlin$getShowMyNetworkConfig$2$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.f> $this_apply;
            final /* synthetic */ PermissionPrivacyFragmentKotlin this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$this_apply = xVar;
                this.this$0 = this;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) xVar, (Object) this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                QUIListItemAdapter adapter;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                x.c.f O = this.$this_apply.O();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                O.f(it.booleanValue());
                SettingOverScrollRecyclerView wh5 = this.this$0.wh();
                if (wh5 == null || (adapter = wh5.getAdapter()) == null) {
                    return;
                }
                adapter.l0(this.$this_apply);
            }
        };
        p16.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.settings.fragment.permissionprivacy.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PermissionPrivacyFragmentKotlin.fj(Function1.this, obj);
            }
        });
        xVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.settings.fragment.permissionprivacy.g
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                PermissionPrivacyFragmentKotlin.gj(PermissionPrivacyFragmentKotlin.this, view);
            }
        });
        return xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ej(PermissionPrivacyFragmentKotlin this$0, CompoundButton view, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(view, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!NetworkUtil.isNetSupport(this$0.getQBaseActivity())) {
            al alVar = this$0.privacyHelper;
            al alVar2 = null;
            if (alVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("privacyHelper");
                alVar = null;
            }
            alVar.v(R.string.cjl, 1);
            al alVar3 = this$0.privacyHelper;
            if (alVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("privacyHelper");
            } else {
                alVar2 = alVar3;
            }
            alVar2.p().postValue(Boolean.valueOf(!z16));
        } else {
            this$0.Vi().setVisibilityForNetWorkStatus(z16, true);
            ReportController.o(this$0.Vi(), "dc00898", "", "", "0X800B862", "0X800B862", z16 ? 1 : 0, 0, "", "", "", "");
            Intrinsics.checkNotNullExpressionValue(view, "view");
            this$0.oj(view, "em_bas_my_network_status_is_visible");
        }
        EventCollector.getInstance().onCompoundButtonChecked(view, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fj(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void gj(PermissionPrivacyFragmentKotlin this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "view");
        this$0.pj(view, "em_bas_my_network_status_is_visible");
    }

    private final com.tencent.mobileqq.widget.listitem.w<QUISingleLineListItem> hj() {
        String qqStr = HardCodeUtil.qqStr(R.string.x37);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.qq_setting_single_way_friends)");
        com.tencent.mobileqq.widget.listitem.x xVar = new com.tencent.mobileqq.widget.listitem.x(new x.b.C8996b(qqStr, R.drawable.qui_administering_user), new x.c.g("", false, false, 6, null));
        xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.settings.fragment.permissionprivacy.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PermissionPrivacyFragmentKotlin.ij(PermissionPrivacyFragmentKotlin.this, view);
            }
        });
        xVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.settings.fragment.permissionprivacy.m
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                PermissionPrivacyFragmentKotlin.jj(PermissionPrivacyFragmentKotlin.this, view);
            }
        });
        return xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ij(PermissionPrivacyFragmentKotlin this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent(this$0.getQBaseActivity(), (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", "https://ti.qq.com/friends/unidirection?_wv=2&_wwv=128&tuin=");
        this$0.startActivity(intent);
        ReportController.y(this$0.Vi(), "0X800B858");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void jj(PermissionPrivacyFragmentKotlin this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "view");
        this$0.pj(view, "em_bas_way_friend_management");
    }

    private final com.tencent.mobileqq.widget.listitem.w<QUISingleLineListItem> kj() {
        ReportController.y(Vi(), "0X800B7EE");
        String qqStr = HardCodeUtil.qqStr(R.string.f2047453q);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.qq_settting_special_care_friends)");
        final com.tencent.mobileqq.widget.listitem.x xVar = new com.tencent.mobileqq.widget.listitem.x(new x.b.C8996b(qqStr, R.drawable.qui_heart), new x.c.g("", false, false, 6, null));
        al alVar = this.privacyHelper;
        if (alVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("privacyHelper");
            alVar = null;
        }
        MutableLiveData<String> q16 = alVar.q();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<String, Unit> function1 = new Function1<String, Unit>(xVar, this) { // from class: com.tencent.mobileqq.settings.fragment.permissionprivacy.PermissionPrivacyFragmentKotlin$getSpecialCareFriendsConfig$1$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> $this_apply;
            final /* synthetic */ PermissionPrivacyFragmentKotlin this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$this_apply = xVar;
                this.this$0 = this;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) xVar, (Object) this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                QUIListItemAdapter adapter;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                x.c.g O = this.$this_apply.O();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                O.h(it);
                SettingOverScrollRecyclerView wh5 = this.this$0.wh();
                if (wh5 == null || (adapter = wh5.getAdapter()) == null) {
                    return;
                }
                adapter.l0(this.$this_apply);
            }
        };
        q16.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.settings.fragment.permissionprivacy.ah
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PermissionPrivacyFragmentKotlin.lj(Function1.this, obj);
            }
        });
        xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.settings.fragment.permissionprivacy.ai
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PermissionPrivacyFragmentKotlin.mj(PermissionPrivacyFragmentKotlin.this, view);
            }
        });
        xVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.settings.fragment.permissionprivacy.aj
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                PermissionPrivacyFragmentKotlin.nj(PermissionPrivacyFragmentKotlin.this, view);
            }
        });
        return xVar;
    }

    private final com.tencent.mobileqq.widget.listitem.w<QUISingleLineListItem> li() {
        ReportController.y(Vi(), "0X800B7FC");
        String title = HardCodeUtil.qqStr(R.string.f171136ci1);
        boolean locZanAllowedForPeople = Vi().getLocZanAllowedForPeople();
        Intrinsics.checkNotNullExpressionValue(title, "title");
        final com.tencent.mobileqq.widget.listitem.x xVar = new com.tencent.mobileqq.widget.listitem.x(new x.b.C8996b(title, R.drawable.qui_like), new x.c.f(locZanAllowedForPeople, new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.settings.fragment.permissionprivacy.a
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                PermissionPrivacyFragmentKotlin.mi(PermissionPrivacyFragmentKotlin.this, compoundButton, z16);
            }
        }));
        al alVar = this.privacyHelper;
        if (alVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("privacyHelper");
            alVar = null;
        }
        MutableLiveData<Boolean> f16 = alVar.f();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>(xVar, this) { // from class: com.tencent.mobileqq.settings.fragment.permissionprivacy.PermissionPrivacyFragmentKotlin$allowNearPeopleZanConfig$2$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.f> $this_apply;
            final /* synthetic */ PermissionPrivacyFragmentKotlin this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$this_apply = xVar;
                this.this$0 = this;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) xVar, (Object) this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                QUIListItemAdapter adapter;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                x.c.f O = this.$this_apply.O();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                O.f(it.booleanValue());
                SettingOverScrollRecyclerView wh5 = this.this$0.wh();
                if (wh5 == null || (adapter = wh5.getAdapter()) == null) {
                    return;
                }
                adapter.l0(this.$this_apply);
            }
        };
        f16.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.settings.fragment.permissionprivacy.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PermissionPrivacyFragmentKotlin.ni(Function1.this, obj);
            }
        });
        xVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.settings.fragment.permissionprivacy.w
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                PermissionPrivacyFragmentKotlin.oi(PermissionPrivacyFragmentKotlin.this, view);
            }
        });
        return xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void lj(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mi(PermissionPrivacyFragmentKotlin this$0, CompoundButton view, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(view, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!NetworkUtil.isNetSupport(this$0.getQBaseActivity())) {
            al alVar = this$0.privacyHelper;
            al alVar2 = null;
            if (alVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("privacyHelper");
                alVar = null;
            }
            alVar.v(R.string.cjl, 1);
            al alVar3 = this$0.privacyHelper;
            if (alVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("privacyHelper");
            } else {
                alVar2 = alVar3;
            }
            alVar2.f().postValue(Boolean.valueOf(!z16));
        } else {
            ReportController.o(this$0.Vi(), "CliOper", "", "", "Setting_tab", "Nearby_likeme", 0, z16 ? 1 : 0, String.valueOf(z16 ? 1 : 0), "", "", "");
            ReportController.o(this$0.Vi(), "dc00898", "", "", "0X800B860", "0X800B860", z16 ? 1 : 0, 0, "", "", "", "");
            this$0.Vi().setZanAllowed(true, z16);
            Intrinsics.checkNotNullExpressionValue(view, "view");
            this$0.oj(view, "em_bas_allow_strangers_to_like_me");
        }
        EventCollector.getInstance().onCompoundButtonChecked(view, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mj(PermissionPrivacyFragmentKotlin this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.startActivityForResult(new Intent(this$0.getQBaseActivity(), (Class<?>) SpecailCareListActivity.class), 2);
        ReportController.y(this$0.Vi(), "0X800B852");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ni(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void nj(PermissionPrivacyFragmentKotlin this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "view");
        this$0.pj(view, "em_bas_special_concern");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void oi(PermissionPrivacyFragmentKotlin this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "view");
        this$0.pj(view, "em_bas_allow_strangers_to_like_me");
    }

    private final void oj(View view, String id5) {
        VideoReport.setElementId(view, id5);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.reportEvent("dt_clck", view, null);
    }

    private final com.tencent.mobileqq.widget.listitem.w<QUISingleLineListItem> pi() {
        ReportController.y(Vi(), "0X800B7ED");
        String qqStr = HardCodeUtil.qqStr(R.string.f171519fs2);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.qq_setting_haoyou_yanzheng)");
        com.tencent.mobileqq.widget.listitem.x xVar = new com.tencent.mobileqq.widget.listitem.x(new x.b.C8996b(qqStr, R.drawable.qui_add_friend), new x.c.g("", false, false, 6, null));
        xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.settings.fragment.permissionprivacy.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PermissionPrivacyFragmentKotlin.qi(PermissionPrivacyFragmentKotlin.this, view);
            }
        });
        xVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.settings.fragment.permissionprivacy.t
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                PermissionPrivacyFragmentKotlin.ri(PermissionPrivacyFragmentKotlin.this, view);
            }
        });
        return xVar;
    }

    private final void pj(View view, String id5) {
        VideoReport.setElementId(view, id5);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void qi(PermissionPrivacyFragmentKotlin this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        INSTANCE.b(this$0.getQBaseActivity());
        ReportController.o(this$0.Vi(), "CliOper", "", "", "Setting_tab", "Vfc_method_clk", 0, 0, "", "", "", "");
        ReportController.y(this$0.Vi(), "0X800B851");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ri(PermissionPrivacyFragmentKotlin this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "view");
        this$0.pj(view, "em_bas_way_friend_me");
    }

    private final com.tencent.mobileqq.widget.listitem.w<QUISingleLineListItem> si() {
        ReportController.y(Vi(), "0X800B7FD");
        String title = HardCodeUtil.qqStr(R.string.f170320m7);
        Manager manager = Vi().getManager(QQManagerFactory.FRIENDS_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.app.FriendsManager");
        Card q16 = ((FriendsManager) manager).q(Vi().getCurrentAccountUin());
        Intrinsics.checkNotNullExpressionValue(title, "title");
        final com.tencent.mobileqq.widget.listitem.x xVar = new com.tencent.mobileqq.widget.listitem.x(new x.b.C8996b(title, R.drawable.qui_group), new x.c.f(q16.strangerInviteMeGroupOpen, new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.settings.fragment.permissionprivacy.h
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                PermissionPrivacyFragmentKotlin.ti(PermissionPrivacyFragmentKotlin.this, compoundButton, z16);
            }
        }));
        al alVar = this.privacyHelper;
        if (alVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("privacyHelper");
            alVar = null;
        }
        MutableLiveData<Boolean> g16 = alVar.g();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>(xVar, this) { // from class: com.tencent.mobileqq.settings.fragment.permissionprivacy.PermissionPrivacyFragmentKotlin$getAllowStrangerInviteConfig$2$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.f> $this_apply;
            final /* synthetic */ PermissionPrivacyFragmentKotlin this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$this_apply = xVar;
                this.this$0 = this;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) xVar, (Object) this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                QUIListItemAdapter adapter;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                x.c.f O = this.$this_apply.O();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                O.f(it.booleanValue());
                SettingOverScrollRecyclerView wh5 = this.this$0.wh();
                if (wh5 == null || (adapter = wh5.getAdapter()) == null) {
                    return;
                }
                adapter.l0(this.$this_apply);
            }
        };
        g16.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.settings.fragment.permissionprivacy.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PermissionPrivacyFragmentKotlin.ui(Function1.this, obj);
            }
        });
        xVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.settings.fragment.permissionprivacy.j
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                PermissionPrivacyFragmentKotlin.vi(PermissionPrivacyFragmentKotlin.this, view);
            }
        });
        return xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ti(PermissionPrivacyFragmentKotlin this$0, CompoundButton view, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(view, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!NetworkUtil.isNetSupport(this$0.getQBaseActivity())) {
            al alVar = this$0.privacyHelper;
            al alVar2 = null;
            if (alVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("privacyHelper");
                alVar = null;
            }
            alVar.v(R.string.cjl, 1);
            al alVar3 = this$0.privacyHelper;
            if (alVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("privacyHelper");
            } else {
                alVar2 = alVar3;
            }
            alVar2.g().postValue(Boolean.valueOf(!z16));
        } else {
            BusinessHandler businessHandler = this$0.Vi().getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
            Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.app.CardHandler");
            ((CardHandler) businessHandler).Y4(z16);
            if (z16) {
                ReportController.o(this$0.Vi(), "dc00898", "", "", "0X800B861", "0X800B861", 1, 0, "", "", "", "");
            } else {
                ReportController.y(this$0.Vi(), "0X800B861");
            }
            Intrinsics.checkNotNullExpressionValue(view, "view");
            this$0.oj(view, "em_bas_allowing_strangers_invite_me_join_group");
        }
        EventCollector.getInstance().onCompoundButtonChecked(view, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ui(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void vi(PermissionPrivacyFragmentKotlin this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "view");
        this$0.pj(view, "em_bas_allowing_strangers_invite_me_join_group");
    }

    private final com.tencent.mobileqq.widget.listitem.w<QUISingleLineListItem> wi() {
        String qqStr = HardCodeUtil.qqStr(R.string.f20415525);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.qq_setting_black_list)");
        final com.tencent.mobileqq.widget.listitem.x xVar = new com.tencent.mobileqq.widget.listitem.x(new x.b.C8996b(qqStr, R.drawable.qui_shield), new x.c.g("", false, false, 6, null));
        al alVar = this.privacyHelper;
        if (alVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("privacyHelper");
            alVar = null;
        }
        MutableLiveData<String> h16 = alVar.h();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<String, Unit> function1 = new Function1<String, Unit>(xVar, this) { // from class: com.tencent.mobileqq.settings.fragment.permissionprivacy.PermissionPrivacyFragmentKotlin$getBlackListConfig$1$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> $this_apply;
            final /* synthetic */ PermissionPrivacyFragmentKotlin this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$this_apply = xVar;
                this.this$0 = this;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) xVar, (Object) this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                QUIListItemAdapter qUIListItemAdapter;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                x.c.g O = this.$this_apply.O();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                O.h(it);
                qUIListItemAdapter = this.this$0.recyclerViewAdapter;
                qUIListItemAdapter.l0(this.$this_apply);
            }
        };
        h16.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.settings.fragment.permissionprivacy.aa
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PermissionPrivacyFragmentKotlin.xi(Function1.this, obj);
            }
        });
        xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.settings.fragment.permissionprivacy.ab
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PermissionPrivacyFragmentKotlin.yi(PermissionPrivacyFragmentKotlin.this, view);
            }
        });
        xVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.settings.fragment.permissionprivacy.ac
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                PermissionPrivacyFragmentKotlin.zi(PermissionPrivacyFragmentKotlin.this, view);
            }
        });
        return xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void yi(PermissionPrivacyFragmentKotlin this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QPublicFragmentActivity.start(this$0.getQBaseActivity(), new Intent(), BlackListFragment.class);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void zi(PermissionPrivacyFragmentKotlin this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "view");
        this$0.pj(view, "em_bas_blacklist_management");
    }

    @NotNull
    public final QQAppInterface Vi() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (QQAppInterface) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        QQAppInterface qQAppInterface = this.mApp;
        if (qQAppInterface != null) {
            return qQAppInterface;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mApp");
        return null;
    }

    public final void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        SettingOverScrollRecyclerView wh5 = wh();
        if (wh5 != null) {
            QUIListItemAdapter qUIListItemAdapter = this.recyclerViewAdapter;
            Group[] Di = Di();
            qUIListItemAdapter.t0((Group[]) Arrays.copyOf(Di, Di.length));
            wh5.setAdapter(qUIListItemAdapter);
        }
        al alVar = this.privacyHelper;
        if (alVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("privacyHelper");
            alVar = null;
        }
        alVar.t();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2) {
            al alVar = this.privacyHelper;
            if (alVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("privacyHelper");
                alVar = null;
            }
            alVar.F();
        }
    }

    @Override // com.tencent.mobileqq.setting.fragment.BaseSettingFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        boolean onBackEvent = super.onBackEvent();
        QBaseActivity qBaseActivity = getQBaseActivity();
        Intrinsics.checkNotNullExpressionValue(qBaseActivity, "qBaseActivity");
        com.tencent.mobileqq.app.nthiddenchat.b.d(qBaseActivity);
        return onBackEvent;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onDestroy();
        QBaseActivity qBaseActivity = getQBaseActivity();
        al alVar = this.privacyHelper;
        al alVar2 = null;
        if (alVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("privacyHelper");
            alVar = null;
        }
        qBaseActivity.removeObserver(alVar.n());
        al alVar3 = this.privacyHelper;
        if (alVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("privacyHelper");
        } else {
            alVar2 = alVar3;
        }
        alVar2.x();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        al alVar = this.privacyHelper;
        if (alVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("privacyHelper");
            alVar = null;
        }
        alVar.e();
        super.onResume();
    }

    @Override // com.tencent.mobileqq.setting.fragment.BaseSettingFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        SettingOverScrollRecyclerView wh5 = wh();
        if (wh5 != null) {
            wh5.setClipToPadding(false);
        }
        this.privacyHelper = new al();
        String qqStr = HardCodeUtil.qqStr(R.string.f20455538);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(titleRes)");
        setTitle(qqStr);
        if (getQBaseActivity().getAppRuntime() instanceof QQAppInterface) {
            AppRuntime appRuntime = getQBaseActivity().getAppRuntime();
            Intrinsics.checkNotNull(appRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
            qj((QQAppInterface) appRuntime);
        }
        init();
        al alVar = this.privacyHelper;
        al alVar2 = null;
        if (alVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("privacyHelper");
            alVar = null;
        }
        alVar.w();
        QBaseActivity qBaseActivity = getQBaseActivity();
        al alVar3 = this.privacyHelper;
        if (alVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("privacyHelper");
        } else {
            alVar2 = alVar3;
        }
        qBaseActivity.addObserver(alVar2.n());
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(view, "pg_bas_privacy_settings");
    }

    public final void qj(@NotNull QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) qQAppInterface);
        } else {
            Intrinsics.checkNotNullParameter(qQAppInterface, "<set-?>");
            this.mApp = qQAppInterface;
        }
    }
}
