package com.tencent.mobileqq.vas.perception.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.vas.VasMMKVProxy;
import com.tencent.mobileqq.vas.VipMMKV;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.perception.api.IVipPerception;
import com.tencent.mobileqq.vas.perception.api.VipPerceptionRequestResult;
import com.tencent.mobileqq.vas.toggle.UnitedProxy;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.graytips.api.INtGrayTipApi;
import com.tencent.qqnt.graytips.local.LocalGrayTip;
import com.tencent.util.AppSetting;
import gu4.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import okhttp3.HttpUrl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 >2\u00020\u0001:\u0001?B\u0007\u00a2\u0006\u0004\b<\u0010=J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J0\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0002J6\u0010\u0014\u001a\u00020\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u00112\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\fH\u0002J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0002J \u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0006H\u0002J \u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0006H\u0002J\u0014\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u001eH\u0002J \u0010 \u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0006H\u0002J\u0018\u0010!\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0006H\u0002JA\u0010)\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u00042'\u0010(\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000f0$\u00a2\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u000f0#H\u0002J\u0010\u0010*\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010+\u001a\u00020\nH\u0002J\b\u0010,\u001a\u00020\nH\u0002J\b\u0010-\u001a\u00020\nH\u0002J\b\u0010.\u001a\u00020\nH\u0002J\u0010\u00100\u001a\u00020\u000f2\u0006\u0010/\u001a\u00020\nH\u0002J(\u00102\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u00101\u001a\u00020\u0002H\u0016J(\u00103\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u00101\u001a\u00020\u0002H\u0016J\u0018\u00104\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0002H\u0016J\u0018\u00105\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0002H\u0016J\u0018\u00106\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u00108\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u000207\u0018\u00010\fH\u0016J \u0010:\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u000209\u0018\u00010\fH\u0016J\b\u0010;\u001a\u00020\u000fH\u0016\u00a8\u0006@"}, d2 = {"Lcom/tencent/mobileqq/vas/perception/api/impl/VipPerceptionImpl;", "Lcom/tencent/mobileqq/vas/perception/api/IVipPerception;", "", "uin", "", "skippedUin", "", "privilegeType", "getLastExpiredNotifyTime", "aioType", "", IProfileProtocolConst.PARAM_TARGET_UIN, "Lcom/tencent/mobileqq/vas/perception/api/VipPerceptionRequestResult;", "Lgu4/i;", "callback", "", "guide", "", "privilegeTypeList", "Lgu4/c;", "expireNotice", "getSelfExperienceQualificationTime", "buildExperienceQualificationKey", "chatType", "getAioType", "peerUin", "guideFlagType", "addCommonPttGuideGrayTip", "peerUid", "addLocalPTTGuideGrayTipOnWeakLimit", "Lkotlin/Pair;", "getSVIPLocalInsertConfig", "addLocalPTTGuideGrayTip", "addSVipLocalGrayTip", "isLocal", "Lkotlin/Function1;", "Lkotlin/Function0;", "Lkotlin/ParameterName;", "name", "successCall", "postGuideGrayTip", "tryTriggerGrayTip", "buildExpiredNotifyKey", "buildPtt30sGuideKey", "buildPTTGuideKey", "buildGroupKeyWordKey", "selfUin", "msg", "userLog", AppConstants.Key.COLUMN_MSG_SENDER_UIN, "longClickVoiceMsg", "voiceMsg30s", "sVipExpiredCheck", "groupKeyWord", "checkInExperience", "Lgu4/o;", "getUserExperience", "Lgu4/m;", "obtainExperience", "debugClearCache", "<init>", "()V", "Companion", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VipPerceptionImpl implements IVipPerception {
    private static final int GUIDE_FLAG_30s = 1;
    private static final int GUIDE_FLAG_DEF = 0;
    private static final int GUIDE_FLAG_LONG_CLICK = 16;

    @NotNull
    private static final String KEY_DEBUG_CACHE_EXPIRE_KEY = "perception_debug_cache_expire_key";

    @NotNull
    private static final String KEY_EXPERIENCE_QUALIFICATION = "vip_perception_key_experience_qualification";

    @NotNull
    private static final String KEY_EXPIRED_NOTIFY_NEXT_REQ_TIME = "perception_expired_notify_next_req_time";

    @NotNull
    private static final String KEY_HAVE_RECEIVE_30s_VOICE = "perception_have_receive_30s_voice";

    @NotNull
    private static final String KEY_HAVE_SHOW_OPEN_SVIP_GRAY_MSG = "perception_have_show_open_svip_gray_msg";

    @NotNull
    private static final String KEY_ONE_WEEK_LIMIT_SVIP_USE = "vip_perception_key_one_week_limit_svip_use";

    @NotNull
    private static final String KEY_VAS_GROUP_KEY_WORD_GRAY_TIP = "perception_vas_group_key_word_gray_tip";

    @NotNull
    private static final String TAG = "VasVipPerceptionImpl";

    @NotNull
    private static final UnitedProxy svipLocalInsertConfig;
    private static final boolean svipLocalInsertEnable;

    @NotNull
    private static final UnitedProxy svipLocalTipsSkip;

    @NotNull
    private static final Map<String, Integer> requestFlagMap = new LinkedHashMap();
    private static boolean IS_DEBUG = AppSetting.isDebugVersion();

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\"\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/vas/perception/api/impl/VipPerceptionImpl$b", "Lcom/tencent/mobileqq/vas/perception/api/VipPerceptionRequestResult;", "Lgu4/o;", "result", "", "data", "", "b", "", "code", "", "msg", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b implements VipPerceptionRequestResult<o> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f310528b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ VipPerceptionRequestResult<o> f310529c;

        b(int i3, VipPerceptionRequestResult<o> vipPerceptionRequestResult) {
            this.f310528b = i3;
            this.f310529c = vipPerceptionRequestResult;
        }

        @Override // com.tencent.mobileqq.vas.perception.api.VipPerceptionRequestResult
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void failure(int code, @NotNull String msg2, @Nullable o result) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            VipPerceptionRequestResult<o> vipPerceptionRequestResult = this.f310529c;
            if (vipPerceptionRequestResult != null) {
                vipPerceptionRequestResult.failure(code, msg2, result);
            }
        }

        @Override // com.tencent.mobileqq.vas.perception.api.VipPerceptionRequestResult
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void success(@NotNull o result, @NotNull Object data) {
            long j3;
            Intrinsics.checkNotNullParameter(result, "result");
            Intrinsics.checkNotNullParameter(data, "data");
            gu4.e eVar = result.f403410c;
            if (eVar != null) {
                j3 = eVar.f403387c;
            } else {
                j3 = 0;
            }
            if (j3 > 0) {
                MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
                Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
                VipPerceptionImpl vipPerceptionImpl = VipPerceptionImpl.this;
                from.encodeLong(vipPerceptionImpl.buildExperienceQualificationKey(vipPerceptionImpl.selfUin(), this.f310528b), result.f403410c.f403387c);
            }
            int i3 = result.f403408a;
            if (i3 == 0) {
                VipPerceptionRequestResult<o> vipPerceptionRequestResult = this.f310529c;
                if (vipPerceptionRequestResult != null) {
                    vipPerceptionRequestResult.success(result, data);
                    return;
                }
                return;
            }
            VipPerceptionRequestResult<o> vipPerceptionRequestResult2 = this.f310529c;
            if (vipPerceptionRequestResult2 != null) {
                String str = result.f403409b;
                Intrinsics.checkNotNullExpressionValue(str, "result.msg");
                vipPerceptionRequestResult2.failure(i3, str, result);
            }
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\"\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/vas/perception/api/impl/VipPerceptionImpl$c", "Lcom/tencent/mobileqq/vas/perception/api/VipPerceptionRequestResult;", "Lgu4/i;", "result", "", "data", "", "b", "", "code", "", "msg", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class c implements VipPerceptionRequestResult<gu4.i> {
        c() {
        }

        @Override // com.tencent.mobileqq.vas.perception.api.VipPerceptionRequestResult
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void failure(int code, @NotNull String msg2, @Nullable gu4.i result) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QLog.w(VipPerceptionImpl.TAG, 1, "addCommonGuideGrayTip \u5c0f\u7070\u6761\u63d2\u5165\u5931\u8d25,code:" + code + ",msg:" + msg2);
        }

        @Override // com.tencent.mobileqq.vas.perception.api.VipPerceptionRequestResult
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void success(@NotNull gu4.i result, @NotNull Object data) {
            Intrinsics.checkNotNullParameter(result, "result");
            Intrinsics.checkNotNullParameter(data, "data");
            VipPerceptionImpl.requestFlagMap.put(VipPerceptionImpl.this.buildGroupKeyWordKey(), 1);
            QLog.w(VipPerceptionImpl.TAG, 1, "addCommonGuideGrayTip \u5c0f\u7070\u6761\u63d2\u5165\u6210\u529f GROUP_KEYWORD");
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\"\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/vas/perception/api/impl/VipPerceptionImpl$d", "Lcom/tencent/mobileqq/vas/perception/api/VipPerceptionRequestResult;", "Lgu4/m;", "result", "", "data", "", "b", "", "code", "", "msg", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class d implements VipPerceptionRequestResult<gu4.m> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f310532b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ VipPerceptionRequestResult<gu4.m> f310533c;

        d(int i3, VipPerceptionRequestResult<gu4.m> vipPerceptionRequestResult) {
            this.f310532b = i3;
            this.f310533c = vipPerceptionRequestResult;
        }

        @Override // com.tencent.mobileqq.vas.perception.api.VipPerceptionRequestResult
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void failure(int code, @NotNull String msg2, @Nullable gu4.m result) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            VipPerceptionRequestResult<gu4.m> vipPerceptionRequestResult = this.f310533c;
            if (vipPerceptionRequestResult != null) {
                vipPerceptionRequestResult.failure(code, msg2, result);
            }
        }

        @Override // com.tencent.mobileqq.vas.perception.api.VipPerceptionRequestResult
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void success(@NotNull gu4.m result, @NotNull Object data) {
            Intrinsics.checkNotNullParameter(result, "result");
            Intrinsics.checkNotNullParameter(data, "data");
            if (result.f403404c > 0) {
                MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
                Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
                VipPerceptionImpl vipPerceptionImpl = VipPerceptionImpl.this;
                from.encodeLong(vipPerceptionImpl.buildExperienceQualificationKey(vipPerceptionImpl.selfUin(), this.f310532b), result.f403404c);
            }
            int i3 = result.f403402a;
            if (i3 == 0) {
                VipPerceptionRequestResult<gu4.m> vipPerceptionRequestResult = this.f310533c;
                if (vipPerceptionRequestResult != null) {
                    vipPerceptionRequestResult.success(result, data);
                    return;
                }
                return;
            }
            VipPerceptionRequestResult<gu4.m> vipPerceptionRequestResult2 = this.f310533c;
            if (vipPerceptionRequestResult2 != null) {
                String str = result.f403403b;
                Intrinsics.checkNotNullExpressionValue(str, "result.msg");
                vipPerceptionRequestResult2.failure(i3, str, result);
            }
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\"\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/vas/perception/api/impl/VipPerceptionImpl$e", "Lcom/tencent/mobileqq/vas/perception/api/VipPerceptionRequestResult;", "Lgu4/c;", "result", "", "data", "", "b", "", "code", "", "msg", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class e implements VipPerceptionRequestResult<gu4.c> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List<Integer> f310534a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ VipPerceptionImpl f310535b;

        e(List<Integer> list, VipPerceptionImpl vipPerceptionImpl) {
            this.f310534a = list;
            this.f310535b = vipPerceptionImpl;
        }

        @Override // com.tencent.mobileqq.vas.perception.api.VipPerceptionRequestResult
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void failure(int code, @NotNull String msg2, @Nullable gu4.c result) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QLog.i(VipPerceptionImpl.TAG, 1, "\u66f4\u65b0Expired notify \u65f6\u95f4\u5931\u8d25, code:" + code + " msg:" + msg2);
        }

        @Override // com.tencent.mobileqq.vas.perception.api.VipPerceptionRequestResult
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void success(@NotNull gu4.c result, @NotNull Object data) {
            gu4.k kVar;
            boolean contains$default;
            boolean z16;
            Intrinsics.checkNotNullParameter(result, "result");
            Intrinsics.checkNotNullParameter(data, "data");
            int i3 = result.f403381a;
            if (i3 == 0) {
                List<Integer> list = this.f310534a;
                VipPerceptionImpl vipPerceptionImpl = this.f310535b;
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    int intValue = ((Number) it.next()).intValue();
                    gu4.k[] kVarArr = result.f403383c;
                    Intrinsics.checkNotNullExpressionValue(kVarArr, "result.nextReqTimestamp");
                    int length = kVarArr.length;
                    int i16 = 0;
                    while (true) {
                        if (i16 < length) {
                            kVar = kVarArr[i16];
                            if (kVar.f403399a == intValue) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            if (z16) {
                                break;
                            } else {
                                i16++;
                            }
                        } else {
                            kVar = null;
                            break;
                        }
                    }
                    if (kVar != null) {
                        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
                        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
                        String buildExpiredNotifyKey = vipPerceptionImpl.buildExpiredNotifyKey(intValue);
                        from.encodeLong(buildExpiredNotifyKey, kVar.f403400b);
                        String cacheKey = from.decodeString(VipPerceptionImpl.KEY_DEBUG_CACHE_EXPIRE_KEY, "");
                        Intrinsics.checkNotNullExpressionValue(cacheKey, "cacheKey");
                        contains$default = StringsKt__StringsKt.contains$default((CharSequence) cacheKey, (CharSequence) buildExpiredNotifyKey, false, 2, (Object) null);
                        if (!contains$default) {
                            if (!TextUtils.isEmpty(cacheKey)) {
                                buildExpiredNotifyKey = cacheKey + "," + buildExpiredNotifyKey;
                            }
                            from.encodeString(VipPerceptionImpl.KEY_DEBUG_CACHE_EXPIRE_KEY, buildExpiredNotifyKey);
                        }
                        QLog.i(VipPerceptionImpl.TAG, 1, "\u66f4\u65b0Expired notify \u65f6\u95f4 type:" + intValue + " , time:" + kVar.f403400b);
                    }
                }
                return;
            }
            QLog.i(VipPerceptionImpl.TAG, 1, "\u66f4\u65b0Expired notify \u65f6\u95f4\u5931\u8d25, code:" + i3 + " msg:" + result.f403382b);
        }
    }

    static {
        ar.Companion companion = ar.INSTANCE;
        UnitedProxy b16 = companion.b("shouyouye", "2024-04-10", "vas_ptt_gray_tip_config");
        svipLocalInsertConfig = b16;
        svipLocalInsertEnable = b16.isEnable(true);
        svipLocalTipsSkip = companion.b("linkliang", "2024-03-21", "vas_audio_graytips_blacklist");
    }

    private final void addCommonPttGuideGrayTip(final String peerUin, final int chatType, int guideFlagType) {
        tryTriggerGrayTip(guideFlagType, false, new Function1<Function0<? extends Unit>, Unit>() { // from class: com.tencent.mobileqq.vas.perception.api.impl.VipPerceptionImpl$addCommonPttGuideGrayTip$1

            @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\"\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/vas/perception/api/impl/VipPerceptionImpl$addCommonPttGuideGrayTip$1$a", "Lcom/tencent/mobileqq/vas/perception/api/VipPerceptionRequestResult;", "Lgu4/i;", "result", "", "data", "", "b", "", "code", "", "msg", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes20.dex */
            public static final class a implements VipPerceptionRequestResult<gu4.i> {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ VipPerceptionImpl f310525a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ Function0<Unit> f310526b;

                a(VipPerceptionImpl vipPerceptionImpl, Function0<Unit> function0) {
                    this.f310525a = vipPerceptionImpl;
                    this.f310526b = function0;
                }

                @Override // com.tencent.mobileqq.vas.perception.api.VipPerceptionRequestResult
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public void failure(int code, @NotNull String msg2, @Nullable gu4.i result) {
                    Intrinsics.checkNotNullParameter(msg2, "msg");
                    QLog.w("VasVipPerceptionImpl", 1, "addCommonGuideGrayTip \u5c0f\u7070\u6761\u63d2\u5165\u5931\u8d25,code:" + code + ",msg:" + msg2);
                }

                @Override // com.tencent.mobileqq.vas.perception.api.VipPerceptionRequestResult
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public void success(@NotNull gu4.i result, @NotNull Object data) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    Intrinsics.checkNotNullParameter(data, "data");
                    this.f310525a.userLog("voiceMsg30s addCommonPttGuideGrayTip GUIDE_FLAG_30s success");
                    this.f310526b.invoke();
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function0<? extends Unit> function0) {
                invoke2((Function0<Unit>) function0);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Function0<Unit> successCall) {
                int aioType;
                Intrinsics.checkNotNullParameter(successCall, "successCall");
                VipPerceptionImpl vipPerceptionImpl = VipPerceptionImpl.this;
                aioType = vipPerceptionImpl.getAioType(chatType);
                vipPerceptionImpl.guide(2, aioType, peerUin, new a(VipPerceptionImpl.this, successCall));
            }
        });
    }

    private final void addLocalPTTGuideGrayTip(final String peerUid, final int chatType, int guideFlagType) {
        tryTriggerGrayTip(guideFlagType, true, new Function1<Function0<? extends Unit>, Unit>() { // from class: com.tencent.mobileqq.vas.perception.api.impl.VipPerceptionImpl$addLocalPTTGuideGrayTip$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function0<? extends Unit> function0) {
                invoke2((Function0<Unit>) function0);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Function0<Unit> successCall) {
                Intrinsics.checkNotNullParameter(successCall, "successCall");
                VipPerceptionImpl.this.userLog("voiceMsg30s addLocalPTTGuideGrayTip GUIDE_FLAG_30s succss");
                VipPerceptionImpl.this.addSVipLocalGrayTip(peerUid, chatType);
                successCall.invoke();
            }
        });
    }

    private final void addLocalPTTGuideGrayTipOnWeakLimit(String peerUid, int chatType, int guideFlagType) {
        List split$default;
        boolean z16;
        boolean z17 = svipLocalInsertEnable;
        QLog.i(TAG, 1, "svipLocalInsertEnable:" + z17);
        if (!z17) {
            return;
        }
        VasMMKVProxy common2 = VipMMKV.INSTANCE.getCommon();
        String decodeString = common2.decodeString(KEY_ONE_WEEK_LIMIT_SVIP_USE, "");
        long currentTimeMillis = System.currentTimeMillis();
        if (!TextUtils.isEmpty(decodeString)) {
            try {
                Intrinsics.checkNotNull(decodeString);
                split$default = StringsKt__StringsKt.split$default((CharSequence) decodeString, new String[]{"_"}, false, 0, 6, (Object) null);
                boolean z18 = false;
                long parseLong = Long.parseLong((String) split$default.get(0));
                int parseInt = Integer.parseInt((String) split$default.get(1));
                Pair<Integer, Integer> sVIPLocalInsertConfig = getSVIPLocalInsertConfig();
                if (currentTimeMillis - parseLong > sVIPLocalInsertConfig.getFirst().intValue() * 60 * 60 * 1000) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (parseInt < sVIPLocalInsertConfig.getSecond().intValue()) {
                    z18 = true;
                }
                QLog.i(TAG, 1, "addLocalPTTGuideGrayTipOnWeakLimit \u672c\u5730\u4e3a\u63d2\u5165\u8fc7,\u76f4\u63a5\u63d2\u5165");
                if (z16 && z18) {
                    common2.encodeString(KEY_ONE_WEEK_LIMIT_SVIP_USE, currentTimeMillis + "_" + (parseInt + 1));
                    addSVipLocalGrayTip(peerUid, chatType);
                    return;
                }
                return;
            } catch (NumberFormatException e16) {
                QLog.i(TAG, 1, "addLocalPTTGuideGrayTipOnWeakLimit exception", e16);
                return;
            }
        }
        QLog.i(TAG, 1, "addLocalPTTGuideGrayTipOnWeakLimit \u672c\u5730\u4e3a\u63d2\u5165\u8fc7,\u76f4\u63a5\u63d2\u5165");
        common2.encodeString(KEY_ONE_WEEK_LIMIT_SVIP_USE, currentTimeMillis + "_1");
        addSVipLocalGrayTip(peerUid, chatType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addSVipLocalGrayTip(String peerUid, int chatType) {
        String obj = "SVIP\u4f1a\u5458\u53ef\u5f00\u542f\u8bed\u97f3\u81ea\u52a8\u8f6c\u6587\u5b57\uff0c\u9a6c\u4e0a\u5f00\u542f".subSequence(0, 17).toString();
        String obj2 = "SVIP\u4f1a\u5458\u53ef\u5f00\u542f\u8bed\u97f3\u81ea\u52a8\u8f6c\u6587\u5b57\uff0c\u9a6c\u4e0a\u5f00\u542f".subSequence(17, 21).toString();
        LocalGrayTip m3 = LocalGrayTip.LocalGrayTipBuilder.i(LocalGrayTip.LocalGrayTipBuilder.i(LocalGrayTip.LocalGrayTipBuilder.d(new LocalGrayTip.LocalGrayTipBuilder(peerUid, chatType, 2060L, 0, false, false, null, 120, null), "https://tianquan.gtimg.cn/shoal/vaclient/9f122979-fdb1-40db-9e34-8221fdf0dc30.png", null, null, 6, null), obj, 0, 2, null).h(obj2, new com.tencent.qqnt.graytips.action.j(), 3), "SVIP\u4f1a\u5458\u53ef\u5f00\u542f\u8bed\u97f3\u81ea\u52a8\u8f6c\u6587\u5b57\uff0c\u9a6c\u4e0a\u5f00\u542f".subSequence(21, 21).toString(), 0, 2, null).m();
        QRouteApi api = QRoute.api(INtGrayTipApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(INtGrayTipApi::class.java)");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
        INtGrayTipApi.a.a((INtGrayTipApi) api, peekAppRuntime, m3, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String buildExperienceQualificationKey(String uin, int privilegeType) {
        return "vip_perception_key_experience_qualification_" + privilegeType + "_" + uin;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String buildExpiredNotifyKey(int privilegeType) {
        return KEY_EXPIRED_NOTIFY_NEXT_REQ_TIME + selfUin() + "_" + privilegeType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String buildGroupKeyWordKey() {
        return KEY_VAS_GROUP_KEY_WORD_GRAY_TIP + selfUin();
    }

    private final String buildPTTGuideKey() {
        return KEY_HAVE_SHOW_OPEN_SVIP_GRAY_MSG + selfUin();
    }

    private final String buildPtt30sGuideKey() {
        return KEY_HAVE_RECEIVE_30s_VOICE + selfUin();
    }

    private final void expireNotice(List<Integer> privilegeTypeList, int aioType, String targetUin, VipPerceptionRequestResult<gu4.c> callback) {
        n.f310567a.n(privilegeTypeList, aioType, targetUin, callback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getAioType(int chatType) {
        if (chatType == 1) {
            return 1;
        }
        if (chatType == 2) {
            return 2;
        }
        return 0;
    }

    private final long getLastExpiredNotifyTime(int privilegeType) {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        return from.decodeLong(buildExpiredNotifyKey(privilegeType), 0L);
    }

    private final Pair<Integer, Integer> getSVIPLocalInsertConfig() {
        JSONObject json = svipLocalInsertConfig.getJson();
        return new Pair<>(Integer.valueOf(json.optInt("interval_hour", 168)), Integer.valueOf(json.optInt("max_count", 3)));
    }

    private final long getSelfExperienceQualificationTime(int privilegeType) {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        return from.decodeLong(buildExperienceQualificationKey(selfUin(), privilegeType), 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void guide(int privilegeType, int aioType, String targetUin, VipPerceptionRequestResult<gu4.i> callback) {
        n.f310567a.v(privilegeType, aioType, targetUin, callback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sVipExpiredCheck$lambda$1(VipPerceptionImpl this$0, int i3, long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        ArrayList arrayList = new ArrayList();
        if (com.tencent.mobileqq.activity.aio.item.m.f179515e) {
            long lastExpiredNotifyTime = this$0.getLastExpiredNotifyTime(2);
            if (lastExpiredNotifyTime <= 0 || currentTimeMillis >= lastExpiredNotifyTime) {
                arrayList.add(2);
                this$0.userLog("sVipExpiredCheck add VOICE_TRANSFORM peerUin: " + j3);
            }
        }
        if (this$0.getAioType(i3) == 2) {
            IChatSettingForTroopApi iChatSettingForTroopApi = (IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class);
            StringBuilder sb5 = new StringBuilder();
            sb5.append(j3);
            if (iChatSettingForTroopApi.hasKeywords(sb5.toString()) && !VasUtil.getSignedService(MobileQQ.sMobileQQ.peekAppRuntime()).getVipStatus().isSVip()) {
                long lastExpiredNotifyTime2 = this$0.getLastExpiredNotifyTime(1);
                if (lastExpiredNotifyTime2 <= 0 || currentTimeMillis >= lastExpiredNotifyTime2) {
                    arrayList.add(1);
                    this$0.userLog("sVipExpiredCheck add GROUP_KEYWORD peerUin: " + j3);
                }
            }
        }
        if (!arrayList.isEmpty()) {
            int aioType = this$0.getAioType(i3);
            StringBuilder sb6 = new StringBuilder();
            sb6.append(j3);
            this$0.expireNotice(arrayList, aioType, sb6.toString(), new e(arrayList, this$0));
            return;
        }
        QLog.i(TAG, 1, "expired notify \u65f6\u95f4\u672a\u5230,\u6682\u4e0d\u8bf7\u6c42");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String selfUin() {
        String str;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentAccountUin();
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    private final boolean skippedUin(long uin) {
        String stringData = svipLocalTipsSkip.getStringData(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        try {
            userLog("skippedUin config: " + stringData);
            JSONArray jSONArray = new JSONArray(stringData);
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                if (uin == jSONArray.getLong(i3)) {
                    userLog("skippedUin " + uin + " !");
                    return true;
                }
            }
        } catch (JSONException unused) {
        }
        return false;
    }

    private final void tryTriggerGrayTip(final int guideFlagType, final boolean isLocal, Function1<? super Function0<Unit>, Unit> postGuideGrayTip) {
        int i3;
        final String buildPTTGuideKey = buildPTTGuideKey();
        Integer num = requestFlagMap.get(buildPTTGuideKey);
        if (num != null) {
            i3 = num.intValue();
        } else {
            i3 = 0;
        }
        if ((i3 & 16) > 0) {
            QLog.i(TAG, 1, "tryTriggerGrayTip cache memory " + i3);
            return;
        }
        if ((i3 & guideFlagType) > 0) {
            QLog.i(TAG, 1, "tryTriggerGrayTip cache memory " + i3);
            return;
        }
        final MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        if (isLocal) {
            int decodeInt = from.decodeInt(buildPTTGuideKey, 0);
            if ((decodeInt & 16) > 0) {
                QLog.i(TAG, 1, "tryTriggerGrayTip long cache file " + decodeInt);
                return;
            }
            if ((decodeInt & 1) > 0) {
                QLog.i(TAG, 1, "tryTriggerGrayTip 30s cache file " + decodeInt);
                return;
            }
        }
        final int i16 = i3;
        postGuideGrayTip.invoke(new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.perception.api.impl.VipPerceptionImpl$tryTriggerGrayTip$call$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                int i17 = i16 | guideFlagType;
                VipPerceptionImpl.requestFlagMap.put(buildPTTGuideKey, Integer.valueOf(i17));
                if (isLocal) {
                    from.encodeInt(buildPTTGuideKey, i17);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void userLog(String msg2) {
        QLog.i(TAG, 1, msg2);
    }

    @Override // com.tencent.mobileqq.vas.perception.api.IVipPerception
    public boolean checkInExperience(@NotNull String uin, int privilegeType) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        long selfExperienceQualificationTime = getSelfExperienceQualificationTime(privilegeType);
        if (selfExperienceQualificationTime <= 0 || selfExperienceQualificationTime <= System.currentTimeMillis() / 1000) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.vas.perception.api.IVipPerception
    public void debugClearCache() {
        List split$default;
        requestFlagMap.clear();
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        from.encodeInt(buildPTTGuideKey(), 0);
        from.encodeLong(buildExperienceQualificationKey(selfUin(), 2), 0L);
        from.encodeLong(buildExperienceQualificationKey(selfUin(), 1), 0L);
        String cacheKey = from.decodeString(KEY_DEBUG_CACHE_EXPIRE_KEY, "");
        if (TextUtils.isEmpty(cacheKey)) {
            Intrinsics.checkNotNullExpressionValue(cacheKey, "cacheKey");
            split$default = StringsKt__StringsKt.split$default((CharSequence) cacheKey, new String[]{","}, false, 0, 6, (Object) null);
            Iterator it = split$default.iterator();
            while (it.hasNext()) {
                from.encodeLong((String) it.next(), 0L);
            }
        }
        from.encodeBool(buildPtt30sGuideKey(), false);
    }

    @Override // com.tencent.mobileqq.vas.perception.api.IVipPerception
    public void getUserExperience(int privilegeType, @Nullable VipPerceptionRequestResult<o> callback) {
        n.f310567a.r(privilegeType, new b(privilegeType, callback));
    }

    @Override // com.tencent.mobileqq.vas.perception.api.IVipPerception
    public void groupKeyWord(int chatType, long peerUin) {
        int i3;
        IChatSettingForTroopApi iChatSettingForTroopApi = (IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(peerUin);
        if (iChatSettingForTroopApi.hasKeywords(sb5.toString())) {
            return;
        }
        Integer num = requestFlagMap.get(buildGroupKeyWordKey());
        if (num != null) {
            i3 = num.intValue();
        } else {
            i3 = 0;
        }
        if (i3 == 1) {
            return;
        }
        int aioType = getAioType(chatType);
        StringBuilder sb6 = new StringBuilder();
        sb6.append(peerUin);
        guide(1, aioType, sb6.toString(), new c());
    }

    @Override // com.tencent.mobileqq.vas.perception.api.IVipPerception
    public void longClickVoiceMsg(int chatType, @NotNull String peerUid, long peerUin, long senderUin) {
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        if (getAioType(chatType) == 0) {
            userLog("longClickVoiceMsg \u804a\u5929\u7c7b\u578b\u4e0d\u652f\u6301 chatType:" + chatType);
            return;
        }
        if (com.tencent.mobileqq.activity.aio.item.m.f179515e) {
            userLog("longClickVoiceMsg \u672c\u5730\u5df2\u5f00\u542f\u8bed\u97f3\u81ea\u52a8\u8f6c\u6587\u5b57");
            return;
        }
        if (!skippedUin(peerUin) && !skippedUin(senderUin)) {
            if (VasUtil.getSignedService(MobileQQ.sMobileQQ.peekAppRuntime()).getVipStatus().isSVip()) {
                if (chatType == 2) {
                    userLog("[longClickVoiceMsg] Do not insert a graytips in the QQ group scenario.");
                    return;
                } else {
                    userLog("try addLocalPTTGuideGrayTip GUIDE_FLAG_LONG_CLICK");
                    addLocalPTTGuideGrayTipOnWeakLimit(peerUid, chatType, 16);
                    return;
                }
            }
            userLog("try addCommonPttGuideGrayTip GUIDE_FLAG_LONG_CLICK");
            StringBuilder sb5 = new StringBuilder();
            sb5.append(peerUin);
            addCommonPttGuideGrayTip(sb5.toString(), chatType, 16);
        }
    }

    @Override // com.tencent.mobileqq.vas.perception.api.IVipPerception
    public void obtainExperience(int privilegeType, @Nullable VipPerceptionRequestResult<gu4.m> callback) {
        n.f310567a.z(privilegeType, new d(privilegeType, callback));
    }

    @Override // com.tencent.mobileqq.vas.perception.api.IVipPerception
    public void sVipExpiredCheck(final int chatType, final long peerUin) {
        if (getAioType(chatType) == 0) {
            userLog("sVipExpiredCheck \u804a\u5929\u7c7b\u578b\u4e0d\u652f\u6301 chatType:" + chatType);
            return;
        }
        if (VasUtil.getSignedService(MobileQQ.sMobileQQ.peekAppRuntime()).getVipStatus().isSVip()) {
            userLog("sVipExpiredCheck svip \u4e0d\u8bf7\u6c42");
        } else {
            y13.d.a(1000L, new Runnable() { // from class: com.tencent.mobileqq.vas.perception.api.impl.a
                @Override // java.lang.Runnable
                public final void run() {
                    VipPerceptionImpl.sVipExpiredCheck$lambda$1(VipPerceptionImpl.this, chatType, peerUin);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.vas.perception.api.IVipPerception
    public void voiceMsg30s(int chatType, @NotNull String peerUid, long peerUin, long senderUin) {
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        if (getAioType(chatType) == 0) {
            userLog("voiceMsg30s \u804a\u5929\u7c7b\u578b\u4e0d\u652f\u6301 chatType:" + chatType);
            return;
        }
        if (com.tencent.mobileqq.activity.aio.item.m.f179515e) {
            userLog("voiceMsg30s \u672c\u5730\u5df2\u5f00\u542f\u8bed\u97f3\u81ea\u52a8\u8f6c\u6587\u5b57");
            return;
        }
        if (!skippedUin(peerUin) && !skippedUin(senderUin)) {
            if (VasUtil.getSignedService(MobileQQ.sMobileQQ.peekAppRuntime()).getVipStatus().isSVip()) {
                if (chatType == 2) {
                    userLog("[voiceMsg30s] Do not insert a graytips in the QQ group scenario. ");
                    return;
                } else {
                    addLocalPTTGuideGrayTip(peerUid, chatType, 1);
                    return;
                }
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(peerUin);
            addCommonPttGuideGrayTip(sb5.toString(), chatType, 1);
        }
    }
}
