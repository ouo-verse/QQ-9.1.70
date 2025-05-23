package com.qzone.reborn.qzmoment.part;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.qzone.reborn.qzmoment.bean.QZMFeedDetailInitBean;
import com.qzone.reborn.qzmoment.bean.QZMFolderInitBean;
import com.qzone.reborn.qzmoment.bean.QZMMyMomentInitBean;
import com.qzone.reborn.qzmoment.viewmodel.QZMFeedDoLikeViewModel;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes37.dex */
public class j extends an.a implements gn.a {

    /* renamed from: d, reason: collision with root package name */
    private QZMFeedDoLikeViewModel f58964d;

    private void C9() {
        if (getActivity() != null && getActivity().getIntent() != null) {
            Intent intent = getActivity().getIntent();
            if (intent.getExtras() == null) {
                QLog.e("QZMFeedDoLikePart", 1, "extra is null");
                return;
            }
            Bundle extras = intent.getExtras();
            if (extras.get("key_bundle_common_init_bean") instanceof QZMFolderInitBean) {
                e8().Z1("page_type_feed_list_do_like");
                return;
            } else if (extras.get("key_bundle_common_init_bean") instanceof QZMFeedDetailInitBean) {
                e8().Z1("page_type_feed_detail_do_like");
                return;
            } else {
                if (extras.get("key_bundle_common_init_bean") instanceof QZMMyMomentInitBean) {
                    e8().Z1("page_type_feed_my_do_like");
                    return;
                }
                return;
            }
        }
        QLog.e("QZMFeedDoLikePart", 1, "qzm activity is null");
    }

    @Override // gn.a
    public QZMFeedDoLikeViewModel e8() {
        return this.f58964d;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f58964d = (QZMFeedDoLikeViewModel) getViewModel(QZMFeedDoLikeViewModel.class);
        C9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        registerIoc(this, gn.a.class);
    }
}
