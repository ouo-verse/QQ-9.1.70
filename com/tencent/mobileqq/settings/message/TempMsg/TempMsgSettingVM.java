package com.tencent.mobileqq.settings.message.TempMsg;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxManager;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxService;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.managers.TempMsgManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import mqq.manager.Manager;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001d\u0018\u0000 D2\u00020\u00012\u00020\u0002:\u0002EFB\u0007\u00a2\u0006\u0004\bB\u0010CJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\b\u0010\t\u001a\u0004\u0018\u00010\bJ\b\u0010\n\u001a\u00020\u0003H\u0014J\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u0012\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\u0013J(\u0010\u0018\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\rH\u0016R3\u0010\u001f\u001a\u001e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000f0\u0019j\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000f`\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR3\u0010#\u001a\u001e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u000f0\u0019j\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u000f`\u001a8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010\u001eR#\u0010)\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u000b0$8\u0006\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001d\u0010/\u001a\b\u0012\u0004\u0012\u00020\r0*8\u0006\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u001d\u00102\u001a\b\u0012\u0004\u0012\u00020\u000f0*8\u0006\u00a2\u0006\f\n\u0004\b0\u0010,\u001a\u0004\b1\u0010.R\u001d\u00105\u001a\b\u0012\u0004\u0012\u00020\r0*8\u0006\u00a2\u0006\f\n\u0004\b3\u0010,\u001a\u0004\b4\u0010.R\u001d\u00108\u001a\b\u0012\u0004\u0012\u00020\u000f0*8\u0006\u00a2\u0006\f\n\u0004\b6\u0010,\u001a\u0004\b7\u0010.R\u001d\u0010;\u001a\b\u0012\u0004\u0012\u00020\r0*8\u0006\u00a2\u0006\f\n\u0004\b9\u0010,\u001a\u0004\b:\u0010.R\u001d\u0010>\u001a\b\u0012\u0004\u0012\u00020\u000f0*8\u0006\u00a2\u0006\f\n\u0004\b<\u0010,\u001a\u0004\b=\u0010.R\u001d\u0010A\u001a\b\u0012\u0004\u0012\u00020\u000f0*8\u0006\u00a2\u0006\f\n\u0004\b?\u0010,\u001a\u0004\b@\u0010.\u00a8\u0006G"}, d2 = {"Lcom/tencent/mobileqq/settings/message/TempMsg/TempMsgSettingVM;", "Landroidx/lifecycle/ViewModel;", "Lcom/tencent/mobileqq/managers/TempMsgManager$d;", "", "c2", "d2", "Lcom/tencent/mobileqq/app/QQAppInterface;", "L1", "Lcom/tencent/mobileqq/managers/TempMsgManager;", "e2", "onCleared", "Lcom/tencent/mobileqq/settings/message/TempMsg/TempMsgSettingVM$SettingItemType;", "type", "", "P1", "", "M1", "O1", "N1", "", ICustomDataEditor.STRING_ARRAY_PARAM_2, "syncResult", "nowStatus", "nowInBoxStatus", "k1", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "i", "Ljava/util/HashMap;", "getMTagCache", "()Ljava/util/HashMap;", "mTagCache", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "S1", "mResultCache", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/Map;", "T1", "()Ljava/util/Map;", "mViewCache", "Landroidx/lifecycle/MutableLiveData;", "D", "Landroidx/lifecycle/MutableLiveData;", "b2", "()Landroidx/lifecycle/MutableLiveData;", "troopRightSwitchLiveData", "E", "Z1", "newTroopRightTextLiveData", UserInfo.SEX_FEMALE, "R1", "contactRightSwitchLiveData", "G", "X1", "newContactRightTextLiveData", "H", "Q1", "consultRightSwitchLiveData", "I", "W1", "newConsultRightTextLiveData", "J", "U1", "newCompanyQQRightTextLiveData", "<init>", "()V", "K", "a", "SettingItemType", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class TempMsgSettingVM extends ViewModel implements TempMsgManager.d {
    private static final a K = new a(null);

    /* renamed from: C, reason: from kotlin metadata */
    private final Map<Integer, SettingItemType> mViewCache;

    /* renamed from: D, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> troopRightSwitchLiveData;

    /* renamed from: E, reason: from kotlin metadata */
    private final MutableLiveData<String> newTroopRightTextLiveData;

    /* renamed from: F, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> contactRightSwitchLiveData;

    /* renamed from: G, reason: from kotlin metadata */
    private final MutableLiveData<String> newContactRightTextLiveData;

    /* renamed from: H, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> consultRightSwitchLiveData;

    /* renamed from: I, reason: from kotlin metadata */
    private final MutableLiveData<String> newConsultRightTextLiveData;

    /* renamed from: J, reason: from kotlin metadata */
    private final MutableLiveData<String> newCompanyQQRightTextLiveData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final HashMap<Short, String> mTagCache = new HashMap<>();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final HashMap<Integer, String> mResultCache = new HashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\r\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0002\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/settings/message/TempMsg/TempMsgSettingVM$SettingItemType;", "", "(Ljava/lang/String;I)V", "fieldTempConversationBlockType", "", "()Ljava/lang/Short;", "tempMsgSettingString", "", "Troop", "Contact", "Consult", "NewTroop", "NewContact", "NewConsult", "NewCompanyQQ", "NewGameCenter", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public enum SettingItemType {
        Troop,
        Contact,
        Consult,
        NewTroop,
        NewContact,
        NewConsult,
        NewCompanyQQ,
        NewGameCenter;

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes35.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f287004a;

            static {
                int[] iArr = new int[SettingItemType.values().length];
                try {
                    iArr[SettingItemType.Troop.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[SettingItemType.Contact.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[SettingItemType.Consult.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[SettingItemType.NewTroop.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[SettingItemType.NewContact.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[SettingItemType.NewConsult.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[SettingItemType.NewCompanyQQ.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                f287004a = iArr;
            }
        }

        public final Short fieldTempConversationBlockType() {
            switch (a.f287004a[ordinal()]) {
                case 1:
                case 4:
                    return (short) -23308;
                case 2:
                case 5:
                    return (short) -23310;
                case 3:
                case 6:
                    return (short) -23309;
                case 7:
                    return (short) -20457;
                default:
                    return null;
            }
        }

        public final String tempMsgSettingString() {
            switch (a.f287004a[ordinal()]) {
                case 1:
                case 4:
                    return AppConstants.Preferences.TEMP_MSG_SETTING_TROOP;
                case 2:
                case 5:
                    return AppConstants.Preferences.TEMP_MSG_SETTING_CONTACT;
                case 3:
                case 6:
                    return AppConstants.Preferences.TEMP_MSG_SETTING_CONSULT;
                case 7:
                    return AppConstants.Preferences.TEMP_MSG_SETTING_COMPANY;
                default:
                    return "";
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/settings/message/TempMsg/TempMsgSettingVM$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f287005a;

        static {
            int[] iArr = new int[SettingItemType.values().length];
            try {
                iArr[SettingItemType.Troop.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SettingItemType.Contact.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SettingItemType.Consult.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SettingItemType.NewTroop.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[SettingItemType.NewContact.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[SettingItemType.NewConsult.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[SettingItemType.NewCompanyQQ.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[SettingItemType.NewGameCenter.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            f287005a = iArr;
        }
    }

    public TempMsgSettingVM() {
        Map<Integer, SettingItemType> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1000, SettingItemType.NewTroop), TuplesKt.to(1006, SettingItemType.NewContact), TuplesKt.to(1005, SettingItemType.NewConsult), TuplesKt.to(1024, SettingItemType.NewCompanyQQ));
        this.mViewCache = mapOf;
        this.troopRightSwitchLiveData = new MutableLiveData<>();
        this.newTroopRightTextLiveData = new MutableLiveData<>();
        this.contactRightSwitchLiveData = new MutableLiveData<>();
        this.newContactRightTextLiveData = new MutableLiveData<>();
        this.consultRightSwitchLiveData = new MutableLiveData<>();
        this.newConsultRightTextLiveData = new MutableLiveData<>();
        this.newCompanyQQRightTextLiveData = new MutableLiveData<>();
        c2();
        d2();
    }

    private final void c2() {
        HashMap<Short, String> hashMap = this.mTagCache;
        String qqStr = HardCodeUtil.qqStr(R.string.hzl);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.temp_msg_setting_troop)");
        hashMap.put((short) -23308, qqStr);
        HashMap<Short, String> hashMap2 = this.mTagCache;
        String qqStr2 = HardCodeUtil.qqStr(R.string.hzb);
        Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(R.string.temp_msg_setting_contacts)");
        hashMap2.put((short) -23310, qqStr2);
        HashMap<Short, String> hashMap3 = this.mTagCache;
        String qqStr3 = HardCodeUtil.qqStr(R.string.hza);
        Intrinsics.checkNotNullExpressionValue(qqStr3, "qqStr(R.string.temp_msg_setting_consult)");
        hashMap3.put((short) -23309, qqStr3);
        HashMap<Short, String> hashMap4 = this.mTagCache;
        String qqStr4 = HardCodeUtil.qqStr(R.string.f230666zr);
        Intrinsics.checkNotNullExpressionValue(qqStr4, "qqStr(R.string.temp_msg_setting_company)");
        hashMap4.put((short) -20457, qqStr4);
        HashMap<Integer, String> hashMap5 = this.mResultCache;
        String qqStr5 = HardCodeUtil.qqStr(R.string.f230716zw);
        Intrinsics.checkNotNullExpressionValue(qqStr5, "qqStr(R.string.temp_msg_\u2026nd_remind_in_message_tab)");
        hashMap5.put(0, qqStr5);
        HashMap<Integer, String> hashMap6 = this.mResultCache;
        String qqStr6 = HardCodeUtil.qqStr(R.string.f230706zv);
        Intrinsics.checkNotNullExpressionValue(qqStr6, "qqStr(R.string.temp_msg_\u2026nd_remind_in_message_box)");
        hashMap6.put(1, qqStr6);
        HashMap<Integer, String> hashMap7 = this.mResultCache;
        String qqStr7 = HardCodeUtil.qqStr(R.string.f230726zx);
        Intrinsics.checkNotNullExpressionValue(qqStr7, "qqStr(R.string.temp_msg_setting_shield_message)");
        hashMap7.put(2, qqStr7);
    }

    private final void d2() {
        TempMsgManager e26 = e2();
        if (e26 != null) {
            e26.T(this);
        }
    }

    public final QQAppInterface L1() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
        if (peekAppRuntime instanceof QQAppInterface) {
            return (QQAppInterface) peekAppRuntime;
        }
        return null;
    }

    public final String M1(SettingItemType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        switch (b.f287005a[type.ordinal()]) {
            case 1:
                String qqStr = HardCodeUtil.qqStr(R.string.hzl);
                Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.temp_msg_setting_troop)");
                return qqStr;
            case 2:
                String qqStr2 = HardCodeUtil.qqStr(R.string.hzb);
                Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(R.string.temp_msg_setting_contacts)");
                return qqStr2;
            case 3:
                String qqStr3 = HardCodeUtil.qqStr(R.string.hza);
                Intrinsics.checkNotNullExpressionValue(qqStr3, "qqStr(R.string.temp_msg_setting_consult)");
                return qqStr3;
            case 4:
                String qqStr4 = HardCodeUtil.qqStr(R.string.hzl);
                Intrinsics.checkNotNullExpressionValue(qqStr4, "qqStr(R.string.temp_msg_setting_troop)");
                return qqStr4;
            case 5:
                String qqStr5 = HardCodeUtil.qqStr(R.string.hzb);
                Intrinsics.checkNotNullExpressionValue(qqStr5, "qqStr(R.string.temp_msg_setting_contacts)");
                return qqStr5;
            case 6:
                String qqStr6 = HardCodeUtil.qqStr(R.string.hza);
                Intrinsics.checkNotNullExpressionValue(qqStr6, "qqStr(R.string.temp_msg_setting_consult)");
                return qqStr6;
            case 7:
                String qqStr7 = HardCodeUtil.qqStr(R.string.f230666zr);
                Intrinsics.checkNotNullExpressionValue(qqStr7, "qqStr(R.string.temp_msg_setting_company)");
                return qqStr7;
            case 8:
                String qqStr8 = HardCodeUtil.qqStr(R.string.f230696zu);
                Intrinsics.checkNotNullExpressionValue(qqStr8, "qqStr(R.string.temp_msg_setting_game_center)");
                return qqStr8;
            default:
                return "";
        }
    }

    public final boolean N1(SettingItemType type) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(type, "type");
        TempMsgManager e26 = e2();
        Map<String, Boolean> t16 = e26 != null ? e26.t() : null;
        String tempMsgSettingString = type.tempMsgSettingString();
        if (t16 == null || (bool = t16.get(tempMsgSettingString)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final String O1(SettingItemType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        TempMsgManager e26 = e2();
        Map<String, Boolean> x16 = e26 != null ? e26.x() : null;
        TempMsgManager e27 = e2();
        Map<String, Boolean> t16 = e27 != null ? e27.t() : null;
        String tempMsgSettingString = type.tempMsgSettingString();
        Boolean bool = x16 != null ? x16.get(tempMsgSettingString) : null;
        Boolean bool2 = t16 != null ? t16.get(tempMsgSettingString) : null;
        if (bool == null || bool2 == null) {
            return "";
        }
        String str = this.mResultCache.get(Integer.valueOf(((ITempMsgBoxService) QRoute.api(ITempMsgBoxService.class)).getTempSettingStatus(bool2.booleanValue(), bool.booleanValue())));
        return str == null ? "" : str;
    }

    public final boolean P1(SettingItemType type) {
        boolean configContains;
        Intrinsics.checkNotNullParameter(type, "type");
        QQAppInterface L1 = L1();
        if (L1 == null) {
            return false;
        }
        IRuntimeService runtimeService = L1.getRuntimeService(ITempMsgBoxManager.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IT\u2026va, ProcessConstant.MAIN)");
        ITempMsgBoxManager iTempMsgBoxManager = (ITempMsgBoxManager) runtimeService;
        switch (b.f287005a[type.ordinal()]) {
            case 1:
                configContains = iTempMsgBoxManager.configContains(1000);
                break;
            case 2:
                configContains = iTempMsgBoxManager.configContains(1006);
                break;
            case 3:
                configContains = iTempMsgBoxManager.configContains(1005);
                break;
            case 4:
                return iTempMsgBoxManager.configContains(1000);
            case 5:
                return iTempMsgBoxManager.configContains(1006);
            case 6:
                return iTempMsgBoxManager.configContains(1005);
            case 7:
                return iTempMsgBoxManager.configContains(1024);
            case 8:
                return iTempMsgBoxManager.configContains(10007);
            default:
                return false;
        }
        return !configContains;
    }

    public final MutableLiveData<Boolean> Q1() {
        return this.consultRightSwitchLiveData;
    }

    public final MutableLiveData<Boolean> R1() {
        return this.contactRightSwitchLiveData;
    }

    public final HashMap<Integer, String> S1() {
        return this.mResultCache;
    }

    public final Map<Integer, SettingItemType> T1() {
        return this.mViewCache;
    }

    public final MutableLiveData<String> U1() {
        return this.newCompanyQQRightTextLiveData;
    }

    public final MutableLiveData<String> W1() {
        return this.newConsultRightTextLiveData;
    }

    public final MutableLiveData<String> X1() {
        return this.newContactRightTextLiveData;
    }

    public final MutableLiveData<String> Z1() {
        return this.newTroopRightTextLiveData;
    }

    public final String a2(short type) {
        if (!this.mTagCache.containsKey(Short.valueOf(type))) {
            return "";
        }
        return this.mTagCache.get(Short.valueOf(type));
    }

    public final MutableLiveData<Boolean> b2() {
        return this.troopRightSwitchLiveData;
    }

    public final TempMsgManager e2() {
        QQAppInterface L1 = L1();
        Manager manager = L1 != null ? L1.getManager(QQManagerFactory.TEMP_MSG_SETTTING_MANAGER) : null;
        if (manager instanceof TempMsgManager) {
            return (TempMsgManager) manager;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        TempMsgManager e26 = e2();
        if (e26 != null) {
            e26.T(null);
        }
    }

    @Override // com.tencent.mobileqq.managers.TempMsgManager.d
    public void k1(short type, boolean syncResult, boolean nowStatus, boolean nowInBoxStatus) {
        if (syncResult) {
            return;
        }
        int tempSettingStatus = ((ITempMsgBoxService) QRoute.api(ITempMsgBoxService.class)).getTempSettingStatus(nowStatus, nowInBoxStatus);
        if (type == -23308 || type == -20461) {
            this.troopRightSwitchLiveData.postValue(Boolean.valueOf(nowStatus));
            MutableLiveData<String> mutableLiveData = this.newTroopRightTextLiveData;
            String str = this.mResultCache.get(Integer.valueOf(tempSettingStatus));
            mutableLiveData.postValue(str != null ? str : "");
            return;
        }
        if (type == -23310 || type == -20460) {
            this.contactRightSwitchLiveData.postValue(Boolean.valueOf(nowStatus));
            MutableLiveData<String> mutableLiveData2 = this.newContactRightTextLiveData;
            String str2 = this.mResultCache.get(Integer.valueOf(tempSettingStatus));
            mutableLiveData2.postValue(str2 != null ? str2 : "");
            return;
        }
        if (type == -23309 || type == -20459) {
            this.consultRightSwitchLiveData.postValue(Boolean.valueOf(nowStatus));
            MutableLiveData<String> mutableLiveData3 = this.newConsultRightTextLiveData;
            String str3 = this.mResultCache.get(Integer.valueOf(tempSettingStatus));
            mutableLiveData3.postValue(str3 != null ? str3 : "");
            return;
        }
        if (type == -20457 || type == -20455) {
            MutableLiveData<String> mutableLiveData4 = this.newCompanyQQRightTextLiveData;
            String str4 = this.mResultCache.get(Integer.valueOf(tempSettingStatus));
            mutableLiveData4.postValue(str4 != null ? str4 : "");
        }
    }
}
