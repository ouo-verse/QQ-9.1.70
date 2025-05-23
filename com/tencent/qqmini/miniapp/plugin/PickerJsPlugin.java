package com.tencent.qqmini.miniapp.plugin;

import android.text.TextUtils;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderConstant;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.qqmini.miniapp.util.DateUtils;
import com.tencent.qqmini.miniapp.widget.DatePickerView;
import com.tencent.qqmini.miniapp.widget.MutiPickerView;
import com.tencent.qqmini.miniapp.widget.PickerView;
import com.tencent.qqmini.miniapp.widget.TimePickerView;
import com.tencent.qqmini.sdk.action.PageAction;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.utils.JSONUtil;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
/* loaded from: classes23.dex */
public class PickerJsPlugin extends BaseJsPlugin {
    private static final String TAG = "PickerJsPlugin";
    private MutiPickerView mutiPickerView;

    private void showDatePicker(final RequestEvent requestEvent, final JSONObject jSONObject, String str, final String str2) {
        final Date smartDateByTime = DateUtils.getSmartDateByTime(str);
        if (smartDateByTime == null) {
            requestEvent.fail();
        } else {
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.plugin.PickerJsPlugin.4
                @Override // java.lang.Runnable
                public void run() {
                    DatePickerView datePickerView = new DatePickerView(((BaseJsPlugin) PickerJsPlugin.this).mMiniAppContext.getAttachActivity());
                    int yearByDateStr = DateUtils.getYearByDateStr(smartDateByTime);
                    int monthByDateStr = DateUtils.getMonthByDateStr(smartDateByTime);
                    int dayByDateStr = DateUtils.getDayByDateStr(smartDateByTime);
                    datePickerView.init(yearByDateStr, monthByDateStr, dayByDateStr, new DatePickerView.OnConfirmListener() { // from class: com.tencent.qqmini.miniapp.plugin.PickerJsPlugin.4.1
                        @Override // com.tencent.qqmini.miniapp.widget.DatePickerView.OnConfirmListener
                        public void onDateCancel() {
                            try {
                                requestEvent.cancel();
                            } catch (Exception e16) {
                                QMLog.e(PickerJsPlugin.TAG, "showDatePickerView onDateCancel error.", e16);
                                requestEvent.fail();
                            }
                        }

                        @Override // com.tencent.qqmini.miniapp.widget.DatePickerView.OnConfirmListener
                        public void onDateConfirm(String str3, String str4, String str5) {
                            String str6;
                            try {
                                JSONObject jSONObject2 = new JSONObject();
                                if (TextUtils.isEmpty(str2)) {
                                    str6 = str3 + "-" + str4 + "-" + str5;
                                } else if ("year".equals(str2)) {
                                    str6 = str3 + "";
                                } else if ("month".equals(str2)) {
                                    str6 = str3 + "-" + str4;
                                } else {
                                    str6 = str3 + "-" + str4 + "-" + str5;
                                }
                                jSONObject2.put("value", str6);
                                requestEvent.ok(jSONObject2);
                            } catch (JSONException e16) {
                                QMLog.e(PickerJsPlugin.TAG, "showDatePickerView onDateConfirm error.", e16);
                                requestEvent.fail();
                            }
                        }
                    });
                    String optString = jSONObject.optString("start");
                    if (!TextUtils.isEmpty(optString)) {
                        datePickerView.setMinDate(DateUtils.dateToLong(optString));
                    }
                    String optString2 = jSONObject.optString("end");
                    if (!TextUtils.isEmpty(optString2)) {
                        datePickerView.setMaxDate(DateUtils.dateToLong(optString2));
                    }
                    datePickerView.updateDate(yearByDateStr, monthByDateStr, dayByDateStr);
                    PickerJsPlugin.this.updateDataPickerFields(datePickerView, str2);
                    datePickerView.show();
                }
            });
        }
    }

    private void showTimePicker(final RequestEvent requestEvent, final JSONObject jSONObject, String str) {
        final Date timeByStrTime = DateUtils.getTimeByStrTime(str);
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.plugin.PickerJsPlugin.3
            @Override // java.lang.Runnable
            public void run() {
                TimePickerView timePickerView = new TimePickerView(((BaseJsPlugin) PickerJsPlugin.this).mMiniAppContext.getAttachActivity());
                timePickerView.init(DateUtils.getHour(timeByStrTime), DateUtils.getMinute(timeByStrTime), new TimePickerView.OnConfirmListener() { // from class: com.tencent.qqmini.miniapp.plugin.PickerJsPlugin.3.1
                    @Override // com.tencent.qqmini.miniapp.widget.TimePickerView.OnConfirmListener
                    public void onTimeCancel() {
                        try {
                            requestEvent.cancel();
                        } catch (Exception e16) {
                            QMLog.e(PickerJsPlugin.TAG, "showDatePickerView onTimeCancel error.", e16);
                        }
                    }

                    @Override // com.tencent.qqmini.miniapp.widget.TimePickerView.OnConfirmListener
                    public void onTimeConfirm(String str2, String str3) {
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("value", str2 + ":" + str3);
                            requestEvent.ok(jSONObject2);
                        } catch (JSONException e16) {
                            QMLog.e(PickerJsPlugin.TAG, "showDatePickerView onTimeConfirm error.", e16);
                        }
                    }
                });
                timePickerView.setIs24HourView(true);
                String optString = jSONObject.optString("start");
                if (!TextUtils.isEmpty(optString)) {
                    Date timeByStrTime2 = DateUtils.getTimeByStrTime(optString);
                    timePickerView.setHourMinValue(DateUtils.getHour(timeByStrTime2));
                    timePickerView.setMinuteMinValue(DateUtils.getMinute(timeByStrTime2));
                }
                String optString2 = jSONObject.optString("end");
                if (!TextUtils.isEmpty(optString2)) {
                    Date timeByStrTime3 = DateUtils.getTimeByStrTime(optString2);
                    timePickerView.setHourMaxValue(DateUtils.getHour(timeByStrTime3));
                    timePickerView.setMinuteMaxValue(DateUtils.getMinute(timeByStrTime3));
                }
                timePickerView.show();
            }
        });
    }

    @JsEvent({com.tencent.luggage.wxa.zf.f.NAME})
    public void handleShowDatePickerView(RequestEvent requestEvent) {
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            JSONObject optJSONObject = jSONObject.optJSONObject(DownloaderConstant.KEY_RANGE);
            String optString = jSONObject.optString("current");
            if (TextUtils.isEmpty(optString)) {
                Calendar calendar = Calendar.getInstance();
                optString = calendar.get(1) + "-" + (calendar.get(2) + 1) + "" + calendar.get(5);
            }
            String optString2 = jSONObject.optString("mode");
            String optString3 = jSONObject.optString("fields");
            if ("date".equals(optString2)) {
                showDatePicker(requestEvent, optJSONObject, optString, optString3);
            } else if ("time".equals(optString2)) {
                showTimePicker(requestEvent, optJSONObject, optString);
            }
        } catch (JSONException e16) {
            QMLog.e(TAG, "showDatePickerView error.", e16);
            requestEvent.fail();
        }
    }

    @JsEvent({"showMultiPickerView"})
    public void handleShowMultiPickerView(final RequestEvent requestEvent) {
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            final int[] jsonArrayToIntArray = JSONUtil.jsonArrayToIntArray(jSONObject.optJSONArray("current"));
            final String[][] jsonArrayToMutiStringArray = JSONUtil.jsonArrayToMutiStringArray(jSONObject, HippyControllerProps.ARRAY);
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.plugin.PickerJsPlugin.2
                @Override // java.lang.Runnable
                public void run() {
                    if (PickerJsPlugin.this.mutiPickerView == null) {
                        PickerJsPlugin.this.mutiPickerView = new MutiPickerView(((BaseJsPlugin) PickerJsPlugin.this).mMiniAppContext.getAttachActivity());
                    }
                    PickerJsPlugin.this.mutiPickerView.setDisplayedValues(jsonArrayToMutiStringArray);
                    PickerJsPlugin.this.mutiPickerView.setCurrentIndex(jsonArrayToIntArray);
                    PickerJsPlugin.this.mutiPickerView.setOnConfirmListener(new MutiPickerView.OnConfirmListener() { // from class: com.tencent.qqmini.miniapp.plugin.PickerJsPlugin.2.1
                        @Override // com.tencent.qqmini.miniapp.widget.MutiPickerView.OnConfirmListener
                        public void onValCancel() {
                            try {
                                requestEvent.cancel(new JSONObject());
                            } catch (Exception e16) {
                                QMLog.e(PickerJsPlugin.TAG, "showMultiPickerView error.", e16);
                            }
                            if (PickerJsPlugin.this.mutiPickerView != null) {
                                PickerJsPlugin.this.mutiPickerView = null;
                            }
                        }

                        @Override // com.tencent.qqmini.miniapp.widget.MutiPickerView.OnConfirmListener
                        public void onValChange(int i3, int i16) {
                            requestEvent.jsService.evaluateSubscribeJS("onMultiPickerViewChange", String.format("{\"column\":%d,\"current\":%d}", Integer.valueOf(i3), Integer.valueOf(i16)), PageAction.obtain(((BaseJsPlugin) PickerJsPlugin.this).mMiniAppContext).getPageId());
                        }

                        @Override // com.tencent.qqmini.miniapp.widget.MutiPickerView.OnConfirmListener
                        public void onValConfirm(int[] iArr) {
                            try {
                                JSONObject jSONObject2 = new JSONObject();
                                JSONArray jSONArray = new JSONArray();
                                for (int i3 : iArr) {
                                    jSONArray.put(i3);
                                }
                                jSONObject2.put("current", jSONArray);
                                requestEvent.ok(jSONObject2);
                            } catch (JSONException e16) {
                                QMLog.e(PickerJsPlugin.TAG, "showMultiPickerView error.", e16);
                            }
                            if (PickerJsPlugin.this.mutiPickerView != null) {
                                PickerJsPlugin.this.mutiPickerView = null;
                            }
                        }
                    });
                    PickerJsPlugin.this.mutiPickerView.show();
                }
            });
        } catch (JSONException e16) {
            QMLog.e(TAG, "showMultiPickerView error.", e16);
            requestEvent.fail();
        }
    }

    @JsEvent({"showPickerView"})
    public void handleShowPickerView(final RequestEvent requestEvent) {
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            final JSONArray optJSONArray = jSONObject.optJSONArray(HippyControllerProps.ARRAY);
            final int optInt = jSONObject.optInt("current", 0);
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.plugin.PickerJsPlugin.1
                @Override // java.lang.Runnable
                public void run() {
                    PickerView pickerView = new PickerView(((BaseJsPlugin) PickerJsPlugin.this).mMiniAppContext.getAttachActivity());
                    String[] jsonArrayToStringArray = JSONUtil.jsonArrayToStringArray(optJSONArray);
                    if (jsonArrayToStringArray != null && jsonArrayToStringArray.length > 0) {
                        pickerView.setDisplayedValues(jsonArrayToStringArray);
                        pickerView.setMinValue(0);
                        pickerView.setMaxValues(jsonArrayToStringArray.length - 1);
                        pickerView.setValue(optInt);
                        pickerView.init(optInt, new PickerView.OnConfirmListener() { // from class: com.tencent.qqmini.miniapp.plugin.PickerJsPlugin.1.1
                            @Override // com.tencent.qqmini.miniapp.widget.PickerView.OnConfirmListener
                            public void onValCancel() {
                                try {
                                    requestEvent.cancel(new JSONObject());
                                } catch (Exception e16) {
                                    QMLog.e(PickerJsPlugin.TAG, "showPickerView error.", e16);
                                }
                            }

                            @Override // com.tencent.qqmini.miniapp.widget.PickerView.OnConfirmListener
                            public void onValConfirm(int i3) {
                                try {
                                    JSONObject jSONObject2 = new JSONObject();
                                    jSONObject2.put("index", i3);
                                    requestEvent.ok(jSONObject2);
                                } catch (JSONException e16) {
                                    QMLog.e(PickerJsPlugin.TAG, "showPickerView error.", e16);
                                }
                            }
                        });
                    }
                    pickerView.show();
                }
            });
        } catch (JSONException e16) {
            QMLog.e(TAG, "showPickerView error.", e16);
            requestEvent.fail();
        }
    }

    @JsEvent({"updateMultiPickerView"})
    public void handleUpdateMultiPickerView(final RequestEvent requestEvent) {
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            final int optInt = jSONObject.optInt("column");
            final int optInt2 = jSONObject.optInt("current");
            final JSONArray optJSONArray = jSONObject.optJSONArray(HippyControllerProps.ARRAY);
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.plugin.PickerJsPlugin.5
                @Override // java.lang.Runnable
                public void run() {
                    if (PickerJsPlugin.this.mutiPickerView != null) {
                        PickerJsPlugin.this.mutiPickerView.setDisplayedValues(optInt, optInt2, JSONUtil.jsonArrayToStringArray(optJSONArray));
                        requestEvent.ok();
                    }
                }
            });
        } catch (Exception e16) {
            QMLog.e(TAG, "updateMultiPickerView error.", e16);
            requestEvent.fail();
        }
    }

    protected void updateDataPickerFields(DatePickerView datePickerView, String str) {
        if (datePickerView == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            datePickerView.setYearVisible(0);
            datePickerView.setMonthOfYearVisible(0);
            datePickerView.setDayOfMonthVisible(0);
            return;
        }
        if (str.equals("year")) {
            datePickerView.setYearVisible(0);
            datePickerView.setMonthOfYearVisible(8);
            datePickerView.setDayOfMonthVisible(8);
        } else if (str.equals("month")) {
            datePickerView.setYearVisible(0);
            datePickerView.setMonthOfYearVisible(0);
            datePickerView.setDayOfMonthVisible(8);
        } else if (str.equals("day")) {
            datePickerView.setYearVisible(0);
            datePickerView.setMonthOfYearVisible(0);
            datePickerView.setDayOfMonthVisible(0);
        }
    }
}
