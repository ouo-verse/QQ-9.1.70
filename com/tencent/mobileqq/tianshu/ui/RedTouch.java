package com.tencent.mobileqq.tianshu.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.profilecard.vas.misc.VasProfileTemplatePreloadHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedTouchImageHelper;
import com.tencent.mobileqq.tianshu.api.IRedTouchTempApi;
import com.tencent.mobileqq.tianshu.data.RedTouchConst;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.IFeatureServiceProxy;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.widget.RedWidgetUtil;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes18.dex */
public class RedTouch extends FrameLayout {
    static IPatchRedirector $redirector_ = null;
    public static final int ADD_RED_POINT = 1;
    private static final int ASSIST_ENGLISH_MAX_LENGTH = 8;
    private static final int ASSIST_NO_ENGLISH_MAX_LENGTH = 8;
    private static final int CORNER_ENGLISH_MAX_LENGTH = 3;
    private static final int CORNER_NO_ENGLISH_MAX_LENGTH = 2;
    public static final int DEFAULT_MAX_NUM = 99;
    public static final int DRAWABLE_APNG = 3;
    public static final int DRAWABLE_FACE = 2;
    public static final int DRAWABLE_GIF = 1;
    public static final int DRAWABLE_STATIC = 0;
    private static final String JSON_KEY_WATER_MARK = "waterMarkUrl";
    public static final String NEWLINE_CHAR = "\\n";
    public static final int NEW_IMAGE_HEIGHT = 30;
    public static final int NEW_IMAGE_WIDTH = 118;
    public static final int NOT_ADD_RED_POINT = 0;
    public static final int RED_APPINFO_TYPE_AVATAR = 40;
    public static final int RED_APPINFO_TYPE_ICON = 3;
    public static final int RED_APPINFO_TYPE_IMAGE = 15;
    public static final int RED_APPINFO_TYPE_NUMBER = 8;
    public static final int RED_APPINFO_TYPE_RED_DOT = 0;
    public static final int RED_APPINFO_TYPE_TEXT = 5;
    public static final int RED_TOUCH_ANIM = 18;
    public static final int RED_TOUCH_ANIM_ICON = 17;
    public static final int RED_TOUCH_ANIM_ICON_WITH_TXT = 16;
    public static final int RED_TOUCH_BANNER = 10;
    public static final int RED_TOUCH_BUBBLE = 21;
    public static final int RED_TOUCH_CORNER = 11;
    public static final int RED_TOUCH_DOUBLE_LINE = 28;
    public static final int RED_TOUCH_EXTEND_DOUBLE_LINE_TEXT = 28;
    public static final int RED_TOUCH_EXTEND_INDEX_HAS_TIPS = 24;
    public static final int RED_TOUCH_EXTEND_INDEX_TIPS_CONTENT = 26;
    public static final int RED_TOUCH_EXTEND_INDEX_TIPS_LIFE_TIME = 11;
    public static final int RED_TOUCH_EXTEND_ITEM_ANIM_IMG = 32;
    public static final int RED_TOUCH_EXTEND_NEW_WORDING = 98;
    public static final int RED_TOUCH_EXTEND_POP_ANIM_IMG = 30;
    public static final int RED_TOUCH_GRAY_TEXT = -100;
    public static final int RED_TOUCH_IMAGE = 3;
    public static final int RED_TOUCH_IMAGE_DEFAULT_ID = 20;
    public static final int RED_TOUCH_ITEM_ANIM = 32;
    public static final int RED_TOUCH_NEW_IMAGE = 15;
    public static final int RED_TOUCH_NUM = 5;
    public static final int RED_TOUCH_NUM_DEFAULT_ID = 40;
    public static final int RED_TOUCH_POP_ANIM = 30;
    public static final int RED_TOUCH_RED_CONTAINER_DEFAULT_ID = 100;
    public static final int RED_TOUCH_RED_POINT = 0;
    public static final int RED_TOUCH_RED_POINT_DEFAULT_ID = 10;
    public static final int RED_TOUCH_REPEAT_ANIM = 22;
    public static final int RED_TOUCH_SPACE = 9;
    public static final int RED_TOUCH_TEXT = 4;
    public static final int RED_TOUCH_TEXT_DEFAULT_ID = 30;
    public static final int RED_TOUCH_UNKNOWN = -1;
    public static final String TAG = "RedTouch";

    /* renamed from: id, reason: collision with root package name */
    protected static int f293129id;
    protected int buttomMargin;
    protected boolean compactMode;
    protected Context context;
    protected int defaultButtomMargin;
    protected int defaultGravity;
    protected int defaultLeftMargin;
    protected int defaultRightMargin;
    protected int defaultTopMargin;
    protected int gravity;
    protected Handler handler;
    protected int imageBottomMargin;
    protected int imageGravity;
    protected int imageLeftMargin;
    protected boolean imagePosEnable;
    protected int imageRedotSize;
    protected int imageRightMargin;
    protected int imageSize;
    protected boolean imageSizeEnable;
    protected int imageTopMargin;
    protected boolean isApplyTo;
    protected boolean isLeftAlign;
    protected boolean isRedOnTop;
    protected boolean isUseNewStyle;
    protected boolean isUseRobotoTtf;
    public ImageView ivAnimRedDot;
    public ImageView ivIcon;
    public boolean lebaIsNeedWaterMack;
    public ImageView lebaIvWaterMack;
    public String lebaJsonWaterMack;
    public TextView lebaTvAssists;
    public TextView lebaTvCorner;
    protected int leftMargin;
    boolean mHostEnable;
    protected int maxNum;
    protected int redImageId;
    protected BusinessInfoCheckUpdate.RedTypeInfo redInfo;
    protected int redNumId;
    protected int redPointId;
    protected int redPointSize;
    protected int redTextId;
    protected LinearLayout redTouchContainer;
    private int redType;
    protected List<BusinessInfoCheckUpdate.RedTypeInfo> redTypeInfos;
    protected int rightMargin;
    protected View target;
    protected int topMargin;
    public TextView tvAnimRedDotLabel;
    public TextView tvAnimRedDotLabel2;
    public TextView tvLabel;
    protected boolean useTextColorFromRedTouchConfig;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f293130d;

        a(String str) {
            this.f293130d = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RedTouch.this, (Object) str);
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                RedTouch.this.lebaIvWaterMack.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                RedTouch.this.showLebaWaterMark(this.f293130d);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34383);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 55)) {
            redirector.redirect((short) 55);
        } else {
            f293129id = 1;
        }
    }

    public RedTouch(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private boolean addComplexRedTouch(int i3, List<BusinessInfoCheckUpdate.RedTypeInfo> list) {
        if (i3 == 28) {
            addDoubleLineRedTouch(list);
            return true;
        }
        return false;
    }

    private void addDoubleLineRedTouch(List<BusinessInfoCheckUpdate.RedTypeInfo> list) {
        ArrayList arrayList = new ArrayList();
        StringBuilder sb5 = new StringBuilder();
        boolean z16 = false;
        for (BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo : list) {
            if (redTypeInfo.red_type.get() == 28) {
                arrayList.add(redTypeInfo);
                sb5.append(redTypeInfo.red_content.get());
                sb5.append("_");
                if (arrayList.size() == 2 && !z16) {
                    processAddDoubleRowText(arrayList);
                    z16 = true;
                }
            } else {
                addRedTouch(redTypeInfo);
            }
        }
        if (!z16) {
            QLog.e(TAG, 1, "addDoubleLineRedTouch: invalid RedTouch, text=" + ((Object) sb5));
        }
    }

    private void addRedTouch(BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo) {
        JSONObject jSONObject;
        int i3 = 0;
        if (this.mHostEnable) {
            this.redTouchContainer.setVisibility(0);
        }
        try {
            if (TextUtils.isEmpty(redTypeInfo.red_desc.get())) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(redTypeInfo.red_desc.get());
            }
            if (jSONObject.has(VasProfileTemplatePreloadHelper.BACKGROUND)) {
                i3 = getRealColor(jSONObject.getString(VasProfileTemplatePreloadHelper.BACKGROUND));
            }
            int i16 = redTypeInfo.red_type.get();
            if (i16 != 0) {
                if (i16 != 9) {
                    if (i16 != 15) {
                        if (i16 != 22) {
                            if (i16 != 3) {
                                if (i16 == 4 || i16 == 5) {
                                    processAddTextOrNum(redTypeInfo, jSONObject, i3);
                                    return;
                                }
                                return;
                            }
                            proceeAddRedImage(redTypeInfo, jSONObject, i3);
                            return;
                        }
                    } else {
                        processAddNewRedImage(redTypeInfo, jSONObject);
                        return;
                    }
                } else {
                    processAddRedSpace(redTypeInfo);
                    return;
                }
            }
            processAddRedPoint(i3);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "addRedTouch ", e16);
        }
    }

    private boolean checkIsEqual(List<BusinessInfoCheckUpdate.RedTypeInfo> list) {
        if (this.redTypeInfos.size() == 0 || this.redTypeInfos.size() != list.size()) {
            return false;
        }
        for (int i3 = 0; i3 < this.redTypeInfos.size(); i3++) {
            if (!checkIsEqual(this.redTypeInfos.get(i3), list.get(i3))) {
                return false;
            }
        }
        return true;
    }

    private void createRedTouchContainer() {
        LinearLayout linearLayout = new LinearLayout(this.context);
        this.redTouchContainer = linearLayout;
        linearLayout.setLayoutParams(getRedTouchContainerLayoutParams());
        this.redTouchContainer.setOrientation(0);
        this.redTouchContainer.setId(100);
        this.redTouchContainer.setVisibility(8);
        addView(this.redTouchContainer);
    }

    public static final int dp2px(float f16, Resources resources) {
        if (f16 == 0.0f) {
            return 0;
        }
        return (int) ((f16 * resources.getDisplayMetrics().density) + 0.5f);
    }

    public static void filterLebaTableAppInfo(BusinessInfoCheckUpdate.AppInfo appInfo) {
        if (appInfo != null && appInfo.red_display_info.red_type_info.get() != null) {
            for (BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo : appInfo.red_display_info.red_type_info.get()) {
                if (redTypeInfo.red_type.get() == 3) {
                    redTypeInfo.red_type.set(0);
                } else if (redTypeInfo.red_type.get() == 4) {
                    redTypeInfo.red_type.set(-100);
                } else if (redTypeInfo.red_type.get() == 9) {
                    redTypeInfo.red_type.set(-1);
                }
            }
        }
    }

    private View getExtenSpace() {
        View view = new View(this.context);
        LinearLayout.LayoutParams redTouchLayoutParams = getRedTouchLayoutParams();
        redTouchLayoutParams.width = 0;
        redTouchLayoutParams.height = 1;
        redTouchLayoutParams.weight = 1.0f;
        view.setLayoutParams(redTouchLayoutParams);
        return view;
    }

    private View getGifImageView(String str) {
        Drawable drawable = getResources().getDrawable(R.drawable.f160830com);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        obtain.mRequestWidth = dipToPixels(30.0f);
        obtain.mRequestHeight = dipToPixels(30.0f);
        obtain.mPlayGifImage = true;
        ImageView imageView = new ImageView(this.context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        LinearLayout.LayoutParams redTouchLayoutParams = getRedTouchLayoutParams();
        redTouchLayoutParams.width = dipToPixels(30.0f);
        redTouchLayoutParams.height = dipToPixels(30.0f);
        imageView.setLayoutParams(redTouchLayoutParams);
        imageView.setImageDrawable(URLDrawable.getDrawable(str, obtain));
        return imageView;
    }

    private static int getIntJSONObj(String str, String str2) {
        try {
            return new JSONObject(str).optInt(str2, 0);
        } catch (JSONException e16) {
            QLog.d(TAG, 1, "getIntJSONObj error : ", e16.getMessage());
            return 0;
        }
    }

    private View getNewImageRedPoint(String str, int i3) {
        int i16;
        int i17;
        Drawable drawable = getResources().getDrawable(R.drawable.f160830com);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        obtain.mRequestWidth = dipToPixels(118.0f);
        obtain.mRequestHeight = dipToPixels(30.0f);
        obtain.mUseApngImage = true;
        ImageView imageView = new ImageView(this.context);
        imageView.setScaleType(ImageView.ScaleType.FIT_END);
        LinearLayout.LayoutParams redTouchLayoutParams = getRedTouchLayoutParams();
        redTouchLayoutParams.width = dipToPixels(118.0f);
        redTouchLayoutParams.height = dipToPixels(30.0f);
        imageView.setLayoutParams(redTouchLayoutParams);
        imageView.setImageDrawable(URLDrawable.getDrawable(str, obtain));
        if (i3 != 1) {
            return imageView;
        }
        FrameLayout frameLayout = new FrameLayout(getContext());
        if (this.imageSizeEnable) {
            i16 = this.imageRedotSize + 12;
            i17 = 6;
        } else {
            i16 = 38;
            i17 = 4;
        }
        imageView.setLayoutParams(new FrameLayout.LayoutParams(dipToPixels(118.0f), dipToPixels(i16)));
        float f16 = i17;
        imageView.setPadding(dipToPixels(f16), dipToPixels(f16), dipToPixels(f16), dipToPixels(f16));
        frameLayout.addView(imageView);
        View redPointView = getRedPointView(0, false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 53;
        redPointView.setLayoutParams(layoutParams);
        frameLayout.addView(redPointView);
        frameLayout.setLayoutParams(getRedTouchLayoutParams());
        return frameLayout;
    }

    private FrameLayout getRedOnTheTonAndRight(ImageView imageView) {
        int i3;
        int i16;
        FrameLayout frameLayout = new FrameLayout(getContext());
        if (this.imageSizeEnable) {
            i3 = this.imageRedotSize + 12;
            i16 = 6;
        } else {
            i3 = 38;
            i16 = 4;
        }
        float f16 = i3;
        imageView.setLayoutParams(new FrameLayout.LayoutParams(dipToPixels(f16), dipToPixels(f16)));
        float f17 = i16;
        imageView.setPadding(dipToPixels(f17), dipToPixels(f17), dipToPixels(f17), dipToPixels(f17));
        frameLayout.addView(imageView);
        View redPointView = getRedPointView(0, false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 53;
        redPointView.setLayoutParams(layoutParams);
        frameLayout.addView(redPointView);
        frameLayout.setLayoutParams(getRedTouchLayoutParams());
        return frameLayout;
    }

    private FrameLayout getRedOnTheTop(ImageView imageView) {
        FrameLayout frameLayout = new FrameLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dipToPixels(30.0f), dipToPixels(30.0f));
        layoutParams.gravity = 80;
        layoutParams.topMargin = dipToPixels(16.0f);
        imageView.setLayoutParams(layoutParams);
        frameLayout.addView(imageView);
        ImageView imageView2 = new ImageView(this.context);
        imageView2.setImageResource(R.drawable.skin_tips_dot);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 49;
        imageView2.setLayoutParams(layoutParams2);
        frameLayout.addView(imageView2);
        frameLayout.setLayoutParams(getRedTouchLayoutParams());
        return frameLayout;
    }

    private FrameLayout.LayoutParams getRedTouchContainerLayoutParams() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = this.gravity;
        layoutParams.leftMargin = this.leftMargin;
        layoutParams.rightMargin = this.rightMargin;
        layoutParams.topMargin = this.topMargin;
        layoutParams.bottomMargin = this.buttomMargin;
        return layoutParams;
    }

    private FrameLayout.LayoutParams getRedTouchTargetLayoutParams() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    public static AnimIconRedDot getRedTypeInfoAnimUrl(BusinessInfoCheckUpdate.AppInfo appInfo) {
        boolean z16;
        String str;
        if (appInfo != null && appInfo.iNewFlag.get() != 0 && appInfo.exposure_max.get() >= 0 && appInfo.red_display_info.get() != null && appInfo.red_display_info.red_type_info.get() != null) {
            AnimIconRedDot animIconRedDot = new AnimIconRedDot(null, 0, null);
            for (BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo : appInfo.red_display_info.red_type_info.get()) {
                if (redTypeInfo != null) {
                    int i3 = redTypeInfo.red_type.get();
                    if (i3 == 17) {
                        String str2 = redTypeInfo.red_content.get();
                        String str3 = redTypeInfo.red_desc.get();
                        int intJSONObj = getIntJSONObj(str3, "time");
                        if (getIntJSONObj(str3, "dot") == 1) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        animIconRedDot.setHasDot(z16);
                        animIconRedDot.setAnimIconUrl(str2);
                        animIconRedDot.setSeconds(intJSONObj);
                        QLog.d(TAG, 1, "red_content : ", str2, " redDesc : ", str3);
                    } else if (i3 == 16) {
                        String str4 = redTypeInfo.red_content.get();
                        if (str4 != null && str4.contains(NEWLINE_CHAR)) {
                            int indexOf = str4.indexOf(NEWLINE_CHAR);
                            str = str4.substring(indexOf + 2).replace(NEWLINE_CHAR, " ");
                            str4 = str4.substring(0, indexOf);
                        } else {
                            str = "";
                        }
                        animIconRedDot.setAssistText(str4);
                        animIconRedDot.setNewlineText(str);
                        QLog.d(TAG, 1, "red_content : ", str4);
                    }
                }
            }
            if (animIconRedDot.getAnimIconUrl() != null || animIconRedDot.getAssistText() != null) {
                return animIconRedDot;
            }
        }
        return null;
    }

    public static String getRedTypeInfoCornerText(BusinessInfoCheckUpdate.AppInfo appInfo) {
        if (appInfo != null && appInfo.iNewFlag.get() != 0 && appInfo.exposure_max.get() >= 0 && appInfo.red_display_info.get() != null && appInfo.red_display_info.red_type_info.get() != null) {
            for (BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo : appInfo.red_display_info.red_type_info.get()) {
                if (redTypeInfo != null && redTypeInfo.red_type.get() == 11) {
                    return redTypeInfo.red_content.get();
                }
            }
        }
        return "";
    }

    private void handleItemAnimation(BusinessInfoCheckUpdate.AppInfo appInfo) {
        if (ItemAnimationHelper.isValidItemAnimationRedTouch(this, appInfo) && !ItemAnimationHelper.isItemAnimationShowed(appInfo)) {
            ItemAnimationHelper.showItemAnimation(this, appInfo);
        } else {
            ItemAnimationHelper.removeItemAnimationView(this);
        }
    }

    private void handleScreenAnimation(BusinessInfoCheckUpdate.AppInfo appInfo) {
        if (!ScreenAnimationDialog.isValidScreenAnimationRedTouch(this, appInfo)) {
            return;
        }
        ScreenAnimationDialog showingDialog = ScreenAnimationDialog.getShowingDialog();
        if (showingDialog != null) {
            if (showingDialog.isRedPathEqualed(appInfo)) {
                showingDialog.updateRedTouch(this, appInfo);
            }
        } else {
            if (ScreenAnimationDialog.isScreenAnimationShowed(appInfo)) {
                return;
            }
            ScreenAnimationDialog screenAnimationDialog = new ScreenAnimationDialog(getContext(), R.style.f173448dl);
            screenAnimationDialog.onLebaResume();
            screenAnimationDialog.updateRedTouch(this, appInfo);
            screenAnimationDialog.showScreenAnimation();
        }
    }

    private void handleTarget(View view) {
        view.setLayoutParams(getRedTouchTargetLayoutParams());
        addView(view);
    }

    public static boolean hasRedTouch(BusinessInfoCheckUpdate.AppInfo appInfo) {
        return (appInfo == null || appInfo.iNewFlag.get() == 0 || appInfo.exposure_max.get() < 0 || appInfo.red_display_info.get() == null || appInfo.red_display_info.red_type_info.get() == null || appInfo.red_display_info.red_type_info.get().size() == 0) ? false : true;
    }

    private void init() {
        this.gravity = this.defaultGravity;
        this.leftMargin = this.defaultLeftMargin;
        this.rightMargin = this.defaultRightMargin;
        this.topMargin = this.defaultTopMargin;
        this.buttomMargin = this.defaultButtomMargin;
        this.maxNum = 99;
        this.redTypeInfos = new ArrayList();
        this.handler = new Handler(Looper.getMainLooper());
        this.redPointId = 10;
        this.redImageId = 20;
        this.redTextId = 30;
        this.redNumId = 40;
    }

    private void proceeAddRedImage(BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo, JSONObject jSONObject, int i3) throws JSONException {
        int i16;
        int i17;
        int i18;
        View apngImageView;
        if (this.imagePosEnable) {
            changeRedTouchContainerForImage();
        }
        int i19 = 0;
        if (jSONObject.has("av")) {
            i16 = jSONObject.getInt("av");
        } else {
            i16 = 0;
        }
        if (jSONObject.has("dot")) {
            i17 = jSONObject.getInt("dot");
        } else {
            i17 = 0;
        }
        if (jSONObject.has("drawable")) {
            i18 = jSONObject.getInt("drawable");
        } else {
            i18 = 0;
        }
        if (jSONObject.has("st")) {
            i19 = Integer.parseInt(jSONObject.getString("st"));
        }
        if (jSONObject.has("uin")) {
            i19 = 2;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "drawableType:" + i19 + ",red_content:" + redTypeInfo.red_content.get());
        }
        if (i19 == 0) {
            View imageRedPoint = getImageRedPoint(redTypeInfo.red_content.get(), i16, i17, i3, i18, "");
            if (imageRedPoint != null) {
                int i26 = this.redImageId;
                this.redImageId = i26 + 1;
                imageRedPoint.setId(i26);
                this.redTouchContainer.addView(imageRedPoint);
                return;
            }
            return;
        }
        if (i19 == 1) {
            this.redTouchContainer.addView(getGifImageView(redTypeInfo.red_content.get()));
            return;
        }
        if (i19 == 2) {
            View imageRedPoint2 = getImageRedPoint("", i16, i17, i3, i18, jSONObject.getString("uin"));
            if (imageRedPoint2 != null) {
                int i27 = this.redImageId;
                this.redImageId = i27 + 1;
                imageRedPoint2.setId(i27);
                this.redTouchContainer.addView(imageRedPoint2);
                return;
            }
            return;
        }
        if (i19 == 3 && (apngImageView = ((IRedTouchImageHelper) QRoute.api(IRedTouchImageHelper.class)).getApngImageView(redTypeInfo.red_content.get(), this.context)) != null) {
            int i28 = this.redImageId;
            this.redImageId = i28 + 1;
            apngImageView.setId(i28);
            this.redTouchContainer.addView(apngImageView);
        }
    }

    private void processAddDoubleRowText(List<BusinessInfoCheckUpdate.RedTypeInfo> list) {
        int i3;
        LinearLayout linearLayout = new LinearLayout(this.context);
        linearLayout.setOrientation(1);
        for (BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo : list) {
            try {
                i3 = getRealColor(new JSONObject(redTypeInfo.red_desc.get()).optString("cr"));
            } catch (Exception unused) {
                QLog.e(TAG, 1, "processAddDoubleRowText: invalid desc: " + redTypeInfo.red_desc.get());
                i3 = 0;
            }
            if (!this.useTextColorFromRedTouchConfig || i3 == 0) {
                i3 = getResources().getColor(R.color.red_touch_gray_text_color);
            }
            TextView textView = new TextView(this.context);
            textView.setText(redTypeInfo.red_content.get());
            textView.setTextColor(i3);
            textView.setTextSize(14.0f);
            textView.setSingleLine(true);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 3;
            textView.setLayoutParams(layoutParams);
            linearLayout.addView(textView);
        }
        linearLayout.setLayoutParams(getRedTouchLayoutParams());
        this.redTouchContainer.addView(linearLayout);
    }

    private void processAddNewRedImage(BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo, JSONObject jSONObject) throws JSONException {
        int i3;
        if (this.imagePosEnable) {
            changeRedTouchContainerForImage();
        }
        if (jSONObject.has("dot")) {
            i3 = jSONObject.getInt("dot");
        } else {
            i3 = 0;
        }
        View newImageRedPoint = getNewImageRedPoint(redTypeInfo.red_content.get(), i3);
        int i16 = this.redImageId;
        this.redImageId = i16 + 1;
        newImageRedPoint.setId(i16);
        this.redTouchContainer.addView(newImageRedPoint);
    }

    private void processAddRedPoint(int i3) {
        ((IRedTouchTempApi) QRoute.api(IRedTouchTempApi.class)).onProcessAddRedPoint(this.target);
        View redPoint = getRedPoint(i3);
        if (redPoint != null) {
            if (this.redType == 10) {
                this.redTouchContainer.addView(getExtenSpace());
            }
            int i16 = this.redPointId;
            this.redPointId = i16 + 1;
            redPoint.setId(i16);
            this.redTouchContainer.addView(redPoint);
        }
    }

    private void processAddRedSpace(BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo) {
        View space = getSpace(redTypeInfo.red_content.get());
        if (space != null) {
            this.redTouchContainer.addView(space);
        }
    }

    private void processAddTextOrNum(BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo, JSONObject jSONObject, int i3) throws JSONException {
        int i16;
        int i17;
        int i18;
        if (!this.useTextColorFromRedTouchConfig && redTypeInfo.red_type.get() == 4) {
            i16 = getResources().getColor(R.color.red_touch_gray_text_color);
        } else if (jSONObject.has("cr")) {
            i16 = getRealColor(jSONObject.getString("cr"));
        } else {
            i16 = -1;
        }
        if (jSONObject.has("cn")) {
            i17 = getRealColor(jSONObject.getString("cn"));
        } else {
            i17 = 0;
        }
        View textRedPoint = getTextRedPoint(redTypeInfo.red_content.get(), i16, i17, i3);
        if (textRedPoint != null) {
            if (redTypeInfo.red_type.get() == 4) {
                i18 = this.redTextId;
                this.redTextId = i18 + 1;
            } else {
                i18 = this.redNumId;
                this.redNumId = i18 + 1;
            }
            textRedPoint.setId(i18);
            this.redTouchContainer.addView(textRedPoint);
            if (((IFeatureServiceProxy) QRoute.api(IFeatureServiceProxy.class)).isFeatureSwitchOn("talkback_fix_enable_2") && AppSetting.f99565y) {
                AccessibilityUtil.n(textRedPoint, false);
                AccessibilityUtil.n(this.redTouchContainer, false);
            }
        }
    }

    private void resumeRedTouchWrapperLayoutParams(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup == null) {
            return;
        }
        if (viewGroup instanceof RelativeLayout) {
            int i3 = f293129id;
            f293129id = i3 + 1;
            setId(i3);
            int id5 = view.getId();
            RelativeLayout relativeLayout = (RelativeLayout) viewGroup;
            for (int i16 = 0; i16 < relativeLayout.getChildCount(); i16++) {
                View childAt = relativeLayout.getChildAt(i16);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) childAt.getLayoutParams();
                int[] rules = layoutParams.getRules();
                for (int i17 = 0; i17 < rules.length; i17++) {
                    if (rules[i17] == id5) {
                        rules[i17] = getId();
                    }
                }
                childAt.setLayoutParams(layoutParams);
            }
        }
        int indexOfChild = viewGroup.indexOfChild(view);
        viewGroup.removeView(view);
        setLayoutParams(view.getLayoutParams());
        viewGroup.addView(this, indexOfChild);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLebaWaterMark(String str) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestWidth = this.lebaIvWaterMack.getMeasuredWidth();
        obtain.mRequestHeight = this.lebaIvWaterMack.getMeasuredHeight();
        obtain.mFailedDrawable = new ColorDrawable(0);
        obtain.mLoadingDrawable = new ColorDrawable(0);
        QLog.i(TAG, 1, "leba show waterMark url = " + str + " width = " + obtain.mRequestWidth + " height = " + obtain.mRequestHeight);
        URLDrawable drawable = URLDrawable.getDrawable(str, obtain);
        drawable.setTargetDensity(getResources().getDisplayMetrics().densityDpi);
        if (drawable.getStatus() == 2) {
            drawable.restartDownload();
        }
        this.lebaIvWaterMack.setImageDrawable(drawable);
    }

    public RedTouch applyTo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (RedTouch) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (!this.isApplyTo) {
            resumeRedTouchWrapperLayoutParams(this.target);
            handleTarget(this.target);
            createRedTouchContainer();
            this.isApplyTo = true;
        } else {
            changeRedTouchContainer();
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void changeRedTouchContainer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
        } else {
            this.redTouchContainer.setLayoutParams(getRedTouchContainerLayoutParams());
        }
    }

    protected void changeRedTouchContainerForImage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, (Object) this);
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = this.imageGravity;
        layoutParams.leftMargin = this.imageLeftMargin;
        layoutParams.rightMargin = this.imageRightMargin;
        layoutParams.topMargin = this.imageTopMargin;
        layoutParams.bottomMargin = this.imageBottomMargin;
        this.redTouchContainer.setLayoutParams(layoutParams);
    }

    public void checkAndShowLebaWaterMark() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        ImageView imageView = this.lebaIvWaterMack;
        if (imageView == null) {
            return;
        }
        if (!this.lebaIsNeedWaterMack) {
            imageView.setVisibility(8);
            return;
        }
        if (!showWaterMack()) {
            this.lebaIvWaterMack.setVisibility(8);
            return;
        }
        if (TextUtils.isEmpty(this.lebaJsonWaterMack)) {
            this.lebaIvWaterMack.setVisibility(8);
            QLog.i(TAG, 1, "leba show waterMark but json isEmpty");
            return;
        }
        try {
            String optString = new JSONObject(this.lebaJsonWaterMack).optString(JSON_KEY_WATER_MARK);
            if (TextUtils.isEmpty(optString)) {
                this.lebaIvWaterMack.setVisibility(8);
                QLog.i(TAG, 1, "leba show waterMark but url isEmpty");
                return;
            }
            this.lebaIvWaterMack.setVisibility(0);
            if (this.lebaIvWaterMack.getMeasuredHeight() > 0) {
                showLebaWaterMark(optString);
            } else {
                this.lebaIvWaterMack.getViewTreeObserver().addOnGlobalLayoutListener(new a(optString));
            }
        } catch (Exception e16) {
            QLog.i(TAG, 1, "leba show waterMark", e16);
        }
    }

    public void clearRedTouch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
            return;
        }
        LinearLayout linearLayout = this.redTouchContainer;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
            this.redTouchContainer.setVisibility(8);
            this.redPointId = 10;
            this.redImageId = 20;
            this.redTextId = 30;
            this.redNumId = 40;
        }
    }

    public void clearRedTouchInLebaTable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        TextView textView = this.lebaTvCorner;
        if (textView != null) {
            textView.setText("");
            this.lebaTvCorner.setVisibility(8);
        }
        TextView textView2 = this.lebaTvAssists;
        if (textView2 != null) {
            textView2.setText("");
            this.lebaTvAssists.setVisibility(8);
        }
        if (this.ivAnimRedDot != null && this.ivIcon != null) {
            ((IRedTouchTempApi) QRoute.api(IRedTouchTempApi.class)).removeLebaIconAnim(this.ivAnimRedDot, this.ivIcon, this.tvLabel, this.tvAnimRedDotLabel, this.tvAnimRedDotLabel2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int dipToPixels(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Integer) iPatchRedirector.redirect((short) 28, this, Float.valueOf(f16))).intValue();
        }
        return (int) TypedValue.applyDimension(1, f16, getResources().getDisplayMetrics());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void downLoadIcon(String str, URLImageView uRLImageView, int i3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, str, uRLImageView, Integer.valueOf(i3));
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Drawable drawable = getResources().getDrawable(R.drawable.f160830com);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        if (this.imageSizeEnable) {
            i16 = this.imageRedotSize;
        } else {
            i16 = 30;
        }
        float f16 = i16;
        obtain.mRequestWidth = dipToPixels(f16);
        obtain.mRequestHeight = dipToPixels(f16);
        try {
            URLDrawable drawable2 = URLDrawable.getDrawable(new URL(RedTouchConst.PicDownload.REDTOUCHPIC_PROTOC, (String) null, str), obtain);
            drawable2.setTag(str);
            drawable2.addHeader(RedTouchConst.PicDownload.ISCIRCLE, String.valueOf(i3));
            uRLImageView.setImageDrawable(drawable2);
        } catch (MalformedURLException e16) {
            e16.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "parse img exception : e = " + e16);
            }
        }
    }

    public int getGravity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Integer) iPatchRedirector.redirect((short) 32, (Object) this)).intValue();
        }
        return this.gravity;
    }

    protected View getImageRedPoint(String str, int i3, int i16, int i17, int i18, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (View) iPatchRedirector.redirect((short) 22, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), str2);
        }
        URLImageView uRLImageView = new URLImageView(this.context);
        uRLImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        uRLImageView.setBackgroundColor(i17);
        if (i18 != 0) {
            uRLImageView.setImageDrawable(getResources().getDrawable(i18));
        } else if (!TextUtils.isEmpty(str2)) {
            IRedTouchTempApi iRedTouchTempApi = (IRedTouchTempApi) QRoute.api(IRedTouchTempApi.class);
            if (iRedTouchTempApi != null) {
                Drawable faceDrawable = iRedTouchTempApi.getFaceDrawable(this.context, str2);
                if (faceDrawable != null) {
                    uRLImageView.setImageDrawable(faceDrawable);
                } else {
                    uRLImageView.setImageBitmap(iRedTouchTempApi.getDefaultFaceBitmap());
                }
            }
        } else {
            downLoadIcon(str, uRLImageView, i3);
        }
        if (i16 == 1) {
            if (this.isRedOnTop) {
                return getRedOnTheTop(uRLImageView);
            }
            return getRedOnTheTonAndRight(uRLImageView);
        }
        if (i18 != 0) {
            uRLImageView.setLayoutParams(getRedTouchLayoutParams());
            uRLImageView.setPadding(dipToPixels(3.0f), dipToPixels(3.0f), dipToPixels(3.0f), dipToPixels(3.0f));
        } else {
            LinearLayout.LayoutParams redTouchLayoutParams = getRedTouchLayoutParams();
            redTouchLayoutParams.width = dipToPixels(30.0f);
            redTouchLayoutParams.height = dipToPixels(30.0f);
            uRLImageView.setLayoutParams(redTouchLayoutParams);
        }
        return uRLImageView;
    }

    public int getLeftMargin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Integer) iPatchRedirector.redirect((short) 35, (Object) this)).intValue();
        }
        return this.leftMargin;
    }

    public int getOuterRedType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return this.redType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getRealColor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this, (Object) str)).intValue();
        }
        if (!TextUtils.isEmpty(str) && !str.equals("#")) {
            return Color.parseColor(str);
        }
        return 0;
    }

    protected View getRedPoint(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (View) iPatchRedirector.redirect((short) 19, (Object) this, i3);
        }
        View redPointView = getRedPointView(i3, true);
        redPointView.setLayoutParams(getRedTouchLayoutParams());
        return redPointView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getRedPointView(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (View) iPatchRedirector.redirect((short) 20, this, Integer.valueOf(i3), Boolean.valueOf(z16));
        }
        ImageView imageView = new ImageView(this.context);
        try {
            imageView.setImageResource(R.drawable.skin_tips_dot);
            if (z16) {
                imageView.setBackgroundColor(i3);
            }
        } catch (OutOfMemoryError unused) {
            QLog.e(TAG, 1, "getRedPoint oom");
        }
        return imageView;
    }

    public View getRedTouchContainer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return (View) iPatchRedirector.redirect((short) 43, (Object) this);
        }
        return this.redTouchContainer;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LinearLayout.LayoutParams getRedTouchLayoutParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (LinearLayout.LayoutParams) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        int i3 = this.redPointSize;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i3);
        layoutParams.gravity = 16;
        return layoutParams;
    }

    public BusinessInfoCheckUpdate.RedTypeInfo getRedType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (BusinessInfoCheckUpdate.RedTypeInfo) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.redInfo;
    }

    public List<BusinessInfoCheckUpdate.RedTypeInfo> getRedTypeInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (List) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.redTypeInfos;
    }

    public String getRedTypeInfoText() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        List<BusinessInfoCheckUpdate.RedTypeInfo> list = this.redTypeInfos;
        if (list == null) {
            return "";
        }
        for (BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo : list) {
            if (redTypeInfo != null && redTypeInfo.red_type.get() == 4) {
                return redTypeInfo.red_content.get();
            }
        }
        return "";
    }

    public int getRightMargin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Integer) iPatchRedirector.redirect((short) 37, (Object) this)).intValue();
        }
        return this.rightMargin;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getSpace(String str) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (View) iPatchRedirector.redirect((short) 24, (Object) this, (Object) str);
        }
        try {
            i3 = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            i3 = 0;
        }
        if (i3 <= 0) {
            return null;
        }
        View view = new View(this.context);
        LinearLayout.LayoutParams redTouchLayoutParams = getRedTouchLayoutParams();
        redTouchLayoutParams.width = dipToPixels(i3);
        redTouchLayoutParams.height = 1;
        view.setLayoutParams(redTouchLayoutParams);
        return view;
    }

    public View getTarget() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            return (View) iPatchRedirector.redirect((short) 48, (Object) this);
        }
        return this.target;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected View getTextRedPoint(String str, int i3, int i16, int i17) {
        int i18;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (View) iPatchRedirector.redirect((short) 21, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
        TextView textView = new TextView(this.context);
        try {
            i18 = Integer.parseInt(str);
            try {
                if (i18 > this.maxNum) {
                    textView.setText(this.maxNum + Marker.ANY_NON_NULL_MARKER);
                } else {
                    textView.setText(str);
                }
                z16 = true;
            } catch (NumberFormatException unused) {
                textView.setText(str.trim());
                z16 = false;
                textView.setTextColor(i3);
                textView.setGravity(17);
                textView.setSingleLine(true);
                if (i16 == 0) {
                }
                if (this.redType == 10) {
                }
                if (this.compactMode) {
                }
                textView.setLayoutParams(getRedTouchLayoutParams());
                if (this.isLeftAlign) {
                }
                return textView;
            }
        } catch (NumberFormatException unused2) {
            i18 = 0;
        }
        textView.setTextColor(i3);
        textView.setGravity(17);
        textView.setSingleLine(true);
        if (i16 == 0) {
            textView.setTextSize(11.0f);
            if (this.compactMode) {
                textView.setIncludeFontPadding(false);
                textView.setBackgroundResource(R.drawable.h1w);
            } else {
                textView.setBackgroundResource(R.drawable.skin_tips_newmessage);
            }
        } else {
            textView.setTextSize(14.0f);
        }
        if (this.redType == 10) {
            textView.setTextSize(1, 17.0f);
        }
        if (this.compactMode && z16 && this.isUseNewStyle) {
            RedWidgetUtil.fixTextViewLayout(textView, i18, this.maxNum, R.drawable.skin_tips_newmessage, this.isUseRobotoTtf);
        } else {
            textView.setLayoutParams(getRedTouchLayoutParams());
        }
        if (this.isLeftAlign) {
            if (!this.compactMode && z16 && this.isUseNewStyle && this.isUseRobotoTtf) {
                this.leftMargin += textView.getLayoutParams().width / 2;
            } else {
                textView.measure(0, 0);
                this.leftMargin += textView.getMeasuredWidth() / 2;
            }
            changeRedTouchContainer();
        }
        return textView;
    }

    public int getTopMargin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Integer) iPatchRedirector.redirect((short) 39, (Object) this)).intValue();
        }
        return this.topMargin;
    }

    public void handleLebaListRedTouch(BusinessInfoCheckUpdate.AppInfo appInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, (Object) this, (Object) appInfo);
        } else {
            handleScreenAnimation(appInfo);
            handleItemAnimation(appInfo);
        }
    }

    public String handleLebaText(String str, int i3, int i16, boolean z16) {
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16));
        }
        int i17 = 0;
        for (char c16 : str.toCharArray()) {
            i17++;
            if (('A' <= c16 && c16 <= 'Z') || ('a' <= c16 && c16 <= 'z')) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                i3 = i16;
            }
            if (i17 >= i3) {
                break;
            }
        }
        if (str.length() > i3) {
            String substring = str.substring(0, i3);
            if (z16) {
                return substring + MiniBoxNoticeInfo.APPNAME_SUFFIX;
            }
            return substring;
        }
        return str;
    }

    public boolean hasLebaRedTouch() {
        TextView textView;
        ImageView imageView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        TextView textView2 = this.lebaTvAssists;
        if ((textView2 == null || textView2.getVisibility() != 0) && (((textView = this.lebaTvCorner) == null || textView.getVisibility() != 0) && !hasRedTouch() && ((imageView = this.ivAnimRedDot) == null || imageView.getDrawable() == null))) {
            return false;
        }
        return true;
    }

    public boolean hasSameRedTouch(BusinessInfoCheckUpdate.AppInfo appInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) appInfo)).booleanValue();
        }
        if (appInfo == null || appInfo.iNewFlag.get() == 0 || appInfo.exposure_max.get() < 0 || appInfo.red_display_info.get() == null || appInfo.red_display_info.red_type_info.get() == null || appInfo.red_display_info.red_type_info.get().size() == 0) {
            return false;
        }
        return checkIsEqual(appInfo.red_display_info.red_type_info.get());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        try {
            super.onLayout(z16, i3, i16, i17, i18);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "[onLayout] e = " + e16);
        }
    }

    public void parseRedTouch(BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) redTypeInfo);
            return;
        }
        this.redInfo = redTypeInfo;
        if (redTypeInfo == null) {
            clearRedTouch();
        } else {
            clearRedTouch();
            addRedTouch(redTypeInfo);
        }
    }

    public void parseRedTouchInLebaTable(BusinessInfoCheckUpdate.AppInfo appInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) appInfo);
            return;
        }
        parseRedTouch(appInfo);
        if (this.lebaTvCorner != null) {
            String redTypeInfoCornerText = getRedTypeInfoCornerText(appInfo);
            if (TextUtils.isEmpty(redTypeInfoCornerText)) {
                this.lebaTvCorner.setText("");
                this.lebaTvCorner.setVisibility(8);
            } else {
                this.lebaTvCorner.setText(handleLebaText(redTypeInfoCornerText, 3, 2, false));
                this.lebaTvCorner.setVisibility(0);
            }
        }
        if (this.lebaTvAssists != null) {
            String redTypeInfoText = getRedTypeInfoText(appInfo);
            if (TextUtils.isEmpty(redTypeInfoText)) {
                this.lebaTvAssists.setText("");
                this.lebaTvAssists.setVisibility(8);
            } else {
                this.lebaTvAssists.setText(handleLebaText(redTypeInfoText, 8, 8, true));
                this.lebaTvAssists.setVisibility(0);
            }
        }
        if (this.ivAnimRedDot != null) {
            AnimIconRedDot redTypeInfoAnimUrl = getRedTypeInfoAnimUrl(appInfo);
            IRedTouchTempApi iRedTouchTempApi = (IRedTouchTempApi) QRoute.api(IRedTouchTempApi.class);
            iRedTouchTempApi.removeLebaIconAnim(this.ivAnimRedDot, this.ivIcon, this.tvLabel, this.tvAnimRedDotLabel, this.tvAnimRedDotLabel2);
            if (redTypeInfoAnimUrl != null) {
                this.ivAnimRedDot.setImageDrawable(iRedTouchTempApi.getApngDrawable(this.context, redTypeInfoAnimUrl.getAnimIconUrl()));
                boolean z16 = !TextUtils.isEmpty(redTypeInfoAnimUrl.getAssistText());
                if (z16) {
                    this.tvAnimRedDotLabel.setText(redTypeInfoAnimUrl.getAssistText());
                    this.tvAnimRedDotLabel2.setText(redTypeInfoAnimUrl.getNewlineText());
                }
                iRedTouchTempApi.startLebaIconAnim(this.ivAnimRedDot, this.ivIcon, this.tvLabel, this.tvAnimRedDotLabel, this.tvAnimRedDotLabel2, this.lebaTvAssists, z16, 5000L, redTypeInfoAnimUrl.getSeconds() * 1000, redTypeInfoAnimUrl.getAnimIconUrl());
                if (redTypeInfoAnimUrl.isHasDot()) {
                    processAddRedPoint(0);
                    return;
                }
                return;
            }
            this.ivAnimRedDot.setImageDrawable(null);
            this.tvAnimRedDotLabel.setText("");
            this.tvAnimRedDotLabel2.setText("");
            iRedTouchTempApi.removeLebaIconAnim(this.ivAnimRedDot, this.ivIcon, this.tvLabel, this.tvAnimRedDotLabel, this.tvAnimRedDotLabel2);
        }
    }

    public void parseRedTouchOnlyRedPoint(BusinessInfoCheckUpdate.AppInfo appInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) appInfo);
            return;
        }
        clearRedTouch();
        if (appInfo == null) {
            return;
        }
        this.redTypeInfos.clear();
        if (appInfo.iNewFlag.get() == 0 || appInfo.exposure_max.get() < 0 || appInfo.red_display_info.get() == null || appInfo.red_display_info.red_type_info.get() == null || checkIsEqual(appInfo.red_display_info.red_type_info.get())) {
            return;
        }
        this.redType = appInfo.type.get();
        this.redTypeInfos.addAll(appInfo.red_display_info.red_type_info.get());
        for (BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo : this.redTypeInfos) {
            if (redTypeInfo.red_type.get() == 4) {
                redTypeInfo.red_type.set(-1);
            }
            addRedTouch(redTypeInfo);
        }
    }

    public RedTouch setButtomMargin(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return (RedTouch) iPatchRedirector.redirect((short) 41, (Object) this, i3);
        }
        this.buttomMargin = dipToPixels(i3);
        return this;
    }

    public RedTouch setGravity(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return (RedTouch) iPatchRedirector.redirect((short) 33, (Object) this, i3);
        }
        this.gravity = i3;
        return this;
    }

    public void setHostEnable(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, z16);
            return;
        }
        LinearLayout linearLayout = this.redTouchContainer;
        if (linearLayout != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 4;
            }
            linearLayout.setVisibility(i3);
        }
        this.mHostEnable = z16;
    }

    public RedTouch setImageGravity(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            return (RedTouch) iPatchRedirector.redirect((short) 52, (Object) this, i3);
        }
        this.imageGravity = i3;
        return this;
    }

    public RedTouch setImageRedTouchMargin(float f16, float f17, float f18, float f19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            return (RedTouch) iPatchRedirector.redirect((short) 49, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
        }
        this.imageLeftMargin = dipToPixels(f16);
        this.imageRightMargin = dipToPixels(f17);
        this.imageTopMargin = dipToPixels(f18);
        this.imageBottomMargin = dipToPixels(f19);
        this.imagePosEnable = true;
        return this;
    }

    public RedTouch setImageSize(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            return (RedTouch) iPatchRedirector.redirect((short) 50, (Object) this, i3);
        }
        this.imageRedotSize = i3;
        this.imageSizeEnable = true;
        return this;
    }

    public RedTouch setLeftAlign(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return (RedTouch) iPatchRedirector.redirect((short) 44, (Object) this, z16);
        }
        this.isLeftAlign = z16;
        return this;
    }

    public RedTouch setLeftMargin(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return (RedTouch) iPatchRedirector.redirect((short) 36, (Object) this, i3);
        }
        this.leftMargin = dipToPixels(i3);
        return this;
    }

    public RedTouch setMargin(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (RedTouch) iPatchRedirector.redirect((short) 34, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        }
        this.leftMargin = dipToPixels(i3);
        this.rightMargin = dipToPixels(i16);
        this.topMargin = dipToPixels(i17);
        this.buttomMargin = dipToPixels(i18);
        return this;
    }

    public void setMaxNum(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this, i3);
        } else {
            this.maxNum = i3;
        }
    }

    public RedTouch setRedPointSize(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (RedTouch) iPatchRedirector.redirect((short) 25, (Object) this, i3);
        }
        this.redPointSize = i3;
        return this;
    }

    public RedTouch setRightMargin(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return (RedTouch) iPatchRedirector.redirect((short) 38, this, Float.valueOf(f16));
        }
        this.rightMargin = dipToPixels(f16);
        return this;
    }

    public RedTouch setTopMargin(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return (RedTouch) iPatchRedirector.redirect((short) 40, this, Float.valueOf(f16));
        }
        this.topMargin = dipToPixels(f16);
        return this;
    }

    public RedTouch setUseNewStyle(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return (RedTouch) iPatchRedirector.redirect((short) 46, (Object) this, z16);
        }
        this.isUseNewStyle = z16;
        return this;
    }

    public RedTouch setUseRobotoTtf() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            return (RedTouch) iPatchRedirector.redirect((short) 54, (Object) this);
        }
        this.isUseRobotoTtf = true;
        return this;
    }

    public RedTouch setUseTextColorFromRedTouchConfig(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            return (RedTouch) iPatchRedirector.redirect((short) 47, (Object) this, z16);
        }
        this.useTextColorFromRedTouchConfig = z16;
        return this;
    }

    public boolean showWaterMack() {
        ImageView imageView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        if (hasLebaRedTouch() && ((imageView = this.ivAnimRedDot) == null || imageView.getDrawable() == null)) {
            return true;
        }
        return false;
    }

    public RedTouch(Context context, View view) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) view);
            return;
        }
        this.isApplyTo = false;
        this.defaultGravity = 21;
        this.defaultLeftMargin = 0;
        this.defaultRightMargin = 0;
        this.defaultTopMargin = 0;
        this.defaultButtomMargin = 0;
        this.isUseNewStyle = false;
        this.isUseRobotoTtf = false;
        this.redPointSize = -2;
        this.imageRedotSize = 30;
        this.compactMode = false;
        this.isRedOnTop = false;
        this.useTextColorFromRedTouchConfig = true;
        this.mHostEnable = true;
        this.context = context;
        this.target = view;
        init();
    }

    public boolean hasRedTouch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return ((Boolean) iPatchRedirector.redirect((short) 42, (Object) this)).booleanValue();
        }
        LinearLayout linearLayout = this.redTouchContainer;
        return (linearLayout == null || linearLayout.getChildCount() == 0) ? false : true;
    }

    private boolean checkIsEqual(BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo, BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo2) {
        return redTypeInfo.red_type.get() == redTypeInfo2.red_type.get() && redTypeInfo.red_content.get().equals(redTypeInfo2.red_content.get()) && redTypeInfo.red_desc.get().equals(redTypeInfo2.red_desc.get()) && redTypeInfo.red_priority.get() == redTypeInfo2.red_priority.get();
    }

    public static String getRedTypeInfoText(BusinessInfoCheckUpdate.AppInfo appInfo) {
        if (appInfo != null && appInfo.iNewFlag.get() != 0 && appInfo.exposure_max.get() >= 0 && appInfo.red_display_info.get() != null && appInfo.red_display_info.red_type_info.get() != null) {
            for (BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo : appInfo.red_display_info.red_type_info.get()) {
                if (redTypeInfo != null && (redTypeInfo.red_type.get() == 4 || redTypeInfo.red_type.get() == -100)) {
                    return redTypeInfo.red_content.get();
                }
            }
        }
        return "";
    }

    public void parseRedTouch(BusinessInfoCheckUpdate.AppInfo appInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) appInfo);
            return;
        }
        clearRedTouch();
        if (appInfo == null) {
            return;
        }
        this.redTypeInfos.clear();
        if (appInfo.iNewFlag.get() == 0 || appInfo.exposure_max.get() < 0 || appInfo.red_display_info.get() == null || appInfo.red_display_info.red_type_info.get() == null || checkIsEqual(appInfo.red_display_info.red_type_info.get())) {
            return;
        }
        this.redType = appInfo.type.get();
        this.redTypeInfos.addAll(appInfo.red_display_info.red_type_info.get());
        if (addComplexRedTouch(this.redType, appInfo.red_display_info.red_type_info.get())) {
            return;
        }
        Iterator<BusinessInfoCheckUpdate.RedTypeInfo> it = this.redTypeInfos.iterator();
        while (it.hasNext()) {
            addRedTouch(it.next());
        }
    }
}
