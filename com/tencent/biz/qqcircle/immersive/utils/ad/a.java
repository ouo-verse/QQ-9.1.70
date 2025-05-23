package com.tencent.biz.qqcircle.immersive.utils.ad;

import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerP2PParams;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.qcircle.api.IQFSPlayerStrategyApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcircle.api.utils.QCircleVideoDeviceInfoUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.PlatformInfor;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import feedcloud.FeedCloudMeta$CmtBlockAd;
import feedcloud.FeedCloudMeta$StComment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.gdt.access;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b)\u0010*J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u001c\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0006\u0010\u000b\u001a\u00020\tJ \u0010\u0012\u001a\u00020\u00112\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fJ0\u0010\u0015\u001a\u00020\u00112\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fJ\"\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018J\u001c\u0010\u001d\u001a\u0004\u0018\u00010\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\tJ\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eJ\u0012\u0010\"\u001a\u0004\u0018\u00010\u00012\b\u0010!\u001a\u0004\u0018\u00010 J\u0010\u0010%\u001a\u00020\u00112\b\u0010$\u001a\u0004\u0018\u00010#J\u0006\u0010&\u001a\u00020\u0011J\u0006\u0010'\u001a\u00020\u0011J\u0010\u0010(\u001a\u00020\u00112\b\u0010$\u001a\u0004\u0018\u00010#\u00a8\u0006+"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/utils/ad/a;", "", "Landroid/view/ViewGroup;", "viewGroup", "", tl.h.F, "Lorg/json/JSONArray;", "jsonArray", "", "", "e", "f", "Lcom/tencent/gdtad/aditem/GdtAd;", "gdtAd", "heightPx", "", "touchY", "", "b", "currentDuration", "totalDuration", "a", "Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$MultiClickAreaInfo;", "g", "Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;", "adInfo", "Lcom/tencent/biz/richframework/video/rfw/player/RFWPlayerP2PParams;", "c", RemoteHandleConst.PARAM_DEFAULT_VALUE, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ltencent/gdt/qq_ad_get$QQAdGet$DeviceInfo;", "d", "Lfeedcloud/FeedCloudMeta$StComment;", "sourceData", DomainData.DOMAIN_NAME, "Le30/b;", "feedBlockData", "i", "j", "l", "k", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f90082a = new a();

    a() {
    }

    private final Map<String, Integer> e(JSONArray jsonArray) {
        HashMap hashMap = new HashMap();
        int length = jsonArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject jSONObject = jsonArray.getJSONObject(i3);
            String string = jSONObject.getString("key");
            Intrinsics.checkNotNullExpressionValue(string, "jsonObject.getString(\"key\")");
            hashMap.put(string, Integer.valueOf(jSONObject.getInt("value")));
        }
        return hashMap;
    }

    @JvmStatic
    public static final int h(@Nullable ViewGroup viewGroup) {
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            return 1;
        }
        return 0;
    }

    public final boolean a(@Nullable GdtAd gdtAd, int currentDuration, int totalDuration, int heightPx, float touchY) {
        List<qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.MultiClickAreaInfo> list;
        float f16;
        if (gdtAd != null) {
            list = gdtAd.getMultiClickAreaInfo();
        } else {
            list = null;
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        if (totalDuration > 0) {
            f16 = (currentDuration * 100) / totalDuration;
        } else {
            f16 = 0.0f;
        }
        Iterator<qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.MultiClickAreaInfo> it = list.iterator();
        while (true) {
            boolean z16 = false;
            if (!it.hasNext()) {
                return false;
            }
            qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.MultiClickAreaInfo next = it.next();
            int i3 = next.begin_play_percent.get();
            int i16 = next.end_play_percent.get();
            if (touchY >= (1 - (next.click_area_from_bottom.get() / 100.0f)) * heightPx) {
                z16 = true;
            }
            if (f16 > i3 && f16 <= i16 && z16) {
                return true;
            }
        }
    }

    public final boolean b(@Nullable GdtAd gdtAd, int heightPx, float touchY) {
        float f16;
        if (gdtAd != null) {
            f16 = gdtAd.getClickAreaFromBottom() / 100.0f;
        } else {
            f16 = 0.0f;
        }
        if (touchY >= (1 - f16) * heightPx) {
            return true;
        }
        return false;
    }

    @Nullable
    public final RFWPlayerP2PParams c(@Nullable qq_ad_get.QQAdGetRsp.AdInfo adInfo) {
        if (adInfo == null || TextUtils.isEmpty(adInfo.ext_json.get())) {
            return null;
        }
        try {
            JSONArray optJSONArray = new JSONObject(adInfo.ext_json.get()).optJSONArray("exp_map");
            if (optJSONArray == null) {
                return null;
            }
            Map<String, Integer> e16 = e(optJSONArray);
            Integer num = e16.get("119700");
            boolean z16 = false;
            if (num == null) {
                num = 0;
            }
            if (num.intValue() == 1) {
                z16 = true;
            }
            Integer num2 = e16.get("120608");
            if (num2 == null) {
                num2 = -1;
            }
            int intValue = num2.intValue();
            Integer num3 = e16.get("120611");
            if (num3 == null) {
                num3 = -1;
            }
            int intValue2 = num3.intValue();
            Integer num4 = e16.get("120612");
            if (num4 == null) {
                num4 = -1;
            }
            int intValue3 = num4.intValue();
            RFWPlayerP2PParams rFWPlayerP2PParams = new RFWPlayerP2PParams();
            rFWPlayerP2PParams.setEnableP2P(z16);
            rFWPlayerP2PParams.setEnablePCDN(z16);
            rFWPlayerP2PParams.setEmergencyTime(intValue2);
            rFWPlayerP2PParams.setSafePlayTime(intValue3);
            rFWPlayerP2PParams.setSafeTimeForPrePlay(intValue);
            rFWPlayerP2PParams.setEmergencyTimeForPrePlay(intValue);
            return rFWPlayerP2PParams;
        } catch (Exception e17) {
            QLog.e("QFSAdUtils", 1, "getAdPlayerP2PParams failed ,error :", e17);
            return null;
        }
    }

    @Nullable
    public final qq_ad_get.QQAdGet.DeviceInfo d() {
        try {
            GdtDeviceInfoHelper.Result create = GdtDeviceInfoHelper.create(RFWApplication.getApplication(), new GdtDeviceInfoHelper.Params());
            if (create != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("QFSAdUtils", 2, "gdt device info init success");
                }
                create.deviceInfo.av1_flag.set(((IQFSPlayerStrategyApi) QRoute.api(IQFSPlayerStrategyApi.class)).getAV1Flag());
                create.deviceInfo.hw_level.set(QCircleVideoDeviceInfoUtils.getVideoDeviceLevel());
                return create.deviceInfo;
            }
            return null;
        } catch (Exception e16) {
            QLog.e("QFSAdUtils", 1, "Error when get gdt device info", e16);
            return null;
        }
    }

    @NotNull
    public final String f() {
        String str;
        if (SimpleUIUtil.isNowElderMode()) {
            str = PlatformInfor.ELDER_MODE;
        } else {
            str = "default";
        }
        if (((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            return "teenager";
        }
        return str;
    }

    @Nullable
    public final qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.MultiClickAreaInfo g(@Nullable GdtAd gdtAd, int currentDuration, int totalDuration) {
        List<qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.MultiClickAreaInfo> list;
        float f16;
        if (gdtAd != null) {
            list = gdtAd.getMultiClickAreaInfo();
        } else {
            list = null;
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        if (totalDuration > 0) {
            f16 = (currentDuration * 100) / totalDuration;
        } else {
            f16 = 0.0f;
        }
        for (qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.MultiClickAreaInfo multiClickAreaInfo : list) {
            int i3 = multiClickAreaInfo.begin_play_percent.get();
            int i16 = multiClickAreaInfo.end_play_percent.get();
            int i17 = multiClickAreaInfo.click_area_from_bottom.get();
            boolean z16 = true;
            boolean z17 = !TextUtils.isEmpty(multiClickAreaInfo.tips.get());
            if (i17 != 100) {
                z16 = false;
            }
            if (f16 > i3 && f16 <= i16 && z17 && z16) {
                return multiClickAreaInfo;
            }
        }
        return null;
    }

    public final boolean i(@Nullable e30.b feedBlockData) {
        if (feedBlockData == null) {
            return false;
        }
        return Intrinsics.areEqual("personal_layer", feedBlockData.b("feed_source"));
    }

    public final boolean j() {
        return !((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("100751", false);
    }

    public final boolean k(@Nullable e30.b feedBlockData) {
        if (i(feedBlockData) && l()) {
            return true;
        }
        return false;
    }

    public final boolean l() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("100756", false);
    }

    @Nullable
    public final String m(@Nullable qq_ad_get.QQAdGetRsp.AdInfo adInfo, @Nullable String defaultValue) {
        String txt = "";
        if (adInfo != null) {
            for (qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo buttonInfo : adInfo.display_info.button_info.get()) {
                if (buttonInfo.pos.get() == 2) {
                    txt = buttonInfo.txt.get();
                    Intrinsics.checkNotNullExpressionValue(txt, "txt");
                }
            }
        }
        if (!TextUtils.isEmpty(txt)) {
            return txt;
        }
        return defaultValue;
    }

    @Nullable
    public final Object n(@Nullable FeedCloudMeta$StComment sourceData) {
        byte[] bArr;
        PBBytesField pBBytesField;
        ByteStringMicro byteStringMicro;
        if (sourceData != null && sourceData.cmt_block_type.get() != 0 && sourceData.cmt_block_ad != null) {
            try {
                access.AdGetRsp adGetRsp = new access.AdGetRsp();
                FeedCloudMeta$CmtBlockAd feedCloudMeta$CmtBlockAd = sourceData.cmt_block_ad;
                if (feedCloudMeta$CmtBlockAd != null && (pBBytesField = feedCloudMeta$CmtBlockAd.trans_rsp) != null && (byteStringMicro = pBBytesField.get()) != null) {
                    bArr = byteStringMicro.toByteArray();
                } else {
                    bArr = null;
                }
                adGetRsp.mergeFrom(bArr);
                return new GdtAd(adGetRsp.qq_ad_get_rsp.pos_ads_info.get(0).ads_info.get(0));
            } catch (Exception e16) {
                QLog.e("QFSAdUtils", 1, "transCommentToGdtAd failed, error is " + e16);
            }
        }
        return null;
    }
}
