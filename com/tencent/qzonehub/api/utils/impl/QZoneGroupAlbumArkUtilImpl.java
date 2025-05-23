package com.tencent.qzonehub.api.utils.impl;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.groupalbum.bean.init.GroupUploadAlbumInitBean;
import com.qzone.util.ToastUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.kernel.api.g;
import com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceGetQunRightCallback;
import com.tencent.qqnt.kernel.nativeinterface.NTGetQunRightReq;
import com.tencent.qqnt.kernel.nativeinterface.NTGetQunRightRsp;
import com.tencent.qqnt.kernel.nativeinterface.QunMediaRightEnum;
import com.tencent.qzonehub.api.IQZoneRouteApi;
import com.tencent.qzonehub.api.utils.IQZoneGroupAlbumArkUtil;
import com.tencent.qzonehub.api.utils.impl.QZoneGroupAlbumArkUtilImpl;
import com.tencent.xaction.log.b;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import fj.r;
import ho.i;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import yo.f;

/* compiled from: P */
/* loaded from: classes34.dex */
public class QZoneGroupAlbumArkUtilImpl implements IQZoneGroupAlbumArkUtil {
    private static final String ACTION = "group_album_action";
    private static final String ACTION_JUMP_UPLOAD_ALBUM = "1";
    private static final String ALBUM_ID = "i";
    private static final String BATCH_ID = "p";
    private static final String CRATE_PREFIX_URL = "https://h5.qzone.qq.com/groupphoto/inqq/photo";
    private static final String DETAIL_PREFIX_URL = "https://h5.qzone.qq.com/groupphoto/inqq/detail";
    private static final String GROUP_ALBUM_APP_NAME = "com.tencent.qzone.albumShare";
    private static final String GROUP_ALBUM_BIZSRC_1 = "groupalbum.upload";
    private static final String GROUP_ALBUM_BIZSRC_2 = "groupalbum.interact";
    private static final String GROUP_ALBUM_BIZSRC_3 = "groupalbum.creatalbum";
    private static final String GROUP_ALBUM_PHOTO = "com.tencent.groupphoto";
    private static final long GROUP_APP_ID_1 = 101786420;
    private static final String GROUP_ID = "u";
    private static final long MIN_CLICK_TIME_MS = 2000;
    private static final String PHOTO_ID = "f";
    private static final String TAG = "QZoneGroupAlbumArkUtilImpl";
    private long mLastClickTimeMs = -1;

    private boolean handleCreateAlbumUrl(final Context context, String str) {
        if (!isCreateAlbumUrl(str)) {
            return false;
        }
        Matcher matcher = Pattern.compile("/groupphoto/inqq/photo/([^/]+)/([^/]+)/.*").matcher(str);
        final String str2 = "";
        final String str3 = "";
        while (matcher.find()) {
            str2 = matcher.group(1);
            str3 = matcher.group(2);
        }
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return false;
        }
        String string = f.e(str).getString(ACTION);
        if ("1".equalsIgnoreCase(string)) {
            long currentTimeMillis = System.currentTimeMillis();
            long j3 = this.mLastClickTimeMs;
            if (j3 != -1 && currentTimeMillis >= j3 && currentTimeMillis - j3 <= 2000) {
                return true;
            }
            this.mLastClickTimeMs = currentTimeMillis;
            requestUserRight(str2, new IAlbumServiceGetQunRightCallback() { // from class: gz3.b
                @Override // com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceGetQunRightCallback
                public final void onGetQunRight(NTGetQunRightRsp nTGetQunRightRsp) {
                    QZoneGroupAlbumArkUtilImpl.this.lambda$handleCreateAlbumUrl$0(context, str2, str3, nTGetQunRightRsp);
                }
            });
            return true;
        }
        StringBuilder sb5 = new StringBuilder("mqzone://arouse/groupalbum/");
        sb5.append("albumdetail");
        sb5.append(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
        sb5.append("groupid=");
        sb5.append(str2);
        sb5.append(ContainerUtils.FIELD_DELIMITER);
        sb5.append("albumid=");
        sb5.append(str3);
        sb5.append(ContainerUtils.FIELD_DELIMITER);
        sb5.append("action=");
        if (string == null) {
            string = "-1";
        }
        sb5.append(string);
        ((IQZoneRouteApi) QRoute.api(IQZoneRouteApi.class)).launchQZoneScheme(context, sb5.toString());
        return true;
    }

    private boolean handleDetailAlbumUrl(Context context, String str) {
        if (!isDetailAlbumUrl(str)) {
            return false;
        }
        Bundle e16 = f.e(str);
        String string = e16.getString("i");
        String string2 = e16.getString("u");
        String string3 = e16.getString("p");
        String string4 = e16.getString("f");
        StringBuilder sb5 = new StringBuilder("mqzone://arouse/groupalbum/");
        sb5.append("feeddetail");
        sb5.append(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
        sb5.append("groupid=");
        sb5.append(string2);
        sb5.append(ContainerUtils.FIELD_DELIMITER);
        sb5.append("albumid=");
        sb5.append(string);
        sb5.append(ContainerUtils.FIELD_DELIMITER);
        sb5.append("batchid=");
        sb5.append(string3);
        sb5.append(ContainerUtils.FIELD_DELIMITER);
        sb5.append("llocid=");
        if (string4 == null) {
            string4 = "";
        }
        sb5.append(string4);
        sb5.append(ContainerUtils.FIELD_DELIMITER);
        sb5.append("fromark=");
        sb5.append("1");
        ((IQZoneRouteApi) QRoute.api(IQZoneRouteApi.class)).launchQZoneScheme(context, sb5.toString());
        return true;
    }

    private boolean isCreateAlbumUrl(String str) {
        return str.startsWith(CRATE_PREFIX_URL);
    }

    private boolean isDetailAlbumUrl(String str) {
        return str.startsWith(DETAIL_PREFIX_URL);
    }

    private void jumpToUpLoadTask(Context context, String str, String str2) {
        CommonAlbumInfo commonAlbumInfo = new CommonAlbumInfo();
        commonAlbumInfo.V(str2);
        GroupUploadAlbumInitBean groupUploadAlbumInitBean = new GroupUploadAlbumInitBean(str, 0, true, commonAlbumInfo, 6);
        groupUploadAlbumInitBean.setFromArk(true);
        i.m().n(context, groupUploadAlbumInitBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleCreateAlbumUrl$0(Context context, String str, String str2, NTGetQunRightRsp nTGetQunRightRsp) {
        if (nTGetQunRightRsp.right.right.contains(Integer.valueOf(QunMediaRightEnum.KQUNMEDIARIGHTENUMUPLOADMEDIA.ordinal()))) {
            jumpToUpLoadTask(context, str, str2);
        } else {
            ToastUtil.o(R.string.f133135a, 4);
        }
    }

    private boolean matchNewPolicy(String str) {
        return GROUP_ALBUM_BIZSRC_1.equalsIgnoreCase(str) || GROUP_ALBUM_BIZSRC_2.equalsIgnoreCase(str) || GROUP_ALBUM_BIZSRC_3.equalsIgnoreCase(str);
    }

    private boolean matchOldPolicy(String str) {
        return GROUP_ALBUM_APP_NAME.equalsIgnoreCase(str) || GROUP_ALBUM_PHOTO.equalsIgnoreCase(str);
    }

    private boolean matchURL(String str) {
        return isCreateAlbumUrl(str) || isDetailAlbumUrl(str);
    }

    private void requestUserRight(String str, IAlbumServiceGetQunRightCallback iAlbumServiceGetQunRightCallback) {
        g b16 = r.b();
        if (b16 != null) {
            NTGetQunRightReq nTGetQunRightReq = new NTGetQunRightReq();
            nTGetQunRightReq.qunId = str;
            nTGetQunRightReq.requestTimeLine.requestInvokeTime = System.currentTimeMillis();
            b16.getQunRight(nTGetQunRightReq, iAlbumServiceGetQunRightCallback);
        }
    }

    private boolean shouldIntercept() {
        return ((IQZoneRouteApi) QRoute.api(IQZoneRouteApi.class)).isNewAIOGroupAlbumEnable();
    }

    @Override // com.tencent.qzonehub.api.utils.IQZoneGroupAlbumArkUtil
    public boolean handleGroupArkUrl(Context context, String str) {
        try {
            String decode = URLDecoder.decode(str, "UTF-8");
            if (handleCreateAlbumUrl(context, decode) || handleDetailAlbumUrl(context, decode)) {
                return true;
            }
            b.a(TAG, 1, "handleGroupArkUrl jumpUrl=" + str + " cannot handle");
            return false;
        } catch (UnsupportedEncodingException unused) {
            b.c(TAG, 1, "handleGroupArkUrl for decode error url:=" + str, new Throwable("handleGroupArkUrl"));
            return false;
        }
    }

    @Override // com.tencent.qzonehub.api.utils.IQZoneGroupAlbumArkUtil
    public boolean isFromGroupAlbumArk(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            return false;
        }
        return (matchOldPolicy(str) || matchNewPolicy(str2)) && matchURL(str3) && shouldIntercept();
    }

    @Override // com.tencent.qzonehub.api.utils.IQZoneGroupAlbumArkUtil
    public void jumpToGroupAlbumEntry(Context context, String str) {
        ((IQZoneRouteApi) QRoute.api(IQZoneRouteApi.class)).launchQZoneScheme(context, "mqzone://arouse/groupalbum/homealbum?groupid=" + str);
    }

    @Override // com.tencent.qzonehub.api.utils.IQZoneGroupAlbumArkUtil
    public boolean isFromShortcutUrl(long j3) {
        return j3 == GROUP_APP_ID_1 && shouldIntercept();
    }
}
