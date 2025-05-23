package com.qzone.reborn.feedpro.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.qzone.reborn.feedpro.layer.router.QzoneFeedProLayerExtraInfoBean;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellCommon;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellOperation;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonOperationForwardToQzoneInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonOperationShareOutInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonShareAccessResourceInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.QzoneBitCheckUtil;
import com.tencent.kuikly.core.render.android.css.ktx.KRCSSViewExtensionKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.util.QQToastUtil;
import common.config.service.QzoneConfig;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PhotoParam;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b2\u00103J\f\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u0002J\f\u0010\u0005\u001a\u0004\u0018\u00010\u0003*\u00020\u0002J\u0012\u0010\t\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\n*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J.\u0010\u0014\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010J\u001e\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015J\u0018\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001c\u001a\u00020\u001bJ\u0018\u0010\"\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010!\u001a\u00020\u0018J\u0018\u0010%\u001a\u00020\u001d2\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010!\u001a\u00020\u0018J\u0010\u0010&\u001a\u00020\u00032\b\u0010$\u001a\u0004\u0018\u00010#J\u0010\u0010'\u001a\u00020\u00032\b\u0010$\u001a\u0004\u0018\u00010#J\"\u0010,\u001a\u00020\u00132\u0006\u0010)\u001a\u00020(2\b\u0010+\u001a\u0004\u0018\u00010*2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015J\u0018\u0010.\u001a\u00020\u00132\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010-\u001a\u00020\u0003J\u0018\u00101\u001a\u00020\u00032\b\u0010/\u001a\u0004\u0018\u00010\u00032\u0006\u00100\u001a\u00020\u0003\u00a8\u00064"}, d2 = {"Lcom/qzone/reborn/feedpro/utils/ao;", "", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "", "p", "o", "Lcom/qzone/reborn/feedpro/layer/router/QzoneFeedProLayerExtraInfoBean;", "extraInfo", "Lcooperation/qzone/model/PhotoInfo;", "k", "Lcooperation/qzone/model/PhotoParam;", "l", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "title", "content", "Landroid/content/DialogInterface$OnClickListener;", "onPositiveButtonClickListener", "onCancelButtonClickListener", "", "r", "", "bizData", "Lkotlin/Pair;", "", "c", "oldLink", "Landroid/content/Context;", "context", "", "e", "Lge/h;", "itemBean", "mask", "f", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "feed", "d", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", "Lcom/qzone/reborn/share/e;", "shareContext", "Lcom/tencent/mobileqq/sharepanel/o;", "callback", "g", "actionId", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "uin", "serviceNick", DomainData.DOMAIN_NAME, "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class ao {

    /* renamed from: a, reason: collision with root package name */
    public static final ao f54312a = new ao();

    ao() {
    }

    public final boolean e(String oldLink, Context context) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        if (oldLink == null || oldLink.length() == 0) {
            return false;
        }
        try {
            str = URLDecoder.decode(oldLink, "UTF-8");
            Intrinsics.checkNotNullExpressionValue(str, "decode(oldLink, \"UTF-8\")");
        } catch (Exception e16) {
            QLog.e("QzoneFeedProShareUtils", 1, "decode exception is " + e16);
            str = "";
        }
        QLog.i("QzoneFeedProShareUtils", 1, "launchScheme: " + str);
        if (!HttpUtil.isValidUrl(str)) {
            return false;
        }
        yo.d.c(str, context);
        QLog.i("QzoneFeedProShareUtils", 1, "launch url: " + str);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0082, code lost:
    
        r11.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0085, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void g(com.qzone.reborn.share.e shareContext, final com.tencent.mobileqq.sharepanel.o callback, byte[] bizData) {
        String stackTraceToString;
        String a16;
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        if (bizData != null) {
            if (!(bizData.length == 0)) {
                try {
                    Charset UTF_8 = StandardCharsets.UTF_8;
                    Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                    String str = new String(bizData, UTF_8);
                    if (!(str.length() == 0) && !Intrinsics.areEqual(str, "null")) {
                        JSONObject k06 = KRCSSViewExtensionKt.k0(str);
                        boolean optBoolean = k06.optBoolean("need_break", false);
                        JSONObject optJSONObject = k06.optJSONObject("tips");
                        if (optJSONObject == null || (a16 = optJSONObject.optString("content", com.qzone.util.l.a(R.string.ke_))) == null) {
                            a16 = com.qzone.util.l.a(R.string.ke_);
                        }
                        String content = a16;
                        if (optBoolean) {
                            Activity activity = shareContext.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String();
                            Intrinsics.checkNotNullExpressionValue(content, "content");
                            r(activity, "", content, new DialogInterface.OnClickListener() { // from class: com.qzone.reborn.feedpro.utils.am
                                @Override // android.content.DialogInterface.OnClickListener
                                public final void onClick(DialogInterface dialogInterface, int i3) {
                                    ao.h(com.tencent.mobileqq.sharepanel.o.this, dialogInterface, i3);
                                }
                            }, new DialogInterface.OnClickListener() { // from class: com.qzone.reborn.feedpro.utils.an
                                @Override // android.content.DialogInterface.OnClickListener
                                public final void onClick(DialogInterface dialogInterface, int i3) {
                                    ao.i(com.tencent.mobileqq.sharepanel.o.this, dialogInterface, i3);
                                }
                            });
                            return;
                        } else {
                            if (callback != null) {
                                callback.b();
                                return;
                            }
                            return;
                        }
                    }
                    return;
                } catch (Exception e16) {
                    stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e16);
                    QLog.e("QzoneFeedProDetailShareRecentAndMoreQQAction", 1, stackTraceToString);
                    if (callback != null) {
                        callback.a();
                        return;
                    }
                    return;
                }
            }
        }
        if (callback != null) {
            callback.b();
        }
    }

    public final PhotoInfo k(RFWLayerItemMediaInfo rFWLayerItemMediaInfo, QzoneFeedProLayerExtraInfoBean extraInfo) {
        RFWLayerPicInfo.RFWPicInfo originPicInfo;
        RFWLayerPicInfo.RFWPicInfo bigPicInfo;
        RFWLayerPicInfo.RFWPicInfo currentPicInfo;
        Intrinsics.checkNotNullParameter(rFWLayerItemMediaInfo, "<this>");
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        PhotoInfo photoInfo = new PhotoInfo();
        photoInfo.albumId = extraInfo.getAlbumId();
        photoInfo.lloc = extraInfo.getLLoc();
        RFWLayerPicInfo layerPicInfo = rFWLayerItemMediaInfo.getLayerPicInfo();
        String str = null;
        photoInfo.currentUrl = (layerPicInfo == null || (currentPicInfo = layerPicInfo.getCurrentPicInfo()) == null) ? null : currentPicInfo.getUrl();
        RFWLayerPicInfo layerPicInfo2 = rFWLayerItemMediaInfo.getLayerPicInfo();
        photoInfo.bigUrl = (layerPicInfo2 == null || (bigPicInfo = layerPicInfo2.getBigPicInfo()) == null) ? null : bigPicInfo.getUrl();
        RFWLayerPicInfo layerPicInfo3 = rFWLayerItemMediaInfo.getLayerPicInfo();
        if (layerPicInfo3 != null && (originPicInfo = layerPicInfo3.getOriginPicInfo()) != null) {
            str = originPicInfo.getUrl();
        }
        photoInfo.orgUrl = str;
        return photoInfo;
    }

    public final PhotoParam l(RFWLayerItemMediaInfo rFWLayerItemMediaInfo, QzoneFeedProLayerExtraInfoBean extraInfo) {
        Intrinsics.checkNotNullParameter(rFWLayerItemMediaInfo, "<this>");
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        return null;
    }

    public final String n(String uin, String serviceNick) {
        Intrinsics.checkNotNullParameter(serviceNick, "serviceNick");
        boolean z16 = true;
        if (uin == null || uin.length() == 0) {
            return serviceNick;
        }
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(uin);
        if (uidFromUin == null || uidFromUin.length() == 0) {
            return serviceNick;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(uidFromUin);
        ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> friendSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendSimpleInfoWithUid(arrayList, "QzoneFeedPro");
        if (friendSimpleInfoWithUid == null || friendSimpleInfoWithUid.isEmpty()) {
            return serviceNick;
        }
        String p16 = friendSimpleInfoWithUid.get(0).p();
        if (p16 != null && p16.length() != 0) {
            z16 = false;
        }
        if (z16) {
            return serviceNick;
        }
        String p17 = friendSimpleInfoWithUid.get(0).p();
        Intrinsics.checkNotNull(p17);
        return p17;
    }

    public final String o(RFWLayerItemMediaInfo rFWLayerItemMediaInfo) {
        RFWLayerPicInfo.RFWPicInfo currentPicInfo;
        RFWLayerPicInfo.RFWPicInfo bigPicInfo;
        RFWLayerPicInfo.RFWPicInfo originPicInfo;
        Intrinsics.checkNotNullParameter(rFWLayerItemMediaInfo, "<this>");
        String str = null;
        if (rFWLayerItemMediaInfo.isVideo() || rFWLayerItemMediaInfo.getLayerPicInfo() == null) {
            return null;
        }
        RFWLayerPicInfo layerPicInfo = rFWLayerItemMediaInfo.getLayerPicInfo();
        String url = (layerPicInfo == null || (originPicInfo = layerPicInfo.getOriginPicInfo()) == null) ? null : originPicInfo.getUrl();
        if (TextUtils.isEmpty(url)) {
            RFWLayerPicInfo layerPicInfo2 = rFWLayerItemMediaInfo.getLayerPicInfo();
            url = (layerPicInfo2 == null || (bigPicInfo = layerPicInfo2.getBigPicInfo()) == null) ? null : bigPicInfo.getUrl();
        }
        if (!TextUtils.isEmpty(url)) {
            return url;
        }
        RFWLayerPicInfo layerPicInfo3 = rFWLayerItemMediaInfo.getLayerPicInfo();
        if (layerPicInfo3 != null && (currentPicInfo = layerPicInfo3.getCurrentPicInfo()) != null) {
            str = currentPicInfo.getUrl();
        }
        return str;
    }

    public final String p(RFWLayerItemMediaInfo rFWLayerItemMediaInfo) {
        RFWLayerPicInfo.RFWPicInfo originPicInfo;
        RFWLayerPicInfo.RFWPicInfo bigPicInfo;
        RFWLayerPicInfo.RFWPicInfo currentPicInfo;
        Intrinsics.checkNotNullParameter(rFWLayerItemMediaInfo, "<this>");
        String str = null;
        if (rFWLayerItemMediaInfo.isVideo() || rFWLayerItemMediaInfo.getLayerPicInfo() == null) {
            return null;
        }
        RFWLayerPicInfo layerPicInfo = rFWLayerItemMediaInfo.getLayerPicInfo();
        String url = (layerPicInfo == null || (currentPicInfo = layerPicInfo.getCurrentPicInfo()) == null) ? null : currentPicInfo.getUrl();
        if (TextUtils.isEmpty(url)) {
            RFWLayerPicInfo layerPicInfo2 = rFWLayerItemMediaInfo.getLayerPicInfo();
            url = (layerPicInfo2 == null || (bigPicInfo = layerPicInfo2.getBigPicInfo()) == null) ? null : bigPicInfo.getUrl();
        }
        if (!TextUtils.isEmpty(url)) {
            return url;
        }
        RFWLayerPicInfo layerPicInfo3 = rFWLayerItemMediaInfo.getLayerPicInfo();
        if (layerPicInfo3 != null && (originPicInfo = layerPicInfo3.getOriginPicInfo()) != null) {
            str = originPicInfo.getUrl();
        }
        return str;
    }

    public final void q(CommonFeed feed, String actionId) {
        CommonCellOperation cellOperation;
        CommonOperationShareOutInfo shareOutside;
        String shareOutButtonToast;
        CommonCellOperation cellOperation2;
        CommonOperationForwardToQzoneInfo forwardToQzone;
        Intrinsics.checkNotNullParameter(actionId, "actionId");
        String str = "";
        if (!Intrinsics.areEqual(actionId, "qzoneshuoshuo") ? !(feed == null || (cellOperation = feed.getCellOperation()) == null || (shareOutside = cellOperation.getShareOutside()) == null || (shareOutButtonToast = shareOutside.getShareOutButtonToast()) == null) : !(feed == null || (cellOperation2 = feed.getCellOperation()) == null || (forwardToQzone = cellOperation2.getForwardToQzone()) == null || (shareOutButtonToast = forwardToQzone.getForwardButtonToast()) == null)) {
            str = shareOutButtonToast;
        }
        if (str.length() == 0) {
            str = com.qzone.util.l.a(R.string.f169532jn4);
        }
        QQToastUtil.showQQToastInUiThread(4, str);
    }

    public final void r(Activity activity, String title, String content, DialogInterface.OnClickListener onPositiveButtonClickListener, DialogInterface.OnClickListener onCancelButtonClickListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(onPositiveButtonClickListener, "onPositiveButtonClickListener");
        Intrinsics.checkNotNullParameter(onCancelButtonClickListener, "onCancelButtonClickListener");
        if (title.length() == 0) {
            title = com.qzone.util.l.a(R.string.kr9);
        }
        String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogSharing", "\u7ee7\u7eed\u5206\u4eab");
        QQCustomDialog qQCustomDialog = new QQCustomDialog(activity, R.style.qZoneInputDialog);
        qQCustomDialog.setContentView(R.layout.custom_dialog);
        qQCustomDialog.setTitle(title);
        qQCustomDialog.setMessage(content);
        qQCustomDialog.setPositiveButton(config, onPositiveButtonClickListener);
        qQCustomDialog.setNegativeButton(com.qzone.util.l.a(R.string.j6l), onCancelButtonClickListener);
        qQCustomDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(com.tencent.mobileqq.sharepanel.o oVar, DialogInterface dialogInterface, int i3) {
        if (oVar != null) {
            oVar.b();
        }
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(com.tencent.mobileqq.sharepanel.o oVar, DialogInterface dialogInterface, int i3) {
        if (oVar != null) {
            oVar.a();
        }
        dialogInterface.dismiss();
    }

    public final boolean d(CommonFeed feed, int mask) {
        CommonCellCommon cellCommon;
        if (feed == null || (cellCommon = feed.getCellCommon()) == null) {
            return false;
        }
        long operateMask = cellCommon.getOperateMask();
        boolean checkBitEnabled = QzoneBitCheckUtil.INSTANCE.checkBitEnabled(operateMask, mask);
        QLog.i("QzoneFeedProShareUtils", 2, "opMask:" + operateMask + ",mask:" + mask + ",permission:" + checkBitEnabled);
        return checkBitEnabled;
    }

    public final boolean f(ge.h itemBean, int mask) {
        ge.i defaultItemBean;
        QzoneFeedProLayerExtraInfoBean extraInfo;
        if (itemBean == null || (defaultItemBean = itemBean.getDefaultItemBean()) == null || (extraInfo = defaultItemBean.getExtraInfo()) == null) {
            return false;
        }
        return extraInfo.j().contains(Integer.valueOf(mask));
    }

    public final String j(CommonFeed feed) {
        CommonCellOperation cellOperation;
        CommonOperationShareOutInfo shareOutside;
        CommonShareAccessResourceInfo shareAccessResource;
        String busiId;
        return (feed == null || (cellOperation = feed.getCellOperation()) == null || (shareOutside = cellOperation.getShareOutside()) == null || (shareAccessResource = shareOutside.getShareAccessResource()) == null || (busiId = shareAccessResource.getBusiId()) == null) ? "" : busiId;
    }

    public final String m(CommonFeed feed) {
        CommonCellOperation cellOperation;
        CommonOperationShareOutInfo shareOutside;
        CommonShareAccessResourceInfo shareAccessResource;
        String resourceId;
        return (feed == null || (cellOperation = feed.getCellOperation()) == null || (shareOutside = cellOperation.getShareOutside()) == null || (shareAccessResource = shareOutside.getShareAccessResource()) == null || (resourceId = shareAccessResource.getResourceId()) == null) ? "" : resourceId;
    }

    public final Pair<Integer, String> c(byte[] bizData) {
        String stackTraceToString;
        if (bizData != null) {
            if (!(bizData.length == 0)) {
                try {
                    Charset UTF_8 = StandardCharsets.UTF_8;
                    Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                    String str = new String(bizData, UTF_8);
                    if (!(str.length() == 0) && !Intrinsics.areEqual(str, "null")) {
                        JSONObject k06 = KRCSSViewExtensionKt.k0(str);
                        return new Pair<>(Integer.valueOf(k06.optInt(CheckForwardServlet.KEY_ERR_CODE, 0)), k06.optString("err_msg", ""));
                    }
                    return null;
                } catch (Exception e16) {
                    stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e16);
                    QLog.e("QzoneFeedProShareUtils", 1, stackTraceToString);
                }
            }
        }
        return null;
    }
}
