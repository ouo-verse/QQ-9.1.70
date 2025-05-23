package gf;

import com.qzone.component.banner.Banner;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\n\u001a\u00020\tH&J\b\u0010\u000b\u001a\u00020\u0004H&J\u0012\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\u000e\u001a\u00020\u0004H&\u00a8\u0006\u000f"}, d2 = {"Lgf/n;", "", "Lcom/qzone/feed/business/model/a;", "data", "", "b", "", WadlProxyConsts.BANNER_TYPE, "hide", "", "d", "a", "Lcom/qzone/component/banner/Banner;", "e", "c", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public interface n {
    void a();

    void b(com.qzone.feed.business.model.a data);

    void c();

    boolean d();

    Banner e(int bannerType);

    void hide(int bannerType);
}
