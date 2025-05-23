package com.tencent.mobileqq.zplan.cc;

import com.tencent.autotemplate.extra.PreDetect;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import fg3.FaceItemData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import qshadow.AIFacePtaData$ZplanFaceStyle;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bL\u0010MJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0016\u0010\f\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\nH\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\u0006\u0010\u0014\u001a\u00020\u0013J\u001c\u0010\u0017\u001a\u00020\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0016\u001a\u00020\u0010J\u0006\u0010\u0018\u001a\u00020\u0004J\u000e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0010J\u0006\u0010\u001b\u001a\u00020\u0004J\u0006\u0010\u001c\u001a\u00020\u0004J\u000e\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0010J\u0006\u0010\u001f\u001a\u00020\u0004J\u0016\u0010\"\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u0010R\"\u0010*\u001a\u00020#8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u00100\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R$\u00107\u001a\u0004\u0018\u0001018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0016\u00108\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010+R\u0016\u0010:\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u00109R\"\u0010?\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u00109\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010B\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u00109\u001a\u0004\b@\u0010<\"\u0004\bA\u0010>R\u0016\u0010C\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u00109R\u0016\u0010D\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010+R\u0014\u0010E\u001a\u00020\u00108\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0014\u00109R\"\u0010H\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010+\u001a\u0004\bF\u0010-\"\u0004\bG\u0010/R\u001a\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00070I8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010J\u00a8\u0006N"}, d2 = {"Lcom/tencent/mobileqq/zplan/cc/j;", "", "Lcom/tencent/mobileqq/zplan/cc/b;", "command", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "Lqshadow/AIFacePtaData$ZplanFaceStyle;", "resList", "b", "Ljava/util/LinkedList;", "serverList", "r", DomainData.DOMAIN_NAME, "Lfg3/l;", PreDetect.FACE_DETECT, "", "f", tl.h.F, "", "j", "datas", "seqId", "l", "c", "newClickIndex", "d", "p", "g", "size", "k", "o", "data", "index", "u", "Lfg3/d;", "a", "Lfg3/d;", "e", "()Lfg3/d;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Lfg3/d;)V", "adapter", "Z", "i", "()Z", "setLoading", "(Z)V", "isLoading", "Lcom/tencent/mobileqq/zplan/cc/ai;", "Lcom/tencent/mobileqq/zplan/cc/ai;", "getOnDataChangeListener", "()Lcom/tencent/mobileqq/zplan/cc/ai;", ReportConstant.COSTREPORT_PREFIX, "(Lcom/tencent/mobileqq/zplan/cc/ai;)V", "onDataChangeListener", "isFirst", "I", "onNeedGeneratePictureIndex", "getLastRequestPersonSize", "()I", "setLastRequestPersonSize", "(I)V", "lastRequestPersonSize", "getLastClickedIndex", "setLastClickedIndex", "lastClickedIndex", "tempPersonSize", "isWaitForNewOne", "threshold", "getTabDisableCache", "t", "tabDisableCache", "Lcom/tencent/mobileqq/zplan/cc/a;", "Lcom/tencent/mobileqq/zplan/cc/a;", "cache", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public fg3.d adapter;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean isLoading;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private ai onDataChangeListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int onNeedGeneratePictureIndex;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private volatile int lastRequestPersonSize;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int lastClickedIndex;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int tempPersonSize;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isWaitForNewOne;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean tabDisableCache;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isFirst = true;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final int threshold = 1;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final a<AIFacePtaData$ZplanFaceStyle> cache = new a<>();

    private final void b(List<AIFacePtaData$ZplanFaceStyle> resList) {
        if (this.tabDisableCache) {
            return;
        }
        this.cache.b(resList);
    }

    private final int f(FaceItemData face2) {
        Iterator<FaceItemData> it = e().i0().iterator();
        int i3 = 0;
        while (it.hasNext()) {
            AIFacePtaData$ZplanFaceStyle face3 = it.next().getFace();
            PBStringField pBStringField = face3 != null ? face3.pta_data : null;
            AIFacePtaData$ZplanFaceStyle face4 = face2.getFace();
            if (Intrinsics.areEqual(pBStringField, face4 != null ? face4.pta_data : null)) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    private final void m(AIFaceDataCommand command) {
        Object obj;
        Object obj2;
        QLog.i("ZPlanCamera_FilamentAIFace", 1, "onReceiveDataCommand = " + command);
        int action = command.getAction();
        Object obj3 = null;
        if (action == 1) {
            QLog.i("ZPlanCamera_FilamentAIFace", 1, "COMMAND_UPDATE = " + command.getUpdateIndex());
            FaceItemData faceItemData = command.b().get(0);
            Intrinsics.checkNotNullExpressionValue(faceItemData, "command.faceData[0]");
            int f16 = f(faceItemData);
            if (f16 < 0) {
                command.d(e().i0().size() - 1);
            } else {
                command.d(f16);
            }
            e().notifyItemChanged(command.getUpdateIndex());
            if (e().i0().get(command.getUpdateIndex()).getType() == FaceItemData.INSTANCE.d() && e().i0().get(command.getUpdateIndex()).getIsSelected()) {
                QLog.i("ZPlanCamera_FilamentAIFace", 1, "onSelectPictureUpdate");
                ai aiVar = this.onDataChangeListener;
                if (aiVar != null) {
                    aiVar.c();
                }
            }
            Iterator<T> it = e().i0().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it.next();
                    if (((FaceItemData) obj).getType() == FaceItemData.INSTANCE.b()) {
                        break;
                    }
                }
            }
            boolean z16 = obj == null;
            Iterator<T> it5 = e().i0().iterator();
            while (true) {
                if (!it5.hasNext()) {
                    obj2 = null;
                    break;
                } else {
                    obj2 = it5.next();
                    if (((FaceItemData) obj2).getType() != FaceItemData.INSTANCE.d()) {
                        break;
                    }
                }
            }
            boolean z17 = obj2 == null;
            if (z16 && z17) {
                QLog.i("ZPlanCamera_FilamentAIFace", 1, "onReceiveDataCommand attach add");
                e().i0().add(FaceItemData.INSTANCE.a());
                e().notifyItemInserted(e().i0().size());
                if (this.isFirst) {
                    ai aiVar2 = this.onDataChangeListener;
                    if (aiVar2 != null) {
                        aiVar2.d(0);
                    }
                    this.isFirst = false;
                } else {
                    ai aiVar3 = this.onDataChangeListener;
                    if (aiVar3 != null) {
                        aiVar3.d(e().i0().size() - 1);
                    }
                }
            }
            ai aiVar4 = this.onDataChangeListener;
            if (aiVar4 != null) {
                aiVar4.traverseExposure();
            }
        } else if (action != 2) {
            if (action == 3) {
                e().i0().clear();
                e().i0().addAll(command.b());
                e().notifyDataSetChanged();
            }
        } else {
            if (e().i0().isEmpty()) {
                return;
            }
            int size = e().i0().size() - 1;
            e().i0().set(size, command.b().get(0));
            e().notifyItemChanged(size);
            ai aiVar5 = this.onDataChangeListener;
            if (aiVar5 != null) {
                aiVar5.traverseExposure();
            }
        }
        Iterator<T> it6 = e().i0().iterator();
        while (true) {
            if (!it6.hasNext()) {
                break;
            }
            Object next = it6.next();
            if (((FaceItemData) next).getType() == FaceItemData.INSTANCE.b()) {
                obj3 = next;
                break;
            }
        }
        this.isLoading = obj3 == null;
    }

    private final void n() {
        ArrayList arrayListOf;
        FaceItemData faceItemData = new FaceItemData(0, false, null, null, null, false, 63, null);
        faceItemData.o(FaceItemData.INSTANCE.c());
        faceItemData.l(true);
        faceItemData.k(this.cache.d());
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(faceItemData);
        m(new AIFaceDataCommand(2, arrayListOf, 0, 4, null));
        int i3 = this.onNeedGeneratePictureIndex + 1;
        this.onNeedGeneratePictureIndex = i3;
        ai aiVar = this.onDataChangeListener;
        if (aiVar != null) {
            aiVar.a(faceItemData, i3);
        }
        ai aiVar2 = this.onDataChangeListener;
        if (aiVar2 != null) {
            aiVar2.b(faceItemData, this.onNeedGeneratePictureIndex);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(FaceItemData data, j this$0, int i3) {
        ArrayList arrayListOf;
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        data.o(FaceItemData.INSTANCE.d());
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(data);
        this$0.m(new AIFaceDataCommand(1, arrayListOf, i3));
    }

    public final void c() {
        int i3 = 0;
        for (Object obj : e().i0()) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            FaceItemData faceItemData = (FaceItemData) obj;
            if (faceItemData.getIsSelected()) {
                this.lastClickedIndex = i3;
                faceItemData.l(false);
            }
            i3 = i16;
        }
        e().notifyDataSetChanged();
    }

    public final void d(int newClickIndex) {
        Iterator<T> it = e().i0().iterator();
        while (it.hasNext()) {
            ((FaceItemData) it.next()).l(false);
        }
        e().i0().get(newClickIndex).l(true);
        e().notifyDataSetChanged();
    }

    public final fg3.d e() {
        fg3.d dVar = this.adapter;
        if (dVar != null) {
            return dVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        return null;
    }

    public final void g() {
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        while (true) {
            boolean z16 = true;
            if (i3 < 3) {
                FaceItemData faceItemData = new FaceItemData(0, false, null, null, null, false, 63, null);
                faceItemData.o(FaceItemData.INSTANCE.c());
                if (i3 != 0) {
                    z16 = false;
                }
                faceItemData.l(z16);
                faceItemData.k(null);
                arrayList.add(faceItemData);
                i3++;
            } else {
                QLog.i("ZPlanCamera_FilamentAIFace", 1, "getDefaultFaceData");
                m(new AIFaceDataCommand(3, arrayList, 0, 4, null));
                return;
            }
        }
    }

    /* renamed from: i, reason: from getter */
    public final boolean getIsLoading() {
        return this.isLoading;
    }

    public final boolean j() {
        QLog.i("ZPlanCamera_FilamentAIFace", 1, "onReceiveData needRequestAndUseCache tabDisableCache = " + this.tabDisableCache);
        if (this.tabDisableCache) {
            h();
            this.isWaitForNewOne = true;
            return true;
        }
        QLog.i("ZPlanCamera_FilamentAIFace", 1, "onReceiveData needRequestAndUseCache = " + this.cache.e());
        if (this.cache.e() > this.threshold) {
            n();
            return false;
        }
        if (this.cache.e() > 1) {
            n();
        } else {
            h();
            this.isWaitForNewOne = true;
        }
        return true;
    }

    public final void k(int size) {
        this.tempPersonSize = size;
        if (size != this.lastRequestPersonSize) {
            this.cache.c();
        }
    }

    public final void l(List<AIFacePtaData$ZplanFaceStyle> datas, int seqId) {
        ArrayList arrayListOf;
        Intrinsics.checkNotNullParameter(datas, "datas");
        QLog.i("ZPlanCamera_FilamentAIFace", 1, "onReceiveData seqId = " + seqId);
        if (datas.isEmpty() && seqId == 0) {
            QLog.i("ZPlanCamera_FilamentAIFace", 1, "onReceiveData init only add");
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(FaceItemData.INSTANCE.a());
            m(new AIFaceDataCommand(3, arrayListOf, 0, 4, null));
            return;
        }
        LinkedList<AIFacePtaData$ZplanFaceStyle> linkedList = new LinkedList<>(datas);
        if (seqId == 0) {
            r(linkedList);
            b(linkedList);
            return;
        }
        b(linkedList);
        boolean z16 = this.isWaitForNewOne;
        if (z16) {
            QLog.i("ZPlanCamera_FilamentAIFace", 1, "onReceiveData isWaitForNewOne = " + z16);
            this.isWaitForNewOne = false;
            if (this.tabDisableCache) {
                this.cache.a(linkedList.pollFirst());
            }
            n();
        }
    }

    public final void o() {
        this.lastRequestPersonSize = this.tempPersonSize;
    }

    public final void p() {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(FaceItemData.INSTANCE.a());
        m(new AIFaceDataCommand(2, arrayListOf, 0, 4, null));
    }

    public final void q(fg3.d dVar) {
        Intrinsics.checkNotNullParameter(dVar, "<set-?>");
        this.adapter = dVar;
    }

    public final void s(ai aiVar) {
        this.onDataChangeListener = aiVar;
    }

    public final void t(boolean z16) {
        this.tabDisableCache = z16;
    }

    public final void u(final FaceItemData data, final int index) {
        Intrinsics.checkNotNullParameter(data, "data");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.cc.i
            @Override // java.lang.Runnable
            public final void run() {
                j.v(FaceItemData.this, this, index);
            }
        });
    }

    private final void h() {
        ArrayList arrayListOf;
        FaceItemData faceItemData = new FaceItemData(0, false, null, null, null, false, 63, null);
        faceItemData.o(FaceItemData.INSTANCE.c());
        faceItemData.l(true);
        faceItemData.k(null);
        Unit unit = Unit.INSTANCE;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(faceItemData);
        m(new AIFaceDataCommand(2, arrayListOf, 0, 4, null));
    }

    private final void r(LinkedList<AIFacePtaData$ZplanFaceStyle> serverList) {
        int coerceAtMost;
        ai aiVar;
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(3, serverList.size());
        ArrayList arrayList = new ArrayList();
        FaceItemData faceItemData = null;
        int i3 = 0;
        while (i3 < coerceAtMost) {
            AIFacePtaData$ZplanFaceStyle pollFirst = serverList.pollFirst();
            if (pollFirst != null) {
                FaceItemData faceItemData2 = new FaceItemData(0, false, null, null, null, false, 63, null);
                faceItemData2.o(FaceItemData.INSTANCE.c());
                faceItemData2.l(i3 == 0);
                faceItemData2.k(pollFirst);
                arrayList.add(faceItemData2);
                if (faceItemData2.getIsSelected()) {
                    faceItemData = faceItemData2;
                }
                this.onNeedGeneratePictureIndex = i3;
                ai aiVar2 = this.onDataChangeListener;
                if (aiVar2 != null) {
                    aiVar2.a(faceItemData2, i3);
                }
            }
            i3++;
        }
        if (faceItemData != null && (aiVar = this.onDataChangeListener) != null) {
            aiVar.b(faceItemData, 0);
        }
        QLog.i("_FilamentAIFace", 1, "setFirstFaceData addsize = " + coerceAtMost + ", cachesize = " + serverList.size());
        m(new AIFaceDataCommand(3, arrayList, 0, 4, null));
    }
}
