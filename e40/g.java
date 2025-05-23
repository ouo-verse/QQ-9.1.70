package e40;

import feedcloud.FeedCloudMeta$StImage;
import java.util.ArrayList;
import java.util.Map;
import qqcircle.QQCircleDitto$StButton;
import qqcircle.QQCircleDitto$StPicTextBanner;
import tianshu.QQCircleTianShu$AdItem;

/* compiled from: P */
/* loaded from: classes4.dex */
public class g extends e {

    /* renamed from: b, reason: collision with root package name */
    public QQCircleTianShu$AdItem f395607b;

    /* renamed from: c, reason: collision with root package name */
    public String f395608c;

    /* renamed from: d, reason: collision with root package name */
    public String f395609d;

    /* renamed from: e, reason: collision with root package name */
    public String f395610e;

    /* renamed from: f, reason: collision with root package name */
    public String f395611f;

    /* renamed from: g, reason: collision with root package name */
    public String f395612g;

    /* renamed from: h, reason: collision with root package name */
    public String f395613h;

    /* renamed from: i, reason: collision with root package name */
    public String f395614i;

    public g(QQCircleTianShu$AdItem qQCircleTianShu$AdItem) {
        super(qQCircleTianShu$AdItem);
        d(a());
    }

    private void d(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            this.f395608c = map.get("pic");
            this.f395609d = map.get("title");
            this.f395610e = map.get("copywriting");
            this.f395611f = map.get("button_copywriting");
            this.f395612g = map.get("button_jumpurl");
            this.f395613h = map.get("publish_image_select_page_icon");
            this.f395614i = map.get("publish_image_select_page_copywriting");
        }
    }

    public String e() {
        return b(this.f395612g, this.f395613h, this.f395614i);
    }

    public QQCircleDitto$StPicTextBanner f() {
        QQCircleDitto$StPicTextBanner qQCircleDitto$StPicTextBanner = new QQCircleDitto$StPicTextBanner();
        FeedCloudMeta$StImage feedCloudMeta$StImage = new FeedCloudMeta$StImage();
        feedCloudMeta$StImage.picUrl.set(this.f395608c);
        qQCircleDitto$StPicTextBanner.icon.set(feedCloudMeta$StImage);
        ArrayList arrayList = new ArrayList();
        QQCircleDitto$StButton qQCircleDitto$StButton = new QQCircleDitto$StButton();
        arrayList.add(qQCircleDitto$StButton);
        qQCircleDitto$StButton.name.set(this.f395611f);
        qQCircleDitto$StPicTextBanner.buttons.set(arrayList);
        qQCircleDitto$StPicTextBanner.title.set(this.f395609d);
        qQCircleDitto$StPicTextBanner.content.set(this.f395610e);
        qQCircleDitto$StPicTextBanner.actionUrl.set(e());
        return qQCircleDitto$StPicTextBanner;
    }

    public String toString() {
        return "ToastInfo{pic='" + this.f395608c + "', title='" + this.f395609d + "', copywriting='" + this.f395610e + "', buttonCopywriting='" + this.f395611f + "', buttonJumpUrl='" + this.f395612g + "', publishImageSelectPageIcon='" + this.f395613h + "', publishImageSelectPageCopywriting='" + this.f395614i + "'}";
    }
}
