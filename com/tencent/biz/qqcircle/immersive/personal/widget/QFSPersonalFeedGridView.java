package com.tencent.biz.qqcircle.immersive.personal.widget;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalFeedGridFragment;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes4.dex */
public class QFSPersonalFeedGridView extends QCircleBaseWidgetView<com.tencent.biz.qqcircle.immersive.personal.bean.b> {

    /* renamed from: d, reason: collision with root package name */
    private QFSPersonalFeedGridFragment f89254d;

    public QFSPersonalFeedGridView(@NonNull Context context) {
        super(context);
        initView();
    }

    private void initView() {
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        if (getQCircleBaseFragment() == null) {
            QLog.i("QFSPersonalFeedGridView", 1, "[onInitView] -> getQCircleBaseFragment() is null");
        } else {
            this.f89254d = new QFSPersonalFeedGridFragment();
            getQCircleBaseFragment().getChildFragmentManager().beginTransaction().replace(R.id.f165218li0, this.f89254d).commit();
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gm6;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSPersonalFeedGridView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void bindData(com.tencent.biz.qqcircle.immersive.personal.bean.b bVar, int i3) {
        this.f89254d.Kh(bVar);
    }
}
