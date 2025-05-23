package com.tenpay.sdk.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.qwallet.utils.QWalletUtils;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.image.sharp.SharpImage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.base.FragmentAnimation;
import com.tencent.mobileqq.mini.utils.SchemaUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.IQWalletHbApi;
import com.tencent.mobileqq.qwallet.hb.detail.HbDetailModule;
import com.tencent.mobileqq.qwallet.hb.skin.HbSkinData;
import com.tencent.mobileqq.qwallet.hb.skin.api.IHbSkinApi;
import com.tencent.mobileqq.qwallet.transaction.impl.NotifyMsgApiImpl;
import com.tencent.mobileqq.vas.pay.api.impl.VasNativePayManagerImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkpublish.api.constant.FSPublishConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tenpay.QwLog;
import com.tenpay.anim.GrabHbViewAnimator;
import com.tenpay.api.QFuncProxy;
import com.tenpay.proxy.QUIProxy;
import com.tenpay.realname.RealNameSource;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.QWalletFakeUrl;
import com.tenpay.sdk.grab.GrabFestivalHbFragment;
import com.tenpay.sdk.grab.HbSenderViewModel;
import com.tenpay.sdk.helper.HBShiMingHelper;
import com.tenpay.sdk.util.HBUtil;
import com.tenpay.sdk.util.HongBaoStateHelper;
import com.tenpay.sdk.util.TenUtils;
import com.tenpay.sdk.util.TenpayUtil;
import com.tenpay.util.Utils;
import cooperation.qwallet.plugin.FakeUrl;
import cooperation.qwallet.plugin.IQWalletHelper;
import cooperation.qwallet.plugin.QWalletPicHelper;
import cooperation.qwallet.pluginshare.ITenCookie;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class GrapHbActivity extends NetBaseActivity implements View.OnClickListener {
    public static final float DEFAULT_COVER_HEIGHT = 116.0f;
    public static final int ERR_GRPB_HB_RETRY = 109028013;
    public static int HB_ShiMing_BIND_RESULT_CODE = 5001;
    public static final String QWALLET_HB_TOP_LING_BG_URL = "https://i.gtimg.cn/channel/imglib/202108/upload_614a54ec6460a7a582363f0616e1a48d.png";
    public static final String QWALLET_HB_TOP_VOICE_BG_URL = "https://i.gtimg.cn/channel/imglib/202109/upload_e5951567e4e73180b4854bb906992b66.png";
    public static final int SPLIT_ANIMATION_DURATION = 400;
    public static final float SPLIT_ANIMATION_FINAL_ALPHA = 0.0f;
    private ViewGroup grabLayerContainer;
    private String hbFrom;
    private ViewGroup hbRootLayout;
    private boolean isFromHBList;
    private String isNeedToRealName;
    private int mChannel;
    private View mCloseBtn;
    private ImageView mGrabBtn;
    private ObjectAnimator mGrabOpenAnimator;
    private String mGroupId;
    private String mGroupType;
    private String mGroupUin;
    private String mGuildId;
    private TextView mHBCount;
    private int mHBSkinId;
    private ImageView mHbAvatar;
    private ImageView mHbBottomBg;
    private View mHbContentLayout;
    private JSONObject mHbData;
    private TextView mHbDetailBtn;
    private LinearLayout mHbMoneyLayout;
    private String mHbSenderUin;
    private HbSenderViewModel mHbSenderVm;
    private HbSkinData mHbSkinData;
    private RelativeLayout mHbTextInfo;
    private ImageView mHbTopBg;
    private LinearLayout mIdiomMoneyLayout;
    private TextView mIdiomMoneyText;
    private LinearLayout mLingInfoLayout;
    private TextView mLingSubTitle;
    private TextView mLingTitle;
    private String mMatchToken;
    private String mPayFlag;
    private String mPreGrabToken;
    private String mQrCodeStr;
    private ViewGroup mRotateContainer;
    private ImageView mSenderIcon;
    private TextView mSenderInfo;
    private ViewGroup mSenderLayout;
    private TextView mSenderName;
    private TextView mSkinHbTitle;
    private ImageView mSpecialShapeBg;
    private String mSubGuildId;
    private String mTinyId;
    private TextView mWishWord;
    private String outerHBSkinId;
    private int skinFrom;
    private int skinType;
    private String subChannel;
    private String mSenderIconPath = "";
    private String mSenderShowName = "";
    private String mSenderIconUrl = "";
    private String mListId = "";
    private String mName = "";
    private String mAnswer = "";
    private String mAuthKey = "";
    private JSONObject mSendObj = null;
    private JSONObject mRecvObj = null;
    private JSONObject mSelfObj = null;
    private JSONArray mRecvArray = null;
    private int mGrapHBState = -1;
    private int mProcessFlag = 129;
    private boolean isShowH5HbDetail = false;
    private int zplanResType = 0;

    private void animateGrabOpenIcon() {
        ImageView imageView = this.mGrabBtn;
        if (imageView == null) {
            return;
        }
        imageView.clearAnimation();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mGrabBtn, BasicAnimation.KeyPath.ROTATION_Y, 0.0f, 360.0f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setDuration(1000L);
        ofFloat.start();
        this.mGrabOpenAnimator = ofFloat;
    }

    private void doExceedLimit() {
        RealNameSource realNameSource;
        String optString = this.mHbData.optString("retmsg");
        String optString2 = this.mHbData.optString("returl");
        if (HBUtil.isHbForFaceToFace(this.mChannel)) {
            realNameSource = new RealNameSource("16");
        } else if (((IQWalletHbApi) QRoute.api(IQWalletHbApi.class)).isGuildAIO(this.mGroupType)) {
            realNameSource = new RealNameSource("14");
        } else if (((IQWalletHbApi) QRoute.api(IQWalletHbApi.class)).isC2CAIO(this.mGroupType)) {
            realNameSource = new RealNameSource("12");
        } else {
            realNameSource = new RealNameSource("13");
        }
        HBShiMingHelper.doAction(this, HB_ShiMing_BIND_RESULT_CODE, this.mUin, optString2, optString, realNameSource);
    }

    private Animator getAnimator(View view, boolean z16, float f16) {
        float f17;
        float f18;
        float screenWidth = Utils.getScreenWidth(getContext());
        float screenHeight = Utils.getScreenHeight(getContext());
        int width = view.getWidth();
        if (width != 0) {
            f17 = screenWidth / width;
        } else {
            f17 = 0.0f;
        }
        view.getLocationOnScreen(new int[2]);
        if (z16) {
            f18 = -((r4[1] + view.getHeight()) - f16);
        } else {
            f18 = (screenHeight - r4[1]) - f16;
        }
        return ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat(com.tencent.luggage.wxa.c8.c.f123400v, view.getAlpha(), view.getAlpha(), 0.0f), PropertyValuesHolder.ofFloat(BasicAnimation.KeyPath.SCALE_X, view.getScaleX(), f17), PropertyValuesHolder.ofFloat(BasicAnimation.KeyPath.SCALE_Y, view.getScaleY(), f17), PropertyValuesHolder.ofFloat("translationY", f18));
    }

    private boolean initDataByIntent(Intent intent) {
        this.mUin = intent.getStringExtra("uin");
        this.mListId = intent.getStringExtra("listid");
        this.mGroupId = intent.getStringExtra(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID);
        this.mGroupType = intent.getStringExtra("grouptype");
        this.mGroupUin = intent.getStringExtra("groupuin");
        this.mTinyId = intent.getStringExtra("tinyId");
        this.mGuildId = intent.getStringExtra("guildId");
        this.mSubGuildId = intent.getStringExtra("subGuildId");
        this.mPayFlag = intent.getStringExtra("pay_flag");
        this.mHbSenderUin = intent.getStringExtra("hb_sender_uin");
        this.mName = intent.getStringExtra("name");
        QwLog.i("mName is " + this.mName);
        this.mAnswer = intent.getStringExtra("answer");
        this.mAuthKey = intent.getStringExtra("authkey");
        QwLog.i("authkey is " + this.mAuthKey);
        String stringExtra = intent.getStringExtra(WadlProxyConsts.CHANNEL);
        try {
            if (!TextUtils.isEmpty(stringExtra)) {
                this.mChannel = Integer.parseInt(stringExtra);
            }
            this.isFromHBList = "1".equals(intent.getStringExtra("fromHBList"));
            this.subChannel = intent.getStringExtra("subchannel");
            try {
                this.mHBSkinId = Integer.parseInt(intent.getStringExtra("skin_id"));
                this.skinFrom = Integer.parseInt(intent.getStringExtra("skin_from"));
                this.skinType = Integer.parseInt(intent.getStringExtra("skin_type"));
            } catch (NumberFormatException e16) {
                QLog.e(((NetBaseActivity) this).TAG, 1, e16, new Object[0]);
            }
            this.outerHBSkinId = intent.getStringExtra("outer_skin_id");
            this.hbFrom = intent.getStringExtra("hb_from");
            this.mMatchToken = intent.getStringExtra("matchToken");
            if (HBUtil.isHbForFaceToFace(this.mChannel)) {
                this.mQrCodeStr = intent.getStringExtra("qr_data");
            }
            return true;
        } catch (NumberFormatException e17) {
            QLog.e(((NetBaseActivity) this).TAG, 1, e17, new Object[0]);
            return false;
        }
    }

    private void initH5HbGrab(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("send_object");
            if (optJSONObject == null) {
                return;
            }
            String optString = optJSONObject.optString("listid");
            this.mListId = optString;
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(this.mUin)) {
                this.isShowH5HbDetail = true;
                processData(jSONObject);
            }
        } catch (JSONException e16) {
            QLog.e(((NetBaseActivity) this).TAG, 1, e16, new Object[0]);
        }
    }

    private void initHbSenderViewModel() {
        final HbSenderViewModel hbSenderViewModel = (HbSenderViewModel) new ViewModelProvider(this).get(HbSenderViewModel.class);
        hbSenderViewModel.getSendIconLiveData().observe(getViewLifecycleOwner(), new Observer<Bitmap>() { // from class: com.tenpay.sdk.activity.GrapHbActivity.1
            @Override // androidx.lifecycle.Observer
            public void onChanged(Bitmap bitmap) {
                if (bitmap != null) {
                    GrapHbActivity.this.mSenderIcon.setImageBitmap(bitmap);
                }
                GrapHbActivity.this.mSenderIconPath = hbSenderViewModel.getMSenderIconPath();
            }
        });
        hbSenderViewModel.getSendIconDrawableLiveData().observe(getViewLifecycleOwner(), new Observer<Drawable>() { // from class: com.tenpay.sdk.activity.GrapHbActivity.2
            @Override // androidx.lifecycle.Observer
            public void onChanged(Drawable drawable) {
                if (drawable != null) {
                    GrapHbActivity.this.mSenderIcon.setImageDrawable(drawable);
                }
                GrapHbActivity.this.mSenderIconUrl = hbSenderViewModel.getMSenderIconUrl();
            }
        });
        hbSenderViewModel.getSendTextLiveData().observe(getViewLifecycleOwner(), new Observer<String>() { // from class: com.tenpay.sdk.activity.GrapHbActivity.3
            @Override // androidx.lifecycle.Observer
            public void onChanged(String str) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                GrapHbActivity.this.mSenderShowName = str;
                Object[] objArr = new Object[1];
                objArr[0] = HBUtil.getHbTypeText(GrapHbActivity.this.mChannel, GrapHbActivity.this.mSendObj == null ? 0 : GrapHbActivity.this.mSendObj.optInt("bus_type"));
                String format = String.format("\u53d1\u51fa\u7684%s\u7ea2\u5305", objArr);
                GrapHbActivity.this.mSenderName.setText(str);
                GrapHbActivity.this.mSenderInfo.setText(format);
                GrapHbActivity.this.mLingSubTitle.setText("\u2500\u2500 " + str + format);
            }
        });
        this.mHbSenderVm = hbSenderViewModel;
    }

    private boolean initQZoneHb(@NonNull String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!"2".equals(jSONObject.optString("hb_state")) || !"101".equals(this.mGroupType)) {
                return false;
            }
            QwLog.e("show grapped out directly");
            this.mGrapHBState = 2;
            popHbLayout(false);
            showHbInvalidUI(getString(R.string.e8r));
            this.mHbSenderVm.update(jSONObject, this.mGroupId, getActivity());
            return true;
        } catch (JSONException e16) {
            QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
            return false;
        }
    }

    private void initView(View view) {
        View findViewById = view.findViewById(R.id.f165657d13);
        this.mHbContentLayout = findViewById;
        QWalletUtils.v(findViewById, 9.5f);
        ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.x6s);
        this.mRotateContainer = viewGroup;
        viewGroup.setClickable(true);
        this.mHbTopBg = (ImageView) view.findViewById(R.id.f67503di);
        this.mHbBottomBg = (ImageView) view.findViewById(R.id.f67343d3);
        this.mHbAvatar = (ImageView) view.findViewById(R.id.f67323d1);
        this.mSpecialShapeBg = (ImageView) view.findViewById(R.id.f87224ts);
        this.mHbTextInfo = (RelativeLayout) view.findViewById(R.id.d1z);
        this.mSkinHbTitle = (TextView) view.findViewById(R.id.f85894q7);
        TextView textView = (TextView) view.findViewById(R.id.f165661x63);
        this.mHbDetailBtn = textView;
        textView.setOnClickListener(this);
        this.mSenderIcon = (ImageView) view.findViewById(R.id.f8321int);
        this.mSenderName = (TextView) view.findViewById(R.id.f83234j0);
        this.mSenderInfo = (TextView) view.findViewById(R.id.inv);
        this.mSenderLayout = (ViewGroup) view.findViewById(R.id.d1p);
        this.mWishWord = (TextView) view.findViewById(R.id.l48);
        this.mLingInfoLayout = (LinearLayout) view.findViewById(R.id.x6t);
        this.mLingTitle = (TextView) view.findViewById(R.id.f67403d9);
        this.mLingSubTitle = (TextView) view.findViewById(R.id.f67393d8);
        this.mIdiomMoneyLayout = (LinearLayout) view.findViewById(R.id.x6q);
        this.mIdiomMoneyText = (TextView) view.findViewById(R.id.x6p);
        this.mHBCount = (TextView) view.findViewById(R.id.d16);
        this.mHbMoneyLayout = (LinearLayout) view.findViewById(R.id.d1j);
        this.mGrabBtn = (ImageView) view.findViewById(R.id.f67373d6);
        Typeface createFromAsset = Typeface.createFromAsset(getAssets(), VasNativePayManagerImpl.DINALTERNATE_BOLD_FONT_PATH);
        this.mHBCount.setTypeface(createFromAsset);
        this.mIdiomMoneyText.setTypeface(createFromAsset);
        this.hbRootLayout = (ViewGroup) view.findViewById(R.id.f67443dc);
        this.grabLayerContainer = (ViewGroup) view.findViewById(R.id.vrk);
        View findViewById2 = view.findViewById(R.id.az7);
        this.mCloseBtn = findViewById2;
        findViewById2.setOnClickListener(this);
        this.hbRootLayout.setOnClickListener(this);
    }

    private void initViewModel() {
        initHbSenderViewModel();
    }

    private boolean isGrapIdiomHbFailed() {
        JSONObject jSONObject;
        int i3 = this.mGrapHBState;
        if ((i3 == 12 || i3 == 14) && (jSONObject = this.mSendObj) != null && HBUtil.isIdiomHb(jSONObject.optInt(WadlProxyConsts.CHANNEL))) {
            return true;
        }
        return false;
    }

    private boolean isNeedSendBroadcast() {
        if (!isGrapIdiomHbFailed() && !TextUtils.equals("2", this.subChannel)) {
            return false;
        }
        return true;
    }

    private boolean isResourceTheSame(HbSkinData hbSkinData) {
        HbSkinData hbSkinData2 = this.mHbSkinData;
        if (hbSkinData2 == null || !TextUtils.equals(hbSkinData2.getDefaultSkinUrl(), hbSkinData.getDefaultSkinUrl()) || !TextUtils.equals(this.mHbSkinData.getPopResUrl(), hbSkinData.getPopResUrl()) || !TextUtils.equals(this.mHbSkinData.getPopBrokenUrl(), hbSkinData.getPopBrokenUrl()) || !TextUtils.equals(this.mHbSkinData.getPopOpenUrl(), hbSkinData.getPopOpenUrl())) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$preloadHbSkinStory$2() {
        final HbSkinData skinDataFromLocal = ((IHbSkinApi) QRoute.api(IHbSkinApi.class)).getSkinDataFromLocal(this.mHBSkinId, this.outerHBSkinId, this.skinFrom);
        if (skinDataFromLocal != null) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tenpay.sdk.activity.av
                @Override // java.lang.Runnable
                public final void run() {
                    GrapHbActivity.this.lambda$preloadHbSkinStory$1(skinDataFromLocal);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$preloadHbSkinStory$4(final HbSkinData hbSkinData) {
        if (hbSkinData != null) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tenpay.sdk.activity.ay
                @Override // java.lang.Runnable
                public final void run() {
                    GrapHbActivity.this.lambda$preloadHbSkinStory$3(hbSkinData);
                }
            });
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPreGrabView$0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.mGrabBtn.setClickable(false);
        sendGrapHbRequest(true);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    /* renamed from: loadHBSkinTask, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void lambda$preloadHbSkinStory$3(@NonNull HbSkinData hbSkinData) {
        Context context = getContext();
        if (context == null || isFinishing() || isResourceTheSame(hbSkinData)) {
            return;
        }
        this.mHbSkinData = hbSkinData;
        Drawable drawable = ContextCompat.getDrawable(context, R.drawable.nvn);
        if ((hbSkinData.getSkinType() & 4) != 0) {
            this.mHbTopBg.setScaleType(ImageView.ScaleType.CENTER_CROP);
            QWalletPicHelper.setNetDrawableForAIO(this.mHbTopBg, hbSkinData.getDefaultSkinUrl(), hbSkinData.getAioResUrl(), drawable);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString(QWalletPicHelper.KEY_EXTRA_CACHE_SUFFIX, this.mListId);
            this.mHbTopBg.setImageDrawable(QWalletPicHelper.getNetDrawableForQWallet(hbSkinData.getPopResUrl(), drawable, drawable, bundle));
        }
        String popBrokenUrl = hbSkinData.getPopBrokenUrl();
        if ((hbSkinData.getSkinType() & 8) != 0 && !TextUtils.isEmpty(popBrokenUrl)) {
            Drawable drawable2 = ContextCompat.getDrawable(context, R.drawable.nuz);
            Bundle bundle2 = new Bundle();
            bundle2.putString(QWalletPicHelper.KEY_EXTRA_CACHE_SUFFIX, this.mListId);
            this.mSpecialShapeBg.setVisibility(0);
            this.mSpecialShapeBg.setImageDrawable(QWalletPicHelper.getNetDrawableForQWallet(hbSkinData.getPopBrokenUrl(), drawable2, drawable2, bundle2));
            this.mHbContentLayout.setVisibility(4);
        }
        ((IQWalletHbApi) QRoute.api(IQWalletHbApi.class)).updateOpenIcon(this.mGrabBtn, hbSkinData.getPopOpenUrl());
    }

    private void onClosed(boolean z16) {
        sendHBStateBroadcast(IQWalletHelper.TROOP_HBLIST_CLOSE_RESULT_CODE);
        if (z16) {
            tenpayReport("redpackets.opened.keyback");
        } else {
            tenpayReport("redpackets.opened.back");
        }
        QwLog.i("onClick mBackBtn");
        sendMyCallBack();
        HBUtil.notifyGrapedHbClose(getContext(), this.mGrapHBState, this.mRecvObj, this.mSendObj, getIntent());
        finish();
    }

    private void popHbLayout(boolean z16) {
        String str;
        if (z16) {
            this.mGrabBtn.setVisibility(0);
            this.mHbBottomBg.setImageResource(R.drawable.nvd);
        } else {
            this.mGrabBtn.setVisibility(8);
            this.mHbBottomBg.setImageResource(R.drawable.nve);
        }
        this.mSkinHbTitle.setVisibility(8);
        Drawable drawable = getApplicationContext().getDrawable(R.drawable.nvn);
        if (HBUtil.isHbForCommand(this.mChannel)) {
            Bundle bundle = new Bundle();
            bundle.putString(QWalletPicHelper.KEY_EXTRA_CACHE_SUFFIX, this.mListId);
            if (this.mChannel == 65536) {
                str = QWALLET_HB_TOP_VOICE_BG_URL;
            } else {
                str = QWALLET_HB_TOP_LING_BG_URL;
            }
            this.mHbTopBg.setImageDrawable(QWalletPicHelper.getDrawableForQWallet(str, drawable, bundle));
        }
        if (this.hbRootLayout.getVisibility() != 0) {
            this.hbRootLayout.setVisibility(0);
            new GrabHbViewAnimator(this.grabLayerContainer, this.mCloseBtn).start();
        }
    }

    private void preloadHbSkinStory() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tenpay.sdk.activity.aw
            @Override // java.lang.Runnable
            public final void run() {
                GrapHbActivity.this.lambda$preloadHbSkinStory$2();
            }
        }, 32, null, false);
        ((IHbSkinApi) QRoute.api(IHbSkinApi.class)).updateSkinData(this.mHBSkinId, this.outerHBSkinId, this.skinFrom, new Function1() { // from class: com.tenpay.sdk.activity.ax
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit lambda$preloadHbSkinStory$4;
                lambda$preloadHbSkinStory$4 = GrapHbActivity.this.lambda$preloadHbSkinStory$4((HbSkinData) obj);
                return lambda$preloadHbSkinStory$4;
            }
        });
    }

    private void processData(JSONObject jSONObject) {
        String str;
        String str2;
        HongBaoStateHelper.extractFromHbData(jSONObject);
        this.mHbData = jSONObject;
        QwLog.e(jSONObject.toString());
        this.mGrapHBState = jSONObject.optInt("state", -1);
        this.isNeedToRealName = jSONObject.optString("need_realname_flag");
        this.mSendObj = jSONObject.optJSONObject("send_object");
        this.mRecvObj = jSONObject.optJSONObject("recv_object");
        this.mSelfObj = jSONObject.optJSONObject("self_object");
        this.mRecvArray = jSONObject.optJSONArray("recv_array");
        if (isNeedSendBroadcast()) {
            sendIdiomHBBroadcast();
        }
        JSONObject jSONObject2 = this.mRecvObj;
        if (jSONObject2 == null) {
            str = "";
        } else {
            str = jSONObject2.optString("amount");
        }
        JSONObject jSONObject3 = this.mSendObj;
        if (jSONObject3 == null) {
            showHbDetail();
            return;
        }
        String optString = jSONObject3.optString("listid");
        String optString2 = this.mSendObj.optString("hb_from", this.hbFrom);
        int optInt = this.mSendObj.optInt(WadlProxyConsts.CHANNEL);
        int optInt2 = this.mSendObj.optInt("act_type", 0);
        String optString3 = this.mSendObj.optString("act_url");
        if (HBUtil.isH5CommonHb(optString2) && optInt2 != 0) {
            try {
                if (processH5ComoonHb(optString2, optInt2, optString3, optString)) {
                    return;
                }
            } catch (JSONException e16) {
                QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
            }
        } else if (HBUtil.isHbForFaceToFace(this.mChannel)) {
            String optString4 = this.mSendObj.optString("send_listid");
            if (!TextUtils.isEmpty(optString4)) {
                this.mListId = optString4;
            }
        } else if (HBUtil.isHbForAnonymity(optInt)) {
            if ("6".equals(this.mGroupType)) {
                this.mProcessFlag = 148;
            } else {
                this.mProcessFlag = 147;
            }
        } else if (HBUtil.isHbForCommand(optInt)) {
            if (optInt == 65536) {
                this.mProcessFlag = 162;
            } else {
                this.mProcessFlag = 152;
            }
        } else if (optInt == 64) {
            this.mProcessFlag = 156;
        } else if (HBUtil.isIdiomHb(optInt)) {
            this.mProcessFlag = 500;
        } else if (HBUtil.isDrawHb(optInt)) {
            this.mProcessFlag = 501;
        }
        try {
            String optString5 = this.mSendObj.optString("is_h5");
            if (!TextUtils.isEmpty(optString5) && optString5.equals("1") && !TextUtils.isEmpty(optString3)) {
                if (optString2.equals("2")) {
                    if (optString3.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) == -1) {
                        str2 = optString3 + "?listId=" + optString;
                    } else {
                        str2 = optString3 + "&listId=" + optString;
                    }
                    QWalletUtils.k(getActivity(), str2);
                    JSONObject jSONObject4 = new JSONObject();
                    JSONObject jSONObject5 = new JSONObject();
                    jSONObject5.put("listid", optString);
                    jSONObject5.put("name", this.mName);
                    jSONObject5.put("grouptype", this.mGroupType);
                    jSONObject5.put(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID, this.mGroupId);
                    jSONObject5.put(WadlProxyConsts.CHANNEL, this.mChannel);
                    jSONObject5.put("skin_id", this.mHBSkinId);
                    jSONObject5.put("fromHBList", this.isFromHBList);
                    jSONObject5.put("senderuin", this.mSendObj.optString("send_uin"));
                    jSONObject5.put("hg_sign", this.mSendObj.optString("hg_sign"));
                    String str3 = this.mGroupUin;
                    if (str3 != null) {
                        jSONObject5.put("groupuin", str3);
                    }
                    String str4 = this.mAuthKey;
                    if (str4 != null) {
                        jSONObject5.put("authkey", str4);
                    }
                    jSONObject5.put("hb_from", optString2);
                    jSONObject5.put(com.tencent.mobileqq.msf.core.c0.j.T0, this.mAppInfo);
                    jSONObject4.put("extra_data", jSONObject5);
                    QFuncProxy.clearTempArgs(null);
                    QFuncProxy.setTempArgs(optString, jSONObject5.toString());
                    finish();
                    return;
                }
                if (optString2.equals("1") && !TextUtils.isEmpty(str)) {
                    String optString6 = this.mSendObj.optString("wishing");
                    String optString7 = this.mSendObj.optString("feedsid");
                    JSONObject jSONObject6 = new JSONObject();
                    jSONObject6.put("wishing", optString6);
                    jSONObject6.put("amount", str);
                    jSONObject6.put("feedsid", optString7);
                    if (!TextUtils.isEmpty(optString)) {
                        QFuncProxy.clearTempArgs(null);
                        QFuncProxy.setTempArgs(optString, jSONObject6.toString());
                        QWalletUtils.k(getActivity(), optString3);
                        finish();
                        return;
                    }
                }
            }
        } catch (Throwable th5) {
            QLog.e(((NetBaseActivity) this).TAG, 1, "", th5);
        }
        showHbDetail();
    }

    private void processFestivalHbGrab() {
        String str;
        String str2;
        if (isFinishing()) {
            return;
        }
        int i3 = this.mGrapHBState;
        if (i3 == 5) {
            doExceedLimit();
            return;
        }
        if (i3 == 7) {
            showAgreementDialog();
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("grab_status", this.mGrapHBState);
        intent.putExtra("grab_skin_id", this.mHBSkinId);
        intent.putExtra("grab_group_id", this.mGroupId);
        JSONObject jSONObject = this.mSendObj;
        String str3 = "";
        if (jSONObject == null) {
            str = "";
        } else {
            str = jSONObject.toString();
        }
        intent.putExtra("send_object", str);
        JSONObject jSONObject2 = this.mSelfObj;
        if (jSONObject2 == null) {
            str2 = "";
        } else {
            str2 = jSONObject2.toString();
        }
        intent.putExtra("self_object", str2);
        JSONObject jSONObject3 = this.mRecvObj;
        if (jSONObject3 != null) {
            str3 = jSONObject3.toString();
        }
        intent.putExtra("recv_object", str3);
        intent.putExtra("public_fragment_window_feature", 1);
        QPublicTransFragmentActivity.start(getQBaseActivity(), intent, GrabFestivalHbFragment.class);
        finish();
    }

    private boolean processH5ComoonHb(String str, int i3, String str2, String str3) throws JSONException {
        String str4;
        if (101 == i3) {
            if (TextUtils.isEmpty(str2)) {
                return false;
            }
            if (str2.startsWith(SchemaUtils.SCHEMA_MQQAPI)) {
                HashMap hashMap = new HashMap();
                hashMap.put("uin", this.mUin);
                str2 = x05.c.a(str2, hashMap, true);
                if (QLog.isColorLevel()) {
                    QLog.i(((NetBaseActivity) this).TAG, 2, "[go to miniapp] finalActUrl: " + str2);
                }
            }
            QWalletUtils.k(getActivity(), str2);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("listid", str3);
            jSONObject.put("name", this.mName);
            jSONObject.put("grouptype", this.mGroupType);
            jSONObject.put(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID, this.mGroupId);
            jSONObject.put(WadlProxyConsts.CHANNEL, this.mChannel);
            jSONObject.put("skin_id", this.mHBSkinId);
            jSONObject.put("fromHBList", this.isFromHBList);
            JSONObject jSONObject2 = this.mSendObj;
            if (jSONObject2 != null) {
                jSONObject.put("senderuin", jSONObject2.optString("send_uin"));
            }
            String str5 = this.mGroupUin;
            if (str5 != null) {
                jSONObject.put("groupuin", str5);
            }
            String str6 = this.mAuthKey;
            if (str6 != null) {
                jSONObject.put("authkey", str6);
            }
            jSONObject.put("hb_from", str);
            jSONObject.put(com.tencent.mobileqq.msf.core.c0.j.T0, this.mAppInfo);
            String str7 = str3 + "_" + TenUtils.getArguments(str2).get("pre_code");
            QwLog.d("cacheKey: " + str7);
            QFuncProxy.clearTempArgs(str7);
            QFuncProxy.setTempArgs(str7, jSONObject.toString());
            QwLog.d("cache authkey: " + jSONObject.toString());
            QFuncProxy.putEncryptValue(this.mUin, str7, getSharedPreferences(ITenCookie.QB_TENPAY_HB_SP_NAME + this.mUin, 4), jSONObject.toString());
            JSONObject jSONObject3 = new JSONObject();
            JSONObject jSONObject4 = new JSONObject();
            JSONObject jSONObject5 = this.mSendObj;
            if (jSONObject5 != null) {
                jSONObject4.put("send_object", jSONObject5);
            }
            JSONObject jSONObject6 = this.mSelfObj;
            if (jSONObject6 != null) {
                jSONObject4.put("self_object", jSONObject6);
            }
            JSONArray jSONArray = this.mRecvArray;
            if (jSONArray != null) {
                jSONObject4.put("recv_array", jSONArray);
            }
            jSONObject3.put("detail_data", jSONObject4);
            QFuncProxy.clearTempArgs(str3);
            QFuncProxy.setTempArgs(str3, jSONObject3.toString());
            QwLog.d("cache detail data: " + jSONObject3.toString());
            getSharedPreferences("common_h5_hb_info" + this.mUin, 4).edit().putString(str3, jSONObject3.toString()).apply();
            finish();
            return true;
        }
        if (103 != i3) {
            return false;
        }
        int i16 = this.mGrapHBState;
        if (i16 != 2) {
            if (i16 != 6) {
                if (i16 != 8) {
                    switch (i16) {
                        case 12:
                            if (TextUtils.equals("3", this.subChannel)) {
                                str4 = "\u63a5\u9f99\u8bd7\u8bcd\u5df2\u66f4\u65b0~";
                                break;
                            } else {
                                str4 = "\u63a5\u9f99\u8bcd\u8bed\u5df2\u66f4\u65b0~";
                                break;
                            }
                        case 13:
                            str4 = "\u8be5\u5355\u8bcd\u5df2\u88ab\u7528\u8fc7\u5566\uff0c\u6362\u4e00\u4e2a\u5355\u8bcd\u5427";
                            break;
                        case 14:
                            str4 = "\u8be5\u9996\u8bd7\u8bcd\u5df2\u63a5\u9f99\u7ed3\u675f";
                            break;
                        default:
                            str4 = "\u8fd9\u4e2a\u7ea2\u5305\u5931\u6548\u4e86\u54e6~";
                            break;
                    }
                } else {
                    str4 = "\u975e\u5b9a\u5411\u8005\u4e0d\u80fd\u62a2\u8fd9\u4e2a\u7ea2\u5305";
                }
            } else {
                str4 = "\u672c\u4eba\u4e0d\u80fd\u62a2\u81ea\u5df1\u7684\u7ea2\u5305";
            }
        } else {
            str4 = "\u8fd9\u4e2a\u7ea2\u5305\u5df2\u7ecf\u88ab\u62a2\u5b8c";
        }
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        if (str2.startsWith(SchemaUtils.SCHEMA_MQQAPI)) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("uin", this.mUin);
            str2 = x05.c.a(str2, hashMap2, true);
            if (QLog.isColorLevel()) {
                QLog.i(((NetBaseActivity) this).TAG, 2, "[go to miniapp] finalActUrl: " + str2);
            }
        }
        QWalletUtils.k(getActivity(), str2);
        SharedPreferences sharedPreferences = getSharedPreferences("common_h5_hb_info" + this.mUin, 0);
        JSONObject jSONObject7 = new JSONObject();
        jSONObject7.put("retcode", this.mGrapHBState);
        jSONObject7.put("retmsg", str4);
        JSONObject jSONObject8 = new JSONObject();
        jSONObject8.put("exception_data", jSONObject7);
        jSONObject8.put("authkey", this.mAuthKey);
        jSONObject8.put("grouptype", this.mGroupType);
        jSONObject8.put(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID, this.mGroupId);
        QFuncProxy.clearTempArgs(str3);
        QFuncProxy.setTempArgs(str3, jSONObject8.toString());
        sharedPreferences.edit().putString(str3, jSONObject8.toString()).apply();
        finish();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveAgreementFlag() {
        SharedPreferences.Editor edit = getSharedPreferences("qb_tenpay_hb_" + this.mUin, 0).edit();
        edit.putBoolean("agree_wallet_contrace", true);
        edit.commit();
    }

    private void sendHBStateBroadcast(int i3) {
        int i16 = this.mGrapHBState;
        if (i16 != 5 && i16 != 7) {
            QwLog.i("sendHBStateBroadcast mListid : " + this.mListId);
            QwLog.i("sendHBStateBroadcast isFromHBList : " + this.isFromHBList);
            if (this.isFromHBList) {
                Intent intent = new Intent(IQWalletHelper.TROOP_HBLIST_BROADCAST_ACTION);
                intent.putExtra("grap_hb_state", this.mGrapHBState);
                intent.putExtra("listid", this.mListId);
                intent.putExtra("result_code", i3);
                sendBroadcast(intent);
            }
        }
    }

    private void sendIdiomHBBroadcast() {
        try {
            if (this.mSendObj == null) {
                return;
            }
            Intent intent = new Intent("grap_idiom_hb_result_action");
            intent.putExtra("listid", this.mListId);
            intent.putExtra("grap_hb_state", this.mGrapHBState);
            intent.putExtra("grap_hb_idiom", this.mSendObj.optString("hb_idiom"));
            intent.putExtra("grap_hb_seq", this.mSendObj.optInt("idiom_seq"));
            intent.putExtra("grap_idiom_alpha", this.mSendObj.optString("idiom_alpha"));
            intent.putExtra("grap_poem_rule", this.mSendObj.optString("poem_rule"));
            if (!TextUtils.isEmpty(this.mGroupId)) {
                intent.putExtra("grap_hb_frienduin", this.mGroupId);
            }
            sendBroadcast(intent);
            QwLog.i("sendIdiomHBBroadcast listid:" + this.mListId + " state:" + this.mGrapHBState + " idiom:" + this.mSendObj.optString("hb_idiom") + " seq:" + this.mSendObj.optInt("idiom_seq") + " alpha:" + this.mSendObj.optString("idiom_alpha") + " frienduin:" + this.mGroupId);
        } catch (Throwable th5) {
            QwLog.i(th5.toString());
        }
    }

    private void showAgreementDialog() {
        SpannableString spannableString = new SpannableString(getString(R.string.e4t) + getString(R.string.e4u));
        spannableString.setSpan(new ClickableSpan() { // from class: com.tenpay.sdk.activity.GrapHbActivity.6
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                GrapHbActivity.this.gotoH5(Cgi.URI_QWALLET_CONTRACT);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setUnderlineText(false);
            }
        }, 14, spannableString.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.login_error_url)), 14, spannableString.length(), 33);
        QUIProxy.createCustomDialogUrlWithoutAutoLink(getContext(), 230, null, spannableString, R.string.e5h, R.string.e4s, new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.GrapHbActivity.7
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                GrapHbActivity.this.saveAgreementFlag();
                GrapHbActivity.this.sendGrapHbRequest(true);
                dialogInterface.dismiss();
                GrapHbActivity.this.tenpayReport("redpackets.identify.agree");
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.GrapHbActivity.8
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                dialogInterface.dismiss();
                GrapHbActivity.this.tenpayReport("redpackets.identify.close");
                GrapHbActivity.this.finish();
            }
        });
        tenpayReport("redpackets.identify.show");
    }

    private void showHbInvalidUI(String str) {
        this.mHbMoneyLayout.setVisibility(8);
        this.mSenderLayout.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.mWishWord.setText(str);
        }
        this.mHbDetailBtn.setVisibility(8);
        this.mLingInfoLayout.setVisibility(8);
        this.mIdiomMoneyLayout.setVisibility(8);
        this.mHbTextInfo.setVisibility(0);
        int parseColor = Color.parseColor("#A61C0303");
        if ((this.skinType & 8) != 0) {
            this.mSpecialShapeBg.setColorFilter(parseColor);
        } else if (this.mHBSkinId <= 0 && TextUtils.isEmpty(this.outerHBSkinId)) {
            this.mHbTopBg.setForeground(null);
        } else {
            this.mHbTopBg.setForeground(new ColorDrawable(parseColor));
        }
    }

    private void showPreGrabView(String str) {
        String str2;
        if ((this.mHBSkinId > 0 || !TextUtils.isEmpty(this.outerHBSkinId)) && this.mChannel == 1) {
            this.mHbTextInfo.setVisibility(8);
            this.mSkinHbTitle.setVisibility(0);
            this.mSkinHbTitle.setText(str);
        }
        this.mGrabBtn.setVisibility(0);
        this.mGrabBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.activity.au
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GrapHbActivity.this.lambda$showPreGrabView$0(view);
            }
        });
        if (((IQWalletHbApi) QRoute.api(IQWalletHbApi.class)).isGuildAIO(this.mGroupType)) {
            str2 = this.mTinyId;
        } else {
            str2 = this.mUin;
        }
        if (TextUtils.equals(str2, this.mHbSenderUin) && this.mChannel == 1) {
            this.mHbDetailBtn.setVisibility(0);
            this.mSkinHbTitle.setVisibility(8);
        } else {
            this.mHbDetailBtn.setVisibility(8);
        }
    }

    private void stopGrabOpenIconAnimation() {
        if (this.mGrabBtn == null) {
            return;
        }
        ObjectAnimator objectAnimator = this.mGrabOpenAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        ImageView imageView = this.mGrabBtn;
        if (imageView != null) {
            imageView.clearAnimation();
            this.mGrabBtn.setRotationY(0.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tenpayReport(@NonNull String str) {
        com.tencent.mobileqq.qwallet.c.c(str, Integer.valueOf(getProcessType()));
    }

    private void toHbDetailWithAnimation(ViewGroup viewGroup, View view, View view2, View view3) {
        viewGroup.getOverlay().add(view2);
        viewGroup.getOverlay().add(view3);
        view.setVisibility(4);
        AnimatorListenerAdapter animatorListenerAdapter = new AnimatorListenerAdapter() { // from class: com.tenpay.sdk.activity.GrapHbActivity.4
            private boolean isStarted = false;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!this.isStarted) {
                    this.isStarted = true;
                    GrapHbActivity.this.goToHbDetailActivity(false);
                }
                if (!GrapHbActivity.this.isFinishing()) {
                    GrapHbActivity.this.getActivity().overridePendingTransition(R.anim.f154740cc, R.anim.f154740cc);
                    GrapHbActivity.this.finish();
                }
            }
        };
        float c16 = com.tencent.mobileqq.util.x.c(getApplicationContext(), 116.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(400L);
        animatorSet.addListener(animatorListenerAdapter);
        animatorSet.playTogether(getAnimator(view2, true, c16), getAnimator(view3, false, 0.0f));
        animatorSet.start();
    }

    protected void addShowHbData() {
        String str;
        JSONObject jSONObject;
        JSONObject jSONObject2 = this.mSendObj;
        if (jSONObject2 == null) {
            return;
        }
        if (HBUtil.isHbForCommand(jSONObject2.optInt(WadlProxyConsts.CHANNEL))) {
            int i3 = this.mGrapHBState;
            if (i3 != 0 && i3 != 10 && (jSONObject = this.mRecvObj) != null) {
                Utils.isEmpty(jSONObject.optString("amount"));
            }
            this.mSendObj.optString("bus_type");
        }
        if (HBUtil.isKsonghb(this.mChannel)) {
            str = "ksong.result.show";
        } else if (HBUtil.isIdiomHb(this.mChannel)) {
            str = "idiom.popup.show";
        } else {
            str = "redpackets.opened.show";
        }
        com.tencent.mobileqq.qwallet.c.c(str, Integer.valueOf(getProcessType()));
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            onClosed(true);
            return true;
        }
        return super.doOnKeyDown(i3, keyEvent);
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment
    @NonNull
    public FragmentAnimation getFragmentAnimation() {
        return FragmentAnimation.NONE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tenpay.sdk.activity.TenpayUtilActivity
    public int getProcessType() {
        return this.mProcessFlag;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    protected void goToHbDetailActivity(boolean z16) {
        int i3 = this.mGrapHBState;
        if (-1 != i3 && 4 != i3) {
            Intent intent = new Intent();
            QwLog.e("ApiGrapH5CommonHbNetListener: mListid\uff1a " + this.mListId + " mGroupid: " + this.mGroupId + " mGrouptype: " + this.mGroupType + " isFromHBList: " + this.isFromHBList + " mName: " + this.mName + " mAnswer: " + this.mAnswer + " mAuthKey: " + this.mAuthKey + " mChannel: " + this.mChannel + " mSenderIconPath: " + this.mSenderIconPath + " mGrapHBState: " + this.mGrapHBState);
            intent.putExtra("listid", this.mListId);
            intent.putExtra(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID, this.mGroupId);
            intent.putExtra("grouptype", this.mGroupType);
            intent.putExtra("tinyId", this.mTinyId);
            intent.putExtra("guildId", this.mGuildId);
            intent.putExtra("subGuildId", this.mSubGuildId);
            intent.putExtra("isFromHBList", this.isFromHBList);
            intent.putExtra("name", this.mName);
            intent.putExtra("answer", this.mAnswer);
            intent.putExtra("authkey", this.mAuthKey);
            intent.putExtra(WadlProxyConsts.CHANNEL, String.valueOf(this.mChannel));
            intent.putExtra("sendIconPath", this.mSenderIconPath);
            intent.putExtra("skin_id", this.mHBSkinId);
            intent.putExtra("outer_skin_id", this.outerHBSkinId);
            intent.putExtra("skin_from", this.skinFrom);
            intent.putExtra(Cgi.GrabHB_StateKey, this.mGrapHBState);
            JSONObject jSONObject = this.mHbData;
            if (jSONObject != null) {
                intent.putExtra("hb_data", jSONObject.toString());
            }
            if (!TextUtils.isEmpty(this.mSenderShowName)) {
                intent.putExtra("sender_name", this.mSenderShowName);
            }
            if (!TextUtils.isEmpty(this.mSenderIconUrl)) {
                intent.putExtra("senderIconUrl", this.mSenderIconUrl);
            }
            intent.putExtra("from_graphb_dialog", z16);
            intent.putExtra("from_out", true);
            if (!z16) {
                intent.addFlags(65536);
            }
            setIntentData(intent);
            HbDetailModule.k(getActivity(), intent, !z16);
        }
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment
    public boolean isAllowLandscape() {
        return true;
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        if (i16 == -1) {
            if (i3 == HB_ShiMing_BIND_RESULT_CODE) {
                finish();
                QwLog.i("finished...");
            }
            QwLog.i("RESULT_OK");
            return;
        }
        QwLog.i("RESULT_CANCELED");
        finish();
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onBlError(String str, JSONObject jSONObject) {
        String optString = jSONObject.optString("retcode");
        QwLog.i("err_code = " + optString);
        if (TextUtils.equals(optString, Integer.toString(ERR_GRPB_HB_RETRY))) {
            if (this.mReTryCount <= NetBaseActivity.MAX_RETRY_COUNT) {
                setIsDismissLoading(false);
                int optInt = jSONObject.optInt("refuse_time");
                if (optInt <= 0) {
                    optInt = 500;
                }
                Handler handler = this.mHandler;
                if (handler != null) {
                    handler.postDelayed(new Runnable() { // from class: com.tenpay.sdk.activity.GrapHbActivity.5
                        @Override // java.lang.Runnable
                        public void run() {
                            GrapHbActivity.this.sendGrapHbRequest(false);
                            GrapHbActivity.this.mReTryCount++;
                        }
                    }, optInt);
                }
            } else {
                setIsDismissLoading(true);
            }
        }
        super.onBlError(str, jSONObject);
        if (this.mHandler == null) {
            return;
        }
        if (jSONObject.optInt("err_suggest_flag", 0) == 0) {
            stopGrabOpenIconAnimation();
            this.mGrabBtn.setClickable(true);
        } else {
            this.mGrabBtn.setVisibility(8);
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, cooperation.qwallet.plugin.FakeUrl.FakeListener
    public boolean onBlHandleFakeurl(FakeUrl.FakeInfo fakeInfo, int i3) {
        Uri uri;
        if (i3 == 0 && (uri = fakeInfo.leftUri) != null) {
            String queryParameter = uri.getQueryParameter("laterFill");
            if (!isFinishing() && QWalletFakeUrl.FAKEURL_COMFIRM_REQUEST.equals(fakeInfo.leftHost) && !TextUtils.isEmpty(queryParameter)) {
                QwLog.i("fake url onBlHandleFakeurl retry request");
                sendGrapHbRequest(Cgi.URI_HB_NA_GRAP, true, queryParameter);
                return true;
            }
        }
        return super.onBlHandleFakeurl(fakeInfo, i3);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (isValidClick(id5)) {
            if (id5 != R.id.az7 && id5 != R.id.f67443dc) {
                if (id5 == R.id.f165661x63) {
                    tenpayReport("redpackets.opened.details");
                    goToHbDetailActivity(true);
                }
            } else {
                onClosed(false);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mExitEnable = false;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fyd, viewGroup, false);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        HBUtil.cleanAdAnimator();
        super.onDestroy();
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onError(String str, JSONObject jSONObject) {
        super.onError(str, jSONObject);
        String str2 = "\u7f51\u7edc\u8bf7\u6c42\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5\u4e00\u8bd5";
        if (jSONObject != null) {
            str2 = jSONObject.optString("retmsg", "\u7f51\u7edc\u8bf7\u6c42\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5\u4e00\u8bd5");
        }
        QLog.e(((NetBaseActivity) this).TAG, 1, "request error " + str2);
        QQToast.makeText(getApplicationContext(), 1, str2, 0).show();
        finish();
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity
    public void onNetDlgokClick(String str, JSONObject jSONObject) {
        super.onNetDlgokClick(str, jSONObject);
        commonBlErrorPros(jSONObject, true);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        SharpImage.pauseByTag(26);
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        SharpImage.playByTag(26);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        stopGrabOpenIconAnimation();
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onSuccess(String str, JSONObject jSONObject) {
        super.onSuccess(str, jSONObject);
        if (isFinishing()) {
            return;
        }
        if (str.equals(Cgi.URI_HB_NA_GRAP) || str.equals(Cgi.URI_HB_NA_QZONE_GRAP) || str.equals(Cgi.URI_HB_NA_QR_GRAP)) {
            this.mGrabBtn.setClickable(true);
            processData(jSONObject);
        }
        if (str.equals(Cgi.URI_HB_NA_GRAP)) {
            sendHBStateBroadcast(IQWalletHelper.TROOP_HBLIST_GRAPHB_RESULT_CODE);
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        initView(view);
        initViewModel();
        Intent intent = getIntent();
        boolean initDataByIntent = initDataByIntent(intent);
        preloadHbSkinStory();
        boolean z16 = false;
        if (intent.getBooleanExtra("is_h5_common_native_show", false)) {
            QwLog.i("isFromH5Common: true");
            initH5HbGrab(intent.getStringExtra("hb_data"));
            return;
        }
        if (!initDataByIntent) {
            QwLog.i("initialize failed...");
            finish();
            return;
        }
        String stringExtra = intent.getStringExtra("detailinfo");
        if (stringExtra != null) {
            QwLog.e("detailinfo received is " + stringExtra);
            if (initQZoneHb(stringExtra)) {
                return;
            }
        }
        if (HBUtil.isFestivalHb(this.mChannel)) {
            sendGrapHbRequest(true);
            return;
        }
        String stringExtra2 = intent.getStringExtra("hb_pre_data");
        if (stringExtra2 != null) {
            try {
                JSONObject jSONObject = new JSONObject(stringExtra2);
                if (jSONObject.optInt("retcode") != 0) {
                    onBlError(Cgi.URI_HB_NA_PRE_GRAP, jSONObject);
                } else {
                    this.mPreGrabToken = jSONObject.optString("pre_grap_token");
                    processData(jSONObject);
                }
                z16 = true;
            } catch (JSONException e16) {
                QLog.e(((NetBaseActivity) this).TAG, 1, e16, new Object[0]);
            }
        }
        if (!z16) {
            sendGrapHbRequest(true);
        }
    }

    protected void sendGrapHbRequest(String str, boolean z16, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("listid", this.mListId);
        hashMap.put(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID, this.mGroupId);
        hashMap.put("grouptype", this.mGroupType);
        hashMap.put("groupuin", this.mGroupUin);
        hashMap.put("tinyid", this.mTinyId);
        hashMap.put("guild_id", this.mGuildId);
        hashMap.put("sub_guild_id", this.mSubGuildId);
        hashMap.put("pay_flag", this.mPayFlag);
        hashMap.put("name", this.mName);
        hashMap.put("answer", this.mAnswer);
        hashMap.put("subchannel", this.subChannel);
        hashMap.put("authkey", this.mAuthKey);
        hashMap.put("uin", this.mUin);
        hashMap.put("senderuin", getIntent().getStringExtra("senderuin"));
        hashMap.put(WadlProxyConsts.CHANNEL, String.valueOf(this.mChannel));
        if (str.equals(Cgi.URI_HB_NA_QR_GRAP) && !TextUtils.isEmpty(this.mQrCodeStr)) {
            hashMap.put("qr_data", this.mQrCodeStr);
        }
        Context context = getContext();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("qb_tenpay_hb_");
        sb5.append(this.mUin);
        hashMap.put("agreement", TenpayUtil.getShareBoolean(context, sb5.toString(), "agree_wallet_contrace") ? "1" : "0");
        hashMap.put("hb_from", this.hbFrom);
        if (HBUtil.isH5CommonHb(this.hbFrom)) {
            hashMap.put("grap_step", "0");
            hashMap.put("hb_from_type", "100");
        }
        if (HBUtil.isKuaKuaHb(this.mChannel)) {
            hashMap.put("matchToken", this.mMatchToken);
        }
        if (!TextUtils.isEmpty(this.mPreGrabToken)) {
            hashMap.put("pre_grap_token", this.mPreGrabToken);
        }
        hashMap.put("msg_id", getIntent().getStringExtra("msg_id"));
        hashMap.put("msg_seq", getIntent().getStringExtra("msg_seq"));
        hashMap.put("msg_md5", getIntent().getStringExtra("msg_md5"));
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("laterFill", str2);
        }
        httpRequest(str, hashMap, z16);
    }

    public void sendMyCallBack() {
        Bundle retCodeAndGetBundle = setRetCodeAndGetBundle(0);
        retCodeAndGetBundle.putString(Cgi.RETURN_MSG_KEY, "");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("need_realname_flag", this.isNeedToRealName);
            jSONObject.put(NotifyMsgApiImpl.KEY_GROUP_TYPE, this.mGroupType);
            jSONObject.put("state", this.mGrapHBState);
        } catch (JSONException e16) {
            QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
        }
        retCodeAndGetBundle.putString("retdata", jSONObject.toString());
    }

    public void showHbDetail() {
        String str;
        String string;
        String str2;
        String str3;
        boolean z16;
        if (HBUtil.isFestivalHb(this.mChannel)) {
            processFestivalHbGrab();
            return;
        }
        int i3 = this.mGrapHBState;
        if (5 != i3 && 10 != i3 && 1 != i3 && 6 != i3 && 7 != i3 && (i3 != 0 || !this.isShowH5HbDetail)) {
            if (i3 == 16) {
                z16 = true;
            } else {
                z16 = false;
            }
            popHbLayout(z16);
        }
        addShowHbData();
        JSONObject jSONObject = this.mSendObj;
        if (jSONObject != null) {
            String optString = jSONObject.optString("wishing");
            if (!TextUtils.isEmpty(optString)) {
                this.mWishWord.setText(optString);
            }
            if (((IQWalletHbApi) QRoute.api(IQWalletHbApi.class)).isGuildAIO(this.mGroupType)) {
                this.mHbSenderVm.updateAtGuild(this.mSendObj, this.mGuildId);
            } else {
                this.mHbSenderVm.update(this.mSendObj, this.mGroupId, getActivity());
            }
            if (HBUtil.isBirthdayHb(this.mChannel)) {
                String str4 = this.mSendObj.optString("send_name") + ":\n" + this.mSendObj.optString("wishing");
                this.mWishWord.setSingleLine(false);
                this.mWishWord.setText(str4);
                this.mWishWord.setTextColor(getResources().getColor(R.color.f158017al3));
                this.mWishWord.setTextSize(1, 23.0f);
            } else if (HBUtil.isHbForCommand(this.mChannel)) {
                this.mLingInfoLayout.setVisibility(0);
                this.mLingTitle.setText(optString);
                this.mWishWord.setText("");
                this.mSenderLayout.setVisibility(8);
            } else if (HBUtil.isIdiomHb(this.mChannel)) {
                this.mWishWord.setText("");
                this.mIdiomMoneyLayout.setVisibility(0);
            }
        }
        int i16 = this.mGrapHBState;
        switch (i16) {
            case 0:
                JSONObject jSONObject2 = this.mRecvObj;
                if (jSONObject2 != null) {
                    str = jSONObject2.optString("amount");
                } else {
                    str = null;
                }
                if (!TextUtils.isEmpty(str)) {
                    String fen2Yuan = Utils.fen2Yuan(str);
                    QwLog.e("amount is: " + fen2Yuan);
                    this.mHBCount.setText(fen2Yuan);
                    this.mIdiomMoneyText.setText(fen2Yuan);
                    tenpayReport("redpackets.opened.success");
                    if (!HBUtil.isIdiomHb(this.mChannel)) {
                        this.mHbMoneyLayout.setVisibility(0);
                    }
                }
                if (!HBUtil.isHbForCommand(this.mChannel) && !HBUtil.isIdiomHb(this.mChannel) && !HBUtil.isShengpiziHb(this.mChannel)) {
                    toHbDetailWithAnimation(this.hbRootLayout, this.grabLayerContainer, this.mHbTopBg, this.mHbBottomBg);
                    return;
                }
                return;
            case 1:
            case 6:
            case 10:
                goToHbDetailActivity(false);
                return;
            case 2:
            case 3:
                if (i16 == 2) {
                    string = "\u6765\u665a\u4e00\u6b65\uff0c\u9886\u5b8c\u5566~";
                } else {
                    string = getString(R.string.e8r);
                }
                showHbInvalidUI(string);
                if (!HBUtil.isHbForFaceToFace(this.mChannel)) {
                    this.mHbDetailBtn.setVisibility(0);
                    return;
                }
                return;
            case 4:
            case 8:
            case 11:
            case 15:
            default:
                showHbInvalidUI(getString(R.string.e8r));
                this.mSenderLayout.setVisibility(8);
                return;
            case 5:
                doExceedLimit();
                return;
            case 7:
                showAgreementDialog();
                return;
            case 9:
                showHbInvalidUI(getString(R.string.e8r));
                if (!HBUtil.isHbForFaceToFace(this.mChannel)) {
                    this.mHbDetailBtn.setVisibility(0);
                }
                this.mSenderLayout.setVisibility(8);
                return;
            case 12:
                if (TextUtils.equals("3", this.subChannel)) {
                    str2 = "\u63a5\u9f99\u8bd7\u8bcd\u5df2\u66f4\u65b0~";
                } else {
                    str2 = "\u63a5\u9f99\u8bcd\u8bed\u5df2\u66f4\u65b0~";
                }
                showHbInvalidUI(str2);
                return;
            case 13:
                if (TextUtils.equals("2", this.subChannel)) {
                    str3 = "\u8be5\u8bd7\u8bcd\u5df2\u88ab\u7528\u8fc7\u5566\uff0c\u6362\u4e00\u53e5\u8bd7\u8bcd\u5427";
                } else {
                    str3 = "\u8be5\u5355\u8bcd\u5df2\u88ab\u7528\u8fc7\u5566\uff0c\u6362\u4e00\u4e2a\u5355\u8bcd\u5427";
                }
                showHbInvalidUI(str3);
                return;
            case 14:
                showHbInvalidUI("\u8be5\u9996\u8bd7\u8bcd\u5df2\u63a5\u9f99\u7ed3\u675f");
                return;
            case 16:
                showPreGrabView(this.mWishWord.getText().toString());
                return;
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }

    protected void sendGrapHbRequest(boolean z16) {
        if ("101".equals(this.mGroupType)) {
            sendGrapHbRequest(Cgi.URI_HB_NA_QZONE_GRAP, z16, null);
        } else if (HBUtil.isHbForFaceToFace(this.mChannel)) {
            sendGrapHbRequest(Cgi.URI_HB_NA_QR_GRAP, z16, null);
        } else {
            sendGrapHbRequest(Cgi.URI_HB_NA_GRAP, z16, null);
        }
        animateGrabOpenIcon();
    }
}
