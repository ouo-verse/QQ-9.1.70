package com.tencent.mobileqq.zootopia.portal.home.model;

import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.module.feedcomponent.manage.FeedManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.zootopia.b;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.sqshow.zootopia.data.ErrorMessage;
import com.tencent.sqshow.zootopia.data.ZootopiaMapSimpleInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import zb3.ZootopiaBannerItem;
import zb3.ZootopiaMapListData;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 52\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00016B\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u00a2\u0006\u0004\b3\u00104J\u0016\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0016\u0010\u000b\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0012\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0011J\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u0011J\u0006\u0010\u0014\u001a\u00020\u000fJ\u0006\u0010\u0015\u001a\u00020\u0006J\u0006\u0010\u0016\u001a\u00020\u0006R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR \u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR \u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\u001fR\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\r0\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010\u001fR\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020\b0\u00118\u0006\u00a2\u0006\f\n\u0004\b%\u0010\u001f\u001a\u0004\b&\u0010'R\u001d\u0010+\u001a\b\u0012\u0004\u0012\u00020\b0\u00118\u0006\u00a2\u0006\f\n\u0004\b)\u0010\u001f\u001a\u0004\b*\u0010'R\u001d\u0010/\u001a\b\u0012\u0004\u0012\u00020,0\u00118\u0006\u00a2\u0006\f\n\u0004\b-\u0010\u001f\u001a\u0004\b.\u0010'R\u0016\u00102\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/zootopia/portal/home/model/ZootopiaListViewModel;", "Lcom/tencent/mobileqq/mvvm/c;", "Lcom/tencent/mobileqq/zootopia/portal/home/model/ZootopiaListRepository;", "", "Lcom/tencent/sqshow/zootopia/data/ZootopiaMapSimpleInfo;", "list", "", "d2", "Lzb3/i;", "listInfo", "e2", "b2", "c2", "Lzb3/c;", "info", "", ICustomDataEditor.STRING_ARRAY_PARAM_2, "Landroidx/lifecycle/MutableLiveData;", "X1", "Z1", "S1", "refresh", FeedManager.LOAD_MORE, "Lcom/tencent/common/app/AppInterface;", "i", "Lcom/tencent/common/app/AppInterface;", "app", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/zootopia/portal/home/model/ZootopiaListRepository;", "repository", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "mZootopiaMapList", "D", "mLoadMoreMapList", "E", "mZootopiaBannerInfo", UserInfo.SEX_FEMALE, "W1", "()Landroidx/lifecycle/MutableLiveData;", "mZootopiaElementList", "G", "U1", "mLoadMoreElementList", "Lcom/tencent/sqshow/zootopia/data/a;", "H", "T1", "errorMessage", "I", "Z", "isEnd", "<init>", "(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/zootopia/portal/home/model/ZootopiaListRepository;)V", "J", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaListViewModel extends com.tencent.mobileqq.mvvm.c<ZootopiaListRepository> {

    /* renamed from: C, reason: from kotlin metadata */
    private final MutableLiveData<List<ZootopiaMapSimpleInfo>> mZootopiaMapList;

    /* renamed from: D, reason: from kotlin metadata */
    private final MutableLiveData<List<ZootopiaMapSimpleInfo>> mLoadMoreMapList;

    /* renamed from: E, reason: from kotlin metadata */
    private final MutableLiveData<zb3.c> mZootopiaBannerInfo;

    /* renamed from: F, reason: from kotlin metadata */
    private final MutableLiveData<ZootopiaMapListData> mZootopiaElementList;

    /* renamed from: G, reason: from kotlin metadata */
    private final MutableLiveData<ZootopiaMapListData> mLoadMoreElementList;

    /* renamed from: H, reason: from kotlin metadata */
    private final MutableLiveData<ErrorMessage> errorMessage;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean isEnd;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final AppInterface app;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaListRepository repository;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u001a\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/zootopia/portal/home/model/ZootopiaListViewModel$c", "Lcom/tencent/mobileqq/zootopia/b;", "Lzb3/i;", "", "end", "result", "", "b", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements com.tencent.mobileqq.zootopia.b<ZootopiaMapListData> {
        c() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(ZootopiaMapListData zootopiaMapListData) {
            b.a.a(this, zootopiaMapListData);
        }

        @Override // com.tencent.mobileqq.zootopia.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void Z(boolean end, ZootopiaMapListData result) {
            Intrinsics.checkNotNullParameter(result, "result");
            ZootopiaListViewModel.this.isEnd = end;
            ZootopiaListViewModel.this.d2(result.a());
            ZootopiaListViewModel.this.e2(result);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            ZootopiaListViewModel.this.T1().postValue(new ErrorMessage(error, message));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZootopiaListViewModel(AppInterface app, ZootopiaListRepository repository) {
        super(repository);
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(repository, "repository");
        this.app = app;
        this.repository = repository;
        this.mZootopiaMapList = new MutableLiveData<>();
        this.mLoadMoreMapList = new MutableLiveData<>();
        this.mZootopiaBannerInfo = new MutableLiveData<>();
        this.mZootopiaElementList = new MutableLiveData<>();
        this.mLoadMoreElementList = new MutableLiveData<>();
        this.errorMessage = new MutableLiveData<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean a2(zb3.c info) {
        if (info.getAdId() <= 0) {
            QLog.e("ZootopiaListViewModel", 1, "info.adId < 0");
        } else {
            ArrayList<ZootopiaBannerItem> b16 = info.b();
            if (b16 == null || b16.isEmpty()) {
                QLog.e("ZootopiaListViewModel", 1, "info items is null");
            } else {
                if (info.b().get(0).getIAdId() > 0) {
                    if (!(info.b().get(0).getPicUrl().length() == 0)) {
                        if (!(info.b().get(0).getJumpUrl().length() == 0)) {
                            return true;
                        }
                    }
                }
                QLog.e("ZootopiaListViewModel", 1, "info items url is null");
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b2(List<ZootopiaMapSimpleInfo> list) {
        this.mLoadMoreMapList.postValue(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c2(ZootopiaMapListData listInfo) {
        this.mLoadMoreElementList.postValue(listInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d2(List<ZootopiaMapSimpleInfo> list) {
        this.mZootopiaMapList.postValue(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e2(ZootopiaMapListData listInfo) {
        this.mZootopiaElementList.postValue(listInfo);
    }

    /* renamed from: S1, reason: from getter */
    public final boolean getIsEnd() {
        return this.isEnd;
    }

    public final MutableLiveData<ErrorMessage> T1() {
        return this.errorMessage;
    }

    public final MutableLiveData<ZootopiaMapListData> U1() {
        return this.mLoadMoreElementList;
    }

    public final MutableLiveData<ZootopiaMapListData> W1() {
        return this.mZootopiaElementList;
    }

    public final MutableLiveData<List<ZootopiaMapSimpleInfo>> X1() {
        return this.mZootopiaMapList;
    }

    public final MutableLiveData<zb3.c> Z1() {
        return this.mZootopiaBannerInfo;
    }

    public final void loadMore() {
        this.repository.m(new b());
    }

    public final void refresh() {
        this.repository.l(new c());
        this.repository.n(940, new Function1<zb3.c, Unit>() { // from class: com.tencent.mobileqq.zootopia.portal.home.model.ZootopiaListViewModel$refresh$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(zb3.c cVar) {
                invoke2(cVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(zb3.c info) {
                boolean a26;
                MutableLiveData mutableLiveData;
                Intrinsics.checkNotNullParameter(info, "info");
                a26 = ZootopiaListViewModel.this.a2(info);
                if (a26) {
                    mutableLiveData = ZootopiaListViewModel.this.mZootopiaBannerInfo;
                    mutableLiveData.postValue(info);
                }
            }
        });
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u001a\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/zootopia/portal/home/model/ZootopiaListViewModel$b", "Lcom/tencent/mobileqq/zootopia/b;", "Lzb3/i;", "", "end", "result", "", "b", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements com.tencent.mobileqq.zootopia.b<ZootopiaMapListData> {
        b() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(ZootopiaMapListData zootopiaMapListData) {
            b.a.a(this, zootopiaMapListData);
        }

        @Override // com.tencent.mobileqq.zootopia.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void Z(boolean end, ZootopiaMapListData result) {
            Intrinsics.checkNotNullParameter(result, "result");
            ZootopiaListViewModel.this.isEnd = end;
            ZootopiaListViewModel.this.b2(result.a());
            ZootopiaListViewModel.this.c2(result);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
        }
    }
}
