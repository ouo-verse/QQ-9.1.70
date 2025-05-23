package ph4;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.utils.l;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.YoloRoomOuterClass$ApplyUser;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomApplySpeakingListRsp;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00072\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0006\u0010\u0003\u001a\u00020\u0002J\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004J\u0016\u0010\f\u001a\u00020\u000b2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bJ\u0014\u0010\r\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bR\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R \u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lph4/f;", "", "", "e", "Landroidx/lifecycle/LiveData;", "", "Ltrpc/yes/common/YoloRoomOuterClass$ApplyUser;", "d", "Lpl4/d;", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomApplySpeakingListRsp;", "listener", "", "f", "g", "a", "J", "mRoomId", "b", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomApplySpeakingListRsp;", "mLastRsp", "Landroidx/lifecycle/MutableLiveData;", "c", "Landroidx/lifecycle/MutableLiveData;", "mCurrentListLiveData", "<init>", "(J)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long mRoomId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private YoloRoomOuterClass$YoloRoomApplySpeakingListRsp mLastRsp;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<YoloRoomOuterClass$ApplyUser>> mCurrentListLiveData = new MutableLiveData<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016JP\u0010\u0011\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0012"}, d2 = {"ph4/f$b", "Lpl4/d;", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomApplySpeakingListRsp;", "response", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "originalMsfRsp", "", "d", "", "isMsfSuccess", "", "msfResultCode", "timiErrCode", "timiSubErrCode", "", "timiErrMsg", "timiDisplayErrMsg", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements pl4.d<YoloRoomOuterClass$YoloRoomApplySpeakingListRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ pl4.d<YoloRoomOuterClass$YoloRoomApplySpeakingListRsp> f426256a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ f f426257b;

        b(pl4.d<YoloRoomOuterClass$YoloRoomApplySpeakingListRsp> dVar, f fVar) {
            this.f426256a = dVar;
            this.f426257b = fVar;
        }

        @Override // pl4.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(boolean isMsfSuccess, int msfResultCode, int timiErrCode, int timiSubErrCode, @Nullable String timiErrMsg, @Nullable String timiDisplayErrMsg, @Nullable YoloRoomOuterClass$YoloRoomApplySpeakingListRsp response, @Nullable FromServiceMsg originalMsfRsp) {
            l.c("MicApplyUserRepo_", 1, "requesting first page data failed," + timiErrCode + ", " + timiErrMsg + ", " + this.f426257b.mRoomId);
            pl4.d<YoloRoomOuterClass$YoloRoomApplySpeakingListRsp> dVar = this.f426256a;
            if (dVar != null) {
                dVar.b(isMsfSuccess, msfResultCode, timiErrCode, timiSubErrCode, timiErrMsg, timiDisplayErrMsg, response, originalMsfRsp);
            }
        }

        @Override // pl4.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(@Nullable YoloRoomOuterClass$YoloRoomApplySpeakingListRsp response, @Nullable FromServiceMsg originalMsfRsp) {
            PBRepeatMessageField<YoloRoomOuterClass$ApplyUser> pBRepeatMessageField;
            List<YoloRoomOuterClass$ApplyUser> list;
            pl4.d<YoloRoomOuterClass$YoloRoomApplySpeakingListRsp> dVar = this.f426256a;
            if (dVar != null) {
                dVar.a(response, originalMsfRsp);
            }
            this.f426257b.mLastRsp = response;
            ArrayList arrayList = new ArrayList();
            if (response != null && (pBRepeatMessageField = response.apply_users) != null && (list = pBRepeatMessageField.get()) != null) {
                arrayList.addAll(list);
            }
            l.h("MicApplyUserRepo_", 1, "requesting first page data succeed " + this.f426257b.mRoomId + ", listSize: " + arrayList.size());
            this.f426257b.mCurrentListLiveData.setValue(arrayList);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016JP\u0010\u0011\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0012"}, d2 = {"ph4/f$c", "Lpl4/d;", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomApplySpeakingListRsp;", "response", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "originalMsfRsp", "", "d", "", "isMsfSuccess", "", "msfResultCode", "timiErrCode", "timiSubErrCode", "", "timiErrMsg", "timiDisplayErrMsg", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements pl4.d<YoloRoomOuterClass$YoloRoomApplySpeakingListRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ pl4.d<YoloRoomOuterClass$YoloRoomApplySpeakingListRsp> f426258a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ f f426259b;

        c(pl4.d<YoloRoomOuterClass$YoloRoomApplySpeakingListRsp> dVar, f fVar) {
            this.f426258a = dVar;
            this.f426259b = fVar;
        }

        @Override // pl4.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(boolean isMsfSuccess, int msfResultCode, int timiErrCode, int timiSubErrCode, @Nullable String timiErrMsg, @Nullable String timiDisplayErrMsg, @Nullable YoloRoomOuterClass$YoloRoomApplySpeakingListRsp response, @Nullable FromServiceMsg originalMsfRsp) {
            l.i("MicApplyUserRepo_", "requesting next page data failed," + timiErrCode + ", " + timiErrMsg + ", " + this.f426259b.mRoomId);
            this.f426258a.b(isMsfSuccess, msfResultCode, timiErrCode, timiSubErrCode, timiErrMsg, timiDisplayErrMsg, response, originalMsfRsp);
        }

        @Override // pl4.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(@Nullable YoloRoomOuterClass$YoloRoomApplySpeakingListRsp response, @Nullable FromServiceMsg originalMsfRsp) {
            boolean z16;
            PBRepeatMessageField<YoloRoomOuterClass$ApplyUser> pBRepeatMessageField;
            List<YoloRoomOuterClass$ApplyUser> list;
            this.f426258a.a(response, originalMsfRsp);
            this.f426259b.mLastRsp = response;
            ArrayList arrayList = new ArrayList();
            List list2 = (List) this.f426259b.mCurrentListLiveData.getValue();
            if (list2 != null) {
                arrayList.addAll(list2);
            }
            if (response != null && (pBRepeatMessageField = response.apply_users) != null && (list = pBRepeatMessageField.get()) != null) {
                arrayList.addAll(list);
                z16 = true;
            } else {
                z16 = false;
            }
            l.h("MicApplyUserRepo_", 1, "requesting next page data succeed " + this.f426259b.mRoomId + ", currentList: " + arrayList.size() + ", updated:" + z16);
            if (z16) {
                this.f426259b.mCurrentListLiveData.setValue(arrayList);
            }
        }
    }

    public f(long j3) {
        this.mRoomId = j3;
    }

    @NotNull
    public final LiveData<List<YoloRoomOuterClass$ApplyUser>> d() {
        return this.mCurrentListLiveData;
    }

    /* renamed from: e, reason: from getter */
    public final long getMRoomId() {
        return this.mRoomId;
    }

    public final void f(@Nullable pl4.d<YoloRoomOuterClass$YoloRoomApplySpeakingListRsp> listener) {
        this.mLastRsp = null;
        l.h("MicApplyUserRepo_", 1, "requesting first page data, roomId:" + this.mRoomId + ", lastMin:" + ((Object) "null"));
        oh4.a.INSTANCE.b(this.mRoomId, this.mLastRsp, new b(listener, this));
    }

    public final void g(@NotNull pl4.d<YoloRoomOuterClass$YoloRoomApplySpeakingListRsp> listener) {
        boolean z16;
        Object obj;
        PBUInt64Field pBUInt64Field;
        PBBoolField pBBoolField;
        Intrinsics.checkNotNullParameter(listener, "listener");
        YoloRoomOuterClass$YoloRoomApplySpeakingListRsp yoloRoomOuterClass$YoloRoomApplySpeakingListRsp = this.mLastRsp;
        if (yoloRoomOuterClass$YoloRoomApplySpeakingListRsp != null && (pBBoolField = yoloRoomOuterClass$YoloRoomApplySpeakingListRsp.has_more) != null) {
            z16 = pBBoolField.get();
        } else {
            z16 = true;
        }
        long j3 = this.mRoomId;
        YoloRoomOuterClass$YoloRoomApplySpeakingListRsp yoloRoomOuterClass$YoloRoomApplySpeakingListRsp2 = this.mLastRsp;
        if (yoloRoomOuterClass$YoloRoomApplySpeakingListRsp2 != null && (pBUInt64Field = yoloRoomOuterClass$YoloRoomApplySpeakingListRsp2.next_score) != null) {
            obj = Long.valueOf(pBUInt64Field.get());
        } else {
            obj = "null";
        }
        l.h("MicApplyUserRepo_", 1, "requesting next page data, hasMore:" + z16 + ", roomId:" + j3 + ", lastMin:" + obj);
        if (!z16) {
            listener.a(this.mLastRsp, new FromServiceMsg());
        } else {
            oh4.a.INSTANCE.b(this.mRoomId, this.mLastRsp, new c(listener, this));
        }
    }
}
