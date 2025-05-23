package dq2;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.adapter.ForwardRecentItemView;
import com.tencent.mobileqq.adapter.ForwardRecentRoundItemView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.filemanager.fileassistant.util.h;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectfriend.api.ISelectNtSaveRecentUserApi;
import com.tencent.mobileqq.selectfriend.model.FSForwardData;
import com.tencent.mobileqq.selectfriend.model.FSLayoutData;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import mqq.app.api.IRuntimeService;
import mqq.manager.Manager;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b?\u0018\u0000 \u0084\u00012\u00020\u0001:\u0002\u0085\u0001B\t\u00a2\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001c\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J \u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\fH\u0002J\u0012\u0010\u001e\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u0014H\u0002J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0014H\u0002J\u0018\u0010 \u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\fH\u0002J \u0010#\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020!2\u0006\u0010\u001b\u001a\u00020\fH\u0002J\u0006\u0010$\u001a\u00020\fJ\b\u0010%\u001a\u0004\u0018\u00010\u000fJ\b\u0010&\u001a\u00020\u000fH\u0016J\u001a\u0010'\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0006\u0010(\u001a\u00020\u0011J\u0006\u0010)\u001a\u00020\u0011J\"\u0010,\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00170*j\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0017`+J\u0016\u0010.\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020\u0011J\u000e\u0010/\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017J\u0006\u00100\u001a\u00020\u0011J\u0006\u00101\u001a\u00020\fJN\u0010>\u001a\u00020\u00042\b\u00103\u001a\u0004\u0018\u0001022\u0016\u00107\u001a\u0012\u0012\u0004\u0012\u00020504j\b\u0012\u0004\u0012\u000205`62\b\u00109\u001a\u0004\u0018\u0001082\u0010\u0010;\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010:2\b\u0010=\u001a\u0004\u0018\u00010<J!\u0010@\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u00142\b\u0010?\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b@\u0010AJ\u0010\u0010C\u001a\u00020\f2\b\u0010B\u001a\u0004\u0018\u00010\u0017J\u0016\u0010D\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020\u0011J\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\f0EJ\u0012\u0010H\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170G0EJ\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00170EJ\f\u0010J\u001a\b\u0012\u0004\u0012\u00020\f0EJ\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00140EJ\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u000f0EJ\f\u0010M\u001a\b\u0012\u0004\u0012\u00020\f0EJ\f\u0010N\u001a\b\u0012\u0004\u0012\u00020\f0EJ\u0010\u0010O\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010:R3\u0010T\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00170*j\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0017`+8\u0006\u00a2\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010SR\u0016\u0010W\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u001c\u0010Z\u001a\b\u0012\u0004\u0012\u00020\f0E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010YR\"\u0010\\\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170G0E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010YR\u001c\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00170E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010YR\u001c\u0010`\u001a\b\u0012\u0004\u0012\u00020\u00140E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010YR\u001c\u0010b\u001a\b\u0012\u0004\u0012\u00020\u000f0E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010YR\u001c\u0010d\u001a\b\u0012\u0004\u0012\u00020\f0E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010YR\u001c\u0010e\u001a\b\u0012\u0004\u0012\u00020\f0E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010YR\u001c\u0010g\u001a\b\u0012\u0004\u0012\u00020\f0E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bf\u0010YR \u0010j\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bh\u0010iR\u0018\u0010m\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010lR\u0018\u0010p\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bn\u0010oR\u0016\u0010s\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bq\u0010rR\u0018\u0010v\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bt\u0010uR\u0018\u0010x\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bw\u0010uR\u0018\u0010{\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\by\u0010zR\u0016\u0010}\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b|\u0010rR\u0016\u0010\u007f\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b~\u0010VR\u0018\u0010\u0081\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0080\u0001\u0010r\u00a8\u0006\u0086\u0001"}, d2 = {"Ldq2/a;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "Landroid/os/Bundle;", "bundle", "", "t2", ICustomDataEditor.NUMBER_PARAM_2, "Landroid/content/Intent;", "intent", "o2", "r2", "q2", "", "i2", ICustomDataEditor.STRING_PARAM_2, "", "uin", "", "type", "Q1", "Landroid/view/View;", "itemView", "m2", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "resultRecord", "Lcom/tencent/mobileqq/adapter/ForwardRecentItemView;", "forwardRecentItemView", "isForwardSelected", "x2", "v", "l2", "j2", "y2", "Lcom/tencent/mobileqq/adapter/ForwardRecentRoundItemView;", "forwardRecentRoundItemView", "w2", ICustomDataEditor.STRING_ARRAY_PARAM_2, "O1", "getLogTag", "p2", "b2", "f2", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "R1", "uinType", SemanticAttributes.DbSystemValues.H2, "u2", "P1", "T1", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/data/RecentUser;", "Lkotlin/collections/ArrayList;", "recentList", "Lcom/tencent/mobileqq/selectfriend/model/FSLayoutData;", "fsLayoutData", "Lcom/tencent/mobileqq/selectfriend/model/FSForwardData;", "fsForwardData", "Lcom/tencent/mobileqq/selectfriend/processor/d;", "forwardBaseProcessor", "M1", "isMulti", "k2", "(Landroid/view/View;Ljava/lang/Boolean;)V", "info", "L1", "v2", "Landroidx/lifecycle/MutableLiveData;", "e2", "", "X1", "N1", "g2", "W1", "Z1", "c2", "d2", "S1", "i", "Ljava/util/LinkedHashMap;", "U1", "()Ljava/util/LinkedHashMap;", "mForwardTargetMap", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "mCurrentStatus", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "mSyncRecentChatClickedLiveData", "D", "mRemoveFromForwardTargetListLiveData", "E", "mAdd2ForwardTargetListLiveData", UserInfo.SEX_FEMALE, "mOpenForwardDialogLiveData", "G", "mReportDataForBusinessLiveData", "H", "mShowConfirmDialogLiveData", "mUpdateResultRecordsLiveData", "J", "mShowForwardCountLimitDialogLiveData", "K", "Lcom/tencent/mobileqq/selectfriend/model/FSForwardData;", "mFsForwardData", "L", "Lcom/tencent/mobileqq/selectfriend/model/FSLayoutData;", "mFsLayoutData", "M", "Landroid/os/Bundle;", "mExtraData", "N", "Z", "mIsFromShare", "P", "Ljava/lang/String;", "fromPkgName", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "mAppid", BdhLogUtil.LogTag.Tag_Req, "Ljava/lang/Boolean;", "mIsFromZplan", ExifInterface.LATITUDE_SOUTH, "mIsShowGuildEntrance", "T", "mUinType", "U", "mIsSdkShare", "<init>", "()V", "V", "a", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a extends BaseViewModel {

    /* renamed from: K, reason: from kotlin metadata */
    private FSForwardData<Bundle> mFsForwardData;

    /* renamed from: L, reason: from kotlin metadata */
    private FSLayoutData mFsLayoutData;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean mIsFromShare;

    /* renamed from: P, reason: from kotlin metadata */
    private String fromPkgName;

    /* renamed from: S, reason: from kotlin metadata */
    private boolean mIsShowGuildEntrance;

    /* renamed from: T, reason: from kotlin metadata */
    private int mUinType;

    /* renamed from: U, reason: from kotlin metadata */
    private boolean mIsSdkShare;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mCurrentStatus;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final LinkedHashMap<String, ResultRecord> mForwardTargetMap = new LinkedHashMap<>();

    /* renamed from: C, reason: from kotlin metadata */
    private MutableLiveData<Boolean> mSyncRecentChatClickedLiveData = new MutableLiveData<>();

    /* renamed from: D, reason: from kotlin metadata */
    private MutableLiveData<List<ResultRecord>> mRemoveFromForwardTargetListLiveData = new MutableLiveData<>();

    /* renamed from: E, reason: from kotlin metadata */
    private MutableLiveData<ResultRecord> mAdd2ForwardTargetListLiveData = new MutableLiveData<>();

    /* renamed from: F, reason: from kotlin metadata */
    private MutableLiveData<View> mOpenForwardDialogLiveData = new MutableLiveData<>();

    /* renamed from: G, reason: from kotlin metadata */
    private MutableLiveData<String> mReportDataForBusinessLiveData = new MutableLiveData<>();

    /* renamed from: H, reason: from kotlin metadata */
    private MutableLiveData<Boolean> mShowConfirmDialogLiveData = new MutableLiveData<>();

    /* renamed from: I, reason: from kotlin metadata */
    private MutableLiveData<Boolean> mUpdateResultRecordsLiveData = new MutableLiveData<>();

    /* renamed from: J, reason: from kotlin metadata */
    private MutableLiveData<Boolean> mShowForwardCountLimitDialogLiveData = new MutableLiveData<>();

    /* renamed from: M, reason: from kotlin metadata */
    private Bundle mExtraData = new Bundle();

    /* renamed from: Q, reason: from kotlin metadata */
    private String mAppid = "";

    /* renamed from: R, reason: from kotlin metadata */
    private Boolean mIsFromZplan = Boolean.FALSE;

    private final String Q1(String uin, int type) {
        return type + util.base64_pad_url + uin;
    }

    private final boolean i2() {
        return (TextUtils.isEmpty(this.fromPkgName) || Intrinsics.areEqual(this.fromPkgName, "com.tencent.mobileqq")) ? false : true;
    }

    private final void j2(View v3) {
        Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.mobileqq.adapter.ForwardRecentRoundItemView");
        ForwardRecentRoundItemView forwardRecentRoundItemView = (ForwardRecentRoundItemView) v3;
        ResultRecord resultRecord = forwardRecentRoundItemView.F;
        if (resultRecord == null) {
            return;
        }
        String str = resultRecord.uin;
        Intrinsics.checkNotNullExpressionValue(str, "resultRecord.uin");
        boolean h26 = h2(str, resultRecord.getUinType());
        if (!h.k(resultRecord.uin)) {
            w2(resultRecord, forwardRecentRoundItemView, h26);
        }
        y2(resultRecord, h26);
    }

    private final void l2(View v3) {
        ResultRecord resultRecord;
        this.mReportDataForBusinessLiveData.postValue("0X8007827");
        if (v3 instanceof ForwardRecentItemView) {
            resultRecord = ((ForwardRecentItemView) v3).J;
        } else {
            resultRecord = v3 instanceof ForwardRecentRoundItemView ? ((ForwardRecentRoundItemView) v3).F : null;
        }
        if (resultRecord == null) {
            QLog.e("ForwardFriend.SelectFriendHomeViewModel", 1, "onListViewItemClickedInDefaultStatus fail, resultRecord is null");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ForwardFriend.SelectFriendHomeViewModel", 2, "[FORWARD_SHOW_DIALOG]invoke openForwardDialog uin=" + com.tencent.mobileqq.qcall.g.b(resultRecord.uin));
        }
        this.mOpenForwardDialogLiveData.postValue(v3);
    }

    private final void m2(View itemView) {
        Intrinsics.checkNotNull(itemView, "null cannot be cast to non-null type com.tencent.mobileqq.adapter.ForwardRecentItemView");
        ForwardRecentItemView forwardRecentItemView = (ForwardRecentItemView) itemView;
        ResultRecord resultRecord = forwardRecentItemView.J;
        if (resultRecord == null) {
            return;
        }
        String str = resultRecord.uin;
        Intrinsics.checkNotNullExpressionValue(str, "resultRecord.uin");
        boolean h26 = h2(str, resultRecord.getUinType());
        if (!h.k(resultRecord.uin)) {
            x2(resultRecord, forwardRecentItemView, h26);
        }
        y2(resultRecord, h26);
    }

    private final void s2(Bundle bundle) {
        boolean z16 = false;
        if (bundle != null && bundle.containsKey("isShareSdk")) {
            this.mIsSdkShare = false;
            if (bundle != null) {
                this.mIsSdkShare = bundle.getBoolean("isShareSdk");
                return;
            }
            return;
        }
        if (bundle != null && bundle.getInt("forward_type", -1) == com.tencent.mobileqq.selectfriend.forward.a.INSTANCE.a()) {
            z16 = true;
        }
        if (z16) {
            this.mIsSdkShare = true;
        }
        if (bundle != null) {
            bundle.putBoolean("isShareSdk", this.mIsSdkShare);
        }
    }

    private final void w2(ResultRecord resultRecord, ForwardRecentRoundItemView forwardRecentRoundItemView, boolean isForwardSelected) {
        if (QLog.isColorLevel()) {
            QLog.d("ForwardFriend.SelectFriendHomeViewModel", 2, "onForwardRecentRoundItemViewClickedInMultiSelectStatus, isSelected = " + isForwardSelected);
        }
        if (isForwardSelected) {
            forwardRecentRoundItemView.d(false);
            String str = resultRecord.uin;
            Intrinsics.checkNotNullExpressionValue(str, "resultRecord.uin");
            v2(str, resultRecord.getUinType());
            return;
        }
        if (L1(resultRecord)) {
            forwardRecentRoundItemView.d(true);
        }
    }

    private final void x2(ResultRecord resultRecord, ForwardRecentItemView forwardRecentItemView, boolean isForwardSelected) {
        if (QLog.isColorLevel()) {
            QLog.d("ForwardFriend.SelectFriendHomeViewModel", 2, "onListViewItemClickedInMultiSelectStatus, isSelected = " + isForwardSelected);
        }
        if (isForwardSelected) {
            forwardRecentItemView.e(false);
            String str = resultRecord.uin;
            Intrinsics.checkNotNullExpressionValue(str, "resultRecord.uin");
            v2(str, resultRecord.getUinType());
            return;
        }
        if (L1(resultRecord)) {
            forwardRecentItemView.e(true);
        }
    }

    public final void M1(QQAppInterface app, ArrayList<RecentUser> recentList, FSLayoutData fsLayoutData, FSForwardData<Bundle> fsForwardData, com.tencent.mobileqq.selectfriend.processor.d forwardBaseProcessor) {
        Set set;
        Intrinsics.checkNotNullParameter(recentList, "recentList");
        ArrayList arrayList = new ArrayList();
        Iterator<RecentUser> it = recentList.iterator();
        while (it.hasNext()) {
            RecentUser recentList2 = it.next();
            Intrinsics.checkNotNullExpressionValue(recentList2, "recentList");
            RecentUser recentUser = recentList2;
            if (recentUser.lFlag == 16 || recentUser.getType() == 10005) {
                arrayList.add(recentUser);
            }
            if (recentUser.getType() == 1038) {
                arrayList.add(recentUser);
            }
            if (TextUtils.equals(recentUser.uin, "256111111111111111") || TextUtils.equals(recentUser.uin, "1111111111111111FFFFFFFFFFFFFFFF")) {
                arrayList.add(recentUser);
            }
            if (TextUtils.equals(recentUser.uin, "256111111111111112")) {
                arrayList.add(recentUser);
            }
            if (recentUser.getType() == 1046) {
                arrayList.add(recentUser);
            }
            if (recentUser.getType() == 10019) {
                arrayList.add(recentUser);
            }
            if ((fsForwardData != null ? fsForwardData.b() : null) != null) {
                Bundle b16 = fsForwardData != null ? fsForwardData.b() : null;
                Intrinsics.checkNotNull(b16);
                if (b16.getBoolean("choose_friend_isForConfess")) {
                    String str = recentUser.uin;
                    Intrinsics.checkNotNull(app);
                    if (TextUtils.equals(str, app.getCurrentAccountUin())) {
                        arrayList.add(recentUser);
                    }
                }
            }
            if (TextUtils.equals(recentUser.uin, h.g(app))) {
                arrayList.add(recentUser);
            }
            if (TextUtils.equals(AppConstants.CONVERSATION_MAY_KNOW_FRIEND_UIN, recentUser.uin) || recentUser.getType() == 8111 || recentUser.getType() == 8112 || recentUser.getType() == 8113 || recentUser.getType() == 10007 || recentUser.getType() == 10015) {
                arrayList.add(recentUser);
            }
            if (recentUser.getType() == 10014) {
                if ((fsForwardData != null ? fsForwardData.b() : null) != null) {
                    Intrinsics.checkNotNull(fsForwardData);
                    Bundle b17 = fsForwardData.b();
                    Intrinsics.checkNotNull(b17);
                    if (!b17.getBoolean("should_show_guild", false)) {
                        arrayList.add(recentUser);
                    }
                }
                Intrinsics.checkNotNull(app);
                IRuntimeService runtimeService = app.getRuntimeService(IGPSService.class, "");
                Intrinsics.checkNotNullExpressionValue(runtimeService, "app!!.getRuntimeService(\u2026va, ProcessConstant.MAIN)");
                IGPSService iGPSService = (IGPSService) runtimeService;
                IGProChannelInfo channelInfo = iGPSService.getChannelInfo(recentUser.uin);
                if (TextUtils.isEmpty(recentUser.troopUin) && channelInfo != null) {
                    QLog.w("ForwardFriend.SelectFriendHomeViewModel", 1, "filterRecentList guild troopUin isEmpty");
                    recentUser.troopUin = channelInfo.getGuildId();
                }
                if (iGPSService.getGuildInfo(recentUser.troopUin) == null || channelInfo == null || channelInfo.getType() != 1) {
                    arrayList.add(recentUser);
                }
            }
            if (recentUser.getType() == 1) {
                Manager manager = app != null ? app.getManager(QQManagerFactory.TROOP_MANAGER) : null;
                Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.app.TroopManager");
                if (((TroopManager) manager).k(recentUser.uin) == null) {
                    if (QLog.isColorLevel()) {
                        QLog.i("ForwardFriend.SelectFriendHomeViewModel", 2, "refreshRecentList, filter troop, recentUser.troopUin =" + recentUser.troopUin + ",recentUser.uin = " + recentUser.uin);
                    }
                    arrayList.add(recentUser);
                }
            }
            if (recentUser.getType() == 0 && app != null) {
                String uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(recentUser.uin);
                IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
                Intrinsics.checkNotNullExpressionValue(uid, "uid");
                if (!iFriendsInfoService.isFriend(uid, "ForwardFriend.SelectFriendHomeViewModel")) {
                    if (QLog.isColorLevel()) {
                        QLog.i("ForwardFriend.SelectFriendHomeViewModel", 2, "refreshRecentList, filter deleted friend, uin = " + recentUser.uin);
                    }
                    arrayList.add(recentUser);
                }
            }
            if (!((ISelectNtSaveRecentUserApi) QRoute.api(ISelectNtSaveRecentUserApi.class)).shouldAddToList(recentUser, true)) {
                arrayList.add(recentUser);
            }
            if (!((ISelectNtSaveRecentUserApi) QRoute.api(ISelectNtSaveRecentUserApi.class)).shouldAddToList(recentUser, true)) {
                arrayList.add(recentUser);
            }
            if (forwardBaseProcessor != null && !forwardBaseProcessor.e(recentUser)) {
                arrayList.add(recentUser);
            }
            if (fsLayoutData == null) {
                return;
            }
            ArrayList<Integer> a16 = fsLayoutData.a();
            Intrinsics.checkNotNull(a16);
            if (a16.contains(Integer.valueOf(recentUser.getType()))) {
                arrayList.add(recentUser);
            }
            ArrayList<String> b18 = fsLayoutData.b();
            Intrinsics.checkNotNull(b18);
            if (b18.contains(recentUser.uin)) {
                arrayList.add(recentUser);
            }
        }
        set = CollectionsKt___CollectionsKt.toSet(arrayList);
        recentList.removeAll(set);
    }

    public final MutableLiveData<ResultRecord> N1() {
        return this.mAdd2ForwardTargetListLiveData;
    }

    /* renamed from: O1, reason: from getter */
    public final String getMAppid() {
        return this.mAppid;
    }

    /* renamed from: P1, reason: from getter */
    public final int getMCurrentStatus() {
        return this.mCurrentStatus;
    }

    public final LinkedHashMap<String, ResultRecord> R1() {
        return this.mForwardTargetMap;
    }

    public final FSForwardData<Bundle> S1() {
        return this.mFsForwardData;
    }

    /* renamed from: T1, reason: from getter */
    public final boolean getMIsShowGuildEntrance() {
        return this.mIsShowGuildEntrance;
    }

    public final LinkedHashMap<String, ResultRecord> U1() {
        return this.mForwardTargetMap;
    }

    public final MutableLiveData<View> W1() {
        return this.mOpenForwardDialogLiveData;
    }

    public final MutableLiveData<List<ResultRecord>> X1() {
        return this.mRemoveFromForwardTargetListLiveData;
    }

    public final MutableLiveData<String> Z1() {
        return this.mReportDataForBusinessLiveData;
    }

    /* renamed from: a2, reason: from getter */
    public final boolean getMIsSdkShare() {
        return this.mIsSdkShare;
    }

    public final int b2() {
        return -1;
    }

    public final MutableLiveData<Boolean> c2() {
        return this.mShowConfirmDialogLiveData;
    }

    public final MutableLiveData<Boolean> d2() {
        return this.mShowForwardCountLimitDialogLiveData;
    }

    public final MutableLiveData<Boolean> e2() {
        return this.mSyncRecentChatClickedLiveData;
    }

    /* renamed from: f2, reason: from getter */
    public final int getMUinType() {
        return this.mUinType;
    }

    public final MutableLiveData<Boolean> g2() {
        return this.mUpdateResultRecordsLiveData;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "ForwardFriend.SelectFriendHomeViewModel";
    }

    public final boolean h2(String uin, int uinType) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        if (TextUtils.isEmpty(uin)) {
            return false;
        }
        return this.mForwardTargetMap.containsKey(Q1(uin, uinType));
    }

    public final void k2(View v3, Boolean isMulti) {
        if (QLog.isColorLevel()) {
            QLog.d("ForwardFriend.SelectFriendHomeViewModel", 2, "onItemViewClicked " + isMulti);
        }
        if (Intrinsics.areEqual(isMulti, Boolean.TRUE)) {
            ForwardRecentItemView forwardRecentItemView = v3 instanceof ForwardRecentItemView ? (ForwardRecentItemView) v3 : null;
            if (forwardRecentItemView != null) {
                m2(forwardRecentItemView);
                return;
            }
            ForwardRecentRoundItemView forwardRecentRoundItemView = v3 instanceof ForwardRecentRoundItemView ? (ForwardRecentRoundItemView) v3 : null;
            if (forwardRecentRoundItemView != null) {
                j2(forwardRecentRoundItemView);
                return;
            }
            return;
        }
        l2(v3);
    }

    public final void p2(Bundle bundle, Intent intent) {
        o2(bundle, intent);
        s2(bundle);
        q2(bundle);
        r2(bundle);
        n2(bundle);
        t2(bundle);
    }

    public final void u2(ResultRecord resultRecord) {
        Intrinsics.checkNotNullParameter(resultRecord, "resultRecord");
        String str = resultRecord.uin;
        Intrinsics.checkNotNullExpressionValue(str, "resultRecord.uin");
        String Q1 = Q1(str, resultRecord.uinType);
        if (TextUtils.isEmpty(Q1)) {
            return;
        }
        LinkedHashMap<String, ResultRecord> linkedHashMap = this.mForwardTargetMap;
        Intrinsics.checkNotNull(Q1);
        linkedHashMap.put(Q1, resultRecord);
    }

    public final void v2(String uin, int uinType) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        if (TextUtils.isEmpty(uin)) {
            return;
        }
        TypeIntrinsics.asMutableMap(this.mForwardTargetMap).remove(Q1(uin, uinType));
        this.mRemoveFromForwardTargetListLiveData.postValue(new ArrayList(this.mForwardTargetMap.values()));
    }

    private final void y2(ResultRecord resultRecord, boolean isForwardSelected) {
        if (isForwardSelected || this.mForwardTargetMap.size() != 9) {
            this.mSyncRecentChatClickedLiveData.postValue(Boolean.TRUE);
        }
    }

    private final void o2(Bundle bundle, Intent intent) {
        Bundle bundle2;
        Object obj = bundle != null ? bundle.get("fs_forward_data_obj") : null;
        this.mFsForwardData = obj instanceof FSForwardData ? (FSForwardData) obj : null;
        Object obj2 = bundle != null ? bundle.get("fs_forward_layout_obj") : null;
        this.mFsLayoutData = obj2 instanceof FSLayoutData ? (FSLayoutData) obj2 : null;
        FSForwardData<Bundle> fSForwardData = this.mFsForwardData;
        if (fSForwardData == null || (bundle2 = fSForwardData.b()) == null) {
            bundle2 = new Bundle();
        }
        this.mExtraData = bundle2;
        if (intent != null) {
            this.mIsShowGuildEntrance = ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).checkShowShareGuildEntrance(intent);
        }
    }

    private final void q2(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        this.mIsFromShare = bundle.getBoolean("isFromShare");
        long j3 = bundle.getLong("req_share_id", 0L);
        this.fromPkgName = bundle.getString("pkg_name");
        if (this.mIsFromShare) {
            return;
        }
        if (j3 > 0 || this.mIsSdkShare || i2()) {
            this.mIsFromShare = true;
        }
    }

    private final void r2(Bundle bundle) {
        Bundle bundle2;
        if (bundle == null || (bundle2 = this.mExtraData) == null) {
            return;
        }
        bundle2.putInt("key_chat_list_head_style", 2);
    }

    private final void t2(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        this.mUinType = 0;
        this.mUinType = bundle.getInt(AppConstants.Key.FORWARD_SOURCE_UIN_TYPE, 0);
    }

    public final boolean L1(ResultRecord info) {
        if (info == null) {
            return false;
        }
        String str = info.uin;
        Intrinsics.checkNotNullExpressionValue(str, "info.uin");
        ResultRecord resultRecord = this.mForwardTargetMap.get(Q1(str, info.getUinType()));
        if (resultRecord != null) {
            resultRecord.lastChooseTime = SystemClock.elapsedRealtime();
            this.mUpdateResultRecordsLiveData.postValue(Boolean.FALSE);
            return false;
        }
        if (this.mForwardTargetMap.size() == 9) {
            MutableLiveData<Boolean> mutableLiveData = this.mShowForwardCountLimitDialogLiveData;
            if (mutableLiveData == null) {
                return false;
            }
            mutableLiveData.postValue(Boolean.TRUE);
            return false;
        }
        this.mAdd2ForwardTargetListLiveData.postValue(info);
        return true;
    }

    private final void n2(Bundle bundle) {
        Long valueOf = bundle != null ? Long.valueOf(bundle.getLong("req_share_id", 0L)) : null;
        if (valueOf != null && valueOf.longValue() > 0) {
            this.mAppid = valueOf.toString();
        }
        Boolean valueOf2 = bundle != null ? Boolean.valueOf(bundle.getBoolean(ForwardRecentActivity.KEY_FORWARD_SHARE_FROM_ZPLAN, false)) : null;
        this.mIsFromZplan = valueOf2;
        if (valueOf2 != null) {
            Intrinsics.checkNotNull(valueOf2, "null cannot be cast to non-null type kotlin.Boolean");
            if (valueOf2.booleanValue()) {
                this.mAppid = bundle != null ? bundle.getString(ForwardRecentActivity.KEY_FORWARD_SHARE_FROM_ZPLAN_APPID) : null;
            }
        }
        QLog.i("ForwardFriend.SelectFriendHomeViewModel", 1, "mAppid =" + this.mAppid);
    }
}
