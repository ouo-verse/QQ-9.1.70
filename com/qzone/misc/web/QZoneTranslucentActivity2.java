package com.qzone.misc.web;

import NS_MOBILE_FEEDS.single_feed;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import com.qzone.common.activities.FeedActionPanelActivity;
import com.qzone.common.activities.base.BaseFragment;
import com.qzone.common.activities.base.QZoneFeedOperateLogic;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.feed.utils.QZoneFeedUtil;
import com.qzone.feed.utils.b;
import com.qzone.feed.utils.e;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.util.QZLog;
import d5.k;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneTranslucentActivity2 extends BaseFragment implements e {
    BusinessFeedData C;
    QZoneFeedOperateLogic D;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            QZoneTranslucentActivity2.this.D.handleGetShareUrl(QZoneResult.unpack(message));
        }
    }

    private void sh() {
        Intent intent = new Intent("action_launch_completed");
        String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "FriendFeed", QzoneConfig.DefaultValue.DEFAULT_FRIENDFEED_TITLE);
        intent.putExtra("plugin_apk", "qzone_plugin.apk");
        intent.putExtra("plugin_name", config);
        sendBroadcast(intent);
    }

    @Override // d5.n
    public boolean Lc() {
        return false;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        Intent intent = getIntent();
        if (intent == null) {
            QZLog.w("QZoneTranslucentActivity2", "intent is null");
            finish();
            return;
        }
        if (intent.getBooleanExtra("QZoneExtra.Plugin.isloading", false)) {
            sh();
        }
        single_feed single_feedVar = (single_feed) intent.getSerializableExtra("feed");
        if (single_feedVar != null) {
            this.C = BusinessFeedData.createFrom(single_feedVar, 0);
        }
        if (this.C == null) {
            QZLog.e("QZoneTranslucentActivity2", "businessFeedData null");
            finish();
            return;
        }
        int intExtra = intent.getIntExtra("action", 0);
        if (intExtra == 4) {
            QZoneFeedUtil.W(this.C, 3, this);
            return;
        }
        if (intExtra == 3) {
            QZoneFeedOperateLogic qZoneFeedOperateLogic = new QZoneFeedOperateLogic(new a(), getActivity(), QZoneFeedOperateLogic.FROM_GONGZHONGHAO);
            this.D = qZoneFeedOperateLogic;
            qZoneFeedOperateLogic.setFeedData(this.C);
            try {
                this.D.onShareToQQ();
                return;
            } catch (Exception e16) {
                QLog.e("QZoneTranslucentActivity2", 1, e16, new Object[0]);
                return;
            }
        }
        QZLog.e("QZoneTranslucentActivity2", "action error");
        finish();
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (i16 != -1) {
            if (i16 != 0) {
                if (QZLog.isColorLevel()) {
                    QZLog.i("QZoneTranslucentActivity2", "share error resultCode:" + i16);
                }
                finish();
                return;
            }
            if (QZLog.isColorLevel()) {
                QZLog.i("QZoneTranslucentActivity2", "share cancled");
            }
            finish();
            return;
        }
        String stringExtra = intent.getStringExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_CACHE_UNIKEY);
        if (i3 == 1205) {
            QZoneFeedUtil.r(QZoneFeedUtil.f47421a.get("activity_result_ahare_to_qzone_key"), intent.getStringExtra("contentIntentKey"), 2, null, stringExtra, getHandler(), intent.getBooleanExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FORWARDANDCOMMENT, false), 2);
        } else {
            if (i3 != 1206) {
                if (QZLog.isColorLevel()) {
                    QZLog.i("QZoneTranslucentActivity2", "share error requestcode:" + i3);
                }
                finish();
                return;
            }
            QZoneFeedUtil.r(QZoneFeedUtil.f47421a.get("current_forward_key"), intent.getStringExtra("contentIntentKey"), 1, null, stringExtra, getHandler(), intent.getBooleanExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FORWARDANDCOMMENT, false), 2);
        }
    }

    @Override // com.qzone.common.activities.base.BaseFragment
    public void onHandleMessage(Message message) {
        String string;
        super.onHandleMessage(message);
        if (isFinishing()) {
            return;
        }
        QZoneResult unpack = QZoneResult.unpack(message);
        if (unpack == null) {
            finish();
            return;
        }
        if (unpack.what == 999908) {
            if (unpack.getSucceed()) {
                int intValue = ((Integer) unpack.getData()).intValue();
                if (intValue == 1) {
                    string = getResources().getString(R.string.akw);
                } else if (intValue != 2) {
                    string = intValue != 7 ? null : getResources().getString(R.string.f170824al0);
                } else {
                    string = getResources().getString(R.string.f170825al1);
                }
                toast(string, 5);
            } else {
                toast(unpack.getMessage());
            }
            finish();
        }
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onWindowFocusChanged(boolean z16) {
        super.onWindowFocusChanged(z16);
    }

    @Override // com.qzone.feed.utils.e
    public void x0(e.a aVar, Serializable serializable, Parcelable parcelable, Map<String, Object> map) {
        boolean z16;
        int i3;
        aVar.f47477j = this.C.getFeedCommInfo().ugckey;
        BusinessFeedData businessFeedData = this.C;
        if (map == null) {
            map = new HashMap<>();
        }
        Map<String, Object> map2 = map;
        if (businessFeedData != null) {
            map2.put("extra_key_cur_like_key", businessFeedData.getFeedCommInfo().curlikekey);
            map2.put("extra_key_ugc_key", businessFeedData.getFeedCommInfo().ugckey);
            map2.put("extra_key_is_op_comment_poke_like", Boolean.FALSE);
        }
        Intent I = QZoneFeedUtil.I(getActivity(), aVar, serializable, parcelable, null, true, 3, map2);
        I.putExtra("show_barrage_effect_icon", aVar.f47473f);
        if (businessFeedData != null) {
            z16 = businessFeedData.isFeedCommentInsertImage();
            if (businessFeedData.getFeedCommInfo().is_kuolie) {
                I.putExtra("isFromExtendWarmFeed", true);
            }
        } else {
            z16 = false;
        }
        if (z16) {
            i3 = FeedActionPanelActivity.M1;
        } else {
            i3 = FeedActionPanelActivity.L1;
        }
        I.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_SHOW_PICCOMMENT, i3);
        I.putExtra("extra_key_from_scene", 7);
        if (b.b(I)) {
            return;
        }
        if (aVar.f47480m) {
            getOutActivity().startActivityForResult(I, aVar.f47476i);
        } else {
            startActivityForResult(I, aVar.f47476i);
        }
    }

    @Override // com.qzone.common.activities.base.BaseFragment
    public void IOnSetTheme() {
        setTheme(R.style.f173748jk);
    }

    @Override // d5.n
    public void F7() {
    }

    @Override // d5.n
    public void b9(k<BusinessFeedData> kVar) {
    }
}
