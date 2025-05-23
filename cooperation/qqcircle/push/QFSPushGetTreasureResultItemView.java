package cooperation.qqcircle.push;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.util.RFWTypefaceUtil;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qcircle.api.global.QFSPushOpenBoxResultBean;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.utils.QFSPushPopWindowImgConst;

/* loaded from: classes28.dex */
public class QFSPushGetTreasureResultItemView extends RecyclerView.ViewHolder {
    private static final int MULTIPLE_ICON_HEIGHT = 16;
    private static final int MULTIPLE_ICON_WIDTH = 40;
    private static final String ROCKET_COUNT_PREFIX = "+";
    private static final int ROCKET_WIDTH = 32;
    private static final String TAG = "QFSPushGetTreasureResultItemView";
    private TextView mRocketCount;
    private ImageView mRocketIcon;
    private ImageView mTreasureMultiple;
    private TextView mTreasureText;

    public QFSPushGetTreasureResultItemView(View view) {
        super(view);
        this.mTreasureText = (TextView) view.findViewById(R.id.f509426r);
        this.mTreasureMultiple = (ImageView) view.findViewById(R.id.f509326q);
        this.mRocketIcon = (ImageView) view.findViewById(R.id.f509226p);
        this.mRocketCount = (TextView) view.findViewById(R.id.f509126o);
        Option enableAutoDeleteLocalCache = Option.obtain().setUrl(QFSPushPopWindowImgConst.ImageURL.QVIDEO_ROCKET_KAIXIANG_DUOKAI_ROCKET).setRequestWidth(ImmersiveUtils.dpToPx(32.0f)).setRequestHeight(ImmersiveUtils.dpToPx(32.0f)).setTargetView(this.mRocketIcon).setEnableAutoDeleteLocalCache(false);
        enableAutoDeleteLocalCache.setSupportRecycler(true);
        QCircleFeedPicLoader.g().loadImage(enableAutoDeleteLocalCache);
    }

    private String getMultiRocketMultipleImgURL(float f16) {
        if (f16 == 2.0f) {
            return QFSPushPopWindowImgConst.ImageURL.QVIDEO_ROCKET_KAIXIANG_DUOKAI_2;
        }
        if (f16 == 3.0f) {
            return QFSPushPopWindowImgConst.ImageURL.QVIDEO_ROCKET_KAIXIANG_DUOKAI_3;
        }
        if (f16 == 5.0f) {
            return QFSPushPopWindowImgConst.ImageURL.QVIDEO_ROCKET_KAIXIANG_DUOKAI_5;
        }
        if (f16 == 10.0f) {
            return QFSPushPopWindowImgConst.ImageURL.QVIDEO_ROCKET_KAIXIANG_DUOKAI_10;
        }
        if (f16 == 100.0f) {
            return QFSPushPopWindowImgConst.ImageURL.QVIDEO_ROCKET_KAIXIANG_DUOKAI_100;
        }
        return QFSPushPopWindowImgConst.ImageURL.QVIDEO_ROCKET_KAIXIANG_DUOKAI_05;
    }

    private String getTreasureName(int i3) {
        if (i3 == 2) {
            return HardCodeUtil.qqStr(R.string.f194294bi);
        }
        return HardCodeUtil.qqStr(R.string.f194144b4);
    }

    public void bindData(QFSPushOpenBoxResultBean qFSPushOpenBoxResultBean) {
        if (qFSPushOpenBoxResultBean == null) {
            return;
        }
        if (qFSPushOpenBoxResultBean.getTreasureType() != 0) {
            this.mTreasureText.setText(getTreasureName(qFSPushOpenBoxResultBean.getTreasureType()));
        }
        if (qFSPushOpenBoxResultBean.getTreasureTextColor() != 0) {
            this.mTreasureText.setTextColor(qFSPushOpenBoxResultBean.getTreasureTextColor());
        }
        if (qFSPushOpenBoxResultBean.getTreasureMultiple() != 0.0f) {
            Option targetView = Option.obtain().setUrl(getMultiRocketMultipleImgURL(qFSPushOpenBoxResultBean.getTreasureMultiple())).setRequestWidth(ImmersiveUtils.dpToPx(40.0f)).setRequestHeight(ImmersiveUtils.dpToPx(16.0f)).setTargetView(this.mTreasureMultiple);
            targetView.setSupportRecycler(true);
            QCircleFeedPicLoader.g().loadImage(targetView);
        }
        RFWTypefaceUtil.setNumberTypeface(this.mRocketCount, false);
        if (qFSPushOpenBoxResultBean.getRocketCount() != 0) {
            this.mRocketCount.setText("+" + qFSPushOpenBoxResultBean.getRocketCount());
        }
    }
}
