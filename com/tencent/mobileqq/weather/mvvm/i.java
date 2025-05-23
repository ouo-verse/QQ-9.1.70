package com.tencent.mobileqq.weather.mvvm;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.mobileqq.weather.data.o;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.TianShuAccess;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\r\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0006\u0010\t\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\u0002R(\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R.\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00140\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0016\u0010\u0010\"\u0004\b\u0017\u0010\u0012R(\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/weather/mvvm/i;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "M1", "", "reqType", "L1", "", "getLogTag", "Q1", "R1", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/weather/data/o;", "i", "Landroidx/lifecycle/MutableLiveData;", "N1", "()Landroidx/lifecycle/MutableLiveData;", "setPendantData", "(Landroidx/lifecycle/MutableLiveData;)V", "pendantData", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "P1", "setRecommendBannerData", "recommendBannerData", BdhLogUtil.LogTag.Tag_Conn, "O1", "setPushDialogData", "pushDialogData", "<init>", "()V", "D", "a", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class i extends BaseViewModel {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<o> pushDialogData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MutableLiveData<o> pendantData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MutableLiveData<List<o>> recommendBannerData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/weather/mvvm/i$a;", "", "", "REQ_TYPE_PENDANT", "I", "REQ_TYPE_PUSH_DIALOG", "REQ_TYPE_REC_BANNER", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.weather.mvvm.i$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/weather/mvvm/i$b", "Lcom/tencent/mobileqq/tianshu/data/TianShuGetAdvCallback;", "", "result", "Lcooperation/vip/pb/TianShuAccess$GetAdsRsp;", "getAdsRsp", "", "onGetAdvs", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b implements TianShuGetAdvCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f313420d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f313421e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ i f313422f;

        b(int i3, int i16, i iVar) {
            this.f313420d = i3;
            this.f313421e = i16;
            this.f313422f = iVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), iVar);
            }
        }

        @Override // com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback
        public void onGetAdvs(boolean result, @Nullable TianShuAccess.GetAdsRsp getAdsRsp) {
            TianShuAccess.RspEntry rspEntry;
            boolean z16;
            List<TianShuAccess.AdItem> list;
            int collectionSizeOrDefault;
            PBRepeatMessageField<TianShuAccess.RspEntry> pBRepeatMessageField;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(result), getAdsRsp);
                return;
            }
            if (!result) {
                QLog.d("WeatherTianshuViewModel", 1, "doRequest " + this.f313420d + " onGetAdvs false");
                return;
            }
            ArrayList arrayList = null;
            if (getAdsRsp != null && (pBRepeatMessageField = getAdsRsp.mapAds) != null) {
                rspEntry = pBRepeatMessageField.get(0);
            } else {
                rspEntry = null;
            }
            if (rspEntry == null) {
                QLog.d("WeatherTianshuViewModel", 1, "doRequest " + this.f313420d + " ads is empty");
                return;
            }
            int i3 = rspEntry.key.get();
            PBRepeatMessageField<TianShuAccess.AdItem> pBRepeatMessageField2 = rspEntry.value.get().lst;
            if (pBRepeatMessageField2 != null && (list = pBRepeatMessageField2.get()) != null) {
                List<TianShuAccess.AdItem> list2 = list;
                int i16 = this.f313420d;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    arrayList2.add(new o((TianShuAccess.AdItem) it.next(), i16));
                }
                arrayList = arrayList2;
            }
            ArrayList arrayList3 = arrayList;
            if (arrayList3 != null && !arrayList3.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                QLog.d("WeatherTianshuViewModel", 1, "doRequest " + this.f313420d + " adItemList is empty");
                return;
            }
            QLog.d("WeatherTianshuViewModel", 1, "doRequest " + this.f313420d + " pos: " + i3 + " rsp ad:", Integer.valueOf(arrayList.size()));
            o oVar = arrayList.get(0);
            int i17 = this.f313421e;
            if (i17 != 1) {
                if (i17 != 2) {
                    if (i17 == 3) {
                        this.f313422f.O1().postValue(oVar);
                        return;
                    }
                    return;
                }
                this.f313422f.P1().postValue(arrayList);
                return;
            }
            com.tencent.mobileqq.weather.data.f.f313296a.q(oVar.a());
            this.f313422f.N1().postValue(oVar);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33414);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.pendantData = new MutableLiveData<>();
        this.recommendBannerData = new MutableLiveData<>();
        this.pushDialogData = new MutableLiveData<>();
    }

    private final void L1(int reqType) {
        int i3;
        int i16 = 1;
        if (reqType != 1) {
            if (reqType != 2) {
                if (reqType != 3) {
                    i3 = 0;
                } else {
                    i3 = 1013;
                }
            } else {
                i3 = 1186;
            }
        } else {
            i3 = 668;
        }
        if (reqType == 2) {
            i16 = 4;
        }
        h.f313416a.i(new b(i3, reqType, this), i3, i16);
    }

    private final void M1() {
        List<o> listOf;
        TianShuAccess.AdItem adItem = new TianShuAccess.AdItem();
        adItem.iconurl.set("https://tianshu.gtimg.cn/tianshu/1695635146797.gif");
        adItem.jumpurl.set("https://act.qzone.qq.com/v2/vip/tx/p/47477_7aef670e?trace_detail=base64-eyJhcHBpZCI6InZhYl9jb21tIiwicGFnZV9pZCI6IjExODYiLCJpdGVtX2lkIjoiMjA2MDYzNiIsIml0ZW1fdHlwZSI6IjUifQ==&h5costreport=1");
        TianShuAccess.AdItem adItem2 = new TianShuAccess.AdItem();
        adItem2.iconurl.set("https://tianshu.gtimg.cn/tianshu/1682490500700.jpg");
        adItem2.jumpurl.set("https://yundong.qq.com/v2/points/mall?_wv=16777219&_wwv=8194&from_scene=thirdchannel&src_id=818&trace_detail=base64-eyJhcHBpZCI6InZhYl9jb21tIiwicGFnZV9pZCI6IjExODciLCJpdGVtX2lkIjoiMTk4MzE4MiIsIml0ZW1fdHlwZSI6IjUifQ==&h5costreport=1");
        adItem2.desc.set("1");
        TianShuAccess.AdItem adItem3 = new TianShuAccess.AdItem();
        adItem3.iconurl.set("https://tianshu.gtimg.cn/tianshu/1694595543264.gif");
        adItem3.jumpurl.set("https://act.qzone.qq.com/v2/vip/tx/p/47477_7aef670e?trace_detail=base64-eyJhcHBpZCI6InZhYl9jb21tIiwicGFnZV9pZCI6IjY2OCIsIml0ZW1faWQiOiIyMDk5ODQxIiwiaXRlbV90eXBlIjoiNSJ9&h5costreport=1");
        TianShuAccess.AdItem adItem4 = new TianShuAccess.AdItem();
        adItem4.iconurl.set("https://tianshu.gtimg.cn/tianshu/1682490500700.jpg");
        adItem4.jumpurl.set("https://yundong.qq.com/v2/points/mall?_wv=16777219&_wwv=8194&from_scene=thirdchannel&src_id=818&trace_detail=base64-eyJhcHBpZCI6InZhYl9jb21tIiwicGFnZV9pZCI6IjExODciLCJpdGVtX2lkIjoiMTk4MzE4MiIsIml0ZW1fdHlwZSI6IjUifQ==&h5costreport=1");
        adItem4.desc.set("4");
        o oVar = new o(adItem, 1186);
        o oVar2 = new o(adItem2, 1186);
        o oVar3 = new o(adItem3, 668);
        o oVar4 = new o(adItem4, 1186);
        MutableLiveData<List<o>> mutableLiveData = this.recommendBannerData;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new o[]{oVar, oVar2, oVar4});
        mutableLiveData.postValue(listOf);
        this.pendantData.postValue(oVar3);
    }

    @NotNull
    public final MutableLiveData<o> N1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.pendantData;
    }

    @NotNull
    public final MutableLiveData<o> O1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.pushDialogData;
    }

    @NotNull
    public final MutableLiveData<List<o>> P1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.recommendBannerData;
    }

    public final void Q1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else if (com.tencent.mobileqq.weather.debug.g.f313380a.e()) {
            M1();
        } else {
            L1(1);
            L1(2);
        }
    }

    public final void R1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            L1(3);
        }
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return "WeatherTianshuViewModel";
    }
}
