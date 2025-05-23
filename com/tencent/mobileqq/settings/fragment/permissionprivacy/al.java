package com.tencent.mobileqq.settings.fragment.permissionprivacy;

import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ark.api.IArkModuleAPIAuthority;
import com.tencent.mobileqq.fragment.blacklist.proto.b;
import com.tencent.mobileqq.fragment.blacklist.userdb.ShieldUserDisplayManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mutualmark.oldlogic.FriendIntimateRelationshipHelper;
import com.tencent.mobileqq.phonecontact.api.IContactSyncService;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.api.IChatsUtil;
import com.tencent.qqnt.chats.biz.hiddenchat.IHiddenChatApi;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.RecentHiddenSesionInfo;
import com.tencent.qqnt.ntrelation.api.IFriendsTABService;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.ntrelation.intimateinfo.api.IIntimateInfoService;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\bZ\u0010[J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0004J\u0016\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eJ\u0006\u0010\u0012\u001a\u00020\u0004J\u0006\u0010\u0013\u001a\u00020\u0004J\u0006\u0010\u0014\u001a\u00020\u0004J\u0006\u0010\u0015\u001a\u00020\u0004J\u0006\u0010\u0016\u001a\u00020\u0004J\u0006\u0010\u0017\u001a\u00020\u0004J\u0006\u0010\u0018\u001a\u00020\u0004R\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00070\u00198\u0006\u00a2\u0006\f\n\u0004\b \u0010\u001c\u001a\u0004\b!\u0010\u001eR\u001d\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0006\u00a2\u0006\f\n\u0004\b#\u0010\u001c\u001a\u0004\b$\u0010\u001eR\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u001c\u001a\u0004\b&\u0010\u001eR\u001d\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00070\u00198\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u001c\u001a\u0004\b(\u0010\u001eR\u001d\u0010,\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0006\u00a2\u0006\f\n\u0004\b*\u0010\u001c\u001a\u0004\b+\u0010\u001eR\u001d\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00070\u00198\u0006\u00a2\u0006\f\n\u0004\b-\u0010\u001c\u001a\u0004\b.\u0010\u001eR\u001d\u00101\u001a\b\u0012\u0004\u0012\u00020\u00070\u00198\u0006\u00a2\u0006\f\n\u0004\b&\u0010\u001c\u001a\u0004\b0\u0010\u001eR$\u00108\u001a\u0004\u0018\u0001028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001d\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00070\u00198\u0006\u00a2\u0006\f\n\u0004\b+\u0010\u001c\u001a\u0004\b9\u0010\u001eR\u001d\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00070\u00198\u0006\u00a2\u0006\f\n\u0004\b(\u0010\u001c\u001a\u0004\b;\u0010\u001eR\u001d\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00070\u00198\u0006\u00a2\u0006\f\n\u0004\b$\u0010\u001c\u001a\u0004\b-\u0010\u001eR\u001d\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00070\u00198\u0006\u00a2\u0006\f\n\u0004\b!\u0010\u001c\u001a\u0004\b*\u0010\u001eR\u001d\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00070\u00198\u0006\u00a2\u0006\f\n\u0004\b?\u0010\u001c\u001a\u0004\b@\u0010\u001eR\u001d\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00070\u00198\u0006\u00a2\u0006\f\n\u0004\bB\u0010\u001c\u001a\u0004\bB\u0010\u001eR\u0014\u0010F\u001a\u00020D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010ER\"\u0010L\u001a\u00020G8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010H\u001a\u0004\b?\u0010I\"\u0004\bJ\u0010KR\u0014\u0010O\u001a\u00020M8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u0010NR\"\u0010V\u001a\u00020P8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u0014\u0010Y\u001a\u00020W8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010X\u00a8\u0006\\"}, d2 = {"Lcom/tencent/mobileqq/settings/fragment/permissionprivacy/al;", "", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "", "D", "y", "", "i", "B", "d", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "w", HippyTKDListViewAdapter.X, "", "nResID", "iconType", "v", UserInfo.SEX_FEMALE, "E", BdhLogUtil.LogTag.Tag_Conn, "u", "e", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "t", "Landroidx/lifecycle/MutableLiveData;", "", "a", "Landroidx/lifecycle/MutableLiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Landroidx/lifecycle/MutableLiveData;", "specialCareTextLD", "b", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "intimateRelationVisibleLD", "c", "l", "intimateRelationTextLD", tl.h.F, "blackListTextLD", "k", "hiddenChatVisibleLD", "f", "j", "hiddenChatTextLD", "g", "getArkAppAuthorityVisibleLD", "arkAppAuthorityVisibleLD", "r", "syncShuoshuoCheckLD", "Lcom/tencent/mobileqq/richstatus/StatusManager;", "Lcom/tencent/mobileqq/richstatus/StatusManager;", ReportConstant.COSTREPORT_PREFIX, "()Lcom/tencent/mobileqq/richstatus/StatusManager;", "setSyncShuoshuoStatusManager", "(Lcom/tencent/mobileqq/richstatus/StatusManager;)V", "syncShuoshuoStatusManager", "getSyncContactVisibleLD", "syncContactVisibleLD", "getSyncContactCheckLD", "syncContactCheckLD", "allowStrangerInviteSwitch", "allowNearPeopleZanSwitch", DomainData.DOMAIN_NAME, "p", "showMyNetwork", "o", "showMyInputStatus", "Lcom/tencent/mobileqq/app/CardObserver;", "Lcom/tencent/mobileqq/app/CardObserver;", "cardObserver", "Lcom/tencent/mobileqq/friends/intimate/d;", "Lcom/tencent/mobileqq/friends/intimate/d;", "()Lcom/tencent/mobileqq/friends/intimate/d;", "setMIntimateInfoObserver", "(Lcom/tencent/mobileqq/friends/intimate/d;)V", "mIntimateInfoObserver", "Lcom/tencent/qqnt/chats/biz/hiddenchat/d;", "Lcom/tencent/qqnt/chats/biz/hiddenchat/d;", "ntHiddenChatAsync", "Lcom/tencent/qqnt/kernel/invorker/d;", "Lcom/tencent/qqnt/kernel/invorker/d;", "getExpandRecentContactListener", "()Lcom/tencent/qqnt/kernel/invorker/d;", "setExpandRecentContactListener", "(Lcom/tencent/qqnt/kernel/invorker/d;)V", "expandRecentContactListener", "Lcom/tencent/mobileqq/richstatus/h;", "Lcom/tencent/mobileqq/richstatus/h;", "syncShuoShuoStatusListener", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class al {
    static IPatchRedirector $redirector_;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<String> specialCareTextLD;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> intimateRelationVisibleLD;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<String> intimateRelationTextLD;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<String> blackListTextLD;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> hiddenChatVisibleLD;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<String> hiddenChatTextLD;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> arkAppAuthorityVisibleLD;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> syncShuoshuoCheckLD;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private StatusManager syncShuoshuoStatusManager;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> syncContactVisibleLD;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> syncContactCheckLD;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> allowStrangerInviteSwitch;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> allowNearPeopleZanSwitch;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> showMyNetwork;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> showMyInputStatus;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CardObserver cardObserver;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.friends.intimate.d mIntimateInfoObserver;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.chats.biz.hiddenchat.d ntHiddenChatAsync;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.qqnt.kernel.invorker.d expandRecentContactListener;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.richstatus.h syncShuoShuoStatusListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/settings/fragment/permissionprivacy/al$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.settings.fragment.permissionprivacy.al$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
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
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0014J(\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0014J \u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H\u0014\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/settings/fragment/permissionprivacy/al$b", "Lcom/tencent/mobileqq/app/CardObserver;", "", "isSuccess", "", "uin", "forNearPeople", "allowed", "", "onSetCardSwitch", "voteAllowed", "praiseStatusAllowed", "onGetCardSwitch", "curSwitchValue", "preSwitchValue", "onGetAllowStrangerInviteToGroupSwitch", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b extends CardObserver {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) al.this);
            }
        }

        @Override // com.tencent.mobileqq.app.CardObserver
        protected void onGetAllowStrangerInviteToGroupSwitch(boolean isSuccess, boolean curSwitchValue, boolean preSwitchValue) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(isSuccess), Boolean.valueOf(curSwitchValue), Boolean.valueOf(preSwitchValue));
                return;
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (!isSuccess) {
                al.this.v(R.string.hhc, 1);
                Manager manager = peekAppRuntime.getManager(QQManagerFactory.FRIENDS_MANAGER);
                Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.app.FriendsManager");
                al.this.g().postValue(Boolean.valueOf(((FriendsManager) manager).q(peekAppRuntime.getCurrentAccountUin()).strangerInviteMeGroupOpen));
                return;
            }
            al.this.g().postValue(Boolean.valueOf(curSwitchValue));
        }

        @Override // com.tencent.mobileqq.app.CardObserver
        protected void onGetCardSwitch(boolean isSuccess, @NotNull String uin, boolean voteAllowed, boolean praiseStatusAllowed) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(isSuccess), uin, Boolean.valueOf(voteAllowed), Boolean.valueOf(praiseStatusAllowed));
                return;
            }
            Intrinsics.checkNotNullParameter(uin, "uin");
            if (!Intrinsics.areEqual(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin(), uin)) {
                return;
            }
            al.this.f().postValue(Boolean.valueOf(voteAllowed));
        }

        @Override // com.tencent.mobileqq.app.CardObserver
        protected void onSetCardSwitch(boolean isSuccess, @NotNull String uin, boolean forNearPeople, boolean allowed) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), uin, Boolean.valueOf(forNearPeople), Boolean.valueOf(allowed));
                return;
            }
            Intrinsics.checkNotNullParameter(uin, "uin");
            if (!Intrinsics.areEqual(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin(), uin)) {
                return;
            }
            if (!isSuccess) {
                al.this.v(R.string.hhc, 1);
            }
            if (forNearPeople) {
                al.this.f().postValue(Boolean.valueOf(allowed));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/settings/fragment/permissionprivacy/al$c", "Lcom/tencent/qqnt/kernel/invorker/d;", "", "listType", "unreadCnt", "", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "changedList", "", "O0", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class c implements com.tencent.qqnt.kernel.invorker.d {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) al.this);
            }
        }

        @Override // com.tencent.qqnt.kernel.invorker.d
        public void O0(int listType, int unreadCnt, @Nullable List<RecentContactInfo> changedList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(listType), Integer.valueOf(unreadCnt), changedList);
            } else {
                al.this.e();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0014J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/settings/fragment/permissionprivacy/al$d", "Lcom/tencent/mobileqq/friends/intimate/d;", "", "isSuccess", "", "friendUin", "isPush", "", "onDisbandIntimateRelationship", "onBandIntimateRelationship", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class d extends com.tencent.mobileqq.friends.intimate.d {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) al.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.friends.intimate.d
        public void onBandIntimateRelationship(boolean isSuccess, @NotNull String friendUin) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(isSuccess), friendUin);
                return;
            }
            Intrinsics.checkNotNullParameter(friendUin, "friendUin");
            super.onBandIntimateRelationship(isSuccess, friendUin);
            if (QLog.isColorLevel()) {
                QLog.i("PermissionPrivacyHelper", 2, "onBandIntimateRelationship");
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                QLog.i("PermissionPrivacyHelper", 1, "peekAppRuntime() is null");
            } else if (peekAppRuntime instanceof QQAppInterface) {
                al.this.D((QQAppInterface) peekAppRuntime);
            } else {
                QLog.i("PermissionPrivacyHelper", 1, "app isn't QQAppInterface");
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.friends.intimate.d
        public void onDisbandIntimateRelationship(boolean isSuccess, @NotNull String friendUin, boolean isPush) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), friendUin, Boolean.valueOf(isPush));
                return;
            }
            Intrinsics.checkNotNullParameter(friendUin, "friendUin");
            super.onDisbandIntimateRelationship(isSuccess, friendUin, isPush);
            if (QLog.isColorLevel()) {
                QLog.i("PermissionPrivacyHelper", 2, "onDisbandIntimateRelationship");
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                QLog.i("PermissionPrivacyHelper", 1, "peekAppRuntime() is null");
            } else if (peekAppRuntime instanceof QQAppInterface) {
                al.this.D((QQAppInterface) peekAppRuntime);
            } else {
                QLog.i("PermissionPrivacyHelper", 1, "app isn't QQAppInterface");
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J$\u0010\u000e\u001a\u00020\b2\u001a\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\fH\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/settings/fragment/permissionprivacy/al$e", "Lcom/tencent/qqnt/chats/biz/hiddenchat/d;", "", "unReadSwitch", "", "unReadNum", "Landroid/widget/TextView;", "mUnReadMsg", "", "a", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentHiddenSesionInfo;", "Lkotlin/collections/ArrayList;", "hiddenChatList", "b", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class e implements com.tencent.qqnt.chats.biz.hiddenchat.d {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) al.this);
            }
        }

        @Override // com.tencent.qqnt.chats.biz.hiddenchat.d
        public void a(boolean unReadSwitch, int unReadNum, @Nullable TextView mUnReadMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(unReadSwitch), Integer.valueOf(unReadNum), mUnReadMsg);
                return;
            }
            if (!unReadSwitch) {
                al.this.j().postValue("");
                return;
            }
            QLog.d("PermissionPrivacyHelper", 1, "get no read num: " + unReadNum);
            if (unReadNum > 99) {
                al.this.j().postValue("99+");
                return;
            }
            if (unReadNum > 0) {
                MutableLiveData<String> j3 = al.this.j();
                StringBuilder sb5 = new StringBuilder();
                sb5.append(unReadNum);
                j3.postValue(sb5.toString());
                return;
            }
            al.this.j().postValue("");
        }

        @Override // com.tencent.qqnt.chats.biz.hiddenchat.d
        public void b(@Nullable ArrayList<RecentHiddenSesionInfo> hiddenChatList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) hiddenChatList);
                return;
            }
            if (hiddenChatList != null && (!hiddenChatList.isEmpty())) {
                QLog.d(LogTag.TAG_HIDDEN_CHAT, 1, "HiddenChat List Num is \uff1a" + hiddenChatList.size());
            }
            if ((hiddenChatList == null || hiddenChatList.isEmpty()) && al.this.i()) {
                al.this.k().postValue(Boolean.FALSE);
            } else {
                al.this.k().postValue(Boolean.TRUE);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/settings/fragment/permissionprivacy/al$f", "Lcom/tencent/mobileqq/richstatus/h;", "", "result", "Lcom/tencent/mobileqq/richstatus/RichStatus;", "status", "", "url", "", "onChangeStatus", "", "currentSync", "onGetSyncShuoShuo", "onSetSyncShuoShuo", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class f implements com.tencent.mobileqq.richstatus.h {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) al.this);
            }
        }

        @Override // com.tencent.mobileqq.richstatus.h
        public void onChangeStatus(int result, @NotNull RichStatus status, @NotNull Object url) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(result), status, url);
            } else {
                Intrinsics.checkNotNullParameter(status, "status");
                Intrinsics.checkNotNullParameter(url, "url");
            }
        }

        @Override // com.tencent.mobileqq.richstatus.h
        public void onGetSyncShuoShuo(int result, boolean currentSync) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(result), Boolean.valueOf(currentSync));
            } else {
                al.this.r().postValue(Boolean.valueOf(currentSync));
            }
        }

        @Override // com.tencent.mobileqq.richstatus.h
        public void onSetSyncShuoShuo(int result, boolean currentSync) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Integer.valueOf(result), Boolean.valueOf(currentSync));
                return;
            }
            if (result == -1) {
                com.tencent.mobileqq.guild.util.qqui.g.c(0, R.string.hhc);
            }
            StatusManager s16 = al.this.s();
            if (s16 != null) {
                al.this.r().postValue(Boolean.valueOf(s16.S()));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/settings/fragment/permissionprivacy/al$g", "Lcom/tencent/mobileqq/fragment/blacklist/proto/b$d;", "", "seq", "", "count", "", "a", "Lcom/tencent/mobileqq/fragment/blacklist/userdb/ShieldUserDisplayManager$a;", "data", "b", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class g implements b.d {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) al.this);
            }
        }

        @Override // com.tencent.mobileqq.fragment.blacklist.proto.b.d
        public void a(long seq, int count) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Long.valueOf(seq), Integer.valueOf(count));
            } else if (count > 0) {
                al.this.h().postValue(HardCodeUtil.qqStr(R.string.f20416526));
            } else {
                al.this.h().postValue("");
            }
        }

        @Override // com.tencent.mobileqq.fragment.blacklist.proto.b.d
        public void b(@NotNull ShieldUserDisplayManager.a data) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) data);
            } else {
                Intrinsics.checkNotNullParameter(data, "data");
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0003H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/settings/fragment/permissionprivacy/al$h", "Lhx3/b;", "", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/e;", WebViewPlugin.KEY_RESPONSE, "", "onQueryResult", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class h implements hx3.b<Integer> {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) al.this);
            }
        }

        @Override // hx3.b
        public void onQueryResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<Integer> responseData) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) responseData);
                return;
            }
            if (responseData == null || responseData.a() != 0) {
                return;
            }
            int i3 = 0;
            if (responseData.b() != null) {
                ArrayList<Integer> b16 = responseData.b();
                Intrinsics.checkNotNull(b16);
                Integer num = b16.get(0);
                Intrinsics.checkNotNullExpressionValue(num, "responseData.data!![0]");
                i3 = num.intValue();
            }
            if (QLog.isColorLevel()) {
                QLog.i("PermissionPrivacyHelper", 2, "updateIntimateRelationshipFriendCount number:" + i3);
            }
            if (i3 > 0) {
                al.this.l().postValue(i3 + HardCodeUtil.qqStr(R.string.juf));
                return;
            }
            al.this.l().postValue("");
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60443);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 32)) {
            redirector.redirect((short) 32);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public al() {
        Manager manager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.specialCareTextLD = new MutableLiveData<>();
        this.intimateRelationVisibleLD = new MutableLiveData<>();
        this.intimateRelationTextLD = new MutableLiveData<>();
        this.blackListTextLD = new MutableLiveData<>();
        this.hiddenChatVisibleLD = new MutableLiveData<>();
        this.hiddenChatTextLD = new MutableLiveData<>();
        this.arkAppAuthorityVisibleLD = new MutableLiveData<>();
        this.syncShuoshuoCheckLD = new MutableLiveData<>();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            manager = peekAppRuntime.getManager(QQManagerFactory.STATUS_MANAGER);
        } else {
            manager = null;
        }
        this.syncShuoshuoStatusManager = (StatusManager) manager;
        this.syncContactVisibleLD = new MutableLiveData<>();
        this.syncContactCheckLD = new MutableLiveData<>();
        this.allowStrangerInviteSwitch = new MutableLiveData<>();
        this.allowNearPeopleZanSwitch = new MutableLiveData<>();
        this.showMyNetwork = new MutableLiveData<>();
        this.showMyInputStatus = new MutableLiveData<>();
        this.cardObserver = new b();
        this.mIntimateInfoObserver = new d();
        this.ntHiddenChatAsync = new e();
        this.expandRecentContactListener = new c();
        this.syncShuoShuoStatusListener = new f();
    }

    private final void B() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.i("PermissionPrivacyHelper", 1, "peekAppRuntime() is null");
        } else if (((IArkModuleAPIAuthority) QRoute.api(IArkModuleAPIAuthority.class)).getArkAuthorityAppList(peekAppRuntime.getCurrentAccountUin()).size() > 0) {
            this.arkAppAuthorityVisibleLD.postValue(Boolean.TRUE);
        } else {
            this.arkAppAuthorityVisibleLD.postValue(Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(QQAppInterface app) {
        ((IIntimateInfoService) QRoute.api(IIntimateInfoService.class)).getBindIntimateRelationshipFriendCount("PermissionPrivacyHelper", new h());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(al this$0) {
        Unit unit;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.qqnt.ntrelation.friendsinfo.bean.a friendsCategoryBaseInfo = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsCategoryBaseInfo(String.valueOf(((IFriendsTABService) QRoute.api(IFriendsTABService.class)).getSpecialCareCategoryId()), "PermissionPrivacyHelper");
        if (friendsCategoryBaseInfo != null) {
            int c16 = friendsCategoryBaseInfo.c();
            if (c16 > 0) {
                this$0.specialCareTextLD.postValue(c16 + HardCodeUtil.qqStr(R.string.juf));
            } else {
                this$0.specialCareTextLD.postValue("");
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QLog.i("PermissionPrivacyHelper", 1, "specailCare categoryMbCount is null");
        }
    }

    private final void d() {
        StatusManager statusManager = this.syncShuoshuoStatusManager;
        if (statusManager != null) {
            statusManager.C(this.syncShuoShuoStatusListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean i() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.d("PermissionPrivacyHelper", 1, "getHiddenChatDismissFeatureSwitch appRuntime null");
            return false;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
        boolean isFeatureSwitchEnable = ((IFeatureRuntimeService) runtimeService).isFeatureSwitchEnable("hidden_chat_change_switch");
        QLog.d("PermissionPrivacyHelper", 1, "getHiddenChatDismissFeatureSwitch: status: " + isFeatureSwitchEnable);
        return isFeatureSwitchEnable;
    }

    private final void y() {
        Unit unit;
        IKernelService iKernelService;
        com.tencent.qqnt.kernel.api.aa recentContactService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (iKernelService = (IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")) != null && (recentContactService = iKernelService.getRecentContactService()) != null) {
            recentContactService.removeExpandRecentContactListener(this.expandRecentContactListener);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QLog.i("PermissionPrivacyHelper", 1, "fetch RecentContact fail");
        }
    }

    private final void z() {
        StatusManager statusManager = this.syncShuoshuoStatusManager;
        if (statusManager != null) {
            statusManager.b0(this.syncShuoShuoStatusListener);
        }
    }

    public final void A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.i("PermissionPrivacyHelper", 1, "peekAppRuntime() is null");
            return;
        }
        if (!(peekAppRuntime instanceof QQAppInterface)) {
            QLog.i("PermissionPrivacyHelper", 1, "appRuntime !is QQAppInterface");
            return;
        }
        IRuntimeService runtimeService = ((QQAppInterface) peekAppRuntime).getRuntimeService(IContactSyncService.class);
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026tSyncService::class.java)");
        IContactSyncService iContactSyncService = (IContactSyncService) runtimeService;
        if (iContactSyncService.isSyncSupportForTheDevice()) {
            this.syncContactVisibleLD.postValue(Boolean.TRUE);
            this.syncContactCheckLD.postValue(Boolean.valueOf(iContactSyncService.isSyncContactAllowed()));
        } else {
            this.syncContactVisibleLD.postValue(Boolean.FALSE);
        }
    }

    public final void C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.i("PermissionPrivacyHelper", 1, "peekAppRuntime() is null");
        } else {
            new com.tencent.mobileqq.fragment.blacklist.proto.b().a(peekAppRuntime, new g());
        }
    }

    public final void E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.i("PermissionPrivacyHelper", 1, "peekAppRuntime() is null");
            return;
        }
        if (FriendIntimateRelationshipHelper.m(peekAppRuntime.getCurrentUin()) && (peekAppRuntime instanceof QQAppInterface)) {
            this.intimateRelationVisibleLD.postValue(Boolean.TRUE);
            ReportController.o(peekAppRuntime, "dc00898", "", "", "0X8009F73", "0X8009F73", 0, 0, "", "", "", "");
            D((QQAppInterface) peekAppRuntime);
            return;
        }
        this.intimateRelationVisibleLD.postValue(Boolean.FALSE);
    }

    public final void F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.settings.fragment.permissionprivacy.ak
                @Override // java.lang.Runnable
                public final void run() {
                    al.G(al.this);
                }
            }, 16, null, true);
        }
    }

    public final void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
            return;
        }
        int unreadCountByListType = ((IChatsUtil) QRoute.api(IChatsUtil.class)).getUnreadCountByListType(5);
        QLog.d("PermissionPrivacyHelper", 1, "fetchUnReadCount no read num: " + unreadCountByListType);
        ((IHiddenChatApi) QRoute.api(IHiddenChatApi.class)).getShowUnReadNum(this.ntHiddenChatAsync, unreadCountByListType, null);
    }

    @NotNull
    public final MutableLiveData<Boolean> f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.allowNearPeopleZanSwitch;
    }

    @NotNull
    public final MutableLiveData<Boolean> g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.allowStrangerInviteSwitch;
    }

    @NotNull
    public final MutableLiveData<String> h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.blackListTextLD;
    }

    @NotNull
    public final MutableLiveData<String> j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.hiddenChatTextLD;
    }

    @NotNull
    public final MutableLiveData<Boolean> k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.hiddenChatVisibleLD;
    }

    @NotNull
    public final MutableLiveData<String> l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.intimateRelationTextLD;
    }

    @NotNull
    public final MutableLiveData<Boolean> m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.intimateRelationVisibleLD;
    }

    @NotNull
    public final com.tencent.mobileqq.friends.intimate.d n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (com.tencent.mobileqq.friends.intimate.d) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return this.mIntimateInfoObserver;
    }

    @NotNull
    public final MutableLiveData<Boolean> o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return this.showMyInputStatus;
    }

    @NotNull
    public final MutableLiveData<Boolean> p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.showMyNetwork;
    }

    @NotNull
    public final MutableLiveData<String> q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.specialCareTextLD;
    }

    @NotNull
    public final MutableLiveData<Boolean> r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.syncShuoshuoCheckLD;
    }

    @Nullable
    public final StatusManager s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (StatusManager) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.syncShuoshuoStatusManager;
    }

    public final void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
            return;
        }
        F();
        E();
        C();
        u();
        B();
        A();
    }

    public final void u() {
        Unit unit;
        IKernelService iKernelService;
        com.tencent.qqnt.kernel.api.aa recentContactService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        ((IHiddenChatApi) QRoute.api(IHiddenChatApi.class)).getAllHiddenChat(this.ntHiddenChatAsync);
        if (peekAppRuntime != null && (iKernelService = (IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")) != null && (recentContactService = iKernelService.getRecentContactService()) != null) {
            recentContactService.addExpandRecentContactListener(this.expandRecentContactListener);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QLog.i("PermissionPrivacyHelper", 1, "fetch RecentContact fail");
        }
    }

    public final void v(int nResID, int iconType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Integer.valueOf(nResID), Integer.valueOf(iconType));
        } else {
            BaseApplication context = BaseApplication.getContext();
            QQToast.makeText(context, iconType, nResID, 0).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        }
    }

    public final void w() {
        AppInterface appInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            appInterface.addObserver(this.cardObserver);
        }
        d();
    }

    public final void x() {
        AppInterface appInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            appInterface.removeObserver(this.cardObserver);
        }
        y();
        z();
    }
}
