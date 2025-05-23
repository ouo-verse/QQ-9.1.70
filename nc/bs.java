package nc;

import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonStTimeLineEvent;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u0000 B2\u00020\u0001:\u0001CB\u0007\u00a2\u0006\u0004\b@\u0010AJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0014\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0010\u0010\n\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\u000b\u001a\u00020\u0007J\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R(\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR(\u0010#\u001a\b\u0012\u0004\u0012\u00020\f0\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R(\u0010(\u001a\b\u0012\u0004\u0012\u00020$0\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u001e\u001a\u0004\b&\u0010 \"\u0004\b'\u0010\"R$\u0010/\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00107\u001a\u0002008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u0010?\u001a\u0002088\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>\u00a8\u0006D"}, d2 = {"Lnc/bs;", "Lcom/qzone/reborn/base/n;", "", "getLogTag", "", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStTimeLineEvent;", "timelineEvents", "", ICustomDataEditor.STRING_ARRAY_PARAM_2, "event", "Z1", "W1", "Lza/a;", "eventBean", "X1", "i", "Ljava/lang/String;", "O1", "()Ljava/lang/String;", "T1", "(Ljava/lang/String;)V", "qzoneId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "S1", "()Ljava/util/List;", "setTimelineEvents", "(Ljava/util/List;)V", "Landroidx/lifecycle/MutableLiveData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "M1", "()Landroidx/lifecycle/MutableLiveData;", "setClickedBean", "(Landroidx/lifecycle/MutableLiveData;)V", "clickedBean", "", "D", "R1", "setTimeLineShowState", "timeLineShowState", "E", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStTimeLineEvent;", "N1", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonStTimeLineEvent;", "setCurTimelineEvent", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonStTimeLineEvent;)V", "curTimelineEvent", "", UserInfo.SEX_FEMALE, "I", "Q1", "()I", "U1", "(I)V", "themeType", "Lwa/c;", "G", "Lwa/c;", "P1", "()Lwa/c;", "setReportParams", "(Lwa/c;)V", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "<init>", "()V", "H", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public class bs extends com.qzone.reborn.base.n {

    /* renamed from: E, reason: from kotlin metadata */
    private CommonStTimeLineEvent curTimelineEvent;

    /* renamed from: F, reason: from kotlin metadata */
    private int themeType;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String qzoneId = "";

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private List<CommonStTimeLineEvent> timelineEvents = new ArrayList();

    /* renamed from: C, reason: from kotlin metadata */
    private MutableLiveData<za.a> clickedBean = new MutableLiveData<>();

    /* renamed from: D, reason: from kotlin metadata */
    private MutableLiveData<Boolean> timeLineShowState = new MutableLiveData<>();

    /* renamed from: G, reason: from kotlin metadata */
    private wa.c reportParams = new wa.c();

    public final MutableLiveData<za.a> M1() {
        return this.clickedBean;
    }

    /* renamed from: N1, reason: from getter */
    public final CommonStTimeLineEvent getCurTimelineEvent() {
        return this.curTimelineEvent;
    }

    /* renamed from: O1, reason: from getter */
    public final String getQzoneId() {
        return this.qzoneId;
    }

    /* renamed from: P1, reason: from getter */
    public final wa.c getReportParams() {
        return this.reportParams;
    }

    /* renamed from: Q1, reason: from getter */
    public final int getThemeType() {
        return this.themeType;
    }

    public final MutableLiveData<Boolean> R1() {
        return this.timeLineShowState;
    }

    public final List<CommonStTimeLineEvent> S1() {
        return this.timelineEvents;
    }

    public final void T1(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.qzoneId = str;
    }

    public final void U1(int i3) {
        this.themeType = i3;
    }

    public final void W1() {
        this.timeLineShowState.postValue(Boolean.TRUE);
    }

    public final void X1(za.a eventBean) {
        Intrinsics.checkNotNullParameter(eventBean, "eventBean");
        QLog.i("QZAlbumxTimeLineViewModel", 2, "click event: " + eventBean.getEvent());
        this.timeLineShowState.postValue(Boolean.FALSE);
        this.clickedBean.postValue(eventBean);
    }

    public final void a2(List<CommonStTimeLineEvent> timelineEvents) {
        Intrinsics.checkNotNullParameter(timelineEvents, "timelineEvents");
        List<CommonStTimeLineEvent> list = timelineEvents;
        if (list.isEmpty()) {
            return;
        }
        this.timelineEvents.clear();
        this.timelineEvents.addAll(list);
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return "QZAlbumxTimeLineViewModel";
    }

    public final void Z1(CommonStTimeLineEvent event) {
        if (event == null) {
            return;
        }
        this.curTimelineEvent = event;
    }
}
