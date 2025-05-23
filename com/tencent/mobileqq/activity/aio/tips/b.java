package com.tencent.mobileqq.activity.aio.tips;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.helper.bd;
import java.util.HashSet;
import java.util.Set;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b implements f, bd, View.OnClickListener, Handler.Callback {
    private static final String E = HardCodeUtil.qqStr(R.string.k5k);
    private static final String F = HardCodeUtil.qqStr(R.string.k5l);
    private Handler C;
    private QidianManager D;

    /* renamed from: d, reason: collision with root package name */
    private String f180097d;

    /* renamed from: e, reason: collision with root package name */
    private String f180098e;

    /* renamed from: f, reason: collision with root package name */
    private String f180099f;

    /* renamed from: h, reason: collision with root package name */
    private Set<String> f180100h;

    /* renamed from: i, reason: collision with root package name */
    private Context f180101i;

    /* renamed from: m, reason: collision with root package name */
    private String f180102m;

    public static void c() {
        SharedPreferences.Editor edit = SharedPreferencesProxyManager.getInstance().getProxy("qidian_sp", 0).edit();
        edit.remove("sp_c2b_tip_content");
        edit.remove("sp_c2b_tip_url");
        edit.remove("sp_c2b_tip_highlight");
        edit.remove("sp_c2b_tip_is_show");
        edit.remove("sp_c2b_tip_hide_time");
        edit.apply();
    }

    public static boolean d(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!"lawtip".equals(jSONObject.getString("type"))) {
                return false;
            }
            SharedPreferences.Editor edit = SharedPreferencesProxyManager.getInstance().getProxy("qidian_sp", 0).edit();
            edit.putString("sp_c2b_tip_content", jSONObject.getString("content"));
            edit.putString("sp_c2b_tip_url", jSONObject.getString("url"));
            edit.putString("sp_c2b_tip_highlight", jSONObject.getString("highlight"));
            edit.putInt("sp_c2b_tip_is_show", jSONObject.getInt("show"));
            edit.putInt("sp_c2b_tip_hide_time", jSONObject.getInt("hideTime"));
            edit.apply();
            return true;
        } catch (JSONException e16) {
            e16.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.d("C2BTipsBar", 2, "parse config error:" + e16.toString());
            }
            return false;
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.tips.f
    public View a(Object... objArr) {
        int indexOf;
        View inflate = LayoutInflater.from(this.f180101i).inflate(R.layout.f167629ca, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.f164210ng);
        SpannableString spannableString = new SpannableString(this.f180098e);
        int i3 = 0;
        while (i3 < this.f180098e.length() && (indexOf = this.f180098e.indexOf(this.f180099f, i3)) >= 0) {
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#12b7f5")), indexOf, this.f180099f.length() + indexOf, 33);
            i3 = indexOf + this.f180099f.length();
        }
        textView.setText(spannableString);
        inflate.setOnClickListener(this);
        inflate.findViewById(R.id.f164209nf).setOnClickListener(this);
        return inflate;
    }

    @Override // com.tencent.qqnt.aio.helper.bd
    public int b() {
        return 0;
    }

    @Override // com.tencent.qqnt.aio.helper.bd
    @NonNull
    public View getView() {
        return a(new Object[0]);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i3 = message.what;
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.f164208ne) {
            Intent intent = new Intent(this.f180101i, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", this.f180097d);
            intent.putExtra("hide_operation_bar", true);
            this.f180101i.startActivity(intent);
            ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00899", "Qidian", this.f180102m, "0X8009788", "ClickLawTip", 1, 0, String.valueOf(NetConnInfoCenter.getServerTime()), this.D.s(this.f180102m), AppSetting.f99551k, "");
        } else if (id5 == R.id.f164209nf) {
            HashSet hashSet = new HashSet(this.f180100h);
            hashSet.add(this.f180102m);
            SharedPreferences.Editor edit = SharedPreferencesProxyManager.getInstance().getProxy("qidian_sp", 0).edit();
            edit.putStringSet("sp_c2b_tip_uins_shown", hashSet);
            edit.apply();
            this.f180100h = hashSet;
            this.C.removeMessages(1);
            ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00899", "Qidian", this.f180102m, "0X8009789", "CloseLawTip", 1, 0, String.valueOf(NetConnInfoCenter.getServerTime()), this.D.s(this.f180102m), AppSetting.f99551k, "");
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
