package com.tencent.mobileqq.troop.file.search.repo;

import android.os.Bundle;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.m;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.transaction.TransReport;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.troop.data.n;
import com.tencent.mobileqq.troop.data.s;
import com.tencent.mobileqq.troop.file.search.model.TroopFileSearchByTypeArgsModel;
import com.tencent.mobileqq.troop.file.search.vm.a;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import tencent.im.cs.cmd0x383.cmd0x383$ApplyFileSearchReqBody;
import tencent.im.cs.cmd0x383.cmd0x383$ApplyFileSearchRspBody;
import tencent.im.cs.cmd0x383.cmd0x383$ReqBody;
import tencent.im.cs.cmd0x383.cmd0x383$RspBody;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 [2\u00020\u0001:\u0001\\B2\u0012\u0006\u0010+\u001a\u00020'\u0012!\u00104\u001a\u001d\u0012\u0013\u0012\u00110-\u00a2\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u00040,\u00a2\u0006\u0004\bY\u0010ZJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u001a\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\rJ&\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\rJ\"\u0010!\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u00142\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\u0006\u0010\"\u001a\u00020\u0004J\u0006\u0010#\u001a\u00020\u0004J\u0010\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010$\u001a\u00020\nR\u0017\u0010+\u001a\u00020'8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010(\u001a\u0004\b)\u0010*R2\u00104\u001a\u001d\u0012\u0013\u0012\u00110-\u00a2\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u00040,8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u00101\u001a\u0004\b2\u00103R#\u0010;\u001a\n 6*\u0004\u0018\u000105058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R&\u0010@\u001a\u0012\u0012\u0004\u0012\u00020%0<j\b\u0012\u0004\u0012\u00020%`=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R2\u0010D\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020%0Aj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020%`B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010CR\u0016\u0010F\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010ER\u0016\u0010I\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010M\u001a\u00020J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010O\u001a\u00020\r8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bN\u0010HR\u0016\u0010Q\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010HR\u0016\u0010S\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010ER\u001c\u0010V\u001a\n 6*\u0004\u0018\u00010T0T8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b7\u0010UR\u0014\u0010X\u001a\u00020\u00148BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b>\u0010W\u00a8\u0006]"}, d2 = {"Lcom/tencent/mobileqq/troop/file/search/repo/TroopFileSearchByTypeRepo;", "Lmqq/observer/BusinessObserver;", "", "rspBodyBytes", "", "k", "", "Ltencent/im/cs/cmd0x383/cmd0x383$ApplyFileSearchRspBody$Item;", "fileList", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "qqStr", "p", "", "busId", "r", "msg", "", SemanticAttributes.DbCassandraConsistencyLevelValues.ANY, DomainData.DOMAIN_NAME, "", "b", "o", "requestForm", "d", "fileId", WadlProxyConsts.PARAM_FILENAME, "thumbnailSizeSmall", "e", "type", "isSuccess", "Landroid/os/Bundle;", "bundle", "onReceive", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "filePath", "Lcom/tencent/mobileqq/troop/data/s;", "i", "Lcom/tencent/mobileqq/troop/file/search/model/TroopFileSearchByTypeArgsModel;", "Lcom/tencent/mobileqq/troop/file/search/model/TroopFileSearchByTypeArgsModel;", "g", "()Lcom/tencent/mobileqq/troop/file/search/model/TroopFileSearchByTypeArgsModel;", "args", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/troop/file/search/vm/a;", "Lkotlin/ParameterName;", "name", "state", "Lkotlin/jvm/functions/Function1;", "getUpdateState", "()Lkotlin/jvm/functions/Function1;", "updateState", "Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;", "kotlin.jvm.PlatformType", "f", "Lkotlin/Lazy;", "j", "()Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;", "troopFileTransMgr", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", h.F, "Ljava/util/ArrayList;", "searchResult", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "dataMap", "Z", "hasRequestMore", BdhLogUtil.LogTag.Tag_Conn, "I", "reqFrom", "Lcom/tencent/mobileqq/pb/ByteStringMicro;", "D", "Lcom/tencent/mobileqq/pb/ByteStringMicro;", "cookie", "E", "pageSize", UserInfo.SEX_FEMALE, "requestCount", "G", "isEnd", "Lcom/tencent/mobileqq/app/QQAppInterface;", "()Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "()Z", TransReport.rep_has_net, "<init>", "(Lcom/tencent/mobileqq/troop/file/search/model/TroopFileSearchByTypeArgsModel;Lkotlin/jvm/functions/Function1;)V", "H", "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class TroopFileSearchByTypeRepo implements BusinessObserver {

    /* renamed from: C, reason: from kotlin metadata */
    private int reqFrom;

    /* renamed from: D, reason: from kotlin metadata */
    private ByteStringMicro cookie;

    /* renamed from: E, reason: from kotlin metadata */
    private final int pageSize;

    /* renamed from: F, reason: from kotlin metadata */
    private int requestCount;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean isEnd;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final TroopFileSearchByTypeArgsModel args;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Function1<a, Unit> updateState;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy troopFileTransMgr;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ArrayList<s> searchResult;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private HashMap<String, s> dataMap;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean hasRequestMore;

    /* JADX WARN: Multi-variable type inference failed */
    public TroopFileSearchByTypeRepo(TroopFileSearchByTypeArgsModel args, Function1<? super a, Unit> updateState) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(updateState, "updateState");
        this.args = args;
        this.updateState = updateState;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<TroopFileTransferManager>() { // from class: com.tencent.mobileqq.troop.file.search.repo.TroopFileSearchByTypeRepo$troopFileTransMgr$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TroopFileTransferManager invoke() {
                QQAppInterface f16;
                f16 = TroopFileSearchByTypeRepo.this.f();
                return TroopFileTransferManager.O(f16, TroopFileSearchByTypeRepo.this.getArgs().c());
            }
        });
        this.troopFileTransMgr = lazy;
        this.searchResult = new ArrayList<>();
        this.dataMap = new HashMap<>();
        ByteStringMicro copyFromUtf8 = ByteStringMicro.copyFromUtf8("");
        Intrinsics.checkNotNullExpressionValue(copyFromUtf8, "copyFromUtf8(\"\")");
        this.cookie = copyFromUtf8;
        this.pageSize = 20;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QQAppInterface f() {
        return TroopUtils.f();
    }

    private final boolean h() {
        return TroopFileUtils.c(f().getApplicationContext()) != 0;
    }

    private final TroopFileTransferManager j() {
        return (TroopFileTransferManager) this.troopFileTransMgr.getValue();
    }

    private final void k(byte[] rspBodyBytes) {
        cmd0x383$RspBody cmd0x383_rspbody = new cmd0x383$RspBody();
        try {
            cmd0x383_rspbody.mergeFrom(rspBodyBytes);
            int i3 = cmd0x383_rspbody.int32_ret_code.get();
            if (i3 < 0) {
                String qqStr = HardCodeUtil.qqStr(i3 == -22 ? R.string.ufe : R.string.f172813uf1);
                Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(if (retCode == -22\u2026.qqstr_troopfil_48bedd29)");
                p(qqStr);
                if (this.reqFrom == 0) {
                    if (!this.searchResult.isEmpty()) {
                        n(1, this.searchResult);
                        return;
                    } else {
                        r(1);
                        return;
                    }
                }
                this.updateState.invoke(new a.f(8));
                return;
            }
            cmd0x383$ApplyFileSearchRspBody cmd0x383_applyfilesearchrspbody = cmd0x383_rspbody.msg_file_search_rsp_body.get();
            if (cmd0x383_applyfilesearchrspbody == null) {
                if (this.reqFrom == 0) {
                    r(1);
                    return;
                } else {
                    r(2);
                    return;
                }
            }
            ByteStringMicro byteStringMicro = cmd0x383_applyfilesearchrspbody.bytes_sync_cookie.get();
            Intrinsics.checkNotNullExpressionValue(byteStringMicro, "rsp.bytes_sync_cookie.get()");
            this.cookie = byteStringMicro;
            int i16 = 0;
            this.isEnd = cmd0x383_applyfilesearchrspbody.uint32_is_end.get() == 1;
            if (QLog.isDebugVersion()) {
                QLog.d("TroopFile.Search.TroopFileSearchByTypeRepo", 4, "onRspTroopFileSearch cookie=" + this.cookie.toStringUtf8() + ", isEnd=" + this.isEnd + ", keyWord=" + cmd0x383_applyfilesearchrspbody.bytes_key_word.get().toStringUtf8() + ", totalCount=" + cmd0x383_applyfilesearchrspbody.uint32_total_match_count.get());
            }
            if (this.reqFrom == 0) {
                this.searchResult.clear();
            }
            List<cmd0x383$ApplyFileSearchRspBody.Item> list = cmd0x383_applyfilesearchrspbody.item_list.get();
            if (list == null) {
                if (this.isEnd) {
                    if (this.reqFrom == 0) {
                        n(0, this.searchResult);
                        return;
                    } else {
                        this.updateState.invoke(new a.f(8));
                        return;
                    }
                }
                if (this.requestCount < 3) {
                    d(1);
                    this.requestCount++;
                    return;
                }
                return;
            }
            m(list);
            if (this.searchResult.size() < 15 && !this.isEnd && this.requestCount < 3) {
                d(1);
                this.requestCount++;
                return;
            }
            this.requestCount = 0;
            if (!this.searchResult.isEmpty() || this.reqFrom != 0) {
                i16 = 1;
            }
            n(i16, this.searchResult);
            if (this.isEnd) {
                this.updateState.invoke(new a.f(8));
            }
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("TroopFile.Search.TroopFileSearchByTypeRepo", 1, "InvalidProtocolBufferMicroException, " + e16.getMessage());
        }
    }

    private final void m(List<cmd0x383$ApplyFileSearchRspBody.Item> fileList) {
        int size = fileList.size();
        for (int i3 = 0; i3 < size; i3++) {
            s sVar = new s(f(), fileList.get(i3));
            if (sVar.f294966i != null) {
                TroopFileManager F = TroopFileManager.F(f(), sVar.f294958a);
                n A = F.A(sVar.f294966i.f294916b);
                if (A != null) {
                    sVar.f294966i.f294915a = A.f294915a;
                } else {
                    sVar.f294966i.f294915a = UUID.randomUUID();
                }
                n nVar = sVar.f294966i;
                F.R(nVar.f294916b, nVar);
            }
            if (QLog.isDebugVersion()) {
                QLog.d("TroopFile.Search.TroopFileSearchByTypeRepo", 4, "fileList" + i3 + MsgSummary.STR_COLON + sVar);
            }
            this.searchResult.add(sVar);
            HashMap<String, s> hashMap = this.dataMap;
            String str = sVar.f294966i.f294916b;
            Intrinsics.checkNotNullExpressionValue(str, "itemData.mFileInfo.mFileId");
            hashMap.put(str, sVar);
        }
    }

    private final void n(int msg2, Object any) {
        this.updateState.invoke(new a.C8686a(msg2, any));
    }

    private final void o(boolean b16) {
        this.updateState.invoke(new a.b(b16));
    }

    private final void p(String qqStr) {
        this.updateState.invoke(new a.c(qqStr, 0, 2, null));
    }

    private final void r(int busId) {
        this.updateState.invoke(new a.d(busId));
    }

    public final void d(int requestForm) {
        cmd0x383$ApplyFileSearchReqBody cmd0x383_applyfilesearchreqbody = new cmd0x383$ApplyFileSearchReqBody();
        cmd0x383_applyfilesearchreqbody.bytes_sync_cookie.set(this.cookie);
        cmd0x383_applyfilesearchreqbody.uint32_search_type.set(2);
        cmd0x383_applyfilesearchreqbody.uint32_file_type.set(this.args.a());
        cmd0x383_applyfilesearchreqbody.uint32_count.set(this.pageSize);
        cmd0x383$ReqBody cmd0x383_reqbody = new cmd0x383$ReqBody();
        cmd0x383_reqbody.uint64_groupcode.set(this.args.c());
        cmd0x383_reqbody.uint32_app_id.set(3);
        cmd0x383_reqbody.msg_file_search_req_body.set(cmd0x383_applyfilesearchreqbody);
        cmd0x383_reqbody.setHasFlag(true);
        Bundle bundle = new Bundle();
        bundle.putInt("request_from", requestForm);
        NewIntent newIntent = new NewIntent(f().getApp(), m.class);
        newIntent.putExtra("cmd", "GroupFileAppSvr.GetFileSearch");
        newIntent.putExtra("data", cmd0x383_reqbody.toByteArray());
        newIntent.putExtras(bundle);
        newIntent.setObserver(this);
        f().startServlet(newIntent);
    }

    public final void e(String fileId, String fileName, int busId, int thumbnailSizeSmall) {
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        j().C(fileId, fileName, busId, thumbnailSizeSmall, null);
    }

    /* renamed from: g, reason: from getter */
    public final TroopFileSearchByTypeArgsModel getArgs() {
        return this.args;
    }

    public final s i(String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        return this.dataMap.get(filePath);
    }

    public final void l() {
        QLog.i("TroopFile.Search.TroopFileSearchByTypeRepo", 1, "initData, " + getArgs());
        this.updateState.invoke(new a.d(4));
        if (h()) {
            d(0);
            return;
        }
        String qqStr = HardCodeUtil.qqStr(R.string.uew);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.qqstr_troopfil_3bf51540)");
        p(qqStr);
        r(1);
    }

    public final void q() {
        if (this.hasRequestMore || this.searchResult.isEmpty()) {
            return;
        }
        if (this.isEnd) {
            o(true);
            return;
        }
        if (h()) {
            o(false);
            this.hasRequestMore = true;
            d(1);
        } else {
            o(true);
            String qqStr = HardCodeUtil.qqStr(R.string.ufd);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.qqstr_troopfil_7b26c479)");
            p(qqStr);
        }
    }

    @Override // mqq.observer.BusinessObserver
    public void onReceive(int type, boolean isSuccess, Bundle bundle) {
        Object m476constructorimpl;
        Unit unit;
        try {
            Result.Companion companion = Result.INSTANCE;
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        if (bundle == null) {
            if (!this.searchResult.isEmpty()) {
                this.hasRequestMore = false;
                r(2);
                return;
            } else {
                r(1);
                return;
            }
        }
        if (isSuccess) {
            byte[] byteArray = bundle.getByteArray("data");
            int i3 = bundle.getInt("request_from");
            this.reqFrom = i3;
            if (i3 == 1) {
                this.hasRequestMore = false;
            }
            if (byteArray != null) {
                k(byteArray);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
        } else {
            int i16 = bundle.getInt("request_from");
            this.reqFrom = i16;
            if (i16 == 0) {
                r(1);
            } else {
                this.hasRequestMore = false;
                r(2);
            }
            unit = Unit.INSTANCE;
        }
        m476constructorimpl = Result.m476constructorimpl(unit);
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            QLog.e("TroopFile.Search.TroopFileSearchByTypeRepo", 1, "onReceive err, " + m479exceptionOrNullimpl.getMessage());
        }
    }
}
