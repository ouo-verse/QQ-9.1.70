package com.tencent.mobileqq.setting.generalSetting.subChatSetting;

import android.content.SharedPreferences;
import android.os.Looper;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.profilecard.base.report.ProfileCardBlacklistReportConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.stt.impl.SttManagerApiImpl;
import com.tencent.mobileqq.tianshu.api.IMobileReportManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.perception.api.IVipPerception;
import com.tencent.mobileqq.vas.perception.api.VipPerceptionRequestResult;
import com.tencent.mobileqq.vas.qqmc.QVipAutoPttConfig;
import com.tencent.mobileqq.vas.search.SearchConstants;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.vip.QVipConfigManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.emotion.stickerrecommended.IStickerRecManager;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\b\u0007*\u0001E\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bI\u0010JJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J#\u0010\u000b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\r\u001a\u00020\bH\u0002J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\bH\u0002J\u0012\u0010\u0012\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0005H\u0014J\u000e\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0002J\u0006\u0010\u0016\u001a\u00020\u0002J\u000e\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0002J\u000e\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0002J\u000e\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002JN\u0010!\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\b2&\u0010 \u001a\"\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001ej\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\u001fR\u0014\u0010$\u001a\u00020\u00108\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u001d\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00020%8\u0006\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001d\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00020%8\u0006\u00a2\u0006\f\n\u0004\b+\u0010'\u001a\u0004\b,\u0010)R\u001d\u00101\u001a\b\u0012\u0004\u0012\u00020.0%8\u0006\u00a2\u0006\f\n\u0004\b/\u0010'\u001a\u0004\b0\u0010)R\u001d\u00104\u001a\b\u0012\u0004\u0012\u00020\u00050%8\u0006\u00a2\u0006\f\n\u0004\b2\u0010'\u001a\u0004\b3\u0010)R\u001d\u00107\u001a\b\u0012\u0004\u0012\u00020\u00050%8\u0006\u00a2\u0006\f\n\u0004\b5\u0010'\u001a\u0004\b6\u0010)R\u001d\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00050%8\u0006\u00a2\u0006\f\n\u0004\b8\u0010'\u001a\u0004\b9\u0010)R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\"\u0010A\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u0014\u0010H\u001a\u00020E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010G\u00a8\u0006K"}, d2 = {"Lcom/tencent/mobileqq/setting/generalSetting/subChatSetting/SubChatSettingVM;", "Landroidx/lifecycle/ViewModel;", "", "c2", "fromGrayMsg", "", "R1", SemanticAttributes.DbSystemValues.H2, "", "actionId", "isSwitch", "f2", "(ILjava/lang/Boolean;)V", "b2", "msgId", "k2", "", "msg", "l2", "onCleared", "isChecked", "i2", "d2", "j2", "enable", "S1", "m2", "moduleId", "itemId", "itemType", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "busiInfo", "e2", "i", "Ljava/lang/String;", "TAG", "Landroidx/lifecycle/MutableLiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "T1", "()Landroidx/lifecycle/MutableLiveData;", "emotionRecLiveData", BdhLogUtil.LogTag.Tag_Conn, "U1", "pttAutoChangeLiveData", "", "D", "W1", "pttAutoTitleLiveData", "E", ICustomDataEditor.STRING_ARRAY_PARAM_2, "showPttAutoTipLiveData", UserInfo.SEX_FEMALE, "Z1", "showPttAutoPayLiveData", "G", "X1", "showExperiencePttAutoDialog", "Lgu4/e;", "H", "Lgu4/e;", "cacheExperienceInfoRsp", "I", "Z", "isFromGrayMsg", "()Z", "setFromGrayMsg", "(Z)V", "com/tencent/mobileqq/setting/generalSetting/subChatSetting/SubChatSettingVM$a", "J", "Lcom/tencent/mobileqq/setting/generalSetting/subChatSetting/SubChatSettingVM$a;", "cardObserver", "<init>", "()V", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class SubChatSettingVM extends ViewModel {

    /* renamed from: H, reason: from kotlin metadata */
    private gu4.e cacheExperienceInfoRsp;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean isFromGrayMsg;

    /* renamed from: J, reason: from kotlin metadata */
    private final a cardObserver;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final String TAG = "SubChatSettingVM";

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<Boolean> emotionRecLiveData = new MutableLiveData<>();

    /* renamed from: C, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> pttAutoChangeLiveData = new MutableLiveData<>();

    /* renamed from: D, reason: from kotlin metadata */
    private final MutableLiveData<CharSequence> pttAutoTitleLiveData = new MutableLiveData<>();

    /* renamed from: E, reason: from kotlin metadata */
    private final MutableLiveData<Unit> showPttAutoTipLiveData = new MutableLiveData<>();

    /* renamed from: F, reason: from kotlin metadata */
    private final MutableLiveData<Unit> showPttAutoPayLiveData = new MutableLiveData<>();

    /* renamed from: G, reason: from kotlin metadata */
    private final MutableLiveData<Unit> showExperiencePttAutoDialog = new MutableLiveData<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0014\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/setting/generalSetting/subChatSetting/SubChatSettingVM$a", "Lcom/tencent/mobileqq/app/CardObserver;", "", "isSuccess", "curSwitch", "", "onSetEmotionRecSwitch", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a extends CardObserver {
        a() {
        }

        @Override // com.tencent.mobileqq.app.CardObserver
        protected void onSetEmotionRecSwitch(boolean isSuccess, boolean curSwitch) {
            IStickerRecManager iStickerRecManager;
            QLog.i(SubChatSettingVM.this.TAG, 1, "onSetEmotionRecSwitch isSuccess = " + isSuccess + " currSwitch = " + curSwitch);
            if (!isSuccess) {
                SubChatSettingVM.this.k2(R.string.hhc);
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
                SubChatSettingVM.this.T1().postValue(Boolean.valueOf((qQAppInterface == null || (iStickerRecManager = (IStickerRecManager) qQAppInterface.getRuntimeService(IStickerRecManager.class)) == null || !iStickerRecManager.isEmotionRecSettingOpen()) ? false : true));
                return;
            }
            SubChatSettingVM.this.T1().postValue(Boolean.valueOf(curSwitch));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\"\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/setting/generalSetting/subChatSetting/SubChatSettingVM$b", "Lcom/tencent/mobileqq/vas/perception/api/VipPerceptionRequestResult;", "Lgu4/o;", "result", "", "data", "", "b", "", "code", "", "msg", "a", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements VipPerceptionRequestResult<gu4.o> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f286532b;

        b(boolean z16) {
            this.f286532b = z16;
        }

        @Override // com.tencent.mobileqq.vas.perception.api.VipPerceptionRequestResult
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void failure(int code, String msg2, gu4.o result) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QLog.i(SubChatSettingVM.this.TAG, 1, "getUserExperience code:" + code + " msg:" + msg2);
        }

        @Override // com.tencent.mobileqq.vas.perception.api.VipPerceptionRequestResult
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void success(gu4.o result, Object data) {
            Intrinsics.checkNotNullParameter(result, "result");
            Intrinsics.checkNotNullParameter(data, "data");
            gu4.e eVar = result.f403410c;
            if (eVar == null) {
                return;
            }
            SubChatSettingVM.this.cacheExperienceInfoRsp = eVar;
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            String currentAccountUin = peekAppRuntime != null ? peekAppRuntime.getCurrentAccountUin() : null;
            if (currentAccountUin == null) {
                currentAccountUin = "";
            }
            gu4.e eVar2 = result.f403410c;
            if (eVar2.f403385a) {
                SubChatSettingVM.this.h2(this.f286532b);
            } else if (eVar2.f403386b && ((IVipPerception) QRoute.api(IVipPerception.class)).checkInExperience(currentAccountUin, 2)) {
                if (this.f286532b) {
                    SubChatSettingVM.this.X1().postValue(null);
                } else {
                    SubChatSettingVM.this.W1().postValue(BaseApplication.getContext().getString(R.string.d4x));
                }
            }
            SubChatSettingVM.g2(SubChatSettingVM.this, 101, null, 2, null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\"\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/setting/generalSetting/subChatSetting/SubChatSettingVM$c", "Lcom/tencent/mobileqq/vas/perception/api/VipPerceptionRequestResult;", "Lgu4/m;", "result", "", "data", "", "b", "", "code", "", "msg", "a", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements VipPerceptionRequestResult<gu4.m> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f286533a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ SubChatSettingVM f286534b;

        c(boolean z16, SubChatSettingVM subChatSettingVM) {
            this.f286533a = z16;
            this.f286534b = subChatSettingVM;
        }

        @Override // com.tencent.mobileqq.vas.perception.api.VipPerceptionRequestResult
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void failure(int code, String msg2, gu4.m result) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (code == -10000001) {
                this.f286534b.k2(R.string.sze);
                return;
            }
            if (code == 10105) {
                if (this.f286533a) {
                    this.f286534b.X1().postValue(null);
                    return;
                } else {
                    this.f286534b.W1().postValue(BaseApplication.getContext().getString(R.string.d4x));
                    return;
                }
            }
            if (this.f286533a) {
                this.f286534b.l2(msg2);
            }
        }

        @Override // com.tencent.mobileqq.vas.perception.api.VipPerceptionRequestResult
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void success(gu4.m result, Object data) {
            Intrinsics.checkNotNullParameter(result, "result");
            Intrinsics.checkNotNullParameter(data, "data");
            if (this.f286533a) {
                this.f286534b.U1().postValue(Boolean.TRUE);
                this.f286534b.X1().postValue(null);
            } else {
                this.f286534b.W1().postValue(BaseApplication.getContext().getString(R.string.d4x));
            }
        }
    }

    public SubChatSettingVM() {
        a aVar = new a();
        this.cardObserver = aVar;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface != null) {
            appInterface.addObserver(aVar);
        }
    }

    private final void R1(boolean fromGrayMsg) {
        ((IVipPerception) QRoute.api(IVipPerception.class)).getUserExperience(2, new b(fromGrayMsg));
    }

    private final int b2() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return 0;
        }
        if (VasUtil.getSignedService(peekAppRuntime).getVipStatus().isSVip()) {
            return 2;
        }
        gu4.e eVar = this.cacheExperienceInfoRsp;
        if (!(eVar != null && eVar.f403385a)) {
            if (!(eVar != null && eVar.f403386b)) {
                return 0;
            }
        }
        return 1;
    }

    private final boolean c2() {
        IVipPerception iVipPerception = (IVipPerception) QRoute.api(IVipPerception.class);
        String currentAccountUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin();
        if (currentAccountUin == null) {
            currentAccountUin = "";
        }
        return iVipPerception.checkInExperience(currentAccountUin, 2);
    }

    private final void f2(int actionId, Boolean isSwitch) {
        String str;
        HashMap<String, String> hashMap = new HashMap<>();
        int b26 = b2();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(b26);
        hashMap.put("user_status", sb5.toString());
        String str2 = "1";
        if (!this.isFromGrayMsg) {
            str = "1";
        } else {
            str = "2";
        }
        hashMap.put("jump_from", str);
        if (isSwitch != null) {
            if (!isSwitch.booleanValue()) {
                str2 = "0";
            }
            hashMap.put(ProfileCardBlacklistReportConst.ELEM_PARAM_SWITCH_STATUS, str2);
        }
        e2("voice_to_word", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, "4", actionId, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h2(boolean fromGrayMsg) {
        ((IVipPerception) QRoute.api(IVipPerception.class)).obtainExperience(2, new c(fromGrayMsg, this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k2(int msgId) {
        l2(BaseApplication.getContext().getString(msgId));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n2(SubChatSettingVM this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        if (VasUtil.getSignedService(peekAppRuntime).getVipStatus().isSVip()) {
            g2(this$0, 101, null, 2, null);
        } else {
            if (com.tencent.mobileqq.activity.aio.item.m.f179515e) {
                return;
            }
            this$0.R1(z16);
        }
    }

    public final void S1(boolean enable) {
        SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences(AppConstants.Preferences.CHECK_UPDATE_SP_KEY, 0);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String currentUin = peekAppRuntime != null ? peekAppRuntime.getCurrentUin() : null;
        if (currentUin == null) {
            currentUin = "";
        }
        String str = "businessinfo_ptt_auto_change_text_" + currentUin;
        String str2 = "businessinfo_ptt_auto_change_time_" + currentUin;
        String str3 = "businessinfo_ptt_auto_change_guide_has_show_" + currentUin;
        long serverTime = NetConnInfoCenter.getServerTime();
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean(str, enable);
        if (enable) {
            edit.putLong(str2, serverTime);
            edit.putBoolean(str3, true);
            com.tencent.mobileqq.activity.aio.item.m.f179517g = true;
        } else {
            edit.putLong(str2, Long.MAX_VALUE);
        }
        edit.apply();
        com.tencent.mobileqq.activity.aio.item.m.f179515e = enable;
        com.tencent.mobileqq.activity.aio.item.m.f179516f = serverTime;
    }

    public final MutableLiveData<Boolean> T1() {
        return this.emotionRecLiveData;
    }

    public final MutableLiveData<Boolean> U1() {
        return this.pttAutoChangeLiveData;
    }

    public final MutableLiveData<CharSequence> W1() {
        return this.pttAutoTitleLiveData;
    }

    public final MutableLiveData<Unit> X1() {
        return this.showExperiencePttAutoDialog;
    }

    public final MutableLiveData<Unit> Z1() {
        return this.showPttAutoPayLiveData;
    }

    public final MutableLiveData<Unit> a2() {
        return this.showPttAutoTipLiveData;
    }

    public final boolean d2() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String currentUin = peekAppRuntime != null ? peekAppRuntime.getCurrentUin() : null;
        if (currentUin == null) {
            currentUin = "";
        }
        return BaseApplication.getContext().getSharedPreferences(AppConstants.Preferences.CHECK_UPDATE_SP_KEY, 0).getBoolean("businessinfo_ptt_auto_change_text_" + currentUin, false);
    }

    public final void e2(String moduleId, String itemId, String itemType, int actionId, HashMap<String, String> busiInfo) {
        Intrinsics.checkNotNullParameter(moduleId, "moduleId");
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(itemType, "itemType");
        String str = "";
        boolean z16 = false;
        if (busiInfo != null) {
            try {
                if (!busiInfo.isEmpty()) {
                    z16 = true;
                }
            } catch (Exception e16) {
                QLog.i(this.TAG, 1, "report exception: " + e16.getMessage());
                return;
            }
        }
        if (z16) {
            JSONObject jSONObject = new JSONObject();
            Set<Map.Entry<String, String>> entrySet = busiInfo.entrySet();
            Intrinsics.checkNotNullExpressionValue(entrySet, "busiInfo.entries");
            Iterator<T> it = entrySet.iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                jSONObject.put((String) entry.getKey(), entry.getValue());
            }
            str = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(str, "json.toString()");
        }
        ((IMobileReportManager) QRoute.api(IMobileReportManager.class)).reportAction(SearchConstants.PLATFORM, "auxiliary_function", moduleId, "", itemId, "", itemType, actionId, 0, 0, "", str, "");
    }

    public final void i2(boolean isChecked) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
        if (qQAppInterface == null) {
            return;
        }
        if (!NetworkUtil.isNetworkAvailable()) {
            QLog.w(this.TAG, 1, "setEmotionRecommendSwitch network is not available");
            k2(R.string.cjm);
            this.emotionRecLiveData.postValue(Boolean.valueOf(((IStickerRecManager) qQAppInterface.getRuntimeService(IStickerRecManager.class)).isEmotionRecSettingOpen()));
            return;
        }
        BusinessHandler businessHandler = qQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
        CardHandler cardHandler = businessHandler instanceof CardHandler ? (CardHandler) businessHandler : null;
        if (cardHandler == null) {
            return;
        }
        QLog.i(this.TAG, 1, "setEmotionRecommendSwitch isChecked=" + isChecked);
        cardHandler.i5(isChecked);
    }

    public final void m2(final boolean fromGrayMsg) {
        this.isFromGrayMsg = fromGrayMsg;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.setting.generalSetting.subChatSetting.s
            @Override // java.lang.Runnable
            public final void run() {
                SubChatSettingVM.n2(SubChatSettingVM.this, fromGrayMsg);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface != null) {
            appInterface.removeObserver(this.cardObserver);
        }
    }

    public final void j2(boolean isChecked) {
        f2(102, Boolean.valueOf(isChecked));
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
        if (qQAppInterface == null) {
            return;
        }
        if (!NetworkUtil.isNetworkAvailable()) {
            QLog.w(this.TAG, 1, "setPttAutoChangeSwitch network is not available");
            k2(R.string.cjn);
            this.pttAutoChangeLiveData.postValue(Boolean.valueOf(d2()));
            return;
        }
        int stage = QVipAutoPttConfig.INSTANCE.getStage();
        if (isChecked && stage <= 1) {
            if (!QVipConfigManager.getBoolean(qQAppInterface, QVipConfigManager.KEY_BOOLEAN_HAVE_SHOW_PTT_TIP, false)) {
                QLog.i(SttManagerApiImpl.PTT_TAG + this.TAG, 1, "open the ptt check box and tip to user");
                this.showPttAutoTipLiveData.postValue(null);
            }
        } else if (isChecked && !VasUtil.getSignedService(qQAppInterface).getVipStatus().isSVip() && !c2()) {
            QLog.i(SttManagerApiImpl.PTT_TAG + this.TAG, 1, "open the ptt check box but u r not svip");
            this.pttAutoChangeLiveData.postValue(Boolean.FALSE);
            this.showPttAutoPayLiveData.postValue(null);
            return;
        }
        QLog.i(this.TAG, 1, "setPttAutoChangeSwitch start");
        if (!isChecked && stage <= 1) {
            QVipConfigManager.setBoolean(qQAppInterface, QVipConfigManager.KEY_BOOLEAN_HAVE_ADD_PTT_GRAY_MSG, false);
        }
        S1(isChecked);
        BusinessHandler businessHandler = qQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
        CardHandler cardHandler = businessHandler instanceof CardHandler ? (CardHandler) businessHandler : null;
        if (cardHandler != null) {
            cardHandler.q5(isChecked);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l2(final String msg2) {
        if (msg2 == null || msg2.length() == 0) {
            return;
        }
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            QQToast.makeText(BaseApplication.getContext(), 1, msg2, 0).show();
        } else {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.setting.generalSetting.subChatSetting.SubChatSettingVM$showToast$$inlined$runOnUiThread$1
                @Override // java.lang.Runnable
                public final void run() {
                    QQToast.makeText(BaseApplication.getContext(), 1, msg2, 0).show();
                }
            });
        }
    }

    static /* synthetic */ void g2(SubChatSettingVM subChatSettingVM, int i3, Boolean bool, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            bool = null;
        }
        subChatSettingVM.f2(i3, bool);
    }
}
