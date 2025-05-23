package com.tencent.ecommerce.biz.comment;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.tencent.biz.pubaccount.weishi.WSAutoShowCommentParams;
import com.tencent.ecommerce.base.pageopener.api.imageselector.ECMediaInfo;
import com.tencent.ecommerce.biz.comment.UploadStateListener;
import com.tencent.ecommerce.repo.comment.ECQShopOrderCommentInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00172\u00020\u0001:\u0003\u0018\u0019\u001aB\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\b\u001a\u00020\u0007J\b\u0010\f\u001a\u00020\u0005H\u0014R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/ecommerce/biz/comment/ECQShopCommentViewModel;", "Landroidx/lifecycle/ViewModel;", "", "Lcom/tencent/ecommerce/base/pageopener/api/imageselector/c;", "mediaInfos", "", "N1", "Lcom/tencent/ecommerce/repo/comment/a;", "commentInfo", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/ecommerce/biz/comment/ECQShopCommentViewModel$c;", "M1", "onCleared", "Lcom/tencent/ecommerce/biz/comment/UploadStateListener;", "i", "Lcom/tencent/ecommerce/biz/comment/UploadStateListener;", "uploadListener", "Lcom/tencent/ecommerce/biz/comment/BatchUploader;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/ecommerce/biz/comment/BatchUploader;", "batchUploader", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "b", "c", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECQShopCommentViewModel extends ViewModel {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final UploadStateListener uploadListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final BatchUploader batchUploader;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/biz/comment/ECQShopCommentViewModel$b;", "", "<init>", "()V", "a", "b", "Lcom/tencent/ecommerce/biz/comment/ECQShopCommentViewModel$b$a;", "Lcom/tencent/ecommerce/biz/comment/ECQShopCommentViewModel$b$b;", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static abstract class b {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/ecommerce/biz/comment/ECQShopCommentViewModel$b$a;", "Lcom/tencent/ecommerce/biz/comment/ECQShopCommentViewModel$b;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* loaded from: classes31.dex */
        public static final class a extends b {

            /* renamed from: a, reason: collision with root package name */
            public static final a f101383a = new a();

            a() {
                super(null);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/ecommerce/biz/comment/ECQShopCommentViewModel$b$b;", "Lcom/tencent/ecommerce/biz/comment/ECQShopCommentViewModel$b;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* renamed from: com.tencent.ecommerce.biz.comment.ECQShopCommentViewModel$b$b, reason: collision with other inner class name */
        /* loaded from: classes31.dex */
        public static final class C1043b extends b {

            /* renamed from: a, reason: collision with root package name */
            public static final C1043b f101384a = new C1043b();

            C1043b() {
                super(null);
            }
        }

        b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/ecommerce/biz/comment/ECQShopCommentViewModel$c;", "", "<init>", "()V", "a", "b", "c", "Lcom/tencent/ecommerce/biz/comment/ECQShopCommentViewModel$c$c;", "Lcom/tencent/ecommerce/biz/comment/ECQShopCommentViewModel$c$a;", "Lcom/tencent/ecommerce/biz/comment/ECQShopCommentViewModel$c$b;", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static abstract class c {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/biz/comment/ECQShopCommentViewModel$c$a;", "Lcom/tencent/ecommerce/biz/comment/ECQShopCommentViewModel$c;", "Lcom/tencent/ecommerce/biz/comment/ECQShopCommentViewModel$b;", "a", "Lcom/tencent/ecommerce/biz/comment/ECQShopCommentViewModel$b;", "exception", "<init>", "(Lcom/tencent/ecommerce/biz/comment/ECQShopCommentViewModel$b;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* loaded from: classes31.dex */
        public static final class a extends c {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            public final b exception;

            public a(b bVar) {
                super(null);
                this.exception = bVar;
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/biz/comment/ECQShopCommentViewModel$c$b;", "Lcom/tencent/ecommerce/biz/comment/ECQShopCommentViewModel$c;", "", "a", "Ljava/lang/String;", WSAutoShowCommentParams.KEY_COMMENT_ID, "<init>", "(Ljava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* loaded from: classes31.dex */
        public static final class b extends c {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            public final String commentId;

            public b(String str) {
                super(null);
                this.commentId = str;
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/biz/comment/ECQShopCommentViewModel$c$c;", "Lcom/tencent/ecommerce/biz/comment/ECQShopCommentViewModel$c;", "", "a", "Ljava/lang/String;", WSAutoShowCommentParams.KEY_COMMENT_ID, "<init>", "(Ljava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* renamed from: com.tencent.ecommerce.biz.comment.ECQShopCommentViewModel$c$c, reason: collision with other inner class name */
        /* loaded from: classes31.dex */
        public static final class C1044c extends c {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            public final String commentId;

            public C1044c(String str) {
                super(null);
                this.commentId = str;
            }
        }

        c() {
        }

        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ECQShopCommentViewModel() {
        d dVar = new d();
        this.uploadListener = dVar;
        this.batchUploader = new BatchUploader("comment", dVar, null, null, null, 28, null);
    }

    public final Flow<c> M1(ECQShopOrderCommentInfo commentInfo) {
        return FlowKt.flow(new ECQShopCommentViewModel$publishComment$1(this, commentInfo, null));
    }

    public final void N1(List<ECMediaInfo> mediaInfos) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECQShopCommentViewModel$uploadImages$1(this, mediaInfos, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.batchUploader.i();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/comment/ECQShopCommentViewModel$d", "Lcom/tencent/ecommerce/biz/comment/UploadStateListener;", "Lcom/tencent/ecommerce/biz/comment/UploadStateListener$a;", "state", "", "onStateChanged", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d implements UploadStateListener {
        d() {
        }

        @Override // com.tencent.ecommerce.biz.comment.UploadStateListener
        public void onStateChanged(UploadStateListener.a state) {
        }
    }
}
