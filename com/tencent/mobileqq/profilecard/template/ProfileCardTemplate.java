package com.tencent.mobileqq.profilecard.template;

import android.graphics.Shader;
import android.graphics.Typeface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: classes16.dex */
public class ProfileCardTemplate {
    static IPatchRedirector $redirector_ = null;
    public static final int ANIMATION_FADE_IN_OUT = 2;
    public static final int ANIMATION_NONE = 0;
    public static final int ANIMATION_SCROLL = 1;
    public static final String BACKGROUND = "background";
    public static long DEFAULT_PROFILE_CARD_STYLE_ID = 0;
    public static final HashMap<String, Integer> GRAVITY_MAP;
    public static long PROFILE_CARD_STYLE_DIY = 0;
    public static long PROFILE_CARD_STYLE_DIY_TEMPLATE = 0;
    public static long PROFILE_CARD_STYLE_DIY_TEMPLATE_2 = 0;
    public static long PROFILE_CARD_STYLE_FRESH = 0;
    public static long PROFILE_CARD_STYLE_GAME = 0;
    public static long PROFILE_CARD_STYLE_JANYUE = 0;
    public static long PROFILE_CARD_STYLE_NEW_V800 = 0;
    public static long PROFILE_CARD_STYLE_SHOPPING = 0;
    public static long PROFILE_CARD_STYLE_SIMPLE = 0;
    public static long PROFILE_CARD_STYLE_SOCIAL = 0;
    public static long PROFILE_CARD_STYLE_TAG = 0;
    public static long PROFILE_CARD_STYLE_VAS_CUSTOM_BG_TEMPLATE = 0;
    public static long PROFILE_CARD_STYLE_WZRY_DYNAMIC = 0;
    public static long PROFILE_CARD_STYLE_WZRY_STATIC = 0;
    public static final String PROFILE_COMMON_VERSION = "583";
    public static final String QVIP_PROFILE_TEMPLATE_JSON = "qvip_profile_template.json";
    public static final String STYLE = "style";
    public static final HashMap<String, String> STYLE_NAME_MAP;
    public static final HashMap<String, Shader.TileMode> TILE_MODE_MAP;
    public static JSONObject mBlackStyleConfig;
    public static JSONObject mWhiteStyleConfig;
    public static Typeface wzryTTFChn;
    public static Typeface wzryTTFNum;
    public int animation;
    public String auth;
    public int customBackgroundAuth;
    public String downloadUrl;
    public String frameBlack;
    public String frameBlackMax;
    public String frameBlackMin;
    public String frameBlackSmall;
    public String frameWhite;
    public String frameWhiteMax;
    public String frameWhiteMin;
    public String frameWhiteSmall;
    public String imageBlack;
    public String imageBlackMax;
    public String imageBlackMin;
    public String imageBlackSmall;
    public int imageSize;
    public String imageWhite;
    public String imageWhiteMax;
    public String imageWhiteMin;
    public String imageWhiteSmall;
    public boolean isHide;
    public int limitefreeBtime;
    public int limitefreeEtime;
    public int limitefreeType;
    public String name;
    public int size;
    public long styleId;
    public int tag;
    public int tagBeginTime;
    public int tagEndTime;
    public ConcurrentHashMap<String, Object> templateAttr;
    public int templateBeginTime;
    public int templateEndTime;
    public String version;
    public String whitelist;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41924);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        DEFAULT_PROFILE_CARD_STYLE_ID = 0L;
        PROFILE_CARD_STYLE_FRESH = 1L;
        PROFILE_CARD_STYLE_JANYUE = 4L;
        PROFILE_CARD_STYLE_GAME = 5L;
        PROFILE_CARD_STYLE_SOCIAL = 6L;
        PROFILE_CARD_STYLE_TAG = 7L;
        PROFILE_CARD_STYLE_SIMPLE = 8L;
        PROFILE_CARD_STYLE_SHOPPING = 9L;
        PROFILE_CARD_STYLE_WZRY_STATIC = 10L;
        PROFILE_CARD_STYLE_WZRY_DYNAMIC = 11L;
        PROFILE_CARD_STYLE_NEW_V800 = 21L;
        PROFILE_CARD_STYLE_DIY_TEMPLATE = 22L;
        PROFILE_CARD_STYLE_DIY_TEMPLATE_2 = 23L;
        PROFILE_CARD_STYLE_VAS_CUSTOM_BG_TEMPLATE = 24L;
        PROFILE_CARD_STYLE_DIY = 10000L;
        HashMap<String, String> hashMap = new HashMap<>();
        STYLE_NAME_MAP = hashMap;
        HashMap<String, Integer> hashMap2 = new HashMap<>();
        GRAVITY_MAP = hashMap2;
        HashMap<String, Shader.TileMode> hashMap3 = new HashMap<>();
        TILE_MODE_MAP = hashMap3;
        hashMap2.put("top", 48);
        hashMap2.put("bottom", 80);
        hashMap2.put("left", 80);
        hashMap2.put("right", 80);
        hashMap2.put("center_vertical", 80);
        hashMap2.put("fill_vertical", 80);
        hashMap2.put("center_horizontal", 80);
        hashMap2.put("fill_horizontal", 80);
        hashMap2.put("center", 80);
        hashMap2.put(CanvasView.CUSTOM_ACTION_FILL, 80);
        hashMap2.put("clip_vertical", 80);
        hashMap2.put("clip_horizontal", 80);
        hashMap3.put("clamp", Shader.TileMode.CLAMP);
        hashMap3.put("repeat", Shader.TileMode.REPEAT);
        hashMap3.put("mirror", Shader.TileMode.MIRROR);
        hashMap.put(String.valueOf(PROFILE_CARD_STYLE_FRESH), "game");
        hashMap.put(String.valueOf(PROFILE_CARD_STYLE_JANYUE), "game");
        hashMap.put(String.valueOf(PROFILE_CARD_STYLE_GAME), "game");
        hashMap.put(String.valueOf(PROFILE_CARD_STYLE_SOCIAL), "photo");
        hashMap.put(String.valueOf(PROFILE_CARD_STYLE_SIMPLE), "simple");
    }

    public ProfileCardTemplate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.styleId = 0L;
        this.name = "";
        this.version = "0";
        this.auth = "0";
        this.tag = 0;
        this.tagBeginTime = 0;
        this.tagEndTime = 0;
        this.imageBlack = "";
        this.imageBlackMin = "";
        this.imageBlackMax = "";
        this.imageBlackSmall = "";
        this.imageWhite = "";
        this.imageWhiteMin = "";
        this.imageWhiteMax = "";
        this.imageWhiteSmall = "";
        this.animation = 0;
        this.frameWhite = "";
        this.frameWhiteMin = "";
        this.frameWhiteMax = "";
        this.frameWhiteSmall = "";
        this.frameBlack = "";
        this.frameBlackMin = "";
        this.frameBlackMax = "";
        this.frameBlackSmall = "";
        this.imageSize = 0;
        this.downloadUrl = "";
        this.size = 0;
        this.templateBeginTime = 0;
        this.templateEndTime = 0;
        this.whitelist = "";
        this.isHide = false;
        this.customBackgroundAuth = 0;
        this.templateAttr = new ConcurrentHashMap<>();
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        Field[] fields = getClass().getFields();
        sb5.append("ProfileCardTemplate:");
        for (Field field : fields) {
            if (field.getModifiers() != 8) {
                try {
                    Object obj = field.get(this);
                    sb5.append(field.getName());
                    sb5.append('=');
                    sb5.append(obj);
                    sb5.append(',');
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        }
        return sb5.toString();
    }
}
