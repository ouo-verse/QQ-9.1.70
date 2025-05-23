package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StIconDecorate;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleCommentAvatarDecorateView extends QCircleAvatarDecorateView {

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface a {
        void a();
    }

    public QCircleCommentAvatarDecorateView(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(FeedCloudMeta$StIconDecorate feedCloudMeta$StIconDecorate, a aVar) {
        setImageDrawable(null);
        if (feedCloudMeta$StIconDecorate == null) {
            QLog.d("QCircleCommentAvatarDecorateView", 1, "empty iconDecorateInfo");
        } else {
            if (!QCircleAvatarDecorateView.e(feedCloudMeta$StIconDecorate)) {
                return;
            }
            n(feedCloudMeta$StIconDecorate.comment_url.get(), aVar);
        }
    }

    private void n(String str, a aVar) {
        if (!TextUtils.isEmpty(str) && !str.equals("null")) {
            if (aVar != null) {
                aVar.a();
            }
            c(str);
            return;
        }
        QLog.d("QCircleCommentAvatarDecorateView", 1, "empty comment decorate");
    }

    public void setCommentDecorate(final FeedCloudMeta$StIconDecorate feedCloudMeta$StIconDecorate, final a aVar) {
        post(new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.f
            @Override // java.lang.Runnable
            public final void run() {
                QCircleCommentAvatarDecorateView.this.m(feedCloudMeta$StIconDecorate, aVar);
            }
        });
    }

    public QCircleCommentAvatarDecorateView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QCircleCommentAvatarDecorateView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    @Override // com.tencent.biz.qqcircle.widgets.QCircleAvatarDecorateView
    protected void j() {
    }
}
