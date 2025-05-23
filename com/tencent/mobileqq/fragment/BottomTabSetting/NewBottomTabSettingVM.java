package com.tencent.mobileqq.fragment.BottomTabSetting;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.TabDataHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.eldermode.ElderModeManager;
import com.tencent.mobileqq.guild.api.IGuildConfigApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010$\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 y2\u00020\u0001:\u0002z{B\u0007\u00a2\u0006\u0004\bw\u0010xJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\b\u0010\u000e\u001a\u00020\rH\u0014J\u0016\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0004J\u0016\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0004J\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J&\u0010\u0017\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0018\u00010\u0015j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0018\u0001`\u0016J\u0017\u0010\u0019\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0018\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0006\u0010\u001b\u001a\u00020\u0004J\u0006\u0010\u001c\u001a\u00020\rJ\u001a\u0010\u001f\u001a\u00020\t2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\u001dJ\u0006\u0010 \u001a\u00020\u0004J\u0006\u0010!\u001a\u00020\u0004J\u000e\u0010\"\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0002J\u0006\u0010#\u001a\u00020\u0004R$\u0010+\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001d\u00101\u001a\b\u0012\u0004\u0012\u00020\u00040,8\u0006\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u001d\u00104\u001a\b\u0012\u0004\u0012\u00020\u00040,8\u0006\u00a2\u0006\f\n\u0004\b2\u0010.\u001a\u0004\b3\u00100R\u001d\u00107\u001a\b\u0012\u0004\u0012\u00020\u00040,8\u0006\u00a2\u0006\f\n\u0004\b5\u0010.\u001a\u0004\b6\u00100R\u001d\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00040,8\u0006\u00a2\u0006\f\n\u0004\b8\u0010.\u001a\u0004\b9\u00100R\u001d\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00040,8\u0006\u00a2\u0006\f\n\u0004\b;\u0010.\u001a\u0004\b<\u00100R\u001d\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00040,8\u0006\u00a2\u0006\f\n\u0004\b>\u0010.\u001a\u0004\b?\u00100R0\u0010H\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0018\u00010A8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR$\u0010O\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NRB\u0010V\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0018\u00010\u0015j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0018\u0001`\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u001a\u0010Z\u001a\u00020\t8\u0006X\u0086D\u00a2\u0006\f\n\u0004\bW\u0010I\u001a\u0004\bX\u0010YR\"\u0010_\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b[\u0010I\u001a\u0004\b\\\u0010Y\"\u0004\b]\u0010^R\"\u0010c\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b`\u0010I\u001a\u0004\ba\u0010Y\"\u0004\bb\u0010^R\"\u0010g\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bd\u0010I\u001a\u0004\be\u0010Y\"\u0004\bf\u0010^R\"\u0010k\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bh\u0010I\u001a\u0004\bi\u0010Y\"\u0004\bj\u0010^R3\u0010n\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00020\u0015j\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0002`\u00168\u0006\u00a2\u0006\f\n\u0004\bl\u0010Q\u001a\u0004\bm\u0010SR$\u0010v\u001a\u0004\u0018\u00010o8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bp\u0010q\u001a\u0004\br\u0010s\"\u0004\bt\u0010u\u00a8\u0006|"}, d2 = {"Lcom/tencent/mobileqq/fragment/BottomTabSetting/NewBottomTabSettingVM;", "Landroidx/lifecycle/ViewModel;", "", "switchItem", "", "i2", "Lcom/tencent/mobileqq/fragment/BottomTabSetting/NewBottomTabSettingVM$SettingItemType;", "type", "m2", "", "d2", "Lcom/tencent/mobileqq/app/QQAppInterface;", "L1", "", "onCleared", "newValue", "p2", "o2", "Q1", "O1", "P1", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "z2", "switchItemName", "j2", "(Ljava/lang/String;)Ljava/lang/Boolean;", SemanticAttributes.DbSystemValues.H2, "g2", "Lkotlin/Function1;", "selectedReport", "T1", "k2", "l2", "M1", ICustomDataEditor.NUMBER_PARAM_2, "Landroid/content/Context;", "i", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "r2", "(Landroid/content/Context;)V", "context", "Landroidx/lifecycle/MutableLiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "W1", "()Landroidx/lifecycle/MutableLiveData;", "guildRightSwitchLiveData", BdhLogUtil.LogTag.Tag_Conn, "S1", "circleRightSwitchLiveData", "D", "c2", "metaDreamRightSwitchLiveData", "E", "U1", "guildEnableLiveData", UserInfo.SEX_FEMALE, "R1", "circleEnableLiveData", "G", "b2", "metaDreamEnableLiveData", "", "H", "Ljava/util/Map;", "f2", "()Ljava/util/Map;", "y2", "(Ljava/util/Map;)V", "tabSwitchMap", "I", "Ljava/lang/String;", "N1", "()Ljava/lang/String;", "q2", "(Ljava/lang/String;)V", "allTabListCacheString", "J", "Ljava/util/HashMap;", "e2", "()Ljava/util/HashMap;", "x2", "(Ljava/util/HashMap;)V", "tabResultMap", "K", "getMTabNone", "()I", "mTabNone", "L", ICustomDataEditor.STRING_ARRAY_PARAM_2, "v2", "(I)V", "mTabKandian", "M", "getMTabQcircle", "w2", "mTabQcircle", "N", "getMInitPosition", ICustomDataEditor.STRING_PARAM_2, "mInitPosition", "P", "Z1", "u2", "mSelectedPosition", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "getMTabHashMap", "mTabHashMap", "Lcom/tencent/mobileqq/fragment/bottomtab/b;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/fragment/bottomtab/b;", "X1", "()Lcom/tencent/mobileqq/fragment/bottomtab/b;", "t2", "(Lcom/tencent/mobileqq/fragment/bottomtab/b;)V", "mPreviewHelper", "<init>", "()V", ExifInterface.LATITUDE_SOUTH, "a", "SettingItemType", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class NewBottomTabSettingVM extends ViewModel {

    /* renamed from: H, reason: from kotlin metadata */
    private Map<String, Integer> tabSwitchMap;

    /* renamed from: I, reason: from kotlin metadata */
    private String allTabListCacheString;

    /* renamed from: J, reason: from kotlin metadata */
    private HashMap<String, Integer> tabResultMap;

    /* renamed from: K, reason: from kotlin metadata */
    private final int mTabNone;

    /* renamed from: N, reason: from kotlin metadata */
    private int mInitPosition;

    /* renamed from: P, reason: from kotlin metadata */
    private int mSelectedPosition;

    /* renamed from: R, reason: from kotlin metadata */
    private com.tencent.mobileqq.fragment.bottomtab.b mPreviewHelper;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private Context context;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<Boolean> guildRightSwitchLiveData = new MutableLiveData<>();

    /* renamed from: C, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> circleRightSwitchLiveData = new MutableLiveData<>();

    /* renamed from: D, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> metaDreamRightSwitchLiveData = new MutableLiveData<>();

    /* renamed from: E, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> guildEnableLiveData = new MutableLiveData<>();

    /* renamed from: F, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> circleEnableLiveData = new MutableLiveData<>();

    /* renamed from: G, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> metaDreamEnableLiveData = new MutableLiveData<>();

    /* renamed from: L, reason: from kotlin metadata */
    private int mTabKandian = 1;

    /* renamed from: M, reason: from kotlin metadata */
    private int mTabQcircle = 2;

    /* renamed from: Q, reason: from kotlin metadata */
    private final HashMap<Integer, String> mTabHashMap = new HashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/fragment/BottomTabSetting/NewBottomTabSettingVM$SettingItemType;", "", "(Ljava/lang/String;I)V", "getTabKey", "", "getTabName", "Guild", "Circle", "MetaDream", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public enum SettingItemType {
        Guild,
        Circle,
        MetaDream;

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes33.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f211114a;

            static {
                int[] iArr = new int[SettingItemType.values().length];
                try {
                    iArr[SettingItemType.Guild.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[SettingItemType.Circle.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[SettingItemType.MetaDream.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f211114a = iArr;
            }
        }

        public final String getTabKey() {
            int i3 = a.f211114a[ordinal()];
            if (i3 == 1) {
                return "GUILD";
            }
            if (i3 == 2) {
                return TabDataHelper.TAB_NEW_WORLD;
            }
            if (i3 != 3) {
                return "";
            }
            return TabDataHelper.TAB_META_DREAM;
        }

        public final String getTabName() {
            int i3 = a.f211114a[ordinal()];
            if (i3 == 1) {
                String guildTabName = ((IGuildConfigApi) QRoute.api(IGuildConfigApi.class)).getGuildTabName();
                Intrinsics.checkNotNullExpressionValue(guildTabName, "api(IGuildConfigApi::class.java).getGuildTabName()");
                return guildTabName;
            }
            if (i3 == 2) {
                String O3 = uq3.c.O3();
                Intrinsics.checkNotNullExpressionValue(O3, "getQQCircleProductName()");
                return O3;
            }
            if (i3 != 3) {
                return "";
            }
            String qqStr = HardCodeUtil.qqStr(R.string.f197844l4);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.qq_bottom_tab_setting_meta_dream)");
            return qqStr;
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f211115a;

        static {
            int[] iArr = new int[SettingItemType.values().length];
            try {
                iArr[SettingItemType.Guild.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SettingItemType.Circle.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SettingItemType.MetaDream.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f211115a = iArr;
        }
    }

    private final int d2() {
        HashMap<String, Integer> hashMap = this.tabResultMap;
        int i3 = 0;
        if (hashMap == null) {
            return 0;
        }
        Intrinsics.checkNotNull(hashMap);
        for (Integer num : hashMap.values()) {
            if (num != null && num.intValue() == 2) {
                i3++;
            }
        }
        return i3;
    }

    private final boolean i2(String switchItem) {
        HashMap<String, Integer> hashMap = this.tabResultMap;
        Integer num = hashMap != null ? hashMap.get(switchItem) : null;
        return num != null && num.intValue() == 2;
    }

    private final boolean m2(SettingItemType type) {
        Context context;
        String tabKey = type.getTabKey();
        QQAppInterface L1 = L1();
        if (L1 == null || (context = this.context) == null) {
            return true;
        }
        return TabDataHelper.isTabShield(context, L1.getCurrentUin(), tabKey);
    }

    public final QQAppInterface L1() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
        if (peekAppRuntime instanceof QQAppInterface) {
            return (QQAppInterface) peekAppRuntime;
        }
        return null;
    }

    public final boolean M1(String switchItemName) {
        Map<String, Integer> map;
        Integer num;
        int i3;
        Intrinsics.checkNotNullParameter(switchItemName, "switchItemName");
        if ((!((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch() && !ElderModeManager.j()) || (map = this.tabSwitchMap) == null || (num = map.get(switchItemName)) == null) {
            return false;
        }
        num.intValue();
        Map<String, Integer> map2 = this.tabSwitchMap;
        if (map2 != null) {
            i3 = 0;
            for (Map.Entry<String, Integer> entry : map2.entrySet()) {
                String key = entry.getKey();
                int intValue = entry.getValue().intValue();
                if (!Intrinsics.areEqual(switchItemName, key) && intValue == 2) {
                    i3++;
                }
            }
        } else {
            i3 = 0;
        }
        return i3 >= 2;
    }

    /* renamed from: N1, reason: from getter */
    public final String getAllTabListCacheString() {
        return this.allTabListCacheString;
    }

    public final String O1(SettingItemType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        int i3 = b.f211115a[type.ordinal()];
        if (i3 == 1) {
            return type.getTabName();
        }
        if (i3 == 2) {
            return type.getTabName();
        }
        if (i3 != 3) {
            return "";
        }
        return type.getTabName();
    }

    public final boolean P1(SettingItemType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        Boolean j26 = j2(type.getTabKey());
        if (j26 != null) {
            return j26.booleanValue();
        }
        return false;
    }

    public final boolean Q1(SettingItemType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        int i3 = b.f211115a[type.ordinal()];
        if (i3 == 1) {
            boolean m26 = m2(type);
            Boolean j26 = j2(type.getTabKey());
            if (!m26 && j26 != null) {
                return true;
            }
        } else if (i3 == 2) {
            boolean h26 = h2();
            boolean m27 = m2(type);
            Boolean j27 = j2(type.getTabKey());
            if (h26 && !m27 && j27 != null) {
                return true;
            }
        } else if (i3 == 3) {
            boolean h27 = h2();
            boolean m28 = m2(type);
            Boolean j28 = j2(type.getTabKey());
            int modelType = TabDataHelper.getModelType();
            boolean z16 = modelType == 3 || modelType == 4;
            if (h27 && !m28 && j28 != null && !z16) {
                return true;
            }
        }
        return false;
    }

    public final MutableLiveData<Boolean> R1() {
        return this.circleEnableLiveData;
    }

    public final MutableLiveData<Boolean> S1() {
        return this.circleRightSwitchLiveData;
    }

    public final int T1(Function1<? super String, Unit> selectedReport) {
        Intrinsics.checkNotNullParameter(selectedReport, "selectedReport");
        String str = TabDataHelper.TAB_NEW_WORLD;
        boolean i26 = i2(TabDataHelper.TAB_NEW_WORLD);
        boolean i27 = i2(TabDataHelper.TAB_RIJ);
        int i3 = this.mTabNone;
        if (i26) {
            i3 = this.mTabQcircle;
        } else if (i27) {
            i3 = this.mTabKandian;
            str = TabDataHelper.TAB_RIJ;
        } else {
            str = "none";
        }
        selectedReport.invoke(str);
        return i3;
    }

    public final MutableLiveData<Boolean> U1() {
        return this.guildEnableLiveData;
    }

    public final MutableLiveData<Boolean> W1() {
        return this.guildRightSwitchLiveData;
    }

    /* renamed from: X1, reason: from getter */
    public final com.tencent.mobileqq.fragment.bottomtab.b getMPreviewHelper() {
        return this.mPreviewHelper;
    }

    /* renamed from: Z1, reason: from getter */
    public final int getMSelectedPosition() {
        return this.mSelectedPosition;
    }

    /* renamed from: a2, reason: from getter */
    public final int getMTabKandian() {
        return this.mTabKandian;
    }

    public final MutableLiveData<Boolean> b2() {
        return this.metaDreamEnableLiveData;
    }

    public final MutableLiveData<Boolean> c2() {
        return this.metaDreamRightSwitchLiveData;
    }

    public final HashMap<String, Integer> e2() {
        return this.tabResultMap;
    }

    public final Map<String, Integer> f2() {
        return this.tabSwitchMap;
    }

    public final void g2() {
        if (j2(TabDataHelper.TAB_RIJ) != null || j2(TabDataHelper.TAB_NEW_WORLD) != null) {
            HashMap<Integer, String> hashMap = this.mTabHashMap;
            Integer valueOf = Integer.valueOf(this.mTabNone);
            String qqStr = HardCodeUtil.qqStr(R.string.zfw);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.bottom_none_tab_title)");
            hashMap.put(valueOf, qqStr);
        }
        if (j2(TabDataHelper.TAB_RIJ) != null) {
            HashMap<Integer, String> hashMap2 = this.mTabHashMap;
            Integer valueOf2 = Integer.valueOf(this.mTabKandian);
            String qqStr2 = HardCodeUtil.qqStr(R.string.c08);
            Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(R.string.kandian_switch)");
            hashMap2.put(valueOf2, qqStr2);
        }
        if (j2(TabDataHelper.TAB_NEW_WORLD) != null) {
            HashMap<Integer, String> hashMap3 = this.mTabHashMap;
            Integer valueOf3 = Integer.valueOf(this.mTabQcircle);
            String O3 = uq3.c.O3();
            Intrinsics.checkNotNullExpressionValue(O3, "getQQCircleProductName()");
            hashMap3.put(valueOf3, O3);
        }
    }

    public final boolean h2() {
        return this.tabResultMap != null;
    }

    public final Boolean j2(String switchItemName) {
        Intrinsics.checkNotNullParameter(switchItemName, "switchItemName");
        HashMap<String, Integer> hashMap = this.tabResultMap;
        if (hashMap == null) {
            if (QLog.isColorLevel()) {
                QLog.d("NewBottomTabSettingVM", 2, "isSwitchHide return null, tabResultMap isEmpty");
            }
            return null;
        }
        Intrinsics.checkNotNull(hashMap);
        Integer num = hashMap.get(switchItemName);
        if (num != null && (num.intValue() == 3 || num.intValue() == 2)) {
            if (QLog.isColorLevel()) {
                QLog.d("NewBottomTabSettingVM", 2, "isSwitchHide: [value : " + num + "]");
            }
            return Boolean.valueOf(num.intValue() == 2);
        }
        if (QLog.isColorLevel()) {
            QLog.d("NewBottomTabSettingVM", 2, "isSwitchHide return null, value is invalid: [value : " + num + "]");
        }
        return null;
    }

    public final boolean k2() {
        return d2() + TabDataHelper.TAB_ARRAY_CONSTANT.length >= 5;
    }

    public final boolean l2() {
        return d2() + TabDataHelper.TAB_ARRAY_CONSTANT.length > 5;
    }

    public final boolean n2() {
        int i3 = this.mInitPosition;
        int i16 = this.mTabKandian;
        return (i3 == i16 && this.mSelectedPosition != i16) || (i3 != i16 && this.mSelectedPosition == i16);
    }

    public final void o2(SettingItemType type, boolean newValue) {
        Intrinsics.checkNotNullParameter(type, "type");
        int i3 = b.f211115a[type.ordinal()];
        if (i3 == 1) {
            this.guildEnableLiveData.postValue(Boolean.valueOf(newValue));
        } else if (i3 == 2) {
            this.circleEnableLiveData.postValue(Boolean.valueOf(newValue));
        } else {
            if (i3 != 3) {
                return;
            }
            this.metaDreamEnableLiveData.postValue(Boolean.valueOf(newValue));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
    }

    public final void p2(SettingItemType type, boolean newValue) {
        Intrinsics.checkNotNullParameter(type, "type");
        int i3 = b.f211115a[type.ordinal()];
        if (i3 == 1) {
            this.guildRightSwitchLiveData.postValue(Boolean.valueOf(newValue));
        } else if (i3 == 2) {
            this.circleRightSwitchLiveData.postValue(Boolean.valueOf(newValue));
        } else {
            if (i3 != 3) {
                return;
            }
            this.metaDreamRightSwitchLiveData.postValue(Boolean.valueOf(newValue));
        }
    }

    public final void q2(String str) {
        this.allTabListCacheString = str;
    }

    public final void r2(Context context) {
        this.context = context;
    }

    public final void s2(int i3) {
        this.mInitPosition = i3;
    }

    public final void t2(com.tencent.mobileqq.fragment.bottomtab.b bVar) {
        this.mPreviewHelper = bVar;
    }

    public final void u2(int i3) {
        this.mSelectedPosition = i3;
    }

    public final void v2(int i3) {
        this.mTabKandian = i3;
    }

    public final void w2(int i3) {
        this.mTabQcircle = i3;
    }

    public final void x2(HashMap<String, Integer> hashMap) {
        this.tabResultMap = hashMap;
    }

    public final void y2(Map<String, Integer> map) {
        this.tabSwitchMap = map;
    }

    public final HashMap<String, Integer> z2() {
        boolean contains$default;
        if (this.tabSwitchMap == null) {
            if (QLog.isColorLevel()) {
                QLog.d("NewBottomTabSettingVM", 2, "tabInfo return null, tabSwitchMap == null");
            }
            return null;
        }
        if (this.allTabListCacheString == null) {
            if (QLog.isColorLevel()) {
                QLog.d("NewBottomTabSettingVM", 2, "tabInfo return null, allTabListCacheString == null: ");
            }
            return null;
        }
        HashMap<String, Integer> hashMap = new HashMap<>();
        Map<String, Integer> map = this.tabSwitchMap;
        Intrinsics.checkNotNull(map);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int intValue = entry.getValue().intValue();
            String str = this.allTabListCacheString;
            Intrinsics.checkNotNull(str);
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) key, false, 2, (Object) null);
            if (contains$default && (intValue == 2 || intValue == 3)) {
                hashMap.put(key, Integer.valueOf(intValue));
            }
        }
        return hashMap;
    }
}
