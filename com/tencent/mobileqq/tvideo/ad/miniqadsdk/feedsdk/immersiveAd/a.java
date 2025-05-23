package com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.immersiveAd;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.tvideo.protocol.pb.AdActionButton;
import com.tencent.tvideo.protocol.pb.AdActionTitle;
import com.tencent.tvideo.protocol.pb.AdFeedHeaderInfo;
import com.tencent.tvideo.protocol.pb.AdFeedInfo;
import com.tencent.tvideo.protocol.pb.AdFloatCardEntity;
import com.tencent.tvideo.protocol.pb.AdFloatCardEntityType;
import com.tencent.tvideo.protocol.pb.AdFloatCardInfo;
import com.tencent.tvideo.protocol.pb.AdFloatCardStyle;
import com.tencent.tvideo.protocol.pb.AdOrderItem;
import com.tencent.tvideo.protocol.pb.AdPlayFinishMaskInfo;
import java.util.List;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    protected AdFeedInfo f304128a;

    public a(AdFeedInfo adFeedInfo) {
        this.f304128a = adFeedInfo;
    }

    public bx2.a a() {
        String str;
        bx2.a aVar = new bx2.a(m(), l(), o(), p());
        aVar.w(r());
        AdFloatCardInfo h16 = h();
        if (h16 != null) {
            aVar.p(h16.card_title);
            aVar.o(h16.card_subTitle);
            aVar.m(h16.card_image_url);
            aVar.n(h16.card_poster_url);
        }
        AdFeedHeaderInfo j3 = j();
        if (j3 != null) {
            aVar.r(j3.title);
            if (TextUtils.isEmpty(j3.sub_title)) {
                str = m();
            } else {
                str = j3.sub_title;
            }
            aVar.q(str);
        }
        aVar.u(n());
        aVar.k(f());
        aVar.h(c());
        aVar.i(i());
        s(aVar, h16);
        aVar.l(q());
        return aVar;
    }

    public com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedui.qqlive.qaduikit.feed.model.c b() {
        return com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedui.qqlive.qaduikit.feed.model.c.a(g(), r());
    }

    public abstract AdActionButton c();

    public abstract AdOrderItem d();

    public abstract int e();

    @Nullable
    public abstract List<String> f();

    public abstract AdPlayFinishMaskInfo g();

    public abstract AdFloatCardInfo h();

    public int i() {
        return 0;
    }

    public abstract AdFeedHeaderInfo j();

    public abstract int k();

    public abstract String l();

    public abstract String m();

    public abstract String n();

    public abstract String o();

    public abstract String p();

    public abstract boolean q();

    public abstract boolean r();

    protected bx2.a s(@NonNull bx2.a aVar, AdFloatCardInfo adFloatCardInfo) {
        if (adFloatCardInfo == null) {
            return aVar;
        }
        if (com.tencent.miniqadsdk.a.f151670a) {
            aVar.t(new AdFloatCardEntity.a().e("http://pgdt.gtimg.cn/gdt/0/EABlv-3ABQABQAAAAQyBjdKtXA2K2ViTE.jpg/0?ck=f61393eb5b976dbcd946583a81e14a6c").i("EF\u6559\u80b2").h("0\u57fa\u7840\u600e\u4e48\u5b66\u82f1\u8bed\uff1f\u4e0d\u8bb0\u5355\u8bcd\uff0c\u4e0d\u5b66\u8bed\u6cd5\uff0c\u6bcf\u59295\u5206\u949f\uff0c\u968f\u65f6\u968f\u5730\u5b66").g(AdFloatCardStyle.STYLE_IDLE_CARD_OPTIMIZATION).build());
            aVar.v(new AdFloatCardEntity.a().e("http://pgdt.gtimg.cn/gdt/0/EABlv-3ABQABQAAAAQyBjdKtXA2K2ViTE.jpg/0?ck=f61393eb5b976dbcd946583a81e14a6c").i("EF\u6559\u80b2").h("0\u57fa\u7840\u600e\u4e48\u5b66\u82f1\u8bed\uff1f\u4e0d\u8bb0\u5355\u8bcd\uff0c\u4e0d\u5b66\u8bed\u6cd5\uff0c\u6bcf\u59295\u5206\u949f\uff0c\u968f\u65f6\u968f\u5730\u5b66").g(AdFloatCardStyle.DEFAULT_STYLE).j(AdFloatCardEntityType.AD_FLOAT_CARD_TYPE_SMALL).a(new AdActionButton.a().a(new AdActionTitle.a().c("\u7acb\u5373\u9886\u53d6").b("http://dldir1.qq.com/qqmi/video_ad/new_jump_to_3x.png").build()).d(0).f("#0000ff").b("#ff0000").e("'#ff0000'").build()).d(false).build());
        }
        List<AdFloatCardEntity> list = adFloatCardInfo.card_entity;
        if (list != null && list.size() > 0) {
            for (AdFloatCardEntity adFloatCardEntity : adFloatCardInfo.card_entity) {
                if (adFloatCardEntity != null) {
                    AdFloatCardEntityType adFloatCardEntityType = adFloatCardEntity.card_type;
                    if (adFloatCardEntityType != AdFloatCardEntityType.AD_FLOAT_CARD_TYPE_IDLE && adFloatCardEntityType != null) {
                        if (adFloatCardEntityType == AdFloatCardEntityType.AD_FLOAT_CARD_TYPE_SMALL) {
                            aVar.v(adFloatCardEntity);
                        } else if (adFloatCardEntityType == AdFloatCardEntityType.AD_FLOAT_CARD_TYPE_BIG) {
                            aVar.j(adFloatCardEntity);
                        }
                    } else {
                        aVar.t(adFloatCardEntity);
                    }
                }
            }
        }
        aVar.s(adFloatCardInfo.horizontal_card_entity);
        return aVar;
    }
}
