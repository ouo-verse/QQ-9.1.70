package com.qzone.reborn.albumx.qzonex.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.qzone.app.QZoneFeedAlertService;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxMainPageInitBean;
import com.qzone.reborn.albumx.qzonex.part.albumdetail.QZAlbumxTransmitPart;
import com.qzone.reborn.albumx.qzonex.part.albumlist.o;
import com.qzone.reborn.albumx.qzonex.part.main.QZAlbumxMainPageTitlePart;
import com.qzone.reborn.base.QZoneBaseFragment;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qqnt.kernel.nativeinterface.AlbumPageInfo;
import com.tencent.richframework.argus.node.ArgusTag;
import cooperation.qzone.QZoneHelper;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import nc.bn;

/* compiled from: P */
@ArgusTag(testConfigKey = "Argus_QZAlbumx", testTags = {"AUTO_PRELOAD"})
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J&\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0014J\b\u0010\u0012\u001a\u00020\u0011H\u0014J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016J\u001a\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\u0019\u001a\u00020\u0018H\u0014J\u0014\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001b0\u001aH\u0014R\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u001b\u0010)\u001a\u00020$8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\u00a8\u0006,"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/fragment/QZAlbumxMainFragment;", "Lcom/qzone/reborn/base/QZoneBaseFragment;", "", "uh", "sh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "enableRootViewSetFitsSystemWindows", "", "getContentLayoutId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "contentView", "onViewCreatedAfterPartInit", "", "getDaTongPageId", "", "", "getChildDaTongDynamicParams", "Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxMainPageInitBean;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxMainPageInitBean;", "initBean", "D", "Ljava/lang/String;", "tabReportPageId", "Lnc/bn;", "E", "Lkotlin/Lazy;", "th", "()Lnc/bn;", "mainTabViewModel", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZAlbumxMainFragment extends QZoneBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private QZAlbumxMainPageInitBean initBean;

    /* renamed from: D, reason: from kotlin metadata */
    private String tabReportPageId = "pg_qz_space_album_list_new";

    /* renamed from: E, reason: from kotlin metadata */
    private final Lazy mainTabViewModel;

    public QZAlbumxMainFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<bn>() { // from class: com.qzone.reborn.albumx.qzonex.fragment.QZAlbumxMainFragment$mainTabViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final bn invoke() {
                return (bn) QZAlbumxMainFragment.this.getViewModel(bn.class);
            }
        });
        this.mainTabViewModel = lazy;
    }

    private final void sh() {
        com.tencent.mobileqq.qui.b bVar = com.tencent.mobileqq.qui.b.f276860a;
        FragmentActivity activity = getActivity();
        bVar.l(activity != null ? activity.getWindow() : null);
    }

    private final bn th() {
        Object value = this.mainTabViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mainTabViewModel>(...)");
        return (bn) value;
    }

    private final void uh() {
        Intent intent;
        if (this.initBean == null) {
            FragmentActivity activity = getActivity();
            Serializable serializableExtra = (activity == null || (intent = activity.getIntent()) == null) ? null : intent.getSerializableExtra("key_bundle_common_init_bean");
            this.initBean = serializableExtra instanceof QZAlbumxMainPageInitBean ? (QZAlbumxMainPageInitBean) serializableExtra : null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat vh(View view, WindowInsetsCompat windowInsetsCompat) {
        view.setPadding(view.getPaddingLeft(), windowInsetsCompat.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.statusBars()).top, view.getPaddingRight(), 0);
        return windowInsetsCompat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wh(final QZAlbumxMainFragment this$0, Integer num) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (num != null && num.intValue() == 0) {
            this$0.tabReportPageId = "pg_qz_space_album_list_new";
        } else if (num != null && num.intValue() == 1) {
            this$0.tabReportPageId = "pg_qz_pic_list";
        } else if (num != null && num.intValue() == 2) {
            this$0.tabReportPageId = "pg_qz_video_list";
        } else if (num != null && num.intValue() == 3) {
            this$0.tabReportPageId = "pg_qz_recommend_content_for_you";
        }
        this$0.getMainHandler().postDelayed(new Runnable() { // from class: com.qzone.reborn.albumx.qzonex.fragment.d
            @Override // java.lang.Runnable
            public final void run() {
                QZAlbumxMainFragment.xh(QZAlbumxMainFragment.this);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xh(QZAlbumxMainFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.registerDaTongReportPageId();
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        uh();
        QZAlbumxMainPageInitBean qZAlbumxMainPageInitBean = this.initBean;
        if (Intrinsics.areEqual(qZAlbumxMainPageInitBean != null ? qZAlbumxMainPageInitBean.getUin() : null, LoginData.getInstance().getUinString())) {
            QZoneFeedAlertService.getInstance().clearSingleUnreadCount(19);
        }
        Part[] partArr = new Part[5];
        partArr[0] = new com.qzone.reborn.albumx.qzonex.part.main.g();
        partArr[1] = new QZAlbumxMainPageTitlePart();
        partArr[2] = new com.qzone.reborn.albumx.qzonex.part.main.e();
        QZAlbumxMainPageInitBean qZAlbumxMainPageInitBean2 = this.initBean;
        partArr[3] = new QZAlbumxTransmitPart(qZAlbumxMainPageInitBean2 != null ? qZAlbumxMainPageInitBean2.getUin() : null, null, 20, 34);
        partArr[4] = new o();
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(partArr);
        return mutableListOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean enableRootViewSetFitsSystemWindows() {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0103, code lost:
    
        if (r2 == null) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0105, code lost:
    
        r5 = r2.getUin();
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x010d, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r1, r5) == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x010f, code lost:
    
        r3 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0110, code lost:
    
        r0.put(com.tencent.mobileqq.profilecard.base.report.ProfileCardBlacklistReportConst.PAGE_PARAM_USERPROFILE_SETTING_HOST_GUEST_TYPE, java.lang.Integer.valueOf(r3));
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00a6, code lost:
    
        if (r1.equals("getActiveFeeds") == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00f6, code lost:
    
        if (r1.equals("pg_qz_pic_list") == false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0021, code lost:
    
        if (r1.equals("pg_qz_video_list") == false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x00f9, code lost:
    
        r1 = com.qzone.common.account.LoginData.getInstance().getUinString();
        r2 = r8.initBean;
     */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00db  */
    @Override // com.qzone.reborn.base.QZoneBaseFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected Map<String, Object> getChildDaTongDynamicParams() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (!isAdded()) {
            return linkedHashMap;
        }
        String str = this.tabReportPageId;
        int i3 = 2;
        switch (str.hashCode()) {
            case -1621929663:
                break;
            case -1553717066:
                if (str.equals("pg_qz_space_album_list_new")) {
                    QZAlbumxMainPageInitBean qZAlbumxMainPageInitBean = this.initBean;
                    String from = qZAlbumxMainPageInitBean != null ? qZAlbumxMainPageInitBean.getFrom() : null;
                    if (from != null) {
                        int hashCode = from.hashCode();
                        if (hashCode == -1715136007) {
                            break;
                        } else if (hashCode != 695639619) {
                            if (hashCode == 2069337438 && from.equals("getMainPage")) {
                                String uinString = LoginData.getInstance().getUinString();
                                QZAlbumxMainPageInitBean qZAlbumxMainPageInitBean2 = this.initBean;
                                i3 = Intrinsics.areEqual(uinString, qZAlbumxMainPageInitBean2 != null ? qZAlbumxMainPageInitBean2.getUin() : null) ? 3 : 4;
                                linkedHashMap.put(IFileBrowserService.FILE_BROWSER_PAGE_FROM, Integer.valueOf(i3));
                                AlbumPageInfo value = th().U1().getValue();
                                linkedHashMap.put("albums_number", Integer.valueOf(value != null ? value.albumNum : 0));
                                String uinString2 = LoginData.getInstance().getUinString();
                                QZAlbumxMainPageInitBean qZAlbumxMainPageInitBean3 = this.initBean;
                                linkedHashMap.put("open_visit_state", Integer.valueOf(!Intrinsics.areEqual(uinString2, qZAlbumxMainPageInitBean3 != null ? qZAlbumxMainPageInitBean3.getUin() : null) ? 1 : 0));
                                break;
                            }
                        } else if (from.equals(QZoneHelper.QZoneAppConstants.REFER_QQ_SETTING)) {
                            i3 = 1;
                            linkedHashMap.put(IFileBrowserService.FILE_BROWSER_PAGE_FROM, Integer.valueOf(i3));
                            AlbumPageInfo value2 = th().U1().getValue();
                            linkedHashMap.put("albums_number", Integer.valueOf(value2 != null ? value2.albumNum : 0));
                            String uinString22 = LoginData.getInstance().getUinString();
                            QZAlbumxMainPageInitBean qZAlbumxMainPageInitBean32 = this.initBean;
                            linkedHashMap.put("open_visit_state", Integer.valueOf(!Intrinsics.areEqual(uinString22, qZAlbumxMainPageInitBean32 != null ? qZAlbumxMainPageInitBean32.getUin() : null) ? 1 : 0));
                        }
                    }
                    i3 = 0;
                    linkedHashMap.put(IFileBrowserService.FILE_BROWSER_PAGE_FROM, Integer.valueOf(i3));
                    AlbumPageInfo value22 = th().U1().getValue();
                    linkedHashMap.put("albums_number", Integer.valueOf(value22 != null ? value22.albumNum : 0));
                    String uinString222 = LoginData.getInstance().getUinString();
                    QZAlbumxMainPageInitBean qZAlbumxMainPageInitBean322 = this.initBean;
                    linkedHashMap.put("open_visit_state", Integer.valueOf(!Intrinsics.areEqual(uinString222, qZAlbumxMainPageInitBean322 != null ? qZAlbumxMainPageInitBean322.getUin() : null) ? 1 : 0));
                }
                break;
            case 469585682:
                if (str.equals("pg_qz_recommend_content_for_you")) {
                    linkedHashMap.put("nearby_is_auth", Integer.valueOf(o7.c.b() ? 1 : 0));
                    break;
                }
                break;
            case 2068943216:
                break;
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f129165b;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    /* renamed from: getDaTongPageId, reason: from getter */
    protected String getMFromDtPageId() {
        return this.tabReportPageId;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        sh();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        ViewCompat.setOnApplyWindowInsetsListener(view, new OnApplyWindowInsetsListener() { // from class: com.qzone.reborn.albumx.qzonex.fragment.b
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat) {
                WindowInsetsCompat vh5;
                vh5 = QZAlbumxMainFragment.vh(view2, windowInsetsCompat);
                return vh5;
            }
        });
        super.onViewCreated(view, savedInstanceState);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(View contentView, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        super.onViewCreatedAfterPartInit(contentView, savedInstanceState);
        th().e2().observe(getLifecycleOwner(), new Observer() { // from class: com.qzone.reborn.albumx.qzonex.fragment.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZAlbumxMainFragment.wh(QZAlbumxMainFragment.this, (Integer) obj);
            }
        });
    }
}
