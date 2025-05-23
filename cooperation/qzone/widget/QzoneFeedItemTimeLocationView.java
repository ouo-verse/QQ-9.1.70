package cooperation.qzone.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QzoneFeedItemTimeLocationView extends RelativeLayout {
    private static final String TAG = "QzoneFeedItemTimeLocationView";
    TextView feedCreateTimeTv;
    TextView feedLocationTv;
    private Context mContext;
    public String timeStr;

    public QzoneFeedItemTimeLocationView(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(R.layout.f167741fz, this);
        this.feedLocationTv = (TextView) findViewById(R.id.c75);
        this.feedCreateTimeTv = (TextView) findViewById(R.id.c8z);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        int i19;
        super.onLayout(z16, i3, i16, i17, i18);
        if (z16) {
            TextView textView = this.feedCreateTimeTv;
            if (textView != null) {
                i19 = textView.getWidth();
            } else {
                i19 = 0;
            }
            int width = getWidth();
            int dimension = ((((width - ((int) (this.mContext.getResources().getDimension(R.dimen.f158216al) + 0.5d))) - ((int) (this.mContext.getResources().getDimension(R.dimen.f158217am) + 0.5d))) - ((int) (this.mContext.getResources().getDimension(R.dimen.f158215ak) + 0.5d))) - i19) - 1;
            this.feedLocationTv.setMaxWidth(dimension);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "onLayout change:timeWidth:" + i19 + ",feedLocationTvWidth(max):" + dimension + ",feedLocationLayoutWidth:" + width);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onLayout");
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
    }

    public void setTime(String str) {
        this.timeStr = str;
    }

    public QzoneFeedItemTimeLocationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    public QzoneFeedItemTimeLocationView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mContext = context;
        init();
    }
}
