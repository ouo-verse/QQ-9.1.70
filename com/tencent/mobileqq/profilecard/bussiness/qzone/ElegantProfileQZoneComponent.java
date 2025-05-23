package com.tencent.mobileqq.profilecard.bussiness.qzone;

import SummaryCard.PhotoInfo;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.mini.utils.SchemaUtils;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.profilecard.base.component.IProfileContentKey;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qzone.picload.c;
import com.tencent.mobileqq.qzonestatus.d;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.tianshu.api.ITianshuManager;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.vas.profilecard.util.LevelUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.RoundRelativeLayout;
import com.tencent.mobileqq.widget.UnderlineTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qzonehub.api.IQZoneApiProxy;
import com.tencent.qzonehub.api.IQZoneRouteApi;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.util.k;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.report.lp.QZoneLoginReportHelper;
import f11.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.slf4j.Marker;

/* loaded from: classes16.dex */
public class ElegantProfileQZoneComponent extends BaseProfileQZoneComponent implements SimpleEventReceiver {
    static IPatchRedirector $redirector_ = null;
    private static final int BIG_PIC_NUMBER = 4;
    private static final String COLOR_FILTER = "#77F5F6FA";
    private static final String DEFAULT_GUEST_GENDER = "\u4ed6";
    private static final String KEY_FEEDS_CONTENT = "feeds_content";
    private static final String KEY_INFO_TYPE = "info_type";
    private static final String KEY_NEW_TIPS_ACTION = "head_jump_url";
    private static final String KEY_NEW_TIPS_TEXT = "head_text";
    private static final String KEY_NEW_TIPS_TIANSHU_ADID = "head_tianshu_itemid";
    private static final String KEY_NEW_TIPS_TIANSHU_TRACEINFO = "head_tianshu_traceinfo";
    private static final String KEY_TAG_ID = "taguin";
    private static final String KEY_URGE_UPDATE = "urge_update";
    private static final float LEFT_MARGIN = 16.0f;
    private static final float PHOTO_MARGIN = 2.0f;
    private static final int PIC_COLOR_FILTER = 1996488704;
    private static final int PIC_NO_COLOR_FILTER = 0;
    private static final int QZONE_PERMISSION = 128;
    private static final String QZONE_PUBLISH_ID = "publish_id";
    private static final float ROUND_RADIUS = 1.0f;
    private static final String SCHEME_QZONE_WRITE_MOOD = "mqzone://arouse/writemood";
    private static final int SMALL_PIC_NUMBER = 5;
    private static final String TAG = "ElegantProfileQZoneComponent";
    private boolean mIsClickUrge;
    private final View.OnClickListener mNewTipsLinkClickListener;
    private String mNewTipsLinkJumpUrl;
    private String mNewTipsLinkTagId;
    private String mNewTipsLinkText;
    private String mNewTipsLinkTianshuAdId;
    private String mNewTipsLinkTianshuTraceInfo;
    private final View.OnClickListener mUrgeUpdateClickListener;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public static class LinkTextDynamicParams implements IDynamicParams {
        static IPatchRedirector $redirector_;

        LinkTextDynamicParams() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Map) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
            HashMap hashMap = new HashMap();
            if (str.equals("clck")) {
                hashMap.put("publish_id", ((IQZoneApiProxy) QRoute.api(IQZoneApiProxy.class)).getPublishId());
            }
            return hashMap;
        }
    }

    public ElegantProfileQZoneComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iComponentCenter, (Object) profileCardInfo);
        } else {
            this.mNewTipsLinkClickListener = new View.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.bussiness.qzone.ElegantProfileQZoneComponent.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ElegantProfileQZoneComponent.this);
                    }
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str;
                    EventCollector.getInstance().onViewClickedBefore(view);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view);
                    } else {
                        ((IQZoneApiProxy) QRoute.api(IQZoneApiProxy.class)).generatePublishId();
                        if (((AbsComponent) ElegantProfileQZoneComponent.this).mActivity == null || TextUtils.isEmpty(ElegantProfileQZoneComponent.this.mNewTipsLinkJumpUrl) || !ElegantProfileQZoneComponent.this.mNewTipsLinkJumpUrl.startsWith(ElegantProfileQZoneComponent.SCHEME_QZONE_WRITE_MOOD) || !((IQZoneRouteApi) QRoute.api(IQZoneRouteApi.class)).launchMediaPickToPublishMood(((AbsComponent) ElegantProfileQZoneComponent.this).mActivity)) {
                            ElegantProfileQZoneComponent elegantProfileQZoneComponent = ElegantProfileQZoneComponent.this;
                            elegantProfileQZoneComponent.openByJumpParser(elegantProfileQZoneComponent.mNewTipsLinkJumpUrl);
                            ITianshuManager iTianshuManager = (ITianshuManager) QRoute.api(ITianshuManager.class);
                            ElegantProfileQZoneComponent elegantProfileQZoneComponent2 = ElegantProfileQZoneComponent.this;
                            String str2 = "";
                            if (!TextUtils.isEmpty(elegantProfileQZoneComponent2.mNewTipsLinkTianshuAdId)) {
                                str = ElegantProfileQZoneComponent.this.mNewTipsLinkTianshuAdId;
                            } else {
                                str = "";
                            }
                            if (!TextUtils.isEmpty(ElegantProfileQZoneComponent.this.mNewTipsLinkTianshuTraceInfo)) {
                                str2 = ElegantProfileQZoneComponent.this.mNewTipsLinkTianshuTraceInfo;
                            }
                            iTianshuManager.report(elegantProfileQZoneComponent2.buildTianShuReportData(102, str, str2));
                            QZoneLoginReportHelper.reportLoginFromFriendProfile(ElegantProfileQZoneComponent.this.getTargetUin());
                        }
                    }
                    EventCollector.getInstance().onViewClicked(view);
                }
            };
            this.mUrgeUpdateClickListener = new View.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.bussiness.qzone.ElegantProfileQZoneComponent.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ElegantProfileQZoneComponent.this);
                    }
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    EventCollector.getInstance().onViewClickedBefore(view);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        ElegantProfileQZoneComponent.this.handleOnClickUrgeUpdate();
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view);
                    }
                    EventCollector.getInstance().onViewClicked(view);
                }
            };
        }
    }

    private void bindNewContentTipLinkWithDTReportParams(@NonNull TextView textView, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(ProfileCardDtReportUtil.DT_REPORT_PARAM_TIANSHU_AD_ID, this.mNewTipsLinkTianshuAdId);
        hashMap.put(ProfileCardDtReportUtil.DT_REPORT_PARAM_TALK_TAG_ID, this.mNewTipsLinkTagId);
        hashMap.put(ProfileCardDtReportUtil.DT_REPORT_PARAM_TEXT_CHAIN_TYPE, str);
        ProfileCardDtReportUtil.initElementWithExposureClickAndParams(textView, ProfileCardDtReportUtil.DT_REPORT_SPACE_ENTRANCE, hashMap, new LinkTextDynamicParams());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TianShuReportData buildTianShuReportData(int i3, String str, String str2) {
        TianShuReportData tianShuReportData = new TianShuReportData();
        tianShuReportData.mTraceId = this.mApp.getCurrentAccountUin();
        tianShuReportData.mTraceNum = 1;
        tianShuReportData.mAppId = "tianshu.247";
        tianShuReportData.mPageId = "tianshu.247";
        tianShuReportData.mItemId = str;
        tianShuReportData.mOperTime = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        tianShuReportData.mActionId = i3;
        tianShuReportData.mActionValue = 1;
        tianShuReportData.mTriggerInfo = str2;
        return tianShuReportData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void clearUrgeUpdateTipTextCache() {
        DATA data = this.mData;
        if (data != 0 && ((ProfileCardInfo) data).card != null && ((ProfileCardInfo) data).card.mapQzoneEx != null && ((ProfileCardInfo) data).card.mapQzoneEx.containsKey(KEY_URGE_UPDATE)) {
            ((ProfileCardInfo) this.mData).card.mapQzoneEx.remove(KEY_URGE_UPDATE);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0145  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean createPhotoView(QQAppInterface qQAppInterface, Card card, ViewGroup viewGroup, PhotoInfo photoInfo, int i3, int i16, int[] iArr, int i17) {
        String str;
        String str2;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        String str3 = photoInfo.strPicUrl;
        View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.h0z, (ViewGroup) null);
        RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) inflate.findViewById(R.id.ifh);
        roundRelativeLayout.f316195e = ViewUtils.dpToPx(1.0f);
        roundRelativeLayout.setVisibility(0);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.dkv);
        View findViewById = inflate.findViewById(R.id.f165805dl0);
        View findViewById2 = inflate.findViewById(R.id.dku);
        View findViewById3 = inflate.findViewById(R.id.dkz);
        TextView textView = (TextView) inflate.findViewById(R.id.dks);
        UnderlineTextView underlineTextView = (UnderlineTextView) inflate.findViewById(R.id.dkr);
        underlineTextView.setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
        Map<String, String> map = photoInfo.mapEx;
        if (map != null) {
            String str4 = map.get("info_type");
            String str5 = photoInfo.mapEx.get(KEY_FEEDS_CONTENT);
            z16 = "1".equals(photoInfo.mapEx.get(BaseProfileQZoneComponent.KEY_IS_VIDEO));
            str2 = str4;
            str = str5;
        } else {
            str = "";
            str2 = "";
            z16 = false;
        }
        if (TextUtils.equals(str2, "1") && !TextUtils.isEmpty(str)) {
            underlineTextView.setText(str);
            underlineTextView.setVisibility(0);
            imageView.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = underlineTextView.getLayoutParams();
            layoutParams.width = i3;
            layoutParams.height = i3;
            int lineHeight = underlineTextView.getLineHeight();
            if (lineHeight > 0) {
                underlineTextView.setMaxLines(getTextCount(card));
            } else {
                QLog.w(TAG, 1, "makeOrRefreshQZone: invalid lineHeight:" + lineHeight);
            }
        } else if (!TextUtils.isEmpty(str3)) {
            if (this.mQzoneDefaultPic == null) {
                this.mQzoneDefaultPic = new ColorDrawable(this.mActivity.getResources().getColor(R.color.f157194kw));
            }
            try {
                Option failDrawable = Option.obtain().setUrl(str3).setTargetView(imageView).setLoadingDrawable(this.mQzoneDefaultPic).setFailDrawable(this.mQzoneDefaultPic);
                if (z16) {
                    failDrawable.setPreferDecoder(a.class);
                }
                c.a().h(failDrawable);
                if (!str3.contains("video=1") && !z16) {
                    z18 = false;
                    BaseProfileQZoneComponent.setVisible(findViewById, z18);
                    if (photoInfo.IsOnlySelf != 1) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    BaseProfileQZoneComponent.setVisible(findViewById3, z19);
                }
                z18 = true;
                BaseProfileQZoneComponent.setVisible(findViewById, z18);
                if (photoInfo.IsOnlySelf != 1) {
                }
                BaseProfileQZoneComponent.setVisible(findViewById3, z19);
            } catch (Exception e16) {
                QLog.e(LevelUtil.PROFILE_CARD_TAG, 1, "makeOrRefreshQZone fail!", e16);
            }
        } else {
            z17 = false;
            if (z17) {
                QLog.w(TAG, 1, "makeOrRefreshQZone: needUpdateUI=false,skip this one");
                return false;
            }
            viewGroup.addView(inflate);
            ViewGroup.LayoutParams layoutParams2 = inflate.getLayoutParams();
            if (layoutParams2 instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams2;
                layoutParams3.rightMargin = i16;
                inflate.setLayoutParams(layoutParams3);
            }
            ViewGroup.LayoutParams layoutParams4 = imageView.getLayoutParams();
            if (isDIYTemplateProfile()) {
                layoutParams4.width = -1;
                layoutParams4.height = -1;
            } else {
                layoutParams4.width = i3;
                layoutParams4.height = i3;
            }
            imageView.setLayoutParams(layoutParams4);
            ViewGroup.LayoutParams layoutParams5 = findViewById2.getLayoutParams();
            if (isDIYTemplateProfile()) {
                layoutParams5.width = -1;
                layoutParams5.height = -1;
            } else {
                layoutParams5.width = i3;
                layoutParams5.height = i3;
            }
            findViewById2.setLayoutParams(layoutParams5);
            int i18 = iArr[0];
            if (i18 > 0) {
                iArr[0] = i18 + i16;
            }
            int i19 = iArr[0] + i3;
            iArr[0] = i19;
            if (i19 + i3 + i16 > i17) {
                log(String.format(Locale.getDefault(), "makeOrRefreshQZone cur:%s, photo:%s, margin:%s, max: %s", Integer.valueOf(iArr[0]), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17)));
                return true;
            }
            findViewById2.setVisibility(8);
            textView.setVisibility(8);
            return false;
        }
        z17 = true;
        if (z17) {
        }
    }

    private String getNewContentTip(Card card) {
        String str = card.strQzoneHeader;
        if (str == null) {
            return "";
        }
        String[] split = str.split("\uff1a");
        if (split.length < 2) {
            return "";
        }
        return split[1];
    }

    private String getNewContentTipFromMapEx(Card card) {
        Map<String, String> map;
        if (card != null && (map = card.mapQzoneEx) != null && map.containsKey(KEY_NEW_TIPS_TEXT)) {
            parseNewTipsParams(card);
            return card.mapQzoneEx.get(KEY_NEW_TIPS_TEXT);
        }
        parseNewTipsParams(null);
        QLog.d(TAG, 1, "no corresponding data in mapQzoneEx");
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public String getTargetUin() {
        AllInOne allInOne;
        ProfileCardInfo profileCardInfo = (ProfileCardInfo) this.mData;
        if (profileCardInfo != null && (allInOne = profileCardInfo.allInOne) != null && !TextUtils.isEmpty(allInOne.uin)) {
            String str = profileCardInfo.allInOne.uin;
            if (str.startsWith(Marker.ANY_NON_NULL_MARKER)) {
                return str.substring(1);
            }
            return str;
        }
        return "";
    }

    private String getTitleText(ProfileCardInfo profileCardInfo) {
        String genderName = getGenderName(profileCardInfo);
        if (profileCardInfo.allInOne.f260789pa == 0) {
            return HardCodeUtil.qqStr(R.string.ac5);
        }
        return String.format("%s%s", genderName, this.mActivity.getString(R.string.bwp));
    }

    private String getUrgeUpdateTipText(Card card) {
        Map<String, String> map;
        if (card != null && (map = card.mapQzoneEx) != null && map.containsKey(KEY_URGE_UPDATE)) {
            return card.mapQzoneEx.get(KEY_URGE_UPDATE);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void handleOnClickUrgeUpdate() {
        if (this.mIsClickUrge) {
            QLog.w(TAG, 1, "handleOnClickUrgeUpdate  mIsClickUrge is true, repeat");
            return;
        }
        DATA data = this.mData;
        if (data != 0 && ((ProfileCardInfo) data).card != null) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (!(peekAppRuntime instanceof QQAppInterface)) {
                QLog.e(TAG, 1, "handleOnClickUrgeUpdate  app error");
                return;
            }
            this.mIsClickUrge = true;
            try {
                ArrayList arrayList = new ArrayList();
                arrayList.add(Long.valueOf(Long.parseLong(((ProfileCardInfo) this.mData).card.uin)));
                NewIntent newIntent = new NewIntent(peekAppRuntime.getApplication(), QZoneUrgeUpdateFeedServlet.class);
                d.b(newIntent, d.a(7, Long.parseLong(peekAppRuntime.getCurrentAccountUin()), arrayList, 0L, ""));
                peekAppRuntime.startServlet(newIntent);
                QLog.d(TAG, 1, "handleOnClickUrgeUpdate   | urgedUinList = " + arrayList.toString());
                return;
            } catch (NumberFormatException e16) {
                QLog.e(TAG, 1, "handleOnClickUrgeUpdate  e = " + e16);
                return;
            }
        }
        QLog.e(TAG, 1, "handleOnClickUrgeUpdate  data error");
    }

    private void handleUrgeUpdateRsp(QZoneUrgeUpdateRspResultEvent qZoneUrgeUpdateRspResultEvent) {
        RFWThreadManager.getUIHandler().post(new Runnable(qZoneUrgeUpdateRspResultEvent) { // from class: com.tencent.mobileqq.profilecard.bussiness.qzone.ElegantProfileQZoneComponent.3
            static IPatchRedirector $redirector_;
            final /* synthetic */ QZoneUrgeUpdateRspResultEvent val$event;

            {
                this.val$event = qZoneUrgeUpdateRspResultEvent;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ElegantProfileQZoneComponent.this, (Object) qZoneUrgeUpdateRspResultEvent);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    ElegantProfileQZoneComponent.this.mIsClickUrge = false;
                    if (this.val$event == null) {
                        QLog.e(ElegantProfileQZoneComponent.TAG, 1, "handleUrgeUpdateRsp  event == null");
                        return;
                    }
                    QLog.d(ElegantProfileQZoneComponent.TAG, 1, "handleUrgeUpdateRsp  event.isSuccess = " + this.val$event.isSuccess());
                    if (this.val$event.isSuccess()) {
                        QQToast.makeText(((AbsComponent) ElegantProfileQZoneComponent.this).mActivity, 2, HardCodeUtil.qqStr(R.string.f22008686), 0).show();
                        ((TextView) ((View) ((AbsComponent) ElegantProfileQZoneComponent.this).mViewContainer).findViewById(R.id.zpq)).setVisibility(8);
                        ElegantProfileQZoneComponent elegantProfileQZoneComponent = ElegantProfileQZoneComponent.this;
                        elegantProfileQZoneComponent.tipsVisibilityState = 8;
                        elegantProfileQZoneComponent.clearUrgeUpdateTipTextCache();
                        return;
                    }
                    QQToast.makeText(((AbsComponent) ElegantProfileQZoneComponent.this).mActivity, 1, HardCodeUtil.qqStr(R.string.f22006684), 0).show();
                    return;
                }
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        });
    }

    private void initNewContentTip(Card card, boolean z16) {
        if (isHost() && !TextUtils.isEmpty(getNewContentTipFromMapEx(card))) {
            initNewContentTipNew(card, z16);
        } else {
            initNewContentTipOld(card, z16);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initNewContentTipNew(Card card, boolean z16) {
        String str;
        ((View) this.mViewContainer).findViewById(R.id.zpp).setVisibility(8);
        this.tipsVisibilityState = 8;
        TextView textView = (TextView) ((View) this.mViewContainer).findViewById(R.id.zpq);
        QLog.d(TAG, 1, "initNewContentTipNew  linkText = " + textView);
        String str2 = "";
        bindNewContentTipLinkWithDTReportParams(textView, "");
        if (!z16 && card.isShowFeeds() && !TextUtils.isEmpty(this.mNewTipsLinkText)) {
            textView.setVisibility(0);
            textView.setOnClickListener(this.mNewTipsLinkClickListener);
            textView.setText(this.mNewTipsLinkText);
            ITianshuManager iTianshuManager = (ITianshuManager) QRoute.api(ITianshuManager.class);
            if (TextUtils.isEmpty(this.mNewTipsLinkTianshuAdId)) {
                str = "";
            } else {
                str = this.mNewTipsLinkTianshuAdId;
            }
            if (!TextUtils.isEmpty(this.mNewTipsLinkTianshuTraceInfo)) {
                str2 = this.mNewTipsLinkTianshuTraceInfo;
            }
            iTianshuManager.report(buildTianShuReportData(101, str, str2));
            return;
        }
        textView.setVisibility(8);
        textView.setOnClickListener(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initNewContentTipOld(Card card, boolean z16) {
        String newContentTip = getNewContentTip(card);
        View findViewById = ((View) this.mViewContainer).findViewById(R.id.zpp);
        TextView textView = (TextView) ((View) this.mViewContainer).findViewById(R.id.zpq);
        textView.setVisibility(8);
        TextView textView2 = (TextView) ((View) this.mViewContainer).findViewById(R.id.zpo);
        QLog.i(TAG, 1, "initNewContentTipOld  | tip = " + newContentTip + " | card.strQzoneHeader = " + card.strQzoneHeader);
        if (!z16 && card.isShowFeeds() && !TextUtils.isEmpty(newContentTip)) {
            findViewById.setVisibility(0);
            this.tipsVisibilityState = 0;
            textView2.setText(newContentTip);
            textView.setOnClickListener(null);
            return;
        }
        findViewById.setVisibility(8);
        this.tipsVisibilityState = 8;
        String urgeUpdateTipText = getUrgeUpdateTipText(card);
        QLog.i(TAG, 1, "initNewContentTipOld  urgeUpdateTipText = " + urgeUpdateTipText);
        if (TextUtils.isEmpty(urgeUpdateTipText)) {
            textView.setVisibility(8);
            return;
        }
        bindNewContentTipLinkWithDTReportParams(textView, KEY_URGE_UPDATE);
        textView.setVisibility(0);
        textView.setOnClickListener(this.mUrgeUpdateClickListener);
        textView.setText(urgeUpdateTipText);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean isHost() {
        if (((ProfileCardInfo) this.mData).allInOne.f260789pa == 0) {
            return true;
        }
        return false;
    }

    private static void log(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean openByJumpParser(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.toLowerCase().startsWith(SchemaUtils.SCHEMA_MQQAPI)) {
            ax c16 = bi.c((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime(), this.mActivity, str);
            if (c16 != null) {
                c16.b();
                return true;
            }
            QLog.e(TAG, 1, "openByJumpParser, parse mqqAPI url failed.");
            return false;
        }
        if (!str.toLowerCase().startsWith("mqzone")) {
            return false;
        }
        QZoneHelper.onMQzoneSchema(this.mActivity, str);
        return true;
    }

    private void parseNewTipsParams(Card card) {
        if (card == null) {
            this.mNewTipsLinkText = null;
            this.mNewTipsLinkJumpUrl = null;
            this.mNewTipsLinkTianshuAdId = null;
            this.mNewTipsLinkTianshuTraceInfo = null;
            this.mNewTipsLinkTagId = null;
            return;
        }
        this.mNewTipsLinkText = card.mapQzoneEx.get(KEY_NEW_TIPS_TEXT);
        String str = card.mapQzoneEx.get(KEY_NEW_TIPS_ACTION);
        this.mNewTipsLinkJumpUrl = str;
        this.mNewTipsLinkTagId = k15.a.h(str).getString(KEY_TAG_ID);
        this.mNewTipsLinkTianshuAdId = card.mapQzoneEx.get(KEY_NEW_TIPS_TIANSHU_ADID);
        this.mNewTipsLinkTianshuTraceInfo = card.mapQzoneEx.get(KEY_NEW_TIPS_TIANSHU_TRACEINFO);
    }

    private void resetPhotoContainer(QQAppInterface qQAppInterface, ProfileCardInfo profileCardInfo, Card card, ViewGroup viewGroup, List<PhotoInfo> list) {
        if (list.isEmpty()) {
            return;
        }
        int dpToPx = ViewUtils.dpToPx(2.0f);
        float dpToPx2 = ViewUtils.dpToPx(16.0f);
        int i3 = (int) ((this.mScreenWidth - dpToPx2) - dpToPx2);
        int columnCount = ((int) ((i3 - ((r0 - 1) * dpToPx)) * 1.0f)) / getColumnCount(card);
        log(String.format(Locale.getDefault(), "makeOrRefreshQZone count:%s, photo:%s, margin:%s, max: %s", Integer.valueOf(list.size()), Integer.valueOf(columnCount), Integer.valueOf(dpToPx), Integer.valueOf(i3)));
        int[] iArr = {0};
        Iterator<PhotoInfo> it = list.iterator();
        while (it.hasNext() && !createPhotoView(qQAppInterface, card, viewGroup, it.next(), columnCount, dpToPx, iArr, i3)) {
        }
    }

    @Override // com.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent
    public int getColumnCount(Card card) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this, (Object) card)).intValue();
        }
        return 4;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: getComponentName */
    public String getTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return TAG;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public int getComponentType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 1012;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (ArrayList) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QZoneUrgeUpdateRspResultEvent.class);
        return arrayList;
    }

    public String getGenderName(ProfileCardInfo profileCardInfo) {
        Card card;
        String string;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this, (Object) profileCardInfo);
        }
        QBaseActivity qBaseActivity = this.mActivity;
        if (qBaseActivity == null) {
            return DEFAULT_GUEST_GENDER;
        }
        String string2 = qBaseActivity.getString(R.string.f207375_u);
        if (profileCardInfo != null && (card = profileCardInfo.card) != null) {
            if (card.shGender == 1) {
                string = this.mActivity.getString(R.string.f207365_t);
            } else {
                string = this.mActivity.getString(R.string.f207375_u);
            }
            return string;
        }
        return string2;
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent, com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent
    public String getProfileContentKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return IProfileContentKey.MAP_KEY_QZONE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent
    public boolean makeOrRefreshQZone(Card card) {
        boolean z16;
        View view;
        boolean z17;
        int i3;
        boolean z18;
        View view2;
        ImageView imageView;
        String charSequence;
        PhotoInfo photoInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) card)).booleanValue();
        }
        ProfileCardInfo profileCardInfo = (ProfileCardInfo) this.mData;
        QQAppInterface qQAppInterface = this.mQQAppInterface;
        LayoutInflater from = LayoutInflater.from(this.mActivity);
        if (ProfilePAUtils.isPaTypeHasUin(profileCardInfo.allInOne) && card != null && !this.mIsFromArkBabyQ && !ProfilePAUtils.isFromGuild(profileCardInfo.allInOne.f260789pa)) {
            View view3 = (View) this.mViewContainer;
            if (isDIYTemplateProfile()) {
                view3 = null;
            }
            if (view3 == null) {
                View qZoneDiyView = ProfileTemplateApi.getDiyMoreInfoManager(this.mComponentCenter).getQZoneDiyView(IProfileContentKey.MAP_KEY_QZONE);
                VIEW view4 = qZoneDiyView;
                if (qZoneDiyView == null) {
                    view4 = from.inflate(R.layout.h0y, (ViewGroup) null);
                }
                this.mViewContainer = view4;
                view = view4;
                z17 = true;
            } else {
                view = view3;
                z17 = false;
            }
            ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.dkt);
            ViewGroup viewGroup2 = (ViewGroup) view.findViewById(R.id.ax7);
            TextView textView = (TextView) view.findViewById(R.id.jj7);
            ImageView imageView2 = (ImageView) view.findViewById(R.id.dcv);
            View findViewById = view.findViewById(R.id.zpp);
            textView.setSingleLine(true);
            textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
            HashMap hashMap = new HashMap();
            if (!card.hasGotPhotoUrl()) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            hashMap.put(ProfileCardDtReportUtil.DT_REPORT_PARAM_IS_EMPTY, Integer.valueOf(i3));
            VideoReport.setElementParams(this.mViewContainer, hashMap);
            int i16 = card.ulShowControl;
            if ((i16 & 128) != 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            log(String.format("makeOrRefreshQZone card.ulShowControl=%x hasLocked=%s", Integer.valueOf(i16), Boolean.valueOf(z18)));
            if (!z18 && ((card.isShowPhoto() || card.hasFakeData) && card.hasGotPhotoUrl())) {
                List<PhotoInfo> qZonePhotoList = card.getQZonePhotoList();
                if (qZonePhotoList == null) {
                    qZonePhotoList = Collections.emptyList();
                }
                if (profileCardInfo.allInOne.f260789pa == 0) {
                    if (qZonePhotoList.size() >= this.qzonePicNums) {
                        this.qzonePicNums = qZonePhotoList.size();
                    } else {
                        card.hasFakeData = false;
                        return true;
                    }
                }
                if (viewGroup2 != null && viewGroup2.getVisibility() != 8) {
                    viewGroup2.removeAllViews();
                    viewGroup2.setVisibility(8);
                }
                textView.setVisibility(0);
                if (qZonePhotoList.isEmpty()) {
                    photoInfo = null;
                } else {
                    photoInfo = qZonePhotoList.get(0);
                }
                if (!z17 && isSamePhotoInfo(this.mLastPhotoInfo, photoInfo) && this.mLastPhotoListSize == qZonePhotoList.size()) {
                    log("makeOrRefreshQZone don't update photo area,photo count:" + qZonePhotoList.size());
                    view2 = findViewById;
                    imageView = imageView2;
                } else {
                    viewGroup.removeAllViews();
                    viewGroup.setVisibility(0);
                    this.photoVisibilityState = 0;
                    List<PhotoInfo> list = qZonePhotoList;
                    view2 = findViewById;
                    imageView = imageView2;
                    resetPhotoContainer(qQAppInterface, profileCardInfo, card, viewGroup, list);
                    this.mLastPhotoInfo = photoInfo;
                    this.mLastPhotoListSize = list.size();
                    log("makeOrRefreshQZone update photo area,photo count:" + list.size());
                }
            } else {
                view2 = findViewById;
                imageView = imageView2;
                viewGroup.setVisibility(8);
                this.photoVisibilityState = 8;
                viewGroup2.setVisibility(8);
                textView.setVisibility(0);
            }
            if (profileCardInfo.allInOne.f260789pa == 0) {
                textView.setText(HardCodeUtil.qqStr(R.string.ac5));
            } else {
                textView.setText(getTitleText(profileCardInfo));
            }
            initNewContentTip(card, z18);
            if (textView.getText() == null) {
                charSequence = "";
            } else {
                charSequence = textView.getText().toString();
            }
            view.setOnClickListener(this);
            view.setContentDescription(textView.getText());
            updateItemTheme(view, textView, null, imageView);
            QBaseActivity qBaseActivity = this.mActivity;
            if (qBaseActivity != null && qBaseActivity.getResources() != null) {
                view.setBackground(this.mActivity.getResources().getDrawable(R.drawable.ktt));
            }
            if (z17) {
                IDiyMoreInfoManager diyMoreInfoManager = ProfileTemplateApi.getDiyMoreInfoManager(this.mComponentCenter);
                if (ProfileTemplateApi.getDiyMoreInfoManager(this.mComponentCenter).isDiy()) {
                    diyMoreInfoManager.updateQzoneForDeepDiy(view);
                }
            }
            checkBlackListForbid(viewGroup, view2);
            log(String.format("makeOrRefreshQZone, [h:%s, des: %s, space: %s, remark: %s, nick: %s, info: %s]", k.d(card.strQzoneHeader), k.d(card.strQzoneFeedsDesc), k.d(card.strSpaceName), k.d(profileCardInfo.nameArray[4]), k.d(profileCardInfo.nameArray[0]), k.d(charSequence)));
            return z17;
        }
        if (this.mViewContainer != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mViewContainer = null;
        return z16;
    }

    @Override // com.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
        } else {
            super.onActivityResult(i3, i16, intent);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent, android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) view);
        } else {
            startQzoneShowFeed();
            ProfileCardDtReportUtil.dtReportClick(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent, com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onCreate(QBaseActivity qBaseActivity, @Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) qBaseActivity, (Object) bundle);
        } else {
            super.onCreate(qBaseActivity, bundle);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            super.onPause();
            SimpleEventBus.getInstance().unRegisterReceiver(this);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QZoneUrgeUpdateRspResultEvent) {
            handleUrgeUpdateRsp((QZoneUrgeUpdateRspResultEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.onResume();
            SimpleEventBus.getInstance().registerReceiver(this);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: onDataUpdate */
    public boolean lambda$checkValidComponent$3(ProfileCardInfo profileCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? super.lambda$checkValidComponent$3(profileCardInfo) : ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) profileCardInfo)).booleanValue();
    }
}
