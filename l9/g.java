package l9;

import android.view.View;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.User;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH&J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\nH&J\b\u0010\u0011\u001a\u00020\u0004H&\u00a8\u0006\u0012"}, d2 = {"Ll9/g;", "", "Lcom/qzone/proxy/feedcomponent/model/User;", QCircleAlphaUserReporter.KEY_USER, "", "X7", "Lcom/qzone/proxy/feedcomponent/model/Comment;", "data", "v8", "q0", "Lcom/qzone/reborn/albumx/common/bean/g;", "date", "S1", "Landroid/view/View;", "view", "W3", "r1", "d6", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public interface g {
    void S1(com.qzone.reborn.albumx.common.bean.g date);

    void W3(View view, Comment data);

    void X7(User user);

    void d6();

    void q0(Comment data);

    void r1(View view, com.qzone.reborn.albumx.common.bean.g date);

    void v8(Comment data);
}
