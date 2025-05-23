package com.tencent.mobileqq.troop.troopsetting.part;

import android.app.Activity;
import android.content.Intent;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilecard.base.report.ProfileCardBlacklistReportConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.troopsetting.event.a;
import com.tencent.mobileqq.troop.troopsetting.vm.TroopSettingViewModel;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.eu;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.GroupMsgMask;
import com.tencent.qqnt.troop.ITroopListRepoApi;
import com.tencent.qqnt.troop.ITroopOperationRepoApi;
import com.tencent.qqnt.troop.TroopInfoRepo;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 T2\u00020\u0001:\u0001UB\u0007\u00a2\u0006\u0004\bR\u0010SJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000bH\u0002J\b\u0010\u0012\u001a\u00020\u0002H\u0002J\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\u000bH\u0002J\b\u0010\u0017\u001a\u00020\u0002H\u0002J\b\u0010\u0018\u001a\u00020\u0002H\u0002J\b\u0010\u0019\u001a\u00020\u0002H\u0002J\u0012\u0010\u001b\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J\u0015\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0016\u00a2\u0006\u0004\b \u0010!J\u0012\u0010$\u001a\u00020\u00022\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016J\u0006\u0010%\u001a\u00020\u0002J\u0006\u0010&\u001a\u00020\u0002J\u0012\u0010)\u001a\u00020\u00022\b\u0010(\u001a\u0004\u0018\u00010'H\u0016J\u0012\u0010*\u001a\u00020\u00022\b\u0010(\u001a\u0004\u0018\u00010'H\u0016R&\u0010/\u001a\u0012\u0012\u0004\u0012\u00020\u001f0+j\b\u0012\u0004\u0012\u00020\u001f`,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\"\u00105\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u000202008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\"\u0010<\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020:008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u00104R\"\u0010>\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020:008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b=\u00104R\"\u0010A\u001a\u000e\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u000202008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b@\u00104R\u0018\u0010E\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010I\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010L\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR0\u0010Q\u001a\u001e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130Mj\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013`N8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010P\u00a8\u0006V"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/part/TroopSettingChatConversationPart;", "Lcom/tencent/mobileqq/troop/troopsetting/part/h;", "", "ra", "da", "", "isChecked", "za", "isSetTop", "Ea", "Aa", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMsgMask;", "value", "ua", "", "result", "troopMask", "na", "ba", "", "tip", "nMask", "aa", "ta", "qa", "wa", "mask", "Da", "targetStatus", "Ba", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "G9", "()[Lcom/tencent/mobileqq/widget/listitem/Group;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "oa", "ma", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "onPartDestroy", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "e", "Ljava/util/ArrayList;", "groups", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", "f", "Lcom/tencent/mobileqq/widget/listitem/x;", "teacherChatConfig", "Lcom/tencent/mobileqq/troop/troopsetting/bizconfig/c;", tl.h.F, "Lcom/tencent/mobileqq/troop/troopsetting/bizconfig/c;", "chatHistoryConfigItem", "Lcom/tencent/mobileqq/widget/listitem/x$c$f;", "i", "msgStickConfig", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "msgShieldConfig", "Lcom/tencent/mobileqq/widget/listitem/x$b$b;", BdhLogUtil.LogTag.Tag_Conn, "msgSettingConfig", "Lcom/tencent/mobileqq/troop/troopsetting/bizconfig/k;", "D", "Lcom/tencent/mobileqq/troop/troopsetting/bizconfig/k;", "hindChatConfigItem", "Lcom/tencent/mobileqq/troop/troopsetting/bizconfig/n;", "E", "Lcom/tencent/mobileqq/troop/troopsetting/bizconfig/n;", "notificationConfigItem", UserInfo.SEX_FEMALE, "Z", "isSettingTroopMask", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "G", "Ljava/util/HashMap;", "daTongPageParams", "<init>", "()V", "H", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopSettingChatConversationPart extends h {
    static IPatchRedirector $redirector_;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> msgSettingConfig;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.troop.troopsetting.bizconfig.k hindChatConfigItem;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.troop.troopsetting.bizconfig.n notificationConfigItem;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isSettingTroopMask;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final HashMap<String, String> daTongPageParams;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<Group> groups;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> teacherChatConfig;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.troop.troopsetting.bizconfig.c chatHistoryConfigItem;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> msgStickConfig;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> msgShieldConfig;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/part/TroopSettingChatConversationPart$a;", "", "", "BTN_INDEX_ASSISTANT", "I", "BTN_INDEX_RECEIVE_NOT_NOTIFY", "BTN_INDEX_SHIELD", "", "CHANGE_MSG_NOTIFY_TIPS_VALUE", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopsetting.part.TroopSettingChatConversationPart$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public /* synthetic */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f301259a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60601);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[GroupMsgMask.values().length];
            try {
                iArr[GroupMsgMask.ASSISTANT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GroupMsgMask.SHIELD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[GroupMsgMask.RECEIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[GroupMsgMask.NOTIFY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f301259a = iArr;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60621);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopSettingChatConversationPart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.groups = new ArrayList<>();
            this.daTongPageParams = new HashMap<>();
        }
    }

    private final void Aa(boolean isChecked) {
        B9().O3(isChecked);
        GroupMsgMask groupMsgMask = B9().S2().troopmask;
        if (isChecked) {
            if (groupMsgMask != GroupMsgMask.NOTIFY) {
                QLog.e("TroopSettingChatConversationPart", 1, "troopMsgShieldCheckListener: checked msg shield btn, but origin mask is " + groupMsgMask);
                return;
            }
            ua(GroupMsgMask.RECEIVE);
        } else {
            GroupMsgMask groupMsgMask2 = GroupMsgMask.NOTIFY;
            if (groupMsgMask == groupMsgMask2) {
                QLog.e("TroopSettingChatConversationPart", 1, "troopMsgShieldCheckListener: unchecked msg shield btn, but origin mask is " + groupMsgMask);
                return;
            }
            ua(groupMsgMask2);
        }
        boolean z26 = B9().z2();
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> xVar = this.msgShieldConfig;
        if (xVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("msgShieldConfig");
            xVar = null;
        }
        E9(xVar, !z26);
        if (!z26) {
            eu.g("Grp_set_new", "grpData_admin", "Grp_msg_exp", 0, 0, B9().T2().troopUin);
        }
        com.tencent.mobileqq.troop.troopsetting.report.c.f301449a.w(z9(), isChecked, B9().T2());
        com.tencent.qqnt.notification.report.h.z(ProfileCardBlacklistReportConst.PAGE_ID_PG_CHAT_SETTING, "em_bas_friend_message_not_disturb", Boolean.valueOf(isChecked), this.daTongPageParams, null, 16, null);
    }

    private final void Ba(boolean targetStatus) {
        B9().O3(targetStatus);
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> xVar = this.msgShieldConfig;
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> xVar2 = null;
        if (xVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("msgShieldConfig");
            xVar = null;
        }
        x.c.f O = xVar.O();
        O.h(null);
        O.f(targetStatus);
        O.h(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.troop.troopsetting.part.ab
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                TroopSettingChatConversationPart.Ca(TroopSettingChatConversationPart.this, compoundButton, z16);
            }
        });
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> xVar3 = this.msgShieldConfig;
        if (xVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("msgShieldConfig");
        } else {
            xVar2 = xVar3;
        }
        D9(xVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ca(TroopSettingChatConversationPart this$0, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Aa(z16);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Da(GroupMsgMask mask) {
        boolean z16;
        String troopUin = B9().S2().getTroopUin();
        if (troopUin != null && troopUin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        B9().S2().troopmask = mask;
        ba();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ea(boolean isSetTop) {
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> xVar = this.msgStickConfig;
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> xVar2 = null;
        if (xVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("msgStickConfig");
            xVar = null;
        }
        x.c.f O = xVar.O();
        O.h(null);
        O.f(isSetTop);
        O.h(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.troop.troopsetting.part.z
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                TroopSettingChatConversationPart.Fa(TroopSettingChatConversationPart.this, compoundButton, z16);
            }
        });
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> xVar3 = this.msgStickConfig;
        if (xVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("msgStickConfig");
        } else {
            xVar2 = xVar3;
        }
        D9(xVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fa(TroopSettingChatConversationPart this$0, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.za(z16);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    private final String aa(String tip, GroupMsgMask nMask) {
        int i3 = b.f301259a[nMask.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    return getContext().getResources().getString(R.string.esr);
                }
                return tip;
            }
            return getContext().getResources().getString(R.string.bnx);
        }
        return getContext().getResources().getString(R.string.esn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ba() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopsetting.part.y
            @Override // java.lang.Runnable
            public final void run() {
                TroopSettingChatConversationPart.ca(TroopSettingChatConversationPart.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ca(TroopSettingChatConversationPart this$0) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str = this$0.B9().T2().troopUin;
        boolean z17 = true;
        if (!this$0.getPartHost().isAdded()) {
            QLog.i("TroopSettingChatConversationPart", 1, "fragment not attach activity");
            return;
        }
        String troopUin = this$0.B9().S2().getTroopUin();
        if (troopUin != null && troopUin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        GroupMsgMask mask = this$0.B9().S2().troopmask;
        com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> xVar = this$0.msgSettingConfig;
        com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> xVar2 = null;
        if (xVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("msgSettingConfig");
            xVar = null;
        }
        String obj = xVar.O().getText().toString();
        Intrinsics.checkNotNullExpressionValue(mask, "mask");
        String aa5 = this$0.aa(obj, mask);
        if (aa5 == null) {
            aa5 = "";
        }
        this$0.ta();
        if (!this$0.isSettingTroopMask) {
            GroupMsgMask groupMsgMask = GroupMsgMask.NOTIFY;
            if (mask == groupMsgMask) {
                if (this$0.B9().Q2()) {
                    this$0.Ba(false);
                }
            } else if (!this$0.B9().Q2()) {
                this$0.Ba(true);
            }
            com.tencent.mobileqq.troop.troopsetting.activity.a.f301056a.f();
            com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> xVar3 = this$0.msgSettingConfig;
            if (xVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("msgSettingConfig");
                xVar3 = null;
            }
            if (mask == groupMsgMask) {
                z17 = false;
            }
            this$0.E9(xVar3, z17);
        } else {
            com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> xVar4 = this$0.msgSettingConfig;
            if (xVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("msgSettingConfig");
                xVar4 = null;
            }
            this$0.E9(xVar4, this$0.B9().Q2());
        }
        com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> xVar5 = this$0.msgSettingConfig;
        if (xVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("msgSettingConfig");
            xVar5 = null;
        }
        xVar5.O().h(new QQText(aa5, 3));
        com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> xVar6 = this$0.msgSettingConfig;
        if (xVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("msgSettingConfig");
        } else {
            xVar2 = xVar6;
        }
        this$0.D9(xVar2);
        ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).clearTroopAssistTipTime(this$0.z9(), str);
        this$0.B9().b4(a.t.f301133a);
    }

    private final void da() {
        boolean z16;
        boolean z17;
        TroopInfo S2 = B9().S2();
        String troopUin = S2.getTroopUin();
        boolean z18 = true;
        if (troopUin != null && troopUin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && S2.isHomeworkTroop()) {
            String string = getContext().getString(R.string.kht);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026.qqstr_chatsett_fa29374e)");
            com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar = new com.tencent.mobileqq.widget.listitem.x<>(new x.b.d(string), new x.c.g("", false, false, 6, null));
            xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopsetting.part.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TroopSettingChatConversationPart.ea(TroopSettingChatConversationPart.this, view);
                }
            });
            xVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.troop.troopsetting.part.t
                @Override // com.tencent.mobileqq.widget.listitem.g
                public final void M(View view) {
                    TroopSettingChatConversationPart.ga(TroopSettingChatConversationPart.this, view);
                }
            });
            this.teacherChatConfig = xVar;
        }
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        this.chatHistoryConfigItem = new com.tencent.mobileqq.troop.troopsetting.bizconfig.c(activity, x9(), B9());
        String string2 = getContext().getString(R.string.f1384109h);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026p_msg_item_setting_stick)");
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> xVar2 = new com.tencent.mobileqq.widget.listitem.x<>(new x.b.d(string2), new x.c.f(S2.isTop, new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.troop.troopsetting.part.u
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z19) {
                TroopSettingChatConversationPart.ha(TroopSettingChatConversationPart.this, compoundButton, z19);
            }
        }));
        Intent intent = getActivity().getIntent();
        if (intent != null && intent.getBooleanExtra("KEY_IS_FROM_SCALE_CHAT", false)) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            xVar2.p(false);
        }
        this.msgStickConfig = xVar2;
        Activity activity2 = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity2, "activity");
        com.tencent.mobileqq.troop.troopsetting.bizconfig.k kVar = new com.tencent.mobileqq.troop.troopsetting.bizconfig.k(activity2, x9(), B9());
        this.hindChatConfigItem = kVar;
        kVar.e0();
        Activity activity3 = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity3, "activity");
        this.notificationConfigItem = new com.tencent.mobileqq.troop.troopsetting.bizconfig.n(activity3, B9());
        TroopSettingViewModel B9 = B9();
        if (S2.troopmask == GroupMsgMask.NOTIFY) {
            z18 = false;
        }
        B9.O3(z18);
        String string3 = getContext().getString(R.string.bns);
        Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri\u2026msg_receive_filter_title)");
        this.msgShieldConfig = new com.tencent.mobileqq.widget.listitem.x<>(new x.b.d(string3), new x.c.f(B9().Q2(), new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.troop.troopsetting.part.v
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z19) {
                TroopSettingChatConversationPart.ia(TroopSettingChatConversationPart.this, compoundButton, z19);
            }
        }));
        String string4 = getContext().getString(R.string.f23262752);
        Intrinsics.checkNotNullExpressionValue(string4, "context.getString(R.stri\u2026oop_chat_setting_str_new)");
        com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> xVar3 = new com.tencent.mobileqq.widget.listitem.x<>(new x.b.C8996b(string4, R.drawable.qui_list_symbol), new x.c.g("", false, false, 6, null));
        xVar3.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopsetting.part.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopSettingChatConversationPart.ja(TroopSettingChatConversationPart.this, view);
            }
        });
        xVar3.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.troop.troopsetting.part.x
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                TroopSettingChatConversationPart.la(TroopSettingChatConversationPart.this, view);
            }
        });
        this.msgSettingConfig = xVar3;
        ArrayList arrayList = new ArrayList();
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar4 = this.teacherChatConfig;
        com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> xVar5 = null;
        if (xVar4 != null) {
            if (xVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("teacherChatConfig");
                xVar4 = null;
            }
            arrayList.add(xVar4);
        }
        com.tencent.mobileqq.troop.troopsetting.bizconfig.c cVar = this.chatHistoryConfigItem;
        if (cVar != null) {
            arrayList.add(cVar);
        }
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> xVar6 = this.msgStickConfig;
        if (xVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("msgStickConfig");
            xVar6 = null;
        }
        arrayList.add(xVar6);
        com.tencent.mobileqq.troop.troopsetting.bizconfig.k kVar2 = this.hindChatConfigItem;
        if (kVar2 != null) {
            arrayList.add(kVar2);
        }
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> xVar7 = this.msgShieldConfig;
        if (xVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("msgShieldConfig");
            xVar7 = null;
        }
        arrayList.add(xVar7);
        com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> xVar8 = this.msgSettingConfig;
        if (xVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("msgSettingConfig");
        } else {
            xVar5 = xVar8;
        }
        arrayList.add(xVar5);
        com.tencent.mobileqq.troop.troopsetting.bizconfig.n nVar = this.notificationConfigItem;
        if (nVar != null) {
            arrayList.add(nVar);
        }
        ArrayList<Group> arrayList2 = new ArrayList<>();
        this.groups = arrayList2;
        CharSequence d16 = com.tencent.mobileqq.troop.troopsetting.activity.a.f301056a.d(getContext().getResources().getString(R.string.f20677598));
        Object[] array = arrayList.toArray(new com.tencent.mobileqq.widget.listitem.a[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = (com.tencent.mobileqq.widget.listitem.a[]) array;
        arrayList2.add(new Group(d16, (com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(aVarArr, aVarArr.length)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ea(TroopSettingChatConversationPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.oa();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ga(TroopSettingChatConversationPart this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        com.tencent.mobileqq.troop.troopsetting.report.c.f301449a.q(this$0.B9().T2());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ha(TroopSettingChatConversationPart this$0, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.za(z16);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ia(TroopSettingChatConversationPart this$0, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Aa(z16);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ja(TroopSettingChatConversationPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.qa();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void la(TroopSettingChatConversationPart this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        com.tencent.mobileqq.troop.troopsetting.report.c.f301449a.l(this$0.B9().T2());
    }

    private final void na(int result, GroupMsgMask troopMask) {
        boolean z16;
        String troopUin = B9().S2().getTroopUin();
        if (troopUin != null && troopUin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        if (result != 0) {
            if (getActivity() != null && !getActivity().isFinishing()) {
                QQToast makeText = QQToast.makeText(z9().getApp(), 1, getContext().getResources().getString(R.string.i8h), 0);
                Activity activity = getActivity();
                Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
                makeText.show(((QBaseActivity) activity).getTitleBarHeight());
                B9().n4();
                return;
            }
            return;
        }
        B9().S2().troopmask = troopMask;
        ba();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pa(TroopInfoData mTroopInfoData, TroopMemberInfo troopMemberInfo) {
        Intrinsics.checkNotNullParameter(mTroopInfoData, "$mTroopInfoData");
        eu.g("Grp_edu", "Grp_data", "teachermsg_Clk", 0, 0, mTroopInfoData.troopUin, eu.a(troopMemberInfo));
    }

    private final void qa() {
        if (this.isSettingTroopMask) {
            QQToast.makeText(getActivity(), 1, R.string.cpr, 0).show(getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            return;
        }
        wa();
        com.tencent.mobileqq.troop.troopsetting.report.c.f301449a.v(B9().T2());
        com.tencent.qqnt.notification.report.h.z(ProfileCardBlacklistReportConst.PAGE_ID_PG_CHAT_SETTING, "em_bas_friend_message_notification_settings", null, this.daTongPageParams, null, 16, null);
    }

    private final void ra() {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopsetting.part.aa
            @Override // java.lang.Runnable
            public final void run() {
                TroopSettingChatConversationPart.sa(TroopSettingChatConversationPart.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sa(TroopSettingChatConversationPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        HashMap<String, String> hashMap = this$0.daTongPageParams;
        String troopUin = this$0.B9().S2().getTroopUin();
        if (troopUin == null) {
            troopUin = "";
        }
        hashMap.put("to_uin", troopUin);
        this$0.daTongPageParams.put("is_qq_fri", "2");
        com.tencent.qqnt.notification.report.h.p(ProfileCardBlacklistReportConst.PAGE_ID_PG_CHAT_SETTING, this$0.daTongPageParams);
    }

    private final void ta() {
        boolean z26 = B9().z2();
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> xVar = this.msgShieldConfig;
        if (xVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("msgShieldConfig");
            xVar = null;
        }
        E9(xVar, !z26);
        boolean z16 = false;
        if (!z26) {
            eu.g("Grp_set_new", "grpData_admin", "Grp_msg_exp", 0, 0, B9().T2().troopUin);
        }
        TroopSettingViewModel B9 = B9();
        if (!z26 && !B9().Q2()) {
            z16 = true;
        }
        B9.b4(new a.p(z16));
    }

    private final void ua(final GroupMsgMask value) {
        boolean z16;
        String troopUin = B9().S2().getTroopUin();
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            com.tencent.mobileqq.troop.troopsetting.activity.a aVar = com.tencent.mobileqq.troop.troopsetting.activity.a.f301056a;
            Activity activity = getActivity();
            String string = getContext().getResources().getString(R.string.f171139ci4);
            Intrinsics.checkNotNullExpressionValue(string, "context.resources.getString(R.string.net_disable)");
            aVar.j(activity, 2, string, 1500);
            ba();
            return;
        }
        if (troopUin != null && troopUin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        this.isSettingTroopMask = true;
        ((ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class)).setGroupMsgMask(troopUin, value, i.a(this), new com.tencent.qqnt.troop.e() { // from class: com.tencent.mobileqq.troop.troopsetting.part.s
            @Override // com.tencent.qqnt.troop.e
            public final void onResult(boolean z17, int i3, String str) {
                TroopSettingChatConversationPart.va(GroupMsgMask.this, this, z17, i3, str);
            }
        });
        if (!B9().D2()) {
            MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
            Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
            if (!from.decodeBool("Change_Msg_Notify_Tips_Value", false)) {
                B9().I3(true);
                from.encodeBool("Change_Msg_Notify_Tips_Value", true);
                from.commitAsync();
                DialogUtil.createNoTitleDialog(getActivity(), getActivity().getResources().getString(R.string.esi), R.string.hkf, R.string.hkf, new DialogUtil.DialogOnClickAdapter(), null).show();
            }
        }
        ba();
        ReportController.o(z9(), "P_CliOper", "Grp_msg", "", "data_page", "Clk_setmsg", 0, 0, troopUin, String.valueOf(value.ordinal() - 1), "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void va(GroupMsgMask value, TroopSettingChatConversationPart this$0, boolean z16, int i3, String errMsg) {
        Intrinsics.checkNotNullParameter(value, "$value");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        QLog.i("TroopSettingChatConversationPart", 2, "[setGroupMsgMask]  result: " + i3 + ", errmsg: " + errMsg + ", groupMask: " + value);
        this$0.isSettingTroopMask = false;
        this$0.na(i3, value);
    }

    private final void wa() {
        boolean z16;
        final TroopInfo S2 = B9().S2();
        final TroopInfoData T2 = B9().T2();
        String troopUin = S2.getTroopUin();
        if (troopUin != null && troopUin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        ReportController.o(z9(), "P_CliOper", "Grp_msg", "", "data_page", "Clk_set", 0, 0, S2.troopuin, "", "0", "");
        String troopDisplayName = S2.getTroopDisplayName();
        Intrinsics.checkNotNullExpressionValue(troopDisplayName, "mTroopInfo.troopDisplayName");
        if (TextUtils.isEmpty(troopDisplayName)) {
            troopDisplayName = S2.troopuin;
            Intrinsics.checkNotNullExpressionValue(troopDisplayName, "mTroopInfo.troopuin");
        }
        SpannableString spannableStringFromColorNickText = ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).getSpannableStringFromColorNickText(getContext().getResources().getString(R.string.hwy, troopDisplayName), 16);
        Object actionSheetHelperCreateDialog = ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).actionSheetHelperCreateDialog(getActivity(), null);
        Intrinsics.checkNotNull(actionSheetHelperCreateDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        final ActionSheet actionSheet = (ActionSheet) actionSheetHelperCreateDialog;
        actionSheet.setMainTitle(spannableStringFromColorNickText);
        actionSheet.addRadioButton((CharSequence) getContext().getResources().getString(R.string.esr), false);
        actionSheet.addRadioButton((CharSequence) getContext().getResources().getString(R.string.esn), false);
        actionSheet.addRadioButton((CharSequence) getContext().getResources().getString(R.string.esj), false);
        GroupMsgMask groupMsgMask = S2.troopmask;
        Intrinsics.checkNotNullExpressionValue(groupMsgMask, "mTroopInfo.troopmask");
        int i3 = b.f301259a[groupMsgMask.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    actionSheet.setRadioButtonChecked(0);
                }
            } else {
                actionSheet.setRadioButtonChecked(2);
            }
        } else {
            actionSheet.setRadioButtonChecked(1);
        }
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.troop.troopsetting.part.r
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i16) {
                TroopSettingChatConversationPart.xa(TroopInfo.this, this, actionSheet, T2, view, i16);
            }
        });
        actionSheet.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void xa(TroopInfo mTroopInfo, TroopSettingChatConversationPart this$0, ActionSheet sheet, TroopInfoData mTroopInfoData, View view, int i3) {
        GroupMsgMask groupMsgMask;
        int i16;
        Intrinsics.checkNotNullParameter(mTroopInfo, "$mTroopInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(sheet, "$sheet");
        Intrinsics.checkNotNullParameter(mTroopInfoData, "$mTroopInfoData");
        try {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        groupMsgMask = GroupMsgMask.NOTIFY;
                    } else {
                        groupMsgMask = GroupMsgMask.SHIELD;
                        i16 = 2;
                    }
                } else {
                    groupMsgMask = GroupMsgMask.ASSISTANT;
                    i16 = 1;
                }
                if (groupMsgMask != mTroopInfo.troopmask) {
                    this$0.ua(groupMsgMask);
                }
                sheet.dismiss();
                eu.g("Grp_msg", "grpData_admin", "Close_setmsg", 0, 0, mTroopInfoData.troopUin, eu.c(mTroopInfoData), String.valueOf(i16));
                return;
            }
            groupMsgMask = GroupMsgMask.RECEIVE;
            sheet.dismiss();
            eu.g("Grp_msg", "grpData_admin", "Close_setmsg", 0, 0, mTroopInfoData.troopUin, eu.c(mTroopInfoData), String.valueOf(i16));
            return;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i("TroopSettingChatConversationPart", 2, e16.toString());
                return;
            }
            return;
        }
        i16 = 3;
        if (groupMsgMask != mTroopInfo.troopmask) {
        }
    }

    private final void za(final boolean isChecked) {
        TroopInfo S2 = B9().S2();
        final TroopInfoData T2 = B9().T2();
        String str = S2.troopuin;
        if (str != null) {
            Intrinsics.checkNotNullExpressionValue(str, "{\n            mTroopInfo.troopuin\n        }");
        } else {
            str = T2.troopUin;
            Intrinsics.checkNotNullExpressionValue(str, "{\n            mTroopInfoData.troopUin\n        }");
        }
        final String str2 = str;
        ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).requestSetTroopTop(getPartHost(), str2, isChecked, true, new Function1<Boolean, Unit>(str2, isChecked, this, T2) { // from class: com.tencent.mobileqq.troop.troopsetting.part.TroopSettingChatConversationPart$switchIsSetUpTroop$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ boolean $isChecked;
            final /* synthetic */ TroopInfoData $mTroopInfoData;
            final /* synthetic */ String $troopCode;
            final /* synthetic */ TroopSettingChatConversationPart this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$troopCode = str2;
                this.$isChecked = isChecked;
                this.this$0 = this;
                this.$mTroopInfoData = T2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, str2, Boolean.valueOf(isChecked), this, T2);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, z16);
                    return;
                }
                QLog.i("TroopSettingChatConversationPart", 1, "[switchIsSetUpTroop] result: " + z16 + ", troopUin: " + this.$troopCode + ", isTop: " + this.$isChecked);
                if (z16) {
                    com.tencent.mobileqq.troop.troopsetting.report.c.f301449a.x(this.this$0.z9(), this.$isChecked ? "open_stick" : "close_stick", this.$mTroopInfoData);
                    return;
                }
                TroopInfo troopInfoFromCache = TroopInfoRepo.INSTANCE.getTroopInfoFromCache(this.$troopCode);
                if (troopInfoFromCache == null) {
                    return;
                }
                this.this$0.B9().b4(new a.ag(troopInfoFromCache.isTop));
            }
        });
    }

    @Override // com.tencent.mobileqq.troop.troopsetting.part.h
    @NotNull
    public Group[] G9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Group[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        Object[] array = this.groups.toArray(new Group[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (Group[]) array;
    }

    public final void ma() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), null, null, new TroopSettingChatConversationPart$initObserver$1(this, null), 3, null);
    }

    public final void oa() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        Intent intent = new Intent();
        final TroopInfoData T2 = B9().T2();
        intent.putExtra("troop_uin", T2.troopUin);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_FROM, 19);
        intent.putExtra(AppConstants.Key.TROOP_INFO_MEMBER_NUM, T2.wMemberNum);
        RouteUtils.startActivityForResult(getActivity(), intent, "/troop/memberlist/TroopMemberList", 9);
        IRuntimeService runtimeService = z9().getRuntimeService(ITroopMemberInfoService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IT\u2026va, ProcessConstant.MAIN)");
        ((ITroopMemberInfoService) runtimeService).getTroopMemberInfoAsync(T2.troopUin, z9().getCurrentAccountUin(), "TroopSettingChatConversationPart", new ITroopMemberInfoService.a() { // from class: com.tencent.mobileqq.troop.troopsetting.part.q
            @Override // com.tencent.mobileqq.troop.api.ITroopMemberInfoService.a
            public final void a(TroopMemberInfo troopMemberInfo) {
                TroopSettingChatConversationPart.pa(TroopInfoData.this, troopMemberInfo);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        da();
        ma();
        ba();
        ra();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity);
            return;
        }
        super.onPartDestroy(activity);
        com.tencent.mobileqq.troop.troopsetting.activity.a.f301056a.a();
        com.tencent.qqnt.notification.report.h.t(ProfileCardBlacklistReportConst.PAGE_ID_PG_CHAT_SETTING, this.daTongPageParams);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
            return;
        }
        super.onPartResume(activity);
        com.tencent.mobileqq.troop.troopsetting.bizconfig.k kVar = this.hindChatConfigItem;
        if (kVar != null) {
            kVar.e0();
        }
    }
}
