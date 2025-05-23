package nn;

import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes38.dex */
public class h extends b implements View.OnClickListener {

    /* renamed from: e, reason: collision with root package name */
    private TextView f420519e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f420520f;

    /* renamed from: h, reason: collision with root package name */
    private View f420521h;

    /* JADX WARN: Multi-variable type inference failed */
    private void w() {
        int i3;
        try {
            i3 = Integer.parseInt(((bn.g) this.mData).a().operation.opUser.f430367id.get());
        } catch (NumberFormatException e16) {
            QLog.e("QZMMessageNickPresenter", 1, "handleOnClickUserAvatar e = " + e16.getMessage());
            i3 = 0;
        }
        ho.h.b(p(), i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void y() {
        this.f420520f.setText(rn.a.b(((bn.g) this.mData).a().createTime.get() * 1000));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void z() {
        this.f420519e.setText(((bn.g) this.mData).a().operation.opUser.nick.get());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.mk_) {
            v();
        } else if (id5 == R.id.mkz) {
            w();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View view) {
        this.f420521h = view;
        this.f420519e = (TextView) view.findViewById(R.id.mkz);
        this.f420520f = (TextView) view.findViewById(R.id.mk_);
        this.f420519e.setOnClickListener(this);
        this.f420520f.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.mkw};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void onBindData(bn.g gVar, int i3, List<Object> list) {
        if (gVar == null) {
            return;
        }
        z();
        y();
        u(this.f420521h);
    }
}
