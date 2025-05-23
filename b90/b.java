package b90;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudRead$StSearchHotEventInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private View f28068a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f28069b;

    /* renamed from: c, reason: collision with root package name */
    private FeedCloudRead$StSearchHotEventInfo f28070c;

    private void c(View view) {
        if (this.f28068a != null) {
            return;
        }
        View inflate = ((ViewStub) view.findViewById(R.id.zet)).inflate();
        this.f28068a = inflate;
        this.f28069b = (TextView) inflate.findViewById(R.id.ezq);
        this.f28068a.setOnClickListener(new View.OnClickListener() { // from class: b90.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                b.this.d(view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        FeedCloudRead$StSearchHotEventInfo feedCloudRead$StSearchHotEventInfo = this.f28070c;
        if (feedCloudRead$StSearchHotEventInfo != null) {
            TextUtils.isEmpty(feedCloudRead$StSearchHotEventInfo.more_url.get());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void b(View view, FeedCloudRead$StSearchHotEventInfo feedCloudRead$StSearchHotEventInfo) {
        String str = feedCloudRead$StSearchHotEventInfo.more_text.get();
        String str2 = feedCloudRead$StSearchHotEventInfo.more_url.get();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.f28070c = feedCloudRead$StSearchHotEventInfo;
            c(view);
            this.f28068a.setVisibility(0);
            this.f28069b.setText(str);
            return;
        }
        this.f28070c = null;
        View view2 = this.f28068a;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }
}
