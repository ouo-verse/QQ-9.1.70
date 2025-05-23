package com.tencent.mobileqq.qqgamepub.api;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IGameShareUtil extends QRouteApi {
    public static final IPatchRedirector $redirector_ = null;
    public static final String DEFAULT_VALUE_SOURCE_AIO_RIGHT_TXT = "\u6709\u65b0\u52a8\u6001";
    public static final String DEF_AIO_LEFT_URL = "https://speed.gamecenter.qq.com/pushgame/v1/detail?_wv=2164260896&_wwv=448&autodownload=1&autolaunch=1&autosubscribe=1&ADTAG=87006&appid=";
    public static final String DEF_AIO_RIGHT_URL = "https://speed.gamecenter.qq.com/pushgame/v1/detail?_wv=2164260896&_wwv=448&ADTAG=87006&appid=";
    public static final String DEF_PIC_LEFT_URL = "https://speed.gamecenter.qq.com/pushgame/v1/detail?_wv=2164260896&_wwv=448&ADTAG=87007&appid=";
    public static final int DP_SHARE_LAYOUT_WIDTH = 251;
    public static final String KEY_MSG_FRIEND_UIN = "friend_uin";
    public static final String KEY_MSG_IS_TROOP = "is_troop";
    public static final String KEY_MSG_UNISEQ = "uniseq";
    public static final String KEY_SOURCE_AIO_SUBTYPE = "game_source_subtype_aio";
    public static final String KEY_SOURCE_AIO_TXT = "game_source_aio_txt";
    public static final String KEY_SOURCE_AIO_TYPE = "game_source_type_aio";
    public static final String KEY_SOURCE_AIO_URL = "game_source_aio_url";
    public static final String KEY_SOURCE_PIC_HAS_DATA = "game_source_pic_has_data";
    public static final String KEY_SOURCE_PIC_SUBTYPE = "game_source_subtype_pic";
    public static final String KEY_SOURCE_PIC_TXT = "game_source_pic_txt";
    public static final String KEY_SOURCE_PIC_TYPE = "game_source_type_pic";
    public static final String KEY_SOURCE_PIC_URL = "game_source_pic_url";
    public static final int SCENE_AIO_ARK = 1;
    public static final int SCENE_AIO_PIC = 3;
    public static final int SOURCE_TYPE_AIO_LEFT = 0;
    public static final int SOURCE_TYPE_AIO_RIGHT = 1;
    public static final int SOURCE_TYPE_PIC = 2;
    public static final Map<Object, Integer> S_MSG_TO_REPORT_SUB_TYPE;
    public static final int TYPE_INVALID = 0;
    public static final int VIEW_TAG_KEY_APPID = -4;
    public static final int VIEW_TAG_KEY_SOURCE_TYPE = -5;
    public static final int VIEW_TAG_KEY_SUBTYPE = -3;
    public static final int VIEW_TAG_KEY_TYPE = -2;
    public static final int VIEW_TAG_KEY_URL = -1;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f264389a;

        /* renamed from: b, reason: collision with root package name */
        public String f264390b;

        /* renamed from: c, reason: collision with root package name */
        public int f264391c;

        /* renamed from: d, reason: collision with root package name */
        public int f264392d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f264393e;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(21779), (Class<?>) IGameShareUtil.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
        } else {
            S_MSG_TO_REPORT_SUB_TYPE = new HashMap();
        }
    }

    void convertDataForGallery(Object obj, Object obj2);

    a getGalleryData(Object obj);

    int getIntFromMsg(String str, int i3, MessageRecord messageRecord);

    TextView getSourceInGallery(Context context, RelativeLayout relativeLayout);

    String getValueFromMsg(String str, String str2, MessageRecord messageRecord);

    void handleBubbleViewForGameShare(int i3, Object obj, MessageRecord messageRecord);

    boolean isGameShare(Object obj);

    boolean isWhiteByAppid(String str);

    void releaseCache();

    void saveGalleryDataToMsg(AppRuntime appRuntime, Bundle bundle);

    void saveValueToMsg(String str, String str2, MessageRecord messageRecord);

    void setPicDataToImageData(Object obj, Object obj2, String str, String str2, int i3, int i16, boolean z16);

    void tryAdjustThumbSize(Object obj, Object obj2, Object obj3);

    void tryCompactMaxWidth(Object obj, ImageView imageView, Object obj2);

    void tryHandleAioSource(View view, RelativeLayout relativeLayout, boolean z16, Resources resources, Context context, Object obj);

    void updateSourceInGallery(TextView textView, Context context, Object obj, Object obj2);
}
