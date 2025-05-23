package mn;

import android.text.TextUtils;
import android.view.View;
import com.qzone.reborn.widget.QZoneAsyncTextView;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes38.dex */
public class d extends a {

    /* renamed from: e, reason: collision with root package name */
    private QZoneAsyncTextView f417011e;

    /* JADX WARN: Multi-variable type inference failed */
    private void w() {
        if (TextUtils.isEmpty(((bn.b) this.mData).a().content.get())) {
            this.f417011e.setVisibility(8);
            return;
        }
        this.f417011e.setVisibility(0);
        this.f417011e.setText(((bn.b) this.mData).a().content.get());
        QLog.i("QZMFeedContentPresenter", 1, "updateContentData  | content = " + ((bn.b) this.mData).a().content.get() + " | feedId = " + ((bn.b) this.mData).a().f430362id.get() + " | pos = " + this.mPosition + " | hashCode = " + hashCode());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mn.a, com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZMFeedContentPresenter";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.mkf};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View view) {
        this.f417011e = (QZoneAsyncTextView) view.findViewById(R.id.nis);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public void onBindData(bn.b bVar, int i3, List<Object> list) {
        if (bVar == null) {
            return;
        }
        w();
    }
}
