package com.tencent.mobileqq.qqlive.room.prepare.rtmp;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.anchor.prepare.IQQLiveAnchorPrepareWrapper;
import com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin;
import com.tencent.mobileqq.qqlive.business.QQLiveConfigConst;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.qqlive.context.QQLiveContext;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomGameInfo;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPrepare;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomAttr;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataSet;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataUserInfo;
import com.tencent.mobileqq.qqlive.data.auth.QQLiveRealNameAuthData;
import com.tencent.mobileqq.qqlive.data.login.LoginInfo;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qqlive.room.livelabel.LabelModel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.common.api.IQQLiveReportApi;
import com.tencent.qqlive.common.report.constant.QQLiveQualityReportData;
import com.tencent.qqlive.common.report.constant.QQLiveReportConstants;
import com.tencent.qqmini.minigame.plugins.RaffleJsPlugin;
import com.tencent.timi.game.api.ITimiGameApi;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qg4.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\u0006\u001a\u00020\u0005*\u00020\u0000\u001a\u0014\u0010\n\u001a\u0004\u0018\u00010\t*\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007\u001a\n\u0010\f\u001a\u00020\u000b*\u00020\u0000\u001a\n\u0010\r\u001a\u00020\u0005*\u00020\u0000\u001a\u001a\u0010\u0011\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e\u001a\u0012\u0010\u0013\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u000e\u001a\n\u0010\u0014\u001a\u00020\u0003*\u00020\u0000\u001a\u001a\u0010\u0016\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000e\u001a\f\u0010\u0018\u001a\u0004\u0018\u00010\u0017*\u00020\u0000\u001a\u0012\u0010\u001b\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0019\u001a\n\u0010\u001c\u001a\u00020\u0003*\u00020\u0000\u001a\u0012\u0010\u001e\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0019\u001a\u0012\u0010!\u001a\u00020\u0003*\u00020\u00002\u0006\u0010 \u001a\u00020\u001f\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/prepare/rtmp/QQLiveRtmpPrepareFragment;", "", "f", "", "d", "", "a", "Lcom/tencent/mobileqq/qqlive/data/anchor/sso/QQLiveAnchorDataPrepare;", "data", "Lcom/tencent/mobileqq/qqlive/data/anchor/room/QQLiveAnchorRoomInfo;", "b", "Lcom/tencent/mobileqq/qqlive/data/anchor/sso/QQLiveAnchorDataUserInfo;", "e", "c", "", "retCode", "desc", DomainData.DOMAIN_NAME, "eventId", "o", "i", "msg", tl.h.F, "Lnf4/f;", "g", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "view", "j", "Lcom/tencent/mobileqq/qqlive/data/anchor/sso/QQLiveAnchorDataSet;", "setResult", "k", "qq-live-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class m {
    public static final boolean a(@NotNull QQLiveRtmpPrepareFragment qQLiveRtmpPrepareFragment) {
        Intrinsics.checkNotNullParameter(qQLiveRtmpPrepareFragment, "<this>");
        if (qQLiveRtmpPrepareFragment.ph().getCurRoomInfo() != null) {
            if (qQLiveRtmpPrepareFragment.ph().getCurRoomInfo().roomType == 1) {
                ITimiGameApi iTimiGameApi = (ITimiGameApi) QRoute.api(ITimiGameApi.class);
                Context context = qQLiveRtmpPrepareFragment.getContext();
                if (context == null) {
                    context = BaseApplication.getContext().getApplicationContext();
                }
                Intrinsics.checkNotNullExpressionValue(context, "context\n                \u2026).getApplicationContext()");
                iTimiGameApi.openAnchorRoomPage(context);
            }
            AegisLogger.INSTANCE.i("Open_Live|QQLiveRtmpPrepareFragment", "checkIsLiving", "has anchor room");
            return true;
        }
        if (com.tencent.mobileqq.qqlive.sail.c.f272176a.m().c()) {
            AegisLogger.INSTANCE.i("Open_Live|QQLiveRtmpPrepareFragment", "checkIsLiving", "has audience room");
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x004c, code lost:
    
        if (r4.isGame != false) goto L13;
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final QQLiveAnchorRoomInfo b(@NotNull QQLiveRtmpPrepareFragment qQLiveRtmpPrepareFragment, @NotNull QQLiveAnchorDataPrepare data) {
        IQQLiveAnchorPrepareWrapper Ih;
        Intrinsics.checkNotNullParameter(qQLiveRtmpPrepareFragment, "<this>");
        Intrinsics.checkNotNullParameter(data, "data");
        QQLiveAnchorRoomInfo qQLiveAnchorRoomInfo = null;
        if (qQLiveRtmpPrepareFragment.Ih() != null && (Ih = qQLiveRtmpPrepareFragment.Ih()) != null) {
            qQLiveAnchorRoomInfo = Ih.getRoomInfo();
        }
        QQLiveAnchorRoomInfo qQLiveAnchorRoomInfo2 = new QQLiveAnchorRoomInfo(qQLiveAnchorRoomInfo);
        qQLiveAnchorRoomInfo2.roomAttr = data.roomAttr;
        qQLiveAnchorRoomInfo2.roomData = data.roomInfo;
        qQLiveAnchorRoomInfo2.userDta = e(qQLiveRtmpPrepareFragment);
        com.tencent.mobileqq.qqlive.room.prepare.k Hh = qQLiveRtmpPrepareFragment.Hh();
        int i3 = 0;
        if (Hh != null) {
            if (Hh.Q.getValue() != null) {
                LabelModel value = Hh.Q.getValue();
                Intrinsics.checkNotNull(value);
            }
            i3 = 1;
        }
        qQLiveAnchorRoomInfo2.roomData.liveRoomType = i3;
        com.tencent.mobileqq.qqlive.room.prepare.k Hh2 = qQLiveRtmpPrepareFragment.Hh();
        if (Hh2 != null) {
            QQLiveAnchorDataRoomAttr qQLiveAnchorDataRoomAttr = qQLiveAnchorRoomInfo2.roomAttr;
            Boolean i26 = Hh2.i2();
            Intrinsics.checkNotNullExpressionValue(i26, "it.isGoodsLiveEnable");
            qQLiveAnchorDataRoomAttr.isECGoodsLive = i26.booleanValue();
            qQLiveAnchorRoomInfo2.roomAttr.openTabLevel = Hh2.U1();
        }
        return qQLiveAnchorRoomInfo2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0062, code lost:
    
        if (r0 != false) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean c(@NotNull QQLiveRtmpPrepareFragment qQLiveRtmpPrepareFragment) {
        QQLiveRealNameAuthData qQLiveRealNameAuthData;
        QQLiveRealNameAuthData qQLiveRealNameAuthData2;
        String str;
        LabelModel labelModel;
        String str2;
        boolean z16;
        boolean z17;
        MutableLiveData<com.tencent.mobileqq.qqlive.room.prepare.x> mutableLiveData;
        com.tencent.mobileqq.qqlive.room.prepare.x value;
        MutableLiveData<com.tencent.mobileqq.qqlive.room.prepare.x> mutableLiveData2;
        MutableLiveData<Boolean> mutableLiveData3;
        QQLiveAnchorDataPrepare W1;
        QQLiveAnchorDataRoomAttr qQLiveAnchorDataRoomAttr;
        MutableLiveData<LabelModel> mutableLiveData4;
        QQLiveAnchorDataPrepare W12;
        QQLiveAnchorDataRoomAttr qQLiveAnchorDataRoomAttr2;
        boolean z18;
        String str3;
        String str4;
        Resources resources;
        String string;
        Resources resources2;
        QQLiveRealNameAuthData qQLiveRealNameAuthData3;
        boolean z19;
        String str5;
        String str6;
        Resources resources3;
        String string2;
        Resources resources4;
        boolean z26;
        QQLiveRealNameAuthData qQLiveRealNameAuthData4;
        QQLiveRealNameAuthData qQLiveRealNameAuthData5;
        Intrinsics.checkNotNullParameter(qQLiveRtmpPrepareFragment, "<this>");
        if (!NetworkUtil.isNetworkAvailable()) {
            QQToast.makeText(qQLiveRtmpPrepareFragment.getContext(), "\u7f51\u7edc\u5df2\u65ad\u5f00\uff0c\u8bf7\u8fde\u63a5\u540e\u91cd\u8bd5\u3002", 0).show();
            n(qQLiveRtmpPrepareFragment, "-1", RaffleJsPlugin.ERROR_REPORT_NO_NETWORK);
            return false;
        }
        com.tencent.mobileqq.qqlive.room.prepare.k Hh = qQLiveRtmpPrepareFragment.Hh();
        com.tencent.mobileqq.qqlive.room.prepare.x xVar = null;
        if (Hh != null) {
            qQLiveRealNameAuthData = Hh.C;
        } else {
            qQLiveRealNameAuthData = null;
        }
        if (qQLiveRealNameAuthData != null) {
            com.tencent.mobileqq.qqlive.room.prepare.k Hh2 = qQLiveRtmpPrepareFragment.Hh();
            if (Hh2 != null && (qQLiveRealNameAuthData5 = Hh2.C) != null && qQLiveRealNameAuthData5.getAuthState() == 2) {
                z19 = true;
            } else {
                z19 = false;
            }
            if (!z19) {
                com.tencent.mobileqq.qqlive.room.prepare.k Hh3 = qQLiveRtmpPrepareFragment.Hh();
                if (Hh3 != null && (qQLiveRealNameAuthData4 = Hh3.C) != null && qQLiveRealNameAuthData4.getAuthState() == 0) {
                    z26 = true;
                } else {
                    z26 = false;
                }
            }
            e.Companion companion = qg4.e.INSTANCE;
            FragmentActivity activity = qQLiveRtmpPrepareFragment.getActivity();
            if (activity == null || (resources4 = activity.getResources()) == null || (str5 = resources4.getString(R.string.f210545ie)) == null) {
                str5 = "\u5f53\u524d\u672a\u5b9e\u540d\u8ba4\u8bc1\u65e0\u6cd5\u5f00\u64ad\uff0c\u8bf7\u91cd\u65b0\u8fdb\u5165\uff01";
            }
            String str7 = str5;
            FragmentActivity activity2 = qQLiveRtmpPrepareFragment.getActivity();
            if (activity2 == null || (resources3 = activity2.getResources()) == null || (string2 = resources3.getString(R.string.f169272hw)) == null) {
                str6 = "\u786e\u5b9a";
            } else {
                str6 = string2;
            }
            companion.e(str7, str6, null, "", null);
            n(qQLiveRtmpPrepareFragment, "-1", "auth fail");
            return false;
        }
        com.tencent.mobileqq.qqlive.room.prepare.k Hh4 = qQLiveRtmpPrepareFragment.Hh();
        if (Hh4 != null) {
            qQLiveRealNameAuthData2 = Hh4.C;
        } else {
            qQLiveRealNameAuthData2 = null;
        }
        if (qQLiveRealNameAuthData2 != null) {
            com.tencent.mobileqq.qqlive.room.prepare.k Hh5 = qQLiveRtmpPrepareFragment.Hh();
            if (Hh5 != null && (qQLiveRealNameAuthData3 = Hh5.C) != null && qQLiveRealNameAuthData3.getAuthState() == 3) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (z18) {
                e.Companion companion2 = qg4.e.INSTANCE;
                FragmentActivity activity3 = qQLiveRtmpPrepareFragment.getActivity();
                if (activity3 == null || (resources2 = activity3.getResources()) == null || (str3 = resources2.getString(R.string.f210295hq)) == null) {
                    str3 = "\u672a\u6ee118\u5c81\uff0c\u65e0\u6cd5\u5f00\u64ad";
                }
                String str8 = str3;
                FragmentActivity activity4 = qQLiveRtmpPrepareFragment.getActivity();
                if (activity4 == null || (resources = activity4.getResources()) == null || (string = resources.getString(R.string.f169272hw)) == null) {
                    str4 = "\u786e\u5b9a";
                } else {
                    str4 = string;
                }
                companion2.e(str8, str4, null, "", null);
                n(qQLiveRtmpPrepareFragment, "-1", "auth_under_age");
                return false;
            }
        }
        com.tencent.mobileqq.qqlive.room.prepare.k Hh6 = qQLiveRtmpPrepareFragment.Hh();
        if (Hh6 != null && (W12 = Hh6.W1()) != null && (qQLiveAnchorDataRoomAttr2 = W12.roomAttr) != null) {
            str = qQLiveAnchorDataRoomAttr2.roomName;
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            QQToast.makeText(qQLiveRtmpPrepareFragment.getActivity(), qQLiveRtmpPrepareFragment.getResources().getString(R.string.f210195hg), 1).show();
            n(qQLiveRtmpPrepareFragment, "-1", "the room name is null");
            return false;
        }
        com.tencent.mobileqq.qqlive.room.prepare.k Hh7 = qQLiveRtmpPrepareFragment.Hh();
        if (Hh7 != null && (mutableLiveData4 = Hh7.Q) != null) {
            labelModel = mutableLiveData4.getValue();
        } else {
            labelModel = null;
        }
        if (labelModel == null) {
            QQToast.makeText(qQLiveRtmpPrepareFragment.getContext(), 1, R.string.f210865j_, 1).show();
            n(qQLiveRtmpPrepareFragment, "-1", "mLastSelectLabel == null");
            return false;
        }
        com.tencent.mobileqq.qqlive.room.prepare.k Hh8 = qQLiveRtmpPrepareFragment.Hh();
        if (Hh8 != null && (W1 = Hh8.W1()) != null && (qQLiveAnchorDataRoomAttr = W1.roomAttr) != null) {
            str2 = qQLiveAnchorDataRoomAttr.poster16v9;
        } else {
            str2 = null;
        }
        if (TextUtils.isEmpty(str2)) {
            n(qQLiveRtmpPrepareFragment, "-1", "the room cover is null");
            QQToast.makeText(qQLiveRtmpPrepareFragment.getActivity(), qQLiveRtmpPrepareFragment.getResources().getString(R.string.f210105h8), 1).show();
            return false;
        }
        com.tencent.mobileqq.qqlive.room.prepare.k Hh9 = qQLiveRtmpPrepareFragment.Hh();
        if (Hh9 != null && (mutableLiveData3 = Hh9.H) != null) {
            z16 = Intrinsics.areEqual(mutableLiveData3.getValue(), Boolean.FALSE);
        } else {
            z16 = false;
        }
        if (z16) {
            e.Companion companion3 = qg4.e.INSTANCE;
            String string3 = qQLiveRtmpPrepareFragment.getResources().getString(R.string.f210895jc);
            Intrinsics.checkNotNullExpressionValue(string3, "resources.getString(R.string.qqlive_protocol_tips)");
            String string4 = qQLiveRtmpPrepareFragment.getResources().getString(R.string.f210885jb);
            Intrinsics.checkNotNullExpressionValue(string4, "resources.getString(R.st\u2026.qqlive_protocol_confirm)");
            companion3.e(string3, string4, null, "", null);
            n(qQLiveRtmpPrepareFragment, "-1", "no select Protocol");
            return false;
        }
        if (!com.tencent.mobileqq.qqlive.base.permission.a.c(qQLiveRtmpPrepareFragment.getActivity())) {
            n(qQLiveRtmpPrepareFragment, "-1", "FloatingBallPermission is not enable");
            return false;
        }
        com.tencent.mobileqq.qqlive.room.prepare.k Hh10 = qQLiveRtmpPrepareFragment.Hh();
        if (Hh10 != null && (mutableLiveData2 = Hh10.K) != null) {
            xVar = mutableLiveData2.getValue();
        }
        if (xVar != null) {
            com.tencent.mobileqq.qqlive.room.prepare.k Hh11 = qQLiveRtmpPrepareFragment.Hh();
            if (Hh11 != null && (mutableLiveData = Hh11.K) != null && (value = mutableLiveData.getValue()) != null && !value.f272087c) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                return true;
            }
        }
        e.Companion companion4 = qg4.e.INSTANCE;
        String string5 = qQLiveRtmpPrepareFragment.getResources().getString(R.string.f210145hb);
        Intrinsics.checkNotNullExpressionValue(string5, "resources.getString(R.st\u2026ert_no_third_push_stream)");
        String string6 = qQLiveRtmpPrepareFragment.getResources().getString(R.string.f210885jb);
        Intrinsics.checkNotNullExpressionValue(string6, "resources.getString(R.st\u2026.qqlive_protocol_confirm)");
        companion4.e(string5, string6, null, "", null);
        n(qQLiveRtmpPrepareFragment, "-1", "no_third_push_stream");
        return false;
    }

    public static final void d(@NotNull QQLiveRtmpPrepareFragment qQLiveRtmpPrepareFragment) {
        Intrinsics.checkNotNullParameter(qQLiveRtmpPrepareFragment, "<this>");
        FragmentActivity activity = qQLiveRtmpPrepareFragment.getActivity();
        if (activity != null && !activity.isFinishing()) {
            AegisLogger.INSTANCE.i("Open_Live|QQLiveRtmpPrepareFragment", "finishSelfActivity", "close self page end");
            activity.finish();
        }
    }

    @NotNull
    public static final QQLiveAnchorDataUserInfo e(@NotNull QQLiveRtmpPrepareFragment qQLiveRtmpPrepareFragment) {
        long j3;
        String str;
        String str2;
        IQQLiveModuleLogin loginModule;
        LoginInfo loginInfo;
        IQQLiveModuleLogin loginModule2;
        LoginInfo loginInfo2;
        String str3;
        IQQLiveModuleLogin loginModule3;
        LoginInfo loginInfo3;
        LiveUserInfo liveUserInfo;
        IQQLiveModuleLogin loginModule4;
        LoginInfo loginInfo4;
        LiveUserInfo liveUserInfo2;
        IQQLiveModuleLogin loginModule5;
        LoginInfo loginInfo5;
        Intrinsics.checkNotNullParameter(qQLiveRtmpPrepareFragment, "<this>");
        QQLiveAnchorDataUserInfo qQLiveAnchorDataUserInfo = new QQLiveAnchorDataUserInfo();
        IQQLiveSDK ph5 = qQLiveRtmpPrepareFragment.ph();
        long j16 = 0;
        if (ph5 != null && (loginModule5 = ph5.getLoginModule()) != null && (loginInfo5 = loginModule5.getLoginInfo()) != null) {
            j3 = loginInfo5.uid;
        } else {
            j3 = 0;
        }
        qQLiveAnchorDataUserInfo.f271213id = j3;
        qQLiveAnchorDataUserInfo.explicitId = 0L;
        IQQLiveSDK ph6 = qQLiveRtmpPrepareFragment.ph();
        String str4 = "";
        if (ph6 == null || (loginModule4 = ph6.getLoginModule()) == null || (loginInfo4 = loginModule4.getLoginInfo()) == null || (liveUserInfo2 = loginInfo4.userInfo) == null || (str = liveUserInfo2.nick) == null) {
            str = "";
        }
        qQLiveAnchorDataUserInfo.nickName = str;
        IQQLiveSDK ph7 = qQLiveRtmpPrepareFragment.ph();
        if (ph7 == null || (loginModule3 = ph7.getLoginModule()) == null || (loginInfo3 = loginModule3.getLoginInfo()) == null || (liveUserInfo = loginInfo3.userInfo) == null || (str2 = liveUserInfo.headUrl) == null) {
            str2 = "";
        }
        qQLiveAnchorDataUserInfo.avatarUrl = str2;
        qQLiveAnchorDataUserInfo.initialClientType = QQLiveConfigConst.CLIENT_TYPE;
        IQQLiveSDK ph8 = qQLiveRtmpPrepareFragment.ph();
        if (ph8 != null && (loginModule2 = ph8.getLoginModule()) != null && (loginInfo2 = loginModule2.getLoginInfo()) != null && (str3 = loginInfo2.businessUid) != null) {
            str4 = str3;
        }
        qQLiveAnchorDataUserInfo.businessUid = str4;
        IQQLiveSDK ph9 = qQLiveRtmpPrepareFragment.ph();
        if (ph9 != null && (loginModule = ph9.getLoginModule()) != null && (loginInfo = loginModule.getLoginInfo()) != null) {
            j16 = loginInfo.tinyid;
        }
        qQLiveAnchorDataUserInfo.tinyId = j16;
        return qQLiveAnchorDataUserInfo;
    }

    public static final long f(@NotNull QQLiveRtmpPrepareFragment qQLiveRtmpPrepareFragment) {
        QQLiveAnchorRoomInfo roomInfo;
        Intrinsics.checkNotNullParameter(qQLiveRtmpPrepareFragment, "<this>");
        IQQLiveAnchorPrepareWrapper Ih = qQLiveRtmpPrepareFragment.Ih();
        if (Ih != null && (roomInfo = Ih.getRoomInfo()) != null) {
            return roomInfo.uid;
        }
        return 0L;
    }

    @Nullable
    public static final nf4.f g(@NotNull QQLiveRtmpPrepareFragment qQLiveRtmpPrepareFragment) {
        Intrinsics.checkNotNullParameter(qQLiveRtmpPrepareFragment, "<this>");
        return ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).oneKeyLiveHandler().h();
    }

    public static final void h(@NotNull QQLiveRtmpPrepareFragment qQLiveRtmpPrepareFragment, @NotNull String retCode, @NotNull String msg2) {
        String str;
        Intrinsics.checkNotNullParameter(qQLiveRtmpPrepareFragment, "<this>");
        Intrinsics.checkNotNullParameter(retCode, "retCode");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        IQQLiveReportApi iQQLiveReportApi = (IQQLiveReportApi) QRoute.api(IQQLiveReportApi.class);
        QQLiveQualityReportData.Builder builder = new QQLiveQualityReportData.Builder(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 67108863, null);
        QQLiveContext c16 = QQLiveContext.INSTANCE.c(QQLiveBusinessConfig.QQLIVE_APP_ID);
        if (c16 != null) {
            str = c16.n();
        } else {
            str = null;
        }
        iQQLiveReportApi.qualityReport(builder.traceId(str).eventId(QQLiveReportConstants.Event.E_ANCHOR_RECONNECT_OBS_ROOM).retCode(retCode).desc(msg2).ext6(QQLiveReportConstants.Scene.SCENE_START_RTMP_LIVE).ext7(String.valueOf(System.currentTimeMillis())));
    }

    public static final void i(@NotNull QQLiveRtmpPrepareFragment qQLiveRtmpPrepareFragment) {
        String str;
        Intrinsics.checkNotNullParameter(qQLiveRtmpPrepareFragment, "<this>");
        IQQLiveReportApi iQQLiveReportApi = (IQQLiveReportApi) QRoute.api(IQQLiveReportApi.class);
        QQLiveQualityReportData.Builder builder = new QQLiveQualityReportData.Builder(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 67108863, null);
        QQLiveContext c16 = QQLiveContext.INSTANCE.c(QQLiveBusinessConfig.QQLIVE_APP_ID);
        if (c16 != null) {
            str = c16.n();
        } else {
            str = null;
        }
        iQQLiveReportApi.qualityReport(builder.traceId(str).eventId(QQLiveReportConstants.Event.E_ANCHOR_RECONNECT_OBS_ROOM).retCode("0").ext6(QQLiveReportConstants.Scene.SCENE_START_RTMP_LIVE).ext7(String.valueOf(System.currentTimeMillis())));
    }

    public static final void j(@NotNull QQLiveRtmpPrepareFragment qQLiveRtmpPrepareFragment, @NotNull View view) {
        QQLiveAnchorDataPrepare qQLiveAnchorDataPrepare;
        String str;
        String str2;
        String str3;
        String str4;
        MutableLiveData<Integer> mutableLiveData;
        QQLiveAnchorRoomGameInfo qQLiveAnchorRoomGameInfo;
        LabelModel labelModel;
        MutableLiveData<LabelModel> mutableLiveData2;
        Intrinsics.checkNotNullParameter(qQLiveRtmpPrepareFragment, "<this>");
        Intrinsics.checkNotNullParameter(view, "view");
        com.tencent.mobileqq.qqlive.room.prepare.k Hh = qQLiveRtmpPrepareFragment.Hh();
        Integer num = null;
        if (Hh != null) {
            com.tencent.mobileqq.qqlive.room.prepare.k Hh2 = qQLiveRtmpPrepareFragment.Hh();
            if (Hh2 != null && (mutableLiveData2 = Hh2.Q) != null) {
                labelModel = mutableLiveData2.getValue();
            } else {
                labelModel = null;
            }
            qQLiveAnchorDataPrepare = Hh.X1(2, labelModel);
        } else {
            qQLiveAnchorDataPrepare = null;
        }
        if (qQLiveAnchorDataPrepare != null) {
            HashMap hashMap = new HashMap();
            QQLiveAnchorDataRoomAttr qQLiveAnchorDataRoomAttr = qQLiveAnchorDataPrepare.roomAttr;
            String str5 = "";
            if (qQLiveAnchorDataRoomAttr == null || (qQLiveAnchorRoomGameInfo = qQLiveAnchorDataRoomAttr.gameInfo) == null || (str = Integer.valueOf(qQLiveAnchorRoomGameInfo.f271211id).toString()) == null) {
                str = "";
            }
            hashMap.put("qqlive_zhibo_content", str);
            QQLiveAnchorDataRoomAttr qQLiveAnchorDataRoomAttr2 = qQLiveAnchorDataPrepare.roomAttr;
            if (qQLiveAnchorDataRoomAttr2 != null) {
                str2 = qQLiveAnchorDataRoomAttr2.roomName;
            } else {
                str2 = null;
            }
            if (str2 != null) {
                Intrinsics.checkNotNullExpressionValue(str2, "roomAttr?.roomName ?: \"\"");
                str5 = str2;
            }
            hashMap.put("qqlive_title_content", str5);
            QQLiveAnchorDataRoomAttr qQLiveAnchorDataRoomAttr3 = qQLiveAnchorDataPrepare.roomAttr;
            if (qQLiveAnchorDataRoomAttr3 != null) {
                str3 = qQLiveAnchorDataRoomAttr3.city;
            } else {
                str3 = null;
            }
            if (TextUtils.isEmpty(str3)) {
                str4 = "0";
            } else {
                str4 = "1";
            }
            hashMap.put("qqlive_is_located", str4);
            com.tencent.mobileqq.qqlive.room.prepare.k Hh3 = qQLiveRtmpPrepareFragment.Hh();
            if (Hh3 != null && (mutableLiveData = Hh3.G) != null) {
                num = mutableLiveData.getValue();
            }
            hashMap.put("qqlive_start_type", String.valueOf(num));
            ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil().reportEvent("clck", view, hashMap);
        }
    }

    public static final void k(@NotNull QQLiveRtmpPrepareFragment qQLiveRtmpPrepareFragment, @NotNull QQLiveAnchorDataSet setResult) {
        String str;
        String str2;
        QQLiveAnchorDataPrepare W1;
        QQLiveAnchorDataRoomInfo qQLiveAnchorDataRoomInfo;
        Intrinsics.checkNotNullParameter(qQLiveRtmpPrepareFragment, "<this>");
        Intrinsics.checkNotNullParameter(setResult, "setResult");
        AegisLogger.INSTANCE.i("Open_Live|QQLiveRtmpPrepareFragment", "onPushPullBroadcast_result", "onSet isSuccess:" + setResult.isSuccess);
        Map<String, String> params = com.tencent.mobileqq.qqlive.room.prepare.f.c(qQLiveRtmpPrepareFragment.Hh(), qQLiveRtmpPrepareFragment.ph());
        if (!setResult.isSuccess && setResult.errorMsg != null) {
            Intrinsics.checkNotNullExpressionValue(params, "params");
            params.put("qqlive_fail_reason", setResult.errorMsg.bizErrMsg);
        }
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("dt_pgid", "pg_qqlive_gamelive_start");
        com.tencent.mobileqq.qqlive.room.prepare.k Hh = qQLiveRtmpPrepareFragment.Hh();
        if (Hh != null && (W1 = Hh.W1()) != null && (qQLiveAnchorDataRoomInfo = W1.roomInfo) != null) {
            str = qQLiveAnchorDataRoomInfo.getProgramId();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        params.put("qqlive_program_id", str);
        nf4.d liveReportUtil = ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil();
        if (setResult.isSuccess) {
            str2 = "ev_qqlive_start_success";
        } else {
            str2 = "ev_qqlive_start_failure";
        }
        liveReportUtil.reportEvent(str2, params);
    }

    public static final void l(@NotNull QQLiveRtmpPrepareFragment qQLiveRtmpPrepareFragment, @NotNull View rootView) {
        Intrinsics.checkNotNullParameter(qQLiveRtmpPrepareFragment, "<this>");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil().i(qQLiveRtmpPrepareFragment, rootView, "pg_qqlive_gamelive_start", com.tencent.mobileqq.qqlive.room.prepare.f.c(qQLiveRtmpPrepareFragment.Hh(), qQLiveRtmpPrepareFragment.ph()));
    }

    public static final void m(@NotNull QQLiveRtmpPrepareFragment qQLiveRtmpPrepareFragment) {
        String str;
        String str2;
        QQLiveAnchorDataPrepare qQLiveAnchorDataPrepare;
        QQLiveAnchorDataRoomInfo qQLiveAnchorDataRoomInfo;
        QQLiveAnchorDataPrepare qQLiveAnchorDataPrepare2;
        QQLiveAnchorDataRoomAttr qQLiveAnchorDataRoomAttr;
        Intrinsics.checkNotNullParameter(qQLiveRtmpPrepareFragment, "<this>");
        Bundle bundle = new Bundle();
        bundle.putString("qqlive_zhibo_type", "0");
        bundle.putString("qqlive_anchor_id", String.valueOf(qQLiveRtmpPrepareFragment.ph().getLoginModule().getLoginInfo().uid));
        com.tencent.mobileqq.qqlive.room.prepare.k Hh = qQLiveRtmpPrepareFragment.Hh();
        String str3 = "";
        if (Hh == null || (qQLiveAnchorDataPrepare2 = Hh.f271954i) == null || (qQLiveAnchorDataRoomAttr = qQLiveAnchorDataPrepare2.roomAttr) == null || (str = Long.valueOf(qQLiveAnchorDataRoomAttr.roomId).toString()) == null) {
            str = "";
        }
        bundle.putString("qqlive_room_id", str);
        bundle.putString("qqlive_user_id", String.valueOf(qQLiveRtmpPrepareFragment.ph().getLoginModule().getLoginInfo().uid));
        com.tencent.mobileqq.qqlive.room.prepare.k Hh2 = qQLiveRtmpPrepareFragment.Hh();
        if (Hh2 != null && (qQLiveAnchorDataPrepare = Hh2.f271954i) != null && (qQLiveAnchorDataRoomInfo = qQLiveAnchorDataPrepare.roomInfo) != null) {
            str2 = qQLiveAnchorDataRoomInfo.programId;
        } else {
            str2 = null;
        }
        if (str2 != null) {
            str3 = str2;
        }
        bundle.putString("qqlive_program_id", str3);
        cj4.c.f31003a.c("ACTION_SETUP_LIVE_REPORT_INFO", bundle, null);
    }

    public static final void n(@NotNull QQLiveRtmpPrepareFragment qQLiveRtmpPrepareFragment, @NotNull String retCode, @NotNull String desc) {
        String str;
        Intrinsics.checkNotNullParameter(qQLiveRtmpPrepareFragment, "<this>");
        Intrinsics.checkNotNullParameter(retCode, "retCode");
        Intrinsics.checkNotNullParameter(desc, "desc");
        AegisLogger.INSTANCE.e("Open_Live|QQLiveRtmpPrepareFragment", "startLiveFailReportReason", desc);
        IQQLiveReportApi iQQLiveReportApi = (IQQLiveReportApi) QRoute.api(IQQLiveReportApi.class);
        QQLiveQualityReportData.Builder builder = new QQLiveQualityReportData.Builder(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 67108863, null);
        QQLiveContext c16 = QQLiveContext.INSTANCE.c(QQLiveBusinessConfig.QQLIVE_APP_ID);
        if (c16 != null) {
            str = c16.n();
        } else {
            str = null;
        }
        iQQLiveReportApi.qualityReport(builder.traceId(str).retCode(retCode).desc(desc).eventId(QQLiveReportConstants.Event.E_BEFORE_START_LIVE_FAIL_REASON).ext6(QQLiveReportConstants.Scene.SCENE_START_RTMP_LIVE));
    }

    public static final void o(@NotNull QQLiveRtmpPrepareFragment qQLiveRtmpPrepareFragment, @NotNull String eventId) {
        String str;
        Intrinsics.checkNotNullParameter(qQLiveRtmpPrepareFragment, "<this>");
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        IQQLiveReportApi iQQLiveReportApi = (IQQLiveReportApi) QRoute.api(IQQLiveReportApi.class);
        QQLiveQualityReportData.Builder builder = new QQLiveQualityReportData.Builder(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 67108863, null);
        QQLiveContext c16 = QQLiveContext.INSTANCE.c(QQLiveBusinessConfig.QQLIVE_APP_ID);
        if (c16 != null) {
            str = c16.n();
        } else {
            str = null;
        }
        iQQLiveReportApi.qualityReport(builder.traceId(str).eventId(eventId).ext6(QQLiveReportConstants.Scene.SCENE_START_RTMP_LIVE).ext7(String.valueOf(System.currentTimeMillis())));
    }
}
