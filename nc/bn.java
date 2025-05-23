package nc;

import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxMainPageInitBean;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.AlbumPageInfo;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.qzone.report.lp.QZoneLoginReportHelper;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b6\u0018\u0000 _2\u00020\u0001:\u0001`B\u0007\u00a2\u0006\u0004\b]\u0010^J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\bJ\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0004J\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0004J\u000e\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0004J\u000e\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0002J\u000e\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0017J\u0006\u0010\u001a\u001a\u00020\u0002R\"\u0010!\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R0\u0010*\u001a\u0010\u0012\f\u0012\n #*\u0004\u0018\u00010\n0\n0\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u00102\u001a\u00020+8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R(\u00106\u001a\b\u0012\u0004\u0012\u00020\b0\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010%\u001a\u0004\b4\u0010'\"\u0004\b5\u0010)R$\u0010=\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R$\u0010A\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u00108\u001a\u0004\b?\u0010:\"\u0004\b@\u0010<R$\u0010E\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bB\u00108\u001a\u0004\bC\u0010:\"\u0004\bD\u0010<R(\u0010I\u001a\b\u0012\u0004\u0012\u00020\n0\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bF\u0010%\u001a\u0004\bG\u0010'\"\u0004\bH\u0010)R0\u0010\u0012\u001a\u0010\u0012\f\u0012\n #*\u0004\u0018\u00010\u00020\u00020\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010%\u001a\u0004\bJ\u0010'\"\u0004\bK\u0010)R\u001d\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00140\"8\u0006\u00a2\u0006\f\n\u0004\bL\u0010%\u001a\u0004\bM\u0010'R\u001d\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00020\"8\u0006\u00a2\u0006\f\n\u0004\bO\u0010%\u001a\u0004\bP\u0010'R(\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00170\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bR\u0010%\u001a\u0004\bS\u0010'\"\u0004\bT\u0010)R\"\u0010\\\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[\u00a8\u0006a"}, d2 = {"Lnc/bn;", "Lcom/qzone/reborn/base/n;", "", SemanticAttributes.DbSystemValues.H2, "", "getLogTag", "Landroid/content/Intent;", "intent", "", "l2", "", "index", "x2", "T1", "desc", "p2", "v2", "z2", "canUploadMedia", "t2", "Lcom/tencent/qqnt/kernel/nativeinterface/AlbumPageInfo;", "albumPageInfo", ICustomDataEditor.NUMBER_PARAM_2, "", "curTime", "r2", "k2", "i", "I", "d2", "()I", "setTabIndex", "(I)V", "tabIndex", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "e2", "()Landroidx/lifecycle/MutableLiveData;", "setTabIndexLiveData", "(Landroidx/lifecycle/MutableLiveData;)V", "tabIndexLiveData", "Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxMainPageInitBean;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxMainPageInitBean;", "b2", "()Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxMainPageInitBean;", "m2", "(Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxMainPageInitBean;)V", "mainInitBean", "D", "f2", "setTitleDescChangeLiveData", "titleDescChangeLiveData", "E", "Ljava/lang/String;", "W1", "()Ljava/lang/String;", "setAlbumTabTitleDesc", "(Ljava/lang/String;)V", "albumTabTitleDesc", UserInfo.SEX_FEMALE, "c2", "setPicTabTitleDesc", "picTabTitleDesc", "G", "g2", "setVideoTabTitleDesc", "videoTabTitleDesc", "H", ICustomDataEditor.STRING_ARRAY_PARAM_2, "setClickedIconIndexLiveData", "clickedIconIndexLiveData", "Z1", "setCanUploadMedia", "J", "U1", "albumTabPageInfo", "K", "j2", "isPicListNotEmpty", "L", "X1", "setCalenderTime", "calenderTime", "M", "Z", "i2", "()Z", "setNeedShowEntrance", "(Z)V", "isNeedShowEntrance", "<init>", "()V", "N", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class bn extends com.qzone.reborn.base.n {

    /* renamed from: C, reason: from kotlin metadata */
    public QZAlbumxMainPageInitBean mainInitBean;

    /* renamed from: E, reason: from kotlin metadata */
    private String albumTabTitleDesc;

    /* renamed from: F, reason: from kotlin metadata */
    private String picTabTitleDesc;

    /* renamed from: G, reason: from kotlin metadata */
    private String videoTabTitleDesc;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean isNeedShowEntrance;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int tabIndex;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private MutableLiveData<Integer> tabIndexLiveData = new MutableLiveData<>(0);

    /* renamed from: D, reason: from kotlin metadata */
    private MutableLiveData<Unit> titleDescChangeLiveData = new MutableLiveData<>();

    /* renamed from: H, reason: from kotlin metadata */
    private MutableLiveData<Integer> clickedIconIndexLiveData = new MutableLiveData<>();

    /* renamed from: I, reason: from kotlin metadata */
    private MutableLiveData<Boolean> canUploadMedia = new MutableLiveData<>(Boolean.FALSE);

    /* renamed from: J, reason: from kotlin metadata */
    private final MutableLiveData<AlbumPageInfo> albumTabPageInfo = new MutableLiveData<>();

    /* renamed from: K, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> isPicListNotEmpty = new MutableLiveData<>();

    /* renamed from: L, reason: from kotlin metadata */
    private MutableLiveData<Long> calenderTime = new MutableLiveData<>();

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A2(bn this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.titleDescChangeLiveData.postValue(Unit.INSTANCE);
    }

    private final boolean h2() {
        return !Intrinsics.areEqual(LoginData.getInstance().getUinString(), b2().getUin());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o2(bn this$0, AlbumPageInfo albumPageInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(albumPageInfo, "$albumPageInfo");
        this$0.albumTabPageInfo.postValue(albumPageInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q2(bn this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.titleDescChangeLiveData.postValue(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s2(bn this$0, long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.calenderTime.postValue(Long.valueOf(j3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u2(bn this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.canUploadMedia.postValue(Boolean.valueOf(z16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w2(bn this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.titleDescChangeLiveData.postValue(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y2(bn this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.tabIndexLiveData.postValue(Integer.valueOf(this$0.tabIndex));
    }

    public final void T1() {
        this.clickedIconIndexLiveData.postValue(Integer.valueOf(this.tabIndex));
    }

    public final MutableLiveData<AlbumPageInfo> U1() {
        return this.albumTabPageInfo;
    }

    /* renamed from: W1, reason: from getter */
    public final String getAlbumTabTitleDesc() {
        return this.albumTabTitleDesc;
    }

    public final MutableLiveData<Long> X1() {
        return this.calenderTime;
    }

    public final MutableLiveData<Boolean> Z1() {
        return this.canUploadMedia;
    }

    public final MutableLiveData<Integer> a2() {
        return this.clickedIconIndexLiveData;
    }

    public final QZAlbumxMainPageInitBean b2() {
        QZAlbumxMainPageInitBean qZAlbumxMainPageInitBean = this.mainInitBean;
        if (qZAlbumxMainPageInitBean != null) {
            return qZAlbumxMainPageInitBean;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mainInitBean");
        return null;
    }

    /* renamed from: c2, reason: from getter */
    public final String getPicTabTitleDesc() {
        return this.picTabTitleDesc;
    }

    /* renamed from: d2, reason: from getter */
    public final int getTabIndex() {
        return this.tabIndex;
    }

    public final MutableLiveData<Integer> e2() {
        return this.tabIndexLiveData;
    }

    public final MutableLiveData<Unit> f2() {
        return this.titleDescChangeLiveData;
    }

    /* renamed from: g2, reason: from getter */
    public final String getVideoTabTitleDesc() {
        return this.videoTabTitleDesc;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return "QZAlbumxMainPageTabView";
    }

    /* renamed from: i2, reason: from getter */
    public final boolean getIsNeedShowEntrance() {
        return this.isNeedShowEntrance;
    }

    public final MutableLiveData<Boolean> j2() {
        return this.isPicListNotEmpty;
    }

    public final boolean k2() {
        boolean c16 = com.qzone.reborn.albumx.qzone.local.g.f52662a.c();
        boolean h26 = h2();
        QLog.d("QZAlbumxMainPageTabView", 1, "[isNeedShowLocalPhotoTab] isNeedShowLocalPhotoTab = " + c16 + ", isGuest = " + h26);
        return !h26 && c16;
    }

    public final void m2(QZAlbumxMainPageInitBean qZAlbumxMainPageInitBean) {
        Intrinsics.checkNotNullParameter(qZAlbumxMainPageInitBean, "<set-?>");
        this.mainInitBean = qZAlbumxMainPageInitBean;
    }

    public final void n2(final AlbumPageInfo albumPageInfo) {
        Intrinsics.checkNotNullParameter(albumPageInfo, "albumPageInfo");
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: nc.bi
            @Override // java.lang.Runnable
            public final void run() {
                bn.o2(bn.this, albumPageInfo);
            }
        });
    }

    public final void p2(String desc) {
        Intrinsics.checkNotNullParameter(desc, "desc");
        this.albumTabTitleDesc = desc;
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: nc.bj
            @Override // java.lang.Runnable
            public final void run() {
                bn.q2(bn.this);
            }
        });
    }

    public final void r2(final long curTime) {
        Long value = this.calenderTime.getValue();
        if (value != null && curTime == value.longValue()) {
            return;
        }
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: nc.bh
            @Override // java.lang.Runnable
            public final void run() {
                bn.s2(bn.this, curTime);
            }
        });
    }

    public final void t2(final boolean canUploadMedia) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: nc.bk
            @Override // java.lang.Runnable
            public final void run() {
                bn.u2(bn.this, canUploadMedia);
            }
        });
    }

    public final void v2(String desc) {
        Intrinsics.checkNotNullParameter(desc, "desc");
        this.picTabTitleDesc = desc;
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: nc.bm
            @Override // java.lang.Runnable
            public final void run() {
                bn.w2(bn.this);
            }
        });
    }

    public final void x2(int index) {
        this.tabIndex = index;
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: nc.bg
            @Override // java.lang.Runnable
            public final void run() {
                bn.y2(bn.this);
            }
        });
    }

    public final void z2(String desc) {
        Intrinsics.checkNotNullParameter(desc, "desc");
        this.videoTabTitleDesc = desc;
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: nc.bl
            @Override // java.lang.Runnable
            public final void run() {
                bn.A2(bn.this);
            }
        });
    }

    public final void l2(Intent intent) {
        Bundle extras;
        if (intent == null || (extras = intent.getExtras()) == null) {
            return;
        }
        if (extras.containsKey("key_bundle_common_init_bean")) {
            Serializable serializable = extras.getSerializable("key_bundle_common_init_bean");
            Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxMainPageInitBean");
            m2((QZAlbumxMainPageInitBean) serializable);
            this.tabIndex = b2().getTabIndex();
        }
        if (extras.containsKey(QZoneLoginReportHelper.KEY_LOGIN_FROM_MQQ)) {
            this.isNeedShowEntrance = 5 == extras.getInt(QZoneLoginReportHelper.KEY_LOGIN_FROM_MQQ, -1);
        }
    }
}
