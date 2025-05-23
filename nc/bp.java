package nc;

import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonStTimeLineEvent;
import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxMainPageInitBean;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.oskplayer.proxy.VideoProxy;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ub.p;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u0000 Q2\u00020\u0001:\u0001RB\u0007\u00a2\u0006\u0004\bO\u0010PJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\rJ\u001a\u0010\u0011\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\rJ\u0006\u0010\u0012\u001a\u00020\u0004J\u0006\u0010\u0013\u001a\u00020\u0004J\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014J\b\u0010\u0018\u001a\u00020\u0017H&R\"\u0010\u001f\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010#\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u001a\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR.\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020%0$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R(\u00101\u001a\b\u0012\u0004\u0012\u00020-0$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010'\u001a\u0004\b/\u0010)\"\u0004\b0\u0010+R(\u00105\u001a\b\u0012\u0004\u0012\u00020\r0$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010'\u001a\u0004\b3\u0010)\"\u0004\b4\u0010+R\"\u00108\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\"\u0010B\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR$\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u0017\u0010N\u001a\u00020I8\u0006\u00a2\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\u00a8\u0006S"}, d2 = {"Lnc/bp;", "Lcom/qzone/reborn/base/n;", "Lcb/a;", "repoBean", "", "d2", "e2", "", "getLogTag", "Landroid/content/Intent;", "intent", "O1", "f2", "", "Z1", "isNeedScrollToFirst", VideoProxy.PARAM_ENABLE_CACHE, "P1", "c2", "b2", "Lza/a;", "curTimelineBean", ICustomDataEditor.STRING_ARRAY_PARAM_2, "Lub/p;", "U1", "i", "Ljava/lang/String;", "getUin", "()Ljava/lang/String;", "setUin", "(Ljava/lang/String;)V", "uin", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "S1", "g2", "dataRepoKey", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/richframework/data/base/UIStateData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "W1", "()Landroidx/lifecycle/MutableLiveData;", "setMediaStateData", "(Landroidx/lifecycle/MutableLiveData;)V", "mediaStateData", "Lcb/b;", "D", "R1", "setCurTitleBean", "curTitleBean", "E", "T1", "setListEmptyData", "listEmptyData", UserInfo.SEX_FEMALE, "Z", "isTimeLine", "()Z", "setTimeLine", "(Z)V", "G", "Lub/p;", "X1", "()Lub/p;", "setRepo", "(Lub/p;)V", "repo", "H", "Lza/a;", "getCurTimelineBean", "()Lza/a;", "setCurTimelineBean", "(Lza/a;)V", "Lub/p$b;", "I", "Lub/p$b;", "getListener", "()Lub/p$b;", "listener", "<init>", "()V", "J", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public abstract class bp extends com.qzone.reborn.base.n {

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isTimeLine;

    /* renamed from: H, reason: from kotlin metadata */
    private za.a curTimelineBean;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String uin = "";

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private String dataRepoKey = "";

    /* renamed from: C, reason: from kotlin metadata */
    private MutableLiveData<UIStateData<cb.a>> mediaStateData = new MutableLiveData<>();

    /* renamed from: D, reason: from kotlin metadata */
    private MutableLiveData<cb.b> curTitleBean = new MutableLiveData<>();

    /* renamed from: E, reason: from kotlin metadata */
    private MutableLiveData<Boolean> listEmptyData = new MutableLiveData<>();

    /* renamed from: G, reason: from kotlin metadata */
    private ub.p repo = U1();

    /* renamed from: I, reason: from kotlin metadata */
    private final p.b listener = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"nc/bp$b", "Lub/p$b;", "Lcb/a;", "repoBean", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b implements p.b {
        b() {
        }

        @Override // ub.p.b
        public void a(cb.a repoBean) {
            Intrinsics.checkNotNullParameter(repoBean, "repoBean");
            if (repoBean.getIsInformLayerOnly()) {
                return;
            }
            if (repoBean.getResult() != 0) {
                bp.this.d2(repoBean);
            } else {
                bp.this.e2(repoBean);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d2(cb.a repoBean) {
        this.mediaStateData.postValue(UIStateData.obtainError(repoBean.getErrMsg()).setRetCode(0L).setLoadMore(!repoBean.q()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e2(cb.a repoBean) {
        this.mediaStateData.postValue(UIStateData.obtainSuccess(false).setData(!repoBean.q(), repoBean).setLatestModifyRecord(UIStateData.ModifyListRecord.obtainNotifyDataSetChanged()).setFinish(!this.repo.getNextHasMore()));
    }

    public final void O1(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Bundle extras = intent.getExtras();
        if (extras != null && extras.containsKey("key_bundle_common_init_bean")) {
            Serializable serializable = extras.getSerializable("key_bundle_common_init_bean");
            Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxMainPageInitBean");
            this.uin = ((QZAlbumxMainPageInitBean) serializable).getUin();
        }
        RFWLog.d("QZAlbumxTabBaseMediaViewModel", RFWLog.USR, "[doInit] qzoneId:" + this.uin);
        this.repo.o(this.uin);
        this.repo.s(this.listener);
    }

    public final MutableLiveData<cb.b> R1() {
        return this.curTitleBean;
    }

    /* renamed from: S1, reason: from getter */
    public final String getDataRepoKey() {
        return this.dataRepoKey;
    }

    public final MutableLiveData<Boolean> T1() {
        return this.listEmptyData;
    }

    public abstract ub.p U1();

    public final MutableLiveData<UIStateData<cb.a>> W1() {
        return this.mediaStateData;
    }

    /* renamed from: X1, reason: from getter */
    public final ub.p getRepo() {
        return this.repo;
    }

    public final boolean Z1() {
        return this.repo.getPrevHasMore();
    }

    public final void a2(za.a curTimelineBean) {
        Intrinsics.checkNotNullParameter(curTimelineBean, "curTimelineBean");
        if (curTimelineBean.getEvent() != null) {
            this.isTimeLine = true;
            this.curTimelineBean = curTimelineBean;
            ub.p pVar = this.repo;
            CommonStTimeLineEvent event = curTimelineBean.getEvent();
            Intrinsics.checkNotNull(event);
            pVar.y(1, event);
        }
    }

    public final void b2() {
        if (this.repo.getNextHasMore()) {
            if (this.isTimeLine) {
                za.a aVar = this.curTimelineBean;
                if ((aVar != null ? aVar.getEvent() : null) != null) {
                    ub.p pVar = this.repo;
                    za.a aVar2 = this.curTimelineBean;
                    CommonStTimeLineEvent event = aVar2 != null ? aVar2.getEvent() : null;
                    Intrinsics.checkNotNull(event);
                    pVar.y(2, event);
                    return;
                }
            }
            this.repo.x(2, false, false);
        }
    }

    public final void c2() {
        za.a aVar = this.curTimelineBean;
        if ((aVar != null ? aVar.getEvent() : null) != null) {
            this.isTimeLine = true;
            ub.p pVar = this.repo;
            za.a aVar2 = this.curTimelineBean;
            CommonStTimeLineEvent event = aVar2 != null ? aVar2.getEvent() : null;
            Intrinsics.checkNotNull(event);
            pVar.y(3, event);
        }
    }

    public final void f2() {
        if (this.repo.getPrevHasMore()) {
            c2();
        } else {
            Q1(this, false, false, 3, null);
        }
    }

    public final void g2(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.dataRepoKey = str;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return "QZAlbumxTabBaseMediaViewModel";
    }

    public final String getUin() {
        return this.uin;
    }

    public final void P1(boolean isNeedScrollToFirst, boolean enableCache) {
        this.isTimeLine = false;
        this.curTimelineBean = null;
        this.repo.G(false, null);
        this.repo.x(1, enableCache, isNeedScrollToFirst);
    }

    public static /* synthetic */ void Q1(bp bpVar, boolean z16, boolean z17, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                z16 = false;
            }
            if ((i3 & 2) != 0) {
                z17 = false;
            }
            bpVar.P1(z16, z17);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: doRefresh");
    }
}
