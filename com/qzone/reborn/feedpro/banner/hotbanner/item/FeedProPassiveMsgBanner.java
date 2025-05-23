package com.qzone.reborn.feedpro.banner.hotbanner.item;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.qzone.reborn.feedpro.banner.hotbanner.constant.FeedProHotBannerType;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ArrayUtils;
import ef.d;
import ho.i;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ld.a;
import ld.b;
import tl.h;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b*\u0010+J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\"\u0010\u000f\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001a\u0010\u0015\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0014J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0018\u001a\u00020\u0013H\u0016J\b\u0010\u0019\u001a\u00020\u000bH\u0016J\u0012\u0010\u001b\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u001c\u001a\u00020\u0013H\u0016J\u001a\u0010\u001e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001d\u001a\u00020\u0013H\u0014R\u0018\u0010!\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010#\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010 R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006,"}, d2 = {"Lcom/qzone/reborn/feedpro/banner/hotbanner/item/FeedProPassiveMsgBanner;", "Lcom/qzone/reborn/feedpro/banner/hotbanner/item/FeedProBaseHotBanner;", "Landroid/view/View;", "view", "", "u0", "Lld/b;", "bannerData", "w0", "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "avatarIv", "", "isVisible", "", "uin", "v0", "x0", "Landroid/content/Context;", "context", "", "viewType", "initView", "Lcom/qzone/reborn/feedpro/banner/hotbanner/constant/FeedProHotBannerType;", "n0", "m0", "r0", "v", "o0", "getLayoutId", c.G, "s0", "e", "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "avatarIv1", "f", "avatarIv2", h.F, "avatarIv3", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "bannerTv", "<init>", "(Landroid/content/Context;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class FeedProPassiveMsgBanner extends FeedProBaseHotBanner {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QZoneUserAvatarView avatarIv1;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QZoneUserAvatarView avatarIv2;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private QZoneUserAvatarView avatarIv3;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView bannerTv;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedProPassiveMsgBanner(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void w0(b bannerData) {
        List<a> c16 = bannerData.c();
        if (ArrayUtils.isOutOfArrayIndex(0, c16)) {
            QLog.e("BaseWidgetView", 1, "user list is empty");
            return;
        }
        Intrinsics.checkNotNull(c16);
        int size = c16.size();
        if (size == 1) {
            v0(this.avatarIv1, true, d.k(c16.get(0).getUin()));
            v0(this.avatarIv2, false, 0L);
            v0(this.avatarIv3, false, 0L);
        } else if (size != 2) {
            v0(this.avatarIv1, true, d.k(c16.get(0).getUin()));
            v0(this.avatarIv2, true, d.k(c16.get(1).getUin()));
            v0(this.avatarIv3, true, d.k(c16.get(2).getUin()));
        } else {
            v0(this.avatarIv1, true, d.k(c16.get(0).getUin()));
            v0(this.avatarIv2, true, d.k(c16.get(1).getUin()));
            v0(this.avatarIv3, false, 0L);
        }
    }

    private final void x0(b bannerData) {
        TextView textView = this.bannerTv;
        if (textView == null) {
            return;
        }
        textView.setText(bannerData.getBannerText());
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f1301883;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public void initView(Context context, int viewType) {
        super.initView(context, viewType);
        this.avatarIv1 = (QZoneUserAvatarView) findViewById(R.id.f206892);
        this.avatarIv2 = (QZoneUserAvatarView) findViewById(R.id.f206993);
        this.avatarIv3 = (QZoneUserAvatarView) findViewById(R.id.f207094);
        this.bannerTv = (TextView) findViewById(R.id.b0w);
        u0(this);
    }

    @Override // com.qzone.reborn.feedpro.banner.hotbanner.item.FeedProBaseHotBanner
    public int m0() {
        return 2;
    }

    @Override // com.qzone.reborn.feedpro.banner.hotbanner.item.FeedProBaseHotBanner
    public FeedProHotBannerType n0() {
        return FeedProHotBannerType.TYPE_PASSIVE_MSG_BANNER;
    }

    @Override // com.qzone.reborn.feedpro.banner.hotbanner.item.FeedProBaseHotBanner
    public void o0(View v3) {
        fl.a u16 = i.u();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        u16.a(context, "getActiveFeeds", 1);
    }

    @Override // com.qzone.reborn.feedpro.banner.hotbanner.item.FeedProBaseHotBanner
    public boolean r0() {
        return true;
    }

    private final void u0(View view) {
        if (view != null) {
            fo.c.o(view, "em_qz_massage_notice_bubble", new fo.b());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: s0, reason: merged with bridge method [inline-methods] */
    public void bindData(b bannerData, int pos) {
        if (bannerData != null) {
            w0(bannerData);
            x0(bannerData);
        }
    }

    private final void v0(QZoneUserAvatarView avatarIv, boolean isVisible, long uin) {
        if (avatarIv != null) {
            avatarIv.setIsShieldJumpToMainPage(true);
        }
        if (!isVisible) {
            if (avatarIv == null) {
                return;
            }
            avatarIv.setVisibility(8);
        } else {
            if (avatarIv != null) {
                avatarIv.setUser(uin);
            }
            if (avatarIv == null) {
                return;
            }
            avatarIv.setVisibility(0);
        }
    }
}
