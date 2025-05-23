package mn;

import com.qzone.reborn.base.l;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes38.dex */
public abstract class a extends l<bn.b> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: getLogTag */
    public abstract String getTAG();

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean u() {
        String str;
        gd.a aVar = gd.a.f401926a;
        if (aVar.b() && aVar.c("KEY_OPEN_QZMOMENT_DEFAULT_FEED_BLUR", false)) {
            QLog.i(getTAG(), 1, "isFeedGaussianBlur -> true, debug open blur");
            return true;
        }
        T t16 = this.mData;
        if (t16 != 0 && ((bn.b) t16).a().opMask.get().contains(1)) {
            QLog.i(getTAG(), 1, "isFeedGaussianBlur -> true, feed_opMask blur | feedId = " + ((bn.b) this.mData).a().f430362id.get() + " | pos = " + this.mPosition);
            return true;
        }
        String tag = getTAG();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("isFeedGaussianBlur -> false   | feedId = ");
        T t17 = this.mData;
        if (t17 != 0) {
            str = ((bn.b) t17).a().f430362id.get();
        } else {
            str = "";
        }
        sb5.append(str);
        sb5.append(" | pos = ");
        sb5.append(this.mPosition);
        QLog.i(tag, 1, sb5.toString());
        return false;
    }
}
