package com.tencent.mobileqq.qqlive.room.prepare.rtmp;

import android.app.Activity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.base.QQLiveBaseFragment;
import com.tencent.mobileqq.qqlive.room.livelabel.LabelModel;
import com.tencent.mobileqq.qqlive.room.livelabel.SelectLabelDialog;
import com.tencent.mobileqq.qqlive.sso.request.QQLiveSetAnchorLabelRequest;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 52\u00020\u00012\u00020\u0002:\u000267B\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u00a2\u0006\u0004\b3\u00104J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0012\u0010\u000f\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u0010\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u001fR\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/prepare/rtmp/QQLiveRtmpPrepareLabelsPart;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View$OnClickListener;", "", "B9", "E9", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "v", NodeProps.ON_CLICK, "onPartDestroy", "Lcom/tencent/mobileqq/qqlive/base/QQLiveBaseFragment;", "d", "Lcom/tencent/mobileqq/qqlive/base/QQLiveBaseFragment;", "hostFragment", "Lcom/tencent/mobileqq/qqlive/room/prepare/rtmp/QQLiveRtmpPrepareLabelsPart$b;", "e", "Lcom/tencent/mobileqq/qqlive/room/prepare/rtmp/QQLiveRtmpPrepareLabelsPart$b;", "labelPartAdapter", "Landroid/widget/RelativeLayout;", "f", "Landroid/widget/RelativeLayout;", "gameSelectorLayout", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "gameItemTextView", "i", "changeLabelTv", "Lcom/tencent/mobileqq/qqlive/room/prepare/k;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/qqlive/room/prepare/k;", "viewModel", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "aegisLog", "Lcom/tencent/mobileqq/qqlive/room/livelabel/SelectLabelDialog;", "D", "Lcom/tencent/mobileqq/qqlive/room/livelabel/SelectLabelDialog;", "selectLabelsDialog", "Lcom/tencent/mobileqq/qqlive/room/livelabel/SelectLabelDialog$b;", "E", "Lcom/tencent/mobileqq/qqlive/room/livelabel/SelectLabelDialog$b;", "selectLabelDialogDismissListener", "<init>", "(Lcom/tencent/mobileqq/qqlive/base/QQLiveBaseFragment;Lcom/tencent/mobileqq/qqlive/room/prepare/rtmp/QQLiveRtmpPrepareLabelsPart$b;)V", UserInfo.SEX_FEMALE, "a", "b", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveRtmpPrepareLabelsPart extends Part implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final IAegisLogApi aegisLog;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private SelectLabelDialog selectLabelsDialog;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private SelectLabelDialog.b selectLabelDialogDismissListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QQLiveBaseFragment hostFragment;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b labelPartAdapter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RelativeLayout gameSelectorLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView gameItemTextView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView changeLabelTv;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qqlive.room.prepare.k viewModel;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/prepare/rtmp/QQLiveRtmpPrepareLabelsPart$a;", "", "", "DIALOG_TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.room.prepare.rtmp.QQLiveRtmpPrepareLabelsPart$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
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

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/prepare/rtmp/QQLiveRtmpPrepareLabelsPart$b;", "", "", "c", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public interface b {
        long c();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45833);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQLiveRtmpPrepareLabelsPart(@NotNull QQLiveBaseFragment hostFragment, @NotNull b labelPartAdapter) {
        Intrinsics.checkNotNullParameter(hostFragment, "hostFragment");
        Intrinsics.checkNotNullParameter(labelPartAdapter, "labelPartAdapter");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) hostFragment, (Object) labelPartAdapter);
            return;
        }
        this.hostFragment = hostFragment;
        this.labelPartAdapter = labelPartAdapter;
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.aegisLog = (IAegisLogApi) api;
    }

    private final void B9() {
        SelectLabelDialog selectLabelDialog;
        LabelModel labelModel;
        MutableLiveData<LabelModel> mutableLiveData;
        if (this.selectLabelsDialog == null) {
            this.selectLabelsDialog = new SelectLabelDialog(10L);
            SelectLabelDialog.b bVar = new SelectLabelDialog.b() { // from class: com.tencent.mobileqq.qqlive.room.prepare.rtmp.n
                @Override // com.tencent.mobileqq.qqlive.room.livelabel.SelectLabelDialog.b
                public final void a(LabelModel labelModel2) {
                    QQLiveRtmpPrepareLabelsPart.C9(QQLiveRtmpPrepareLabelsPart.this, labelModel2);
                }
            };
            this.selectLabelDialogDismissListener = bVar;
            SelectLabelDialog selectLabelDialog2 = this.selectLabelsDialog;
            if (selectLabelDialog2 != null) {
                selectLabelDialog2.Ch(bVar);
            }
        }
        SelectLabelDialog selectLabelDialog3 = this.selectLabelsDialog;
        Intrinsics.checkNotNull(selectLabelDialog3);
        if (!selectLabelDialog3.isVisible() && (selectLabelDialog = this.selectLabelsDialog) != null) {
            com.tencent.mobileqq.qqlive.room.prepare.k kVar = this.viewModel;
            if (kVar != null && (mutableLiveData = kVar.Q) != null) {
                labelModel = mutableLiveData.getValue();
            } else {
                labelModel = null;
            }
            selectLabelDialog.Bh(labelModel);
            selectLabelDialog.show(this.hostFragment.getParentFragmentManager(), "SelectLabelDialog");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C9(QQLiveRtmpPrepareLabelsPart this$0, LabelModel labelModel) {
        MutableLiveData<LabelModel> mutableLiveData;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (labelModel == null) {
            return;
        }
        com.tencent.mobileqq.qqlive.room.prepare.k kVar = this$0.viewModel;
        if (kVar != null) {
            mutableLiveData = kVar.Q;
        } else {
            mutableLiveData = null;
        }
        if (mutableLiveData != null) {
            mutableLiveData.setValue(labelModel);
        }
        this$0.E9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E9() {
        LabelModel labelModel;
        LabelModel labelModel2;
        LabelModel labelModel3;
        long j3;
        MutableLiveData<LabelModel> mutableLiveData;
        LabelModel value;
        MutableLiveData<LabelModel> mutableLiveData2;
        String string;
        MutableLiveData<LabelModel> mutableLiveData3;
        LabelModel value2;
        MutableLiveData<LabelModel> mutableLiveData4;
        MutableLiveData<LabelModel> mutableLiveData5;
        IAegisLogApi iAegisLogApi = this.aegisLog;
        String tag = getTAG();
        com.tencent.mobileqq.qqlive.room.prepare.k kVar = this.viewModel;
        if (kVar != null && (mutableLiveData5 = kVar.Q) != null) {
            labelModel = mutableLiveData5.getValue();
        } else {
            labelModel = null;
        }
        iAegisLogApi.i(tag, "setSelectGameLabelView mLastSelectLabel=" + labelModel);
        com.tencent.mobileqq.qqlive.room.prepare.k kVar2 = this.viewModel;
        if (kVar2 != null && (mutableLiveData4 = kVar2.Q) != null) {
            labelModel2 = mutableLiveData4.getValue();
        } else {
            labelModel2 = null;
        }
        if (labelModel2 == null) {
            TextView textView = this.gameItemTextView;
            if (textView != null) {
                textView.setText(getActivity().getResources().getString(R.string.f210725iw));
            }
            TextView textView2 = this.changeLabelTv;
            if (textView2 != null) {
                textView2.setText(getActivity().getResources().getString(R.string.f210735ix));
                return;
            }
            return;
        }
        TextView textView3 = this.gameItemTextView;
        if (textView3 != null) {
            com.tencent.mobileqq.qqlive.room.prepare.k kVar3 = this.viewModel;
            if (kVar3 == null || (mutableLiveData3 = kVar3.Q) == null || (value2 = mutableLiveData3.getValue()) == null || (string = value2.title) == null) {
                string = getActivity().getResources().getString(R.string.f210725iw);
            }
            textView3.setText(string);
        }
        TextView textView4 = this.changeLabelTv;
        if (textView4 != null) {
            textView4.setText(getActivity().getResources().getString(R.string.f210715iv));
        }
        com.tencent.mobileqq.qqlive.room.prepare.k kVar4 = this.viewModel;
        if (kVar4 != null && (mutableLiveData2 = kVar4.Q) != null) {
            labelModel3 = mutableLiveData2.getValue();
        } else {
            labelModel3 = null;
        }
        com.tencent.mobileqq.qqlive.room.livelabel.e.c(labelModel3);
        long c16 = this.labelPartAdapter.c();
        com.tencent.mobileqq.qqlive.room.prepare.k kVar5 = this.viewModel;
        if (kVar5 != null && (mutableLiveData = kVar5.Q) != null && (value = mutableLiveData.getValue()) != null) {
            j3 = value.thirdLabelId;
        } else {
            j3 = 0;
        }
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new QQLiveSetAnchorLabelRequest(c16, j3), null);
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "QQLiveRtmpPrepareLabelsPart";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) v3);
        } else {
            if (v3 != null) {
                num = Integer.valueOf(v3.getId());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == R.id.f60912wp) {
                B9();
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        RelativeLayout relativeLayout;
        TextView textView;
        MutableLiveData<LabelModel> mutableLiveData;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        TextView textView2 = null;
        if (rootView != null) {
            relativeLayout = (RelativeLayout) rootView.findViewById(R.id.f60912wp);
        } else {
            relativeLayout = null;
        }
        this.gameSelectorLayout = relativeLayout;
        if (rootView != null) {
            textView = (TextView) rootView.findViewById(R.id.f60892wn);
        } else {
            textView = null;
        }
        this.gameItemTextView = textView;
        if (rootView != null) {
            textView2 = (TextView) rootView.findViewById(R.id.tri);
        }
        this.changeLabelTv = textView2;
        RelativeLayout relativeLayout2 = this.gameSelectorLayout;
        if (relativeLayout2 != null) {
            relativeLayout2.setOnClickListener(this);
        }
        com.tencent.mobileqq.qqlive.room.prepare.k kVar = (com.tencent.mobileqq.qqlive.room.prepare.k) new ViewModelProvider(this.hostFragment, com.tencent.mobileqq.qqlive.room.prepare.k.U).get(com.tencent.mobileqq.qqlive.room.prepare.k.class);
        this.viewModel = kVar;
        if (kVar != null && (mutableLiveData = kVar.Q) != null) {
            QQLiveBaseFragment qQLiveBaseFragment = this.hostFragment;
            final Function1<LabelModel, Unit> function1 = new Function1<LabelModel, Unit>() { // from class: com.tencent.mobileqq.qqlive.room.prepare.rtmp.QQLiveRtmpPrepareLabelsPart$onInitView$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveRtmpPrepareLabelsPart.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(LabelModel labelModel) {
                    invoke2(labelModel);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(LabelModel labelModel) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        QQLiveRtmpPrepareLabelsPart.this.E9();
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) labelModel);
                    }
                }
            };
            mutableLiveData.observe(qQLiveBaseFragment, new Observer() { // from class: com.tencent.mobileqq.qqlive.room.prepare.rtmp.o
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QQLiveRtmpPrepareLabelsPart.D9(Function1.this, obj);
                }
            });
        }
        com.tencent.mobileqq.qqlive.room.prepare.f.a(this.gameSelectorLayout, "em_qqlive_content_choice", new HashMap());
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
            return;
        }
        super.onPartDestroy(activity);
        this.viewModel = null;
        this.selectLabelDialogDismissListener = null;
        SelectLabelDialog selectLabelDialog = this.selectLabelsDialog;
        if (selectLabelDialog != null) {
            selectLabelDialog.Ch(null);
        }
        SelectLabelDialog selectLabelDialog2 = this.selectLabelsDialog;
        if (selectLabelDialog2 != null) {
            selectLabelDialog2.dismissAllowingStateLoss();
        }
        this.selectLabelsDialog = null;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@NotNull Activity activity) {
        LabelModel labelModel;
        MutableLiveData<LabelModel> mutableLiveData;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartResume(activity);
        com.tencent.mobileqq.qqlive.room.prepare.k kVar = this.viewModel;
        if (kVar != null && (mutableLiveData = kVar.Q) != null) {
            labelModel = mutableLiveData.getValue();
        } else {
            labelModel = null;
        }
        if (labelModel != null) {
            E9();
        }
    }
}
