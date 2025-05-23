package dd;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import ch.j;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.business.qboss.QbossAdvDesc;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.aj;
import com.qzone.common.friend.business.model.Friend;
import com.qzone.misc.network.qboss.model.QBossDBData;
import com.qzone.reborn.base.n;
import com.qzone.reborn.comment.bean.QZoneCommentCacheData;
import com.qzone.reborn.comment.bean.QZoneCommentPanelParams;
import com.qzone.reborn.comment.utils.cachedata.QZoneCommentCacheDataHelper;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bC\u0010DJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\b\u001a\u00020\u0006J\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\u000bJ\u0010\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0014\u001a\u00020\u0006J\u0006\u0010\u0015\u001a\u00020\u0006J\u000e\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u000bJ\u000e\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u000bR\"\u0010 \u001a\u00020\u00198\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR0\u0010)\u001a\u0010\u0012\f\u0012\n \"*\u0004\u0018\u00010\u00020\u00020!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0016\u0010,\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\"\u00104\u001a\u00020-8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R2\u0010=\u001a\u0012\u0012\u0004\u0012\u00020\u001105j\b\u0012\u0004\u0012\u00020\u0011`68\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<RJ\u0010B\u001a\u0012\u0012\u0004\u0012\u00020\u000205j\b\u0012\u0004\u0012\u00020\u0002`62\u0016\u0010>\u001a\u0012\u0012\u0004\u0012\u00020\u000205j\b\u0012\u0004\u0012\u00020\u0002`68\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b?\u00108\u001a\u0004\b@\u0010:\"\u0004\bA\u0010<\u00a8\u0006E"}, d2 = {"Ldd/b;", "Lcom/qzone/reborn/base/n;", "", "getLogTag", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "Z1", "initData", "Lcom/qzone/reborn/comment/bean/QZoneCommentCacheData;", "S1", "", QBossDBData.QBOSS_ID, "Lcom/qzone/business/qboss/QbossAdvDesc;", "W1", "content", "P1", "Lcom/qzone/common/friend/business/model/Friend;", QCircleAlphaUserReporter.KEY_USER, "M1", "N1", ICustomDataEditor.STRING_ARRAY_PARAM_2, "saveMode", "e2", "O1", "Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;", "i", "Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;", "T1", "()Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;", "c2", "(Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;)V", "initParams", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "U1", "()Landroidx/lifecycle/MutableLiveData;", "setInputContent", "(Landroidx/lifecycle/MutableLiveData;)V", "inputContent", BdhLogUtil.LogTag.Tag_Conn, "I", "initMaxInputLength", "", "D", "Z", "X1", "()Z", "d2", "(Z)V", "isInputAtByUser", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "E", "Ljava/util/ArrayList;", "Q1", "()Ljava/util/ArrayList;", "setAtUserList", "(Ljava/util/ArrayList;)V", "atUserList", "value", UserInfo.SEX_FEMALE, "R1", "b2", "commentPics", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b extends n {

    /* renamed from: C, reason: from kotlin metadata */
    private int initMaxInputLength;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isInputAtByUser;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public QZoneCommentPanelParams initParams;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private MutableLiveData<String> inputContent = new MutableLiveData<>("");

    /* renamed from: E, reason: from kotlin metadata */
    private ArrayList<Friend> atUserList = new ArrayList<>();

    /* renamed from: F, reason: from kotlin metadata */
    private ArrayList<String> commentPics = new ArrayList<>();

    public final void M1(Friend user) {
        Intrinsics.checkNotNullParameter(user, "user");
        this.atUserList.add(user);
    }

    public final void N1() {
        this.atUserList.clear();
    }

    public final void O1(int saveMode) {
        QZoneCommentCacheDataHelper.INSTANCE.a().g("", aj.d(this.atUserList), saveMode);
    }

    public final String P1(String content) {
        return cd.b.b(content, this.atUserList);
    }

    public final ArrayList<Friend> Q1() {
        return this.atUserList;
    }

    public final ArrayList<String> R1() {
        return this.commentPics;
    }

    public final QZoneCommentCacheData S1() {
        String feedsId;
        if (!TextUtils.isEmpty(T1().getCacheUniKey())) {
            feedsId = T1().getCacheUniKey();
        } else if (!TextUtils.isEmpty(T1().getAutoSaveUgcKey())) {
            feedsId = T1().getAutoSaveUgcKey();
        } else {
            feedsId = !TextUtils.isEmpty(T1().getFeedsId()) ? T1().getFeedsId() : null;
        }
        return QZoneCommentCacheDataHelper.INSTANCE.a().d(feedsId);
    }

    public final QZoneCommentPanelParams T1() {
        QZoneCommentPanelParams qZoneCommentPanelParams = this.initParams;
        if (qZoneCommentPanelParams != null) {
            return qZoneCommentPanelParams;
        }
        Intrinsics.throwUninitializedPropertyAccessException("initParams");
        return null;
    }

    public final MutableLiveData<String> U1() {
        return this.inputContent;
    }

    public final QbossAdvDesc W1(int qbossId) {
        return m5.a.H().J(LoginData.getInstance().getUin(), qbossId);
    }

    /* renamed from: X1, reason: from getter */
    public final boolean getIsInputAtByUser() {
        return this.isInputAtByUser;
    }

    public final void a2() {
        T1().setMaxInputLength(this.initMaxInputLength);
    }

    public final void b2(ArrayList<String> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.commentPics.clear();
        this.commentPics.addAll(value);
    }

    public final void c2(QZoneCommentPanelParams qZoneCommentPanelParams) {
        Intrinsics.checkNotNullParameter(qZoneCommentPanelParams, "<set-?>");
        this.initParams = qZoneCommentPanelParams;
    }

    public final void d2(boolean z16) {
        this.isInputAtByUser = z16;
    }

    public final void e2(int saveMode) {
        QZoneCommentCacheDataHelper.INSTANCE.a().g(this.inputContent.getValue(), aj.d(this.atUserList), saveMode);
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneInputViewModel";
    }

    public final void initData() {
        j.l();
    }

    public final void Z1(Activity activity) {
        Intent intent;
        if (activity == null || (intent = activity.getIntent()) == null) {
            return;
        }
        Serializable serializableExtra = intent.getSerializableExtra("qzone_route_bean");
        Intrinsics.checkNotNull(serializableExtra, "null cannot be cast to non-null type com.qzone.reborn.comment.bean.QZoneCommentPanelParams");
        c2((QZoneCommentPanelParams) serializableExtra);
        this.initMaxInputLength = T1().getMaxInputLength();
    }
}
