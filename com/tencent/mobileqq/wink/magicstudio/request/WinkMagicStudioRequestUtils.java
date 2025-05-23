package com.tencent.mobileqq.wink.magicstudio.request;

import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioHistoryImageModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qshadow.ShadowAIGCReport$ReportItem;
import qshadow.ShadowAIGCReport$ReportReply;
import qshadow.ShadowAIGCReport$ReportRequest;
import r93.h;
import w53.b;
import w93.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0014\u0010\f\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u0014\u0010\r\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u000e\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0003J\u0006\u0010\u0010\u001a\u00020\u0007\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/request/WinkMagicStudioRequestUtils;", "", "", "Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioHistoryImageModel;", "historyDataList", "", "reportPriority", "", "e", "Lcom/tencent/mobileqq/wink/magicstudio/request/WinkMagicStudioReportReq;", Const.BUNDLE_KEY_REQUEST, "f", "c", "d", "historyData", "b", "a", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkMagicStudioRequestUtils {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final WinkMagicStudioRequestUtils f323879a = new WinkMagicStudioRequestUtils();

    WinkMagicStudioRequestUtils() {
    }

    private final void e(List<MagicStudioHistoryImageModel> historyDataList, int reportPriority) {
        ArrayList arrayList = new ArrayList();
        for (MagicStudioHistoryImageModel magicStudioHistoryImageModel : historyDataList) {
            ShadowAIGCReport$ReportItem shadowAIGCReport$ReportItem = new ShadowAIGCReport$ReportItem();
            shadowAIGCReport$ReportItem.local_md5.set(magicStudioHistoryImageModel.getImageMd5());
            shadowAIGCReport$ReportItem.priority.set(reportPriority);
            shadowAIGCReport$ReportItem.compress_url.set(magicStudioHistoryImageModel.getCompressedUrl());
            shadowAIGCReport$ReportItem.face_crop_url.set(magicStudioHistoryImageModel.getCropFaceUrl());
            arrayList.add(shadowAIGCReport$ReportItem);
        }
        ShadowAIGCReport$ReportRequest shadowAIGCReport$ReportRequest = new ShadowAIGCReport$ReportRequest();
        shadowAIGCReport$ReportRequest.busi_id.set(h.f430993a.e());
        shadowAIGCReport$ReportRequest.type.set(1);
        shadowAIGCReport$ReportRequest.items.set(arrayList);
        f(new WinkMagicStudioReportReq(shadowAIGCReport$ReportRequest));
    }

    private final void f(WinkMagicStudioReportReq request) {
        e.f445096a.j(request, new Function5<BaseRequest, Boolean, Long, String, ShadowAIGCReport$ReportReply, Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.request.WinkMagicStudioRequestUtils$sendReportRequest$1
            @Override // kotlin.jvm.functions.Function5
            public /* bridge */ /* synthetic */ Unit invoke(BaseRequest baseRequest, Boolean bool, Long l3, String str, ShadowAIGCReport$ReportReply shadowAIGCReport$ReportReply) {
                invoke(baseRequest, bool.booleanValue(), l3.longValue(), str, shadowAIGCReport$ReportReply);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull BaseRequest baseRequest, boolean z16, long j3, @Nullable String str, @Nullable ShadowAIGCReport$ReportReply shadowAIGCReport$ReportReply) {
                Intrinsics.checkNotNullParameter(baseRequest, "<anonymous parameter 0>");
                b.f("WinkMagicStudioRequestUtils", "sendReportRequest retCode:" + j3 + ", isSuccess:" + z16 + " retCode:" + j3);
            }
        });
    }

    public final void a() {
        ShadowAIGCReport$ReportRequest shadowAIGCReport$ReportRequest = new ShadowAIGCReport$ReportRequest();
        shadowAIGCReport$ReportRequest.busi_id.set(h.f430993a.e());
        shadowAIGCReport$ReportRequest.type.set(3);
        f(new WinkMagicStudioReportReq(shadowAIGCReport$ReportRequest));
    }

    public final void b(@NotNull MagicStudioHistoryImageModel historyData) {
        List<ShadowAIGCReport$ReportItem> mutableListOf;
        Intrinsics.checkNotNullParameter(historyData, "historyData");
        ShadowAIGCReport$ReportRequest shadowAIGCReport$ReportRequest = new ShadowAIGCReport$ReportRequest();
        shadowAIGCReport$ReportRequest.busi_id.set(h.f430993a.e());
        shadowAIGCReport$ReportRequest.type.set(2);
        PBRepeatMessageField<ShadowAIGCReport$ReportItem> pBRepeatMessageField = shadowAIGCReport$ReportRequest.items;
        ShadowAIGCReport$ReportItem shadowAIGCReport$ReportItem = new ShadowAIGCReport$ReportItem();
        shadowAIGCReport$ReportItem.local_md5.set(historyData.getImageMd5());
        Unit unit = Unit.INSTANCE;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(shadowAIGCReport$ReportItem);
        pBRepeatMessageField.set(mutableListOf);
        f(new WinkMagicStudioReportReq(shadowAIGCReport$ReportRequest));
    }

    public final void c(@NotNull List<MagicStudioHistoryImageModel> historyDataList) {
        Intrinsics.checkNotNullParameter(historyDataList, "historyDataList");
        e(historyDataList, 0);
    }

    public final void d(@NotNull List<MagicStudioHistoryImageModel> historyDataList) {
        Intrinsics.checkNotNullParameter(historyDataList, "historyDataList");
        e(historyDataList, 1);
    }
}
