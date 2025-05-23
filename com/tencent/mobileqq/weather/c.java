package com.tencent.mobileqq.weather;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.jungle.weather.proto.WeatherReportInfo$Alarm;
import com.tencent.jungle.weather.proto.WeatherReportInfo$GetWeatherByLbsReq;
import com.tencent.jungle.weather.proto.WeatherReportInfo$GetWeatherByLbsRsp;
import com.tencent.jungle.weather.proto.WeatherReportInfo$WeatherDisplay;
import com.tencent.jungle.weather.proto.WeatherReportInfo$WeatherDisplayUp;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.weather.api.impl.WeatherRuntimeServiceImpl;
import com.tencent.mobileqq.weather.proto.WeatherPush$PushRequest;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import mqq.app.MSFServlet;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes20.dex */
public class c extends MSFServlet {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void a(AppInterface appInterface, int i3, int i16, int i17) {
        NewIntent newIntent = new NewIntent(MobileQQ.sMobileQQ, c.class);
        newIntent.putExtra("cmd", "QQWeatherReport.getWeatherByLbs");
        newIntent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, 8888);
        newIntent.putExtra("latitide", i3);
        newIntent.putExtra("longtitude", i16);
        newIntent.putExtra("adcode", i17);
        appInterface.startServlet(newIntent);
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent, (Object) fromServiceMsg);
            return;
        }
        if (!"QQWeatherReport.getWeatherByLbs".equals(fromServiceMsg.getServiceCmd())) {
            return;
        }
        boolean isSuccess = fromServiceMsg.isSuccess();
        Bundle bundle = new Bundle();
        bundle.putAll(intent.getExtras());
        if (QLog.isColorLevel()) {
            QLog.d("WeatherServlet", 2, "WeatherServlet onReceive isSucess1:" + isSuccess);
        }
        if (isSuccess) {
            try {
                byte[] bArr = new byte[r13.getInt() - 4];
                ByteBuffer.wrap(fromServiceMsg.getWupBuffer()).get(bArr);
                WeatherReportInfo$GetWeatherByLbsRsp weatherReportInfo$GetWeatherByLbsRsp = new WeatherReportInfo$GetWeatherByLbsRsp();
                weatherReportInfo$GetWeatherByLbsRsp.mergeFrom(bArr);
                if (weatherReportInfo$GetWeatherByLbsRsp.pbRspMsgHead.uint32_result.get() == 0) {
                    isSuccess = true;
                } else {
                    isSuccess = false;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("WeatherServlet", 2, "WeatherServlet onReceive isSucess2:" + isSuccess);
                }
                if (isSuccess) {
                    WeatherReportInfo$WeatherDisplay weatherReportInfo$WeatherDisplay = weatherReportInfo$GetWeatherByLbsRsp.weather_display;
                    for (int i3 = 0; i3 < weatherReportInfo$GetWeatherByLbsRsp.weather_display.ups.size(); i3++) {
                        WeatherReportInfo$WeatherDisplayUp weatherReportInfo$WeatherDisplayUp = weatherReportInfo$GetWeatherByLbsRsp.weather_display.ups.get(i3);
                        int i16 = weatherReportInfo$WeatherDisplayUp.theme.get();
                        String str = "drawer_up_type";
                        String str2 = "drawer_up_text";
                        if (i16 == 2) {
                            str = "drawer_up_simple_type";
                            str2 = "drawer_up_simple_text";
                        }
                        if (i16 == 3) {
                            str = "drawer_up_experiment_type";
                            str2 = "drawer_up_experiment_text";
                        }
                        bundle.putInt(str, weatherReportInfo$WeatherDisplayUp.up_type.get());
                        bundle.putString(str2, weatherReportInfo$WeatherDisplayUp.content.get());
                    }
                    bundle.putString("drawer_down_text", weatherReportInfo$WeatherDisplay.down.content.get());
                    bundle.putString("KEY_TEMPER", weatherReportInfo$GetWeatherByLbsRsp.temper.get());
                    bundle.putString("o_wea_code", weatherReportInfo$GetWeatherByLbsRsp.o_wea_code.get());
                    bundle.putString("wea_desc", weatherReportInfo$GetWeatherByLbsRsp.wea_desc.get());
                    bundle.putString("area_info", weatherReportInfo$GetWeatherByLbsRsp.area.city.get() + "-" + weatherReportInfo$GetWeatherByLbsRsp.area.area_name.get());
                    bundle.putInt("adcode", weatherReportInfo$GetWeatherByLbsRsp.area.area_id.get());
                    bundle.putInt("show_flag", weatherReportInfo$GetWeatherByLbsRsp.show_flag.get());
                    int size = weatherReportInfo$GetWeatherByLbsRsp.alarms.get().size();
                    bundle.putInt("drawer_warning_count", size);
                    for (int i17 = 0; i17 < size; i17++) {
                        WeatherReportInfo$Alarm weatherReportInfo$Alarm = weatherReportInfo$GetWeatherByLbsRsp.alarms.get(i17);
                        bundle.putString("drawer_warning_icon_" + i17, weatherReportInfo$Alarm.icon.get());
                        bundle.putString("drawer_warning_name_" + i17, weatherReportInfo$Alarm.name.get());
                        bundle.putString("drawer_warning_color_" + i17, weatherReportInfo$Alarm.color.get());
                        bundle.putString("drawer_warning_level_" + i17, com.tencent.mobileqq.weather.util.b.a(weatherReportInfo$Alarm.level.get()));
                    }
                } else {
                    bundle.putInt("uint32_result", weatherReportInfo$GetWeatherByLbsRsp.pbRspMsgHead.uint32_result.get());
                    bundle.putString("string_err_msg", weatherReportInfo$GetWeatherByLbsRsp.pbRspMsgHead.string_err_msg.get());
                }
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
                z16 = false;
            }
        }
        z16 = isSuccess;
        notifyObserver(intent, intent.getIntExtra(AppConstants.Key.SHARE_REQ_TYPE, 0), z16, bundle, WeatherRuntimeServiceImpl.class);
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        byte[] byteArray;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent, (Object) packet);
            return;
        }
        int intExtra = intent.getIntExtra(AppConstants.Key.SHARE_REQ_TYPE, 0);
        String stringExtra = intent.getStringExtra("cmd");
        int intExtra2 = intent.getIntExtra("adcode", 0);
        if (intExtra != 6666) {
            if (intExtra != 8888) {
                if (intExtra == 9999) {
                    WeatherPush$PushRequest weatherPush$PushRequest = new WeatherPush$PushRequest();
                    weatherPush$PushRequest.adcode.set(intent.getIntExtra("adcode", 0));
                    weatherPush$PushRequest.hideRedPoint.set(intent.getBooleanExtra("hide_red_point", false));
                    weatherPush$PushRequest.uin.set(intent.getLongExtra("uin", 0L));
                    byteArray = weatherPush$PushRequest.toByteArray();
                } else {
                    throw new RuntimeException("Weatherservlet unknow req_type: " + intExtra);
                }
            } else {
                WeatherReportInfo$GetWeatherByLbsReq weatherReportInfo$GetWeatherByLbsReq = new WeatherReportInfo$GetWeatherByLbsReq();
                weatherReportInfo$GetWeatherByLbsReq.lat.set(intent.getIntExtra("latitide", 0));
                weatherReportInfo$GetWeatherByLbsReq.lng.set(intent.getIntExtra("longtitude", 0));
                weatherReportInfo$GetWeatherByLbsReq.adcode_from_mapsdk.set(intExtra2);
                byteArray = weatherReportInfo$GetWeatherByLbsReq.toByteArray();
            }
        } else {
            WeatherReportInfo$GetWeatherByLbsReq weatherReportInfo$GetWeatherByLbsReq2 = new WeatherReportInfo$GetWeatherByLbsReq();
            weatherReportInfo$GetWeatherByLbsReq2.uin.set(intent.getLongExtra("uin", 0L));
            weatherReportInfo$GetWeatherByLbsReq2.adcode_from_mapsdk.set(intExtra2);
            byteArray = weatherReportInfo$GetWeatherByLbsReq2.toByteArray();
        }
        ByteBuffer allocate = ByteBuffer.allocate(byteArray.length + 4);
        allocate.putInt(byteArray.length + 4).put(byteArray);
        packet.setSSOCommand(stringExtra);
        packet.putSendData(allocate.array());
    }
}
