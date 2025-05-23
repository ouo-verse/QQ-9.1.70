package com.tencent.mobileqq.profilecard.bussiness.personalitysign;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.tencent.av.utils.ba;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ar;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.config.business.sigtopic.SigTopicConfProcessor;
import com.tencent.mobileqq.config.business.sigtopic.a;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.profile.b;
import com.tencent.mobileqq.profile.k;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.api.IProfileCardFeatureApi;
import com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.base.component.IProfileContentKey;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent;
import com.tencent.mobileqq.profilecard.base.utils.ProfileCardUtils;
import com.tencent.mobileqq.profilecard.base.utils.ProfileSignatureUtils;
import com.tencent.mobileqq.profilecard.bussiness.personalitysign.utils.RichStatusUtils;
import com.tencent.mobileqq.profilecard.bussiness.personalitysign.utils.UiUtils;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.richstatus.c;
import com.tencent.mobileqq.richstatus.e;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.ITopic;
import com.tencent.mobileqq.text.OffsetableImageSpan;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.j;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.bo;
import com.tencent.mobileqq.widget.imageview.CircleBoarderImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.d;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.util.Pair;
import com.tencent.widget.AbsListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tencent.im.oidb.oidb_0xd9f.oidb_0xd9f$LongNickItem;
import tencent.im.oidb.oidb_0xd9f.oidb_0xd9f$RspBody;
import tencent.im.oidb.oidb_0xd9f.oidb_0xd9f$TopicItem;
import tencent.im.oidb.oidb_0xd9f.oidb_0xd9f$UinItem;

/* loaded from: classes16.dex */
public abstract class ProfileContentSignComponent extends AbsQQProfileContentComponent implements View.OnClickListener, ITopic.OnTopicClickListener, DecodeTaskCompletionListener, AbsListView.OnScrollListener {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ProfileContentSignComponent";
    private boolean isInitDtReport;
    private String mActionText;
    private Map<String, CircleBoarderImageView> mCommonTopicFriendAvatar;
    private IFaceDecoder mDecoder;
    private int mDrawableSize;
    private ar mFriendListObserver;
    private boolean mFromExtendFriend;
    private TextView mInfo;
    private String mPlainText;
    private int mPos;
    private RichStatusIconListener mStatusIconListener;
    private String mTopic;
    private RichStatus richStatus;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public static class RichStatusIconListener implements e {
        static IPatchRedirector $redirector_;
        private WeakReference<ProfileContentSignComponent> mRef;

        public RichStatusIconListener(ProfileContentSignComponent profileContentSignComponent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) profileContentSignComponent);
            } else {
                this.mRef = new WeakReference<>(profileContentSignComponent);
            }
        }

        @Override // com.tencent.mobileqq.richstatus.e
        public void onGetIcon(int i3, int i16, Bitmap bitmap) {
            ProfileContentSignComponent profileContentSignComponent;
            RichStatus richStatus;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), bitmap);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(ProfileContentSignComponent.TAG, 2, String.format("onGetIcon actionId=%s size=%s icon=%s", Integer.valueOf(i3), Integer.valueOf(i16), bitmap));
            }
            if (bitmap != null && (profileContentSignComponent = this.mRef.get()) != null && (richStatus = profileContentSignComponent.richStatus) != null && richStatus.actionId == i3) {
                profileContentSignComponent.makeOrRefreshSign(((ProfileCardInfo) ((AbsComponent) profileContentSignComponent).mData).card, false);
            }
        }
    }

    public ProfileContentSignComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iComponentCenter, (Object) profileCardInfo);
            return;
        }
        this.richStatus = null;
        this.isInitDtReport = false;
        this.mFriendListObserver = new ar() { // from class: com.tencent.mobileqq.profilecard.bussiness.personalitysign.ProfileContentSignComponent.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ProfileContentSignComponent.this);
                }
            }

            @Override // com.tencent.mobileqq.app.ar
            protected void onSetSelfSignatureResult(boolean z16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, z16);
                    return;
                }
                if (((AbsComponent) ProfileContentSignComponent.this).mApp != null && ((ProfileCardInfo) ((AbsComponent) ProfileContentSignComponent.this).mData).allInOne.uin.equals(((AbsComponent) ProfileContentSignComponent.this).mApp.getCurrentAccountUin())) {
                    d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(((AbsComponent) ProfileContentSignComponent.this).mApp.getCurrentAccountUin()), ProfileContentSignComponent.TAG);
                    if (friendsSimpleInfoWithUid != null) {
                        ProfileContentSignComponent.this.setNewSignature(friendsSimpleInfoWithUid.s(), friendsSimpleInfoWithUid.t());
                    }
                }
            }

            @Override // com.tencent.mobileqq.app.ar
            protected void onUpdateSignature(boolean z16, String[] strArr) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, this, Boolean.valueOf(z16), strArr);
                    return;
                }
                if (z16 && strArr != null && strArr.length > 0 && ((AbsComponent) ProfileContentSignComponent.this).mApp != null) {
                    for (String str : strArr) {
                        if (TextUtils.equals(((ProfileCardInfo) ((AbsComponent) ProfileContentSignComponent.this).mData).allInOne.uin, str)) {
                            d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(((ProfileCardInfo) ((AbsComponent) ProfileContentSignComponent.this).mData).allInOne.uin), ProfileContentSignComponent.TAG);
                            if (friendsSimpleInfoWithUid != null) {
                                ProfileContentSignComponent.this.richStatus = c.h(friendsSimpleInfoWithUid);
                                ProfileContentSignComponent profileContentSignComponent = ProfileContentSignComponent.this;
                                profileContentSignComponent.makeOrRefreshSign(((ProfileCardInfo) ((AbsComponent) profileContentSignComponent).mData).card, false);
                                return;
                            }
                            return;
                        }
                    }
                }
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void adjustSignInfoViewLayout() {
        VIEW view = this.mViewContainer;
        if (view == 0) {
            return;
        }
        TextView textView = (TextView) ((View) view).findViewById(R.id.info);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
        layoutParams.width = -1;
        textView.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v24, types: [android.view.View, VIEW] */
    public boolean makeOrRefreshSign(Card card, boolean z16) {
        boolean z17;
        int color;
        int i3;
        SpannableString spannableString;
        int i16;
        boolean z18;
        boolean z19;
        boolean z26 = false;
        if (shouldForbidUpdate(card)) {
            return false;
        }
        DATA data = this.mData;
        if (((ProfileCardInfo) data).allInOne.f260789pa == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        boolean isPaTypeHasUin = ProfilePAUtils.isPaTypeHasUin(((ProfileCardInfo) data).allInOne);
        Resources resources = this.mActivity.getResources();
        if (ProfileCardUtils.isDefaultProfile((ProfileCardInfo) this.mData)) {
            i3 = resources.getColor(R.color.skin_black);
            color = resources.getColor(R.color.skin_black);
        } else {
            color = resources.getColor(R.color.black);
            i3 = RichStatus.ACTION_COLOR_NORMAL;
        }
        RichStatus richStatus = this.richStatus;
        if (richStatus == null && card != null) {
            richStatus = RichStatusUtils.INSTANCE.getRichStatus(card);
        }
        if (richStatus != null) {
            spannableString = new SpannableString(richStatus.toSpannableStringWithTopic(getPrefixText(), i3, color, this));
        } else {
            spannableString = null;
        }
        String str = "";
        if (spannableString == null) {
            spannableString = new SpannableString("");
        }
        HashMap hashMap = new HashMap();
        if (spannableString.length() == 0) {
            i16 = 1;
        } else {
            i16 = 2;
        }
        hashMap.put(ProfileCardDtReportUtil.DT_REPORT_PARAM_IS_EMPTY, Integer.valueOf(i16));
        VideoReport.setElementParams(this.mViewContainer, hashMap);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("makeOrRefreshSign isHost=%s isPaTypeHasUin=%s length=%s", Boolean.valueOf(z17), Boolean.valueOf(isPaTypeHasUin), Integer.valueOf(spannableString.length())));
        }
        boolean isContactProfileElegantVersion = ((IProfileCardFeatureApi) QRoute.api(IProfileCardFeatureApi.class)).isContactProfileElegantVersion();
        if (card != null) {
            str = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(card.uin);
        }
        DATA data2 = this.mData;
        if (data2 != 0 && ((ProfileCardInfo) data2).allInOne != null && ProfilePAUtils.isPaTypeStrangerInContact(((ProfileCardInfo) data2).allInOne)) {
            z18 = true;
        } else {
            z18 = false;
        }
        boolean isFriend = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(str, TAG);
        if ((!z17 && spannableString.length() == 0) || (!isFriend && (!z18 || !isContactProfileElegantVersion))) {
            if (this.mViewContainer != 0) {
                this.mViewContainer = null;
                z26 = true;
            }
        } else {
            if (this.mViewContainer == 0) {
                this.mViewContainer = initViewContainer();
                z19 = true;
            } else {
                z19 = false;
            }
            View view = (View) this.mViewContainer;
            View findViewById = view.findViewById(R.id.m2g);
            TextView textView = (TextView) view.findViewById(R.id.info);
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.lqz);
            if (SimpleUIUtil.isNowElderMode()) {
                view.setMinimumHeight(resources.getDimensionPixelSize(R.dimen.cai));
                view.setMinimumWidth(resources.getDimensionPixelSize(R.dimen.cai));
            }
            textView.setTextColor(i3);
            StatusManager statusManager = (StatusManager) this.mApp.getManager(QQManagerFactory.STATUS_MANAGER);
            boolean z27 = z17;
            SpannableString spannableString2 = spannableString;
            RichStatus richStatus2 = richStatus;
            updateSignInfo(z27, spannableString2, richStatus2, textView, linearLayout, statusManager);
            updateSignTopic(z27, spannableString2, richStatus2, view, textView, linearLayout);
            updateSignContentDescription(richStatus, findViewById);
            updateRichStatusIconListener(richStatus, statusManager);
            if (z17 || ProfilePAUtils.isPaTypeFriend(((ProfileCardInfo) this.mData).allInOne)) {
                findViewById.setTag(new b(3, null));
                findViewById.setOnClickListener(this);
            }
            updateItemTheme(findViewById, textView, null, null);
            initView(view, z17, spannableString);
            z26 = z19;
        }
        IDiyMoreInfoManager diyMoreInfoManager = ProfileTemplateApi.getDiyMoreInfoManager(this.mComponentCenter);
        if (diyMoreInfoManager.isDiy()) {
            VIEW view2 = this.mViewContainer;
            if (view2 != 0) {
                ((View) view2).setBackgroundResource(R.drawable.f160556k2);
            }
            diyMoreInfoManager.updateSignForDeepDiy((View) this.mViewContainer);
        }
        adjustSignInfoViewLayout();
        return z26;
    }

    private void setAvatar(String str, CircleBoarderImageView circleBoarderImageView) {
        Bitmap bitmap;
        IFaceDecoder iFaceDecoder = this.mDecoder;
        if (iFaceDecoder != null) {
            bitmap = iFaceDecoder.getBitmapFromCache(1, str);
            if (bitmap == null && !this.mDecoder.isPausing()) {
                this.mDecoder.requestDecodeFace(str, 1, true);
                this.mCommonTopicFriendAvatar.put(str, circleBoarderImageView);
            }
        } else {
            bitmap = null;
        }
        if (bitmap == null) {
            bitmap = BaseImageUtil.getDefaultFaceBitmap();
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
        if (ThemeUtil.isInNightMode(this.mApp)) {
            bitmapDrawable.setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
        }
        circleBoarderImageView.setImageDrawable(bitmapDrawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void setNewSignature(byte[] bArr, long j3) {
        boolean z16;
        Card r16;
        if (((ProfileCardInfo) this.mData).allInOne.f260789pa == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            EntityManager createEntityManager = this.mApp.getEntityManagerFactory().createEntityManager();
            FriendsManager friendsManager = (FriendsManager) this.mApp.getManager(QQManagerFactory.FRIENDS_MANAGER);
            if (friendsManager == null) {
                r16 = null;
            } else {
                r16 = friendsManager.r(((ProfileCardInfo) this.mData).allInOne.uin);
            }
            if (r16 == null) {
                r16 = new Card();
                r16.uin = ((ProfileCardInfo) this.mData).allInOne.uin;
                r16.vRichSign = bArr;
                r16.lSignModifyTime = j3;
                createEntityManager.persist(r16);
            } else {
                r16.vRichSign = bArr;
                r16.lSignModifyTime = j3;
                createEntityManager.update(r16);
            }
            this.richStatus = RichStatusUtils.INSTANCE.getRichStatus(r16);
            makeOrRefreshSign(((ProfileCardInfo) this.mData).card, false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean shouldForbidUpdate(Card card) {
        byte[] bArr;
        if (card != null && (((bArr = card.vRichSign) == null || bArr.length == 0) && ((card.lSignModifyTime > 0 || TextUtils.isEmpty(card.strSign)) && ProfilePAUtils.isPaTypeStrangerInContact(((ProfileCardInfo) this.mData).allInOne) && ((IProfileCardFeatureApi) QRoute.api(IProfileCardFeatureApi.class)).isContactProfileElegantVersion()))) {
            return true;
        }
        return false;
    }

    private void updateRichStatusIconListener(RichStatus richStatus, StatusManager statusManager) {
        if (richStatus != null && !TextUtils.isEmpty(richStatus.actionText)) {
            this.richStatus = richStatus;
            if (this.mStatusIconListener == null && statusManager != null) {
                RichStatusIconListener richStatusIconListener = new RichStatusIconListener(this);
                this.mStatusIconListener = richStatusIconListener;
                statusManager.C(richStatusIconListener);
                return;
            }
            return;
        }
        this.richStatus = null;
        Object obj = this.mStatusIconListener;
        if (obj != null && statusManager != null) {
            statusManager.b0(obj);
            this.mStatusIconListener = null;
        }
    }

    private void updateSignContentDescription(RichStatus richStatus, View view) {
        String str;
        int i3;
        StringBuilder sb5 = new StringBuilder();
        if (richStatus != null) {
            String str2 = richStatus.actionText;
            if (str2 != null) {
                sb5.append(str2);
            }
            String str3 = richStatus.dataText;
            if (str3 != null) {
                sb5.append(str3);
            }
            if (richStatus.topics != null) {
                for (int i16 = 0; i16 < richStatus.topics.size(); i16++) {
                    if (!TextUtils.isEmpty(richStatus.topics.get(i16).second)) {
                        sb5.append(richStatus.topics.get(i16).second);
                    }
                }
            }
            ArrayList<String> arrayList = richStatus.plainText;
            if (arrayList != null) {
                i3 = arrayList.size();
            } else {
                i3 = 0;
            }
            for (int i17 = 0; i17 < i3; i17++) {
                String str4 = richStatus.plainText.get(i17);
                if (!TextUtils.isEmpty(str4)) {
                    sb5.append(str4);
                }
            }
        }
        if (TextUtils.isEmpty(sb5)) {
            str = HardCodeUtil.qqStr(R.string.f203294zt);
        } else {
            str = HardCodeUtil.qqStr(R.string.pem) + ((Object) sb5);
        }
        view.setContentDescription(str);
    }

    private void updateSignInfo(boolean z16, SpannableString spannableString, RichStatus richStatus, TextView textView, LinearLayout linearLayout, StatusManager statusManager) {
        Bitmap g16;
        if (richStatus != null && !TextUtils.isEmpty(richStatus.actionText)) {
            Resources resources = this.mActivity.getResources();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spannableString);
            spannableStringBuilder.insert(0, (CharSequence) "[S] ");
            if (statusManager != null) {
                g16 = statusManager.K(richStatus.actionId, 200);
            } else {
                g16 = j.g(resources, R.drawable.bwk);
            }
            int textSize = (int) ((textView.getTextSize() * 1.1f) + 0.5f);
            bo boVar = new bo(resources, g16, false, false);
            boVar.setBounds(0, 0, textSize, textSize);
            OffsetableImageSpan offsetableImageSpan = new OffsetableImageSpan(boVar, 0);
            offsetableImageSpan.setOffset(-0.1f);
            spannableStringBuilder.setSpan(offsetableImageSpan, 0, 3, 17);
            this.mDrawableSize = textSize;
            textView.setText(new QQText(spannableStringBuilder, 1, 20));
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        } else {
            this.mDrawableSize = 0;
            if (spannableString.length() == 0 && z16) {
                textView.setText(getEmptyStringId());
                recommendTopicViewControl(linearLayout, z16);
            } else {
                textView.setText(new QQText(spannableString, 1, 20));
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
        ViewCompat.setImportantForAccessibility(textView, 2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void updateSignTopic(boolean z16, SpannableString spannableString, RichStatus richStatus, View view, TextView textView, LinearLayout linearLayout) {
        List<Pair<Integer, String>> list;
        String str;
        int i3;
        List<Pair<Integer, String>> list2;
        int i16;
        if (spannableString.length() >= 0) {
            if (richStatus != null && (list2 = richStatus.topics) != null && list2.size() > 0) {
                if (z16) {
                    i16 = 1;
                } else {
                    i16 = 2;
                }
                ReportController.o(null, "dc00898", "", "", "0X800A4D2", "0X800A4D2", i16, 0, "" + i16, "0", "", "");
            }
            List<oidb_0xd9f$TopicItem> list3 = null;
            if (!k.d().i(this.mQQAppInterface) && richStatus != null && (list = richStatus.topics) != null && list.size() > 0 && !this.mFromExtendFriend) {
                ArrayList<String> arrayList = richStatus.plainText;
                if (arrayList != null && arrayList.size() > 0) {
                    str = richStatus.plainText.get(0);
                } else {
                    str = null;
                }
                this.mPlainText = str;
                richStatus.sortTopicPos();
                List<Pair<Integer, Integer>> list4 = richStatus.topicsPos;
                if (list4 != null && list4.size() > 0) {
                    i3 = richStatus.topicsPos.get(0).second.intValue();
                } else {
                    i3 = 0;
                }
                this.mPos = i3;
                if (ProfileUtils.isVisible(textView)) {
                    textView.post(new Runnable(textView, richStatus) { // from class: com.tencent.mobileqq.profilecard.bussiness.personalitysign.ProfileContentSignComponent.3
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ TextView val$info;
                        final /* synthetic */ RichStatus val$richStatus;

                        {
                            this.val$info = textView;
                            this.val$richStatus = richStatus;
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, this, ProfileContentSignComponent.this, textView, richStatus);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            int k3;
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this);
                                return;
                            }
                            if (((AbsComponent) ProfileContentSignComponent.this).mActivity == null || ((AbsComponent) ProfileContentSignComponent.this).mActivity.isFinishing() || (k3 = k.d().k(this.val$info, this.val$richStatus.topics.get(0).second, this.val$richStatus.actionText, ProfileContentSignComponent.this.mDrawableSize, ProfileContentSignComponent.this.mPlainText, ProfileContentSignComponent.this.mPos)) == Integer.MIN_VALUE) {
                                return;
                            }
                            UiUtils.INSTANCE.showProfileSignGuideAsDropDown(this.val$info, -k3, 0);
                            k.d().m(((AbsQQProfileContentComponent) ProfileContentSignComponent.this).mQQAppInterface);
                            ReportController.o(null, "dc00898", "", "", "0X800A4D1", "0X800A4D1", 0, 0, "0", "0", "", "");
                        }
                    });
                } else {
                    this.mInfo = textView;
                    this.mTopic = richStatus.topics.get(0).second;
                    this.mActionText = richStatus.actionText;
                }
            }
            k.d().r(this.mQQAppInterface, richStatus);
            boolean n3 = k.d().n(this.mQQAppInterface);
            ImageView imageView = (ImageView) view.findViewById(R.id.maq);
            oidb_0xd9f$RspBody oidb_0xd9f_rspbody = new oidb_0xd9f$RspBody();
            DATA data = this.mData;
            if (((ProfileCardInfo) data).card != null && ((ProfileCardInfo) data).card.vLongNickTopicInfo != null) {
                try {
                    oidb_0xd9f_rspbody.mergeFrom(((ProfileCardInfo) data).card.vLongNickTopicInfo);
                    oidb_0xd9f$LongNickItem oidb_0xd9f_longnickitem = oidb_0xd9f_rspbody.longnick_item.get();
                    if (oidb_0xd9f_longnickitem != null) {
                        list3 = oidb_0xd9f_longnickitem.rpt_topic_item.get();
                    }
                    boolean h16 = k.d().h(this.mQQAppInterface, k.d().e(list3));
                    if (!n3 && !h16) {
                        recommendTopicViewControl(linearLayout, z16);
                        return;
                    }
                    int c16 = k.d().c(list3);
                    if (list3 != null && list3.size() > 0 && c16 > 0) {
                        linearLayout.setTag(new b(97, k.d().f(list3)));
                        linearLayout.setOnClickListener(this);
                        commonSigTopicViewControl(linearLayout, list3);
                        imageView.setOnTouchListener(ba.f77070d);
                        imageView.setOnClickListener(new View.OnClickListener(linearLayout) { // from class: com.tencent.mobileqq.profilecard.bussiness.personalitysign.ProfileContentSignComponent.4
                            static IPatchRedirector $redirector_;
                            final /* synthetic */ View val$topicView;

                            {
                                this.val$topicView = linearLayout;
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileContentSignComponent.this, (Object) linearLayout);
                                }
                            }

                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                EventCollector.getInstance().onViewClickedBefore(view2);
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view2);
                                } else {
                                    k.d().q(((AbsQQProfileContentComponent) ProfileContentSignComponent.this).mQQAppInterface);
                                    this.val$topicView.setVisibility(8);
                                }
                                EventCollector.getInstance().onViewClicked(view2);
                            }
                        });
                        return;
                    }
                    recommendTopicViewControl(linearLayout, z16);
                    return;
                } catch (Exception e16) {
                    QLog.e(TAG, 1, "", e16);
                    return;
                }
            }
            recommendTopicViewControl(linearLayout, z16);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void commonSigTopicViewControl(View view, List<oidb_0xd9f$TopicItem> list) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) view, (Object) list);
            return;
        }
        if (view != null) {
            if (list != null && !list.isEmpty()) {
                view.setVisibility(0);
                ((RelativeLayout) view.findViewById(R.id.lhx)).setVisibility(0);
                CircleBoarderImageView circleBoarderImageView = (CircleBoarderImageView) view.findViewById(R.id.f164802ld1);
                CircleBoarderImageView circleBoarderImageView2 = (CircleBoarderImageView) view.findViewById(R.id.f164803ld2);
                CircleBoarderImageView circleBoarderImageView3 = (CircleBoarderImageView) view.findViewById(R.id.f164804ld3);
                ArrayList arrayList = new ArrayList();
                arrayList.add(circleBoarderImageView);
                arrayList.add(circleBoarderImageView2);
                arrayList.add(circleBoarderImageView3);
                TextView textView = (TextView) view.findViewById(R.id.mc7);
                Collections.sort(list, new Comparator<oidb_0xd9f$TopicItem>() { // from class: com.tencent.mobileqq.profilecard.bussiness.personalitysign.ProfileContentSignComponent.5
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ProfileContentSignComponent.this);
                        }
                    }

                    @Override // java.util.Comparator
                    public int compare(oidb_0xd9f$TopicItem oidb_0xd9f_topicitem, oidb_0xd9f$TopicItem oidb_0xd9f_topicitem2) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            return ((Integer) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) oidb_0xd9f_topicitem, (Object) oidb_0xd9f_topicitem2)).intValue();
                        }
                        if (oidb_0xd9f_topicitem == null) {
                            return 1;
                        }
                        return (oidb_0xd9f_topicitem2 != null && oidb_0xd9f_topicitem.uint32_frd_num.get() <= oidb_0xd9f_topicitem2.uint32_frd_num.get()) ? 1 : -1;
                    }
                });
                int c16 = k.d().c(list);
                List<oidb_0xd9f$UinItem> b16 = k.d().b(list);
                if (b16.size() > arrayList.size()) {
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        ((CircleBoarderImageView) arrayList.get(i3)).setVisibility(0);
                        setAvatar(String.valueOf(b16.get(i3).uint64_uin.get()), (CircleBoarderImageView) arrayList.get(i3));
                    }
                } else {
                    for (int i16 = 0; i16 < arrayList.size(); i16++) {
                        if (i16 < b16.size()) {
                            ((CircleBoarderImageView) arrayList.get(i16)).setVisibility(0);
                            setAvatar(String.valueOf(b16.get(i16).uint64_uin.get()), (CircleBoarderImageView) arrayList.get(i16));
                        } else {
                            ((CircleBoarderImageView) arrayList.get(i16)).setVisibility(8);
                        }
                    }
                }
                if (c16 <= 3) {
                    str = c16 + HardCodeUtil.qqStr(R.string.pej);
                } else {
                    str = HardCodeUtil.qqStr(R.string.pdq) + c16 + HardCodeUtil.qqStr(R.string.pd6);
                }
                textView.setText(str);
                if (ThemeUtil.isNowThemeIsNight(this.mApp, false, null)) {
                    view.setBackgroundDrawable(null);
                } else if (!ProfileCardUtils.isDefaultProfile((ProfileCardInfo) this.mData)) {
                    view.setBackgroundDrawable(this.mActivity.getResources().getDrawable(R.drawable.hgv));
                } else {
                    view.setBackgroundDrawable(this.mActivity.getResources().getDrawable(R.drawable.hgu));
                }
                ReportController.o(null, "dc00898", "", "", "0X800A4D4", "0X800A4D4", 0, 0, "1", "0", "", "");
                return;
            }
            view.setVisibility(8);
        }
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
        return 1011;
    }

    protected int getEmptyStringId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return R.string.fru;
    }

    protected String getPrefixText() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent, com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent
    public String getProfileContentKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return IProfileContentKey.MAP_KEY_PERSONAL_SIG;
    }

    public void hideCommonTopicFriendAvatarControl(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) view);
            return;
        }
        if (view != null) {
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.lhx);
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
            CircleBoarderImageView circleBoarderImageView = (CircleBoarderImageView) view.findViewById(R.id.f164802ld1);
            CircleBoarderImageView circleBoarderImageView2 = (CircleBoarderImageView) view.findViewById(R.id.f164803ld2);
            CircleBoarderImageView circleBoarderImageView3 = (CircleBoarderImageView) view.findViewById(R.id.f164804ld3);
            if (circleBoarderImageView != null) {
                circleBoarderImageView.setVisibility(8);
            }
            if (circleBoarderImageView2 != null) {
                circleBoarderImageView2.setVisibility(8);
            }
            if (circleBoarderImageView3 != null) {
                circleBoarderImageView3.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void initView(View view, boolean z16, SpannableString spannableString) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, view, Boolean.valueOf(z16), spannableString);
            return;
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.f164472yw);
        if (imageView != null) {
            if (!z16 && !ProfilePAUtils.isPaTypeFriend(((ProfileCardInfo) this.mData).allInOne)) {
                i3 = 4;
            }
            imageView.setVisibility(i3);
        }
        updateItemTheme(null, null, null, imageView);
    }

    public abstract View initViewContainer();

    /* JADX WARN: Multi-variable type inference failed */
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view);
        } else if (view.getTag() instanceof b) {
            b bVar = (b) view.getTag();
            int i3 = bVar.f260135a;
            if (i3 == 3) {
                ProfileSignatureUtils.handleSignatureClick((ProfileCardInfo) this.mData, this.mActivity, this.mQQAppInterface);
            } else if (i3 == 97) {
                Pair pair = (Pair) bVar.f260136b;
                ProfileSignatureUtils.handleSignatureCommonClick(view, ((Integer) pair.first).intValue(), (String) pair.second, this.mActivity, this.mQQAppInterface);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onCreate(QBaseActivity qBaseActivity, @Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) qBaseActivity, (Object) bundle);
            return;
        }
        super.onCreate(qBaseActivity, bundle);
        Intent intent = this.mActivity.getIntent();
        if (intent != null) {
            this.mFromExtendFriend = intent.getBooleanExtra(IProfileCardConst.KEY_FROM_EXTENDS_FRIENDS, false);
        }
        IFaceDecoder iQQAvatarService = ((IQQAvatarService) this.mApp.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.mApp);
        this.mDecoder = iQQAvatarService;
        iQQAvatarService.setDecodeTaskCompletionListener(this);
        this.mCommonTopicFriendAvatar = new HashMap();
        this.mApp.addObserver(this.mFriendListObserver);
        IProfileActivityDelegate iProfileActivityDelegate = this.mDelegate;
        if (iProfileActivityDelegate != null) {
            iProfileActivityDelegate.addProfileScrollListener(this);
        }
    }

    @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
    public void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
        CircleBoarderImageView circleBoarderImageView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16), str, bitmap);
            return;
        }
        Map<String, CircleBoarderImageView> map = this.mCommonTopicFriendAvatar;
        if (map != null && (circleBoarderImageView = map.get(str)) != null) {
            circleBoarderImageView.setImageBitmap(bitmap);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        this.mApp.removeObserver(this.mFriendListObserver);
        IProfileActivityDelegate iProfileActivityDelegate = this.mDelegate;
        if (iProfileActivityDelegate != null) {
            iProfileActivityDelegate.removeProfileScrollListener(this);
        }
        if (this.mStatusIconListener != null) {
            ((StatusManager) this.mApp.getManager(QQManagerFactory.STATUS_MANAGER)).b0(this.mStatusIconListener);
            this.mStatusIconListener = null;
        }
        IFaceDecoder iFaceDecoder = this.mDecoder;
        if (iFaceDecoder != null) {
            iFaceDecoder.destory();
            this.mDecoder = null;
        }
        Map<String, CircleBoarderImageView> map = this.mCommonTopicFriendAvatar;
        if (map != null) {
            map.clear();
            this.mCommonTopicFriendAvatar = null;
        }
        super.onDestroy();
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, absListView, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) absListView, i3);
        } else if (i3 == 0 && !k.d().i(this.mQQAppInterface) && ProfileUtils.isVisible(this.mInfo)) {
            this.mInfo.post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.bussiness.personalitysign.ProfileContentSignComponent.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ProfileContentSignComponent.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    int k3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (((AbsComponent) ProfileContentSignComponent.this).mActivity == null || ((AbsComponent) ProfileContentSignComponent.this).mActivity.isFinishing() || (k3 = k.d().k(ProfileContentSignComponent.this.mInfo, ProfileContentSignComponent.this.mTopic, ProfileContentSignComponent.this.mActionText, ProfileContentSignComponent.this.mDrawableSize, ProfileContentSignComponent.this.mPlainText, ProfileContentSignComponent.this.mPos)) == Integer.MIN_VALUE) {
                        return;
                    }
                    UiUtils.INSTANCE.showProfileSignGuideAsDropDown(ProfileContentSignComponent.this.mInfo, -k3, 0);
                    k.d().m(((AbsQQProfileContentComponent) ProfileContentSignComponent.this).mQQAppInterface);
                    ReportController.o(null, "dc00898", "", "", "0X800A4D1", "0X800A4D1", 0, 0, "0", "0", "", "");
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void recommendTopicViewControl(View view, boolean z16) {
        int i3;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, view, Boolean.valueOf(z16));
            return;
        }
        if (view != null) {
            if (!z16) {
                view.setVisibility(8);
                return;
            }
            if (!k.d().o(this.mQQAppInterface)) {
                view.setVisibility(8);
                return;
            }
            a a16 = SigTopicConfProcessor.a();
            if (a16 != null && !a16.b()) {
                hideCommonTopicFriendAvatarControl(view);
                view.setVisibility(0);
                ArrayList<a.b> arrayList = a16.a().f202831f;
                TextView textView = (TextView) view.findViewById(R.id.mc7);
                ImageView imageView = (ImageView) view.findViewById(R.id.maq);
                textView.setText(k.d().g(a16));
                int i16 = 0;
                while (true) {
                    if (i16 < a16.a().f202831f.size()) {
                        if (TextUtils.isEmpty(arrayList.get(i16).f202833b)) {
                            i16++;
                        } else {
                            i3 = arrayList.get(i16).f202832a;
                            str = arrayList.get(i16).f202833b;
                            break;
                        }
                    } else {
                        i3 = -1;
                        str = "";
                        break;
                    }
                }
                if (z16) {
                    view.setOnClickListener(new View.OnClickListener(str, i3, view) { // from class: com.tencent.mobileqq.profilecard.bussiness.personalitysign.ProfileContentSignComponent.6
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ int val$recommendTagId;
                        final /* synthetic */ String val$recommendTagName;
                        final /* synthetic */ View val$root;

                        {
                            this.val$recommendTagName = str;
                            this.val$recommendTagId = i3;
                            this.val$root = view;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, ProfileContentSignComponent.this, str, Integer.valueOf(i3), view);
                            }
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            EventCollector.getInstance().onViewClickedBefore(view2);
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view2);
                            } else if (com.tencent.mobileqq.richstatus.topic.c.a(this.val$recommendTagName) && this.val$recommendTagId >= 0) {
                                Bundle bundle = new Bundle();
                                bundle.putString("key_sign_topic_name", this.val$recommendTagName);
                                bundle.putInt("key_sign_topic_id", this.val$recommendTagId);
                                bundle.putInt("from_type", 2);
                                if (((AbsComponent) ProfileContentSignComponent.this).mActivity != null) {
                                    Intent intent = new Intent();
                                    intent.putExtras(bundle);
                                    intent.putExtra("public_fragment_class", "com.tencent.mobileqq.signature.SignTextEditFragment");
                                    intent.setClass(((AbsComponent) ProfileContentSignComponent.this).mActivity, QPublicFragmentActivity.class);
                                    ((AbsComponent) ProfileContentSignComponent.this).mActivity.startActivityForResult(intent, -1);
                                }
                                this.val$root.setVisibility(8);
                                k.d().p(((AbsQQProfileContentComponent) ProfileContentSignComponent.this).mQQAppInterface);
                                ReportController.o(null, "dc00898", "", "", "0X800A4D5", "0X800A4D5", 0, 0, "2", "0", "", "");
                            }
                            EventCollector.getInstance().onViewClicked(view2);
                        }
                    });
                }
                imageView.setOnTouchListener(ba.f77070d);
                imageView.setOnClickListener(new View.OnClickListener(view) { // from class: com.tencent.mobileqq.profilecard.bussiness.personalitysign.ProfileContentSignComponent.7
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ View val$root;

                    {
                        this.val$root = view;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ProfileContentSignComponent.this, (Object) view);
                        }
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        EventCollector.getInstance().onViewClickedBefore(view2);
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view2);
                        } else {
                            k.d().p(((AbsQQProfileContentComponent) ProfileContentSignComponent.this).mQQAppInterface);
                            this.val$root.setVisibility(8);
                        }
                        EventCollector.getInstance().onViewClicked(view2);
                    }
                });
                if (ThemeUtil.isNowThemeIsNight(this.mApp, false, null)) {
                    view.setBackgroundDrawable(null);
                } else if (!ProfileCardUtils.isDefaultProfile((ProfileCardInfo) this.mData)) {
                    view.setBackgroundDrawable(this.mActivity.getResources().getDrawable(R.drawable.hgv));
                } else {
                    view.setBackgroundDrawable(this.mActivity.getResources().getDrawable(R.drawable.hgu));
                }
                ReportController.o(null, "dc00898", "", "", "0X800A4D4", "0X800A4D4", 0, 0, "2", "0", "", "");
                return;
            }
            view.setVisibility(8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: onDataUpdate, reason: merged with bridge method [inline-methods] */
    public boolean lambda$checkValidComponent$3(ProfileCardInfo profileCardInfo) {
        VIEW view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) profileCardInfo)).booleanValue();
        }
        boolean lambda$checkValidComponent$3 = super.lambda$checkValidComponent$3((ProfileContentSignComponent) profileCardInfo);
        DATA data = this.mData;
        boolean makeOrRefreshSign = lambda$checkValidComponent$3 | makeOrRefreshSign(((ProfileCardInfo) data).card, ((ProfileCardInfo) data).isNetRet);
        if (makeOrRefreshSign && !this.isInitDtReport && (view = this.mViewContainer) != 0) {
            this.isInitDtReport = true;
            ProfileCardDtReportUtil.initElementWithExposure((View) view, ProfileCardDtReportUtil.DT_REPORT_SIGNATURE);
        }
        return makeOrRefreshSign;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.text.ITopic.OnTopicClickListener
    public void onClick(ITopic iTopic, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) iTopic, (Object) view);
            return;
        }
        Object data = iTopic.getData();
        if (data instanceof Pair) {
            Pair pair = (Pair) data;
            com.tencent.mobileqq.richstatus.topic.c.d(this.mActivity, com.tencent.mobileqq.richstatus.topic.c.b(((Integer) pair.first).intValue(), (String) pair.second), -1);
            int i3 = ((ProfileCardInfo) this.mData).allInOne.f260789pa == 0 ? 1 : 2;
            ReportController.o(null, "dc00898", "", "", "0X800A4D3", "0X800A4D3", i3, 0, "" + i3, "0", "", "");
        }
    }
}
