package com.tencent.mobileqq.troop.teamup.api;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.biz.richframework.ext.RFWStringsKt;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.teamup.detail.fragment.TroopTeamUpDetailFragment;
import com.tencent.mobileqq.troop.teamup.home.fragment.TroopTeamUpHomeFragment;
import com.tencent.mobileqq.troop.teamup.member.fragment.TroopTeamUpMemberListFragment;
import com.tencent.mobileqq.troop.teamup.publish.fragment.TroopTeamUpPublishFragment;
import com.tencent.mobileqq.utils.StringUtils;
import com.tencent.mobileqq.utils.ax;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.TeamUpTeamDetail;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapWithDefaultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u001b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001d\u0010\t\u001a\u0004\u0018\u00010\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\f\u001a\u0004\u0018\u00010\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\b\u00a8\u0006\u0016\u00b2\u0006\u000e\u0010\u0015\u001a\u0004\u0018\u00010\u00048\nX\u008a\u0084\u0002"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/api/a;", "Lcom/tencent/mobileqq/utils/ax;", "", "b", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljava/util/HashMap;", "H", "()Ljava/lang/String;", "page_name", BdhLogUtil.LogTag.Tag_Req, "G", "group_code", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "Landroid/content/Context;", "context", "<init>", "(Lcom/tencent/common/app/business/BaseQQAppInterface;Landroid/content/Context;)V", ExifInterface.LATITUDE_SOUTH, "a", "team_id", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
final class a extends ax {
    static IPatchRedirector $redirector_;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    static final /* synthetic */ KProperty<Object>[] T;

    /* renamed from: Q, reason: from kotlin metadata */
    private final HashMap page_name;

    /* renamed from: R, reason: from kotlin metadata */
    private final HashMap group_code;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/api/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.teamup.api.a$a, reason: collision with other inner class name and from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55367);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            T = new KProperty[]{Reflection.property1(new PropertyReference1Impl(a.class, "page_name", "getPage_name()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "group_code", "getGroup_code()Ljava/lang/String;", 0)), Reflection.property0(new PropertyReference0Impl(a.class, "team_id", "<v#0>", 0))};
            INSTANCE = new Companion(null);
        }
    }

    public a(@Nullable BaseQQAppInterface baseQQAppInterface, @Nullable Context context) {
        super(baseQQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseQQAppInterface, (Object) context);
            return;
        }
        HashMap<String, String> hashMap = this.f307441f;
        this.page_name = hashMap;
        this.group_code = hashMap;
    }

    private static final String F(HashMap<String, String> hashMap) {
        Object orImplicitDefaultNullable;
        Intrinsics.checkNotNullExpressionValue(hashMap, "doAction$lambda$0(...)");
        orImplicitDefaultNullable = MapsKt__MapWithDefaultKt.getOrImplicitDefaultNullable(hashMap, T[2].getName());
        return (String) orImplicitDefaultNullable;
    }

    @Nullable
    public final String G() {
        Object orImplicitDefaultNullable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        HashMap hashMap = this.group_code;
        Intrinsics.checkNotNullExpressionValue(hashMap, "<get-group_code>(...)");
        orImplicitDefaultNullable = MapsKt__MapWithDefaultKt.getOrImplicitDefaultNullable(hashMap, T[1].getName());
        return (String) orImplicitDefaultNullable;
    }

    @Nullable
    public final String H() {
        Object orImplicitDefaultNullable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        HashMap hashMap = this.page_name;
        Intrinsics.checkNotNullExpressionValue(hashMap, "<get-page_name>(...)");
        orImplicitDefaultNullable = MapsKt__MapWithDefaultKt.getOrImplicitDefaultNullable(hashMap, T[0].getName());
        return (String) orImplicitDefaultNullable;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x0045. Please report as an issue. */
    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        String str;
        String str2;
        String str3;
        String str4;
        int i3;
        int i16;
        int i17;
        int i18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        QLog.i("TroopTeamUpJumpAction", 1, "doAction attrs=" + this.f307441f);
        String H = H();
        boolean z16 = false;
        if (H != null) {
            String str5 = "";
            switch (H.hashCode()) {
                case -1335224239:
                    if (H.equals("detail")) {
                        HashMap<String, String> hashMap = this.f307441f;
                        String str6 = hashMap.get("template_id");
                        if (str6 == null) {
                            str = "";
                        } else {
                            str = str6;
                        }
                        String str7 = this.f307441f.get("show_more");
                        if (str7 != null && RFWStringsKt.toIntOrDefault$default(str7, 0, 0, 2, null) == 0) {
                            z16 = true;
                        }
                        boolean z17 = !z16;
                        String G = G();
                        if (G == null) {
                            str2 = "";
                        } else {
                            str2 = G;
                        }
                        String F = F(hashMap);
                        if (F == null) {
                            str3 = "";
                        } else {
                            str3 = F;
                        }
                        TroopTeamUpDetailFragment.Companion companion = TroopTeamUpDetailFragment.INSTANCE;
                        Context context = this.f307437b;
                        if (context == null) {
                            context = BaseApplication.context;
                        }
                        Context context2 = context;
                        Intrinsics.checkNotNullExpressionValue(context2, "context ?: BaseApplication.context");
                        companion.b(context2, str2, str3, str, z17);
                        return true;
                    }
                    break;
                case -235365105:
                    if (H.equals("publish")) {
                        TroopTeamUpPublishFragment.Companion companion2 = TroopTeamUpPublishFragment.INSTANCE;
                        String G2 = G();
                        if (G2 == null) {
                            str4 = "";
                        } else {
                            str4 = G2;
                        }
                        TroopTeamUpPublishFragment.Companion.b(companion2, str4, null, null, 0, 12, null);
                        return true;
                    }
                    break;
                case 3322014:
                    if (H.equals("list")) {
                        TroopTeamUpHomeFragment.Companion companion3 = TroopTeamUpHomeFragment.INSTANCE;
                        String G3 = G();
                        if (G3 != null) {
                            str5 = G3;
                        }
                        companion3.a(str5);
                        return true;
                    }
                    break;
                case 948881689:
                    if (H.equals("members")) {
                        TeamUpTeamDetail teamUpTeamDetail = new TeamUpTeamDetail();
                        String str8 = this.f307441f.get("team_id");
                        if (str8 == null) {
                            str8 = "";
                        }
                        teamUpTeamDetail.teamId = str8;
                        teamUpTeamDetail.groupId = StringUtils.toLong(G());
                        String str9 = this.f307441f.get("team_title");
                        if (str9 != null) {
                            str5 = str9;
                        }
                        teamUpTeamDetail.title = str5;
                        String str10 = this.f307441f.get("state");
                        if (str10 != null) {
                            i3 = Integer.parseInt(str10);
                        } else {
                            i3 = 0;
                        }
                        teamUpTeamDetail.status = i3;
                        String str11 = this.f307441f.get("join_type");
                        if (str11 != null) {
                            i16 = Integer.parseInt(str11);
                        } else {
                            i16 = 0;
                        }
                        teamUpTeamDetail.joinType = i16;
                        String str12 = this.f307441f.get("join_limit");
                        if (str12 != null) {
                            i17 = Integer.parseInt(str12);
                        } else {
                            i17 = 0;
                        }
                        teamUpTeamDetail.joinLimit = i17;
                        String str13 = this.f307441f.get("template_id");
                        if (str13 != null) {
                            i18 = Integer.parseInt(str13);
                        } else {
                            i18 = 0;
                        }
                        teamUpTeamDetail.templateId = i18;
                        teamUpTeamDetail.newGroupId = StringUtils.toLong(this.f307441f.get("new_group_id"));
                        TroopTeamUpMemberListFragment.Companion companion4 = TroopTeamUpMemberListFragment.INSTANCE;
                        Context context3 = this.f307437b;
                        if (context3 == null) {
                            context3 = BaseApplication.context;
                        }
                        Intrinsics.checkNotNullExpressionValue(context3, "context ?: BaseApplication.context");
                        companion4.a(context3, teamUpTeamDetail, false);
                        return true;
                    }
                    break;
            }
        }
        return false;
    }
}
