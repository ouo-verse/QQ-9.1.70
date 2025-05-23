package com.tencent.biz.qqcircle.immersive.views.search.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.widgets.QFSLikeImageView;
import com.tencent.mobileqq.R;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import java.util.List;
import tianshu.QQCircleTianShu$MapEntry;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSSearchLikeImageView extends QFSLikeImageView {
    public QFSSearchLikeImageView(Context context) {
        super(context);
    }

    private void o() {
        this.C = QCircleSkinHelper.getInstance().getUrl("https://qq-video.cdn-go.cn/android/latest/defaultmode/9065/animation_lottie/qvideo_skin_feedzhengwen_icon_animation_like.json");
        this.D = QCircleSkinHelper.getInstance().getUrl("https://qq-video.cdn-go.cn/android/latest/defaultmode/9065/animation_lottie/qvideo_skin_feedzhengwen_icon_animation_cancellike.json");
        this.E = "";
        this.F = "";
        this.G = 400L;
        this.H = 400L;
    }

    @Override // com.tencent.biz.qqcircle.widgets.QFSLikeImageView
    protected void g(List<QQCircleTianShu$MapEntry> list) {
        setDisplayDrawables(getResources().getDrawable(R.drawable.ooe), getResources().getDrawable(R.drawable.l8f, null));
        boolean isDarkMode = QCircleSkinHelper.getInstance().isDarkMode();
        if (list != null && list.size() != 0) {
            super.f(list);
            if (!isDarkMode) {
                for (QQCircleTianShu$MapEntry qQCircleTianShu$MapEntry : list) {
                    if (!TextUtils.isEmpty(qQCircleTianShu$MapEntry.value.get())) {
                        if ("like_resource_theme".equals(qQCircleTianShu$MapEntry.key.get())) {
                            this.C = qQCircleTianShu$MapEntry.value.get();
                        } else if ("cancel_like_resource_theme".equals(qQCircleTianShu$MapEntry.key.get())) {
                            this.D = qQCircleTianShu$MapEntry.value.get();
                        } else if ("normal_like_icon_theme".equals(qQCircleTianShu$MapEntry.key.get())) {
                            this.E = qQCircleTianShu$MapEntry.value.get();
                        }
                    }
                }
                return;
            }
            return;
        }
        o();
    }

    public QFSSearchLikeImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QFSSearchLikeImageView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
