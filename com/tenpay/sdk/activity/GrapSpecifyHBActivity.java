package com.tenpay.sdk.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.qwallet.utils.QWalletUtils;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.image.ApngDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.base.FragmentAnimation;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletApi;
import com.tencent.mobileqq.qwallet.api.IQWalletNickNameApi;
import com.tencent.mobileqq.qwallet.hb.IQWalletHbApi;
import com.tencent.mobileqq.qwallet.hb.detail.HbDetailModule;
import com.tencent.mobileqq.qwallet.transaction.impl.NotifyMsgApiImpl;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkpublish.api.constant.FSPublishConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tenpay.ErrorCode;
import com.tenpay.QwLog;
import com.tenpay.anim.GrabHbViewAnimator;
import com.tenpay.proxy.QUIProxy;
import com.tenpay.realname.RealNameSource;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.grab.HbSenderViewModel;
import com.tenpay.sdk.helper.HBShiMingHelper;
import com.tenpay.sdk.util.HBUtil;
import com.tenpay.sdk.util.HongBaoStateHelper;
import com.tenpay.sdk.util.OnGetResult;
import com.tenpay.sdk.util.OnGetResultOnMainThread;
import com.tenpay.sdk.util.QQFaceFileUtil;
import com.tenpay.sdk.util.TenpayUtil;
import com.tenpay.util.Utils;
import cooperation.qwallet.plugin.IQWalletHelper;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class GrapSpecifyHBActivity extends NetBaseActivity implements View.OnClickListener {
    public static int HB_ICON_SIZE = 240;
    public static int HB_ShiMing_BIND_RESULT_CODE = 5001;
    private static final int STATE_EXPIRED = 1;
    private static final int STATE_INVALID = 3;
    private static final int STATE_NONRECEIPTOR = 2;
    private static final int STATE_NORMAL = 0;
    private static final int STATE_OVERTIME = 4;
    private static final int STATE_PRE_GRAB = 5;
    private ViewGroup animContainer;
    private boolean isFromHBList;
    protected String isNeedToRealName;
    private ImageView mBottomBg;
    private String mChannel;
    private ImageView mCloseBtn;
    private ImageView mGrabBtn;
    private ImageView mGrabIcon;
    private ObjectAnimator mGrabOpenAnimator;
    private String mGroupType;
    private String mGroupid;
    private String mGrouptype;
    private String mGroupuin;
    private String mGuildId;
    protected JSONObject mHBdata;
    private TextView mHbInfoBtn;
    private RelativeLayout mHbLayout;
    private HbSenderViewModel mHbSenderVm;
    private LinearLayout mIconlayout;
    private String mPreGrabToken;
    private RelativeLayout mRootLayout;
    private ImageView mSenderIcon;
    private LinearLayout mSenderLayout;
    private TextView mSenderText;
    private String mSubGuildId;
    private TextView mSubTitle;
    private String mTinyId;
    private TextView mTitle;
    private ImageView mTopBg;
    private ApngDrawable.OnPlayRepeatListener playRepeatListener;
    private long mLastCalledTime = 0;
    protected int mGrapHBState = -1;
    protected String mListid = "";
    protected String mName = "";
    protected String mAnswer = "";
    protected String mAuthKey = "";
    protected JSONObject mSendObj = null;
    protected JSONObject mRecvObj = null;
    protected JSONObject mSelfObj = null;
    protected JSONObject mTreeObj = null;
    protected JSONArray mRecvArray = null;
    private long mGotoDetailTime = 0;
    private String[] mGrabUins = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class LoadQQIconTask extends AsyncTask<String, Void, Void> implements OnGetResult {
        private Bitmap mBitmap = null;
        private ImageView mImageView;

        public LoadQQIconTask(ImageView imageView) {
            this.mImageView = imageView;
        }

        @Override // com.tenpay.sdk.util.OnGetResult
        public void getResult(Object obj) {
            AsyncTask.Status status = getStatus();
            if (status != AsyncTask.Status.FINISHED && status != AsyncTask.Status.RUNNING && obj != null) {
                String str = (String) obj;
                QwLog.i("path=" + str);
                execute(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Void doInBackground(String... strArr) {
            String str = strArr[0];
            if (Utils.isStringNull(str)) {
                return null;
            }
            this.mBitmap = QQFaceFileUtil.getImageByPath(str, GrapSpecifyHBActivity.HB_ICON_SIZE);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Void r26) {
            ImageView imageView;
            Bitmap bitmap = this.mBitmap;
            if (bitmap == null || (imageView = this.mImageView) == null) {
                return;
            }
            imageView.setImageBitmap(bitmap);
        }
    }

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

    private Animator getAnimator(View view, boolean z16, float f16) {
        float f17;
        float screenWidth = Utils.getScreenWidth(getContext());
        float screenHeight = Utils.getScreenHeight(getContext());
        float width = screenWidth / view.getWidth();
        view.getLocationOnScreen(new int[2]);
        if (z16) {
            f17 = -((r3[1] + view.getHeight()) - f16);
        } else {
            f17 = (screenHeight - r3[1]) - f16;
        }
        return ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat(com.tencent.luggage.wxa.c8.c.f123400v, view.getAlpha(), view.getAlpha(), 0.0f), PropertyValuesHolder.ofFloat(BasicAnimation.KeyPath.SCALE_X, view.getScaleX(), width), PropertyValuesHolder.ofFloat(BasicAnimation.KeyPath.SCALE_Y, view.getScaleY(), width), PropertyValuesHolder.ofFloat("translationY", f17));
    }

    private ImageView getGrabIcon(String str, boolean z16) {
        final ImageView imageView = new ImageView(getContext());
        if (z16) {
            imageView.setPadding(0, ViewUtils.dip2px(9.0f), 0, 0);
            imageView.setBackgroundResource(R.drawable.dwt);
        } else {
            int dip2px = ViewUtils.dip2px(3.0f);
            imageView.setPadding(dip2px, dip2px, dip2px, dip2px);
            imageView.setBackgroundResource(R.drawable.n8z);
        }
        if (((IQWalletHbApi) QRoute.api(IQWalletHbApi.class)).isGuildAIO(this.mGroupType)) {
            HBUtil.getGuildUsersAvatarUrl(str, this.mGuildId, new OnGetResultOnMainThread() { // from class: com.tenpay.sdk.activity.GrapSpecifyHBActivity.5
                @Override // com.tenpay.sdk.util.OnGetResultOnMainThread
                public void getResultOnMainThread(Object obj) {
                    try {
                        imageView.setImageDrawable(HBUtil.getAvatarDrawable((String) obj));
                    } catch (Exception e16) {
                        QLog.e(((NetBaseActivity) GrapSpecifyHBActivity.this).TAG, 1, e16, new Object[0]);
                    }
                }
            });
        } else {
            new QQFaceFileUtil(new LoadQQIconTask(imageView)).getQQFaceImage(str, getActivity());
        }
        return imageView;
    }

    private void handleData(int i3) {
        RealNameSource realNameSource;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 3) {
                    if (i3 != 16) {
                        switch (i3) {
                            case 5:
                                String optString = this.mHBdata.optString("returl");
                                String optString2 = this.mHBdata.optString("retmsg");
                                if (((IQWalletHbApi) QRoute.api(IQWalletHbApi.class)).isGuildAIO(this.mGroupType)) {
                                    realNameSource = new RealNameSource("14");
                                } else {
                                    realNameSource = new RealNameSource("13");
                                }
                                HBShiMingHelper.doAction(this, HB_ShiMing_BIND_RESULT_CODE, this.mUin, optString, optString2, realNameSource);
                                break;
                            case 6:
                            case 10:
                                break;
                            case 7:
                                showProtocol();
                                break;
                            case 8:
                                JSONObject jSONObject = this.mSendObj;
                                if (jSONObject != null) {
                                    try {
                                        this.mGrabUins = jSONObject.optString("grab_uin_list").split("\\|", 5);
                                    } catch (Exception e16) {
                                        QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
                                    }
                                }
                                String[] strArr = this.mGrabUins;
                                if (strArr != null && strArr.length > 0) {
                                    setState(2, null);
                                    break;
                                } else {
                                    setState(3, null);
                                    break;
                                }
                            case 9:
                                setState(4, null);
                                break;
                            default:
                                setState(3, null);
                                break;
                        }
                    } else {
                        setState(5, null);
                    }
                } else {
                    setState(1, null);
                }
            }
            goToHbDetailActivity(false);
        } else {
            setState(0, null);
        }
        processCashGame();
    }

    private void initHbSenderViewModel() {
        HbSenderViewModel hbSenderViewModel = (HbSenderViewModel) new ViewModelProvider(this).get(HbSenderViewModel.class);
        hbSenderViewModel.getSendIconLiveData().observe(getViewLifecycleOwner(), new Observer<Bitmap>() { // from class: com.tenpay.sdk.activity.GrapSpecifyHBActivity.1
            @Override // androidx.lifecycle.Observer
            public void onChanged(Bitmap bitmap) {
                if (bitmap != null) {
                    GrapSpecifyHBActivity.this.mSenderIcon.setImageBitmap(bitmap);
                }
            }
        });
        hbSenderViewModel.getSendIconDrawableLiveData().observe(getViewLifecycleOwner(), new Observer<Drawable>() { // from class: com.tenpay.sdk.activity.GrapSpecifyHBActivity.2
            @Override // androidx.lifecycle.Observer
            public void onChanged(Drawable drawable) {
                if (drawable != null) {
                    GrapSpecifyHBActivity.this.mSenderIcon.setImageDrawable(drawable);
                }
            }
        });
        hbSenderViewModel.getSendTextLiveData().observe(getViewLifecycleOwner(), new Observer<String>() { // from class: com.tenpay.sdk.activity.GrapSpecifyHBActivity.3
            @Override // androidx.lifecycle.Observer
            public void onChanged(String str) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                GrapSpecifyHBActivity.this.mSenderText.setText(GrapSpecifyHBActivity.this.getString(R.string.f171301dw3) + str);
            }
        });
        hbSenderViewModel.getRecieverIconDrawableLiveData().observe(getViewLifecycleOwner(), new Observer<Drawable>() { // from class: com.tenpay.sdk.activity.GrapSpecifyHBActivity.4
            @Override // androidx.lifecycle.Observer
            public void onChanged(Drawable drawable) {
                if (drawable != null) {
                    GrapSpecifyHBActivity.this.mGrabIcon.setImageDrawable(drawable);
                }
            }
        });
        this.mHbSenderVm = hbSenderViewModel;
    }

    private void initIntentData() {
        Intent intent = getIntent();
        this.mListid = intent.getStringExtra("listid");
        this.mGroupid = intent.getStringExtra(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID);
        this.mGrouptype = intent.getStringExtra("grouptype");
        this.mGroupuin = intent.getStringExtra("groupuin");
        this.mTinyId = intent.getStringExtra("tinyId");
        this.mGuildId = intent.getStringExtra("guildId");
        this.mSubGuildId = intent.getStringExtra("subGuildId");
        this.mName = intent.getStringExtra("name");
        this.mAnswer = intent.getStringExtra("answer");
        this.mAuthKey = intent.getStringExtra("authkey");
        this.isFromHBList = "1".equals(intent.getStringExtra("fromHBList"));
        this.mChannel = intent.getStringExtra(WadlProxyConsts.CHANNEL);
        this.mGroupType = intent.getStringExtra("grouptype");
    }

    private void initView(View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.az7);
        this.mCloseBtn = imageView;
        imageView.setOnClickListener(this);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.root_layout);
        this.mRootLayout = relativeLayout;
        relativeLayout.setOnClickListener(this);
        this.mSenderText = (TextView) view.findViewById(R.id.f67473df);
        this.mSenderIcon = (ImageView) view.findViewById(R.id.f67453dd);
        this.mGrabBtn = (ImageView) view.findViewById(R.id.f67373d6);
        this.mSenderLayout = (LinearLayout) view.findViewById(R.id.f67463de);
        this.mSubTitle = (TextView) view.findViewById(R.id.f67483dg);
        this.mGrabIcon = (ImageView) view.findViewById(R.id.de5);
        this.mTopBg = (ImageView) view.findViewById(R.id.f67503di);
        this.mBottomBg = (ImageView) view.findViewById(R.id.f67343d3);
        this.mTitle = (TextView) view.findViewById(R.id.f67493dh);
        TextView textView = (TextView) view.findViewById(R.id.d1f);
        this.mHbInfoBtn = textView;
        textView.setOnClickListener(this);
        this.mIconlayout = (LinearLayout) view.findViewById(R.id.inu);
        RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.f165657d13);
        this.mHbLayout = relativeLayout2;
        relativeLayout2.setOnClickListener(this);
        QWalletUtils.v(this.mHbLayout, 9.5f);
        this.animContainer = (ViewGroup) view.findViewById(R.id.gg6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showGrabUI$0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.mGrabBtn.setClickable(false);
        sendGrapHbRequest(true);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateSubTitle$1(String str) {
        if (isFinishing()) {
            return;
        }
        this.mSubTitle.setText(getString(R.string.f21787627, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$updateSubTitle$2(final String str) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tenpay.sdk.activity.bc
            @Override // java.lang.Runnable
            public final void run() {
                GrapSpecifyHBActivity.this.lambda$updateSubTitle$1(str);
            }
        });
        return null;
    }

    private void popHbLayout() {
        if (this.mRootLayout.getVisibility() != 0) {
            this.mRootLayout.setVisibility(0);
            new GrabHbViewAnimator(this.mHbLayout, this.mCloseBtn).start();
        }
    }

    private void processCashGame() {
        HBUtil.processCashGame(getContext(), this.animContainer, this.animContainer.findViewById(R.id.f164327rz), (ImageView) this.animContainer.findViewById(R.id.d0y), (TextView) this.animContainer.findViewById(R.id.f107766ba), this.mTreeObj);
    }

    private void processData(JSONObject jSONObject) {
        HongBaoStateHelper.extractFromHbData(jSONObject);
        this.mHBdata = jSONObject;
        QwLog.e(jSONObject.toString());
        this.mGrapHBState = jSONObject.optInt("state", -1);
        this.isNeedToRealName = jSONObject.optString("need_realname_flag");
        int i3 = this.mGrapHBState;
        if (i3 != 4 && i3 >= 0 && i3 <= 16) {
            this.mSendObj = jSONObject.optJSONObject("send_object");
            this.mRecvObj = jSONObject.optJSONObject("recv_object");
            this.mSelfObj = jSONObject.optJSONObject("self_object");
            this.mTreeObj = jSONObject.optJSONObject("mtree_object");
            this.mRecvArray = jSONObject.optJSONArray("recv_array");
            JSONObject jSONObject2 = this.mSendObj;
            if (jSONObject2 != null) {
                if (8 != this.mGrapHBState) {
                    this.mTitle.setText(jSONObject2.optString("wishing"));
                }
                if (((IQWalletHbApi) QRoute.api(IQWalletHbApi.class)).isGuildAIO(this.mGroupType)) {
                    this.mHbSenderVm.updateAtGuild(this.mSendObj, this.mGuildId);
                } else {
                    this.mHbSenderVm.update(this.mSendObj, this.mGroupid, getActivity());
                }
            }
            handleData(this.mGrapHBState);
            return;
        }
        setState(3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveAgreementFlag(boolean z16) {
        SharedPreferences.Editor edit = getSharedPreferences("qb_tenpay_hb_" + this.mUin, 0).edit();
        edit.putBoolean("agree_wallet_contrace", z16);
        edit.commit();
    }

    private void sendHBStateBroadcast(int i3) {
        int i16 = this.mGrapHBState;
        if (i16 != 5 && i16 != 7) {
            QwLog.i("sendHBStateBroadcast mListid : " + this.mListid);
            QwLog.i("sendHBStateBroadcast isFromHBList : " + this.isFromHBList);
            if (this.isFromHBList) {
                Intent intent = new Intent(IQWalletHelper.TROOP_HBLIST_BROADCAST_ACTION);
                intent.putExtra("grap_hb_state", this.mGrapHBState);
                intent.putExtra("listid", this.mListid);
                intent.putExtra("result_code", i3);
                sendBroadcast(intent);
            }
        }
    }

    private void setState(int i3, String str) {
        popHbLayout();
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 == 5) {
                                showGrabUI();
                                return;
                            }
                            return;
                        } else {
                            showOtherUI(getString(R.string.e8r));
                            this.mHbInfoBtn.setVisibility(8);
                            this.mSenderLayout.setVisibility(8);
                            return;
                        }
                    }
                    showOtherUI(str);
                    return;
                }
                showNotGrabUI();
                return;
            }
            showOtherUI(getString(R.string.e8r));
            return;
        }
        this.mCloseBtn.setVisibility(4);
        toHbDetailWithAnimation(this.mRootLayout, this.mHbLayout, this.mTopBg, this.mBottomBg);
    }

    private void showGrabUI() {
        this.mSubTitle.setText("\u4e13\u5c5e\u4e8e\u4f60\u7684\u7ea2\u5305");
        this.mHbInfoBtn.setVisibility(8);
        if (((IQWalletHbApi) QRoute.api(IQWalletHbApi.class)).isGuildAIO(this.mGroupType)) {
            this.mHbSenderVm.updateReceiverIconAtGuild(this.mTinyId, this.mGuildId);
        } else if (!TextUtils.isEmpty(this.mUin)) {
            new QQFaceFileUtil(new LoadQQIconTask(this.mGrabIcon)).getQQFaceImage(this.mUin, getActivity());
        }
        this.mIconlayout.setVisibility(8);
        this.mGrabBtn.setVisibility(0);
        this.mGrabBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.activity.bb
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GrapSpecifyHBActivity.this.lambda$showGrabUI$0(view);
            }
        });
        ((IQWalletHbApi) QRoute.api(IQWalletHbApi.class)).updateOpenIcon(this.mGrabBtn, null);
        this.mBottomBg.setImageResource(R.drawable.nvd);
    }

    private void showNotGrabUI() {
        int i3;
        int i16;
        int i17;
        JSONObject jSONObject;
        this.mTitle.setText(R.string.e8u);
        String[] strArr = this.mGrabUins;
        if (strArr != null && strArr.length != 0) {
            int length = strArr.length;
            boolean z16 = true;
            if (length != 1) {
                z16 = false;
            }
            if (z16 && (jSONObject = this.mSendObj) != null) {
                this.mTitle.setText(jSONObject.optString("wishing"));
            }
            updateSubTitle();
            if (length <= 3) {
                i16 = ViewUtils.dpToPx(10.0f);
                i3 = i16;
            } else {
                i3 = -ViewUtils.dip2px(5.0f);
                i16 = 0;
            }
            for (String str : this.mGrabUins) {
                View grabIcon = getGrabIcon(str, z16);
                if (z16) {
                    i17 = 64;
                } else {
                    i17 = 55;
                }
                float f16 = i17;
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewUtils.dpToPx(f16), ViewUtils.dpToPx(f16));
                layoutParams.setMargins(i3, 0, i16, 0);
                grabIcon.setLayoutParams(layoutParams);
                this.mIconlayout.addView(grabIcon);
            }
            this.mGrabIcon.setVisibility(8);
            this.mGrabBtn.setVisibility(8);
            this.mBottomBg.setImageResource(R.drawable.nve);
            return;
        }
        this.mSubTitle.setText("\u4e13\u5c5e\u4e8e\u522b\u4eba\u7684\u7ea2\u5305");
        this.mIconlayout.setVisibility(8);
    }

    private void showOtherUI(String str) {
        this.mTitle.setText(str);
        this.mIconlayout.setVisibility(8);
        this.mSubTitle.setVisibility(8);
        this.mGrabIcon.setVisibility(8);
        this.mGrabBtn.setVisibility(8);
        this.mBottomBg.setImageResource(R.drawable.nve);
    }

    private void showProtocol() {
        SpannableString spannableString = new SpannableString(getString(R.string.e4t) + getString(R.string.e4u));
        spannableString.setSpan(new ClickableSpan() { // from class: com.tenpay.sdk.activity.GrapSpecifyHBActivity.7
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                GrapSpecifyHBActivity.this.gotoH5(Cgi.URI_QWALLET_CONTRACT);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setUnderlineText(false);
            }
        }, 14, spannableString.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.login_error_url)), 14, spannableString.length(), 33);
        QUIProxy.createCustomDialogUrlWithoutAutoLink(getContext(), 230, null, spannableString, R.string.e5h, R.string.e4s, new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.GrapSpecifyHBActivity.8
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                GrapSpecifyHBActivity.this.saveAgreementFlag(true);
                GrapSpecifyHBActivity.this.sendGrapHbRequest(true);
                dialogInterface.dismiss();
                GrapSpecifyHBActivity.this.tenpayReport("redpackets.identify.agree");
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.GrapSpecifyHBActivity.9
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                dialogInterface.dismiss();
                GrapSpecifyHBActivity.this.tenpayReport("redpackets.identify.close");
                GrapSpecifyHBActivity.this.finish();
            }
        });
        tenpayReport("redpackets.identify.show");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tenpayReport(@NonNull String str) {
        com.tencent.mobileqq.qwallet.c.c(str, Integer.valueOf(getProcessType()));
    }

    private void toHbDetailWithAnimation(ViewGroup viewGroup, View view, View view2, View view3) {
        viewGroup.getOverlay().add(view2);
        viewGroup.getOverlay().add(view3);
        view.setVisibility(4);
        AnimatorListenerAdapter animatorListenerAdapter = new AnimatorListenerAdapter() { // from class: com.tenpay.sdk.activity.GrapSpecifyHBActivity.6
            private boolean isStarted = false;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!this.isStarted) {
                    this.isStarted = true;
                    GrapSpecifyHBActivity.this.goToHbDetailActivity(false);
                }
                if (!GrapSpecifyHBActivity.this.isFinishing()) {
                    GrapSpecifyHBActivity.this.getActivity().overridePendingTransition(R.anim.f154740cc, R.anim.f154740cc);
                    GrapSpecifyHBActivity.this.finish();
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

    private void updateSubTitle() {
        String str = this.mGrabUins[0];
        if (((IQWalletHbApi) QRoute.api(IQWalletHbApi.class)).isGuildAIO(this.mGroupType)) {
            this.mSubTitle.setText(getString(R.string.f21787627, ((IQWalletApi) QRoute.api(IQWalletApi.class)).getGuildNickName(getAppRuntime(), this.mGuildId, str)));
        } else {
            ((IQWalletNickNameApi) QRoute.api(IQWalletNickNameApi.class)).getNickName(this.mGroupid, str, new Function1() { // from class: com.tenpay.sdk.activity.bd
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit lambda$updateSubTitle$2;
                    lambda$updateSubTitle$2 = GrapSpecifyHBActivity.this.lambda$updateSubTitle$2((String) obj);
                    return lambda$updateSubTitle$2;
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        ImageView imageView;
        if (i3 == 4 && (imageView = this.mCloseBtn) != null) {
            imageView.performClick();
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
        return 212;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    protected void goToHbDetailActivity(boolean z16) {
        int i3 = this.mGrapHBState;
        if (-1 != i3 && 4 != i3) {
            Intent intent = new Intent();
            intent.putExtra("listid", this.mListid);
            intent.putExtra("isFromHBList", this.isFromHBList);
            intent.putExtra(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID, this.mGroupid);
            intent.putExtra("grouptype", this.mGrouptype);
            intent.putExtra("tinyId", this.mTinyId);
            intent.putExtra("guildId", this.mGuildId);
            intent.putExtra("subGuildId", this.mSubGuildId);
            intent.putExtra("name", this.mName);
            intent.putExtra("answer", this.mAnswer);
            intent.putExtra("authkey", this.mAuthKey);
            intent.putExtra(WadlProxyConsts.CHANNEL, this.mChannel);
            intent.putExtra(Cgi.GrabHB_StateKey, this.mGrapHBState);
            JSONObject jSONObject = this.mHBdata;
            if (jSONObject != null) {
                intent.putExtra("hb_data", jSONObject.toString());
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
            QwLog.i("onActivityResult Activity.RESULT_OK");
            return;
        }
        QwLog.i("onActivityResult Activity.RESULT_CANCELED");
        finish();
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onBlError(String str, JSONObject jSONObject) {
        String optString = jSONObject.optString("retcode");
        QwLog.i("err_code = " + optString);
        if (TextUtils.equals(optString, Integer.toString(GrapHbActivity.ERR_GRPB_HB_RETRY))) {
            if (this.mReTryCount <= NetBaseActivity.MAX_RETRY_COUNT) {
                setIsDismissLoading(false);
                int optInt = jSONObject.optInt("refuse_time");
                if (optInt <= 0) {
                    optInt = 500;
                }
                Handler handler = this.mHandler;
                if (handler != null) {
                    handler.postDelayed(new Runnable() { // from class: com.tenpay.sdk.activity.GrapSpecifyHBActivity.10
                        @Override // java.lang.Runnable
                        public void run() {
                            GrapSpecifyHBActivity.this.sendGrapHbRequest(false);
                            GrapSpecifyHBActivity.this.mReTryCount++;
                        }
                    }, optInt);
                }
            } else {
                setIsDismissLoading(true);
            }
        }
        super.onBlError(str, jSONObject);
        if (this.mHandler != null && ErrorCode.ERR_SERVER_LIMITED.equals(optString)) {
            this.mGrabBtn.setClickable(true);
            setState(3, jSONObject.optString("retmsg"));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        SystemClock.uptimeMillis();
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mLastCalledTime + 1500 <= currentTimeMillis) {
            this.mLastCalledTime = currentTimeMillis;
            if (view.getId() != R.id.az7 && view != this.mRootLayout) {
                if (view == this.mHbInfoBtn) {
                    tenpayReport("redpackets.opened.details");
                    goToHbDetailActivity(true);
                }
            } else {
                tenpayReport("only.popup.back");
                sendHBStateBroadcast(IQWalletHelper.TROOP_HBLIST_CLOSE_RESULT_CODE);
                sendMyCallBack();
                HBUtil.notifyGrapedHbClose(getContext(), this.mGrapHBState, this.mRecvObj, this.mSendObj, getIntent());
                finish();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        boolean z16 = false;
        this.mExitEnable = false;
        View inflate = layoutInflater.inflate(R.layout.f168579ae2, viewGroup, false);
        initView(inflate);
        initIntentData();
        initHbSenderViewModel();
        String stringExtra = getIntent().getStringExtra("hb_pre_data");
        if (stringExtra != null) {
            try {
                JSONObject jSONObject = new JSONObject(stringExtra);
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
        tenpayReport("only.popup.show");
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        HBUtil.cleanAdAnimator();
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
    public void onStop() {
        super.onStop();
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

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onSuccess(String str, JSONObject jSONObject) {
        super.onSuccess(str, jSONObject);
        if (!isFinishing() && str.equals(Cgi.URI_HB_NA_GRAP)) {
            this.mGrabBtn.setClickable(true);
            processData(jSONObject);
            sendHBStateBroadcast(IQWalletHelper.TROOP_HBLIST_GRAPHB_RESULT_CODE);
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    protected void sendGrapHbRequest(boolean z16) {
        String str;
        String str2 = Cgi.URI_HB_NA_GRAP;
        HashMap hashMap = new HashMap();
        hashMap.put("listid", this.mListid);
        hashMap.put(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID, this.mGroupid);
        hashMap.put("grouptype", this.mGrouptype);
        hashMap.put("groupuin", this.mGroupuin);
        hashMap.put("tinyid", this.mTinyId);
        hashMap.put("guild_id", this.mGuildId);
        hashMap.put("sub_guild_id", this.mSubGuildId);
        hashMap.put("name", this.mName);
        hashMap.put("answer", this.mAnswer);
        hashMap.put("authkey", this.mAuthKey);
        hashMap.put("uin", this.mUin);
        hashMap.put(WadlProxyConsts.CHANNEL, this.mChannel);
        JSONObject jSONObject = this.mSendObj;
        if (jSONObject != null) {
            hashMap.put("senderuin", jSONObject.optString("send_uin"));
        } else {
            QLog.w(((NetBaseActivity) this).TAG, 1, "mSendObj is null");
        }
        if (TenpayUtil.getShareBoolean(getContext(), "qb_tenpay_hb_" + this.mUin, "agree_wallet_contrace")) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("agreement", str);
        if (!TextUtils.isEmpty(this.mPreGrabToken)) {
            hashMap.put("pre_grap_token", this.mPreGrabToken);
        }
        httpRequest(str2, hashMap, z16);
        animateGrabOpenIcon();
    }

    public void sendMyCallBack() {
        Bundle retCodeAndGetBundle = setRetCodeAndGetBundle(0);
        retCodeAndGetBundle.putString(Cgi.RETURN_MSG_KEY, "");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("need_realname_flag", this.isNeedToRealName);
            jSONObject.put(NotifyMsgApiImpl.KEY_GROUP_TYPE, this.mGrouptype);
            jSONObject.put("state", this.mGrapHBState);
        } catch (JSONException e16) {
            QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
        }
        retCodeAndGetBundle.putString("retdata", jSONObject.toString());
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }
}
