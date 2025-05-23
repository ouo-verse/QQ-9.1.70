package com.tencent.biz.qqcircle.immersive.views.search.mixuser;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.immersive.utils.n;
import com.tencent.biz.qqcircle.immersive.utils.p;
import com.tencent.biz.qqcircle.widgets.search.QFSSearchUserResultItemView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StUser;
import qqcircle.QQCircleBase$StUserBusiData;

/* compiled from: P */
/* loaded from: classes4.dex */
public final class QFSSearchVUserResultItemView extends QFSSearchUserResultItemView {
    private TextView I;

    public QFSSearchVUserResultItemView(@NonNull Context context) {
        super(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void v0() {
        String str;
        if (this.E.busiData.has()) {
            byte[] byteArray = this.E.busiData.get().toByteArray();
            QQCircleBase$StUserBusiData qQCircleBase$StUserBusiData = new QQCircleBase$StUserBusiData();
            try {
                qQCircleBase$StUserBusiData.mergeFrom(byteArray);
                str = p.e(qQCircleBase$StUserBusiData);
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.w("QFSSearchVUserResultItemView", 1, "#setupReason error", e16);
            }
            if (!TextUtils.isEmpty(str)) {
                this.I.setVisibility(8);
                return;
            } else {
                this.I.setVisibility(0);
                this.I.setText(str);
                return;
            }
        }
        str = null;
        if (!TextUtils.isEmpty(str)) {
        }
    }

    @Override // com.tencent.biz.qqcircle.widgets.search.QFSSearchUserResultItemView, com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gsm;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.search.QFSSearchUserResultItemView, com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSSearchVUserResultItemView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.search.QFSSearchUserResultItemView
    public void initView() {
        super.initView();
        this.I = (TextView) findViewById(R.id.f56992m4);
        this.G = n.a(getContext(), R.dimen.f159418d51);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.search.QFSSearchUserResultItemView, com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: m0 */
    public void bindData(FeedCloudMeta$StUser feedCloudMeta$StUser, int i3) {
        if (feedCloudMeta$StUser == this.E) {
            return;
        }
        super.bindData(feedCloudMeta$StUser, 0);
        if (feedCloudMeta$StUser == null) {
            return;
        }
        v0();
    }

    @Override // com.tencent.biz.qqcircle.widgets.search.QFSSearchUserResultItemView
    protected String q0() {
        return QCircleDaTongConstant.ElementId.EM_XSJ_USER_ITEM_BIG_V;
    }

    public QFSSearchVUserResultItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QFSSearchVUserResultItemView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
