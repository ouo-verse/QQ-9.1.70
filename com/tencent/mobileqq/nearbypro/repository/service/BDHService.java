package com.tencent.mobileqq.nearbypro.repository.service;

import android.os.Looper;
import android.os.Message;
import android.util.Size;
import com.google.protobuf.nano.WireFormatNano;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.nearbypro.request.NearbyProBaseOIDBRequest;
import com.tencent.mobileqq.nearbypro.request.NearbyProBaseRequest;
import com.tencent.mobileqq.nearbypro.request.RspStatus;
import com.tencent.mobileqq.nearbypro.utils.l;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qqnt.kernel.nativeinterface.cq;
import fu4.ac;
import fu4.ah;
import fu4.ai;
import fu4.aj;
import fu4.ak;
import fu4.am;
import fu4.ao;
import fu4.aq;
import fu4.at;
import fu4.au;
import fu4.d;
import fu4.f;
import fu4.k;
import fu4.n;
import fu4.o;
import fu4.s;
import fu4.t;
import fu4.v;
import fu4.w;
import fu4.z;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.Charsets;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import lq4.e;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 32\u00020\u0001:\u00054,567B\u0007\u00a2\u0006\u0004\b1\u00102J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\nJ\u001b\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000eJ3\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0019\u001a\u00020\u00172\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0018\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0012H\u0002J%\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002\u00a2\u0006\u0004\b\"\u0010#J\f\u0010&\u001a\u00020%*\u00020$H\u0002J#\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00020'2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b(\u0010)J\u001d\u0010*\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b*\u0010\u0006R\u001b\u00100\u001a\u00020+8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/repository/service/BDHService;", "", "", "filePath", "Lfu4/ak;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lfu4/w;", "msgInfo", DomainData.DOMAIN_NAME, "(Lfu4/w;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/nearbypro/request/NearbyProBaseRequest;", "req", "k", "(Lcom/tencent/mobileqq/nearbypro/request/NearbyProBaseRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lfu4/au;", "uploadRsp", "", "", "cumulateSha1", "Lcom/tencent/mobileqq/transfile/FileMsg;", "l", "(Ljava/lang/String;Lfu4/au;[[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lfu4/ah;", "e", "f", "Lfu4/v;", "indexNode", "g", "reqExtendInfo", "Lcom/tencent/mobileqq/transfile/TransferRequest;", "d", "rsp", "Llq4/e;", h.F, "(Lfu4/au;[[B)Llq4/e;", "Leu4/a;", "Llq4/d;", "p", "", "j", "(Lfu4/v;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "o", "Lcom/tencent/mobileqq/transfile/api/ITransFileController;", "a", "Lkotlin/Lazy;", "i", "()Lcom/tencent/mobileqq/transfile/api/ITransFileController;", "transController", "<init>", "()V", "b", "BeginUpReq", "DownloadReq", "EndUpReq", "PicSize", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class BDHService {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy transController;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B3\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0004\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\r8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\r8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/repository/service/BDHService$BeginUpReq;", "Lcom/tencent/mobileqq/nearbypro/request/NearbyProBaseOIDBRequest;", "Lfu4/ah;", "Lfu4/ak;", "pbReq", "Lfu4/ah;", "getPbReq", "()Lfu4/ah;", "Lkotlin/Function0;", "pbRspConstructor", "Lkotlin/jvm/functions/Function0;", "getPbRspConstructor", "()Lkotlin/jvm/functions/Function0;", "", "oidb_service_type", "I", "getOidb_service_type", "()I", "oidb_cmd", "getOidb_cmd", "<init>", "(Lfu4/ah;Lkotlin/jvm/functions/Function0;II)V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class BeginUpReq extends NearbyProBaseOIDBRequest<ah, ak> {
        private final int oidb_cmd;
        private final int oidb_service_type;

        @NotNull
        private final ah pbReq;

        @NotNull
        private final Function0<ak> pbRspConstructor;

        public /* synthetic */ BeginUpReq(ah ahVar, Function0 function0, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
            this(ahVar, (i17 & 2) != 0 ? new Function0<ak>() { // from class: com.tencent.mobileqq.nearbypro.repository.service.BDHService.BeginUpReq.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final ak invoke() {
                    return new ak();
                }
            } : function0, (i17 & 4) != 0 ? 100 : i3, (i17 & 8) != 0 ? 4777 : i16);
        }

        @Override // com.tencent.mobileqq.nearbypro.request.NearbyProBaseOIDBRequest
        public int getOidb_cmd() {
            return this.oidb_cmd;
        }

        @Override // com.tencent.mobileqq.nearbypro.request.NearbyProBaseOIDBRequest
        public int getOidb_service_type() {
            return this.oidb_service_type;
        }

        @Override // com.tencent.mobileqq.nearbypro.request.NearbyProBasePBRequest
        @NotNull
        public Function0<ak> getPbRspConstructor() {
            return this.pbRspConstructor;
        }

        @Override // com.tencent.mobileqq.nearbypro.request.NearbyProBasePBRequest
        @NotNull
        public ah getPbReq() {
            return this.pbReq;
        }

        public BeginUpReq(@NotNull ah pbReq, @NotNull Function0<ak> pbRspConstructor, int i3, int i16) {
            Intrinsics.checkNotNullParameter(pbReq, "pbReq");
            Intrinsics.checkNotNullParameter(pbRspConstructor, "pbRspConstructor");
            this.pbReq = pbReq;
            this.pbRspConstructor = pbRspConstructor;
            this.oidb_service_type = i3;
            this.oidb_cmd = i16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B3\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0004\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\r8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\r8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/repository/service/BDHService$DownloadReq;", "Lcom/tencent/mobileqq/nearbypro/request/NearbyProBaseOIDBRequest;", "Lfu4/ah;", "Lfu4/ak;", "pbReq", "Lfu4/ah;", "getPbReq", "()Lfu4/ah;", "Lkotlin/Function0;", "pbRspConstructor", "Lkotlin/jvm/functions/Function0;", "getPbRspConstructor", "()Lkotlin/jvm/functions/Function0;", "", "oidb_service_type", "I", "getOidb_service_type", "()I", "oidb_cmd", "getOidb_cmd", "<init>", "(Lfu4/ah;Lkotlin/jvm/functions/Function0;II)V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class DownloadReq extends NearbyProBaseOIDBRequest<ah, ak> {
        private final int oidb_cmd;
        private final int oidb_service_type;

        @NotNull
        private final ah pbReq;

        @NotNull
        private final Function0<ak> pbRspConstructor;

        public /* synthetic */ DownloadReq(ah ahVar, Function0 function0, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
            this(ahVar, (i17 & 2) != 0 ? new Function0<ak>() { // from class: com.tencent.mobileqq.nearbypro.repository.service.BDHService.DownloadReq.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final ak invoke() {
                    return new ak();
                }
            } : function0, (i17 & 4) != 0 ? 200 : i3, (i17 & 8) != 0 ? 4777 : i16);
        }

        @Override // com.tencent.mobileqq.nearbypro.request.NearbyProBaseOIDBRequest
        public int getOidb_cmd() {
            return this.oidb_cmd;
        }

        @Override // com.tencent.mobileqq.nearbypro.request.NearbyProBaseOIDBRequest
        public int getOidb_service_type() {
            return this.oidb_service_type;
        }

        @Override // com.tencent.mobileqq.nearbypro.request.NearbyProBasePBRequest
        @NotNull
        public Function0<ak> getPbRspConstructor() {
            return this.pbRspConstructor;
        }

        @Override // com.tencent.mobileqq.nearbypro.request.NearbyProBasePBRequest
        @NotNull
        public ah getPbReq() {
            return this.pbReq;
        }

        public DownloadReq(@NotNull ah pbReq, @NotNull Function0<ak> pbRspConstructor, int i3, int i16) {
            Intrinsics.checkNotNullParameter(pbReq, "pbReq");
            Intrinsics.checkNotNullParameter(pbRspConstructor, "pbRspConstructor");
            this.pbReq = pbReq;
            this.pbRspConstructor = pbRspConstructor;
            this.oidb_service_type = i3;
            this.oidb_cmd = i16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B3\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0004\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\r8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\r8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/repository/service/BDHService$EndUpReq;", "Lcom/tencent/mobileqq/nearbypro/request/NearbyProBaseOIDBRequest;", "Lfu4/ah;", "Lfu4/ak;", "pbReq", "Lfu4/ah;", "getPbReq", "()Lfu4/ah;", "Lkotlin/Function0;", "pbRspConstructor", "Lkotlin/jvm/functions/Function0;", "getPbRspConstructor", "()Lkotlin/jvm/functions/Function0;", "", "oidb_service_type", "I", "getOidb_service_type", "()I", "oidb_cmd", "getOidb_cmd", "<init>", "(Lfu4/ah;Lkotlin/jvm/functions/Function0;II)V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class EndUpReq extends NearbyProBaseOIDBRequest<ah, ak> {
        private final int oidb_cmd;
        private final int oidb_service_type;

        @NotNull
        private final ah pbReq;

        @NotNull
        private final Function0<ak> pbRspConstructor;

        public /* synthetic */ EndUpReq(ah ahVar, Function0 function0, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
            this(ahVar, (i17 & 2) != 0 ? new Function0<ak>() { // from class: com.tencent.mobileqq.nearbypro.repository.service.BDHService.EndUpReq.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final ak invoke() {
                    return new ak();
                }
            } : function0, (i17 & 4) != 0 ? 101 : i3, (i17 & 8) != 0 ? 4777 : i16);
        }

        @Override // com.tencent.mobileqq.nearbypro.request.NearbyProBaseOIDBRequest
        public int getOidb_cmd() {
            return this.oidb_cmd;
        }

        @Override // com.tencent.mobileqq.nearbypro.request.NearbyProBaseOIDBRequest
        public int getOidb_service_type() {
            return this.oidb_service_type;
        }

        @Override // com.tencent.mobileqq.nearbypro.request.NearbyProBasePBRequest
        @NotNull
        public Function0<ak> getPbRspConstructor() {
            return this.pbRspConstructor;
        }

        @Override // com.tencent.mobileqq.nearbypro.request.NearbyProBasePBRequest
        @NotNull
        public ah getPbReq() {
            return this.pbReq;
        }

        public EndUpReq(@NotNull ah pbReq, @NotNull Function0<ak> pbRspConstructor, int i3, int i16) {
            Intrinsics.checkNotNullParameter(pbReq, "pbReq");
            Intrinsics.checkNotNullParameter(pbRspConstructor, "pbRspConstructor");
            this.pbReq = pbReq;
            this.pbRspConstructor = pbRspConstructor;
            this.oidb_service_type = i3;
            this.oidb_cmd = i16;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/repository/service/BDHService$PicSize;", "", "(Ljava/lang/String;I)V", "THUMB", "BIG", "ORIGINAL", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes15.dex */
    public enum PicSize {
        THUMB,
        BIG,
        ORIGINAL
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ$\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007*\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0005R\u0014\u0010\n\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/repository/service/BDHService$a;", "", "Lfu4/o;", "", "https", "Lcom/tencent/mobileqq/nearbypro/repository/service/BDHService$PicSize;", "size", "", "", "a", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.nearbypro.repository.service.BDHService$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: com.tencent.mobileqq.nearbypro.repository.service.BDHService$a$a, reason: collision with other inner class name */
        /* loaded from: classes15.dex */
        public /* synthetic */ class C8156a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f253919a;

            static {
                int[] iArr = new int[PicSize.values().length];
                try {
                    iArr[PicSize.THUMB.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[PicSize.BIG.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[PicSize.ORIGINAL.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f253919a = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ List b(Companion companion, o oVar, boolean z16, PicSize picSize, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                z16 = false;
            }
            if ((i3 & 2) != 0) {
                picSize = PicSize.BIG;
            }
            return companion.a(oVar, z16, picSize);
        }

        @NotNull
        public final List<String> a(@NotNull o oVar, boolean z16, @NotNull PicSize size) {
            String str;
            String str2;
            List<String> emptyList;
            List<String> emptyList2;
            Intrinsics.checkNotNullParameter(oVar, "<this>");
            Intrinsics.checkNotNullParameter(size, "size");
            k kVar = oVar.f400795c;
            if (kVar == null) {
                emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                return emptyList2;
            }
            ac acVar = kVar.f400786f;
            if (acVar == null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                return emptyList;
            }
            int i3 = C8156a.f253919a[size.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        str = acVar.f400657a;
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    str = acVar.f400658b;
                }
            } else {
                str = acVar.f400659c;
            }
            eu4.a[] aVarArr = kVar.f400784d;
            Intrinsics.checkNotNullExpressionValue(aVarArr, "downloadInfo.ipv4");
            ArrayList arrayList = new ArrayList();
            for (eu4.a aVar : aVarArr) {
                String intAddr2Ip = NetworkUtil.intAddr2Ip(aVar.f397169a);
                if (z16) {
                    str2 = "https://" + intAddr2Ip + ":" + kVar.f400783c + kVar.f400782b + oVar.f400793a + str;
                } else {
                    str2 = "http://" + intAddr2Ip + ":" + aVar.f397170b + kVar.f400782b + oVar.f400793a + str;
                }
                if (str2 != null) {
                    arrayList.add(str2);
                }
            }
            return arrayList;
        }

        Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\n\u00a2\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/request/NearbyProBaseRequest;", "<anonymous parameter 0>", "Lcom/tencent/mobileqq/nearbypro/request/d;", "<anonymous parameter 1>", "Lfu4/ak;", "rsp", "", "b", "(Lcom/tencent/mobileqq/nearbypro/request/NearbyProBaseRequest;Lcom/tencent/mobileqq/nearbypro/request/d;Lfu4/ak;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b<Req, Rsp> implements com.tencent.mobileqq.nearbypro.request.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<ak> f253920a;

        /* JADX WARN: Multi-variable type inference failed */
        b(CancellableContinuation<? super ak> cancellableContinuation) {
            this.f253920a = cancellableContinuation;
        }

        @Override // com.tencent.mobileqq.nearbypro.request.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final void a(@NotNull NearbyProBaseRequest nearbyProBaseRequest, @NotNull RspStatus rspStatus, @Nullable ak akVar) {
            Intrinsics.checkNotNullParameter(nearbyProBaseRequest, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(rspStatus, "<anonymous parameter 1>");
            CancellableContinuation<ak> cancellableContinuation = this.f253920a;
            Result.Companion companion = Result.INSTANCE;
            if (akVar == null) {
                akVar = new ak();
            }
            cancellableContinuation.resumeWith(Result.m476constructorimpl(akVar));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/nearbypro/repository/service/BDHService$c", "Lcom/tencent/mobileqq/transfile/TransProcessorHandler;", "Landroid/os/Message;", "msg", "", "handleMessage", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class c extends TransProcessorHandler {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<FileMsg> f253922b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        c(CancellableContinuation<? super FileMsg> cancellableContinuation, Looper looper) {
            super(looper);
            this.f253922b = cancellableContinuation;
        }

        @Override // android.os.Handler
        public void handleMessage(@NotNull Message msg2) {
            FileMsg fileMsg;
            Intrinsics.checkNotNullParameter(msg2, "msg");
            super.handleMessage(msg2);
            Object obj = msg2.obj;
            if (obj instanceof FileMsg) {
                fileMsg = (FileMsg) obj;
            } else {
                fileMsg = null;
            }
            if (fileMsg == null || fileMsg.commandId != 1019) {
                return;
            }
            int i3 = msg2.what;
            if (i3 != 1001) {
                if (i3 != 1003) {
                    if (i3 != 1005) {
                        j.c().c("NearbyProBDHService", "SendFile handleMessage: msg not support " + msg2.what);
                        return;
                    }
                    j.c().d("NearbyProBDHService", "SendFile handleMessage: send error  " + fileMsg.errorCode + "  " + fileMsg.errorMessage);
                    BDHService.this.i().removeHandle(this);
                    this.f253922b.resumeWith(Result.m476constructorimpl(null));
                    return;
                }
                j.c().e("NearbyProBDHService", "SendFile handleMessage: send finish  " + fileMsg.filePath);
                BDHService.this.i().removeHandle(this);
                this.f253922b.resumeWith(Result.m476constructorimpl(fileMsg));
                return;
            }
            j.c().c("NearbyProBDHService", "dbhSendFile handleMessage: start upload");
        }
    }

    public BDHService() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ITransFileController>() { // from class: com.tencent.mobileqq.nearbypro.repository.service.BDHService$transController$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ITransFileController invoke() {
                return (ITransFileController) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ITransFileController.class, "");
            }
        });
        this.transController = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TransferRequest d(String filePath, byte[] reqExtendInfo) {
        TransferRequest transferRequest = new TransferRequest();
        transferRequest.mFileType = 24;
        transferRequest.mCommandId = 1019;
        transferRequest.mIsUp = true;
        transferRequest.mUniseq = System.currentTimeMillis();
        transferRequest.mExtentionInfo = reqExtendInfo;
        transferRequest.mLocalPath = filePath;
        return transferRequest;
    }

    private final ah e(String filePath) {
        ah ahVar = new ah();
        ai aiVar = new ai();
        f fVar = new f();
        fVar.f400770a = Random.INSTANCE.nextLong();
        fVar.f400771b = 100;
        aiVar.f400688a = fVar;
        am amVar = new am();
        amVar.f400708a = 2;
        amVar.f400709b = 1;
        amVar.f400710c = 11;
        amVar.f400711d = 5;
        aiVar.f400689b = amVar;
        d dVar = new d();
        dVar.f400766a = 2;
        aiVar.f400690c = dVar;
        ahVar.f400678a = aiVar;
        at atVar = new at();
        aq aqVar = new aq();
        s sVar = new s();
        sVar.f400803a = cq.v(filePath);
        sVar.f400804b = cq.r(filePath);
        sVar.f400805c = cq.u(filePath);
        sVar.f400806d = new File(filePath).getName();
        t tVar = new t();
        tVar.f400812a = 1;
        tVar.f400813b = 4;
        sVar.f400807e = tVar;
        Size a16 = l.f253953a.a(filePath);
        sVar.f400808f = a16.getWidth();
        sVar.f400809g = a16.getHeight();
        sVar.f400811i = false;
        aqVar.f400729a = sVar;
        aqVar.f400730b = 0;
        Unit unit = Unit.INSTANCE;
        atVar.f400735a = new aq[]{aqVar};
        atVar.f400736b = true;
        ahVar.f400679b = atVar;
        return ahVar;
    }

    private final ah f(w msgInfo) {
        ah ahVar = new ah();
        ai aiVar = new ai();
        f fVar = new f();
        fVar.f400770a = Random.INSTANCE.nextLong();
        fVar.f400771b = 101;
        aiVar.f400688a = fVar;
        am amVar = new am();
        amVar.f400708a = 2;
        amVar.f400709b = 1;
        amVar.f400710c = 11;
        amVar.f400711d = 5;
        aiVar.f400689b = amVar;
        d dVar = new d();
        dVar.f400766a = 2;
        aiVar.f400690c = dVar;
        ahVar.f400678a = aiVar;
        ao aoVar = new ao();
        aoVar.f400723a = false;
        aoVar.f400725c = msgInfo;
        ahVar.f400683f = aoVar;
        return ahVar;
    }

    private final ah g(v indexNode) {
        ah ahVar = new ah();
        ai aiVar = new ai();
        f fVar = new f();
        fVar.f400770a = Random.INSTANCE.nextLong();
        fVar.f400771b = 200;
        aiVar.f400688a = fVar;
        am amVar = new am();
        amVar.f400708a = 2;
        amVar.f400709b = 1;
        amVar.f400710c = 11;
        amVar.f400711d = 5;
        aiVar.f400689b = amVar;
        d dVar = new d();
        dVar.f400766a = 2;
        aiVar.f400690c = dVar;
        ahVar.f400678a = aiVar;
        n nVar = new n();
        nVar.f400791a = indexNode;
        ahVar.f400680c = nVar;
        return ahVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0037, code lost:
    
        if (r1 == null) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final e h(au rsp, byte[][] cumulateSha1) {
        Object firstOrNull;
        String str;
        byte[] bArr;
        Object firstOrNull2;
        int i3;
        Object firstOrNull3;
        byte[] bArr2;
        v vVar;
        e eVar = new e();
        z[] zVarArr = rsp.f400748f.f400825a;
        Intrinsics.checkNotNullExpressionValue(zVarArr, "rsp.msgInfo.msgInfoBody");
        firstOrNull = ArraysKt___ArraysKt.firstOrNull(zVarArr);
        z zVar = (z) firstOrNull;
        if (zVar != null && (vVar = zVar.f400830a) != null) {
            str = vVar.f400819b;
        } else {
            str = null;
        }
        eVar.f415424a = str;
        String ukey = rsp.f400743a;
        if (ukey != null) {
            Intrinsics.checkNotNullExpressionValue(ukey, "ukey");
            bArr = ukey.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bArr, "this as java.lang.String).getBytes(charset)");
        }
        bArr = WireFormatNano.EMPTY_BYTES;
        eVar.f415425b = bArr;
        aj[] ajVarArr = rsp.f400749g;
        Intrinsics.checkNotNullExpressionValue(ajVarArr, "rsp.extinfo");
        firstOrNull2 = ArraysKt___ArraysKt.firstOrNull(ajVarArr);
        aj ajVar = (aj) firstOrNull2;
        if (ajVar != null) {
            i3 = ajVar.f400693b;
        } else {
            i3 = 0;
        }
        eVar.f415426c = i3;
        aj[] ajVarArr2 = rsp.f400749g;
        Intrinsics.checkNotNullExpressionValue(ajVarArr2, "rsp.extinfo");
        firstOrNull3 = ArraysKt___ArraysKt.firstOrNull(ajVarArr2);
        aj ajVar2 = (aj) firstOrNull3;
        if (ajVar2 == null || (bArr2 = ajVar2.f400694c) == null) {
            bArr2 = WireFormatNano.EMPTY_BYTES;
        }
        eVar.f415427d = bArr2;
        lq4.b bVar = new lq4.b();
        eu4.a[] aVarArr = rsp.f400745c;
        Intrinsics.checkNotNullExpressionValue(aVarArr, "rsp.ipv4");
        ArrayList arrayList = new ArrayList();
        for (eu4.a it : aVarArr) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            lq4.d p16 = p(it);
            if (p16 != null) {
                arrayList.add(p16);
            }
        }
        Object[] array = arrayList.toArray(new lq4.d[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        bVar.f415418a = (lq4.d[]) array;
        eVar.f415428e = bVar;
        eVar.f415429f = com.tencent.mobileqq.nearbypro.request.c.c(rsp.f400748f);
        eVar.f415430g = 1048576;
        lq4.a aVar = new lq4.a();
        aVar.f415417a = cumulateSha1;
        eVar.f415431h = aVar;
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ITransFileController i() {
        return (ITransFileController) this.transController.getValue();
    }

    private final Object k(NearbyProBaseRequest nearbyProBaseRequest, Continuation<? super ak> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        j.e().b(nearbyProBaseRequest, new b(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0091  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Object l(String str, au auVar, byte[][] bArr, Continuation<? super FileMsg> continuation) {
        Continuation intercepted;
        z[] zVarArr;
        Object result;
        Object coroutine_suspended;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        w wVar = auVar.f400748f;
        if (wVar != null) {
            zVarArr = wVar.f400825a;
        } else {
            zVarArr = null;
        }
        if (zVarArr != null) {
            aj[] ajVarArr = auVar.f400749g;
            if (ajVarArr != null) {
                if (ajVarArr.length == 0) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                if (!z19) {
                    z16 = false;
                    if (!z16) {
                        eu4.a[] aVarArr = auVar.f400745c;
                        if (aVarArr != null) {
                            if (aVarArr.length == 0) {
                                z18 = true;
                            } else {
                                z18 = false;
                            }
                            if (!z18) {
                                z17 = false;
                                if (!z17) {
                                    final c cVar = new c(cancellableContinuationImpl, Looper.getMainLooper());
                                    cVar.addFilter(BDHCommonUploadProcessor.class);
                                    i().addHandle(cVar);
                                    i().transferAsync(d(str, com.tencent.mobileqq.nearbypro.request.c.c(h(auVar, bArr))));
                                    cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.nearbypro.repository.service.BDHService$sendFile$2$2
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                                            invoke2(th5);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(@Nullable Throwable th5) {
                                            j.c().c("NearbyProBDHService", "SendFile: removeHandle");
                                            BDHService.this.i().removeHandle(cVar);
                                        }
                                    });
                                    result = cancellableContinuationImpl.getResult();
                                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    if (result == coroutine_suspended) {
                                        DebugProbes.probeCoroutineSuspended(continuation);
                                    }
                                    return result;
                                }
                            }
                        }
                        z17 = true;
                        if (!z17) {
                        }
                    }
                }
            }
            z16 = true;
            if (!z16) {
            }
        }
        j.c().d("NearbyProBDHService", "SendFile: uploadRsp is invalid");
        cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(null));
        result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
        }
        return result;
    }

    private final Object m(String str, Continuation<? super ak> continuation) {
        return k(new BeginUpReq(e(str), null, 0, 0, 14, null), continuation);
    }

    private final Object n(w wVar, Continuation<? super ak> continuation) {
        return k(new EndUpReq(f(wVar), null, 0, 0, 14, null), continuation);
    }

    private final lq4.d p(eu4.a aVar) {
        lq4.d dVar = new lq4.d();
        lq4.c cVar = new lq4.c();
        cVar.f415420b = NetworkUtil.intAddr2Ip(aVar.f397171c);
        cVar.f415419a = 1;
        dVar.f415422a = cVar;
        dVar.f415423b = aVar.f397172d;
        return dVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object j(@Nullable v vVar, @NotNull Continuation<? super List<String>> continuation) {
        BDHService$reqDownPhoto$1 bDHService$reqDownPhoto$1;
        Object coroutine_suspended;
        int i3;
        List emptyList;
        o oVar;
        List emptyList2;
        if (continuation instanceof BDHService$reqDownPhoto$1) {
            bDHService$reqDownPhoto$1 = (BDHService$reqDownPhoto$1) continuation;
            int i16 = bDHService$reqDownPhoto$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                bDHService$reqDownPhoto$1.label = i16 - Integer.MIN_VALUE;
                Object obj = bDHService$reqDownPhoto$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = bDHService$reqDownPhoto$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    if (vVar == null) {
                        emptyList = CollectionsKt__CollectionsKt.emptyList();
                        return emptyList;
                    }
                    NearbyProBaseRequest downloadReq = new DownloadReq(g(vVar), null, 0, 0, 14, null);
                    bDHService$reqDownPhoto$1.label = 1;
                    obj = k(downloadReq, bDHService$reqDownPhoto$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                oVar = ((ak) obj).f400697c;
                if (oVar != null) {
                    j.c().d("NearbyProBDHService", "reqDownPhoto: rsp is null");
                    emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                    return emptyList2;
                }
                return Companion.b(INSTANCE, oVar, false, null, 3, null);
            }
        }
        bDHService$reqDownPhoto$1 = new BDHService$reqDownPhoto$1(this, continuation);
        Object obj2 = bDHService$reqDownPhoto$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = bDHService$reqDownPhoto$1.label;
        if (i3 == 0) {
        }
        oVar = ((ak) obj2).f400697c;
        if (oVar != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object o(@NotNull String str, @NotNull Continuation<? super w> continuation) {
        BDHService$sendPhoto$1 bDHService$sendPhoto$1;
        Object coroutine_suspended;
        int i3;
        byte[][] bArr;
        Object m3;
        BDHService bDHService;
        au auVar;
        au auVar2;
        BDHService bDHService2;
        if (continuation instanceof BDHService$sendPhoto$1) {
            bDHService$sendPhoto$1 = (BDHService$sendPhoto$1) continuation;
            int i16 = bDHService$sendPhoto$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                bDHService$sendPhoto$1.label = i16 - Integer.MIN_VALUE;
                Object obj = bDHService$sendPhoto$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = bDHService$sendPhoto$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 == 3) {
                                auVar2 = (au) bDHService$sendPhoto$1.L$0;
                                ResultKt.throwOnFailure(obj);
                                j.c().c("DBHService", "sendPhoto R-DEBUG: endTransfer: " + com.tencent.mobileqq.nearbypro.request.c.d((ak) obj));
                                return auVar2.f400748f;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        auVar2 = (au) bDHService$sendPhoto$1.L$1;
                        bDHService2 = (BDHService) bDHService$sendPhoto$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        if (((FileMsg) obj) != null) {
                            j.c().d("NearbyProBDHService", "sendPhoto: fileMag is null");
                            return null;
                        }
                        w wVar = auVar2.f400748f;
                        Intrinsics.checkNotNullExpressionValue(wVar, "uploadRsp.msgInfo");
                        bDHService$sendPhoto$1.L$0 = auVar2;
                        bDHService$sendPhoto$1.L$1 = null;
                        bDHService$sendPhoto$1.label = 3;
                        obj = bDHService2.n(wVar, bDHService$sendPhoto$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        j.c().c("DBHService", "sendPhoto R-DEBUG: endTransfer: " + com.tencent.mobileqq.nearbypro.request.c.d((ak) obj));
                        return auVar2.f400748f;
                    }
                    byte[][] bArr2 = (byte[][]) bDHService$sendPhoto$1.L$2;
                    String str2 = (String) bDHService$sendPhoto$1.L$1;
                    bDHService = (BDHService) bDHService$sendPhoto$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    bArr = bArr2;
                    str = str2;
                    m3 = obj;
                } else {
                    ResultKt.throwOnFailure(obj);
                    ArrayList<byte[]> p16 = cq.p(str);
                    Intrinsics.checkNotNullExpressionValue(p16, "genFileCumulateSha1(filePath)");
                    Object[] array = p16.toArray(new byte[0]);
                    Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    bArr = (byte[][]) array;
                    bDHService$sendPhoto$1.L$0 = this;
                    bDHService$sendPhoto$1.L$1 = str;
                    bDHService$sendPhoto$1.L$2 = bArr;
                    bDHService$sendPhoto$1.label = 1;
                    m3 = m(str, bDHService$sendPhoto$1);
                    if (m3 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    bDHService = this;
                }
                auVar = ((ak) m3).f400696b;
                if (auVar != null) {
                    j.c().d("NearbyProBDHService", "sendPhoto: uploadRsp is null");
                    return null;
                }
                bDHService$sendPhoto$1.L$0 = bDHService;
                bDHService$sendPhoto$1.L$1 = auVar;
                bDHService$sendPhoto$1.L$2 = null;
                bDHService$sendPhoto$1.label = 2;
                obj = bDHService.l(str, auVar, bArr, bDHService$sendPhoto$1);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                auVar2 = auVar;
                bDHService2 = bDHService;
                if (((FileMsg) obj) != null) {
                }
            }
        }
        bDHService$sendPhoto$1 = new BDHService$sendPhoto$1(this, continuation);
        Object obj2 = bDHService$sendPhoto$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = bDHService$sendPhoto$1.label;
        if (i3 == 0) {
        }
        auVar = ((ak) m3).f400696b;
        if (auVar != null) {
        }
    }
}
