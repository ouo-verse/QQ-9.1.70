package com.qzone.reborn.groupalbum.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.qzone.reborn.groupalbum.viewmodel.z;
import com.qzone.reborn.notice.QZoneNoticeFragment;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import gf.k;
import java.util.ArrayList;
import java.util.List;
import ji.b;
import ji.c;
import ji.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u001a\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0014J\b\u0010\u0013\u001a\u00020\u0005H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/qzone/reborn/groupalbum/fragment/GroupAlbumNoticeFragment;", "Lcom/qzone/reborn/notice/QZoneNoticeFragment;", "Lgf/k;", "Landroid/content/Intent;", "intent", "", "parseIntent", "initViewModel", "initIoc", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "getPageType", "Landroid/view/View;", "contentView", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onViewCreatedBeforePartInit", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "getDaTongPageId", "Lcom/qzone/reborn/groupalbum/viewmodel/z;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/groupalbum/viewmodel/z;", "mFeedViewModel", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class GroupAlbumNoticeFragment extends QZoneNoticeFragment implements k {

    /* renamed from: C, reason: from kotlin metadata */
    private z mFeedViewModel;

    private final void initIoc() {
        registerIoc(this, k.class);
    }

    private final void initViewModel() {
        this.mFeedViewModel = (z) getViewModel(z.class);
    }

    private final void parseIntent(Intent intent) {
        z zVar = this.mFeedViewModel;
        if (zVar != null) {
            zVar.X1(intent);
        }
    }

    @Override // com.qzone.reborn.notice.QZoneNoticeFragment, com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new c());
        arrayList.add(new e());
        arrayList.add(new ji.a());
        arrayList.add(new b());
        return arrayList;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    /* renamed from: getDaTongPageId */
    protected String getTabReportPageId() {
        return "pg_qz_interactive_notification";
    }

    @Override // gf.k
    public int getPageType() {
        return 11;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        z zVar = this.mFeedViewModel;
        if (zVar != null) {
            zVar.L1();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(View contentView, Bundle savedInstanceState) {
        Intent intent;
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        super.onViewCreatedBeforePartInit(contentView, savedInstanceState);
        initIoc();
        initViewModel();
        if (getActivity() == null || (intent = requireActivity().getIntent()) == null) {
            return;
        }
        parseIntent(intent);
    }
}
