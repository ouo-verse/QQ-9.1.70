package com.qzone.reborn.groupalbum.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.qzone.reborn.albumx.common.part.edittext.CommonAlbumEditTextInputPart;
import com.qzone.reborn.albumx.common.part.edittext.CommonAlbumEditTextTitleBarPart;
import com.qzone.reborn.base.QZoneBaseFragment;
import com.qzone.reborn.groupalbum.bean.init.GroupAlbumEditTextInitBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0014J&\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0014R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/qzone/reborn/groupalbum/fragment/GroupAlbumEditTextFragment;", "Lcom/qzone/reborn/base/QZoneBaseFragment;", "", "getContentLayoutId", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "getDaTongPageId", "Lcom/qzone/reborn/groupalbum/bean/init/GroupAlbumEditTextInitBean;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/groupalbum/bean/init/GroupAlbumEditTextInitBean;", "initBean", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class GroupAlbumEditTextFragment extends QZoneBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private GroupAlbumEditTextInitBean initBean;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f127470r;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    /* renamed from: getDaTongPageId */
    protected String getTabReportPageId() {
        GroupAlbumEditTextInitBean groupAlbumEditTextInitBean = this.initBean;
        if (groupAlbumEditTextInitBean == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initBean");
            groupAlbumEditTextInitBean = null;
        }
        return groupAlbumEditTextInitBean.getDaTongPageId();
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intent intent;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentActivity activity = getActivity();
        Serializable serializableExtra = (activity == null || (intent = activity.getIntent()) == null) ? null : intent.getSerializableExtra("key_bundle_common_init_bean");
        Intrinsics.checkNotNull(serializableExtra, "null cannot be cast to non-null type com.qzone.reborn.groupalbum.bean.init.GroupAlbumEditTextInitBean");
        this.initBean = (GroupAlbumEditTextInitBean) serializableExtra;
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        Part[] partArr = new Part[2];
        GroupAlbumEditTextInitBean groupAlbumEditTextInitBean = this.initBean;
        GroupAlbumEditTextInitBean groupAlbumEditTextInitBean2 = null;
        if (groupAlbumEditTextInitBean == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initBean");
            groupAlbumEditTextInitBean = null;
        }
        partArr[0] = new CommonAlbumEditTextTitleBarPart(groupAlbumEditTextInitBean.getTitleBarText());
        GroupAlbumEditTextInitBean groupAlbumEditTextInitBean3 = this.initBean;
        if (groupAlbumEditTextInitBean3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initBean");
            groupAlbumEditTextInitBean3 = null;
        }
        String text = groupAlbumEditTextInitBean3.getText();
        GroupAlbumEditTextInitBean groupAlbumEditTextInitBean4 = this.initBean;
        if (groupAlbumEditTextInitBean4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initBean");
            groupAlbumEditTextInitBean4 = null;
        }
        int maxInputLen = groupAlbumEditTextInitBean4.getMaxInputLen();
        GroupAlbumEditTextInitBean groupAlbumEditTextInitBean5 = this.initBean;
        if (groupAlbumEditTextInitBean5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initBean");
            groupAlbumEditTextInitBean5 = null;
        }
        String hint = groupAlbumEditTextInitBean5.getHint();
        GroupAlbumEditTextInitBean groupAlbumEditTextInitBean6 = this.initBean;
        if (groupAlbumEditTextInitBean6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initBean");
            groupAlbumEditTextInitBean6 = null;
        }
        boolean canOutputBlankString = groupAlbumEditTextInitBean6.getCanOutputBlankString();
        GroupAlbumEditTextInitBean groupAlbumEditTextInitBean7 = this.initBean;
        if (groupAlbumEditTextInitBean7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initBean");
        } else {
            groupAlbumEditTextInitBean2 = groupAlbumEditTextInitBean7;
        }
        partArr[1] = new CommonAlbumEditTextInputPart(text, maxInputLen, hint, canOutputBlankString, groupAlbumEditTextInitBean2.getIsMultiLineInput(), false, 32, null);
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(partArr);
        return mutableListOf;
    }
}
