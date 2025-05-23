package com.tencent.mobileqq.activity.qqsettingme.config;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.qqsettingme.config.QQSettingMeBizBean;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import common.config.service.QZoneConfigHelper;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes10.dex */
public class QQSettingMeMenuConfigBeanV3 {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final String f184993a;

    /* renamed from: b, reason: collision with root package name */
    private Map<String, String> f184994b;

    /* renamed from: c, reason: collision with root package name */
    private final QQSettingMeBizBean[] f184995c;

    /* renamed from: d, reason: collision with root package name */
    private final HashMap<String, QQSettingMeBizBean> f184996d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a extends TypeToken<List<List<String>>> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingMeMenuConfigBeanV3.this);
            }
        }
    }

    public QQSettingMeMenuConfigBeanV3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f184993a = "[\n    [\"d_album\", \"d_favorite\", \"d_document\", \"d_qqwallet\" , \"d_financial\" ,\"d_vip_identity\", \"d_decoration\" ]\n,    [\"d_vip_card\"]]";
        this.f184994b = new HashMap<String, String>() { // from class: com.tencent.mobileqq.activity.qqsettingme.config.QQSettingMeMenuConfigBeanV3.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeMenuConfigBeanV3.this);
                    return;
                }
                put("d_vip_identity", "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/chouti/qecommerce_drawer_super_member.png");
                put("d_qqwallet", "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/chouti/qecommerce_drawer_wallet.png");
                put("d_decoration", "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/chouti/qecommerce_drawer_skin.png");
                put("d_album", "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/chouti/qecommerce_drawer_photo.png");
                put("d_favorite", "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/chouti/qecommerce_drawer_collection.png");
                put("d_document", "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/chouti/qecommerce_drawer_folder.png");
                put("d_financial", "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/chouti/qecommerce_drawer_littlebank.png");
                put("d_vip_card", "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/chouti/qecommerce_drawer_free_cellular_data_colour.png");
            }
        };
        QQSettingMeBizBean.b bVar = new QQSettingMeBizBean.b(QzoneConfig.DefaultValue.DEFAULT_HOME_PAGE_ALBUM_TITLE);
        QQSettingMeBizBean.ActionType actionType = QQSettingMeBizBean.ActionType.DEFAULT;
        QQSettingMeBizBean[] qQSettingMeBizBeanArr = {new QQSettingMeBizBean("d_album", 12, bVar, R.drawable.qui_image_vas, new QQSettingMeBizBean.a(actionType, ""), String.valueOf(BusinessInfoCheckUpdateItem.UIAPPID_MY_PHOTO), "em_drawer_photo_album", true, true, true, true, true), new QQSettingMeBizBean("d_favorite", 11, new QQSettingMeBizBean.b("\u6536\u85cf"), R.drawable.qui_collection_vas, new QQSettingMeBizBean.a(actionType, ""), String.valueOf(BusinessInfoCheckUpdateItem.UIAPPID_QFAV), "em_drawer_favorites", true, true, true, true, true), new QQSettingMeBizBean("d_document", 13, new QQSettingMeBizBean.b("\u6587\u4ef6"), R.drawable.qui_floder_vas, new QQSettingMeBizBean.a(actionType, ""), String.valueOf(BusinessInfoCheckUpdateItem.UIAPPID_MYFILE), "em_drawer_files", true, true, true, true, true), new QQSettingMeBizBean("d_qqwallet", 5, new QQSettingMeBizBean.b("\u94b1\u5305"), R.drawable.qui_wallet_vas, new QQSettingMeBizBean.a(actionType, ""), String.valueOf(100007), "em_drawer_qq_wallet", true, true, true, true, true), new QQSettingMeBizBean("d_vip_identity", 4, new QQSettingMeBizBean.b("\u4f1a\u5458\u4e2d\u5fc3"), R.drawable.qui_super_member_vas, new QQSettingMeBizBean.a(actionType, ""), String.valueOf(BusinessInfoCheckUpdateItem.UIAPPID_SECOND_VIP), "em_drawer_super_member", true, true, true, false, true), new QQSettingMeBizBean("d_decoration", 7, new QQSettingMeBizBean.b("\u4e2a\u6027\u88c5\u626e"), R.drawable.qui_skin_vas, new QQSettingMeBizBean.a(actionType, ""), String.valueOf(100005), "em_drawer_dress", true, true, true, false, false), new QQSettingMeBizBean("d_zplan", 1, new QQSettingMeBizBean.b("\u8d85\u7ea7QQ\u79c0"), R.drawable.qui_super_qq_show_vas, new QQSettingMeBizBean.a(actionType, ""), String.valueOf(BusinessInfoCheckUpdateItem.UIAPPID_DRAWER_ZPLAN), "em_drawer_superqqshow", true, true, false, false, false), new QQSettingMeBizBean("d_my_game", 2, new QQSettingMeBizBean.b("\u6211\u7684\u6e38\u620f"), R.drawable.qui_game, new QQSettingMeBizBean.a(actionType, ""), String.valueOf(BusinessInfoCheckUpdateItem.UIAPPID_MYGAME_DRAWER), "em_bas_my_game", true, true, false, false, false), new QQSettingMeBizBean("d_smallworld", 3, new QQSettingMeBizBean.b("\u6211\u7684\u5c0f\u4e16\u754c"), R.drawable.qui_small_world_vas, new QQSettingMeBizBean.a(actionType, ""), "", "", false, false, false, false, true), new QQSettingMeBizBean("d_financial", 6, new QQSettingMeBizBean.b("\u5c0f\u91d1\u5e93"), R.drawable.qui_littlebank_vas, new QQSettingMeBizBean.a(actionType, ""), String.valueOf(BusinessInfoCheckUpdateItem.UIAPPID_FINANCIAL), "em_drawer_little_bank", true, true, true, true, true), new QQSettingMeBizBean("d_intimate_space", 8, new QQSettingMeBizBean.b(QZoneConfigHelper.W()), R.drawable.qui_intimates_space_vas, new QQSettingMeBizBean.a(actionType, ""), String.valueOf(BusinessInfoCheckUpdateItem.UIAPPID_MY_INTIMATE_SPACE), "em_qz_chum_space_entry", true, true, true, false, false), new QQSettingMeBizBean("d_vip_card", 9, new QQSettingMeBizBean.b("\u514d\u6d41\u91cf", "\u9650\u65f6\u63a8\u5e7f"), R.drawable.qui_free_cellular_data_vas, new QQSettingMeBizBean.a(actionType, ""), String.valueOf(BusinessInfoCheckUpdateItem.UIAPPID_CUKING_CARD), "em_drawer_sim_card", true, true, true, false, false, false), new QQSettingMeBizBean("d_video", 14, new QQSettingMeBizBean.b("\u6211\u7684\u89c6\u9891"), R.drawable.qui_video_on_vas, new QQSettingMeBizBean.a(actionType, ""), "", "", false, false, false, false, false)};
        this.f184995c = qQSettingMeBizBeanArr;
        this.f184996d = new HashMap<>();
        for (QQSettingMeBizBean qQSettingMeBizBean : qQSettingMeBizBeanArr) {
            if (qQSettingMeBizBean.J == null && this.f184994b.containsKey(qQSettingMeBizBean.n())) {
                qQSettingMeBizBean.J = this.f184994b.get(qQSettingMeBizBean.n());
            }
            this.f184996d.put(qQSettingMeBizBean.n(), qQSettingMeBizBean);
        }
    }

    private QQSettingMeBizBean[] b(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (this.f184996d.containsKey(str)) {
                arrayList.add(this.f184996d.get(str));
            }
        }
        return (QQSettingMeBizBean[]) arrayList.toArray(new QQSettingMeBizBean[0]);
    }

    private QQSettingMeBizBean[][] d(String str) {
        try {
            List list = (List) new Gson().fromJson(str, new a().getType());
            QQSettingMeBizBean[][] qQSettingMeBizBeanArr = new QQSettingMeBizBean[list.size()];
            for (int i3 = 0; i3 < list.size(); i3++) {
                qQSettingMeBizBeanArr[i3] = b((List) list.get(i3));
            }
            return qQSettingMeBizBeanArr;
        } catch (Exception unused) {
            return new QQSettingMeBizBean[][]{this.f184995c};
        }
    }

    public QQSettingMeBizBean[] a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (QQSettingMeBizBean[]) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f184995c;
    }

    public QQSettingMeBizBean[][] c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (QQSettingMeBizBean[][]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return d("[\n    [\"d_album\", \"d_favorite\", \"d_document\", \"d_qqwallet\" , \"d_financial\" ,\"d_vip_identity\", \"d_decoration\" ]\n,    [\"d_vip_card\"]]");
    }
}
