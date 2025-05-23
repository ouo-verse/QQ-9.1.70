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
import com.tencent.richframework.bubble.controller.RFWTipsBaseController;
import com.tencent.richframework.widget.RFWTriangleView;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a extends RFWTipsBaseController {

    /* renamed from: d, reason: collision with root package name */
    RFWTriangleView f395706d;

    /* renamed from: e, reason: collision with root package name */
    final b f395707e;

    /* renamed from: f, reason: collision with root package name */
    final boolean f395708f;

    public a(View view, RFWTipsBaseConfig rFWTipsBaseConfig, b bVar) {
        super(view, rFWTipsBaseConfig);
        this.f395707e = bVar;
        this.f395708f = bVar.f395711c == 0;
    }

    public RFWTriangleView a() {
        return this.f395706d;
    }

    @Override // com.tencent.richframework.bubble.controller.RFWTipsBaseController
    protected boolean clickPopupWindowDismiss() {
        return true;
    }

    @Override // com.tencent.richframework.bubble.controller.RFWTipsBaseController
    protected int getGravity() {
        return 0;
    }

    @Override // com.tencent.richframework.bubble.controller.RFWTipsBaseController
    protected int getLayoutId() {
        return R.layout.cne;
    }

    @Override // com.tencent.richframework.bubble.controller.RFWTipsBaseController
    protected void initView(View view) {
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.mr8);
        if (this.f395708f) {
            this.f395706d = (RFWTriangleView) view.findViewById(R.id.mr6);
        } else {
            this.f395706d = (RFWTriangleView) view.findViewById(R.id.mr7);
        }
        this.f395706d.setVisibility(0);
        RFWSquareImageView rFWSquareImageView = (RFWSquareImageView) view.findViewById(R.id.mr9);
        TextView textView = (TextView) view.findViewById(R.id.mrb);
        ImageView imageView = (ImageView) view.findViewById(R.id.mr_);
        linearLayout.setBackground(QzoneGuideBubbleHelper.e(ViewUtils.dpToPx(4.0f), 0.0f, this.f395707e.f395717i));
        textView.setText(this.f395707e.f395710b);
        textView.setMaxEms(8);
        textView.setTextColor(this.f395707e.f395713e);
        rFWSquareImageView.setRoundRect(ViewUtils.dpToPx(4.0f));
        imageView.setVisibility(0);
        QzoneGuideBubbleHelper.d dVar = this.f395707e.f395719k;
        if (dVar == null || TextUtils.isEmpty(dVar.f60582e)) {
            return;
        }
        rFWSquareImageView.setVisibility(0);
        com.tencent.mobileqq.qzone.picload.c.a().h(Option.obtain().setUrl(this.f395707e.f395719k.f60582e).setTargetView(rFWSquareImageView));
        imageView.setVisibility(this.f395707e.f395723o ? 0 : 8);
    }

    @Override // com.tencent.richframework.bubble.controller.RFWTipsBaseController
    protected int[] getShowXY(View view, PopupWindow popupWindow) {
        if (view != null && popupWindow != null) {
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            view.getLocationInWindow(iArr2);
            int measuredWidth = popupWindow.getContentView().getMeasuredWidth();
            int measuredHeight = popupWindow.getContentView().getMeasuredHeight();
            iArr[0] = (((iArr2[0] + view.getWidth()) - measuredWidth) + this.mConfig.getLeftMargin()) - this.mConfig.getRightMargin();
            iArr[1] = ((iArr2[1] + (this.f395708f ? -measuredHeight : view.getHeight())) + this.mConfig.getTopMargin()) - this.mConfig.getBottomMargin();
            if (this.f395706d.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.f395706d.getLayoutParams()).leftMargin = (measuredWidth - (view.getWidth() / 2)) - (this.f395706d.getMeasuredWidth() / 2);
            }
            return iArr;
        }
        return new int[2];
    }
}
