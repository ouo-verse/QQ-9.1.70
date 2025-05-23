package com.tencent.av.share.api;

import android.content.Intent;
import android.view.View;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.utils.ax;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IShareChatApi extends QRouteApi {
    public static final String GAV_ARK_APP_NAME = "com.tencent.qqavchat";
    public static final String GAV_ARK_FROM_CHATTING = "gav_ark_share_from_chatting";
    public static final String GAV_ARK_FROM_INVITE = "gav_ark_share_from_invite";
    public static final String GAV_ARK_FROM_TYPE = "gav_ark_from_type";
    public static final String GAV_ARK_GROUP_ADMIN_KEY = "gav_ark_group_admin_key";
    public static final String GAV_ARK_GROUP_CARD_KEY = "gav_ark_group_card_key";
    public static final String GAV_ARK_GROUP_NAME_KEY = "gav_ark_group_name_key";
    public static final String GAV_ARK_GROUP_OWNER_KEY = "gav_ark_group_owner_key";
    public static final String GAV_ARK_GROUP_UIN_KEY = "gav_ark_group_uin_key";
    public static final String GAV_ARK_ROOM_CREATE_TIME_KEY = "gav_ark_room_create_time_key";
    public static final String GAV_ARK_ROOM_ID_KEY = "gav_ark_room_id_key";
    public static final String GAV_META_CHILD_KEY = "news";

    int getLinkTypeNeedVerify();

    int getLinkTypeNoVerify();

    boolean jump(ax axVar);

    void share(BaseQQAppInterface baseQQAppInterface, QBaseActivity qBaseActivity, View view, Intent intent);

    boolean shareGAVArkMsg(BaseQQAppInterface baseQQAppInterface, String str, String str2, int i3, String str3);
}
