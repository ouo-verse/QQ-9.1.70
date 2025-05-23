package com.tencent.mobileqq.onlinestatus.repository;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseBusinessHandler;
import com.tencent.mobileqq.onlinestatus.api.IAvatarPreviewService;
import com.tencent.mobileqq.onlinestatus.avatar.AvatarPreviewUtil;
import com.tencent.mobileqq.onlinestatus.networkhandler.OnlineStatusAggregationHandler;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.onlinestatus.OnlineStatusLikeInfo$CheckLikeRsp;
import tencent.im.onlinestatus.OnlineStatusLikeInfo$LikeItem;
import tencent.im.onlinestatus.OnlineStatusLikeInfo$UinLikeInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0007*\u0001*\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006\u00a2\u0006\u0004\b.\u0010/J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006J\u0006\u0010\b\u001a\u00020\u0002J\u0012\u0010\f\u001a\u00020\u000b2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\tJ\u000e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\u000bJ\u0006\u0010\u0011\u001a\u00020\u000bJ\u001e\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002J\u0018\u0010\u0019\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0018\u001a\u00020\u0017J\u000e\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0012R\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001c\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R0\u0010)\u001a\u001e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00020%j\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0002`&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/repository/OnlineStatusLikeRepository;", "Lcom/tencent/mobileqq/mvvm/a;", "", "index", "Lcom/tencent/mobileqq/onlinestatus/model/d;", DomainData.DOMAIN_NAME, "", "p", "o", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "", "u", "Lcom/tencent/mobileqq/onlinestatus/viewmodel/i;", "viewModel", "v", "l", ReportConstant.COSTREPORT_PREFIX, "", "uin", "likeType", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CLICK_TYPE, "t", "", "type", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "a", "Ljava/util/List;", "mFriendList", "b", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "mOnlineStatusLikeAdapter", "c", "Lcom/tencent/mobileqq/onlinestatus/viewmodel/i;", "mViewModel", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "d", "Ljava/util/HashMap;", "mLikeCache", "com/tencent/mobileqq/onlinestatus/repository/OnlineStatusLikeRepository$a", "e", "Lcom/tencent/mobileqq/onlinestatus/repository/OnlineStatusLikeRepository$a;", "aggregationObserver", "<init>", "(Ljava/util/List;)V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class OnlineStatusLikeRepository extends com.tencent.mobileqq.mvvm.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<com.tencent.mobileqq.onlinestatus.model.d> mFriendList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView.Adapter<?> mOnlineStatusLikeAdapter;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.onlinestatus.viewmodel.i mViewModel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, Integer> mLikeCache;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a aggregationObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J\u001a\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\bH\u0014\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/onlinestatus/repository/OnlineStatusLikeRepository$a", "Lcom/tencent/mobileqq/onlinestatus/observer/b;", "", "isSuccess", "Landroid/os/Bundle;", "data", "", "d", "", "a", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class a extends com.tencent.mobileqq.onlinestatus.observer.b {
        a() {
        }

        @Override // com.tencent.mobileqq.onlinestatus.observer.b
        protected void a(boolean isSuccess, @Nullable Object data) {
            if (isSuccess && data != null) {
                try {
                    OnlineStatusLikeInfo$CheckLikeRsp onlineStatusLikeInfo$CheckLikeRsp = new OnlineStatusLikeInfo$CheckLikeRsp();
                    onlineStatusLikeInfo$CheckLikeRsp.mergeFrom((byte[]) data);
                    int i3 = onlineStatusLikeInfo$CheckLikeRsp.err_code.get();
                    String obj = onlineStatusLikeInfo$CheckLikeRsp.err_msg.get().toString();
                    if (i3 == 0) {
                        com.tencent.mobileqq.onlinestatus.viewmodel.i iVar = OnlineStatusLikeRepository.this.mViewModel;
                        if (iVar == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                            iVar = null;
                        }
                        com.tencent.mobileqq.onlinestatus.viewmodel.i iVar2 = OnlineStatusLikeRepository.this.mViewModel;
                        if (iVar2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                            iVar2 = null;
                        }
                        com.tencent.mobileqq.onlinestatus.model.d P1 = iVar.P1(iVar2.R1());
                        for (OnlineStatusLikeInfo$UinLikeInfo onlineStatusLikeInfo$UinLikeInfo : onlineStatusLikeInfo$CheckLikeRsp.like_info.get()) {
                            List<OnlineStatusLikeInfo$LikeItem> list = onlineStatusLikeInfo$UinLikeInfo.like_items.get();
                            int i16 = 0;
                            if (list.size() > 0) {
                                i16 = list.get(0).like_type.get();
                            }
                            OnlineStatusLikeRepository.this.mLikeCache.put(String.valueOf(onlineStatusLikeInfo$UinLikeInfo.uin.get()), Integer.valueOf(i16));
                            if (onlineStatusLikeInfo$UinLikeInfo.uin.get() == Long.parseLong(P1.getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().x())) {
                                com.tencent.mobileqq.onlinestatus.viewmodel.i iVar3 = OnlineStatusLikeRepository.this.mViewModel;
                                if (iVar3 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                                    iVar3 = null;
                                }
                                iVar3.Q1().setValue(Integer.valueOf(i16));
                            }
                        }
                        return;
                    }
                    QLog.d("OnlineStatusLikeRepository", 1, "getLikeStatusToUpdateView resultCode = " + i3 + " resultMsg = " + obj);
                    return;
                } catch (Exception e16) {
                    QLog.e("OnlineStatusLikeRepository", 1, "getLikeStatusToUpdateView: " + e16);
                    QQToast.makeText(BaseApplication.context, 1, R.string.f172532qp, 1).show();
                    return;
                }
            }
            QQToast.makeText(BaseApplication.context, 1, R.string.f172532qp, 1).show();
        }

        @Override // com.tencent.mobileqq.onlinestatus.observer.b
        protected void d(boolean isSuccess, @Nullable Bundle data) {
            String str;
            if (!isSuccess) {
                QQToast.makeText(BaseApplication.context, 1, R.string.f172522qo, 1).show();
                return;
            }
            String str2 = "";
            com.tencent.mobileqq.onlinestatus.viewmodel.i iVar = null;
            if (data != null) {
                str = data.getString("os_uin_key", "");
            } else {
                str = null;
            }
            if (str != null) {
                str2 = str;
            }
            int i3 = 0;
            if (data != null) {
                i3 = data.getInt("os_like_key", 0);
            }
            if (!TextUtils.isEmpty(str2)) {
                OnlineStatusLikeRepository.this.mLikeCache.put(str2, Integer.valueOf(i3));
            }
            com.tencent.mobileqq.onlinestatus.viewmodel.i iVar2 = OnlineStatusLikeRepository.this.mViewModel;
            if (iVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                iVar2 = null;
            }
            com.tencent.mobileqq.onlinestatus.viewmodel.i iVar3 = OnlineStatusLikeRepository.this.mViewModel;
            if (iVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                iVar3 = null;
            }
            if (Intrinsics.areEqual(str2, iVar2.P1(iVar3.R1()).getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().x())) {
                com.tencent.mobileqq.onlinestatus.viewmodel.i iVar4 = OnlineStatusLikeRepository.this.mViewModel;
                if (iVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                } else {
                    iVar = iVar4;
                }
                iVar.Q1().setValue(Integer.valueOf(i3));
            }
        }
    }

    public OnlineStatusLikeRepository(@NotNull List<com.tencent.mobileqq.onlinestatus.model.d> mFriendList) {
        Intrinsics.checkNotNullParameter(mFriendList, "mFriendList");
        this.mFriendList = mFriendList;
        this.mLikeCache = new HashMap<>();
        this.aggregationObserver = new a();
    }

    public final void l() {
        AppInterface appInterface;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            appInterface.addObserver(this.aggregationObserver);
        }
    }

    public final void m(@Nullable String uin, long type) {
        long parseLong;
        IAvatarPreviewService e16 = AvatarPreviewUtil.f255541a.e();
        if (uin != null) {
            try {
                parseLong = Long.parseLong(uin);
            } catch (Exception e17) {
                QLog.e("OnlineStatusLikeRepository", 1, "getStatusJumpScheme fail:", e17);
                return;
            }
        } else {
            parseLong = 0;
        }
        e16.getStatusJumpScheme(parseLong, type, new Function2<Boolean, String, Unit>() { // from class: com.tencent.mobileqq.onlinestatus.repository.OnlineStatusLikeRepository$getAvatarClickedSchema$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str) {
                invoke2(bool, str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Boolean bool, @Nullable String str) {
                Intrinsics.checkNotNull(bool);
                if (!bool.booleanValue()) {
                    QLog.e("OnlineStatusLikeRepository", 1, "getStatusJumpScheme fail");
                }
                com.tencent.mobileqq.onlinestatus.viewmodel.i iVar = OnlineStatusLikeRepository.this.mViewModel;
                if (iVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                    iVar = null;
                }
                if (TextUtils.isEmpty(str)) {
                    str = "";
                } else {
                    Intrinsics.checkNotNull(str);
                }
                iVar.W1(str);
            }
        });
    }

    @NotNull
    public final com.tencent.mobileqq.onlinestatus.model.d n(int index) {
        return this.mFriendList.get(index);
    }

    public final int o() {
        return this.mFriendList.size();
    }

    @NotNull
    public final List<com.tencent.mobileqq.onlinestatus.model.d> p() {
        return this.mFriendList;
    }

    public final void q(@NotNull String uin) {
        ArrayList<String> arrayListOf;
        AppInterface appInterface;
        BaseBusinessHandler baseBusinessHandler;
        Intrinsics.checkNotNullParameter(uin, "uin");
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(uin);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        OnlineStatusAggregationHandler onlineStatusAggregationHandler = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            baseBusinessHandler = appInterface.getBusinessHandler(OnlineStatusAggregationHandler.class.getName());
        } else {
            baseBusinessHandler = null;
        }
        if (baseBusinessHandler instanceof OnlineStatusAggregationHandler) {
            onlineStatusAggregationHandler = (OnlineStatusAggregationHandler) baseBusinessHandler;
        }
        if (onlineStatusAggregationHandler != null) {
            onlineStatusAggregationHandler.D2(arrayListOf, 1);
        }
    }

    public final int r(@NotNull String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Integer num = this.mLikeCache.get(uin);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public final void s() {
        AppInterface appInterface;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            appInterface.removeObserver(this.aggregationObserver);
        }
    }

    public final void t(@NotNull String uin, int likeType, int clickType) {
        AppInterface appInterface;
        BaseBusinessHandler baseBusinessHandler;
        Intrinsics.checkNotNullParameter(uin, "uin");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        OnlineStatusAggregationHandler onlineStatusAggregationHandler = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            baseBusinessHandler = appInterface.getBusinessHandler(OnlineStatusAggregationHandler.class.getName());
        } else {
            baseBusinessHandler = null;
        }
        if (baseBusinessHandler instanceof OnlineStatusAggregationHandler) {
            onlineStatusAggregationHandler = (OnlineStatusAggregationHandler) baseBusinessHandler;
        }
        OnlineStatusAggregationHandler onlineStatusAggregationHandler2 = onlineStatusAggregationHandler;
        if (onlineStatusAggregationHandler2 != null) {
            onlineStatusAggregationHandler2.K2(uin, likeType, 1, clickType, null);
        }
    }

    public final void u(@NotNull RecyclerView.Adapter<?> adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.mOnlineStatusLikeAdapter = adapter;
    }

    public final void v(@NotNull com.tencent.mobileqq.onlinestatus.viewmodel.i viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.mViewModel = viewModel;
    }
}
