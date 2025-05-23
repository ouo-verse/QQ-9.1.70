package com.tencent.mobileqq.intervideo.now;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ar;
import com.tencent.mobileqq.app.cy;
import com.tencent.mobileqq.data.MessageForQQStory;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.troopshare.e;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.vas.profilecard.util.LevelUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ShareToQQActivity extends BaseActivity {
    static boolean isSharing;
    String phoneNumWithNationCode;
    AllInOne allinone = null;
    String shielTagetUin = "";
    private String mSourceFrom = "";
    private String mArkBody = "";
    ar mFriendListObserver = new a();
    cy shieldListObserver = new b();

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class b extends cy {
        b() {
        }

        @Override // com.tencent.mobileqq.app.cy
        protected void a(boolean z16, List<Long> list) {
            ShareToQQActivity shareToQQActivity = ShareToQQActivity.this;
            AllInOne allInOne = shareToQQActivity.allinone;
            if (allInOne == null) {
                shareToQQActivity.finish();
                return;
            }
            String str = allInOne.uin;
            if (ProfilePAUtils.isPaTypeStrangerInContact(allInOne)) {
                str = ShareToQQActivity.this.getContactStrangerUin();
            }
            int size = list == null ? 0 : list.size();
            boolean z17 = false;
            for (int i3 = 0; !z17 && i3 < size; i3++) {
                if (Utils.p(String.valueOf(list.get(i3)), str)) {
                    z17 = true;
                }
            }
            if (z17) {
                Intent intent = new Intent();
                intent.putExtra("isSuccess", z16);
                intent.putExtra("isCancelShield", false);
                ShareToQQActivity.this.setResult(-1, intent);
            }
            ShareToQQActivity.this.finish();
        }

        @Override // com.tencent.mobileqq.app.cy
        protected void c(boolean z16, List<Long> list) {
            ShareToQQActivity shareToQQActivity = ShareToQQActivity.this;
            AllInOne allInOne = shareToQQActivity.allinone;
            if (allInOne == null) {
                shareToQQActivity.finish();
                return;
            }
            String str = allInOne.uin;
            if (ProfilePAUtils.isPaTypeStrangerInContact(allInOne)) {
                str = ShareToQQActivity.this.getContactStrangerUin();
            }
            boolean z17 = false;
            int size = list == null ? 0 : list.size();
            for (int i3 = 0; !z17 && i3 < size; i3++) {
                if (Utils.p(String.valueOf(list.get(i3)), str)) {
                    z17 = true;
                }
            }
            if (z17) {
                Intent intent = new Intent();
                intent.putExtra("isSuccess", z16);
                intent.putExtra("isCancelShield", true);
                ShareToQQActivity.this.setResult(-1, intent);
            }
            ShareToQQActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        String stringExtra = getIntent().getStringExtra("storyid");
        String stringExtra2 = getIntent().getStringExtra(GetAdInfoRequest.SOURCE_FROM);
        if (TextUtils.equals(this.mSourceFrom, "share_from_troop_member_card") && i16 == -1) {
            intent.putExtra(AppConstants.LeftViewText.SELFSET_LEFTVIEWTEXT, getString(R.string.hvn));
            SplashActivity.getAliasIntent(this);
            Intent m3 = BaseAIOUtils.m(intent, null);
            m3.putExtras(new Bundle(intent.getExtras()));
            ForwardUtils.p(this.app, this, ForwardUtils.n0(m3), m3);
        } else if (!TextUtils.equals(stringExtra2, "OD")) {
            if (!TextUtils.isEmpty(stringExtra)) {
                e.G(this.app, this, i16, intent);
            } else {
                e.F(this.app, this, i16, intent);
            }
        }
        isSharing = false;
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        AllInOne allInOne;
        super.doOnCreate(bundle);
        Intent intent = getIntent();
        if (isSharing) {
            finish();
        }
        isSharing = true;
        String stringExtra = intent.getStringExtra("storyid");
        this.mSourceFrom = intent.getStringExtra(GetAdInfoRequest.SOURCE_FROM);
        this.mArkBody = intent.getStringExtra("arkBody");
        if (intent.getBooleanExtra(MiniChatConstants.MINI_APP_LANDSCAPE, false)) {
            setRequestedOrientation(0);
        }
        if ("shiel_uin".equals(this.mSourceFrom)) {
            addObserver(this.mFriendListObserver);
            boolean booleanExtra = intent.getBooleanExtra("isCancelShield", false);
            this.shielTagetUin = intent.getStringExtra("uin");
            try {
                ((FriendListHandler) this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).changeFriendShieldFlag(Long.valueOf(this.shielTagetUin).longValue(), !booleanExtra);
            } catch (NumberFormatException unused) {
                QLog.d("qqBaseActivity", 1, "changeFriendShieldFlag, NumberFormatException:shielTagetUin=" + this.shielTagetUin);
            }
            return false;
        }
        if ("source_from_operate_shiel_uin_list".equals(this.mSourceFrom)) {
            addObserver(this.shieldListObserver);
            boolean booleanExtra2 = intent.getBooleanExtra("isCancelShield", false);
            this.shielTagetUin = intent.getStringExtra("uin");
            this.allinone = (AllInOne) intent.getParcelableExtra("allinone");
            ShieldMsgManger shieldMsgManger = (ShieldMsgManger) this.app.getManager(QQManagerFactory.SHIELD_LIST_MANAGER);
            if (shieldMsgManger != null && (allInOne = this.allinone) != null) {
                try {
                    String str = allInOne.uin;
                    if (ProfilePAUtils.isPaTypeStrangerInContact(allInOne)) {
                        str = getContactStrangerUin();
                    }
                    long parseLong = Long.parseLong(str);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(Long.valueOf(parseLong));
                    int p16 = ProfileCardUtil.p(this.allinone);
                    if (booleanExtra2) {
                        shieldMsgManger.m(p16, arrayList);
                    } else {
                        shieldMsgManger.k(p16, arrayList);
                    }
                } catch (NumberFormatException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e(LevelUtil.PROFILE_CARD_TAG, 2, "shieldMsg() " + e16.toString());
                    }
                }
            } else {
                Intent intent2 = new Intent();
                intent2.putExtra("isSuccess", false);
                intent2.putExtra("isCancelShield", booleanExtra2);
                setResult(-1, intent2);
            }
            return false;
        }
        if ("share_from_troop_member_card".equals(this.mSourceFrom)) {
            intent.putExtra(AppConstants.LeftViewText.SELFSET_LEFTVIEWTEXT, getString(R.string.hvn));
            SplashActivity.getAliasIntent(this);
            Intent m3 = BaseAIOUtils.m(intent, null);
            m3.putExtras(new Bundle(intent.getExtras()));
            ForwardUtils.p(this.app, this, ForwardUtils.n0(m3), m3);
            finish();
            return true;
        }
        if (TextUtils.equals(this.mSourceFrom, "OD")) {
            e.S(this, this.mArkBody);
            finish();
            return true;
        }
        if (!TextUtils.isEmpty(stringExtra)) {
            MessageForQQStory messageForQQStory = new MessageForQQStory();
            messageForQQStory.coverImgUrl = intent.getStringExtra("imageUrl");
            messageForQQStory.brief = intent.getStringExtra("summary");
            messageForQQStory.srcName = vc0.a.f441361a;
            messageForQQStory.srcAction = "mqqapi://qstory/opendiscovery?src_type=internal&version=1";
            messageForQQStory.msgAction = String.format("nowmqqapi://now/openroom?src_type=app&version=1&roomid=%s&first=%d&bid=1&contentType=2&unionid=%s", Long.valueOf(intent.getLongExtra("roomid", 0L)), 2, intent.getStringExtra("unionid"));
            messageForQQStory.authorName = intent.getStringExtra("anchorname");
            messageForQQStory.logoImgUrl = "https://p.qpic.cn/qqstory_pic/hb4ycQ6NORNib7icgbswTvTCmkTyROl41Rcw9UeasFKzLwevbfJVhMRA/";
            messageForQQStory.briefBgColor = -16395392;
            messageForQQStory.type = 0;
            e.U(this, messageForQQStory, 1001);
        } else {
            e.T(this, intent.getExtras(), 1001);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        super.doOnDestroy();
        isSharing = false;
        if ("shiel_uin".equals(this.mSourceFrom)) {
            removeObserver(this.mFriendListObserver);
        } else if ("source_from_operate_shiel_uin_list".equals(this.mSourceFrom)) {
            removeObserver(this.shieldListObserver);
        }
    }

    String getContactStrangerUin() {
        try {
            return ac.m0(this.app, this.phoneNumWithNationCode);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(LevelUtil.PROFILE_CARD_TAG, 2, e16.toString());
            }
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a extends ar {
        a() {
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onUpdateFriendShieldFlag(long j3, boolean z16, boolean z17, boolean z18, String str) {
            String str2;
            if (j3 != 0 && (str2 = ShareToQQActivity.this.shielTagetUin) != null) {
                if (str2.equals(j3 + "")) {
                    Intent intent = new Intent();
                    intent.putExtra("isSuccess", z17);
                    intent.putExtra("isCancelShield", false);
                    ShareToQQActivity.this.setResult(-1, intent);
                }
            }
            ShareToQQActivity.this.finish();
        }
    }
}
