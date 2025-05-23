package com.tencent.mobileqq.robotchat;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes18.dex */
public class RobotChatTipLayout extends RelativeLayout implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private TextView f282433d;

    /* renamed from: e, reason: collision with root package name */
    private WeakReference<a> f282434e;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface a {
        void a(RobotChatTipLayout robotChatTipLayout);
    }

    public RobotChatTipLayout(Context context) {
        super(context);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        WeakReference<a> weakReference = this.f282434e;
        if (weakReference != null && (aVar = weakReference.get()) != null) {
            aVar.a(this);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setRobotName(String str) {
        int indexOf;
        if (TextUtils.isEmpty(str)) {
            str = getResources().getString(R.string.vqn);
        }
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        String str2 = null;
        if (runtime != null && (runtime instanceof QQAppInterface)) {
            String robotWarning = ((ITroopRobotService) ((QQAppInterface) runtime).getRuntimeService(ITroopRobotService.class, "all")).getRobotWarning();
            if (!TextUtils.isEmpty(robotWarning)) {
                try {
                    str2 = robotWarning.replace("[name]", "%1$s");
                } catch (Exception e16) {
                    QLog.e("RobotChatTipLayout", 2, "setRobotName exception: " + e16);
                }
            } else {
                str2 = robotWarning;
            }
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = getResources().getString(R.string.vqj);
        }
        String format = String.format(str2, str);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(format) || (indexOf = format.indexOf(str, 4)) < 0) {
            return;
        }
        SpannableString spannableString = new SpannableString(format);
        spannableString.setSpan(new ForegroundColorSpan(-11692801), indexOf, str.length() + indexOf, 33);
        TextView textView = this.f282433d;
        if (textView != null) {
            textView.setText(spannableString);
        }
        setVisibility(0);
    }
}
