package com.tencent.mobileqq.richmediabrowser.api.impl;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.api.IShortVideoDepend;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.j;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import cooperation.peak.PeakConstants;
import java.net.URL;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ShortVideoDependImpl implements IShortVideoDepend {
    @Override // com.tencent.mobileqq.richmediabrowser.api.IShortVideoDepend
    public void dealSendToFriend(Activity activity, Intent intent, String str, String str2, int i3, ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        if (intent != null) {
            if (!TextUtils.isEmpty(str)) {
                intent.putExtra(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM, str);
                intent.putExtra(PeakConstants.KEY_QQ_CAMERA_MATERIAL_NAME, str2);
            }
            if (i3 == 72) {
                intent.putExtra(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, 1);
                intent.putExtra("key_direct_show_uin_type", actionSheetItem.uinType);
                intent.putExtra("key_direct_show_uin", actionSheetItem.uin);
                ForwardBaseOption.startForwardActivityForResult(activity, intent, (Class<?>) ForwardRecentTranslucentActivity.class, 19005, BusinessInfoCheckUpdateItem.UIAPPID_CUKING_CARD, " biz_src_jc_video");
                return;
            }
            ForwardBaseOption.startForwardActivity(activity, intent, BusinessInfoCheckUpdateItem.UIAPPID_CUKING_CARD, " biz_src_jc_video");
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IShortVideoDepend
    public void dealSendToGuild(Activity activity, Intent intent, String str, String str2, int i3, ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        if (intent != null) {
            if (!TextUtils.isEmpty(str)) {
                intent.putExtra(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM, str);
                intent.putExtra(PeakConstants.KEY_QQ_CAMERA_MATERIAL_NAME, str2);
            }
            if (i3 == 171) {
                intent.putExtra(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, 1);
                intent.putExtra("key_direct_show_uin_type", actionSheetItem.uinType);
                intent.putExtra("key_direct_show_uin", actionSheetItem.uin);
                intent.putExtra("caller_name", activity.getClass().getSimpleName());
                intent.putExtra("forward_source_business_type", BusinessInfoCheckUpdateItem.UIAPPID_CUKING_CARD);
                intent.putExtra("forward_source_sub_business_type", " biz_src_jc_video");
                intent.putExtra("only_single_selection", true);
                ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).startQQGuildForwardGuildListFragment(activity, intent, 20000);
                return;
            }
            ForwardBaseOption.startForwardActivity(activity, intent, BusinessInfoCheckUpdateItem.UIAPPID_CUKING_CARD, " biz_src_jc_video");
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IShortVideoDepend
    public String getLocalShortVideoPath() {
        return ShortVideoUtils.getLocalShortVideoPath();
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IShortVideoDepend
    public String getShortVideoSavePath(MessageRecord messageRecord, String str) {
        if (messageRecord instanceof MessageForShortVideo) {
            return j.j((MessageForShortVideo) messageRecord, str);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IShortVideoDepend
    public URL getThumbUrl(String str) {
        return ShortVideoUtils.getThumbUrl(str);
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IShortVideoDepend
    public Runnable getVideoFileSaveRunnable(String str, MqqHandler mqqHandler, String str2, boolean z16) {
        return new ShortVideoUtils.VideoFileSaveRunnable(str, mqqHandler, str2, z16);
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IShortVideoDepend
    public int getVideoSaveFailCode() {
        return 1;
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IShortVideoDepend
    public int getVideoSaveSuccessCode() {
        return 2;
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IShortVideoDepend
    public boolean isAEPituTakeSameOpen() {
        return ShortVideoUtils.isAEPituTakeSameOpen();
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IShortVideoDepend
    public void reportVideoPlayEvent(int i3, String str, int i16, int i17, long j3, long j16) {
        ShortVideoUtils.reportVideoPlayEvent(null, i3, str, i16, i17, j3, j16);
    }
}
