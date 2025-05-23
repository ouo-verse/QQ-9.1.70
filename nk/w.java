package nk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateAlbumDetailInitBean;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nk.w;
import vj.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b6\u00107J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016J8\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0010H\u0016J\b\u0010\u0019\u001a\u00020\u0002H\u0016J\b\u0010\u001a\u001a\u00020\u0006H\u0016R$\u0010\"\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0017\u0010(\u001a\u00020#8\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\"\u0010/\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0017\u00105\u001a\u0002008\u0006\u00a2\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104\u00a8\u00068"}, d2 = {"Lnk/w;", "Lcom/qzone/reborn/albumx/common/viewmodel/b;", "", "getLogTag", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "m2", "Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", "S1", "", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "b2", "l2", "Lcom/qzone/reborn/albumx/common/bean/a;", "batchBean", "", "batchPos", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", QAdVrReportParams.ParamKey.MEDIA, "mediaPos", "Landroid/widget/ImageView;", "view", "transCreatorKey", ICustomDataEditor.STRING_ARRAY_PARAM_2, "Q1", "c2", "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateAlbumDetailInitBean;", "H", "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateAlbumDetailInitBean;", "k2", "()Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateAlbumDetailInitBean;", "setInitBean", "(Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateAlbumDetailInitBean;)V", "initBean", "Lvj/c;", "I", "Lvj/c;", "i2", "()Lvj/c;", "dataRepo", "J", "Ljava/lang/String;", "j2", "()Ljava/lang/String;", ICustomDataEditor.NUMBER_PARAM_2, "(Ljava/lang/String;)V", "dataRepoKey", "Lvj/c$b;", "K", "Lvj/c$b;", "getListener", "()Lvj/c$b;", "listener", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class w extends com.qzone.reborn.albumx.common.viewmodel.b {

    /* renamed from: H, reason: from kotlin metadata */
    private QZoneIntimateAlbumDetailInitBean initBean;

    /* renamed from: I, reason: from kotlin metadata */
    private final vj.c dataRepo = new vj.c();

    /* renamed from: J, reason: from kotlin metadata */
    private String dataRepoKey = "";

    /* renamed from: K, reason: from kotlin metadata */
    private final c.b listener = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"nk/w$a", "Lvj/c$b;", "Lsj/a;", "repoBean", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class a implements c.b {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(a this$0, sj.a repoBean) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(repoBean, "$repoBean");
            this$0.a(repoBean);
        }

        @Override // vj.c.b
        public void a(final sj.a repoBean) {
            Intrinsics.checkNotNullParameter(repoBean, "repoBean");
            if (!RFWThreadManager.isMainThread()) {
                RFWThreadManager.getUIHandler().post(new Runnable() { // from class: nk.v
                    @Override // java.lang.Runnable
                    public final void run() {
                        w.a.c(w.a.this, repoBean);
                    }
                });
            } else {
                w.this.U1(repoBean);
            }
        }
    }

    @Override // com.qzone.reborn.albumx.common.viewmodel.b
    public String Q1() {
        return this.dataRepo.k();
    }

    @Override // com.qzone.reborn.albumx.common.viewmodel.b
    public LoadInfo S1() {
        return this.dataRepo.getLoadInfo();
    }

    @Override // com.qzone.reborn.albumx.common.viewmodel.b
    public void a2(com.qzone.reborn.albumx.common.bean.a batchBean, int batchPos, CommonStMedia media, int mediaPos, ImageView view, int transCreatorKey) {
        String str;
        String str2;
        String spaceId;
        Intrinsics.checkNotNullParameter(batchBean, "batchBean");
        Intrinsics.checkNotNullParameter(media, "media");
        Intrinsics.checkNotNullParameter(view, "view");
        CommonAlbumInfo value = M1().getValue();
        String str3 = "";
        if (value == null || (str = value.getAlbumId()) == null) {
            str = "";
        }
        batchBean.g(str);
        CommonAlbumInfo value2 = M1().getValue();
        if (value2 == null || (str2 = value2.getName()) == null) {
            str2 = "";
        }
        batchBean.h(str2);
        QZoneIntimateAlbumDetailInitBean qZoneIntimateAlbumDetailInitBean = this.initBean;
        if (qZoneIntimateAlbumDetailInitBean != null) {
            qZoneIntimateAlbumDetailInitBean.setClickMediaPos(this.dataRepo.c(batchBean.getBatchInfo().getLinkId(), k9.b.f411905a.a(media)));
        }
        QZoneIntimateAlbumDetailInitBean qZoneIntimateAlbumDetailInitBean2 = this.initBean;
        if (qZoneIntimateAlbumDetailInitBean2 != null) {
            qZoneIntimateAlbumDetailInitBean2.setDataRepoKey(this.dataRepoKey);
        }
        view.setTag(R.id.f100755tc, Integer.valueOf(transCreatorKey));
        sj.g gVar = sj.g.f433870a;
        Context context = view.getContext();
        vj.d dVar = vj.d.f441734a;
        QZoneIntimateAlbumDetailInitBean qZoneIntimateAlbumDetailInitBean3 = this.initBean;
        if (qZoneIntimateAlbumDetailInitBean3 != null && (spaceId = qZoneIntimateAlbumDetailInitBean3.getSpaceId()) != null) {
            str3 = spaceId;
        }
        QZoneIntimateAlbumDetailInitBean qZoneIntimateAlbumDetailInitBean4 = this.initBean;
        gVar.h(context, view, mediaPos, dVar.c(str3, qZoneIntimateAlbumDetailInitBean4 != null ? qZoneIntimateAlbumDetailInitBean4.getSpaceType() : 0), batchBean, l2(), this.initBean);
    }

    @Override // com.qzone.reborn.albumx.common.viewmodel.b
    public void b2(boolean isLoadMore) {
        QZoneIntimateAlbumDetailInitBean qZoneIntimateAlbumDetailInitBean = this.initBean;
        if (qZoneIntimateAlbumDetailInitBean != null) {
            qZoneIntimateAlbumDetailInitBean.setViewModelHashCode(hashCode());
            this.dataRepo.C(qZoneIntimateAlbumDetailInitBean);
        }
        this.dataRepo.l().add(this.listener);
        this.dataRepo.u(isLoadMore);
    }

    @Override // com.qzone.reborn.albumx.common.viewmodel.b
    public void c2() {
        this.dataRepo.x(hashCode());
    }

    @Override // com.qzone.reborn.albumx.common.viewmodel.b, com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return "QZoneIntimateAlbumDetailViewModel";
    }

    /* renamed from: i2, reason: from getter */
    public final vj.c getDataRepo() {
        return this.dataRepo;
    }

    /* renamed from: j2, reason: from getter */
    public final String getDataRepoKey() {
        return this.dataRepoKey;
    }

    /* renamed from: k2, reason: from getter */
    public final QZoneIntimateAlbumDetailInitBean getInitBean() {
        return this.initBean;
    }

    public String l2() {
        return "";
    }

    public final void n2(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.dataRepoKey = str;
    }

    public final void m2(Activity activity) {
        Intent intent;
        Bundle extras;
        if (activity == null || (intent = activity.getIntent()) == null || (extras = intent.getExtras()) == null || !extras.containsKey("key_bundle_common_init_bean")) {
            return;
        }
        Serializable serializable = extras.getSerializable("key_bundle_common_init_bean");
        Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type com.qzone.reborn.intimate.bean.init.QZoneIntimateAlbumDetailInitBean");
        this.initBean = (QZoneIntimateAlbumDetailInitBean) serializable;
    }
}
