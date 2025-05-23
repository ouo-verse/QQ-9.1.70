package com.qzone.reborn.feedx.widget.dragon;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.qzone.feed.business.model.FeedResourceInfo;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.reborn.feedx.bean.QZoneDragonUserInfo;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.service.qzone.e;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.QZonePushReporter;
import fo.c;
import ho.i;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H$J\u0010\u0010\n\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\bJ&\u0010\u0011\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0004J\u0012\u0010\u0013\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0004J\b\u0010\u0014\u001a\u00020\u0003H\u0004J\b\u0010\u0015\u001a\u00020\u0005H\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001f"}, d2 = {"Lcom/qzone/reborn/feedx/widget/dragon/QZoneFeedHeadBaseDragonView;", "Lcom/qzone/reborn/widget/QZoneBaseWidgetView;", "Lcom/qzone/reborn/feedx/bean/QZoneDragonUserInfo;", "", "q0", "", "n0", "getLogTag", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "setFeedData", "Landroid/widget/ImageView;", "imageIcon", "Lcom/qzone/feed/business/model/FeedResourceInfo;", "resInfo", "Lcom/tencent/libra/listener/IPicLoadStateListener;", "listener", "p0", "jumpUrlRes", "o0", "r0", "m0", "e", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "mFeedData", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class QZoneFeedHeadBaseDragonView extends QZoneBaseWidgetView<QZoneDragonUserInfo> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private BusinessFeedData mFeedData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneFeedHeadBaseDragonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final String n0() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("dragon_level", getData().getGrade());
        jSONObject.put("dragon_type", m0());
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
        return jSONObject2;
    }

    private final void q0() {
        User user;
        HashMap hashMap = new HashMap();
        hashMap.put(QZonePushReporter.EVENT_CODE_TYPE1, "ev_qz_feed_tap_icon");
        BusinessFeedData businessFeedData = this.mFeedData;
        hashMap.put("touin", Long.valueOf((businessFeedData == null || (user = businessFeedData.getUser()) == null) ? 0L : user.uin));
        hashMap.put(QZonePushReporter.EVENT_VALUE, n0());
        c.c("ev_qz_feed_tap_icon_click", hashMap);
    }

    protected abstract String getLogTag();

    public String m0() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void o0(String jumpUrlRes) {
        if (TextUtils.isEmpty(jumpUrlRes)) {
            QLog.e(getLogTag(), 1, "[handleClickSelectButton] jumpUrlRes is " + jumpUrlRes);
            return;
        }
        String a16 = e.f286406a.a(jumpUrlRes);
        if (TextUtils.isEmpty(a16)) {
            QLog.e(getLogTag(), 1, "[handleClickSelectButton] schema is " + a16);
            return;
        }
        i.q(getContext(), a16);
        q0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void r0() {
        User user;
        HashMap hashMap = new HashMap();
        hashMap.put(QZonePushReporter.EVENT_CODE_TYPE1, "ev_qz_feed_tap_icon");
        BusinessFeedData businessFeedData = this.mFeedData;
        hashMap.put("touin", Long.valueOf((businessFeedData == null || (user = businessFeedData.getUser()) == null) ? 0L : user.uin));
        hashMap.put(QZonePushReporter.EVENT_VALUE, n0());
        c.c("ev_qz_feed_tap_icon_imp", hashMap);
    }

    public final void setFeedData(BusinessFeedData feedData) {
        this.mFeedData = feedData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void p0(ImageView imageIcon, FeedResourceInfo resInfo, IPicLoadStateListener listener) {
        String sourceMaterialUrl = resInfo != null ? resInfo.getSourceMaterialUrl() : null;
        if (TextUtils.isEmpty(sourceMaterialUrl)) {
            QLog.e(getLogTag(), 4, "[loadImageIcon] resInfo is null");
        } else {
            com.tencent.mobileqq.qzone.picload.c.a().i(Option.obtain().setUrl(sourceMaterialUrl).setTargetView(imageIcon).setLoadingDrawableId(R.drawable.trans).setFailedDrawableColor(R.drawable.trans), listener);
        }
    }
}
