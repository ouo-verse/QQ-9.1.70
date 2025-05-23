package com.tencent.biz.qqcircle.share.part;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qcircleshadow.lib.variation.HostForwardUtils;
import com.tencent.biz.qqcircle.comment.at.bean.QFSCommentAtEntity;
import com.tencent.biz.qqcircle.immersive.part.u;
import com.tencent.biz.qqcircle.share.bean.QFSShareSelectMemberInitBean;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import cooperation.qzone.QzoneIPCModule;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import uq3.o;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 N2\u00020\u00012\u00020\u0002:\u0002OPB\u000f\u0012\u0006\u0010#\u001a\u00020\u0015\u00a2\u0006\u0004\bL\u0010MJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0012\u0010\u000e\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002J\u001a\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0012\u0010\u001b\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u001e\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016R\u0017\u0010#\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010&R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00103\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00100R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\"\u0010=\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020:09088\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u0010<R#\u0010D\u001a\n ?*\u0004\u0018\u00010>0>8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR\u0018\u0010G\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010I\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010FR\u0018\u0010K\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010F\u00a8\u0006Q"}, d2 = {"Lcom/tencent/biz/qqcircle/share/part/QFSShareSelectMemberSenderPart;", "Lcom/tencent/biz/qqcircle/immersive/part/u;", "Landroid/view/View$OnClickListener;", "", "E9", "G9", "initViewModel", "F9", "L9", "K9", "Landroid/os/ResultReceiver;", "C9", "Landroid/os/Bundle;", "resultData", "J9", "", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "B9", "", QzoneIPCModule.RESULT_CODE, "I9", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "v", NodeProps.ON_CLICK, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "d", "Ljava/lang/String;", "getSelectType", "()Ljava/lang/String;", "selectType", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "closeTv", "f", "titleTv", "Landroid/widget/ImageView;", tl.h.F, "Landroid/widget/ImageView;", "closeIv", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "i", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "topSendBtn", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "bottomSendBtn", "Landroid/widget/FrameLayout;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/FrameLayout;", "bottomBtnLayout", "Landroidx/lifecycle/Observer;", "Lcom/tencent/richframework/data/base/UIStateData;", "Lcom/tencent/biz/qqcircle/comment/at/bean/QFSCommentAtEntity;", "D", "Landroidx/lifecycle/Observer;", "selectStatusObserver", "Lzb0/a;", "kotlin.jvm.PlatformType", "E", "Lkotlin/Lazy;", "D9", "()Lzb0/a;", "viewModel", UserInfo.SEX_FEMALE, "Landroid/os/ResultReceiver;", "shareCallbackResultReceiver", "G", "shareReportResultReceiver", "H", "selectedMemberResultReceiver", "<init>", "(Ljava/lang/String;)V", "I", "a", "QFSShareResultReceiver", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class QFSShareSelectMemberSenderPart extends u implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private FrameLayout bottomBtnLayout;

    /* renamed from: D, reason: from kotlin metadata */
    private Observer<UIStateData<QFSCommentAtEntity>> selectStatusObserver;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private ResultReceiver shareCallbackResultReceiver;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private ResultReceiver shareReportResultReceiver;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private ResultReceiver selectedMemberResultReceiver;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String selectType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView closeTv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView titleTv;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView closeIv;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QUIButton topSendBtn;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private QUIButton bottomSendBtn;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\r\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/biz/qqcircle/share/part/QFSShareSelectMemberSenderPart$QFSShareResultReceiver;", "Landroid/os/ResultReceiver;", "", QzoneIPCModule.RESULT_CODE, "Landroid/os/Bundle;", "resultData", "", "onReceiveResult", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/biz/qqcircle/share/part/QFSShareSelectMemberSenderPart;", "d", "Ljava/lang/ref/WeakReference;", "senderPartWrf", "senderPart", "Landroid/os/Handler;", "handler", "<init>", "(Lcom/tencent/biz/qqcircle/share/part/QFSShareSelectMemberSenderPart;Landroid/os/Handler;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class QFSShareResultReceiver extends ResultReceiver {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<QFSShareSelectMemberSenderPart> senderPartWrf;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public QFSShareResultReceiver(@Nullable QFSShareSelectMemberSenderPart qFSShareSelectMemberSenderPart, @NotNull Handler handler) {
            super(handler);
            Intrinsics.checkNotNullParameter(handler, "handler");
            this.senderPartWrf = new WeakReference<>(qFSShareSelectMemberSenderPart);
        }

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int resultCode, @Nullable Bundle resultData) {
            QFSShareSelectMemberSenderPart qFSShareSelectMemberSenderPart = this.senderPartWrf.get();
            if (qFSShareSelectMemberSenderPart != null) {
                qFSShareSelectMemberSenderPart.I9(resultCode, resultData);
                if (resultCode == -1) {
                    qFSShareSelectMemberSenderPart.J9(resultData);
                    Activity activity = qFSShareSelectMemberSenderPart.getActivity();
                    if (activity != null) {
                        activity.finish();
                        return;
                    }
                    return;
                }
                return;
            }
            QLog.d("QFSShareSelectMemberSenderPart", 1, "[onReceiveResult] senderPart is null.");
        }
    }

    public QFSShareSelectMemberSenderPart(@NotNull String selectType) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(selectType, "selectType");
        this.selectType = selectType;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<zb0.a>() { // from class: com.tencent.biz.qqcircle.share.part.QFSShareSelectMemberSenderPart$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final zb0.a invoke() {
                return (zb0.a) QFSShareSelectMemberSenderPart.this.getViewModel(zb0.a.class);
            }
        });
        this.viewModel = lazy;
    }

    private final List<ResultRecord> B9() {
        List<ResultRecord> list;
        ArrayList arrayList = new ArrayList();
        for (QFSCommentAtEntity qFSCommentAtEntity : D9().N1()) {
            ResultRecord resultRecord = new ResultRecord();
            resultRecord.uin = qFSCommentAtEntity.e();
            resultRecord.name = qFSCommentAtEntity.b();
            resultRecord.uinType = qFSCommentAtEntity.f();
            arrayList.add(resultRecord);
        }
        list = CollectionsKt___CollectionsKt.toList(arrayList);
        return list;
    }

    private final ResultReceiver C9() {
        if (o.Y1("qqcircle_enable_share_select_fix_leak", true)) {
            return new QFSShareResultReceiver(this, new Handler(Looper.getMainLooper()));
        }
        final Handler handler = new Handler(Looper.getMainLooper());
        return new ResultReceiver(handler) { // from class: com.tencent.biz.qqcircle.share.part.QFSShareSelectMemberSenderPart$getResultReceiver$1
            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int resultCode, @Nullable Bundle resultData) {
                QFSShareSelectMemberSenderPart.this.I9(resultCode, resultData);
                if (resultCode == -1) {
                    Activity activity = QFSShareSelectMemberSenderPart.this.getActivity();
                    if (activity != null) {
                        activity.finish();
                    }
                    QFSShareSelectMemberSenderPart.this.J9(resultData);
                }
            }
        };
    }

    private final zb0.a D9() {
        return (zb0.a) this.viewModel.getValue();
    }

    private final void E9() {
        ResultReceiver resultReceiver;
        Intent intent;
        Intent intent2;
        Activity activity = getActivity();
        ResultReceiver resultReceiver2 = null;
        if (activity != null && (intent2 = activity.getIntent()) != null) {
            resultReceiver = (ResultReceiver) intent2.getParcelableExtra("PARAM_ActivityResultReceiver");
        } else {
            resultReceiver = null;
        }
        this.shareReportResultReceiver = resultReceiver;
        Activity activity2 = getActivity();
        if (activity2 != null && (intent = activity2.getIntent()) != null) {
            resultReceiver2 = (ResultReceiver) intent.getParcelableExtra("param_select_member_activity_result_receiver");
        }
        this.selectedMemberResultReceiver = resultReceiver2;
    }

    private final void F9() {
        int i3;
        boolean areEqual = Intrinsics.areEqual(this.selectType, "select_type_friends");
        FrameLayout frameLayout = this.bottomBtnLayout;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomBtnLayout");
            frameLayout = null;
        }
        if (areEqual) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        frameLayout.setVisibility(i3);
        L9();
    }

    private final void G9() {
        String str = this.selectType;
        ImageView imageView = null;
        if (Intrinsics.areEqual(str, "select_type_troops")) {
            TextView textView = this.titleTv;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleTv");
                textView = null;
            }
            textView.setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f1905842h));
            TextView textView2 = this.closeTv;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("closeTv");
                textView2 = null;
            }
            textView2.setVisibility(8);
            ImageView imageView2 = this.closeIv;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("closeIv");
            } else {
                imageView = imageView2;
            }
            imageView.setVisibility(0);
            return;
        }
        if (Intrinsics.areEqual(str, "select_type_mutual_follow")) {
            TextView textView3 = this.titleTv;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleTv");
                textView3 = null;
            }
            textView3.setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f1905742g));
            TextView textView4 = this.closeTv;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("closeTv");
                textView4 = null;
            }
            textView4.setVisibility(8);
            ImageView imageView3 = this.closeIv;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("closeIv");
            } else {
                imageView = imageView3;
            }
            imageView.setVisibility(0);
            return;
        }
        TextView textView5 = this.titleTv;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTv");
            textView5 = null;
        }
        textView5.setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f1909043c));
        TextView textView6 = this.closeTv;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeTv");
            textView6 = null;
        }
        textView6.setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f181803er));
        ImageView imageView4 = this.closeIv;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeIv");
        } else {
            imageView = imageView4;
        }
        imageView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(QFSShareSelectMemberSenderPart this$0, UIStateData uIStateData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.L9();
        QFSCommentAtEntity qFSCommentAtEntity = (QFSCommentAtEntity) uIStateData.getData();
        if (qFSCommentAtEntity != null) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("param_changed_item", qFSCommentAtEntity);
            if (uIStateData.getState() == 8) {
                this$0.I9(1000, bundle);
            } else if (uIStateData.getState() == 6) {
                this$0.I9(1001, bundle);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I9(int resultCode, Bundle resultData) {
        ResultReceiver resultReceiver;
        if (resultCode == -1 && (resultReceiver = this.shareReportResultReceiver) != null) {
            resultReceiver.send(resultCode, resultData);
        }
        ResultReceiver resultReceiver2 = this.selectedMemberResultReceiver;
        if (resultReceiver2 != null) {
            resultReceiver2.send(resultCode, resultData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J9(Bundle resultData) {
        Intent intent;
        QFSShareSelectMemberInitBean qFSShareSelectMemberInitBean;
        String str;
        boolean z16;
        Activity activity = getActivity();
        String str2 = null;
        if (activity != null) {
            intent = activity.getIntent();
        } else {
            intent = null;
        }
        if (intent == null) {
            return;
        }
        Serializable serializableExtra = intent.getSerializableExtra("key_bundle_common_init_bean");
        if (serializableExtra instanceof QFSShareSelectMemberInitBean) {
            qFSShareSelectMemberInitBean = (QFSShareSelectMemberInitBean) serializableExtra;
        } else {
            qFSShareSelectMemberInitBean = null;
        }
        if (qFSShareSelectMemberInitBean != null) {
            str = qFSShareSelectMemberInitBean.getFeedId();
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.d("QFSShareSelectMemberSenderPart", 1, "[sendShareRequest] feedId is null");
            return;
        }
        String str3 = "";
        if (resultData != null) {
            str2 = resultData.getString(AppConstants.Key.SHARE_RES_COMMENT_MESSAGE, "");
        }
        if (str2 != null) {
            str3 = str2;
        }
        yb0.l.f449997a.e(str, B9(), str3, true);
    }

    private final void K9() {
        Intent intent;
        List<QFSCommentAtEntity> N1 = D9().N1();
        if (N1.isEmpty()) {
            return;
        }
        Activity activity = getActivity();
        if (activity != null) {
            intent = activity.getIntent();
        } else {
            intent = null;
        }
        if (intent == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(QCircleHostConstants._ForwardRecentActivity.KEY_REQ(), 6);
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        for (QFSCommentAtEntity qFSCommentAtEntity : N1) {
            ResultRecord resultRecord = new ResultRecord();
            resultRecord.name = qFSCommentAtEntity.name;
            resultRecord.uin = qFSCommentAtEntity.uin;
            int i3 = qFSCommentAtEntity.uinType;
            resultRecord.uinType = i3;
            resultRecord.type = i3;
            resultRecord.isNewTroop = false;
            arrayList.add(resultRecord);
        }
        bundle.putParcelableArrayList("selected_target_list", arrayList);
        intent.putExtras(bundle);
        intent.putExtra(ForwardBaseOption.FORWARD_INPUT_VIEW_HIDE, true);
        intent.putExtra("share_not_send_by_client", true);
        intent.putExtra("host_forward_type_key", HostForwardUtils.HOST_FORWARD_RECENTLY_CHAT_FLAG());
        if (this.shareCallbackResultReceiver == null) {
            this.shareCallbackResultReceiver = C9();
        }
        intent.putExtra("PARAM_ActivityResultReceiver", this.shareCallbackResultReceiver);
        new HostForwardUtils().startForwardActivityForResult(getActivity(), intent);
    }

    private final void L9() {
        boolean z16;
        String str;
        int size = D9().N1().size();
        if (size <= 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        int i3 = 8;
        QUIButton qUIButton = null;
        if (Intrinsics.areEqual(this.selectType, "select_type_friends")) {
            QUIButton qUIButton2 = this.topSendBtn;
            if (qUIButton2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topSendBtn");
                qUIButton2 = null;
            }
            if (!z16) {
                i3 = 0;
            }
            qUIButton2.setVisibility(i3);
            if (!z16) {
                QUIButton qUIButton3 = this.topSendBtn;
                if (qUIButton3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("topSendBtn");
                } else {
                    qUIButton = qUIButton3;
                }
                qUIButton.setText(getContext().getString(R.string.a8j) + getContext().getString(R.string.f189263yx, Integer.valueOf(size)));
                return;
            }
            return;
        }
        QUIButton qUIButton4 = this.topSendBtn;
        if (qUIButton4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topSendBtn");
            qUIButton4 = null;
        }
        qUIButton4.setVisibility(8);
        if (z16) {
            QUIButton qUIButton5 = this.bottomSendBtn;
            if (qUIButton5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomSendBtn");
                qUIButton5 = null;
            }
            qUIButton5.setClickable(false);
            QUIButton qUIButton6 = this.bottomSendBtn;
            if (qUIButton6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomSendBtn");
                qUIButton6 = null;
            }
            qUIButton6.setBackgroundDisabled();
        } else {
            QUIButton qUIButton7 = this.bottomSendBtn;
            if (qUIButton7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomSendBtn");
                qUIButton7 = null;
            }
            qUIButton7.setClickable(true);
            QUIButton qUIButton8 = this.bottomSendBtn;
            if (qUIButton8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomSendBtn");
                qUIButton8 = null;
            }
            qUIButton8.o();
        }
        QUIButton qUIButton9 = this.bottomSendBtn;
        if (qUIButton9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomSendBtn");
        } else {
            qUIButton = qUIButton9;
        }
        if (z16) {
            str = getContext().getString(R.string.a8j);
        } else {
            str = getContext().getString(R.string.a8j) + getContext().getString(R.string.f189263yx, Integer.valueOf(size));
        }
        qUIButton.setText(str);
    }

    private final void initViewModel() {
        this.selectStatusObserver = new Observer() { // from class: com.tencent.biz.qqcircle.share.part.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSShareSelectMemberSenderPart.H9(QFSShareSelectMemberSenderPart.this, (UIStateData) obj);
            }
        };
        MutableLiveData<UIStateData<QFSCommentAtEntity>> M1 = D9().M1();
        Observer<UIStateData<QFSCommentAtEntity>> observer = this.selectStatusObserver;
        if (observer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectStatusObserver");
            observer = null;
        }
        M1.observeForever(observer);
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSShareSelectMemberSenderPart";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null) {
            num = Integer.valueOf(v3.getId());
        } else {
            num = null;
        }
        boolean z17 = false;
        if ((num != null && num.intValue() == R.id.f3481106) || (num != null && num.intValue() == R.id.f44171og)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            Activity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
        } else {
            if ((num != null && num.intValue() == R.id.f3630147) || (num != null && num.intValue() == R.id.f501424l)) {
                z17 = true;
            }
            if (z17) {
                K9();
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.f3481106);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.qfs_cancel_btn)");
        this.closeTv = (TextView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f44171og);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.qfs_iv_close)");
        this.closeIv = (ImageView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.f55572i_);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.qfs_title)");
        this.titleTv = (TextView) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.f3630147);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.qfs_confirm_btn)");
        this.topSendBtn = (QUIButton) findViewById4;
        View findViewById5 = rootView.findViewById(R.id.f501424l);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.id.qfs_publish_btn)");
        this.bottomSendBtn = (QUIButton) findViewById5;
        View findViewById6 = rootView.findViewById(R.id.f34610zm);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.\u2026.qfs_bottom_panel_layout)");
        this.bottomBtnLayout = (FrameLayout) findViewById6;
        ImageView imageView = this.closeIv;
        QUIButton qUIButton = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeIv");
            imageView = null;
        }
        imageView.setOnClickListener(this);
        TextView textView = this.closeTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeTv");
            textView = null;
        }
        textView.setOnClickListener(this);
        QUIButton qUIButton2 = this.topSendBtn;
        if (qUIButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topSendBtn");
            qUIButton2 = null;
        }
        qUIButton2.setOnClickListener(this);
        QUIButton qUIButton3 = this.bottomSendBtn;
        if (qUIButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomSendBtn");
        } else {
            qUIButton = qUIButton3;
        }
        qUIButton.setOnClickListener(this);
        G9();
        F9();
        initViewModel();
        E9();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        MutableLiveData<UIStateData<QFSCommentAtEntity>> M1 = D9().M1();
        Observer<UIStateData<QFSCommentAtEntity>> observer = this.selectStatusObserver;
        if (observer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectStatusObserver");
            observer = null;
        }
        M1.removeObserver(observer);
        this.shareCallbackResultReceiver = null;
        this.shareReportResultReceiver = null;
        this.selectedMemberResultReceiver = null;
    }
}
