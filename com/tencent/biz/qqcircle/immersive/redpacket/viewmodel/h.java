package com.tencent.biz.qqcircle.immersive.redpacket.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.immersive.redpacket.bean.QFSRedPacketClipBean;
import com.tencent.biz.qqcircle.immersive.redpacket.bean.QFSRedPacketPreviewBean;
import com.tencent.biz.qqcircle.immersive.redpacket.task.AddRedPacketCoverData;
import com.tencent.biz.qqcircle.immersive.redpacket.task.ErrorCode;
import com.tencent.biz.qqcircle.immersive.redpacket.task.o;
import com.tencent.biz.qqcircle.immersive.redpacket.viewmodel.MakeRedPacketResult;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudDatacard$RedPocketCoverInfo;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 .2\u00020\u0001:\u0001/B\u0007\u00a2\u0006\u0004\b,\u0010-J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u000e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fJ\u0016\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0015\u001a\u00020\u0002R$\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00168\u0006@BX\u0086.\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001e0\"8\u0006\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u00060"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/redpacket/viewmodel/h;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "Q1", "Lfeedcloud/FeedCloudDatacard$RedPocketCoverInfo;", "coverInfo", "R1", "", "getLogTag", "Landroid/content/Intent;", "intent", "S1", "Landroid/content/Context;", "context", "W1", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "startTime", "T1", "U1", "N1", "Lcom/tencent/biz/qqcircle/immersive/redpacket/bean/QFSRedPacketPreviewBean;", "<set-?>", "i", "Lcom/tencent/biz/qqcircle/immersive/redpacket/bean/QFSRedPacketPreviewBean;", "P1", "()Lcom/tencent/biz/qqcircle/immersive/redpacket/bean/QFSRedPacketPreviewBean;", "previewBean", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/biz/qqcircle/immersive/redpacket/viewmodel/MakeRedPacketResult;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "_makeRedPacketResult", "Landroidx/lifecycle/LiveData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/LiveData;", "O1", "()Landroidx/lifecycle/LiveData;", "makeRedPacketResult", "Lcom/tencent/biz/qqcircle/immersive/redpacket/task/c;", "D", "Lcom/tencent/biz/qqcircle/immersive/redpacket/task/c;", "addRedPacketCoverTask", "<init>", "()V", "E", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class h extends BaseViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final LiveData<MakeRedPacketResult> makeRedPacketResult;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private com.tencent.biz.qqcircle.immersive.redpacket.task.c addRedPacketCoverTask;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QFSRedPacketPreviewBean previewBean;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<MakeRedPacketResult> _makeRedPacketResult;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/biz/qqcircle/immersive/redpacket/viewmodel/h$b", "Lcom/tencent/biz/qqcircle/immersive/redpacket/task/o;", "Lcom/tencent/biz/qqcircle/immersive/redpacket/task/a;", "value", "", "b", "Lcom/tencent/biz/qqcircle/immersive/redpacket/task/k;", "errorCode", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b implements o<AddRedPacketCoverData> {
        b() {
        }

        @Override // com.tencent.biz.qqcircle.immersive.redpacket.task.o
        public void a(@NotNull ErrorCode errorCode) {
            Intrinsics.checkNotNullParameter(errorCode, "errorCode");
            QLog.d("QFSRedPacketPreviewViewModel", 1, "startMake, onError, errorCode:" + errorCode);
            h.this.Q1();
        }

        @Override // com.tencent.biz.qqcircle.immersive.redpacket.task.o
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull AddRedPacketCoverData value) {
            Intrinsics.checkNotNullParameter(value, "value");
            QLog.d("QFSRedPacketPreviewViewModel", 1, "startMake, onSuccess, value:" + value);
            FeedCloudDatacard$RedPocketCoverInfo coverInfo = value.getCoverInfo();
            if (coverInfo == null) {
                h.this.Q1();
            } else {
                h.this.R1(coverInfo);
            }
        }
    }

    public h() {
        MutableLiveData<MakeRedPacketResult> mutableLiveData = new MutableLiveData<>();
        this._makeRedPacketResult = mutableLiveData;
        this.makeRedPacketResult = mutableLiveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q1() {
        this._makeRedPacketResult.postValue(new MakeRedPacketResult(MakeRedPacketResult.State.FAILED, null, null, 0, 14, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x001c, code lost:
    
        r1 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void R1(FeedCloudDatacard$RedPocketCoverInfo coverInfo) {
        int i3;
        Integer intOrNull;
        MutableLiveData<MakeRedPacketResult> mutableLiveData = this._makeRedPacketResult;
        MakeRedPacketResult.State state = MakeRedPacketResult.State.SUCCEED;
        HashMap<String, String> schemeAttrs = P1().getSchemeAttrs();
        if (schemeAttrs != null && (r1 = schemeAttrs.get(QCircleScheme.AttrRedPacket.RED_ENVELOPE_ENTRANCE)) != null && intOrNull != null) {
            i3 = intOrNull.intValue();
        } else {
            i3 = 0;
        }
        mutableLiveData.postValue(new MakeRedPacketResult(state, null, coverInfo, i3, 2, null));
    }

    public final void N1() {
        com.tencent.biz.qqcircle.immersive.redpacket.task.c cVar = this.addRedPacketCoverTask;
        if (cVar != null) {
            cVar.f();
        }
    }

    @NotNull
    public final LiveData<MakeRedPacketResult> O1() {
        return this.makeRedPacketResult;
    }

    @NotNull
    public final QFSRedPacketPreviewBean P1() {
        QFSRedPacketPreviewBean qFSRedPacketPreviewBean = this.previewBean;
        if (qFSRedPacketPreviewBean != null) {
            return qFSRedPacketPreviewBean;
        }
        Intrinsics.throwUninitializedPropertyAccessException("previewBean");
        return null;
    }

    public final void S1(@Nullable Intent intent) {
        QFSRedPacketPreviewBean qFSRedPacketPreviewBean;
        if (intent == null) {
            QLog.w("QFSRedPacketPreviewViewModel", 1, "initData, intent is null ");
            return;
        }
        Serializable serializableExtra = intent.getSerializableExtra("key_bundle_common_init_bean");
        if (serializableExtra instanceof QFSRedPacketPreviewBean) {
            qFSRedPacketPreviewBean = (QFSRedPacketPreviewBean) serializableExtra;
        } else {
            qFSRedPacketPreviewBean = null;
        }
        if (qFSRedPacketPreviewBean == null) {
            QLog.w("QFSRedPacketPreviewViewModel", 1, "initData, initBean is null ");
        } else {
            this.previewBean = qFSRedPacketPreviewBean;
        }
    }

    public final void T1(@NotNull Activity activity, long startTime) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        com.tencent.biz.qqcircle.launcher.c.u0(activity, new QFSRedPacketClipBean(P1().getLocalVideoPath(), startTime, 0L, null, false, false, null, 124, null));
    }

    public final void U1(long startTime) {
        this._makeRedPacketResult.postValue(new MakeRedPacketResult(MakeRedPacketResult.State.LOADING, null, null, 0, 14, null));
        N1();
        com.tencent.biz.qqcircle.immersive.redpacket.task.c cVar = new com.tencent.biz.qqcircle.immersive.redpacket.task.c();
        this.addRedPacketCoverTask = cVar;
        cVar.n(new AddRedPacketCoverData(startTime, P1(), null, null, null, null, null, 124, null), new b());
    }

    public final void W1(@NotNull Context context) {
        String str;
        boolean z16;
        Intrinsics.checkNotNullParameter(context, "context");
        com.tencent.biz.qqcircle.immersive.redpacket.util.d dVar = com.tencent.biz.qqcircle.immersive.redpacket.util.d.f89585a;
        HashMap hashMap = new HashMap();
        hashMap.put(QCircleScheme.AttrDetail.SHOULD_REUSE_EXISTED_PAGE, "1");
        HashMap<String, String> schemeAttrs = P1().getSchemeAttrs();
        if (schemeAttrs != null) {
            str = schemeAttrs.get(QCircleScheme.AttrRedPacket.RED_ENVELOPE_ENTRANCE);
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            hashMap.put(QCircleScheme.AttrRedPacket.RED_ENVELOPE_ENTRANCE, str);
        }
        hashMap.put("taskid", "qqhongbao-1");
        Unit unit = Unit.INSTANCE;
        com.tencent.biz.qqcircle.immersive.redpacket.util.d.g(dVar, context, null, hashMap, 2, null);
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    public String getLogTag() {
        return "QFSRedPacketPreviewViewModel";
    }
}
