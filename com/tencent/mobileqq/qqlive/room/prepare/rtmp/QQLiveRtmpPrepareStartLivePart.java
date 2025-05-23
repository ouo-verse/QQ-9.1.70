package com.tencent.mobileqq.qqlive.room.prepare.rtmp;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001'B\u0011\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\u0012\u0010\u000e\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u0010\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\fH\u0016R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/prepare/rtmp/QQLiveRtmpPrepareStartLivePart;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View$OnClickListener;", "", "E9", "", "D9", "", "enable", "H9", "I9", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "v", NodeProps.ON_CLICK, "Lcom/tencent/mobileqq/qqlive/room/prepare/rtmp/QQLiveRtmpPrepareStartLivePart$a;", "d", "Lcom/tencent/mobileqq/qqlive/room/prepare/rtmp/QQLiveRtmpPrepareStartLivePart$a;", "startLiveAdapter", "Landroid/widget/Button;", "e", "Landroid/widget/Button;", "startToLiveButton", "Landroid/widget/CheckBox;", "f", "Landroid/widget/CheckBox;", "protocolCheckBox", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "protocolTextView", "Lcom/tencent/mobileqq/qqlive/room/prepare/k;", "i", "Lcom/tencent/mobileqq/qqlive/room/prepare/k;", "viewModel", "<init>", "(Lcom/tencent/mobileqq/qqlive/room/prepare/rtmp/QQLiveRtmpPrepareStartLivePart$a;)V", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveRtmpPrepareStartLivePart extends Part implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final a startLiveAdapter;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Button startToLiveButton;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CheckBox protocolCheckBox;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView protocolTextView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qqlive.room.prepare.k viewModel;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/prepare/rtmp/QQLiveRtmpPrepareStartLivePart$a;", "", "Landroid/view/View;", "v", "", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public interface a {
        void a(@NotNull View v3);
    }

    public QQLiveRtmpPrepareStartLivePart(@Nullable a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        } else {
            this.startLiveAdapter = aVar;
        }
    }

    private final String D9() {
        return ht3.a.d("qqlive_open_live_protocol_url", "https://qlive.qq.com/cos/live/h5/policys/index.html?_wv=2");
    }

    private final void E9() {
        Intent intent = new Intent(getActivity(), (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", D9());
        getActivity().startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(QQLiveRtmpPrepareStartLivePart this$0, CompoundButton compoundButton, boolean z16) {
        MutableLiveData<Boolean> mutableLiveData;
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.qqlive.room.prepare.k kVar = this$0.viewModel;
        com.tencent.mobileqq.qqlive.room.prepare.g gVar = null;
        if (kVar != null) {
            mutableLiveData = kVar.H;
        } else {
            mutableLiveData = null;
        }
        if (mutableLiveData != null) {
            mutableLiveData.setValue(Boolean.valueOf(z16));
        }
        com.tencent.mobileqq.qqlive.room.prepare.k kVar2 = this$0.viewModel;
        if (kVar2 != null) {
            gVar = kVar2.getRepository();
        }
        if (gVar != null) {
            gVar.o(z16);
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H9(boolean enable) {
        CheckBox checkBox = this.protocolCheckBox;
        if (checkBox != null) {
            checkBox.setChecked(enable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I9(boolean enable) {
        Button button = this.startToLiveButton;
        if (button != null) {
            button.setEnabled(enable);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "QQLiveRtmpPrepareStartLivePart";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) v3);
        } else {
            if (v3 != null) {
                num = Integer.valueOf(v3.getId());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == R.id.f60922wq) {
                a aVar = this.startLiveAdapter;
                if (aVar != null) {
                    aVar.a(v3);
                }
            } else if (num != null && num.intValue() == R.id.f60872wl) {
                E9();
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        Button button;
        CheckBox checkBox;
        MutableLiveData<Boolean> mutableLiveData;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        TextView textView = null;
        if (rootView != null) {
            button = (Button) rootView.findViewById(R.id.f60922wq);
        } else {
            button = null;
        }
        this.startToLiveButton = button;
        if (rootView != null) {
            checkBox = (CheckBox) rootView.findViewById(R.id.f60852wj);
        } else {
            checkBox = null;
        }
        this.protocolCheckBox = checkBox;
        if (rootView != null) {
            textView = (TextView) rootView.findViewById(R.id.f60872wl);
        }
        this.protocolTextView = textView;
        Button button2 = this.startToLiveButton;
        if (button2 != null) {
            button2.setOnClickListener(this);
        }
        TextView textView2 = this.protocolTextView;
        if (textView2 != null) {
            textView2.setOnClickListener(this);
        }
        CheckBox checkBox2 = this.protocolCheckBox;
        if (checkBox2 != null) {
            checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.qqlive.room.prepare.rtmp.y
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                    QQLiveRtmpPrepareStartLivePart.F9(QQLiveRtmpPrepareStartLivePart.this, compoundButton, z16);
                }
            });
        }
        com.tencent.mobileqq.qqlive.room.prepare.k kVar = (com.tencent.mobileqq.qqlive.room.prepare.k) new ViewModelProvider(getHostFragment(), com.tencent.mobileqq.qqlive.room.prepare.k.U).get(com.tencent.mobileqq.qqlive.room.prepare.k.class);
        this.viewModel = kVar;
        if (kVar != null && (mutableLiveData = kVar.H) != null) {
            Fragment hostFragment = getHostFragment();
            final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.qqlive.room.prepare.rtmp.QQLiveRtmpPrepareStartLivePart$onInitView$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveRtmpPrepareStartLivePart.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke2(bool);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Boolean it) {
                    com.tencent.mobileqq.qqlive.room.prepare.k kVar2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                        return;
                    }
                    QQLiveRtmpPrepareStartLivePart qQLiveRtmpPrepareStartLivePart = QQLiveRtmpPrepareStartLivePart.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    qQLiveRtmpPrepareStartLivePart.H9(it.booleanValue());
                    QQLiveRtmpPrepareStartLivePart qQLiveRtmpPrepareStartLivePart2 = QQLiveRtmpPrepareStartLivePart.this;
                    kVar2 = qQLiveRtmpPrepareStartLivePart2.viewModel;
                    Intrinsics.checkNotNull(kVar2);
                    qQLiveRtmpPrepareStartLivePart2.I9(kVar2.f271955m && it.booleanValue());
                }
            };
            mutableLiveData.observe(hostFragment, new Observer() { // from class: com.tencent.mobileqq.qqlive.room.prepare.rtmp.z
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QQLiveRtmpPrepareStartLivePart.G9(Function1.this, obj);
                }
            });
        }
        HashMap hashMap = new HashMap();
        com.tencent.mobileqq.qqlive.room.prepare.f.a(this.startToLiveButton, "em_qqlive_live_start", hashMap);
        com.tencent.mobileqq.qqlive.room.prepare.f.a(this.protocolCheckBox, "em_qqlive_protocol", hashMap);
    }
}
