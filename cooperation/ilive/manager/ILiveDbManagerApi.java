package cooperation.ilive.manager;

import MQQ.QqLiveMsg;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes28.dex */
public interface ILiveDbManagerApi extends QRouteApi {
    public static final String KEY_DRAWER_PLUS_TEXT = "drawer_plus_text";
    public static final String KEY_DRAWER_SHOP_JUMP_SCHEME = "drawer_shop_jump_scheme";
    public static final String KEY_DRAWER_TRACE_INFO = "drawer_trace_info";
    public static final String KEY_IS_QQ_LIVE_PGC = "is_show_anchor_entrance";
    public static final String KEY_IS_SHOW_SHOP = "is_show_shop";
    public static final String KEY_PLUGIN_LAST_USE_DATA = "ilive_plugin_last_use";
    public static final String KEY_PLUGIN_NEW_DATA = "ilive_plugin_new_data";
    public static final String KEY_SHOP_PIC_URL = "key_shop_pic_url";
    public static final String KEY_SHOP_TITLE = "key_shop_title";
    public static final String SP_TABLE_QQ_LIVE_PGC = "qq_vas_ilive";
    public static final int TYPE_PLUGIN_LAST_USE_DATA = 2;
    public static final int TYPE_PLUGIN_NEW_DATA = 1;
    public static final int TYPE_SHOP_ICON = 2;
    public static final int TYPE_SHOP_TITLE = 1;
    public static final int TYPE_SWITCH_LIVE_ENTRANCE = 1;
    public static final int TYPE_SWITCH_QQ_SHOW_SHOP = 2;

    String getCurrentUin();

    String getILiveEnterInfo(int i3);

    String getIliveDrawerData(String str);

    int getIliveSwitch(int i3);

    void saveIliveData(int i3, QqLiveMsg qqLiveMsg);

    boolean saveIliveDrawerData(String str, String str2);
}
