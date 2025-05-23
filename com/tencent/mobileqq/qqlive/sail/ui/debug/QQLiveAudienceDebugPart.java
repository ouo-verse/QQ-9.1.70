package com.tencent.mobileqq.qqlive.sail.ui.debug;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.qqlive.sail.room.f;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Arrays;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import mqq.app.Constants;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b5\u00106J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u001c\u0010\u000f\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0014J\u0012\u0010\u0016\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016J\u0012\u0010\u0019\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0014H\u0016R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010 \u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010\"\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u001fR\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010,\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010)R\u0018\u00100\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010)R\u0018\u00102\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010)R\u0018\u00104\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010)\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/debug/QQLiveAudienceDebugPart;", "Lcom/tencent/mobileqq/qqlive/sail/base/c;", "Landroid/view/View$OnClickListener;", "", "ta", "ra", "Lcom/tencent/mobileqq/qqlive/sail/model/player/a;", CustomImageProps.QUALITY, "va", "ua", "wa", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "", "isPartEnable", "", "getInitRelyViewStubId", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "V9", "v", NodeProps.ON_CLICK, "Landroid/view/ViewGroup;", "e", "Landroid/view/ViewGroup;", "viewStub", "f", "Landroid/view/View;", "copyBtn", h.F, "closeBtn", "Lkotlinx/coroutines/Job;", "i", "Lkotlinx/coroutines/Job;", "refreshJob", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "roomInfoTextView", BdhLogUtil.LogTag.Tag_Conn, "videoUrlInfoTextView", "D", "videoDownloadSpeedTextView", "E", "playerInfoTextView", UserInfo.SEX_FEMALE, "watchInfoTextView", "G", "requestProtocolTextView", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveAudienceDebugPart extends com.tencent.mobileqq.qqlive.sail.base.c implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private TextView videoUrlInfoTextView;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private TextView videoDownloadSpeedTextView;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private TextView playerInfoTextView;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private TextView watchInfoTextView;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private TextView requestProtocolTextView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup viewStub;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View copyBtn;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View closeBtn;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Job refreshJob;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView roomInfoTextView;

    public QQLiveAudienceDebugPart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void ra() {
        Job launch$default;
        Job job = this.refreshJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null))), null, null, new QQLiveAudienceDebugPart$launchRefreshJob$1(this, null), 3, null);
        this.refreshJob = launch$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ta() {
        com.tencent.mobileqq.qqlive.sail.room.e eVar;
        TextView textView = this.roomInfoTextView;
        if (textView != null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("appId: " + QQLiveBusinessConfig.QQLIVE_APP_ID + "\n");
            sb5.append("\u89c2\u4f17Uid: " + M9() + "\n");
            sb5.append("roomId: " + H9() + "\n");
            sb5.append("roomType: " + J9() + "\n");
            sb5.append("\u4e3b\u64adUid: " + C9() + "\n");
            sb5.append("\u4e3b\u64adNick: " + B9() + "\n");
            textView.setText(sb5.toString());
        }
        f F9 = F9();
        com.tencent.mobileqq.qqlive.sail.model.player.a aVar = null;
        if (F9 instanceof com.tencent.mobileqq.qqlive.sail.room.e) {
            eVar = (com.tencent.mobileqq.qqlive.sail.room.e) F9;
        } else {
            eVar = null;
        }
        if (eVar != null) {
            aVar = eVar.getPlayerQuality();
        }
        if (aVar != null) {
            TextView textView2 = this.videoUrlInfoTextView;
            if (textView2 != null) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append("\u5c01\u88c5\u683c\u5f0f: " + aVar.c() + "\n");
                sb6.append("\u7f16\u7801\u683c\u5f0f: " + aVar.n() + "\n");
                sb6.append("\u7801\u7387: " + aVar.m() + "\n");
                sb6.append("\u5e27\u7387: " + aVar.o() + "\n");
                sb6.append("VideoSize: " + aVar.q() + HippyTKDListViewAdapter.X + aVar.p() + "\n");
                String l3 = aVar.l();
                StringBuilder sb7 = new StringBuilder();
                sb7.append("\u6d41\u5730\u5740: ");
                sb7.append(l3);
                sb7.append("\n");
                sb6.append(sb7.toString());
                textView2.setText(sb6.toString());
            }
            TextView textView3 = this.requestProtocolTextView;
            if (textView3 != null) {
                StringBuilder sb8 = new StringBuilder();
                sb8.append("\u7f51\u7edc\u8bf7\u6c42\u534f\u8bae: " + aVar.i() + "\n");
                textView3.setText(sb8.toString());
            }
            va(aVar);
            ua(aVar);
            wa(aVar);
            ra();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ua(com.tencent.mobileqq.qqlive.sail.model.player.a quality) {
        TextView textView;
        if (quality != null && (textView = this.playerInfoTextView) != null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("\u6d41\u5361\u987f\u6b21\u6570:" + quality.a() + ", \u5361\u987f\u603b\u65f6\u957f(ms):" + quality.b() + "\n");
            long d16 = quality.d();
            StringBuilder sb6 = new StringBuilder();
            sb6.append("\u9996\u5e27\u8017\u65f6(ms):");
            sb6.append(d16);
            sb6.append("\n");
            sb5.append(sb6.toString());
            textView.setText(sb5.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void va(com.tencent.mobileqq.qqlive.sail.model.player.a quality) {
        TextView textView;
        if (quality != null && (textView = this.videoDownloadSpeedTextView) != null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("\u7f13\u5b58\u901f\u5ea6(KB):" + quality.j());
            textView.setText(sb5.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void wa(com.tencent.mobileqq.qqlive.sail.model.player.a quality) {
        if (quality != null) {
            final long currentTimeMillis = System.currentTimeMillis() - quality.g();
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqlive.sail.ui.debug.d
                @Override // java.lang.Runnable
                public final void run() {
                    QQLiveAudienceDebugPart.xa(QQLiveAudienceDebugPart.this, currentTimeMillis);
                }
            }, 64, null, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xa(final QQLiveAudienceDebugPart this$0, final long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final long a16 = gl4.a.a(this$0.getContext());
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.sail.ui.debug.e
            @Override // java.lang.Runnable
            public final void run() {
                QQLiveAudienceDebugPart.za(QQLiveAudienceDebugPart.this, j3, a16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void za(QQLiveAudienceDebugPart this$0, long j3, long j16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = this$0.watchInfoTextView;
        if (textView != null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("\u89c2\u770b\u65f6\u957f(s):" + (j3 / 1000) + "\n");
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%dM", Arrays.copyOf(new Object[]{Long.valueOf(j16)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            sb5.append("\u5185\u5b58:" + format);
            textView.setText(sb5.toString());
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void V9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.V9();
        Job job = this.refreshJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.Part
    public int getInitRelyViewStubId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return R.id.f60032ub;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean isPartEnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        CharSequence charSequence;
        CharSequence charSequence2;
        CharSequence charSequence3;
        CharSequence charSequence4;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) v3);
        } else {
            CharSequence charSequence5 = null;
            if (v3 != null) {
                num = Integer.valueOf(v3.getId());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == R.id.uez) {
                ViewGroup viewGroup = this.viewStub;
                if (viewGroup != null) {
                    viewGroup.setVisibility(8);
                }
            } else if (num != null && num.intValue() == R.id.f164954uf0) {
                TextView textView = this.roomInfoTextView;
                if (textView != null) {
                    charSequence = textView.getText();
                } else {
                    charSequence = null;
                }
                TextView textView2 = this.videoUrlInfoTextView;
                if (textView2 != null) {
                    charSequence2 = textView2.getText();
                } else {
                    charSequence2 = null;
                }
                TextView textView3 = this.videoDownloadSpeedTextView;
                if (textView3 != null) {
                    charSequence3 = textView3.getText();
                } else {
                    charSequence3 = null;
                }
                TextView textView4 = this.playerInfoTextView;
                if (textView4 != null) {
                    charSequence4 = textView4.getText();
                } else {
                    charSequence4 = null;
                }
                TextView textView5 = this.watchInfoTextView;
                if (textView5 != null) {
                    charSequence5 = textView5.getText();
                }
                com.tencent.timi.game.utils.a.a(getContext(), ((Object) charSequence) + "\n" + ((Object) charSequence2) + "\n" + ((Object) charSequence3) + "\n" + ((Object) charSequence4) + "\n" + ((Object) charSequence5));
                QQToast.makeText(getContext(), "\u590d\u5236\u6210\u529f", 0, 0).show();
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        ViewGroup viewGroup;
        View view;
        View view2;
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        TextView textView6 = null;
        if (rootView != null) {
            viewGroup = (ViewGroup) rootView.findViewById(R.id.f60032ub);
        } else {
            viewGroup = null;
        }
        this.viewStub = viewGroup;
        if (rootView != null) {
            view = rootView.findViewById(R.id.f164954uf0);
        } else {
            view = null;
        }
        this.copyBtn = view;
        if (rootView != null) {
            view2 = rootView.findViewById(R.id.uez);
        } else {
            view2 = null;
        }
        this.closeBtn = view2;
        View view3 = this.copyBtn;
        if (view3 != null) {
            view3.setOnClickListener(this);
        }
        View view4 = this.closeBtn;
        if (view4 != null) {
            view4.setOnClickListener(this);
        }
        if (rootView != null) {
            textView = (TextView) rootView.findViewById(R.id.f7809465);
        } else {
            textView = null;
        }
        this.roomInfoTextView = textView;
        if (rootView != null) {
            textView2 = (TextView) rootView.findViewById(R.id.f11803732);
        } else {
            textView2 = null;
        }
        this.videoUrlInfoTextView = textView2;
        if (rootView != null) {
            textView3 = (TextView) rootView.findViewById(R.id.f1173971b);
        } else {
            textView3 = null;
        }
        this.videoDownloadSpeedTextView = textView3;
        if (rootView != null) {
            textView4 = (TextView) rootView.findViewById(R.id.f25860bz);
        } else {
            textView4 = null;
        }
        this.playerInfoTextView = textView4;
        if (rootView != null) {
            textView5 = (TextView) rootView.findViewById(R.id.f120667_6);
        } else {
            textView5 = null;
        }
        this.watchInfoTextView = textView5;
        if (rootView != null) {
            textView6 = (TextView) rootView.findViewById(R.id.f28740jr);
        }
        this.requestProtocolTextView = textView6;
        ta();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        super.onPartCreate(activity, savedInstanceState);
        MutableLiveData<Boolean> L1 = ((a) getViewModel(a.class)).L1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.debug.QQLiveAudienceDebugPart$onPartCreate$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveAudienceDebugPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                ViewGroup viewGroup;
                Job job;
                ViewGroup viewGroup2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (!it.booleanValue()) {
                    viewGroup = QQLiveAudienceDebugPart.this.viewStub;
                    if (viewGroup != null) {
                        viewGroup.setVisibility(8);
                    }
                    job = QQLiveAudienceDebugPart.this.refreshJob;
                    if (job != null) {
                        Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                        return;
                    }
                    return;
                }
                QQLiveAudienceDebugPart.this.startInit();
                viewGroup2 = QQLiveAudienceDebugPart.this.viewStub;
                if (viewGroup2 != null) {
                    viewGroup2.setVisibility(0);
                }
                QQLiveAudienceDebugPart.this.ta();
            }
        };
        L1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.debug.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveAudienceDebugPart.sa(Function1.this, obj);
            }
        });
    }
}
