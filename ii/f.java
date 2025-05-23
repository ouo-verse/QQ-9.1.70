package ii;

import androidx.lifecycle.MutableLiveData;
import ci.g;
import com.qzone.reborn.albumx.common.convert.bean.CommonStLike;
import com.qzone.reborn.base.n;
import com.qzone.reborn.groupalbum.layer.bean.GroupAlbumLayerExtraInfoBean;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import ki.s;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005R(\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R(\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00130\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0015\u0010\u000f\"\u0004\b\u0016\u0010\u0011\u00a8\u0006\u001c"}, d2 = {"Lii/f;", "Lq9/b;", "Lcom/qzone/reborn/groupalbum/layer/bean/GroupAlbumLayerExtraInfoBean;", "Lci/g;", "requestBean", "Lcom/qzone/reborn/base/n$a;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStLike;", "dataCallback", "", "L1", "Landroidx/lifecycle/MutableLiveData;", "Lci/f;", "i", "Landroidx/lifecycle/MutableLiveData;", "M1", "()Landroidx/lifecycle/MutableLiveData;", "setPraiseInfo", "(Landroidx/lifecycle/MutableLiveData;)V", "praiseInfo", "Lci/c;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getCommentInfo", "setCommentInfo", "commentInfo", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class f extends q9.b<GroupAlbumLayerExtraInfoBean> {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private MutableLiveData<ci.f> praiseInfo = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private MutableLiveData<ci.c> commentInfo = new MutableLiveData<>();

    public final void L1(g requestBean, n.a<CommonStLike> dataCallback) {
        Intrinsics.checkNotNullParameter(requestBean, "requestBean");
        Intrinsics.checkNotNullParameter(dataCallback, "dataCallback");
        s.f412506a.c(requestBean.getCom.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent.KEY_IS_VIDEO java.lang.String(), requestBean.getUploadUserUid(), requestBean.getGroupId(), requestBean.getAlbumId(), requestBean.getBatchId(), requestBean.getLLoc(), requestBean.getLikeKey(), requestBean.getActionType(), dataCallback);
    }

    public final MutableLiveData<ci.f> M1() {
        return this.praiseInfo;
    }
}
