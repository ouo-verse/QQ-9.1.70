package com.qzone.reborn.groupalbum.selectmedia;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.base.QZoneBaseFragment;
import com.qzone.reborn.groupalbum.bean.init.GroupChatHistoryMediaSelectInitBean;
import com.qzone.reborn.groupalbum.selectmedia.part.ChatHistorySearchTitlePart;
import com.qzone.reborn.groupalbum.selectmedia.part.ChatHistorySelectMediaPart;
import com.qzone.reborn.groupalbum.selectmedia.viewmodel.ChatHistoryMediaViewModel;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u001a\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/qzone/reborn/groupalbum/selectmedia/ChatHistorySelectMediaFragment;", "Lcom/qzone/reborn/base/QZoneBaseFragment;", "", "ph", "", "getContentLayoutId", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Lcom/qzone/reborn/groupalbum/bean/init/GroupChatHistoryMediaSelectInitBean;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/groupalbum/bean/init/GroupChatHistoryMediaSelectInitBean;", "initBean", "<init>", "()V", "D", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class ChatHistorySelectMediaFragment extends QZoneBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private GroupChatHistoryMediaSelectInitBean initBean;

    private final void ph() {
        Parcelable parcelableExtra = getHostActivity().getIntent().getParcelableExtra("key_bundle_common_init_bean");
        Intrinsics.checkNotNull(parcelableExtra);
        this.initBean = (GroupChatHistoryMediaSelectInitBean) parcelableExtra;
        ChatHistoryMediaViewModel chatHistoryMediaViewModel = (ChatHistoryMediaViewModel) getViewModel(ChatHistoryMediaViewModel.class);
        GroupChatHistoryMediaSelectInitBean groupChatHistoryMediaSelectInitBean = this.initBean;
        GroupChatHistoryMediaSelectInitBean groupChatHistoryMediaSelectInitBean2 = null;
        if (groupChatHistoryMediaSelectInitBean == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initBean");
            groupChatHistoryMediaSelectInitBean = null;
        }
        String groupId = groupChatHistoryMediaSelectInitBean.getGroupId();
        GroupChatHistoryMediaSelectInitBean groupChatHistoryMediaSelectInitBean3 = this.initBean;
        if (groupChatHistoryMediaSelectInitBean3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initBean");
            groupChatHistoryMediaSelectInitBean3 = null;
        }
        CommonAlbumInfo albumInfo = groupChatHistoryMediaSelectInitBean3.getAlbumInfo();
        GroupChatHistoryMediaSelectInitBean groupChatHistoryMediaSelectInitBean4 = this.initBean;
        if (groupChatHistoryMediaSelectInitBean4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initBean");
        } else {
            groupChatHistoryMediaSelectInitBean2 = groupChatHistoryMediaSelectInitBean4;
        }
        chatHistoryMediaViewModel.W1(groupId, albumInfo, groupChatHistoryMediaSelectInitBean2.getFromType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f127681b;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        ph();
        super.onViewCreated(view, savedInstanceState);
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new ChatHistorySelectMediaPart(), new ChatHistorySearchTitlePart());
        return mutableListOf;
    }
}
