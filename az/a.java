package az;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;
import yy.WSMsgDetailData;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007\u00a2\u0006\u0004\b\"\u0010#J \u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J6\u0010\u0014\u001a\u00020\t2\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u00112\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006J\b\u0010\u0015\u001a\u00020\tH\u0016J\b\u0010\u0016\u001a\u00020\tH\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R$\u0010!\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Laz/a;", "Lcom/tencent/biz/pubaccount/weishi/presenter/a;", "Lzy/c;", "Lzy/b;", "Lyy/a;", "data", "", "isFirst", "isRefresh", "", "A0", "", "subjectId", "C0", "z0", "Ljava/util/ArrayList;", "Lyy/c;", "Lkotlin/collections/ArrayList;", "sectionList", "isFinished", "B0", "g", "doOnDestroy", "Lzy/d;", "f", "Lzy/d;", "dataFetcher", h.F, "Lyy/a;", "getMsgDetailData", "()Lyy/a;", "setMsgDetailData", "(Lyy/a;)V", "msgDetailData", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public abstract class a extends com.tencent.biz.pubaccount.weishi.presenter.a<zy.c> implements zy.b {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private zy.d dataFetcher;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private WSMsgDetailData msgDetailData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"az/a$a", "Lkz/a;", "Lyy/a;", "data", "", "a", "", "errorCode", "", "errorMsg", "onFailure", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: az.a$a, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    public static final class C0079a implements kz.a<WSMsgDetailData> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f27356b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f27357c;

        C0079a(boolean z16, boolean z17) {
            this.f27356b = z16;
            this.f27357c = z17;
        }

        @Override // kz.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(WSMsgDetailData data) {
            Intrinsics.checkNotNullParameter(data, "data");
            a.this.A0(data, this.f27356b, this.f27357c);
            a.this.B0(data.b(), this.f27356b, this.f27357c, data.getIsFinished());
        }

        @Override // kz.a
        public void onFailure(int errorCode, String errorMsg) {
            zy.c x06 = a.this.x0();
            if (x06 != null) {
                x06.Yc();
            }
        }
    }

    public final void B0(ArrayList<yy.c> sectionList, boolean isFirst, boolean isRefresh, boolean isFinished) {
        Intrinsics.checkNotNullParameter(sectionList, "sectionList");
        zy.c x06 = x0();
        if (x06 != null) {
            x06.f6(false);
        }
        if (!isFirst && !isRefresh) {
            zy.c x07 = x0();
            if (x07 != null) {
                x07.A6(sectionList);
            }
        } else {
            zy.c x08 = x0();
            if (x08 != null) {
                x08.U5(sectionList);
            }
        }
        zy.c x09 = x0();
        if (x09 != null) {
            x09.lg(isFinished);
        }
        if ((isRefresh || isFirst) && sectionList.size() == 0) {
            zy.c x010 = x0();
            if (x010 != null) {
                x010.jc(true);
            }
        } else {
            zy.c x011 = x0();
            if (x011 != null) {
                x011.jc(false);
            }
        }
        zy.c x012 = x0();
        if (x012 != null) {
            x012.wb(isRefresh, isFinished);
        }
    }

    public void C0(int subjectId) {
        this.dataFetcher = new zy.d(subjectId, e());
    }

    public void z0(boolean isFirst, boolean isRefresh) {
        jz.a aVar = new jz.a(isFirst, isRefresh);
        boolean O = O();
        zy.d dVar = this.dataFetcher;
        if (dVar != null) {
            dVar.c(aVar, O, new C0079a(isFirst, isRefresh));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A0(WSMsgDetailData data, boolean isFirst, boolean isRefresh) {
        if (!isFirst && !isRefresh) {
            WSMsgDetailData wSMsgDetailData = this.msgDetailData;
            if (wSMsgDetailData != null) {
                wSMsgDetailData.d(data.getIsFinished());
                wSMsgDetailData.e(data.getMsgRedDotCount());
                wSMsgDetailData.b().addAll(data.b());
            }
        } else {
            this.msgDetailData = data;
        }
        if (data.b().size() == 0) {
            data.d(true);
        }
    }

    public void doOnDestroy() {
    }

    public void g() {
    }
}
