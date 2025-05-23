package mc0;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.StringRes;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.h;
import com.tencent.mobileqq.R;
import com.tencent.richframework.widget.popupwindow.priority.RFWPriorityPopupWindow;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a extends RFWPriorityPopupWindow {
    protected a(Context context) {
        super(context);
    }

    public static a c(Context context, @StringRes int i3) {
        return d(context, h.a(i3));
    }

    public static a d(Context context, String str) {
        int g16;
        a aVar = new a(context);
        View inflate = LayoutInflater.from(context).inflate(R.layout.g8o, (ViewGroup) null, false);
        TextView textView = (TextView) inflate.findViewById(R.id.f3476101);
        textView.setText(str);
        textView.setTextColor(ie0.a.f().g(context, R.color.qui_common_text_allwhite_primary, 1002));
        RFWPriorityPopupWindow businessTag = aVar.setBusinessTag("qcircle");
        if (QCircleToast.g() && !QCirclePanelStateEvent.isAnyPanelShowing()) {
            g16 = Color.parseColor("#b3424242");
        } else {
            g16 = ie0.a.f().g(context, R.color.qui_common_bg_top_dark, 1002);
        }
        businessTag.setBubbleBackground(g16).setContentView(inflate);
        return aVar;
    }
}
