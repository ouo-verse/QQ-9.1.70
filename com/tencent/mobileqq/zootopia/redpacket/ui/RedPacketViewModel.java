package com.tencent.mobileqq.zootopia.redpacket.ui;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b/\u00100J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\u0005J2\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00102\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00050\u0012R\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR#\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u001c0\u00158\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001aR\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020 0\u00158\u0006\u00a2\u0006\f\n\u0004\b!\u0010\u0018\u001a\u0004\b\"\u0010\u001aR\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00020\t0\u00158\u0006\u00a2\u0006\f\n\u0004\b$\u0010\u0018\u001a\u0004\b%\u0010\u001aR\"\u0010.\u001a\u00020'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/zootopia/redpacket/ui/RedPacketViewModel;", "Lcom/tencent/mobileqq/mvvm/c;", "Lcom/tencent/mobileqq/zootopia/redpacket/ui/RedPacketRepository;", "Ltu4/c;", "rsp", "", "X1", "W1", "U1", "Lhd3/a;", "data", "Z1", "T1", "", "localApngPath", "localPngPath", "", "redPacketId", "Lkotlin/Function1;", "callback", "b2", "Landroidx/lifecycle/MutableLiveData;", "Lhd3/c;", "i", "Landroidx/lifecycle/MutableLiveData;", "Q1", "()Landroidx/lifecycle/MutableLiveData;", "listStyleLiveData", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "R1", "redPacketDataList", "Lhd3/b;", BdhLogUtil.LogTag.Tag_Conn, "S1", "redPacketPageLiveData", "D", "P1", "currentChooseRedPacketItemData", "", "E", "J", "O1", "()J", ICustomDataEditor.STRING_ARRAY_PARAM_2, "(J)V", "curAvatarId", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class RedPacketViewModel extends com.tencent.mobileqq.mvvm.c<RedPacketRepository> {

    /* renamed from: C, reason: from kotlin metadata */
    private final MutableLiveData<hd3.b> redPacketPageLiveData;

    /* renamed from: D, reason: from kotlin metadata */
    private final MutableLiveData<hd3.a> currentChooseRedPacketItemData;

    /* renamed from: E, reason: from kotlin metadata */
    private long curAvatarId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<hd3.c> listStyleLiveData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<List<hd3.a>> redPacketDataList;

    public RedPacketViewModel() {
        super(new RedPacketRepository());
        this.listStyleLiveData = new MutableLiveData<>();
        this.redPacketDataList = new MutableLiveData<>();
        this.redPacketPageLiveData = new MutableLiveData<>();
        this.currentChooseRedPacketItemData = new MutableLiveData<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U1(tu4.c rsp) {
        tu4.d dVar = rsp.f437495a;
        if (dVar == null) {
            return;
        }
        hd3.b bVar = new hd3.b();
        String str = dVar.f437499b;
        Intrinsics.checkNotNullExpressionValue(str, "pageStyle.upperBackUrl");
        bVar.i(str);
        String str2 = dVar.f437500c;
        Intrinsics.checkNotNullExpressionValue(str2, "pageStyle.middleBackUrl");
        bVar.l(str2);
        String str3 = dVar.f437501d;
        Intrinsics.checkNotNullExpressionValue(str3, "pageStyle.sendButtonUrl");
        bVar.k(str3);
        String str4 = dVar.f437502e;
        Intrinsics.checkNotNullExpressionValue(str4, "pageStyle.lowerBackColor");
        bVar.j(str4);
        String str5 = dVar.f437506i;
        Intrinsics.checkNotNullExpressionValue(str5, "pageStyle.entranceColor");
        bVar.h(str5);
        String str6 = dVar.f437507j;
        Intrinsics.checkNotNullExpressionValue(str6, "pageStyle.translucentColor");
        bVar.m(str6);
        this.redPacketPageLiveData.postValue(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W1(tu4.c rsp) {
        Object orNull;
        Object orNull2;
        tu4.a[] aVarArr;
        ArrayList arrayList = new ArrayList();
        tu4.e[] eVarArr = rsp.f437496b;
        if (eVarArr != null) {
            orNull2 = ArraysKt___ArraysKt.getOrNull(eVarArr, 0);
            tu4.e eVar = (tu4.e) orNull2;
            if (eVar != null && (aVarArr = eVar.f437510b) != null) {
                for (tu4.a aVar : aVarArr) {
                    hd3.a aVar2 = new hd3.a();
                    aVar2.m(aVar.f437490a);
                    String str = aVar.f437491b;
                    Intrinsics.checkNotNullExpressionValue(str, "data.templateName");
                    aVar2.n(str);
                    aVar2.h(aVar.f437492c);
                    String str2 = aVar.f437493d;
                    Intrinsics.checkNotNullExpressionValue(str2, "data.avatarMd5");
                    aVar2.j(str2);
                    aVar2.i(aVar.f437494e);
                    arrayList.add(aVar2);
                }
            }
        }
        orNull = CollectionsKt___CollectionsKt.getOrNull(arrayList, 0);
        hd3.a aVar3 = (hd3.a) orNull;
        if (aVar3 != null) {
            aVar3.k(true);
            this.currentChooseRedPacketItemData.postValue(aVar3);
        }
        this.redPacketDataList.postValue(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X1(tu4.c rsp) {
        hd3.c cVar = new hd3.c();
        tu4.d dVar = rsp.f437495a;
        String str = dVar != null ? dVar.f437505h : null;
        String str2 = "";
        if (str == null) {
            str = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str, "rsp.pageStyle?.coverSelectColor ?: \"\"");
        }
        cVar.c(str);
        tu4.d dVar2 = rsp.f437495a;
        String str3 = dVar2 != null ? dVar2.f437504g : null;
        if (str3 != null) {
            Intrinsics.checkNotNullExpressionValue(str3, "rsp.pageStyle?.coverTitleColor ?: \"\"");
            str2 = str3;
        }
        cVar.d(str2);
        this.listStyleLiveData.postValue(cVar);
    }

    /* renamed from: O1, reason: from getter */
    public final long getCurAvatarId() {
        return this.curAvatarId;
    }

    public final MutableLiveData<hd3.a> P1() {
        return this.currentChooseRedPacketItemData;
    }

    public final MutableLiveData<hd3.c> Q1() {
        return this.listStyleLiveData;
    }

    public final MutableLiveData<List<hd3.a>> R1() {
        return this.redPacketDataList;
    }

    public final MutableLiveData<hd3.b> S1() {
        return this.redPacketPageLiveData;
    }

    public final void T1() {
        getRepository().p(new Function1<tu4.c, Unit>() { // from class: com.tencent.mobileqq.zootopia.redpacket.ui.RedPacketViewModel$loadRedPacketData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(tu4.c cVar) {
                invoke2(cVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(tu4.c cVar) {
                if (cVar == null) {
                    return;
                }
                RedPacketViewModel.this.a2(cVar.f437497c);
                RedPacketViewModel.this.X1(cVar);
                RedPacketViewModel.this.W1(cVar);
                RedPacketViewModel.this.U1(cVar);
            }
        });
    }

    public final void Z1(hd3.a data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.currentChooseRedPacketItemData.postValue(data);
    }

    public final void a2(long j3) {
        this.curAvatarId = j3;
    }

    public final void b2(String localApngPath, String localPngPath, int redPacketId, Function1<? super Integer, Unit> callback) {
        Intrinsics.checkNotNullParameter(localApngPath, "localApngPath");
        Intrinsics.checkNotNullParameter(localPngPath, "localPngPath");
        Intrinsics.checkNotNullParameter(callback, "callback");
        getRepository().t(localApngPath, localPngPath, redPacketId, this.curAvatarId, callback);
    }
}
