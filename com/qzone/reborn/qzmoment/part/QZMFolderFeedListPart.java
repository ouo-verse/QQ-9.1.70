package com.qzone.reborn.qzmoment.part;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.FrameLayout;
import com.qzone.reborn.qzmoment.bean.QZMFolderInitBean;
import com.qzone.reborn.qzmoment.bean.QZMMessageInitBean;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes37.dex */
public class QZMFolderFeedListPart extends QZMBaseFeedListPart {
    private com.qzone.reborn.qzmoment.viewmodel.j F;
    private QZMFolderInitBean G;

    private void Q9() {
        if (this.G.isNeedToJumpMessagePage()) {
            this.G.setIsNeedToJumpMessagePage(false);
            ((jn.b) ho.i.t(jn.b.class)).d(getActivity(), new QZMMessageInitBean());
        } else {
            if (!this.G.isNeedToJumpFeedDetailPage() || this.G.getFeedDetailInitBean() == null) {
                return;
            }
            this.G.setIsNeedToJumpFeedDetailPage(false);
            ((jn.b) ho.i.t(jn.b.class)).a(getActivity(), this.G.getFeedDetailInitBean());
        }
    }

    private void R9() {
        if (getActivity() == null) {
            QLog.e("QZMFolderFeedListPart", 1, "qzm activity is null");
            return;
        }
        if (getActivity().getIntent() == null) {
            QLog.e("QZMFolderFeedListPart", 1, "qzm activity intent is null");
            return;
        }
        Intent intent = getActivity().getIntent();
        if (intent != null && intent.hasExtra("key_bundle_common_init_bean")) {
            this.G = (QZMFolderInitBean) intent.getSerializableExtra("key_bundle_common_init_bean");
        }
        if (this.G != null) {
            Q9();
        }
    }

    @Override // com.qzone.reborn.qzmoment.part.QZMBaseFeedListPart
    protected com.qzone.reborn.qzmoment.viewmodel.c I9() {
        if (this.F == null) {
            this.F = (com.qzone.reborn.qzmoment.viewmodel.j) getViewModel(com.qzone.reborn.qzmoment.viewmodel.j.class);
        }
        return this.F;
    }

    @Override // com.qzone.reborn.qzmoment.part.QZMBaseFeedListPart, com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZMFolderFeedListPart";
    }

    @Override // com.qzone.reborn.qzmoment.part.QZMBaseFeedListPart, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        S9(view);
    }

    @Override // com.qzone.reborn.qzmoment.part.QZMBaseFeedListPart, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        com.qzone.reborn.qzmoment.comment.d.l().onDestroy();
    }

    @Override // com.qzone.reborn.qzmoment.part.QZMBaseFeedListPart, com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStart(Activity activity) {
        R9();
    }

    private void S9(View view) {
        final View findViewById = view.findViewById(R.id.mgk);
        findViewById.post(new Runnable() { // from class: com.qzone.reborn.qzmoment.part.QZMFolderFeedListPart.1
            @Override // java.lang.Runnable
            public void run() {
                View view2;
                if (QZMFolderFeedListPart.this.f58906f == null || (view2 = findViewById) == null || view2.getVisibility() != 0) {
                    return;
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) QZMFolderFeedListPart.this.f58906f.getLayoutParams();
                layoutParams.topMargin = (int) (findViewById.getHeight() + QZMFolderFeedListPart.this.f58906f.getResources().getDimension(R.dimen.f9658));
                QZMFolderFeedListPart.this.f58906f.setLayoutParams(layoutParams);
            }
        });
    }
}
