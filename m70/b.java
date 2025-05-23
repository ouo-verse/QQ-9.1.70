package m70;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.text.rich.parser.RichTextAtParser;
import feedcloud.FeedCloudMeta$StBarrage;
import uz3.k;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class b extends k.a {
    public b(Context context, int i3) {
        super(j(context, i3));
        l(this.f440689a);
    }

    private static View j(Context context, int i3) {
        return LayoutInflater.from(context).inflate(i3, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String h(FeedCloudMeta$StBarrage feedCloudMeta$StBarrage) {
        if (feedCloudMeta$StBarrage == null) {
            return null;
        }
        return feedCloudMeta$StBarrage.f398446id.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String i(FeedCloudMeta$StBarrage feedCloudMeta$StBarrage) {
        if (feedCloudMeta$StBarrage == null) {
            return null;
        }
        return feedCloudMeta$StBarrage.content.get();
    }

    public abstract void k(a aVar);

    public abstract void l(View view);

    /* JADX INFO: Access modifiers changed from: protected */
    public void m(TextView textView, String str) {
        if (textView == null) {
            QLog.d("QDM-FSBaseBarrageHolder", 1, "[setViewText] view should not is null.");
            return;
        }
        if (str == null) {
            str = "";
        }
        textView.setText(RichTextAtParser.changeAT2PlainText(str));
    }
}
