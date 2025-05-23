package nn;

import android.view.View;
import com.qzone.reborn.base.l;
import com.qzone.reborn.qzmoment.bean.QZMFeedDetailInitBean;
import com.qzone.util.ToastUtil;
import com.tencent.mobileqq.R;
import ho.i;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes38.dex */
public abstract class b extends l<bn.g> {
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void u(View view) {
        if (this.mData == 0 || view == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("message_id", ((bn.g) this.mData).a().f430364id.get());
        hashMap.put("message_issuer_uin", ((bn.g) this.mData).a().operation.opUser.f430367id.get());
        fo.c.o(view, "em_bas_single_message_item", new fo.b().l(hashMap).i(((bn.g) this.mData).a().f430364id.get()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void v() {
        String str;
        if (!((bn.g) this.mData).a().opMask.isEmpty()) {
            if (((bn.g) this.mData).a().opMask.get(0).intValue() == 2) {
                ToastUtil.o(R.string.f133215i, 4);
                return;
            } else if (((bn.g) this.mData).a().opMask.get(0).intValue() == 1) {
                ToastUtil.o(R.string.f133225j, 4);
                return;
            }
        }
        if (((bn.g) this.mData).a().noticeType.get() != 1 && ((bn.g) this.mData).a().noticeType.get() != 2) {
            str = "";
        } else {
            str = "comment";
        }
        ((jn.b) i.t(jn.b.class)).a(p(), new QZMFeedDetailInitBean(((bn.g) this.mData).a().feed.f430362id.get(), ((bn.g) this.mData).a().feed.poster.f430367id.get(), Long.valueOf(((bn.g) this.mData).a().createTime.get()), str));
    }
}
