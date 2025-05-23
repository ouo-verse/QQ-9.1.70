package nn;

import android.view.View;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a extends b implements View.OnClickListener {

    /* renamed from: e, reason: collision with root package name */
    private QZoneUserAvatarView f420512e;

    /* JADX WARN: Multi-variable type inference failed */
    private void w() {
        long j3;
        try {
            j3 = Long.parseLong(((bn.g) this.mData).a().operation.opUser.f430367id.get());
        } catch (NumberFormatException e16) {
            QLog.e("QZMMessageAvatarPresenter", 1, "handleOnClickUserAvatar e = " + e16.getMessage());
            j3 = 0;
        }
        ho.h.b(p(), j3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void y() {
        long j3;
        if (((bn.g) this.mData).a().operation.opUser == null) {
            return;
        }
        try {
            j3 = Long.parseLong(((bn.g) this.mData).a().operation.opUser.f430367id.get());
        } catch (NumberFormatException e16) {
            QLog.e("QZMMessageAvatarPresenter", 1, "updateUserAvatar  e = " + e16.getMessage());
            j3 = 0L;
        }
        if (j3 == 0) {
            QLog.e("QZMMessageAvatarPresenter", 1, "invalid uin");
        } else {
            this.f420512e.setUser(j3);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.mlp) {
            w();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.mkt};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View view) {
        QZoneUserAvatarView qZoneUserAvatarView = (QZoneUserAvatarView) view.findViewById(R.id.mlp);
        this.f420512e = qZoneUserAvatarView;
        qZoneUserAvatarView.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void onBindData(bn.g gVar, int i3, List<Object> list) {
        if (gVar == null) {
            return;
        }
        y();
    }
}
