package ka1;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.colornote.settings.h;
import com.tencent.mobileqq.statistics.ReportController;
import cooperation.qqfav.QfavHelper;
import cooperation.qqfav.QfavUtil;
import cooperation.qqfav.d;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b implements h {
    @Override // com.tencent.mobileqq.colornote.settings.h
    public void a(View view, int i3) {
        Context context = view.getContext();
        boolean z16 = true;
        if (context instanceof BaseActivity) {
            z16 = true ^ ((BaseActivity) context).isInMultiWindow();
        }
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        QfavHelper.i((Activity) context, qQAppInterface.getAccount(), null, -1, z16);
        d.g(qQAppInterface, 6, 0);
        QfavUtil.O(qQAppInterface.getCurrentAccountUin());
        ReportController.o(null, "dc00898", "", "", "0X800AA81", "0X800AA81", 2, 0, "", "", "", "");
    }

    @Override // com.tencent.mobileqq.colornote.settings.h
    public String getTitle() {
        return ((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).getApp().getResources().getString(R.string.b4t);
    }

    @Override // com.tencent.mobileqq.colornote.settings.h
    public int getType() {
        return android.R.dimen.app_icon_size;
    }
}
