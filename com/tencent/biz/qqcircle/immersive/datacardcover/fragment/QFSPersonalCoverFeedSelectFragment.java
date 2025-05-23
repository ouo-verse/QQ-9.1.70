package com.tencent.biz.qqcircle.immersive.datacardcover.fragment;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.QFSBaseFragment;
import com.tencent.biz.qqcircle.immersive.datacardcover.part.QFSPersonalCoverUploadPart;
import com.tencent.biz.qqcircle.immersive.datacardcover.part.h;
import com.tencent.biz.qqcircle.immersive.datacardcover.part.j;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import feedcloud.FeedCloudRead$SingleProfileCardInfo;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0014J\u0014\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00100\u000fH\u0014J\b\u0010\u0013\u001a\u00020\u0012H\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/datacardcover/fragment/QFSPersonalCoverFeedSelectFragment;", "Lcom/tencent/biz/qqcircle/immersive/QFSBaseFragment;", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "initBean", "Lfeedcloud/FeedCloudRead$SingleProfileCardInfo;", "rh", "", "getContentLayoutId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "getLogTag", "getPageId", "getDaTongPageId", "", "", "getChildDaTongPageParams", "", "isUseDarkTextStatusBar", "<init>", "()V", "E", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSPersonalCoverFeedSelectFragment extends QFSBaseFragment {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0011\u0010\b\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/datacardcover/fragment/QFSPersonalCoverFeedSelectFragment$a;", "", "", "profileType", "", "b", "a", "()Ljava/lang/String;", "PROFILE_SCHEMA", "FRIEND_PROFILE", "Ljava/lang/String;", "MY_PROFILE", "TAG", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qqcircle.immersive.datacardcover.fragment.QFSPersonalCoverFeedSelectFragment$a, reason: from kotlin metadata */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String a() {
            return "mqq://card/show_pslcard?src_type=internal&version=1&card_type=person&uin=" + QCircleCommonUtil.getCurrentAccount();
        }

        public final boolean b(@NotNull String profileType) {
            Intrinsics.checkNotNullParameter(profileType, "profileType");
            return Intrinsics.areEqual("0", profileType);
        }

        Companion() {
        }
    }

    private final FeedCloudRead$SingleProfileCardInfo rh(QCircleInitBean initBean) {
        boolean z16;
        byte[] busiInfoData = initBean.getBusiInfoData();
        boolean z17 = false;
        if (busiInfoData != null) {
            if (busiInfoData.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                z17 = true;
            }
        }
        if (z17) {
            try {
                byte[] busiInfoData2 = initBean.getBusiInfoData();
                if (busiInfoData2 == null) {
                    return null;
                }
                FeedCloudRead$SingleProfileCardInfo feedCloudRead$SingleProfileCardInfo = new FeedCloudRead$SingleProfileCardInfo();
                feedCloudRead$SingleProfileCardInfo.mergeFrom(busiInfoData2);
                feedCloudRead$SingleProfileCardInfo.setHasFlag(true);
                return feedCloudRead$SingleProfileCardInfo;
            } catch (Exception e16) {
                QLog.e(getTAG(), 1, "[parseProfileCardInfo] e:" + e16);
            }
        }
        return null;
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        QFSPersonalCoverUploadPart qFSPersonalCoverUploadPart = new QFSPersonalCoverUploadPart();
        qFSPersonalCoverUploadPart.setReportBean(getReportBean());
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new h(), new j(R.drawable.orv, R.color.f158017al3, R.string.f189413zb), qFSPersonalCoverUploadPart);
        return mutableListOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    @NotNull
    public Map<String, Object> getChildDaTongPageParams() {
        Serializable serializable;
        Intent intent;
        HashMap hashMap = new HashMap();
        FragmentActivity activity = getActivity();
        QCircleInitBean qCircleInitBean = null;
        if (activity != null && (intent = activity.getIntent()) != null) {
            serializable = intent.getSerializableExtra("key_bundle_common_init_bean");
        } else {
            serializable = null;
        }
        if (serializable instanceof QCircleInitBean) {
            qCircleInitBean = (QCircleInitBean) serializable;
        }
        if (qCircleInitBean != null) {
            String launchFrom = qCircleInitBean.getLaunchFrom();
            Intrinsics.checkNotNullExpressionValue(launchFrom, "it.launchFrom");
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_FROM, launchFrom);
            FeedCloudRead$SingleProfileCardInfo rh5 = rh(qCircleInitBean);
            if (rh5 != null) {
                hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_CARD_TYPE, Integer.valueOf(rh5.card_cover_type.get()));
            } else {
                hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_CARD_TYPE, 0);
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.gks;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    @NotNull
    public String getDaTongPageId() {
        return QCircleDaTongConstant.PageId.PG_XSJ_ADJUST_PAGE;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSPersonalCoverFeedSelectFragment";
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean isUseDarkTextStatusBar() {
        return false;
    }
}
