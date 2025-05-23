package com.tencent.mobileqq.flock.feedlist.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.module.feedcomponent.manage.FeedManager;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.flock.api.FlockConstants$FlockListScene;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.addcontact.api.IAddContactSessionRepo;
import com.tencent.mobileqq.troop.addcontact.model.AddContactDataType;
import com.tencent.mobileqq.winkpublish.report.WinkBaseErrorCodeKt;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001c\b&\u0018\u0000 J2\u00020\u0001:\u0001KB\u0007\u00a2\u0006\u0004\bH\u0010IJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016JV\u0010\u0013\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062&\u0010\u0010\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000ej\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J \u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006J&\u0010\u001b\u001a\u00020\u00022\u0016\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0018j\b\u0012\u0004\u0012\u00020\n`\u00192\u0006\u0010\u0010\u001a\u00020\u0011JN\u0010\u001c\u001a\u00020\u00022\u0016\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0018j\b\u0012\u0004\u0012\u00020\n`\u00192&\u0010\u0010\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000ej\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u000f2\u0006\u0010\r\u001a\u00020\u0006J\u000e\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001dJ\u000e\u0010 \u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001dR&\u0010%\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\"0!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R)\u0010+\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\"0&8\u0006\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020\n0,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u001a\u00102\u001a\b\u0012\u0004\u0012\u0002000!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u0010$R\u001d\u00105\u001a\b\u0012\u0004\u0012\u0002000&8\u0006\u00a2\u0006\f\n\u0004\b3\u0010(\u001a\u0004\b4\u0010*R>\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000ej\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR(\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00040,8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bB\u0010.\u001a\u0004\bC\u0010D\"\u0004\bE\u0010F\u00a8\u0006L"}, d2 = {"Lcom/tencent/mobileqq/flock/feedlist/viewmodel/a;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "X1", "", "getLogTag", "", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "W1", "", "Lcom/tencent/mobileqq/flock/feeddetail/bean/a;", "datas", FeedManager.LOAD_MORE, "isFinish", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "attachInfo", "", "attachInfo2", "U1", "", "retCode", "errMsg", "T1", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "feeds", "M1", "L1", "Ly45/b;", "feed", ICustomDataEditor.STRING_ARRAY_PARAM_2, "N1", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/richframework/data/base/UIStateData;", "i", "Landroidx/lifecycle/MutableLiveData;", "_feedListData", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "R1", "()Landroidx/lifecycle/LiveData;", "feedListData", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "feedList", "Lcom/tencent/mobileqq/flock/feedlist/viewmodel/ToastState;", "D", "_toastStateData", "E", "S1", "toastStateData", UserInfo.SEX_FEMALE, "Ljava/util/HashMap;", "O1", "()Ljava/util/HashMap;", "setAttachInfo", "(Ljava/util/HashMap;)V", "G", "[B", "P1", "()[B", "Z1", "([B)V", "H", "Q1", "()Ljava/util/List;", "setFeedFilter", "(Ljava/util/List;)V", "feedFilter", "<init>", "()V", "I", "a", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public abstract class a extends BaseViewModel {
    static IPatchRedirector $redirector_;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final List<com.tencent.mobileqq.flock.feeddetail.bean.a> feedList;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<ToastState> _toastStateData;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final LiveData<ToastState> toastStateData;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private HashMap<String, String> attachInfo;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private byte[] attachInfo2;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private List<String> feedFilter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<UIStateData<List<com.tencent.mobileqq.flock.feeddetail.bean.a>>> _feedListData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveData<UIStateData<List<com.tencent.mobileqq.flock.feeddetail.bean.a>>> feedListData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0086\u0002R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/flock/feedlist/viewmodel/a$a;", "", "Lcom/tencent/mobileqq/flock/api/FlockConstants$FlockListScene;", "type", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/flock/feedlist/viewmodel/a;", "a", "", "IS_FINISH", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.flock.feedlist.viewmodel.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: com.tencent.mobileqq.flock.feedlist.viewmodel.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        public /* synthetic */ class C7605a {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f210179a;

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43515);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 1)) {
                    redirector.redirect((short) 1);
                    return;
                }
                int[] iArr = new int[FlockConstants$FlockListScene.values().length];
                try {
                    iArr[FlockConstants$FlockListScene.TROOP.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[FlockConstants$FlockListScene.RECOM.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[FlockConstants$FlockListScene.ACTIVITY.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[FlockConstants$FlockListScene.PUBLISH.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[FlockConstants$FlockListScene.JOIN.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[FlockConstants$FlockListScene.TOPIC_AGGREGATION.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                f210179a = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final Class<? extends a> a(@NotNull FlockConstants$FlockListScene type) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Class) iPatchRedirector.redirect((short) 2, (Object) this, (Object) type);
            }
            Intrinsics.checkNotNullParameter(type, "type");
            switch (C7605a.f210179a[type.ordinal()]) {
                case 1:
                    return c.class;
                case 2:
                case 3:
                    return g.class;
                case 4:
                case 5:
                    return e.class;
                case 6:
                    return com.tencent.mobileqq.topicaggregation.viewmodel.a.class;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43519);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 19)) {
            redirector.redirect((short) 19);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        MutableLiveData<UIStateData<List<com.tencent.mobileqq.flock.feeddetail.bean.a>>> mutableLiveData = new MutableLiveData<>();
        this._feedListData = mutableLiveData;
        this.feedListData = mutableLiveData;
        this.feedList = new ArrayList();
        MutableLiveData<ToastState> mutableLiveData2 = new MutableLiveData<>();
        this._toastStateData = mutableLiveData2;
        this.toastStateData = mutableLiveData2;
        this.attachInfo = new HashMap<>();
        this.attachInfo2 = new byte[0];
        this.feedFilter = new ArrayList();
    }

    private final void X1() {
        this.attachInfo.clear();
        this.attachInfo2 = new byte[0];
        this.feedFilter.clear();
    }

    public final void L1(@NotNull ArrayList<com.tencent.mobileqq.flock.feeddetail.bean.a> feeds, @Nullable HashMap<String, String> attachInfo, boolean isFinish) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, feeds, attachInfo, Boolean.valueOf(isFinish));
            return;
        }
        Intrinsics.checkNotNullParameter(feeds, "feeds");
        this.feedList.clear();
        this.feedList.addAll(feeds);
        if (attachInfo != null) {
            this.attachInfo = attachInfo;
        }
        if (!this.feedList.isEmpty()) {
            this._feedListData.postValue(UIStateData.obtainSuccess(true).setData(false, this.feedList).setFinish(isFinish));
        }
    }

    public final void M1(@NotNull ArrayList<com.tencent.mobileqq.flock.feeddetail.bean.a> feeds, @NotNull byte[] attachInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) feeds, (Object) attachInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(feeds, "feeds");
        Intrinsics.checkNotNullParameter(attachInfo, "attachInfo");
        this.feedList.clear();
        this.feedList.addAll(feeds);
        this.attachInfo2 = attachInfo;
        if (!this.feedList.isEmpty()) {
            this._feedListData.postValue(UIStateData.obtainSuccess(true).setData(false, this.feedList).setFinish(false));
        }
        this.feedFilter.clear();
        for (com.tencent.mobileqq.flock.feeddetail.bean.a aVar : feeds) {
            List<String> list = this.feedFilter;
            String str = aVar.a().f449366a;
            Intrinsics.checkNotNullExpressionValue(str, "item.feed.id");
            list.add(str);
        }
    }

    public final void N1(@NotNull y45.b feed) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) feed);
            return;
        }
        Intrinsics.checkNotNullParameter(feed, "feed");
        List<com.tencent.mobileqq.flock.feeddetail.bean.a> list = this.feedList;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (Intrinsics.areEqual(((com.tencent.mobileqq.flock.feeddetail.bean.a) obj).a().f449366a, feed.f449366a)) {
                arrayList.add(obj);
            }
        }
        this.feedList.removeAll(arrayList);
        this._feedListData.postValue(UIStateData.obtainSuccess(true).setData(true, this.feedList));
    }

    @NotNull
    public final HashMap<String, String> O1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (HashMap) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.attachInfo;
    }

    @NotNull
    public final byte[] P1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (byte[]) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.attachInfo2;
    }

    @NotNull
    public final List<String> Q1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (List) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.feedFilter;
    }

    @NotNull
    public final LiveData<UIStateData<List<com.tencent.mobileqq.flock.feeddetail.bean.a>>> R1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LiveData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.feedListData;
    }

    @NotNull
    public final LiveData<ToastState> S1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (LiveData) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.toastStateData;
    }

    public final void T1(long retCode, @Nullable String errMsg, boolean isLoadMore) {
        String str;
        ToastState toastState;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Long.valueOf(retCode), errMsg, Boolean.valueOf(isLoadMore));
            return;
        }
        QLog.e(getLogTag(), 1, "handleFeedListResponseFail, retCode:" + retCode + ", errMsg:" + errMsg + ", isLoadMore:" + isLoadMore);
        if (!this.feedList.isEmpty()) {
            if (retCode == WinkBaseErrorCodeKt.ERROR_REQUEST_TIMEOUT) {
                toastState = ToastState.NETWORK_ERROR;
            } else if (isLoadMore) {
                toastState = ToastState.LOAD_MORE_FAILED;
            } else {
                toastState = ToastState.REFRESH_FAILED;
            }
            this._toastStateData.postValue(toastState);
            return;
        }
        if (retCode == WinkBaseErrorCodeKt.ERROR_REQUEST_TIMEOUT) {
            str = "\u52a0\u8f7d\u5931\u8d25\uff0c\u68c0\u67e5\u7f51\u7edc\u518d\u8bd5\u5427";
        } else {
            str = "\u52a0\u8f7d\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5";
        }
        this._feedListData.postValue(UIStateData.obtainError(str).setRetCode(retCode).setLoadMore(isLoadMore));
    }

    public final void U1(@NotNull List<? extends com.tencent.mobileqq.flock.feeddetail.bean.a> datas, boolean loadMore, boolean isFinish, @Nullable HashMap<String, String> attachInfo, @Nullable byte[] attachInfo2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, datas, Boolean.valueOf(loadMore), Boolean.valueOf(isFinish), attachInfo, attachInfo2);
            return;
        }
        Intrinsics.checkNotNullParameter(datas, "datas");
        QLog.e(getLogTag(), 1, "handleFeedListResponseSuccess, loadMore:" + loadMore + ", isFinish:" + isFinish);
        if (!loadMore) {
            this.feedList.clear();
        }
        this.feedList.addAll(datas);
        if (this.feedList.isEmpty()) {
            this._feedListData.postValue(UIStateData.obtainEmpty().setData(loadMore, this.feedList).setFinish(isFinish).setLoadMore(loadMore));
        } else {
            this._feedListData.postValue(UIStateData.obtainSuccess(false).setData(loadMore, this.feedList).setFinish(isFinish).setLoadMore(loadMore));
        }
        if (attachInfo != null) {
            this.attachInfo = attachInfo;
        }
        if (attachInfo2 != null) {
            this.attachInfo2 = attachInfo2;
            ((IAddContactSessionRepo) QRoute.api(IAddContactSessionRepo.class)).setSession(AddContactDataType.FLOCK, attachInfo2);
        }
    }

    public void W1(boolean isLoadMore) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, isLoadMore);
        } else if (!isLoadMore) {
            X1();
        }
    }

    public final void Z1(@NotNull byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) bArr);
        } else {
            Intrinsics.checkNotNullParameter(bArr, "<set-?>");
            this.attachInfo2 = bArr;
        }
    }

    public final void a2(@NotNull y45.b feed) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) feed);
            return;
        }
        Intrinsics.checkNotNullParameter(feed, "feed");
        Iterator<com.tencent.mobileqq.flock.feeddetail.bean.a> it = this.feedList.iterator();
        int i3 = 0;
        while (true) {
            if (it.hasNext()) {
                if (Intrinsics.areEqual(it.next().a().f449366a, feed.f449366a)) {
                    break;
                } else {
                    i3++;
                }
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 == -1) {
            return;
        }
        this.feedList.set(i3, new com.tencent.mobileqq.flock.feeddetail.bean.a(feed));
        this._feedListData.postValue(UIStateData.obtainSuccess(true).setData(true, this.feedList));
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    public String getLogTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return "FlockFeedListBaseViewModel";
    }
}
