package com.tencent.mobileqq.zootopia.portal.detail;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.zootopia.portal.detail.a;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.sqshow.zootopia.data.ErrorMessage;
import com.tencent.sqshow.zootopia.data.ZootopiaMapComment;
import com.tencent.sqshow.zootopia.data.ZootopiaMapDetail;
import com.tencent.sqshow.zootopia.data.ZootopiaMapSimpleInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zb3.ZootopiaMapCommentResp;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u00106\u001a\u00020\u0002\u00a2\u0006\u0004\b7\u00108J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0006R.\u0010\u0011\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00128F@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00030\u001a8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\u001d\u001a\u0004\b\"\u0010\u001fR%\u0010+\u001a\u0010\u0012\f\u0012\n &*\u0004\u0018\u00010%0%0$8\u0006\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R%\u0010.\u001a\u0010\u0012\f\u0012\n &*\u0004\u0018\u00010%0%0$8\u0006\u00a2\u0006\f\n\u0004\b,\u0010(\u001a\u0004\b-\u0010*R%\u00101\u001a\u0010\u0012\f\u0012\n &*\u0004\u0018\u00010%0%0$8\u0006\u00a2\u0006\f\n\u0004\b/\u0010(\u001a\u0004\b0\u0010*R\u001d\u00105\u001a\b\u0012\u0004\u0012\u0002020\u001a8\u0006\u00a2\u0006\f\n\u0004\b3\u0010\u001d\u001a\u0004\b4\u0010\u001f\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/zootopia/portal/detail/am;", "Lcom/tencent/mobileqq/mvvm/c;", "Lcom/tencent/mobileqq/zootopia/portal/detail/ai;", "Lzb3/h;", "commentResp", "P1", "", "b2", ICustomDataEditor.STRING_ARRAY_PARAM_2, "Lcom/tencent/sqshow/zootopia/data/ZootopiaMapSimpleInfo;", "value", "i", "Lcom/tencent/sqshow/zootopia/data/ZootopiaMapSimpleInfo;", "U1", "()Lcom/tencent/sqshow/zootopia/data/ZootopiaMapSimpleInfo;", "f2", "(Lcom/tencent/sqshow/zootopia/data/ZootopiaMapSimpleInfo;)V", "mapItemInfo", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "T1", "()I", "e2", "(I)V", "mapId", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/sqshow/zootopia/data/m;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "R1", "()Landroidx/lifecycle/MutableLiveData;", "detail", "D", "Q1", "comments", "Landroidx/lifecycle/LiveData;", "", "kotlin.jvm.PlatformType", "E", "Landroidx/lifecycle/LiveData;", "Z1", "()Landroidx/lifecycle/LiveData;", "visitorsText", UserInfo.SEX_FEMALE, "W1", "memberText", "G", "X1", "onlineTimeText", "Lcom/tencent/sqshow/zootopia/data/a;", "H", "S1", "errorMessage", "repository", "<init>", "(Lcom/tencent/mobileqq/zootopia/portal/detail/ai;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class am extends com.tencent.mobileqq.mvvm.c<ai> {

    /* renamed from: C, reason: from kotlin metadata */
    private final MutableLiveData<ZootopiaMapDetail> detail;

    /* renamed from: D, reason: from kotlin metadata */
    private final MutableLiveData<ZootopiaMapCommentResp> comments;

    /* renamed from: E, reason: from kotlin metadata */
    private final LiveData<String> visitorsText;

    /* renamed from: F, reason: from kotlin metadata */
    private final LiveData<String> memberText;

    /* renamed from: G, reason: from kotlin metadata */
    private final LiveData<String> onlineTimeText;

    /* renamed from: H, reason: from kotlin metadata */
    private final MutableLiveData<ErrorMessage> errorMessage;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ZootopiaMapSimpleInfo mapItemInfo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mapId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zootopia/portal/detail/am$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lcom/tencent/sqshow/zootopia/data/m;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements com.tencent.mobileqq.zootopia.api.e<ZootopiaMapDetail> {
        b() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(ZootopiaMapDetail result) {
            Intrinsics.checkNotNullParameter(result, "result");
            am.this.R1().postValue(result);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            am.this.S1().postValue(new ErrorMessage(error, message));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public am(ai repository) {
        super(repository);
        Intrinsics.checkNotNullParameter(repository, "repository");
        MutableLiveData<ZootopiaMapDetail> mutableLiveData = new MutableLiveData<>();
        this.detail = mutableLiveData;
        this.comments = new MutableLiveData<>();
        LiveData<String> map = Transformations.map(mutableLiveData, new Function() { // from class: com.tencent.mobileqq.zootopia.portal.detail.aj
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String g26;
                g26 = am.g2((ZootopiaMapDetail) obj);
                return g26;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "map(detail) {\n        if\u2026       \"\"\n        }\n    }");
        this.visitorsText = map;
        LiveData<String> map2 = Transformations.map(mutableLiveData, new Function() { // from class: com.tencent.mobileqq.zootopia.portal.detail.ak
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String c26;
                c26 = am.c2((ZootopiaMapDetail) obj);
                return c26;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map2, "map(detail) { \"${it.memberCount}\u4eba/\u573a\" }");
        this.memberText = map2;
        LiveData<String> map3 = Transformations.map(mutableLiveData, new Function() { // from class: com.tencent.mobileqq.zootopia.portal.detail.al
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String d26;
                d26 = am.d2((ZootopiaMapDetail) obj);
                return d26;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map3, "map(detail) {\n        if\u2026ration)}\"\n        }\n    }");
        this.onlineTimeText = map3;
        this.errorMessage = new MutableLiveData<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ZootopiaMapCommentResp P1(ZootopiaMapCommentResp commentResp) {
        List<ZootopiaMapComment> g16;
        List<ZootopiaMapComment> a16 = commentResp.a();
        ArrayList arrayList = new ArrayList();
        for (Object obj : a16) {
            ZootopiaMapComment zootopiaMapComment = (ZootopiaMapComment) obj;
            ZootopiaMapDetail value = this.detail.getValue();
            Object obj2 = null;
            if (value != null && (g16 = value.g()) != null) {
                Iterator<T> it = g16.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (Intrinsics.areEqual(((ZootopiaMapComment) next).getCommentId(), zootopiaMapComment.getCommentId())) {
                        obj2 = next;
                        break;
                    }
                }
                obj2 = (ZootopiaMapComment) obj2;
            }
            if (obj2 == null) {
                arrayList.add(obj);
            }
        }
        return new ZootopiaMapCommentResp(arrayList, commentResp.getHasMore());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String c2(ZootopiaMapDetail zootopiaMapDetail) {
        return zootopiaMapDetail.getMemberCount() + "\u4eba/\u573a";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String g2(ZootopiaMapDetail zootopiaMapDetail) {
        if (zootopiaMapDetail.getVisitorCount() > 0) {
            return ((int) (((float) zootopiaMapDetail.getVisitorCount()) * zootopiaMapDetail.getVisitorWeight())) + "\u4eba\u8bbf\u95ee\u8fc7";
        }
        return "";
    }

    public final MutableLiveData<ZootopiaMapCommentResp> Q1() {
        return this.comments;
    }

    public final MutableLiveData<ZootopiaMapDetail> R1() {
        return this.detail;
    }

    public final MutableLiveData<ErrorMessage> S1() {
        return this.errorMessage;
    }

    public final int T1() {
        int i3 = this.mapId;
        if (i3 != 0) {
            return i3;
        }
        ZootopiaMapSimpleInfo zootopiaMapSimpleInfo = this.mapItemInfo;
        if (zootopiaMapSimpleInfo != null) {
            return zootopiaMapSimpleInfo.getMapID();
        }
        ZootopiaMapDetail value = this.detail.getValue();
        if (value != null) {
            return value.getId();
        }
        return 0;
    }

    /* renamed from: U1, reason: from getter */
    public final ZootopiaMapSimpleInfo getMapItemInfo() {
        return this.mapItemInfo;
    }

    public final LiveData<String> W1() {
        return this.memberText;
    }

    public final LiveData<String> X1() {
        return this.onlineTimeText;
    }

    public final LiveData<String> Z1() {
        return this.visitorsText;
    }

    public final void a2() {
        int T1;
        ai repository = getRepository();
        Intrinsics.checkNotNullExpressionValue(repository, "repository");
        ai aiVar = repository;
        ZootopiaMapSimpleInfo zootopiaMapSimpleInfo = this.mapItemInfo;
        if (zootopiaMapSimpleInfo != null) {
            T1 = zootopiaMapSimpleInfo.getMapID();
        } else {
            T1 = T1();
        }
        a.C9116a.a(aiVar, T1, 0, new a(), 2, null);
    }

    public final void b2() {
        int T1;
        ai repository = getRepository();
        ZootopiaMapSimpleInfo zootopiaMapSimpleInfo = this.mapItemInfo;
        if (zootopiaMapSimpleInfo != null) {
            T1 = zootopiaMapSimpleInfo.getMapID();
        } else {
            T1 = T1();
        }
        repository.j(T1, new b());
    }

    public final void e2(int i3) {
        this.mapId = i3;
    }

    public final void f2(ZootopiaMapSimpleInfo zootopiaMapSimpleInfo) {
        this.mapItemInfo = zootopiaMapSimpleInfo;
        if (this.detail.getValue() != null || zootopiaMapSimpleInfo == null) {
            return;
        }
        this.detail.postValue(ZootopiaMapDetail.INSTANCE.a(zootopiaMapSimpleInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String d2(ZootopiaMapDetail zootopiaMapDetail) {
        boolean z16 = false;
        if (zootopiaMapDetail != null && zootopiaMapDetail.getOnlineDuration() == 0) {
            z16 = true;
        }
        if (z16) {
            return "";
        }
        return "\u7d2f\u8ba1\u5728\u7ebf " + com.tencent.sqshow.zootopia.utils.t.f373300a.b(zootopiaMapDetail.getOnlineDuration());
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zootopia/portal/detail/am$a", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lzb3/h;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a implements com.tencent.mobileqq.zootopia.api.e<ZootopiaMapCommentResp> {
        a() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(ZootopiaMapCommentResp result) {
            Intrinsics.checkNotNullParameter(result, "result");
            am.this.Q1().postValue(am.this.P1(result));
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
        }
    }
}
