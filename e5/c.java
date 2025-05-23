package e5;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.qzone.widget.QzoneGuideBubbleHelper;
import com.tencent.biz.richframework.widget.RFWSquareImageView;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.richframework.bubble.bean.RFWTipsBaseConfig;
import com.tencent.richframework.widget.RFWTriangleView;

/* compiled from: P */
/* loaded from: classes38.dex */
public class c extends a {
    public c(View view, RFWTipsBaseConfig rFWTipsBaseConfig, b bVar) {
        super(view, rFWTipsBaseConfig, bVar);
    }

    @Override // e5.a, com.tencent.richframework.bubble.controller.RFWTipsBaseController
    protected void initView(View view) {
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.mr8);
        RFWTriangleView rFWTriangleView = (RFWTriangleView) view.findViewById(R.id.mr6);
        this.f395706d = rFWTriangleView;
        rFWTriangleView.setVisibility(0);
        RFWSquareImageView rFWSquareImageView = (RFWSquareImageView) view.findViewById(R.id.mr9);
        TextView textView = (TextView) view.findViewById(R.id.mrb);
        ImageView imageView = (ImageView) view.findViewById(R.id.mr_);
        linearLayout.setBackground(QzoneGuideBubbleHelper.e(ViewUtils.dpToPx(4.0f), 0.0f, this.f395707e.f395717i));
        textView.setText(this.f395707e.f395710b);
        textView.setMaxEms(8);
        textView.setTextColor(this.f395707e.f395713e);
        rFWSquareImageView.setRoundRect(ViewUtils.dpToPx(4.0f));
        QzoneGuideBubbleHelper.d dVar = this.f395707e.f395719k;
        if (dVar == null || TextUtils.isEmpty(dVar.f60582e)) {
            return;
        }
        rFWSquareImageView.setVisibility(0);
        com.tencent.mobileqq.qzone.picload.c.a().h(Option.obtain().setUrl(this.f395707e.f395719k.f60582e).setTargetView(rFWSquareImageView));
        imageView.setVisibility(0);
    }

    @Override // e5.a, com.tencent.richframework.bubble.controller.RFWTipsBaseController
    protected int[] getShowXY(View view, PopupWindow popupWindow) {
        if (view != null && popupWindow != null) {
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            int measuredWidth = popupWindow.getContentView().getMeasuredWidth();
            int[] iArr2 = {(((iArr[0] + view.getWidth()) - measuredWidth) + this.mConfig.getLeftMargin()) - this.mConfig.getRightMargin(), (iArr[1] - popupWindow.getContentView().getMeasuredHeight()) - this.mConfig.getBottomMargin()};
            if (a().getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) a().getLayoutParams()).leftMargin = (measuredWidth - (view.getWidth() / 2)) - (a().getMeasuredWidth() / 2);
            }
            return iArr2;
        }
        return new int[2];
    }
}
