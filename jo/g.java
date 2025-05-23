package jo;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u0000 #2\u00020\u0001:\u0002*\u0014B\u000f\u0012\u0006\u00100\u001a\u00020\u0005\u00a2\u0006\u0004\bJ\u0010/J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\bH\u0002J\u0010\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0018\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u0005J\b\u0010\u0015\u001a\u00020\u0000H\u0004J\u000e\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0005J\u0006\u0010\u001a\u001a\u00020\nJ\u0006\u0010\u001b\u001a\u00020\bJ\u000e\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u0005J\u000e\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u0005J\u000e\u0010 \u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u0005J!\u0010#\u001a\u00020\u00002\u0012\u0010\"\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050!\"\u00020\u0005\u00a2\u0006\u0004\b#\u0010$J\u0018\u0010&\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u00052\b\b\u0002\u0010%\u001a\u00020\u0005J\u000e\u0010)\u001a\u00020\u00002\u0006\u0010(\u001a\u00020'R\"\u00100\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0016\u00101\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010+R\u0016\u00104\u001a\u0002028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u00103R\u001a\u00108\u001a\b\u0012\u0004\u0012\u00020\u0016058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0014\u0010;\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010:R2\u0010?\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020<j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0002`=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010>R2\u0010A\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100<j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0010`=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010>R\u001e\u0010C\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010BR\"\u0010I\u001a\u00020'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010H\u00a8\u0006K"}, d2 = {"Ljo/g;", "", "Ljo/e;", "node", "c", "", DomainData.DOMAIN_NAME, "nodeName", "", "i", "", "v", "", QCircleWeakNetReporter.KEY_COST, "u", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Ljo/f;", "step", "f", "nodeDesc", "b", "w", "Ljo/g$b;", "resultHandler", tl.h.F, "t", "l", "r", "msg", ReportConstant.COSTREPORT_PREFIX, "stepName", HippyTKDListViewAdapter.X, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "lastNodeArr", "j", "([Ljava/lang/String;)Ljo/g;", "stepDesc", "e", "", "streamType", "k", "a", "Ljava/lang/String;", "o", "()Ljava/lang/String;", "setMStreamName", "(Ljava/lang/String;)V", "mStreamName", "mSessionId", "Ljo/a;", "Ljo/a;", "mStreamResult", "", "d", "Ljava/util/List;", "mResultHandlerList", "Ljo/c;", "Ljo/c;", "mConfig", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "Ljava/util/LinkedHashMap;", "mNodeMap", "g", "mStepMap", "[Ljava/lang/String;", "mLastNodeArr", "I", "p", "()I", "setMStreamType", "(I)V", "mStreamType", "<init>", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public class g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String mStreamName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String mSessionId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private a mStreamResult;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final List<b> mResultHandlerList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final c mConfig;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private LinkedHashMap<String, e> mNodeMap;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private LinkedHashMap<String, f> mStepMap;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String[] mLastNodeArr;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mStreamType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Ljo/g$b;", "", "Ljo/a;", "streamResult", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public interface b {
        void a(a streamResult);
    }

    public g(String mStreamName) {
        Intrinsics.checkNotNullParameter(mStreamName, "mStreamName");
        this.mStreamName = mStreamName;
        this.mSessionId = "";
        this.mStreamResult = new a();
        this.mResultHandlerList = new ArrayList();
        this.mConfig = new c();
        this.mNodeMap = new LinkedHashMap<>();
        this.mStepMap = new LinkedHashMap<>();
        this.mLastNodeArr = new String[0];
    }

    private final g c(e node) {
        if (this.mNodeMap.containsKey(node.getNodeName())) {
            s("addNode error, node exist");
            return this;
        }
        this.mNodeMap.put(node.getNodeName(), node);
        return this;
    }

    private final g f(f step) {
        this.mStepMap.put(step.getStepName(), step);
        return this;
    }

    private final boolean i(String nodeName) {
        boolean contains;
        Object last;
        String[] strArr = this.mLastNodeArr;
        if (!(strArr.length == 0)) {
            contains = ArraysKt___ArraysKt.contains(strArr, nodeName);
            if (!contains) {
                return false;
            }
            for (String str : this.mLastNodeArr) {
                e eVar = this.mNodeMap.get(str);
                if (eVar != null && eVar.getNodeTime() <= 0) {
                    return false;
                }
            }
            return true;
        }
        Set<String> keySet = this.mNodeMap.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "mNodeMap.keys");
        last = CollectionsKt___CollectionsKt.last(keySet);
        return Intrinsics.areEqual(nodeName, last);
    }

    private final String n() {
        return System.currentTimeMillis() + "_" + hashCode();
    }

    private final boolean q() {
        return this.mSessionId.length() == 0;
    }

    private final void u(long cost) {
        s("stream end");
        Collection<e> values = this.mNodeMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "mNodeMap.values");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            ((e) it.next()).e();
        }
        Collection<f> values2 = this.mStepMap.values();
        Intrinsics.checkNotNullExpressionValue(values2, "mStepMap.values");
        Iterator<T> it5 = values2.iterator();
        while (it5.hasNext()) {
            ((f) it5.next()).f();
        }
        this.mStreamResult.e(cost);
        this.mStreamResult.c(this.mSessionId);
        this.mStreamResult.d(this.mStreamName);
        Iterator<T> it6 = this.mResultHandlerList.iterator();
        while (it6.hasNext()) {
            ((b) it6.next()).a(this.mStreamResult);
        }
        this.mSessionId = "";
    }

    private final void v() {
        this.mSessionId = n();
        this.mStreamResult = new a();
        s("stream start");
    }

    public final g b(String nodeName, String nodeDesc) {
        Intrinsics.checkNotNullParameter(nodeName, "nodeName");
        Intrinsics.checkNotNullParameter(nodeDesc, "nodeDesc");
        c(new e(nodeName, nodeDesc));
        return this;
    }

    public final g e(String stepName, String stepDesc) {
        Intrinsics.checkNotNullParameter(stepName, "stepName");
        Intrinsics.checkNotNullParameter(stepDesc, "stepDesc");
        f(new f(stepName, stepDesc));
        return this;
    }

    public final void h(b resultHandler) {
        Intrinsics.checkNotNullParameter(resultHandler, "resultHandler");
        this.mResultHandlerList.add(resultHandler);
    }

    public final g j(String... lastNodeArr) {
        Intrinsics.checkNotNullParameter(lastNodeArr, "lastNodeArr");
        this.mLastNodeArr = lastNodeArr;
        return this;
    }

    public final g k(int streamType) {
        this.mStreamType = streamType;
        return this;
    }

    public final void l() {
        if (q()) {
            return;
        }
        u(0L);
    }

    public final void m(String stepName) {
        Intrinsics.checkNotNullParameter(stepName, "stepName");
        f fVar = this.mStepMap.get(stepName);
        if (fVar != null) {
            if (fVar.getStart() <= 0) {
                s(stepName + ", " + fVar.getStepDesc() + " have not call start method");
                return;
            }
            fVar.h(System.currentTimeMillis());
            fVar.g(fVar.getEnd() - fVar.getStart());
            s(stepName + ", " + fVar.getStepDesc() + " cost " + fVar.getCooperation.qqcircle.report.QCircleWeakNetReporter.KEY_COST java.lang.String() + " ms");
        }
    }

    /* renamed from: o, reason: from getter */
    public final String getMStreamName() {
        return this.mStreamName;
    }

    /* renamed from: p, reason: from getter */
    public final int getMStreamType() {
        return this.mStreamType;
    }

    public final boolean r() {
        return this.mSessionId.length() > 0;
    }

    public final void s(String msg2) {
        String str;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (this.mConfig.getMLogEnable()) {
            if (this.mSessionId.length() == 0) {
                str = "";
            } else {
                str = "session: " + this.mSessionId + ", ";
            }
            QLog.d("qzone_stream_" + this.mStreamName, 1, str + msg2);
        }
    }

    public final void t(String nodeName) {
        Object first;
        Intrinsics.checkNotNullParameter(nodeName, "nodeName");
        Set<String> keySet = this.mNodeMap.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "mNodeMap.keys");
        first = CollectionsKt___CollectionsKt.first(keySet);
        Intrinsics.checkNotNullExpressionValue(first, "mNodeMap.keys.first()");
        String str = (String) first;
        boolean areEqual = Intrinsics.areEqual(nodeName, str);
        if (!areEqual && q()) {
            s("tag node error, stream has finish, nodeName: " + nodeName + ", firstNodeName: " + str);
            return;
        }
        if (this.mNodeMap.isEmpty()) {
            s("tag node error, you have not define any node");
            return;
        }
        if (!this.mNodeMap.containsKey(nodeName)) {
            s("tag node error, have you define this node?");
            return;
        }
        e eVar = this.mNodeMap.get(nodeName);
        e eVar2 = this.mNodeMap.get(str);
        if (eVar == null || eVar2 == null) {
            return;
        }
        e eVar3 = eVar2;
        e eVar4 = eVar;
        eVar4.g(System.currentTimeMillis());
        if (!areEqual) {
            eVar4.f(eVar4.getNodeTime() - eVar3.getNodeTime());
            this.mStreamResult.a().put(eVar4.getNodeName(), Long.valueOf(eVar4.getCooperation.qqcircle.report.QCircleWeakNetReporter.KEY_COST java.lang.String()));
        }
        if (areEqual) {
            v();
        } else {
            s("tag node: " + nodeName + ", " + eVar4.getNodeDesc() + " cost " + eVar4.getCooperation.qqcircle.report.QCircleWeakNetReporter.KEY_COST java.lang.String() + " ms");
        }
        if (i(nodeName)) {
            u(eVar4.getCooperation.qqcircle.report.QCircleWeakNetReporter.KEY_COST java.lang.String());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final g w() {
        this.mNodeMap.clear();
        this.mStepMap.clear();
        return this;
    }

    public final void x(String stepName) {
        Intrinsics.checkNotNullParameter(stepName, "stepName");
        f fVar = this.mStepMap.get(stepName);
        if (fVar != null) {
            fVar.i(System.currentTimeMillis());
            s(stepName + ", " + fVar.getStepDesc() + " start");
        }
    }

    public static /* synthetic */ g d(g gVar, String str, String str2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                str2 = "";
            }
            return gVar.b(str, str2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addNode");
    }

    public static /* synthetic */ g g(g gVar, String str, String str2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                str2 = "";
            }
            return gVar.e(str, str2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addStep");
    }
}
