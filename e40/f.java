package e40;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import tianshu.QQCircleTianShu$AdItem;

/* compiled from: P */
/* loaded from: classes4.dex */
public class f extends e {

    /* renamed from: b, reason: collision with root package name */
    public String f395600b;

    /* renamed from: c, reason: collision with root package name */
    public String f395601c;

    /* renamed from: d, reason: collision with root package name */
    public List<String> f395602d;

    /* renamed from: e, reason: collision with root package name */
    public String f395603e;

    /* renamed from: f, reason: collision with root package name */
    public String f395604f;

    /* renamed from: g, reason: collision with root package name */
    public String f395605g;

    /* renamed from: h, reason: collision with root package name */
    public String f395606h;

    public f(QQCircleTianShu$AdItem qQCircleTianShu$AdItem) {
        super(qQCircleTianShu$AdItem);
        d(a());
    }

    public void d(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            this.f395600b = map.get("pic_type");
            this.f395601c = map.get("single_pic");
            String str = map.get("carousel_pics");
            if (!TextUtils.isEmpty(str)) {
                this.f395602d = Arrays.asList(str.split("\\|"));
            }
            this.f395603e = map.get("jump_url");
            this.f395604f = map.get("bubble_copywriting");
            this.f395605g = map.get("publish_image_select_page_icon");
            this.f395606h = map.get("publish_image_select_page_copywriting");
        }
    }

    public String toString() {
        return "ButtonInfo{picType='" + this.f395600b + "', singlePic='" + this.f395601c + "', carouselPics=" + this.f395602d + ", jumpUrl='" + this.f395603e + "', bubbleCopywriting='" + this.f395604f + "', publishImageSelectPageIcon='" + this.f395605g + "', publishImageSelectPageCopywriting='" + this.f395606h + "'}";
    }
}
