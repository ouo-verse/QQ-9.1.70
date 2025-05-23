package com.qzone.reborn.albumx.qzonex.fragment;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.albumx.qzone.part.QZoneAlbumxLocalPhotoRecommendFeedListPart;
import com.qzone.reborn.albumx.qzone.part.QZoneAlbumxLocalPhotoRecommendOperatePart;
import com.qzone.reborn.albumx.qzonex.part.recommendtab.QZAlbumTabRecommendTitlePart;
import com.qzone.reborn.base.QZoneBaseFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import cooperation.qzone.api.QZoneContant;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 $2\u00020\u0001:\u0001%B\u0007\u00a2\u0006\u0004\b\"\u0010#J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0014J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0014J\u0014\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00110\u0010H\u0014J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001b\u0010!\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \u00a8\u0006&"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/fragment/QZAlbumxTabRecommendFragment;", "Lcom/qzone/reborn/base/QZoneBaseFragment;", "", "isSelected", "", "rh", "", "getLogTag", "", "getContentLayoutId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "getDaTongPageId", "", "", "getChildDaTongPageParams", "isVisibleToUser", "setUserVisibleHint", "Lcom/qzone/reborn/albumx/qzone/part/QZoneAlbumxLocalPhotoRecommendFeedListPart;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/albumx/qzone/part/QZoneAlbumxLocalPhotoRecommendFeedListPart;", "photoRecommendFeedListPart", "Lcom/qzone/reborn/albumx/qzone/part/QZoneAlbumxLocalPhotoRecommendOperatePart;", "D", "Lcom/qzone/reborn/albumx/qzone/part/QZoneAlbumxLocalPhotoRecommendOperatePart;", "photoRecommendOperatePart", "E", "Lkotlin/Lazy;", "qh", "()Z", "standaloneMode", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZAlbumxTabRecommendFragment extends QZoneBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private QZoneAlbumxLocalPhotoRecommendFeedListPart photoRecommendFeedListPart;

    /* renamed from: D, reason: from kotlin metadata */
    private QZoneAlbumxLocalPhotoRecommendOperatePart photoRecommendOperatePart;

    /* renamed from: E, reason: from kotlin metadata */
    private final Lazy standaloneMode;

    public QZAlbumxTabRecommendFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.qzone.reborn.albumx.qzonex.fragment.QZAlbumxTabRecommendFragment$standaloneMode$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                Intent intent;
                FragmentActivity activity = QZAlbumxTabRecommendFragment.this.getActivity();
                boolean z16 = false;
                if (activity != null && (intent = activity.getIntent()) != null) {
                    z16 = intent.getBooleanExtra(QZoneContant.LOCAL_PHOTO_RECOMMEND_VIDEO_FEED_STANDALONE, false);
                }
                return Boolean.valueOf(z16);
            }
        });
        this.standaloneMode = lazy;
    }

    private final boolean qh() {
        return ((Boolean) this.standaloneMode.getValue()).booleanValue();
    }

    private final void rh(boolean isSelected) {
        QZoneAlbumxLocalPhotoRecommendFeedListPart qZoneAlbumxLocalPhotoRecommendFeedListPart = this.photoRecommendFeedListPart;
        if (qZoneAlbumxLocalPhotoRecommendFeedListPart != null) {
            qZoneAlbumxLocalPhotoRecommendFeedListPart.W9(isSelected);
        }
        QZoneAlbumxLocalPhotoRecommendOperatePart qZoneAlbumxLocalPhotoRecommendOperatePart = this.photoRecommendOperatePart;
        if (qZoneAlbumxLocalPhotoRecommendOperatePart != null) {
            qZoneAlbumxLocalPhotoRecommendOperatePart.O9(isSelected);
        }
        QLog.d(getTAG(), 1, "[onTabFragmentSelectChanged] isSelected = " + isSelected);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sh(QZAlbumxTabRecommendFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.registerDaTongReportPageId();
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        QZoneAlbumxLocalPhotoRecommendFeedListPart qZoneAlbumxLocalPhotoRecommendFeedListPart = new QZoneAlbumxLocalPhotoRecommendFeedListPart();
        this.photoRecommendFeedListPart = qZoneAlbumxLocalPhotoRecommendFeedListPart;
        Intrinsics.checkNotNull(qZoneAlbumxLocalPhotoRecommendFeedListPart);
        arrayList.add(qZoneAlbumxLocalPhotoRecommendFeedListPart);
        QZoneAlbumxLocalPhotoRecommendOperatePart qZoneAlbumxLocalPhotoRecommendOperatePart = new QZoneAlbumxLocalPhotoRecommendOperatePart(qh());
        this.photoRecommendOperatePart = qZoneAlbumxLocalPhotoRecommendOperatePart;
        Intrinsics.checkNotNull(qZoneAlbumxLocalPhotoRecommendOperatePart);
        arrayList.add(qZoneAlbumxLocalPhotoRecommendOperatePart);
        arrayList.add(new QZAlbumTabRecommendTitlePart());
        return arrayList;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    protected Map<String, Object> getChildDaTongPageParams() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("nearby_is_auth", Integer.valueOf(o7.c.b() ? 1 : 0));
        linkedHashMap.put("come_from", 2);
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f128984u;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    /* renamed from: getDaTongPageId */
    protected String getTabReportPageId() {
        return "pg_qz_recommend_content_for_you";
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZAlbumxTabRecommendFragment";
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        rh(false);
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        rh(true);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        QLog.d(getTAG(), 1, "[setUserVisibleHint]: " + isVisibleToUser);
        getMainHandler().postDelayed(new Runnable() { // from class: com.qzone.reborn.albumx.qzonex.fragment.h
            @Override // java.lang.Runnable
            public final void run() {
                QZAlbumxTabRecommendFragment.sh(QZAlbumxTabRecommendFragment.this);
            }
        }, 200L);
    }
}
