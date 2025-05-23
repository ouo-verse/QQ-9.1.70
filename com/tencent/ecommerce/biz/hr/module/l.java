package com.tencent.ecommerce.biz.hr.module;

import android.graphics.Rect;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.scroll.HippyHeaderListViewController;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001\u0003B\u0087\u0001\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\"\u001a\u00020\u001f\u0012\b\b\u0002\u0010&\u001a\u00020#\u00a2\u0006\u0004\b'\u0010(R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\r\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\bR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0003\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\bR\u0014\u0010\u0016\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\bR\u0014\u0010\u0018\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\bR\u0014\u0010\u001a\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0004R\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006*"}, d2 = {"Lcom/tencent/ecommerce/biz/hr/module/l;", "", "", "a", "I", "shareType", "", "b", "Ljava/lang/String;", "arkJson", "c", "title", "d", "desc", "", "e", "Ljava/util/List;", "()Ljava/util/List;", "imageUrls", "f", "shareUrl", "g", "qzoneComment", tl.h.F, "qzoneThirdPartyAppId", "i", HippyHeaderListViewController.VIEW_TAG, "Landroid/graphics/Rect;", "j", "Landroid/graphics/Rect;", "clipArea", "", "k", UserInfo.SEX_FEMALE, "scale", "", "l", "Z", "useQCircleWxShare", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILandroid/graphics/Rect;FZ)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final int shareType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final String arkJson;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final String title;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final String desc;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final List<String> imageUrls;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final String shareUrl;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final String qzoneComment;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final String qzoneThirdPartyAppId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final int viewTag;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final Rect clipArea;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public final float scale;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public final boolean useQCircleWxShare;

    public l(int i3, String str, String str2, String str3, List<String> list, String str4, String str5, String str6, int i16, Rect rect, float f16, boolean z16) {
        this.shareType = i3;
        this.arkJson = str;
        this.title = str2;
        this.desc = str3;
        this.imageUrls = list;
        this.shareUrl = str4;
        this.qzoneComment = str5;
        this.qzoneThirdPartyAppId = str6;
        this.viewTag = i16;
        this.clipArea = rect;
        this.scale = f16;
        this.useQCircleWxShare = z16;
    }

    public final List<String> a() {
        return this.imageUrls;
    }
}
