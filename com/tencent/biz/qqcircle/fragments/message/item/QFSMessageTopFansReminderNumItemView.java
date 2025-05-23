package com.tencent.biz.qqcircle.fragments.message.item;

import android.content.Context;
import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QFSMessageLightInteractInfo;
import com.tencent.biz.qqcircle.utils.h;
import com.tencent.biz.qqcircle.widgets.QCircleBaseLightInteractWidget;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSMessageTopFansReminderNumItemView extends QCircleBaseLightInteractWidget {
    private static final int D = QCircleApplication.getAPP().getResources().getDimensionPixelSize(R.dimen.d3g);
    private static final int E = QCircleApplication.getAPP().getResources().getDimensionPixelSize(R.dimen.d3f);
    private TextView C;

    /* renamed from: i, reason: collision with root package name */
    private ViewGroup f84446i;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f84447m;

    public QFSMessageTopFansReminderNumItemView(@NonNull Context context, int i3) {
        super(context, i3);
        l0(this);
    }

    private void l0(@NonNull View view) {
        this.C = (TextView) view.findViewById(R.id.f46971w1);
        this.f84447m = (ImageView) view.findViewById(R.id.f46961w0);
        this.f84446i = (ViewGroup) view.findViewById(R.id.f46981w2);
        QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(QCircleSkinHelper.getInstance().getUrl("qvideo_icon_jiejie_look")).setTargetView(this.f84447m).setRequestWidth(D).setRequestHeight(E).setLoadingDrawableColor(0).setFailedDrawableColor(0));
        this.f84446i.setBackground(QCircleSkinHelper.getInstance().getDrawable("qvideo_msgpage_noticebg_bluegradient"));
        setClipChildren(false);
        setClipToPadding(false);
    }

    private void m0(@NonNull QFSMessageLightInteractInfo qFSMessageLightInteractInfo) {
        if (this.C == null) {
            return;
        }
        String fansReminderNum = qFSMessageLightInteractInfo.getFansReminderNum();
        QLog.d(getLogTag(), 1, "[updateFansNum] fansNum:" + fansReminderNum);
        String a16 = h.a(R.string.f1917545n);
        String a17 = h.a(R.string.f1917645o);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) a16);
        int length = spannableStringBuilder.length();
        spannableStringBuilder.append((CharSequence) fansReminderNum);
        spannableStringBuilder.append((CharSequence) a17);
        spannableStringBuilder.setSpan(new tc0.a(Typeface.DEFAULT_BOLD, ImmersiveUtils.dpToPx(17.0f)), length, fansReminderNum.length() + length, 33);
        this.C.setText(spannableStringBuilder);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    protected void bindData(Object obj, int i3) {
        if (!(obj instanceof QFSMessageLightInteractInfo)) {
            return;
        }
        m0((QFSMessageLightInteractInfo) obj);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f168713gj3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSMessageTopFansReminderNumItemView";
    }

    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public void setReportBean(Object obj) {
    }
}
