package com.tencent.mobileqq.activity.qqsettingme.config;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.qqsettingme.config.QQSettingMeBizBean;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import common.config.service.QZoneConfigHelper;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final QQSettingMeBizBean[] f184998a;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        QQSettingMeBizBean.b bVar = new QQSettingMeBizBean.b("\u8d85\u7ea7QQ\u79c0");
        QQSettingMeBizBean.ActionType actionType = QQSettingMeBizBean.ActionType.DEFAULT;
        this.f184998a = new QQSettingMeBizBean[]{new QQSettingMeBizBean("d_zplan", 1, bVar, R.drawable.qui_super_qq_show_vas, new QQSettingMeBizBean.a(actionType, ""), String.valueOf(BusinessInfoCheckUpdateItem.UIAPPID_DRAWER_ZPLAN), "em_drawer_superqqshow", true, true, false, false, false), new QQSettingMeBizBean("d_my_game", 2, new QQSettingMeBizBean.b("\u6211\u7684\u6e38\u620f"), R.drawable.qui_game, new QQSettingMeBizBean.a(actionType, ""), String.valueOf(BusinessInfoCheckUpdateItem.UIAPPID_MYGAME_DRAWER), "em_bas_my_game", true, true, false, false, false), new QQSettingMeBizBean("d_smallworld", 3, new QQSettingMeBizBean.b("\u6211\u7684\u5c0f\u4e16\u754c"), R.drawable.qui_small_world_vas, new QQSettingMeBizBean.a(actionType, ""), "", "", false, false, false, false, true), new QQSettingMeBizBean("d_vip_identity", 4, new QQSettingMeBizBean.b("\u5f00\u901a\u4f1a\u5458"), R.drawable.qui_super_member_vas, new QQSettingMeBizBean.a(actionType, ""), String.valueOf(BusinessInfoCheckUpdateItem.UIAPPID_SECOND_VIP), "em_drawer_super_member", true, true, true, false, true), new QQSettingMeBizBean("d_qqwallet", 5, new QQSettingMeBizBean.b("\u6211\u7684QQ\u94b1\u5305"), R.drawable.qui_wallet_vas, new QQSettingMeBizBean.a(actionType, ""), String.valueOf(100007), "em_drawer_qq_wallet", true, true, true, true, true), new QQSettingMeBizBean("d_financial", 6, new QQSettingMeBizBean.b("\u8d22\u5bcc\u5c0f\u91d1\u5e93"), R.drawable.qui_littlebank_vas, new QQSettingMeBizBean.a(actionType, ""), String.valueOf(BusinessInfoCheckUpdateItem.UIAPPID_FINANCIAL), "em_drawer_little_bank", true, true, true, true, true), new QQSettingMeBizBean("d_decoration", 7, new QQSettingMeBizBean.b("\u6211\u7684\u4e2a\u6027\u88c5\u626e"), R.drawable.qui_skin_vas, new QQSettingMeBizBean.a(actionType, ""), String.valueOf(100005), "em_drawer_dress", true, true, true, false, false), new QQSettingMeBizBean("d_intimate_space", 8, new QQSettingMeBizBean.b(QZoneConfigHelper.W()), R.drawable.qui_intimates_space_vas, new QQSettingMeBizBean.a(actionType, ""), String.valueOf(BusinessInfoCheckUpdateItem.UIAPPID_MY_INTIMATE_SPACE), "em_qz_chum_space_entry", true, true, true, false, false), new QQSettingMeBizBean("d_vip_card", 9, new QQSettingMeBizBean.b("\u514d\u6d41\u91cf"), R.drawable.qui_free_cellular_data_vas, new QQSettingMeBizBean.a(actionType, ""), String.valueOf(BusinessInfoCheckUpdateItem.UIAPPID_CUKING_CARD), "em_drawer_sim_card", true, true, true, false, false), new QQSettingMeBizBean("d_album", 12, new QQSettingMeBizBean.b("\u6211\u7684\u76f8\u518c"), R.drawable.qui_image_vas, new QQSettingMeBizBean.a(actionType, ""), String.valueOf(BusinessInfoCheckUpdateItem.UIAPPID_MY_PHOTO), "em_drawer_photo_album", true, true, true, true, true), new QQSettingMeBizBean("d_favorite", 11, new QQSettingMeBizBean.b("\u6211\u7684\u6536\u85cf"), R.drawable.qui_collection_vas, new QQSettingMeBizBean.a(actionType, ""), String.valueOf(BusinessInfoCheckUpdateItem.UIAPPID_QFAV), "em_drawer_favorites", true, true, true, true, true), new QQSettingMeBizBean("d_document", 13, new QQSettingMeBizBean.b("\u6211\u7684\u6587\u4ef6"), R.drawable.qui_floder_vas, new QQSettingMeBizBean.a(actionType, ""), String.valueOf(BusinessInfoCheckUpdateItem.UIAPPID_MYFILE), "em_drawer_files", true, true, true, true, true), new QQSettingMeBizBean("d_video", 14, new QQSettingMeBizBean.b("\u6211\u7684\u89c6\u9891"), R.drawable.qui_video_on_vas, new QQSettingMeBizBean.a(actionType, ""), "", "", false, false, false, false, false)};
    }

    public QQSettingMeBizBean[] a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (QQSettingMeBizBean[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f184998a;
    }
}
