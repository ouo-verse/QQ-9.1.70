package fs;

import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;

/* compiled from: P */
/* loaded from: classes38.dex */
public class r extends JobSegment<b, b> {

    /* renamed from: d, reason: collision with root package name */
    private long f400467d;

    public r(long j3) {
        this.f400467d = j3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tribe.async.async.JobSegment
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void runSegment(JobContext jobContext, b bVar) {
        if (com.tencent.aelight.camera.aioeditor.takevideo.g.f(this.f400467d)) {
            bVar.f400395l.f400415a = com.tencent.aelight.camera.aioeditor.takevideo.g.e(this.f400467d);
            if (TextUtils.isEmpty(bVar.f400395l.f400415a)) {
                super.notifyError(new ErrorMessage(-1, HardCodeUtil.qqStr(R.string.o0l)));
                return;
            }
        }
        super.notifyResult(bVar);
    }
}
