package com.tencent.mobileqq.profilecard.view.vas.svipPrivilege;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.SvipPrivilegeShow;
import com.tencent.mobileqq.profilecard.base.utils.VasSvipPrivilegeAnimateHelper;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.view.vas.svipPrivilege.VasSvipPrivilegePopupWindow;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ff;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.vas.image.c;
import com.tencent.mobileqq.vas.inject.VasInjectApi;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.vipicon.api.IVipIconFactory;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.VoteViewElegant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.qqva.svip_profile_server.svip_privilege_show.SvipPrivilegeShowPB$ReportExposureReq;
import com.tencent.trpcprotocol.qqva.svip_profile_server.svip_privilege_show.SvipPrivilegeShowPB$ReportExposureRsp;
import com.tencent.trpcprotocol.qqva.svip_profile_server.svip_privilege_show.SvipPrivilegeShowPB$SetPrivilegeItem;
import com.tencent.trpcprotocol.qqva.svip_profile_server.svip_privilege_show.SvipPrivilegeShowPB$SetPrivilegeReq;
import com.tencent.trpcprotocol.qqva.svip_profile_server.svip_privilege_show.SvipPrivilegeShowPB$SetPrivilegeRsp;
import cooperation.qzone.mobilereport.MobileReportManager;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes35.dex */
public class VasSvipPrivilegePopupWindow extends PopupWindow {
    private static final String EXPOSE_CMD = "trpc.qqva.svip_profile_server.SsoSvipPrivilegeShow.SsoReportExposure";
    private static final String SET_CMD = "trpc.qqva.svip_profile_server.SsoSvipPrivilegeShow.SsoSetPrivilege";
    private static final String TAG = "VasSvipPrivilegePopupWindow";
    private static final String URL_HEAD_BG = "https://tianquan.gtimg.cn/shoal/vaclient/041bde7f-90ad-49e1-b8f3-a9bf11246bf5.png";
    private static final String URL_USE_BTN = "https://tianquan.gtimg.cn/shoal/vaclient/24c10e7a-712c-4609-bf7c-869e0d5ea6a7.png";
    private final QQAppInterface mApp;
    private AvatarLayout mAvatarLayout;
    private final ProfileCardInfo mCardInfo;
    private View mHeadView;
    private ImageView mIconIv;
    private TextView mIconTv;
    private AnimationTextView mLevelInfo;
    private TextView mLevelTv;
    private TextView mLikeTv;
    private ImageView mNameExtIv;
    private ImageView mNameIv;
    private TextView mNameTv;
    private TextView mPendantTv;
    private TextView mSkipBtn;
    private final List<SvipPrivilegeShow> mSvipPrivilegeShows;
    private ImageView mUseBtn;
    private VoteViewElegant mVoteView;

    public VasSvipPrivilegePopupWindow(Context context, ProfileCardInfo profileCardInfo, List<SvipPrivilegeShow> list) {
        super(LayoutInflater.from(context).inflate(R.layout.hhh, (ViewGroup) null), -1, -1);
        this.mApp = (QQAppInterface) ((QBaseActivity) context).getAppRuntime();
        this.mCardInfo = profileCardInfo;
        this.mSvipPrivilegeShows = list;
        setClippingEnabled(false);
        setBackgroundDrawable(new ColorDrawable(0));
        initView();
        refreshData();
    }

    private void addAvatarAndPendant(String str, int i3) {
        this.mPendantTv.setText(str);
        VasSvipPrivilegeAnimateHelper.replacePendant(this.mAvatarLayout, this.mCardInfo, i3);
    }

    private void addLevelIcon(String str, int i3) {
        this.mLevelTv.setText(str);
        VasSvipPrivilegeAnimateHelper.replaceLevelIcon(this.mLevelInfo, this.mCardInfo, i3);
    }

    private void addLikeArea(String str, int i3) {
        this.mLikeTv.setText(str);
        this.mVoteView.setVoteImageId(R.drawable.qui_like, R.drawable.qui_like_filled);
        VasSvipPrivilegeAnimateHelper.replaceLikeAreaId(this.mVoteView, this.mCardInfo, i3);
        this.mVoteView.setVoteNumColor(-1);
        ((ImageView) this.mVoteView.findViewById(R.id.l0l)).setColorFilter(-1);
    }

    private void addNameplate(String str) {
        this.mNameTv.setText(str);
        Card card = this.mCardInfo.card;
        c icon = ((IVipIconFactory) QRoute.api(IVipIconFactory.class)).getIcon(getContentView().getResources(), card.uin, VasInjectApi.getInstance().getVipIconInfo(card));
        if (icon != null) {
            this.mNameIv.setImageDrawable(icon);
        } else {
            this.mNameIv.setImageDrawable(null);
            this.mNameExtIv.setVisibility(4);
        }
        int[] d16 = ff.j.d(this.mApp, card.uin);
        if (!ff.C(d16[0]) && !ff.H(d16[0])) {
            this.mNameExtIv.setVisibility(8);
        } else {
            ff.j.l(getContentView().getContext(), this.mNameExtIv, card.nameplateExtId, 2);
        }
    }

    private void addVipIcon(String str, String str2) {
        this.mIconTv.setText(str);
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.mIconIv.setImageDrawable(((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getDynamicDrawable(str2));
    }

    private void initView() {
        this.mHeadView = getContentView().findViewById(R.id.f28250if);
        this.mPendantTv = (TextView) getContentView().findViewById(R.id.f28340io);
        this.mNameTv = (TextView) getContentView().findViewById(R.id.f28370ir);
        this.mLikeTv = (TextView) getContentView().findViewById(R.id.f28310il);
        this.mLevelTv = (TextView) getContentView().findViewById(R.id.f28290ij);
        this.mIconTv = (TextView) getContentView().findViewById(R.id.f28270ih);
        AvatarLayout avatarLayout = (AvatarLayout) getContentView().findViewById(R.id.f28240ie);
        this.mAvatarLayout = avatarLayout;
        avatarLayout.d(0, avatarLayout.findViewById(R.id.f28230id), true);
        this.mNameIv = (ImageView) getContentView().findViewById(R.id.f28320im);
        this.mNameExtIv = (ImageView) getContentView().findViewById(R.id.f28330in);
        this.mIconIv = (ImageView) getContentView().findViewById(R.id.f28260ig);
        this.mUseBtn = (ImageView) getContentView().findViewById(R.id.f28360iq);
        this.mSkipBtn = (TextView) getContentView().findViewById(R.id.f28350ip);
        this.mVoteView = (VoteViewElegant) getContentView().findViewById(R.id.f28300ik);
        this.mLevelInfo = (AnimationTextView) getContentView().findViewById(R.id.f28280ii);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadButtons$0(View view) {
        onUseClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadButtons$1(View view) {
        onDismissClick();
    }

    private void loadButtons() {
        this.mUseBtn.setImageDrawable(((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getDynamicDrawable(URL_USE_BTN));
        this.mUseBtn.setOnClickListener(new View.OnClickListener() { // from class: rd2.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VasSvipPrivilegePopupWindow.this.lambda$loadButtons$0(view);
            }
        });
        this.mSkipBtn.setOnClickListener(new View.OnClickListener() { // from class: rd2.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VasSvipPrivilegePopupWindow.this.lambda$loadButtons$1(view);
            }
        });
    }

    private void loadHeadBg() {
        this.mHeadView.setBackground(((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getDynamicDrawable(URL_HEAD_BG));
    }

    private void onDismissClick() {
        MobileReportManager.getInstance().reportAction("not_set", "4", "data_card", "vip_privilege_unity", "", 102, 0, System.currentTimeMillis(), "");
        dismiss();
    }

    private void onExpose() {
        try {
            SvipPrivilegeShowPB$ReportExposureReq svipPrivilegeShowPB$ReportExposureReq = new SvipPrivilegeShowPB$ReportExposureReq();
            svipPrivilegeShowPB$ReportExposureReq.exposure_time.set(System.currentTimeMillis());
            VasUtil.getService().getPbRequest().request(EXPOSE_CMD, new String(svipPrivilegeShowPB$ReportExposureReq.toByteArray(), "ISO8859_1"), new BusinessObserver() { // from class: rd2.c
                @Override // com.tencent.mobileqq.app.BusinessObserver
                public final void onUpdate(int i3, boolean z16, Object obj) {
                    VasSvipPrivilegePopupWindow.lambda$onExpose$2(i3, z16, obj);
                }
            });
        } catch (Exception e16) {
            QLog.e(TAG, 1, "onExpose error", e16);
        }
        MobileReportManager.getInstance().reportAction("", "", "data_card", "vip_privilege_unity", "", 100, 0, System.currentTimeMillis(), "");
    }

    private void onUseClick() {
        try {
            SvipPrivilegeShowPB$SetPrivilegeReq svipPrivilegeShowPB$SetPrivilegeReq = new SvipPrivilegeShowPB$SetPrivilegeReq();
            ArrayList arrayList = new ArrayList();
            for (SvipPrivilegeShow svipPrivilegeShow : this.mSvipPrivilegeShows) {
                SvipPrivilegeShowPB$SetPrivilegeItem svipPrivilegeShowPB$SetPrivilegeItem = new SvipPrivilegeShowPB$SetPrivilegeItem();
                svipPrivilegeShowPB$SetPrivilegeItem.appid.set(svipPrivilegeShow.appId);
                svipPrivilegeShowPB$SetPrivilegeItem.item_id.set(svipPrivilegeShow.itemId);
                arrayList.add(svipPrivilegeShowPB$SetPrivilegeItem);
            }
            svipPrivilegeShowPB$SetPrivilegeReq.privilege_items.set(arrayList);
            VasUtil.getService().getPbRequest().request(SET_CMD, new String(svipPrivilegeShowPB$SetPrivilegeReq.toByteArray(), "ISO8859_1"), new BusinessObserver() { // from class: rd2.d
                @Override // com.tencent.mobileqq.app.BusinessObserver
                public final void onUpdate(int i3, boolean z16, Object obj) {
                    VasSvipPrivilegePopupWindow.lambda$onUseClick$3(i3, z16, obj);
                }
            });
        } catch (Exception e16) {
            QLog.e(TAG, 1, "onUseClick error", e16);
        }
        MobileReportManager.getInstance().reportAction("set_now", "4", "data_card", "vip_privilege_unity", "", 102, 0, System.currentTimeMillis(), "");
        VasSvipPrivilegeAnimateHelper.playSvipPrivilegeAnimation(this.mCardInfo, this.mSvipPrivilegeShows);
        dismiss();
    }

    private void refreshData() {
        try {
            List<SvipPrivilegeShow> list = this.mSvipPrivilegeShows;
            if (list != null && !list.isEmpty()) {
                for (SvipPrivilegeShow svipPrivilegeShow : this.mSvipPrivilegeShows) {
                    int i3 = svipPrivilegeShow.appId;
                    if (i3 == 4) {
                        addAvatarAndPendant(svipPrivilegeShow.text, svipPrivilegeShow.itemId);
                    } else if (i3 == 34) {
                        addNameplate(svipPrivilegeShow.text);
                    } else if (i3 == 41) {
                        addLevelIcon(svipPrivilegeShow.text, svipPrivilegeShow.itemId);
                    } else if (i3 == 48) {
                        addVipIcon(svipPrivilegeShow.text, svipPrivilegeShow.icon);
                    } else if (i3 == 328) {
                        addLikeArea(svipPrivilegeShow.text, svipPrivilegeShow.itemId);
                    }
                }
                loadHeadBg();
                loadButtons();
                onExpose();
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "VasSvipPrivilegePopupWindow err , msg:" + th5.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onExpose$2(int i3, boolean z16, Object obj) {
        if (z16 && i3 == 0 && obj != null) {
            try {
                SvipPrivilegeShowPB$ReportExposureRsp svipPrivilegeShowPB$ReportExposureRsp = new SvipPrivilegeShowPB$ReportExposureRsp();
                svipPrivilegeShowPB$ReportExposureRsp.mergeFrom((byte[]) obj);
                QLog.d(TAG, 1, "onExpose ret=" + svipPrivilegeShowPB$ReportExposureRsp.ret.get() + ",msg=" + svipPrivilegeShowPB$ReportExposureRsp.f381642msg.get());
                return;
            } catch (Exception e16) {
                QLog.e(TAG, 1, "onExpose error", e16);
                return;
            }
        }
        QLog.e(TAG, 1, "onExpose error not sucess");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onUseClick$3(int i3, boolean z16, Object obj) {
        if (z16 && i3 == 0 && obj != null) {
            try {
                SvipPrivilegeShowPB$SetPrivilegeRsp svipPrivilegeShowPB$SetPrivilegeRsp = new SvipPrivilegeShowPB$SetPrivilegeRsp();
                svipPrivilegeShowPB$SetPrivilegeRsp.mergeFrom((byte[]) obj);
                QLog.d(TAG, 1, "onUseClick ret=" + svipPrivilegeShowPB$SetPrivilegeRsp.ret.get() + ",msg=" + svipPrivilegeShowPB$SetPrivilegeRsp.f381643msg.get());
                return;
            } catch (Exception e16) {
                QLog.e(TAG, 1, "onUseClick error", e16);
                return;
            }
        }
        QLog.e(TAG, 1, "onUseClick error not sucess");
    }
}
