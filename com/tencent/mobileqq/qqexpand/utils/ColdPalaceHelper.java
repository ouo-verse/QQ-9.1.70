package com.tencent.mobileqq.qqexpand.utils;

import android.content.SharedPreferences;
import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ea;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b>\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0014\u00a2\u0006\u0004\bV\u0010WJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\t\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0002J\u0016\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rJ\u000e\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011R\u0017\u0010\u0018\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017R\u001b\u0010\u001d\u001a\u00020\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001f\u001a\u00020\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\u001a\u001a\u0004\b\u001e\u0010\u001cR\u001b\u0010\"\u001a\u00020\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010\u001a\u001a\u0004\b!\u0010\u001cR\u001b\u0010$\u001a\u00020\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001a\u001a\u0004\b#\u0010\u001cR\u001b\u0010&\u001a\u00020\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b%\u0010\u001cR\"\u0010+\u001a\u00020\u00048\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b#\u0010'\u001a\u0004\b(\u0010\u001c\"\u0004\b)\u0010*R\"\u0010.\u001a\u00020\u00048\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b%\u0010'\u001a\u0004\b,\u0010\u001c\"\u0004\b-\u0010*R\"\u00101\u001a\u00020\u00048\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b!\u0010'\u001a\u0004\b/\u0010\u001c\"\u0004\b0\u0010*R\"\u00105\u001a\u00020\u00048\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b2\u0010'\u001a\u0004\b3\u0010\u001c\"\u0004\b4\u0010*R\"\u00108\u001a\u00020\u00048\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b(\u0010'\u001a\u0004\b6\u0010\u001c\"\u0004\b7\u0010*R\"\u0010>\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010A\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u00109\u001a\u0004\b?\u0010;\"\u0004\b@\u0010=R\"\u0010G\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\"\u0010J\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010B\u001a\u0004\bH\u0010D\"\u0004\bI\u0010FR\"\u0010P\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\"\u0010R\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010K\u001a\u0004\b2\u0010M\"\u0004\bQ\u0010OR\u001b\u0010U\u001a\u00020S8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b \u0010T\u00a8\u0006X"}, d2 = {"Lcom/tencent/mobileqq/qqexpand/utils/ColdPalaceHelper;", "", "", "type", "", "p", "wording", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "c", Element.ELEMENT_NAME_TIMES, "u", "r", "", "time", "nowTs", "t", "", "show", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/app/QQAppInterface;", "a", "Lcom/tencent/mobileqq/app/QQAppInterface;", "()Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "b", "Lkotlin/Lazy;", "e", "()Ljava/lang/String;", "strSkillTip", "f", "strSkillUseupTip", "d", "i", "strWarnMeInColdPalace", "g", "strWarnMeForbbiden", tl.h.F, "strWarnMeFreeTime", "Ljava/lang/String;", "k", "v", "(Ljava/lang/String;)V", "svrStrSkillTip", "l", "w", "svrStrSkillUseupTip", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, HippyTKDListViewAdapter.X, "svrStrSkillUseupTitle", "j", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "svrStrWarnMeInColdPalace", DomainData.DOMAIN_NAME, "y", "svrStrWarnMeForbbiden", "J", "getSvrPunishLeftTime", "()J", "setSvrPunishLeftTime", "(J)V", "svrPunishLeftTime", "getSvrPunishTimeSince", "setSvrPunishTimeSince", "svrPunishTimeSince", "I", "getSvrSkillTimesLeft", "()I", "setSvrSkillTimesLeft", "(I)V", "svrSkillTimesLeft", "getSvrMeInColdPalaceTimes", "setSvrMeInColdPalaceTimes", "svrMeInColdPalaceTimes", "Z", "getNeedWarnMeInColdPalace", "()Z", "setNeedWarnMeInColdPalace", "(Z)V", "needWarnMeInColdPalace", "setSvrShowGrayTipEntry", "svrShowGrayTipEntry", "Landroid/content/SharedPreferences;", "()Landroid/content/SharedPreferences;", "sp", "<init>", "(Lcom/tencent/mobileqq/app/QQAppInterface;)V", "qqexpand_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ColdPalaceHelper {

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final QQAppInterface app;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Lazy strSkillTip;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Lazy strSkillUseupTip;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy strWarnMeInColdPalace;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy strWarnMeForbbiden;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy strWarnMeFreeTime;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public volatile String svrStrSkillTip;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public volatile String svrStrSkillUseupTip;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public volatile String svrStrSkillUseupTitle;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public volatile String svrStrWarnMeInColdPalace;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public volatile String svrStrWarnMeForbbiden;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private volatile long svrPunishLeftTime;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private volatile long svrPunishTimeSince;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private volatile int svrSkillTimesLeft;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private volatile int svrMeInColdPalaceTimes;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private volatile boolean needWarnMeInColdPalace;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private volatile boolean svrShowGrayTipEntry;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private final Lazy sp;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b \u0010!J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\bR\u0014\u0010\u000e\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\bR\u0014\u0010\u000f\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\bR\u0014\u0010\u0010\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\bR\u0014\u0010\u0011\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\bR\u0014\u0010\u0012\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\bR\u0014\u0010\u0013\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\bR\u0014\u0010\u0014\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\bR\u0014\u0010\u0015\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\bR\u0014\u0010\u0016\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\bR\u0014\u0010\u0017\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\bR\u0014\u0010\u0019\u001a\u00020\u00188\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00188\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u00188\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u00188\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u00188\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u00188\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001a\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/qqexpand/utils/ColdPalaceHelper$a;", "", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "Lcom/tencent/mobileqq/qqexpand/utils/ColdPalaceHelper;", "a", "", "COLD_PALACE_IMAGE_URL", "Ljava/lang/String;", "", "PUNISH_FOREVER", "J", "PUNISH_NONE", "SP_FILE", "SP_KEY_ME_IN_COLD_PALACE_TIMES", "SP_KEY_PUNISH_LEFT_TIME", "SP_KEY_PUNISH_TIME_SINCE", "SP_KEY_SHOW_GRAY_TIP_ENTRY", "SP_KEY_SKILL_TIP", "SP_KEY_SKILL_USEUP_TIP", "SP_KEY_SKILL_USEUP_TITLE", "SP_KEY_WARN_ME_FORBBIDEN", "SP_KEY_WARN_ME_IN_COLDPALACE", "TAG", "", "type_skill_tip", "I", "type_skill_useup_tip", "type_skill_useup_title", "type_warn_free_time_tip", "type_warn_me_forbbiden", "type_warn_me_in_coldpalace_tip", "<init>", "()V", "qqexpand_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqexpand.utils.ColdPalaceHelper$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final ColdPalaceHelper a(BaseQQAppInterface app) {
            Intrinsics.checkNotNullParameter(app, "app");
            Object coldPalaceHelper = ((IColdPalaceUtils) QRoute.api(IColdPalaceUtils.class)).getColdPalaceHelper(app);
            Intrinsics.checkNotNull(coldPalaceHelper, "null cannot be cast to non-null type com.tencent.mobileqq.qqexpand.utils.ColdPalaceHelper");
            return (ColdPalaceHelper) coldPalaceHelper;
        }

        Companion() {
        }
    }

    public ColdPalaceHelper(QQAppInterface app) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Intrinsics.checkNotNullParameter(app, "app");
        this.app = app;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.qqexpand.utils.ColdPalaceHelper$strSkillTip$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String string = ColdPalaceHelper.this.getApp().getApplication().getResources().getString(R.string.f198444mq);
                Intrinsics.checkNotNullExpressionValue(string, "app.application.resource\u2026end_coldpalace_skill_tip)");
                return string;
            }
        });
        this.strSkillTip = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.qqexpand.utils.ColdPalaceHelper$strSkillUseupTip$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String string = ColdPalaceHelper.this.getApp().getApplication().getResources().getString(R.string.f198464ms);
                Intrinsics.checkNotNullExpressionValue(string, "app.application.resource\u2026ldpalace_skill_useup_tip)");
                return string;
            }
        });
        this.strSkillUseupTip = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.qqexpand.utils.ColdPalaceHelper$strWarnMeInColdPalace$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String string = ColdPalaceHelper.this.getApp().getApplication().getResources().getString(R.string.f198504mw);
                Intrinsics.checkNotNullExpressionValue(string, "app.application.resource\u2026end_coldpalace_warn_mein)");
                return string;
            }
        });
        this.strWarnMeInColdPalace = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.qqexpand.utils.ColdPalaceHelper$strWarnMeForbbiden$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String string = ColdPalaceHelper.this.getApp().getApplication().getResources().getString(R.string.f198494mv);
                Intrinsics.checkNotNullExpressionValue(string, "app.application.resource\u2026oldpalace_warn_forbbiden)");
                return string;
            }
        });
        this.strWarnMeForbbiden = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.qqexpand.utils.ColdPalaceHelper$strWarnMeFreeTime$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String string = ColdPalaceHelper.this.getApp().getApplication().getResources().getString(R.string.f198434mp);
                Intrinsics.checkNotNullExpressionValue(string, "app.application.resource\u2026end_coldpalace_free_time)");
                return string;
            }
        });
        this.strWarnMeFreeTime = lazy5;
        this.svrSkillTimesLeft = Integer.MIN_VALUE;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<SharedPreferences>() { // from class: com.tencent.mobileqq.qqexpand.utils.ColdPalaceHelper$sp$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPreferences invoke() {
                return ea.E(ColdPalaceHelper.this.getApp().getCurrentAccountUin(), "file_extend_cold_palace_");
            }
        });
        this.sp = lazy6;
        String string = d().getString("key_skill_tip", "");
        v(string == null ? "" : string);
        String string2 = d().getString("key_skill_useup_tip", "");
        w(string2 == null ? "" : string2);
        String string3 = d().getString("key_skill_useup_title", "");
        x(string3 == null ? "" : string3);
        String string4 = d().getString("key_warn_me_in_coldpalace", "");
        z(string4 == null ? "" : string4);
        String string5 = d().getString("key_warn_me_forbbiden", "");
        y(string5 != null ? string5 : "");
        this.svrPunishLeftTime = d().getLong("key_punish_left_time", 0L);
        this.svrPunishTimeSince = d().getLong("key_punish_time_since", 0L);
        this.svrShowGrayTipEntry = d().getBoolean("key_show_gray_tip_entry", this.svrShowGrayTipEntry);
        this.svrMeInColdPalaceTimes = d().getInt("key_me_in_cold_palace_times", 0);
    }

    @JvmStatic
    public static final ColdPalaceHelper b(BaseQQAppInterface baseQQAppInterface) {
        return INSTANCE.a(baseQQAppInterface);
    }

    /* renamed from: a, reason: from getter */
    public final QQAppInterface getApp() {
        return this.app;
    }

    /* renamed from: c, reason: from getter */
    public final int getSvrSkillTimesLeft() {
        return this.svrSkillTimesLeft;
    }

    public final SharedPreferences d() {
        Object value = this.sp.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-sp>(...)");
        return (SharedPreferences) value;
    }

    public final String e() {
        return (String) this.strSkillTip.getValue();
    }

    public final String f() {
        return (String) this.strSkillUseupTip.getValue();
    }

    public final String g() {
        return (String) this.strWarnMeForbbiden.getValue();
    }

    public final String h() {
        return (String) this.strWarnMeFreeTime.getValue();
    }

    public final String i() {
        return (String) this.strWarnMeInColdPalace.getValue();
    }

    /* renamed from: j, reason: from getter */
    public final boolean getSvrShowGrayTipEntry() {
        return this.svrShowGrayTipEntry;
    }

    public final String k() {
        String str = this.svrStrSkillTip;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("svrStrSkillTip");
        return null;
    }

    public final String l() {
        String str = this.svrStrSkillUseupTip;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("svrStrSkillUseupTip");
        return null;
    }

    public final String m() {
        String str = this.svrStrSkillUseupTitle;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("svrStrSkillUseupTitle");
        return null;
    }

    public final String n() {
        String str = this.svrStrWarnMeForbbiden;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("svrStrWarnMeForbbiden");
        return null;
    }

    public final String o() {
        String str = this.svrStrWarnMeInColdPalace;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("svrStrWarnMeInColdPalace");
        return null;
    }

    public final String p(int type) {
        if (type == 0) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(e(), Arrays.copyOf(new Object[]{k()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            return format;
        }
        if (type == 1) {
            return m();
        }
        if (type == 2) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format(f(), Arrays.copyOf(new Object[]{l()}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
            return format2;
        }
        if (type == 3) {
            StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
            String format3 = String.format(i(), Arrays.copyOf(new Object[]{o()}, 1));
            Intrinsics.checkNotNullExpressionValue(format3, "format(format, *args)");
            return format3;
        }
        if (type == 4) {
            StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
            String format4 = String.format(g(), Arrays.copyOf(new Object[]{n()}, 1));
            Intrinsics.checkNotNullExpressionValue(format4, "format(format, *args)");
            return format4;
        }
        if (type != 5) {
            return "";
        }
        StringCompanionObject stringCompanionObject5 = StringCompanionObject.INSTANCE;
        String format5 = String.format(h(), Arrays.copyOf(new Object[0], 0));
        Intrinsics.checkNotNullExpressionValue(format5, "format(format, *args)");
        return format5;
    }

    public final void s(boolean show) {
        this.svrShowGrayTipEntry = show;
        d().edit().putBoolean("key_show_gray_tip_entry", this.svrShowGrayTipEntry).apply();
    }

    public final void t(long time, long nowTs) {
        this.svrPunishLeftTime = time;
        this.svrPunishTimeSince = nowTs;
        d().edit().putLong("key_punish_left_time", time);
        d().edit().putLong("key_punish_time_since", nowTs);
        d().edit().apply();
    }

    public final void u(int times) {
        this.svrSkillTimesLeft = times;
    }

    public final void v(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.svrStrSkillTip = str;
    }

    public final void w(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.svrStrSkillUseupTip = str;
    }

    public final void x(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.svrStrSkillUseupTitle = str;
    }

    public final void y(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.svrStrWarnMeForbbiden = str;
    }

    public final void z(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.svrStrWarnMeInColdPalace = str;
    }

    public final void q(int type, String wording) {
        if (wording == null) {
            wording = "";
        }
        if (type == 0) {
            v(wording);
            d().edit().putString("key_skill_tip", wording).apply();
            return;
        }
        if (type == 1) {
            x(wording);
            d().edit().putString("key_skill_useup_title", wording).apply();
            return;
        }
        if (type == 2) {
            w(wording);
            d().edit().putString("key_skill_useup_tip", wording).apply();
        } else if (type == 3) {
            z(wording);
            d().edit().putString("key_warn_me_in_coldpalace", wording).apply();
        } else {
            if (type != 4) {
                return;
            }
            y(wording);
            d().edit().putString("key_warn_me_forbbiden", wording).apply();
        }
    }

    public final void r(int times) {
        if (times > 0 && times != this.svrMeInColdPalaceTimes) {
            this.needWarnMeInColdPalace = true;
        }
        if (times <= 0) {
            this.needWarnMeInColdPalace = false;
        }
        this.svrMeInColdPalaceTimes = times;
        d().edit().putInt("key_me_in_cold_palace_times", times);
    }
}
