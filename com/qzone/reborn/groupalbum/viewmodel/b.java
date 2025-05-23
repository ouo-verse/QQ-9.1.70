package com.qzone.reborn.groupalbum.viewmodel;

import android.app.Activity;
import android.content.Intent;
import android.widget.ImageView;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.qzone.reborn.groupalbum.bean.init.GroupAlbumAlbumDetailInitBean;
import com.qzone.reborn.groupalbum.reship.manager.GroupAlbumReshipSendBoxManager;
import com.qzone.reborn.groupalbum.viewmodel.b;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.io.Serializable;
import ki.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000[\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\b\u0007*\u00013\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b7\u00108J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016J8\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0013H\u0016J\b\u0010\u001c\u001a\u00020\bH\u0016R$\u0010#\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010+\u001a\u00020$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u00102\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105\u00a8\u00069"}, d2 = {"Lcom/qzone/reborn/groupalbum/viewmodel/b;", "Lcom/qzone/reborn/albumx/common/viewmodel/b;", "", "getLogTag", "Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", "S1", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "l2", "Lcom/qzone/reborn/groupalbum/bean/init/GroupAlbumAlbumDetailInitBean;", "initBean", ICustomDataEditor.NUMBER_PARAM_2, "", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "b2", "k2", "Lcom/qzone/reborn/albumx/common/bean/a;", "batchBean", "", "batchPos", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", QAdVrReportParams.ParamKey.MEDIA, "mediaPos", "Landroid/widget/ImageView;", "view", "transCreatorKey", ICustomDataEditor.STRING_ARRAY_PARAM_2, "c2", "H", "Lcom/qzone/reborn/groupalbum/bean/init/GroupAlbumAlbumDetailInitBean;", "j2", "()Lcom/qzone/reborn/groupalbum/bean/init/GroupAlbumAlbumDetailInitBean;", "setMInitBean", "(Lcom/qzone/reborn/groupalbum/bean/init/GroupAlbumAlbumDetailInitBean;)V", "mInitBean", "Lki/g;", "I", "Lki/g;", "i2", "()Lki/g;", "setDataRepo", "(Lki/g;)V", "dataRepo", "J", "Ljava/lang/String;", "getDataRepoKey", "()Ljava/lang/String;", "m2", "(Ljava/lang/String;)V", "dataRepoKey", "com/qzone/reborn/groupalbum/viewmodel/b$a", "K", "Lcom/qzone/reborn/groupalbum/viewmodel/b$a;", "listener", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class b extends com.qzone.reborn.albumx.common.viewmodel.b {

    /* renamed from: H, reason: from kotlin metadata */
    private GroupAlbumAlbumDetailInitBean mInitBean;

    /* renamed from: I, reason: from kotlin metadata */
    private ki.g dataRepo = new ki.g();

    /* renamed from: J, reason: from kotlin metadata */
    private String dataRepoKey = "";

    /* renamed from: K, reason: from kotlin metadata */
    private final a listener = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/qzone/reborn/groupalbum/viewmodel/b$a", "Lki/g$b;", "Lcom/qzone/reborn/albumx/common/bean/b;", "repoBean", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class a implements g.b {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(a this$0, com.qzone.reborn.albumx.common.bean.b repoBean) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(repoBean, "$repoBean");
            this$0.a(repoBean);
        }

        @Override // ki.g.b
        public void a(final com.qzone.reborn.albumx.common.bean.b repoBean) {
            Intrinsics.checkNotNullParameter(repoBean, "repoBean");
            if (!RFWThreadManager.isMainThread()) {
                RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.reborn.groupalbum.viewmodel.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.a.c(b.a.this, repoBean);
                    }
                });
            } else {
                b.this.U1(repoBean);
            }
        }
    }

    @Override // com.qzone.reborn.albumx.common.viewmodel.b
    public LoadInfo S1() {
        return this.dataRepo.getLoadInfo();
    }

    @Override // com.qzone.reborn.albumx.common.viewmodel.b
    public void a2(com.qzone.reborn.albumx.common.bean.a batchBean, int batchPos, CommonStMedia media, int mediaPos, ImageView view, int transCreatorKey) {
        String str;
        String name;
        Intrinsics.checkNotNullParameter(batchBean, "batchBean");
        Intrinsics.checkNotNullParameter(media, "media");
        Intrinsics.checkNotNullParameter(view, "view");
        GroupAlbumAlbumDetailInitBean groupAlbumAlbumDetailInitBean = this.mInitBean;
        String str2 = "";
        if (groupAlbumAlbumDetailInitBean == null || (str = groupAlbumAlbumDetailInitBean.getAlbumId()) == null) {
            str = "";
        }
        batchBean.g(str);
        CommonAlbumInfo value = M1().getValue();
        if (value != null && (name = value.getName()) != null) {
            str2 = name;
        }
        batchBean.h(str2);
        GroupAlbumAlbumDetailInitBean groupAlbumAlbumDetailInitBean2 = this.mInitBean;
        if (groupAlbumAlbumDetailInitBean2 != null) {
            groupAlbumAlbumDetailInitBean2.setClickMediaPos(this.dataRepo.c(batchBean.getBatchInfo().getLinkId(), k9.b.f411905a.a(media)));
        }
        GroupAlbumAlbumDetailInitBean groupAlbumAlbumDetailInitBean3 = this.mInitBean;
        if (groupAlbumAlbumDetailInitBean3 != null) {
            groupAlbumAlbumDetailInitBean3.setDataRepoKey(this.dataRepoKey);
        }
        view.setTag(R.id.f100755tc, Integer.valueOf(transCreatorKey));
        ei.a.f396299a.b(view.getContext(), view, mediaPos, k2(), batchBean, this.mInitBean);
    }

    @Override // com.qzone.reborn.albumx.common.viewmodel.b
    public void b2(boolean isLoadMore) {
        String groupId;
        GroupAlbumAlbumDetailInitBean groupAlbumAlbumDetailInitBean = this.mInitBean;
        if (groupAlbumAlbumDetailInitBean != null) {
            this.dataRepo.k(groupAlbumAlbumDetailInitBean);
        }
        ki.g gVar = this.dataRepo;
        GroupAlbumAlbumDetailInitBean groupAlbumAlbumDetailInitBean2 = this.mInitBean;
        gVar.p(groupAlbumAlbumDetailInitBean2 != null ? groupAlbumAlbumDetailInitBean2.getAlbumId() : null, this.listener);
        this.dataRepo.u(isLoadMore);
        GroupAlbumAlbumDetailInitBean groupAlbumAlbumDetailInitBean3 = this.mInitBean;
        if (groupAlbumAlbumDetailInitBean3 == null || (groupId = groupAlbumAlbumDetailInitBean3.getGroupId()) == null) {
            return;
        }
        GroupAlbumReshipSendBoxManager.f56848a.w(groupId);
    }

    @Override // com.qzone.reborn.albumx.common.viewmodel.b
    public void c2() {
        ki.g gVar = this.dataRepo;
        GroupAlbumAlbumDetailInitBean groupAlbumAlbumDetailInitBean = this.mInitBean;
        gVar.q(groupAlbumAlbumDetailInitBean != null ? groupAlbumAlbumDetailInitBean.getAlbumId() : null);
    }

    @Override // com.qzone.reborn.albumx.common.viewmodel.b, com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "GroupAlbumAlbumDetailViewModel";
    }

    /* renamed from: i2, reason: from getter */
    public final ki.g getDataRepo() {
        return this.dataRepo;
    }

    /* renamed from: j2, reason: from getter */
    public final GroupAlbumAlbumDetailInitBean getMInitBean() {
        return this.mInitBean;
    }

    public String k2() {
        return "";
    }

    public final void l2(Activity activity) {
        Intent intent;
        if (this.mInitBean != null || activity == null || (intent = activity.getIntent()) == null || intent.getExtras() == null) {
            return;
        }
        Intent intent2 = activity.getIntent();
        Serializable serializableExtra = intent2 != null ? intent2.getSerializableExtra("key_bundle_common_init_bean") : null;
        this.mInitBean = serializableExtra instanceof GroupAlbumAlbumDetailInitBean ? (GroupAlbumAlbumDetailInitBean) serializableExtra : null;
    }

    public final void m2(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.dataRepoKey = str;
    }

    public final void n2(GroupAlbumAlbumDetailInitBean initBean) {
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        this.mInitBean = initBean;
    }
}
