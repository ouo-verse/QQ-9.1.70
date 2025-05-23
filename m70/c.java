package m70;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.text.rich.RFWAsyncRichTextView;
import feedcloud.FeedCloudMeta$StBarrage;

/* compiled from: P */
/* loaded from: classes4.dex */
public class c extends b {

    /* renamed from: d, reason: collision with root package name */
    private RFWAsyncRichTextView f416368d;

    /* renamed from: e, reason: collision with root package name */
    private String f416369e;

    /* renamed from: f, reason: collision with root package name */
    private volatile RectF f416370f;

    /* renamed from: g, reason: collision with root package name */
    private volatile Paint f416371g;

    /* renamed from: h, reason: collision with root package name */
    private a f416372h;

    public c(Context context) {
        super(context, R.layout.g_c);
        this.f416370f = new RectF();
        this.f416371g = new Paint();
    }

    private void n() {
        if (this.f416368d == null) {
            return;
        }
        if (!j70.a.b()) {
            this.f440689a.setAlpha(1.0f);
        } else if (TextUtils.equals(j70.a.a(), this.f416369e)) {
            this.f440689a.setAlpha(1.0f);
        } else {
            this.f440689a.setAlpha(0.3f);
        }
    }

    private void o(@NonNull a aVar) {
        FeedCloudMeta$StBarrage a16 = aVar.a();
        m(this.f416368d, i(a16));
        this.f416369e = h(a16);
    }

    @Override // uz3.k.a
    public void a(Canvas canvas) {
        if (canvas == null) {
            return;
        }
        a aVar = this.f416372h;
        if (aVar != null && aVar.b()) {
            this.f416369e = h(this.f416372h.a());
            this.f416372h.e(false);
        }
        n();
        super.a(canvas);
    }

    @Override // m70.b
    public void k(a aVar) {
        if (aVar == null) {
            QLog.d("QDM-QFSFakeBarrageHolder", 1, "[onBindView] param should not be null.");
        } else {
            o(aVar);
            this.f416372h = aVar;
        }
    }

    @Override // m70.b
    public void l(View view) {
        if (view == null) {
            return;
        }
        RFWAsyncRichTextView rFWAsyncRichTextView = (RFWAsyncRichTextView) view.findViewById(R.id.v9l);
        this.f416368d = rFWAsyncRichTextView;
        rFWAsyncRichTextView.setShadowLayer(2.0f, 0.0f, 1.0f, RFWApplication.getApplication().getResources().getColor(R.color.cjx));
    }
}
