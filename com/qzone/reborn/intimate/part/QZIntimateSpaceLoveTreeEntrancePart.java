package com.qzone.reborn.intimate.part;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.qzone.proto.SocialTree$CollectWaterReq;
import com.qzone.proto.SocialTree$GettWaterTaskListReq;
import com.qzone.proto.SocialTree$GettWaterTaskListRsp;
import com.qzone.proto.SocialTree$WateringReq;
import com.qzone.proto.SocialTreeCommon$WaterTask;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.reborn.intimate.bean.QZoneIntimateSpaceBean;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateLoveTreeInitBean;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.mobileqq.vas.ui.APNGDrawable;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import common.config.service.QzoneConfig;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ,2\u00020\u0001:\u0001-B\u0007\u00a2\u0006\u0004\b*\u0010+J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J+\u0010\u0010\u001a\u00020\u00072!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00070\nH\u0002J\u0016\u0010\u0013\u001a\u00020\u00072\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011H\u0002J\u0016\u0010\u0014\u001a\u00020\u00072\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011H\u0002J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0012\u0010\u001a\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u001b\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016R\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010\"R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006."}, d2 = {"Lcom/qzone/reborn/intimate/part/QZIntimateSpaceLoveTreeEntrancePart;", "Lcom/qzone/reborn/base/k;", "", "M9", "()Ljava/lang/Long;", "", "apngUrl", "", "R9", "J9", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "hasTree", "callback", "Q9", "Lkotlin/Function0;", "successCallback", "K9", "L9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "onPartDestroy", "Lnk/at;", "d", "Lnk/at;", "mSpaceViewModel", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "signBubble", "f", QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, "Lcom/tencent/mobileqq/vas/ui/APNGDrawable;", tl.h.F, "Lcom/tencent/mobileqq/vas/ui/APNGDrawable;", "entranceApngDrawable", "<init>", "()V", "i", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZIntimateSpaceLoveTreeEntrancePart extends com.qzone.reborn.base.k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private nk.at mSpaceViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView signBubble;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView entrance;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private APNGDrawable entranceApngDrawable;

    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J$\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"com/qzone/reborn/intimate/part/QZIntimateSpaceLoveTreeEntrancePart$b", "Lcom/tencent/biz/ProtoUtils$TroopProtocolObserver;", "", "errorCode", "", "data", "Landroid/os/Bundle;", "bundle", "", "onResult", "", "errorMsg", "", "onError", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b extends ProtoUtils.TroopProtocolObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f57233d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QZIntimateSpaceLoveTreeEntrancePart f57234e;

        b(Function0<Unit> function0, QZIntimateSpaceLoveTreeEntrancePart qZIntimateSpaceLoveTreeEntrancePart) {
            this.f57233d = function0;
            this.f57234e = qZIntimateSpaceLoveTreeEntrancePart;
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public boolean onError(int errorCode, String errorMsg, Bundle bundle) {
            QLog.e("QZIntimateSpaceLoveTreeEntrancePart", 1, "fastSignIn fail. Error: error code is " + errorCode + ", error msg is " + errorMsg);
            QQToast.makeText(this.f57234e.getContext(), 1, "\u7b7e\u5230\u5931\u8d25", 0).show();
            return true;
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int errorCode, byte[] data, Bundle bundle) {
            if (errorCode == 0 && data != null) {
                QLog.i("QZIntimateSpaceLoveTreeEntrancePart", 1, "fastSignIn success");
                this.f57233d.invoke();
            } else {
                QLog.e("QZIntimateSpaceLoveTreeEntrancePart", 1, "fastSignIn fail, Error: error code is " + errorCode);
            }
        }
    }

    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J$\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"com/qzone/reborn/intimate/part/QZIntimateSpaceLoveTreeEntrancePart$c", "Lcom/tencent/biz/ProtoUtils$TroopProtocolObserver;", "", "errorCode", "", "data", "Landroid/os/Bundle;", "bundle", "", "onResult", "", "errorMsg", "", "onError", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c extends ProtoUtils.TroopProtocolObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f57235d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QZIntimateSpaceLoveTreeEntrancePart f57236e;

        c(Function0<Unit> function0, QZIntimateSpaceLoveTreeEntrancePart qZIntimateSpaceLoveTreeEntrancePart) {
            this.f57235d = function0;
            this.f57236e = qZIntimateSpaceLoveTreeEntrancePart;
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public boolean onError(int errorCode, String errorMsg, Bundle bundle) {
            QLog.e("QZIntimateSpaceLoveTreeEntrancePart", 1, "fastSignIn watering fail. Error: error code is " + errorCode + ", error msg is " + errorMsg);
            QQToast.makeText(this.f57236e.getContext(), 1, "\u7b7e\u5230\u5931\u8d25", 0).show();
            return true;
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int errorCode, byte[] data, Bundle bundle) {
            if (errorCode == 0 && data != null) {
                QLog.i("QZIntimateSpaceLoveTreeEntrancePart", 1, "fastSignIn watering success");
                this.f57235d.invoke();
                QQToast.makeText(this.f57236e.getContext(), 2, "\u7b7e\u5230\u6210\u529f", 0).show();
            } else {
                QLog.e("QZIntimateSpaceLoveTreeEntrancePart", 1, "fastSignIn watering fail, Error: error code is " + errorCode);
            }
        }
    }

    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J$\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"com/qzone/reborn/intimate/part/QZIntimateSpaceLoveTreeEntrancePart$d", "Lcom/tencent/biz/ProtoUtils$TroopProtocolObserver;", "", "errorCode", "", "data", "Landroid/os/Bundle;", "bundle", "", "onResult", "", "errorMsg", "", "onError", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class d extends ProtoUtils.TroopProtocolObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function1<Boolean, Unit> f57237d;

        /* JADX WARN: Multi-variable type inference failed */
        d(Function1<? super Boolean, Unit> function1) {
            this.f57237d = function1;
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public boolean onError(int errorCode, String errorMsg, Bundle bundle) {
            QLog.e("QZIntimateSpaceLoveTreeEntrancePart", 1, "requestTodayCheckInRequest on error, error code is " + errorCode + ", error msg is " + errorMsg);
            return true;
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int errorCode, byte[] data, Bundle bundle) {
            boolean z16;
            if (errorCode == 0 && data != null) {
                SocialTree$GettWaterTaskListRsp socialTree$GettWaterTaskListRsp = new SocialTree$GettWaterTaskListRsp();
                try {
                    socialTree$GettWaterTaskListRsp.mergeFrom(data);
                    Iterator<SocialTreeCommon$WaterTask> it = socialTree$GettWaterTaskListRsp.task_list.get().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z16 = true;
                            break;
                        }
                        SocialTreeCommon$WaterTask next = it.next();
                        if (next.f50094id.get() == 1) {
                            z16 = next.is_complete.get();
                            break;
                        }
                    }
                    this.f57237d.invoke(Boolean.valueOf(z16));
                    return;
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.e("QZIntimateSpaceLoveTreeEntrancePart", 1, "fastSignIn fail, Error: response data decode fail");
                    e16.printStackTrace();
                    return;
                }
            }
            QLog.e("QZIntimateSpaceLoveTreeEntrancePart", 1, "fastSignIn fail, Error: error code is " + errorCode);
        }
    }

    private final void J9() {
        Long M9 = M9();
        if (M9 == null) {
            QLog.e("QZIntimateSpaceLoveTreeEntrancePart", 1, "enterLoveTree fail. Error: peer uin is null");
            return;
        }
        QZoneIntimateLoveTreeInitBean qZoneIntimateLoveTreeInitBean = new QZoneIntimateLoveTreeInitBean();
        qZoneIntimateLoveTreeInitBean.setPeerUin(M9.toString());
        qZoneIntimateLoveTreeInitBean.setEnterPage("0");
        qZoneIntimateLoveTreeInitBean.setFrom("3");
        ck.c o16 = ho.i.o();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        o16.g(context, qZoneIntimateLoveTreeInitBean);
    }

    private final void K9(Function0<Unit> successCallback) {
        List<Integer> listOf;
        Long M9 = M9();
        if (M9 == null) {
            QLog.e("QZIntimateSpaceLoveTreeEntrancePart", 1, "fastSignIn fail. Error: peer uin is null");
            return;
        }
        SocialTree$CollectWaterReq socialTree$CollectWaterReq = new SocialTree$CollectWaterReq();
        socialTree$CollectWaterReq.uin.set(M9.longValue());
        PBRepeatField<Integer> pBRepeatField = socialTree$CollectWaterReq.id_list;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(1);
        pBRepeatField.set(listOf);
        ProtoUtils.a(MobileQQ.sMobileQQ.peekAppRuntime(), new b(successCallback, this), socialTree$CollectWaterReq.toByteArray(), "OidbSvcTrpcTcp.0x9374", 37748, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L9(Function0<Unit> successCallback) {
        List<Integer> listOf;
        Long M9 = M9();
        if (M9 == null) {
            QLog.e("QZIntimateSpaceLoveTreeEntrancePart", 1, "fastSignIn watering fail. Error: peer uin is null");
            return;
        }
        SocialTree$WateringReq socialTree$WateringReq = new SocialTree$WateringReq();
        socialTree$WateringReq.uin.set(M9.longValue());
        PBRepeatField<Integer> pBRepeatField = socialTree$WateringReq.id_list;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(1);
        pBRepeatField.set(listOf);
        ProtoUtils.a(MobileQQ.sMobileQQ.peekAppRuntime(), new c(successCallback, this), socialTree$WateringReq.toByteArray(), "OidbSvcTrpcTcp.0x9392", 37778, 1);
    }

    private final Long M9() {
        Object obj;
        nk.at atVar = this.mSpaceViewModel;
        if (atVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSpaceViewModel");
            atVar = null;
        }
        QZoneIntimateSpaceBean X1 = atVar.X1();
        if (X1 == null) {
            QLog.e("QZIntimateSpaceLoveTreeEntrancePart", RFWLog.USR, "enter love tree fail. Error: spaceBean is null");
            return null;
        }
        Iterator<T> it = X1.getMembers().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (!ef.b.g((User) obj)) {
                break;
            }
        }
        User user = (User) obj;
        if (user == null) {
            QLog.e("QZIntimateSpaceLoveTreeEntrancePart", RFWLog.USR, "enter love tree fail. Error: peerUser is null");
            return null;
        }
        return Long.valueOf(user.uin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(QZIntimateSpaceLoveTreeEntrancePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.J9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(final QZIntimateSpaceLoveTreeEntrancePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.K9(new Function0<Unit>() { // from class: com.qzone.reborn.intimate.part.QZIntimateSpaceLoveTreeEntrancePart$onInitView$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                final QZIntimateSpaceLoveTreeEntrancePart qZIntimateSpaceLoveTreeEntrancePart = QZIntimateSpaceLoveTreeEntrancePart.this;
                qZIntimateSpaceLoveTreeEntrancePart.L9(new Function0<Unit>() { // from class: com.qzone.reborn.intimate.part.QZIntimateSpaceLoveTreeEntrancePart$onInitView$2$1.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        ImageView imageView;
                        imageView = QZIntimateSpaceLoveTreeEntrancePart.this.signBubble;
                        if (imageView == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("signBubble");
                            imageView = null;
                        }
                        imageView.setVisibility(8);
                    }
                });
            }
        });
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q9(Function1<? super Boolean, Unit> callback) {
        List<Integer> listOf;
        Long M9 = M9();
        if (M9 == null) {
            QLog.e("QZIntimateSpaceLoveTreeEntrancePart", 1, "requestHasSignIn fail. Error: peer uin is null");
            return;
        }
        SocialTree$GettWaterTaskListReq socialTree$GettWaterTaskListReq = new SocialTree$GettWaterTaskListReq();
        socialTree$GettWaterTaskListReq.uin.set(M9.longValue());
        PBRepeatField<Integer> pBRepeatField = socialTree$GettWaterTaskListReq.id_list;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(1);
        pBRepeatField.set(listOf);
        ProtoUtils.a(MobileQQ.sMobileQQ.peekAppRuntime(), new d(callback), socialTree$GettWaterTaskListReq.toByteArray(), "OidbSvcTrpcTcp.0x939d", 37789, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R9(String apngUrl) {
        ApngOptions apngOptions = new ApngOptions();
        APNGDrawable aPNGDrawable = this.entranceApngDrawable;
        if (aPNGDrawable != null) {
            aPNGDrawable.stop();
        }
        ImageView imageView = null;
        this.entranceApngDrawable = null;
        this.entranceApngDrawable = ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngDrawable("QZIntimateSpaceLoveTreeEntrancePart", apngUrl, apngOptions);
        ImageView imageView2 = this.entrance;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE);
        } else {
            imageView = imageView2;
        }
        imageView.setImageDrawable(this.entranceApngDrawable);
        APNGDrawable aPNGDrawable2 = this.entranceApngDrawable;
        if (aPNGDrawable2 != null) {
            aPNGDrawable2.start();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        final View findViewById = rootView.findViewById(R.id.kqn);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026intimate_space_love_tree)");
        View findViewById2 = rootView.findViewById(R.id.kqo);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026space_love_tree_entrance)");
        ImageView imageView = (ImageView) findViewById2;
        this.entrance = imageView;
        nk.at atVar = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE);
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.intimate.part.at
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZIntimateSpaceLoveTreeEntrancePart.N9(QZIntimateSpaceLoveTreeEntrancePart.this, view);
            }
        });
        ImageView imageView2 = this.entrance;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE);
            imageView2 = null;
        }
        fo.c.n(imageView2, "em_qz_love_tree_entry");
        View findViewById3 = rootView.findViewById(R.id.kqp);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026_space_love_tree_sign_in)");
        ImageView imageView3 = (ImageView) findViewById3;
        this.signBubble = imageView3;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signBubble");
            imageView3 = null;
        }
        imageView3.setVisibility(8);
        ImageView imageView4 = this.signBubble;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signBubble");
            imageView4 = null;
        }
        imageView4.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.intimate.part.au
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZIntimateSpaceLoveTreeEntrancePart.O9(QZIntimateSpaceLoveTreeEntrancePart.this, view);
            }
        });
        ImageView imageView5 = this.signBubble;
        if (imageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signBubble");
            imageView5 = null;
        }
        fo.c.n(imageView5, "em_qz_love_tree_drop_entry");
        ViewModel viewModel = getViewModel(nk.at.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneIntima\u2026TabViewModel::class.java)");
        nk.at atVar2 = (nk.at) viewModel;
        this.mSpaceViewModel = atVar2;
        if (atVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSpaceViewModel");
        } else {
            atVar = atVar2;
        }
        MutableLiveData<UIStateData<QZoneIntimateSpaceBean>> U1 = atVar.U1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<UIStateData<QZoneIntimateSpaceBean>, Unit> function1 = new Function1<UIStateData<QZoneIntimateSpaceBean>, Unit>() { // from class: com.qzone.reborn.intimate.part.QZIntimateSpaceLoveTreeEntrancePart$onInitView$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<QZoneIntimateSpaceBean> uIStateData) {
                invoke2(uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UIStateData<QZoneIntimateSpaceBean> uIStateData) {
                QLog.i("QZIntimateSpaceLoveTreeEntrancePart", RFWLog.USR, "lifecycle: " + QZIntimateSpaceLoveTreeEntrancePart.this.getPartHost().getLifecycleOwner().getLifecycle().getCurrentState());
                QZoneIntimateSpaceBean data = uIStateData.getData();
                if ((data != null ? data.isMasterSpace() : false) && uIStateData.getData().isLoveSpace() && mk.a.f416872a.a()) {
                    findViewById.setVisibility(0);
                    QZIntimateSpaceLoveTreeEntrancePart.this.R9("https://qzonestyle.gtimg.cn/qzone/client/intimate_space/social_tree/entrance/love_tree_seeding.png");
                    final QZIntimateSpaceLoveTreeEntrancePart qZIntimateSpaceLoveTreeEntrancePart = QZIntimateSpaceLoveTreeEntrancePart.this;
                    qZIntimateSpaceLoveTreeEntrancePart.Q9(new Function1<Boolean, Unit>() { // from class: com.qzone.reborn.intimate.part.QZIntimateSpaceLoveTreeEntrancePart$onInitView$3.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z16) {
                            ImageView imageView6;
                            ImageView imageView7;
                            ImageView imageView8 = null;
                            if (!z16) {
                                Context context = QZIntimateSpaceLoveTreeEntrancePart.this.getContext();
                                imageView7 = QZIntimateSpaceLoveTreeEntrancePart.this.signBubble;
                                if (imageView7 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("signBubble");
                                    imageView7 = null;
                                }
                                com.qzone.reborn.util.h.i(context, imageView7, "https://image.superqqshow.qq.com/wuji/qq_zplan_config_test/couple_space_pic_resouce/4221bcd7_ewkHVTbJ9gR.png", ef.d.b(40), ef.d.b(45));
                            }
                            imageView6 = QZIntimateSpaceLoveTreeEntrancePart.this.signBubble;
                            if (imageView6 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("signBubble");
                            } else {
                                imageView8 = imageView6;
                            }
                            imageView8.setVisibility(z16 ? 8 : 0);
                        }
                    });
                    return;
                }
                findViewById.setVisibility(8);
            }
        };
        U1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.intimate.part.av
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZIntimateSpaceLoveTreeEntrancePart.P9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        APNGDrawable aPNGDrawable = this.entranceApngDrawable;
        if (aPNGDrawable != null) {
            aPNGDrawable.stop();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        QZoneIntimateSpaceBean data;
        super.onPartResume(activity);
        QLog.i("QZIntimateSpaceLoveTreeEntrancePart", RFWLog.USR, "lifecycle: OnResume");
        nk.at atVar = this.mSpaceViewModel;
        if (atVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSpaceViewModel");
            atVar = null;
        }
        UIStateData<QZoneIntimateSpaceBean> value = atVar.U1().getValue();
        if (value != null && (data = value.getData()) != null && data.isMasterSpace() && data.isLoveSpace() && mk.a.f416872a.a()) {
            Q9(new Function1<Boolean, Unit>() { // from class: com.qzone.reborn.intimate.part.QZIntimateSpaceLoveTreeEntrancePart$onPartResume$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16) {
                    ImageView imageView;
                    imageView = QZIntimateSpaceLoveTreeEntrancePart.this.signBubble;
                    if (imageView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("signBubble");
                        imageView = null;
                    }
                    imageView.setVisibility(z16 ? 8 : 0);
                }
            });
        }
    }
}
