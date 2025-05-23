package com.tencent.mobileqq.qwallet.hb.panel.recommend;

import android.os.Bundle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qwallet.hb.panel.m;
import com.tencent.mobileqq.qwallet.pb.RedPackSkin$GetActivityReq;
import com.tencent.mobileqq.qwallet.pb.RedPackSkin$GetActivityRsp;
import com.tencent.mobileqq.qwallet.pb.RedPackSkin$RecommendSkin;
import com.tencent.mobileqq.qwallet.pb.RedPackSkin$ReportActivityClickReq;
import com.tencent.mobileqq.qwallet.pb.RedPackSkin$ReportActivityClickRsp;
import com.tencent.mobileqq.qwallet.pb.RedPackSkinExt;
import com.tencent.mobileqq.qwallet.pb.a;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl2.o;
import pl2.p;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 :2\u00020\u00012\u00020\u0002:\u0002;<B\u0007\u00a2\u0006\u0004\b8\u00109J(\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0002J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0006\u0010\f\u001a\u00020\u0007J\u0006\u0010\r\u001a\u00020\u0007J\u0006\u0010\u000e\u001a\u00020\u0007J\u0006\u0010\u000f\u001a\u00020\tR\u001b\u0010\u0015\u001a\u00020\u00108FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R$\u0010!\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010(\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010/\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00103\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010*\u001a\u0004\b1\u0010,\"\u0004\b2\u0010.R\u0019\u00107\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0017048F\u00a2\u0006\u0006\u001a\u0004\b5\u00106\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/panel/recommend/SendHbOpActivitiesViewModel;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/LifecycleObserver;", "", "opName", "r2", "r3", "", "U1", "", "recommendId", "M1", "W1", "T1", "S1", "Q1", "Lcom/tencent/mobileqq/qwallet/hb/panel/recommend/SkinRecommendViewModel;", "i", "Lkotlin/Lazy;", "R1", "()Lcom/tencent/mobileqq/qwallet/hb/panel/recommend/SkinRecommendViewModel;", "skinRecommendVM", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/qwallet/hb/panel/recommend/SendHbOpActivitiesViewModel$b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "_activitiesLiveBean", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "P1", "()Ljava/lang/String;", ICustomDataEditor.STRING_ARRAY_PARAM_2, "(Ljava/lang/String;)V", "jumpSchema", "D", "Ljava/lang/Integer;", "getOperationId", "()Ljava/lang/Integer;", "b2", "(Ljava/lang/Integer;)V", "operationId", "E", "I", "O1", "()I", "Z1", "(I)V", "jumpActionType", UserInfo.SEX_FEMALE, "getDefaultRecommendSkinId", "X1", "defaultRecommendSkinId", "Landroidx/lifecycle/LiveData;", "N1", "()Landroidx/lifecycle/LiveData;", "activitiesLiveBean", "<init>", "()V", "G", "a", "b", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class SendHbOpActivitiesViewModel extends ViewModel implements LifecycleObserver {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private String jumpSchema;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private Integer operationId;

    /* renamed from: E, reason: from kotlin metadata */
    private int jumpActionType;

    /* renamed from: F, reason: from kotlin metadata */
    private int defaultRecommendSkinId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy skinRecommendVM;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<SendHbOpActivitiesBean> _activitiesLiveBean;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\t\u0010\u0010R$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/panel/recommend/SendHbOpActivitiesViewModel$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "id", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "tag", "c", "content", "e", "(Ljava/lang/String;)V", "rightIconUrl", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.hb.panel.recommend.SendHbOpActivitiesViewModel$b, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class SendHbOpActivitiesBean {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int id;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String tag;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String content;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private String rightIconUrl;

        public SendHbOpActivitiesBean(int i3, @Nullable String str, @Nullable String str2, @Nullable String str3) {
            this.id = i3;
            this.tag = str;
            this.content = str2;
            this.rightIconUrl = str3;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final String getContent() {
            return this.content;
        }

        /* renamed from: b, reason: from getter */
        public final int getId() {
            return this.id;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final String getRightIconUrl() {
            return this.rightIconUrl;
        }

        @Nullable
        /* renamed from: d, reason: from getter */
        public final String getTag() {
            return this.tag;
        }

        public final void e(@Nullable String str) {
            this.rightIconUrl = str;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SendHbOpActivitiesBean)) {
                return false;
            }
            SendHbOpActivitiesBean sendHbOpActivitiesBean = (SendHbOpActivitiesBean) other;
            if (this.id == sendHbOpActivitiesBean.id && Intrinsics.areEqual(this.tag, sendHbOpActivitiesBean.tag) && Intrinsics.areEqual(this.content, sendHbOpActivitiesBean.content) && Intrinsics.areEqual(this.rightIconUrl, sendHbOpActivitiesBean.rightIconUrl)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            int i3 = this.id * 31;
            String str = this.tag;
            int i16 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i17 = (i3 + hashCode) * 31;
            String str2 = this.content;
            if (str2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str2.hashCode();
            }
            int i18 = (i17 + hashCode2) * 31;
            String str3 = this.rightIconUrl;
            if (str3 != null) {
                i16 = str3.hashCode();
            }
            return i18 + i16;
        }

        @NotNull
        public String toString() {
            return "SendHbOpActivitiesBean(id=" + this.id + ", tag=" + this.tag + ", content=" + this.content + ", rightIconUrl=" + this.rightIconUrl + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\r\u001a\u00020\n\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000\"\u0010\b\u0001\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\t\u001a\n \b*\u0004\u0018\u00010\u00070\u0007H\n\u00a2\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lcom/tencent/mobileqq/pb/MessageMicro;", "Req", "Rsp", "", "<anonymous parameter 0>", "", "isSuccess", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "bundle", "", "onReceive", "(IZLandroid/os/Bundle;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class c implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ o f277605d;

        public c(o oVar) {
            this.f277605d = oVar;
        }

        @Override // mqq.observer.BusinessObserver
        public final void onReceive(int i3, boolean z16, Bundle bundle) {
            int i16;
            String str;
            if (bundle != null) {
                i16 = bundle.getInt("rsp_code");
            } else {
                i16 = 1001;
            }
            if (bundle != null) {
                str = bundle.getString("rsp_msg");
            } else {
                str = null;
            }
            if (z16) {
                try {
                    MessageMicro rsp = ((MessageMicro) RedPackSkin$ReportActivityClickRsp.class.newInstance()).mergeFrom(bundle.getByteArray("rsp_bytes"));
                    o oVar = this.f277605d;
                    if (oVar != null) {
                        Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                        oVar.onSuccess((o) rsp);
                        return;
                    }
                    return;
                } catch (Exception unused) {
                    QLog.e("QWalletHttp-QWalletPbServlet", 1, "mergeFrom bytes array to " + RedPackSkin$ReportActivityClickRsp.class + " failed.");
                    o oVar2 = this.f277605d;
                    if (oVar2 != null) {
                        oVar2.onFail(i16, p.INSTANCE.a());
                        return;
                    }
                    return;
                }
            }
            o oVar3 = this.f277605d;
            if (oVar3 != null) {
                if (str == null) {
                    str = "empty bundle";
                }
                oVar3.onFail(i16, str);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\r\u001a\u00020\n\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000\"\u0010\b\u0001\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\t\u001a\n \b*\u0004\u0018\u00010\u00070\u0007H\n\u00a2\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lcom/tencent/mobileqq/pb/MessageMicro;", "Req", "Rsp", "", "<anonymous parameter 0>", "", "isSuccess", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "bundle", "", "onReceive", "(IZLandroid/os/Bundle;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class d implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ o f277606d;

        public d(o oVar) {
            this.f277606d = oVar;
        }

        @Override // mqq.observer.BusinessObserver
        public final void onReceive(int i3, boolean z16, Bundle bundle) {
            int i16;
            String str;
            if (bundle != null) {
                i16 = bundle.getInt("rsp_code");
            } else {
                i16 = 1001;
            }
            if (bundle != null) {
                str = bundle.getString("rsp_msg");
            } else {
                str = null;
            }
            if (z16) {
                try {
                    MessageMicro rsp = ((MessageMicro) RedPackSkin$GetActivityRsp.class.newInstance()).mergeFrom(bundle.getByteArray("rsp_bytes"));
                    o oVar = this.f277606d;
                    if (oVar != null) {
                        Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                        oVar.onSuccess((o) rsp);
                        return;
                    }
                    return;
                } catch (Exception unused) {
                    QLog.e("QWalletHttp-QWalletPbServlet", 1, "mergeFrom bytes array to " + RedPackSkin$GetActivityRsp.class + " failed.");
                    o oVar2 = this.f277606d;
                    if (oVar2 != null) {
                        oVar2.onFail(i16, p.INSTANCE.a());
                        return;
                    }
                    return;
                }
            }
            o oVar3 = this.f277606d;
            if (oVar3 != null) {
                if (str == null) {
                    str = "empty bundle";
                }
                oVar3.onFail(i16, str);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/qwallet/hb/panel/recommend/SendHbOpActivitiesViewModel$e", "Lpl2/o;", "Lcom/tencent/mobileqq/qwallet/pb/RedPackSkin$GetActivityRsp;", "rsp", "", "a", "", "errCode", "", "errMsg", "onFail", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class e implements o<RedPackSkin$GetActivityRsp> {
        e() {
        }

        @Override // pl2.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull RedPackSkin$GetActivityRsp rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            SendHbOpActivitiesViewModel.this.Z1(rsp.action.get());
            SendHbOpActivitiesViewModel.this.b2(Integer.valueOf(rsp.f278702id.get()));
            SendHbOpActivitiesViewModel.this.X1(rsp.select_recommend_id.get());
            int jumpActionType = SendHbOpActivitiesViewModel.this.getJumpActionType();
            if (jumpActionType != 1) {
                if (jumpActionType != 2) {
                    return;
                }
                SkinRecommendViewModel R1 = SendHbOpActivitiesViewModel.this.R1();
                a.Companion companion = com.tencent.mobileqq.qwallet.pb.a.INSTANCE;
                List<RedPackSkin$RecommendSkin> list = rsp.skins.get();
                Intrinsics.checkNotNullExpressionValue(list, "rsp.skins.get()");
                R1.t2(companion.c(list));
            } else {
                SendHbOpActivitiesViewModel.this.a2(rsp.jump_url.get());
            }
            SendHbOpActivitiesBean sendHbOpActivitiesBean = new SendHbOpActivitiesBean(rsp.f278702id.get(), rsp.tag2.get(), rsp.content.get(), rsp.reddot_pic.get());
            SendHbOpActivitiesViewModel.this._activitiesLiveBean.postValue(sendHbOpActivitiesBean);
            QLog.i("SendHbOpActivitiesViewModel", 1, "trpc.qpay.red_pack_skin.Skin.SsoGetActivity finish: action=" + SendHbOpActivitiesViewModel.this.getJumpActionType() + ", bean=" + sendHbOpActivitiesBean);
        }

        @Override // pl2.k
        public void onFail(int errCode, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.e("SendHbOpActivitiesViewModel", 1, "trpc.qpay.red_pack_skin.Skin.SsoGetActivity fail: errCode=" + errCode + " errMsg = " + errMsg);
        }
    }

    public SendHbOpActivitiesViewModel() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<SkinRecommendViewModel>() { // from class: com.tencent.mobileqq.qwallet.hb.panel.recommend.SendHbOpActivitiesViewModel$skinRecommendVM$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SkinRecommendViewModel invoke() {
                return new SkinRecommendViewModel();
            }
        });
        this.skinRecommendVM = lazy;
        this._activitiesLiveBean = new MutableLiveData<>();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final int M1(int recommendId) {
        int collectionSizeOrDefault;
        boolean z16;
        List<com.tencent.mobileqq.qwallet.pb.a> value = R1().Z1().getValue();
        RedPackSkin$RecommendSkin redPackSkin$RecommendSkin = null;
        if (value != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : value) {
                if (obj instanceof a.Skin) {
                    arrayList.add(obj);
                }
            }
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((a.Skin) it.next()).getValue());
            }
            Iterator it5 = arrayList2.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    break;
                }
                Object next = it5.next();
                if (((RedPackSkin$RecommendSkin) next).recommend_id.get() == recommendId) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    redPackSkin$RecommendSkin = next;
                    break;
                }
            }
            redPackSkin$RecommendSkin = redPackSkin$RecommendSkin;
        }
        if (redPackSkin$RecommendSkin != null) {
            return RedPackSkinExt.f(redPackSkin$RecommendSkin);
        }
        return -1;
    }

    private final void U1(String opName, String r26, String r36) {
        if (r26 == null) {
            r26 = "";
        }
        if (r36 == null) {
            r36 = "";
        }
        m.g(opName, r26, r36, "", "");
    }

    @NotNull
    public final LiveData<SendHbOpActivitiesBean> N1() {
        return this._activitiesLiveBean;
    }

    /* renamed from: O1, reason: from getter */
    public final int getJumpActionType() {
        return this.jumpActionType;
    }

    @Nullable
    /* renamed from: P1, reason: from getter */
    public final String getJumpSchema() {
        return this.jumpSchema;
    }

    public final int Q1() {
        int i3 = this.defaultRecommendSkinId;
        if (i3 != 0) {
            return M1(i3);
        }
        List<com.tencent.mobileqq.qwallet.pb.a> value = R1().Z1().getValue();
        if (value == null) {
            return 0;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : value) {
            if (obj instanceof a.Skin) {
                arrayList.add(obj);
            }
        }
        if (!arrayList.isEmpty()) {
            return RedPackSkinExt.f(((a.Skin) arrayList.get(0)).getValue());
        }
        return -1;
    }

    @NotNull
    public final SkinRecommendViewModel R1() {
        return (SkinRecommendViewModel) this.skinRecommendVM.getValue();
    }

    public final void S1() {
        String str;
        String str2;
        boolean z16;
        String str3;
        SendHbOpActivitiesBean value = this._activitiesLiveBean.getValue();
        if (value != null) {
            str = Integer.valueOf(value.getId()).toString();
        } else {
            str = null;
        }
        SendHbOpActivitiesBean value2 = this._activitiesLiveBean.getValue();
        if (value2 != null) {
            str2 = value2.getRightIconUrl();
        } else {
            str2 = null;
        }
        int i3 = 0;
        if (str2 != null && str2.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            str3 = "0";
        } else {
            str3 = "1";
        }
        U1("redpack.make_entry.click", str, str3);
        MutableLiveData<SendHbOpActivitiesBean> mutableLiveData = this._activitiesLiveBean;
        SendHbOpActivitiesBean value3 = mutableLiveData.getValue();
        if (value3 != null) {
            value3.e(null);
        } else {
            value3 = null;
        }
        mutableLiveData.postValue(value3);
        p.Companion companion = p.INSTANCE;
        RedPackSkin$ReportActivityClickReq redPackSkin$ReportActivityClickReq = new RedPackSkin$ReportActivityClickReq();
        PBInt32Field pBInt32Field = redPackSkin$ReportActivityClickReq.f278705id;
        Integer num = this.operationId;
        if (num != null) {
            i3 = num.intValue();
        }
        pBInt32Field.set(i3);
        pl2.d dVar = new pl2.d();
        QLog.i("QWalletHttp-QWalletPbServlet", 1, "send req: cmd=trpc.qpay.red_pack_skin.Skin.SsoReportActivityClick callback: " + dVar + TokenParser.SP);
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        NewIntent newIntent = new NewIntent(waitAppRuntime.getApplication(), p.class);
        newIntent.putExtra("cmd", "trpc.qpay.red_pack_skin.Skin.SsoReportActivityClick");
        newIntent.putExtra("data", fh.b(redPackSkin$ReportActivityClickReq.toByteArray()));
        newIntent.putExtra("timeout", 30000L);
        newIntent.setObserver(new c(dVar));
        waitAppRuntime.startServlet(newIntent);
    }

    public final void T1() {
        String str;
        boolean z16;
        String str2;
        SendHbOpActivitiesBean value = this._activitiesLiveBean.getValue();
        String str3 = null;
        if (value != null) {
            str = Integer.valueOf(value.getId()).toString();
        } else {
            str = null;
        }
        SendHbOpActivitiesBean value2 = this._activitiesLiveBean.getValue();
        if (value2 != null) {
            str3 = value2.getRightIconUrl();
        }
        if (str3 != null && str3.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            str2 = "0";
        } else {
            str2 = "1";
        }
        U1("redpack.make_entry.show", str, str2);
    }

    public final void W1() {
        MessageMicro<RedPackSkin$GetActivityReq> messageMicro = new MessageMicro<RedPackSkin$GetActivityReq>() { // from class: com.tencent.mobileqq.qwallet.pb.RedPackSkin$GetActivityReq
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], RedPackSkin$GetActivityReq.class);
        };
        e eVar = new e();
        p.Companion companion = p.INSTANCE;
        QLog.i("QWalletHttp-QWalletPbServlet", 1, "send req: cmd=trpc.qpay.red_pack_skin.Skin.SsoGetActivity callback: " + eVar + TokenParser.SP);
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        NewIntent newIntent = new NewIntent(waitAppRuntime.getApplication(), p.class);
        newIntent.putExtra("cmd", "trpc.qpay.red_pack_skin.Skin.SsoGetActivity");
        newIntent.putExtra("data", fh.b(messageMicro.toByteArray()));
        newIntent.putExtra("timeout", 30000L);
        newIntent.setObserver(new d(eVar));
        waitAppRuntime.startServlet(newIntent);
    }

    public final void X1(int i3) {
        this.defaultRecommendSkinId = i3;
    }

    public final void Z1(int i3) {
        this.jumpActionType = i3;
    }

    public final void a2(@Nullable String str) {
        this.jumpSchema = str;
    }

    public final void b2(@Nullable Integer num) {
        this.operationId = num;
    }
}
