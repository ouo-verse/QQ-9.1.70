package com.tencent.gamematrix.gmcg.sdk.event;

import com.google.gson.JsonSyntaxException;
import com.tencent.gamematrix.gmcg.api.GmCgPlayPushEventListener;
import com.tencent.gamematrix.gmcg.api.constant.GmCgPushEventDefine;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.base.utils.CGJsonUtil;
import com.tencent.gamematrix.gmcg.base.utils.CGStringUtil;
import com.tencent.mobileqq.icgame.api.impl.RoomServiceConstants;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class CGPushEventHelper {
    private final GmCgPlayPushEventListener mPlayPushEventListener;

    public CGPushEventHelper(GmCgPlayPushEventListener gmCgPlayPushEventListener) {
        this.mPlayPushEventListener = gmCgPlayPushEventListener;
    }

    public void onPushEvent(String str) {
        CGLog.i("CGPushEventHelper onPushEvent: " + str);
        if (CGStringUtil.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jsonObjectFromString = CGJsonUtil.getJsonObjectFromString(str);
            if (jsonObjectFromString != null) {
                String stringFromJsonObject = CGJsonUtil.getStringFromJsonObject(jsonObjectFromString, "cmd");
                JSONObject jsonObjectFromString2 = CGJsonUtil.getJsonObjectFromString(CGJsonUtil.getStringFromJsonObject(jsonObjectFromString, "body"));
                if (jsonObjectFromString2 != null) {
                    if (GmCgPushEventDefine.CMD_PUSH_EVENT_TIME_NOT_ENOUGH.equalsIgnoreCase(stringFromJsonObject)) {
                        long longFromJsonObject = CGJsonUtil.getLongFromJsonObject(jsonObjectFromString2, "time", 0L);
                        boolean boolFromJsonObject = CGJsonUtil.getBoolFromJsonObject(jsonObjectFromString2, "needCharge", false);
                        GmCgPlayPushEventListener gmCgPlayPushEventListener = this.mPlayPushEventListener;
                        if (gmCgPlayPushEventListener != null) {
                            gmCgPlayPushEventListener.onGmCgPlayPushEventTimeNotEnough(longFromJsonObject, boolFromJsonObject);
                            return;
                        }
                        return;
                    }
                    if (GmCgPushEventDefine.CMD_PUSH_EVENT_TIME_NOT_ENOUGH_V2.equalsIgnoreCase(stringFromJsonObject)) {
                        long longFromJsonObject2 = CGJsonUtil.getLongFromJsonObject(jsonObjectFromString2, "time", 0L);
                        long longFromJsonObject3 = CGJsonUtil.getLongFromJsonObject(jsonObjectFromString2, "leftTime", 0L);
                        boolean boolFromJsonObject2 = CGJsonUtil.getBoolFromJsonObject(jsonObjectFromString2, "needCharge", false);
                        int intFromJsonObject = CGJsonUtil.getIntFromJsonObject(jsonObjectFromString2, "type", 1);
                        GmCgPlayPushEventListener gmCgPlayPushEventListener2 = this.mPlayPushEventListener;
                        if (gmCgPlayPushEventListener2 != null) {
                            gmCgPlayPushEventListener2.onGmCgPlayPushEventTimeNotEnoughV2(longFromJsonObject2, longFromJsonObject3, boolFromJsonObject2, intFromJsonObject);
                        }
                    }
                    if (GmCgPushEventDefine.CMD_PUSH_EVENT_GAME_RECHARGE_GIVE_TIME.equalsIgnoreCase(stringFromJsonObject)) {
                        String stringFromJsonObject2 = CGJsonUtil.getStringFromJsonObject(jsonObjectFromString2, RoomServiceConstants.PARAMS_GAME_ID, "");
                        int intFromJsonObject2 = CGJsonUtil.getIntFromJsonObject(jsonObjectFromString2, "givetimeh", 0);
                        int intFromJsonObject3 = CGJsonUtil.getIntFromJsonObject(jsonObjectFromString2, "amount", 0);
                        String stringFromJsonObject3 = CGJsonUtil.getStringFromJsonObject(jsonObjectFromString2, "time", "");
                        GmCgPlayPushEventListener gmCgPlayPushEventListener3 = this.mPlayPushEventListener;
                        if (gmCgPlayPushEventListener3 != null) {
                            gmCgPlayPushEventListener3.onGmCgPlayPushEventGameRechargeGiveTime(stringFromJsonObject2, intFromJsonObject2, intFromJsonObject3, stringFromJsonObject3);
                            return;
                        }
                        return;
                    }
                    if ("CMD_GAME_TIME_INFORMATION".equalsIgnoreCase(stringFromJsonObject)) {
                        String stringFromJsonObject4 = CGJsonUtil.getStringFromJsonObject(jsonObjectFromString2, "msg", "");
                        int intFromJsonObject4 = CGJsonUtil.getIntFromJsonObject(jsonObjectFromString2, "left_account_time", 0);
                        int intFromJsonObject5 = CGJsonUtil.getIntFromJsonObject(jsonObjectFromString2, "type", 0);
                        GmCgPlayPushEventListener gmCgPlayPushEventListener4 = this.mPlayPushEventListener;
                        if (gmCgPlayPushEventListener4 != null) {
                            gmCgPlayPushEventListener4.onGmCgGameTimeInfo(intFromJsonObject5, stringFromJsonObject4, intFromJsonObject4);
                            return;
                        }
                        return;
                    }
                    if (GmCgPushEventDefine.CMD_GAME_TIME_CHARGE_INFORMATION.equalsIgnoreCase(stringFromJsonObject)) {
                        String stringFromJsonObject5 = CGJsonUtil.getStringFromJsonObject(jsonObjectFromString2, "msg", "");
                        int intFromJsonObject6 = CGJsonUtil.getIntFromJsonObject(jsonObjectFromString2, "add_time_seconds", 0);
                        String stringFromJsonObject6 = CGJsonUtil.getStringFromJsonObject(jsonObjectFromString2, "start_time", "");
                        String stringFromJsonObject7 = CGJsonUtil.getStringFromJsonObject(jsonObjectFromString2, "start_time", "");
                        int intFromJsonObject7 = CGJsonUtil.getIntFromJsonObject(jsonObjectFromString2, "validity", 0);
                        GmCgPlayPushEventListener gmCgPlayPushEventListener5 = this.mPlayPushEventListener;
                        if (gmCgPlayPushEventListener5 != null) {
                            gmCgPlayPushEventListener5.onGmCgPlayPushEventMcGameRechargeGiveTime(stringFromJsonObject5, intFromJsonObject6, intFromJsonObject7, stringFromJsonObject6, stringFromJsonObject7);
                            return;
                        }
                        return;
                    }
                    if (GmCgPushEventDefine.CMD_PUSH_EVENT_TIME_UPDATE.equalsIgnoreCase(stringFromJsonObject)) {
                        long longFromJsonObject4 = CGJsonUtil.getLongFromJsonObject(jsonObjectFromString2, "left", 0L);
                        GmCgPlayPushEventListener gmCgPlayPushEventListener6 = this.mPlayPushEventListener;
                        if (gmCgPlayPushEventListener6 != null) {
                            gmCgPlayPushEventListener6.onGmCgPlayPushEventTimeUpdate(longFromJsonObject4);
                            return;
                        }
                        return;
                    }
                }
            }
        } catch (JsonSyntaxException unused) {
            CGLog.e("CGPushEventHelper onPushEvent: unknown data syntax");
        }
        GmCgPlayPushEventListener gmCgPlayPushEventListener7 = this.mPlayPushEventListener;
        if (gmCgPlayPushEventListener7 != null) {
            gmCgPlayPushEventListener7.onGmCgPlayPushEventUnknown(str);
        }
    }
}
