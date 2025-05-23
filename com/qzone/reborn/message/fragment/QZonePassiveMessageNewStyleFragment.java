package com.qzone.reborn.message.fragment;

import android.os.Bundle;
import android.view.View;
import com.qzone.reborn.base.QZoneBaseFragment;
import com.qzone.reborn.message.part.QZonePassiveMessageFeedCommentPart;
import com.qzone.reborn.message.part.QZonePassiveMessageHighFivePart;
import com.qzone.reborn.message.part.QZonePassiveMessageJoinAlbumPart;
import com.qzone.reborn.message.part.QZonePassiveMessageWechatGuildPart;
import com.qzone.reborn.message.part.l;
import com.qzone.reborn.message.part.m;
import com.qzone.reborn.message.part.n;
import com.qzone.reborn.message.part.s;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import gf.k;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import mqq.app.Constants;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u001c\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0014\u00a8\u0006\u0013"}, d2 = {"Lcom/qzone/reborn/message/fragment/QZonePassiveMessageNewStyleFragment;", "Lcom/qzone/reborn/base/QZoneBaseFragment;", "Lgf/k;", "", "getContentLayoutId", "Landroid/view/View;", "contentView", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onViewCreatedBeforePartInit", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "getPageType", "", "enableDaTongPageRegister", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZonePassiveMessageNewStyleFragment extends QZoneBaseFragment implements k {
    @Override // com.qzone.reborn.base.QZoneBaseFragment
    protected boolean enableDaTongPageRegister() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.cmc;
    }

    @Override // gf.k
    public int getPageType() {
        return 13;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(View contentView, Bundle savedInstanceState) {
        super.onViewCreatedBeforePartInit(contentView, savedInstanceState);
        registerIoc(this, k.class);
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        int i3 = 1;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new l(), new QZonePassiveMessageFeedCommentPart(false, false, null, 7, null), new s(), new n(), new m(), new QZonePassiveMessageJoinAlbumPart(null, i3, 0 == true ? 1 : 0), new QZonePassiveMessageHighFivePart(0 == true ? 1 : 0, i3, 0 == true ? 1 : 0), new QZonePassiveMessageWechatGuildPart());
        return mutableListOf;
    }
}
