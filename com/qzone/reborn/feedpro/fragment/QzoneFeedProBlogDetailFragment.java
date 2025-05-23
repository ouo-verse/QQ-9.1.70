package com.qzone.reborn.feedpro.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.qzone.reborn.base.QZoneBaseFragment;
import com.qzone.reborn.feedpro.part.detail.QzoneFeedProBlogDetailWebViewPart;
import com.qzone.reborn.feedpro.part.detail.h;
import com.qzone.reborn.feedpro.utils.al;
import com.qzone.reborn.feedpro.viewmodel.d;
import com.qzone.reborn.share.QQShareActionManagerV2;
import com.qzone.reborn.share.QzoneSharePart;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import gf.k;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import re.b;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\tH\u0014J\u001c\u0010\u000f\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014J\u0012\u0010\u0010\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0014J\b\u0010\u0016\u001a\u00020\tH\u0016J\b\u0010\u0017\u001a\u00020\tH\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0014R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/qzone/reborn/feedpro/fragment/QzoneFeedProBlogDetailFragment;", "Lcom/qzone/reborn/base/QZoneBaseFragment;", "Lgf/k;", "Landroid/content/Intent;", "intent", "", "parseIntent", "initViewModel", "initIoc", "", "getContentLayoutId", "Landroid/view/View;", "contentView", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onViewCreatedBeforePartInit", "onActivityCreated", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "enableRootViewSetFitsSystemWindows", "getReportPageId", "getPageType", "", "getDaTongPageId", "Lcom/qzone/reborn/feedpro/viewmodel/d;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/feedpro/viewmodel/d;", "mBlogViewModel", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzoneFeedProBlogDetailFragment extends QZoneBaseFragment implements k {

    /* renamed from: C, reason: from kotlin metadata */
    private d mBlogViewModel;

    private final void initIoc() {
        registerIoc(this, k.class);
    }

    private final void initViewModel() {
        this.mBlogViewModel = (d) getViewModel(d.class);
    }

    private final void parseIntent(Intent intent) {
        d dVar = this.mBlogViewModel;
        Intrinsics.checkNotNull(dVar);
        dVar.O1(intent);
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new h());
        arrayList.add(new QzoneFeedProBlogDetailWebViewPart());
        QQShareActionManagerV2 qQShareActionManagerV2 = new QQShareActionManagerV2();
        qQShareActionManagerV2.b(al.f54309a.a());
        arrayList.add(new QzoneSharePart(qQShareActionManagerV2, b.class));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean enableRootViewSetFitsSystemWindows() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.chx;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    /* renamed from: getDaTongPageId */
    protected String getMFromDtPageId() {
        return "pg_qz_dynamic_detail_page";
    }

    @Override // gf.k
    public int getPageType() {
        return 2;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.qzone.util.ap.a
    public int getReportPageId() {
        return 3;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FragmentActivity activity = getActivity();
        Window window = activity != null ? activity.getWindow() : null;
        if (window == null) {
            return;
        }
        ImmersiveUtils.setStatusTextColor(true, window);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(View contentView, Bundle savedInstanceState) {
        super.onViewCreatedBeforePartInit(contentView, savedInstanceState);
        initIoc();
        initViewModel();
        FragmentActivity activity = getActivity();
        Intent intent = activity != null ? activity.getIntent() : null;
        if (intent == null) {
            return;
        }
        parseIntent(intent);
    }
}
