package com.tencent.mobileqq.zplan.fragment;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQSettingMeABTestHelper;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mobileqq.zplan.aio.a;
import com.tencent.mobileqq.zplan.lite.IZPlanFilamentSwitch;
import com.tencent.mobileqq.zplan.setting.SwitchSetting;
import com.tencent.mobileqq.zplan.utils.api.IZPlanAccessibleHelper;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.shadow.dynamic.host.Constant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\"\u0018\u0000 G2\u00020\u0001:\u0002HIB\u0007\u00a2\u0006\u0004\bE\u0010FJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004R\"\u0010\u0016\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u001e\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010%\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R0\u0010/\u001a\u0010\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020(\u0018\u00010&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R0\u00103\u001a\u0010\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020(\u0018\u00010&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010*\u001a\u0004\b1\u0010,\"\u0004\b2\u0010.R\u001d\u00108\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006\u00a2\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u001d\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006\u00a2\u0006\f\n\u0004\b9\u00105\u001a\u0004\b:\u00107R\u001d\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006\u00a2\u0006\f\n\u0004\b<\u00105\u001a\u0004\b=\u00107R\u001d\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006\u00a2\u0006\f\n\u0004\b?\u00105\u001a\u0004\b@\u00107R\u001d\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006\u00a2\u0006\f\n\u0004\bB\u00105\u001a\u0004\bC\u00107\u00a8\u0006J"}, d2 = {"Lcom/tencent/mobileqq/zplan/fragment/NewZplanSettingAvatarShowVM;", "Landroidx/lifecycle/ViewModel;", "Lcom/tencent/mobileqq/app/QQAppInterface;", "M1", "Lcom/tencent/mobileqq/zplan/fragment/NewZplanSettingAvatarShowVM$SettingItemType;", "type", "Landroidx/lifecycle/MutableLiveData;", "", "S1", "newValue", "", "i2", "Q1", "", "O1", "P1", "i", "Ljava/lang/String;", "T1", "()Ljava/lang/String;", "d2", "(Ljava/lang/String;)V", "mPageCode", "Lcom/tencent/mobileqq/widget/listitem/Group;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/widget/listitem/Group;", "X1", "()Lcom/tencent/mobileqq/widget/listitem/Group;", "f2", "(Lcom/tencent/mobileqq/widget/listitem/Group;)V", "otherSwitchGroup", BdhLogUtil.LogTag.Tag_Conn, "Z", "Z1", "()Z", "g2", "(Z)V", "otherSwitchGroupIsVisible", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$f;", "D", "Lcom/tencent/mobileqq/widget/listitem/x;", "W1", "()Lcom/tencent/mobileqq/widget/listitem/x;", "e2", "(Lcom/tencent/mobileqq/widget/listitem/x;)V", "masterSwitchConfig", "E", "c2", SemanticAttributes.DbSystemValues.H2, "qzoneSwitchConfig", UserInfo.SEX_FEMALE, "Landroidx/lifecycle/MutableLiveData;", "U1", "()Landroidx/lifecycle/MutableLiveData;", "masterRightSwitchLiveData", "G", ICustomDataEditor.STRING_ARRAY_PARAM_2, "profileCardRightSwitchLiveData", "H", "b2", "qzoneRightSwitchLiveData", "I", "N1", "aioAvatarRightSwitchLiveData", "J", "R1", "drawerRightSwitchLiveData", "<init>", "()V", "K", "a", "SettingItemType", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class NewZplanSettingAvatarShowVM extends ViewModel {
    private static final a K = new a(null);

    /* renamed from: C, reason: from kotlin metadata */
    private boolean otherSwitchGroupIsVisible;

    /* renamed from: D, reason: from kotlin metadata */
    private com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> masterSwitchConfig;

    /* renamed from: E, reason: from kotlin metadata */
    private com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> qzoneSwitchConfig;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private Group otherSwitchGroup;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String mPageCode = "";

    /* renamed from: F, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> masterRightSwitchLiveData = new MutableLiveData<>();

    /* renamed from: G, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> profileCardRightSwitchLiveData = new MutableLiveData<>();

    /* renamed from: H, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> qzoneRightSwitchLiveData = new MutableLiveData<>();

    /* renamed from: I, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> aioAvatarRightSwitchLiveData = new MutableLiveData<>();

    /* renamed from: J, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> drawerRightSwitchLiveData = new MutableLiveData<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/zplan/fragment/NewZplanSettingAvatarShowVM$SettingItemType;", "", "(Ljava/lang/String;I)V", "MasterSwitch", "ProfileCardSwitch", "QzoneSwitch", "AioAvatarSwitch", "DrawerSwitch", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public enum SettingItemType {
        MasterSwitch,
        ProfileCardSwitch,
        QzoneSwitch,
        AioAvatarSwitch,
        DrawerSwitch
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/zplan/fragment/NewZplanSettingAvatarShowVM$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f333457a;

        static {
            int[] iArr = new int[SettingItemType.values().length];
            try {
                iArr[SettingItemType.MasterSwitch.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SettingItemType.ProfileCardSwitch.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SettingItemType.QzoneSwitch.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SettingItemType.AioAvatarSwitch.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[SettingItemType.DrawerSwitch.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f333457a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j2(NewZplanSettingAvatarShowVM this$0, SettingItemType type, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(type, "$type");
        MutableLiveData<Boolean> S1 = this$0.S1(type);
        if (S1 != null) {
            S1.postValue(Boolean.valueOf(z16));
        }
    }

    public final QQAppInterface M1() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
        if (peekAppRuntime instanceof QQAppInterface) {
            return (QQAppInterface) peekAppRuntime;
        }
        return null;
    }

    public final MutableLiveData<Boolean> N1() {
        return this.aioAvatarRightSwitchLiveData;
    }

    public final String O1(SettingItemType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        int i3 = b.f333457a[type.ordinal()];
        if (i3 == 1) {
            String qqStr = HardCodeUtil.qqStr(R.string.xup);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.zplan_setting_total)");
            return qqStr;
        }
        if (i3 == 2) {
            String qqStr2 = HardCodeUtil.qqStr(R.string.xty);
            Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(R.string.zplan_setting_profile_card)");
            return qqStr2;
        }
        if (i3 == 3) {
            String zplanSettingQzoneSwitchName = ((IZPlanFeatureSwitchHelper) QRoute.api(IZPlanFeatureSwitchHelper.class)).getZplanSettingQzoneSwitchName();
            if (zplanSettingQzoneSwitchName.length() > 0) {
                return zplanSettingQzoneSwitchName;
            }
            String qqStr3 = HardCodeUtil.qqStr(R.string.xuf);
            Intrinsics.checkNotNullExpressionValue(qqStr3, "qqStr(R.string.zplan_setting_qzone)");
            return qqStr3;
        }
        if (i3 == 4) {
            String qqStr4 = HardCodeUtil.qqStr(R.string.xtf);
            Intrinsics.checkNotNullExpressionValue(qqStr4, "qqStr(R.string.zplan_setting_aio_avatar)");
            return qqStr4;
        }
        if (i3 != 5) {
            return "";
        }
        String qqStr5 = HardCodeUtil.qqStr(R.string.xtl);
        Intrinsics.checkNotNullExpressionValue(qqStr5, "qqStr(R.string.zplan_setting_drawer)");
        return qqStr5;
    }

    public final boolean P1(SettingItemType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        int i3 = b.f333457a[type.ordinal()];
        if (i3 == 1) {
            return com.tencent.mobileqq.zplan.setting.c.e();
        }
        if (i3 == 2) {
            return com.tencent.mobileqq.zplan.setting.c.h(SwitchSetting.PROFILE_CARD_SETTING);
        }
        if (i3 == 3) {
            return com.tencent.mobileqq.zplan.setting.c.h(SwitchSetting.DYNAMIC_SETTING);
        }
        if (i3 == 4) {
            return a.c.d();
        }
        if (i3 != 5) {
            return false;
        }
        return com.tencent.mobileqq.zplan.setting.c.b();
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0042, code lost:
    
        if (com.tencent.mobileqq.utils.QQSettingMeABTestHelper.c() != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0098, code lost:
    
        if (r2 != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00c7, code lost:
    
        if (r0 != false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean Q1(SettingItemType type) {
        Long valueOf;
        Intrinsics.checkNotNullParameter(type, "type");
        boolean z16 = true;
        if (type == SettingItemType.MasterSwitch) {
            return true;
        }
        int i3 = b.f333457a[type.ordinal()];
        if (i3 == 2) {
            QQAppInterface M1 = M1();
            valueOf = M1 != null ? Long.valueOf(M1.getLongAccountUin()) : null;
            if (valueOf == null) {
                return false;
            }
            boolean isZplanAccessibleWithoutSetting = ((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).isZplanAccessibleWithoutSetting(1004L, valueOf.longValue());
            boolean enableZPlanNativeAppFilament = ((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).enableZPlanNativeAppFilament(2);
            if (isZplanAccessibleWithoutSetting) {
            }
            z16 = false;
        } else if (i3 == 3) {
            QQAppInterface M12 = M1();
            valueOf = M12 != null ? Long.valueOf(M12.getLongAccountUin()) : null;
            if (valueOf == null) {
                return false;
            }
            boolean isZplanAccessibleWithoutSetting2 = ((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).isZplanAccessibleWithoutSetting(Constant.FROM_ID_UNINSTALL_PLUGIN, valueOf.longValue());
            boolean f16 = QQSettingMeABTestHelper.e().f();
            boolean enableZPlanNativeAppFilament2 = ((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).enableZPlanNativeAppFilament(0);
            if (isZplanAccessibleWithoutSetting2) {
                if (!f16) {
                }
            }
            z16 = false;
        } else {
            if (i3 == 4) {
                QQAppInterface M13 = M1();
                valueOf = M13 != null ? Long.valueOf(M13.getLongAccountUin()) : null;
                if (valueOf != null) {
                    return a.c.c(valueOf.longValue());
                }
                return false;
            }
            if (i3 != 5) {
                return false;
            }
            boolean enableZPlanFilamentBase = ((IZPlanFilamentSwitch) QRoute.api(IZPlanFilamentSwitch.class)).enableZPlanFilamentBase(null);
            boolean h16 = QQSettingMeABTestHelper.e().h();
            if (enableZPlanFilamentBase) {
                if (h16) {
                }
            }
            z16 = false;
        }
        return z16;
    }

    public final MutableLiveData<Boolean> R1() {
        return this.drawerRightSwitchLiveData;
    }

    public final MutableLiveData<Boolean> S1(SettingItemType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        int i3 = b.f333457a[type.ordinal()];
        if (i3 == 1) {
            return this.masterRightSwitchLiveData;
        }
        if (i3 == 2) {
            return this.profileCardRightSwitchLiveData;
        }
        if (i3 == 3) {
            return this.qzoneRightSwitchLiveData;
        }
        if (i3 == 4) {
            return this.aioAvatarRightSwitchLiveData;
        }
        if (i3 != 5) {
            return null;
        }
        return this.drawerRightSwitchLiveData;
    }

    /* renamed from: T1, reason: from getter */
    public final String getMPageCode() {
        return this.mPageCode;
    }

    public final MutableLiveData<Boolean> U1() {
        return this.masterRightSwitchLiveData;
    }

    public final com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> W1() {
        return this.masterSwitchConfig;
    }

    /* renamed from: X1, reason: from getter */
    public final Group getOtherSwitchGroup() {
        return this.otherSwitchGroup;
    }

    /* renamed from: Z1, reason: from getter */
    public final boolean getOtherSwitchGroupIsVisible() {
        return this.otherSwitchGroupIsVisible;
    }

    public final MutableLiveData<Boolean> a2() {
        return this.profileCardRightSwitchLiveData;
    }

    public final MutableLiveData<Boolean> b2() {
        return this.qzoneRightSwitchLiveData;
    }

    public final com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> c2() {
        return this.qzoneSwitchConfig;
    }

    public final void d2(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mPageCode = str;
    }

    public final void e2(com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> xVar) {
        this.masterSwitchConfig = xVar;
    }

    public final void f2(Group group) {
        this.otherSwitchGroup = group;
    }

    public final void g2(boolean z16) {
        this.otherSwitchGroupIsVisible = z16;
    }

    public final void h2(com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> xVar) {
        this.qzoneSwitchConfig = xVar;
    }

    public final void i2(final SettingItemType type, final boolean newValue) {
        Intrinsics.checkNotNullParameter(type, "type");
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.fragment.x
            @Override // java.lang.Runnable
            public final void run() {
                NewZplanSettingAvatarShowVM.j2(NewZplanSettingAvatarShowVM.this, type, newValue);
            }
        });
    }
}
