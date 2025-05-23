package com.qzone.reborn.albumx.qzone.fragment;

import android.content.Intent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.album.business.albumlist.fragment.d;
import com.qzone.album.business.albumlist.fragment.e;
import com.qzone.reborn.albumx.qzone.part.QZoneAlbumxLocalPhotoRecommendFeedListPart;
import com.qzone.reborn.albumx.qzone.part.QZoneAlbumxLocalPhotoRecommendOperatePart;
import com.qzone.reborn.albumx.qzone.part.QZoneAlbumxLocalPhotoRecommendStandaloneFeedListPart;
import com.qzone.reborn.base.QZoneBaseFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.guild.aio.util.ex.ViewExtKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
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

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0001/B\u0007\u00a2\u0006\u0004\b,\u0010-J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0014J\b\u0010\t\u001a\u00020\bH\u0014J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J \u0010\u0017\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\rH\u0016J\b\u0010\u0019\u001a\u00020\u0005H\u0014J\u0014\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001b0\u001aH\u0014J\u0010\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\bH\u0016R\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u001b\u0010+\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\u00a8\u00060"}, d2 = {"Lcom/qzone/reborn/albumx/qzone/fragment/QZoneLocalPhotoRecommendFragment;", "Lcom/qzone/reborn/base/QZoneBaseFragment;", "Lcom/qzone/album/business/albumlist/fragment/d;", "", "qh", "", "getLogTag", "getContentLayoutId", "", "enableRootViewSetFitsSystemWindows", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "update", "", "counter", "I6", "Landroidx/fragment/app/Fragment;", "fragment", "isSelected", "Lcom/qzone/album/business/albumlist/fragment/e;", "ioc", "Y4", "onWindowFocusChanged", "getDaTongPageId", "", "", "getChildDaTongPageParams", "isVisibleToUser", "setUserVisibleHint", "Lcom/qzone/reborn/albumx/qzone/part/QZoneAlbumxLocalPhotoRecommendFeedListPart;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/albumx/qzone/part/QZoneAlbumxLocalPhotoRecommendFeedListPart;", "photoRecommendFeedListPart", "Lcom/qzone/reborn/albumx/qzone/part/QZoneAlbumxLocalPhotoRecommendOperatePart;", "D", "Lcom/qzone/reborn/albumx/qzone/part/QZoneAlbumxLocalPhotoRecommendOperatePart;", "photoRecommendOperatePart", "E", "Lkotlin/Lazy;", "rh", "()Z", "standaloneMode", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneLocalPhotoRecommendFragment extends QZoneBaseFragment implements d {

    /* renamed from: C, reason: from kotlin metadata */
    private QZoneAlbumxLocalPhotoRecommendFeedListPart photoRecommendFeedListPart;

    /* renamed from: D, reason: from kotlin metadata */
    private QZoneAlbumxLocalPhotoRecommendOperatePart photoRecommendOperatePart;

    /* renamed from: E, reason: from kotlin metadata */
    private final Lazy standaloneMode;

    public QZoneLocalPhotoRecommendFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.qzone.reborn.albumx.qzone.fragment.QZoneLocalPhotoRecommendFragment$standaloneMode$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                Intent intent;
                FragmentActivity activity = QZoneLocalPhotoRecommendFragment.this.getActivity();
                boolean z16 = false;
                if (activity != null && (intent = activity.getIntent()) != null) {
                    z16 = intent.getBooleanExtra(QZoneContant.LOCAL_PHOTO_RECOMMEND_VIDEO_FEED_STANDALONE, false);
                }
                return Boolean.valueOf(z16);
            }
        });
        this.standaloneMode = lazy;
    }

    private final int qh() {
        return rh() ? 1 : 2;
    }

    private final boolean rh() {
        return ((Boolean) this.standaloneMode.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sh(QZoneLocalPhotoRecommendFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.registerDaTongReportPageId();
    }

    @Override // com.qzone.album.business.albumlist.fragment.d
    public boolean I6(long counter) {
        return false;
    }

    @Override // com.qzone.album.business.albumlist.fragment.d
    public void Y4(Fragment fragment, boolean isSelected, e ioc) {
        View fragmentContentView;
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(ioc, "ioc");
        View fragmentContentView2 = getFragmentContentView();
        if (!(fragmentContentView2 != null && fragmentContentView2.getPaddingTop() == 0) && (fragmentContentView = getFragmentContentView()) != null) {
            ViewExtKt.f(fragmentContentView, 0);
        }
        if (isSelected) {
            ioc.a(false);
            ioc.b(true);
        } else {
            ioc.b(false);
        }
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

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        if (rh()) {
            arrayList.add(new QZoneAlbumxLocalPhotoRecommendStandaloneFeedListPart());
        } else {
            QZoneAlbumxLocalPhotoRecommendFeedListPart qZoneAlbumxLocalPhotoRecommendFeedListPart = new QZoneAlbumxLocalPhotoRecommendFeedListPart();
            this.photoRecommendFeedListPart = qZoneAlbumxLocalPhotoRecommendFeedListPart;
            Intrinsics.checkNotNull(qZoneAlbumxLocalPhotoRecommendFeedListPart);
            arrayList.add(qZoneAlbumxLocalPhotoRecommendFeedListPart);
        }
        QZoneAlbumxLocalPhotoRecommendOperatePart qZoneAlbumxLocalPhotoRecommendOperatePart = new QZoneAlbumxLocalPhotoRecommendOperatePart(rh());
        this.photoRecommendOperatePart = qZoneAlbumxLocalPhotoRecommendOperatePart;
        Intrinsics.checkNotNull(qZoneAlbumxLocalPhotoRecommendOperatePart);
        arrayList.add(qZoneAlbumxLocalPhotoRecommendOperatePart);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean enableRootViewSetFitsSystemWindows() {
        if (rh()) {
            return false;
        }
        return super.enableRootViewSetFitsSystemWindows();
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    protected Map<String, Object> getChildDaTongPageParams() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("nearby_is_auth", Integer.valueOf(o7.c.b() ? 1 : 0));
        linkedHashMap.put("come_from", Integer.valueOf(qh()));
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f128984u;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    /* renamed from: getDaTongPageId */
    protected String getMFromDtPageId() {
        return "pg_qz_recommend_content_for_you";
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneLocalPhotoRecommendFragment";
    }

    @Override // com.qzone.album.business.albumlist.fragment.d
    public void onWindowFocusChanged() {
        QLog.d(getTAG(), 1, "[onWindowFocusChanged]");
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        QLog.d(getTAG(), 1, "[setUserVisibleHint]: " + isVisibleToUser);
        RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.qzone.reborn.albumx.qzone.fragment.a
            @Override // java.lang.Runnable
            public final void run() {
                QZoneLocalPhotoRecommendFragment.sh(QZoneLocalPhotoRecommendFragment.this);
            }
        }, 200L);
    }

    @Override // com.qzone.album.business.albumlist.fragment.d
    public void update() {
    }
}
